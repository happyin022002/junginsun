/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DualTypeExceptionMgtDAO.java
*@FileTitle : Dual Type Exception Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.07
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.05.07 이성훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.CoverageVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.basic.DualTypeExceptionMgtBCImpl;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo.DualTypeCustomerVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo.SCOrDARListInputVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo.SCOrDARListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

 /**
  * OPUS DualTypeExceptionMgtDAO <br>
  * - OPUS-DMTExceptionMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
  * 
  * @author SungHoon, Lee
  * @see DualTypeExceptionMgtBCImpl 참조
  * @since J2EE 1.6
  */ 
public class DualTypeExceptionMgtDBDAO extends DBDAOSupport {

	/**
	 * Dual Type Exception 에 기등록된 Customer 정보를 조회 합니다. <br>
	 * 
	 * @return List<DualTypeCustomerVO>
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public List<DualTypeCustomerVO> searchDualTypeCustomerList() throws DAOException {
		DBRowSet dbRowset = null;
		List<DualTypeCustomerVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new DualTypeExceptionMgtDBDAODualTypeCustomerListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DualTypeCustomerVO .class);
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
	 * Dual Type Exception을 조회 합니다. <br>
	 * 
	 * @param DualTypeCustomerVO dualTypeCustomerVO
	 * @return List<DualTypeCustomerVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<DualTypeCustomerVO> searchDualTypeCustomer(DualTypeCustomerVO dualTypeCustomerVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DualTypeCustomerVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(dualTypeCustomerVO != null){
				Map<String, String> mapVO = dualTypeCustomerVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new DualTypeExceptionMgtDBDAODualTypeCustomerRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DualTypeCustomerVO .class);
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
	 * Dual Type Exception을 생성 합니다. <br>
	 * 
	 * @param List<DualTypeCustomerVO> dualTypeCustomerVOs
	 * @exception DAOException
	 */
	public void addDualTypeCustomer(List<DualTypeCustomerVO> dualTypeCustomerVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (dualTypeCustomerVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new DualTypeExceptionMgtDBDAODualTypeCustomerCSQL(), dualTypeCustomerVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Dual Type Exception을 수정 합니다. <br>
	 * 
	 * @param List<DualTypeCustomerVO> dualTypeCustomerVOs
	 * @exception DAOException
	 */
	public void modifyDualTypeCustomer(List<DualTypeCustomerVO> dualTypeCustomerVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (dualTypeCustomerVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new DualTypeExceptionMgtDBDAODualTypeCustomerUSQL(), dualTypeCustomerVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Dual Type Exception을 삭제 합니다. <br>
	 * 
	 * @param List<DualTypeCustomerVO> dualTypeCustomerVOs
	 * @exception DAOException
	 */
	public void removeDualTypeCustomer(List<DualTypeCustomerVO> dualTypeCustomerVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(dualTypeCustomerVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new DualTypeExceptionMgtDBDAODualTypeCustomerDSQL(), dualTypeCustomerVOs, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Dual Type Exception Coverage의 Dual Type 여부를 조회 합니다.<br>
	 * 
	 * @param CoverageVO coverageVO
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean checkDualCoverage(CoverageVO coverageVO) throws DAOException {
		boolean result = false;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(coverageVO != null){
				Map<String, String> mapVO = coverageVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new DualTypeExceptionMgtDBDAOCheckDualCoverageRSQL(), param, velParam);
			if (dbRowset.next())
				result = dbRowset.getInt(1) > 0 ? true : false;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	
	/**
	 * Dual Type Exception(S/C)의 삭제가능 여부를 조회 합니다.<br>
	 * 
	 * @param DualTypeCustomerVO dualTypeCustomerVO
	 * @return String
	 * @exception DAOException
	 */
	public String checkDelDualTypeCustomerBySC(DualTypeCustomerVO dualTypeCustomerVO) throws DAOException {
		String result = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(dualTypeCustomerVO != null){
				Map<String, String> mapVO = dualTypeCustomerVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
						new DualTypeExceptionMgtDBDAOCheckDelDualTypeCustomerBySCRSQL(), param, velParam);
			
			if (dbRowset.next()) {
				result = dbRowset.getString(1);
			}			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	
	/**
	 * Dual Type Exception(Before Booking)의 삭제가능 여부를 조회 합니다.<br>
	 * 
	 * @param DualTypeCustomerVO dualTypeCustomerVO
	 * @return String
	 * @exception DAOException
	 */
	public String checkDelDualTypeCustomerByRFA(DualTypeCustomerVO dualTypeCustomerVO) throws DAOException {
		String result = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(dualTypeCustomerVO != null){
				Map<String, String> mapVO = dualTypeCustomerVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new DualTypeExceptionMgtDBDAOCheckDelDualTypeCustomerByRFARSQL(), param, velParam);
			
			if (dbRowset.next()) {
				result = dbRowset.getString(1);
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	
	/**
	 * Dual Type Exception(S/C) Expire Date 가 유효한지 조회 합니다.<br>
	 * 
	 * @param DualTypeCustomerVO dualTypeCustomerVO
	 * @return String
	 * @exception DAOException
	 */
	public String checkDelDualTypeExpireDateBySC(DualTypeCustomerVO dualTypeCustomerVO) throws DAOException {
		String result = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(dualTypeCustomerVO != null){
				Map<String, String> mapVO = dualTypeCustomerVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
						new DualTypeExceptionMgtDBDAOCheckDualTypeExpireDateBySCRSQL(), param, velParam);
			
			if (dbRowset.next()) {
				result = dbRowset.getString(1);
			}			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	
	/**
	 * Dual Type Exception(Before Booking) Expire Date 가 유효한지 조회 합니다.<br>
	 * 
	 * @param DualTypeCustomerVO dualTypeCustomerVO
	 * @return String
	 * @exception DAOException
	 */
	public String checkDelDualTypeExpireDateByRFA(DualTypeCustomerVO dualTypeCustomerVO) throws DAOException {
		String result = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(dualTypeCustomerVO != null){
				Map<String, String> mapVO = dualTypeCustomerVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new DualTypeExceptionMgtDBDAOCheckDualTypeExpireDateByRFARSQL(), param, velParam);
			
			if (dbRowset.next()) {
				result = dbRowset.getString(1);
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	
	/**
	 * 등록할 Dual Type Exception 이 기등록된 것인지 조회 합니다.<br>
	 * 
	 * @param DualTypeCustomerVO dualTypeCustomerVO
	 * @return DualTypeCustomerVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public DualTypeCustomerVO checkDuplicateDualTypeException(DualTypeCustomerVO dualTypeCustomerVO) throws DAOException {
		List<DualTypeCustomerVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(dualTypeCustomerVO != null){
				Map<String, String> mapVO = dualTypeCustomerVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new DualTypeExceptionMgtDBDAOCheckDuplicateDualTypeExceptionRSQL(), param, velParam);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DualTypeCustomerVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	
	/**
	 * 기등록된 Dual Type Exception 를 조회하는 함수<br>
	 * 
	 * @param SCOrDARListInputVO sCOrDARListInputVO
	 * @return List<SCOrDARListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")	
	public List<SCOrDARListVO> searchSCorDARListByCustomer(SCOrDARListInputVO sCOrDARListInputVO) throws DAOException {
		List<SCOrDARListVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if (sCOrDARListInputVO != null){
				Map<String, String> mapVO = sCOrDARListInputVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(sCOrDARListInputVO != null) {
				if ("S".equals(sCOrDARListInputVO.getDmdtCtrtExptTpCd())) {
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
							new DualTypeExceptionMgtDBDAOSearchDualTypeExceptionAppliedBySCRSQL(), param, velParam);
				}
				else if ("B".equals(sCOrDARListInputVO.getDmdtCtrtExptTpCd())) { 
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
							new DualTypeExceptionMgtDBDAOSearchDualTypeExceptionAppliedByRFARSQL(), param, velParam);
				}
			}
			if(dbRowset != null) {
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SCOrDARListVO .class);
			}
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
	* Dual Type Exception의 다음 Sequence를 조회 합니다.<br>
	* 
	* @param DualTypeCustomerVO dualTypeCustomerVO
	* @return String
	* @exception DAOException
	*/	 
	public String searchNextCustExptSeq(DualTypeCustomerVO dualTypeCustomerVO) throws DAOException {
		String result = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(dualTypeCustomerVO != null){
				Map<String, String> mapVO = dualTypeCustomerVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new DualTypeExceptionMgtDBDAOSearchNextCustExptSeqRSQL(), param, velParam);

			if (dbRowset.next())
				result = dbRowset.getString(1);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result; 
	 }
}
