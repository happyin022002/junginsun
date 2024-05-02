/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0059ViewAdapter.java
*@FileTitle : Execution Plan
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.09.30 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event;

import java.sql.SQLException;
import java.util.List;

import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Lee SeungYol
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EesEqr0092ViewAdapter extends ViewAdapter {

	
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
		CommonRsVO commonRsVO = (CommonRsVO) vos.get(0);
		DBRowSet rs = commonRsVO.getDbRowset();
		String[] realColNms		= getColHeader(rs);
		
		int totCnt = rs.getRowCount();
		
		String sortNum	= null;
		String num		= null;
		String rowBgColor=null;
		String dataFormat=null;
				
		sbufXML.append("<DATA TOTAL='" + totCnt +"'>"+"\n");
		
		try {
			while ( rs.next() ){
				int colCnt = realColNms.length;
				
				sortNum = rs.getString("T5_SORTNUM");	//	PLAN(1), Execution(2), WO(3)
				num		= rs.getString("T5_NUM");		//  NORMAL ROW(1), SUB TOTAL(2), GRAND TOTAL(3) 구분
				
				// ROW별 색상셋팅(TOTAL, SUB TOTAL, PLAN)
				if(num.equals("2") ) {      // SUB TOTAL 라인					   
					rowBgColor=" BGCOLOR=\"249,223,155\" ";
				}else if(num.equals("3") ) {// GRAND TOTAL 라인					   
					rowBgColor=" BGCOLOR=\"254,189,182\" ";
				}else if(sortNum.equals("1") ) {    // PLAN 라인					   
					rowBgColor=" BGCOLOR=\"203,239,234\" ";
				}else {
					rowBgColor=""; 
				}
				sbufXML.append("	<TR"+rowBgColor+">\n");
				
				for(int j=1;j<=colCnt;j++){
					if(j==2) {
						// company combo box 제어
						if(sortNum.equals("1") || !num.equals("1")) {
							dataFormat=" DATA-TYPE=\"dtData\" ";
						}else {   
							dataFormat=""; 
						}
					} else if(j==12 || j==13) {
						//so send check box 제어
						if((sortNum.equals("2") || sortNum.equals("4")) && num.equals("1")) {
							dataFormat=" DATA-TYPE=\"dtCheckBox\" ";
						}else {
							dataFormat="";
						}
					} else {
						dataFormat=""; 
					}
					sbufXML.append("		<TD"+dataFormat+"><![CDATA["+ getNull(rs.getString(j))+"]]></TD>\n");
				}
				sbufXML.append("	</TR>");
			}
		} catch(SQLException ex){
			throw new RuntimeException(ex.getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
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
