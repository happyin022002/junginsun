/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : TRSInterfaceRSC.java
 *@FileTitle : trs EDI Receive
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.regex.Pattern;

import com.clt.apps.opus.esd.trs.servicesio.usarailwoack.basic.USARailWoAckManageBC;
import com.clt.apps.opus.esd.trs.servicesio.usarailwoack.basic.USARailWoAckManageBCImpl;
import com.clt.apps.opus.esd.trs.servicesio.usarailwoack.event.EdiEns001Event;
import com.clt.apps.opus.esd.trs.servicesio.usarailwoack.event.EdiEns002Event;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.utility.CheckUtilities;

/**
 * ENIS-BIZCOMMON Business Logic ServiceCommand<br>
 * - ENIS-BIZCOMMON에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author Lee Sang-Woo
 * @see ESD006_HU01EventResponse,USACargoReleaseManageDBDAO 참조
 * @since J2EE 1.4
 */
public class TRSInterfaceRSC extends ServiceCommandSupport {
	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ENIS-BIZCOMMON 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		if (e.getEventName().equalsIgnoreCase("EdiEns001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				manageUSARailWoAckMQ(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EdiEns002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				manageUSARail417WoAckMQ(e);
			}
		}
		return eventResponse;
	}

	/**
	 * EDI-027-IN-Vendor-824, 997 (US - 824, 997) EDI <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private void manageUSARailWoAckMQ(Event e) throws EventException {
		USARailWoAckManageBC command = new USARailWoAckManageBCImpl();
		try {
			HashMap<Object, Object> ff = receive812997FF(((EdiEns001Event) e).getString());
			String msgType = (String) ff.get("HEADER_MESSAGE_TYPE");
			if ("824".equals(msgType) || "997".equals(msgType)) {
				String bkgNbr = (String) ff.get("bkg_nbr");
				String cntrNbr = (String) ff.get("cntr_nbr");
				String orgMsgVnd = (String) ff.get("org_msg_vnd"); // USA_EDI_CD
				begin();
				if (!CheckUtilities.isInBlank(bkgNbr) && !CheckUtilities.isInBlank(cntrNbr)) {
					HashMap<String, String> p = new HashMap<String, String>();
					p.put("bkg_no", bkgNbr);
					p.put("eq_no", cntrNbr);
					p.put("usa_edi_cd", orgMsgVnd);
					DBRowSet dbRowSet = command.searchCreditSeqUsaEdiCd(p);
					if (dbRowSet != null) {
						String bilEdiCtrlSeq = null;
						String usaEdiCd = null;
						while (dbRowSet.next()) {
							bilEdiCtrlSeq = dbRowSet.getString("BIL_EDI_CTRL_SEQ");
							usaEdiCd = dbRowSet.getString("USA_EDI_CD");
							if ("KLEINSCHMIDT".equals(getSenderIdAnMessageType(usaEdiCd))) {
								ff.put("org_credit", bilEdiCtrlSeq);
							}
							if (!CheckUtilities.isInBlank(String.valueOf(ff.get("org_credit"))) && CheckUtilities.isInOnlyNumber(String.valueOf(ff.get("org_credit")))) {
								command.receiveUSARailWoAckManageList(ff);
								command.receiveUSARailReWoAckManageList(ff);
							}
						}
					}
				} else {
					if (!CheckUtilities.isInBlank(String.valueOf(ff.get("org_credit"))) && CheckUtilities.isInOnlyNumber(String.valueOf(ff.get("org_credit")))) {
						command.receiveUSARailWoAckManageList(ff);
						command.receiveUSARailReWoAckManageList(ff);
					}
				}
				commit();
			}
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
	 * EDI-027-IN-Vendor-417 (417) EDI <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private void manageUSARail417WoAckMQ(Event e) throws EventException {
		USARailWoAckManageBC command = new USARailWoAckManageBCImpl();
		try {
			begin();
			HashMap<Object, Object> ff = receive417FF((EdiEns002Event) e);
			String msgType = (String) ff.get("HEADER_MESSAGE_TYPE");
			if ("417".equals(msgType)) {
				command.receiveManageUSARail417WoAck(ff);
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
	 * EDI F/F Parsing - Receive 812,997
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 */
	private HashMap<Object, Object> receive812997FF(String str) throws Exception {
		HashMap<Object, Object> retruObject = new HashMap<Object, Object>();
		if (!CheckUtilities.isNull(str)) {
			InputStream is = new ByteArrayInputStream(str.getBytes());
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line;
			while ((line = br.readLine()) != null) {
				if (line.startsWith("$$$MSGSTART:")) {
					retruObject.put("HEADER_SENDER_ID", ((String) line.subSequence(12, 32)).trim());
					retruObject.put("HEADER_RECEIVER_ID", ((String) line.subSequence(32, 52)).trim());
					retruObject.put("HEADER_MESSAGE_TYPE", ((String) line.subSequence(52, 62)).trim());
					retruObject.put("HEADER_REFERENCE_NO", ((String) line.subSequence(62, 77)).trim());
				} else {
					String[] o = line.split(Pattern.quote(":"));
					retruObject.put(o[0].toLowerCase(), o.length > 1 ? o[1].trim() : "");
				}
			}
			br.close();
		}
		return retruObject;
	}

	/**
	 * EDI F/F Parsing - Receive 417
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 */
	private HashMap<Object, Object> receive417FF(EdiEns002Event e) throws Exception {
		String str = e.getString();
		HashMap<Object, Object> retruObject = new HashMap<Object, Object>();
		if (!CheckUtilities.isNull(str)) {
			InputStream is = new ByteArrayInputStream(str.getBytes());
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line;
			while ((line = br.readLine()) != null) {
				if (line.startsWith("$$$MSGSTART:")) {
					retruObject.put("HEADER_SENDER_ID", ((String) line.subSequence(12, 32)).trim());
					retruObject.put("HEADER_RECEIVER_ID", ((String) line.subSequence(32, 52)).trim());
					retruObject.put("HEADER_MESSAGE_TYPE", ((String) line.subSequence(52, 62)).trim());
					retruObject.put("HEADER_REFERENCE_NO", ((String) line.subSequence(62, 77)).trim());
				} else if (line.startsWith("BKG_NO:") || line.startsWith("BL_NO:") || line.startsWith("CNTR_NO:") || line.startsWith("INBOND_NO:") || line.startsWith("CNRU_NO:")) {
					String[] o = line.split(Pattern.quote(":"));
					retruObject.put(o[0].toLowerCase(), o.length > 1 ? o[1].trim() : "");
				}
			}
			br.close();
		}
		return retruObject;
	}

	/**
	 * 
	 * @param receiverID
	 * @return
	 */
	private String getSenderIdAnMessageType(String receiverID) {
		String ediHeader = receiverID;
		if ("BNSF".equals(receiverID) || "CSXI".equals(receiverID) || "CSXT".equals(receiverID) || "CSLI".equals(receiverID) || "FEC".equals(receiverID) || "IAIS".equals(receiverID) || "KCS".equals(receiverID) || "NS".equals(receiverID) || "UP".equals(receiverID) || "WC".equals(receiverID)) {
			ediHeader = "KLEINSCHMIDT";
		}
		return ediHeader;
	}
}
