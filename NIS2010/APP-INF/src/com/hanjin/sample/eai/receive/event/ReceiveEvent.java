package com.hanjin.sample.eai.receive.event;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgWebServiceVO;
import com.hanjin.framework.support.layer.event.EventSupport;

public class ReceiveEvent extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String msg;
	private String commit;
	private BkgWebServiceVO bkgWebServiceVO;
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCommit() {
		return commit;
	}

	public void setCommit(String commit) {
		this.commit = commit;
	}

	public BkgWebServiceVO getBkgWebServiceVO() {
		return bkgWebServiceVO;
	}

	public void setBkgWebServiceVO(BkgWebServiceVO bkgWebServiceVO) {
		this.bkgWebServiceVO = bkgWebServiceVO;
	}
	
}