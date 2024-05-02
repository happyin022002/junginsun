/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0081Event.java
*@FileTitle : (N.China)I/B Agent Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.09
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.12.09 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.AgentByVesselPortVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.CprtItemVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0081 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0081HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author saeil kim
 * @see FNS_INV_0081HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0081Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AgentByVesselPortVO agentByVesselPortVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AgentByVesselPortVO[] agentByVesselPortVOs = null;
	
	public AgentByVesselPortVO getAgentByVesselPortVO() {
		return agentByVesselPortVO;
	}

	public void setAgentByVesselPortVO(AgentByVesselPortVO agentByVesselPortVO) {
		this.agentByVesselPortVO = agentByVesselPortVO;
	}

	public AgentByVesselPortVO[] getAgentByVesselPortVOS() {
		return agentByVesselPortVOs;
	}

	public void setAgentByVesselPortVOS(AgentByVesselPortVO[] agentByVesselPortVOs) {
		this.agentByVesselPortVOs = agentByVesselPortVOs;
	}

	private String optType = "";
	
	private String arOfcCd = "";
	
	private String arCtrlOfcCd = "";
	
	public void setOptType(String optType){
		this. optType = optType;
	}

	public String getOptType(){
		return optType;
	}
	
	public void setArOfcCd(String arOfcCd){
		this. arOfcCd = arOfcCd;
	}

	public String getArOfcCd(){
		return arOfcCd;
	}
	
	public void setArCtrlOfcCd(String arCtrlOfcCd){
		this. arCtrlOfcCd = arCtrlOfcCd;
	}

	public String getArCtrlOfcCd(){
		return arCtrlOfcCd;
	}
}