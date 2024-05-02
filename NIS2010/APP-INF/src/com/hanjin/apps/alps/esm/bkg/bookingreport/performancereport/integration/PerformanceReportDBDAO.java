/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : PerformanceReportDBDAO.java
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
 * 2011.05.11 김상수 [CHM-201109394-01] DPCS 고도화 요청 - B/L Turn Time Report (ESM_BKG_0067) 화면, 쿼리, VO및 java Method들의 전면수정
 * 2011.05.16 김상수 [CHM-201109394-01] DPCS 고도화 요청 : B/L Turn Time Report (ESM_BKG_0067) Summary Sheet추가 및 로직 변경
 * 2011.10.04 정선용 [CHM-201112445] SI Automation System 구축
 * 2011.10.18 조원주 [CHM-201113594] DPCS-SI Turn Time레포트 및 Draft B/L전송후 Amendment S/I PIC변경관련 개발요구사항 송부
 * 2011.11.22 정선용 [CHM-201114286-01] DPCS-SI Turn Time레포트 및 Draft B/L전송후 Amendment S/I PIC변경관련 개발요구사항 송부
 * 2011.11.30 정선용 [CHM-201114554-01] DPCS-Correction 기능 보완 요청
 * 2011.12.08 금병주 [CHM-201114555-01] DPCS Correction 기능 보완 -2
 * 2012.01.07 조정민 [CHM-201221961] Email 접수 Draft B/L Correction 분류 시스템 개발
 * 2013.04.04 김진주 [CHM-201323618] DPCS SI Turn Time 로직 보완 요청(Workshop 결과)
 * 2013.06.24 김진주 [CHM-201324100] E-BKG & E-SI Turn Time Report 
 * 2013.11.06 김진주 [CHM-201327291][SZP DPCS] 라이브 적용일자 및 시스템 개선사항 요청
 * 2014.06.13 조인영 [CHM-201430236] 미주 서비스 센터 통합 관련 시스템 개발 4차 - TRO Report 신규 생성 (USA)
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.basic.PerformanceReportBCImpl;
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
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgWebServiceVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.SIWebServiceVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgDpcsUsrGrpVO;
import com.hanjin.syscommon.common.table.BkgHrdCdgCtntVO;
import com.hanjin.syscommon.common.table.BkgObChnRcvHisVO;
import com.hanjin.syscommon.common.table.BkgObChnRcvVO;
import com.hanjin.syscommon.common.table.BkgXterSrchSetVO;

/**
 * NIS2010 PerformanceReportDBDAO <br>
 * - NIS2010-BookingReport system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author kang dong yun
 * @see PerformanceReportBCImpl 참조
 * @since J2EE 1.6
 */
