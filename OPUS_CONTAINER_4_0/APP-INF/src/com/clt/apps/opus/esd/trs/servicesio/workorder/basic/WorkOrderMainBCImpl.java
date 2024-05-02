/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : WorkOrderMainBCImpl.java
 *@FileTitle : WO Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion :
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.workorder.basic;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.esd.sce.edi315send.basic.Edi315SendBC;
import com.clt.apps.opus.esd.sce.edi315send.basic.Edi315SendBCImpl;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315SendVO;
import com.clt.apps.opus.esd.trs.servicesio.workorder.event.WorkOrderRcvEvent;
import com.clt.apps.opus.esd.trs.servicesio.workorder.integration.WorkOrderMainDBDAO;
import com.clt.apps.opus.esd.trs.servicesio.workorder.vo.JoEdiRcvBodyVo;
import com.clt.apps.opus.esd.trs.servicesio.workorder.vo.JoEdiRcvChargeVo;
import com.clt.apps.opus.esd.trs.servicesio.workorder.vo.JoEdiRcvEqmentVo;
import com.clt.apps.opus.esd.trs.servicesio.workorder.vo.JoEdiRcvStopVo;
import com.clt.apps.opus.esd.trs.servicesio.workorder.vo.SelectTrspSvcOrdInfoVO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.utility.CheckUtilities;

