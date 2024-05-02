/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmSpc0021ViewAdapter.java
*@FileTitle      : Daily Forecast Status
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.08.03
*@LastModifier   : 한상훈
*@LastVersion    : 1.0
* 2009.08.13
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ComplexMainVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ETCVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiry021FcastPortViewListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryConditionVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author 한상훈
 * @see ViewAdapter 참조 
 * @since J2EE 1.5
 */
public class EsmSpc0021ViewAdapter extends ViewAdapter{
	
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
		
		List<ETCVO> etc = new ArrayList<ETCVO>();
		etc = comMain.getEtc();
		List<SearchSpaceControlInquiry021FcastPortViewListVO> viewList = new ArrayList<SearchSpaceControlInquiry021FcastPortViewListVO>();
		viewList = comMain.getInquiry021FcastPortViewListVO();
		
		SearchSpaceControlInquiryConditionVO condition = comMain.getCondition();
		int rowCountetc  = etc.size();
		int rowCountview = viewList.size();
		
		sbufXML.append("<DATA TOTAL=\""+rowCountview+"\">\n");
		
		int weekCnt   = 0;
		String[] week ; //소스 품질 수정 요청건
		String[] fdtd ; //소스 품질 수정 요청건
		boolean[] existsWeek ; //소스 품질 수정 요청건
		String strWeek = "";
		String strFdTd = "";
		String portv   = condition.getChkview();

