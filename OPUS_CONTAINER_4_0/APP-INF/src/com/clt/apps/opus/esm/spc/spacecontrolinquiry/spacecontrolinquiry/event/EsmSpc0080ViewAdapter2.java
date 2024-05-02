/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0080ViewAdapter2.java
*@FileTitle : spacecontrolinquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.26
*@LastModifier : CHOI.Y.S
*@LastVersion : 1.0
* 2010.08.26 CHOI.Y.S
* 1.0 Creation
* 2010.08.26 최윤성 [CHM-201005492-01] RDR 실적 Summary 기능 개발 - 2010년 시스템 개발 계획
* 2011.07.05 최윤성 [CHM-201111937-01] Space Utilization 화면 보완
*  - Total Weight 항목 추가
=========================================================*/
package com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ComplexMainVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlRDRSummaryDownVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author CHOI.Y.S
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EsmSpc0080ViewAdapter2 extends ViewAdapter{
	
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
		
		List<SearchSpaceControlRDRSummaryDownVO> vo = new ArrayList<SearchSpaceControlRDRSummaryDownVO>();
		
		vo = comMain.getSearchSpaceControlRDRSummaryDownVO();
		
		int totCnt = vo.size();
		
		sbufXML.append("<DATA TOTAL='" + totCnt + "'>\n");
		
		for(int i=0;i<totCnt;i++) {
			sbufXML.append("<TR>");
            sbufXML.append("	<TD>" + vo.get(i).getOperator() + "</TD>");
			sbufXML.append("	<TD>" + vo.get(i).getWeek()     + "</TD>");
			sbufXML.append("	<TD>" + vo.get(i).getTrade()    + "</TD>");
			sbufXML.append("	<TD>" + vo.get(i).getSubTrade() + "</TD>");
			sbufXML.append("	<TD>" + vo.get(i).getLane()     + "</TD>");
			sbufXML.append("	<TD>" + vo.get(i).getVvd()      + "</TD>");
			sbufXML.append("	<TD>" + vo.get(i).getBound()    + "</TD>");
			sbufXML.append("	<TD>" + vo.get(i).getBsa()      + "</TD>");
			sbufXML.append("	<TD>" + vo.get(i).getFull()     + "</TD>");
			sbufXML.append("	<TD>" + vo.get(i).getMty()      + "</TD>");
			sbufXML.append("	<TD>" + vo.get(i).getTtlLoad()  + "</TD>");
			sbufXML.append("	<TD>" + vo.get(i).getTtlWgt()   + "</TD>");
			sbufXML.append("	<TD>" + vo.get(i).getFullLf()   + "</TD>");
			sbufXML.append("	<TD>" + vo.get(i).getTtlLf()    + "</TD>");
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