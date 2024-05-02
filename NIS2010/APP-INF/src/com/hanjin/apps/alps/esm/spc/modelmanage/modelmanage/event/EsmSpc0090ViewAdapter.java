/*=========================================================
*Copyright(c) 2018 SM Lines
*@FileName : EsmSpc0090ViewAdapter.java
*@FileTitle : SPACE MANAGEMENT PLAN (NEW)
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.19
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2018.03.19 송민석
* 1.0 Creation
* 
* History
* 2018.03.19 송민석 [CSR #3462] 기존 H/O, RHQ, L/OFC 3단계로 진행 되던 업무를 H/O에서 통합 관리하도록 수정함 이에 ESM_SPC_0090을 copy해서 새로운 화면으로 만듬
* 
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.event;

import java.sql.SQLException;
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
 * @author CHOI Yun Sung
 * @see ViewAdapter 참조
 * @since CHOI Yun Sung
 */
public class EsmSpc0090ViewAdapter extends ViewAdapter {

	
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
		
		String sc_no          = null;
		String trd_cd         = null;
		String sub_trd_cd     = null;
		String sls_rgn_ofc_cd = null;
		String view_type       = null;
		String delt_flg       = null;
		String mainColor = "230,255,255"; //light blue
		String deltColor = "192,192,192"; //grey
		String scTtlColor = "180,252,131";//"128,255,0"; //green
		String ttlColor = "247,231,236"; //pink
		String nonColor = "255,255,255"; //white
		
		sbufXML.append("<DATA TOTAL='" + totCnt + "'>\n");
		
