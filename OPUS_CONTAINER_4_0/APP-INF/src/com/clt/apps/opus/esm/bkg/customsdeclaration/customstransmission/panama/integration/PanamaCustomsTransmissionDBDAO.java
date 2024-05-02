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
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.basic.PanamaCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.vo.BkgCstmsPnmRcvErrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.vo.BkgCstmsPnmRcvLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.vo.BkgCstmsPnmSndLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.vo.PanamaCstmsRcvLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.vo.PanamaManifestListEmptyCargoDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.vo.PanamaManifestListGeneralCargoDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.vo.PanamaManifestListHamoTrpCdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.vo.PanamaManifestListHazardousCargoDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.vo.PanamaManifestListMctForBasicInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.vo.PanamaManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.panama.integration.PanamaManifestListDownloadDBDAOsearchCallSeqRSQL;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


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
	
	/**
	 * BkgCstmsPnmSndLogVO Insert
	 * 
	 * @param bkgCstmsPnmSndLogVO
	 * @throws DAOException
	 */
	public void addBkgCstmsPnmSndLogVO(BkgCstmsPnmSndLogVO bkgCstmsPnmSndLogVO) throws DAOException {
		try
		{
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			if (bkgCstmsPnmSndLogVO != null)
			{
				Map<String, String> mapVO = bkgCstmsPnmSndLogVO.getColumnValues();
				velParam.putAll(mapVO);
				sqlExe.executeUpdate((ISQLTemplate) new PanamaCustomsTransmissionDBDAOaddBkgCstmsPnmSndLogCSQL(), mapVO, velParam);
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * BkgCstmsPnmRcvLogVO Insert
	 * 
	 * @param bkgCstmsPnmRcvLogVO
	 * @throws DAOException
	 */
	public void addBkgCstmsPnmRcvLogVO(BkgCstmsPnmRcvLogVO bkgCstmsPnmRcvLogVO) throws DAOException {
		try
		{
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			if (bkgCstmsPnmRcvLogVO != null)
			{
				Map<String, String> mapVO = bkgCstmsPnmRcvLogVO.getColumnValues();
				velParam.putAll(mapVO);
				sqlExe.executeUpdate((ISQLTemplate) new PanamaCustomsTransmissionDBDAOaddBkgCstmsPnmRcvLogCSQL(), mapVO, velParam);
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * BkgCstmsPnmRcvErrVO Insert
	 * 
	 * @param bkgCstmsPnmRcvErrVOs Container
	 * @throws DAOException
	 */
	public void addBkgCstmsPnmRcvErrVO(List<BkgCstmsPnmRcvErrVO> bkgCstmsPnmRcvErrVOs) throws DAOException {
		try
		{
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgCstmsPnmRcvErrVOs != null && bkgCstmsPnmRcvErrVOs.size() > 0)
			{
				Map<String, String> mapVO = bkgCstmsPnmRcvErrVOs.get(0).getColumnValues();
				velParam.putAll(mapVO);
				updCnt = sqlExe.executeBatch((ISQLTemplate) new PanamaCustomsTransmissionDBDAOaddBkgCstmsPnmRcvErrCSQL(),  bkgCstmsPnmRcvErrVOs, velParam);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * searchVstNo
	 * 
	 * @param crrBatNo 조회조건
	 * @return String
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgCstmsPnmSndLogVO searchVstNo(String crrBatNo) throws DAOException {
		DBRowSet dbRowset = null;
		BkgCstmsPnmSndLogVO sndLog = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("crr_bat_no", crrBatNo);
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PanamaCustomsTransmissionDBDAOsearchVstNoRSQL(), param, velParam);
			List list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsPnmSndLogVO.class);
			if (list.size() > 0)
				sndLog = (BkgCstmsPnmSndLogVO)list.get(0);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return sndLog;
	}

	/**
	 * RCV LOG SEQ 조회 
	 * 
	 * @param vstNo
	 * @param vvdCd
	 * @return
	 * @throws DAOException
	 */
	public String searchCstmsRcvNextSeq(String vstNo, String vvdCd) throws DAOException {
		DBRowSet dbRowset = null;
		String nextSeq = "1";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("vst_no", vstNo);
			param.put("vvd_cd", vvdCd);
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PanamaCustomsTransmissionDBDAOsearchCstmsRcvNextSeqRSQL(), param, velParam);
			if (dbRowset.next()) {
				nextSeq = dbRowset.getString(1);
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return nextSeq;
	}
	
	/**
	 * RCV Log History
	 * 
	 * @param bkgCstmsPnmRcvLogVO 조회조건
	 * @return List<BkgCstmsPnmRcvLogVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PanamaCstmsRcvLogVO> searchCstmsRcvLogList(BkgCstmsPnmRcvLogVO bkgCstmsPnmRcvLogVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PanamaCstmsRcvLogVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.putAll(bkgCstmsPnmRcvLogVO.getColumnValues());
			velParam.putAll(bkgCstmsPnmRcvLogVO.getColumnValues());
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PanamaCustomsTransmissionDBDAOsearchCstmsRcvLogRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PanamaCstmsRcvLogVO.class);
			
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * View RCV Log File 
	 * 
	 * @param bkgCstmsPnmRcvLogVO 조회조건
	 * @return List<BkgCstmsPnmRcvLogVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgCstmsPnmRcvLogVO searchCstmsRcvLogDetail(BkgCstmsPnmRcvLogVO bkgCstmsPnmRcvLogVO) throws DAOException {
		DBRowSet dbRowset = null;
		BkgCstmsPnmRcvLogVO vo = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.putAll(bkgCstmsPnmRcvLogVO.getColumnValues());
			velParam.putAll(bkgCstmsPnmRcvLogVO.getColumnValues());
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PanamaCustomsTransmissionDBDAOsearchCstmsRcvLogRSQL(), param, velParam);
			List list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsPnmRcvLogVO.class);
			if (list.size() > 0)
				vo = (BkgCstmsPnmRcvLogVO)list.get(0);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return vo;
	}
}