		if (rowCountetc>0 && etc != null) {//3.1				
			weekCnt = rowCountetc;
			week    = new String[weekCnt];
			fdtd    = new String[weekCnt];
			existsWeek = new boolean[weekCnt];
			
			for(int i = 0;i<rowCountetc;i++) {
				week[i] = JSPUtil.getNull(etc.get(i).getCostYr()) + JSPUtil.getNull(etc.get(i).getCostWk1());
				fdtd[i] = JSPUtil.getNull(etc.get(i).getSlsFmDt()) + "~"+JSPUtil.getNull(etc.get(i).getSlsToDt());
			}//4.9
		
		
			if (rowCountview>0 && viewList != null) {//3.1
				String[] items   = {"Load", "Grev", "Grpb", "Cm", "Cmb"};
				int duration = Integer.parseInt(condition.getDuration());
	//		    int level    = 0;				
			    
			    for(int j=0;j<rowCountview;j++){ //4.1
	//		    	level = Integer.parseInt(viewList.get(j).getLvl());
			    	
			    	sbufXML.append("<TR>\n");
	//		    	sbufXML.append("<TR LEVEL=\"" + level + "\">\n");
			    	sbufXML.append("<TD>" + viewList.get(j).getAqCd()  + "</TD>\n");
			    	sbufXML.append("<TD>" + viewList.get(j).getOfcCd() + "</TD>\n");
			    	sbufXML.append("<TD></TD>\n");
			    	
			    	for(int d = 1 ; d <= duration ; d++){
			    			
		    			sbufXML.append("<TD>" + viewList.get(j).getQtaLoad()  + "</TD>\n");
		    			sbufXML.append("<TD>" + viewList.get(j).getFctLoad()  + "</TD>\n");
		    			sbufXML.append("<TD>" + viewList.get(j).getPfcLoad()  + "</TD>\n");
		    			sbufXML.append("<TD>" + viewList.get(j).getDiffLoad() + "</TD>\n");
		    			sbufXML.append("<TD>" + viewList.get(j).getBkgLoad()  + "</TD>\n");
		    			sbufXML.append("<TD>" + viewList.get(j).getPrefLoad() + "</TD>\n");
		    			
		    			sbufXML.append("<TD>" + viewList.get(j).getQtaGrev()  + "</TD>\n");
		    			sbufXML.append("<TD>" + viewList.get(j).getFctGrev()  + "</TD>\n");
		    			sbufXML.append("<TD>" + viewList.get(j).getPfcGrev()  + "</TD>\n");
		    			sbufXML.append("<TD>" + viewList.get(j).getDiffGrev() + "</TD>\n");
		    			sbufXML.append("<TD>" + viewList.get(j).getBkgGrev()  + "</TD>\n");
		    			sbufXML.append("<TD>" + viewList.get(j).getPrefGrev() + "</TD>\n");
		    			
		    			sbufXML.append("<TD>" + viewList.get(j).getQtaGrpb()  + "</TD>\n");
		    			sbufXML.append("<TD>" + viewList.get(j).getFctGrpb()  + "</TD>\n");
		    			sbufXML.append("<TD>" + viewList.get(j).getPfcGrpb()  + "</TD>\n");
		    			sbufXML.append("<TD>" + viewList.get(j).getDiffGrpb() + "</TD>\n");
		    			sbufXML.append("<TD>" + viewList.get(j).getBkgGrpb()  + "</TD>\n");
		    			sbufXML.append("<TD>" + viewList.get(j).getPrefGrpb() + "</TD>\n");
		    			
		    			sbufXML.append("<TD>" + viewList.get(j).getPfcCm()  + "</TD>\n");
		    			sbufXML.append("<TD>" + viewList.get(j).getQtaCm()  + "</TD>\n");
		    			sbufXML.append("<TD>" + viewList.get(j).getFctCm()  + "</TD>\n");
		    			sbufXML.append("<TD>" + viewList.get(j).getDiffCm() + "</TD>\n");
		    			sbufXML.append("<TD>" + viewList.get(j).getBkgCm()  + "</TD>\n");
		    			sbufXML.append("<TD>" + viewList.get(j).getPrefCm() + "</TD>\n");
		    			
		    			sbufXML.append("<TD>" + viewList.get(j).getQtaCmb()  + "</TD>\n");
		    			sbufXML.append("<TD>" + viewList.get(j).getFctCmb()  + "</TD>\n");
		    			sbufXML.append("<TD>" + viewList.get(j).getPfcCmb()  + "</TD>\n");
		    			sbufXML.append("<TD>" + viewList.get(j).getDiffCmb() + "</TD>\n");
		    			sbufXML.append("<TD>" + viewList.get(j).getBkgCmb()  + "</TD>\n");
		    			sbufXML.append("<TD>" + viewList.get(j).getPrefCmb() + "</TD>\n");
			    			
			    		if(d < duration){
							j++;
						}
					}
			    	sbufXML.append("<TD></TD>\n");
			    	sbufXML.append("</TR>\n");
			    }
			    
			    for(int j=rowCountview-duration;j<rowCountview;j++) {//4.1
	//		    	level = Integer.parseInt(viewList.get(j).getLvl());
			    	
			    	sbufXML.append("<TR>\n");
	//		    	sbufXML.append("<TR LEVEL=\"" + level + "\">\n");
					sbufXML.append("<TD></TD>\n");
					sbufXML.append("<TD></TD>\n");
					sbufXML.append("<TD></TD>\n");
					
					for(int d = 1 ; d <= duration ; d++) {
						
						if(!viewList.get(j).getBsa().equals("")) {
			    			existsWeek[Integer.parseInt(viewList.get(j).getNum()) - 1] = !viewList.get(j).getBsa().equals("");
			    			
			    			sbufXML.append("<TD DATA-FORMAT=\"dfNone\" DATA-ALIGN=\"daCenter\">BSA</TD>\n");
			    			sbufXML.append("<TD>" + viewList.get(j).getBsa() + "</TD>\n");
			    			sbufXML.append("<TD DATA-FORMAT=\"dfNone\" DATA-ALIGN=\"daCenter\">L/F</TD>\n");
			    			sbufXML.append("<TD DATA-FORMAT=\"dfNone\">" + viewList.get(j).getLf() + "</TD>\n");
			    			sbufXML.append("<TD DATA-FORMAT=\"dfNone\"></TD>\n");
			    			sbufXML.append("<TD DATA-FORMAT=\"dfNone\"></TD>\n");
			    			
			    			for(int i = 1 ; i < items.length ; i++){
			    				sbufXML.append("<TD DATA-FORMAT=\"dfNone\" DATA-ALIGN=\"daCenter\">BSA</TD>\n");
			    				sbufXML.append("<TD DATA-FORMAT=\"dfNone\"></TD>\n");
			    				sbufXML.append("<TD DATA-FORMAT=\"dfNone\" DATA-ALIGN=\"daCenter\">L/F</TD>\n");
			    				sbufXML.append("<TD DATA-FORMAT=\"dfNone\"></TD>\n");
			    				sbufXML.append("<TD DATA-FORMAT=\"dfNone\"></TD>\n");
			    				sbufXML.append("<TD DATA-FORMAT=\"dfNone\"></TD>\n");
							}
						}
						if(d < duration){
							j++;
						}
					}
					sbufXML.append("<TD></TD>\n");
					sbufXML.append("</TR>\n");		
			    }//4.9
			}
			
			for(int i = 0 ; i < existsWeek.length ; i++) {
				if(existsWeek[i]){
					strWeek = strWeek + "|" + week[i];
					strFdTd = strFdTd + "|" + fdtd[i];
				}
			}
		} //소스 품질 수정 요청건
		
		sbufXML.append("</DATA>\n");
		sbufXML.append("<ETC-DATA>\n");
		sbufXML.append("<ETC KEY=\"week\">").append(strWeek.length()>0?strWeek.substring(1):"").append("</ETC>\n");
		sbufXML.append("<ETC KEY=\"fdtd\">").append(strFdTd.length()>0?strFdTd.substring(1):"").append("</ETC>\n");
		sbufXML.append("<ETC KEY=\"portv\">" + portv + "</ETC>\n");
		sbufXML.append("</ETC-DATA>\n");
		
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