/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CustomerEdiBC.java
*@FileTitle : Customer EDI Data Management
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.basic;

import java.util.List;

import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315SendVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.CustomerEdiDBDAOOptionsVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.CustomerInqChoiceVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.GetMyPerformanceSelectVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchCargoTrackingDataOptionsVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchComboPerformanceVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchCsInfoVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchCustStsVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomTpIdVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomerDataVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomerInfoVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomerInqueryVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchEDIPerformanceOptionsVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchEdiActivityInquiryDataOptionsVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchEdiStatusDataVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchEdiSummaryReportOptionsVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchMissingListVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchMyCustomerVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchMyPerformanceVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchPerCsInfoVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchPerRepPupModiVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchStsListVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchVesselSkdOptionsVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;


/**
 * SCEM Business Logic Command Interface<br>
 *
 * @author 
 * @see EdiSendEventResponse
 * @since J2EE 1.4
 */
public interface CustomerEdiBC {

    /**
     * retrieving EDI Customer Data
     * @param CustomerEdiDBDAOOptionsVO cusEdiOpt
     * @return List<SearchCustomerDataVO>
     * @throws EventException
     */
	public List<SearchCustomerDataVO> searchCustomerData(CustomerEdiDBDAOOptionsVO cusEdiOpt) throws EventException;
  
    /**
     * retrieving My Performance
     * @param SearchEDIPerformanceOptionsVO schEdOpts
     * @return List<GetMyPerformanceSelectVO>
     * @throws EventException
     */
	public List<GetMyPerformanceSelectVO> getMyPerformance(SearchEDIPerformanceOptionsVO schEdOpts) throws EventException;
	
    /**
     * retrieving EDI Status Data
     * @param CustomerEdiDBDAOOptionsVO cusEdiOpt
     * @return List<SearchEdiStatusDataVO>
     * @throws EventException
     */
	  public List<SearchEdiStatusDataVO> searchEdiStatusData(CustomerEdiDBDAOOptionsVO cusEdiOpt) throws EventException;

    /**
     * retrieving Cargo Tracking EDI Save/Send - Individual Data
     * @param SearchCargoTrackingDataOptionsVO schCtdOpts
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse searchCargoTrackingData(SearchCargoTrackingDataOptionsVO schCtdOpts) throws EventException;


    /**
     * retrieving EDI Search Activity Inquiry Data
     * @param SearchEdiActivityInquiryDataOptionsVO schEAIDOpts
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse searchEdiActivityInquiryData(SearchEdiActivityInquiryDataOptionsVO schEAIDOpts)  throws EventException;
    
    /**
     * retrieving Edi Summary Report List
     * @param SearchEdiSummaryReportOptionsVO schSROptsVO
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse searchEdiSummaryReport(SearchEdiSummaryReportOptionsVO schSROptsVO) throws EventException;    
    
    /**
     * EDI Customer Inquiry data Search<br>
     * EsdSce0062  <br>
     *                         
     * @param CustomerInqChoiceVO custInq
     * @return List<SearchCustomerInqueryVO> 
     * @exception EventException
     */
    public List<SearchCustomerInqueryVO> searchCustomerInquery(CustomerInqChoiceVO custInq) throws EventException;
    
    /**
     * EDI Customer Inquiry data Search count<br>
     * EsdSce0062  <br>
     *                         
     * @param CustomerInqChoiceVO custInq
     * @return EventResponse 
     * @exception EventException
     */
    public EventResponse searchCustomercnt(CustomerInqChoiceVO custInq) throws EventException;
    
    /**
     * EDI Customer Inquiry data save<br>
     * EsdSce0062  <br>
     *                         updateCustomerInquery
     * @param Event e
     * @return EventResponse 
     * @exception EventException
     */
    public EventResponse updateCustomerInquery(Event e) throws EventException;
    
    /**
     * customer tp id data search<br>
     * EsdSce0062  <br>
     * 
     * @param SearchEDIPerformanceOptionsVO schEpOpts
     * @return List<SearchCustomTpIdVO> 
     * @exception EventException
     */
    public List<SearchCustomTpIdVO> searchCustomTpId(SearchEDIPerformanceOptionsVO schEpOpts)  throws EventException;
    
    /**
     * retrieving Edi Detail Report - Mvmt List
     * @param SearchEdiSummaryReportOptionsVO schSROptsVO
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse searchDetailMvmtReport(SearchEdiSummaryReportOptionsVO schSROptsVO) throws EventException;    
    
    /**
     * retrieving Edi Detail Report - Other List
     * @param SearchEdiSummaryReportOptionsVO schSROptsVO
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse searchDetailOtherReport(SearchEdiSummaryReportOptionsVO schSROptsVO) throws EventException;    
    
    /**
     * retrieving EDI Customer Information
     * @param SearchEdiSummaryReportOptionsVO schSROptsVO
     * @return List<SearchCsInfoVO>
     * @throws EventException
     */
    public List<SearchCsInfoVO> searchCsInfo(SearchEdiSummaryReportOptionsVO schSROptsVO) throws EventException;

    /**
	 * retrieving vvd list include period.
	 * 
	 * @param SearchVesselSkdOptionsVO schVSlVO
	 * @return EventResponse
	 * @exception EventException
	 */
    public EventResponse searchVvdList(SearchVesselSkdOptionsVO schVSlVO) throws EventException;
	
