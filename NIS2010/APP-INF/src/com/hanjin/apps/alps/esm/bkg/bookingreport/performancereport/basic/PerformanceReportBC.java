/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceReportBC.java
*@FileTitle : bookingReport
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.06.01 강동윤
* 1.0 Creation
* 2011.10.04 정선용 [CHM-201112445] SI Automation System 구축
* 2011.10.18 조원주 [CHM-201113594] DPCS-SI Turn Time레포트 및 Draft B/L전송후 Amendment S/I PIC변경관련 개발요구사항 송부
* 2011.11.22 정선용 [CHM-201114286-01] DPCS-SI Turn Time레포트 및 Draft B/L전송후 Amendment S/I PIC변경관련 개발요구사항 송부
* 2011.11.30 정선용 [CHM-201114554-01] DPCS-Correction 기능 보완 요청
* 2011.12.08 금병주 [CHM-201114555-01] DPCS Correction 기능 보완 -2
* 2012.01.07 조정민 [CHM-201221961] Email 접수 Draft B/L Correction 분류 시스템 개발
* 2013.06.24 김진주 [CHM-201324100] E-BKG & E-SI Turn Time Report 
* 2013.11.06 김진주 [CHM-201327291][SZP DPCS] 라이브 적용일자 및 시스템 개선사항 요청
* 2014.06.13 조인영 [CHM-201430236] 미주 서비스 센터 통합 관련 시스템 개발 4차 - TRO Report 신규 생성 (USA)
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgWebServiceVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.SIWebServiceVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.AutoratingReportVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.BDRBookingStatusListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.BkgCorrCngDpcsUsrVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.BkgDpcsDocWeightVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.BkgEmlAcctStupVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.BkgRptDfltVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.BkgSrFaxVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.BlCaDetailListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.BlCargoManifestInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.BlCargoManifestOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.BlCntrCargoManifestOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.CaInquiryReportVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.CaIssueDateInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.CaIssueDateOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.CaPerformanceReportInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.CaPerformanceReportOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.CaSummaryReportInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.CaSummaryReportOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.CheckBkgNoVsSrNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocPFMCBLListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocPFMCOfcListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocPerformanceReportInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocPerformanceSummaryVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueBkgHistListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueDetailListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueDetailReturnInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueListInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueListOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueReportByPolListInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueReportByPolListOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueSummaryAgingVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueSummaryJITCompletenceVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueSummaryReturnFeedbackVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueSummarySRKindVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueSummaryStatusVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueSummaryUrgencyVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueVvdListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocTurnTimeInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocTurnTimeOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DpcsAmendReasonBkgListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DpcsSiSplitBkgCntrCompareResultVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DpcsSiSplitBkgCntrHisVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DpcsSiSplitCandidateVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DpcsWebBookingVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.EBkgSiPfmcInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.EBkgSiTurnTimeInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.EBkgSiTurnTimeOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.EBkgSiUploadStsReportInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.FreightChargeSummaryReportInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.InBoundReportInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.InBoundReportOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.ModifySiValAutoVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.ModifySrTransferVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.PortCLSReportVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.PortCloseBLlistVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.PortCloseOfficeListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.ProductionRatioVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.ProductionRatioDetailVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.QueueStatusVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.QueueStatusDetailVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.RbcvesselVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SaelsPerformanceReportInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SaelsPerformanceReportOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchBkgSrProcHisListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchBookingTrendReportVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchDPCSPfmcErrorListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchDPCSVolListInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchDpcsPerfByVolListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchEDIGrpIDVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchFCLListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchPerfVolByRegionGroupDtlListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchPerfVolByRegionGroupInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchPerfVolByRegionGroupListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchQueueDetailReturnReasonCdListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchQueueSummaryInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchReportByInputterUserGroupListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchReportByRaterUserGroupListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchSREmlAtchFileListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchSREmlCtntVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchSREmlReceivingListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchSRReceivingListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchUserGroupIdVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SiTurnTimeDetailVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SiTurnTimeSummaryVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SiTurnTimeVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.TroEurStatusListInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.TroStatusListInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.TroUsaStatusListInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.VesselUtilizationStatusReportInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.VesselUtilizationStatusReportOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.VesselVVDListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.specialreport.vo.ReportTemplateListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.DocsUserGroupCdVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgDpcsUsrGrpVO;
import com.hanjin.syscommon.common.table.BkgXterSrchSetVO;

/**
 * NIS2010-Bookingreport Business Logic Command Interface<br>
 * - NIS2010-Bookingreport에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author kang dong yun
 * @see Esm_bkg_0753EventResponse 참조
 * @since J2EE 1.6
 */
 
public interface PerformanceReportBC {
	/**
	 * VVD Selection Inquiry 결과를 조회한다. (ESM_BKG_0753)<br>
	 * 
	 * @param  VesselVVDListVO vesselVVDListVO
	 * @return List<VesselVVDListVO>
	 * @throws EventException
	 */	
	public List<VesselVVDListVO> searchVVDList(VesselVVDListVO vesselVVDListVO) throws EventException;
	
	
	/**
	 * VVD Selection Inquiry 유효성을 체크한다. (ESM_BKG_0753)<br>
	 * 
	 * @param  VesselVVDListVO[] vesselVVDListVO
	 * @throws EventException
	 */
	public void checkVVDList(VesselVVDListVO[] vesselVVDListVO) throws EventException;
	
	/**
	 * C/A Summary Template 결과를 조회한다. (ESM_BKG_0767)<br>
	 * 
	 * @param  BkgRptDfltVO bkgRptDfltVO
	 * @return List<BkgRptDfltVO>
	 * @throws EventException
	 */
	public List<BkgRptDfltVO> searchReportTemplateList(BkgRptDfltVO bkgRptDfltVO) throws EventException;
	
	/**
	 * C/A Summary Template 을 추가/수정한다. (ESM_BKG_0767)<br>
	 * 
	 * @param  BkgRptDfltVO[] bkgRptDfltVO
	 * @throws EventException
	 */
	public void addReportTemplate(BkgRptDfltVO[] bkgRptDfltVO) throws EventException;
	
	/**
	 * C/A Summary Template 을 삭제한다. (ESM_BKG_0767)<br>
	 * 
	 * @param  BkgRptDfltVO[] bkgRptDfltVO
	 * @throws EventException
	 */
	public void removeReportTemplate(BkgRptDfltVO[] bkgRptDfltVO) throws EventException;
	
	/**
	 * BDR Status를 기간 및 BKG Office별로 조회한다.
	 * @param BDRBookingStatusListVO bdrBookingStatusListVO
	 * @return List<BDRBookingStatusListVO> 
	 * @exception EventException
	 */		
	 public List<BDRBookingStatusListVO> searchBDRBookingPfmcStatusList(BDRBookingStatusListVO bdrBookingStatusListVO) throws EventException;
	 
	 /**
	  *  SR Receiving List 결과를 조회한다. (ESM_BKG_0488)<br>
	  * 
	  * @param SearchSRReceivingListVO vo
	  * @return List<SearchSRReceivingListVO>
	  * @exception EventException
	  */	
	 public List<SearchSRReceivingListVO> searchSRReceivingList(SearchSRReceivingListVO vo) throws EventException;
	 
	 /**
	  *  SR EMAIL Receiving List 결과를 조회한다. (ESM_BKG_0488)<br>
	  * 
	  * @param SearchSREmlReceivingListVO vo
	  * @return List<SearchSREmlReceivingListVO>
	  * @exception EventException
	  */	
	 public List<SearchSREmlReceivingListVO> searchSREmlReceivingList(SearchSREmlReceivingListVO vo) throws EventException;
	 
