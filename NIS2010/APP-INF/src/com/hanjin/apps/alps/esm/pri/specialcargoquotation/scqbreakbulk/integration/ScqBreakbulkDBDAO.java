/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScqBreakbulkDBDAO.java
*@FileTitle : Awkward Cargo Pricing Application
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.26
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.02.18 문동선
* 1.0 Creation
=========================================================
* History 
* 2013.07.03 송호진 [CHM-201324872] Counter Offer Cancel 기능 추가
* 2013.07.25 송호진 [CHM-201325102] Approval Cancel 기능 추가
* 2013.08.12 송호진 [CHM-201325335] Container Type & Q'ty 정보 Historical 관리 & Route 별 비용 Local Currency 적용
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration.PRICommonDBDAOMdmSubcontinentRSQL;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.basic.ScqAwkwardBCImpl;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.vo.PriScqBbCgoVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.vo.PriScqBbCntrTpszVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.vo.PriScqBbCntrVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.vo.PriScqBbHdrVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.vo.PriScqBbRoutCostVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.vo.PriScqAtchFileVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS ScqBreakbulkDBDAO <br>
 * - ALPS-SpecialCargoQuotation system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Dong-sun Moon
 * @see ScqAwkwardBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class ScqBreakbulkDBDAO extends DBDAOSupport {

	/**
	 * PRI_SCQ_BB_CGO  테이블 건 조회.<br>
	 * 
	 * @param PriScqBbCgoVO PriScqBbCgoVO
	 * @return List<PriScqBbCgoVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PriScqBbCgoVO> searchPriScqBbCgo(PriScqBbCgoVO PriScqBbCgoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriScqBbCgoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(PriScqBbCgoVO != null){
				Map<String, String> mapVO = PriScqBbCgoVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScqBreakbulkDBDAOsearchPriScqBbCgoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScqBbCgoVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * PRI_SCQ_BB_CGO  테이블 건 생성 ( Single ).<br>
	 * 
	 * @param PriScqBbCgoVO PriScqBbCgoVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addPriScqBbCgoVO(PriScqBbCgoVO PriScqBbCgoVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = PriScqBbCgoVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqBreakbulkDBDAOaddPriScqBbCgoCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * PRI_SCQ_BB_CGO 테이블 건 수정 ( Single ).<br>
	 * 
	 * @param PriScqBbCgoVO PriScqBbCgoVO
	 * @return int
	 * @exception DAOException
	 * @exception Exception
	 */
	public int modifyPriScqBbCgoVO(PriScqBbCgoVO PriScqBbCgoVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = PriScqBbCgoVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ScqBreakbulkDBDAOmodifyPriScqBbCgoUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * PRI_SCQ_BB_ROUT_COST 테이블 삭제.<br>
	 * 
	 * @param PriScqBbHdrVO PriScqBbHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removePriScqBbRoutCost(PriScqBbHdrVO PriScqBbHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = PriScqBbHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqBreakbulkDBDAOremovePriScqBbRoutCostDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Delete SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * PRI_SCQ_BB_ROUT 테이블 삭제.<br>
	 * 
	 * @param PriScqBbHdrVO PriScqBbHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removePriScqBbRout(PriScqBbHdrVO PriScqBbHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = PriScqBbHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqBreakbulkDBDAOremovePriScqBbRoutDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Delete SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	
	/**
	 * PRI_SCQ_BB_CNTR 테이블 삭제.<br>
	 * 
	 * @param PriScqBbHdrVO PriScqBbHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removePriScqBbCntr(PriScqBbHdrVO PriScqBbHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = PriScqBbHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqBreakbulkDBDAOremovePriScqBbCntrForCCDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Delete SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * PRI_SCQ_BB_CGO 테이블 삭제.<br>
	 * 
	 * @param PriScqBbHdrVO PriScqBbHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removePriScqBbCgo(PriScqBbHdrVO PriScqBbHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = PriScqBbHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqBreakbulkDBDAOremovePriScqBbCgoForCCDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Delete SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * PRI_SCQ_BB_MN 테이블 삭제.<br>
	 * 
	 * @param PriScqBbHdrVO PriScqBbHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removePriScqBbMn(PriScqBbHdrVO PriScqBbHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = PriScqBbHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqBreakbulkDBDAOremovePriScqBbMnDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Delete SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


	/**
	 * PRI_SCQ_PROG 테이블 삭제.<br>
	 * 
	 * @param PriScqBbHdrVO PriScqBbHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removePriScqProgBb(PriScqBbHdrVO PriScqBbHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = PriScqBbHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqBreakbulkDBDAOremovePriScqProgBbDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Delete SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * PRI_SCQ_PROG 삭제 ( Approval Cancel 시 사용 )
     * SCQ_RQST_NO, SCQ_VER_NO 기준 가장 마지막 Approval 기록 데이터 삭제.<br>
     * SPCL_CGO_TP_CD = 'BB'
	 * 
	 * @param PriScqBbHdrVO priScqBbHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removePriScqProgBbForApprCxl(PriScqBbHdrVO priScqBbHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqBbHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqBreakbulkDBDAOremovePriScqBbProgForApprCxlDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * PRI_SCQ_BB_CGO 테이블 건 삭제 ( Single ).<br>
	 * 
	 * @param PriScqBbCgoVO PriScqBbCgoVO
	 * @return int
	 * @exception DAOException
	 * @exception Exception
	 */
	public int removePriScqBbCgoVO(PriScqBbCgoVO PriScqBbCgoVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = PriScqBbCgoVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ScqBreakbulkDBDAOremovePriScqBbCgoDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * PRI_SCQ_BB_CNTR 테이블 건 조회.<br>
	 * 
	 * @param PriScqBbCntrVO PriScqBbCntrVO
	 * @return List<PriScqBbCntrVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PriScqBbCntrVO> searchPriScqBbCntr(PriScqBbCntrVO priScqBbCntrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriScqBbCntrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priScqBbCntrVO != null){
				Map<String, String> mapVO = priScqBbCntrVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScqBreakbulkDBDAOsearchPriScqBbCntrRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScqBbCntrVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * PRI_SCQ_BB_CNTR 테이블 건 생성 ( Single ).<br>
	 * 
	 * @param PriScqBbCntrVO PriScqBbCntrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addPriScqBbCntrVO(PriScqBbCntrVO PriScqBbCntrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = PriScqBbCntrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqBreakbulkDBDAOaddPriScqBbCntrCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * PRI_SCQ_BB_CNTR 테이블 건 수정 ( Single ).<br>
	 * 
	 * @param PriScqBbCntrVO PriScqBbCntrVO
	 * @return int
	 * @exception DAOException
	 * @exception Exception
	 */
	public int modifyPriScqBbCntrVO(PriScqBbCntrVO PriScqBbCntrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = PriScqBbCntrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ScqBreakbulkDBDAOmodifyPriScqBbCntrUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * PRI_SCQ_BB_CNTR 테이블 건 삭제 ( Single ).<br>
	 * 
	 * @param PriScqBbCntrVO PriScqBbCntrVO
	 * @return int
	 * @exception DAOException
	 * @exception Exception
	 */
	public int removePriScqBbCntrVO(PriScqBbCntrVO PriScqBbCntrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = PriScqBbCntrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ScqBreakbulkDBDAOremovePriScqBbCntrDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}	
	
	
	/**
	 * PRI_SCQ_BB_CGO  테이블 건 생성 ( Multi ).<br>
	 * 
	 * @param List<PriScqBbCgoVO> PriScqBbCgoVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] addPriScqBbCgoVOS(List<PriScqBbCgoVO> PriScqBbCgoVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(PriScqBbCgoVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ScqBreakbulkDBDAOaddPriScqBbCgoCSQL(), PriScqBbCgoVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * PRI_SCQ_BB_CGO 테이블 건 수정 ( Multi ).<br>
	 * 
	 * @param List<PriScqBbCgoVO> PriScqBbCgoVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyPriScqBbCgoVOS(List<PriScqBbCgoVO> PriScqBbCgoVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(PriScqBbCgoVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ScqBreakbulkDBDAOmodifyPriScqBbCgoUSQL(), PriScqBbCgoVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	/**
	 * PRI_SCQ_BB_CGO 테이블 건 삭제 ( Multi ).<br>
	 * 
	 * @param List<PriScqBbCgoVO> PriScqBbCgoVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] removePriScqBbCgoVOS(List<PriScqBbCgoVO> PriScqBbCgoVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(PriScqBbCgoVO .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ScqBreakbulkDBDAOremovePriScqBbCgoDSQL(), PriScqBbCgoVO,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
	
	/**
	 * PRI_SCQ_BB_CNTR 테이블 건 생성 ( Multi ).<br>
	 * 
	 * @param List<PriScqBbCntrVO> PriScqBbCntrVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] addPriScqBbCntrVOS(List<PriScqBbCntrVO> PriScqBbCntrVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(PriScqBbCntrVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ScqBreakbulkDBDAOaddPriScqBbCntrCSQL(), PriScqBbCntrVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * PRI_SCQ_BB_CNTR 테이블 건 수정 ( Multi ).<br>
	 * 
	 * @param List<PriScqBbCntrVO> PriScqBbCntrVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyPriScqBbCntrVOS(List<PriScqBbCntrVO> PriScqBbCntrVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(PriScqBbCntrVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ScqBreakbulkDBDAOmodifyPriScqBbCntrUSQL(), PriScqBbCntrVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	/**
	 * PRI_SCQ_BB_CNTR 테이블 건 삭제 ( Multi ).<br>
	 * 
	 * @param List<PriScqBbCntrVO> PriScqBbCntrVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] removePriScqBbCntrVOS(List<PriScqBbCntrVO> PriScqBbCntrVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(PriScqBbCntrVO .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ScqBreakbulkDBDAOremovePriScqBbCntrDSQL(), PriScqBbCntrVO,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}	
		 
	/**
	 * Break Bulk Quotation 용 Container Type Size List 조회.<br>
	 * 
	 * @param PriScqBbHdrVO PriScqBbHdrVO
	 * @return List<PriScqBbHdrVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PriScqBbHdrVO> searchPriScqBbHdr(PriScqBbHdrVO PriScqBbHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriScqBbHdrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(PriScqBbHdrVO != null){
				Map<String, String> mapVO = PriScqBbHdrVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScqBreakbulkDBDAOsearchPriScqBbHdrRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScqBbHdrVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	 
	
	/**
	 * PRI_SCQ_BB_MN 새로운 Request No 조회.<br>
	 * 
	 * @param PriScqBbHdrVO PriScqBbHdrVO
	 * @return String
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public String searchPriScqBbNewRqstNo(PriScqBbHdrVO PriScqBbHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriScqBbHdrVO> list = null;
		String result= null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(PriScqBbHdrVO != null){
				Map<String, String> mapVO = PriScqBbHdrVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScqBreakbulkDBDAOsearchPriScqBbNewRqstNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScqBbHdrVO .class);
			result = list.get(0).getScqRqstNo();
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}	 
		 
	/**
	 * PRI_SCQ_BB_MN 테이블 건 생성.<br>
	 * 
	 * @param PriScqBbHdrVO PriScqBbHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addPriScqBbMn(PriScqBbHdrVO PriScqBbHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = PriScqBbHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqBreakbulkDBDAOaddPriScqBbMnCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * PRI_SCQ_BB_MN 테이블 건 수정.<br>
	 * 
	 * @param PriScqBbHdrVO PriScqBbHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyPriScqBbMn(PriScqBbHdrVO PriScqBbHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = PriScqBbHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqBreakbulkDBDAOmodifyPriScqBbMnUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * PRI_SCQ_BB_MN 테이블 건 수정.( Approval Cancel 시 사용 )<br>
     * SCQ_RQST_NO, SCQ_VER_NO 기준 삭제된 가장 마지막 Approval 기록 직전의 Progress 상태로 Update.<br>
	 * @param PriScqBbHdrVO priScqBbHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyPriScqBbMnForApprCxl(PriScqBbHdrVO priScqBbHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqBbHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqBreakbulkDBDAOmodifyPriScqBbMnForApprCxlUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	

	/**
	 * PRI_SCQ_PROG 테이블 건 생성.<br>
	 * 
	 * @param PriScqBbHdrVO PriScqBbHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addPriScqBbProg(PriScqBbHdrVO PriScqBbHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = PriScqBbHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqBreakbulkDBDAOaddPriScqBbProgCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * PRI_SCQ_PROG 테이블 건 수정.<br>
	 * 
	 * @param PriScqBbHdrVO PriScqBbHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyPriScqBbProg(PriScqBbHdrVO PriScqBbHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = PriScqBbHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqBreakbulkDBDAOmodifyPriScqBbProgUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	 
	/**
	 * PRI_SCQ_BB_MN 테이블 건 조회.<br>
	 * 
	 * @param PriScqBbHdrVO PriScqBbHdrVO
	 * @return List<PriScqBbHdrVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<PriScqBbHdrVO> searchPriScqBbVerNo(PriScqBbHdrVO PriScqBbHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriScqBbHdrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(PriScqBbHdrVO != null){
				Map<String, String> mapVO = PriScqBbHdrVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScqBreakbulkDBDAOsearchPriScqBbVerNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScqBbHdrVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	} 
	 
	 
	/**
	 * Break Bulk Quotation 용 Container Type Size List 조회.<br>
	 * 
	 * @param PriScqBbCntrTpszVO PriScqBbCntrTpszVO
	 * @return List<PriScqBbCntrTpszVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<PriScqBbCntrTpszVO> searchPriScqBbCntrTpsz(PriScqBbCntrTpszVO PriScqBbCntrTpszVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriScqBbCntrTpszVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(PriScqBbCntrTpszVO != null){
				Map<String, String> mapVO = PriScqBbCntrTpszVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScqBreakbulkDBDAOsearchPriScqBbCntrTpszRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScqBbCntrTpszVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	} 	 
	 
	/**
	 * PRI_SCQ_BB_CGO 테이블의 최종 CGO SEQ 조회.<br>
	 * 
	 * @param PriScqBbCgoVO PriScqBbCgoVO
	 * @return String
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public String searchPriScqBbNewCgoSeq(PriScqBbCgoVO PriScqBbCgoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriScqBbCgoVO> list = null;
		String result= null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(PriScqBbCgoVO != null){
				Map<String, String> mapVO = PriScqBbCgoVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScqBreakbulkDBDAOsearchPriScqBbNewCgoSeqRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScqBbCgoVO .class);
			result = list.get(0).getCgoSeq();
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}		

	/**
	 * PRI_SCQ_BB_CNTR 테이블의 최종 CNTR SEQ 조회.<br>
	 * 
	 * @param PriScqBbCgoVO PriScqBbCgoVO
	 * @return String
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public String searchPriScqBbNewCntrSeq(PriScqBbCntrVO priScqBbCntrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriScqBbCntrVO> list = null;
		String result= null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(priScqBbCntrVO != null){
				Map<String, String> mapVO = priScqBbCntrVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScqBreakbulkDBDAOsearchPriScqBbNewCntrSeqRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScqBbCntrVO .class);
			result = list.get(0).getCntrSeq();
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}		 
	 
	/**
	 * PRI_SCQ_BB_CNTR 테이블의 최종 CNTR_GRP_VER_NO + 1 조회.<br>
	 * 
	 * @param PriScqBbHdrVO priScqBbHdrVO
	 * @return String
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public String searchPriScqBbNewCntrGrpVerNo(PriScqBbHdrVO priScqBbHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriScqBbCntrVO> list = null;
		String result= null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(priScqBbHdrVO != null){
				Map<String, String> mapVO = priScqBbHdrVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScqBreakbulkDBDAOsearchPriScqBbNewCntrGrpVerNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScqBbCntrVO .class);
			result = list.get(0).getCntrGrpVerNo();
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}		 
		 
	/**
	 * PRI_SCQ_BB_MN 새로운 SCQ_VER_NO 조회.<br>
	 * 
	 * @param PriScqBbHdrVO PriScqBbHdrVO
	 * @return String
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public String searchPriScqBbNewVerNo(PriScqBbHdrVO PriScqBbHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriScqBbHdrVO> list = null;
		String result= null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(PriScqBbHdrVO != null){
				Map<String, String> mapVO = PriScqBbHdrVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScqBreakbulkDBDAOsearchPriScqBbNewVerNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScqBbHdrVO .class);
			result = list.get(0).getScqVerNo();
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}		 

	 
	 
	/**
	 * MDM_LOCATION MDM_SVC_SCP_LMT 테이블 건 조회.<br>
	 * 
	 * @param PriScqBbHdrVO PriScqBbHdrVO
	 * @return List<PriScqBbHdrVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<PriScqBbHdrVO> searchPriScqBbSvcScp(PriScqBbHdrVO PriScqBbHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriScqBbHdrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(PriScqBbHdrVO != null){
				Map<String, String> mapVO = PriScqBbHdrVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScqBreakbulkDBDAOsearchPriScqBbSvcScpRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScqBbHdrVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;	 
	 }
	 

	/**
	 * PRI_SCQ_BB_ROUT  테이블 건 조회.<br>
	 * 
	 * @param PriScqBbRoutCostVO priScqBbRoutCostVO
	 * @return List<PriScqBbRoutCostVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PriScqBbRoutCostVO> searchPriScqBbRoutCost(PriScqBbRoutCostVO priScqBbRoutCostVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<PriScqBbRoutCostVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
		
			try{
				if(priScqBbRoutCostVO != null){
					Map<String, String> mapVO = priScqBbRoutCostVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScqBreakbulkDBDAOsearchPriScqBbRoutCostRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScqBbRoutCostVO .class);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;	 
		 }	 
	 
	/**
	 * PRI_SCQ_BB_ROUT 새로운 ROUT_SEQ_VER_NO 조회.<br>
	 * 
	 * @param PriScqBbHdrVO PriScqBbHdrVO
	 * @return String
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public String searchPriScqBbNewRoutSeqVerNo(PriScqBbRoutCostVO priScqBbRoutCostVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriScqBbRoutCostVO> list = null;
		String result= null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(priScqBbRoutCostVO != null){
				Map<String, String> mapVO = priScqBbRoutCostVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScqBreakbulkDBDAOsearchPriScqBbNewRoutSeqVerNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScqBbRoutCostVO .class);
			result = list.get(0).getRoutSeqVerNo();
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}		 
	 
	/**
	 * PRI_SCQ_BB_ROUT 테이블 건 생성.<br>
	 * 
	 * @param List<PriScqBbRoutCostVO> insModels
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addPriScqBbRout(PriScqBbRoutCostVO priScqBbRoutCostVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqBbRoutCostVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqBreakbulkDBDAOaddPriScqBbRoutCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * PRI_SCQ_BB_ROUT_COST 테이블 건 생성.<br>
	 * 
	 * @param List<PriScqBbRoutCostVO> insModels
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addPriScqBbRoutCost(List<PriScqBbRoutCostVO> insModels) throws DAOException,Exception {
	    try {
	        SQLExecuter sqlExe = new SQLExecuter("");
	        int insCnt[] = null;
	        if(insModels.size() > 0){
	            insCnt = sqlExe.executeBatch((ISQLTemplate)new ScqBreakbulkDBDAOaddPriScqBbRoutCostCSQL(), insModels,null);
	            for(int i = 0; i < insCnt.length; i++){
	                if(insCnt[i]== Statement.EXECUTE_FAILED)
	                    throw new DAOException("Fail to insert No"+ i + " SQL");
	            }
	        }
	    }catch(SQLException se) {
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage(),se);
	    }catch(Exception ex){
	        log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
	    }
	} 
	
	/**
	 * PRI_SCQ_BB_ROUT 테이블 건 수정.<br>
	 * 
	 * @param PriScqBbCgoVO PriScqBbCgoVO
	 * @return int
	 * @exception DAOException
	 * @exception Exception
	 */
	public int modifyPriScqBbRout(PriScqBbRoutCostVO priScqBbRoutCostVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priScqBbRoutCostVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ScqBreakbulkDBDAOmodifyPriScqBbRoutUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}	
	
	/**
	 * PRI_SCQ_BB_ROUT_COST 테이블 건 수정.<br>
	 * 
	 * @param List<PriScqBbCntrVO> PriScqBbCntrVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyPriScqBbRoutCost(List<PriScqBbRoutCostVO> priScqBbRoutCostVOs) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priScqBbRoutCostVOs .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ScqBreakbulkDBDAOmodifyPriScqBbRoutCostUSQL(), priScqBbRoutCostVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	/**
	 * Request 에 연결된 첨부 파일 내역을 Copy 에 포함..<br>
	 * 
	 * @param PriScqAtchFileVO priScqAtchFileVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addPriScqAtchFileCopy(PriScqAtchFileVO priScqAtchFileVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAtchFileVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqBreakbulkDBDAOaddPriScqAtchFileCopyCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
    /**
     * 메일 보내는 대상을 조회한다.<br>
     *
     * @param PriScqBbHdrVO hdrVO
     * @return String[]
     * @exception DAOException
     */
    public String[] searchEmailTargetUser(PriScqBbHdrVO hdrVO) throws DAOException {
        DBRowSet dbRowset = null;
        String[] toUser = null;

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (hdrVO != null) {
                Map<String, String> mapVO = hdrVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ScqBreakbulkDBDAOsearchEmailTargetUserListRSQL(),param, velParam);  
            if(dbRowset != null){
            	int i=0;
	            while (dbRowset.next()){
		        	if (i == 0) {
		        		toUser = new String[dbRowset.getRowCount()];
		        	}
				    toUser[i] = dbRowset.getString("TO_USER");
					i++;
			    }
            } 
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return toUser;
    }

	/**
	 * LANE - POL 별 VVD - ETA DT 리스트를 조회한다.<br>
	 * 
	 * @param PriScqBbHdrVO hdrVO
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchVVDETAList(PriScqBbHdrVO hdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (hdrVO != null) {
				Map<String, String> mapVO = hdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ScqBreakbulkDBDAOsearchVVDETAListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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