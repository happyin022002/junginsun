/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmSaq0116ViewAdapter.java
*@FileTitle      : remark
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.saq.common.common.event;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * EsmSsa0116 화면 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author M.C Choi
 * @see ViewAdapter 참조
 * @since J2EE 1.6
 */

public class EsmSaq0116ViewAdapter extends ViewAdapter {

	public EsmSaq0116ViewAdapter() {
		// TODO Auto-generated constructor stub
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

	@Override
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix){
		// TODO Auto-generated method stub
		StringBuilder sbufXML = new StringBuilder();

		int totCnt = vos.size();

			
		
		
		try {
			
			
			sbufXML.append("<DATA TOTAL='" + totCnt +"'> \n");
			
			for(int i=0;i<totCnt;i++){
				Map<String, String> colValues = vos.get(i).getColumnValues();
				sbufXML.append("<TR>                                                          \n");
				sbufXML.append("<TD></TD>                                                     \n");
				sbufXML.append("<TD><![CDATA["+getNull(colValues.get("bse_mon")) +"]]></TD>   \n");
				sbufXML.append("<TD><![CDATA["+getNull(colValues.get("bse_wk"))  +"]]></TD>   \n");
				sbufXML.append("<TD><![CDATA["+getNull(colValues.get("vvd"))     +"]]></TD>   \n");
				sbufXML.append("<TD><![CDATA["+getNull(colValues.get("bsa"))     +"]]></TD>   \n");
				sbufXML.append("</TR>                                                         \n"); 
		
			
			}
			sbufXML.append("</DATA> \n");
						
	
			
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
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
			while(it.hasNext()){ 
				String key = (String)it.next(); 
				String val = "" + etc_data.get(key); 
				sb.append("<ETC KEY=\"" + key + "\"><![CDATA[" + val + "]]></ETC>\n"); 
				
			} 
		}
		
		sb.append("<ETC KEY=\"status\"><![CDATA[OK]]></ETC>\n");
		sb.append("</ETC-DATA>\n");
		sb.append("<TR-ALL>OK</TR-ALL>\n");
		
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
