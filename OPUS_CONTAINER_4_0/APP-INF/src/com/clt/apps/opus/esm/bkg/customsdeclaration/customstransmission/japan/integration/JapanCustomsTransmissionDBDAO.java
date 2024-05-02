/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JapanCustomsTransmissionDAO.java
*@FileTitle : UI_BKG-0730
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.21
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.04.21 김승민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanReceiveLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.basic.JapanCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.EdiJapanCommonVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListBlCntrInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListBlCustInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListBlGeneralInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListBlMarkDescInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListEmptyBlCntrInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListEmptyBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListSendHeaderInfoForDmfVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListSendHeaderInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListVesselArrivalDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanTransmitBlKeyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration.JapanManifestListDownloadDBDAOsearchEtaRSQL;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration.JapanManifestListDownloadDBDAOsearchJpcusEtaRSQL;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListEtcVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.BkgCstmsJpRcvLogVO;
import com.clt.syscommon.common.table.BkgCstmsJpSndLogVO;

/**
 * OPUS JapanCustomsTransmissionDAO <br>
 * - OPUS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KIM SEUNG MIN
 * @see JapanCustomsTransmissionBCImpl 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("serial")
public class JapanCustomsTransmissionDBDAO extends DBDAOSupport {

	/**
	 * 일본세관 Manifest 신고용 Estimated Vessel Arrival 정보를 조회한다.<br>
	 *
	 * @param JapanManifestTransmitVO japanManifestTransmitVO
	 * @return List<JapanManifestListEtcVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JapanManifestListEtcVO> searchJpcusEta(JapanManifestTransmitVO japanManifestTransmitVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (japanManifestTransmitVO != null) {
				Map<String, String> mapVO = japanManifestTransmitVO.getColumnValues();
				param.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanManifestListDownloadDBDAOsearchJpcusEtaRSQL(), param, null, true);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, JapanManifestListEtcVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Vessel Call Sign 번호를 조회한다.<br>
	 *
	 * @param String inVslCd
	 * @return String callSgnNo
	 * @throws DAOException
	 */
	public String searchVslCallsign(String inVslCd) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("in_vsl_cd", inVslCd);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchSendLogSeqRSQL(), param, null, true);
			return (dbRowset.next() ? dbRowset.getString(1) : "");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * DMF 메시지가 기존에 전송된 적이 있는 지 여부를 확인한다.<br>
	 *
	 * @param JapanManifestTransmitVO japanManifestTransmitVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchDmfSendLog(JapanManifestTransmitVO japanManifestTransmitVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (japanManifestTransmitVO != null) {
				Map<String, String> mapVO = japanManifestTransmitVO.getColumnValues();
				param.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchDmfSendLogRSQL(), param, null, true);
			return (dbRowset.next() ? dbRowset.getInt(1) : 0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 일본세관 신고용 Manifest Estimated Vessel Arrival Date 를 조회한다.<br>
	 *
	 * @param JapanManifestTransmitVO japanManifestTransmitVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchEta(JapanManifestTransmitVO japanManifestTransmitVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (japanManifestTransmitVO != null) {
				Map<String, String> mapVO = japanManifestTransmitVO.getColumnValues();
				param.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanManifestListDownloadDBDAOsearchEtaRSQL(), param, null, true);
			return (dbRowset.next() ? dbRowset.getString(1) : "");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 일본세관 신고용 Manifest Empty Indicator 를 조회한다.<br>
	 *
	 * @param JapanTransmitBlKeyVO japanTransmitBlKeyVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchEmptyInd(JapanTransmitBlKeyVO japanTransmitBlKeyVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (japanTransmitBlKeyVO != null) {
				Map<String, String> mapVO = japanTransmitBlKeyVO.getColumnValues();
				param.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchEmptyIndRSQL(), param, null, true);
			return (dbRowset.next() ? dbRowset.getString(1) : "");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 일본세관 신고용 Manifest Empty B/L 정보를 조회한다.<br>
	 *
	 * @param JapanTransmitBlKeyVO japanTransmitBlKeyVO
	 * @return List<JapanManifestListEmptyBlInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JapanManifestListEmptyBlInfoVO> searchEmptyBl(JapanTransmitBlKeyVO japanTransmitBlKeyVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (japanTransmitBlKeyVO != null) {
				Map<String, String> mapVO = japanTransmitBlKeyVO.getColumnValues();
				param.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchEmptyBlRSQL(), param, null, true);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, JapanManifestListEmptyBlInfoVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 일본세관 신고용 Manifest Empty B/L Container 정보를 조회한다.<br>
	 *
	 * @param JapanTransmitBlKeyVO japanTransmitBlKeyVO
	 * @return List<JapanManifestListEmptyBlCntrInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JapanManifestListEmptyBlCntrInfoVO> searchEmptyBlCntr(JapanTransmitBlKeyVO japanTransmitBlKeyVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (japanTransmitBlKeyVO != null) {
				Map<String, String> mapVO = japanTransmitBlKeyVO.getColumnValues();
				param.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchEmptyBlCntrRSQL(), param, null, true);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, JapanManifestListEmptyBlCntrInfoVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 일본세관 신고용 Manifest B/L General 정보를 조회 (Full)<br>
	 *
	 * @param JapanTransmitBlKeyVO japanTransmitBlKeyVO
	 * @return List<EdiJapanCommonVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EdiJapanCommonVO> searchEdiBlGeneralMfrFull(JapanTransmitBlKeyVO japanTransmitBlKeyVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (japanTransmitBlKeyVO != null) {
				Map<String, String> mapVO = japanTransmitBlKeyVO.getColumnValues();
				param.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchEdiBlGeneralMfrFullRSQL(), param, null, true);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, EdiJapanCommonVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 일본세관 신고용 Manifest B/L General 정보를 조회 (Empty)<br>
	 *
	 * @param JapanTransmitBlKeyVO japanTransmitBlKeyVO
	 * @return List<EdiJapanCommonVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EdiJapanCommonVO> searchEdiBlGeneralMfrMt(JapanTransmitBlKeyVO japanTransmitBlKeyVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (japanTransmitBlKeyVO != null) {
				Map<String, String> mapVO = japanTransmitBlKeyVO.getColumnValues();
				param.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchEdiBlGeneralMfrMtRSQL(), param, null, true);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, EdiJapanCommonVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 일본세관 신고용 Manifest B/L General 정보를 조회한다.<br>
	 *
	 * @param JapanTransmitBlKeyVO japanTransmitBlKeyVO
	 * @return List<JapanManifestListBlGeneralInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JapanManifestListBlGeneralInfoVO> searchBlGeneral(JapanTransmitBlKeyVO japanTransmitBlKeyVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (japanTransmitBlKeyVO != null) {
				Map<String, String> mapVO = japanTransmitBlKeyVO.getColumnValues();
				param.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchBlGeneralRSQL(), param, null, true);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, JapanManifestListBlGeneralInfoVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 일본세관 신고용 Manifest B/L Customer 정보를 조회 (Full)<br>
	 *
	 * @param JapanTransmitBlKeyVO japanTransmitBlKeyVO
	 * @returnList<EdiJapanCommonVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EdiJapanCommonVO> searchEdiBlCustMfrFull(JapanTransmitBlKeyVO japanTransmitBlKeyVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (japanTransmitBlKeyVO != null) {
				Map<String, String> mapVO = japanTransmitBlKeyVO.getColumnValues();
				param.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchEdiBlCustMfrFullRSQL(), param, null, true);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, EdiJapanCommonVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 일본세관 신고용 Manifest B/L Customer 정보를 조회 (Empty)<br>
	 *
	 * @param JapanTransmitBlKeyVO japanTransmitBlKeyVO
	 * @returnList<EdiJapanCommonVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EdiJapanCommonVO> searchEdiBlCustMfrMt(JapanTransmitBlKeyVO japanTransmitBlKeyVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (japanTransmitBlKeyVO != null) {
				Map<String, String> mapVO = japanTransmitBlKeyVO.getColumnValues();
				param.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchEdiBlCustMfrMtRSQL(), param, null, true);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, EdiJapanCommonVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 일본세관 신고용 Manifest B/L Customer 정보를 조회한다.<br>
	 *
	 * @param JapanTransmitBlKeyVO japanTransmitBlKeyVO
	 * @return List<JapanManifestListBlCustInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JapanManifestListBlCustInfoVO> searchBlCust(JapanTransmitBlKeyVO japanTransmitBlKeyVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (japanTransmitBlKeyVO != null) {
				Map<String, String> mapVO = japanTransmitBlKeyVO.getColumnValues();
				param.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchBlCustRSQL(), param, null, true);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, JapanManifestListBlCustInfoVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * EDI_REF_ID와 CNTR_NO로 일본세관 BL_NO 조회<br>
	 *
	 * @param String ediRefId
	 * @param String cntrNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchJpBlCntrByEdiRefId(String ediRefId, String cntrNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("edi_ref_id", ediRefId);
			param.put("cntr_no", cntrNo);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchJpBlCntrByEdiRefIdRSQL(), param, null, true);
			String retVal = "";
			if (dbRowset.getRowCount() > 0) if (dbRowset.next()) retVal = dbRowset.getString(1);
			return retVal;
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * EDI_REF_ID로 일본세관 SND_LOG에서 VVD, POD등의 정보 조회<br>
	 *
	 * @param String ediRefId
	 * @return List<BkgCstmsJpSndLogVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BkgCstmsJpSndLogVO> searchJpSndLogByEdiRefId(String ediRefId) throws DAOException {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("edi_ref_id", ediRefId);

			return (List) new SQLExecuter("").executeQuery((ISQLTemplate)new JapanCustomsTransmissionDBDAOsearchJpSndLogByEdiRefIdRSQL(), param, null, BkgCstmsJpSndLogVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 일본세관 신고용 Manifest B/L Container 정보를 조회 (Full)<br>
	 *
	 * @param JapanTransmitBlKeyVO japanTransmitBlKeyVO
	 * @return List<EdiJapanCommonVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EdiJapanCommonVO> searchEdiBlCntrMfrFull(JapanTransmitBlKeyVO japanTransmitBlKeyVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (japanTransmitBlKeyVO != null) {
				Map<String, String> mapVO = japanTransmitBlKeyVO.getColumnValues();
				param.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchEdiBlCntrMfrFullRSQL(), param, null, true);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, EdiJapanCommonVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 일본세관 신고용 Manifest B/L Container 정보를 조회 (Empty)<br>
	 *
	 * @param JapanTransmitBlKeyVO japanTransmitBlKeyVO
	 * @return List<EdiJapanCommonVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EdiJapanCommonVO> searchEdiBlCntrMfrMt(JapanTransmitBlKeyVO japanTransmitBlKeyVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (japanTransmitBlKeyVO != null) {
				Map<String, String> mapVO = japanTransmitBlKeyVO.getColumnValues();
				param.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchEdiBlCntrMfrMtRSQL(), param, null, true);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, EdiJapanCommonVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


	/**
	 * 일본세관 신고용 Manifest B/L Container 정보를 조회한다.<br>
	 *
	 * @param JapanTransmitBlKeyVO japanTransmitBlKeyVO
	 * @return List<JapanManifestListBlCntrInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JapanManifestListBlCntrInfoVO> searchBlCntr(JapanTransmitBlKeyVO japanTransmitBlKeyVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (japanTransmitBlKeyVO != null) {
				Map<String, String> mapVO = japanTransmitBlKeyVO.getColumnValues();
				param.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchBlCntrRSQL(), param, null, true);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, JapanManifestListBlCntrInfoVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 일본세관 신고용 Container Seal No.를 조회한다.<br>
	 *
	 * @param String blNo
	 * @param String cntrNo
	 * @return List<EdiJapanCommonVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EdiJapanCommonVO> searchEdiCntrSealNoMfrFull(String blNo, String cntrNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bl_no", blNo);
			param.put("cntr_no", cntrNo);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchEdiCntrSealNoMfrFullRSQL(), param, null);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, EdiJapanCommonVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 일본세관 신고용 Container Seal No.를 조회한다.<br>
	 *
	 * @param String blNo
	 * @param String cntrNo
	 * @return List<JapanManifestListBlCntrInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JapanManifestListBlCntrInfoVO> searchCntrSealNo(String blNo, String cntrNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bl_no", blNo);
			param.put("cntr_no", cntrNo);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchCntrSealNoRSQL(), param, null, true);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, JapanManifestListBlCntrInfoVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 일본세관 신고용 Manifest B/L Mark Description 정보를 조회한다.<br>
	 *
	 * @param JapanTransmitBlKeyVO japanTransmitBlKeyVO
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchEdiBlMarkDescMfrFull(JapanTransmitBlKeyVO japanTransmitBlKeyVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (japanTransmitBlKeyVO != null) {
				Map<String, String> mapVO = japanTransmitBlKeyVO.getColumnValues();
				param.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchEdiBlMarkDescMfrFullRSQL(), param, null, true);
			return (dbRowset.next() ? new String[]{dbRowset.getString("BL_DESC"), dbRowset.getString("DIFF_RMK")} : new String[]{"N/M", "N/M"});
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 일본세관 신고용 Manifest B/L Mark Description 정보를 조회한다.<br>
	 *
	 * @param JapanTransmitBlKeyVO japanTransmitBlKeyVO
	 * @return List<JapanManifestListBlMarkDescInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JapanManifestListBlMarkDescInfoVO> searchBlMarkDesc(JapanTransmitBlKeyVO japanTransmitBlKeyVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (japanTransmitBlKeyVO != null) {
				Map<String, String> mapVO = japanTransmitBlKeyVO.getColumnValues();
				param.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchBlMarkDescRSQL(), param, null, true);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, JapanManifestListBlMarkDescInfoVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 일본세관 신고용 Header 정보를 조회한다.<br>
	 *
	 * @param String inVvdCd
	 * @param String inPodCd
	 * @param String ofcCd
	 * @param String usrId
	 * @param String inMsgTp
	 * @param String dateData
	 * @param String strLength
	 * @param String blNo
	 * @return List<JapanManifestListSendHeaderInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JapanManifestListSendHeaderInfoVO> searchSendHeader(String inVvdCd, String inPodCd, String ofcCd, String usrId, String inMsgTp, String dateData, String strLength, String blNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("in_vvd_cd", inVvdCd);
			param.put("in_pod_cd", inPodCd);
			param.put("ofc_cd", ofcCd);
			param.put("usr_id", usrId);
			param.put("in_msg_tp", inMsgTp);
			param.put("date_data", dateData);
			param.put("str_length", strLength);
			param.put("bl_no", blNo);
			velParam.putAll(param);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchSendHeaderRSQL(), param, velParam, true);
			return  (List) RowSetUtil.rowSetToVOs(dbRowset, JapanManifestListSendHeaderInfoVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 일본세관 신고용 Header(DMF용) 정보를 조회한다.<br>
	 *
	 * @param String inVvdCd
	 * @param String inPodCd
	 * @param String ofcCd
	 * @param String usrId
	 * @param String vesselInfo
	 * @param String sendDt
	 * @return List<JapanManifestListSendHeaderInfoForDmfVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JapanManifestListSendHeaderInfoForDmfVO> searchSendHeaderForDmf(String inVvdCd, String inPodCd, String ofcCd, String usrId, String vesselInfo, String sendDt) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("in_vvd_cd", inVvdCd);
			param.put("in_pod_cd", inPodCd);
			param.put("ofc_cd", ofcCd);
			param.put("usr_id", usrId);
			param.put("vessel_info", vesselInfo);
			param.put("send_dt", sendDt);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchSendHeaderForDmfRSQL(), param, null, true);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, JapanManifestListSendHeaderInfoForDmfVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 일본세관 신고용 Manifest Vessel Arrival 정보를 조회한다.<br>
	 *
	 * @param String inVvdCd
	 * @param String inPodcd
	 * @param String inPodCdSplit
	 * @param String inEtaDt
	 * @return List<JapanManifestListSendHeaderInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JapanManifestListVesselArrivalDetailVO> searchVesselArrival(String inVvdCd, String inPodcd, String inPodCdSplit, String inEtaDt) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("in_vvd_cd", inVvdCd);
			param.put("in_pod_cd", inPodcd);
			param.put("in_pod_cd_split", inPodCdSplit);
			param.put("in_eta_dt", inEtaDt);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchVesselArrivalRSQL(), param, null, true);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, JapanManifestListVesselArrivalDetailVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 일본세관 신고용 Send Log 테이블 Seq를 조회한다.<br>
	 *
	 * @param String sndDt
	 * @param String msgTp
	 * @return int seqNumber
	 * @throws DAOException
	 */
	public int searchSendLogSeq(String sndDt, String msgTp) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("snd_dt", sndDt);
			param.put("msg_tp", msgTp);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchSendLogSeqRSQL(), param, null, true);
			return (dbRowset.next() ? dbRowset.getInt(1) : 0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 일본세관 신고용 Receive Log 테이블 Seq를 조회한다.<br>
	 *
	 * @return int seqNumber
	 * @throws DAOException
	 */
	public int searchReceiveLogSeq() throws DAOException {
		try {
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchReceiveLogSeqRSQL(), null, null, true);
			return (dbRowset.next() ? dbRowset.getInt(1) : 0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 일본세관에 전송할 Manifest Detail 정보를 조회한다.<br>
	 *
	 * @param String jpSndLogId
	 * @param String msgSndDt
	 * @param String ofcCd
	 * @param String logSeq
	 * @param String blNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchDetailInfo(String jpSndLogId, String msgSndDt, String ofcCd, String logSeq, String blNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("jp_snd_log_id", jpSndLogId);
			param.put("msg_snd_dt", msgSndDt);
			param.put("ofc_cd", ofcCd);
			param.put("log_seq", logSeq);
			param.put("bl_no", blNo);
			velParam.putAll(param);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchDetailInfoRSQL(), param, velParam, true);
			StringBuffer ediSndMsg = new StringBuffer();
			while (dbRowset.next()) ediSndMsg.append(dbRowset.getString("EDI_SND_MSG"));
			return ediSndMsg.toString();
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 일본세관에 전송한 Send Log의 Send Date를 업데이트한다.<br>
	 *
	 * @param BkgCstmsJpSndLogVO bkgCstmsJpSndLogVO
	 * @throws DAOException
	 */
	public void modifySendLog(BkgCstmsJpSndLogVO bkgCstmsJpSndLogVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (bkgCstmsJpSndLogVO != null) {
				Map<String, String> mapVO = bkgCstmsJpSndLogVO.getColumnValues();
				param.putAll(mapVO);
			}
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new JapanCustomsTransmissionDBDAOmodifySendLogUSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 일본세관 Manifest 전송 로그를 생성한다.<br>
	 *
	 * @param List<BkgCstmsJpSndLogVO> bkgCstmsJpSndLogVOList
	 * @throws DAOException
	 */
	public void addSendLog(List<BkgCstmsJpSndLogVO> bkgCstmsJpSndLogVOList) throws DAOException, Exception {
		try {
			if (bkgCstmsJpSndLogVOList.size() > 0) {
				int insCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new JapanCustomsTransmissionDBDAOaddSendLogCSQL(), bkgCstmsJpSndLogVOList, null);
				for(int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 일본세관 Manifest 수신 로그를 생성한다.<br>
	 *
	 * @param List<BkgCstmsJpRcvLogVO> bkgCstmsJpRcvLogVOList
	 * @throws DAOException
	 */
	public void addReceiveLog(List<BkgCstmsJpRcvLogVO> bkgCstmsJpRcvLogVOList) throws DAOException, Exception {
		try {
			if (bkgCstmsJpRcvLogVOList.size() > 0) {
				int insCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new JapanCustomsTransmissionDBDAOaddReceiveLogCSQL(), bkgCstmsJpRcvLogVOList, null);
				for(int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 일본세관으로부터 수신한 Manifest 내용을 업데이트한다.<br>
	 *
	 * @param JapanReceiveLogVO japanReceiveLogVO
	 * @throws DAOException
	 */
	public void modifyReceiveLog(JapanReceiveLogVO japanReceiveLogVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (japanReceiveLogVO != null) {
				Map<String, String> mapVO = japanReceiveLogVO.getColumnValues();
				param.putAll(mapVO);
			}
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new JapanCustomsTransmissionDBDAOmodifyReceiveLogUSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 일본세관에 전송할 POD 정보를 조회한다.<br>
	 *
	 * @param String inPodCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchJapanPODInfo(String inPodCd) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("in_pod_cd", inPodCd);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchJapanPODInfoRSQL(), param, null, true);
			return (dbRowset.next() ? dbRowset.getString(1) : "");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


}
