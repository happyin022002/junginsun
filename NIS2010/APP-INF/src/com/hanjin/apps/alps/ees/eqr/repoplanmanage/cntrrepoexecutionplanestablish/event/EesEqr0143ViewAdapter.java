/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0143ViewAdapter.java
*@FileTitle : EQR All-Weeks' Plan Access Grant
*Open Issues :
*	신규프로젝트 CSRNO : CHM-201003779
*	EQR VL-VD 전주차 접근권한 유저 신규메뉴 생성
*Change history :
* No.	Ver.		Modifier           					modifier date    explanation
* 1      	1.0      	Lee Byoung Hun				2010.05.11		1.0 최초 생성
*
*@LastModifyDate : 2010.05.11
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2010.05.11
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event;

import java.util.List;

import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0143ConditionVO;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Lee Byoung Hun
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EesEqr0143ViewAdapter extends ViewAdapter {

	
	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception 
	 */	
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		StringBuilder sbufXML = new StringBuilder();
		EesEqr0143ConditionVO conditionVO = (EesEqr0143ConditionVO) vos.get(0);
		
		String row = conditionVO.getRow();
		String usrId = conditionVO.getUsrId();
		String usrNm = conditionVO.getUsrNm();
		String ofcCd = conditionVO.getOfcCd();
		
		sbufXML.append("<DATA>\n");
		sbufXML.append("<TR ROW= \"" + row + "\" >\n");
		sbufXML.append("<TD COL=\"usr_id\">" + usrId + "</TD>\n");
		sbufXML.append("<TD COL=\"usr_nm\">" + usrNm + "</TD>\n");
		sbufXML.append("<TD COL=\"ofc_cd\">" + ofcCd + "</TD>\n");
		sbufXML.append("</TR>\n");
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
		return null;
	}

}
