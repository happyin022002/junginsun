/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmSaq0049ViewAdapter2.java
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
import com.clt.apps.opus.esm.saq.monthlysalesquotaadjustmentinquiry.monthlyquotaadjustmentinquiry.vo.SearchMonthlyQuotaInquiry0049Tab02VO;
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
	public class EsmSaq0049ViewAdapter2 extends ViewAdapter {

		public EsmSaq0049ViewAdapter2() {

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
		//QuotaConditionVO conditionVO = null; //소스 품질 수정 요청건
		QuotaConditionVO conditionVO = new QuotaConditionVO(); //소스 품질 수정 요청건
		List<SearchMonthlyQuotaInquiry0049Tab02VO> volist = null;
		int realCnt = 0;
		ReturnVO returnVO = (ReturnVO)vos.get(0);		
		if (returnVO !=null) {
		    volist = (List<SearchMonthlyQuotaInquiry0049Tab02VO>)returnVO.getList(0);
		    conditionVO = (QuotaConditionVO)returnVO.getConditionVO();
		}
		
		// Tree 관련 색상 지정
		String[] bgcolor = SAQUtil.getColors(9);
		String items[] = conditionVO.getItem().split(":"); // 선택된 item text array
		
		if (items[0].equals("ALL")) {
			items = new String[]{"ALL"};	
		}

		
		int level = 1;
		//boolean isEndRow = false; // HAVE-CHILD check flag
		
		String unit = conditionVO.getUnit();
		float multiplier = 1F;
		//수치 데이터 저장(Total, 1~12월)
		float[] values = new float[4];
		//BSA 수치 데이터 저장(L/F 계산시 사용)
		//float[] bsaValues = new float[4];
		//Load 수치 데이터 저장(L/F 계산시 사용)
		//float[] loadValues = new float[4];

//		String cellFormat = "";
//		String isExpand = "";
//		String fontColor = "";
		
		
		FormCommand formcommand = conditionVO.getFormCommand();
		if( formcommand.isCommand(FormCommand.SEARCHLIST02)){	//2.1

			if (volist !=null && volist.size() > 0) realCnt = volist.size(); 
		
			sbufXML.append("<DATA TOTAL='" + realCnt + "'>\n");
			
			for(int i=0;i<realCnt;i++){ //3.1
				
				Map<String, String> colValues = volist.get(i).getColumnValues();
				
				
				
				level = Integer.parseInt(colValues.get("slevel"));	

//				fontColor = "COLOR=\"0,0,0\"";						
//				if(colValues.get("conv_dir_cd")!="") fontColor = "COLOR=\"255,0,0\"";				
				
				String dir_cd = colValues.get("dir_cd");
				String sub_trd_cd = colValues.get("sub_trd_cd");
				String rlane_cd = colValues.get("rlane_cd");
				String item = colValues.get("item_text");
				
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
					
					values[j] = Float.parseFloat(colValues.get("val_" + colSuffix)) * multiplier;
					
				}	
				
				
//				// L/F DATA-FORMAT, POINT-COUNT 설정
//				if (item.equalsIgnoreCase("L/F")) {
//					cellFormat = "DATA-FORMAT=\"dfFloat\" POINT-COUNT=\"1\" "; //1 --> 소숫점 이하 자리수
//				} else {
//					cellFormat = "";
//				}					
				
//				float strVal_00 = (Float) (values[0] == 0 ? "" : values[0]);
//				float strVal_01 = (Float) (values[1] == 0 ? "" : values[1]);
//				float strVal_02 = (Float) (values[2] == 0 ? "" : values[2]);
//				float strVal_03 = (Float) (values[3] == 0 ? "" : values[3]);
				
//				if( colValues.get("slevel").equals("1") ){
//					isExpand = "true";
//				}else{
//					isExpand = "false";
//				}
				
				
//				sbufXML.append("<TR LEVEL='" + colValues.get("slevel") + "' expand='" + isExpand +"'>\n");
				sbufXML.append("<TR>");
				if (item.equalsIgnoreCase("L/F")) {					
					sbufXML.append("<TD BGCOLOR='" + bgcolor[level-1] + "' ><![CDATA[" + dir_cd + "]]></TD>\n");
					sbufXML.append("<TD BGCOLOR='" + bgcolor[level-1] + "' ><![CDATA[" + sub_trd_cd + "]]></TD>\n");
					sbufXML.append("<TD BGCOLOR='" + bgcolor[level-1] + "' ><![CDATA[" + rlane_cd + "]]></TD>\n");
					sbufXML.append("<TD BGCOLOR='" + bgcolor[level-1] + "'><![CDATA[" +item + "]]></TD>\n");
					sbufXML.append("<TD BGCOLOR='" + bgcolor[level-1] + "'><![CDATA[" + Math.round(values[0]/0.1)*0.1 + "]]></TD>\n");
					sbufXML.append("<TD BGCOLOR='" + bgcolor[level-1] + "'><![CDATA[" + Math.round(values[1]/0.1)*0.1 + "]]></TD>\n");
					sbufXML.append("<TD BGCOLOR='" + bgcolor[level-1] + "'><![CDATA[" + Math.round(values[2]/0.1)*0.1 + "]]></TD>\n");
					sbufXML.append("<TD BGCOLOR='" + bgcolor[level-1] + "'><![CDATA[" + Math.round(values[3]/0.1)*0.1 + "]]></TD>\n");
					sbufXML.append("<TD BGCOLOR='" + bgcolor[level-1]+ "'></TD>\n");		
				}else{
					sbufXML.append("<TD BGCOLOR='" + bgcolor[level-1] + "' ><![CDATA[" + dir_cd + "]]></TD>\n");
					sbufXML.append("<TD BGCOLOR='" + bgcolor[level-1] + "' ><![CDATA[" + sub_trd_cd + "]]></TD>\n");
					sbufXML.append("<TD BGCOLOR='" + bgcolor[level-1] + "' ><![CDATA[" + rlane_cd + "]]></TD>\n");
					sbufXML.append("<TD BGCOLOR='" + bgcolor[level-1] + "'><![CDATA[" +item + "]]></TD>\n");	
					sbufXML.append("<TD BGCOLOR='" + bgcolor[level-1] + "'><![CDATA[" + (Float)values[0] + "]]></TD>\n");						
					sbufXML.append("<TD BGCOLOR='" + bgcolor[level-1] + "'><![CDATA[" + (Float)values[1] + "]]></TD>\n");
					sbufXML.append("<TD BGCOLOR='" + bgcolor[level-1] + "'><![CDATA[" + (Float)values[2] + "]]></TD>\n");
					sbufXML.append("<TD BGCOLOR='" + bgcolor[level-1] + "'><![CDATA[" + (Float)values[3] + "]]></TD>\n");			
					sbufXML.append("<TD BGCOLOR='" + bgcolor[level-1]+ "'></TD>\n");		
				}
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
