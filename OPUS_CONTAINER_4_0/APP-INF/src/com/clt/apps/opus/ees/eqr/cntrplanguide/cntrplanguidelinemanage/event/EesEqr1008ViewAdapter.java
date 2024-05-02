/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrPlanGuidelineManageDBDAO.java
*@FileTitle : Container Guideline Manage
*@LastModifyDate : 2013.05.27
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2013.05.27 SHIN DONG IL
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelinemanage.event;

import java.sql.SQLException;
import java.util.List;

import com.clt.apps.opus.ees.eqr.cntrcommon.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelinemanage.vo.EesEqr1008ConditionVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * @author SHIN DONG IL
 * @see ViewAdapter 참조
 * @since 2013.06.10
 */
public class EesEqr1008ViewAdapter extends ViewAdapter {
	
	/**
	 * VO List를 Parsing하여 Data태그 부분의 XML문자열을 반환한다.<br>
	 * @param vos List<AbstractValueObject> List 객체
	 * @param colOrder String[] Column명 문자열 
	 * @param prefix String IBSheet savename's prefix
	 * @return String Data태그 부분의 XML문자열
	 * @exception 
	 */	
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		StringBuilder sbufXML = new StringBuilder();
		
		CommonRsVO commonRsVO = (CommonRsVO) vos.get(0);
		
		EesEqr1008ConditionVO conditionVO = (EesEqr1008ConditionVO) commonRsVO.getConditionVO();

		DBRowSet rs = commonRsVO.getDbRowset();
		
		int totCnt  = vos.size();
		
		String[] cntr_tp_sz = conditionVO.getCntrTpszCd().split(",");
		
		String sort_id      = null;
		String cfm_flg    	= "N";
		String main_page 	=  conditionVO.getMainPage();

		String rowBgColor	= "";
		String fontColor 	= "COLOR=\"RED\" ";
		String fontBold  	= "BOLD=\"FALSE\" ";
		String colEdit   	= "EDIT=\"FALSE\" ";
		
		sbufXML.append("<DATA TOTAL='" + totCnt + "'>\n");
		
