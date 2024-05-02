/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TerminalProductivityDBDAO.java
*@FileTitle : Terminal Productivity Target Input
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancemanagement.terminalproductivity.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.spe.egmapping.egandevaluator.integration.EGandEvaluatorDBDAOaddEGEVMappingCSQL;
import com.hanjin.apps.alps.esd.spe.egmapping.egandevaluator.vo.SpeEGEVMappingVO;
import com.hanjin.apps.alps.esd.spe.egmapping.evaluationgroupmapping.integration.EvaluationGroupMappingDBDAOSearchBECodeRSQL;
import com.hanjin.apps.alps.esd.spe.performancemanagement.terminalproductivity.basic.TerminalProductivityBCImpl;
import com.hanjin.apps.alps.esd.spe.performancemanagement.terminalproductivity.vo.TmlProdTgtInpVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS TerminalProductivityDBDAO <br>
 * - ALPS-PerformanceManagement system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author HI
 * @see TerminalProductivityBCImpl 참조
 * @since J2EE 1.6
 */
public class TerminalProductivityDBDAO extends DBDAOSupport {

	
	/**
	 * Terminal Productivity Target Input 을 조회한다.<br>
	 * 
	 * @param TmlProdTgtInpVO	tmlProdTgtInpVO
	 * @return List<TmlProdTgtInpVO>
	 * @exception EventException
	 */
	public List<TmlProdTgtInpVO> selectTmlProdTgtInp(TmlProdTgtInpVO tmlProdTgtInpVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TmlProdTgtInpVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(tmlProdTgtInpVO != null){
				Map<String, String> mapVO = tmlProdTgtInpVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalProductivityDBDAOSelectTmlProdTgtInpRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TmlProdTgtInpVO .class);
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
	  * Terminal Productivity 데이터를 입력한다.<br>
	  * 
	  * @param TmlProdTgtInpVO tmlProdTgtInpVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void addEGTmlProdTgtInp(TmlProdTgtInpVO tmlProdTgtInpVO)throws DAOException {
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(tmlProdTgtInpVO != null){
				 //query parameter
				 Map<String, String> param = tmlProdTgtInpVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new TerminalProductivityDBDAOAddEGEVMappingCSQL() , param, null);
				 
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to update SQL");
				 
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
	  * Terminal Productivity 데이터를 수정한다.<br>
	  * 
	  * @param TmlProdTgtInpVO tmlProdTgtInpVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void modifyTmlProdTgtInp(TmlProdTgtInpVO tmlProdTgtInpVO)throws DAOException {
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(tmlProdTgtInpVO != null){
				 //query parameter
				 Map<String, String> param = tmlProdTgtInpVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new TerminalProductivityDBDAOModifyTmlProdTgtInpUSQL() , param, null);
				 
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to update SQL");
				 
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
	  * Terminal Productivity 데이터를 삭제한다.<br>
	  * 
	  * @param TmlProdTgtInpVO tmlProdTgtInpVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void removeTmlProdTgtInp(TmlProdTgtInpVO tmlProdTgtInpVO)throws DAOException {
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(tmlProdTgtInpVO != null){
				 //query parameter
				 Map<String, String> param = tmlProdTgtInpVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new TerminalProductivityDBDAORemoveTmlProdTgtInpDSQL() , param, null);
				 
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to update SQL");
				 
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