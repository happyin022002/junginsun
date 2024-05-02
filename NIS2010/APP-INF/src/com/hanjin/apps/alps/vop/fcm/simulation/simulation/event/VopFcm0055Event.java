/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VopFcm0055Event.java
*@FileTitle : VopFcm0055Event
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

import com.hanjin.apps.alps.vop.fcm.simulation.simulation.vo.TrndLineSimulationVO;
import com.hanjin.apps.alps.vop.fcm.trendline.trendline.vo.FcmTrndLineVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.FcmNoonRptVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * VVOP_FCM_0055 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_FCM_0055HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ryu Hyuk
 * @see VOP_FCM_0055HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopFcm0055Event extends EventSupport {

	/** Table Value Object 조회 조건 및 단건 처리  */
	private TrndLineSimulationVO trndLineSimulationVO = null;
	private FcmTrndLineVO fcmTrndLineVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private FcmNoonRptVO[] fcmNoonRptVOs = null;

	private String target = null;
	
	private static final long serialVersionUID = 1L;
	
	public VopFcm0055Event(){}

	public TrndLineSimulationVO getTrndLineSimulationVO() {
		return trndLineSimulationVO;
	}

	public void setTrndLineSimulationVO(TrndLineSimulationVO trndLineSimulationVO) {
		this.trndLineSimulationVO = trndLineSimulationVO;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public FcmTrndLineVO getFcmTrndLineVO() {
		return fcmTrndLineVO;
	}

	public void setFcmTrndLineVO(FcmTrndLineVO fcmTrndLineVO) {
		this.fcmTrndLineVO = fcmTrndLineVO;
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

}