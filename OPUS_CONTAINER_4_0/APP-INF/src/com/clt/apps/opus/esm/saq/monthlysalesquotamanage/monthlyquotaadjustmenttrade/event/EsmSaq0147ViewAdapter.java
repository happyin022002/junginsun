/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSaq0147ViewAdapter.java
*@FileTitle : ESM_SAQ_0147
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : Choi.M.C
*@LastVersion : 1.0
* 2007-06-29 변영주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.event;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.saq.common.SAQUtil;
import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.vo.SearchMonthlyQuotaAdjustmentTradeModifyListVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
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
public class EsmSaq0147ViewAdapter extends ViewAdapter {

	public EsmSaq0147ViewAdapter() {
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
		
		//Sheet 관련 색상 지정
		String bgColor[] = SAQUtil.getColors(4);
		int totCnt = 0;
		
		if( conditionVO.getChkCommand().equals("SEARCHLIST")){
			
			List<SearchMonthlyQuotaAdjustmentTradeModifyListVO> searchMonthlyQuotaAdjustmentTradeModifyListVOs=  (List<SearchMonthlyQuotaAdjustmentTradeModifyListVO>) listVO.getList(0);
			totCnt = searchMonthlyQuotaAdjustmentTradeModifyListVOs.size();
			
			if(searchMonthlyQuotaAdjustmentTradeModifyListVOs.size() != 0) {
	
				sbufXML.append("<DATA TOTAL='" + totCnt +"'>\n");
				
				for(int i=0;i<totCnt;i++){
					
					Map<String, String> colValues = searchMonthlyQuotaAdjustmentTradeModifyListVOs.get(i).getColumnValues();
					
					sbufXML.append("<TR>");
					sbufXML.append("<TD BGCOLOR = \"" + bgColor[1] + "\"><![CDATA["+getNull(colValues.get("sub_trd_cd")) +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR = \"" + bgColor[1] + "\"><![CDATA["+getNull(colValues.get("lane_grp"))   +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR = \"" + bgColor[1] + "\"><![CDATA["+getNull(colValues.get("rhq_cd"))     +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR = \"" + bgColor[1] + "\"><![CDATA["+getNull(colValues.get("grp_seq1"))   +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR = \"" + bgColor[1] + "\"><![CDATA["+getNull(colValues.get("load1"))      +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR = \"" + bgColor[1] + "\"><![CDATA["+getNull(colValues.get("load1"))      +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR = \"" + bgColor[1] + "\"><![CDATA["+getNull(colValues.get("g_rpb1"))     +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR = \"" + bgColor[1] + "\"><![CDATA["+getNull(colValues.get("g_rpb1"))     +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR = \"" + bgColor[1] + "\"><![CDATA["+getNull(colValues.get("grp_seq2"))   +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR = \"" + bgColor[1] + "\"><![CDATA["+getNull(colValues.get("load2"))      +"]]></TD>\n");
					
					//if (colValues.get("load2")=="") {  	
					if ("".equals(colValues.get("load2"))) {  	//소스 품질 수정 요청건
						sbufXML.append("<TD BGCOLOR=\"DEFBF8\"><![CDATA["+getNull(colValues.get("load2")) +"]]></TD>\n");
					} else { 
						sbufXML.append("<TD BGCOLOR = \"" + bgColor[2] + "\"><![CDATA["+getNull(colValues.get("load2"))  +"]]></TD>\n");
					}
					sbufXML.append("<TD BGCOLOR = \"" + bgColor[1] + "\"><![CDATA["+getNull(colValues.get("g_rpb2"))     +"]]></TD>\n");
					
					//if (colValues.get("g_rpb2")=="") { 
					if ("".equals(colValues.get("g_rpb2"))) {   //소스 품질 수정 요청건
						sbufXML.append("<TD BGCOLOR=\"DEFBF8\"><![CDATA["+getNull(colValues.get("g_rpb2")) +"]]></TD>\n");
					} else {
						sbufXML.append("<TD BGCOLOR = \"" + bgColor[2] + "\"><![CDATA["+getNull(colValues.get("g_rpb2")) +"]]></TD>\n");
					}
					sbufXML.append("<TD BGCOLOR = \"" + bgColor[1] + "\"><![CDATA["+getNull(colValues.get("grp_seq3"))   +"]]></TD>\n");	
					sbufXML.append("<TD BGCOLOR = \"" + bgColor[1] + "\"><![CDATA["+getNull(colValues.get("load3"))      +"]]></TD>\n");
					
					//if (colValues.get("load3")=="") {
					if ("".equals(colValues.get("load3"))) { //소스 품질 수정 요청건
						sbufXML.append("<TD BGCOLOR=\"DEFBF8\"><![CDATA["+getNull(colValues.get("load3")) +"]]></TD>\n");
					} else {
						sbufXML.append("<TD BGCOLOR = \"" + bgColor[2] + "\"><![CDATA["+getNull(colValues.get("load3"))  +"]]></TD>\n");
					}
					sbufXML.append("<TD BGCOLOR = \"" + bgColor[1] + "\"><![CDATA["+getNull(colValues.get("g_rpb3"))     +"]]></TD>\n");	
					
					//if (colValues.get("g_rpb3")=="") {
					if ("".equals(colValues.get("g_rpb3"))) { //소스 품질 수정 요청건
						sbufXML.append("<TD BGCOLOR=\"DEFBF8\"><![CDATA["+getNull(colValues.get("g_rpb3")) +"]]></TD>\n");
					} else {
						sbufXML.append("<TD BGCOLOR = \"" + bgColor[2] + "\"><![CDATA["+getNull(colValues.get("g_rpb3")) +"]]></TD>\n");
					}
					
					sbufXML.append("<TD BGCOLOR = \"" + bgColor[1] + "\"><![CDATA["+getNull(colValues.get("tot_bsa"))     +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR = \"" + bgColor[1] + "\"><![CDATA["+getNull(colValues.get("rlane_cd"))    +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR = \"" + bgColor[1] + "\"><![CDATA["+getNull(colValues.get("sprt_grp_cd")) +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR = \"" + bgColor[1] + "\"><![CDATA["+getNull(colValues.get("bsa_grp_cd"))  +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR = \"" + bgColor[1] + "\"><![CDATA["+getNull(colValues.get("ctrt_rhq_cd")) +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR = \"" + bgColor[1] + "\"><![CDATA["+getNull(colValues.get("trd_cd"))      +"]]></TD>\n");
					sbufXML.append("<TD BGCOLOR = \"" + bgColor[1] + "\"><![CDATA["+getNull(colValues.get("load2"))       +"]]></TD>\n");
					sbufXML.append("<TD><![CDATA[R]]></TD>");
					sbufXML.append("<TD></TD>");
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
