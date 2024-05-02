/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0101Event.java
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

import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.vo.AgentRateMasterVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_0101 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0101HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_ACM_0101HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0101Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private AgentRateMasterVO agentRateMasterVO = null;

	public EsmAcm0101Event() {}

	public AgentRateMasterVO getAgentRateMasterVO() {
		return agentRateMasterVO;
	}

	public void setAgentRateMasterVO(AgentRateMasterVO agentRateMasterVO) {
		this.agentRateMasterVO = agentRateMasterVO;
	}

}