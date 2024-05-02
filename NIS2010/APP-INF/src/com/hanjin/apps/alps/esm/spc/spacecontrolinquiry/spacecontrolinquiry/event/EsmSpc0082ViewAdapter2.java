/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0082ViewAdapter2.java
*@FileTitle : L/F Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.19
*@LastModifier : CHOI.Y.S
*@LastVersion : 1.0
* 2010.10.19 CHOI.Y.S
* 1.0 Creation
* 2010.10.19 최윤성 [CHM-201006585-01] 2010년 연간개발계획 - full+empty L/F summary 화면 개발.
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ComplexMainVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlLFSummaryDownVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author CHOI.Y.S
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EsmSpc0082ViewAdapter2 extends ViewAdapter{
	
	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param colOrder String[] Column명 문자열 
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception 
	 */	
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) 
	{
		StringBuilder sbufXML = new StringBuilder();
				
		ComplexMainVO comMain = (ComplexMainVO)vos.get(0);
		
		List<SearchSpaceControlLFSummaryDownVO> vo = new ArrayList<SearchSpaceControlLFSummaryDownVO>();
		
		vo = comMain.getSearchSpaceControlLFSummaryDownVO();
		
		int totCnt = vo.size();
		
		sbufXML.append("<DATA TOTAL='" + totCnt + "'>\n");
		
		for(int i=0;i<totCnt;i++) {
			sbufXML.append("<TR>");
            sbufXML.append("	<TD>" + vo.get(i).getCostWk()   + "</TD>");
			sbufXML.append("	<TD>" + vo.get(i).getTrdCd()    + "</TD>");
			sbufXML.append("	<TD>" + vo.get(i).getSubTrdCd() + "</TD>");
			sbufXML.append("	<TD>" + vo.get(i).getRlaneCd()  + "</TD>");
			sbufXML.append("	<TD>" + vo.get(i).getDirCd()    + "</TD>");
			sbufXML.append("	<TD>" + vo.get(i).getVvd()      + "</TD>");
			sbufXML.append("	<TD>" + vo.get(i).getBsa()      + "</TD>");
			sbufXML.append("	<TD>" + vo.get(i).getFull()     + "</TD>");
			sbufXML.append("	<TD>" + vo.get(i).getEmpty()    + "</TD>");
			sbufXML.append("	<TD>" + vo.get(i).getTtlLoad()  + "</TD>");
			sbufXML.append("	<TD>" + vo.get(i).getFullLf()   + "%</TD>");
			sbufXML.append("	<TD>" + vo.get(i).getTtlLf()    + "%</TD>");
			sbufXML.append("</TR>\n");
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
	
	protected String getETCData(EventResponse eventResponse) {
		return "";
	}
}