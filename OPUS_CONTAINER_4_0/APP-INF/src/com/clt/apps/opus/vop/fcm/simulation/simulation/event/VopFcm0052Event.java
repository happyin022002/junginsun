/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VopFcm8888Event.java
*@FileTitle : VopFcm8888Event
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.04
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2011.10.04 유혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.fcm.simulation.simulation.event;

import com.clt.apps.opus.vop.fcm.simulation.simulation.vo.FcmBnkCsmPfDtlSimVO;
import com.clt.apps.opus.vop.fcm.simulation.simulation.vo.FcmBnkCsmPfSimVO;
import com.clt.apps.opus.vop.fcm.simulation.simulation.vo.SmlPfSkdVO;
import com.clt.apps.opus.vop.fcm.trendline.trendline.vo.FcmTrndLineVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * VVOP_FCM_0052 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_FCM_0052HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ryu Hyuk
 * @see VOP_FCM_00528HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopFcm0052Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SmlPfSkdVO smlPfSkdVO = null;
	
	private FcmBnkCsmPfSimVO fcmBnkCsmPfSimVO = null;
	
	private FcmBnkCsmPfDtlSimVO fcmBnkCsmPfDtlSimVO = null;
	
	private FcmTrndLineVO fcmTrndLineVO = null;
	
	
	public VopFcm0052Event(){}

	
	public FcmBnkCsmPfSimVO getFcmBnkCsmPfSimVO() {
		return fcmBnkCsmPfSimVO;
	}


	public void setFcmBnkCsmPfSimVO(FcmBnkCsmPfSimVO fcmBnkCsmPfSimVO) {
		this.fcmBnkCsmPfSimVO = fcmBnkCsmPfSimVO;
	}


	public FcmBnkCsmPfDtlSimVO getFcmBnkCsmPfDtlSimVO() {
		return fcmBnkCsmPfDtlSimVO;
	}


	public void setFcmBnkCsmPfDtlSimVO(FcmBnkCsmPfDtlSimVO fcmBnkCsmPfDtlSimVO) {
		this.fcmBnkCsmPfDtlSimVO = fcmBnkCsmPfDtlSimVO;
	}


	public SmlPfSkdVO getSmlPfSkdVO() {
		return smlPfSkdVO;
	}

	public void setSmlPfSkdVO(SmlPfSkdVO smlPfSkdVO) {
		this.smlPfSkdVO = smlPfSkdVO;
	}


	public FcmTrndLineVO getFcmTrndLineVO() {
		return fcmTrndLineVO;
	}


	public void setFcmTrndLineVO(FcmTrndLineVO fcmTrndLineVO) {
		this.fcmTrndLineVO = fcmTrndLineVO;
	}
	
}