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
public class UserViewAdapter0672 extends ViewAdapter {

	
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
		
		
		log.debug("----------------------->   prefix         "+ prefix);
		
		//조회할때 이거 탄다.
		StringBuilder sbufXML = new StringBuilder();
		
		int totCnt = vos.size();
		int realCnt = vos.size();

		AbstractValueObject vo = (AbstractValueObject)vos.get(0);
		String[] realColNms=getColHeader(vo);
		String[] changedColNms = getChangedColNms(realColNms, prefix);
		
		if(vo.getMaxRows()>0){
			totCnt = vo.getMaxRows();
		}
		
		
		int seq = 1;
		
		if(prefix.trim().equals("t2sheet1_") ){
			sbufXML.append("<DATA COLORDER='" + JSPUtil.convertStringArrayToString(changedColNms, "|") + "' COLSEPARATOR='" + DELIMITER + "' TOTAL='" + totCnt +"'>\n");
			
			
			for(int i=0;i<realCnt;i++){
				Map<String, String> colValues = vos.get(i).getColumnValues();
				
				String style = "";
				//log.debug("-------------" + realColNms);
				//log.debug("-------------" + colValues.get("is_validated"));
				
				//code validated 되지 않은 데이터
				if(colValues.get("is_validated") != null 
						&& colValues.get("is_validated").equals("N")){
					//1.색변경(살구색)
					style = "EDIT='FALSE' BGCOLOR='255,192,192'";
				//그룹핑 데이터
				}
				
				if(colValues.get("bl_no") == null 
						|| colValues.get("bl_no").equals("")){
					//1.두껍게
					//2.수정불가
					//3.Merge
					//4.색변경(그린)
					style = "BOLD='TRUE' EDIT='FALSE' BGCOLOR='0,192,0'";
					colValues.put("Seq","");
				}else{
					colValues.put("seq",""+seq);
					seq = seq + 1;
				}
				
				
				
				
				sbufXML.append("	<TR " + style + "><![CDATA[");
				//sbufXML.append("	<TR bgcolor='rgb(255,0,0)'><![CDATA[");
				int colCnt = realColNms.length;
				
				for (int j = 0 ; j < colCnt-1 ; j++) {
					sbufXML.append(getNull(colValues.get(realColNms[j])) + DELIMITER);
		        }
				sbufXML.append(getNull(colValues.get(realColNms[colCnt-1])) + "]]></TR>\n");
			}
		}else if(prefix.trim().equals("t3sheet1_")){
			sbufXML.append("<DATA COLORDER='" + JSPUtil.convertStringArrayToString(changedColNms, "|") + "' TOTAL='" + totCnt +"'>\n");
			for(int i=0;i<realCnt;i++){
				Map<String, String> colValues = vos.get(i).getColumnValues();
				
				
				sbufXML.append("	<TR>");
				//sbufXML.append("	<TR bgcolor='rgb(255,0,0)'><![CDATA[");
				int colCnt = realColNms.length;
				
				for (int j = 0 ; j < colCnt-1 ; j++) {
					StringBuffer styleBuf = new StringBuffer();
					//String cellValue = colValues.get(realColNms[j]);
					if(colValues.get("ib_cmdt_flg").equals("1")){
						styleBuf.append(" BOLD='TRUE' ");
					}
					
					if(colValues.get("is_validated").equals("Y")){						

						if(realColNms[j].equals("fax1")){
							if( "Y".equals(colValues.get("fax_snd_flg1"))) {
								styleBuf.append(" EDIT='TRUE'");
							}else{
								styleBuf.append(" EDIT='FALSE'");
							}
						}
						if(realColNms[j].equals("fax2")){
							if( "Y".equals(colValues.get("fax_snd_flg2"))) {
								styleBuf.append(" EDIT='TRUE'");
							}else{
								styleBuf.append(" EDIT='FALSE'");
							}
						}
						if(realColNms[j].equals("fax3")){
							if( "Y".equals(colValues.get("fax_snd_flg3"))) {
								styleBuf.append(" EDIT='TRUE'");
							}else{
								styleBuf.append(" EDIT='FALSE'");
							}
						}
						if(realColNms[j].equals("fax4")){
							if( "Y".equals(colValues.get("fax_snd_flg4"))) {
								styleBuf.append(" EDIT='TRUE'");
							}else{
								styleBuf.append(" EDIT='FALSE'");
							}
						}
						if(realColNms[j].equals("fax5")){
							if( "Y".equals(colValues.get("fax_snd_flg5"))) {
								styleBuf.append(" EDIT='TRUE'");
							}else{
								styleBuf.append(" EDIT='FALSE'");
							}
						}
						if(realColNms[j].equals("eml1")){
							if( "Y".equals(colValues.get("eml_snd_flg1"))) {
								styleBuf.append(" EDIT='TRUE'");
							}else{
								styleBuf.append(" EDIT='FALSE'");
							}
						}
						if(realColNms[j].equals("eml2")){
							if( "Y".equals(colValues.get("eml_snd_flg2"))) {
								styleBuf.append(" EDIT='TRUE'");
							}else{
								styleBuf.append(" EDIT='FALSE'");
							}
						}
						if(realColNms[j].equals("eml3")){
							if( "Y".equals(colValues.get("eml_snd_flg3"))) {
								styleBuf.append(" EDIT='TRUE'");
							}else{
								styleBuf.append(" EDIT='FALSE'");
							}
						}
						if(realColNms[j].equals("eml4")){
							if( "Y".equals(colValues.get("eml_snd_flg4"))) {
								styleBuf.append(" EDIT='TRUE'");
							}else{
								styleBuf.append(" EDIT='FALSE'");
							}
						}
						if(realColNms[j].equals("eml5")){
							if( "Y".equals(colValues.get("eml_snd_flg5"))) {
								styleBuf.append(" EDIT='TRUE'");
							}else{
								styleBuf.append(" EDIT='FALSE'");
							}
						}
					}else{
						if(realColNms[j].equals("fax1")){
							styleBuf.append(" EDIT='FALSE'");
						}
						if(realColNms[j].equals("fax2")){
							styleBuf.append(" EDIT='FALSE'");
						}
						if(realColNms[j].equals("fax3")){
							styleBuf.append(" EDIT='FALSE'");
						}
						if(realColNms[j].equals("fax4")){
							styleBuf.append(" EDIT='FALSE'");
						}
						if(realColNms[j].equals("fax5")){
							styleBuf.append(" EDIT='FALSE'");
						}
						if(realColNms[j].equals("eml1")){
							styleBuf.append(" EDIT='FALSE'");
						}
						if(realColNms[j].equals("eml2")){
							styleBuf.append(" EDIT='FALSE'");
						}
						if(realColNms[j].equals("eml3")){
							styleBuf.append(" EDIT='FALSE'");
						}
						if(realColNms[j].equals("eml4")){
							styleBuf.append(" EDIT='FALSE'");
						}
						if(realColNms[j].equals("eml5")){
							styleBuf.append(" EDIT='FALSE'");
						}
						styleBuf.append(" COLOR='255,192,192'");
					}
					
					
					sbufXML.append("<TD "+ styleBuf.toString() + "><![CDATA[");				
					sbufXML.append(colValues.get(realColNms[j]));
					sbufXML.append("]]></TD>");
		        }
				sbufXML.append(getNull(colValues.get(realColNms[colCnt-1])) + "</TR>\n");
			}
		}else if(prefix.trim().equals("t4sheet1_") ){
			sbufXML.append("<DATA COLORDER='" + JSPUtil.convertStringArrayToString(changedColNms, "|") + "' COLSEPARATOR='" + DELIMITER + "' TOTAL='" + totCnt +"'>\n");
			
			
			for(int i=0;i<realCnt;i++){
				Map<String, String> colValues = vos.get(i).getColumnValues();
				
				String style = "";
				//log.debug("-------------" + realColNms);
				//log.debug("-------------" + colValues.get("is_validated"));
				
				
				
				
				
				
				sbufXML.append("	<TR " + style + "><![CDATA[");
				//sbufXML.append("	<TR bgcolor='rgb(255,0,0)'><![CDATA[");
				int colCnt = realColNms.length;
				
				for (int j = 0 ; j < colCnt-1 ; j++) {
					sbufXML.append(getNull(colValues.get(realColNms[j])) + DELIMITER);
		        }
				sbufXML.append(getNull(colValues.get(realColNms[colCnt-1])) + "]]></TR>\n");
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