/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0410ViewAdapter.java
*@FileTitle : General Cargo Manifest by VVD/PORT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.25 김경섭
* 1.0 Creation
* 2012.02.13 정선용 [CHM-201216202] DPCS B/L Perf. by Volume-I (by Region-User Group) 기능 보완 요청
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
 * @author Kim Gyoung Sub
 * @see ViewAdapter 참조
 * @since J2EE 1.6
 */
public class EsmBkg0432ViewAdapter extends ViewAdapter{

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
		//String[] realColNms=getColHeader(vo);
		//String[] changedColNms = getChangedColNms(realColNms, prefix);
		
		if(vo.getMaxRows()>0){
			totCnt = vo.getMaxRows();
		}
		//String groupingCd     = ""; //새로운 행을 만들기 위한 기준코드
		//String tempGroupingCd = "";//새로운 행을 만들기 위한 기준코드 템프
		String srStsCd = "";
		sbufXML.append("\n<DATA TOTAL='").append(totCnt).append("'>\n");
		Map<String, String> colValues = null;
		
		//String total_40t = ""; 
		//String total_20t = ""; 

		String SumStaff = "";
		String SumSi ="";
		String TotAvgPoint ="";
		String TotElapsedDD ="";
		String TotElapsedHH ="";
		String TotElapsedMM ="";
		String TotElapsedSS ="";
		String TotAvgElapsedDD ="";
		String TotAvgElapsedHH ="";
		String TotAvgElapsedMM ="";
		String TotAvgElapsedSS ="";		
//		String SumBkg ="";
//		String SumOriESi ="";
//		String SumOriFSi ="";
//		String SumOriMSi ="";
			
		if(realCnt>0){
			colValues = vos.get(0).getColumnValues();
		}
		
		
		StringBuilder sbufXMLTotal = new StringBuilder();
		for(int i=0;i<realCnt;i++){
			colValues = vos.get(i).getColumnValues();
			//tempGroupingCd =colValues.get("queue") + colValues.get("pic");
			
			SumStaff = colValues.get("sum_staff");
			SumSi =colValues.get("sum_si");
			TotAvgPoint =colValues.get("tot_avg_point");
			TotElapsedDD =colValues.get("tot_elapsed_dd");
			TotElapsedHH =colValues.get("tot_elapsed_hh");
			TotElapsedMM =colValues.get("tot_elapsed_mm");
			TotElapsedSS =colValues.get("tot_elapsed_ss");
			TotAvgElapsedDD =colValues.get("tot_avg_elapsed_dd");
			TotAvgElapsedHH =colValues.get("tot_avg_elapsed_hh");
			TotAvgElapsedMM =colValues.get("tot_avg_elapsed_mm");
			TotAvgElapsedSS =colValues.get("tot_avg_elapsed_ss");			
//			SumBkg =colValues.get("sum_bkg");
//			SumOriESi =colValues.get("sum_ori_e_si");
//			SumOriFSi =colValues.get("sum_ori_f_si");
//			SumOriMSi =colValues.get("sum_ori_m_si");
			
			sbufXML.append("	<TR BGCOLOR='255,255,255' MERGE='FALSE'>\n");
			//이전 Queue, Pic 와 현재 데이타의 값이 틀리면 칼럼 값을 출력한다.
//			sbufXML.append("		<TD><![CDATA[]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("region_d")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("group_d"))  .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("tot_staff")).append("]]></TD>\n");//pic
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("tot_his_cnt")).append("]]></TD>\n");//pic


			sbufXML.append("		<TD><![CDATA[").append(colValues.get("tot_si_cnt")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("tot_bkg_cnt")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("tot_hbl_cnt")) .append("]]></TD>\n");
			
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("tot_ori_edi_cnt")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("tot_ori_mail_cnt")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("tot_ori_fax_cnt")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("tot_ori_sen_cnt")) .append("]]></TD>\n");
			
			srStsCd = colValues.get("sr_sts_cd");
			if ("AD".equals(srStsCd)) {
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("tot_amd_ad_cnt")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("tot_hbl_in_ad_cnt")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("tot_aes_ad_cnt")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("tot_bl_cfm_cnt_ad_cnt")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("tot_addi_cnt_ad_cnt")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("total_a_point")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("avg_point_qa")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("tot_qa_elapsed")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("tot_time_dd")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("tot_time_hh")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("tot_time_mm")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("tot_time_ss")) .append("]]></TD>\n");
				
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("avg_time_qa")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("avg_time_dd")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("avg_time_hh")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("avg_time_mm")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("avg_time_ss")) .append("]]></TD>\n");
				
			}
			if ("ID".equals(srStsCd)) {
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("tot_amd_id_cnt")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("tot_hbl_in_id_cnt")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("tot_aes_id_cnt")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("tot_bl_cfm_cnt_id_cnt")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("tot_addi_cnt_id_cnt")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("total_i_point")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("avg_point_id")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("tot_input_elapsed")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("tot_time_dd")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("tot_time_hh")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("tot_time_mm")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("tot_time_ss")) .append("]]></TD>\n");				
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("avg_time_in")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("avg_time_dd")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("avg_time_hh")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("avg_time_mm")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("avg_time_ss")) .append("]]></TD>\n");				
				
			}
			if ("RD".equals(srStsCd)) {
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("tot_amd_rd_cnt")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("tot_hbl_in_rd_cnt")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("tot_aes_rd_cnt")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("tot_bl_cfm_cnt_rd_cnt")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("tot_addi_cnt_rd_cnt")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("total_r_point")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("avg_point_ra")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("tot_rate_elapsed")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("tot_time_dd")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("tot_time_hh")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("tot_time_mm")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("tot_time_ss")) .append("]]></TD>\n");					
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("avg_time_ra")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("avg_time_dd")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("avg_time_hh")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("avg_time_mm")) .append("]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("avg_time_ss")) .append("]]></TD>\n");				
				
			}
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("region")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("sr_sts_cd")) .append("]]></TD>\n");
 
			
			sbufXML.append("	</TR>\n");
			sbufXML.append("	\n");

			
