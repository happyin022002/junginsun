/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName       : EsmCsq0219ViewAdapter.java
*@FileTitle      : QTA Adjustment by VVD for IAS Sector
*@Open Issues    :
*@Change history :
*@LastModifyDate : 2014.01.23
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2014.01.23 CSQ USER
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.event;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.csq.common.basic.CommonBC;
import com.clt.apps.opus.esm.csq.common.basic.CommonBCImpl;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 *
 * @author CSQ USER
 * @see ViewAdapter 참조
 * @since CSQ USER
 */
public class EsmCsq0219ViewAdapter extends ViewAdapter {

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
		String coa_bse_mon      = "";
		String coa_bse_wk       = "";
		String coa_vvd          = "";
		String coa_fnl_bsa_capa = "";
		String searchCode = "";

		String  f_click    = "";
		String  isChkbox  = "";
		
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
		
		CommonBC commonBc = new CommonBCImpl();
		
		HashMap vVVDList = null;
		String vVVD = "|";
		try{
	
			for(int i=0;i<realCnt;i++){
				Map<String, String> colValues = vos.get(i).getColumnValues();
	
				flag         = getNull(colValues.get("flag"));
				bse_mon      = getNull(colValues.get("bse_mon"));
				bse_wk       = getNull(colValues.get("bse_wk"));
				vvd          = getNull(colValues.get("vvd"));
				fnl_bsa_capa = getNull(colValues.get("fnl_bsa_capa"));
				coa_bse_mon      = getNull(colValues.get("coa_bse_mon"));
				coa_bse_wk       = getNull(colValues.get("coa_bse_wk"));
				coa_vvd          = getNull(colValues.get("coa_vvd"));
				coa_fnl_bsa_capa = getNull(colValues.get("coa_fnl_bsa_capa"));
				f_click      = getNull(colValues.get("f_click"));
				
				//노선에 따른 VVD 정보를 가져온다.
				if (i==0 ) {
					searchCode = getNull(colValues.get("bse_tp_cd")) + "|"
							        +  getNull(colValues.get("bse_yr"))      + "|"
							        +  getNull(colValues.get("bse_qtr_cd"))      + "|IAS|"
							        +  getNull(colValues.get("sub_trd_cd"));
					vVVDList  = commonBc.getCodeIbCombo("controlVvdList",searchCode);		
				
				}
	
				if ( coa_bse_mon.isEmpty() || bse_mon.equals(coa_bse_mon) ) {
					isBseMon   = false;
					tdMonColor = "";
				} else {
					isBseMon   = true;
					tdMonColor = " COLOR='255,0,0'";
				}
	
				if ( coa_bse_wk.isEmpty() || bse_wk.equals(coa_bse_wk) ) {
					isBseWk   = false;
					tdWkColor = "";
				} else {
					isBseWk   = true;
					tdWkColor = " COLOR='255,0,0'";
				}
	
				if ( coa_vvd.isEmpty() || vvd.equals(coa_vvd) ) {
					isVvd      = false;
					tdVvdColor = "";
				} else {
					isVvd      = true;
					tdVvdColor = " COLOR='255,0,0'";
				}
	
				if ( coa_fnl_bsa_capa.isEmpty() || fnl_bsa_capa.equals(coa_fnl_bsa_capa) ) {
					isBsaCapa  = false;
					tdBsaColor = "";
				} else {
					isBsaCapa  = true;
					tdBsaColor = " COLOR='255,0,0'";
				}
	
				if ( isBseMon || isBseWk || isVvd || isBsaCapa ) {
					tdBgColor = " BGCOLOR='242,221,220'";
				} else {
					tdBgColor = "";
				}
	
				if ( flag.equals("D") ) {
					tdDelColor = " BGCOLOR='242,221,220' COLOR='255,0,0'";
				} else {
					tdDelColor = "";
				}
	
				if ( f_click.equals("Y") ) {
					isChkbox = " EDIT='TRUE'";
				} else {
					isChkbox = " EDIT='FALSE'";
				}
				if (flag.equals("I")) {
					if(vVVDList != null)  vVVD = "|" + vVVDList.get(getNull(colValues.get("rlane_cd"))+getNull(colValues.get("dir_cd")) );
				}
				sbufXML.append("<TR>");
				sbufXML.append("	<TD>" + getNull(colValues.get("trd_cd")) + "</TD>");
				sbufXML.append("	<TD>" + getNull(colValues.get("sub_trd_cd")) + "</TD>");
				sbufXML.append("	<TD>" + getNull(colValues.get("rlane_cd")) + "</TD>");
				sbufXML.append("	<TD>" + getNull(colValues.get("dir_cd")) + "</TD>");
				sbufXML.append("	<TD>" + getNull(colValues.get("qta_rlse_ver_no")) + "</TD>");
				sbufXML.append("	<TD>" + getNull(colValues.get("ioc_cd")) + "</TD>");
				sbufXML.append("	<TD>" + getNull(colValues.get("sts_flag")) + "</TD>");
				sbufXML.append("	<TD>" + flag + "</TD>");
				sbufXML.append("	<TD"  + tdDelColor + ">" + bse_mon      + "</TD>");
				sbufXML.append("	<TD"  + tdDelColor + ">" + bse_wk       + "</TD>");
				sbufXML.append("	<TD"  + tdDelColor + ">" + vvd          + "</TD>");
				sbufXML.append("	<TD"  + tdDelColor + ">" + fnl_bsa_capa + "</TD>");
				sbufXML.append("	<TD"  + tdDelColor + ">" + getNull(colValues.get("lod_qty")) + "</TD>");
				sbufXML.append("	<TD"  + tdDelColor + ">" + getNull(colValues.get("grs_rev")) + "</TD>");
				sbufXML.append("	<TD"  + tdBgColor + tdMonColor + ">" + coa_bse_mon      + "</TD>");
				sbufXML.append("	<TD"  + tdBgColor + tdWkColor  +">" + coa_bse_wk       + "</TD>");
				sbufXML.append("	<TD"  + tdBgColor + tdVvdColor + ">" + coa_vvd          + "</TD>");
				sbufXML.append("	<TD"  + tdBgColor + tdBsaColor + ">" + coa_fnl_bsa_capa + "</TD>");
				if(flag.equals("I")) {
					sbufXML.append("	<TD EDIT='TRUE' DATA-TYPE='dtCombo' COMBO-TEXT='"+ vVVD +"' COMBO-CODE='"+ vVVD +"' ></TD>");
				} else {
					sbufXML.append("	<TD></TD>");
				}
				sbufXML.append("	<TD"  + isChkbox + "></TD>");
				sbufXML.append("</TR>\n");
			}
			sbufXML.append("</DATA>\n");
		}catch(Exception e){
			log.error("err " + e.toString(), e);
		}
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