/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author
 * @see WorkOrderMainBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class WorkOrderMainBCImpl extends BasicCommandSupport implements WorkOrderMainBC {
	private transient WorkOrderMainDBDAO woDbdao = null;

	public WorkOrderMainBCImpl() {
		woDbdao = new WorkOrderMainDBDAO();
	}

	/**
	 * NYK-Hawk_FFile(URV_N)-JOEDIACC_IAS_INBOUND
	 * 
	 * @param workOrderRcvEvent
	 * @return int
	 * @throws EventException
	 */
	public int receiveJoEdiAcc(WorkOrderRcvEvent workOrderRcvEvent) throws EventException {
		int r = 0;
		try {
			JoEdiRcvBodyVo joEdiRcvBodyVo = workOrderRcvEvent.getJoEdiRcvBodyVo();
			String joItemRef = joEdiRcvBodyVo.getJoItemRef();
			String[] s = joItemRef.split(Pattern.quote("-"));
			if (s.length > 1) {
				SelectTrspSvcOrdInfoVO svcOrdInfoVO = selectTrspSvcOrdInfo(s);
				if (svcOrdInfoVO != null) {
					addTrsEdiWrkOrdHis(joEdiRcvBodyVo, svcOrdInfoVO, "E");
					r = 1;
				}
			}
			return r;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new EventException(e.getMessage());
		}
	}

	/**
	 * NYK-Hawk_FFile(URV_N)-JOEDIREJ_IAS_INBOUND
	 * 
	 * @param workOrderRcvEvent
	 * @return int
	 * @throws EventException
	 */
	public int receiveJoEdiRej(WorkOrderRcvEvent workOrderRcvEvent) throws EventException {
		int r = 0;
		try {
			JoEdiRcvBodyVo joEdiRcvBodyVo = workOrderRcvEvent.getJoEdiRcvBodyVo();
			if (joEdiRcvBodyVo != null) {
				String joItemRef = joEdiRcvBodyVo.getJoItemRef();
				String[] s = joItemRef.split(Pattern.quote("-"));
				if (s.length > 1) {
					SelectTrspSvcOrdInfoVO svcOrdInfoVO = selectTrspSvcOrdInfo(s);
					if (svcOrdInfoVO != null) {
						addTrsEdiWrkOrdHis(joEdiRcvBodyVo, svcOrdInfoVO, "J");
						r = 1;
					}
				}
			}
			return r;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new EventException(e.getMessage());
		}
	}

	/**
	 * NYK-Hawk_FFile(URV_N)-JOEDIUPDT_IAS_INBOUND
	 * 
	 * @param workOrderRcvEvent
	 * @return int
	 * @throws EventException
	 */
	public int receiveJoEdiUpdt(WorkOrderRcvEvent workOrderRcvEvent) throws EventException {
		int r = 0;
		try {
			JoEdiRcvBodyVo joEdiRcvBodyVo = workOrderRcvEvent.getJoEdiRcvBodyVo();
			if (joEdiRcvBodyVo != null) {
				String joItemRef = joEdiRcvBodyVo.getJoItemRef();
				String[] s = joItemRef.split(Pattern.quote("-"));
				if (s.length > 1) {
					SelectTrspSvcOrdInfoVO svcOrdInfoVO = selectTrspSvcOrdInfo(s);
					if (svcOrdInfoVO != null) {
						addTrsEdiWrkOrdHis(joEdiRcvBodyVo, svcOrdInfoVO, "P");
						r = 1;
					}
				}
			}
			return r;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new EventException(e.getMessage());
		}
	}

	/**
	 * NYK-Hawk_FFile(URV_N)-JOEDIAPPT_IAS_INBOUND
	 * 
	 * @param workOrderRcvEvent
	 * @return int
	 * @throws EventException
	 */
	public int receiveJoEdiAppt(WorkOrderRcvEvent workOrderRcvEvent) throws EventException {
//		BkgCopManageBC command = new BkgCopManageBCImpl();
//		DBRowSet rowSet = null;
		int r = 0;
//		String iBkgNo = "";
//		String iIoBndCd = "";
//		String iPctlNo = "";
//		String iCopNo = "";
//		String iAreaContiCd = "X";
		try {
			JoEdiRcvBodyVo joEdiRcvBodyVo = workOrderRcvEvent.getJoEdiRcvBodyVo();
			if (joEdiRcvBodyVo != null) {
				String joItemRef = joEdiRcvBodyVo.getJoItemRef();
				String[] s = joItemRef.split(Pattern.quote("-"));
				if (s.length > 1) {
					SelectTrspSvcOrdInfoVO svcOrdInfoVO = selectTrspSvcOrdInfo(s);
					if (svcOrdInfoVO != null) {
						addTrsEdiWrkOrdHis(joEdiRcvBodyVo, svcOrdInfoVO, "S");
						String iGateInStart = joEdiRcvBodyVo.getGateInStart();
						if (!CheckUtilities.isInBlank(iGateInStart)) {
							if (iGateInStart.length() < 14) {
								iGateInStart = StringUtils.rightPad(iGateInStart, 14, "0");
							}
							HashMap<String, Object> param = new HashMap<String, Object>();
							param.put("trsp_so_ofc_cty_cd", svcOrdInfoVO.getTrspSoOfcCtyCd());
							param.put("trsp_so_seq", svcOrdInfoVO.getTrspSoSeq());
							param.put("apnt_dt", iGateInStart);

							woDbdao.modifyTrsTrspSvcOrd(param);
//							rowSet = woDbdao.searchTrsSvcOrdForScheduleAppt(param);
//							if (rowSet.next()) {
//								iBkgNo = rowSet.getString("bkg_no");
//								iIoBndCd = rowSet.getString("trsp_bnd_cd");
//								iPctlNo = rowSet.getString("pctl_no");
//								iCopNo = rowSet.getString("cop_no");
//								if (!CheckUtilities.isInBlank(iCopNo)) {
//									command.updateDorArrDtByTrs(iBkgNo, iCopNo, iIoBndCd, iPctlNo, iAreaContiCd, iGateInStart);
//								}
//							}
						}
						r = 1;
					}
				}
			}
			return r;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new EventException(e.getMessage());
		}
	}

	/**
	 * NYK-Hawk_FFile(URV_N)-JOEDIACTL_IAS_INBOUND
	 * 
	 * @param workOrderRcvEvent
	 * @return int
	 * @throws EventException
	 */
	public int receiveJoEdiActl(WorkOrderRcvEvent workOrderRcvEvent) throws EventException {
		Edi315SendBC callSend = new Edi315SendBCImpl();
		DBRowSet rowSet = null;
		int r = 0;
		try {
			JoEdiRcvBodyVo joEdiRcvBodyVo = workOrderRcvEvent.getJoEdiRcvBodyVo();
			if (joEdiRcvBodyVo != null) {
				String joItemRef = joEdiRcvBodyVo.getJoItemRef();
				String[] s = joItemRef.split(Pattern.quote("-"));
				if (s.length > 1) {
					SelectTrspSvcOrdInfoVO svcOrdInfoVO = selectTrspSvcOrdInfo(s);
					if (svcOrdInfoVO != null) {
						addTrsEdiWrkOrdHis(joEdiRcvBodyVo, svcOrdInfoVO, "T");

						String iGateIn = joEdiRcvBodyVo.getGateIn();
						HashMap<String, Object> param = new HashMap<String, Object>();
						param.put("trsp_so_ofc_cty_cd", svcOrdInfoVO.getTrspSoOfcCtyCd());
						param.put("trsp_so_seq", svcOrdInfoVO.getTrspSoSeq());
						param.put("de_dt", iGateIn);
						woDbdao.modifyTrsTrspSvcOrd(param);

						rowSet = woDbdao.searchEdi315SendingList(param);
						if (rowSet.next()) {
							HashMap<String, Object> hh = new HashMap<String, Object>();
							hh.put("cop_no", rowSet.getString("cop_no"));
							hh.put("act_dt", iGateIn);
							hh.put("bnd_cd", rowSet.getString("bnd_cd"));
							hh.put("upd_usr_id", "IAS");
							callSend.updateSceCopDtlActualDateByTrs(hh);

							Edi315SendVO edi315SendVo = new Edi315SendVO();
							edi315SendVo.setCopNo(rowSet.getString("cop_no"));
							edi315SendVo.setCostActGrpSeq(rowSet.getString("cost_act_grp_seq"));
							edi315SendVo.setEdiStatus("D");
							edi315SendVo.setCopCallModule("TRS");
							edi315SendVo.setCreId("IAS");
							edi315SendVo.setUpdId("IAS");
							callSend.edi315Send(edi315SendVo);
						}
						r = 1;
					}
				}
			}
			return r;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new EventException(e.getMessage());
		}
	}

	/**
	 * 
	 * @param joEdiRcvBodyVo
	 * @param svcOrdInfoVO
	 * @param rcvMsgTpCd
	 * @throws EventException
	 */
	private void addTrsEdiWrkOrdHis(JoEdiRcvBodyVo joEdiRcvBodyVo, SelectTrspSvcOrdInfoVO svcOrdInfoVO, String rcvMsgTpCd) throws EventException {
		DBRowSet ds = null;
		try {
			HashMap<String, Object> revParam = new HashMap<String, Object>();
			revParam.put("trsp_so_ofc_cty_cd", svcOrdInfoVO.getTrspSoOfcCtyCd());
			revParam.put("trsp_so_seq", svcOrdInfoVO.getTrspSoSeq());
			revParam.put("trsp_wo_ofc_cty_cd", svcOrdInfoVO.getTrspWoOfcCtyCd());
			revParam.put("trsp_wo_seq", svcOrdInfoVO.getTrspWoSeq());
			revParam.put("rcv_msg_tp_cd", rcvMsgTpCd);
			revParam.put("rcv_msg_seq", woDbdao.selectRcvMsgSeq());
			revParam.put("rcv_msg_sts_cd", "");
			woDbdao.addTrsEdiWrkOrdHis(revParam);
			if ("J".equals(rcvMsgTpCd)) {
				revParam.put("edi_rjct_rsn_cd", CheckUtilities.isNullReplacement(joEdiRcvBodyVo.getReasonCd(), ""));
				woDbdao.addTrsEdiUsaRcvRejectMsg(revParam);
			} else if ("E".equals(rcvMsgTpCd)) {
				revParam.put("trs_sub_sts_cd", "AC");
				woDbdao.insertTrsSubStsHis(revParam);
				woDbdao.modifyTrsTrspSvcOrd(revParam);
			} else if ("P".equals(rcvMsgTpCd)) {
				// Update
				List<JoEdiRcvEqmentVo> joEdiRcvEqmentVos = joEdiRcvBodyVo.getJoEdiRcvEqmentVos();
				List<JoEdiRcvStopVo> joEdiRcvStopVos = joEdiRcvBodyVo.getJoEdiRcvStopVos();
				double amount = 0.0D;
				double fuelRto = 0.0D;
				String currency = "";
				HashMap<String, String> surcharge = new HashMap<String, String>();
				if (joEdiRcvEqmentVos != null) {
					for (JoEdiRcvEqmentVo eqmentVo : joEdiRcvEqmentVos) {
						List<JoEdiRcvChargeVo> chargeVos = eqmentVo.getJoEdiRcvChargeVos();
						if (chargeVos != null) {
							// Charge
							for (JoEdiRcvChargeVo chargeVo : chargeVos) {
								if ("TRCOST".equals(chargeVo.getSvcCd())) {
									amount = Double.parseDouble(CheckUtilities.isNullOrNullStringReplacement(chargeVo.getAmount(), "0"));
									fuelRto = Double.parseDouble(CheckUtilities.isNullOrNullStringReplacement(chargeVo.getFscPercent(), "0"));
									ds = woDbdao.searchSoBasicAndFuelAmt(revParam);
									if (ds.next()) {
										if (Double.compare(amount, ds.getDouble("bzc_amt")) != 0) {
											addTrsEdiUsaRcvMsg(revParam, "Charges", chargeVo.getSvcCd(), chargeVo.getCurrency(), String.valueOf(amount), "", "", "N", String.valueOf(ds.getDouble("bzc_amt")), "", "");
											addTrsEdiUsaRcvMsg(revParam, "Charges", ds.getString("fuel_lgs_cost_cd"), chargeVo.getCurrency(), String.valueOf((amount * fuelRto) / 100), String.valueOf(fuelRto), "", "N", String.valueOf((ds.getDouble("bzc_amt") * fuelRto) / 100),
													String.valueOf(fuelRto), "");
										} else {
											if (Double.compare(fuelRto, ds.getDouble("fuel_rto")) != 0) {
												addTrsEdiUsaRcvMsg(revParam, "Charges", ds.getString("fuel_lgs_cost_cd"), chargeVo.getCurrency(), String.valueOf((amount * fuelRto) / 100), String.valueOf(fuelRto), "", "N", String.valueOf((ds.getDouble("bzc_amt") * ds.getDouble("fuel_rto")) / 100),
														String.valueOf(ds.getDouble("fuel_rto")), "");
											}
										}
									}
								} else {
									if (surcharge.containsKey(chargeVo.getSvcCd())) {
										surcharge.put(chargeVo.getSvcCd(), String.valueOf(Double.parseDouble(surcharge.get(chargeVo.getSvcCd())) + Double.parseDouble(chargeVo.getAmount())));
									} else {
										surcharge.put(chargeVo.getSvcCd(), chargeVo.getAmount());
										currency = chargeVo.getCurrency();
									}
								}
							}
						}

						if (!eqmentVo.getCntrNo().equals(svcOrdInfoVO.getEqNo())) {
							// Equipment
							addTrsEdiUsaRcvMsg(revParam, "Equipment", "EQ", "", "0", "", eqmentVo.getCntrNo(), "N", "", "", svcOrdInfoVO.getEqNo());
						}
					}
				}

				if (!surcharge.isEmpty()) {
					for (String key : surcharge.keySet()) {
						addTrsEdiUsaRcvMsg(revParam, "Charges", key, currency, surcharge.get(key), "", "", "Y", "", "", "");
					}
				}

				if (joEdiRcvStopVos != null) {
					// Stop Info
					for (JoEdiRcvStopVo stopVo : joEdiRcvStopVos) {
						if ("delivery".equalsIgnoreCase(stopVo.getStopTp())) {
							if (!stopVo.getStopContactNm().equals(svcOrdInfoVO.getCntcPsonNm())) {
								addTrsEdiUsaRcvMsg(revParam, "Stop", "CNTCNM", "", "0", "", stopVo.getStopContactNm(), "N", "", "", svcOrdInfoVO.getCntcPsonNm());
							}
							if (!stopVo.getStopContactTe().equals(svcOrdInfoVO.getCntcPsonPhnNo())) {
								addTrsEdiUsaRcvMsg(revParam, "Stop", "CNTCTE", "", "0", "", stopVo.getStopContactTe(), "N", "", "", svcOrdInfoVO.getCntcPsonPhnNo());
							}
						}
					}
				}

				if (!joEdiRcvBodyVo.getBkgNo().equals(svcOrdInfoVO.getBkgNo())) {
					// Booking
					addTrsEdiUsaRcvMsg(revParam, "Reference", "BKG", "", "0", "", joEdiRcvBodyVo.getBkgNo(), "N", "", "", svcOrdInfoVO.getBkgNo());
				}

				if (!joEdiRcvBodyVo.getBlNo().equals(svcOrdInfoVO.getBlNo())) {
					// B/L
					addTrsEdiUsaRcvMsg(revParam, "Reference", "BL", "", "0", "", joEdiRcvBodyVo.getBlNo(), "N", "", "", svcOrdInfoVO.getBlNo());
				}

				if (!joEdiRcvBodyVo.getCutoffDt().equals(svcOrdInfoVO.getCutOffDt())) {
					// Cut-Off Date
					addTrsEdiUsaRcvMsg(revParam, "Dates", "CUTOFF", "", "0", "", joEdiRcvBodyVo.getCutoffDt(), "N", "", "", svcOrdInfoVO.getCutOffDt());
				}
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new EventException(e.getMessage());
		}
	}

	/**
	 * 
	 * @param revParam
	 * @param rcvMsg
	 * @param lgsCostCd
	 * @param rcvAmt
	 * @param fuelRto
	 * @param rcvMsgDesc
	 * @throws EventException
	 */
	private void addTrsEdiUsaRcvMsg(HashMap<String, Object> revParam, String rcvMsg, String lgsCostCd, String currency, String rcvAmt, String fuelRto, String rcvMsgDesc, String chgCompare, String oldRcvAmt, String oldFuelRto, String oldRcvMsgDesc) throws EventException {
		try {
			revParam.put("rcv_msg", rcvMsg);
			revParam.put("lgs_cost_cd", lgsCostCd);
			revParam.put("curr_cd", currency);
			revParam.put("rcv_amt", rcvAmt);
			revParam.put("fuel_rto", fuelRto);
			revParam.put("rcv_msg_desc", rcvMsgDesc);
			revParam.put("chg_compare", chgCompare);

			revParam.put("old_rcv_amt", oldRcvAmt);
			revParam.put("old_fuel_rto", oldFuelRto);
			revParam.put("old_rcv_msg_desc", oldRcvMsgDesc);
			woDbdao.addTrsEdiUsaRcvMsg(revParam);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new EventException(e.getMessage());
		}
	}

	/**
	 * 
	 * @param s
	 * @return
	 * @throws Exception
	 */
	private SelectTrspSvcOrdInfoVO selectTrspSvcOrdInfo(String[] s) throws Exception {
		HashMap<String, Object> revParam = new HashMap<String, Object>();
		revParam.put("trsp_so_ofc_cty_cd", s[1].substring(0, 3));
		revParam.put("trsp_so_seq", s[1].substring(3));
		revParam.put("trsp_wo_ofc_cty_cd", s[0].substring(0, 3));
		revParam.put("trsp_wo_seq", s[0].substring(3));
		return woDbdao.selectTrspSvcOrdInfo(revParam);

	}
}