/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0041ViewAdapter.java
*@FileTitle      : QTA Set-up by RHQ (Contract TTL retrieve only)
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.06.13
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.06.13 SQM USER
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.planning.planning.event;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author SQM USER
 * @see ViewAdapter 참조
 * @since SQM USER
 */
public class EsmSqm0041ViewAdapter extends ViewAdapter {
	
	/**
	 * VO List 를 Parsing 하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception 
	 */
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		StringBuilder sbufXML = new StringBuilder();
		
		int totCnt  = vos.size();
		int realCnt = vos.size();

		String color = "";
		String obDivCd = "";
		sbufXML.append("<DATA TOTAL='" + totCnt + "'>\n");
		
		for(int i=0;i<realCnt;i++){
			Map<String, String> colValues = vos.get(i).getColumnValues();
			
			obDivCd          = getNull(colValues.get("ob_div_cd"));
			if ( obDivCd.isEmpty() || obDivCd.equals("N.OB") ) {
				color = " BGCOLOR='255,255,255'";
			}else{
				color = " BGCOLOR=''";
			}

			sbufXML.append("<TR MERGE='TRUE'>");
			sbufXML.append("	<TD></TD>	");
			sbufXML.append("	<TD"  + color + ">" + getNull(colValues.get("bse_yr")) + "</TD>");
			sbufXML.append("	<TD"  + color + ">" + getNull(colValues.get("bse_qtr_cd")) + "</TD>");
			sbufXML.append("	<TD"  + color + ">" + getNull(colValues.get("ob_div_cd")) + "</TD>");
			sbufXML.append("	<TD"  + color + ">" + getNull(colValues.get("ofc_vw_cd")) + "</TD>");
			sbufXML.append("	<TD"  + color + ">" + getNull(colValues.get("trd_cd")) + "</TD>");
			sbufXML.append("	<TD"  + color + ">" + getNull(colValues.get("sub_trd_cd")) + "</TD>");
			sbufXML.append("	<TD"  + color + ">" + getNull(colValues.get("rlane_cd")) + "</TD>");
			sbufXML.append("	<TD"  + color + ">" + getNull(colValues.get("conv_dir_cd")) + "</TD>");
			sbufXML.append("	<TD"  + color + ">" + getNull(colValues.get("hul_bnd_cd")) + "</TD>");
			sbufXML.append("	<TD"  + color + ">" + getNull(colValues.get("bse_wk")) + "</TD>");
			sbufXML.append("	<TD"  + color + ">" + getNull(colValues.get("vvd")) + "</TD>");
			sbufXML.append("	<TD"  + color + ">" + getNull(colValues.get("fnl_bsa_capa")) + "</TD>");
			sbufXML.append("	<TD"  + color + ">" + getNull(colValues.get("rhq_cd")) + "</TD>");
			sbufXML.append("	<TD"  + color + ">" + getNull(colValues.get("rgn_ofc_cd")) + "</TD>");
			sbufXML.append("	<TD"  + color + ">" + getNull(colValues.get("ofc_qty")) + "</TD>");
			sbufXML.append("	<TD"  + color + ">" + getNull(colValues.get("ofc_rev")) + "</TD>");


			sbufXML.append("</TR>\n");
		}
		sbufXML.append("</DATA>\n");
		
		return sbufXML.toString();
	}
	
	/**
	 * DBRowSet를 Parsing 하여 <DATA>태그를 생성한다.<br>
	 * IBSheet의 prefix 값이 있는 경우 COLORDER에 prefix 를 붙인 column 명으로 표시해 준다.<br>
	 * 
	 * @param rs		DBRowSet	VO객체
	 * @param prefix	String		IBSheet savename's prefix string
	 * @return String	IBSheet		<DATA> 태그
	 * @exception 
	 */
	protected String makeDataTag(DBRowSet rs, String prefix) {
		StringBuilder sb = new StringBuilder();
		
		//Pivot Table 인 경우 makePivotDataTag 실행하여  return
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
	 * Pivot Table 용 Data tag 를 생성한다.<br>
	 * 
	 * @param rs		DBRowSet	VO 객체
	 * @return String	IBSheet		<DATA> 태그
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