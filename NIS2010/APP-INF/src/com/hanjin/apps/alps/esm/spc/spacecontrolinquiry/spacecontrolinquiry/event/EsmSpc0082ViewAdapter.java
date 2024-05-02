/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0082ViewAdapter.java
*@FileTitle : L/F Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.19
*@LastModifier : CHOI.Y.S
*@LastVersion : 1.0
* 2010.10.19 CHOI.Y.S
* 1.0 Creation
* 2010.10.19 최윤성 [CHM-201006585-01] 2010년 연간개발계획 - full+empty L/F summary 화면 개발.
* 2011.01.19 최윤성 [CHM-201108422-01] L/F Summary 화면 하드코딩 및 보완 요청
*  - IAS/IP sub-trade 에 한하여 BSA 는 Full BKG volume 과 동일하게 보여지도록 수정
*  - IAS 한하여 Empty 값은 From ~ To 의 Conti 가 모두 A 인 값만 보이고 나머지는 0.
*  - 화면에 주차별로 display 된 데이터의 총합을 보여주는 열 추가.
* 2011.02.10 이석준[CHM-201108799-01] UI에서 Duration을 2이상 주고 조회시 Total Load Factor가 첫번째것만 나와서
*  - 해당 function 변경  : viewList.get(i).getTtlLf1() ==> viewList.get(i).getTTtlLf()변경
* 2014.07.02 김용습 R4J 패치 사전 작업
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ComplexMainVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ETCVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlLFSummaryListVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
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
public class EsmSpc0082ViewAdapter extends ViewAdapter{
	
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
		List<SearchSpaceControlLFSummaryListVO> viewList = new ArrayList<SearchSpaceControlLFSummaryListVO>();
		etc = comMain.getEtc();
		viewList = comMain.getSearchSpaceControlLFSummaryListVO();
		
		ConditionVO condition = comMain.getConditionVO();
		
		int rowCountetc  = etc.size();
		int rowCountview = viewList.size();
		
		sbufXML.append("<DATA TOTAL=\""+rowCountview+"\">\n");
		
		int weekCnt    = 0;
		String[] week  = null;
		String[] fdtd  = null;
		String strWeek = "";
		String strFdTd = "";
		
		//2014.07.02 김용습 R4J 패치 사전 작업
      	StringBuffer out1 = new StringBuffer();
    	StringBuffer out2 = new StringBuffer();
		
		if (rowCountetc > 0 && etc != null) {//3.1
			weekCnt = rowCountetc;
			week    = new String[weekCnt];
			fdtd    = new String[weekCnt];
			
			for(int i = 0; i<rowCountetc ; i++){
				week[i] = JSPUtil.getNull(etc.get(i).getCostYr()) + JSPUtil.getNull(etc.get(i).getCostWk1());
				fdtd[i] = JSPUtil.getNull(etc.get(i).getSlsFmDt()) + "~" + JSPUtil.getNull(etc.get(i).getSlsToDt());
				
				//2014.07.02 김용습 R4J 패치 사전 작업
				//strWeek = strWeek + "|" + week[i];
				//strFdTd = strFdTd + "|" + fdtd[i];
				out1.append("|").append(week[i]);
				out2.append("|").append(fdtd[i]);
			}
			//2014.07.02 김용습 R4J 패치 사전 작업
			strWeek = out1.toString();
			strFdTd = out2.toString();
		}//3.9
		
