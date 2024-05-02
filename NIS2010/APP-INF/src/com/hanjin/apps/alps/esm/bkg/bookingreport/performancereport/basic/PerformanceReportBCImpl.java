/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : PerformanceReportBCImpl.java
 *@FileTitle : bookingReport
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.01
 *@LastModifier : 강동윤
 *@LastVersion : 1.0
 * 2009.06.01 강동윤
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2011.05.16 김상수 [CHM-201109394-01] DPCS 고도화 요청 - B/L Turn Time Report (ESM_BKG_0067) 화면, 쿼리, VO및 java Method들의 전면수정
 * 2011.07.22 채창호 CHM-201111754-01:[UI_BKG_1123]TRO Status Report (EUR) 화면 개발
 * 2011.07.19 김진승 [CHM-201111820] Split 03-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치; File 관련 FileUtils 사용으로 변경;
 * 2011.10.04 정선용 [CHM-201112445] SI Automation System 구축
 * 2011.10.18 조원주 [CHM-201113594] DPCS-SI Turn Time레포트 및 Draft B/L전송후 Amendment S/I PIC변경관련 개발요구사항 송부
 * 2011.11.22 정선용 [CHM-201114286-01] DPCS-SI Turn Time레포트 및 Draft B/L전송후 Amendment S/I PIC변경관련 개발요구사항 송부
 * 2011.11.30 정선용 [CHM-201114554-01] DPCS-Correction 기능 보완 요청
 * 2011.12.08 금병주 [CHM-201114555-01] DPCS Correction 기능 보완 -2
 * 2012.01.07 조정민 [CHM-201221961] Email 접수 Draft B/L Correction 분류 시스템 개발
 * 2013.06.24 김진주 [CHM-201324100] E-BKG & E-SI Turn Time Report 
 * 2013.06.24 김진주 [CHM-201325117] Split 03-[ALPS 데이터품질 - BKG validation 로직보완] 6월 대상 건에 대한 진행 요청 건
 * 2013.11.06 김진주 [CHM-201327291][SZP DPCS] 라이브 적용일자 및 시스템 개선사항 요청
 * 2014.06.13 조인영 [CHM-201430236] 미주 서비스 센터 통합 관련 시스템 개발 4차 - TRO Report 신규 생성 (USA)
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import weblogic.wsee.util.StringUtil;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgHrdCdgCtntListCondVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgWebServiceVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.SIWebServiceVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration.PerformanceReportDBDAO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration.PerformanceReportEAIDAO;
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
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.io.FileUtils;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgDpcsUsrGrpVO;
import com.hanjin.syscommon.common.table.BkgHrdCdgCtntVO;
import com.hanjin.syscommon.common.table.BkgObChnRcvHisVO;
import com.hanjin.syscommon.common.table.BkgObChnRcvVO;
import com.hanjin.syscommon.common.table.BkgXterSrchSetVO;
import com.hanjin.syscommon.common.util.TiffSplitUtil;
/**
 * NIS2010-BookingReport Business Logic Basic Command implementation<br>
 * - NIS2010-BookingReport에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author kang dong yun
 * @see ESM_BKG_0753EventResponse,PerformanceReportBC 각 DAO 클래스 참조
 * @since J2EE 1.6    
 */  
public class PerformanceReportBCImpl extends BasicCommandSupport implements PerformanceReportBC {
 
	// Database Access Object
	private transient PerformanceReportDBDAO dbDao = null;
 
	/**
	 * PerformanceReportBCImpl 객체 생성<br>
	 * PerformanceReportDBDAO를 생성한다.<br>
	 */
	public PerformanceReportBCImpl() {
		dbDao = new PerformanceReportDBDAO();
	}

