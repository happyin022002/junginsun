/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmSaq0089ViewAdapter.java
*@FileTitle      : Monthly Quota Inquiry
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotaadjustmentinquiry.monthlyquotaadjustmentinquiry.event;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.saq.common.SAQUtil;
import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotaadjustmentinquiry.monthlyquotaadjustmentinquiry.vo.SearchMonthlyQuotaInquiryListVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.layer.event.EventResponse;
/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Lee SeungYol
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EsmSaq0089ViewAdapter extends ViewAdapter {

	public EsmSaq0089ViewAdapter() {
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
		
		// Tree 관련 색상 지정
		String[] bgColor = SAQUtil.getColors(9);

		String items[] = conditionVO.getItem().split(":"); // 선택된 item text array
		if (items[0].equals("ALL")) {
			items = new String[]{"ALL"};	
		}

		int level = 1;
		String unit = conditionVO.getUnit();
//		String isExpand="";
		float multiplier = 1F;
		//수치 데이터 저장(Total, 1~12월)
		float[] values = new float[4];
		//BSA 수치 데이터 저장(L/F 계산시 사용)
		//float[] bsaValues = new float[4];
		//Load 수치 데이터 저장(L/F 계산시 사용)
		//float[] loadValues = new float[4];

		String fontColor = "";
		
		if( conditionVO.getChkCommand().equals("SEARCHLIST01")) {
			
			List<SearchMonthlyQuotaInquiryListVO> searchMonthlyQuotaInquiryListVOs = (List<SearchMonthlyQuotaInquiryListVO>) listVO.getList(0);
			totCnt  = searchMonthlyQuotaInquiryListVOs.size();
				
			sbufXML.append("<DATA TOTAL='" + totCnt +"'>\n");
			if(totCnt != 0) {
				for(int i=0;i<totCnt;i++){
					
					Map<String, String> colValues = searchMonthlyQuotaInquiryListVOs.get(i).getColumnValues();

					level = Integer.parseInt(SAQUtil.getNvl(colValues.get("slevel"),"0"));
					
					String trd_cd = colValues.get("trd_cd");
					String dir_cd = colValues.get("dir_cd");
					String sub_trd_cd = colValues.get("sub_trd_cd");
					String item = colValues.get("item");
					
					trd_cd = trd_cd.equals("") ? " " : trd_cd;
					dir_cd = dir_cd.equals("") ? " " : dir_cd;
					sub_trd_cd = sub_trd_cd.equals("") ? " " : sub_trd_cd;
					

					//unit 적용
					if (unit.equals("F")) {
						if (item.equalsIgnoreCase("SUPPLY") || item.equalsIgnoreCase("VOLUME")) {
							multiplier = 0.5F;
						} else if (item.equalsIgnoreCase("G.RPB") || item.equalsIgnoreCase("CMPB")) {
							multiplier = 2F;
						} else {
							multiplier = 1F;
						}					
					} else if (unit.equals("T")) {
						multiplier = 1F;
					}
					
					//Total 및 월별 수치 데이터를 배열에 저장
					for (int j=0; j<values.length; j++) {
						String colSuffix = "";
						if (j < 10) {
							colSuffix = "0" + j;
						} else {
							colSuffix = String.valueOf(j);
						}
						
						values[j] = Float.parseFloat(SAQUtil.getNvl(colValues.get("val_" + colSuffix),"0")) * multiplier;
					}	
									
					String strVal_00 = values[0] == 0 ? "" : String.valueOf(values[0]);
					String strVal_01 = values[1] == 0 ? "" : String.valueOf(values[1]);
					String strVal_02 = values[2] == 0 ? "" : String.valueOf(values[2]);
					String strVal_03 = values[3] == 0 ? "" : String.valueOf(values[3]);
					
//					if( colValues.get("slevel").equals("1") ){
//						isExpand = "true";
//					}else{
//						isExpand = "false";
//					}		
//					String trd_image = "";	
//					String dir_image = "";	
//					String sub_trd_image = "";	
//					if( trd_cd.toUpperCase().equals("TOTAL") ){
//						trd_image = "IMAGE=\"0\"";				
//					}else if( dir_cd.toUpperCase().equals("TOTAL") ){
//						dir_image = "IMAGE=\"0\"";				
//					}else if( sub_trd_cd.toUpperCase().equals("TOTAL") ){
//						sub_trd_image = "IMAGE=\"0\"";								
//					}
					
//					sbufXML.append("<TR LEVEL=\""+colValues.get("slevel")+"\" expand=\""+isExpand+"\" >\n");
					sbufXML.append("<TR>");
					sbufXML.append("<TD bgColor=\""+bgColor[level-1]+"\"><![CDATA["+ trd_cd +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[level-1]+"\"><![CDATA["+ dir_cd +"]]></TD>\n");
					sbufXML.append("<TD bgColor=\""+bgColor[level-1]+"\"><![CDATA["+ sub_trd_cd +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[level-1]+"\"><![CDATA["+ colValues.get("item") +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[level-1]+"\"><![CDATA["+ strVal_00 +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[level-1]+"\"><![CDATA["+ strVal_01 +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[level-1]+"\"><![CDATA["+ strVal_02 +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[level-1]+"\"><![CDATA["+ strVal_03 +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[level-1]+"\"></TD>\n");
					sbufXML.append("</TR>");
					
				} // for end
			}
			sbufXML.append("</DATA>\n");
			
		}else if(conditionVO.getChkCommand().equals("SEARCHLIST02")) {
			
			List<SearchMonthlyQuotaInquiryListVO> searchMonthlyQuotaInquiryListVOs = (List<SearchMonthlyQuotaInquiryListVO>) listVO.getList(0);
			totCnt  = searchMonthlyQuotaInquiryListVOs.size();
				
			sbufXML.append("<DATA TOTAL='" + totCnt +"'>\n");
			if(totCnt != 0) {
				for(int i=0;i<totCnt;i++){
					
					Map<String, String> colValues = searchMonthlyQuotaInquiryListVOs.get(i).getColumnValues();

					level = Integer.parseInt(SAQUtil.getNvl(colValues.get("slevel"),"0"));
					
					fontColor = "COLOR=\"0,0,0\"";						
					//if(colValues.get("conv_dir_cd")!="") fontColor = "COLOR=\"255,0,0\"";
					if(!"".equals(colValues.get("conv_dir_cd"))) fontColor = "COLOR=\"255,0,0\""; //소스 품질 수정 요청건
					
					String dir_cd = colValues.get("dir_cd");
					String sub_trd_cd = colValues.get("sub_trd_cd");
					String rlane_cd = colValues.get("rlane_cd");
					String item = colValues.get("item");
					
					dir_cd = dir_cd.equals("") ? " " : dir_cd;
					sub_trd_cd = sub_trd_cd.equals("") ? " " : sub_trd_cd;
					rlane_cd = rlane_cd.equals("") ? " " : rlane_cd;			
				
					//unit 적용
					if (unit.equals("F")) {
						if (item.equalsIgnoreCase("SUPPLY") || item.equalsIgnoreCase("VOLUME")) {
							multiplier = 0.5F;
						} else if (item.equalsIgnoreCase("G.RPB") || item.equalsIgnoreCase("CMPB")) {
							multiplier = 2F;
						} else {
							multiplier = 1F;
						}					
					} else if (unit.equals("T")) {
						multiplier = 1F;
					}
					
					//Total 및 월별 수치 데이터를 배열에 저장
					for (int j=0; j<values.length; j++) {
						String colSuffix = "";
						if (j < 10) {
							colSuffix = "0" + j;
						} else {
							colSuffix = String.valueOf(j);
						}
						
						values[j] = Float.parseFloat(SAQUtil.getNvl(colValues.get("val_" + colSuffix),"0")) * multiplier;
					}	
									
					String strVal_00 = values[0] == 0 ? "" : String.valueOf(values[0]);
					String strVal_01 = values[1] == 0 ? "" : String.valueOf(values[1]);
					String strVal_02 = values[2] == 0 ? "" : String.valueOf(values[2]);
					String strVal_03 = values[3] == 0 ? "" : String.valueOf(values[3]);
					
//					if( colValues.get("slevel").equals("1") ){
//						isExpand = "true";
//					}else{
//						isExpand = "false";
//					}	
//					String dir_image = "";	
//					String sub_trd_image = "";	
//					String rlane_image = "";	
//
//			
//					if( dir_cd.toUpperCase().equals("TOTAL") ){
//						dir_image = "IMAGE=\"0\"";				
//					}else if( sub_trd_cd.toUpperCase().equals("TOTAL") ){
//						sub_trd_image = "IMAGE=\"0\"";		
//					}else if( rlane_cd.toUpperCase().equals("TOTAL") ){
//						rlane_image = "IMAGE=\"0\"";		
//					}
					
//					sbufXML.append("<TR LEVEL=\""+colValues.get("slevel")+"\" expand=\""+isExpand+"\" >\n");
					sbufXML.append("<TR>");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[level-1]+"\"><![CDATA["+ dir_cd +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[level-1]+"\"><![CDATA["+ sub_trd_cd +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[level-1]+"\" "+fontColor+"><![CDATA["+ rlane_cd +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[level-1]+"\"><![CDATA["+ item +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[level-1]+"\"><![CDATA["+ strVal_00 +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[level-1]+"\"><![CDATA["+ strVal_01 +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[level-1]+"\"><![CDATA["+ strVal_02 +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[level-1]+"\"><![CDATA["+ strVal_03 +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[level-1]+"\"></TD>\n");
					sbufXML.append("</TR>");
					
				}
			} // for end
			sbufXML.append("</DATA>\n");

		} else if( conditionVO.getChkCommand().equals("SEARCHLIST04")) {
			
			List<SearchMonthlyQuotaInquiryListVO> searchMonthlyQuotaInquiryListVOs = (List<SearchMonthlyQuotaInquiryListVO>) listVO.getList(0);
			totCnt  = searchMonthlyQuotaInquiryListVOs.size();
			
			String strVal = "";
			int colorIdx = 0;
			
			sbufXML.append("<DATA TOTAL='" + totCnt +"'>\n");
			if(totCnt != 0) {
				for(int i=0;i<totCnt;i++){
					
					Map<String, String> colValues = searchMonthlyQuotaInquiryListVOs.get(i).getColumnValues();
					
					level = Integer.parseInt(SAQUtil.getNvl(colValues.get("slevel"),"0"));
					
					fontColor = "COLOR=\"0,0,0\"";						
					//if(colValues.get("conv_dir_cd")!="") fontColor = "COLOR=\"255,0,0\"";
					
					if(!"".equals(colValues.get("conv_dir_cd"))) fontColor = "COLOR=\"255,0,0\""; //소스 품질 수정 요청건
					
					String sub_trd_cd = colValues.get("sub_trd_cd");
					String rlane_cd = colValues.get("rlane_cd");
					String vvd_grp_cd = colValues.get("vvd_grp_cd");
					//String vvd_grp_name = rlane_cd + "-" + vvd_grp_cd;
					//vvd_grp_name = vvd_grp_name.indexOf("TOTAL") != -1 ? "TOTAL" : vvd_grp_name;
					String item = colValues.get("item");
					String bse_wk = colValues.get("bse_wk");			
					String vvd_cd = colValues.get("vvd_cd");
					
					vvd_grp_cd = vvd_grp_cd.equals("") ? " " : vvd_grp_cd;
					bse_wk = bse_wk.equals("") ? " " : bse_wk;
					vvd_cd = vvd_cd.equals("") ? " " : vvd_cd;
					rlane_cd = rlane_cd.equals("") ? " " : rlane_cd;
					sub_trd_cd = sub_trd_cd.equals("") ? " " : sub_trd_cd;
					
					//unit 적용
					if (unit.equals("F")) {
						if (item.equalsIgnoreCase("SUPPLY") || item.equalsIgnoreCase("VOLUME")) {
							multiplier = 0.5F;
						} else if (item.equalsIgnoreCase("G.RPB") || item.equalsIgnoreCase("CMPB")) {
							multiplier = 2F;
						} else {
							multiplier = 1F;
						}					
					} else if (unit.equals("T")) {
						multiplier = 1F;
					}
					
					strVal = Float.parseFloat(SAQUtil.getNvl(colValues.get("val"),"0")) == 0 ? "" : String.valueOf(Float.parseFloat(SAQUtil.getNvl(colValues.get("val"),"0"))* multiplier);
					
//					if( colValues.get("slevel").equals("1") ){
//						isExpand = "true";
//					}else{
//						isExpand = "false";
//					}				
//
					if(level > 2){
						colorIdx = level-3;
					}else{
						colorIdx = level-1;
					}		
//					String sub_trd_image = "";	
//					String rlane_image = "";
//			
//					if( sub_trd_cd.toUpperCase().equals("TOTAL") ){
//						sub_trd_image = "IMAGE=\"0\"";				
//					}else if( rlane_cd.toUpperCase().equals("TOTAL") ){
//						rlane_image = "IMAGE=\"0\"";		
//					}
					
//					sbufXML.append("<TR LEVEL=\""+colValues.get("slevel")+"\" expand=\""+isExpand+"\" >\n");
					sbufXML.append("<TR>");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[colorIdx]+"\"><![CDATA["+ bse_wk +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[colorIdx]+"\" ><![CDATA["+ sub_trd_cd +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[colorIdx]+"\" "+fontColor+"><![CDATA["+ rlane_cd +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[colorIdx]+"\"><![CDATA["+ vvd_grp_cd +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[colorIdx]+"\"><![CDATA["+ vvd_cd +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[colorIdx]+"\"><![CDATA["+ item +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[colorIdx]+"\"><![CDATA["+ strVal +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR=\""+bgColor[colorIdx]+"\"></TD>\n");
					sbufXML.append("</TR>");
					
				}
			}
			sbufXML.append("</DATA>\n");
		}

		return sbufXML.toString();
	}
	
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
