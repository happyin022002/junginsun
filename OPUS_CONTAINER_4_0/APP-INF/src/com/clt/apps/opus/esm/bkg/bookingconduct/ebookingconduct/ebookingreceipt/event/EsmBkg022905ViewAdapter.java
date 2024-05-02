/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg022905ViewAdapter.java
*@FileTitle : e-Booking & SI Process Detail(C/M)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.17
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.06.17 전용진
* 1.0 Creation
* -------------------------------------------------------
* history
* 2011.01.04 김영철 [CHM-201007416-01] E-BKG & SI CM Tab 수정 요청 (구주 24HR Rule 관련)
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event;

import java.util.List;
import java.util.Map;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;

/**
 * EsmBkg022905ViewAdapter
 *
 * @author Jun Yong Jin
 * @see com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.ESM_BKG_0229_05HTMLAction
 * @since J2EE 1.6
 */
public class EsmBkg022905ViewAdapter extends ViewAdapter {

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

		sbufXML.append("<DATA TOTAL='" + totCnt +"'>\n");

		int cntrSeq = 0;
		String oldCntrNo = "";
		for(int i=0;i<realCnt;i++){
			Map<String, String> colValues = vos.get(i).getColumnValues();
			if ( i > 0 ) oldCntrNo = (vos.get(i-1).getColumnValues()).get("cntr_no");
			if ( !oldCntrNo.equals(JSPUtil.getNull(colValues.get("cntr_no"))) ) cntrSeq++;

			if ( !"".equals(JSPUtil.getNull(colValues.get("diff_rmk"))) ) {
				sbufXML.append("	<TR>\n");
				sbufXML.append("		<TD><![CDATA[" + JSPUtil.getNull(colValues.get("cntr_no")) + "]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[" + JSPUtil.getNull(colValues.get("dcgo_seq")) + "]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[" + JSPUtil.getNull(colValues.get("diff_rmk")) + "]]></TD>\n");
				sbufXML.append("	</TR>\n");
			} else {
				sbufXML.append("	<TR>\n");
				sbufXML.append("		<TD>R</TD>\n");
				sbufXML.append("		<TD BGCOLOR=\"204, 204, 204\">" + cntrSeq + "</TD>\n");
				sbufXML.append("		<TD><![CDATA[" + JSPUtil.getNull(colValues.get("cntr_no")) + "]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[" + JSPUtil.getNull(colValues.get("cntr_no")) + "]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pck_qty")) + "]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pck_tp_cd")) + "]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[-]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[" + JSPUtil.getNull(colValues.get("cntr_mf_wgt")) + "]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[" + JSPUtil.getNull(colValues.get("wgt_ut_cd")) + "]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[-]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[" + JSPUtil.getNull(colValues.get("meas_qty")) + "]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[" + JSPUtil.getNull(colValues.get("meas_ut_cd")) + "]]></TD>\n");
				sbufXML.append("	</TR>\n");
	
				sbufXML.append("	<TR MERGE=\"TRUE\">\n");
				sbufXML.append("		<TD></TD>\n");
				sbufXML.append("		<TD BGCOLOR=\"204, 204, 204\">" + cntrSeq + "</TD>\n");
				sbufXML.append("		<TD BGCOLOR=\"204, 204, 204\"><![CDATA[" + JSPUtil.getNull(colValues.get("cntr_mf_seq")) + "]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[-]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[" + colValues.get("hamo_trf_cd") + "]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[" + colValues.get("hamo_trf_cd") + "]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[-]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[" + colValues.get("cmdt_hs_cd") + "]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[" + colValues.get("cmdt_hs_cd") + "]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[-]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[" + colValues.get("ncm_no") + "]]></TD>\n");
				sbufXML.append("		<TD><![CDATA[" + colValues.get("ncm_no") + "]]></TD>\n");
				sbufXML.append("	</TR>\n");
	
				sbufXML.append("	<TR MERGE=\"TRUE\">\n");
				sbufXML.append("		<TD></TD>\n");
				sbufXML.append("		<TD BGCOLOR=\"204, 204, 204\">" + cntrSeq + "</TD>\n");
	//			for (int j=0;j<11;j++) {
	//				sbufXML.append("		<TD><![CDATA[" + colValues.get("cntr_mf_gds_desc") + "]]></TD>\n");
	//			}
				for (int j=0;j<8;j++) {
					sbufXML.append("		<TD><![CDATA[" + colValues.get("cntr_mf_gds_desc") + "]]></TD>\n");
				}
				for (int j=0;j<2;j++) {
					sbufXML.append("		<TD><![CDATA[" + colValues.get("po_no") + "]]></TD>\n");
				}
				sbufXML.append("	</TR>\n");
	
				sbufXML.append("	<TR MERGE=\"TRUE\">\n");
				sbufXML.append("		<TD></TD>\n");
				sbufXML.append("		<TD BGCOLOR=\"204, 204, 204\">" + cntrSeq + "</TD>\n");
	//			for (int j=0;j<11;j++) {
	//				sbufXML.append("		<TD><![CDATA[" + colValues.get("cntr_mf_dtl_desc") + "]]></TD>\n");
	//			}
				for (int j=0;j<8;j++) {
					sbufXML.append("		<TD><![CDATA[" + colValues.get("cntr_mf_dtl_desc") + "]]></TD>\n");
				}
				for (int j=0;j<2;j++) {
					sbufXML.append("		<TD><![CDATA[" + colValues.get("dcgo_seq") + "]]></TD>\n");
				}
				sbufXML.append("	</TR>\n");
	
				sbufXML.append("	<TR MERGE=\"TRUE\">\n");
				sbufXML.append("		<TD></TD>\n");
				sbufXML.append("		<TD BGCOLOR=\"204, 204, 204\">" + cntrSeq + "</TD>\n");
	//			for (int j=0;j<11;j++) {
	//				sbufXML.append("		<TD><![CDATA[" + colValues.get("cntr_mf_mk_desc") + "]]></TD>\n");
	//			}
				for (int j=0;j<8;j++) {
					sbufXML.append("		<TD><![CDATA[" + colValues.get("cntr_mf_mk_desc") + "]]></TD>\n");
				}
				for (int j=0;j<2;j++) {
					sbufXML.append("		<TD><![CDATA[" + colValues.get("cntr_mf_no") + "]]></TD>\n");
				}
				sbufXML.append("	</TR>\n");
	
				oldCntrNo = JSPUtil.getNull(colValues.get("cntr_no"));
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
