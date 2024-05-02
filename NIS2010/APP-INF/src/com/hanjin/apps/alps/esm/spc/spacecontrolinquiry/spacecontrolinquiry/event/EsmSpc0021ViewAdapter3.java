/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0021ViewAdapter3.java
*@FileTitle : spacecontrolinquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.13 한상훈
* 1.0 Creation
* 2009.11.24 CHOI.Y.S - GS 분리
* 2011.07.05 이행지 [CHM-201111946-01] Daily F"cast Status 화면 보완 - Dest. 컬럼 추가
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ComplexMainVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ETCVO;
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
public class EsmSpc0021ViewAdapter3 extends ViewAdapter{
	
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
		
		DBRowSet rs = new DBRowSet();
		rs = comMain.getRs();
//		DBRowSet rstitle = new DBRowSet();
//		rstitle = comMain.getRstitle();
		List<ETCVO> etc = new ArrayList<ETCVO>();
		etc = comMain.getEtc();
		
		SearchSpaceControlInquiryConditionVO condition = comMain.getCondition();
		
		int rowCountetc  = etc.size();
		int rowCount = vos.size();
		
		sbufXML.append("<DATA TOTAL=\""+rowCount+"\">\n");
					
		int weekCnt    = 0;
		String[] week  = null;
		String[] fdtd  = null;
		String strWeek = "";
		String strFdTd = "";
		String portv   = condition.getChkview();
		
