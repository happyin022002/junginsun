/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UsaCustomsTransmissionDBDAO.java
 *@FileTitle : CustomsTransmission
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsBlByKeyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.AmsInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.BaplieAlarmSetupVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.BayPlanCntrDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.BayPlanCntrListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.BlLineInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.CmdMarkVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.CntrLineInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.CustLineInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.DgUnnoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.EmlNtfcBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.EtaCondAtAdvancedVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.EtaDetailAtAdvancedVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.HoldInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.Isf5InfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.OFMBlLineInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.OFMCntrLineVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.OfmHeaderVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.SendDetailLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.SendLogDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.StiCondListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.StiDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaCFlag1XChkVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaCMVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaContainerInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaCstmsManifestAmendmentCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaCstmsManifestAmendmentVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaCustomerInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaEDADetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaIsf5CondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaIsf5ResultVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaLocationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaManifestListCondForEdiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaMiCountVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaMiHiHeadFootCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaMiHiHeaderFooterVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaPartialBlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaRcvMsgVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaResultCntrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaTmlBlByVvdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaTransmitInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaTrsmFirstHeadVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.VesselEtaCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.VesselEtaInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.BlInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.BlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestAmendmentVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.SendingLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration.UsaManifestListDownloadDBDAOsearchUserAuthMiMultiYnRSQL;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestSearchDetailVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration.HoldNoticeDBDAOPrcExecEnisLogCSQL;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration.HoldNoticeDBDAOsearchHldNtcFlgRSQL;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.BkgCstmsAdvBlVO;
import com.clt.syscommon.common.table.BkgCstmsAdvCntrRsltVO;
import com.clt.syscommon.common.table.MdmVslCntrVO;


/**
 * OPUS UsaCustomsTransmissionDBDAO <br>
 * - OPUS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Kyoung Jong Yun
 * @see 상위 BCImpl 참조
 * @since J2EE 1.6
 */
