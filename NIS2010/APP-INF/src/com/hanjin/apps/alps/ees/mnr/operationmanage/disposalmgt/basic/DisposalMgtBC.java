/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DisposalMgtBC.java
*@FileTitle : Disposal
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11 
*@LastModifier : 박명신 
*@LastVersion : 1.0
* 2009.09.11 박명신 
* 1.0 Creation 
* --------------------------------------------------------
* History
* 2011.11.21 신혜정 [CHM-201114467-01] Cancelled Disposal Invoice history 저장   
* 2012.04.12 신혜정 [CHM-201217048] Disposal Inquiry 화면에서 not pick-up 된 장비 list 조회 기능 추가
* 2012.11.29 조경완 [CHM-201221414-01] ALPS-MNR-DISPOSAL-MANAGEMENT-MANAGEMENT INQUIRY 화면에서 수정 건 
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.basic;


import java.util.List;

import com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.vo.ReceivableInvoiceGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispCancelVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispNoPickUpVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomMyBiddingHdrVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.DisposalGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.DisposalInquiryGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.DisposalNVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.DisposalSoldGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.DisposalSoldINVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.MyBiddingGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.MyBiddingINVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
 	
/**	
 * alps-Operationmanage Business Logic Command Interface<br>
 * - alps-Operationmanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author park myoung sin	 	
 * @see Ees_mnr_0156EventResponse 참조
 * @since J2EE 1.4	
 */ 
	
public interface DisposalMgtBC {	
	/**
	 * [EES_MNR_0164]Disposal Request의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @param SignOnUserAccount account 
	 * @return DisposalGRPVO
	 * @exception EventException
	 */    
	public DisposalGRPVO searchDisposalListBasic(DisposalGRPVO disposalGRPVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0164]Disposal Request의 정보를 삭제(Reject) 합니다. <br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalGRPVO
	 * @exception EventException
	 */   
	public DisposalGRPVO removeDisposalListData(DisposalGRPVO disposalGRPVO, SignOnUserAccount account) throws EventException; 
	
	/**
	 * [EES_MNR_0093]Scrapping/Donation Creation의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalGRPVO
	 * @exception EventException
	 */ 
	public DisposalGRPVO searchDSPBuyerDTLPartBasic(DisposalGRPVO disposalGRPVO, SignOnUserAccount account) throws EventException;
		
	/**
	 * [EES_MNR_0159]Disposal Request의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @return DisposalGRPVO
	 * @exception EventException
	 */ 
	public DisposalGRPVO searchDisposalMailListBasic(DisposalGRPVO disposalGRPVO) throws EventException;	
	
	/**
	 * [EES_MNR_0159]Disposal Management의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @return DisposalGRPVO
	 * @exception EventException
	 */
	public DisposalGRPVO searchDSPConfirmMailListBasic(DisposalGRPVO disposalGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0200]Disposal Request의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @return DisposalGRPVO
	 * @exception EventException
	 */
	public DisposalGRPVO searchDisposalBasic(DisposalGRPVO disposalGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0162]Disposal Approval Popup 화면에서 Buyer List를 조회한다. <br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @return DisposalGRPVO
	 * @exception EventException
	 */
	public DisposalGRPVO searchDisposalBasicPopUp(DisposalGRPVO disposalGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0159]Disposal Management의 정보를 작업 합니다. <br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalGRPVO
	 * @exception EventException
	 */   
	public DisposalGRPVO reBiddingDisposalBasic(DisposalGRPVO disposalGRPVO, SignOnUserAccount account) throws EventException;  
	
	/**
	 * [EES_MNR_0159]Disposal Management의 정보를 작업 합니다. <br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalGRPVO
	 * @exception EventException
	 */   
	public DisposalGRPVO confirmDisposalBasic(DisposalGRPVO disposalGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0157]Disposal Request의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalGRPVO
	 * @exception EventException
	 */   
	public DisposalGRPVO manageDisposalBasic(DisposalGRPVO disposalGRPVO, SignOnUserAccount account) throws EventException;
	 
	/**
	 * [EES_MNR_0159]Disposal Request의 정보를 삭제 합니다. <br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalGRPVO
	 * @exception EventException
	 */   
	public DisposalGRPVO removeDisposalBasic(DisposalGRPVO disposalGRPVO, SignOnUserAccount account) throws EventException; 
	
	/**
	* [EES_MNR_0157]Disposal Request의 정보를 추가 합니다. <br>
	*
	* @param DisposalGRPVO disposalGRPVO
	* @exception EventException
	*/    
	public void addContractDisposalBuyerDTLBasic(DisposalGRPVO disposalGRPVO) throws EventException;

