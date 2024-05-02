/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : WorkOrderRemarkDBDAO.java
 *@FileTitle : Office별로 Cost/Trans Mode 및 IN/OUT Bound 별 W/O에 공통 적용할 비고 사항을 관리하는 화면
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-11-08
 *@LastModifier : poong_yeon
 *@LastVersion : 1.0
 * 2006-11-08 poong_yeon
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderremark.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esd.trs.workordermanage.workorderremark.event.EsdTrs0078Event;
import com.clt.apps.opus.esd.trs.workordermanage.workorderremark.vo.WorkOrderRemarkVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * ESD-WorkOrderManage에 대한 DB 처리를 담당<br>
 * - ESD-WorkOrderManage Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author poong_yeon
 * @see WorkOrderRemarkBCImpl 참조
 * @since J2EE 1.4
 */
public class WorkOrderRemarkDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = -3494103290008251824L;

	/**
	 * WorkOrderRemark의 데이타 모델을 DB에서 삭제한다.<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void removeWorkOrderRemark(EsdTrs0078Event event) throws DAOException {
		Collection<WorkOrderRemarkVO> delModels = new ArrayList<WorkOrderRemarkVO>();
		WorkOrderRemarkVO[] multiVos = event.getWorkOrderRemarkVOs();
		try {
			if (multiVos != null) {
				for (int i = 0; i < multiVos.length; i++) {
					if (multiVos[i].getIbflag().equals("D")) {
						delModels.add(multiVos[i]);
					}
				}
			}
			int[] delCnt = null;
			if (delModels.size() > 0) {
				delCnt = new SQLExecuter("DEFAULT").executeBatch(new WorkOrderRemarkDBDAOMultiWorkOrderRemarkDSQL(), delModels, null, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to DELETE No" + i + " SQL");
					}
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
	 * WorkOrderRemark의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void multiWorkOrderRemark(EsdTrs0078Event event) throws DAOException {
		Collection<WorkOrderRemarkVO> insModels = new ArrayList<WorkOrderRemarkVO>();
		Collection<WorkOrderRemarkVO> updModels = new ArrayList<WorkOrderRemarkVO>();
		Collection<WorkOrderRemarkVO> delModels = new ArrayList<WorkOrderRemarkVO>();

		WorkOrderRemarkVO[] multiVos = event.getWorkOrderRemarkVOs();
		try {
			if (multiVos != null) {
				for (int i = 0; i < multiVos.length; i++) {
					if (multiVos[i].getIbflag().equals("I")) {
						insModels.add(multiVos[i]);
					}
					if (multiVos[i].getIbflag().equals("U")) {
						updModels.add(multiVos[i]);
					}
					if (multiVos[i].getIbflag().equals("D")) {
						delModels.add(multiVos[i]);
					}
				}
			}
			int[] insCnt = null;
			if (insModels.size() > 0) {
				insCnt = new SQLExecuter("DEFAULT").executeBatch(new WorkOrderRemarkDBDAOMultiWorkOrderRemarkCSQL(), insModels, null, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to INSERT No" + i + " SQL");
					}
				}
			}
			int[] updCnt = null;
			if (updModels.size() > 0) {
				updCnt = new SQLExecuter("DEFAULT").executeBatch(new WorkOrderRemarkDBDAOMultiWorkOrderRemarkUSQL(), updModels, null, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to UPDATE No" + i + " SQL");
					}
				}
			}

			int[] delCnt = null;
			if (delModels.size() > 0) {
				delCnt = new SQLExecuter("DEFAULT").executeBatch(new WorkOrderRemarkDBDAOMultiWorkOrderRemarkDSQL(), delModels, null, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to DELETE No" + i + " SQL");
					}
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
	 * WorkOrderRemark의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchWorkOrderRemarkList(EsdTrs0078Event event) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			WorkOrderRemarkVO workOrderRemarkVO = event.getWorkOrderRemarkVO();
			if (workOrderRemarkVO != null) {
				param.putAll(workOrderRemarkVO.getColumnValues());
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new WorkOrderRemarkDBDAOSearchWorkOrderRemarkListRSQL(), param, param);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;
	}
}