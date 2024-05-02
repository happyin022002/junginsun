/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0083ViewAdapter.java
*@FileTitle : Weekly L/F by POL/POD
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.22
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2010.11.22 김종준
* 1.0 Creation
* 2011.12.08 김종준 - Ticket ID : CHM-201004165
* 2011.12.08 김종준   화면 속도 개선 
* 2011.12.29 김종준 [CHM-201007719-01] Loading by POL/POD 화면 -POL/POD별 조회 기능추가
* 2011.07.05 최윤성 [CHM-201111937-01] Space Utilization 화면 보완
*  - Grid 상단의 POL/POD 체크박스 옆에 Weight 체크박스 추가하여, 해당 항목 체크시 Weight 정보 보여줌. 각각의 Carrier 별 Weight 정보를 추가.
* 2011.10.05 김종준 [CHM-201113755-01] 
	-IOC가 ‘O’인 경우에만 조회가 가능토록 되어있으나, WAFIE와 마찬가지로 NBSIM 노선의 경우,
	  Intra 노선이지만, Ocean 처럼 인식되어 데이터가 조회될 수 있도록 보완 요청  
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ComplexMainVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchWeeklyLfByPolPodListVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.controller.ViewAdapter;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author 김종준
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EsmSpc0083ViewAdapter extends ViewAdapter{
	

	
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
		
		ConditionVO conditionVO = listVO.getConditionVO();

		if( listVO.getEventCommand().equals("SEARCHLIST")){	//2.1
			
			List<SearchWeeklyLfByPolPodListVO> list = new ArrayList<SearchWeeklyLfByPolPodListVO>();
			list = listVO.getSearchWeeklyLfByPolPodListVO();

			if(list != null) rowCount = list.size();
			sbufXML.append("<DATA TOTAL=\""+rowCount+"\">\n");		

			for(int i=0;i<rowCount;i++){
				
				SearchWeeklyLfByPolPodListVO colValues = list.get(i);
				String bgColor = "";
				String lvl = colValues.getLvl();
				String lvl0 = colValues.getLvl0();
				String rowMerge = "false"; 
				if ( lvl0.equals("9")) {	//VVD ROW 색상 지정
					bgColor = "232,255,198";
					rowMerge = "true";
				} else if ( lvl0.equals("")) {	 //TTL LOAD,BSA,L/F ROW 색상 지정
					bgColor = "236,231,247";
				}
				if ( colValues.getGrpId().equals("01101") ) {	//Line별 색상 지정	
					bgColor = "247,231,236";
				} else if ( colValues.getGrpId().substring(0, 2).equals("11") && !colValues.getGrpId().equals("11111")) {	//Trade별 색상 지정	
					bgColor = "219,229,241";
				}
			    String polPodColor = "0,0,0";	   //Sub Trade/line,pol,pod 색상 세팅
			    if ( lvl0.equals("")) { 
			    	polPodColor = "236,231,247";
				} else if ( lvl0.equals("9")) {
			    	polPodColor = "232,255,198";
			    }

			    String polTtlColor = "236,231,247";	   //POL TTL 색상 세팅
			    if ( !lvl0.equals("9") && !lvl0.equals("")) {
			    	polTtlColor = "219,229,241";
			    }

				sbufXML.append("<TR MERGE=\""+rowMerge+"\" LEVEL='" + lvl +"' BGCOLOR=\""+bgColor+"\" EXPAND=\"FALSE\">");
				sbufXML.append("	<TD BGCOLOR=\"232,255,198\"><![CDATA["+ colValues.getSubRlaneCd()	+"]]></TD>");
				if ( conditionVO.getPolpodFlg().equals("POL")) {
					sbufXML.append("	<TD BGCOLOR=\""+polPodColor+"\"><![CDATA["+ colValues.getPol()  +"]]></TD>");
					sbufXML.append("	<TD BGCOLOR=\""+polPodColor+"\"><![CDATA["+ colValues.getPod()  +"]]></TD>");
				} else {
					sbufXML.append("	<TD BGCOLOR=\""+polPodColor+"\"><![CDATA["+ colValues.getPod()  +"]]></TD>");
					sbufXML.append("	<TD BGCOLOR=\""+polPodColor+"\"><![CDATA["+ colValues.getPol()  +"]]></TD>");
				}
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk1HjsQty()    	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk1HjsWgt()    	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk1CosQty() 	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk1CosWgt()    	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk1KklQty()     +"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk1KklWgt()    	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk1YmlQty() 	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk1YmlWgt()    	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk1OthQty()  	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk1OthWgt()    	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\" BGCOLOR=\""+polTtlColor+"\"><![CDATA["+ colValues.getWk1PolQty()	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\" BGCOLOR=\""+polTtlColor+"\"><![CDATA["+ colValues.getWk1PolWgt()	+"]]></TD>");

				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk2HjsQty()   	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk2HjsWgt()   	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk2CosQty()     +"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk2CosWgt()   	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk2KklQty()     +"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk2KklWgt()   	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk2YmlQty() 	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk2YmlWgt()   	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk2OthQty()  	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk2OthWgt()   	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"  BGCOLOR=\""+polTtlColor+"\"><![CDATA["+ colValues.getWk2PolQty()+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"  BGCOLOR=\""+polTtlColor+"\"><![CDATA["+ colValues.getWk2PolWgt()+"]]></TD>");

				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk3HjsQty()   	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk3HjsWgt()   	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk3CosQty()     +"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk3CosWgt()   	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk3KklQty()     +"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk3KklWgt()   	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk3YmlQty() 	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk3YmlWgt()   	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk3OthQty()  	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk3OthWgt()   	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"  BGCOLOR=\""+polTtlColor+"\"><![CDATA["+ colValues.getWk3PolQty()+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"  BGCOLOR=\""+polTtlColor+"\"><![CDATA["+ colValues.getWk3PolWgt()+"]]></TD>");

				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk4HjsQty()   	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk4HjsWgt()   	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk4CosQty()     +"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk4CosWgt()   	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk4KklQty()     +"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk4KklWgt()   	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk4YmlQty() 	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk4YmlWgt()   	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk4OthQty()  	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk4OthWgt()   	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"  BGCOLOR=\""+polTtlColor+"\"><![CDATA["+ colValues.getWk4PolQty()+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"  BGCOLOR=\""+polTtlColor+"\"><![CDATA["+ colValues.getWk4PolWgt()+"]]></TD>");

				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk5HjsQty()   	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk5HjsWgt()   	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk5CosQty()     +"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk5CosWgt()   	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk5KklQty()     +"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk5KklWgt()   	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk5YmlQty() 	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk5YmlWgt()   	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk5OthQty()  	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getWk5OthWgt()   	+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"  BGCOLOR=\""+polTtlColor+"\"><![CDATA["+ colValues.getWk5PolQty()+"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"  BGCOLOR=\""+polTtlColor+"\"><![CDATA["+ colValues.getWk5PolWgt()+"]]></TD>");
				String ttlColor = "247,231,236";	//POL TTL 기본  VVD 색상 지정	
			    if ( lvl0.equals("") ) {	//TTL LOAD,BSA,L/F ROW 색상 지정
			    	ttlColor = "236,231,247";	//POL TTL 색상 지정
			    } else if (  lvl0.equals("9") ) {
			    	ttlColor = "232,255,198";	//vvd 색상 지정
			    } 
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getGtlHjsQty()   +"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getGtlHjsWgt()   +"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getGtlCosQty()   +"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getGtlCosWgt()   +"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getGtlKklQty()   +"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getGtlKklWgt()   +"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getGtlYmlQty()   +"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getGtlYmlWgt()   +"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getGtlOthQty()   +"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\"><![CDATA["+ colValues.getGtlOthWgt()   +"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\" BGCOLOR=\""+ttlColor+"\"><![CDATA["+ colValues.getGtlPolQty()   +"]]></TD>");
				sbufXML.append("	<TD DATA-ALIGN=\"daRight\" BGCOLOR=\""+ttlColor+"\"><![CDATA["+ colValues.getGtlPolWgt()   +"]]></TD>");

				sbufXML.append("	<TD><![CDATA["+ colValues.getLvl()    +"]]></TD>");
				sbufXML.append("	<TD><![CDATA["+ colValues.getLvl0()   +"]]></TD>");
				sbufXML.append("	<TD><![CDATA["+ colValues.getGrpId()  +"]]></TD>");
				sbufXML.append("	<TD><![CDATA["+ colValues.getTrdCd()  +"]]></TD>");
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