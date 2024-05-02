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
 2011.01.06 이정수 [CHM-201007610] RAS 기능 보완 및 Logic 보완 6
*/
package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration.BookingUtilDBDAOsearchMdmLocPortNameRSQL;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchScOftAutoratingListVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.basic.UnmatchBLBCImpl;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.AutoRdnInfoVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.CreateSurchargeInputVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchAuditByCNTRQtyDiscrepancyListVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchAuditByCommodityAndRouteListVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchAuditByHangerInstallationListVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchChargeFilteringListVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchUnmatchItemListVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchUnmatchTypeListVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltUnmatchBLListbyAuditorVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltUnmatchDiffAmountVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltUnmatchStatusReportVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.UnmatchBLVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.ScNoteConversionVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.BkgRevUmchBkgVO;


/**
 * OPUS UnmatchBLDBDAO <br>
 * - OPUS-RevenueAudit system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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
		String rdn_no = "";
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
				rdn_no = dbRowset.getString("FILERED_BKG_COUNT");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rdn_no;
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
	 * @return int
	 * @exception DAOException
	 */
	public int modifyUnmatchBLRmk(BkgRevUmchBkgVO vo) throws DAOException,Exception {
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
	 * @return List<UnmatchBLVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UnmatchBLVO> searchBkgCaFlg(String blNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<UnmatchBLVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("bl_no", blNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAORsltSearchBkgCaFlgRSQL(), param, null);
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
	 * Self Audit - RFA E OftDiscrepancy 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UnmatchBLVO> selectCheckRfaSelfOftDiscrepancy(String bkgNo, String caFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<UnmatchBLVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOCheckRfaSelfOftDiscrepancyRSQL(), param, velParam);
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
	 * @return List<UnmatchBLVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UnmatchBLVO> selectCheckRfaSurchargeDiscrepancy(String bkgNo, String caFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<UnmatchBLVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
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
	 * Self Audit - RFA F SurchargeDiscrepancy 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UnmatchBLVO> selectCheckRfaSelfSurchargeDiscrepancy(String bkgNo, String caFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<UnmatchBLVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOCheckRfaSelfSurchargeDiscrepancyRSQL(), param, velParam);
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
	 * Audit - TAA E OftDiscrepancy 를 조회한다. <br>
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
	 * Self Audit - TAA E OftDiscrepancy 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UnmatchBLVO> selectCheckTaaSelfOftDiscrepancy(String bkgNo, String caFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<UnmatchBLVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOCheckTaaSelfOftDiscrepancyRSQL(), param, velParam);
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
	 * Audit - TAA E OftDiscrepancy Detail 를 조회한다. <br>
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
	 * Self Audit - TAA E OftDiscrepancy Detail 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UnmatchBLVO> selectCheckTaaSelfOftDiscrepancyDetail(String bkgNo, String caFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<UnmatchBLVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOCheckTaaSelfOftDiscrepancyDetailRSQL(), param, velParam);
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
	 * Audit - TAA F SurchargeDiscrepancy 를 조회한다. <br>
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
	 * Self Audit - TAA F SurchargeDiscrepancy 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UnmatchBLVO> selectCheckTaaSelfSurchargeDiscrepancy(String bkgNo, String caFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<UnmatchBLVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOCheckTaaSelfSurchargeDiscrepancyRSQL(), param, velParam);
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
	 * Audit - TAA F SurchargeDiscrepancy Detail 를 조회한다. <br>
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
	 * Self Audit - TAA F SurchargeDiscrepancy Detail 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UnmatchBLVO> selectCheckTaaSelfSurchargeDiscrepancyDetail(String bkgNo, String caFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<UnmatchBLVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOCheckTaaSelfSurchargeDiscrepancyDetailRSQL(), param, velParam);
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
		 * OFT성 Charge의 개수를 조회한다.<br>
		 * 
		 * @param String bkgNo
		 * @return int
		 * @exception DAOException
		 */

		 public int searchOftChargeCount(String bkgNo) throws DAOException {
			 DBRowSet dbRowset = null;
			 int cnt = 0;

			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();

			 try{
				 param.put   ("bkg_no", bkgNo);			 
				 velParam.put("bkg_no", bkgNo);

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
			 * Audit - SC E OftDiscrepancy 를 조회한다. <br>
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
			 * Self Audit - SC E OftDiscrepancy 를 조회한다. <br>
			 * 
			 * @param String bkgNo
			 * @param String caFlg
			 * @return List<UnmatchBLVO>
			 * @exception DAOException
			 */
			@SuppressWarnings("unchecked")
			public List<UnmatchBLVO> selectCheckScSelfOftDiscrepancy(String bkgNo, String caFlg) throws DAOException {
				DBRowSet dbRowset = null;
				List<UnmatchBLVO> list = null;
				Map<String, Object> param = new HashMap<String, Object>();
				Map<String, Object> velParam = new HashMap<String, Object>();
				try{
					param.put("bkg_no", bkgNo);
					param.put("ca_flg", caFlg);
					velParam.put("bkg_no", bkgNo);
					velParam.put("ca_flg", caFlg);
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOCheckScSelfOftDiscrepancyRSQL(), param, velParam);
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
			 * Audit - SC E OftDiscrepancy Detail 를 조회한다. <br>
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
			 * Self Audit - SC E OftDiscrepancy Detail 를 조회한다. <br>
			 * 
			 * @param String bkgNo
			 * @param String caFlg
			 * @return List<UnmatchBLVO>
			 * @exception DAOException
			 */
			@SuppressWarnings("unchecked")
			public List<UnmatchBLVO> selectCheckScSelfOftDiscrepancyDetail(String bkgNo, String caFlg) throws DAOException {
				DBRowSet dbRowset = null;
				List<UnmatchBLVO> list = null;
				Map<String, Object> param = new HashMap<String, Object>();
				Map<String, Object> velParam = new HashMap<String, Object>();
				try{
					param.put("bkg_no", bkgNo);
					param.put("ca_flg", caFlg);
					velParam.put("bkg_no", bkgNo);
					velParam.put("ca_flg", caFlg);
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOCheckScSelfOftDiscrepancyDetailRSQL(), param, velParam);
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
			 * @return List<UnmatchBLVO>
			 * @exception DAOException
			 */
			@SuppressWarnings("unchecked")
			public List<UnmatchBLVO> selectCheckScSurchargeDiscrepancy(String bkgNo, String caFlg) throws DAOException {
				DBRowSet dbRowset = null;
				List<UnmatchBLVO> list = null;
				Map<String, Object> param = new HashMap<String, Object>();
				Map<String, Object> velParam = new HashMap<String, Object>();
				try{
					param.put("bkg_no", bkgNo);
					param.put("ca_flg", caFlg);
					velParam.put("bkg_no", bkgNo);
					velParam.put("ca_flg", caFlg);
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
			 * Self Audit - SC F SurchargeDiscrepancy 를 조회한다. <br>
			 * 
			 * @param String bkgNo
			 * @param String caFlg
			 * @return List<UnmatchBLVO>
			 * @exception DAOException
			 */
			@SuppressWarnings("unchecked")
			public List<UnmatchBLVO> selectCheckScSelfSurchargeDiscrepancy(String bkgNo, String caFlg) throws DAOException {
				DBRowSet dbRowset = null;
				List<UnmatchBLVO> list = null;
				Map<String, Object> param = new HashMap<String, Object>();
				Map<String, Object> velParam = new HashMap<String, Object>();
				try{
					param.put("bkg_no", bkgNo);
					param.put("ca_flg", caFlg);
					velParam.put("bkg_no", bkgNo);
					velParam.put("ca_flg", caFlg);
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOCheckScSelfSurchargeDiscrepancyRSQL(), param, velParam);
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
			 * Audit - SC F SurchargeDiscrepancy Detail 를 조회한다. <br>
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
			 * Self Audit - SC F SurchargeDiscrepancy Detail 를 조회한다. <br>
			 * 
			 * @param String bkgNo
			 * @param String caFlg
			 * @return List<UnmatchBLVO>
			 * @exception DAOException
			 */
			@SuppressWarnings("unchecked")
			public List<UnmatchBLVO> selectCheckScSelfSurchargeDiscrepancyDetail(String bkgNo, String caFlg) throws DAOException {
				DBRowSet dbRowset = null;
				List<UnmatchBLVO> list = null;
				Map<String, Object> param = new HashMap<String, Object>();
				Map<String, Object> velParam = new HashMap<String, Object>();
				try{
					param.put("bkg_no", bkgNo);
					param.put("ca_flg", caFlg);
					velParam.put("bkg_no", bkgNo);
					velParam.put("ca_flg", caFlg);
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UnmatchBLDBDAOCheckScSelfSurchargeDiscrepancyDetailRSQL(), param, velParam);
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
}