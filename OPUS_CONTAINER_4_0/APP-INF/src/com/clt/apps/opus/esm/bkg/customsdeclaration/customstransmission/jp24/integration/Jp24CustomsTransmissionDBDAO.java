/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : Jp24CustomsTransmissionDBDAO.java
 *@FileTitle : Jp24CustomsTransmissionDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.06.28
 *@LastModifier :
 *@LastVersion : 1.0
 * 2013.06.28
 * 1.0 Creation
=========================================================*/ 
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.basic.Jp24CustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.vo.AdvJpReceiveLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.vo.AdvJpSendLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.vo.CstmsEmlListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.vo.DepartureTimeVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.vo.EdiAdvJpCommonVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.vo.ErrorReportVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.vo.FlatFileVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.vo.JmsReportVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.CargoInfoHeaderVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS Jp24CustomsTransmissionDBDAO <br>
 * - OPUS-Jp24CustomsTransmission system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KIM, Sang-Soo
 * @see Jp24CustomsTransmissionBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class Jp24CustomsTransmissionDBDAO extends DBDAOSupport {

	/**
	 * [ESM_BKG_1501] EDI Transmit
	 * BKG_CSTMS_ADV_JP_VSL_SKD 정보 수정저장<br>
	 *
	 * @param CargoInfoHeaderVO cargoInfoHeaderVO
	 * @exception DAOException, Exception
	 */
	public void modifyAdvJpVslSkd(CargoInfoHeaderVO cargoInfoHeaderVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (cargoInfoHeaderVO != null) {
				Map<String, String> mapVO = cargoInfoHeaderVO.getColumnValues();
				param.putAll(mapVO);
			}
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new Jp24CustomsTransmissionDBDAOModifyAdvJpVslSkdUSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1501_N] EDI Transmit
	 * BKG_CSTMS_ADV_JP_BL 정보 조회<br>
	 *
	 * @param CargoInfoHeaderVO cargoInfoHeaderVO
	 * @param String blNo
	 * @return List<EdiAdvJpCommonVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EdiAdvJpCommonVO> searchEdiAdvJpBl_N(CargoInfoHeaderVO cargoInfoHeaderVO, String blNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (cargoInfoHeaderVO != null) {
				Map<String, String> mapVO = cargoInfoHeaderVO.getColumnValues();
				param.putAll(mapVO);
			}
			param.put("bl_no", blNo);
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24CustomsTransmissionDBDAOSearchEdiAdvJpBl_N_RSQL(), param, null, EdiAdvJpCommonVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1501] EDI Transmit
	 * BKG_CSTMS_ADV_JP_BL 정보 조회<br>
	 *
	 * @param CargoInfoHeaderVO cargoInfoHeaderVO
	 * @param String blNo
	 * @return List<EdiAdvJpCommonVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EdiAdvJpCommonVO> searchEdiAdvJpBl(CargoInfoHeaderVO cargoInfoHeaderVO, String blNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (cargoInfoHeaderVO != null) {
				Map<String, String> mapVO = cargoInfoHeaderVO.getColumnValues();
				param.putAll(mapVO);
			}
			param.put("bl_no", blNo);
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24CustomsTransmissionDBDAOSearchEdiAdvJpBlRSQL(), param, null, EdiAdvJpCommonVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1501_N] EDI Transmit
	 * BKG_CSTMS_ADV_JP_CUST 정보 조회<br>
	 *
	 * @param String blNo
	 * @return List<EdiAdvJpCommonVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EdiAdvJpCommonVO> searchEdiAdvJpCustomer_N(String blNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bl_no", blNo);
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24CustomsTransmissionDBDAOSearchEdiAdvJpCustomer_N_RSQL(), param, null, EdiAdvJpCommonVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1501] EDI Transmit
	 * BKG_CSTMS_ADV_JP_CUST 정보 조회<br>
	 *
	 * @param String blNo
	 * @return List<EdiAdvJpCommonVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EdiAdvJpCommonVO> searchEdiAdvJpCustomer(String blNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bl_no", blNo);
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24CustomsTransmissionDBDAOSearchEdiAdvJpCustomerRSQL(), param, null, EdiAdvJpCommonVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1501_N] EDI Transmit
	 * BKG_CSTMS_ADV_JP_MK 정보 조회<br>
	 *
	 * @param String blNo
	 * @return List<EdiAdvJpCommonVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EdiAdvJpCommonVO> searchEdiAdvJpMarkDesc_N(String blNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bl_no", blNo);
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24CustomsTransmissionDBDAOSearchEdiAdvJpMarkDesc_N_RSQL(), param, null, EdiAdvJpCommonVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1501] EDI Transmit
	 * BKG_CSTMS_ADV_JP_MK 정보 조회<br>
	 *
	 * @param String blNo
	 * @return List<EdiAdvJpCommonVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EdiAdvJpCommonVO> searchEdiAdvJpMarkDesc(String blNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bl_no", blNo);
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24CustomsTransmissionDBDAOSearchEdiAdvJpMarkDescRSQL(), param, null, EdiAdvJpCommonVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1501_N] EDI Transmit
	 * BKG_CSTMS_ADV_JP_CNTR 정보 조회<br>
	 *
	 * @param String blNo
	 * @return List<EdiAdvJpCommonVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EdiAdvJpCommonVO> searchEdiAdvJpContainer_N(String blNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bl_no", blNo);
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24CustomsTransmissionDBDAOSearchEdiAdvJpContainer_N_RSQL(), param, null, EdiAdvJpCommonVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1501] EDI Transmit
	 * BKG_CSTMS_ADV_JP_CNTR 정보 조회<br>
	 *
	 * @param String blNo
	 * @return List<EdiAdvJpCommonVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EdiAdvJpCommonVO> searchEdiAdvJpContainer(String blNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bl_no", blNo);
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24CustomsTransmissionDBDAOSearchEdiAdvJpContainerRSQL(), param, null, EdiAdvJpCommonVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1501] EDI Transmit
	 * BKG_CNTR_SEAL_NO 정보 조회<br>
	 *
	 * @param String blNo
	 * @param String cntrNo
	 * @return List<EdiAdvJpCommonVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EdiAdvJpCommonVO> searchEdiAdvJpCntrSealNo(String blNo, String cntrNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bl_no", blNo);
			param.put("cntr_no", cntrNo);
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24CustomsTransmissionDBDAOSearchEdiAdvJpCntrSealNoRSQL(), param, null, EdiAdvJpCommonVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1501] EDI Transmit
	 * [ESM_BKG_1502] EDI Transmit
	 * [ESM_BKG_1503] EDI Transmit
	 * BKG_CSTMS_ADV_JP_SND_LOG 정보 신규 저장<br>
	 *
	 * @param AdvJpSendLogVO advJpSendLogVO
	 * @exception DAOException, Exception
	 */
	public void addAdvJpSendLog(AdvJpSendLogVO advJpSendLogVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (advJpSendLogVO != null) {
				Map<String, String> mapVO = advJpSendLogVO.getColumnValues();
				param.putAll(mapVO);
			}
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new Jp24CustomsTransmissionDBDAOAddAdvJpSendLogCSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1503] EDI Transmit
	 * BKG_CSTMS_ADV_JP_VSL_SKD 정보 조회<br>
	 *
	 * @param DepartureTimeVO departureTimeVO
	 * @return List<EdiAdvJpCommonVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EdiAdvJpCommonVO> searchEdiAdvJpVslSkd(DepartureTimeVO departureTimeVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (departureTimeVO != null) {
				Map<String, String> mapVO = departureTimeVO.getColumnValues();
				param.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24CustomsTransmissionDBDAOSearchEdiAdvJpVslSkdRSQL(), param, null, EdiAdvJpCommonVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1503] EDI Transmit
	 * BKG_CSTMS_ADV_JP_VSL_SKD의 전송Flag Update<br>
	 *
	 * @param DepartureTimeVO departureTimeVO
	 * @exception DAOException, Exception
	 */
	public void modifyTrnsFlagOfAdvJpVslSkd(DepartureTimeVO departureTimeVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (departureTimeVO != null) {
				Map<String, String> mapVO = departureTimeVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new Jp24CustomsTransmissionDBDAOModifyTrnsFlagOfAdvJpVslSkdUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1503]
	 * Departure Time Registration 조회<br>
	 *
	 * @param DepartureTimeVO departureTimeVO
	 * @return List<DepartureTimeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<DepartureTimeVO> searchDepartureTime(DepartureTimeVO departureTimeVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (departureTimeVO != null) {
				Map<String, String> mapVO = departureTimeVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24CustomsTransmissionDBDAOSearchDepartureTimeRSQL(), param, velParam, DepartureTimeVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1504]
	 * JMS Report 목록 조회<br>
	 *
	 * @param JmsReportVO jmsReportVO
	 * @return List<JmsReportVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JmsReportVO> searchJmsReport(JmsReportVO jmsReportVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (jmsReportVO != null) {
				Map<String, String> mapVO = jmsReportVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24CustomsTransmissionDBDAOSearchJmsReportRSQL(), param, velParam, JmsReportVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1505]
	 * Transmit Result Error Report 목록 조회 - SAMR/SCMR<br>
	 *
	 * @param ErrorReportVO errorReportVO
	 * @return List<ErrorReportVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ErrorReportVO> searchErrorReportForAmrCmr(ErrorReportVO errorReportVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (errorReportVO != null) {
				Map<String, String> mapVO = errorReportVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24CustomsTransmissionDBDAOSearchErrorReportForAmrCmrRSQL(), param, velParam, ErrorReportVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1505]
	 * Transmit Result Error Report 목록 조회 - SAS111<br>
	 *
	 * @param ErrorReportVO errorReportVO
	 * @return List<AdvJpReceiveLogVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AdvJpReceiveLogVO> searchErrorReportForSas111(ErrorReportVO errorReportVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (errorReportVO != null) {
				Map<String, String> mapVO = errorReportVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24CustomsTransmissionDBDAOSearchErrorReportForSas111RSQL(), param, velParam, AdvJpReceiveLogVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1505]
	 * Transmit Result Error Report 목록 조회 - SATD/etc.<br>
	 *
	 * @param ErrorReportVO errorReportVO
	 * @return List<ErrorReportVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ErrorReportVO> searchErrorReport(ErrorReportVO errorReportVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (errorReportVO != null) {
				Map<String, String> mapVO = errorReportVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24CustomsTransmissionDBDAOSearchErrorReportRSQL(), param, velParam, ErrorReportVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1506]
	 * Send FlatFile 조회<br>
	 *
	 * @param FlatFileVO flatFileVO
	 * @return List<FlatFileVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<FlatFileVO> searchSendFlatFile(FlatFileVO flatFileVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (flatFileVO != null) {
				Map<String, String> mapVO = flatFileVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24CustomsTransmissionDBDAOSearchSendFlatFileRSQL(), param, velParam, FlatFileVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [UDEV_OPUSBKG_T_JPN24]
	 * IB_CSSM_VOY_NO, CALL_SGN_NO로 VSL정보 조회<br>
	 *
	 * @param AdvJpReceiveLogVO advJpReceiveLogVO
	 * @return List<AdvJpReceiveLogVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AdvJpReceiveLogVO> getAdvJpVslByCssmVoy(AdvJpReceiveLogVO advJpReceiveLogVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (advJpReceiveLogVO != null) {
				Map<String, String> mapVO = advJpReceiveLogVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24CustomsTransmissionDBDAOGetAdvJpVslByCssmVoyRSQL(), param, velParam, AdvJpReceiveLogVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [UDEV_OPUSBKG_T_JPN24]
	 * IB_CSSM_VOY_NO, CALL_SGN_NO로 VSL정보 조회<br>
	 *
	 * @param AdvJpReceiveLogVO advJpReceiveLogVO
	 * @return List<AdvJpReceiveLogVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AdvJpReceiveLogVO> getAdvJpVslByCallsign(AdvJpReceiveLogVO advJpReceiveLogVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (advJpReceiveLogVO != null) {
				Map<String, String> mapVO = advJpReceiveLogVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24CustomsTransmissionDBDAOGetAdvJpVslByCallsignRSQL(), param, velParam, AdvJpReceiveLogVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [UDEV_OPUSBKG_T_JPN24]
	 * BKG_CSTMS_ADV_JP_RCV_LOG 정보 신규 저장<br>
	 *
	 * @param List<AdvJpReceiveLogVO> advJpReceiveLogVOList
	 * @exception DAOException, Exception
	 */
	public void addAdvJpReceiveLog(List<AdvJpReceiveLogVO> advJpReceiveLogVOList) throws DAOException, Exception {
		try {
			if (advJpReceiveLogVOList.size() > 0) {
				int insCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new Jp24CustomsTransmissionDBDAOAddAdvJpReceiveLogCSQL(), advJpReceiveLogVOList, null);
				for(int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [UDEV_OPUSBKG_T_JPN24]
	 * BKG_CSTMS_ADV_JP_RCV_LOG 테이블의 JP_BAT_NO 수정 저장<br>
	 *
	 * @param AdvJpReceiveLogVO advJpReceiveLogVO
	 * @exception DAOException, Exception
	 */
	public void modifyJpBatNoOfAdvJpReceiveLog(AdvJpReceiveLogVO advJpReceiveLogVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (advJpReceiveLogVO != null) {
				Map<String, String> mapVO = advJpReceiveLogVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new Jp24CustomsTransmissionDBDAOModifyJpBatNoOfAdvJpReceiveLogUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * EDI 송수신시 전송할 E-mail 주소 조회<br>
	 *
	 * @param CstmsEmlListVO cstmsEmlListVO
	 * @return List<CstmsEmlListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CstmsEmlListVO> searchCstmsEmlList(CstmsEmlListVO cstmsEmlListVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (cstmsEmlListVO != null) {
				Map<String, String> mapVO = cstmsEmlListVO.getColumnValues();
				param.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24CustomsTransmissionDBDAOSearchCstmsEmlListRSQL(), param, null, CstmsEmlListVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * BL_NO로 ADV_JP_SND_LOG 조회<br>
	 *
	 * @param String blNo
	 * @return List<AdvJpSendLogVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AdvJpSendLogVO> searchAdvJpSndLogByBlNo(String blNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("bl_no", blNo);
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24CustomsTransmissionDBDAOSearchAdvJpSndLogByBlNoRSQL(), param, null, AdvJpSendLogVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * BL_NO로 BKG_VVD 조회<br>
	 *
	 * @param String blNo
	 * @return List<AdvJpSendLogVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AdvJpSendLogVO> searchBkgVvdByBlNo(String blNo) throws DAOException {
			Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("bl_no", blNo);
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24CustomsTransmissionDBDAOSearchBkgVvdByBlNoRSQL(), param, null, AdvJpSendLogVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * EDI_REF_ID로 ADV_JP_SND_LOG 조회<br>
	 *
	 * @param String ediRefId
	 * @return List<AdvJpSendLogVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AdvJpSendLogVO> searchAdvJpSndLogByEdiRefId(String ediRefId) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("edi_ref_id", ediRefId);
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24CustomsTransmissionDBDAOSearchAdvJpSndLogByEdiRefIdRSQL(), param, null, AdvJpSendLogVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [BATCH] NoResponseForJp24
	 * BKG_CSTMS_ADV_JP_SND_LOG 테이블의 CSTMS_RQST_FLG 수정 저장<br>
	 *
	 * @param AdvJpReceiveLogVO advJpReceiveLogVO
	 * @exception DAOException, Exception
	 */
	public void modifyRqstFlgOfAdvJpSndLog(AdvJpReceiveLogVO advJpReceiveLogVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (advJpReceiveLogVO != null) {
				Map<String, String> mapVO = advJpReceiveLogVO.getColumnValues();
				param.putAll(mapVO);
			}
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new Jp24CustomsTransmissionDBDAOModifyRqstFlgOfAdvJpSndLogUSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


}
