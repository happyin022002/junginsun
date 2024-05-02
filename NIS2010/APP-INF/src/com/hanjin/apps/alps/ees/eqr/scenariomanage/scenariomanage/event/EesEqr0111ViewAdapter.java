
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0111ViewAdapter.java
*@FileTitle : EesEqr0111 화면  IBSheet Generation Class
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-06
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009-08-06 정은호
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.event;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.vo.EesEqr0111ConditionVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.syscommon.common.table.EqrScnrVslSkdVO;

/**
 * EesEqr0111 화면 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author ChungEunHo
 * @see ViewAdapter 참조
 * @since J2EE 1.6
 */
public class EesEqr0111ViewAdapter extends ViewAdapter {

	
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
	protected String makeDataTag(List<AbstractValueObject> Parentvos, String prefix) {
		StringBuilder sbufXML = new StringBuilder();
		
		CommonRsVO listVO = new CommonRsVO();
		AbstractValueObject pvo = (AbstractValueObject)Parentvos.get(0);
		ObjectCloner.build(pvo, listVO);
		EesEqr0111ConditionVO condiVO = (EesEqr0111ConditionVO)listVO.getConditionVO();
		List<EqrScnrVslSkdVO> list = listVO.getResultVOList();
		List<EqrScnrVslSkdVO> vos = new ArrayList<EqrScnrVslSkdVO>();
		ObjectCloner.build(list, vos);
		
		AbstractValueObject vo = (AbstractValueObject)vos.get(0);
		
		int totCnt = vos.size();
		int realCnt = vos.size();
		String[] realColNms=getColHeader(vo);
		String[] changedColNms = getChangedColNms(realColNms, prefix);
		String edittype = "";
		
		if(condiVO != null){
			edittype = condiVO.getEdittype();
		}
		
		if(vo.getMaxRows()>0){
			totCnt = vo.getMaxRows();
		}
		sbufXML.append("<DATA COLORDER='" + JSPUtil.convertStringArrayToString(changedColNms, "|") + "' COLSEPARATOR='" + DELIMITER + "' TOTAL='" + totCnt +"'>\n");

		for(int i=0;i<realCnt;i++){
			Map<String, String> colValues = vos.get(i).getColumnValues();
			
			sbufXML.append("	<TR EDIT =\""+JSPUtil.getNull(edittype)+"\" ><![CDATA[");
			int colCnt = realColNms.length;
			
			for (int j = 0 ; j < colCnt-1 ; j++) {
				sbufXML.append(getNull(colValues.get(realColNms[j])) + DELIMITER);
	        }
			sbufXML.append(getNull(colValues.get(realColNms[colCnt-1])) + "]]></TR>\n");
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
