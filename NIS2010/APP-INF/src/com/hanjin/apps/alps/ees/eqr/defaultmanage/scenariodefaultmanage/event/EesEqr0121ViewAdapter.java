/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr121ViewAdapter.java
*@FileTitle : EesEqr121 화면 IBSheet Generation Class
*Open Issues :
*Change history :
*@LastModifyDate : 2009-07-15
*@LastModifier : chung eun ho
*@LastVersion : 1.0
* 2009-07-15 chung eun ho
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.event;

import java.sql.SQLException;
import java.util.List;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;

/**
 * EesEqr121 화면 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author chung eun ho
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EesEqr0121ViewAdapter extends ViewAdapter {

	
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
	protected String makeDataTag(DBRowSet rowSet,String prefix) {
		StringBuilder sb = new StringBuilder();
		String[] realColNms = getColHeader(rowSet);
		String editStatus = "";
		String dataFormat = "";
		String rowBgColor = "";	

		try{
			
			sb.append("<DATA  TOTAL='" + getRowSetCnt(rowSet) + "'>\n");
			
			int colCount = realColNms.length;
			
			while (rowSet.next()) { 
				// 1: Manufactured 를 의미
			    // TOTAL, BOTH 아닐때만 수정가능
				if(
				   JSPUtil.getNull(rowSet.getString(25)).equals("1") &&
				  !JSPUtil.getNull(rowSet.getString(26)).equals("2") &&
				  !JSPUtil.getNull(rowSet.getString(26)).equals("3") && 
				  !JSPUtil.getNull(rowSet.getString(1)).equals("Both")
				) {
					editStatus="";
				}else {
					editStatus="EDIT='FALSE' "; 
				}
			
				// ROW별 색상셋팅(TOTAL, SUB TOTAL, PLAN)
				if(JSPUtil.getNull(rowSet.getString(26)).equals("2")) {		// GRAND TOTAL 라인					   
					rowBgColor="BGCOLOR='254,189,182' ";
				}else if(JSPUtil.getNull(rowSet.getString(26)).equals("3") ) { // SUB TOTAL 라인					   
					rowBgColor="BGCOLOR='249,223,155' ";						
				}else {
					rowBgColor=""; 
				}		
				sb.append("<TR "+editStatus+" "+ rowBgColor +">");
				
				sb.append("<TD>R</TD>");
				sb.append("<TD></TD>");
				
				for (int j = 1 ; j <= colCount ; j++) {
					// CO 정보를 dtCombo 형식으로 사용하므로 sub total, total, both 은 dtData 형식으로 변경
					if(JSPUtil.getNull(rowSet.getString(26)).equals("2") || 
					   //JSPUtil.getNull(rowSet.getString(26)).equals("3") || 
					   JSPUtil.getNull(rowSet.getString(1)).equals("Both")) {
						dataFormat="DATA-TYPE='dtData' ";
					}
					
					sb.append("<TD "+dataFormat +">"+JSPUtil.getNull(rowSet.getString(j)).replaceAll("&","&amp;") +"</TD>"); 
					
				}	
				sb.append( "</TR>\n");
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
		
		return sb.toString();
	}

}
