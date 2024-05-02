/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VopFcm0061Event
*@FileTitle : VopFcm0061Event
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
package com.hanjin.apps.alps.vop.fcm.performance.performance.event;

import com.hanjin.apps.alps.vop.fcm.performance.performance.vo.FcmMonFoilSavCostVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * VOP_FCM_0061 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_FCM_0061HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ryu Hyuk
 * @see VOP_FCM_0061HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopFcm0061Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private FcmMonFoilSavCostVO fcmMonFoilSavCostVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private FcmMonFoilSavCostVO[] fcmMonFoilSavCostVOs = null;
	
	public VopFcm0061Event(){}
	
	public void setFcmMonFoilSavCostVO(FcmMonFoilSavCostVO fcmMonFoilSavCostVO){
		this.fcmMonFoilSavCostVO = fcmMonFoilSavCostVO;
	}

	public FcmMonFoilSavCostVO getFcmMonFoilSavCostVO(){
		return fcmMonFoilSavCostVO;
	}

	public FcmMonFoilSavCostVO[] getFcmMonFoilSavCostVOs() {
//		return fcmMonFoilSavCostVOs;
		FcmMonFoilSavCostVO[] rtnVOs = null;
		if (this.fcmMonFoilSavCostVOs != null) {
			rtnVOs = new FcmMonFoilSavCostVO[fcmMonFoilSavCostVOs.length];
			System.arraycopy(fcmMonFoilSavCostVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setFcmMonFoilSavCostVOs(FcmMonFoilSavCostVO[] fcmMonFoilSavCostVOs) {
//		this.fcmMonFoilSavCostVOs = fcmMonFoilSavCostVOs;
		if (fcmMonFoilSavCostVOs != null) {
			FcmMonFoilSavCostVO[] tmpVOs = new FcmMonFoilSavCostVO[fcmMonFoilSavCostVOs.length];
			System.arraycopy(fcmMonFoilSavCostVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.fcmMonFoilSavCostVOs = tmpVOs;
		}
	}

}