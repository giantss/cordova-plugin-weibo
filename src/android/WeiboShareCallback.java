package com.giants.weibo;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.sina.weibo.sdk.api.share.BaseResponse;
import com.sina.weibo.sdk.api.share.IWeiboHandler;
import com.sina.weibo.sdk.api.share.WeiboShareSDK;
import com.sina.weibo.sdk.constant.WBConstants;

public class WeiboShareCallback extends Activity implements IWeiboHandler.Response {

	private static final String CANCEL_BY_USER ="cancel by user";
	private static final String SHARE_FAIL ="sharefail";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Weibo.mWeiboShareAPI = WeiboShareSDK.createWeiboAPI(this,Weibo.APP_KEY);
		Weibo.mWeiboShareAPI.registerApp();
        Weibo.mWeiboShareAPI.handleWeiboResponse(getIntent(), this);
	}

	@Override
	public void onResponse(BaseResponse baseResp) {
		switch (baseResp.errCode) {
		case WBConstants.ErrorCode.ERR_OK:
			Weibo.currentCallbackContext.success();
			break;
		case WBConstants.ErrorCode.ERR_CANCEL:
			Weibo.currentCallbackContext.error(CANCEL_BY_USER);
			break;
		case WBConstants.ErrorCode.ERR_FAIL:
			Weibo.currentCallbackContext.error(SHARE_FAIL);
			break;
		}
		this.finish();
	}

	@Override
	public void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		Weibo.mWeiboShareAPI.handleWeiboResponse(intent, this);
	}

}
