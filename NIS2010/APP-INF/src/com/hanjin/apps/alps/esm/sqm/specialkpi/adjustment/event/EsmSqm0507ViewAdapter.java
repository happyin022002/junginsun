/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0507ViewAdapter.java
*@FileTitle      : SKD Adjustment by VVD
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.07.23
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.07.23 SQM USER
* 1.0 Creation
* 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
* 2015.11.09 김용습 [CHM-201538494] [CSR 전환건] SKD Adjustment by VVD 화면 보완 (Trade Direction, Adjusting VVD Select, BSA Flag 칼럼 추가)
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.event;

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
public class EsmSqm0507ViewAdapter extends ViewAdapter {
	
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
		
		sbufXML.append("<DATA TOTAL='" + totCnt + "'>\n");
		
		String flag         = "";
		String bse_mon      = "";
		String bse_wk       = "";
		String vvd          = "";
		String fnl_bsa_capa = "";
		
		String mas_bse_mon      = "";
		String mas_bse_wk       = "";
		String mas_vvd          = "";
		String mas_fnl_bsa_capa = "";
		
		String  isEdit    = "";
		String  adj_vvd    = "";
		String  isChkbox = "";
		
		boolean isBseMon  = false;
		boolean isBseWk   = false;
		boolean isVvd     = false;
		boolean isBsaCapa = false;
		
		String tdDelColor = "";
		String tdBgColor  = "";
		String tdMonColor = "";
		String tdWkColor  = "";
		String tdVvdColor = "";
		String tdBsaColor = "";
		
		for(int i=0;i<realCnt;i++){
			Map<String, String> colValues = vos.get(i).getColumnValues();
			
			flag         = getNull(colValues.get("flag"));
			bse_mon      = getNull(colValues.get("bse_mon"));
			bse_wk       = getNull(colValues.get("bse_wk"));
			vvd          = getNull(colValues.get("vvd"));
			fnl_bsa_capa = getNull(colValues.get("fnl_bsa_capa"));
			
			mas_bse_mon      = getNull(colValues.get("mas_bse_mon"));
			mas_bse_wk       = getNull(colValues.get("mas_bse_wk"));
			mas_vvd          = getNull(colValues.get("mas_vvd"));
			mas_fnl_bsa_capa = getNull(colValues.get("mas_fnl_bsa_capa"));
			
			if ( mas_bse_mon.isEmpty() || bse_mon.equals(mas_bse_mon) ) {
				isBseMon   = false;
				tdMonColor = "";
			} else {
				isBseMon   = true;
				tdMonColor = " COLOR='255,0,0'";
			}
			
			if ( mas_bse_wk.isEmpty() || bse_wk.equals(mas_bse_wk) ) {
				isBseWk   = false;
				tdWkColor = "";
			} else {
				isBseWk   = true;
				tdWkColor = " COLOR='255,0,0'";
			}
			
			if ( mas_vvd.isEmpty() || vvd.equals(mas_vvd) ) {
				isVvd      = false;
				tdVvdColor = "";
			} else {
				isVvd      = true;
				tdVvdColor = " COLOR='255,0,0'";
			}
			
			if ( mas_fnl_bsa_capa.isEmpty() || fnl_bsa_capa.equals(mas_fnl_bsa_capa) ) {
				isBsaCapa  = false;
				tdBsaColor = "";
			} else {
				isBsaCapa  = true;
				tdBsaColor = " COLOR='255,0,0'";
			}
			
			if ( isBseWk || isBseMon || isVvd || isBsaCapa ) {
				tdBgColor = " BGCOLOR='242,221,220'";
			} else {
				tdBgColor = "";
			}
			
			if ( flag.equals("I") ) {
				isEdit = " EDIT='TRUE'";
			} else {
				isEdit = " EDIT='FALSE'";
			}
			
			if ( flag.equals("D") ) {
				tdDelColor = " BGCOLOR='242,221,220' COLOR='255,0,0'";
			} else {
				tdDelColor = "";
			}
			
			if ( adj_vvd.equals("") ) {
				isChkbox = " EDIT='TRUE'";
			} else {
				isChkbox = " EDIT='FALSE'";
			}
			
			sbufXML.append("<TR MERGE='TRUE'>");
			sbufXML.append("	<TD>" + getNull(colValues.get("trd_cd"))     + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("dir_cd"))     + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("hul_bnd_cd"))     + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("sub_trd_cd")) + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("rlane_cd"))   + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("ioc_cd"))     + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("sts_flag"))   + "</TD>");
			sbufXML.append("	<TD>" + flag + "</TD>");
			sbufXML.append("	<TD"  + tdDelColor + ">" + bse_mon      + "</TD>");
			sbufXML.append("	<TD"  + tdDelColor + ">" + bse_wk       + "</TD>");
			sbufXML.append("	<TD"  + tdDelColor + ">" + vvd          + "</TD>");
			sbufXML.append("	<TD"  + tdDelColor + ">" + fnl_bsa_capa + "</TD>");
			sbufXML.append("	<TD"  + tdBgColor + tdMonColor + ">" + mas_bse_mon      + "</TD>");
			sbufXML.append("	<TD"  + tdBgColor + tdWkColor  + ">" + mas_bse_wk       + "</TD>");
			sbufXML.append("	<TD"  + tdBgColor + tdVvdColor + ">" + mas_vvd          + "</TD>");
			sbufXML.append("	<TD"  + tdBgColor + tdBsaColor + ">" + mas_fnl_bsa_capa + "</TD>");
			sbufXML.append("	<TD"  + isEdit + "></TD>");
			sbufXML.append("	<TD"  + isChkbox + "></TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("bsa_zr_flg")) + "</TD>");
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