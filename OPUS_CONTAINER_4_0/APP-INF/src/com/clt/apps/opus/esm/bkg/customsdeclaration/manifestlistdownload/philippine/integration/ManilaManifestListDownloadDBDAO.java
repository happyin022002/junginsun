/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ManilaManifestListDownloadDBDAO.java
 *@FileTitle : UI_BKG-0234
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.19
 *@LastModifier : 임재택
 *@LastVersion : 1.0
 * 2009.05.19 임재택
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.basic.ManilaManifestListDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchCheckPodVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchCheckPolVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchCheckVvdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchCntrInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchPkgDescVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchPkgMarkVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchVvdDtlVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * OPUS ManilaManifestListDownloadDBDAO <br>
 * - OPUS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author LIM JAE TAEK
 * @see ManilaManifestListDownloadBCImpl 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("serial")
public class ManilaManifestListDownloadDBDAO extends DBDAOSupport {

	/**
	 * ManilaManifestListDownloadDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param manilaManifestListCondVO ManilaManifestListCondVO
	 * @return List<ManilasearchVvdDtlVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ManilaSearchVvdDtlVO> searchVvdDtl( ManilaManifestListCondVO manilaManifestListCondVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<ManilaSearchVvdDtlVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (manilaManifestListCondVO != null) {
				Map<String, String> mapVO = manilaManifestListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new ManilaManifestListDownloadDBDAOsearchVvdDtlRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
					ManilaSearchVvdDtlVO.class);
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
	 * ManilaManifestListDownloadDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param manilaManifestListCondVO ManilaManifestListCondVO
	 * @return List<ManilaSearchBlInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ManilaSearchBlInfoVO> searchBlInfo(
			ManilaManifestListCondVO manilaManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ManilaSearchBlInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (manilaManifestListCondVO != null) {
				Map<String, String> mapVO = manilaManifestListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new ManilaManifestListDownloadDBDAOsearchBlInfoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
					ManilaSearchBlInfoVO.class);
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
	 * ManilaManifestListDownloadDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param manilaManifestListCondVO ManilaManifestListCondVO
	 * @return List<ManilaSearchCntrInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ManilaSearchCntrInfoVO> searchCntrInfo(
			ManilaManifestListCondVO manilaManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ManilaSearchCntrInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (manilaManifestListCondVO != null) {
				Map<String, String> mapVO = manilaManifestListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new ManilaManifestListDownloadDBDAOsearchCntrInfoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
					ManilaSearchCntrInfoVO.class);
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
	 * ManilaManifestListDownloadDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param manilaManifestListCondVO ManilaManifestListCondVO
	 * @return List<ManilaSearchPkgDescVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ManilaSearchPkgDescVO> searchPkgDesc(
			ManilaManifestListCondVO manilaManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ManilaSearchPkgDescVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (manilaManifestListCondVO != null) {
				Map<String, String> mapVO = manilaManifestListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new ManilaManifestListDownloadDBDAOsearchPkgDescRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
					ManilaSearchPkgDescVO.class);
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
	 * ManilaManifestListDownloadDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param manilaManifestListCondVO ManilaManifestListCondVO
	 * @return List<ManilaSearchPkgMarkVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ManilaSearchPkgMarkVO> searchPkgMark(
			ManilaManifestListCondVO manilaManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ManilaSearchPkgMarkVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (manilaManifestListCondVO != null) {
				Map<String, String> mapVO = manilaManifestListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new ManilaManifestListDownloadDBDAOsearchPkgMarkRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
					ManilaSearchPkgMarkVO.class);
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
	 * MalilaManifestListDownloadDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param manilaManifestListCondVO ManilaManifestListCondVO
	 * @return List<ManilaSearchCheckPodVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ManilaSearchCheckPodVO> searchCheckPod(
			ManilaManifestListCondVO manilaManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ManilaSearchCheckPodVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
				Map<String, String> mapVO = manilaManifestListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new ManilaManifestListDownloadDBDAOsearchCheckPodRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					ManilaSearchCheckPodVO.class);
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
	 * MalilaManifestListDownloadDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param manilaManifestListCondVO ManilaManifestListCondVO
	 * @return List<ManilaSearchCheckPolVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ManilaSearchCheckPolVO> searchCheckPol(
			ManilaManifestListCondVO manilaManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ManilaSearchCheckPolVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (manilaManifestListCondVO != null) {
				Map<String, String> mapVO = manilaManifestListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new ManilaManifestListDownloadDBDAOsearchCheckPolRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					ManilaSearchCheckPolVO.class);
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
	 * MalilaManifestListDownloadDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param manilaManifestListCondVO ManilaManifestListCondVO
	 * @return List<ManilaSearchCheckVvdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ManilaSearchCheckVvdVO> searchCheckVvd(
			ManilaManifestListCondVO manilaManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ManilaSearchCheckVvdVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (manilaManifestListCondVO != null) {
				Map<String, String> mapVO = manilaManifestListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new ManilaManifestListDownloadDBDAOsearchCheckVvdRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					ManilaSearchCheckVvdVO.class);
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
	 * BKG_BOOKING에서 DEL_CD 조회<br>
	 *
	 * @param String blNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchDelCdFrBkg(String blNo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("bl_no", blNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ManilaManifestListDownloadDBDAOsearchDelCdFrBkgRSQL(), param, null);
			String delCd = "";
			if (dbRowset.next()) delCd = dbRowset.getString("DEL_CD");
			return delCd;
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}

