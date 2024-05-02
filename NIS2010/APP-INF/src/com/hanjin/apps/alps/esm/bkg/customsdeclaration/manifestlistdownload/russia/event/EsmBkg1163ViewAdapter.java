/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EsmBkg1163ViewAdapter.java
*@FileTitle : Russia Customs Manifest
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.05
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.07.05 김보배
* 1.0 Creation
* -------------------------------------------------------
* History
* 2013.11.04 김보배 [CHM-201327164] Russia Manifest 기능 보완
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.russia.event;

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
 * @author BOBAE KIM
 * @see ViewAdapter 참조
 * @since J2EE 1.6
 */
public class EsmBkg1163ViewAdapter extends ViewAdapter{

	/**
	 * VO List 를 Parsing 하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param List<AbstractValueObject> vos
	 * @param String prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception 
	 */	
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		StringBuilder sbufXML = new StringBuilder();
		
		int totCnt = vos.size();
		int realCnt = vos.size();

		AbstractValueObject vo = (AbstractValueObject)vos.get(0);
		//String[] realColNms=getColHeader(vo);
		//String[] changedColNms = getChangedColNms(realColNms, prefix);
		
		if(vo.getMaxRows()>0){
			totCnt = vo.getMaxRows();
		}
		String groupingCd     = ""; //새로운 행을 만들기 위한 기준코드
		String tempGroupingCd = "";//새로운 행을 만들기 위한 기준코드 템프
		
		sbufXML.append("\n<DATA TOTAL='").append(totCnt).append("'>\n");
		Map<String, String> colValues = null;
		
		if(realCnt>0){
			colValues = vos.get(0).getColumnValues();
		}
		
		StringBuilder sbufXMLTotal = new StringBuilder();
		for(int i=0;i<realCnt;i++){
			colValues = vos.get(i).getColumnValues();
			tempGroupingCd =colValues.get("group_title");
			
			//이전 SR NO와 현재 데이타의 값이 틀리면 제목을 새로 생성한다.
			if(!groupingCd.equals(tempGroupingCd)){
				if(i > 0 ){ // total을 만든다.  
					sbufXML.append("	<TR BGCOLOR='247,225,236' MERGE='TRUE'>\n");
					sbufXML.append("		<TD DATA-ALIGN='daLeft' BOLD='true' EDIT='false'><![CDATA[").append(vos.get(i-1).getColumnValues().get("group_total")).append("]]></TD>\n");
					for (int j = 0; j < 23; j++) {
						sbufXML.append("		<TD><![CDATA[").append(vos.get(i-1).getColumnValues().get("group_total")).append("]]></TD>\n");
					}
					
					sbufXML.append("	</TR>\n");
					sbufXML.append("	\n");
				}
				
				sbufXML.append("	<TR BGCOLOR='255,255,255' MERGE='TRUE'>\n");
				sbufXML.append("		<TD DATA-ALIGN='daLeft' EDIT='false'><![CDATA[").append(vos.get(i).getColumnValues().get("group_title")).append("]]></TD>\n");
				for (int j = 0; j < 23; j++) {
					sbufXML.append("		<TD><![CDATA[").append(vos.get(i).getColumnValues().get("group_title")).append("]]></TD>\n");
				}
				
				sbufXML.append("	</TR>\n");
				sbufXML.append("	\n");
			}

			sbufXML.append("	<TR BGCOLOR='232,231,236' MERGE='FALSE'>\n");

			sbufXML.append("		<TD DATA-TYPE='dtCheckBox' EDIT='TRUE' BGCOLOR='255,255,255'><![CDATA[]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("seq_no")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("bkg_no")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("bl_no")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("group_pol_pod")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("por_cd")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("pol_cd")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("pol_yd_cd")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("pod_cd")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("pod_yd_cd")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("del_cd")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("del_yd_cd")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("rd_cd1")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("rd_cd2")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("sh_nm")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("cnee_nm")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("cntr_no")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("cntr_seal_no")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("pkg1")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("pkg2")) .append("]]></TD>\n");
			sbufXML.append("		<TD EDIT='TRUE' BGCOLOR='255,255,255'><![CDATA[").append(colValues.get("wgt1")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("wgt2")) .append("]]></TD>\n");
			sbufXML.append("		<TD EDIT='TRUE' BGCOLOR='255,255,255'><![CDATA[").append(colValues.get("tare_wgt")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("wgt2")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("total_wgt")) .append("]]></TD>\n");
			
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("wgt2")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("nf_cust_cnt")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("nf_cust_nm")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("nf_cust_addr")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("cntr_pck")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("cntr_wgt")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("cntr_mf_seq")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("cargo_pck")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("cargo_wgt")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("cargo_desc")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("bl_cmdt_cd")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("bl_cmdt_nm")) .append("]]></TD>\n");
			
			
			sbufXML.append("		<TD DATA-TYPE='dtHiddenStatus'><![CDATA[]]></TD>\n");
			sbufXML.append("	</TR>\n");
			sbufXML.append("	\n");
	
			if(i == realCnt -1){
				sbufXML.append("	<TR BGCOLOR='247,225,236' MERGE='TRUE'>\n");
				sbufXML.append("		<TD DATA-ALIGN='daLeft' BOLD='true'  EDIT='false'><![CDATA[").append(vos.get(i).getColumnValues().get("group_total")).append("]]></TD>\n");
				
				for (int j = 0; j < 23; j++) {
					sbufXML.append("		<TD  EDIT='false'><![CDATA[").append(vos.get(i).getColumnValues().get("group_total")).append("]]></TD>\n");
				}
				
				sbufXML.append("	</TR>\n");
				sbufXML.append("	\n");
			}

			
			groupingCd = tempGroupingCd;
		}
		
		sbufXML.append(sbufXMLTotal.toString());
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
		}catch(Exception ex){
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
