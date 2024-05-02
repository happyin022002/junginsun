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
package com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.event;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.HashMap;
import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author chae chang Ho
 * @see ViewAdapter 참조
 * @since J2EE 1.6
 */
public class EesEqr0088ViewAdapter extends ViewAdapter {

	
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
		CommonRsVO listVO = new CommonRsVO();
		AbstractValueObject vo = (AbstractValueObject)vos.get(0);
		ObjectCloner.build(vo, listVO);
		DBRowSet rowSet	 = listVO.getDbRowset();
		sbufXML.append("<DATA TOTAL='"+getRowSetCnt(rowSet)+"'> ");
		int i =1;
		try{
		if (rowSet != null) {
			while (rowSet.next()) {
				if (rowSet.getString(2).equals("Total")){
					sbufXML.append("<TR BGCOLOR='247,231,236'>");	
				}else {
					sbufXML.append("<TR> ");	
				}
				for (int j = 0 ; j < rowSet.getMetaData().getColumnCount() ; j++) {
					if (j==0){
						sbufXML.append(" <TD BGCOLOR='239,235,239'><![CDATA["+JSPUtil.getNull(rowSet.getString(i++))+"]]></TD>");
					}else {
						sbufXML.append(" <TD><![CDATA["+JSPUtil.getNull(rowSet.getString(i++))+"]]></TD>"); 
					}
				}
					i = 1;
			sbufXML.append("</TR> \n");
			}
		}
		sbufXML.append(" </DATA>");					
		}catch(SQLException ex){
			throw new RuntimeException(ex.getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
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
		StringBuilder sb = new StringBuilder();
		
		String[] realColNms = getColHeader(rs);

		try{
			sb.append("<DATA COLSEPARATOR='" + DELIMITER + "' TOTAL='" + getRowSetCnt(rs) + "'>\n");
			int colCount = realColNms.length;
			
			while (rs.next()) { 
				sb.append("	<TR><![CDATA[");
				for (int j = 1 ; j < colCount ; j++) {
					sb.append(getNull(rs.getObject(j)) + DELIMITER);
				}	
				sb.append(getNull(rs.getObject(colCount))  + "]]></TR>\n");
			}
			sb.append("</DATA>\n");
		}catch(SQLException ex){
			throw new RuntimeException(ex.getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}

		return sb.toString();
	
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