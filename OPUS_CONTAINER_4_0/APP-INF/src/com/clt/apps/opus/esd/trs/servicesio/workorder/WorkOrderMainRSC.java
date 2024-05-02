/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : WorkOrderMainRSC.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015-01-07
 *@LastModifier : 
 *@LastVersion : 1.0
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.workorder;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.clt.apps.opus.esd.trs.servicesio.workorder.basic.WorkOrderMainBC;
import com.clt.apps.opus.esd.trs.servicesio.workorder.basic.WorkOrderMainBCImpl;
import com.clt.apps.opus.esd.trs.servicesio.workorder.event.WorkOrderRcvEvent;
import com.clt.apps.opus.esd.trs.servicesio.workorder.vo.JoEdiRcvBodyVo;
import com.clt.apps.opus.esd.trs.servicesio.workorder.vo.JoEdiRcvChargeVo;
import com.clt.apps.opus.esd.trs.servicesio.workorder.vo.JoEdiRcvEqmentVo;
import com.clt.apps.opus.esd.trs.servicesio.workorder.vo.JoEdiRcvHdrVo;
import com.clt.apps.opus.esd.trs.servicesio.workorder.vo.JoEdiRcvStopVo;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.utility.CheckUtilities;

/**
 * ESD-TRS Business Logic ServiceCommand<br>
 * - ESD-TRS에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author
 * @see WorkOrderMainDBDAO.java 참조
 * @since J2EE 1.6
 */
public class WorkOrderMainRSC extends ServiceCommandSupport {

	/**
	 * TRS 업무 시나리오 선행작업<br>
	 * WorkOrder업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("WorkOrderMainRSC start");
	}

	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * WorkOrder업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("WorkOrderMainRSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ESD-TRS 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	@Override
	public EventResponse perform(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		if (e.getEventName().equalsIgnoreCase("WorkOrderRcvEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				manageGblWoAckMQ(e);
			}
		}
		return eventResponse;
	}

	/**
	 * EDI-108-IN-VENDOR-JOEDI (Global - JOEDI)
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private void manageGblWoAckMQ(Event e) throws EventException {
		WorkOrderMainBC command = new WorkOrderMainBCImpl();
		try {
			begin();
			WorkOrderRcvEvent workOrderRcvEvent = parsingJoEdiRcvHeaderFlatFile((WorkOrderRcvEvent) e);
			String msgType = workOrderRcvEvent.getJoEdiRcvHdrVo().getMsgType();
			workOrderRcvEvent = parsingJoEdiRcvBodyFlatFile(workOrderRcvEvent, msgType);
			if (workOrderRcvEvent != null) {
				if (isSoValid(workOrderRcvEvent)) {
					if ("JOEDIUPDT".equalsIgnoreCase(msgType)) {
						command.receiveJoEdiUpdt(workOrderRcvEvent);
					} else if ("JOEDIACC".equalsIgnoreCase(msgType)) {
						command.receiveJoEdiAcc(workOrderRcvEvent);
					} else if ("JOEDIACTL".equalsIgnoreCase(msgType)) {
						command.receiveJoEdiActl(workOrderRcvEvent);
					} else if ("JOEDIREJ".equalsIgnoreCase(msgType)) {
						command.receiveJoEdiRej(workOrderRcvEvent);
					} else if ("JOEDIAPPT".equalsIgnoreCase(msgType)) {
						command.receiveJoEdiAppt(workOrderRcvEvent);
					}
				}
			}
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw de;
		} catch (Exception ee) {
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		}
	}

	/**
	 * 
	 * @param workOrderRcvEvent
	 * @return
	 */
	private boolean isSoValid(WorkOrderRcvEvent workOrderRcvEvent) {
		boolean isValidSo = false;
		if (workOrderRcvEvent.getJoEdiRcvBodyVo() != null) {
			JoEdiRcvBodyVo joEdiRcvBodyVo = workOrderRcvEvent.getJoEdiRcvBodyVo();
			String joItemRef = joEdiRcvBodyVo.getJoItemRef();
			try {
				isValidSo = joItemRef.matches("([a-zA-Z]{3}[0-9]+){1}-([a-zA-Z]{3}[0-9]+){1}");
				if (!isValidSo) {
					log.debug("OSCAR DATA ==>  REF_NO : " + joItemRef);
				}
			} catch (Exception e) {
				log.error("REF_NO : " + joItemRef, e);
			}
		}

		return isValidSo;
	}

