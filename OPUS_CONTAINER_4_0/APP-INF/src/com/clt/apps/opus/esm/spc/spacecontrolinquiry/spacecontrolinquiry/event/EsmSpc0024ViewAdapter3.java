/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmSpc0024ViewAdapter3.java
*@FileTitle      : No-Show Summary
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.08.20
*@LastModifier   : 한상훈
*@LastVersion    : 1.0
* 2009.08.20
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import java.util.List;

import com.clt.apps.opus.esm.spc.common.SPCUtil;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ComplexMainVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.controller.ViewAdapter;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author 한상훈
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EsmSpc0024ViewAdapter3 extends ViewAdapter{
	
	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param colOrder String[] Column명 문자열 
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception 
	 */	
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) 
	{
		StringBuilder sbufXML = new StringBuilder();
				
		ComplexMainVO comMain = (ComplexMainVO)vos.get(0);
		boolean searchOffice  = !comMain.getCondition().getOffice().equals("");
		boolean searchVVD     = !comMain.getCondition().getVvd().equals("");
		boolean searchWeek    = !comMain.getCondition().getWeek().equals("");
		boolean searchLane    = !comMain.getCondition().getLane().equals("");
		
		DBRowSet rowSets = new DBRowSet();
		rowSets = comMain.getRs();
		
		int rowCount = 0;
		
		try{				
			rowCount = rowSets.getRowCount();	
		}catch(Exception e){
			log.error(e.getMessage(), e);
		}
		
		sbufXML.append("<DATA TOTAL=\""+rowCount+"\">\n");
		
		String[] color = SPCUtil.getColors(4);
		color[3] = "255,255,255";
		
		if (rowSets != null && rowSets.getRowCount()>0) {//3.1
			int lvl       = 0;
			String office = null;
			String lane   = null;
			String week   = null;
			String vvd    = null;
			
			try{
				while(rowSets.next()){
					lvl    = rowSets.getInt("lvl");
					office = rowSets.getString("ofc_cd");
					lane   = rowSets.getString("rlane_cd");
					week   = rowSets.getString("cost_wk");
					vvd    = rowSets.getString("vvd");
					
					if(office.equals("")) {
						office = "-";
					} else if(lane.equals("")) {
						lane = "-";
					} else if(week.equals("")) {
						week =  "-";// "+";
					}
					
					if((!searchOffice || lvl >= 2) && (!searchVVD || (lvl != 2 && lvl != 3)) && (!searchWeek || lvl != 3) && (!searchLane || lvl != 2)){
						sbufXML.append("<tr BGCOLOR='" + color[lvl-1] + "'>\n");
//						sbufXML.append("<tr BGCOLOR=\"" + color[lvl-1] + "\" LEVEL=\"" + lvl + "\" EXPAND=\"").append((searchVVD || lvl<3)?"TRUE":"FALSE").append("\">\n");
						sbufXML.append("<td BGCOLOR=\"" + color[3] + "\">" + rowSets.getString("aq_cd") + "</td>\n");
						sbufXML.append("<td BGCOLOR=\"").append(lvl>1?color[3]:color[lvl-1]).append("\">" + office + "</td>\n");
						sbufXML.append("<td BGCOLOR=\"").append(lvl>2?color[3]:color[lvl-1]).append("\">" + lane   + "</td>\n");
						sbufXML.append("<td>" + week + "</td>\n");
						sbufXML.append("<td>" + vvd  + "</td>\n");
						sbufXML.append("<td INDENT=\"1\">" + rowSets.getString("fcast_lod_qty") + "</td>\n");
						sbufXML.append("<td INDENT=\"2\">" + rowSets.getString("bkg_lod_qty")   + "</td>\n");
						sbufXML.append("<td INDENT=\"1\">" + rowSets.getString("aloc_lod_qty")  + "</td>\n");
						sbufXML.append("<td INDENT=\"2\">" + rowSets.getString("shortfall")     + "</td>\n");
						sbufXML.append("<td INDENT=\"3\">" + rowSets.getString("ratio")         + "%</td>\n");
						sbufXML.append("<td>" + lvl + "</td>\n");
						sbufXML.append("</tr>\n");
					}
				}
			}catch(Exception e){
				log.error(e.getMessage(), e);
			}
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
	protected String makeDataTag(DBRowSet rs,String prefix) {
		StringBuilder sb = new StringBuilder();
		
		return sb.toString();
	} 
	
	/**
	 * Pivot Table용 Data tag를 생성한다.<br>
	 * 
	 * @param rs			DBRowSet 		VO객체
	 * @return String 	IBSheet 			<DATA>태그
	 * @exception 
	 */
	protected String makePivotDataTag(DBRowSet rs) {
		StringBuilder sb = new StringBuilder();

		return sb.toString();
	}
}