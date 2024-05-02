/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceReportBC.java
*@FileTitle : bookingReport
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.AutoratingReportVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.BDRBookingStatusListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.BkgRptDfltVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.BlCaDetailListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.BlCargoManifestInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.BlCargoManifestOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.CaInquiryReportVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.CaIssueDateInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.CaIssueDateOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.CaPerformanceReportInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.CaPerformanceReportOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.CaSummaryReportInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.CaSummaryReportOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.DocPFMCBLListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.DocPFMCOfcListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.DocQueueDetailReturnInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.DpcsWebBookingVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.FreightChargeSummaryReportInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.InBoundReportInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.InBoundReportOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.RbcvesselVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.SaelsPerformanceReportInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.SaelsPerformanceReportOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.SearchBookingTrendReportVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.SearchEDIGrpIDVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.SearchFCLListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.SearchUserGroupIdVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.VesselUtilizationStatusReportInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.VesselUtilizationStatusReportOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.VesselVVDListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.specialreport.vo.ReportTemplateListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.DocsUserGroupCdVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * -Bookingreport Business Logic Command Interface<br>
 * - -Bookingreport biz Logic Interface<br>
 *
 * @author
 * @see Esm_bkg_0753EventResponse reference
 * @since J2EE 1.6
 */

public interface PerformanceReportBC {
	/**
	 * Searching the VVD list (ESM_BKG_07 53)<br>
	 * 
	 * @param  VesselVVDListVO vesselVVDListVO
	 * @return List<VesselVVDListVO>
	 * @throws EventException
	 */	
	public List<VesselVVDListVO> searchVVDList(VesselVVDListVO vesselVVDListVO) throws EventException;
	
	
	/**
	 * Checking the validation of VVD list (ESM_BKG_0753)<br>
	 * 
	 * @param  VesselVVDListVO[] vesselVVDListVO
	 * @throws EventException
	 */
	public void checkVVDList(VesselVVDListVO[] vesselVVDListVO) throws EventException;
	
	/**
	 * Searching for C/A Summary Template (ESM_BKG_0767)<br>
	 * 
	 * @param  BkgRptDfltVO bkgRptDfltVO
	 * @return List<BkgRptDfltVO>
	 * @throws EventException
	 */
	public List<BkgRptDfltVO> searchReportTemplateList(BkgRptDfltVO bkgRptDfltVO) throws EventException;
	
	/**
	 * Adding and modifying the C/A Summary Template (ESM_BKG_0767)<br>
	 * 
	 * @param  BkgRptDfltVO[] bkgRptDfltVO
	 * @throws EventException
	 */
	public void addReportTemplate(BkgRptDfltVO[] bkgRptDfltVO) throws EventException;
	
	/**
	 * Deleting the C/A Summary Template (ESM_BKG_0767)<br>
	 * 
	 * @param  BkgRptDfltVO[] bkgRptDfltVO
	 * @throws EventException
	 */
	public void removeReportTemplate(BkgRptDfltVO[] bkgRptDfltVO) throws EventException;
	 
  
	/**
	 * Searching for C/A Detail(s)(ESM_BKG_0651)<br>
	 * 
	 * @param String blNo
	 * @param String bkgNo
	 * @param String caNo
	 * @return List<BlCaDetailListVO>
	 * @throws EventException
	 */
	public List<BlCaDetailListVO> searchBLCaDetailList(String blNo, String bkgNo, String caNo) throws EventException ;
	
	/**
	 * Searching the History List of C/A Detail(s)(ESM_BKG_0651)<br>
	 * 
	 * @param String bkgNo
	 * @param String corrNo
	 * @return List<BlCaDetailListVO>
	 * @throws EventException
	 */
	public List<BlCaDetailListVO> searchBLCaDetailHisList(String bkgNo, String corrNo) throws EventException ;

	
	/**
	 * Searching the C/A Performance Report (ESM_BKG_0110)<br>
	 * 
	 * @param CaPerformanceReportInVO vo
	 * @return List<CaPerformanceReportOutVO>
	 * @throws EventException
	 */
	public List<CaPerformanceReportOutVO> searchCAPerformanceReport(CaPerformanceReportInVO vo) throws EventException ;
	

