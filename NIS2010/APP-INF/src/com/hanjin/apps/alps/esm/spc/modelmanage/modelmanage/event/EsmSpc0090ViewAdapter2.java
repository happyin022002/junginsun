/*=========================================================
*Copyright(c) 2018 SM Lines
*@FileName : EsmSpc0090ViewAdapter2.java
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
 * @author SQM USER
 * @see ViewAdapter 참조
 * @since SQM USER
 */
public class EsmSpc0090ViewAdapter2 extends ViewAdapter {

	/**
	 * VO List 를 Parsing 하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 *
	 * @param vos List<AbstractValueObject> List 객체
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception
	 */
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		StringBuilder sbufXML = new StringBuilder();

		int totCnt  = vos.size();
		int realCnt = vos.size();
		String trd_cd = "";

		sbufXML.append("<DATA TOTAL='" + totCnt + "'>\n");
		for(int i=0;i<realCnt;i++){
			Map<String, String> colValues = vos.get(i).getColumnValues();
			trd_cd = getNull(colValues.get("trd_cd"));

			sbufXML.append("<TR>");
			sbufXML.append("	<TD><![CDATA[" + getNull(colValues.get("acct_clss_cd")) + "]]></TD>");
			sbufXML.append("	<TD><![CDATA[" + getNull(colValues.get("cust_grp_nm"))     + "]]></TD>");
			sbufXML.append("	<TD><![CDATA[" + getNull(colValues.get("cust_lgl_eng_nm")) + "]]></TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("ctrt_ofc_cd"))     + "</TD>");
			if(trd_cd.equals("AES") || trd_cd.equals("IAS")) {
				sbufXML.append("	<TD INDENT='1'></TD>");
				sbufXML.append("	<TD INDENT='1'>" + getNull(colValues.get("rfa_no"))   + "</TD>");
			} else {
				sbufXML.append("	<TD INDENT='1'>" + getNull(colValues.get("sc_no"))   + "</TD>");
				sbufXML.append("	<TD INDENT='1'></TD>");
			}
			sbufXML.append("	<TD INDENT='1'>" + getNull(colValues.get("wk_mqc_qty"))     + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("cust_ctrl_cd"))     + "</TD>");
			sbufXML.append("	<TD></TD>"); //sub_trd_cd
			sbufXML.append("	<TD></TD>"); //sls_rhq_cd
			sbufXML.append("	<TD></TD>"); //cust_qty
			sbufXML.append("	<TD></TD>"); //smpl_cust_qty
			sbufXML.append("	<TD></TD>"); //cust_adj_qty
			sbufXML.append("	<TD></TD>"); //sls_rgn_ofc_cd
			//송민석 수정
//			sbufXML.append("	<TD></TD>"); //strd_qty
//			sbufXML.append("	<TD></TD>"); //smpl_strd_qty
//			sbufXML.append("	<TD></TD>"); //strd_pfmc_ratio
//			sbufXML.append("	<TD></TD>"); //strd_pfmc_wt
			sbufXML.append("	<TD></TD>"); //strd_adj_qty
			sbufXML.append("	<TD></TD>"); //rlane_cd
			sbufXML.append("	<TD></TD>"); //load_qta
			sbufXML.append("    <TD></TD>"); //rlane_qty
            sbufXML.append("    <TD></TD>"); //smpl_rlane_qty
            sbufXML.append("    <TD></TD>"); //rlane_pfmc_ratio
            sbufXML.append("    <TD></TD>"); //rlane_pfmc_wt
            sbufXML.append("    <TD></TD>"); //rlane_adj_qty
            sbufXML.append("    <TD></TD>"); //del
            sbufXML.append("    <TD></TD>"); //rlane_cmpb
            sbufXML.append("    <TD></TD>"); //spc_ctrl_mdl_rmk
			sbufXML.append("	<TD>" + getNull(colValues.get("cust_cnt_cd"))     + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("cust_seq"))     + "</TD>");
			sbufXML.append("	<TD>" + getNull(colValues.get("trd_cd"))     + "</TD>");
			sbufXML.append("	<TD></TD>"); //ibflag
			sbufXML.append("	<TD></TD>"); //real_ibflag
			sbufXML.append("	<TD></TD>"); //strd_flag2
			sbufXML.append("	<TD></TD>"); //delt_flg
            sbufXML.append("    <TD>" + getNull(colValues.get("sc_rfa_flg"))     + "</TD>");
			sbufXML.append("	<TD></TD>"); //lane_ho
			sbufXML.append("	<TD></TD>"); //o_add
			sbufXML.append("	<TD></TD>"); //r_rmk
			sbufXML.append("	<TD></TD>"); //rev_lane_cust_cnt
			sbufXML.append("     <TD></TD>"); //org_rlane_cd
			sbufXML.append("    <TD></TD>"); //g3_cng_usr
			sbufXML.append("    <TD></TD>"); //cng_ofc_list
            
	 
			sbufXML.append("</TR>\n");
		}
		sbufXML.append("</DATA>\n");
		return sbufXML.toString();
	}

	/**
	 * DBRowSet를 Parsing 하여 <DATA>태그를 생성한다.<br>
	 * IBSheet의 prefix 값이 있는 경우 COLORDER에 prefix 를 붙인 column 명으로 표시해 준다.<br>
	 *
	 * @param rs		DBRowSet	VO객체
	 * @param prefix	String		IBSheet savename's prefix string
	 * @return String	IBSheet		<DATA> 태그
	 * @exception
	 */
	protected String makeDataTag(DBRowSet rs, String prefix) {
		StringBuilder sb = new StringBuilder();

		//Pivot Table 인 경우 makePivotDataTag 실행하여  return
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
	 * Pivot Table 용 Data tag 를 생성한다.<br>
	 *
	 * @param rs		DBRowSet	VO 객체
	 * @return String	IBSheet		<DATA> 태그
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
}