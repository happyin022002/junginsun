/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmSaq0049ViewAdapter5.java
*@FileTitle      : Trade Group
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotaadjustmentinquiry.monthlyquotaadjustmentinquiry.event;

import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.saq.common.SAQUtil;
import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotaadjustmentinquiry.monthlyquotaadjustmentinquiry.vo.SearchMonthlyQuotaInquiry0049Tab05VO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Lee SeungYol
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */

	public class EsmSaq0049ViewAdapter5 extends ViewAdapter {

		public EsmSaq0049ViewAdapter5() {

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
		StringBuilder sbufXML = new StringBuilder();
		//QuotaConditionVO conditionVO = null;
		QuotaConditionVO conditionVO = new QuotaConditionVO(); //소스 품질 수정 요청건
		List<SearchMonthlyQuotaInquiry0049Tab05VO> volist = null;
		int realCnt = 0;
		ReturnVO returnVO = (ReturnVO)vos.get(0);		
		if (returnVO !=null) {
		    volist = (List<SearchMonthlyQuotaInquiry0049Tab05VO>)returnVO.getList(0);
		    conditionVO = (QuotaConditionVO)returnVO.getConditionVO();
		}
		
		// Tree 관련 색상 지정
		String[] bgcolor = SAQUtil.getColors(9);
		String items[] = conditionVO.getItem().split(":"); // 선택된 item text array
		
		if (items[0].equals("ALL")) {
			items = new String[]{"ALL"};	
		}

		int level = 1;
//		boolean isEndRow = false; // HAVE-CHILD check flag
		
		String unit = conditionVO.getUnit();
		float multiplier = 1F;
		//수치 데이터 저장(Total, 1~12월)
		//float[] values = new float[4];
		//BSA 수치 데이터 저장(L/F 계산시 사용)
		//float[] bsaValues = new float[4];
		//Load 수치 데이터 저장(L/F 계산시 사용)
		//float[] loadValues = new float[4];

		//String cellFormat = "";
//		String isExpand = "";
		String fontColor = "";
		
		String strVal = "";
//		int colorIdx = 0;
		
		FormCommand formcommand = conditionVO.getFormCommand();
		if( formcommand.isCommand(FormCommand.SEARCHLIST05)){	//2.1

			if (volist !=null && volist.size() > 0) realCnt = volist.size(); 
		
			sbufXML.append("<DATA TOTAL='" + realCnt + "'>\n");
			
			for(int i=0;i<realCnt;i++){ //3.1
				
				Map<String, String> colValues = volist.get(i).getColumnValues();
				
				level = Integer.parseInt(colValues.get("slevel"));
				
				
				fontColor = "COLOR=\"0,0,0\"";						
				//if(colValues.get("conv_dir_cd")!="") fontColor = "COLOR=\"255,0,0\"";			
				
				if(!colValues.get("conv_dir_cd").equals("")) fontColor = "COLOR=\"255,0,0\""; //소스 품질 수정 요청건	
			
//				isEndRow = (Integer.parseInt(colValues.get("row_seq")) == 6
//						|| (colValues.get("item_text").equals(items[items.length-1]))
//						? true : false);
				
				String sub_trd_cd = colValues.get("sub_trd_cd");
				String rlane_cd = colValues.get("rlane_cd");
				String vvd_grp_cd = colValues.get("vvd_grp_cd");
				//String vvd_grp_name = rlane_cd + "-" + vvd_grp_cd;
				//vvd_grp_name = vvd_grp_name.indexOf("TOTAL") != -1 ? "TOTAL" : vvd_grp_name;
				String rhq_cd = colValues.get("rhq_cd");
				String aq_cd = colValues.get("aq_cd");
				String ofc_cd_1 = colValues.get("ofc_cd_1");
				String ofc_cd_2 = colValues.get("ofc_cd_2");
				String item = colValues.get("item");								
				String bse_wk = colValues.get("bse_wk");			
				String vvd_cd = colValues.get("vvd_cd");
				
				vvd_grp_cd = vvd_grp_cd.equals("") ? " " : vvd_grp_cd;
				rhq_cd = rhq_cd.equals("") ? " " : rhq_cd;
				aq_cd = aq_cd.equals("") ? " " : aq_cd;
				aq_cd = aq_cd.equals("000000") ? "  " : aq_cd;
				ofc_cd_1 = ofc_cd_1.equals("") ? " " : ofc_cd_1;
				ofc_cd_2 = ofc_cd_2.equals("") ? " " : ofc_cd_2;		
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
				
				
				strVal = Float.parseFloat(colValues.get("val")) == 0 ? "" : String.valueOf(Float.parseFloat(colValues.get("val")) * multiplier ) ;
				
//				if( colValues.get("slevel").equals("1") ){
//					isExpand = "true";
//				}else{
//					isExpand = "false";
//				}				
//				
//				String isChild = "";
//				
//				if(level==7 && isEndRow){
//					isChild = "TRUE";
//				}else {
//					isChild = "FALSE";
//				}
				
				
				
//				sbufXML.append("<TR LEVEL='" + colValues.get("slevel") + "' HAVE-CHILD='" + isChild +"' expand='" + isExpand +"'>\n");
				sbufXML.append("<TR>");
				sbufXML.append("<TD BGCOLOR='" + bgcolor[level-1] + "'><![CDATA[" +bse_wk + "]]></TD>\n");
				sbufXML.append("<TD BGCOLOR='" + bgcolor[level-1] + "' ><![CDATA[" + sub_trd_cd + "]]></TD>\n");
				sbufXML.append("<TD BGCOLOR='" + bgcolor[level-1] + "'  " + fontColor +"><![CDATA[" + rlane_cd + "]]></TD>\n");
				sbufXML.append("<TD BGCOLOR='" + bgcolor[level-1] + "'><![CDATA[" +vvd_grp_cd + "]]></TD>\n");
				sbufXML.append("<TD BGCOLOR='" + bgcolor[level-1] + "'><![CDATA[" +vvd_cd + "]]></TD>\n");
				sbufXML.append("<TD BGCOLOR='" + bgcolor[level-1] + "'><![CDATA[" +rhq_cd + "]]></TD>\n");
				sbufXML.append("<TD BGCOLOR='" + bgcolor[level-1] + "' ><![CDATA[" + aq_cd + "]]></TD>\n");
				sbufXML.append("<TD BGCOLOR='" + bgcolor[level-1] + "' ><![CDATA[" + ofc_cd_1 + "]]></TD>\n");
				sbufXML.append("<TD BGCOLOR='" + bgcolor[level-1] + "'><![CDATA[" +item + "]]></TD>\n");
				sbufXML.append("<TD BGCOLOR='" + bgcolor[level-1] + "'><![CDATA[" +strVal + "]]></TD>\n");
				sbufXML.append("<TD BGCOLOR='" + bgcolor[level-1]+ "'></TD>\n");		
				sbufXML.append("</TR>\n");
	
			}	//3.9  for문 END
			sbufXML.append("</DATA>\n");
	    } //2.9 if END
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
