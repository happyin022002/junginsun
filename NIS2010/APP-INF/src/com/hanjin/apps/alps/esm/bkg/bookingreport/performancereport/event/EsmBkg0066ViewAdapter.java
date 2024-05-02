/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0066ViewAdapter.java
*@FileTitle : 0066 B/L Processing Report 정보를 조회합니다.
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.25 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;

/**
 * EsmBkg0066ViewAdapter
 *
 * @author Kim Gyoung Sub
 * @see com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.ESM_BKG_0066HTMLAction
 * @since J2EE 1.6
 */
public class EsmBkg0066ViewAdapter extends ViewAdapter{

	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param List<AbstractValueObject> vos
	 * @param String prefix 
	 * @return String <Data>태그 부분의 XML문자열
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
		String queCDnPIC     = "";
		String tempQueCDnPIC = "";
		
		sbufXML.append("\n<DATA TOTAL='").append(totCnt).append("'>\n");
		Map<String, String> colValues = null;
		for(int i=0;i<realCnt;i++){
			colValues = vos.get(i).getColumnValues();
			tempQueCDnPIC =colValues.get("dpcs_wrk_grp_cd") + colValues.get("pic");
			
			//이전 SR NO와 현재 데이타의 값이 틀리면 제목을 새로 생성한다.
			if(i > 0 && !queCDnPIC.equals(tempQueCDnPIC)){
				sbufXML.append("	<TR BGCOLOR='229,234,255' MERGE='true'>\n");
				sbufXML.append("		<TD><![CDATA[Average Elapsed Time]]></TD>\n"); 
				sbufXML.append("		<TD><![CDATA[Average Elapsed Time]]></TD>\n"); 
				sbufXML.append("		<TD><![CDATA[Average Elapsed Time]]></TD>\n"); 
				sbufXML.append("		<TD><![CDATA[Average Elapsed Time]]></TD>\n"); 
				sbufXML.append("		<TD><![CDATA[Average Elapsed Time]]></TD>\n"); 
				sbufXML.append("		<TD><![CDATA[Average Elapsed Time]]></TD>\n"); 
				sbufXML.append("		<TD><![CDATA[Average Elapsed Time]]></TD>\n"); 
				sbufXML.append("		<TD><![CDATA[Average Elapsed Time]]></TD>\n"); 
				sbufXML.append("		<TD><![CDATA[").append(vos.get(i-1).getColumnValues().get("avg_elapsed_time_hh")) .append(":")
													   .append(vos.get(i-1).getColumnValues().get("avg_elapsed_time_mi")) .append(":")
				                                       .append(vos.get(i-1).getColumnValues().get("avg_elapsed_time_ss")) .append("]]></TD>\n");
				sbufXML.append("	</TR>\n");
				sbufXML.append("	\n");
			}

			sbufXML.append("	<TR BGCOLOR='255,255,255'>\n");
			if(!queCDnPIC.equals(tempQueCDnPIC)){
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("seq_no"))  .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("queue"))  .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("pic"))    .append("]]></TD>\n");//pic
			}else{
				sbufXML.append("		<TD><![CDATA[]]></TD>\n"); //seq
				sbufXML.append("		<TD><![CDATA[]]></TD>\n"); //queue
				sbufXML.append("		<TD><![CDATA[]]></TD>\n"); //pic
			}
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("bkg_no")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("sr_kind")).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("vvd_cd")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("pol_cd")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("pod_cd")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("elapsed_time_hh")) .append(":")
			                                       .append(colValues.get("elapsed_time_mi")) .append(":")
			                                       .append(colValues.get("elapsed_time_ss")) .append("]]></TD>\n");
			sbufXML.append("	</TR>\n");
			sbufXML.append("	\n");
			
			if(i == realCnt -1){
				sbufXML.append("	<TR BGCOLOR='229,234,255' MERGE='true'>\n");
				sbufXML.append("		<TD><![CDATA[Average Elapsed Time]]></TD>\n"); 
				sbufXML.append("		<TD><![CDATA[Average Elapsed Time]]></TD>\n"); 
				sbufXML.append("		<TD><![CDATA[Average Elapsed Time]]></TD>\n"); 
				sbufXML.append("		<TD><![CDATA[Average Elapsed Time]]></TD>\n"); 
				sbufXML.append("		<TD><![CDATA[Average Elapsed Time]]></TD>\n"); 
				sbufXML.append("		<TD><![CDATA[Average Elapsed Time]]></TD>\n"); 
				sbufXML.append("		<TD><![CDATA[Average Elapsed Time]]></TD>\n"); 
				sbufXML.append("		<TD><![CDATA[Average Elapsed Time]]></TD>\n"); 
				sbufXML.append("		<TD><![CDATA[").append(vos.get(i).getColumnValues().get("avg_elapsed_time_hh")) .append(":")
													   .append(vos.get(i).getColumnValues().get("avg_elapsed_time_mi")) .append(":")
				                                       .append(vos.get(i).getColumnValues().get("avg_elapsed_time_ss")) .append("]]></TD>\n");
				sbufXML.append("	</TR>\n");
				sbufXML.append("	\n");
			}

			
			queCDnPIC = tempQueCDnPIC;
		}
		sbufXML.append("</DATA>\n");
		return sbufXML.toString();
	}

	/**
	 * DBRowSet를 Parsing하여 <DATA>태그를 생성한다.<br>
	 * IBSheet의 prefix값이 있는 경우 COLORDER에 prefix를 붙인 column명으로 표시해 준다.<br>
	 * 
	 * @param DBRowSet rs
	 * @param String prefix
	 * @return String IBSheet 		<DATA>태그
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
	 * @param DBRowSet rs
	 * @return String 	IBSheet 			<DATA>태그
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
