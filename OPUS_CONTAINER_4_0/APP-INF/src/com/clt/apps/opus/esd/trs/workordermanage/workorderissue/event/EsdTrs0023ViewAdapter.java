/*=========================================================
 *Copyright(c) 2008 CyberLogitec
 *@FileName : DefaultViewAdapter.java
 *@FileTitle : Default IBSheet Generation Class
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2008-11-24
 *@LastModifier : Lee SeungYol
 *@LastVersion : 1.0
 * 2008-11-24 Lee SeungYol
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderissue.event;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.trs.common.util.TrsDefaultViewAdapter;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.vo.WoIssueListVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.utility.CheckUtilities;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * @author Eunju-Son
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EsdTrs0023ViewAdapter extends TrsDefaultViewAdapter {
	private final String IMG_RED = "/opuscntr/img/btng_icon_r.gif";
	private final String IMG_BLANK = "/opuscntr/img/blank.gif";

	@SuppressWarnings("rawtypes")
	protected String makeDataTag(List vos, String prefix, Event event) {
		FormCommand formcommand = event.getFormCommand();
		StringBuilder sb = new StringBuilder();
		String keepSoNos = CheckUtilities.isNullOrNullStringReplacement(((EsdTrs0023Event) event).getKeepSoNos(), "XX");
		try {
			if (formcommand.isCommand(FormCommand.MULTI01) || formcommand.isCommand(FormCommand.ADD) || formcommand.isCommand(FormCommand.MODIFY) || formcommand.isCommand(FormCommand.REMOVE)
					|| formcommand.isCommand(FormCommand.REMOVELIST)) { // 저장XML인 경우

				if (vos == null || vos.size() == 0) {
					sb.append("<RESULT>");
					sb.append("<TR-ALL>OK</TR-ALL>");
					sb.append("</RESULT>");
				}
			} else if (formcommand.isCommand(FormCommand.SEARCH) || formcommand.isCommand(FormCommand.SEARCH01) || formcommand.isCommand(FormCommand.SEARCH02)
					|| formcommand.isCommand(FormCommand.SEARCH03)) { // 조회XML인 경우
				int totCnt = vos.size();
				int realCnt = vos.size();
				AbstractValueObject vo = (AbstractValueObject) vos.get(0);
				String realColNms[] = getColHeader(vo);
				String changedColNms[] = getChangedColNms(realColNms, prefix);
				WoIssueListVO resultList = null;

				String sBgcolor = "";
				String sTpsz = "";
				String sSpcl = "";
				String sFmnd = "";
				String sWGT = "";
				String foFlag = "";
				String sono = "";
				float fLbsw = 0;
				if (vo.getMaxRows() > 0) {
					totCnt = vo.getMaxRows();
				}
				sb.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' COLSEPARATOR='").append("\u261C\u261E").append("' TOTAL='")
						.append(totCnt).append("'>\n").toString());
				for (int l = 0; l < realCnt; l++) {
					sBgcolor = "";
					sTpsz = "";
					sSpcl = "";
					sFmnd = "";
					sWGT = "";
					fLbsw = 0;
					resultList = (WoIssueListVO) vos.get(l);
					if (resultList != null) {
						sSpcl = JSPUtil.getNull(resultList.getSpclCgoCntrTpCd());
						sTpsz = JSPUtil.getNull(resultList.getEqTpszCd());
						sFmnd = JSPUtil.getNull(resultList.getFmLocValue());
						sWGT = JSPUtil.getNull(resultList.getLbsNetWgt());
						foFlag = JSPUtil.getNull(resultList.getFoFlg());
						sono = JSPUtil.getNull(resultList.getTrspSoOfcCtyCdSeq());
					}
					if ("".equals(sWGT) || sWGT == null) {
						sWGT = "0";
					}
					fLbsw = Float.parseFloat(sWGT);

					if (sFmnd.length() > 2) {
						sFmnd = sFmnd.substring(0, 2);
					}
					sBgcolor = "";
					if (sFmnd.equals("US")) {
						if ((sTpsz.equals("D2") && (Float.compare(fLbsw, 38000.0000F) >= 0)) || (sTpsz.equals("D4") && (Float.compare(fLbsw, 44000.0000F) >= 0))
								|| (sTpsz.equals("D5") && (Float.compare(fLbsw, 44000.0000F) >= 0)) || (sTpsz.equals("D7") && (Float.compare(fLbsw, 44000.0000F) >= 0))) {
							sBgcolor = "COLOR='BLUE'";
						}
						if (sSpcl.equals("DG") || sSpcl.equals("RF") || sSpcl.equals("AK") || sSpcl.equals("AD") || sSpcl.equals("RD") || sSpcl.equals("BB")) {
							sBgcolor = "COLOR='RED'";
						}
					}
					if ("Y".equals(foFlag)) {
						sBgcolor = "COLOR='RED'";
					}
					Map colValues = ((AbstractValueObject) vos.get(l)).getColumnValues();
					sb.append("<TR ");
					sb.append(sBgcolor + ">");
					sb.append("<![CDATA[");
					int colCnt = realColNms.length;
					for (int m = 0; m < colCnt - 1; m++) {
						if ("cng_ind_flg_img".equals(realColNms[m]) || "vndr_cm_img".equals(realColNms[m])) {
							if ("Y".equals(String.valueOf(getNull((String) colValues.get(realColNms[m]))))) {
								sb.append((new StringBuilder(IMG_RED)).append("☜☞").toString());
							} else {
								sb.append((new StringBuilder(IMG_BLANK)).append("☜☞").toString());
							}
						} else {
							sb.append((new StringBuilder(String.valueOf(getNull((String) colValues.get(realColNms[m]))))).append("☜☞").toString());
						}
					}
					if ("ibcheck".equals(realColNms[colCnt - 1])) {
						if (keepSoNos.indexOf(sono) > -1) {
							sb.append((new StringBuilder("1")).append("]]></TR>\n").toString());
						} else {
							sb.append((new StringBuilder("0")).append("]]></TR>\n").toString());
						}
					} else if ("cng_ind_flg_img".equals(realColNms[colCnt - 1]) || "vndr_cm_img".equals(realColNms[colCnt - 1])) {
						if ("Y".equals(String.valueOf(getNull((String) colValues.get(realColNms[colCnt - 1]))))) {
							sb.append((new StringBuilder(IMG_RED)).append("]]></TR>\n").toString());
						} else {
							sb.append((new StringBuilder(IMG_BLANK)).append("]]></TR>\n").toString());
						}
					} else {
						sb.append((new StringBuilder(String.valueOf(getNull((String) colValues.get(realColNms[colCnt - 1]))))).append("]]></TR>\n").toString());
					}
				}
				sb.append("</DATA>\n");
			} else if (formcommand.isCommand(FormCommand.INIT)) { // 조회XML인 경우
				sb.append(super.makeDataTag(vos, prefix));
			}
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new RuntimeException(ex.getMessage());
		}
		return sb.toString();
	}

	protected String makeDataTag(DBRowSet rs, String prefix, Event event) {
		FormCommand formcommand = event.getFormCommand();
		StringBuilder sb = new StringBuilder();
		StringBuilder colOrder = new StringBuilder();
		// ArrayList scgV = null;
		int rowCount = 0;

		if (rs.isPivot()) {
			sb.append(makePivotDataTag(rs));
			return sb.toString();
		}
		String realColNms[] = getColHeader(rs);
		try {
			if (formcommand.isCommand(FormCommand.MULTI01) || formcommand.isCommand(FormCommand.ADD) || formcommand.isCommand(FormCommand.MODIFY) || formcommand.isCommand(FormCommand.REMOVE)
					|| formcommand.isCommand(FormCommand.REMOVELIST)) { // 저장XML인 경우

				sb.append("<RESULT>");
				sb.append("<TR-ALL>OK</TR-ALL>");
				sb.append("</RESULT>");
			} else if (formcommand.isCommand(FormCommand.SEARCH04)) { // 조회XML인 경우

				StringBuffer bil_case_cd = new StringBuffer();
				StringBuffer bil_case_nm = new StringBuffer();

				bil_case_cd.append(' ');
				bil_case_nm.append(' ');

				while (rs != null && rs.next()) {
					bil_case_cd.append('|' + JSPUtil.getNull(rs.getString("N3PTY_BIL_TP_CD")));
					bil_case_nm.append('|' + JSPUtil.getNull(rs.getString("N3PTY_BIL_TP_NM")));
				}
				sb.append("<SHEET>\n");
				// <!-- 선택항목1. ETC-DATA 요소 -->
				sb.append("<ETC-DATA>\n");
				sb.append("<ETC KEY='bil_cs_cd'><![CDATA['" + bil_case_cd + "']]></ETC>\n");
				sb.append("<ETC KEY='bil_cs_nm'><![CDATA['" + bil_case_nm + "']]></ETC>\n");
				sb.append("</ETC-DATA>\n");
				sb.append("</SHEET>\n");

			} else if (formcommand.isCommand(FormCommand.SEARCH) || formcommand.isCommand(FormCommand.SEARCH01)) { // 조회XML인 경우
				String changedColNms[] = getChangedColNms(realColNms, prefix);
				sb.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' TOTAL='").append(getRowSetCnt(rs)).append("'>\n").toString());
				int columnCnt = rs.getMetaData().getColumnCount();
				if (rs != null) {
					rowCount = rs.getRowCount();

					for (int k = 1; k < columnCnt + 1; k++) {
						colOrder.append(rs.getMetaData().getColumnName(k));
						if (k != rs.getMetaData().getColumnCount())
							colOrder.append("|");
					}

					while (rs.next()) {
						sb.append("<SHEET>\n");
					}
				} // end if(rs != null)
				sb.append("<DATA TOTAL=\'" + rowCount + "\' COLORDER=\'" + colOrder + "\'>\n");

				String sBgcolor = "";
				String sTpsz = "";
				String sSpcl = "";
				String sFmnd = ""; // fm_loc_value
				float fLbsw = 0; // LBS_NET_WGT

				if (rs != null) {

					while (rs.next()) {
						sBgcolor = "";
						sTpsz = "";
						sSpcl = "";
						sFmnd = "";
						fLbsw = 0;

						sSpcl = JSPUtil.getNull(rs.getString("SPCL_CGO_CNTR_TP_CD")); // SPCL_CGO_CNTR_TP_CD
						sTpsz = JSPUtil.getNull(rs.getString("EQ_TPSZ_CD")); // EQ_TPSZ_CD
						sFmnd = JSPUtil.getNull(rs.getString("FM_LOC_VALUE")); // FM_LOC_VALUE

						if (sFmnd.length() > 2)
							sFmnd = sFmnd.substring(0, 2);
						fLbsw = rs.getFloat("LBS_NET_WGT");

						sBgcolor = "";
						if (sFmnd.equals("US")) {
							if ((sTpsz.equals("D2") && (Float.compare(fLbsw, 38000.0000F) >= 0)) || (sTpsz.equals("D4") && (Float.compare(fLbsw, 44000.0000F) >= 0))
									|| (sTpsz.equals("D5") && (Float.compare(fLbsw, 44000.0000F) >= 0)) || (sTpsz.equals("D7") && (Float.compare(fLbsw, 44000.0000F) >= 0))) {
								// 2009.03.11 추가 미주 CNTR의 TP/SZ가 D2 이면서 38.000 LBS 이상 또는 D4/D5/D7 이면서 44.000 LBS 이상 데이터는 전체 row data를 파란색으로 표시
								sBgcolor = "COLOR='BLUE'";
							}

							if (sSpcl.equals("DG") || sSpcl.equals("RF") || sSpcl.equals("AK") || sSpcl.equals("AD") || sSpcl.equals("RD") || sSpcl.equals("BB")) {
								// 2009.03.11 추가 미주 CNTR의 special 정보중 DG/RF/AW 는 전체 row data를 빨간색으로 표시
								sBgcolor = "COLOR='RED'";
							}
						}

						sb.append("<TR ");
						sb.append(sBgcolor + ">");
						for (int j = 0; j < columnCnt; j++) {
							sb.append("<TD><![CDATA[" + JSPUtil.getNull(rs.getString(j + 1)) + "]]></TD>");
						}
						sb.append("</TR>");
					}
				}
				sb.append("</DATA>\n");

			} else if (formcommand.isCommand(FormCommand.SEARCH05) || formcommand.isCommand(FormCommand.SEARCH06)) {

				String changedColNms[] = getChangedColNms(realColNms, prefix);

				sb.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' TOTAL='").append(getRowSetCnt(rs)).append("'>\n").toString());
				int columnCnt = rs.getMetaData().getColumnCount();
				if (rs != null) {
					rowCount = rs.getRowCount();

					for (int k = 1; k < columnCnt + 1; k++) {
						colOrder.append(rs.getMetaData().getColumnName(k));
						if (k != rs.getMetaData().getColumnCount())
							colOrder.append("|");
					}

					while (rs.next()) {
						sb.append("<TR>");
						for (int j = 0; j < columnCnt; j++) {
							sb.append("<TD><![CDATA[" + JSPUtil.getNull(rs.getString(j + 1)) + "]]></TD>");
						}
						sb.append("</TR>");
					}
				} // end if(rs != null)
				sb.append("</DATA>\n");

			} else {
				String changedColNms[] = getChangedColNms(realColNms, prefix);
				sb.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' COLSEPARATOR='").append("\u261C\u261E").append("' TOTAL='")
						.append(getRowSetCnt(rs)).append("'>\n").toString());
				int colCount = realColNms.length;
				for (; rs.next(); sb.append((new StringBuilder()).append(getNull(rs.getObject(colCount))).append("]]></TR>\n").toString())) {
					sb.append("\t<TR><![CDATA[");
					for (int j = 1; j < colCount; j++)
						sb.append((new StringBuilder()).append(getNull(rs.getObject(j))).append("\u261C\u261E").toString());
				}

				sb.append("</DATA>\n");
			}
		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
			throw new RuntimeException(ex.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new RuntimeException(ex.getMessage());
		}
		return sb.toString();
	}

	@SuppressWarnings("rawtypes")
	protected String getETCData(EventResponse eventResponse) {
		if (eventResponse == null)
			return "";

		StringBuilder sb = new StringBuilder();
		HashMap<String, String> etc_data = (HashMap<String, String>) eventResponse.getETCData();

		sb.append("<ETC-DATA>\n");
		if (etc_data != null && etc_data.size() > 0) {
			Iterator it = etc_data.keySet().iterator();
			while (it.hasNext()) {
				String key = (String) it.next();
				String val = "" + etc_data.get(key);
				sb.append("<ETC KEY='" + key + "'><![CDATA[" + val + "]]></ETC>\n");
			}
		}
		// Pivot 관련 ETC-DATA생성
		sb.append(getPivotETCData(eventResponse));
		sb.append("</ETC-DATA>\n");

		return sb.toString();
	}

}
