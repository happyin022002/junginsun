/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_0031ViewAdapter
*@FileTitle : 화면 조회속도를 개선시키기 위한  Adapter
*Open Issues :	
*Change history :
*@LastModifyDate : 2009. 8. 31.
*@LastModifier : 
*@LastVersion : 1.0
*2009. 8. 31. 김종준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.event;

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
public class EesCim0031ViewAdapter extends ViewAdapter {

	
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
		//String[] changedColNms = getChangedColNms(realColNms, prefix);
		
		if(vo.getMaxRows()>0){
			totCnt = vo.getMaxRows();
		}
		
		sbufXML.append("<DATA TOTAL='" + totCnt +"'>\n");

		for(int i=0;i<realCnt;i++){
			Map<String, String> colValues = vos.get(i).getColumnValues();
			String lvl = colValues.get("lvl");
			if ( lvl.equals("01") ) {
				sbufXML.append("<TR BGCOLOR='201, 213, 235'>\n");
			} else {
				sbufXML.append("<TR >\n");
			}
			int colCnt = realColNms.length;
			
			sbufXML.append("<TD EDIT='FALSE'><![CDATA["+JSPUtil.getNull(colValues.get("loc_cd"))+"]]></TD>\n");
			sbufXML.append("<TD EDIT='FALSE'><![CDATA["+JSPUtil.getNull(colValues.get("cntr_tpsz_cd"))+"]]></TD>\n");
			sbufXML.append("<TD EDIT='FALSE'><![CDATA["+JSPUtil.getNull(colValues.get("aval_qty"))+"]]></TD>\n");
			sbufXML.append("<TD EDIT='FALSE'><![CDATA["+JSPUtil.getNull(colValues.get("snd_qty"))+"]]></TD>\n");
			sbufXML.append("<TD EDIT='FALSE'><![CDATA["+JSPUtil.getNull(colValues.get("dmg_qty"))+"]]></TD>\n");
			sbufXML.append("<TD EDIT='FALSE'><![CDATA["+JSPUtil.getNull(colValues.get("tot_qty"))+"]]></TD>\n");
			sbufXML.append("<TD EDIT='FALSE'><![CDATA["+JSPUtil.getNull(colValues.get("due_out_qty"))+"]]></TD>\n");
			sbufXML.append("<TD EDIT='FALSE'><![CDATA["+JSPUtil.getNull(colValues.get("due_in_qty"))+"]]></TD>\n");
			
			boolean editFlag = false;
			if ( lvl.equals("00") ) {
				editFlag = true;
			}
			if ( Integer.parseInt(colValues.get("cntr_qty").trim().replace(",", "")) >= 0 ) {
				sbufXML.append("<TD EDIT='"+editFlag+"' COLOR='BLUE'><![CDATA["+JSPUtil.getNull(colValues.get("cntr_qty"))+"]]></TD>\n");
			} else {
				sbufXML.append("<TD EDIT='"+editFlag+"' COLOR='RED'><![CDATA["+JSPUtil.getNull(colValues.get("cntr_qty"))+"]]></TD>\n");
			}
			if ( Integer.parseInt(colValues.get("vari_qty").trim().replace(",", "")) >= 0 ) {
				sbufXML.append("<TD EDIT='FALSE' COLOR='BLUE'><![CDATA["+JSPUtil.getNull(colValues.get("vari_qty"))+"]]></TD>\n");
			} else {
				sbufXML.append("<TD EDIT='FALSE' COLOR='RED'><![CDATA["+JSPUtil.getNull(colValues.get("vari_qty"))+"]]></TD>\n");
			}
			sbufXML.append("<TD EDIT='FALSE'><![CDATA["+JSPUtil.getNull(colValues.get("lvl"))+"]]></TD>\n");
			sbufXML.append("<TD EDIT='FALSE'><![CDATA["+JSPUtil.getNull(colValues.get("ibflag"))+"]]></TD>\n");
			
			
			sbufXML.append(JSPUtil.getNull(colValues.get(realColNms[colCnt-1])) + "</TR>\n");
		}
		sbufXML.append("</DATA>\n");
		//log.debug("##################### AbstractValueObject sbufXML.toString() [\n" + sbufXML.toString() + "\n]");
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
