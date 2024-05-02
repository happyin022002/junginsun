/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CpsGem0016ViewAdapter.java
*@FileTitle : Default IBSheet Generation Class
*Open Issues :
*Change history :
*@LastModifyDate : 2009-06-05
*@LastModifier : 박창준
*@LastVersion : 1.0
* 2009-06-05 Park ChangJune
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event;
		
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Park ChangJune
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class CpsGem0016ViewAdapter extends ViewAdapter {

	
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
		String[] realColNms = {"~~", "slp_tj_no", "slp_seq_no", "ofc_cd", "gen_expn_cd", "abbr_nm", "tic_cd", "slp_curr_cd", "gl_eff_dt", "slp_amt", "gen_expn_fnl_locl_amt", "ratio", "slp_desc",
							   "~~", "slp_tj_no1", "slp_seq_no1", "sub_ofc_cd", "sub_gen_expn_cd", "sub_abbr_nm", "tic_cd1", "slp_curr_cd1", "gl_eff_dt1", "slp_amt1", "slp_perf_amt", "ratio1", "slp_desc1"};
		
		if(vo.getMaxRows()>0){
			totCnt = vo.getMaxRows();
		}

		sbufXML.append("<DATA " + "COLSEPARATOR='" + DELIMITER + "' TOTAL='" + totCnt +"'>\n");

		for(int i=0;i<realCnt;i++){
			Map<String, String> colValues = vos.get(i).getColumnValues();
			
			int colCnt = realColNms.length;

			sbufXML.append("<TR><![CDATA[");
			for (int j = 0 ; j < 13 ; j++) {
				
					sbufXML.append(JSPUtil.getNull(colValues.get(realColNms[j])) + DELIMITER);
				
			}
			sbufXML.append("]]></TR>\n");
			
			sbufXML.append("<TR><![CDATA[");
			for (int j = 13 ; j < colCnt ; j++) {
				
					sbufXML.append(JSPUtil.getNull(colValues.get(realColNms[j])) + DELIMITER);
				
			}
			sbufXML.append("]]></TR>\n");

			sbufXML.append("<TR HIDDEN=\"TRUE\"><![CDATA[");
			for (int j = 0; j < 13; j++) {
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
			throw new RuntimeException(ex.getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}
		return sb.toString();
	}

}
