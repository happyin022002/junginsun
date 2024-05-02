/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : ReceiveQueueVMSDBDAO.java
 *@FileTitle : GNOSS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011-10-07
 *@LastModifier : Myoung Sin Park
 *@LastVersion : 1.0
 * 2011-10-07 Myoung Sin Park
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpassageplanmanagement.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpassageplanmanagement.vo.PassagePlanDtVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration.ProformaScheduleMgtDBDAOCheckYardRSQL;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * CRM JMS Consuming에 따른 JMS Inbound Class<br> -
 * JMS 에서 받은 데이터 DB Logic 처리를 담당한다.<br>
 * 
 * @author Myoung Sin Park
 * @see 
 * @since J2EE 1.4
 */
public class VesselPassagePlanManagementDBDAO extends DBDAOSupport{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 입력된 MDM Yard Code가 MDM_YARD 테이블에 등록되여 있는지 확인한다.
	 * 
	 * @param String ydCd
	 * @return int
	 * @exception DAOException
	 */
	public int checkPassagePlan(PassagePlanDtVO passagePlanDtVO) throws DAOException {
		DBRowSet dbRowset = null;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{		
			if(passagePlanDtVO != null){
				Map<String, String> mapVO = passagePlanDtVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselPassagePlanManagementDBDAOCheckPassagePlanDtRSQL(), param, velParam);
			if(dbRowset != null){
				if(dbRowset.next()){
					cnt = Integer.parseInt(dbRowset.getString("CNT"));
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnt;
	}
	
	

	/**
	 * Create Passage Plan report.<br>
	 * 
	 * @param PassagePlanDtVO passagePlanDtVO
	 * @exception DAOException
	 */
	public void insertPassagePlan(PassagePlanDtVO passagePlanDtVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if(passagePlanDtVO != null){
				Map<String, String> mapVO = passagePlanDtVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new VesselPassagePlanManagementDBDAOCreatePassagePlanDtRSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * Update Passage Plan report.<br>
	 * 
	 * @param PassagePlanDtVO passagePlanDtVO
	 * @exception DAOException
	 */
	public void updatePassagePlan(PassagePlanDtVO passagePlanDtVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if(passagePlanDtVO != null){
				Map<String, String> mapVO = passagePlanDtVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new VesselPassagePlanManagementDBDAOUpdatePassagePlanDtRSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
}