	 /**
	  *  SSR EML Fail Receiving이 존재하는지 조회한다 (ESM_BKG_0488)<br>
	  * 
	  * @param SearchSREmlReceivingListVO vo
	  * @return Boolean
	  * @exception EventException
	  */	
	 public Boolean chkSREmlFailReceivingList(SearchSREmlReceivingListVO vo) throws EventException;
	 
	 /**
	  *  SR EMAIL Atch File List 결과를 조회한다. (ESM_BKG_0488)<br>
	  * 
	  * @param SearchSREmlAtchFileListVO vo
	  * @return List<SearchSREmlAtchFileListVO>
	  * @exception EventException
	  */	
	 public List<SearchSREmlAtchFileListVO> searchSREmlAtchFileList(SearchSREmlAtchFileListVO vo) throws EventException;
	 
	 /**
	  *  SR EMAIL Atch File List 결과를 조회한다. (ESM_BKG_0488)<br>
	  * 
	  * @param SearchSREmlCtntVO vo
	  * @return List<SearchSREmlCtntVO>
	  * @exception EventException
	  */	
	 public List<SearchSREmlCtntVO> searchSREmlCtnt(SearchSREmlCtntVO vo) throws EventException;
	 
	 
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
	  * SR Receiving List Input Remark 를 추가한다. (ESM_BKG_0988)
	  * 
	  * @param String srNo
	  * @param String usrId
	  * @param String srKndCd
	  * @param String rcvRmk
	  * @exception EventException
	  */	
	 public void addQueueRemark(String srNo, String usrId, String srKndCd, String rcvRmk) throws EventException;
	 
	 /**
	  * SR Receiving List 를 추가/수정/삭제 한다. (ESM_BKG_0488)
	  * 
	  * @param BkgSrFaxVO[] bkgSrFaxVOs
	  * @param SignOnUserAccount account
	  * @exception EventException
	  */	
	 public void manageSRReceiving(BkgSrFaxVO[] bkgSrFaxVOs, SignOnUserAccount account) throws EventException;
	 
	 /**	  
	  * SR Receiving List BKG Match & Transfer 에 SrNo에 대한 BkgNo를 가져온다.(ESM_BKG_0489) <br>
	  * 
	  * @param String bkgNo
	  * @param String srNo
	  * @return CheckBkgNoVsSrNoVO
	  * @exception EventException
	  */	
	 public CheckBkgNoVsSrNoVO checkBkgNoVsSrNo(String bkgNo, String srNo) throws EventException;
	 
	 /**
	  * SR Receiving List BKG Match & Transfer 에 DPCS IP를 가져온다.(ESM_BKG_0489) <br>
	  * 
	  * @param String ofcNo
	  * @return String 
	  * @exception EventException
	  */	
	 public String searchDpcsIp(String ofcNo) throws EventException;
	 
	 /**
	  * SR Receiving List BKG Match & Transfer 에 User Part 정보를 가져온다.(ESM_BKG_0489) <br>
	  * 
	  * @param String usrId
	  * @return String[]
	  * @exception EventException
	  */	
	 public String[] searchUserPartCd(String usrId) throws EventException;
	 
	 /**
	  * SR Receiving List BKG Match & Transfer 에 AmendReason 정보를 가져온다.(ESM_BKG_0489) <br>
	  * 
	  * @param String srNo
	  * @param String bkgSrKndCd
	  * @param String usrId
	  * @return List<DpcsAmendReasonBkgListVO>
	  * @exception EventException
	  */	
	 public List<DpcsAmendReasonBkgListVO> searchAmendReasonBkgList(String srNo, String bkgSrKndCd, String usrId) throws EventException;
	 
	 /**
	  * SR Receiving List BKG Match & Transfer 에 Sr 작성 시간을 수정한다.(ESM_BKG_0489) <br>
	  * 
	  * @param String srNo
	 * @param String faxLogRefNo
	 * @param String bkgSrKndCd
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifySrStartTime(String srNo,String faxLogRefNo,String bkgSrKndCd,SignOnUserAccount account) throws EventException;
	 
	 /**
	  * SR Receiving List BKG Match & Transfer 에 BkgNo Match 정보를 수정한다.(ESM_BKG_0489) <br>
	  * 
	  * @param DocQueueBkgHistListVO vo
	  * @param String status
	  * @exception EventException
	  */	
	 public void modifyBkgNoMatch(DocQueueBkgHistListVO vo, String status) throws EventException;
	 
	 /**
	 * SR Receiving List Transfer To Dc 정보를 수정한다.(ESM_BKG_0489) <br>
	 * 
	 * @param ModifySrTransferVO modifySrTransferVO
	 * @exception EventException
	 */
	 public void modifySrTransfer(ModifySrTransferVO modifySrTransferVO) throws EventException;
	 
	 
	 /**
	  * SR Receiving List BKG Match & Transfer 에 QueaueBkgNo 정보를 삭제한다.(ESM_BKG_0489) <br>
	  * 
	  * @param DocQueueBkgHistListVO docQueueBkgHistListVO
	  * @exception EventException
	  */	
	 public void removeQueueBkgNo(DocQueueBkgHistListVO docQueueBkgHistListVO) throws EventException;
	 
	 /**
	 * SR Receiving List Transfer To Dc sr_no,bkg_no check.(ESM_BKG_0489) <br>
	 * 
	 * @param DocQueueBkgHistListVO vo
	 * @return List<DocQueueBkgHistListVO>
	 * @exception EventException
	 */
	public List<DocQueueBkgHistListVO> checkBkgNoOrSrNo(DocQueueBkgHistListVO vo) throws EventException;
			
	 /**
	  * SR Receiving List BKG Match & Transfer 에 QueaueBkgNo 정보를 수정한다.(ESM_BKG_0489) <br>
	  * 
	  *	@param DocQueueBkgHistListVO[] vos
	  * @param DocQueueBkgHistListVO vo
	  * @param SignOnUserAccount account
	  * @exception EventException
	  */	
	 public void manageBkgQueueList(DocQueueBkgHistListVO[] vos,DocQueueBkgHistListVO vo,SignOnUserAccount account) throws EventException;
	 
	 /**
	 * 해당 VVD별 Port의 Document마감 시간 조회함.
	 * 화면 - ESM_BKG_0417
	 * @param PortCLSReportVO vo
	 * @return List<PortCLSReportVO>
	 * @throws EventException
	 */
	public List<PortCLSReportVO> searchPCTCLSReport(PortCLSReportVO vo) throws EventException ;

	/**
	 * Freight & Charge 요약 리포트 조회한다.
	 * 화면 - ESM_BKG_0595
	 * @param FreightChargeSummaryReportInVO vo
	 * @return List<FreightChargeSummaryReportInVO>
	 * @throws EventException
	 */
	public List<FreightChargeSummaryReportInVO> searchFrtSumList(FreightChargeSummaryReportInVO vo) throws EventException ;
	
	/**
	 * SR Data의 처리 Office 별 B/L Turn Time 집계 현황을 조회한다. (Summary List)
	 * 화면 - ESM_BKG_0067
	 * @param DocPerformanceSummaryVO docPerformanceSummaryVO
	 * @return List<DocPerformanceSummaryVO>
	 * @throws EventException
	 */
	public List<DocPerformanceSummaryVO> searchDPCSTurnTimeSummary(DocPerformanceSummaryVO docPerformanceSummaryVO) throws EventException;
		
	
	/**
	 * SR Data의 처리 Office 별 B/L Turn Time 처리 시간 실적 현황을 조회한다.
	 * 화면 - ESM_BKG_0067
	 * @param DocPerformanceReportInVO docPerformanceReportInVO
	 * @return List<DocPerformanceReportInVO>
	 * @throws EventException
	 */
	public List<DocPerformanceReportInVO> searchDPCSTurnTimeList(DocPerformanceReportInVO docPerformanceReportInVO) throws EventException;	
	
