/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmSpc0042ViewAdapter.java
*@FileTitle      : Control by HO
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.08.14
*@LastModifier   : 최윤성
*@LastVersion    : 1.0
* 2009.08.14
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.event;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author CHOI Yun Sung 
 * @see ViewAdapter 참조
 * @since CHOI Yun Sung
 */
public class EsmSpc0042ViewAdapter extends ViewAdapter {

	
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
		
		int totCnt = vos.size();
		int realCnt = vos.size();

		AbstractValueObject vo = (AbstractValueObject)vos.get(0);
		
		if(vo.getMaxRows()>0){
			totCnt = vo.getMaxRows();
		}
		
		sbufXML.append("<DATA TOTAL='" + totCnt + "'>\n");
		
		for(int i=0;i<realCnt;i++){
			Map<String, String> colValues = vos.get(i).getColumnValues();
			
			sbufXML.append("<TR>");
			sbufXML.append("	<TD></TD>");
            sbufXML.append("	<TD>" + getNull(colValues.get("trd_cd"))           + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("sub_trd_cd"))       + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("rlane_cd"))         + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("dir_cd"))           + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("cost_yr")) + getNull(colValues.get("cost_wk")) + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("vvd"))              + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("bsa_vol"))          + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("bsa_wgt"))          + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("lod_vol"))          + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("lod_wgt"))          + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("lod_hc"))           + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("lod_45"))           + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("lod_rf"))           + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("qta_ocn"))          + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("qta_ipc"))          + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("fc_ocn_vol"))       + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("fc_ocn_wgt"))       + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("fc_ipc_vol"))       + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("fc_ipc_wgt"))       + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("fc_ts_vol"))       + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("fc_ts_wgt"))       + "</TD>");
			sbufXML.append("	<TD><![CDATA[" + (Float.parseFloat(nullToZero(getNull(colValues.get("bsa_vol")))) == 0?"":((getNull(colValues.get("trd_cd")).startsWith("I")?Float.parseFloat(nullToZero(getNull(colValues.get("fc_ipc_vol")))):Float.parseFloat(nullToZero(getNull(colValues.get("fc_ocn_vol"))))) * 100 / Float.parseFloat(nullToZero(getNull(colValues.get("bsa_vol")))))) + "]]></TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("al_ocn_vol"))       + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("al_ocn_wgt"))       + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("al_ipc_vol"))       + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("al_ipc_wgt"))       + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("al_ts_vol"))       + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("al_ts_wgt"))       + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("bkg_ocn_vol"))      + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("bkg_ocn_wgt"))      + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("bkg_ipc_vol"))      + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("bkg_ipc_wgt"))      + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("bkg_ts_vol"))      + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("bkg_ts_wgt"))      + "</TD>");
			if ((getNull(colValues.get("trd_cd")).startsWith("I"))){
				sbufXML.append("	<TD CALCU-LOGIC=\"|lod_vol|-|" + "alloc_ipc_vol|-|alloc_ts_vol"+"|\"></TD>");
			} else {
				sbufXML.append("	<TD CALCU-LOGIC=\"|lod_vol|-|" + "alloc_ocn_vol|"+"|\"></TD>");				
			}
			sbufXML.append("	<TD>" + getNull(colValues.get("vsl_cd"))           + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("skd_voy_no"))       + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("skd_dir_cd"))       + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("ctrl_spc_flg"))     + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("ctrl_port_flg"))    + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("ctrl_40ft_hc_flg")) + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("ctrl_45ft_hc_flg")) + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("ctrl_53ft_flg"))    + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("ctrl_rf_flg"))      + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("ctrl_wgt_flg"))     + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("ibflag"))           + "</TD>");
			sbufXML.append("	<TD></TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("mty_gnte"))         + "</TD>");
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
	
	private String nullToZero(String str) {
		String rtnStr = ""; //소스 품질 수정 요청건
		//if(str == null || str == "") //소스 품질 수정 요청건
		if(str == null || "".equals(str)) {
			rtnStr = "0";
		} else {
			rtnStr = str;			
		}
		return rtnStr;
	}

}