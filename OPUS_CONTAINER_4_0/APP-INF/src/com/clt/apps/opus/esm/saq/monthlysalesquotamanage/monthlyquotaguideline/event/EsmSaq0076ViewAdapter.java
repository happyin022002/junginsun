/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSaq0076ViewAdapter.java
*@FileTitle : Master Version Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 김민아
*@LastVersion : 1.0
* 2007-02-02 byyoo
* 1.0 최초 생성
* 2011.02.14 김종준 [T-선사] YEARLY QTA 부분 삭제
=========================================================*/

package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaguideline.event;

import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.saq.common.SAQUtil;
import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaguideline.vo.SearchMonthlyGuidelineTargetGroupListVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.controller.ViewAdapter;

/**
 * @author Kim Min Ah
 * @see QuotaConditionVO, SearchMonthlyGuidelineTargetGroupListVO 참조
 * @since J2EE 1.6
 */

public class EsmSaq0076ViewAdapter extends ViewAdapter {

	public EsmSaq0076ViewAdapter() {
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
		StringBuilder sbufXML = new StringBuilder();
		QuotaConditionVO conditionVO = null;
		List<SearchMonthlyGuidelineTargetGroupListVO> voList = null;
		int realCnt = 0;
		
		ReturnVO returnVO = (ReturnVO) vos.get(0);
		if(returnVO != null){
			voList = (List<SearchMonthlyGuidelineTargetGroupListVO>) returnVO.getList(0);
			conditionVO = returnVO.getConditionVO();
		}

		//Sheet 관련 색상 지정
		String bgColor[] = SAQUtil.getColors(4);

		int unit = 1;
		int unit_cost = 1;
		String[] strMonIndex = {"1", "2", "3"};
		//String cellFormat = "";
		//String cellFormat1 = "";
		String cellColor = "";
				
		if(voList != null && voList.size() > 0) realCnt = voList.size();
		
		sbufXML.append("<DATA TOTAL='" + realCnt +"'>\n");

		for(int i=0;i<realCnt;i++){
			
			Map<String, String> colValues = voList.get(i).getColumnValues();
			
			//1. Unit 적용여부
			if("Supply".equals(colValues.get("item_text")) || "Volume".equals(colValues.get("item_text"))){
				unit = (conditionVO.getUnit().compareTo("F")==0 ? 2: 1);
				unit_cost = 1;
			} else if("CMPB".equals(colValues.get("item_text")) ){
				unit = 1;
				unit_cost = (conditionVO.getUnit().compareTo("F")==0 ? 2: 1);
			} else if("G.RPB".equals(colValues.get("item_text")) 
					|| colValues.get("item").indexOf("CMB")>-1 || colValues.get("item").indexOf("OPB")>-1){
				unit = 1;
				unit_cost = (conditionVO.getUnit().compareTo("F")==0 ? 2: 1);
			} else{
				unit = 1;
				unit_cost = 1;
			}
			
			//2. L/F DATA-FORMAT, POINT-COUNT 설정
//			if("L/F".equals(colValues.get("item"))){
//				cellFormat = "(int)(";
//				cellFormat1 = ")";
////				cellFormat = "DATA-FORMAT=\"dfFloat\" POINT-COUNT=\"1\" ";
//
//			} else {
//				cellFormat = "";
//			}
			
			//3. Color 지정
			if("0".equals(colValues.get("dir_seq"))){
				if("0".equals(colValues.get("sub_seq"))){
					cellColor = bgColor[0];
				}else{
					cellColor = bgColor[1];
				}
			}else{
				if(colValues.get("dir_cd").equals(conditionVO.getDirCd()) 
						&& colValues.get("trd_cd").equals(conditionVO.getTrade())){
					cellColor = SAQUtil.getHighlightColor(0);
				}else{
					cellColor = bgColor[2];
				}
			}

			sbufXML.append("<TR>");
			
//			sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\"><![CDATA["+getNull(colValues.get("trd_cd"))+"]]></TD>\n");
//			sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\"><![CDATA["+getNull(colValues.get("dir_cd"))+"]]></TD>\n");
//			sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\"><![CDATA["+getNull(colValues.get("item"))+"]]></TD>\n");
//			sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" " + cellFormat + " ><![CDATA["+cellFormat+Float.parseFloat(getNull(colValues.get("recent_mon"))=="" ? "0" : getNull(colValues.get("recent_mon" )))/unit*unit_cost+cellFormat1+"]]></TD>\n");
//
////			log.debug("==========================Float.parseFloat(getNull(colValues.get(recent_mon))== ? 0 : getNull(colValues.get(recent_mon )))/unit*unit_cost:"+Float.parseFloat(getNull(colValues.get("recent_mon"))=="" ? "0" : getNull(colValues.get("recent_mon" )))/unit*unit_cost);
////			log.debug("==========================(int)(Float.parseFloat(getNull(colValues.get(recent_mon))== ? 0 : getNull(colValues.get(recent_mon )))/unit*unit_cost:"+(int)(Float.parseFloat(getNull(colValues.get("recent_mon"))=="" ? "0" : getNull(colValues.get("recent_mon" )))/unit*unit_cost));
////			log.debug("==========================cellFormat(Float.parseFloat(getNull(colValues.get(recent_mon))== ? 0 : getNull(colValues.get(recent_mon )))/unit*unit_cost:"+cellFormat+Float.parseFloat(getNull(colValues.get("recent_mon"))=="" ? "0" : getNull(colValues.get("recent_mon" )))/unit*unit_cost+cellFormat1);
//
//			sbufXML.append("<TD></TD>\n");
//			sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" " + cellFormat + "><![CDATA["+Float.parseFloat(getNull(colValues.get("recent_tgt_mon"))=="" ? "0" : getNull(colValues.get("recent_tgt_mon" )))/unit*unit_cost+"]]></TD>\n");
//						
//			sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" " + cellFormat + "><![CDATA["+Float.parseFloat(getNull(colValues.get("fcast_tot"     ))=="" ? "0" : getNull(colValues.get("fcast_tot" 		)))/unit*unit_cost+"]]></TD>\n");
//			sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" " + cellFormat + "><![CDATA["+Float.parseFloat(getNull(colValues.get("mdl_rst_tot"   ))=="" ? "0" : getNull(colValues.get("mdl_rst_tot" 	)))/unit*unit_cost+"]]></TD>\n");
//			sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" " + cellFormat + "><![CDATA["+Float.parseFloat(getNull(colValues.get("trade_tot"     ))=="" ? "0" : getNull(colValues.get("trade_tot" 		)))/unit*unit_cost+"]]></TD>\n");
//			sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" " + cellFormat + "><![CDATA["+Float.parseFloat(getNull(colValues.get("rhq_tot"       ))=="" ? "0" : getNull(colValues.get("rhq_tot" 		)))/unit*unit_cost+"]]></TD>\n");
//			sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" " + cellFormat + "><![CDATA["+Float.parseFloat(getNull(colValues.get("final_tot"     ))=="" ? "0" : getNull(colValues.get("final_tot" 		)))/unit*unit_cost+"]]></TD>\n");
//			sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" " + cellFormat + "><![CDATA["+Float.parseFloat(getNull(colValues.get("adjusted_tot"  ))=="" ? "0" : getNull(colValues.get("adjusted_tot" 	)))/unit*unit_cost+"]]></TD>\n");
//			sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" " + cellFormat + "><![CDATA["+Float.parseFloat(getNull(colValues.get("initial_tot"   ))=="" ? "0" : getNull(colValues.get("initial_tot" 	)))/unit*unit_cost+"]]></TD>\n");
//			sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" " + cellFormat + "><![CDATA["+Float.parseFloat(getNull(colValues.get("final_tgt_tot" ))=="" ? "0" : getNull(colValues.get("final_tgt_tot" 	)))/unit*unit_cost+"]]></TD>\n");
//		
//		//월별 항목
//		for(int j = 0 ; j < 3 ; j++){
//			sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" " + cellFormat + "><![CDATA["+Float.parseFloat(getNull(colValues.get("fcast_" 	  + strMonIndex[j]))=="" ? "0" : getNull(colValues.get("fcast_" 	 + strMonIndex[j])))/unit*unit_cost+"]]></TD>\n");
//			sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" " + cellFormat + "><![CDATA["+Float.parseFloat(getNull(colValues.get("mdl_rst_"   + strMonIndex[j]))=="" ? "0" : getNull(colValues.get("mdl_rst_" 	 + strMonIndex[j])))/unit*unit_cost+"]]></TD>\n");
//			sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" " + cellFormat + "><![CDATA["+Float.parseFloat(getNull(colValues.get("trade_" 	  + strMonIndex[j]))=="" ? "0" : getNull(colValues.get("trade_" 	 + strMonIndex[j])))/unit*unit_cost+"]]></TD>\n");
//			sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" " + cellFormat + "><![CDATA["+Float.parseFloat(getNull(colValues.get("rhq_" 	  + strMonIndex[j]))=="" ? "0" : getNull(colValues.get("rhq_" 	   	 + strMonIndex[j])))/unit*unit_cost+"]]></TD>\n");
//			sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" " + cellFormat + "><![CDATA["+Float.parseFloat(getNull(colValues.get("final_" 	  + strMonIndex[j]))=="" ? "0" : getNull(colValues.get("final_" 	 + strMonIndex[j])))/unit*unit_cost+"]]></TD>\n");
//			sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" " + cellFormat + "><![CDATA["+Float.parseFloat(getNull(colValues.get("adjusted_"  + strMonIndex[j]))=="" ? "0" : getNull(colValues.get("adjusted_"   + strMonIndex[j])))/unit*unit_cost+"]]></TD>\n");
//			sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" " + cellFormat + "><![CDATA["+Float.parseFloat(getNull(colValues.get("initial_"   + strMonIndex[j]))=="" ? "0" : getNull(colValues.get("initial_" 	 + strMonIndex[j])))/unit*unit_cost+"]]></TD>\n");
//			sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" " + cellFormat + "><![CDATA["+Float.parseFloat(getNull(colValues.get("final_tgt_" + strMonIndex[j]))=="" ? "0" : getNull(colValues.get("final_tgt_"  + strMonIndex[j])))/unit*unit_cost+"]]></TD>\n");
//		}
			if("L/F".equals(colValues.get("item"))){		
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\"><![CDATA["+getNull(colValues.get("trd_cd"))+"]]></TD>\n");
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\"><![CDATA["+getNull(colValues.get("dir_cd"))+"]]></TD>\n");
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\"><![CDATA["+getNull(colValues.get("item"))+"]]></TD>\n");
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" ><![CDATA["+Float.parseFloat(getNull(colValues.get("recent_mon"))=="" ? "0" : getNull(colValues.get("recent_mon" )))/unit*unit_cost+"]]></TD>\n");
	
				sbufXML.append("<TD></TD>\n");
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" ><![CDATA["+Float.parseFloat(getNull(colValues.get("recent_tgt_mon"))=="" ? "0" : getNull(colValues.get("recent_tgt_mon" )))/unit*unit_cost+"]]></TD>\n");
							
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" ><![CDATA["+Float.parseFloat(getNull(colValues.get("fcast_tot"     ))=="" ? "0" : getNull(colValues.get("fcast_tot" 		)))/unit*unit_cost+"]]></TD>\n");
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" ><![CDATA["+Float.parseFloat(getNull(colValues.get("mdl_rst_tot"   ))=="" ? "0" : getNull(colValues.get("mdl_rst_tot" 	)))/unit*unit_cost+"]]></TD>\n");
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" ><![CDATA["+Float.parseFloat(getNull(colValues.get("trade_tot"     ))=="" ? "0" : getNull(colValues.get("trade_tot" 		)))/unit*unit_cost+"]]></TD>\n");
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" ><![CDATA["+Float.parseFloat(getNull(colValues.get("rhq_tot"       ))=="" ? "0" : getNull(colValues.get("rhq_tot" 		)))/unit*unit_cost+"]]></TD>\n");
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" ><![CDATA["+Float.parseFloat(getNull(colValues.get("final_tot"     ))=="" ? "0" : getNull(colValues.get("final_tot" 		)))/unit*unit_cost+"]]></TD>\n");
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" ><![CDATA["+Float.parseFloat(getNull(colValues.get("adjusted_tot"  ))=="" ? "0" : getNull(colValues.get("adjusted_tot" 	)))/unit*unit_cost+"]]></TD>\n");
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" ><![CDATA["+Float.parseFloat(getNull(colValues.get("initial_tot"   ))=="" ? "0" : getNull(colValues.get("initial_tot" 	)))/unit*unit_cost+"]]></TD>\n");
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" ><![CDATA["+Float.parseFloat(getNull(colValues.get("final_tgt_tot" ))=="" ? "0" : getNull(colValues.get("final_tgt_tot" 	)))/unit*unit_cost+"]]></TD>\n");
			
				
			//월별 항목
			for(int j = 0 ; j < 3 ; j++){
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" ><![CDATA["+Float.parseFloat(getNull(colValues.get("fcast_" 	  + strMonIndex[j]))=="" ? "0" : getNull(colValues.get("fcast_" 	 + strMonIndex[j])))/unit*unit_cost+"]]></TD>\n");
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" ><![CDATA["+Float.parseFloat(getNull(colValues.get("mdl_rst_"   + strMonIndex[j]))=="" ? "0" : getNull(colValues.get("mdl_rst_" 	 + strMonIndex[j])))/unit*unit_cost+"]]></TD>\n");
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" ><![CDATA["+Float.parseFloat(getNull(colValues.get("trade_" 	  + strMonIndex[j]))=="" ? "0" : getNull(colValues.get("trade_" 	 + strMonIndex[j])))/unit*unit_cost+"]]></TD>\n");
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" ><![CDATA["+Float.parseFloat(getNull(colValues.get("rhq_" 	  + strMonIndex[j]))=="" ? "0" : getNull(colValues.get("rhq_" 	   	 + strMonIndex[j])))/unit*unit_cost+"]]></TD>\n");
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" ><![CDATA["+Float.parseFloat(getNull(colValues.get("final_" 	  + strMonIndex[j]))=="" ? "0" : getNull(colValues.get("final_" 	 + strMonIndex[j])))/unit*unit_cost+"]]></TD>\n");
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" ><![CDATA["+Float.parseFloat(getNull(colValues.get("adjusted_"  + strMonIndex[j]))=="" ? "0" : getNull(colValues.get("adjusted_"   + strMonIndex[j])))/unit*unit_cost+"]]></TD>\n");
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" ><![CDATA["+Float.parseFloat(getNull(colValues.get("initial_"   + strMonIndex[j]))=="" ? "0" : getNull(colValues.get("initial_" 	 + strMonIndex[j])))/unit*unit_cost+"]]></TD>\n");
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" ><![CDATA["+Float.parseFloat(getNull(colValues.get("final_tgt_" + strMonIndex[j]))=="" ? "0" : getNull(colValues.get("final_tgt_"  + strMonIndex[j])))/unit*unit_cost+"]]></TD>\n");
				}	
			} else {
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\"><![CDATA["+getNull(colValues.get("trd_cd"))+"]]></TD>\n");
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\"><![CDATA["+getNull(colValues.get("dir_cd"))+"]]></TD>\n");
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\"><![CDATA["+getNull(colValues.get("item"))+"]]></TD>\n");
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" ><![CDATA["+(int)(Float.parseFloat(getNull(colValues.get("recent_mon"))=="" ? "0" : getNull(colValues.get("recent_mon" )))/unit*unit_cost)+"]]></TD>\n");
	
				sbufXML.append("<TD></TD>\n");
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" ><![CDATA["+(int)(Float.parseFloat(getNull(colValues.get("recent_tgt_mon"))=="" ? "0" : getNull(colValues.get("recent_tgt_mon" )))/unit*unit_cost)+"]]></TD>\n");
							
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" ><![CDATA["+(int)(Float.parseFloat(getNull(colValues.get("fcast_tot"     ))=="" ? "0" : getNull(colValues.get("fcast_tot" 		)))/unit*unit_cost)+"]]></TD>\n");
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" ><![CDATA["+(int)(Float.parseFloat(getNull(colValues.get("mdl_rst_tot"   ))=="" ? "0" : getNull(colValues.get("mdl_rst_tot" 	)))/unit*unit_cost)+"]]></TD>\n");
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" ><![CDATA["+(int)(Float.parseFloat(getNull(colValues.get("trade_tot"     ))=="" ? "0" : getNull(colValues.get("trade_tot" 		)))/unit*unit_cost)+"]]></TD>\n");
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" ><![CDATA["+(int)(Float.parseFloat(getNull(colValues.get("rhq_tot"       ))=="" ? "0" : getNull(colValues.get("rhq_tot" 		)))/unit*unit_cost)+"]]></TD>\n");
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" ><![CDATA["+(int)(Float.parseFloat(getNull(colValues.get("final_tot"     ))=="" ? "0" : getNull(colValues.get("final_tot" 		)))/unit*unit_cost)+"]]></TD>\n");
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" ><![CDATA["+(int)(Float.parseFloat(getNull(colValues.get("adjusted_tot"  ))=="" ? "0" : getNull(colValues.get("adjusted_tot" 	)))/unit*unit_cost)+"]]></TD>\n");
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" ><![CDATA["+(int)(Float.parseFloat(getNull(colValues.get("initial_tot"   ))=="" ? "0" : getNull(colValues.get("initial_tot" 	)))/unit*unit_cost)+"]]></TD>\n");
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" ><![CDATA["+(int)(Float.parseFloat(getNull(colValues.get("final_tgt_tot" ))=="" ? "0" : getNull(colValues.get("final_tgt_tot" 	)))/unit*unit_cost)+"]]></TD>\n");
			
			//월별 항목
			for(int j = 0 ; j < 3 ; j++){
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" ><![CDATA["+(int)(Float.parseFloat(getNull(colValues.get("fcast_" 	  + strMonIndex[j]))=="" ? "0" : getNull(colValues.get("fcast_" 	 + strMonIndex[j])))/unit*unit_cost)+"]]></TD>\n");
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" ><![CDATA["+(int)(Float.parseFloat(getNull(colValues.get("mdl_rst_"   + strMonIndex[j]))=="" ? "0" : getNull(colValues.get("mdl_rst_" 	 + strMonIndex[j])))/unit*unit_cost)+"]]></TD>\n");
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" ><![CDATA["+(int)(Float.parseFloat(getNull(colValues.get("trade_" 	  + strMonIndex[j]))=="" ? "0" : getNull(colValues.get("trade_" 	 + strMonIndex[j])))/unit*unit_cost)+"]]></TD>\n");
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" ><![CDATA["+(int)(Float.parseFloat(getNull(colValues.get("rhq_" 	  + strMonIndex[j]))=="" ? "0" : getNull(colValues.get("rhq_" 	   	 + strMonIndex[j])))/unit*unit_cost)+"]]></TD>\n");
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" ><![CDATA["+(int)(Float.parseFloat(getNull(colValues.get("final_" 	  + strMonIndex[j]))=="" ? "0" : getNull(colValues.get("final_" 	 + strMonIndex[j])))/unit*unit_cost)+"]]></TD>\n");
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" ><![CDATA["+(int)(Float.parseFloat(getNull(colValues.get("adjusted_"  + strMonIndex[j]))=="" ? "0" : getNull(colValues.get("adjusted_"   + strMonIndex[j])))/unit*unit_cost)+"]]></TD>\n");
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" ><![CDATA["+(int)(Float.parseFloat(getNull(colValues.get("initial_"   + strMonIndex[j]))=="" ? "0" : getNull(colValues.get("initial_" 	 + strMonIndex[j])))/unit*unit_cost)+"]]></TD>\n");
				sbufXML.append("<TD BGCOLOR = \"" + cellColor + "\" ><![CDATA["+(int)(Float.parseFloat(getNull(colValues.get("final_tgt_" + strMonIndex[j]))=="" ? "0" : getNull(colValues.get("final_tgt_"  + strMonIndex[j])))/unit*unit_cost)+"]]></TD>\n");
				}
			}
			
			
		
		
			sbufXML.append("</TR>\n");
		}
		sbufXML.append("</DATA>\n");
		
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
	@Override
	protected String makeDataTag(DBRowSet arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}