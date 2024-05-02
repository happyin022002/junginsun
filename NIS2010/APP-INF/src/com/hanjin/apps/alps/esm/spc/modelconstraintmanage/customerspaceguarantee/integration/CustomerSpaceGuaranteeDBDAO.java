/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomerSpaceGuaranteeDBDAO.java
*@FileTitle : TP/SZ Volume Calculation Terms
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 이현주
*@LastVersion : 1.0
* 2009.09.07 이현주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelconstraintmanage.customerspaceguarantee.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.customerspaceguarantee.basic.CustomerSpaceGuaranteeBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.customerspaceguarantee.vo.SearchCustomerSpaceGuaranteeConvLaneListVO;
import com.hanjin.apps.alps.esm.spc.common.common.vo.SaqCntrSzConvVO;
import com.hanjin.apps.alps.esm.spc.common.common.vo.SaqCntrSzConvLaneVO;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.customerspaceguarantee.vo.SearchCustomerSpaceGuaranteeConvListVO;


/**
 * ALPS CustomerSpaceGuaranteeDBDAO <br>
 * - ALPS-ModelConstraintManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author HJ.LEE
 * @see CustomerSpaceGuaranteeBCImpl 참조
 * @since J2EE 1.6
 */
public class CustomerSpaceGuaranteeDBDAO extends DBDAOSupport {

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchCustomerSpaceGuaranteeConvLaneListVO searchCustomerSpaceGuaranteeConvLaneListVO
	 * @return List<SearchCustomerSpaceGuaranteeConvLaneListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchCustomerSpaceGuaranteeConvLaneListVO> searchCustomerSpaceGuaranteeConvLaneList(SearchCustomerSpaceGuaranteeConvLaneListVO searchCustomerSpaceGuaranteeConvLaneListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCustomerSpaceGuaranteeConvLaneListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchCustomerSpaceGuaranteeConvLaneListVO != null){
				Map<String, String> mapVO = searchCustomerSpaceGuaranteeConvLaneListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("SAQ_HJSBAT").executeQuery((ISQLTemplate)new CustomerSpaceGuaranteeDBDAOSearchCustomerSpaceGuaranteeConvLaneListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCustomerSpaceGuaranteeConvLaneListVO .class);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchCustomerSpaceGuaranteeConvListVO searchCustomerSpaceGuaranteeConvListVO
	 * @return List<SearchCustomerSpaceGuaranteeConvListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchCustomerSpaceGuaranteeConvListVO> searchCustomerSpaceGuaranteeConvList(SearchCustomerSpaceGuaranteeConvListVO searchCustomerSpaceGuaranteeConvListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCustomerSpaceGuaranteeConvListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchCustomerSpaceGuaranteeConvListVO != null){
				Map<String, String> mapVO = searchCustomerSpaceGuaranteeConvListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("SAQ_HJSBAT").executeQuery((ISQLTemplate)new CustomerSpaceGuaranteeDBDAOSearchCustomerSpaceGuaranteeConvListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCustomerSpaceGuaranteeConvListVO .class);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SaqCntrSzConvVO saqCntrSzConvVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addmultiCustomerSpaceGuarantee1(SaqCntrSzConvVO saqCntrSzConvVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = saqCntrSzConvVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SAQ_HJSBAT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CustomerSpaceGuaranteeDBDAOMultiSaqCntrSzConvCSQL(), param, velParam);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SaqCntrSzConvVO saqCntrSzConvVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifymultiCustomerSpaceGuarantee1(SaqCntrSzConvVO saqCntrSzConvVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = saqCntrSzConvVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SAQ_HJSBAT");
			result = sqlExe.executeUpdate((ISQLTemplate)new CustomerSpaceGuaranteeDBDAOMultiSaqCntrSzConvUSQL(), param, velParam);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SaqCntrSzConvVO saqCntrSzConvVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removemultiCustomerSpaceGuarantee1(SaqCntrSzConvVO saqCntrSzConvVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = saqCntrSzConvVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SAQ_HJSBAT");
			result = sqlExe.executeUpdate((ISQLTemplate)new CustomerSpaceGuaranteeDBDAOMultiSaqCntrSzConvDSQL(), param, velParam);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SaqCntrSzConvVO> saqCntrSzConvVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiCustomerSpaceGuarantee1S(List<SaqCntrSzConvVO> saqCntrSzConvVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SAQ_HJSBAT");
			if(saqCntrSzConvVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CustomerSpaceGuaranteeDBDAOMultiSaqCntrSzConvCSQL(), saqCntrSzConvVO,null);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SaqCntrSzConvVO> saqCntrSzConvVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymultiCustomerSpaceGuarantee1S(List<SaqCntrSzConvVO> saqCntrSzConvVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SAQ_HJSBAT");
			if(saqCntrSzConvVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CustomerSpaceGuaranteeDBDAOMultiSaqCntrSzConvUSQL(), saqCntrSzConvVO,null);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SaqCntrSzConvVO> saqCntrSzConvVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removemultiCustomerSpaceGuarantee1S(List<SaqCntrSzConvVO> saqCntrSzConvVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SAQ_HJSBAT");
			if(saqCntrSzConvVO .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new CustomerSpaceGuaranteeDBDAOMultiSaqCntrSzConvDSQL(), saqCntrSzConvVO,null);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SaqCntrSzConvLaneVO saqCntrSzConvLaneVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addmultiCustomerSpaceGuarantee2(SaqCntrSzConvLaneVO saqCntrSzConvLaneVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = saqCntrSzConvLaneVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SAQ_HJSBAT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CustomerSpaceGuaranteeDBDAOMultiSaqCntrSzConvLaneCSQL(), param, velParam);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SaqCntrSzConvLaneVO saqCntrSzConvLaneVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifymultiCustomerSpaceGuarantee2(SaqCntrSzConvLaneVO saqCntrSzConvLaneVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = saqCntrSzConvLaneVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SAQ_HJSBAT");
			result = sqlExe.executeUpdate((ISQLTemplate)new CustomerSpaceGuaranteeDBDAOMultiSaqCntrSzConvLaneUSQL(), param, velParam);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SaqCntrSzConvLaneVO saqCntrSzConvLaneVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removemultiCustomerSpaceGuarantee2(SaqCntrSzConvLaneVO saqCntrSzConvLaneVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = saqCntrSzConvLaneVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SAQ_HJSBAT");
			result = sqlExe.executeUpdate((ISQLTemplate)new CustomerSpaceGuaranteeDBDAOMultiSaqCntrSzConvLaneDSQL(), param, velParam);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SaqCntrSzConvLaneVO> saqCntrSzConvLaneVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiCustomerSpaceGuarantee2S(List<SaqCntrSzConvLaneVO> saqCntrSzConvLaneVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SAQ_HJSBAT");
			if(saqCntrSzConvLaneVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CustomerSpaceGuaranteeDBDAOMultiSaqCntrSzConvLaneCSQL(), saqCntrSzConvLaneVO,null);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SaqCntrSzConvLaneVO> saqCntrSzConvLaneVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymultiCustomerSpaceGuarantee2S(List<SaqCntrSzConvLaneVO> saqCntrSzConvLaneVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SAQ_HJSBAT");
			if(saqCntrSzConvLaneVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CustomerSpaceGuaranteeDBDAOMultiSaqCntrSzConvLaneUSQL(), saqCntrSzConvLaneVO,null);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SaqCntrSzConvLaneVO> saqCntrSzConvLaneVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removemultiCustomerSpaceGuarantee2S(List<SaqCntrSzConvLaneVO> saqCntrSzConvLaneVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SAQ_HJSBAT");
			if(saqCntrSzConvLaneVO .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new CustomerSpaceGuaranteeDBDAOMultiSaqCntrSzConvLaneDSQL(), saqCntrSzConvLaneVO,null);
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
	
}