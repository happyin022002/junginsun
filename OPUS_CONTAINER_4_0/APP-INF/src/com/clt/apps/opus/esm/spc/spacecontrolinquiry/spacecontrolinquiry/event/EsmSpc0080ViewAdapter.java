/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0080ViewAdapter.java
*@FileTitle : spacecontrolinquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.26
*@LastModifier : CHOI.Y.S
*@LastVersion : 1.0
* 2010.08.26 CHOI.Y.S
* 1.0 Creation
* 2010.08.26 최윤성 [CHM-201005492-01] RDR 실적 Summary 기능 개발 - 2010년 시스템 개발 계획
* 2010.09.16 이윤정 [CHM-201005916-01] Weekly L/F by Carrier 화면의 조회 결과 값에 따른 색상 변경 
* 2011.07.01 최윤성 [CHM-201111937-01] Space Utilization 화면 보완
*  - Total Weight 항목 추가
=========================================================*/
package com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.spc.common.common.vo.ConditionVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ComplexMainVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ETCVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlRDRSummaryListVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
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
public class EsmSpc0080ViewAdapter extends ViewAdapter{
	
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
		List<SearchSpaceControlRDRSummaryListVO> viewList = new ArrayList<SearchSpaceControlRDRSummaryListVO>();
		etc = comMain.getEtc();
		viewList = comMain.getSearchSpaceControlRDRSummaryListVO();
		
		ConditionVO condition = comMain.getConditionVO();
		
		int rowCountetc  = etc.size();
		int rowCountview = viewList.size();
		
		sbufXML.append("<DATA TOTAL=\""+rowCountview+"\">\n");
		
		int weekCnt    = 0;
		String[] week;
		String[] fdtd;
		String strWeek = "";
		String strFdTd = "";
		
		if (rowCountetc > 0 && etc != null) {//3.1
			weekCnt = rowCountetc;
			week    = new String[weekCnt];
			fdtd    = new String[weekCnt];
			
			StringBuffer sbWeek = new StringBuffer(); //소스 품질 수정 요청건
			StringBuffer sbFdTd = new StringBuffer(); //소스 품질 수정 요청건	
			
			for(int i = 0; i<rowCountetc ; i++){
				week[i] = JSPUtil.getNull(etc.get(i).getCostYr()) + JSPUtil.getNull(etc.get(i).getCostWk1());
				fdtd[i] = JSPUtil.getNull(etc.get(i).getSlsFmDt()) + "~" + JSPUtil.getNull(etc.get(i).getSlsToDt());
//				strWeek = strWeek + "|" + week[i];
//				strFdTd = strFdTd + "|" + fdtd[i];
				
				sbWeek.append("|").append(week[i]); //소스 품질 수정 요청건
				sbFdTd.append("|").append(fdtd[i]); //소스 품질 수정 요청건
			}
			
			strWeek = sbWeek.toString(); //소스 품질 수정 요청건
			strFdTd = sbFdTd.toString(); //소스 품질 수정 요청건
		}//3.9
		
