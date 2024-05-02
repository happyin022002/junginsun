/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StatusInquiryBC.java
*@FileTitle : StatusInquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 황건하
*@LastVersion : 1.0
* 2009.07.17 황건하
* 1.0 Creation
* 2010.11.17 손은주 [CHM-201006809-01]	[TPB] TPB Activity기간별 TPB 조회 기능
* 2010-11-18  손은주 [CHM-201006809-01][TPB] TPB Activity기간별 TPB 조회 기능 - office 관련 select box 수정
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.event.EsdTpb0135Event;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.vo.EmailFaxSentHistVO;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.vo.SearchActivityByClosingTPBVO;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.vo.SearchActivityByConfirmedTPBVO;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.vo.SearchInformationOnPendingTPBVO;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.vo.SearchStatusByTPBVO;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.vo.SearchStatusByTPBBKGVO;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.vo.SearchTPBDetailInfoVO;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.vo.SearchTPBDetailListVO;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.vo.SearchTPBStatusSummaryVO;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.vo.SearchTPBInvoiceListVO;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.vo.SearchTPBStatusByBkgNoVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-StatusInquirymanage Business Logic Command Interface<br>
 * - ALPS-StatusInquirymanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author GUN-HA HWANG
 * @see Esd_tpb_105EventResponse 참조
 * @since J2EE 1.6
 */

public interface StatusInquiryBC {
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchTPBDetailInfoVO searchTPBDetailInfoVO
	 * @return List<SearchTPBDetailInfoVO>
	 * @exception EventException
	 */
	public List<SearchTPBDetailInfoVO> searchTPBDetailInfo(SearchTPBDetailInfoVO searchTPBDetailInfoVO) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchTPBDetailListVO searchTPBDetailListVO
	 * @return List<SearchTPBDetailListVO>
	 * @exception EventException
	 */
	public List<SearchTPBDetailListVO> searchTPBDetailList(SearchTPBDetailListVO searchTPBDetailListVO) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchStatusByTPBVO	searchStatusByTPBVO
	 * @return List<SearchStatusByTPBVO>
	 * @exception EventException
	 */
	public List<SearchStatusByTPBVO> searchStatusByTPB(SearchStatusByTPBVO searchStatusByTPBVO) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchStatusByTPBBKGVO	searchStatusByTPBBKGVO
	 * @return List<SearchStatusByTPBBKGVO>
	 * @exception EventException
	 */
	public List<SearchStatusByTPBBKGVO> searchStatusByTPBBKG(SearchStatusByTPBBKGVO searchStatusByTPBBKGVO) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchTPBStatusSummaryVO searchTPBStatusSummaryVO
	 * @param SignOnUserAccount account
	 * @return List<SearchTPBStatusSummaryVO>
	 * @exception EventException
	 */
	public List<SearchTPBStatusSummaryVO> searchTPBStatusSummary(SearchTPBStatusSummaryVO searchTPBStatusSummaryVO, SignOnUserAccount account) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchTPBInvoiceListVO searchTpbInvoiceListVO
	 * @return List<SearchTPBInvoiceListVO>
	 * @exception EventException
	 */
	public List<SearchTPBInvoiceListVO> searchInvoiceList(SearchTPBInvoiceListVO searchTpbInvoiceListVO) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchInformationOnPendingTPBVO searchInformationOnPendingTPBVO
	 * @return List<SearchInformationOnPendingTPBVO>
	 * @exception EventException
	 */
	public List<SearchInformationOnPendingTPBVO> searchInformationOnPendingTPB(SearchInformationOnPendingTPBVO searchInformationOnPendingTPBVO) throws EventException;
	
	/**
	 * BKG_NO으로 상태를 가져옵니다.<br>
	 * 
	 * @param SearchTPBStatusByBkgNoVO searchTpbStatusByBkgNoVO
	 * @return String
	 * @exception EventException
	 */
	public String searchTpbStatusByBkgNo(SearchTPBStatusByBkgNoVO searchTpbStatusByBkgNoVO) throws EventException;
	
	/**
	 * 해당점소의 조회기간내에 Confirm된 TPB를 조회합니다.<br>
	 * 
	 * @param SearchActivityByConfirmedTPBVO searchActivityByConfirmedTPBVO
	 * @return List<SearchActivityByConfirmedTPBVO>
	 * @exception EventException
	 */
	public List<SearchActivityByConfirmedTPBVO> searchActivityByConfirmedTPB(SearchActivityByConfirmedTPBVO searchActivityByConfirmedTPBVO) throws EventException;
	
	/**
	 * 해당점소의 조회기간내에 Close된 TPB를 조회합니다.<br>
	 * 
	 * @param SearchActivityByClosingTPBVO searchActivityByClosingTPBVO
	 * @return List<SearchActivityByClosingTPBVO>
	 * @exception EventException
	 */
	public List<SearchActivityByClosingTPBVO> searchActivityByClosingTPB(SearchActivityByClosingTPBVO searchActivityByClosingTPBVO) throws EventException;
	
	/**
	 * 해당점소의 Control Office를 조회합니다.<br>
	 * 
	 * @param EsdTpb0135Event event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchControlOffice(EsdTpb0135Event event) throws EventException;
	
	/**
	 * RHQ Office 목록을 조회합니다.<br>
	 * 
	 * @param EsdTpb0135Event event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchHandleRHQList(EsdTpb0135Event event) throws EventException;
	
	/**
	 * Control Office 목록을 조회합니다.<br>
	 * 
	 * @param EsdTpb0135Event event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchControlOfficeList(EsdTpb0135Event event) throws EventException;
	
	/**
	 * TPB Office 목록을 조회합니다.<br>
	 * 
	 * @param EsdTpb0135Event event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTPBOfficeList(EsdTpb0135Event event) throws EventException;
	
	/**
	 * Email/Fax 전송내역을 조회합니다.<br>
	 * 
	 * @param EmailFaxSentHistVO emailFaxSentHistVO
	 * @return List<EmailFaxSentHistVO>
	 * @exception EventException
	 */
	public List<EmailFaxSentHistVO> searchEmailFaxSentHistoryList(EmailFaxSentHistVO emailFaxSentHistVO) throws EventException;


}