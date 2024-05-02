/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StmSap0004Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event;

import com.clt.framework.support.layer.event.EventSupport;



/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMasterDataMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author CLT
 * @see AccountReceivableInvoiceMasterDataMgtEvent 참조
 * @since J2EE 1.4
 */

public class StmSap0004Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String luCd = "";
	private String attrCtnt1 = "";

	public String getLuCd() {
		return luCd;
	}

	public void setLuCd(String luCd) {
		this.luCd = luCd;
	}

	public String getAttrCtnt1() {
		return attrCtnt1;
	}

	public void setAttrCtnt1(String attrCtnt1) {
		this.attrCtnt1 = attrCtnt1;
	}




}