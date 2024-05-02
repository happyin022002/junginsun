/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VopFcm0082Event.java
*@FileTitle : VopFcm0082Event
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
package com.hanjin.apps.alps.vop.fcm.setup.setup.event;

import com.hanjin.apps.alps.vop.fcm.setup.setup.vo.FcmSavItmRgstVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * VOP_FCM_0082 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_FCM_0082HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ryu Hyuk
 * @see VOP_FCM_0082HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopFcm0082Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private FcmSavItmRgstVO fcmSavItmRgstVO = null;
	private FcmSavItmRgstVO[] fcmSavItmRgstVOs = null;

	public VopFcm0082Event(){}



	public FcmSavItmRgstVO[] getFcmSavItmRgstVOs() {
//		return fcmSavItmRgstVOs;
		FcmSavItmRgstVO[] rtnVOs = null;
		if (this.fcmSavItmRgstVOs != null) {
			rtnVOs = new FcmSavItmRgstVO[fcmSavItmRgstVOs.length];
			System.arraycopy(fcmSavItmRgstVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}



	public void setFcmSavItmRgstVOs(FcmSavItmRgstVO[] fcmSavItmRgstVOs) {
//		this.fcmSavItmRgstVOs = fcmSavItmRgstVOs;
		if (fcmSavItmRgstVOs != null) {
			FcmSavItmRgstVO[] tmpVOs = new FcmSavItmRgstVO[fcmSavItmRgstVOs.length];
			System.arraycopy(fcmSavItmRgstVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.fcmSavItmRgstVOs = tmpVOs;
		}
	}



	public FcmSavItmRgstVO getFcmSavItmRgstVO() {
		return fcmSavItmRgstVO;
	}



	public void setFcmSavItmRgstVO(FcmSavItmRgstVO fcmSavItmRgstVO) {
		this.fcmSavItmRgstVO = fcmSavItmRgstVO;
	}
	
	

}