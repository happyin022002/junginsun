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
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import java.sql.SQLException;
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
 * @author
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class UserViewAdapter0381 extends ViewAdapter {

	
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
		
		sbufXML.append("<DATA COLORDER='" + JSPUtil.convertStringArrayToString(changedColNms, "|") + "' TOTAL='" + totCnt +"'>\n");
		
		

		for(int i=0;i<realCnt;i++){
			Map<String, String> colValues = vos.get(i).getColumnValues();
			
			
			sbufXML.append("	<TR>");
			//sbufXML.append("	<TR bgcolor='rgb(255,0,0)'><![CDATA[");
			int colCnt = realColNms.length;
			
			for (int j = 0 ; j < colCnt-1 ; j++) {
				StringBuffer style = new StringBuffer("");
				String cellValue = "";
				String prtValue = getNull(colValues.get(realColNms[j]));
				
				//FAX
				for(int k=1;k<6;k++){
					cellValue = colValues.get("fax_ntc_snd_rslt_cd"+k);//sheetObj.CellValue( i,"t1sheet1_" + "fax_ntc_snd_rslt_cd"+q);
					if(cellValue.equals("6") 
							&& realColNms[j].equals("fax_no"+k)){  // 실패,빨간색						
						style = new StringBuffer(" COLOR='255,0,0' ");
						style.append(" TOOL-TIP='" + colValues.get("fax_ntc_snd_rslt_nm"+k) + "' ");
						
				
					}else if(cellValue.equals("5") 
							&& realColNms[j].equals("fax_no"+k)){  // 성공,파란색						
						style = new StringBuffer(" COLOR='0,0,255' ");
						style.append(" TOOL-TIP='" + colValues.get("fax_ntc_snd_rslt_nm"+k) + "' ");
				
					}else if(cellValue.equals("") 
							&& realColNms[j].equals("fax_no"+k)){  // 검은색						
						style = new StringBuffer(" COLOR='0,0,0' ");
						style.append(" TOOL-TIP='" + colValues.get("fax_ntc_snd_rslt_nm"+k) + "' ");
				
					}else if(realColNms[j].equals("fax_no"+k)){// 진행중,핑크색
						style = new StringBuffer(" COLOR='255,0,192' ");
						//메시지를 입력함.
						style.append(" TOOL-TIP='" + colValues.get("fax_ntc_snd_rslt_nm"+k) + "' ");
				
					}
					
					
					
					cellValue = colValues.get("fax_snd_flg"+k);//sheetObj.CellValue( i,"t1sheet1_" + "fax_ntc_snd_rslt_cd"+q);
					
					if(cellValue != null && cellValue.equals("N")) {
						if(realColNms[j].equals("fax_evnt_flg"+k)){
							style.append( " EDIT='FALSE' ");
							prtValue = "0";
						}else if(realColNms[j].equals("fax_no"+k)){
							style.append( " EDIT='FALSE' ");							
						}
	
					}
				
					cellValue = colValues.get("eml_ntc_snd_rslt_cd"+k);//sheetObj.CellValue( i,"t1sheet1_" + "fax_ntc_snd_rslt_cd"+q);
					if(cellValue.equals("4") 
							&& realColNms[j].equals("ntc_eml"+k)){  // 실패,빨간색						
						style = new StringBuffer(" COLOR='255,0,0' ");
						style.append(" TOOL-TIP='" + colValues.get("eml_ntc_snd_rslt_nm"+k) + "' ");
				
					}else if(cellValue.equals("3") 
							&& realColNms[j].equals("ntc_eml"+k)){  // 성공,파란색						
						style = new StringBuffer(" COLOR='0,0,255' ");
						style.append(" TOOL-TIP='" + colValues.get("eml_ntc_snd_rslt_nm"+k) + "' ");
				
					}else if(cellValue.equals("") 
							&& realColNms[j].equals("ntc_eml"+k)){  // 검은색						
						style = new StringBuffer(" COLOR='0,0,0' ");
						style.append(" TOOL-TIP='" + colValues.get("eml_ntc_snd_rslt_nm"+k) + "' ");
				
					}else if(realColNms[j].equals("ntc_eml"+k)){// 진행중,핑크색
						style = new StringBuffer(" COLOR='255,0,192' ");
						style.append(" TOOL-TIP='" + colValues.get("eml_ntc_snd_rslt_nm"+k) + "' ");
				
					}
					
					cellValue = colValues.get("eml_snd_flg"+k);//sheetObj.CellValue( i,"t1sheet1_" + "fax_ntc_snd_rslt_cd"+q);
					if(cellValue != null && cellValue.equals("N")) {
						if(realColNms[j].equals("eml_evnt_flg"+k)){
							style.append( " EDIT='FALSE' ");
							prtValue = "0";
						}else if(realColNms[j].equals("ntc_eml"+k)){
							style.append( " EDIT='FALSE' ");							
						}
	
					}
				}		
				if(realColNms[j].equals("arr_prv_fom_cd")){
					if ("".equals(JSPUtil.getNull(colValues.get("arr_prv_fom_cd")))) {
						style.append( " EDIT='FALSE' ");
					}
				}
				if(realColNms[j].equals("locl_lang_flg")){
					if ("".equals(JSPUtil.getNull(colValues.get("locl_lang_flg")))) {
						style.append( " EDIT='FALSE' ");
					}
				}
				if(realColNms[j].equals("eclz_bl_cpy_flg")){
					if ("".equals(JSPUtil.getNull(colValues.get("eclz_bl_cpy_flg")))) {
						style.append( " EDIT='FALSE' ");
					}
				}
				
				
				sbufXML.append("<TD "+ style + "><![CDATA[");				
				sbufXML.append(prtValue);
				sbufXML.append("]]></TD>");
	        }
			
			sbufXML.append("<TD><![CDATA[");				
			sbufXML.append(getNull(colValues.get(realColNms[colCnt-1])));
			sbufXML.append("]]></TD></TR>\n");
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
