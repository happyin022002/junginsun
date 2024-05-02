/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmSpc0021ViewAdapter2.java
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
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiry021AllocPortViewListVO;
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
public class EsmSpc0021ViewAdapter2 extends ViewAdapter{
	
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
		List<SearchSpaceControlInquiry021AllocPortViewListVO> viewList = new ArrayList<SearchSpaceControlInquiry021AllocPortViewListVO>();
		etc = comMain.getEtc();
		viewList = comMain.getInquiry021AllocPortViewListVO();
		
		SearchSpaceControlInquiryConditionVO condition = comMain.getCondition();
		
		int rowCountetc  = etc.size();
		int rowCountview = viewList.size();
		
		sbufXML.append("<DATA TOTAL=\""+rowCountview+"\">\n");
		
		int weekCnt    = 0;
		String[] week;
		String[] fdtd;
		String strWeek = "";
		String strFdTd = "";
		String portv   = condition.getChkview();
		
		if (rowCountetc > 0 && etc != null) {//3.1
			weekCnt = rowCountetc;
			week    = new String[weekCnt];
			fdtd    = new String[weekCnt];
			
			StringBuffer sbWeek = new StringBuffer(); //소스 품질 수정 요청건
			StringBuffer sbFdTd = new StringBuffer(); //소스 품질 수정 요청건			
			
			for(int i = 0; i<rowCountetc ; i++){
				week[i] = JSPUtil.getNull(etc.get(i).getCostYr()) + JSPUtil.getNull(etc.get(i).getCostWk1());
				fdtd[i] = JSPUtil.getNull(etc.get(i).getSlsFmDt()) + "~" + JSPUtil.getNull(etc.get(i).getSlsToDt());
				//strWeek = strWeek + "|" + week[i];
				//strFdTd = strFdTd + "|" + fdtd[i];
				
				sbWeek.append("|").append(week[i]); //소스 품질 수정 요청건
				sbFdTd.append("|").append(fdtd[i]); //소스 품질 수정 요청건
			}
			
			strWeek = sbWeek.toString(); //소스 품질 수정 요청건
			strFdTd = sbFdTd.toString(); //소스 품질 수정 요청건
		}//3.9
		
