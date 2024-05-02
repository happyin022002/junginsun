/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : AustraliaManifestListDownloadDBDAO.java
 *@FileTitle : AustraliaManifestListDownloadDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.06.28
 *@LastModifier :
 *@LastVersion : 1.0
 * 2013.06.28
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.basic.AustraliaManifestListDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusDgListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusDgListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusResultCuscarVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusResultSeacrSumVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusSearchCuscarVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusSendHistoryCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusSendHistoryDetailVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.BkgCstmsAusSndLogVO;


/**
 * OPUS AustraliaManifestListDownloadDBDAO <br>
 * - OPUS-AustraliaManifestListDownload system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KIM, Sang-Soo
 * @see AustraliaManifestListDownloadBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class AustraliaManifestListDownloadDBDAO extends DBDAOSupport {

	/**
	 * [ESM_BKG_1514] : CARLST
	 * [ESM_BKG_1517] : UBMREQ
	 * Australia Customs Cargo 목록 조회<br>
	 *
	 * @param AusSearchCuscarVO searchCuscarVO
	 * @return List<AusResultCuscarVO>
	 * @exception DAOException
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" })
	public List<AusResultCuscarVO> searchAusCarlstUbmreq(AusSearchCuscarVO searchCuscarVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (searchCuscarVO != null) {
				Map<String, String> mapVO = searchCuscarVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new AustraliaManifestListDownloadDBDAOsearchAusCarlstUbmreqRSQL(), param, velParam, AusResultCuscarVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException( new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException( new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1516]
	 * Australia Sea Cargo Report - SEACR Summary 조회<br>
	 *
	 * @param AusSearchCuscarVO searchCuscarVO
	 * @return List<AusResultSeacrSumVO>
	 * @exception DAOException
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" })
	public List<AusResultSeacrSumVO> searchAusSeacrSum(AusSearchCuscarVO searchCuscarVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (searchCuscarVO != null) {
				Map<String, String> mapVO = searchCuscarVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new AustraliaManifestListDownloadDBDAOsearchAusSeacrSumRSQL(), param, velParam, AusResultSeacrSumVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException( new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException( new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1516]
	 * Australia Sea Cargo Report - B/L 목록 조회<br>
	 *
	 * @param AusSearchCuscarVO searchCuscarVO
	 * @return List<AusResultCuscarVO>
	 * @exception DAOException
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" })
	public List<AusResultCuscarVO> searchAusSeacrBl(AusSearchCuscarVO searchCuscarVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (searchCuscarVO != null) {
				Map<String, String> mapVO = searchCuscarVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new AustraliaManifestListDownloadDBDAOsearchAusSeacrBlRSQL(), param, velParam, AusResultCuscarVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException( new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException( new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1515]
	 * Transmit Result Error Report 목록 조회
	 *
	 * @param String ediRefId
	 * @return List<BkgCstmsAusSndLogVO>
	 * @exception DAOException
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" })
	public List<BkgCstmsAusSndLogVO> searchReceiveFlatFile(String ediRefId) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("edi_ref_id", ediRefId);
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new AustraliaManifestListDownloadDBDAOsearchReceiveFlatFileRSQL(), param, null, BkgCstmsAusSndLogVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException( new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException( new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * BKG의 위험물 테이블에서 데이타를 조회해온다.<br>
	 *
	 * @param AusDgListCondVO ausDgListCondVO
	 * @return List<AusDgListDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" } )
	public List<AusDgListDetailVO> searchAusDgInfoAtBkgDg(AusDgListCondVO ausDgListCondVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(ausDgListCondVO != null) {
				Map<String, String> mapVO = ausDgListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new AustraliaManifestListDownloadDBDAOsearchAusDgInfoAtBkgDgRSQL(), param, velParam, AusDgListDetailVO.class);
		} catch (SQLException se) {
			throw new DAOException( new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException( new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Lloyd, vessel name등 Vessel 정보를 조회해옴-(Booking 쪽 data),<br>
	 * 도착일시/출발일시 정보를 Local 운항스케쥴에서 조회함- (Booking 쪽 data) <br>
	 *
	 * @param AusDgListCondVO ausDgListCondVO
	 * @return List<AusDgListDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" } )
	public List<AusDgListDetailVO> serachAusVslAtCommon(AusDgListCondVO ausDgListCondVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(ausDgListCondVO != null) {
				Map<String, String> mapVO = ausDgListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new AustraliaManifestListDownloadDBDAOserachAusVslAtCommonRSQL(), param, velParam, AusDgListDetailVO.class);
		} catch (SQLException se) {
			throw new DAOException( new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException( new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Sent결과를 조회해 온다.<br>
	 *
	 * @param AusSendHistoryCondVO ausSendHistoryCondVO
	 * @return List<AusSendHistoryDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" } )
	public List<AusSendHistoryDetailVO> searchAusSendHistoryByCntrNo(AusSendHistoryCondVO ausSendHistoryCondVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (ausSendHistoryCondVO != null) {
				Map<String, String> mapVO = ausSendHistoryCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new AustraliaManifestListDownloadDBDAOsearchAusSendHistoryByCntrNoRSQL(), param, velParam, AusSendHistoryDetailVO.class);
		} catch (SQLException se) {
			throw new DAOException( new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException( new ErrorHandler(ex).getMessage(), ex);
		}
	}


}
