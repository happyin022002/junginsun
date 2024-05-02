/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UsaInbondTransmissionDAO.java
 *@FileTitle : Generate Arrival Manifest by Container
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.22
 *@LastModifier : 이수빈
 *@LastVersion : 1.0
 * 2009.04.22 이수빈
 * 1.0 Creation
 * --------------------------------------------------
 * History
 * 2012.04.24 민정호 [] Port code assignment for NY/NJ 
 * 2012.04.24 민정호 [CHM-201216602] Rail AMS 수신시 hold / hold release 관련 보완 (ACE 관련)
 * 2012.05.10 김보배 [CHM-201217461] [BKG] [ACE M1] US AMS 전송후 1J 이후 Diversion 요청 기능 추가
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration.UsaCustomsTransmissionDBDAOaddCarrierBatchNoCSQL;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration.UsaCustomsTransmissionDBDAOsearchAmsCodeRSQL;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration.UsaCustomsTransmissionDBDAOsearchCarrierBatchNumberRSQL;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration.UsaCustomsTransmissionDBDAOsearchCstmsPortCdRSQL;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration.UsaCustomsTransmissionDBDAOsearchCstmsPortCd2RSQL;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration.UsaCustomsTransmissionDBDAOsearchHiHeader1RSQL;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration.UsaCustomsTransmissionDBDAOsearchMdmVslCntrRSQL;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration.UsaCustomsTransmissionDBDAOsearchMiEtaRSQL;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration.UsaCustomsTransmissionDBDAOsearchSndLogCountRSQL;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration.UsaCustomsTransmissionDBDAOsearchSndLogNextHisSeqRSQL;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration.UsaCustomsTransmissionDBDAOselectSysdateRSQL;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.EtaCondAtAdvancedVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.EtaDetailAtAdvancedVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaMiCountVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaTrsmFirstHeadVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.SendingLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.basic.UsaInbondTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.ClearanceTypeCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.ClearanceTypeDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.LclMibCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.UsaArrHeaderCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.UsaInbondManifestDetailListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.UsaInbondManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.UsaInbondManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.vo.InbondManifestDetailVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MdmVslCntrVO;

/**
 * ALPS UsaInbondTransmissionDAO <br>
 * - ALPS-InbondTransmission system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Dowan
 * @see UsaInbondTransmissionBCImpl 참조
 * @since J2EE 1.4
 */
public class UsaInbondTransmissionDBDAO extends DBDAOSupport {

	/**
	 * 0533 화면 상단 시트 조회구현.<br>
	 * 
	 * @param UsaInbondManifestListCondVO
	 *            usaInbondManifestListCondVO
	 * @return List<UsaInbondManifestListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UsaInbondManifestListVO> searchInbondArrivalManifestList(UsaInbondManifestListCondVO usaInbondManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaInbondManifestListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (usaInbondManifestListCondVO != null) {
				Map<String, String> mapVO = usaInbondManifestListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UsaInbondTransmissionDBDAOsearchInbondArrivalManifestListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaInbondManifestListVO.class);
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
	 * US BL 갯수를 리턴한다..<br>
	 * 
	 * @param String blNo
	 * @return int
	 * @exception DAOException
	 */
	public int searchUsBlCnt(String blNo) throws DAOException {
		int retVal = 0;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UsaInbondTransmissionDBDAOsearchUsBlCntRSQL(), param, velParam);

			if (dbRowset.getRowCount() > 0) {

				if (dbRowset.next()) {
					retVal = dbRowset.getInt(1);
				}

			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVal;
	}

