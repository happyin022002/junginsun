/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UnmatchBLDBDAO.java
*@FileTitle : Unmatch B/L Inquiry by Regional Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.06.22 이승준
* 1.0 Creation
=========================================================
History
* 2011.01.06 이정수 [CHM-201007610] RAS 기능 보완 및 Logic 보완 6
* 2012.04.02 김진주 [CHM-201216859] [BKG/DOC - Revenue Audit System] 미주발 S/C B/L OFT 자동심사기능 개발 
* 2012.10.05 조정민 [CHM-201219854] [BKG] BKG 생성시 S/C 에 운임 조회 후 부재시 G/W 메일 SALES REP/PRICING STAFF 전송 기능 추가 
* 2012.11.02 김진주 [CHM-201220005] [BKG/DOC - Revenue Audit System] S/C B/L Surcharge 자동심사 시스템 보완 요청
* 2013.02.04 김진주 [CHM-201322626] [BKG/DOC - Revenue Audit System] SZPBB, HKGBB의 DHF 심사로직 추가
* 2013.04.24 김진주 [CHM-201323001] [BKG/DOC - Revenud Audit System] S/C 적용 B/L 자동심사기능 개발
* 2013.07.30 김진주 [CHM-201325469] [BKG/DOC - Revenue Audit System] COD BKG Inquiry 기능 개발 요청
*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchScOftAutoratingListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.basic.UnmatchBLBCImpl;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.AutoRdnInfoVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.AwkwardBKGListForAuditVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.BKGvsBayPlanVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.BayPlanVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.CODBookingListInVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.CODBookingListOutVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.CreateSurchargeInputVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.DiversionCAVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.EqSubErrSchVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.IhcBKGListForAuditVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.IndiaDthBKGListForAuditVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.IranDthBKGListForAuditVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.MultiRateBkgList1VO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.MultiRateBkgListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.NonAutoratedChargeVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.OblSurrenderForAuditVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RetroActFilterSchVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RetroactiveBLStatusListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchAuditByCNTRQtyDiscrepancyListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchAuditByCommodityAndRouteListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchAuditByHangerInstallationListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchChargeFilteringListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchRetroActFilterVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchUnmatchItemListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchUnmatchTypeListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltUnmatchBLListbyAuditorVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltUnmatchDiffAmountVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltUnmatchStatusReportVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.ScNoteConversionVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.SearchStopOffBkgListforAuditVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.TxsBkgListForAuditSchVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.TxsBkgListForAuditVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.UmchErrBlReportVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.UnmatchBLVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.UnmatchSettlementListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.WscBkgListForAuditSchVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgRevUmchBkgVO;


/**
 * NIS2010 UnmatchBLDBDAO <br>
 * - NIS2010-RevenueAudit system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Seung Jun Lee
 * @see UnmatchBLBCImpl 참조
 * @since J2EE 1.6
 */
public class UnmatchBLDBDAO extends DBDAOSupport {
	
	
	/**
	 * UNMATCH BL INQUERY 시 조건에 해당되는 BKG COUNT SEARCH<br>
	 * 
	 * @param RsltUnmatchBLListbyAuditorVO rsltUnmatchBLListbyAuditorVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchFilteredBkgCount(RsltUnmatchBLListbyAuditorVO rsltUnmatchBLListbyAuditorVO) throws DAOException {
		String bkg_cnt = "";
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltUnmatchBLListbyAuditorVO != null){
				Map<String, String> mapVO = rsltUnmatchBLListbyAuditorVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOFilteredUnmatchBkgCountRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				//bkg_cnt = dbRowset.getString("FILERED_BKG_COUNT");
				bkg_cnt = dbRowset.getString("BKG_COUNT");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bkg_cnt;
	}

	/**
	 * unmatch bl list by auditor.<br>
	 * 
	 * @param RsltUnmatchBLListbyAuditorVO rsltUnmatchBLListbyAuditorVO
	 * @return List<RsltUnmatchBLListbyAuditorVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltUnmatchBLListbyAuditorVO> searchUnmatchBLListbyAuditor(RsltUnmatchBLListbyAuditorVO rsltUnmatchBLListbyAuditorVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltUnmatchBLListbyAuditorVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltUnmatchBLListbyAuditorVO != null){
				Map<String, String> mapVO = rsltUnmatchBLListbyAuditorVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAORsltUnmatchBLListbyAuditorVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltUnmatchBLListbyAuditorVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
	 
	/**
	 * 차이금액 상세내역을 조회한다.<br>
	 * 
	 * @param RsltUnmatchDiffAmountVO rsltUnmatchDiffAmountVO
	 * @return List<RsltUnmatchDiffAmountVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltUnmatchDiffAmountVO> searchUnmatchItemDetailList(RsltUnmatchDiffAmountVO rsltUnmatchDiffAmountVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltUnmatchDiffAmountVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltUnmatchDiffAmountVO != null){
				Map<String, String> mapVO = rsltUnmatchDiffAmountVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOUnmatchDiffAmountRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltUnmatchDiffAmountVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
	 
	/**
	 * unmatch status report list search.<br>
	 * 
	 * @param RsltUnmatchStatusReportVO rsltUnmatchStatusReportVO
	 * @return List<RsltUnmatchStatusReportVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltUnmatchStatusReportVO> searchUnmatchBLStatusList(RsltUnmatchStatusReportVO rsltUnmatchStatusReportVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltUnmatchStatusReportVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltUnmatchStatusReportVO != null){
				Map<String, String> mapVO = rsltUnmatchStatusReportVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOUnmatchStatusReportRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltUnmatchStatusReportVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
	 
		/**
		 * unmatch settlemetn status report list search.<br>
		 * 
		 * @param UnmatchSettlementListVO unmatchSettlementListVO
		 * @return List<UnmatchSettlementListVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<UnmatchSettlementListVO> searchUnmatchBLSettlementList(UnmatchSettlementListVO unmatchSettlementListVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<UnmatchSettlementListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(unmatchSettlementListVO != null){
					Map<String, String> mapVO = unmatchSettlementListVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOSearchUnmatchBLSettlementListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, UnmatchSettlementListVO .class);
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}
			/**
			 * Retroactive B/L status report list search.<br>
			 * 
			 * @param RetroactiveBLStatusListVO retroactiveBLStatusListVO
			 * @return List<RetroactiveBLStatusListVO>
			 * @exception DAOException
			 */
			 @SuppressWarnings("unchecked")
			public List<RetroactiveBLStatusListVO> searchRetroactiveBlStatusList(RetroactiveBLStatusListVO retroactiveBLStatusListVO) throws DAOException {
				DBRowSet dbRowset = null;
				List<RetroactiveBLStatusListVO> list = null;
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				try{
					if(retroactiveBLStatusListVO != null){
						Map<String, String> mapVO = retroactiveBLStatusListVO .getColumnValues();
					
						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOSearchRetroactiveBlStatusListRSQL(), param, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, RetroactiveBLStatusListVO .class);
				} catch (SQLException se) {
					log.error(se.getMessage(),se);
					throw new DAOException(new ErrorHandler(se).getMessage(), se);
				}catch(Exception ex){
					log.error(ex.getMessage(),ex);
					throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
				}
				return list;
			}
	 
	 
//	/**
//	 * 단건의 데이터를 생성한다.<br>
//	 * 
//	 * @param BkgRevUmchBkgVO vo
//	 * @exception DAOException
//	 */
//	public void addUnmatchBL(BkgRevUmchBkgVO vo) throws DAOException,Exception {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		try {
//			Map<String, String> mapVO = vo.getColumnValues();
//			
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);
//			
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int result = sqlExe.executeUpdate((ISQLTemplate)new UnmatchBLDBDAOBkgRevUmchBkgVOCSQL(), param, velParam);
//			if(result == Statement.EXECUTE_FAILED)
//					throw new DAOException("Fail to insert SQL");
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//	}
	
	/**
	 * BKG_REV_UMCH_BKG 테이블을 수정한다.<br>
	 * 
	 * @param BkgRevUmchBkgVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int modifyUnmatchBL(BkgRevUmchBkgVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new UnmatchBLDBDAOBkgRevUmchBkgVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modifyUnmatchBL SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * UNMACH LIST의 상태를 SETTLE 시킴.<br>
	 * 
	 * @param BkgRevUmchBkgVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int modifySettleUnmatchBL(BkgRevUmchBkgVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new UnmatchBLDBDAOBkgRevUmchBkgVOSettleUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modifySettleUnmatchBL SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * UNMACH LIST의 REMARK를 저장.<br>
	 * 
	 * @param BkgRevUmchBkgVO vo
	 * @param String gubun 
	 * @return int
	 * @exception DAOException
	 */
	public int modifyUnmatchBLRmk(BkgRevUmchBkgVO vo, String gubun) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.put   ("gubun", gubun);			 
			velParam.put("gubun", gubun);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new UnmatchBLDBDAOBkgRevUmchBkgVORmkUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modifyUnmatchBLRmk SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
//	/**
//	 * 단건의 데이터를 삭제한다.<br>
//	 * 
//	 * @param BkgRevUmchBkgVO vo
//	 * @return int
//	 * @exception DAOException
//	 */
//	public int removeUnmatchBL(BkgRevUmchBkgVO vo) throws DAOException,Exception {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		
//		int result = 0;
//		try {
//			Map<String, String> mapVO = vo.getColumnValues();
//			
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);
//			
//			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate)new UnmatchBLDBDAOBkgRevUmchBkgVODSQL(), param, velParam);
//			if(result == Statement.EXECUTE_FAILED)
//					throw new DAOException("Fail to removeUnmatchBL SQL");
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return result;
//	}

