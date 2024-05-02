/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : IndonesiaManifestListDownloadDBDAO.java
 *@FileTitle : UI_BKG-0311
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.29
 *@LastModifier : 장지영
 *@LastVersion : 1.0
 * 2009.09.29 장지영
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.vo.IndonesiaManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.vo.IndonesiaSearchManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.vo.indonesiaBkgDetailVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * NIS2010 IndonesiaManifestListDownloadDBDAO <br>
 * - 인도네시아 세관 전송 대상 데이터 조회<br>
 * 
 * @author JI-YOUNG JANG
 * @see IndonesiaManifestListDownloadBCImpl 참조
 * @since J2EE 1.4
 */
public class IndonesiaManifestListDownloadDBDAO extends DBDAOSupport {

	/**
	 * 	 인도네시아 세관에 적하목록을 신고하기 위해 BKG Manifest 정보를 조회한다. 
	 * @param indonesiaManifestListCondVO
	 * @return List<IndonesiaSearchManifestListVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<IndonesiaSearchManifestListVO> searchManifestListByOpt01(
			IndonesiaManifestListCondVO indonesiaManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<IndonesiaSearchManifestListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (indonesiaManifestListCondVO != null) {
				Map<String, String> mapVO = indonesiaManifestListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			log.info("in DAO");
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new IndonesiaManifestListDownloadDBDAOsearchManifestListByOpt01RSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
					IndonesiaSearchManifestListVO.class);
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
	 * 	 인도네시아 세관에 적하목록을 신고하기 위해 BKG Manifest 정보를 조회한다. 
	 * @param indonesiaManifestListCondVO
	 * @return List<IndonesiaSearchManifestListVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<IndonesiaSearchManifestListVO> searchManifestListByOpt02(
			IndonesiaManifestListCondVO indonesiaManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<IndonesiaSearchManifestListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (indonesiaManifestListCondVO != null) {
				Map<String, String> mapVO = indonesiaManifestListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			log.info("in DAO");
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new IndonesiaManifestListDownloadDBDAOsearchManifestListByOpt02RSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
					IndonesiaSearchManifestListVO.class);
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
	 * 	 인도네시아 세관에 적하목록을 신고하기 위해 BKG Manifest 정보를 조회한다. 
	 * @param indonesiaManifestListCondVO
	 * @return List<IndonesiaSearchManifestListVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<IndonesiaSearchManifestListVO> searchManifestListByOpt03(
			IndonesiaManifestListCondVO indonesiaManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<IndonesiaSearchManifestListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (indonesiaManifestListCondVO != null) {
				Map<String, String> mapVO = indonesiaManifestListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			log.info("in DAO");
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new IndonesiaManifestListDownloadDBDAOsearchManifestListByOpt03RSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
					IndonesiaSearchManifestListVO.class);
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
	 * 	 인도네시아 세관에 적하목록을 신고하기 위해 BKG Manifest 정보를 조회한다. 
	 * @param indonesiaManifestListCondVO
	 * @return List<IndonesiaSearchManifestListVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<IndonesiaSearchManifestListVO> searchManifestListByOpt04(
			IndonesiaManifestListCondVO indonesiaManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<IndonesiaSearchManifestListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (indonesiaManifestListCondVO != null) {
				Map<String, String> mapVO = indonesiaManifestListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			log.info("in DAO");
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new IndonesiaManifestListDownloadDBDAOsearchManifestListByOpt04RSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
					IndonesiaSearchManifestListVO.class);
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
	 * 	 인도네시아 세관에 적하목록을 신고하기 위해 BKG Detail 정보를 조회한다. 
	 * @param IndonesiaManifestListCondVO  indonesiaManifestListCondVO
	 * @return List<indonesiaBkgDetailVO>
	 * @throws DAOException
	 * @throws Exception
	 */	
	 @SuppressWarnings("unchecked")
		public List<indonesiaBkgDetailVO> searchBkgInfo(IndonesiaManifestListCondVO  indonesiaManifestListCondVO) throws DAOException {
			 
			List<indonesiaBkgDetailVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(indonesiaManifestListCondVO != null){
					Map<String, String> mapVO = indonesiaManifestListCondVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				list = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new IndonesiaManifestListDownloadDBDAOsearchBkgDetailRSQL(), param, velParam, indonesiaBkgDetailVO.class);
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			
			return list;
		}
	

}

