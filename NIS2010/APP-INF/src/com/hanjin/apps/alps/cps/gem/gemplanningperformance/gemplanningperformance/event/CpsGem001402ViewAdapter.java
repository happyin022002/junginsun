/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CpsGem001402ViewAdapter.java
*@FileTitle : Default IBSheet Generation Class
*Open Issues :
*Change history :
*@LastModifyDate : 2009-06-26
*@LastModifier : 박창준
*@LastVersion : 1.0
* 2009-06-26 Park ChangJune
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.event;
		
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
 * @author Park ChangJune
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class CpsGem001402ViewAdapter extends ViewAdapter {

	
	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param colOrder String[] Column명 문자열 
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception 
	 */	
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		StringBuilder sbufXML = new StringBuilder();
		
		int totCnt = vos.size();
		int realCnt = vos.size();

		AbstractValueObject vo = (AbstractValueObject)vos.get(0);
		//String[] realColNms=getColHeader(vo);
		String[] realColNms = {"~~", "gen_expn_rqst_no", "field_one", "fm_ofc_cd", "field_two", "fm_gen_expn_cd", "field_tree", "to_ofc_cd", "field_four", "to_gen_expn_cd",
							   "~~", "gen_expn_rqst_no1", "field_one1", "fm_locl_curr_cd", "field_two1", "fm_rqst_ut_val", "field_tree1", "to_locl_curr_cd", "field_four1", "to_rqst_ut_val", 
							   "~~", "gen_expn_rqst_no2", "field_one2", "fm_rq_amt", "field_two2", "fm_rq_amt1", "field_tree2", "to_rq_amt", "field_four2", "to_rq_amt1",
							   "~~", "gen_expn_rqst_no3", "field_one3", "fm_gen_expn_itm_no", "field_two3", "fm_gen_expn_itm_no1", "field_tree3", "to_gen_expn_itm_no", "field_four3", "to_gen_expn_itm_no1",
							   "~~", "gen_expn_rqst_no4", "field_one4", "fm_gen_expn_itm_desc", "field_two4", "fm_gen_expn_itm_desc1", "field_tree4", "to_gen_expn_itm_desc", "field_four4", "to_gen_expn_itm_desc1"};
		
		if(vo.getMaxRows()>0){
			totCnt = vo.getMaxRows();
		}

		sbufXML.append("<DATA " + "COLSEPARATOR='" + DELIMITER + "' TOTAL='" + totCnt +"'>\n");

		for(int i=0;i<realCnt;i++){
			Map<String, String> colValues = vos.get(i).getColumnValues();
			
			int colCnt = realColNms.length;

			sbufXML.append("<TR><![CDATA[");
			for (int j = 0 ; j < 10 ; j++) {
				sbufXML.append(JSPUtil.getNull(colValues.get(realColNms[j])) + DELIMITER);
			}
			sbufXML.append("]]></TR>\n");
			
			sbufXML.append("<TR><![CDATA[");
			for (int j = 10 ; j < colCnt ; j++) {
				sbufXML.append(JSPUtil.getNull(colValues.get(realColNms[j])) + DELIMITER);
			}
			sbufXML.append("]]></TR>\n");
			
			//셀머지 위해 공백값 Trim 처리 제외
			sbufXML.append("<TR><![CDATA[");
			for (int j = 20; j < colCnt; j++) {
				sbufXML.append(colValues.get(realColNms[j]) + DELIMITER);
			}
			sbufXML.append("]]></TR>\n");
			
			//셀머지 위해 공백값 Trim 처리 제외
			sbufXML.append("<TR><![CDATA[");
			for (int j = 30; j < colCnt; j++) {
				sbufXML.append(colValues.get(realColNms[j]) + DELIMITER);
			}
			sbufXML.append("]]></TR>\n");
			
			//셀머지 위해 공백값 Trim 처리 제외
			sbufXML.append("<TR><![CDATA[");
			for (int j = 40; j < colCnt; j++) {
				sbufXML.append(colValues.get(realColNms[j]) + DELIMITER);
			}
			sbufXML.append("]]></TR>\n");
			
			sbufXML.append("<TR HIDDEN=\"TRUE\"><![CDATA[");
			for (int j = 0; j < 10; j++) {
				sbufXML.append(DELIMITER);
			}
			sbufXML.append("]]></TR>\n");

		}
		
		sbufXML.append("</DATA>\n");
		
		return sbufXML.toString();
	}

	/**
	 * DBRowSet를 Parsing하여 <DATA>태그를 생성한다.<br>
	 * IBSheet의 prefix값이 있는 경우 COLORDER에 prefix를 붙인 column명으로 표시해 준다.<br>
	 * 
	 * @param rs DBRowSet 		VO객체
	 * @param prefix String 		IBSheet savename's prefix string
	 * @return String IBSheet 		<DATA>태그
	 * @exception 
	 */
	protected String makeDataTag(DBRowSet rs,String prefix) {
		StringBuilder sb = new StringBuilder();
		
		//Pivot Table인 경우 makePivotDataTag 실행하여  return한
		if(rs.isPivot()){
			sb.append(makePivotDataTag(rs));
			return sb.toString();
		}

		String[] realColNms = getColHeader(rs);

		try{
			String[] changedColNms = getChangedColNms(realColNms, prefix);
			
			sb.append("<DATA COLORDER='" + JSPUtil.convertStringArrayToString(changedColNms, "|") + "' COLSEPARATOR='" + DELIMITER + "' TOTAL='" + getRowSetCnt(rs) + "'>\n");
			
			int colCount = realColNms.length;
			
			while (rs.next()) { 
				sb.append("	<TR><![CDATA[");
				for (int j = 1 ; j < colCount ; j++) {
					sb.append(JSPUtil.getNull(rs.getObject(j)) + DELIMITER);
				}	
				sb.append(JSPUtil.getNull(rs.getObject(colCount))  + "]]></TR>\n");
			}
			sb.append("</DATA>\n");
		}catch(SQLException ex){
			throw new RuntimeException(ex.getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}
		return sb.toString();
	}

	/**
	 * Pivot Table용 Data tag를 생성한다.<br>
	 * 
	 * @param rs			DBRowSet 		VO객체
	 * @return String 	IBSheet 			<DATA>태그
	 * @exception 
	 */
	protected String makePivotDataTag(DBRowSet rs) {
		StringBuilder sb = new StringBuilder();
		int colCnt = 0;
		int rowCnt = rs.getRowCount();
		
		String[][] arrRowSet = null;

		try{
			colCnt = rs.getMetaData().getColumnCount();
			arrRowSet = new String[rowCnt][colCnt];
			
			int rowIdx = 0;
			while (rs.next()) { 
				for (int j = 1 ; j <= colCnt ; j++) {
					arrRowSet[rowIdx][j-1] = JSPUtil.getNull(rs.getObject(j)).toString();
				}
				rowIdx++;
			}
		
	
			sb.append("<DATA COLSEPARATOR='" + DELIMITER + "'>\n");
			if(rowCnt>0){
				for (int coIdx = 0 ;coIdx < colCnt ; coIdx++) {
					sb.append("	<TR><![CDATA[");
					for(int roIdx=0;roIdx < rowCnt-1; roIdx++){
						sb.append(arrRowSet[roIdx][coIdx] + DELIMITER);
					}
					sb.append(arrRowSet[rowCnt-1][coIdx]  + "]]></TR>\n");
				}//end for coIdx
			}//end for roIdx
			sb.append("</DATA>\n");
			
		}catch(SQLException ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		

		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}
		return sb.toString();
	}

}
