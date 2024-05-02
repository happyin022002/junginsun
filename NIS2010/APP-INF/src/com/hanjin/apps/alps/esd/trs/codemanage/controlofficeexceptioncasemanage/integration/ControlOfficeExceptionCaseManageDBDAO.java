/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ControlOfficeExceptionCaseManageDBDAO.java
*@FileTitle : Control Office Exception Case Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-27
*@LastModifier : poong
*@LastVersion : 1.0
* 2006-09-27 poong
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.controlofficeexceptioncasemanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.codemanage.controlofficeexceptioncasemanage.basic.ControlOfficeExceptionCaseManageBCImpl;
import com.hanjin.apps.alps.esd.trs.codemanage.controlofficeexceptioncasemanage.event.EsdTrs0079Event;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.TrsTrspOfcExptRuleVO;

/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author poong
 * @see ControlOfficeExceptionCaseManageBCImpl 참조
 * @since J2EE 1.4
 */
public class ControlOfficeExceptionCaseManageDBDAO extends DBDAOSupport {

	/**
	 * ControlOfficeExceptionCaseManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchControlOfficeExceptionCaseManageList(EsdTrs0079Event event) throws DAOException {
        DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            ControlOfficeExceptionCaseManageDBDAOSearchControlOfficeExceptionCaseManageListRSQLRSQL template = new ControlOfficeExceptionCaseManageDBDAOSearchControlOfficeExceptionCaseManageListRSQLRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }
        return dbRowset;
	}
	
	/**
	 * ControlOfficeExceptionCaseManage의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void multiTRS_TRSP_OFC_EXPT_RULE(EsdTrs0079Event event) throws DAOException {
		try {
			int insCnt[] = null;
			SQLExecuter sqlExe = new SQLExecuter("");
			TrsTrspOfcExptRuleVO[] model = event.getTrsTrspOfcExptRuleVOS();
			Map<String,Object> param = new HashMap<String,Object>();

			Collection<TrsTrspOfcExptRuleVO> insertVoList = new ArrayList<TrsTrspOfcExptRuleVO>();
			Collection<TrsTrspOfcExptRuleVO> updateVoList = new ArrayList<TrsTrspOfcExptRuleVO>();
			Collection<TrsTrspOfcExptRuleVO> insertHisVoList = new ArrayList<TrsTrspOfcExptRuleVO>();
			
			String ofcCd = event.getFORM_USR_OFC_CD();
			String usrId = event.getFORM_CRE_USR_ID();
			
			param.put("OFC_CD", 	ofcCd);
			param.put("USR_ID", 	usrId);
			for ( int i=0; i<model.length; i++ ) {
				if ( model[i].getIbflag().equals("I")){
					insertVoList.add(model[i]);
				} else if ( model[i].getIbflag().equals("U")){
					updateVoList.add(model[i]);
				}
				insertHisVoList.add(model[i]);
			}
			
			//1. Office Exception Insert
			if(insertVoList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ControlOfficeExceptionCaseManageDBDAOMultiTrsTrspOfcExptRuleCSQL(), insertVoList, param, param);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}

			//2. Office Exception Delete
			if(updateVoList.size() > 0){	
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ControlOfficeExceptionCaseManageDBDAOMultiTrsTrspOfcExptRuleDSQL(), updateVoList, param, param);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}

			//3. Office Exception History Insert
			if(insertHisVoList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ControlOfficeExceptionCaseManageDBDAOMultiTrsTrspOfcExptRuleHisCSQL(), insertHisVoList, param, param);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
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
	 * ControlOfficeExceptionCaseManage의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchYardCode(EsdTrs0079Event event) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			Map<String, String> mapVO = event.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			ControlOfficeExceptionCaseManageDBDAOSearchYardCodeRSQL template = new ControlOfficeExceptionCaseManageDBDAOSearchYardCodeRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * ControlOfficeExceptionCaseManage의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchCountryCode(EsdTrs0079Event event) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			Map<String, String> mapVO = event.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			ControlOfficeExceptionCaseManageDBDAOSearchCountryCodeRSQL template = new ControlOfficeExceptionCaseManageDBDAOSearchCountryCodeRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * ControlOfficeExceptionCaseManage의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchControlOfficeCode(EsdTrs0079Event event) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			Map<String, String> mapVO = event.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			ControlOfficeExceptionCaseManageDBDAOSearchControlOfficeCodeRSQL template = new ControlOfficeExceptionCaseManageDBDAOSearchControlOfficeCodeRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * ControlOfficeExceptionCaseManage의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchEquipmentTP(EsdTrs0079Event event) throws DAOException {
        DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            ControlOfficeExceptionCaseManageDBDAOSearchEquipmentTPRSQL template = new ControlOfficeExceptionCaseManageDBDAOSearchEquipmentTPRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }
        return dbRowset;
	}
	
	/**
	 * ControlOfficeExceptionCaseManage의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchEquipmentSZ(EsdTrs0079Event event) throws DAOException {
        DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            ControlOfficeExceptionCaseManageDBDAOSearchEquipmentSZRSQL template = new ControlOfficeExceptionCaseManageDBDAOSearchEquipmentSZRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }
        return dbRowset;
	}
	
	/**
	 * ControlOfficeExceptionCaseManage의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet verifyControlOfficeCD(EsdTrs0079Event event) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			Map<String, String> mapVO = event.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			ControlOfficeExceptionCaseManageDBDAOVerifyControlOfficeCDRSQL template = new ControlOfficeExceptionCaseManageDBDAOVerifyControlOfficeCDRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	
	/**
	 * ControlOfficeExceptionCaseManage의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet verifySOOfficeCD(EsdTrs0079Event event) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			Map<String, String> mapVO = event.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			ControlOfficeExceptionCaseManageDBDAOverifySOOfficeCDRSQL template = new ControlOfficeExceptionCaseManageDBDAOverifySOOfficeCDRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
}