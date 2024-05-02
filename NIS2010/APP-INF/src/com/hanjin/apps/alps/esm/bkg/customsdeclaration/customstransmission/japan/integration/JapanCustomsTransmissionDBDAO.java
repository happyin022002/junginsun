/*=========================================================
*Copyright(c) 2017 Hi-Plus Card
*@FileName : JapanCustomsTransmissionDAO.java
*@FileTitle : UI_BKG-0730
*Open Issues :
*Change history :
*	2017.09.07 하대성 2017 Renewal Version Transmit 반영
*@LastModifyDate : 2017.09.07
*@LastModifier : 하대성
*@LastVersion : 1.0
* 2009.04.21 김승민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanReceiveLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.basic.JapanCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListBlCntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListBlCustInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListBlGeneralInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListBlMarkDescInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListEmptyBlCntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListEmptyBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListSendHeaderInfoForDmfVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListSendHeaderInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListVesselArrivalDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanTransmitBlKeyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration.JapanManifestListDownloadDBDAOsearchEtaRSQL;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration.JapanManifestListDownloadDBDAOsearchJpcusEtaRSQL;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration.JapanmanifestListDownloadDBDAOsearchVslCallsignRSQL;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListJpcusEtaInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration.CargoReleaseOrderDBDAOModifyKorDoSelfTransFlgUSQL;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.BkgCstmsJpRcvLogDtlVO;
import com.hanjin.syscommon.common.table.BkgCstmsJpRcvLogVO;
import com.hanjin.syscommon.common.table.BkgCstmsJpSndLogDtlVO;
import com.hanjin.syscommon.common.table.BkgCstmsJpSndLogVO;

/**
 * ALPS JapanCustomsTransmissionDAO <br>
 * - ALPS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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
	 * @return List<JapanManifestListJpcusEtaInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<JapanManifestListJpcusEtaInfoVO> searchJpcusEta(JapanManifestTransmitVO japanManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListJpcusEtaInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (japanManifestTransmitVO != null) {
				Map<String, String> mapVO = japanManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}	
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanManifestListDownloadDBDAOsearchJpcusEtaRSQL(),param, null, true);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
					JapanManifestListJpcusEtaInfoVO.class);
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
	 * Vessel Call Sign 번호를 조회한다.<br>
	 * 
	 * @param String inVslCd
	 * @return String callSgnNo
	 * @throws DAOException
	 */
	public String searchVslCallsign (
			String inVslCd) throws DAOException {
		DBRowSet dbRowset = null;
		String callSgnNo = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
 			param.put("in_vsl_cd", inVslCd);
 			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanmanifestListDownloadDBDAOsearchVslCallsignRSQL(),param, velParam, true);
			 if (dbRowset.next()) {
				 callSgnNo = dbRowset.getString(1);
			 } else {
				 callSgnNo = "";					 
			 }			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return callSgnNo;
	}	
	
	/**
	 * DMF 메시지가 기존에 전송된 적이 있는 지 여부를 확인한다.<br>
	 * 
	 * @param JapanManifestTransmitVO japanManifestTransmitVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchDmfSendLog (JapanManifestTransmitVO japanManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		int logCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (japanManifestTransmitVO != null) {
				Map<String, String> mapVO = japanManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
 			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchDmfSendLogRSQL(),param, velParam, true);
			 if (dbRowset.next()) {
				 logCount = dbRowset.getInt(1);
			 } else {
				 logCount = 0;					 
			 }			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return logCount;
	}	
	
	/**
	 * 일본세관 신고용 Manifest Estimated Vessel Arrival Date 를 조회한다.<br>
	 * 
	 * @param JapanManifestTransmitVO japanManifestTransmitVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchEta(JapanManifestTransmitVO japanManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		String etaDt = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (japanManifestTransmitVO != null) {
				Map<String, String> mapVO = japanManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}	
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanManifestListDownloadDBDAOsearchEtaRSQL(),param, null, true);
			 if (dbRowset.next()) {
				 etaDt = dbRowset.getString(1);
			 } else {
				 etaDt = "";					 
			 }	
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return etaDt;
	}	
	
	/**
	 * 일본세관 신고용 Manifest Empty Indicator 를 조회한다.<br>
	 * 
	 * @param JapanTransmitBlKeyVO blKeyVO
	 * @return String mtyBkgFlg
	 * @throws DAOException
	 */
	public String searchEmptyInd (
			JapanTransmitBlKeyVO blKeyVO) throws DAOException {
		DBRowSet dbRowset = null;
		String mtyBkgFlg = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (blKeyVO != null) {
				Map<String, String> mapVO = blKeyVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO); 
			}
 			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchEmptyIndRSQL(),param, velParam, true);
			 if (dbRowset.next()) {
				 mtyBkgFlg = dbRowset.getString(1);
			 } else {
				 mtyBkgFlg = "";					 
			 }			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return mtyBkgFlg;
	}	
	
	/**
	 * 일본세관 신고용 Manifest Empty B/L 정보를 조회한다.<br>
	 * 
	 * @param JapanTransmitBlKeyVO blKeyVO
	 * @return List<JapanManifestListEmptyBlInfoVO>
	 * @throws DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<JapanManifestListEmptyBlInfoVO> searchEmptyBl(JapanTransmitBlKeyVO blKeyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListEmptyBlInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (blKeyVO != null) {
				Map<String, String> mapVO = blKeyVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}	
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchEmptyBlRSQL(),param, null, true);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
					JapanManifestListEmptyBlInfoVO.class);
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
	 * 일본세관 신고용 Manifest Empty B/L 정보를 조회한다.(Renewal2017)<br>
	 * 
	 * @param JapanTransmitBlKeyVO blKeyVO
	 * @return List<JapanManifestListEmptyBlInfoVO>
	 * @throws DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<JapanManifestListEmptyBlInfoVO> searchEmptyBlRenewal2017(JapanTransmitBlKeyVO blKeyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListEmptyBlInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (blKeyVO != null) {
				Map<String, String> mapVO = blKeyVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}	
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchEmptyBlRenewal2017RSQL(),param, null, true);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
					JapanManifestListEmptyBlInfoVO.class);
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
	 * 일본세관 신고용 Manifest Empty B/L Container 정보를 조회한다.<br>
	 * 
	 * @param JapanTransmitBlKeyVO blKeyVO
	 * @return List<JapanManifestListEmptyBlCntrInfoVO>
	 * @throws DAOException
	 */		
	@SuppressWarnings("unchecked")
	public List<JapanManifestListEmptyBlCntrInfoVO> searchEmptyBlCntr(JapanTransmitBlKeyVO blKeyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListEmptyBlCntrInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (blKeyVO != null) {
				Map<String, String> mapVO = blKeyVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}	
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchEmptyBlCntrRSQL(),param, null, true);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
					JapanManifestListEmptyBlCntrInfoVO.class);
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
	 * 일본세관 신고용 Manifest B/L General 정보를 조회한다.<br>
	 * 
	 * @param JapanTransmitBlKeyVO blKeyVO
	 * @return List<JapanManifestListBlGeneralInfoVO>
	 * @throws DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<JapanManifestListBlGeneralInfoVO> searchBlGeneral(JapanTransmitBlKeyVO blKeyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListBlGeneralInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (blKeyVO != null) {
				Map<String, String> mapVO = blKeyVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}	
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchBlGeneralRSQL(),param, null, true);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
					JapanManifestListBlGeneralInfoVO.class);
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
	 * 일본세관 신고용 Manifest B/L General 정보를 조회한다.(2017 Renewal)<br>
	 * 
	 * @param JapanTransmitBlKeyVO blKeyVO
	 * @return List<JapanManifestListBlGeneralInfoVO>
	 * @throws DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<JapanManifestListBlGeneralInfoVO> searchBlGeneralRenewal2017(JapanTransmitBlKeyVO blKeyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListBlGeneralInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (blKeyVO != null) {
				Map<String, String> mapVO = blKeyVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}	
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchBlGeneralRenewal2017RSQL(),param, null, true);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
					JapanManifestListBlGeneralInfoVO.class);
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
	 * 일본세관 신고용 Manifest B/L Customer 정보를 조회한다.<br>
	 * 
	 * @param JapanTransmitBlKeyVO blKeyVO
	 * @return List<JapanManifestListBlCustInfoVO>
	 * @throws DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<JapanManifestListBlCustInfoVO> searchBlCust(JapanTransmitBlKeyVO blKeyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListBlCustInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (blKeyVO != null) {
				Map<String, String> mapVO = blKeyVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}	
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchBlCustRSQL(),param, null, true);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
					JapanManifestListBlCustInfoVO.class);
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
	 * 일본세관 신고용 Manifest B/L Customer 정보를 조회한다.(2017 Renewal)<br>
	 * 
	 * @param JapanTransmitBlKeyVO blKeyVO
	 * @return List<JapanManifestListBlCustInfoVO>
	 * @throws DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<JapanManifestListBlCustInfoVO> searchBlCustRenewal2017(JapanTransmitBlKeyVO blKeyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListBlCustInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (blKeyVO != null) {
				Map<String, String> mapVO = blKeyVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}	
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchBlCustRenewal2017RSQL(),param, null, true);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
					JapanManifestListBlCustInfoVO.class);
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
	 * 일본세관 신고용 Manifest B/L Container 정보를 조회한다.<br>
	 * 
	 * @param JapanTransmitBlKeyVO blKeyVO
	 * @return List<JapanManifestListBlCntrInfoVO>
	 * @throws DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<JapanManifestListBlCntrInfoVO> searchBlCntr(JapanTransmitBlKeyVO blKeyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListBlCntrInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (blKeyVO != null) {
				Map<String, String> mapVO = blKeyVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}	
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchBlCntrRSQL(),param, null, true);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
					JapanManifestListBlCntrInfoVO.class);
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
	 * 일본세관 신고용 Manifest B/L Container 정보를 조회한다.(2017 Renewal)<br>
	 * 
	 * @param JapanTransmitBlKeyVO blKeyVO
	 * @return List<JapanManifestListBlCntrInfoVO>
	 * @throws DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<JapanManifestListBlCntrInfoVO> searchBlCntrRenewal2017(JapanTransmitBlKeyVO blKeyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListBlCntrInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (blKeyVO != null) {
				Map<String, String> mapVO = blKeyVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}	
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchBlCntrRenewal2017RSQL(),param, null, true);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
					JapanManifestListBlCntrInfoVO.class);
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
	 * 일본세관 신고용 Manifest B/L Mark Description 정보를 조회한다.<br>
	 * 
	 * @param JapanTransmitBlKeyVO blKeyVO
	 * @return List<JapanManifestListBlMarkDescInfoVO>
	 * @throws DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<JapanManifestListBlMarkDescInfoVO> searchBlMarkDesc(JapanTransmitBlKeyVO blKeyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListBlMarkDescInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (blKeyVO != null) {
				Map<String, String> mapVO = blKeyVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}	
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchBlMarkDescRSQL(),param, null, true);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
					JapanManifestListBlMarkDescInfoVO.class);
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
	 * 일본세관 신고용 Manifest B/L Mark Description 정보를 조회한다.(Renewal 2017)<br>
	 * 
	 * @param JapanTransmitBlKeyVO blKeyVO
	 * @return List<JapanManifestListBlMarkDescInfoVO>
	 * @throws DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<JapanManifestListBlMarkDescInfoVO> searchBlMarkDescRenewal2017(JapanTransmitBlKeyVO blKeyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListBlMarkDescInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (blKeyVO != null) {
				Map<String, String> mapVO = blKeyVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}	
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchBlMarkDescRenewal2017RSQL(),param, null, true);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
					JapanManifestListBlMarkDescInfoVO.class);
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
	 * 일본세관 신고용 Manifest B/L Mark Description 정보를 조회한다.<br>
	 * 
	 * @param String mark
	 * @param String desc
	 * @return List<JapanManifestListBlMarkDescInfoVO>
	 * @throws DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<JapanManifestListBlMarkDescInfoVO> searchBlMarkDesc(String mark, String desc) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListBlMarkDescInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
 			param.put("mark", mark);	
 			param.put("desc", desc);	
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchBlMarkDesc2RSQL(),param, velParam, true);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
					JapanManifestListBlMarkDescInfoVO.class);
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
	@SuppressWarnings("unchecked")
	public List<JapanManifestListSendHeaderInfoVO> searchSendHeader(
			String inVvdCd, 
			String inPodCd,
			String ofcCd, 
			String usrId,
			String inMsgTp, 
			String dateData,
			String strLength,
			String blNo
			) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListSendHeaderInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
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
 			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchSendHeaderRSQL(),param, velParam, true);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
					JapanManifestListSendHeaderInfoVO.class);
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
	 * 일본세관 신고용 Header 정보를 조회한다.(Renewal2017)<br>
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
	@SuppressWarnings("unchecked")
	public List<JapanManifestListSendHeaderInfoVO> searchSendHeaderRenewal2017(
			String inVvdCd, 
			String inPodCd,
			String ofcCd, 
			String usrId,
			String inMsgTp, 
			String dateData,
			String strLength,
			String blNo
			) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListSendHeaderInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
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
 			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchSendHeaderRenewal2017RSQL(),param, velParam, true);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
					JapanManifestListSendHeaderInfoVO.class);
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
	@SuppressWarnings("unchecked")
	public List<JapanManifestListSendHeaderInfoForDmfVO> searchSendHeaderForDmf(
			String inVvdCd, 
			String inPodCd,
			String ofcCd, 
			String usrId,
			String vesselInfo,
			String sendDt) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListSendHeaderInfoForDmfVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
 			param.put("in_vvd_cd", inVvdCd);	
 			param.put("in_pod_cd", inPodCd);	
 			param.put("ofc_cd", ofcCd);
 			param.put("usr_id", usrId);
 			param.put("vessel_info", vesselInfo);
 			param.put("send_dt", sendDt);
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchSendHeaderForDmfRSQL(),param, velParam, true);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
					JapanManifestListSendHeaderInfoForDmfVO.class);
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
	 * 일본세관 신고용 Manifest Vessel Arrival 정보를 조회한다.<br>
	 * 
	 * @param String inVvdCd
	 * @param String inPodcd
	 * @param String inPodCdSplit
	 * @param String inEtaDt
	 * @return List<JapanManifestListSendHeaderInfoVO>
	 * @throws DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<JapanManifestListVesselArrivalDetailVO> searchVesselArrival(
			String inVvdCd, 
			String inPodcd, 
			String inPodCdSplit, 
			String inEtaDt
			) throws DAOException {
		DBRowSet dbRowset = null;
		List<JapanManifestListVesselArrivalDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
 			param.put("in_vvd_cd", inVvdCd);	
 			param.put("in_pod_cd", inPodcd);
 			param.put("in_pod_cd_split", inPodCdSplit);
 			param.put("in_eta_dt", inEtaDt);	
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchVesselArrivalRSQL(),param, velParam, true);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
					JapanManifestListVesselArrivalDetailVO.class);
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
	 * 일본세관 신고용 Send Log 테이블 Seq를 조회한다.<br>
	 * 
	 * @param String sndDt
	 * @return int seqNumber
	 * @throws DAOException
	 */
	public int searchSendLogSeq(String sndDt) throws DAOException {
		DBRowSet dbRowset = null;
		int seqNumber = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
 			param.put("snd_dt", sndDt);
 			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchSendLogSeqRSQL(),param, velParam, true);
			 if (dbRowset.next()) {
				 seqNumber = dbRowset.getInt(1);
			 } else {
				 seqNumber = 0;					 
			 }			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return seqNumber;
	}	
	
	/**
	 * 일본세관 신고용 Receive Log 테이블 Seq를 조회한다.<br>
	 * 
	 * @param String jpMsgTpCd
	 * @param String rcvDt
	 * @return int seqNumber
	 * @throws DAOException
	 */
	public int searchReceiveLogSeq(
			String jpMsgTpCd, 
			String rcvDt) throws DAOException {
		DBRowSet dbRowset = null;
		int seqNumber = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("jp_msg_tp_cd", jpMsgTpCd);
			param.put("rcv_dt", rcvDt);
 			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchReceiveLogSeqRSQL(),param, velParam, true);
			 if (dbRowset.next()) {
				 seqNumber = dbRowset.getInt(1);
			 } else {
				 seqNumber = 0;					 
			 }			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return seqNumber;
	}		
	
	/**
	 * 일본세관에 전송할 Manifest Detail 정보를 조회한다.<br>
	 * 
	 * @param String jpSndLogId
	 * @param String msgSndDt
	 * @param String ofcCd
	 * @param String logSeq
	 * @param String blNo
	 * @return String corrNo
	 * @throws DAOException
	 */
	public String searchDetailInfo(
			String jpSndLogId,
			String msgSndDt,
			String ofcCd,
			String logSeq,
			String blNo) throws DAOException {
		DBRowSet dbRowset = null;
		StringBuffer corrNo = new StringBuffer();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
 			param.put("jp_snd_log_id", jpSndLogId);
 			param.put("msg_snd_dt", msgSndDt);
 			param.put("ofc_cd", ofcCd);
 			param.put("log_seq", logSeq);
 			param.put("bl_no", blNo);

			velParam.putAll(param);
 			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchDetailInfoRSQL(),param, velParam, true);
			while(dbRowset.next()) 
			{
				corrNo.append(dbRowset.getString(1));
			}		
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return corrNo.toString();
	}	
	
	
	
	/**
	 * 일본세관에 전송한 Send Log의 Send Date를 업데이트한다.<br>
	 * 
	 * @param BkgCstmsJpSndLogVO bkgCstmsJpSndLogVO
	 * @throws DAOException
	 */
	public void modifySendLog(BkgCstmsJpSndLogVO bkgCstmsJpSndLogVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = bkgCstmsJpSndLogVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
		
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new JapanCustomsTransmissionDBDAOmodifySendLogUSQL(), param, velParam, true);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modify SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * 일본세관 Manifest 전송 로그(Detail)를 생성한다.<br>
	 * 
	 * @param BkgCstmsJpSndLogDtlVO bkgCstmsJpSndLogDtlVO
	 * @return int
	 * @throws DAOException
	 */
	public int addSendLogDetail(BkgCstmsJpSndLogDtlVO bkgCstmsJpSndLogDtlVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = bkgCstmsJpSndLogDtlVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);		
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new JapanCustomsTransmissionDBDAOaddSendLogDetailCSQL(), param, velParam, true);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * 일본세관 Manifest 전송 로그를 생성한다.<br>
	 * 
	 * @param BkgCstmsJpSndLogVO bkgCstmsJpSndLogVO
	 * @throws DAOException
	 */
	public void addSendLog(BkgCstmsJpSndLogVO bkgCstmsJpSndLogVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = bkgCstmsJpSndLogVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);		
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new JapanCustomsTransmissionDBDAOaddSendLogCSQL(), param, velParam, true);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * 일본세관 Manifest 수신 로그를 생성한다.<br>
	 * 
	 * @param BkgCstmsJpRcvLogVO bkgCstmsJpRcvLogVO
	 * @throws DAOException
	 */
	public void addReceiveLog(BkgCstmsJpRcvLogVO bkgCstmsJpRcvLogVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = bkgCstmsJpRcvLogVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);		
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new JapanCustomsTransmissionDBDAOaddReceiveLogCSQL(), param, velParam, true);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * 일본세관 Manifest 수신 로그(Detail)를 생성한다.<br>
	 * 
	 * @param BkgCstmsJpRcvLogDtlVO bkgCstmsJpRcvLogDtlVO
	 * @throws DAOException
	 */
	public void addReceiveLogDetail(BkgCstmsJpRcvLogDtlVO bkgCstmsJpRcvLogDtlVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = bkgCstmsJpRcvLogDtlVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);		
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new JapanCustomsTransmissionDBDAOaddReceiveLogDetailCSQL(), param, velParam, true);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * EDI수신 한 사항을 Update한다.<br>
	 * msg_tp == "VCA" or msg_tp == "DOR" or msg_tp == "ICN" 인 경우
	 * @param String msgTp
	 * @param String updDt
	 * @param String ofcCd
	 * @param String updUsrId
	 * @throws DAOException
	 * @author Son Yun Seuk
	 */
	public void modifySysAckSts(String msgTp, String updDt, String ofcCd, String updUsrId) throws DAOException , Exception
	{
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		
		try 
		{
			param.put("msg_tp", msgTp);
			param.put("upd_dt", updDt);
			param.put("ofc_cd", ofcCd);
			param.put("upd_usr_id", updUsrId);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new JapanCustomsTransmissionDBDAOmodifySysAckStsUSQL(), param, null, true);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * EDI수신 한 사항을 Update한다.<br>
	 * msg_tp != "DOR" 이고 log_seq값이 존재하는 경우
	 * @param String msgTp
	 * @param String logSeq
	 * @param String updDt
	 * @param String ofcCd
	 * @param String updUsrId
	 * @param String vslCd
	 * @throws DAOException
	 * @author Son Yun Seuk
	 */
	public void modifySysAckStsForSeq(String msgTp, String logSeq, String updDt, String ofcCd, String updUsrId, String vslCd) throws DAOException , Exception
	{
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		
		try 
		{
			param.put("msg_tp", msgTp);
			param.put("upd_dt", updDt);
			param.put("ofc_cd", ofcCd);
			param.put("upd_usr_id", updUsrId);
			param.put("vsl_cd", vslCd);
			param.put("log_seq", logSeq);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new JapanCustomsTransmissionDBDAOmodifySysAckStsForSeqUSQL(), param, null, true);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * EDI수신 한 사항을 Update한다.<br>
	 * else 의 경우
	 * @param String msgTp
	 * @param String updDt
	 * @param String ofcCd
	 * @param String updUsrId
	 * @param String vslCd
	 * @throws DAOException
	 * @author Son Yun Seuk
	 */
	public void modifySysAckStsForVDI(String msgTp, String updDt, String ofcCd, String updUsrId, String vslCd) throws DAOException, Exception
	{
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		
		try 
		{
			param.put("msg_tp", msgTp);
			param.put("upd_dt", updDt);
			param.put("ofc_cd", ofcCd);
			param.put("upd_usr_id", updUsrId);
			param.put("vsl_cd", vslCd);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new JapanCustomsTransmissionDBDAOmodifySysAckStsForVDIUSQL(), param, null, true);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 일본세관으로부터 수신한 Manifest 내용을 업데이트한다.<br>
	 * 
	 * @param JapanReceiveLogVO japanReceiveLogVO
	 * @return int result
	 * @throws DAOException 
	 */
	public int modifyReceiveLog(JapanReceiveLogVO japanReceiveLogVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = japanReceiveLogVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);	
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new JapanCustomsTransmissionDBDAOmodifyReceiveLogUSQL(), param, velParam, true);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * 일본세관에 전송할 POD 정보를 조회한다.<br>
	 * 
	 * @param String inPodCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchJapanPODInfo(String inPodCd) throws DAOException {
		DBRowSet dbRowset = null;
		String japanPod = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
 			param.put("in_pod_cd", inPodCd);
 			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanCustomsTransmissionDBDAOsearchJapanPODInfoRSQL(),param, null, true);
			while(dbRowset.next()) 
			{
				japanPod = dbRowset.getString(1);
			}		
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return japanPod;
	}	

	
}
