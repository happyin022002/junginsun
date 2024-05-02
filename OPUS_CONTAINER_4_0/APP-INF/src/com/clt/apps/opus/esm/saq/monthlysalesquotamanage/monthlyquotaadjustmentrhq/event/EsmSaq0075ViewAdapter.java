/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSaq0075ViewAdapter.java
*@FileTitle : Regional Group Vs Regional Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : Choi.M.C
*@LastVersion : 1.0
* 2007-03-05 byyoo
* 1.0 Creation
* 2011.02.15 김종준 [T-선사] YEARLY QTA 부분 삭제
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.event;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.clt.apps.opus.esm.saq.common.SAQUtil;
import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.vo.MonthlyQuotaAdjustmentRhqVO;
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
public class EsmSaq0075ViewAdapter extends ViewAdapter{
	
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
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		// TODO Auto-generated method stub
		StringBuilder sbufXML = new StringBuilder();
		
		ReturnVO listVO = (ReturnVO)vos.get(0);
		QuotaConditionVO conditionVO = (QuotaConditionVO) listVO.getList(1);

		// Sheet 관련 색상 지정
		String bgColor[] = SAQUtil.getColors(5);
		String fontColor = "";			
		
		if(conditionVO.getChkCommand().equals("SEARCHLIST")||conditionVO.getChkCommand().equals("MODIFY01")){
			int uc_amt_unit = (conditionVO.getUnit().compareTo("F")==0 ? 2 : 1);
			int unit = 1;
			int unit_cost = 1;
			int grp = 0; // 1 : 수정가능 LANE, 0 : 수정불가 LANE
			int colorIdx = 0;
			String preLane = "";
			String preLaneGrp = "";
			String rgnGrp = "";
			boolean isInclProt = ("Y".equals(conditionVO.getInclPortFlag()) ? true : false);
			List<MonthlyQuotaAdjustmentRhqVO> list01=  (List<MonthlyQuotaAdjustmentRhqVO>) listVO.getList(0);
			int totCnt = list01.size();
			
			sbufXML.append("<DATA TOTAL='" + totCnt +"'>\n");
	
			if (totCnt != 0) {//3.1
				for(int j=0; j<totCnt; j++){
					MonthlyQuotaAdjustmentRhqVO colValues = list01.get(j);
					rgnGrp = colValues.getRgnGrp();
					// bgColor 구분에 필요...LANE의 첫번째 SPRT_GRP 만 수정 가능....
					if (preLaneGrp.equals(colValues.getLaneGrp()) == false) {						
						if (preLane.equals(colValues.getRlaneCd()+colValues.getSprtGrpCd())) {
							grp = 2; // 수정불가 RHQ
						} else {					
							grp = 1; // 수정가능 RHQ				
							preLane = colValues.getRlaneCd()+colValues.getSprtGrpCd();
						}
						preLaneGrp = colValues.getLaneGrp();
					}
					if( rgnGrp.equals("0") ){							
						colorIdx = 0;
					}else{
						colorIdx = grp;
					}

					// unit 적용 
					if (colValues.getItem().equals("Supply")
							|| colValues.getItem().equals("Volume")) {
						unit = (conditionVO.getUnit().compareTo("F")==0 ? 2 : 1);
						unit_cost = 1;
					} else if (colValues.getItem().equals("G.RPB")
							|| colValues.getItem().indexOf("CMPB") > -1
							|| colValues.getItem().indexOf("OPB") > -1) {
						unit = 1;
						unit_cost = (conditionVO.getUnit().compareTo("F")==0 ? 2 : 1);
					} else {
						unit = 1;
						unit_cost = 1;
					}
				
					sbufXML.append("<TR>");			
					sbufXML.append("	<TD BGCOLOR=\""+bgColor[1]+"\">"+colValues.getSubTrdCd()+"</TD>	");
					sbufXML.append("	<TD BGCOLOR=\""+bgColor[colorIdx]+"\"  COLOR=\"0,0,255\" >"+colValues.getConvLaneGrp()+"</TD>	");
					sbufXML.append("	<TD BGCOLOR=\""+bgColor[colorIdx]+"\"><![CDATA["+colValues.getPolCd()+"]]></TD>	");
					sbufXML.append("	<TD BGCOLOR=\""+bgColor[colorIdx]+"\"><![CDATA["+colValues.getPodCd()+"]]></TD>	");
					sbufXML.append("	<TD BGCOLOR=\""+bgColor[colorIdx]+"\"><![CDATA["+colValues.getCtrtAqCd()+"]]></TD>	");
					sbufXML.append("	<TD BGCOLOR=\""+bgColor[colorIdx]+"\">"+colValues.getCtrtRgnOfcCd()+"</TD>	");
					sbufXML.append("	<TD BGCOLOR=\""+bgColor[colorIdx]+"\">"+colValues.getItem()+"</TD>	");
					//display 관련 수치  항목은 소수점 1자리 반올림으로 보여준다. (0 은 "" 으로)
					sbufXML.append("	<TD BGCOLOR=\""+bgColor[colorIdx]+"\">"+SAQUtil.getZeroToNullString(JSPUtil.round(Double.parseDouble(JSPUtil.getNull(colValues.getRecentMonthly(),"0",false))/unit*unit_cost, -1))+"</TD>	");
					sbufXML.append("	<TD BGCOLOR=\""+bgColor[colorIdx]+"\">"+SAQUtil.getZeroToNullString(JSPUtil.round(Double.parseDouble(JSPUtil.getNull(colValues.getFcast01(),"0",false))/unit*unit_cost, -1))+"</TD>	");
					sbufXML.append("	<TD BGCOLOR=\""+bgColor[colorIdx]+"\">"+SAQUtil.getZeroToNullString(JSPUtil.round(Double.parseDouble(JSPUtil.getNull(colValues.getModel01(),"0",false))/unit*unit_cost, -1))+"</TD>	");
					sbufXML.append("	<TD BGCOLOR=\""+bgColor[colorIdx]+"\">"+SAQUtil.getZeroToNullString(JSPUtil.round(Double.parseDouble(JSPUtil.getNull(colValues.getInitial01(),"0",false))/unit*unit_cost, -1))+"</TD>	");
					sbufXML.append("	<TD BGCOLOR=\""+bgColor[colorIdx]+"\">"+SAQUtil.getZeroToNullString(JSPUtil.round(Double.parseDouble(JSPUtil.getNull(colValues.getFinal01(),"0",false))/unit*unit_cost, -1))+"</TD>	");
					if ( Integer.parseInt(JSPUtil.getNull(colValues.getItemCode(),"0",false)) == 2 && rgnGrp.equals("0") ) { 
						sbufXML.append("	<TD BGCOLOR=\""+bgColor[colorIdx]+"\"  COLOR=\"0,0,255\" >"+(isInclProt ? colValues.getPolCd()+"-"+colValues.getPodCd() : colValues.getLaneGrp())+"</TD>	");
					}else{
						sbufXML.append("	<TD BGCOLOR=\""+bgColor[colorIdx]+"\"></TD>	");
					}
					//key 관련 hidden 항목
					sbufXML.append("	<TD>"+grp+"</TD>");
					sbufXML.append("	<TD>"+colValues.getLaneGrp().substring(0,7)+"</TD>");
					sbufXML.append("	<TD>"+colValues.getCtrtRgnOfcCd()+colValues.getPolCd()+colValues.getPodCd()+"</TD>");
					sbufXML.append("	<TD>"+colValues.getRlaneCd()+"</TD>");
					sbufXML.append("	<TD>"+colValues.getSprtGrpCd()+"</TD>");
					sbufXML.append("	<TD>"+colValues.getBsaGrpCd()+"</TD>");
					sbufXML.append("	<TD>"+colValues.getItemCode()+"</TD>");
					sbufXML.append("	<TD>"+(colValues.getItem().equals("Volume") && rgnGrp.equals("0") ? "U" : "")+"</TD>");
					
					//계산 관련 hidden 항목
					sbufXML.append("	<TD>"+Double.parseDouble(JSPUtil.getNull(colValues.getFinal01(),"0",false))/unit*unit_cost+"</TD>");
					sbufXML.append("	<TD>"+Double.parseDouble(JSPUtil.getNull(colValues.getFinal01(),"0",false))/unit*unit_cost+"</TD>");
					sbufXML.append("	<TD>"+Double.parseDouble(JSPUtil.getNull(colValues.getTotLod(),"0",false))/unit+"</TD>");
					sbufXML.append("	<TD>"+Double.parseDouble(JSPUtil.getNull(colValues.getTotRpb(),"0",false))/uc_amt_unit+"</TD>");
					sbufXML.append("	<TD>"+Double.parseDouble(JSPUtil.getNull(colValues.getCmUcAmt(),"0",false))/uc_amt_unit+"</TD>");
					sbufXML.append("	<TD>"+Double.parseDouble(JSPUtil.getNull(colValues.getOpfitUcAmt(),"0",false))/uc_amt_unit+"</TD>");
					sbufXML.append("	<TD>"+Double.parseDouble(JSPUtil.getNull(colValues.getRaCmUcAmt(),"0",false))/uc_amt_unit+"</TD>");
					sbufXML.append("	<TD>"+Double.parseDouble(JSPUtil.getNull(colValues.getRaOpfitUcAmt(),"0",false))/uc_amt_unit+"</TD>");
					sbufXML.append("	<TD>"+Double.parseDouble(JSPUtil.getNull(colValues.getTotBsa(),"0",false))/unit+"</TD>");
					sbufXML.append("	<TD>"+Double.parseDouble(JSPUtil.getNull(colValues.getLowQty(),"0",false))/unit+"</TD>");
					sbufXML.append("	<TD>"+rgnGrp+"</TD>");
					sbufXML.append("</TR>\n");
					
				}
			}
			sbufXML.append("</DATA>\n");
			
		}
		else if(conditionVO.getChkCommand().equals("SEARCHLIST01")||conditionVO.getChkCommand().equals("SEARCHLIST02")
				||conditionVO.getChkCommand().equals("SEARCHLIST03")||conditionVO.getChkCommand().equals("SEARCHLIST04")){
		
			int bgLevel = 0;
			int unit = 1;
			int unit_cost = 1;
			double ratio_plus = 0;
			double ratio_percent = 0;
			
			List<MonthlyQuotaAdjustmentRhqVO> list01=  (List<MonthlyQuotaAdjustmentRhqVO>) listVO.getList(0);
			int totCnt = list01.size();

			String cellFormat = "";
			String cellColor = "";
			sbufXML.append("<DATA TOTAL='" + totCnt +"'>\n");
			
			if (totCnt != 0) {//3.1
				for(int j=0; j<totCnt; j++){

					MonthlyQuotaAdjustmentRhqVO colValues = list01.get(j);

					// unit 적용 
					if (colValues.getItem().equals("Supply")
							|| colValues.getItem().equals("Volume")) {
						unit = (conditionVO.getUnit().compareTo("F")==0 ? 2 : 1);
						unit_cost = 1;
					} else if (colValues.getItem().equals("G.RPB")
							|| colValues.getItem().indexOf("CMPB") > -1
							|| colValues.getItem().indexOf("OPB") > -1) {
						unit = 1;
						unit_cost = (conditionVO.getUnit().compareTo("F")==0 ? 2 : 1);
					} else {
						unit = 1;
						unit_cost = 1;
					}

					// L/F DATA-FORMAT, POINT-COUNT 설정
					if (colValues.getItem().equals("L/F")) {
						cellFormat = "DATA-FORMAT=\"dfFloat\" POINT-COUNT=\"1\" ";
					} else {
						cellFormat = "";
					}

					ratio_plus = Double.parseDouble(JSPUtil.getNull(colValues.getPfmcSmr(),"0",false)) - Double.parseDouble(JSPUtil.getNull(colValues.getPfmcQta(),"0",false));
					ratio_plus = JSPUtil.round(ratio_plus/unit*unit_cost, 0);
					ratio_percent = SAQUtil.getRatio(Double.parseDouble(JSPUtil.getNull(colValues.getPfmcSmr(),"0",false)), Double.parseDouble(JSPUtil.getNull(colValues.getPfmcQta(),"0",false)));

					bgLevel = Integer.parseInt(SAQUtil.getNvl(colValues.getSlevel(),"0"))-1;

					if(conditionVO.getChkCommand().equals("SEARCHLIST04")){
						fontColor = "COLOR=\"0,0,0\"";						
						if(colValues.getConvDirCd()!="") fontColor = "COLOR=\"255,0,0\"";											
						
						String rlane_cd = JSPUtil.getNull(colValues.getRlaneCd(),"",false);
						String ctrt_aq_cd = JSPUtil.getNull(colValues.getCtrtAqCd(),"",false);
						String ctrt_rgn_ofc_cd = JSPUtil.getNull(colValues.getCtrtRgnOfcCd(),"",false);
//						String rlane_image = "";
//						String ctrt_aq_image = "";
//						String ctrt_rgn_ofc_image = "";								
//						if( rlane_cd.toUpperCase().equals("TOTAL") ){
//							rlane_image = "IMAGE=\"0\"";
//						}else if( ctrt_aq_cd.toUpperCase().equals("TOTAL") ){
//							ctrt_aq_image = "IMAGE=\"0\"";
//						}else if( ctrt_rgn_ofc_cd.toUpperCase().equals("TOTAL") ){
//							ctrt_rgn_ofc_image = "IMAGE=\"0\"";
//						} 						
						if( ctrt_aq_cd == null || ctrt_aq_cd.length() == 0){
							ctrt_aq_cd = " ";
						}
						cellColor = bgColor[bgLevel];
						
//						sbufXML.append("<TR LEVEL=\""+colValues.getSlevel()+"\" expand=\"false\"> \n");
						sbufXML.append("<TR>");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"><![CDATA["+colValues.getSubTrdCd()+"]]></TD> \n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+fontColor+"><![CDATA["+rlane_cd+"]]></TD> \n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" ><![CDATA["+ctrt_aq_cd+"]]></TD> \n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" ><![CDATA["+ctrt_rgn_ofc_cd+"]]></TD> \n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"><![CDATA["+colValues.getItem()+"]]></TD> \n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"></TD> \n");
					}else if (conditionVO.getChkCommand().equals("SEARCHLIST03")) {
						// 조회 조건과 동일한 Bound 는 특정색으로 표시.
						if (conditionVO.getBound().equals(colValues.getDirCd())) {
							cellColor = SAQUtil.getHighlightColor(0);
						} else {
							cellColor = bgColor[(bgLevel == 1 ? 2 : bgLevel )];							
						}
						sbufXML.append("<TR> \n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"><![CDATA["+colValues.getSubTrdCd()+"]]></TD> \n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"><![CDATA["+colValues.getDirCd()+"]]></TD> \n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"><![CDATA["+colValues.getItem()+"]]></TD> \n");
					} else {
						// 조회 조건과 동일한 Trade/Bound 는 특정색으로 표시.
						if (conditionVO.getTrade().equals(colValues.getTrdCd()) 
								&& conditionVO.getBound().equals(colValues.getDirCd())) {
							cellColor = SAQUtil.getHighlightColor(0);
						} else {
							cellColor = bgColor[bgLevel];							
						}
						sbufXML.append("<TR> \n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"><![CDATA["+colValues.getTrdCd()+"]]></TD> \n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"><![CDATA["+colValues.getDirCd()+"]]></TD> \n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"><![CDATA["+colValues.getItem()+"]]></TD> \n");
					}
					
					sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+">"+SAQUtil.getZeroToNullString(Float.parseFloat(JSPUtil.getNull(colValues.getPfmcQta(),"0",false))/unit*unit_cost)+"</TD>	\n");
					sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+">"+SAQUtil.getZeroToNullString(Float.parseFloat(JSPUtil.getNull(colValues.getPfmcSmr(),"0",false))/unit*unit_cost)+"</TD>	\n");
					sbufXML.append("<TD BGCOLOR=\""+cellColor+"\">"+(ratio_plus > 0 ? "+" : "") + SAQUtil.getStringToCurr(String.valueOf((new Double(ratio_plus)).intValue()))+"</TD>	\n");
					sbufXML.append("<TD BGCOLOR=\""+cellColor+"\">"+(ratio_percent > 0 ? "+" : "") + ratio_percent+"</TD>	\n");
//					sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+">"+SAQUtil.getZeroToNullString(Float.parseFloat(JSPUtil.getNull(colValues.getRecentYr(),"0",false))/unit*unit_cost)+"</TD>	\n");
					sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+">"+SAQUtil.getZeroToNullString(Float.parseFloat(JSPUtil.getNull(colValues.getRecentMon(),"0",false))/unit*unit_cost)+"</TD>	\n");
					sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+">"+SAQUtil.getZeroToNullString(Float.parseFloat(JSPUtil.getNull(colValues.getForecastTot(),"0",false))/unit*unit_cost)+"</TD>	\n");
					sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+">"+SAQUtil.getZeroToNullString(Float.parseFloat(JSPUtil.getNull(colValues.getModelTot(),"0",false))/unit*unit_cost)+"</TD>	\n");
					if( conditionVO.getSearch_step() == null || !(conditionVO.getSearch_step()).equals("05") ){
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+">"+SAQUtil.getZeroToNullString(Float.parseFloat(JSPUtil.getNull(colValues.getInitialTot(),"0",false))/unit*unit_cost)+"</TD>	\n");
					}
					sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+">"+SAQUtil.getZeroToNullString(Float.parseFloat(JSPUtil.getNull(colValues.getFinalTot(),"0",false))/unit*unit_cost)+"</TD>	\n");
					
					// 월별 항목
					sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+">"+SAQUtil.getZeroToNullString(Float.parseFloat(JSPUtil.getNull(colValues.getFcast1(),"0",false))/unit*unit_cost)+"</TD>	\n");
					sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+">"+SAQUtil.getZeroToNullString(Float.parseFloat(JSPUtil.getNull(colValues.getMdlRst1(),"0",false))/unit*unit_cost)+"</TD>	\n");
					
					if( conditionVO.getSearch_step() == null || !(conditionVO.getSearch_step()).equals("05") ){
						
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+">"+SAQUtil.getZeroToNullString(Float.parseFloat(JSPUtil.getNull(colValues.getInitial1() ,"0",false))/unit*unit_cost)+"</TD>	\n");
					}
					sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+">"+SAQUtil.getZeroToNullString(Float.parseFloat(JSPUtil.getNull(colValues.getFinal1(),"0",false))/unit*unit_cost)+"</TD>	\n");
				
				
					sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+">"+SAQUtil.getZeroToNullString(Float.parseFloat(JSPUtil.getNull(colValues.getFcast2(),"0",false))/unit*unit_cost)+"</TD>	\n");
					sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+">"+SAQUtil.getZeroToNullString(Float.parseFloat(JSPUtil.getNull(colValues.getMdlRst2(),"0",false))/unit*unit_cost)+"</TD>	\n");
					
					if( conditionVO.getSearch_step() == null || !(conditionVO.getSearch_step()).equals("05") ){
						
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+">"+SAQUtil.getZeroToNullString(Float.parseFloat(JSPUtil.getNull(colValues.getInitial2() ,"0",false))/unit*unit_cost)+"</TD>	\n");
					}
					sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+">"+SAQUtil.getZeroToNullString(Float.parseFloat(JSPUtil.getNull(colValues.getFinal2(),"0",false))/unit*unit_cost)+"</TD>	\n");
				
				
					sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+">"+SAQUtil.getZeroToNullString(Float.parseFloat(JSPUtil.getNull(colValues.getFcast3(),"0",false))/unit*unit_cost)+"</TD>	\n");
					sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+">"+SAQUtil.getZeroToNullString(Float.parseFloat(JSPUtil.getNull(colValues.getMdlRst3(),"0",false))/unit*unit_cost)+"</TD>	\n");
					
					if( conditionVO.getSearch_step() == null || !(conditionVO.getSearch_step()).equals("05") ){
						
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+">"+SAQUtil.getZeroToNullString(Float.parseFloat(JSPUtil.getNull(colValues.getInitial3() ,"0",false))/unit*unit_cost)+"</TD>	\n");
					}
					sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+">"+SAQUtil.getZeroToNullString(Float.parseFloat(JSPUtil.getNull(colValues.getFinal3(),"0",false))/unit*unit_cost)+"</TD>	\n");
					
					
					sbufXML.append("</TR> \n");
				}//4.9
			}//3.9
			sbufXML.append("</DATA> \n");
		}
		else if(conditionVO.getChkCommand().equals("SEARCHLIST05")) {	//2.2
//			String rlane_grp = null;		//소스 품질 수정 요청건			
//			String subj_ctnt = null;	
//			String cmt_ctnt = null;
//			String rmk_cre_gdt = null;
//			String cre_ofc_cd = null;
			
			List<MonthlyQuotaAdjustmentRhqVO> list01=  (List<MonthlyQuotaAdjustmentRhqVO>) listVO.getList(0);
			int totCnt = list01.size();
			sbufXML.append("<DATA TOTAL='" + totCnt +"'>\n");
			for(int j=0; j<totCnt; j++){

				MonthlyQuotaAdjustmentRhqVO colValues = list01.get(j);
				sbufXML.append("<TR> \n");
				sbufXML.append("	<TD>"+colValues.getRlaneCd()+"</TD>");
				sbufXML.append("	<TD>"+colValues.getSprtGrpCd()+"</TD>");
				sbufXML.append("	<TD>"+colValues.getBsaGrpCd()+"</TD>");
				sbufXML.append("	<TD>"+colValues.getCtrtRgnOfcCd()+"</TD>");
				sbufXML.append("	<TD>"+colValues.getPolCd()+"</TD>");
				sbufXML.append("	<TD>"+colValues.getPodCd()+"</TD>");
				
//				sbufXML.append("	<TD>"+rlane_grp+"</TD>"); //소스 품질 수정 요청건	
//				sbufXML.append("	<TD><![CDATA["+subj_ctnt+"]]></TD>");
//				sbufXML.append("	<TD><![CDATA["+cmt_ctnt+"]]></TD>");
//				sbufXML.append("	<TD><![CDATA["+rmk_cre_gdt+"]]></TD>");
//				sbufXML.append("	<TD><![CDATA["+cre_ofc_cd+"]]></TD>");
				
				sbufXML.append("	<TD></TD>");
				sbufXML.append("	<TD></TD>");
				sbufXML.append("	<TD></TD>");
				sbufXML.append("	<TD></TD>");
				sbufXML.append("	<TD></TD>");
				sbufXML.append("</TR> \n");
			}
			sbufXML.append("</DATA> \n");
	
		}
		
		log.debug("EsmSaq0075ViewAdapter makeDataTag end");
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
			QuotaConditionVO conditionVO = (QuotaConditionVO) listVO.getList(1);
			
			// filter 에 필요한 항목을 담을 StringBuffer 선언
			StringBuffer subTrdCds = new StringBuffer();
			StringBuffer rlaneCds = new StringBuffer();
			StringBuffer rgnOfcCds = new StringBuffer();
			StringBuffer aqCds = new StringBuffer();		
			StringBuffer rgnOfcCdTotal = new StringBuffer();

			StringBuffer polCds = new StringBuffer();
			StringBuffer podCds = new StringBuffer();		
			StringBuffer itemCds = new StringBuffer();
			StringBuffer rlaneTotals = new StringBuffer();
			
			int realCnt = 0;
			String preLane = "";
			String preLaneGrp = "";
			String rgnGrp = "";
			String sub_trd_cd = null;
			String lane_grp = null;
			String ctrt_aq_cd = null;
			String ctrt_rgn_ofc_cd = null;
			
			if( conditionVO.getChkCommand().equals("SEARCHLIST")||conditionVO.getChkCommand().equals("MODIFY01")){
	
				List<MonthlyQuotaAdjustmentRhqVO> list01=  (List<MonthlyQuotaAdjustmentRhqVO>) listVO.getList(0);
				
				realCnt = list01.size();
				
				for(int i=0;i<realCnt;i++){
					
					MonthlyQuotaAdjustmentRhqVO colValues = list01.get(i);
					rgnGrp = colValues.getRgnGrp();
					
					if (preLaneGrp.equals(colValues.getLaneGrp()) == false) {						
						if (preLane.equals(colValues.getRlaneCd()+colValues.getSprtGrpCd())) {
							log.debug("");
						} else {		
							preLane = colValues.getRlaneCd()+colValues.getSprtGrpCd();
							// Apply 용 lane_grp 
							if( rlaneTotals.indexOf(colValues.getLaneGrp().substring(0,7)) < 0)
								rlaneTotals.append(colValues.getSubTrdCd()).append("|").append(colValues.getLaneGrp().substring(0,7)).append(";");
						}
						preLaneGrp = colValues.getLaneGrp();
					}

					sub_trd_cd = colValues.getSubTrdCd();
					lane_grp = colValues.getConvLaneGrp();
					ctrt_aq_cd = colValues.getCtrtAqCd();
					ctrt_rgn_ofc_cd = colValues.getCtrtRgnOfcCd();
					// filter 에 필요한 항목 리스트 작성
					if(subTrdCds.indexOf(colValues.getSubTrdCd()) < 0)
						subTrdCds.append(colValues.getSubTrdCd()).append(";");
					
					if(rlaneCds.indexOf(lane_grp) < 0){
						rlaneCds.append(sub_trd_cd).append("|").append(lane_grp).append(";");
					}	
					
					if(rgnOfcCds.indexOf(ctrt_rgn_ofc_cd) < 0)
						rgnOfcCds.append(ctrt_aq_cd).append("|").append(ctrt_rgn_ofc_cd).append(";");
					if(aqCds.indexOf(colValues.getCtrtAqCd()) < 0  )
						aqCds.append(colValues.getCtrtAqCd()).append(";");					
					if( "0".equals(colValues.getRgnGrp()) 
							&& rgnOfcCdTotal.indexOf(colValues.getCtrtRgnOfcCd()) < 0  )
						rgnOfcCdTotal.append(colValues.getCtrtRgnOfcCd()).append(";");

					if(polCds.indexOf(colValues.getPolCd()) < 0 && rgnGrp.equals("0") )
						polCds.append(colValues.getPolCd()).append(";");
					if(podCds.indexOf(colValues.getPodCd()) < 0 && rgnGrp.equals("0") )
						podCds.append(colValues.getPolCd()).append(";");
					if(itemCds.indexOf(colValues.getItem()) < 0)
						itemCds.append(colValues.getItem()).append(";");	
					
				}
				
				sb.append("<ETC KEY=\"version\">"+conditionVO.getNewVersion()+"</ETC>\n");
				sb.append("<ETC KEY=\"saqStsCd\">"+conditionVO.getSaqStsCd()+"</ETC>\n");
				sb.append("<ETC KEY=\"mqtaMdlVerNo\">"+conditionVO.getMqtaMdlVerNo()+"</ETC>\n");
				sb.append("<ETC KEY=\"slsFcastPubNo\">"+conditionVO.getSlsFcastPubNo()+"</ETC>\n");
				sb.append("<ETC KEY=\"inclPortFlag\">"+conditionVO.getInclPortFlag()+"</ETC>\n");
				sb.append("<ETC KEY=\"SUB_TRADE\">"+subTrdCds.toString()+"</ETC>\n");
				sb.append("<ETC KEY=\"LANE\"><![CDATA["+rlaneCds.toString()+"]]></ETC>\n");
				sb.append("<ETC KEY=\"RGN_OFC\">"+rgnOfcCds.toString()+"</ETC>\n");
				sb.append("<ETC KEY=\"AQ\">"+aqCds.toString()+"</ETC>\n");
				sb.append("<ETC KEY=\"RGN_OFC_TOTAL\">"+rgnOfcCdTotal.toString()+"</ETC>\n");
				sb.append("<ETC KEY=\"POL_CD\">"+polCds.toString()+"</ETC>\n");
				sb.append("<ETC KEY=\"POD_CD\">"+podCds.toString()+"</ETC>\n");
				sb.append("<ETC KEY=\"ITEM\">"+itemCds.toString()+"</ETC>\n");
				sb.append("<ETC KEY=\"LANE_TOTAL\">"+rlaneTotals.toString()+"</ETC>\n");
				
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