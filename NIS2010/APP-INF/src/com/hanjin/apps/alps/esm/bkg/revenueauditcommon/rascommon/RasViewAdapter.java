/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : PriViewAdapter.java
 *@FileTitle : PriViewAdapter
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.12
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.08.12 박성수
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author SungSoo Park
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class RasViewAdapter extends ViewAdapter {

	private final static String ROW_PROP_COL_NM = "row_properties";
	private final static String CELL_PROP_POSTFIX_NM = "_prop";
	private final static String CELL_TOOLTIP_TEXT_NM = "_tooltip";
	private final static String PROP_SEPARATOR = ";";
	private final static String VAL_SEPARATOR = ":";

	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param List<AbstractValueObject> vos List 객체
	 * @param String prefix IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception
	 */
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		StringBuilder sbXml = new StringBuilder();

		int iTotal = vos.size();
		int iRowCount = iTotal;

		Map<String, String> mapRow = null;
		String sRowProp = null;
		String sCellProp = null;
		String sTooltipText = null;
		String[] arrPropList = null;
		String[] arrProp = null;

		AbstractValueObject vo = (AbstractValueObject) vos.get(0);
		String[] arrColNm = super.getColHeader(vo);
		String[] arrPfxColNm = super.getChangedColNms(arrColNm, prefix);

		if (vo.getMaxRows() > 0) {
			iTotal = vo.getMaxRows();
		}

		sbXml.append("<DATA COLORDER=\"" + JSPUtil.convertStringArrayToString(arrPfxColNm, "|") + "\" TOTAL=\""
				+ iTotal + "\">\n");

		for (int i = 0; i < iRowCount; i++) {
			mapRow = vos.get(i).getColumnValues();

			sbXml.append("\t<TR");
			if (mapRow.containsKey(ROW_PROP_COL_NM)) {
				sRowProp = mapRow.get(ROW_PROP_COL_NM);
				if (sRowProp != null && sRowProp.trim().length() > 0) {
					arrPropList = sRowProp.toUpperCase().split(PROP_SEPARATOR);
					for (int t = 0; t < arrPropList.length; t++) {
						arrProp = arrPropList[t].split(VAL_SEPARATOR);
						if (arrProp.length < 2) {
							sbXml.append(" " + arrPropList[t].trim());
						} else {
							sbXml.append(" " + arrProp[0].trim() + "=\"" + arrProp[1].trim() + "\"");
						}
					}
				}
			}
			sbXml.append(">\n");

			for (int j = 0; j < arrColNm.length; j++) {
				String sColNm = arrColNm[j];
				String sPropColNm = sColNm + CELL_PROP_POSTFIX_NM;
				String sTooltipColNm = sColNm + CELL_TOOLTIP_TEXT_NM;

				sbXml.append("\t\t<TD");
				if (mapRow.containsKey(sPropColNm)) {
					sCellProp = mapRow.get(sPropColNm);
					if (sCellProp != null && sCellProp.trim().length() > 0) {
						arrPropList = sCellProp.toUpperCase().split(PROP_SEPARATOR);
						for (int t = 0; t < arrPropList.length; t++) {
							arrProp = arrPropList[t].split(VAL_SEPARATOR);
							if (arrProp.length < 2) {
								sbXml.append(" " + arrPropList[t].trim());
							} else {
								sbXml.append(" " + arrProp[0].trim() + "=\"" + arrProp[1].trim() + "\"");
							}
						}
					}
				}
				if (mapRow.containsKey(sTooltipColNm)) {
					sTooltipText = mapRow.get(sTooltipColNm);
					if (sTooltipText != null && sTooltipText.trim().length() > 0) {
						sbXml.append(" TOOL-TIP=\"" + sTooltipText.replaceAll("&", "&amp;").replaceAll("\"", "&quot;").replaceAll("<", "&lt;").replaceAll(">", "&gt;") + "\"");
						//sbXml.append(" TOOL-TIP=\"" + JSPUtil.replaceForHTML(sTooltipText) + "\"");
					}
				}
				sbXml.append("><![CDATA[");
				sbXml.append(super.getNull(mapRow.get(arrColNm[j])));
				sbXml.append("]]></TD>\n");
			}
			sbXml.append("\t</TR>\n");
		}

		sbXml.append("</DATA>\n");

		return sbXml.toString();
	}

	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param rs DBRowSet rs DBRowSet객체
	 * @param String prefix IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception
	 */
	protected String makeDataTag(DBRowSet rs, String prefix) {
		StringBuilder sbXml = new StringBuilder();

		int iTotal = getRowSetCnt(rs);

		Map<String, String> mapCol = new HashMap<String, String>();
		String sRowProp = null;
		String sCellProp = null;
		String sTooltipText = null;
		String[] arrPropList = null;
		String[] arrProp = null;

		String[] arrColNm = super.getColHeader(rs);
		String[] arrPfxColNm = super.getChangedColNms(arrColNm, prefix);

		try {
			for (int s = 0; s < arrColNm.length; s++) {
				mapCol.put(arrColNm[s], "");
			}

			if (rs.getMaxRows() > 0) {
				iTotal = rs.getMaxRows();
			}

			sbXml.append("<DATA COLORDER=\"" + JSPUtil.convertStringArrayToString(arrPfxColNm, "|") + "\" TOTAL=\""
					+ iTotal + "\">\n");

			while (rs.next()) {
				sbXml.append("\t<TR");
				if (mapCol.containsKey(ROW_PROP_COL_NM)) {
					sRowProp = rs.getString(ROW_PROP_COL_NM);
					if (sRowProp != null && sRowProp.trim().length() > 0) {
						arrPropList = sRowProp.toUpperCase().split(PROP_SEPARATOR);
						for (int t = 0; t < arrPropList.length; t++) {
							arrProp = arrPropList[t].split(VAL_SEPARATOR);
							if (arrProp.length < 2) {
								sbXml.append(" " + arrPropList[t].trim());
							} else {
								sbXml.append(" " + arrProp[0].trim() + "=\"" + arrProp[1].trim() + "\"");
							}
						}
					}
				}
				sbXml.append(">\n");

				for (int j = 0; j < arrColNm.length; j++) {
					String sColNm = arrColNm[j];
					String sPropColNm = sColNm + CELL_PROP_POSTFIX_NM;
					String sTooltipColNm = sColNm + CELL_TOOLTIP_TEXT_NM;

					sbXml.append("\t\t<TD");
					if (mapCol.containsKey(sPropColNm)) {
						sCellProp = rs.getString(sPropColNm);
						if (sCellProp != null && sCellProp.trim().length() > 0) {
							arrPropList = sCellProp.toUpperCase().split(PROP_SEPARATOR);
							for (int t = 0; t < arrPropList.length; t++) {
								arrProp = arrPropList[t].split(VAL_SEPARATOR);
								if (arrProp.length < 2) {
									sbXml.append(" " + arrPropList[t].trim());
								} else {
									sbXml.append(" " + arrProp[0].trim() + "=\"" + arrProp[1].trim() + "\"");
								}
							}
						}
					}
					if (mapCol.containsKey(sTooltipColNm)) {
						sTooltipText = rs.getString(sTooltipColNm);
						if (sTooltipText != null && sTooltipText.trim().length() > 0) {
							sbXml.append(" TOOL-TIP=\"" + sTooltipText.replaceAll("\"", "\\\"").replaceAll("<", "&lt;").replaceAll(">", "&gt;") + "\"");
						}
					}
					sbXml.append("><![CDATA[");
					sbXml.append(super.getNull(rs.getString(arrColNm[j])));
					sbXml.append("]]></TD>\n");
				}
				sbXml.append("\t</TR>\n");
			}

			sbXml.append("</DATA>\n");
		} catch (SQLException ex) {
			throw new RuntimeException(ex.getMessage());
		} catch(Exception ex){
            throw new RuntimeException(ex.getMessage());
        }

		return sbXml.toString();
	}

}
