/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StatusInquiryBCImpl.java
*@FileTitle : StatusInquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.basic;

import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.esd.tpb.common.combo.event.CommonCodeEvent;
import com.clt.apps.opus.esd.tpb.common.combo.integration.CommonCodeDBDAO;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.event.EsdTpb0135Event;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.integration.StatusInquiryDBDAO;
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
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/** 
 * -StatusInquiryManage Business Logic Basic Command implementation<br>
 * - -StatusInquiryManage business logic interface<br>
 *
 * @author 
 * @see EventResponse,StatusInquiryBC DAO class reference
 * @since J2EE 1.6
 */
public class StatusInquiryBCImpl extends BasicCommandSupport implements StatusInquiryBC {

	// Database Access Object
	private transient StatusInquiryDBDAO dbDao = null;
	private transient CommonCodeDBDAO comCdDbDao = null;
	/**
	 * StatusInquiryBCImpl object creation<br>
	 * StatusInquiryDBDAO creation<br>
	 */
	public StatusInquiryBCImpl() {
		dbDao = new StatusInquiryDBDAO();
		comCdDbDao = new CommonCodeDBDAO();
	}
	
	/**
	 * <br>
	 * 
	 * @param SearchTPBDetailInfoVO searchTPBDetailInfoVO
	 * @return List<SearchTPBDetailInfoVO>
	 * @exception EventException
	 */
	public List<SearchTPBDetailInfoVO> searchTPBDetailInfo(SearchTPBDetailInfoVO searchTPBDetailInfoVO) throws EventException {
//		SearchTPBDetailInfoVO stdVO = searchTPBDetailInfoVO;
//		String s_ofc_cd = stdVO.getOfcCd();
//		log.debug("s_ofc_cd_BC_IMPL===========>"+s_ofc_cd);
		try {
			return dbDao.searchTPBDetailInfo(searchTPBDetailInfoVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * <br>
	 * 
	 * @param SearchTPBDetailListVO searchTPBDetailListVO
	 * @return List<SearchTPBDetailListVO>
	 * @exception EventException
	 */
	public List<SearchTPBDetailListVO> searchTPBDetailList(SearchTPBDetailListVO searchTPBDetailListVO) throws EventException {
		try {
			return dbDao.searchTPBDetailList(searchTPBDetailListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * <br>
	 * 
	 * @param SearchStatusByTPBVO searchStatusByTPBVO
	 * @return List<SearchStatusByTPBVO>
	 * @exception EventException
	 */
	public List<SearchStatusByTPBVO> searchStatusByTPB(SearchStatusByTPBVO searchStatusByTPBVO) throws EventException {
//		SearchStatusByTPBVO stsVO = searchStatusByTPBVO;
//		String s_ots_sts_cd = stsVO.getSOtsStsCd();
//		log.debug("s_ots_sts_cd_BC_IMPL===========>"+s_ots_sts_cd);
		try {
			return dbDao.searchStatusByTPB(searchStatusByTPBVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * <br>
	 * 
	 * @param SearchStatusByTPBBKGVO searchStatusByTPBBKGVO
	 * @return List<SearchStatusByTPBBKGVO>
	 * @exception EventException
	 */
	public List<SearchStatusByTPBBKGVO> searchStatusByTPBBKG(SearchStatusByTPBBKGVO searchStatusByTPBBKGVO) throws EventException {
		try {
			return dbDao.searchStatusByTPBBKG(searchStatusByTPBBKGVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * <br>
	 * 
	 * @param SearchTPBStatusSummaryVO searchTPBStatusSummaryVO
	 * @param account SignOnUserAccount
	 * @return List<SearchTPBStatusSummaryVO>
	 * @exception EventException
	 */
	public List<SearchTPBStatusSummaryVO> searchTPBStatusSummary(SearchTPBStatusSummaryVO searchTPBStatusSummaryVO, SignOnUserAccount account) throws EventException {
		try {
			searchTPBStatusSummaryVO.setUserOfcCd(account.getOfc_cd());
			return dbDao.searchTPBStatusSummary(searchTPBStatusSummaryVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * <br>
	 * 
	 * @param SearchTPBInvoiceListVO searchTpbInvoiceListVO
	 * @return List<SearchTPBInvoiceListVO>
	 * @exception EventException
	 */
	public List<SearchTPBInvoiceListVO> searchInvoiceList(SearchTPBInvoiceListVO searchTpbInvoiceListVO) throws EventException {
		try {
			return dbDao.searchInvoiceList(searchTpbInvoiceListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * <br>
	 * @param SearchInformationOnPendingTPBVO searchInformationOnPendingTPBVO
	 * @return List<SearchInformationOnPendingTPBVO>
	 * @exception EventException
	 */
	public List<SearchInformationOnPendingTPBVO> searchInformationOnPendingTPB(SearchInformationOnPendingTPBVO searchInformationOnPendingTPBVO) throws EventException {
		try {
			return dbDao.searchInformationOnPendingTPB(searchInformationOnPendingTPBVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * getting status by BKG_NO<br>
	 * 
	 * @param SearchTPBStatusByBkgNoVO searchTpbStatusByBkgNoVO
	 * @return String
	 * @exception EventException
	 */
	public String searchTpbStatusByBkgNo(SearchTPBStatusByBkgNoVO searchTpbStatusByBkgNoVO) throws EventException{

		try {
			return dbDao.searchTpbStatusByBkgNo(searchTpbStatusByBkgNoVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
 
	}
	/**
	 * retrieving TPB Confirmed<br>
	 * @param SearchActivityByConfirmedTPBVO searchActivityByConfirmedTPBVO
	 * @return List<SearchActivityByConfirmedTPBVO>
	 * @exception EventException
	 */
	public List<SearchActivityByConfirmedTPBVO> searchActivityByConfirmedTPB(SearchActivityByConfirmedTPBVO searchActivityByConfirmedTPBVO) throws EventException {
		try {
			return dbDao.searchActivityByConfirmedTPB(searchActivityByConfirmedTPBVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * retrieving TPB Closed<br>
	 * @param SearchActivityByClosingTPBVO searchActivityByClosingTPBVO
	 * @return List<SearchActivityByClosingTPBVO>
	 * @exception EventException
	 */
	public List<SearchActivityByClosingTPBVO> searchActivityByClosingTPB(SearchActivityByClosingTPBVO searchActivityByClosingTPBVO) throws EventException {
		try {
			return dbDao.searchActivityByClosingTPB(searchActivityByClosingTPBVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	
	
	/**
	 * retrieving Control Office<br>
	 * 
	 * @param EsdTpb0135Event event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchControlOffice(EsdTpb0135Event event) throws EventException {
		try {
			CommonCodeEvent comCdEvent = new CommonCodeEvent();
			HashMap<String, Object> params = new HashMap<String, Object>();
			DBRowSet dbRowset = null;
			String ofc_cd = "";
			FormCommand formcommand = event.getFormCommand();
			SearchActivityByConfirmedTPBVO searchActivityByConfirmedTPBVO = event.getSearchActivityByConfirmedTPBVO();
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			
			
			params.put("s_ofc_cd_for_rhq", searchActivityByConfirmedTPBVO.getSOfcCdForRhq());
			params.put("s_if_rhq_cd", searchActivityByConfirmedTPBVO.getSIfRhqCd());			
			params.put("s_office_level", searchActivityByConfirmedTPBVO.getSOfficeLevel());
			
			
			comCdEvent.setEventParams(params);
			//dbRowset = dbDao.searchCtrlOffice(event);
			dbRowset = comCdDbDao.searchCtrlOffice(comCdEvent);
			if(formcommand.isCommand(FormCommand.SEARCH01)){
				while(dbRowset.next()){
					ofc_cd = dbRowset.getString("OFC_CD");
				}
			}
			
			eventResponse.setETCData("USER_CTRL_OFC_CD",ofc_cd);
			return eventResponse;
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * retrieving RHQ Office list<br>
	 * 
	 * @param EsdTpb0135Event event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchHandleRHQList(EsdTpb0135Event event) throws EventException {
		try {
			CommonCodeEvent comCdEvent = new CommonCodeEvent();
			HashMap<String, Object> params = new HashMap<String, Object>();
			DBRowSet dbRowset = null;
			String ofc_cd = "";
			StringBuffer ofc_cd_buf = new StringBuffer();
			FormCommand formcommand = event.getFormCommand();
			SearchActivityByConfirmedTPBVO searchActivityByConfirmedTPBVO = event.getSearchActivityByConfirmedTPBVO();
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			
			params.put("s_ofc_cd_for_rhq", searchActivityByConfirmedTPBVO.getSOfcCdForRhq());
			params.put("s_office_level", searchActivityByConfirmedTPBVO.getSOfficeLevel());
			params.put("s_if_rhq_cd", searchActivityByConfirmedTPBVO.getSIfRhqCd());
			
									
			comCdEvent.setEventParams(params);
			dbRowset = comCdDbDao.searchHandleRHQList(comCdEvent);
			if(formcommand.isCommand(FormCommand.SEARCH02)){
				while(dbRowset.next()){
//					ofc_cd = ofc_cd + "|" + dbRowset.getString("OFC_CD");
					ofc_cd_buf.append("|").append(dbRowset.getString("OFC_CD"));
				}
			}
			ofc_cd = ofc_cd_buf.toString();
			
			eventResponse.setETCData("RHQ_OFC_CD",ofc_cd);
			return eventResponse;
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * retrieving Control Office list<br>
	 * 
	 * @param EsdTpb0135Event event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchControlOfficeList(EsdTpb0135Event event) throws EventException {
		try {
			CommonCodeEvent comCdEvent = new CommonCodeEvent();
			HashMap<String, Object> params = new HashMap<String, Object>();
			DBRowSet dbRowset = null;
			String ofc_cd = "";
			StringBuffer ofc_cd_buf =  new StringBuffer();
			FormCommand formcommand = event.getFormCommand();
			SearchActivityByConfirmedTPBVO searchActivityByConfirmedTPBVO = event.getSearchActivityByConfirmedTPBVO();
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			
			params.put("s_if_rhq_cd", searchActivityByConfirmedTPBVO.getSIfRhqCd());			
			
			comCdEvent.setEventParams(params);
			//dbRowset = dbDao.searchCtrlOffice(event);
			dbRowset = comCdDbDao.searchControlOfficeList(comCdEvent);
			if(formcommand.isCommand(FormCommand.SEARCH03)){
				while(dbRowset.next()){
//					ofc_cd = ofc_cd + "|" + dbRowset.getString("N3PTY_CTRL_OFC_CD");
					ofc_cd_buf.append("|").append(dbRowset.getString("N3PTY_CTRL_OFC_CD"));
				}
			}
			
			ofc_cd = ofc_cd_buf.toString();
			eventResponse.setETCData("CTRL_OFC_CD",ofc_cd);
			return eventResponse;
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * retrieving TPB Office list<br>
	 * 
	 * @param EsdTpb0135Event event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTPBOfficeList(EsdTpb0135Event event) throws EventException {
		try {
			CommonCodeEvent comCdEvent = new CommonCodeEvent();
			HashMap<String, Object> params = new HashMap<String, Object>();
			DBRowSet dbRowset = null;
			String ofc_cd = "";
			StringBuffer ofc_cd_buf =  new StringBuffer();
			FormCommand formcommand = event.getFormCommand();
			SearchActivityByConfirmedTPBVO searchActivityByConfirmedTPBVO = event.getSearchActivityByConfirmedTPBVO();
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			
		
			params.put("s_if_ctrl_cd", searchActivityByConfirmedTPBVO.getSIfCtrlCd());
			
			
			comCdEvent.setEventParams(params);
			//dbRowset = dbDao.searchCtrlOffice(event);
			dbRowset = comCdDbDao.searchTPBOfficeList(comCdEvent);
			if(formcommand.isCommand(FormCommand.SEARCH04)){
				while(dbRowset.next()){
//					ofc_cd = ofc_cd + "|" + dbRowset.getString("OFC_CD");
					ofc_cd_buf.append("|").append(dbRowset.getString("OFC_CD"));
				}
			}
			ofc_cd = ofc_cd_buf.toString();
			
			eventResponse.setETCData("TPB_OFC_CD", ofc_cd);
			return eventResponse;
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
}