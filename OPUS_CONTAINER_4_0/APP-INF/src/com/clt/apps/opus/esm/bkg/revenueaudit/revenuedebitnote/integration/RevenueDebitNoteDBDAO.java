/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RevenueDebitNoteDBDAO.java
*@FileTitle : RDN Issuance by Regional Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.05.19 이승준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.basic.RevenueDebitNoteBCImpl;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.vo.CstmBkgRevDrNoteVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.vo.RsltBkgRevDrAmtVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.vo.RsltBkgRevDrNoteVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.vo.RsltBkgRevDrNotesPerformanceVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.vo.RsltBkgRevDrNotesStatusVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.vo.RsltSearchRDNIssueMailingListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.BkgRevDrAmtVO;
import com.clt.syscommon.common.table.BkgRevDrNoteProgVO;



/**
 * OPUS RevenueDebitNoteDBDAO <br>
 * - OPUS-RevenueAudit system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Seung Jun Lee
 * @see RevenueDebitNoteBCImpl 참조
 * @since J2EE 1.4
 */
public class RevenueDebitNoteDBDAO extends DBDAOSupport {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * RDN NO 저장된 최대값 + 1 조회<br>
	 * 
	 * @param CstmBkgRevDrNoteVO bkgRevDrNoteVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchBkgRevDrNoteMaxSeq(CstmBkgRevDrNoteVO bkgRevDrNoteVO) throws DAOException {
		String rdn_no = "";
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgRevDrNoteVO != null){
				Map<String, String> mapVO = bkgRevDrNoteVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RevenueDebitNoteDBDAOBkgRevDrNoteVOMaxSeqRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				rdn_no = dbRowset.getString("RDN_NO");
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
	 * RDN NO 저장된 최대값 조회.<br>
	 * 
	 * @param CstmBkgRevDrNoteVO bkgRevDrNoteVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchBkgRevDrNoteMaxSeqMinusOne(CstmBkgRevDrNoteVO bkgRevDrNoteVO) throws DAOException {
		String rdn_no = "";
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgRevDrNoteVO != null){
				Map<String, String> mapVO = bkgRevDrNoteVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RevenueDebitNoteDBDAOBkgRevDrNoteVOMaxSeqMinusOneRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				rdn_no = dbRowset.getString("RDN_NO");
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
	 * 진행중인 RDN NO 조회.<br>
	 * 
	 * @param  CstmBkgRevDrNoteVO bkgRevDrNoteVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchExistRevDrNote(CstmBkgRevDrNoteVO bkgRevDrNoteVO) throws DAOException {
		String rdn_no = "";
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgRevDrNoteVO != null){
				Map<String, String> mapVO = bkgRevDrNoteVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RevenueDebitNoteDBDAOBkgRevDrNoteVOExistRevDrNoteRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				rdn_no = dbRowset.getString("RDN_NO");
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
	
	
//	/**
//	 * BL_NO가 존재하는 지 조회한다.<br>
//	 * 
//	 * @param CstmBkgRevDrNoteVO bkgRevDrNoteVO
//	 * @return int
//	 * @throws DAOException
//	 */
//	public int searchCheckBlNo(CstmBkgRevDrNoteVO bkgRevDrNoteVO) throws DAOException {
//		int chk = 0;
//		DBRowSet dbRowset = null;
//		
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		
//		try{
//			if(bkgRevDrNoteVO != null){
//				Map<String, String> mapVO = bkgRevDrNoteVO.getColumnValues();
//			
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RevenueDebitNoteDBDAOBkgBookingBlNoRSQL(), param, velParam);
//			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
//				chk = dbRowset.getInt("CHK");
//			}
//			
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//		return chk;
//	}
	
	
	/**
	 * CA_NO가 존재하는 지 조회한다.<br>
	 * 
	 * @param CstmBkgRevDrNoteVO bkgRevDrNoteVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchCheckCaNo(CstmBkgRevDrNoteVO bkgRevDrNoteVO) throws DAOException {
		int chk = 0;
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		
		try{
			if(bkgRevDrNoteVO != null){
				Map<String, String> mapVO = bkgRevDrNoteVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RevenueDebitNoteDBDAOBkgRevDrNoteVOCheckCaNoRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				chk = dbRowset.getInt("CHK");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return chk;
	}
	
	
	/**
	 * Ragional Group Remark search<br>
	 * 
	 * @param CstmBkgRevDrNoteVO bkgRevDrNoteVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchBkgRevDrNoteProgMaxRmk(CstmBkgRevDrNoteVO bkgRevDrNoteVO) throws DAOException {
		String rmk = "";
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgRevDrNoteVO != null){
				Map<String, String> mapVO = bkgRevDrNoteVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RevenueDebitNoteDBDAOBkgRevDrNoteProgVORSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				rmk = dbRowset.getString("RDN_RMK");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rmk;
	}
	
	/**
	 * Receipt remark search<br>
	 * 
	 * @param CstmBkgRevDrNoteVO bkgRevDrNoteVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchBkgRevDrNoteProgReceiptMaxRmk(CstmBkgRevDrNoteVO bkgRevDrNoteVO) throws DAOException {
		String rmk = "";
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgRevDrNoteVO != null){
				Map<String, String> mapVO = bkgRevDrNoteVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RevenueDebitNoteDBDAOBkgRevDrNoteProgVOReceiptRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				rmk = dbRowset.getString("RDN_RMK");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rmk;
	}
	
	
	
	/**
	 * BL_NO로 bkg 관련 데이터 조회<br>
	 * 
	 * @param CstmBkgRevDrNoteVO bkgRevDrNoteVO
	 * @return List<RsltBkgRevDrNoteVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltBkgRevDrNoteVO> searchBlno(CstmBkgRevDrNoteVO bkgRevDrNoteVO) throws DAOException {
		 	 
		DBRowSet dbRowset = null;
		List<RsltBkgRevDrNoteVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgRevDrNoteVO != null){
				Map<String, String> mapVO = bkgRevDrNoteVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
					
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            RevenueDebitNoteDBDAOBkgRevDrNotesBlnoRSQL template = new RevenueDebitNoteDBDAOBkgRevDrNotesBlnoRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltBkgRevDrNoteVO .class);
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
	 * BKG_REV_DR_AMT 테이블을 조회한다.<br>
	 * 
	 * @param CstmBkgRevDrNoteVO bkgRevDrNoteVO
	 * @return List<RsltBkgRevDrAmtVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltBkgRevDrAmtVO> searchBkgRevDrAmtList(CstmBkgRevDrNoteVO bkgRevDrNoteVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltBkgRevDrAmtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgRevDrNoteVO != null){
				Map<String, String> mapVO = bkgRevDrNoteVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            RevenueDebitNoteDBDAOBkgRevDrAmtVORSQL template = new RevenueDebitNoteDBDAOBkgRevDrAmtVORSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltBkgRevDrAmtVO .class);
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
	 * RDN Issuance by Regional Group 에 대한 메인 조회.<br>
	 * 
	 * @param CstmBkgRevDrNoteVO bkgRevDrNoteVO
	 * @return List<RsltBkgRevDrNoteVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltBkgRevDrNoteVO> searchBkgRevDrNoteList(CstmBkgRevDrNoteVO bkgRevDrNoteVO) throws DAOException {
		 	 
		DBRowSet dbRowset = null;
		List<RsltBkgRevDrNoteVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgRevDrNoteVO != null){
				Map<String, String> mapVO = bkgRevDrNoteVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
					
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            RevenueDebitNoteDBDAOBkgRevDrNoteVORSQL template = new RevenueDebitNoteDBDAOBkgRevDrNoteVORSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltBkgRevDrNoteVO .class);
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
	 * RDN STATUS SEARCH<br>
	 * 
	 * @param RsltBkgRevDrNotesStatusVO rsltBkgRevDrNotesStatusVO
	 * @return List<RsltBkgRevDrNotesStatusVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltBkgRevDrNotesStatusVO> searchBkgRevDrNoteStatusList(RsltBkgRevDrNotesStatusVO rsltBkgRevDrNotesStatusVO) throws DAOException {
		 	 
		DBRowSet dbRowset = null;
		List<RsltBkgRevDrNotesStatusVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltBkgRevDrNotesStatusVO != null){				
               if (!JSPUtil.getNull(rsltBkgRevDrNotesStatusVO.getUmchTpCd()).equals("")) {
					rsltBkgRevDrNotesStatusVO.setUmchTpCd("'" + rsltBkgRevDrNotesStatusVO.getUmchTpCd().replaceAll("," ,"','") +"'");

				}
               Map<String, String> mapVO = rsltBkgRevDrNotesStatusVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
					
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            RevenueDebitNoteDBDAOBkgRevDrNotesStatusRSQL template = new RevenueDebitNoteDBDAOBkgRevDrNotesStatusRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltBkgRevDrNotesStatusVO .class);
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
	 * RDN PERFORMANCE SEARCH<br>
	 * 
	 * @param RsltBkgRevDrNotesPerformanceVO rsltBkgRevDrNotesPerformanceVO
	 * @return List<RsltBkgRevDrNotesPerformanceVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltBkgRevDrNotesPerformanceVO> searchRDNPerformanceList(RsltBkgRevDrNotesPerformanceVO rsltBkgRevDrNotesPerformanceVO) throws DAOException {
		 	 
		DBRowSet dbRowset = null;
		List<RsltBkgRevDrNotesPerformanceVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltBkgRevDrNotesPerformanceVO != null){
				Map<String, String> mapVO = rsltBkgRevDrNotesPerformanceVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
					
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            RevenueDebitNoteDBDAOBkgRevDrNotesPerformanceRSQL template = new RevenueDebitNoteDBDAOBkgRevDrNotesPerformanceRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltBkgRevDrNotesPerformanceVO .class);
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
	 * RevenueDebitNoteDBDAO의 Receipt 정보 조회.<br>
	 * 
	 * @param CstmBkgRevDrNoteVO bkgRevDrNoteVO
	 * @return List<RsltBkgRevDrNoteVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltBkgRevDrNoteVO> searchBkgRevDrNoteReceiptList(CstmBkgRevDrNoteVO bkgRevDrNoteVO) throws DAOException {
		 	 
		DBRowSet dbRowset = null;
		List<RsltBkgRevDrNoteVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgRevDrNoteVO != null){
				Map<String, String> mapVO = bkgRevDrNoteVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
					
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            RevenueDebitNoteDBDAOBkgRevDrNoteVOReceiptRSQL template = new RevenueDebitNoteDBDAOBkgRevDrNoteVOReceiptRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltBkgRevDrNoteVO .class);
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
//	 * Ragional Group Remark search<br>
//	 * 
//	 * @param CstmBkgRevDrNoteVO cstmBkgRevDrNoteVO
//	 * @return List<BkgRevDrNoteProgVO>
//	 * @throws DAOException
//	 */
//	 @SuppressWarnings("unchecked")
//	public List<BkgRevDrNoteProgVO> searchBkgRevDrNoteProgList(CstmBkgRevDrNoteVO cstmBkgRevDrNoteVO) throws DAOException {
//		DBRowSet dbRowset = null;
//		List<BkgRevDrNoteProgVO> list = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		try{
//			if(cstmBkgRevDrNoteVO != null){
//				Map<String, String> mapVO = cstmBkgRevDrNoteVO .getColumnValues();
//			
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			
//            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//            RevenueDebitNoteDBDAOBkgRevDrNoteProgVORSQL template = new RevenueDebitNoteDBDAOBkgRevDrNoteProgVORSQL();
//			dbRowset = sqlExe.executeQuery(template, param, velParam);
//			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgRevDrNoteProgVO .class);
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//		return list;
//	}
	 
//	/**
//	 * Receipt remark search.<br>
//	 * 
//	 * @param CstmBkgRevDrNoteVO cstmBkgRevDrNoteVO
//	 * @return List<BkgRevDrNoteProgVO>
//	 * @throws DAOException
//	 */
//	 @SuppressWarnings("unchecked")
//	public List<BkgRevDrNoteProgVO> searchBkgRevDrNoteProgReceiptList(CstmBkgRevDrNoteVO cstmBkgRevDrNoteVO) throws DAOException {
//		DBRowSet dbRowset = null;
//		List<BkgRevDrNoteProgVO> list = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		try{
//			if(cstmBkgRevDrNoteVO != null){
//				Map<String, String> mapVO = cstmBkgRevDrNoteVO .getColumnValues();
//			
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			
//            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//            RevenueDebitNoteDBDAOBkgRevDrNoteProgVOReceiptRSQL template = new RevenueDebitNoteDBDAOBkgRevDrNoteProgVOReceiptRSQL();
//			dbRowset = sqlExe.executeQuery(template, param, velParam);
//			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgRevDrNoteProgVO .class);
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//		return list;
//	}
	/**
	 * BKG_REV_DR_NOTE_PROG 테이블을 등록한다.<br>
	 * 
	 * @param BkgRevDrNoteProgVO vo
	 * @throws DAOException
	 */
	public void addBkgRevDrNoteProg(BkgRevDrNoteProgVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			RevenueDebitNoteDBDAOBkgRevDrNoteProgVOCSQL template = new RevenueDebitNoteDBDAOBkgRevDrNoteProgVOCSQL();
			int result = sqlExe.executeUpdate(template, param, velParam);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
//	/**
//	 * Revise_seq 최근값을 복사하여 등록한다.<br>
//	 * 
//	 * @param CstmBkgRevDrNoteVO vo
//	 * @throws DAOException
//	 */
//	public void addSearchBkgRevDrNoteProg(CstmBkgRevDrNoteVO vo) throws DAOException,Exception {
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
//            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//            RevenueDebitNoteDBDAOBkgRevDrNoteProgVOAddSearchCSQL template = new RevenueDebitNoteDBDAOBkgRevDrNoteProgVOAddSearchCSQL();
//			int result = sqlExe.executeUpdate(template, param, velParam);
//			if(result == Statement.EXECUTE_FAILED) {
//				throw new DAOException("Fail to insert SQL");
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
	 * Prog_seq 최근값을 복사하여 등록한다.(Office Remark)<br>
	 * 
	 * @param CstmBkgRevDrNoteVO vo
	 * @throws DAOException
	 */
	public void addSearchBkgRevDrNoteProgOffice(CstmBkgRevDrNoteVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            RevenueDebitNoteDBDAOBkgRevDrNoteProgVOAddSearchOfficeCSQL template = new RevenueDebitNoteDBDAOBkgRevDrNoteProgVOAddSearchOfficeCSQL();
			int result = sqlExe.executeUpdate(template, param, velParam);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Prog_seq 최근값을 복사하여 등록한다.(Reciver Remark)<br>
	 * 
	 * @param CstmBkgRevDrNoteVO vo
	 * @throws DAOException
	 */
	public void addSearchBkgRevDrNoteProgReciver(CstmBkgRevDrNoteVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            RevenueDebitNoteDBDAOBkgRevDrNoteProgVOAddSearchReceiverRSQL template = new RevenueDebitNoteDBDAOBkgRevDrNoteProgVOAddSearchReceiverRSQL();
			int result = sqlExe.executeUpdate(template, param, velParam);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * BKG_REV_DR_NOTE_PROG 테이블을 수정한다.<br>
	 * 
	 * @param BkgRevDrNoteProgVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int modifyBkgRevDrNoteProg(BkgRevDrNoteProgVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			RevenueDebitNoteDBDAOBkgRevDrNoteProgVOUSQL template = new RevenueDebitNoteDBDAOBkgRevDrNoteProgVOUSQL();
			result = sqlExe.executeUpdate(template, param, velParam);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
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
//	 * BKG_REV_DR_NOTE_PROG 테이블을 삭제한다.<br>
//	 * 
//	 * @param BkgRevDrNoteProgVO vo
//	 * @return int
//	 * @throws DAOException
//	 */
//	public int removeBkgRevDrNoteProg(BkgRevDrNoteProgVO vo) throws DAOException,Exception {
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
//            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//			RevenueDebitNoteDBDAOBkgRevDrNoteProgVODSQL template = new RevenueDebitNoteDBDAOBkgRevDrNoteProgVODSQL();
//			result = sqlExe.executeUpdate(template, param, velParam);
//			if(result == Statement.EXECUTE_FAILED) {
//				throw new DAOException("Fail to insert SQL");
//			}
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//		return result;
//	}

//	/**
//	 * BKG_REV_DR_NOTE_PROG 테이블을 일괄 등록한다.<br>
//	 * 
//	 * @param List<BkgRevDrNoteProgVO> insModels
//	 * @throws DAOException
//	 */
//	public void addBkgRevDrNoteProgS(List<BkgRevDrNoteProgVO> insModels) throws DAOException,Exception {
//		try {
//            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//			RevenueDebitNoteDBDAOBkgRevDrNoteProgVOCSQL template = new RevenueDebitNoteDBDAOBkgRevDrNoteProgVOCSQL();
//			int insCnt[] = null;
//			if(insModels.size() > 0){
//				insCnt = sqlExe.executeBatch(template, insModels, null);
//				for(int i = 0; i < insCnt.length; i++){
//					if(insCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to insert No"+ i + " SQL");
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
//	/**
//	 * BKG_REV_DR_NOTE_PROG 테이블을 일괄 수정한다.<br>
//	 * 
//	 * @param List<BkgRevDrNoteProgVO> updModels
//	 * @throws DAOException
//	 */
//	public void modifyBkgRevDrNoteProgS(List<BkgRevDrNoteProgVO> updModels) throws DAOException,Exception {
//		try {
//            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//			RevenueDebitNoteDBDAOBkgRevDrNoteProgVOUSQL template = new RevenueDebitNoteDBDAOBkgRevDrNoteProgVOUSQL();
//			int updCnt[] = null;
//			if(updModels.size() > 0){
//				updCnt = sqlExe.executeBatch(template, updModels, null);
//				for(int i = 0; i < updCnt.length; i++){
//					if(updCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	
//	/**
//	 * BKG_REV_DR_NOTE_PROG 테이블을 일괄 삭제한다.<br>
//	 * 
//	 * @param List<BkgRevDrNoteProgVO> delModels
//	 * @throws DAOException
//	 */
//	public void removeBkgRevDrNoteProgS(List<BkgRevDrNoteProgVO> delModels) throws DAOException,Exception {
//		try {
//            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//			RevenueDebitNoteDBDAOBkgRevDrNoteProgVODSQL template = new RevenueDebitNoteDBDAOBkgRevDrNoteProgVODSQL();
//			int delCnt[] = null;
//			if(delModels.size() > 0){
//				delCnt = sqlExe.executeBatch(template, delModels, null);
//				for(int i = 0; i < delCnt.length; i++){
//					if(delCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * BKG_REV_DR_NOTE 테이블을 등록한다.<br>
	 * 
	 * @param CstmBkgRevDrNoteVO vo
	 * @throws DAOException
	 */
	public void addBkgRevDrNote(CstmBkgRevDrNoteVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			RevenueDebitNoteDBDAOBkgRevDrNoteVOCSQL template = new RevenueDebitNoteDBDAOBkgRevDrNoteVOCSQL();
			int result = sqlExe.executeUpdate(template, param, velParam);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
//	/**
//	 * note 최근값을 복사하여 등록한다.<br>
//	 * 
//	 * @param CstmBkgRevDrNoteVO vo
//	 * @throws DAOException
//	 */
//	public void addSearchBkgRevDrNote(CstmBkgRevDrNoteVO vo) throws DAOException,Exception {
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
//            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//            RevenueDebitNoteDBDAOBkgRevDrNoteVOAddSearchCSQL template = new RevenueDebitNoteDBDAOBkgRevDrNoteVOAddSearchCSQL();
//			int result = sqlExe.executeUpdate(template, param, velParam);
//			if(result == Statement.EXECUTE_FAILED) {
//				throw new DAOException("Fail to insert SQL");
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
	 * BKG_REV_DR_NOTE 테이블을 수정한다.<br>
	 * 
	 * @param CstmBkgRevDrNoteVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int modifyBkgRevDrNote(CstmBkgRevDrNoteVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			RevenueDebitNoteDBDAOBkgRevDrNoteVOUSQL template = new RevenueDebitNoteDBDAOBkgRevDrNoteVOUSQL();
			result = sqlExe.executeUpdate(template, param, velParam);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
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
	 * RDN STATUS 를 갱신한다.<br>
	 * 
	 * @param CstmBkgRevDrNoteVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int modifyBkgRevDrNoteStatus(CstmBkgRevDrNoteVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			log.debug("RYU START" + vo.toString() + "RYU END");
			
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            RevenueDebitNoteDBDAOBkgRevDrNoteVOStatusUSQL template = new RevenueDebitNoteDBDAOBkgRevDrNoteVOStatusUSQL();
			result = sqlExe.executeUpdate(template, param, velParam);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
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
	 * BKG_REV_DR_AMT 테이블을 일괄 등록한다.<br>
	 * 
	 * @param List<BkgRevDrAmtVO> insModels
	 * @throws DAOException
	 */
	public void addBkgRevDrAmtS(List<BkgRevDrAmtVO> insModels) throws DAOException,Exception {
		try {
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			RevenueDebitNoteDBDAOBkgRevDrAmtVOCSQL template = new RevenueDebitNoteDBDAOBkgRevDrAmtVOCSQL();
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch(template, insModels, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * BKG_REV_DR_AMT 테이블을 일괄 수정한다.<br>
	 * 
	 * @param List<BkgRevDrAmtVO> updModels
	 * @throws DAOException
	 */
	public void modifyBkgRevDrAmtS(List<BkgRevDrAmtVO> updModels) throws DAOException,Exception {
		try {
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			RevenueDebitNoteDBDAOBkgRevDrAmtVOUSQL template = new RevenueDebitNoteDBDAOBkgRevDrAmtVOUSQL();
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch(template, updModels, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * BKG_REV_DR_AMT 테이블을 일괄 삭제한다.<br>
	 * 
	 * @param List<BkgRevDrAmtVO> delModels
	 * @throws DAOException
	 */
	public void removeBkgRevDrAmtS(List<BkgRevDrAmtVO> delModels) throws DAOException,Exception {
		try {
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			RevenueDebitNoteDBDAOBkgRevDrAmtVODSQL template = new RevenueDebitNoteDBDAOBkgRevDrAmtVODSQL();
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch(template, delModels, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	 /**
	 * RDN Issuance by Auditor Issue 메일 대상자를 조회한다.<br>
	 * 
	 * @param RsltSearchRDNIssueMailingListVO rsltSearchRDNIssueMailingListVO
	 * @return List<RsltSearchRDNIssueMailingListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltSearchRDNIssueMailingListVO> searchRDNIssueMailingList(RsltSearchRDNIssueMailingListVO rsltSearchRDNIssueMailingListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltSearchRDNIssueMailingListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(rsltSearchRDNIssueMailingListVO != null){
				Map<String, String> mapVO = rsltSearchRDNIssueMailingListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
            //RevenueDebitNoteDBDAORsltSearchRDNIssueMailingListRSQL template = new RevenueDebitNoteDBDAORsltSearchRDNIssueMailingListRSQL();
            //SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			//dbRowset = sqlExe.executeQuery(template, param, velParam);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RevenueDebitNoteDBDAORsltSearchRDNIssueMailingListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltSearchRDNIssueMailingListVO.class);
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
	 * Non-Charged B/L에 대한 RDN 자동발행 대상자조회
	 * @param bkgNo
	 * @return List<RsltSearchRDNIssueMailingListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltSearchRDNIssueMailingListVO> searchRDNIssueMailingAutoList(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltSearchRDNIssueMailingListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RevenueDebitNoteDBDAORsltSearchRDNIssueMailingAutoListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltSearchRDNIssueMailingListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
}