/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SPServiceCategoryDBDAO.java
*@FileTitle : S/P Service Category Confirm
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.egmaster.spservicecategory.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.spe.egmaster.evaluationgroup.integration.EvaluationGroupDBDAOSearchEGDataChkRSQL;
import com.hanjin.apps.alps.esd.spe.egmaster.evaluationgroup.vo.SpeEGCreVO;
import com.hanjin.apps.alps.esd.spe.egmaster.spservicecategory.basic.SPServiceCategoryBCImpl;
import com.hanjin.apps.alps.esd.spe.egmaster.spservicecategory.event.EsdSpe1003Event;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.apps.alps.esd.spe.egmaster.spservicecategory.vo.SpeSvcCateVO;


/**
 * ALPS SPServiceCategoryDBDAO <br>
 * - ALPS-EGMaster system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author HI
 * @see SPServiceCategoryBCImpl 참조
 * @since J2EE 1.6
 */
public class SPServiceCategoryDBDAO extends DBDAOSupport {


	 /**
	  * 마스터 테이블에 업체등록<br>
	  * 
	  * @param SpeSvcCateVO speSvcCateVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void addSpSvcCateCfm(SpeSvcCateVO speSvcCateVO)throws DAOException {
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(speSvcCateVO != null){
				 //query parameter
				 Map<String, String> param = speSvcCateVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new SPServiceCategoryDBDAOAddSpSvcCateCfmCSQL() , param, null);
				 
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
	  * 업체의 서비스 카테고리 정보를 저장한다. <br>
	  * 
	  * @param SpeSvcCateVO speSvcCateVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void addSpSvcCateCfmStup(SpeSvcCateVO speSvcCateVO)throws DAOException {
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(speSvcCateVO != null){
				 //query parameter
				 Map<String, String> param = speSvcCateVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new SPServiceCategoryDBDAOAddSpSvcCateCfmStupCSQL() , param, null);
				 
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
	  * 업체와 업체의 서비스 카테고리 정보를 히스토리 테이블에 저장한다. <br>
	  * 
	  * @param SpeSvcCateVO speSvcCateVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void addSpSvcCateCfmHis(SpeSvcCateVO speSvcCateVO)throws DAOException {
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(speSvcCateVO != null){
				 //query parameter
				 Map<String, String> param = speSvcCateVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new SPServiceCategoryDBDAOAddSpSvcCateCfmHisCSQL() , param, null);
				 
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
	  * 업체와 업체의 서비스 카테고리 정보를 히스토리 테이블에 저장한다. <br>
	  * 
	  * @param SpeSvcCateVO speSvcCateVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void addSpSvcCateCfmHisChkYn(SpeSvcCateVO speSvcCateVO)throws DAOException {
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(speSvcCateVO != null){
				 //query parameter
				 Map<String, String> param = speSvcCateVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new SPServiceCategoryDBDAOAddSpSvcCateCfmHisChkYnCSQL() , param, null);
				 
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
	  * 마스터 테이블에 업체 삭제<br>
	  * 
	  * @param SpeSvcCateVO speSvcCateVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void removeSpSvcCateCfm(SpeSvcCateVO speSvcCateVO)throws DAOException {
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(speSvcCateVO != null){
				 //query parameter
				 Map<String, String> param = speSvcCateVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new SPServiceCategoryDBDAORemoveSpSvcCateCfmDSQL() , param, null);
				 
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
	  * 업체의 서비스 카테고리 정보 삭제<br>
	  * 
	  * @param SpeSvcCateVO speSvcCateVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void removeSpSvcCateCfmStup(SpeSvcCateVO speSvcCateVO)throws DAOException {
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(speSvcCateVO != null){
				 //query parameter
				 Map<String, String> param = speSvcCateVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new SPServiceCategoryDBDAORemoveSpSvcCateCfmStupDSQL() , param, null);
				 
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
	  * 업체의 서비스 카테고리 정보 삭제<br>
	  * 
	  * @param SpeSvcCateVO speSvcCateVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void removeSpSvcCateCfmHis(SpeSvcCateVO speSvcCateVO)throws DAOException {
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(speSvcCateVO != null){
				 //query parameter
				 Map<String, String> param = speSvcCateVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new SPServiceCategoryDBDAORemoveSpSvcCateCfmHisCSQL() , param, null);
				 
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
	 * 업체의 서비스 카테고리 정보를 조회한다.<br>
	 * 
	 * @param EsdSpe1003Event event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public DBRowSet searchSpSvcCateCfm(EsdSpe1003Event event) throws DAOException {
		 DBRowSet dbRowset = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
				 Map<String, String> mapVO = (event.getSpeSvcCateVO()).getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SPServiceCategoryDBDAOSearchSpSvcCateCfmRSQL(), param, velParam);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return dbRowset;
	 }	  
	 
	 
		/**
		 * 저장전 저장할수 있는 데이터 인지 확인한다.<br>
		 * 
		 * @param SpeSvcCateVO speSvcCateVO
		 * @return List<SpeSvcCateVO>
		 * @exception EventException
		 */
		public List<SpeSvcCateVO> searchSpSvcCateCfmChk(SpeSvcCateVO speSvcCateVO)  throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SpeSvcCateVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(speSvcCateVO != null){
				 Map<String, String> mapVO = speSvcCateVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SPServiceCategoryDBDAOSearchSpSvcCateCfmChkRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SpeSvcCateVO .class);
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