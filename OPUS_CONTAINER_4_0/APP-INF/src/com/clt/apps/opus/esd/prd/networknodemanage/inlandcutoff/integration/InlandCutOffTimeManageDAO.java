/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : InlandCutOffTimeManageDAO
 *@FileTitle : InlandCutOffTimeManageDAO
 *Open Issues :  Inland Cut Off Time Management
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 =========================================================*/
package com.clt.apps.opus.esd.prd.networknodemanage.inlandcutoff.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.PrdInlndCutOffTmMgmtVO;

/**
 * PRD에 대한 DB 처리를 담당<br>
 * PRD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author
 * @see
 * @since J2EE 1.4
 */
public class InlandCutOffTimeManageDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public List<AbstractValueObject> searchInlandCutOffTime(PrdInlndCutOffTmMgmtVO vo) throws DAOException {
		List<AbstractValueObject> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (vo != null) {
				param.putAll(vo.getColumnValues());
				list = new SQLExecuter("").executeQuery((ISQLTemplate) new InlandCutOffTimeManageDAOSearchInlandCutOffTimeRSQL(), param, param, PrdInlndCutOffTmMgmtVO.class);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public int dupcheck(PrdInlndCutOffTmMgmtVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		int count = 0;
		try {
			if (vo != null) {
				param.putAll(vo.getColumnValues());
				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InlandCutOffTimeManageDAODupcheckRSQL(), param, param);
				dbRowset.next();
				count = dbRowset.getInt(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return count;
	}

	/**
	 * 
	 * @param vos
	 * @param type
	 * @return
	 * @throws DAOException
	 */
	public int managePrdInlndCutOffTmMgmt(List<PrdInlndCutOffTmMgmtVO> vos, String type) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
//			int[] dbStatus = new int[vos.size()];
			if ("M".equals(type)) {
				new SQLExecuter("").executeBatch((ISQLTemplate) new InlandCutOffTimeManageDAOMergePrdInlndCutOffTmMgmtCSQL(), vos, param);
			} else {
				new SQLExecuter("").executeBatch((ISQLTemplate) new InlandCutOffTimeManageDAODeletePrdInlndCutOffTmMgmtDSQL(), vos, param);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return 0;
	}

	/**
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public int checkEffectDate(PrdInlndCutOffTmMgmtVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		int rsltVal = 0;
		try {
			if (vo != null) {
				param.putAll(vo.getColumnValues());
				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InlandCutOffTimeManageDAOCheckEffectDateRSQL(), param, param);
				if (dbRowset != null && dbRowset.next()) {
					rsltVal = dbRowset.getInt(1);
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsltVal;
	}
}