public class PerformanceReportDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * VVD Selection Inquiry 결과를 조회한다.<br>
	 * 
	 * @param vesselVVDListVO vesselVVDListVO
	 * @return List<VesselVVDListVO>
	 * @exception  DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VesselVVDListVO> searchVVDList(VesselVVDListVO vesselVVDListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VesselVVDListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vesselVVDListVO != null){
				
				Map<String, String> mapVO = vesselVVDListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOVesselVVDListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VesselVVDListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
	 /**
	  * VVD Selection Inquiry 유효성을 체크한다<br>
	  * 
	  * @param 	VesselVVDListVO vesselVVDListVO
	  * @exception  DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void checkVVDList(VesselVVDListVO vesselVVDListVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<VesselVVDListVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 if(vesselVVDListVO != null){
					
				 log.debug(" vvd = " + vesselVVDListVO.getVvd());
				 log.debug(" vsl_cd = " + vesselVVDListVO.getVslCd());
					
				 Map<String, String> mapVO = vesselVVDListVO .getColumnValues();
				
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOVesselVVDListVO2RSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, VesselVVDListVO .class);
				
			 	if (list.size() == 0)
			 		throw new DAOException("Fail to VVD Value");

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	 }
	 
	 /**
	  * C/A Summary Template 결과를 조회한다.<br>
	  * 
	  * @param BkgRptDfltVO bkgRptDfltVO
	  * @return List<BkgRptDfltVO>
	  * @exception  DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<BkgRptDfltVO> searchReportTemplateList(BkgRptDfltVO bkgRptDfltVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<BkgRptDfltVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 if(bkgRptDfltVO != null){
					
				 Map<String, String> mapVO = bkgRptDfltVO .getColumnValues();
				
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOBkgRptDfltVORSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgRptDfltVO .class);
				
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		 
		 return list;
	 }
	
	 /**
	  * C/A Summary Template 을 추가한다.<br>
	  * 
	  * @param BkgRptDfltVO bkgRptDfltVO
	  * @exception  DAOException
	  */
	 public void addReportTemplate(BkgRptDfltVO bkgRptDfltVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();			
		
		 try{
			 if(bkgRptDfltVO != null){
					Map<String, String> mapVO = bkgRptDfltVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}							
				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOBkgRptDfltVOCSQL(), param,velParam);
				
				if(insCnt == Statement.EXECUTE_FAILED)
							throw new DAOException(new ErrorHandler("COM12240").getMessage());

		 } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 } catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }

	 }
	 
	 
	 /**
	  * C/A Summary Template 을 수정한다.<br>
	  * 
	  * @param BkgRptDfltVO bkgRptDfltVO
	  * @exception  DAOException
	  */
	 public void modifyReportTemplate(BkgRptDfltVO bkgRptDfltVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();			
		
		 try{
			 if(bkgRptDfltVO != null){
					Map<String, String> mapVO = bkgRptDfltVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}							
				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOBkgRptDfltVOUSQL(), param,velParam);
				
				if(insCnt == Statement.EXECUTE_FAILED)
							throw new DAOException(new ErrorHandler("COM12240").getMessage());

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	 }
	 
	 /**
	  * C/A Summary Template 을 삭제한다.<br>
	  * 
	  * @param BkgRptDfltVO bkgRptDfltVO
	  * @exception  DAOException
	  */
	 public void removeReportTemplate(BkgRptDfltVO bkgRptDfltVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();			
		
		 try{
			 if(bkgRptDfltVO != null){
					Map<String, String> mapVO = bkgRptDfltVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}							
				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOBkgRptDfltVODSQL(), param,velParam);
				
				if(insCnt == Statement.EXECUTE_FAILED)
							throw new DAOException(new ErrorHandler("COM12240").getMessage());

		 } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	 }
	 
	 	/**
		 * BDR Status를 기간 및 BKG Office별로 조회한다.
		 * 
		 * @param 	BDRBookingStatusListVO bdrBookingStatusListVO
		 * @return List<BDRBookingStatusListVO>
		 * @exception  DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<BDRBookingStatusListVO> searchBDRBookingPfmcStatusList(BDRBookingStatusListVO bdrBookingStatusListVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<BDRBookingStatusListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				Map<String, String> mapVO = bdrBookingStatusListVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchBDRBookingPfmcStatusList1RSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, BDRBookingStatusListVO .class);
			
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		} 

		 
		 /**
		 * SR Receiving List 결과를 조회한다.<br>
		 * 
		 * @param SearchSRReceivingListVO vo
	  	 * @return List<SearchSRReceivingListVO>
		 * @exception  DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<SearchSRReceivingListVO> searchSRReceivingList(SearchSRReceivingListVO vo) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchSRReceivingListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(vo != null){
					Map<String, String> mapVO = vo .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchSRReceivingListVORSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSRReceivingListVO .class);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}
		
		/**
		 * SR EML Receiving List 결과를 조회한다.<br>
		 * 
		 * @param SearchSREmlReceivingListVO vo
		 * @return List<SearchSREmlReceivingListVO>
		 * @exception DAOException
		 */
		@SuppressWarnings("unchecked")
		public List<SearchSREmlReceivingListVO> searchSREmlReceivingList(
				SearchSREmlReceivingListVO vo) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchSREmlReceivingListVO> list = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
	
			try {
				if (vo != null) {
					Map<String, String> mapVO = vo.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("")
						.executeQuery(
								(ISQLTemplate) new PerformanceReportDBDAOSearchSREmlReceivingListVORSQL(),
								param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset,
						SearchSREmlReceivingListVO.class);
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}
		
		/**
		 * SR EML Fail Receiving이 존재하는지 조회한다.<br>
		 * 
		 * @param SearchSREmlReceivingListVO vo
		 * @return Boolean
		 * @exception DAOException
		 */
		@SuppressWarnings("unchecked")
		public Boolean chkSREmlFailReceivingList(
				SearchSREmlReceivingListVO vo) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchSREmlReceivingListVO> list = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			Boolean isEmlRcvFailFlg = false;
			try {
				if (vo != null) {
					Map<String, String> mapVO = vo.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("")
						.executeQuery(
								(ISQLTemplate) new PerformanceReportDBDAOSearchSREmlReceivingListVORSQL(),
								param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset,
						SearchSREmlReceivingListVO.class);
				
				if (list != null && list.size() > 0) {
					isEmlRcvFailFlg = true;
				}else{
					isEmlRcvFailFlg = false;
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return isEmlRcvFailFlg;
		}
		/**
		 * SR EML Atch File List 결과를 조회한다.<br>
		 * 
		 * @param SearchSREmlAtchFileListVO vo
		 * @return List<SearchSREmlAtchFileListVO>
		 * @exception DAOException
		 */
		@SuppressWarnings("unchecked")
		public List<SearchSREmlAtchFileListVO> searchSREmlAtchFileList(
				SearchSREmlAtchFileListVO vo) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchSREmlAtchFileListVO> list = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
	
			try {
				if (vo != null) {
					Map<String, String> mapVO = vo.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("")
						.executeQuery(
								(ISQLTemplate) new PerformanceReportDBDAOSearchSREmlAtchFileListVORSQL(),
								param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset,
						SearchSREmlAtchFileListVO.class);
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}
		/**
		 * SR EML Contents 정보를 조회한다.<br>
		 * 
		 * @param SearchSREmlCtntVO vo
		 * @return List<SearchSREmlCtntVO>
		 * @exception DAOException
		 */
		@SuppressWarnings("unchecked")
		public List<SearchSREmlCtntVO> searchSREmlCtnt(
				SearchSREmlCtntVO vo) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchSREmlCtntVO> list = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
	
			try {
				if (vo != null) {
					Map<String, String> mapVO = vo.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("")
						.executeQuery(
								(ISQLTemplate) new PerformanceReportDBDAOSearchSREmlCtntVORSQL(),
								param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset,
						SearchSREmlCtntVO.class);
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}
		 /**
		  * SR Receiving List Input Remark 를 수정 한다.<br>
		  * 
		  * @param String srNo
		  * @param String usrId
		  * @param String srKndCd
		  * @param String rcvRmk
		  * @exception  DAOException
		  */
		 public void modifyQueueRemark(String srNo,String usrId, String srKndCd, String rcvRmk) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();			
			
			 try{
				 if(srNo != null){
					 	param.put("sr_no", srNo);
					 	param.put("usr_id", usrId);				            
			            param.put("sr_knd_cd", srKndCd);
			            param.put("rcv_rmk", rcvRmk);
			            
			            velParam.put("sr_no", srNo);
			            velParam.put("usr_id", usrId);
			            velParam.put("sr_knd_cd", srKndCd);
			            velParam.put("rcv_rmk", rcvRmk);
					}							
					SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
					int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOSearchSRReceivingListVOUSQL(), param,velParam);
					
					if(insCnt == Statement.EXECUTE_FAILED)
								throw new DAOException(new ErrorHandler("COM12240").getMessage());

			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}

		 }

		 /**
		  * SR Receiving List 를 수정 한다.<br>
		  * 
		  * @param BkgSrFaxVO bkgSrFaxVO
		  * @exception  DAOException
		  */
		 public void modifySRReceiving(BkgSrFaxVO bkgSrFaxVO) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();			
			
			 try{
				 if(bkgSrFaxVO != null){
						Map<String, String> mapVO = bkgSrFaxVO .getColumnValues();
					
						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}							
					SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
					int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOBkgSrFaxVOUSQL(), param,velParam);
					
					if(insCnt == Statement.EXECUTE_FAILED)
								throw new DAOException(new ErrorHandler("COM12240").getMessage());

			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}

		 }
		 /**
		  * SR Receiving List 를 수정 한다.<br>
		  * 
		  * @param BkgSrFaxVO bkgSrFaxVO
		  * @exception  DAOException
		  */
		 public void addBkgSRCrntRqst(BkgSrFaxVO bkgSrFaxVO) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();			
			
			 try{
				 if(bkgSrFaxVO != null){
						Map<String, String> mapVO = bkgSrFaxVO .getColumnValues();
					
						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}							
					SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
					int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOBkgSRCrntRqstCSQL(), param,velParam);
					
					if(insCnt == Statement.EXECUTE_FAILED)
								throw new DAOException(new ErrorHandler("COM12240").getMessage());

			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}

		 }
		 
			 
		 /**
		  * SR Receiving List 를 삭제 한다.<br>
		  * 
		  * @param BkgSrFaxVO bkgSrFaxVO
		  * @exception  DAOException
		  */
		 public void removeSRReceiving(BkgSrFaxVO bkgSrFaxVO) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();			
			
			 try{
				 if(bkgSrFaxVO != null){
						Map<String, String> mapVO = bkgSrFaxVO .getColumnValues();
					
						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}							
					SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
					int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOBkgSrFaxListVOUSQL(), param,velParam);
					
					if(insCnt == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to delete SQL");

			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}

		 }
			 
	    /**
		 * SR Receiving List BKG Match & Transfer 에 SrNo에 대한 BkgNo를 가져온다. <br>
		 * 
		 * @param String bkgNo
		 * @param String srNo
		 * @return CheckBkgNoVsSrNoVO
		 * @exception  DAOException
		 */
		 @SuppressWarnings("unchecked")
		public CheckBkgNoVsSrNoVO checkBkgNoVsSrNo(String bkgNo, String srNo) throws DAOException {
			DBRowSet dbRowset = null;
			List<CheckBkgNoVsSrNoVO> list = null;
			CheckBkgNoVsSrNoVO checkBkgNoVsSrNoVO = new CheckBkgNoVsSrNoVO();
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(bkgNo != null){
					param.put("bkg_no", bkgNo);
		            param.put("sr_no", srNo);
		            
		            velParam.put("bkg_no", bkgNo);
		            velParam.put("sr_no", srNo);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOCheckBkgNoVsSrNoVORSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, CheckBkgNoVsSrNoVO .class);
				if (list != null && list.size() > 0) {
					checkBkgNoVsSrNoVO = (CheckBkgNoVsSrNoVO) list.get(0);
				}else{
					checkBkgNoVsSrNoVO.setBkgNo(bkgNo);
					checkBkgNoVsSrNoVO.setSrNo(srNo);
					checkBkgNoVsSrNoVO.setChkVal("F");
				}
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return checkBkgNoVsSrNoVO;
		}
				 
		/**
		 * SR Receiving List BKG Match & Transfer 에 DPCS IP를 가져온다.<br>
	     * 
	     * @param String ofcNo
		 * @return String
		 * @exception  DAOException
		 */
		public String searchDpcsIp(String ofcNo) throws DAOException {
			DBRowSet dbRowset = null;
			
			String searchDpcsIp = "";
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(ofcNo != null){
					param.put("ofc_cd", ofcNo);
		            					           
		            velParam.put("ofc_cd", ofcNo);

				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAODpcsAmendReasonBkgList2VORSQL(), param, velParam);
				
				if (dbRowset.first()){
				
					searchDpcsIp = dbRowset.getString(1);
				}
				
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return searchDpcsIp;
		}
					 
	    /**
		 * SR Receiving List BKG Match & Transfer 에 AmendReason 정보를 가져온다.<br>
		 * 
		 * @param String srNo
		 * @param String bkgSrKndCd
		 * @param String usrId
		 * @return List<DpcsAmendReasonBkgListVO>
		 * @exception  DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<DpcsAmendReasonBkgListVO> searchAmendReasonBkgList(String srNo, String bkgSrKndCd,String usrId) throws DAOException {
			DBRowSet dbRowset = null;
			List<DpcsAmendReasonBkgListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try{
				if(srNo != null){									
		            param.put("sr_no", srNo);
		            param.put("sr_knd_cd", bkgSrKndCd);
		            param.put("user_id", usrId);
		            
		            velParam.put("sr_no", srNo);
		            velParam.put("sr_knd_cd", bkgSrKndCd);	
		            velParam.put("user_id", usrId);		
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAODpcsAmendReasonBkgListVORSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, DpcsAmendReasonBkgListVO .class);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}
					 
	    /**
		 * SR Receiving List BKG Match & Transfer 에 User Part 정보를 가져온다.<br>
		 * 
		 * @param String usrId
		 * @return String[]
		 * @exception  DAOException
		 */
		public String[] searchUesrGroupId(String usrId) throws DAOException {
			DBRowSet dbRowset = null;
			
			String[] usrGrpInfo = new String[3];
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(usrId != null){
					param.put("usr_id", usrId);
		            					           
		            velParam.put("usr_id", usrId);

				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAODpcsAmendReasonBkgList3VORSQL(), param, velParam);
				
				if (dbRowset.first()){
				
					usrGrpInfo[0] = dbRowset.getString(1);
					usrGrpInfo[1] = dbRowset.getString(2);
					usrGrpInfo[2] = dbRowset.getString(3);
				}
				
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return usrGrpInfo;
		}
		 /**
		  * SR Receiving List BKG Match & Transfer 에 Sr 작성 시간을 수정한다.<br>
		  * 
		  * @param String srNo
		  * @param String faxLogRefNo
		  * @param String bkgSrKndCd
		  * @param SignOnUserAccount account
		  * @exception  DAOException
		  */
		 public void modifySrStartTime(String srNo,String faxLogRefNo,String bkgSrKndCd,SignOnUserAccount account) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();			
			
			 try{
				 if(srNo != null){
					 	param.put("sr_no", srNo);
					 	param.put("fax_log_ref_no", faxLogRefNo);
					 	param.put("sr_knd_cd", bkgSrKndCd);
					 	param.put("usr_id", account.getUsr_id());
					 	
			            velParam.put("sr_no", srNo);
			            velParam.put("fax_log_ref_no", faxLogRefNo);
			            velParam.put("sr_knd_cd", bkgSrKndCd);
			            velParam.put("usr_id", account.getUsr_id());
					}							
					SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
					int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOBkgSrFax2VOUSQL(), param,velParam);
					
					if(insCnt == Statement.EXECUTE_FAILED)
								throw new DAOException(new ErrorHandler("COM12240").getMessage());

			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}

		 }
		 
		 /**
		  * SR Receiving List BKG Match & Transfer 에 BkgNo Match 정보를 수정한다.<br>
		  * 
		  * @param DocQueueBkgHistListVO vo
		  * @param String status
		  * @exception  DAOException
		  */
		 public void modifyBkgNoMatch(DocQueueBkgHistListVO vo, String status) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();	
									
										
			 try{
				 
				 if(vo != null){									 	
					 	param.put("sr_no", vo.getSrNo());
					 	param.put("fax_log_ref_no", vo.getFaxLogRefNo());
					 	param.put("sr_knd_cd", vo.getSrKndCd()); 
					 	param.put("sr_mtch_sts_cd", status);
					 	param.put("usr_id", vo.getUpdUsrId());
					 	param.put("mtch_usr_id", vo.getUpdUsrId());
					 	param.put("fnt_ofc_eml", vo.getFntOfcEml());
					 	
			            velParam.put("sr_no", vo.getSrNo());
			            velParam.put("fax_log_ref_no", vo.getFaxLogRefNo());
			            velParam.put("sr_knd_cd", vo.getSrKndCd()); 
			            velParam.put("sr_mtch_sts_cd", status);
			            velParam.put("usr_id", vo.getUpdUsrId());
			            velParam.put("mtch_usr_id", vo.getUpdUsrId());
			            velParam.put("fnt_ofc_eml", vo.getFntOfcEml());
			            
					}							
					SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
					
					int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOBkgSrFax3VOUSQL(), param,velParam);
					
					if(insCnt == Statement.EXECUTE_FAILED)
								throw new DAOException(new ErrorHandler("COM12240").getMessage());

			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}

		 }
		 /**
		  * SR Receiving List BKG Match & Transfer 에 Transfer 정보를 수정한다.<br>
		  * 
		  * @param ModifySrTransferVO modifySrTransferVO
		  * @exception  DAOException
		  */
		 public void modifySrTransfer(ModifySrTransferVO modifySrTransferVO) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();	
									
			 try{
				 if(modifySrTransferVO != null){
					Map<String, String> mapVO = modifySrTransferVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				 }		
				
				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAODocQueueBkgHistList3VOUSQL(), param,velParam);
				
				if(insCnt == Statement.EXECUTE_FAILED)
							throw new DAOException(new ErrorHandler("COM12240").getMessage());

			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}

		 }
		 
		 /**
		  * SR Receiving List Transfer 에 QueaueBkgNo 정보를 SR History 에 추가한다.<br>
		  * 
		  * @param ModifySrTransferVO modifySrTransferVO
		  * @exception  DAOException
		  */
		 public void addSrTransfer(ModifySrTransferVO modifySrTransferVO) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();			
			
			 try{
				 if(modifySrTransferVO != null){
					Map<String, String> mapVO = modifySrTransferVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				 }				
				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOModifySrTransferCSQL(), param,velParam);
				
				if(insCnt == Statement.EXECUTE_FAILED)
							throw new DAOException(new ErrorHandler("COM12240").getMessage());

			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}

		 }
		 
		 /**
		  * SR Receiving List Transfer 에서 생성한 history seq 를  수정한다.<br>
		  * 
		  * @param ModifySrTransferVO modifySrTransferVO
		  * @exception  DAOException
		  */
		 public void modifySrCrntRqstForMaxHisSeq(ModifySrTransferVO modifySrTransferVO) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();			
			
			 try{
				 if(modifySrTransferVO != null){
					Map<String, String> mapVO = modifySrTransferVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				 }				
				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOmodifySrCrntRqstForMaxHisSeqUSQL(), param,velParam);
				
				if(insCnt == Statement.EXECUTE_FAILED)
							throw new DAOException(new ErrorHandler("COM12240").getMessage());

			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}

		 }
		 
		 /**
		 * BKG_SR_HIS 테이블에서 MAX(SR_HIS_SEQ) 값 조회 <br>
		 * @param 	String bkgNo
		 * @return 	String
		 * @throws DAOException
		 */
		public int searchMaxSrHisSeq(String bkgNo) throws DAOException {
			DBRowSet dbRowset = null;
			int srHisSeq = 0;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			try {
				param.put("bkg_no", bkgNo);
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new PerformanceReportDBDAOSearchMaxSrHisSeqRSQL(), param, velParam);
				if (dbRowset.next()) {
					srHisSeq = dbRowset.getInt("SR_HIS_SEQ");
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return srHisSeq;
		}
		
		
		 /**
		  * SR Receiving List BKG Match & Transfer 에 QueaueBkgNo 정보를 삭제한다.<br>
		  * 
		  * @param DocQueueBkgHistListVO docQueueBkgHistListVO
		  * @exception  DAOException
		  */
		 public void removeQueueBkgNo(DocQueueBkgHistListVO docQueueBkgHistListVO) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();	
									
										
			 try{
				 
				 if(docQueueBkgHistListVO != null){									 	
					 	Map<String, String> mapVO = docQueueBkgHistListVO .getColumnValues();
						
						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}							
					SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
					int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAODpcsAmendReasonBkgListVODSQL(), param,velParam);
					
					if(insCnt == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to Delete SQL");

			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}

		 }
		 
		 
		 /**
		  * SR Receiving List BKG Match & Transfer 에 QueaueBkgNo 정보를 삭제한다.<br>
		  * 
		  * @param DocQueueBkgHistListVO docQueueBkgHistListVO
		  * @exception  DAOException
		  */
		 public void removeQueueBkgList (DocQueueBkgHistListVO docQueueBkgHistListVO) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();	
									
										
			 try{
				 
				 if(docQueueBkgHistListVO != null){									 	
					 	Map<String, String> mapVO = docQueueBkgHistListVO .getColumnValues();
						
						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}							
					SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
					int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAODpcsAmendReasonBkgList2VODSQL(), param,velParam);
					
					if(insCnt == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to Delete SQL");

			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}

		 }
		
		 /**
		  * SR Receiving List BKG Match & Transfer 에 QueueBkgNoMaster 정보를 입력한다.<br>
		  * 
		  * @param DocQueueBkgHistListVO docQueueBkgHistListVO
		  * @exception  DAOException
		  */
		 public void addQueueBkgNoMaster (DocQueueBkgHistListVO docQueueBkgHistListVO) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();	
									
										
			 try{
				 
				 if(docQueueBkgHistListVO != null){									 	
					 	Map<String, String> mapVO = docQueueBkgHistListVO .getColumnValues();
						
						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}							
					SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
					int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAODocQueueBkgHistListVOCSQL(), param,velParam);
					
					if(insCnt == Statement.EXECUTE_FAILED)
								throw new DAOException(new ErrorHandler("COM12240").getMessage());

			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}

		 }
		
		 /**
		  * SR Receiving List BKG Match & Transfer 에 QueueBkgNoMaster 정보를 입력한다.<br>
		  * 
		  * @param DocQueueBkgHistListVO docQueueBkgHistListVO
		  * @exception  DAOException
		  */
		 public void modifyCorrectionSRWorkStatus (DocQueueBkgHistListVO docQueueBkgHistListVO) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();	
									
										
			 try{
				 
				 if(docQueueBkgHistListVO != null){									 	
					 	Map<String, String> mapVO = docQueueBkgHistListVO .getColumnValues();
						
						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}							
					SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
					int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOModifyCorrectionSRWorkStatusUSQL(), param,velParam);
					
					if(insCnt == Statement.EXECUTE_FAILED)
								throw new DAOException(new ErrorHandler("COM12240").getMessage());

			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}

		 }
		 
		 /**
		  * SR Receiving List BKG Match & Transfer 에 AmendReason 정보를 입력한다.<br>
		  * 
		  * @param DocQueueBkgHistListVO docQueueBkgHistListVO
		  * @exception  DAOException
		  */
		 public void addQueueBkgNoAmendReason(DocQueueBkgHistListVO docQueueBkgHistListVO) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();	
									
										
			 try{
				 
				 if(docQueueBkgHistListVO != null){									 	
					 	Map<String, String> mapVO = docQueueBkgHistListVO .getColumnValues();
						
						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}							
					SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
					int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAODocQueueBkgHistList2VOCSQL(), param,velParam);
					
					if(insCnt == Statement.EXECUTE_FAILED)
								throw new DAOException(new ErrorHandler("COM12240").getMessage());

			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}

		 }
		 
		 /**
		  * SR Receiving List BKG Match & Transfer 에 QueueBkgNoMaster 정보를 수정한다.<br>
		  * 
		  * @param DocQueueBkgHistListVO docQueueBkgHistListVO
		  * @exception  DAOException
		  */
		 public void modifyQueueBkgNoMaster (DocQueueBkgHistListVO docQueueBkgHistListVO) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();	
									
										
			 try{
				 
				 if(docQueueBkgHistListVO != null){									 	
					 	Map<String, String> mapVO = docQueueBkgHistListVO .getColumnValues();
						
						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}							
					SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
					int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAODocQueueBkgHistListVOUSQL(), param,velParam);
					
					if(insCnt == Statement.EXECUTE_FAILED)
								throw new DAOException(new ErrorHandler("COM12240").getMessage());

			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}

		 }
		 
		 /**
			 * SR Receiving List BKG Match & Transfer 에 Max 값을 조회한다.<br>
			 * 
			 * @param DocQueueBkgHistListVO docQueueBkgHistListVO
			 * @return String
			 * @exception  DAOException
			 */
			public String searchSrCrntRqstMaxSeq(DocQueueBkgHistListVO docQueueBkgHistListVO) throws DAOException {
				DBRowSet dbRowset = null;
				
				String maxSeq = "";
				
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				try{
					if(docQueueBkgHistListVO != null){
						Map<String, String> mapVO = docQueueBkgHistListVO .getColumnValues();
						
						param.putAll(mapVO);
						velParam.putAll(mapVO);

					}
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAODocQueueBkgHistList2VORSQL(), param, velParam);
					
					if (dbRowset.first()){
					
						maxSeq = dbRowset.getString(1);
					}
					
				}catch(SQLException se){
					log.error(se.getMessage(),se);
					throw new DAOException(new ErrorHandler(se).getMessage());
				}catch(Exception ex){
					log.error(ex.getMessage(),ex);
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}
				return maxSeq;
			}

		 /**
		 * SR Receiving List BKG Match & Transfer 에 SrNo에 해당하는 BkgNo가 있는지 체크한다.<br>
		 * 
		 * @param DocQueueBkgHistListVO docQueueBkgHistListVO
		 * @return List<DocQueueBkgHistListVO>
		 * @exception  DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<DocQueueBkgHistListVO> checkBkgNoOrSrNo(DocQueueBkgHistListVO docQueueBkgHistListVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<DocQueueBkgHistListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try{
				if(docQueueBkgHistListVO != null){
					Map<String, String> mapVO = docQueueBkgHistListVO .getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);

				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAODocQueueBkgHistListVORSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, DocQueueBkgHistListVO .class);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}

		 /**
		 * 해당 VVD별 Port의 Document마감 시간 조회함.
		 * 화면 - ESM_BKG_0417
		 * @param PortCLSReportVO vo
		 * @return List<PortCLSReportVO>
		 * @exception  DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<PortCLSReportVO> searchPCTCLSReport(PortCLSReportVO vo) throws DAOException {
			DBRowSet dbRowset = null;
			List<PortCLSReportVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			//@ 조건문 In절 처리
			if(vo.getRtroKndCd() != null && !"".equals(vo.getRtroKndCd())){
				vo.setRtroKndCd("'" + vo.getRtroKndCd().replaceAll(",", "','") + "'");
			}
			try{
				Map<String, String> mapVO = vo .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOPortCLSReportVORSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortCLSReportVO .class);
			
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}   
		 
		 /**
		 * Freight & Charge 요약 리포트 조회한다.
		 * 화면 - ESM_BKG_0595
		 * @param FreightChargeSummaryReportInVO vo
		 * @return List<FreightChargeSummaryReportInVO>
		 * @exception  DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<FreightChargeSummaryReportInVO> searchFrtSumList(FreightChargeSummaryReportInVO vo) throws DAOException {
			DBRowSet dbRowset = null;
			List<FreightChargeSummaryReportInVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				Map<String, String> mapVO = vo .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOFreightChargeSummaryReportInVORSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, FreightChargeSummaryReportInVO .class);
			
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}

		/**
		 * SR Data의 처리 Office 별 B/L Turn Time 집계 현황을 조회한다. (Summary List)
		 * 화면 - ESM_BKG_0067
		 * @param DocPerformanceSummaryVO docPerformanceSummaryVO
		 * @return List<DocPerformanceSummaryVO>
		 * @exception  DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<DocPerformanceSummaryVO> searchDPCSTurnTimeSummary(DocPerformanceSummaryVO docPerformanceSummaryVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<DocPerformanceSummaryVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				Map<String, String> mapVO = docPerformanceSummaryVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchDPCSTurnTimeSummaryRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, DocPerformanceSummaryVO.class);

			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}

		/**
		 * SR Data의 처리 Office 별 B/L Turn Time 상세실적 현황을 조회한다. (Detail List)
		 * 화면 - ESM_BKG_0067
		 * @param DocPerformanceReportInVO docPerformanceReportInVO
		 * @return List<DocPerformanceReportInVO>
		 * @exception  DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<DocPerformanceReportInVO> searchDPCSTurnTimeList(DocPerformanceReportInVO docPerformanceReportInVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<DocPerformanceReportInVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				Map<String, String> mapVO = docPerformanceReportInVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchDPCSTurnTimeList1RSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, DocPerformanceReportInVO.class);

			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}

		 /**
		 * SR Data의 처리 부문별 담당자의 처리 Error 실적 현황을 조회(ESM_BKG_0409).
		 * @param SearchDPCSPfmcErrorListVO vo
		 * @return List<SearchDPCSPfmcErrorListVO>
		 * @exception  DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<SearchDPCSPfmcErrorListVO> searchDPCSPfmcErrorList(SearchDPCSPfmcErrorListVO vo) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchDPCSPfmcErrorListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
		
			try{
				String[] doc_part = vo.getDocPart().split(",");
				 
				 for (int i = 0; i< doc_part.length; i++){
					 if(doc_part[i].equals("E")){
						 vo.setDocPartEu("Y");
					 }else if(doc_part[i].equals("J")){
						 vo.setDocPartJp("Y");
					 }else if(doc_part[i].equals("S")){
						 vo.setDocPartSw("Y");
					 }else{
						 vo.setDocPart("Y");
					 }
				 }
				
				Map<String, String> mapVO = vo .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchDPCSPfmcErrorListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchDPCSPfmcErrorListVO.class);
			
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}  
		
		 /**
		 * TRO 현황 조회 화면(ESM_BKG_0620).
		 * 
		 * @param TroStatusListInVO vo
		 * @return List<TroStatusListInVO>
		 * @exception  DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<TroStatusListInVO> searchTroStatusList(TroStatusListInVO vo) throws DAOException {
			DBRowSet dbRowset = null;
			List<TroStatusListInVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
		
			try{
				Map<String, String> mapVO = vo .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOTroStatusListInVORSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, TroStatusListInVO.class);
			
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		} 
		 /**
		 * e-Booking & S/I 업로드 실적 조회 기능(ESM_BKG_0226)<br>
		 * 1.Report Type이 Pending Report <br>
		 * 
		 * @param EBkgSiUploadStsReportInVO vo
		 * @return List<EBkgSiUploadStsReportInVO>
		 * @exception  DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<EBkgSiUploadStsReportInVO> searchEBkgSiUploadStsListByPending(EBkgSiUploadStsReportInVO vo) throws DAOException {
			DBRowSet dbRowset = null;
			List<EBkgSiUploadStsReportInVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
		
			try{
				Map<String, String> mapVO = vo .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchEBkgSiUploadStsListByPendingRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, EBkgSiUploadStsReportInVO.class);
			
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}  
		 /**
		 * e-Booking & S/I 업로드 실적 조회 기능(ESM_BKG_0226).<br>
		 * 2.Report Type이 Delay Report <br>
		 * 
		 * @param EBkgSiUploadStsReportInVO vo
		 * @return List<EBkgSiUploadStsReportInVO>
		 * @exception  DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<EBkgSiUploadStsReportInVO> searchEBkgSiUploadStsListByDealy(EBkgSiUploadStsReportInVO vo) throws DAOException {
			DBRowSet dbRowset = null;
			List<EBkgSiUploadStsReportInVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
		
			try{
				if (!JSPUtil.getNull(vo.getBkgUpldStsCd()).equals("")) {
					vo.setBkgUpldStsCd("'" + vo.getBkgUpldStsCd().replaceAll(",", "','") + "'");
				}
				
				Map<String, String> mapVO = vo .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchEBkgSiUploadStsListByDealyRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, EBkgSiUploadStsReportInVO.class);
			
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}  
		 /**
		 * e-Booking & S/I 업로드 실적 조회 기능(ESM_BKG_0226).<br>
		 * 3.Report Type이 Detail Report<br>
		 * 
		 * @param EBkgSiUploadStsReportInVO vo
		 * @return List<EBkgSiUploadStsReportInVO>
		 * @exception  DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<EBkgSiUploadStsReportInVO> searchEBkgSiUploadStsListByDetail(EBkgSiUploadStsReportInVO vo) throws DAOException {
			DBRowSet dbRowset = null;
			List<EBkgSiUploadStsReportInVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
		
			try{
				if (!JSPUtil.getNull(vo.getBkgUpldStsCd()).equals("")) {
					vo.setBkgUpldStsCd("'" + vo.getBkgUpldStsCd().replaceAll(",", "','") + "'");
				}
				
				Map<String, String> mapVO = vo .getColumnValues();
				
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchEBkgSiUploadStsListByDetailRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, EBkgSiUploadStsReportInVO.class);
			
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}  
		 
		 /**
		 * e-Booking & S/I 실적 조회 기능(ESM_BKG_0227)<br>
		 * 1.Report Type이 BookingOffice Report <br>
		 * 
		 * @param EBkgSiPfmcInVO vo
		 * @return List<EBkgSiPfmcInVO>
		 * @exception  DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<EBkgSiPfmcInVO> searchEBkgSiPfmcListByBkgOfc(EBkgSiPfmcInVO vo) throws DAOException {
			DBRowSet dbRowset = null;
			List<EBkgSiPfmcInVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
		
			try{
				Map<String, String> mapVO = vo .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOsearchEBkgSiPfmcListByBkgOfcRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, EBkgSiPfmcInVO.class);
			
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}  
		 /**
		 * e-Booking & S/I 실적 조회 기능(ESM_BKG_0227)<br>
		 * 2.Report Type이 SalesOffice Report <br>
		 * 
		 * @param EBkgSiPfmcInVO vo
		 * @return List<EBkgSiPfmcInVO>
		 * @exception  DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<EBkgSiPfmcInVO> searchEBkgSiPfmcListBySalOfc(EBkgSiPfmcInVO vo) throws DAOException {
			DBRowSet dbRowset = null;
			List<EBkgSiPfmcInVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
		
			try{
				Map<String, String> mapVO = vo .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOsearchEBkgSiPfmcListBySalOfcRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, EBkgSiPfmcInVO.class);
			
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}  
		 /**
		 * e-Booking & S/I 실적 조회 기능(ESM_BKG_0227)<br>
		 * 3.Report Type이 Shipper Report<br>
		 * 
		 * @param EBkgSiPfmcInVO vo
		 * @return List<EBkgSiPfmcInVO>
		 * @exception  DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<EBkgSiPfmcInVO> searchEBkgSiPfmcListByShipper(EBkgSiPfmcInVO vo) throws DAOException {
			DBRowSet dbRowset = null;
			List<EBkgSiPfmcInVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
		
			try{
				Map<String, String> mapVO = vo .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOsearchEBkgSiPfmcListByShipperRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, EBkgSiPfmcInVO.class);
			
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}   
		 /**
		 * e-Booking & S/I 실적 조회 기능(ESM_BKG_0227)<br>
		 * 4.Report Type이 Detail Report<br>
		 * 
		 * @param EBkgSiPfmcInVO vo
		 * @return List<EBkgSiPfmcInVO>
		 * @exception  DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<EBkgSiPfmcInVO> searchEBkgSiPfmcListByDetail(EBkgSiPfmcInVO vo) throws DAOException {
			DBRowSet dbRowset = null;
			List<EBkgSiPfmcInVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
		
			try{
				Map<String, String> mapVO = vo .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOsearchEBkgSiPfmcListByDetailRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, EBkgSiPfmcInVO.class);
			
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		} 
		 /**
		 * Port Closing Inquiry(ESM_BKG_0914)<br>
		 * 1.Office List -PCT (Port Closing Time) 현황 조회 화면<br>
		 * 
		 * @param PortCloseOfficeListVO vo
		 * @return List<PortCloseOfficeListVO>
		 * @exception  DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<PortCloseOfficeListVO> searchPctlOfficeList(PortCloseOfficeListVO vo) throws DAOException {
			DBRowSet dbRowset = null;
			List<PortCloseOfficeListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
		
			try{
				Map<String, String> mapVO = vo .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchPctlOfficeListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortCloseOfficeListVO.class);
			
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}  
		 /**
		 * Port Closing Inquiry(ESM_BKG_0914)<br>
		 * 2.B/L List -PCT (Port Closing Time) 현황 조회 화면<br>
		 * 
		 * @param PortCloseBLlistVO vo
		 * @return List<PortCloseBLlistVO>
		 * @exception  DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<PortCloseBLlistVO> searchPctlBLList(PortCloseBLlistVO vo) throws DAOException {
			DBRowSet dbRowset = null;
			List<PortCloseBLlistVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
		
			try{
				Map<String, String> mapVO = vo .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchPctlBLListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortCloseBLlistVO.class);
			
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}  
		 /**
		 * Port Closing Inquiry(ESM_BKG_0914)<br>
		 * 3.Office List Summary -PCT (Port Closing Time) 현황 조회 화면<br>
		 * 
		 * @param PortCloseOfficeListVO vo
		 * @return List<PortCloseOfficeListVO>
		 * @exception  DAOException
		 */
		public List<PortCloseOfficeListVO> searchPctlOfficeSummary(PortCloseOfficeListVO vo) throws DAOException {
			DBRowSet dbRowset = null;
			List<PortCloseOfficeListVO> list= null;
			PortCloseOfficeListVO portCloseOfficeListVO = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try{
				Map<String, String> mapVO = vo .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchPctlOfficeSummaryRSQL(), param, velParam);
				
				list = new ArrayList<PortCloseOfficeListVO>();
				while (dbRowset.next()) {
					portCloseOfficeListVO = new PortCloseOfficeListVO();
					portCloseOfficeListVO.setBlType("O");
					portCloseOfficeListVO.setBlTtl(dbRowset.getString("o_bl_ttl"));
					portCloseOfficeListVO.setCneeTtl(dbRowset.getString("o_cnee_ttl"));
					portCloseOfficeListVO.setNtfyTtl(dbRowset.getString("o_ntfy_ttl"));
					list.add(portCloseOfficeListVO);
					
					portCloseOfficeListVO = new PortCloseOfficeListVO();
					portCloseOfficeListVO.setBlType("S");
					portCloseOfficeListVO.setBlTtl(dbRowset.getString("s_bl_ttl"));
					portCloseOfficeListVO.setCneeTtl(dbRowset.getString("s_cnee_ttl"));
					portCloseOfficeListVO.setNtfyTtl(dbRowset.getString("s_ntfy_ttl"));
					list.add(portCloseOfficeListVO);
	            }
				if (list.size() < 1){
					portCloseOfficeListVO = new PortCloseOfficeListVO();
					portCloseOfficeListVO.setBlType("O");
					portCloseOfficeListVO.setBlTtl("0");
					portCloseOfficeListVO.setCneeTtl("0");
					portCloseOfficeListVO.setNtfyTtl("0");
					list.add(portCloseOfficeListVO);
					
					portCloseOfficeListVO = new PortCloseOfficeListVO();
					portCloseOfficeListVO.setBlType("S");
					portCloseOfficeListVO.setBlTtl("0");
					portCloseOfficeListVO.setCneeTtl("0");
					portCloseOfficeListVO.setNtfyTtl("0");
					list.add(portCloseOfficeListVO);
	            }
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}
		
		/**
		  * C/A Detail(s)리스트를 조회합니다<br>
		  * 
		  * @param String blNo
		  * @param String bkgNo
		  * @param String caNo
		  * @return List<BlCaDetailListVO>
		  * @exception  DAOException
		  */
		 @SuppressWarnings("unchecked")
		 public List<BlCaDetailListVO> searchBLCaDetailList(String blNo, String bkgNo, String caNo) throws DAOException {
			 DBRowSet dbRowset = null;
			 List<BlCaDetailListVO> list = null;
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();
		
			 try{
				 param.put("bl_no", blNo);
				 param.put("bkg_no", bkgNo); 
				 param.put("corr_no", caNo);
	        							            
		         velParam.put("bl_no", blNo);
		         velParam.put("bkg_no", bkgNo);
		         velParam.put("corr_no", caNo);
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOBlCaDetailListVORSQL(), param, velParam);
				 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BlCaDetailListVO.class);
			
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			 return list;
		 }
		 
		 /**
		  * C/A Detail(s)에 History 리스트를 조회합니다<br>
		  * 
		  * @param String bkgNo
		  * @param String corrNo
		  * @return List<BlCaDetailListVO>
		  * @exception  DAOException
		  */
		 @SuppressWarnings("unchecked")
		 public List<BlCaDetailListVO> searchBLCaDetailHisList(String bkgNo, String corrNo) throws DAOException {
			 DBRowSet dbRowset = null;
			 List<BlCaDetailListVO> list = null;
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();
		
			 try{
				 param.put("bkg_no", bkgNo);
				 param.put("corr_no", corrNo); 
	        							            
		         velParam.put("bkg_no", bkgNo);
		         velParam.put("corr_no", corrNo);
		         
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOBlCaDetailListVO2RSQL(), param, velParam);
				 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BlCaDetailListVO.class);
			
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			 return list;
		 }
		 
	 /**
	 * Doc Performance Report(ESM_BKG_0214)<br>
	 * 1.Office List -Documentation 실적 산출 기능 조회 화면<br>
	 * 
	 * @param DocPFMCOfcListVO vo
	 * @return List<DocPFMCOfcListVO>
	 * @exception  DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	 public List<DocPFMCOfcListVO> searchDocPFMCOfcList(DocPFMCOfcListVO vo) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<DocPFMCOfcListVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		
		 try{
			Map<String, String> mapVO = vo .getColumnValues();
			

			param.putAll(mapVO);
			velParam.putAll(mapVO); 
			
			if (!vo.getFrDt().equals(""))
			{
				param.put("rep_year", vo.getFrDt().substring(0, 4)); 
		        velParam.put("rep_year", vo.getFrDt().substring(0, 4));
		        
		        if(!vo.getFrDt().substring(0, 4).equals("2012") && vo.getClassType().equals("10")){
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchCneeAccuracyOfcListRSQL(), param, velParam);
				} else if(!vo.getFrDt().substring(0, 4).equals("2012") && vo.getClassType().equals("9")){
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchDocPFMCPreAuditOfcListRSQL(), param, velParam);
				} else {
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchDocPFMCOfcListRSQL(), param, velParam);
				}
			}else{
				if(vo.getClassType().equals("10")){
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchCneeAccuracyOfcListRSQL(), param, velParam);
				} else if(vo.getClassType().equals("9")){
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchDocPFMCPreAuditOfcListRSQL(), param, velParam);
				} else {
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchDocPFMCOfcListRSQL(), param, velParam);
				}
			}       
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DocPFMCOfcListVO.class);
		
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}  
	 /**
	 * Doc Performance Report(ESM_BKG_0214)<br>
	 * 2.B/L List -Documentation 실적 산출 기능 조회 화면<br>
	 * 
	 * @param DocPFMCBLListVO vo
	 * @return List<DocPFMCBLListVO>
	 * @exception  DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<DocPFMCBLListVO> searchDocPFMCBLList(DocPFMCBLListVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<DocPFMCBLListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			Map<String, String> mapVO = vo .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			if (!vo.getFrDt().equals("")){
				if(!vo.getFrDt().substring(0, 4).equals("2012") && vo.getClassType().equals("10")){
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchCneeAccuracyBLListRSQL(), param, velParam);
				} else if(!vo.getFrDt().substring(0, 4).equals("2012") && vo.getClassType().equals("9")){
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchDocPFMCPreAuditBLListRSQL(), param, velParam);
				} else {
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchDocPFMCBLListRSQL(), param, velParam);
				}
			}else{
				if(vo.getClassType().equals("10")){
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchCneeAccuracyBLListRSQL(), param, velParam);
				} else if(vo.getClassType().equals("9")){
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchDocPFMCPreAuditBLListRSQL(), param, velParam);
				} else {
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchDocPFMCBLListRSQL(), param, velParam);
				}
			}
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DocPFMCBLListVO.class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
	 /**
	 * User Group Id 조회합니다.<br>
	 * @param String usrId
	 * @return List<DocQueueListOutVO>
	 * @exception  DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchUserGroupIdVO> searchUserGroupId(String usrId) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchUserGroupIdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			 param.put("usr_id", usrId);
	         velParam.put("usr_id", usrId);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchUserGroupIdRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchUserGroupIdVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}
	 
	 /**
     * Work Group별 PIC 목록조회<br>
     * 
     * @param String wrkGrpCd
     * @return List<BkgComboVO>
	 * @exception  DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BkgComboVO> searchSZPBBPicCombo(String wrkGrpCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgComboVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			 param.put("wrk_grp_cd", wrkGrpCd);
	         velParam.put("usr_id", wrkGrpCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchSZPBBPicComboRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgComboVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}
	/**
	 * 0421 Queue List  정보를 조회합니다.<br>
	 * @param DocQueueListInVO docQueueListInVO
	 * @return List<DocQueueListOutVO>
	 * @exception  DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DocQueueListOutVO> searchQueueList(DocQueueListInVO docQueueListInVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DocQueueListOutVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//@ 조건문 In절 처리
		if(docQueueListInVO.getReturnTo() != null && !"".equals(docQueueListInVO.getReturnTo())){
			docQueueListInVO.setReturnTo("'" + docQueueListInVO.getReturnTo().replaceAll(",", "','") + "'" );
		}
		try{
			
			Map<String, String> mapVO = docQueueListInVO .getColumnValues();
			//region
			mapVO.put("region_a",0<=docQueueListInVO.getRegion().indexOf("A")?"Y":"N");
			mapVO.put("region_e",0<=docQueueListInVO.getRegion().indexOf("E")?"Y":"N");
			mapVO.put("region_j",0<=docQueueListInVO.getRegion().indexOf("J")?"Y":"N");
			mapVO.put("region_s",0<=docQueueListInVO.getRegion().indexOf("S")?"Y":"N");
			mapVO.put("region_o",0<=docQueueListInVO.getRegion().indexOf("O")?"Y":"N");
			mapVO.put("region_u",0<=docQueueListInVO.getRegion().indexOf("U")?"Y":"N");
			mapVO.put("region_k",0<=docQueueListInVO.getRegion().indexOf("K")?"Y":"N");
			mapVO.put("region_n",0<=docQueueListInVO.getRegion().indexOf("N")?"Y":"N");
			
			param.putAll(mapVO);
			velParam.putAll(mapVO); 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchQueueListRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DocQueueListOutVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	 
	/**
	 * 0437 Queue List  정보를 조회합니다.<br>
	 * @param DocQueueListInVO docQueueListInVO
	 * @return List<DocQueueListOutVO>
	 * @exception  DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DocQueueListOutVO> searchSZPBBQueueList(DocQueueListInVO docQueueListInVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DocQueueListOutVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			
			Map<String, String> mapVO = docQueueListInVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchSZPBBQueueListRSQL(),param, velParam, true);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DocQueueListOutVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

		 /**
		  * 0422 Queue Detail 상단 메타  정보를 조회합니다.<br>
		  * @param String userPartCd
		  * @param String bkgNo
		  * @param String srNo
		  * @param String userId
		  * @param String srKind
		  * @param String srKndCd
		  * @return List<DocQueueDetailListVO>
		  * @exception  DAOException
		  */
		 @SuppressWarnings("unchecked")
		 public List<DocQueueDetailListVO> searchQueueDetailList(String userPartCd, String bkgNo, String srNo, String userId, String srKind, String srKndCd) throws DAOException {
			 DBRowSet dbRowset = null;
			 List<DocQueueDetailListVO> list = null;
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();
			 
			 try{
				 param.put("user_part_cd", userPartCd);
				 param.put("bkg_no", bkgNo);
				 param.put("sr_no", srNo);
				 param.put("user_id", userId);
				 param.put("sr_kind", srKind);
				 param.put("sr_knd_cd", srKndCd);
				 
				 velParam.put("user_part_cd", userPartCd);
				 velParam.put("bkg_no", bkgNo);
				 velParam.put("sr_no", srNo);
				 velParam.put("user_id", userId);
				 velParam.put("sr_kind", srKind);
				 velParam.put("sr_knd_cd", srKndCd);
		         
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchQueueDetailList1RSQL(),param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, DocQueueDetailListVO.class);
			 } catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			 
			 return list;
		 } 	
		 
		 /**
		  * 0422 Queue Detail complete flg 정보를 조회합니다.<br>
		  * @param String bkgNo
		  * @return String
		  * @exception  DAOException
		  */
		 public String searchQueueDetailList4(String bkgNo) throws DAOException {
			 DBRowSet dbRowset = null;
			 StringBuffer completeFlg = new StringBuffer();
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();
			 
			 try{
				 param.put("bkg_no", bkgNo);
				 
				 velParam.put("bkg_no", bkgNo);
		         
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchQueueDetailList4RSQL(),param, velParam);
				
				if (dbRowset.first()){
					if (dbRowset.getString(2).equals("") || dbRowset.getString(2).equals("0")){
						
						completeFlg.append("N");
					}else{
						
						completeFlg.append("Y");
					}
					
					completeFlg.append(",");
					
					if (dbRowset.getString(1).equals("") || dbRowset.getString(1).equals("0")){
						
						completeFlg.append("N");
					}else{
						
						completeFlg.append("Y");
					}
				}
				
			 } catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			 
			 return completeFlg.toString();
		 } 	 
		 
		 /**
		  * 0437 Queue Detail complete flg 정보를 조회합니다.<br>
		  * @param String bkgNo
		  * @return String
		  * @exception  DAOException
		  */
		 public String searchSZPBBQueueDetailList4(String bkgNo) throws DAOException {
			 DBRowSet dbRowset = null;
			 StringBuffer completeFlg = new StringBuffer();
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();
			 
			 try{
				 param.put("bkg_no", bkgNo);
				 
				 velParam.put("bkg_no", bkgNo);
		         
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchSZPBBQueueDetailList4RSQL(),param, velParam);
				
				if (dbRowset.first()){
					if (!dbRowset.getString(2).equals("") && dbRowset.getString(2).equals("5")){
						
						completeFlg.append("Y");
					}else{
						
						completeFlg.append("N");
					}
					
					completeFlg.append(",");
					
					if (dbRowset.getString(1).equals("") || dbRowset.getString(1).equals("0")){
						
						completeFlg.append("N");
					}else{
						
						completeFlg.append("Y");
					}
				}
				
			 } catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			 
			 return completeFlg.toString();
		 } 	 
		 
		 /**
		  * 0422 Queue Detail List 정보를 조회합니다.<br>
		  * @param docQueueDetailListVO DocQueueDetailListVO 
		  * @return List<DocQueueDetailListVO>
		  * @exception  DAOException
		  */
		 @SuppressWarnings("unchecked")
		 public List<DocQueueDetailListVO> searchQueueDetailList(DocQueueDetailListVO docQueueDetailListVO) throws DAOException {
			 DBRowSet dbRowset = null;
			 List<DocQueueDetailListVO> list = null;
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();
			 
			 try{
				 Map<String, String> mapVO = docQueueDetailListVO.getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
				 
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchQueueDetailList2RSQL(),param, velParam);
				 list = (List)RowSetUtil.rowSetToVOs(dbRowset, DocQueueDetailListVO.class);
			 } catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			 
			 return list;
		 } 	 
		 
		 
		 /**
		  * 0422 Queue Detail List 에 Go To BKG(e-booking:ESM_BKG_0229) 에 필요한 정보를 조회합니다.<br>
		  * @param String bkgNo 
		  * @return String
		  * @exception  DAOException
		  */
		 public String searchRqstInfo(String bkgNo) throws DAOException {
			 DBRowSet dbRowset = null;

			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();
			 
			 StringBuffer rqstInfo = new StringBuffer();
			 
			 try{
				 param.put("bkg_no", bkgNo);
			   							            
			     velParam.put("bkg_no", bkgNo);
				 
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchQueueDetailList3RSQL(),param, velParam);
				 
				 if (dbRowset.first()){
					 
					 rqstInfo.append(dbRowset.getString(1)); 
					 rqstInfo.append(",");
					 rqstInfo.append(dbRowset.getString(2)); 
					 rqstInfo.append(",");
					 rqstInfo.append(dbRowset.getString(3)); 
				 }
				 
			 } catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			 
			 return rqstInfo.toString();
		 } 	 
	 
	 /**
	 * C/A Performance Report (ESM_BKG_0110)를 조회합니다.<br>
	 * 
	 * @param CaPerformanceReportInVO vo
	 * @return List<CaPerformanceReportOutVO>
	 * @exception  DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CaPerformanceReportOutVO> searchCAPerformanceReport(CaPerformanceReportInVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<CaPerformanceReportOutVO> list = null;
		//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();
	
	try{
		vo.setChoFromDt(vo.getChoFromDt().replaceAll("-", ""));
		vo.setChoToDt(vo.getChoToDt().replaceAll("-",""));
		
		vo.setBlObrdFromDt(vo.getBlObrdFromDt().replaceAll("-", ""));
		vo.setBlObrdToDt(vo.getBlObrdToDt().replaceAll("-", ""));
		
		// >>>>>>>>>>>>>>> REASON SQL SETTING START <<<<<<<<<<<<<<<
		String[] temp = vo.getReaVal().split(",");
		
		String reaSql = "";
		
		if (!vo.getReaVal().equals("")){
			
			for (int i = 0 ; i < temp.length ; i++){
				
//				if (i == 0){
//					
//					reaSql = "AND ( CA_RSN_CD = '" + temp[i] + "'";
//				}else{
//					
//					reaSql = reaSql + " OR CA_RSN_CD = '" + temp[i] + "'"; 
//				}
//				
//				if (i == temp.length-1){
//					
//					reaSql = reaSql + " )";
//				}
				
				if (i == 0){
					
					if (temp[i].equals("M")){
						
						reaSql = "AND ( COR.CA_RSN_CD = '" + temp[i] + "' OR COR.CA_RSN_CD = 'O' ";
					}else if (temp[i].equals("C")){
						
						reaSql = "AND ( COR.CA_RSN_CD = '" + temp[i] + "' OR COR.CA_RSN_CD = 'H' ";
					}else{
						
						reaSql = "AND ( COR.CA_RSN_CD = '" + temp[i] + "'";
					}
				}else{
					
					if (temp[i].equals("M")){
						
						reaSql = reaSql + " OR COR.CA_RSN_CD = '" + temp[i] + "' OR COR.CA_RSN_CD = 'O' ";
					}else if (temp[i].equals("C")){
						
						reaSql = reaSql + " OR COR.CA_RSN_CD = '" + temp[i] + "' OR COR.CA_RSN_CD = 'H' ";
					}else{
					
						reaSql = reaSql + " OR COR.CA_RSN_CD = '" + temp[i] + "'";
					}
				}
				
				if (i == temp.length-1){
					
					reaSql = reaSql + " )";
				}
			}
			
			vo.setReaVal(reaSql);
		}
		// >>>>>>>>>>>>>>>>>> REASON SQL SETTING END <<<<<<<<<<<<<<
		
		// >>>>>>>>>>>>>>>>>> KIND SQL SETTING START <<<<<<<<<<<<<<
		temp = vo.getCaKnd().split(",");
		
		String kndSql = "";
		
		if (!vo.getCaKnd().equals("")){
			
			for (int i = 0 ; i < temp.length ; i++){
				
				if (i == 0){
					
					kndSql = "AND ( ";
				}else{
					
					kndSql = kndSql + " OR ";
				}
				
//				if (temp[i].equals("A")){
//					
//					kndSql = kndSql + " RT_CA_KNT > 0 ";
//				}else if (temp[i].equals("B")){
//					
//					kndSql = kndSql + " FRT_TERM_CA_KNT > 0 ";
//				}else if (temp[i].equals("C")){
//					
//					kndSql = kndSql + " TERM_CA_KNT > 0 ";
//				}else if (temp[i].equals("D")){
//					
//					kndSql = kndSql + " ROUT_CA_KNT > 0 ";
//				}else if (temp[i].equals("E")){
//					
//					kndSql = kndSql + " CUST_CA_KNT > 0 ";
//				}else if (temp[i].equals("F")){
//					
//					kndSql = kndSql + " QTY_CA_KNT > 0 ";
//				}else if (temp[i].equals("G")){
//					
//					kndSql = kndSql + " MEAS_QTY_CA_KNT > 0 ";
//				}else if (temp[i].equals("H")){
//					
//					kndSql = kndSql + " CMDT_CA_KNT > 0 ";
//				}else if (temp[i].equals("I")){
//					
//					kndSql = kndSql + " TRNK_VSL_CA_KNT > 0 ";
//				}else if (temp[i].equals("J")){
//					
//					kndSql = kndSql + " PRPST_VSL_CA_KNT > 0 ";
//				}else if (temp[i].equals("K")){
//					
//					kndSql = kndSql + " CA_OTR_RSN_KNT > 0 ";
//				}
				
				if (temp[i].equals("A")){
					
					kndSql = kndSql + " COR.RT_CORR_FLG = 'Y' ";
				}else if (temp[i].equals("B")){
					
					kndSql = kndSql + " COR.CHG_TERM_CORR_FLG = 'Y' ";
				}else if (temp[i].equals("C")){
					
					kndSql = kndSql + " COR.RCVDE_TERM_CORR_FLG = 'Y' ";
				}else if (temp[i].equals("D")){
					
					kndSql = kndSql + " COR.ROUT_CORR_FLG = 'Y' ";
				}else if (temp[i].equals("E")){
					
					kndSql = kndSql + " COR.CUST_CORR_FLG = 'Y' ";
				}else if (temp[i].equals("F")){
					
					kndSql = kndSql + " COR.QTY_CORR_FLG = 'Y' ";
				}else if (temp[i].equals("G")){
					
					kndSql = kndSql + " COR.MEAS_QTY_CORR_FLG = 'Y' ";
				}else if (temp[i].equals("H")){
					
					kndSql = kndSql + " COR.CMDT_CORR_FLG = 'Y' ";
				}else if (temp[i].equals("I")){
					
					kndSql = kndSql + " COR.TRNK_VSL_CORR_FLG = 'Y' ";
				}else if (temp[i].equals("J")){
					
					kndSql = kndSql + " COR.PRPST_VSL_CORR_FLG = 'Y' ";
				}else if (temp[i].equals("K")){
					
					kndSql = kndSql + " COR.CA_OTR_RSN_CORR_FLG = 'Y' ";
				}
				
				if (i == temp.length-1){
					
					kndSql = kndSql + " )";
				}
			}
			
			vo.setCaKnd(kndSql);
		}
		// >>>>>>>>>>>>>>>>>> KIND SQL SETTING END <<<<<<<<<<<<<<
		
		Map<String, String> mapVO = vo .getColumnValues();
		
		param.putAll(mapVO);
		velParam.putAll(mapVO);
		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOCaPerformanceReportOutVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CaPerformanceReportOutVO.class);
		
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}       
	 /**
	 * Doc Performance Report(ESM_BKG_0631)<br>
	 * 2.B/L List -Documentation 실적 산출 기능 조회 화면<br>
	 * 
	 * @param String fromDt
	 * @param String toDt
	 * @return List<RbcvesselVO>
	 * @exception  DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RbcvesselVO> searchRBCVesselList(String fromDt, String toDt) throws DAOException {
		DBRowSet dbRowset = null;
		List<RbcvesselVO> list = null;
		//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();
	
	try{
		param.put("from_dt", fromDt);
    	param.put("to_dt", toDt); 
   							            
        velParam.put("fromDt", fromDt);
        velParam.put("toDt", toDt);

		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAORbcvesselVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RbcvesselVO.class);
		
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	} 
	 
	 /**
	 * Sales Performance Report 실적 조회 기능(ESM_BKG_0632)<br>
	 * 
	 * @param SaelsPerformanceReportInVO vo
	 * @return List<SaelsPerformanceReportOutVO>
	 * @exception  DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SaelsPerformanceReportOutVO> searchSalesPerformanceReport(SaelsPerformanceReportInVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SaelsPerformanceReportOutVO> list = null;
		List<SaelsPerformanceReportOutVO> list2 = null;
		List<SaelsPerformanceReportOutVO> list3 = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			// >>>>>>>>>>>>>>>>>> VVD SETTING START <<<<<<<<<<<<<<<<<<<<<<
			StringBuffer sqlVVD = new StringBuffer();
			
			sqlVVD.append(" AND ( ");
			
			String[] tempVVD = vo.getVvd().split(",");
			
			for (int i = 0 ; i < tempVVD.length ; i++){
				
				if (i == 0){
					
					//newVVD += "BKG.VSL_CD = '" + tempVVD[i].substring(0, 4) + "' AND BKG.SKD_VOY_NO = '" + tempVVD[i].substring(4, 8) + "' AND BKG.SKD_DIR_CD = '" + tempVVD[i].substring(8) + "' \n";
					
					sqlVVD.append("BKG.VSL_CD = '");
					sqlVVD.append(tempVVD[i].substring(0, 4));
					sqlVVD.append("' AND BKG.SKD_VOY_NO = '");
					sqlVVD.append(tempVVD[i].substring(4, 8));
					sqlVVD.append("' AND BKG.SKD_DIR_CD = '");
					sqlVVD.append(tempVVD[i].substring(8));
					sqlVVD.append("' \n");
					
				}else{
															
					sqlVVD.append(" OR BKG.VSL_CD = '");
					sqlVVD.append(tempVVD[i].substring(0, 4));
					sqlVVD.append("' AND BKG.SKD_VOY_NO = '");
					sqlVVD.append(tempVVD[i].substring(4, 8));
					sqlVVD.append("' AND BKG.SKD_DIR_CD = '");
					sqlVVD.append(tempVVD[i].substring(8));
					sqlVVD.append("' \n");
				}
			}
			
			sqlVVD.append(" )");
			
			vo.setVvd(sqlVVD.toString());
			// >>>>>>>>>>>>>>>>>> VVD SETTING END <<<<<<<<<<<<<<<<<<<<<<
			log.debug("group by >>>>>>>>>>>>>>>>>>>>>> " + vo.getGrpBy());
			// >>>>>>>>>>>>>>>>>> GROUP BY SETTING START <<<<<<<<<<<<<<<
			
			StringBuffer sqlGrpBy = new StringBuffer();
			
			String[] tempGrpBy = vo.getGrpBy().split(","); 
			
			for (int i = 0 ; i < tempGrpBy.length ; i++){
				
				if (tempGrpBy[i].equals("POD")){
					
					//POD
					sqlGrpBy.append(",BKG.POD_CD \n");
				}else if (tempGrpBy[i].equals("Dest Country")){
					
					//DEST COUNTRY
					sqlGrpBy.append(",SUBSTR(BKG.DEL_CD,0,2) \n");
				}else if (tempGrpBy[i].equals("POL vs POD")){
					
					//POL VS POD
					sqlGrpBy.append(",BKG.POL_CD \n");
					sqlGrpBy.append(",BKG.POD_CD \n");
				}else if (tempGrpBy[i].equals("POL vs Dest Country")){
					
					//POL VS DEST COUNTRY
					sqlGrpBy.append(",BKG.POL_CD \n");
					sqlGrpBy.append(",SUBSTR(BKG.DEL_CD,0,2) \n");
				}else if (tempGrpBy[i].equals("POL")){
					
					//POL
					sqlGrpBy.append(",BKG.POL_CD \n");
				}else if (tempGrpBy[i].equals("POR Country")){
					
					//POR COUNTRY
					sqlGrpBy.append(",SUBSTR(BKG.POR_CD,0,2) \n");
				}else if (tempGrpBy[i].equals("POR Country vs POD")){
					
					//POR COUNTRY VS POD
					sqlGrpBy.append(",SUBSTR(BKG.POR_CD,0,2) \n");
					sqlGrpBy.append(",BKG.POD_CD \n");
				}else if (tempGrpBy[i].equals("POR Country vs Dest. Country")){
					
					//POR COUNTRY VS DEST COUNTRY
					sqlGrpBy.append(",SUBSTR(BKG.POR_CD,0,2) \n");
					sqlGrpBy.append(",SUBSTR(BKG.DEL_CD,0,2) \n");
				//}else if (tempGrpBy[i].equals("By POL vs ORG Mode")){
					
					//BY POL VS ORIGIN MODE
				//}else if (tempGrpBy[i].equals("By POD vs DST Mode")){
					
					//BY POL VS DEST MODE
				//}else if (tempGrpBy[i].equals("Not Applicable")){
					
					//NOT APPLICABLE
				}
			}
			
			vo.setGrpCon(sqlGrpBy.toString());
			// >>>>>>>>>>>>>>>>>> GROUP BY SETTING END <<<<<<<<<<<<<<<
			log.debug(" special  >>>>>>>>>>>>> " + vo.getDcgoFlg());
			Map<String, String> mapVO = vo .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			if (vo.getRepKnd().equals("G")){
				
				if (!vo.getOpFrom().equals("") && !vo.getOpTo().equals("")){
					
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSaelsPerformanceReportGeneral2RSQL(), param, velParam);
					
					list2 = (List)RowSetUtil.rowSetToVOs(dbRowset, SaelsPerformanceReportOutVO.class);
					
					list  = (List)RowSetUtil.rowSetToVOs(dbRowset, SaelsPerformanceReportOutVO.class);
					list.clear();
					
					for (int i = 0 ; i < list2.size() ; i++){
						
						sqlVVD.delete(0, sqlVVD.length());
						
						sqlVVD.append(" AND ( ");
				
						sqlVVD.append("BKG.VSL_CD = '");
						sqlVVD.append(list2.get(i).getVvd().substring(0, 4));
						sqlVVD.append("' AND BKG.SKD_VOY_NO = '");
						sqlVVD.append(list2.get(i).getVvd().substring(4, 8));
						sqlVVD.append("' AND BKG.SKD_DIR_CD = '");
						sqlVVD.append(list2.get(i).getVvd().substring(8));
						sqlVVD.append("' \n");
							
						sqlVVD.append(" )");
						
						vo.setVvd(sqlVVD.toString());
						
						mapVO = vo.getColumnValues();
						
						param.putAll(mapVO);
						velParam.putAll(mapVO);
						
						dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSaelsPerformanceReportGeneralRSQL(), param, velParam);
						
						list3 = (List)RowSetUtil.rowSetToVOs(dbRowset, SaelsPerformanceReportOutVO.class);						
						
						for (int j = 0 ; j < list3.size() ; j++){
							
							if (i == Integer.parseInt(vo.getOpFrom())-1 || i < Integer.parseInt(vo.getOpTo())){
								
								list.add(list3.get(j));
							}
						}
					}
				}else{
				
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSaelsPerformanceReportGeneralRSQL(), param, velParam);
					
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, SaelsPerformanceReportOutVO.class);
				}
			}else if (vo.getRepKnd().equals("R")){
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSaelsPerformanceReportByRouteRSQL(), param, velParam);
			}else if (vo.getRepKnd().equals("E")){
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSaelsPerformanceReportByEQRSQL(), param, velParam);
			}else if (vo.getRepKnd().equals("O")){
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSaelsPerformanceReportBySalesOfcRSQL(), param, velParam);
			}else if (vo.getRepKnd().equals("C")){
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSaelsPerformanceReportByRepComRSQL(), param, velParam);
			}else if (vo.getRepKnd().equals("M")){
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSaelsPerformanceReportByShipCodeRSQL(), param, velParam);
			}else if (vo.getRepKnd().equals("P")){
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSaelsPerformanceReportByShipGrpRSQL(), param, velParam);
			}else if (vo.getRepKnd().equals("S")){
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSaelsPerformanceReportBySalesRepRSQL(), param, velParam);
			}else if (vo.getRepKnd().equals("I")){
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSaelsPerformanceReportByIBContOfcRSQL(), param, velParam);
			}else if (vo.getRepKnd().equals("D")){
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSaelsPerformanceReportByDownLoadRSQL(), param, velParam);
			}
			
			if (!vo.getRepKnd().equals("G")){
				
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SaelsPerformanceReportOutVO.class);
			}
		
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	} 

	 
	 	/**
		 *  0422 Completed 버튼 클릭시 BKG_SR_HIS를 생성합니다.<br>
		 * 
		 * @param DocQueueDetailListVO docQueueDetailListVO
		 * @exception  DAOException
		 */
		public void addQueueDetailList(DocQueueDetailListVO docQueueDetailListVO) throws DAOException,Exception {
			try {
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();	
										
											
				if(docQueueDetailListVO != null ){
					Map<String, String> mapVO = docQueueDetailListVO .getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
					int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOAddQueueDetailListCSQL(), param,velParam);
					                                                    
					if(insCnt == Statement.EXECUTE_FAILED)
								throw new DAOException(new ErrorHandler("COM12240").getMessage());

					
				}
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}
		
		/**
		 *  0421 Delete 버튼 클릭시 BKG_SR_CRNT_RQST 를 수정합니다.<br>
		 * 
		 * @param DocQueueDetailListVO docQueueDetailListVO
		 * @exception  DAOException
		 */
		public void removeDpcsQueueCrnt(DocQueueDetailListVO docQueueDetailListVO) throws DAOException,Exception {
			try {
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();	
				if(docQueueDetailListVO != null ){
					Map<String, String> mapVO = docQueueDetailListVO .getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
					int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAORemoveDpcsQueueCrntUSQL(), param,velParam);
					
					if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException(new ErrorHandler("COM12240").getMessage());
					
				}
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}
		
		/**
		 *  0421 Delete 버튼 클릭시 BKG_SR_CRNT_RQST 를 수정합니다.<br>
		 * 
		 * @param DocQueueDetailListVO docQueueDetailListVO
		 * @exception  DAOException
		 */
		public void addDpcsQueueHistory(DocQueueDetailListVO docQueueDetailListVO) throws DAOException,Exception {
			try {
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();	
				if(docQueueDetailListVO != null ){
					Map<String, String> mapVO = docQueueDetailListVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
					int  insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOAddDpcsQueueHisCSQL(), param,velParam);
					if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException(new ErrorHandler("COM12240").getMessage());
					
				}
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}
		
		
		/**
		 *  0422 Completed 버튼 클릭시 BKG_SR_CRNT_RQST 를 수정합니다.<br>
		 * 
		 * @param DocQueueDetailListVO docQueueDetailListVO
		 * @exception  DAOException
		 */
		public void modifyQueueDetailList(DocQueueDetailListVO docQueueDetailListVO) throws DAOException,Exception {
			try {
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();	
				
				String comFlg = docQueueDetailListVO.getComFlg();
				if (comFlg.equals("inp")){
					docQueueDetailListVO.setSrStsCd("ID");
				}else if (comFlg.equals("rt")){
					docQueueDetailListVO.setSrStsCd("RD");
				}else if (comFlg.equals("qa")){
					docQueueDetailListVO.setSrStsCd("AD");
				}else if (comFlg.equals("cor")){
					docQueueDetailListVO.setSrStsCd("DC");
				}else if (docQueueDetailListVO.getPndFlg().equals("Y")){
					if (docQueueDetailListVO.getSrWrkStsCd().equals("P")){
						docQueueDetailListVO.setSrStsCd("PN");
					}else if (docQueueDetailListVO.getSrWrkStsCd().equals("F")){
						docQueueDetailListVO.setSrStsCd("FP");
					}
				}
				
				if(docQueueDetailListVO != null ){
					Map<String, String> mapVO = docQueueDetailListVO .getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					log.debug(" com flg >>>>>>> " + docQueueDetailListVO.getComFlg());
					SQLExecuter sqlExe = new SQLExecuter("DEFAULT"); 
					int insCnt ;				
					
					/* Irregular case로 정상적으로 unpend가 실행되지 않는 케이스가 발생하여 데이터 보정
					 * Q-List상 Pending Status = 'N'이고, History상 Pending End가 없는 상태에서 Q-Detail Open시
					 * 사용자가 Q-Detail을 Open한 시간을 Pending End로 변경해 준다.*/
					//(new SQLExecuter("")).executeUpdate((ISQLTemplate)new PerformanceReportDBDAOModifyQueueDetailPendingHistoryForIrregularCaseUSQL(), param,velParam);
					
					if  (comFlg.equals("pnx") || (comFlg.equals("end") && docQueueDetailListVO.getPndFlg().equals("Y"))){
						insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOModifyQueueDetailCompletPendingHisUSQL(), param,velParam);
						if(insCnt == Statement.EXECUTE_FAILED)
							throw new DAOException(new ErrorHandler("COM12240").getMessage());
					}else if ((!comFlg.equals("start") && !comFlg.equals("end"))){
						insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOAddQueueDetailCompletAfterHisCSQL(), param,velParam);
						if(insCnt == Statement.EXECUTE_FAILED)
							throw new DAOException(new ErrorHandler("COM12240").getMessage());
						insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOAddQueueDetailIdlingAfterHisUSQL(), param,velParam);
						if(insCnt == Statement.EXECUTE_FAILED)
							throw new DAOException(new ErrorHandler("COM12240").getMessage());
					}
					
					
					insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOModifyQueueDetailList3USQL(), param,velParam);
					if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException(new ErrorHandler("COM12240").getMessage());
					
				}
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}
		
	/**
	 * ESM_BKG_0437 : Queue List 에 Input/Rate PIC 정보를 수정한다<br>
	 * 
	 * @param DocQueueListOutVO vo
	 * @param SignOnUserAccount account
	 * @exception  DAOException
	*/
		public void modifySZPBBPicUserId(DocQueueListOutVO vo, SignOnUserAccount account) throws DAOException,Exception {
			try {
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();	
								
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			 	param.put("usr_id", account.getUsr_id());

				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				int updCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOModifySZPBBPicUserIdUSQL(), param,velParam);
				
				if(updCnt == Statement.EXECUTE_FAILED)
					throw new DAOException(new ErrorHandler("COM12240").getMessage());
				
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}
		/**
		 *  0422 Pending 버튼 클릭시 BKG_SR_CRNT_RQST 를 수정합니다.<br>
		 * 
		 * @param DocQueueDetailListVO docQueueDetailListVO
		 * @exception  DAOException
		 */
		public void modifyQueueDetailList2(DocQueueDetailListVO docQueueDetailListVO) throws DAOException,Exception {
			try {
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();	
				
//				docQueueDetailListVO.setUpDt(searchOfcTime(docQueueDetailListVO.getUsrId()));
				
				if(docQueueDetailListVO != null ){
					/*docQueueDetailListVO.setWrkGrpCd("PN");
					docQueueDetailListVO.setSrStsCd("PN");
					*/
					Map<String, String> mapVO = docQueueDetailListVO .getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
					int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOModifyQueueDetailList2USQL(), param,velParam);
					
					if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException(new ErrorHandler("COM12240").getMessage());
					
					insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOAddQueueDetailCompletAfterHisCSQL(), param,velParam);
					if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException(new ErrorHandler("COM12240").getMessage());
					
					insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOAddQueueDetailIdlingAfterHisUSQL(), param,velParam);
					if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException(new ErrorHandler("COM12240").getMessage());
					
				}
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}
		/**
		 *  0985 Return  버튼 클릭시 Return 관련 데이블 데이타를 수정합니다.<br>
		 * 
		 * @param docQueueDetailReturnInVO DocQueueDetailReturnInVO
		 * @exception  DAOException
		 */
		public void modifyQueueDetailReturn(DocQueueDetailReturnInVO docQueueDetailReturnInVO) throws DAOException,Exception {
			try {
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();	
				if(docQueueDetailReturnInVO != null ){
//					docQueueDetailReturnInVO.setUpDt(searchOfcTime(docQueueDetailReturnInVO.getUsrId()));
					Map<String, String> mapVO = docQueueDetailReturnInVO .getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
					int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOModifyQueueDetailReturnUSQL(), param,velParam);
					
					if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException(new ErrorHandler("COM12240").getMessage());
					
					
				}
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}
		/**
		 *  0985 Return  버튼 클릭시 Return 관련 데이블 데이타을 생성합니다.<br>
		 * 
		 * @param docQueueDetailReturnInVO DocQueueDetailReturnInVO
		 * @exception  DAOException
		 */
		public void addQueueDetailReturn(DocQueueDetailReturnInVO docQueueDetailReturnInVO) throws DAOException,Exception {
			try {
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();	
				
				
				if(docQueueDetailReturnInVO != null ){
					//docQueueDetailReturnInVO.setUpDt(searchOfcTime(docQueueDetailReturnInVO.getUsrId()));
					Map<String, String> mapVO = docQueueDetailReturnInVO .getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
					int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOAddQueueDetailReturn1CSQL(), param,velParam);
					
					if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException(new ErrorHandler("COM12240").getMessage());
					
					insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOAddQueueDetailIdlingAfterHisUSQL(), param,velParam);
					if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException(new ErrorHandler("COM12240").getMessage());
					
					insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOAddQueueDetailReturn2CSQL(), param,velParam);
					
					if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException(new ErrorHandler("COM12240").getMessage());
					
					
				}
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}
		
		/**
		 *  0985 Return  버튼 클릭시 Return 관련 데이블 데이타을 생성합니다.<br>
		 * 
		 * @param SearchQueueDetailReturnReasonCdListVO searchQueueDetailReturnReasonCdListVO
		 * @exception  DAOException
		 */
		public void addQueueDetailReturnReason(SearchQueueDetailReturnReasonCdListVO searchQueueDetailReturnReasonCdListVO) throws DAOException,Exception {
			try {
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();	
				
				
				if(searchQueueDetailReturnReasonCdListVO != null ){
					Map<String, String> mapVO = searchQueueDetailReturnReasonCdListVO .getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
					int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOAddQueueDetailReturnRsnCSQL(), param,velParam);
					
					if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException(new ErrorHandler("COM12240").getMessage());
					
				}
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}
		
		/**
		 *  0984 Return to Return  버튼 클릭시 관련 데이블 데이타를 수정합니다.<br>
		 * 
		 * @param docQueueDetailReturnInVO DocQueueDetailReturnInVO
		 * @exception  DAOException
		 */
		public void modifyQueueRtnToRtn(DocQueueDetailReturnInVO docQueueDetailReturnInVO) throws DAOException,Exception {
			try {
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();	
				
				
				if(docQueueDetailReturnInVO != null ){
//					docQueueDetailReturnInVO.setUpDt(searchOfcTime(docQueueDetailReturnInVO.getUsrId()));
					Map<String, String> mapVO = docQueueDetailReturnInVO .getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
					int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOModifyQueueRtnToRtnUSQL(), param,velParam);
					
					if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException(new ErrorHandler("COM12240").getMessage());
					
					
				}
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}
		/**
		 *  0984 Return to Return  버튼 클릭시 관련 데이블 데이타를 생성합니다.<br>
		 * 
		 * @param docQueueDetailReturnInVO DocQueueDetailReturnInVO
		 * @exception  DAOException
		 */
		public void addQueueRtnToRtn(DocQueueDetailReturnInVO docQueueDetailReturnInVO) throws DAOException,Exception {
			try {
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();	
				
				
				if(docQueueDetailReturnInVO != null ){
//					docQueueDetailReturnInVO.setUpDt(searchOfcTime(docQueueDetailReturnInVO.getUsrId()));
					Map<String, String> mapVO = docQueueDetailReturnInVO .getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
					int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOAddQueueRtnToRtnCSQL(), param,velParam);
					
					insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOAddQueueDetailIdlingAfterHisUSQL(), param,velParam);
					if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException(new ErrorHandler("COM12240").getMessage());
					
					if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException(new ErrorHandler("COM12240").getMessage());
					
				}
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}

		 /**
		  * 0424 Open 시 Queue VVD List 정보를 조회합니다.<br>
		  * @param docQueueVvdListVO DocQueueVvdListVO 
		  * @return List<DocQueueVvdListVO>
		  * @exception  DAOException
		  */
		 @SuppressWarnings("unchecked")
		 public List<DocQueueVvdListVO> searchQueueVvdList(DocQueueVvdListVO docQueueVvdListVO) throws DAOException {
			 DBRowSet dbRowset = null;
			 List<DocQueueVvdListVO> list = null;
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();
			 
			 try{
			
				 Map<String, String> mapVO = docQueueVvdListVO.getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
				 
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchQueueVvdListRSQL(),param, velParam);
				 list = (List)RowSetUtil.rowSetToVOs(dbRowset, DocQueueVvdListVO.class);
			 } catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			 
			 return list;
		 }
		 
		 /**
		  * 0424 Queue Report By Pol 정보를 조회합니다.<br>
		  * 
		  * @param DocQueueReportByPolListInVO docQueueReportByPolListInVO 
		  * @return List<DocQueueReportByPolListOutVO>
		  * @exception  DAOException
		  */
		 @SuppressWarnings("unchecked")
		 public List<DocQueueReportByPolListOutVO> searchQueueReportByPol(DocQueueReportByPolListInVO docQueueReportByPolListInVO) throws DAOException {
			 DBRowSet dbRowset = null;
			 List<DocQueueReportByPolListOutVO> list = null;
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();
			 
			 try{
				 
				 String[] doc_part = docQueueReportByPolListInVO.getDocPart().split(",");
				 
				 for (int i = 0; i< doc_part.length; i++){
					 if(doc_part[i].equals("E")){
						 docQueueReportByPolListInVO.setDocPartEu("Y");
					 }else if(doc_part[i].equals("J")){
						 docQueueReportByPolListInVO.setDocPartJp("Y");
					 }else if(doc_part[i].equals("S")){
						 docQueueReportByPolListInVO.setDocPartSw("Y");
					 }else{
						 docQueueReportByPolListInVO.setDocPart("Y");
					 }
				 }
				 Map<String, String> mapVO = docQueueReportByPolListInVO.getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
				 
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchQueueReportByPolRSQL(),param, velParam);
				 list = (List)RowSetUtil.rowSetToVOs(dbRowset, DocQueueReportByPolListOutVO.class);
			 } catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			 
			 return list;
		 } 	
		 
		 /**
		  * 0568 C/A Report 정보를 조회합니다.<br>
		  * 
		  * @param CaIssueDateInVO vo 
		  * @return List<CaIssueDateOutVO>
		  * @exception  DAOException
		  */
		 @SuppressWarnings("unchecked")
		 public List<CaIssueDateOutVO> searchCaIssueDateList(CaIssueDateInVO vo) throws DAOException {

			 DBRowSet dbRowset = null;
			 List<CaIssueDateOutVO> list = null;
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();

			 try{
				 Map<String, String> mapVO = vo.getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
				 
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOCaIssueDateOutVORSQL(),param, velParam);
				 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CaIssueDateOutVO.class);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			 
			 return list;
		 } 	
		 
		 /*
		  * 0568 C/A Report Remark를 수정합니다.<br>
		  * 
		  * @param CaIssueDateInVO vo 
		  * @exception  DAOException
		  */
		 /*
		 public void modifyCaIssueRemark(CaIssueDateInVO vo) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();			
			
			 try{
				 if(vo != null){
						Map<String, String> mapVO = vo.getColumnValues();
					
						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}							
					SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
					int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOCaIssueDateInVOUSQL(), param,velParam);
					
					if(insCnt == Statement.EXECUTE_FAILED)
								throw new DAOException(new ErrorHandler("COM12240").getMessage());

			 } catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		 }
		*/
		 /**
		 * Freight & Charge List by VVD (ESM_BKG_1057)를 조회합니다.<br>
		 * 
		 * @param searchFCLListVO vo
		 * @return List<searchFCLListVO>
		 * @exception  DAOException
		 */
		 @SuppressWarnings("unchecked")
		 public List<SearchFCLListVO> searchFCLList(SearchFCLListVO searchFCLListVO) throws DAOException {
			 DBRowSet dbRowset = null;
			 List<SearchFCLListVO> list = null;
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();

			 try{
				 if(searchFCLListVO != null){
						
					 Map<String, String> mapVO = searchFCLListVO .getColumnValues();
					
					 param.putAll(mapVO);
					 velParam.putAll(mapVO);
				 }
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchFCLListVORSQL(), param, velParam);
				 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchFCLListVO .class);
					
			 } catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			 return list;
		 }
		 
		 /**
		  * 0570 C/A Report_B/L Inquiry >>> Main를 조회합니다.<br>
		  * 
		  * @param blNo
		  * @return List<CaInquiryReportVO>
		  * @exception  DAOException
		  */
		 @SuppressWarnings("unchecked")
		 public List<CaInquiryReportVO> searchCaByBLno(String blNo) throws DAOException {

			 DBRowSet dbRowset = null;
			 List<CaInquiryReportVO> list = null;
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();

			 try{
				 param.put("bl_no", blNo);

		         velParam.put("bl_no", blNo);
				 
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOCaInquiryReportRSQL(),param, velParam);
				 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CaInquiryReportVO.class);
			 } catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			 
			 return list;
		 } 
		 
		 /**
		  * 0570 C/A Report_B/L Inquiry >>> Main를 조회합니다.<br>
		  * 
		  * @param blNo
		  * @param corrNo
		  * @return List<CaInquiryReportVO>
		  * @exception  DAOException
		  */
		 @SuppressWarnings("unchecked")
		 public List<CaInquiryReportVO> searchCaByCustomerInfo(String blNo ,String corrNo) throws DAOException {

			 DBRowSet dbRowset = null;
			 List<CaInquiryReportVO> list = null;
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();

			 try{
				 param.put("bl_no", blNo);
				 param.put("corr_no", corrNo);

		         velParam.put("bl_no", blNo);
		         velParam.put("corr_no", corrNo);
				 
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOCaInquiryReportCustRSQL(),param, velParam);
				 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CaInquiryReportVO.class);
			 } catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			 
			 return list;
		 } 
		 
		 /**
		  * 0570 C/A Report_B/L Inquiry >>> Main를 조회합니다.<br>
		  * 
		  * @param blNo
		  * @param corrNo
		  * @return List<CaInquiryReportVO>
		  * @exception  DAOException
		  */
		 @SuppressWarnings("unchecked")
		 public List<CaInquiryReportVO> searchCaByMarkDescInfo(String blNo ,String corrNo) throws DAOException {

			 DBRowSet dbRowset = null;
			 List<CaInquiryReportVO> list = null;
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();

			 try{
				 param.put("bl_no", blNo);
				 param.put("corr_no", corrNo);

		         velParam.put("bl_no", blNo);
		         velParam.put("corr_no", corrNo);
				 
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOCaInquiryReportMarksRSQL(),param, velParam);
				 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CaInquiryReportVO.class);
			 } catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			 
			 return list;
		 } 
		 
		 /**
		  * 0570 C/A Report_B/L Inquiry >>> Main를 조회합니다.<br>
		  * 
		  * @param blNo
		  * @param corrNo
		  * @return List<CaInquiryReportVO>
		  * @exception  DAOException
		  */
		 @SuppressWarnings("unchecked")
		 public List<CaInquiryReportVO> searchCaByContainerInfo(String blNo, String corrNo) throws DAOException {

			 DBRowSet dbRowset = null;
			 List<CaInquiryReportVO> list = null;
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();
			 try{
				 param.put("bl_no", blNo);
				 param.put("corr_no", corrNo);

		         velParam.put("bl_no", blNo);
		         velParam.put("corr_no", corrNo);
				 
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOCaInquiryReportCntrRSQL(),param, velParam);
				 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CaInquiryReportVO.class);
			 } catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			 
			 return list;
		 } 

		 
		 /**
		  * 0066 B/L Processing Report 정보를 조회합니다.<br>
		  * 
		  * @param docTurnTimeInVO DocTurnTimeInVO 
		  * @return List<DocTurnTimeOutVO>
		  * @exception  DAOException
		  */
		 @SuppressWarnings("unchecked")
		 public List<DocTurnTimeOutVO> searchBlTurnTimeReport(DocTurnTimeInVO docTurnTimeInVO) throws DAOException {
			 DBRowSet dbRowset = null;
			 List<DocTurnTimeOutVO> list = null;
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();
			 try{
				 
				 String[] doc_part = docTurnTimeInVO.getDocPart().split(",");
				 
				 for (int i = 0; i< doc_part.length; i++){
					 if(doc_part[i].equals("E")){
						 docTurnTimeInVO.setDocPartEu("Y");
					 }else if(doc_part[i].equals("J")){
						 docTurnTimeInVO.setDocPartJp("Y");
					 }else if(doc_part[i].equals("S")){
						 docTurnTimeInVO.setDocPartSw("Y");
					 }else{
						 docTurnTimeInVO.setDocPart("Y");
					 }
				 }
				 Map<String, String> mapVO = docTurnTimeInVO.getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
				 
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchBlTurnTimeReportRSQL(),param, velParam);
				 list = (List)RowSetUtil.rowSetToVOs(dbRowset, DocTurnTimeOutVO.class);
			 } catch(SQLException se) {
				 log.error(se.getMessage(),se);
				 throw new DAOException(new ErrorHandler(se).getMessage(), se);
			 } catch(Exception ex) {
				 log.error(ex.getMessage(),ex);
				 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			 }
			 
			 return list;
		 } 			 
		 /**
		  * 0940 I/B DOC Performance Report 정보를 조회합니다.<br>
		  * 
		  * @param inBoundReportInVO InBoundReportInVO 
		  * @return List<DocTurnTimeOutVO>
		  * @exception  DAOException
		  */
		 @SuppressWarnings("unchecked")
		 public List<InBoundReportOutVO> searchInBoundPfmcReport(InBoundReportInVO inBoundReportInVO) throws DAOException {
			 DBRowSet dbRowset = null;
			 List<InBoundReportOutVO> list = null;
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();
			 
			 try{
				 Map<String, String> mapVO = inBoundReportInVO.getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
				 
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchInBoundPfmcReportRSQL(),param, velParam);
				 list = (List)RowSetUtil.rowSetToVOs(dbRowset, InBoundReportOutVO.class);
			 } catch(SQLException se) {
				 log.error(se.getMessage(),se);
				 throw new DAOException(new ErrorHandler(se).getMessage(), se);
			 } catch(Exception ex) {
				 log.error(ex.getMessage(),ex);
				 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			 }
			 
			 return list;
		 } 			 

		 /**
		  * 0274 General Cargo Manifest by VVD/PORT 정보를 조회합니다.<br>
		  * 
		  * @param blCargoManifestInVO BlCargoManifestInVO 
		  * @return List<BlCargoManifestOutVO>
		  * @exception  DAOException
		  */
		 @SuppressWarnings("unchecked")
		 public List<BlCargoManifestOutVO> searchBLCargoManifestList(BlCargoManifestInVO blCargoManifestInVO) throws DAOException {
			 DBRowSet dbRowset = null;
			 List<BlCargoManifestOutVO> list = null;
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();
			 
			 try{
				 Map<String, String> mapVO = blCargoManifestInVO.getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
				 
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchBLCargoManifestListRSQL(),param, velParam);
				 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BlCargoManifestOutVO.class);
			 } catch(SQLException se) {
				 log.error(se.getMessage(),se);
				 throw new DAOException(new ErrorHandler(se).getMessage(), se);
			 } catch(Exception ex) {
				 log.error(ex.getMessage(),ex);
				 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			 }
			 
			 return list;
		}	
		 
		 /**
		  * 0274 General Cargo Manifest by VVD/PORT 정보를 Container단위로 조회합니다.<br>
		  * 
		  * @param blCargoManifestInVO BlCargoManifestInVO 
		  * @return List<BlCntrCargoManifestOutVO>
		  * @exception  DAOException
		  */
		 @SuppressWarnings("unchecked")
		 public List<BlCntrCargoManifestOutVO> searchBLCntrCargoManifestList(BlCargoManifestInVO blCargoManifestInVO) throws DAOException {
			 DBRowSet dbRowset = null;
			 List<BlCntrCargoManifestOutVO> list = null;
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();
			 
			 try{
				 Map<String, String> mapVO = blCargoManifestInVO.getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
				 
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchBLCntrCargoManifestListRSQL(),param, velParam);
				 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BlCntrCargoManifestOutVO.class);
			 } catch(SQLException se) {
				 log.error(se.getMessage(),se);
				 throw new DAOException(new ErrorHandler(se).getMessage(), se);
			 } catch(Exception ex) {
				 log.error(ex.getMessage(),ex);
				 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			 }
			 
			 return list;
		 }		 
		 /**
		  * 0410 Performance Report by Volume 정보를 조회합니다.<br>
		  * 
		  * @param searchDPCSVolListInVO SearchDPCSVolListInVO 
		  * @return List<SearchDPCSVolListOutVO>
		  * @exception  DAOException
		  */
		 @SuppressWarnings("unchecked")