		if (rowCountview > 0 && viewList != null) {//3.1
			int duration = Integer.parseInt(condition.getDuration());
			
//			String[] typ = {"BSA", "FULL", "EMPTY", "TTL LOAD", "FULL LF", "TTL LF"};
			String rlane_cd   = "";
			String dir_cd     = "";
			String sub_trd_cd = "";
			
			for(int i =0 ; i < rowCountview ; i++){
				rlane_cd   = viewList.get(i).getRlaneCd();
				dir_cd     = viewList.get(i).getDirCd();
				sub_trd_cd = viewList.get(i).getSubTrdCd();
				
				// VVD 출력 부분
//				if(!(rlane_cd.equals("TOTAL"))){
//					sbufXML.append("<TR MERGE=\"true\" BGCOLOR=\"232,255,198\">\n");
//					sbufXML.append("<TD>" + sub_trd_cd).append(rlane_cd.equals("TOTAL")?"":(" / " + rlane_cd.substring(0, 3))).append("</TD>\n");
//					sbufXML.append("<TD></TD>\n");
//					
//					for(int w = 1 ; w <= duration ; w++){
//						String temp = "";
//						
//						switch (w) {
//							case 1:
//								temp = viewList.get(i).getVvd1();
//								break;
//							case 2:
//								temp = viewList.get(i).getVvd2();
//								break;
//							case 3:
//								temp = viewList.get(i).getVvd3();
//								break;
//							case 4:
//								temp = viewList.get(i).getVvd4();
//								break;
//							case 5:
//								temp = viewList.get(i).getVvd5();
//								break;
//							case 6:
//								temp = viewList.get(i).getVvd6();
//								break;
//							case 7:
//								temp = viewList.get(i).getVvd7();
//								break;
//							case 8:
//								temp = viewList.get(i).getVvd8();
//								break;
//							case 9:
//								temp = viewList.get(i).getVvd9();
//								break;
//							case 10:
//								temp = viewList.get(i).getVvd10();
//								break;
//							case 11:
//								temp = viewList.get(i).getVvd11();
//								break;
//							case 12:
//								temp = viewList.get(i).getVvd12();
//								break;
//							case 13:
//								temp = viewList.get(i).getVvd13();
//								break;
//							case 14:
//								temp = viewList.get(i).getVvd14();
//								break;
//							case 15:
//								temp = viewList.get(i).getVvd15();
//								break;
//						}
//						
//						for(int m = 1 ; m <= 1 ; m++){
//							for(int t = 0 ; t < 6 ; t++){
//								sbufXML.append("<TD DATA-FORMAT=\"dtNone\" DATA-ALIGN=\"daCenter\">" + JSPUtil.getNull(temp) + "</TD>\n");
//							}
//						}
//					}
//					sbufXML.append("</TR>\n");
//				}
				
//				// Sub Title 부분 - BSA, FULL, EMPTY, TTL LOAD, FULL LF, TTL LF
//				sbufXML.append("<TR MERGE=\"true\" BGCOLOR=\"" + (sub_trd_cd.equals("TOTAL")?"236,231,247":(rlane_cd.equals("TOTAL")?"247,231,236":"232,255,198")) + "\">\n");
//				sbufXML.append("<TD>" + sub_trd_cd).append(rlane_cd.equals("TOTAL")?"":(" / " + rlane_cd.substring(0, 3))).append("</TD>\n");
//				sbufXML.append("<TD></TD>\n");
//				
//				for(int w = 1 ; w <= duration ; w++){
//					for(int m = 1 ; m <= 1 ; m++){
//						for(int t = 0 ; t < 6 ; t++){
//							sbufXML.append("<TD DATA-FORMAT=\"dtNone\" DATA-ALIGN=\"daCenter\">" + typ[t] + "</TD>\n");
//						}
//					}
//				}
//				sbufXML.append("</TR>\n");
				
				sbufXML.append("<TR BGCOLOR=\"" + (sub_trd_cd.equals("TOTAL")?"236,231,247":(rlane_cd.equals("TOTAL")?"247,231,236":"0,0,0")) + "\">\n");
				sbufXML.append("<TD BGCOLOR=\"" + (rlane_cd.equals("TOTAL")?(sub_trd_cd.equals("TOTAL")?"236,231,247":"247,231,236"):"") + "\">" + sub_trd_cd + (rlane_cd.equals("TOTAL")?"":(" / " + rlane_cd.substring(0, 3))) + "</TD>\n");
				sbufXML.append("<TD></TD>\n");
				
				for(int w = 1 ; w <= duration ; w++) {
					String temp1  = "";
					String temp2  = "";
					String temp3  = "";
					String temp4  = "";
					String temp5  = "";
					String temp6  = "";
					String temp7  = "";
					
					switch (w) {
						case 1: // BSA, FULL, EMPTY, TTL_LOAD, FULL_LF, TTL_LF
							temp1 = viewList.get(i).getBsa1();
							temp2 = viewList.get(i).getFull1();
							temp3 = viewList.get(i).getEmpty1();
							temp4 = viewList.get(i).getTtlLoad1();
							temp5 = viewList.get(i).getFullLf1();
							temp6 = viewList.get(i).getTtlLf1();
							temp7 = viewList.get(i).getTtlWgtLf1();
							break;
						
						case 2:
							temp1 = viewList.get(i).getBsa2();
							temp2 = viewList.get(i).getFull2();
							temp3 = viewList.get(i).getEmpty2();
							temp4 = viewList.get(i).getTtlLoad2();
							temp5 = viewList.get(i).getFullLf2();
							temp6 = viewList.get(i).getTtlLf2();
							temp7 = viewList.get(i).getTtlWgtLf2();
							break;
						
						case 3:
							temp1 = viewList.get(i).getBsa3();
							temp2 = viewList.get(i).getFull3();
							temp3 = viewList.get(i).getEmpty3();
							temp4 = viewList.get(i).getTtlLoad3();
							temp5 = viewList.get(i).getFullLf3();
							temp6 = viewList.get(i).getTtlLf3();
							temp7 = viewList.get(i).getTtlWgtLf3();
							break;
						
						case 4:
							temp1 = viewList.get(i).getBsa4();
							temp2 = viewList.get(i).getFull4();
							temp3 = viewList.get(i).getEmpty4();
							temp4 = viewList.get(i).getTtlLoad4();
							temp5 = viewList.get(i).getFullLf4();
							temp6 = viewList.get(i).getTtlLf4();
							temp7 = viewList.get(i).getTtlWgtLf4();
							break;
						
						case 5:
							temp1 = viewList.get(i).getBsa5();
							temp2 = viewList.get(i).getFull5();
							temp3 = viewList.get(i).getEmpty5();
							temp4 = viewList.get(i).getTtlLoad5();
							temp5 = viewList.get(i).getFullLf5();
							temp6 = viewList.get(i).getTtlLf5();
							temp7 = viewList.get(i).getTtlWgtLf5();
							break;
						
						case 6:
							temp1 = viewList.get(i).getBsa6();
							temp2 = viewList.get(i).getFull6();
							temp3 = viewList.get(i).getEmpty6();
							temp4 = viewList.get(i).getTtlLoad6();
							temp5 = viewList.get(i).getFullLf6();
							temp6 = viewList.get(i).getTtlLf6();
							temp7 = viewList.get(i).getTtlWgtLf6();
							break;
						
						case 7:
							temp1 = viewList.get(i).getBsa7();
							temp2 = viewList.get(i).getFull7();
							temp3 = viewList.get(i).getEmpty7();
							temp4 = viewList.get(i).getTtlLoad7();
							temp5 = viewList.get(i).getFullLf7();
							temp6 = viewList.get(i).getTtlLf7();
							temp7 = viewList.get(i).getTtlWgtLf7();
							break;
						
						case 8:
							temp1 = viewList.get(i).getBsa8();
							temp2 = viewList.get(i).getFull8();
							temp3 = viewList.get(i).getEmpty8();
							temp4 = viewList.get(i).getTtlLoad8();
							temp5 = viewList.get(i).getFullLf8();
							temp6 = viewList.get(i).getTtlLf8();
							temp7 = viewList.get(i).getTtlWgtLf8();
							break;
						
						case 9:
							temp1 = viewList.get(i).getBsa9();
							temp2 = viewList.get(i).getFull9();
							temp3 = viewList.get(i).getEmpty9();
							temp4 = viewList.get(i).getTtlLoad9();
							temp5 = viewList.get(i).getFullLf9();
							temp6 = viewList.get(i).getTtlLf9();
							temp7 = viewList.get(i).getTtlWgtLf9();
							break;
						
						case 10:
							temp1 = viewList.get(i).getBsa10();
							temp2 = viewList.get(i).getFull10();
							temp3 = viewList.get(i).getEmpty10();
							temp4 = viewList.get(i).getTtlLoad10();
							temp5 = viewList.get(i).getFullLf10();
							temp6 = viewList.get(i).getTtlLf10();
							temp7 = viewList.get(i).getTtlWgtLf10();
							break;
						
						case 11:
							temp1 = viewList.get(i).getBsa11();
							temp2 = viewList.get(i).getFull11();
							temp3 = viewList.get(i).getEmpty11();
							temp4 = viewList.get(i).getTtlLoad11();
							temp5 = viewList.get(i).getFullLf11();
							temp6 = viewList.get(i).getTtlLf11();
							temp7 = viewList.get(i).getTtlWgtLf11();
							break;
						
						case 12:
							temp1 = viewList.get(i).getBsa12();
							temp2 = viewList.get(i).getFull12();
							temp3 = viewList.get(i).getEmpty12();
							temp4 = viewList.get(i).getTtlLoad12();
							temp5 = viewList.get(i).getFullLf12();
							temp6 = viewList.get(i).getTtlLf12();
							temp7 = viewList.get(i).getTtlWgtLf12();
							break;
						
						case 13:
							temp1 = viewList.get(i).getBsa13();
							temp2 = viewList.get(i).getFull13();
							temp3 = viewList.get(i).getEmpty13();
							temp4 = viewList.get(i).getTtlLoad13();
							temp5 = viewList.get(i).getFullLf13();
							temp6 = viewList.get(i).getTtlLf13();
							temp7 = viewList.get(i).getTtlWgtLf13();
							break;
						
						case 14:
							temp1 = viewList.get(i).getBsa14();
							temp2 = viewList.get(i).getFull14();
							temp3 = viewList.get(i).getEmpty14();
							temp4 = viewList.get(i).getTtlLoad14();
							temp5 = viewList.get(i).getFullLf14();
							temp6 = viewList.get(i).getTtlLf14();
							temp7 = viewList.get(i).getTtlWgtLf14();
							break;
						
						case 15:
							temp1 = viewList.get(i).getBsa15();
							temp2 = viewList.get(i).getFull15();
							temp3 = viewList.get(i).getEmpty15();
							temp4 = viewList.get(i).getTtlLoad15();
							temp5 = viewList.get(i).getFullLf15();
							temp6 = viewList.get(i).getTtlLf15();
							temp7 = viewList.get(i).getTtlWgtLf15();
							break;
					}
					
					sbufXML.append("<TD>" + temp1 + "</TD>\n");
					sbufXML.append("<TD>" + temp2 + "</TD>\n");
					sbufXML.append("<TD>" + temp3 + "</TD>\n");
					sbufXML.append("<TD>" + temp4 + "</TD>\n");
					sbufXML.append("<TD>" + temp5 + "%</TD>\n");
					sbufXML.append("<TD>" + temp6 + "%</TD>\n");
					sbufXML.append("<TD>" + temp7 + "%</TD>\n");
				}
				
				sbufXML.append("<TD>" + viewList.get(i).getTBsa()    + "</TD>\n");
				sbufXML.append("<TD>" + viewList.get(i).getTFull()   + "</TD>\n");
				sbufXML.append("<TD>" + viewList.get(i).getTEmpty()  + "</TD>\n");
				sbufXML.append("<TD>" + viewList.get(i).getTLoad()   + "</TD>\n");
				sbufXML.append("<TD>" + viewList.get(i).getTFullLf() + "%</TD>\n");
				sbufXML.append("<TD>" + viewList.get(i).getTTtlLf()  + "%</TD>\n");
				sbufXML.append("<TD>" + viewList.get(i).gettTtlWgtLf()  + "%</TD>\n");
				
				sbufXML.append("</TR>\n");
			}
		} else {		//3.9 데이타가 없는 경우
			strWeek = strWeek;
			strFdTd = strFdTd;
		}
		
		sbufXML.append("</DATA>\n");
		sbufXML.append("<ETC-DATA>\n");
		sbufXML.append("<ETC KEY=\"week\">").append(strWeek.length()>0?strWeek.substring(1):"").append("</ETC>\n");
		sbufXML.append("<ETC KEY=\"fdtd\">").append(strFdTd.length()>0?strFdTd.substring(1):"").append("</ETC>\n");
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