		try{
			while ( rs.next() ){
				rowBgColor	= "BGCOLOR=\"228,247,186\" ";
				sort_id = getNull(rs.getString("sort_id"));
				cfm_flg = getNull(rs.getString("cfm_flg"));
				
				sbufXML.append("<TR>");
				sbufXML.append("	<TD "+rowBgColor+">" + getNull(rs.getString("trd_cd"))        	+ "</TD>");
				sbufXML.append("	<TD "+rowBgColor+">" + getNull(rs.getString("sub_trd_cd"))      + "</TD>");
				sbufXML.append("	<TD "+rowBgColor+">" + getNull(rs.getString("vsl_lane_cd"))     + "</TD>");
				sbufXML.append("	<TD "+rowBgColor+">" + getNull(rs.getString("eq_gline_seq"))    + "</TD>");
				sbufXML.append("	<TD "+rowBgColor+">" + getNull(rs.getString("vvd"))        		+ "</TD>");
				sbufXML.append("	<TD "+rowBgColor+">" + getNull(rs.getString("pol_cd"))        	+ "</TD>");
				sbufXML.append("	<TD "+rowBgColor+">" + getNull(rs.getString("eta_dt"))        	+ "</TD>");
				
				if(cfm_flg.equals("Y")||main_page.equals("false")){
					colEdit   	= "EDIT=\"FALSE\" ";					
				}else{
					colEdit   	= "EDIT=\"TRUE\" ";
				}
				
				if(cfm_flg.equals("Y")){
					rowBgColor	= "BGCOLOR=\"228,247,186\" ";	
				}else{
					rowBgColor	= "BGCOLOR=\"255,255,255\" ";	
				}
				
				if(getNull(rs.getString("old_repo_gline_rmk")).equals("O")){
					fontColor 	= "COLOR=\"RED\" ";
					fontBold  	= "BOLD=\"TRUE\" ";					
				}else if(getNull(rs.getString("old_repo_gline_rmk")).equals("S")){
					fontColor 	= "COLOR=\"BLACK\" ";
					fontBold  	= "BOLD=\"FALSE\" ";					
				}else if(getNull(rs.getString("old_repo_gline_rmk")).equals("D")){
					fontColor 	= "COLOR=\"RED\" ";	
					fontBold  	= "BOLD=\"TRUE\" ";					
				}

				sbufXML.append("	<TD "+rowBgColor + fontColor + fontBold + colEdit+"><![CDATA[" + getNull(rs.getString("repo_gline_rmk"))    + "]]></TD>");
				
				colEdit   	= "EDIT=\"FALSE\" ";
				rowBgColor	= "BGCOLOR=\"250,224,212\" ";
				fontColor 	= "COLOR=\"BLACK\" ";
				fontBold  	= "BOLD=\"FALSE\" ";
				sbufXML.append("	<TD "+rowBgColor + fontColor + fontBold + colEdit+">" + getNull(rs.getString("pod_cd"))        	+ "</TD>");
				
			//Container Type Size 종류만큼 qty, unit 컬럼을 생성한다.
			for(int i=0;i<cntr_tp_sz.length;i++){
				String col_qty 		=  cntr_tp_sz[i]+"_qty";
				String col_ut 		=  cntr_tp_sz[i]+"_ut";
				String old_col_qty 	=  "old_"+cntr_tp_sz[i]+"_qty";
				String old_col_ut 	=  "old_"+cntr_tp_sz[i]+"_ut";
				
				if(sort_id.equals("1")||cfm_flg.equals("Y")|| main_page.equals("false")){
					colEdit   	= "EDIT=\"FALSE\" ";					
				}else{
					colEdit   	= "EDIT=\"TRUE\" ";
				}
				
				// CNTR TY/SZ QTY 
				//rowBgColor	= "BGCOLOR=\"255.216.216\" ";
				if(cfm_flg.equals("Y")){
					rowBgColor	= "BGCOLOR=\"250,236,197\" ";			
				}else{
					rowBgColor	= "BGCOLOR=\"255.255.255\" ";
				}

				if(getNull(rs.getString(old_col_qty)).equals("O")){ 
					fontColor 	= "COLOR=\"RED\" ";
					fontBold  	= "BOLD=\"TRUE\" ";
				}else if(getNull(rs.getString(old_col_qty)).equals("S")){
					fontColor 	= "COLOR=\"BLACK\" ";
					fontBold  	= "BOLD=\"FALSE\" ";
				}else if(getNull(rs.getString(old_col_qty)).equals("D")){
					fontColor 	= "COLOR=\"RED\" ";	
					fontBold  	= "BOLD=\"TRUE\" ";
				}

				sbufXML.append("	<TD "+rowBgColor + fontColor + fontBold + colEdit+">" + getNull(rs.getString(col_qty))        		+ "</TD>");
				
				if(cfm_flg.equals("Y")|| main_page.equals("false")){
					colEdit   	= "EDIT=\"FALSE\" ";					
				}else{
					colEdit   	= "EDIT=\"TRUE\" ";
				}
				
				// CNTR TY/SZ QTY Unit 
				if(getNull(rs.getString(old_col_ut)).equals("O")){ 
					fontColor 	= "COLOR=\"RED\" ";
					fontBold  	= "BOLD=\"TRUE\" ";
				}else if(getNull(rs.getString(old_col_ut)).equals("S")){
					fontColor 	= "COLOR=\"BLACK\" ";
					fontBold  	= "BOLD=\"FALSE\" ";
				}else if(getNull(rs.getString(old_col_ut)).equals("D")){
					fontColor 	= "COLOR=\"RED\" ";	
					fontBold  	= "BOLD=\"TRUE\" ";
				}
				
				sbufXML.append("	<TD "+rowBgColor + fontColor + fontBold + colEdit+">" + getNull(rs.getString(col_ut))        		+ "</TD>");
				
			}//end for(int i=0;i<cntr_tp_sz.length;i++)
				colEdit   	= "EDIT=\"FALSE\" ";
				rowBgColor	= "BGCOLOR=\"228,247,186\" ";
				fontColor 	= "COLOR=\"BLACK\" ";
				fontBold  	= "BOLD=\"FALSE\" ";

				sbufXML.append("	<TD "+rowBgColor + fontColor + fontBold + colEdit+">" + getNull(rs.getString("eff_end_dt"))        	+ "</TD>");
				
				if(sort_id.equals("1")) {//Guideline Header일 경우
					if(main_page.equals("true")){//Guideline Creation화면일 경우
						colEdit   	= "EDIT=\"TRUE\" ";
						sbufXML.append("	<TD  EDIT=\"TRUE\" DATA-TYPE=\"dtCheckBox\">" + getNull(rs.getString("cfm_flg"))  + "</TD>");						
					}else{//Guideline Inquery 화면일 경우
						colEdit   	= "EDIT=\"FALSE\" ";
						rowBgColor	= "BGCOLOR=\"250,224,212\" ";
						sbufXML.append("	<TD  EDIT=\"FALSE\" DATA-TYPE=\"dtCheckBox\">" + getNull(rs.getString("cfm_flg"))      + "</TD>");
					}

				}else{
					sbufXML.append("	<TD "+rowBgColor+" EDIT=\"FALSE\" DATA-TYPE=\"dtData\"></TD>");
				}				
				colEdit   	= "EDIT=\"FALSE\" ";
				rowBgColor	= "BGCOLOR=\"228,247,186\" ";
				sbufXML.append("	<TD "+rowBgColor + fontColor + fontBold + colEdit+">" + getNull(rs.getString("upd_dt"))        		+ "</TD>");
				sbufXML.append("	<TD "+rowBgColor + fontColor + fontBold + colEdit+">" + getNull(rs.getString("upd_usr_nm"))        	+ "</TD>");
				
				sbufXML.append("	<TD>" + getNull(rs.getString("eff_st_dt"))        	+ "</TD>");
				sbufXML.append("	<TD>" + getNull(rs.getString("upd_usr_id"))        	+ "</TD>");
				sbufXML.append("	<TD>" + getNull(rs.getString("vsl_cd"))        		+ "</TD>");
				sbufXML.append("	<TD>" + getNull(rs.getString("skd_voy_no"))       	+ "</TD>");
				sbufXML.append("	<TD>" + getNull(rs.getString("skd_dir_cd"))        	+ "</TD>");
				sbufXML.append("	<TD>" + getNull(rs.getString("sort_id"))        	+ "</TD>");
				sbufXML.append("	<TD></TD>");
				
				sbufXML.append("</TR>\n");
			}
		} catch(SQLException ex){
			throw new RuntimeException(ex.getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}	
		sbufXML.append("</DATA>\n");
		
		return sbufXML.toString();
	}

	/**
	 * DBRowSet를 Parsing하여 DATA태그를 생성한다.<br>
	 * IBSheet의 prefix값이 있는 경우 COLORDER에 prefix를 붙인 column명으로 표시해 준다.<br>
	 * @param rs DBRowSet 		VO객체
	 * @param prefix String 		IBSheet savename's prefix string
	 * @return String IBSheet 		DATA태그
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
	 * @param DBRowSet rs		VO객체
	 * @return String 	IBSheet DATA태그
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