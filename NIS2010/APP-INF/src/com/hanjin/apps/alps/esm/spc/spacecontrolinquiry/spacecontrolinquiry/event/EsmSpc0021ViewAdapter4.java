/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0021ViewAdapter4.java
*@FileTitle : spacecontrolinquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.13
*@LastModifier : SHKIM
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ComplexMainVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ETCVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiry021PfmcRatioVO;
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
public class EsmSpc0021ViewAdapter4 extends ViewAdapter{
	
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
		List<SearchSpaceControlInquiry021PfmcRatioVO> viewList = new ArrayList<SearchSpaceControlInquiry021PfmcRatioVO>();
		etc = comMain.getEtc();
		viewList = comMain.getSearchSpaceControlInquiry021PfmcRatioVOs();
		
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
		
		if (rowCountetc > 0 && etc != null) {//3.1
			weekCnt = rowCountetc;
			week    = new String[weekCnt];
			fdtd    = new String[weekCnt];
			
			for(int i = 0; i<rowCountetc ; i++){
				week[i] = JSPUtil.getNull(etc.get(i).getCostYr()) + JSPUtil.getNull(etc.get(i).getCostWk1());
				fdtd[i] = JSPUtil.getNull(etc.get(i).getSlsFmDt()) + "~" + JSPUtil.getNull(etc.get(i).getSlsToDt());
				strWeek = strWeek + "|" + week[i];
				strFdTd = strFdTd + "|" + fdtd[i];
			}
		}//3.9
		
		if (rowCountview > 0 && viewList != null) {//3.1
			int duration = Integer.parseInt(condition.getDuration());
			int level    = 0;
			
			String rlane_cd   = "";
			String dir_cd     = "";
			String sub_trd_cd = "";
			String rhq_cd      = "";
			String aq_cd      = "";
			String ofc_cd     = "";
			int row_cnt       = 0;
			double[] tbsa   = {0, 0, 0, 0, 0, 0, 0};
			double[] sbsa   = {0, 0, 0, 0, 0, 0, 0};
			double[] ibsa   = {0, 0, 0, 0, 0, 0, 0};	// IA 에 대한 Dest Sub TTL의 BSA
			double[] bsa    = new double[duration+1];
			
			for(int i =0 ; i < rowCountview ; i++){
				rlane_cd   = viewList.get(i).getRlaneCd();
				dir_cd     = viewList.get(i).getDirCd();
				sub_trd_cd = viewList.get(i).getSubTrdCd();
				
				rhq_cd      = viewList.get(i).getRhqCd();
				if(rhq_cd.equals("+")){
					rhq_cd = "-";
				}
				
				aq_cd      = viewList.get(i).getAqCd();
				if(aq_cd.equals("+")){
					aq_cd = "-";
				}
				
				ofc_cd = viewList.get(i).getOfcCd();
				if(ofc_cd.equals("+")){
					ofc_cd = "-";
				}
				
				if(row_cnt == 0){
					if(!dir_cd.equals("TOTAL")){
						sbufXML.append("<TR LEVEL=\"0\" MERGE=\"true\" BGCOLOR=\"232,255,198\">\n");
						
						if(dir_cd.equals("TOTAL")){
							sbufXML.append("<TD BGCOLOR=\"247,231,236\">" + sub_trd_cd).append(dir_cd.equals("TOTAL")?"":(" / " + (rlane_cd.equals("TOTAL")?rlane_cd:rlane_cd.substring(0, 3)))).append("</TD>\n");
						}else{
							sbufXML.append("<TD>" + sub_trd_cd).append(dir_cd.equals("TOTAL")?"":(" / " + (rlane_cd.equals("TOTAL")?rlane_cd:rlane_cd.substring(0, 3)))).append("</TD>\n");
						}
						
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
							
							String vvd = JSPUtil.getNull(temp3); // String vvd = JSPUtil.getNull(rowSets[1].getString("vvd"+w));
							for(int m = 1 ; m <= 1 ; m++){
								for(int t = 0 ; t < 6 ; t++){
									sbufXML.append("<TD DATA-FORMAT=\"dtNone\" DATA-ALIGN=\"daCenter\">" + vvd + "</TD>\n");
								}
							}
						}
						sbufXML.append("</TR>\n");
					}
				}
				
				row_cnt = row_cnt + Integer.parseInt(viewList.get(i).getCnt());// rs.getInt("cnt");
				
				if(row_cnt == 0){
					if(!dir_cd.equals("TOTAL")){
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
							
							bsa[w]  = Double.parseDouble(temp1); // bsa[w] = rowSets[1].getInt("bsa"+w);
							ibsa[w] = ibsa[w] + bsa[w];
							sbsa[w] = sbsa[w] + bsa[w];
							tbsa[w] = tbsa[w] + bsa[w];
						}
					}
				}
				
				
				level = aq_cd.equals("-")?0:(ofc_cd.equals("-")?1:2);
				
