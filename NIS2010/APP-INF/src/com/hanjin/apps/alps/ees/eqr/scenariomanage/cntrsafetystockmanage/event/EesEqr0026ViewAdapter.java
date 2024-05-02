/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : DefaultViewAdapter.java
*@FileTitle : Default IBSheet Generation Class
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-10
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.08.06 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrsafetystockmanage.event;

import java.sql.SQLException;
import java.util.List;

import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrsafetystockmanage.vo.EesEqr0026ConditionVO;
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
public class EesEqr0026ViewAdapter extends ViewAdapter {

	
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
		EesEqr0026ConditionVO conditionVO = (EesEqr0026ConditionVO) commonRsVO.getConditionVO();
		DBRowSet rs = commonRsVO.getDbRowset();		
		String[] realColNms = getColHeader(rs);		
		StringBuilder sbufXML = new StringBuilder();
		
		String f_cmd		= conditionVO.getFCmd();
		String statusType	= conditionVO.getStatusType();
		String row			= conditionVO.getRow();
		String col_name		= conditionVO.getCol();
		String timegap		= null;
		StringBuffer sfstk_vol_qty = new StringBuffer(512);
		
		try{
			int colCount = realColNms.length;
			
			if ( f_cmd.equals("3") ) { // SEARCHLIST
				sbufXML.append("<DATA TOTAL=\""+getRowSetCnt(rs)+"\">"+"\n");
				while (rs.next()) {
					if ( getRowSetCnt(rs) >0 ){
						timegap = getNull(rs.getString("timegap"));
						
					}
					timegap = JSPUtil.getNull(rs.getString("timegap"));
					sbufXML.append("	<TR EDIT=\""+statusType+"\">"+"\n");
					sbufXML.append("		<TD>R</TD>"+"\n");
					sbufXML.append("		<TD></TD>"+"\n");
					
					for (int j = 1 ; j < colCount ; j++) {
						if(timegap.equals("Y")){
							sbufXML.append("		<TD BGCOLOR=\"YELLOW\">"+getNull(rs.getObject(j))+"</TD>"+"\n");
						} else {
							sbufXML.append("		<TD>"+getNull(rs.getObject(j))+"</TD>"+"\n");
						}
					}
					sbufXML.append("	</TR> \n");
				}
			} else if ( f_cmd.equals("122") ) { // SEARCHLIST02
				col_name		= col_name.substring(0,2) + "sfstk_vol_qty";
				if ( colCount == 0 ) {
					sfstk_vol_qty.append("0");
				}
				sbufXML.append("<DATA>"+"\n");
				sbufXML.append("	<TR ROW=\""+row+"\">"+"\n");
				while (rs.next()) {
					sfstk_vol_qty.append(getNull(rs.getString("SFSTK_VOL_QTY")));
				}
				sbufXML.append("		<TD COL=\""+col_name+"\" DATA-TYPE=\"dtData\">"+sfstk_vol_qty+"</TD>"+"\n");
				
				sbufXML.append("	</TR>"+"\n");
			}
			
			sbufXML.append("</DATA>	\n");
		} catch(SQLException ex){
			throw new RuntimeException(ex.getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}
		
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