	/**
	 * SR Data의 처리 부문별 담당자의 처리 Error 실적 현황을 조회(ESM_BKG_0409).
	 * @param SearchDPCSPfmcErrorListVO vo
	 * @return List<SearchDPCSPfmcErrorListVO>
	 * @throws EventException
	 */
	public List<SearchDPCSPfmcErrorListVO> searchDPCSPfmcErrorList(SearchDPCSPfmcErrorListVO vo) throws EventException ;
	
	/**
	 * TRO 현황 조회 화면(ESM_BKG_0620).
	 * @param TroStatusListInVO vo
	 * @return List<TroStatusListInVO>
	 * @throws EventException
	 */
	public List<TroStatusListInVO> searchTroStatusList(TroStatusListInVO vo) throws EventException ;

	/**
	 * e-Booking & S/I 업로드 실적 조회 기능(ESM_BKG_0226)<br>
	 * 1.Report Type이 Pending Report <br>
	 * 
	 * @param EBkgSiUploadStsReportInVO vo
	 * @return List<EBkgSiUploadStsReportInVO>
	 * @throws EventException
	 */
	public List<EBkgSiUploadStsReportInVO> searchEBkgSiUploadStsListByPending(EBkgSiUploadStsReportInVO vo) throws EventException ;
	
	 /**
	 * e-Booking & S/I 업로드 실적 조회 기능(ESM_BKG_0226).<br>
	 * 2.Report Type이 Delay Report <br>
	 * 
	 * @param EBkgSiUploadStsReportInVO vo
	 * @return List<EBkgSiUploadStsReportInVO>
	 * @throws EventException
	 */
	public List<EBkgSiUploadStsReportInVO> searchEBkgSiUploadStsListByDealy(EBkgSiUploadStsReportInVO vo) throws EventException ;
	 /**
	 * e-Booking & S/I 업로드 실적 조회 기능(ESM_BKG_0226).<br>
	 * 3.Report Type이 Detail Report<br>
	 * 
	 * @param EBkgSiUploadStsReportInVO vo
	 * @return List<EBkgSiUploadStsReportInVO>
	 * @throws EventException
	 */
	public List<EBkgSiUploadStsReportInVO> searchEBkgSiUploadStsListByDetail(EBkgSiUploadStsReportInVO vo) throws EventException;

	/**
	 * e-Booking & S/I 실적 조회 기능(ESM_BKG_0227)<br>
	 * 1.Report Type이 BookingOffice Report <br>
	 * 
	 * @param EBkgSiPfmcInVO vo
	 * @return List<EBkgSiPfmcInVO>
	 * @throws EventException
	 */
	public List<EBkgSiPfmcInVO> searchEBkgSiPfmcListByBkgOfc(EBkgSiPfmcInVO vo) throws EventException ;
	
	 /**
	 * e-Booking & S/I 실적 조회 기능(ESM_BKG_0227)<br>
	 * 2.Report Type이 SalesOffice Report <br>
	 * 
	 * @param EBkgSiPfmcInVO vo
	 * @return List<EBkgSiPfmcInVO>
	 * @throws EventException
	 */
	public List<EBkgSiPfmcInVO> searchEBkgSiPfmcListBySalOfc(EBkgSiPfmcInVO vo) throws EventException ;
	
	 /**
	 * e-Booking & S/I 실적 조회 기능(ESM_BKG_0227)<br>
	 * 3.Report Type이 Shipper Report<br>
	 * 
	 * @param EBkgSiPfmcInVO vo
	 * @return List<EBkgSiPfmcInVO>
	 * @throws EventException
	 */
	public List<EBkgSiPfmcInVO> searchEBkgSiPfmcListByShipper(EBkgSiPfmcInVO vo) throws EventException ;
	
	 /**
	 * e-Booking & S/I 실적 조회 기능(ESM_BKG_0227)<br>
	 * 4.Report Type이 Detail Report<br>
	 * 
	 * @param EBkgSiPfmcInVO vo
	 * @return List<EBkgSiPfmcInVO>
	 * @throws EventException
	 */
	public List<EBkgSiPfmcInVO> searchEBkgSiPfmcListByDetail(EBkgSiPfmcInVO vo) throws EventException ;
	
	 /**
	 * Port Closing Inquiry(ESM_BKG_0914)<br>
	 * 1.Office List -PCT (Port Closing Time) 현황 조회 화면<br>
	 * 
	 * @param PortCloseOfficeListVO vo
	 * @return List<PortCloseOfficeListVO>
	 * @throws EventException
	 */
	public List<PortCloseOfficeListVO> searchPctlOfficeList(PortCloseOfficeListVO vo) throws EventException ;
	
	 /**
	 * Port Closing Inquiry(ESM_BKG_0914)<br>
	 * 2.B/L List -PCT (Port Closing Time) 현황 조회 화면<br>
	 * 
	 * @param PortCloseBLlistVO vo
	 * @return List<PortCloseBLlistVO>
	 * @throws EventException
	 */
	public List<PortCloseBLlistVO> searchPctlBLList(PortCloseBLlistVO vo) throws EventException ;
	
	/**
	 * Port Closing Inquiry(ESM_BKG_0914)<br>
	 * 3.Office List Summary -PCT (Port Closing Time) 현황 조회 화면<br>
	 * 
	 * @param PortCloseOfficeListVO vo
	 * @return List<PortCloseOfficeListVO>
	 * @throws EventException
	 */
	public List<PortCloseOfficeListVO> searchPctlOfficeSummary(PortCloseOfficeListVO vo) throws EventException ;
	

	/**
	 * C/A Detail(s)(ESM_BKG_0651) 를 조회합니다<br>
	 * 
	 * @param String blNo
	 * @param String bkgNo
	 * @param String caNo
	 * @return List<BlCaDetailListVO>
	 * @throws EventException
	 */
	public List<BlCaDetailListVO> searchBLCaDetailList(String blNo, String bkgNo, String caNo) throws EventException ;
	
	/**
	 * C/A Detail(s)(ESM_BKG_0651)에 History List 를 조회합니다<br>
	 * 
	 * @param String bkgNo
	 * @param String corrNo
	 * @return List<BlCaDetailListVO>
	 * @throws EventException
	 */
	public List<BlCaDetailListVO> searchBLCaDetailHisList(String bkgNo, String corrNo) throws EventException ;
	
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
	 * C/A Performance Report (ESM_BKG_0110)를 조회합니다.<br>
	 * 
	 * @param CaPerformanceReportInVO vo
	 * @return List<CaPerformanceReportOutVO>
	 * @throws EventException
	 */
	public List<CaPerformanceReportOutVO> searchCAPerformanceReport(CaPerformanceReportInVO vo) throws EventException ;
	

	 /**
	 * User Group Id 조회합니다.<br>
	 * @param String usrId
	 * @return List<DocQueueListOutVO>
	 * @throws EventException
	 */
	public List<SearchUserGroupIdVO> searchUserGroupId(String usrId) throws EventException ;

    /**
     * Work Group별 PIC 목록조회<br>
     * 
     * @param String wrkGrpCd
     * @return List<BkgComboVO>
     * @exception EventException
     */
    public List<BkgComboVO> searchSZPBBPicCombo(String wrkGrpCd) throws EventException;
	
	/**
	 * 0421 Queue List 정보를 조회합니다.<br>
	 * @param DocQueueListInVO docQueueListInVO
	 * @return List<DocQueueListOutVO>
	 * @throws EventException
	 */
	public  List<DocQueueListOutVO> searchQueueList(DocQueueListInVO docQueueListInVO)throws EventException ;
	
