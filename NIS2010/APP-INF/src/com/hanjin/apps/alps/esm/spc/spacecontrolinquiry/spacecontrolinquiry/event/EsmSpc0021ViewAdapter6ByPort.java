/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmSpc0021ViewAdapter6ByPort.java
*@FileTitle      : Daily Forecast Status
*Open Issues     :
*Change history  :
*@LastModifyDate : 2012.06.27
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 Creation
* 2013.01.15 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2014.07.02 김용습 R4J 패치 사전 작업
* 2014.07.30 [CHM-201431081] SPC Allocation Control Option 추가 보완 요청	
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ComplexMainVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ETCVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiry021AllocPortViewListVO;
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
public class EsmSpc0021ViewAdapter6ByPort extends ViewAdapter{
	
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
		String[] week  = null;
		String[] fdtd  = null;
		String strWeek = "";
		String strFdTd = "";
		String portv   = condition.getChkview();
		
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
			int duration   = Integer.parseInt(condition.getDuration());
			int level      = 0;
			int row_cnt    = 0;
			int rowCntNext = 0;
			
			String rlane_cd   = "";
			String dir_cd     = "";
			String sub_trd_cd = "";
			String aq_cd      = "";
			String ofc_cd     = "";
			String port1      = "";
			
			String rlane_cd_next = "";
			String aq_cd_next    = "";
			String ofc_cd_next   = "";
			String port1_next    = "";
			
			double[] bsaAllTtl   = {0, 0, 0, 0, 0, 0, 0};
			double[] bsaSubTtl  = {0, 0, 0, 0, 0, 0, 0};
			
			double[] bsa    = new double[duration+1];
			double[] arrBkg = new double[duration+1];
			
