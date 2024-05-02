/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0085ViewAdapter.java
*@FileTitle : ST Off-Hire Scenario Inquiry
*Open Issues :
*
*@LastModifyDate : 2009.08.10
*@LastModifier : ChungEunHo
*@LastVersion : 1.0
* 2009.08.10
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.event;

import java.sql.SQLException;
import java.util.List;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;

/**
 * EES_EQR_0085 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author ChungEunHo
 * @see ViewAdapter 참조
 * @since J2EE 1.6
 */
public class EesEqr0085ViewAdapter extends ViewAdapter {

	
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
	protected String makeDataTag(DBRowSet rs,String prefix) {
		StringBuilder sb = new StringBuilder();
		
		//Pivot Table인 경우 makePivotDataTag 실행하여  return한
		if(rs.isPivot()){
			sb.append(makePivotDataTag(rs));
			return sb.toString();
		}

		String[] realColNms = getColHeader(rs);

		try{
			
			
			sb.append("<DATA  TOTAL='" + getRowSetCnt(rs) + "'>\n");
			
			int colCount = realColNms.length;
		
			int i =1;
			
			while (rs.next()) { 
				sb.append("	<TR EDIT ='"+JSPUtil.getNull(rs.getString("delstatus"))+"'>");
				sb.append("	<TD EDIT ='"+JSPUtil.getNull(rs.getString("delstatus"))+"'>R</TD>");
				sb.append("<TD></TD>");
				for (int j=0; j < colCount; j++) {
					sb.append("<TD><![CDATA[" + JSPUtil.getNull(rs.getString(i++)) + "]]></TD>");
				}
				i = 1;
				sb.append("</TR>\n");
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