//	/**
//	 * 다건의 데이터를 일괄적으로 생성한다.<br>
//	 * 
//	 * @param List<BkgRevUmchBkgVO> insModels
//	 * @exception DAOException
//	 */
//	public void addUnmatchBLS(List<BkgRevUmchBkgVO> insModels) throws DAOException,Exception {
//		try {
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int insCnt[] = null;
//			if(insModels.size() > 0){
//				insCnt = sqlExe.executeBatch((ISQLTemplate)new UnmatchBLDBDAOBkgRevUmchBkgVOCSQL(), insModels,null);
//				for(int i = 0; i < insCnt.length; i++){
//					if(insCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to addUnmatchBLS No"+ i + " SQL");
//				}
//			}
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//	}
//	/**
//	 * BKG_REV_UMCH_BKG 테이블을 일괄 수정한다.<br>
//	 * 
//	 * @param List<BkgRevUmchBkgVO> updModels
//	 * @exception DAOException
//	 */
//	public void modifyUnmatchBLS(List<BkgRevUmchBkgVO> updModels) throws DAOException,Exception {
//		try {
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int updCnt[] = null;
//			if(updModels.size() > 0){
//				updCnt = sqlExe.executeBatch((ISQLTemplate)new UnmatchBLDBDAOBkgRevUmchBkgVOUSQL(), updModels,null);
//				for(int i = 0; i < updCnt.length; i++){
//					if(updCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to modifyUnmatchBLS No"+ i + " SQL");
//				}
//			}
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//	}
	
	/**
	 * 다건의 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @param List<BkgRevUmchBkgVO> delModels
	 * @exception DAOException
	 */