	/**
	 * [EES_MNR0160] Retrive. <br>
	 * Disposal Sold Creation 의 Header 리스트를 조회합니다.
	 * @param DisposalSoldGRPVO disposalSoldGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalSoldGRPVO
	 * @exception EventException
	 */
	public DisposalSoldGRPVO searchDisposalSoldListBasic(DisposalSoldGRPVO disposalSoldGRPVO, SignOnUserAccount account) throws EventException;
	
	
	
	/**
	 * [EES_MNR_0160]Disposal Sold Creation의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalSoldGRPVO disposalSoldGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalSoldGRPVO
	 * @exception EventException
	 */
	public DisposalSoldGRPVO searchDisposalSoldDetailBasic(DisposalSoldGRPVO disposalSoldGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0251] Sold Cancellation의 정보를 저장 합니다.<br>
	 * 
	 * @param CustomMnrDispCancelVO[] customMnrDispCancelVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDisposalSoldCancel(CustomMnrDispCancelVO[] customMnrDispCancelVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0163]Disposal Invoice Inquiry의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalInquiryGRPVO disposalInquiryGRPVO
	 * @return DisposalInquiryGRPVO
	 * @exception EventException
	 */
	public DisposalInquiryGRPVO searchDisposalInquiryListBasic(DisposalInquiryGRPVO disposalInquiryGRPVO) throws EventException;

	/**
	 * [EES_MNR_0163]Disposal Invoice Detail의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalInquiryGRPVO disposalInquiryGRPVO
	 * @return DisposalInquiryGRPVO
	 * @exception EventException
	 */
	public DisposalInquiryGRPVO searchDisposalDetailInquiryListBasic(DisposalInquiryGRPVO disposalInquiryGRPVO) throws EventException;

	/**
	 * [EES_MNR_0163]Disposal Invoice Collection의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalInquiryGRPVO disposalInquiryGRPVO
	 * @return DisposalInquiryGRPVO
	 * @exception EventException
	 */
	public DisposalInquiryGRPVO searchDisposalCollectionInquiryListBasic(DisposalInquiryGRPVO disposalInquiryGRPVO) throws EventException;

	
	/**
	 * [EES_MNR_0160]Disposal Sold Creation의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param DisposalSoldGRPVO disposalSoldGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDisposalSoldBasic(DisposalSoldGRPVO disposalSoldGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0160] Disposal Sold Creation 의 Release No 를 생성 조회 합니다. <br>
	 *
	 * @param SignOnUserAccount account
	 * @return DisposalSoldGRPVO
	 * @exception EventException
	 */          
	public DisposalSoldGRPVO searchDispRlseNoBasic(SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0157,0159]Disposal Comfirm시 추가 Sum작업을 실행<br> 
	 * 
	 * @param DisposalGRPVO disposalGRPVO
	 * @exception EventException
	 */    
	public void addDisposalCofirmSumBasic(DisposalGRPVO disposalGRPVO) throws EventException;

	/**
	 * [EES_MNR_0161]Disposal Invoice Issue의 정보를 삭제 합니다. <br>
	 * 
	 * @param DisposalGRPVO disposalGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException  
	 */    
	public void modifyDisposalInvoiceLinkClearBasic(DisposalGRPVO disposalGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0161]Disposal Invoice Issue의 정보를 수정 합니다. 
	 * 
	 * @param DisposalGRPVO disposalGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException  
	 */    
	public void modifyDisposalInvoiceLinkBasic(DisposalGRPVO disposalGRPVO,SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_S308] 파트너 정보를 조회 합니다. 
	 * 
	 * @param DisposalInquiryGRPVO disposalInquiryGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalInquiryGRPVO
	 * @exception EventException  
	 */   
	public DisposalInquiryGRPVO searchPartnerBasic(DisposalInquiryGRPVO disposalInquiryGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_S304] My Bidding List 헤더 목록을 조회합니다.<br>
	 * 
	 * @param  MyBiddingGRPVO myBiddingGRPVO
	 * @return MyBiddingGRPVO 
	 * @exception EventException   
	 */ 
	public MyBiddingGRPVO searchMyBiddingHdrListBasic(MyBiddingGRPVO myBiddingGRPVO) throws EventException;

