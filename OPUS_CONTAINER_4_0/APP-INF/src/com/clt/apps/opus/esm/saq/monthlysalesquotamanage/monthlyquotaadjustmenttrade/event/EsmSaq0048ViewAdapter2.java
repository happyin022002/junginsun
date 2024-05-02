/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSaq0048ViewAdapter2.java
*@FileTitle : Monthly Sales Quota Adjustment Trade Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : Choi.M.C
*@LastVersion : 1.0
* 2007-02-12 byyoo
* 1.0 Creation
* 2011.02.15 김종준 [T-선사] YEARLY QTA 부분 삭제
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.event;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.saq.common.SAQUtil;
import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.vo.SearchMonthlyAdjustmentTabTargetGroupListVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Choi.M.C
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EsmSaq0048ViewAdapter2 extends ViewAdapter {

	public EsmSaq0048ViewAdapter2() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception 
	 */	
	@SuppressWarnings("unchecked")
	@Override
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		// TODO Auto-generated method stub
		StringBuilder sbufXML = new StringBuilder();
	
		ReturnVO listVO = (ReturnVO)vos.get(0);
		QuotaConditionVO conditionVO = listVO.getConditionVO();
		List<SearchMonthlyAdjustmentTabTargetGroupListVO> searchMonthlyGuidelineTargetGroupListVOs = (List<SearchMonthlyAdjustmentTabTargetGroupListVO>) listVO.getList(0);
		
		int totCnt = 0;
		
		if(searchMonthlyGuidelineTargetGroupListVOs.size() != 0) {
			
			totCnt  = searchMonthlyGuidelineTargetGroupListVOs.size();
			
			//Sheet 관련 색상 지정
			String bgColor[] = SAQUtil.getColors(4);
			String fontColor = "";
			
			if( conditionVO.getChkCommand().equals("SEARCHLIST01") 
					|| conditionVO.getChkCommand().equals("SEARCHLIST02")
					|| conditionVO.getChkCommand().equals("SEARCHLIST03")
					|| conditionVO.getChkCommand().equals("SEARCHLIST04")) {
				
				int bgLevel = 0;
				int unit = 1;
				int unit_cost = 1;
				double ratio_plus = 0;
				double ratio_percent = 0;
	
				String[] strMonIndex = {"1", "2", "3"};
				//String cellFormat = "";
				String cellColor = "";
				
				sbufXML.append("<DATA TOTAL='" + totCnt +"'>\n");
			
				for(int i=0;i<totCnt;i++){ // for start
					
					Map<String, String> colValues = searchMonthlyGuidelineTargetGroupListVOs.get(i).getColumnValues();
					
					if (conditionVO.getChkCommand().equals("SEARCHLIST04")) {
						if( colValues.get("item").equals("BSA") || colValues.get("item").equals("L/F") ){
							continue;
						}
					}
		
					// unit 적용 
					if (colValues.get("item").equals("Supply")
							|| colValues.get("item").equals("Volume")) {
						unit = (conditionVO.getUnit().compareTo("F")==0 ? 2 : 1);
						unit_cost = 1;
					} else if (colValues.get("item").equals("G.RPB")
							|| colValues.get("item").indexOf("CMPB") > -1
							|| colValues.get("item").indexOf("OPB") > -1) {
						unit = 1;
						unit_cost = (conditionVO.getUnit().compareTo("F")==0 ? 2 : 1);
					} else {
						unit = 1;
						unit_cost = 1;
					}
		
//					// L/F DATA-FORMAT, POINT-COUNT 설정
//					if (colValues.get("item").equals("L/F")) {
//						cellFormat = "DATA-FORMAT=\"dfFloat\" POINT-COUNT=\"1\" ";
//					} else {
//						cellFormat = "";
//					}
		
					ratio_plus = Double.parseDouble(SAQUtil.getNvl(colValues.get("pfmc_smr"),"0")) - Double.parseDouble(SAQUtil.getNvl(colValues.get("pfmc_qta"),"0"));
					ratio_plus = JSPUtil.round(ratio_plus/unit*unit_cost, 0);
					ratio_percent = SAQUtil.getRatio(Double.parseDouble(SAQUtil.getNvl(colValues.get("pfmc_smr"),"0")), Double.parseDouble(SAQUtil.getNvl(colValues.get("pfmc_qta"),"0")));
		
					bgLevel = Integer.parseInt(SAQUtil.getNvl(colValues.get("slevel"),"0"))-1;
					
					if (conditionVO.getChkCommand().equals("SEARCHLIST04")) {
						fontColor = "COLOR=\"0,0,0\"";
						//if(colValues.get("conv_dir_cd")!="") fontColor = "COLOR=\"255,0,0\"";			
						if(!"".equals(colValues.get("conv_dir_cd"))) fontColor = "COLOR=\"255,0,0\""; //소스 품질 수정 요청건	
						
						cellColor = bgColor[bgLevel];
						String rlane_cd = colValues.get("rlane_cd");
						String sub_trd_cd = colValues.get("sub_trd_cd");
						if( rlane_cd.toUpperCase().equals("TOTAL") ){
							rlane_cd = "TOTAL";
						}else if( sub_trd_cd.toUpperCase().equals("TOTAL") ){
							sub_trd_cd = "TOTAL";
						}
		
//						sbufXML.append("<TR LEVEL=\""+colValues.get("slevel")+"\" expand=\"false\" >\n");
						sbufXML.append("<TR>\n"); // 트리제거로 인하여 변경
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" ></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" ><![CDATA["+colValues.get("ctrt_rhq_cd")+"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" ><![CDATA["+sub_trd_cd+"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+ fontColor +"><![CDATA["+rlane_cd+"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" ><![CDATA["+colValues.get("item")+"]]></TD>\n");
	
					} else if (conditionVO.getChkCommand().equals("SEARCHLIST03")) {
						// 조회 조건과 동일한 Bound 는 특정색으로 표시.
						if (conditionVO.getBound().equals(colValues.get("dir_cd"))) {
							cellColor = SAQUtil.getHighlightColor(0);
						} else {
							cellColor = bgColor[(bgLevel == 1 ? 2 : bgLevel )];							
						}
		
						sbufXML.append("<TR>");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" ><![CDATA["+colValues.get("sub_trd_cd")+"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" ><![CDATA["+colValues.get("dir_cd")+"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" ><![CDATA["+colValues.get("item")+"]]></TD>\n");
		
					} else {
						// 조회 조건과 동일한 Trade/Bound 는 특정색으로 표시.
						if (conditionVO.getTrade().equals(colValues.get("trd_cd")) 
								&& conditionVO.getBound().equals(colValues.get("dir_cd"))) {
							cellColor = SAQUtil.getHighlightColor(0);
						} else {
							cellColor = bgColor[bgLevel];							
						}
						sbufXML.append("<TR>");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" ><![CDATA["+colValues.get("trd_cd")+"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" ><![CDATA["+colValues.get("dir_cd")+"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" ><![CDATA["+colValues.get("item")+"]]></TD>\n");
	
					}
					if (colValues.get("item").equals("L/F")) {
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"   ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("pfmc_qta"),"0"))/unit*unit_cost+"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("pfmc_smr"),"0"))/unit*unit_cost+"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" ><![CDATA["+(ratio_plus > 0 ? "+" : "") + SAQUtil.getStringToCurr(String.valueOf((new Double(ratio_plus)).intValue()))+"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" ><![CDATA["+(ratio_percent > 0 ? "+" : "") + ratio_percent+"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("recent_mon"),"0"))/unit*unit_cost+"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("forecast_tot"),"0"))/unit*unit_cost+"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("model_tot"),"0"))/unit*unit_cost+"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("trade_tot"),"0"))/unit*unit_cost+"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("rhq_tot"),"0"))/unit*unit_cost+"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("final_tot"),"0"))/unit*unit_cost+"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("adjusted_tot"),"0"))/unit*unit_cost+"]]></TD>\n");
		
						for(int j=0; j<3; j++) {
						// 월별 항목
			
							sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("fcast_"+strMonIndex[j]),"0"))/unit*unit_cost+"]]></TD>\n");
							sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("mdl_rst_"+strMonIndex[j]),"0"))/unit*unit_cost+"]]></TD>\n");
							sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("trade_"+strMonIndex[j]),"0"))/unit*unit_cost+"]]></TD>\n");
							sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("rhq_"+strMonIndex[j]),"0"))/unit*unit_cost+"]]></TD>\n");
							sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("final_"+strMonIndex[j]),"0"))/unit*unit_cost+"]]></TD>\n");
							sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("adjusted_"+strMonIndex[j]),"0"))/unit*unit_cost+"]]></TD>\n");
							
						}
					}else{
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+(int)(Float.parseFloat(SAQUtil.getNvl(colValues.get("pfmc_qta"),"0"))/unit*unit_cost)+"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+(int)(Float.parseFloat(SAQUtil.getNvl(colValues.get("pfmc_smr"),"0"))/unit*unit_cost)+"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" ><![CDATA["+(ratio_plus > 0 ? "+" : "") + SAQUtil.getStringToCurr(String.valueOf((new Double(ratio_plus)).intValue()))+"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" ><![CDATA["+(ratio_percent > 0 ? "+" : "") + ratio_percent+"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+(int)(Float.parseFloat(SAQUtil.getNvl(colValues.get("recent_mon"),"0"))/unit*unit_cost)+"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+(int)(Float.parseFloat(SAQUtil.getNvl(colValues.get("forecast_tot"),"0"))/unit*unit_cost)+"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+(int)(Float.parseFloat(SAQUtil.getNvl(colValues.get("model_tot"),"0"))/unit*unit_cost)+"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+(int)(Float.parseFloat(SAQUtil.getNvl(colValues.get("trade_tot"),"0"))/unit*unit_cost)+"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+(int)(Float.parseFloat(SAQUtil.getNvl(colValues.get("rhq_tot"),"0"))/unit*unit_cost)+"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+(int)(Float.parseFloat(SAQUtil.getNvl(colValues.get("final_tot"),"0"))/unit*unit_cost)+"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+(int)(Float.parseFloat(SAQUtil.getNvl(colValues.get("adjusted_tot"),"0"))/unit*unit_cost)+"]]></TD>\n");
		
						for(int j=0; j<3; j++) {
						// 월별 항목
			
							sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+(int)(Float.parseFloat(SAQUtil.getNvl(colValues.get("fcast_"+strMonIndex[j]),"0"))/unit*unit_cost)+"]]></TD>\n");
							sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+(int)(Float.parseFloat(SAQUtil.getNvl(colValues.get("mdl_rst_"+strMonIndex[j]),"0"))/unit*unit_cost)+"]]></TD>\n");
							sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+(int)(Float.parseFloat(SAQUtil.getNvl(colValues.get("trade_"+strMonIndex[j]),"0"))/unit*unit_cost)+"]]></TD>\n");
							sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+(int)(Float.parseFloat(SAQUtil.getNvl(colValues.get("rhq_"+strMonIndex[j]),"0"))/unit*unit_cost)+"]]></TD>\n");
							sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+(int)(Float.parseFloat(SAQUtil.getNvl(colValues.get("final_"+strMonIndex[j]),"0"))/unit*unit_cost)+"]]></TD>\n");
							sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+(int)(Float.parseFloat(SAQUtil.getNvl(colValues.get("adjusted_"+strMonIndex[j]),"0"))/unit*unit_cost)+"]]></TD>\n");
							
						}
					}
					
					
