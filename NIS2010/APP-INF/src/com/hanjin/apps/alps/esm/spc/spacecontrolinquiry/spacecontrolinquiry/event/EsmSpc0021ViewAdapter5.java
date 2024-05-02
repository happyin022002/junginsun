/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0021ViewAdapter5.java
*@FileTitle : Daily Forecast Status
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.27
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2014.07.02 김용습 R4J 패치 사전 작업
* 2014.10.21 Arie Im [CHM-201432344] Daily FCST - Dest Control시 SUM기능 보완
* 2014.11.20 Arie Im [CHM-201432864] Daily FCST보완
				- SUB Trade별 전체 실적 GUIDE추가(Acct)
				- SUB Trade, Trade 별 USMode/Account/Dest Sum 추가(HO/RHQ)
				- 체크박스 기능 재정의(HO/RHQ)
				- Excluding Sector(IAS) 추가 (HO/RHQ탭)
* 2016.01.12 이혜민 [CHM-201539227] Daily FCST status _ Allocation status(HO) & Allocation status(RHQ) 기능추가				
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
public class EsmSpc0021ViewAdapter5 extends ViewAdapter{
	
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
	{log.debug("\n\nEsmSpc0021ViewAdapter5");	
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
		boolean isSmp  = false;
		
		
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
			int duration    = Integer.parseInt(condition.getDuration());
			int level       = 0;
			int level2  	= 0; //[CHM-201432344]
			String pre_gid  = "0";
			String gid      = "0";
			String next_gid = "0";
			
			//String[] typ = {"qta", "fct", "alc", "bkg", "pref"};
			String rlane_cd        = "";
			String dir_cd          = "";
			String sub_trd_cd      = "";
			String next_sub_trd_cd = "";
			String rhq_cd          = "";
			String aq_cd           = "";
			String acct_lvl        = "";
			String ofc_cd          = "";
			String sub_ofc_cd      = "";
			String dest            = "";
			String next_dest       = "";
			String guideYn         = "";
			
			String usa_bkg_mod_cd="";//add
			String dest_loc_cd= "";//add
			String acct_cd = "";//add
			
			int row_num       = 0;
			double[] tbsa   = {0, 0, 0, 0, 0, 0, 0};
			double[] sbsa   = {0, 0, 0, 0, 0, 0, 0};
			double[] ibsa   = {0, 0, 0, 0, 0, 0, 0};	// IA 에 대한 Dest Sub TTL의 BSA
			double[] bsa    = new double[duration+1];
//			int[][] lf   = new String[duration+1][6];
			double[][] fct  = new double[duration+1][6];
			double[][] ifct = new double[duration+1][6];	// IA 에 대한 Dest Sub TTL의 F'Cast
			double[][] sfct = new double[duration+1][6];
			double[][] tfct = new double[duration+1][6];
			
			double[] tbsaw   = {0, 0, 0, 0, 0, 0, 0};
			double[] sbsaw   = {0, 0, 0, 0, 0, 0, 0};
			double[] ibsaw   = {0, 0, 0, 0, 0, 0, 0};	// IA 에 대한 Dest Sub TTL의 BSA
			double[] bsaw    = new double[duration+1];
			double[][] bkgWgt  = new double[duration+1][6];
			double[][] ibkgWgt = new double[duration+1][6];	// IA 에 대한 Dest Sub TTL의 F'Cast
			double[][] sbkgWgt = new double[duration+1][6];
			double[][] tbkgWgt = new double[duration+1][6];
			
			for(int i =0 ; i < rowCountview ; i++){
				gid      = viewList.get(i).getGid();
				next_gid = viewList.get(i).getGid();
				
				if(i > 0){
					pre_gid = viewList.get(i-1).getGid();
				}
				
				if(rowCountview > (i+1)){
					next_gid        = viewList.get(i+1).getGid();
					next_sub_trd_cd = viewList.get(i+1).getSubTrdCd();
					next_dest       = viewList.get(i+1).getDest();
				} else { 
					next_gid        = "";
					next_sub_trd_cd = "";
					next_dest       = "";
				}
				
				rlane_cd   = viewList.get(i).getRlaneCd();
				dir_cd     = viewList.get(i).getDirCd();
				sub_trd_cd = viewList.get(i).getSubTrdCd();
				
				usa_bkg_mod_cd   = viewList.get(i).getUsaBkgModCd();
				dest_loc_cd     = viewList.get(i).getDestLocCd();
				acct_cd = viewList.get(i).getAcctCd();
				
				rhq_cd      = viewList.get(i).getRhqCd();
				if(rhq_cd.equals("+")){
					rhq_cd = "-";
				}
				aq_cd      = viewList.get(i).getAqCd();
				if(aq_cd.equals("+")){
					aq_cd = "-";
				}
				
				acct_lvl = viewList.get(i).getCustCtrlCd();

				if(!isSmp && !acct_lvl.equals("")) {
					isSmp = true;
				}
				
				ofc_cd = viewList.get(i).getOfcCd();
				sub_ofc_cd   = viewList.get(i).getSubOfcCd();

//				if(ofc_cd.equals("+")){
//					ofc_cd = "-";
//				}
				dest = viewList.get(i).getDest();

				guideYn = "GUIDE".equals(viewList.get(i).getT())?"Y":"N";
				
				if( !pre_gid.equals(gid) && !rlane_cd.equals("TOTAL")){
					if(!dir_cd.equals("TOTAL")){
						sbufXML.append("<TR LEVEL=\"0\" MERGE=\"true\" BGCOLOR=\"232,255,198\">\n");
						sbufXML.append("<TD BGCOLOR=\"223,232,247\"><![CDATA[" + dest + "]]></TD>\n");
						
						if(!dest.equals(" ") && rlane_cd.equals("TOTAL")){
							sbufXML.append("<TD BGCOLOR=\"223,232,247\"><![CDATA[" + dest + " TTL" + "]]></TD>\n");
						}else if(dir_cd.equals("TOTAL")){
							sbufXML.append("<TD BGCOLOR=\"247,231,236\">" + sub_trd_cd).append(dir_cd.equals("TOTAL")?"":(" / " + (rlane_cd.equals("TOTAL")?rlane_cd:rlane_cd.substring(0, 3)))).append("</TD>\n");
						}else{
							sbufXML.append("<TD>" + sub_trd_cd).append(dir_cd.equals("TOTAL")?"":(" / " + (rlane_cd.equals("TOTAL")?rlane_cd:rlane_cd.substring(0, 3)))).append("</TD>\n");
						}
						
						sbufXML.append("<TD INDENT=\"1\"></TD>\n");
						sbufXML.append("<TD INDENT=\"1\"></TD>\n");
						sbufXML.append("<TD INDENT=\"1\"></TD>\n");
						sbufXML.append("<TD INDENT=\"1\"></TD>\n");
						
						sbufXML.append("<TD></TD>\n");//add 
						sbufXML.append("<TD></TD>\n");//add
						sbufXML.append("<TD></TD>\n");//add	
						
						sbufXML.append("<TD></TD>\n");
						sbufXML.append("<TD INDENT=\"1\">" + (row_num++) + "</TD>\n");
						//ho(office), hg0(guide for none office), hg(guide), hc1(USMode), hc2(Account), hc3(Dest)
						sbufXML.append("<TD></TD>\n");
						sbufXML.append("<TD></TD>\n");
						sbufXML.append("<TD></TD>\n");
						sbufXML.append("<TD></TD>\n");
						sbufXML.append("<TD></TD>\n");
						sbufXML.append("<TD></TD>\n");
						sbufXML.append("<TD></TD>\n");
						
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
							
							String vvd = JSPUtil.getNull(temp3); // String vvd = JSPUtil.getNull(rowSets[1].getString("vvd"+w));
							for(int m = 1 ; m <= 1 ; m++){
								for(int t = 0 ; t < 6; t++){
									sbufXML.append("<TD DATA-FORMAT=\"dtNone\" DATA-ALIGN=\"daCenter\">" + vvd + "</TD>\n");
								}
							}
						}
						sbufXML.append("</TR>\n");
					}
				}
				
				
//				if(aq_cd.equals("-") && dir_cd.equals("TOTAL")){
//					continue;
//				}
				//[CHM-201432344]
//				level = aq_cd.equals("-")?0:(ofc_cd.equals("+")?1:(acct_lvl.isEmpty()?2:3));
//				level = aq_cd.equals("-")?0:(ofc_cd.equals("+")?1:                          (acct_lvl.isEmpty()?2:(usa_bkg_mod_cd.equals("+")?3:acct_cd.equals("+")?4:dest_loc_cd.equals("+")?5:6)));
				level = aq_cd.equals("-")?0:(ofc_cd.equals("+")?1:(sub_ofc_cd.equals("+")?2:(acct_lvl.isEmpty()?3:(usa_bkg_mod_cd.equals("+")?4:acct_cd.equals("+")?5:dest_loc_cd.equals("+")?6:7))));

				level2 = level;
				
//				String gid_aq = acct_lvl.isEmpty()?((rlane_cd.equals("TOTAL")&&!dir_cd.equals("TOTAL"))?dir_cd:aq_cd):"Guide";
				
				if("Y".equals(guideYn)){ //6, 5, 4
					if("+".equals(usa_bkg_mod_cd) && "+".equals(acct_cd) && "+".equals(dest_loc_cd)){//3
						level2 = 4;
					} else if("+".equals(acct_cd) && "+".equals(dest_loc_cd)){//4
						level2 = 5;
					} else if( "+".equals(dest_loc_cd)){//5
						level2 = 6;
					} else if("+".equals(usa_bkg_mod_cd) && "+".equals(acct_cd) && !"+".equals(dest_loc_cd)){
//					} else if(!"+".equals(usa_bkg_mod_cd) && !"+".equals(acct_cd) && !"+".equals(dest_loc_cd)){
						level2 = 7;
					}
				}
		
				sbufXML.append("<TR LEVEL=\"" + ("Y".equals(guideYn)?level2:level) + "\" BGCOLOR=\"").append(rhq_cd.equals("-")?"247,231,236":(aq_cd.equals("-")?"203,230,254":(ofc_cd.equals("+")?"253,251,151":(acct_lvl.isEmpty()?"":"253,238,187")))).append("\">\n");
				sbufXML.append("<TD BGCOLOR=\"223,232,247\"><![CDATA[" + dest + "]]></TD>\n");
				
				if(!dest.equals(" ") && rlane_cd.equals("TOTAL")){
					sbufXML.append("<TD DATA-ALIGN=\"daCenter\" BGCOLOR=\"223,232,247\"><![CDATA[" + dest + " TTL" + "]]></TD>\n");
				}else if(dir_cd.equals("TOTAL")){
					sbufXML.append("<TD DATA-ALIGN=\"daCenter\" BGCOLOR=\"247,231,236\">").append(sub_trd_cd.equals("TOTAL")?"Trade":sub_trd_cd).append(dir_cd.equals("TOTAL")?"":((rlane_cd.equals("TOTAL")?"":" / " + rlane_cd.substring(0, 3)))).append("</TD>\n");
				}else{
					sbufXML.append("<TD DATA-ALIGN=\"daCenter\">").append(sub_trd_cd.equals("TOTAL")?"Trade":sub_trd_cd).append(dir_cd.equals("TOTAL")?"":((rlane_cd.equals("TOTAL")?"":" / " + rlane_cd.substring(0, 3)))).append("</TD>\n");
				}
				
				String newAreaCode = (acct_lvl.isEmpty()?(rlane_cd.equals("TOTAL")&&!dir_cd.equals("TOTAL"))?dir_cd:(!aq_cd.equals("-")?aq_cd:(!rhq_cd.equals("-")?rhq_cd+" ":((sub_trd_cd.equals("TOTAL")?"Trade":(!dest.equals(" ")&&dir_cd.equals("TOTAL")?dest:sub_trd_cd))+(dir_cd.equals("TOTAL")?"":((rlane_cd.equals("TOTAL")?"":" / " + rlane_cd.substring(0, 3))))))):"Guide");
				if("Z".equals(acct_lvl)) newAreaCode = " " + aq_cd;
				
				sbufXML.append("<TD>").append((rlane_cd.equals("TOTAL")&&!dir_cd.equals("TOTAL"))?dir_cd:(!rhq_cd.equals("-")?rhq_cd:((sub_trd_cd.equals("TOTAL")?"Trade":sub_trd_cd)+(dir_cd.equals("TOTAL")?"":((rlane_cd.equals("TOTAL")?"":" / " + rlane_cd.substring(0, 3))))))).append("</TD>\n");
				sbufXML.append("<TD><![CDATA[").append(newAreaCode).append("]]></TD>\n");
				sbufXML.append("<TD><![CDATA[").append(aq_cd.equals("-")?" TTL":(ofc_cd.equals("+")?aq_cd:ofc_cd)).append("]]></TD>\n");
				
				sbufXML.append("<TD><![CDATA[").append(ofc_cd.equals("+")?" TTL":(sub_ofc_cd.equals("+")?" TTL":sub_ofc_cd)).append("]]></TD>\n");

				sbufXML.append("<TD>" + (level==3&&acct_lvl.isEmpty()?(ofc_cd.equals("+")?"":"+"):("Z".equals(acct_lvl)?"*":acct_lvl)) + "</TD>\n");
				
			   if(("Y".equals(guideYn)?level2:level) < 4) usa_bkg_mod_cd = "";
			   if(guideYn.equals("Y")) {
					if("+".equals(usa_bkg_mod_cd) && ("Z".equals(acct_lvl)||(level==0&&!acct_lvl.isEmpty()))) { //핑크색 Guide영역의 + 표시 설정
						usa_bkg_mod_cd = "";
					}
					sbufXML.append("<TD>" + usa_bkg_mod_cd + "</TD>\n");//add office가 (+) 이고 cust control cd가 null이 아니면 ""로 표시함
					if("+".equals(acct_cd)) {
//						if("Z".equals(acct_lvl)) acct_cd = "";
						acct_cd = "";
						sbufXML.append("<TD DATA-ALIGN=\"daCenter\">" + (level2==0||level2<=3?"":acct_cd) + "</TD>\n");//add
					} else {
						sbufXML.append("<TD DATA-ALIGN=\"daLeft\"><![CDATA["+ (level2==0?"":acct_cd)  + "]]></TD>\n");//add
					}					
					if("+".equals(dest_loc_cd)) dest_loc_cd = "";
					sbufXML.append("<TD>" + dest_loc_cd + "</TD>\n");//add
			   } else {
				   if("+".equals(acct_cd)) acct_cd = "";
				   if("+".equals(dest_loc_cd)) dest_loc_cd = "";
					sbufXML.append("<TD>" + usa_bkg_mod_cd + "</TD>\n");//add office가 (+) 이고 cust control cd가 null이 아니면 ""로 표시함
					sbufXML.append("<TD DATA-ALIGN=\"daLeft\"><![CDATA["+ acct_cd  + "]]></TD>\n");//add
					sbufXML.append("<TD>" + dest_loc_cd + "</TD>\n");//add
			   }
			   //level
				sbufXML.append("<TD>" + ("Y".equals(guideYn)?level2:level) +"</TD>\n");

				sbufXML.append("<TD>" + (level==3&&!ofc_cd.equals("+")?"OFFICE":(level<4&&!acct_lvl.isEmpty()?"TOTAL":(row_num++))) + "</TD>\n");
				sbufXML.append("<TD>" + (level==3&&!ofc_cd.equals("+")?"1":"0") + "</TD>\n");
				sbufXML.append("<TD>" + (level<4&&!acct_lvl.isEmpty()?"1":"0") + "</TD>\n");
				sbufXML.append("<TD>" + ("Guide".equals((acct_lvl.isEmpty()?(rlane_cd.equals("TOTAL")&&!dir_cd.equals("TOTAL"))?dir_cd:(!aq_cd.equals("-")?aq_cd:(!rhq_cd.equals("-")?rhq_cd+" ":((sub_trd_cd.equals("TOTAL")?"Trade":(!dest.equals(" ")&&dir_cd.equals("TOTAL")?dest:sub_trd_cd))+(dir_cd.equals("TOTAL")?"":((rlane_cd.equals("TOTAL")?"":" / " + rlane_cd.substring(0, 3))))))):"Guide"))?"1":"0") + "</TD>\n");
				sbufXML.append("<TD>" + (!usa_bkg_mod_cd.isEmpty()?"1":"0") + "</TD>\n");
				sbufXML.append("<TD>" + (!acct_cd.isEmpty()?"1":"0") + "</TD>\n");
				sbufXML.append("<TD>" + (!dest_loc_cd.isEmpty()?"1":"0") + "</TD>\n");
				
				// Row 단위 데이터 입력하는 곳 
				for(int w = 1 ; w <= duration ; w++){
					String temp4 = "";
					String temp5 = "";
					String temp6 = "";
					String temp7 = "";
					String temp8 = "";
					String temp9 = "";
					switch (w) {
						case 1: //String[] _typ = {"Qta", "Fct", "Alc", "Bkg", "Pref"};
							temp4 = viewList.get(i).getQta11();
							temp5 = viewList.get(i).getFct11();
							temp6 = viewList.get(i).getAlc11();
							temp7 = viewList.get(i).getBkg11();
							temp8 = viewList.get(i).getPref11();
							temp9 = viewList.get(i).getPrf11();
							break;
						case 2:	
							temp4 = viewList.get(i).getQta21();
							temp5 = viewList.get(i).getFct21();
							temp6 = viewList.get(i).getAlc21();
							temp7 = viewList.get(i).getBkg21();
							temp8 = viewList.get(i).getPref21();
							temp9 = viewList.get(i).getPrf21();
							break;
						case 3:
							temp4 = viewList.get(i).getQta31();
							temp5 = viewList.get(i).getFct31();
							temp6 = viewList.get(i).getAlc31();
							temp7 = viewList.get(i).getBkg31();
							temp8 = viewList.get(i).getPref31();
							temp9 = viewList.get(i).getPrf31();
							break;
						case 4:
							temp4 = viewList.get(i).getQta41();
							temp5 = viewList.get(i).getFct41();
							temp6 = viewList.get(i).getAlc41();
							temp7 = viewList.get(i).getBkg41();
							temp8 = viewList.get(i).getPref41();
							temp9 = viewList.get(i).getPrf41();
							break;
						case 5:
							temp4 = viewList.get(i).getQta51();
							temp5 = viewList.get(i).getFct51();
							temp6 = viewList.get(i).getAlc51();
							temp7 = viewList.get(i).getBkg51();
							temp8 = viewList.get(i).getPref51();
							temp9 = viewList.get(i).getPrf51();
							break;
						case 6:
							temp4 = viewList.get(i).getQta61();
							temp5 = viewList.get(i).getFct61();
							temp6 = viewList.get(i).getAlc61();
							temp7 = viewList.get(i).getBkg61();
							temp8 = viewList.get(i).getPref61();
							temp9 = viewList.get(i).getPrf61();
							break;
					}
					if(temp4 == null) temp4 = "";
					
					sbufXML.append("<TD DATA-FORMAT=\"dfInteger\">" + temp4 + "</TD>\n");
					sbufXML.append("<TD DATA-FORMAT=\"dfInteger\">" + temp5 + "</TD>\n");
					sbufXML.append("<TD DATA-FORMAT=\"dfInteger\">" + temp6 + "</TD>\n");
					sbufXML.append("<TD DATA-FORMAT=\"dfInteger\">" + temp7 + "</TD>\n");
					sbufXML.append("<TD>" + temp8 + "</TD>\n");
					sbufXML.append("<TD>" + temp9 + "</TD>\n");
//					sbufXML.append("<TD>" + JSPUtil.getNull(rowSets[1].getString(typ[t]+w+m)) + "</TD>\n");
				}
				sbufXML.append("</TR>\n");
				
				if("N".equals(guideYn) && rhq_cd.equals("-") && !dir_cd.equals("TOTAL") && !rlane_cd.equals("TOTAL")){
					// L/F 구하기 위함.
					for(int w = 1 ; w <= duration ; w++){
						String temp1 = "";
						String tempw1 = "";	
						switch (w) {
							case 1:
								temp1 = viewList.get(i).getBsa1();
									tempw1 = viewList.get(i).getBsaw1();
								break;
							case 2:
								temp1 = viewList.get(i).getBsa2();
									tempw1 = viewList.get(i).getBsaw2();
								break;
							case 3:
								temp1 = viewList.get(i).getBsa3();
									tempw1 = viewList.get(i).getBsaw3();
								break;
							case 4:
								temp1 = viewList.get(i).getBsa4();
									tempw1 = viewList.get(i).getBsaw4();
								break;
							case 5:
								temp1 = viewList.get(i).getBsa5();
									tempw1 = viewList.get(i).getBsaw5();
								break;
							case 6:
								temp1 = viewList.get(i).getBsa6();
									tempw1 = viewList.get(i).getBsaw6();
								break;
						}
						
							if(temp1 == null || temp1.equals("")) temp1 = "0";
							if(tempw1 == null || tempw1.equals("")) tempw1 = "0";
						bsa[w]  = Double.parseDouble(temp1); // bsa[w] = rowSets[1].getInt("bsa"+w);
						ibsa[w] = ibsa[w] + bsa[w];
						sbsa[w] = sbsa[w] + bsa[w];
						tbsa[w] = tbsa[w] + bsa[w];
						
							bsaw[w]  = Double.parseDouble(tempw1); 
							ibsaw[w] = ibsaw[w] + bsaw[w];
							sbsaw[w] = sbsaw[w] + bsaw[w];
							tbsaw[w] = tbsaw[w] + bsaw[w];
						for(int m = 1 ; m <= 5 ; m++){
							String temp2 = "";
								String tempw2 = "";
							switch (w) {
								case 1:
									temp2 = viewList.get(i).getFct11()==""?null:viewList.get(i).getFct11();
										tempw2 = viewList.get(i).getBkgw1();
									break;
								case 2:
									temp2 = viewList.get(i).getFct21()==""?null:viewList.get(i).getFct21();
										tempw2 = viewList.get(i).getBkgw2();
									break;
								case 3:
									temp2 = viewList.get(i).getFct31()==""?null:viewList.get(i).getFct31();
										tempw2 = viewList.get(i).getBkgw3();
									break;
								case 4:
									temp2 = viewList.get(i).getFct41()==""?null:viewList.get(i).getFct41();
										tempw2 = viewList.get(i).getBkgw4();
									break;
								case 5:
									temp2 = viewList.get(i).getFct51()==""?null:viewList.get(i).getFct51();
										tempw2 = viewList.get(i).getBkgw5();
									break;
								case 6:
									temp2 = viewList.get(i).getFct61()==""?null:viewList.get(i).getFct61();
									break;
							}
							
							if(temp2 == null || temp2.equals("")) temp2 = "0";
							if(tempw2 == null || tempw2.equals("")) tempw2 = "0";
							
							fct[w][m]  = Double.parseDouble(temp2);
							ifct[w][m] = ifct[w][m] + fct[w][m];
							sfct[w][m] = sfct[w][m] + fct[w][m];
							tfct[w][m] = tfct[w][m] + fct[w][m];
								bkgWgt[w][m]  = Double.parseDouble(tempw2);
								ibkgWgt[w][m] = ibkgWgt[w][m] + bkgWgt[w][m];
								sbkgWgt[w][m] = sbkgWgt[w][m] + bkgWgt[w][m];
								tbkgWgt[w][m] = tbkgWgt[w][m] + bkgWgt[w][m];
						}
					}
				}
				
				if( !next_gid.equals(gid) && (!rlane_cd.equals("TOTAL") || !next_sub_trd_cd.equals(sub_trd_cd) || !next_dest.equals(dest)) ){
					double[] tb   = new double[duration+1];
					double[][] tf = new double[duration+1][6];

					// BSA
					sbufXML.append("<TR LEVEL=\"0\" MERGE=\"true\" BGCOLOR=\"236,231,247\">\n");
					sbufXML.append("<TD DATA-ALIGN=\"daCenter\" BGCOLOR=\"223,232,247\"><![CDATA[" + dest + "]]></TD>\n");
					
					if(!dest.equals(" ") && rlane_cd.equals("TOTAL")){
						sbufXML.append("<TD DATA-ALIGN=\"daCenter\" BGCOLOR=\"223,232,247\"><![CDATA[" + dest + " TTL" + "]]></TD>\n");
					}else{
						sbufXML.append("<TD DATA-ALIGN=\"daCenter\">").append(sub_trd_cd.equals("TOTAL")?"Trade":sub_trd_cd).append(dir_cd.equals("TOTAL")?"":((rlane_cd.equals("TOTAL")?"":" / " + rlane_cd.substring(0, 3)))).append("</TD>\n");
					}
					sbufXML.append("<TD DATA-ALIGN=\"daCenter\" INDENT=\"1\"></TD>\n");
					sbufXML.append("<TD INDENT=\"1\"></TD>\n");
					sbufXML.append("<TD INDENT=\"1\"></TD>\n");
					sbufXML.append("<TD INDENT=\"1\"></TD>\n");
					
					sbufXML.append("<TD INDENT=\"1\"></TD>\n");//add
					sbufXML.append("<TD INDENT=\"1\"></TD>\n");//add
					sbufXML.append("<TD INDENT=\"1\"></TD>\n");//add
					
					sbufXML.append("<TD INDENT=\"1\"></TD>\n");
					sbufXML.append("<TD INDENT=\"1\">" + (row_num++) + "</TD>\n");
					//ho(office), hg0(guide for none office), hg(guide), hc1(USMode), hc2(Account), hc3(Dest)
					sbufXML.append("<TD INDENT=\"1\"></TD>\n");
					sbufXML.append("<TD INDENT=\"1\"></TD>\n");
					sbufXML.append("<TD INDENT=\"1\"></TD>\n");
					sbufXML.append("<TD INDENT=\"1\"></TD>\n");
					sbufXML.append("<TD INDENT=\"1\"></TD>\n");
					sbufXML.append("<TD INDENT=\"1\"></TD>\n");
					sbufXML.append("<TD></TD>\n");

					
//					double[] tb   = new double[duration+1];
					tb = sub_trd_cd.equals("TOTAL")?tbsa:(dest.equals(" ")&&(sub_trd_cd.equals("IA")||sub_trd_cd.equals("IP"))?ibsa:(rlane_cd.equals("TOTAL")?sbsa:bsa));
					for(int w = 1 ; w <= duration ; w++){
						double lbsa = tb[w];
						for(int m = 1 ; m <= 1 ; m++){
							sbufXML.append("<TD DATA-FORMAT=\"dfNone\" DATA-ALIGN=\"daCenter\">BSA</TD>\n");
							sbufXML.append("<TD DATA-FORMAT=\"dfInteger\" DATA-ALIGN=\"daRight\">" + lbsa + "</TD>\n");
							sbufXML.append("<TD DATA-FORMAT=\"dfNone\"></TD>\n");
							sbufXML.append("<TD DATA-FORMAT=\"dfNone\"></TD>\n");
							sbufXML.append("<TD DATA-FORMAT=\"dfNone\"></TD>\n");
							sbufXML.append("<TD DATA-FORMAT=\"dfNone\"></TD>\n");
						}
					}
					sbufXML.append("</TR>\n");
					
					
					String localArea = condition.getArea();
					String localOffice = condition.getSalesOffice();
					if( (localArea == null || localArea.equals("")) && (localOffice == null  || localOffice.equals("")) ){
						// L/F
						sbufXML.append("<TR LEVEL=\"0\" MERGE=\"true\" BGCOLOR=\"236,231,247\">\n");
						sbufXML.append("<TD DATA-ALIGN=\"daCenter\" BGCOLOR=\"223,232,247\"><![CDATA[" + dest + "]]></TD>\n");
						
						if(!dest.equals(" ") && rlane_cd.equals("TOTAL")){
							sbufXML.append("<TD DATA-ALIGN=\"daCenter\" BGCOLOR=\"223,232,247\"><![CDATA[" + dest + " TTL" + "]]></TD>\n");
						}else{
							sbufXML.append("<TD DATA-ALIGN=\"daCenter\">").append(sub_trd_cd.equals("TOTAL")?"Trade":sub_trd_cd).append(dir_cd.equals("TOTAL")?"":((rlane_cd.equals("TOTAL")?"":" / " + rlane_cd.substring(0, 3)))).append("</TD>\n");
						}
						sbufXML.append("<TD DATA-ALIGN=\"daCenter\" INDENT=\"1\"></TD>\n");
						sbufXML.append("<TD DATA-ALIGN=\"daCenter\" INDENT=\"1\"></TD>\n");
						sbufXML.append("<TD DATA-ALIGN=\"daCenter\" INDENT=\"1\"></TD>\n");
						sbufXML.append("<TD DATA-ALIGN=\"daCenter\" INDENT=\"1\"></TD>\n");
						
						sbufXML.append("<TD INDENT=\"1\"></TD>\n");//add
						sbufXML.append("<TD INDENT=\"1\"></TD>\n");//add
						sbufXML.append("<TD INDENT=\"1\"></TD>\n");//add
						
						sbufXML.append("<TD INDENT=\"1\"></TD>\n");
						sbufXML.append("<TD INDENT=\"1\">" + (row_num++) + "</TD>\n");
						//ho(office), hg0(guide for none office), hg(guide), hc1(USMode), hc2(Account), hc3(Dest)
						sbufXML.append("<TD INDENT=\"1\"></TD>\n");
						sbufXML.append("<TD INDENT=\"1\"></TD>\n");
						sbufXML.append("<TD INDENT=\"1\"></TD>\n");
						sbufXML.append("<TD INDENT=\"1\"></TD>\n");
						sbufXML.append("<TD INDENT=\"1\"></TD>\n");
						sbufXML.append("<TD INDENT=\"1\"></TD>\n");
						sbufXML.append("<TD></TD>\n");
						
	//					double[][] tf = new double[duration+1][6];
						tf = sub_trd_cd.equals("TOTAL")?tfct:(dest.equals(" ")&&(sub_trd_cd.equals("IA")||sub_trd_cd.equals("IP"))?ifct:(rlane_cd.equals("TOTAL")?sfct:fct));
						for(int w = 1 ; w <= duration ; w++){
							double lbsa = tb[w];
							for(int m = 1 ; m <= 1 ; m++){
								double lfct = tf[w][m];
								sbufXML.append("<TD DATA-FORMAT=\"dfNone\" DATA-ALIGN=\"daCenter\">L/F</TD>\n");
								sbufXML.append("<TD DATA-FORMAT=\"dfNone\" DATA-ALIGN=\"daRight\">" + (lbsa==0?0:Math.round(lfct*100.0/lbsa)) + "%</TD>\n");
								sbufXML.append("<TD DATA-FORMAT=\"dfNone\"></TD>\n");
								sbufXML.append("<TD DATA-FORMAT=\"dfNone\"></TD>\n");
								sbufXML.append("<TD DATA-FORMAT=\"dfNone\"></TD>\n");
								sbufXML.append("<TD DATA-FORMAT=\"dfNone\"></TD>\n");
							}
						}
						sbufXML.append("</TR>\n");
				    }
					// Port Rotation
					if(!(sub_trd_cd.equals("TOTAL")||rlane_cd.equals("TOTAL"))){
//						sbufXML.append("</TR>\n");
						sbufXML.append("<TR LEVEL=\"0\" MERGE=\"true\" BGCOLOR=\"236,231,247\">\n");
						sbufXML.append("<TD DATA-ALIGN=\"daCenter\" BGCOLOR=\"223,232,247\"><![CDATA[" + dest + "]]></TD>\n");
						
						if(!dest.equals(" ") && rlane_cd.equals("TOTAL")){
							sbufXML.append("<TD DATA-ALIGN=\"daCenter\" BGCOLOR=\"223,232,247\"><![CDATA[" + dest + " TTL" + "]]></TD>\n");
						}else{
							sbufXML.append("<TD DATA-ALIGN=\"daCenter\">").append(sub_trd_cd.equals("TOTAL")?"Trade":sub_trd_cd).append(dir_cd.equals("TOTAL")?"":((rlane_cd.equals("TOTAL")?"":" / " + rlane_cd.substring(0, 3)))).append("</TD>\n");
						}
						sbufXML.append("<TD DATA-ALIGN=\"daCenter\" INDENT=\"1\"></TD>\n");
						sbufXML.append("<TD INDENT=\"1\">Port Rotation</TD>\n");
						sbufXML.append("<TD INDENT=\"1\">Port Rotation</TD>\n");
						sbufXML.append("<TD INDENT=\"1\">Port Rotation</TD>\n");			
						
						sbufXML.append("<TD INDENT=\"1\"></TD>\n");//add
						sbufXML.append("<TD INDENT=\"1\"></TD>\n");//add
						sbufXML.append("<TD INDENT=\"1\"></TD>\n");//add
											
						sbufXML.append("<TD INDENT=\"1\"></TD>\n");
						sbufXML.append("<TD INDENT=\"1\">" + (row_num++) + "</TD>\n");
						//ho(office), hg0(guide for none office), hg(guide), hc1(USMode), hc2(Account), hc3(Dest)
						sbufXML.append("<TD INDENT=\"1\"></TD>\n");
						sbufXML.append("<TD INDENT=\"1\"></TD>\n");
						sbufXML.append("<TD INDENT=\"1\"></TD>\n");
						sbufXML.append("<TD INDENT=\"1\"></TD>\n");
						sbufXML.append("<TD INDENT=\"1\"></TD>\n");
						sbufXML.append("<TD INDENT=\"1\"></TD>\n");
						sbufXML.append("<TD></TD>\n");
						
						for(int w = 1 ; w <= duration ; w++){
							String tport = viewList.get(i).getPort1();
								
							sbufXML.append("<TD DATA-ALIGN=\"daCenter\" DATA-FORMAT=\"dfNone\">" + tport + "</TD>\n");
							sbufXML.append("<TD DATA-ALIGN=\"daCenter\" DATA-FORMAT=\"dfNone\">" + tport + "</TD>\n");
							sbufXML.append("<TD DATA-ALIGN=\"daCenter\" DATA-FORMAT=\"dfNone\">" + tport + "</TD>\n");
							sbufXML.append("<TD DATA-ALIGN=\"daCenter\" DATA-FORMAT=\"dfNone\">" + tport + "</TD>\n");
							sbufXML.append("<TD DATA-ALIGN=\"daCenter\" DATA-FORMAT=\"dfNone\">" + tport + "</TD>\n");
						}
						sbufXML.append("</TR>\n");
					}
					
					// Dest Sub TTL 의 BSA/F'cast Sub TTL 초기화
					if(rlane_cd.equals("TOTAL") && dest.equals(" ") && (sub_trd_cd.equals("IA")||sub_trd_cd.equals("IP"))){
						for(int w = 0 ; w <= duration ; w++){
							ibsa[w] = 0;
							for(int m = 1 ; m <= 5 ; m++){
								ifct[w][m] = 0;
								ibkgWgt[w][m] = 0;
							}
						}
					}
					
					// Sub Trade 별 BSA/F'cast Sub TTL 초기화
					if(rlane_cd.equals("TOTAL")){
						for(int w = 0 ; w <= duration ; w++){
							sbsa[w] = 0;
							for(int m = 1 ; m <= 5 ; m++){
								sfct[w][m] = 0;
								sbkgWgt[w][m] = 0;
							}
						}
					}
					
				}
			}
		}
//		else{		//3.9 데이타가 없는 경우
//			strWeek = strWeek;
//			strFdTd = strFdTd;
//		}
		
		sbufXML.append("</DATA>\n");
		sbufXML.append("<ETC-DATA>\n");
		sbufXML.append("<ETC KEY=\"week\">").append(strWeek.length()>0?strWeek.substring(1):"").append("</ETC>\n");
		sbufXML.append("<ETC KEY=\"fdtd\">").append(strFdTd.length()>0?strFdTd.substring(1):"").append("</ETC>\n");
		sbufXML.append("<ETC KEY=\"portv\">" + portv + "</ETC>\n");
		sbufXML.append("<ETC KEY=\"isSmp\">" + isSmp + "</ETC>\n");
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