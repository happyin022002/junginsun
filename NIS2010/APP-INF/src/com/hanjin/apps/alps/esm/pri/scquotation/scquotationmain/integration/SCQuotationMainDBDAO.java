/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCQuotationMainDBDAO.java
*@FileTitle : S/C Quotation Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.08.06 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.basic.SCQuotationMainBCImpl;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltCopyToQuotationVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltPriSqMnChkNeedCalcVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltPriSqMnVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltSearchDetailCntVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltSearchGlineExistVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PriSqHdrVO;
import com.hanjin.syscommon.common.table.PriSqMnVO;
import com.hanjin.syscommon.common.table.PriSqRtCmdtRoutVO;


/**
 * ALPS SCQuotationMainDBDAO <br>
 * - ALPS-SCQuotation system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Seung-Jun,Lee
 * @see SCQuotationMainBCImpl 참조
 * @since J2EE 1.6
 */
public class SCQuotationMainDBDAO extends DBDAOSupport {

	
	/**
	 * GUIDE LINE이 존재하는지 조회한다.<br>
	 * 
	 * @param RsltPriSqMnVO rsltPriSqMnVO
	 * @return List<RsltSearchGlineExistVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltSearchGlineExistVO> searchGlineExist(RsltPriSqMnVO rsltPriSqMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltSearchGlineExistVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltPriSqMnVO != null){
				Map<String, String> mapVO = rsltPriSqMnVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCQuotationMainDBDAOsearchGlineExistRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltSearchGlineExistVO .class);
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
	 * 각 탭별 건수 조회한다.<br>
	 * 
	 * @param RsltPriSqMnVO rsltPriSqMnVO
	 * @return List<RsltSearchDetailCntVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltSearchDetailCntVO> searchDetailCnt(RsltPriSqMnVO rsltPriSqMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltSearchDetailCntVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltPriSqMnVO != null){
				Map<String, String> mapVO = rsltPriSqMnVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCQuotationMainDBDAOSearchDetailCntRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltSearchDetailCntVO .class);
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
	 * Copy 할 Gline seq를 조회한다.<br>
	 * 
	 * @param RsltPriSqMnVO rsltPriSqMnVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchCopyGlineSeq(RsltPriSqMnVO rsltPriSqMnVO) throws DAOException {
		String gline_seq = "";
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltPriSqMnVO != null){
				Map<String, String> mapVO = rsltPriSqMnVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCQuotationMainDBDAOSearchGlineCopySeqRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				gline_seq = dbRowset.getString("GLINE_SEQ");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return gline_seq;
	}
	
	
	/**
	 * QUOTATION NO 맥스값을 조회한다.<br>
	 * 
	 * @param PriSqHdrVO priSqHdrVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchScQuotationHeaderMaxQttnNo(PriSqHdrVO priSqHdrVO) throws DAOException {
		String max_qttn_no = "";
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSqHdrVO != null){
				Map<String, String> mapVO = priSqHdrVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCQuotationMainDBDAOPriSqHdrMaxQuotationNoRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				max_qttn_no = dbRowset.getString("MAX_QTTN_NO");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return max_qttn_no;
	}
	
	
 
	
	/**
	 * cmdt seq 별 rate data가 있는지 체크한다.<br>
	 * 
	 * @param RsltPriSqMnVO rsltPriSqMnVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchCheckExistRate(RsltPriSqMnVO rsltPriSqMnVO) throws DAOException {
		String cnt = "";
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltPriSqMnVO != null){
				Map<String, String> mapVO = rsltPriSqMnVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCQuotationMainDBDAOCheckExistRateRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				cnt = dbRowset.getString("CNT_NON_RATE");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cnt;
	}
	
	
	/**
	 * Quotation Main 정보를 조회한다.<br>
	 * 
	 * @param RsltPriSqMnVO rsltPriSqMnVO
	 * @returnList<RsltPriSqMnVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriSqMnVO> searchScQuotationMainList(RsltPriSqMnVO rsltPriSqMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSqMnVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltPriSqMnVO != null){
				Map<String, String> mapVO = rsltPriSqMnVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCQuotationMainDBDAORsltPriSqMnVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriSqMnVO .class);
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
	 * Quotation Main 정보를 조회한다.<br>
	 * 
	 * @param RsltPriSqMnVO rsltPriSqMnVO
	 * @returnList<RsltPriSqMnChkNeedCalcVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriSqMnChkNeedCalcVO> searchScQuotationMainChkNeedCalcList(RsltPriSqMnVO rsltPriSqMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSqMnChkNeedCalcVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltPriSqMnVO != null){
				Map<String, String> mapVO = rsltPriSqMnVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCQuotationMainDBDAORsltPriSqMnChkNeedCalcVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriSqMnChkNeedCalcVO .class);
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
	 * PRI_SQ_MN 테이블을 등록한다.<br>
	 * 
	 * @param PriSqMnVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addScQuotationMain(PriSqMnVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCQuotationMainDBDAOPriSqMnVOCSQL(), param, velParam);
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
	 * PRI_SQ_MN 테이블을 수정한다.<br>
	 * 
	 * @param PriSqMnVO vo
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyScQuotationMain(PriSqMnVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new SCQuotationMainDBDAOPriSqMnVOUSQL(), param, velParam);
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
	 * copy to proposal 시 생성된 proposal no 업데이트<br>
	 * 
	 * @param PriSqMnVO vo
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyScQuotationMainPropNo(PriSqMnVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new SCQuotationMainDBDAOPriSqMnPropNoUSQL(), param, velParam);
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
     * Quotation Main 의 PropNo를 공백으로 수정합니다.<br>
     *
     * @param PriSqMnVO vo
     * @return int
     * @exception DAOException
     */
    public int modifyScQuotationMainPropNoDel(PriSqMnVO vo) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate) new SCQuotationMainDBDAOPriSqMnPropNoDelUSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    
    
    /**
     * Quotation Main 의 PropNo를 공백으로 수정합니다.<br>
     *
     * @param PriSqMnVO vo
     * @return int
     * @exception DAOException
     */
    public int modifyScQuotationHdrStsCd(PriSqMnVO vo) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate) new SCQuotationMainDBDAOPriSqMnPropNoDelUSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }    

	/**
	 * PRI_SQ_MN 테이블을 삭제한다.<br>
	 * 
	 * @param PriSqMnVO vo
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeScQuotationMain(PriSqMnVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new SCQuotationMainDBDAOPriSqMnVODSQL(), param, velParam);
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
	 * PRI_SQ_MN 테이블 Qttn No 별 전체 삭제<br>
	 * 
	 * @param PriSqHdrVO vo
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeScQuotationMain(PriSqHdrVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new SCQuotationMainDBDAOPriSqMnDeleteByQttnVerNoDSQL(), param, velParam);
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
	 * PRI_SQ_MN 테이블을 일괄 등록한다.<br>
	 * 
	 * @param List<PriSqMnVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addScQuotationMainS(List<PriSqMnVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCQuotationMainDBDAOPriSqMnVOCSQL(), insModels,null);
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
	 * PRI_SQ_MN 테이블을 일괄 수정한다.<br>
	 * 
	 * @param List<PriSqMnVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyScQuotationMainS(List<PriSqMnVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCQuotationMainDBDAOPriSqMnVOUSQL(), updModels,null);
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
	 * PRI_SQ_MN 테이블을 일괄 삭제한다.<br>
	 * 
	 * @param List<PriSqMnVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeScQuotationMainS(List<PriSqMnVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCQuotationMainDBDAOPriSqMnVODSQL(), delModels,null);
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
	 * PRI_SQ_HDR 테이블을 등록한다.<br>
	 * 
	 * @param PriSqHdrVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addScQuotationHeader(PriSqHdrVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCQuotationMainDBDAOPriSqHdrVOCSQL(), param, velParam);
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
	 * PRI_SQ_HDR 테이블을 수정한다.<br>
	 * 
	 * @param PriSqHdrVO vo
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyScQuotationHeader(PriSqHdrVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new SCQuotationMainDBDAOPriSqHdrVOUSQL(), param, velParam);
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
	 * PRI_SQ_HDR 테이블 상태코드 저장한다.<br>
	 * 
	 * @param PriSqHdrVO vo
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyScQuotationHeaderStatus(PriSqHdrVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new SCQuotationMainDBDAOPriSqHdrVOStatusUSQL(), param, velParam);
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
	 * PRI_SQ_HDR 테이블을 삭제한다.<br>
	 * 
	 * @param PriSqHdrVO vo
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeScQuotationHeader(PriSqHdrVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new SCQuotationMainDBDAOPriSqHdrVODSQL(), param, velParam);
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
	 * PRI_SQ_HDR 테이블을 일괄 등록한다.<br>
	 * 
	 * @param List<PriSqHdrVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addScQuotationHeaderS(List<PriSqHdrVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCQuotationMainDBDAOPriSqHdrVOCSQL(), insModels,null);
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
	 * PRI_SQ_HDR 테이블을 일괄 수정한다.<br>
	 * 
	 * @param List<PriSqHdrVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyScQuotationHeaderS(List<PriSqHdrVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCQuotationMainDBDAOPriSqHdrVOUSQL(), updModels,null);
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
	 * PRI_SQ_HDR 테이블을 일괄 삭제한다.<br>
	 * 
	 * @param List<PriSqHdrVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeScQuotationHeaderS(List<PriSqHdrVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCQuotationMainDBDAOPriSqHdrVODSQL(), delModels,null);
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
	 * COPY TO QUOTATION PRI_SQ_HDR<br>
	 * 
	 * @param RsltCopyToQuotationVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCopyToQuotationScQuotationHeader(RsltCopyToQuotationVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCQuotationMainDBDAOPriSqHdrVOAddCopyToQuotationCSQL(), param, velParam);
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
	 * COPY TO QUOTATION PRI_SQ_MN<br>
	 * 
	 * @param RsltCopyToQuotationVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCopyToQuotationScQuotationMain(RsltCopyToQuotationVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCQuotationMainDBDAOPriSqMnVOAddCopyToQuotationCSQL(), param, velParam);
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
	 * SC QUOTATION INQUIRY MAIN SEARCH<br>
	 * 
	 * @param RsltPriSqMnVO rsltPriSqMnVO
	 * @return List<RsltPriSqMnVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriSqMnVO> searchScQuotationReportList(RsltPriSqMnVO rsltPriSqMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSqMnVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltPriSqMnVO != null){
				Map<String, String> mapVO = rsltPriSqMnVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCQuotationMainDBDAORsltPriSqMnVOReportRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriSqMnVO .class);
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
     * S/C Quotation Rate Main Table에 변경된 Load값을 이용해서 CM 값을 재 계산해서 갱신한다.<br>
	 * 
	 * @param priSqRtCmdtRoutVO PriSqRtCmdtRoutVO 데이터객체 배열
	 * @param pfmcUnit String
	 * @throws DAOException
	 */
	public void modifyPrsPriSqMnCm(PriSqRtCmdtRoutVO priSqRtCmdtRoutVO,String pfmcUnit) throws DAOException, Exception {
		try {
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, Object> param = new HashMap<String, Object>();
			velParam.put("pfmc_unit", pfmcUnit);			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(priSqRtCmdtRoutVO != null){
				Map<String, String> mapVO = priSqRtCmdtRoutVO .getColumnValues();			
				param.putAll(mapVO);
				param.put("pfmc_unit", pfmcUnit);
			}
			
			
			int updCnt  = 0;
 
			updCnt = sqlExe.executeUpdate((ISQLTemplate) new SCQuotationMainDBDAOPriSqMnCmVOUSQL(), param,
						velParam);
				 
			if (updCnt == Statement.EXECUTE_FAILED)  
						throw new DAOException("Fail to update  SQL");   
 
	 
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} 
	}
	
}