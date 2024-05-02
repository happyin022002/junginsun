/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StmSar1003Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.event;

import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.RCTViewAccountingListVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.event.StmSar1008Event;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableOutstandingSC로 실행요청<br>
 * - AccountReceivableOutstandingSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see StmSar1008Event 참조
 * @since J2EE 1.4
 */

public class StmSar2005Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	
	private RCTViewAccountingListVO rctViewAccountingListVO;


	public RCTViewAccountingListVO getRctViewAccountingListVO() {
		return rctViewAccountingListVO;
	}


	public void setRctViewAccountingListVO(
			RCTViewAccountingListVO rctViewAccountingListVO) {
		this.rctViewAccountingListVO = rctViewAccountingListVO;
	}





}