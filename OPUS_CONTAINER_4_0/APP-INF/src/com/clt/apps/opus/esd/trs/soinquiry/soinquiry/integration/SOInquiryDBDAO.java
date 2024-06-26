/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : SOInquiryDBDAO.java
 *@FileTitle : SO Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-11-10
 *@LastModifier : juhyun
 *@LastVersion : 1.0 
 * 2006-11-10 juhyun
 * 1.0 최초 생성
 * 2011.01.03 이윤정 [CHM-201007768-01] DMDT 관련 컬럼 추가
=========================================================*/
package com.clt.apps.opus.esd.trs.soinquiry.soinquiry.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.trs.common.util.CommonUtil;
import com.clt.apps.opus.esd.trs.soinquiry.soinquiry.basic.SOInquiryBCImpl;
import com.clt.apps.opus.esd.trs.soinquiry.soinquiry.event.EsdTrs0019Event;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author ytlee
 * @see SOInquiryBCImpl 참조
 * @since J2EE 1.4
 */
public class SOInquiryDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = -4250272428410449332L;

	/**
	 * SOInquiry의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param event
	 * @param soffice_cd
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchSOInquiry(EsdTrs0019Event event, String soffice_cd) throws DAOException {

		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		List<String> trunkVvd = new ArrayList<String>();
		List<String> copNumber = new ArrayList<String>();
		List<String> mtyRefNumber = new ArrayList<String>();
		List<String> eqNumber = new ArrayList<String>();
		List<String> bkgNumber = new ArrayList<String>();
		List<String> blNumber = new ArrayList<String>();
		List<String> inputOffice = new ArrayList<String>();
		List<String> woNumber = new ArrayList<String>();
		List<String> invoiceNumber = new ArrayList<String>();
		List<String> soNumber = new ArrayList<String>();
		List<String> wrkOfc = new ArrayList<String>();
		List<String> scRfaCd = new ArrayList<String>();
		List<String> zipCode = new ArrayList<String>();
		boolean month_flg = false;

		String opener = JSPUtil.getNull(event.getOpener()); // popup 을 통해 열수도 있음,.(chreport)
		String r_wrkofc = JSPUtil.getNull(event.getHidWrkOfc()); // popup 을 통해 열수도 있음,.(chreport)
		// String r_trosts = JSPUtil.getNull(event.getHidTroSts()); // popup 을 통해 열수도 있음,.(chreport)
		String r_tpsz = JSPUtil.getNull(event.getHidTpsz()); // popup 을 통해 열수도 있음,.(chreport)
		String r_trunk_vvd = JSPUtil.getNull(event.getTrunkVvd()); // trunk_vvd
		String r_bkgnumber = JSPUtil.getNull(event.getBkgNumber()); // bkgnumber
		String r_blnumber = JSPUtil.getNull(event.getBlNumber()); // blnumber
		String r_sonumber = JSPUtil.getNull(event.getSoNumber()); // S/O INPUT BOX
		String r_wonumber = JSPUtil.getNull(event.getWoNumber()); // W/O No. INPUT BOX
		String r_copnumber = JSPUtil.getNull(event.getCopNumber()); // W/O No. INPUT BOX
		String r_invoicenumber = JSPUtil.getNull(event.getInvoiceNumber()); // Invoice No.
		String r_eqnumber = JSPUtil.getNull(event.getEqNumber()); // EQ No.
		String r_zip_code = JSPUtil.getNull(event.getZipCode()); // Zip Code.
		String r_radio_eq = JSPUtil.getNull(event.getHidRadioEq()); // EQ No.
		String r_mtyrefnumber = JSPUtil.getNull(event.getMtyRefNumber()); // MTY REF No.
		String grid_flg = JSPUtil.getNull(event.getHidGridFlg()); // MTY REF No.
		String r_unplanned = JSPUtil.getNull(event.getHidUnplanned()); // EQ No.
		String r_period = JSPUtil.getNull(event.getHidPeriod()); // S/O Creation W/O Issue Invoice Confirm
		String r_from_date = JSPUtil.getNull(event.getHidFromDate()); // hid_from_date
		String r_to_date = JSPUtil.getNull(event.getHidToDate()); // hid_to_date
		String r_radio_office = JSPUtil.getNull(event.getHidRadioOffice()); // hid_radio_office
		String r_input_office = JSPUtil.getNull(event.getInputOffice()); // input_office
		String r_somode = JSPUtil.getNull(event.getHidSoMode()); // S/O combo
		String r_womode = JSPUtil.getNull(event.getHidWoMode()); // WO combo
		String r_invoicemode = JSPUtil.getNull(event.getHidInvoiceMode()); // invoice combo
		String r_cargomode = JSPUtil.getNull(event.getHidCargoMode()); // cargo combo
		String r_boundmode = JSPUtil.getNull(event.getHidBoundMode()); // bound combo
		String r_radio_user = JSPUtil.getNull(event.getHidRadioUser()); // radio_user
		String r_user_id = JSPUtil.getNull(event.getUserId()); // user_id
		String r_costmode = JSPUtil.getNull(event.getHidCostMode()); // costmode
		String r_transmode = JSPUtil.getNull(event.getHidTransMode()); // transmode
		String r_sotype = JSPUtil.getNull(event.getHidSoType()); // sotype
		String r_provider = JSPUtil.getNull(event.getHidProvider()); // provider
		String r_provider_type = JSPUtil.getNull(event.getHidProviderType()); // provider type
		String r_amount = JSPUtil.getNull(event.getHidAmount()); // amount combo
		String r_radio_number = JSPUtil.getNull(event.getHidRadioNumber()); // S/C No. RFA No. RADIO
		String r_sc_rfa_cd = JSPUtil.getNull(event.getScRfaCd()); // S/C No. RFA No. INPUT BOX
		String r_from_node = JSPUtil.getNull(event.getHidFromNode()); // from_node
		String r_via_node = JSPUtil.getNull(event.getHidViaNode()); // via_node
		String r_to_node = JSPUtil.getNull(event.getHidToNode()); // to_node
		String r_door_node = JSPUtil.getNull(event.getHidDoorNode()); // door_node
		String invar_term = JSPUtil.getNull(event.getInvarTerm()); // door_node
		String invar_onlycy = JSPUtil.getNull(event.getInvarOnlyCy()); // door_node
		String invar_trosts = JSPUtil.getNull(event.getInvarTroSts()); // door_node
		String invar_usrail = JSPUtil.getNull(event.getHidUsRail()); // door_node
		String invar_usdropnpull = JSPUtil.getNull(event.getHidUsDropNPull()); // dmdt
		String cntr_slt_no = JSPUtil.getNull(event.getCntrSltNo()); // Slot Reference No.

		// multi from node setting 2015.04.13
		String fmnode = event.getSearchFmNode();
		List<String> arr_fmnode = new ArrayList<String>();
		arr_fmnode = CommonUtil.seperationParameter(fmnode, ",");
		param.put("arr_fmnode", arr_fmnode);

		// multi to node setting 2015.04.13
		String tonode = event.getSearchToNode();
		List<String> arr_tonode = new ArrayList<String>();
		arr_tonode = CommonUtil.seperationParameter(tonode, ",");
		param.put("arr_tonode", arr_tonode);
		param.put("portio", event.getPortIo().toString());
		param.put("portcd", event.getPortCd().toString());
		param.put("opener", opener);
		param.put("soffice_cd", soffice_cd);
		if (r_from_date.length() == 6) {
			month_flg = true;
		}
		param.put("invar_usrail", invar_usrail);
		param.put("invar_usdropnpull", invar_usdropnpull);

		if (!r_trunk_vvd.equals("")) {
			String arrTrunkVvd[] = event.getTrunkVvd().split(",");
			for (int i = 0; i < arrTrunkVvd.length; i++) {
				trunkVvd.add(arrTrunkVvd[i]);
			}
		}
		param.put("r_trunk_vvd", trunkVvd);

		if (!r_bkgnumber.equals("")) {
			String arrBkgNumber[] = event.getBkgNumber().split(",");
			for (int i = 0; i < arrBkgNumber.length; i++) {
				bkgNumber.add(arrBkgNumber[i]);
			}
		}
		param.put("r_bkgnumber", bkgNumber);

		if (!r_blnumber.equals("")) {
			String arrBlNumber[] = event.getBlNumber().split(",");
			for (int i = 0; i < arrBlNumber.length; i++) {
				blNumber.add(arrBlNumber[i]);
			}
		}
		param.put("r_blnumber", blNumber);

		if (!r_copnumber.equals("")) {
			String arrCopNumber[] = event.getCopNumber().split(",");
			for (int i = 0; i < arrCopNumber.length; i++) {
				copNumber.add(arrCopNumber[i]);
			}
		}
		param.put("r_copnumber", copNumber);

		if (!r_eqnumber.equals("")) {
			String arrEqNumber[] = event.getEqNumber().split(",");
			for (int i = 0; i < arrEqNumber.length; i++) {
				eqNumber.add(arrEqNumber[i]);
			}
		}
		param.put("r_eqnumber", eqNumber); // EQ No
		param.put("r_radio_eq", r_radio_eq); // EQ No. RADIO

		if (!r_mtyrefnumber.equals("")) {
			String arrMtyRefNumber[] = event.getMtyRefNumber().split(",");
			for (int i = 0; i < arrMtyRefNumber.length; i++) {
				mtyRefNumber.add(arrMtyRefNumber[i]);
			}
		}
		param.put("r_mtyrefnumber", mtyRefNumber);

		// Period
		param.put("r_period", r_period); // period
		param.put("r_from_date", r_from_date); // From date
		param.put("r_to_date", r_to_date); // To date
		param.put("month_flg", month_flg); // month flg

		// office
		param.put("r_radio_office", r_radio_office); // Office Radio button
		if (!r_input_office.equals("")) {
			String arrInputOffice[] = event.getInputOffice().split(",");
			for (int i = 0; i < arrInputOffice.length; i++) {
				inputOffice.add(arrInputOffice[i]);
			}
		}

		param.put("r_input_office", inputOffice); // Input office
		param.put("r_somode", r_somode); // S/O combox
		param.put("r_womode", r_womode); // W/O combox
		param.put("r_invoicemode", r_invoicemode); // Invoice combox
		param.put("r_cargomode", r_cargomode); // cargo combox
		param.put("r_boundmode", r_boundmode); // bound combox
		param.put("r_radio_user", r_radio_user); // User Radio box
		param.put("r_user_id", r_user_id); // User_id
		param.put("r_costmode", r_costmode); // Cost mode
		param.put("r_transmode", r_transmode); // Trans mode
		param.put("r_sotype", r_sotype); // SO type code
		param.put("r_provider", r_provider); // Service provider
		param.put("r_provider_type", r_provider_type); // Service provider Type
		param.put("r_from_node", r_from_node); // From node
		param.put("r_via_node", r_via_node); // Via node
		param.put("r_to_node", r_to_node); // To node
		param.put("r_door_node", r_door_node); // Door node

		if (!r_wonumber.equals("")) {
			String arrWoNumber[] = event.getWoNumber().split(",");
			for (int i = 0; i < arrWoNumber.length; i++) {
				woNumber.add(arrWoNumber[i]);
			}
		}
		param.put("r_wonumber", woNumber); // WorkOrder Number

		if (!r_invoicenumber.equals("")) {
			String arrInvoiceNumber[] = event.getInvoiceNumber().split(",");
			for (int i = 0; i < arrInvoiceNumber.length; i++) {
				arrInvoiceNumber[i] = arrInvoiceNumber[i].replaceAll("\\'", "\\'\\'");
				invoiceNumber.add(arrInvoiceNumber[i]);
			}
		}
		param.put("r_invoicenumber", invoiceNumber); // Invoice Number

		if (!r_sonumber.equals("")) {
			String arrSoNumber[] = event.getSoNumber().split(",");
			for (int i = 0; i < arrSoNumber.length; i++) {
				soNumber.add(arrSoNumber[i]);
			}
		}
		param.put("r_sonumber", soNumber);
		param.put("r_unplanned", r_unplanned);
		if (!r_zip_code.equals("")) {
			String arrZipCode[] = event.getZipCode().split(",");
			for (int i = 0; i < arrZipCode.length; i++) {
				zipCode.add(arrZipCode[i]);
			}
		}
		param.put("r_zip_code", zipCode);
		param.put("invar_onlycy", invar_onlycy);
		if (!r_wrkofc.equals("")) {
			String arrWrkOfc[] = event.getHidWrkOfc().split(",");
			for (int i = 0; i < arrWrkOfc.length; i++) {
				wrkOfc.add(arrWrkOfc[i]);
			}
		}
		param.put("r_wrkofc", wrkOfc);
		param.put("invar_term", invar_term);
		param.put("invar_trosts", invar_trosts);
		param.put("r_tpsz", r_tpsz);
		param.put("grid_flg", grid_flg);
		param.put("r_radio_number", r_radio_number);
		if (!r_sc_rfa_cd.equals("")) {
			String arrScRfaCd[] = event.getScRfaCd().split(",");
			for (int i = 0; i < arrScRfaCd.length; i++) {
				scRfaCd.add(arrScRfaCd[i]);
			}
		}
		param.put("r_sc_rfa_cd", scRfaCd);
		param.put("r_amount", r_amount);
		param.put("cntr_slt_no", CommonUtil.seperationParameter(cntr_slt_no, ","));
		try {
			dRs = new SQLExecuter().executeQuery(new SOInquiryDBDAOSearchSOInquiryRSQL(), param, param);
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
	 * SOInquiry의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet search_office(EsdTrs0019Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("office_cd", event.getOfficeCd());
		try {
			return new SQLExecuter().executeQuery(new SOInquiryDBDAOSearchOfficeRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}
}
