/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSaq0176ViewAdapter.java
*@FileTitle : Monthly Sales Quota Adjustment RHQ - Excel Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : ChoiI.M.C
*@LastVersion : 1.0
* 2008-01-24 Lee Ho Ik
* 1.0 Creation
* 2010.05.03 Lee Sang Yong : new F/W 전환작업
* 2010.06.28 Kim Min Ah : [CHM-201004282] 소스 품질검토 결과 적용
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.event;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Lee Sang Yong
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */

public class EsmSaq0176ViewAdapter extends ViewAdapter {

	public EsmSaq0176ViewAdapter() {
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
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		// TODO Auto-generated method stub
		StringBuilder sbufXML = new StringBuilder();
		
		ReturnVO listVO = (ReturnVO)vos.get(0);
		DBRowSet rowSet = listVO.getDbRowset();
		EsmSaq0176Event event = (EsmSaq0176Event)listVO.getList(0);
		
		int totCnt = 0;
		
		try {
			
			if(rowSet != null){
				totCnt = rowSet.getRowCount();	
			}
			
			if( event.getQuotaConditionVO().getChkCommand().equals("SEARCHLIST")){
				
				sbufXML.append("<DATA TOTAL='" + totCnt +"'>\n");
				
				if (rowSet != null) {
					while (rowSet.next()) {
						
						sbufXML.append("<TR>");
						sbufXML.append("<TD><![CDATA[R]]></TD>");
						for ( int j = 1; j < 26; j++ ) {
							sbufXML.append("<TD>"+rowSet.getString(j)+"</TD>");
						}
						sbufXML.append("</TR>\n");
					}
				}
			
				sbufXML.append("</DATA>\n");

			}
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
