/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StmSar5001Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.event;

import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.AgentCollectionListVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.ManageAgentCollectionListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableAgentSC로 실행요청<br>
 * - AccountReceivableAgentSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see StmSar5001Event 참조
 * @since J2EE 1.4
 */

public class StmSar5001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AgentCollectionListVO agentCollectionListVO = null;
	
	private ManageAgentCollectionListVO[] manageAgentCollectionListVOs = null;
	
	public ManageAgentCollectionListVO[] getManageAgentCollectionListVOs() {
		ManageAgentCollectionListVO[] rtnVOs = null;
		if (this.manageAgentCollectionListVOs != null) {
			rtnVOs = new ManageAgentCollectionListVO[manageAgentCollectionListVOs.length];
			System.arraycopy(manageAgentCollectionListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setManageAgentCollectionListVOs(ManageAgentCollectionListVO[] manageAgentCollectionListVOs) {
		if (manageAgentCollectionListVOs != null) {
			ManageAgentCollectionListVO[] tmpVOs = new ManageAgentCollectionListVO[manageAgentCollectionListVOs.length];
			System.arraycopy(manageAgentCollectionListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.manageAgentCollectionListVOs = tmpVOs;
		}
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public AgentCollectionListVO getAgentCollectionListVO() {
		return agentCollectionListVO;
	}

	public void setAgentCollectionListVO(AgentCollectionListVO agentCollectionListVO) {
		this.agentCollectionListVO = agentCollectionListVO;
	}

	
	public StmSar5001Event(){}

}