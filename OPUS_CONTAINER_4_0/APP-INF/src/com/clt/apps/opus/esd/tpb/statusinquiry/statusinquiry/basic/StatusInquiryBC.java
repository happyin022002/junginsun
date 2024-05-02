/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StatusInquiryBC.java
*@FileTitle : StatusInquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.basic;

import java.util.List;

import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.event.EsdTpb0135Event;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.vo.SearchActivityByClosingTPBVO;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.vo.SearchActivityByConfirmedTPBVO;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.vo.SearchInformationOnPendingTPBVO;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.vo.SearchStatusByTPBBKGVO;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.vo.SearchStatusByTPBVO;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.vo.SearchTPBDetailInfoVO;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.vo.SearchTPBDetailListVO;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.vo.SearchTPBInvoiceListVO;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.vo.SearchTPBStatusByBkgNoVO;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.vo.SearchTPBStatusSummaryVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * -StatusInquirymanage Business Logic Command Interface<br>
 * - -StatusInquirymanage business logic interface<br>
 *
 * @author 
 * @see Esd_tpb_105EventResponse reference
 * @since J2EE 1.6
 */

public interface StatusInquiryBC {
	/**
	 * <br>
	 * 
	 * @param SearchTPBDetailInfoVO searchTPBDetailInfoVO
	 * @return List<SearchTPBDetailInfoVO>
	 * @exception EventException
	 */
	public List<SearchTPBDetailInfoVO> searchTPBDetailInfo(SearchTPBDetailInfoVO searchTPBDetailInfoVO) throws EventException;
	/**
	 * <br>
	 * 
	 * @param SearchTPBDetailListVO searchTPBDetailListVO
	 * @return List<SearchTPBDetailListVO>
	 * @exception EventException
	 */
	public List<SearchTPBDetailListVO> searchTPBDetailList(SearchTPBDetailListVO searchTPBDetailListVO) throws EventException;
	/**
	 * <br>
	 * 
	 * @param SearchStatusByTPBVO	searchStatusByTPBVO
	 * @return List<SearchStatusByTPBVO>
	 * @exception EventException
	 */
	public List<SearchStatusByTPBVO> searchStatusByTPB(SearchStatusByTPBVO searchStatusByTPBVO) throws EventException;
	/**
	 * <br>
	 * 
	 * @param SearchStatusByTPBBKGVO	searchStatusByTPBBKGVO
	 * @return List<SearchStatusByTPBBKGVO>
	 * @exception EventException
	 */
	public List<SearchStatusByTPBBKGVO> searchStatusByTPBBKG(SearchStatusByTPBBKGVO searchStatusByTPBBKGVO) throws EventException;
	/**
	 * <br>
	 * 
	 * @param SearchTPBStatusSummaryVO searchTPBStatusSummaryVO
	 * @param SignOnUserAccount account
	 * @return List<SearchTPBStatusSummaryVO>
	 * @exception EventException
	 */
	public List<SearchTPBStatusSummaryVO> searchTPBStatusSummary(SearchTPBStatusSummaryVO searchTPBStatusSummaryVO, SignOnUserAccount account) throws EventException;
	/**
	 * <br>
	 * 
	 * @param SearchTPBInvoiceListVO searchTpbInvoiceListVO
	 * @return List<SearchTPBInvoiceListVO>
	 * @exception EventException
	 */
	public List<SearchTPBInvoiceListVO> searchInvoiceList(SearchTPBInvoiceListVO searchTpbInvoiceListVO) throws EventException;
	/**
	 * <br>
	 * 
	 * @param SearchInformationOnPendingTPBVO searchInformationOnPendingTPBVO
	 * @return List<SearchInformationOnPendingTPBVO>
	 * @exception EventException
	 */
	public List<SearchInformationOnPendingTPBVO> searchInformationOnPendingTPB(SearchInformationOnPendingTPBVO searchInformationOnPendingTPBVO) throws EventException;
	
	/**
	 * getting status by BKG_NO<br>
	 * 
	 * @param SearchTPBStatusByBkgNoVO searchTpbStatusByBkgNoVO
	 * @return String
	 * @exception EventException
	 */
	public String searchTpbStatusByBkgNo(SearchTPBStatusByBkgNoVO searchTpbStatusByBkgNoVO) throws EventException;
	
	/**
	 * retrieving TPB Confirmed<br>
	 * 
	 * @param SearchActivityByConfirmedTPBVO searchActivityByConfirmedTPBVO
	 * @return List<SearchActivityByConfirmedTPBVO>
	 * @exception EventException
	 */
	public List<SearchActivityByConfirmedTPBVO> searchActivityByConfirmedTPB(SearchActivityByConfirmedTPBVO searchActivityByConfirmedTPBVO) throws EventException;
	
	/**
	 * retrieving TPB Closed<br>
	 * 
	 * @param SearchActivityByClosingTPBVO searchActivityByClosingTPBVO
	 * @return List<SearchActivityByClosingTPBVO>
	 * @exception EventException
	 */
	public List<SearchActivityByClosingTPBVO> searchActivityByClosingTPB(SearchActivityByClosingTPBVO searchActivityByClosingTPBVO) throws EventException;
	
	/**
	 * retrieving Control Office<br>
	 * 
	 * @param EsdTpb0135Event event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchControlOffice(EsdTpb0135Event event) throws EventException;
	
	/**
	 * retrieving RHQ Office list<br>
	 * 
	 * @param EsdTpb0135Event event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchHandleRHQList(EsdTpb0135Event event) throws EventException;
	
	/**
	 * retrieving Control Office list<br>
	 * 
	 * @param EsdTpb0135Event event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchControlOfficeList(EsdTpb0135Event event) throws EventException;
	
	/**
	 * retrieving TPB Office list<br>
	 * 
	 * @param EsdTpb0135Event event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTPBOfficeList(EsdTpb0135Event event) throws EventException;
	

}