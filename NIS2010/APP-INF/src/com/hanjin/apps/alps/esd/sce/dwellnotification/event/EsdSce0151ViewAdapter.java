/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DefaultViewAdapter.java
*@FileTitle : Default IBSheet Generation Class
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-08
*@LastModifier : chae chang Ho
*@LastVersion : 1.0
* 2009-09-08 chae chang Hp
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.dwellnotification.event;

import java.util.Iterator;
import java.util.List;
import java.util.HashMap;

import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.DwllNtfcSrchVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Lee SeungYol
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EsdSce0151ViewAdapter extends ViewAdapter {

	
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
		String[] cloumndata  = null;
		DwllNtfcSrchVO vo = null;
		DwllNtfcSrchVO conditionVO = (DwllNtfcSrchVO) vos.get(0);
		String row = "";
	    vo = (DwllNtfcSrchVO) vos.get(1);
	    cloumndata = vo.getResultStrArray();
		row = conditionVO.getRow();
		
		
		sbufXML.append("<DATA>\n");
		sbufXML.append("<TR ROW= \"" + JSPUtil.getNull(row) + "\" >\n");
		sbufXML.append("<TD COL=\"sc_no\" DATA-TYPE=\"dtData\"><![CDATA[" + JSPUtil.getNull(cloumndata[9].toString()) +"]]></TD>\n");
		sbufXML.append("<TD COL=\"cust_cd\" DATA-TYPE=\"dtData\"><![CDATA[" + JSPUtil.getNull(cloumndata[8].toString()) +"]]></TD>\n");
		sbufXML.append("<TD COL=\"ctrt_pty_nm\" DATA-TYPE=\"dtData\"><![CDATA[" + JSPUtil.getNull(cloumndata[0].toString()) +"]]></TD>\n");
		sbufXML.append("<TD COL=\"tml_dwll_flg\" DATA-TYPE=\"dtData\"><![CDATA[" + JSPUtil.getNull(cloumndata[1].toString()) +"]]></TD>\n");
		sbufXML.append("<TD COL=\"enr_dwll_flg\" DATA-TYPE=\"dtData\"><![CDATA["+ JSPUtil.getNull(cloumndata[2].toString()) +"]]></TD>\n");
		sbufXML.append("<TD COL=\"dest_dwll_flg\" DATA-TYPE=\"dtData\"><![CDATA[" + JSPUtil.getNull(cloumndata[3].toString()) +"]]></TD>\n");
		sbufXML.append("<TD COL=\"eff_dt\" DATA-TYPE=\"dtData\"><![CDATA[" + JSPUtil.getNull(cloumndata[4].toString()) +"]]></TD>\n");
		sbufXML.append("<TD COL=\"exp_dt\" DATA-TYPE=\"dtData\"><![CDATA[" + JSPUtil.getNull(cloumndata[5].toString()) +"]]></TD>\n");
		sbufXML.append("<TD COL=\"vsl_dlay_flg\" DATA-TYPE=\"dtData\"><![CDATA[" + JSPUtil.getNull(cloumndata[6].toString()) +"]]></TD>\n");
		sbufXML.append("<TD COL=\"expt_set_usr_id\" DATA-TYPE=\"dtData\"><![CDATA[" + JSPUtil.getNull(cloumndata[10].toString()) +"]]></TD>\n");
		sbufXML.append("<TD COL=\"expt_set_dt\" DATA-TYPE=\"dtData\"><![CDATA[" + JSPUtil.getNull(cloumndata[11].toString()) +"]]></TD>\n");
		sbufXML.append("<TD COL=\"expt_set_usr_name\" DATA-TYPE=\"dtData\"><![CDATA[" + JSPUtil.getNull(cloumndata[12].toString()) +"]]></TD>\n");
		sbufXML.append("</TR>\n");
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
	protected String makeDataTag(DBRowSet rs,String prefix) {
		return null;
	}


	protected String getETCData(EventResponse eventResponse) { 
		if(eventResponse==null) 
		return ""; 

		StringBuilder sb = new StringBuilder(); 
		HashMap<String, String> etc_data = (HashMap<String, String>) eventResponse.getETCData(); 

		sb.append("<ETC-DATA>\n"); 
		if(etc_data !=null && etc_data.size()>0){ 
			Iterator<String> it = etc_data.keySet().iterator(); 
			while(it.hasNext())	{ 
				String key = (String)it.next(); 
				String val = "" + etc_data.get(key); 
				sb.append("<ETC KEY='" + key + "'><![CDATA[" + val + "]]></ETC>\n"); 
			} 
		} 
		//Pivot 관련 ETC-DATA생성 
		sb.append(getPivotETCData(eventResponse)); 
		sb.append("</ETC-DATA>\n"); 

		return sb.toString(); 
		} 
}