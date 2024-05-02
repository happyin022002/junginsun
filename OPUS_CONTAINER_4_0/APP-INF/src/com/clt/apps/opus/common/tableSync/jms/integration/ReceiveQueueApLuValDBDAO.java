/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueAP_LU_VALDBDAO.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-02-26
 *@LastModifier : Kim Jung-Jae
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
 * 1.0 최초 생성
 =========================================================*/
package com.clt.apps.opus.common.tableSync.jms.integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.loggable.LoggableStateFactory;
import com.clt.framework.component.util.loggable.LoggableStatement;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.AP_LU_VAL;
import com.clt.syscommon.common.table.ApLuValVO;
import com.clt.syscommon.common.table.ArMstRevVvdVO;

/**
 * JMS에서 받은 데이터 DB Logic 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see
 * @since J2EE 1.4
 */
public class ReceiveQueueApLuValDBDAO extends DBDAOSupport{

	/**
	 * insert
	 * @param o
	 * @return
	 * @throws DAOException
	 */
	public void addApLuVal(Object o) throws DAOException {
		
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			ApLuValVO model = (ApLuValVO)o; 
			String bLuDeltFlg = "";
			
			if(model.getAvalFlg() != null && !"null".equals(model.getAvalFlg()) 
					&& model.getAvalFlg().equals("Y"))
				bLuDeltFlg = "N";
			else
				bLuDeltFlg = "Y";

			param.put("lu_tp_ind_cd"	, model.getLuTpIndCd());
			param.put("lu_cd"			, model.getLuCd());
			param.put("lu_delt_flg"		, bLuDeltFlg);
			param.put("lu_ctnt"			, model.getLuCtnt());
			param.put("lu_desc"			, model.getLuDesc());
			param.put("lu_st_act_dt"	, model.getLuStActDt());
			param.put("lu_end_act_dt"	, model.getLuEndActDt());
			param.put("cre_dt"			, model.getCreDt());
			param.put("cre_usr_id"		, model.getCreUsrId());
			param.put("upd_dt"			, model.getUpdDt());
			param.put("upd_usr_id"		, model.getUpdUsrId());
			param.put("eai_evnt_dt"		, model.getEaiEvntDt());
			param.put("aval_flg"		, model.getAvalFlg());	

			int insCnt = new SQLExecuter("DEFAULT").executeUpdate(new ReceiveQueueApLuValDBDAOAddApLuValCSQL(), param, param);
			if(insCnt == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}		
	}	
		
	/**
	 * update
	 * @param o
	 * @return
	 * @throws DAOException
	 */
	public void modifyApLuVal(Object o) throws DAOException {
		
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			ApLuValVO model = (ApLuValVO)o; 
			String bLuDeltFlg = "";
			
			if(model.getAvalFlg() != null && !"null".equals(model.getAvalFlg()) 
					&& model.getAvalFlg().equals("Y"))
				bLuDeltFlg = "N";
			else
				bLuDeltFlg = "Y";
			
			param.put("lu_delt_flg"		, bLuDeltFlg);
			param.put("lu_ctnt"			, model.getLuCtnt());
			param.put("lu_desc"			, model.getLuDesc());
			param.put("lu_st_act_dt"	, model.getLuStActDt());
			param.put("lu_end_act_dt"	, model.getLuEndActDt());
			param.put("cre_dt"			, model.getCreDt());
			param.put("cre_usr_id"		, model.getCreUsrId());
			param.put("upd_dt"			, model.getUpdDt());
			param.put("upd_usr_id"		, model.getUpdUsrId());
			param.put("aval_flg"		, model.getAvalFlg());	
			param.put("lu_tp_ind_cd"	, model.getLuTpIndCd());
			param.put("lu_cd"			, model.getLuCd());
			param.put("eai_evnt_dt"		, model.getEaiEvntDt());
			
			int updCnt = new SQLExecuter("DEFAULT").executeUpdate(new ReceiveQueueApLuValDBDAOModifyApLuValUSQL(), param, param);
			if(updCnt == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}		
	}	
	
	/**
	 * 기존 데이타 유무 확인
	 * @param pk
	 * @param pk1
	 * @return
	 * @throws DAOException
	 */
	public boolean searchApLuValList(String pk1, String pk2) throws DAOException{
		
		boolean isSuccessful = false; 
		DBRowSet dRs = null;
		
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			
			param.put("lu_tp_ind_cd", pk1);
			param.put("lu_cd"		, pk2);
			
			dRs = new SQLExecuter("DEFAULT").executeQuery(new ReceiveQueueApLuValDBDAOSearchApLuValListRSQL(), param, param);
			
			if(dRs.getRowCount() <= 0){
				isSuccessful = true;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
			
		return isSuccessful;	
	}		

	/**
	 * delete
	 * @param o
	 * @return
	 * @throws DAOException
	 */
	public void removeApLuVal(Object o) throws DAOException{
		
		log.info("\n\n ReceiveQueueApLuValDBDAO.removeApLuVal");
		
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			ApLuValVO model = (ApLuValVO)o; 
			
			param.put("lu_tp_ind_cd", model.getLuTpIndCd());
			param.put("lu_cd"		, model.getLuCd());
			param.put("eai_evnt_dt"	, model.getEaiEvntDt());
			
			int delCnt = new SQLExecuter("DEFAULT").executeUpdate(new ReceiveQueueApLuValDBDAORemoveApLuValUSQL(), param, param);
			if(delCnt == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to delete SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
	}	
}