//		 public List<SearchDPCSVolListOutVO> searchDPCSVolList(SearchDPCSVolListInVO searchDPCSVolListInVO) throws DAOException {
//			 DBRowSet dbRowset = null;
//			 List<SearchDPCSVolListOutVO> list = null;
//			 //query parameter
//			 Map<String, Object> param = new HashMap<String, Object>();
//			 //velocity parameter
//			 Map<String, Object> velParam = new HashMap<String, Object>();
//			 
//			 try{
//				 
//				 String[] doc_part = searchDPCSVolListInVO.getDocPart().split(",");
//				 
//				 for (int i = 0; i< doc_part.length; i++){
//					 if(doc_part[i].equals("E")){
//						 searchDPCSVolListInVO.setDocPartEu("Y");
//					 }else if(doc_part[i].equals("J")){
//						 searchDPCSVolListInVO.setDocPartJp("Y");
//					 }else if(doc_part[i].equals("S")){
//						 searchDPCSVolListInVO.setDocPartSw("Y");
//					 }else if(doc_part[i].equals("O")){
//						 searchDPCSVolListInVO.setDocPartOt("Y");
//					 }else{
//						 searchDPCSVolListInVO.setDocPart("Y");
//					 }
//				 }
//				 
//				 
//				 Map<String, String> mapVO = searchDPCSVolListInVO.getColumnValues();
//				 param.putAll(mapVO);
//				 velParam.putAll(mapVO);
//				 
//				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchDPCSVolListRSQL(),param, velParam);
//				 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchDPCSVolListOutVO.class);
//			 } catch(SQLException se) {
//				 log.error(se.getMessage(),se);
//				 throw new DAOException(new ErrorHandler(se).getMessage(), se);
//			 } catch(Exception ex) {
//				 log.error(ex.getMessage(),ex);
//				 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//			 }
//			 
//			 return list;
//		 }		 
		 public List<SearchDpcsPerfByVolListVO> searchDPCSVolList(SearchDPCSVolListInVO searchDPCSVolListInVO) throws DAOException {
			 DBRowSet dbRowset = null;
			 List<SearchDpcsPerfByVolListVO> list = null;
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();
			 
			 try{
				 
				 String[] doc_part = searchDPCSVolListInVO.getDocPart().split(",");
				 
				 for (int i = 0; i< doc_part.length; i++){
					 if(doc_part[i].equals("E")){
						 searchDPCSVolListInVO.setDocPartEu("Y");
					 }else if(doc_part[i].equals("J")){
						 searchDPCSVolListInVO.setDocPartJp("Y");
					 }else if(doc_part[i].equals("S")){
						 searchDPCSVolListInVO.setDocPartSw("Y");
					 }else if(doc_part[i].equals("O")){
						 searchDPCSVolListInVO.setDocPartOt("Y");
					 }else{
						 searchDPCSVolListInVO.setDocPart("Y");
					 }
				 }
				 
				 
				 Map<String, String> mapVO = searchDPCSVolListInVO.getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
				 
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchDPCSVolListRSQL(),param, velParam);
				 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchDpcsPerfByVolListVO.class);
			 } catch(SQLException se) {
				 log.error(se.getMessage(),se);
				 throw new DAOException(new ErrorHandler(se).getMessage(), se);
			 } catch(Exception ex) {
				 log.error(ex.getMessage(),ex);
				 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			 }
			 
			 return list;
		 }		 

	 /**
	  * C/A Summary Report 결과를 조회한다.<br>
	  * 
	  * @param  CaSummaryReportInVO vo
	  * @return List<CaSummaryReportOutVO>
	  * @exception  DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CaSummaryReportOutVO> searchCaSummaryReport(CaSummaryReportInVO vo) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<CaSummaryReportOutVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param    = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 Map<String, String> mapVO = vo.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOCaSummaryReportOutVORSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CaSummaryReportOutVO.class);
			 
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }
		 
		 return list;
	 } 
	 
	 /**
	  * C/A Summary Report BL List 결과를 조회한다.<br>
	  * 
	  * @param  CaSummaryReportInVO vo
	  * @return List<CaSummaryReportOutVO>
	  * @exception  DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CaSummaryReportOutVO> searchCaSummaryReportBLList(CaSummaryReportInVO vo) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<CaSummaryReportOutVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param    = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 Map<String, String> mapVO = vo.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOCaSummaryReportOutVO2RSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CaSummaryReportOutVO.class);
			 
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }
		 
		 return list;
	 } 
	 
	 /**
	  * Vessel Utilization Status vs. Bsa by Lane 에 Trade Code 를 조회합니다.<br>
	  * 
	  * @param  VesselUtilizationStatusReportInVO vo
	  * @return List<VesselUtilizationStatusReportInVO>
	  * @exception  DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<VesselUtilizationStatusReportInVO> searchVesselUtilizationTrade(VesselUtilizationStatusReportInVO vo) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<VesselUtilizationStatusReportInVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param    = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 Map<String, String> mapVO = vo.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchMdmDtlRevLaneTrdCdRSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, VesselUtilizationStatusReportInVO.class);
			 
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }
		 
		 return list;
	 } 
	 
	 /**
	  * Vessel Utilization Status vs. Bsa by Lane 에 Sub Trade Code 를 조회합니다.<br>
	  * 
	  * @param  VesselUtilizationStatusReportInVO vo
	  * @return List<VesselUtilizationStatusReportInVO>
	  * @exception  DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<VesselUtilizationStatusReportInVO> searchVesselUtilizationSubTrade(VesselUtilizationStatusReportInVO vo) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<VesselUtilizationStatusReportInVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param    = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 Map<String, String> mapVO = vo.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchMdmDtlRevLaneSubTrdCdRSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, VesselUtilizationStatusReportInVO.class);
			 
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }
		 
		 return list;
	 } 
	 
	 /**
	  * Vessel Utilization Status vs. Bsa by Lane 에 Bound Code 를 조회합니다.<br>
	  * 
	  * @param  VesselUtilizationStatusReportInVO vo
	  * @return List<VesselUtilizationStatusReportInVO>
	  * @exception  DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<VesselUtilizationStatusReportInVO> searchVesselUtilizationBound(VesselUtilizationStatusReportInVO vo) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<VesselUtilizationStatusReportInVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param    = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 Map<String, String> mapVO = vo.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchMdmDtlRevLaneDirCdRSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, VesselUtilizationStatusReportInVO.class);
			 
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }
		 
		 return list;
	 } 
	 
	 /**
	  * Vessel Utilization Status vs. Bsa by Lane 에 BSA by Lane 리스트를 조회합니다.<br>
	  * 
	  * @param  VesselUtilizationStatusReportInVO vo
	  * @return List<VesselUtilizationStatusReportOutVO>
	  * @exception  DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<VesselUtilizationStatusReportOutVO> searchVesselUtilizationStatusReport(VesselUtilizationStatusReportInVO vo) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<VesselUtilizationStatusReportOutVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param    = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 Map<String, String> mapVO = vo.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOVesselUtilizationStatusReportOutVORSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, VesselUtilizationStatusReportOutVO.class);
			 
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }
		 
		 return list;
	 } 
	 
	 /**
	  * Vessel Utilization Status vs. Bsa by Lane 에 BSA by Lane 리스트를 조회합니다.<br>
	  * 
	  * @param  String vvd
	  * @return List<VesselUtilizationStatusReportOutVO>
	  * @exception  DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<VesselUtilizationStatusReportOutVO> searchVesselUtilizationStatusReport(String vvd) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<VesselUtilizationStatusReportOutVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param    = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 param.put("vvd", vvd);

	         velParam.put("vvd", vvd);
	         
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOVesselUtilizationStatusReportOutVO2RSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, VesselUtilizationStatusReportOutVO.class);
			 
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }
		 
		 return list;
	 } 
	 
	 /**
	  * Vessel Utilization Status vs. Bsa by Lane 에 이전 BSA정보를 조회합니다.<br>
	  * 
	  * @param  String vvd
	  * @return List<VesselUtilizationStatusReportOutVO>
	  * @exception  DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<VesselUtilizationStatusReportOutVO> searchVesselUtilizationStatusReportPreBsa(String vvd) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<VesselUtilizationStatusReportOutVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param    = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 param.put("vvd", vvd);

	         velParam.put("vvd", vvd);
	         
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOVesselUtilizationStatusReportOutVO3RSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, VesselUtilizationStatusReportOutVO.class);
			 
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }
		 
		 return list;
	 } 
	 
	 /**
	  * Vessel Utilization Status vs. Bsa by Lane 에 이전 VVD정보를 조회합니다.<br>
	  * 
	  * @param  String vvd
	  * @return String
	  * @exception  DAOException
	  */
	 public String searchVesselUtilizationStatusReportPreVvd(String vvd) throws DAOException {
		 DBRowSet dbRowset = null;
		 String reValue = null;
		 
		 //query parameter
		 Map<String, Object> param    = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 param.put("vvd", vvd);

	         velParam.put("vvd", vvd);
	         
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOVesselUtilizationStatusReportOutVO4RSQL(),param, velParam);

			 if (dbRowset.first()){
				 
				 reValue = dbRowset.getString(1);
			 }else{
				 
				 reValue = vvd;
			 }
			 
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }
		 
		 return reValue;
	 }
	 
	 /**
	  * 0985 Queue Detail Return 정보를 조회합니다.<br>
	  * @param  DocQueueDetailReturnInVO docQueueDetailReturnInVO 
	  * @return List<DocQueueDetailReturnInVO>
	  * @throws DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<DocQueueDetailReturnInVO> searchQueueDetailReturn(DocQueueDetailReturnInVO docQueueDetailReturnInVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<DocQueueDetailReturnInVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 Map<String, String> mapVO = docQueueDetailReturnInVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchQueueDetailReturnRSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, DocQueueDetailReturnInVO.class);
		 } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		 
		 return list;
	 } 	 
 	 
	 /**
	  * 0985 Queue Detail Return Code List 정보를 조회합니다.<br>
	  * @param  SearchQueueDetailReturnReasonCdListVO vo
	  * @return List<SearchQueueDetailReturnReasonCdListVO>
	  * @throws DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<SearchQueueDetailReturnReasonCdListVO> searchQueueDetailReturnReasonCdList(SearchQueueDetailReturnReasonCdListVO vo) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SearchQueueDetailReturnReasonCdListVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 Map<String, String> mapVO = vo.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchQueueDetailReturnReasonCdListRSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchQueueDetailReturnReasonCdListVO.class);
		 } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		 
		 return list;
	 } 	
	 /**
	 * Correction(C/A) 월별 Summary Batch. (BAT_BKG_004)<br>
	 * 
	 * @param String fromDt
	 * @param String toDt
	 * @exception EventException
	 */	
	 public void manageCASummary(String fromDt, String toDt) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		 try{
			 param.put("from_dt", fromDt);
			 param.put("to_dt", toDt);
			 
			 velParam.put("from_dt", fromDt);
	         velParam.put("to_dt", toDt);						
				
	         SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			 int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOCaSummaryBatchCSQL(), param,velParam);
				
			 if(insCnt == Statement.EXECUTE_FAILED)
							throw new DAOException(new ErrorHandler("COM12240").getMessage());

		 } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	 }
	 
	 /**
	  * 1073 Customer EDI ID Inquiry 정보를 조회합니다.<br>
	  * @param  SearchEDIGrpIDVO searchEDIGrpIDVO
	  * @return List<SearchEDIGrpIDVO>
	  * @throws DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<SearchEDIGrpIDVO> searchEDIGrpId(SearchEDIGrpIDVO searchEDIGrpIDVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SearchEDIGrpIDVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 Map<String, String> mapVO = searchEDIGrpIDVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchEDIGrpIDRSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEDIGrpIDVO.class);
		 } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		 
		 return list;
	 } 	 

	/**
	 * addBkgSrRequest - 외부호출
	 *
	 * @param DpcsWebBookingVO dpcsWebBookingVO
	 * @throws DAOException
	 */
	public void addBkgSrRequest(DpcsWebBookingVO dpcsWebBookingVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
	    try {
			Map<String, String> mapVO = dpcsWebBookingVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
	    	new SQLExecuter("").executeSP((ISQLTemplate)new PerformanceReportDBDAOAddBkgSrRequestCSQL(), param, velParam);
	    } catch (SQLException se) {
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage());
	    } catch(Exception ex) {
	        log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage());
	    }
	}

	/**
	 * 0104 Report template(Default, Detail, User Set)을 생성합니다.<br>
	 * 
	 * @param List<ReportTemplateListVO> reportTemplateListVO
	 * @throws DAOException
	 */
	public void addReportTemplateBstVipList(List<ReportTemplateListVO> reportTemplateListVO) throws DAOException, Exception {
		manageReportTemplateBstVipList(reportTemplateListVO, "C");
	}

	/**
	 * 0104 Report template(Default, Detail, User Set)을 수정합니다.<br>
	 * 
	 * @param List<ReportTemplateListVO> reportTemplateListVO
	 * @throws DAOException
	 */
	public void modifyReportTemplateBstVipList(List<ReportTemplateListVO> reportTemplateListVO) throws DAOException, Exception {
		manageReportTemplateBstVipList(reportTemplateListVO, "U");
	}

	/**
	 * 0104 Report template(Default, Detail, User Set) 을 삭제합니다.<br>
	 * 
	 * @param List<ReportTemplateListVO> reportTemplateListVO
	 * @throws DAOException
	 */
	public void removeReportTemplateBstVipList(List<ReportTemplateListVO> reportTemplateListVO) throws DAOException, Exception {
		manageReportTemplateBstVipList(reportTemplateListVO, "D");
	}

	/**
	 * 0104 Report template(Default, Detail, User Set)을 수정/삭제 처리합니다.<br>
	 * 
	 * @param List<ReportTemplateListVO> reportTemplateListVO
	 * @param String cudGubun
	 * @throws DAOException
	 */
	public void manageReportTemplateBstVipList(List<ReportTemplateListVO> reportTemplateListVO, String cudGubun) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (reportTemplateListVO.size() > 0) {

				if (cudGubun.equals("C")) {
					updCnt = sqlExe.executeBatch((ISQLTemplate) new PerformanceReportDBDAOAddReportTemplateBstVipList1CSQL(), reportTemplateListVO, null);
					checkDBDAOException(updCnt);

					updCnt = sqlExe.executeBatch((ISQLTemplate) new PerformanceReportDBDAOAddReportTemplateBstVipList2CSQL(), reportTemplateListVO, null);
					checkDBDAOException(updCnt);

					updCnt = sqlExe.executeBatch((ISQLTemplate) new PerformanceReportDBDAOAddReportTemplateBstVipList3CSQL(), reportTemplateListVO, null);
					checkDBDAOException(updCnt);

				} else if (cudGubun.equals("U")) {
					updCnt = sqlExe.executeBatch((ISQLTemplate) new PerformanceReportDBDAOModifyReportTemplateBstVipList1USQL(), reportTemplateListVO, null);
					checkDBDAOException(updCnt);

					updCnt = sqlExe.executeBatch((ISQLTemplate) new PerformanceReportDBDAOModifyReportTemplateBstVipList2USQL(), reportTemplateListVO, null);
					checkDBDAOException(updCnt);

					/******************** Report Template Detail *************************/
					// if("B".equals(reportTemplateListVO.get(0).getBkgRptKndCd())) return;
					/* Detail: Item Option delete/Insert */
					// query parameter
					Map<String, Object> param = new HashMap<String, Object>();
					// velocity parameter
					Map<String, Object> velParam = new HashMap<String, Object>();

					int result = 0;
					for (int i = 0; i < reportTemplateListVO.size(); i++) {

						Map<String, String> mapVO = reportTemplateListVO.get(i).getColumnValues();

						param.putAll(mapVO);
						velParam.putAll(mapVO);

						log.debug("reportTemplateListVO.get(" + i + ")::" + reportTemplateListVO.get(i).getSelectedColNm() + "::" + reportTemplateListVO.get(i).getModifiedColNm());
						if (!JSPUtil.getNull(reportTemplateListVO.get(i).getSelectedColNm()).equals(reportTemplateListVO.get(i).getModifiedColNm())) {
							result = sqlExe.executeUpdate((ISQLTemplate) new PerformanceReportDBDAORemoveReportTemplateBstVipList2DSQL(), param, velParam);
							checkDBDAOException(result);
							result = sqlExe.executeUpdate((ISQLTemplate) new PerformanceReportDBDAOAddReportTemplateBstVipList2CSQL(), param, velParam);
							checkDBDAOException(result);
						}

						param.clear();
						velParam.clear();
					}
					/*******************************************************************************************/

				} else if (cudGubun.equals("D")) {
					updCnt = sqlExe.executeBatch((ISQLTemplate) new PerformanceReportDBDAORemoveReportTemplateBstVipList2DSQL(), reportTemplateListVO, null);
					checkDBDAOException(updCnt);

					updCnt = sqlExe.executeBatch((ISQLTemplate) new PerformanceReportDBDAORemoveReportTemplateBstVipList3DSQL(), reportTemplateListVO, null);
					checkDBDAOException(updCnt);

					updCnt = sqlExe.executeBatch((ISQLTemplate) new PerformanceReportDBDAORemoveReportTemplateBstVipList1DSQL(), reportTemplateListVO, null);
					checkDBDAOException(updCnt);

				}

			}// End reportTemplateListVO.size() > 0
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * checkDBDAOException
	 * 
	 * @param int[] updCnt
	 * @throws DAOException
	 */
	public void checkDBDAOException(int[] updCnt) throws DAOException {
		for (int i = 0; updCnt != null && i < updCnt.length; i++) {
			checkDBDAOException(updCnt[i]);
		}
	}
	
	/**
	 * checkDBDAOException
	 * 
	 * @param int updCnt
	 * @throws DAOException
	 */
	public void checkDBDAOException(int updCnt) throws DAOException {
		if (updCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + updCnt + " SQL");
	}
	
	/**
	 * 1004 Super User Authority Change - PIC CHANGE(0421화면) 버튼 클릭시 관련 데이블 데이타를 수정합니다.<br>
	 * 
	 * @param  DocsUserGroupCdVO docsUserGroupCdVO
	 * @throws DAOException
	 */
	public void modifyDocsUserGroupCd(DocsUserGroupCdVO docsUserGroupCdVO) throws DAOException, Exception {
		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			if (docsUserGroupCdVO != null) {
				Map<String, String> mapVO = docsUserGroupCdVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				int insCnt = sqlExe.executeUpdate((ISQLTemplate) new PerformanceReportDBDAOModifyDocsUserGroupCdUSQL(), param, velParam);

				if (insCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());

			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * Container NO , Type Size - bkg_no 별 머지함 
	 * bkgCzStsCd: Container NO - "CN", Type Size - "CQ" 
	 * @param  String bkgNo 
	 * @param  String bkgCzStsCd   
	 * @throws DAOException
	 */
	public void manageQtyCntrCoposite(String bkgNo , String bkgCzStsCd ) throws DAOException, Exception {
		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
				
			param.put("bkg_no",      bkgNo);
			param.put("bkg_cz_sts_cd", bkgCzStsCd);
			
			velParam.put("bkg_no",      bkgNo);
			velParam.put("bkg_cz_sts_cd", bkgCzStsCd);
			 
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate) new PerformanceReportDBDAOManageQtyCntrCopositeDSQL(), param, velParam);
			if (insCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
			
			insCnt = sqlExe.executeUpdate((ISQLTemplate) new PerformanceReportDBDAOManageQtyCntrCopositeCSQL(), param, velParam); 
			if (insCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
			
			if(bkgCzStsCd.equals("CQ")){
				
				insCnt = sqlExe.executeUpdate((ISQLTemplate) new PerformanceReportDBDAOManageQtyCntrCoposite2DSQL(), param, velParam); 
				if (insCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
				
				insCnt = sqlExe.executeUpdate((ISQLTemplate) new PerformanceReportDBDAOManageQtyCntrCoposite2CSQL(), param, velParam); 
				if (insCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
					
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
			
	/**
	 * BKG_AUTO_RT_HIS 생성작업<br>
	 * 
	 * @param String bkgNo
	 * @exception  DAOException
	 */
 
	 @SuppressWarnings("unchecked")
	public void addAutoRtHistory(String bkgNo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		try{
			param.put("in_bkg_no", bkgNo);
			param.put("o_result", "");
			param.put("o_err_msg", "");
			log.debug("param:" + param);
			
			rtnMap = new SQLExecuter("DEFAULT") .executeSP( (ISQLTemplate) new PerformanceReportDBDAOAddAutoRtHistoryCSQL(), param, null);
			log.debug("---------------------------------------------------------");
			log.debug("rtnMap:" + rtnMap);
			log.debug("---------------------------------------------------------");
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	} 
	 
	 /**
	  * 사용자 Office에 해당 하는 Data Update Time 을 조회합니다.<br>
	  * @param  String usrId
	  * @return String
	  * @throws DAOException
	  */
	 public String searchOfcTime(String usrId) throws DAOException {
		 DBRowSet dbRowset = null;
		 String ofcTime = "";
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 param.put("usr_id", usrId);
			 
			 velParam.put("usr_id", usrId);
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchOfcTimeRSQL(),param, velParam);
			 
			 if (dbRowset.first()){
				 
				 ofcTime = dbRowset.getString(1);
			 }
			 			 
		 } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		 
		 return ofcTime;
	 } 	 
	 /**
	  * Autorating Accuracy monitoring Report 조회(ESM_BKG_1081).<br>
	  * 1.Autorating Accuracy Ration<br>
	  * 
	  * @param  AutoratingReportVO autoratingReportVO
	  * @return List<AutoratingReportVO>
	  * @throws DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<AutoratingReportVO> searchAutoratingReport(AutoratingReportVO autoratingReportVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<AutoratingReportVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 Map<String, String> mapVO = autoratingReportVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchAutoratingReportRSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, AutoratingReportVO.class);
		 } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		 
		 return list;
	 } 	 
	 
	 /**
	  * Autorating Accuracy monitoring Report 조회(ESM_BKG_1081).<br>
	  * 2.Autorating B/L List<br>
	  * 
	  * @param  AutoratingReportVO autoratingReportVO
	  * @return List<AutoratingReportVO>
	  * @throws DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<AutoratingReportVO> searchAutoBLListReport(AutoratingReportVO autoratingReportVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<AutoratingReportVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 Map<String, String> mapVO = autoratingReportVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchAutoBLListReportRSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, AutoratingReportVO.class);
		 } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		 
		 return list;
	 } 	 
	 
	 /**
	  * Autorating Accuracy monitoring Report 조회(ESM_BKG_1081).<br>
	  * 3.Non Autorating B/L List<br>
	  * 
	  * @param  AutoratingReportVO autoratingReportVO
	  * @return List<AutoratingReportVO>
	  * @throws DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<AutoratingReportVO> searchNonAutoratingReport(AutoratingReportVO autoratingReportVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<AutoratingReportVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 Map<String, String> mapVO = autoratingReportVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchNonAutoratingReportRSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, AutoratingReportVO.class);
		 } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		 
		 return list;
	 } 
	 
	 /**
	  * 2 weeks Daily Booking Trend by Customer 조회(ESM_BKG_1082)합니다.<br>
	  * 
	  * @param  SearchBookingTrendReportVO vo
	  * @return List<SearchBookingTrendReportVO>
	  * @exception  DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<SearchBookingTrendReportVO> searchBookingTrendReport(SearchBookingTrendReportVO vo) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SearchBookingTrendReportVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param    = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 /*
		 StringBuffer newVVDs = new StringBuffer();
		 //SELECT VVD Option Setting
		 String[] tempVVDs = vo.getVvd().split(",");		 		
		 
		 for (int i = 0 ; i < tempVVDs.length ; i++){
			 if (i == 0){
				 newVVDs.append("'"); newVVDs.append(tempVVDs[i]); newVVDs.append("'");
			 }else{
				 newVVDs.append(","); newVVDs.append("'"); newVVDs.append(tempVVDs[i]); newVVDs.append("'");
			 }
		 }
		 */
		 vo.setVvd(vo.getVvd()); 
		 
		 //Unit View Option Setting
		 if (vo.getUnitOp().equals("FEU")){
			 vo.setUnitOp("1");
		 }else{
			 vo.setUnitOp("2");
		 }
		 
		 //Display Level on the Output result Option Setting
		 StringBuffer selOp = new StringBuffer();
		 StringBuffer grpOp = new StringBuffer();
		 log.debug(" dis option <<<<<<<<<<<<<<<<< " + vo.getDisVal());
		 
		 /* display Sales Rep. */
		 if (vo.getDisVal().indexOf("1") > -1){
			 
			 selOp.append(" ,X.OB_SREP_CD ,X.CUST_CD ,REPLACE(X.CUST_NM,CHR(13) || CHR(10),' ') AS CUST_NM ");
			 
			 grpOp.append(" ,X.OB_SREP_CD ,X.CUST_CD ,X.CUST_NM ");
		 }else{
			 //Display 에서 빼고 Group By 될수 있도록 함
			 log.debug("dis option indexOf1: "+vo.getDisVal().indexOf("1"));
		 }
		 /* display Customer */ 
         if (vo.getDisVal().indexOf("2") > -1){
			 
			 selOp.append(" ,X.CUST_CD ,REPLACE(X.CUST_NM,CHR(13) || CHR(10),' ') AS CUST_NM ");
			 
			 grpOp.append(" ,X.CUST_CD ,X.CUST_NM ");
		 }else{
//			 Display 에서 빼고 Group By 될수 있도록 함
			 log.debug("dis option indexOf2: "+vo.getDisVal().indexOf("2"));
		 }
         /* display CM. */
		 if (vo.getDisVal().indexOf("3") > -1){
			 
			 selOp.append(" ,TRUNC(SUM(DECODE(X.BY_SEQ,1,X.CM,0))) AS CM ,DECODE(SUM(DECODE(X.BY_SEQ,1,X.CM,0)),0,0,TRUNC(SUM(DECODE(X.BY_SEQ,1,X.CM,0))/SUM(DECODE(X.BY_SEQ,1,NVL(X.C_TEU,0),0)))) AS CMPB ");
			 
			// grpOp.append(" ,X.CM ,X.CMPB ");
		 }else{
//			 Display 에서 빼고 Group By 될수 있도록 함
			 log.debug("dis option indexOf3: "+vo.getDisVal().indexOf("3"));
		 }
		 
		 vo.setSelOp(selOp.toString());
		 vo.setGrpOp(grpOp.toString());
		 
		 try{
			 Map<String, String> mapVO = vo.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchBookingTrendReportVORSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchBookingTrendReportVO.class);
			 
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }
		 
		 return list;
	 } 
	 
	 /**
	  * 2 weeks Daily Booking Trend by Customer >>> B/L Detail 조회(ESM_BKG_1083)합니다.<br>
	  * 
	  * @param  SearchBookingTrendReportVO vo
	  * @return List<SearchBookingTrendReportVO>
	  * @exception  DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<SearchBookingTrendReportVO> searchBookingTrendReportBLDetail(SearchBookingTrendReportVO vo) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SearchBookingTrendReportVO> list = null;
		 
		//Unit View Option Setting
		 if (vo.getUnitOp().equals("FEU")){
			 vo.setUnitOp("1");
		 }else{
			 vo.setUnitOp("2");
		 }
		 //query parameter
		 Map<String, Object> param    = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 		 
		 try{
			 Map<String, String> mapVO = vo.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchBookingTrendReportByBLRSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchBookingTrendReportVO.class);
			 
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }
		 
		 return list;
	 } 
	 /**
	  * 2 weeks Daily Booking Trend by Customer 조회(ESM_BKG_1082)합니다.<br>
	  * 
	  * @param  SearchBookingTrendReportVO vo
	  * @return List<SearchBookingTrendReportVO>
	  * @exception  DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<SearchBookingTrendReportVO> searchBookingTrendReportDetail(SearchBookingTrendReportVO vo) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SearchBookingTrendReportVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param    = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		
		 try{
			 Map<String, String> mapVO = vo.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchBookingTrendDetailReportVORSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchBookingTrendReportVO.class);
			 
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }
		 
		 return list;
	 } 
		/**
		 * Booking 에서 Cancel 처리 할 경우  Status 업데이트 처리한다<br>
		 * 
		 * @author Kim tae kyoung
		 * @param String bkgNo
		 * @param String bkgSrCrntRqst
		 * @param String srWrkStsCd
		 * @exception DAOException
		 */
		public void modifyQueueByBkg(String bkgNo, String bkgSrCrntRqst, String srWrkStsCd) throws DAOException, Exception {
			SQLExecuter sqlExe = new SQLExecuter("");
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			int insCnt = 0 ;

			try {
				param.put("bkg_no", bkgNo);
				param.put("bkg_sr_crnt_rqst", bkgSrCrntRqst);
				param.put("sr_wrk_sts_cd", srWrkStsCd);
				
				velParam.put("bkg_no", bkgNo);
				velParam.put("bkg_sr_crnt_rqst", bkgSrCrntRqst);
				velParam.put("sr_wrk_sts_cd", srWrkStsCd);

				insCnt = sqlExe.executeUpdate((ISQLTemplate) new PerformaceReportDBDAOModifyQueueByBkgUSQL(), param, velParam);
				
				if (insCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
			} catch (SQLException ex) {
				//log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			} catch (Exception ex) {
				//log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}

	/**
	 * 중국 EDI 수신을 추가한다.<br>
	 * @author Min Jeong KIM
	 * @param List<BkgObChnRcvVO> bkgObChnRcvs
	 * @exception DAOException
	 */
	public void addBkgObChnRcv(List<BkgObChnRcvVO> bkgObChnRcvs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			
			// 혹시 같은 MSG_RCV_NO가 있을지 모르니깐.

			Map<String, Object> param = new HashMap<String, Object>();
			if(bkgObChnRcvs != null) {
				Map<String, String> mapVO = bkgObChnRcvs.get(0).getColumnValues();
				param.putAll(mapVO);
			}
			DBRowSet dbRowset = sqlExe.executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchBkgObChnRcvMaxSeqRSQL(), param, null);
			log.info(new PerformanceReportDBDAOSearchBkgObChnRcvMaxSeqRSQL().getSQL());
			if (dbRowset.next()) {
				int maxSeq = dbRowset.getInt(1);
				if (maxSeq > 0 ) {
					for (int i=0; i<bkgObChnRcvs.size(); i++) {
						bkgObChnRcvs.get(i).setRcvLogSeq(String.valueOf(maxSeq + Integer.parseInt(bkgObChnRcvs.get(i).getRcvLogSeq())));
					}
				}
				
				log.info(new PerformanceReportDBDAOAddBkgObChnRcvCSQL().getSQL());
				int updCnt[] = sqlExe.executeBatch((ISQLTemplate) new PerformanceReportDBDAOAddBkgObChnRcvCSQL(), bkgObChnRcvs, null);

				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
				
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 중국 EDI 수신을 추가한다.<br>
	 * @author Min Jeong KIM
	 * @param bkgObChnRcvHis BkgObChnRcvHisVO
	 * @exception DAOException
	 */
	public void addBkgObChnRcvHis(BkgObChnRcvHisVO bkgObChnRcvHis) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			
			// 혹시 같은 MSG_RCV_NO가 있을지 모르니깐.

			Map<String, Object> param = new HashMap<String, Object>();
			if(bkgObChnRcvHis != null) {
				Map<String, String> mapVO = bkgObChnRcvHis.getColumnValues();
				param.putAll(mapVO);
			}
			int insCnt = sqlExe.executeUpdate((ISQLTemplate) new PerformanceReportDBDAOAddBkgObChnRcvHisCSQL(), param, param);
			if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException(new ErrorHandler("COM12240").getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * SR Receiving List 결과를 조회한다.<br>
	 * 
	 * @param BkgEmlAcctStupVO vo
  	 * @return List<BkgEmlAcctStupVO>
	 * @exception  DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BkgEmlAcctStupVO> searchBkgEmlAcctStupList(
			BkgEmlAcctStupVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgEmlAcctStupVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new PerformanceReportDBDAOBkgEmlAcctStupRSQL(),
							param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					BkgEmlAcctStupVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
	/**
	  * BKG_EML_ACCT_STUP 를 수정 한다.<br>
	  * 
	  * @param List<BkgEmlAcctStupVO> bkgEmlAcctStupVOs
	  * @exception  DAOException
	  */
	 public void modifyBkgEmlAcctStup(List<BkgEmlAcctStupVO> bkgEmlAcctStupVOs)
			throws DAOException {

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgEmlAcctStupVOs.size() > 0) {
				updCnt = sqlExe
						.executeBatch(
								(ISQLTemplate) new PerformanceReportDBDAOBkgEmlAcctStupVOUSQL(),
								bkgEmlAcctStupVOs, null);

				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}
	 
	 /**
	  * BKG_EML_ACCT_STUP 를 저장 한다.<br>
	  * 
	  * @param List<BkgEmlAcctStupVO> bkgEmlAcctStupVOs
	  * @exception  DAOException
	  */
	 public void addBkgEmlAcctStup(List<BkgEmlAcctStupVO> bkgEmlAcctStupVOs)
			throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (bkgEmlAcctStupVOs.size() > 0) {
				insCnt = sqlExe
						.executeBatch(
								(ISQLTemplate) new PerformanceReportDBDAOBkgEmlAcctStupVOCSQL(),
								bkgEmlAcctStupVOs, null);

				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
		 
	 /**
	 * BKG_EML_ACCT_STUP 를 삭제합니다. <br>
	 * 
	 * @param List<BkgEmlAcctStupVO> bkgEmlAcctStupVOs
	 * @throws DAOException
	 */
	public void removeBkgEmlAcctStup(List<BkgEmlAcctStupVO> bkgEmlAcctStupVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(bkgEmlAcctStupVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new PerformanceReportDBDAOBkgEmlAcctStupVODSQL(), bkgEmlAcctStupVOs,null);

				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
     * Queue List Set Serarch 조회(ESM_BKG_0446).<br>
     * 
     * @param String usrId
     * @return List<BkgXterSrchSetVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<BkgXterSrchSetVO> searchQueueListSearchSetList(String usrId) throws DAOException {
  	  DBRowSet dbRowset = null;
        List<BkgXterSrchSetVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
        	param.put("usr_id", usrId);
            velParam.put("usr_id", usrId);
            
            param.put("usr_id", usrId);
            velParam.put("usr_id", usrId);
            
            SQLExecuter executer = new SQLExecuter("DEFAULT");              
            PerformanceReportDBDAOBkgDpcsQueueSetSearchListRSQL template = new PerformanceReportDBDAOBkgDpcsQueueSetSearchListRSQL();

            dbRowset = executer.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgXterSrchSetVO.class);              
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
        return list;
  }

    /**
     * Queue List Set Serarch Where 조회(ESM_BKG_0446).<br>
     * 
     * @param String usrId
     * @return String
     * @exception DAOException
     */
    public String searchQueueListSearchSetWhere(String usrId) throws DAOException {
  	  DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        String set_qry_where = "";
        try {
            param.put("usr_id", usrId);
            velParam.put("usr_id", usrId);
            SQLExecuter executer = new SQLExecuter("DEFAULT");              
            PerformanceReportDBDAOBkgDpcsQueueSetSearchWhereListRSQL template = new PerformanceReportDBDAOBkgDpcsQueueSetSearchWhereListRSQL();

            dbRowset = executer.executeQuery(template, param, velParam);
            if (dbRowset.first()){
            	set_qry_where = dbRowset.getString(1);
			 }            
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
        return set_qry_where;
  }  
    
    /**
	  * 0455 DPCS SPLIT List 정보를 조회합니다.<br>
	  * @param  DpcsSiSplitCandidateVO vo
	  * @return List<DpcsSiSplitCandidateVO>
	  * @throws DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<DpcsSiSplitCandidateVO> searchDpcsSiSplitCandidate(DpcsSiSplitCandidateVO vo) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<DpcsSiSplitCandidateVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 Map<String, String> mapVO = vo.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAODpcsSiSplitCandidateRSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, DpcsSiSplitCandidateVO.class);
		 } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		 
		 return list;
	 } 	
	 
	 /**
	  * 0455 DPCS SPLIT Cntr Hist 정보를 조회합니다.<br>
	  * @param  DpcsSiSplitBkgCntrHisVO vo
	  * @return List<DpcsSiSplitBkgCntrHisVO>
	  * @throws DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<DpcsSiSplitBkgCntrHisVO> searchDpcsSiSplitCntrHis(DpcsSiSplitBkgCntrHisVO vo) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<DpcsSiSplitBkgCntrHisVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 Map<String, String> mapVO = vo.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAODpcsSiSplitBkgCntrHisRSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, DpcsSiSplitBkgCntrHisVO.class);
		 } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		 
		 return list;
	 }

	 /**
	  * 0455 DPCS SPLIT Cntr Compare Result List 정보를 조회합니다.<br>
	  * @param  DpcsSiSplitBkgCntrCompareResultVO vo
	  * @return List<DpcsSiSplitBkgCntrCompareResultVO>
	  * @throws DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<DpcsSiSplitBkgCntrCompareResultVO> searchDpcsSiSplitBkgCntrCompareResult(DpcsSiSplitBkgCntrCompareResultVO vo) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<DpcsSiSplitBkgCntrCompareResultVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 Map<String, String> mapVO = vo.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAODpcsSiSplitBkgCntrCompareResultRSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, DpcsSiSplitBkgCntrCompareResultVO.class);
		 } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		 
		 return list;
	 }

	 /**
	  * 0455 DPCS SPLIT Cntr Compare Result List 정보를 조회합니다.<br>
	  * @param  DpcsSiSplitBkgCntrCompareResultVO vo
	  * @return List<DpcsSiSplitBkgCntrCompareResultVO>
	  * @throws DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<DpcsSiSplitBkgCntrCompareResultVO> searchDpcsSiSplitBkgCntrCompareSumResult(DpcsSiSplitBkgCntrCompareResultVO vo) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<DpcsSiSplitBkgCntrCompareResultVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 Map<String, String> mapVO = vo.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAODpcsSiSplitBkgCntrCompareResultRSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, DpcsSiSplitBkgCntrCompareResultVO.class);
		 } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		 
		 return list;
	 }

	 /**
	  * 0423 Queue Summary - Status by S/I Event 정보를 조회합니다.<br>
	  * 
	  * @param SearchQueueSummaryInVO searchQueueSummaryInVO
	  * @return List<DocQueueSummaryStatusVO>
	  * @throws DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<DocQueueSummaryStatusVO> searchQueueSummaryStatus(SearchQueueSummaryInVO searchQueueSummaryInVO) throws DAOException {
	 	DBRowSet dbRowset = null;
	 	List<DocQueueSummaryStatusVO> list = null;
	 	//query parameter
	 	Map<String, Object> param = new HashMap<String, Object>();
	 	//velocity parameter
	 	Map<String, Object> velParam = new HashMap<String, Object>();

	 	try {
	 		Map<String, String> mapVO = searchQueueSummaryInVO.getColumnValues();
	 		param.putAll(mapVO);
	 		velParam.putAll(mapVO);

	 		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAODocQueueSummaryStatusVORSQL(), param, velParam);
	 		list = (List)RowSetUtil.rowSetToVOs(dbRowset, DocQueueSummaryStatusVO.class);
	 	} catch(SQLException se) {
	 		log.error(se.getMessage(),se);
	 		throw new DAOException(new ErrorHandler(se).getMessage(), se);
	 	} catch(Exception ex) {
	 		log.error(ex.getMessage(),ex);
	 		throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	 	}

	 	return list;
	 } 

	 /**
	  * 0423 Queue Summary - By SR Kind 정보를 조회합니다.<br>
	  * 
	  * @param SearchQueueSummaryInVO searchQueueSummaryInVO
	  * @return List<DocQueueSummarySRKindVO>
	  * @throws DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<DocQueueSummarySRKindVO> searchQueueSummarySRKind(SearchQueueSummaryInVO searchQueueSummaryInVO) throws DAOException {
	 	DBRowSet dbRowset = null;
	 	List<DocQueueSummarySRKindVO> list = null;
	 	//query parameter
	 	Map<String, Object> param = new HashMap<String, Object>();
	 	//velocity parameter
	 	Map<String, Object> velParam = new HashMap<String, Object>();

	 	try {
	 		Map<String, String> mapVO = searchQueueSummaryInVO.getColumnValues();
	 		param.putAll(mapVO);
	 		velParam.putAll(mapVO);

	 		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAODocQueueSummarySRKindVORSQL(), param, velParam);
	 		list = (List)RowSetUtil.rowSetToVOs(dbRowset, DocQueueSummarySRKindVO.class);
	 	} catch(SQLException se) {
	 		log.error(se.getMessage(),se);
	 		throw new DAOException(new ErrorHandler(se).getMessage(), se);
	 	} catch(Exception ex) {
	 		log.error(ex.getMessage(),ex);
	 		throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	 	}

	 	return list;
	 } 

	 /**
	  * 0423 Queue Summary - Just in Time(JIT) Completence 정보를 조회합니다.<br>
	  * 
	  * @param SearchQueueSummaryInVO searchQueueSummaryInVO
	  * @return List<DocQueueSummaryJITCompletenceVO>
	  * @throws DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<DocQueueSummaryJITCompletenceVO> searchQueueSummaryJITCompletence(SearchQueueSummaryInVO searchQueueSummaryInVO) throws DAOException {
	 	DBRowSet dbRowset = null;
	 	List<DocQueueSummaryJITCompletenceVO> list = null;
	 	//query parameter
	 	Map<String, Object> param = new HashMap<String, Object>();
	 	//velocity parameter
	 	Map<String, Object> velParam = new HashMap<String, Object>();

	 	try {
	 		Map<String, String> mapVO = searchQueueSummaryInVO.getColumnValues();
	 		param.putAll(mapVO);
	 		velParam.putAll(mapVO);

	 		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAODocQueueSummaryJITCompletenceVORSQL(), param, velParam);
	 		list = (List)RowSetUtil.rowSetToVOs(dbRowset, DocQueueSummaryJITCompletenceVO.class);
	 	} catch(SQLException se) {
	 		log.error(se.getMessage(),se);
	 		throw new DAOException(new ErrorHandler(se).getMessage(), se);
	 	} catch(Exception ex) {
	 		log.error(ex.getMessage(),ex);
	 		throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	 	}

	 	return list;
	 } 

	 /**
	  * 0423 Queue Summary - By Urgency 정보를 조회합니다.<br>
	  * 
	  * @param SearchQueueSummaryInVO searchQueueSummaryInVO
	  * @return List<DocQueueSummaryUrgencyVO>
	  * @throws DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<DocQueueSummaryUrgencyVO> searchQueueSummaryUrgency(SearchQueueSummaryInVO searchQueueSummaryInVO) throws DAOException {
	 	DBRowSet dbRowset = null;
	 	List<DocQueueSummaryUrgencyVO> list = null;
	 	//query parameter
	 	Map<String, Object> param = new HashMap<String, Object>();
	 	//velocity parameter
	 	Map<String, Object> velParam = new HashMap<String, Object>();

	 	try {
	 		Map<String, String> mapVO = searchQueueSummaryInVO.getColumnValues();
	 		param.putAll(mapVO);
	 		velParam.putAll(mapVO);

	 		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAODocQueueSummaryUrgencyVORSQL(), param, velParam);
	 		list = (List)RowSetUtil.rowSetToVOs(dbRowset, DocQueueSummaryUrgencyVO.class);
	 	} catch(SQLException se) {
	 		log.error(se.getMessage(),se);
	 		throw new DAOException(new ErrorHandler(se).getMessage(), se);
	 	} catch(Exception ex) {
	 		log.error(ex.getMessage(),ex);
	 		throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	 	}

	 	return list;
	 } 

	 /**
	  * 0423 Queue Summary - By Return Feedback Status 정보를 조회합니다.<br>
	  * 
	  * @param SearchQueueSummaryInVO searchQueueSummaryInVO
	  * @return List<DocQueueSummaryReturnFeedbackVO>
	  * @throws DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<DocQueueSummaryReturnFeedbackVO> searchQueueSummaryReturnFeedback(SearchQueueSummaryInVO searchQueueSummaryInVO) throws DAOException {
	 	DBRowSet dbRowset = null;
	 	List<DocQueueSummaryReturnFeedbackVO> list = null;
	 	//query parameter
	 	Map<String, Object> param = new HashMap<String, Object>();
	 	//velocity parameter
	 	Map<String, Object> velParam = new HashMap<String, Object>();

	 	try {
	 		Map<String, String> mapVO = searchQueueSummaryInVO.getColumnValues();
	 		param.putAll(mapVO);
	 		velParam.putAll(mapVO);

	 		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAODocQueueSummaryReturnFeedbackVORSQL(), param, velParam);
	 		list = (List)RowSetUtil.rowSetToVOs(dbRowset, DocQueueSummaryReturnFeedbackVO.class);
	 	} catch(SQLException se) {
	 		log.error(se.getMessage(),se);
	 		throw new DAOException(new ErrorHandler(se).getMessage(), se);
	 	} catch(Exception ex) {
	 		log.error(ex.getMessage(),ex);
	 		throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	 	}

	 	return list;
	 } 

	 /**
	  * 0423 Queue Summary - Aging Status(P.F) 정보를 조회합니다.<br>
	  * 
	  * @param SearchQueueSummaryInVO searchQueueSummaryInVO
	  * @return List<DocQueueSummaryAgingVO>
	  * @throws DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<DocQueueSummaryAgingVO> searchQueueSummaryAging(SearchQueueSummaryInVO searchQueueSummaryInVO) throws DAOException {
	 	DBRowSet dbRowset = null;
	 	List<DocQueueSummaryAgingVO> list = null;
	 	//query parameter
	 	Map<String, Object> param = new HashMap<String, Object>();
	 	//velocity parameter
	 	Map<String, Object> velParam = new HashMap<String, Object>();

	 	try {
	 		Map<String, String> mapVO = searchQueueSummaryInVO.getColumnValues();
	 		param.putAll(mapVO);
	 		velParam.putAll(mapVO);

	 		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAODocQueueSummaryAgingVORSQL(), param, velParam);
	 		list = (List)RowSetUtil.rowSetToVOs(dbRowset, DocQueueSummaryAgingVO.class);
	 	} catch(SQLException se) {
	 		log.error(se.getMessage(),se);
	 		throw new DAOException(new ErrorHandler(se).getMessage(), se);
	 	} catch(Exception ex) {
	 		log.error(ex.getMessage(),ex);
	 		throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	 	}

	 	return list;
	 } 

	/**
	 * 0415 - DPCS Point List를 조회합니다.<br>
	 * 
	 * @param BkgDpcsDocWeightVO bkgDpcsDocWeightVO
	 * @return List<BkgDpcsDocWeightVO>
	 * @throws DAOException
	 */
	public List<BkgDpcsDocWeightVO> searchDPCSPointList(BkgDpcsDocWeightVO bkgDpcsDocWeightVO) throws DAOException {
		DBRowSet dbR = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, String> mapVO = bkgDpcsDocWeightVO.getColumnValues();
		param.putAll(mapVO);
		List<BkgDpcsDocWeightVO> list = null;
		try{
			dbR = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOBkgDpcsSearchPointListRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbR, BkgDpcsDocWeightVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 0412 - DPCS Weight Value를 수정합니다.
	 * 
	 * @param BkgDpcsDocWeightVO bkgDpcsDocWeightVO
	 * @throws DAOException
	 */
	public void modifyDpcsWeightValue(BkgDpcsDocWeightVO bkgDpcsDocWeightVO) throws DAOException {
		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			if (bkgDpcsDocWeightVO != null) {
				Map<String, String> mapVO = bkgDpcsDocWeightVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				int insCnt = sqlExe.executeUpdate((ISQLTemplate) new PerformanceReportDBDAOModifyDpcsWeightValueUSQL(), param, velParam);
				if (insCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());

			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
  

	/**
	 * 0432 - B/L Perform Volume By Region Group List를 조회합니다.
	 * 
	 * @param SearchPerfVolByRegionGroupInVO searchPerfVolByRegionGroupInVO
	 * @return List<SearchPerfVolByRegionGroupListVO>
	 * @throws EventException
	 */
	public List<SearchPerfVolByRegionGroupListVO> searchBlPerfVolByRegionGroupList(SearchPerfVolByRegionGroupInVO searchPerfVolByRegionGroupInVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SearchPerfVolByRegionGroupListVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 Map<String, String> mapVO = searchPerfVolByRegionGroupInVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchBlPerfVolByRegionGroupListRSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchPerfVolByRegionGroupListVO.class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }
		 
		 return list;
	} 	

	/**
	 * 0432 - B/L Perform Volume By Region Group Detail List를 조회합니다.<br>
	 * 
	 * @param SearchPerfVolByRegionGroupInVO searchPerfVolByRegionGroupInVO
	 * @return List<SearchPerfVolByRegionGroupDtlListVO>
	 * @throws DAOException
	 */
	public List<SearchPerfVolByRegionGroupDtlListVO> searchBlPerfVolByRegionGroupDtlList(SearchPerfVolByRegionGroupInVO searchPerfVolByRegionGroupInVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SearchPerfVolByRegionGroupDtlListVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 Map<String, String> mapVO = searchPerfVolByRegionGroupInVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchBlPerfVolByRegionGroupDtlListRSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchPerfVolByRegionGroupDtlListVO.class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }
		 
		 return list;
	}

	/**
	 * 0415 - Report By Inputter User Group List를 조회합니다.<br>
	 * 
	 * @param SearchPerfVolByRegionGroupInVO searchPerfVolByRegionGroupInVO
	 * @return List<SearchReportByInputterUserGroupListVO>
	 * @throws DAOException
	 */
	public List<SearchReportByInputterUserGroupListVO> searchReportByInputterUserGroupList(SearchPerfVolByRegionGroupInVO searchPerfVolByRegionGroupInVO) throws DAOException {
		// TODO Auto-generated method stub
		 DBRowSet dbRowset = null;
		 List<SearchReportByInputterUserGroupListVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 Map<String, String> mapVO = searchPerfVolByRegionGroupInVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchReportByInputterUserGroupListRSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchReportByInputterUserGroupListVO.class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }
		 
		 return list;
	}

	/**
	 * 0415 - Report By Inputter User Group Detail List를 조회합니다.
	 * 
	 * @param SearchPerfVolByRegionGroupInVO searchPerfVolByRegionGroupInVO
	 * @return List<SearchPerfVolByRegionGroupDtlListVO>
	 * @throws DAOException
	 */
	public List<SearchPerfVolByRegionGroupDtlListVO> searchReportByInputterUserGroupDtlList(SearchPerfVolByRegionGroupInVO searchPerfVolByRegionGroupInVO) throws DAOException {
		DBRowSet dbRowset = null;
		 List<SearchPerfVolByRegionGroupDtlListVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 
			 Map<String, String> mapVO = searchPerfVolByRegionGroupInVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchReportByInputterUserGroupDtlListRSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchPerfVolByRegionGroupDtlListVO.class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }
		 
		 return list;
	}

	/**
	 * 0415 - Report By Rater User Group List를 조회합니다.
	 * 
	 * @param SearchPerfVolByRegionGroupInVO searchPerfVolByRegionGroupInVO
	 * @return List<SearchReportByRaterUserGroupListVO>
	 * @throws DAOException
	 */
	public List<SearchReportByRaterUserGroupListVO> searchReportByRaterUserGroupList(SearchPerfVolByRegionGroupInVO searchPerfVolByRegionGroupInVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SearchReportByRaterUserGroupListVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 
			 Map<String, String> mapVO = searchPerfVolByRegionGroupInVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchReportByRaterUserGroupListRSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchReportByRaterUserGroupListVO.class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }
		 
		 return list;
	} 	
	
	/**
	 * BOOKING S/I KIND에 따른 VALUE 자동 세팅<br>
	 * call_pgm_type 세팅 값 1.QUE 2.SI<br>
	 * call_pgm_type 1.QUE일 경우 in_type => 1.QA,2.CONFIRM<br>
	 * 
	 * @param ModifySiValAutoVO modifySiValAutoVO
	 * @param String call_pgm_type
	 * @return ModifySiValAutoVO
	 * @exception  DAOException
	 */
	 @SuppressWarnings("unchecked")
	public ModifySiValAutoVO modifySiValAuto(ModifySiValAutoVO modifySiValAutoVO, String call_pgm_type) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		 
		try{
			Map<String, String> mapVO = modifySiValAutoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			param.put("call_pgm_type", call_pgm_type);
			velParam.put("call_pgm_type", call_pgm_type);
			
			log.debug("param:" + param);
			
			rtnMap = new SQLExecuter("DEFAULT") .executeSP( (ISQLTemplate) new PerformanceReportDBDAOModifySiValAutoUSQL(), param, velParam);
			log.debug("---------------------------------------------------------");
			log.debug("rtnMap:" + rtnMap);
			
			modifySiValAutoVO.setOResult(rtnMap.get("o_result")==null?"":(String)rtnMap.get("o_result"));
			modifySiValAutoVO.setOErrMsg(rtnMap.get("o_err_msg")==null?"":(String)rtnMap.get("o_err_msg"));
            
			log.debug("---------------------------------------------------------");
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return modifySiValAutoVO;
	} 
	 
	 /**
		 * TRO 현황 조회 화면(ESM_BKG_1123).
		 * 
		 * @param TroEurStatusListInVO vo
		 * @return List<TroEurStatusListInVO>
		 * @exception  DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<TroEurStatusListInVO> searchEurTroStatusList(TroEurStatusListInVO vo) throws DAOException {
			DBRowSet dbRowset = null;
			List<TroEurStatusListInVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
		
			try{
				Map<String, String> mapVO = vo .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOTroEurStatusListInVORSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, TroEurStatusListInVO.class);
			
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		} 
		 
		/**
		 * @param String srNo
		 * @param String faxLogRefNo
		 * @param String srProcTpCd
		 * @param String updUsrId
		 * @throws DAOException
		 */
		public void addBkgSrProcHisPrc(String srNo, String faxLogRefNo,
				String srProcTpCd, String updUsrId) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
//			Map<String, Object> rtnMap = new HashMap<String, Object>();
			try{
	 
//					Map<String, String> mapVO = docQueueBkgHistListVO.getColumnValues();
//					param.putAll(mapVO);
				
				param.put("sr_no", srNo);
				param.put("fax_log_ref_no", faxLogRefNo);
				param.put("sr_proc_tp_cd", srProcTpCd);
				param.put("usr_id", updUsrId);
				new SQLExecuter("DEFAULT") .executeSP( (ISQLTemplate) new PerformanceReportDBDAOAddBkgSrProcHisPrcCSQL(), param, null);
				log.debug("---------------------------------------------------------");
				log.debug("---------------------------------------------------------");
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		/**
		 * @param String srNo
		 * @param String faxLogRefNo
		 * @param String srProcTpCd
		 * @param String updUsrId
		 * @param String preCtnt
		 * @param String crntCtnt
		 * @param String hisCateNm
		 * @throws DAOException
		 */
		public void addBkgSrProcHis(String srNo, String faxLogRefNo,
				String srProcTpCd, String updUsrId, String preCtnt, String crntCtnt, 
				String hisCateNm) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
//			Map<String, Object> rtnMap = new HashMap<String, Object>();
			try{
	 
//					Map<String, String> mapVO = docQueueBkgHistListVO.getColumnValues();
//					param.putAll(mapVO);
				
				param.put("sr_no", srNo);
				param.put("fax_log_ref_no", faxLogRefNo);
				param.put("sr_proc_tp_cd", srProcTpCd);
				param.put("usr_id", updUsrId);
				param.put("pre_ctnt", preCtnt);
				param.put("crnt_ctnt", crntCtnt);
				param.put("his_cate_nm", hisCateNm);
				
				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				int insCnt = sqlExe.executeUpdate((ISQLTemplate) new PerformanceReportDBDAOAddBkgSrProcHisCSQL(), param, null);
				
				log.debug("---------------------------------------------------------");
				log.debug("insCnt:" + insCnt);
				log.debug("---------------------------------------------------------");
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}	

		/**
		 * @param String srNo
		 * @param String faxLogRefNo
		 * @param String procTpCd
		 * @param String usrId
		 * @throws DAOException
		 */
		public void modifyBkgProcTpCd(String srNo, String faxLogRefNo,
				 String procTpCd, String usrId) throws DAOException {
			try {
				// query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

	            param.put("sr_no", srNo);
	            param.put("fax_log_ref_no", faxLogRefNo);
	            param.put("usr_id", usrId);
	            param.put("proc_tp_cd", procTpCd);
	            velParam.put("usr_id", usrId);
				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				int insCnt = sqlExe.executeUpdate((ISQLTemplate) new PerformanceReportDBDAOModifyBkgProcTpCdUSQL(), param, velParam);
				if (insCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
 
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			
		} 	
		/**
		 * @param SearchSREmlReceivingListVO searchSREmlReceivingListVO
		 * @param String usrId
		 * @throws DAOException
		 */
		public void modifyBkgSrFaxUrgency(
				SearchSREmlReceivingListVO searchSREmlReceivingListVO, String usrId) throws DAOException {
			try {
				// query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				if (searchSREmlReceivingListVO != null) {
					Map<String, String> mapVO = searchSREmlReceivingListVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
		            param.put("usr_id", usrId);
		            velParam.put("usr_id", usrId);
					SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
					int insCnt = sqlExe.executeUpdate((ISQLTemplate) new PerformanceReportDBDAOModifyBkgSrFaxUrgencyUSQL(), param, velParam);
					if (insCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());

				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			
		}

		/**
		 * @param SearchSREmlReceivingListVO searchSREmlReceivingListVO
		 * @param String usrId
		 * @throws DAOException
		 */
		public void modifyBkgXterRqstMstBkgNo(
				SearchSREmlReceivingListVO searchSREmlReceivingListVO, String usrId)  throws DAOException {
			try {
				// query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				if (searchSREmlReceivingListVO != null) {
					Map<String, String> mapVO = searchSREmlReceivingListVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
		            param.put("usr_id", usrId);
		            velParam.put("usr_id", usrId);
					SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
					int insCnt = sqlExe.executeUpdate((ISQLTemplate) new PerformanceReportDBDAOModifyBkgXterRqstMstBkgNoUSQL(), param, velParam);
					if (insCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());

				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			
		}

		/**
		 * @param SearchSREmlReceivingListVO vo
		 * @return List<SearchSREmlReceivingListVO>
		 * @throws DAOException
		 */
		public List<SearchSREmlReceivingListVO> searchSiAutoSREmlReceivingList(
				SearchSREmlReceivingListVO vo) throws DAOException {
					DBRowSet dbRowset = null;
					List<SearchSREmlReceivingListVO> list = null;
					// query parameter
					Map<String, Object> param = new HashMap<String, Object>();
					// velocity parameter
					Map<String, Object> velParam = new HashMap<String, Object>();
			
					try {
						if (vo != null) {
							Map<String, String> mapVO = vo.getColumnValues();
							param.putAll(mapVO);
							velParam.putAll(mapVO);
						}
						dbRowset = new SQLExecuter("")
								.executeQuery(
										(ISQLTemplate) new PerformanceReportDBDAOSearchSiAutoSREmlReceivingListVORSQL(),
										param, velParam);
						list = (List) RowSetUtil.rowSetToVOs(dbRowset,
								SearchSREmlReceivingListVO.class);
					} catch (SQLException se) {
						log.error(se.getMessage(), se);
						throw new DAOException(new ErrorHandler(se).getMessage(), se);
					} catch (Exception ex) {
						log.error(ex.getMessage(), ex);
						throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
					}
					return list;
		}

		/**
		 * @param SearchBkgSrProcHisListVO vo
		 * @return List<SearchBkgSrProcHisListVO>
		 * @throws DAOException
		 */
		public List<SearchBkgSrProcHisListVO> searchBkgSrProcHisList(
				SearchBkgSrProcHisListVO vo) throws DAOException {
					DBRowSet dbRowset = null;
					List<SearchBkgSrProcHisListVO> list = null;
					// query parameter
					Map<String, Object> param = new HashMap<String, Object>();
					// velocity parameter
					Map<String, Object> velParam = new HashMap<String, Object>();
			
					try {
						if (vo != null) {
							Map<String, String> mapVO = vo.getColumnValues();
							param.putAll(mapVO);
							velParam.putAll(mapVO);
						}
						dbRowset = new SQLExecuter("")
								.executeQuery(
										(ISQLTemplate) new PerformanceReportDBDAOSearchBkgSrProcHisListRSQL(),
										param, velParam);
						list = (List) RowSetUtil.rowSetToVOs(dbRowset,
								SearchBkgSrProcHisListVO.class);
					} catch (SQLException se) {
						log.error(se.getMessage(), se);
						throw new DAOException(new ErrorHandler(se).getMessage(), se);
					} catch (Exception ex) {
						log.error(ex.getMessage(), ex);
						throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
					}
					return list;
		}

		/**
		 * @param String usrId
		 * @return List<BkgHrdCdgCtntVO>
		 * @throws DAOException
		 */
		public List<BkgHrdCdgCtntVO> searchRhqMail(String usrId)  throws DAOException {
				DBRowSet dbRowset = null;
				List<BkgHrdCdgCtntVO> list = null;
				// query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				//Map<String, Object> velParam = new HashMap<String, Object>();
		
				try {
					param.put("usr_id", usrId);
					dbRowset = new SQLExecuter("")
							.executeQuery(
									(ISQLTemplate) new PerformanceReportDBDAOSearchRhqMailRSQL(),
									param, null);
					list = (List) RowSetUtil.rowSetToVOs(dbRowset,
							BkgHrdCdgCtntVO.class);
				} catch (SQLException se) {
					log.error(se.getMessage(), se);
					throw new DAOException(new ErrorHandler(se).getMessage(), se);
				} catch (Exception ex) {
					log.error(ex.getMessage(), ex);
					throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
				}
				return list;
		}

		/**
		 * @param BkgCorrCngDpcsUsrVO vo
		 * @return List<BkgCorrCngDpcsUsrVO>
		 * @throws DAOException
		 */
		public List<BkgCorrCngDpcsUsrVO> searchDPSCCngUserGroup(BkgCorrCngDpcsUsrVO vo) throws DAOException {
					DBRowSet dbRowset = null;
					List<BkgCorrCngDpcsUsrVO> list = null;
					// query parameter
					Map<String, Object> param = new HashMap<String, Object>();
					// velocity parameter
					Map<String, Object> velParam = new HashMap<String, Object>();
			
					try {
						if (vo != null) {
							Map<String, String> mapVO = vo.getColumnValues();
							param.putAll(mapVO);
							velParam.putAll(mapVO);
						}
						dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PerformanceReportDBDAOSearchDPSCCngUserGroupRSQL(), param, velParam);
						list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCorrCngDpcsUsrVO.class);
					} catch (SQLException se) {
						log.error(se.getMessage(), se);
						throw new DAOException(new ErrorHandler(se).getMessage(), se);
					} catch (Exception ex) {
						log.error(ex.getMessage(), ex);
						throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
					}
					return list;
		}
		
		/**
		 * 1140 Super User Authority Change - PIC CHANGE(0421화면) 버튼 클릭시 관련 데이블 데이타를 수정합니다.<br>
		 * 
		 * @param  BkgCorrCngDpcsUsrVO bkgCorrCngDpcsUsrVO
		 * @throws DAOException
		 */
		public void modifyDocsUserCngGroupCd(BkgCorrCngDpcsUsrVO bkgCorrCngDpcsUsrVO) throws DAOException, Exception {
			try {
				// query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				if (bkgCorrCngDpcsUsrVO != null) {
					Map<String, String> mapVO = bkgCorrCngDpcsUsrVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);

					SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
					int insCnt = sqlExe.executeUpdate((ISQLTemplate) new PerformanceReportDBDAOModifyDocsUserCngGroupCdUSQL(), param, velParam);

					if (insCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());

				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}

		 
		 /**
		 * SI Turn Time Report - Summary 를 조회한다.<br>
		 * 
		 * @param SiTurnTimeVO vo
	  	 * @return List<SiTurnTimeSummaryVO>
		 * @exception  DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<SiTurnTimeSummaryVO> searchSiTurnTimeSummary(SiTurnTimeVO vo) throws DAOException {
			DBRowSet dbRowset = null;
			List<SiTurnTimeSummaryVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(vo != null){
					Map<String, String> mapVO = vo .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchSiTurnTimeSummaryRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SiTurnTimeSummaryVO.class);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}

		 
		 /**
		 * SI Turn Time Report - Detail을  조회한다.<br>
		 * 
		 * @param SiTurnTimeVO vo
	  	 * @return List<SiTurnTimeDetailVO>
		 * @exception  DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<SiTurnTimeDetailVO> searchSiTurnTimeDetail(SiTurnTimeVO vo) throws DAOException {
			DBRowSet dbRowset = null;
			List<SiTurnTimeDetailVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(vo != null){
					Map<String, String> mapVO = vo .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchSiTurnTimeDetailRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SiTurnTimeDetailVO.class);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}
		 
		/**
		 * SI Turn Time Report - Detail SS를  조회한다.<br>
		 * 
		 * @param SiTurnTimeVO vo
	  	 * @return List<SiTurnTimeDetailVO>
		 * @exception  DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<SiTurnTimeDetailVO> searchSiTurnTimeDetailSs(SiTurnTimeVO vo) throws DAOException {
			DBRowSet dbRowset = null;
			List<SiTurnTimeDetailVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(vo != null){
					Map<String, String> mapVO = vo .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchSiTurnTimeDetailRSsRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SiTurnTimeDetailVO.class);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}

		 
		 /**
		 * Queue Status Report - Region별 결과를 조회한다.<br>
		 * 
		 * @param QueueStatusVO vo
	  	 * @return List<QueueStatusVO>
		 * @exception  DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<QueueStatusVO> searchQueueStatusByRegion(QueueStatusVO vo) throws DAOException {
			DBRowSet dbRowset = null;
			List<QueueStatusVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(vo != null){
					Map<String, String> mapVO = vo .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchQueueStatusByRegionRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, QueueStatusVO.class);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}
		 
		 /**
		 * Queue Status Report - Office별 결과를 조회한다.<br>
		 * 
		 * @param QueueStatusVO vo
	  	 * @return List<QueueStatusVO>
		 * @exception  DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<QueueStatusVO> searchQueueStatusByOffice(QueueStatusVO vo) throws DAOException {
			DBRowSet dbRowset = null;
			List<QueueStatusVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(vo != null){
					Map<String, String> mapVO = vo .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchQueueStatusByOfficeRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, QueueStatusVO.class);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}
		 
		 /**
		 * Queue Status Report - 상세목록을 조회한다.<br>
		 * 
		 * @param QueueStatusVO vo
	  	 * @return List<QueueStatusDetailVO>
		 * @exception  DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<QueueStatusDetailVO> searchQueueStatusDetail(QueueStatusVO vo) throws DAOException {
			DBRowSet dbRowset = null;
			List<QueueStatusDetailVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(vo != null){
					Map<String, String> mapVO = vo .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchQueueStatusDetailRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, QueueStatusDetailVO.class);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}
		 
		 /**
		 * Production Ratio Report - Region별 결과를 조회한다.<br>
		 * 
		 * @param ProductionRatioVO vo
	  	 * @return List<ProductionRatioVO>
		 * @exception  DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<ProductionRatioVO> searchProductionRatioByRegion(ProductionRatioVO vo) throws DAOException {
			DBRowSet dbRowset = null;
			List<ProductionRatioVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(vo != null){
					Map<String, String> mapVO = vo .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchProductionRatioByRegionRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, ProductionRatioVO.class);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}
		 
		 /**
		 * Production Ratio Report - Office별 결과를 조회한다.<br>
		 * 
		 * @param ProductionRatioVO vo
	  	 * @return List<ProductionRatioVO>
		 * @exception  DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<ProductionRatioVO> searchProductionRatioByOffice(ProductionRatioVO vo) throws DAOException {
			DBRowSet dbRowset = null;
			List<ProductionRatioVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(vo != null){
					Map<String, String> mapVO = vo .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchProductionRatioByOfficeRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, ProductionRatioVO.class);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}
		 
		 /**
		 * Production Ratio Report - Region별 결과를 조회한다.<br>
		 * 
		 * @param ProductionRatioVO vo
	  	 * @return List<ProductionRatioDetailVO>
		 * @exception  DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<ProductionRatioDetailVO> searchProductionRatioDetail(ProductionRatioVO vo) throws DAOException {
			DBRowSet dbRowset = null;
			List<ProductionRatioDetailVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(vo != null){
					Map<String, String> mapVO = vo .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchProductionRatioDetailRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, ProductionRatioDetailVO.class);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}
		 
		 /**
		  * DPCS - S/R 업무처리 담당자 정보를 Searchg한다
		  * 
		  * @param String usrId
		  * @param String dpcsWrkGrpCd
		  * @param String rgnOfcCd
		  * @param BkgDpcsUsrGrpVO vo
		  * @return List<BkgDpcsUsrGrpVO>
		  * @exception  DAOException
		  */
		 @SuppressWarnings("unchecked")
		public List<BkgDpcsUsrGrpVO> searchDPCSUser(String usrId, String dpcsWrkGrpCd, String rgnOfcCd, BkgDpcsUsrGrpVO vo) throws DAOException  {
			DBRowSet dbRowset = null;
			List<BkgDpcsUsrGrpVO> list = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try {
				if (vo != null) {
					Map<String, String> mapVO = vo.getColumnValues();
					
					
					param.put("usr_id", usrId);
					param.put("dpcs_wrk_grp_cd", dpcsWrkGrpCd);
					param.put("rgn_ofc_cd", rgnOfcCd);
					
					velParam.put("usr_id", usrId);
					velParam.put("dpcs_wrk_grp_cd", dpcsWrkGrpCd);
					velParam.put("rgn_ofc_cd", rgnOfcCd);

					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PerformanceReportDBDAOSearchDPCSUserRSQL(), param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgDpcsUsrGrpVO.class);

			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}
			return list;
		}
		 
		 
	 /**
	 * e-Booking & S/I by Email 실적 조회 기능(ESM_BKG_0235)<br>
	 * Report Type : BookingOffice Report (Only) <br>
	 * 
	 * @param EBkgSiPfmcInVO vo
	 * @param boolean detail
	 * @return List<EBkgSiPfmcInVO>
	 * @exception  DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<EBkgSiPfmcInVO> searchEBkgSiPfmcListByEmail(EBkgSiPfmcInVO vo, boolean detail) throws DAOException {
		DBRowSet dbRowset = null;
		List<EBkgSiPfmcInVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
						
			Map<String, String> mapVO = vo .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			if (!detail) {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOsearchEBkgSiPfmcListByEmailRSQL(), param, velParam);
			} else {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOsearchEBkgSiPfmcListByEmailDtlRSQL(), param, velParam);
			}
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EBkgSiPfmcInVO.class);
		
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	} 
	 /**
	  * e-Booking & S/I by Email 실적 엑셀 다운로드 기능(ESM_BKG_0235)<br>
	  * Report Type : BookingOffice Report (Only) <br>
	  * 
	  * @param EBkgSiPfmcInVO vo
	  * @return DBRowSet
	  * @exception  DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public DBRowSet searchEBkgSiPfmcListByEmailForExcelDown(EBkgSiPfmcInVO vo) throws DAOException {
		 DBRowSet dbRowset = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 
			 Map<String, String> mapVO = vo .getColumnValues();
			 
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOsearchEBkgSiPfmcListByEmailDtlRSQL(), param, velParam);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }
		 return dbRowset;
	 } 
	 
	/**
	 * 해당 BKG이 Front Office Type으로 접수된 적이 있는지 조회한다.<br>
	 * 
	 * @param String bkgNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchFrontOfficeFlag(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String blFntOfcFlg = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if( null != bkgNo){ 
				param.put("bkg_no",bkgNo);
				velParam.put("bkg_no",bkgNo);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOsearchFrontOfficeFlagRSQL(), param, velParam);

				if(dbRowset.first())
					blFntOfcFlg = dbRowset.getString(1);
			}
		
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return blFntOfcFlg;
	}

	/**
	 * ESM_BKG_0236 : e-BKG & SI Turn Time Summary를 조회합니다.
	 * 
	 * @param EBkgSiTurnTimeInVO eBkgSiTurnTimeInVO
	 * @return List<EBkgSiTurnTimeOutVO>
	 * @throws EventException
	 */
	public List<EBkgSiTurnTimeOutVO> searchEBkgSiTurnTimeSummary(EBkgSiTurnTimeInVO eBkgSiTurnTimeInVO) throws DAOException {
		DBRowSet dbRowset = null;
		 List<EBkgSiTurnTimeOutVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 
			 Map<String, String> mapVO = eBkgSiTurnTimeInVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchEBkgSiTurnTimeSummaryRSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EBkgSiTurnTimeOutVO.class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }
		 
		 return list;
	}

	/**
	 * ESM_BKG_0236 : e-BKG & SI Turn Time Detail을 조회합니다.
	 * 
	 * @param EBkgSiTurnTimeInVO eBkgSiTurnTimeInVO
	 * @param EBkgSiTurnTimeInVO[] eBkgSiTurnTimeInVOs
	 * @return List<EBkgSiTurnTimeOutVO>
	 * @throws EventException
	 */
	public List<EBkgSiTurnTimeOutVO> searchEBkgSiTurnTimeDetail(EBkgSiTurnTimeInVO eBkgSiTurnTimeInVO, EBkgSiTurnTimeInVO[] eBkgSiTurnTimeInVOs) throws DAOException {
		DBRowSet dbRowset = null;
		 List<String> dBkgOfcCd = new ArrayList<String>();
		 List<EBkgSiTurnTimeOutVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 for(int i=0;i<eBkgSiTurnTimeInVOs.length;i++){
				 dBkgOfcCd.add(eBkgSiTurnTimeInVOs[i].getBkgOfcCd() + eBkgSiTurnTimeInVOs[i].getGsoCd());
			 }
			 
			 Map<String, String> mapVO = eBkgSiTurnTimeInVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 param.put("d_bkg_ofc_cd",dBkgOfcCd);
			 velParam.put("d_bkg_ofc_cd",dBkgOfcCd);
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchEBkgSiTurnTimeDetailRSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EBkgSiTurnTimeOutVO.class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }
		 
		 return list;
	}

	/**
	 * ESM_BKG_0236 : e-BKG & SI Upload Time Summary를 조회합니다.
	 * 
	 * @param EBkgSiTurnTimeInVO eBkgSiTurnTimeInVO
	 * @return List<EBkgSiTurnTimeOutVO>
	 * @throws EventException
	 */
	public List<EBkgSiTurnTimeOutVO> searchEBkgSiUploadTimeSummary(EBkgSiTurnTimeInVO eBkgSiTurnTimeInVO) throws DAOException {
		DBRowSet dbRowset = null;
		 List<EBkgSiTurnTimeOutVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 
			 Map<String, String> mapVO = eBkgSiTurnTimeInVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchEBkgSiUploadTimeSummaryRSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EBkgSiTurnTimeOutVO.class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }
		 
		 return list;
	}

	/**
	 * ESM_BKG_0236 : e-BKG & SI Upload Time Detail을 조회합니다.
	 * 
	 * @param EBkgSiTurnTimeInVO eBkgSiTurnTimeInVO
	 * @param EBkgSiTurnTimeInVO[] eBkgSiTurnTimeInVOs
	 * @return List<EBkgSiTurnTimeOutVO>
	 * @throws EventException
	 */
	public List<EBkgSiTurnTimeOutVO> searchEBkgSiUploadTimeDetail(EBkgSiTurnTimeInVO eBkgSiTurnTimeInVO, EBkgSiTurnTimeInVO[] eBkgSiTurnTimeInVOs) throws DAOException {
		DBRowSet dbRowset = null;
		 List<EBkgSiTurnTimeOutVO> list = null;
		 List<String> dBkgOfcCd = new ArrayList<String>();
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 for(int i=0;i<eBkgSiTurnTimeInVOs.length;i++){
				 dBkgOfcCd.add(eBkgSiTurnTimeInVOs[i].getBkgOfcCd() + eBkgSiTurnTimeInVOs[i].getGsoCd());
			 }
			 
			 Map<String, String> mapVO = eBkgSiTurnTimeInVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 param.put("d_bkg_ofc_cd",dBkgOfcCd);
			 velParam.put("d_bkg_ofc_cd",dBkgOfcCd);
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchEBkgSiUploadTimeDetailRSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EBkgSiTurnTimeOutVO.class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }
		 
		 return list;
	}
	
	/**
	 * Doc Performance Report(ESM_BKG_0214)<br>
	 * Doc Performance Report에서 사용할 Region Office 목록을 불러온다.<br>
	 * 
	 * @return List<BkgComboVO>
	 * @throws DAOException
	 */
	public List<BkgComboVO> searchRgnOfficeCdForPFMC() throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgComboVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			PerformanceReportDBDAOsearchRgnOfficeCdForPFMCRSQL template = new PerformanceReportDBDAOsearchRgnOfficeCdForPFMCRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);

			list = new ArrayList<BkgComboVO>();
			while (dbRowset.next()) {
				BkgComboVO vo = new BkgComboVO();
				vo.setVal(dbRowset.getString("region_cd"));
				list.add(vo);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	
	 /**
	 * TRO 현황 조회 화면(ESM_BKG_0621).
	 * 
	 * @param TroUsaStatusListInVO vo
	 * @return List<TroUsaStatusListInVO>
	 * @exception  DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<TroUsaStatusListInVO> searchTroUsaStatusList(TroUsaStatusListInVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<TroUsaStatusListInVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			Map<String, String> mapVO = vo .getColumnValues();
			
			param.putAll(mapVO);
			String bkg_ofc_cd = vo.getBkgOfcCd();
			if( !bkg_ofc_cd.equals("") && !bkg_ofc_cd.equals("null") && bkg_ofc_cd != null) {
				ArrayList<String> ofcCdArr = new ArrayList<String>();
				StringTokenizer str  = null;
				int j = 0;
				
				ofcCdArr.clear();
				str = new StringTokenizer(bkg_ofc_cd, ",");
				while( str.hasMoreTokens() ) {
					String tmpStr = "";
					tmpStr = str.nextToken();
					tmpStr = tmpStr.replaceAll("\\'", "\\'\\'");
					ofcCdArr.add(j++, tmpStr);
				}
				param.put("ofcCdArr", ofcCdArr);
			}
			String por_cd = vo.getPorCd();
			if( !por_cd.equals("") && !por_cd.equals("null") && por_cd != null) {
				ArrayList<String> porCdArr = new ArrayList<String>();
				StringTokenizer str  = null;
				int j = 0;
				porCdArr.clear();
				str = new StringTokenizer(por_cd, ",");
				while( str.hasMoreTokens() ) {
					String tmpStr = "";
					tmpStr = str.nextToken();
					tmpStr = tmpStr.replaceAll("\\'", "\\'\\'");
					porCdArr.add(j++, tmpStr);
				}
				param.put("porCdArr", porCdArr);
			}
			String pol_cd = vo.getPolCd();
			if( !pol_cd.equals("") && !pol_cd.equals("null") && pol_cd != null) {
				ArrayList<String> polCdArr = new ArrayList<String>();
				StringTokenizer str  = null;
				int j = 0;
				polCdArr.clear();
				str = new StringTokenizer(pol_cd, ",");
				while( str.hasMoreTokens() ) {
					String tmpStr = "";
					tmpStr = str.nextToken();
					tmpStr = tmpStr.replaceAll("\\'", "\\'\\'");
					polCdArr.add(j++, tmpStr);
				}
				param.put("polCdArr", polCdArr);
			}
			String eq_ctrl_ofc_cd = vo.getEqCtrlOfcCd();
			if( !eq_ctrl_ofc_cd.equals("") && !eq_ctrl_ofc_cd.equals("null") && eq_ctrl_ofc_cd != null) {
				ArrayList<String> eqOfcCdArr = new ArrayList<String>();
				StringTokenizer str  = null;
				int j = 0;
				eqOfcCdArr.clear();
				str = new StringTokenizer(eq_ctrl_ofc_cd, ",");
				while( str.hasMoreTokens() ) {
					String tmpStr = "";
					tmpStr = str.nextToken();
					tmpStr = tmpStr.replaceAll("\\'", "\\'\\'");
					eqOfcCdArr.add(j++, tmpStr);
				}
				param.put("eqOfcCdArr", eqOfcCdArr);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOTroUsaStatusListInVORSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TroUsaStatusListInVO.class);
		
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	 /**
	  * WEB SI Auto Upload 처리된 Queue의 Input History 기록<br>
	  * 
	  * @param BkgWebServiceVO vo
	  * @exception  DAOException
	  */
	 public void addQueueHistoryByAutoUpload(BkgWebServiceVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();			
		
		 try{
			 if(vo != null){
					Map<String, String> mapVO = vo .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}							
				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOAddQueueHistoryByAutoUploadCSQL(), param,velParam);
				
				if(insCnt == Statement.EXECUTE_FAILED)
							throw new DAOException(new ErrorHandler("COM12240").getMessage());

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	 }

	 /**
	  * Web SI Auto Upload 처리된 Queue의 Input End Status를 업데이트<br>
	  * 
	  * @param BkgWebServiceVO vo
	  * @exception  DAOException
	  */
	 public void modifyQueueStatusByAutoUpload(BkgWebServiceVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();			
		
		 try{
			 if(vo != null){
					Map<String, String> mapVO = vo .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}							
				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOModifyQueueStatusByAutoUploadUSQL(), param,velParam);
				
				if(insCnt == Statement.EXECUTE_FAILED)
							throw new DAOException(new ErrorHandler("COM12240").getMessage());

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	 }
	 
	 /**
	  * WEB SI Audit 처리된 Queue의 QA History 기록<br>
	  * 
	  * @param SIWebServiceVO vo
	  * @param SignOnUserAccount account
	  * @return int
	  * @exception  DAOException
	  */
	 public int addQueueHistoryByWebSiAudit(SIWebServiceVO vo, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();			
		int insCnt = 0;
		 try{
			 if(vo != null){
					Map<String, String> mapVO = vo .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					param.put("usr_id", account.getUsr_id());
				}							
				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				 insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOAddQueueHistoryByWebSiAuditCSQL(), param,velParam);
				
				if(insCnt == Statement.EXECUTE_FAILED)
							throw new DAOException(new ErrorHandler("COM12240").getMessage());

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		 return insCnt;
	 }

	 /**
	  * Web SI Audit 처리된 Queue의 QA Status를 업데이트<br>
	  * 
	  * @param SIWebServiceVO vo
	  * @param SignOnUserAccount account
	  * @exception  DAOException
	  */
	 public void modifyQueueStatusByWebSiAudit(SIWebServiceVO vo, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();			
		
		 try{
			 if(vo != null){
					Map<String, String> mapVO = vo .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					param.put("usr_id", account.getUsr_id());
				}							
				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOModifyQueueStatusByWebSiAuditUSQL(), param,velParam);
				
				if(insCnt == Statement.EXECUTE_FAILED)
							throw new DAOException(new ErrorHandler("COM12240").getMessage());

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	 }

}