	 /**
	 * Searching the User Group Id<br>
	 * @param String usrId
	 * @return List<DocQueueListOutVO>
	 * @throws EventException
	 */
	public List<SearchUserGroupIdVO> searchUserGroupId(String usrId) throws EventException ;
	
			  
    /**
     * 0985 Managing(Create/modify) the data related with Return table<br>	
     * 
     * @param docQueueDetailReturnInVO DocQueueDetailReturnInVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageQueueDetailReturn(DocQueueDetailReturnInVO docQueueDetailReturnInVO,SignOnUserAccount account) throws EventException;
    
    /**
     * 0984 Managing(Create/modify) the data related with Return table<br>	
     * 
     * @param docQueueDetailReturnInVO DocQueueDetailReturnInVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageQueueRtnToRtn(DocQueueDetailReturnInVO docQueueDetailReturnInVO,SignOnUserAccount account) throws EventException;
  
	 
	 /**
	 * Searching the C/A Report (ESM_BKG_0568)<br>
	 * 
	 * @param CaIssueDateInVO vo
	 * @return List<CaIssueDateOutVO>
	 * @throws EventException
	 */
	 public List<CaIssueDateOutVO> searchCaIssueDateList(CaIssueDateInVO vo) throws EventException ;
	 
	 /**
	 * Searching the C/A Report_B/L Inquiry >>> Main (ESM_BKG_0570)<br>
	 * 
	 * @param String blNo
	 * @return List<CaInquiryReportVO>
	 * @throws EventException
	 */
	 public List<CaInquiryReportVO> searchCaByBLno(String blNo) throws EventException ;
	 
	 /**
	 * Searching the C/A Report_B/L Inquiry >>> Customer Info. (ESM_BKG_0570)<br>
	 * 
	 * @param String blNo
	 * @param String corrNo
	 * @return List<CaInquiryReportVO>
	 * @throws EventException
	 */
	 public List<CaInquiryReportVO> searchCaByCustomerInfo(String blNo, String corrNo) throws EventException ;
	 
	 /**
	 * Searching the C/A Report_B/L Inquiry >>> Marks&Desc Info. (ESM_BKG_0570)<br>
	 * 
	 * @param String blNo
	 * @param String corrNo
	 * @return List<CaInquiryReportVO>
	 * @throws EventException
	 */
	 public List<CaInquiryReportVO> searchCaByMarkDescInfo(String blNo, String corrNo) throws EventException ;
		 
	 /**
	 * Searching the C/A Report_B/L Inquiry >>> Container Info. (ESM_BKG_0570)<br>
	 * 
	 * @param String blNo
	 * @param String corrNo
	 * @return List<CaInquiryReportVO>
	 * @throws EventException
	 */
	 public List<CaInquiryReportVO> searchCaByContainerInfo(String blNo, String corrNo) throws EventException ;	 

	
 
	 /**
	  * 0274 Searching the General Cargo Manifest by VVD/PORT<br>
	  * 
	  * @param BlCargoManifestInVO blCargoManifestInVO
	  * @return List<BlCargoManifestOutVO>
	  * @throws EventException
	  */
	 public List<BlCargoManifestOutVO> searchBLCargoManifestList(BlCargoManifestInVO blCargoManifestInVO)  throws EventException ;
	
	 
	/**
	 * Searching the C/A Summary Report (ESM_BKG_0174)<br>
	 * 
	 * @param  CaSummaryReportInVO vo
	 * @return List<CaSummaryReportOutVO>
	 * @throws EventException
	 */	
    public List<CaSummaryReportOutVO> searchCaSummaryReport(CaSummaryReportInVO vo) throws EventException;
    
    /**
	 * Searching the C/A Summary Report BL List (ESM_BKG_0174)<br>
	 * 
	 * @param  CaSummaryReportInVO vo
	 * @return List<CaSummaryReportOutVO>
	 * @throws EventException
	 */	
    public List<CaSummaryReportOutVO> searchCaSummaryReportBLList(CaSummaryReportInVO vo) throws EventException;
    
    /**
	  * 0985 Searching the Queue Detail Return<br>
	  * @param  DocQueueDetailReturnInVO docQueueDetailReturnInVO 
	  * @return List<DocQueueDetailReturnInVO>
	  * @throws EventException
	  */
	 public List<DocQueueDetailReturnInVO> searchQueueDetailReturn(DocQueueDetailReturnInVO docQueueDetailReturnInVO) throws EventException;
      
    /**
	 * Searching the Correction(C/A) monthly Summary Batch (BAT_BKG_004)<br>
	 * 
	 * @param String fromDt
	 * @param String toDt
	 * @exception EventException
	 */	
    public void manageCASummary(String fromDt, String toDt) throws EventException; 