		if (rowCountetc>0 && rowCount > 0) {//3.1
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

		if (rs.getRowCount()>0 && rowCount > 0) {//3.1
			int duration       = Integer.parseInt(condition.getDuration());
			int level          = 0;
			String[] typ       = {"qta", "fct", "alc", "bkg", "pref"};
			String rlane_cd    = "";
			String dir_cd      = "";
			String sub_trd_cd  = "";
			String aq_cd       = "";
			String ofc_cd      = "";
			String dest       = "";
			int row_cnt        = 0;
			int dummy          = 0;
			int[] tbsa         = {0, 0, 0, 0, 0, 0, 0};
			int[] sbsa         = {0, 0, 0, 0, 0, 0, 0};
			int[] ibsa         = {0, 0, 0, 0, 0, 0, 0};
			int[] bsa          = new int[duration+1];
			//int[][] lf         = new String[duration+1][6];
			int[][] fct        = new int[duration+1][6];
			int[][] ifct       = new int[duration+1][6];
			int[][] sfct       = new int[duration+1][6];
			int[][] tfct       = new int[duration+1][6];
			double[] trdGap    = new double[duration+1];
			double[] subtrdGap = new double[duration+1];
			double[] rqta      = new double[duration+1];
			double[] rfct      = new double[duration+1];
			double[] rrfct     = new double[duration+1];
			String tdValue     = "";
			
			DecimalFormat df = new DecimalFormat("###.#");
			
			for(int w = 1 ; w <= duration ; w++){
				trdGap[w]    = 0;
				subtrdGap[w] = 0;
			}
			
			try{
				while (rs.next()) {//4.1
					rlane_cd   = rs.getString("rlane_cd");
					dir_cd     = rs.getString("dir_cd");
					sub_trd_cd = rs.getString("sub_trd_cd");
					aq_cd      = rs.getString("aq_cd");
					if(aq_cd.equals("+")){
						aq_cd = "-";
					}
					ofc_cd = rs.getString("ofc_cd");
//					if(ofc_cd.equals("+")){
//						ofc_cd = "-";
//					}
					dest = rs.getString("dest");
					
					if(row_cnt == 0){
						if(!(aq_cd.equals("-") && dir_cd.equals("TOTAL"))){		// Trade, Sub Trade의 Total이 아닐경우   
							for(int w = 1 ; w <= duration ; w++){
								bsa[w]  = rs.getInt("bsa"+w);
								ibsa[w] = ibsa[w] + bsa[w];
								sbsa[w] = sbsa[w] + bsa[w];
								tbsa[w] = tbsa[w] + bsa[w];
								for(int m = 1 ; m <= 5 ; m++){
									dummy = 1;
									//fct[w][m] = rs.getInt("fct"+w+m);
									fct[w][m]  = rs.getInt("fct"+w+dummy);
									ifct[w][m] = ifct[w][m] + fct[w][m];
									sfct[w][m] = sfct[w][m] + fct[w][m];
									tfct[w][m] = tfct[w][m] + fct[w][m];
								}
							}
							
							sbufXML.append("<TR LEVEL=\"0\" MERGE=\"true\" BGCOLOR=\"232,255,198\">\n");
							sbufXML.append("<TD BGCOLOR=\"223,232,247\"><![CDATA[" + dest + "]]></TD>\n");
							
							if(!dest.equals(" ") && rlane_cd.equals("TOTAL")){
								sbufXML.append("<TD BGCOLOR=\"223,232,247\"><![CDATA[" + dest + " TTL" + "]]></TD>\n");
							}else{
								sbufXML.append("<TD>" + sub_trd_cd).append(dir_cd.equals("TOTAL")?"":(" / " + (rlane_cd.equals("TOTAL")?rlane_cd:rlane_cd.substring(0, 3)))).append("</TD>\n");
							}
							sbufXML.append("<TD></TD>\n");
							sbufXML.append("<TD INDENT=\"1\"></TD>\n");
							sbufXML.append("<TD INDENT=\"1\"></TD>\n");
							
							for(int w = 1 ; w <= duration ; w++){
								String vvd = JSPUtil.getNull(rs.getString("vvd"+w));
								for(int m = 1 ; m <= 1 ; m++){
									for(int t = 0 ; t < 5 ; t++){
										sbufXML.append("<TD DATA-FORMAT=\"dtNone\" DATA-ALIGN=\"daCenter\">"+vvd+"</TD>\n");
									}
								}
							}
							sbufXML.append("</TR>\n");
						}
					}
					row_cnt = row_cnt + rs.getInt("cnt");
					//if(aq_cd.equals("-") && dir_cd.equals("TOTAL")){
						//continue;
					//}
					level = aq_cd.equals("-")?0:(ofc_cd.equals("+")?1:2);
					
					sbufXML.append("<TR LEVEL=\""+level+"\" BGCOLOR=\"").append(aq_cd.equals("-")?"247,231,236":"").append("\">\n");
					sbufXML.append("<TD ><![CDATA[" + dest + "]]></TD>\n");
					if(!dest.equals(" ") && rlane_cd.equals("TOTAL")){
						sbufXML.append("<TD BGCOLOR=\"223,232,247\"><![CDATA[" + dest + " TTL" + "]]></TD>\n");
					}else{
						sbufXML.append("<TD>").append(sub_trd_cd.equals("TOTAL")?"Trade":sub_trd_cd).append(dir_cd.equals("TOTAL")?"":((rlane_cd.equals("TOTAL")?"":" / "+rlane_cd.substring(0, 3)))).append("</TD>\n");
					}
					sbufXML.append("<TD></TD>\n");
					sbufXML.append("<TD>").append((rlane_cd.equals("TOTAL")&&!dir_cd.equals("TOTAL"))?dir_cd:aq_cd).append("</TD>\n");
					sbufXML.append("<TD>").append(aq_cd.equals("-")?"":ofc_cd).append("</TD>\n");
					
					int[] bsatotal = new int[duration+1];
					bsatotal = sub_trd_cd.equals("TOTAL")?tbsa:(dest.equals(" ")&&sub_trd_cd.equals("IA")?ibsa:(rlane_cd.equals("TOTAL")?sbsa:bsa));
					
					for(int w = 1 ; w <= duration ; w++){
						for(int m = 1 ; m <= 1 ; m++){
							for(int t = 0 ; t < 5 ; t++){
								tdValue = JSPUtil.getNull(rs.getString(typ[t]+w+m));
								
								if(t == 0 && rlane_cd.equals("TOTAL") && aq_cd.equals("-") && dir_cd.equals("TOTAL")) {
									rqta[w] = Double.parseDouble(tdValue);
								}							
								
								if(t == 1 && !rlane_cd.equals("TOTAL") && aq_cd.equals("-")){							// Lane Total 일경우 
									if((bsa[w] - Double.parseDouble(tdValue)) < 0){
										subtrdGap[w] = subtrdGap[w] + (bsa[w] - Double.parseDouble(tdValue));
									}
								}
								
								if(t == 1 && rlane_cd.equals("TOTAL") && aq_cd.equals("-") && dir_cd.equals("TOTAL")){	// Sub Trade Total 일경우 
									rfct[w]   = Double.parseDouble(tdValue);		// 원본값 저장
									rrfct[w]  = rfct[w] + subtrdGap[w];				// 수정값 저장
									tdValue   = Double.toString(rrfct[w]);
									trdGap[w] = trdGap[w] + subtrdGap[w];
								}
								
								if(t == 1 && sub_trd_cd.equals("TOTAL") && rlane_cd.equals("TOTAL") && aq_cd.equals("-") && dir_cd.equals("TOTAL")){	// Trade Total 일경우
									rfct[w]  = Double.parseDouble(tdValue);
									rrfct[w] = rfct[w] + trdGap[w];
									tdValue  = Double.toString(rrfct[w]);
								}
								
								if(t == 4 && rlane_cd.equals("TOTAL") && aq_cd.equals("-") && dir_cd.equals("TOTAL") && rfct[w] != rrfct[w]){	// 원본값과 수정값이 같지 않을 경우 Perf 재계산
									if(rqta[w] == 0) tdValue = "0%";
									else tdValue = df.format(rrfct[w]/rqta[w]*100) + "%";
								}
								
								sbufXML.append("<TD>"+tdValue+"</TD>\n");
							}
						}
					}
					
					sbufXML.append("</TR>\n");
	
					if(row_cnt == 0){
						sbufXML.append("<TR LEVEL=\"0\" MERGE=\"true\" BGCOLOR=\"236,231,247\">\n");
						sbufXML.append("<TD><![CDATA[" + dest + "]]></TD>\n");
						
						if(!dest.equals(" ") && rlane_cd.equals("TOTAL")){
							sbufXML.append("<TD BGCOLOR=\"223,232,247\"><![CDATA[" + dest + " TTL" + "]]></TD>\n");
						}else{
							sbufXML.append("<TD>").append(sub_trd_cd.equals("TOTAL")?"Trade":sub_trd_cd).append(dir_cd.equals("TOTAL")?"":((rlane_cd.equals("TOTAL")?"":" / "+rlane_cd.substring(0, 3)))).append("</TD>\n");
						}
						sbufXML.append("<TD></TD>\n");
						sbufXML.append("<TD INDENT=\"1\"></TD>\n");
						sbufXML.append("<TD INDENT=\"1\"></TD>\n");
	
						int[] tb = new int[duration+1];
						int[][] tf = new int[duration+1][6];
						tb = sub_trd_cd.equals("TOTAL")?tbsa:(dest.equals(" ")&&sub_trd_cd.equals("IA")?ibsa:(rlane_cd.equals("TOTAL")?sbsa:bsa));
						tf = sub_trd_cd.equals("TOTAL")?tfct:(dest.equals(" ")&&sub_trd_cd.equals("IA")?ifct:(rlane_cd.equals("TOTAL")?sfct:fct));
						for(int w = 1 ; w <= duration ; w++){
							int lbsa = tb[w];
								for(int m = 1 ; m <= 1 ; m++){
									double lfct = tf[w][m];
									
									if(sub_trd_cd.equals("TOTAL") && rlane_cd.equals("TOTAL") && aq_cd.equals("-")){
										lfct = lfct + trdGap[w];
									} else if(rlane_cd.equals("TOTAL") && aq_cd.equals("-")){
										lfct = lfct + subtrdGap[w];
										subtrdGap[w] = 0;
									}
									
									sbufXML.append("<TD DATA-FORMAT=\"dfNone\" DATA-ALIGN=\"daCenter\">BSA</TD>\n");
									sbufXML.append("<TD DATA-FORMAT=\"dfInteger\" DATA-ALIGN=\"daRight\">" + lbsa + "</TD>\n");
									sbufXML.append("<TD DATA-FORMAT=\"dfNone\"></TD>\n");
									sbufXML.append("<TD DATA-FORMAT=\"dfNone\" DATA-ALIGN=\"daCenter\">L/F</TD>\n");
									sbufXML.append("<TD DATA-ALIGN=\"daRight\">").append(lbsa==0?0:Math.round(lfct*100.0/lbsa)).append("%</TD>\n");
								}
						}
						
						if(rlane_cd.equals("TOTAL") && dest.equals(" ") && (sub_trd_cd.equals("IA") || sub_trd_cd.equals("IP")) ){
							for(int w = 0 ; w <= duration ; w++){
								ibsa[w] = 0;
								for(int m = 1 ; m <= 5 ; m++){
									ifct[w][m] = 0;
								}
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
						sbufXML.append("</TR>\n");
					}
				}
			}catch(SQLException e){
				throw new RuntimeException(e.getMessage());
			}catch(Exception e){
				log.error(e.getMessage(),e);
				throw new RuntimeException(e.getMessage());
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