	/**
	 * 0437 Queue List 정보를 조회합니다.<br>
	 * @param DocQueueListInVO docQueueListInVO
	 * @return List<DocQueueListOutVO>
	 * @throws EventException
	 */
	public  List<DocQueueListOutVO> searchSZPBBQueueList(DocQueueListInVO docQueueListInVO)throws EventException ;
	
	/**
	 * Sales Performance Report (ESM_BKG_0632)를 조회합니다.<br>
	 * 
	 * @param SaelsPerformanceReportInVO vo
	 * @return List<SaelsPerformanceReportOutVO>
	 * @throws EventException
	 */
	public List<SaelsPerformanceReportOutVO> searchSalesPerformanceReport(SaelsPerformanceReportInVO vo) throws EventException ;

	
	/**
	 * 0422 Queue Detail List 메타 정보를 조회합니다.<br>
     * @param String userPartCd
     * @param String bkgNo
     * @param String srNo
     * @param String userId
     * @param String srKind
     * @param String srKndCd
	 * @return List<DocQueueDetailListVO>
	 * @throws EventException
	 */
	public  List<DocQueueDetailListVO> searchQueueDetailList(String userPartCd, String bkgNo, String srNo, String userId, String srKind, String srKndCd) throws EventException ;
	
	/**
	 * 0422 Queue Detail List 메타 정보를 조회합니다.<br>
     * @param String bkgNo
	 * @return String
	 * @throws EventException
	 */
	public  String searchQueueDetailList4(String bkgNo) throws EventException ;
	
	/**
	 * 0437 0437 Queue Detail List Complete Flag를 조회합니다.<br>
     * @param String bkgNo
	 * @return String
	 * @throws EventException
	 */
	public  String searchSZPBBQueueDetailList4(String bkgNo) throws EventException ;
	
	/**
	 * 0422 Queue Detail List 정보를 조회합니다.<br>
	 * @param DocQueueDetailListVO docQueueDetailListVO
	 * @return List<DocQueueDetailListVO>
	 * @throws EventException
	 */
	public  List<DocQueueDetailListVO> searchQueueDetailList(DocQueueDetailListVO docQueueDetailListVO)throws EventException ;
	
	/**
	 * 0422 Queue Detail List 에 Go To BKG(e-booking:ESM_BKG_0229) 에 필요한 정보를 조회합니다.<br>
	 * @param String bkgNo
	 * @return String
	 * @throws EventException
	 */
	public  String searchRqstInfo(String bkgNo)throws EventException ;
	
	 /**
     * 0422 Completed 버튼 클릭시 Queue Detail 관련 테이블을 트랜잭션 처리합니다.<br>	
     * 
	 * @param DocQueueDetailListVO docQueueDetailListVO
	 * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageQueueDetailList(DocQueueDetailListVO docQueueDetailListVO,SignOnUserAccount account) throws EventException;
    
	/**
	 * ESM_BKG_0437 : Queue List 에 Input/Rate PIC 정보를 수정한다<br>
	 * 
	 * @param DocQueueListOutVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifySZPBBPicUserId(DocQueueListOutVO vo, SignOnUserAccount account) throws EventException;
    
    /**
	 * 0421 Delete 버튼 클릭시 Queue 관련 테이블을 트랜잭션 처리합니다.<br>
	 * 
	 * @param DocQueueDetailListVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeDpcsQueList(DocQueueDetailListVO[] vos, SignOnUserAccount account) throws EventException;

	
    /**
     * 0422 Pending 버튼 클릭시 BKG_SR_CRNT_RQST 관련 테이블을 트랜잭션 처리합니다.<br>	
     * 
     * @param DocQueueDetailListVO docQueueDetailListVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageQueueDetailList2(DocQueueDetailListVO docQueueDetailListVO,SignOnUserAccount account) throws EventException;
    
    /**
     * 0985 Return  버튼 클릭시 Return 관련 데이블 데이타을 수정/생성 합니다.<br>	
     * 
     * @param docQueueDetailReturnInVO DocQueueDetailReturnInVO
     * @param SearchQueueDetailReturnReasonCdListVO[] searchQueueDetailReturnReasonCdListVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageQueueDetailReturn(DocQueueDetailReturnInVO docQueueDetailReturnInVO,SearchQueueDetailReturnReasonCdListVO[] searchQueueDetailReturnReasonCdListVOs,SignOnUserAccount account) throws EventException;
    
    /**
	 * 0985 DPCS reject 내역을 email로 전송한다.<br>
	 * @param 	DocQueueDetailReturnInVO vo
	 * @param 	SignOnUserAccount account
	 * @throws 	EventException
	 */
	public void sendDpcsRejectEmail(DocQueueDetailReturnInVO vo, SignOnUserAccount account) throws EventException;
	
    /**
     * 0984 Return to Return  버튼 클릭시 관련 데이블 데이타를 생성/수정합니다.<br>	
     * 
     * @param docQueueDetailReturnInVO DocQueueDetailReturnInVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageQueueRtnToRtn(DocQueueDetailReturnInVO docQueueDetailReturnInVO,SignOnUserAccount account) throws EventException;
    
    /**
	 * 0424 Open 시 Queue VVD List 정보를 조회합니다.<br>
	 * 
	 * @param DocQueueVvdListVO docQueueVvdListVO
	 * @return List<DocQueueVvdListVO>
	 * @throws EventException
	 */
	 public List<DocQueueVvdListVO> searchQueueVvdList(DocQueueVvdListVO docQueueVvdListVO)  throws EventException ;


	 /**
	 * 0424 Queue Report By Pol 정보를 조회합니다.<br>
	 * 
	 * @param DocQueueReportByPolListInVO docQueueReportByPolListInVO  
	 * @return List<DocQueueReportByPolListOutVO>
	 * @throws EventException
	 */
	 public List<DocQueueReportByPolListOutVO> searchQueueReportByPol(DocQueueReportByPolListInVO docQueueReportByPolListInVO) throws EventException ;
	 
	 /**
	 * C/A Report (ESM_BKG_0568)를 조회합니다.<br>
	 * 
	 * @param CaIssueDateInVO vo
	 * @return List<CaIssueDateOutVO>
	 * @throws EventException
	 */
	 public List<CaIssueDateOutVO> searchCaIssueDateList(CaIssueDateInVO vo) throws EventException ;
	 
	 /*
	 * C/A Report (ESM_BKG_0568) Remark를 수정합니다.<br>
	 * 
	 * @param  CaIssueDateInVO[] vos
	 * @param  SignOnUserAccount account
	 * @throws EventException
	 */
	 //public void modifyCaIssueRemark(CaIssueDateInVO[] vos, SignOnUserAccount account) throws EventException ;


	 /**
	 * C/A Report_B/L Inquiry >>> Main (ESM_BKG_0570)를 조회합니다.<br>
	 * 
	 * @param String blNo
	 * @return List<CaInquiryReportVO>
	 * @throws EventException
	 */
	 public List<CaInquiryReportVO> searchCaByBLno(String blNo) throws EventException ;
	 
	 /**
	 * C/A Report_B/L Inquiry >>> Customer Info. (ESM_BKG_0570)를 조회합니다.<br>
	 * 
	 * @param String blNo
	 * @param String corrNo
	 * @return List<CaInquiryReportVO>
	 * @throws EventException
	 */
	 public List<CaInquiryReportVO> searchCaByCustomerInfo(String blNo, String corrNo) throws EventException ;
	 
	 /**
	 * C/A Report_B/L Inquiry >>> Marks&Desc Info. (ESM_BKG_0570)를 조회합니다.<br>
	 * 
	 * @param String blNo
	 * @param String corrNo
	 * @return List<CaInquiryReportVO>
	 * @throws EventException
	 */
	 public List<CaInquiryReportVO> searchCaByMarkDescInfo(String blNo, String corrNo) throws EventException ;
		 
