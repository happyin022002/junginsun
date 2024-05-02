/*=========================================================
 * Copyright(c) 2009 CyberLogitec
 * @FileName : AccountReceivableEDISendBC.java
 * @FileTitle : (China) Pantos Inquiry/Re-send
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2009.04.27
 * @LastModifier : 김상현
 * @LastVersion : 1.0
 * 2009.05.04 김세일
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2010.09.10 최도순 [CHM-201005801] AR Inovice module내 EDI Submission기능 추가 개발(2차) 
 * 2010.11.25 이석준 [CHM-201006884] Glovis EDI 전송 내역 조회
 * 2010.12.22 최도순 [CHM-201006644] 최도순 NIKE, Invoice EDI 신규 개발 요청
 * 2012.04.27 김상현 [CHM-201216976] DHL EDI 개발 요청
 * 2012.05.21 김상현 [CHM-201216580] Honey Well EDI 작업
 * 2012.06.20 김상현 [CHM-201218417] 삼성전자 EDI TIME OUT 방지 logic 보완 요청
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.basic;

import java.util.List;


import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.APCInvoiceVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.EDI310InputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.EDI310InvoiceVO;
import com.clt.framework.core.layer.event.EventException;
 
/**
 * ALPS-Accountreceivableinvoicemgt Business Logic Command Interface<br>
 * - ALPS-Accountreceivableinvoicemgt에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author saeil kim
 * @see Fns_inv_0003EventResponse 참조
 * @since J2EE 1.4
 */

public interface AccountReceivableEDISendBC {
	 
	/**
	 * Search EDI 310 Invoice<br>
	 * 
	 * @param EDI310InputVO edi310InputVO
	 * @return List<EDI310InvoiceVO>
	 * @exception EventException
	 */
	public List<EDI310InvoiceVO> searchEDI310Invoice( EDI310InputVO edi310InputVO ) throws EventException;
	
	/**
	 * Search Invoice EDI Level<br>
	 * 
	 * @param String cntcTpCd
	 * @param String scRfaNo
	 * @return String
	 * @exception EventException
	 */
	public String searchInvoiceEDILevel( String cntcTpCd, String scRfaNo) throws EventException;
		
	/**
	 * Send EDI 310 Invoice<br>
	 * 
	 * @param List<EDI310InvoiceVO> edi310InvoiceVOs
	 * @param String usrId
	 * @return List<String>
	 * @exception EventException
	 */		
	public List<String> sendEDI310Invoice (List<EDI310InvoiceVO> edi310InvoiceVOs, String usrId) throws EventException;

	/**
	 * APC Invoice 를 조회한다.<br>
	 * @author Myoungsin park
	 * @param APCInvoiceVO aPCInvoiceVO
	 * @return List<APCInvoiceVO>
	 * @exception EventException 
	 */	
	public List<APCInvoiceVO> searchAPCInvoice(APCInvoiceVO aPCInvoiceVO) throws EventException;
	
	/**
	 * Send APC Invoice<br>
	 * 
	 * @param List<APCInvoiceVO> aPCInvoiceVOs
	 * @param String usrId
	 * @exception EventException
	 */		
	public void sendAPCInvoice (List<APCInvoiceVO> aPCInvoiceVOs, String usrId) throws EventException;
}
