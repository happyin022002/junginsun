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
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.basic.ManilaManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchBolVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchCheckPodVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchCheckPolVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchCheckVvdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchCntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchCtnVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchGenVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchPkgDescVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchPkgMarkVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchVvdDtlVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * NIS2010 ManilaManifestListDownloadDBDAO <br>
 * - NIS2010-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author LIM JAE TAEK
 * @see ManilaManifestListDownloadBCImpl 참조
 * @since J2EE 1.4
 */
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
	 * ManilaManifestListDownloadDAO의 General 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param manilaManifestListCondVO ManilaManifestListCondVO
	 * @return List<ManilaSearchGenVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ManilaSearchGenVO> searchGen( ManilaManifestListCondVO manilaManifestListCondVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<ManilaSearchGenVO> list = null;
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
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new ManilaManifestListDownloadDBDAOsearchGenRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
					ManilaSearchGenVO.class);
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
	 * ManilaManifestListDownloadDAO의 Container 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param manilaManifestListCondVO ManilaManifestListCondVO
	 * @return List<ManilaSearchCtnVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ManilaSearchCtnVO> searchCtn(
			ManilaManifestListCondVO manilaManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ManilaSearchCtnVO> list = null;
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
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new ManilaManifestListDownloadDBDAOsearchCtnRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
					ManilaSearchCtnVO.class);
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
	 * ManilaManifestListDownloadDAO의 BL 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param manilaManifestListCondVO ManilaManifestListCondVO
	 * @return List<ManilaSearchBolVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<ManilaSearchBolVO> searchBol(ManilaManifestListCondVO manilaManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ManilaSearchBolVO> list = null;
		// query
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(manilaManifestListCondVO != null) {
				Map<String, String> mapVO = manilaManifestListCondVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new ManilaManifestListDownloadDBDAOsearchBolRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ManilaSearchBolVO.class);
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