	 /**
	 * C/A Report_B/L Inquiry >>> Container Info. (ESM_BKG_0570)를 조회합니다.<br>
	 * 
	 * @param String blNo
	 * @param String corrNo
	 * @return List<CaInquiryReportVO>
	 * @throws EventException
	 */
	 public List<CaInquiryReportVO> searchCaByContainerInfo(String blNo, String corrNo) throws EventException ;	 

    /**
	 * 1057 FCL List 정보를 조회합니다.<br>
	 * @param searchFCLListVO searchFCLListVO
	 * @return List<searchFCLListVO>
	 * @throws EventException
	 */
	public  List<SearchFCLListVO> searchFCLList(SearchFCLListVO searchFCLListVO)throws EventException ;
	
	/**
	 * 0066 B/L Processing Report 정보를 조회합니다.<br>
	 * 
	 * @param DocTurnTimeInVO docTurnTimeInVO
	 * @return List<DocTurnTimeOutVO>
	 * @throws EventException
	 */
	 public List<DocTurnTimeOutVO> searchBlTurnTimeReport(DocTurnTimeInVO docTurnTimeInVO) throws EventException;
	 
	 /**
	  * 0940 I/B DOC Performance Report 정보를 조회합니다.<br>
	  * 
	  * @param InBoundReportInVO inBoundReportInVO
	  * @return List<InBoundReportOutVO>
	  * @throws EventException
	  */
	 public List<InBoundReportOutVO> searchInBoundPfmcReport(InBoundReportInVO inBoundReportInVO)  throws EventException;

	 /**
	  * 0274 General Cargo Manifest by VVD/PORT 정보를 조회합니다.<br>
	  * 
	  * @param BlCargoManifestInVO blCargoManifestInVO
	  * @return List<BlCargoManifestOutVO>
	  * @throws EventException
	  */
	 public List<BlCargoManifestOutVO> searchBLCargoManifestList(BlCargoManifestInVO blCargoManifestInVO)  throws EventException ;
	 
	 /**
	  * 0274 General Cargo Manifest by VVD/PORT 정보를 Container단위로 조회합니다.<br>
	  * 
	  * @param BlCargoManifestInVO blCargoManifestInVO
	  * @return List<BlCntrCargoManifestOutVO>
	  * @throws EventException
	  */
	 public List<BlCntrCargoManifestOutVO> searchBLCntrCargoManifestList(BlCargoManifestInVO blCargoManifestInVO)  throws EventException ;
	 
	 
	 /**
	  * 0410 Performance Report by Volume 정보를 조회합니다.<br>
	  * 
	  * @param SearchDPCSVolListInVO searchDPCSVolListInVO
	  * @return List<SearchDPCSVolListOutVO>
	  * @throws EventException
	  */
	 public List<SearchDpcsPerfByVolListVO> searchDPCSVolList(SearchDPCSVolListInVO searchDPCSVolListInVO)  throws EventException;	 
	 
	/**
	 * C/A Summary Report 결과를 조회한다. (ESM_BKG_0174)<br>
	 * 
	 * @param  CaSummaryReportInVO vo
	 * @return List<CaSummaryReportOutVO>
	 * @throws EventException
	 */	
    public List<CaSummaryReportOutVO> searchCaSummaryReport(CaSummaryReportInVO vo) throws EventException;
    
    /**
	 * C/A Summary Report BL List 결과를 조회한다. (ESM_BKG_0174)<br>
	 * 
	 * @param  CaSummaryReportInVO vo
	 * @return List<CaSummaryReportOutVO>
	 * @throws EventException
	 */	
    public List<CaSummaryReportOutVO> searchCaSummaryReportBLList(CaSummaryReportInVO vo) throws EventException;
    
    /**
	  * 0985 Queue Detail Return 정보를 조회합니다.<br>
	  * @param  DocQueueDetailReturnInVO docQueueDetailReturnInVO 
	  * @return List<DocQueueDetailReturnInVO>
	  * @throws EventException
	  */
	 public List<DocQueueDetailReturnInVO> searchQueueDetailReturn(DocQueueDetailReturnInVO docQueueDetailReturnInVO) throws EventException;

	 /**
	  * 0985 Queue Detail Return 정보를 조회합니다.<br>
	  * @param  SearchQueueDetailReturnReasonCdListVO vo
	  * @return List<DocQueueDetailReturnInVO>
	  * @throws EventException
	  */
	 public List<SearchQueueDetailReturnReasonCdListVO> searchQueueDetailReturnReasonCdList(SearchQueueDetailReturnReasonCdListVO vo) throws EventException;

	 
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
	 * Correction(C/A) 월별 Summary Batch. (BAT_BKG_004)<br>
	 * 
	 * @param String fromDt
	 * @param String toDt
	 * @exception EventException
	 */	
    public void manageCASummary(String fromDt, String toDt) throws EventException; 

