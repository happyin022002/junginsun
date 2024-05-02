/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCReportBC.java
*@FileTitle : Proposal Amendment Draft Print
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.28
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2009.06.25 변영주
* 1.0 Creation
* =========================================================
* History
* 2013.05.28 이혜민 [CHM-201324516-01] Surcharge 종합체계 구축 T/F - Surcharge Summary Report 화면 신규개발 
* 2016.05.26 [CHM-201641700] [해수부 운임공표 및 신고제] 운임신고 관련 시스템 개발
* 2016.09.07 [CHM-201642825] [해수부 운임공표 및 신고제] 운임신고 관련 시스템 개발 (정식방식)
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.PriMofMapgHisVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.PriMofMapgVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RptParaVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RptSearchChargeSummaryReportBlInquiryVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RptSearchChargeSummaryReportSummaryViewVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltRptPropListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSCPrnVwRDInfoVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSCRetRDInfoVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchKoreaMOTListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchMOFLaneListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchMOTSSEFilingListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCBlListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCInfromationVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCMOTFilingListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCOutOfDateBkgListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCPerformanceBulletListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCPerformanceDetailListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCPerformanceDetailSumVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCPerfromanceVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCRateSearchBulletListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCRateSearchDARListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCRateSearchDoorListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCRateSearchListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCTimelyRateListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCTradeSubTradeLaneListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MdmChargeVO;
import com.hanjin.syscommon.common.table.PriMotTrfMnVO;
import com.hanjin.syscommon.common.table.PriSpHdrVO;
import com.hanjin.syscommon.common.table.PriSpMnVO;

/**
 * NIS2010-Screport Business Logic Command Interface<br>
 * - NIS2010-Screport에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Byeon Young Joo
 * @see Esm_pri_0039EventResponse 참조
 * @since J2EE 1.6
 */

