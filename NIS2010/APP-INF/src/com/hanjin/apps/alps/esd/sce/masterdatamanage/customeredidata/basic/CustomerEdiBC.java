/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CustomerEdiBC.java
*@FileTitle : Customer EDI Data 관리 및 Control
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-26
*@LastModifier : yongcheon_shin
*@LastVersion : 1.0
* 2006-09-20 yongcheon_shin
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.COPDetailVO;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.SearchSceCopHdrInfoVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315SendVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.CustomerEdiDBDAOOptionsVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.CustomerInqChoiceVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCargoTrackingDataOptionsVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCsInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.GetMyPerformanceSelectVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchComboPerformanceVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCustStsVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomTpIdVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomerDataVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomerInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomerInqueryVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchEDIPerformanceOptionsVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchEdiActivityInquiryDataOptionsVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchEdiStatusDataVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchEdiSummaryReportOptionsVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchEstimationListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchMissingListVO;

import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchPerCsInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchMyCustomerVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchMyPerformanceVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchPerRepPupModiVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchStsListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchVesselSkdOptionsVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ENIS-SCEM Business Logic Command Interface<br>
 * - ENIS-SCEM에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author yongcheonshin
 * @see EdiSendEventResponse 참조
 * @since J2EE 1.4
 */
public interface CustomerEdiBC {

    /**
     * EDI Customer Data 추출
     * @param CustomerEdiDBDAOOptionsVO cusEdiOpt
     * @return List<SearchCustomerDataVO>
     * @throws EventException
     */
	public List<SearchCustomerDataVO> searchCustomerData(CustomerEdiDBDAOOptionsVO cusEdiOpt) throws EventException;
  
    /**
     * My Performance 추출
     * @param SearchEDIPerformanceOptionsVO schEdOpts
     * @return List<GetMyPerformanceSelectVO>
     * @throws EventException
     */
	public List<GetMyPerformanceSelectVO> getMyPerformance(SearchEDIPerformanceOptionsVO schEdOpts) throws EventException;
	
    /**
     * EDI Status Data 추출
     * @param CustomerEdiDBDAOOptionsVO cusEdiOpt
     * @return List<SearchEdiStatusDataVO>
     * @throws EventException
     */
	  public List<SearchEdiStatusDataVO> searchEdiStatusData(CustomerEdiDBDAOOptionsVO cusEdiOpt) throws EventException;
    
    /**
     * EDI Search Send history Data 추출
     * @param e
     * @return EventResponse
     * @throws EventException
     */
    //public EventResponse searchEdiSendingHistory(Event e) throws EventException;
    
    /**
     * Cargo Tracking EDI Save/Send - Individual Data 추출
     * @param SearchCargoTrackingDataOptionsVO schCtdOpts
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse searchCargoTrackingData(SearchCargoTrackingDataOptionsVO schCtdOpts) throws EventException;
    
    /**
     * Cargo Tracking EDI Save/Send - Individual Data 추출
     * @param e
     * @return EventResponse
     * @throws EventException
     */
    //public EventResponse updateCageTrackingSaveSend(Event e) throws EventException;
    
    
    /**
     * EDI Search Send history Data 추출
     * @param e
     * @return EventResponse
     * @throws EventException
     */
    //public EventResponse searchEdiTransportationData(Event e) throws EventException;
    
    
    /**
     * EDI Search Activity Inquiry Data 추출
     * @param SearchEdiActivityInquiryDataOptionsVO schEAIDOpts
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse searchEdiActivityInquiryData(SearchEdiActivityInquiryDataOptionsVO schEAIDOpts)  throws EventException;
    
    /**
     * Edi Summary Report 리스트 조회
     * @param SearchEdiSummaryReportOptionsVO schSROptsVO
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse searchEdiSummaryReport(SearchEdiSummaryReportOptionsVO schSROptsVO) throws EventException;    
    /**
     * EDI Search Document Data 추출
     * @param e
     * @return EventResponse
     * @throws EventException 
     */
    //public EventResponse searchEdiDocumentationData(Event e) throws EventException;
    
    
    /**
     *  Actual 값 Cop detail Setting  호출
     * @param e
     * @return EventResponse
     * @throws EventException
     */
    //public EventResponse actualCopDetail(EsdSce0035Event e) throws EventException;
    
    
    /**
     * EDI Customer Inquiry data Search<br>
     * EsdSce0062 ?? ???? ??? ???? <br>
     *                         
     * @param CustomerInqChoiceVO custInq
     * @return List<SearchCustomerInqueryVO> 
     * @exception EventException
     */
    public List<SearchCustomerInqueryVO> searchCustomerInquery(CustomerInqChoiceVO custInq) throws EventException;
    
