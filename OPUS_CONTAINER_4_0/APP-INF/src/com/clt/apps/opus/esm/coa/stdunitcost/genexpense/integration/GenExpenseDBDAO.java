/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GenExpenseDBDAO.java
*@FileTitle : General Expense
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.23
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2012.02.23 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.genexpense.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.coa.stdunitcost.genexpense.basic.GenExpenseBCImpl;
import com.clt.apps.opus.esm.coa.stdunitcost.genexpense.vo.SearchGeneralExpenseVO;
import com.clt.apps.opus.esm.coa.stdunitcost.genexpense.vo.SearchGeneralExpenseByVesselVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.CoaDmdtN3rdPtyVO;


/**
 * ALPS GenExpenseDBDAO <br>
 * - ALPS-STDUnitCost system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author CHOI SUGMIN
 * @see GenExpenseBCImpl 참조
 * @since J2EE 1.6
 */
public class GenExpenseDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4703470364755516270L;

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param CoaDmdtN3rdPtyVO coaDmdtN3rdPtyVO
	 * @return List<SearchGeneralExpenseVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchGeneralExpenseVO> searchGeneralExpenseList(CoaDmdtN3rdPtyVO coaDmdtN3rdPtyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchGeneralExpenseVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(coaDmdtN3rdPtyVO != null){
				Map<String, String> mapVO = coaDmdtN3rdPtyVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GenExpenseDBDAOSearchGeneralExpenseVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchGeneralExpenseVO .class);
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
	 * [일반관리비] 정보를 [수정] 합니다.<br>
	 * 
	 * @param List<CoaDmdtN3rdPtyVO> coaDmdtN3rdPtyVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifymultiGeneralExpenseS(List<CoaDmdtN3rdPtyVO> coaDmdtN3rdPtyVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(coaDmdtN3rdPtyVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new GenExpenseDBDAOCoaDmdtN3rdPtyVOUSQL(), coaDmdtN3rdPtyVO,null);
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
	}
	

	/**
	 * [VSL별 General Expense] 정보를 [조회] 합니다.<br>
	 * 
	 * @param CoaDmdtN3rdPtyVO coaDmdtN3rdPtyVO
	 * @return List<SearchOwnDailyHireVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchGeneralExpenseByVesselVO> searchGeneralExpenseByVessel(CoaDmdtN3rdPtyVO coaDmdtN3rdPtyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchGeneralExpenseByVesselVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(coaDmdtN3rdPtyVO != null){
				Map<String, String> mapVO = coaDmdtN3rdPtyVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GenExpenseDBDAOSearchGeneralExpenseByVesselRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchGeneralExpenseByVesselVO .class);
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
	 * [VSL별 General Expense] 정보를 [행위] 합니다.<br>
	 * 
	 * @param CoaDmdtN3rdPtyVO coaDmdtN3rdPtyVO
	 * @return List<SearchOwnDailyHireVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchGeneralExpenseByVesselVO> searchGeneralExpenseByVesselClass(CoaDmdtN3rdPtyVO coaDmdtN3rdPtyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchGeneralExpenseByVesselVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(coaDmdtN3rdPtyVO != null){
				Map<String, String> mapVO = coaDmdtN3rdPtyVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GenExpenseDBDAOsearchGeneralExpenseByVesselClassRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchGeneralExpenseByVesselVO .class);
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
	 * [VSL별 GeneralExpense] 정보를 [생성] 합니다.<br>
	 * 
	 * @param CoaDmdtN3rdPtyVO coaDmdtN3rdPtyVO
	 * @exception DAOException
	 */
	public void addGeneralExpenseByVessel(CoaDmdtN3rdPtyVO coaDmdtN3rdPtyVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(coaDmdtN3rdPtyVO != null){
				Map<String, String> mapVO = coaDmdtN3rdPtyVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				sqlExe.executeSP((ISQLTemplate)new GenExpenseDBDAOCreateGeneralExpenseByVesselCSQL(), param, velParam);
			}		
				
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
		

	/**
	 * [일반관리비] 정보를 [수정] 합니다.<br>
	 * 
	 * @param List<CoaDmdtN3rdPtyVO> coaDmdtN3rdPtyVO
	 * @exception DAOException
	 * @exception Exception
	 * @author SJH.20141229.ADD
	 */
	public void modifymultiGeneralExpense3(List<CoaDmdtN3rdPtyVO> coaDmdtN3rdPtyVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(coaDmdtN3rdPtyVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new GenExpenseDBDAOModifyGeneralExpense3USQL(), coaDmdtN3rdPtyVO,null);
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
	}
	
	/**
	 * [일반관리비] 정보를 [등록] 합니다.<br>
	 * 
	 * @param List<CoaDmdtN3rdPtyVO> coaDmdtN3rdPtyVO
	 * @exception DAOException
	 * @exception Exception
	 * @author SJH.20141229.ADD
	 */
	public void addGeneralExpense4(List<CoaDmdtN3rdPtyVO> coaDmdtN3rdPtyVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(coaDmdtN3rdPtyVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new GenExpenseDBDAOAddGeneralExpense4CSQL(), coaDmdtN3rdPtyVO,null);
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
	}		
	
	/**
	 * [일반관리비] 정보를 [수정] 합니다.<br>
	 * 
	 * @param List<CoaDmdtN3rdPtyVO> coaDmdtN3rdPtyVO
	 * @exception DAOException
	 * @exception Exception
	 * @author SJH.20141229.ADD
	 */
	public void modifyGeneralExpense4(List<CoaDmdtN3rdPtyVO> coaDmdtN3rdPtyVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(coaDmdtN3rdPtyVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new GenExpenseDBDAOModifyGeneralExpense4USQL(), coaDmdtN3rdPtyVO,null);
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
	}	
	
	/**
	 * [일반관리비] 정보를 [삭제] 합니다.<br>
	 * 
	 * @param List<CoaDmdtN3rdPtyVO> coaDmdtN3rdPtyVO
	 * @exception DAOException
	 * @exception Exception
	 * @author SJH.20141229.ADD
	 */
	public void removeGeneralExpense4(List<CoaDmdtN3rdPtyVO> coaDmdtN3rdPtyVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(coaDmdtN3rdPtyVO .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new GenExpenseDBDAORemoveGeneralExpense4DSQL(), coaDmdtN3rdPtyVO,null);
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
	}		

}