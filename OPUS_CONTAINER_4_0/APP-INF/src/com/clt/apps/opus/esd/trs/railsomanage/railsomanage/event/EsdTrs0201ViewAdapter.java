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

public class EsdTrs0201ViewAdapter extends TrsDefaultViewAdapter {

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
			if (formcommand.isCommand(FormCommand.MULTI) || formcommand.isCommand(FormCommand.ADD) || formcommand.isCommand(FormCommand.MODIFY) || formcommand.isCommand(FormCommand.REMOVE) || formcommand.isCommand(FormCommand.REMOVELIST)) { // 저장XML인 경우
				sb.append("<RESULT>");
				sb.append("<TR-ALL>OK</TR-ALL>");
				sb.append("</RESULT>");
			} else if (formcommand.isCommand(FormCommand.SEARCH02)) {
				String changedColNms[] = getChangedColNms(realColNms, prefix);
				sb.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' TOTAL='").append(getRowSetCnt(rs)).append("'>\n").toString());
				while (rs.next()) {
					sb.append("<TR>");
					sb.append("<TD>");
					sb.append(getNull(rs.getString("EQ_NO")) + "</TD>");
					sb.append("<TD><![CDATA[");
					sb.append(getNull(rs.getString("VERIFY_RESULT")) + "]]></TD>");
					sb.append("<TD>");
					sb.append(getNull(rs.getString("VERIFY_YN")) + "</TD>");
					sb.append("</TR>\n");
				}
				sb.append("</DATA>\n");
			} else { // 조회XML인 경우
				String changedColNms[] = getChangedColNms(realColNms, prefix);
				sb.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' TOTAL='").append(getRowSetCnt(rs)).append("'>\n").toString());
				int colCount = realColNms.length;

				String colName = "";
				String sExpt = "";
				while (rs.next()) {
					sExpt = getNull(rs.getString("EXPT"));
					if (sExpt.equals("0") || "Y".equals(rs.getString("stop_off_flg")) || "Y".equals(rs.getString("overweight")) || "Y".equals(rs.getString("stcc_rstr_flg"))) {
						sb.append("<TR ").append("COLOR='RED'").append(">");
					} else {
						sb.append("<TR>");
					}
					for (int j = 0; j < colCount; j++) {
						colName = rs.getMetaData().getColumnName(j + 1);
						if ("CND_CSTMS_CLR_FLG".equals(colName)) {
							if ("N".equals(getNull(rs.getObject(colName)))) {
								sb.append("<TD EDIT='FALSE'></TD>");
							}
						} else {
							if (!"".equals(getNull(rs.getObject(colName)))) {
								sb.append("<TD><![CDATA[").append(getNull(rs.getObject(colName))).append("]]></TD>");
							} else {
								sb.append("<TD></TD>");
							}
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