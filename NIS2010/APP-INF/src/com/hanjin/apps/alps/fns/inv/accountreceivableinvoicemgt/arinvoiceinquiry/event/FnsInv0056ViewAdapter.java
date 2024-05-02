/*=========================================================
 *Copyright(c) 2008 CyberLogitec
 *@FileName : FnsInv0056ViewAdapter.java
 *@FileTitle : Default IBSheet Generation Class
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.21
 *@LastModifier : 박정진
 *@LastVersion : 1.0
 * 2009.05.21 박정진
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event;

import java.sql.SQLException;
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
 * @author 박정진
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class FnsInv0056ViewAdapter extends ViewAdapter {

	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos
	 *            List<AbstractValueObject> List 객체
	 * @param colOrder
	 *            String[] Column명 문자열
	 * @param prefix
	 *            String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception
	 */
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		StringBuilder sbufXML = new StringBuilder();

		int totCnt = vos.size();
		int realCnt = vos.size();

		AbstractValueObject vo = (AbstractValueObject) vos.get(0);
		String[] realColNms = {"", "ar_ofc_cd", "io_bnd_cd", "", "not_arrived_cnt", "not_arrived_amt", "", "below_day1_cnt", "below_day1_amt", "below_day4_cnt", "below_day4_amt", "cr_clt_ofc_cd", "cr_amt", "ib_cr_term_dys", "ob_cr_term_dys","dp_prcs_knt","day1","day2","day3","day4","day5",
				"", "ar_ofc_cd", "io_bnd_cd", "ttl_amt", "wi_term_cnt", "wi_term_amt", "ttl_lt_amt", "below_day2_cnt", "below_day2_amt", "below_day5_cnt", "below_day5_amt", "", "", "", "", "", "", "", "", "", "",
				"", "ar_ofc_cd", "io_bnd_cd", "ttl_cnt", "ttl_wi_term_cnt", "ttl_wi_term_amt", "lt_cnt", "below_day3_cnt", "below_day3_amt", "over_day5_cnt", "over_day5_amt", "", "", "", "", "", "", "", "", "", ""
		};

		if (vo.getMaxRows() > 0) {
			totCnt = vo.getMaxRows();
		}

		sbufXML.append("<DATA COLSEPARATOR='" + DELIMITER + "' TOTAL='" + totCnt + "'>\n");

		for (int i = 0; i < realCnt; i++) {
			Map<String, String> colValues = vos.get(i).getColumnValues();

			sbufXML.append("	<TR><![CDATA[");
			int colCnt = realColNms.length;

			for (int j = 0; j < 21; j++) {
				sbufXML.append(JSPUtil.getNull(colValues.get(realColNms[j])) + DELIMITER);
			}
			sbufXML.append(JSPUtil.getNull(colValues.get(realColNms[colCnt - 1])) + "]]></TR>\n");

			sbufXML.append("	<TR><![CDATA[");

			for (int j = 21; j < 42; j++) {
				sbufXML.append(JSPUtil.getNull(colValues.get(realColNms[j])) + DELIMITER);
			}
			sbufXML.append(JSPUtil.getNull(colValues.get(realColNms[colCnt - 1])) + "]]></TR>\n");
			
			sbufXML.append("	<TR><![CDATA[");

			for (int j = 42; j < colCnt - 1; j++) {
				sbufXML.append(JSPUtil.getNull(colValues.get(realColNms[j])) + DELIMITER);
			}
			sbufXML.append(JSPUtil.getNull(colValues.get(realColNms[colCnt - 1])) + "]]></TR>\n");

		}
		sbufXML.append("</DATA>\n");

		return sbufXML.toString();
	}

	/**
	 * DBRowSet를 Parsing하여 <DATA>태그를 생성한다.<br>
	 * IBSheet의 prefix값이 있는 경우 COLORDER에 prefix를 붙인 column명으로 표시해 준다.<br>
	 * 
	 * @param rs
	 *            DBRowSet VO객체
	 * @param prefix
	 *            String IBSheet savename's prefix string
	 * @return String IBSheet <DATA>태그
	 * @exception
	 */
	protected String makeDataTag(DBRowSet rs, String prefix) {
		StringBuilder sb = new StringBuilder();

		// Pivot Table인 경우 makePivotDataTag 실행하여 return한
		if (rs.isPivot()) {
			sb.append(makePivotDataTag(rs));
			return sb.toString();
		}

		String[] realColNms = getColHeader(rs);
		try {
			String[] changedColNms = getChangedColNms(realColNms, prefix);

			sb.append("<DATA COLORDER='" + JSPUtil.convertStringArrayToString(changedColNms, "☜☞") 
					+ "' COLSEPARATOR='" + DELIMITER + "' TOTAL='"
					+ getRowSetCnt(rs) + "'>\n");

			int colCount = realColNms.length;

			while (rs.next()) {
				sb.append("	<TR><![CDATA[");
				for (int j = 1; j < colCount; j++) {
					sb.append(JSPUtil.getNull(rs.getObject(j)) + DELIMITER);
				}
				sb.append(JSPUtil.getNull(rs.getObject(colCount)) + "]]></TR>\n");

			}
			sb.append("</DATA>\n");
		} catch (SQLException ex) {
			throw new RuntimeException(ex.getMessage());
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			return null;
		}
		return sb.toString();
	}

	/**
	 * Pivot Table용 Data tag를 생성한다.<br>
	 * 
	 * @param rs
	 *            DBRowSet VO객체
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
					arrRowSet[rowIdx][j - 1] = JSPUtil.getNull(rs.getObject(j)).toString();
				}
				rowIdx++;
			}
		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
			throw new RuntimeException(ex.getMessage());
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			return null;
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
				}// end for coIdx
			}// end for roIdx
			sb.append("</DATA>\n");
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new RuntimeException(ex.getMessage());
		}
		return sb.toString();
	}
}
