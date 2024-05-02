/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : USA404EDIStatusInquiryDBDAO.java
 *@FileTitle : USA 404 EDI Status Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-11-28
 *@LastModifier : kim_sang_geun
 *@LastVersion : 1.0
 * 2006-11-28 kim_sang_geun
 * 1.0 최초 생성
 * N200902230090 2009-03-10 [EDI] 미주 Rail 998, 404 FF 통합
 * N200903170080 2009-03-27 [EDI] CPRS 404 EDI 보완 요청
 * N200903260080 2009-04-07 [TRS-US Rail] AES No 관련 보완 요청
 * N200904030180 2009-04-15 [TRS_Rail EDI] DG 관련 항목 추가 및 Shipper 정보 누락관련 보완요청
 * N200904290040 2009-05-15 [EDI-TRS] Rail EDI (404) CUST 정보 보완요청
 * N200905250130 [TRS]US RAIL EDI 발송시 RF CNTR Temp 체크 로직 추가
 * N200905270080 [TRS]US RAIL EDI  DG CGO에 대한 Flash point 추가 전송관련 보완
 * N200906020130 2009-06-09 [TRS-Rail EDI] DG 정보 오전송에 따른 보완
 * S1L-09U-003 2009-06-10 Rail Export Cargo Available Return Time 개발
 * N200906100030 2009-06-15 [EDI-TRS/Dom. EDI-404] Rail Interchage에 대한 Contract no 보완
 * 1.46 2010.11.23 이재위 [] [TRS] OPMS Design/Development Verification 을 위한 소스 점검
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.trs.common.util.CommonUtil;
import com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.basic.USA404EDIStatusInquiryBCImpl;
import com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.event.EsdTrs0026Event;
import com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.event.EsdTrs0027Event;
import com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.event.EsdTrs0028Event;
import com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.vo.MessageEdiSendInfoVO;
import com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.vo.Multi01USA404EDIStatusInquiryVO;
import com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.vo.TrsTrspRailBilVndrSetVO;
import com.clt.bizcommon.edi.broker.ReferenceNumberGeneratorBroker;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.TrsTrspCfmMsgHisVO;
import com.clt.syscommon.common.table.TrsTrspEdiRailOrdVO;

/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * @author kim_sang_geun
 * @see USA404EDIStatusInquiryBCImpl 참조
 * @since J2EE 1.4
 */
