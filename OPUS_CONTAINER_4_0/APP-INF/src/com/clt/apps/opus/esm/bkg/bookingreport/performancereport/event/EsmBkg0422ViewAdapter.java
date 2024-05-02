/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0422ViewAdapter.java
*@FileTitle : General Cargo Manifest by VVD/PORT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.25 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event;

import java.util.List;
import java.util.Map;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Kim Gyoung Sub
 * @see ViewAdapter 참조
 * @since J2EE 1.6
 */
public class EsmBkg0422ViewAdapter extends ViewAdapter{

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
		String srNo     = "";
		String srNoTemp = "";
		
		sbufXML.append("\n<DATA TOTAL='").append(totCnt).append("'>\n");
		Map<String, String> colValues = null;
		for(int i=0;i<realCnt;i++){
			colValues = vos.get(i).getColumnValues();
			
			srNoTemp =colValues.get("sr_no");
			
			//이전 SR NO와 현재 데이타의 값이 틀리면 제목을 새로 생성한다.
			sbufXML.append("	<TR BGCOLOR='255,255,255'>\n");
			if(!srNo.equals(srNoTemp)){
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("seq")).append("]]></TD>\n");//seq
				if(colValues.get("sr_sts_cd") != null && colValues.get("sr_sts_cd").equals("SR")){              //read
					if(colValues.get("sr_knd_cd") != null && colValues.get("sr_knd_cd").equals("F")){
						sbufXML.append("		<TD>0</TD>\n");
					}else{
						sbufXML.append("		<TD>1</TD>\n");
					}
				}else{ 
					sbufXML.append("		<TD>1</TD>\n");
				}
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("sr_no")).append("]]></TD>\n"); //sr_no
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("sr_sts")).append("]]></TD>\n");//status
				
			}else{
				sbufXML.append("		<TD><![CDATA[]]></TD>\n");//seq
				sbufXML.append("		<TD>1</TD>\n"); //read
				sbufXML.append("		<TD><![CDATA[]]></TD>\n"); //sr_no
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("sr_sts")).append("]]></TD>\n");//status
			}
			
			if(colValues.get("return_cd") != null && colValues.get("return_cd").equals("R")){ //return '0'돋보기 이미지  1 블랭크 이미지
				sbufXML.append("		<TD IMAGE='0'><![CDATA[<<-]]></TD>\n");
			}else if(colValues.get("return_cd") != null && colValues.get("return_cd").equals("T")){ //return to return 
				sbufXML.append("		<TD IMAGE='1'><![CDATA[     ->>]]></TD>\n");
			}else{ 
				sbufXML.append("		<TD IMAGE='1'></TD>\n");
			}
			
			if(colValues.get("sr_kind") == null || colValues.get("sr_kind").equals("") || !colValues.get("sr_kind").equals("A")){ //amend
				sbufXML.append("		<TD>1</TD>\n");
			}else{ 
				sbufXML.append("		<TD>0</TD>\n");
			}
		
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("up_dt")).append("]]></TD>\n");//update
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("gmt_dt")).append("]]></TD>\n");//gmt_dt
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("pic_nm")).append("]]></TD>\n");//pic
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("pic_ofc_cd")).append("]]></TD>\n");//pic
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("message")).append("]]></TD>\n");//message
			
		   if(colValues.get("message") == null || colValues.get("message").equals("")){//message pop
				sbufXML.append("		<TD>1</TD>\n");
			}else{ 
				sbufXML.append("		<TD>0</TD>\n");
			}
		   sbufXML.append("		<TD><![CDATA[").append(colValues.get("sr_sts_cd")).append("]]></TD>\n");//message
		   sbufXML.append("		<TD><![CDATA[").append(colValues.get("return_cd")).append("]]></TD>\n");//message
		   sbufXML.append("		<TD><![CDATA[").append(colValues.get("sr_kind")).append("]]></TD>\n");//message
		   sbufXML.append("		<TD><![CDATA[").append(colValues.get("message_all")).append("]]></TD>\n");//message
		   sbufXML.append("		<TD><![CDATA[").append(colValues.get("sr_knd_cd")).append("]]></TD>\n");//message
		   sbufXML.append("		<TD><![CDATA[").append(colValues.get("sr_no")).append("]]></TD>\n"); //return_sr_no
		   sbufXML.append("		<TD><![CDATA[").append(colValues.get("img_file_real_path")).append("]]></TD>\n"); //img_file_path_ctnt
		   sbufXML.append("		<TD><![CDATA[").append(colValues.get("img_file_nm")).append("]]></TD>\n"); //img_file_nm
		   sbufXML.append("		<TD><![CDATA[").append(colValues.get("sr_his_seq")).append("]]></TD>\n"); //sr_his_seq
		   sbufXML.append("	</TR>\n");
		   sbufXML.append("	\n");
		   srNo = srNoTemp;
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