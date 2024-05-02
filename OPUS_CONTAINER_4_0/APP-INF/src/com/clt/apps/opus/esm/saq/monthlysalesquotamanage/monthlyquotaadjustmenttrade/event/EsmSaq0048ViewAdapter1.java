/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSaq0048ViewAdapter1.java
*@FileTitle : Monthly Sales Quota Adjustment Trade Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : Choi.M.C
*@LastVersion : 1.0
* 2007-02-12 byyoo
* 1.0 Creation
* 2010.05.12 Kim Min Ah : 한달 판매목표 수립을 위한 수정
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
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.vo.SearchMonthlyQuotaAdjustmentTradeListVO;
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
public class EsmSaq0048ViewAdapter1 extends ViewAdapter {

	public EsmSaq0048ViewAdapter1() {
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
		List<SearchMonthlyQuotaAdjustmentTradeListVO> searchMonthlyGuidelineTargetGroupListVOs = (List<SearchMonthlyQuotaAdjustmentTradeListVO>) listVO.getList(0);
		
		int totCnt = 0;
		//2010.05.07 한달 판매목표 수립을 위한 수정 Start
		totCnt = searchMonthlyGuidelineTargetGroupListVOs.size();
		
		if(totCnt == 0){//There is no data 나오도록 함
			sbufXML.append("<DATA TOTAL='" + totCnt +"'>\n");
			sbufXML.append("</DATA>\n");
		}else{
		//if(searchMonthlyGuidelineTargetGroupListVOs.size() != 0) {

			//totCnt = searchMonthlyGuidelineTargetGroupListVOs.size();
		//2010.05.07 한달 판매목표 수립을 위한 수정 End

			//Sheet 관련 색상 지정
			String bgColor[] = SAQUtil.getColors(4);

			if( conditionVO.getChkCommand().equals("SEARCHLIST")||conditionVO.getChkCommand().equals("MODIFY02")){
	
				sbufXML.append("<DATA TOTAL='" + totCnt +"'>\n");
				
				for(int i=0;i<totCnt;i++){
					
					Map<String, String> colValues = searchMonthlyGuidelineTargetGroupListVOs.get(i).getColumnValues();
					
					int uc_amt_unit = (conditionVO.getUnit().compareTo("F")==0 ? 2 : 1);
					int unit = 1;
					int unit_cost = 1;
					int grp = 0; // 1 : 첫번째 Total, 0 : Data, 2 : 다른그룹 Total
					boolean isCheckBox = false;
					String remark = "";
	
					String stsCd = JSPUtil.getNull(colValues.get("saqStsCd"));
					int work_step = 1;
					if (stsCd.equals("DR") || stsCd.equals("FC") || stsCd.equals("FN")) {			
						work_step = 3;
					}
						
					// BGCOLOR 구분에 필요
					grp = 0; // Data
					if (colValues.get("rhq_cd").equals("TOTAL")) {
						
						if (Integer.parseInt(colValues.get("grp_seq")) == 1 ) {
							grp = 1; // 첫번째 Total 수정가능.
						} else { 
							grp = 2; // 다른그룹 Total 수정불가.
						}
					}
	
					// check box 항목 여부 (첫번째 그룹의 데이타만 체크 가능 )
					if(Integer.parseInt(colValues.get("grp_seq")) == 1 && grp == 0 &&
							(colValues.get("item").equals("Volume") 
									|| colValues.get("item").equals("G.REV")) ){
						isCheckBox = true;
					} else {
						isCheckBox = false;
					}
					
					// unit 적용 
					if (colValues.get("item").equals("Supply")
							|| colValues.get("item").equals("Volume")) {
						unit = (conditionVO.getUnit().compareTo("F")==0 ? 2 : 1);
						unit_cost = 1;
					} else if (colValues.get("item").indexOf("G.RPB") > -1
							|| colValues.get("item").indexOf("CMPB") > -1
							|| colValues.get("item").indexOf("OPB") > -1) {
						unit = 1;
						unit_cost = (conditionVO.getUnit().compareTo("F")==0 ? 2 : 1);
					} else {
						unit = 1;
						unit_cost = 1;
					}
					if ( grp == 0 ){
						remark = colValues.get("rhq_cd")+" Input";
					}else{
						remark = " ";
					}
					
					sbufXML.append("<TR>");
					
					sbufXML.append("<TD BGCOLOR = \"" + bgColor[1]   + "\"><![CDATA["+getNull(colValues.get("sub_trd_cd"))+"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR = \"" + bgColor[grp] + "\" COLOR=\"0,0,255\"><![CDATA["+getNull(colValues.get("conv_lane_grp"))               +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR = \"" + bgColor[grp] + "\"><![CDATA["+getNull(colValues.get("rhq_cd"))                      +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR = \"" + bgColor[grp] + "\"><![CDATA["+getNull(colValues.get("item"))                        +"]]></TD>\n");
	
					// display 관련 수치  항목은 소수점 1자리 반올림으로 보여준다. (0 은 "" 으로)
//					sbufXML.append("<TD BGCOLOR = \"" + bgColor[grp] + "\"><![CDATA["+SAQUtil.getZeroToNullString(JSPUtil.round(Double.parseDouble(SAQUtil.getNvl(colValues.get("recent_yearly"),"0"))/unit*unit_cost , -1))  +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR = \"" + bgColor[grp] + "\"><![CDATA["+SAQUtil.getZeroToNullString(JSPUtil.round(Double.parseDouble(SAQUtil.getNvl(colValues.get("recent_monthly"),"0"))/unit*unit_cost, -1))  +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR = \"" + bgColor[grp] + "\"><![CDATA["+SAQUtil.getZeroToNullString(JSPUtil.round(Double.parseDouble(SAQUtil.getNvl(colValues.get("fcast_01"),"0"))/unit*unit_cost	  , -1))  +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR = \"" + bgColor[grp] + "\"><![CDATA["+SAQUtil.getZeroToNullString(JSPUtil.round(Double.parseDouble(SAQUtil.getNvl(colValues.get("model_01"),"0"))/unit*unit_cost      , -1))  +"]]></TD>\n");
//					sbufXML.append("<TD BGCOLOR = \"" + bgColor[grp] + "\"><![CDATA["+SAQUtil.getZeroToNullString(JSPUtil.round(Double.parseDouble(SAQUtil.getNvl(colValues.get("yearly_01"),"0"))/unit*unit_cost     , -1))  +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR = \"" + bgColor[grp] + "\" "+ (isCheckBox?"EDIT=\"TRUE\"":"" )        +"></TD>\n");
					sbufXML.append("<TD BGCOLOR = \"" + bgColor[grp] + "\"><![CDATA["+SAQUtil.getZeroToNullString(JSPUtil.round(Double.parseDouble(SAQUtil.getNvl(colValues.get("trade_01"),"0"))/unit*unit_cost      , -1))  +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR = \"" + bgColor[grp] + "\" "+ (isCheckBox?"EDIT=\"TRUE\"":"" )        +"></TD>\n");
					sbufXML.append("<TD BGCOLOR = \"" + bgColor[grp] + "\"><![CDATA["+SAQUtil.getZeroToNullString(JSPUtil.round(Double.parseDouble(SAQUtil.getNvl(colValues.get("rhq_01"),"0"))/unit*unit_cost        , -1))  +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR = \"" + bgColor[grp] + "\"><![CDATA["+SAQUtil.getZeroToNullString(JSPUtil.round(Double.parseDouble(SAQUtil.getNvl(colValues.get("final_01"),"0"))/unit*unit_cost      , -1))  +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR = \"" + bgColor[grp] + "\"><![CDATA["+SAQUtil.getZeroToNullString(JSPUtil.round(Double.parseDouble(SAQUtil.getNvl(colValues.get("adjusted_01"),"0"))/unit*unit_cost   , -1))  +"]]></TD>\n");
						
					if ( Integer.parseInt(colValues.get("item_code")) == 2 ) {
						sbufXML.append("<TD BGCOLOR = \"" + bgColor[grp] + "\" COLOR=\"0,0,255\"><![CDATA["+ remark  +"]]></TD>\n");
						
				 	} else { 
				 		sbufXML.append("<TD BGCOLOR = \"" + bgColor[grp] +"\"></TD>\n");			 		
				 	}
	
					//key 관련 hidden 항목
					
					sbufXML.append("<TD><![CDATA["+ colValues.get("rlane_cd")    +"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+ colValues.get("sprt_grp_cd") +"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+ colValues.get("bsa_grp_cd")  +"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+ colValues.get("item_code")   +"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+ ((colValues.get("item").equals("Volume") && grp == 0)?"U":"") +"]]></TD>\n");
	
					//계산 관련 hidden 항목
					sbufXML.append("<TD><![CDATA["+ Integer.parseInt(colValues.get("grp_seq"))   +"]]></TD>\n");
				
					if (work_step == 1) {
						sbufXML.append("<TD><![CDATA["+ Double.parseDouble(SAQUtil.getNvl(colValues.get("trade_01"),"0"))/unit*unit_cost  +"]]></TD>\n");
						sbufXML.append("<TD><![CDATA["+ Double.parseDouble(SAQUtil.getNvl(colValues.get("trade_01"),"0"))/unit*unit_cost  +"]]></TD>\n");
	
					} else {
						sbufXML.append("<TD><![CDATA["+ Double.parseDouble(SAQUtil.getNvl(("final_01"),"0"))/unit*unit_cost  +"]]></TD>\n");
						sbufXML.append("<TD><![CDATA["+ Double.parseDouble(SAQUtil.getNvl(("final_01"),"0"))/unit*unit_cost  +"]]></TD>\n");
	
					}
					
					sbufXML.append("<TD><![CDATA["+ Double.parseDouble(SAQUtil.getNvl(colValues.get("trade_01"),"0"))/unit*unit_cost     +"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+ Double.parseDouble(SAQUtil.getNvl(colValues.get("rhq_01"),"0"))/unit*unit_cost       +"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+ Double.parseDouble(SAQUtil.getNvl(colValues.get("tot_lod"),"0"))/unit                +"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+ Double.parseDouble(SAQUtil.getNvl(colValues.get("tot_rpb"),"0"))*uc_amt_unit         +"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+ Double.parseDouble(SAQUtil.getNvl(colValues.get("cm_uc_amt"),"0"))*uc_amt_unit       +"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+ Double.parseDouble(SAQUtil.getNvl(colValues.get("opfit_uc_amt"),"0"))*uc_amt_unit    +"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+ Double.parseDouble(SAQUtil.getNvl(colValues.get("ra_cm_uc_amt"),"0"))*uc_amt_unit    +"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+ Double.parseDouble(SAQUtil.getNvl(colValues.get("ra_opfit_uc_amt"),"0"))*uc_amt_unit +"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+ Double.parseDouble(SAQUtil.getNvl(colValues.get("tot_bsa"),"0"))/unit                +"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+ Double.parseDouble(SAQUtil.getNvl(colValues.get("low_qty"),"0"))/unit                +"]]></TD>\n");
					sbufXML.append("<TD><![CDATA["+ colValues.get("lane_grp").substring(0,7)     +"]]></TD>\n");
	
					sbufXML.append("<TD><![CDATA[R]]></TD>\n");
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
			
			String sub_trd_cd = "";
			String lane_grp   = "";
			
			// filter 에 필요한 항목을 담을 StringBuffer 선언
			StringBuffer subTrdCds   = new StringBuffer();
			StringBuffer rlaneCds    = new StringBuffer();
			StringBuffer rhqCds      = new StringBuffer();
			StringBuffer rhqTotal    = new StringBuffer();
			StringBuffer itemCds     = new StringBuffer();
			StringBuffer rlaneTotals = new StringBuffer();
			
			int realCnt = 0;
			
			if( conditionVO.getChkCommand().equals("SEARCHLIST")||conditionVO.getChkCommand().equals("MODIFY02")){
	
				List<SearchMonthlyQuotaAdjustmentTradeListVO> searchMonthlyGuidelineTargetGroupListVOs = (List<SearchMonthlyQuotaAdjustmentTradeListVO>) listVO.getList(0);
				
				realCnt = searchMonthlyGuidelineTargetGroupListVOs.size();
				
				for(int i=0;i<realCnt;i++){
					
					Map<String, String> colValues = searchMonthlyGuidelineTargetGroupListVOs.get(i).getColumnValues();
					
					sub_trd_cd = colValues.get("sub_trd_cd");
					lane_grp   = colValues.get("conv_lane_grp");
					
					// filter 에 필요한 항목 리스트 작성
					if(subTrdCds.indexOf(sub_trd_cd) < 0){
						subTrdCds.append(sub_trd_cd).append(";");
					}
					if(rlaneCds.indexOf(lane_grp) < 0){
						rlaneCds.append(sub_trd_cd).append("|").append(lane_grp).append(";");
					}
					if(rhqCds.indexOf(colValues.get("rhq_cd")) < 0) {
						rhqCds.append(colValues.get("rhq_cd")).append(";");
					}
					if(rhqTotal.indexOf(colValues.get("rhq_cd")) < 0 && Integer.parseInt(colValues.get("grp_seq")) == 1 && !colValues.get("rhq_cd").equals("TOTAL")) {
						rhqTotal.append(colValues.get("rhq_cd")).append(";");
					}
					if(itemCds.indexOf(colValues.get("item")) < 0) {
						itemCds.append(colValues.get("item")).append(";");
					}
					// Apply 용 lane_grp (lane_cd-sprt_grp_cd)
					if(Integer.parseInt(colValues.get("grp_seq")) == 1 && rlaneTotals.indexOf(colValues.get("lane_grp").substring(0,7)) < 0) {
						rlaneTotals.append(sub_trd_cd).append("|").append(colValues.get("lane_grp").substring(0,7)).append(";");
					}
					
				}
				
				sb.append("<ETC KEY=\"SUB_TRADE\"><![CDATA["+ subTrdCds.toString()   +"]]></ETC>\n");
				sb.append("<ETC KEY=\"LANE\"><![CDATA["+ rlaneCds.toString()         +"]]></ETC>\n");
				sb.append("<ETC KEY=\"RHQ\"><![CDATA["+ rhqCds.toString()            +"]]></ETC>\n");
				sb.append("<ETC KEY=\"ITEM\"><![CDATA["+ itemCds.toString()          +"]]></ETC>\n");
				sb.append("<ETC KEY=\"RHQ_TOTAL\"><![CDATA["+ rhqTotal.toString()    +"]]></ETC>\n");
				sb.append("<ETC KEY=\"LANE_TOTAL\"><![CDATA["+ rlaneTotals.toString()+"]]></ETC>\n");
				
			}
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
