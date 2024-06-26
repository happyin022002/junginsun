/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMDM_MOVE_STATUSDBDAO.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-02-26
 *@LastModifier : Kim Jung-Jae
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MdmMvmtStsVO;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 * JMS에서 받은 데이터 DB Logic 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see 
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmMvmtStsDBDAO extends DBDAOSupport{
	/**
	 * insert
	 * @param model
	 * @return
	 * @throws DAOException
	 */
	public void addMdmMvmtStsInsert(MdmMvmtStsVO model) throws DAOException {
		
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("mvmt_sts_cd"	, model.getMvmtStsCd());
			param.put("mvmt_sts_nm"	, model.getMvmtStsNm());
			param.put("dest_yd_flg"	, model.getDestYdFlg());
			param.put("dp_seq"		, model.getDpSeq());
			param.put("io_bnd_cd"	, model.getIoBndCd());
			param.put("cre_usr_id"	, model.getCreUsrId());
			param.put("cre_dt"		, model.getCreDt());
			param.put("upd_usr_id"	, model.getUpdUsrId());
			param.put("upd_dt"		, model.getUpdDt());
			param.put("delt_flg"	, model.getDeltFlg());
			param.put("eai_evnt_dt"	, model.getEaiEvntDt());
			param.put("eai_if_id"	, model.getEaiIfId());

			int insCnt = new SQLExecuter("DEFAULT").executeUpdate(new ReceiveQueueMdmMvmtStsDBDAOAddMdmMvmtStsInsertCSQL(), param, param);
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
	 * @param model
	 * @return
	 * @throws DAOException
	 */
	public void addMdmMvmtStsUpdate(MdmMvmtStsVO model) throws DAOException {
		
		Map<String, Object> param = new HashMap<String, Object>();

		try {

			param.put("mvmt_sts_nm"	, model.getMvmtStsNm());
			param.put("dest_yd_flg"	, model.getDestYdFlg());
			param.put("io_bnd_cd"	, model.getIoBndCd());
			param.put("cre_usr_id"	, model.getCreUsrId());
			param.put("cre_dt"		, model.getCreDt());
			param.put("upd_usr_id"	, model.getUpdUsrId());
			param.put("upd_dt"		, model.getUpdDt());
			param.put("delt_flg"	, model.getDeltFlg());
			param.put("eai_evnt_dt"	, model.getEaiEvntDt());
			param.put("mvmt_sts_cd"	, model.getMvmtStsCd());
			param.put("eai_if_id"	, model.getEaiIfId());

			int insCnt = new SQLExecuter("DEFAULT").executeUpdate(new ReceiveQueueMdmMvmtStsDBDAOAddMdmMvmtStsUpdateUSQL(), param, param);
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
	 * 기존 데이타 유무 확인
	 * @param pk
	 * @return
	 * @throws DAOException
	 */
	public boolean searchMdmMvmtStsList(String pk) throws DAOException{
		
		boolean isSuccessful = false; 
		DBRowSet dRs = null;
		
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("mvmt_sts_cd", pk);		
			
			dRs = new SQLExecuter("DEFAULT").executeQuery(new ReceiveQueueMdmMvmtStsDBDAOSearchMdmMvmtStsListRSQL(), param, param);
			
			if(dRs.getRowCount() > 0){
				isSuccessful = false;
			}else{
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
	 * @param models
	 * @return
	 * @throws DAOException
	 */
	public void removeMdmMvmtSts(MdmMvmtStsVO model) throws DAOException{
		
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			param.put("upd_usr_id"	, model.getUpdUsrId());
			param.put("upd_dt"		, model.getUpdDt());
			param.put("eai_evnt_dt"	, model.getEaiEvntDt());
			param.put("mvmt_sts_cd"	, model.getMvmtStsCd());
			param.put("eai_if_id"	, model.getEaiIfId());

			int updCnt = new SQLExecuter("DEFAULT").executeUpdate(new ReceiveQueueMdmMvmtStsDBDAORemoveMdmMvmtStsUSQL(), param, param);
			if(updCnt == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to update SQL");
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