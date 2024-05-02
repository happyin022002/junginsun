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
package com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.event;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.trs.common.util.TrsDefaultViewAdapter;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Jin-O Choi
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */

public class EsdTrs0028ViewAdapter extends TrsDefaultViewAdapter {

	@SuppressWarnings("rawtypes")
	protected String makeDataTag(List vos, String prefix, Event event) {
		StringBuilder sbufXML = new StringBuilder();
		int totCnt = vos.size();
		int realCnt = vos.size();
		AbstractValueObject vo = (AbstractValueObject) vos.get(0);
		String realColNms[] = getColHeader(vo);
		String changedColNms[] = getChangedColNms(realColNms, prefix);
		if (vo.getMaxRows() > 0)
			totCnt = vo.getMaxRows();
		sbufXML.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' COLSEPARATOR='").append("\u261C\u261E").append("' TOTAL='").append(totCnt).append("'>\n").toString());
		for (int i = 0; i < realCnt; i++) {
			Map colValues = ((AbstractValueObject) vos.get(i)).getColumnValues();
			sbufXML.append("\t<TR><![CDATA[");
			int colCnt = realColNms.length;
			for (int j = 0; j < colCnt - 1; j++)
				sbufXML.append((new StringBuilder(String.valueOf(getNull((String) colValues.get(realColNms[j]))))).append("\u261C\u261E").toString());

			sbufXML.append((new StringBuilder(String.valueOf(getNull((String) colValues.get(realColNms[colCnt - 1]))))).append("]]></TR>\n").toString());
		}

		sbufXML.append("</DATA>\n");
		return sbufXML.toString();
	}