    /**
     * EDI Customer Inquiry data Search count<br>
     * EsdSce0062 ?? ???? ??? ???? <br>
     *                         
     * @param CustomerInqChoiceVO custInq
     * @return EventResponse 
     * @exception EventException
     */
    public EventResponse searchCustomercnt(CustomerInqChoiceVO custInq) throws EventException;
    
    /**
     * EDI Customer Inquiry data save<br>
     * EsdSce0062 ?? ???? ??? ???? <br>
     *                         updateCustomerInquery
     * @param Event e
     * @return EventResponse 
     * @exception EventException
     */
    public EventResponse updateCustomerInquery(Event e) throws EventException;
    
    /**
     * customer tp id data search<br>
     * EsdSce0062 ?? ???? ??? ???? <br>
     * 
     * @param SearchEDIPerformanceOptionsVO schEpOpts
     * @return List<SearchCustomTpIdVO> 
     * @exception EventException
     */
    public List<SearchCustomTpIdVO> searchCustomTpId(SearchEDIPerformanceOptionsVO schEpOpts)  throws EventException;
    
    /**
     * Edi Detail Report - Mvmt 리스트 조회
     * @param SearchEdiSummaryReportOptionsVO schSROptsVO
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse searchDetailMvmtReport(SearchEdiSummaryReportOptionsVO schSROptsVO) throws EventException;    
    
    /**
     * Edi Detail Report - Other 리스트 조회
     * @param SearchEdiSummaryReportOptionsVO schSROptsVO
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse searchDetailOtherReport(SearchEdiSummaryReportOptionsVO schSROptsVO) throws EventException;    
    
    /**
     * EDI Customer Information 조회
     * @param SearchEdiSummaryReportOptionsVO schSROptsVO
     * @return List<SearchCsInfoVO>
     * @throws EventException
     */
    public List<SearchCsInfoVO> searchCsInfo(SearchEdiSummaryReportOptionsVO schSROptsVO) throws EventException;
    
    /**
     * EDI Customer TP ID Information 조회
     * @param e
     * @return EventResponse
     * @throws EventException
     */
    //public EventResponse searchCsTpIdInfo(Event e) throws EventException;
    
    
    /**
	 * 해당 기간에 포함 되는 VVD List 조회
	 * 
	 * @param SearchVesselSkdOptionsVO schVSlVO
	 * @return EventResponse
	 * @exception EventException
	 */
    public EventResponse searchVvdList(SearchVesselSkdOptionsVO schVSlVO) throws EventException;
	
	/**
	 * 화주별 EDI 전송 Status 조회
	 * 
	 * @param SearchEDIPerformanceOptionsVO schEpOpts
	 * @return response EsdSce0063EventResponse
	 * @exception EventException
	 */
	public List<SearchStsListVO> searchStsList(SearchEDIPerformanceOptionsVO schEpOpts)  throws EventException;
	
	/**
	 * EDI Performance Missing 조회
	 * 
	 * @param SearchEDIPerformanceOptionsVO schEpOpts
	 * @return response EsdSce0072EventResponse
	 * @exception EventException
	 */
	public EventResponse searchEDIPerformance(SearchEDIPerformanceOptionsVO schEPOpts)  throws EventException;
	