	/**
	 * 1073 Customer EDI ID Inquiry 정보를 조회합니다.<br>
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
     * 0104 Report template(Default, Detail, User Set) 을 트랜잭션 처리합니다.<br>	
     * 
	 * @param ReportTemplateListVO[] reportTemplateListVO
	 * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageReportTemplateBstVipList(ReportTemplateListVO[] reportTemplateListVO,SignOnUserAccount account) throws EventException;

	/**
	 *  1004 Super User Authority Change - PIC CHANGE(0421화면) 버튼 클릭시 관련 데이블 데이타를 수정합니다.<br>
	 *  
	 * @param DocsUserGroupCdVO docsUserGroupCdVO
	 * @param SignOnUserAccount account
     * @exception EventException
	 */
	public void modifyDocsUserGroupCd(DocsUserGroupCdVO docsUserGroupCdVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Container NO , Type Size - bkg_no 별 머지함 
	 * bkgCzStsCd: Container NO - "CN", Type Size - "CQ" 
	 * @param  String bkgNo 
	 * @param  String bkgCzStsCd   
	 * @throws EventException
	 */
	public void manageQtyCntrCoposite(String bkgNo , String bkgCzStsCd )throws EventException;
	
	/**
	 * BKG_AUTO_RT_HIS 생성작업<br>
	 * @param  String bkgNo 
	 * @throws EventException
	 */
	public void addAutoRtHistory(String bkgNo) throws EventException ;
	
	 /**
	  * Autorating Accuracy monitoring Report 조회(ESM_BKG_1081).<br>
	  * 1.Autorating Accuracy Ration<br>
	  * 
	  * @param  AutoratingReportVO autoratingReportVO
	  * @return List<AutoratingReportVO>
	  * @throws EventException
	  */
	 public List<AutoratingReportVO> searchAutoratingReport(AutoratingReportVO autoratingReportVO) throws EventException ;
	
	 /**
	  * Autorating Accuracy monitoring Report 조회(ESM_BKG_1081).<br>
	  * 2.Autorating B/L List<br>
	  * 
	  * @param  AutoratingReportVO autoratingReportVO
	  * @return List<AutoratingReportVO>
	  * @throws EventException
	  */
	 public List<AutoratingReportVO> searchAutoBLListReport(AutoratingReportVO autoratingReportVO) throws EventException ;
		
	 /**
	  * Autorating Accuracy monitoring Report 조회(ESM_BKG_1081).<br>
	  * 3.Non Autorating B/L List<br>
	  * 
	  * @param  AutoratingReportVO autoratingReportVO
	  * @return List<AutoratingReportVO>
	  * @throws EventException
	  */
	 public List<AutoratingReportVO> searchNonAutoratingReport(AutoratingReportVO autoratingReportVO) throws EventException ;
	
	 /**
	  * 1 weeks Daily Booking Trend by Customer 조회(ESM_BKG_1082).<br>
	  * 
	  * @param  SearchBookingTrendReportVO vo
	  * @return List<SearchBookingTrendReportVO>
	  * @throws EventException
	  */
	 public List<SearchBookingTrendReportVO> searchBookingTrendReport(SearchBookingTrendReportVO vo) throws EventException ;
	
	 /**
	  * 2 weeks Daily Booking Trend by Customer >>> B/L Detail 조회(ESM_BKG_1083).<br>
	  * 
	  * @param  SearchBookingTrendReportVO vo
	  * @return List<SearchBookingTrendReportVO>
	  * @throws EventException
	  */
	 public List<SearchBookingTrendReportVO> searchBookingTrendReportBLDetail(SearchBookingTrendReportVO vo) throws EventException ;
	
	 /**
	  * 3 weeks Daily Booking Trend by Customer Detail 엑셀 조회(ESM_BKG_1082).<br>
	  * 
	  * @param  SearchBookingTrendReportVO vo
	  * @return List<SearchBookingTrendReportVO>
	  * @throws EventException
	  */
	 public List<SearchBookingTrendReportVO> searchBookingTrendReportDeail(SearchBookingTrendReportVO vo) throws EventException ;
	 /**
	  * Booking 에서 Cancel 처리 할 경우  Status 업데이트 처리한다.<br>
	  * 
	  * @param  String bkgNo
	  * @param  String bkgSrCrntRqst
	  * @param  String srWrkStsCd
	  * @throws EventException
	  */
	 public void modifyQueueByBkg(String bkgNo, String bkgSrCrntRqst, String srWrkStsCd ) throws EventException;

	 /**
	  * 중국 EDI 수신
	  * @param rcvMsg String
	  * @throws EventException
	  */
	 public void loadRcvMsg(String rcvMsg) throws EventException;
	 
	 /**
	 * Email Account Set-up for Front Office 를 추가/수정/삭제 한다. (ESM_BKG_048)
	 * 
	 * @param BkgEmlAcctStupVO[] bkgEmlAcctStups
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBkgEmlAcctStup(BkgEmlAcctStupVO[] bkgEmlAcctStups, SignOnUserAccount account) throws EventException ;
	
	
	/**
	  * Email Account Set-up for Front Office 조회(ESM_BKG_0425).<br>
	  * 
	  * @param  BkgEmlAcctStupVO bkgEmlAcctStupVO
	  * @return List<BkgEmlAcctStupVO>
	  * @throws EventException
	  */
	 public List<BkgEmlAcctStupVO> searchBkgEmlAcctStupList(BkgEmlAcctStupVO bkgEmlAcctStupVO) throws EventException;
	 
	 /**
     * 조회 이벤트 처리<br>
     * Queue List Set Serarch 조회(ESM_BKG_0446).<br>
     * 
     * @param String usrId
     * @return List<BkgXterSrchSetVO>
     * @exception EventException
     */
    public List<BkgXterSrchSetVO> searchQueueListSearchSetList(String usrId) throws EventException;
    
    /**
     * Queue List Set Serarch Where 조회(ESM_BKG_0446).<br>
     * 
     * @param String usrId
     * @return String
     * @exception EventException
     */
    public String searchQueueListSearchSetWhere(String usrId) throws EventException ;
    
    /**
	  * 0445 DPCS SPLIT List 정보를 조회합니다.<br>
	  * @param  DpcsSiSplitCandidateVO vo
	  * @return List<DpcsSiSplitCandidateVO>
	  * @throws EventException
	  */
	 public List<DpcsSiSplitCandidateVO> searchDpcsSiSplitCandidate(DpcsSiSplitCandidateVO vo) throws EventException;

	 /**
	  * 0445 DPCS SPLIT Cntr Hist 정보를 조회합니다.<br>
	  * @param  DpcsSiSplitBkgCntrHisVO vo
	  * @return List<DpcsSiSplitBkgCntrHisVO>
	  * @throws EventException
	  */
	 public List<DpcsSiSplitBkgCntrHisVO> searchDpcsSiSplitCntrHis(DpcsSiSplitBkgCntrHisVO vo) throws EventException ;
	
	 /**
	  * 0449 DPCS SPLIT Cntr Compare Result List 정보를 조회합니다.<br>
	  * @param  DpcsSiSplitBkgCntrCompareResultVO vo
	  * @return List<DpcsSiSplitBkgCntrCompareResultVO>
	  * @throws EventException
	  */
	 public List<DpcsSiSplitBkgCntrCompareResultVO> searchDpcsSiSplitBkgCntrCompareResult(DpcsSiSplitBkgCntrCompareResultVO vo) throws EventException ;

	/**
	 * 0423 Queue Summary - Status by S/I Event 정보를 조회합니다.<br>
	 * 
	 * @param  SearchQueueSummaryInVO searchQueueSummaryInVO
	 * @return List<DocQueueSummaryStatusVO>
	 * @throws EventException
	 */
	public List<DocQueueSummaryStatusVO> searchQueueSummaryStatus(SearchQueueSummaryInVO searchQueueSummaryInVO) throws EventException;

	/**
	 * 0423 Queue Summary - By SR Kind 정보를 조회합니다.<br>
	 * 
	 * @param  SearchQueueSummaryInVO searchQueueSummaryInVO
	 * @return List<DocQueueSummarySRKindVO>
	 * @throws EventException
	 */
	public List<DocQueueSummarySRKindVO> searchQueueSummarySRKind(SearchQueueSummaryInVO searchQueueSummaryInVO) throws EventException;

	/**
	 * 0423 Queue Summary - Just in Time(JIT) Completence 정보를 조회합니다.<br>
	 * 
	 * @param  SearchQueueSummaryInVO searchQueueSummaryInVO
	 * @return List<DocQueueSummaryJITCompletenceVO>
	 * @throws EventException
	 */
	public List<DocQueueSummaryJITCompletenceVO> searchQueueSummaryJITCompletence(SearchQueueSummaryInVO searchQueueSummaryInVO) throws EventException;

	/**
	 * 0423 Queue Summary - By Urgency 정보를 조회합니다.<br>
	 * 
	 * @param  SearchQueueSummaryInVO searchQueueSummaryInVO
	 * @return List<DocQueueSummaryUrgencyVO>
	 * @throws EventException
	 */
	public List<DocQueueSummaryUrgencyVO> searchQueueSummaryUrgency(SearchQueueSummaryInVO searchQueueSummaryInVO) throws EventException;

	/**
	 * 0423 Queue Summary - By Return Feedback Status 정보를 조회합니다.<br>
	 * 
	 * @param  SearchQueueSummaryInVO searchQueueSummaryInVO
	 * @return List<DocQueueSummaryReturnFeedbackVO>
	 * @throws EventException
	 */
	public List<DocQueueSummaryReturnFeedbackVO> searchQueueSummaryReturnFeedback(SearchQueueSummaryInVO searchQueueSummaryInVO) throws EventException;

	/**
	 * 0423 Queue Summary - Aging Status(P.F) 정보를 조회합니다.<br>
	 * 
	 * @param  SearchQueueSummaryInVO searchQueueSummaryInVO
	 * @return List<DocQueueSummaryAgingVO>
	 * @throws EventException
	 */
	public List<DocQueueSummaryAgingVO> searchQueueSummaryAging(SearchQueueSummaryInVO searchQueueSummaryInVO) throws EventException;

	/**
	 * 0412 - DPCS Weight Value를 수정합니다.
	 * 
	 * @param BkgDpcsDocWeightVO[] bkgDpcsDocWeightVOs
	 * @param String usr_id
	 * @throws EventException
	 */
	public void modifyDpcsWeightValue(BkgDpcsDocWeightVO[] bkgDpcsDocWeightVOs, String usr_id) throws EventException;

	/**
	 * 0415 - DPCS Point List를 조회합니다.<br>
	 * 
	 * @param BkgDpcsDocWeightVO bkgDpcsDocWeightVO
	 * @return List<BkgDpcsDocWeightVO>
	 * @throws EventException
	 */
	public List<BkgDpcsDocWeightVO> searchDPCSPointList(BkgDpcsDocWeightVO bkgDpcsDocWeightVO) throws EventException;

	/**
	 * 0432 - B/L Perform Volume By Region Group List를 조회합니다.
	 * 
	 * @param SearchPerfVolByRegionGroupInVO searchPerfVolByRegionGroupInVO
	 * @return List<SearchPerfVolByRegionGroupListVO>
	 * @throws EventException
	 */
	public List<SearchPerfVolByRegionGroupListVO> searchBlPerfVolByRegionGroupList(SearchPerfVolByRegionGroupInVO searchPerfVolByRegionGroupInVO) throws EventException;

	/**
	 * 0432 - B/L Perform Volume By Region Group Detail List를 조회합니다.<br>
	 * 
	 * @param SearchPerfVolByRegionGroupInVO searchPerfVolByRegionGroupInVO
	 * @return List<SearchPerfVolByRegionGroupDtlListVO>
	 * @throws EventException
	 */
	public List<SearchPerfVolByRegionGroupDtlListVO> searchBlPerfVolByRegionGroupDtlList(SearchPerfVolByRegionGroupInVO searchPerfVolByRegionGroupInVO) throws EventException;

	/**
	 * 0415 - Report By Inputter User Group List를 조회합니다.<br>
	 * 
	 * @param SearchPerfVolByRegionGroupInVO searchPerfVolByRegionGroupInVO
	 * @return List<SearchReportByInputterUserGroupListVO>
	 * @throws EventException
	 */
	public List<SearchReportByInputterUserGroupListVO> searchReportByInputterUserGroupList(SearchPerfVolByRegionGroupInVO searchPerfVolByRegionGroupInVO) throws EventException;
	
	/**
	 * 0415 - Report By Inputter User Group Detail List를 조회합니다.
	 * 
	 * @param SearchPerfVolByRegionGroupInVO searchPerfVolByRegionGroupInVO
	 * @return List<SearchPerfVolByRegionGroupDtlListVO>
	 * @throws EventException
	 */
	public List<SearchPerfVolByRegionGroupDtlListVO> searchReportByInputterUserGroupDtlList(SearchPerfVolByRegionGroupInVO searchPerfVolByRegionGroupInVO) throws EventException;

	/**
	 * 0415 - Report By Rater User Group List를 조회합니다.
	 * 
	 * @param SearchPerfVolByRegionGroupInVO searchPerfVolByRegionGroupInVO
	 * @return List<SearchReportByRaterUserGroupListVO>
	 * @throws EventException
	 */
	public List<SearchReportByRaterUserGroupListVO> searchReportByRaterUserGroupList(SearchPerfVolByRegionGroupInVO searchPerfVolByRegionGroupInVO) throws EventException;
	
	/**
	 * BOOKING S/I KIND에 따른 VALUE 자동 세팅<br>
	 * call_pgm_type 세팅 값 1.QA 2.F,B<br>
	 * call_pgm_type doc_tp_cd B-BL Confim,E-AES,C-CAED,I-IE<br>
	 * 
	 * @param ModifySiValAutoVO modifySiValAutoVO
	 * @param String call_pgm_type
	 * @return ModifySiValAutoVO
	 * @exception  EventException
	 */
	public ModifySiValAutoVO modifySiValAuto(ModifySiValAutoVO modifySiValAutoVO,String call_pgm_type) throws EventException;


	/**
		 * TRO 현황 조회 화면(ESM_BKG_1123).
		 * @param TroEurStatusListInVO vo
		 * @return List<TroEurStatusListInVO>
		 * @throws EventException
		 */
	public List<TroEurStatusListInVO> searchEurTroStatusList(TroEurStatusListInVO vo) throws EventException ;


	/**
	 * @param DocQueueBkgHistListVO vo
	 * @param DocQueueBkgHistListVO[] vos
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void sendMailDcube(DocQueueBkgHistListVO vo,
			DocQueueBkgHistListVO[] vos, SignOnUserAccount account) throws EventException ;


	/**
	 * @param SearchSREmlReceivingListVO[] searchSREmlReceivingListVOs
	 * @param String usr_id
	 * @throws EventException
	 */
	public void modifyReceivingList(
			SearchSREmlReceivingListVO[] searchSREmlReceivingListVOs,
			String usr_id) throws EventException ;


	/**
	 * @param SearchSREmlReceivingListVO searchSREmlReceivingListVO
	 * @return List<SearchSREmlReceivingListVO>
	 * @throws EventException
	 */
	public List<SearchSREmlReceivingListVO> searchSiAutoSREmlReceivingList(
			SearchSREmlReceivingListVO searchSREmlReceivingListVO)throws EventException ;
	 
	/**
	  * 첨부파일의 재변환을 위해 메일을 전송한다.
	  * 첨부된 파일에 가로/세로 양식이 혼재된 경우 OCR인식률이 떨어져 재변환이 필요한 경우 사용하는 기능.
	  * 
	  * @param SearchSREmlCtntVO vo
	  * @param SignOnUserAccount account
	  * @exception EventException
	  */	
	 public void sendEmlConversionRequest(SearchSREmlCtntVO vo, SignOnUserAccount account) throws EventException;


	/**
	 * @param SearchBkgSrProcHisListVO searchBkgSrProcHisListVO
	 * @return List<SearchBkgSrProcHisListVO>
	 * @throws EventException
	 */
	public List<SearchBkgSrProcHisListVO> searchBkgSrProcHisList(
			SearchBkgSrProcHisListVO searchBkgSrProcHisListVO) throws EventException ;
	
	/**
	 * @param BkgCorrCngDpcsUsrVO bkgCorrCngDpcsUsrVO
	 * @return List<BkgCorrCngDpcsUsrVO>
	 * @throws EventException
	 */
	public List<BkgCorrCngDpcsUsrVO> searchDPSCCngUserGroup(
			BkgCorrCngDpcsUsrVO bkgCorrCngDpcsUsrVO) throws EventException ;
	
	/**
	 *  1140 Correction Change - PIC CHANGE(0421화면) 버튼 클릭시 관련 데이블 데이타를 수정합니다.<br>
	 *  
	 * @param BkgCorrCngDpcsUsrVO docsUserGroupCdVO
	 * @param DocQueueDetailListVO docQueueDetailListVO
	 * @param SignOnUserAccount account
     * @exception EventException
	 */
	public void modifyDocsUserCngGroupCd(BkgCorrCngDpcsUsrVO docsUserGroupCdVO, DocQueueDetailListVO docQueueDetailListVO, SignOnUserAccount account) throws EventException;
	
	/**
	 *  SI Turn Time Report - Summary 를 조회
	 *  
	 * @param SiTurnTimeVO vo
	 * @return List<SiTurnTimeSummaryVO>
     * @exception EventException
	 */
	public List<SiTurnTimeSummaryVO> searchSiTurnTimeSummary(SiTurnTimeVO vo) throws EventException;
	/**
	 *  SI Turn Time Report - Detail 를 조회
	 *  
	 * @param SiTurnTimeVO vo
	 * @return List<SiTurnTimeDetailVO>
     * @exception EventException
	 */
	public List<SiTurnTimeDetailVO> searchSiTurnTimeDetail(SiTurnTimeVO vo) throws EventException;
	
	/**
	 *  SI Turn Time Report - Detail SS 를 조회
	 *  
	 * @param SiTurnTimeVO vo
	 * @return List<SiTurnTimeDetailVO>
     * @exception EventException
	 */
	public List<SiTurnTimeDetailVO> searchSiTurnTimeDetailSs(SiTurnTimeVO vo) throws EventException;
	


	/**
	 * Queue Status Report - Region별 결과를 조회한다. (ESM_BKG_0463)<br>
	 * 
	 * @param QueueStatusVO vo
	 * @return List<QueueStatusVO>
	 * @exception EventException
	 */
	public List<QueueStatusVO> searchQueueStatusByRegion(QueueStatusVO vo) throws EventException;

	/**
	 * Queue Status Report - Office별 결과를 조회한다. (ESM_BKG_0463)<br>
	 * 
	 * @param QueueStatusVO vo
	 * @return List<QueueStatusVO>
	 * @exception EventException
	 */
	public List<QueueStatusVO> searchQueueStatusByOffice(QueueStatusVO vo) throws EventException;

	/**
	 * Queue Status Report - Office별 결과를 조회한다. (ESM_BKG_0463)<br>
	 * 
	 * @param QueueStatusVO vo
	 * @return List<QueueStatusDetailVO>
	 * @exception EventException
	 */
	public List<QueueStatusDetailVO> searchQueueStatusDetail(QueueStatusVO vo) throws EventException;

	/**
	 * ProductionRatio Report - RHQ별 결과를 조회한다. (ESM_BKG_0464)<br>
	 * 
	 * @param ProductionRatioVO vo
	 * @return List<ProductionRatioVO>
	 * @exception EventException
	 */
	public List<ProductionRatioVO> searchProductionRatioByRegion(ProductionRatioVO vo) throws EventException;

	/**
	 * ProductionRatio Report - Office별 결과를 조회한다. (ESM_BKG_0464)<br>
	 * 
	 * @param ProductionRatioVO vo
	 * @return List<ProductionRatioVO>
	 * @exception EventException
	 */
	public List<ProductionRatioVO> searchProductionRatioByOffice(ProductionRatioVO vo) throws EventException;
	
	/**
	 * ProductionRatio Report - 상세 목록을 조회한다. (ESM_BKG_0464)<br>
	 * 
	 * @param ProductionRatioVO vo
	 * @return List<ProductionRatioDetailVO>
	 * @exception EventException
	 */
	public List<ProductionRatioDetailVO> searchProductionRatioDetail(ProductionRatioVO vo) throws EventException;
	
	/**
	 * @category ESM_BKG_0436
	 * @category searchDPSCUser
	 * DPCS - S/R 업무처리 담당자 정보를 Searchg한다<br>
	 * 
	 * @param String usrId
	 * @param String dpcsWrkGrpCd
	 * @param String rgnOfcCd
	 * @param BkgDpcsUsrGrpVO   vo
	 * @return List<BkgDpcsUsrGrpVO>
	 * @exception EventException
	 */

	public List<BkgDpcsUsrGrpVO> searchDPCSUser(String usrId, String dpcsWrkGrpCd,String rgnOfcCd, BkgDpcsUsrGrpVO vo) throws EventException;
	
	
	/**
	 * e-Booking & S/I by Email 실적 조회 기능(ESM_BKG_0235)<br>
	 * Report Type : BookingOffice Report (Only) <br>
	 * 
	 * @param EBkgSiPfmcInVO vo
	 * @param boolean detail
	 * @return List<EBkgSiPfmcInVO>
	 * @throws EventException
	 */
	public List<EBkgSiPfmcInVO> searchEBkgSiPfmcListByEmail(EBkgSiPfmcInVO vo, boolean detail) throws EventException;
	
	/**
	 * e-Booking & S/I by Email 실적 엑셀 다운로드 기능(ESM_BKG_0235)<br>
	 * Report Type : BookingOffice Report (Only) <br>
	 * 
	 * @param EBkgSiPfmcInVO vo
	 * @return DBRowSet
	 * @throws EventException
	 */
	public DBRowSet searchEBkgSiPfmcListByEmailForExcelDown(EBkgSiPfmcInVO vo) throws EventException;
	
	/**
	 * 해당 BKG이 Front Office Type으로 접수된 적이 있는지 조회한다.<br>
	 * 
	 * @param String bkgNo
	 * @return String
	 * @throws EventException
	 */
	public String searchFrontOfficeFlag(String bkgNo) throws EventException;	



	/**
	 * ESM_BKG_0236 : e-BKG & SI Turn Time Summary를 조회합니다.
	 * 
	 * @param EBkgSiTurnTimeInVO eBkgSiTurnTimeInVO
	 * @return List<EBkgSiTurnTimeOutVO>
	 * @throws EventException
	 */
	public List<EBkgSiTurnTimeOutVO> searchEBkgSiTurnTimeSummary(EBkgSiTurnTimeInVO eBkgSiTurnTimeInVO) throws EventException; 


	/**
	 * ESM_BKG_0236 : e-BKG & SI Turn Time Detail을 조회합니다.
	 * 
	 * @param EBkgSiTurnTimeInVO eBkgSiTurnTimeInVO
	 * @param EBkgSiTurnTimeInVO[] eBkgSiTurnTimeInVOs
	 * @return List<EBkgSiTurnTimeOutVO>
	 * @throws EventException
	 */
	public List<EBkgSiTurnTimeOutVO> searchEBkgSiTurnTimeDetail(EBkgSiTurnTimeInVO eBkgSiTurnTimeInVO, EBkgSiTurnTimeInVO[] eBkgSiTurnTimeInVOs) throws EventException;


	/**
	 * ESM_BKG_0236 : e-BKG & SI Upload Time Summary를 조회합니다.
	 * 
	 * @param EBkgSiTurnTimeInVO eBkgSiTurnTimeInVO
	 * @return List<EBkgSiTurnTimeOutVO>
	 * @throws EventException
	 */
	public List<EBkgSiTurnTimeOutVO> searchEBkgSiUploadTimeSummary(EBkgSiTurnTimeInVO eBkgSiTurnTimeInVO) throws EventException;


	/**
	 * ESM_BKG_0236 : e-BKG & SI Upload Time Detail을 조회합니다.
	 * 
	 * @param EBkgSiTurnTimeInVO eBkgSiTurnTimeInVO
	 * @param EBkgSiTurnTimeInVO[] eBkgSiTurnTimeInVOs
	 * @return List<EBkgSiTurnTimeOutVO>
	 * @throws EventException
	 */
	public List<EBkgSiTurnTimeOutVO> searchEBkgSiUploadTimeDetail(EBkgSiTurnTimeInVO eBkgSiTurnTimeInVO, EBkgSiTurnTimeInVO[] eBkgSiTurnTimeInVOs) throws EventException;
	
	/**
	 * Doc Performance Report(ESM_BKG_0214)<br>
	 * Doc Performance Report에서 사용할 Region Office 목록을 불러온다.<br>
	 *
	 * @return List<BkgComboVO>
	 * @throws EventException
	 */
	public List<BkgComboVO> searchRgnOfficeCdForPFMC() throws EventException;
	
	/**
	 * TRO 현황 조회 화면(ESM_BKG_0621).
	 * @param TroUsaStatusListInVO vo
	 * @return List<TroUsaStatusListInVO>
	 * @throws EventException
	 */
	public List<TroUsaStatusListInVO> searchTroUsaStatusList(TroUsaStatusListInVO vo) throws EventException ;
	
	/**
	 * WEB SI Auto Upload 후 Queue List와 History 를 변경한다.
	 * 
	 * @param BkgWebServiceVO vo
	 * @exception EventException
	 */
	public void modifyQueueByAutoUpload(BkgWebServiceVO vo) throws EventException;
	
	/**
	 * WEB SI Audit 후 Queue List와 History 를 변경한다.
	 * 
	 * @param SIWebServiceVO vo
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int modifyQueueByWebSiAudit(SIWebServiceVO vo,  SignOnUserAccount account) throws EventException ;
}