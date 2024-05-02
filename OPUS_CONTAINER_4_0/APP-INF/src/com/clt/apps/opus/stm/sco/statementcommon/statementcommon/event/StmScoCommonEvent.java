/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StmScoCommonEvent.java
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
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.LookupInfoVO;


/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 StatementCommonSC로 실행요청<br>
 * - StatementCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see StmScoCommonEvent 참조
 * @since J2EE 1.4
 */

public class StmScoCommonEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	String srhLookupCode = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private LookupInfoVO lookupInfoVO = null;

	/** Table Value Object Multi Data 처리 */
	private LookupInfoVO[] lookupInfoVOs = null;
	
	public StmScoCommonEvent() {}
	
	public String getSrhLookupCode() {
		return srhLookupCode;
	}
	public void setSrhLookupCode(String srhLookupCode) {
		this.srhLookupCode = srhLookupCode;
	}

	public LookupInfoVO getLookupInfoVO() {
		return lookupInfoVO;
	}

	public void setLookupInfoVO(LookupInfoVO lookupInfoVO) {
		this.lookupInfoVO = lookupInfoVO;
	}

	public LookupInfoVO[] getLookupInfoVOs() {
		LookupInfoVO[] rtnVOs = null;
		if (this.lookupInfoVOs != null) {
			rtnVOs = new LookupInfoVO[lookupInfoVOs.length];
			System.arraycopy(lookupInfoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setLookupInfoVOs(LookupInfoVO[] lookupInfoVOs) {
		if (lookupInfoVOs != null) {
			LookupInfoVO[] tmpVOs = new LookupInfoVO[lookupInfoVOs.length];
			System.arraycopy(lookupInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.lookupInfoVOs = tmpVOs;
		}
	}

}