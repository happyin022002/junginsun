/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : SOInquiryBCImpl.java
 *@FileTitle : SO Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.soinquiry.soinquiry.basic;

import com.clt.apps.opus.esd.trs.soinquiry.soinquiry.event.EsdTrs0019Event;
import com.clt.apps.opus.esd.trs.soinquiry.soinquiry.integration.SOInquiryDBDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * 
 * 
 * @author
 * @see ESD_TRS_019EventResponse,SOInquiryBC
 * @since J2EE 1.4
 */
public class SOInquiryBCImpl extends BasicCommandSupport implements SOInquiryBC {

	// Database Access Object
	private transient SOInquiryDBDAO dbDao = null;

	/**
	 * ChassisGensetSOManageBCImpl <br>
	 * ChassisGensetSOManageDBDAO<br>
	 */
	public SOInquiryBCImpl() {
		dbDao = new SOInquiryDBDAO();
	}

	/**
	 * Inquiry event process<br>
	 * SOInquiry - Inquiry event process<br>
	 * 
	 * @param e ESD_TRS_019Event
	 * @param soffice_cd
	 * @return EventResponse ESD_TRS_019EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSOInquiry(Event e, String soffice_cd) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0019Event event = (EsdTrs0019Event) e;
		try {
			eventResponse.setRsVo(dbDao.searchSOInquiry(event, soffice_cd));
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}


	/**
	 * Checking office<br>
	 * SOInquiry - Inquiry event process<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	public EventResponse search_office(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSet = null; // DB ResultSet for sending data
		EsdTrs0019Event event = (EsdTrs0019Event) e;

		try {
			rowSet = dbDao.search_office(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	@Override
	public String[] getColumns(Event e) {
		EsdTrs0019Event event = (EsdTrs0019Event) e;
		String hidUsRail = event.getHidUsRail();
		String hidUsdropnpull = event.getHidUsDropNPull();

		int sizeofarray = 139;
		if (hidUsRail.equalsIgnoreCase("Y")) {
			sizeofarray = sizeofarray + 3;
		}
		if (hidUsdropnpull.equalsIgnoreCase("Y")) {
			sizeofarray = sizeofarray + 10;
		}

		String[] titleField = new String[sizeofarray];

		int i = 0;
		titleField[i++] = " ";
		titleField[i++] = "EQ_NO";
		titleField[i++] = "EQ_TPSZ";
		titleField[i++] = "ORG_EQ_TPSZ";
		titleField[i++] = "TRSP_COST_DTL_MOD_CD";
		titleField[i++] = "TRSP_CRR_MOD_CD";
		titleField[i++] = "TRSP_SO_TP_CD";
		titleField[i++] = "UPLN_SO_FLG";
		titleField[i++] = "BKG_CNTR_CMB_SEQ";
		titleField[i++] = "TRSP_FRST_FLG";
		titleField[i++] = "SO_NO";
		titleField[i++] = "SO_CRE_DT1";
		titleField[i++] = "SO_DEL_FLG";
		titleField[i++] = "SO_DEL_DT";
		titleField[i++] = "UPD_USR_ID";
		titleField[i++] = "WO_NO";
		titleField[i++] = "WO_ISS_STS_CD";
		titleField[i++] = "WO_ISS_DT";
		titleField[i++] = "WO_ISS_TP";
		titleField[i++] = "WO_ISS_OFC_CD";
		titleField[i++] = "WO_ISS_ID";
		titleField[i++] = "FM_NOD_CD";
		titleField[i++] = "VIA_NOD_CD";
		titleField[i++] = "TO_NOD_CD";
		titleField[i++] = "DOOR";
		// titleField[i++] = "DOOR_ACT_CUST" ;
		titleField[i++] = "DOOR_FCTRY_NM";
		titleField[i++] = "DOOR_ZIP";
		titleField[i++] = "DOR_DE_ADDR";
		titleField[i++] = "DOOR_TEL";
		titleField[i++] = "DOOR_FAX";
		titleField[i++] = "DOOR_PIC";
		// titleField[i++] = "USA_DO_USR_INFO" ;
		// titleField[i++] = "DO_CRE_DATE" ;
		// titleField[i++] = "DO_CRE_TIME" ;
		titleField[i++] = "VNDR_TP_CD";
		titleField[i++] = "VNDR_CD";
		titleField[i++] = "VNDR_ABBR_NM";
		titleField[i++] = "PVNDR_CD";
		titleField[i++] = "PVNDR_NM";
		titleField[i++] = "WO_RCV_DT";
		titleField[i++] = "APPT_TIME";
		titleField[i++] = "DELIV_TIME";
		titleField[i++] = "N3PTY_BIL_FLG";
		titleField[i++] = "COST_OFC_CD";
		titleField[i++] = "WO_CURR_CD";
		titleField[i++] = "WO_BZC_AMT";
		titleField[i++] = "WO_NEGO_AMT";
		titleField[i++] = "WO_FUEL_SCG_AMT";
		titleField[i++] = "WO_ETC_ADD_AMT";
		// ----------------
		if (hidUsRail.equalsIgnoreCase("Y")) {
			titleField[i++] = "WO_HZD_MTRL_SCG_AMT";
			titleField[i++] = "WO_OVR_WGT_SCG_AMT";
			titleField[i++] = "WO_USA_TTL_AMT";
		}
		titleField[i++] = "WO_TOT_AMT";
		titleField[i++] = "WO_TOT_AMT_USD";
		titleField[i++] = "INV_XCH_RT";
		titleField[i++] = "INV_CALC_LGC_TP_CD";
		titleField[i++] = "INV_CURR_CD";
		titleField[i++] = "INV_BZC_AMT";
		titleField[i++] = "INV_ETC_ADD_AMT";
		titleField[i++] = "INV_TOT_AMT";
		titleField[i++] = "INV_TOT_AMT_USD";
		titleField[i++] = "INV_VNDR_CD";
		titleField[i++] = "INV_VNDR_NM";
		titleField[i++] = "INV_NO";
		titleField[i++] = "INV_STS_CD";
		titleField[i++] = "INV_CFM_DT";
		titleField[i++] = "CAR_NO";
		// titleField[i++] = "INV_IF_DT" ;
		titleField[i++] = "INV_CFM_OFC_CD";
		titleField[i++] = "INV_CRE_USR_ID";
		titleField[i++] = "N1ST_NOD_PLN_DT";
		titleField[i++] = "LST_NOD_PLN_DT";
		titleField[i++] = "DOR_NOD_PLN_DT";
		titleField[i++] = "DOR_ARR_DT";
		titleField[i++] = "COP_NO";
		titleField[i++] = "AG_SEQ";
		titleField[i++] = "AG_CODE";
		titleField[i++] = "BKG_NO";
		titleField[i++] = "BL_NO";
		titleField[i++] = "TRSP_BND_CD";
		titleField[i++] = "TERM";
		titleField[i++] = "TRO_SEQ";
		titleField[i++] = "TRO_CNFM";
		titleField[i++] = "TRO_CFM_OFC";
		titleField[i++] = "TRO_CFM_USR";
		titleField[i++] = "TRO_CFM_UPD";
		titleField[i++] = "TRO_REV_CUR";
		titleField[i++] = "EUR_TRO_REV";
		titleField[i++] = "MANIFESTED";
		titleField[i++] = "TRO_LOD_REF";
		titleField[i++] = "BKG_QTY";
		titleField[i++] = "POR_CD";
		titleField[i++] = "POL_CD";
		titleField[i++] = "POD_CD";
		titleField[i++] = "DEL_CD";
		titleField[i++] = "T_VVD";
		titleField[i++] = "SLAN_CD";
		titleField[i++] = "IB_VVD_CD";
		titleField[i++] = "OB_VVD_CD";
		titleField[i++] = "CGO_TP_CD";
		titleField[i++] = "BKG_SPE";
		titleField[i++] = "USED";
		titleField[i++] = "LT";
		titleField[i++] = "I_EXIT";
		titleField[i++] = "LT_EXP";
		titleField[i++] = "SEAL_NO";
		titleField[i++] = "SEAL_NO2";
		titleField[i++] = "WEIGHT_KGS";
		titleField[i++] = "WEIGHT_LBS";
		titleField[i++] = "NO_PKG";
		titleField[i++] = "PKG_CD";
		titleField[i++] = "CMDT_NM";
		titleField[i++] = "C_LOC";
		titleField[i++] = "USA_LAST_CITY";
		titleField[i++] = "F";
		titleField[i++] = "O";
		titleField[i++] = "C";
		titleField[i++] = "IT_NO";
		titleField[i++] = "PICKUP_NO";
		titleField[i++] = "PU_YARD_CD";
		titleField[i++] = "AVAILABLE_DT";
		titleField[i++] = "LAST_FREE_DT";
		titleField[i++] = "SC_NO";
		titleField[i++] = "RFA_NO";
		titleField[i++] = "DOOR_SVC_TP";
		titleField[i++] = "PKUP_CNTR";
		titleField[i++] = "SHIPPER";
		titleField[i++] = "CONSIGNEE";
		titleField[i++] = "NOTIFY";
		titleField[i++] = "REF_BKG_NO";
		titleField[i++] = "REF_BL_NO";
		titleField[i++] = "ORG_GATE_OUT_DT";
		titleField[i++] = "DEST_GATE_IN_DT";
		titleField[i++] = "MTY_REF_ID";
		titleField[i++] = "TRSP_PURP_RSN";
		titleField[i++] = "INTER_RMK";
		titleField[i++] = "SPCL_INSTR_RMK";
		titleField[i++] = "WO_INSTR_RMK";
		titleField[i++] = "CHZ_BUNDLE_SEQ";
		titleField[i++] = "TRSP_SPL_SO_TP_CD";

		if (hidUsdropnpull.equalsIgnoreCase("Y")) {
			titleField[i++] = "FM_DT";
			titleField[i++] = "FM_YD";
			titleField[i++] = "FM_STS";
			titleField[i++] = "TO_DT";
			titleField[i++] = "TO_YD";
			titleField[i++] = "TO_STS";
			titleField[i++] = "MT_DT";
			titleField[i++] = "MT_YD";
			titleField[i++] = "WEB_MT_DT";
			titleField[i++] = "GRACE_END";
		}

		return titleField;
	}

	@Override
	public String[] getTitle(Event e) {
		EsdTrs0019Event event = (EsdTrs0019Event) e;
		String hidUsRail = event.getHidUsRail();
		String hidUsdropnpull = event.getHidUsDropNPull();
		int sizeofarray = 139;

		if (hidUsRail.equalsIgnoreCase("Y")) {
			sizeofarray = sizeofarray + 3;
		}
		if (hidUsdropnpull.equalsIgnoreCase("Y")) {
			sizeofarray = sizeofarray + 10;
		}
		String[] title = new String[sizeofarray];

		int j = 0;
		title[j++] = "Seq.";
		title[j++] = "EQ No.";
		title[j++] = "TP/SZ";
		title[j++] = "Org TP/SZ";
		title[j++] = "Cost Mode";
		title[j++] = "Trans Mode";
		title[j++] = "S/O TP";
		title[j++] = "Unplanned";
		title[j++] = "CB";
		title[j++] = "Frustrated";
		title[j++] = "S/O No.";
		title[j++] = "S/O CRE DT ";
		title[j++] = "S/O DEL";
		title[j++] = "S/O DEL DT ";
		title[j++] = "S/O UPD ID ";
		title[j++] = "W/O No.";
		title[j++] = "W/O Iss STS";
		title[j++] = "W/O Iss DT ";
		title[j++] = "W/O ISS TP ";
		title[j++] = "W/O ISS OFC";
		title[j++] = "W/O ISS ID ";
		title[j++] = "From";
		title[j++] = "Via";
		title[j++] = "To";
		title[j++] = "Door ";
		title[j++] = "Door Information";
		title[j++] = "Door Information";
		title[j++] = "Door Information";
		title[j++] = "Door Information";
		title[j++] = "Door Information";
		title[j++] = "Door Information";
		title[j++] = "Door Information";
		// title[j++] = "Web D/O";
		// title[j++] = "Web D/O";
		// title[j++] = "Web D/O";
		title[j++] = "W/O S/P";
		title[j++] = "W/O S/P";
		title[j++] = "W/O S/P";
		title[j++] = "Parent S/P";
		title[j++] = "Parent S/P";
		title[j++] = "W/O RCV DT";
		title[j++] = "Appt. Time";
		title[j++] = "Deliv. Time";
		title[j++] = "3rd Party";
		title[j++] = "Cost OFC";
		title[j++] = "Work Order Amount";
		title[j++] = "Work Order Amount";
		title[j++] = "Work Order Amount";
		title[j++] = "Work Order Amount";
		title[j++] = "Work Order Amount";
		title[j++] = "Work Order Amount";
		title[j++] = "Work Order Amount";
		// ----
		if (hidUsRail.equalsIgnoreCase("Y")) {
			title[j++] = "Work Order Amount";
			title[j++] = "Work Order Amount";
			title[j++] = "Work Order Amount";
		}
		title[j++] = "Exchange Rate";
		title[j++] = "Calculation Logic";
		title[j++] = "Invoice Amount";
		title[j++] = "Invoice Amount";
		title[j++] = "Invoice Amount";
		title[j++] = "Invoice Amount";
		title[j++] = "Invoice Amount";
		title[j++] = "Invoice S/P";
		title[j++] = "Invoice S/P";
		title[j++] = "Invoice No.";
		title[j++] = "INV STS";
		title[j++] = "INV CNFM DT";
		title[j++] = "CSR No.";
		// title[j++] = "INV I/F DT ";
		title[j++] = "INV OFC";
		title[j++] = "INV User ";
		title[j++] = "Estimated Time";
		title[j++] = "Estimated Time";
		title[j++] = "Estimated Time";
		title[j++] = "Estimated Time";
		title[j++] = "COP No.";
		title[j++] = "A/G SEQ";
		title[j++] = "A/G Code ";
		title[j++] = "BKG No.";
		title[j++] = "BL No. ";
		title[j++] = "BND";
		title[j++] = "Term ";
		title[j++] = "TRO Information";
		title[j++] = "TRO Information";
		title[j++] = "TRO Information";
		title[j++] = "TRO Information";
		title[j++] = "TRO Information";
		title[j++] = "TRO Information";
		title[j++] = "TRO Information";
		title[j++] = "TRO Information";
		title[j++] = "TRO Information";
		title[j++] = "BKG QTY";
		title[j++] = "POR";
		title[j++] = "POL";
		title[j++] = "POD";
		title[j++] = "DEL";
		title[j++] = "T.VVD";
		title[j++] = "Lane";
		title[j++] = "In VVD";
		title[j++] = "Out VVD";
		title[j++] = "CGO TP";
		title[j++] = "CNTR SPE";
		title[j++] = "Used";
		title[j++] = "L/T";
		title[j++] = "I.Exit";
		title[j++] = "L/T EXP";
		title[j++] = "Seal No.1";
		title[j++] = "Seal No.2";
		title[j++] = "Weight(KGS)";
		title[j++] = "Weight(LBS)";
		title[j++] = "No of PKG";
		title[j++] = "PKG CD";
		title[j++] = "Commodity DESC";
		title[j++] = "C.LOC";
		title[j++] = "USA Last City";
		title[j++] = "F";
		title[j++] = "O";
		title[j++] = "C";
		title[j++] = "IT No";
		title[j++] = "Pickup No.";
		title[j++] = "PU Yard";
		title[j++] = "Available DT";
		title[j++] = "Last Free DT";
		title[j++] = "S/C No.";
		title[j++] = "RFA No.";
		title[j++] = "Door SVC TP";
		title[j++] = "Pickup CNTR";
		title[j++] = "Shipper";
		title[j++] = "Consignee";
		title[j++] = "Notify ";
		title[j++] = "Ref.BKG No ";
		title[j++] = "Ref.BL No";
		title[j++] = "Outgate Date ";
		title[j++] = "Ingate Date";
		title[j++] = "MTY Reference No ";
		title[j++] = "Reason ";
		title[j++] = "Internal Remark";
		title[j++] = "Special Instruction";
		title[j++] = "W/O Instruction";
		title[j++] = "CHZ Bundle";
		title[j++] = "Supplement Kind";

		if (hidUsdropnpull.equalsIgnoreCase("Y")) {
			title[j++] = "From(ID)";
			title[j++] = "From(ID)";
			title[j++] = "From(ID)";
			title[j++] = "To";
			title[j++] = "To";
			title[j++] = "To";
			title[j++] = "MT Info.";
			title[j++] = "MT Info.";
			title[j++] = "Web Mty";
			title[j++] = "Grace End";
		}

		// title[j++] = "ETS";

		return title;
	}

	/**
	 * End process of TRS task scenario<br>
	 * Releasing the related implicit object when SOInquiry task is end.<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}