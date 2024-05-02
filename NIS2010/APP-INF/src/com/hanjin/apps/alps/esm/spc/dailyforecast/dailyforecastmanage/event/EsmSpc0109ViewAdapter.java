/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0109ViewAdapter.java
*@FileTitle : Daily Forecast Input
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2014.02.04 [CHM-201428383-01] RFA 로직 추가
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.event;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchContractForecastManageListVO;
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
public class EsmSpc0109ViewAdapter extends ViewAdapter {

	
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
		
		// 조회된 전체 Count 를  화면에 맞게 주차별로 변경후 화면에 보이는 실제 Row 수( TTL 의 개수 )
		totCnt = Integer.parseInt(nullToZero(getNull(vos.get(0).getColumnValues().get("tot_cnt"))));
		
		String[] weeks = new String[30];
		String[] vvds  = new String[30];
		
		int week_cnt     = 0;
		int titleRows    = 3;
		int vvd_cnt      = 0;
		int lvl          = 0;
		int rnum         = 0;
		int colCount     = 38;
		int infoColCount = 20;
		int color_num    = 0;
		
		int rowNum  = titleRows;
		int rowCust = titleRows;
		
		boolean isEditable = true;
		
		String vsl_cd         = "";
		String sls_rgn_ofc_cd = "";
		
		int treeLvl = 0;
		String[] colors = { "225,244,226", "235,240,255", "255,255,128", "240,240,240" };
		
		sbufXML.append("<DATA TOTAL='" + totCnt + "'>\n");
		
