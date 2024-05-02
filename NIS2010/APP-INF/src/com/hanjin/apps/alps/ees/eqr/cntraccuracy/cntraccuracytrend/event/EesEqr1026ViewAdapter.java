/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName 			: EesEqr1026ViewAdapter.java
*@FileTitle 		: Discharging result
*@LastModifyDate 	: 2013.07.11
*@LastModifier 		: SHIN DONG IL
*@LastVersion 		: 1.0
* 2013.07.11 SHIN DONG IL
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.cntraccuracy.cntraccuracytrend.event;

import java.sql.SQLException;
import java.util.List;
 
import com.hanjin.apps.alps.ees.eqr.cntrcommon.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.cntraccuracy.cntraccuracytrend.vo.EesEqr1026ConditionVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * @author SHIN DONG IL
 * @see ViewAdapter 참조
 * @since 2013.06.10
 */
public class EesEqr1026ViewAdapter extends ViewAdapter {
	
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
		
		CommonRsVO commonRsVO = (CommonRsVO) vos.get(0);
		
		EesEqr1026ConditionVO conditionVO = (EesEqr1026ConditionVO) commonRsVO.getConditionVO();

		DBRowSet rs = commonRsVO.getDbRowset();
		
		int totCnt  = vos.size();
		
		String[] cntr_tp_sz = ((conditionVO.getCntrTpszCd()).toLowerCase()).split(",");
		
		String sort_flag    = "";
		String col_nm 		= "";
		String bgColor		= "";
		String rowBgColor	= "";
		
		sbufXML.append("<DATA TOTAL='" + totCnt + "'>\n");
		
		try{
			while ( rs.next() ){
				sort_flag = getNull(rs.getString("sort_flag"));
				bgColor= "BGCOLOR=\"0,0,0\" ";

				if(sort_flag.equals("2") || sort_flag.equals("4") || sort_flag.equals("6") || sort_flag.equals("8")){
					rowBgColor = "BGCOLOR=\"213,213,213\" ";					
				}else{
					rowBgColor = "BGCOLOR=\"0,0,0\" ";
				}
				
				sbufXML.append("<TR>");
				
				if(rs.getString("trd_cd").equals("ZTTL")) {
					sbufXML.append("	<TD "+bgColor+" >TTL</TD>");
				}else {
					sbufXML.append("	<TD "+bgColor+" >" + getNull(rs.getString("trd_cd"))      	+ "</TD>");
				}
				
				sbufXML.append("	<TD "+bgColor+" >" + getNull(rs.getString("sub_trd_cd"))     + "</TD>");
				
				if(rs.getString("slan_cd").equals("ZTTL")) {
					sbufXML.append("	<TD "+bgColor+" >TTL</TD>");
				}else {
					sbufXML.append("	<TD "+bgColor+" >" + getNull(rs.getString("slan_cd"))      	+ "</TD>");
				}
				
				sbufXML.append("	<TD "+bgColor+" ><![CDATA[" + getNull(rs.getString("week")) 	+ "]]></TD>");
				
					sbufXML.append("	<TD "+bgColor+" >" + getNull(rs.getString("vvd"))        	+ "</TD>");	

					
				sbufXML.append("	<TD "+rowBgColor+" >" + getNull(rs.getString("yd_cd"))      + "</TD>");
				
				sbufXML.append("	<TD "+rowBgColor+" >" + getNull(rs.getString("d_ttl"))     + "</TD>");
				
				for(int i=0;i<cntr_tp_sz.length;i++){	//MT Plan(A) Container Type/Size
					col_nm = "d_"+cntr_tp_sz[i];
					sbufXML.append("	<TD "+rowBgColor+" >" + getNull(rs.getString(col_nm))       + "</TD>");
				}

				sbufXML.append("	<TD "+rowBgColor+" >" + getNull(rs.getString("l_ttl"))      + "</TD>");
								
				for(int i=0;i<cntr_tp_sz.length;i++){	//MT Booking(B) Container Type/Size
					col_nm = "l_"+cntr_tp_sz[i];
					sbufXML.append("	<TD "+rowBgColor+" >" + getNull(rs.getString(col_nm))        	+ "</TD>");
				}					
				
				sbufXML.append("	<TD "+rowBgColor+" FontColor=\"0,0,255\" BOLD=\"TRUE\" >" + getNull(rs.getString("df_ttl_a"))     + "</TD>");
				
				for(int i=0;i<cntr_tp_sz.length;i++){	//Diff(A-B) Container Type/Size
					col_nm = "df_"+cntr_tp_sz[i]+"_a";
					sbufXML.append("	<TD "+rowBgColor+" FontColor=\"0,0,255\" BOLD=\"TRUE\" >" + getNull(rs.getString(col_nm))        		+ "</TD>");
				}

				sbufXML.append("	<TD "+rowBgColor+" >" + getNull(rs.getString("p_ttl"))     	+ "</TD>");
				
				for(int i=0;i<cntr_tp_sz.length;i++){	// Full BKG Lodg
					col_nm = "p_"+cntr_tp_sz[i];
					sbufXML.append("	<TD "+rowBgColor+" >" + getNull(rs.getString(col_nm))        		+ "</TD>");
				}
				
				sbufXML.append("	<TD "+rowBgColor+" FontColor=\"0,0,255\" BOLD=\"TRUE\" >" + getNull(rs.getString("df_ttl_b"))     	+ "</TD>");
				
				for(int i=0;i<cntr_tp_sz.length;i++){	// Full BKG Disch
					col_nm = "df_"+cntr_tp_sz[i]+"_b";
					sbufXML.append("	<TD "+rowBgColor+" FontColor=\"0,0,255\" BOLD=\"TRUE\" >" + getNull(rs.getString(col_nm))        		+ "</TD>");
				}

				
				sbufXML.append("	<TD></TD>");
				sbufXML.append("	<TD>" + getNull(rs.getString("sort_flag"))        	+ "</TD>");
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
	 * DBRowSet를 Parsing하여 <DATA>태그를 생성한다.<br>
	 * IBSheet의 prefix값이 있는 경우 COLORDER에 prefix를 붙인 column명으로 표시해 준다.<br>
	 * 
	 * @param DBRowSet rs		VO객체
	 * @param String prefix		IBSheet savename's prefix string
	 * @return String IBSheet 	DATA 태그
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
	 * @param DBRowSet rs 		VO객체
	 * @return String 	IBSheet DATA 태그
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