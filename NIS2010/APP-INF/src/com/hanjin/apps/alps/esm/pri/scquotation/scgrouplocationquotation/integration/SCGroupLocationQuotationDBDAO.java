/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGroupLocationQuotationDBDAO.java
*@FileTitle : S/C Quotation Location Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.09
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.08.09 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scgrouplocationquotation.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scgrouplocationquotation.basic.SCGroupLocationQuotationBCImpl;
import com.hanjin.apps.alps.esm.pri.scquotation.scgrouplocationquotation.vo.RsltPriSqGrpLocDtlVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scgrouplocationquotation.vo.RsltPriSqGrpLocVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltCopyToQuotationVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltPriSqMnVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PriSqGrpLocDtlVO;
import com.hanjin.syscommon.common.table.PriSqGrpLocVO;
import com.hanjin.syscommon.common.table.PriSqHdrVO;


/**
 * ALPS SCGroupLocationQuotationDBDAO <br>
 * - ALPS-SCQuotation system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Seung-Jun,Lee
 * @see SCGroupLocationQuotationBCImpl 참조
 * @since J2EE 1.6
 */
public class SCGroupLocationQuotationDBDAO extends DBDAOSupport {

	/**
	 * GROUP LOCATION SEQ 맥스값을 조회한다.<br>
	 * 
	 * @param PriSqGrpLocVO priSqGrpLocVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchGroupLocationQuotationMaxGrpLocSeq(PriSqGrpLocVO priSqGrpLocVO) throws DAOException {
		int max_grp_loc_seq = -1;
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSqGrpLocVO != null){
				Map<String, String> mapVO = priSqGrpLocVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGroupLocationQuotationDBDAOPriSqGrpLocMaxGrpLocSeqRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				max_grp_loc_seq = dbRowset.getInt("MAX_GRP_LOC_SEQ");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return max_grp_loc_seq;
	}
	
	
	/**
	 * GROUP LOCATION DETAIL SEQ 맥스값을 조회한다.<br>
	 * 
	 * @param PriSqGrpLocVO priSqGrpLocVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchGroupLocationQuotationMaxGrpLocDtlSeq(PriSqGrpLocVO priSqGrpLocVO) throws DAOException {
		int max_grp_loc_dtl_seq = -1;
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSqGrpLocVO != null){
				Map<String, String> mapVO = priSqGrpLocVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGroupLocationQuotationDBDAOPriSqGrpLocMaxGrpLocDtlSeqRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				max_grp_loc_dtl_seq = dbRowset.getInt("MAX_GRP_LOC_DTL_SEQ");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return max_grp_loc_dtl_seq;
	}
	
	
	/**
	 * PRI_SQ_GRP_LOC_DTL 테이블을 조회한다.<br>
	 * 
	 * @param PriSqGrpLocVO priSqGrpLocVO
	 * @return List<RsltPriSqGrpLocDtlVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriSqGrpLocDtlVO> searchGroupLocationDetailList(PriSqGrpLocVO priSqGrpLocVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSqGrpLocDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSqGrpLocVO != null){
				Map<String, String> mapVO = priSqGrpLocVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGroupLocationQuotationDBDAORsltPriSqGrpLocDtlVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriSqGrpLocDtlVO .class);
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
	 * PRI_SQ_GRP_LOC 테이블을 조회한다.<br>
	 * 
	 * @param PriSqGrpLocVO priSqGrpLocVO
	 * @return List<RsltPriSqGrpLocVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriSqGrpLocVO> searchScGroupLocationQuotationList(PriSqGrpLocVO priSqGrpLocVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSqGrpLocVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSqGrpLocVO != null){
				Map<String, String> mapVO = priSqGrpLocVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGroupLocationQuotationDBDAORsltPriSqGrpLocVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriSqGrpLocVO .class);
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
	 * PRI_SQ_GRP_LOC_DTL 테이블을 등록한다.<br>
	 * 
	 * @param PriSqGrpLocDtlVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addScGroupLocationQuotationDetail(PriSqGrpLocDtlVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCGroupLocationQuotationDBDAOPriSqGrpLocDtlVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * PRI_SQ_GRP_LOC_DTL 테이블에 GLINE 정보를 카피한다.<br>
	 * 
	 * @param RsltPriSqMnVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addGlineCopyScGroupLocationQuotationDetail(RsltPriSqMnVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCGroupLocationQuotationDBDAOPriSqGrpLocDtlVOAddGlineCopyCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * PRI_SQ_GRP_LOC_DTL 테이블을 수정한다.<br>
	 * 
	 * @param PriSqGrpLocDtlVO vo
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyScGroupLocationQuotationDetail(PriSqGrpLocDtlVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new SCGroupLocationQuotationDBDAOPriSqGrpLocDtlVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * PRI_SQ_GRP_LOC_DTL 테이블을 삭제한다.<br>
	 * 
	 * @param PriSqGrpLocDtlVO vo
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeScGroupLocationQuotationDetail(PriSqGrpLocDtlVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new SCGroupLocationQuotationDBDAOPriSqGrpLocDtlVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * PRI_SQ_GRP_LOC_DTL 테이블 loc seq 별 전체 삭제한다.<br>
	 * 
	 * @param PriSqGrpLocVO vo
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeScGroupLocationQuotationDetail(PriSqGrpLocVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new SCGroupLocationQuotationDBDAOPriSqGrpLocDtlVOAllDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PRI_SQ_GRP_LOC_DTL 테이블을 일괄 등록한다.<br>
	 * 
	 * @param List<PriSqGrpLocDtlVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addScGroupLocationQuotationDetailS(List<PriSqGrpLocDtlVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCGroupLocationQuotationDBDAOPriSqGrpLocDtlVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
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
	 * PRI_SQ_GRP_LOC_DTL 테이블을 일괄 수정한다.<br>
	 * 
	 * @param List<PriSqGrpLocDtlVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyScGroupLocationQuotationDetailS(List<PriSqGrpLocDtlVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCGroupLocationQuotationDBDAOPriSqGrpLocDtlVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return updCnt;
	}
	
	/**
	 * PRI_SQ_GRP_LOC_DTL 테이블을 일괄 삭제한다.<br>
	 * 
	 * @param List<PriSqGrpLocDtlVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeScGroupLocationQuotationDetailS(List<PriSqGrpLocDtlVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCGroupLocationQuotationDBDAOPriSqGrpLocDtlVODSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return delCnt;
	}
	
	
	/**
	 * PRI_SQ_GRP_LOC 테이블을 등록한다.<br>
	 * 
	 * @param PriSqGrpLocVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addScGroupLocationQuotation(PriSqGrpLocVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCGroupLocationQuotationDBDAOPriSqGrpLocVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * PRI_SQ_GRP_LOC 테이블에 GLINE 정보를 카피한다.<br>
	 * 
	 * @param RsltPriSqMnVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addGlineCopyScGroupLocationQuotation(RsltPriSqMnVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCGroupLocationQuotationDBDAOPriSqGrpLocVOAddGlineCopyCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * PRI_SQ_GRP_LOC 테이블을 수정한다.<br>
	 * 
	 * @param PriSqGrpLocVO vo
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyScGroupLocationQuotation(PriSqGrpLocVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new SCGroupLocationQuotationDBDAOPriSqGrpLocVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * PRI_SQ_GRP_LOC 테이블을 삭제한다.<br>
	 * 
	 * @param PriSqGrpLocVO vo
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeScGroupLocationQuotation(PriSqGrpLocVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new SCGroupLocationQuotationDBDAOPriSqGrpLocVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PRI_SQ_GRP_LOC 테이블을 일괄 등록한다.<br>
	 * 
	 * @param List<PriSqGrpLocVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addScGroupLocationQuotationS(List<PriSqGrpLocVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCGroupLocationQuotationDBDAOPriSqGrpLocVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
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
	 * PRI_SQ_GRP_LOC 테이블을 일괄 수정한다.<br>
	 * 
	 * @param List<PriSqGrpLocVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyScGroupLocationQuotationS(List<PriSqGrpLocVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCGroupLocationQuotationDBDAOPriSqGrpLocVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return updCnt;
	}
	
	/**
	 * PRI_SQ_GRP_LOC 테이블을 일괄 삭제한다.<br>
	 * 
	 * @param List<PriSqGrpLocVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeScGroupLocationQuotationS(List<PriSqGrpLocVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCGroupLocationQuotationDBDAOPriSqGrpLocVODSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return delCnt;
	}
	
	
	
	/**
	 * COPY TO QUOTATION PRI_SQ_GRP_LOC<br>
	 * 
	 * @param RsltCopyToQuotationVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCopyToQuotationScGroupLocationQuotation(RsltCopyToQuotationVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCGroupLocationQuotationDBDAOPriSqGrpLocVOAddCopyToQuotationCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * COPY TO QUOTATION PRI_SQ_GRP_LOC_DTL<br>
	 * 
	 * @param RsltCopyToQuotationVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCopyToQuotationScGroupLocationQuotationDetail(RsltCopyToQuotationVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCGroupLocationQuotationDBDAOPriSqGrpLocDtlVOAddCopyToQuotationCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * PRI_SQ_GRP_LOC 테이블 Qttn No 별 전체 삭제한다.<br>
	 * 
	 * @param PriSqHdrVO priSqHdrVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeScGroupLocationQuotation(PriSqHdrVO priSqHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSqHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCGroupLocationQuotationDBDAOPriSqGrpLocVODeleteByQttnVerNoDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * PRI_SQ_GRP_LOC_DTL 테이블 Qttn No 별 전체 삭제한다.<br>
	 * 
	 * @param PriSqHdrVO priSqHdrVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeScGroupLocationQuotationDetail(PriSqHdrVO priSqHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSqHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCGroupLocationQuotationDBDAOPriSqGrpLocDtlVODeleteByQttnVerNoDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * RATE에서 사용하는 LOCATION 를 조회한다.
	 * @param PriSqGrpLocVO vo
	 * @return RsltCdListVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public RsltCdListVO searchCheckGroupLocationInUse(PriSqGrpLocVO vo) throws DAOException {
		List<RsltCdListVO> list = null;
		DBRowSet dbRowset = null;

		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCGroupLocationQuotationDBDAOCheckGroupLocationInUseRSQL(), param, null);
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		if (list == null || list.size() <= 0) {
			return null;
		} else {
			return list.get(0);
		}
	}
	
}