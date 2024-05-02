/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0014ViewAdapter.java
*@FileTitle : Scenario BSA 화면조회
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	ChungEunHo	2009.08.12		1.0 최초 생성
*
*@LastModifyDate : 2009.08.12
*@LastModifier : ChungEunHo
*@LastVersion : 1.0
* 2009.08.12
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.event;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.vo.EesEqr0014ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.vo.SearchBSInfoVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.vo.SearchBSPortInfoVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.controller.ViewAdapter;

/**
 * EES_EQR_0014 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author ChungEunHo
 * @see ViewAdapter 참조
 * @since J2EE 1.6
 */
public class EesEqr0014ViewAdapter extends ViewAdapter {

	
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
		EesEqr0014ConditionVO conditionVO = (EesEqr0014ConditionVO) listVO.getConditionVO();
		
		List resultVOList = listVO.getResultVOList();
		String flag = "";
//		String status = "";
		
		StringBuilder sbufXML = new StringBuilder();
		
		// 상단Sheet의 경우
		if (resultVOList != null && resultVOList.size() > 0) {
			int totCnt = resultVOList.size();
			int realCnt = resultVOList.size();

			AbstractValueObject vo = (AbstractValueObject)resultVOList.get(0);
			String[] realColNms=getColHeader(vo);
			String[] changedColNms = getChangedColNms(realColNms, prefix);
			
			if(vo.getMaxRows()>0){
				totCnt = vo.getMaxRows();
			}
//			status 	= conditionVO.getStatusType();
			flag 	= conditionVO.getFlag();
			sbufXML.append("<DATA COLORDER='" + JSPUtil.convertStringArrayToString(changedColNms, "|") + "' COLSEPARATOR='" + DELIMITER + "' TOTAL='" + totCnt +"'>\n");

			for(int i=0;i<realCnt;i++){
				// 2015.02.25 CHM-201534210 EQR 소스 보안
				Map<String, String> colValues = new HashMap<String, String>();
				String voClassName = resultVOList.get(i).getClass().getName();
				
				if(voClassName != null && voClassName.indexOf("SearchBSInfoVO") != -1){
					colValues = ((SearchBSInfoVO) resultVOList.get(i)).getColumnValues();
				}else if(voClassName != null && voClassName.indexOf("SearchBSPortInfoVO") != -1) {
					colValues = ((SearchBSPortInfoVO) resultVOList.get(i)).getColumnValues();
				}
				
				
				sbufXML.append("	<TR EDIT=\"" + flag + "\"><![CDATA[");
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
