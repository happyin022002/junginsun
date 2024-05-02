/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StmSap0003Event.java
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

import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.ApCSRNoListVO;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMasterDataMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Han Dong Hoon
 * @see AccountReceivableInvoiceMasterDataMgtEvent 참조
 * @since J2EE 1.4
 */

public class StmSap0003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 처리  */
	private ApCSRNoListVO apCSRNoListVO = null;


	public StmSap0003Event() {}


	public ApCSRNoListVO getApCSRNoListVO() {
		return apCSRNoListVO;
	}


	public void setApCSRNoListVO(ApCSRNoListVO apCSRNoListVO) {
		this.apCSRNoListVO = apCSRNoListVO;
	}
	
}
