/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0021ViewAdapter.java
*@FileTitle : US Domestic 물량 조회/수정
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	Lee Byoung Hun	2009.08.05		1.0 최초 생성
*
*@LastModifyDate : 2009.08.05
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.08.05
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.event;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.eqr.common.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.vo.EesEqr0021ConditionVO;
import com.clt.apps.opus.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.vo.SearchYearDomesticPlanVO;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;

/**
 * EES_EQR_0021 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Lee Byoung Hun
 * @see ViewAdapter 참조
 * @since J2EE 1.6
 */
public class EesEqr0021ViewAdapter extends ViewAdapter {

	
	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param colOrder String[] Column명 문자열 
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception 
	 */	
	@SuppressWarnings("unchecked")
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		CommonRsVO rsVO = (CommonRsVO) vos.get(0);
		EesEqr0021ConditionVO conditionVO = (EesEqr0021ConditionVO) rsVO.getConditionVO();
		String statusType = conditionVO.getStatusType();
		List resultVOList = rsVO.getResultVOList();
		DBRowSet rs = rsVO.getDbRowset();
		
		StringBuilder sbufXML = new StringBuilder();
		
		// 상단Sheet의 경우
		if (resultVOList != null) {
			int totCnt = resultVOList.size();
			int realCnt = resultVOList.size();

			AbstractValueObject vo = (AbstractValueObject)resultVOList.get(0);
			String[] realColNms=getColHeader(vo);
			String[] changedColNms = getChangedColNms(realColNms, prefix);
			
			if(vo.getMaxRows()>0){
				totCnt = vo.getMaxRows();
			}
			
			sbufXML.append("<DATA COLORDER='" + JSPUtil.convertStringArrayToString(changedColNms, "|") + "' COLSEPARATOR='" + DELIMITER + "' TOTAL='" + totCnt +"'>\n");

			for(int i=0;i<realCnt;i++){
				Map<String, String> colValues = ((SearchYearDomesticPlanVO) resultVOList.get(i)).getColumnValues();
				
				sbufXML.append("	<TR EDIT=\"" + statusType + "\"><![CDATA[");
				int colCnt = realColNms.length;
				
				for (int j = 0 ; j < colCnt-1 ; j++) {
					sbufXML.append(getNull(colValues.get(realColNms[j])) + DELIMITER);
		        }
				sbufXML.append(getNull(colValues.get(realColNms[colCnt-1])) + "]]></TR>\n");
			}
			sbufXML.append("</DATA>\n");
			
		// 하단Sheet의 경우
		} else {
			String fmToAt = conditionVO.getFmtoat();
			String fmTypeBy = conditionVO.getFmtypeby();
			String toTypeBy = conditionVO.getTotypeby();
			String atTypeBy = conditionVO.getAttypeby();
			String timegap = null;
			
			if(!((fmToAt.equals("1") && fmTypeBy.equals("E") && toTypeBy.equals("E")) || (fmToAt.equals("2") && atTypeBy.equals("E")))){
				statusType = "FALSE";
			}
			
			//Pivot Table인 경우 makePivotDataTag 실행하여  return한
			if(rs.isPivot()){
				sbufXML.append(makePivotDataTag(rs));
				return sbufXML.toString();
			}

			String[] realColNms = getColHeader(rs);

			try{
				sbufXML.append("<DATA TOTAL='" + getRowSetCnt(rs) + "'>\n");
				
				int colCount = realColNms.length;
				
				while (rs.next()) { 
					timegap = JSPUtil.getNull(rs.getString("timegap"));
					sbufXML.append("	<TR EDIT=\"" + statusType + "\">");
					sbufXML.append("<TD></TD>");
					sbufXML.append("<TD></TD>");
					
					if ("Y".equals(timegap)) {
						for (int j = 1 ; j < colCount ; j++) {
							sbufXML.append("<TD BGCOLOR=\"YELLOW\">");
							sbufXML.append(JSPUtil.getNull(rs.getString(j)));
							sbufXML.append("</TD>");
						}
						sbufXML.append("<TD BGCOLOR=\"YELLOW\">");
						sbufXML.append(JSPUtil.getNull(rs.getString(colCount)));
						sbufXML.append("</TD>");
					} else {
						for (int j = 1 ; j < colCount ; j++) {
							sbufXML.append("<TD>");
							sbufXML.append(JSPUtil.getNull(rs.getString(j)));
							sbufXML.append("</TD>");
						}
						sbufXML.append("<TD>");
						sbufXML.append(JSPUtil.getNull(rs.getString(colCount)));
						sbufXML.append("</TD>");
					}
					
					sbufXML.append("</TR>\n");
				}
				sbufXML.append("</DATA>\n");
				
			}catch(SQLException ex){
				throw new RuntimeException(ex.getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new RuntimeException(ex.getMessage());
			}
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
