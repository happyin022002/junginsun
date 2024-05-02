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
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.basic;

import java.util.List;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.ADIDASInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.ADIDASInvoiceEdiVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.DHLInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.DHLInvoiceEdiVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.GlovisInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.GlovisInvoiceEdiVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.HNWLInvoiceEdiVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.HPInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.HPInvoiceEDIVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.MGBInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.MGBInvoiceEdiVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.NikeInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.NikeInvoiceEdiVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.PHILSInvoiceEdiVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.SamsungEDIBLChargeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.SamsungEDISendVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.SamsungInPutVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.SamsungInvoiceEDIVO;
import com.hanjin.framework.core.layer.event.EventException;
 
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
	 * 조회 이벤트 처리<br>
	 * 입력한 VVD 및 삼성업체명에 대해 기 EDI 정보로 생성된 문서번호(message no)정보를 조회한다.<br>
	 * 
	 * @param SamsungInPutVO samInPutVo
	 * @return SamsungInvoiceEDIVO
	 * @exception EventException
	 */
	public SamsungInvoiceEDIVO searchSamsungEDIMSGNo (SamsungInPutVO samInPutVo) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * 삼성전자의 EDI 전송할 Account Receivable 정보를 조회한다.<br>
	 * 
	 * @param String msgId
	 * @param String msgNo
	 * @return SamsungInvoiceEDIVO
	 * @exception EventException
	 */
	public SamsungInvoiceEDIVO searchSamsungAREDIList (String msgId, String msgNo) throws EventException;
	
	/**
	 * 새로운 Message No로 삼성전자의 EDI 전송할 Account Receivable 정보를 생성한다.<br>
	 * 
	 * @author JungJin Park
	 * @param SamsungInvoiceEDIVO creSamVo
	 * @return String
	 * @exception EventException
	 */		
	public String createSamsungAREDIList (SamsungInvoiceEDIVO creSamVo) throws EventException;
	
	/**
	 * 삼성전자의 EDI 전송 매출채권 정보를 삭제한다.<br>
	 * 
	 * @author JungJin Park
	 * @param String msgId
	 * @param String msgNo
	 * @param String userId
	 * @exception EventException
	 */		
	public void removeSamsungAREDIList (String msgId, String msgNo, String userId) throws EventException;

	/**
	 * 삼성전자의 Account Receivable 정보를 EDI 로 전송한다.
	 * 
	 * @param sendSamVOs
	 * @param sendStartIdx
	 * @throws EventException
	 */
	public void sendSamsungAREDIList (List<SamsungEDISendVO> sendSamVOs, String sendStartIdx) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * EDI 전송가능한 대상을 입력된 BL NO로 조회한다.<br>
	 * 삼성전자의 EDI 전송할 Account Receivable 정보에 추가로 입력할 내용으로 입력된 BL NO에 대한 정보를 조회한다.<br>
	 * 
	 * @param SamsungInPutVO samInPutVo
	 * @param String blNo
	 * @return SamsungInvoiceEDIVO
	 * @exception EventException
	 */
	public SamsungEDIBLChargeVO searchSamsungEDIByBL(SamsungInPutVO samInPutVo, String blNo) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * 입력한 ofc_Cd, bl_src_no Customer로 EDI 전송대상을 조회한다.<br>
	 * 
	 * @param HPInputVO hpInputVO
	 * @return List<HPInvoiceEDIVO>
	 * @exception EventException
	 */
	public List<HPInvoiceEDIVO> searchHPInvoiceEDIList(HPInputVO hpInputVO ) throws EventException;
	
	/**
	 * HP EDI 정보를 전송한다.<br>
	 * 
	 * @param List<HPInvoiceEDIVO> hpInvoiceEDIVOs
	 * @param String usrId
	 * @exception EventException
	 */		
	public void sendHPEDIList (List<HPInvoiceEDIVO> hpInvoiceEDIVOs, String usrId) throws EventException;
	
	/**
	 * Glovis로부터 들어온 EDI Message 수신
	 * 
	 * @param GlovisInputVO glovisInputVO
	 * @return List<CustomGlovisEDISearchVO>
	 * @exception EventException
	 */
	public List<GlovisInvoiceEdiVO> searchEdiGlovisList(GlovisInputVO glovisInputVO)  throws EventException;
	
	/**
	 * Glovis EDI 를 전송한다 
	 * 
	 * @param List<GlovisInvoiceEdiVO> glovisInvoiceEdiVOs
	 * @param String usrId
	 * @param String btnFlag
	 * @exception EventException
	 */
	public void sendEdiGlovisList (List<GlovisInvoiceEdiVO> glovisInvoiceEdiVOs,String usrId,String btnFlag) throws EventException;
	
	
	/**
	 * ofc_Cd, bl_src_no Customer로 EDI 전송대상을 조회한다.<br>
	 * 
	 * @param NikeInputVO nikeInputVO
	 * @return List<NikeInvoiceEdiVO>
	 * @exception EventException
	 */
	public List<NikeInvoiceEdiVO> searchEdiNikeList( NikeInputVO nikeInputVO ) throws EventException ;
	
	/**
	 * NIKE EDI 정보를 전송한다.<br>
	 * 
	 * @param List<NikeInvoiceEdiVO> nikeInvoiceEdiVOs
	 * @param String usrId
	 * @exception EventException
	 */		
	public void sendEdiNikeList (List<NikeInvoiceEdiVO> nikeInvoiceEdiVOs, String usrId) throws EventException;

	/**
	 * Retrieve DHL EDI list.
	 * 
	 * @param inputVO
	 * @return List<DHLInvoiceEdiVO>
	 * @throws EventException
	 */
	public List<DHLInvoiceEdiVO> searchEdiDHLList(DHLInputVO inputVO) throws EventException;

	/**
	 * Add DHL EDI.
	 * 
	 * @param dhlInvoiceEdiVOs
	 * @throws EventException
	 */
	public void addEdiDHL(DHLInvoiceEdiVO dhlInvoiceEdiVOs[]) throws EventException;

	/**
	 * Sending EDI for DHL.
	 * 
	 * @param dhlInvoiceEdiVOs
	 * @throws EventException
	 */
	public void sendEdiDHL(DHLInvoiceEdiVO dhlInvoiceEdiVOs[]) throws EventException;

	/**
	 * Retrieve Honey Well EDI list.
	 * 
	 * @param inputVO
	 * @return List<HNWLInvoiceEdiVO>
	 * @throws EventException
	 */
	public List<HNWLInvoiceEdiVO> searchEdiHNWLList(DHLInputVO inputVO) throws EventException;

	/**
	 * Add Honey Well EDI.
	 * 
	 * @param invoiceEdiVos
	 * @throws EventException
	 */
	public void addEdiHNWL(HNWLInvoiceEdiVO invoiceEdiVos[]) throws EventException;

	/**
	 * Sending EDI for Honey Well.
	 * 
	 * @param invoiceEdiVos
	 * @param inputVo
	 * @throws EventException
	 */
	public void sendEdiHNWL(HNWLInvoiceEdiVO invoiceEdiVos[], DHLInputVO inputVo) throws EventException;
	
	
	/**
	 * Retrieve PHILIPS EDI list.
	 * 
	 * @param inputVO
	 * @return List<PHILSInvoiceEdiVO>
	 * @throws EventException
	 */
	public List<PHILSInvoiceEdiVO> searchEdiPHILSList(DHLInputVO inputVO) throws EventException;
	
	
	/**
	 * Sending EDI for PHILIPS.
	 * 
	 * @param invoiceEdiVos
	 * @param inputVo
	 * @throws EventException
	 */
	public void sendEdiPHILS(PHILSInvoiceEdiVO invoiceEdiVos[], DHLInputVO inputVo) throws EventException;
	
	
	
	
		/**
		 * bl_src_no 로 EDI 전송대상을 조회한다.<br>
		 * 
		 * @param MGBInputVO mgbInputVO 
		 * @return String
		 * @exception EventException
		 */
		public String searchEdiMGBofficeYN( MGBInputVO mgbInputVO ) throws EventException ;
	
	/**
	 * ofc_Cd, bl_src_no Customer로 EDI 전송대상을 조회한다.<br>
	 * 
	 * @param MGBInputVO mgbInputVO 
	 * @return List<MGBInvoiceEdiVO>
	 * @exception EventException
	 */
	public List<MGBInvoiceEdiVO> searchEdiMGBList( MGBInputVO mgbInputVO ) throws EventException ;
	
	/**
	 * MGB EDI 정보를 전송한다.<br>
	 * 
	 * @param List<MGBInvoiceEdiVO> mgbInvoiceEdiVOs
	 * @param String usrId
	 * @exception EventException
	 */		
	public void sendEdiMGBList (List<MGBInvoiceEdiVO> mgbInvoiceEdiVOs, String usrId) throws EventException;

	/**
	 * ofc_Cd, bl_src_no Customer로 ADIDAS EDI 전송대상을 조회한다.<br>
	 * 
	 * @param ADIDASInputVO adidasInputVO
	 * @return List<ADIDASInvoiceEdiVO>
	 * @exception EventException
	 */
	public List<ADIDASInvoiceEdiVO> searchEdiADIDASList( ADIDASInputVO adidasInputVO ) throws EventException ;
	
	/**
	 * Sending EDI for ADIDAS.
	 * 
	 * @param adidasInvoiceEdiVOs
	 * @param String ofcCd
	 * @param String usrId
	 * @throws EventException
	 */
	public void sendEdiADIDAS(ADIDASInvoiceEdiVO adidasInvoiceEdiVOs[], String ofcCd, String usrId) throws EventException;


}
