/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CommonPopUpManageDBDAO.java
 *@FileTitle : EsdSce0103
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.28
 *@LastModifier : 신한성
 *@LastVersion : 1.0
 * 2009.07.28 신한성
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.common.popup.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.sce.common.popup.vo.COPSummaryVO;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.ComOfficeManagementVO;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.ComVvdManagementConditionVO;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.ComVvdManagementVO;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.SCNOManagementVO;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.SearchContiInfoVO;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.SearchContiManageVO;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.SearchSceClmDataVO;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.SearchSceClmInfoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS CommonPopUpManageDBDAO <br>
 * - ALPS-common system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Shin Han Sung
 * @see popupBCImpl 참조
 * @since J2EE 1.6
 */
public class CommonPopUpManageDBDAO extends DBDAOSupport {

	/**
	 * VVD 조회
	 * 
	 * @param ComVvdManagementConditionVO comVvdManagementConditionVO
	 * @return List<ComVvdManagementVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ComVvdManagementVO> searchVVDManage(
			ComVvdManagementConditionVO comVvdManagementConditionVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<ComVvdManagementVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (comVvdManagementConditionVO != null) {
				Map<String, String> mapVO = comVvdManagementConditionVO
						.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				// VVD = vsl_cd/skd_voy_no/skd_dir_cd 처리
				if (velParam.get("selvvd") != null
						&& !((String) velParam.get("selvvd")).trim().equals("")) {

					String vvd = ((String) velParam.get("selvvd")).trim();
					String vslCd = vvd.substring(0, 4);
					String skdVoyNo = vvd.substring(4, 8);
					String skdDirCd = vvd.substring(8);

					param.put("selvslcd", vslCd);
					param.put("skdvoyno", skdVoyNo);
					param.put("skddircd", skdDirCd.toUpperCase());
				}

			}
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new CommonPopUpManageDBDAOSearchVVDManageRSQL(),
							param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					ComVvdManagementVO.class);
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
	 * Service Office Code 조회
	 * 
	 * @param ComOfficeManagementVO comOfficeManagementVO
	 * @return List<ComOfficeManagementVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ComOfficeManagementVO> searchServiceOfficeCodeManage(
			ComOfficeManagementVO comOfficeManagementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComOfficeManagementVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (comOfficeManagementVO != null) {
				Map<String, String> mapVO = comOfficeManagementVO
						.getColumnValues();

				param.putAll(mapVO);
				// velParam.putAll(mapVO);

			}
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new CommonPopUpManageDBDAOSearchServiceOfficeCodeManageRSQL(),
							param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					ComOfficeManagementVO.class);
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
	 * COP summary 조회
	 * 
	 * @param COPSummaryVO copSummaryVO
	 * @return List<COPSummaryVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<COPSummaryVO> searchCOPSmryManage(COPSummaryVO copSummaryVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<COPSummaryVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (copSummaryVO != null) {
				Map<String, String> mapVO = copSummaryVO.getColumnValues();

				param.putAll(mapVO);
				// velParam.putAll(mapVO);

			}
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new CommonPopUpManageDBDAOSearchCOPSmryManageRSQL(),
							param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, COPSummaryVO.class);
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
	 * SC Count 조회
	 * 
	 * @param SCNOManagementVO sCNOManagementVO
	 * @return int
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public int searchSCNOManageCount(SCNOManagementVO sCNOManagementVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (sCNOManagementVO != null) {
				Map<String, String> mapVO = sCNOManagementVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				param.put("cust_cnt_seq", ((String) param.get("cust_cnt_seq"))
						.toUpperCase());

			}
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new CommonPopUpManageDBDAOSearchSCNOManageCountRSQL(),
							param, velParam);
			if (dbRowset.getRowCount() > 0) {
				dbRowset.next();
				return dbRowset.getInt(1);
			} else {
				return 0;
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
	 * SC 조회
	 * 
	 * @param SCNOManagementVO sCNOManagementVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchSCNOManage(SCNOManagementVO sCNOManagementVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (sCNOManagementVO != null) {
				Map<String, String> mapVO = sCNOManagementVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				param.put("cust_cnt_seq", ((String) param.get("cust_cnt_seq"))
						.toUpperCase());

			}
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new CommonPopUpManageDBDAOSearchSCNOManageRSQL(),
							param, velParam);
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
	 * EMAIL 내용 조회
	 * 
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchEMAILTemplateContent(SignOnUserAccount account)
			throws DAOException {

		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {

			param.put("usr_id", account.getUsr_id());	// user id
			param.put("ofc_cd", account.getOfc_cd());	// office code

			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new CommonPopUpManageDBDAOGetEMAILTemplateContentRSQL(),
							param, null);
			
			if (dbRowset.getRowCount() > 0) {
				dbRowset.next();
				return dbRowset.getString(1);
			} else {
				return "";
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
	 * EMAIL 수신인 조회
	 * 
	 * @param String param
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchEMAILRecipients(String param)
			throws DAOException {

		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			// BKG_NO&BKG_NO_SPLIT MULTI 처리
			if (param != null
					&& !param.trim().equals("")) {
				velParam.put("bkg_no", param.toUpperCase()
						.split(","));
			}
			
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new CommonPopUpManageDBDAOSearchEMAILRecipientsRSQL(),
							null, velParam);
			
				return dbRowset;
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * SCE CLM LIST 조회
	 * 
	 * @param SearchSceClmInfoVO clmInfo
	 * @return List<SearchSceClmDataVO>
	 * @throws DAOException
	 */
	public List<SearchSceClmDataVO> searchSceClmList(SearchSceClmInfoVO clmInfo) throws DAOException {
    	
    	log.debug("searchSceClmList-을 실행합니다.");
    	DBRowSet dbRowset = null;
		List<SearchSceClmDataVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
        	if (clmInfo != null) {
				Map<String, String> mapVO = clmInfo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			    log.debug("PARAM:"+ param);
			    log.debug("velParam:"+ velParam);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CommonPopUpManaeDBDAOSearchSceClmDataRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SearchSceClmDataVO.class);
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
	 * COUNTRY 조회
	 *
	 * @param SearchContiInfoVO contiInfo
	 * @return List<SearchContiManageVO>
	 * @throws DAOException
	 */
	public List<SearchContiManageVO> searchContiManage(SearchContiInfoVO contiInfo) throws DAOException {
		
		log.debug("searchContiManage-을 실행합니다.");
    	DBRowSet dbRowset = null;
		List<SearchContiManageVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
        	if (contiInfo != null) {
				Map<String, String> mapVO = contiInfo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			    log.debug("PARAM:"+ param);
			    log.debug("velParam:"+ velParam);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CommonPopUpManageDBDAOSearchContiManageRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SearchContiManageVO.class);
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
}