/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0568ViewAdapter.java
*@FileTitle : C/A Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.09.22 강동윤
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
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author kang dong yun
 * @see ViewAdapter 참조
 * @since J2EE 1.6
 */
public class EsmBkg0568ViewAdapter extends ViewAdapter{

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
		String[] realColNms=getColHeader(vo);
		String[] changedColNms = getChangedColNms(realColNms, prefix);
		
		if(vo.getMaxRows()>0){
			totCnt = vo.getMaxRows();
		}
		
		String nowVVD 	= "";
		String befVVD 	= "";

		int seqIdx = 1;
		
		Map<String, String> tempColValues = vos.get(0).getColumnValues();			
		
		if(tempColValues.get("vvd") != null){
			
			sbufXML.append("\n<DATA TOTAL='"); sbufXML.append(totCnt); sbufXML.append("'>\n");
				
			for(int i = 0 ; i < realCnt ; i++){
				
				Map<String, String> nowColValues = vos.get(i).getColumnValues();
				
				nowVVD = JSPUtil.getNull(nowColValues.get("vvd"));
				
				if (i != 0){
					
					Map<String, String> befColValues = vos.get(i-1).getColumnValues(); 
					
					befVVD = JSPUtil.getNull(befColValues.get("vvd"));
				}
				
				if (!befVVD.equals(nowVVD)){		//그룹구분
					
					//seqIdx = 1;
					
					sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");
						
					//sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
					sbufXML.append("  <TD DATA-ALIGN=\"daLeft\" BOLD=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd"));  sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD ><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd"));  sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD ><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd"));  sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD ><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd"));  sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD ><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd"));  sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD ><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd"));  sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD ><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd"));  sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD ><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd"));  sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD ><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd"));  sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD ><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd"));  sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD ><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd"));  sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD ><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd"));  sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD ><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd"));  sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD ><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd"));  sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD ><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd"));  sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD ><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd"));  sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD ><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd"));  sbufXML.append("]]></TD>\n");					
					sbufXML.append("  <TD ><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd"));  sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD ><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd"));  sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD ><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd"));  sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD ><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd"));  sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD ><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd"));  sbufXML.append("]]></TD>\n");		
					sbufXML.append("  <TD><![CDATA[G]]></TD>\n");
					sbufXML.append("  <TD>R</TD>\n");
					//sbufXML.append("  <TD DATA-ALIGN=\"daLeft\" BOLD=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd"));  sbufXML.append("]]></TD>\n");
					
					sbufXML.append("</TR>\n"); 

				}
				
				sbufXML.append(" <TR MERGE=\"false\">\n");
				
				//sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
				sbufXML.append("  <TD DATA-TYPE=\"dtCheckBox\"><![CDATA[0]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(Integer.toString(seqIdx++)); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("bl_no"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("usa_cstms_file_cd"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("bkg_no"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("vps_eta_dt"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("corr_no"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("corr_dt"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("corr_ofc_cd"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("ca_rsn_cd"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("ca_rsn_nm"))); sbufXML.append("]]></TD>\n");				
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("kind_a"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("kind_b"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("kind_c"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("kind_d"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("kind_e"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("kind_f"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("kind_g"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("kind_h"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("kind_i"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("kind_j"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("kind_k"))); sbufXML.append("]]></TD>\n");												
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("bkg_corr_rmk"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("vvd"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("pol_cd"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("pod_cd"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("bl_tp_cd"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA[C]]></TD>\n");
				sbufXML.append("  <TD>R</TD>\n");
				
				sbufXML.append(" </TR>\n");
				
			}//for

			sbufXML.append("</DATA>\n");
		}else{

			sbufXML.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' COLSEPARATOR='").append("\u261C\u261E").append("' TOTAL='").append(totCnt).append("'>\n").toString());
	        for(int i = 0; i < realCnt; i++)
	        {
	            Map<String,String> colValues = ((AbstractValueObject)vos.get(i)).getColumnValues();
	            sbufXML.append("\t<TR><![CDATA[");
	            int colCnt = realColNms.length;
	            for(int j = 0; j < colCnt - 1; j++)
	                sbufXML.append((new StringBuilder(String.valueOf(getNull((String)colValues.get(realColNms[j]))))).append("\u261C\u261E").toString());

	            sbufXML.append((new StringBuilder(String.valueOf(getNull((String)colValues.get(realColNms[colCnt - 1]))))).append("]]></TR>\n").toString());
	        }
	        
	        sbufXML.append("</DATA>\n");
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
