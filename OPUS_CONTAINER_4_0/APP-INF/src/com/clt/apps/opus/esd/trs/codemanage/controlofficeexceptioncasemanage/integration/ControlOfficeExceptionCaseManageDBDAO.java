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
package com.clt.apps.opus.esd.trs.codemanage.controlofficeexceptioncasemanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esd.trs.codemanage.controlofficeexceptioncasemanage.basic.ControlOfficeExceptionCaseManageBCImpl;
import com.clt.apps.opus.esd.trs.codemanage.controlofficeexceptioncasemanage.event.EsdTrs0079Event;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.TrsTrspOfcExptRuleVO;

/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author poong
 * @see ControlOfficeExceptionCaseManageBCImpl 참조
 * @since J2EE 1.4
 */
public class ControlOfficeExceptionCaseManageDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = -5718071937891534967L;

	/**
	 * ControlOfficeExceptionCaseManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchControlOfficeExceptionCaseManageList(EsdTrs0079Event event) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		HashMap<String, String> p = event.getControlOfficeExceptionSearchConditionVO().getColumnValues();
		param.putAll(p);
		try {
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(new ControlOfficeExceptionCaseManageDBDAOSearchListRSQL(), param, param);
		} catch (SQLException ex) {
			throw new DAOException(ex.getMessage(), ex);
		} catch (Exception ex) {
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
			Map<String, Object> param = new HashMap<String, Object>();

			Collection<TrsTrspOfcExptRuleVO> insertVoList = new ArrayList<TrsTrspOfcExptRuleVO>();
			Collection<TrsTrspOfcExptRuleVO> updateVoList = new ArrayList<TrsTrspOfcExptRuleVO>();
			Collection<TrsTrspOfcExptRuleVO> insertHisVoList = new ArrayList<TrsTrspOfcExptRuleVO>();

			String ofcCd = event.getFORM_USR_OFC_CD();
			String usrId = event.getFORM_CRE_USR_ID();

			for (int i = 0; i < model.length; i++) {
				if (model[i].getIbflag().equals("I")) {
					insertVoList.add(model[i]);
				} else if (model[i].getIbflag().equals("U")) {
					updateVoList.add(model[i]);
				}
				insertHisVoList.add(model[i]);
			}

			// 1. Office Exception Delete
			if (updateVoList.size() > 0) {
				param.put("OFC_CD", ofcCd);
				param.put("USR_ID", usrId);
				insCnt = sqlExe.executeBatch(new ControlOfficeExceptionCaseManageDBDAOMultiTrsTrspOfcExptRuleDSQL(), updateVoList, param, param);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
			// 2. Office Exception Insert
			if (insertVoList.size() > 0) {
				param.put("vos", insertVoList);
				DBRowSet ds = sqlExe.executeQuery(new ControlOfficeExceptionCaseManageDBDAOMultiTrsTrspOfcExptRuleRSQL(), param, param);
				if (ds.next()) {
					if (ds.getInt("cnt") > 0) {
						throw new EventException(new ErrorHandler("TRS00007").getMessage());
					}
				}
				param.clear();
				param.put("OFC_CD", ofcCd);
				param.put("USR_ID", usrId);
				insCnt = sqlExe.executeBatch(new ControlOfficeExceptionCaseManageDBDAOMultiTrsTrspOfcExptRuleCSQL(), insertVoList, param, param);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}

			// 3. Office Exception History Insert
			if (insertHisVoList.size() > 0) {
				param.clear();
				param.put("OFC_CD", ofcCd);
				param.put("USR_ID", usrId);
				insCnt = sqlExe.executeBatch(new ControlOfficeExceptionCaseManageDBDAOMultiTrsTrspOfcExptRuleHisCSQL(), insertHisVoList, param, param);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
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
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = event.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(new ControlOfficeExceptionCaseManageDBDAOSearchYardCodeRSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
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
	public DBRowSet searchYardCodeName(EsdTrs0079Event event) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(event.getColumnValues());
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(new ControlOfficeExceptionCaseManageDBDAOSearchYardCodeNameRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
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
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = event.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(new ControlOfficeExceptionCaseManageDBDAOSearchCountryCodeRSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
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
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = event.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(new ControlOfficeExceptionCaseManageDBDAOSearchControlOfficeCodeRSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
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
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(new ControlOfficeExceptionCaseManageDBDAOSearchEquipmentTPRSQL(), param, velParam);
		} catch (SQLException ex) {
			throw new DAOException(ex.getMessage(), ex);
		} catch (Exception ex) {
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
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(new ControlOfficeExceptionCaseManageDBDAOSearchEquipmentSZRSQL(), param, velParam);
		} catch (SQLException ex) {
			throw new DAOException(ex.getMessage(), ex);
		} catch (Exception ex) {
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
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = event.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(new ControlOfficeExceptionCaseManageDBDAOVerifyControlOfficeCDRSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
}