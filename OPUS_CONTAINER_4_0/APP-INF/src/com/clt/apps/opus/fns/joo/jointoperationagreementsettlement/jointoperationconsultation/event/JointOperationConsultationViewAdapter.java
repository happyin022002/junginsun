/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : JointOperationConsultationViewAdapter.java
*@FileTitle : Default IBSheet Generation Class
*Open Issues :
*Change history :
*@LastModifyDate : 2009-06-12
*@LastModifier : Park Hee-dong
*@LastVersion : 1.0
* 2009-06-12 Park Hee-dong
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;

/**
 * 2DataRows를 위한 ViewAdapter<br>
 * - 조회한 한개의 row를 두row의 xml로 넘긴다.<br>
 *
 * @author Park Hee Dong
 * @see DefaultViewAdapter 참조
 * @since J2EE 1.6
 */
public class JointOperationConsultationViewAdapter extends ViewAdapter {

	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param colOrder String[] Column명 문자열 
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @ex
	 */	
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		StringBuilder sbufXML = new StringBuilder();
		
		int totCnt  = vos.size();
		int realCnt = vos.size();

		AbstractValueObject vo = (AbstractValueObject)vos.get(0);
		String[] realColNms= {"seq_num","dr_cr_cd","acct_cd","vndr","ctr_cd","loc_cd","eff_dt","csr_locl_amt","csr_locl_amt","seq_num","slp_desc","slp_desc","slp_desc","slp_desc","slp_desc","slp_desc","vvd","key_no"};

		if(vo.getMaxRows()>0){
			totCnt = vo.getMaxRows();
		}
		
		sbufXML.append("<DATA COLSEPARATOR='" + DELIMITER + "' TOTAL='" + totCnt +"'>\n");

		//realCnt => 실제 data건수
		for(int i=0;i<realCnt;i++){
			Map<String, String> colValues = vos.get(i).getColumnValues();
			
			sbufXML.append("	<TR><![CDATA[");
			int colCnt = realColNms.length;
			
			for (int j = 0 ; j < 8 ; j++) {
				sbufXML.append(JSPUtil.getNull(colValues.get(realColNms[j])) + DELIMITER);
	        }
			sbufXML.append(JSPUtil.getNull(colValues.get(realColNms[7])) + "]]></TR>\n");

			sbufXML.append("	<TR><![CDATA[");

			for (int j = 9 ; j < colCnt-1 ; j++) {
				sbufXML.append(JSPUtil.getNull(colValues.get(realColNms[j])) + DELIMITER);
	        }
			sbufXML.append(JSPUtil.getNull(colValues.get(realColNms[colCnt-1])) + "]]></TR>\n");
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
	protected String makeDataTag(DBRowSet rs, String prefix) {
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
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
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
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
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
