/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : USA404TrsStccDBDAO.java
 *@FileTitle : USA404TrsStccDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.sce.common.manualinput.basic.ManualInputBCImpl;
import com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.event.EsdTrs0802Event;
import com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.vo.TrsStccVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * OPUS ManualInputDBDAO <br>
 * - OPUS-ManualInputDBDAO system Business Logic Handling.<br>
 * 
 * @author YoungHeon Lee
 * @see ManualInputBCImpl reference
 * @since J2EE 1.6
 */
public class USA404TrsStccDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * searchTrsStcc
	 * 
	 * @param event
	 * @return List<TrsStccVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<TrsStccVO> searchTrsStcc(EsdTrs0802Event event) throws DAOException {
		DBRowSet dbRowset = null;
		List<TrsStccVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (event != null) {
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("frm_stcc_cd", event.getFrmStccCd());
				mapVO.put("frm_stcc_seq", event.getFrmStccSeq());
				mapVO.put("frm_un_cmdt_cd", event.getFrmUnCmdtCd());
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new USA404TrsStccDBDAOSearchTrsStccRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TrsStccVO.class);
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
	 * addTrsStcc
	 * 
	 * @param insertVoList
	 * @throws DAOException
	 */
	public void addTrsStcc(List<TrsStccVO> insertVoList) throws DAOException {
		int creCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (insertVoList.size() > 0) {
				creCnt = sqlExe.executeBatch((ISQLTemplate) new USA404TrsStccDBDAOAddTrsStccCSQL(), insertVoList, null);
				for (int i = 0; i < creCnt.length; i++) {
					if (creCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No" + i + " SQL");
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
	 * modifyTrsStcc
	 * 
	 * @param updateVoList
	 * @throws DAOException
	 */
	public void modifyTrsStcc(List<TrsStccVO> updateVoList) throws DAOException {
		int creCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (updateVoList.size() > 0) {
				creCnt = sqlExe.executeBatch((ISQLTemplate) new USA404TrsStccDBDAOModifyTrsStccUSQL(), updateVoList, null);
				for (int i = 0; i < creCnt.length; i++) {
					if (creCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to modify No" + i + " SQL");
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
	 * removeTrsStcc
	 * 
	 * @param deleteVoList
	 * @throws DAOException
	 */
	public void removeTrsStcc(List<TrsStccVO> deleteVoList) throws DAOException {
		int creCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (deleteVoList.size() > 0) {
				creCnt = sqlExe.executeBatch((ISQLTemplate) new USA404TrsStccDBDAORemoveTrsStccDSQL(), deleteVoList, null);
				for (int i = 0; i < creCnt.length; i++) {
					if (creCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to remove No" + i + " SQL");
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
}