		for(int i=0;i<realCnt;i++){
			Map<String, String> colValues = vos.get(i).getColumnValues();
			
			sc_no          = getNull(colValues.get("sc_no"));
			trd_cd         = getNull(colValues.get("trd_cd"));
			sub_trd_cd     = getNull(colValues.get("sub_trd_cd"));
			sls_rgn_ofc_cd = getNull(colValues.get("sls_rgn_ofc_cd")); 
			view_type      = getNull(colValues.get("t"));
			delt_flg       = getNull(colValues.get("delt_flg"));
			
//			if(sub_trd_cd.equals("") && sls_rgn_ofc_cd.equals("TTL")){
//				sbufXML.append("<TR BGCOLOR=\"255,255,153\">");
//			}else if(sls_rgn_ofc_cd.equals("TTL")){
//				sbufXML.append("<TR BGCOLOR=\"247,231,236\">");
//			}
				sbufXML.append("<TR>");
//			}
			sbufXML.append("	<TD BGCOLOR='"+mainColor+"'><![CDATA[" + getNull(colValues.get("acct_clss_cd")) + "]]></TD>");
			sbufXML.append("	<TD BGCOLOR='"+mainColor+"'><![CDATA[" + getNull(colValues.get("cust_grp_nm"))     + "]]></TD>");
			sbufXML.append("	<TD BGCOLOR='"+mainColor+"'><![CDATA[" + getNull(colValues.get("cust_lgl_eng_nm")) + "]]></TD>");
			sbufXML.append("	<TD BGCOLOR='"+mainColor+"'>" + getNull(colValues.get("ctrt_ofc_cd"))              + "</TD>");
			if(trd_cd.equals("AES") || trd_cd.equals("IAS")) {
				sbufXML.append("	<TD INDENT='1' BGCOLOR='"+mainColor+"'></TD>");
				sbufXML.append("	<TD INDENT='1' BGCOLOR='"+mainColor+"'>" + getNull(colValues.get("rfa_no"))   + "</TD>");
			} else {
				sbufXML.append("	<TD INDENT='1' BGCOLOR='"+mainColor+"'>" + sc_no                              + "</TD>");
				sbufXML.append("	<TD INDENT='1' BGCOLOR='"+mainColor+"'></TD>");
			}
			sbufXML.append("	<TD INDENT='1' BGCOLOR='"+mainColor+"'>" + getNull(colValues.get("wk_mqc_qty"))   + "</TD>");
			sbufXML.append("	<TD BGCOLOR='"+mainColor+"'>" + getNull(colValues.get("cust_ctrl_cd")) + "</TD>");
			
			if(sub_trd_cd.equals("") && sls_rgn_ofc_cd.equals("TTL")) {
				if(trd_cd.equals("AES") || trd_cd.equals("IAS")) {
					sbufXML.append("	<TD BGCOLOR='"+scTtlColor+"'>RFA TTL</TD>");
				} else {
					sbufXML.append("	<TD BGCOLOR='"+scTtlColor+"'>SC TTL</TD>");
				}
				sbufXML.append("	<TD BGCOLOR='"+scTtlColor+"'></TD>");
			} else {
				sbufXML.append("	<TD BGCOLOR='"+nonColor+"'>" + getNull(colValues.get("sub_trd_cd")) + "</TD>");
				sbufXML.append("	<TD BGCOLOR='"+nonColor+"'>" + getNull(colValues.get("sls_rhq_cd")) + "</TD>");
			}
			
			if(sls_rgn_ofc_cd.equals("TTL")) {
				
				if(sub_trd_cd.equals("")){ //SC TTL Line
					sbufXML.append("	<TD BGCOLOR='"+scTtlColor+"'>" + nullToZero(getNull(colValues.get("cust_ttl_qty"))) + "</TD>");
					sbufXML.append("	<TD BGCOLOR='"+scTtlColor+"'>" + nullToZero(getNull(colValues.get("smpl_cust_qty"))) + "</TD>");
					sbufXML.append("	<TD BGCOLOR='"+scTtlColor+"'>" + nullToZero(getNull(colValues.get("cust_adj_ttl_qty")))     + "</TD>");
					sbufXML.append("	<TD BGCOLOR='"+scTtlColor+"'>" + sls_rgn_ofc_cd + "</TD>");
					if(view_type.equals("H")){
						sbufXML.append("	<TD BGCOLOR='"+scTtlColor+"'>" + nullToZero(getNull(colValues.get("strd_ttl_qty"))) + "</TD>");
						sbufXML.append("	<TD BGCOLOR='"+scTtlColor+"'>" + nullToZero(getNull(colValues.get("smpl_strd_qty"))) + "</TD>");
					}else{
						sbufXML.append("	<TD BGCOLOR='"+scTtlColor+"'>" + nullToZero(getNull(colValues.get("strd_adj_ttl_qty")) )    + "</TD>");
					}
				}else{
					sbufXML.append("	<TD BGCOLOR='"+nonColor+"'>" + nullToZero(getNull(colValues.get("cust_ttl_qty"))) + "</TD>");
					sbufXML.append("	<TD BGCOLOR='"+nonColor+"'>" + nullToZero(getNull(colValues.get("smpl_cust_qty"))) + "</TD>");
					sbufXML.append("	<TD BGCOLOR='"+nonColor+"'>" + nullToZero(getNull(colValues.get("cust_adj_ttl_qty")))     + "</TD>");
					sbufXML.append("	<TD BGCOLOR='"+ttlColor+"'>" + sls_rgn_ofc_cd + "</TD>");
					if(view_type.equals("H")){
						sbufXML.append("	<TD BGCOLOR='"+ttlColor+"'>" + nullToZero(getNull(colValues.get("strd_ttl_qty"))) + "</TD>");
						sbufXML.append("	<TD BGCOLOR='"+ttlColor+"'>" + nullToZero(getNull(colValues.get("smpl_strd_qty"))) + "</TD>");
					}else{
						sbufXML.append("	<TD BGCOLOR='"+ttlColor+"'>" + nullToZero(getNull(colValues.get("strd_adj_ttl_qty")) )    + "</TD>");
					}
				}
			} else {
				sbufXML.append("	<TD BGCOLOR='"+nonColor+"'>" + nullToZero(getNull(colValues.get("cust_qty")))     + "</TD>");
				sbufXML.append("	<TD BGCOLOR='"+nonColor+"'>" + nullToZero(getNull(colValues.get("smpl_cust_qty"))) + "</TD>");
				sbufXML.append("	<TD BGCOLOR='"+nonColor+"'>" + nullToZero(getNull(colValues.get("cust_adj_qty")))     + "</TD>");
				if(view_type.equals("H") && delt_flg.equals("Y")){
					sbufXML.append("	<TD BGCOLOR='"+deltColor+"'>" + sls_rgn_ofc_cd + "</TD>");
				}else{
					sbufXML.append("	<TD BGCOLOR='"+nonColor+"'>" + sls_rgn_ofc_cd + "</TD>");
				}
				if(!view_type.equals("H")){
					sbufXML.append("	<TD BGCOLOR='"+nonColor+"'>" + nullToZero(getNull(colValues.get("strd_adj_qty")) )    + "</TD>");
				}else{
					sbufXML.append("	<TD BGCOLOR='"+nonColor+"'>" + nullToZero(getNull(colValues.get("strd_qty")) )    + "</TD>");
					sbufXML.append("	<TD BGCOLOR='"+nonColor+"'>" + nullToZero(getNull(colValues.get("smpl_strd_qty")) )    + "</TD>");
				}
			}
			
			if(!view_type.equals("H")){
				if(sls_rgn_ofc_cd.equals("TTL")) {
					if(sub_trd_cd.equals("")){
						sbufXML.append("	<TD BGCOLOR='"+scTtlColor+"'>" + getNull(colValues.get("rlane_cd"))                     + "</TD>");
						sbufXML.append("	<TD BGCOLOR='"+scTtlColor+"'>" + nullToZero(getNull(colValues.get("load_ttl_qta")))        + "</TD>");
						sbufXML.append("	<TD BGCOLOR='"+scTtlColor+"'>" + nullToZero(getNull(colValues.get("rlane_ttl_qty")))        + "</TD>");
						sbufXML.append("	<TD BGCOLOR='"+scTtlColor+"'>" + nullToZero(getNull(colValues.get("smpl_rlane_qty")))        + "</TD>");
						sbufXML.append("	<TD>" + nullToZero(getNull(colValues.get("rlane_pfmc_ratio"))) + "</TD>");
						sbufXML.append("	<TD BGCOLOR='"+scTtlColor+"'></TD>");	// Lane PFMC Weighted 자동 계산
						sbufXML.append("	<TD BGCOLOR='"+scTtlColor+"'>" + nullToZero(getNull(colValues.get("rlane_adj_ttl_qty")))    + "</TD>");
						sbufXML.append("	<TD BGCOLOR='"+scTtlColor+"' EDIT='false'></TD>");//del
						sbufXML.append("	<TD BGCOLOR='"+scTtlColor+"'>" + getNull(colValues.get("rlane_cmpb"))                   + "</TD>");
						sbufXML.append("	<TD BGCOLOR='"+scTtlColor+"'></TD>");//spc_ctrl_mdl_rmk
					}else{
						sbufXML.append("	<TD BGCOLOR='"+ttlColor+"'>" + getNull(colValues.get("rlane_cd"))                     + "</TD>");
						sbufXML.append("	<TD BGCOLOR='"+ttlColor+"'>" + nullToZero(getNull(colValues.get("load_ttl_qta")))        + "</TD>");
						sbufXML.append("	<TD BGCOLOR='"+ttlColor+"'>" + nullToZero(getNull(colValues.get("rlane_ttl_qty")))        + "</TD>");
						sbufXML.append("	<TD BGCOLOR='"+ttlColor+"'>" + nullToZero(getNull(colValues.get("smpl_rlane_qty")))        + "</TD>");
						sbufXML.append("	<TD>" + nullToZero(getNull(colValues.get("rlane_pfmc_ratio"))) + "</TD>");
						sbufXML.append("	<TD BGCOLOR='"+ttlColor+"'></TD>");	// Lane PFMC Weighted 자동 계산
						sbufXML.append("	<TD BGCOLOR='"+ttlColor+"'>" + nullToZero(getNull(colValues.get("rlane_adj_ttl_qty")))    + "</TD>");
						sbufXML.append("	<TD BGCOLOR='"+ttlColor+"' EDIT='false'></TD>");//del
						sbufXML.append("	<TD BGCOLOR='"+ttlColor+"'>" + getNull(colValues.get("rlane_cmpb"))                   + "</TD>");
						sbufXML.append("	<TD BGCOLOR='"+ttlColor+"'></TD>");//spc_ctrl_mdl_rmk
					}
				}else{
					if(delt_flg.equals("Y")){
						sbufXML.append("	<TD BGCOLOR='"+deltColor+"'>" + getNull(colValues.get("rlane_cd"))                     + "</TD>");
					}else{
						sbufXML.append("	<TD BGCOLOR='"+nonColor+"'>" + getNull(colValues.get("rlane_cd"))                     + "</TD>");
					}
					sbufXML.append("	<TD BGCOLOR='"+nonColor+"'>" + getNull(colValues.get("load_qta"))                     + "</TD>");
					sbufXML.append("	<TD BGCOLOR='"+nonColor+"'>" + nullToZero(getNull(colValues.get("rlane_qty")))        + "</TD>");
					sbufXML.append("	<TD BGCOLOR='"+nonColor+"'>" + nullToZero(getNull(colValues.get("smpl_rlane_qty")))        + "</TD>");
					sbufXML.append("	<TD>" + nullToZero(getNull(colValues.get("rlane_pfmc_ratio"))) + "</TD>");
					sbufXML.append("	<TD BGCOLOR='"+nonColor+"'></TD>");	// Lane PFMC Weighted 자동 계산
					sbufXML.append("	<TD BGCOLOR='"+nonColor+"'>" + nullToZero(getNull(colValues.get("rlane_adj_qty")))    + "</TD>");
					if(nullToZero(getNull(colValues.get("rlane_adj_qty"))).equals("0")){
						sbufXML.append("	<TD EDIT='true'></TD>");//del
					} else {
						sbufXML.append("	<TD EDIT='false'></TD>");//del
					}
					sbufXML.append("	<TD BGCOLOR='"+nonColor+"'>" + getNull(colValues.get("rlane_cmpb"))                   + "</TD>");
					sbufXML.append("	<TD BGCOLOR='"+nonColor+"'><![CDATA[" + getNull(colValues.get("spc_ctrl_mdl_rmk"))     + "]]></TD>");
				}

			} else {
				if(sls_rgn_ofc_cd.equals("TTL")) {
					if(sub_trd_cd.equals("")){
						sbufXML.append("	<TD>" + nullToZero(getNull(colValues.get("strd_pfmc_ratio")))  + "</TD>");
						sbufXML.append("	<TD BGCOLOR='"+scTtlColor+"'></TD>");
						sbufXML.append("	<TD BGCOLOR='"+scTtlColor+"'>" + nullToZero(getNull(colValues.get("strd_adj_ttl_qty")))     + "</TD>");
						sbufXML.append("	<TD BGCOLOR='"+scTtlColor+"' EDIT='false'></TD>");//del
						sbufXML.append("	<TD BGCOLOR='"+scTtlColor+"'>" + getNull(colValues.get("strd_cmpb"))        + "</TD>");
					}else{
						sbufXML.append("	<TD>" + nullToZero(getNull(colValues.get("strd_pfmc_ratio")))  + "</TD>");
						sbufXML.append("	<TD BGCOLOR='"+ttlColor+"'></TD>");
						sbufXML.append("	<TD BGCOLOR='"+ttlColor+"'>" + nullToZero(getNull(colValues.get("strd_adj_ttl_qty")))     + "</TD>");
						sbufXML.append("	<TD BGCOLOR='"+ttlColor+"' EDIT='false'></TD>");//del
						sbufXML.append("	<TD BGCOLOR='"+ttlColor+"'>" + getNull(colValues.get("strd_cmpb"))        + "</TD>");
					}
				}else{
					sbufXML.append("	<TD>" + nullToZero(getNull(colValues.get("strd_pfmc_ratio")))  + "</TD>");
					sbufXML.append("	<TD BGCOLOR='"+nonColor+"'></TD>");
					sbufXML.append("	<TD BGCOLOR='"+nonColor+"'>" + nullToZero(getNull(colValues.get("strd_adj_qty")))     + "</TD>");
					if(nullToZero(getNull(colValues.get("strd_adj_qty"))).equals("0")){
						sbufXML.append("	<TD EDIT='true'></TD>");//del
					} else {
						sbufXML.append("	<TD EDIT='false'></TD>");//del
					}						
					sbufXML.append("	<TD BGCOLOR='"+nonColor+"'>" + getNull(colValues.get("strd_cmpb"))        + "</TD>");
				}
			}
			
			sbufXML.append("	<TD>" + getNull(colValues.get("cust_cnt_cd"))        + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("cust_seq"))        + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("trd_cd"))        + "</TD>");
			if(view_type.equals("H")){
				sbufXML.append("	<TD>" + getNull(colValues.get("rlane_cd"))        + "</TD>");
				sbufXML.append("	<TD>" + getNull(colValues.get("strd_flag"))        + "</TD>");
				sbufXML.append("	<TD>" + getNull(colValues.get("strd_flag2"))        + "</TD>");
				sbufXML.append("	<TD>" + getNull(colValues.get("rhq_ho"))        + "</TD>");
				sbufXML.append("	<TD>" + getNull(colValues.get("ofc_ho"))        + "</TD>");
			}
			sbufXML.append("	<TD></TD>");
			sbufXML.append("	<TD></TD>");
			sbufXML.append("	<TD></TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("delt_flg"))        + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("sc_rfa_flg"))      + "</TD>");
			if(!view_type.equals("H")){
				sbufXML.append("	<TD>" + getNull(colValues.get("lane_ho"))      + "</TD>");
				sbufXML.append("	<TD>" + getNull(colValues.get("o_add"))        + "</TD>");
				sbufXML.append("	<TD>" + getNull(colValues.get("r_rmk"))        + "</TD>");
				sbufXML.append("	<TD>" + getNull(colValues.get("rev_lane_cust_cnt"))        + "</TD>");
				sbufXML.append("	<TD>" + getNull(colValues.get(""))        + "</TD>");
			}
			
			if(view_type.equals("L")){
				sbufXML.append("	<TD></TD>");
			}
			
			sbufXML.append("	<TD></TD>");
			sbufXML.append("	<TD></TD>");
			
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
		if(str == null || str.equals(""))
			str = "0";
		return str;
	}
}