/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EesCim1062ViewAdapter.java
*@FileTitle : Location 팝업
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
import java.util.HashMap;
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
public class EesCim1062ViewAdapter extends ViewAdapter {

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
		
		HashMap<String, String> treeFlag = new HashMap<String, String>();
		String treeExpand = "FALSE";
		for(int i=(realCnt - 1) ;i >= 0;i--){		
			Map<String, String> colValues = vos.get(i).getColumnValues();
			if(colValues.get("ecc_lvl").equals("0")){
				String rcc = colValues.get("rcc_cd");		
				treeFlag.put(rcc, treeExpand);	
				treeExpand = "FALSE";						
			} else {	
				String useFlag = colValues.get("use_flg");
				if(useFlag.equals("Y")){								
					treeExpand = "TRUE";					
				}				
			}					
		}					
		
		for(int i=0;i<realCnt;i++){			
			Map<String, String> colValues = vos.get(i).getColumnValues();
			
			sbufXML.append("<TR LEVEL=\"").append(colValues.get("ecc_lvl")).append("\" EXPAND=\"").append(treeFlag.get(colValues.get("rcc_cd"))).append("\">");
			sbufXML.append("<TD><![CDATA[]]></TD>");
			sbufXML.append("<TD><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("use_flg")));sbufXML.append("]]></TD>");
			sbufXML.append("<TD><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("rcc_cd")));sbufXML.append("]]></TD>");
			sbufXML.append("<TD><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("ecc_cd")));sbufXML.append("]]></TD>");
			sbufXML.append("<TD><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("ecc_lvl")));sbufXML.append("]]></TD>");
			sbufXML.append("<TD><![CDATA[");sbufXML.append(JSPUtil.getNull(colValues.get("usr_id")));sbufXML.append("]]></TD>");
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
