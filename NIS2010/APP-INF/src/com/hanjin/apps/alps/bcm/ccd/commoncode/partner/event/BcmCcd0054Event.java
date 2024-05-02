package com.hanjin.apps.alps.bcm.ccd.commoncode.partner.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.VendorVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.layer.event.EventSupport;

public class BcmCcd0054Event extends EventSupport {

	private VendorVO mdmVendorVO = null;
	int 	iPage = 0;

	/**
     * BCM_CCD_0054HTMLAction 객체를 생성
     */
	public BcmCcd0054Event(){
	}
	
	public String getEventName() {
		return "BcmCcd0054Event";
	}
	
	public String toString() {
		return "BcmCcd0054Event";
	}

	public VendorVO getMdmVendorVO() {
		return mdmVendorVO;
	}

	public void setMdmVendorVO(VendorVO mdmVendorVO) {
		this.mdmVendorVO = mdmVendorVO;
	}

	public int getiPage() {
		return iPage;
	}

	public void setiPage(int iPage) {
		this.iPage = iPage;
	}

}
