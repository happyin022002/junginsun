/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EasEsd)360ViewAdapter.java
*@FileTitle : Default IBSheet Generation Class
*Open Issues :
*Change history :
*@LastModifyDate : 2015-05-14
*@LastModifier : PARK JEONG MIN
*@LastVersion : 1.0
* 2009-06-23 PARK JEONG MIN
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.mnradvanceaudit.event;

import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.controller.ViewAdapter;
import java.util.List;
import java.util.Map;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author KIM CHANG SIK
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EsdEas0360ViewAdapter extends DefaultViewAdapter {
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
		
        String realColNms[] = getColHeader(vo);


		if(vo.getMaxRows()>0){
			totCnt = vo.getMaxRows();
		}

		sbufXML.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(realColNms, "|")).append("' TOTAL='").append(totCnt).append("'>\n").toString());
		String colName =  "";
		for(int i=0;i<realCnt;i++){
			Map<String, String> colValues = vos.get(i).getColumnValues();
			
			int colCnt = realColNms.length;
			
			String estVrfyYN = JSPUtil.getNull(colValues.get("est_vrfy_yn"));
			String wkVrfyTN = JSPUtil.getNull(colValues.get("wk_vrfy_yn"));
			String eacYN = JSPUtil.getNull(colValues.get("eac_yn"));
			String auditResult = JSPUtil.getNull(colValues.get("audit_result"));
			String mltWoCurrFlg = JSPUtil.getNull(colValues.get("mlt_wo_curr_flg"));
			String sBatProgStsCd = JSPUtil.getNull(colValues.get("bat_prog_sts_cd"));
			String sSel = JSPUtil.getNull(colValues.get("sel"));
			float wo_inv_rto = Float.parseFloat(JSPUtil.getNull(colValues.get("wo_inv_rto"), "0.0"));
			float expn_max_prmt_rto = Float.parseFloat(JSPUtil.getNull(colValues.get("expn_max_prmt_rto"),  "0.0"));

			sbufXML.append("<TR");
			sbufXML.append(!"".equals(auditResult) ? " COLOR='100,100,100'" : "");
			sbufXML.append(!"".equals(auditResult) ? " BGCOLOR='245,235,245'" : "");
			sbufXML.append(">");
			for (int j = 0 ; j < colCnt ; j++) {
				colName =  (String)realColNms[j];
				
				
				if (colName.equals("sel")) {
            		sbufXML.append((new StringBuilder())
            				.append("<TD")
            				.append(sBatProgStsCd.equals("P")?" BGCOLOR='255, 190, 130'":"")
            				.append(">")
            				.append(sSel)
            				.append("</TD>").toString());
            	}else if("Y".equals(estVrfyYN) && "est_vrfy_yn".equals(colName)) {
					sbufXML.append("<TD COLOR='RED'><![CDATA[");
					sbufXML.append(JSPUtil.getNull(colValues.get(realColNms[j])) );
					sbufXML.append("]]></TD>");
				} else if("Y".equals(wkVrfyTN) && "wk_vrfy_yn".equals(colName)) {
					sbufXML.append("<TD COLOR='RED'><![CDATA[");
					sbufXML.append(JSPUtil.getNull(colValues.get(realColNms[j])) );
					sbufXML.append("]]></TD>");
				} else if("Y".equals(mltWoCurrFlg) && "mlt_wo_curr_flg".equals(colName)) {
					sbufXML.append("<TD COLOR='RED'><![CDATA[");
					sbufXML.append(JSPUtil.getNull(colValues.get(realColNms[j])) );
					sbufXML.append("]]></TD>");
				} else if(Float.compare(wo_inv_rto, expn_max_prmt_rto) == 1 &&  ("chg_wo_amt".equals(colName) || "inv_diff_pct".equals(colName))) { 
					sbufXML.append("<TD COLOR='RED'><![CDATA[");
					sbufXML.append(JSPUtil.getNull(colValues.get(realColNms[j])) );
					sbufXML.append("]]></TD>");
				} else if("Y".equals(eacYN) && "eac_yn".equals(colName)) {
					sbufXML.append("<TD COLOR='RED'><![CDATA[");
					sbufXML.append(JSPUtil.getNull(colValues.get(realColNms[j])) );
					sbufXML.append("]]></TD>");
				} else {
					sbufXML.append("<TD><![CDATA[");
					sbufXML.append(JSPUtil.getNull(colValues.get(realColNms[j])) );
					sbufXML.append("]]></TD>");
				}
			}
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