				sbufXML.append("<TR LEVEL=\"" + level + "\" BGCOLOR=\"").append(rhq_cd.equals("-")?"247,231,236":(aq_cd.equals("-")?"203,230,254":(ofc_cd.equals("-")?"253,251,151":""))).append("\">\n");
				
				if(dir_cd.equals("TOTAL")){
					sbufXML.append("<TD BGCOLOR=\"247,231,236\">").append(sub_trd_cd.equals("TOTAL")?"Trade":sub_trd_cd).append(dir_cd.equals("TOTAL")?"":((rlane_cd.equals("TOTAL")?"":" / " + rlane_cd.substring(0, 3)))).append("</TD>\n");
				}else{
					sbufXML.append("<TD>").append(sub_trd_cd.equals("TOTAL")?"Trade":sub_trd_cd).append(dir_cd.equals("TOTAL")?"":((rlane_cd.equals("TOTAL")?"":" / " + rlane_cd.substring(0, 3)))).append("</TD>\n");
				}
				sbufXML.append("<TD>").append((rlane_cd.equals("TOTAL")&&!dir_cd.equals("TOTAL"))?dir_cd:(!rhq_cd.equals("-")?rhq_cd:((sub_trd_cd.equals("TOTAL")?"Trade":sub_trd_cd)+(dir_cd.equals("TOTAL")?"":((rlane_cd.equals("TOTAL")?"":" / " + rlane_cd.substring(0, 3))))))).append("</TD>\n");
				sbufXML.append("<TD>").append((rlane_cd.equals("TOTAL")&&!dir_cd.equals("TOTAL"))?dir_cd:(!aq_cd.equals("-")?aq_cd:(!rhq_cd.equals("-")?rhq_cd+" ":((sub_trd_cd.equals("TOTAL")?"Trade":sub_trd_cd)+(dir_cd.equals("TOTAL")?"":((rlane_cd.equals("TOTAL")?"":" / " + rlane_cd.substring(0, 3)))))))).append("</TD>\n");
				sbufXML.append("<TD>").append(aq_cd.equals("-")?" TTL":(ofc_cd.equals("-")?aq_cd:ofc_cd)).append("</TD>\n");
				
