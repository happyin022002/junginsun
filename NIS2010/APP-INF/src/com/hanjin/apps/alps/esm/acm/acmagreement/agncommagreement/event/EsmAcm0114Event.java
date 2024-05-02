/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0114Event.java
*@FileTitle : Agreement Information
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.15
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.06.15 김봉균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.event;

import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.vo.AgentRateMasterVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_0114 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0114HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Bong-Gyoon
 * @see ESM_ACM_0114HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0114Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private AgentRateMasterVO agentRateMasterVO = null;

	public EsmAcm0114Event() {}

	public AgentRateMasterVO getAgentRateMasterVO() {
		return agentRateMasterVO;
	}

	public void setAgentRateMasterVO(AgentRateMasterVO agentRateMasterVO) {
		this.agentRateMasterVO = agentRateMasterVO;
	}

}