	/**
	 * Diversion Arrival H01 정보를 조회한다.<br>
	 * 
	 * @param String blNo
	 * @param String irsNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchH01ForDiversion(String blNo, String irsNo) throws DAOException {
		String retVal = "";

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			param.put("irs_no", irsNo);
			velParam.put("irs_no", irsNo);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UsaInbondTransmissionDBDAOsearchH01ForDiversionRSQL(), param, velParam);

			if (dbRowset.getRowCount() > 0) {
				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVal;
	}

	/**
	 * Paperless MIB Generate 상단 시트 조회.<br>
	 * 
	 * @param UsaInbondManifestListCondVO
	 *            usaInbondManifestListCondVO
	 * @return List<UsaInbondManifestListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UsaInbondManifestListVO> searchMibManifestList(UsaInbondManifestListCondVO usaInbondManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaInbondManifestListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (usaInbondManifestListCondVO != null) {
				Map<String, String> mapVO = usaInbondManifestListCondVO.getColumnValues();

				param.putAll(mapVO);

				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UsaInbondTransmissionDBDAOsearchInbondManifestMIBSummaryRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaInbondManifestListVO.class);
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
	 * Paperless MIB Generate 에서 해당 VVD, POD, HUB, DEL에 대해 Partial BL이 존재하는 지 여부
	 * 조회.<br>
	 * 
	 * @param LclMibCondVO
	 *            lclMibCondVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchLclMibFlag(LclMibCondVO lclMibCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		String retVal = "N";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (lclMibCondVO != null) {
				Map<String, String> mapVO = lclMibCondVO.getColumnValues();

				param.putAll(mapVO);

				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new UsaInbondTransmissionDBDAOsearchLclMibFlagRSQL(), param, velParam);
			if (dbRowset.getRowCount() > 0) {

				if (dbRowset.next()) {
					// retVal = dbRowset.getString(1);
					retVal = "Y";
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVal;
	}

	/**
	 * Paperless MIB Generate 하단 시트 조회.<br>
	 * 
	 * @param UsaInbondManifestListVO
	 *            usaInbondManifestListVO
	 * @return List<UsaInbondManifestDetailListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UsaInbondManifestDetailListVO> searchInbondManifestDeatilList(UsaInbondManifestListVO usaInbondManifestListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaInbondManifestDetailListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (usaInbondManifestListVO != null) {
				Map<String, String> mapVO = usaInbondManifestListVO.getColumnValues();

				param.putAll(mapVO);

				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UsaInbondTransmissionDBDAOsearchInbondManifestDeatilListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaInbondManifestDetailListVO.class);
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
	 * USA Inbound화주의 Customs Clearance Type을 조회<br>
	 * 
	 * @param ClearanceTypeCondVO
	 *            clearanceTypeCondVO
	 * @return List<InbondManifestDetailVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InbondManifestDetailVO> searchClearanceTypebySc(ClearanceTypeCondVO clearanceTypeCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InbondManifestDetailVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (clearanceTypeCondVO != null) {
				Map<String, String> mapVO = clearanceTypeCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UsaInbondTransmissionDBDAOsearchClearanceTypebyScRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ClearanceTypeDetailVO.class);
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
	 * USA Inbound화주의 Customs Clearance Type을 수정<br>
	 * 
	 * @param ClearanceTypeDetailVO
	 *            clearanceTypeDetailVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyClearanceTypebySc(ClearanceTypeDetailVO clearanceTypeDetailVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = clearanceTypeDetailVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new UsaInbondTransmissionDBDAOmodifyClearanceTypebyScUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * Mdm Commodity Name 조회<br>
	 * 
	 * @param String cmdtCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchCommodity(String cmdtCd) throws DAOException {
		DBRowSet dbRowset = null;
		String result = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("cmdt_cd", cmdtCd);
			velParam.put("cmdt_cd", cmdtCd);

			SQLExecuter sqlExe = new SQLExecuter("");
			dbRowset = sqlExe.executeQuery((ISQLTemplate) new UsaInbondTransmissionDBDAOsearchCommodityRSQL(), param, velParam);
			if (dbRowset.next()) {
				result = dbRowset.getString(1);
			}
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * Advanced Table로 부터 ETA 정보를 조회한다.
	 * 
	 * @param EtaCondAtAdvancedVO
	 *            etaCondAtAdvancedVO
	 * @return EtaDetailAtAdvancedVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public EtaDetailAtAdvancedVO searchEtaFromAdvanced(EtaCondAtAdvancedVO etaCondAtAdvancedVO) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<EtaDetailAtAdvancedVO> list = null;
		EtaDetailAtAdvancedVO retVo = null;

		try {
			Map<String, String> mapVO = etaCondAtAdvancedVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchMiEtaRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EtaDetailAtAdvancedVO.class);
			if (list != null && list.size() > 0)
				retVo = list.get(0);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVo;
	}

	/**
	 * Vsl_cd가 등록된 Loc_Cd 의 AMS_PORT_CD 정보를 조회한다.
	 * 
	 * @param String locCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchPodAmsCode(String locCd) throws DAOException {
		String retVal = "";

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("loc_cd", locCd);
			velParam.put("loc_cd", locCd);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchAmsCodeRSQL(), param, velParam);

			if (dbRowset.getRowCount() > 0) {

				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}

			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVal;
	}

	/**
	 * BKG_CSTMS_ADV_SND_LOG.의 LOG SEQ를 구한다.
	 * 
	 * @param String cntCd
	 * @param String ioBndCd
	 * @param String sndDt
	 * @param String trsmMsgTpId
	 * @return String
	 * @throws DAOException
	 */
	public String searchSndLogNextHisSeq(String cntCd, String ioBndCd, String sndDt, String trsmMsgTpId) throws DAOException {
		String retVal = "";

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("cnt_cd", cntCd);
			velParam.put("cnt_cd", cntCd);
			param.put("io_bnd_cd", ioBndCd);
			velParam.put("io_bnd_cd", ioBndCd);
			param.put("snd_dt", sndDt);
			velParam.put("snd_dt", sndDt);
			param.put("trsm_msg_tp_id", trsmMsgTpId);
			velParam.put("trsm_msg_tp_id", trsmMsgTpId);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchSndLogNextHisSeqRSQL(), param, velParam);

