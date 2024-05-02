/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VopFcm9999Event.java
*@FileTitle : VopFcm9999Event
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.04
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2011.10.04 유혁
* 1.0 Creation
* 
* 2015.04.30 이병훈 [CHM-201534057] Split09-2015년 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.trendline.trendline.event;

import com.hanjin.apps.alps.vop.fcm.trendline.trendline.vo.FcmTrndLineVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.FcmNoonRptVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * VOP_FCM_0012 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_FCM_0012HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ryu Hyuk
 * @see VOP_FCM_0012HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopFcm0012Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private FcmTrndLineVO fcmTrndLineVO = null;
	/** Table Value Object Multi Data 처리 */
	private FcmTrndLineVO[] fcmTrndLineVOs = null;
	private FcmNoonRptVO[] fcmNoonRptVOs = null;
	
	private String vslClssCd = null;
	
	public VopFcm0012Event(){}
	
	public void setFcmTrndLineVO(FcmTrndLineVO fcmTrndLineVO){
		this.fcmTrndLineVO = fcmTrndLineVO;
	}

	public FcmTrndLineVO getFcmTrndLineVO(){
		return fcmTrndLineVO;
	}

	public FcmTrndLineVO[] getFcmTrndLineVOs() {
//		return fcmTrndLineVOs;
		FcmTrndLineVO[] rtnVOs = null;
		if (this.fcmTrndLineVOs != null) {
			rtnVOs = new FcmTrndLineVO[fcmTrndLineVOs.length];
			System.arraycopy(fcmTrndLineVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setFcmTrndLineVOs(FcmTrndLineVO[] fcmTrndLineVOs) {
//		this.fcmTrndLineVOs = fcmTrndLineVOs;
		if (fcmTrndLineVOs != null) {
			FcmTrndLineVO[] tmpVOs = new FcmTrndLineVO[fcmTrndLineVOs.length];
			System.arraycopy(fcmTrndLineVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.fcmTrndLineVOs = tmpVOs;
		}
	}

	public FcmNoonRptVO[] getFcmNoonRptVOs() {
//		return fcmNoonRptVOs;
		FcmNoonRptVO[] rtnVOs = null;
		if (this.fcmNoonRptVOs != null) {
			rtnVOs = new FcmNoonRptVO[fcmNoonRptVOs.length];
			System.arraycopy(fcmNoonRptVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setFcmNoonRptVOs(FcmNoonRptVO[] fcmNoonRptVOs) {
//		this.fcmNoonRptVOs = fcmNoonRptVOs;
		if (fcmNoonRptVOs != null) {
			FcmNoonRptVO[] tmpVOs = new FcmNoonRptVO[fcmNoonRptVOs.length];
			System.arraycopy(fcmNoonRptVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.fcmNoonRptVOs = tmpVOs;
		}
	}

	public String getVslClssCd() {
		return vslClssCd;
	}

	public void setVslClssCd(String vslClssCd) {
		this.vslClssCd = vslClssCd;
	}
}