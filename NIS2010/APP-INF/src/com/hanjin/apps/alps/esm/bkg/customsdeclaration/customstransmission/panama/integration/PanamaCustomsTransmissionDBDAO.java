/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PanamaCustomsTransmissionDBDAO.java
*@FileTitle : UI_BKG-0017
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.21
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.04.21 김승민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.panama.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.panama.basic.PanamaCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.panama.vo.PanamaManifestListEmptyCargoDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.panama.vo.PanamaManifestListGeneralCargoDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.panama.vo.PanamaManifestListHamoTrpCdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.panama.vo.PanamaManifestListHazardousCargoDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.panama.vo.PanamaManifestListMctForBasicInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.panama.vo.PanamaManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.panama.integration.PanamaManifestListDownloadDBDAOsearchCallSeqRSQL;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS PanamaCustomsTransmissionDBDAO <br>
 * - ALPS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author KIM SEUNG MIN
 * @see PanamaCustomsTransmissionBCImpl 참조
 * @since J2EE 1.4
 */
public class PanamaCustomsTransmissionDBDAO extends DBDAOSupport {

	
	/**
	 * ACP(Authority of Canal of Panama)로 전송할 Manifest Basic Info를 조회한다.<br>
	 * 
	 * @param PanamaManifestTransmitVO panamaManifestTransmitVO
	 * @return List<PanamaManifestListMctForBasicInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PanamaManifestListMctForBasicInfoVO> searchMctForBasicInfo( 
			PanamaManifestTransmitVO panamaManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PanamaManifestListMctForBasicInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (panamaManifestTransmitVO != null) {
				Map<String, String> mapVO = panamaManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new PanamaCustomsTransmissionDBDAOsearchMctForBasicInfoRSQL(),param, velParam,true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					PanamaManifestListMctForBasicInfoVO.class);
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
	 * ACP(Authority of Canal of Panama)로 전송할 Manifest Vessel Call Sequence 정보를 조회한다.<br>
	 * 
	 * @param PanamaManifestTransmitVO panamaManifestTransmitVO
	 * @return String callSeq
	 * @throws DAOException
	 */
	public String searchCallSeq(
			PanamaManifestTransmitVO panamaManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		String callSeq = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (panamaManifestTransmitVO != null) {
				Map<String, String> mapVO = panamaManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PanamaManifestListDownloadDBDAOsearchCallSeqRSQL(),param, velParam,true);
			 if (dbRowset.next()) {
				 callSeq = dbRowset.getString(1);
			 } else {
				 callSeq = "";					 
			 }			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return callSeq;
	}
	
	/**
	 * ACP(Authority of Canal of Panama)로 전송할 Manifest General Cargo 정보를 조회한다.<br>
	 * 
	 * @param PanamaManifestTransmitVO panamaManifestTransmitVO
	 * @return List<PanamaManifestListGeneralCargoDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PanamaManifestListGeneralCargoDetailVO> searchGeneralCargoDetail(
			PanamaManifestTransmitVO panamaManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PanamaManifestListGeneralCargoDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (panamaManifestTransmitVO != null) {
				Map<String, String> mapVO = panamaManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new PanamaCustomsTransmissionDBDAOsearchGeneralCargoDetailRSQL(),param, velParam,true);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
					PanamaManifestListGeneralCargoDetailVO.class);
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
	 * ACP(Authority of Canal of Panama)로 전송할 Manifest Empty Cargo 정보를 조회한다.<br>
	 * 
	 * @param PanamaManifestTransmitVO panamaManifestTransmitVO
	 * @return List<PanamaManifestListEmptyCargoDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PanamaManifestListEmptyCargoDetailVO> searchEmptyCargoDetail(
			PanamaManifestTransmitVO panamaManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PanamaManifestListEmptyCargoDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (panamaManifestTransmitVO != null) {
				Map<String, String> mapVO = panamaManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new PanamaCustomsTransmissionDBDAOsearchEmptyCargoDetailRSQL(),param, velParam,true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					PanamaManifestListEmptyCargoDetailVO.class);
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
	 * ACP(Authority of Canal of Panama)로 전송할 Manifest Hazardous Cargo 정보를 조회한다.<br>
	 * 
	 * @param PanamaManifestTransmitVO panamaManifestTransmitVO
	 * @return List<PanamaManifestListHazardCargoDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PanamaManifestListHazardousCargoDetailVO> searchHazardousCargoDetail(
			PanamaManifestTransmitVO panamaManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PanamaManifestListHazardousCargoDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (panamaManifestTransmitVO != null) {
				Map<String, String> mapVO = panamaManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new PanamaCustomsTransmissionDBDAOsearchHazardousCargoDetailRSQL(),param, velParam,true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					PanamaManifestListHazardousCargoDetailVO.class);
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
	 * ACP(Authority of Canal of Panama)로 전송할 Manifest Basic Info를 조회한다.<br>
	 * 
	 * @param PanamaManifestTransmitVO panamaManifestTransmitVO
	 * @return List<PanamaManifestListHamoTrpCdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PanamaManifestListHamoTrpCdVO> searchHamoTrpCd(
			PanamaManifestTransmitVO panamaManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PanamaManifestListHamoTrpCdVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (panamaManifestTransmitVO != null) {
				Map<String, String> mapVO = panamaManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new PanamaCustomsTransmissionDBDAOsearchHamoTrpCdRSQL(),param, velParam,true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					PanamaManifestListHamoTrpCdVO.class);
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
	 * ACP(Authority of Canal of Panama)로 전송할 Manifest Basic Info를 조회한다.<br>
	 * 
	 * @param String hamoTrpCd
	 * @return String attrCtnt
	 * @throws DAOException
	 */
	public String searchAttrCtnt(String hamoTrpCd) throws DAOException {
		DBRowSet dbRowset = null;
		String attrCtnt = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
 			param.put("hamotrpcd", hamoTrpCd);			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PanamaCustomsTransmissionDBDAOsearchAttrCtntRSQL(),param, velParam,true);
			 if (dbRowset.next()) {
				 attrCtnt = dbRowset.getString(1);
			 } else {
				 attrCtnt = "";					 
			 }			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return attrCtnt;
	}	

		
}
