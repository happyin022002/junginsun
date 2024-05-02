/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StmSco0054Event.java
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



/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 StatementCommonSC로 실행요청<br>
 * - StatementCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see StmSco0054Event 참조
 * @since J2EE 1.4
 */

public class StmSco0054Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String acct_cd ="";
	private String acctg_mng_tp_cd ="";
	private String pnd_tgt_flg ="";
	
	
	public String getAcct_cd() {
		return acct_cd;
	}
	public void setAcct_cd(String acct_cd) {
		this.acct_cd = acct_cd;
	}

	public String getAcctg_mng_tp_cd() {
		return acctg_mng_tp_cd;
	}
	public void setAcctg_mng_tp_cd(String acctg_mng_tp_cd) {
		this.acctg_mng_tp_cd = acctg_mng_tp_cd;
	}
	
	public String getPnd_tgt_flg() {
		return pnd_tgt_flg;
	}
	public void setPnd_tgt_flg(String pnd_tgt_flg) {
		this.pnd_tgt_flg = pnd_tgt_flg;
	}
	
	
	

}