	/**
	 * J/O EDI Receive Header
	 * 
	 * @param e
	 * @return
	 * @throws Exception
	 */
	private WorkOrderRcvEvent parsingJoEdiRcvHeaderFlatFile(WorkOrderRcvEvent e) throws Exception {
		String eaiRcvContents = e.getEaiRcvContents();
		JoEdiRcvHdrVo joEdiRcvHdrVo = new JoEdiRcvHdrVo();
		if (!CheckUtilities.isNull(eaiRcvContents)) {
			InputStream is = new ByteArrayInputStream(eaiRcvContents.getBytes());
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line;
			while ((line = br.readLine()) != null) {
				if (line.startsWith("$$$MSGSTART:")) {
					joEdiRcvHdrVo.setSenderId(((String) line.subSequence(12, 32)).trim());
					joEdiRcvHdrVo.setReceiverId(((String) line.subSequence(32, 52)).trim());
					joEdiRcvHdrVo.setMsgType(((String) line.subSequence(52, 62)).trim());
					joEdiRcvHdrVo.setReferenceNo(((String) line.subSequence(62, 77)).trim());
					e.setJoEdiRcvHdrVo(joEdiRcvHdrVo);
					break;
				}
			}
			br.close();
		}
		return e;
	}

	/**
	 * EDI F/F Parsing - Receive
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 */
	private WorkOrderRcvEvent parsingJoEdiRcvBodyFlatFile(WorkOrderRcvEvent e, String msgType) throws Exception {
		String eaiRcvContents = e.getEaiRcvContents();
		JoEdiRcvBodyVo joEdiRcvBodyVo = new JoEdiRcvBodyVo();
		List<JoEdiRcvEqmentVo> joEdiRcvEqmentVos = new ArrayList<JoEdiRcvEqmentVo>();
		List<JoEdiRcvStopVo> joStopVos = new ArrayList<JoEdiRcvStopVo>();
		JoEdiRcvEqmentVo joEdiRcvEqmentVo = null;
		List<JoEdiRcvChargeVo> joChargeVos = null;
		JoEdiRcvChargeVo joChargeVo = null;
		JoEdiRcvStopVo joStopVo = null;
		if (!CheckUtilities.isNull(eaiRcvContents)) {
			InputStream is = new ByteArrayInputStream(eaiRcvContents.getBytes());
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line;
			String item = null;
			String itemValue = null;
			String naviagtion = "";
			String entity = null;
			while ((line = br.readLine()) != null) {
				if (line.startsWith("$$$MSGSTART:")) {
					continue;
				} else if (line.startsWith("{")) {
					entity = line.substring(1).toLowerCase();
					naviagtion += ">" + entity;
					if ("JOEDIUPDT".equals(msgType)) {
						if (entity.equalsIgnoreCase("equipment")) {
							joEdiRcvEqmentVo = new JoEdiRcvEqmentVo();
							joChargeVos = new ArrayList<JoEdiRcvChargeVo>();
						} else if (entity.equalsIgnoreCase("charge")) {
							joChargeVo = new JoEdiRcvChargeVo();
						} else if (entity.equalsIgnoreCase("stop")) {
							joStopVo = new JoEdiRcvStopVo();
						}
					} else if ("JOEDIACTL".equals(msgType) || "JOEDIAPPT".equals(msgType)) {
						if (entity.equalsIgnoreCase("equipment")) {
							joEdiRcvEqmentVo = new JoEdiRcvEqmentVo();
						}
					}

				} else if (line.startsWith("}")) {
					entity = line.substring(1).toLowerCase();
					naviagtion = naviagtion.substring(0, naviagtion.lastIndexOf(">"));
					if ("JOEDIUPDT".equals(msgType)) {
						if (entity.equalsIgnoreCase("equipment")) {
							if (joEdiRcvEqmentVo != null && joEdiRcvEqmentVos != null) {
								joEdiRcvEqmentVo.setJoEdiRcvChargeVos(joChargeVos);
								joEdiRcvEqmentVos.add(joEdiRcvEqmentVo);
								joEdiRcvEqmentVo = null;
							}
						} else if (entity.equalsIgnoreCase("charge")) {
							if (joChargeVos != null && joChargeVo != null) {
								joChargeVos.add(joChargeVo);
								joChargeVo = null;
							}
						} else if (entity.equalsIgnoreCase("stop")) {
							if (joStopVos != null && joStopVo != null) {
								joStopVos.add(joStopVo);
								joStopVo = null;
							}
						}
					} else if ("JOEDIACTL".equals(msgType) || "JOEDIAPPT".equals(msgType)) {
						if (entity.equalsIgnoreCase("equipment")) {
							if (joEdiRcvEqmentVos != null && joEdiRcvEqmentVo != null) {
								joEdiRcvEqmentVos.add(joEdiRcvEqmentVo);
								joEdiRcvEqmentVo = null;
							}
						}
					}
				} else {
					String[] o = line.split(Pattern.quote(":"));
					item = o[0].toLowerCase();
					itemValue = o.length > 1 ? o[1].trim() : "";
					if (naviagtion.indexOf("equipment_list>equipment") > -1) {
						if (naviagtion.endsWith("equipment_list>equipment")) {
							if (joEdiRcvEqmentVo != null) {
								if ("cntr_no".equals(item)) {
									joEdiRcvEqmentVo.setCntrNo(itemValue);
								} else if ("cntr_tpsz".equals(item)) {
									joEdiRcvEqmentVo.setCntrTpsz(itemValue);
								}
							}
						} else if (naviagtion.endsWith("equipment_list>equipment>charge")) {
							if (joChargeVo != null) {
								if ("stop_no".equals(item)) {
									joChargeVo.setStopNo(itemValue);
								} else if ("svc_cd".equals(item)) {
									joChargeVo.setSvcCd(itemValue);
								} else if ("amount".equals(item)) {
									joChargeVo.setAmount(itemValue);
								} else if ("currency".equals(item)) {
									joChargeVo.setCurrency(itemValue);
								} else if ("fsc_percent".equals(item)) {
									joChargeVo.setFscPercent(itemValue);
								} else if ("billable".equals(item)) {
									joChargeVo.setBillable(itemValue);
								} else if ("charge_ref".equals(item)) {
									joChargeVo.setChargeRef(itemValue);
								} else if ("billto".equals(item)) {
									joChargeVo.setBillto(itemValue);
								} else if ("comment".equals(item)) {
									joChargeVo.setComment(itemValue);
								}
							}
						}
					} else if (naviagtion.indexOf("stop_list>stop") > -1) {
						if (naviagtion.endsWith("stop_list>stop") || naviagtion.endsWith("stop_list>stop>location")) {
							if (joStopVo != null) {
								if ("stop_tp".equals(item)) {
									joStopVo.setStopTp(itemValue);
								} else if ("stop_nm".equals(item)) {
									joStopVo.setStopNm(itemValue);
								} else if ("stop_no".equals(item)) {
									joStopVo.setStopNo(itemValue);
								} else if ("stop_contact_nm".equals(item)) {
									joStopVo.setStopContactNm(itemValue);
								} else if ("stop_contact_te".equals(item)) {
									joStopVo.setStopContactTe(itemValue);
								}
							}
						}
					} else if (naviagtion.indexOf("actl_detail>equipment") > -1 || naviagtion.indexOf("appt_detail>equipment") > -1) {
						if (joEdiRcvEqmentVo != null) {
							if ("cntr_no".equals(item)) {
								joEdiRcvEqmentVo.setCntrNo(itemValue);
							} else if ("cntr_tpsz".equals(item)) {
								joEdiRcvEqmentVo.setCntrTpsz(itemValue);
							}
						}
					} else {
						if ("jo_item_msg_type".equals(item)) {
							joEdiRcvBodyVo.setJoItemMsgType(itemValue);
						} else if ("snd_cd".equals(item)) {
							joEdiRcvBodyVo.setSndCd(itemValue);
						} else if ("rcv_cd".equals(item)) {
							joEdiRcvBodyVo.setRcvCd(itemValue);
						} else if ("jo_item_ref".equals(item)) {
							joEdiRcvBodyVo.setJoItemRef(itemValue);
						} else if ("reason_cd".equals(item)) {
							joEdiRcvBodyVo.setReasonCd(itemValue);
						} else if ("stop_no".equals(item)) {
							joEdiRcvBodyVo.setStopNo(itemValue);
						} else if ("gate_in_start".equals(item)) {
							joEdiRcvBodyVo.setGateInStart(itemValue);
						} else if ("gate_in_end".equals(item)) {
							joEdiRcvBodyVo.setGateInEnd(itemValue);
						} else if ("gate_in_form".equals(item)) {
							joEdiRcvBodyVo.setGateInForm(itemValue);
						} else if ("gate_out_start".equals(item)) {
							joEdiRcvBodyVo.setGateOutStart(itemValue);
						} else if ("gate_out_edn".equals(item)) {
							joEdiRcvBodyVo.setGateOutEdn(itemValue);
						} else if ("gate_out_form".equals(item)) {
							joEdiRcvBodyVo.setGateOutForm(itemValue);
						} else if ("gate_in".equals(item)) {
							joEdiRcvBodyVo.setGateIn(itemValue);
						} else if ("gate_out".equals(item)) {
							joEdiRcvBodyVo.setGateOut(itemValue);
						} else if ("bkg_no".equals(item)) {
							joEdiRcvBodyVo.setBkgNo(itemValue);
						} else if ("bl_no".equals(item)) {
							joEdiRcvBodyVo.setBlNo(itemValue);
						} else if ("cutoff_dt".equals(item)) {
							joEdiRcvBodyVo.setCutoffDt(itemValue);
						}
					}
				}
			}
			br.close();
		}
		joEdiRcvBodyVo.setJoEdiRcvEqmentVos(joEdiRcvEqmentVos);
		joEdiRcvBodyVo.setJoEdiRcvStopVos(joStopVos);
		e.setJoEdiRcvBodyVo(joEdiRcvBodyVo);
		return e;
	}
}
