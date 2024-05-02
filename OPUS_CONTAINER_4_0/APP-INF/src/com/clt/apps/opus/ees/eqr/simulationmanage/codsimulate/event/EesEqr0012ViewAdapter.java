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
package com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.event;

import java.util.Iterator;
import java.util.List;
import java.util.HashMap;

import com.clt.apps.opus.ees.eqr.common.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.vo.EesEqr0012ConditionVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Lee SeungYol
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EesEqr0012ViewAdapter extends ViewAdapter {

	
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
		String[] loc  = null;
		CommonRsVO vo = null;
		int rowCount	 = 0; //DB ResultSet 리스트의 건수
		EesEqr0012ConditionVO conditionVO = (EesEqr0012ConditionVO) vos.get(0);
		String row = "";
		String col = null;
		String colName1 = conditionVO.getColname1();
		String colName2 = conditionVO.getColname2();
		String startdate = conditionVO.getStartdate();
		String enddate = conditionVO.getEnddate();
	    vo = (CommonRsVO) vos.get(1);
	    loc = vo.getResultStrArray();
		loc[0] = "| |"+loc[0] ;
		loc[1] = "| |"+loc[1] ;
		//loc[2] = "| |"+loc[2] ;
		//loc[2] = loc[2] ;
		//loc[3] = "||"+loc[3] ;	
		rowCount = Integer.parseInt(loc[4]);
		
		row = conditionVO.getRow1();
		col = conditionVO.getCol();
		if (!loc[2].equals("| |")){
			
			String strLocChange = loc[2].replace('|', ',');
			String[] arrLocYard = strLocChange.split(",");
			String strLocYard = "";
			String allLocYard = "";
			if(arrLocYard.length > 0) {
				for(int i=0; i <arrLocYard.length; i++) {
					strLocYard = arrLocYard[i].trim();
					if(!"".equals(strLocYard) && strLocYard != null){
						strLocYard = strLocYard.substring(3);
						if(i == 0) {
							allLocYard = strLocYard;
						}else{
							allLocYard = allLocYard +"|" + strLocYard;
						}
					}
				}
			}
			
			if(loc[2].length() == 3) {
				allLocYard = loc[2]; 
			}
			
			sbufXML.append("<DATA>\n");
			sbufXML.append("<TR ROW= \"" + row + "\" >\n");
			sbufXML.append("<TD COL=\""+col+"\" DATA-TYPE=\"dtCombo\" COMBO-TEXT=\"" + allLocYard + "\" COMBO-CODE=\"" + loc[3] + "\"></TD>\n");
			sbufXML.append("<TD COL=\"vvdCnt\" DATA-TYPE=\"dtData\">" + rowCount + "</TD>\n");
			sbufXML.append("<TD COL=\""+ colName1 +"\" >"+JSPUtil.getNull(startdate)+"</TD>");
			sbufXML.append("<TD COL=\""+ colName2 +"\" >"+JSPUtil.getNull(enddate)+"</TD>");
			sbufXML.append("</TR>\n");
			sbufXML.append("</DATA>\n");
		}else {
			sbufXML.append("<DATA>\n");
			sbufXML.append("<TR ROW= \"" + row + "\" >\n");
			sbufXML.append("<TD COL=\""+col+"\" DATA-TYPE=\"dtData\" COMBO-TEXT=\"" + loc[2] + "\" COMBO-CODE=\"" + loc[3] + "\"></TD>\n");
			sbufXML.append("<TD COL=\"vvdCnt\" DATA-TYPE=\"dtData\">" + rowCount + "</TD>\n");
			sbufXML.append("<TD COL=\""+ colName1 +"\" >"+JSPUtil.getNull(startdate)+"</TD>");
			sbufXML.append("<TD COL=\""+ colName2 +"\" >"+JSPUtil.getNull(enddate)+"</TD>");
			sbufXML.append("</TR>\n");
			sbufXML.append("</DATA>\n");	
		}
		
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