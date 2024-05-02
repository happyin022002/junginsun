/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0517Event.java
*@FileTitle : VOSI Update Monitoring
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.07.10 김종옥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesseloperationsupportmonitoring.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesseloperationsupportmonitoring.vo.VosiUpdateMonitoringConditionVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesseloperationsupportmonitoring.vo.VosiUpdateMonitoringVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * VOP_VSK_0517 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0517HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jong Ock
 * @see VOP_VSK_0517HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopVsk0517Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VosiUpdateMonitoringVO vosiUpdateMonitoringVO = null;
	private VosiUpdateMonitoringConditionVO vosiUpdateMonitoringConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private VosiUpdateMonitoringVO[] vosiUpdateMonitoringVOs = null;

	public VopVsk0517Event(){}
	
	public void setVosiUpdateMonitoringVO(VosiUpdateMonitoringVO vosiUpdateMonitoringVO){
		this. vosiUpdateMonitoringVO = vosiUpdateMonitoringVO;
	}

	public void setVosiUpdateMonitoringVOS(VosiUpdateMonitoringVO[] vosiUpdateMonitoringVOs){
		if(vosiUpdateMonitoringVOs != null){
			VosiUpdateMonitoringVO[] tmpVOs = Arrays.copyOf(vosiUpdateMonitoringVOs, vosiUpdateMonitoringVOs.length);
			this.vosiUpdateMonitoringVOs = tmpVOs;
		}
	}

	public VosiUpdateMonitoringVO getVosiUpdateMonitoringVO(){
		return vosiUpdateMonitoringVO;
	}

	public VosiUpdateMonitoringVO[] getVosiUpdateMonitoringVOS(){
		VosiUpdateMonitoringVO[] rtnVOs = null;
		if (this.vosiUpdateMonitoringVOs != null) {
			rtnVOs = Arrays.copyOf(vosiUpdateMonitoringVOs, vosiUpdateMonitoringVOs.length);
		}
		return rtnVOs;
	}
	
	public void setVosiUpdateMonitoringConditionVO(VosiUpdateMonitoringConditionVO vosiUpdateMonitoringConditionVO) {
		this.vosiUpdateMonitoringConditionVO = vosiUpdateMonitoringConditionVO;
	}
	
	public VosiUpdateMonitoringConditionVO getVosiUpdateMonitoringConditionVO() {
		return vosiUpdateMonitoringConditionVO;
	}

}