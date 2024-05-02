/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : PakistanManifestListDownloadDBDAO.java
 *@FileTitle : Pakistan Customs Manifest
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.07.18
 *@LastModifier : 김보배
 *@LastVersion : 1.0
 * 2012.07.18 김보배
 * 1.0 Creation
 * ------------------------------------------------------
 * History
 * 2012.08.31 김보배 [CHM-201219908] [BKG] Pakistan Manifest 기능 보완 요청
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.vo.PakistanBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.vo.PakistanCNTRInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.vo.PakistanManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.vo.PakistanVesselVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * OPUS PakistanManifestListDownloadDBDAO <br>
 * - OPUS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author BOBAE KIM
 * @see PakistanManifestLIstDownloadBCImpl 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("serial")
public class PakistanManifestListDownloadDBDAO extends DBDAOSupport {

	/**
	 * 파키스탄 세관 - VVD 정보 조회
	 *
	 * @param PakistanVesselVO pakistanVesselVO
	 * @return List<PakistanVesselVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PakistanVesselVO> searchVessel(PakistanVesselVO pakistanVesselVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<PakistanVesselVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (pakistanVesselVO != null) {
				Map<String, String> mapVO = pakistanVesselVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new PakistanManifestListDownloadDBDAOsearchVesselRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PakistanVesselVO.class);
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
	 * 파키스탄 세관 - B/L Info 조회
	 *
	 * @param PakistanManifestListCondVO pakistanManifestListCondVO
	 * @return List<PakistanBlInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PakistanBlInfoVO> searchBlInfo(PakistanManifestListCondVO pakistanManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PakistanBlInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (pakistanManifestListCondVO != null) {
				Map<String, String> mapVO = pakistanManifestListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new PakistanManifestListDownloadDBDAOsearchBlInfoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PakistanBlInfoVO.class);
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
	 * 파키스탄 세관 - container 정보 조회
	 *
	 * @param PakistanManifestListCondVO pakistanManifestListCondVO
	 * @return List<PakistanCNTRInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PakistanCNTRInfoVO> searchCNTRInfo(PakistanManifestListCondVO pakistanManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PakistanCNTRInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (pakistanManifestListCondVO != null) {
				Map<String, String> mapVO = pakistanManifestListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new PakistanManifestListDownloadDBDAOsearchCNTRInfoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PakistanCNTRInfoVO.class);
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
	 * 파키스탄 세관 - Charge Info 조회
	 *
	 * @param PakistanManifestListCondVO pakistanManifestListCondVO
	 * @return List<PakistanBlInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PakistanBlInfoVO> searchChargeInfo(PakistanManifestListCondVO pakistanManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PakistanBlInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (pakistanManifestListCondVO != null) {
				Map<String, String> mapVO = pakistanManifestListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new PakistanManifestListDownloadDBDAOsearchChargeInfoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PakistanBlInfoVO.class);
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

