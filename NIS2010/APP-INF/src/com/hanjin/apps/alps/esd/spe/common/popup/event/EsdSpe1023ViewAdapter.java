/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsdSpe1023ViewAdapter.java
*@FileTitle : Location 팝업
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.17
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.17 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.common.popup.event;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;

/**
 * IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author 박명신
 * @see ViewAdapter 참조      
 * @since J2EE 1.5   
 */
public class EsdSpe1023ViewAdapter extends ViewAdapter {

	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param List<AbstractValueObject> paramList
	 * @param String paramString
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception	 
	 */				
	public String makeDataTag(List<AbstractValueObject> paramList,
			String paramString) {
		StringBuilder localStringBuilder = new StringBuilder();
		int i = paramList.size();
		int j = paramList.size();
		AbstractValueObject localAbstractValueObject = (AbstractValueObject) paramList
				.get(0);
		String[] arrayOfString1 = getColHeader(localAbstractValueObject);
		String[] arrayOfString2 = getChangedColNms(arrayOfString1, paramString);
		if (localAbstractValueObject.getMaxRows() > 0)
			i = localAbstractValueObject.getMaxRows();
		String str = JSPUtil.convertStringArrayToString(arrayOfString2, "|");
		str = JSPUtil.replace(str, new StringBuilder().append(paramString).append("slevel").append("|").toString(), "");
		localStringBuilder.append(new StringBuilder().append("<DATA COLORDER='")
				                                     .append(str).append("' COLSEPARATOR='")
				                                     .append("☜☞")
				                                     .append("' TOTAL='")
				                                     .append(i).append("'>\n").toString());
		for (int k = 0; k < j; ++k) {
			HashMap localHashMap = ((AbstractValueObject) paramList.get(k)).getColumnValues();
			localStringBuilder.append(new StringBuilder().append("\t<TR LEVEL='")
					                                     .append((String) localHashMap.get("slevel"))
					                                     .append("'><![CDATA[").toString()); 
			int l = arrayOfString1.length;
			for (int i1 = 0; i1 < l; ++i1) {
				if ("slevel".equals(arrayOfString1[i1].toLowerCase()))
					continue;
				localStringBuilder.append(new StringBuilder().append(getNull((String) localHashMap.get(arrayOfString1[i1]))).append("☜☞").toString());
			}
			localStringBuilder.delete(localStringBuilder.toString().length() - "☜☞".length(), localStringBuilder.toString().length());
			localStringBuilder.append("]]></TR>\n");
		}
		localStringBuilder.append("</DATA>\n");
		return localStringBuilder.toString();
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
		}catch(SQLException ex){  
			throw new RuntimeException(ex.getMessage());
		}catch(Exception e){  
			throw new RuntimeException(e.getMessage());  
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
		}catch(SQLException ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}catch(Exception e){  
			throw new RuntimeException(e.getMessage());  
		}        
		
		try{
			sb.append("<DATA COLSEPARATOR='" + DELIMITER + "'>\n");
			if(rowCnt>0){ 
				for (int coIdx = 0 ;coIdx < colCnt ; coIdx++) {
					sb.append(" <TR><![CDATA[");
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