		for(int i=0;i<realCnt;i++){
			Map<String, String> colValues = vos.get(i).getColumnValues();				
			
			lvl  = Integer.parseInt(nullToZero(getNull(colValues.get("lvl"))));
			rnum = Integer.parseInt(nullToZero(getNull(colValues.get("rnum"))));
			
			isEditable = true;
			color_num  = lvl;
			
			sls_rgn_ofc_cd = getNull(colValues.get("sls_rgn_ofc_cd"));
			
			vsl_cd = getNull(colValues.get("vsl_cd"));
			if(vsl_cd == null) vsl_cd = "";
			
			String vvd = vsl_cd + getNull(colValues.get("skd_voy_no")) + getNull(colValues.get("dir_cd"));
			vvd = vvd.trim();
			weeks[rnum-1] = getNull(colValues.get("cost_wk"));
			vvds[rnum-1]  = vvd;
			
			week_cnt = (week_cnt < rnum) ? rnum : week_cnt;
			
			if(vvd_cnt == 0){
				String rowMerge = lvl <= 0? "TRUE":"FALSE";
				treeLvl = ((lvl==1 && sls_rgn_ofc_cd.equals("")) || lvl > 1)?lvl+1:lvl;
				
				sbufXML.append("<TR MERGE='" + rowMerge + "' LEVEL='" + lvl + "'>");
				sbufXML.append("	<TD>" + getNull(colValues.get("srep_cd")) + "</TD>");
				sbufXML.append("	<TD><![CDATA[" + getNull(colValues.get("srep_nm")) + "]]></TD>");
				sbufXML.append("	<TD INDENT='1'><![CDATA[" + getNull(colValues.get("cust_tp")) + "]]></TD>");
				
				sbufXML.append("	<TD INDENT='1'>" + getNull(colValues.get("cust_cnt_cd")) + getNull(colValues.get("cust_seq")) + "</TD>");
				sbufXML.append("	<TD INDENT='1'><![CDATA[" + getNull(colValues.get("cust_nm")) + "]]></TD>");
				sbufXML.append("	<TD INDENT='1'>" + getNull(colValues.get("sc_no"))        + "</TD>");
				sbufXML.append("	<TD INDENT='1'>" + getNull(colValues.get("rfa_no"))       + "</TD>");
				sbufXML.append("	<TD INDENT='1'>" + getNull(colValues.get("cust_ctrl_cd")) + "</TD>");
				
				sbufXML.append("	<TD>" + getNull(colValues.get("sls_rhq_cd"))     + "</TD>");
				sbufXML.append("	<TD>" + getNull(colValues.get("sls_rgn_ofc_cd")) + "</TD>");
				sbufXML.append("	<TD INDENT='1'>" + getNull(colValues.get("rlane_cd"))  + "</TD>");
				sbufXML.append("	<TD INDENT='1'>" + getNull(colValues.get("guide_qty")) + "</TD>");
				sbufXML.append("	<TD INDENT='1'>" + getNull(colValues.get("fcast_seq"))    + "</TD>");
				sbufXML.append("	<TD></TD>");	// POL
				sbufXML.append("	<TD></TD>");	// POD
			}
			
			vvd_cnt = vvd_cnt + 1;
			
			for(; vvd_cnt < rnum ; vvd_cnt++){
				sbufXML.append("	<TD></TD>");	
				sbufXML.append("	<TD></TD>");
				sbufXML.append("	<TD>" + vvds[vvd_cnt-1] + "</TD>");
				
				for(int t = 3 ; t < infoColCount ; t++){
					sbufXML.append("	<TD>0</TD>");
				}
				
				sbufXML.append("	<TD BGCOLOR='" + colors[1] + "'></TD>");	// VVD 부분
				sbufXML.append("	<TD BGCOLOR='" + colors[1] + "'></TD>");	// Total TEU 부분
				sbufXML.append("	<TD BGCOLOR='" + colors[1] + "'></TD>");	// TEU 부분
				
				for(int t = infoColCount + 2 ; t < infoColCount + 9 ; t++){
					sbufXML.append("	<TD>0</TD>");
				}
				
				sbufXML.append("	<TD></TD>");									// Remark
				sbufXML.append("	<TD BGCOLOR='" + colors[1] + "'>0</TD>");		// Loading Total TEU 부분
				
				for(int t = infoColCount + 11 ; t < colCount ; t++){
					sbufXML.append("	<TD>0</TD>");
					
				}
			}
			
			if(vsl_cd.equals("TTL")){
				isEditable = false;
				
				if(lvl != 1) color_num++;
			}
			
			sbufXML.append("	<TD>" + getNull(colValues.get("trd_cd"))     + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("sub_trd_cd")) + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("rlane_cd"))   + "</TD>");
			sbufXML.append("	<TD>" + vsl_cd + "</TD>");	
			sbufXML.append("	<TD>" + getNull(colValues.get("skd_voy_no")).trim() + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("dir_cd")).trim()     + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("ioc_ts_cd"))         + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("srep_cd"))           + "</TD>");				
			sbufXML.append("	<TD>" + getNull(colValues.get("ctrt_ofc_cd"))       + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("cust_cnt_cd"))       + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("cust_seq"))          + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("sls_rgn_ofc_cd"))    + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("pol_cd"))            + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("pod_cd"))            + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("fcast_seq"))         + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("sc_no"))             + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("sc_flg"))            + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("rfa_no"))            + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("cust_ctrl_cd"))      + "</TD>");
			sbufXML.append("	<TD>" + (!getNull(colValues.get("fcast_cnt")).equals("0")?"R":"") + "</TD>");
			
			sbufXML.append("	<TD BGCOLOR='" + colors[1] + "'>" + vvd + "</TD>");
			sbufXML.append("	<TD BGCOLOR='" + colors[1] + "'>" + nullToZero(getNull(colValues.get("fcast_ttl_qty"))) + "</TD>");
			sbufXML.append("	<TD BGCOLOR='" + colors[1] + "'></TD>");
			
			sbufXML.append("	<TD EDIT='" + isEditable + "' BGCOLOR='" + colors[color_num] + "'>" + Double.valueOf(nullToZero(getNull(colValues.get("fcast_20ft_qty")))).doubleValue() + "</TD>");
			sbufXML.append("	<TD EDIT='" + isEditable + "' BGCOLOR='" + colors[color_num] + "'>" + Double.valueOf(nullToZero(getNull(colValues.get("fcast_40ft_qty")))).doubleValue() + "</TD>");
			sbufXML.append("	<TD EDIT='" + isEditable + "' BGCOLOR='" + colors[color_num] + "'>" + nullToZero(getNull(colValues.get("fcast_40ft_hc_qty"))) + "</TD>");
			sbufXML.append("	<TD EDIT='" + isEditable + "' BGCOLOR='" + colors[color_num] + "'>" + nullToZero(getNull(colValues.get("fcast_45ft_hc_qty"))) + "</TD>");
			sbufXML.append("	<TD EDIT='" + isEditable + "' BGCOLOR='" + colors[color_num] + "'>" + nullToZero(getNull(colValues.get("fcast_53ft_qty")))    + "</TD>");
			sbufXML.append("	<TD EDIT='" + isEditable + "' BGCOLOR='" + colors[color_num] + "'>" + nullToZero(getNull(colValues.get("fcast_rf_qty")))      + "</TD>");
			sbufXML.append("	<TD EDIT='" + isEditable + "' BGCOLOR='" + colors[color_num] + "'>" + nullToZero(getNull(colValues.get("fcast_ttl_wgt")))     + "</TD>");
			sbufXML.append("	<TD BGCOLOR='" + colors[color_num] + "'><![CDATA[" + getNull(colValues.get("fcast_rmk"))            + "]]></TD>");
			
			sbufXML.append("	<TD BGCOLOR='" + colors[1] + "'>" + nullToZero(getNull(colValues.get("lfcast_ttl_qty")))     + "</TD>");
			sbufXML.append("	<TD BGCOLOR='" + colors[1] + "'>" + nullToZero(getNull(colValues.get("lfcast_20ft_qty")))    + "</TD>");
			sbufXML.append("	<TD BGCOLOR='" + colors[1] + "'>" + nullToZero(getNull(colValues.get("lfcast_40ft_qty")))    + "</TD>");
			sbufXML.append("	<TD BGCOLOR='" + colors[1] + "'>" + nullToZero(getNull(colValues.get("lfcast_40ft_hc_qty"))) + "</TD>");
			sbufXML.append("	<TD BGCOLOR='" + colors[1] + "'>" + nullToZero(getNull(colValues.get("lfcast_45ft_hc_qty"))) + "</TD>");
			sbufXML.append("	<TD BGCOLOR='" + colors[1] + "'>" + nullToZero(getNull(colValues.get("lfcast_53ft_qty")))    + "</TD>");
			sbufXML.append("	<TD BGCOLOR='" + colors[1] + "'>" + nullToZero(getNull(colValues.get("lfcast_rf_qty")))      + "</TD>");
			sbufXML.append("	<TD BGCOLOR='" + colors[1] + "'>" + nullToZero(getNull(colValues.get("lfcast_ttl_wgt")))     + "</TD>");
			
			if(getNull(colValues.get("cost_wk")).equals("TTL")){
				vvd_cnt = 0;
				switch(treeLvl){
				case 2:
					rowCust = rowNum;
					break;
				}
				
				sbufXML.append("	<TD>" + treeLvl + "</TD>");
				sbufXML.append("	<TD></TD>");
				sbufXML.append("	<TD>" + rowCust + "</TD>");
				sbufXML.append("	<TD>" + getNull(colValues.get("sc_flg"))       + "</TD>");
				sbufXML.append("</TR>\n");
				
				rowNum = rowNum + 1;
			}			
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
		if(str == null || str.equals(""))
			str = "0";
		return str;
	}
	
	protected String getETCData(EventResponse eventResponse) {
		if(eventResponse==null) 
			return "";
		
		List<Object> vos = eventResponse.getRsVoList();
		int realCnt = vos.size();
		
		String[] weeks = new String[30];
		int week_cnt   = 0;
		int rnum       = 0;
		
		for(int i=0;i<realCnt;i++){
			SearchContractForecastManageListVO vo = (SearchContractForecastManageListVO)vos.get(i);
			Map<String, String> colValues = vo.getColumnValues();
			
			rnum = Integer.parseInt(nullToZero(getNull(colValues.get("rnum"))));
			
			weeks[rnum-1] = getNull(colValues.get("cost_wk"));
			
			week_cnt = week_cnt < rnum ? rnum : week_cnt;
		}
		
		String yrwk = "";
		
		for(int i = 0 ; i < week_cnt ; i++){
			yrwk = yrwk + "|" + weeks[i];
		}
		
		StringBuilder sb = new StringBuilder();
		
		try{
			
			sb.append("<ETC-DATA>\n");
			sb.append("    <ETC KEY='status'>OK</ETC>\n");
			sb.append("    <ETC KEY='week'>" + yrwk + "</ETC>\n");
			sb.append("</ETC-DATA>\n");
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}
		return sb.toString();
	} 

}