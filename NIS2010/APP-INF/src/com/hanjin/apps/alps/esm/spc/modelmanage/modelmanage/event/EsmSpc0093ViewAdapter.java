/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0093ViewAdapter.java
*@FileTitle : SMP Report by Ofc
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.01
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2013.02.01 최윤성
* 1.0 Creation
* 2013.02.01 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2014.02.04 [CHM-201428383-01] RFA 로직 추가
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.event;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author CHOI Yun Sung
 * @see ViewAdapter 참조
 * @since CHOI Yun Sung
 */
public class EsmSpc0093ViewAdapter extends ViewAdapter {

	
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
		
		int totCnt  = vos.size();
		int realCnt = vos.size();
		
		String lvl    = null;
		String treeLvl = null;
		String custCtrlCd = null;
		
		//sheet의 Header인 sub trade를 etc data 로 받기 위함
		int subTrdCnt = 0;
		List<String> subTrdList = new ArrayList<String>();
		
		String trdTtlColor = "255,255,153"; //yellow
		String rhqTtlColor = "180,252,131"; //green
		String ofcTtlColor = "247,231,236"; //pink
		String nonColor = "255,255,255"; //white
		String bgColor = null;
		
		sbufXML.append("<DATA TOTAL='" + totCnt + "'>\n");
		
		for(int i=0;i<realCnt;i++){
			Map<String, String> colValues = vos.get(i).getColumnValues();
			
			if(i==0){
				subTrdCnt = Integer.parseInt(colValues.get("sub_trd_cnt"));

				for(int j=1; j<subTrdCnt+1; j++){
					subTrdList.add(colValues.get("sub_trd_cd_"+j));
				}
			}
			
			lvl = getNull(colValues.get("lvl"));
			
			if("6".equals(lvl)){
				treeLvl = "1";
			}else if("7".equals(lvl)){
				treeLvl = "2";
			}else if("8".equals(lvl)){
				treeLvl = "3";
			}else{
				treeLvl = "-1";
			}
			
			if("1".equals(lvl)){
				bgColor = trdTtlColor;
			}else if("3".equals(lvl)){
				bgColor = rhqTtlColor;
			}else if("5".equals(lvl)){
				bgColor = ofcTtlColor;
			}else{
				bgColor = nonColor;
			}
			
			custCtrlCd = getNull(colValues.get("cust_ctrl_cd"));
			
			
			sbufXML.append("<TR LEVEL='" + treeLvl +"'>");
			
			sbufXML.append("	<TD>" + getNull(colValues.get("trd_cd"))              + "</TD>");
			if("1".equals(lvl) || "2".equals(lvl)){
				sbufXML.append("	<TD>TTL</TD>");
			}else{
				sbufXML.append("	<TD>" + getNull(colValues.get("sls_rhq_cd"))              + "</TD>");
			}
			if("1".equals(lvl) || "2".equals(lvl) || "3".equals(lvl) || "4".equals(lvl)){
				sbufXML.append("	<TD>TTL</TD>");
			}else{
				sbufXML.append("	<TD>" + getNull(colValues.get("ofc_cd"))   + "</TD>");
			}
			if("1".equals(lvl) || "3".equals(lvl) || "5".equals(lvl)){
				sbufXML.append("	<TD BGCOLOR='"+bgColor+"'>Total</TD>");
			}else{
				sbufXML.append("	<TD>" + custCtrlCd + "</TD>");
			}
			if("6".equals(lvl)){
				sbufXML.append("	<TD>+</TD>");
			}else{
				sbufXML.append("	<TD BGCOLOR='"+bgColor+"'>" + getNull(colValues.get("acct_clss"))        + "</TD>");
			}
			if("7".equals(lvl)){
				sbufXML.append("	<TD>+</TD>");
			}else{
				sbufXML.append("	<TD BGCOLOR='"+bgColor+"'><![CDATA[" + getNull(colValues.get("cust_lgl_eng_nm"))        + "]]></TD>");
			}
			sbufXML.append("	<TD BGCOLOR='"+bgColor+"'>"+getNull(colValues.get("ctrt_ofc_cd"))+"</TD>");
			sbufXML.append("	<TD INDENT='1' BGCOLOR='"+bgColor+"'>"+getNull(colValues.get("sc_no"))+"</TD>");
			sbufXML.append("	<TD INDENT='1' BGCOLOR='"+bgColor+"'>"+getNull(colValues.get("rfa_no"))+"</TD>");
			sbufXML.append("	<TD BGCOLOR='"+bgColor+"'>" + treeLvl + "</TD>");
			
			
			for(int j=1; j<subTrdCnt+1; j++){
				sbufXML.append("	<TD BGCOLOR='"+bgColor+"'>"+getNull(colValues.get("sub_trd_cd_"+j))+"</TD>");
				if("C".equals(custCtrlCd)){
					sbufXML.append("	<TD BGCOLOR='"+bgColor+"'></TD>");
				}else{
					sbufXML.append("	<TD BGCOLOR='"+bgColor+"'>"+getNull(colValues.get("sub_trd_adj_qty_"+j))+"</TD>");
				}
				if("7".equals(lvl) || "8".equals(lvl) || "C".equals(custCtrlCd)){
					sbufXML.append("	<TD BGCOLOR='"+bgColor+"'></TD>");
				}else{
					sbufXML.append("	<TD BGCOLOR='"+bgColor+"'>"+getNull(colValues.get("sub_trd_adj_ratio_"+j))+"%</TD>");
				}
				sbufXML.append("	<TD BGCOLOR='"+bgColor+"'>"+getNull(colValues.get("c_load_qta_"+j))+"</TD>");
				if("7".equals(lvl) || "8".equals(lvl)){
					sbufXML.append("	<TD BGCOLOR='"+bgColor+"'></TD>");
				}else{
					sbufXML.append("	<TD BGCOLOR='"+bgColor+"'>"+getNull(colValues.get("c_load_qta_ratio_"+j))+"%</TD>");
				}
			}
			
			sbufXML.append("	<TD BGCOLOR='"+bgColor+"'></TD>");
			sbufXML.append("</TR>\n");
		}
		sbufXML.append("</DATA>\n");
		
		String strSubTrd = null;
		for(int i=0; i<subTrdList.size(); i++){
			if(strSubTrd == null){
				strSubTrd = subTrdList.get(i);
			}else{
				strSubTrd = strSubTrd + "|" + subTrdList.get(i);
			}
		}

		sbufXML.append("<ETC-DATA>\n");
		sbufXML.append("<ETC KEY=\"str_sub_trd\">").append(getNull(strSubTrd)).append("</ETC>\n");
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
	
//	private String nullToZero(String str) {
//		if(str == null || str.equals(""))
//			str = "0";
//		return str;
//	}
	
	protected String getETCData(EventResponse eventResponse) {
		return "";
	}
}