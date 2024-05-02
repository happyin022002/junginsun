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
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotarelease.event;

import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotarelease.vo.SearchMonthlyQuotaRelease0052ListSub01VO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
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
public class EsmSaq0052ViewAdapter1 extends ViewAdapter {

	
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
		//QuotaConditionVO conditionVO = null; //소스 품질 수정 요청건
		QuotaConditionVO conditionVO = new QuotaConditionVO(); //소스 품질 수정 요청건
		List<SearchMonthlyQuotaRelease0052ListSub01VO> volist = null;
		int totCnt = vos.size();
		int realCnt =0;

		ReturnVO returnVO = (ReturnVO)vos.get(0);		
		if (returnVO !=null) {
		    volist = (List<SearchMonthlyQuotaRelease0052ListSub01VO>)returnVO.getList(0);
		    conditionVO = (QuotaConditionVO)returnVO.getConditionVO();
		}
		
		if (volist !=null && volist.size() > 0) realCnt = volist.size();		

		
		FormCommand formcommand = conditionVO.getFormCommand();		
		
	    if(formcommand.isCommand(FormCommand.SEARCHLIST01)){	

	    	sbufXML.append("<DATA TOTAL='" + totCnt +"'>\n");
			String mqta_rlse_ver_no = "";
			String trd_cd = "";
			String dir_cd = "";
			String saq_tgt_grp_cd = "";
			String mqta_ver_no = "";
			String gline_ver_no = "";
			String mod ="";
	        String is_new_version = conditionVO.getVersion();
	        
			if("true".equals(is_new_version)){
				mod ="I";
			}else {
				mod ="R";
			}
			
			for(int i=0;i<realCnt;i++){
				
				Map<String, String> colValues = volist.get(i).getColumnValues();
				
				mqta_rlse_ver_no = JSPUtil.getNull(colValues.get("mqta_rlse_ver_no"));
				trd_cd = JSPUtil.getNull(colValues.get("trd_cd"));
				dir_cd = JSPUtil.getNull(colValues.get("dir_cd"));
				saq_tgt_grp_cd = JSPUtil.getNull(colValues.get("saq_tgt_grp_cd"));
				mqta_ver_no = JSPUtil.getNull(colValues.get("mqta_ver_no"));
				gline_ver_no = JSPUtil.getNull(colValues.get("gline_ver_no"));
			
				
				//기존 VOs에서 받아온 데이터를 형변환 하여 VO에 입력
				sbufXML.append("<TR>\n");
				sbufXML.append("<TD></TD>\n");
				sbufXML.append("<TD><![CDATA["+ mod +"]]></TD>\n");
				sbufXML.append("<TD><![CDATA["+ trd_cd +"]]></TD>\n");
				sbufXML.append("<TD><![CDATA["+ dir_cd +"]]></TD>\n");
				sbufXML.append("<TD><![CDATA["+ mqta_ver_no +"]]></TD>\n");
				sbufXML.append("<TD><![CDATA["+ saq_tgt_grp_cd +"]]></TD>\n");
				sbufXML.append("<TD><![CDATA["+ gline_ver_no +"]]></TD>\n");
				sbufXML.append("<TD><![CDATA["+ mqta_rlse_ver_no +"]]></TD>\n");
				sbufXML.append("</TR>\n");
			}
					
			sbufXML.append("</DATA>\n");
	    }
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
