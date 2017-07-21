package com.ztz.myoschina.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.ztz.myoschina.R;
import com.ztz.myoschina.fragment.ImageDetailFragment;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ImagePagerActivity extends BaseActivity {
    public static final String IMAGE_URL = "image_url";
    public static final String IMAGE_INDEX = "image_index";
    @BindView(R.id.tv_number)
    TextView tvNumber;
    @BindView(R.id.vp_pager)
    ViewPager vpPager;
    private List<String> urls;
    int currIndex=0;
    private static String filePath;
    private static Bitmap mBitmap;
    private static String mFileName="";
    private static String mSaveMessage;
    private static final String TAG = "ImagePagerActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_pager);
        ButterKnife.bind(this);
        initViews();
    }

    private void initViews() {
        urls = getIntent().getStringArrayListExtra(IMAGE_URL);
        int index = getIntent().getIntExtra(IMAGE_INDEX, 0);
        tvNumber.setText((index + 1) + "/" + urls.size());
        ImageViewAdapter adapter = new ImageViewAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapter);
        vpPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                currIndex=position;
                tvNumber.setText((position + 1) + "/" + urls.size());
            }
        });
        //设置当前viewpager位置
        vpPager.setCurrentItem(index);
    }

    @OnClick(R.id.iv_download)
    public void onViewClicked() {
        //将图片保存到本地
        String filePath=urls.get(currIndex);
        downLoad(filePath);
    }

    private void downLoad(String filePath) {
        this.filePath = filePath;
        showDialog("图片正在保存...");

        new Thread(saveFileRunnable).start();
    }
    private Runnable saveFileRunnable = new Runnable(){
        @Override
        public void run() {
            try {
                byte[] data = getImage(filePath);
                if(data!=null){
                    mBitmap = BitmapFactory.decodeByteArray(data, 0, data.length);// bitmap
                }else{
                    Toast.makeText(ImagePagerActivity.this, "Image error!", Toast.LENGTH_LONG).show();
                }
                saveFile(mBitmap, mFileName);
                mSaveMessage = "图片保存成功！";
            } catch (IOException e) {
                mSaveMessage = "图片保存失败！";
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            messageHandler.sendMessage(messageHandler.obtainMessage());
        }

    };
    private Handler messageHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            closeDialog();
            Log.d(TAG, mSaveMessage);
            Toast.makeText(ImagePagerActivity.this, mSaveMessage, Toast.LENGTH_SHORT).show();
        }
    };
    public  byte[] getImage(String path) throws Exception {
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5 * 1000);
        conn.setRequestMethod("GET");
        InputStream inStream = conn.getInputStream();
        if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){
            return readStream(inStream);
        }
        return null;
    }

    /**
     * 取得的是byte数组, 从byte数组生成bitmap
     * @param inStream
     * @return
     * @throws Exception
     */
    public byte[] readStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while( (len=inStream.read(buffer)) != -1){
            outStream.write(buffer, 0, len);
        }
        outStream.close();
        inStream.close();
        return outStream.toByteArray();
    }
    public  void saveFile(Bitmap bm, String fileName) throws IOException {
        File dirFile = new File(Environment.getExternalStorageDirectory().getPath());
        if(!dirFile.exists()){
            dirFile.mkdir();
        }
        fileName = UUID.randomUUID().toString()+".jpg";
        File jia=new File(Environment.getExternalStorageDirectory().getPath() +"/DCIM/VIMI8");
        if(!jia.exists()){   //判断文件夹是否存在，不存在则创建
            jia.mkdirs();
        }
        File myCaptureFile = new File(jia +"/"+ fileName);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(myCaptureFile));
        bm.compress(Bitmap.CompressFormat.JPEG, 80, bos);
        bos.flush();
        bos.close();

        //把图片保存后声明这个广播事件通知系统相册有新图片到来
        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        Uri uri = Uri.fromFile(myCaptureFile);
        intent.setData(uri);
        //发送系统全局广播
        sendBroadcast(intent);
    }
    public class ImageViewAdapter extends FragmentPagerAdapter {

        public ImageViewAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ImageDetailFragment.getInstance(urls.get(position));
        }

        @Override
        public int getCount() {
            return urls.size();
        }
    }
}
