/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0020ViewAdapter.java
*@FileTitle : EesEqr0020ViewAdapter
*Open Issues :
*Change history :
* No.	Ver.		Modifier           			modifier date    explanation
* 1      	1.0      	Lee Byoung Hun		2009.07.29		1.0 최초 생성
*
*@LastModifyDate : 2009.07.29
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.07.29
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.event;

import java.sql.SQLException;
import java.util.List;

import com.clt.apps.opus.ees.eqr.common.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.vo.EesEqr0020ConditionVO;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Lee SeungYol
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EesEqr0020ViewAdapter extends ViewAdapter {

	
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
		CommonRsVO commonRsVO = (CommonRsVO) vos.get(0);
		EesEqr0020ConditionVO conditionVO = (EesEqr0020ConditionVO) commonRsVO.getConditionVO();
		DBRowSet rs = commonRsVO.getDbRowset();
		
		String sheetNum = conditionVO.getSheetNum();
		String statusType = conditionVO.getStatusType();
		String rccCd = "";
		String rowBgColor = "";
		
		StringBuilder sb = new StringBuilder();
		
		//Pivot Table인 경우 makePivotDataTag 실행하여  return한
		if(rs.isPivot()){
			sb.append(makePivotDataTag(rs));
			return sb.toString();
		}

		String[] realColNms = getColHeader(rs);
		try{
			// 조회대상 Sheet 번호가 없는경우 (코드 조회 경우)
			if ("".equals(sheetNum) || sheetNum == null) {
				if (rs.next()) {
					rccCd = rs.getString("RCC_CD");
				}
				sb.append("<DATA>");
				sb.append("<TR ROW= \"" + conditionVO.getRow() + "\">");
				sb.append("<TD COL= \"" + conditionVO.getCol1() + "\">");
				sb.append(rccCd);
				sb.append("</TD></TR></DATA>");
				
				return sb.toString();
			}
			
			String[] changedColNms = getChangedColNms(realColNms, prefix);
			
			sb.append("<DATA COLORDER='" + JSPUtil.convertStringArrayToString(changedColNms, "|") + "' COLSEPARATOR='" + DELIMITER + "' TOTAL='" + getRowSetCnt(rs) + "'>\n");
			
			int colCount = realColNms.length;
			
			while (rs.next()) { 
				// 두번째 시트의 경우
				if ("2".equals(sheetNum)) {
					statusType = "FALSE";
					
					// ROW별 색상셋팅(TOTAL, SUB TOTAL, PLAN)
					if(JSPUtil.getNull(rs.getString("NUM2")).equals("2")) {		// GRAND TOTAL 라인					   
						rowBgColor="BGCOLOR=\"254,189,182\" ";
					}else if(JSPUtil.getNull(rs.getString("NUM2")).equals("3") ) { // SUB TOTAL 라인					   
						rowBgColor="BGCOLOR=\"249,223,155\" ";						
					}else {
						rowBgColor=""; 
					}
				}
				
				sb.append("	<TR EDIT=\"" + statusType + "\" " + rowBgColor + "><![CDATA[");
				for (int j = 1 ; j < colCount ; j++) {
					sb.append(getNull(rs.getObject(j)) + DELIMITER);
				}	
				sb.append(getNull(rs.getObject(colCount))  + "]]></TR>\n");
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
					sb.append(getNull(rs.getObject(j)) + DELIMITER);
				}	
				sb.append(getNull(rs.getObject(colCount))  + "]]></TR>\n");
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
					arrRowSet[rowIdx][j-1] = getNull(rs.getObject(j)).toString();
				}
				rowIdx++;
			}
		}catch(SQLException ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
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
