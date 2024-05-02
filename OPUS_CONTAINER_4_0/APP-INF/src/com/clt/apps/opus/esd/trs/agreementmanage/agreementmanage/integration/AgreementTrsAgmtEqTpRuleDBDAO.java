 /*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AgreementTrsAgmtEqTpRuleDBDAO.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014-10-21
*@LastModifier : 
*@LastVersion : 1.0
* 2014-10-21
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.sce.common.manualinput.basic.ManualInputBCImpl;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0801Event;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.vo.TrsAgmtEqTpRuleVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.ComIntgCdDtlVO;


/**
 * OPUS ManualInputDBDAO <br>
 * - OPUS-ManualInputDBDAO system Business Logic Handling.<br>
 * 
 * @author YoungHeon Lee
 * @see ManualInputBCImpl reference
 * @since J2EE 1.6
 */
public class AgreementTrsAgmtEqTpRuleDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * EpTp Rule을 조회한다.
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<TrsAgmtEqTpRuleVO> searchTrsAgmtEqTpRule(EsdTrs0801Event event) throws DAOException {
		DBRowSet dbRowset = null;
		List<TrsAgmtEqTpRuleVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(event != null){
//				Map<String, String> mapVO = trsAgmtEqTpRuleVO.getColumnValues();
				
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("frm_trsp_agmt_rule_tp_cd", event.getFrmTrspAgmtRuleTpCd());
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AgreementTrsAgmtEqTpRuleDBDAOSearchTrsAgmtEqTpRuleRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TrsAgmtEqTpRuleVO .class);
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
	 * COM_INTG_CD_DTL을 조회한다.
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @throws DAOException
	 */
	public List<ComIntgCdDtlVO> searchComIntgCdDtl(String key, String value) throws DAOException {
		EsdTrs0801Event event = new EsdTrs0801Event();
		event.setFrmIntgCdId(key);
		event.setFrmIntgCdValCtnt(value);
		
		return searchComIntgCdDtl(event);
	}
	
	/**
	 * COM_INTG_CD_DTL을 조회한다.
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<ComIntgCdDtlVO> searchComIntgCdDtl(EsdTrs0801Event event) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComIntgCdDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(event != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("frm_intg_cd_id", event.getFrmIntgCdId());
				mapVO.put("frm_intg_cd_val_ctnt", event.getFrmIntgCdValCtnt());
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AgreementTrsAgmtEqTpRuleDBDAOSearchComIntgCdDtlRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComIntgCdDtlVO .class);
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
	 * EqTp Rule을 추가한다.
	 * 
	 * @param insertVoList
	 * @throws DAOException
	 */
	public void addTrsAgmtEqTpRule(List<TrsAgmtEqTpRuleVO> insertVoList) throws DAOException {
		int creCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (insertVoList.size() > 0) {
				creCnt = sqlExe.executeBatch((ISQLTemplate) new AgreementTrsAgmtEqTpRuleDBDAOAddTrsAgmtEqTpRuleCSQL(), insertVoList, null);
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
	 * EqTp Rule을 수정한다.
	 * 
	 * @param updateVoList
	 * @throws DAOException
	 */
	public void modifyTrsAgmtEqTpRule(List<TrsAgmtEqTpRuleVO> updateVoList) throws DAOException {
		int creCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (updateVoList.size() > 0) {
				creCnt = sqlExe.executeBatch((ISQLTemplate) new AgreementTrsAgmtEqTpRuleDBDAOModifyTrsAgmtEqTpRuleUSQL(),updateVoList, null);
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
	 * EqTp Rule을 제거한다.
	 * 
	 * @param deleteVoList
	 * @throws DAOException
	 */
	public void removeTrsAgmtEqTpRule(List<TrsAgmtEqTpRuleVO> deleteVoList) throws DAOException {
		int creCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (deleteVoList.size() > 0) {
				creCnt = sqlExe.executeBatch((ISQLTemplate) new AgreementTrsAgmtEqTpRuleDBDAORemoveTrsAgmtEqTpRuleDSQL(), deleteVoList, null);
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