/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StmSco0050Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event;

import com.clt.framework.support.layer.event.EventSupport;

import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.LedgerCodeCombinationListVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.LedgerCodeCombinationCondVO;

/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 StatementCommonSC로 실행요청<br>
 * - StatementCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see StmSco0050Event 참조
 * @since J2EE 1.4
 */

public class StmSco0050Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private LedgerCodeCombinationCondVO ledgerCodeCombinationCondVO = null;
	private LedgerCodeCombinationListVO[] ledgerCodeCombinationListVOs = null;
	private LedgerCodeCombinationListVO ledgerCodeCombinationListVO = null;
	
	public LedgerCodeCombinationCondVO getLedgerCodeCombinationCondVO() {
		return ledgerCodeCombinationCondVO;
	}

	public void setLedgerCodeCombinationCondVO(LedgerCodeCombinationCondVO ledgerCodeCombinationCondVO) {
		this.ledgerCodeCombinationCondVO = ledgerCodeCombinationCondVO;
	}
	
	public LedgerCodeCombinationListVO[] getLedgerCodeCombinationListVOs() {		
		LedgerCodeCombinationListVO[] rtnVOs = null;
		if (this.ledgerCodeCombinationListVOs != null) {
			rtnVOs = new LedgerCodeCombinationListVO[ledgerCodeCombinationListVOs.length];
			System.arraycopy(ledgerCodeCombinationListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setLedgerCodeCombinationListVOs(LedgerCodeCombinationListVO[] ledgerCodeCombinationListVOs) {
		if (ledgerCodeCombinationListVOs != null) {
			LedgerCodeCombinationListVO[] tmpVOs = new LedgerCodeCombinationListVO[ledgerCodeCombinationListVOs.length];
			System.arraycopy(ledgerCodeCombinationListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.ledgerCodeCombinationListVOs = tmpVOs;
		}
	}

	public LedgerCodeCombinationListVO getLedgerCodeCombinationListVO() {
		return ledgerCodeCombinationListVO;
	}

	public void setLedgerCodeCombinationListVO(
			LedgerCodeCombinationListVO ledgerCodeCombinationListVO) {
		this.ledgerCodeCombinationListVO = ledgerCodeCombinationListVO;
	} 
	
	
	

}