	/**
	 * EDI Total Performance on-time-performance 조회
	 * 
	 * @param SearchEDIPerformanceOptionsVO schEPOpts
	 * @return response EsdSce0072EventResponse
	 * @exception EventException
	 */
	public EventResponse searchEDITotalPerformance(SearchEDIPerformanceOptionsVO schEPOpts)  throws EventException;
	
	/**
	 * EDI Total Performance Combo조회
	 * 
	 * @param SearchEDIPerformanceOptionsVO custOpts
	 * @return response EsdSce0073EventResponse
	 * @exception EventException
	 */
	public List<SearchComboPerformanceVO> searchComboPerformance(SearchEDIPerformanceOptionsVO custOpts) throws EventException;
	
	/**
	 * EDI searchCustSts 조회
	 * 
	 * @param SearchEDIPerformanceOptionsVO custOpts
	 * @return response EsdSce0073EventResponse
	 * @exception EventException
	 */
	public List<SearchCustStsVO> searchCustSts(SearchEDIPerformanceOptionsVO custOpts)  throws EventException;
	
    /**
     * EDI PERFORMANCE Customer Information 조회
     * @param SearchEDIPerformanceOptionsVO schEPOpts
     * @return EventResponse
     * @throws EventException
     */
	public List<SearchPerCsInfoVO> searchPerCsInfo(SearchEDIPerformanceOptionsVO schEPOpts)throws EventException;
    
    /**
     * EDI Customer TP ID Information 조회
     * @param SearchEDIPerformanceOptionsVO custOpts
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse searchPerCsTpIdInfo(SearchEDIPerformanceOptionsVO custOpts) throws EventException;
    
    /**
     * EDI Customer TP ID Information 조회
     * @param SearchEDIPerformanceOptionsVO custOpts
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse searchPerCsTpIdInfo1(SearchEDIPerformanceOptionsVO custOpts) throws EventException;
    
    /**
     * Missing List popup 조회
     * @param SearchMissingListVO searchMissingListVo
     * @return List<SearchMissingListVO>
     * @throws EventException
     */
    public List<SearchMissingListVO> searchMissingList(SearchMissingListVO searchMissingListVo) throws EventException;
    
    /**
     * On-Time List popup 조회
     * @param SearchMissingListVO searchOnTimeListVo
     * @return List<SearchMissingListVO>
     * @throws EventException
     */
    public List<SearchMissingListVO> searchOnTimeList(SearchMissingListVO searchOnTimeListVo) throws EventException;
    
    
    /**
     * Missing List 조회
     * @param SearchMissingListVO searchMissingListVo
     * @return List<SearchMissingListVO>
     * @throws EventException
     */
    public List<SearchMissingListVO> searchDetailMissingList(SearchMissingListVO searchMissingListVo) throws EventException;
    
    /**
     * Vessel Schedule Accuracy 조회
     * @param e
     * @return EventResponse
     * @throws EventException
     */
    //public EventResponse searchEstimationList(Event e) throws EventException;
    
    /**
    * EDI Statue 조회
    * @param e
    * @return EventResponse
    * @throws EventException
    */
   //public EventResponse searchEdiStsList(Event e) throws EventException;
   
    
    /**
     * EDI Customer Information 조회
     * @param e
     * @return EventResponse
     * @throws EventException
     */
    //public EventResponse searchVesCsInfo(Event e) throws EventException;
    
    /**
     * EDI Customer TP ID Information 조회
     * @param e
     * @return EventResponse
     * @throws EventException
     */
    //public EventResponse searchVesCsTpIdInfo(SearchEDIPerformanceOptionsVO custOpts) throws EventException;
    
    /**
     *  My Performance Report Modify조회
     * @param SearchCustomerInfoVO myCustInfo
     * @return List<SearchPerRepPupModiVO>
     * @throws EventException
     */
    public List<SearchPerRepPupModiVO> searchPerRepPupModi(SearchCustomerInfoVO myCustInfo) throws EventException;
    
