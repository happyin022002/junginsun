/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UtilDBDAO.java
*@FileTitle : ESD_SPE_COM
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.common.util.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.spe.common.util.basic.UtilBCImpl;
import com.hanjin.apps.alps.esd.spe.common.util.vo.UtillVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS UtilDBDAO <br>
 * - ALPS-Common system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author HI
 * @see UtilBCImpl 참조
 * @since J2EE 1.6
 */
public class UtilDBDAO extends DBDAOSupport {

	/**
	 * RHQ Office 를 조회합니다.<br>
	 * 
	 * @param UtillVO utillVO
	 * @return List<UtillVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<UtillVO> searchRhqOfc(UtillVO utillVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<UtillVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(utillVO != null){
				Map<String, String> mapVO = utillVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UtilDBDAOSearchRhqOfcRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UtillVO .class);
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
	 * 지역별 Office 를 조회합니다.<br>
	 * 
	 * @param UtillVO utillVO
	 * @return List<UtillVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<UtillVO> searchOfc(UtillVO utillVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<UtillVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(utillVO != null){
				 Map<String, String> mapVO = utillVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UtilDBDAOSearchOfcRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, UtillVO .class);
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
	 * 공통코드 값을 조회한다. 코드와명을 붙여서 조회한다.<br>
	 * 
	 * @param UtillVO utillVO
	 * @return List<UtillVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<UtillVO> searchComCode(UtillVO utillVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<UtillVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(utillVO != null){
				 Map<String, String> mapVO = utillVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UtilDBDAOSearchComCodeRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, UtillVO .class);
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
	  * 공통코드 값을 조회한다 구분자를 텝 으로 코드와 명을 붙여온다.<br>
	  * 
	  * @param UtillVO utillVO
	  * @return List<UtillVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<UtillVO> searchComCode2(UtillVO utillVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<UtillVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(utillVO != null){
				 Map<String, String> mapVO = utillVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UtilDBDAOSearchComCode2RSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, UtillVO .class);
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
	  * 공통코드 값을 조회한다.<br>
	  * 
	  * @param UtillVO utillVO
	  * @return List<UtillVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<UtillVO> searchComCode3(UtillVO utillVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<UtillVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(utillVO != null){
				 Map<String, String> mapVO = utillVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UtilDBDAOSearchComCode3RSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, UtillVO .class);
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
	 * 사용자가 입력한 Control Office 코드가 존재하는 값인지 조회한다..<br>
	 * 
	 * @param UtillVO utillVO
	 * @return List<UtillVO>
	 * @exception DAOException
	 */
	 public List<UtillVO> searchOfcChk(UtillVO utillVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<UtillVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(utillVO != null){
				 Map<String, String> mapVO = utillVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UtilDBDAOSearchOfcChkRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, UtillVO .class);
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
	 * 사용자가 입력한 Vender 코드로 조회한다.<br>
	 * 
	 * @param UtillVO utillVO
	 * @return List<UtillVO>
	 * @exception DAOException
		 */
	 @SuppressWarnings("unchecked")
	 public List<UtillVO> searchVender(UtillVO utillVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<UtillVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(utillVO != null){
				 Map<String, String> mapVO = utillVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UtilDBDAOSearchVenderRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, UtillVO .class);
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
	  * 사용자가 입력한 USER 코드로 조회한다.<br>
	  * 
	  * @param UtillVO utillVO
	  * @return List<UtillVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<UtillVO> searchUser(UtillVO utillVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<UtillVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(utillVO != null){
				 Map<String, String> mapVO = utillVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UtilDBDAOSearchUserRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, UtillVO .class);
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
	  * 사용자가 입력한 Terminal 코드로 조회한다.<br>
	  * 
	  * @param UtillVO utillVO
	  * @return List<UtillVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<UtillVO> searchTerminal(UtillVO utillVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<UtillVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(utillVO != null){
				 Map<String, String> mapVO = utillVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UtilDBDAOSearchTerminalRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, UtillVO .class);
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