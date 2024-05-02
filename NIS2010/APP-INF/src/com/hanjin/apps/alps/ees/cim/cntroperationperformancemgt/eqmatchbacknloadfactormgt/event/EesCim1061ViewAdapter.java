/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EesCim1061ViewAdapter.java
*@FileTitle : Location M/B by COA BKG
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.17
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2011.03.17 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
	
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;

/**
 * IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author 박명신
 * @see ViewAdapter 참조      
 * @since J2EE 1.5   
 */
public class EesCim1061ViewAdapter extends ViewAdapter {

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
		
		sbufXML.append("<DATA>\n");
		
		int realCnt = vos.size();
		
		String[] arrHeaderList = null;
		
		if(realCnt > 0){
			Map<String, String> tmpColValues = vos.get(0).getColumnValues();
			String headerList = tmpColValues.get("div");			
			arrHeaderList = headerList.split(",");	
		}	
			
		for(int i=1;i<realCnt;i++){		
			Map<String, String> colValues = vos.get(i).getColumnValues();
			
			//배경컬러  total은 핑크 Ratio 는 푸른색
			String bgColor = "";	
			
			String locCd = colValues.get("loc_cd");
			if(colValues.get("loc_cd") == null || colValues.get("loc_cd").equals("")){
				locCd = "G.Total"; 
				bgColor = " BGCOLOR=\"247,225,236\"";
				sbufXML.append("<TR HIDDEN=\"TRUE\">"); 
			} else {
				sbufXML.append("<TR>");
			}
			
			sbufXML.append("<TD><![CDATA[]]></TD>");	
			sbufXML.append("<TD").append(bgColor).append("><![CDATA[").append(locCd).append("]]></TD>");
			
			String divCd = colValues.get("div");
			if(divCd.equalsIgnoreCase("M/B Ratio(%)")){
				if(bgColor.equals("")){	
					bgColor = " BGCOLOR=\"240,255,255\"";
				}				
			}	 
			sbufXML.append("<TD").append(bgColor).append("><![CDATA[").append(JSPUtil.getNull(colValues.get("div")));sbufXML.append("]]></TD>");
			
			if(arrHeaderList != null){
				for (int j = 0; j < arrHeaderList.length; j++) {	
					String originValue = colValues.get(arrHeaderList[j]);
					if(originValue == null){	
						originValue = "0";
					}
						
					String formatValue = "";	
					//숫자 포멧 변환
					if(divCd.equalsIgnoreCase("M/B Ratio(%)")){
						formatValue = JSPUtil.toDecimalFormat(Double.parseDouble(originValue), ",###.#");
						formatValue = formatValue + "%";
					} else {
						formatValue = JSPUtil.toDecimalFormat(Double.parseDouble(originValue), ",###");
					}	
					
					//Ratio 와 Balance 는 추가 요건	   
					//1. -일때 빨간색표시 , + 일때  "+" 문자열 표시 및 파란색으로 표시
					if(divCd.equalsIgnoreCase("M/B Ratio(%)") || divCd.equalsIgnoreCase("Balance")){
						if(Double.parseDouble(originValue) < 0){	
							sbufXML.append("<TD").append(bgColor).append(" COLOR=\"RED\"><![CDATA[");sbufXML.append(formatValue);sbufXML.append("]]></TD>");
						} else {	 
							if(Double.parseDouble(originValue) != 0){
								formatValue = "+" + formatValue;			 	
							}		
							sbufXML.append("<TD").append(bgColor).append(" COLOR=\"BLUE\"><![CDATA[");sbufXML.append(formatValue);sbufXML.append("]]></TD>");
						}				
					} else {		
						sbufXML.append("<TD").append(bgColor).append("><![CDATA[").append(formatValue);sbufXML.append("]]></TD>");
					}			
				}	
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
		}catch(SQLException ex){  
			throw new RuntimeException(ex.getMessage());
		}catch(Exception e){  
			throw new RuntimeException(e.getMessage());  
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
		}catch(SQLException ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}catch(Exception e){  
			throw new RuntimeException(e.getMessage());  
		}        
		
		try{
			sb.append("<DATA COLSEPARATOR='" + DELIMITER + "'>\n");
			if(rowCnt>0){ 
				for (int coIdx = 0 ;coIdx < colCnt ; coIdx++) {
					sb.append(" <TR><![CDATA[");
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
