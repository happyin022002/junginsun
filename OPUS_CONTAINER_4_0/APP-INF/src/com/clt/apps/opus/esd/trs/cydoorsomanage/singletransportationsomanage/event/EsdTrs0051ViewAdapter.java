/*=========================================================
 *Copyright(c) 2008 CyberLogitec
 *@FileName : EsdTrs0051ViewAdapter.java
 *@FileTitle : EsdTrs0051ViewAdapter Generation Class
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011-01-06
 *@LastModifier : 민정호
 *@LastVersion : 1.1
 * 2008-11-24 Lee SeungYol
 * 1.0 최초 생성
 *----------------------------------------------------------
 * History
 * 2011.01.06 민정호 1.1 [CHM_201108116] Single Transportaion S/O 관리(USA, EUR)
=========================================================*/
package com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.event;

import java.sql.SQLException;
import java.util.List;

import com.clt.apps.opus.esd.trs.common.util.TrsDefaultViewAdapter;
import com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SoProcVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Poong-Yeon Cho
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */

public class EsdTrs0051ViewAdapter extends TrsDefaultViewAdapter {
	private final String IMG_RED = "/opuscntr/img/btng_icon_r.gif";
	private final String IMG_BLANK = "/opuscntr/img/blank.gif";

	/**
	 * makeDataTag
	 * 
	 * @param vos
	 * @param prefix
	 * @param event
	 * @return
	 */
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix, Event event) {
		int totCnt = 0;
		String strOfccd = "";
		StringBuilder sb = new StringBuilder();
		FormCommand formcommand = event.getFormCommand();
		try {
			if (formcommand.isCommand(FormCommand.SEARCH19)) {
				SoProcVO listVO = new SoProcVO();
				sb.append("<DATA TOTAL='" + totCnt + "'>\n");

				for (int m = 0; m < vos.size(); m++) {
					AbstractValueObject vo = (AbstractValueObject) vos.get(m);
					ObjectCloner.build(vo, listVO);
					sb.append("<TR>");
					sb.append("\n<TD>" + JSPUtil.getNull(listVO.getRtnValue()) + "</TD>");
					sb.append("\n<TD>" + JSPUtil.getNull(listVO.getActCustCntCd()) + "</TD>");
					sb.append("\n<TD>" + JSPUtil.getNull(listVO.getActCustSeq()) + "</TD>");
					sb.append("\n<TD>" + JSPUtil.getNull(listVO.getActCustAddrSeq()) + "</TD>");
					sb.append("\n<TD>" + JSPUtil.getNull(listVO.getActCustFctryPstCd()) + "</TD>");
					sb.append("\n<TD>" + JSPUtil.getNull(listVO.getActCustFctryNm()) + "</TD>");
					sb.append("\n<TD>" + JSPUtil.getNull(listVO.getActCustFctryAddr()) + "</TD>");
					sb.append("\n<TD>" + JSPUtil.getNull(listVO.getActCustFctryPhnNo()) + "</TD>");
					sb.append("\n<TD>" + JSPUtil.getNull(listVO.getActCustFctryFaxNo()) + "</TD>");
					sb.append("\n<TD>" + JSPUtil.getNull(listVO.getActCustFctryPicNo()) + "</TD>");
					sb.append("\n<TD>" + JSPUtil.getNull(listVO.getActCustEml()) + "</TD>");
					sb.append("\n<TD>" + JSPUtil.getNull(listVO.getActCustRmk()) + "</TD>");
					sb.append("</TR> ");
				}
				sb.append("</DATA>\n");
			} else {
				SingleTransportationVO listVO = new SingleTransportationVO();
				event.getSignOnUserAccount().getOfc_cd();
				totCnt = vos.size();
				if (event.getSignOnUserAccount().getOfc_cd().length() > 2) {
					strOfccd = event.getSignOnUserAccount().getOfc_cd().substring(0, 3);
				}
				event.getSignOnUserAccount().getOfc_cd();
				totCnt = vos.size();
				sb.append("<DATA TOTAL='" + totCnt + "'>\n");
				for (int m = 0; m < vos.size(); m++) {
					AbstractValueObject vo = (AbstractValueObject) vos.get(m);
					ObjectCloner.build(vo, listVO);
					listVO.getTrspSoSeq();
					sb.append("<TR>");
					sb.append("\n<TD>" + strOfccd + "</TD>");
					sb.append("\n<TD>" + listVO.getTrspSoSeq() + "</TD>");
					sb.append("</TR> ");
				}
				sb.append("</DATA>\n");
			}
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new RuntimeException(ex.getMessage());
		}

		return sb.toString();
	}

	/**
	 * makeDataTag
	 * 
	 * @param rs
	 * @param prefix
	 * @param event
	 * @return
	 */
	protected String makeDataTag(DBRowSet rs, String prefix, Event event) {
		FormCommand formcommand = event.getFormCommand();
		StringBuilder sb = new StringBuilder();
		if (rs.isPivot()) {
			sb.append(makePivotDataTag(rs));
			return sb.toString();
		}
		String realColNms[] = getColHeader(rs);
		try {
			String changedColNms[] = getChangedColNms(realColNms, prefix);
			if (formcommand.isCommand(FormCommand.SEARCH10)) {
				sb.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' TOTAL='").append(getRowSetCnt(rs)).append("'>\n").toString());
				int colCount = realColNms.length;
				String colName = "";
				String sFcolor = "";

				String sTpsz = "";
				String sSpcl = "";
				float fLbsw = 0;
				String sFmnd = "";
				String eq_no = "";
				String sbkg_sts_cd = "";
				String sTrsp_cost_dtl_mod_cd = "";
				String sTrsp_so_cmb_seq = "";

				boolean eq_seqp = false;
				boolean bTrsp_mod = false;
				boolean bCmb_seq = false;

				while (rs.next()) {
					sSpcl = JSPUtil.getNull(rs.getString("SPCL_CGO_CNTR_TP_CD"));
					sTpsz = JSPUtil.getNull(rs.getString("EQ_TPSZ_CD"));
					fLbsw = rs.getFloat("CNTR_LBS_WGT");
					sFmnd = JSPUtil.getNull(rs.getString("fm_nod_cd"));
					eq_no = JSPUtil.getNull(rs.getString("EQ_NO"));
					sbkg_sts_cd = JSPUtil.getNull(rs.getString("BKG_STS_CD"));
					sTrsp_cost_dtl_mod_cd = JSPUtil.getNull(rs.getString("TRSP_COST_DTL_MOD_CD"));
					sTrsp_so_cmb_seq = JSPUtil.getNull(rs.getString("TRSP_SO_CMB_SEQ"));

					if (sFmnd.length() > 2) {
						sFmnd = sFmnd.substring(0, 2);
					}
					sFcolor = "";
					if (sFmnd.equals("US")) {
						if ((sTpsz.equals("D2") && (Float.compare(fLbsw, 38000.0000F) >= 0)) || (sTpsz.equals("D4") && (Float.compare(fLbsw, 44000.0000F) >= 0)) || (sTpsz.equals("D5") && (Float.compare(fLbsw, 44000.0000F) >= 0)) || (sTpsz.equals("D7") && (Float.compare(fLbsw, 44000.0000F) >= 0))) {
							sFcolor = " COLOR='BLUE'";
						}
						if (sSpcl.equals("DG") || sSpcl.equals("RF") || sSpcl.equals("AK")) {
							sFcolor = " COLOR='RED'";
						}
					}
					if ("".equals(eq_no) && "X".equals(sbkg_sts_cd)) {
						eq_seqp = true;
					} else {
						eq_seqp = false;
					}

					if (sTrsp_so_cmb_seq.length() > 0) {
						bCmb_seq = true;
					} else {
						bCmb_seq = false;
					}

					if (sTrsp_cost_dtl_mod_cd.equals("DOOR")) {
						bTrsp_mod = false;
					} else {
						bTrsp_mod = true;
					}

					if (bCmb_seq) {
						bTrsp_mod = true;
					}

					sb.append((new StringBuilder()).append("\n<TR").append(sFcolor)).append(">");
					for (int j = 1; j < colCount + 1; j++) {
						colName = rs.getMetaData().getColumnName(j);
						if (colName.equals("FM_NOD_CD") || colName.equals("FM_NOD_CD2")) {
							sb.append((new StringBuilder()).append("<TD").append(" EDIT='").append("FALSE").append("'").append(">").append(getNull(rs.getObject("FM_NOD_CD"))).append("</TD>").toString());
						} else if (colName.equals("VIA_NOD_CD") || colName.equals("VIA_NOD_CD2")) {
							sb.append((new StringBuilder()).append("<TD").append(" EDIT='").append("FALSE").append("'").append(">").append(getNull(rs.getObject("VIA_NOD_CD"))).append("</TD>").toString());
						} else if (colName.equals("TO_NOD_CD") || colName.equals("TO_NOD_CD2")) {
							sb.append((new StringBuilder()).append("<TD").append(" EDIT='").append("FALSE").append("'").append(">").append(getNull(rs.getObject("TO_NOD_CD"))).append("</TD>").toString());
						} else if (colName.equals("DOR_NOD_CD") || colName.equals("DOR_NOD_CD2")) {
							sb.append((new StringBuilder()).append("<TD").append(" EDIT='").append("FALSE").append("'").append(">").append(getNull(rs.getObject("DOR_NOD_CD"))).append("</TD>").toString());
						} else if (colName.equals("FM_NOD_YARD")) {
							sb.append((new StringBuilder()).append("<TD").append(" EDIT='").append("FALSE").append("'").append(" COMBO-TEXT='").append("|").append(JSPUtil.getNull(rs.getObject(j))).append("'").append(" COMBO-CODE='").append("|").append(JSPUtil.getNull(rs.getObject(j))).append("'")
									.append(">").append(JSPUtil.getNull(rs.getObject(j))).append("</TD>").toString());
						} else if (colName.equals("FM_NOD_YARD2")) {
							sb.append((new StringBuilder()).append("<TD>").append(JSPUtil.getNull(rs.getObject("FM_NOD_YARD"))).append("</TD>").toString());
						} else if (colName.equals("VIA_NOD_YARD")) {
							sb.append((new StringBuilder()).append("<TD").append(" EDIT='").append("FALSE").append("'").append(" COMBO-TEXT='").append("|").append(JSPUtil.getNull(rs.getObject(j))).append("'").append(" COMBO-CODE='").append("|").append(JSPUtil.getNull(rs.getObject(j))).append("'")
									.append(">").append(JSPUtil.getNull(rs.getObject(j))).append("</TD>").toString());
						} else if (colName.equals("VIA_NOD_YARD2")) {
							sb.append((new StringBuilder()).append("<TD>").append(JSPUtil.getNull(rs.getObject("VIA_NOD_YARD"))).append("</TD>").toString());
						} else if (colName.equals("TO_NOD_YARD")) {
							sb.append((new StringBuilder()).append("<TD").append(" EDIT='").append("FALSE").append("'").append(" COMBO-TEXT='").append("|").append(JSPUtil.getNull(rs.getObject(j))).append("'").append(" COMBO-CODE='").append("|").append(JSPUtil.getNull(rs.getObject(j))).append("'")
									.append(">").append(JSPUtil.getNull(rs.getObject(j))).append("</TD>").toString());
						} else if (colName.equals("TO_NOD_YARD2")) {
							sb.append((new StringBuilder()).append("<TD>").append(JSPUtil.getNull(rs.getObject("TO_NOD_YARD"))).append("</TD>").toString());
						} else if (colName.equals("DOR_NOD_YARD")) {
							sb.append((new StringBuilder()).append("<TD").append(" EDIT='").append("FALSE").append("'").append(" COMBO-TEXT='").append("|").append(JSPUtil.getNull(rs.getObject(j))).append("'").append(" COMBO-CODE='").append("|").append(JSPUtil.getNull(rs.getObject(j))).append("'")
									.append(">").append(JSPUtil.getNull(rs.getObject(j))).append("</TD>").toString());
						} else if (colName.equals("DOR_SVC_TP_CD")) {
							sb.append((new StringBuilder()).append("<TD").append(" EDIT='").append("FALSE").append("'").append(" COMBO-TEXT='UNDECIDED|LIVE LOAD|LIVE UNLOAD|STREET TURN|DROP AND PICK'").append(" COMBO-CODE='UD|LL|LU|ST|DP'").append(">").append(JSPUtil.getNull(rs.getObject(j)))
									.append("</TD>").toString());
						} else if (colName.equals("EQ_NO")) {
							sb.append((new StringBuilder()).append("<TD").append(" EDIT='").append(eq_seqp ? "TRUE" : "FALSE").append("'").append(">").append(JSPUtil.getNull(rs.getObject(j))).append("</TD>").toString());
						} else if (colName.equals("TRSP_CRR_MOD_CD2")) {
							sb.append((new StringBuilder()).append("<TD").append(">").append("<![CDATA[").append(JSPUtil.getNull(rs.getObject("TRSP_CRR_MOD_CD"))).append("]]></TD>").toString());
						} else if (colName.equals("SEALNO")) {
							sb.append((new StringBuilder()).append("<TD").append(">").append("<![CDATA[").append(getNull(rs.getObject(j))).append("]]>").append("</TD>").toString());
						} else if (colName.equals("SHPR_CUST_NM") || colName.equals("CNEE_CUST_NM") || colName.equals("NTFY_CUST_NM") || colName.equals("SCREMARK") || colName.equals("SPCL_INSTR_RMK") || colName.equals("CMDT_NAME") || colName.equals("INTER_RMK") || colName.equals("TRNS_RQST_RSN")
								|| colName.equals("DOR_PST_CD")) {
							sb.append((new StringBuilder()).append("<TD").append(" EDIT='").append("FALSE").append("'").append("><![CDATA[").append(getNull(rs.getObject(j))).append("]]></TD>").toString());
						} else if (colName.equalsIgnoreCase("cng_ind_flg_img")) {
							if ("Y".equals(rs.getObject("cng_ind_flg_img"))) {
								sb.append("<TD>").append("<![CDATA[").append(new StringBuilder(IMG_RED)).append("]]></TD>");
							} else {
								sb.append("<TD>").append("<![CDATA[").append(new StringBuilder(IMG_BLANK)).append("]]></TD>");
							}
						} else if (colName.equals("DOR_DE_ADDR") || colName.equals("FCTRY_NM") || colName.equals("CNTC_PSON_PHN_NO") || colName.equals("CNTC_PSON_FAX_NO") || colName.equals("CNTC_PSON_NM")) {
							sb.append((new StringBuilder()).append("<TD").append(" EDIT='").append(bTrsp_mod ? "FALSE" : "").append("'").append("><![CDATA[").append(JSPUtil.getNull(rs.getObject(j))).append("]]></TD>").toString());
						} else {
							sb.append((new StringBuilder()).append("<TD").append(" EDIT='").append("FALSE").append("'").append(">").append("<![CDATA[").append(getNull(rs.getObject(j))).append("]]>").append("</TD>").toString());
						}
					}
					sb.append("</TR>");
				}

				sb.append("\n</DATA>\n");
				return sb.toString();
			} else if (formcommand.isCommand(FormCommand.SEARCHLIST)) {
				sb.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' TOTAL='").append(getRowSetCnt(rs)).append("'>\n").toString());

				int colCount = realColNms.length;
				String colName = "";
				String sFcolor = "";

				String sTrsp_crr_mod_cd = "";
				String sTrsp_cost_dtl_mod_cd = "";
				String sTpsz = "";
				String sSpcl = "";
				float fLbsw = 0;
				String sFmnd = "";
				String sTrsp_so_cmb_seq = "";
				String eq_no = "";
				String sbkg_sts_cd = "";
				String trspCostDtlModCd = "";

				boolean bCmb_seq = false;
				boolean bCrr_mod = false;
				boolean bTrsp_mod = false;
				boolean eq_seqp = false;

				while (rs.next()) {
					sTrsp_crr_mod_cd = JSPUtil.getNull(rs.getString("TRSP_CRR_MOD_CD"));
					sTrsp_cost_dtl_mod_cd = JSPUtil.getNull(rs.getString("TRSP_COST_DTL_MOD_CD"));
					sSpcl = JSPUtil.getNull(rs.getString("SPCL_CGO_CNTR_TP_CD"));
					sTpsz = JSPUtil.getNull(rs.getString("EQ_TPSZ_CD"));
					fLbsw = rs.getFloat("CNTR_LBS_WGT");
					sFmnd = JSPUtil.getNull(rs.getString("fm_nod_cd"));
					sTrsp_so_cmb_seq = JSPUtil.getNull(rs.getString("TRSP_SO_CMB_SEQ"));
					eq_no = JSPUtil.getNull(rs.getString("EQ_NO"));
					sbkg_sts_cd = JSPUtil.getNull(rs.getString("BKG_STS_CD"));
					trspCostDtlModCd = JSPUtil.getNull(rs.getString("trsp_cost_dtl_mod_cd"));
					if (sFmnd.length() > 2) {
						sFmnd = sFmnd.substring(0, 2);
					}
					sFcolor = "";
					if (sFmnd.equals("US")) {
						if ((sTpsz.equals("D2") && (Float.compare(fLbsw, 38000.0000F) >= 0)) || (sTpsz.equals("D4") && (Float.compare(fLbsw, 44000.0000F) >= 0)) || (sTpsz.equals("D5") && (Float.compare(fLbsw, 44000.0000F) >= 0)) || (sTpsz.equals("D7") && (Float.compare(fLbsw, 44000.0000F) >= 0))) {
							sFcolor = " COLOR='BLUE'";
						}
						if (sSpcl.equals("DG") || sSpcl.equals("RF") || sSpcl.equals("AK")) { // 2009.03.11 추가 CNTR의 special 정보중 DG/RF/AK 는 전체 row data를 빨간색으로 표시
							sFcolor = " COLOR='RED'";
						}
					}
					eq_seqp = false;
					// Combined로 묶인 경우는 수정이 불가능 해야 한다.
					if (sTrsp_so_cmb_seq.length() > 0) {

						bCmb_seq = true;
					} else {
						bCmb_seq = false;
					}

					// Transportation Mode가 Direct일 경우는 수정이 불가능해야 한다.
					if (sTrsp_crr_mod_cd.indexOf("D") >= 0) {
						bCrr_mod = true;
					} else {
						bCrr_mod = false;
					}

					if (sTrsp_cost_dtl_mod_cd.equals("DOOR")) {
						bTrsp_mod = false;
					} else {
						bTrsp_mod = true;
					}

					if (bCmb_seq) {
						bCrr_mod = true;
						bTrsp_mod = true;
					}
					if (eq_no.equals("") && sbkg_sts_cd.equals("X")) {
						eq_seqp = true;
					} else {
						eq_seqp = false;
					}
					sb.append((new StringBuilder()).append("\n<TR").append(sTrsp_crr_mod_cd.equals("WD") ? " BGCOLOR='238,255,226'" : "").append(sFcolor)).append(">");
					for (int j = 1; j < colCount + 1; j++) {
						colName = rs.getMetaData().getColumnName(j);
						if (colName.equals("FM_NOD_CD") || colName.equals("FM_NOD_CD2")) {
							sb.append((new StringBuilder()).append("<TD").append(" EDIT='").append(bCmb_seq ? "FALSE" : "").append("'").append(">").append(getNull(rs.getObject("FM_NOD_CD"))).append("</TD>").toString());
						} else if (colName.equals("VIA_NOD_CD") || colName.equals("VIA_NOD_CD2")) {
							sb.append((new StringBuilder()).append("<TD").append(" EDIT='").append(bCrr_mod ? "FALSE" : "").append("'").append(">").append(getNull(rs.getObject("VIA_NOD_CD"))).append("</TD>").toString());
						} else if (colName.equals("TO_NOD_CD") || colName.equals("TO_NOD_CD2")) {
							sb.append((new StringBuilder()).append("<TD").append(" EDIT='").append(bCmb_seq ? "FALSE" : "").append("'").append(">").append(getNull(rs.getObject("TO_NOD_CD"))).append("</TD>").toString());
						} else if (colName.equals("DOR_NOD_CD") || colName.equals("DOR_NOD_CD2")) {
							sb.append((new StringBuilder()).append("<TD").append(" EDIT='").append(bTrsp_mod ? "FALSE" : "").append("'").append(">").append(getNull(rs.getObject("DOR_NOD_CD"))).append("</TD>").toString());
						} else if (colName.equals("FM_NOD_YARD")) {
							sb.append((new StringBuilder()).append("<TD").append(" EDIT='").append(bCmb_seq ? "FALSE" : "").append("'").append(" COMBO-TEXT='").append("|").append(JSPUtil.getNull(rs.getObject(j))).append("'").append(" COMBO-CODE='").append("|")
									.append(JSPUtil.getNull(rs.getObject(j))).append("'").append(">").append(JSPUtil.getNull(rs.getObject(j))).append("</TD>").toString());
						} else if (colName.equals("FM_NOD_YARD2")) {
							sb.append((new StringBuilder()).append("<TD>").append(JSPUtil.getNull(rs.getObject("FM_NOD_YARD"))).append("</TD>").toString());
						} else if (colName.equals("VIA_NOD_YARD")) {
							sb.append((new StringBuilder()).append("<TD").append(" EDIT='").append(bCrr_mod ? "FALSE" : "").append("'").append(" COMBO-TEXT='").append("|").append(JSPUtil.getNull(rs.getObject(j))).append("'").append(" COMBO-CODE='").append("|")
									.append(JSPUtil.getNull(rs.getObject(j))).append("'").append(">").append(JSPUtil.getNull(rs.getObject(j))).append("</TD>").toString());
						} else if (colName.equals("VIA_NOD_YARD2")) {
							sb.append((new StringBuilder()).append("<TD>").append(JSPUtil.getNull(rs.getObject("VIA_NOD_YARD"))).append("</TD>").toString());
						} else if (colName.equals("TO_NOD_YARD")) {
							sb.append((new StringBuilder()).append("<TD").append(" EDIT='").append(bCmb_seq ? "FALSE" : "").append("'").append(" COMBO-TEXT='").append("|").append(JSPUtil.getNull(rs.getObject(j))).append("'").append(" COMBO-CODE='").append("|")
									.append(JSPUtil.getNull(rs.getObject(j))).append("'").append(">").append(JSPUtil.getNull(rs.getObject(j))).append("</TD>").toString());
						} else if (colName.equals("TO_NOD_YARD2")) {
							sb.append((new StringBuilder()).append("<TD>").append(JSPUtil.getNull(rs.getObject("TO_NOD_YARD"))).append("</TD>").toString());
						} else if (colName.equals("DOR_NOD_YARD")) {
							sb.append((new StringBuilder()).append("<TD").append(" EDIT='").append(bTrsp_mod ? "FALSE" : "").append("'").append(" COMBO-TEXT='").append("|").append(JSPUtil.getNull(rs.getObject(j))).append("'").append(" COMBO-CODE='").append("|")
									.append(JSPUtil.getNull(rs.getObject(j))).append("'").append(">").append(JSPUtil.getNull(rs.getObject(j))).append("</TD>").toString());
						} else if (colName.equals("DOR_NOD_YARD2")) {
							sb.append((new StringBuilder()).append("<TD").append(">").append(JSPUtil.getNull(rs.getObject("DOR_NOD_YARD"))).append("</TD>").toString());
						} else if (colName.equals("SHPR_CUST_NM") || colName.equals("CNEE_CUST_NM") || colName.equals("NTFY_CUST_NM") || colName.equals("SCREMARK") || colName.equals("SPCL_INSTR_RMK") || colName.equals("INTER_RMK") || colName.equals("TRNS_RQST_RSN")) { // 20100106 추가 : TRNS_RQST_RSN
							sb.append((new StringBuilder()).append("<TD").append("><![CDATA[").append(getNull(rs.getObject(j))).append("]]></TD>").toString());
						} else if (colName.equals("CMDT_NAME")) {
							sb.append((new StringBuilder()).append("<TD").append("><![CDATA[").append(JSPUtil.getNull(rs.getObject(j))).append("]]></TD>").toString());
						} else if (colName.equals("DOR_SVC_TP_CD")) {
							sb.append((new StringBuilder()).append("<TD").append(" EDIT='").append(bTrsp_mod ? "FALSE" : "").append("'").append(" COMBO-TEXT='UNDECIDED|LIVE LOAD|LIVE UNLOAD|STREET TURN|DROP AND PICK'").append(" COMBO-CODE='UD|LL|LU|ST|DP'").append(">")
									.append(JSPUtil.getNull(rs.getObject(j))).append("</TD>").toString());
						} else if (colName.equals("DOR_DE_ADDR") || colName.equals("FCTRY_NM") || colName.equals("CNTC_PSON_PHN_NO") || colName.equals("CNTC_PSON_FAX_NO") || colName.equals("CNTC_PSON_NM") || colName.equals("DOR_PST_CD")) {
							sb.append((new StringBuilder()).append("<TD").append(" EDIT='").append(bTrsp_mod ? "FALSE" : "").append("'").append("><![CDATA[").append(JSPUtil.getNull(rs.getObject(j))).append("]]></TD>").toString());
						} else if (colName.equals("LST_LOC_CD")) {
							sb.append((new StringBuilder()).append("<TD").append(" COMBO-TEXT='").append("|").append(JSPUtil.getNull(rs.getObject(j))).append("'").append(" COMBO-CODE='").append("|").append(JSPUtil.getNull(rs.getObject(j))).append("'").append(">")
									.append(JSPUtil.getNull(rs.getObject(j))).append("</TD>").toString());
						} else if (colName.equals("EQ_NO")) {
							sb.append((new StringBuilder()).append("<TD").append(" EDIT='").append(eq_seqp ? "TRUE" : "FALSE").append("'").append(sFcolor).append(">").append(JSPUtil.getNull(rs.getObject(j))).append("</TD>").toString());
						} else if (colName.equals("TRSP_CRR_MOD_CD2")) {
							sb.append((new StringBuilder()).append("<TD").append(">").append("<![CDATA[").append(JSPUtil.getNull(rs.getObject("TRSP_CRR_MOD_CD"))).append("]]></TD>").toString());
						} else if (colName.equals("SEALNO")) {
							sb.append((new StringBuilder()).append("<TD").append(">").append("<![CDATA[").append(getNull(rs.getObject(j))).append("]]>").append("</TD>").toString());
						} else if (colName.equalsIgnoreCase("cng_ind_flg_img")) {
							if ("Y".equals(rs.getObject("cng_ind_flg_img"))) {
								sb.append("<TD>").append("<![CDATA[").append(new StringBuilder(IMG_RED)).append("]]></TD>");
							} else {
								sb.append("<TD>").append("<![CDATA[").append(new StringBuilder(IMG_BLANK)).append("]]></TD>");
							}
						} else if (colName.equalsIgnoreCase("dor_de_addr") || colName.equalsIgnoreCase("dor_pst_cd") || colName.equalsIgnoreCase("fctry_nm") || colName.equalsIgnoreCase("cntc_pson_phn_no") || colName.equalsIgnoreCase("cntc_pson_fax_no") || colName.equalsIgnoreCase("cntc_pson_nm")) {
							if ("CY".equals(trspCostDtlModCd)) {
								sb.append((new StringBuilder()).append("<TD").append(" EDIT='FALSE'").append(">").append("<![CDATA[").append(JSPUtil.getNull(rs.getObject(j))).append("]]>").append("</TD>").toString());
							} else {
								sb.append((new StringBuilder()).append("<TD").append(" EDIT='TRUE'").append(">").append("<![CDATA[").append(JSPUtil.getNull(rs.getObject(j))).append("]]>").append("</TD>").toString());
							}
						} else {
							sb.append((new StringBuilder()).append("<TD").append(">").append("<![CDATA[").append(getNull(rs.getObject(j))).append("]]>").append("</TD>").toString());
						}
					}
					sb.append("</TR>");
				}
				sb.append("\n</DATA>\n");
				return sb.toString();
			} else {
				sb.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' COLSEPARATOR='").append("\u261C\u261E").append("' TOTAL='").append(getRowSetCnt(rs)).append("'>\n").toString());
				int colCount = realColNms.length;
				for (; rs.next(); sb.append((new StringBuilder()).append(getNull(rs.getObject(colCount))).append("]]></TR>\n").toString())) {
					sb.append("\t<TR><![CDATA[");
					for (int j = 1; j < colCount; j++)
						sb.append((new StringBuilder()).append(getNull(rs.getObject(j))).append("\u261C\u261E").toString());

				}

				sb.append("</DATA>\n");
			}
		} catch (SQLException ex) {
			throw new RuntimeException(ex.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new RuntimeException(ex.getMessage());
		}
		return sb.toString();
	}

}
