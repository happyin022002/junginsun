/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IncomeMgtBC.java
*@FileTitle : IncomeMgtBC
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.09.21 함형석
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.11.21 신혜정 [CHM-201114467-01] Cancelled Disposal Invoice history 저장  
* 2012.04.05 신혜정 [CHM-201217201] Disposal Invoice Issue 화면내 [Confirm], [Cancel] 처리시, invoice no 체크 로직 추가
					  1. [Confirm] 처리시, invoice no 유,무에 따른 체크 로직 추가
					   - invoice no 가 있을 경우 confirm 된 데이타 확인 후 존재시 return 처리
					   - invoice no 가 없을 경우(invoice status=New) Verify List 의 disposal no, eq_no 리스트로 invoice no 존재 확인후 있으면 return 처리
					  2. [Cancel] 처리시, Cancel invoice no 체크 로직 추가
					   - 기 Cancel invoice no 존재시 return 처리
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.basic;


import com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.vo.ReceivableINVInquiryINVO;
import com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.vo.ReceivableInvoiceGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispDtlVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * alps-AccountManage Business Logic Command Interface<br>
 * - alps-AccountManage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 함형석
 * @see Ees_mnr_0161EventResponse 참조
 * @since J2EE 1.4
 */	
     
public interface IncomeMgtBC {  

	/**
	 * [EES_MNR_0161 ] 의 정보를 조회 합니다. <br>
	 *
	 * @param ReceivableInvoiceGRPVO receivableInvoiceGRPVO
	 * @param SignOnUserAccount account
	 * @return ReceivableInvoiceGRPVO
	 * @exception EventException
	 */ 
	public ReceivableInvoiceGRPVO searchReceivableInvoiceListBasic(ReceivableInvoiceGRPVO receivableInvoiceGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0161]Disposal Invoice Issue의 정보를 조회 합니다. <br>
	 *
	 * @param ReceivableInvoiceGRPVO receivableInvoiceGRPVO
	 * @return ReceivableInvoiceGRPVO
	 * @exception EventException
	 */
	public ReceivableInvoiceGRPVO searchReceivableInvoiceDetailListBasic(ReceivableInvoiceGRPVO receivableInvoiceGRPVO) throws EventException;

	/**
	 * [EES_MNR_0161]Disposal Invoice Issue의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param ReceivableInvoiceGRPVO receivableInvoiceGRPVO
	 * @param SignOnUserAccount account
	 * @return ReceivableInvoiceGRPVO
	 * @exception EventException
	 */ 
	public ReceivableInvoiceGRPVO manageRepairReceivableInvoiceBasic(ReceivableInvoiceGRPVO receivableInvoiceGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0161]Disposal Invoice Issue의 State 정보를 수정 합니다. <br>
	 *
	 * @param ReceivableInvoiceGRPVO receivableInvoiceGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */ 
	public void manageRepairReceivableInvoiceStateHsBasic(ReceivableInvoiceGRPVO receivableInvoiceGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0161]Disposal Invoice Issue의 정보를 삭제 합니다. <br>
	 *
	 * @param ReceivableInvoiceGRPVO receivableInvoiceGRPVO
	 * @param SignOnUserAccount account
	 * @return ReceivableInvoiceGRPVO
	 * @exception EventException
	 */ 
	public ReceivableInvoiceGRPVO removeReceivableInvoiceBasic(ReceivableInvoiceGRPVO receivableInvoiceGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0161]Disposal Invoice Issue의 상태정보를 수정 합니다. <br>
	 * 
	 * @param ReceivableInvoiceGRPVO receivableInvoiceGRPVO
	 * @param SignOnUserAccount account 
	 * @exception EventException   
	 */ 
	public void modifyReceivableInvoiceStatusBasic(ReceivableInvoiceGRPVO receivableInvoiceGRPVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0161]Cancelled Disposal Invoice history 정보를 저장한다.  
	 * @param receivableInvoiceGRPVO RCV_INV_SEQ 정보
	 * @param account 사용자 계정
	 * @throws EventException
	 */
	public void addReceivableInvoiceCancelledBasic(ReceivableInvoiceGRPVO receivableInvoiceGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0161] Disposal Invoice Issue 내 Confirm, Cancel 시 invoice no 중복여부를 점검합니다.<br>
	 *     
	 * @param ReceivableINVInquiryINVO receivableINVInquiryINVO
	 * @return String
	 * @throws EventException
	 */
	public String checkReceivableInvNoBasic(ReceivableINVInquiryINVO receivableINVInquiryINVO) throws EventException;	
	
	/**
	 * [EES_MNR_0161] Disposal Invoice Issue 내 Confirm 시 invoice no 중복여부를 점검합니다. <br>
	 *   
	 * @param CustomMnrDispDtlVO customMnrDispDtlVO
	 * @return String
	 * @throws EventException
	 */
	public String checkVerifiedInvNoBasic(CustomMnrDispDtlVO customMnrDispDtlVO) throws EventException;		

} 