/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0068ViewAdapter.java
*@FileTitle : Pre-Allocation Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 주선영
*@LastVersion : 1.0
* 2009.09.07 주선영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelconstraintmanage.preallocation.event;

import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.controller.ViewAdapter;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author 주선영
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EsmSpc0067ViewAdapter extends ViewAdapter{
	
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

		
 	   sbufXML.append("<DATA TOTAL='" + totCnt + "' >\n");
		for(int i=0;i<realCnt;i++){
			Map<String, String> colValues = vos.get(i).getColumnValues();			
			sbufXML.append("<TR>\n");
			sbufXML.append("	<TD></TD>	    ");
			sbufXML.append("	<TD>R</TD>	    ");
			sbufXML.append("	<TD></TD>	    ");			
			sbufXML.append("	<TD><![CDATA["+colValues.get("bse_yr")+"]]></TD>	    ");
			sbufXML.append("	<TD><![CDATA["+colValues.get("bse_mon")+"]]></TD>	    ");
			sbufXML.append("	<TD>"+colValues.get("rep_trd_cd")+"</TD>    ");
			sbufXML.append("	<TD>"+colValues.get("rlane_cd")+"</TD>	    ");
			sbufXML.append("	<TD>"+colValues.get("dir_cd")+"</TD>	    ");
			sbufXML.append("	<TD COMBO-CODE=\"" + colValues.get("vsl_clss_capa") + " \" COMBO-TEXT=\"" +  colValues.get("vsl_clss_capa_txt") +"\">" + colValues.get("vsl_clss_capa") +"</TD>");
			sbufXML.append("	<TD>"+colValues.get("port_cd")+"</TD>	    ");
			sbufXML.append("	<TD>"+colValues.get("spc_aloc_qty")+"</TD>	");
			sbufXML.append("	<TD>"+colValues.get("to_trd_cd")+"</TD>	");
			sbufXML.append("	<TD>"+colValues.get("to_dir_cd")+"</TD>	");
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