			for(int i =0 ; i < rowCountview ; i++){
								
				dir_cd     = viewList.get(i).getDirCd();
				sub_trd_cd = viewList.get(i).getSubTrdCd();	
				rlane_cd   = viewList.get(i).getRlaneCd();				
				aq_cd      = viewList.get(i).getAqCd();	
				ofc_cd     = viewList.get(i).getOfcCd();
				port1      = viewList.get(i).getPort1();				
				
				if(i < rowCountview-1 ) {
					rowCntNext    = Integer.parseInt(viewList.get(i+1).getCnt());
					rlane_cd_next = viewList.get(i+1).getRlaneCd();
					aq_cd_next    = viewList.get(i+1).getAqCd();
					ofc_cd_next   = viewList.get(i+1).getOfcCd();
					port1_next    = viewList.get(i+1).getPort1();
				} else {
					rowCntNext    = 1;
					rlane_cd_next = "";
					aq_cd_next    = "";
					ofc_cd_next   = "";
					port1_next    = "";
				}
				
				if(aq_cd.equals("+"))
					aq_cd = "-";
				
				// Tree의 Level
				level = aq_cd.equals("-")?0:(port1.equals("+")?1:(ofc_cd.equals("+")?2:3));
				
				/****************  VVD Row : Start ****************************/
				if(		!rlane_cd.equals("TOTAL")
					&&	aq_cd.equals("-")
					&&	ofc_cd.equals("+")
					&&	port1.equals("+") ){
					
					sbufXML.append("<TR LEVEL=\"0\" MERGE=\"true\" BGCOLOR=\"232,255,198\">\n");
					
					if( rlane_cd.equals("TOTAL")){
						sbufXML.append("<TD BGCOLOR=\"223,232,247\">Trade</TD>\n");
					}else{
						sbufXML.append("<TD>" + sub_trd_cd).append(dir_cd.equals("TOTAL")?"":(" / " + (rlane_cd.equals("TOTAL")?rlane_cd:rlane_cd.substring(0, 3)))).append("</TD>\n");
					}
					
					sbufXML.append("<TD></TD>\n");
					sbufXML.append("<TD></TD>\n");
					sbufXML.append("<TD></TD>\n");
					sbufXML.append("<TD></TD>\n");
					sbufXML.append("<TD INDENT=\"1\"></TD>\n");
					sbufXML.append("<TD INDENT=\"1\"></TD>\n");
					sbufXML.append("<TD INDENT=\"1\"></TD>\n");
					
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
							case 6:
								temp3 = viewList.get(i).getVvd6();
								break;
						}
						
						String vvd = JSPUtil.getNull(temp3);
						
						for(int t = 0 ; t < 21 ; t++){
							sbufXML.append("<TD DATA-FORMAT=\"dtNone\" DATA-ALIGN=\"daCenter\">" + vvd + "</TD>\n");
						}
					}
					sbufXML.append("</TR>\n");
				}
				/**************** 1st VVD Row : End ****************************/
				
				/************************ Data Row [Start]*************************************/
				
				sbufXML.append("<TR LEVEL=\"" + level + "\" BGCOLOR=\"").append(aq_cd.equals("-")?"247,231,236":"").append("\">\n");
				
				if(rlane_cd.equals("TOTAL") && sub_trd_cd.equals("TOTAL")){
					sbufXML.append("<TD BGCOLOR=\"223,232,247\">Trade</TD>\n");
				} else {
					sbufXML.append("<TD>").append(sub_trd_cd.equals("TOTAL")?"Trade":sub_trd_cd).append(dir_cd.equals("TOTAL")?"":((rlane_cd.equals("TOTAL")?"":" / " + rlane_cd.substring(0, 3)))).append("</TD>\n");
				}
				
				sbufXML.append("<TD></TD>\n");
				sbufXML.append("<TD>").append((rlane_cd.equals("TOTAL")&&!dir_cd.equals("TOTAL"))?dir_cd:aq_cd).append("</TD>\n");
				sbufXML.append("<TD>").append(sub_trd_cd).append("</TD>\n");						// sub trd
				sbufXML.append("<TD>").append(rlane_cd).append("</TD>\n");							// rlane
				sbufXML.append("<TD>").append(dir_cd).append("</TD>\n");							// dir
				sbufXML.append("<TD>").append(aq_cd.equals("-")?"":port1).append("</TD>\n");		// port
				sbufXML.append("<TD>").append(aq_cd.equals("-")?"":(port1.equals("+")?"":ofc_cd)).append("</TD>\n");		// office
				
				for(int w = 1 ; w <= duration ; w++){
					String vvd    = "";
					String temp4  = "";
					String temp5  = "";
					String temp6  = "";
					String temp7  = "";
					String temp8  = "";
					String temp9  = "";
					String temp10 = "";
					String temp11 = "";
					String temp12 = "";
					String temp13 = "";
					String temp14 = "";
					String temp15 = "";
					String temp16 = "";
					String temp17 = "";
					String temp18 = "";
					String temp19 = "";
					String temp20 = "";			     
					String temp21 = "";
					String temp22 = "";
					String temp23 = "";
					String temp24 = "";
					
					switch (w) {
						case 1: 
							vvd    = viewList.get(i).getVvd1();
							temp4  = viewList.get(i).getQta11();
							temp5  = viewList.get(i).getAlc11();
							temp6  = viewList.get(i).getAlcRf11();
							temp7  = viewList.get(i).getBkg11();
							temp8  = viewList.get(i).getBkg2011();
							temp9  = viewList.get(i).getBkg4011();
							temp10 = viewList.get(i).getBkgD211();
							temp11 = viewList.get(i).getBkgD411();
							temp12 = viewList.get(i).getBkgHc11();
							temp13 = viewList.get(i).getBkgRd11();
							temp14 = viewList.get(i).getBkg4511();
							temp15 = viewList.get(i).getBkg5311();
							temp16 = viewList.get(i).getBkgRf11();
							temp17 = viewList.get(i).getBkgR211();
							temp18 = viewList.get(i).getBkgR511();
							temp19 = viewList.get(i).getCmEn11();
							temp20 = viewList.get(i).getCmOp11();
							temp21 = viewList.get(i).getCmOc11();
							temp22 = viewList.get(i).getCmVl11();
							temp23 = viewList.get(i).getPref11();
							temp24 = viewList.get(i).getPrefRf11();
							break;
						case 2:
							vvd    = viewList.get(i).getVvd2();
							temp4  = viewList.get(i).getQta21();
							temp5  = viewList.get(i).getAlc21();
							temp6  = viewList.get(i).getAlcRf21();
							temp7  = viewList.get(i).getBkg21();
							temp8  = viewList.get(i).getBkg2021();
							temp9  = viewList.get(i).getBkg4021();
							temp10 = viewList.get(i).getBkgD221();
							temp11 = viewList.get(i).getBkgD421();
							temp12 = viewList.get(i).getBkgHc21();
							temp13 = viewList.get(i).getBkgRd21();
							temp14 = viewList.get(i).getBkg4521();
							temp15 = viewList.get(i).getBkg5321();
							temp16 = viewList.get(i).getBkgRf21();
							temp17 = viewList.get(i).getBkgR221();
							temp18 = viewList.get(i).getBkgR521();
							temp19 = viewList.get(i).getCmEn21();
							temp20 = viewList.get(i).getCmOp21();
							temp21 = viewList.get(i).getCmOc21();
							temp22 = viewList.get(i).getCmVl21();
							temp23 = viewList.get(i).getPref21();
							temp24 = viewList.get(i).getPrefRf21();
							break;
						case 3:
							vvd    = viewList.get(i).getVvd3();
							temp4  = viewList.get(i).getQta31();
							temp5  = viewList.get(i).getAlc31();
							temp6  = viewList.get(i).getAlcRf31();
							temp7  = viewList.get(i).getBkg31();
							temp8  = viewList.get(i).getBkg2031();
							temp9  = viewList.get(i).getBkg4031();
							temp10 = viewList.get(i).getBkgD231();
							temp11 = viewList.get(i).getBkgD431();
							temp12 = viewList.get(i).getBkgHc31();
							temp13 = viewList.get(i).getBkgRd31();
							temp14 = viewList.get(i).getBkg4531();
							temp15 = viewList.get(i).getBkg5331();
							temp16 = viewList.get(i).getBkgRf31();
							temp17 = viewList.get(i).getBkgR231();
							temp18 = viewList.get(i).getBkgR531();
							temp19 = viewList.get(i).getCmEn31();
							temp20 = viewList.get(i).getCmOp31();
							temp21 = viewList.get(i).getCmOc31();
							temp22 = viewList.get(i).getCmVl31();
							temp23 = viewList.get(i).getPref31();
							temp24 = viewList.get(i).getPrefRf31();
							break;
						case 4:
							vvd    = viewList.get(i).getVvd4();
							temp4  = viewList.get(i).getQta41();
							temp5  = viewList.get(i).getAlc41();
							temp6  = viewList.get(i).getAlcRf41();
							temp7  = viewList.get(i).getBkg41();
							temp8  = viewList.get(i).getBkg2041();
							temp9  = viewList.get(i).getBkg4041();
							temp10 = viewList.get(i).getBkgD241();
							temp11 = viewList.get(i).getBkgD441();
							temp12 = viewList.get(i).getBkgHc41();
							temp13 = viewList.get(i).getBkgRd41();
							temp14 = viewList.get(i).getBkg4541();
							temp15 = viewList.get(i).getBkg5341();
							temp16 = viewList.get(i).getBkgRf41();
							temp17 = viewList.get(i).getBkgR241();
							temp18 = viewList.get(i).getBkgR541();	
							temp19 = viewList.get(i).getCmEn41();
							temp20 = viewList.get(i).getCmOp41();
							temp21 = viewList.get(i).getCmOc41();
							temp22 = viewList.get(i).getCmVl41();
							temp23 = viewList.get(i).getPref41();
							temp24 = viewList.get(i).getPrefRf41();
							break;
						case 5:
							vvd    = viewList.get(i).getVvd5();
							temp4  = viewList.get(i).getQta51();
							temp5  = viewList.get(i).getAlc51();
							temp6  = viewList.get(i).getAlcRf51();
							temp7  = viewList.get(i).getBkg51();
							temp8  = viewList.get(i).getBkg2051();
							temp9  = viewList.get(i).getBkg4051();
							temp10 = viewList.get(i).getBkgD251();
							temp11 = viewList.get(i).getBkgD451();
							temp12 = viewList.get(i).getBkgHc51();
							temp13 = viewList.get(i).getBkgRd51();
							temp14 = viewList.get(i).getBkg4551();
							temp15 = viewList.get(i).getBkg5351();
							temp16 = viewList.get(i).getBkgRf51();
							temp17 = viewList.get(i).getBkgR251();
							temp18 = viewList.get(i).getBkgR551();
							temp19 = viewList.get(i).getCmEn51();
							temp20 = viewList.get(i).getCmOp51();
							temp21 = viewList.get(i).getCmOc51();
							temp22 = viewList.get(i).getCmVl51();
							temp23 = viewList.get(i).getPref51();
							temp24 = viewList.get(i).getPrefRf51();
							break;
						case 6:
							vvd    = viewList.get(i).getVvd6();
							temp4  = viewList.get(i).getQta61();
							temp5  = viewList.get(i).getAlc61();
							temp6  = viewList.get(i).getAlcRf61();
							temp7  = viewList.get(i).getBkg61();
							temp8  = viewList.get(i).getBkg2061();
							temp9  = viewList.get(i).getBkg4061();
							temp10 = viewList.get(i).getBkgD261();
							temp11 = viewList.get(i).getBkgD461();
							temp12 = viewList.get(i).getBkgHc61();
							temp13 = viewList.get(i).getBkgRd61();
							temp14 = viewList.get(i).getBkg4561();
							temp15 = viewList.get(i).getBkg5361();
							temp16 = viewList.get(i).getBkgRf61();
							temp17 = viewList.get(i).getBkgR261();
							temp18 = viewList.get(i).getBkgR561();
							temp19 = viewList.get(i).getCmEn61();
							temp20 = viewList.get(i).getCmOp61();
							temp21 = viewList.get(i).getCmOc61();
							temp22 = viewList.get(i).getCmVl61();
							temp23 = viewList.get(i).getPref61();
							temp24 = viewList.get(i).getPrefRf61();
							break;
					}
					
					if(vvd    == null) vvd    = "";
					if(temp4  == null) temp4  = "";
					if(temp5  == null) temp5  = "";
					if(temp6  == null) temp6  = "";
					if(temp7  == null) temp7  = "";
					if(temp8  == null) temp8  = "";
					if(temp9  == null) temp9  = "";
					if(temp10 == null) temp10 = "";
					if(temp11 == null) temp11 = "";
					if(temp12 == null) temp12 = "";
					if(temp13 == null) temp13 = "";
					if(temp14 == null) temp14 = "";
					if(temp15 == null) temp15 = "";
					if(temp16 == null) temp16 = "";
					if(temp17 == null) temp17 = "";
					if(temp18 == null) temp18 = "";
					if(temp19 == null) temp19 = "";
					if(temp20 == null) temp20 = "";
					if(temp21 == null) temp21 = "";
					if(temp22 == null) temp22 = "";
					if(temp23 == null) temp23 = "";	
					if(temp23 == null) temp24 = "";	
					
					sbufXML.append("<TD>" + temp4  + "</TD>\n");
					sbufXML.append("<TD>" + temp5  + "</TD>\n");
					sbufXML.append("<TD>" + temp6  + "</TD>\n");
				
					sbufXML.append("<TD>" + vvd    + "</TD>\n");
					
					sbufXML.append("<TD>" + temp7  + "</TD>\n"); // TTL	
					sbufXML.append("<TD>" + temp8  + "</TD>\n");
					sbufXML.append("<TD>" + temp9  + "</TD>\n");
					sbufXML.append("<TD>" + temp10 + "</TD>\n");
					sbufXML.append("<TD>" + temp11 + "</TD>\n");
					sbufXML.append("<TD>" + temp12 + "</TD>\n");
					sbufXML.append("<TD>" + temp13 + "</TD>\n");
					sbufXML.append("<TD>" + temp14 + "</TD>\n");
					sbufXML.append("<TD>" + temp15 + "</TD>\n");
					
					sbufXML.append("<TD>" + temp16 + "</TD>\n"); // TTL
					sbufXML.append("<TD>" + temp17 + "</TD>\n");
					sbufXML.append("<TD>" + temp18 + "</TD>\n");
					
//					sbufXML.append("<TD>" + temp19 + "</TD>\n");
					sbufXML.append("<TD>" + temp20 + "</TD>\n");
					sbufXML.append("<TD>" + temp21 + "</TD>\n");
					sbufXML.append("<TD>" + temp22 + "</TD>\n");
					sbufXML.append("<TD>" + temp23 + "</TD>\n");
					sbufXML.append("<TD>" + temp24 + "</TD>\n");
				}
				sbufXML.append("</TR>\n");
				/************************ Data Row [Start]*************************************/
				
				/********************** BSL  TTL을 위한 계산 [Start]***************************/
				
				// BSA
				if(		!rlane_cd.equals("TOTAL")
					&&	aq_cd.equals("-")
					&&	ofc_cd.equals("+")
					&&	port1.equals("+") ){
					
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
							case 6:
								temp1 = viewList.get(i).getBsa6();
								break;
						}
						
						bsa[w]       = Double.parseDouble(temp1);
						bsaSubTtl[w] = bsaSubTtl[w] + Double.parseDouble(temp1);
						bsaAllTtl[w] = bsaAllTtl[w] + Double.parseDouble(temp1);
					}// End 'for'
				}// End 'If'
				
				// BKG
				if(		aq_cd.equals("-")
					&&  ofc_cd.equals("+")
					&&  port1.equals("+") ){
					
					for(int w = 1 ; w <= duration ; w++){
						String bkg ="";
						
						switch (w) {
							case 1:
								bkg = viewList.get(i).getBkg11();
								break;
							case 2:
								bkg = viewList.get(i).getBkg21();
								break;
							case 3:
								bkg = viewList.get(i).getBkg31();
								break;
							case 4:
								bkg = viewList.get(i).getBkg41();
								break;
							case 5:
								bkg = viewList.get(i).getBkg51();
								break;
							case 6:
								bkg = viewList.get(i).getBkg61();
								break;
						}
						
						arrBkg[w] = Double.parseDouble(bkg); // Bkg 구하기
					}
				}
				/********************** BSL  TTL을 위한 계산 [End]***************************/
				
				row_cnt = row_cnt + Integer.parseInt(viewList.get(i).getCnt());
				
				/*************************** Sub Total  [Start]********************/
				
				// Sub Total 'IF' Start 					
				if( row_cnt == 0 && (rowCntNext > 0 || (!rlane_cd_next.equals("TOTAL") && aq_cd_next.equals("+") && ofc_cd_next.equals("+") && port1_next.equals("+"))) ){
					
					// <Tr>  Start
					sbufXML.append("<TR LEVEL=\"0\" MERGE=\"true\" BGCOLOR=\"236,231,247\">\n");
										
					if( rlane_cd.equals("TOTAL") &&  sub_trd_cd.equals("TOTAL")){
						sbufXML.append("<TD BGCOLOR=\"223,232,247\"><![CDATA[Trade]]></TD>");
					}else{
					   sbufXML.append("<TD>").append(sub_trd_cd.equals("TOTAL")?"Trade":sub_trd_cd).append(dir_cd.equals("TOTAL")?"":((rlane_cd.equals("TOTAL")?"":" / " + rlane_cd.substring(0, 3)))).append("</TD>\n");
					}
					
					sbufXML.append("<TD INDENT=\"1\"></TD>\n");
					sbufXML.append("<TD INDENT=\"1\"></TD>\n");
					sbufXML.append("<TD INDENT=\"1\"></TD>\n");
					sbufXML.append("<TD INDENT=\"1\"></TD>\n");
					sbufXML.append("<TD INDENT=\"1\"></TD>\n");
					sbufXML.append("<TD INDENT=\"1\"></TD>\n");
					sbufXML.append("<TD INDENT=\"1\"></TD>\n");
					
					double[] tb = new double[duration+1];
					
					tb = sub_trd_cd.equals("TOTAL")? bsaAllTtl:( (rlane_cd.equals("TOTAL")? bsaSubTtl:bsa));
					
					for(int w = 1 ; w <= duration ; w++){
						double lbsa = tb[w];
						double dBkg = arrBkg[w];
						
						for(int m = 1 ; m <= 1 ; m++){
							sbufXML.append("<TD DATA-FORMAT=\"dfNone\" DATA-ALIGN=\"daCenter\">BSA</TD>\n");
							sbufXML.append("<TD DATA-FORMAT=\"dfInteger\" DATA-ALIGN=\"daRight\">" + lbsa + "</TD>\n");
							
							sbufXML.append("<TD DATA-FORMAT=\"dfNone\"></TD>\n");
							sbufXML.append("<TD DATA-FORMAT=\"dfNone\"></TD>\n");
							sbufXML.append("<TD DATA-FORMAT=\"dfNone\"></TD>\n");
							sbufXML.append("<TD DATA-FORMAT=\"dfNone\"></TD>\n");
							sbufXML.append("<TD DATA-FORMAT=\"dfNone\"></TD>\n");
							sbufXML.append("<TD DATA-FORMAT=\"dfNone\"></TD>\n");
							sbufXML.append("<TD DATA-FORMAT=\"dfNone\"></TD>\n");
							sbufXML.append("<TD DATA-FORMAT=\"dfNone\"></TD>\n");
							sbufXML.append("<TD DATA-FORMAT=\"dfNone\"></TD>\n");
							sbufXML.append("<TD DATA-FORMAT=\"dfNone\"></TD>\n");
							sbufXML.append("<TD DATA-FORMAT=\"dfNone\"></TD>\n");
							sbufXML.append("<TD DATA-FORMAT=\"dfNone\"></TD>\n");
							sbufXML.append("<TD DATA-FORMAT=\"dfNone\"></TD>\n");
							sbufXML.append("<TD DATA-FORMAT=\"dfNone\"></TD>\n");
							sbufXML.append("<TD DATA-FORMAT=\"dfNone\"></TD>\n");
							sbufXML.append("<TD DATA-FORMAT=\"dfNone\"></TD>\n");
							sbufXML.append("<TD DATA-FORMAT=\"dfNone\"></TD>\n");
							
							sbufXML.append("<TD DATA-FORMAT=\"dfNone\" DATA-ALIGN=\"daCenter\">L/F</TD>\n");
							
							sbufXML.append("<TD DATA-ALIGN=\"daRight\">" + (lbsa==0?0:Math.round( (dBkg/lbsa) * 100)) + "%</TD>\n");
						}
					}
					
					sbufXML.append("</TR>\n");
					
					// Sub Trade 별 BSA/F'cast Sub TTL 초기화
					if(rlane_cd.equals("TOTAL")){
						for(int w = 0 ; w <= duration ; w++){
							bsaSubTtl[w] = 0;
						}
					}
				} // Sub Total 'IF' End
				/*************************** Sub Total  [End]********************/
			}// end 'i' For
			
		}else{		//3.9 데이타가 없는 경우
			strWeek = strWeek;
			strFdTd = strFdTd;
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