	/**
	 * VVD Selection Inquiry 결과를 조회한다. (ESM_BKG_0753)<br>
	 * 
	 * @param VesselVVDListVO vesselVVDListVO
	 * @return List<VesselVVDListVO>  
	 * @throws EventException  
	 */
	public List<VesselVVDListVO> searchVVDList(VesselVVDListVO vesselVVDListVO) throws EventException {
		try {
			return dbDao.searchVVDList(vesselVVDListVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * VVD Selection Inquiry 유효성을 체크한다. (ESM_BKG_0753)<br>
	 * 
	 * @param VesselVVDListVO vesselVVDListVO
	 * @throws EventException
	 */
	public void checkVVDList(VesselVVDListVO[] vesselVVDListVO) throws EventException {

		try {
			for (int i = 0; i < vesselVVDListVO.length; i++) {
				dbDao.checkVVDList(vesselVVDListVO[i]);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * C/A Summary Template 결과를 조회한다. (ESM_BKG_0767)<br>
	 * 
	 * @param BkgRptDfltVO bkgRptDfltVO
	 * @return List<BkgRptDfltVO>
	 * @throws EventException
	 */
	public List<BkgRptDfltVO> searchReportTemplateList(BkgRptDfltVO bkgRptDfltVO) throws EventException {
		try {
			return dbDao.searchReportTemplateList(bkgRptDfltVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * C/A Summary Template 을 추가/수정한다. (ESM_BKG_0767)<br>
	 * 
	 * @param BkgRptDfltVO[] bkgRptDfltVOS
	 * @throws EventException
	 */
	public void addReportTemplate(BkgRptDfltVO[] bkgRptDfltVOS) throws EventException {

		try {
			for (int i = 0; i < bkgRptDfltVOS.length; i++) {
				if (bkgRptDfltVOS[i].getIbflag().equals("I")) {

					dbDao.addReportTemplate(bkgRptDfltVOS[i]);
				} else if (bkgRptDfltVOS[i].getIbflag().equals("U")) {

					dbDao.modifyReportTemplate(bkgRptDfltVOS[i]);
				} else if (bkgRptDfltVOS[i].getIbflag().equals("D")) {

					dbDao.removeReportTemplate(bkgRptDfltVOS[i]);
				}
			}

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * C/A Summary Template 을 삭제한다. (ESM_BKG_0767)<br>
	 * 
	 * @param BkgRptDfltVO[] bkgRptDfltVOS
	 * @throws EventException
	 */
	public void removeReportTemplate(BkgRptDfltVO[] bkgRptDfltVOS) throws EventException {

		try {
			for (int i = 0; i < bkgRptDfltVOS.length; i++) {
				if (bkgRptDfltVOS[i].getIbflag().equals("D")) {

					dbDao.removeReportTemplate(bkgRptDfltVOS[i]);
				}
			}

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * BDR Status를 기간 및 BKG Office별로 조회한다.
	 * 
	 * @param BDRBookingStatusListVO bdrBookingStatusListVO
	 * @return List<BDRBookingStatusListVO>
	 * @exception EventException
	 */
	public List<BDRBookingStatusListVO> searchBDRBookingPfmcStatusList(BDRBookingStatusListVO bdrBookingStatusListVO) throws EventException {
		try {
			return dbDao.searchBDRBookingPfmcStatusList(bdrBookingStatusListVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * SR Receiving List 결과를 조회한다. (ESM_BKG_0488)<br>
	 * 
	 * @param SearchSRReceivingListVO vo
	 * @return List<SearchSRReceivingListVO>
	 * @exception EventException
	 */
	public List<SearchSRReceivingListVO> searchSRReceivingList(SearchSRReceivingListVO vo) throws EventException {

		try {
			return dbDao.searchSRReceivingList(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	/**
	 * SR EMAIL Receiving List 결과를 조회한다. (ESM_BKG_0488)<br>
	 * 
	 * @param SearchSREmlReceivingListVO vo
	 * @return List<SearchSREmlReceivingListVO>
	 * @exception EventException
	 */
	public List<SearchSREmlReceivingListVO> searchSREmlReceivingList(SearchSREmlReceivingListVO vo) throws EventException {

		try {
			return dbDao.searchSREmlReceivingList(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * 
	 * @param SearchSREmlReceivingListVO vo
	 * @return List<SearchSREmlReceivingListVO>
	 * @exception EventException
	 */
	public List<SearchSREmlReceivingListVO> searchSiAutoSREmlReceivingList(SearchSREmlReceivingListVO vo) throws EventException {

		try {
			return dbDao.searchSiAutoSREmlReceivingList(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	  *  SSR EML Fail Receiving이 존재하는지 조회한다 (ESM_BKG_0488)<br>
	  * 
	  * @param SearchSREmlReceivingListVO vo
	  * @return Boolean
	  * @exception EventException
	  */	
	public Boolean chkSREmlFailReceivingList(SearchSREmlReceivingListVO vo) throws EventException {
	 try {
			return dbDao.chkSREmlFailReceivingList(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	  *  SR EMAIL Atch File List 결과를 조회한다. (ESM_BKG_0488)<br>
	  * 
	  * @param SearchSREmlAtchFileListVO vo
	  * @return List<SearchSREmlAtchFileListVO>
	  * @exception EventException
	  */	
	 public List<SearchSREmlAtchFileListVO> searchSREmlAtchFileList(SearchSREmlAtchFileListVO vo) throws EventException {
		try {
			return dbDao.searchSREmlAtchFileList(vo);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[] {}).getMessage(), ex);
		}
	}
	 
	/**
	  * 첨부파일의 재변환을 위해 메일을 전송한다.
	  * 첨부된 파일에 가로/세로 양식이 혼재된 경우 OCR인식률이 떨어져 재변환이 필요한 경우 사용하는 기능.
	  * 
	  * @param SearchSREmlCtntVO vo
	  * @param SignOnUserAccount account
	  * @exception EventException
	  */	
	 public void sendEmlConversionRequest(SearchSREmlCtntVO vo, SignOnUserAccount account) throws EventException {
		try {
			PerformanceReportEAIDAO eaiDao = new PerformanceReportEAIDAO();
			eaiDao.sendEmlConversionRequest(vo, account);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[] {}).getMessage(), ex);
		}
	}
	 
	 /**
	  *  SR EMAIL Contents 결과를 조회한다. (ESM_BKG_0488)<br>
	  * 
	  * @param SearchSREmlCtntVO vo
	  * @return List<SearchSREmlCtntVO>
	  * @exception EventException
	  */	
	 public List<SearchSREmlCtntVO> searchSREmlCtnt(SearchSREmlCtntVO vo)throws EventException {
		try {
			return dbDao.searchSREmlCtnt(vo);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[] {}).getMessage(), ex);
		}
	}
	 
	/**
	 * SR Receiving List Input Remark 를 추가한다. (ESM_BKG_0988)
	 * 
	 * @param String srNo
	 * @param String usrId
	 * @param String srKndCd
	 * @param String rcvRmk
	 * @exception EventException
	 */
	public void addQueueRemark(String srNo, String usrId, String srKndCd, String rcvRmk) throws EventException {

		try {

			// if (srKndCd.equals("I")){
			// dbDao.addQueueRemark(srNo, usrId, srKndCd, rcvRmk);
			// }else if (srKndCd.equals("U")){
			dbDao.modifyQueueRemark(srNo, usrId, srKndCd, rcvRmk);
			// }
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * SR Receiving List 를 추가/수정/삭제 한다. (ESM_BKG_048)
	 * 
	 * @param BkgSrFaxVO[] bkgSrFaxVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSRReceiving(BkgSrFaxVO[] bkgSrFaxVOs, SignOnUserAccount account) throws EventException {

		try {
			for (int i = 0; i < bkgSrFaxVOs.length; i++) {
				if (bkgSrFaxVOs[i].getIbflag().equals("U")) {

					bkgSrFaxVOs[i].setUpdUsrId(account.getUsr_id());
					dbDao.modifySRReceiving(bkgSrFaxVOs[i]);
				} else if (bkgSrFaxVOs[i].getIbflag().equals("D")) {

					bkgSrFaxVOs[i].setUpdUsrId(account.getUsr_id());
					dbDao.removeSRReceiving(bkgSrFaxVOs[i]);
				}
			}

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * SR Receiving List BKG Match & Transfer 에 SrNo에 대한 BkgNo를 가져온다.(ESM_BKG_0489) <br>
	 * 
	 * @param String bkgNo
	 * @param String srNo
	 * @return List<CheckBkgNoVsSrNoVO>
	 * @exception EventException
	 */
	public CheckBkgNoVsSrNoVO checkBkgNoVsSrNo(String bkgNo, String srNo) throws EventException {

		try {
			return dbDao.checkBkgNoVsSrNo(bkgNo, srNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * SR Receiving List BKG Match & Transfer 에 DPCS IP를 가져온다.(ESM_BKG_0489) <br>
	 * 
	 * @param String ofcNo
	 * @return String
	 * @exception EventException
	 */
	public String searchDpcsIp(String ofcNo) throws EventException {

		try {
			return dbDao.searchDpcsIp(ofcNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * SR Receiving List BKG Match & Transfer 에 User Part 정보를 가져온다.(ESM_BKG_0489) <br>
	 * 
	 * @param String usrId
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchUserPartCd(String usrId) throws EventException {

		try {
			return dbDao.searchUesrGroupId(usrId);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * SR Receiving List BKG Match & Transfer 에 AmendReason 정보를 가져온다.(ESM_BKG_0489) <br>
	 * 
	 * @param String srNo
	 * @param String bkgSrKndCd
	 * @param String usrId
	 * @return List<DpcsAmendReasonBkgListVO>
	 * @exception EventException
	 */
	public List<DpcsAmendReasonBkgListVO> searchAmendReasonBkgList(String srNo, String bkgSrKndCd,String usrId) throws EventException {
		try {
			return dbDao.searchAmendReasonBkgList(srNo, bkgSrKndCd,usrId);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * SR Receiving List BKG Match & Transfer 에 Sr 작성 시간을 수정한다.(ESM_BKG_0489) <br>
	 * 
	 * @param String srNo
	 * @param String faxLogRefNo
	 * @param String bkgSrKndCd
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifySrStartTime(String srNo,String faxLogRefNo,String bkgSrKndCd,SignOnUserAccount account) throws EventException {

		try {
			dbDao.modifySrStartTime(srNo, faxLogRefNo, bkgSrKndCd,account);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * SR Receiving List BKG Match & Transfer 에 BkgNo Match 정보를 수정한다.(ESM_BKG_0489) <br>
	 * 
	 * @param DocQueueBkgHistListVO vo
	 * @param String status
	 * @exception EventException
	 */
	public void modifyBkgNoMatch(DocQueueBkgHistListVO vo, String status) throws EventException {

		try {

			dbDao.modifyBkgNoMatch(vo, status);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * SR Receiving List Transfer To Dc 정보를 수정한다.(ESM_BKG_0489) <br>
	 * 
	 * @param ModifySrTransferVO modifySrTransferVO
	 * @exception EventException
	 */
	public void modifySrTransfer(ModifySrTransferVO modifySrTransferVO) throws EventException {

		try {

			dbDao.modifySrTransfer(modifySrTransferVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * SR Receiving List BKG Match & Transfer 에 BkgNo정보를 삭제한다.(ESM_BKG_0489) <br>
	 * 
	 * @param DocQueueBkgHistListVO docQueueBkgHistListVO
	 * @exception EventException
	 */
	public void removeQueueBkgNo(DocQueueBkgHistListVO docQueueBkgHistListVO) throws EventException {

		try {

			dbDao.removeQueueBkgList(docQueueBkgHistListVO);
			dbDao.removeQueueBkgNo(docQueueBkgHistListVO);
			//docQueueBkgHistListVO.getSrNo(),docQueueBkgHistListVO.getFaxLogRefNo(), docQueueBkgHistListVO.getSrKndCd()
			modifyBkgNoMatch(docQueueBkgHistListVO,"DEL");
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * SR Receiving List Transfer To Dc sr_no,bkg_no check.(ESM_BKG_0489) <br>
	 * 
	 * @param DocQueueBkgHistListVO vo
	 * @return List<DocQueueBkgHistListVO>
	 * @exception EventException
	 */
	public List<DocQueueBkgHistListVO> checkBkgNoOrSrNo(DocQueueBkgHistListVO vo) throws EventException {
		try {
			return dbDao.checkBkgNoOrSrNo(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * SR Receiving List BKG Match & Transfer 에 QueaueBkgNo 정보를 수정한다.(ESM_BKG_0489) <br>
	 * 
	 * @param DocQueueBkgHistListVO[] vos
	 * @param DocQueueBkgHistListVO vo
	 * @param SignOnUserAccount account
	 * 
	 * @exception EventException
	 */
	public void manageBkgQueueList(DocQueueBkgHistListVO[] vos,DocQueueBkgHistListVO vo,SignOnUserAccount account) throws EventException {
		
		try {
			String orgImgFileNm = vo.getImgFileNm();
//			String orgImgFileNm = "@20110319112630A0881.tif";
			String imgFilePath = "//a_dpcs" + "/" + vo.getFaxSvrOfcCd()+ "/" + vo.getImgFilePathCtnt();
//			String imgFilePath = "D://dpcs//" ;
			String targetImgFilePath = "//a_dpcs/module/BKG" + "/" + vo.getRcvOfcCd()+ "/" + vo.getImgFilePathCtnt();
//			String targetImgFilePath = "D://dpcs//div//" ;
			
			log.debug("\n imgFilePath:"+imgFilePath );
			log.debug("\n orgImgFileNm:"+orgImgFileNm );
			log.debug("\n targetImgFilePath:"+targetImgFilePath );
			String page = "";
			int start_page = 0;
			int end_page = 0;
			String[] arrayPage = null;
			String targetFileNm = "";
			String[] temp1 = null;
			String[] temp2 = null;
			String srAmdRsnTpCd = null;
			String srHisSeq = "";
			String maxSeq = "";
			int maxSrHisSeq;
			for (int i = 0; i < vos.length; i++) {
				if (vos[i].getIbflag().equals("I")) {
					vos[i].setUpdUsrId(account.getUsr_id());
					
					page = vos[i].getImgPgNo();
					start_page = 0;
					end_page = 0;
					
					arrayPage = page.split("-");
					if (arrayPage.length > 1){
						start_page = Integer.parseInt(arrayPage[0]);
						end_page = Integer.parseInt(arrayPage[1]);
					}else{
						start_page = Integer.parseInt(page);
						end_page = Integer.parseInt(page);
					}
					targetFileNm = "@"+vos[i].getBkgNo() + vos[i].getSrNo()+".tif";
					vos[i].setImgFileNm(targetFileNm);
					vos[i].setFaxLogRefNo(vo.getFaxLogRefNo());
					
					maxSeq = dbDao.searchSrCrntRqstMaxSeq(vos[i]);
					vos[i].setSrAmdSeq(maxSeq);
					dbDao.addQueueBkgNoMaster(vos[i]);
					dbDao.modifyCorrectionSRWorkStatus(vos[i]);
					
					temp1 = null;
					temp2 = null;
					srAmdRsnTpCd = vos[i].getSrAmdRsnTpCd();
					if (srAmdRsnTpCd != null) {
						temp1 = srAmdRsnTpCd.split(":");
						for (int j = 1; j < temp1.length; j++) {
							temp2 = temp1[j].split("_");
							vos[i].setSrAmdRsnTpCd(temp2[0]);
							vos[i].setSrAmdRsnCd(temp2[1]);
							dbDao.addQueueBkgNoAmendReason(vos[i]);
						}
					}
					
					ModifySrTransferVO modifySrTransferVO = new ModifySrTransferVO();
					modifySrTransferVO.setSrNo(vo.getSrNo());
					modifySrTransferVO.setSrKndCd(vo.getSrKndCd());
					modifySrTransferVO.setBkgNo(vos[i].getBkgNo());
					modifySrTransferVO.setUsrId(vos[i].getUpdUsrId());
					modifySrTransferVO.setSrMtchStsCd("");
					modifySrTransferVO.setOfcCd(account.getOfc_cd());
					modifySrTransferVO.setSrStsCd("XX");
					
					//TRANSFER TO DC 버튼에서 처리함.
					//dbDao.modifySrTransfer(modifySrTransferVO );
					
					srHisSeq = "";
					if (vos[i].getSrAmdTpCd().equals("A")){
						maxSrHisSeq = dbDao.searchMaxSrHisSeq(vos[i].getBkgNo());
						srHisSeq = String.valueOf(maxSrHisSeq + 1);
						modifySrTransferVO.setSrHisSeq(srHisSeq);
						dbDao.addSrTransfer(modifySrTransferVO);
						dbDao.modifySrCrntRqstForMaxHisSeq(modifySrTransferVO);
					}
					maxSrHisSeq = dbDao.searchMaxSrHisSeq(vos[i].getBkgNo());
					srHisSeq = String.valueOf(maxSrHisSeq + 1);
					modifySrTransferVO.setSrHisSeq(srHisSeq);
					modifySrTransferVO.setSrStsCd("SR");
					dbDao.addSrTransfer(modifySrTransferVO);
					
					maxSrHisSeq = dbDao.searchMaxSrHisSeq(vos[i].getBkgNo());
					srHisSeq = String.valueOf(maxSrHisSeq + 1);
					modifySrTransferVO.setSrHisSeq(srHisSeq);
					modifySrTransferVO.setSrStsCd("ST");
					dbDao.addSrTransfer(modifySrTransferVO);
					
					dbDao.modifySrCrntRqstForMaxHisSeq(modifySrTransferVO);
					
					if ( FileUtils.fileExists(imgFilePath+orgImgFileNm) == true){ // 2011.07.19 Changed
						//파일 split 처리
						TiffSplitUtil tiffUtil = new TiffSplitUtil();
					 	
						if (start_page == 0)start_page = 1;
						if (end_page == 0)end_page = 1;
						FileUtils.mkdir(targetImgFilePath);
						if (start_page == 1 && vo.getTotPgKnt().equals(String.valueOf(end_page))){
							FileUtils.fileCopy(imgFilePath+orgImgFileNm, targetImgFilePath+targetFileNm);
						}else{
							tiffUtil.splitBetween(imgFilePath+orgImgFileNm, targetImgFilePath+targetFileNm, start_page-1, end_page-1);
						}
						
						//2011.08.23 history 추가 
						String srProcTpCd ="FILSPT"; //File split
						dbDao.addBkgSrProcHisPrc(vos[i].getSrNo(), vos[i].getFaxLogRefNo(), srProcTpCd, vos[i].getUpdUsrId());
					}	
				}	
					
				
				dbDao.modifyBkgNoMatch(vo, "P");
			}
		} catch (EventException ex) {
			throw ex;	
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * 해당 VVD별 Port의 Document마감 시간 조회함. 화면 - ESM_BKG_0417
	 * 
	 * @param PortCLSReportVO vo
	 * @return List<PortCLSReportVO>
	 * @throws EventException
	 */
	public List<PortCLSReportVO> searchPCTCLSReport(PortCLSReportVO vo) throws EventException {
		try {
			return dbDao.searchPCTCLSReport(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Freight & Charge 요약 리포트 조회한다. 화면 - ESM_BKG_0595
	 * 
	 * @param FreightChargeSummaryReportInVO vo
	 * @return List<FreightChargeSummaryReportInVO>
	 * @throws EventException
	 */
	public List<FreightChargeSummaryReportInVO> searchFrtSumList(FreightChargeSummaryReportInVO vo) throws EventException {
		try {
			return dbDao.searchFrtSumList(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * SR Data의 처리 Office 별 B/L Turn Time 집계 현황을 조회한다. (Summary List)
	 * 화면 - ESM_BKG_0067
	 * @param DocPerformanceSummaryVO docPerformanceSummaryVO
	 * @return List<DocPerformanceSummaryVO>
	 * @throws EventException
	 */
	public List<DocPerformanceSummaryVO> searchDPCSTurnTimeSummary(DocPerformanceSummaryVO docPerformanceSummaryVO) throws EventException {
		try {
			return dbDao.searchDPCSTurnTimeSummary(docPerformanceSummaryVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * SR Data의 처리 Office 별 B/L Turn Time 상세실적 현황을 조회한다. (Detail List)
	 * 화면 - ESM_BKG_0067
	 * @param DocPerformanceReportInVO docPerformanceReportInVO
	 * @return List<DocPerformanceReportInVO>
	 * @throws EventException
	 */
	public List<DocPerformanceReportInVO> searchDPCSTurnTimeList(DocPerformanceReportInVO docPerformanceReportInVO) throws EventException {
		try {
			return dbDao.searchDPCSTurnTimeList(docPerformanceReportInVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * SR Data의 처리 부문별 담당자의 처리 Error 실적 현황을 조회(ESM_BKG_0409).
	 * 
	 * @param SearchDPCSPfmcErrorListVO vo
	 * @return List<SearchDPCSPfmcErrorListVO>
	 * @throws EventException
	 */
	public List<SearchDPCSPfmcErrorListVO> searchDPCSPfmcErrorList(SearchDPCSPfmcErrorListVO vo) throws EventException {
		try {
			return dbDao.searchDPCSPfmcErrorList(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * TRO 현황 조회 화면(ESM_BKG_0620).
	 * 
	 * @param TroStatusListInVO vo
	 * @return List<TroStatusListInVO>
	 * @throws EventException
	 */
	public List<TroStatusListInVO> searchTroStatusList(TroStatusListInVO vo) throws EventException {
		try {
			return dbDao.searchTroStatusList(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * e-Booking & S/I 업로드 실적 조회 기능(ESM_BKG_0226)<br>
	 * 1.Report Type이 Pending Report <br>
	 * 
	 * @param EBkgSiUploadStsReportInVO vo
	 * @return List<EBkgSiUploadStsReportInVO>
	 * @throws EventException
	 */
	public List<EBkgSiUploadStsReportInVO> searchEBkgSiUploadStsListByPending(EBkgSiUploadStsReportInVO vo) throws EventException {
		try {
			return dbDao.searchEBkgSiUploadStsListByPending(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * e-Booking & S/I 업로드 실적 조회 기능(ESM_BKG_0226).<br>
	 * 2.Report Type이 Delay Report <br>
	 * 
	 * @param EBkgSiUploadStsReportInVO vo
	 * @return List<EBkgSiUploadStsReportInVO>
	 * @throws EventException
	 */
	public List<EBkgSiUploadStsReportInVO> searchEBkgSiUploadStsListByDealy(EBkgSiUploadStsReportInVO vo) throws EventException {
		try {
			return dbDao.searchEBkgSiUploadStsListByDealy(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * e-Booking & S/I 업로드 실적 조회 기능(ESM_BKG_0226).<br>
	 * 3.Report Type이 Detail Report<br>
	 * 
	 * @param EBkgSiUploadStsReportInVO vo
	 * @return List<EBkgSiUploadStsReportInVO>
	 * @throws EventException
	 */
	public List<EBkgSiUploadStsReportInVO> searchEBkgSiUploadStsListByDetail(EBkgSiUploadStsReportInVO vo) throws EventException {
		try {
			return dbDao.searchEBkgSiUploadStsListByDetail(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * e-Booking & S/I 실적 조회 기능(ESM_BKG_0227)<br>
	 * 1.Report Type이 BookingOffice Report <br>
	 * 
	 * @param EBkgSiPfmcInVO vo
	 * @return List<EBkgSiPfmcInVO>
	 * @throws EventException
	 */
	public List<EBkgSiPfmcInVO> searchEBkgSiPfmcListByBkgOfc(EBkgSiPfmcInVO vo) throws EventException {
		try {
			return dbDao.searchEBkgSiPfmcListByBkgOfc(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * e-Booking & S/I 실적 조회 기능(ESM_BKG_0227)<br>
	 * 2.Report Type이 SalesOffice Report <br>
	 * 
	 * @param EBkgSiPfmcInVO vo
	 * @return List<EBkgSiPfmcInVO>
	 * @throws EventException
	 */
	public List<EBkgSiPfmcInVO> searchEBkgSiPfmcListBySalOfc(EBkgSiPfmcInVO vo) throws EventException {
		try {
			return dbDao.searchEBkgSiPfmcListBySalOfc(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * e-Booking & S/I 실적 조회 기능(ESM_BKG_0227)<br>
	 * 3.Report Type이 Shipper Report<br>
	 * 
	 * @param EBkgSiPfmcInVO vo
	 * @return List<EBkgSiPfmcInVO>
	 * @throws EventException
	 */
	public List<EBkgSiPfmcInVO> searchEBkgSiPfmcListByShipper(EBkgSiPfmcInVO vo) throws EventException {
		try {
			return dbDao.searchEBkgSiPfmcListByShipper(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * e-Booking & S/I 실적 조회 기능(ESM_BKG_0227)<br>
	 * 4.Report Type이 Detail Report<br>
	 * 
	 * @param EBkgSiPfmcInVO vo
	 * @return List<EBkgSiPfmcInVO>
	 * @throws EventException
	 */
	public List<EBkgSiPfmcInVO> searchEBkgSiPfmcListByDetail(EBkgSiPfmcInVO vo) throws EventException {
		try {
			return dbDao.searchEBkgSiPfmcListByDetail(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}

	}

	/**
	 * Port Closing Inquiry(ESM_BKG_0914)<br>
	 * 1.Office List -PCT (Port Closing Time) 현황 조회 화면<br>
	 * 
	 * @param PortCloseOfficeListVO vo
	 * @return List<PortCloseOfficeListVO>
	 * @throws EventException
	 */
	public List<PortCloseOfficeListVO> searchPctlOfficeList(PortCloseOfficeListVO vo) throws EventException {
		try {
			return dbDao.searchPctlOfficeList(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}

	}

	/**
	 * Port Closing Inquiry(ESM_BKG_0914)<br>
	 * 2.B/L List -PCT (Port Closing Time) 현황 조회 화면<br>
	 * 
	 * @param PortCloseBLlistVO vo
	 * @return List<PortCloseBLlistVO>
	 * @throws EventException
	 */
	public List<PortCloseBLlistVO> searchPctlBLList(PortCloseBLlistVO vo) throws EventException {
		try {
			return dbDao.searchPctlBLList(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}

	}

	/**
	 * Port Closing Inquiry(ESM_BKG_0914)<br>
	 * 3.Office List Summary -PCT (Port Closing Time) 현황 조회 화면<br>
	 * 
	 * @param PortCloseOfficeListVO vo
	 * @return List<PortCloseOfficeListVO>
	 * @throws EventException
	 */
	public List<PortCloseOfficeListVO> searchPctlOfficeSummary(PortCloseOfficeListVO vo) throws EventException {
		try {
			return dbDao.searchPctlOfficeSummary(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}

	}

	/**
	 * C/A Detail(s)(ESM_BKG_0651) 를 조회합니다<br>
	 * 
	 * @param String blNo
	 * @param String bkgNo
	 * @param String caNo
	 * @return List<BlCaDetailListVO>
	 * @throws EventException
	 */
	public List<BlCaDetailListVO> searchBLCaDetailList(String blNo, String bkgNo, String caNo) throws EventException {

		try {
			return dbDao.searchBLCaDetailList(blNo, bkgNo, caNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * C/A Detail(s)(ESM_BKG_0651)에 History List 를 조회합니다<br>
	 * 
	 * @param String bkgNo
	 * @param String corrNo
	 * @return List<BlCaDetailListVO>
	 * @throws EventException
	 */
	public List<BlCaDetailListVO> searchBLCaDetailHisList(String bkgNo,String corrNo) throws EventException {
		
		try {
			return dbDao.searchBLCaDetailHisList(bkgNo,corrNo);
		} catch (DAOException ex) {
			 log.error("err " + ex.toString(), ex);
			 throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			 log.error("err " + ex.toString(), ex);
			 throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);			
		}
	}
	
	
	/**
	 * Doc Performance Report(ESM_BKG_0214)<br>
	 * 1.Office List -Documentation 실적 산출 기능 조회 화면<br>
	 * 
	 * @param DocPFMCOfcListVO vo
	 * @return List<DocPFMCOfcListVO>
	 * @throws EventException
	 */
	public List<DocPFMCOfcListVO> searchDocPFMCOfcList(DocPFMCOfcListVO vo) throws EventException {
		try {
			return dbDao.searchDocPFMCOfcList(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}

	}

	/**
	 * Doc Performance Report(ESM_BKG_0214)<br>
	 * 2.B/L List -Documentation 실적 산출 기능 조회 화면<br>
	 * 
	 * @param DocPFMCBLListVO vo
	 * @return List<DocPFMCBLListVO>
	 * @throws EventException
	 */
	public List<DocPFMCBLListVO> searchDocPFMCBLList(DocPFMCBLListVO vo) throws EventException {
		try {
			return dbDao.searchDocPFMCBLList(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * User Group Id 조회합니다.<br>
	 * 
	 * @param String usrId
	 * @return List<DocQueueListOutVO>
	 * @throws EventException
	 */
	public List<SearchUserGroupIdVO> searchUserGroupId(String usrId) throws EventException {
		try {
			return dbDao.searchUserGroupId(usrId);

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

    /**
     * Work Group별 PIC 목록조회<br>
     * 
     * @param String wrkGrpCd
     * @return List<BkgComboVO>
     * @exception EventException
     */
    public List<BkgComboVO> searchSZPBBPicCombo(String wrkGrpCd) throws EventException {
        try {
            return dbDao.searchSZPBBPicCombo(wrkGrpCd);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		}
    }

	/**
	 * 0421 Queue List 정보를 조회합니다.<br>
	 * 
	 * @param DocQueueListInVO docQueueListInVO
	 * @return List<DocQueueListOutVO>
	 * @throws EventException
	 */
	public List<DocQueueListOutVO> searchQueueList(DocQueueListInVO docQueueListInVO) throws EventException {
		try {
			return dbDao.searchQueueList(docQueueListInVO);

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * 0437 Queue List 정보를 조회합니다.<br>
	 * 
	 * @param DocQueueListInVO docQueueListInVO
	 * @return List<DocQueueListOutVO>
	 * @throws EventException
	 */
	public List<DocQueueListOutVO> searchSZPBBQueueList(DocQueueListInVO docQueueListInVO) throws EventException {
		try {
			return dbDao.searchSZPBBQueueList(docQueueListInVO);

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * 0422 Queue Detail List 메타 정보를 조회합니다.<br>
	 * 
	 * @param String userPartCd
	 * @param String bkgNo
	 * @param String srNo
	 * @param String userId
	 * @param String srKind
	 * @param String srKndCd
	 * @return List<DocQueueDetailListVO>
	 * @throws EventException
	 */
	public List<DocQueueDetailListVO> searchQueueDetailList(String userPartCd, String bkgNo, String srNo, String userId, String srKind, String srKndCd) throws EventException {
		try {
			return dbDao.searchQueueDetailList(userPartCd, bkgNo, srNo, userId, srKind, srKndCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * 0422 Queue Detail List 메타 정보를 조회합니다.<br>
     * @param String bkgNo
	 * @return String
	 * @throws EventException
	 */
	public  String searchQueueDetailList4(String bkgNo) throws EventException{
		
		try {
			return dbDao.searchQueueDetailList4(bkgNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * 0437 Queue Detail List Complete Flag를 조회합니다.<br>
     * @param String bkgNo
	 * @return String
	 * @throws EventException
	 */
	public  String searchSZPBBQueueDetailList4(String bkgNo) throws EventException{
		
		try {
			return dbDao.searchSZPBBQueueDetailList4(bkgNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	
	/**
	 * 0422 Queue Detail List 정보를 조회합니다.<br>
	 * 
	 * @param DocQueueDetailListVO docQueueDetailListVO
	 * @return List<DocQueueDetailListVO>
	 * @throws EventException
	 */
	public List<DocQueueDetailListVO> searchQueueDetailList(DocQueueDetailListVO docQueueDetailListVO) throws EventException {
		try {
			return dbDao.searchQueueDetailList(docQueueDetailListVO);

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * 0422 Queue Detail List 에 Go To BKG(e-booking:ESM_BKG_0229) 에 필요한 정보를 조회합니다.<br>
	 * @param String bkgNo
	 * @return String
	 * @throws EventException
	 */
	public  String searchRqstInfo(String bkgNo)throws EventException{
		
		try {
			return dbDao.searchRqstInfo(bkgNo);

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * C/A Performance Report (ESM_BKG_0110)를 조회합니다.<br>
	 * 
	 * @param CaPerformanceReportInVO vo
	 * @return List<CaPerformanceReportOutVO>
	 * @throws EventException
	 */
	public List<CaPerformanceReportOutVO> searchCAPerformanceReport(CaPerformanceReportInVO vo) throws EventException {

		try {
			return dbDao.searchCAPerformanceReport(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * 조회이벤트 처리<br>
	 * Performancereport화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String fromDt
	 * @param String toDt
	 * @return List<RbcvesselVO>
	 * @exception EventException
	 */
	public List<RbcvesselVO> searchRBCVesselList(String fromDt, String toDt) throws EventException {
		try {
			return dbDao.searchRBCVesselList(fromDt, toDt);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}

	}

	/**
	 * Sales Performance Report (ESM_BKG_0632)를 조회합니다.<br>
	 * 
	 * @param SaelsPerformanceReportInVO vo
	 * @return List<SaelsPerformanceReportOutVO>
	 * @throws EventException
	 */
	public List<SaelsPerformanceReportOutVO> searchSalesPerformanceReport(SaelsPerformanceReportInVO vo) throws EventException {

		try {
			return dbDao.searchSalesPerformanceReport(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * 0422 Completed 버튼 클릭시 Queue Detail 관련 테이블을 트랜잭션 처리합니다.<br>
	 * 
	 * @param DocQueueDetailListVO docQueueDetailListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageQueueDetailList(DocQueueDetailListVO docQueueDetailListVO, SignOnUserAccount account) throws EventException {

		if (docQueueDetailListVO == null) return;
		try {
			//dbDao.addQueueDetailList(docQueueDetailListVO);
			dbDao.modifyQueueDetailList(docQueueDetailListVO);

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * ESM_BKG_0437 : Queue List 에 Input/Rate PIC 정보를 수정한다<br>
	 * 
	 * @param DocQueueListOutVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifySZPBBPicUserId(DocQueueListOutVO vo, SignOnUserAccount account) throws EventException {

		if (vo == null) return;
		try {
			//dbDao.addQueueDetailList(docQueueDetailListVO);
			dbDao.modifySZPBBPicUserId(vo, account);

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * 0421 Delete 버튼 클릭시 Queue 관련 테이블을 트랜잭션 처리합니다.<br>
	 * 
	 * @param DocQueueDetailListVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeDpcsQueList(DocQueueDetailListVO[] vos, SignOnUserAccount account) throws EventException {

		try { 
			if (vos != null && vos.length > 0){
				for (int i = 0; i < vos.length; i++) {
					if (vos[i].getSel().equals("1") ) {
						vos[i].setSrStsCd("DL");
						vos[i].setSrWrkStsCd("D");
						vos[i].setUsrId(account.getUsr_id());
						dbDao.removeDpcsQueueCrnt(vos[i]);
						dbDao.addDpcsQueueHistory(vos[i]);
					}
				}
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * 0422 Pending 버튼 클릭시 BKG_SR_CRNT_RQST 관련 테이블을 트랜잭션 처리합니다.<br>
	 * 
	 * @param DocQueueDetailListVO docQueueDetailListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageQueueDetailList2(DocQueueDetailListVO docQueueDetailListVO, SignOnUserAccount account) throws EventException {

		if (docQueueDetailListVO == null) return;
		try {
			dbDao.modifyQueueDetailList2(docQueueDetailListVO);

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
     * 0985 Return  버튼 클릭시 Return 관련 데이블 데이타을 수정/생성 합니다.<br>	
     * 
     * @param docQueueDetailReturnInVO DocQueueDetailReturnInVO
     * @param SearchQueueDetailReturnReasonCdListVO[] searchQueueDetailReturnReasonCdListVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageQueueDetailReturn(DocQueueDetailReturnInVO docQueueDetailReturnInVO,SearchQueueDetailReturnReasonCdListVO[] searchQueueDetailReturnReasonCdListVOs,SignOnUserAccount account) throws EventException {
    
		if (docQueueDetailReturnInVO == null) return;
		try {
			dbDao.addQueueDetailReturn(docQueueDetailReturnInVO);
			for (int i = 0; i < searchQueueDetailReturnReasonCdListVOs.length; i++) {
				searchQueueDetailReturnReasonCdListVOs[i].setSrKndCd(docQueueDetailReturnInVO.getSrcCd());
				searchQueueDetailReturnReasonCdListVOs[i].setSrNo(docQueueDetailReturnInVO.getSrNo());
				searchQueueDetailReturnReasonCdListVOs[i].setBkgNo(docQueueDetailReturnInVO.getBkgNo());
				searchQueueDetailReturnReasonCdListVOs[i].setUpdUsrId(account.getUsr_id());
				dbDao.addQueueDetailReturnReason(searchQueueDetailReturnReasonCdListVOs[i]);
			}	
			dbDao.modifyQueueDetailReturn(docQueueDetailReturnInVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
    /**
	 * 0985 DPCS reject 내역을 email로 전송한다.<br>
	 * @param 	DocQueueDetailReturnInVO vo
	 * @param 	SignOnUserAccount account
	 * @throws 	EventException
	 */
	public void sendDpcsRejectEmail(DocQueueDetailReturnInVO vo, SignOnUserAccount account) throws EventException{
		try {
			PerformanceReportEAIDAO eaiDao = new PerformanceReportEAIDAO();
			eaiDao.sendDpcsRejectEmail(vo,account);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	/**
	 * 0984 Return to Return 버튼 클릭시 관련 데이블 데이타를 생성/수정합니다.<br>
	 * 
	 * @param DocQueueDetailReturnInVO docQueueDetailReturnInVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageQueueRtnToRtn(DocQueueDetailReturnInVO docQueueDetailReturnInVO, SignOnUserAccount account) throws EventException {

		if (docQueueDetailReturnInVO == null) return;
		try {
			dbDao.addQueueRtnToRtn(docQueueDetailReturnInVO);
			dbDao.modifyQueueRtnToRtn(docQueueDetailReturnInVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * 0424 Open 시 Queue VVD List 정보를 조회합니다.<br>
	 * 
	 * @param DocQueueVvdListVO docQueueVvdListVO
	 * @return List<DocQueueVvdListVO>
	 * @throws EventException
	 */
	public List<DocQueueVvdListVO> searchQueueVvdList(DocQueueVvdListVO docQueueVvdListVO) throws EventException {
		try {
			return dbDao.searchQueueVvdList(docQueueVvdListVO);

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * 0424 Queue Report By Pol 정보를 조회합니다.<br>
	 * 
	 * @param DocQueueReportByPolListInVO docQueueReportByPolListInVO
	 * @return List<DocQueueReportByPolListOutVO>
	 * @throws EventException
	 */
	public List<DocQueueReportByPolListOutVO> searchQueueReportByPol(DocQueueReportByPolListInVO docQueueReportByPolListInVO) throws EventException {
		try {
			return dbDao.searchQueueReportByPol(docQueueReportByPolListInVO);

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * C/A Report (ESM_BKG_0568)를 조회합니다.<br>
	 * 
	 * @param CaIssueDateInVO vo
	 * @return List<CaIssueDateOutVO>
	 * @throws EventException
	 */
	public List<CaIssueDateOutVO> searchCaIssueDateList(CaIssueDateInVO vo) throws EventException {

		try {
			return dbDao.searchCaIssueDateList(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/*
	 * C/A Report (ESM_BKG_0568) Remark를 수정합니다.<br>
	 * 
	 * @param CaIssueDateInVO[] vos
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	/*
	public void modifyCaIssueRemark(CaIssueDateInVO[] vos, SignOnUserAccount account) throws EventException {

		try {
			for (int i = 0; i < vos.length; i++) {
				if (vos[i].getIbflag().equals("U")) {

					vos[i].setUsrId(account.getUsr_id());
					dbDao.modifyCaIssueRemark(vos[i]);
				}
			}

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	*/
	/**
	 * 조회이벤트 처리<br>
	 * Freight & Charge List by VVD 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchFCLListVO searchFCLListVO
	 * @return List<SearchFCLListVO>
	 * @exception EventException
	 */
	public List<SearchFCLListVO> searchFCLList(SearchFCLListVO searchFCLListVO) throws EventException {
		try {
			return dbDao.searchFCLList(searchFCLListVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * 0066 B/L Processing Report 정보를 조회합니다.<br>
	 * 
	 * @param DocTurnTimeInVO docTurnTimeInVO
	 * @return List<DocTurnTimeOutVO>
	 * @throws EventException
	 */
	public List<DocTurnTimeOutVO> searchBlTurnTimeReport(DocTurnTimeInVO docTurnTimeInVO) throws EventException {
		try {
			return dbDao.searchBlTurnTimeReport(docTurnTimeInVO);

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * 0940 I/B DOC Performance Report 정보를 조회합니다.<br>
	 * 
	 * @param InBoundReportInVO inBoundReportInVO
	 * @return List<InBoundReportOutVO>
	 * @throws EventException
	 */
	public List<InBoundReportOutVO> searchInBoundPfmcReport(InBoundReportInVO inBoundReportInVO) throws EventException {
		try {
			return dbDao.searchInBoundPfmcReport(inBoundReportInVO);

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * 0274 General Cargo Manifest by VVD/PORT 정보를 조회합니다.<br>
	 * 
	 * @param BlCargoManifestInVO blCargoManifestInVO
	 * @return List<BlCargoManifestOutVO>
	 * @throws EventException
	 */
	public List<BlCargoManifestOutVO> searchBLCargoManifestList(BlCargoManifestInVO blCargoManifestInVO) throws EventException {
		try {
			return dbDao.searchBLCargoManifestList(blCargoManifestInVO);

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	/**
	 * 0274 General Cargo Manifest by VVD/PORT 정보를 Container 단위로 조회합니다.<br>
	 * 
	 * @param BlCargoManifestInVO blCargoManifestInVO
	 * @return List<BlCntrCargoManifestOutVO>
	 * @throws EventException
	 */
	public List<BlCntrCargoManifestOutVO> searchBLCntrCargoManifestList(BlCargoManifestInVO blCargoManifestInVO) throws EventException {
		try {
			return dbDao.searchBLCntrCargoManifestList(blCargoManifestInVO);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * 0410 Performance Report by Volume 정보를 조회합니다.<br>
	 * 
	 * @param SearchDPCSVolListInVO searchDPCSVolListInVO
	 * @return List<SearchDPCSVolListOutVO>
	 * @throws EventException
	 */
	public List<SearchDpcsPerfByVolListVO> searchDPCSVolList(SearchDPCSVolListInVO searchDPCSVolListInVO) throws EventException {
		
		try {
			return dbDao.searchDPCSVolList(searchDPCSVolListInVO);

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * C/A Report_B/L Inquiry >>> Main (ESM_BKG_0570)를 조회합니다.<br>
	 * 
	 * @param String blNo
	 * @return List<CaInquiryReportVO>
	 * @throws EventException
	 */
	public List<CaInquiryReportVO> searchCaByBLno(String blNo) throws EventException {

		try {
			return dbDao.searchCaByBLno(blNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * C/A Report_B/L Inquiry >>> Customer Info. (ESM_BKG_0570)를 조회합니다.<br>
	 * 
	 * @param String blNo
	 * @param String corrNo
	 * @return List<CaInquiryReportVO>
	 * @throws EventException
	 */
	public List<CaInquiryReportVO> searchCaByCustomerInfo(String blNo, String corrNo) throws EventException {

		try {
			return dbDao.searchCaByCustomerInfo(blNo, corrNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * C/A Report_B/L Inquiry >>> Marks&Desc Info. (ESM_BKG_0570)를 조회합니다.<br>
	 * 
	 * @param String blNo
	 * @param String corrNo
	 * @return List<CaInquiryReportVO>
	 * @throws EventException
	 */
	public List<CaInquiryReportVO> searchCaByMarkDescInfo(String blNo, String corrNo) throws EventException {

		try {
			return dbDao.searchCaByMarkDescInfo(blNo, corrNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * C/A Report_B/L Inquiry >>> Container Info. (ESM_BKG_0570)를 조회합니다.<br>
	 * 
	 * @param String blNo
	 * @param String corrNo
	 * @return List<CaInquiryReportVO>
	 * @throws EventException
	 */
	public List<CaInquiryReportVO> searchCaByContainerInfo(String blNo, String corrNo) throws EventException {

		try {
			return dbDao.searchCaByContainerInfo(blNo, corrNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * C/A Summary Report 결과를 조회한다. (ESM_BKG_0174)<br>
	 * 
	 * @param CaSummaryReportInVO vo
	 * @return List<CaSummaryReportOutVO>
	 * @throws EventException
	 */
	public List<CaSummaryReportOutVO> searchCaSummaryReport(CaSummaryReportInVO vo) throws EventException {

		try {
			/*
			 * //CA REASON SETTING >>>>> START String tempStr = vo.getCaReasonM();
			 * 
			 * if (tempStr == null || tempStr.equals("")){
			 * 
			 * tempStr = vo.getCaReasonC(); }else{
			 * 
			 * if (vo.getCaReasonC() != null && !vo.getCaReasonC().equals("")){ tempStr += "," + vo.getCaReasonC(); } }
			 * 
			 * if (tempStr == null || tempStr.equals("")){
			 * 
			 * tempStr = vo.getCaReasonG(); }else{
			 * 
			 * if (vo.getCaReasonG() != null && !vo.getCaReasonG().equals("")){ tempStr += "," + vo.getCaReasonG(); } }
			 * 
			 * if (tempStr == null || tempStr.equals("")){
			 * 
			 * tempStr = vo.getCaReasonA(); }else{
			 * 
			 * if (vo.getCaReasonA() != null && !vo.getCaReasonA().equals("")){ tempStr += "," + vo.getCaReasonA(); } }
			 * 
			 * if (tempStr == null || tempStr.equals("")){
			 * 
			 * tempStr = vo.getCaReasonO(); }else{
			 * 
			 * if (vo.getCaReasonO() != null && !vo.getCaReasonO().equals("")){ tempStr += "," + vo.getCaReasonO(); } }
			 * 
			 * if (tempStr.indexOf(",") > -1){
			 * 
			 * String[] tempArr = tempStr.split(",");
			 * 
			 * for (int i = 0 ; i < tempArr.length ; i++){
			 * 
			 * if (i == 0){
			 * 
			 * tempStr = " COR.CA_RSN_CD = '" + tempArr[i] + "'"; }else{
			 * 
			 * tempStr += " OR COR.CA_RSN_CD = '" + tempArr[i] + "'"; } }
			 * 
			 * vo.setCaReason(tempStr); } //CA REASON SETTING >>>>> END
			 * 
			 * //CA CLASS SETTING >>>>> START tempStr = "";
			 * 
			 * if (vo.getCaClass1() != null && !vo.getCaClass1().equals("")){
			 * 
			 * tempStr = " COR.RAT_FLG = '" + vo.getCaClass1() + "'"; }
			 * 
			 * if (tempStr != null && !tempStr.equals("")){
			 * 
			 * if (vo.getCaClass2() != null && !vo.getCaClass2().equals("")){ tempStr += " OR COR.RAT_FLG = '" + vo.getCaClass2() + "'"; } }else{
			 * 
			 * if (vo.getCaClass2() != null && !vo.getCaClass2().equals("")){ tempStr = " COR.RAT_FLG = '" + vo.getCaClass2() + "'"; } }
			 * 
			 * if (tempStr != null && !tempStr.equals("")){
			 * 
			 * if (vo.getCaClass3() != null && !vo.getCaClass3().equals("")){ tempStr += " OR COR.EXPN_FLG = '" + vo.getCaClass3() + "'"; } }else{
			 * 
			 * if (vo.getCaClass3() != null && !vo.getCaClass3().equals("")){ tempStr = " COR.EXPN_FLG = '" + vo.getCaClass3() + "'"; } }
			 * 
			 * if (tempStr != null && !tempStr.equals("")){
			 * 
			 * vo.setCaClass(tempStr); } //CA CLASS SETTING >>>>> END
			 * 
			 * //CA KIND SETTING >>>>> START tempStr = "";
			 * 
			 * if (vo.getCaKindA() != null && !vo.getCaKindA().equals("")){
			 * 
			 * tempStr = " COR.RT_CORR_FLG = 'Y' "; }
			 * 
			 * if (tempStr != null && !tempStr.equals("")){
			 * 
			 * if (vo.getCaKindB() != null && !vo.getCaKindB().equals("")){ tempStr += " OR COR.CHG_TERM_CORR_FLG = 'Y' "; } }else{
			 * 
			 * if (vo.getCaKindB() != null && !vo.getCaKindB().equals("")){ tempStr = " COR.CHG_TERM_CORR_FLG = 'Y' "; } }
			 * 
			 * if (tempStr != null && !tempStr.equals("")){
			 * 
			 * if (vo.getCaKindC() != null && !vo.getCaKindC().equals("")){ tempStr += " OR COR.RCVDE_TERM_CORR_FLG = 'Y' "; } }else{
			 * 
			 * if (vo.getCaKindC() != null && !vo.getCaKindC().equals("")){ tempStr = " COR.RCVDE_TERM_CORR_FLG = 'Y' "; } }
			 * 
			 * if (tempStr != null && !tempStr.equals("")){
			 * 
			 * if (vo.getCaKindD() != null && !vo.getCaKindD().equals("")){ tempStr += " OR COR.ROUT_CORR_FLG = 'Y' "; } }else{
			 * 
			 * if (vo.getCaKindD() != null && !vo.getCaKindD().equals("")){ tempStr = " COR.ROUT_CORR_FLG = 'Y' "; } }
			 * 
			 * if (tempStr != null && !tempStr.equals("")){
			 * 
			 * if (vo.getCaKindE() != null && !vo.getCaKindE().equals("")){ tempStr += " OR COR.CUST_CORR_FLG = 'Y' "; } }else{
			 * 
			 * if (vo.getCaKindE() != null && !vo.getCaKindE().equals("")){ tempStr = " COR.COR.CUST_CORR_FLG = 'Y' "; } }
			 * 
			 * if (tempStr != null && !tempStr.equals("")){
			 * 
			 * if (vo.getCaKindF() != null && !vo.getCaKindF().equals("")){ tempStr += " OR COR.QTY_CORR_FLG = 'Y' "; } }else{
			 * 
			 * if (vo.getCaKindF() != null && !vo.getCaKindF().equals("")){ tempStr = " COR.QTY_CORR_FLG = 'Y' "; } }
			 * 
			 * if (tempStr != null && !tempStr.equals("")){
			 * 
			 * if (vo.getCaKindG() != null && !vo.getCaKindG().equals("")){ tempStr += " OR COR.MEAS_QTY_CORR_FLG = 'Y' "; } }else{
			 * 
			 * if (vo.getCaKindG() != null && !vo.getCaKindG().equals("")){ tempStr = " COR.COR.MEAS_QTY_CORR_FLG = 'Y' "; } }
			 * 
			 * if (tempStr != null && !tempStr.equals("")){
			 * 
			 * if (vo.getCaKindH() != null && !vo.getCaKindH().equals("")){ tempStr += " OR COR.CMDT_CORR_FLG = 'Y' "; } }else{
			 * 
			 * if (vo.getCaKindH() != null && !vo.getCaKindH().equals("")){ tempStr = " COR.CMDT_CORR_FLG = 'Y' "; } }
			 * 
			 * if (tempStr != null && !tempStr.equals("")){
			 * 
			 * if (vo.getCaKindI() != null && !vo.getCaKindI().equals("")){ tempStr += " OR COR.TRNK_VSL_CORR_FLG = 'Y' "; } }else{
			 * 
			 * if (vo.getCaKindI() != null && !vo.getCaKindI().equals("")){ tempStr = " COR.TRNK_VSL_CORR_FLG = 'Y' "; } }
			 * 
			 * if (tempStr != null && !tempStr.equals("")){
			 * 
			 * if (vo.getCaKindJ() != null && !vo.getCaKindJ().equals("")){ tempStr += " OR COR.PRPST_VSL_CORR_FLG = 'Y' "; } }else{
			 * 
			 * if (vo.getCaKindJ() != null && !vo.getCaKindJ().equals("")){ tempStr = " COR.PRPST_VSL_CORR_FLG = 'Y' "; } }
			 * 
			 * if (tempStr != null && !tempStr.equals("")){
			 * 
			 * if (vo.getCaKindK() != null && !vo.getCaKindK().equals("")){ tempStr += " OR COR.CA_OTR_RSN_CORR_FLG = 'Y' "; } }else{
			 * 
			 * if (vo.getCaKindK() != null && !vo.getCaKindK().equals("")){ tempStr = " COR.CA_OTR_RSN_CORR_FLG = 'Y' "; } }
			 * 
			 * if (tempStr != null && !tempStr.equals("")){
			 * 
			 * vo.setCaKind(tempStr); } //CA KIND SETTING >>>>> END
			 */
			return dbDao.searchCaSummaryReport(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * C/A Summary Report BL List 결과를 조회한다. (ESM_BKG_0174)<br>
	 * 
	 * @param CaSummaryReportInVO vo
	 * @return List<CaSummaryReportOutVO>
	 * @throws EventException
	 */
	public List<CaSummaryReportOutVO> searchCaSummaryReportBLList(CaSummaryReportInVO vo) throws EventException {

		try {			
			return dbDao.searchCaSummaryReportBLList(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Vessel Utilization Status vs. Bsa by Lane 에 Trade Code 를 조회합니다. (ESM_BKG_0746)<br>
	 * 
	 * @param  VesselUtilizationStatusReportInVO vo
	 * @return List<VesselUtilizationStatusReportInVO>
	 * @throws EventException
	 */	
    public List<VesselUtilizationStatusReportInVO> searchVesselUtilizationTrade(VesselUtilizationStatusReportInVO vo) throws EventException{
    	try{
    		return dbDao.searchVesselUtilizationTrade(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    /**
	 * Vessel Utilization Status vs. Bsa by Lane 에 Sub Trade Code 를 조회합니다. (ESM_BKG_0746)<br>
	 * 
	 * @param  VesselUtilizationStatusReportInVO vo
	 * @return List<VesselUtilizationStatusReportInVO>
	 * @throws EventException
	 */	
    public List<VesselUtilizationStatusReportInVO> searchVesselUtilizationSubTrade(VesselUtilizationStatusReportInVO vo) throws EventException{
    	
    	try{
    		return dbDao.searchVesselUtilizationSubTrade(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    /**
	 * Vessel Utilization Status vs. Bsa by Lane 에 Bound Code 를 조회합니다. (ESM_BKG_0746)<br>
	 * 
	 * @param  VesselUtilizationStatusReportInVO vo
	 * @return List<VesselUtilizationStatusReportInVO>
	 * @throws EventException
	 */	
    public List<VesselUtilizationStatusReportInVO> searchVesselUtilizationBound(VesselUtilizationStatusReportInVO vo) throws EventException{
    	
    	try{
    		return dbDao.searchVesselUtilizationBound(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    /**
	 * Vessel Utilization Status vs. Bsa by Lane 에 BSA by Lane 리스트를 조회합니다. (ESM_BKG_0746)<br>
	 * 
	 * @param  VesselUtilizationStatusReportInVO vo
	 * @return List<VesselUtilizationStatusReportOutVO>
	 * @throws EventException
	 */	
    public List<VesselUtilizationStatusReportOutVO> searchVesselUtilizationStatusReport(VesselUtilizationStatusReportInVO vo) throws EventException{
    	
    	List<VesselUtilizationStatusReportOutVO> list  = null;    	
    	
    	try{
    		    		
    		list = dbDao.searchVesselUtilizationStatusReport(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		
		return list;
    }       

	
	/**
	  * 0985 Queue Detail Return 정보를 조회합니다.<br>
	  * @param  DocQueueDetailReturnInVO docQueueDetailReturnInVO 
	  * @return List<DocQueueDetailReturnInVO>
	  * @throws EventException
	  */
	 public List<DocQueueDetailReturnInVO> searchQueueDetailReturn(DocQueueDetailReturnInVO docQueueDetailReturnInVO) throws EventException {
		try {
			return dbDao.searchQueueDetailReturn(docQueueDetailReturnInVO);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}	
	 /**
	  * 0985 Queue Detail Return 정보를 조회합니다.<br>
	  * @param  SearchQueueDetailReturnReasonCdListVO vo
	  * @return List<DocQueueDetailReturnInVO>
	  * @throws EventException
	  */
	 public List<SearchQueueDetailReturnReasonCdListVO> searchQueueDetailReturnReasonCdList(SearchQueueDetailReturnReasonCdListVO vo) throws EventException {
		try {
			return dbDao.searchQueueDetailReturnReasonCdList(vo);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}
	 
	 /**
	 * Correction(C/A) 월별 Summary Batch. (BAT_BKG_004)<br>
	 * 
	 * @param String fromDt
	 * @param String toDt
	 * @exception EventException
	 */	
    public void manageCASummary(String fromDt, String toDt) throws EventException{
    	
    	try {
    		dbDao.manageCASummary(fromDt, toDt);

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
	/**
	  * 1073 Customer EDI ID Inquiry 정보를 조회합니다.<br>
	  * @param  SearchEDIGrpIDVO searchEDIGrpIDVO
	  * @return List<SearchEDIGrpIDVO>
	  * @throws EventException
	  */
    public List<SearchEDIGrpIDVO> searchEDIGrpId(SearchEDIGrpIDVO searchEDIGrpIDVO) throws EventException {
		try {
			return dbDao.searchEDIGrpId(searchEDIGrpIDVO);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}	

	/**
	 * addBkgSrRequest
	 * @param  DpcsWebBookingVO dpcsWebBookingVO
	 * @throws EventException
	 */
    public void addBkgSrRequest(DpcsWebBookingVO dpcsWebBookingVO) throws EventException {
		try {
			dbDao.addBkgSrRequest(dpcsWebBookingVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }
    
    /**
	 * 0104 Report template(Default, Detail, User Set) 을 트랜잭션 처리합니다.<br>
	 * 
	 * @param ReportTemplateListVO[] reportTemplateListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageReportTemplateBstVipList(ReportTemplateListVO[] reportTemplateListVO, SignOnUserAccount account) throws EventException {

		if (reportTemplateListVO == null) return;
		try {
			List<ReportTemplateListVO> insertVoList = new ArrayList<ReportTemplateListVO>();
			List<ReportTemplateListVO> updateVoList = new ArrayList<ReportTemplateListVO>();
			List<ReportTemplateListVO> deleteVoList = new ArrayList<ReportTemplateListVO>();
			for (int i = 0; i < reportTemplateListVO.length; i++) {

				reportTemplateListVO[i].setBkgRptKndCd(reportTemplateListVO[0].getPBkgRptKndCd());
				reportTemplateListVO[i].setUpdUsrId(account.getUsr_id());

				if (reportTemplateListVO[i].getIbflag().equals("I")) {
					insertVoList.add(reportTemplateListVO[i]);
				} else if (reportTemplateListVO[i].getIbflag().equals("U")) {
					updateVoList.add(reportTemplateListVO[i]);
				} else if (reportTemplateListVO[i].getIbflag().equals("D")) {
					deleteVoList.add(reportTemplateListVO[i]);
				}
			}

			if (deleteVoList.size() > 0) {
				dbDao.removeReportTemplateBstVipList(deleteVoList);
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyReportTemplateBstVipList(updateVoList);
			}

			if (insertVoList.size() > 0) {
				dbDao.addReportTemplateBstVipList(insertVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}    

	/**
	 * 1004 Super User Authority Change - PIC CHANGE(0421화면) 버튼 클릭시 관련 데이블 데이타를 수정합니다.<br>
	 * 
	 * @param DocsUserGroupCdVO docsUserGroupCdVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyDocsUserGroupCd(DocsUserGroupCdVO docsUserGroupCdVO, SignOnUserAccount account) throws EventException {

		if (docsUserGroupCdVO == null) return;
		try {
			String[] arrSrcCd = JSPUtil.getNull(docsUserGroupCdVO.getSrcCd()).split(",");
			String[] arrSrNo = JSPUtil.getNull(docsUserGroupCdVO.getSrNo()).split(",");
			String[] arrBkgNo = JSPUtil.getNull(docsUserGroupCdVO.getBkgNo()).split(",");
			String[] arrBeforeUsrId = JSPUtil.getNull(docsUserGroupCdVO.getBeforeUsrId()).split(",");
			
			DocsUserGroupCdVO tempObj = null;
			for (int i = 0; i < arrSrcCd.length; i++) {
				if(JSPUtil.getNull(arrSrcCd[i]).equals("") || JSPUtil.getNull(arrSrNo[i]).equals("")
				   || JSPUtil.getNull(arrBkgNo[i]).equals("") || JSPUtil.getNull(arrBeforeUsrId[i]).equals("")){
					continue;
				}
				tempObj = new DocsUserGroupCdVO(); 
				ObjectCloner.build(docsUserGroupCdVO, tempObj);
				
				tempObj.setSrcCd(arrSrcCd[i]);
				tempObj.setSrNo(arrSrNo[i]);
				tempObj.setBkgNo(arrBkgNo[i]);
				tempObj.setBeforeUsrId(arrBeforeUsrId[i]);
				dbDao.modifyDocsUserGroupCd(tempObj);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	/**
	 * Container NO , Type Size - bkg_no 별 머지함 
	 * bkgCzStsCd: Container NO - "CN", Type Size - "CQ" 
	 * @param  String bkgNo 
	 * @param  String bkgCzStsCd  
	 * @throws EventException
	 */
	public void manageQtyCntrCoposite(String bkgNo , String bkgCzStsCd )throws EventException {
		
		try{
			if (!StringUtil.isEmpty(bkgNo)) {
				dbDao.manageQtyCntrCoposite(bkgNo,bkgCzStsCd);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * BKG_AUTO_RT_HIS 생성작업<br>
	 * @param  String bkgNo 
	 * @throws EventException
	 */
	public void addAutoRtHistory(String bkgNo) throws EventException {
		try{
				dbDao.addAutoRtHistory(bkgNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	 /**
	  * Autorating Accuracy monitoring Report 조회(ESM_BKG_1081).<br>
	  * 1.Autorating Accuracy Ration<br>
	  * 
	  * @param  AutoratingReportVO autoratingReportVO
	  * @return List<AutoratingReportVO>
	  * @throws EventException
	  */
	 public List<AutoratingReportVO> searchAutoratingReport(AutoratingReportVO autoratingReportVO) throws EventException {
		 try {
				return dbDao.searchAutoratingReport(autoratingReportVO);
				
			} catch(DAOException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
			}
	 }	
	 

	 /**
	  * Autorating Accuracy monitoring Report 조회(ESM_BKG_1081).<br>
	  * 2.Autorating B/L List<br>
	  * 
	  * @param  AutoratingReportVO autoratingReportVO
	  * @return List<AutoratingReportVO>
	  * @throws EventException
	  */
	 public List<AutoratingReportVO> searchAutoBLListReport(AutoratingReportVO autoratingReportVO) throws EventException {
		 try {
				return dbDao.searchAutoBLListReport(autoratingReportVO);
				
			} catch(DAOException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
			}
	 }	
	 
	 /**
	  * Autorating Accuracy monitoring Report 조회(ESM_BKG_1081).<br>
	  * 3.Non Autorating B/L List<br>
	  * 
	  * @param  AutoratingReportVO autoratingReportVO
	  * @return List<AutoratingReportVO>
	  * @throws EventException
	  */
	 public List<AutoratingReportVO> searchNonAutoratingReport(AutoratingReportVO autoratingReportVO) throws EventException {
		 try {
				return dbDao.searchNonAutoratingReport(autoratingReportVO);
				
			} catch(DAOException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
			}
	 }	
	 
	 /**
	  * 1 weeks Daily Booking Trend by Customer 조회(ESM_BKG_1082).<br>
	  * 
	  * @param  SearchBookingTrendReportVO vo
	  * @return List<SearchBookingTrendReportVO>
	  * @throws EventException
	  */
	 public List<SearchBookingTrendReportVO> searchBookingTrendReport(SearchBookingTrendReportVO vo) throws EventException{
		 
		try {
			return dbDao.searchBookingTrendReport(vo);
				
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	 }
	 
	 
	 /**
	  * 2 weeks Daily Booking Trend by Customer >>> B/L Detail 조회(ESM_BKG_1083).<br>
	  * 
	  * @param  SearchBookingTrendReportVO vo
	  * @return List<SearchBookingTrendReportVO>
	  * @throws EventException
	  */
	 public List<SearchBookingTrendReportVO> searchBookingTrendReportBLDetail(SearchBookingTrendReportVO vo) throws EventException{
		 
		try {
			return dbDao.searchBookingTrendReportBLDetail(vo);
				
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	 }
	 
	 /**
	  * 3 weeks Daily Booking Trend by Customer Detail 엑셀 조회(ESM_BKG_1082).<br>
	  * 
	  * @param  SearchBookingTrendReportVO vo
	  * @return List<SearchBookingTrendReportVO>
	  * @throws EventException
	  */
	 public List<SearchBookingTrendReportVO> searchBookingTrendReportDeail(SearchBookingTrendReportVO vo) throws EventException{
		 
		try {
			return dbDao.searchBookingTrendReportDetail(vo);
				
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	 }
		/**
		 * Booking 에서 Cancel 처리 할 경우  Status 업데이트 처리한다<br>
		 * 
		 * @author Kim tae kyoung
		 * @param String bkgNo
		 * @param String bkgSrCrntRqst
		 * @param String srWrkStsCd
		 * @throws EventException
		 */
	 
	 public void modifyQueueByBkg(String bkgNo, String bkgSrCrntRqst, String srWrkStsCd) throws EventException{
		 try{
			 	dbDao.modifyQueueByBkg(bkgNo, bkgSrCrntRqst, srWrkStsCd);
			} catch(DAOException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
			}
		 }
	 
	/**
	 * 중국 EDI 수신
	 * 
	 * @param rcvMsg String
	 * @throws EventException
	 */
	public void loadRcvMsg(String rcvMsg) throws EventException {
	
		log.info("<<<< PerformanceReportBCImpl.loadRcvMsg Start >>>>");

		// 수신 메시지
		String sUsrId = "CHN_RCV";
		String sDiv = "";
		if (rcvMsg.indexOf("\r\n") != -1)
		{
			sDiv = "\r\n";
		}
		else
		{
			sDiv = "\n";
		}
		String[] arrRcvMsg = rcvMsg.split(sDiv);
			
		try
		{	
			// 헤더만 DB 등록함
			BkgObChnRcvHisVO hisVO = new BkgObChnRcvHisVO();
			hisVO.setChnEdiMsgTpId(arrRcvMsg[0].substring(12, 15));
			hisVO.setMsgRcvNo(arrRcvMsg[0].substring(68, 77));
			hisVO.setEdiRcvMsg(arrRcvMsg[0]);
			hisVO.setCreUsrId(sUsrId);
			dbDao.addBkgObChnRcvHis(hisVO);
		}
		catch (DAOException ex) 
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		catch (Exception ex) 
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		
		try
		{
			BkgObChnRcvVO bkgObChnRcvVO = new BkgObChnRcvVO();
			List<BkgObChnRcvVO> bkgObChnRcvVOs = new ArrayList<BkgObChnRcvVO>();
			int iCnt = 1;
			StringTokenizer st = null;
			String key = null;
			String value = "";
			for (int i = 1; i < arrRcvMsg.length; i++)
			{
				if ("{MAIN".equals(arrRcvMsg[i])) {
					bkgObChnRcvVO = new BkgObChnRcvVO();
					// 헤더
					bkgObChnRcvVO.setChnEdiMsgTpId(arrRcvMsg[0].substring(12, 15));
					bkgObChnRcvVO.setMsgRcvNo(arrRcvMsg[0].substring(68, 77));
					bkgObChnRcvVO.setCreUsrId(sUsrId);
					bkgObChnRcvVO.setRcvLogSeq(String.valueOf(iCnt++));
					continue;
				}
				if ("}MAIN".equals(arrRcvMsg[i])) {
					bkgObChnRcvVOs.add(bkgObChnRcvVO);
					continue;
				}
				// 구분자 ":"이후에 값이 없는 경우가 있으므로 count 에 따라 key, value를 다르게 함.
				st = new StringTokenizer(arrRcvMsg[i], ":");
				if (st.countTokens() == 2) {
					key = st.nextToken();
					value = st.nextToken().trim();
				}
				else if (st.countTokens() == 1) {
					key = st.nextToken();
					value = "";
				}
				else
				{
					break;
				}
				// Key, Value로 데이타 세팅
				if ("BKG_NO".equals(key)) {
					bkgObChnRcvVO.setBkgNo(value);
					continue;
				}
				if ("EIR_DATE".equals(key)) {
					bkgObChnRcvVO.setEirXchDt(value);
					continue;
				}
				if ("POL_NAME".equals(key)) {
					bkgObChnRcvVO.setPolNm(value);
					continue;
				}
				if ("POD_NAME".equals(key)) {
					bkgObChnRcvVO.setPodNm(value);
					continue;
				}
				if ("VVD".equals(key)) {
					bkgObChnRcvVO.setVvdCd(value);
					continue;
				}
				if ("VSL_NAME".equals(key)) {
					bkgObChnRcvVO.setVvdNm(value);
					continue;
				}
				if ("CT_LOC_CD".equals(key)) {
					bkgObChnRcvVO.setCstmsLocCd(value);
					continue;
				}
				if ("CNTR_NO".equals(key)) {
					bkgObChnRcvVO.setCntrNo(value);
					continue;
				}
				if ("CT_DATE".equals(key)) {
					bkgObChnRcvVO.setCgorDt(value);
					continue;
				}
			}
			dbDao.addBkgObChnRcv(bkgObChnRcvVOs);
		}
		catch (DAOException ex) 
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		catch (Exception ex)
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}
	/**
	 * Email Account Set-up for Front Office 를 추가/수정/삭제 한다. (ESM_BKG_048)
	 * 
	 * @param BkgEmlAcctStupVO[] bkgEmlAcctStups
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBkgEmlAcctStup(BkgEmlAcctStupVO[] bkgEmlAcctStups, SignOnUserAccount account) throws EventException {

		List<BkgEmlAcctStupVO> insertVoList = new ArrayList<BkgEmlAcctStupVO>();
		List<BkgEmlAcctStupVO> updateVoList = new ArrayList<BkgEmlAcctStupVO>();
		List<BkgEmlAcctStupVO> deleteVoList = new ArrayList<BkgEmlAcctStupVO>();
		try {
			for (int i = 0; i < bkgEmlAcctStups.length; i++) {
				bkgEmlAcctStups[i].setUpdUsrId(account.getUsr_id());
				
				if (bkgEmlAcctStups[i].getIbflag().equals("I")) {
					insertVoList.add(bkgEmlAcctStups[i]);
				} else if (bkgEmlAcctStups[i].getIbflag().equals("U")) {
					updateVoList.add(bkgEmlAcctStups[i]);
				} else if (bkgEmlAcctStups[i].getIbflag().equals("D")) {
					deleteVoList.add(bkgEmlAcctStups[i]);
				}
			}
			dbDao.addBkgEmlAcctStup(insertVoList);
			dbDao.modifyBkgEmlAcctStup(updateVoList);
			dbDao.removeBkgEmlAcctStup(deleteVoList);
		} catch (EventException ex) {
			throw ex;	
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	/**
	  * Email Account Set-up for Front Office 조회(ESM_BKG_0425).<br>
	  * 
	  * @param  BkgEmlAcctStupVO bkgEmlAcctStupVO
	  * @return List<BkgEmlAcctStupVO>
	  * @throws EventException
	  */
	 public List<BkgEmlAcctStupVO> searchBkgEmlAcctStupList(BkgEmlAcctStupVO bkgEmlAcctStupVO) throws EventException {
		 try {
				return dbDao.searchBkgEmlAcctStupList(bkgEmlAcctStupVO);
				
			} catch(DAOException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
			}
	 }	
	
	 /**
     * 조회 이벤트 처리<br>
     * Queue List Set Serarch 조회(ESM_BKG_0446).<br>
     * 
     * @param String usrId
     * @return List<BkgXterSrchSetVO>
     * @exception EventException
     */
    public List<BkgXterSrchSetVO> searchQueueListSearchSetList(String usrId) throws EventException {
        try {        	
            return dbDao.searchQueueListSearchSetList(usrId);
        } catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }
    
    /**
     * Queue List Set Serarch Where 조회(ESM_BKG_0446).<br>
     * 
     * @param String usrId
     * @return String
     * @exception EventException
     */
    public String searchQueueListSearchSetWhere(String usrId) throws EventException {
    	try {        	
            return dbDao.searchQueueListSearchSetWhere(usrId);
        } catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }
    
    /**
	 * 0455 DPCS SPLIT List 정보를 조회합니다.<br>
	 * 
	 * @param DpcsSiSplitCandidateVO vo
	 * @return List<DpcsSiSplitCandidateVO>
	 * @throws EventException
	 */
	public List<DpcsSiSplitCandidateVO> searchDpcsSiSplitCandidate(DpcsSiSplitCandidateVO vo) throws EventException {
		try {
			return dbDao.searchDpcsSiSplitCandidate(vo);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),
					ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),
					ex);
		}
	}

	/**
	  * 0455 DPCS SPLIT Cntr Hist 정보를 조회합니다.<br>
	  * @param  DpcsSiSplitBkgCntrHisVO vo
	  * @return List<DpcsSiSplitBkgCntrHisVO>
	  * @throws EventException
	  */
	 public List<DpcsSiSplitBkgCntrHisVO> searchDpcsSiSplitCntrHis(DpcsSiSplitBkgCntrHisVO vo) throws EventException {
		 try {
				return dbDao.searchDpcsSiSplitCntrHis(vo);
			} catch (DAOException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("COM12240").getMessage(),
						ex);
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("COM12240").getMessage(),
						ex);
			}
	 }

	 /**
	  * 0449 DPCS SPLIT Cntr Compare Result List 정보를 조회합니다.<br>
	  * @param  DpcsSiSplitBkgCntrCompareResultVO vo
	  * @return List<DpcsSiSplitBkgCntrCompareResultVO>
	  * @throws EventException
	  */
	 public List<DpcsSiSplitBkgCntrCompareResultVO> searchDpcsSiSplitBkgCntrCompareResult(DpcsSiSplitBkgCntrCompareResultVO vo) throws EventException {
		 try {
				return dbDao.searchDpcsSiSplitBkgCntrCompareResult(vo);
			} catch (DAOException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("COM12240").getMessage(),
						ex);
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("COM12240").getMessage(),
						ex);
			}
		}

	/**
	 * 0423 Queue Summary - Status by S/I Event 정보를 조회합니다.<br>
	 * 
	 * @param  SearchQueueSummaryInVO searchQueueSummaryInVO
	 * @return List<DocQueueSummaryStatusVO>
	 * @throws EventException
	 */
	public List<DocQueueSummaryStatusVO> searchQueueSummaryStatus(SearchQueueSummaryInVO searchQueueSummaryInVO) throws EventException {
		try {
			return dbDao.searchQueueSummaryStatus(searchQueueSummaryInVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * 0423 Queue Summary - By SR Kind 정보를 조회합니다.<br>
	 * 
	 * @param  SearchQueueSummaryInVO searchQueueSummaryInVO
	 * @return List<DocQueueSummarySRKindVO>
	 * @throws EventException
	 */
	public List<DocQueueSummarySRKindVO> searchQueueSummarySRKind(SearchQueueSummaryInVO searchQueueSummaryInVO) throws EventException {
		try {
			return dbDao.searchQueueSummarySRKind(searchQueueSummaryInVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * 0423 Queue Summary - Just in Time(JIT) Completence 정보를 조회합니다.<br>
	 * 
	 * @param  SearchQueueSummaryInVO searchQueueSummaryInVO
	 * @return List<DocQueueSummaryJITCompletenceVO>
	 * @throws EventException
	 */
	public List<DocQueueSummaryJITCompletenceVO> searchQueueSummaryJITCompletence(SearchQueueSummaryInVO searchQueueSummaryInVO) throws EventException {
		try {
			return dbDao.searchQueueSummaryJITCompletence(searchQueueSummaryInVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * 0423 Queue Summary - By Urgency 정보를 조회합니다.<br>
	 * 
	 * @param  SearchQueueSummaryInVO searchQueueSummaryInVO
	 * @return List<DocQueueSummaryUrgencyVO>
	 * @throws EventException
	 */
	public List<DocQueueSummaryUrgencyVO> searchQueueSummaryUrgency(SearchQueueSummaryInVO searchQueueSummaryInVO) throws EventException {
		try {
			return dbDao.searchQueueSummaryUrgency(searchQueueSummaryInVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * 0423 Queue Summary - By Return Feedback Status 정보를 조회합니다.<br>
	 * 
	 * @param  SearchQueueSummaryInVO searchQueueSummaryInVO
	 * @return List<DocQueueSummaryReturnFeedbackVO>
	 * @throws EventException
	 */
	public List<DocQueueSummaryReturnFeedbackVO> searchQueueSummaryReturnFeedback(SearchQueueSummaryInVO searchQueueSummaryInVO) throws EventException {
		try {
			return dbDao.searchQueueSummaryReturnFeedback(searchQueueSummaryInVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * 0423 Queue Summary - Aging Status(P.F) 정보를 조회합니다.<br>
	 * 
	 * @param  SearchQueueSummaryInVO searchQueueSummaryInVO
	 * @return List<DocQueueSummaryAgingVO>
	 * @throws EventException
	 */
	public List<DocQueueSummaryAgingVO> searchQueueSummaryAging(SearchQueueSummaryInVO searchQueueSummaryInVO) throws EventException {
		try {
			return dbDao.searchQueueSummaryAging(searchQueueSummaryInVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * 0415 - DPCS Point List를 조회합니다.<br>
	 * 
	 * @param BkgDpcsDocWeightVO bkgDpcsDocWeightVO
	 * @return List<BkgDpcsDocWeightVO>
	 * @throws EventException
	 */
	@Override
	public List<BkgDpcsDocWeightVO> searchDPCSPointList(BkgDpcsDocWeightVO bkgDpcsDocWeightVO) throws EventException {
    	try {        	
            return dbDao.searchDPCSPointList(bkgDpcsDocWeightVO);
        } catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * 0412 - DPCS Weight Value를 수정합니다.
	 * 
	 * @param BkgDpcsDocWeightVO[] bkgDpcsDocWeightVOs
	 * @param String usr_id
	 * @throws EventException
	 */
	@Override
	public void modifyDpcsWeightValue(BkgDpcsDocWeightVO[] bkgDpcsDocWeightVOs, String usr_id) throws EventException {
		try {
			for (int i = 0; i < bkgDpcsDocWeightVOs.length; i++) {
				if (bkgDpcsDocWeightVOs[i].getIbflag().equals("U")) {

					bkgDpcsDocWeightVOs[i].setCreUsrId(usr_id);
					dbDao.modifyDpcsWeightValue(bkgDpcsDocWeightVOs[i]);
				}
			}

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		
	}

	/**
	 * 0432 - B/L Perform Volume By Region Group List를 조회합니다.
	 * 
	 * @param SearchPerfVolByRegionGroupInVO searchPerfVolByRegionGroupInVO
	 * @return List<SearchPerfVolByRegionGroupListVO>
	 * @throws EventException
	 */
	@Override
	public List<SearchPerfVolByRegionGroupListVO> searchBlPerfVolByRegionGroupList(SearchPerfVolByRegionGroupInVO searchPerfVolByRegionGroupInVO) throws EventException {
		try {
			return dbDao.searchBlPerfVolByRegionGroupList(searchPerfVolByRegionGroupInVO);

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * 0432 - B/L Perform Volume By Region Group Detail List를 조회합니다.<br>
	 * 
	 * @param SearchPerfVolByRegionGroupInVO searchPerfVolByRegionGroupInVO
	 * @return List<SearchPerfVolByRegionGroupDtlListVO>
	 * @throws EventException
	 */
		@Override
		public List<SearchPerfVolByRegionGroupDtlListVO> searchBlPerfVolByRegionGroupDtlList(SearchPerfVolByRegionGroupInVO searchPerfVolByRegionGroupInVO) throws EventException {
			try {
				return dbDao.searchBlPerfVolByRegionGroupDtlList(searchPerfVolByRegionGroupInVO);

			} catch(DAOException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
			}
		}

	/**
	 * 0415 - Report By Inputter User Group List를 조회합니다.<br>
	 * 
	 * @param SearchPerfVolByRegionGroupInVO searchPerfVolByRegionGroupInVO
	 * @return List<SearchReportByInputterUserGroupListVO>
	 * @throws EventException
	 */
	@Override
	public List<SearchReportByInputterUserGroupListVO> searchReportByInputterUserGroupList(SearchPerfVolByRegionGroupInVO searchPerfVolByRegionGroupInVO) throws EventException {
		try {
			return dbDao.searchReportByInputterUserGroupList(searchPerfVolByRegionGroupInVO);

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * 0415 - Report By Inputter User Group Detail List를 조회합니다.
	 * 
	 * @param SearchPerfVolByRegionGroupInVO searchPerfVolByRegionGroupInVO
	 * @return List<SearchPerfVolByRegionGroupDtlListVO>
	 * @throws EventException
	 */
	@Override
	public List<SearchPerfVolByRegionGroupDtlListVO> searchReportByInputterUserGroupDtlList(SearchPerfVolByRegionGroupInVO searchPerfVolByRegionGroupInVO) throws EventException {
		try {
			return dbDao.searchReportByInputterUserGroupDtlList(searchPerfVolByRegionGroupInVO);

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * 0415 - Report By Rater User Group List를 조회합니다.
	 * 
	 * @param SearchPerfVolByRegionGroupInVO searchPerfVolByRegionGroupInVO
	 * @return List<SearchReportByRaterUserGroupListVO>
	 * @throws EventException
	 */
	@Override
	public List<SearchReportByRaterUserGroupListVO> searchReportByRaterUserGroupList(SearchPerfVolByRegionGroupInVO searchPerfVolByRegionGroupInVO) throws EventException {
		try {
			return dbDao.searchReportByRaterUserGroupList(searchPerfVolByRegionGroupInVO);

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * BOOKING S/I KIND에 따른 VALUE 자동 세팅<br>
	 * call_pgm_type 세팅 값 1.QUE 2.SI<br>
	 * call_pgm_type 1.QUE일 경우 in_type => 1.QA,2.CONFIRM<br>
	 * 
	 * @param ModifySiValAutoVO modifySiValAutoVO
	 * @param String call_pgm_type
	 * @return ModifySiValAutoVO
	 * @exception  EventException
	 */
	public ModifySiValAutoVO modifySiValAuto(ModifySiValAutoVO modifySiValAutoVO,String call_pgm_type) throws EventException {
		try {
			return dbDao.modifySiValAuto(modifySiValAutoVO,call_pgm_type);

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * TRO 현황 조회 화면(ESM_BKG_1123).
	 * 
	 * @param TroEurStatusListInVO vo
	 * @return List<TroEurStatusListInVO>
	 * @throws EventException
	 */
	public List<TroEurStatusListInVO> searchEurTroStatusList(TroEurStatusListInVO vo) throws EventException {
		try {
			return dbDao.searchEurTroStatusList(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * dcube 에 메일 전송 
	 * 
	 * @param DocQueueBkgHistListVO vo 
	 * @param DocQueueBkgHistListVO[] vos
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void sendMailDcube(DocQueueBkgHistListVO vo,
			DocQueueBkgHistListVO[] vos, SignOnUserAccount account)
			throws EventException {
		try {
//			String orgImgFileNm = vo.getImgFileNm();
//			String orgImgFileNm = "@DUS105842700ANR107140001.tif";
//			String imgFilePath = "//a_dpcs" + "/" + vo.getFaxSvrOfcCd()+ "/" + vo.getImgFilePathCtnt();
//			String imgFilePath = "D://dpcs//" ;
//			String targetImgFilePath = "//a_dpcs/module/BKG" + "/" + vo.getRcvOfcCd()+ "/" + vo.getImgFilePathCtnt();
//			String targetImgFilePath = "D://dpcs//div//" ;

			log.debug("\n\n vos.length: "+vos.length);
//			String subject = "";
//			String mailContent ="";
			String rcvMail = "";
//			BookingUtil utilBC = new BookingUtil();
			BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
			for (int i = 0; i < vos.length; i++) {
				bkgHrdCdgCtntListCondVO.setHrdCdgId("DPCS_RCV_EML");
				bkgHrdCdgCtntListCondVO.setAttrCtnt1(account.getOfc_cd());
//				List<BkgHrdCdgCtntVO> siTranEmail = utilBC.searchHardCoding(bkgHrdCdgCtntListCondVO);
//				log.debug("\n\n siTranEmail.size(): "+siTranEmail.size());
				
				List<BkgHrdCdgCtntVO> siTransEmail = dbDao.searchRhqMail(account.getUsr_id());
				log.debug("\n\n siTransEmail.size(): "+siTransEmail.size());
//				if(siTranEmail.size() > 0){
//					rcvMail = siTranEmail.get(0).getAttrCtnt2();
//					log.debug("\n\n rcvMail: "+rcvMail);
//				} else {
//					rcvMail = "sitrans_test@hanjin.com";
//				}
				if(siTransEmail.size() > 0){
					rcvMail = siTransEmail.get(0).getAttrCtnt2();
					log.debug("\n\n rcvMail: "+rcvMail);
				} else {
					rcvMail = "sitrans_test@smlines.com";
				}
				log.debug("\n targetFileNm:"+vos[i].getImgFileRealPath());
//				if("//a_dpcs/module/BKG/PKGBB/FWS/0000000000/Tiff/Receive/2011/03/19/".equals(targetImgFilePath) ){
//				if("D://dpcs//div//".equals(targetImgFilePath) ){
//					//si automation -----------------------
					PerformanceReportEAIDAO eaiDao = new PerformanceReportEAIDAO();
//					SingleMailAttachedFile singleMailAttachedFile = new SingleMailAttachedFile();
////					singleMailAttachedFile.setFileLocation(targetImgFilePath+targetFileNm); // 주석 
//					singleMailAttachedFile.setFileLocation(vos[i].getImgFileRealPath()); //서버
//					singleMailAttachedFile.setFileName(vos[i].getImgFileNm());
////					singleMailAttachedFile.setFileName(targetFileNm); // 주석
////					singleMailAttachedFile.setFileKey("dpcs"); // 주석
////					log.debug("\n targetImgFilePath:"+targetImgFilePath);
//					subject = "<"+vos[i].getSrUrgCd()+"/"+vos[i].getSrAmdTpCd()+"/"+vos[i].getBkgNo()+">";
//					mailContent = "<DUEDATE:"+vos[i].getSrDueDt()+">\n"+
//								  "<SPLITFLAG:"+vos[i].getSplit()+">\n"+
//								  "<SPLITNO:"+vos[i].getBlSplitNo()+">\n"+
//								  "<SPLITTOTAL:"+vos[i].getBlSplitTtlKnt()+">\n"+
//								  "<SOURCE:DCF>";
//					singleMailAttachedFile.setFileContent(mailContent);
					
					eaiDao.sendDpcsFaxEmail(vos[i],account,rcvMail);
					//2011.08.23 history 추가  Tagged Mail 전송 history
				    dbDao.addBkgSrProcHisPrc(vos[i].getSrNo(), vos[i].getFaxLogRefNo(), "EMLSND", account.getUsr_id());
					//-----------------------			
				    
				    //transfer 로직 추가 (S)--------------------------------
				    
					ModifySrTransferVO modifySrTransferVO = new ModifySrTransferVO();
					modifySrTransferVO.setSrNo(vos[i].getSrNo());
					modifySrTransferVO.setSrKndCd(vos[i].getSrKndCd());
					modifySrTransferVO.setBkgNo(vos[i].getBkgNo());
					modifySrTransferVO.setUsrId(account.getUsr_id());
					modifySrTransferVO.setSrMtchStsCd("T");
					modifySrTransferVO.setOfcCd(account.getOfc_cd());
					
					modifySrTransfer(modifySrTransferVO);
					/*BKG BOOKING에  SI FLAG Mark */
					GeneralBookingReceiptBC generalBookingReceiptBC = new GeneralBookingReceiptBCImpl();
					generalBookingReceiptBC.modifySiFlag(vos[i].getBkgNo(),"F");
					//transfer 로직 추가 (E)--------------------------------
//				}
					
				
			}//for
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}	
	}
	/**
	 * receiving list 수정 
	 * 
	 * @param SearchSREmlReceivingListVO[] vOs 
	 * @param String usr_id
	 * @throws EventException
	 */
	public void modifyReceivingList(
			SearchSREmlReceivingListVO[] vOs,
			String usr_id) throws EventException {
		try {
			for (int i = 0; i < vOs.length; i++) {
				//BKG NO 변경시 ,invalid 체크 
				if("".equals(vOs[i].getBkgNo()) || !vOs[i].getBkgNo().equals(vOs[i].getOldBkgNo())){
					CheckBkgNoVsSrNoVO checkBkgNoVsSrNoVO = checkBkgNoVsSrNo(vOs[i].getBkgNo(), vOs[i].getSrNo());
					if("F".equals(checkBkgNoVsSrNoVO.getChkVal()) ) {
						throw new EventException(new ErrorHandler("BKG00426").getMessage());
					}
				}
				
				dbDao.modifyBkgXterRqstMstBkgNo(vOs[i], usr_id);
//				PerformanceReportBC command2 = new PerformanceReportBCImpl();
				
				if( "".equals(JSPUtil.getNull(vOs[i].getXterSndrId())) ||
					"".equals(JSPUtil.getNull(vOs[i].getSrNo())  )	||
					"".equals(JSPUtil.getNull(vOs[i].getMaxSeq())) ) {
					//Invalid data (NULL)
					throw new EventException(new ErrorHandler("BKG08020").getMessage());
				}
				DpcsWebBookingVO dpcsWebBookingVO = new DpcsWebBookingVO();
				dpcsWebBookingVO.setXterSndrId(vOs[i].getXterSndrId());
				dpcsWebBookingVO.setXterRqstNo(vOs[i].getSrNo());
				dpcsWebBookingVO.setXterRqstSeq(vOs[i].getMaxSeq());
				//seanaccs => Y, samsung => N
				dpcsWebBookingVO.setXterRqstChgFlg("N");
				//BKG_INS_BKG_XTER_RQST_PRC 호출 
				addBkgSrRequest(dpcsWebBookingVO);				
				
				dbDao.modifyBkgSrFaxUrgency(vOs[i], usr_id);
				
				//BKG NO 변경시 , TAGCHG Tag 변경 
				if(!vOs[i].getBkgNo().equals(vOs[i].getOldBkgNo())){
					dbDao.addBkgSrProcHis(vOs[i].getSrNo(), vOs[i].getFaxLogRefNo(),
							"TAGCHG", usr_id, vOs[i].getOldBkgNo(),
							vOs[i].getBkgNo(), "BKG NO");
				}
				//URG 변경시 , TAGCHG Tag 변경 
				if(!vOs[i].getSrUrgCd().equals(vOs[i].getOldSrUrgCd())){
					dbDao.addBkgSrProcHis(vOs[i].getSrNo(), vOs[i].getFaxLogRefNo(),
							"TAGCHG", usr_id, vOs[i].getOldSrUrgCd(),
							vOs[i].getSrUrgCd(), "Urgency");
				}
				//SR Kind 변경시 , TAGCHG Tag 변경 
				if(!vOs[i].getSrAmdTpCd().equals(vOs[i].getOldSrAmdTpCd())){
					dbDao.addBkgSrProcHis(vOs[i].getSrNo(), vOs[i].getFaxLogRefNo(),
							"TAGCHG", usr_id, vOs[i].getOldSrAmdTpCd(),
							vOs[i].getSrAmdTpCd(), "SR Kind");
				}				
				//Split No변경시 , TAGCHG Tag 변경 
				if(!vOs[i].getBlSplitNo().equals(vOs[i].getOldBlSplitNo()) ){
					dbDao.addBkgSrProcHis(vOs[i].getSrNo(), vOs[i].getFaxLogRefNo(),
							"TAGCHG", usr_id, vOs[i].getOldBlSplitNo(),
							vOs[i].getBlSplitNo(), "Split No");
				}
				//Split Ttl변경시 , TAGCHG Tag 변경 
				if(!vOs[i].getBlSplitTtlKnt().equals(vOs[i].getOldBlSplitTtlKnt())	){
					dbDao.addBkgSrProcHis(vOs[i].getSrNo(), vOs[i].getFaxLogRefNo(),
							"TAGCHG", usr_id, vOs[i].getOldBlSplitTtlKnt(),
							vOs[i].getBlSplitTtlKnt(), "Split Ttl");
				}	
				
				//bkg_sr_fax 에 현재 상태 저장 
				dbDao.modifyBkgProcTpCd (vOs[i].getSrNo(), vOs[i].getFaxLogRefNo(),
										 "TAGCHG", usr_id);
				
			}
		}catch(EventException e){
			throw e;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		
	}
	/**
	 * 
	 * @param SearchBkgSrProcHisListVO searchBkgSrProcHisListVO
	 * @return List<SearchBkgSrProcHisListVO>
	 * @throws EventException
	 */
	public List<SearchBkgSrProcHisListVO> searchBkgSrProcHisList(
			SearchBkgSrProcHisListVO searchBkgSrProcHisListVO)
			throws EventException {
		try {
			return dbDao.searchBkgSrProcHisList(searchBkgSrProcHisListVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	/**
	 * 현재 process 상태 업데이트 
	 * 
	 * @param String srNo
	 * @param String faxLogRefNo
	 * @param String procTpCd
	 * @param String usrId 
	 * @throws EventException 
	 */
	public void modifyBkgProcTpCd(
			String srNo, String faxLogRefNo, String procTpCd, String usrId)
			throws EventException {
		try {
			dbDao.modifyBkgProcTpCd(srNo, faxLogRefNo, procTpCd, usrId);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Correcation Change 를 위해 대상 조회
	 * 
	 * @param BkgCorrCngDpcsUsrVO bkgCorrCngDpcsUsrVO
	 * @return List<BkgCorrCngDpcsUsrVO>
	 * @throws EventException
	 */
	public List<BkgCorrCngDpcsUsrVO> searchDPSCCngUserGroup(BkgCorrCngDpcsUsrVO bkgCorrCngDpcsUsrVO) throws EventException {
		try {
			return dbDao.searchDPSCCngUserGroup(bkgCorrCngDpcsUsrVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * 1140 Super User Authority Change - PIC CHANGE(0421화면) 버튼 클릭시 관련 데이블 데이타를 수정합니다.<br>
	 * 
	 * @param BkgCorrCngDpcsUsrVO bkgCorrCngDpcsUsrVO
	 * @param DocQueueDetailListVO docQueueDetailListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyDocsUserCngGroupCd(BkgCorrCngDpcsUsrVO bkgCorrCngDpcsUsrVO, DocQueueDetailListVO docQueueDetailListVO,SignOnUserAccount account) throws EventException {

		if (bkgCorrCngDpcsUsrVO == null) return;
		try {
			String[] arrSrcCd = JSPUtil.getNull(bkgCorrCngDpcsUsrVO.getSrcCd()).split(",");
			String[] arrSrNo = JSPUtil.getNull(bkgCorrCngDpcsUsrVO.getSrNo()).split(",");
			String[] arrBkgNo = JSPUtil.getNull(bkgCorrCngDpcsUsrVO.getBkgNo()).split(",");
			String[] arrBeforeUsrId = JSPUtil.getNull(bkgCorrCngDpcsUsrVO.getBeforeUsrId()).split(",");
			
			BkgCorrCngDpcsUsrVO tempObj = null;
			for (int i = 0; i < arrSrcCd.length; i++) {
				if(JSPUtil.getNull(arrSrcCd[i]).equals("") || JSPUtil.getNull(arrSrNo[i]).equals("")
				   || JSPUtil.getNull(arrBkgNo[i]).equals("") || JSPUtil.getNull(arrBeforeUsrId[i]).equals("")){
					continue;
				}
				tempObj = new BkgCorrCngDpcsUsrVO(); 
				ObjectCloner.build(bkgCorrCngDpcsUsrVO, tempObj);
				
				tempObj.setSrcCd(arrSrcCd[i]);
				tempObj.setSrNo(arrSrNo[i]);
				tempObj.setBkgNo(arrBkgNo[i]);
				tempObj.setBeforeUsrId(arrBeforeUsrId[i]);
				dbDao.modifyDocsUserCngGroupCd(tempObj);
				
				docQueueDetailListVO.setRtnTo(tempObj.getChangeUsrId());
				dbDao.modifyQueueDetailList(docQueueDetailListVO);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * SI Turn Time Report - Summary 를 조회한다. (ESM_BKG_0435)<br>
	 * 
	 * @param SiTurnTimeVO vo
	 * @return List<SiTurnTimeSummaryVO>
	 * @exception EventException
	 */
	public List<SiTurnTimeSummaryVO> searchSiTurnTimeSummary(SiTurnTimeVO vo) throws EventException {

		try {
			return dbDao.searchSiTurnTimeSummary(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * SI Turn Time Report - Detail을  조회한다. (ESM_BKG_0435)<br>
	 * 
	 * @param SiTurnTimeVO vo
	 * @return List<SiTurnTimeDetailVO>
	 * @exception EventException
	 */
	public List<SiTurnTimeDetailVO> searchSiTurnTimeDetail(SiTurnTimeVO vo) throws EventException {

		try {
			return dbDao.searchSiTurnTimeDetail(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * SI Turn Time Report - Detail Ss를  조회한다. (ESM_BKG_0435)<br>
	 * 
	 * @param SiTurnTimeVO vo
	 * @return List<SiTurnTimeDetailVO>
	 * @exception EventException
	 */
	public List<SiTurnTimeDetailVO> searchSiTurnTimeDetailSs(SiTurnTimeVO vo) throws EventException {

		try {
			return dbDao.searchSiTurnTimeDetailSs(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * Queue Status Report - Region별 결과를 조회한다. (ESM_BKG_0463)<br>
	 * 
	 * @param QueueStatusVO vo
	 * @return List<QueueStatusVO>
	 * @exception EventException
	 */
	public List<QueueStatusVO> searchQueueStatusByRegion(QueueStatusVO vo) throws EventException {

		try {
			return dbDao.searchQueueStatusByRegion(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * Queue Status Report - Office별 결과를 조회한다. (ESM_BKG_0463)<br>
	 * 
	 * @param QueueStatusVO vo
	 * @return List<QueueStatusVO>
	 * @exception EventException
	 */
	public List<QueueStatusVO> searchQueueStatusByOffice(QueueStatusVO vo) throws EventException {

		try {
			return dbDao.searchQueueStatusByOffice(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * Queue Status Report - Office별 결과를 조회한다. (ESM_BKG_0463)<br>
	 * 
	 * @param QueueStatusVO vo
	 * @return List<QueueStatusDetailVO>
	 * @exception EventException
	 */
	public List<QueueStatusDetailVO> searchQueueStatusDetail(QueueStatusVO vo) throws EventException {

		try {
			return dbDao.searchQueueStatusDetail(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * ProductionRatio Report - RHQ별 결과를 조회한다. (ESM_BKG_0464)<br>
	 * 
	 * @param ProductionRatioVO vo
	 * @return List<ProductionRatioVO>
	 * @exception EventException
	 */
	public List<ProductionRatioVO> searchProductionRatioByRegion(ProductionRatioVO vo) throws EventException {

		try {
			return dbDao.searchProductionRatioByRegion(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * ProductionRatio Report - Office별 결과를 조회한다. (ESM_BKG_0464)<br>
	 * 
	 * @param ProductionRatioVO vo
	 * @return List<ProductionRatioVO>
	 * @exception EventException
	 */
	public List<ProductionRatioVO> searchProductionRatioByOffice(ProductionRatioVO vo) throws EventException {

		try {
			return dbDao.searchProductionRatioByOffice(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * ProductionRatio Report - 상세 목록을 조회한다. (ESM_BKG_0464)<br>
	 * 
	 * @param ProductionRatioVO vo
	 * @return List<ProductionRatioDetailVO>
	 * @exception EventException
	 */
	public List<ProductionRatioDetailVO> searchProductionRatioDetail(ProductionRatioVO vo) throws EventException {

		try {
			return dbDao.searchProductionRatioDetail(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
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
	public List<BkgDpcsUsrGrpVO> searchDPCSUser(String usrId, String dpcsWrkGrpCd, String rgnOfcCd, BkgDpcsUsrGrpVO vo) throws EventException {
		// TODO Auto-generated method stub
		try {
			return dbDao.searchDPCSUser(usrId, dpcsWrkGrpCd, rgnOfcCd, vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}	
	}
	
	/**
	 * e-Booking & S/I by Email 실적 조회 기능(ESM_BKG_0235)<br>
	 * Report Type : BookingOffice Report (Only) <br>
	 * 
	 * @param EBkgSiPfmcInVO vo
	 * @param boolean detail
	 * @return List<EBkgSiPfmcInVO>
	 * @throws EventException
	 */
	public List<EBkgSiPfmcInVO> searchEBkgSiPfmcListByEmail(EBkgSiPfmcInVO vo, boolean detail) throws EventException {
		try {
			return dbDao.searchEBkgSiPfmcListByEmail(vo, detail);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}

	}
	
	/**
	 * e-Booking & S/I by Email 실적 엑셀 다운로드 기능(ESM_BKG_0235)<br>
	 * Report Type : BookingOffice Report (Only) <br>
	 * 
	 * @param EBkgSiPfmcInVO vo
	 * @return DBRowSet
	 * @throws EventException
	 */
	public DBRowSet searchEBkgSiPfmcListByEmailForExcelDown(EBkgSiPfmcInVO vo) throws EventException {
		try {
			return dbDao.searchEBkgSiPfmcListByEmailForExcelDown(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}

	}	
	
	/**
	 * 해당 BKG이 Front Office Type으로 접수된 적이 있는지 조회한다.<br>
	 * 
	 * @param String bkgNo
	 * @return String
	 * @throws EventException
	 */
	public String searchFrontOfficeFlag(String bkgNo) throws EventException {
		try {
			return dbDao.searchFrontOfficeFlag(bkgNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}

	}


	/**
	 * ESM_BKG_0236 : e-BKG & SI Turn Time Summary를 조회합니다.
	 * 
	 * @param EBkgSiTurnTimeInVO eBkgSiTurnTimeInVO
	 * @return List<EBkgSiTurnTimeOutVO>
	 * @throws EventException
	 */
	@Override
	public List<EBkgSiTurnTimeOutVO> searchEBkgSiTurnTimeSummary(EBkgSiTurnTimeInVO eBkgSiTurnTimeInVO) throws EventException {
		try {
			return dbDao.searchEBkgSiTurnTimeSummary(eBkgSiTurnTimeInVO);

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}


	/**
	 * ESM_BKG_0236 : e-BKG & SI Turn Time Detail을 조회합니다.
	 * 
	 * @param EBkgSiTurnTimeInVO eBkgSiTurnTimeInVO
	 * @param EBkgSiTurnTimeInVO[] eBkgSiTurnTimeInVOs
	 * @return List<EBkgSiTurnTimeOutVO>
	 * @throws EventException
	 */
	@Override
	public List<EBkgSiTurnTimeOutVO> searchEBkgSiTurnTimeDetail(EBkgSiTurnTimeInVO eBkgSiTurnTimeInVO, EBkgSiTurnTimeInVO[] eBkgSiTurnTimeInVOs) throws EventException {
		try {
			return dbDao.searchEBkgSiTurnTimeDetail(eBkgSiTurnTimeInVO, eBkgSiTurnTimeInVOs);

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}


	/**
	 * ESM_BKG_0236 : e-BKG & SI Upload Time Summary를 조회합니다.
	 * 
	 * @param EBkgSiTurnTimeInVO eBkgSiTurnTimeInVO
	 * @return List<EBkgSiTurnTimeOutVO>
	 * @throws EventException
	 */
	@Override
	public List<EBkgSiTurnTimeOutVO> searchEBkgSiUploadTimeSummary(EBkgSiTurnTimeInVO eBkgSiTurnTimeInVO) throws EventException {
		try {
			return dbDao.searchEBkgSiUploadTimeSummary(eBkgSiTurnTimeInVO);

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}


	/**
	 * ESM_BKG_0236 : e-BKG & SI Upload Time Detail을 조회합니다.
	 * 
	 * @param EBkgSiTurnTimeInVO eBkgSiTurnTimeInVO
	 * @param EBkgSiTurnTimeInVO[] eBkgSiTurnTimeInVOs
	 * @return List<EBkgSiTurnTimeOutVO>
	 * @throws EventException
	 */
	@Override
	public List<EBkgSiTurnTimeOutVO> searchEBkgSiUploadTimeDetail(EBkgSiTurnTimeInVO eBkgSiTurnTimeInVO, EBkgSiTurnTimeInVO[] eBkgSiTurnTimeInVOs) throws EventException {
		try {
			return dbDao.searchEBkgSiUploadTimeDetail(eBkgSiTurnTimeInVO, eBkgSiTurnTimeInVOs);

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Doc Performance Report(ESM_BKG_0214)<br>
	 * Doc Performance Report에서 사용할 Region Office 목록을 불러온다.<br>
	 *
	 * @return List<BkgComboVO>
	 * @throws EventException
	 */
	public List<BkgComboVO> searchRgnOfficeCdForPFMC() throws EventException {
		try {
            return dbDao.searchRgnOfficeCdForPFMC();
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	
	/**
	 * TRO 현황 조회 화면(ESM_BKG_0621).
	 * 
	 * @param TroUsaStatusListInVO vo
	 * @return List<TroUsaStatusListInVO>
	 * @throws EventException
	 */
	public List<TroUsaStatusListInVO> searchTroUsaStatusList(TroUsaStatusListInVO vo) throws EventException {
		try {
			return dbDao.searchTroUsaStatusList(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * WEB SI Auto Upload 후 Queue List와 History 를 변경한다.
	 * 
	 * @param BkgWebServiceVO vo
	 * @exception EventException
	 */
	public void modifyQueueByAutoUpload(BkgWebServiceVO vo) throws EventException {

		try {

			dbDao.addQueueHistoryByAutoUpload(vo);
			dbDao.modifyQueueStatusByAutoUpload(vo);
			
			GeneralBookingReceiptBC generalBookingReceiptBC = new GeneralBookingReceiptBCImpl();
			generalBookingReceiptBC.modifySiFlag(vo.getBkgNo(),"Y");
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * WEB SI Audit 후 Queue List와 History 를 변경한다.
	 * 
	 * @param SIWebServiceVO vo
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int modifyQueueByWebSiAudit(SIWebServiceVO vo,  SignOnUserAccount account) throws EventException {
		int updCnt= 0;
		try {

			updCnt = dbDao.addQueueHistoryByWebSiAudit(vo, account);
			dbDao.modifyQueueStatusByWebSiAudit(vo, account);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		return updCnt;
	}
}