/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : DefaultViewAdapter.java
*@FileTitle : Default IBSheet Generation Class
*Open Issues :
*Change history :
*@LastModifyDate : 2008-11-24
*@LastModifier : Lee SeungYol
*@LastVersion : 1.0
* 2008-11-24 Lee SeungYol
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

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
 * @author Lee SeungYol
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EsmBkg1066ViewAdapter extends ViewAdapter {

	
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
		String[] realColNms=getColHeader(vo);
		String[] changedColNms = getChangedColNms(realColNms, prefix);
		
		if(vo.getMaxRows()>0){
			totCnt = vo.getMaxRows();
		}
		
		sbufXML.append("<DATA COLORDER='" + JSPUtil.convertStringArrayToString(changedColNms, "|") + "' TOTAL='" + totCnt +"'>\n");


		int colCnt = 0;		
		String tdAttr  = "";
		String colName = "";
		String strTmp  = "";
		
		for(int i=0;i<realCnt;i++){
			Map<String, String> colValues = vos.get(i).getColumnValues();
			
			sbufXML.append("	<TR>\n");
			colCnt = realColNms.length;
			
			for (int j = 0 ; j < colCnt ; j++) {
				
				tdAttr = "";
				colName = realColNms[j];
 				
				if (colName.endsWith("fax_no")) 
				{
					// 전송 성공/실패 여부 색상 표시 : 성공(S)-blue, 실패(F)-red,진행중(P)-pink
					strTmp = getNull(colValues.get(colName.substring(0,2) + "_fax_ntc_snd_rslt"));					
					
					if ("S".equals(strTmp)) tdAttr = tdAttr + " COLOR=\"0,0,255\""; // blue
					else if ("F".equals(strTmp)) tdAttr = tdAttr + " COLOR=\"255,0,0\""; // red
					else if ("P".equals(strTmp)) tdAttr = tdAttr + " COLOR=\"255,0,192\""; // Pink

					// Notice 대상 여부. Notice 대상이 아닌 경우 Edit 불가
					strTmp = getNull(colValues.get(colName.substring(0,2) + "_fax_snd_flg"));
					if ("N".equals(strTmp)) tdAttr = tdAttr + " EDIT=\"FALSE\"";
				}
				else if (colName.endsWith("ntc_eml")) 
				{
					//  전송 성공/실패 여부 색상 표시 : 성공(S)-blue, 실패(F)-red,진행중(P)-pink
					strTmp = getNull(colValues.get(colName.substring(0,2) + "_eml_ntc_snd_rslt"));

					if ("S".equals(strTmp)) tdAttr = tdAttr + " COLOR=\"0,0,255\""; // blue
					else if ("F".equals(strTmp)) tdAttr = tdAttr + " COLOR=\"255,0,0\""; // red
					else if ("P".equals(strTmp)) tdAttr = tdAttr + " COLOR=\"255,0,192\""; // Pink
					
					// Notice 대상 여부. Notice 대상이 아닌 경우 Edit 불가
					strTmp = getNull(colValues.get(colName.substring(0,2) + "_eml_snd_flg"));
					if ("N".equals(strTmp)) tdAttr = tdAttr + " EDIT=\"FALSE\"";

				}
				else if (colName.endsWith("fax_no_chk")) 
				{
					// Notice 대상 여부. Notice 대상이 아닌 경우 Edit 불가
					strTmp = getNull(colValues.get(colName.substring(0,2) + "_fax_snd_flg"));
					if ("N".equals(strTmp)) tdAttr = tdAttr + " EDIT=\"FALSE\"";
				}
				else if (colName.endsWith("ntc_eml_chk")) 
				{
					// Notice 대상 여부. Notice 대상이 아닌 경우 Edit 불가
					strTmp = getNull(colValues.get(colName.substring(0,2) + "_eml_snd_flg"));
					if ("N".equals(strTmp)) tdAttr = tdAttr + " EDIT=\"FALSE\"";
				}
				else if (colName.equals("cntr_wgt"))
				{
					// Over Weight 시, 색상(red) 처리
					strTmp = getNull(colValues.get("over_wgt_flg"));
					if ("Y".equals(strTmp)) tdAttr = tdAttr + " COLOR=\"RED\" BOLD=\"TRUE\"";
				}
				else if (colName.equals("pkup_no_show")) 
				{
					if ("Y".equals(getNull(colValues.get("frt_clt_flg"))) &&
							"Y".equals(getNull(colValues.get("obl_clt_flg"))) &&
							"Y".equals(getNull(colValues.get("cstms_clr_flg"))) &&
							"Y".equals(getNull(colValues.get("pkup_yd_cd_flg"))))
					{
						tdAttr = tdAttr + " EDIT=\"TRUE\"";
					}
					else {
						tdAttr = tdAttr + " EDIT=\"FALSE\"";
					}
				}
				
				
				sbufXML.append("		<TD" + tdAttr + "><![CDATA[" + getNull(colValues.get(realColNms[j])) + "]]></TD>\n");
	        }

			sbufXML.append("	</TR>\n");
		}
		sbufXML.append("</DATA>\n");
		
		return sbufXML.toString();
	}

	protected String makeDataTag1(List<AbstractValueObject> vos, String prefix) {
		StringBuilder sbufXML = new StringBuilder();
		
		int totCnt = vos.size();
		int realCnt = vos.size();

		AbstractValueObject vo = (AbstractValueObject)vos.get(0);
		String[] realColNms=getColHeader(vo);
		String[] changedColNms = getChangedColNms(realColNms, prefix);
		
		if(vo.getMaxRows()>0){
			totCnt = vo.getMaxRows();
		}
		
		sbufXML.append("<DATA COLORDER='" + JSPUtil.convertStringArrayToString(changedColNms, "|") + "' COLSEPARATOR='" + DELIMITER + "' TOTAL='" + totCnt +"'>\n");

		for(int i=0;i<realCnt;i++){
			Map<String, String> colValues = vos.get(i).getColumnValues();
			
			sbufXML.append("	<TR><![CDATA[");
			int colCnt = realColNms.length;
			
			for (int j = 0 ; j < colCnt-1 ; j++) {
				sbufXML.append(getNull(colValues.get(realColNms[j])) + DELIMITER);
	        }
			sbufXML.append(getNull(colValues.get(realColNms[colCnt-1])) + "]]></TR>\n");
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

}
