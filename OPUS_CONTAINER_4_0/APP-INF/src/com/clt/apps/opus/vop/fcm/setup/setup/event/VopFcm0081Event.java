/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VopFcm0081Event.java
*@FileTitle : VopFcm0081Event
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
package com.clt.apps.opus.vop.fcm.setup.setup.event;

import com.clt.apps.opus.vop.fcm.setup.setup.vo.FcmVslCntrRgstVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * VOP_FCM_0081 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_FCM_0081HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ryu Hyuk
 * @see VOP_FCM_0081HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopFcm0081Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private FcmVslCntrRgstVO fcmVslCntrRgstVO = null;
	private FcmVslCntrRgstVO[] fcmVslCntrRgstVOs = null;
	
	private String vslCd = null;

	public VopFcm0081Event(){}

	public FcmVslCntrRgstVO[] getFcmVslCntrRgstVOs() {
//		return fcmVslCntrRgstVOs;
		FcmVslCntrRgstVO[] rtnVOs = null;
		if (this.fcmVslCntrRgstVOs != null) {
			rtnVOs = new FcmVslCntrRgstVO[fcmVslCntrRgstVOs.length];
			System.arraycopy(fcmVslCntrRgstVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setFcmVslCntrRgstVOs(FcmVslCntrRgstVO[] fcmVslCntrRgstVOs) {
//		this.fcmVslCntrRgstVOs = fcmVslCntrRgstVOs;
		if (fcmVslCntrRgstVOs != null) {
			FcmVslCntrRgstVO[] tmpVOs = new FcmVslCntrRgstVO[fcmVslCntrRgstVOs.length];
			System.arraycopy(fcmVslCntrRgstVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.fcmVslCntrRgstVOs = tmpVOs;
		}
	}

	public FcmVslCntrRgstVO getFcmVslCntrRgstVO() {
		return fcmVslCntrRgstVO;
	}

	public void setFcmVslCntrRgstVO(FcmVslCntrRgstVO fcmVslCntrRgstVO) {
		this.fcmVslCntrRgstVO = fcmVslCntrRgstVO;
	}

	public String getVslCd() {
		return vslCd;
	}

	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	

}