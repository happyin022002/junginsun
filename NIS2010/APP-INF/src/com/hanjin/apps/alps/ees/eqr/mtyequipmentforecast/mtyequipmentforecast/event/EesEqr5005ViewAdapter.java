/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr5005ViewAdapter
*@FileTitle : 화면 조회속도를 개선시키기 위한  Adapter
*Open Issues :	
*Change history :
*@LastModifyDate : 2009. 12. 29.
*@LastModifier : 
*@LastVersion : 1.0
*2009. 8. 31. 김종준
* 1.0 Creation
* ======================================================
* 2011.06.13 나상보 [CHM-201111555-01] [EQR] R9 코드 생성에 따른 EQR 모듈 보완 작업 요청
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.event;

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
 * @author 김종준 
 * @see ViewAdapter 참조      
 * @since J2EE 1.5   
 */
public class EesEqr5005ViewAdapter extends ViewAdapter {
	private String color = "255,0,0";
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
		String[] realColNms=getColHeader(vo);
		
		if(vo.getMaxRows()>0){
			totCnt = vo.getMaxRows();
		}
		
		sbufXML.append("<DATA TOTAL='" + totCnt +"'>\n");

		for(int i=0;i<realCnt;i++){
			Map<String, String> colValues = vos.get(i).getColumnValues();
			int colCnt = realColNms.length;

			String view_flag = colValues.get("view_flag");
			if ( JSPUtil.getNull(view_flag).equals("FACTOR") ) {
				if (colValues.get("yrwk").equals("Total")) {
					if ( colValues.get("factor").equals("Evaluation") ) {
						sbufXML.append("<TR BGCOLOR='247,225,236'>\n");
					} else {
						sbufXML.append("<TR BGCOLOR='201, 213, 235'>\n");
					}
				} else {
					sbufXML.append("<TR>\n");
				}
			} else {
				if (colValues.get("o5_qty").equals("HIDDEN")) {	  //Accuracy Ranking 데이타 히든처리
					sbufXML.append("<TR HIDDEN=\"TRUE\">\n");
				} else {
					if (colValues.get("factor").equals("Diff.(%)")) {
						if ( colValues.get("yrwk").equals("Total") && colValues.get("loc_cd").equals("Total") ) {
							sbufXML.append("<TR BGCOLOR='247,225,236'>\n");
						} else {
							sbufXML.append("<TR BGCOLOR='201, 213, 235'>\n");
						}
					} else {
						sbufXML.append("<TR>\n");
					}					
				}
			}
				
			int tot_qty_color = colValues.get("tot_qty").indexOf("-");
			String tot_qty_fontcolor = "";
			if ( tot_qty_color != -1)  tot_qty_fontcolor = color; 
			
			int d2_qty_color = colValues.get("d2_qty").indexOf("-");
			String d2_qty_fontcolor = "";
			if ( d2_qty_color != -1)  d2_qty_fontcolor = color; 

			int d4_qty_color = colValues.get("d4_qty").indexOf("-");
			String d4_qty_fontcolor = "";
			if ( d4_qty_color != -1)  d4_qty_fontcolor = color; 

			int d5_qty_color = colValues.get("d5_qty").indexOf("-");
			String d5_qty_fontcolor = "";
			if ( d5_qty_color != -1)  d5_qty_fontcolor = color; 

			int d7_qty_color = colValues.get("d7_qty").indexOf("-");
			String d7_qty_fontcolor = "";
			if ( d7_qty_color != -1)  d7_qty_fontcolor = color; 

			int r2_qty_color = colValues.get("r2_qty").indexOf("-");
			String r2_qty_fontcolor = "";
			if ( r2_qty_color != -1)  r2_qty_fontcolor = color; 

			int r5_qty_color = colValues.get("r5_qty").indexOf("-");
			String r5_qty_fontcolor = "";
			if ( r5_qty_color != -1)  r5_qty_fontcolor = color; 
			
			int r9_qty_color = colValues.get("r9_qty").indexOf("-");
			String r9_qty_fontcolor = "";
			if ( r9_qty_color != -1)  r9_qty_fontcolor = color; 

			int o2_qty_color = colValues.get("o2_qty").indexOf("-");
			String o2_qty_fontcolor = "";
			if ( o2_qty_color != -1)  o2_qty_fontcolor = color; 

			int s2_qty_color = colValues.get("s2_qty").indexOf("-");
			String s2_qty_fontcolor = "";
			if ( s2_qty_color != -1)  s2_qty_fontcolor = color; 

			int o4_qty_color = colValues.get("o4_qty").indexOf("-");
			String o4_qty_fontcolor = "";
			if ( o4_qty_color != -1)  o4_qty_fontcolor = color; 

			int s4_qty_color = colValues.get("s4_qty").indexOf("-");
			String s4_qty_fontcolor = "";
			if ( s4_qty_color != -1)  s4_qty_fontcolor = color; 

			int f2_qty_color = colValues.get("f2_qty").indexOf("-");
			String f2_qty_fontcolor = "";
			if ( f2_qty_color != -1)  f2_qty_fontcolor = color; 

			int a2_qty_color = colValues.get("a2_qty").indexOf("-");
			String a2_qty_fontcolor = "";
			if ( a2_qty_color != -1)  a2_qty_fontcolor = color; 

			int f4_qty_color = colValues.get("f4_qty").indexOf("-");
			String f4_qty_fontcolor = "";
			if ( f4_qty_color != -1)  f4_qty_fontcolor = color; 

			int a4_qty_color = colValues.get("a4_qty").indexOf("-");
			String a4_qty_fontcolor = "";
			if ( a4_qty_color != -1)  a4_qty_fontcolor = color; 

			int f5_qty_color = colValues.get("f5_qty").indexOf("-");
			String f5_qty_fontcolor = "";
			if ( f5_qty_color != -1)  f5_qty_fontcolor = color; 
			
			int o5_qty_color = colValues.get("o5_qty").indexOf("-");
			String o5_qty_fontcolor = "";
			if ( o5_qty_color != -1)  o5_qty_fontcolor = color; 

			if ( !JSPUtil.getNull(view_flag).equals("FACTOR") ) {
				sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("bound"))	+"]]></TD>\n");
				sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("yrwk"))	+"]]></TD>\n");
				sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("loc_cd"))	+"]]></TD>\n");
				sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("eval"))	+"]]></TD>\n");
				sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("factor"))	+"]]></TD>\n");
			} else {
				sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("bound"))	+"]]></TD>\n");
				sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("loc_cd"))	+"]]></TD>\n");
				sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("factor"))	+"]]></TD>\n");
				sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("yrwk"))	+"]]></TD>\n");
				
			}
			sbufXML.append("<TD FontColor='"+tot_qty_fontcolor+"'><![CDATA["+JSPUtil.getNull(colValues.get("tot_qty"  		))+"]]></TD>\n");
			sbufXML.append("<TD FontColor='"+d2_qty_fontcolor+"'><![CDATA["+JSPUtil.getNull(colValues.get("d2_qty"   		))+"]]></TD>\n");
			sbufXML.append("<TD FontColor='"+d4_qty_fontcolor+"'><![CDATA["+JSPUtil.getNull(colValues.get("d4_qty"   		))+"]]></TD>\n");
			sbufXML.append("<TD FontColor='"+d5_qty_fontcolor+"'><![CDATA["+JSPUtil.getNull(colValues.get("d5_qty"   		))+"]]></TD>\n");
			sbufXML.append("<TD FontColor='"+d7_qty_fontcolor+"'><![CDATA["+JSPUtil.getNull(colValues.get("d7_qty"   		))+"]]></TD>\n");
			sbufXML.append("<TD FontColor='"+r2_qty_fontcolor+"'><![CDATA["+JSPUtil.getNull(colValues.get("r2_qty"   		))+"]]></TD>\n");
			sbufXML.append("<TD FontColor='"+r5_qty_fontcolor+"'><![CDATA["+JSPUtil.getNull(colValues.get("r5_qty"   		))+"]]></TD>\n");
			sbufXML.append("<TD FontColor='"+r9_qty_fontcolor+"'><![CDATA["+JSPUtil.getNull(colValues.get("r9_qty"   		))+"]]></TD>\n");
			sbufXML.append("<TD FontColor='"+o2_qty_fontcolor+"'><![CDATA["+JSPUtil.getNull(colValues.get("o2_qty"   		))+"]]></TD>\n");
			sbufXML.append("<TD FontColor='"+o4_qty_fontcolor+"'><![CDATA["+JSPUtil.getNull(colValues.get("o4_qty"   		))+"]]></TD>\n");
			sbufXML.append("<TD FontColor='"+o5_qty_fontcolor+"'><![CDATA["+JSPUtil.getNull(colValues.get("o5_qty"   		))+"]]></TD>\n");
			sbufXML.append("<TD FontColor='"+s2_qty_fontcolor+"'><![CDATA["+JSPUtil.getNull(colValues.get("s2_qty"   		))+"]]></TD>\n");
			sbufXML.append("<TD FontColor='"+s4_qty_fontcolor+"'><![CDATA["+JSPUtil.getNull(colValues.get("s4_qty"   		))+"]]></TD>\n");
			sbufXML.append("<TD FontColor='"+f2_qty_fontcolor+"'><![CDATA["+JSPUtil.getNull(colValues.get("f2_qty"   		))+"]]></TD>\n");
			sbufXML.append("<TD FontColor='"+f4_qty_fontcolor+"'><![CDATA["+JSPUtil.getNull(colValues.get("f4_qty"   		))+"]]></TD>\n");
			sbufXML.append("<TD FontColor='"+f5_qty_fontcolor+"'><![CDATA["+JSPUtil.getNull(colValues.get("f5_qty"   		))+"]]></TD>\n");
			sbufXML.append("<TD FontColor='"+a2_qty_fontcolor+"'><![CDATA["+JSPUtil.getNull(colValues.get("a2_qty"   		))+"]]></TD>\n");
			sbufXML.append("<TD FontColor='"+a4_qty_fontcolor+"'><![CDATA["+JSPUtil.getNull(colValues.get("a4_qty"   		))+"]]></TD>\n");
			
			if ( JSPUtil.getNull(view_flag).equals("FACTOR") ) {
				sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("dp_seq"   		))+"]]></TD>\n");
			}

			sbufXML.append(JSPUtil.getNull(colValues.get(realColNms[colCnt-1])) + "</TR>\n");
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
				sb.append(" <TR EXPAND=\"FALSE\"><![CDATA[");
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
					sb.append(" <TR EXPAND=\"FALSE\"><![CDATA[");
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
