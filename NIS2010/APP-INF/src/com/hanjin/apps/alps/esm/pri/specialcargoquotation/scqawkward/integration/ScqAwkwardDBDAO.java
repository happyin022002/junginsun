/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScqAwkwardDBDAO.java
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
* 2013.06.26 이혜민 [CHM-201325215] Special cargo Quotation System 수정 요청 - Approval Office에서 Approval/Reject/Pending으로 처리한 경우  해당 Sales Rep 에게 GW Mail로 송부
* 2013.07.03 송호진 [CHM-201324872] Counter Offer Cancel 기능 추가
* 2013.07.25 송호진 [CHM-201325102] Approval Cancel 기능 추가
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.vo.OrganizationVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.basic.ScqAwkwardBCImpl;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.AwkCgoExtraCostByRouteVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.AwkCostByCgoRoutVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.PriScqAwkCgoVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.PriScqAwkCmdtListVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.PriScqAwkCntrTpszVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.PriScqAwkHdrVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.SearchOceanRouteYDListVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.vo.PriScqAtchFileVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS ScqAwkwardDBDAO <br>
 * - ALPS-SpecialCargoQuotation system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Dong-sun Moon
 * @see ScqAwkwardBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class ScqAwkwardDBDAO extends DBDAOSupport {

	/**
	 * PRI_SCQ_AWK_CGO  테이블 건 조회.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @return List<PriScqAwkCgoVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PriScqAwkCgoVO> searchPriScqAwkCgo(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriScqAwkCgoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priScqAwkHdrVO != null){
				Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScqAwkwardDBDAOSearchPriScqAwkCgoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScqAwkCgoVO .class);
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
	 * PRI_SCQ_AWK_CGO테이블 건 수정 ( Single ).<br>
	 * 
	 * @param PriScqAwkCgoVO priScqAwkCgoVO
	 * @return int
	 * @exception DAOException
	 * @exception Exception
	 */
	public int modifyPriScqAwkCgoVO(PriScqAwkCgoVO priScqAwkCgoVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priScqAwkCgoVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOmodifyPriScqAwkCgoUSQL(), param, velParam);
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
	 * PRI_SCQ_AWK_CGO   테이블 건 삭제 ( Single ).<br>
	 * 
	 * @param PriScqAwkCgoVO priScqAwkCgoVO
	 * @return int
	 * @exception DAOException
	 * @exception Exception
	 */
	public int removePriScqAwkCgoVO(PriScqAwkCgoVO priScqAwkCgoVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priScqAwkCgoVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOremovePriScqAwkCgoDSQL(), param, velParam);
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
	 * PRI_SCQ_AWK_CGO 테이블 건 생성 ( Multi ).<br>
	 * 
	 * @param List<PriScqAwkCgoVO> priScqAwkCgoVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] addPriScqAwkCgoVOS(List<PriScqAwkCgoVO> priScqAwkCgoVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priScqAwkCgoVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ScqAwkwardDBDAOaddPriScqAwkCgoCSQL(), priScqAwkCgoVO,null);
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
	 * PRI_SCQ_AWK_CGO테이블 건 수정 ( Multi ).<br>
	 * 
	 * @param List<PriScqAwkCgoVO> priScqAwkCgoVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyPriScqAwkCgoVOS(List<PriScqAwkCgoVO> priScqAwkCgoVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priScqAwkCgoVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ScqAwkwardDBDAOmodifyPriScqAwkCgoUSQL(), priScqAwkCgoVO,null);
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
	 * PRI_SCQ_AWK_CGO   테이블 건 삭제 ( Multi ).<br>
	 * 
	 * @param List<PriScqAwkCgoVO> priScqAwkCgoVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] removePriScqAwkCgoVOS(List<PriScqAwkCgoVO> priScqAwkCgoVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priScqAwkCgoVO .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ScqAwkwardDBDAOremovePriScqAwkCgoDSQL(), priScqAwkCgoVO,null);
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
	 * PRI_SCQ_AWK_ROUT
     * PRI_SCQ_AWK_ROUT_COST
     * PRI_SCQ_AWK_YD_COST 테이블 건 조회.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @return List<AwkCgoExtraCostByRouteVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AwkCgoExtraCostByRouteVO> searchAwkCgoExtraCostByRoute(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AwkCgoExtraCostByRouteVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priScqAwkHdrVO != null){
				Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScqAwkwardDBDAOsearchAwkCgoExtraCostByRouteRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AwkCgoExtraCostByRouteVO .class);
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
	 * PRI_SCQ_AWK_MN 
     * PRI_SCQ_PROG 테이블 건 조회.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @return List<PriScqAwkHdrVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PriScqAwkHdrVO> searchPriScqAwkHdr(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriScqAwkHdrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(priScqAwkHdrVO != null){
				Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScqAwkwardDBDAOsearchPriScqAwkHdrRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScqAwkHdrVO .class);
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
	 * PRI_SCQ_AWK_MN 새로운 Request No 조회.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @return String
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public String searchPriScqAwkNewRqstNo(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriScqAwkHdrVO> list = null;
		String result= null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(priScqAwkHdrVO != null){
				Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScqAwkwardDBDAOsearchPriScqAwkNewRqstNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScqAwkHdrVO .class);
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
	 * PRI_SCQ_AWK_MN 테이블 건 생성.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addPriScqAwkMn(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOaddPriScqAwkMnCSQL(), param, velParam);
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
	 * PRI_SCQ_AWK_MN 테이블 건 수정.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyPriScqAwkMn(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOmodifyPriScqAwkMnUSQL(), param, velParam);
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
	 * PRI_SCQ_AWK_MN 테이블 건 수정.( Approval Cancel 시 사용 )<br>
     * SCQ_RQST_NO, SCQ_VER_NO 기준 삭제된 가장 마지막 Approval 기록 직전의 Progress 상태로 Update.<br>
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyPriScqAwkMnForApprCxl(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOmodifyPriScqAwkMnForApprCxlUSQL(), param, velParam);
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
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addPriScqAwkProg(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOaddPriScqAwkProgCSQL(), param, velParam);
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
	 * PRI_SCQ_PROG  테이블 건 수정.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyPriScqAwkProg(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOmodifyPriScqAwkProgUSQL(), param, velParam);
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
	 * PRI_SCQ_AWK_MN 테이블 건 조회.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @return List<PriScqAwkHdrVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<PriScqAwkHdrVO> searchPriScqAwkRqstNo(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriScqAwkHdrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(priScqAwkHdrVO != null){
				Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScqAwkwardDBDAOsearchPriScqAwkRqstNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScqAwkHdrVO .class);
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
	 * PRI_SCQ_AWK_MN 테이블 건 조회.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @return List<PriScqAwkHdrVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<PriScqAwkHdrVO> searchPriScqAwkVerNo(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriScqAwkHdrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(priScqAwkHdrVO != null){
				Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScqAwkwardDBDAOsearchPriScqAwkVerNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScqAwkHdrVO .class);
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
	 * Commodity List를 조회한다. <br>
	 * 
	 * @param PriScqAwkCmdtListVO priScqAwkCmdtListVO
	 * @return List<PriScqAwkCmdtListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PriScqAwkCmdtListVO> searchCommodityList(PriScqAwkCmdtListVO priScqAwkCmdtListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriScqAwkCmdtListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priScqAwkCmdtListVO != null){
				Map<String, String> mapVO = priScqAwkCmdtListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScqAwkwardDBDAOsearchCmdtListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScqAwkCmdtListVO .class);
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
	 * MDM_CNTR_TP_SZ  테이블 건 조회.<br>
	 * 
	 * @param PriScqAwkCntrTpszVO priScqAwkCntrTpszVO
	 * @return List<PriScqAwkCntrTpszVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<PriScqAwkCntrTpszVO> searchPriScqAwkCntrTpsz(PriScqAwkCntrTpszVO priScqAwkCntrTpszVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriScqAwkCntrTpszVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(priScqAwkCntrTpszVO != null){
				Map<String, String> mapVO = priScqAwkCntrTpszVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScqAwkwardDBDAOsearchPriScqAwkCntrTpszRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScqAwkCntrTpszVO .class);
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
	 * 입력된 POL, POD 기준의 Ocean Route 와 
     * 각 Port 별 Yard 를 Proformer Schedule 및 TES 의 Main Yard 정보를 조회하여 가져온다..<br>
	 * 2012-02-28 생성
	 * @param  SearchConditionVO vo
	 * @return List<SearchOceanRouteYDListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchOceanRouteYDListVO> searchOceanRouteYDList(SearchConditionVO vo) throws DAOException{
		DBRowSet dbRowset = null;
		List<SearchOceanRouteYDListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ScqAwkwardDBDAOSearchOceanRouteYDListRSQL(), param, velParam);
//					EventResponse response = new GeneralEventResponse();
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchOceanRouteYDListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
			
	/**
	 * PRI_SCQ_AWK_CGO 테이블의 최종 CGO SEQ 조회.<br>
	 * 
	 * @param PriScqAwkCgoVO priScqAwkCgoVO
	 * @return String
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public String searchPriScqAwkNewCgoSeq(PriScqAwkCgoVO priScqAwkCgoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriScqAwkCgoVO> list = null;
		String result= null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(priScqAwkCgoVO != null){
				Map<String, String> mapVO = priScqAwkCgoVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScqAwkwardDBDAOsearchPriScqAwkNewCgoSeqRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScqAwkCgoVO .class);
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
	 * PRI_SCQ_AWK_MN 새로운 SCQ_VER_NO 조회.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @return String
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public String searchPriScqAwkNewVerNo(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriScqAwkHdrVO> list = null;
		String result= null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(priScqAwkHdrVO != null){
				Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScqAwkwardDBDAOsearchPriScqAwkNewVerNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScqAwkHdrVO .class);
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
	 * MDM_LOCATION
     * MDM_SVC_SCP_LMT 테이블 건 조회.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @return List<PriScqAwkHdrVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<PriScqAwkHdrVO> searchPriScqSvcScp(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriScqAwkHdrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(priScqAwkHdrVO != null){
				Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScqAwkwardDBDAOsearchPriScqSvcScpRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScqAwkHdrVO .class);
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
	 * PriScqAwkRout테이블 건 생성.<br>
	 * 
	 * @param List<AwkCgoExtraCostByRouteVO> awkCgoExtraCostByRouteVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] addPriScqAwkRoutVOS(List<AwkCgoExtraCostByRouteVO> awkCgoExtraCostByRouteVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(awkCgoExtraCostByRouteVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ScqAwkwardDBDAOaddPriScqAwkRoutCSQL(), awkCgoExtraCostByRouteVO,null);
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
	 * PRI_SCQ_AWK_ROUT 테이블 삭제.<br>
	 * 
	 * @param AwkCgoExtraCostByRouteVO awkCgoExtraCostByRouteVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int removePriScqAwkRoutVO(AwkCgoExtraCostByRouteVO awkCgoExtraCostByRouteVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = awkCgoExtraCostByRouteVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOremovePriScqAwkRoutDSQL(), param, velParam);
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

	/*
	 * Calculation Part 
	 */
	
	/**
	 * PRI_SCQ_AWK_MN_TMP 의 SCQ_RQST_NO 별 신규 SCQ_VER_NO 생성.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @return String
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public String searchPriScqAwkNewVerNoTmp(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriScqAwkHdrVO> list = null;
		String result= null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(priScqAwkHdrVO != null){
				Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScqAwkwardDBDAOsearchPriScqAwkNewVerNoTmpRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScqAwkHdrVO .class);
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
	 * PRI_SCQ_AWK_CGO_TMP 조회.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @return List<PriScqAwkCgoVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PriScqAwkCgoVO> searchPriScqAwkCgoTmp(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriScqAwkCgoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priScqAwkHdrVO != null){
				Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScqAwkwardDBDAOSearchPriScqAwkCgoTmpRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScqAwkCgoVO .class);
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
	 * PRI_SCQ_AWK_ROUT_TMP
     * PRI_SCQ_AWK_ROUT_SMRY_TMP
     * PRI_SCQ_AWK_YD_SMRY_TMP 테이블 건 조회.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @return List<AwkCgoExtraCostByRouteVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AwkCgoExtraCostByRouteVO> searchAwkCgoExtraCostByRouteTmp(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AwkCgoExtraCostByRouteVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priScqAwkHdrVO != null){
				Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScqAwkwardDBDAOsearchAwkCgoExtraCostByRouteTmpRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AwkCgoExtraCostByRouteVO .class);
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
	 * PRI_SCQ_AWK_MN_TMP 테이블 생성.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addPriScqAwkMnTmp(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOaddPriScqAwkMnTmpCSQL(), param, velParam);
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
	 * PRI_SCQ_AWK_CGO_TMP 테이블 생성.<br>
	 * 
	 * @param List<PriScqAwkCgoVO> priScqAwkCgoVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] addPriScqAwkCgoTmpVOS(List<PriScqAwkCgoVO> priScqAwkCgoVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priScqAwkCgoVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ScqAwkwardDBDAOaddPriScqAwkCgoTmpCSQL(), priScqAwkCgoVO,null);
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
	 * PRI_SCQ_AWK_ROUT_TMP 테이블 생성.<br>
	 * 
	 * @param List<AwkCgoExtraCostByRouteVO> awkCgoExtraCostByRouteVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] addPriScqAwkRoutTmpVOS(List<AwkCgoExtraCostByRouteVO> awkCgoExtraCostByRouteVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(awkCgoExtraCostByRouteVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ScqAwkwardDBDAOaddPriScqAwkRoutTmpCSQL(), awkCgoExtraCostByRouteVO,null);
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
	 * PRI_SCQ_PROG 삭제 ( Counter Offer Cancel 시 사용 )
     * SCQ_RQST_NO, SCQ_VER_NO 기준 데이터 삭제.<br>
     * SPCL_CGO_TP_CD = 'AK'
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removePriScqProgAwk(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOremovePriScqProgAwkDSQL(), param, velParam);
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
	 * PRI_SCQ_PROG 삭제 ( Approval Cancel 시 사용 )
     * SCQ_RQST_NO, SCQ_VER_NO 기준 가장 마지막 Approval 기록 데이터 삭제.<br>
     * SPCL_CGO_TP_CD = 'AK'
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removePriScqProgAwkForApprCxl(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOremovePriScqAwkProgForApprCxlDSQL(), param, velParam);
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
	 * PRI_SCQ_AWK_MN 삭제 ( Counter Offer Cancel 시 사용 )
     * SCQ_RQST_NO, SCQ_VER_NO 기준 데이터 삭제.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removePriScqAwkMn(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOremovePriScqAwkMnDSQL(), param, velParam);
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
	 * PRI_SCQ_AWK_MN_TMP 테이블 삭제.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removePriScqAwkMnTmp(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOremovePriScqAwkMnTmpDSQL(), param, velParam);
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
	 * PRI_SCQ_AWK_CGO 삭제 ( Copy 시 사용 )
     * SCQ_RQST_NO, SCQ_VER_NO 기준 전체 데이터 삭제.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removePriScqAwkCgoForCopy(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOremovePriScqAwkCgoForCopyDSQL(), param, velParam);
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
	 * PRI_SCQ_AWK_CGO_TMP 테이블 삭제.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removePriScqAwkCgoTmp(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOremovePriScqAwkCgoTmpDSQL(), param, velParam);
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
	 * PRI_SCQ_AWK_ROUT 삭제 ( Copy 시 사용 )
     * SCQ_RQST_NO, SCQ_VER_NO 기준 전체 데이터 삭제.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removePriScqAwkRoutForCopy(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOremovePriScqAwkRoutForCopyDSQL(), param, velParam);
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
	 * PRI_SCQ_AWK_ROUT_TMP 테이블 삭제.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removePriScqAwkRoutTmp(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOremovePriScqAwkRoutTmpDSQL(), param, velParam);
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
	 * PRI_SCQ_AWK_ROUT_DTL 삭제 ( Copy 시 사용 )
     * SCQ_RQST_NO, SCQ_VER_NO 기준 전체 데이터 삭제.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removePriScqAwkRoutDtlForCopy(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOremovePriScqAwkRoutDtlForCopyDSQL(), param, velParam);
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
	 * PRI_SCQ_AWK_ROUT_DTL_TMP 테이블 삭제.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removePriScqAwkRoutDtlTmp(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOremovePriScqAwkRoutDtlTmpDSQL(), param, velParam);
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
	 * PRI_SCQ_AWK_ROUT_SMRY 삭제 ( Copy 시 사용 )
     * SCQ_RQST_NO, SCQ_VER_NO 기준 전체 데이터 삭제.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removePriScqAwkRoutSmryForCopy(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOremovePriScqAwkRoutSmryForCopyDSQL(), param, velParam);
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
	 * PRI_SCQ_AWK_ROUT_SMRY_TMP 테이블 삭제.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removePriScqAwkRoutSmryTmp(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOremovePriScqAwkRoutSmryTmpDSQL(), param, velParam);
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
	 * PRI_SCQ_AWK_YD_DTL 삭제 ( Copy 시 사용 )
     * SCQ_RQST_NO, SCQ_VER_NO 기준 전체 데이터 삭제.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removePriScqAwkYdDtlForCopy(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOremovePriScqAwkYdDtlForCopyDSQL(), param, velParam);
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
	 * PRI_SCQ_AWK_YD_DTL_TMP 테이블 삭제.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removePriScqAwkYdDtlTmp(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOremovePriScqAwkYdDtlTmpDSQL(), param, velParam);
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
	 * PRI_SCQ_AWK_YD_SMRY 삭제 ( Copy 시 사용 )
     * SCQ_RQST_NO, SCQ_VER_NO 기준 전체 데이터 삭제.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removePriScqAwkYdSmryForCopy(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOremovePriScqAwkYdSmryForCopyDSQL(), param, velParam);
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
	 * PRI_SCQ_AWK_YD_SMRY_TMP 테이블 삭제.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removePriScqAwkYdSmryTmp(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOremovePriScqAwkYdSmryTmpDSQL(), param, velParam);
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
	 * PRI_SCQ_AWK_CGO Temp Table Copy 해오기.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void copyPriScqAwkCgo(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOcopyPriScqAwkCgoCSQL(), param, velParam);
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
	 * PRI_SCQ_AWK_CGO Temp Table Copy 해오기.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void copyPriScqAwkRout(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOcopyPriScqAwkRoutCSQL(), param, velParam);
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
	 * PRI_SCQ_AWK_ROUT_SMRY Temp Table Copy 해오기.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void copyPriScqAwkRoutSmry(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOcopyPriScqAwkRoutSmryCSQL(), param, velParam);
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
	 * PRI_SCQ_AWK_ROUT_DTL Temp Table Copy 해오기.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void copyPriScqAwkRoutDtl(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOcopyPriScqAwkRoutDtlCSQL(), param, velParam);
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
	 * PRI_SCQ_AWK_YD_SMRY Temp Table Copy 해오기.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void copyPriScqAwkYdSmry(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOcopyPriScqAwkYdSmryCSQL(), param, velParam);
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
	 * PRI_SCQ_AWK_YD_DTL Temp Table Copy 해오기.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void copyPriScqAwkYdDtl(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOcopyPriScqAwkYdDtlCSQL(), param, velParam);
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
	 * PRI_SCQ_AWK_ROUT_DTL_TMP 의 POL - T/S1, T/S Last - POD 구간 - Cargo 별 
     * Add - On Cost 계산 및 결과 생성.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void calcPriScqAwkRoutDtlTmpAddOnCost(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOcalcPriScqAwkRoutDtlTmpAddOnCostCSQL(), param, velParam);
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
	 * PRI_SCQ_AWK_ROUT_DTL_TMP 의 Shuttle Cost 계산 및 결과 생성.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void calcPriScqAwkRoutDtlTmpShuttleCost(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOcalcPriScqAwkRoutDtlTmpShuttleCostCSQL(), param, velParam);
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
	 * PRI_SCQ_AWK_ROUT_SMRY_TMP 테이블 생성
     * 기 계산 처리되어 생성된 PRI_SCQ_AWK_ROUT_DTL_TMP 데이터를 기반하여 Summary Data 를 생성한다.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void calcPriScqAwkRoutSmryTmp(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOcalcPriScqAwkRoutSmryTmpCSQL(), param, velParam);
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
	 * PRI_SCQ_AWK_YD_DTL_TMP 의 Yard - Cargo 별 Cost 계산 및 결과 생성.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void calcPriScqAwkYdDtlTmp(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOcalcPriScqAwkYdDtlTmpCSQL(), param, velParam);
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
	 * PRI_SCQ_AWK_YD_DTL_TMP 의 Yard - Cargo 별 Basic Cost ( POL, POD Route ) 계산 및 결과 생성.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void calcPriScqAwkYdDtlTmpBasic(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOcalcPriScqAwkYdDtlTmpBasicCostCSQL(), param, velParam);
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
	 * PRI_SCQ_AWK_YD_DTL_TMP 의 Yard - Cargo 별 T/S Cost ( T/S Route ) 계산 및 결과 생성.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void calcPriScqAwkYdDtlTmpTS(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOcalcPriScqAwkYdDtlTmpTSCostCSQL(), param, velParam);
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
	 * PRI_SCQ_AWK_YD_DTL_TMP 의 Yard - Cargo 별 Wire, S.Gear Cost ( POL, POD, T/S Route ) 계산 및 결과 생성.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void calcPriScqAwkYdDtlTmpWireSGear(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOcalcPriScqAwkYdDtlTmpWireSGearCostCSQL(), param, velParam);
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
	 * PRI_SCQ_AWK_YD_SMRY_TMP 테이블 생성
     * 기 계산 처리되어 생성된 PRI_SCQ_AWK_YD_DTL_TMP 데이터를 기반하여 Summary Data 를 생성한다..<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void calcPriScqAwkYdSmryTmp(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOcalcPriScqAwkYdSmryTmpCSQL(), param, velParam);
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
	 * Request 에 연결된 첨부 파일 내역을 Copy 에 포함.<br>
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
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOaddPriScqAtchFileCopyCSQL(), param, velParam);
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
	 * Cargo - Route 별 비용 리스트 TMP 건 조회.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @return List<AwkCostByCgoRoutVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AwkCostByCgoRoutVO> searchAwkCostByCgoRoutTmp(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AwkCostByCgoRoutVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priScqAwkHdrVO != null){
				Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScqAwkwardDBDAOsearchAwkCostByCgoRoutTmpRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AwkCostByCgoRoutVO .class);
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
	 * Cargo - Route 별 비용 리스트건 조회.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @return List<AwkCostByCgoRoutVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AwkCostByCgoRoutVO> searchAwkCostByCgoRout(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AwkCostByCgoRoutVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priScqAwkHdrVO != null){
				Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScqAwkwardDBDAOsearchAwkCostByCgoRoutRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AwkCostByCgoRoutVO .class);
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
	 * MDM_ORGANIZATION  테이블 건 조회.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @return List<OrganizationVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OrganizationVO> searchOfficeHierarchyList(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OrganizationVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priScqAwkHdrVO != null){
				Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScqAwkwardDBDAOsearchOfficeHierarchyListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OrganizationVO .class);
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
	 * Request or C/Offer 의 진행으로 신규로 생성되는 Version 에 대해
     * PRI_SCQ_AWK_CGO Table Copy 해오기.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void copyPriScqAwkRqstNoCgo(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOcopyPriScqAwkRqstNoCgoCSQL(), param, velParam);
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
	 * Request or C/Offer 의 진행으로 신규로 생성되는 Version 에 대해
     * PRI_SCQ_AWK_ROUT Table Copy 해오기.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void copyPriScqAwkRqstNoRout(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOcopyPriScqAwkRqstNoRoutCSQL(), param, velParam);
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
	 * Request or C/Offer 의 진행으로 신규로 생성되는 Version 에 대해
     * PRI_SCQ_AWK_ROUT_SMRY Table Copy 해오기.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void copyPriScqAwkRqstNoRoutSmry(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOcopyPriScqAwkRqstNoRoutSmryCSQL(), param, velParam);
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
	 * Request or C/Offer 의 진행으로 신규로 생성되는 Version 에 대해
     * PRI_SCQ_AWK_ROUT_DTL Table Copy 해오기.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void copyPriScqAwkRqstNoRoutDtl(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOcopyPriScqAwkRqstNoRoutDtlCSQL(), param, velParam);
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
	 * Request or C/Offer 의 진행으로 신규로 생성되는 Version 에 대해
     * PRI_SCQ_AWK_YD_SMRY Table Copy 해오기.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void copyPriScqAwkRqstNoYdSmry(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOcopyPriScqAwkRqstNoYdSmryCSQL(), param, velParam);
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
	 * Request or C/Offer 의 진행으로 신규로 생성되는 Version 에 대해
     * PRI_SCQ_AWK_YD_DTL Table Copy 해오기.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void copyPriScqAwkRqstNoYdDtl(PriScqAwkHdrVO priScqAwkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScqAwkHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScqAwkwardDBDAOcopyPriScqAwkRqstNoYdDtlCSQL(), param, velParam);
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
     * @param PriScqAwkHdrVO hdrVO
     * @return String[]
     * @exception DAOException
     */
    public String[] searchEmailTargetUser(PriScqAwkHdrVO hdrVO) throws DAOException {
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
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ScqAwkwardDBDAOsearchEmailTargetUserListRSQL(),param, velParam);  
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
}