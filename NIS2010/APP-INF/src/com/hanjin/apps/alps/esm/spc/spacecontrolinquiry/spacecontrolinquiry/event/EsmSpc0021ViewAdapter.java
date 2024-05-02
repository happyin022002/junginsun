/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0021ViewAdapter.java
*@FileTitle : spacecontrolinquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.13 한상훈
* 1.0 Creation
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2013.12.19 신자영 [선처리] daily forecast status Duration2 조건 추가
* 2014.06.17 신자영 [CHM-201430603] FCST comparison 메뉴 일부 개선 요청
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ComplexMainVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ETCVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiry021FcastPortViewListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryConditionVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.layer.event.EventResponse;

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
log.debug("\ncom.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0021ViewAdapter");		
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
		String[] week = null;
		String[] fdtd = null;
		boolean[] existsWeek = null;
		String strWeek = "";
		String strFdTd = "";
		String portv   = condition.getChkview();
		// duration 선택에 따른 보여주기 변경
		int from = Integer.parseInt(condition.getDuration2From());
		int to = Integer.parseInt(condition.getDuration2To());
		int duration_cnt = to - from;

		if (rowCountetc>0 && etc != null) {//3.1				
			weekCnt = rowCountetc;
			week    = new String[weekCnt];
			fdtd    = new String[weekCnt];
			existsWeek = new boolean[weekCnt];
			
			for(int i = 0;i<rowCountetc;i++) {
				week[i] = JSPUtil.getNull(etc.get(i).getCostYr()) + JSPUtil.getNull(etc.get(i).getCostWk1());
				fdtd[i] = JSPUtil.getNull(etc.get(i).getSlsFmDt()) + "~"+JSPUtil.getNull(etc.get(i).getSlsToDt());
//				i = i + 1;
			}//4.9
		}
		
		if (rowCountview>0 && viewList != null) {//3.1
//			String[] items   = {"Load", "Grev", "Grpb", "Cm", "Cmb"};
//			String[] items   = {"Load"};
//			String[] targets = {"Qta", "Fct", "Pfc", "Diff", "Bkg", "Pref"};
			int duration = Integer.parseInt(condition.getDuration());
		    int level    = 0;				
		    
		    for(int j=0;j<rowCountview;j++){ // while (rowSet.next()) {//4.1
		    	// 2014.05.30 VVD,LANE별 BSA,LF추가 요건에 따라 r_num으로 row 표현 변경  -->1:기존 data 2:LANE별 BSA 3:
		    	
		    		level = Integer.parseInt(viewList.get(j).getLvl());//level = rowSet.getInt("lvl");
		    		// 2014.05.29 LANE별 sum 추가, Lane Total의 경우 컬럼명 수정
		    		// r_Num에 따라 구별 1:보통 데이타 2:TOTAL 3:LANE VVD
		    		if(viewList.get(j).getRNum().equals("3")){ //VVD
		    			sbufXML.append("<TR LEVEL=\"" + level + "\"  MERGE=\"TRUE\">\n");
		    		}else{
		    			sbufXML.append("<TR LEVEL=\"" + level + "\" >\n");
		    		}
		    		
		    		if(viewList.get(j).getRNum().equals("3")){ 
		    			sbufXML.append("<TD BGCOLOR=\"223,232,247\" >" +"LANE VVD"+ "</TD>\n");  //VVD
		    			sbufXML.append("<TD BGCOLOR=\"223,232,247\" ></TD>\n");
		    		}else if(viewList.get(j).getRlaneCd().equals("")){
		    			sbufXML.append("<TD>" +"TOTAL"+ "</TD>\n");  //전체 TOTAL
		    			sbufXML.append("<TD></TD>\n");
		    		
		    		}else if(!viewList.get(j).getRlaneCd().equals("") && viewList.get(j).getAqCd().equals("TOTAL")){ //전체 TOTAL
		    			sbufXML.append("<TD>" +"LANE TOTAL"+ "</TD>\n");
		    			sbufXML.append("<TD></TD>\n");
		    		}else{
		    			sbufXML.append("<TD>" + viewList.get(j).getRlaneCd() + "</TD>\n");

		    			if(viewList.get(j).getRNum().equals("3")){
		    				sbufXML.append("<TD BGCOLOR=\"223,232,247\" ></TD>\n");
		    			}else{
		    				sbufXML.append("<TD>" + viewList.get(j).getAqCd()  + "</TD>\n");
		    			}
		    		}
		    		if(viewList.get(j).getRNum().equals("3")){
		    			sbufXML.append("<TD BGCOLOR=\"223,232,247\" ></TD>\n");
		    			sbufXML.append("<TD BGCOLOR=\"223,232,247\" ></TD>\n");
		    		}else{
		    		sbufXML.append("<TD>" + viewList.get(j).getOfcCd() + "</TD>\n");
		    		sbufXML.append("<TD>" + viewList.get(j).getRNum() + "</TD>\n");
		    		}
		    		sbufXML.append("<TD></TD>\n");
		    	
		    		for(int d = 1 ; d <= duration ; d++){
		    			if(!viewList.get(j).getBsa().equals("")){
		    				
		    				if(viewList.get(j).getRNum().equals("3")){ //VVD
				    			sbufXML.append("<TD BGCOLOR=\"223,232,247\" DATA-FORMAT=\"dfNone\" DATA-ALIGN=\"daCenter\">" + viewList.get(j).getVvd() + "</TD>\n");
				    			sbufXML.append("<TD BGCOLOR=\"223,232,247\" DATA-FORMAT=\"dfNone\" DATA-ALIGN=\"daCenter\">" + viewList.get(j).getVvd() + "</TD>\n");
				    			sbufXML.append("<TD BGCOLOR=\"223,232,247\" DATA-FORMAT=\"dfNone\" DATA-ALIGN=\"daCenter\">" + viewList.get(j).getVvd() + "</TD>\n");
			    				// 2013.12.09 Day add 2~3 cnt = 1		    			
				    			if(duration_cnt > 0 ){
				    				sbufXML.append("<TD BGCOLOR=\"223,232,247\" DATA-FORMAT=\"dfNone\" DATA-ALIGN=\"daCenter\">" + viewList.get(j).getVvd() + "</TD>\n");
				    			}
				    			if(duration_cnt > 1 ){
				    				sbufXML.append("<TD BGCOLOR=\"223,232,247\" DATA-FORMAT=\"dfNone\" DATA-ALIGN=\"daCenter\">" + viewList.get(j).getVvd() + "</TD>\n");
				    			}
				    			if(duration_cnt > 2 ){
				    				sbufXML.append("<TD BGCOLOR=\"223,232,247\" DATA-FORMAT=\"dfNone\" DATA-ALIGN=\"daCenter\">" + viewList.get(j).getVvd() + "</TD>\n");
				    			}
				    			if(duration_cnt > 3 ){
				    				sbufXML.append("<TD BGCOLOR=\"223,232,247\" DATA-FORMAT=\"dfNone\" DATA-ALIGN=\"daCenter\">" + viewList.get(j).getVvd() + "</TD>\n");
				    			}
				    			if(duration_cnt > 4 ){
				    				sbufXML.append("<TD BGCOLOR=\"223,232,247\" DATA-FORMAT=\"dfNone\" DATA-ALIGN=\"daCenter\">" + viewList.get(j).getVvd() + "</TD>\n");
				    			}
				    			sbufXML.append("<TD BGCOLOR=\"223,232,247\" DATA-FORMAT=\"dfNone\" DATA-ALIGN=\"daCenter\">" + viewList.get(j).getVvd() + "</TD>\n");
				    			sbufXML.append("<TD BGCOLOR=\"223,232,247\" DATA-FORMAT=\"dfNone\" DATA-ALIGN=\"daCenter\">" + viewList.get(j).getVvd() + "</TD>\n");
				    			sbufXML.append("<TD BGCOLOR=\"223,232,247\" DATA-FORMAT=\"dfNone\" DATA-ALIGN=\"daCenter\">" + viewList.get(j).getVvd() + "</TD>\n");
		    				}else if(viewList.get(j).getRNum().equals("1")){// original form
			    				sbufXML.append("<TD>" + viewList.get(j).getQtaLoad()  + "</TD>\n");
			    				sbufXML.append("<TD>" + viewList.get(j).getFctLoad()  + "</TD>\n");
			    				sbufXML.append("<TD>" + viewList.get(j).getPfcLoad()  + "</TD>\n");
			    				// 2013.12.09 Day add 2~3 cnt = 1		    			
			    				if(duration_cnt > 0 ){
			    					sbufXML.append("<TD>" + viewList.get(j).getPfcLoad2()  + "</TD>\n");
			    				}
			    				if(duration_cnt > 1 ){
			    					sbufXML.append("<TD>" + viewList.get(j).getPfcLoad3()  + "</TD>\n");
			    				}
			    				if(duration_cnt > 2 ){
			    					sbufXML.append("<TD>" + viewList.get(j).getPfcLoad4()  + "</TD>\n");
			    				}
			    				if(duration_cnt > 3 ){
			    					sbufXML.append("<TD>" + viewList.get(j).getPfcLoad5()  + "</TD>\n");
			    				}
			    				if(duration_cnt > 4 ){
			    					sbufXML.append("<TD>" + viewList.get(j).getPfcLoad6()  + "</TD>\n");
			    				}
			    				sbufXML.append("<TD>" + viewList.get(j).getDiffLoad() + "</TD>\n");
			    				sbufXML.append("<TD>" + viewList.get(j).getBkgLoad()  + "</TD>\n");
			    				sbufXML.append("<TD>" + viewList.get(j).getPrefLoad() + "</TD>\n");
		    				}else if(viewList.get(j).getRNum().equals("2")){// LANE BSA,L/F
				    			sbufXML.append("<TD DATA-FORMAT=\"dfNone\" DATA-ALIGN=\"daCenter\">BSA</TD>\n");
				    			sbufXML.append("<TD>" + viewList.get(j).getBsa() + "</TD>\n");
				    			sbufXML.append("<TD DATA-FORMAT=\"dfNone\"></TD>\n");
			    				// 2013.12.09 Day add 2~3 cnt = 1		    			
				    			if(duration_cnt > 0 ){
				    				sbufXML.append("<TD DATA-FORMAT=\"dfNone\"></TD>\n");
				    			}
				    			if(duration_cnt > 1 ){
				    				sbufXML.append("<TD DATA-FORMAT=\"dfNone\"></TD>\n");
				    			}
				    			if(duration_cnt > 2 ){
				    				sbufXML.append("<TD DATA-FORMAT=\"dfNone\"></TD>\n");
				    			}
				    			if(duration_cnt > 3 ){
				    				sbufXML.append("<TD DATA-FORMAT=\"dfNone\"></TD>\n");
				    			}
				    			if(duration_cnt > 4 ){
				    				sbufXML.append("<TD DATA-FORMAT=\"dfNone\"></TD>\n");
				    			}
				    			sbufXML.append("<TD DATA-FORMAT=\"dfNone\"></TD>\n");
				    			sbufXML.append("<TD DATA-FORMAT=\"dfNone\" DATA-ALIGN=\"daCenter\">L/F</TD>\n");
				    			sbufXML.append("<TD DATA-FORMAT=\"dfNone\">" + viewList.get(j).getLf() + "</TD>\n");
		    				}
		    			}
		    		if(d < duration){
						j++;
					}
				}
		    	sbufXML.append("</TR>\n");
		    	
		    	

		    }
		    
		    // 여기까지 
		    
		    
		    int k = rowCountview-duration;
		    log.debug("\n***************rowCountview = " + rowCountview);
		    log.debug("\n***************rowCountview-duration = " + k);
		    for(int j=rowCountview-duration;j<rowCountview;j++) { 
		    	level = Integer.parseInt(viewList.get(j).getLvl());
				for(int d = 1 ; d <= duration ; d++) {
					
					if(!viewList.get(j).getBsa().equals("")) {
		    			existsWeek[Integer.parseInt(viewList.get(j).getNum()) - 1] = !viewList.get(j).getBsa().equals("");
					}
					if(d < duration){
						j++;
					}
				}	
		    } //4.9
		}
		if(existsWeek != null){
			for(int i = 0 ; i < existsWeek.length ; i++) {
				if(existsWeek[i]){
					strWeek = strWeek + "|" + week[i];
					strFdTd = strFdTd + "|" + fdtd[i];
				}
			}	
		}
		
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