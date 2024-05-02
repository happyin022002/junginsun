/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : HongKongManifestListDownloadDBDAO.java
 *@FileTitle : UI_BKG-0282
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.10
 *@LastModifier : 임재택
 *@LastVersion : 1.0
 * 2009.05.19 임재택
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.vo.HongKongManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.vo.HongKongSearchManifestListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.vo.HongKongSearchVesselVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.vo.HongKongVesselCondVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * OPUS HongKongManifestListDownloadDBDAO <br>
 * - OPUS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author LIM JAE TAEK
 * @see HongKongManifestListDownloadBCImpl 참조
 * @since J2EE 1.4
 */
public class HongKongManifestListDownloadDBDAO extends DBDAOSupport {

	/**
	 * 	 홍콩 세관에 적하목록을 신고하기 위해 BKG Manifest 정보를 조회한다. 
	 * @param HongKongManifestListCondVO hongKongManifestListCondVO
	 * @return List<HongKongSearchManifestListVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<HongKongSearchManifestListVO> searchManifestList(
			HongKongManifestListCondVO hongKongManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<HongKongSearchManifestListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (hongKongManifestListCondVO != null) {
				Map<String, String> mapVO = hongKongManifestListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new HongKongManifestListDownloadDBDAOsearchManifestListRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
					HongKongSearchManifestListVO.class);
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
	 * 홍콩 세관에 적하목록을 신고하기 위해 Vessel 정보를 조회한다. 
	 * @param HongKongVesselCondVO hongKongVesselCondVO
	 * @return List<HongKongSearchVesselVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<HongKongSearchVesselVO> searchVessel(
			HongKongVesselCondVO hongKongVesselCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<HongKongSearchVesselVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (hongKongVesselCondVO != null) {
				Map<String, String> mapVO = hongKongVesselCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new HongKongManifestListDownloadDBDAOsearchVesselRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
					HongKongSearchVesselVO.class);
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

