/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceEdiHitBC.java
*@FileTitle : HIT INVOICE EDI RECEIVE, PDF FILE ATTACH & ACK 
*Open Issues :
*Change history :
*@LastModifyDate : 2016-06-24
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2016-06-24 SHIN DONG IL
* 1.0 최초생성
============================================================= */
package com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.vo.InvEdiAckLogVO;
import com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.vo.InvEdiErrLogVO;
import com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.vo.InvEdiRcvEqVO;
import com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.vo.InvEdiRcvVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;


/**
 * HIT INVOICE EDI RECEIVE, PDF FILE ATTACH & ACK <br>
 * @author SHIN DONG IL
 * @see 각각의 BC 참조
 * @since J2EE 1.4
 */
public interface InvoiceEdiHitBC {
	static final String CHR10 = "\n";
	/**
	 * Invoice EDI 수신 
	 * @param str
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse getInvoiceEdiFf(String str)throws EventException;
	
	/**
	 * Invoice EDI 수신한 F/F을 EDI 수신 테이블에 저장.
	 * @param invEdiRcvVO
	 * @param invEdiRcvEqVOs 
	 * @return String
	 * @exception EventException
	 */
	public String saveInvoiceEdi(InvEdiRcvVO invEdiRcvVO, List<InvEdiRcvEqVO> invEdiRcvEqVOs)throws EventException;
	/**
	 * EDI 수신 테이블에 저장된 Invoice validation check.
	 * @param ediRcvSeq
	 * @exception EventException
	 */
	public void validationInvEdi(String ediRcvSeq)throws EventException;
	
	/**
	 * 본 테이블에 DATA SAVE(TRS_TRSP_INV_WRK, TRS_TRSP_SVC_ORD,TRS_TRSP_SO_HIS).
	 * @param invEdiRcvVO
	 * @param invEdiRcvEqVOs 
	 * @exception EventException
	 */
	public void saveInvoice(InvEdiRcvVO invEdiRcvVO, List<InvEdiRcvEqVO> invEdiRcvEqVOs)throws EventException;
	/**
	 * Invoice PDF File 수신 
	 * @param e
	 * @exception EventException
	 */
	public void receiveInvoicePdfFile(Event e)throws EventException;
	
	/**
	 * Invoice Ack 송신 
	 * @param invEdiRcvVO
	 * @return InvEdiAckLogVO
	 * @exception EventException
	 */
	public InvEdiAckLogVO makeInvoiceEdiAckFF(InvEdiRcvVO invEdiRcvVO)throws EventException;
	
	/**
	 * Invoice Ack 송신 
	 * @param invEdiRcvVO
	 * @param invEdiAckLogVO
	 * @exception EventException
	 */
	public void sendInvEdiAck(InvEdiRcvVO invEdiRcvVO,InvEdiAckLogVO invEdiAckLogVO)throws EventException;
	
	/**
	 * Invoice EDI Error Log Save 
	 * @param invEdiErrLogVO
	 * @throws EventException
	 */
	public void saveInvEdiErrLog(InvEdiErrLogVO invEdiErrLogVO)throws EventException;
}
