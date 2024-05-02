/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0024ViewAdapter2.java
*@FileTitle : spacecontrolinquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.20 한상훈
* 1.0 Creation
* 2009.11.24 CHOI.Y.S
* - GS 분리
* 2011.06.27 Kim jong jun : 소스 품질검토 결과 적용
2011.10.24 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업 중 오류 수정
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import java.util.List;

import com.hanjin.apps.alps.esm.spc.common.SPCUtil;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ComplexMainVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author 한상훈
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EsmSpc0024ViewAdapter2 extends ViewAdapter{
	
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
		
		DBRowSet rowSets = new DBRowSet();
		rowSets = comMain.getRs();
		
		int rowCount = 0;
		
		try{
			rowCount = rowSets.getRowCount();
		}catch(Exception e){
			log.debug("DBRowSet err");
			log.error(e.getMessage());
		}
		
		sbufXML.append("<DATA TOTAL=\"" + rowCount + "\">\n");
		
		String[] color = SPCUtil.getColors(3);
		color[2] = "255,255,255";
		int monthCount = 0;
		String monthList = null;
		
		if (rowSets != null && rowSets.getRowCount()>0) {//3.1
			try{
				if(rowSets.next()){
					monthList  = rowSets.getString("mon");
					monthCount = rowSets.getInt("fcast_lod_qty");
				}
			}catch(Exception e){
				log.error(e.getMessage(), e);
			}
			
			int r   = 0;
			int t   = 0;
			int lvl = 0;
			int rCount = rowCount / (monthCount + 1);
			
			try{
				if(monthCount > 0){
					monthList = monthList + "|TTL";
					for(r = 0; r < rCount ; r++){
						rowSets.next();
						lvl = rowSets.getInt("lvl");
						
						if(!searchOffice || lvl >= 2){
							sbufXML.append("<tr BGCOLOR=\"" + color[lvl] + "\"  MERGE=\"").append((lvl==2)?"":"TRUE").append("\">\n");
							sbufXML.append("<td>" + rowSets.getString("trd_cd") + "</td>\n");
							sbufXML.append("<td>" + rowSets.getString("aq_cd")  + "</td>\n");
							sbufXML.append("<td>" + rowSets.getString("ofc_cd") + "</td>\n");
							sbufXML.append("<td INDENT=\"1\">" + rowSets.getString("fcast_lod_qty") + "</td>\n");
							sbufXML.append("<td INDENT=\"2\">" + rowSets.getString("shortfall")     + "</td>\n");
							sbufXML.append("<td INDENT=\"3\">" + rowSets.getString("ratio")         + "%</td>\n");
							
							for(t = 0; t < monthCount ; t++){
								if(rowSets.next()){
									sbufXML.append("<td INDENT=\"1\">" + rowSets.getString("fcast_lod_qty") + "</td>\n");
									sbufXML.append("<td INDENT=\"2\">" + rowSets.getString("shortfall")     + "</td>\n");
									sbufXML.append("<td INDENT=\"3\">" + rowSets.getString("ratio")         + "%</td>\n");
								}
							}
							
							sbufXML.append("<td>" + rowSets.getString("lvl") + "</td>\n");
							sbufXML.append("</tr>\n");
						} else {
							for(t = 0; t < monthCount ; t++){
								rowSets.next();
							}
						}
					}
				}
			}catch(Exception e){
				log.error(e.getMessage(), e);
			}
		}
		
		sbufXML.append("</DATA>\n");
		sbufXML.append("<ETC-DATA>\n");
		sbufXML.append("<ETC KEY=\"title\">" + monthList + "</ETC>\n");
		sbufXML.append("</ETC-DATA>\n");
		
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
	
	protected String getETCData(EventResponse eventResponse) {
		return "";
	}
}