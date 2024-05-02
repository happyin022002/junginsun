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

import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.DewllNotifiySetupExpContainerVO;
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
public class EsdSce0157ViewAdapter extends ViewAdapter {

	
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
		String cloumndata  = null;
		String cloumndata1  = null;
		DewllNotifiySetupExpContainerVO vo = null;
		String row = "";
	    vo = (DewllNotifiySetupExpContainerVO) vos.get(0);
	    cloumndata = vo.getMstBkgNo();
	    cloumndata1 = vo.getMsg();
		row = vo.getRow();
		
		
		sbufXML.append("<DATA>\n");
		sbufXML.append("<TR ROW= \"" + JSPUtil.getNull(row) + "\" >\n");
		sbufXML.append("<TD COL=\"mst_bkg_no\" DATA-TYPE=\"dtData\"><![CDATA[" + JSPUtil.getNull(cloumndata) +"]]></TD>\n");
		sbufXML.append("<TD COL=\"msg\" DATA-TYPE=\"dtData\"><![CDATA[" + JSPUtil.getNull(cloumndata1) +"]]></TD>\n");
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