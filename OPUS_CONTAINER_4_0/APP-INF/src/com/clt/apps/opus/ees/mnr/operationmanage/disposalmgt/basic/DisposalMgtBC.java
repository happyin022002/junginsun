/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DisposalMgtBC.java
*@FileTitle : Disposal
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.basic;

import java.util.List;

import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.DisposalGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.DisposalInquiryGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.DisposalSoldGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.MyBiddingGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.MyBiddingINVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.CustomMyBiddingHdrVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
 	
/**	
 * COM-Operation manage Business Logic Command Interface<br>
 * - COM-Operation manage interface of business logic<br>
 *
 * @author
 * @see Ees_mnr_0156EventResponse
 * @since J2EE 1.4	
 */ 
	
public interface DisposalMgtBC {
	
	/**
	 * [EES_MNR_0164]Retrieving "Disposal Request" data<br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @param SignOnUserAccount account 
	 * @return DisposalGRPVO
	 * @exception EventException
	 */
	public DisposalGRPVO searchDisposalListBasic(DisposalGRPVO disposalGRPVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0093]Retrieving "Scraping/Donation Creation" data<br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @return DisposalGRPVO
	 * @exception EventException
	 */
	public DisposalGRPVO searchDSPBuyerDTLPartBasic(DisposalGRPVO disposalGRPVO) throws EventException;
		
	/**
	 * [EES_MNR_0159]Retrieving "Disposal Request" data<br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @return DisposalGRPVO
	 * @exception EventException
	 */
	public DisposalGRPVO searchDisposalMailListBasic(DisposalGRPVO disposalGRPVO) throws EventException;	
	
	/**
	 * [EES_MNR_0159]Retrieving "Disposal Management" data<br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @return DisposalGRPVO
	 * @exception EventException
	 */
	public DisposalGRPVO searchDSPConfirmMailListBasic(DisposalGRPVO disposalGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0200]Retrieving "Disposal Request" data<br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @return DisposalGRPVO
	 * @exception EventException
	 */
	public DisposalGRPVO searchDisposalBasic(DisposalGRPVO disposalGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0159]Modifying "Disposal Management" data<br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalGRPVO
	 * @exception EventException
	 */   
	public DisposalGRPVO reBiddingDisposalBasic(DisposalGRPVO disposalGRPVO, SignOnUserAccount account) throws EventException;  
	
	/**
	 * [EES_MNR_0159]Modifying "Disposal Management" data<br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalGRPVO
	 * @exception EventException
	 */
	public DisposalGRPVO confirmDisposalBasic(DisposalGRPVO disposalGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0157]Adding, modifying, deleting "Disposal Request" data<br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalGRPVO
	 * @exception EventException
	 */
	public DisposalGRPVO manageDisposalBasic(DisposalGRPVO disposalGRPVO, SignOnUserAccount account) throws EventException;
	 
	/**
	 * [EES_MNR_0159]Deleting "Disposal Request"" data<br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalGRPVO
	 * @exception EventException
	 */
	public DisposalGRPVO removeDisposalBasic(DisposalGRPVO disposalGRPVO, SignOnUserAccount account) throws EventException; 
	
	/**
	* [EES_MNR_0157]Adding "Disposal Request" data<br>
	*
	* @param DisposalGRPVO disposalGRPVO
	* @exception EventException
	*/
	public void addContractDisposalBuyerDTLBasic(DisposalGRPVO disposalGRPVO) throws EventException;

	/**
	 * [EES_MNR0160] Retrieving "Disposal Sold Creation" header list<br>
	 * @param DisposalSoldGRPVO disposalSoldGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalSoldGRPVO
	 * @exception EventException
	 */
	public DisposalSoldGRPVO searchDisposalSoldListBasic(DisposalSoldGRPVO disposalSoldGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0160]Retrieving "Disposal Sold Creation" data<br>
	 *
	 * @param DisposalSoldGRPVO disposalSoldGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalSoldGRPVO
	 * @exception EventException
	 */
	public DisposalSoldGRPVO searchDisposalSoldDetailBasic(DisposalSoldGRPVO disposalSoldGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0163]Retrieving "Disposal Invoice Inquiry" data<br>
	 * @param DisposalInquiryGRPVO disposalInquiryGRPVO
	 * @return DisposalInquiryGRPVO
	 * @exception EventException
	 */
	public DisposalInquiryGRPVO searchDisposalInquiryListBasic(DisposalInquiryGRPVO disposalInquiryGRPVO) throws EventException;

	/**
	 * [EES_MNR_0163]Retrieving "Disposal Invoice Detail" data<br>
	 * @param DisposalInquiryGRPVO disposalInquiryGRPVO
	 * @return DisposalInquiryGRPVO
	 * @exception EventException
	 */
	public DisposalInquiryGRPVO searchDisposalDetailInquiryListBasic(DisposalInquiryGRPVO disposalInquiryGRPVO) throws EventException;

	/**
	 * [EES_MNR_0163]Retrieving "Disposal Invoice Collection" data<br>
	 * @param DisposalInquiryGRPVO disposalInquiryGRPVO
	 * @return DisposalInquiryGRPVO
	 * @exception EventException
	 */
	public DisposalInquiryGRPVO searchDisposalCollectionInquiryListBasic(DisposalInquiryGRPVO disposalInquiryGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0160]Adding, modifying, deleting "Disposal Sold Creation" data<br>
	 *
	 * @param DisposalSoldGRPVO disposalSoldGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDisposalSoldBasic(DisposalSoldGRPVO disposalSoldGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0160]Retrieving the data of created "ReleaseNo"<br>
	 *
	 * @param SignOnUserAccount account
	 * @return DisposalSoldGRPVO
	 * @exception EventException
	 */          
	public DisposalSoldGRPVO searchDispRlseNoBasic(SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0157,0159]Modifying data sum when "Disposal the data confirm"<br> 
	 * 
	 * @param DisposalGRPVO disposalGRPVO
	 * @exception EventException
	 */
	public void addDisposalCofirmSumBasic(DisposalGRPVO disposalGRPVO) throws EventException;

	/**
	 * [EES_MNR_0161]Deleting "Disposal Invoice Issue" data<br>
	 * 
	 * @param DisposalGRPVO disposalGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException  
	 */
	public void modifyDisposalInvoiceLinkClearBasic(DisposalGRPVO disposalGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0161]Modifying "Disposal Invoice Issue" data<br>
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
	 * [EES_MNR_S304] 선택된 Bidding No의 Bidding Status을 조회합니다.<br>
	 * 
	 * @param MyBiddingINVO myBiddingINVO
	 * @return List<CustomMyBiddingHdrVO>
	 * @exception EventException
	 */          
	public List<CustomMyBiddingHdrVO> searchMyBiddingStatus(MyBiddingINVO myBiddingINVO) throws EventException;
	
	
}