		if (rowCountview > 0 && viewList != null) {//3.1
			int duration = Integer.parseInt(condition.getDuration());
			int level    = 0;
			
			String rlane_cd   = "";
			String dir_cd     = "";
			String sub_trd_cd = "";
			String aq_cd      = "";
			String ofc_cd     = "";
			int row_cnt       = 0;
//			int dummy         = 0;
			double[] tbsa   = {0, 0, 0, 0, 0, 0, 0};
			double[] sbsa   = {0, 0, 0, 0, 0, 0, 0};
			double[] bsa    = new double[duration+1];
			double[][] fct  = new double[duration+1][6];
			double[][] sfct = new double[duration+1][6];
			double[][] tfct = new double[duration+1][6];
			
			for(int i =0 ; i < rowCountview ; i++){
				rlane_cd   = viewList.get(i).getRlaneCd();
				dir_cd     = viewList.get(i).getDirCd();
				sub_trd_cd = viewList.get(i).getSubTrdCd();
				
				aq_cd      = viewList.get(i).getAqCd();
				if(aq_cd.equals("+")){
					aq_cd = "-";
				}
				
				ofc_cd = viewList.get(i).getOfcCd();
				if(ofc_cd.equals("+")){
					ofc_cd = "-";
				}
				
				if(row_cnt == 0){
					if(!(aq_cd.equals("-") && dir_cd.equals("TOTAL"))){
						for(int w = 1 ; w <= duration ; w++){
							String temp1 = "";
							switch (w) {
								case 1:
									temp1 = viewList.get(i).getBsa1();
									break;
								case 2:
									temp1 = viewList.get(i).getBsa2();
									break;
								case 3:
									temp1 = viewList.get(i).getBsa3();
									break;
								case 4:
									temp1 = viewList.get(i).getBsa4();
									break;
								case 5:
									temp1 = viewList.get(i).getBsa5();
									break;
							}
							
							bsa[w]  = Double.parseDouble(temp1);
							sbsa[w] = sbsa[w] + bsa[w];
							tbsa[w] = tbsa[w] + bsa[w];
							
							for(int m = 1 ; m <= 5 ; m++){
//								dummy = 1;
								String temp2 = "";
								switch (w) {
									case 1:
										temp2 = viewList.get(i).getFct11();
										break;
									case 2:
										temp2 = viewList.get(i).getFct21();
										break;
									case 3:
										temp2 = viewList.get(i).getFct31();
										break;
									case 4:
										temp2 = viewList.get(i).getFct41();
										break;
									case 5:
										temp2 = viewList.get(i).getFct51();
										break;
								}
								
								if(temp2 == null) temp2 = "0";
								
								fct[w][m]  = Double.parseDouble(temp2);
								sfct[w][m] = sfct[w][m] + fct[w][m];
								tfct[w][m] = tfct[w][m] + fct[w][m];
							}
						}
						
						sbufXML.append("<TR Align='Center'  MERGE='TRUE' BGCOLOR=\"232,255,198\">\n");
//						sbufXML.append("<TR LEVEL=\"0\" MERGE=\"true\" BGCOLOR=\"232,255,198\">\n");
						sbufXML.append("<TD>" + sub_trd_cd).append(dir_cd.equals("TOTAL")?"":(" / " + (rlane_cd.equals("TOTAL")?rlane_cd:rlane_cd.substring(0, 3)))).append("</TD>\n");
						sbufXML.append("<TD></TD>\n");
						sbufXML.append("<TD>VVD</TD>\n");
						sbufXML.append("<TD>VVD</TD>\n");
						
						
						for(int w = 1 ; w <= duration ; w++){
							String temp3 = "";
							switch (w) {
								case 1:
									temp3 = viewList.get(i).getVvd1();
									break;
								case 2:
									temp3 = viewList.get(i).getVvd2();
									break;
								case 3:
									temp3 = viewList.get(i).getVvd3();
									break;
								case 4:
									temp3 = viewList.get(i).getVvd4();
									break;
								case 5:
									temp3 = viewList.get(i).getVvd5();
									break;
							}
							
							String vvd = JSPUtil.getNull(temp3);
							for(int m = 1 ; m <= 1 ; m++){
								for(int t = 0 ; t < 5 ; t++){
									sbufXML.append("<TD DATA-FORMAT=\"dtNone\" DATA-ALIGN=\"daCenter\">" + vvd + "</TD>\n");
								}
							}
						}
						sbufXML.append("<TD></TD>\n");
						sbufXML.append("<TD></TD>\n");
						sbufXML.append("</TR>\n");
					}
				}
				
				row_cnt = row_cnt + Integer.parseInt(viewList.get(i).getCnt());
				
				level = aq_cd.equals("-")?0:(ofc_cd.equals("-")?1:2);
				
				sbufXML.append("<TR BGCOLOR=\"").append(aq_cd.equals("-")?"247,231,236":"").append("\">\n");
//				sbufXML.append("<TR LEVEL=\"" + level + "\" BGCOLOR=\"").append(aq_cd.equals("-")?"247,231,236":"").append("\">\n");
				sbufXML.append("<TD>").append(sub_trd_cd.equals("TOTAL")?"Trade":sub_trd_cd).append(dir_cd.equals("TOTAL")?"":((rlane_cd.equals("TOTAL")?"":" / " + rlane_cd.substring(0, 3)))).append("</TD>\n");
				sbufXML.append("<TD></TD>\n");
				sbufXML.append("<TD>").append((rlane_cd.equals("TOTAL")&&!dir_cd.equals("TOTAL"))?dir_cd:aq_cd).append("</TD>\n");
				sbufXML.append("<TD>").append(aq_cd.equals("-")?"":ofc_cd).append("</TD>\n");
				
				
				for(int w = 1 ; w <= duration ; w++){
					String temp4 = "";
					String temp5 = "";
					String temp6 = "";
					String temp7 = "";
					String temp8 = "";
					
					switch (w) {
						case 1: //String[] _typ = {"Qta", "Fct", "Alc", "Bkg", "Pref"};
							temp4 = viewList.get(i).getQta11();
							temp5 = viewList.get(i).getFct11();
							temp6 = viewList.get(i).getAlc11();
							temp7 = viewList.get(i).getBkg11();
							temp8 = viewList.get(i).getPref11();
							break;
						case 2:	
							temp4 = viewList.get(i).getQta21();
							temp5 = viewList.get(i).getFct21();
							temp6 = viewList.get(i).getAlc21();
							temp7 = viewList.get(i).getBkg21();
							temp8 = viewList.get(i).getPref21();
							break;
						case 3:
							temp4 = viewList.get(i).getQta31();
							temp5 = viewList.get(i).getFct31();
							temp6 = viewList.get(i).getAlc31();
							temp7 = viewList.get(i).getBkg31();
							temp8 = viewList.get(i).getPref31();
						break;
						case 4:
							temp4 = viewList.get(i).getQta41();
							temp5 = viewList.get(i).getFct41();
							temp6 = viewList.get(i).getAlc41();
							temp7 = viewList.get(i).getBkg41();
							temp8 = viewList.get(i).getPref41();
							break;
						case 5:
							temp4 = viewList.get(i).getQta51();
							temp5 = viewList.get(i).getFct51();
							temp6 = viewList.get(i).getAlc51();
							temp7 = viewList.get(i).getBkg51();
							temp8 = viewList.get(i).getPref51();
							break;
					}
					
					if(temp4 == null) temp4 = "";
					
					sbufXML.append("<TD>" + temp4 + "</TD>\n");
					sbufXML.append("<TD>" + temp5 + "</TD>\n");
					sbufXML.append("<TD>" + temp6 + "</TD>\n");
					sbufXML.append("<TD>" + temp7 + "</TD>\n");
					sbufXML.append("<TD>" + temp8 + "</TD>\n");
				}
				sbufXML.append("<TD>" + (level==2?1:0)  + "</TD>");
				sbufXML.append("<TD></TD>\n");
				sbufXML.append("</TR>\n");
				
				if(row_cnt == 0){
					sbufXML.append("<TR BGCOLOR=\"236,231,247\">\n");
//					sbufXML.append("<TR LEVEL=\"0\" MERGE=\"true\" BGCOLOR=\"236,231,247\">\n");
					sbufXML.append("<TD>").append(sub_trd_cd.equals("TOTAL")?"Trade":sub_trd_cd).append(dir_cd.equals("TOTAL")?"":((rlane_cd.equals("TOTAL")?"":" / " + rlane_cd.substring(0, 3)))).append("</TD>\n");
					sbufXML.append("<TD></TD>\n");
					sbufXML.append("<TD INDENT=\"1\"></TD>\n");
					sbufXML.append("<TD INDENT=\"1\"></TD>\n");
					
					double[] tb   = new double[duration+1];
					double[][] tf = new double[duration+1][6];
					tb = sub_trd_cd.equals("TOTAL")?tbsa:(rlane_cd.equals("TOTAL")?sbsa:bsa);
					tf = sub_trd_cd.equals("TOTAL")?tfct:(rlane_cd.equals("TOTAL")?sfct:fct);
					
					for(int w = 1 ; w <= duration ; w++){
						double lbsa = tb[w];
						for(int m = 1 ; m <= 1 ; m++){
							double lfct = tf[w][m];
							sbufXML.append("<TD DATA-FORMAT=\"dfNone\" DATA-ALIGN=\"daCenter\">BSA</TD>\n");
							sbufXML.append("<TD DATA-FORMAT=\"dfInteger\" DATA-ALIGN=\"daRight\">" + (int)lbsa + "</TD>\n");
							sbufXML.append("<TD DATA-FORMAT=\"dfNone\"></TD>\n");
							sbufXML.append("<TD DATA-FORMAT=\"dfNone\" DATA-ALIGN=\"daCenter\">L/F</TD>\n");
							sbufXML.append("<TD DATA-ALIGN=\"daRight\">" + (lbsa==0?0:Math.round(lfct*100.0/lbsa)) + "%</TD>\n");
						}
					}
					
					if(rlane_cd.equals("TOTAL")){
						for(int w = 0 ; w <= duration ; w++){
							sbsa[w] = 0;
							for(int m = 1 ; m <= 5 ; m++){
								sfct[w][m] = 0;
							}
						}
					}
					sbufXML.append("<TD></TD>\n");
					sbufXML.append("<TD></TD>\n");
					sbufXML.append("</TR>\n");
				}
			}
		}else{		//3.9 데이타가 없는 경우
//			strWeek = strWeek;
//			strFdTd = strFdTd;
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