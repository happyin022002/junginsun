/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0001Event.java
*@FileTitle : Commission Agreement Creation_Master
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.20
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.03.20 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.event;

import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.vo.AgentMinimumCommissionVO;
import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.vo.AgentRateMasterVO;
import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.vo.AgentRateDetailVO;
import com.hanjin.framework.support.layer.event.EventSupport;

 
/**
 * ESM_ACM_0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_ACM_0001HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0001Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private AgentRateMasterVO agentRateMasterVO = null;

	/** Table Value Object Multi Data 처리 */
	private AgentRateMasterVO[] agentRateMasterVOs = null;

	/** Table Value Object Multi Data 처리 */
	private AgentRateDetailVO[] agentRateDetailVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AgentMinimumCommissionVO agentMinimumCommissionVO = null;

	/** Table Value Object Multi Data 처리 */
	private AgentMinimumCommissionVO[] agentMinimumCommissionVOs = null;
	
	
	private String chgCd = null;

	public EsmAcm0001Event() {}

	public AgentRateMasterVO getAgentRateMasterVO() {
		return agentRateMasterVO;
	}

	public void setAgentRateMasterVO(AgentRateMasterVO agentRateMasterVO) {
		this.agentRateMasterVO = agentRateMasterVO;
	}

	public AgentRateMasterVO[] getAgentRateMasterVOs() {
		return agentRateMasterVOs;
	}

	public void setAgentRateMasterVOs(AgentRateMasterVO[] agentRateMasterVOs) {
		this.agentRateMasterVOs = agentRateMasterVOs;
	}

	public AgentRateDetailVO[] getAgentRateDetailVOs() {
		return agentRateDetailVOs;
	}

	public void setAgentRateDetailVOs(AgentRateDetailVO[] agentRateDetailVOs) {
		this.agentRateDetailVOs = agentRateDetailVOs;
	}
	
	
	
	public AgentMinimumCommissionVO getAgentMinimumCommissionVO() {
		return agentMinimumCommissionVO;
	}

	public void setAgentMinimumCommissionVO(
			AgentMinimumCommissionVO agentMinimumCommissionVO) {
		this.agentMinimumCommissionVO = agentMinimumCommissionVO;
	}

	public AgentMinimumCommissionVO[] getAgentMinimumCommissionVOs() {
		return agentMinimumCommissionVOs;
	}

	public void setAgentMinimumCommissionVOs(
			AgentMinimumCommissionVO[] agentMinimumCommissionVOs) {
		this.agentMinimumCommissionVOs = agentMinimumCommissionVOs;
	}

	public String getChgCd() {
		return chgCd;
	}

	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
	}
}
