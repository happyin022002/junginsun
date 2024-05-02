/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0080Event.java
*@FileTitle : (N.China)I/B Agent Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.06.09 김세일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.AgentByVesselPortVO;


/**
 * FNS_INV_0080 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0080HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author saeil kim
 * @see FNS_INV_0080HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0080Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AgentByVesselPortVO agentByVesselPortVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AgentByVesselPortVO[] agentByVesselPortVOs = null;
	
	private String option = null;
	
	private String ofc = null;

	private String pageType = null;	
	
	public FnsInv0080Event(){}
	
	public void setAgentByVesselPortVO(AgentByVesselPortVO agentByVesselPortVO){
		this. agentByVesselPortVO = agentByVesselPortVO;
	}

	public void setAgentByVesselPortVOS(AgentByVesselPortVO[] agentByVesselPortVOs){
		this. agentByVesselPortVOs = agentByVesselPortVOs;
	}

	public AgentByVesselPortVO getAgentByVesselPortVO(){
		return agentByVesselPortVO;
	}

	public AgentByVesselPortVO[] getAgentByVesselPortVOS(){
		return agentByVesselPortVOs;
	}

	/**
	 * @return the option
	 */
	public String getOption() {
		return option;
	}

	/**
	 * @param option the option to set
	 */
	public void setOption(String option) {
		this.option = option;
	}

	/**
	 * @return the ofc
	 */
	public String getOfc() {
		return ofc;
	}

	/**
	 * @param ofc the ofc to set
	 */
	public void setOfc(String ofc) {
		this.ofc = ofc;
	}

	/**
	 * @return the pageType
	 */
	public String getPageType() {
		return pageType;
	}

	/**
	 * @param pageType the pageType to set
	 */
	public void setPageType(String pageType) {
		this.pageType = pageType;
	}

	
}