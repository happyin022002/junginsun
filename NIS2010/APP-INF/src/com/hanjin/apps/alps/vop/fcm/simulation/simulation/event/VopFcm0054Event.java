/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VopFcm0054Event.java
*@FileTitle : VopFcm0054Event
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.23
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.12.23 진마리아
* 1.0 Creation
* 
* 2015.04.30 이병훈 [CHM-201534057] Split09-2015년 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.simulation.simulation.event;

import com.hanjin.apps.alps.vop.fcm.trendline.trendline.vo.FcmTrndLineVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * VVOP_FCM_0054 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_FCM_0054HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ryu Hyuk
 * @see VOP_FCM_0054HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopFcm0054Event extends EventSupport {

	/** Table Value Object 조회 조건 및 단건 처리  */
	private FcmTrndLineVO fcmTrndLineVO = null;
	/** Table Value Object Multi Data 처리 */
	private FcmTrndLineVO[] fcmTrndLineVOs = null;
	
	private static final long serialVersionUID = 1L;
	
	public VopFcm0054Event(){}

	public FcmTrndLineVO getFcmTrndLineVO() {
		return fcmTrndLineVO;
	}

	public void setFcmTrndLineVO(FcmTrndLineVO fcmTrndLineVO) {
		this.fcmTrndLineVO = fcmTrndLineVO;
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

}