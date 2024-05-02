/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : CodepublishDBDAO.java
 *@FileTitle : 공통코드관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-09-07
 *@LastModifier : SeongWook Kim
 *@LastVersion : 1.0
 * 2006-09-07 SeongWook Kim
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.edm.codepublish.integration;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.edm.codepublish.basic.CodepublishBCImpl;
import com.hanjin.edm.codepublish.event.ComEdm001Event;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.COM_CODEDOMAIN;

/**
 * edm-edm에 대한 DB 처리를 담당<br>
 * - edm-edm Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SeongWook Kim
 * @see CodepublishBCImpl 참조
 * @since J2EE 1.4
 */
public class CodepublishDBDAO extends DBDAOSupport {

	/**
	 * Codepublish의 모든 목록을 가져온다.<br>
	 * 
	 * @param e
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchEDMCodeList(Event e) throws DAOException {
		DBRowSet dbRowset = null;
		ComEdm001Event event = (ComEdm001Event) e;
		// form 조회조건
		String subsystem = event.getVar1().toUpperCase(); // 서스시스템
		String searchtype = event.getSearchtype();
		String codeid = event.getId().toUpperCase(); // 코드아이디
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("subsystem", subsystem);
		param.put("codeid", codeid);
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("subsystem", subsystem);
		velParam.put("searchtype", searchtype);
		velParam.put("codeid", codeid);
		try {
			dbRowset = new SQLExecuter("hanjinEDMDs").executeQuery((ISQLTemplate)new CodepublishDAOEdmCodeRSQL(), param, velParam);
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
	 * Codepublish의 모든 목록을 가져온다.<br>
	 * 
	 * @param e
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchEDMCodeDetailList(Event e) throws DAOException {
		DBRowSet dbRowset = null;
		ComEdm001Event event = (ComEdm001Event) e;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("codeid", event.getCodeid());
		try {
			dbRowset = new SQLExecuter("hanjinEDMDs").executeQuery((ISQLTemplate)new CodepublishDAOEdmCodeDetailRSQL(), param, null);
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
	 * Codepublish의 모든 목록을 가져온다.<br>
	 * 
	 * @param e
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchAPPCodeList(Event e) throws DAOException {
		DBRowSet dbRowset = null;
		ComEdm001Event event = (ComEdm001Event) e;
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<String> codes = Arrays.asList(event.getSelectedcodes().split("\\|"));
		velParam.put("codes", codes);
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodepublishDAOComIntgCdRSQL(), null, velParam);
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
	 * Codepublish의 모든 목록을 가져온다.<br>
	 * 
	 * @param e
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchAPPCodeDetailList(Event e) throws DAOException {
		DBRowSet dbRowset = null;
		ComEdm001Event event = (ComEdm001Event) e;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("intg_cd_id", event.getCodeid());
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodepublishDAOComIntgCdDtlRSQL(), param, null);
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
	 * edm codedomain 목록을 가져온다.<br>
	 * 
	 * @param e
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchEDMCodeListByCode(Event e) throws DAOException {

		DBRowSet dbRowset = null;
		ComEdm001Event event = (ComEdm001Event) e;
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<String> codes = Arrays.asList(event.getSelectedcodes().split("\\|"));
		velParam.put("codes", codes);
		try {
			dbRowset = new SQLExecuter("hanjinEDMDs").executeQuery((ISQLTemplate)new CodepublishDAOEdmCodeByCodeRSQL(), null, velParam);
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
	 * edm codevalue 목록을 가져온다.<br>
	 * 
	 * @param e
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchEDMCodeDetailListByCode(Event e) throws DAOException {
		DBRowSet dbRowset = null;
		ComEdm001Event event = (ComEdm001Event) e;
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<String> codes = Arrays.asList(event.getSelectedcodes().split("\\|"));
		velParam.put("codes", codes);
		try {
			dbRowset = new SQLExecuter("hanjinEDMDs").executeQuery((ISQLTemplate)new CodepublishDAOEdmCodeDetailByCodeRSQL(), null, velParam);
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
	 * 
	 * 코드 테이블을 삭제한다.<br>
	 * @param model
	 * @throws DAOException
	 */
	public void deleteAPPCode(COM_CODEDOMAIN model) throws DAOException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("intg_cd_id", model.getGroupid());
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate) new CodepublishDAOComIntgCdDtlDSQL(), params, null);
			sqlExe.executeUpdate((ISQLTemplate) new CodepublishDAOComIntgCdDSQL(), params, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 
	 * 코드 데이터를 생성한다.<br>
	 * 
	 * @param insModels
	 * @param account
	 * @throws DAOException void
	 */
	public void addAPPCodeList(DBRowSet insModels, SignOnUserAccount account) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			while (insModels.next()) {
				param.put("intg_cd_id", insModels.getString("codeid"));
				param.put("intg_cd_nm", insModels.getString("name"));
				param.put("intg_cd_desc", insModels.getString("definition"));
				param.put("intg_cd_tp_nm", insModels.getString("var2"));
				param.put("intg_cd_dat_tp_nm", insModels.getString("datatype"));
				param.put("intg_cd_len", insModels.getString("precision"));
				param.put("ownr_sub_sys_cd", insModels.getString("var1"));
				param.put("mng_tbl_nm", insModels.getString("var3"));
				param.put("intg_cd_use_flg", insModels.getString("var5"));
				param.put("cre_usr_id", account.getUsr_id());
				param.put("upd_usr_id", account.getUsr_id());
				sqlExe.executeUpdate((ISQLTemplate) new CodepublishDAOComIntgCdCSQL(), param, velParam);
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
	 * 
	 * 코드 디테일 데이터를 생성한다.<br>
	 * 
	 * @param insModels
	 * @param account
	 * @throws DAOException void
	 */
	public void addAPPCodeDetailList(DBRowSet insModels, SignOnUserAccount account) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			while (insModels.next()) {
				param.put("intg_cd_id", insModels.getString("codeid"));
				param.put("intg_cd_val_ctnt", insModels.getString("key"));
				param.put("intg_cd_val_dp_desc", insModels.getString("value"));
				param.put("intg_cd_val_desc", insModels.getString("description"));
				param.put("intg_cd_val_dp_seq", insModels.getString("codeorder"));
				param.put("aply_st_dt", insModels.getString("begindate"));
				param.put("aply_end_dt", insModels.getString("enddate"));
				param.put("cre_usr_id", account.getUsr_id());
				param.put("upd_usr_id", account.getUsr_id());
				sqlExe.executeUpdate((ISQLTemplate) new CodepublishDAOComIntgCdDtlCSQL(), param, velParam);
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