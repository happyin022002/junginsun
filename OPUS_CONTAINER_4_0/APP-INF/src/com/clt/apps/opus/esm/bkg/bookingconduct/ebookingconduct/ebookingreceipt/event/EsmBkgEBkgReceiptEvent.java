/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkgUsaTmlEdiAckEvent.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.22
 *@LastModifier : 류대영
 *@LastVersion : 1.0
 * 2009.12.08 류대영
 * 1.0 Creation
 * ------------------------------------------------------
 * HISTORY
 * 2010.12.30 이일민 [CHM-201007165-01] Split 01-Simple EDI 개발 요청
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event;

import java.io.ByteArrayInputStream;

import com.clt.apps.opus.esm.bkg.servicesio.EBookingConductMQProxy;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * 미주 terminal EDI 수신용 이벤트
 * 
 * @author Ryu Daeyoung
 * @see EBookingConductMQProxy 참조
 * @since J2EE 1.4
 */
public class EsmBkgEBkgReceiptEvent extends EventSupport {
	private static final long serialVersionUID = 1L;	
	private String rcvSeq = null;
	private String rcvMsg = null;
	private ByteArrayInputStream rcvXls = null;

	
	public String getRcvSeq() {
		return rcvSeq;
	}
	public void setRcvSeq(String rcvSeq) {
		this.rcvSeq = rcvSeq;
	}
	public String getRcvMsg() {
		return rcvMsg;
	}
	public void setRcvMsg(String rcvMsg) {
		this.rcvMsg = rcvMsg;
	}
	public ByteArrayInputStream getRcvXls() {
		return rcvXls;
	}
	public void setRcvXls(ByteArrayInputStream rcvXls) {
		this.rcvXls = rcvXls;
	}
}