	/**
	 * retrieving EDI Sedn Status by customer.
	 * 
	 * @param SearchEDIPerformanceOptionsVO schEpOpts
	 * @return response EsdSce0063EventResponse
	 * @exception EventException
	 */
	public List<SearchStsListVO> searchStsList(SearchEDIPerformanceOptionsVO schEpOpts)  throws EventException;
	
	/**
	 * retrieving EDI Performance Missing
	 * 
	 * @param SearchEDIPerformanceOptionsVO schEpOpts
	 * @return response EsdSce0072EventResponse
	 * @exception EventException
	 */
	public EventResponse searchEDIPerformance(SearchEDIPerformanceOptionsVO schEPOpts)  throws EventException;
	
	/**
	 * retrieving EDI Total Performance on-time-performance
	 * 
	 * @param SearchEDIPerformanceOptionsVO schEPOpts
	 * @return response EsdSce0072EventResponse
	 * @exception EventException
	 */
	public EventResponse searchEDITotalPerformance(SearchEDIPerformanceOptionsVO schEPOpts)  throws EventException;
	
	/**
	 * retrieving EDI Total Performance Combo List
	 * 
	 * @param SearchEDIPerformanceOptionsVO custOpts
	 * @return response EsdSce0073EventResponse
	 * @exception EventException
	 */
	public List<SearchComboPerformanceVO> searchComboPerformance(SearchEDIPerformanceOptionsVO custOpts) throws EventException;
	
	/**
	 * retrieving EDI performance List
	 * 
	 * @param SearchEDIPerformanceOptionsVO custOpts
	 * @return response EsdSce0073EventResponse
	 * @exception EventException
	 */
	public List<SearchCustStsVO> searchCustSts(SearchEDIPerformanceOptionsVO custOpts)  throws EventException;
	
    /**
     * retrieving EDI PERFORMANCE Customer Information
     * @param SearchEDIPerformanceOptionsVO schEPOpts
     * @return EventResponse
     * @throws EventException
     */
	public List<SearchPerCsInfoVO> searchPerCsInfo(SearchEDIPerformanceOptionsVO schEPOpts)throws EventException;
    
    /**
     * retrieving EDI Customer TP ID Information
     * @param SearchEDIPerformanceOptionsVO custOpts
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse searchPerCsTpIdInfo(SearchEDIPerformanceOptionsVO custOpts) throws EventException;
    
    /**
     * retrieving EDI Customer TP ID Information
     * @param SearchEDIPerformanceOptionsVO custOpts
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse searchPerCsTpIdInfo1(SearchEDIPerformanceOptionsVO custOpts) throws EventException;
    
    /**
     * retrieving Missing List popup
     * @param SearchMissingListVO searchMissingListVo
     * @return List<SearchMissingListVO>
     * @throws EventException
     */
    public List<SearchMissingListVO> searchMissingList(SearchMissingListVO searchMissingListVo) throws EventException;
    
    /**
     * retrieving On-Time List popup
     * @param SearchMissingListVO searchOnTimeListVo
     * @return List<SearchMissingListVO>
     * @throws EventException
     */
    public List<SearchMissingListVO> searchOnTimeList(SearchMissingListVO searchOnTimeListVo) throws EventException;
    
    
    /**
     * retrieving Missing List
     * @param SearchMissingListVO searchMissingListVo
     * @return List<SearchMissingListVO>
     * @throws EventException
     */
    public List<SearchMissingListVO> searchDetailMissingList(SearchMissingListVO searchMissingListVo) throws EventException;

    /**
     * retrieving My Performance Report
     * @param SearchCustomerInfoVO myCustInfo
     * @return List<SearchPerRepPupModiVO>
     * @throws EventException
     */
    public List<SearchPerRepPupModiVO> searchPerRepPupModi(SearchCustomerInfoVO myCustInfo) throws EventException;
    
    /**
     * retrieving My Performance Report 
     * @param CustomerInqChoiceVO perMod
     * @param CustomerInqChoiceVO[] perMods
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse updatePerformanceCnt(CustomerInqChoiceVO perMod, CustomerInqChoiceVO[] perMods, Event e) throws EventException;
    
    /**
     * update My Performance Report
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse updatePerformance(Event e) throws EventException;
    
    /**
     * update My Performance Report
     * @param e
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse updatePerformanceModify(Event e) throws EventException;
    
    /**
     * retrieving My page - My Customer
     * @param String str
     * @return List<SearchMyCustomerVO>
     * @throws EventException
     */
    public List<SearchMyCustomerVO> searchMyCustomer(String str) throws EventException;
    
    /**
     * retrieving My page - My Performance Report
     * @param str
     * @return List<SearchMyPerformanceVO>
     * @throws EventException
     */
    public List<SearchMyPerformanceVO> searchMyPerformance(String str) throws EventException;
    
    /**
     * retrieving My page - My Cutomer
     * @param e
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse deleteMyCustomer(Event e) throws EventException;
    
    /**
     * retrieving My page - My Performace
     * @param e
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse deleteMyPerformance(Event e) throws EventException;
    
    /**
     * retrieving location from send EDI(manual) 
     * @param List<Edi315SendVO> list
     * @param boolean ibflgChk
     * @return String
     * @throws EventException
     */
    public String searchMdmLocation(List<Edi315SendVO> list,  boolean ibflgChk) throws EventException;
}