public class UsaCustomsTransmissionDBDAO extends DBDAOSupport {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 헤더, footer 정보를 조회한다.<br>
	 *
	 * @param UsaMiHiHeadFootCondVO usaMiHiHeadFootCondVO
	 * @return UsaMiHiHeaderFooterVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public UsaMiHiHeaderFooterVO searchMiHiHeaderFooter(UsaMiHiHeadFootCondVO usaMiHiHeadFootCondVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (usaMiHiHeadFootCondVO != null) {
				Map<String, String> mapVO = usaMiHiHeadFootCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchMiHiHeaderFooterRSQL(), param, velParam);
			List<UsaMiHiHeaderFooterVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaMiHiHeaderFooterVO.class);
			return list.get(0);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Container 정보를 조회한다.
	 *
	 * @param String blNo
	 * @param String gubun
	 * @return List<UsaContainerInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<UsaContainerInfoVO> searchContainerInfo(String blNo, String gubun) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			if (gubun == null) gubun = "N";
			param.put("gubun", gubun);
			velParam.put("gubun", gubun);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchCntrLineRSQL(), param, velParam);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, UsaContainerInfoVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * HI H01 정보를 조회한다.
	 *
	 * @param String vpsEtdDt
	 * @param String polLoc
	 * @param String podAmsPortcd
	 * @param String vpsEtaDtA
	 * @param String fieldName
	 * @return String
	 * @throws DAOException
	 */
	public String searchH01(String vpsEtdDt, String polLoc, String podAmsPortcd, String vpsEtaDtA, String fieldName) throws DAOException {
		String retVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vpsEtdDt.length() == 10) {
				String vpsEtdDt2 = vpsEtdDt.substring(0,6);
				String vpsEtdDt3 = vpsEtdDt.substring(6,10);
				if (("H01".equals(fieldName) || "H02".equals(fieldName))  && "0000".equals(vpsEtdDt3)) {
					vpsEtdDt3 = "0001";
					vpsEtdDt = vpsEtdDt2 + vpsEtdDt3;
				}
			}
			param.put("vps_etd_dt", vpsEtdDt);
			velParam.put("vps_etd_dt", vpsEtdDt);
			param.put("pol_loc", polLoc);
			velParam.put("pol_loc", polLoc);
			param.put("pod_ams_port_cd", podAmsPortcd);
			velParam.put("pod_ams_port_cd", podAmsPortcd);
			param.put("vps_eta_dt_a", vpsEtaDtA);
			velParam.put("vps_eta_dt_a", vpsEtaDtA);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchH01RSQL(), param, velParam);
			if(dbRowset.getRowCount() > 0) if (dbRowset.next()) retVal = dbRowset.getString(fieldName);
			return retVal;

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Vsl_cd가 등록된 BKG_BOOKING로 부터 LANE 정보를 조회한다.
	 *
	 * @param String vvd
	 * @param String pod
	 * @param String msgTp
	 * @return String
	 * @throws DAOException
	 */
	public String searchBkgLane(String vvd, String pod, String msgTp) throws DAOException {
		String retVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (msgTp == null)
			{
				msgTp = "MI/HI";
			}
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
			param.put("pod", pod);
			velParam.put("pod", pod);
			param.put("msg_tp", msgTp);
			velParam.put("msg_tp", msgTp);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchBkgLaneRSQL(), param, velParam);
			if (dbRowset.next())
			{
				retVal = dbRowset.getString(1);
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
	 * Vsl_cd가 등록된 Loc_Cd 의 AMS_PORT_CD 정보를 조회한다.
	 *
	 * @param String vvd
	 * @param String blNo
	 * @param String locCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchAmsCodeByVvd(String vvd, String blNo, String locCd) throws DAOException {
		String retVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			param.put("loc_cd", locCd);
			velParam.put("loc_cd", locCd);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchAmsCodeByVvdRSQL(), param, velParam);
			if (dbRowset.next()) retVal = dbRowset.getString(1);
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return retVal;
	}

	/**
	 * Vsl_cd가 등록된 ETA 정보를 조회한다.
	 *
	 * @param String vvd
	 * @param String pod
	 * @param String formatGubun
	 * @return String
	 * @throws DAOException
	 */
	public String searchVslEta(String vvd, String pod, String formatGubun) throws DAOException {
		String retVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
			param.put("pod", pod);
			velParam.put("pod", pod);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchEtaRSQL(), param, velParam);
			if (dbRowset.next())
			{
				retVal = dbRowset.getString(formatGubun);
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
	 * Vsl_cd가 등록된 ETD 정보를 조회한다.
	 *
	 * @param String vvd
	 * @param String pol
	 * @param String formatGubun
	 * @return String
	 * @throws DAOException
	 */
	public String searchVslEtd(String vvd, String pol, String formatGubun) throws DAOException {
		String retVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
			param.put("pol", pol);
			velParam.put("pol", pol);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchEtdRSQL(), param, velParam);
			if (dbRowset.next())
			{
				retVal = dbRowset.getString(formatGubun);
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
	 * pol_last_loc, pol_last_ams 정보를 조회한다.
	 *
	 * @param String vvd
	 * @return List<AmsInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AmsInfoVO> searchAmsCode(String vvd) throws DAOException {
		List<AmsInfoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchAmsInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, AmsInfoVO.class);
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
	 * T_PRE_MF_NO가 (Split전 Original BL이 전송된 적이) 있는지 확인 조회한다.
	 *
	 * @param String blNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchPreMF(String blNo) throws DAOException {
		String retVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchPreMFRSQL(), param, velParam);
			if (dbRowset.next())
			{
				retVal = dbRowset.getString(1);
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
	 * S01,02,03, U01,02,03, N00,01,02,03 정보를 조회한다.
	 *
	 * @param String blNo
	 * @return List<UsaCustomerInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UsaCustomerInfoVO> searchCustomer(String blNo) throws DAOException {
		// CustLineInfoVO
		List<UsaCustomerInfoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchCustLineInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaCustomerInfoVO.class);
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
	 * Del Ams Port조회
	 *
	 * @param BlLineInfoVO blLineInfoVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchDelAms(BlLineInfoVO blLineInfoVO) throws DAOException {
		String retVal = "";
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (blLineInfoVO != null) {
				Map<String, String> mapVO = blLineInfoVO.getColumnValues();
				param.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchDelAmsRSQL(), param, null);
			if (dbRowset.next()) retVal = dbRowset.getString(1);
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return retVal;
	}

	/**
	 * Fda Info 조회
	 *
	 * @param String blNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchFdaInfo(String blNo) throws DAOException {
		String retVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchFdaInfoRSQL(), param, velParam);
			if (dbRowset.next())
			{
				retVal = dbRowset.getString(1);
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
	 * COMMODITY Description 조회
	 *
	 * @param String cmdtCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchCmdtDesc(String cmdtCd) throws DAOException {
		String retVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("cmdt_cd", cmdtCd);
			velParam.put("cmdt_cd", cmdtCd);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchCmdtDescRSQL(), param, velParam);
			if (dbRowset.next())
			{
				retVal = dbRowset.getString(1);
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
	 * Container MF 정보를 조회한다.
	 *
	 * @param String blNo
	 * @param String cntrNo
	 * @param String cmdtDesc
	 * @return List<UsaCMVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UsaCMVO> searchCMInfo(String blNo, String cntrNo, String cmdtDesc) throws DAOException {
		List<UsaCMVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			param.put("cntr_no", cntrNo);
			velParam.put("cntr_no", cntrNo);
			param.put("cmdt_desc", cmdtDesc);
			velParam.put("cmdt_desc", cmdtDesc);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchCntrMfLineRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaCMVO.class);
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
	 * Cmd Mark 정보를 조회한다.
	 *
	 * @param String blNo
	 * @param String cntrNo
	 * @param String cmdSeq
	 * @return CmdMarkVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public CmdMarkVO searchCmMark(String blNo, String cntrNo, String cmdSeq) throws DAOException {
		// CustLineInfoVO
		List<CmdMarkVO> list = null;
		CmdMarkVO cmdMarkVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			param.put("cntr_no", cntrNo);
			velParam.put("cntr_no", cntrNo);
			param.put("cmd_seq", cmdSeq);
			velParam.put("cmd_seq", cmdSeq);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchCmdMarkRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CmdMarkVO.class);
			if (list != null && list.size() > 0)
			{
				cmdMarkVO = list.get(0);
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
		return cmdMarkVO;
	}

	/**
	 * DgUnno 정보를 조회한다.
	 *
	 * @param String mbl
	 * @param String cntrNo
	 * @return List<DgUnnoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DgUnnoVO> searchDgUnNo(String mbl, String cntrNo) throws DAOException {
		// CntrLineInfoVO
		List<DgUnnoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("bl_no", mbl);
			velParam.put("bl_no", mbl);
			param.put("cntr_no", cntrNo);
			velParam.put("cntr_no", cntrNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchDgUnnoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, DgUnnoVO.class);
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
		try
		{
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchMdmVslCntrRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MdmVslCntrVO.class);
			if (list != null && list.size() > 0)
			{
				mdmVslCntrVO = list.get(0);
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
		return mdmVslCntrVO;
	}

	/**
	 * bl count 정보를 조회한다.
	 *
	 * @param String vvd
	 * @param String pol
	 * @param String podCd
	 * @return int
	 * @throws DAOException
	 */
	public int searchBlCount(String vvd, String pol, String podCd) throws DAOException {
		int retVal = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
			param.put("pol_cd", pol);
			velParam.put("pol_cd", pol);
			param.put("pod_cd", podCd);
			velParam.put("pod_cd", podCd);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchBlCountRSQL(), param, velParam);
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
	 * MI TRANS DT 정보를 조회한다.
	 *
	 * @param String vvd
	 * @param String pol
	 * @param String podCd
	 * @param String msgTp
	 * @return String
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public UsaTransmitInfoVO searchMiTransmitDt(String vvd, String pol, String podCd, String msgTp) throws DAOException {
		// String retVal = "";
		UsaTransmitInfoVO retVo = null;
		List<UsaTransmitInfoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
			param.put("pol_cd", pol);
			velParam.put("pol_cd", pol);
			param.put("pod_cd", podCd);
			velParam.put("pod_cd", podCd);
			param.put("msg_tp", msgTp);
			velParam.put("msg_tp", msgTp);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchMiTransmitDtRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaTransmitInfoVO.class);
			if (list != null && list.size() > 0)
			{
				retVo = list.get(0);
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
		return retVo;
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
	 * Sysdate 를 조회한다.
	 *
	 * @param String format
	 * @return String
	 * @throws DAOException
	 */
	public String searchSysdate(String format) {
		String retVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("format", format);
			velParam.put("format", format);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOselectSysdateRSQL(), param, velParam);
			if (dbRowset.next())
			{
				retVal = dbRowset.getString(1);
			}
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return retVal;
	}

	/**
	 * MI/HI/TI/AI의 공통 첫번째 헤더를 조회한다.
	 *
	 * @param UsaTrsmFirstHeadVO usaTrsmFirstHeadVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchTrsmFirstHeader(UsaTrsmFirstHeadVO usaTrsmFirstHeadVO) throws DAOException {
		String retVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = usaTrsmFirstHeadVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchHiHeader1RSQL(), param, velParam);
			if (dbRowset.next())
			{
				retVal = dbRowset.getString(1);
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
	 * Advanced Table로 부터 ETA 정보를 조회한다.
	 *
	 * @param EtaCondAtAdvancedVO etaCondAtAdvancedVO
	 * @return EtaDetailAtAdvancedVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public EtaDetailAtAdvancedVO searchEtaFromAdvanced(EtaCondAtAdvancedVO etaCondAtAdvancedVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<EtaDetailAtAdvancedVO> list = null;
		EtaDetailAtAdvancedVO retVo = null;
		try
		{
			Map<String, String> mapVO = etaCondAtAdvancedVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchMiEtaRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EtaDetailAtAdvancedVO.class);
			if (list != null && list.size() > 0)
				retVo = list.get(0);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return retVo;
	}

	/**
	 * Ofm Header 정보를 조회한다.
	 *
	 * @param String vvd
	 * @param String pod
	 * @param String ofc
	 * @param String usr
	 * @param String tmpstr3
	 * @return OfmHeaderVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public OfmHeaderVO searchOfmHeader(String vvd, String pod, String ofc, String usr, String tmpstr3)
			throws DAOException {
		List<OfmHeaderVO> list = null;
		OfmHeaderVO ofmHeaderVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
			param.put("pod", pod);
			velParam.put("pod", pod);
			param.put("ofc", ofc);
			velParam.put("ofc", ofc);
			param.put("usr", usr);
			velParam.put("usr", usr);
			param.put("tmpstr3", tmpstr3);
			velParam.put("tmpstr3", tmpstr3);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchOfmHeaderRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, OfmHeaderVO.class);
			if (list != null && list.size() > 0)
			{
				ofmHeaderVO = list.get(0);
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
		return ofmHeaderVO;
	}

	/**
	 * Snd Log에 Ofm 정보가 Exist 하는지 조회한다.
	 *
	 * @param String vvd
	 * @param String pod
	 * @param String pol
	 * @return String
	 * @throws DAOException
	 */
	public String searchSndLogOfmExist(String vvd, String pod, String pol) throws DAOException {
		String retVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
			param.put("pod", pod);
			velParam.put("pod", pod);
			param.put("pol", pol);
			velParam.put("pol", pol);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchSndLogOfmExistRSQL(), param, velParam);
			if (dbRowset.next())
			{
				retVal = dbRowset.getString(1);
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
	 * Log 정보를 생성한다.<br>
	 *
	 * @param SendingLogVO sendingLogVO
	 * @throws DAOException
	 */
	public void addSendLog(SendingLogVO sendingLogVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = sendingLogVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new UsaCustomsTransmissionDBDAOaddSendLogCSQL(), param,
					velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
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
	 * Log Detail 정보를 생성한다.<br>
	 *
	 * @param SendingLogVO sendingLogVO
	 * @throws DAOException
	 */
	public void addSendLogDetail(SendingLogVO sendingLogVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = sendingLogVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new UsaCustomsTransmissionDBDAOaddSendLogDetailCSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
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
	 * AUTO HI전송인지 여부에 따라서 해당 MI전송 LOG도 Auto Check Update한다.<br>
	 *
	 * @param SendingLogVO sendingLogVO
	 * @throws DAOException
	 */
	public void modifyHiInfo(SendingLogVO sendingLogVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = sendingLogVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOupdateBkgCstmsAdvSndLogUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
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
	 * MI ETA INSERT.<br>
	 *
	 * @param SendingLogVO sendingLogVO
	 * @throws DAOException
	 */
	public void addVslEta(SendingLogVO sendingLogVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = sendingLogVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new UsaCustomsTransmissionDBDAOaddVvdArrCSQL(), param,
					velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
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
	 * Vsl_cd가 등록된 국가코드 정보를 조회한다.
	 *
	 * @param String vvd
	 * @param String pod
	 * @return String
	 * @throws DAOException
	 */
	public String searchEtaWhenSkdIsNotExist(String vvd, String pod) throws DAOException {
		String retVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
			param.put("pod", pod);
			velParam.put("pod", pod);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchEtaWhenSkdIsNotExistRSQL(), param, velParam);
			if (dbRowset.next())
			{
				retVal = dbRowset.getString(1);
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
	 * ISF-5 대상인지 판단 FROB, 62, 63 일때.
	 *
	 * @param String blNo
	 * @return int
	 * @throws DAOException
	 */
	public int searchIsf5(String blNo) throws DAOException {
		int retVal = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDDAOsearchIsf5RSQL(), param, velParam);
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
	 * BKG_CSTMS_ADV_SND_LOG.의 LOG SEQ를 구한다.
	 *
	 * @param String cntCd
	 * @param String ioBndCd
	 * @param String sndDt
	 * @param String trsmMsgTpId
	 * @return String
	 * @throws DAOException
	 */
	public String searchSndLogNextHisSeq(String cntCd, String ioBndCd, String sndDt, String trsmMsgTpId)
			throws DAOException {
		String retVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("cnt_cd", cntCd);
			velParam.put("cnt_cd", cntCd);
			param.put("io_bnd_cd", ioBndCd);
			velParam.put("io_bnd_cd", ioBndCd);
			param.put("snd_dt", sndDt);
			velParam.put("snd_dt", sndDt);
			param.put("trsm_msg_tp_id", trsmMsgTpId);
			velParam.put("trsm_msg_tp_id", trsmMsgTpId);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchSndLogNextHisSeqRSQL(), param, velParam);
			if (dbRowset.next())
			{
				retVal = dbRowset.getString(1);
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
	 * B01,B02,B04 정보를 조회한다.
	 *
	 * @param String blNo
	 * @return OFMBlLineInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public OFMBlLineInfoVO searchOfmItType(String blNo) throws DAOException {
		List<OFMBlLineInfoVO> list = null;
		OFMBlLineInfoVO blLineInfoVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchOFMBlLineInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, OFMBlLineInfoVO.class);
			if (list != null && list.size() > 0)
			{
				blLineInfoVO = list.get(0);
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
		return blLineInfoVO;
	}

	/**
	 * OFM Customer 정보를 조회한다.
	 *
	 * @param String blNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchOfmCustomer(String blNo) throws DAOException {
		String retVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchOFMCustLineInfoRSQL(), param, velParam);
			if (dbRowset.next())
			{
				retVal = dbRowset.getString(1);
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
	 * OFM Container List 정보를 조회한다.
	 *
	 * @param String blNo
	 * @return List<OFMCntrLineVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OFMCntrLineVO> searchOfmContainerInfo(String blNo) throws DAOException {
		// UsaContainerInfoVO
		List<OFMCntrLineVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchOFMCntrLineRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, OFMCntrLineVO.class);
			/*
			 * if(list != null && list.size() > 0 ){ UsaContainerInfoVO = list.get(0); }
			 */
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
	 * Container MF 정보를 조회한다.
	 *
	 * @param String blNo
	 * @param String cntrNo
	 * @param String cmdtDesc
	 * @return List<UsaCMVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UsaCMVO> searchOfmCMInfo(String blNo, String cntrNo, String cmdtDesc) throws DAOException {
		List<UsaCMVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			param.put("cntr_no", cntrNo);
			velParam.put("cntr_no", cntrNo);
			param.put("cmdt_desc", cmdtDesc);
			velParam.put("cmdt_desc", cmdtDesc);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchOfmCntrMfLineRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaCMVO.class);
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
	 * loc_nm 정보를 조회한다.
	 *
	 * @param String locCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchLocNm(String locCd) throws DAOException {
		String retVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("loc_cd", locCd);
			velParam.put("loc_cd", locCd);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchLocNmRSQL(), param, velParam);
			if (dbRowset.next())
			{
				retVal = dbRowset.getString(1);
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
	 * OFM 헤더, 풋터 정보를 조회한다.<br>
	 *
	 * @param UsaMiHiHeadFootCondVO usaMiHiHeadFootCondVO
	 * @return UsaMiHiHeaderFooterVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public UsaMiHiHeaderFooterVO searchOfmHeaderFooter(UsaMiHiHeadFootCondVO usaMiHiHeadFootCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaMiHiHeaderFooterVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = usaMiHiHeadFootCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchOfmMiHiHeaderFooterRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaMiHiHeaderFooterVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list.get(0);
	}

	/**
	 * 0233화면의 EDA내역을 조회한다.
	 *
	 * @param UsaManifestListCondForEdiVO usaManifestListCondForEdiVO
	 * @return List<UsaEDADetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UsaEDADetailVO> searchEDAEta(UsaManifestListCondForEdiVO usaManifestListCondForEdiVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaEDADetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = usaManifestListCondForEdiVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchEDAEtaRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaEDADetailVO.class);
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
	 * Current U.S. Server Date < EDA on MI - 5 Days 를 체크한다.
	 *
	 * @param String edaOnMi
	 * @return int
	 * @throws DAOException
	 */
	public int searchMiDiff(String edaOnMi) throws DAOException {
		int retVal = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("eda_on_mi", edaOnMi);
			velParam.put("eda_on_mi", edaOnMi);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchMiDiffRSQL(), param, velParam);
			retVal = dbRowset.getRowCount();
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
	 * Server Date < New ETA (on NIS Vessel Schedule) - 5 Days 를 체크한다.
	 *
	 * @param String etaDt
	 * @return int
	 * @throws DAOException
	 */
	public int searchEtaDiff(String etaDt) throws DAOException {
		int retVal = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("eta_dt", etaDt);
			velParam.put("eta_dt", etaDt);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchEtaDiffRSQL(), param, velParam);
			retVal = dbRowset.getRowCount();
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
	 * BKG_CSTMS_ADV_VVD_ARR 테이블에 EDA_UPD_DT 등을 갱신한다.<br>
	 *
	 * @param SendingLogVO sendingLogVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifyVvdEta(SendingLogVO sendingLogVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = sendingLogVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new UsaCustomsTransmissionDBDAOmodifyVvdEtaUSQL(), param,
					velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			return result;
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
	 * 미 세관 적하 목록 정정 대상을 가져옴
	 *
	 * @param UsaCstmsManifestAmendmentCondVO usaCstmsManifestAmendmentCondVO
	 * @return List<CstmsManifestAmendmentVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CstmsManifestAmendmentVO> searchUsaCstmsManifestAmendment(UsaCstmsManifestAmendmentCondVO usaCstmsManifestAmendmentCondVO) throws DAOException {
		List<CstmsManifestAmendmentVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;

		try
		{
			Map<String, String> mapVO = usaCstmsManifestAmendmentCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("start_no", usaCstmsManifestAmendmentCondVO.getStartNo());
			param.put("end_no", usaCstmsManifestAmendmentCondVO.getEndNo());

			if (!"".equals(usaCstmsManifestAmendmentCondVO.getBkgNo())
					|| !"".equals(usaCstmsManifestAmendmentCondVO.getMblNo())
					|| !"".equals(usaCstmsManifestAmendmentCondVO.getVvdCd()))
			{
				// Vessel 스케줄 조회
				dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchMinClptSeqRSQL(), param, velParam);
				if (dbRowset.next())
				{
					param.put("min_seq", dbRowset.getString(1));
					velParam.put("min_seq", dbRowset.getString(1));
					param.put("vsl_skd_flg", dbRowset.getString(2));
					velParam.put("vsl_skd_flg", dbRowset.getString(2));
				}
			}
			// 조회
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchUsaCstmsManifestAmendmentRSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaCstmsManifestAmendmentVO.class);
			for (int i = 0; i < list.size(); i++)
			{
				StringBuffer sbActionCode = new StringBuffer();
				UsaCstmsManifestAmendmentVO vo = (UsaCstmsManifestAmendmentVO) list.get(i);
				// Total Count 세팅
				list.get(0).setMaxRows(Integer.parseInt(vo.getTotal()));
				/***********************************************************
				 * Action Code 세팅
				 ***********************************************************/
				if (!"D".equals(vo.getMfStsCd()))
				{
					if (("X".equals(vo.getBkgStsCd()) || "A".equals(vo.getBkgStsCd()) || "S".equals(vo.getBkgStsCd()) || !vo
							.getBVvdCd().equals(vo.getTVvdCd()))
							&& ("Y".equals(vo.getBMi())))
					{
						// BOOKING의 VVD와 BKC의 VVD가 다르고 전송한 적이 있다면
						sbActionCode.append("DADC");
					}
				}
				if (!"X".equals(vo.getBkgStsCd()) && !"A".equals(vo.getBkgStsCd()) && !"S".equals(vo.getBkgStsCd())
						&& ("D".equals(vo.getMfStsCd()) || sbActionCode.toString().indexOf("DA") != -1))
				{
					// 상태가
					sbActionCode.append("RA");
				}
				// 나올수가 없음
				if ("DARA".equals(sbActionCode.toString()))
				{
					sbActionCode.setLength(0);
				}
				if (!"X".equals(vo.getBkgStsCd()) && !"A".equals(vo.getBkgStsCd()) && !"S".equals(vo.getBkgStsCd()))
				{
					sbActionCode.append("DN");
				}
				if (!"X".equals(vo.getBkgStsCd()) && !"A".equals(vo.getBkgStsCd()) && !"S".equals(vo.getBkgStsCd())
						&& "Y".equals(vo.getVMi()))
				{
					// Log 테이블에 데이타가 있으면
					sbActionCode.append("AC");
				}
				vo.setActionCode(sbActionCode.toString());
				/***********************************************************
				 * AI TYPE 세팅
				 ***********************************************************/
				if (sbActionCode.toString().startsWith("DA"))
				{
					vo.setAiType("Delete");
				}
				else if (sbActionCode.toString().endsWith("DN"))
				{
					vo.setAiType("D/L");
				}
				else if (sbActionCode.toString().endsWith("AC"))
				{
					if ("Y".equals(vo.getVMi()) && "Y".equals(vo.getBMi()))
					{
						if ("Y".equals(vo.getAiFlag()))
							vo.setAiType("Update");
						else
							vo.setAiType("N/A");
					}
					else
					{
						vo.setAiType("Add");
					}
				}
				/***********************************************************
				 * 조회조건 중 AI Type별 조회 조회 쿼리로 못해서 여기서 로직으로 List 제거
				 ***********************************************************/
				if (!usaCstmsManifestAmendmentCondVO.getAiType().equals("")
						&& !usaCstmsManifestAmendmentCondVO.getAiType().equals(vo.getAiType()))
				{
					list.remove(i);
					i--;
					continue;
				}
				/***********************************************************
				 * ActionCode Description 세팅
				 ***********************************************************/
				StringBuffer sbActionDesc = new StringBuffer();
				for (int j = 0; j < vo.getActionCode().length(); j = j + 2)
				{
					if ("DN".equals(vo.getActionCode().substring(j, j + 2)))
					{
						sbActionDesc.append("DownLoad");
					}
					else if ("AC".equals(vo.getActionCode().substring(j, j + 2)))
					{
						sbActionDesc.append("Add Transmit");
					}
					else if ("DA".equals(vo.getActionCode().substring(j, j + 2)))
					{
						sbActionDesc.append("DeActivate");
					}
					else if ("RA".equals(vo.getActionCode().substring(j, j + 2)))
					{
						sbActionDesc.append("ReActivate");
					}
					else if ("DC".equals(vo.getActionCode().substring(j, j + 2)))
					{
						sbActionDesc.append("Delete Transmit");
					}
					if (j + 2 < vo.getActionCode().length())
					{
						sbActionDesc.append("->");
					}
				}
				vo.setActionDesc(sbActionDesc.toString());
			}
			// Total Count 세팅
			if (!"".equals(usaCstmsManifestAmendmentCondVO.getAiType()) && list.size() > 0)
			{
				list.get(0).setMaxRows(list.size());
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
		return list;
	}

	/**
	 * 미 세관 Cancel 대상 적하 목록을 가져옴
	 *
	 * @param UsaCstmsManifestAmendmentCondVO usaCstmsManifestAmendmentCondVO
	 * @return List<CstmsManifestAmendmentVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CstmsManifestAmendmentVO> searchDelManifestAmendment(UsaCstmsManifestAmendmentCondVO usaCstmsManifestAmendmentCondVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (usaCstmsManifestAmendmentCondVO != null) {
				Map<String, String> mapVO = usaCstmsManifestAmendmentCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchDelManifestAmendmentRSQL(), param, velParam);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, UsaCstmsManifestAmendmentVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
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
		try
		{
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchCarrierBatchNumberRSQL(), param, velParam);
			if (dbRowset.next())
			{
				retVal = dbRowset.getString(1);
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
	 * BKG_CSTMS_ADV_EDI_BL_RSPN 테이블에 CRR_BAT_NO 등을 삽입한다.<br>
	 *
	 * @param SendingLogVO sendingLogVO
	 * @return int
	 * @throws DAOException
	 */
	public int addCarrierBatchNo(SendingLogVO sendingLogVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = sendingLogVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new UsaCustomsTransmissionDBDAOaddCarrierBatchNoCSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			return result;
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
	 * 1023화면, Vessel Stowage Plan - Exclude Canada Import정보를 조회한다.
	 *
	 * @param StiCondListVO stiCondListVO
	 * @return List<StiDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<StiDetailVO> searchStiListAtCnd(StiCondListVO stiCondListVO) throws DAOException {
		List<StiDetailVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = stiCondListVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchStiListAtCndRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, StiDetailVO.class);
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
	 * 1023화면, Vessel Stowage Plan - Exclude Canada Import가 체크되어 있지 않은 경우, US, CA정보를 조회한다.
	 *
	 * @param StiCondListVO stiCondListVO
	 * @return List<StiDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<StiDetailVO> searchStiListAtUsa(StiCondListVO stiCondListVO) throws DAOException {
		List<StiDetailVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = stiCondListVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchStiListAtUsaRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, StiDetailVO.class);
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
	 * 1023화면, Vessel Stowage Plan Transmit 할때, Vessel Info를 조회한다.
	 *
	 * @param VesselEtaCondVO vesselEtaCondVO
	 * @return VesselEtaInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public VesselEtaInfoVO searchVesselEta(VesselEtaCondVO vesselEtaCondVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<VesselEtaInfoVO> list = null;
		VesselEtaInfoVO vesselEtaInfoVO = null;
		try
		{
			Map<String, String> mapVO = vesselEtaCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchVesselEtaRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, VesselEtaInfoVO.class);

			if(list != null && list.size() > 0) {
				vesselEtaInfoVO = list.get(0);
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
		return vesselEtaInfoVO;
	}

	/**
	 * 1023화면, Vessel Stowage Plan Transmit 할때, Container별 Bay Info를 조회한다.
	 *
	 * @param BayPlanCntrListCondVO bayPlanCntrListCondVO
	 * @return BayPlanCntrDetailVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BayPlanCntrDetailVO searchBayPlanCntrList(BayPlanCntrListCondVO bayPlanCntrListCondVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<BayPlanCntrDetailVO> list = null;
		try
		{
			Map<String, String> mapVO = bayPlanCntrListCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchBayPlanCntrListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BayPlanCntrDetailVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list.get(0);
	}

	/**
	 * bkg_cstms_adv_snd_log.crr_bat_no 를 Setup 하기 위해 새로운 번호를 조회한다.
	 *
	 * @return String
	 * @throws DAOException
	 */
	public String searchDateSeq() throws DAOException {
		String retVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchDateSeqRSQL(), param, velParam);
			if (dbRowset.next())
			{
				retVal = dbRowset.getString(1);
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
	 * BKG_CSTMS_ADV_STWG_SND_LOG 테이블에 로그를 입력한다.<br>
	 *
	 * @param SendDetailLogVO sendDetailLogVO
	 * @return int
	 * @throws DAOException
	 */
	public int addStowageSendLog(SendDetailLogVO sendDetailLogVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = sendDetailLogVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new UsaCustomsTransmissionDBDAOaddStowageSendLogCSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			return result;
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
	 * BKG_CSTMS_ADV_STWG_SND_DTL 테이블에 로그를 입력한다.<br>
	 *
	 * @param SendDetailLogVO sendDetailLogVO
	 * @return int
	 * @throws DAOException
	 */
	public int addSendDetailLog(SendDetailLogVO sendDetailLogVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = sendDetailLogVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new UsaCustomsTransmissionDBDAOaddSendDetailLogCSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			return result;
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
	 * BKG_CSTMS_ADV_STWG_CNTR 테이블에 로그를 갱신한다.<br>
	 *
	 * @param SendLogDetailVO sendLogDetailVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifySendLogByCntr(SendLogDetailVO sendLogDetailVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = sendLogDetailVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new UsaCustomsTransmissionDBDAOmodifySendLogByCntrUSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			return result;
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
	 * BKG_CSTMS_ADV_STWG_CNTR 테이블에 로그를 입력(Insert)한다.<br>
	 *
	 * @param SendLogDetailVO sendLogDetailVO
	 * @return int
	 * @throws DAOException
	 */
	public int addSendLogByCntr(SendLogDetailVO sendLogDetailVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = sendLogDetailVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new UsaCustomsTransmissionDBDAOAddSendLogByCntrCSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			return result;
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
	 * AmpPort에 대한 LocCd를 찾는다.
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return UsaLocationVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public UsaLocationVO searchLocCdByAmsPort(UsaRcvMsgVO usaRcvMsgVO) {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<UsaLocationVO> list = null;
		UsaLocationVO rtn = null;
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchLocCdByAmsPortRSQL(), param, velParam);
			if (dbRowset.getRowCount() > 0)
			{
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaLocationVO.class);
				rtn = list.get(0);
			}
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return rtn;
	}

	/**
	 * CustomsLoc에 대한 LocCd를 찾는다.
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return UsaLocationVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public UsaLocationVO searchLocCdForCustomsLoc(UsaRcvMsgVO usaRcvMsgVO) {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<UsaLocationVO> list = null;
		UsaLocationVO rtn = null;
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchLocCdForCustomsLocRSQL(), param, velParam);
			if (dbRowset.getRowCount() > 0)
			{
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaLocationVO.class);
				rtn = list.get(0);
			}
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return rtn;
	}

	/**
	 * 해당 CusAmsport가 Disposition Code에 속하는 지 찾는다.
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchCstmsLocByDspoCd(UsaRcvMsgVO usaRcvMsgVO) {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int rtn = 0;
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchCstmsLocByDspoCdRSQL(), param, velParam);
			if (dbRowset.getRowCount() > 0)
			{
				rtn=1;
			}
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return rtn;
	}

	/**
	 * RCV LOG에서 수신일자의 가장 큰 순차를 찾는다.
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return String maxRcvSeq
	 * @throws DAOException
	 */
	public String searchMaxIrSeq(UsaRcvMsgVO usaRcvMsgVO) {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		String maxRcvSeq = "1";
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchMaxIrSeqRSQL(), param, velParam);
			if (dbRowset.next())
			{
				maxRcvSeq = dbRowset.getString(1);
			}
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return maxRcvSeq;
	}

	/**
	 * 미세관 응답메세지 수신 로그를 저장한다.<br>
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 * @throws DAOException
	 */
	public int addRcvLogMst(UsaRcvMsgVO usaRcvMsgVO) {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new UsaCustomsTransmissionDBDAOaddRcvLogMstCSQL(), param,
					velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");


			return result;
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return 0;
	}

	/**
	 * 미세관 응답메세지 수신 로그의 상세데이터를 저장한다.<br>
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 * @throws DAOException
	 */
	public int addRcvLogDetail(UsaRcvMsgVO usaRcvMsgVO) {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new UsaCustomsTransmissionDBDAOaddRcvLogDetailCSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			return result;
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return 0;
	}

	/**
	 * 캐나다에 해당 BL이 있는지 확인한다.
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchCNRUBlAtCanada(UsaRcvMsgVO usaRcvMsgVO) {
		int retVal = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchCNRUBlAtCanadaRSQL(), param, velParam);
			if (dbRowset.next())
			{
				retVal = 1;
			}
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return retVal;
	}

	/**
	 * 미세관 응답메세지 수신 NVOCC 를 갱신한다.<br>
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifyDnvlFile(UsaRcvMsgVO usaRcvMsgVO) {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new UsaCustomsTransmissionDBDAOmodifyDnvlFileUSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to UPDATE SQL");
			return result;
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return 0;
	}

	/**
	 * 미세관 응답메세지 수신 NVOCC 를 입력한다.<br>
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 * @throws DAOException
	 */
	public int addDnvoFile(UsaRcvMsgVO usaRcvMsgVO) {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new UsaCustomsTransmissionDBDAOaddDnvoFileCSQL(), param,
					velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to UPDATE SQL");
			return result;
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return 0;
	}

	/**
	 * MASTER BL NO를 찾는다..
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return UsaResultCntrVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public UsaResultCntrVO searchMasterBl(UsaRcvMsgVO usaRcvMsgVO) {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<UsaResultCntrVO> list = null;
		UsaResultCntrVO rtn = null;
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchMasterBlRSQL(), param, velParam);
			if (dbRowset.getRowCount() > 0)
			{
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaResultCntrVO.class);
				rtn = list.get(0);
			}
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return rtn;
	}

	/**
	 * VVD, POD를 찾는다.
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return UsaResultCntrVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public UsaResultCntrVO searchVVDPodByBl(UsaRcvMsgVO usaRcvMsgVO) {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<UsaResultCntrVO> list = null;
		UsaResultCntrVO rtn = null;
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchVVDPodByBlRSQL(), param, velParam);
			if (dbRowset.getRowCount() > 0)
			{
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaResultCntrVO.class);
				rtn = list.get(0);
			}
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return rtn;
	}

	/**
	 * 미세관 응답메세지 수신 NVOCC 중 NIS 를 갱신한다.<br>
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifyVvdPodByBlAtDnvoFile(UsaRcvMsgVO usaRcvMsgVO) {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOmodifyVvdPodByBlAtDnvoFileUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to UPDATE SQL");
			return result;
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return 0;
	}

	/**
	 * VVD, POD를 찾는다.
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return UsaResultCntrVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public UsaResultCntrVO searchMBlByVvdCntrNo(UsaRcvMsgVO usaRcvMsgVO) {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<UsaResultCntrVO> list = null;
		UsaResultCntrVO rtn = null;
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchMBlByVvdCntrNoRSQL(), param, velParam);
			if (dbRowset.getRowCount() > 0)
			{
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaResultCntrVO.class);
				rtn = list.get(0);
			}
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return rtn;
	}

	/**
	 * CNRU BL VALIDATION CHECK.
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return String
	 * @throws DAOException
	 */
	public String validateCNRUBl(UsaRcvMsgVO usaRcvMsgVO) {
		String retVal = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOvalidateCNRUBlRSQL(), param, velParam);
			if (dbRowset.next())
			{
				retVal = dbRowset.getString(1);
			}
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return retVal;
	}

	/**
	 * 1J에 의해 HUB를 찾는다.
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchItHubByBl1J(UsaRcvMsgVO usaRcvMsgVO) {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		String sCusLoc = "";
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchItHubByBl1JRSQL(), param, velParam);
			if (dbRowset.next())
			{
				sCusLoc = dbRowset.getString(1);
			}
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return sCusLoc;
	}

	/**
	 * RESULT의 MAX SEQ를 찾는다.
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return UsaResultCntrVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public UsaResultCntrVO searchMaxSeqAtResult(UsaRcvMsgVO usaRcvMsgVO) {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<UsaResultCntrVO> list = null;
		UsaResultCntrVO rtn = null;
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchMaxSeqAtResultRSQL(), param, velParam);
			if (dbRowset.getRowCount() > 0)
			{
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaResultCntrVO.class);
				rtn = list.get(0);
			}
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return rtn;
	}

	/**
	 * BKG_CSTMS_ADV_RSLT 를 입력한다.<br>
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 * @throws DAOException
	 */
	public int addCustomsResult(UsaRcvMsgVO usaRcvMsgVO) {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new UsaCustomsTransmissionDBDAOaddCustomsResultCSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to UPDATE SQL");
			return result;
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return 0;
	}

	/**
	 * Old cntr C-FLAG를 찾는다.
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return UsaResultCntrVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public UsaResultCntrVO searchCFlagAtResultCntr(UsaRcvMsgVO usaRcvMsgVO) {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<UsaResultCntrVO> list = null;
		UsaResultCntrVO rtn = null;
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchCFlagAtResultCntrRSQL(), param, velParam);
			if (dbRowset.getRowCount() > 0)
			{
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaResultCntrVO.class);
				rtn = list.get(0);
			}
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return rtn;
	}

	/**
	 * CNTR QTY(qty_69) 를 찾는다.
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 * @throws DAOException
	 */
	public int search69QtyByBl(UsaRcvMsgVO usaRcvMsgVO) {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int qty69 = 0;
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearch69QtyByBlRSQL(), param, velParam);
			if (dbRowset.next())
			{
				// 여러건의 경우 첫번째 Row의 69 Qty를 리턴한다.
				qty69 = dbRowset.getInt(1);
			}
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return qty69;
	}

	/**
	 * 1C 의 QTY - 4E의 QTY
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchSumQtyByBl(UsaRcvMsgVO usaRcvMsgVO) {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int sumQtyByBl = 0;
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchSumQtyByBlRSQL(), param, velParam);
			if (dbRowset.next())
			{
				sumQtyByBl = dbRowset.getInt(1);
			}
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return sumQtyByBl;
	}

	/**
	 * 미세관 응답메세지 수신 NVOCC 중 BKG_CSTMS_ADV_CNTR_RSLT 를 입력한다.<br>
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 * @throws DAOException
	 */
	public int addResultCntr(UsaRcvMsgVO usaRcvMsgVO) {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new UsaCustomsTransmissionDBDAOaddResultCntrCSQL(), param,
					velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to UPDATE SQL");
			return result;
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return 0;
	}

	/**
	 * 미세관 응답메세지 수신 NVOCC 중 BKG_CSTMS_ADV_CNTR_RSLT 를 갱신한다.<br>
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifyCustomsResult(UsaRcvMsgVO usaRcvMsgVO) {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new UsaCustomsTransmissionDBDAOmodifyCustomsResultUSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to UPDATE SQL");
			return result;
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return 0;
	}

	/**
	 * 미세관 응답메세지 수신 NVOCC 중 BKG_CSTMS_ADV_CNTR_RSLT 를 갱신한다.<br>
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifyCustomsResultForRemark(UsaRcvMsgVO usaRcvMsgVO) {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOmodifyCustomsResultForRemarkUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to UPDATE SQL");
			return result;
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return 0;
	}

	/**
	 * 미세관 응답메세지 수신 NVOCC 중 BKG_CSTMS_ADV_CNTR_RSLT 를 갱신한다.<br>
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifyCustomsResultForRemark3(UsaRcvMsgVO usaRcvMsgVO) {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOmodifyCustomsResultForRemark3USQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to UPDATE SQL");
			return result;
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return 0;
	}

	/**
	 * 미세관 응답메세지 수신 NVOCC 중 BKG_CSTMS_ADV_CNTR_RSLT 를 갱신한다.<br>
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifyCustomsResultForRemarkSnpHJSC(UsaRcvMsgVO usaRcvMsgVO) {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOmodifyCustomsResultForRemarkSnpHJSCUSQL(), param,
					velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to UPDATE SQL");
			return result;
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return 0;
	}

	/**
	 * bkg_cstms_adv_bl 정보를 조회한다.
	 *
	 * @param String blNo
	 * @param String cntCd
	 * @return BkgCstmsAdvBlVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgCstmsAdvBlVO searchAdvBl(String blNo, String cntCd) {
		List<BkgCstmsAdvBlVO> list = null;
		BkgCstmsAdvBlVO vo = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			param.put("cnt_cd", cntCd);
			velParam.put("cnt_cd", cntCd);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchAdvBlRSQL(), param, velParam);
			if (dbRowset.getRowCount() > 0)
			{
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsAdvBlVO.class);
				vo = list.get(0);
			}
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return vo;
	}

	/**
	 * blNo에 대해 Partial B/L 를 찾는다.
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return List<UsaPartialBlVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UsaPartialBlVO> searchPartialBl(UsaRcvMsgVO usaRcvMsgVO) {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<UsaPartialBlVO> list = null;
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchPartialBlRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaPartialBlVO.class);
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return list;
	}

	/**
	 * Booking Party 를 찾는다.
	 *
	 * @param UsaIsf5CondVO usaIsf5CondVO
	 * @return UsaIsf5ResultVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public UsaIsf5ResultVO searchIsf5BkgParty(UsaIsf5CondVO usaIsf5CondVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<UsaIsf5ResultVO> list = null;
		UsaIsf5ResultVO rtn = null;
		try
		{
			Map<String, String> mapVO = usaIsf5CondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchIsf5BkgPartyRSQL(), param, velParam);
			if (dbRowset.getRowCount() > 0)
			{
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaIsf5ResultVO.class);
				rtn = list.get(0);
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
		return rtn;
	}

	/**
	 * Ship To Party 를 찾는다.
	 *
	 * @param UsaIsf5CondVO usaIsf5CondVO
	 * @return UsaIsf5ResultVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public UsaIsf5ResultVO searchIsf5SF30Party(UsaIsf5CondVO usaIsf5CondVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<UsaIsf5ResultVO> list = null;
		UsaIsf5ResultVO rtn = null;
		try
		{
			Map<String, String> mapVO = usaIsf5CondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchIsf5SF30PartyRSQL(), param, velParam);
			if (dbRowset.getRowCount() > 0)
			{
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaIsf5ResultVO.class);
				rtn = list.get(0);
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
		return rtn;
	}

	/**
	 * Foreign Port of Unlading, Place of Delivery 를 찾는다.
	 *
	 * @param UsaIsf5CondVO usaIsf5CondVO
	 * @return UsaIsf5ResultVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public UsaIsf5ResultVO searchIsf5SF50(UsaIsf5CondVO usaIsf5CondVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<UsaIsf5ResultVO> list = null;
		UsaIsf5ResultVO rtn = null;
		try
		{
			Map<String, String> mapVO = usaIsf5CondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchIsf5SF50RSQL(), param, velParam);
			if (dbRowset.getRowCount() > 0)
			{
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaIsf5ResultVO.class);
				rtn = list.get(0);
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
		return rtn;
	}

	/**
	 * 미세관 응답메세지 수신 NVOCC 중 BKG_CSTMS_ADV_CNTR_RSLT 를 갱신한다.<br>
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifyCustomsResultForCstmsClrCd(UsaRcvMsgVO usaRcvMsgVO) {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOmodifyCustomsResultForCstmsClrCdUSQL(), param,
					velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to UPDATE SQL");
			return result;
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return 0;
	}

	/**
	 * 미세관 응답메세지 수신 NVOCC 중 NIS 를 갱신한다.<br>
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifyBkgCstmsAdvStwgSndLog(UsaRcvMsgVO usaRcvMsgVO) {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOmodifyBkgCstmsAdvStwgSndLogUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to UPDATE SQL");
			return result;
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return 0;
	}

	/**
	 * ISF5 정보조회
	 *
	 * @param sBlNo BL No.
	 * @param sIsfActCd ISF Action Code
	 * @return Isf5InfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Isf5InfoVO> searchIsf5Info(String sBlNo, String sIsfActCd) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		List<Isf5InfoVO> list = null;
		try
		{
			param.put("bl_no", sBlNo);
			param.put("isf_act_cd", sIsfActCd);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchIsf5InfoRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Isf5InfoVO.class);
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
	 * C-Flag H->W->Y 조회
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return String cFlag
	 * @throws DAOException
	 */
	public String searchCFlagHWY(UsaRcvMsgVO usaRcvMsgVO) {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		String cFlag = "N";
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			String cstmsSeq1X = this.search1XSeq(usaRcvMsgVO, "");
			param.put("cstms_seq", cstmsSeq1X);
			velParam.put("cstms_seq", cstmsSeq1X);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchCFlagHWYRSQL(), param, velParam);
			if (dbRowset.next())
			{
				cFlag = dbRowset.getString(1);
			}
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return cFlag;
	}

	/**
	 * C-Flag I -> J -> V -> T -> E 조회
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @param String oldCFlag
	 * @return String cFlag
	 * @throws DAOException
	 */
	public String searchCFlagIJVTE(UsaRcvMsgVO usaRcvMsgVO, String oldCFlag) {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		String cFlag = "N";
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("old_c_flag", oldCFlag);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchCFlagJIVTERSQL(), param, velParam);
			if (dbRowset.next())
			{
				cFlag = dbRowset.getString(1);
			}
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return cFlag;
	}

	/**
	 * C-Flag T , E 조회
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return String cFlag
	 * @throws DAOException
	 */
	public String searchCFlagTE(UsaRcvMsgVO usaRcvMsgVO) {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		String cFlag = "N";
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchCFlagTERSQL(), param, velParam);
			if (dbRowset.next())
			{
				cFlag = dbRowset.getString(1);
			}
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return cFlag;
	}

	/**
	 * DSPO_CD에 따른 Hold Qty & Remove Qty가 일치하는지 체크<br>
	 * Hold Code와 Remove Code는 Pair로 존재함.<br>
	 * Hold Code에 해당하는 Remove Code의 Qty를 Sum해서 같은지 비교
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkHoldRemvQty(UsaRcvMsgVO usaRcvMsgVO) {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		boolean bResult = false;
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			String cstmsSeq1X = this.search1XSeq(usaRcvMsgVO, "");
			param.put("cstms_seq", cstmsSeq1X);
			velParam.put("cstms_seq", cstmsSeq1X);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOcheckHoldRemvQtyRSQL(), param, velParam);
			if (dbRowset.next())
			{
				if (dbRowset.getInt(1) == 0)
				{
					bResult = true;
				}
			}
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return bResult;
	}
	/**
	 * Inbound Hold Notice 'CF'로 세팅할 데이타 조회
	 * @param usaRcvMsgVO
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<HoldInfoVO> searchHoldInfo(UsaRcvMsgVO usaRcvMsgVO) {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<HoldInfoVO> list = null;
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchHoldInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, HoldInfoVO.class);
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return list;
	}

	/**
	 * 해당 Hold의 Remove코드 조회
	 *
	 * @param blNo
	 * @param holdInfoVO
	 * @return HoldInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public HoldInfoVO searchRemvInfo(String blNo, HoldInfoVO holdInfoVO) {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		HoldInfoVO rHoldInfoVO = null;
		try
		{
			Map<String, String> mapVO = holdInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("bl_no", blNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchRemvInfoRSQL(), param, velParam);
			List<HoldInfoVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, HoldInfoVO.class);
			if (list.size() > 0)
			{
				rHoldInfoVO = list.get(0);
			}
			else
			{
				rHoldInfoVO = new HoldInfoVO();
			}
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return rHoldInfoVO;
	}

	/**
	 * 4E : 1J 를 받은 적이 있으면 'J', 그외 'N'<br>
	 * Release Code : 1J 를 받은 적이 있으면 'J', 1C 를 받은 적이 있으면 'Y', 그외 'N'<br>
	 * @param usaRcvMsgVO
	 * @return String
	 * @throws DAOException
	 */
	public String search1J1CChk(UsaRcvMsgVO usaRcvMsgVO) {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		String cFlag = "N";
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearch1J1CChkRSQL(), param, velParam);
			if (dbRowset.next())
			{
				cFlag = dbRowset.getString(1);
			}
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return cFlag;
	}

	/**
	 * Release Code : 이전 Dspo Cd 별 Enter/Release Qty 합산하여 Cntr_Pck_Qty 와 동일할 경우, C-flag =Y or J. 아니면 N<br>
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchRailCflagHYJ(UsaRcvMsgVO usaRcvMsgVO) {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		String cFlag = "N";
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			String cstmsSeq1X = this.search1XSeq(usaRcvMsgVO, "RAIL");
			param.put("cstms_seq", cstmsSeq1X);
			velParam.put("cstms_seq", cstmsSeq1X);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchRailCflagHYJRSQL(), param, velParam);
			if (dbRowset.next())
			{
				cFlag = dbRowset.getString(1);
			}
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return cFlag;
	}

	/**
	 * Hold Pair 체크
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkRailHoldPairDspo(UsaRcvMsgVO usaRcvMsgVO) {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		boolean bResult = false;
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			String cstmsSeq1X = this.search1XSeq(usaRcvMsgVO, "RAIL");
			param.put("cstms_seq", cstmsSeq1X);
			velParam.put("cstms_seq", cstmsSeq1X);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOcheckRailHoldPairDspoRSQL(), param, velParam);
			if (dbRowset.next())
			{
				if (dbRowset.getInt(1) == 0)
				{
					bResult = true;
				}
			}
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return bResult;
	}

	/**
	 * DSPO_CD
	 * @param dspo_cd
	 * @param cstms_div_id
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkHoldRemv(String dspo_cd, String cstms_div_id) {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		boolean result = false;
		try
		{
			param.put("dspo_cd", dspo_cd);
			param.put("cstms_div_id", cstms_div_id);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOcheckHoldRemvRSQL(), param, velParam);
			if (dbRowset.next())
			{
				result = true;
			}
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return result;
	}

	/**
	 * BKG_CSTMS_ADV_RCV_LOG의 POL수정<br>
	 *
	 * @param usaRcvMsgVO usaRcvMsgVO
	 * @param type type
	 * @throws DAOException
	 */
	public void modifyBkgCstmsAdvRcvLog(UsaRcvMsgVO usaRcvMsgVO, String type) {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			mapVO.put("type", type);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOmodifyBkgCstmsAdvRcvLogUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage());
		}
	}

	/**
	 * HOLD CODE 여부판단
	 * @param hldTpCd
	 * @param hldCd
	 * @param rlseHldCd
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean searchHldNtcFlg(String hldTpCd, String hldCd, String rlseHldCd) {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("hld_ntc_tp_cd", hldTpCd);
			mapVO.put("cstms_dspo_cd", hldCd);
			mapVO.put("cstms_pair_dspo_cd", rlseHldCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new HoldNoticeDBDAOsearchHldNtcFlgRSQL(), param, velParam);
			if (dbRowset.next())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return false;
	}

	/**
	 * 4A의 경우 HOLD CODE 여부판단
	 * @param blNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchCFlag4A(String blNo) {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("bl_no", blNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchCFlag4ARSQL(), param, velParam);
			if (dbRowset.next())
			{
				return dbRowset.getString(1);
			}
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return "";
	}

	/**
	 * 4A 후 1B, 4C의 경우 REMOVE한다.
	 * @param blNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchCFlag1B4C(String blNo) {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bl_no", blNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			// 4A가 들어온 SEQ구하기
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchCFlag4AMaxSeqRSQL(), param, velParam);
			if (dbRowset.next())
			{
				int maxSeq = dbRowset.getInt(1);
//				if (maxSeq > 0)
//				{
					mapVO.put("cstms_seq", ""+maxSeq);
					dbRowset = new SQLExecuter("").executeQuery(
							(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchCFlag1B4CRSQL(), mapVO, mapVO);
					if (dbRowset.next())
					{
						return dbRowset.getString(1);
					}
//				}
			}
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return "";
	}

	/**
	 * 로그를 기록한다.<br>
	 *
	 * @param String modName
	 * @param String applInfo
	 * @param String logDesc
	 * @exception DAOException
	 */
	public void addEnisLog(String modName, String applInfo, String logDesc) {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("mod_name", modName);
			mapVO.put("appl_info", applInfo);
			mapVO.put("log_desc", logDesc);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeSP((ISQLTemplate) new HoldNoticeDBDAOPrcExecEnisLogCSQL(), param, velParam);
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
	}

	/**
	 * MDM_LOCATION ams loc cd가 없을때 세관쪽 테이블 조회
	 * @param cusAmsport
	 * @return String
	 * @throws DAOException
	 */
	public String searchAmsCusLoc(String cusAmsport) {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("cus_ams_port", cusAmsport);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchAmsCusLocRSQL(), param, velParam);
			if (dbRowset.next())
			{
				return dbRowset.getString(1);
			}
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return "";
	}

	/**
	 * BKG_CGO_RLSE C-Flag 가져오기
	 * @param usaRcvMsgVO
	 * @return UsaPartialBlVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public UsaPartialBlVO searchOldCstmsClrCd(UsaRcvMsgVO usaRcvMsgVO) {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchOldCstmsClrCdRSQL(), param, velParam);
			List<UsaPartialBlVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaPartialBlVO.class);
			if (list.size() > 0)
			{
				return list.get(0);
			}
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return new UsaPartialBlVO();
	}

	/**
	 * Vsl_cd가 등록된 BKG_BOOKING로 부터 LANE 정보를 조회한다.
	 *
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	public String searchSvcLane(String vvd) throws DAOException {
		String retVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			velParam.put("vvd", vvd);
			param.put("vvd", vvd);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchSvcLaneRSQL(), param, velParam);
			if (dbRowset.next())
			{
				retVal = dbRowset.getString(1);
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
	 * Transmit 하기 위한 세관 테이블의 Customer, Container 등의 Terminal BL 정보를 조회한다
	 *
	 * @param BlInfoCondVO blInfoCondVO
	 * @return List<BlInfoVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<BlInfoVO> searchUsaTmlBlByVvd(BlInfoCondVO blInfoCondVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		List<BlInfoVO> list = null;
		try
		{
			if (blInfoCondVO != null)
			{
				if (!"".equals(JSPUtil.getNull(blInfoCondVO.getBlNo())))
				{
					param.put("bl_no", blInfoCondVO.getBlNo());
				}
				else
				{
					UsaManifestSearchDetailVO[] vos = blInfoCondVO.getUsaManifestSearchDetailVOs();
					StringBuffer sbBlNo = new StringBuffer();
					for (int i=0; i<vos.length; i++) {
						if (i > 0) {
							sbBlNo.append(",");
						}
						sbBlNo.append("'");
						sbBlNo.append(vos[i].getBlNo());
						sbBlNo.append("'");
					}
					param.put("bl_nos", sbBlNo.toString());
				}
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchUsaTmlBlByVvdRSQL(), param, param);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaTmlBlByVvdVO.class);
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
	 * 컨테이너 번호 조회
	 *
	 * @param cntrNo
	 * @return String
	 */
	public String searchCntrNo(String cntrNo) {
		Map<String, Object> param = new HashMap<String, Object>();
		try
		{
			param.put("cntr_no", cntrNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchCntrNoRSQL(), param, param);
			if (dbRowset.next())
			{
				return dbRowset.getString(1);
			}
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage());
		}
		return cntrNo;
	}

	/**
	 * 컨테이너 번호 조회
	 *
	 * @param String vvd
	 * @param String pol
	 * @param String pod
	 * @param String msgTp
	 * @return String
	 */
	public String searchActDirCd(String vvd, String pol, String pod, String msgTp) throws DAOException{
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		String retVal = "";
		try
		{
			velParam.put("vvd", vvd);
			param.put("vvd", vvd);
			velParam.put("pol_cd", pol);
			param.put("pol_cd", pol);
			velParam.put("pod_cd", pod);
			param.put("pod_cd", pod);
			velParam.put("msg_tp", msgTp);
			param.put("msg_tp", msgTp);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchActDirCdRSQL(), param, velParam);
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
	 * ISF-5 전송한 이력 조회.
	 *
	 * @param String blNo
	 * @return int
	 * @throws DAOException
	 */
	public int searchIsf5SndLog(String blNo) throws DAOException {
		int retVal = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchIsf5SndLogRSQL(), param, velParam);
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
	 * 1X Hold에서 제외시키는 로직
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @param @param String rail
	 * @return String
	 */
	@SuppressWarnings("unchecked")
	private String search1XSeq (UsaRcvMsgVO usaRcvMsgVO, String rail) {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		String sResult = "";
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("rail", rail);
			velParam.put("rail", rail);
			/*********************************************************
			 * '1X' Hold Code는 상황에 따라 Seq 제외<br>
			 * '1X' 위에 Hold Code가 있으면 그 '1X'는 제외<br>
			 * '1X' 후 Manual로 CGO_RLSE Cflag변경하면 그 '1X'는 제외
			 *********************************************************/
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchCFlag1XListRSQL(), param, velParam);
			List<UsaCFlag1XChkVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaCFlag1XChkVO.class);
			boolean holdFlg = false;
			boolean xflg = false;
			List<UsaCFlag1XChkVO> holdList = new ArrayList<UsaCFlag1XChkVO>();
			StringBuffer sbTmpSeq = new StringBuffer();
			StringBuffer sbSeq = new StringBuffer();
			for (int i = 0; i < list.size(); i++)
			{
				// hold의 경우
				if ("H".equals(list.get(i).getHoldFlg()) && !"1X".equals(list.get(i).getDspoCd()))
				{
					// 1X를 받고 나서 다음 Hold를 받으면 그동안 쌓인 holdList는 초기화한다.
					if (xflg)
					{
						holdList = new ArrayList<UsaCFlag1XChkVO>();
						xflg = false;
						//sbTmpSeq = new StringBuffer();
					}
					holdFlg = true;
					// 같은 HOLD코드가 holdList에 있을 때 Qty만 증가 시킨다.
					boolean holdAddFlg = false;
					if (holdList.size() > 0)
					{
						for (int j = 0; j < holdList.size(); j++)
						{
							if (list.get(i).getDspoCd().equals(holdList.get(j).getDspoCd()))
							{
								int holdQty = Integer.parseInt(holdList.get(j).getCntrQty()) + Integer.parseInt(list.get(i).getCntrQty());
								holdList.get(j).setCntrQty(String.valueOf(holdQty));
								holdAddFlg = true;
								break;
							}
						}
					}
					// 위에서 증가시킨 Qty가 없을 때 새로운 hold Code를 holdList에 추가한다.
					if (!holdAddFlg)
					{
						UsaCFlag1XChkVO vo = new UsaCFlag1XChkVO();
						vo.setRemvCd(list.get(i).getRemvCd());
						vo.setCntrQty(list.get(i).getCntrQty());
						vo.setDspoCd(list.get(i).getDspoCd());
						holdList.add(vo);
					}
				}
				// 1X 이전에 hold 코드를 받은 경우 임시로 1X Seq를 sbTmpSeq에 담아 둔다.
				if (holdFlg && "1X".equals(list.get(i).getDspoCd()))
				{
					xflg = true;
					if (sbTmpSeq.toString().length() > 0)
					{
						sbTmpSeq.append(",");
					}
					sbTmpSeq.append("'");
					sbTmpSeq.append(list.get(i).getCstmsSeq());
					sbTmpSeq.append("'");
				}
				// 현재 Hold이고 Removal코드를 받은경우
				if (holdFlg && "R".equals(list.get(i).getRemvFlg()))
				{
					UsaCFlag1XChkVO vo = new UsaCFlag1XChkVO();
					vo.setDspoCd(list.get(i).getDspoCd());
					vo.setCntrQty(list.get(i).getCntrQty());

					for (int j = 0; j < holdList.size(); j++)
					{
						// holdList의 Removal코드와 현재 Removal가 같다면
						if (holdList.get(j).getRemvCd().indexOf(vo.getDspoCd()) >= 0)
						{
							// holdList의 Qty에서 Removal Qty를 뺀다.
							int remoQty = Integer.parseInt(holdList.get(j).getCntrQty()) - Integer.parseInt(vo.getCntrQty());
							holdList.get(j).setCntrQty(String.valueOf(remoQty));
						}
						// holdList의 Qty가 0이 되면 holdList에서 해당 hold Code를 제외한다.
						if ("0".equals(holdList.get(j).getCntrQty()))
						{
							holdList.remove(j);
							j--;
						}
					}
					// holdList에 값이 없으면 모두 Removal된것으로 판단해서 임시로 sbTmpSeq에 담아둔 Seq를 실제 sbSeq에 담는다.
					// 모든 값을 초기화한다.
					if (holdList.size() == 0)
					{
						if (sbSeq.toString().length() > 0)
						{
							sbSeq.append(",");
						}
						sbSeq.append(sbTmpSeq.toString());
						holdFlg = false;
						xflg = false;
						sbTmpSeq = new StringBuffer();
					}
				}
			}
			sResult = sbSeq.toString();
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return sResult;
	}

	/**
	 * Container Result 테이블 수정
	 *
	 * @param cntrRsltVOs
	 */
	public void modifyCntrRslt(List<BkgCstmsAdvCntrRsltVO> cntrRsltVOs) {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (cntrRsltVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch(
						(ISQLTemplate) new UsaCustomsTransmissionDBDAOmodifyCntrRsltUSQL(), cntrRsltVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
	}

	/**
	 * Baplie Alarm List 조회
	 *
	 * @param baplieAlarmSetupVO BaplieAlarmSetupVO
	 * @return List<BaplieAlarmSetupVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BaplieAlarmSetupVO> searchBaplieAlarmSetup(BaplieAlarmSetupVO baplieAlarmSetupVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<BaplieAlarmSetupVO> list = null;
		try {
			// 실제 SQL상 사용되는 조건이 없어 껍데기 뿐인 mapVo가 생성되었다.
			Map<String, String> mapVO = baplieAlarmSetupVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			ISQLTemplate iSQLTemplate = (ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchBaplieAlarmSetupRSQL();
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(iSQLTemplate, param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BaplieAlarmSetupVO.class);
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Baplie Alarm 등록
	 *
	 * @param baplieAlarmSetupVOs List<BaplieAlarmSetupVO>
	 * @throws DAOException
	 */
	public void addBaplieAlarmSetup(List<BaplieAlarmSetupVO> baplieAlarmSetupVOs) throws DAOException {
		try {
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (baplieAlarmSetupVOs.size() > 0) {
				Map<String, String> mapVO = baplieAlarmSetupVOs.get(0).getColumnValues();
				velParam.putAll(mapVO);
				updCnt = sqlExe.executeBatch((ISQLTemplate) new UsaCustomsTransmissionDBDAOaddBaplieAlarmSetupCSQL(),
						baplieAlarmSetupVOs, velParam);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Baplie Alarm 수정
	 *
	 * @param baplieAlarmSetupVOs List<BaplieAlarmSetupVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyBaplieAlarmSetup(List<BaplieAlarmSetupVO> baplieAlarmSetupVOs) throws DAOException {
		try {
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (baplieAlarmSetupVOs.size() > 0) {
				Map<String, String> mapVO = baplieAlarmSetupVOs.get(0).getColumnValues();
				velParam.putAll(mapVO);
				updCnt = sqlExe.executeBatch(
						(ISQLTemplate) new UsaCustomsTransmissionDBDAOmodifyBaplieAlarmSetupUSQL(),
						baplieAlarmSetupVOs, velParam);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Baplie Alarm 삭제
	 *
	 * @param baplieAlarmSetupVOs List<BaplieAlarmSetupVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeBaplieAlarmSetup(List<BaplieAlarmSetupVO> baplieAlarmSetupVOs) throws DAOException {
		try {
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (baplieAlarmSetupVOs.size() > 0) {
				Map<String, String> mapVO = baplieAlarmSetupVOs.get(0).getColumnValues();
				velParam.putAll(mapVO);
				updCnt = sqlExe.executeBatch(
						(ISQLTemplate) new UsaCustomsTransmissionDBDAOremoveBaplieAlarmSetupDSQL(),
						baplieAlarmSetupVOs, velParam);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * '4A'에 의한 HOLD인지 체크
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean check4AHold(UsaRcvMsgVO usaRcvMsgVO) {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		boolean bResult = false;
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bl_no", usaRcvMsgVO.getBlNo());
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			// 4A가 들어온 SEQ구하기
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchCFlag4AMaxSeqRSQL(), param, velParam);
			if (dbRowset.next())
			{
				int maxSeq = dbRowset.getInt(1);
				if (maxSeq > 0)
				{
					mapVO.put("cstms_seq", ""+maxSeq);
					dbRowset = new SQLExecuter("").executeQuery(
							(ISQLTemplate) new UsaCustomsTransmissionDBDAOcheck4AHoldRSQL(), mapVO, mapVO);
					if (dbRowset.next())
					{
						if ("H".equals(dbRowset.getString(1)))
						{
							bResult = true;
						}
					}
				}
			}
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return bResult;
	}


	/**
	 * 미세관 응답메세지 수신 C01 항목으로 리스팅 된 Cntr 에 대해 R03 의 Remark 를 표기
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @throws DAOException
	 */
	public void modifyBaplieRcvByCntr(UsaRcvMsgVO usaRcvMsgVO) {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new UsaCustomsTransmissionDBDAOmodifyBaplieRcvByCntrUSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to UPDATE SQL");
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
	}
	/**
	 * 미세관 응답메세지 수신 C01 항목으로 리스팅 되지 않은 CNTR 에 대해 해당 VVD의 BAPLIE 전송이력이 있는 CNTR 는 모두 ACK 로 표기
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @throws DAOException
	 */
	public void modifyBaplieRcvByVvd(UsaRcvMsgVO usaRcvMsgVO) {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new UsaCustomsTransmissionDBDAOmodifyBaplieRcvByVvdUSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to UPDATE SQL");
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
	}

	/**
	 * EDI 수신 후 찾아진 BL_NO 존재시 해당 테이블에 BL_NO update 메소드 수행
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @throws DAOException
	 */
	public void modifyBkgCstmsAdvRcvLogBl(UsaRcvMsgVO usaRcvMsgVO){
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new UsaCustomsTransmissionDBDAOmodifyBkgCstmsAdvRcvLogBlUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to UPDATE SQL");
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
	}

	/**
	 * STOWAGE SEND LOG 테이블 업데이트
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int result
	 * @throws DAOException
	 */
	public int modifyBaplieCusResSndLog(UsaRcvMsgVO usaRcvMsgVO){
		int result = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new UsaCustomsTransmissionDBDAOmodifyBaplieCusResSndLogUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to UPDATE SQL");

		}
		catch (Exception ex)
		{
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return result;
	}

	/**
	 * ERROR_DETAIL 루프 내, Cntr_no error result 별 업데이트
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int result
	 * @throws DAOException
	 */
	public int modifyBaplieCusResByCntr(UsaRcvMsgVO usaRcvMsgVO) {
		int result = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new UsaCustomsTransmissionDBDAOmodifyBaplieCusResByCntrUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to UPDATE SQL");

		}
		catch (Exception ex)
		{
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return result;
	}

	/**
	 * STOWAGE CNTR 테이블 수신 메소드 수행
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int result
	 * @throws DAOException
	 */
	public int modifyBaplieCusResByVvd(UsaRcvMsgVO usaRcvMsgVO) {
		int result = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new UsaCustomsTransmissionDBDAOmodifyBaplieCusResByVvdUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to UPDATE SQL");

		}
		catch (Exception ex)
		{
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return result;
	}

	/**
	 * 수신 msg 의 ORG_FF_REF_NO로 관련 데이터 구한다.<br>
	 *
	 * @param String orgRefNo
	 * @return UsaRcvMsgVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public UsaRcvMsgVO searchCusResDataBySndId(String orgRefNo) throws DAOException {
		List<UsaRcvMsgVO> list = null;
		UsaRcvMsgVO orgRefVO = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (orgRefNo != null)
			{
				param.put("crr_bat_no", orgRefNo);
				velParam.put("crr_bat_no", orgRefNo);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchCusResDataBySndIdRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaRcvMsgVO.class);
			if (list != null && list.size() > 0)
			{
				orgRefVO = list.get(0);
			}
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return orgRefVO;
	}

	/**
	 * 유져의 MI - MULTI 권한을 조회한다.<br>
	 *
	 * @param String userId
	 * @return String
	 * @exception DAOException
	 */
	public String searchUserAuthMiMultiYn(String userId) throws DAOException {
		DBRowSet dbRowset = null;
		String retVal = "N";

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (userId != null)
			{
				param.put("usr_id", userId);
				velParam.put("usr_id", userId);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchUserAuthMiMultiYnRSQL(), param, velParam);

			if (dbRowset.getRowCount() > 0)
			{
				if (dbRowset.next())
				{
					retVal = dbRowset.getString(1);
				}
			}
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVal;
	}

	/**
	 * BUF27 존재시 N00를 조사
	 *
	 * @param String blNo
	 * @return List<UsaCustomerInfoVO>
	 * @throws DAOException
	 */
	public List<UsaCustomerInfoVO> searchCstmsPartyInfo(String blNo) throws DAOException {
		List<UsaCustomerInfoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchCstmsPartyInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaCustomerInfoVO.class);
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
	 * vvd, pol, port값으로 CstmsPortTmlCd값을 조회한다.
	 *
	 * @param String vvdCd
	 * @param String polCd
	 * @param String podCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchCstmsPortTmlCd(String vvdCd, String polCd,String podCd) throws DAOException {
		String retVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			velParam.put("vvd", vvdCd);
			param.put("vvd", vvdCd);
			velParam.put("pod_cd", podCd);
			param.put("pod_cd", podCd);
			velParam.put("pol_cd", polCd);
			param.put("pol_cd", polCd);

			if("".equals(polCd) || polCd == null){
				velParam.put("pre_pol_cd", "");
				param.put("pre_pol_cd", "");
			}else{
				velParam.put("pre_pol_cd", polCd.substring(0,2).toUpperCase());
				param.put("pre_pol_cd", polCd.substring(0,2).toUpperCase());
			}

			if("".equals(podCd) || podCd == null){
				velParam.put("pre_pod_cd", "");
				param.put("pre_pod_cd", "");
			}else{
				velParam.put("pre_pod_cd", podCd.substring(0,2).toUpperCase());
				param.put("pre_pod_cd", podCd.substring(0,2).toUpperCase());
			}


			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchCstmsPortTmlCdRSQL(), param, velParam);
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
	 * searchEmlNtfcBlInfo
	 *
	 * @param usaRcvMsgVO
	 * @return
	 * @throws DAOException
	 */
	public EmlNtfcBlInfoVO searchEmlNtfcBlInfo(UsaRcvMsgVO usaRcvMsgVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		EmlNtfcBlInfoVO emlNtfcBlInfoVO = new EmlNtfcBlInfoVO();
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchEmlNtfcBlInfoRSQL(), param, velParam);
			List<EmlNtfcBlInfoVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, EmlNtfcBlInfoVO.class);
			if (list != null && list.size() > 0)
			{
				emlNtfcBlInfoVO = list.get(0);
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
		return emlNtfcBlInfoVO;
	}

	/**
	 * crr_bat_no 로 BL정보 조회
	 * @param crrBatNo
	 * @return
	 * @throws DAOException
	 */
	public List<CndCstmsBlByKeyVO> searchBlForCrrBatNo(String crrBatNo) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		List<CndCstmsBlByKeyVO> list = null;
		try
		{
			param.put("crr_bat_no", crrBatNo);
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchBlForCrrBatNoRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CndCstmsBlByKeyVO.class);
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
	 * AUTO HI전송인지 여부에 따라서 해당 MI전송 LOG도 Auto Check Update한다.<br>
	 *
	 * @param usaRcvMsgVO
	 * @throws DAOException
	 */
	public void modifyAdvSndLog(UsaRcvMsgVO usaRcvMsgVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOmodifyAdvSndLogUSQL(), param, velParam);
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
	 * BL Info
	 * @param blNo
	 * @param trsmMsgTpCd
	 * @return
	 * @throws DAOException
	 */
	public BlLineInfoVO searchBlInfo(String blNo, String trsmMsgTpCd) throws DAOException {
		BlLineInfoVO blLineInfoVO = null;
		try
		{
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			param.put("bl_no", blNo);
			param.put("trsm_msg_tp_cd", trsmMsgTpCd);
			velParam.putAll(param);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchBlInfoRSQL(), param, velParam);
			List list = (List) RowSetUtil.rowSetToVOs(dbRowset, BlLineInfoVO.class);
			if (list.size() > 0)
			{
				blLineInfoVO = (BlLineInfoVO)list.get(0);
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
		return blLineInfoVO;
	}

	/**
	 * Customer Info
	 * @param blNo
	 * @return
	 * @throws DAOException
	 */
	public CustLineInfoVO searchCustInfo(String blNo) throws DAOException {
		CustLineInfoVO custLineInfoVO = null;
		try
		{
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			param.put("bl_no", blNo);
			velParam.putAll(param);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchCustInfoRSQL(), param, velParam);
			List list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustLineInfoVO.class);
			if (list.size() > 0)
			{
				custLineInfoVO = (CustLineInfoVO)list.get(0);
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
		return custLineInfoVO;
	}

	/**
	 * CNTR Info
	 * @param blNo
	 * @return
	 * @throws DAOException
	 */
	public List<CntrLineInfoVO> searchCntrInfo(String blNo) throws DAOException {
		List<CntrLineInfoVO> list = null;
		try
		{
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			param.put("bl_no", blNo);
			velParam.putAll(param);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchCntrInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CntrLineInfoVO.class);

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
	 * BKG_CSTMS_ADV_EDI_BL_RSPN 테이블에 CRR_BAT_NO 등을 삽입한다.<br>
	 *
	 * @param sendingLogVOs
	 * @throws DAOException
	 */
	public void addBkgCstmsAdvEdiBlRspn(List<SendingLogVO> sendingLogVOs) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			if (sendingLogVOs != null && sendingLogVOs.size() > 0)
			{
				int updCnt[] = null;
				updCnt = sqlExe.executeBatch((ISQLTemplate) new UsaCustomsTransmissionDBDAOaddBkgCstmsAdvEdiBlRspnCSQL(), sendingLogVOs, null);
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
	 * W01 Reject 의 경우 Email Notification 대상 BL정보조회
	 * @param blNo
	 * @param crrBatNo
	 * @return
	 * @throws DAOException
	 */
	public List<EmlNtfcBlInfoVO> searchEmlNtfcW01Info(String blNo, String crrBatNo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<EmlNtfcBlInfoVO> list = null;
		try
		{
			param.put("bl_no", blNo);
			param.put("crr_bat_no", crrBatNo);
			velParam.putAll(param);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchEmlNtfcW01InfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EmlNtfcBlInfoVO.class);

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
	 * bkg_cstms_adv_bl 정보를 조회한다.
	 *
	 * @param usaRcvMsgVO
	 * @return List<BkgCstmsAdvBlVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCstmsAdvBlVO> searchAdvCntr(UsaRcvMsgVO usaRcvMsgVO) {
		List<BkgCstmsAdvBlVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchAdvCntrRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsAdvBlVO.class);
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return list;
	}

	/**
	 * 1C의 경우 1X로 인한 HOLD CODE 여부판단
	 * @param blNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchCFlag1X1C(String blNo) {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("bl_no", blNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOsearchCFlag1X1CRSQL(), param, velParam);
			if (dbRowset.next())
			{
				return dbRowset.getString(1);
			}
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return "";
	}
}