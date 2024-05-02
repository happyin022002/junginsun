/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0122ViewAdapter.java
*@FileTitle : Default IBSheet Generation Class
*Open Issues :
*Change history :
*@LastModifyDate : 2009-07-13
*@LastModifier : Chae Chang Ho
*@LastVersion : 1.0
* 2008-11-24 Chae Chang Ho
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.event;

import java.sql.SQLException;
import java.util.List;

import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0122ConditionVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.ScenarioDefaultManageRsVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.controller.ViewAdapter;
/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Lee SeungYol
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EesEqr0122ViewAdapter extends ViewAdapter {

	
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
		StringBuilder sb = new StringBuilder();
	
		ScenarioDefaultManageRsVO listVO = new ScenarioDefaultManageRsVO();
		AbstractValueObject vo = (AbstractValueObject)vos.get(0);
		ObjectCloner.build(vo, listVO);
		
		EesEqr0122ConditionVO condiVO = (EesEqr0122ConditionVO)listVO.getConditionVo();
		DBRowSet rowSet				  = listVO.getDBRowSet();		
		String flag = null;
		
		try{
			sb.append("<DATA TOTAL='"+getRowSetCnt(rowSet)+"'> ");
			int i =1;
			if (rowSet != null) {
				while (rowSet.next()) {	
					flag = JSPUtil.getNull(rowSet.getString("flag")); 
					if(flag.equals("1") || flag.equals("3")){
						if (flag.equals("1")){
							sb.append("<TR>");
							sb.append("<TD>R</TD>");
							sb.append("<TD></TD>");
							for (int j = 0 ; j < rowSet.getMetaData().getColumnCount() ; j++) {
								//sb.append(" <TD><![CDATA["+JSPUtil.getNull(rowSet.getString(i++))+"]]></TD>");
								sb.append(" <TD>"+JSPUtil.getNull(rowSet.getString(i++))+"</TD>");
							}
							i = 1;
							sb.append("</TR>\n"); 
						}else {
							String timegap = JSPUtil.getNull(rowSet.getString("timegap"));
							if(timegap.equals("Y")) {
								sb.append("<TR BGCOLOR='YELLOW'>");
								sb.append("<TD></TD>");
								sb.append("<TD></TD>");	
							}else {
								sb.append("<TR>");
								sb.append("<TD></TD>");
								sb.append("<TD></TD>");
							}
							for (int j = 0 ; j < rowSet.getMetaData().getColumnCount() ; j++) {
								if(condiVO.getFmToAt().equals("1")) {
									if(condiVO.getFmTypeBy().equals("E") && condiVO.getToTypeBy().equals("E")) {
									//sb.append(" <TD><![CDATA["+JSPUtil.getNull(rowSet.getString(i++))+"]]></TD>");
									sb.append(" <TD>"+JSPUtil.getNull(rowSet.getString(i++))+"</TD>");
									} else {
									//sb.append(" <TD EDIT='FALSE'><![CDATA["+JSPUtil.getNull(rowSet.getString(i++))+"]]></TD>");
									sb.append(" <TD EDIT='FALSE'>"+JSPUtil.getNull(rowSet.getString(i++))+"</TD>");
									}
								}else {
									if(condiVO.getAtTypeBy().equals("E")) {
										//sb.append(" <TD><![CDATA["+JSPUtil.getNull(rowSet.getString(i++))+"]]></TD>");
										sb.append(" <TD>"+JSPUtil.getNull(rowSet.getString(i++))+"</TD>");
									}else{
										//sb.append(" <TD EDIT='FALSE'><![CDATA["+JSPUtil.getNull(rowSet.getString(i++))+"]]></TD>");
										sb.append(" <TD EDIT='FALSE'>"+JSPUtil.getNull(rowSet.getString(i++))+"</TD>");
									}
								}
							}
							i = 1;
							sb.append("</TR>\n");  
						}
					}else if (flag.equals("2")){		
						sb.append("<TR>");
						for (int j = 0 ; j < rowSet.getMetaData().getColumnCount() ; j++) {
							sb.append(" <TD><![CDATA["+JSPUtil.getNull(rowSet.getString(i++))+"]]></TD>");
						}
						i = 1;
						sb.append("</TR>\n"); 
					}
				}
				sb.append("</DATA>\n");		
			}
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
