/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr1102ViewAdapter.java
*@FileTitle : Default IBSheet Generation Class
*Open Issues :
*Change history :
*@LastModifyDate : 2016-01-19
*@LastModifier : PARK JEONG MIN
*@LastVersion : 1.0
* 2016-01-19 PARK JEONG MIN
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastsummary.event;

import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.controller.ViewAdapter;
import java.util.List;
import java.util.Map;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author PARK JEONG MIN
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EesEqr1102ViewAdapter extends DefaultViewAdapter {
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
		
        String realColNms[] = getColHeader(vo);


		if(vo.getMaxRows()>0){
			totCnt = vo.getMaxRows();
		}

		sbufXML.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(realColNms, "|")).append("' TOTAL='").append(totCnt).append("'>\n").toString());
		String colName =  "";
		
		for(int i=0;i<realCnt;i++){
			Map<String, String> colValues = vos.get(i).getColumnValues();
			
			int colCnt = realColNms.length;
			
			int ivw0 = Integer.parseInt(JSPUtil.getNull(colValues.get("iv_w0"), "0"));
			int ivw1 = Integer.parseInt(JSPUtil.getNull(colValues.get("iv_w1"), "0"));
			int ivw2 = Integer.parseInt(JSPUtil.getNull(colValues.get("iv_w2"), "0"));
			int ivw3 = Integer.parseInt(JSPUtil.getNull(colValues.get("iv_w3"), "0"));
			int ivAvg = Integer.parseInt(JSPUtil.getNull(colValues.get("iv_avg"), "0"));
			
			int optVol = Integer.parseInt(JSPUtil.getNull(colValues.get("opt_vol"), "0"));

			int opw0 = Integer.parseInt(JSPUtil.getNull(colValues.get("op_w0"), "0"));
			int opw1 = Integer.parseInt(JSPUtil.getNull(colValues.get("op_w1"), "0"));
			int opw2 = Integer.parseInt(JSPUtil.getNull(colValues.get("op_w2"), "0"));
			int opw3 = Integer.parseInt(JSPUtil.getNull(colValues.get("op_w3"), "0"));
			//Double opAvg = Double.parseDouble(JSPUtil.getNull(colValues.get("op_avg"), "0.0"));
			int opAvg = Integer.parseInt(JSPUtil.getNull(colValues.get("op_avg"), "0"));

			Double prw0 = Double.parseDouble(JSPUtil.getNull(colValues.get("pr_w0"), "0.0"));
			Double prw1 = Double.parseDouble(JSPUtil.getNull(colValues.get("pr_w1"), "0.0"));
			Double prw2 = Double.parseDouble(JSPUtil.getNull(colValues.get("pr_w2"), "0.0"));
			Double prw3 = Double.parseDouble(JSPUtil.getNull(colValues.get("pr_w3"), "0.0"));
			Double prAvg = Double.parseDouble(JSPUtil.getNull(colValues.get("pr_avg"), "0.0"));
			
			int mbValue = Integer.parseInt(JSPUtil.getNull(colValues.get("mb_value"), "0"));
			
			sbufXML.append("<TR>");
			for (int j = 0 ; j < colCnt ; j++) {
				colName =  (String)realColNms[j];
				
				
				if(ivw0 < 0 && "iv_w0".equals(colName)) {
					sbufXML.append("<TD COLOR='RED'><![CDATA[");
				} else if(ivw1 < 0 && "iv_w1".equals(colName)) {
					sbufXML.append("<TD COLOR='RED'><![CDATA[");
				} else if(ivw2 < 0 && "iv_w2".equals(colName)) {
					sbufXML.append("<TD COLOR='RED'><![CDATA[");
				} else if(ivw3 < 0 && "iv_w3".equals(colName)) {
					sbufXML.append("<TD COLOR='RED'><![CDATA[");
				} else if(ivAvg < 0 && "iv_avg".equals(colName)) {
					sbufXML.append("<TD COLOR='RED'><![CDATA[");
				} else if(optVol < 0 && "opt_vol".equals(colName)) {
					sbufXML.append("<TD COLOR='RED'><![CDATA[");
				} else if(opw0 < 0 && "op_w0".equals(colName)) {
					sbufXML.append("<TD COLOR='RED'><![CDATA[");
				} else if(opw1 < 0 && "op_w1".equals(colName)) {
					sbufXML.append("<TD COLOR='RED'><![CDATA[");
				} else if(opw2 < 0 && "op_w2".equals(colName)) {
					sbufXML.append("<TD COLOR='RED'><![CDATA[");
				} else if(opw3 < 0 && "op_w3".equals(colName)) {
					sbufXML.append("<TD COLOR='RED'><![CDATA[");
				} else if(opAvg < 0 && "op_avg".equals(colName)) {
					sbufXML.append("<TD COLOR='RED'><![CDATA[");
				} else if(prw0 < 0 && "pr_w0".equals(colName)) {
					sbufXML.append("<TD COLOR='RED'><![CDATA[");
				} else if(prw1 < 0 && "pr_w1".equals(colName)) {
					sbufXML.append("<TD COLOR='RED'><![CDATA[");
				} else if(prw2 < 0 && "pr_w2".equals(colName)) {
					sbufXML.append("<TD COLOR='RED'><![CDATA[");
				} else if(prw3 < 0 && "pr_w3".equals(colName)) {
					sbufXML.append("<TD COLOR='RED'><![CDATA[");
				} else if(prAvg < 0 && "pr_avg".equals(colName)) {
					sbufXML.append("<TD COLOR='RED'><![CDATA[");
				} else if(mbValue < 0 && "mb_value".equals(colName)) {
					sbufXML.append("<TD COLOR='RED'><![CDATA[");					
				} else {
					sbufXML.append("<TD><![CDATA[");
				}
				
				sbufXML.append(JSPUtil.getNull(colValues.get(realColNms[j])) );
				sbufXML.append("]]></TD>");
			}
			sbufXML.append("</TR>\n");
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
		}catch(Exception ex){
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
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}
		
		try{
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
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}
		return sb.toString();
	}
}
