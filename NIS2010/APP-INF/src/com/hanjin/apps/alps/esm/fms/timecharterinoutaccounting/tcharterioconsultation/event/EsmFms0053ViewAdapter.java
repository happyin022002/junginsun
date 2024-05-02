/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : EsmFms0074ViewAdapter.java
*@FileTitle : Default IBSheet Generation Class
*Open Issues :
*Change history :
*@LastModifyDate : 2009-06-09
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009-06-09 Yoon, Seyeong
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event;

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
 * @author Lee SeungYol
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EsmFms0053ViewAdapter extends ViewAdapter {

	
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

		if(vo.getMaxRows()>0){
			totCnt = vo.getMaxRows();
		}

		sbufXML.append("<DATA " + "COLSEPARATOR='" + DELIMITER + "' TOTAL='" + totCnt +"'>\n");

		if (prefix.equals("master")) {//Inqury Result List 조회시
			String[] realColNms = {"~~", "~~", "~~", "csr_no", "vndr_cnt_cd", "vndr_seq", "eff_dt", 
						"csr_curr_cd", "csr_amt", "csr_desc", "if_err_rsn"};

			for(int i=0;i<realCnt;i++){
				Map<String, String> colValues = vos.get(i).getColumnValues();
				
				int colCntAll = realColNms.length;

				sbufXML.append("<TR SUM='TRUE'><![CDATA[");
				for (int j = 0 ; j < colCntAll ; j++) {
					sbufXML.append(JSPUtil.getNull(colValues.get(realColNms[j])) + DELIMITER);
				}
				sbufXML.append("]]></TR>\n");
			}
		} else {//Error CSR Detail 조회시 
			String[] realColNms = {"~~", "org_slp_seq_no", "acct_cd", "vndr_cnt_cd", "vndr_seq", "ctr_cd", "slp_loc_cd", "eff_dt", "csr_amt",
					   "org_slp_tp_cd", "org_slp_func_cd", "org_slp_ofc_cd", "org_slp_iss_dt", "org_slp_ser_no", "cxl_desc", 
					   "pre_slp_tp_cd", "pre_slp_func_cd", "pre_slp_ofc_cd",
					   "~~", "org_slp_seq_no", "csr_desc", "csr_desc", "csr_desc", "csr_desc", "csr_desc", "vvd_cd", "key_number",
					   "slp_tp_cd", "slp_func_cd", "slp_ofc_cd", "slp_iss_dt", "slp_ser_no", "slp_seq_no",
					   "pre_slp_iss_dt", "pre_slp_ser_no", "pre_slp_seq_no"};

			for(int i=0;i<realCnt;i++){
				Map<String, String> colValues = vos.get(i).getColumnValues();
				
				int colCntAll = realColNms.length;
				int colCnt1st = colCntAll/2;

				sbufXML.append("<TR SUM='TRUE'><![CDATA[");
				//ibFlag
				sbufXML.append("I" + DELIMITER);
				for (int j = 1 ; j < colCnt1st ; j++) {
					sbufXML.append(JSPUtil.getNull(colValues.get(realColNms[j])) + DELIMITER);
				}
				sbufXML.append("]]></TR>\n");
				
				sbufXML.append("<TR><![CDATA[");
				//ibFlag
				sbufXML.append("I" + DELIMITER);
				colCnt1st = colCnt1st + 1;
				for (int j = colCnt1st ; j < colCntAll ; j++) {
					sbufXML.append(JSPUtil.getNull(colValues.get(realColNms[j])) + DELIMITER);
				}
				sbufXML.append("]]></TR>\n");
			}
		}
		
		sbufXML.append("</DATA>\n");
		
		return sbufXML.toString();
	}

	/**
	 * DBRowSet를 Parsing하여 <DATA>태그를 생성한다.<br>
	 * IBSheet의 prefix값이 있는 경우 COLORDER에 prefix를 붙인 column명으로 표시해 준다.<br>
	 * 
	 * @param rs DBRowSet 			VO객체
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
