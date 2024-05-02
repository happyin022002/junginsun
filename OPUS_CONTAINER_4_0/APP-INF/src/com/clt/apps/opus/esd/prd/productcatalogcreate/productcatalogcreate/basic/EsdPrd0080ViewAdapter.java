/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsdPrd0080ViewAdapter
 *@FileTitle :  
 *Open Issues :	
 *Change history :
 *@LastModifyDate : 2009. 9. 1.
 *@LastModifier : 
 *@LastVersion : 1.0
 *2009. 9. 1. 정선용
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.basic;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;

/**
 * IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author 박명신
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EsdPrd0080ViewAdapter extends ViewAdapter {

	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param colOrder String[] Column명 문자열
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception
	 */
	@SuppressWarnings("rawtypes")
	protected String makeDataTag(List vos, String prefix) {
		StringBuilder sbufXML = new StringBuilder();

		int totCnt = vos.size();
		int realCnt = vos.size();

		if (vos.get(0) instanceof AbstractValueObject) {
			AbstractValueObject vo = (AbstractValueObject) vos.get(0);
			String[] realColNms = getColHeader(vo);
			String[] changedColNms = getChangedColNms(realColNms, prefix);

			if (vo.getMaxRows() > 0) {
				totCnt = vo.getMaxRows();
			}

			sbufXML.append("<DATA COLORDER='" + JSPUtil.convertStringArrayToString(changedColNms, "|") + "' COLSEPARATOR='" + DELIMITER + "' TOTAL='" + totCnt + "'>\n");

			for (int i = 0; i < realCnt; i++) {
				Map<String, String> colValues = ((AbstractValueObject) vos.get(i)).getColumnValues();

				sbufXML.append("	<TR><![CDATA[");
				int colCnt = realColNms.length;

				for (int j = 0; j < colCnt - 1; j++) {
					sbufXML.append(getNull(colValues.get(realColNms[j])) + DELIMITER);
				}
				sbufXML.append(getNull(colValues.get(realColNms[colCnt - 1])) + "]]></TR>\n");
			}
			sbufXML.append("</DATA>\n");
		}

		return sbufXML.toString();
	}

	/**
	 * DBRowSet를 Parsing하여 <DATA>태그를 생성한다.<br>
	 * IBSheet의 prefix값이 있는 경우 COLORDER에 prefix를 붙인 column명으로 표시해 준다.<br>
	 * 
	 * @param rs DBRowSet VO객체
	 * @param prefix String IBSheet savename's prefix string
	 * @return String IBSheet <DATA>태그
	 * @exception
	 */
	protected String makeDataTag(DBRowSet rs, String prefix) {
		StringBuilder sb = new StringBuilder();
		if (rs.isPivot()) {
			sb.append(makePivotDataTag(rs));
			return sb.toString();
		}

		try {
			sb.append("<DATA>\n");
			while (rs.next()) {

				sb.append("<TR>");
				sb.append("<TD><![CDATA[]]></TD>");
				sb.append("<TD><![CDATA[" + JSPUtil.getNull(rs.getString("upd_ind_cd")) + "]]> </TD>");
				sb.append("<TD><![CDATA[" + JSPUtil.getNull(rs.getString("upd_ind_cd")) + "]]> </TD>");
				sb.append("<TD><![CDATA[" + JSPUtil.getNull(rs.getString("upd_ind_cd")) + "]]> </TD>");
				sb.append("<TD><![CDATA[]]></TD>");
				sb.append("<TD><![CDATA[" + JSPUtil.getNull(rs.getString("upd_ind_cd")) + "]]> </TD>");
				sb.append("<TD><![CDATA[" + JSPUtil.getNull(rs.getString("upd_ind_cd")) + "]]> </TD>");
			}
			sb.append("</DATA>\n");
		} catch (SQLException ex) {
			throw new RuntimeException(ex.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new RuntimeException(ex.getMessage());
		}

		return sb.toString();
	}

	/**
	 * Pivot Table용 Data tag를 생성한다.<br>
	 * 
	 * @param rs DBRowSet VO객체
	 * @return String IBSheet <DATA>태그
	 * @exception
	 */
	protected String makePivotDataTag(DBRowSet rs) {
		StringBuilder sb = new StringBuilder();
		int colCnt = 0;
		int rowCnt = rs.getRowCount();

		String[][] arrRowSet = null;

		try {
			colCnt = rs.getMetaData().getColumnCount();
			arrRowSet = new String[rowCnt][colCnt];

			int rowIdx = 0;
			while (rs.next()) {
				for (int j = 1; j <= colCnt; j++) {
					arrRowSet[rowIdx][j - 1] = getNull(rs.getObject(j)).toString();
				}
				rowIdx++;
			}
		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
			throw new RuntimeException(ex.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new RuntimeException(ex.getMessage());
		}

		try {
			sb.append("<DATA COLSEPARATOR='" + DELIMITER + "'>\n");
			if (rowCnt > 0) {
				for (int coIdx = 0; coIdx < colCnt; coIdx++) {
					sb.append("	<TR><![CDATA[");
					for (int roIdx = 0; roIdx < rowCnt - 1; roIdx++) {
						sb.append(arrRowSet[roIdx][coIdx] + DELIMITER);
					}
					sb.append(arrRowSet[rowCnt - 1][coIdx] + "]]></TR>\n");
				}
			}
			sb.append("</DATA>\n");
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new RuntimeException(ex.getMessage());
		}
		return sb.toString();
	}

}
