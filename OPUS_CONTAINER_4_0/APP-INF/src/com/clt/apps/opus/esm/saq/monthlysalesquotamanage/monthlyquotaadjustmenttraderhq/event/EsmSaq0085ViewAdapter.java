/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSaq0085ViewAdapter.java
*@FileTitle : Regional Group Vs. Trade Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : ChoiI.M.C
*@LastVersion : 1.0
* 2007-02-23 byyoo
* 1.0 Creation
* 2010.05.12 Kim Min Ah : 한달 판매목표 수립을 위한 수정
* 2011.02.15 김종준 [T-선사] YEARLY QTA 부분 삭제
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttraderhq.event;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.saq.common.SAQUtil;
import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttraderhq.vo.SearchMonthlyAdjustmentTradeRhqTabLaneListVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttraderhq.vo.SearchMonthlyQuotaAdjustmentTradeRhqListVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author ChoiI.M.C
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EsmSaq0085ViewAdapter extends ViewAdapter {

	public EsmSaq0085ViewAdapter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param colOrder String[] Column명 문자열 
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
		
		int totCnt = 0;
		
		//Sheet 관련 색상 지정
		String bgColor[] = SAQUtil.getColors(4);
		String fontColor = "";
		
		if( conditionVO.getChkCommand().equals("SEARCHLIST04")) {
			
			List<SearchMonthlyAdjustmentTradeRhqTabLaneListVO> searchMonthlyAdjustmentTradeRhqVOs = (List<SearchMonthlyAdjustmentTradeRhqTabLaneListVO>) listVO.getList(0);
			
			if(searchMonthlyAdjustmentTradeRhqVOs.size() != 0) {
				
				totCnt  = searchMonthlyAdjustmentTradeRhqVOs.size();
				
				int bgLevel = 0;
				int unit = 1;
				int unit_cost = 1;
				double ratio_plus = 0;
				double ratio_percent = 0;
	
				String[] strMonIndex = {"1", "2", "3"};
				String cellFormat = "";
				
				sbufXML.append("<DATA TOTAL='" + totCnt +"'>\n");
			
				for(int i=0;i<totCnt;i++){ // for start
					
					Map<String, String> colValues = searchMonthlyAdjustmentTradeRhqVOs.get(i).getColumnValues();
					
					if (colValues.get("item").equals("Supply")|| colValues.get("item").equals("Volume")) {
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
	
					// L/F DATA-FORMAT, POINT-COUNT 설정
					if (colValues.get("item").equals("L/F")) {
						cellFormat = "DATA-FORMAT=\"dfFloat\" POINT-COUNT=\"1\" ";
					} else {
						cellFormat = "";
					}
					
					ratio_plus = Double.parseDouble(SAQUtil.getNvl(colValues.get("pfmc_smr"),"0")) - Double.parseDouble(SAQUtil.getNvl(colValues.get("pfmc_qta"),"0"));
					ratio_plus = JSPUtil.round(ratio_plus/unit*unit_cost, 0);
					ratio_percent = SAQUtil.getRatio(Double.parseDouble(SAQUtil.getNvl(colValues.get("pfmc_smr"),"0")), Double.parseDouble(SAQUtil.getNvl(colValues.get("pfmc_qta"),"0")));
					
					// BGCOLOR 설정
					bgLevel = Integer.parseInt(SAQUtil.getNvl(colValues.get("slevel"),"0"))-1;
//					String rlane_image = "";
//					String sub_trd_image = "";
//						
//					if( colValues.get("rlane_cd").toUpperCase().equals("TOTAL") ){
//						rlane_image = "IMAGE=\"0\"";				
//					}else if( colValues.get("sub_trd_cd").toUpperCase().equals("TOTAL") ){
//						sub_trd_image = "IMAGE=\"0\"";				
//					}		
					fontColor = "COLOR=\"0,0,0\"";
					//if(colValues.get("conv_dir_cd")!="") fontColor = "COLOR=\"255,0,0\"";
					if(!"".equals(colValues.get("conv_dir_cd"))) fontColor = "COLOR=\"255,0,0\""; //소스 품질 수정 요청건
					
					sbufXML.append("<TR>");
//					sbufXML.append("<TR LEVEL=\""+colValues.get("slevel")+"\" expand=\"false\" >\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[bgLevel]+"\"></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[bgLevel]+"\" ><![CDATA["+getNull(colValues.get("sub_trd_cd"))               +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[bgLevel]+"\" "+ fontColor +"><![CDATA["+getNull(colValues.get("rlane_cd"))   +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[bgLevel]+"\"><![CDATA["+getNull(colValues.get("item"))                        +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[bgLevel]+"\" "+cellFormat+"><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("pfmc_qta"),"0"))/unit*unit_cost+"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[bgLevel]+"\" "+cellFormat+"><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("pfmc_smr"),"0"))/unit*unit_cost+"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[bgLevel]+"\" ><![CDATA["+(ratio_plus > 0 ? "+" : "") + SAQUtil.getStringToCurr(String.valueOf((new Double(ratio_plus)).intValue()))+"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[bgLevel]+"\" ><![CDATA["+(ratio_percent > 0 ? "+" : "") + ratio_percent+"]]></TD>\n");
//					sbufXML.append("<TD BGCOLOR=\""+bgColor[bgLevel]+"\" "+cellFormat+" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("recent_yr"),"0"))/unit*unit_cost+"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[bgLevel]+"\" "+cellFormat+" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("recent_mon"),"0"))/unit*unit_cost+"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[bgLevel]+"\" "+cellFormat+" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("forecast_tot"),"0"))/unit*unit_cost+"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[bgLevel]+"\" "+cellFormat+" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("model_tot"),"0"))/unit*unit_cost+"]]></TD>\n");
//					sbufXML.append("<TD BGCOLOR=\""+bgColor[bgLevel]+"\" "+cellFormat+" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("yearly_tot"),"0"))/unit*unit_cost+"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[bgLevel]+"\" "+cellFormat+" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("trade_tot"),"0"))/unit*unit_cost+"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[bgLevel]+"\" "+cellFormat+" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("rhq_tot"),"0"))/unit*unit_cost+"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[bgLevel]+"\" "+cellFormat+" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("final_tot"),"0"))/unit*unit_cost+"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[bgLevel]+"\" "+cellFormat+" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("adjusted_tot"),"0"))/unit*unit_cost+"]]></TD>\n");
					
					for(int j=0; j<3; j++) {
						// 월별 항목
			
							sbufXML.append("<TD BGCOLOR=\""+bgColor[bgLevel]+"\" "+cellFormat+" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("fcast_"+strMonIndex[j]),"0"))/unit*unit_cost+"]]></TD>\n");
							sbufXML.append("<TD BGCOLOR=\""+bgColor[bgLevel]+"\" "+cellFormat+" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("mdl_rst_"+strMonIndex[j]),"0"))/unit*unit_cost+"]]></TD>\n");
//							sbufXML.append("<TD BGCOLOR=\""+bgColor[bgLevel]+"\" "+cellFormat+" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("yqta_"+strMonIndex[j]),"0"))/unit*unit_cost+"]]></TD>\n");
							sbufXML.append("<TD BGCOLOR=\""+bgColor[bgLevel]+"\" "+cellFormat+" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("trade_"+strMonIndex[j]),"0"))/unit*unit_cost+"]]></TD>\n");
							sbufXML.append("<TD BGCOLOR=\""+bgColor[bgLevel]+"\" "+cellFormat+" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("rhq_"+strMonIndex[j]),"0"))/unit*unit_cost+"]]></TD>\n");
							sbufXML.append("<TD BGCOLOR=\""+bgColor[bgLevel]+"\" "+cellFormat+" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("final_"+strMonIndex[j]),"0"))/unit*unit_cost+"]]></TD>\n");
							sbufXML.append("<TD BGCOLOR=\""+bgColor[bgLevel]+"\" "+cellFormat+" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("adjusted_"+strMonIndex[j]),"0"))/unit*unit_cost+"]]></TD>\n");
							
					}
		
					sbufXML.append("</TR>");
				} // for end
				sbufXML.append("</DATA>\n");
			}
	
		} else if( conditionVO.getChkCommand().equals("SEARCHLIST") || conditionVO.getChkCommand().equals("MODIFY02")) {
			
			List<SearchMonthlyQuotaAdjustmentTradeRhqListVO> searchMonthlyQuotaAdjustmentTradeRhqListVOs = (List<SearchMonthlyQuotaAdjustmentTradeRhqListVO>) listVO.getList(0);

			//2010.05.07 한달 판매목표 수립을 위한 수정 Start
			if(searchMonthlyQuotaAdjustmentTradeRhqListVOs.size() == 0){//There is no data 나오도록 함
				sbufXML.append("<DATA TOTAL='" + totCnt +"'>\n");
				sbufXML.append("</DATA>\n");
			}else{
			//if(searchMonthlyQuotaAdjustmentTradeRhqListVOs.size() != 0) {
			//2010.05.07 한달 판매목표 수립을 위한 수정 End
				
				totCnt  = searchMonthlyQuotaAdjustmentTradeRhqListVOs.size();
				
				int unit = 1;
				int unit_cost = 1;
				int grp = 0; // 1 : 수정가능 LANE, 0 : 수정불가 LANE
				int uc_amt_unit = (conditionVO.getUnit().compareTo("F")==0 ? 2 : 1);
				String preLane = "";
				String preLaneGrp = "";
				
				sbufXML.append("<DATA TOTAL='" + totCnt +"'>\n");
				
				for(int i=0;i<totCnt;i++){
					
					Map<String, String> colValues = searchMonthlyQuotaAdjustmentTradeRhqListVOs.get(i).getColumnValues();
					
					// BGCOLOR 구분에 필요					
					if (preLaneGrp.equals(colValues.get("lane_grp")) == false) {						
						if (preLane.equals(colValues.get("rlane_cd")+colValues.get("sprt_grp_cd"))) {
							grp = 0; // 수정불가 RHQ
						} else {
							grp = 1; // 수정가능 RHQ
							preLane = colValues.get("rlane_cd")+colValues.get("sprt_grp_cd");
						}
						preLaneGrp = colValues.get("lane_grp");
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
					
					sbufXML.append("<TR>");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[1]  +"\"><![CDATA["+getNull(colValues.get("sub_trd_cd"))                      +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[grp]+"\" COLOR=\"0,0,255\"><![CDATA["+getNull(colValues.get("conv_lane_grp")) +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[grp]+"\"><![CDATA["+getNull(colValues.get("rhq_cd"))                          +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[grp]+"\"><![CDATA["+getNull(colValues.get("item"))                            +"]]></TD>\n");
	
					// display 관련 수치  항목은 소수점 1자리 반올림으로 보여준다. (0 은 "" 으로)
//					sbufXML.append("<TD BGCOLOR=\""+bgColor[grp]+"\"><![CDATA["+SAQUtil.getZeroToNullString(JSPUtil.round(Double.parseDouble(SAQUtil.getNvl(colValues.get("recent_yearly"),"0"))/unit*unit_cost , -1))  +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[grp]+"\"><![CDATA["+SAQUtil.getZeroToNullString(JSPUtil.round(Double.parseDouble(SAQUtil.getNvl(colValues.get("recent_monthly"),"0"))/unit*unit_cost, -1))  +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[grp]+"\"><![CDATA["+SAQUtil.getZeroToNullString(JSPUtil.round(Double.parseDouble(SAQUtil.getNvl(colValues.get("fcast_01"),"0"))/unit*unit_cost	  , -1))    +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[grp]+"\"><![CDATA["+SAQUtil.getZeroToNullString(JSPUtil.round(Double.parseDouble(SAQUtil.getNvl(colValues.get("model_01"),"0"))/unit*unit_cost      , -1))  +"]]></TD>\n");
//					sbufXML.append("<TD BGCOLOR=\""+bgColor[grp]+"\"><![CDATA["+SAQUtil.getZeroToNullString(JSPUtil.round(Double.parseDouble(SAQUtil.getNvl(colValues.get("yearly_01"),"0"))/unit*unit_cost     , -1))  +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[grp]+"\"><![CDATA["+SAQUtil.getZeroToNullString(JSPUtil.round(Double.parseDouble(SAQUtil.getNvl(colValues.get("trade_01"),"0"))/unit*unit_cost      , -1))  +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[grp]+"\"><![CDATA["+SAQUtil.getZeroToNullString(JSPUtil.round(Double.parseDouble(SAQUtil.getNvl(colValues.get("rhq_01"),"0"))/unit*unit_cost        , -1))  +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[grp]+"\"><![CDATA["+SAQUtil.getZeroToNullString(JSPUtil.round(Double.parseDouble(SAQUtil.getNvl(colValues.get("final_01"),"0"))/unit*unit_cost      , -1))  +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[grp]+"\"><![CDATA["+SAQUtil.getZeroToNullString(JSPUtil.round(Double.parseDouble(SAQUtil.getNvl(colValues.get("adjusted_01"),"0"))/unit*unit_cost   , -1))  +"]]></TD>\n");
						
					if ( Integer.parseInt(colValues.get("item_code")) == 2 ) {
						sbufXML.append("<TD BGCOLOR=\""+bgColor[grp]+"\" COLOR=\"0,0,255\"><![CDATA["+ getNull(colValues.get("lane_grp")) +"]]></TD>\n");
						
				 	} else { 
				 		sbufXML.append("<TD BGCOLOR=\""+bgColor[grp] +"\"></TD>\n");			 		
				 	}
					sbufXML.append("<TD><![CDATA["+ colValues.get("rhq_cd")    +"]]></TD>\n");
					
					//key 관련 hidden 항목
					sbufXML.append("<TD><![CDATA["+ grp    +"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+ colValues.get("lane_grp").substring(0,7) +"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+ colValues.get("rlane_cd")                +"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+ colValues.get("sprt_grp_cd")             +"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+ colValues.get("bsa_grp_cd")              +"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+ colValues.get("item_code")               +"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+ (colValues.get("item").equals("Volume")?"U":"") +"]]></TD>\n");
	
					//계산 관련 hidden 항목
					sbufXML.append("<TD><![CDATA["+ Double.parseDouble(SAQUtil.getNvl(colValues.get("rhq_01"),"0"))/unit*unit_cost       +"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+ Double.parseDouble(SAQUtil.getNvl(colValues.get("rhq_01"),"0"))/unit*unit_cost       +"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+ Double.parseDouble(SAQUtil.getNvl(colValues.get("tot_lod"),"0"))/unit                +"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+ Double.parseDouble(SAQUtil.getNvl(colValues.get("tot_rpb"),"0"))*uc_amt_unit         +"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+ Double.parseDouble(SAQUtil.getNvl(colValues.get("cm_uc_amt"),"0"))*uc_amt_unit       +"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+ Double.parseDouble(SAQUtil.getNvl(colValues.get("opfit_uc_amt"),"0"))*uc_amt_unit    +"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+ Double.parseDouble(SAQUtil.getNvl(colValues.get("ra_cm_uc_amt"),"0"))*uc_amt_unit    +"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+ Double.parseDouble(SAQUtil.getNvl(colValues.get("ra_opfit_uc_amt"),"0"))*uc_amt_unit +"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+ Double.parseDouble(SAQUtil.getNvl(colValues.get("tot_bsa"),"0"))/unit                +"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+ Double.parseDouble(SAQUtil.getNvl(colValues.get("low_qty"),"0"))/unit                +"]]></TD>\n");
					sbufXML.append("</TR>\n");
				} // for end
				sbufXML.append("</DATA>\n");
			}
			
		}// for end
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
			while(it.hasNext()){ 
				String key = (String)it.next(); 
				String val = "" + etc_data.get(key); 
				sb.append("<ETC KEY=\"" + key + "\"><![CDATA[" + val + "]]></ETC>\n"); 
				
			} 
		}
		
		if(eventResponse.getRsVoList().size() != 0) {
			
			ReturnVO listVO = (ReturnVO)eventResponse.getRsVoList().get(0);
			QuotaConditionVO conditionVO = listVO.getConditionVO();
			
			// filter 에 필요한 항목을 담을 StringBuffer 선언
			StringBuffer subTrdCds   = new StringBuffer();
			StringBuffer rlaneCds    = new StringBuffer();
			StringBuffer itemCds     = new StringBuffer();
			StringBuffer rlaneTotals = new StringBuffer();
			
			String preLane    = "";
			String preLaneGrp = "";
			String subTrdCd   = null;
			
			int realCnt = 0;
			
			if( conditionVO.getChkCommand().equals("SEARCHLIST")||conditionVO.getChkCommand().equals("MODIFY02")){
					
				List<SearchMonthlyQuotaAdjustmentTradeRhqListVO> searchMonthlyQuotaAdjustmentTradeRhqListVOs = (List<SearchMonthlyQuotaAdjustmentTradeRhqListVO>) listVO.getList(0);
				
				realCnt = searchMonthlyQuotaAdjustmentTradeRhqListVOs.size();
				
				for(int i=0;i<realCnt;i++){
					
					Map<String, String> colValues = searchMonthlyQuotaAdjustmentTradeRhqListVOs.get(i).getColumnValues();
					
					if (preLaneGrp.equals(colValues.get("lane_grp")) == false) {						
						if (preLane.equals(colValues.get("rlane_cd")+colValues.get("sprt_grp_cd"))) {
							log.debug("getETCData if true block");	//2010-05-11 빈 Block문장들(if, for, while, do)을 점검
						} else { // Apply 용 lane_grp
							if(rlaneTotals.indexOf(colValues.get("lane_grp").substring(0,7)) < 0)
								rlaneTotals.append(colValues.get("sub_trd_cd")).append("|").append(colValues.get("lane_grp").substring(0,7)).append(";");
						}
						preLaneGrp = colValues.get("lane_grp");
					}
					subTrdCd = colValues.get("sub_trd_cd");
					
					// filter 에 필요한 항목 리스트 작성
					if(subTrdCds.indexOf(colValues.get("sub_trd_cd")) < 0)
						subTrdCds.append(colValues.get("sub_trd_cd")).append(";");
					if(rlaneCds.indexOf(colValues.get("conv_lane_grp")) < 0)
						rlaneCds.append(subTrdCd).append("|").append(colValues.get("conv_lane_grp")).append(";");
					if(itemCds.indexOf(colValues.get("item")) < 0)
						itemCds.append(colValues.get("item")).append(";");
				}
			}

			sb.append("<ETC KEY=\"SUB_TRADE\"><![CDATA["+ subTrdCds.toString()   +"]]></ETC>\n");
			sb.append("<ETC KEY=\"LANE\"><![CDATA["+ rlaneCds.toString()         +"]]></ETC>\n");
			sb.append("<ETC KEY=\"ITEM\"><![CDATA["+ itemCds.toString()          +"]]></ETC>\n");
			sb.append("<ETC KEY=\"LANE_TOTAL\"><![CDATA["+ rlaneTotals.toString()+"]]></ETC>\n");

		}
		
		sb.append("<ETC KEY=\"status\"><![CDATA[OK]]></ETC>\n");
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
