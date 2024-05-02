/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ArgManifestListDownloadDBDAO.java
 *@FileTitle : ArgManifestListDownloadDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.12.29
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.04.29 김민정
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.argentina.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.argentina.basic.ArgManifestListDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.argentina.vo.ArgManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.argentina.vo.ArgManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.argentina.vo.BkgCstmsArgBlVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS ArgManifestListDownloadDBDAO <br>
 * - OPUS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Min Jeong
 * @see ArgManifestListDownloadBCImpl 참조
 * @since J2EE 1.4
 */
public class ArgManifestListDownloadDBDAO extends DBDAOSupport {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Manifest Download List 조회
	 * 
	 * @param ArgManifestListCondVO arsManifestListCondVO
	 * @param SignOnUserAccount account
	 * @return
	 * @throws DAOException
	 */
	public List<ArgManifestListDetailVO> searchManifestList(ArgManifestListCondVO arsManifestListCondVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<ArgManifestListDetailVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		arsManifestListCondVO.setUpdUsrId(account.getUpd_usr_id());
		try {
			param.putAll(arsManifestListCondVO.getColumnValues());
			velParam.putAll(arsManifestListCondVO.getColumnValues());
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ArgManifestListDownloadDBDAOsearchManifestListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ArgManifestListDetailVO.class);
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * BKG_CSTMS_ARS_BL
	 * 
	 * @param bkgCstmsArgBlVOs
	 * @throws DAOException
	 */
	public void addBkgCstmsArgBl(List<BkgCstmsArgBlVO> bkgCstmsArgBlVOs) throws DAOException {
		try {
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgCstmsArgBlVOs != null && bkgCstmsArgBlVOs.size() > 0) {
				Map<String, String> mapVO = bkgCstmsArgBlVOs.get(0).getColumnValues();
				velParam.putAll(mapVO);
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ArgManifestListDownloadDBDAOaddBkgCstmsArgBlCSQL(), bkgCstmsArgBlVOs, velParam);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * BKG_CSTMS_ARS_BL
	 * 
	 * @param bkgCstmsArgBlVOs
	 * @throws DAOException
	 */
	public void updateInTransitArgBl(List<BkgCstmsArgBlVO> bkgCstmsArgBlVOs) throws DAOException {
		try {
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgCstmsArgBlVOs != null && bkgCstmsArgBlVOs.size() > 0) {
				Map<String, String> mapVO = bkgCstmsArgBlVOs.get(0).getColumnValues();
				velParam.putAll(mapVO);
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ArgManifestListDownloadDBDAOupdateInTransitArgBlCSQL(), bkgCstmsArgBlVOs, velParam);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Manifest List 삭제
	 * 
	 * @param List<BkgCstmsArgBlVO> bkgCstmsArgBlVOs
	 * @throws DAOException
	 */
	public void removeManifestBlByVvd(List<BkgCstmsArgBlVO> bkgCstmsArgBlVOs) throws DAOException {
		try {
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgCstmsArgBlVOs != null && bkgCstmsArgBlVOs.size() > 0) {
				Map<String, String> mapVO = bkgCstmsArgBlVOs.get(0).getColumnValues();
				velParam.putAll(mapVO);
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ArgManifestListDownloadDBDAOremoveBkgCstmsArgBlCSQL(), bkgCstmsArgBlVOs, velParam);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		}catch(SQLException se){
	            log.error(se.getMessage(),se);
	            throw new DAOException(new ErrorHandler(se).getMessage(), se);
	        }catch(Exception ex){
	            log.error(ex.getMessage(),ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        }
	}
}