/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0090ViewAdapter.java
*@FileTitle : Scenario Sublease Out 화면조회
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	ChungEunHo	2009.08.11		1.0 최초 생성
*
*@LastModifyDate : 2009.08.05
*@LastModifier : ChungEunHo
*@LastVersion : 1.0
* 2009.08.11
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.event;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.vo.EesEqr0090ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.vo.SearchYearSubleasePlanVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.controller.ViewAdapter;

/**
 * EES_EQR_0090 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author ChungEunHo
 * @see ViewAdapter 참조
 * @since J2EE 1.6
 */
public class EesEqr0090ViewAdapter extends ViewAdapter {

	
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
		CommonRsVO listVO = new CommonRsVO();
		AbstractValueObject rsVO = (AbstractValueObject)vos.get(0);
		ObjectCloner.build(rsVO, listVO);
		EesEqr0090ConditionVO conditionVO = (EesEqr0090ConditionVO) listVO.getConditionVO();
		
		List resultVOList = listVO.getResultVOList();
		DBRowSet rs = listVO.getDbRowset();
		String fmToAt    = "";
		String fmTypeBy = "";
		String toTypeBy = "";
		String atTypeBy = "";
		String timegap = "";
		String statusType = "";
		
		StringBuilder sbufXML = new StringBuilder();
		fmToAt = conditionVO.getFmtoat();
		fmTypeBy = conditionVO.getFmtypeby();
		toTypeBy = conditionVO.getTotypeby();
		atTypeBy = conditionVO.getAttypeby();
		statusType = conditionVO.getStatustype();
		// 상단Sheet의 경우
		if (resultVOList != null ) {
			if(resultVOList.size() > 0){
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
					Map<String, String> colValues = ((SearchYearSubleasePlanVO) resultVOList.get(i)).getColumnValues();
					
					sbufXML.append("	<TR EDIT=\"" + statusType + "\"><![CDATA[");
					int colCnt = realColNms.length;
					
					for (int j = 0 ; j < colCnt-1 ; j++) {
						sbufXML.append(getNull(colValues.get(realColNms[j])) + DELIMITER);
			        }
					sbufXML.append(getNull(colValues.get(realColNms[colCnt-1])) + "]]></TR>\n");
				}
				sbufXML.append("</DATA>\n");
			}else{
				sbufXML.append("<DATA  TOTAL='0'>\n");
				sbufXML.append("</DATA>\n");
			}
		// 하단Sheet의 경우
		} else {
			
			if(!((fmToAt.equals("1") && fmTypeBy.equals("E") && toTypeBy.equals("E")) || (fmToAt.equals("2") && atTypeBy.equals("E")))){
				statusType = "FALSE";
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
						for (int j = 1 ; j <= colCount ; j++) {
							sbufXML.append("<TD BGCOLOR=\"YELLOW\">");
							sbufXML.append(JSPUtil.getNull(rs.getString(j)));
							sbufXML.append("</TD>");
						}
					} else {
						for (int j = 1 ; j <= colCount ; j++) {
							sbufXML.append("<TD>");
							sbufXML.append(JSPUtil.getNull(rs.getString(j)));
							sbufXML.append("</TD>");
						}
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
