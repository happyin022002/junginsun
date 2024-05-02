/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EesDod0005ViewAdapter.java
*@FileTitle : EesDod0005ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.06
*@LastModifier : Yoon, Yong-Sang
*@LastVersion : 1.0
* 2015.11.06 YOON, Yong-Sang	1.0	최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodtariff.dropofftariff.event;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;

/**
 * EES_DOD_0005 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DOD_0005HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author YOON, Yong-Sang 
 * @see EES_DOD_0005HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesDod0005ViewAdapter extends ViewAdapter {
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param List<AbstractValueObject> vos
	 * @param String prefix
	 * @return String
	 */
	public String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		StringBuilder sbufXML = new StringBuilder();
		
		int totCnt = vos.size();
		int realCnt = vos.size();

		AbstractValueObject vo = (AbstractValueObject)vos.get(0);

		if(vo.getMaxRows()>0){
			totCnt = vo.getMaxRows();
		} 
		
		Map<String, String> colValues = null;
		
		if(realCnt>0){
			colValues = vos.get(0).getColumnValues();
		}
				
		//TOTAL 개수 조정
		sbufXML.append("<DATA TOTAL='").append(totCnt).append("'>\n");
		
		for(int j = 0 ; j < realCnt ; j++){
			
			colValues = vos.get(j).getColumnValues();

			sbufXML.append("<TR>\n");
			sbufXML.append("	<TD></TD>\n");
			sbufXML.append("	<TD>R</TD>\n");
			
//			if ( now_tpb_no.length() > 0 ) {
//				sbufXML.append("<TD><![CDATA[").append(grp_srt_no).append("]]></TD>\n");
//				sbufXML.append("<TD><![CDATA[").append(grp_srt_no).append("]]></TD>\n");
//			} else {
//				sbufXML.append("<TD EDIT='false'></TD>\n");
//				sbufXML.append("<TD EDIT='false'></TD>\n");
//			}
			
			String cfmFlg = colValues.get("drp_off_chg_trf_cfm_flg");
			String expFlg = colValues.get("drp_off_chg_trf_exp_flg");
			String chgFlg = colValues.get("chg_cnt");
			String tdAttr = "";
			if("C".equals(cfmFlg) || "Y".equals(expFlg) || "0".equals(chgFlg) ){
				tdAttr = " EDIT=\"FALSE\"";
			}
			
//			sbufXML.append("	<TD").append(tdAttr).append("><![CDATA[").append(JSPUtil.getNull(colValues.get("ibflag"))).append("]]></TD>\n");
//			sbufXML.append("	<TD").append(tdAttr).append("><![CDATA[").append(JSPUtil.getNull(colValues.get(""))).append("]]></TD>\n");
			sbufXML.append("	<TD><![CDATA[").append(JSPUtil.getNull(colValues.get(""))).append("]]></TD>\n");
			sbufXML.append("	<TD").append(tdAttr).append("><![CDATA[").append(JSPUtil.getNull(colValues.get("drp_off_chg_trf_seq"))).append("]]></TD>\n");  
			sbufXML.append("	<TD").append(tdAttr).append("><![CDATA[").append(JSPUtil.getNull(colValues.get("drp_off_chg_trf_eff_dt"))).append("]]></TD>\n");   
			sbufXML.append("	<TD").append(tdAttr).append("><![CDATA[").append(JSPUtil.getNull(colValues.get("drp_off_chg_trf_exp_dt"))).append("]]></TD>\n");  
			sbufXML.append("	<TD").append(tdAttr).append("><![CDATA[").append(JSPUtil.getNull(colValues.get("drp_off_chg_trf_exp_flg"))).append("]]></TD>\n");    
			sbufXML.append("	<TD").append(tdAttr).append("><![CDATA[").append(JSPUtil.getNull(colValues.get("drp_off_chg_trf_cnt_cd"))).append("]]></TD>\n");     
			sbufXML.append("	<TD").append(tdAttr).append("><![CDATA[").append(JSPUtil.getNull(colValues.get("del_cd"))).append("]]></TD>\n");   
			sbufXML.append("	<TD").append(tdAttr).append("><![CDATA[").append(JSPUtil.getNull(colValues.get("cntr_rtn_loc_cd"))).append("]]></TD>\n");
			sbufXML.append("	<TD").append(tdAttr).append("><![CDATA[").append(JSPUtil.getNull(colValues.get("cntr_rtn_yd_sfx_cd"))).append("]]></TD>\n"); 
			sbufXML.append("	<TD").append(tdAttr).append("><![CDATA[").append(JSPUtil.getNull(colValues.get("pol_conti_cd"))).append("]]></TD>\n");  
			sbufXML.append("	<TD").append(tdAttr).append("><![CDATA[").append(JSPUtil.getNull(colValues.get("cntr_tpsz_cd"))).append("]]></TD>\n");
			if("sheet2_".equals(prefix)){
				sbufXML.append("	<TD").append(tdAttr).append("><![CDATA[").append(JSPUtil.getNull(colValues.get("rfa_no"))).append("]]></TD>\n");   
				sbufXML.append("	<TD").append(tdAttr).append("><![CDATA[").append(JSPUtil.getNull(colValues.get("sc_no"))).append("]]></TD>\n");
				sbufXML.append("	<TD").append(tdAttr).append("><![CDATA[").append(JSPUtil.getNull(colValues.get("cust_nm"))).append("]]></TD>\n");
				sbufXML.append("	<TD").append(tdAttr).append("><![CDATA[").append(JSPUtil.getNull(colValues.get("spcl_cust_nm"))).append("]]></TD>\n");
				sbufXML.append("	<TD").append(tdAttr).append("><![CDATA[").append(JSPUtil.getNull(colValues.get("spcl_cust_cnt_seq"))).append("]]></TD>\n");   
			} else {
				sbufXML.append("	<TD").append(tdAttr).append("><![CDATA[").append(JSPUtil.getNull(colValues.get("curr_cd"))).append("]]></TD>\n");   
				sbufXML.append("	<TD").append(tdAttr).append("><![CDATA[").append(JSPUtil.getNull(colValues.get("drp_off_chg_trf_amt"))).append("]]></TD>\n");
			}			  
			sbufXML.append("	<TD").append(tdAttr).append("><![CDATA[").append(JSPUtil.getNull(colValues.get("drp_off_chg_trf_expt_flg"))).append("]]></TD>\n");
			if("sheet2_".equals(prefix)){
				sbufXML.append("	<TD").append(tdAttr).append("><![CDATA[").append(JSPUtil.getNull(colValues.get("curr_cd"))).append("]]></TD>\n");   
				sbufXML.append("	<TD").append(tdAttr).append("><![CDATA[").append(JSPUtil.getNull(colValues.get("drp_off_chg_trf_amt"))).append("]]></TD>\n");
			}
			sbufXML.append("	<TD").append(tdAttr).append("><![CDATA[").append(JSPUtil.getNull(colValues.get("upd_usr_id"))).append("]]></TD>\n");  
			sbufXML.append("	<TD").append(tdAttr).append("><![CDATA[").append(JSPUtil.getNull(colValues.get("upd_dt"))).append("]]></TD>\n");  
			sbufXML.append("	<TD").append(tdAttr).append("><![CDATA[").append(JSPUtil.getNull(colValues.get("drp_off_chg_trf_cfm_usr_id"))).append("]]></TD>\n");  
			sbufXML.append("	<TD").append(tdAttr).append("><![CDATA[").append(JSPUtil.getNull(colValues.get("drp_off_chg_trf_cfm_dt"))).append("]]></TD>\n");  
			sbufXML.append("	<TD").append(tdAttr).append("><![CDATA[").append(JSPUtil.getNull(colValues.get("drp_off_chg_trf_cfm_flg"))).append("]]></TD>\n");
			sbufXML.append("	<TD").append(tdAttr).append("><![CDATA[").append(JSPUtil.getNull(colValues.get("atch_file_lnk_cnt"))).append("]]></TD>\n");
			sbufXML.append("	<TD").append(tdAttr).append("><![CDATA[").append(JSPUtil.getNull(colValues.get("drp_off_chg_trf_rmk"))).append("]]></TD>\n");
			sbufXML.append("	<TD").append(tdAttr).append("><![CDATA[").append(JSPUtil.getNull(colValues.get("drp_off_chg_trf_div_cd"))).append("]]></TD>\n");
			sbufXML.append("	<TD").append(tdAttr).append("><![CDATA[").append(JSPUtil.getNull(colValues.get("chg_cnt"))).append("]]></TD>\n");

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
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new RuntimeException(se.getMessage());
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
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new RuntimeException(se.getMessage());
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