public interface SCReportBC {
	/**
	 * 대상 SC List 를 조회<br>
	 * 
	 * @param RptParaVO rptParaVO
	 * @return List<RsltRptPropListVO>
	 * @exception EventException
	 */
	public List<RsltRptPropListVO> searchReportProposalList(RptParaVO rptParaVO) throws EventException;
	/**
	 * SC 기본 정보를 조회<br>
	 * 
	 * @param PriSpHdrVO priSpHdrVO
	 * @return List<RsltRptPropListVO>
	 * @exception EventException
	 */
	public List<RsltRptPropListVO> searchReportProposalInfo(PriSpHdrVO priSpHdrVO) throws EventException;
	/**
	 * Report 관련 정보를 조회<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @return List<RsltSCRetRDInfoVO>
	 * @exception EventException
	 */
	public List<RsltSCRetRDInfoVO> searchSCRetrievalRDInfo(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException;
	/**
	 * Report 관련 정보를 조회<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @return List<RsltSCPrnVwRDInfoVO>
	 * @exception EventException
	 */
	public List<RsltSCPrnVwRDInfoVO> searchSCPrintViewRDInfo(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException;

	/**
	 * MOT Filing List를 조회<br>
	 * 
	 * @param RsltSearchSCMOTFilingListVO rsltSearchSCMOTFilingListVO
	 * @param SignOnUserAccount account
	 * @return List<RsltSearchSCMOTFilingListVO>
	 * @exception EventException
	 */
	public List<RsltSearchSCMOTFilingListVO> searchSCMOTFilingList(RsltSearchSCMOTFilingListVO rsltSearchSCMOTFilingListVO, SignOnUserAccount account) throws EventException;

	/**
	 * S/C List Inquiry 리스트를 조회.<br>
	 * 
	 * @param RsltSearchSCListVO rsltSearchSCListVO
	 * @return List<RsltSearchSCListVO>
	 * @exception EventException
	 */
	public List<RsltSearchSCListVO> searchSCList(RsltSearchSCListVO rsltSearchSCListVO) throws EventException;
	
	/**
	 * S/C List Inquiry sum 과 sc no 갯수를 조회한다.<br>
	 * 
	 * @param RsltSearchSCListVO rsltSearchSCListVO
	 * @return List<RsltSearchSCListVO>
	 * @exception EventException
	 */
	public List<RsltSearchSCListVO> searchSCSumList(RsltSearchSCListVO rsltSearchSCListVO) throws EventException;	

	/**
	 * S/C Performance Summary 리스트 조회를 위해 BackEndJob을 실행한다. <br>
	 * 
	 * @param SignOnUserAccount account
	 * @param RsltSearchSCPerfromanceVO rsltSearchSCPerfromanceVO
	 * @return String
	 * @exception EventException
	 */
	public String searchSCPerformanceSummaryListDoStart(SignOnUserAccount account, RsltSearchSCPerfromanceVO rsltSearchSCPerfromanceVO) throws EventException;

	/**
	 * S/C Performance Summary 리스트 조회를 위해 Single scope S/C의 count를 조회한다.<br>
     *
	 * @param RsltSearchSCPerfromanceVO rsltSearchSCPerfromanceVO
	 * @return List<RsltSearchSCPerfromanceVO>
	 * @exception EventException
	 */
	public List<RsltSearchSCPerfromanceVO> searchSCPerformanceSummaryListScopeCnt(RsltSearchSCPerfromanceVO rsltSearchSCPerfromanceVO) throws EventException;	
	
	/**
	 * SC Performance Summary - View BL 리스트를 조회하기 위해 BackEndJob을 실행한다.<br>
     *
	 * @param SignOnUserAccount account
	 * @param RsltSearchSCBlListVO rsltSearchSCBlListVO
	 * @return String
	 * @exception EventException
	 */
	public String searchSCBlListDoStart(SignOnUserAccount account, RsltSearchSCBlListVO rsltSearchSCBlListVO) throws EventException;
	
	/**
	 * SC Performance Summary - View BL 리스트를 조회하기 위해 BackEndJob을 실행한다.<br>
     *
	 * @param SignOnUserAccount account
	 * @param RsltSearchSCPerformanceDetailListVO rsltSearchSCPerformanceDetailListVO
	 * @return String
	 * @exception EventException
	 */
	public String searchSCPerformanceDetailListDoStart(SignOnUserAccount account, RsltSearchSCPerformanceDetailListVO rsltSearchSCPerformanceDetailListVO) throws EventException;	
	
	/**
	 * S/C Performance Summary - Detail 의 trade, sub trade, lane 콤보를 조회한다.<br>
     *
	 * @param RsltSearchSCTradeSubTradeLaneListVO rsltSearchSCTradeSubTradeLaneListVO
	 * @return List<RsltSearchSCTradeSubTradeLaneListVO>
	 * @exception EventException
	 */
	public List<RsltSearchSCTradeSubTradeLaneListVO> searchSCTradeSubTradeLaneList(RsltSearchSCTradeSubTradeLaneListVO rsltSearchSCTradeSubTradeLaneListVO) throws EventException;	
	/**
	 * 해당 SC NO 에 대한 기본 내용을 조회한다. <br>
     *
	 * @param RsltSearchSCInfromationVO rsltSearchSCInfromationVO
	 * @return List<RsltSearchSCInfromationVO>
	 * @exception EventException
	 */
	public List<RsltSearchSCInfromationVO> searchSCInfromation(RsltSearchSCInfromationVO rsltSearchSCInfromationVO) throws EventException;	
	
	/**
	 * Commodity, actual 콤보 데이터를 조회한다. <br>
     *
	 * @param RsltSearchSCPerformanceBulletListVO rsltSearchSCPerformanceBulletListVO
	 * @return List<RsltSearchSCPerformanceBulletListVO>
	 * @exception EventException
	 */
	public List<RsltSearchSCPerformanceBulletListVO> searchSCPerformanceBulletList(RsltSearchSCPerformanceBulletListVO rsltSearchSCPerformanceBulletListVO) throws EventException;	
	/**
	 * S/C Performance Summary - S/C TOTAL 합계내용을 조회한다. <br>
     *
	 * @param RsltSearchSCPerformanceDetailSumVO rsltSearchSCPerformanceDetailSumVO
	 * @return List<RsltSearchSCPerformanceDetailSumVO>
	 * @exception EventException
	 */
	public List<RsltSearchSCPerformanceDetailSumVO> searchSCPerformanceDetailSum(RsltSearchSCPerformanceDetailSumVO rsltSearchSCPerformanceDetailSumVO) throws EventException;	
	/**
	 * Rate Search 리스트를 조회하기 위해 BackEndJob을 실행한다.<br>
     *
	 * @param SignOnUserAccount account
	 * @param RsltSearchSCRateSearchListVO rsltSearchSCRateSearchListVO
	 * @return String
	 * @exception EventException
	 */
	public String searchSCRateSearchListDoStart(SignOnUserAccount account, RsltSearchSCRateSearchListVO rsltSearchSCRateSearchListVO) throws EventException;
	/**
	 * Commodity, actual 콤보 데이터를 조회한다. <br>
     *
	 * @param RsltSearchSCRateSearchBulletListVO rsltSearchSCRateSearchBulletListVO
	 * @return List<RsltSearchSCRateSearchBulletListVO>
	 * @exception EventException
	 */
	public List<RsltSearchSCRateSearchBulletListVO> searchSCRateSearchBulletList(RsltSearchSCRateSearchBulletListVO rsltSearchSCRateSearchBulletListVO) throws EventException;	
	/**
	 * Destinatnion Arbitrary Guideline Inquiry 리스트를 조회한다. <br>
     *
	 * @param RsltSearchSCRateSearchDARListVO rsltSearchSCRateSearchDARListVO
	 * @return List<RsltSearchSCRateSearchDARListVO>
	 * @exception EventException
	 */
	public List<RsltSearchSCRateSearchDARListVO> searchSCRateSearchDARList(RsltSearchSCRateSearchDARListVO rsltSearchSCRateSearchDARListVO) throws EventException;	
	/**
	 * US Route Cost Inquiry 리스트를 조회한다. <br>
     *
	 * @param RsltSearchSCRateSearchDoorListVO rsltSearchSCRateSearchDoorListVO
	 * @return List<RsltSearchSCRateSearchDoorListVO>
	 * @exception EventException
	 */
	public List<RsltSearchSCRateSearchDoorListVO> searchSCRateSearchDoorList(RsltSearchSCRateSearchDoorListVO rsltSearchSCRateSearchDoorListVO) throws EventException;
	
	/**
	 * BackEndJob의 상태값을 조회한다.<br>
	 * 
	 * @param String object
	 * @return String
	 * @exception EventException
	 */
	public String comBakEndJbVOs(String object) throws EventException;
	
	/**
	 * Office /  S’rep 별로  적기 계약  생성에 대한  결과 값을 조회<br>
	 * 
	 * @param RsltSearchSCTimelyRateListVO rsltSearchSCTimelyRateListVO
	 * @return List<RsltSearchSCTimelyRateListVO>
	 * @throws EventException
	 */
	public List<RsltSearchSCTimelyRateListVO> searchTimelyRateCreationReport(RsltSearchSCTimelyRateListVO rsltSearchSCTimelyRateListVO) throws EventException;
	
	/**
	 * 전체 대상 BKG 중 Batch Result 가 E (Error) 인 목록조회 <br>
	 * 
	 * @param RsltSearchSCOutOfDateBkgListVO rsltSearchSCOutOfDateBkgListVO
	 * @return List<RsltSearchSCOutOfDateBkgListVO>
	 * @throws EventException
	 */
	public List<RsltSearchSCOutOfDateBkgListVO> searchTimelyOutOfDateBookingList(RsltSearchSCOutOfDateBkgListVO rsltSearchSCOutOfDateBkgListVO) throws EventException;
	
	/**
	 * Charge Summary Report - Summary View Tab을 조회를 위해 BackEndJob을 실행한다. <br>
	 * 
	 * @param RptSearchChargeSummaryReportSummaryViewVO rptSearchChargeSummaryReportSummaryViewVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchChargeSummaryReportSummaryViewDoStart(RptSearchChargeSummaryReportSummaryViewVO rptSearchChargeSummaryReportSummaryViewVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 입력한 OFC 유효성을 검증한다.<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchOfcValid(String ofcCd) throws EventException;
	
	/**
	 * Charge Summary Report - BL Inquiry 조회를 위해 BackEndJob을 실행한다. <br>
	 * 
	 * @param RptSearchChargeSummaryReportBlInquiryVO rptSearchChargeSummaryReportBlInquiryVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchChargeSummaryBlInquiryDoStart(RptSearchChargeSummaryReportBlInquiryVO rptSearchChargeSummaryReportBlInquiryVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Charge Summary Report - Detail View Tab을 조회를 위해 BackEndJob을 실행한다. <br>
	 * 
	 * @param RptSearchChargeSummaryReportSummaryViewVO rptSearchChargeSummaryReportSummaryViewVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchChargeSummaryReportDetailViewDoStart(RptSearchChargeSummaryReportSummaryViewVO rptSearchChargeSummaryReportSummaryViewVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_PRI_0131 : BackEndJob 결과 - Account별 조회 이벤트 처리<br>
	 *
	 * @param String key
	 * @return List<Object>
	 * @exception EventException
	 */
	public List<Object> excelDownChargeSummaryBlInquiry(String key) throws EventException;
	/**
	 * charge 리스트를 조회합니다.<br>
	 * 
	 * @param MdmChargeVO mdmChargeVO
	 * @return List<MdmChargeVO>
	 * @exception EventException
	 */
	public List<MdmChargeVO> searchChargeList(MdmChargeVO mdmChargeVO) throws EventException;

	/**
	 * MOT/SSE Filing List Inquiry 리스트 조회를  실행한다. <br>
	 * 
	 * @param RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO
	 * @return List<RsltSearchMOTSSEFilingListVO>
	 * @exception EventException
	 */	
	public List<RsltSearchMOTSSEFilingListVO> searchMOTSSEFilingList(RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO) throws EventException ;	

    /**
     * MOT/SSE Filing 을 위한 일자별 대상 BKG 을 가져와 해당 일자의 Log 데이터를 생성한다.( Batch Job 호출 대상 ) 
     * -  중복 제거 이전.<br>
     * 
     * @param RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO
     * @exception EventException
     */
    public void createPriMotFileLogData(RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO ) throws EventException ;

	/**
	 * MOT/SSE Filing 을 위한 일별 데이터 중 OFT 가 Null 이거나 Zero 인 경우에 대해 생성된 Surcharge Detail 삭제
	 * MOT Tariff Matching 을 위한 준비 과정.<br>
	 * 
	 * @param RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO
	 * @exception EventException
	 */
	public void removePriMotFileRtLogDtlZeroOft(RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO) throws EventException;
	
    /**
     * MOT/SSE Filing 을 위한 일별 데이터 중에서 OFT 가 Null or Zero 인 경우에 대해 MOT Tariff 정보를 Matching 시켜 해당 Surcharge Data 를 복제 생성  한다.<br>
     * 
     * @param RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO
     * @exception EventException
     */
    public void createPriMotFileRtLogDtlMatchingTariff(RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO ) throws EventException ;
    
    /**
     * MOT/SSE Filing 을 위한 일별 데이터 중에서 OFT 가 Null or Zero 인 경우들에 대해 MOT Tariff 를 Matching 하여 OFT 와 Remark 를 Update 한다.<br>
     * 
     * @param RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO
     * @exception EventException
     */
    public void mergePriMotFileRtLogOFT(RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO ) throws EventException ;

    /**
     * MOT/SSE Filing 을 위한 일별 데이터중에서 이전 Filing 되었던 것과 같은 건을 제거한 금일 Filing 대상 데이터 생성 한다.<br>
     * 
     * @param RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO
     * @exception EventException
     */
    public void createPriMotFileRtData(RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO ) throws EventException ;

	/**
	 * 기 실행된 MOT/SSE Filing List 삭제.<br>
	 * PRI_MOT_FILE_RT
	 * 
	 * @param RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO
	 * @exception EventException
	 */
	public void removePriMotFileRt(RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO) throws EventException;
	
	/**
	 * 기 실행된 MOT/SSE Filing List 삭제.<br>
	 * PRI_MOT_FILE_RT_SCG_DTL
	 * 
	 * @param RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO
	 * @exception EventException
	 */
	public void removePriMotFileRtScgDtl(RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO) throws EventException;
	
	/**
	 * 기 실행된 MOT/SSE Filing List 삭제.<br>
	 * PRI_MOT_FILE_RT_LOG
	 * 
	 * @param RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO
	 * @exception EventException
	 */
	public void removePriMotFileRtLog(RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO) throws EventException;
	
	/**
	 * 기 실행된 MOT/SSE Filing List 삭제.<br>
	 * PRI_MOT_FILE_RT_LOG_DTL
	 * 
	 * @param RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO
	 * @exception EventException
	 */
	public void removePriMotFileRtLogDtl(RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO) throws EventException;
	

	/**
	 * MOT Tariff List 를  조회 합니다.<br>
	 * 
	 * @param RsltSearchMOTSSEFilingListVO	rsltSearchMOTSSEFilingListVO
	 * @return List<RsltSearchMOTSSEFilingListVO>
	 * @exception EventException
	 */
	public List<RsltSearchMOTSSEFilingListVO> searchMOTSSETariffList(RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO) throws EventException;
	
	/**
	 * MOT Tariff List 를  관리 합니다.<br>
	 * 
	 * @param PriMotTrfMnVO priMotTrfMnVO
	 * @param RsltSearchMOTSSEFilingListVO[] rsltSearchMOTSSEFilingListVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageMOTSSETariffList(PriMotTrfMnVO priMotTrfMnVO, RsltSearchMOTSSEFilingListVO[] rsltSearchMOTSSEFilingListVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * 선택된 Service Scope에 등록된 MOT Tariff 리스트를 조회한다.<br>
	 * 
	 * @param RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO
	 * @return List<RsltGlineScpEffDtListVO>
	 * @exception EventException
	 */
	public List<RsltSearchMOTSSEFilingListVO> searchMotTrfScopeEffectiveDateList(RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO) throws EventException ;

	/**
	 * MOT Base Port List 를 조회합니다.<br>
	 * 
	 * @param String svcScpCd
	 * @param String orgDestTpCd
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchMotBsePortList(String svcScpCd, String orgDestTpCd) throws EventException;

	/**
	 * PRI Mot Tariff 내용 전체를 삭제한다. <br>
	 * 
	 * @param PriMotTrfMnVO priMotTrfMnVO
	 * @exception EventException
	 */
	public void removeMOTSSETariff(PriMotTrfMnVO priMotTrfMnVO) throws EventException;

	/**
	 * MOT Tariff 화면을 위한 Service Scope Code List 를 조회합니다.<br>
	 * 
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchMotTrfSvcScpCdList() throws EventException ;

	
	/**
	 * MOT Tariff 화면을 위한 Service Scope Code 별 Lane Code List 를 조회합니다.<br>
	 * 
	 * @param String svc_scp_cd
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchMotTrfLaneCdList(String svc_scp_cd) throws EventException;
	
	/**
	 * Korea MOF Filing (by Upload) 리스트 조회를  실행한다. <br>
	 * 
	 * @param RsltSearchKoreaMOTListVO rsltSearchKoreaMOTListVO
	 * @return List<RsltSearchKoreaMOTListVO>
	 * @exception EventException
	 */
	public List<RsltSearchKoreaMOTListVO> searchKoreaMOTFilingList(RsltSearchKoreaMOTListVO rsltSearchKoreaMOTListVO) throws EventException;
	
	/**
	 * Korea MOF Filing (by Upload) Send Email <br>
	 * 
	 * @param RsltSearchKoreaMOTListVO rsltSearchKoreaMOTListVO
	 * @param RsltSearchKoreaMOTListVO[] rsltSearchKoreaMOTListVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String multiKoreaMOTFilingList(RsltSearchKoreaMOTListVO rsltSearchKoreaMOTListVO, RsltSearchKoreaMOTListVO[] rsltSearchKoreaMOTListVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Korea MOF Filing (Formatted) 리스트 조회를  실행한다. <br>
	 * 
	 * @param RsltSearchKoreaMOTListVO rsltSearchKoreaMOTListVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchMOFFilingList(RsltSearchKoreaMOTListVO rsltSearchKoreaMOTListVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Korea MOF Filing (Base Table) - Scope & Location 리스트 조회를  실행한다. <br>
	 * 
	 * @param RsltSearchMOFLaneListVO rsltSearchMOFLaneListVO
	 * @return List<RsltSearchMOFLaneListVO>
	 * @exception EventException
	 */
	public List<RsltSearchMOFLaneListVO> searchPriMofLaneList(RsltSearchMOFLaneListVO rsltSearchMOFLaneListVO) throws EventException;

	/**
	 * Korea MOF Filing (Base Table) - Scope & Location 정보를  관리한다.<br>
	 * 
	 * @param RsltSearchMOFLaneListVO[] rsltSearchMOFLaneListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePriMofLaneList(RsltSearchMOFLaneListVO[] rsltSearchMOFLaneListVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Korea MOF Filing Mapping 리스트 조회를  실행한다. <br>
	 * 
	 * @param PriMofMapgVO priMofMapgVO
	 * @param SignOnUserAccount account
	 * @return List<PriMofMapgVO>
	 * @exception EventException
	 */
	public List<PriMofMapgVO> searchPriMofMapgList(PriMofMapgVO priMofMapgVO) throws EventException;
	
	
	/**
	 * Korea MOF Filing Mapping 리스트를 저장/변경/삭제한다. <br>
	 * 
	 * @param PriMofMapgVO[] priMofMapgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePriMofMapg(PriMofMapgVO[] priMofMapgVOs, PriMofMapgHisVO[] priMofMapgHisVOs, SignOnUserAccount account) throws EventException;
	
}