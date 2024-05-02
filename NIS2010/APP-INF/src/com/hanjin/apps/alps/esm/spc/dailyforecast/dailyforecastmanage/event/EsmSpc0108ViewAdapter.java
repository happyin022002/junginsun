/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0042Event.java
*@FileTitle : Allocation Change by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2009.08.14 최윤성 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.event;

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
public class EsmSpc0108ViewAdapter extends ViewAdapter {
	
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) 
	{
		StringBuilder sbufXML = new StringBuilder();
		
		int rowCount = vos.size();
		String rev_lane;
		sbufXML.append("<DATA TOTAL=\""+rowCount+"\">\n");
		
		if (rowCount > 0) {//3.1
			for(int i = 0; i < rowCount;i++){
				
				Map<String, String> colValues = vos.get(i).getColumnValues();
				rev_lane     = getNull(colValues.get("rlane_cd"));
				if(rev_lane.length() > 0){
	            	sbufXML.append("<TR LEVEL='1'>");
	            }else{
	            	sbufXML.append("<TR LEVEL='0'>");
	            }
				//sbufXML.append("<TR LEVEL='" + lvl+ "' EDIT='" + (editRow.equals("true")?(rowIoc?"FALSE":"TRUE"):editRow) + "'>");
				sbufXML.append("	<TD><![CDATA[" + getNull(colValues.get("fm_yrwk")) + "]]></TD>");
				sbufXML.append("	<TD><![CDATA[" + getNull(colValues.get("to_yrwk"))  + "]]></TD>");
				sbufXML.append("	<TD><![CDATA[" + getNull(colValues.get("sls_rgn_ofc_cd"))  + "]]></TD>");
				sbufXML.append("	<TD><![CDATA[" + getNull(colValues.get("cust_cnt_cd"))  + "]]></TD>");
				sbufXML.append("	<TD><![CDATA[" + getNull(colValues.get("cust_seq"))  + "]]></TD>");
				sbufXML.append("	<TD><![CDATA[" + getNull(colValues.get("cust_nm"))  + "]]></TD>");
				sbufXML.append("	<TD><![CDATA[" + getNull(colValues.get("sc_no"))  + "]]></TD>");
				sbufXML.append("	<TD><![CDATA[" + getNull(colValues.get("rfa_no"))  + "]]></TD>");
				sbufXML.append("	<TD><![CDATA[" + getNull(colValues.get("cust_ctrl_cd"))  + "]]></TD>");
				sbufXML.append("	<TD><![CDATA[" + getNull(colValues.get("sub_trd_cd"))  + "]]></TD>");
				if(rev_lane.length() > 0){
	            	sbufXML.append("	<TD><![CDATA[" + getNull(colValues.get("rlane_cd"))  + "]]></TD>");
	            }else{
	            	sbufXML.append("	<TD INDENT='1'><![CDATA[" + getNull(colValues.get("rlane_cd"))  + "]]></TD>");
	            }
				//sbufXML.append("	<TD><![CDATA[" + getNull(colValues.get("rlane_cd"))  + "]]></TD>");
				sbufXML.append("	<TD><![CDATA[" + getNull(colValues.get("guide"))  + "]]></TD>");
				sbufXML.append("	<TD><![CDATA[" + getNull(colValues.get("bkg_qty"))  + "]]></TD>");
				sbufXML.append("	<TD><![CDATA[" + getNull(colValues.get("perf"))  + "]]></TD>");

				sbufXML.append("</TR>\n");
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