/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0081ViewAdapter.java
*@FileTitle : Loading by POL/POD
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.26
*@LastModifier : 김민아
*@LastVersion : 1.0
* 2010.08.26 김민아
* 1.0 Creation
* 2010.08.26 김민아 [CHM-201005553-01] RDR 실적 중 POL/POD 세부 Data Download 기능 개발
* 2011.07.05 최윤성 [CHM-201111937-01] Space Utilization 화면 보완
*  - Lane 조회조건 추가 및 Full TEU/Mty TEU 각각의 항목 옆에 Full WGT/Mty WGT 항목 추가
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ComplexMainVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryRDRDetailListVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.controller.ViewAdapter;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author 한상훈
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EsmSpc0081ViewAdapter extends ViewAdapter{
	

	
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
		ComplexMainVO listVO = (ComplexMainVO)vos.get(0);
		int rowCount	 = 0;
		

		if( listVO.getEventCommand().equals("SEARCHLIST")){	//2.1
			
			List<SearchSpaceControlInquiryRDRDetailListVO> list = new ArrayList<SearchSpaceControlInquiryRDRDetailListVO>();
			list = listVO.getSearchSpaceControlInquiryRDRDetailListVO();
			
			if(list != null) rowCount = list.size();
			sbufXML.append("<DATA TOTAL=\""+rowCount+"\">\n");		

			for(int i=0;i<rowCount;i++){
				
				SearchSpaceControlInquiryRDRDetailListVO colValues = list.get(i);
				
				sbufXML.append("<TR>");
				sbufXML.append("<TD><![CDATA["+ colValues.getOprCd()     +"]]></TD>");
				sbufXML.append("<TD><![CDATA["+ colValues.getCostWk()    +"]]></TD>");
				sbufXML.append("<TD><![CDATA["+ colValues.getTrdCd()     +"]]></TD>");
				sbufXML.append("<TD><![CDATA["+ colValues.getSubTrdCd()  +"]]></TD>");
				sbufXML.append("<TD><![CDATA["+ colValues.getRlaneCd()   +"]]></TD>");
				sbufXML.append("<TD><![CDATA["+ colValues.getVvd()       +"]]></TD>");
				sbufXML.append("<TD><![CDATA["+ colValues.getDirCd()     +"]]></TD>");
				sbufXML.append("<TD><![CDATA["+ colValues.getBasicSlot() +"]]></TD>");
				sbufXML.append("<TD><![CDATA["+ colValues.getCntrType()  +"]]></TD>");
				sbufXML.append("<TD><![CDATA["+ colValues.getCntr20()    +"]]></TD>");
				sbufXML.append("<TD><![CDATA["+ colValues.getCntr20h()   +"]]></TD>");
				sbufXML.append("<TD><![CDATA["+ colValues.getCntr40()    +"]]></TD>");
				sbufXML.append("<TD><![CDATA["+ colValues.getCntr40h()   +"]]></TD>");
				sbufXML.append("<TD><![CDATA["+ colValues.getCntr45()    +"]]></TD>");
				sbufXML.append("<TD><![CDATA["+ colValues.getFullTeu()   +"]]></TD>");
				sbufXML.append("<TD><![CDATA["+ colValues.getFullWgt()   +"]]></TD>");
				sbufXML.append("<TD><![CDATA["+ colValues.getMtyTeu()    +"]]></TD>");
				sbufXML.append("<TD><![CDATA["+ colValues.getMtyWgt()    +"]]></TD>");
				sbufXML.append("<TD><![CDATA["+ colValues.getPol()       +"]]></TD>");
				sbufXML.append("<TD><![CDATA["+ colValues.getPod()       +"]]></TD>");
				sbufXML.append("</TR>\n");
				
			}
			
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