	/**
	 * [EES_MNR_S304] My Bidding List 디테일 목록을 조회합니다.<br>
	 *
	 * @param MyBiddingGRPVO myBiddingGRPVO
	 * @return MyBiddingGRPVO
	 * @exception EventException
	 */
	public MyBiddingGRPVO searchMyBiddingDtlListBasic(MyBiddingGRPVO myBiddingGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_S304] My Bidding List 디테일 목록을 저장합니다.<br>
	 *
	 * @param MyBiddingGRPVO myBiddingGRPVO
	 * @param SignOnUserAccount account
	 * @return MyBiddingGRPVO
	 * @exception EventException
	 */
	public MyBiddingGRPVO manageMyBiddingDtlListBasic(MyBiddingGRPVO myBiddingGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_S304] My Bidding List 디테일 목록을 삭제합니다.<br>
	 *
	 * @param MyBiddingGRPVO myBiddingGRPVO
	 * @param SignOnUserAccount account
	 * @return MyBiddingGRPVO
	 * @exception EventException
	 */
	public MyBiddingGRPVO removeMyBiddingDtlListBasic(MyBiddingGRPVO myBiddingGRPVO, SignOnUserAccount account) throws EventException;
	

	/**
	 * [EES_MNR_S304] My Bidding List의  Local Time을 조회 합니다.<br>
	 *
	 * @param MyBiddingGRPVO myBiddingGRPVO
	 * @param SignOnUserAccount account
	 * @return MyBiddingGRPVO
	 * @exception EventException
	 */
	public MyBiddingGRPVO searchMyBiddingLoaclTimeListBasic(MyBiddingGRPVO myBiddingGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0251] Sold Cancellation의 Detail Information을 조회 합니다.<br>
	 * 
	 * @param DisposalSoldINVO	disposalSoldINVO
	 * @return List<CustomMnrDispCancelVO>
	 * @exception EventException
	 */
	public List<CustomMnrDispCancelVO> searchDisposalSoldCancelListBasic(DisposalSoldINVO disposalSoldINVO) throws EventException;
	
	/**
	 * [EES_MNR_S304] 선택된 Bidding No의 Bidding Status을 조회합니다.<br>
	 * 
	 * @param MyBiddingINVO myBiddingINVO
	 * @return List<CustomMyBiddingHdrVO>
	 * @exception EventException
	 */
	public List<CustomMyBiddingHdrVO> searchMyBiddingStatus(MyBiddingINVO myBiddingINVO) throws EventException;
	
	/**
	 * [EES_MNR_0161]Cancelled Disposal Invoice history 정보를 저장한다.  
	 * @param receivableInvoiceGRPVO
	 * @throws EventException
	 */
	public void addDisposalHRDCancelledBasic(ReceivableInvoiceGRPVO receivableInvoiceGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0161]Cancelled Disposal Invoice history 정보를 저장한다.
	 * @param receivableInvoiceGRPVO
	 * @throws EventException
	 */
	public void addDisposalDTLCancelledBasic(ReceivableInvoiceGRPVO receivableInvoiceGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0256]Disposal Cancelled Invoice Inquiry의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalInquiryGRPVO disposalInquiryGRPVO
	 * @return DisposalInquiryGRPVO
	 * @exception EventException
	 */
	public DisposalInquiryGRPVO searchDisposalCancelledInquiryListBasic(DisposalInquiryGRPVO disposalInquiryGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0256]Disposal Cancelled Invoice Detail의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalInquiryGRPVO disposalInquiryGRPVO
	 * @return DisposalInquiryGRPVO
	 * @exception EventException
	 */
	public DisposalInquiryGRPVO searchDisposalDetailCancelledInquiryListBasic(DisposalInquiryGRPVO disposalInquiryGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0261] Disposal Inquiry 화면에서 not pick-up 된 장비 pop up list를 조회합니다.<br>
	 * 
	 * @param DisposalNVO disposalNVO
	 * @return List<CustomMnrDispNoPickUpVO>
	 * @throws EventException
	 */
	public List<CustomMnrDispNoPickUpVO> searchDisposalNoPickUpListBasic(DisposalNVO disposalNVO) throws EventException;
	
	/**
	 * [EES_MNR_0159]Disposal No 정보를 체크합니다. <br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @return DisposalGRPVO
	 * @exception EventException
	 */ 
	public DisposalGRPVO searchVerifyDisposalNoBasic(DisposalGRPVO disposalGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0156]Disposal No 중복체크를 합니다 <br>
	 *
	 * @param DisposalGRPVO disposalGRPVO 
	 * @return DisposalGRPVO
	 * @exception EventException
	 */
	public DisposalGRPVO searchDisposalNoDubChkBasic(DisposalGRPVO disposalGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0159]Disposal Contract 메일보낼 리스트 조회 <br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @return DisposalGRPVO
	 * @exception EventException
	 */ 
	public DisposalGRPVO searchDispContractMailListBasic(DisposalGRPVO disposalGRPVO) throws EventException;
}