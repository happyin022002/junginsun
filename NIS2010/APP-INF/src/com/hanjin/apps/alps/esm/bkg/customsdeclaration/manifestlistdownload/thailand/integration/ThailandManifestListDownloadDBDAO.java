/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : GhanaManifestListDownloadDBDAO.java
 *@FileTitle : Ghana Customs Manifest
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.04.12
 *@LastModifier : 김보배
 *@LastVersion : 1.0
 * 2012.04.12 김보배
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.thailand.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.thailand.vo.ThailandManifestListBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.thailand.vo.ThailandManifestListCntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.thailand.vo.ThailandManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.thailand.vo.ThailandVvdInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.thailand.vo.ThailandVvdInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdInfoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * NIS2010 GhanaManifestListDownloadDBDAO <br>
 * - NIS2010-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author BOBAE KIM
 * @see GhanaManifestLIstDownloadBCImpl 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("serial")
public class ThailandManifestListDownloadDBDAO extends DBDAOSupport {

	/**
	 * 	태국세관 BKG Manifest - vvd 정보 조회
	 * @param thailandVvdInfoCondVO
	 * @return
	 * @throws DAOException 
	 */

	@SuppressWarnings("unchecked")
	public List<CstmsVvdInfoVO> searchCstmsVvdInfo(ThailandVvdInfoCondVO thailandVvdInfoCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CstmsVvdInfoVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (thailandVvdInfoCondVO != null) {
				Map<String, String> mapVO = thailandVvdInfoCondVO
						.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new ThailandManifestListDownloadDBDAOsearchVvdListRSQL(),
							param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					ThailandVvdInfoVO.class);
		} catch (SQLException se) {
			
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 태국세관 BKG Manifest - b/l info 정보 조회
	 * @param thailandManifestListCondVO
	 * @return
	 * @throws DAOException 
	 */
	@SuppressWarnings("unchecked")
	public List<ThailandManifestListBlInfoVO> searchCustomsBlInfo(ThailandManifestListCondVO thailandManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ThailandManifestListBlInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (thailandManifestListCondVO != null) {
				Map<String, String> mapVO = thailandManifestListCondVO
						.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new ThailandManifestListDownloadDBDAOsearchCustomsBlInfoRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,ThailandManifestListBlInfoVO.class);
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
	 * 	태국세관 BKG Manifest - container 정보 조회
	 * @param thailandManifestListCondVO
	 * @return
	 * @throws DAOException 
	 */
	@SuppressWarnings("unchecked")
	public List<ThailandManifestListCntrInfoVO> searchCustomsCNTRInfo(ThailandManifestListCondVO thailandManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ThailandManifestListCntrInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (thailandManifestListCondVO != null) {
				Map<String, String> mapVO = thailandManifestListCondVO
						.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new ThailandManifestListDownloadDBDAOsearchCustomsCNTRInfoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ThailandManifestListCntrInfoVO.class);
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

