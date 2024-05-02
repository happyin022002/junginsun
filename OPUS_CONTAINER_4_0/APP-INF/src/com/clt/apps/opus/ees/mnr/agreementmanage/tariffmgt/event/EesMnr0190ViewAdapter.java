/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HiddenViewAdapter
*@FileTitle : 데이터의 상태에 따라  BackColor 와 Edit 를 설정한다.
*Open Issues :	
*Change history :
*@LastModifyDate : 2009. 7. 1.
*@LastModifier : 
*@LastVersion : 1.0
*2009. 7. 1. 김완규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.event;

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
public class EesMnr0190ViewAdapter extends ViewAdapter {

	
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
		for(int i=0;i<realCnt;i++){
			Map<String, String> colValues = vos.get(i).getColumnValues();
			
			String rowMsg = colValues.get("inp_msg4");
			String volumeType = colValues.get("inp_msg11");
			
			if(rowMsg.equals("SS")) {
				sbufXML.append("<TR BGCOLOR=\"240,255,255\">");
				sbufXML.append("  <TD><![CDATA[]]></TD>");
				sbufXML.append("  <TD><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("checkbox")));sbufXML.append("]]></TD>");
			
				sbufXML.append("<TD><![CDATA[ ]]></TD>");
				sbufXML.append("<TD><![CDATA["+ i +"]]></TD>");
				sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg17")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg1")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg2")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg6")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg7")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg10")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg11")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg12")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg13")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg8")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg9")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg14")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg15")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg19")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg23")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg16")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg5")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg4")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg18")));sbufXML.append("]]></TD>");
			
			} else {
				sbufXML.append("<TR BGCOLOR=\"247,229,255\">");
				sbufXML.append("  <TD><![CDATA[ ]]></TD>");
				sbufXML.append("  <TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("checkbox")));sbufXML.append("]]></TD>");

				sbufXML.append("<TD><![CDATA[ ]]></TD>");
				sbufXML.append("<TD><![CDATA["+ i +"]]></TD>");
				sbufXML.append("<TD EDIT=\"TRUE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg17")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"TRUE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg1")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"TRUE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg2")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"TRUE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg6")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"TRUE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg7")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"TRUE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg10")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"TRUE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg11")));sbufXML.append("]]></TD>");
				
				if(volumeType.equals("Q")) {
					sbufXML.append("<TD EDIT=\"TRUE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg12")));sbufXML.append("]]></TD>");
					sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg13")));sbufXML.append("]]></TD>");
				} else {
					sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg12")));sbufXML.append("]]></TD>");
					sbufXML.append("<TD EDIT=\"TRUE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg13")));sbufXML.append("]]></TD>");
				}
				sbufXML.append("<TD EDIT=\"TRUE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg8")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"TRUE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg9")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"TRUE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg14")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"TRUE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg15")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"TRUE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg19")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg23")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"TRUE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg16")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"TRUE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg5")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"TRUE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg4")));sbufXML.append("]]></TD>");
				sbufXML.append("<TD EDIT=\"TRUE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg18")));sbufXML.append("]]></TD>");
			
			}
			sbufXML.append("<TD EDIT=\"TRUE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg20")));sbufXML.append("]]></TD>");
			sbufXML.append("<TD EDIT=\"TRUE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg21")));sbufXML.append("]]></TD>");
			sbufXML.append("<TD EDIT=\"TRUE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg22")));sbufXML.append("]]></TD>");
			sbufXML.append("<TD EDIT=\"TRUE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg24")));sbufXML.append("]]></TD>");
			sbufXML.append("<TD EDIT=\"TRUE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg25")));sbufXML.append("]]></TD>");
			sbufXML.append("<TD EDIT=\"TRUE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg26")));sbufXML.append("]]></TD>");
			sbufXML.append("<TD EDIT=\"TRUE\"><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("inp_msg27")));sbufXML.append("]]></TD>");

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