//			groupingCd = tempGroupingCd;
		}
		
		sbufXML.append("</DATA>\n");
		sbufXML.append("<ETC-DATA>");
		sbufXML.append("		<ETC KEY='sum_staff'><![CDATA[").append(SumStaff).append("]]></ETC>\n");   
		sbufXML.append("		<ETC KEY='sum_si'><![CDATA[").append(SumSi).append("]]></ETC>\n");  
		sbufXML.append("		<ETC KEY='tot_avg_point'><![CDATA[").append(TotAvgPoint).append("]]></ETC>\n");  
		sbufXML.append("		<ETC KEY='tot_elapsed_dd'><![CDATA[").append(TotElapsedDD).append("]]></ETC>\n");  
		sbufXML.append("		<ETC KEY='tot_elapsed_hh'><![CDATA[").append(TotElapsedHH).append("]]></ETC>\n");  
		sbufXML.append("		<ETC KEY='tot_elapsed_mm'><![CDATA[").append(TotElapsedMM).append("]]></ETC>\n");  
		sbufXML.append("		<ETC KEY='tot_elapsed_ss'><![CDATA[").append(TotElapsedSS).append("]]></ETC>\n");  
		sbufXML.append("		<ETC KEY='tot_avg_elapsed_dd'><![CDATA[").append(TotAvgElapsedDD).append("]]></ETC>\n");  
		sbufXML.append("		<ETC KEY='tot_avg_elapsed_hh'><![CDATA[").append(TotAvgElapsedHH).append("]]></ETC>\n");  
		sbufXML.append("		<ETC KEY='tot_avg_elapsed_mm'><![CDATA[").append(TotAvgElapsedMM).append("]]></ETC>\n");  
		sbufXML.append("		<ETC KEY='tot_avg_elapsed_ss'><![CDATA[").append(TotAvgElapsedSS).append("]]></ETC>\n");  		
		
		sbufXML.append("</ETC-DATA>");
//		sbufXML.append("</SHEET>\n");		
		
		
//		sbufXML.append("	<TR BGCOLOR='128,128,0' MERGE='FALSE'>\n");
//		//이전 Queue, Pic 와 현재 데이타의 값이 틀리면 칼럼 값을 출력한다.
//		sbufXML.append("		<TD><![CDATA[TOTAL]]></TD>\n");
//		sbufXML.append("		<TD><![CDATA[All]]></TD>\n");
//		sbufXML.append("		<TD><![CDATA[").append(SumStaff).append("]]></TD>\n");//pic
//
//
//		sbufXML.append("		<TD><![CDATA[").append(SumSi) .append("]]></TD>\n");
//		sbufXML.append("		<TD><![CDATA[").append(SumBkg) .append("]]></TD>\n");
//		sbufXML.append("		<TD><![CDATA[]]></TD>\n");
//		
//		sbufXML.append("		<TD><![CDATA[").append(SumOriESi) .append("]]></TD>\n");
//		sbufXML.append("		<TD><![CDATA[").append(SumOriMSi) .append("]]></TD>\n");
//		sbufXML.append("		<TD><![CDATA[").append(SumOriFSi) .append("]]></TD>\n");
//		
//		sbufXML.append("		<TD><![CDATA[]]></TD>\n");
//		sbufXML.append("		<TD><![CDATA[]]></TD>\n");
//		sbufXML.append("		<TD><![CDATA[]]></TD>\n");
//		sbufXML.append("		<TD><![CDATA[]]></TD>\n");
//		sbufXML.append("		<TD><![CDATA[]]></TD>\n");
//		sbufXML.append("		<TD><![CDATA[]]></TD>\n");
//		sbufXML.append("		<TD><![CDATA[]]></TD>\n");
//		sbufXML.append("		<TD><![CDATA[]]></TD>\n");
//
//		sbufXML.append("		<TD><![CDATA[]]></TD>\n");
//		sbufXML.append("		<TD><![CDATA[]]></TD>\n");
//
//		
//		sbufXML.append("	</TR>\n");
//		sbufXML.append("	\n");
		
		sbufXML.append(sbufXMLTotal.toString());
//		sbufXML.append("</DATA>\n"); 
		
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
