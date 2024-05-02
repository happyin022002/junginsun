/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : DefaultViewAdapter.java
 *@FileTitle : Default IBSheet Generation Class
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.03.07
 *@LastModifier : 김종호
 *@LastVersion : 1.2
 * 2008-11-24 Lee SeungYol
 * 1.0 최초 생성
 * 1.2 2011.03.07 김종호 : ALPS 고도화 작업
=========================================================*/
package com.clt.apps.opus.esd.trs.railsomanage.railsomanage.event;

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
 * @author Poong-Yeon Cho
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */

public class EsdTrs0204ViewAdapter extends TrsDefaultViewAdapter {

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
		sbufXML.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' COLSEPARATOR='").append("\u261C\u261E").append("' TOTAL='")
				.append(totCnt).append("'>\n").toString());
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
			if (formcommand.isCommand(FormCommand.MULTI) || formcommand.isCommand(FormCommand.MODIFY01) || formcommand.isCommand(FormCommand.MODIFY) || formcommand.isCommand(FormCommand.REMOVE)
					|| formcommand.isCommand(FormCommand.SEARCHLIST12)) { // 저장XML인 경우

				sb.append("<RESULT>");
				sb.append("<TR-ALL>OK</TR-ALL>");
				sb.append("</RESULT>");
			} else { // 조회XML인 경우
				String changedColNms[] = getChangedColNms(realColNms, prefix);
				sb.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' TOTAL='").append(getRowSetCnt(rs)).append("'>\n").toString());

				int colCount = realColNms.length;

				String colName = "";
				String sBgcolor = "";
				String sibd_it_loc = "";
				String sstatus = "";
				String sthrough = "";
				String sbkgSpe = "";
				String screDtHms = "";
				String sbkgUpdDtHms = "";
				String scxlRqstDtHms = "";
				String scxlRqstRsn = "";
				String scxlRqstRjctDtHms = "";
				String srqstRjctRsn = "";
				String sinterRmk = "";
				String sspclInstrRmk = "";
				String serrDesc = "";
				String sinlndRoutRmk = "";
				String srefNo = "";
				String scmdtName = "";
				String scntrWgt = "";
				String sbkgStsCd = "";
				String sbkgNo = "";
				String strunkvvdRevised = "";
				String spodCdRevised = "";
				String cgoTpCd = "";

				while (rs.next()) {
					sibd_it_loc = getNull(rs.getString("ibd_ipi_locl_ind_cd"));
					sstatus = getNull(rs.getString("STATUS"));
					sbkgSpe = getNull(rs.getString("BKG_SPE")).trim();
					screDtHms = getNull(rs.getString("CRE_DT_HMS"));
					sbkgUpdDtHms = getNull(rs.getString("BKG_UPDATED_DT_HMS"));
					scxlRqstDtHms = getNull(rs.getString("CXL_RQST_DT_HMS"));
					scxlRqstRsn = getNull(rs.getString("CXL_RQST_RSN"));
					scxlRqstRjctDtHms = getNull(rs.getString("CXL_RQST_RJCT_DT_HMS"));
					srqstRjctRsn = getNull(rs.getString("RQST_RJCT_RSN"));
					sinterRmk = getNull(rs.getString("INTER_RMK"));
					sspclInstrRmk = getNull(rs.getString("SPCL_INSTR_RMK"));
					serrDesc = getNull(rs.getString("ERR_DESC"));
					sinlndRoutRmk = getNull(rs.getString("INLND_ROUT_RMK"));
					srefNo = getNull(rs.getString("REF_NO"));
					scmdtName = getNull(rs.getString("CMDT_NAME"));
					scntrWgt = getNull(rs.getString("CNTR_WGT"));
					sbkgStsCd = getNull(rs.getString("BKG_STS_CD")).trim();
					sbkgNo = getNull(rs.getString("BKG_NO")).trim();
					strunkvvdRevised = getNull(rs.getString("TRUNKVVD_REVISED")).trim();
					spodCdRevised = getNull(rs.getString("POD_CD_REVISED")).trim();
					cgoTpCd = getNull(rs.getString("CGO_TP_CD")).trim();
					sthrough = getNull(rs.getString("THROUGH")).trim();

					boolean bit_loc = false;
					if (sibd_it_loc.equals("L")) {
						bit_loc = true;
					} else {
						bit_loc = false;
					}

					if ("DG".equals(sbkgSpe)) {
						sBgcolor = "COLOR='RED'";
						sb.append("<TR " + sBgcolor + ">");
					} else {
						sBgcolor = "";
						sb.append("<TR>");
					}

					for (int j = 0; j < colCount; j++) {
						colName = rs.getMetaData().getColumnName(j + 1);
						sb.append("<TD");
						if ("IBD_IPI_LOCL_IND_CD".equals(colName)) {
							if (bit_loc == false) {
								sb.append(" EDIT=''>");
							} else {
								sb.append(" EDIT='FALSE'>");
							}
						} else if ("IBD_NO".equals(colName)) {
							sb.append(" EDIT='FALSE'>");
						} else if ("INTER_RMK".equals(colName) && "M".equals(cgoTpCd)) {
							sb.append(" EDIT='TRUE'>");
						} else {
							sb.append(">");
						}

						if ("STATUS".equals(colName)) {
							if ("".equals(sstatus)) {
								sb.append("</TD>");
							} else {
								sb.append("<![CDATA[");
								sb.append(getNull(sstatus) + "]]></TD>");
							}
						} else if ("THROUGH".equals(colName)) {
							if ("".equals(sthrough)) {
								sb.append("</TD>");
							} else {
								sb.append("<![CDATA[");
								sb.append(getNull(sthrough) + "]]></TD>");
							}
						} else if ("BKG_SPE".equals(colName)) {
							if ("".equals(sbkgSpe)) {
								sb.append("</TD>");
							} else {
								sb.append("<![CDATA[");
								sb.append(getNull(sbkgSpe) + "]]></TD>");
							}
						} else if ("CRE_DT_HMS".equals(colName)) {
							if ("".equals(screDtHms)) {
								sb.append("</TD>");
							} else {
								sb.append("<![CDATA[");
								sb.append(getNull(screDtHms) + "]]></TD>");
							}
						} else if ("BKG_UPDATED_DT_HMS".equals(colName)) {
							if ("".equals(sbkgUpdDtHms)) {
								sb.append("</TD>");
							} else {
								sb.append("<![CDATA[");
								sb.append(getNull(sbkgUpdDtHms) + "]]></TD>");
							}
						} else if ("CXL_RQST_DT_HMS".equals(colName)) {
							if ("".equals(scxlRqstDtHms)) {
								sb.append("</TD>");
							} else {
								sb.append("<![CDATA[");
								sb.append(getNull(scxlRqstDtHms) + "]]></TD>");
							}
						} else if ("CXL_RQST_RSN".equals(colName)) {
							if ("".equals(scxlRqstRsn)) {
								sb.append("</TD>");
							} else {
								sb.append("<![CDATA[");
								sb.append(getNull(scxlRqstRsn) + "]]></TD>");
							}
						} else if ("CXL_RQST_RJCT_DT_HMS".equals(colName)) {
							if ("".equals(scxlRqstRjctDtHms)) {
								sb.append("</TD>");
							} else {
								sb.append("<![CDATA[");
								sb.append(getNull(scxlRqstRjctDtHms) + "]]></TD>");
							}
						} else if ("RQST_RJCT_RSN".equals(colName)) {
							if ("".equals(srqstRjctRsn)) {
								sb.append("</TD>");
							} else {
								sb.append("<![CDATA[");
								sb.append(getNull(srqstRjctRsn) + "]]></TD>");
							}
						} else if ("INTER_RMK".equals(colName)) {
							if ("".equals(sinterRmk)) {
								sb.append("</TD>");
							} else {
								sb.append("<![CDATA[");
								sb.append(getNull(sinterRmk) + "]]></TD>");
							}
						} else if ("SPCL_INSTR_RMK".equals(colName)) {
							if ("".equals(sspclInstrRmk)) {
								sb.append("</TD>");
							} else {
								sb.append("<![CDATA[");
								sb.append(getNull(sspclInstrRmk) + "]]></TD>");
							}
						} else if ("ERR_DESC".equals(colName)) {
							if ("".equals(serrDesc)) {
								sb.append("</TD>");
							} else {
								sb.append("<![CDATA[");
								sb.append(getNull(serrDesc) + "]]></TD>");
							}
						} else if ("INLND_ROUT_RMK".equals(colName)) {
							if ("".equals(sinlndRoutRmk)) {
								sb.append("</TD>");
							} else {
								sb.append("<![CDATA[");
								sb.append(getNull(sinlndRoutRmk) + "]]></TD>");
							}
						} else if ("REF_NO".equals(colName)) {
							if ("".equals(srefNo)) {
								sb.append("</TD>");
							} else {
								sb.append("<![CDATA[");
								sb.append(getNull(srefNo) + "]]></TD>");
							}
						} else if ("CMDT_NAME".equals(colName)) {
							if ("".equals(scmdtName)) {
								sb.append("</TD>");
							} else {
								sb.append("<![CDATA[");
								sb.append(getNull(scmdtName) + "]]></TD>");
							}
						} else if ("CNTR_WGT".equals(colName)) {
							if ("".equals(scntrWgt)) {
								sb.append("</TD>");
							} else {
								sb.append("<![CDATA[");
								sb.append(getNull(scntrWgt) + "]]></TD>");
							}
						} else if ("BKG_STS_CD".equals(colName)) {
							sb.append("<![CDATA[");
							sb.append(getNull(sbkgStsCd) + "]]></TD>");
						} else if ("BKG_NO".equals(colName)) {
							sb.append(getNull(sbkgNo) + "</TD>");
						} else if ("TRUNKVVD_REVISED".equals(colName)) {
							sb.append("<![CDATA[");
							sb.append(getNull(strunkvvdRevised) + "]]></TD>");
						} else if ("POD_CD_REVISED".equals(colName)) {
							sb.append("<![CDATA[");
							sb.append(getNull(spodCdRevised) + "]]></TD>");
						} else {
							sb.append("<![CDATA[");
							sb.append(getNull(rs.getObject(colName)) + "]]></TD>");
						}

					}
					sb.append("</TR>\n");
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