	/**
	 * 1073 Searching the Customer EDI ID Inquiry<br>
	 * @param  SearchEDIGrpIDVO searchEDIGrpIDVO
	 * @return List<SearchEDIGrpIDVO>
	 * @throws EventException
	 */
    public List<SearchEDIGrpIDVO> searchEDIGrpId(SearchEDIGrpIDVO searchEDIGrpIDVO) throws EventException;

	/**
	 * addBkgSrRequest
	 * @param  DpcsWebBookingVO dpcsWebBookingVO
	 * @throws EventException
	 */
    public void addBkgSrRequest(DpcsWebBookingVO dpcsWebBookingVO) throws EventException;
    
	/**
     * 0104 Managing(transaction) the Report template(Default, Detail, User Set)<br>	
     * 
	 * @param ReportTemplateListVO[] reportTemplateListVO
	 * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageReportTemplateBstVipList(ReportTemplateListVO[] reportTemplateListVO,SignOnUserAccount account) throws EventException;

	/**
	 *  1004 Managing(modify) the Super User Authority Change - PIC CHANGE(0421)<br>
	 *  
	 * @param DocsUserGroupCdVO docsUserGroupCdVO
	 * @param SignOnUserAccount account
     * @exception EventException
	 */
	public void modifyDocsUserGroupCd(DocsUserGroupCdVO docsUserGroupCdVO, SignOnUserAccount account) throws EventException;

	/**
	 * Container NO , Type Size - by bkg_no
	 * bkgCzStsCd: Container NO - "CN", Type Size - "CQ" 
	 * @param  String bkgNo 
	 * @param  String bkgCzStsCd   
	 * @throws EventException
	 */
	public void manageQtyCntrCoposite(String bkgNo , String bkgCzStsCd )throws EventException;
	
	/**
	 * BKG_AUTO_RT_HIS creation<br>
	 * @param  String bkgNo 
	 * @throws EventException
	 */
	public void addAutoRtHistory(String bkgNo) throws EventException ;
	
	 /**
	  * Searching the Autorating Accuracy monitoring Report(ESM_BKG_1081).<br>
	  * 1.Autorating Accuracy Ration<br>
	  * 
	  * @param  AutoratingReportVO autoratingReportVO
	  * @return List<AutoratingReportVO>
	  * @throws EventException
	  */
	 public List<AutoratingReportVO> searchAutoratingReport(AutoratingReportVO autoratingReportVO) throws EventException ;
	
	 /**
	  * Searching the Autorating Accuracy monitoring Report(ESM_BKG_1081).<br>
	  * 2.Autorating B/L List<br>
	  * 
	  * @param  AutoratingReportVO autoratingReportVO
	  * @return List<AutoratingReportVO>
	  * @throws EventException
	  */
	 public List<AutoratingReportVO> searchAutoBLListReport(AutoratingReportVO autoratingReportVO) throws EventException ;
		
	 /**
	  * Searching the Autorating Accuracy monitoring Report(ESM_BKG_1081).<br>
	  * 3.Non Autorating B/L List<br>
	  * 
	  * @param  AutoratingReportVO autoratingReportVO
	  * @return List<AutoratingReportVO>
	  * @throws EventException
	  */
	 public List<AutoratingReportVO> searchNonAutoratingReport(AutoratingReportVO autoratingReportVO) throws EventException ;
	
		
	 /**
	  * Searching the 2 weeks Daily Booking Trend by Customer >>> B/L Detail (ESM_BKG_1083)<br>
	  * 
	  * @param  SearchBookingTrendReportVO vo
	  * @return List<SearchBookingTrendReportVO>
	  * @throws EventException
	  */
	 public List<SearchBookingTrendReportVO> searchBookingTrendReportBLDetail(SearchBookingTrendReportVO vo) throws EventException ;

	 
	 /**
	  * China EDI Receive
	  * @param rcvMsg String
	  * @throws EventException
	  */
	 public void loadRcvMsg(String rcvMsg) throws EventException;
	 
	 
	 
	/**
	 * BDR Status를 기간 및 BKG Office별로 조회한다.
	 * @param BDRBookingStatusListVO bdrBookingStatusListVO
	 * @return List<BDRBookingStatusListVO> 
	 * @exception EventException
	 */		
	 public List<BDRBookingStatusListVO> searchBDRBookingPfmcStatusList(BDRBookingStatusListVO bdrBookingStatusListVO) throws EventException;

	/**
	 * Doc Performance Report(ESM_BKG_0214)<br>
	 * 1.Office List -Documentation 실적 산출 기능 조회 화면<br>
	 * 
	 * @param DocPFMCOfcListVO vo
	 * @return List<DocPFMCOfcListVO>
	 * @throws EventException
	 */
	public List<DocPFMCOfcListVO> searchDocPFMCOfcList(DocPFMCOfcListVO vo) throws EventException ;		 