    /**
     *  My Performance Report Modify 중복 체크 
     * @param CustomerInqChoiceVO perMod
     * @param CustomerInqChoiceVO[] perMods
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse updatePerformanceCnt(CustomerInqChoiceVO perMod, CustomerInqChoiceVO[] perMods, Event e) throws EventException;
    
    /**
     *  My Performance Report 저장
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse updatePerformance(Event e) throws EventException;
    
    /**
     *  My Performance Report Save
     * @param e
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse updatePerformanceModify(Event e) throws EventException;
    
    /**
     *  My page - My Customer 조회
     * @param String str
     * @return List<SearchMyCustomerVO>
     * @throws EventException
     */
    public List<SearchMyCustomerVO> searchMyCustomer(String str) throws EventException;
    
    /**
     * My page - My Performance Report 조회
     * @param str
     * @return List<SearchMyPerformanceVO>
     * @throws EventException
     */
    public List<SearchMyPerformanceVO> searchMyPerformance(String str) throws EventException;
    
    /**
     *  My page - My Cutomer 삭제
     * @param e
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse deleteMyCustomer(Event e) throws EventException;
    
    /**
     *  My page - My Performace 삭제
     * @param e
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse deleteMyPerformance(Event e) throws EventException;
    
    /**
     * EDI Group Information 조회
     * @param SearchEstimationListVO searchEstimationListVO
     * @return List<SearchEstimationListVO>
     * @throws EventException
     */
    public List<SearchEstimationListVO> searchEstimation(SearchEstimationListVO searchEstimationListVO) throws EventException ;
    /*public DBRowSet searchGroupID(CustomerInqChoiceVO myUserInfo) throws EventException;*/
    
    /**
     * EDI manual 전송시 입력한 location 유효성 체크 
     * @param List<Edi315SendVO> list
     * @param boolean ibflgChk
     * @return String
     * @throws EventException
     */
    public String searchMdmLocation(List<Edi315SendVO> list,  boolean ibflgChk) throws EventException;
    /**
     * EDI Customer Information 다중조회
     * @param CustomerEdiDBDAOOptionsVO cusEdiOpt
     * @return String[]
     * @throws EventException
     */
    public String[] searchCsInfoList(CustomerEdiDBDAOOptionsVO cusEdiOpt) throws EventException;
    
    /**
     * 조회 이벤트 처리<br>
     * Performance Setting Info 조회 이벤트 처리<br>
     *
     * @param SearchPerRepPupModiVO searchPerRepPupModiVO 
     * @return List<SearchPerRepPupModiVO>
     * @exception EventException ...
     */
    public List<SearchPerRepPupModiVO> searchUsrPerformanceSettingInfo(SearchPerRepPupModiVO searchPerRepPupModiVO) throws EventException;
    
    /**
     * 조회 이벤트 처리<br>
     * Performance Setting Info를 이전에 저장했는지 조회 이벤트 처리<br>
     *
     * @param SearchCustomerInfoVO myCustInfo 
     * @return int
     * @exception EventException ...
     */
    public int checkUsrPerformanceSettingInfo(SearchCustomerInfoVO myCustInfo) throws EventException;
 
    /**
     * 조회 이벤트 처리<br>
     * Performance Basic Form 조회 이벤트 처리<br>
     *
     * @param SearchCustomerInfoVO myCustInfo
     * @return List<SearchPerRepPupModiVO>
     * @exception EventException ...
     */
    public List<SearchPerRepPupModiVO> searchUsrPerformanceBasicForm(SearchCustomerInfoVO myCustInfo) throws EventException;
    
    /**
     * 조회 이벤트 처리<br>
     * My Performance Report Edi Group code 별 EDI Standard Status Code 및 Customer Status Code 정보 조회<br>
     *
     * @param SearchCustomerInfoVO myCustInfo
     * @return List<SearchPerRepPupModiVO>
     * @exception EventException ...
     */
    public List<SearchPerRepPupModiVO> searchEdiGrpCgoSts(SearchCustomerInfoVO myCustInfo) throws EventException;
    
    /**
     * 삭제 이벤트 처리
     * My Performance Report EDI Group Code 정보 삭제
     * @param myCustInfo
     * @throws EventException
     */
    public void removePerRepPupInfo(SearchCustomerInfoVO myCustInfo) throws EventException;
    
}
