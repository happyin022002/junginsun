/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmSaq0163ViewAdapter.java
*@FileTitle      : Customized Conditions
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.saq.basicdatamanage.monthlycustomizedcondition.event;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.clt.apps.opus.esm.saq.basicdatamanage.monthlycustomizedcondition.vo.MonthlyCustomizedConditionTabLoadTargetVO;
import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author 김태호
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
 
public class EsmSaq0163ViewAdapter extends ViewAdapter {

	public EsmSaq0163ViewAdapter() {
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
		QuotaConditionVO conditionVO =  listVO.getConditionVO();
		//DBRowSet rowSet = listVO.getDbRowset();
		log.debug("EsmSaq0163ViewAdapter  !!!!!!!!!!!"+conditionVO.getChkCommand());
		try{
			DBRowSet rowSet = listVO.getDbRowset();
						
			if( conditionVO.getChkCommand().equals("SEARCHLIST01")) {
				
				int totCnt = rowSet.getRowCount();
				
				log.debug("EsmSaq0163ViewAdapter  =======>>"+totCnt);
				
				
				sbufXML.append("<DATA TOTAL='" + totCnt +"'>\n");
		
				if (rowSet != null) {
					while (rowSet.next()) {
						//Map<String, String> colValues = list01.get(i).getColumnValues();
			
						sbufXML.append("<TR>");
	//					sbufXML.append("<TD></TD>");
	//					sbufXML.append("<TD></TD>");
	//					sbufXML.append("<TD></TD>");
						sbufXML.append("<TD></TD>");
						
						sbufXML.append("<TD>"+rowSet.getString("saq_tgt_grp_cd")+"</TD>");
						sbufXML.append("<TD>"+rowSet.getString("trd_cd")+"</TD>");
						sbufXML.append("<TD>"+rowSet.getString("dir_cd")+"</TD>");
						sbufXML.append("<TD>"+rowSet.getString("sls_rhq_cd")+"</TD>");
						sbufXML.append("</TR>\n");
					     
					}
				}
				sbufXML.append("</DATA>\n");
			}else if( conditionVO.getChkCommand().equals("SEARCHLIST02")) {
				
				int totCnt = rowSet.getRow();
				
				sbufXML.append("<DATA TOTAL='" + totCnt +"'>\n");
		
				if (rowSet != null) {
					while (rowSet.next()) {
					//Map<String, String> colValues = list01.get(i).getColumnValues();
		
						sbufXML.append("<TR>");
						sbufXML.append("<TD></TD>");
						sbufXML.append("<TD></TD>");
						sbufXML.append("<TD></TD>");
						sbufXML.append("<TD>"+rowSet.getString("trade_group")+"</TD>");
						sbufXML.append("<TD>"+rowSet.getString("trd_cd")+"</TD>");
						sbufXML.append("<TD>"+rowSet.getString("sub_trd_cd")+"</TD>");
						sbufXML.append("<TD>"+rowSet.getString("rlane_cd")+"</TD>");
						sbufXML.append("<TD>"+rowSet.getString("dir_cd")+"</TD>");
						sbufXML.append("<TD>"+rowSet.getString("conv_dir_cd")+"</TD>");
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
		log.debug("getETCData ==============================>>>>>>>>>>11");
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
		
//		sb.append("<TR-ALL>OK</TR-ALL>\n");
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
		log.debug("getETCData ==============================>>>>>>>>>>22");
		// TODO Auto-generated method stub
		return null;
	}

}