	protected String makeDataTag(DBRowSet rs, String prefix, Event event) {
		FormCommand formcommand = event.getFormCommand();
		StringBuilder sb = new StringBuilder();
		if (rs.isPivot()) {
			sb.append(makePivotDataTag(rs));
			return sb.toString();
		}
		String realColNms[] = getColHeader(rs);
		try {
			if (formcommand.isCommand(FormCommand.MULTI) || formcommand.isCommand(FormCommand.MULTI03) || formcommand.isCommand(FormCommand.MULTI04) || formcommand.isCommand(FormCommand.MODIFY) || formcommand.isCommand(FormCommand.MULTI02) || formcommand.isCommand(FormCommand.SEARCHLIST12)) { // 저장XML인
																																																																										// 경우

				sb.append("<RESULT>");
				sb.append("<TR-ALL>OK</TR-ALL>");
				sb.append("</RESULT>");

			} else if (formcommand.isCommand(FormCommand.SEARCH)) { // 조회XML인 경우
				String changedColNms[] = getChangedColNms(realColNms, prefix);
				sb.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' TOTAL='").append(getRowSetCnt(rs)).append("'>\n").toString());
				int colCount = realColNms.length;

				String colName = "";
				String sLastchk = "";
				String sInvFlg = "";
				String sBilIssStsCd = "";
				String sBilEdiRcvRsltCd = "";
				String sCgoTpCd = "";
				String sTrspBndCd = "";
				String sSpclCgoCntrTpCd = "";
				String sBkgSpe = "";
				String sInterRmk = "";
				String sSpclInstrRmk = "";
				String sDeltFlg = "";
				String exptAckVndrFlg = "N";

				String sBgcolor = "BGCOLOR='239,235,239'";

				while (rs.next()) {
					String sChk1 = "";
					String sChk2 = "";
					String sChk3 = "";
					String sChk4 = "";
					String sChk5 = "";
					String sInterRmkChk = "";
					String sSpclInstrRmkChk = "";
					String sWoRjctRsn = "";
					String sLvSpclCgo = "";
					String sLvSpclCgoChk = "";

					sLastchk = getNull(rs.getString("LASTCHK"));
					exptAckVndrFlg = getNull(rs.getString("EXPT_ACK_VNDR_FLG"));
					sInvFlg = getNull(rs.getString("INV_FLG"));
					sBilIssStsCd = getNull(rs.getString("BIL_ISS_STS_CD"));
					sBilEdiRcvRsltCd = getNull(rs.getString("BIL_EDI_RCV_RSLT_CD"));
					sCgoTpCd = getNull(rs.getString("CGO_TP_CD"));
					sTrspBndCd = getNull(rs.getString("TRSP_BND_CD"));
					sSpclCgoCntrTpCd = getNull(rs.getString("SPCL_CGO_CNTR_TP_CD"));
					sBkgSpe = getNull(rs.getString("BKG_SPE"));
					sInterRmk = getNull(rs.getString("INTER_RMK"));
					sSpclInstrRmk = getNull(rs.getString("SPCL_INSTR_RMK"));
					sDeltFlg = getNull(rs.getString("DELT_FLG"));

					// LASTCHK 컬럼으로 Check..
					if (!"Y".equals(getNull(sLastchk)) || "Y".equals(getNull(sInvFlg)) || "Y".equals(getNull(sDeltFlg))) {
						sChk5 = "EDIT='FALSE' " + sBgcolor;
						sChk4 = "EDIT='FALSE' " + sBgcolor;
						sChk3 = "EDIT='FALSE' " + sBgcolor;
						sChk2 = "EDIT='FALSE' " + sBgcolor;
						sChk1 = "EDIT='FALSE' " + sBgcolor;
						sInterRmkChk = "EDIT='FALSE' " + sBgcolor;
						sSpclInstrRmkChk = "EDIT='FALSE' " + sBgcolor;
					}

					// Bill Issue Code 컬럼으로 Check..
					if ("I".equals(sBilIssStsCd)) {
						if ("A".equals(sBilEdiRcvRsltCd) || "E".equals(sBilEdiRcvRsltCd) || "R".equals(sBilEdiRcvRsltCd)) {
							sChk1 = "EDIT='FALSE' " + sBgcolor;
						} else {
							if ("N".equals(exptAckVndrFlg)) {
								sChk2 = "EDIT='FALSE' " + sBgcolor;
							}
						}
					} else if ("X".equals(sBilIssStsCd)) {
						if ("A".equals(sBilEdiRcvRsltCd) && "E".equals(sBilEdiRcvRsltCd)) {
							sChk2 = "EDIT='FALSE' " + sBgcolor;
							sChk1 = "EDIT='FALSE' " + sBgcolor;
						} else {
							sChk5 = "EDIT='FALSE' " + sBgcolor;
							sChk1 = "EDIT='FALSE' " + sBgcolor;
						}
					} else {
						sChk2 = "EDIT='FALSE' " + sBgcolor;
					}

					// Cargo Type Code 컬럼으로 Check..
					if ("M".equals(sCgoTpCd)) {
						sWoRjctRsn = "EDIT='FALSE' " + sBgcolor;
					}

					// Cargo Type Code 컬럼으로 Check..
					if ("I".equals(sTrspBndCd)) {
						sLvSpclCgo = sSpclCgoCntrTpCd;
					} else {
						sLvSpclCgo = sBkgSpe;
					}

					if (!"".equals(sLvSpclCgo)) {
						sLvSpclCgoChk = "COLOR='255,0,0'";
					}
					if (!"".equals(sLvSpclCgoChk)) {
						sb.append("<TR " + sLvSpclCgoChk + ">");
					} else {
						sb.append("<TR>");
					}
					for (int j = 0; j < colCount; j++) {
						colName = rs.getMetaData().getColumnName(j + 1);
						if ("CHK5".equals(colName)) {
							if (!"".equals(sChk5)) {
								sb.append("<TD " + sChk5 + ">");
								sb.append(getNull(rs.getString("CHK5")) + "</TD>");
							} else {
								sb.append("<TD>");
								sb.append(getNull(rs.getString("CHK5")) + "</TD>");
							}
						} else if ("CHK4".equals(colName)) {
							if (!"".equals(sChk4)) {
								sb.append("<TD " + sChk4 + ">");
								sb.append(getNull(rs.getString("CHK4")) + "</TD>");
							} else {
								sb.append("<TD>");
								sb.append(getNull(rs.getString("CHK4")) + "</TD>");
							}
						} else if ("CHK3".equals(colName)) {
							if (!"".equals(sChk3)) {
								sb.append("<TD " + sChk3 + ">");
								sb.append(getNull(rs.getString("CHK3")) + "</TD>");
							} else {
								sb.append("<TD>");
								sb.append(getNull(rs.getString("CHK3")) + "</TD>");
							}
						} else if ("CHK2".equals(colName)) {
							if (!"".equals(sChk2)) {
								sb.append("<TD " + sChk2 + ">");
								sb.append(getNull(rs.getString("CHK2")) + "</TD>");
							} else {
								sb.append("<TD>");
								sb.append(getNull(rs.getString("CHK2")) + "</TD>");
							}
						} else if ("CHK1".equals(colName)) {
							if (!"".equals(sChk1)) {
								sb.append("<TD " + sChk1 + ">");
								sb.append(getNull(rs.getString("CHK1")) + "</TD>");
							} else {
								sb.append("<TD>");
								sb.append(getNull(rs.getString("CHK1")) + "</TD>");
							}
						} else if ("INTER_RMK".equals(colName)) {
							if (!"".equals(sInterRmkChk)) {
								if (!"".equals(sInterRmk)) {
									sb.append("<TD " + sInterRmkChk + "><![CDATA[");
									sb.append(getNull(rs.getString("INTER_RMK")) + "]]></TD>");
								} else {
									sb.append("<TD " + sInterRmkChk + ">");
									sb.append(getNull(rs.getString("INTER_RMK")) + "</TD>");
								}
							} else {
								if ("M".equals(sCgoTpCd)) {
									sb.append("<TD EDIT='TRUE'><![CDATA[");
									sb.append(getNull(rs.getString("INTER_RMK")) + "]]></TD>");
								} else {
									sb.append("<TD EDIT='FALSE'><![CDATA[");
									sb.append(getNull(rs.getString("INTER_RMK")) + "]]></TD>");
								}
							}
						} else if ("SPCL_INSTR_RMK".equals(colName)) {
							if (!"".equals(sSpclInstrRmkChk)) {
								if (!"".equals(sSpclInstrRmk)) {
									sb.append("<TD " + sSpclInstrRmkChk + "><![CDATA[");
									sb.append(getNull(rs.getString("SPCL_INSTR_RMK")) + "]]></TD>");
								} else {
									sb.append("<TD " + sSpclInstrRmkChk + ">");
									sb.append(getNull(rs.getString("SPCL_INSTR_RMK")) + "</TD>");
								}
							} else {
								if (!"".equals(sSpclInstrRmk)) {
									sb.append("<TD><![CDATA[");
									sb.append(getNull(rs.getString("SPCL_INSTR_RMK")) + "]]></TD>");
								} else {
									sb.append("<TD>");
									sb.append(getNull(rs.getString("SPCL_INSTR_RMK")) + "</TD>");
								}
							}
						} else if ("WO_RJCT_RSN".equals(colName)) {
							if (!"".equals(sWoRjctRsn)) {
								sb.append("<TD " + sWoRjctRsn + ">");
								sb.append(getNull(rs.getString("WO_RJCT_RSN")) + "</TD>");
							} else {
								sb.append("<TD>");
								sb.append(getNull(rs.getString("WO_RJCT_RSN")) + "</TD>");
							}
						} else {
							sb.append("<TD><![CDATA[");
							sb.append(getNull(rs.getObject(colName)) + "]]></TD>");
						}
					}// for end
					sb.append("</TR>\n");
				}// while end
				sb.append("</DATA>\n");
			} else {
				String changedColNms[] = getChangedColNms(realColNms, prefix);
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
