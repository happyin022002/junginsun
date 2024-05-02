/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0063ViewAdapter.java
*@FileTitle : 컨테이너 이송실행 실적 및 Feedback 조회
*Open Issues :
*Change history :
* No.	Ver.		Modifier           					modifier date    explanation
* 1		1.0		Lee Byoung Hun				2009.10.09		1.0 최초 생성
*
*@LastModifyDate : 2009.10.09
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.10.09
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionfeedbackexamine.event;

import java.sql.SQLException;
import java.util.List;

import com.clt.apps.opus.ees.eqr.common.vo.CommonRsVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Lee SeungYol
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EesEqr0063ViewAdapter extends ViewAdapter {

	
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
		String strXML = null;
		
		CommonRsVO rsVO = (CommonRsVO) vos.get(0);
		
		if ("Sheet1".equals(rsVO.getResultString())) {
			strXML = makeDataTagSheet1(rsVO.getDbRowset());
		} else if ("Sheet2".equals(rsVO.getResultString())) {
			strXML = makeDataTagSheet2(rsVO.getDbRowset());
		}
		
		return strXML;
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
		return null;
	}
	
	/**
	 * DBRowSet를 Parsing하여 Sheet1의 <DATA>태그를 생성한다.<br>
	 * 
	 * @param rs
	 * @return
	 */
	protected String makeDataTagSheet1(DBRowSet rs) {
		StringBuilder sb = new StringBuilder();

		String[] realColNms = getColHeader(rs);

		try{
			String rowBgColor = "";
			int i =1;
			
			sb.append("<DATA TOTAL='" + getRowSetCnt(rs) + "'>\n");
			
			int colCount = realColNms.length;
			
			while (rs.next()) {
				// ROW별 색상셋팅(TOTAL, SUB TOTAL, PLAN)
				if(JSPUtil.getNull(rs.getString(1)).indexOf("TOTAL") != -1) {		// GRAND TOTAL 라인
				rowBgColor="BGCOLOR=\"236,231,247\"";
				}else if(JSPUtil.getNull(rs.getString(1)).indexOf("TTL") != -1 ) { // SUB TOTAL 라인
				rowBgColor="BGCOLOR=\"247,231,236\"";
				}else {
					rowBgColor="";
				}
				
				sb.append("	<TR>");
				sb.append("<TD></TD>");
				for (int j = 0 ; j < colCount ; j++) {
					if(JSPUtil.getNull(rs.getString(i)).indexOf("TTL") != -1 ) {
						sb.append("<TD " + rowBgColor + ">" + JSPUtil.getNull(rs.getString(i++)).substring(8,15) + "</TD>");
					} else {
						sb.append("<TD " + rowBgColor + ">" + JSPUtil.getNull(rs.getString(i++)) + "</TD>");
					}
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
	 * DBRowSet를 Parsing하여 Sheet2의 <DATA>태그를 생성한다.<br>
	 * 
	 * @param rs
	 * @return
	 */
	protected String makeDataTagSheet2(DBRowSet rs) {
		StringBuilder sb = new StringBuilder();

		String[] realColNms = getColHeader(rs);

		try{
			int i =1;
			
			sb.append("<DATA TOTAL='" + getRowSetCnt(rs) + "'>\n");
			
			int colCount = realColNms.length;
			
			while (rs.next()) {
				
				sb.append("	<TR>");
				for (int j = 0 ; j < colCount ; j++) {
					sb.append("<TD>" + JSPUtil.getNull(rs.getString(i++)) + "</TD>");
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

}
