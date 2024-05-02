/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : USA404EDIStatusInquiryBCImpl.java
 *@FileTitle : USA 404 EDI Status Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ServerExportException;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.event.EsdTrs0026Event;
import com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.event.EsdTrs0027Event;
import com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.event.EsdTrs0028Event;
import com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration.USA404EDIStatusInquiryDBDAO;
import com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration.USA404EDIStatusInquiryEAIDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.utility.CheckUtilities;

/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * 
 * @author
 * @see ESD_TRS_028EventResponse,USA404EDIStatusInquiryBC
 * @since J2EE 1.4
 */
public class USA404EDIStatusInquiryBCImpl extends BasicCommandSupport implements USA404EDIStatusInquiryBC {
	private transient USA404EDIStatusInquiryDBDAO dbDao = null;
	private transient USA404EDIStatusInquiryEAIDAO eaiDao = null;

	/**
	 * USA404EDIStatusInquiryBCImpl <br>
	 * USA404EDIStatusInquiryDBDAO<br>
	 */
	public USA404EDIStatusInquiryBCImpl() {
		dbDao = new USA404EDIStatusInquiryDBDAO();
		eaiDao = new USA404EDIStatusInquiryEAIDAO();
	}

	/**
	 * Inquiry event process<br>
	 * USA404EDIStatusInquiry - Inquiry event process<br>
	 * 
	 * @param e ESD_TRS_028Event
	 * @return EventResponse ESD_TRS_028EventResponse
	 * @exception EventException
	 */
	public EventResponse searchUSA404EDIStatusInquiry(Event e) throws EventException {
		EsdTrs0028Event event = (EsdTrs0028Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			eventResponse.setRsVo(dbDao.searchUSA404EDIStatusInquiry(event));
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Inquiry event processing<br>
	 * USA404EDIStatusInquiry - Inquiry event process<br>
	 * 
	 * @param e ESD_TRS_028Event
	 * @return EventResponse ESD_TRS_028EventResponse
	 * @exception EventException
	 */
	public EventResponse search02USA404EDIStatusInquiry(Event e) throws EventException {
		EsdTrs0028Event event = (EsdTrs0028Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			eventResponse.setRsVo(dbDao.search02USA404EDIStatusInquiry(event));
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Inquiry event process<br>
	 * USA404EDIStatusInquiry - Inquiry event process<br>
	 * COP EDI
	 * 
	 * @param list
	 * @return
	 * @exception EventException
	 */
	public EventResponse search03USA404EDIStatusSend(List<Object> list) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			eventResponse.setRsVo(dbDao.search03USA404EDIStatusSend(list));
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Inquiry event process<br>
	 * USA404EDIStatusInquiry - Inquiry event process<br>
	 * COP EDI
	 * 
	 * @param list
	 * @return
	 * @exception EventException
	 */
	public EventResponse searchUS404EDIResendList(List<Object> list) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			eventResponse.setRsVo(dbDao.searchUS404EDIResendList(list));
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Inquiry event process<br>
	 * USA404EDIStatusInquiry - Inquiry event process<br>
	 * COP EDI
	 * 
	 * @param rowSet
	 * @exception EventException
	 */
	public void search03SubUSA404EDIStatusSend(DBRowSet rowSet) throws EventException {
		try {
			if (rowSet != null) {
				String sApprecv_c = null;
				String sVndrEdi = null;
				String sAppMaherEdi = null;
				while (rowSet.next()) {
					sVndrEdi = JSPUtil.getNull(rowSet.getString("APPRECV_C"));
					sAppMaherEdi = JSPUtil.getNull(rowSet.getString("APP_MAHER"));
					if ("CN".equals(sVndrEdi) || "CPRS".equals(sVndrEdi) || !CheckUtilities.isInBlank(sAppMaherEdi)) {
						StringBuffer eh = new StringBuffer();
						eh.append("{CNTR\n");
						StringBuffer eb = funcSetFF0(rowSet);
						StringBuffer vndrCredit = new StringBuffer();
						vndrCredit.append("CREDIT:" + JSPUtil.getNull(rowSet.getString("CREDIT")) + "\n");
						StringBuffer eb1 = null;
						StringBuffer eb2 = funcSetFFAshpr(rowSet);
						StringBuffer eb3 = funcSetCustomer(rowSet);
						StringBuffer eb4 = funcSetFFUtcn(rowSet);
						StringBuffer eb5 = funcSetFFRecv(rowSet);
						funcSetFFContainerSealNo(eb5, rowSet);
						funcSetFFRef(eb5, rowSet);
						funcSetFFSplitBl(eb5, rowSet);
						funcSetFFOld(eb5, rowSet);
						funcSetFFRount(eb5, rowSet);
						eb5.append("INBOND:" + JSPUtil.getNull(rowSet.getString("INBOND")) + "\n");
						funcSetLADE(eb5, rowSet, 1, 5);
						funcSetDG(eb5, rowSet);
						funcBlGrpForCnFF(eb5, rowSet);
						funcCntrMfForCnFF(eb5, rowSet);
						eb5.append("}CNTR\n");

						// EDI Send
						if ("CN".equals(sVndrEdi) || "CPRS".equals(sVndrEdi)) {
							if ("CPRS".equals(sVndrEdi)) {
								sApprecv_c = "CPRSP";
							} else {
								sApprecv_c = "CN";
							}
							eb1 = funcSetFF1(rowSet, false);
							String ediVndr = getSenderIdAnMessageType(sVndrEdi) + eh.toString() + "APPRECV_C:" + sApprecv_c + "\n" + eb.toString() + vndrCredit.toString() + eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb5.toString();
							eaiDao.return404EDIsent(ediVndr);
						}

						if (!CheckUtilities.isInBlank(sAppMaherEdi)) {
							eb1 = funcSetFF1(rowSet, true);
							String ediMtc = getSenderIdAnMessageType(sAppMaherEdi) + eh.toString() + "APPRECV_C:" + sAppMaherEdi + "\n" + eb.toString() + vndrCredit.toString() + eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb5.toString();
							eaiDao.return404EDIsent(ediMtc);
						}
					}
				}
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Inquiry event process<br>
	 * USA404EDIStatusInquiry - Inquiry event process<br>
	 * COP EDI
	 * 
	 * @param rowSet
	 * @exception EventException
	 */
	public void resendUS404EDIResend(DBRowSet rowSet) throws EventException {
		/*****************************************************************
		 * SEND vs Resend <br>
		 * -------------------------------------------------------------- <br>
		 * RAIL VENDOR : X (Always) MTC : MTC (AS EDI CC FM/TO, POL/POD) MAHERTP : X (EDI CC FM/TO:'USNYCDS' Only)
		 */
		try {
			if (rowSet != null) {
				String sApprecv_c = null;
				String sVndrEdi = null;
				String sAppMaherEdi = null;
				while (rowSet.next()) {
					sVndrEdi = JSPUtil.getNull(rowSet.getString("APPRECV_C"));
					sAppMaherEdi = JSPUtil.getNull(rowSet.getString("APP_MAHER"));
					if ("CN".equals(sVndrEdi) || "CPRS".equals(sVndrEdi) || !CheckUtilities.isInBlank(sAppMaherEdi)) {
						StringBuffer eh = new StringBuffer();
						eh.append("{CNTR\n");
						StringBuffer eb = funcSetFF0(rowSet);
						StringBuffer vndrCredit = new StringBuffer();
						vndrCredit.append("CREDIT:" + JSPUtil.getNull(rowSet.getString("CREDIT")) + "\n");
						StringBuffer eb1 = null;
						StringBuffer eb2 = funcSetFFAshpr(rowSet);
						StringBuffer eb3 = funcSetCustomer(rowSet);
						StringBuffer eb4 = funcSetFFUtcn(rowSet);
						StringBuffer eb5 = funcSetFFRecv(rowSet);
						funcSetFFContainerSealNo(eb5, rowSet);
						funcSetFFRef(eb5, rowSet);
						funcSetFFSplitBl(eb5, rowSet);
						funcSetFFOld(eb5, rowSet);
						funcSetFFRount(eb5, rowSet);
						eb5.append("INBOND:" + JSPUtil.getNull(rowSet.getString("INBOND")) + "\n");
						funcSetLADE(eb5, rowSet, 1, 5);
						funcSetDG(eb5, rowSet);
						funcBlGrpForCnFF(eb5, rowSet);
						funcCntrMfForCnFF(eb5, rowSet);
						eb5.append("}CNTR\n");

						if ("CN".equals(sVndrEdi) || "CPRS".equals(sVndrEdi)) {
							if ("CPRS".equals(sVndrEdi)) {
								sApprecv_c = "CPRSP";
							} else {
								sApprecv_c = "CN";
							}
							eb1 = funcSetFF1(rowSet, false);
							String ediVndr = getSenderIdAnMessageType(sVndrEdi) + eh.toString() + "APPRECV_C:" + sApprecv_c + "\n" + eb.toString() + vndrCredit.toString() + eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb5.toString();
							eaiDao.return404EDIsent(ediVndr);
						}
						if (!CheckUtilities.isInBlank(sAppMaherEdi)) {
							eb1 = funcSetFF1(rowSet, true);
							String ediMtc = getSenderIdAnMessageType(sAppMaherEdi) + eh.toString() + "APPRECV_C:" + sAppMaherEdi + "\n" + eb.toString() + vndrCredit.toString() + eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb5.toString();
							eaiDao.return404EDIsent(ediMtc);
						}
					}
				}
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Inquiry event process<br>
	 * USA404EDIStatusInquiry - Inquiry event process<br>
	 * COP EDI
	 * 
	 * @param list
	 * @return
	 * @exception EventException
	 */
	public EventResponse search04USA404EDIStatusSend(List<Object> list) throws EventException {
		DBRowSet rowSet = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			rowSet = dbDao.search04USA404EDIStatusSend(list);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Inquiry event process<br>
	 * USA404EDIStatusInquiry - Inquiry event process<br>
	 * COP EDI
	 * 
	 * @param rowSet
	 * @exception EventException
	 */
	public void search04SubUSA404EDIStatusSend(DBRowSet rowSet) throws EventException {
		String sApprecv_c = null;
		String sVndrEdi = null;
		String sAppMaherEdi = null;
		try {
			while (rowSet.next()) {
				sVndrEdi = JSPUtil.getNull(rowSet.getString("APPRECV_C"));
				sAppMaherEdi = JSPUtil.getNull(rowSet.getString("APP_MAHER"));
				if ("CN".equals(sVndrEdi) || "CPRS".equals(sVndrEdi) || !CheckUtilities.isInBlank(sAppMaherEdi)) {
					StringBuffer eh = new StringBuffer();
					eh.append("{CNTR\n");
					StringBuffer eb = funcSetFF0(rowSet);
					StringBuffer vndrCredit = new StringBuffer();
					vndrCredit.append("CREDIT:" + JSPUtil.getNull(rowSet.getString("CREDIT")) + "\n");
					StringBuffer eb1 = null;
					StringBuffer eb2 = funcSetFFAshpr(rowSet);
					StringBuffer eb3 = funcSetCustomer(rowSet);
					StringBuffer eb4 = funcSetFFUtcn(rowSet);
					StringBuffer eb5 = funcSetFFRecv(rowSet);

					funcSetFFContainerSealNo(eb5, rowSet);
					funcSetFFRef(eb5, rowSet);
					funcSetFFSplitBl(eb5, rowSet);

					eb5.append("{OLD\n");
					eb5.append("APPRECV_C_OLD:" + JSPUtil.getNull(rowSet.getString("APPRECV_C_OLD")) + "\n");
					eb5.append("BKGNO_OLD:" + JSPUtil.getNull(rowSet.getString("BKGNO_OLD")) + "\n");

					String blnoOld = JSPUtil.getNull(rowSet.getString("BLNO_OLD"));
					if (CheckUtilities.isInBlank(blnoOld)) {
						eb5.append("BLNO_OLD:" + JSPUtil.getNull(rowSet.getString("BKGNO_OLD")) + "\n");
					} else {
						eb5.append("BLNO_OLD:" + blnoOld + "\n");
					}

					// MTC = CREDIT prefix 'M'
					StringBuffer vndrCreditOld = new StringBuffer();
					StringBuffer mtcCreditOld = new StringBuffer();
					vndrCreditOld.append("CREDIT_OLD:X" + JSPUtil.getNull(rowSet.getString("CREDIT_OLD")) + "\n");
					mtcCreditOld.append("CREDIT_OLD:Z" + JSPUtil.getNull(rowSet.getString("CREDIT_OLD")) + "\n");

					StringBuffer eb6 = new StringBuffer();
					eb6.append("EQINIT_OLD:" + JSPUtil.getNull(rowSet.getString("EQINIT_OLD")) + "\n");
					eb6.append("EQNO_OLD:" + JSPUtil.getNull(rowSet.getString("EQNO_OLD")) + "\n");
					eb6.append("SNDDT_OLD:" + JSPUtil.getNull(rowSet.getString("SNDDT_OLD")) + "\n");
					eb6.append("}OLD\n");

					funcSetFFRount(eb6, rowSet);
					eb6.append("INBOND:" + JSPUtil.getNull(rowSet.getString("INBOND")) + "\n");

					funcSetLADE(eb6, rowSet, 1, 5);
					funcSetDG(eb6, rowSet);
					funcBlGrpForCnFF(eb6, rowSet);
					funcCntrMfForCnFF(eb6, rowSet);
					eb6.append("}CNTR\n");

					if ("CN".equals(sVndrEdi) || "CPRS".equals(sVndrEdi)) {
						if ("CPRS".equals(sVndrEdi)) {
							sApprecv_c = "CPRSP";
						} else {
							sApprecv_c = "CN";
						}
						eb1 = funcSetFF1(rowSet, false);
						String sVndr_send = getSenderIdAnMessageType(sVndrEdi) + eh.toString() + "APPRECV_C:" + sApprecv_c + "\n" + eb.toString() + vndrCredit.toString() + eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb5.toString() + vndrCreditOld.toString() + eb6.toString();
						eaiDao.cancelReturn4040EDIsend(sVndr_send);
					}

					if (!CheckUtilities.isInBlank(sAppMaherEdi)) {
						eb1 = funcSetFF1(rowSet, true);
						String ediff = getSenderIdAnMessageType(sAppMaherEdi) + eh.toString() + "APPRECV_C:" + sAppMaherEdi + "\n" + eb.toString() + vndrCredit.toString() + eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb5.toString() + vndrCreditOld.toString() + eb6.toString();
						eaiDao.cancelReturn4040EDIsend(ediff);
					}
				}
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Multi-event processing<br>
	 * ESD_TRS_028 - Multi-event processing<br>
	 * 404EDI Send Cop
	 * 
	 * @param e ESD_TRS_028Event
	 * @return EventResponse ESD_TRS_028EventResponse
	 * @exception EventException
	 */
	public EventResponse multiUSA404EDIStatusInquiry(Event e) throws EventException {
		EsdTrs0028Event event = (EsdTrs0028Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			eventResponse.setRsVoList(dbDao.multiTrsTrspEdiRailOrderVos(event));
			return eventResponse;
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Multi-event processing<br>
	 * ESD_TRS_028 - Multi-event processing<br>
	 * 404EDI Send Cop
	 * 
	 * @param e ESD_TRS_028Event
	 * @return EventResponse ESD_TRS_028EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	public EventResponse modifyUS404EDIResendRailBilOrd(Event e) throws EventException {
		EsdTrs0028Event event = (EsdTrs0028Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ArrayList arr_edi_snd_no = null;
		try {
			arr_edi_snd_no = dbDao.modifyUS404EDIResendRailBilOrd(event);
			eventResponse.setRsVoList(arr_edi_snd_no);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Multi-event processing<br>
	 * ESD_TRS_028 - Multi-event processing<br>
	 * 404EDI Send
	 * 
	 * @param e ESD_TRS_028Event
	 * @exception EventException
	 */
	public void multiUSA404EDIRollbackInquiry(Event e) throws EventException {
		EsdTrs0028Event event = (EsdTrs0028Event) e;
		try {
			dbDao.multiRollbackTrsTrspEdiRailOrderVos(event);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Multi-event processing<br>
	 * ESD_TRS_028 - Multi-event processing<br>
	 * 404EDI Send
	 * 
	 * @param e ESD_TRS_028Event
	 * @exception EventException
	 */
	public void addUSA404EDIResendRollback(Event e) throws EventException {
		EsdTrs0028Event event = (EsdTrs0028Event) e;
		try {
			dbDao.addUSA404EDIResendRollback(event);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Multi-event processing<br>
	 * ESD_TRS_028 - Multi-event processing<br>
	 * 404EDI Confirm Message Send
	 * 
	 * @param e ESD_TRS_028Event
	 * @return EventResponse ESD_TRS_028EventResponse
	 * @exception EventException
	 */
	public EventResponse multi01USA404EDIStatusInquiry(Event e) throws EventException {
		EsdTrs0028Event event = (EsdTrs0028Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			dbDao.multi01USA404EDIStatusInquiry(event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Multi-event processing<br>
	 * ESD_TRS_028 - Multi-event processing<br>
	 * 404EDI Cancellation EDI Send
	 * 
	 * @param e ESD_TRS_028Event
	 * @return EventResponse ESD_TRS_028EventResponse
	 * @exception EventException
	 */
	public EventResponse multi02USA404EDIStatusInquiry(Event e) throws EventException {
		EsdTrs0028Event event = (EsdTrs0028Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			eventResponse.setRsVoList(dbDao.multi02TrsTrspEdiRailOrderVos(event));
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Multi-event processing<br>
	 * ESD_TRS_028 - Multi-event processing<br>
	 * 404EDI Cancellation EDI Send
	 * 
	 * @param e ESD_TRS_028Event
	 * @exception EventException
	 */
	public void multi02USA404EDIStatusInquiryRBB(Event e) throws EventException {
		EsdTrs0028Event event = (EsdTrs0028Event) e;
		try {
			dbDao.multi02TrsTrspEdiRailOrderVoRbb(event);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Multi-event processing<br>
	 * ESD_TRS_028 - Multi-event processing<br>
	 * 404EDI Cancellation EDI Send
	 * 
	 * @param e ESD_TRS_028Event
	 * @param row
	 * @return EventResponse ESD_TRS_028EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	public EventResponse multi02USA404EDIStatusInquiryForSpp(Event e, int row) throws EventException {
		EsdTrs0028Event event = (EsdTrs0028Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ArrayList arr_edi_snd_no = null;
		try {
			arr_edi_snd_no = dbDao.multi02TrsTrspEdiRailOrderVoForSpp(event, row);
			eventResponse.setRsVoList(arr_edi_snd_no);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Multi-event processing<br>
	 * ESD_TRS_028 - Multi-event processing<br>
	 * 404EDI Cancellation EDI Send
	 * 
	 * @param e ESD_TRS_028Event
	 * @exception EventException
	 */
	public void multi03USA404EDIStatusInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0028Event event = (EsdTrs0028Event) e;
		try {
			dbDao.multi03TrsTrspEdiRailOrderVos(event);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Multi-event processing<br>
	 * ESD_TRS_028 - Multi-event processing<br>
	 * 404EDI Cancellation EDI Send
	 * 
	 * @param sOfc_cty_cd
	 * @param sSo_seq
	 * @return ArrayList
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	public ArrayList batchUSA404ComfirmedMessageSend(String sOfc_cty_cd, String sSo_seq) throws EventException {
		ArrayList arrResponse = null;
		try {
			arrResponse = dbDao.batchUSA404ComfirmedMessageAuto(sOfc_cty_cd, sSo_seq);
			return arrResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Multi-event processing<br>
	 * Multi-event processing of USA404EDIStatusInquiry<br>
	 * 404EDI CONFIM MESSAGE Send FAX
	 * 
	 * @param event
	 * @exception EventException
	 */
	public void faxEdiSend(EsdTrs0028Event event) throws EventException {
		try {
			eaiDao.faxEdiSend(event);
		} catch (ServerExportException de) {
			log.error(de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Multi-event processing<br>
	 * Multi-event processing of USA404EDIStatusInquiry<br>
	 * 404EDI CONFIM MESSAGE Send E-mail
	 * 
	 * @param event
	 * @exception EventException
	 */
	public void emailEdiSend(EsdTrs0028Event event) throws EventException {
		try {
			eaiDao.emailEdiSend(event);
		} catch (ServerExportException de) {
			log.error(de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * TRS + YY(2) + MM (2)+ DD(2) + Sequence (6)
	 * 
	 * @return
	 * @throws Exception
	 */
	private String getEdiReferenceNo() throws Exception {
		return dbDao.searchTrsEdiReferenceNo();
	}

	/**
	 * 
	 * @param rowSet
	 * @return
	 * @throws Exception
	 */
	private StringBuffer funcSetFF0(DBRowSet rowSet) throws Exception {
		String bkgNo = JSPUtil.getNull(rowSet.getString("BKGNO"));
		StringBuffer eb = new StringBuffer();
		eb.append("TYPE:" + JSPUtil.getNull(rowSet.getString("TYPE")) + "\n");
		eb.append("SHIPQLF_C:" + JSPUtil.getNull(rowSet.getString("SHIPQLF_C")) + "\n");
		eb.append("CLEARED_QUAL:" + JSPUtil.getNull(rowSet.getString("CLEARED_QUAL")) + "\n");
		eb.append("BOUND_IND:" + JSPUtil.getNull(rowSet.getString("BOUND_IND")) + "\n");
		eb.append("BKGNO:" + bkgNo + "\n");
		eb.append("BLNO:" + CheckUtilities.isNullOrNullStringReplacement(JSPUtil.getNull(rowSet.getString("BLNO")), bkgNo) + "\n");
		eb.append("MTREFNO:" + JSPUtil.getNull(rowSet.getString("MTREFNO")) + "\n");
		eb.append("BKG_SCNO:" + JSPUtil.getNull(rowSet.getString("BKG_SCNO")) + "\n");
		eb.append("VSLCODE:" + JSPUtil.getNull(rowSet.getString("VSLCODE")) + "\n");
		eb.append("VOYAGE:" + JSPUtil.getNull(rowSet.getString("VOYAGE")) + "\n");
		eb.append("VSLNAME:" + JSPUtil.getNull(rowSet.getString("VSLNAME")) + "\n");
		eb.append("VSLCUTOFF:" + JSPUtil.getNull(rowSet.getString("VSLCUTOFF")) + "\n");
		eb.append("LLOYD:" + JSPUtil.getNull(rowSet.getString("LLOYD")) + "\n");
		eb.append("CONSORT_VOY:" + JSPUtil.getNull(rowSet.getString("CONSORT_VOY")) + "\n");
		eb.append("HUBETA:" + JSPUtil.getNull(rowSet.getString("HUBETA")) + "\n");
		eb.append("POL:" + JSPUtil.getNull(rowSet.getString("POL")) + "\n");
		eb.append("POL_NM:" + JSPUtil.getNull(rowSet.getString("POL_NM")) + "\n");
		eb.append("POL_CT:" + JSPUtil.getNull(rowSet.getString("POL_CT")) + "\n");
		eb.append("POD:" + JSPUtil.getNull(rowSet.getString("POD")) + "\n");
		eb.append("POD_NM:" + JSPUtil.getNull(rowSet.getString("POD_NM")) + "\n");
		eb.append("POD_CT:" + JSPUtil.getNull(rowSet.getString("POD_CT")) + "\n");
		eb.append("CONTRACT:" + JSPUtil.getNull(rowSet.getString("CONTRACT")) + "\n");
		return eb;
	}

	/**
	 * @param rowSet
	 * @param maharFlg
	 * @return
	 * @throws Exception
	 */
	private StringBuffer funcSetFF1(DBRowSet rowSet, boolean maharFlg) throws Exception {
		StringBuffer sbObj = new StringBuffer();
		sbObj.append("IMTRANSNO:" + JSPUtil.getNull(rowSet.getString("IMTRANSNO")) + "\n");
		sbObj.append("TRANSEXPNO:" + JSPUtil.getNull(rowSet.getString("TRANSEXPNO")) + "\n");
		sbObj.append("DOCK:" + JSPUtil.getNull(rowSet.getString("DOCK")) + "\n");
		sbObj.append("FFDESC:" + JSPUtil.getNull(rowSet.getString("FFDESC")) + "\n");
		sbObj.append("EQTPSZ:" + JSPUtil.getNull(rowSet.getString("EQTPSZ")) + "\n");
		sbObj.append("EQINIT:" + JSPUtil.getNull(rowSet.getString("EQINIT")) + "\n");
		sbObj.append("EQNO:" + JSPUtil.getNull(rowSet.getString("EQNO")) + "\n");
		sbObj.append("WGT:" + JSPUtil.getNull(rowSet.getString("WGT")) + "\n");
		sbObj.append("TARE_WGT:" + JSPUtil.getNull(rowSet.getString("TARE_WGT")) + "\n");
		sbObj.append("NET_WGT:" + JSPUtil.getNull(rowSet.getString("NET_WGT")) + "\n");
		sbObj.append("EQDESC_C:" + JSPUtil.getNull(rowSet.getString("EQDESC_C")) + "\n");
		sbObj.append("EQLTH_C:" + JSPUtil.getNull(rowSet.getString("EQLTH_C")) + "\n");
		sbObj.append("EQCHK:" + JSPUtil.getNull(rowSet.getString("EQCHK")) + "\n");
		sbObj.append("SEALNO:" + JSPUtil.getNull(rowSet.getString("SEALNO")) + "\n");
		sbObj.append("STCC:" + JSPUtil.getNull(rowSet.getString("STCC")) + "\n");
		sbObj.append("SPCHAND_C:" + JSPUtil.getNull(rowSet.getString("SPCHAND_C")) + "\n");
		sbObj.append("ILTRANS_C:" + JSPUtil.getNull(rowSet.getString("ILTRANS_C")) + "\n");
		sbObj.append("CUSTENTTP_C:" + JSPUtil.getNull(rowSet.getString("CUSTENTTP_C")) + "\n");
		sbObj.append("CUSTENTNO:" + JSPUtil.getNull(rowSet.getString("CUSTENTNO")) + "\n");
		sbObj.append("CUSTTYPE:" + JSPUtil.getNull(rowSet.getString("CUSTTYPE")) + "\n");
		sbObj.append("CUSTLOC:" + JSPUtil.getNull(rowSet.getString("CUSTLOC")) + "\n");
		sbObj.append("CUSTLOCQUAL:" + JSPUtil.getNull(rowSet.getString("CUSTLOCQUAL")) + "\n");
		sbObj.append("CARGOWGT:" + JSPUtil.getNull(rowSet.getString("CARGOWGT")) + "\n");
		sbObj.append("ORGCTY:" + JSPUtil.getNull(rowSet.getString("ORGCTY")) + "\n");
		sbObj.append("ORGSTATE:" + JSPUtil.getNull(rowSet.getString("ORGSTATE")) + "\n");
		sbObj.append("ORGCNT:" + JSPUtil.getNull(rowSet.getString("ORGCNT")) + "\n");
		sbObj.append("ORGLOC:" + JSPUtil.getNull(rowSet.getString("ORGLOC")) + "\n");
		sbObj.append("ORGYD:" + JSPUtil.getNull(rowSet.getString("ORGYD")) + "\n");
		sbObj.append("DSTCTY:" + JSPUtil.getNull(rowSet.getString("DSTCTY")) + "\n");
		sbObj.append("DSTSTATE:" + JSPUtil.getNull(rowSet.getString("DSTSTATE")) + "\n");
		sbObj.append("DSTCNT:" + JSPUtil.getNull(rowSet.getString("DSTCNT")) + "\n");
		sbObj.append("DSTLOC:" + JSPUtil.getNull(rowSet.getString("DSTLOC")) + "\n");
		sbObj.append("DSTYD:" + JSPUtil.getNull(rowSet.getString("DSTYD")) + "\n");
		if (maharFlg) {
			sbObj.append("SHPR_N:" + JSPUtil.getNull(rowSet.getString("SHPR_N_MAHER")) + "\n");
		} else {
			sbObj.append("SHPR_N:" + JSPUtil.getNull(rowSet.getString("SHPR_N")) + "\n");
		}
		sbObj.append("SHPR_A:" + JSPUtil.getNull(rowSet.getString("SHPR_A")) + "\n");
		sbObj.append("SHPR_C:" + JSPUtil.getNull(rowSet.getString("SHPR_C")) + "\n");
		sbObj.append("SHPR_S:" + JSPUtil.getNull(rowSet.getString("SHPR_S")) + "\n");
		sbObj.append("SHPR_CN:" + JSPUtil.getNull(rowSet.getString("SHPR_CN")) + "\n");
		sbObj.append("SHPR_P:" + JSPUtil.getNull(rowSet.getString("SHPR_P")) + "\n");
		return sbObj;
	}

	/**
	 * 
	 * @param rowSet
	 * @return
	 * @throws Exception
	 */
	private StringBuffer funcSetFFAshpr(DBRowSet rowSet) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("ASHPR_CODE:" + JSPUtil.getNull(rowSet.getString("ASHPR_CODE")) + "\n");
		sb.append("ASHPR_N:" + JSPUtil.getNull(rowSet.getString("ASHPR_N")) + "\n");
		sb.append("ASHPR_A:" + JSPUtil.getNull(rowSet.getString("ASHPR_A")) + "\n");
		sb.append("ASHPR_C:" + JSPUtil.getNull(rowSet.getString("ASHPR_C")) + "\n");
		sb.append("ASHPR_S:" + JSPUtil.getNull(rowSet.getString("ASHPR_S")) + "\n");
		sb.append("ASHPR_P:" + JSPUtil.getNull(rowSet.getString("ASHPR_P")) + "\n");
		sb.append("ASHPR_CN:" + JSPUtil.getNull(rowSet.getString("ASHPR_CN")) + "\n");
		return sb;
	}

	/**
	 * 
	 * @param rowSet
	 * @return
	 * @throws Exception
	 */
	private StringBuffer funcSetCustomer(DBRowSet rowSet) throws Exception {
		StringBuffer sbObj = new StringBuffer();
		sbObj.append("CNEE_N:" + JSPUtil.getNull(rowSet.getString("CNEE_N")) + "\n");
		sbObj.append("CNEE_A:" + JSPUtil.getNull(rowSet.getString("CNEE_A")) + "\n");
		sbObj.append("CNEE_C:" + JSPUtil.getNull(rowSet.getString("CNEE_C")) + "\n");
		sbObj.append("CNEE_S:" + JSPUtil.getNull(rowSet.getString("CNEE_S")) + "\n");
		sbObj.append("CNEE_CN:" + JSPUtil.getNull(rowSet.getString("CNEE_CN")) + "\n");
		sbObj.append("CNEE_P:" + JSPUtil.getNull(rowSet.getString("CNEE_P")) + "\n");
		sbObj.append("NTFY_N:" + JSPUtil.getNull(rowSet.getString("NTFY_N")) + "\n");
		sbObj.append("NTFY_A:" + JSPUtil.getNull(rowSet.getString("NTFY_A")) + "\n");
		sbObj.append("NTFY_C:" + JSPUtil.getNull(rowSet.getString("NTFY_C")) + "\n");
		sbObj.append("NTFY_S:" + JSPUtil.getNull(rowSet.getString("NTFY_S")) + "\n");
		sbObj.append("NTFY_CN:" + JSPUtil.getNull(rowSet.getString("NTFY_CN")) + "\n");
		sbObj.append("NTFY_P:" + JSPUtil.getNull(rowSet.getString("NTFY_P")) + "\n");
		sbObj.append("NTFY_T:" + JSPUtil.getNull(rowSet.getString("NTFY_T")) + "\n");
		sbObj.append("CARE_N:" + JSPUtil.getNull(rowSet.getString("CARE_N")) + "\n");
		sbObj.append("CARE_A:" + JSPUtil.getNull(rowSet.getString("CARE_A")) + "\n");
		sbObj.append("CARE_C:" + JSPUtil.getNull(rowSet.getString("CARE_C")) + "\n");
		sbObj.append("CARE_S:" + JSPUtil.getNull(rowSet.getString("CARE_S")) + "\n");
		sbObj.append("CARE_CN:" + JSPUtil.getNull(rowSet.getString("CARE_CN")) + "\n");
		sbObj.append("CARE_P:" + JSPUtil.getNull(rowSet.getString("CARE_P")) + "\n");
		sbObj.append("BILL_N:" + JSPUtil.getNull(rowSet.getString("BILL_N")) + "\n");
		sbObj.append("BILL_A:" + JSPUtil.getNull(rowSet.getString("BILL_A")) + "\n");
		sbObj.append("BILL_C:" + JSPUtil.getNull(rowSet.getString("BILL_C")) + "\n");
		sbObj.append("BILL_S:" + JSPUtil.getNull(rowSet.getString("BILL_S")) + "\n");
		sbObj.append("BILL_CN:" + JSPUtil.getNull(rowSet.getString("BILL_CN")) + "\n");
		sbObj.append("BILL_P:" + JSPUtil.getNull(rowSet.getString("BILL_P")) + "\n");
		return sbObj;
	}

	/**
	 * 
	 * @param sbObj
	 * @param rowSet
	 * @param start
	 * @param end
	 * @throws Exception
	 */
	private void funcSetLADE(StringBuffer sbObj, DBRowSet rowSet, int start, int end) throws Exception {
		if (start == 1) {
			sbObj.append("{LADE\n");
			sbObj.append("LADELINE:" + JSPUtil.getNull(rowSet.getString("LADELINE" + start)) + "\n");
			sbObj.append("LADEDESC:" + JSPUtil.getNull(rowSet.getString("LADEDESC" + start)) + "\n");
			sbObj.append("COMMCODE:" + JSPUtil.getNull(rowSet.getString("COMMCODE" + start)) + "\n");
			sbObj.append("HS_CD:" + JSPUtil.getNull(rowSet.getString("HS_CD" + start)) + "\n");
			sbObj.append("BKG_COMM:" + JSPUtil.getNull(rowSet.getString("BKG_COMM" + start)) + "\n");
			sbObj.append("REF_COMM:" + JSPUtil.getNull(rowSet.getString("REF_COMM" + start)) + "\n");
			sbObj.append("UNITCODE:" + JSPUtil.getNull(rowSet.getString("UNITCODE" + start)) + "\n");
			sbObj.append("}LADE\n");
			start++;
		}
		sbObj.append("LADEQTY:" + JSPUtil.getNull(rowSet.getString("LADEQTY")) + "\n");
		sbObj.append("PACKFORM:" + JSPUtil.getNull(rowSet.getString("PACKFORM")) + "\n");
	}

	/**
	 * 
	 * @param rowSet
	 * @return
	 * @throws Exception
	 */
	private StringBuffer funcSetFFUtcn(DBRowSet rowSet) throws Exception {
		StringBuffer eb4 = new StringBuffer();
		eb4.append("UTCN_CODE:" + JSPUtil.getNull(rowSet.getString("UTCN_CODE")) + "\n");
		eb4.append("UTCN_N:" + JSPUtil.getNull(rowSet.getString("UTCN_N")) + "\n");
		eb4.append("UTCN_A:" + JSPUtil.getNull(rowSet.getString("UTCN_A")) + "\n");
		eb4.append("UTCN_C:" + JSPUtil.getNull(rowSet.getString("UTCN_C")) + "\n");
		eb4.append("UTCN_S:" + JSPUtil.getNull(rowSet.getString("UTCN_S")) + "\n");
		eb4.append("UTCN_CN:" + JSPUtil.getNull(rowSet.getString("UTCN_CN")) + "\n");
		eb4.append("UTCN_P:" + JSPUtil.getNull(rowSet.getString("UTCN_P")) + "\n");

		return eb4;
	}

	/**
	 * 
	 * @param rowSet
	 * @return
	 * @throws Exception
	 */
	private StringBuffer funcSetFFRecv(DBRowSet rowSet) throws Exception {
		StringBuffer eb5 = new StringBuffer();
		eb5.append("RECV_N:" + JSPUtil.getNull(rowSet.getString("RECV_N")) + "\n");
		eb5.append("RECV_A:" + JSPUtil.getNull(rowSet.getString("RECV_A")) + "\n");
		eb5.append("RECV_C:" + JSPUtil.getNull(rowSet.getString("RECV_C")) + "\n");
		eb5.append("RECV_S:" + JSPUtil.getNull(rowSet.getString("RECV_S")) + "\n");
		eb5.append("RECV_CN:" + JSPUtil.getNull(rowSet.getString("RECV_CN")) + "\n");
		eb5.append("RECV_P:" + JSPUtil.getNull(rowSet.getString("RECV_P")) + "\n");
		// 404 Flat File 신규 추가.
		eb5.append("CUSBRK_N:" + JSPUtil.getNull(rowSet.getString("CUSBRK_N")) + "\n");
		eb5.append("CUSBRK_A:" + JSPUtil.getNull(rowSet.getString("CUSBRK_A")) + "\n");
		eb5.append("CUSBRK_C:" + JSPUtil.getNull(rowSet.getString("CUSBRK_C")) + "\n");
		eb5.append("CUSBRK_S:" + JSPUtil.getNull(rowSet.getString("CUSBRK_S")) + "\n");
		eb5.append("CUSBRK_CN:" + JSPUtil.getNull(rowSet.getString("CUSBRK_CN")) + "\n");
		eb5.append("CUSBRK_P:" + JSPUtil.getNull(rowSet.getString("CUSBRK_P")) + "\n");

		eb5.append("ADMC_C:" + JSPUtil.getNull(rowSet.getString("ADMC_C")) + "\n");
		eb5.append("FDA_IND:" + JSPUtil.getNull(rowSet.getString("FDA_IND")) + "\n");
		eb5.append("CUST_F:" + JSPUtil.getNull(rowSet.getString("CUST_F")) + "\n");
		eb5.append("CUST_E:" + JSPUtil.getNull(rowSet.getString("CUST_E")) + "\n");
		eb5.append("TEMP:" + JSPUtil.getNull(rowSet.getString("TEMP")) + "\n");
		eb5.append("TUN:" + JSPUtil.getNull(rowSet.getString("TUN")) + "\n");
		eb5.append("VENT:" + JSPUtil.getNull(rowSet.getString("VENT")) + "\n");
		eb5.append("HUMID:" + JSPUtil.getNull(rowSet.getString("HUMID")) + "\n");
		eb5.append("GENSET:" + JSPUtil.getNull(rowSet.getString("GENSET")) + "\n");
		return eb5;
	}

	/**
	 * F/F DG Info
	 * 
	 * @param sbObj
	 * @param rowSet
	 * @throws Exception
	 */
	private void funcSetDG(StringBuffer sbObj, DBRowSet rowSet) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		int cnt = 0;
		if (!"M".equals(rowSet.getString("cgo_tp_cd"))) {
			param.put("dgBkgNo", rowSet.getString("bkgno"));
			param.put("dgEqNo", rowSet.getString("cntr_no_r"));
			dbRowset = dbDao.search03SubUSA404EDIStatusSend(param, param);
			cnt = dbRowset.getRowCount();
			String dot_auth_no = null, dot_spcl_apro_no = null, dot_exp_no = null;
			while (dbRowset.next()) {
				sbObj.append("{DG\n");
				sbObj.append("DG_STCC:" + JSPUtil.getNull(dbRowset.getString("DG_STCC")) + "\n");
				sbObj.append("DG_UN:" + JSPUtil.getNull(dbRowset.getString("DG_UN")) + "\n");
				sbObj.append("CFR_NBR:" + JSPUtil.getNull(dbRowset.getString("CFR_NBR")) + "\n");
				sbObj.append("DG_NAME:" + JSPUtil.getNull(dbRowset.getString("DG_NAME")) + "\n");
				sbObj.append("DG_TECH:" + JSPUtil.getNull(dbRowset.getString("DG_TECH")) + "\n");
				sbObj.append("DG_CONTENTS:" + JSPUtil.getNull(dbRowset.getString("DG_CONTENTS")) + "\n");
				sbObj.append("DG_CLASS:" + JSPUtil.getNull(dbRowset.getString("DG_CLASS")) + "\n");
				sbObj.append("DG_CLASS2:" + JSPUtil.getNull(dbRowset.getString("DG_CLASS2")) + "\n"); // New Field
				sbObj.append("DG_ZONE:" + JSPUtil.getNull(dbRowset.getString("DG_ZONE")) + "\n");
				sbObj.append("DG_RESIDUE:" + JSPUtil.getNull(dbRowset.getString("DG_RESIDUE")) + "\n");
				sbObj.append("DG_ERAP_CD:" + JSPUtil.getNull(dbRowset.getString("DG_ERAP_CD")) + "\n"); // New Field
				sbObj.append("DG_ERAP_TEL:" + JSPUtil.getNull(dbRowset.getString("DG_ERAP_TEL")) + "\n"); // New Field
				sbObj.append("DG_PGRP:" + JSPUtil.getNull(dbRowset.getString("DG_PGRP")) + "\n");
				sbObj.append("DG_PSAGRP:" + JSPUtil.getNull(dbRowset.getString("DG_PSAGRP")) + "\n");
				sbObj.append("DG_MP:" + JSPUtil.getNull(dbRowset.getString("DG_MP")) + "\n");
				sbObj.append("DG_FLSHTEMP:" + JSPUtil.getNull(dbRowset.getString("DG_FLSHTEMP")) + "\n");
				sbObj.append("DG_FLSHUNIT:" + JSPUtil.getNull(dbRowset.getString("DG_FLSHUNIT")) + "\n");
				sbObj.append("DG_QTY:" + JSPUtil.getNull(dbRowset.getString("DG_QTY")) + "\n");
				sbObj.append("DG_QUNIT:" + JSPUtil.getNull(dbRowset.getString("DG_QUNIT")) + "\n");
				sbObj.append("DG_WEIGHT:" + JSPUtil.getNull(dbRowset.getString("DG_WEIGHT")) + "\n");
				sbObj.append("DG_WUNIT:" + JSPUtil.getNull(dbRowset.getString("DG_WUNIT")) + "\n");
				sbObj.append("DG_CLASS1NEW:" + JSPUtil.getNull(dbRowset.getString("DG_CLASS1NEW")) + "\n");
				sbObj.append("DG_CLASS1NEWUNIT:" + JSPUtil.getNull(dbRowset.getString("DG_CLASS1NEWUNIT")) + "\n");
				sbObj.append("DG_LIMIT:" + JSPUtil.getNull(dbRowset.getString("DG_LIMIT")) + "\n");
				sbObj.append("DG_LIMIT_QTY:" + JSPUtil.getNull(dbRowset.getString("DG_LIMIT_QTY")) + "\n");

				dot_auth_no = dbRowset.getString("dot_auth_no");
				dot_spcl_apro_no = dbRowset.getString("dot_spcl_apro_no");
				dot_exp_no = dbRowset.getString("dot_exp_no");

				if (!CheckUtilities.isInBlank(dot_auth_no) || !CheckUtilities.isInBlank(dot_spcl_apro_no) || !CheckUtilities.isInBlank(dot_exp_no)) {
					if (!CheckUtilities.isInBlank(dot_auth_no)) {
						sbObj.append("{REF").append("\n");
						sbObj.append("DG_DOT_TP:").append("HA").append("\n");
						sbObj.append("DG_DOT_NO:").append(dot_auth_no).append("\n");
						sbObj.append("}REF").append("\n");
					}
					if (!CheckUtilities.isInBlank(dot_spcl_apro_no)) {
						sbObj.append("{REF").append("\n");
						sbObj.append("DG_DOT_TP:").append("S0").append("\n");
						sbObj.append("DG_DOT_NO:").append(dot_spcl_apro_no).append("\n");
						sbObj.append("}REF").append("\n");
					}
					if (!CheckUtilities.isInBlank(dot_exp_no)) {
						sbObj.append("{REF").append("\n");
						sbObj.append("DG_DOT_TP:").append("HE").append("\n");
						sbObj.append("DG_DOT_NO:").append(dot_exp_no).append("\n");
						sbObj.append("}REF").append("\n");
					}
				} else {
					sbObj.append("{REF").append("\n");
					sbObj.append("DG_DOT_TP:\n");
					sbObj.append("DG_DOT_NO:\n");
					sbObj.append("}REF").append("\n");
				}
				sbObj.append("DG_TEL:" + JSPUtil.getNull(dbRowset.getString("DG_TEL")) + "\n");
				sbObj.append("DG_CONTACT:" + JSPUtil.getNull(dbRowset.getString("DG_CONTACT")) + "\n");
				sbObj.append("DG_DECLARANT:" + JSPUtil.getNull(dbRowset.getString("DG_DECLARANT")) + "\n"); // New Field
				sbObj.append("DG_SPCL_PROVISION:" + JSPUtil.getNull(dbRowset.getString("DG_SPCL_PROVISION")) + "\n");// New Field
				sbObj.append("}DG\n");
			}
		}
		if (cnt == 0) {
			sbObj.append("{DG\n");
			sbObj.append("DG_STCC:\n");
			sbObj.append("DG_UN:\n");
			sbObj.append("CFR_NBR:\n");
			sbObj.append("DG_NAME:\n");
			sbObj.append("DG_TECH:\n");
			sbObj.append("DG_CONTENTS:\n");
			sbObj.append("DG_CLASS:\n");
			sbObj.append("DG_CLASS2:\n"); // New Field
			sbObj.append("DG_ZONE:\n");
			sbObj.append("DG_RESIDUE:\n");
			sbObj.append("DG_ERAP_CD:\n"); // New Field
			sbObj.append("DG_ERAP_TEL:\n"); // New Field
			sbObj.append("DG_PGRP:\n");
			sbObj.append("DG_PSAGRP:\n");
			sbObj.append("DG_MP:\n");
			sbObj.append("DG_FLSHTEMP:\n");
			sbObj.append("DG_FLSHUNIT:\n");
			sbObj.append("DG_QTY:\n");
			sbObj.append("DG_QUNIT:\n");
			sbObj.append("DG_WEIGHT:\n");
			sbObj.append("DG_WUNIT:\n");
			sbObj.append("DG_CLASS1NEW:\n");
			sbObj.append("DG_CLASS1NEWUNIT:\n");
			sbObj.append("DG_LIMIT:\n");
			sbObj.append("DG_LIMIT_QTY:\n");
			sbObj.append("{REF\n");
			sbObj.append("DG_DOT_TP:\n"); // New Field
			sbObj.append("DG_DOT_NO:\n");// New Field
			sbObj.append("}REF\n");
			sbObj.append("DG_TEL:\n");
			sbObj.append("DG_CONTACT:\n");
			sbObj.append("DG_DECLARANT:\n"); // New Field
			sbObj.append("DG_SPCL_PROVISION:\n");// New Field
			sbObj.append("}DG\n");
		}
	}

	/**
	 * 
	 * @param sb
	 * @param rowSet
	 * @throws Exception
	 */
	private void funcSetFFRount(StringBuffer sb, DBRowSet rowSet) throws Exception {
		String sRailCmb = JSPUtil.getNull(rowSet.getString("RAIL_CMB"));
		if (sRailCmb.equals("C1T") || sRailCmb.equals("S2R") || sRailCmb.equals("S3R")) {
			sb.append("{ROUTE\n");
			sb.append("ROUTCARR:" + JSPUtil.getNull(rowSet.getString("ROUTCARR")) + "\n");
			sb.append("ROUTSEQ:" + JSPUtil.getNull(rowSet.getString("ROUTSEQ")) + "\n");
			sb.append("ROUTCITY:" + JSPUtil.getNull(rowSet.getString("ROUTCITY")) + "\n");
			sb.append("INTMOSVR:" + JSPUtil.getNull(rowSet.getString("INTMOSVR")) + "\n");
			sb.append("TRANSTP:" + JSPUtil.getNull(rowSet.getString("TRANSTP")) + "\n");
			sb.append("TOYD:" + JSPUtil.getNull(rowSet.getString("TO_YARD_CD")) + "\n");
			sb.append("CONTRACT:" + JSPUtil.getNull(rowSet.getString("CONTRACT")) + "\n");
			sb.append("}ROUTE\n");
		} else {
			sb.append("{ROUTE\n");
			sb.append("ROUTCARR:" + JSPUtil.getNull(rowSet.getString("ROUTCARR")) + "\n");
			sb.append("ROUTSEQ:" + JSPUtil.getNull(rowSet.getString("ROUTSEQ")) + "\n");
			sb.append("ROUTCITY:" + JSPUtil.getNull(rowSet.getString("ROUTCITY")) + "\n");
			sb.append("INTMOSVR:" + JSPUtil.getNull(rowSet.getString("INTMOSVR")) + "\n");
			sb.append("TRANSTP:" + JSPUtil.getNull(rowSet.getString("TRANSTP")) + "\n");
			sb.append("TOYD:" + JSPUtil.getNull(rowSet.getString("TO_YARD_CD")) + "\n");
			sb.append("CONTRACT:" + JSPUtil.getNull(rowSet.getString("CONTRACT")) + "\n");
			sb.append("}ROUTE\n");
			sb.append("{ROUTE\n");
			sb.append("ROUTCARR:" + JSPUtil.getNull(rowSet.getString("ROUTCARR2")) + "\n");
			sb.append("ROUTSEQ:" + JSPUtil.getNull(rowSet.getString("ROUTSEQ2")) + "\n");
			sb.append("ROUTCITY:" + JSPUtil.getNull(rowSet.getString("ROUTCITY2")) + "\n");
			sb.append("INTMOSVR:" + JSPUtil.getNull(rowSet.getString("INTMOSVR2")) + "\n");
			sb.append("TRANSTP:" + JSPUtil.getNull(rowSet.getString("TRANSTP2")) + "\n");
			sb.append("TOYD:" + JSPUtil.getNull(rowSet.getString("TO_YARD_CD2")) + "\n");
			sb.append("CONTRACT:" + JSPUtil.getNull(rowSet.getString("CONTRACT2")) + "\n");
			sb.append("}ROUTE\n");
			if (sRailCmb.equals("C3T") || sRailCmb.equals("C3R") || sRailCmb.equals("C3S")) {
				sb.append("{ROUTE\n");
				sb.append("ROUTCARR:" + JSPUtil.getNull(rowSet.getString("ROUTCARR3")) + "\n");
				sb.append("ROUTSEQ:" + JSPUtil.getNull(rowSet.getString("ROUTSEQ3")) + "\n");
				sb.append("ROUTCITY:" + JSPUtil.getNull(rowSet.getString("ROUTCITY3")) + "\n");
				sb.append("INTMOSVR:" + JSPUtil.getNull(rowSet.getString("INTMOSVR3")) + "\n");
				sb.append("TRANSTP:" + JSPUtil.getNull(rowSet.getString("TRANSTP3")) + "\n");
				sb.append("TOYD:" + JSPUtil.getNull(rowSet.getString("TO_YARD_CD3")) + "\n");
				sb.append("CONTRACT:" + JSPUtil.getNull(rowSet.getString("CONTRACT3")) + "\n");
				sb.append("}ROUTE\n");
			}
		}
	}

	/**
	 * 
	 * @param sb
	 * @param rowSet
	 * @throws Exception
	 */
	private void funcSetFFContainerSealNo(StringBuffer sb, DBRowSet rowSet) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("bkg_no", rowSet.getString("BKGNO"));
		param.put("cntr_no", rowSet.getString("CNTR_NO_R"));
		DBRowSet dbRowset = dbDao.searchUSA404EDICntrSeal(param);
		if (dbRowset != null && dbRowset.getRowCount() > 0) {
			while (dbRowset.next()) {
				sb.append("{CONTAINER_SEAL_NO\n");
				sb.append("SEAL_NO:" + JSPUtil.getNull(dbRowset.getString("CNTR_SEAL_NO")) + "\n");
				sb.append("}CONTAINER_SEAL_NO\n");
			}
		} else {
			sb.append("{CONTAINER_SEAL_NO\n");
			sb.append("SEAL_NO:\n");
			sb.append("}CONTAINER_SEAL_NO\n");
		}
	}

	/**
	 * 
	 * @param sb
	 * @param rowSet
	 * @throws Exception
	 */
	private void funcSetFFRef(StringBuffer sb, DBRowSet rowSet) throws Exception {
		sb.append("{REF\n");
		sb.append("REFID:" + JSPUtil.getNull(rowSet.getString("REFID")) + "\n");
		sb.append("REFVAL:" + JSPUtil.getNull(rowSet.getString("REFVAL")) + "\n");
		sb.append("}REF\n");
	}

	/**
	 * 
	 * @param sb
	 * @param rowSet
	 * @throws Exception
	 */
	private void funcSetFFSplitBl(StringBuffer sb, DBRowSet rowSet) throws Exception {
		sb.append("{SPLITBL\n");
		sb.append("SPLITBL:" + JSPUtil.getNull(rowSet.getString("SPLITBL")) + "\n");
		sb.append("}SPLITBL\n");
	}

	/**
	 * 
	 * @param sb
	 * @param rowSet
	 * @throws Exception
	 */
	private void funcSetFFOld(StringBuffer sb, DBRowSet rowSet) throws Exception {
		sb.append("{OLD\n");
		sb.append("APPRECV_C_OLD:" + "\n");
		sb.append("BKGNO_OLD:" + "\n");
		sb.append("BLNO_OLD:" + "\n");
		sb.append("CREDIT_OLD:" + "\n");
		sb.append("EQINIT_OLD:" + "\n");
		sb.append("EQNO_OLD:" + "\n");
		sb.append("SNDDT_OLD:" + "\n");
		sb.append("}OLD\n");
	}

	/**
	 * 
	 * @param sb
	 * @param mstDbRowset
	 * @throws Exception
	 */
	private void funcBlGrpForCnFF(StringBuffer sb, DBRowSet mstDbRowset) throws Exception {
		DBRowSet blGrpDbRowSet = null;
		try {
			blGrpDbRowSet = dbDao.searchBlGrpForCnFF(mstDbRowset);
			while (blGrpDbRowSet.next()) {
				sb.append("{BL_GRP\n");
				sb.append("BL_BLNO:" + CheckUtilities.isNullReplacement(blGrpDbRowSet.getString("BL_BLNO"), blGrpDbRowSet.getString("BL_BKGNO")) + "\n");
				sb.append("BL_LADEQTY:" + JSPUtil.getNull(blGrpDbRowSet.getString("BL_LADEQTY")) + "\n");
				sb.append("BL_LADEDESC:" + JSPUtil.getNull(blGrpDbRowSet.getString("BL_LADEDESC")) + "\n");
				sb.append("BL_COMMCODE:" + JSPUtil.getNull(blGrpDbRowSet.getString("BL_COMMCODE")) + "\n");
				sb.append("BL_PACKFORM:" + JSPUtil.getNull(blGrpDbRowSet.getString("BL_PACKFORM")) + "\n");
				sb.append("}BL_GRP\n");
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 
	 * @param sb
	 * @param rowSet
	 * @throws Exception
	 */
	private void funcCntrMfForCnFF(StringBuffer sb, DBRowSet mstDbRowset) throws Exception {
		DBRowSet cntrMfDbRowSet = null;
		try {
			cntrMfDbRowSet = dbDao.searchCntrMfForCnFF(mstDbRowset);
			while (cntrMfDbRowSet.next()) {
				sb.append("{CNTR_MF\n");
				sb.append("CM_LINE_ITEM:" + JSPUtil.getNull(cntrMfDbRowSet.getString("CM_LINE_ITEM")) + "\n");
				sb.append("CM_PACKQTY:" + JSPUtil.getNull(cntrMfDbRowSet.getString("CM_PACKQTY")) + "\n");
				sb.append("CM_PACKDESC:" + JSPUtil.getNull(cntrMfDbRowSet.getString("CM_PACKDESC")) + "\n");
				sb.append("CM_PACKFORM:" + JSPUtil.getNull(cntrMfDbRowSet.getString("CM_PACKFORM")) + "\n");
				sb.append("CM_WEIGHT:" + JSPUtil.getNull(cntrMfDbRowSet.getString("CM_WEIGHT")) + "\n");
				sb.append("}CNTR_MF\n");
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * ESD_TRS_028 - Multi-event processing<br>
	 * 404EDI Send EDI Send
	 * 
	 * @param list
	 * @param cancelFlg
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchFlatFileKleinSchmitRailBill(List<Object> list, String cancelFlg) throws EventException {
		DBRowSet rowSet = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			rowSet = dbDao.searchFlatFileKleinSchmitRailBill(list, cancelFlg);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * ESD_TRS_028 - Multi-event processing<br>
	 * 404EDI Send EDI Send
	 * 
	 * @param rowSet
	 * @throws EventException
	 */
	public void ediSendKleinSchmitRailBill(DBRowSet rowSet) throws EventException {
		DBRowSet equipDbRowSet = null;
		DBRowSet dtlDbRowSet = null;
		DBRowSet addressDbRowSet = null;
		DBRowSet dgRowSet = null;
		try {
			StringBuilder sb = new StringBuilder();
			while (rowSet.next()) {
				sb.append("$$$MSGSTART:" + StringUtils.rightPad("RIBS", 20, "") + StringUtils.rightPad("KLEINSCHMIDT", 20, "") + StringUtils.rightPad("RAILBILL", 10, "") + getEdiReferenceNo()).append("\n");
				sb.append("{HEADER").append("\n");
				sb.append("ORG_YARD:").append(checkBlankToReplace(rowSet, "ORG_YARD", null)).append("\n");
				sb.append("ORG_CITY:").append(checkBlankToReplace(rowSet, "ORG_CITY", null)).append("\n");
				sb.append("ORG_STATE:").append(checkBlankToReplace(rowSet, "ORG_STATE", null)).append("\n");
				sb.append("DEST_YARD:").append(checkBlankToReplace(rowSet, "DEST_YARD", null)).append("\n");
				sb.append("DEST_CITY:").append(checkBlankToReplace(rowSet, "DEST_CITY", null)).append("\n");
				sb.append("DEST_STATE:").append(checkBlankToReplace(rowSet, "DEST_STATE", null)).append("\n");
				sb.append("1ST_CARRIER:").append(checkBlankToReplace(rowSet, "N1ST_CARRIER", null)).append("\n");
				sb.append("1ST_INTERCHANGE:").append(checkBlankToReplace(rowSet, "N1ST_INTERCHANGE", null)).append("\n");
				sb.append("2ND_CARRIER:").append(checkBlankToReplace(rowSet, "N2ND_CARRIER", null)).append("\n");
				sb.append("2ND_INTERCHANGE:").append(checkBlankToReplace(rowSet, "N2ND_INTERCHANGE", null)).append("\n");
				sb.append("3RD_CARRIER:").append(checkBlankToReplace(rowSet, "N3RD_CARRIER", null)).append("\n");
				sb.append("1ST_AUTH:").append(checkBlankToReplace(rowSet, "N1ST_AUTH", null)).append("\n");
				sb.append("2ND_AUTH:").append(checkBlankToReplace(rowSet, "N2ND_AUTH", null)).append("\n");
				sb.append("3RD_AUTH:").append(checkBlankToReplace(rowSet, "N3RD_AUTH", null)).append("\n");
				sb.append("1ST_PLAN:").append(checkBlankToReplace(rowSet, "N1ST_PLAN", null)).append("\n");
				sb.append("2ND_PLAN:").append(checkBlankToReplace(rowSet, "N2ND_PLAN", null)).append("\n");
				sb.append("3RD_PLAN:").append(checkBlankToReplace(rowSet, "N3RD_PLAN", null)).append("\n");
				sb.append("EQ_TPYE:").append(checkBlankToReplace(rowSet, "EQ_TPYE", null)).append("\n");
				sb.append("1ST_RULE:").append(checkBlankToReplace(rowSet, "N1ST_RULE", null)).append("\n");
				sb.append("2ND_RULE:").append(checkBlankToReplace(rowSet, "N2ND_RULE", null)).append("\n");
				sb.append("MSG_TYPE:").append(checkBlankToReplace(rowSet, "MSG_TYPE", null)).append("\n");
				sb.append("}HEADER").append("\n");
				equipDbRowSet = dbDao.searchFlatFileKleinSchmitRailBillEquement(rowSet);
				while (equipDbRowSet.next()) {
					sb.append("{EQUIP").append("\n");
					dtlDbRowSet = dbDao.searchFlatFileKleinSchmitRailBillDetail(equipDbRowSet);
					while (dtlDbRowSet.next()) {
						sb.append("{DETAIL").append("\n");
						sb.append("EQ_NO:").append(checkBlankToReplace(dtlDbRowSet, "EQ_NO", null)).append("\n");
						sb.append("EQ_TPSZ:").append(checkBlankToReplace(dtlDbRowSet, "EQ_TPSZ", null)).append("\n");
						sb.append("EQ_STS:").append(checkBlankToReplace(dtlDbRowSet, "EQ_STS", null)).append("\n");
						sb.append("GROSS_WGT:").append(checkBlankToReplace(dtlDbRowSet, "GROSS_WGT", null)).append("\n");
						sb.append("GROSS_WGT_UNIT:").append(checkBlankToReplace(dtlDbRowSet, "WGT_UNIT", null)).append("\n");
						sb.append("TARE_WGT:").append(checkBlankToReplace(dtlDbRowSet, "TARE_WGT", null)).append("\n");
						sb.append("TARE_WGT_UNIT:").append(checkBlankToReplace(dtlDbRowSet, "WGT_UNIT", null)).append("\n");
						sb.append("CARGO_WGT:").append(checkBlankToReplace(dtlDbRowSet, "CARGO_WGT", null)).append("\n");
						sb.append("CARGO_WGT_UNIT:").append(checkBlankToReplace(dtlDbRowSet, "WGT_UNIT", null)).append("\n");
						sb.append("NTFY_NM:").append(checkBlankToReplace(dtlDbRowSet, "NTFY_NM", null)).append("\n");
						sb.append("NTFY_TE:").append(checkBlankToReplace(dtlDbRowSet, "NTFY_TE", null)).append("\n");
						sb.append("NTFY_FX:").append(checkBlankToReplace(dtlDbRowSet, "NTFY_FX", null)).append("\n");
						sb.append("DOMESTIC_NM:").append(checkBlankToReplace(dtlDbRowSet, "DOMESTIC_NM", null)).append("\n");
						sb.append("STCC_CD:").append(checkBlankToReplace(dtlDbRowSet, "STCC_CD", null)).append("\n");
						sb.append("STCC_DESC:").append(checkBlankToReplace(dtlDbRowSet, "STCC_DESC", null)).append("\n");
						sb.append("BKG_NO:").append(checkBlankToReplace(dtlDbRowSet, "BKG_NO", null)).append("\n");
						sb.append("BL_NO:").append(checkBlankToReplace(dtlDbRowSet, "BL_NO", null)).append("\n");
						sb.append("DOMESTIC_BKG_NO:").append(checkBlankToReplace(dtlDbRowSet, "DOMESTIC_BKG_NO", null)).append("\n");
						sb.append("POL_YD:").append(checkBlankToReplace(dtlDbRowSet, "POL_YD", null)).append("\n");
						sb.append("POL_NM:").append(checkBlankToReplace(dtlDbRowSet, "POL_NM", null)).append("\n");
						sb.append("POD_YD:").append(checkBlankToReplace(dtlDbRowSet, "POD_YD", null)).append("\n");
						sb.append("POD_NM:").append(checkBlankToReplace(dtlDbRowSet, "POD_NM", null)).append("\n");
						sb.append("VSL_CD:").append(checkBlankToReplace(dtlDbRowSet, "VSL_CD", null)).append("\n");
						sb.append("VSL_NM:").append(checkBlankToReplace(dtlDbRowSet, "VSL_NM", null)).append("\n");
						sb.append("VSL_VOY:").append(checkBlankToReplace(dtlDbRowSet, "VSL_VOY", null)).append("\n");
						sb.append("STATUS:").append(checkBlankToReplace(dtlDbRowSet, "STATUS", null)).append("\n");
						sb.append("TRANS_NO:").append(checkBlankToReplace(dtlDbRowSet, "TRANS_NO", null)).append("\n");
						sb.append("IMEX:").append(checkBlankToReplace(dtlDbRowSet, "IMEX", null)).append("\n");
						sb.append("INBOND_TP:").append(checkBlankToReplace(dtlDbRowSet, "INBOND_TP", null)).append("\n");
						sb.append("IT_NO:").append(checkBlankToReplace(dtlDbRowSet, "IT_NO", null)).append("\n");
						sb.append("RAILBILL_DT:").append(checkBlankToReplace(dtlDbRowSet, "RAILBILL_DT", null)).append("\n");
						sb.append("MT_PLAN_NO:").append(checkBlankToReplace(dtlDbRowSet, "MT_PLAN_NO", null)).append("\n");
						sb.append("TEMP:").append(checkBlankToReplace(dtlDbRowSet, "TEMP", null)).append("\n");
						sb.append("TEMP_UNIT:").append(checkBlankToReplace(dtlDbRowSet, "TEMP_UNIT", null)).append("\n");
						sb.append("PROTECT:").append(checkBlankToReplace(dtlDbRowSet, "PROTECT", null)).append("\n");
						sb.append("VSL_CUTOVER_DT:").append(checkBlankToReplace(dtlDbRowSet, "VSL_CUTOVER_DT", null)).append("\n");
						sb.append("ETA:").append(checkBlankToReplace(dtlDbRowSet, "ETA", null)).append("\n");
						sb.append("SEAL:").append(checkBlankToReplace(dtlDbRowSet, "SEAL", null)).append("\n");
						sb.append("}DETAIL").append("\n");
					}
					addressDbRowSet = dbDao.searchFlatFileKleinSchmitRailBillAddress(equipDbRowSet);
					if (addressDbRowSet != null && addressDbRowSet.getRowCount() > 0) {
						while (addressDbRowSet.next()) {
							sb.append("{ADDRESS").append("\n");
							sb.append("PARTY_TP:").append(checkBlankToReplace(addressDbRowSet, "PARTY_TP", null)).append("\n");
							sb.append("PARTY_NM:").append(checkBlankToReplace(addressDbRowSet, "PARTY_NM", null)).append("\n");
							sb.append("PARTY_ADD1:").append(checkBlankToReplace(addressDbRowSet, "PARTY_ADD1", null)).append("\n");
							sb.append("PARTY_ADD2:").append(checkBlankToReplace(addressDbRowSet, "PARTY_ADD2", null)).append("\n");
							sb.append("PARTY_CITY:").append(checkBlankToReplace(addressDbRowSet, "PARTY_CITY", null)).append("\n");
							sb.append("PARTY_STATE:").append(checkBlankToReplace(addressDbRowSet, "PARTY_STATE", null)).append("\n");
							sb.append("PARTY_POSTAL:").append(checkBlankToReplace(addressDbRowSet, "PARTY_POSTAL", null)).append("\n");
							sb.append("}ADDRESS").append("\n");
						}
					} else {
						sb.append("{ADDRESS").append("\n");
						sb.append("PARTY_TP:\n");
						sb.append("PARTY_NM:\n");
						sb.append("PARTY_ADD1:\n");
						sb.append("PARTY_ADD2:\n");
						sb.append("PARTY_CITY:\n");
						sb.append("PARTY_STATE:\n");
						sb.append("PARTY_POSTAL:\n");
						sb.append("}ADDRESS").append("\n");
					}
					dgRowSet = dbDao.searchFlatFileKleinSchmitRailBillDanger(equipDbRowSet);
					String dot_auth_no = null, dot_spcl_apro_no = null, dot_exp_no = null;
					while (dgRowSet.next()) {
						sb.append("{DANGER").append("\n");
						sb.append("PKG_CD:").append(checkBlankToReplace(dgRowSet, "PKG_CD", null)).append("\n");
						sb.append("PKG_QTY:").append(checkBlankToReplace(dgRowSet, "PKG_QTY", null)).append("\n");
						sb.append("UNBR:").append(checkBlankToReplace(dgRowSet, "UNBR", null)).append("\n");
						sb.append("CFR_NBR:").append(checkBlankToReplace(dgRowSet, "CFR_NBR", null)).append("\n");
						sb.append("DG_STCC:").append(checkBlankToReplace(dgRowSet, "DG_STCC", null)).append("\n");
						sb.append("GWGT:").append(checkBlankToReplace(dgRowSet, "GWGT", null)).append("\n");
						sb.append("GWGT_UNIT:").append(checkBlankToReplace(dgRowSet, "GWGT_UNIT", null)).append("\n");
						sb.append("NWGT:").append(checkBlankToReplace(dgRowSet, "NWGT", null)).append("\n");
						sb.append("NWGT_UNIT:").append(checkBlankToReplace(dgRowSet, "NWGT_UNIT", null)).append("\n");
						sb.append("CLASS:").append(checkBlankToReplace(dgRowSet, "CLASS", null)).append("\n");
						sb.append("CLASS2:").append(checkBlankToReplace(dgRowSet, "CLASS2", null)).append("\n");
						sb.append("PKG_GRP:").append(checkBlankToReplace(dgRowSet, "PKG_GRP", null)).append("\n");
						sb.append("PROPER:").append(checkBlankToReplace(dgRowSet, "PROPER", null)).append("\n");
						sb.append("PROPER_NOS:").append(checkBlankToReplace(dgRowSet, "PROPER_NOS", null)).append("\n");
						sb.append("TECHNICAL:").append(checkBlankToReplace(dgRowSet, "TECHNICAL", null)).append("\n");
						sb.append("DECLARANT:").append(checkBlankToReplace(dgRowSet, "DECLARANT", null)).append("\n");
						sb.append("SPCL_PROVISION:").append(checkBlankToReplace(dgRowSet, "SPCL_PROVISION", null)).append("\n");
						sb.append("ERAP_CD:").append(checkBlankToReplace(dgRowSet, "ERAP_CD", null)).append("\n");
						sb.append("ERAP_CONTACT:").append(checkBlankToReplace(dgRowSet, "ERAP_CONTACT", null)).append("\n");
						sb.append("FLASH:").append(checkBlankToReplace(dgRowSet, "FLASH", null)).append("\n");
						sb.append("FLASH_UNIT:").append(checkBlankToReplace(dgRowSet, "FLASH_UNIT", null)).append("\n");
						sb.append("TEMP_CONTROL:").append(checkBlankToReplace(dgRowSet, "TEMP_CONTROL", null)).append("\n");
						sb.append("TEMP_CONTROL_UNIT:").append(checkBlankToReplace(dgRowSet, "TEMP_CONTROL_UNIT", null)).append("\n");
						sb.append("TEMP_EMERENCY:").append(checkBlankToReplace(dgRowSet, "TEMP_EMERENCY", null)).append("\n");
						sb.append("TEMP_EMERENCY_UNIT:").append(checkBlankToReplace(dgRowSet, "TEMP_EMERENCY_UNIT", null)).append("\n");
						sb.append("WGT_NE:").append(checkBlankToReplace(dgRowSet, "WGT_NE", null)).append("\n");
						sb.append("WGT_NE_UNIT:").append(checkBlankToReplace(dgRowSet, "WGT_NE_UNIT", null)).append("\n");
						sb.append("PIOSON_ZONE:").append(checkBlankToReplace(dgRowSet, "PIOSON_ZONE", null)).append("\n");
						sb.append("LIMIT:").append(checkBlankToReplace(dgRowSet, "LIMIT", null)).append("\n");
						sb.append("MAR_POLL:").append(checkBlankToReplace(dgRowSet, "MAR_POLL", null)).append("\n");
						sb.append("D13_IND:").append(checkBlankToReplace(dgRowSet, "D13_IND", null)).append("\n");
						sb.append("HOT_IND:").append(checkBlankToReplace(dgRowSet, "HOT_IND", null)).append("\n");
						sb.append("INHALATION_IND:").append(checkBlankToReplace(dgRowSet, "INHALATION_IND", null)).append("\n");
						sb.append("RESIDUE_IND:").append(checkBlankToReplace(dgRowSet, "RESIDUE_IND", null)).append("\n");
						sb.append("PIOSON_IND:").append(checkBlankToReplace(dgRowSet, "PIOSON_IND", null)).append("\n");
						sb.append("RQ_IND:").append(checkBlankToReplace(dgRowSet, "RQ_IND", null)).append("\n");
						sb.append("{CONTACT").append("\n");
						sb.append("PIC_NM:").append(checkBlankToReplace(dgRowSet, "PIC_NM", null)).append("\n");
						sb.append("PIC_TEL:").append(checkBlankToReplace(dgRowSet, "PIC_TEL", null)).append("\n");
						sb.append("}CONTACT").append("\n");
						dot_auth_no = dgRowSet.getString("dot_auth_no");
						dot_spcl_apro_no = dgRowSet.getString("dot_spcl_apro_no");
						dot_exp_no = dgRowSet.getString("dot_exp_no");
						if (!CheckUtilities.isInBlank(dot_auth_no) || !CheckUtilities.isInBlank(dot_spcl_apro_no) || !CheckUtilities.isInBlank(dot_exp_no)) {
							if (!CheckUtilities.isInBlank(dot_auth_no)) {
								sb.append("{REF").append("\n");
								sb.append("DOT_TYPE:").append("HA").append("\n");
								sb.append("DOT_NO:").append(dot_auth_no).append("\n");
								sb.append("}REF").append("\n");
							}
							if (!CheckUtilities.isInBlank(dot_spcl_apro_no)) {
								sb.append("{REF").append("\n");
								sb.append("DOT_TYPE:").append("S0").append("\n");
								sb.append("DOT_NO:").append(dot_spcl_apro_no).append("\n");
								sb.append("}REF").append("\n");
							}
							if (!CheckUtilities.isInBlank(dot_exp_no)) {
								sb.append("{REF").append("\n");
								sb.append("DOT_TYPE:").append("HE").append("\n");
								sb.append("DOT_NO:").append(dot_exp_no).append("\n");
								sb.append("}REF").append("\n");
							}
						} else {
							sb.append("{REF").append("\n");
							sb.append("DOT_TYPE:\n");
							sb.append("DOT_NO:\n");
							sb.append("}REF").append("\n");
						}

						sb.append("}DANGER").append("\n");
					}
					sb.append("}EQUIP").append("\n");
				}
				eaiDao.return4040EDIsend(sb.toString());
				sb.setLength(0);
				sb.trimToSize();
			}
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * checkBlankToReplace
	 * 
	 * @param ds
	 * @param column
	 * @param defaultValue
	 * @return
	 * @throws Exception
	 */
	private String checkBlankToReplace(DBRowSet ds, String column, String defaultValue) throws Exception {
		String dbValue = null;
		try {
			dbValue = ds.getString(column.toLowerCase());
		} catch (Exception e) {
			log.error(e.getMessage());
			dbValue = "";
		}
		if (!CheckUtilities.isInBlank(dbValue)) {
			dbValue = dbValue.replaceAll("\r", "").replaceAll("\n", "").trim();
		} else {
			if (!CheckUtilities.isInBlank(defaultValue)) {
				dbValue = defaultValue.trim();
			}
		}
		return dbValue;
	}

	/**
	 * 
	 * @param receiverID
	 * @return
	 * @throws EventException
	 */
	private String getSenderIdAnMessageType(String receiverID) throws EventException {
		String ediHeader = "";
		String senderId = "";
		String messageType = "";

		if ("CN".equals(receiverID)) {
			senderId = "NYKS";
			messageType = "404";
		} else if ("CPRS".equals(receiverID)) {
			senderId = "NYKS";
			messageType = "404";
			receiverID = "CPRSP";
		} else if ("BNSF".equals(receiverID) || "CSXI".equals(receiverID) || "CSXT".equals(receiverID) || "CSLI".equals(receiverID) || "FEC".equals(receiverID) || "IAIS".equals(receiverID) || "KCS".equals(receiverID) || "NS".equals(receiverID) || "UP".equals(receiverID) || "WC".equals(receiverID)) {
			senderId = "RIBS";
			messageType = "404";
			receiverID = "KLEINSCHMIDT";
		} else if ("MAHER".equals(receiverID)) {
			senderId = "NYKS";
			messageType = "404";
			receiverID = "MAHER";
		} else {
			throw new EventException("Not available Vendor.");
		}
		try {
			ediHeader = "$$$MSGSTART:" + StringUtils.rightPad(senderId, 20, "") + StringUtils.rightPad(receiverID, 20, "") + StringUtils.rightPad(messageType, 10, "") + getEdiReferenceNo() + "\n";
		} catch (Exception e) {
			throw new EventException("Not available Vendor.");
		}

		return ediHeader;
	}

	/**
	 * searchFaxNoVndrEmlByVndrSeq <br>
	 * 
	 * @param e EventResponse
	 * @return EventResponse ESD_TRS_028EventResponse
	 * @exception EventException
	 */
	public EventResponse searchFaxNoVndrEmlByVndrSeq(Event e) throws EventException {
		EsdTrs0028Event event = (EsdTrs0028Event) e;
		DBRowSet rowSet = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			rowSet = dbDao.searchFaxNoVndrEmlByVndrSeq(event.getVndrSeq());
			String faxNo = "";
			String vndrEml = "";
			String vndrSeq = "";
			String vndrLglEngNm = "";
			String vndrLoclLangNm = "";
			if (rowSet.next()) {
				faxNo = rowSet.getString("FAX_NO");
				vndrEml = rowSet.getString("VNDR_EML");
				vndrSeq = rowSet.getString("VNDR_SEQ");
				vndrLglEngNm = rowSet.getString("VNDR_LGL_ENG_NM");
				vndrLoclLangNm = rowSet.getString("VNDR_LOCL_LANG_NM");
			}
			eventResponse.setETCData("fax_no", faxNo);
			eventResponse.setETCData("vndr_eml", vndrEml);
			eventResponse.setETCData("vndr_seq", vndrSeq);
			eventResponse.setETCData("vndr_lgl_eng_nm", vndrLglEngNm);
			eventResponse.setETCData("vndr_locl_lang_nm", vndrLoclLangNm);
			return eventResponse;
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Inquiry event process<br>
	 * 404EDI - Inquiry event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_0026EventResponse
	 * @exception EventException
	 */
	public EventResponse searchUSRailMoreCandidates(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSet = null; // DB ResultSet for sending data
		EsdTrs0026Event event = (EsdTrs0026Event) e;
		try {
			rowSet = dbDao.searchUSRailMoreCandidates(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception se) {
			log.error("err " + se.toString(), se);
			throw new EventException(se.getMessage());
		}
	}

	/**
	 * Insert event process<br>
	 * 404EDI - Insert event process<br>
	 * 
	 * @param Event e
	 * @exception EventException
	 */
	public void multiUSRailMoreCandidates(Event e) throws EventException {
		EsdTrs0026Event event = (EsdTrs0026Event) e;
		try {
			dbDao.multiUSRailMoreCandidates(event);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception se) {
			log.error("err " + se.toString(), se);
			throw new EventException(se.getMessage());
		}
	}

	/**
	 * Inquiry event process<br>
	 * 404EDI - Inquiry event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_0027EventResponse
	 * @exception EventException
	 */
	public EventResponse searchUSRailBasicRates(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSet = null;
		EsdTrs0027Event event = (EsdTrs0027Event) e;
		try {
			rowSet = dbDao.searchUSRailBasicRates(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception se) {
			log.error("err " + se.toString(), se);
			throw new EventException(se.getMessage());
		}
	}

	/**
	 * End process of TRS task scenario<br>
	 * Releasing the related implicit object when USA404EDIStatusInquiry task is end.<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}