public class USA404EDIStatusInquiryDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = -4251774965921596626L;

	/**
	 * USA404EDIStatusInquiry의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchUSA404EDIStatusInquiry(EsdTrs0028Event event) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		ArrayList<String> st = null;
		List<String> vvd = new ArrayList<String>();
		List<String> bkg = new ArrayList<String>();
		List<String> bl = new ArrayList<String>();
		List<String> cntr = new ArrayList<String>();
		List<String> refNo = new ArrayList<String>();
		try {
			Map<String, String> mapVO = event.getColumnValues();
			param.putAll(mapVO);
			if (event != null && !"".equals(event.getTrunkVvd())) {
				st = CommonUtil.seperationParameter(event.getTrunkVvd(), ",");
				vvd.addAll(st);
			}
			param.put("vvd", vvd);
			if (event != null && !"".equals(event.getBkgNo())) {
				st = CommonUtil.seperationParameter(event.getBkgNo(), ",");
				bkg.addAll(st);
			}
			param.put("bkg", bkg);

			if (event != null && !"".equals(event.getBillNo())) {
				st = CommonUtil.seperationParameter(event.getBillNo(), ",");
				bl.addAll(st);
			}
			param.put("bl", bl);

			if (event != null && !"".equals(event.getCntrNo())) {
				st = CommonUtil.seperationParameter(event.getCntrNo(), ",");
				cntr.addAll(st);
			}
			param.put("cntr", cntr);

			if (event != null && !"".equals(event.getRefNo())) {
				st = CommonUtil.seperationParameter(event.getRefNo(), ",");
				refNo.addAll(st);
			}
			param.put("ref_no", refNo);
			String podN = "";
			if (event.getPodCd() != null) {
				podN = JSPUtil.getNullNoTrim(event.getPodCd());
				if (event.getPodNodCd() != null) {
					podN += JSPUtil.getNullNoTrim(event.getPodNodCd());
				}
			}
			param.put("pod_n", podN);
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new USA404EDIStatusInquiryDBDAOSearchUsa404EdiStatusInquiryBkgRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}

	/**
	 * USA404EDIStatusInquiry의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 404EDI Send
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet search02USA404EDIStatusInquiry(EsdTrs0028Event event) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			Map<String, String> condiParams = event.getColumnValues();
			param.put("trsp_so_ofc_cty_cd", condiParams.get("f_trsp_so_ofc_cty_cd"));
			param.put("trsp_so_seq", condiParams.get("f_trsp_so_seq"));
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new USA404EDIStatusInquiryDBDAOSearch02USA404EDIStatusInquiryRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}

	/**
	 * USA404EDIStatusInquiry의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 404EDI Send
	 * @param list
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet search03USA404EDIStatusSend(List<Object> list) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (list.size() > 0) {
				param.put("strsp_edi_snd_no", list.size() > 0 ? String.valueOf(list.get(0)) : "");
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new USA404EDIStatusInquiryDBDAOSearch03USA404EDIStatusSendRSQL(), param, null);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}

	/**
	 * USA404EDIStatusInquiry의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 404EDI Send
	 * @param param
	 * @param velParam
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet search03SubUSA404EDIStatusSend(Map<String, Object> param, Map<String, Object> velParam) throws DAOException {
		DBRowSet dbRowset = null;
		try {
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new USA404EDIStatusInquiryDBDAOSearch03SubUSA404EDIStatusSendRSQLRSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}

	/**
	 * USA404EDIStatusInquiry의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 404EDI Send
	 * @param list
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchUS404EDIResendList(List<Object> list) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("strsp_edi_snd_no", list.size() > 0 ? String.valueOf(list.get(0)) : "");
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new USA404EDIStatusInquiryDBDAOSearch03USA404EDIResendListRSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}

	/**
	 * USA404EDIStatusInquiry의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 404EDI Send Cancel
	 * @param list
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet search04USA404EDIStatusSend(List<Object> list) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("strsp_edi_snd_no", list.size() > 0 ? String.valueOf(list.get(0)) : "");
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new USA404EDIStatusInquiryDBDAOSearch04USA404EDIStatusSendRSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}

	/**
	 * USA404EDIStatusInquiry의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList multiTrsTrspEdiRailOrderVos(EsdTrs0028Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = null;
		DBRowSet dbRowSet = null;
		ArrayList arr_edi_snd_no = new ArrayList();
		List<TrsTrspEdiRailOrdVO> trsTrspEdiRailOrdVoListFull = new ArrayList<TrsTrspEdiRailOrdVO>();
		List<TrsTrspEdiRailOrdVO> trsTrspEdiRailOrdVoListEmpty = new ArrayList<TrsTrspEdiRailOrdVO>();

		TrsTrspEdiRailOrdVO[] model = event.getTrsTrspEdiRailOrdVOS();
		SQLExecuter sqlExecuter = new SQLExecuter();

		int insCnt[] = null;
		int q = 1;
		int z = 0;
		int r = 0;

		String sso_seq = "";
		String strsp_edi_snd_no = null;
		try {
			strsp_edi_snd_no = event.getUserId() + "" + (new SimpleDateFormat("yyyyMMddssSS").format(new Date()));
			arr_edi_snd_no.add(z++, strsp_edi_snd_no);
			mapVO = event.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("strsp_edi_snd_no", strsp_edi_snd_no);
			velParam.put("strsp_edi_snd_no", strsp_edi_snd_no);

			for (int i = 0; i < model.length; i++) {
				if (model[i].getIbflag().equals("I")) {
					changeChkRailSoStsCd(model[i].getColumnValues());

					r++;
					if (sso_seq.equals(model[i].getTrspSoSeq())) {
						q++;
					} else {
						q = 1;
					}
					dbRowSet = sqlExecuter.executeQuery(new USA404EDIStatusInquiryDBDAOSearchZeroRateVendorRSQL(), model[i].getColumnValues(), null);
					if (dbRowSet.getRowCount() > 0) {
						if (dbRowSet.next()) {
							throw new Exception(new ErrorHandler("TRS00062", new String[] { dbRowSet.getString("eq_no"), dbRowSet.getString("vndr_abbr_nm") }).getMessage());
						}
					}
					model[i].setBilIssKnt(Integer.toString(q));
					sso_seq = model[i].getTrspSoSeq();
					if ("F".equals(model[i].getCgoTpCd())) {
						trsTrspEdiRailOrdVoListFull.add(model[i]);
					} else {
						trsTrspEdiRailOrdVoListEmpty.add(model[i]);
					}
				}
			}

			if (trsTrspEdiRailOrdVoListFull.size() > 0) {
				insCnt = sqlExecuter.executeBatch((ISQLTemplate) new USA404EDIStatusInquiryDBDAOInsert404EdiRailOrdCSQL(), trsTrspEdiRailOrdVoListFull, param, velParam);
				for (int j = 0; j < insCnt.length; j++) {
					if (insCnt[j] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + j + " SQL");
				}

				insCnt = sqlExecuter.executeBatch((ISQLTemplate) new USA404EDIStatusInquiryDBDAOUpdate404EdiRailOrdUSQL(), trsTrspEdiRailOrdVoListFull, param, velParam);
				for (int j = 0; j < insCnt.length; j++) {
					if (insCnt[j] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + j + " SQL");
				}

				insCnt = sqlExecuter.executeBatch((ISQLTemplate) new USA404EDIStatusInquiryDBDAOInsert404EdiTempCSQL(), trsTrspEdiRailOrdVoListFull, param, velParam);
				for (int j = 0; j < insCnt.length; j++) {
					if (insCnt[j] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + j + " SQL");
				}
			}

			if (trsTrspEdiRailOrdVoListEmpty.size() > 0) {
				insCnt = sqlExecuter.executeBatch((ISQLTemplate) new USA404EDIStatusInquiryDBDAOInsert404EdiRailOrdCSQL(), trsTrspEdiRailOrdVoListEmpty, param, velParam);
				for (int j = 0; j < insCnt.length; j++) {
					if (insCnt[j] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + j + " SQL");
				}

				insCnt = sqlExecuter.executeBatch((ISQLTemplate) new USA404EDIStatusInquiryDBDAOUpdateEqrRepoIfUSQL(), trsTrspEdiRailOrdVoListEmpty, param, velParam);
				for (int j = 0; j < insCnt.length; j++) {
					if (insCnt[j] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + j + " SQL");
				}

				insCnt = sqlExecuter.executeBatch((ISQLTemplate) new USA404EDIStatusInquiryDBDAOUpdate404EdiRailOrd2USQL(), trsTrspEdiRailOrdVoListEmpty, param, velParam);
				for (int j = 0; j < insCnt.length; j++) {
					if (insCnt[j] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + j + " SQL");
				}

				insCnt = sqlExecuter.executeBatch((ISQLTemplate) new USA404EDIStatusInquiryDBDAOInsert404EdiTempCSQL(), trsTrspEdiRailOrdVoListEmpty, param, velParam);
				for (int j = 0; j < insCnt.length; j++) {
					if (insCnt[j] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + j + " SQL");
				}
			}
			arr_edi_snd_no.add(z++, String.valueOf(r));
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return arr_edi_snd_no;
	}

	/**
	 * USA404EDIStatusInquiry의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList modifyUS404EDIResendRailBilOrd(EsdTrs0028Event event) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<TrsTrspEdiRailOrdVO> trsTrspEdiRailOrdVoList = new ArrayList<TrsTrspEdiRailOrdVO>();
		List<TrsTrspEdiRailOrdVO> trsTrspEdiRailOrdVoListWo = new ArrayList<TrsTrspEdiRailOrdVO>();
		List<TrsTrspEdiRailOrdVO> trsTrspEdiRailOrdVoListIns = new ArrayList<TrsTrspEdiRailOrdVO>();
		List<TrsTrspEdiRailOrdVO> trsTrspEdiRailOrdVoListUpd = new ArrayList<TrsTrspEdiRailOrdVO>();

		TrsTrspEdiRailOrdVO[] model = event.getTrsTrspEdiRailOrdVOS();

		int insCnt[] = null;
		int r = 0;

		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddssSS");
		String sdateformat = sf.format(new Date());
		String strsp_edi_snd_no = event.getUserId() + "" + sdateformat;

		ArrayList arr_edi_snd_no = new ArrayList();
		arr_edi_snd_no.add(0, strsp_edi_snd_no);

		try {
			Map<String, String> mapVO = event.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			param.put("strsp_edi_snd_no", strsp_edi_snd_no);
			velParam.put("strsp_edi_snd_no", strsp_edi_snd_no);

			for (int i = 0; i < model.length; i++) {
				if (model[i].getIbflag().equals("I")) {
					r++;

					trsTrspEdiRailOrdVoList.add(model[i]);
				}

				if ("I".equals(model[i].getBilIssStsCd())) {
					trsTrspEdiRailOrdVoListWo.add(model[i]);
				} else {
					param.put("trspSoOfcCtyCd", model[i].getTrspSoOfcCtyCd());
					param.put("trspSoSeq", model[i].getTrspSoSeq());

					velParam.put("trspSoOfcCtyCd", model[i].getTrspSoOfcCtyCd());
					velParam.put("trspSoSeq", model[i].getTrspSoSeq());

					dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new USA404EDIStatusInquiryDBDAOSearch404EdiResendSoRSQL(), param, velParam);

					if (dbRowset != null && dbRowset.next()) {
						if (dbRowset.getString(1).equals("0")) {
							trsTrspEdiRailOrdVoListIns.add(model[i]);
						} else {
							trsTrspEdiRailOrdVoListUpd.add(model[i]);
						}
					}
				}
			}

			if (trsTrspEdiRailOrdVoList.size() > 0) {
				// USA404EDIStatusInquiryDBDAOInsert404EdiResendTrsTrspEdiTmpCSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate) new USA404EDIStatusInquiryDBDAOInsert404EdiResendTrsTrspEdiTmpCSQL(), trsTrspEdiRailOrdVoList, param, velParam);
				for (int j = 0; j < insCnt.length; j++) {
					if (insCnt[j] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + j + " SQL");
				}
			}

			if (trsTrspEdiRailOrdVoListWo.size() > 0) {
				// USA404EDIStatusInquiryDBDAOUpdate404EdiResendTrsTrspEdiRailOrdUSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate) new USA404EDIStatusInquiryDBDAOUpdate404EdiResendTrsTrspEdiRailOrdUSQL(), trsTrspEdiRailOrdVoListWo, param, velParam);
				for (int j = 0; j < insCnt.length; j++) {
					if (insCnt[j] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + j + " SQL");
				}
			}

			if (trsTrspEdiRailOrdVoListUpd.size() > 0) {
				// USA404EDIStatusInquiryDBDAOUpdate404EdiResendTrsTrspEdiRailOrdUSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate) new USA404EDIStatusInquiryDBDAOUpdate404EdiResendSoUSQL(), trsTrspEdiRailOrdVoListUpd, param, velParam);
				for (int j = 0; j < insCnt.length; j++) {
					if (insCnt[j] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + j + " SQL");
				}
			}

			if (trsTrspEdiRailOrdVoListIns.size() > 0) {
				// USA404EDIStatusInquiryDBDAOUpdate404EdiResendTrsTrspEdiRailOrdUSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate) new USA404EDIStatusInquiryDBDAOInsert404EdiResendSoCSQL(), trsTrspEdiRailOrdVoListIns, param, velParam);
				for (int j = 0; j < insCnt.length; j++) {
					if (insCnt[j] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + j + " SQL");
				}
			}

			arr_edi_snd_no.add(1, String.valueOf(r));

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return arr_edi_snd_no;
	}

	/**
	 * @param event
	 * @throws DAOException
	 */
	public void multiRollbackTrsTrspEdiRailOrderVos(EsdTrs0028Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<TrsTrspEdiRailOrdVO> trsTrspEdiRailOrdVoList = new ArrayList<TrsTrspEdiRailOrdVO>();
		TrsTrspEdiRailOrdVO[] model = event.getTrsTrspEdiRailOrdVOS();
		int insCnt[] = null;
		try {
			Map<String, String> mapVO = event.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			for (int i = 0; i < model.length; i++) {
				if (model[i].getIbflag().equals("I")) {
					trsTrspEdiRailOrdVoList.add(model[i]);
				}
			}
			if (trsTrspEdiRailOrdVoList.size() > 0) {
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate) new USA404EDIStatusInquiryDBDAOMulti404EdiRollbackUSQL(), trsTrspEdiRailOrdVoList, param, velParam);
				for (int j = 0; j < insCnt.length; j++) {
					if (insCnt[j] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + j + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}

	}

	/**
	 * @param params
	 * @throws EventException
	 */
	private void changeChkRailSoStsCd(HashMap<String, String> params) throws EventException {
		DBRowSet dbRowSet = null;
		try {
			dbRowSet = new SQLExecuter().executeQuery((ISQLTemplate) new USA404EDIStatusInquiryDBDAOChangeChkRailSoStsCdRSQLRSQL(), params, null);
			if (dbRowSet.next()) {
				if (dbRowSet.getInt(1) > 0) {
					throw new EventException(new ErrorHandler("TRS00061").getMessage());
				}
			}
		} catch (Exception e) {
			throw new EventException(e.getMessage());
		}
	}

	/**
	 * @param event
	 * @throws DAOException
	 */
	public void addUSA404EDIResendRollback(EsdTrs0028Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<TrsTrspEdiRailOrdVO> trsTrspEdiRailOrdVoList = new ArrayList<TrsTrspEdiRailOrdVO>();

		TrsTrspEdiRailOrdVO[] model = event.getTrsTrspEdiRailOrdVOS();

		int insCnt[] = null;

		try {
			Map<String, String> mapVO = event.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			for (int i = 0; i < model.length; i++) {
				if (model[i].getIbflag().equals("I")) {
					trsTrspEdiRailOrdVoList.add(model[i]);
				}
			}

			if (trsTrspEdiRailOrdVoList.size() > 0) {
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate) new USA404EDIStatusInquiryDBDAOUpdateUSA404EdiResendRollbackUSQL(), trsTrspEdiRailOrdVoList, param, velParam);
				for (int j = 0; j < insCnt.length; j++) {
					if (insCnt[j] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + j + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
	}

	/**
	 * USA404EDIStatusInquiry의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * @param event
	 * @throws DAOException
	 */
	public void multi01USA404EDIStatusInquiry(EsdTrs0028Event event) throws DAOException {
		Collection<Multi01USA404EDIStatusInquiryVO> insModels = new ArrayList<Multi01USA404EDIStatusInquiryVO>();
		Multi01USA404EDIStatusInquiryVO[] multiVos = event.getConfirmationMsgSendVos();
		String sSndOfcCd = event.getCtrlOfcCd();
		String sSndUsrId = event.getUserId();
		try {
			if (multiVos != null) {
				for (int i = 0; i < multiVos.length; i++) {
					if (multiVos[i].getIbflag().equals("I")) {
						insModels.add(multiVos[i]);
					}
				}
			}
			Map<String, Object> param_wrk = new HashMap<String, Object>();
			param_wrk.put("snd_ofc_cd", sSndOfcCd);
			param_wrk.put("snd_usr_id", sSndUsrId);

			int[] insCnt = null;
			if (insModels.size() > 0) {
				insCnt = new SQLExecuter("DEFAULT").executeBatch(new USA404EDIStatusInquiryDBDAOMulti01USA404EDIStatusInquiryCSQL(), insModels, param_wrk, param_wrk);
			}
			if (insCnt != null) {
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to INSERT No" + i + " SQL");
					}
				}
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
	}

	/**
	 * USA404EDIStatusInquiry의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 404EDI Cancellation EDI Send
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList multi02TrsTrspEdiRailOrderVos(EsdTrs0028Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<TrsTrspEdiRailOrdVO> trsTrspEdiRailOrdVoListFullRbb = new ArrayList<TrsTrspEdiRailOrdVO>();
		List<TrsTrspEdiRailOrdVO> trsTrspEdiRailOrdVoListFull = new ArrayList<TrsTrspEdiRailOrdVO>();
		List<TrsTrspEdiRailOrdVO> trsTrspEdiRailOrdVoListEmpty = new ArrayList<TrsTrspEdiRailOrdVO>();

		TrsTrspEdiRailOrdVO[] model = event.getTrsTrspEdiRailOrdVOS();

		int insCnt[] = null;
		int q = 1;
		int z = 0;
		int r = 0;

		String sso_seq = "";
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddssSS");
		String sdateformat = sf.format(new Date());
		String strsp_edi_snd_no = event.getUserId() + "" + sdateformat;
		ArrayList arr_edi_snd_no = new ArrayList();
		arr_edi_snd_no.add(z++, strsp_edi_snd_no);
		try {
			Map<String, String> mapVO = event.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			param.put("strsp_edi_snd_no", strsp_edi_snd_no);
			velParam.put("strsp_edi_snd_no", strsp_edi_snd_no);

			for (int i = 0; i < model.length; i++) {
				changeChkRailSoStsCd(model[i].getColumnValues());
				r++;
				if (sso_seq.equals(model[i].getTrspSoSeq())) {
					q++;
				} else {
					q = 1;
				}
				model[i].setBilIssKnt(Integer.toString(q));
				sso_seq = model[i].getTrspSoSeq();

				if ("F".equals(model[i].getCgoTpCd()) && "RBB".equals(model[i].getWoRjctRsn())) {
					trsTrspEdiRailOrdVoListFullRbb.add(model[i]);
				} else if ("F".equals(model[i].getCgoTpCd()) && !"RBB".equals(model[i].getWoRjctRsn())) {
					trsTrspEdiRailOrdVoListFull.add(model[i]);
				} else {
					trsTrspEdiRailOrdVoListEmpty.add(model[i]);
				}
			}

			if (trsTrspEdiRailOrdVoListFullRbb.size() > 0) {
				param.put("woRjctRsn", "RBB");
				velParam.put("woRjctRsn", "RBB");

				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate) new USA404EDIStatusInquiryDBDAOInsert404EdiRailOrd2CSQL(), trsTrspEdiRailOrdVoListFullRbb, param, velParam);
				for (int j = 0; j < insCnt.length; j++) {
					if (insCnt[j] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + j + " SQL");
				}

				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate) new USA404EDIStatusInquiryDBDAOInsert404EdiTemp2CSQL(), trsTrspEdiRailOrdVoListFullRbb, param, velParam);
				for (int j = 0; j < insCnt.length; j++) {
					if (insCnt[j] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + j + " SQL");
				}
			}

			if (trsTrspEdiRailOrdVoListFull.size() > 0) {
				param.put("woRjctRsn", "");
				velParam.put("woRjctRsn", "");

				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate) new USA404EDIStatusInquiryDBDAOInsert404EdiRailOrd2CSQL(), trsTrspEdiRailOrdVoListFull, param, velParam);
				for (int j = 0; j < insCnt.length; j++) {
					if (insCnt[j] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + j + " SQL");
				}

				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate) new USA404EDIStatusInquiryDBDAOInsert404EdiTemp2CSQL(), trsTrspEdiRailOrdVoListFull, param, velParam);
				for (int j = 0; j < insCnt.length; j++) {
					if (insCnt[j] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + j + " SQL");
				}

				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate) new USA404EDIStatusInquiryDBDAOUpdate404EdiRailOrd4USQL(), trsTrspEdiRailOrdVoListFull, param, velParam);
				for (int j = 0; j < insCnt.length; j++) {
					if (insCnt[j] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + j + " SQL");
				}
			}

			if (trsTrspEdiRailOrdVoListEmpty.size() > 0) {
				param.put("woRjctRsn", "");
				velParam.put("woRjctRsn", "");
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate) new USA404EDIStatusInquiryDBDAOInsert404EdiRailOrd2CSQL(), trsTrspEdiRailOrdVoListEmpty, param, velParam);
				for (int j = 0; j < insCnt.length; j++) {
					if (insCnt[j] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + j + " SQL");
				}

				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate) new USA404EDIStatusInquiryDBDAOUpdateEqrRepoIf2USQL(), trsTrspEdiRailOrdVoListEmpty, param, velParam);
				for (int j = 0; j < insCnt.length; j++) {
					if (insCnt[j] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + j + " SQL");
				}

				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate) new USA404EDIStatusInquiryDBDAOInsert404EdiTemp2CSQL(), trsTrspEdiRailOrdVoListEmpty, param, velParam);
				for (int j = 0; j < insCnt.length; j++) {
					if (insCnt[j] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + j + " SQL");
				}

				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate) new USA404EDIStatusInquiryDBDAOUpdate404EdiRailOrd4USQL(), trsTrspEdiRailOrdVoListEmpty, param, velParam);
				for (int j = 0; j < insCnt.length; j++) {
					if (insCnt[j] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + j + " SQL");
				}
			}
			arr_edi_snd_no.add(z++, String.valueOf(r));
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return arr_edi_snd_no;
	}

	/**
	 * USA404EDIStatusInquiry의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 404EDI Cancellation EDI Send
	 * @param event
	 * @throws DAOException
	 */
	public void multi02TrsTrspEdiRailOrderVoRbb(EsdTrs0028Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<TrsTrspEdiRailOrdVO> trsTrspEdiRailOrdVoListFullRbb = new ArrayList<TrsTrspEdiRailOrdVO>();
		TrsTrspEdiRailOrdVO[] model = event.getTrsTrspEdiRailOrdVOS();
		int insCnt[] = null;
		try {
			Map<String, String> mapVO = event.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			for (int i = 0; i < model.length; i++) {
				if ("F".equals(model[i].getCgoTpCd()) && "RBB".equals(model[i].getWoRjctRsn())) {
					trsTrspEdiRailOrdVoListFullRbb.add(model[i]);
				}
			}
			if (trsTrspEdiRailOrdVoListFullRbb.size() > 0) {
				param.put("woRjctRsn", "RBB");
				velParam.put("woRjctRsn", "RBB");

				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate) new USA404EDIStatusInquiryDBDAOUpdate404EdiRailOrd4USQL(), trsTrspEdiRailOrdVoListFullRbb, param, velParam);
				for (int j = 0; j < insCnt.length; j++) {
					if (insCnt[j] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + j + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
	}

	/**
	 * USA404EDIStatusInquiry의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 404EDI Cancellation EDI Send
	 * @param event
	 * @param h
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList multi02TrsTrspEdiRailOrderVoForSpp(EsdTrs0028Event event, int h) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<TrsTrspEdiRailOrdVO> trsTrspEdiRailOrdVoListFullRbb = new ArrayList<TrsTrspEdiRailOrdVO>();
		List<TrsTrspEdiRailOrdVO> trsTrspEdiRailOrdVoListFull = new ArrayList<TrsTrspEdiRailOrdVO>();
		List<TrsTrspEdiRailOrdVO> trsTrspEdiRailOrdVoListEmpty = new ArrayList<TrsTrspEdiRailOrdVO>();

		TrsTrspEdiRailOrdVO[] model = event.getTrsTrspEdiRailOrdVOS();

		int insCnt[] = null;
		int q = 1;
		int z = 0;
		int r = 0;

		String sso_seq = "";
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddssSS"); // "MMMddyy"
		String sdateformat = sf.format(new Date());
		String strsp_edi_snd_no = event.getUserId() + "" + sdateformat; // TRSP_EDI_SND_NO

		ArrayList arr_edi_snd_no = new ArrayList(); // TRSP SO SEQ를 넘기기 위한 객체
		arr_edi_snd_no.add(z++, strsp_edi_snd_no);

		try {
			Map<String, String> mapVO = event.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			param.put("strsp_edi_snd_no", strsp_edi_snd_no);
			velParam.put("strsp_edi_snd_no", strsp_edi_snd_no);

			r++;

			if (sso_seq.equals(model[h].getTrspSoSeq())) {
				q++;
			} else
				q = 1;

			model[h].setBilIssKnt(Integer.toString(q));
			sso_seq = model[h].getTrspSoSeq();

			if ("F".equals(model[h].getCgoTpCd()) && "RBB".equals(model[h].getWoRjctRsn())) {
				trsTrspEdiRailOrdVoListFullRbb.add(model[h]);
			} else if ("F".equals(model[h].getCgoTpCd()) && !"RBB".equals(model[h].getWoRjctRsn())) {
				trsTrspEdiRailOrdVoListFull.add(model[h]);
			} else {
				trsTrspEdiRailOrdVoListEmpty.add(model[h]);
			}

			// trsTrspEdiRailOrdVoListFullRbb 수행
			if (trsTrspEdiRailOrdVoListFullRbb.size() > 0) {
				param.put("woRjctRsn", "RBB");
				velParam.put("woRjctRsn", "RBB");

				// USA404EDIStatusInquiryDBDAOInsert404EdiRailOrd2CSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate) new USA404EDIStatusInquiryDBDAOInsert404EdiRailOrd2SPPCSQL(), trsTrspEdiRailOrdVoListFullRbb, param, velParam);
				for (int j = 0; j < insCnt.length; j++) {
					if (insCnt[j] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + j + " SQL");
				}

				// USA404EDIStatusInquiryDBDAOInsert404EdiTemp2CSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate) new USA404EDIStatusInquiryDBDAOInsert404EdiTemp2SPPCSQL(), trsTrspEdiRailOrdVoListFullRbb, param, velParam);
				for (int j = 0; j < insCnt.length; j++) {
					if (insCnt[j] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + j + " SQL");
				}

				// USA404EDIStatusInquiryDBDAOUpdate404EdiRailOrd4USQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate) new USA404EDIStatusInquiryDBDAOUpdate404EdiRailOrd4SPPUSQL(), trsTrspEdiRailOrdVoListFullRbb, param, velParam);
				for (int j = 0; j < insCnt.length; j++) {
					if (insCnt[j] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + j + " SQL");
				}
			}

			// trsTrspEdiRailOrdVoListFull 수행
			if (trsTrspEdiRailOrdVoListFull.size() > 0) {
				param.put("woRjctRsn", "");
				velParam.put("woRjctRsn", "");

				// USA404EDIStatusInquiryDBDAOInsert404EdiRailOrd2CSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate) new USA404EDIStatusInquiryDBDAOInsert404EdiRailOrd2SPPCSQL(), trsTrspEdiRailOrdVoListFull, param, velParam);
				for (int j = 0; j < insCnt.length; j++) {
					if (insCnt[j] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + j + " SQL");
				}

				// USA404EDIStatusInquiryDBDAOInsert404EdiTemp2CSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate) new USA404EDIStatusInquiryDBDAOInsert404EdiTemp2SPPCSQL(), trsTrspEdiRailOrdVoListFull, param, velParam);
				for (int j = 0; j < insCnt.length; j++) {
					if (insCnt[j] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + j + " SQL");
				}

				// USA404EDIStatusInquiryDBDAOUpdate404EdiRailOrd4USQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate) new USA404EDIStatusInquiryDBDAOUpdate404EdiRailOrd4SPPUSQL(), trsTrspEdiRailOrdVoListFull, param, velParam);
				for (int j = 0; j < insCnt.length; j++) {
					if (insCnt[j] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + j + " SQL");
				}
			}

			// trsTrspEdiRailOrdVoListEmpty 수행
			if (trsTrspEdiRailOrdVoListEmpty.size() > 0) {
				// USA404EDIStatusInquiryDBDAOInsert404EdiRailOrd2CSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate) new USA404EDIStatusInquiryDBDAOInsert404EdiRailOrd2SPPCSQL(), trsTrspEdiRailOrdVoListEmpty, param, velParam);
				for (int j = 0; j < insCnt.length; j++) {
					if (insCnt[j] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + j + " SQL");
				}

				// USA404EDIStatusInquiryDBDAOUpdateEqrRepoIf2USQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate) new USA404EDIStatusInquiryDBDAOUpdateEqrRepoIf2SPPUSQL(), trsTrspEdiRailOrdVoListEmpty, param, velParam);
				for (int j = 0; j < insCnt.length; j++) {
					if (insCnt[j] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + j + " SQL");
				}

				// USA404EDIStatusInquiryDBDAOInsert404EdiTemp2CSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate) new USA404EDIStatusInquiryDBDAOInsert404EdiTemp2SPPCSQL(), trsTrspEdiRailOrdVoListEmpty, param, velParam);
				for (int j = 0; j < insCnt.length; j++) {
					if (insCnt[j] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + j + " SQL");
				}

				// USA404EDIStatusInquiryDBDAOUpdate404EdiRailOrd4USQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate) new USA404EDIStatusInquiryDBDAOUpdate404EdiRailOrd4SPPUSQL(), trsTrspEdiRailOrdVoListEmpty, param, velParam);
				for (int j = 0; j < insCnt.length; j++) {
					if (insCnt[j] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + j + " SQL");
				}
			}
			arr_edi_snd_no.add(z++, String.valueOf(r));
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return arr_edi_snd_no;
	}

	/**
	 * USA404EDIStatusInquiry의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * @param event
	 * @throws DAOException
	 */
	public void multi03TrsTrspEdiRailOrderVos(EsdTrs0028Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		List<TrsTrspEdiRailOrdVO> updateVoList = new ArrayList<TrsTrspEdiRailOrdVO>();
		TrsTrspEdiRailOrdVO[] model = event.getTrsTrspEdiRailOrdVOS();
		int insCnt[] = null;
		try {
			param.putAll(event.getColumnValues());
			for (int i = 0; i < model.length; i++) {
				updateVoList.add(model[i]);
			}
			if (updateVoList.size() > 0) {
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate) new USA404EDIStatusInquiryDBDAOUpdate404EdiRailOrd3USQL(), updateVoList, param, param);
				for (int j = 0; j < insCnt.length; j++) {
					if (insCnt[j] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to update No" + j + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
	}

	/**
	 * sending (interface) USA404EDIStatusInquiry의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * Correction Search View(Update)
	 * @param sOfc_cty_cd
	 * @param sSo_seq
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList batchUSA404ComfirmedMessageAuto(String sOfc_cty_cd, String sSo_seq) throws DAOException {
		// DB ResultSet
		DBRowSet rs = null;

		ArrayList arrResponse = new ArrayList();

		String strspSoOfcCtyCd = "";
		String strspSoSeq = "";
		String ssndSeq = "";
		String seqNo = "";
		String seqTpszCd = "";
		String sprovVndrSeq = "";
		String sprovUsrId = "";
		String sprovFaxNo = "";
		String sprovEml = "";
		String sshprCustNm = "";
		String sshprFaxNo = "";
		String ssndDt = "";
		String sofcCd = "";
		String screUsrId = "";
		String sprovCfmMzdCd = "";

		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("trspSoOfcCtyCd", sOfc_cty_cd);
			param.put("trspSoSeq", sSo_seq);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			USA404EDIStatusInquiryDBDAObatchUSA404ComfirmedMessageAutoRSQL template = new USA404EDIStatusInquiryDBDAObatchUSA404ComfirmedMessageAutoRSQL();
			rs = sqlExe.executeQuery(template, param, null);

			// 결과를 DBRowset에 담는다.
			Collection<TrsTrspCfmMsgHisVO> insertVoList = new ArrayList<TrsTrspCfmMsgHisVO>();
			while (rs.next()) {
				strspSoOfcCtyCd = rs.getString("TRSP_SO_OFC_CTY_CD");
				strspSoSeq = rs.getString("TRSP_SO_SEQ");
				seqNo = rs.getString("EQ_NO");
				seqTpszCd = rs.getString("EQ_TPSZ_CD");
				sprovVndrSeq = rs.getString("PROV_VNDR_SEQ");
				sprovUsrId = rs.getString("PROV_USR_ID");
				sprovFaxNo = rs.getString("PROV_FAX_NO");
				sprovEml = rs.getString("PROV_EML");
				sshprCustNm = rs.getString("SHPR_CUST_NM");
				sshprFaxNo = rs.getString("SHPR_FAX_NO");
				ssndDt = rs.getString("SND_DT");
				sofcCd = rs.getString("CRE_OFC_CD");
				screUsrId = rs.getString("CRE_USR_ID");
				sprovCfmMzdCd = rs.getString("PROV_CFM_MZD_CD");

				TrsTrspCfmMsgHisVO vo = new TrsTrspCfmMsgHisVO();
				vo.setTrspSoOfcCtyCd(strspSoOfcCtyCd);
				vo.setTrspSoSeq(strspSoSeq);
				vo.setEqNo(seqNo);
				vo.setEqTpszCd(seqTpszCd);
				vo.setRltTrkrSeq(sprovVndrSeq);
				vo.setRltTrkrNm(sprovUsrId);
				vo.setRltTrkrFaxNo(sprovFaxNo);
				vo.setRltTrkrEml(sprovEml);
				vo.setShprCustNm(sshprCustNm);
				vo.setShprFaxNo(sshprFaxNo);
				vo.setSndDt(ssndDt);
				vo.setSndOfcCd(sofcCd);
				vo.setSndUsrId(screUsrId);
				insertVoList.add(vo);

				MessageEdiSendInfoVO esd012_eventResponse = new MessageEdiSendInfoVO();
				esd012_eventResponse.setTrspSoOfcCtyCd(strspSoOfcCtyCd);
				esd012_eventResponse.setTrspSoSeq(strspSoSeq);
				esd012_eventResponse.setSndSeq(ssndSeq);
				esd012_eventResponse.setProvVndrSeq(sprovVndrSeq);
				esd012_eventResponse.setProvUsrId(sprovUsrId);
				esd012_eventResponse.setProvFaxNo(sprovFaxNo);
				esd012_eventResponse.setProvEml(sprovEml);
				esd012_eventResponse.setShprCustNm(sshprCustNm);
				esd012_eventResponse.setShprFaxNo(sshprFaxNo);
				esd012_eventResponse.setSndDt(ssndDt);
				esd012_eventResponse.setOfcCd(sofcCd);
				esd012_eventResponse.setCreUsrId(screUsrId);
				esd012_eventResponse.setProvCfmMzdCd(sprovCfmMzdCd);
				arrResponse.add(esd012_eventResponse);
			}
			if (insertVoList.size() > 0) {
				sqlExe.executeBatch((ISQLTemplate) new USA404EDIStatusInquiryDBDAObatchUSA404ComfirmedMessageAutoCSQL(), insertVoList, null, null);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return arrResponse;
	}

	/**
	 * @return
	 * @throws DAOException
	 */
	public String searchTrsEdiReferenceNo() throws DAOException {
		try {
			return ReferenceNumberGeneratorBroker.getKey("TRS", "TRS_TRSP_EDI_RAIL_ORD_SEQ");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
	}

	/**
	 * @param list
	 * @param cancelFlg
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchFlatFileKleinSchmitRailBill(List<Object> list, String cancelFlg) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();

		String strsp_edi_snd_no = "";
		if (list.size() > 0) {
			strsp_edi_snd_no = String.valueOf(list.get(0));
		}
		try {
			param.put("strsp_edi_snd_no", strsp_edi_snd_no);
			param.put("p_msg_type", cancelFlg);
			// EDI FF 생성
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new USA404EDIStatusInquiryDBDAOsearchFlatFileKleinSchmitRailBillRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}

	/**
	 * Equip
	 * @param paramDbRowSet
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchFlatFileKleinSchmitRailBillEquement(DBRowSet paramDbRowSet) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("trsp_so_ofc_cty_cd", paramDbRowSet.getString("trsp_so_ofc_cty_cd"));
			param.put("trsp_so_seq", paramDbRowSet.getString("trsp_so_seq"));
			param.put("strsp_edi_snd_no", paramDbRowSet.getString("strsp_edi_snd_no"));
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new USA404EDIStatusInquiryDBDAOsearchFlatFileKleinSchmitRailBillEquementRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}

	/**
	 * Detail
	 * @param paramDbRowSet
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchFlatFileKleinSchmitRailBillDetail(DBRowSet paramDbRowSet) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("trsp_so_ofc_cty_cd", paramDbRowSet.getString("trsp_so_ofc_cty_cd"));
			param.put("trsp_so_seq", paramDbRowSet.getString("trsp_so_seq"));
			param.put("eq_no", paramDbRowSet.getString("eq_no"));
			param.put("eq_tpsz_cd", paramDbRowSet.getString("eq_tpsz"));
			param.put("strsp_edi_snd_no", paramDbRowSet.getString("strsp_edi_snd_no"));
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new USA404EDIStatusInquiryDBDAOsearchFlatFileKleinSchmitRailBillDetailRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}

	/**
	 * Address
	 * @param paramDbRowSet
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchFlatFileKleinSchmitRailBillAddress(DBRowSet paramDbRowSet) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("trsp_so_ofc_cty_cd", paramDbRowSet.getString("trsp_so_ofc_cty_cd"));
			param.put("trsp_so_seq", paramDbRowSet.getString("trsp_so_seq"));
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new USA404EDIStatusInquiryDBDAOsearchFlatFileKleinSchmitRailBillAddressRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}

	/**
	 * Danger
	 * @param paramDbRowSet
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchFlatFileKleinSchmitRailBillDanger(DBRowSet paramDbRowSet) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		SQLExecuter sqlExecuter = new SQLExecuter("DEFAULT");
		USA404EDIStatusInquiryDBDAOsearchFlatFileKleinSchmitRailBillDangerRSQL query = new USA404EDIStatusInquiryDBDAOsearchFlatFileKleinSchmitRailBillDangerRSQL();
		try {
			param.put("trsp_so_ofc_cty_cd", paramDbRowSet.getString("trsp_so_ofc_cty_cd"));
			param.put("trsp_so_seq", paramDbRowSet.getString("trsp_so_seq"));
			param.put("f_type", "L");
			dbRowset = sqlExecuter.executeQuery(query, param, param);
			if (dbRowset.getRowCount() <= 0) {
				param.put("f_type", "D");
				dbRowset = sqlExecuter.executeQuery(query, param, param);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}

	/**
	 * Danger-Ref
	 * @param paramDbRowSet
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchFlatFileKleinSchmitRailBillDangerRef(DBRowSet paramDbRowSet) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("trsp_so_ofc_cty_cd", paramDbRowSet.getString("trsp_so_ofc_cty_cd"));
			param.put("trsp_so_seq", paramDbRowSet.getString("trsp_so_seq"));
			param.put("eq_no", paramDbRowSet.getString("eq_no"));
			param.put("eq_tpsz_cd", paramDbRowSet.getString("eq_tpsz"));
			param.put("bkg_no", paramDbRowSet.getString("bkg_no"));
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new USA404EDIStatusInquiryDBDAOsearchFlatFileKleinSchmitRailBillDangerRefRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}

	/**
	 * Danger-Ref
	 * @param vdnrSeq
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchFaxNoVndrEmlByVndrSeq(String vdnrSeq) throws DAOException {
		DBRowSet dbRowset = null;
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("vndr_seq", vdnrSeq);
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new USA404EDIStatusInquiryDBDAOSearchFaxNoVndrEmlByVndrSeqRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}

	/**
	 * @param param
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchUSA404EDICntrSeal(Map<String, Object> param) throws DAOException {
		DBRowSet dbRowset = null;
		try {
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new USA404EDIStatusInquiryDBDAOSearchUSA404EDICntrSealRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}

	/**
	 * 404EDI의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchUSRailMoreCandidates(EsdTrs0026Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		String basis_dt = (String) event.getBasisDt() == null ? "" : JSPUtil.removeCharacter((String) event.getBasisDt(), "-").substring(0, 8);
		param.put("trsp_so_ofc_cty_cd", event.getTrspSoOfcCtyCd()); // OK
		param.put("trsp_so_seq", event.getTrspSoSeq()); // OK
		param.put("ctrl_ofc_cd", event.getCtrlOfcCd());
		param.put("vndr_seq", event.getVndrSeq());
		param.put("basis_dt", basis_dt); // OK
		param.put("eq_knd_cd", event.getEqKndCd());
		param.put("eq_tp_sz_cd", event.getEqTpSzCd()); // OK
		param.put("cmb_tp_cd", event.getCmbTpCd());
		param.put("cgo_tp_cd", event.getCgoTpCd()); // OK
		param.put("bound_cd", event.getBoundCd()); // OK
		param.put("crr_mod_cd", event.getCrrModCd());
		param.put("cost_mod_cd", event.getCostmodCd());
		param.put("cust_cnt_cd", event.getCustCntCd());
		param.put("cust_seq", event.getCustSeq());
		param.put("cmdt_cd", event.getCmdtCd());
		param.put("from_nod_cd", event.getFromNodCd()); // OK
		param.put("via_nod_cd", event.getViaNodCd());
		param.put("door_nod_cd", event.getDoorNodCd());
		param.put("to_nod_cd", event.getToNodCd()); // OK
		param.put("bundle_cnt", event.getBundleCnt());
		param.put("wgt_uom", event.getBundleCnt());
		param.put("wgt_qty", event.getWgtQty()); // OK
		param.put("wo_issued", event.getWoIssued());
		param.put("fm_vndr_prmry_seq", event.getFmVndrPrmrySeq());
		param.put("spcl_cgo_cntr_tp_cd", event.getSpclCgoCntrTpCd());
		param.put("curr_cd", event.getCurrCd());

		param.put("agmt_ofc_cty_cd", event.getAgmtOfcCtyCd()); // OK
		param.put("agmt_seq", event.getAgmtSeq()); // OK

		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new USA404EDIStatusInquiryDBDAOsearchUSRailMoreCandidatesRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return dRs;
	}

	/**
	 * USA404EDIStatusInquiry의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 404EDI Cancellation EDI Send
	 * @param event
	 * @throws DAOException
	 */
	public void multiUSRailMoreCandidates(EsdTrs0026Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		TrsTrspRailBilVndrSetVO[] model = event.getTrsTrspRailBilVndrSetVOs();
		try {
			for (int i = 0; i < model.length; i++) {
				if (model[i].getApplRt() == null || model[i].getApplRt().length() < 1) {
					Map<String, String> mapVO = model[i].getColumnValues();
					param.putAll(mapVO);
					param.put("sUsrId", event.getSignOnUserAccount().getUsr_id());
					param.put("sOfcCd", event.getSignOnUserAccount().getOfc_cd());

					new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new USA404EDIStatusInquiryDBDAOUpdateTrsTrspRailBilVndrSetAplUSQL(), param, param);
				}
			}
			for (int i = 0; i < model.length; i++) {
				if (model[i].getApplRt() != null && model[i].getApplRt().length() > 0) {
					Map<String, String> mapVO = model[i].getColumnValues();
					param.putAll(mapVO);
					param.put("sUsrId", event.getSignOnUserAccount().getUsr_id());
					param.put("sOfcCd", event.getSignOnUserAccount().getOfc_cd());

					new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new USA404EDIStatusInquiryDBDAOUpdateTrsTrspRailBilVndrSetAplUSQL(), param, param);
				}
			}
			param.clear();
			param.put("sUsrId", event.getSignOnUserAccount().getUsr_id());
			param.put("sOfcCd", event.getSignOnUserAccount().getOfc_cd());
			param.put("trsp_so_ofc_cty_cd", model[0].getTrspSoOfcCtyCd());
			param.put("trsp_so_seq", model[0].getTrspSoSeq());
			param.put("sub_rail_seq", model[0].getSubRailSeq());
			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new USA404EDIStatusInquiryDBDAOUpdateTrsTrspRailBilVndrSetUSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
	}

	/**
	 * 404EDI의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchUSRailBasicRates(EsdTrs0027Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		String basis_dt = (String) event.getBasisDt() == null ? "" : JSPUtil.removeCharacter((String) event.getBasisDt(), "-").substring(0, 8);
		param.put("trsp_so_ofc_cty_cd", event.getTrspSoOfcCtyCd()); // OK
		param.put("trsp_so_seq", event.getTrspSoSeq()); // OK
		param.put("ctrl_ofc_cd", event.getCtrlOfcCd());
		param.put("vndr_seq", event.getVndrSeq());
		param.put("basis_dt", basis_dt); // OK
		param.put("eq_knd_cd", event.getEqKndCd());
		param.put("eq_tp_sz_cd", event.getEqTpSzCd()); // OK
		param.put("cmb_tp_cd", event.getCmbTpCd());
		param.put("cgo_tp_cd", event.getCgoTpCd()); // OK
		param.put("bound_cd", event.getBoundCd()); // OK
		param.put("crr_mod_cd", event.getCrrModCd());
		param.put("cost_mod_cd", event.getCostmodCd());
		param.put("cust_cnt_cd", event.getCustCntCd());
		param.put("cust_seq", event.getCustSeq());
		param.put("cmdt_cd", event.getCmdtCd());
		param.put("from_nod_cd", event.getFromNodCd()); // OK
		param.put("via_nod_cd", event.getViaNodCd());
		param.put("door_nod_cd", event.getDoorNodCd());
		param.put("to_nod_cd", event.getToNodCd()); // OK
		param.put("bundle_cnt", event.getBundleCnt());
		param.put("wgt_uom", event.getBundleCnt());
		param.put("wgt_qty", event.getWgtQty()); // OK
		param.put("wo_issued", event.getWoIssued());
		param.put("fm_vndr_prmry_seq", event.getFmVndrPrmrySeq());
		param.put("spcl_cgo_cntr_tp_cd", event.getSpclCgoCntrTpCd());
		param.put("curr_cd", event.getCurrCd());

		param.put("agmt_ofc_cty_cd", event.getAgmtOfcCtyCd()); // OK
		param.put("agmt_seq", event.getAgmtSeq()); // OK

		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new USA404EDIStatusInquiryDBDAOsearchUSRailBasicRatesRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return dRs;
	}

	/**
	 * Trs Trsp Rail Bil Order
	 * @param cntrNo
	 * @param eventDt
	 * @param woNo
	 * @param yardCd
	 * @param mvmtStsCd
	 * @param bkgNo
	 * @param usrId
	 * @param inMvmtCreTpCd
	 * @return
	 * @throws DAOException
	 */
	public int updateWoExeDtExecuteDateByCtm(String cntrNo, String eventDt, String woNo, String yardCd, String mvmtStsCd, String bkgNo, String usrId, String inMvmtCreTpCd) throws DAOException {
		int rvalue = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("cntr_no", cntrNo);
		param.put("wo_exe_dt", eventDt);
		param.put("wo_no", woNo);
		param.put("node_cd", yardCd);
		param.put("mvmt_sts_cd", mvmtStsCd);
		param.put("bkg_no", bkgNo);
		param.put("upd_usr_id", usrId);
		param.put("mvmt_cre_tp_cd", inMvmtCreTpCd);
		try {
			rvalue = new SQLExecuter().executeUpdate((ISQLTemplate) new USA404EDIStatusInquiryDBDAOUpdateWoExeDtExecuteDateByCtmUSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rvalue;
	}

	/**
	 * @param mstDbRowSet
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchBlGrpForCnFF(DBRowSet mstDbRowSet) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("trsp_so_ofc_cty_cd", mstDbRowSet.getString("trsp_so_ofc_cty_cd"));
			param.put("trsp_so_seq", mstDbRowSet.getString("trsp_so_seq"));
			param.put("eq_no", mstDbRowSet.getString("cntr_no_r"));
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new USA404EDIStatusInquiryDBDAOSearchBlGrpForCnFFRSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}

	/**
	 * @param mstDbRowSet
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchCntrMfForCnFF(DBRowSet mstDbRowSet) throws DAOException {
		DBRowSet dbRowset = null;
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("trsp_so_ofc_cty_cd", mstDbRowSet.getString("trsp_so_ofc_cty_cd"));
			param.put("trsp_so_seq", mstDbRowSet.getString("trsp_so_seq"));
			param.put("eq_no", mstDbRowSet.getString("cntr_no_r"));
			param.put("bound_ind", mstDbRowSet.getString("bound_ind"));
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new USA404EDIStatusInquiryDBDAOSearchBlGrpCntrMfForCnFFRSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}
}