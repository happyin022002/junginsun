/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmSpc0100ViewAdapter.java
*@FileTitle      : Lane-Office-POL
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.08.03
*@LastModifier   : 한상훈
*@LastVersion    : 1.0
* 2009.08.03
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.dailyforecast.basicdata.event;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.spc.common.SPCUtil;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author 한상훈
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EsmSpc0100ViewAdapter extends ViewAdapter{
	
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
		log.debug("EsmSpc0105ViewAdapter makeDataTag List<AbstractValueObject> vos, String prefix..............");
		StringBuilder sbufXML = new StringBuilder();
		
		int totCnt = vos.size();
		int realCnt = vos.size();

		AbstractValueObject vo = (AbstractValueObject)vos.get(0);
		
		String[] colors = SPCUtil.getColors(4);
		
		if(vo.getMaxRows()>0){
			totCnt = vo.getMaxRows();
		}
		
		sbufXML.append("<DATA TOTAL='" + totCnt +"'>\n");

		for(int i=0;i<realCnt;i++){
			Map<String, String> colValues = vos.get(i).getColumnValues();			
			
			int lvl = Integer.parseInt(colValues.get("lvl").substring(0,1));
			sbufXML.append("	<TR LEVEL='"+ lvl +"'>");			
			sbufXML.append("	<TD>"+colValues.get("yrwk")+"</TD>	");
			sbufXML.append("	<TD>"+colValues.get("slan_cd")+"</TD>	");
			sbufXML.append("    <TD").append(lvl==1?" DATA-TYPE=\"dtImage\"":"").append(lvl<=1?" BGCOLOR=\""+colors[lvl-1]+"\"":"").append(">").append(lvl==1?"1":colValues.get("ts_port")).append("</TD>	");
			sbufXML.append("	<TD").append(lvl==2?" DATA-TYPE=\"dtImage\"":"").append(lvl<=2?" BGCOLOR=\""+colors[lvl-1]+"\"":"").append(">").append(lvl==2?"1":colValues.get("bkg_port")).append("</TD>	");
			sbufXML.append("	<TD").append(lvl==3?" DATA-TYPE=\"dtImage\"":"").append(lvl<=3?" BGCOLOR=\""+colors[lvl-1]+"\"":"").append(">").append(lvl==3?"1":colValues.get("sls_ofc_cd")).append("</TD>	");
			sbufXML.append("	<TD").append(lvl==4?" DATA-TYPE=\"dtImage\"":"").append(lvl<=4?" BGCOLOR=\""+colors[lvl-1]+"\"":"").append(">").append(lvl==4?"1":colValues.get("rlane_cd")).append("</TD>	");
			sbufXML.append("	<TD").append(lvl<=4?" BGCOLOR=\""+colors[lvl-1]+"\"":"").append(">"+colValues.get("vvd")).append("</TD>	");
			sbufXML.append("	<TD").append(lvl<=4?" BGCOLOR=\""+colors[lvl-1]+"\"":"").append(">"+colValues.get("lvl")).append("</TD>	");
			sbufXML.append("	<TD").append(lvl<=4?" BGCOLOR=\""+colors[lvl-1]+"\"":"").append(">"+colValues.get("bkg_ttl_qty")).append("</TD>	");
			sbufXML.append("	<TD").append(lvl<=4?" BGCOLOR=\""+colors[lvl-1]+"\"":"").append(">"+colValues.get("bkg_ttl_wgt")).append("</TD>	");
			sbufXML.append("	<TD").append(lvl<=4?" BGCOLOR=\""+colors[lvl-1]+"\"":"").append(">"+colValues.get("bkg_20ft_qty")).append("</TD>	");
			sbufXML.append("	<TD").append(lvl<=4?" BGCOLOR=\""+colors[lvl-1]+"\"":"").append(">"+colValues.get("bkg_40ft_qty")).append("</TD>	");
			sbufXML.append("	<TD").append(lvl<=4?" BGCOLOR=\""+colors[lvl-1]+"\"":"").append(">"+colValues.get("bkg_40ft_hc_qty")).append("</TD>	");
			sbufXML.append("	<TD").append(lvl<=4?" BGCOLOR=\""+colors[lvl-1]+"\"":"").append(">"+colValues.get("bkg_45ft_hc_qty")).append("</TD>	");
			sbufXML.append("	<TD").append(lvl<=4?" BGCOLOR=\""+colors[lvl-1]+"\"":"").append(">"+colValues.get("bkg_rf20_qty")).append("</TD>	");
			sbufXML.append("	<TD").append(lvl<=4?" BGCOLOR=\""+colors[lvl-1]+"\"":"").append(">"+colValues.get("bkg_rf40_qty")).append("</TD>	");
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
	protected String makeDataTag(DBRowSet rs,String prefix) {
		StringBuilder sb = new StringBuilder();
		
		//Pivot Table인 경우 makePivotDataTag 실행하여  return한
		if(rs.isPivot()){
			sb.append(makePivotDataTag(rs));
			return sb.toString();
		}

		String[] realColNms = getColHeader(rs);

		try{
			String[] changedColNms = getChangedColNms(realColNms, prefix);
			
			sb.append("<DATA COLORDER='" + JSPUtil.convertStringArrayToString(changedColNms, "|") + "' COLSEPARATOR='" + DELIMITER + "' TOTAL='" + getRowSetCnt(rs) + "'>\n");
			
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
	
	/**
	 * Pivot Table용 Data tag를 생성한다.<br>
	 * 
	 * @param rs			DBRowSet 		VO객체
	 * @return String 	IBSheet 			<DATA>태그
	 * @exception 
	 */
	protected String makePivotDataTag(DBRowSet rs) {
		StringBuilder sb = new StringBuilder();
		int colCnt = 0;
		int rowCnt = rs.getRowCount();
		
		String[][] arrRowSet = null;

		try{
			colCnt = rs.getMetaData().getColumnCount();
			arrRowSet = new String[rowCnt][colCnt];
			
			int rowIdx = 0;
			while (rs.next()) { 
				for (int j = 1 ; j <= colCnt ; j++) {
					arrRowSet[rowIdx][j-1] = getNull(rs.getObject(j)).toString();
				}
				rowIdx++;
			}
		}catch(SQLException ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}

		
		try{
			sb.append("<DATA COLSEPARATOR='" + DELIMITER + "'>\n");
			if(rowCnt>0){
				for (int coIdx = 0 ;coIdx < colCnt ; coIdx++) {
					sb.append("	<TR><![CDATA[");
					for(int roIdx=0;roIdx < rowCnt-1; roIdx++){
						sb.append(arrRowSet[roIdx][coIdx] + DELIMITER);
					}
					sb.append(arrRowSet[rowCnt-1][coIdx]  + "]]></TR>\n");
				}//end for coIdx
			}//end for roIdx
			sb.append("</DATA>\n");
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}
		return sb.toString();
	}
}