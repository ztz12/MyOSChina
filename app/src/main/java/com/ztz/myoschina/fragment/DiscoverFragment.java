package com.ztz.myoschina.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.ztz.myoschina.R;
import com.ztz.myoschina.activity.ShakeActivity;

/**
 * Created by wqewqe on 2017/5/11.
 */

public class DiscoverFragment extends Fragment {
    Button btnRecommend,btnProgramme,btnScan,btnShake;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_discover,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnRecommend=(Button)view.findViewById(R.id.btn_recommend);
        btnProgramme=(Button)view.findViewById(R.id.btn_programme);
        btnScan=(Button)view.findViewById(R.id.btn_scan);
        btnShake=(Button)view.findViewById(R.id.btn_shake);
        btnShake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), ShakeActivity.class);
                startActivity(intent);
            }
        });
      btnScan.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
             takePhoto();
          }
      });
//        if(ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
//            ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
//        }else {
//            takePhoto();
//        }
    }
    private void takePhoto(){
        Intent intent=new Intent(getContext(), CaptureActivity.class);
        startActivityForResult(intent,1);
    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        switch (requestCode){
//            case 1:
//                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
//                    takePhoto();
//                }else {
//                    Toast.makeText(getActivity(), "用户拒绝", Toast.LENGTH_SHORT).show();
//                }
//        }
//    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (data != null) {
                    Bundle bundle = data.getExtras();
                    if (bundle == null) {
                        return;
                    }
                    if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                        String result = bundle.getString(CodeUtils.RESULT_STRING);
                        Toast.makeText(getActivity(), "解析结果:" + result, Toast.LENGTH_LONG).show();
                    } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                        Toast.makeText(getActivity(), "解析二维码失败", Toast.LENGTH_LONG).show();
                    }
                    break;
                }
        }
    }
}
