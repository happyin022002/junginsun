/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSaq0077ViewAdapter.java
*@FileTitle : Model Result
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 김종호
*@LastVersion : 1.0
* 2008-11-24 Lee SeungYol (Default View Adapter 제공)
* 2009.08.31 김종호
* 1.0 Creation (new F/W 전환작업)   
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotastatusinquiry.event;

import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.saq.common.SAQUtil;
import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotastatusinquiry.vo.SearchMonthlyQuotaStatusInquiry0153List01VO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.controller.ViewAdapter;
/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Lee SeungYol
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EsmSaq0153ViewAdapter extends ViewAdapter {

	
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
	
		StringBuilder sbufXML = new StringBuilder();
		QuotaConditionVO quotaConditionVO = null;
		List<SearchMonthlyQuotaStatusInquiry0153List01VO> volist = null;
		int totCnt = vos.size();
		int realCnt = 0;
		ReturnVO returnVO = (ReturnVO)vos.get(0);
		
		if (returnVO !=null) {
		    volist = (List<SearchMonthlyQuotaStatusInquiry0153List01VO>)returnVO.getList(0);
		    quotaConditionVO = (QuotaConditionVO)returnVO.getConditionVO();
		}
		
		if (volist !=null && volist.size() > 0) realCnt = volist.size();

		
		
		String bgColor[] = SAQUtil.getColors(4);
		
		
		sbufXML.append("<DATA TOTAL='" + totCnt +"'>\n");

		
		for(int i=0;i<realCnt;i++){
			
			Map<String, String> colValues = volist.get(i).getColumnValues();
			
			
			String cellColor1 = "";
			String cellColor2 = "";	
			  
			if(("In Progress").equals(colValues.get("grp_status"))){
				
				cellColor1 = "BGCOLOR=\""+ SAQUtil.getHighlightColor(0) + "\" COLOR=\"red\"";
			}else {
				cellColor1 = "BGCOLOR=\""+bgColor[2]+"\"";
			}

			if(("In Progress").equals(colValues.get("status"))){
				
				cellColor2 = "BGCOLOR=\""+ SAQUtil.getHighlightColor(0) + "\" COLOR=\"red\"";
			}else {
				cellColor2 = "BGCOLOR=\""+bgColor[2]+"\"";
			}
			
 		
			//기존 VOs에서 받아온 데이터를 형변환 하여 VO에 입력
			sbufXML.append("<TR>\n");
			sbufXML.append("<TD BGCOLOR = \"" + bgColor[1] + "\"><![CDATA["+colValues.get("stage")+"]]></TD>\n");
			sbufXML.append("<TD BGCOLOR = \"" + bgColor[1] + "\"><![CDATA["+colValues.get("seq")+"]]></TD>\n");
			sbufXML.append("<TD BGCOLOR = \"" + bgColor[1] + "\"><![CDATA["+colValues.get("step")+"]]></TD>\n");
			sbufXML.append("<TD " + cellColor1 + "><![CDATA["+colValues.get("grp_status")+"]]></TD>\n");
			sbufXML.append("<TD " + cellColor1 + "><![CDATA["+colValues.get("filter1")+"]]></TD>\n");
			
            if("1".equals(quotaConditionVO.getGrpFlg())){
             	sbufXML.append("<TD " + cellColor1 +  "><![CDATA["+colValues.get("filter2")+"]]></TD>\n");
            }else {
             	sbufXML.append("<TD " + cellColor2 +  "><![CDATA["+colValues.get("filter2")+"]]></TD>\n");
            }
            
 			sbufXML.append("<TD " + cellColor2 + "><![CDATA["+colValues.get("filter3")+"]]></TD>\n");
			sbufXML.append("<TD " + cellColor2 + "><![CDATA["+colValues.get("filter4")+"]]></TD>\n");
			sbufXML.append("<TD " + cellColor2 + "><![CDATA["+colValues.get("version")+"]]></TD>\n");
			sbufXML.append("<TD " + cellColor2 + "><![CDATA["+colValues.get("upd_dt")+"]]></TD>\n");
			sbufXML.append("<TD BGCOLOR = \"" + bgColor[2] + "\"><![CDATA["+colValues.get("bse_yr")+"]]></TD>\n");
			sbufXML.append("<TD BGCOLOR = \"" + bgColor[2] + "\"><![CDATA["+colValues.get("bse_qtr_cd")+"]]></TD>\n");
			sbufXML.append("<TD BGCOLOR = \"" + bgColor[2] + "\"><![CDATA["+colValues.get("mqta_ver_no")+"]]></TD>\n");
			sbufXML.append("<TD BGCOLOR = \"" + bgColor[2] + "\"><![CDATA["+colValues.get("status")+"]]></TD>\n");
			
			sbufXML.append("</TR>\n");
		}
		
				
		sbufXML.append("</DATA>\n");
		
		return sbufXML.toString(); //스트링 버퍼로 받은 값들을 스트링으로 변환하여 반환한다.
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
	protected String makeDataTag(DBRowSet rs,String prefix) {
		// ViewAdapter에는 위의 List로 받는 부분과 이 쪽의 DBRowSet으로 받는 두 부분은 무조건 구현이 되어있어야한다.
		// 하지만 ESM_SAQ_0077의 경우 DBRowSet을 사용하지 않기 때문에 이부분은 골격만 만들어 놓는다.
		return null;
	}

}
