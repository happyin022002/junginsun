/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsmMas0107ViewAdapter.java
*@FileTitle : Trunk IPC Internal Pricing
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.12
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2010.10.12 이행지
* 1.0 Creation
*=========================================================
* History
* 2010.10.22 이행지 [CHM-201006375-01][MAS] Trunk IPC와 Ocean간 내부거래 신규 추가 
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.event;

import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.controller.ViewAdapter;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Lee SeungYol
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EsmMas0107ViewAdapter extends DefaultViewAdapter {
	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param colOrder String[] Column명 문자열 
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception 
	 */
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		StringBuilder sbufXML = new StringBuilder();
		
		int totCnt = vos.size();
		int realCnt = vos.size();

		AbstractValueObject vo = (AbstractValueObject)vos.get(0);
		
		if(vo.getMaxRows()>0){
			totCnt = vo.getMaxRows();
		}
		try {
			sbufXML.append("<DATA TOTAL='" + totCnt +"'>\n");
	
			for(int i=0;i<realCnt;i++){
				Map<String, String> colValues = vos.get(i).getColumnValues();
				float fx_cost_dtrb_amt = Float.parseFloat( getNull(colValues.get("fx_cost_dtrb_amt")) );
				
				sbufXML.append("<TR>");
				sbufXML.append("<TD></TD>");
				sbufXML.append("<TD>"+getNull(colValues.get("fm_trd_cd"))+"</TD>");
				sbufXML.append("<TD>"+getNull(colValues.get("fm_ioc_cd"))+"</TD>");
				sbufXML.append("<TD>"+getNull(colValues.get("fm_rlane_cd"))+"</TD>");
				sbufXML.append("<TD>"+getNull(colValues.get("fm_vsl_cd"))+getNull(colValues.get("fm_skd_voy_no"))+getNull(colValues.get("fm_skd_dir_cd"))+"</TD>");
				sbufXML.append("<TD>"+fx_cost_dtrb_amt+"</TD>");
				sbufXML.append("<TD>"+getNull(colValues.get("to_trd_cd"))+"</TD>");
				sbufXML.append("<TD>"+getNull(colValues.get("to_ioc_cd"))+"</TD>");
				sbufXML.append("<TD>"+getNull(colValues.get("to_rlane_cd"))+"</TD>");
				sbufXML.append("<TD>"+getNull(colValues.get("to_vsl_cd"))+getNull(colValues.get("to_skd_voy_no"))+getNull(colValues.get("to_skd_dir_cd"))+"</TD>");
				sbufXML.append("<TD>"+fx_cost_dtrb_amt*(-1)+"</TD>");
				sbufXML.append("</TR>\n");
			}
			sbufXML.append("</DATA>\n");
		} catch(Exception e){
            log.error("err " + e.toString(), e);
        }
		
		return sbufXML.toString();
	}
}
