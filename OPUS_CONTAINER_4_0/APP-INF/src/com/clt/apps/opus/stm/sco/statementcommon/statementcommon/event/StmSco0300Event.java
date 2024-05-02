/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StmSap0120Event.java
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

import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.ScoStmtCdConvVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMasterDataMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Han Dong Hoon
 * @see AccountReceivableInvoiceMasterDataMgtEvent 참조
 * @since J2EE 1.4
 */

public class StmSco0300Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String luTpCd  = "";
	private String enblFlg = "";

	private ScoStmtCdConvVO[] scoStmtCdConvVOs = null;

	public String getLuTpCd() {
		return luTpCd;
	}

	public void setLuTpCd(String luTpCd) {
		this.luTpCd = luTpCd;
	}

	public String getEnblFlg() {
		return enblFlg;
	}

	public void setEnblFlg(String enblFlg) {
		this.enblFlg = enblFlg;
	}

	public ScoStmtCdConvVO[] getScoStmtCdConvVOs() {
		ScoStmtCdConvVO[] rtnVOs = null;
		if (this.scoStmtCdConvVOs != null) {
			rtnVOs = new ScoStmtCdConvVO[scoStmtCdConvVOs.length];
			System.arraycopy(scoStmtCdConvVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setScoStmtCdConvVOs(ScoStmtCdConvVO[] scoStmtCdConvVOs) {
		if (scoStmtCdConvVOs != null) {
			ScoStmtCdConvVO[] tmpVOs = new ScoStmtCdConvVO[scoStmtCdConvVOs.length];
			System.arraycopy(scoStmtCdConvVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scoStmtCdConvVOs = tmpVOs;
		}
	}


}