			if (dbRowset.getRowCount() > 0) {

				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}

			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVal;
	}

	/**
	 * Sysdate 를 조회한다.
	 * 
	 * @param String format
	 * @return String
	 * @throws DAOException
	 */
	public String searchSysdate(String format) throws DAOException {
		String retVal = "";

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("format", format);
			velParam.put("format", format);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UsaCustomsTransmissionDBDAOselectSysdateRSQL(), param, velParam);

			if (dbRowset.getRowCount() > 0) {

				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}

			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVal;
	}

	/**
	 * MI/HI/TI/AI의 공통 첫번째 헤더를 조회한다.
	 * 
	 * @param UsaTrsmFirstHeadVO
	 *            usaTrsmFirstHeadVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchTrsmFirstHeader(UsaTrsmFirstHeadVO usaTrsmFirstHeadVO) throws DAOException {
		String retVal = "";

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = usaTrsmFirstHeadVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchHiHeader1RSQL(), param, velParam);

			if (dbRowset.getRowCount() > 0) {

				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}

			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVal;
	}

	/**
	 * MDM_VSL_CNTR 정보를 조회한다.
	 * 
	 * @param String vvd
	 * @return MdmVslCntrVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public MdmVslCntrVO searchVslInfo(String vvd) throws DAOException {

		// CntrLineInfoVO
		List<MdmVslCntrVO> list = null;
		MdmVslCntrVO mdmVslCntrVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			param.put("vvd", vvd);
			velParam.put("vvd", vvd);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchMdmVslCntrRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MdmVslCntrVO.class);
			if (list != null && list.size() > 0) {
				mdmVslCntrVO = list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return mdmVslCntrVO;
	}

	/**
	 * bkg_cstms_adv_snd_log.crr_bat_no 를 Setup 하기 위해 새로운 번호를 조회한다.
	 * 
	 * @return String
	 * @throws DAOException
	 */
	public String searchCarrierBatchNo() throws DAOException {
		String retVal = "";

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchCarrierBatchNumberRSQL(), param, velParam);

			if (dbRowset.getRowCount() > 0) {

				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}

			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVal;
	}

	/**
	 * BKG_CSTMS_ADV_EDI_BL_RSPN 테이블에 CRR_BAT_NO 등을 삽입한다.<br>
	 * 
	 * @param SendingLogVO
	 *            sendingLogVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addCarrierBatchNo(SendingLogVO sendingLogVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			Map<String, String> mapVO = sendingLogVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new UsaCustomsTransmissionDBDAOaddCarrierBatchNoCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

			return result;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * hub수정권한을 조회한다.
	 * 
	 * @param String usrId
	 * @return String
	 * @throws DAOException
	 */
	public String[] searchUserAuthInfoForHub(String usrId) throws DAOException {
		String[] retVal = new String[2];

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("usr_id", usrId);
			velParam.put("usr_id", usrId);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UsaInbondTransmissionDBDAOsearchUserAuthInfoForHubRSQL(), param, velParam);

			if (dbRowset.next()) {
				retVal[0] = JSPUtil.getNull(dbRowset.getString(1),"");
				retVal[1] = JSPUtil.getNull(dbRowset.getString(2),"");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVal;
	}

	/**
	 * vvd, pod 의 MI 전송횟수를 조회한다.
	 * 
	 * @param UsaMiCountVO usaMiCountVO
	 * @return int
	 * @throws DAOException
	 */
	public int checkMiTransCount(UsaMiCountVO usaMiCountVO) throws DAOException {
		int retVal = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = usaMiCountVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchSndLogCountRSQL(), param, velParam);
			if (dbRowset.next())
			{
				retVal = dbRowset.getInt(1);
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
		return retVal;
	}
	
	/**
	 * vvd, pol,pod 값으로 cstms_port_cd값을 조회한다.
	 * 
	 * @param String vvdCd
	 * @param String polCd
	 * @param String podCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchCstmsPortCd(String vvdCd, String polCd, String podCd) throws DAOException {
		String retVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			velParam.put("vvd_cd", vvdCd);
			param.put("vvd_cd", vvdCd);
			velParam.put("pol_cd", polCd);
			param.put("pol_cd", polCd);
			velParam.put("pod_cd", podCd);
			param.put("pod_cd", podCd);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchCstmsPortCdRSQL(), param, velParam);
			if (dbRowset.next()) {
				retVal = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return retVal;
	}
	
	
	/**
	 * vvd, pol,pod 값으로 AMS_TML_CD값을 조회한다.
	 * 
	 * @param String vvdCd
	 * @param String polCd
	 * @param String podCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchCstmsPortCd2(String vvdCd, String polCd, String podCd) throws DAOException {
		String retVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			velParam.put("vvd_cd", vvdCd);
			param.put("vvd_cd", vvdCd);
			velParam.put("pol_cd", polCd);
			param.put("pol_cd", polCd);
			velParam.put("pod_cd", podCd);
			param.put("pod_cd", podCd);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchCstmsPortCd2RSQL(), param, velParam);
			if (dbRowset.next()) {
				retVal = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return retVal;
	}	
}