//	public void removeUnmatchBLS(List<BkgRevUmchBkgVO> delModels) throws DAOException,Exception {
//		try {
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int delCnt[] = null;
//			if(delModels.size() > 0){
//				delCnt = sqlExe.executeBatch((ISQLTemplate)new UnmatchBLDBDAOBkgRevUmchBkgVODSQL(), delModels,null);
//				for(int i = 0; i < delCnt.length; i++){
//					if(delCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to removeUnmatchBLS No"+ i + " SQL");
//				}
//			}
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//	}
	
	/**
	 * Unmatch Details 리스트를 조회한다.<br>
	 * 
	 * @param RsltSearchUnmatchItemListVO rsltSearchUnmatchItemListVO
	 * @return List<RsltSearchUnmatchItemListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltSearchUnmatchItemListVO> searchUnmatchItemList(RsltSearchUnmatchItemListVO rsltSearchUnmatchItemListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltSearchUnmatchItemListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(rsltSearchUnmatchItemListVO != null){
				Map<String, String> mapVO = rsltSearchUnmatchItemListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAORsltSearchUnmatchItemListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltSearchUnmatchItemListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}			
	
	/**
	 * Unmatch Description 리스트를 조회한다.<br>
	 * 
	 * @param RsltSearchUnmatchTypeListVO rsltSearchUnmatchTypeListVO
	 * @return List<RsltSearchUnmatchTypeListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltSearchUnmatchTypeListVO> searchUnmatchTypeList(RsltSearchUnmatchTypeListVO rsltSearchUnmatchTypeListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltSearchUnmatchTypeListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(rsltSearchUnmatchTypeListVO != null){
				Map<String, String> mapVO = rsltSearchUnmatchTypeListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAORsltSearchUnmatchTypeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltSearchUnmatchTypeListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}			

	/**
	 * Charge Filtering  리스트를 조회한다.<br>
	 *
	 * @param RsltSearchChargeFilteringListVO rsltSearchChargeFilteringListVO
	 * @return List<RsltSearchChargeFilteringListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")	 
	public List<RsltSearchChargeFilteringListVO> searchChargeFilteringList(RsltSearchChargeFilteringListVO rsltSearchChargeFilteringListVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<RsltSearchChargeFilteringListVO> list = null;
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				if(rsltSearchChargeFilteringListVO != null){
					Map<String, String> mapVO = rsltSearchChargeFilteringListVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);

					String ratUtList = rsltSearchChargeFilteringListVO.getRatUtCd();
					if( ratUtList != null &&  ratUtList.length() != 0 ){
						List<String> ratUtListArr = new ArrayList<String>();
						StringTokenizer st = new StringTokenizer(ratUtList, ",");
						while(st.hasMoreTokens()){
							ratUtListArr.add(st.nextToken());
						}
						param.put("rat_ut_list", ratUtListArr);
						velParam.put("rat_ut_list", ratUtListArr);
					}
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAORsltSearchChargeFilteringListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltSearchChargeFilteringListVO.class);			
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
	}			


	 /**
	 * Audit by Commodity And Route  리스트를 조회한다.<br>
	 *
	 * @param RsltSearchAuditByCommodityAndRouteListVO rsltSearchAuditByCommodityAndRouteListVO
	 * @return List<RsltSearchAuditByCommodityAndRouteListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")	 
	public List<RsltSearchAuditByCommodityAndRouteListVO> searchAuditByCommodityAndRouteList(RsltSearchAuditByCommodityAndRouteListVO rsltSearchAuditByCommodityAndRouteListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltSearchAuditByCommodityAndRouteListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(rsltSearchAuditByCommodityAndRouteListVO != null){
				Map<String, String> mapVO = rsltSearchAuditByCommodityAndRouteListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				String ratUtList = rsltSearchAuditByCommodityAndRouteListVO.getRatUtCd();
				if( ratUtList != null &&  ratUtList.length() != 0 ){
					List<String> ratUtListArr = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(ratUtList, ",");
					while(st.hasMoreTokens()){
						ratUtListArr.add(st.nextToken());
					}
					param.put("rat_ut_list", ratUtListArr);
					velParam.put("rat_ut_list", ratUtListArr);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAORsltSearchAuditByCommodityAndRouteListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltSearchAuditByCommodityAndRouteListVO.class);			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}			
	 
	 
    
    /**
     * Audit by CNTR Qty Discrepancy 리스트를 조회한다. <br>
     * @param RsltSearchAuditByCNTRQtyDiscrepancyListVO rsltSearchAuditByCNTRQtyDiscrepancyListVO
     * @return List<RsltSearchAuditByCNTRQtyDiscrepancyListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltSearchAuditByCNTRQtyDiscrepancyListVO> searchAuditByCNTRQtyDiscrepancyList(RsltSearchAuditByCNTRQtyDiscrepancyListVO rsltSearchAuditByCNTRQtyDiscrepancyListVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltSearchAuditByCNTRQtyDiscrepancyListVO> list = null;
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            if (rsltSearchAuditByCNTRQtyDiscrepancyListVO != null) {
                Map<String, String> mapVO = rsltSearchAuditByCNTRQtyDiscrepancyListVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
              mapVO.put("ctrt_cntr_tpsz_cd", rsltSearchAuditByCNTRQtyDiscrepancyListVO.getCtrtCntrTpszCd());
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UnmatchBLDBDAORsltSearchAuditByCNTRQtyDiscrepancyListVORSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltSearchAuditByCNTRQtyDiscrepancyListVO.class);
            
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }
    
    /**
     * remark update와 create 을 분기한다. <br>
     * @param rsltSearchAuditByCNTRQtyDiscrepancyListVO 
     * @return String
     * @exception DAOException
     */
    
    public String searchByBkgRevAudRslt(RsltSearchAuditByCNTRQtyDiscrepancyListVO rsltSearchAuditByCNTRQtyDiscrepancyListVO) throws DAOException {
        DBRowSet dbRowset = null;
        
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();
        String rtn = "";
        try {
            if (rsltSearchAuditByCNTRQtyDiscrepancyListVO != null) {
                Map<String, String> mapVO = rsltSearchAuditByCNTRQtyDiscrepancyListVO.getColumnValues();
               
              
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            
            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new UnmatchBLDBDAOSearchbyBkgRevAudRsltRSQL(), param, param);
			if (dbRowset.next()) {
				rtn = dbRowset.getString(1);
			}
            
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return rtn;
    }
    
  
		
    /**
     * Audit by CNTR Qty Discrepancy Remark를 수정한다. <br>
     * 
     * @param rsltSearchAuditByCNTRQtyDiscrepancyListVO 
     * @return int
     * @exception DAOException
     * @throws Exception 
     */
    
  	public int modifyAuditByCNTRQtyDiscrepancyList(RsltSearchAuditByCNTRQtyDiscrepancyListVO rsltSearchAuditByCNTRQtyDiscrepancyListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		//Map<String, String> mapVO = null;
		
		int result = 0;
		try {
			Map<String, String> mapVO = rsltSearchAuditByCNTRQtyDiscrepancyListVO.getColumnValues();
			//mapVO.put("usrId", usrId);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new UnmatchBLDBDAOModifyAuditByCNTRQtyDiscrepancyListUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modifyUnmatchBLRmk SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	 
    /**
     * Audit by CNTR Qty Discrepancy Remark를 생성한다. <br>
     * 
     * @param RsltSearchAuditByCNTRQtyDiscrepancyListVO rsltSearchAuditByCNTRQtyDiscrepancyListVO
     * @return List<RsltSearchAuditByCNTRQtyDiscrepancyListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
  	public int createAuditByCNTRQtyDiscrepancyList(RsltSearchAuditByCNTRQtyDiscrepancyListVO rsltSearchAuditByCNTRQtyDiscrepancyListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		//Map<String, String> mapVO = null;
		
		int result = 0;
		try {
			Map<String, String> mapVO = rsltSearchAuditByCNTRQtyDiscrepancyListVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new UnmatchBLDBDAOModifyAuditByCNTRQtyDiscrepancyListCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modifyUnmatchBLRmk SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
    
    /**
     * Audit by Hanger Installation 화면에서 remark update와 create 을 분기한다 <br>
     * @param rsltSearchAuditByHangerInstallationListVO 
     * @return String
     * @exception DAOException
     */
   
    public String searchByBkgRevAudRsltByHanger(RsltSearchAuditByHangerInstallationListVO rsltSearchAuditByHangerInstallationListVO) throws DAOException {
        DBRowSet dbRowset = null;
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();
        String rtn = "";
        try {
            if (rsltSearchAuditByHangerInstallationListVO != null) {
                Map<String, String> mapVO = rsltSearchAuditByHangerInstallationListVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }

            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new UnmatchBLDBDAOSearchbyBkgRevAudRsltByHangerRSQL(), param, param);
			if (dbRowset.next()) {
				rtn = dbRowset.getString(1);
			}
            
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return rtn;
    }
    
    /**
     * Audit by Hanger Installation 리스트를 조회한다. <br>
     * 
     * @param RsltSearchAuditByHangerInstallationListVO pVO
     * @return List<RsltSearchAuditByHangerInstallationListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltSearchAuditByHangerInstallationListVO> searchAuditByHangerInstallationList(RsltSearchAuditByHangerInstallationListVO pVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltSearchAuditByHangerInstallationListVO> list = null;
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            if (pVO != null) {
                Map<String, String> mapVO = pVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UnmatchBLDBDAORsltSearchAuditByHangerInstallationListVORSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltSearchAuditByHangerInstallationListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }
    
    /**
     * Audit by Hanger Installation Remark를 수정한다. <br>
     * @param RsltSearchAuditByHangerInstallationListVO rsltSearchAuditByHangerInstallationListVO 
     * @return int
     * @exception DAOException
     */
   
  	public int modifyAuditByHangerInstallationList(RsltSearchAuditByHangerInstallationListVO rsltSearchAuditByHangerInstallationListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		//Map<String, String> mapVO = null;
		
		int result = 0;
		try {
			Map<String, String> mapVO = rsltSearchAuditByHangerInstallationListVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new UnmatchBLDBDAOModifyAuditByHangerInstallationListUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modifyUnmatchBLRmk SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	 
    /**
     * Audit by Hanger Installation Remark를 생성한다. <br>
     * @param RsltSearchAuditByHangerInstallationListVO rsltSearchAuditByHangerInstallationListVO 
     * @return int
     * @exception DAOException
     */
  
  	public int createAuditByHangerInstallationList(RsltSearchAuditByHangerInstallationListVO rsltSearchAuditByHangerInstallationListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		//Map<String, String> mapVO = null;
		
		int result = 0;
		try {
			Map<String, String> mapVO = rsltSearchAuditByHangerInstallationListVO.getColumnValues();
			//mapVO.put("usrId", usrId);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new UnmatchBLDBDAOModifyAuditByHangerInstallationListCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modifyUnmatchBLRmk SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
    
    /**
	 * B/L No 로 BkgNo 와 caFlg, ctrtTpCD 를 조회한다. <br>
	 * 
	 * @param String blNo
	 * @param String caFlg
	 * @return UnmatchBLVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public UnmatchBLVO searchBkgCaFlg(String blNo, String caFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<UnmatchBLVO> list = null;
		UnmatchBLVO unmatchBLVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("bl_no", blNo);
			param.put("ca_flg", caFlg);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAORsltSearchBkgCaFlgRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UnmatchBLVO.class);
			if(list != null && list.size() > 0){
				unmatchBLVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return unmatchBLVO;
	}

	/**
	 * Booking No 로 caFlg, ctrtTpCD 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @return List<UnmatchBLVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UnmatchBLVO> searchBkgStatus(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<UnmatchBLVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAORsltSearchBkgStatusRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UnmatchBLVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Self Audit - SC A EffectiveDateDiscrepancy 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UnmatchBLVO> selectCheckScEffectiveDateDiscrepancy(String bkgNo, String caFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<UnmatchBLVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOCheckScEffectiveDateDiscrepancyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UnmatchBLVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	/**
	 * Self Audit - SC A2 Customer Code Discrepancy 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UnmatchBLVO> selectCheckScApplicationDateDiscrepancy(String bkgNo, String caFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<UnmatchBLVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOCheckScApplicationDateDiscrepancyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UnmatchBLVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * Self Audit - SC B Customer Code Discrepancy 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UnmatchBLVO> selectCheckScCustomerDiscrepancy(String bkgNo, String caFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<UnmatchBLVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOCheckScCustomerDiscrepancyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UnmatchBLVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * Self Audit - SC C Commodity Discrepancy 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UnmatchBLVO> selectCheckScCommodityDiscrepancy(String bkgNo, String caFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<UnmatchBLVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOCheckScCommodityDiscrepancyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UnmatchBLVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	/**
	 * Self Audit - SC D Non-Charged B/L 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UnmatchBLVO> selectCheckScNonchargedBl(String bkgNo, String caFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<UnmatchBLVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOCheckScNonchargedBlRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UnmatchBLVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}		

	/**
	 * Self Audit - SC E OftDiscrepancy 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UnmatchBLVO> selectCheckScOftDiscrepancy(String bkgNo, String caFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<UnmatchBLVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOCheckScOftDiscrepancyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UnmatchBLVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	/**
	 * Self Audit - SC E OftDiscrepancy Detail 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UnmatchBLVO> selectCheckScOftDiscrepancyDetail(String bkgNo, String caFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<UnmatchBLVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOCheckScOftDiscrepancyDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UnmatchBLVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}		

	/**
	 * Self Audit - SC F SurchargeDiscrepancy 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @param String mod
	 * @return List<UnmatchBLVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UnmatchBLVO> selectCheckScSurchargeDiscrepancy(String bkgNo, String caFlg, String mod) throws DAOException {
		DBRowSet dbRowset = null;
		List<UnmatchBLVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			param.put("mod", mod);
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			velParam.put("mod", mod);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOCheckScSurchargeDiscrepancyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UnmatchBLVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}		

	/**
	 * Self Audit - SC F SurchargeDiscrepancy Detail 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UnmatchBLVO> selectCheckScSurchargeDiscrepancyDetail(String bkgNo, String caFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<UnmatchBLVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOCheckScSurchargeDiscrepancyDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UnmatchBLVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	
	/**
	 * India에 대하여 SC SurchargeDiscrepancy Detail 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @param String cntCd
	 * @return String[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String[] selectCheckScSurchargeDiscrepancyDetailByCnt(String bkgNo, String caFlg, String cntCd) throws DAOException {
		DBRowSet dbRowset = null;
		String[] rtn =new String[2];
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			param.put("cnt_cd", cntCd);
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			velParam.put("cnt_cd", cntCd);
			
            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new UnmatchBLDBDAOCheckScIndiaSurchargeDiscrepancyDetailRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtn[0] = dbRowset.getString("IHC_FLG");
				rtn[1] = dbRowset.getString("THC_FLG");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtn;
	}
	/**
	 * Self Audit - RFA A1 EffectiveDateDiscrepancy 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UnmatchBLVO> selectCheckRfaEffectiveDateDiscrepancy(String bkgNo, String caFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<UnmatchBLVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOCheckRfaEffectiveDateDiscrepancyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UnmatchBLVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	/**
	 * Self Audit - RFA A2 ApplicationDateDiscrepancy 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UnmatchBLVO> selectCheckApplicationDateDiscrepancy(String bkgNo, String caFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<UnmatchBLVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOCheckRfaApplicationDateDiscrepancyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UnmatchBLVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	
		 
	/**
	 * Self Audit - RFA B Customer Code Discrepancy 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UnmatchBLVO> selectCheckRfaCustomerDiscrepancy(String bkgNo, String caFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<UnmatchBLVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOCheckRfaCustomerDiscrepancyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UnmatchBLVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * Self Audit - RFA C Commodity Discrepancy 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UnmatchBLVO> selectCheckRfaCommodityDiscrepancy(String bkgNo, String caFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<UnmatchBLVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOCheckRfaCommodityDiscrepancyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UnmatchBLVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	/**
	 * Self Audit - RFA D Non-Charged B/L 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UnmatchBLVO> selectCheckRfaNonchargedBl(String bkgNo, String caFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<UnmatchBLVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOCheckRfaNonchargedBlRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UnmatchBLVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}		

	/**
	 * Self Audit - RFA E OftDiscrepancy 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UnmatchBLVO> selectCheckRfaOftDiscrepancy(String bkgNo, String caFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<UnmatchBLVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOCheckRfaOftDiscrepancyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UnmatchBLVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}		
	
	/**
	 * Self Audit - RFA E OftDiscrepancy Detail 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UnmatchBLVO> selectCheckRfaOftDiscrepancyDetail(String bkgNo, String caFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<UnmatchBLVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOCheckRfaOftDiscrepancyDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UnmatchBLVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}		

	/**
	 * Self Audit - RFA F SurchargeDiscrepancy 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @param String mod
	 * @return List<UnmatchBLVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UnmatchBLVO> selectCheckRfaSurchargeDiscrepancy(String bkgNo, String caFlg, String mod) throws DAOException {
		DBRowSet dbRowset = null;
		List<UnmatchBLVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			param.put("mod", mod);
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			velParam.put("mod", mod);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOCheckRfaSurchargeDiscrepancyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UnmatchBLVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}		
	

	/**
	 * Self Audit - RFA F SurchargeDiscrepancy Detail 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg

	 * @return List<UnmatchBLVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UnmatchBLVO> selectCheckRfaSurchargeDiscrepancyDetail(String bkgNo, String caFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<UnmatchBLVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOCheckRfaSurchargeDiscrepancyDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UnmatchBLVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	/**
	 * 특정 국가 특정 surcharge에 대해 RFA SurchargeDiscrepancy Detail 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @param String cntCd
	 * @return String[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String[] selectCheckRfaSurchargeDiscrepancyDetailByCnt(String bkgNo, String caFlg, String cntCd) throws DAOException {
		DBRowSet dbRowset = null;
		String[] rtn =new String[2];
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			param.put("cnt_cd", cntCd);
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			velParam.put("cnt_cd", cntCd);
			
            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new UnmatchBLDBDAOCheckRfaIndiaSurchargeDiscrepancyDetailRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtn[0] = dbRowset.getString("IHC_FLG");
				rtn[1] = dbRowset.getString("THC_FLG");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtn;
	}
	/**
	 * Self Audit - Void Qty Discrepancy 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UnmatchBLVO> selectAwkwardVoidSlotDiscrepancy(String bkgNo, String caFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<UnmatchBLVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOCheckAwkwardVoidSlotDiscrepancyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UnmatchBLVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	

	/**
	 * Self Audit - TAA A EffectiveDateDiscrepancy 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UnmatchBLVO> selectCheckTaaEffectiveDateDiscrepancy(String bkgNo, String caFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<UnmatchBLVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOCheckTaaEffectiveDateDiscrepancyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UnmatchBLVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * Self Audit - TAA A EffectiveDateDiscrepancy 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UnmatchBLVO> selectCheckTaaApplicationDateDiscrepancy(String bkgNo, String caFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<UnmatchBLVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOCheckTaaApplicationDateDiscrepancyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UnmatchBLVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	
	
	/**
	 * Self Audit - TAA B Customer Code Discrepancy 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UnmatchBLVO> selectCheckTaaCustomerDiscrepancy(String bkgNo, String caFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<UnmatchBLVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOCheckTaaCustomerDiscrepancyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UnmatchBLVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * Self Audit - TAA C Commodity Discrepancy 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UnmatchBLVO> selectCheckTaaCommodityDiscrepancy(String bkgNo, String caFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<UnmatchBLVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOCheckTaaCommodityDiscrepancyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UnmatchBLVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	/**
	 * Self Audit - TAA D Non-Charged B/L 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UnmatchBLVO> selectCheckTaaNonchargedBl(String bkgNo, String caFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<UnmatchBLVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOCheckTaaNonchargedBlRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UnmatchBLVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}		
	
	/**
	 * Self Audit - TAA E OftDiscrepancy 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UnmatchBLVO> selectCheckTaaOftDiscrepancy(String bkgNo, String caFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<UnmatchBLVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOCheckTaaOftDiscrepancyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UnmatchBLVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}		
	
	/**
	 * Self Audit - TAA E OftDiscrepancy Detail 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UnmatchBLVO> selectCheckTaaOftDiscrepancyDetail(String bkgNo, String caFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<UnmatchBLVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOCheckTaaOftDiscrepancyDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UnmatchBLVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}		
	
	/**
	 * Self Audit - TAA F SurchargeDiscrepancy 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UnmatchBLVO> selectCheckTaaSurchargeDiscrepancy(String bkgNo, String caFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<UnmatchBLVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOCheckTaaSurchargeDiscrepancyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UnmatchBLVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}		
	
	
	/**
	 * Self Audit - TAA F SurchargeDiscrepancy Detail 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UnmatchBLVO> selectCheckTaaSurchargeDiscrepancyDetail(String bkgNo, String caFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<UnmatchBLVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOCheckTaaSurchargeDiscrepancyDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UnmatchBLVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}		
	
	/**
	 * booking status 가 X 일때 Re Audit 상태를 업데이트 한다.<br>
	 * 
	 * @param UnmatchBLVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int modifyReauditUnmatchBLStatus(UnmatchBLVO vo) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new UnmatchBLDBDAOModifyReauditUnmatchBLStatusUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) 
				throw new DAOException("Fail to modifyReauditUnmatchBLStatus SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * 신규생성된 BKG_REV_UMCH_BKG 테이블을 새로이 갱신한다.<br>
	 * 
	 * @param UnmatchBLVO vo
	 * @return int
	 * @exception DAOException
	*/
	public int modifyCompareBkgRevUmchBkg(UnmatchBLVO vo) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new UnmatchBLDBDAOModifyCompareBkgRevUmchBkgUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) 
				throw new DAOException("Fail to modifyCompareBkgRevUmchBkg SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * RFA Surcharge를 생성한다.<br>
	 * 
	 * @param List<CreateSurchargeInputVO> insModels
	 * @exception DAOException
	 */
	public void createRfaSurchargeInput(List<CreateSurchargeInputVO> insModels) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		int insCnt[] = null;
		try {
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new UnmatchBLDBDAOCreateRfaSurchargeInputCSQL(), insModels, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " createRfaSurchargeInput SQL");
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
	 * TAA Surcharge를 생성한다.<br>
	 * 
	 * @param List<CreateSurchargeInputVO> insModels
	 * @exception DAOException
	 */
	public void createTaaSurchargeInput(List<CreateSurchargeInputVO> insModels) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		int insCnt[] = null;
		try {
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new UnmatchBLDBDAOCreateTaaSurchargeInputCSQL(), insModels, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " createTaaSurchargeInput SQL");
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
	 * SC Surcharge를 생성한다.<br>
	 * 
	 * @param List<CreateSurchargeInputVO> insModels
	 * @exception DAOException
	 */
	public void createScSurchargeInput(List<CreateSurchargeInputVO> insModels) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		int insCnt[] = null;
		try {
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new UnmatchBLDBDAOCreateScSurchargeInputCSQL(), insModels, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " createRfaSurchargeInput SQL");
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
	 * OFT성 Charge의 개수를 조회한다.<br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return int
	 * @exception DAOException
	 */

	 public int searchOftChargeCount(String bkgNo, String caFlg) throws DAOException {
		 DBRowSet dbRowset = null;
		 int cnt = 0;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 param.put   ("bkg_no", bkgNo);			 
			 velParam.put("bkg_no", bkgNo);
			 param.put   ("ca_flg", caFlg);			 
			 velParam.put("ca_flg", caFlg);

			 dbRowset = new SQLExecuter().executeQuery(new UnmatchBLDBDAOSearchOftChargeCountRSQL(), param, velParam);
			 if(dbRowset.next()) {
				 cnt = dbRowset.getInt("cnt");
			 }
		 }catch(SQLException ex){
			 //log.error(ex.getMessage(), ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }catch(Exception ex){
			 //log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }

		 return cnt;
	 }

	/**
	 * RFA, TAA RevenueAuditOft를 생성한다.<br>
	 * 
	 * @return int
	 * @exception DAOException
	 */
	public int createRevenueAuditOft() throws DAOException, Exception {
		int result = 0;
		SQLExecuter sqlExe = new SQLExecuter("");		
		try {
			result = sqlExe.executeUpdate((ISQLTemplate)new UnmatchBLDBDAOCreateRevenueAuditOftCSQL(), null, null);
			if(result == Statement.EXECUTE_FAILED) 
				throw new DAOException("Fail to createRevenueAuditOft SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * Group & Multi B/L Rating을위해 RevenueAuditOft를 생성한다.<br>
	 * 
	 * @return int
	 * @exception DAOException
	 */
	public int createRevenueAuditOftForMultiRating() throws DAOException, Exception {
		int result = 0;
		SQLExecuter sqlExe = new SQLExecuter("");		
		try {
			result = sqlExe.executeUpdate((ISQLTemplate)new UnmatchBLDBDAOCreateRevenueAuditOftForMultiRatingCSQL(), null, null);
			if(result == Statement.EXECUTE_FAILED) 
				throw new DAOException("Fail to createRevenueAuditOft SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * RFA, TAA RevenueAudit Surcharge를 생성한다.<br>
	 * 
	 * @param List<SearchScOftAutoratingListVO> insModels
	 * @exception DAOException
	 */
	public void createRevenueAuditSurcharge(List<SearchScOftAutoratingListVO> insModels) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		int insCnt[] = null;
		try {
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new UnmatchBLDBDAOCreateRevenueAuditSurchargeCSQL(), insModels, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " createRevenueAuditSurcharge SQL");
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
	 * 특정 SC에 대해 OTH <> ORC 상호 호환하여 심사할 수 있도록 Charge Code를 업데이트<br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @exception DAOException
	 */
	public void modifyORCOTHChargeRate(String bkgNo, String caFlg) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);

			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new UnmatchBLDBDAOModifyORCOTHChargeRateUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modifyORCOTHChargeRate SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * 비교 데이터 생성위한 maxseq 를 조회한다. <br>
	 * 
	 * @param UnmatchBLVO pVo
	 * @return String
	 * @exception DAOExceptio
	 */
	public String searchMaxUmchBkgSeq(UnmatchBLVO pVo) throws DAOException {
		String maxUmchBkgSeq = "0";
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if(pVo != null){
				Map<String, String> mapVO = pVo.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOSearchMaxUmchBkgSeqRSQL(), param, null);
			if(dbRowset.next()){
				maxUmchBkgSeq = dbRowset.getString("MAX_UMCH_BKG_SEQ");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return maxUmchBkgSeq;
	}		
	
	
	/**
	 * 비교할 Unmatch 데이터를 BKG_REV_UMCH_BKG 테이블에 임시 생성한다.<br>
	 * 
	 * @param UnmatchBLVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int addCompareBkgRevUmchBkg(UnmatchBLVO vo) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		SQLExecuter sqlExe = new SQLExecuter("");
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			result = sqlExe.executeUpdate((ISQLTemplate)new UnmatchBLDBDAOAddCompareBkgRevUmchBkgCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) 
				throw new DAOException("Fail to addCompareBkgRevUmchBkg SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * 비교할 Unmatch 데이터를 BKG_REV_UMCH_ITMG 테이블에 임시 생성한다.<br>
	 * 
	 * @param UnmatchBLVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int addCompareBkgRevUmchItm(UnmatchBLVO vo) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		SQLExecuter sqlExe = new SQLExecuter("");
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			result = sqlExe.executeUpdate((ISQLTemplate)new UnmatchBLDBDAOAddCompareBkgRevUmchItmCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) 
				throw new DAOException("Fail to addCompareBkgRevUmchItm SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * 비교할 Unmatch 데이터를 BKG_REV_UMCH_ITMG_DTL 테이블에 임시 생성한다.<br>
	 * 
	 * @param UnmatchBLVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int addCompareBkgRevUmchItmDtl(UnmatchBLVO vo) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		SQLExecuter sqlExe = new SQLExecuter("");
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			result = sqlExe.executeUpdate((ISQLTemplate)new UnmatchBLDBDAOAddCompareBkgRevUmchItmDtlCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) 
				throw new DAOException("Fail to addCompareBkgRevUmchItmDtl SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * BKG_REV_UMCH_BKG 상태를 비교 조회한다. <br>
	 * 
	 * @param UnmatchBLVO pVo
	 * @return String
	 * @exception DAOException
	 */
	public String selectCompareBkgRevUmchBkg(UnmatchBLVO pVo) throws DAOException {
		String cnt = "0";
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if(pVo != null){
				Map<String, String> mapVO = pVo.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOSelectCompareBkgRevUmchBkgRSQL(), param, null);
			if(dbRowset.next()){
				cnt = dbRowset.getString("CNT"); 
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cnt;
	}		
	
	/**
	 * BKG_REV_UMCH_ITM 상태를 비교 조회한다. <br>
	 * 
	 * @param UnmatchBLVO pVo
	 * @return String
	 * @exception DAOException
	 */
	public String selectCompareBkgRevUmchItm(UnmatchBLVO pVo) throws DAOException {
		String cnt = "0";
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if(pVo != null){
				Map<String, String> mapVO = pVo.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOSelectCompareBkgRevUmchItmRSQL(), param, null);
			if(dbRowset.next()){
				cnt = dbRowset.getString("CNT"); 
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cnt;
	}		
	
	/**
	 * BKG_REV_UMCH_ITM_DTL 상태를 비교 조회한다. <br>
	 * 
	 * @param UnmatchBLVO pVo
	 * @return String
	 * @exception DAOException
	 */
	public String selectCompareBkgRevUmchItmDtl(UnmatchBLVO pVo) throws DAOException {
		String cnt = "0";
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if(pVo != null){
				Map<String, String> mapVO = pVo.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOSelectCompareBkgRevUmchItmDtlRSQL(), param, null);
			if(dbRowset.next()){
				cnt = dbRowset.getString("CNT"); 
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cnt;
	}		
	
	/**
	 * 비교 Unmatch 데이터 BKG_REV_UMCH_BKG를 삭제한다.<br>
	 * 
	 * @param UnmatchBLVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int removeCompareBkgRevUmchBkg(UnmatchBLVO vo) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		SQLExecuter sqlExe = new SQLExecuter("");
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			result = sqlExe.executeUpdate((ISQLTemplate)new UnmatchBLDBDAORemoveCompareBkgRevUmchBkgDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) 
				throw new DAOException("Fail to removeCompareBkgRevUmchBkg SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * 비교 Unmatch 데이터 BKG_REV_UMCH_ITM를 삭제한다.<br>
	 * 
	 * @param UnmatchBLVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int removeCompareBkgRevUmchItm(UnmatchBLVO vo) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		SQLExecuter sqlExe = new SQLExecuter("");
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			result = sqlExe.executeUpdate((ISQLTemplate)new UnmatchBLDBDAORemoveCompareBkgRevUmchItmDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) 
				throw new DAOException("Fail to removeCompareBkgRevUmchItm SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * 비교 Unmatch 데이터 BKG_REV_UMCH_ITM_DTL를 삭제한다.<br>
	 * 
	 * @param UnmatchBLVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int removeCompareBkgRevUmchItmDtl(UnmatchBLVO vo) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		SQLExecuter sqlExe = new SQLExecuter("");
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			result = sqlExe.executeUpdate((ISQLTemplate)new UnmatchBLDBDAORemoveCompareBkgRevUmchItmDtlDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) 
				throw new DAOException("Fail to removeCompareBkgRevUmchItmDtl SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * BKG_REV_UMCH_BKG 테이블의 LST_UMCH_FND_DT 를 갱신한다.<br>
	 * 
	 * @param UnmatchBLVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int modifyCompareBkgRevUmchBkgFndDt(UnmatchBLVO vo) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		SQLExecuter sqlExe = new SQLExecuter("");
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			result = sqlExe.executeUpdate((ISQLTemplate)new UnmatchBLDBDAOModifyCompareBkgRevUmchBkgFndDtUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) 
				throw new DAOException("Fail to modifyCompareBkgRevUmchBkgFndDt SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * RFA, TAA 심사 에서 OFT 와 SURCHARGE Autorating 을 Call 할때 필요한 rtAplyDt 를 YYYYMMDD 형식으로 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return String
	 * @exception DAOException
	 */
	public String searchAuditRtAplyDt(String bkgNo, String caFlg) throws DAOException {
		String rtAplyDt = "";
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);

			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOSearchAuditRtAplyDtRSQL(), param, velParam);
			if(dbRowset.next()){
				rtAplyDt = dbRowset.getString("RT_APLY_DT");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtAplyDt;
	}		

	/**
	 * RDN 자동 발행 대상을 조회
	 * 
	 * @param UnmatchBLVO unmatchBLVO
	 * @return AutoRdnInfoVO
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public AutoRdnInfoVO searchAutoRdnInfo(UnmatchBLVO unmatchBLVO) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		AutoRdnInfoVO autoRdnInfoVO = null;
		try {
			if (unmatchBLVO != null) {
				Map<String, String> mapVO = unmatchBLVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UnmatchBLDBDAOSearchAutoRdnInfoRSQL(), param, velParam);
			List<AutoRdnInfoVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, AutoRdnInfoVO.class);
			if (list.size() > 0) {
				autoRdnInfoVO = list.get(0);
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return autoRdnInfoVO;
	}
	 
	    /**
	     * Audit by CNTR Qty Discrepancy 리스트를  Container 별로 조회한다. <br>
	     * @param EqSubErrSchVO eqSubErrSchVO
	     * @return List<EqSubErrSchVO>
	     * @exception DAOException
	     */
	    @SuppressWarnings("unchecked")
	    public List<EqSubErrSchVO> searchAuditByEqSubErrList(EqSubErrSchVO eqSubErrSchVO) throws DAOException {
	        DBRowSet dbRowset = null;
	        List<EqSubErrSchVO> list = null;
	        Map<String, Object> param = new HashMap<String, Object>();
	        Map<String, Object> velParam = new HashMap<String, Object>();
	        try {
	            if (eqSubErrSchVO != null) {
	                Map<String, String> mapVO = eqSubErrSchVO.getColumnValues();
	                param.putAll(mapVO);
	                velParam.putAll(mapVO);
	            }
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UnmatchBLDBDAOSearchAuditByEqSubErrListRSQL(), param, velParam);
	            list = (List) RowSetUtil.rowSetToVOs(dbRowset, EqSubErrSchVO.class);
	            
	        } catch (SQLException se) {
	            log.error(se.getMessage(), se);
	            throw new DAOException(new ErrorHandler(se).getMessage());
	        } catch (Exception ex) {
	            log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }
	        return list;
	    }
	    
	    /**
	     * Audit Remark를 수정한다. <br>
	     * 
	     * @param EqSubErrSchVO eqSubErrSchVO
	     * @param SignOnUserAccount account
	     * @return int
	     * @exception DAOException
	     * @throws Exception 
	     */
	    
	  	public int modifyAuditRmkByEqSubErrList(EqSubErrSchVO eqSubErrSchVO, SignOnUserAccount account) throws DAOException,Exception {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			try {
				Map<String, String> mapVO = eqSubErrSchVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("upd_usr_id", account.getUpd_usr_id());
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new UnmatchBLDBDAOModifyAuditRmkByEqSubErrListUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modifyAuditRmkByEqSubErrList SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return result;
		}
	  	
	    /**
	     * Audit Remark를 생성한다. <br>
	     * 
	     * @param EqSubErrSchVO eqSubErrSchVO
	     * @param SignOnUserAccount account
	     * @return int
	     * @exception DAOException
	     */
	    @SuppressWarnings("unchecked")
	  	public int addAuditRmkByEqSubErrList(EqSubErrSchVO eqSubErrSchVO, SignOnUserAccount account) throws DAOException,Exception {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			try {
				Map<String, String> mapVO = eqSubErrSchVO.getColumnValues();
				param.putAll(mapVO);
				param.put("cre_usr_id", account.getCre_usr_id());
				param.put("upd_usr_id", account.getUpd_usr_id());
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new UnmatchBLDBDAOAddAuditRmkByEqSubErrListCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modifyUnmatchBLRmk SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return result;
		}
	    
		/**
		 * RFA, TAA 심사 에서 OFT 와 SURCHARGE Autorating 을 Call 할때 필요한 rtAplyDt 를 YYYYMMDD 형식으로 조회한다. <br>
		 * 
		 * @param String bkgNo
		 * @param String caFlg
		 * @return String
		 * @exception DAOException
		 */
		public String checkTotalBlAmount(String bkgNo, String caFlg) throws DAOException {
			String passFlg = "N";
			DBRowSet dbRowset = null;
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				
				param.put("bkg_no", bkgNo);
				param.put("ca_flg", caFlg);

				velParam.put("bkg_no", bkgNo);
				velParam.put("ca_flg", caFlg);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOCheckTotalBlAmountRSQL(), param, velParam);
				if(dbRowset.next()){
					passFlg = "Y";
				}
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return passFlg;
		}
	    
	    /**
	     * COD BKG Inquiry 리스트를 조회한다. <br>
	     * 
	     * @param CODBookingListInVO vo
	     * @return List<CODBookingListOutVO>
	     * @exception DAOException
	     */
	    @SuppressWarnings("unchecked")
	    public List<CODBookingListOutVO> searchCODBookingList(CODBookingListInVO vo) throws DAOException {
	        DBRowSet dbRowset = null;
	        List<CODBookingListOutVO> list = null;
	        Map<String, Object> param = new HashMap<String, Object>();
	        Map<String, Object> velParam = new HashMap<String, Object>();
	        try {
	            if (vo != null) {
	                Map<String, String> mapVO = vo.getColumnValues();
	                param.putAll(mapVO);
	                velParam.putAll(mapVO);
	            }
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UnmatchBLDBDAOSearchCODBookingListRSQL(), param, velParam);
	            list = (List) RowSetUtil.rowSetToVOs(dbRowset, CODBookingListOutVO.class);
	        } catch (SQLException se) {
	            log.error(se.getMessage(), se);
	            throw new DAOException(new ErrorHandler(se).getMessage());
	        } catch (Exception ex) {
	            log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }
	        return list;
	    }
	    
	    /**
	     * Merchant Request에 의한 Diversion C/A 목록을 조회한다 <br>
	     * 
	     * @param DiversionCAVO vo
	     * @return List<DiversionCAVO>
	     * @exception DAOException
	     */
	    @SuppressWarnings("unchecked")
	    public List<DiversionCAVO> searchDiversionCAList(DiversionCAVO vo) throws DAOException {
	        DBRowSet dbRowset = null;
	        List<DiversionCAVO> list = null;
	        Map<String, Object> param = new HashMap<String, Object>();
	        Map<String, Object> velParam = new HashMap<String, Object>();
	        try {
	            if (vo != null) {
	                Map<String, String> mapVO = vo.getColumnValues();
	                param.putAll(mapVO);
	                velParam.putAll(mapVO);
	            }
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UnmatchBLDBDAOSearchDiversionCAListRSQL(), param, velParam);
	            list = (List) RowSetUtil.rowSetToVOs(dbRowset, DiversionCAVO.class);
	        } catch (SQLException se) {
	            log.error(se.getMessage(), se);
	            throw new DAOException(new ErrorHandler(se).getMessage());
	        } catch (Exception ex) {
	            log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }
	        return list;
	    }
	    
	    /**
	     * COD BKG Inquiry 화면에서 remark update와 create 을 분기한다 <br>
	     * @param CODBookingListOutVO vo 
	     * @return String
	     * @exception DAOException
	     */
	   
	    public String searchByCodBookingList(CODBookingListOutVO vo) throws DAOException {
	        DBRowSet dbRowset = null;
	        Map<String, Object> param = new HashMap<String, Object>();
	        Map<String, Object> velParam = new HashMap<String, Object>();
	        String rtn = "";
	        try {
	            if (vo != null) {
	                Map<String, String> mapVO = vo.getColumnValues();
	                param.putAll(mapVO);
	                velParam.putAll(mapVO);
	            }

	            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new UnmatchBLDBDAOCodBookingListRSQL(), param, param);
				if (dbRowset.next()) {
					rtn = dbRowset.getString(1);
				}
	            
	        } catch (SQLException se) {
	            log.error(se.getMessage(), se);
	            throw new DAOException(new ErrorHandler(se).getMessage());
	        } catch (Exception ex) {
	            log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }
	        return rtn;
	    }
	    
	    /**
	     * COD BKG Inquiry Remark를 수정한다. <br>
	     * @param CODBookingListOutVO vo 
	     * @param SignOnUserAccount account
	     * @return int
	     * @exception DAOException
	     */
	   
	  	public int modifyCodBookingList(CODBookingListOutVO vo, SignOnUserAccount account) throws DAOException,Exception {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			//parameter Setting
			//Map<String, String> mapVO = null;
			
			int result = 0;
			try {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put("usr_id", account.getUsr_id());
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new UnmatchBLDBDAOModifyCodBookingListUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modifyUnmatchBLRmk SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return result;
		}
		 
	    /**
	     * COD BKG Inquiry Remark를 생성한다. <br>
	     * @param CODBookingListOutVO vo 
	     * @param SignOnUserAccount account
	     * @return int
	     * @exception DAOException
	     */
	  
	  	public int createCodBookingList(CODBookingListOutVO vo, SignOnUserAccount account) throws DAOException,Exception {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			//parameter Setting
			//Map<String, String> mapVO = null;
			
			int result = 0;
			try {
				Map<String, String> mapVO = vo.getColumnValues();
				//mapVO.put("usrId", usrId);
				param.putAll(mapVO);
				param.put("usr_id", account.getUsr_id());
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new UnmatchBLDBDAOModifyCodBookingListCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modifyUnmatchBLRmk SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return result;
		}		
		 
		 
	    
	    /**
	     * 심사를 위한 AK BKG 리스트를 조회한다.  <br>
	     * @param AwkwardBKGListForAuditVO vo
	     * @return List<AwkwardBKGListForAuditVO>
	     * @exception DAOException
	     */
	    @SuppressWarnings("unchecked")
	    public List<AwkwardBKGListForAuditVO> searchAwkwardBKGListforAudit(AwkwardBKGListForAuditVO vo) throws DAOException {
	        DBRowSet dbRowset = null;
	        List<AwkwardBKGListForAuditVO> list = null;
	        Map<String, Object> param = new HashMap<String, Object>();
	        Map<String, Object> velParam = new HashMap<String, Object>();
	        try {
	            if (vo != null) {
	                Map<String, String> mapVO = vo.getColumnValues();
	                param.putAll(mapVO);
	                velParam.putAll(mapVO);
	                
	                String cntrTpszCdList = vo.getCntrTpszCd();
					if( cntrTpszCdList != null &&  cntrTpszCdList.length() != 0 ){
						List<String> cntrTpszCdListArr = new ArrayList<String>();
						StringTokenizer st = new StringTokenizer(cntrTpszCdList, ",");
						while(st.hasMoreTokens()){
							cntrTpszCdListArr.add(st.nextToken());
						}
						param.put("cntr_tpsz_cd_list", cntrTpszCdListArr);
						velParam.put("cntr_tpsz_cd_list", cntrTpszCdListArr);
					}
	            }
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UnmatchBLDBDAOSearchAwkwardBKGListForAuditRSQL(), param, velParam);
	            list = (List) RowSetUtil.rowSetToVOs(dbRowset, AwkwardBKGListForAuditVO.class);
	            
	        } catch (SQLException se) {
	            log.error(se.getMessage(), se);
	            throw new DAOException(new ErrorHandler(se).getMessage());
	        } catch (Exception ex) {
	            log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }
	        return list;
	    }
		 
		 
	    
	    /**
	     * AK Application vs Bay Plan Discrepancy 조회 <br>
	     * @param BKGvsBayPlanVO vo
	     * @return List<BKGvsBayPlanVO>
	     * @exception DAOException
	     */
	    @SuppressWarnings("unchecked")
	    public List<BKGvsBayPlanVO> searchAwkwardBKGvsBayPlanList(BKGvsBayPlanVO vo) throws DAOException {
	        DBRowSet dbRowset = null;
	        List<BKGvsBayPlanVO> list = null;
	        Map<String, Object> param = new HashMap<String, Object>();
	        Map<String, Object> velParam = new HashMap<String, Object>();
	        try {
	            if (vo != null) {
	                Map<String, String> mapVO = vo.getColumnValues();
	                param.putAll(mapVO);
	                velParam.putAll(mapVO);
	                
	                String cntrTpszCdList = vo.getCntrTpszCd();
					if( cntrTpszCdList != null &&  cntrTpszCdList.length() != 0 ){
						List<String> cntrTpszCdListArr = new ArrayList<String>();
						StringTokenizer st = new StringTokenizer(cntrTpszCdList, ",");
						while(st.hasMoreTokens()){
							cntrTpszCdListArr.add(st.nextToken());
						}
						param.put("cntr_tpsz_cd_list", cntrTpszCdListArr);
						velParam.put("cntr_tpsz_cd_list", cntrTpszCdListArr);
					}
	            }
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UnmatchBLDBDAOSearchAwkwardBKGvsBayPlanListRSQL(), param, velParam);
	            list = (List) RowSetUtil.rowSetToVOs(dbRowset, BKGvsBayPlanVO.class);
	            
	        } catch (SQLException se) {
	            log.error(se.getMessage(), se);
	            throw new DAOException(new ErrorHandler(se).getMessage());
	        } catch (Exception ex) {
	            log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }
	        return list;
	    }
		 
		 
	    
	    /**
	     * 심사를 위한 IHC BKG 리스트를 조회한다.  <br>
	     * @param IhcBKGListForAuditVO vo
	     * @return List<IhcBKGListForAuditVO>
	     * @exception DAOException
	     */
	    @SuppressWarnings("unchecked")
	    public List<IhcBKGListForAuditVO> searchIhcBKGListforAudit(IhcBKGListForAuditVO vo) throws DAOException {
	        DBRowSet dbRowset = null;
	        List<IhcBKGListForAuditVO> list = null;
	        Map<String, Object> param = new HashMap<String, Object>();
	        Map<String, Object> velParam = new HashMap<String, Object>();
	        try {
	            if (vo != null) {
	                Map<String, String> mapVO = vo.getColumnValues();
	                param.putAll(mapVO);
	                velParam.putAll(mapVO);
	            }
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UnmatchBLDBDAOSearchIhcBKGListForAuditRSQL(), param, velParam);
	            list = (List) RowSetUtil.rowSetToVOs(dbRowset, IhcBKGListForAuditVO.class);
	            
	        } catch (SQLException se) {
	            log.error(se.getMessage(), se);
	            throw new DAOException(new ErrorHandler(se).getMessage());
	        } catch (Exception ex) {
	            log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }
	        return list;
	    }
	    
	    /**
	     * 소급적용 BKG 리스트를 조회한다.  <br>
	     * @param RetroActFilterSchVO vo
	     * @return List<RsltSearchRetroActFilterVO>
	     * @exception DAOException
	     */
	    @SuppressWarnings("unchecked")
	    public List<RsltSearchRetroActFilterVO> searchRetroactBLFilterList(RetroActFilterSchVO vo) throws DAOException {
	        DBRowSet dbRowset = null;
	        List<RsltSearchRetroActFilterVO> list = null;
	        Map<String, Object> param = new HashMap<String, Object>();
	        Map<String, Object> velParam = new HashMap<String, Object>();
	        try {
	            if (vo != null) {
	                Map<String, String> mapVO = vo.getColumnValues();
	                
	                mapVO.put("retroact_day", vo.getRetroactDay());
	                
	                if("W1".equals(vo.getRetroactDay())){
	                	mapVO.put("rtro_fm_dt", "1");
						mapVO.put("rtro_to_dt", "7");
	                }else if ("W2".equals(vo.getRetroactDay())){
	                	mapVO.put("rtro_fm_dt", "8");
						mapVO.put("rtro_to_dt", "14");
	                }else if ("W3".equals(vo.getRetroactDay())){
	                	mapVO.put("rtro_fm_dt", "15");
						mapVO.put("rtro_to_dt", "21");
	                }else if ("W4".equals(vo.getRetroactDay())){
	                	mapVO.put("rtro_fm_dt", "22");
						mapVO.put("rtro_to_dt", "28");
	                }else if ("W5".equals(vo.getRetroactDay())){
	                	mapVO.put("rtro_fm_dt", "29");
						mapVO.put("rtro_to_dt", "35");
	                }else if ("W6".equals(vo.getRetroactDay())){
	                	mapVO.put("rtro_fm_dt", "36");
						mapVO.put("rtro_to_dt", "9999");
	                }else {
		                mapVO.put("retroact_day", vo.getRetroactDay());
	                }
	                
	                param.putAll(mapVO);
	                velParam.putAll(mapVO);
	            }
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UnmatchBLDBDAOsearchRetroactiveBLFilterListRSQL(), param, velParam);
	            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltSearchRetroActFilterVO.class);
	            
	        } catch (SQLException se) {
	            log.error(se.getMessage(), se);
	            throw new DAOException(new ErrorHandler(se).getMessage());
	        } catch (Exception ex) {
	            log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }
	        return list;
	    }
	    
	    
	    /**
	     * TXS BKG List for Audit 리스트를 조회한다.  <br>
	     * @param TxsBkgListForAuditSchVO vo
	     * @return List<TxsBkgListForAuditVO>
	     * @exception DAOException
	     */
	    @SuppressWarnings("unchecked")
	    public List<TxsBkgListForAuditVO> searchTxsBkgListForAudit(TxsBkgListForAuditSchVO vo) throws DAOException {
	        DBRowSet dbRowset = null;
	        List<TxsBkgListForAuditVO> list = null;
	        Map<String, Object> param = new HashMap<String, Object>();
	        Map<String, Object> velParam = new HashMap<String, Object>();
	        try {
	            if (vo != null) {
	                Map<String, String> mapVO = vo.getColumnValues();
	                param.putAll(mapVO);
	                velParam.putAll(mapVO);
	            }
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UnmatchBLDBDAOSearchTxsBkgListForAuditRSQL(), param, velParam);
	            list = (List) RowSetUtil.rowSetToVOs(dbRowset, TxsBkgListForAuditVO.class);
	            
	        } catch (SQLException se) {
	            log.error(se.getMessage(), se);
	            throw new DAOException(new ErrorHandler(se).getMessage());
	        } catch (Exception ex) {
	            log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }
	        return list;
	    }
	    
	    /**
	     * Stop Off BKG List for Audit 정보를 조회한다.<br>
	     *
	     * @param String fmDt
	     * @param String toDt
	     * @return List<SearchStopOffBkgListforAuditVO>
	     * @exception DAOException
	     */
	    public List<SearchStopOffBkgListforAuditVO> searchStopOffBkgListforAudit(String fmDt, String toDt) throws DAOException {
	        DBRowSet dbRowset = null;
	        List<SearchStopOffBkgListforAuditVO> searchStopOffBkgListforAuditVOList = null;
	        //query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        //velocity parameter
	        Map<String, Object> velParam = new HashMap<String, Object>();

	        try{
	            Map<String, String> mapVO = new HashMap();

	            mapVO.put("fm_dt" , fmDt);
	            mapVO.put("to_dt" , toDt);

	            param.putAll(mapVO);
	            velParam.putAll(mapVO);

	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOSearchStopOffBkgListforAuditRSQL(), param, velParam);
	            searchStopOffBkgListforAuditVOList = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchStopOffBkgListforAuditVO.class);
	        }catch(SQLException se){
	            log.error(se.getMessage(),se);
	            throw new DAOException(new ErrorHandler(se).getMessage(), se);
	        }catch(Exception ex){
	            log.error(ex.getMessage(),ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        }
	        return searchStopOffBkgListforAuditVOList;
	    }	    	
		 
		 
	    
	    /**
	     * 심사를 위해 특정 Rule Type (Conversion Table상 Code)을 포함하는 SC Note를 조회 <br>
	     * @param ScNoteConversionVO vo
	     * @return List<ScNoteConversionVO>
	     * @exception DAOException
	     */
	    @SuppressWarnings("unchecked")
	    public List<ScNoteConversionVO> searchScNoteConversionListByRule(ScNoteConversionVO vo) throws DAOException {
	        DBRowSet dbRowset = null;
	        List<ScNoteConversionVO> list = null;
	        Map<String, Object> param = new HashMap<String, Object>();
	        Map<String, Object> velParam = new HashMap<String, Object>();
	        try {
	            if (vo != null) {
	                Map<String, String> mapVO = vo.getColumnValues();
	                param.putAll(mapVO);
	                velParam.putAll(mapVO);
	            }
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UnmatchBLDBDAOSearchScNoteConversionListByRuleRSQL(), param, velParam);
	            list = (List) RowSetUtil.rowSetToVOs(dbRowset, ScNoteConversionVO.class);
	            
	        } catch (SQLException se) {
	            log.error(se.getMessage(), se);
	            throw new DAOException(new ErrorHandler(se).getMessage());
	        } catch (Exception ex) {
	            log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }
	        return list;
	    }   	
		 
		 
	    
	    /**
	     * BKG별 Bay Plan을 조회한다.<br>
	     * @param String bkgNo
	     * @return List<BayPlanVO>
	     * @exception DAOException
	     */
	    @SuppressWarnings("unchecked")
	    public List<BayPlanVO> searchBayPlanByBooking(String bkgNo) throws DAOException {
	        DBRowSet dbRowset = null;
	        List<BayPlanVO> list = null;
	        Map<String, Object> param = new HashMap<String, Object>();
	        Map<String, Object> velParam = new HashMap<String, Object>();
	        try {
	        	
	        	Map<String, String> mapVO = new HashMap();
	        	mapVO.put("bkg_no" , bkgNo);
	        	param.putAll(mapVO);
	        	
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UnmatchBLDBDAOSearchBayPlanByBookingRSQL(), param, velParam);
	            list = (List) RowSetUtil.rowSetToVOs(dbRowset, BayPlanVO.class);
	            
	        } catch (SQLException se) {
	            log.error(se.getMessage(), se);
	            throw new DAOException(new ErrorHandler(se).getMessage());
	        } catch (Exception ex) {
	            log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }
	        return list;
	    }
		 
	    
	    /**
	     * 심사를 위한 O B/L Surrender 목록을 조회한다.  <br>
	     * @param OblSurrenderForAuditVO vo
	     * @return List<OblSurrenderForAuditVO>
	     * @exception DAOException
	     */
	    @SuppressWarnings("unchecked")
	    public List<OblSurrenderForAuditVO> searchOblSurrenderForAudit(OblSurrenderForAuditVO vo) throws DAOException {
	        DBRowSet dbRowset = null;
	        List<OblSurrenderForAuditVO> list = null;
	        Map<String, Object> param = new HashMap<String, Object>();
	        Map<String, Object> velParam = new HashMap<String, Object>();
	        try {
	            if (vo != null) {
	                Map<String, String> mapVO = vo.getColumnValues();
	                param.putAll(mapVO);
	                velParam.putAll(mapVO);
	            }
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UnmatchBLDBDAOSearchOblSurrenderForAuditRSQL(), param, velParam);
	            list = (List) RowSetUtil.rowSetToVOs(dbRowset, OblSurrenderForAuditVO.class);
	            
	        } catch (SQLException se) {
	            log.error(se.getMessage(), se);
	            throw new DAOException(new ErrorHandler(se).getMessage());
	        } catch (Exception ex) {
	            log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }
	        return list;
	    }
		 
	    
	    /**
	     * 심사를 위한 Non Autorated Charge 목록을 조회한다. <br>
	     * @param NonAutoratedChargeVO vo
	     * @return List<NonAutoratedChargeVO>
	     * @exception DAOException
	     */
	    @SuppressWarnings("unchecked")
	    public List<NonAutoratedChargeVO> searchNonAutoratedChargeForAudit(NonAutoratedChargeVO vo) throws DAOException {
	        DBRowSet dbRowset = null;
	        List<NonAutoratedChargeVO> list = null;
	        Map<String, Object> param = new HashMap<String, Object>();
	        Map<String, Object> velParam = new HashMap<String, Object>();
	        try {
	            if (vo != null) {
	                Map<String, String> mapVO = vo.getColumnValues();
	                param.putAll(mapVO);
	                velParam.putAll(mapVO);
	            }
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UnmatchBLDBDAOSearchNonAutoratedChargeForAuditRSQL(), param, velParam);
	            list = (List) RowSetUtil.rowSetToVOs(dbRowset, NonAutoratedChargeVO.class);
	            
	        } catch (SQLException se) {
	            log.error(se.getMessage(), se);
	            throw new DAOException(new ErrorHandler(se).getMessage());
	        } catch (Exception ex) {
	            log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }
	        return list;
	    }
	    
	    /**
	     * TXS BKG List for Audit 리스트를 조회한다.  <br>
		 * @param WscBkgListForAuditSchVO vo
		 * @return List<WscBkgListForAuditSchVO>
	     * @exception DAOException
	     */
	    @SuppressWarnings("unchecked")
	    public List<WscBkgListForAuditSchVO> searchWscBkgListForAudit(WscBkgListForAuditSchVO vo) throws DAOException {
	        DBRowSet dbRowset = null;
	        List<WscBkgListForAuditSchVO> list = null;
	        Map<String, Object> param = new HashMap<String, Object>();
	        Map<String, Object> velParam = new HashMap<String, Object>();
	        try {
	            if (vo != null) {
	                Map<String, String> mapVO = vo.getColumnValues();
	                param.putAll(mapVO);
	                velParam.putAll(mapVO);
	            }
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UnmatchBLDBDAOSearchWscBkgListForAuditRSQL(), param, velParam);
	            list = (List) RowSetUtil.rowSetToVOs(dbRowset, WscBkgListForAuditSchVO.class);
	            
	        } catch (SQLException se) {
	            log.error(se.getMessage(), se);
	            throw new DAOException(new ErrorHandler(se).getMessage());
	        } catch (Exception ex) {
	            log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }
	        return list;
	    }
	    
	    /**
	     * India Dth BKG 리스트를 조회한다.  <br>
	     * @param IndiaDthBKGListForAuditVO vo
	     * @return List<IndiaDthBKGListForAuditVO>
	     * @exception DAOException
	     */
	    @SuppressWarnings("unchecked")
	    public List<IndiaDthBKGListForAuditVO> searchIndiaDthBKGListforAudit(IndiaDthBKGListForAuditVO vo) throws DAOException {
	        DBRowSet dbRowset = null;
	        List<IndiaDthBKGListForAuditVO> list = null;
	        Map<String, Object> param = new HashMap<String, Object>();
	        Map<String, Object> velParam = new HashMap<String, Object>();
	        try {
	            if (vo != null) {
	                Map<String, String> mapVO = vo.getColumnValues();
	                param.putAll(mapVO);
	                velParam.putAll(mapVO);
	            }
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UnmatchBLDBDAOSearchIndiaDthBKGListForAuditRSQL(), param, velParam);
	            list = (List) RowSetUtil.rowSetToVOs(dbRowset, IndiaDthBKGListForAuditVO.class);
	            
	        } catch (SQLException se) {
	            log.error(se.getMessage(), se);
	            throw new DAOException(new ErrorHandler(se).getMessage());
	        } catch (Exception ex) {
	            log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }
	        return list;
	    }
	    
	    /**
	     * Iran Dth BKG 리스트를 조회한다.  <br>
	     * @param IranDthBKGListForAuditVO vo
	     * @return List<IranDthBKGListForAuditVO> 
	     * @exception DAOException
	     */
	    @SuppressWarnings("unchecked")
	    public List<IranDthBKGListForAuditVO> searchIranDthBKGListforAudit(IranDthBKGListForAuditVO vo) throws DAOException {
	        DBRowSet dbRowset = null;
	        List<IranDthBKGListForAuditVO> list = null;
	        Map<String, Object> param = new HashMap<String, Object>();
	        Map<String, Object> velParam = new HashMap<String, Object>();
	        try {
	            if (vo != null) {
	                Map<String, String> mapVO = vo.getColumnValues();
	                param.putAll(mapVO);
	                velParam.putAll(mapVO);
	            }
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UnmatchBLDBDAOSearchIranDthBKGListForAuditRSQL(), param, velParam);
	            list = (List) RowSetUtil.rowSetToVOs(dbRowset, IranDthBKGListForAuditVO.class);
	            
	        } catch (SQLException se) {
	            log.error(se.getMessage(), se);
	            throw new DAOException(new ErrorHandler(se).getMessage());
	        } catch (Exception ex) {
	            log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }
	        return list;
	    }
	    
	    
		/**
		 * 특정 surcharge에 대해서 심사 결과를 따로 보관하는 국가인지 여부를 조회한다. <br>
		 * 
		 * @param String bkgNo
		 * @return String[]
		 * @exception DAOException
		 */
		@SuppressWarnings("unchecked")
		public String[] searchCntForSurchargeAudit(String bkgNo) throws DAOException {
			DBRowSet dbRowset = null;
			String[] rtn =new String[2];
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				param.put("bkg_no", bkgNo);
				velParam.put("bkg_no", bkgNo);
				
	            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new UnmatchBLDBDAOSearchCntForSurchargeAuditRSQL(), param, velParam);
				if (dbRowset.next()) {
					rtn[0] = dbRowset.getString("POL_CNT_CD");
					rtn[1] = dbRowset.getString("POD_CNT_CD");
				}
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return rtn;
		}
		
		
	    /**
	     * unmatch bl age 리스트를 조회한다.
	     * @param UmchErrBlReportVO vo
	     * @return List<UmchErrBlReportVO>
	     * @throws DAOException
	     */
	    @SuppressWarnings("unchecked")
	    public List<UmchErrBlReportVO> searchUnmatchBLAgingList(UmchErrBlReportVO vo) throws DAOException {
	        DBRowSet dbRowset = null;
	        List<UmchErrBlReportVO> list = null;
	        Map<String, Object> param = new HashMap<String, Object>();
	        Map<String, Object> velParam = new HashMap<String, Object>();
	        try {
	            if (vo != null) {
	                Map<String, String> mapVO = vo.getColumnValues();
	                param.putAll(mapVO); 
	                velParam.putAll(mapVO);
	            }
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UnmatchBLDBDAOSearchUnmatchBLAgingListRSQL(), param, velParam);
	            list = (List) RowSetUtil.rowSetToVOs(dbRowset, UmchErrBlReportVO.class);
	            
	        } catch (SQLException se) {
	            log.error(se.getMessage(), se);
	            throw new DAOException(new ErrorHandler(se).getMessage());
	        } catch (Exception ex) {
	            log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }
	        return list;
	    }
	    
	    
	    /**
	     * 심사를 위해 특정 Rule Type (Conversion Table상 Code)을 포함하는 RFA Note를 조회 <br>
	     * @param ScNoteConversionVO vo
	     * @return List<ScNoteConversionVO>
	     * @exception DAOException
	     */
	    @SuppressWarnings("unchecked")
	    public List<ScNoteConversionVO> searchRfaNoteConversionListByRule(ScNoteConversionVO vo) throws DAOException {
	        DBRowSet dbRowset = null;
	        List<ScNoteConversionVO> list = null;
	        Map<String, Object> param = new HashMap<String, Object>();
	        Map<String, Object> velParam = new HashMap<String, Object>();
	        try {
	            if (vo != null) {
	                Map<String, String> mapVO = vo.getColumnValues();
	                param.putAll(mapVO);
	                velParam.putAll(mapVO);
	            }
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UnmatchBLDBDAOSearchRfaNoteConversionListByRuleRSQL(), param, velParam);
	            list = (List) RowSetUtil.rowSetToVOs(dbRowset, ScNoteConversionVO.class);
	            
	        } catch (SQLException se) {
	            log.error(se.getMessage(), se);
	            throw new DAOException(new ErrorHandler(se).getMessage());
	        } catch (Exception ex) {
	            log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }
	        return list;
	    }   	
	    
	    /**
	     * rating시 OFT가 2개 이상 뜨는 건에 대해 조회한다.
	     * @param MultiRateBkgListVO vo
	     * @return List<MultiRateBkgListVO>
	     * @throws DAOException
	     */
	    @SuppressWarnings("unchecked")
	    public List<MultiRateBkgListVO> searchMultiRateBkgList(MultiRateBkgListVO vo) throws DAOException {
	        DBRowSet dbRowset = null;
	        List<MultiRateBkgListVO> list = null;
	        Map<String, Object> param = new HashMap<String, Object>();
	        Map<String, Object> velParam = new HashMap<String, Object>();
	        try {
	            if (vo != null) {
	                Map<String, String> mapVO = vo.getColumnValues();
	                param.putAll(mapVO);
	                velParam.putAll(mapVO);
	            }
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UnmatchBLDBDAOSearchMultiRateBkgListRSQL(), param, velParam);
	            list = (List) RowSetUtil.rowSetToVOs(dbRowset, MultiRateBkgListVO.class);
	            
	        } catch (SQLException se) {
	            log.error(se.getMessage(), se);
	            throw new DAOException(new ErrorHandler(se).getMessage());
	        } catch (Exception ex) {
	            log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }
	        return list;
	    }   
		
	    /**
	     * Multi Rate BKG List for Audit(1) 조회
	     * @param MultiRateBkgList1VO vo
	     * @return List<MultiRateBkgList1VO>
	     * @throws DAOException
	     */
	    @SuppressWarnings("unchecked")
	    public List<MultiRateBkgList1VO> searchMultiRateBkgList_1(MultiRateBkgList1VO vo) throws DAOException {
	        DBRowSet dbRowset = null;
	        List<MultiRateBkgList1VO> list = null;
	        Map<String, Object> param = new HashMap<String, Object>();
	        Map<String, Object> velParam = new HashMap<String, Object>();
	        try {
	            if (vo != null) {
	                Map<String, String> mapVO = vo.getColumnValues();
	                param.putAll(mapVO);
	                velParam.putAll(mapVO);
	            }
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UnmatchBLDBDAOSearchMultiRateBkgList1RSQL(), param, velParam);
	            list = (List) RowSetUtil.rowSetToVOs(dbRowset, MultiRateBkgList1VO.class);
	        } catch (SQLException se) {
	            log.error(se.getMessage(), se);
	            throw new DAOException(new ErrorHandler(se).getMessage());
	        } catch (Exception ex) {
	            log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }
	        return list;
	    }
	    
	    /**
	     * Multi Rate BKG List for Audit(1) 수정(Save 버튼)
	     * @param voList
	     * @throws DAOException
	     */
	    public void manageMultiRateBkgList_1(List<MultiRateBkgList1VO> voList) throws DAOException {
	    	int updCnt[] = null;
	    	Map<String, Object> velParam = new HashMap<String, Object>();
	    	
	    	try {
	    		SQLExecuter sqlExe = new SQLExecuter("");
	    		
	    		if(voList != null ) {
	    			velParam.put("btn", "SAVE");
	    			updCnt = sqlExe.executeBatch((ISQLTemplate)new UnmatchBLDBDAOManageMultiRateBkgList1USQL(), voList, velParam);
	    			
	    			for(int i = 0; i < updCnt.length; i++){
	                    if(updCnt[i]== Statement.EXECUTE_FAILED)
	                        throw new DAOException("Fail to update No"+ i + " SQL");
	                }
	    		}
	    	} catch(SQLException se){
	            log.error(se.getMessage(),se);
	            log.error("err " + se.toString(), se);
	            throw new DAOException(new ErrorHandler(se).getMessage());
	        } catch(Exception ex){
	            log.error(ex.getMessage(),ex);
	            log.error("err " + ex.toString(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }
	    }
	    
	    /**
	     * Multi Rate BKG List for Audit(1) 확인(Confirm 버튼)
	     * @param voList
	     * @throws DAOException
	     */
	    public void confirmMultiRateBkgList_1(List<MultiRateBkgList1VO> voList) throws DAOException {
	    	int updCnt[] = null;
	    	Map<String, Object> velParam = new HashMap<String, Object>();
	    	
	    	try {
	    		SQLExecuter sqlExe = new SQLExecuter("");
	    		
	    		if(voList != null ) {
	    			velParam.put("btn", "CONFIRM");
	    			updCnt = sqlExe.executeBatch((ISQLTemplate)new UnmatchBLDBDAOManageMultiRateBkgList1USQL(), voList, velParam);
	    			
	    			for(int i = 0; i < updCnt.length; i++){
	                    if(updCnt[i]== Statement.EXECUTE_FAILED)
	                        throw new DAOException("Fail to update No"+ i + " SQL");
	                }
	    		}
	    	} catch(SQLException se){
	            log.error(se.getMessage(),se);
	            log.error("err " + se.toString(), se);
	            throw new DAOException(new ErrorHandler(se).getMessage());
	        } catch(Exception ex){
	            log.error(ex.getMessage(),ex);
	            log.error("err " + ex.toString(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }
	    }
	    
	    /**
	     * Multi Rate BKG List for Audit(1) 확인 취소(Release 버튼)
	     * @param voList
	     * @throws DAOException
	     */
	    public void releaseMultiRateBkgList_1(List<MultiRateBkgList1VO> voList) throws DAOException {
	    	int updCnt[] = null;
	    	Map<String, Object> velParam = new HashMap<String, Object>();
	    	
	    	try {
	    		SQLExecuter sqlExe = new SQLExecuter("");
	    		
	    		if(voList != null ) {
	    			velParam.put("btn", "RELEASE");
	    			updCnt = sqlExe.executeBatch((ISQLTemplate)new UnmatchBLDBDAOManageMultiRateBkgList1USQL(), voList, velParam);
	    			
	    			for(int i = 0; i < updCnt.length; i++){
	                    if(updCnt[i]== Statement.EXECUTE_FAILED)
	                        throw new DAOException("Fail to update No"+ i + " SQL");
	                }
	    		}
	    	} catch(SQLException se){
	            log.error(se.getMessage(),se);
	            log.error("err " + se.toString(), se);
	            throw new DAOException(new ErrorHandler(se).getMessage());
	        } catch(Exception ex){
	            log.error(ex.getMessage(),ex);
	            log.error("err " + ex.toString(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }
	    } 
}