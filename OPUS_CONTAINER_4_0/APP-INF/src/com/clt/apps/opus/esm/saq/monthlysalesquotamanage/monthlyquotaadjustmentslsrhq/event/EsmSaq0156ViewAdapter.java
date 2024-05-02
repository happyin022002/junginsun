/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSaq0156ViewAdapter.java
*@FileTitle : Monthly Sales Quota Adjustment Sales RHQ
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : ChoiI.M.C
*@LastVersion : 1.0
* 2007-10-22 Lee Ho Ik
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentslsrhq.event;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.saq.common.SAQUtil;
import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentslsrhq.vo.SearchMonthlyQuotaAdjustmentSlsRhqListVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentslsrhq.vo.SearchMonthlyQuotaAdjustmentSlsRhqRMKListVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Lee Ho Ik
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EsmSaq0156ViewAdapter extends ViewAdapter {

	public EsmSaq0156ViewAdapter() {
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
		//AbstractValueObject vo = (AbstractValueObject)vos.get(0);
		
		ReturnVO listVO = (ReturnVO)vos.get(0);
		QuotaConditionVO conditionVO = listVO.getConditionVO();
		
		int totCnt = 0;
		
		//Sheet 관련 색상 지정
		String bgColor[] = SAQUtil.getColors(5);
		String fontColor = "";
		
		if( conditionVO.getChkCommand().equals("SEARCHLIST01") || conditionVO.getChkCommand().equals("SEARCHLIST02") || 
				conditionVO.getChkCommand().equals("SEARCHLIST03") || conditionVO.getChkCommand().equals("SEARCHLIST04")) {
			
			List<SearchMonthlyQuotaAdjustmentSlsRhqListVO> searchMonthlyAdjustmentSlsListVOs = (List<SearchMonthlyQuotaAdjustmentSlsRhqListVO>) listVO.getList(0);
			
			if(searchMonthlyAdjustmentSlsListVOs.size() != 0) {
				
				totCnt  = searchMonthlyAdjustmentSlsListVOs.size();
	
				int bgLevel = 0;
				int unit = 1;
				int unit_cost = 1;
				double ratio_plus = 0;
				double ratio_percent = 0;
	
				String[] strMonIndex = {"1", "2", "3"};
				//String cellFormat = "";
				String cellColor = "";
				
				sbufXML.append("<DATA TOTAL='" + totCnt +"'>\n");
			
				for(int i=0;i<totCnt;i++){
					
					Map<String, String> colValues = searchMonthlyAdjustmentSlsListVOs.get(i).getColumnValues();

					// unit 적용 
					if (colValues.get("item").equals("Supply") || colValues.get("item").equals("Volume")) {
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
						String rlane_cd = colValues.get("rlane_cd");
						String sls_aq_cd = colValues.get("sls_aq_cd");
						String sls_rgn_ofc_cd = colValues.get("sls_rgn_ofc_cd");
//						String rlane_image = "";
//						String sls_aq_image = "";
//						String sls_rgn_ofc_image = "";
//						if( rlane_cd.toUpperCase().equals("TOTAL") ){
//							rlane_image = "IMAGE=\"0\"";
//						}else if( sls_aq_cd.toUpperCase().equals("TOTAL") ){
//							sls_aq_image = "IMAGE=\"0\"";
//						}else if( sls_rgn_ofc_cd.toUpperCase().equals("TOTAL") ){
//							sls_rgn_ofc_image = "IMAGE=\"0\"";
//						}
						if( sls_aq_cd == null || sls_aq_cd.length() == 0){
							sls_aq_cd = " ";
						}
						cellColor = bgColor[bgLevel];
						//if(colValues.get("conv_dir_cd")!="") fontColor = "COLOR=\"255,0,0\"";
						if(!"".equals(colValues.get("conv_dir_cd"))) fontColor = "COLOR=\"255,0,0\""; //소스 품질 수정 요청건
						
//						sbufXML.append("<TR LEVEL=\""+colValues.get("slevel")+"\" expand=\"false\" >\n");
						sbufXML.append("<TR>");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"><![CDATA["+getNull(colValues.get("sub_trd_cd"))      +"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+ fontColor +"><![CDATA["+ rlane_cd +"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" ><![CDATA["+ sls_aq_cd              +"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" ><![CDATA["+ sls_rgn_ofc_cd    +"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"><![CDATA["+getNull(colValues.get("item"))            +"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"></TD>\n");

					} else if (conditionVO.getChkCommand().equals("SEARCHLIST03")) { 
						// Bound가 TOTAL이면 제외 
						if (!colValues.get("sub_trd_cd").equals("TOTAL") && colValues.get("dir_cd").equals("TOTAL")) {						
							continue;
						}						
						// 조회 조건과 동일한 Bound 는 특정색으로 표시.
						if (conditionVO.getBound().equals(colValues.get("dir_cd"))) {
							cellColor = SAQUtil.getHighlightColor(0);
						} else {
							cellColor = bgColor[(bgLevel == 1 ? 2 : bgLevel )];							
						}
						sbufXML.append("<TR>");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"><![CDATA["+getNull(colValues.get("sub_trd_cd")) +"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"><![CDATA["+getNull(colValues.get("dir_cd"))     +"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"><![CDATA["+getNull(colValues.get("item"))       +"]]></TD>\n");

					} else {
						// Bound가 TOTAL이면 제외 
						if (!colValues.get("trd_cd").equals("TOTAL") && colValues.get("dir_cd").equals("TOTAL")) {						
							continue;
						}
						// 조회 조건과 동일한 Trade/Bound 는 특정색으로 표시.
						if (conditionVO.getTrade().equals(colValues.get("trd_cd")) && conditionVO.getBound().equals(colValues.get("dir_cd"))) {
							cellColor = SAQUtil.getHighlightColor(0);
						} else {
							cellColor = bgColor[bgLevel];							
						}
					
						sbufXML.append("<TR>");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"><![CDATA["+getNull(colValues.get("trd_cd")) +"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"><![CDATA["+getNull(colValues.get("dir_cd")) +"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"><![CDATA["+getNull(colValues.get("item"))   +"]]></TD>\n");
					}
					
//					sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+"><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("pfmc_qta"),"0"))/unit*unit_cost+"]]></TD>\n");
//					sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+"><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("pfmc_smr"),"0"))/unit*unit_cost+"]]></TD>\n");
//					sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" ><![CDATA["+(ratio_plus > 0 ? "+" : "") + SAQUtil.getStringToCurr(String.valueOf((new Double(ratio_plus)).intValue()))+"]]></TD>\n");
//					sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" ><![CDATA["+(ratio_percent > 0 ? "+" : "") + ratio_percent+"]]></TD>\n");
//					sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("recent_mon"),"0"))/unit*unit_cost+"]]></TD>\n");
//					sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("fcast_tot"),"0"))/unit*unit_cost+"]]></TD>\n");
//					sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("mdl_rslt_tot"),"0"))/unit*unit_cost+"]]></TD>\n");
//					
//					if( conditionVO.getSearch_step() == null || !(conditionVO.getSearch_step()).equals("09") ){
//						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("initial_tot"),"0"))/unit*unit_cost+"]]></TD>\n");
//					}
//					sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("rhq_tot"),"0"))/unit*unit_cost+"]]></TD>\n");
//					
//					for(int j=0; j<3; j++) {
//						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("fcast_"+strMonIndex[j]),"0"))/unit*unit_cost+"]]></TD>\n");
//						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("mdl_rst_"+strMonIndex[j]),"0"))/unit*unit_cost+"]]></TD>\n");
//						
//						if( conditionVO.getSearch_step() == null || !(conditionVO.getSearch_step()).equals("09") ){
//							sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("initial_"+strMonIndex[j]),"0"))/unit*unit_cost+"]]></TD>\n");
//						}
//						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" "+cellFormat+" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("rhq_"+strMonIndex[j]),"0"))/unit*unit_cost+"]]></TD>\n");
					if (colValues.get("item").equals("L/F")) {
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("pfmc_qta"),"0"))/unit*unit_cost+"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("pfmc_smr"),"0"))/unit*unit_cost+"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" ><![CDATA["+(ratio_plus > 0 ? "+" : "") + SAQUtil.getStringToCurr(String.valueOf((new Double(ratio_plus)).intValue()))+"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" ><![CDATA["+(ratio_percent > 0 ? "+" : "") + ratio_percent+"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("recent_mon"),"0"))/unit*unit_cost+"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("fcast_tot"),"0"))/unit*unit_cost+"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("mdl_rslt_tot"),"0"))/unit*unit_cost+"]]></TD>\n");
						
						if( conditionVO.getSearch_step() == null || !(conditionVO.getSearch_step()).equals("09") ){
							sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("initial_tot"),"0"))/unit*unit_cost+"]]></TD>\n");
						}
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("rhq_tot"),"0"))/unit*unit_cost+"]]></TD>\n");
						
						for(int j=0; j<3; j++) {
							sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("fcast_"+strMonIndex[j]),"0"))/unit*unit_cost+"]]></TD>\n");
							sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("mdl_rst_"+strMonIndex[j]),"0"))/unit*unit_cost+"]]></TD>\n");
							
							if( conditionVO.getSearch_step() == null || !(conditionVO.getSearch_step()).equals("09") ){
								sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("initial_"+strMonIndex[j]),"0"))/unit*unit_cost+"]]></TD>\n");
							}
							sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+Float.parseFloat(SAQUtil.getNvl(colValues.get("rhq_"+strMonIndex[j]),"0"))/unit*unit_cost+"]]></TD>\n");
						}
					}else{
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" ><![CDATA["+(int)(Float.parseFloat(SAQUtil.getNvl(colValues.get("pfmc_qta"),"0"))/unit*unit_cost)+"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" ><![CDATA["+(int)(Float.parseFloat(SAQUtil.getNvl(colValues.get("pfmc_smr"),"0"))/unit*unit_cost)+"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" ><![CDATA["+(ratio_plus > 0 ? "+" : "") + SAQUtil.getStringToCurr(String.valueOf((new Double(ratio_plus)).intValue()))+"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\" ><![CDATA["+(ratio_percent > 0 ? "+" : "") + ratio_percent+"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+(int)(Float.parseFloat(SAQUtil.getNvl(colValues.get("recent_mon"),"0"))/unit*unit_cost)+"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+(int)(Float.parseFloat(SAQUtil.getNvl(colValues.get("fcast_tot"),"0"))/unit*unit_cost)+"]]></TD>\n");
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+(int)(Float.parseFloat(SAQUtil.getNvl(colValues.get("mdl_rslt_tot"),"0"))/unit*unit_cost)+"]]></TD>\n");
						
						if( conditionVO.getSearch_step() == null || !(conditionVO.getSearch_step()).equals("09") ){
							sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+(int)(Float.parseFloat(SAQUtil.getNvl(colValues.get("initial_tot"),"0"))/unit*unit_cost)+"]]></TD>\n");
						}
						sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+(int)(Float.parseFloat(SAQUtil.getNvl(colValues.get("rhq_tot"),"0"))/unit*unit_cost)+"]]></TD>\n");
						
						for(int j=0; j<3; j++) {
							sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+(int)(Float.parseFloat(SAQUtil.getNvl(colValues.get("fcast_"+strMonIndex[j]),"0"))/unit*unit_cost)+"]]></TD>\n");
							sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+(int)(Float.parseFloat(SAQUtil.getNvl(colValues.get("mdl_rst_"+strMonIndex[j]),"0"))/unit*unit_cost)+"]]></TD>\n");
							
							if( conditionVO.getSearch_step() == null || !(conditionVO.getSearch_step()).equals("09") ){
								sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+(int)(Float.parseFloat(SAQUtil.getNvl(colValues.get("initial_"+strMonIndex[j]),"0"))/unit*unit_cost)+"]]></TD>\n");
							}
							sbufXML.append("<TD BGCOLOR=\""+cellColor+"\"  ><![CDATA["+(int)(Float.parseFloat(SAQUtil.getNvl(colValues.get("rhq_"+strMonIndex[j]),"0"))/unit*unit_cost)+"]]></TD>\n");
						}
					} // for i end
					sbufXML.append("</TR> \n");
				} // for end
				sbufXML.append("</DATA>\n");
			}
		}else if(conditionVO.getChkCommand().equals("SEARCHLIST05")) {
			
			List<SearchMonthlyQuotaAdjustmentSlsRhqRMKListVO> searchMonthlyAdjustmentSlsListVOs = (List<SearchMonthlyQuotaAdjustmentSlsRhqRMKListVO>) listVO.getList(0);
			
			if(searchMonthlyAdjustmentSlsListVOs.size() != 0) {
				
				totCnt  = searchMonthlyAdjustmentSlsListVOs.size();
				
				String sprt_grp_cd = null;
				String bsa_grp_cd = null;
				String pol_cd = null;
				String pod_cd = null;
				String rlane_cd = null;
				String sls_rgn_ofc_cd = null;
				String rlane_grp = null;
				String subj_ctnt = null;
				String cmt_ctnt = null;
				String rmk_cre_gdt = null;
				String cre_ofc_cd = null;
				
				sbufXML.append("<DATA TOTAL='" + totCnt +"'>\n");
			
				for(int i=0;i<totCnt;i++){
					
					Map<String, String> colValues = searchMonthlyAdjustmentSlsListVOs.get(i).getColumnValues();

					sprt_grp_cd    = JSPUtil.getNull(colValues.get("sprt_grp_cd"));
					bsa_grp_cd     = JSPUtil.getNull(colValues.get("bsa_grp_cd"));
					pol_cd         = JSPUtil.getNull(colValues.get("pol_cd"));
					pod_cd         = JSPUtil.getNull(colValues.get("pod_cd"));
					rlane_cd       = JSPUtil.getNull(colValues.get("rlane_cd"));
					sls_rgn_ofc_cd = JSPUtil.getNull(colValues.get("sls_rgn_ofc_cd"));
					rlane_grp      = JSPUtil.getNull(colValues.get("rlane_grp"));
					subj_ctnt      = JSPUtil.getNull(colValues.get("subj_ctnt"));
					cmt_ctnt       = JSPUtil.getNull(colValues.get("cmt_ctnt"));
					rmk_cre_gdt    = JSPUtil.getNull(colValues.get("rmk_cre_gdt"));	
					cre_ofc_cd     = JSPUtil.getNull(colValues.get("cre_ofc_cd"));
					
					sbufXML.append("<TR>");
					sbufXML.append("<TD>"+rlane_cd+"</TD>\n");
					sbufXML.append("<TD>"+sprt_grp_cd+"</TD>\n");
					sbufXML.append("<TD>"+bsa_grp_cd+"</TD>\n");
					sbufXML.append("<TD>"+sls_rgn_ofc_cd+"</TD>\n");
					sbufXML.append("<TD>"+pol_cd+"</TD>\n");
					sbufXML.append("<TD>"+pod_cd+"</TD>\n");
					sbufXML.append("<TD>"+rlane_grp+"</TD>\n");
					
					sbufXML.append("<TD><![CDATA["+subj_ctnt+"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+cmt_ctnt+"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+rmk_cre_gdt+"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+cre_ofc_cd+"]]></TD>\n");
					sbufXML.append("</TR>");
				}
				sbufXML.append("</DATA>\n");
			} // for end

		} else if( conditionVO.getChkCommand().equals("SEARCHLIST") || conditionVO.getChkCommand().equals("MODIFY02")) {
			
			List<SearchMonthlyQuotaAdjustmentSlsRhqListVO> searchMonthlyAdjustmentSlsListVOs = (List<SearchMonthlyQuotaAdjustmentSlsRhqListVO>) listVO.getList(0);
			
			if(searchMonthlyAdjustmentSlsListVOs.size() != 0) {
				
				totCnt  = searchMonthlyAdjustmentSlsListVOs.size();
				
				int uc_amt_unit = (conditionVO.getUnit().compareTo("F")==0 ? 2 : 1);
				int unit = 1;
				int unit_cost = 1;
				int grp = 0; // 1 : 수정가능 LANE, 0 : 수정불가 LANE
				int colorIdx = 0;
				String preLane = "";
				String preLaneGrp = "";
				String rgnGrp = "";
				//boolean isCheckBox = false;
				boolean isInclProt = ("Y".equals(conditionVO.getInclPortFlag()) ? true : false);
				
				sbufXML.append("<DATA TOTAL='" + totCnt +"'>\n");
			
				for(int i=0;i<totCnt;i++){
					
					Map<String, String> colValues = searchMonthlyAdjustmentSlsListVOs.get(i).getColumnValues();

					if((colValues.get("item").equals("Supply") || colValues.get("item").equals("L/F")) && (!colValues.get("sls_rgn_ofc_cd").equals("Total"))) {	
						continue;
					}
				
					rgnGrp = colValues.get("rgn_grp");
					// BGCOLOR 구분에 필요...LANE의 첫번째 SPRT_GRP 만 수정 가능....
					if (preLaneGrp.equals(colValues.get("lane_grp")) == false) {						
						if (preLane.equals(colValues.get("rlane_cd")+colValues.get("sprt_grp_cd"))) {
							grp = 2; // 수정불가 RHQ
						} else {					
							grp = 1; // 수정가능 RHQ				
							preLane = colValues.get("rlane_cd")+colValues.get("sprt_grp_cd");
						}
						preLaneGrp = colValues.get("lane_grp");
					}
					
					if( rgnGrp.equals("0") ){							
						colorIdx = 0;
					}else{
						colorIdx = grp;
					}
					
					// unit 적용 
					if (colValues.get("item").equals("Supply") || colValues.get("item").equals("Volume")) {
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
					
					// check box 항목 여부  - 첫번째 그룹만 선택 가능 
					//if(rgnGrp.equals("0") && grp == 1 && (colValues.get("item").equals("Volume") 
					//				|| colValues.get("item").equals("G.REV")) ){ 
						//isCheckBox = true; 
					//} else {
						//isCheckBox = false;
					//}
					// -2010-05-10 빈 Block 문장들(if, for, while, do)을 점검, isCheckBox 이미주석처리되어있었음..

					sbufXML.append("<TR>");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[1]       +"\"><![CDATA["+getNull(colValues.get("sub_trd_cd"))                      +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[colorIdx]+"\" COLOR=\"0,0,255\"><![CDATA["+getNull(colValues.get("conv_lane_grp")) +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[colorIdx]+"\"><![CDATA["+(rgnGrp.equals("0") ?  colValues.get("pol_cd") : "  " )   +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[colorIdx]+"\"><![CDATA["+(rgnGrp.equals("0") ?  colValues.get("pod_cd") : "  " )   +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[colorIdx]+"\"><![CDATA["+getNull(colValues.get("sls_aq_cd"))                       +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[colorIdx]+"\"><![CDATA["+getNull(colValues.get("sls_rgn_ofc_cd"))                  +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[colorIdx]+"\"><![CDATA["+getNull(colValues.get("item"))                            +"]]></TD>\n");
					

					//display 관련 수치  항목은 소수점 1자리 반올림으로 보여준다. (0 은 "" 으로)
				
					sbufXML.append("<TD BGCOLOR=\""+bgColor[colorIdx]+"\"><![CDATA["+SAQUtil.getZeroToNullString(JSPUtil.round(Double.parseDouble(SAQUtil.getNvl(colValues.get("recent_monthly"),"0"))/unit*unit_cost, -1))  +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[colorIdx]+"\"><![CDATA["+SAQUtil.getZeroToNullString(JSPUtil.round(Double.parseDouble(SAQUtil.getNvl(colValues.get("fcast_01"),"0"))/unit*unit_cost	  , -1))    +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[colorIdx]+"\"><![CDATA["+SAQUtil.getZeroToNullString(JSPUtil.round(Double.parseDouble(SAQUtil.getNvl(colValues.get("model_01"),"0"))/unit*unit_cost      , -1))  +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[colorIdx]+"\"><![CDATA["+SAQUtil.getZeroToNullString(JSPUtil.round(Double.parseDouble(SAQUtil.getNvl(colValues.get("initial_01"),"0"))/unit*unit_cost     , -1)) +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[colorIdx]+"\"><![CDATA["+SAQUtil.getZeroToNullString(JSPUtil.round(Double.parseDouble(SAQUtil.getNvl(colValues.get("rhq_01"),"0"))/unit*unit_cost      , -1))    +"]]></TD>\n");

					if ( Integer.parseInt(SAQUtil.getNvl(colValues.get("item_code"),"0")) == 2 && rgnGrp.equals("0") ) { 
						sbufXML.append("<TD BGCOLOR=\""+bgColor[colorIdx]+"\" COLOR=\"0,0,255\"><![CDATA["+(isInclProt ? colValues.get("pol_cd")+"-"+colValues.get("pod_cd") : colValues.get("lane_grp"))+" Input]]></TD>\n");
					} else {
						sbufXML.append("<TD BGCOLOR=\""+bgColor[colorIdx]+"\"></TD>\n");
					} 

					//key 관련 hidden 항목
					sbufXML.append("<TD><![CDATA["+ grp    +"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+ colValues.get("lane_grp").substring(0,7) +"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+ colValues.get("sls_rgn_ofc_cd")+colValues.get("pol_cd")+colValues.get("pod_cd") +"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+ colValues.get("rlane_cd")    +"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+ colValues.get("sprt_grp_cd") +"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+ colValues.get("bsa_grp_cd")  +"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+ colValues.get("item_code")   +"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+ (colValues.get("item").equals("Volume") && rgnGrp.equals("0") ? "U" : "") +"]]></TD>\n");

					//계산 관련 hidden 항목
					sbufXML.append("<TD><![CDATA["+ Double.parseDouble(SAQUtil.getNvl(colValues.get("rhq_01"),"0"))/unit*unit_cost       +"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+ Double.parseDouble(SAQUtil.getNvl(colValues.get("rhq_01"),"0"))/unit*unit_cost       +"]]></TD>\n");
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
					sbufXML.append("<TD><![CDATA["+ rgnGrp +"]]></TD>\n");
					sbufXML.append("</TR>\n");
					
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
		sb.append("<ETC KEY=\"status\"><![CDATA[OK]]></ETC>\n");
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
			StringBuffer subTrdCds = new StringBuffer();
			StringBuffer rlaneCds = new StringBuffer();
			StringBuffer rgnOfcCds = new StringBuffer();
			StringBuffer aqCds = new StringBuffer();		
			StringBuffer rgnOfcCdTotal = new StringBuffer();		
			StringBuffer polCds = new StringBuffer();
			StringBuffer podCds = new StringBuffer();		
			StringBuffer itemCds = new StringBuffer();
			StringBuffer rlaneTotals = new StringBuffer();

			String rgnGrp = "";
			String preLane    = "";
			String preLaneGrp = "";
			String sub_trd_cd = null;
			String lane_grp = null;
			String sls_aq_cd = null;
			String sls_rgn_ofc_cd = null;

			int realCnt = 0;
			
			if( conditionVO.getChkCommand().equals("SEARCHLIST")||conditionVO.equals("MODIFY02")){
					
				List<SearchMonthlyQuotaAdjustmentSlsRhqListVO> searchMonthlyAdjustmentSlsListVOs = (List<SearchMonthlyQuotaAdjustmentSlsRhqListVO>) listVO.getList(0);
				
				realCnt = searchMonthlyAdjustmentSlsListVOs.size();
				
				for(int i=0;i<realCnt;i++){
					
					Map<String, String> colValues = searchMonthlyAdjustmentSlsListVOs.get(i).getColumnValues();
					
					rgnGrp = colValues.get("rgn_grp");
					// BGCOLOR 구분에 필요...LANE의 첫번째 SPRT_GRP 만 수정 가능....
					if (preLaneGrp.equals(colValues.get("lane_grp")) == false) {						
						if (preLane.equals(colValues.get("rlane_cd")+colValues.get("sprt_grp_cd"))) {
							log.debug("getETCData if true block");	//2010-05-10 빈 Block문장들(if, for, while, do)을 점검
						} else {    
							preLane = colValues.get("rlane_cd")+colValues.get("sprt_grp_cd");
							// Apply 용 lane_grp 
							if(rlaneTotals.indexOf(colValues.get("lane_grp").substring(0,7)) < 0)
								rlaneTotals.append(colValues.get("sub_trd_cd")).append("|").append(colValues.get("lane_grp").substring(0,colValues.get("lane_grp").length()-2)).append(";");
						}
						preLaneGrp = colValues.get("lane_grp");
					}

					sub_trd_cd = colValues.get("sub_trd_cd");
					lane_grp = colValues.get("conv_lane_grp");
					sls_aq_cd = colValues.get("sls_aq_cd");
					sls_rgn_ofc_cd = colValues.get("sls_rgn_ofc_cd");

					// filter 에 필요한 항목 리스트 작성
					if(subTrdCds.indexOf(colValues.get("sub_trd_cd")) < 0)
						subTrdCds.append(colValues.get("sub_trd_cd")).append(";");
					
					if(rlaneCds.indexOf(lane_grp) < 0){					
						rlaneCds.append(sub_trd_cd).append("|").append(lane_grp).append(";");
					}	
					
					if(rgnOfcCds.indexOf(sls_rgn_ofc_cd) < 0  )
						rgnOfcCds.append(sls_aq_cd).append("|").append(sls_rgn_ofc_cd).append(";");
					if(aqCds.indexOf(colValues.get("sls_aq_cd")) < 0  )
						aqCds.append(colValues.get("sls_aq_cd")).append(";");					
					if( "0".equals(colValues.get("rgn_grp")) 
							&& rgnOfcCdTotal.indexOf(colValues.get("sls_rgn_ofc_cd")) < 0  )
						rgnOfcCdTotal.append(colValues.get("sls_rgn_ofc_cd")).append(";");
					
					if(polCds.indexOf(colValues.get("pol_cd")) < 0 && rgnGrp.equals("0") )
						polCds.append(colValues.get("pol_cd")).append(";");
					if(podCds.indexOf(colValues.get("pod_cd")) < 0 && rgnGrp.equals("0") )
						podCds.append(colValues.get("pod_cd")).append(";");
					if(itemCds.indexOf(colValues.get("item")) < 0)
						itemCds.append(colValues.get("item")).append(";");	

				}
			}

			sb.append("<ETC KEY=\"SUB_TRADE\"><![CDATA["+ subTrdCds.toString()        +"]]></ETC>\n");
			sb.append("<ETC KEY=\"LANE\"><![CDATA["+ rlaneCds.toString()              +"]]></ETC>\n");
			sb.append("<ETC KEY=\"AQ\"><![CDATA["+ aqCds.toString()                   +"]]></ETC>\n");
			sb.append("<ETC KEY=\"RGN_OFC\"><![CDATA["+ rgnOfcCds.toString()          +"]]></ETC>\n");
			sb.append("<ETC KEY=\"RGN_OFC_TOTAL\"><![CDATA["+ rgnOfcCdTotal.toString()+"]]></ETC>\n");
			sb.append("<ETC KEY=\"POL_CD\"><![CDATA["+ polCds.toString()              +"]]></ETC>\n");
			sb.append("<ETC KEY=\"POD_CD\"><![CDATA["+ podCds.toString()              +"]]></ETC>\n");
			sb.append("<ETC KEY=\"ITEM\"><![CDATA["+ itemCds.toString()               +"]]></ETC>\n");
			sb.append("<ETC KEY=\"LANE_TOTAL\"><![CDATA["+ rlaneTotals.toString()     +"]]></ETC>\n");

		}
		
		//sb.append("<ETC KEY=\"status\"><![CDATA[OK]]></ETC>\n");
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
