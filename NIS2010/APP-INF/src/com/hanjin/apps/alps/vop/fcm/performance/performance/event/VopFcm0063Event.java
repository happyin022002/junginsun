/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VopFcm0063Event
*@FileTitle : VopFcm0063Event
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.04
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2011.10.04 유혁
* 1.0 Creation
* 
* History
* 2015.01.23 이병훈 [CHM-201430612] Fuel Consumption Master table 개발
* 2015.04.30 이병훈 [CHM-201534057] Split09-2015년 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.performance.performance.event;

import com.hanjin.apps.alps.vop.fcm.performance.performance.vo.FcmMasterTableInquiryVO;
import com.hanjin.apps.alps.vop.fcm.performance.performance.vo.FcmMonFoilSavCostVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * VOP_FCM_0063 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_FCM_0063HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ryu Hyuk
 * @see VOP_FCM_0063HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopFcm0063Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private FcmMonFoilSavCostVO fcmMonFoilSavCostVO = null;
	private FcmMasterTableInquiryVO[] fcmMasterTableInquiryVOs = null;
	
	public VopFcm0063Event(){}
	
	public void setFcmMonFoilSavCostVO(FcmMonFoilSavCostVO fcmMonFoilSavCostVO){
		this.fcmMonFoilSavCostVO = fcmMonFoilSavCostVO;
	}

	public FcmMonFoilSavCostVO getFcmMonFoilSavCostVO(){
		return fcmMonFoilSavCostVO;
	}
	
	public FcmMasterTableInquiryVO[] getFcmMasterTableInquiryVOs() {
//		return fcmMasterTableInquiryVOs;
		FcmMasterTableInquiryVO[] rtnVOs = null;
		if (this.fcmMasterTableInquiryVOs != null) {
			rtnVOs = new FcmMasterTableInquiryVO[fcmMasterTableInquiryVOs.length];
			System.arraycopy(fcmMasterTableInquiryVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setFcmMasterTableInquiryVOs(FcmMasterTableInquiryVO[] fcmMasterTableInquiryVOs) {
//		this.fcmMasterTableInquiryVOs = fcmMasterTableInquiryVOs;
		if (fcmMasterTableInquiryVOs != null) {
			FcmMasterTableInquiryVO[] tmpVOs = new FcmMasterTableInquiryVO[fcmMasterTableInquiryVOs.length];
			System.arraycopy(fcmMasterTableInquiryVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.fcmMasterTableInquiryVOs = tmpVOs;
		}
	}

}