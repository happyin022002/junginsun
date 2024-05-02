/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : MnrComCustom2ViewAdapter.java
*@FileTitle : Default IBSheet Generation Class
*Open Issues : MnrAGMTHdrCombo-EES_MNR_0015GS(SEARCH02) 를 픽스하기 위한       
*Open Issues : MNR_COM_CUSTOM2GS
*Change history : 
*@LastModifyDate : 2009-11-24
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009-11-24 박명신
* 1.0 최초 생성 
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.event;

import java.util.ArrayList;
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
 * @author 박명신 
 * @see ViewAdapter 참조	
 * @since J2EE 1.5 
 */	
public class MnrComCustom2ViewAdapter extends ViewAdapter {
	
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
		//실제로 타는 makeDataTag 
		StringBuilder sbufXML = new StringBuilder();
			
		int realCnt = vos.size();   
			
		//*********************** OutPut 순서 여기서 바꿈 ******** Start
		List<String> customOutIndex = new ArrayList<String>();
		customOutIndex.add("trsm_mod_cd");
		customOutIndex.add("vndr_seq");
		customOutIndex.add("agmt_ref_no");
		customOutIndex.add("eq_type_name");
		customOutIndex.add("agmt_ofc_cty_cd");
		customOutIndex.add("agmt_dt");
		customOutIndex.add("agmt_seq");
		customOutIndex.add("agmt_rmk");
		customOutIndex.add("vndr_nm");
		customOutIndex.add("agmt_no");
		customOutIndex.add("agmt_type_tpsz");
		customOutIndex.add("pagerows");
		customOutIndex.add("agmt_ver_no");
		customOutIndex.add("eff_dt");
		customOutIndex.add("curr_cd");
		customOutIndex.add("exp_dt");
		customOutIndex.add("ibflag");
		customOutIndex.add("cre_dt");
		customOutIndex.add("upd_usr_id");
		customOutIndex.add("delt_flg");
		customOutIndex.add("agmt_prifix");
		customOutIndex.add("pay_term_dys");
		customOutIndex.add("edi_id");
		customOutIndex.add("cre_usr_id");
		customOutIndex.add("agmt_lst_ver_flg");
		customOutIndex.add("trf_no");
		customOutIndex.add("isversionup");
		customOutIndex.add("agmt_display_type");
		customOutIndex.add("eq_knd_cd");
		customOutIndex.add("mnr_meas_ut_nm");
		customOutIndex.add("agmt_ofc_cd");
		customOutIndex.add("upd_dt");     
		//*********************** OutPut 순서 여기서 바꿈 ******** End
		String[] realColNms = new String[customOutIndex.size()];
		for(int x = 0;x < customOutIndex.size();x++){
			realColNms[x] = customOutIndex.get(x);
		}				
			
		sbufXML.append("<DATA COLORDER='" + JSPUtil.convertStringArrayToString(realColNms, "|") + "' COLSEPARATOR='" + DELIMITER + "' TOTAL='" + realCnt +"'>\n");
		
		for(int i=0;i<realCnt;i++){ 
			Map<String, String> colValues = vos.get(i).getColumnValues();
				
			sbufXML.append("	<TR><![CDATA[");   
				
			for (int j = 0 ; j < realColNms.length ; j++) {  
				sbufXML.append(JSPUtil.getNull(colValues.get(realColNms[j])));
				if(j != (realColNms.length - 1)){
					sbufXML.append(DELIMITER); 
				}  	
	        }	
			sbufXML.append("]]></TR>\n"); 
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
					sb.append(JSPUtil.getNull(rs.getObject(j)) + DELIMITER);
				}	
				sb.append(JSPUtil.getNull(rs.getObject(colCount))  + "]]></TR>\n");
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
					arrRowSet[rowIdx][j-1] = JSPUtil.getNull(rs.getObject(j)).toString();
				}
				rowIdx++;
			}	
			
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
