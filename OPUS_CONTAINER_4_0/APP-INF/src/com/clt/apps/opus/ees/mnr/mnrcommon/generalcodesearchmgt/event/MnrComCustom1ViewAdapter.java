/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : MnrComCustom1ViewAdapter.java
*@FileTitle : Default IBSheet Generation Class
*Open Issues : MnrComEqGenInfoSearch-MNR_COMGS(SEARCH02)를 FIX하기위한  
*Open Issues : MNR_COM_CUSTOM1GS
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
public class MnrComCustom1ViewAdapter extends ViewAdapter {
	
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
		customOutIndex.add("imm_ext");
		customOutIndex.add("mdl_nm");
		customOutIndex.add("mvmt_dt");
		customOutIndex.add("dv_cur");
		customOutIndex.add("rpr_yd");
		customOutIndex.add("sp_name");
		customOutIndex.add("flg_rmk");
		customOutIndex.add("manu_dt");
		customOutIndex.add("mkr_nm");
		customOutIndex.add("pagerows");
		customOutIndex.add("dv_value");
		customOutIndex.add("ibflag");
		customOutIndex.add("off_hire");
		customOutIndex.add("mvmt_cd");
		customOutIndex.add("dsp_flag");
		customOutIndex.add("hngr_flg_yd");
		customOutIndex.add("lessor_nm");
		customOutIndex.add("hngr_rck_cd");
		customOutIndex.add("crnt_yd_cd");
		customOutIndex.add("lstm_cd");
		customOutIndex.add("eq_no");
		customOutIndex.add("hngr_flg_dt");
		customOutIndex.add("bar_atch_knt");
		customOutIndex.add("status");
		customOutIndex.add("bar_tp_cd");
		customOutIndex.add("dmg_flag");
		customOutIndex.add("cost");
		customOutIndex.add("mtrl_cd");
		customOutIndex.add("eq_type");
		customOutIndex.add("mtrl_nm");
		customOutIndex.add("rpr_type");
		customOutIndex.add("eq_tpsz_cd");
		customOutIndex.add("rpr_dt"); 
		customOutIndex.add("total_loss_date"); 
		customOutIndex.add("rpr_cost_amt");	
		//2010-08-16 dpp_amt 추가. 서미진.
		customOutIndex.add("dpp_amt");
		//2010-12-24 행거 관련 추가 박명신
		customOutIndex.add("mnr_hngr_trf_cd");
		customOutIndex.add("mnr_hngr_trf_otr_desc");
		customOutIndex.add("act_invt_qty");
		customOutIndex.add("mnr_hngr_dmg_qty");
		customOutIndex.add("mnr_lost_hngr_qty");
		customOutIndex.add("mnr_disp_hngr_qty");
		customOutIndex.add("lessor_cd");
		customOutIndex.add("rstr_usg_lbl_nm");
		customOutIndex.add("rstr_usg_lbl_tp");
		customOutIndex.add("rstr_usg_lbl_val");
		customOutIndex.add("cntr_sts_cd");
			
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
