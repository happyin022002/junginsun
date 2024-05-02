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
=========================================================*/
package com.clt.apps.opus.vop.fcm.trendline.trendline.event;

import com.clt.apps.opus.vop.fcm.trendline.trendline.vo.FcmTrndLineVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * VOP_FCM_0013 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_FCM_0013HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ryu Hyuk
 * @see VOP_FCM_0013HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopFcm0013Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private FcmTrndLineVO fcmTrndLineVO = null;
	
	public VopFcm0013Event(){}
	
	public void setFcmTrndLineVO(FcmTrndLineVO fcmTrndLineVO){
		this.fcmTrndLineVO =fcmTrndLineVO;
	}

	public FcmTrndLineVO getFcmTrndLineVO(){
		return fcmTrndLineVO;
	}

}