//					sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("pfmc_qta"),"0"))/unit*unit_cost+"]]></TD>\n");
//					sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("pfmc_smr"),"0"))/unit*unit_cost+"]]></TD>\n");
//					sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" ><![CDATA["+(ratio_plus > 0 ? "+" : "") + SAQUtil.getStringToCurr(String.valueOf((new Double(ratio_plus)).intValue()))+"]]></TD>\n");
//					sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" ><![CDATA["+(ratio_percent > 0 ? "+" : "") + ratio_percent+"]]></TD>\n");
//					sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("recent_mon"),"0"))/unit*unit_cost+"]]></TD>\n");
//					sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("forecast_tot"),"0"))/unit*unit_cost+"]]></TD>\n");
//					sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("model_tot"),"0"))/unit*unit_cost+"]]></TD>\n");
//					sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("trade_tot"),"0"))/unit*unit_cost+"]]></TD>\n");
//					sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("rhq_tot"),"0"))/unit*unit_cost+"]]></TD>\n");
//					sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("final_tot"),"0"))/unit*unit_cost+"]]></TD>\n");
//					sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("adjusted_tot"),"0"))/unit*unit_cost+"]]></TD>\n");
//	
//					for(int j=0; j<3; j++) {
//					// 월별 항목
//		
//						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("fcast_"+strMonIndex[j]),"0"))/unit*unit_cost+"]]></TD>\n");
//						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("mdl_rst_"+strMonIndex[j]),"0"))/unit*unit_cost+"]]></TD>\n");
//						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("trade_"+strMonIndex[j]),"0"))/unit*unit_cost+"]]></TD>\n");
//						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("rhq_"+strMonIndex[j]),"0"))/unit*unit_cost+"]]></TD>\n");
//						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("final_"+strMonIndex[j]),"0"))/unit*unit_cost+"]]></TD>\n");
//						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("adjusted_"+strMonIndex[j]),"0"))/unit*unit_cost+"]]></TD>\n");
//						
//					}
		
					sbufXML.append("</TR>");
				} // for end
				sbufXML.append("</DATA>\n");
	
	
			} else if( conditionVO.getChkCommand().equals("SEARCHLIST05")) {
				
				sbufXML.append("<DATA TOTAL='" + totCnt +"'>\n");
				
				for(int i=0;i<totCnt;i++){
					
					Map<String, String> colValues = searchMonthlyGuidelineTargetGroupListVOs.get(i).getColumnValues();
	
					String sprt_grp_cd = null;
					String bsa_grp_cd = null;
					String rlane_cd = null;
					String ctrt_rhq_cd = null;
					String rlane_grp = null;				
					String subj_ctnt = null;	
					String cmt_ctnt = null;
					String rmk_cre_gdt = null;
					String cre_ofc_cd = null;
	
					sprt_grp_cd =  JSPUtil.getNull(colValues.get("sprt_grp_cd"));
					bsa_grp_cd  =  JSPUtil.getNull(colValues.get("bsa_grp_cd"));
					rlane_cd    =  JSPUtil.getNull(colValues.get("rlane_cd"));
					ctrt_rhq_cd =  JSPUtil.getNull(colValues.get("ctrt_rhq_cd"));
					rlane_grp   =  JSPUtil.getNull(colValues.get("rlane_grp"));
					subj_ctnt   =  JSPUtil.getNull(colValues.get("subj_ctnt"));
					cmt_ctnt    =  JSPUtil.getNull(colValues.get("cmt_ctnt"));
					rmk_cre_gdt =  JSPUtil.getNull(colValues.get("rmk_cre_gdt"));	
					cre_ofc_cd  =  JSPUtil.getNull(colValues.get("cre_ofc_cd"));
	
					sbufXML.append("<TR>");
					sbufXML.append("<TD><![CDATA["+rlane_cd+"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+sprt_grp_cd+"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+bsa_grp_cd+"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+ctrt_rhq_cd+"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+rlane_grp+"]]></TD>\n");
					
					sbufXML.append("<TD><![CDATA["+subj_ctnt+"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+cmt_ctnt+"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+rmk_cre_gdt+"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+cre_ofc_cd+"]]></TD>\n");
					sbufXML.append("</TR>");
	
				}
				sbufXML.append("</DATA>\n");
			}
		}
		return sbufXML.toString();
	}
	
	
	@SuppressWarnings("unchecked")
	protected String getETCData(EventResponse eventResponse) { 
		if(eventResponse==null) 
		return ""; 

		StringBuilder sb = new StringBuilder(); 
		HashMap<String, String> etc_data = (HashMap<String, String>) eventResponse.getETCData();

		sb.append("<ETC-DATA>\n"); 
		if(etc_data !=null && etc_data.size()>0){ 
			Iterator it = etc_data.keySet().iterator(); 
			while(it.hasNext()) {
				String key = (String)it.next();
				String val = "" + etc_data.get(key); 
				sb.append("<ETC KEY='" + key + "'><![CDATA[" + val + "]]></ETC>\n");
				
			} 
		}

		sb.append("</ETC-DATA>\n"); 
		//Pivot 관련 ETC-DATA생성 
		sb.append(getPivotETCData(eventResponse)); 

		return sb.toString(); 
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
	@Override
	protected String makeDataTag(DBRowSet arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