		if (rowCountview > 0 && viewList != null) {//3.1
			int duration = Integer.parseInt(condition.getDuration());
			
			String[] typ = {"BSA", "FULL", "EMPTY", "TTL LOAD", "TTL WGT", "FULL LF", "TTL LF"};
			String rlane_cd   = "";
			String dir_cd     = "";
			String sub_trd_cd = "";
			String opr_cd     = "";
			
			for(int i =0 ; i < rowCountview ; i++){
				rlane_cd   = viewList.get(i).getRlaneCd();
				dir_cd     = viewList.get(i).getDirCd();
				sub_trd_cd = viewList.get(i).getSubTrdCd();
				opr_cd     = viewList.get(i).getOprCd();
				
				if((opr_cd.equals("VVD") || opr_cd.equals("ITEM"))) {
					if(!(rlane_cd.equals("TOTAL") && opr_cd.equals("VVD"))){
//						sbufXML.append("<TR MERGE=\"true\" BGCOLOR=\"" + (rlane_cd.equals("TOTAL")?(opr_cd.equals("ITEM")?(sub_trd_cd.equals("TOTAL")?"236,231,247":"247,231,236"):"232,255,198"):"232,255,198") + "\">\n");
 						sbufXML.append("<TR MERGE=\"true\" BGCOLOR=\"" + (opr_cd.equals("VVD")?"232,255,198":(opr_cd.equals("ITEM")?"247,231,236":"0,0,0")) + "\">\n"); ////2010.09.16 이윤정 [CHM-201005916-01] Weekly L/F by Carrier 화면의 조회 결과 값에 따른 색상 변경
						sbufXML.append("<TD>" + sub_trd_cd).append(rlane_cd.equals("TOTAL")?"":(" / " + rlane_cd.substring(0, 3))).append("</TD>\n");
						sbufXML.append("<TD></TD>\n");
						sbufXML.append("<TD></TD>\n");
						
						for(int w = 1 ; w <= duration ; w++){
							String temp = "";
							
							switch (w) {
								case 1:
									temp = viewList.get(i).getVvd1();
									break;
								case 2:
									temp = viewList.get(i).getVvd2();
									break;
								case 3:
									temp = viewList.get(i).getVvd3();
									break;
								case 4:
									temp = viewList.get(i).getVvd4();
									break;
								case 5:
									temp = viewList.get(i).getVvd5();
									break;
								case 6:
									temp = viewList.get(i).getVvd6();
									break;
								case 7:
									temp = viewList.get(i).getVvd7();
									break;
								case 8:
									temp = viewList.get(i).getVvd8();
									break;
								case 9:
									temp = viewList.get(i).getVvd9();
									break;
								case 10:
									temp = viewList.get(i).getVvd10();
									break;
								case 11:
									temp = viewList.get(i).getVvd11();
									break;
								case 12:
									temp = viewList.get(i).getVvd12();
									break;
								case 13:
									temp = viewList.get(i).getVvd13();
									break;
								case 14:
									temp = viewList.get(i).getVvd14();
									break;
								case 15:
									temp = viewList.get(i).getVvd15();
									break;
							}
							
							String vvd = JSPUtil.getNull(temp);
							for(int m = 1 ; m <= 1 ; m++){
								for(int t = 0 ; t < 7 ; t++){
									if(opr_cd.equals("VVD")){
										// Sub Title 부분에 VVD 입력.
										sbufXML.append("<TD DATA-FORMAT=\"dtNone\" DATA-ALIGN=\"daCenter\">" + vvd + "</TD>\n");
									} else {
										// Sub Title 부분에 Type 입력.
										sbufXML.append("<TD DATA-FORMAT=\"dtNone\" DATA-ALIGN=\"daCenter\">" + typ[t] + "</TD>\n");
									}
								}
							}
						}
						sbufXML.append("</TR>\n");
					}
				} else {
 					sbufXML.append("<TR BGCOLOR=\"" + (opr_cd.equals("TOTAL")?(rlane_cd.equals("TOTAL")?(dir_cd.equals("TOTAL")?"236,231,247":"247,231,236"):"236,231,247"):"0,0,0") + "\">\n"); //2010.09.16 이윤정 [CHM-201005916-01] Weekly L/F by Carrier 화면의 조회 결과 값에 따른 색상 변경
//					sbufXML.append("<TR BGCOLOR=\"" + (rlane_cd.equals("TOTAL")?(opr_cd.equals("TOTAL")?(sub_trd_cd.equals("TOTAL")?"236,231,247":"247,231,236"):""):"") + "\">\n");
					sbufXML.append("<TD BGCOLOR=\"" + (rlane_cd.equals("TOTAL")?(sub_trd_cd.equals("TOTAL")?"236,231,247":"247,231,236"):"") + "\">" + sub_trd_cd + (rlane_cd.equals("TOTAL")?"":(" / " + rlane_cd.substring(0, 3))) + "</TD>\n");
					sbufXML.append("<TD>" + (rlane_cd.equals("TOTAL")?(opr_cd.equals("TOTAL")?dir_cd:opr_cd):opr_cd) + "</TD>\n");
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
							case 1: // BSA, FULL, EMPTY, TTL_LOAD, TTL WT, FULL_LF, TTL_LF
								temp1 = viewList.get(i).getBsa1();
								temp2 = viewList.get(i).getFull1();
								temp3 = viewList.get(i).getEmpty1();
								temp4 = viewList.get(i).getTtlLoad1();
								temp5 = viewList.get(i).getTtlWgt1();
								temp6 = viewList.get(i).getFullLf1();
								temp7 = viewList.get(i).getTtlLf1();
								break;
							
							case 2:
								temp1 = viewList.get(i).getBsa2();
								temp2 = viewList.get(i).getFull2();
								temp3 = viewList.get(i).getEmpty2();
								temp4 = viewList.get(i).getTtlLoad2();
								temp5 = viewList.get(i).getTtlWgt2();
								temp6 = viewList.get(i).getFullLf2();
								temp7 = viewList.get(i).getTtlLf2();
								break;
							
							case 3:
								temp1 = viewList.get(i).getBsa3();
								temp2 = viewList.get(i).getFull3();
								temp3 = viewList.get(i).getEmpty3();
								temp4 = viewList.get(i).getTtlLoad3();
								temp5 = viewList.get(i).getTtlWgt3();
								temp6 = viewList.get(i).getFullLf3();
								temp7 = viewList.get(i).getTtlLf3();
								break;
							
							case 4:
								temp1 = viewList.get(i).getBsa4();
								temp2 = viewList.get(i).getFull4();
								temp3 = viewList.get(i).getEmpty4();
								temp4 = viewList.get(i).getTtlLoad4();
								temp5 = viewList.get(i).getTtlWgt4();
								temp6 = viewList.get(i).getFullLf4();
								temp7 = viewList.get(i).getTtlLf4();
								break;
							
							case 5:
								temp1 = viewList.get(i).getBsa5();
								temp2 = viewList.get(i).getFull5();
								temp3 = viewList.get(i).getEmpty5();
								temp4 = viewList.get(i).getTtlLoad5();
								temp5 = viewList.get(i).getTtlWgt5();
								temp6 = viewList.get(i).getFullLf5();
								temp7 = viewList.get(i).getTtlLf5();
								break;
							
							case 6:
								temp1 = viewList.get(i).getBsa6();
								temp2 = viewList.get(i).getFull6();
								temp3 = viewList.get(i).getEmpty6();
								temp4 = viewList.get(i).getTtlLoad6();
								temp5 = viewList.get(i).getTtlWgt6();
								temp6 = viewList.get(i).getFullLf6();
								temp7 = viewList.get(i).getTtlLf6();
								break;
							
							case 7:
								temp1 = viewList.get(i).getBsa7();
								temp2 = viewList.get(i).getFull7();
								temp3 = viewList.get(i).getEmpty7();
								temp4 = viewList.get(i).getTtlLoad7();
								temp5 = viewList.get(i).getTtlWgt7();
								temp6 = viewList.get(i).getFullLf7();
								temp7 = viewList.get(i).getTtlLf7();
								break;
							
							case 8:
								temp1 = viewList.get(i).getBsa8();
								temp2 = viewList.get(i).getFull8();
								temp3 = viewList.get(i).getEmpty8();
								temp4 = viewList.get(i).getTtlLoad8();
								temp5 = viewList.get(i).getTtlWgt8();
								temp6 = viewList.get(i).getFullLf8();
								temp7 = viewList.get(i).getTtlLf8();
								break;
							
							case 9:
								temp1 = viewList.get(i).getBsa9();
								temp2 = viewList.get(i).getFull9();
								temp3 = viewList.get(i).getEmpty9();
								temp4 = viewList.get(i).getTtlLoad9();
								temp5 = viewList.get(i).getTtlWgt9();
								temp6 = viewList.get(i).getFullLf9();
								temp7 = viewList.get(i).getTtlLf9();
								break;
							
							case 10:
								temp1 = viewList.get(i).getBsa10();
								temp2 = viewList.get(i).getFull10();
								temp3 = viewList.get(i).getEmpty10();
								temp4 = viewList.get(i).getTtlLoad10();
								temp5 = viewList.get(i).getTtlWgt10();
								temp6 = viewList.get(i).getFullLf10();
								temp7 = viewList.get(i).getTtlLf10();
								break;
							
							case 11:
								temp1 = viewList.get(i).getBsa11();
								temp2 = viewList.get(i).getFull11();
								temp3 = viewList.get(i).getEmpty11();
								temp4 = viewList.get(i).getTtlLoad11();
								temp5 = viewList.get(i).getTtlWgt11();
								temp6 = viewList.get(i).getFullLf11();
								temp7 = viewList.get(i).getTtlLf11();
								break;
							
							case 12:
								temp1 = viewList.get(i).getBsa12();
								temp2 = viewList.get(i).getFull12();
								temp3 = viewList.get(i).getEmpty12();
								temp4 = viewList.get(i).getTtlLoad12();
								temp5 = viewList.get(i).getTtlWgt12();
								temp6 = viewList.get(i).getFullLf12();
								temp7 = viewList.get(i).getTtlLf12();
								break;
							
							case 13:
								temp1 = viewList.get(i).getBsa13();
								temp2 = viewList.get(i).getFull13();
								temp3 = viewList.get(i).getEmpty13();
								temp4 = viewList.get(i).getTtlLoad13();
								temp5 = viewList.get(i).getTtlWgt13();
								temp6 = viewList.get(i).getFullLf13();
								temp7 = viewList.get(i).getTtlLf13();
								break;
							
							case 14:
								temp1 = viewList.get(i).getBsa14();
								temp2 = viewList.get(i).getFull14();
								temp3 = viewList.get(i).getEmpty14();
								temp4 = viewList.get(i).getTtlLoad14();
								temp5 = viewList.get(i).getTtlWgt14();
								temp6 = viewList.get(i).getFullLf14();
								temp7 = viewList.get(i).getTtlLf14();
								break;
							
							case 15:
								temp1 = viewList.get(i).getBsa15();
								temp2 = viewList.get(i).getFull15();
								temp3 = viewList.get(i).getEmpty15();
								temp4 = viewList.get(i).getTtlLoad15();
								temp5 = viewList.get(i).getTtlWgt15();
								temp6 = viewList.get(i).getFullLf15();
								temp7 = viewList.get(i).getTtlLf15();
								break;
						}
						
						sbufXML.append("<TD>" + temp1 + "</TD>\n");
						sbufXML.append("<TD>" + temp2 + "</TD>\n");
						sbufXML.append("<TD>" + temp3 + "</TD>\n");
						sbufXML.append("<TD>" + temp4 + "</TD>\n");
						sbufXML.append("<TD>" + temp5 + "</TD>\n");
						sbufXML.append("<TD>" + temp6 + "</TD>\n");
						sbufXML.append("<TD>" + temp7 + "</TD>\n");
					}
					
					sbufXML.append("</TR>\n");
				}
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