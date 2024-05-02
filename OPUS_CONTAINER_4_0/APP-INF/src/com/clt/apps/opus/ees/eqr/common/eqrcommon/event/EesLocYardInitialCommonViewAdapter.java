
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLocYardInitialCommonViewAdapter.java
*@FileTitle : EES_LOCYARDINITIAL_COMMON 화면 IBSheet Generation Class
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-06
*@LastModifier : chung eun ho
*@LastVersion : 1.0
* 2009-08-06 chung eun ho
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.event;

import java.util.List;

import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.CommonVO;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EesCommonConditionVO;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EesCommonVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.controller.ViewAdapter;

/**
 * EES_LOCYARDINITIAL_COMMON 화면 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author chung eun ho
 * @see ViewAdapter 참조
 * @since J2EE 1.6
 */
public class EesLocYardInitialCommonViewAdapter extends ViewAdapter {

	
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
		CommonVO listVO = new CommonVO();
		AbstractValueObject vo = (AbstractValueObject)OBVOS.get(0) ;
		ObjectCloner.build(vo, listVO);

		EesCommonConditionVO condiVO = (EesCommonConditionVO)listVO.getConditionVo();
		EesCommonVO retVO  = (EesCommonVO)listVO.getResultVo();
		String row 								= "";
		String colname                          = "";
		String initialEcc                       = "";
		String resultFlag                       = "";
		String[] locYard 						= null;
		
		try{
			row    	   = condiVO.getLocyardinitialRow();
			colname	   = condiVO.getLocyardinitialColname();
			initialEcc = condiVO.getLocyardinitialEcc();
			
			resultFlag = retVO.getResultset7();         // resultFlag 3가지(1,2,3)중에 하나를 view 에서 봐야함.	
			locYard = retVO.getLocyardInitialResult();	// 검색결과		
			if(resultFlag.equals("1")) { // vessel schedule yard 1개 혹은 water(vvd 없음) 의 경우 prd matrix yard	
				sb.append("<DATA>\n");
				sb.append("<TR ROW=\""+row+"\" >");
				sb.append("	<TD COL=\""+ colname +"\" DATA-TYPE=\"dtData\" >"+JSPUtil.getNull(locYard[0])+"</TD>");
				sb.append("</TR>  ");
				sb.append("</DATA>\n");
				
			}else if(resultFlag.equals("2")) {  // vessel schedule yard 2개 이상
				sb.append("<DATA>\n");
				sb.append("<TR ROW=\""+row+"\" >");
				sb.append("	<TD COL=\""+ colname +"\" DATA-TYPE=\"dtComboEdit\" COMBO-TEXT='"+JSPUtil.getNull(locYard[0].replace("'", " "))+"' COMBO-CODE='"+JSPUtil.getNull(locYard[1])+"' ></TD>");
				sb.append("</TR>  ");
				sb.append("</DATA>\n");
				
			}else { // resultFlag = 3 을 의미함. mdm yard (vessel)
				if(locYard[0]==null || locYard[0].equals("")) { // 검색결과 전혀 없는 경우, 검색값 ecc 를 셋팅
					locYard[0] = initialEcc;	
					sb.append("<DATA>\n");
					sb.append("<TR ROW=\""+row+"\" >");
					sb.append("	<TD COL=\""+ colname +"\" DATA-TYPE=\"dtData\" >"+JSPUtil.getNull(locYard[0])+"</TD>");
					sb.append("</TR>  ");
					sb.append("</DATA>\n");
					
				}else {						
					sb.append("<DATA>\n");
					sb.append("<TR ROW=\""+row+"\" >");
					sb.append("	<TD COL=\""+ colname +"\" DATA-TYPE=\"dtComboEdit\" COMBO-TEXT='"+JSPUtil.getNull(locYard[0].replace("'", " "))+"' COMBO-CODE='"+JSPUtil.getNull(locYard[1])+"' ></TD>");
					sb.append("</TR>  ");
					sb.append("</DATA>\n");
				}
			}
			
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