				for(int w = 1 ; w <= duration ; w++){
					String temp4 = "";
					String temp5 = "";
					String temp6 = "";
					String temp7 = "";
					String temp8 = "";
					String temp9 = "";
					
					switch (w) {
						case 1: 
							temp4 = viewList.get(i).getFct11();
							temp5 = viewList.get(i).getFqta11();
							temp6 = viewList.get(i).getFbsa11();
							temp7 = viewList.get(i).getBkg11();
							temp8 = viewList.get(i).getBqta11();
							temp9 = viewList.get(i).getBbsa11();
							break;
						case 2:	
							temp4 = viewList.get(i).getFct21();
							temp5 = viewList.get(i).getFqta21();
							temp6 = viewList.get(i).getFbsa21();
							temp7 = viewList.get(i).getBkg21();
							temp8 = viewList.get(i).getBqta21();
							temp9 = viewList.get(i).getBbsa21();
							break;
						case 3:
							temp4 = viewList.get(i).getFct31();
							temp5 = viewList.get(i).getFqta31();
							temp6 = viewList.get(i).getFbsa31();
							temp7 = viewList.get(i).getBkg31();
							temp8 = viewList.get(i).getBqta31();
							temp9 = viewList.get(i).getBbsa31();
							break;
						case 4:
							temp4 = viewList.get(i).getFct41();
							temp5 = viewList.get(i).getFqta41();
							temp6 = viewList.get(i).getFbsa41();
							temp7 = viewList.get(i).getBkg41();
							temp8 = viewList.get(i).getBqta41();
							temp9 = viewList.get(i).getBbsa41();
							break;
						case 5:
							temp4 = viewList.get(i).getFct51();
							temp5 = viewList.get(i).getFqta51();
							temp6 = viewList.get(i).getFbsa51();
							temp7 = viewList.get(i).getBkg51();
							temp8 = viewList.get(i).getBqta51();
							temp9 = viewList.get(i).getBbsa51();
							break;
						case 6:
							temp4 = viewList.get(i).getFct61();
							temp5 = viewList.get(i).getFqta61();
							temp6 = viewList.get(i).getFbsa61();
							temp7 = viewList.get(i).getBkg61();
							temp8 = viewList.get(i).getBqta61();
							temp9 = viewList.get(i).getBbsa61();
							break;
					}
					
					if(temp4 == null) temp4 = "";
					
					// Sub Trade Total 일경우
					if(rlane_cd.equals("TOTAL") && aq_cd.equals("-") && !sub_trd_cd.equals("TOTAL")){	 
						if(sbsa[w] == 0) {
							temp6 = "0%";
							temp9 = "0%";
						}else{
							temp6 = Math.round(Double.parseDouble(temp4) *100/sbsa[w]) + "%";
							temp9 = Math.round(Double.parseDouble(temp7) *100/sbsa[w]) + "%";
						}
					}
					
					// Trade Total 일경우
					if(rlane_cd.equals("TOTAL") && aq_cd.equals("-") && sub_trd_cd.equals("TOTAL")){	 
						if(tbsa[w] == 0) {
							temp6 = "0%";
							temp9 = "0%";
						}else{
							temp6 = Math.round(Double.parseDouble(temp4) *100/tbsa[w]) + "%";
							temp9 = Math.round(Double.parseDouble(temp7) *100/tbsa[w]) + "%";
						}
					}
					
					sbufXML.append("<TD>" + temp4 + "</TD>\n");
					sbufXML.append("<TD>" + temp5 + "</TD>\n");
					sbufXML.append("<TD>" + temp6 + "</TD>\n");
					sbufXML.append("<TD>" + temp7 + "</TD>\n");
					sbufXML.append("<TD>" + temp8 + "</TD>\n");
					sbufXML.append("<TD>" + temp9 + "</TD>\n");
				}
				sbufXML.append("</TR>\n");
				
				if(row_cnt == 0){
					
					// Sub Trade 별 BSA/F'cast Sub TTL 초기화
					if(rlane_cd.equals("TOTAL")){
						for(int w = 0 ; w <= duration ; w++){
							sbsa[w] = 0;
						}
					}
					
					// Port Rotation
					if(!(sub_trd_cd.equals("TOTAL")||rlane_cd.equals("TOTAL"))){
						sbufXML.append("<TR LEVEL=\"0\" MERGE=\"true\" BGCOLOR=\"236,231,247\">\n");
						
						sbufXML.append("<TD>").append(sub_trd_cd.equals("TOTAL")?"Trade":sub_trd_cd).append(dir_cd.equals("TOTAL")?"":((rlane_cd.equals("TOTAL")?"":" / " + rlane_cd.substring(0, 3)))).append("</TD>\n");
						sbufXML.append("<TD INDENT=\"1\">Port Rotation</TD>\n");
						sbufXML.append("<TD INDENT=\"1\">Port Rotation</TD>\n");
						sbufXML.append("<TD INDENT=\"1\">Port Rotation</TD>\n");
						
						for(int w = 1 ; w <= duration ; w++){
							String tport = viewList.get(i).getPort1();
							for(int m = 1 ; m <= 1 ; m++){
								
								sbufXML.append("<TD DATA-ALIGN=\"daCenter\" DATA-FORMAT=\"dfNone\">" + tport + "</TD>\n");
								sbufXML.append("<TD DATA-ALIGN=\"daCenter\" DATA-FORMAT=\"dfNone\">" + tport + "</TD>\n");
								sbufXML.append("<TD DATA-ALIGN=\"daCenter\" DATA-FORMAT=\"dfNone\">" + tport + "</TD>\n");
								sbufXML.append("<TD DATA-ALIGN=\"daCenter\" DATA-FORMAT=\"dfNone\">" + tport + "</TD>\n");
								sbufXML.append("<TD DATA-ALIGN=\"daCenter\" DATA-FORMAT=\"dfNone\">" + tport + "</TD>\n");
								sbufXML.append("<TD DATA-ALIGN=\"daCenter\" DATA-FORMAT=\"dfNone\">" + tport + "</TD>\n");
							}
						}
						
						sbufXML.append("</TR>\n");
					}
				}
			}
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