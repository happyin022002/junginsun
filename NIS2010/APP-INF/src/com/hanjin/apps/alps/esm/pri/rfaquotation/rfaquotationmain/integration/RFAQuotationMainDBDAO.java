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
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltCopyToQuotationVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltPriRqMnChkNeedCalcVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltPriRqMnVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltSearchDetailCntVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltSearchGlineExistVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.basic.SCQuotationMainBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PriRqHdrVO;
import com.hanjin.syscommon.common.table.PriRqMnVO;
import com.hanjin.syscommon.common.table.PriRqRtCmdtRoutVO;


/**
 * ALPS SCQuotationMainDBDAO <br>
 * - ALPS-SCQuotation system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Seung-Jun,Lee
 * @see SCQuotationMainBCImpl 참조
 * @since J2EE 1.6
 */
public class RFAQuotationMainDBDAO extends DBDAOSupport {

	
	/**
	 * GUIDE LINE이 존재하는지 조회한다.<br>
	 * 
	 * @param RsltPriRqMnVO rsltPriRqMnVO
	 * @return List<RsltSearchGlineExistVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltSearchGlineExistVO> searchGlineExist(RsltPriRqMnVO rsltPriRqMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltSearchGlineExistVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltPriRqMnVO != null){
				Map<String, String> mapVO = rsltPriRqMnVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAQuotationMainDBDAOsearchGlineExistRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltSearchGlineExistVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	
	/**
	 * 각 탭별 건수를 조회한다.<br>
	 * 
	 * @param RsltPriRqMnVO rsltPriRqMnVO
	 * @return List<RsltSearchDetailCntVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltSearchDetailCntVO> searchDetailCnt(RsltPriRqMnVO rsltPriRqMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltSearchDetailCntVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltPriRqMnVO != null){
				Map<String, String> mapVO = rsltPriRqMnVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAQuotationMainDBDAOSearchDetailCntRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltSearchDetailCntVO .class);
		} catch (SQLException se) {
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
	 * @param RsltPriRqMnVO rsltPriRqMnVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchCopyGlineSeq(RsltPriRqMnVO rsltPriRqMnVO) throws DAOException {
		String gline_seq = "";
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltPriRqMnVO != null){
				Map<String, String> mapVO = rsltPriRqMnVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAQuotationMainDBDAOSearchGlineCopySeqRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				gline_seq = dbRowset.getString("GLINE_SEQ");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return gline_seq;
	}
	
	
	/**
	 * QUOTATION NO 맥스값을 조회한다.<br>
	 * 
	 * @param PriRqHdrVO priRqHdrVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchRFAQuotationHeaderMaxQttnNo(PriRqHdrVO priRqHdrVO) throws DAOException {
		String max_qttn_no = "";
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRqHdrVO != null){
				Map<String, String> mapVO = priRqHdrVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAQuotationMainDBDAOPriRqHdrMaxQuotationNoRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				max_qttn_no = dbRowset.getString("MAX_QTTN_NO");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return max_qttn_no;
	}
	
	
	/**
	 * Copy to Proposal 전 calculate 했는지 체크한다.<br>
	 * 
	 * @param RsltPriRqMnVO rsltPriRqMnVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchCheckCalculate(RsltPriRqMnVO rsltPriRqMnVO) throws DAOException {
		String cnt = "";
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltPriRqMnVO != null){
				Map<String, String> mapVO = rsltPriRqMnVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAQuotationMainDBDAOCheckCalculatedRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				cnt = dbRowset.getString("CNT_CAL");
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
	 * cmdt seq 별 rate data가 있는지 체크한다.<br>
	 * 
	 * @param RsltPriRqMnVO rsltPriRqMnVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchCheckExistRate(RsltPriRqMnVO rsltPriRqMnVO) throws DAOException {
		String cnt = "";
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltPriRqMnVO != null){
				Map<String, String> mapVO = rsltPriRqMnVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAQuotationMainDBDAOCheckExistRateRSQL(), param, velParam);
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
	 * @param RsltPriRqMnVO rsltPriRqMnVO
	 * @return List<RsltPriRqMnVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriRqMnVO> searchRFAQuotationMainList(RsltPriRqMnVO rsltPriRqMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriRqMnVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltPriRqMnVO != null){
				Map<String, String> mapVO = rsltPriRqMnVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAQuotationMainDBDAORsltPriRqMnVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriRqMnVO .class);
		} catch (SQLException se) {
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
	 * @param RsltPriRqMnVO RsltPriRqMnVO
	 * @returnList<RsltPriRqMnChkNeedCalcVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriRqMnChkNeedCalcVO> searchRFAQuotationMainChkNeedCalcList(RsltPriRqMnVO RsltPriRqMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriRqMnChkNeedCalcVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(RsltPriRqMnVO != null){
				Map<String, String> mapVO = RsltPriRqMnVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAQuotationMainDBDAORsltPriRqMnChkNeedCalcVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriRqMnChkNeedCalcVO .class);
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
	 * PRI_RQ_MN 테이블을 등록한다.<br>
	 * 
	 * @param PriRqMnVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addRFAQuotationMain(PriRqMnVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new RFAQuotationMainDBDAOPriRqMnVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * PRI_RQ_MN 테이블을 수정한다.<br>
	 * 
	 * @param PriRqMnVO vo
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyRFAQuotationMain(PriRqMnVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new RFAQuotationMainDBDAOPriRqMnVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
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
	 * @param PriRqMnVO vo
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyRFAQuotationMainPropNo(PriRqMnVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new RFAQuotationMainDBDAOPriRqMnPropNoUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
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
     * @param PriRqMnVO vo
     * @return int
     * @exception DAOException
     */
    public int modifyRFAQuotationMainPropNoDel(PriRqMnVO vo) throws DAOException {
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
            result = sqlExe.executeUpdate((ISQLTemplate) new RFAQuotationMainDBDAOPriRqMnPropNoDelUSQL(), param, velParam);
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
     * Quotation HEADER 의 qttn_sts_cd를 N 수정합니다.<br>
     *
     * @param PriRqMnVO vo
     * @return int
     * @exception DAOException
     */
    public int modifyRFAQuotationHdrStsCd(PriRqMnVO vo) throws DAOException {
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
            result = sqlExe.executeUpdate((ISQLTemplate) new RFAQuotationMainDBDAOPriRqHdrStsCdVODSQL(), param, velParam);
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
	 * PRI_RQ_MN 테이블을 삭제한다.<br>
	 * 
	 * @param PriRqMnVO vo
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeRFAQuotationMain(PriRqMnVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new RFAQuotationMainDBDAOPriRqMnVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PRI_RQ_MN 테이블을 일괄 등록한다.<br>
	 * 
	 * @param List<PriRqMnVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addRFAQuotationMainS(List<PriRqMnVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFAQuotationMainDBDAOPriRqMnVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}
	/**
	 * PRI_RQ_MN 테이블을 갱신한다.<br>
	 * 
	 * @param List<PriRqMnVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyRFAQuotationMainS(List<PriRqMnVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RFAQuotationMainDBDAOPriRqMnVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return updCnt;
	}
	
	/**
	 * PRI_RQ_MN 테이블을 삭제한다.<br>
	 * 
	 * @param List<PriRqMnVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeRFAQuotationMainS(List<PriRqMnVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new RFAQuotationMainDBDAOPriRqMnVODSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return delCnt;
	}
	
	
	/**
	 * PRI_RQ_HDR 테이블을 등록한다.<br>
	 * 
	 * @param PriRqHdrVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addRFAQuotationHeader(PriRqHdrVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new RFAQuotationMainDBDAOPriRqHdrVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * PRI_RQ_HDR 테이블을 갱신한다.<br>
	 * 
	 * @param PriRqHdrVO vo
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyRFAQuotationHeader(PriRqHdrVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new RFAQuotationMainDBDAOPriRqHdrVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * PRI_RQ_HDR 테이블 상태코드를 저장한다.<br>
	 * 
	 * @param PriRqHdrVO vo
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyRFAQuotationHeaderStatus(PriRqHdrVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new RFAQuotationMainDBDAOPriRqHdrVOStatusUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * PRI_RQ_HDR 테이블을 삭제한다.<br>
	 * 
	 * @param PriRqHdrVO vo
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeRFAQuotationHeader(PriRqHdrVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new RFAQuotationMainDBDAOPriRqHdrVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PRI_RQ_HDR 테이블을 일괄 등록한다.<br>
	 * 
	 * @param List<PriRqHdrVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addRFAQuotationHeaderS(List<PriRqHdrVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFAQuotationMainDBDAOPriRqHdrVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}
	/**
	 * PRI_RQ_HDR 테이블을 일괄 갱신한다.<br>
	 * 
	 * @param List<PriRqHdrVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyRFAQuotationHeaderS(List<PriRqHdrVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RFAQuotationMainDBDAOPriRqHdrVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return updCnt;
	}
	
	/**
	 * PRI_RQ_HDR 테이블을 일괄 삭제한다.<br>
	 * 
	 * @param List<PriRqHdrVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeRFAQuotationHeaderS(List<PriRqHdrVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new RFAQuotationMainDBDAOPriRqHdrVODSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return delCnt;
	}
	
	
	
	/**
	 * COPY TO QUOTATION PRI_RQ_HDR<br>
	 * 
	 * @param RsltCopyToQuotationVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCopyToQuotationRfaQuotationHeader(RsltCopyToQuotationVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new RFAQuotationMainDBDAOPriRqHdrVOAddCopyToQuotationCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * COPY TO QUOTATION PRI_RQ_MN<br>
	 * 
	 * @param RsltCopyToQuotationVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCopyToQuotationRfaQuotationMain(RsltCopyToQuotationVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new RFAQuotationMainDBDAOPriRqMnVOAddCopyToQuotationCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	

	/**
	 * PRI_RQ_MN 테이블 Qttn No 별 전체 삭제<br>
	 * 
	 * @param PriRqHdrVO vo
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeRfaQuotationMain(PriRqHdrVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new RFAQuotationMainDBDAOPriRqMnDeleteByQttnNoDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * RFA Quotation Main Inquiry(ESM_PRI_6015).<br>
	 * 
	 * @param RsltPriRqMnVO rsltPriRqMnVO
	 * @return List<RsltPriRqMnVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriRqMnVO> searchRFAQuotationMainReportList(RsltPriRqMnVO rsltPriRqMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriRqMnVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltPriRqMnVO != null){
				Map<String, String> mapVO = rsltPriRqMnVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAQuotationMainDBDAORsltPriRqMnVOReportRSQLRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriRqMnVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 

	/**
	 * RFA Quotation Rate Main Table에 변경된 Load값을 이용해서 CM 값을 재 계산해서 갱신한다.<br>
	 * 
	 * @param priRqRtCmdtRoutVO PriRqRtCmdtRoutVO
	 * @param pfmcUnit String TEU/FEU
	 * @throws DAOException
	 */
	public void modifyPrsPriRqMnCm(PriRqRtCmdtRoutVO priRqRtCmdtRoutVO,String pfmcUnit) throws DAOException, Exception {
		try {
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, Object> param = new HashMap<String, Object>();
			velParam.put("pfmc_unit", pfmcUnit);			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(priRqRtCmdtRoutVO != null){
				Map<String, String> mapVO = priRqRtCmdtRoutVO .getColumnValues();			
				param.putAll(mapVO);
				param.put("pfmc_unit", pfmcUnit);
			}
			
			
			int updCnt  = 0;
 
			updCnt = sqlExe.executeUpdate((ISQLTemplate) new RFAQuotationMainDBDAOPriRqMnCmVOUSQL(), param,
						velParam);
				 
			if (updCnt == Statement.EXECUTE_FAILED)  
						throw new DAOException("Fail to update  SQL");   
 
	 
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

}