
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLocYardCommonViewAdapter.java
*@FileTitle : EES_LOCYARD_COMMON 화면 IBSheet Generation Class
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-06
*@LastModifier : chung eun ho
*@LastVersion : 1.0
* 2009-08-06 chung eun ho
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.event;

import java.util.List;

import com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.vo.CommonVO;
import com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.vo.EesCommonConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.vo.EesCommonVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
//import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.controller.ViewAdapter;

/**
 * EES_LOCYARD_COMMON 화면 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author chung eun ho
 * @see ViewAdapter 참조
 * @since J2EE 1.6
 */
public class EesLocYardCommonViewAdapter extends ViewAdapter {

	
	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param colOrder String[] Column명 문자열 
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception 
	 */	 
	protected String makeDataTag(List<AbstractValueObject> OBVOS, String prefix) {
		StringBuilder sb = new StringBuilder();
//		CommonVO listVO = new CommonVO();
//		AbstractValueObject vo = (AbstractValueObject)OBVOS.get(0) ;
//		ObjectCloner.build(vo, listVO);
		CommonVO listVO = (CommonVO)OBVOS.get(0) ;

		EesCommonConditionVO condiVO = (EesCommonConditionVO)listVO.getConditionVo();
		EesCommonVO retVO  = (EesCommonVO)listVO.getResultVo();
		String row 								= "";
		String colname                          = "";
		String[] locYard					    = null;
		try{
			row    = condiVO.getLocyardRow();
			colname= condiVO.getLocyardColname();
			locYard= retVO.getLocyardResult();
			
			sb.append("<DATA>\n");
			sb.append("<TR ROW=\""+row+"\" >");
			sb.append("	<TD COL=\""+ colname +"\" DATA-TYPE=\"dtComboEdit\" COMBO-TEXT='"+JSPUtil.getNull(locYard[0])+"' COMBO-CODE='"+JSPUtil.getNull(locYard[1])+"' ></TD>");
			sb.append("</TR>  ");
			sb.append("</DATA>\n");
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
	protected String makeDataTag(DBRowSet rowSet,String prefix) {
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
