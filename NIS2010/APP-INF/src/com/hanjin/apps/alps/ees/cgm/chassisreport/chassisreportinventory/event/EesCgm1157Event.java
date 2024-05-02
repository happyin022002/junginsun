/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName 		: EesCgm1157Event.java
*@FileTitle 	: Land Inventory Monitoring
*Open Issues 	: 
*Change history :
*@LastModifyDate: 2014.04.16
*@LastModifier 	: 최덕우
*@LastVersion 	: 1.0
* 2014.04.16 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassisreport.chassisreportinventory.event;

import com.hanjin.apps.alps.ees.cgm.chassisreport.chassisreportinventory.vo.LandInvMonitoringVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ees_cgm_1157 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_cgm_1157HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 최덕우
 * @see EES_CGM_1157HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesCgm1157Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private LandInvMonitoringVO landInvMonitoringVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private LandInvMonitoringVO[] landInvMonitoringVOS = null;

	public EesCgm1157Event(){}
	
	

	public LandInvMonitoringVO getLandInvMonitoringVO() {
		return landInvMonitoringVO;
	}

	public void setLandInvMonitoringVO(LandInvMonitoringVO landInvMonitoringVO) {
		this.landInvMonitoringVO = landInvMonitoringVO;
	}

	public LandInvMonitoringVO[] getLandInvMonitoringVOS() {
		return landInvMonitoringVOS;
	}

	public void setLandInvMonitoringVOS(LandInvMonitoringVO[] landInvMonitoringVOS) {
		this.landInvMonitoringVOS = landInvMonitoringVOS;
	}

	
}