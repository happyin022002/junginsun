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
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ghana.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ghana.basic.GhanaManifestLIstDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ghana.vo.GhanaSearchManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ghana.vo.GhanaSearchVesselVO;
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
public class GhanaManifestListDownloadDBDAO extends DBDAOSupport {

	/**
	 * 	 가나 세관에 적하목록을 신고하기 위해 BKG Manifest 정보를 조회한다. 
	 * @param GhanaSearchManifestListVO ghanaSearchManifestListVO
	 * @return List<GhanaSearchManifestListVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<GhanaSearchManifestListVO> searchManifestList(GhanaSearchManifestListVO ghanaSearchManifestListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<GhanaSearchManifestListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (ghanaSearchManifestListVO != null) {
				Map<String, String> mapVO = ghanaSearchManifestListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new GhanaManifestListDownloadDBDAOsearchManifestListRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,	GhanaSearchManifestListVO.class);
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
	 * 가나 세관에 적하목록을 신고하기 위해 Vessel 정보를 조회한다. 
	 * @param GhanaSearchVesselVO ghanaSearchVesselVO
	 * @return List<GhanaSearchVesselVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<GhanaSearchVesselVO> searchVessel(GhanaSearchVesselVO ghanaSearchVesselVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<GhanaSearchVesselVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (ghanaSearchVesselVO != null) {
				Map<String, String> mapVO = ghanaSearchVesselVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new GhanaManifestListDownloadDBDAOsearchVesselRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,	GhanaSearchVesselVO.class);
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