	/**
	 * Doc Performance Report(ESM_BKG_0214)<br>
	 * 2.B/L List -Documentation 실적 산출 기능 조회 화면<br>
	 * 
	 * @param DocPFMCBLListVO vo
	 * @return List<DocPFMCBLListVO>
	 * @throws EventException
	 */
	public List<DocPFMCBLListVO> searchDocPFMCBLList(DocPFMCBLListVO vo) throws EventException ;
	
	 /**
	  * 조회이벤트 처리<br>
	  * Performancereport화면에 대한 조회 이벤트 처리<br>
	  * 
	  * @param String fromDt
	  * @param String toDt
	  * @return List<RbcvesselVO>
	  * @exception EventException
	  */	
	 public List<RbcvesselVO> searchRBCVesselList(String fromDt, String toDt) throws EventException;
	 
	/**
	 * Sales Performance Report (ESM_BKG_0632)를 조회합니다.<br>
	 * 
	 * @param SaelsPerformanceReportInVO vo
	 * @return List<SaelsPerformanceReportOutVO>
	 * @throws EventException
	 */
	public List<SaelsPerformanceReportOutVO> searchSalesPerformanceReport(SaelsPerformanceReportInVO vo) throws EventException ;

    /**
	 * Vessel Utilization Status vs. Bsa by Lane 에 Trade Code 를 조회합니다. (ESM_BKG_0746)<br>
	 * 
	 * @param  VesselUtilizationStatusReportInVO vo
	 * @return List<VesselUtilizationStatusReportInVO>
	 * @throws EventException
	 */	
    public List<VesselUtilizationStatusReportInVO> searchVesselUtilizationTrade(VesselUtilizationStatusReportInVO vo) throws EventException; 
  
    /**
	 * Vessel Utilization Status vs. Bsa by Lane 에 Sub Trade Code 를 조회합니다. (ESM_BKG_0746)<br>
	 * 
	 * @param  VesselUtilizationStatusReportInVO vo
	 * @return List<VesselUtilizationStatusReportInVO>
	 * @throws EventException
	 */	
    public List<VesselUtilizationStatusReportInVO> searchVesselUtilizationSubTrade(VesselUtilizationStatusReportInVO vo) throws EventException;
       
    /**
	 * Vessel Utilization Status vs. Bsa by Lane 에 Bound Code 를 조회합니다. (ESM_BKG_0746)<br>
	 * 
	 * @param  VesselUtilizationStatusReportInVO vo
	 * @return List<VesselUtilizationStatusReportInVO>
	 * @throws EventException
	 */	
    public List<VesselUtilizationStatusReportInVO> searchVesselUtilizationBound(VesselUtilizationStatusReportInVO vo) throws EventException; 
   
    /**
	 * Vessel Utilization Status vs. Bsa by Lane 에 BSA by Lane 리스트를 조회합니다. (ESM_BKG_0746)<br>
	 * 
	 * @param  VesselUtilizationStatusReportInVO vo
	 * @return List<VesselUtilizationStatusReportOutVO>
	 * @throws EventException
	 */	
    public List<VesselUtilizationStatusReportOutVO> searchVesselUtilizationStatusReport(VesselUtilizationStatusReportInVO vo) throws EventException; 
  
	 /**
	  * 0940 I/B DOC Performance Report 정보를 조회합니다.<br>
	  * 
	  * @param InBoundReportInVO inBoundReportInVO
	  * @return List<InBoundReportOutVO>
	  * @throws EventException
	  */
	 public List<InBoundReportOutVO> searchInBoundPfmcReport(InBoundReportInVO inBoundReportInVO)  throws EventException;

    /**
	 * 1057 FCL List 정보를 조회합니다.<br>
	 * @param searchFCLListVO searchFCLListVO
	 * @return List<searchFCLListVO>
	 * @throws EventException
	 */
	public  List<SearchFCLListVO> searchFCLList(SearchFCLListVO searchFCLListVO)throws EventException ;
	
	/**
	 * Freight & Charge 요약 리포트 조회한다.
	 * 화면 - ESM_BKG_0595
	 * @param FreightChargeSummaryReportInVO vo
	 * @return List<FreightChargeSummaryReportInVO>
	 * @throws EventException
	 */
	public List<FreightChargeSummaryReportInVO> searchFrtSumList(FreightChargeSummaryReportInVO vo) throws EventException ;
		
			 
}
