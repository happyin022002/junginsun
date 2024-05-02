/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VopFcm0083Event.java
*@FileTitle : VopFcm0083Event
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.00
*@LastModifier : 이병훈
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.setup.setup.event;

import com.hanjin.apps.alps.vop.fcm.setup.setup.vo.FcmDepRptErrRtVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * VOP_FCM_0083 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_FCM_0083HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see VOP_FCM_0083HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopFcm0083Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private FcmDepRptErrRtVO fcmDepRptErrRtVO = null;
	private FcmDepRptErrRtVO[] fcmDepRptErrRtVOs = null;
	
	private String vslCd = null;

	public VopFcm0083Event(){}

	public FcmDepRptErrRtVO[] getFcmDepRptErrRtVOs() {
		FcmDepRptErrRtVO[] rtnVOs = null;
		if (this.fcmDepRptErrRtVOs != null) {
			rtnVOs = new FcmDepRptErrRtVO[fcmDepRptErrRtVOs.length];
			System.arraycopy(fcmDepRptErrRtVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setFcmDepRptErrRtVOs(FcmDepRptErrRtVO[] fcmDepRptErrRtVOs) {
//		this.fcmVslCntrRgstVOs = fcmVslCntrRgstVOs;
		if (fcmDepRptErrRtVOs != null) {
			FcmDepRptErrRtVO[] tmpVOs = new FcmDepRptErrRtVO[fcmDepRptErrRtVOs.length];
			System.arraycopy(fcmDepRptErrRtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.fcmDepRptErrRtVOs = tmpVOs;
		}
	}

	public FcmDepRptErrRtVO getFcmDepRptErrRtVO() {
		return fcmDepRptErrRtVO;
	}

	public void setFcmDepRptErrRtVO(FcmDepRptErrRtVO fcmDepRptErrRtVO) {
		this.fcmDepRptErrRtVO = fcmDepRptErrRtVO;
	}

	public String getVslCd() {
		return vslCd;
	}

	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	

}