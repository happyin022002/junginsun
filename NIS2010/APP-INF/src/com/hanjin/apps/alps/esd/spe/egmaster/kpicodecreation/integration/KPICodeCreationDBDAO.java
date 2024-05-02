/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : KPICodeCreationDBDAO.java
*@FileTitle : KPI Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.egmaster.kpicodecreation.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.spe.egmaster.kpicodecreation.basic.KPICodeCreationBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.apps.alps.esd.spe.egmaster.kpicodecreation.vo.KPICodeCreVO;


/**
 * ALPS KPICodeCreationDBDAO <br>
 * - ALPS-EGMaster system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author HI
 * @see KPICodeCreationBCImpl 참조
 * @since J2EE 1.6
 */
public class KPICodeCreationDBDAO extends DBDAOSupport {

	
	 /**
	  * KPI Code Creation 데이터를 입력 한다.<br>
	  * 
	  * @param KPICodeCreVO kpiCodeCreVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void addKPICodeCre(KPICodeCreVO kpiCodeCreVO)throws DAOException {
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(kpiCodeCreVO != null){
				 //query parameter
				 Map<String, String> param = kpiCodeCreVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new KPICodeCreationDBDAOAddKPICodeCreCSQL() , param, null);
				 
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
	  * KPI Code Creation 데이터를 수정 한다.<br>
	  * 
	  * @param KPICodeCreVO kpiCodeCreVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void modifyKPICodeCre(KPICodeCreVO kpiCodeCreVO)throws DAOException {
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(kpiCodeCreVO != null){
				 //query parameter
				 Map<String, String> param = kpiCodeCreVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new KPICodeCreationDBDAOModifyKPICodeCreUSQL() , param, null);
				 
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
	  * KPI Code Creation 데이터를 삭제 한다.<br>
	  * 
	  * @param KPICodeCreVO kpiCodeCreVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void removeKPICodeCre(KPICodeCreVO kpiCodeCreVO)throws DAOException {
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(kpiCodeCreVO != null){
				 //query parameter
				 Map<String, String> param = kpiCodeCreVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new KPICodeCreationDBDAORemoveKPICodeCreUSQL() , param, null);
				 
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
		 * KPI Code Creation 데이터를 조회한다.<br>
		 * 
		 * @param KPICodeCreVO kpiCodeCreVO
		 * @return List<KPICodeCreVO>
		 * @exception EventException
		 */
		public List<KPICodeCreVO> searchKPICodeCre(KPICodeCreVO kpiCodeCreVO) throws DAOException {
			 DBRowSet dbRowset = null;
			 List<KPICodeCreVO> list = null;
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();
			 
			 try{
				 if(kpiCodeCreVO != null){
					 Map<String, String> mapVO = kpiCodeCreVO .getColumnValues();
					 
					 param.putAll(mapVO);
					 velParam.putAll(mapVO);
				 }
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KPICodeCreationDBDAOSearchKPICodeCreRSQL(), param, velParam);
				 list = (List)RowSetUtil.rowSetToVOs(dbRowset, KPICodeCreVO .class);
			 } catch(SQLException se) {
				 log.error(se.getMessage(),se);
				 throw new DAOException(new ErrorHandler(se).getMessage());
			 } catch(Exception ex) {
				 log.error(ex.getMessage(),ex);
				 throw new DAOException(new ErrorHandler(ex).getMessage());
			 }
			 return list;
		 }	 	 

}