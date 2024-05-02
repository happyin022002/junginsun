/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName 			: EesEqr1025ViewAdapter.java
*@FileTitle 		: Loading Trend by Lane
*@LastModifyDate 	: 2013.07.11
*@LastModifier 		: 
*@LastVersion 		: 
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntraccuracy.cntraccuracytrend.event;

import java.sql.SQLException;
import java.util.List;

import com.clt.apps.opus.ees.eqr.cntrcommon.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.cntraccuracy.cntraccuracytrend.vo.EesEqr1025ConditionVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;

/**
 *  IBSheet XML <br>
 * @author 
 * @see ViewAdapter 
 * @since 2013.06.10
 */
public class EesEqr1025ViewAdapter extends ViewAdapter {
	
	/**
	 * VO List Parsing.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 
	 * @param colOrder String[] Column 
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>
	 * @exception 
	 */	
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		StringBuilder sbufXML = new StringBuilder();
		
		CommonRsVO commonRsVO = (CommonRsVO) vos.get(0);
		
		EesEqr1025ConditionVO conditionVO = (EesEqr1025ConditionVO) commonRsVO.getConditionVO();

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
				sort_flag = getNull(rs.getString("sort_flg"));				
				bgColor   = "BGCOLOR=\"0,0,0\" ";

				if(sort_flag.equals("1") || sort_flag.equals("3") || sort_flag.equals("5") || sort_flag.equals("7") ){
					rowBgColor= "BGCOLOR=\"0,0,0\" ";
								
				}else{
					rowBgColor= "BGCOLOR=\"213,213,213\" ";		
				}
				
				sbufXML.append("<TR>");
				sbufXML.append("	<TD "+bgColor+" >T</TD>");
				
				if(rs.getString("sub_trd_cd").equals("ZTTL")) { 
					sbufXML.append("	<TD "+bgColor+" >TTL</TD>");
				}else {
					sbufXML.append("	<TD "+bgColor+" >" + getNull(rs.getString("sub_trd_cd"))      	+ "</TD>");
				}				

				sbufXML.append("	<TD "+bgColor+" >" + getNull(rs.getString("slan_cd"))    + "</TD>");
				
				if(rs.getString("week").equals("999999")) { 
					sbufXML.append("	<TD "+bgColor+" >TTL</TD>"); 
				}else {
					sbufXML.append("	<TD "+bgColor+" ><![CDATA[" + getNull(rs.getString("week")) 	+ "]]></TD>");
				}
				
				sbufXML.append("	<TD "+bgColor+" >" + getNull(rs.getString("vvd"))        	+ "</TD>");
				

				sbufXML.append("	<TD "+rowBgColor+" >" + getNull(rs.getString("yd_cd"))      + "</TD>");
				sbufXML.append("	<TD "+rowBgColor+" >" + getNull(rs.getString("vps_eta_dt"))    		+ "</TD>");
				sbufXML.append("	<TD "+rowBgColor+" >" + getNull(rs.getString("vps_etd_dt"))    		+ "</TD>");
				sbufXML.append("	<TD "+rowBgColor+" >" + getNull(rs.getString("fcbf_dt")) 		+ "</TD>");
				
				sbufXML.append("	<TD "+rowBgColor+" >" + getNull(rs.getString("p_teu"))    + "</TD>");
				sbufXML.append("	<TD "+rowBgColor+" >" + getNull(rs.getString("p_box"))    + "</TD>");

				for(int i=0;i<cntr_tp_sz.length;i++){	//MT Plan(A) Container Type/Size
					col_nm = "p_"+cntr_tp_sz[i];
					sbufXML.append("	<TD "+rowBgColor+" >" + getNull(rs.getString(col_nm))       + "</TD>");
				}

				sbufXML.append("	<TD "+rowBgColor+" >" + getNull(rs.getString("p_wgt"))     + "</TD>");
				
				sbufXML.append("	<TD "+rowBgColor+" >" + getNull(rs.getString("m_teu"))     + "</TD>");				
				sbufXML.append("	<TD "+rowBgColor+" >" + getNull(rs.getString("m_box"))     + "</TD>");
				
				for(int i=0;i<cntr_tp_sz.length;i++){	//MT Booking(B) Container Type/Size
					col_nm = "m_"+cntr_tp_sz[i];
					sbufXML.append("	<TD "+rowBgColor+" >" + getNull(rs.getString(col_nm))        	+ "</TD>");
				}
				
				sbufXML.append("	<TD "+rowBgColor+" >" + getNull(rs.getString("m_wgt"))      + "</TD>");
				
				sbufXML.append("	<TD "+rowBgColor+" FontColor=\"0,0,255\" BOLD=\"TRUE\" >" + getNull(rs.getString("df_teu_a"))     	  + "</TD>");
				sbufXML.append("	<TD "+rowBgColor+" FontColor=\"0,0,255\" BOLD=\"TRUE\" >" + getNull(rs.getString("df_box_a"))     	  + "</TD>");
				
				for(int i=0;i<cntr_tp_sz.length;i++){	//Diff(A-B) Container Type/Size
					col_nm = "df_"+cntr_tp_sz[i]+"_a";
					sbufXML.append("	<TD "+rowBgColor+" FontColor=\"0,0,255\" BOLD=\"TRUE\" >" + getNull(rs.getString(col_nm))        		+ "</TD>");
				}
				
				sbufXML.append("	<TD "+rowBgColor+" >" + getNull(rs.getString("f_l_teu"))     + "</TD>");
				sbufXML.append("	<TD "+rowBgColor+" >" + getNull(rs.getString("f_l_box"))     + "</TD>");
				
				
				for(int i=0;i<cntr_tp_sz.length;i++){	// Full BKG Lodg
					col_nm = "f_l_"+cntr_tp_sz[i];
					sbufXML.append("	<TD "+rowBgColor+" >" + getNull(rs.getString(col_nm))        		+ "</TD>");
				}

				sbufXML.append("	<TD "+rowBgColor+" >" + getNull(rs.getString("f_l_wgt"))     	+ "</TD>");
				
				sbufXML.append("	<TD "+rowBgColor+" >" + getNull(rs.getString("f_a_wgt"))     	+ "</TD>");
				
				sbufXML.append("	<TD "+rowBgColor+" >" + getNull(rs.getString("f_d_teu"))     	+ "</TD>");
				sbufXML.append("	<TD "+rowBgColor+" >" + getNull(rs.getString("f_d_box"))     	+ "</TD>");
				
				for(int i=0;i<cntr_tp_sz.length;i++){	// Full BKG Disch
					col_nm = "f_d_"+cntr_tp_sz[i];
					sbufXML.append("	<TD "+rowBgColor+" >" + getNull(rs.getString(col_nm))        		+ "</TD>");
				}

				sbufXML.append("	<TD "+rowBgColor+" >" + getNull(rs.getString("f_d_wgt"))     	+ "</TD>");
				
				if(sort_flag.equals("8") || sort_flag.equals("4") || sort_flag.equals("2") ){ 
					sbufXML.append("	<TD "+rowBgColor+" ></TD>");				
					sbufXML.append("	<TD "+rowBgColor+" ></TD>");
					sbufXML.append("	<TD "+rowBgColor+" ></TD>");
					
					sbufXML.append("	<TD "+rowBgColor+" ></TD>");
					sbufXML.append("	<TD "+rowBgColor+" ></TD>");
					sbufXML.append("	<TD "+rowBgColor+" ></TD>");
					sbufXML.append("	<TD "+rowBgColor+" ></TD>");
					sbufXML.append("	<TD "+rowBgColor+" ></TD>");
					
				}else {
					sbufXML.append("	<TD "+rowBgColor+" >" + getNull(rs.getString("void"))     		+ "</TD>");				
					sbufXML.append("	<TD "+rowBgColor+" >" + getNull(rs.getString("bsa_teu"))     	+ "</TD>");
					sbufXML.append("	<TD "+rowBgColor+" >" + getNull(rs.getString("bsa_wgt"))     	+ "</TD>");
					
					sbufXML.append("	<TD "+rowBgColor+" >" + getNull(rs.getString("lf_fd"))     		+ "%</TD>");
					sbufXML.append("	<TD "+rowBgColor+" >" + getNull(rs.getString("lf_f_teu"))     	+ "%</TD>");
					sbufXML.append("	<TD "+rowBgColor+" >" + getNull(rs.getString("lf_f_wgt"))     	+ "%</TD>");
					sbufXML.append("	<TD "+rowBgColor+" >" + getNull(rs.getString("lf_t_teu"))     	+ "%</TD>");
					sbufXML.append("	<TD "+rowBgColor+" >" + getNull(rs.getString("lf_t_wgt"))     	+ "%</TD>");						
					
				}
				
				sbufXML.append("	<TD "+rowBgColor+" >" + getNull(rs.getString("type1"))     + "</TD>");
				sbufXML.append("	<TD "+rowBgColor+" >" + getNull(rs.getString("type2"))     + "</TD>");
				sbufXML.append("	<TD "+rowBgColor+" >" + getNull(rs.getString("pln_rsn_rmk"))     	+ "</TD>");
				
				sbufXML.append("	<TD>" + getNull(rs.getString("sort_flg"))        	+ "</TD>");
				sbufXML.append("	<TD>" + getNull(rs.getString("clpt_seq"))        	+ "</TD>");
				
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
	 * DBRowSet를 Parsing<br>
	 * @param DBRowSet rs 		VO
	 * @param String prefix 	IBSheet savename's prefix string
	 * @return String IBSheet 	DATA 
	 * @exception 
	 */
	protected String makeDataTag(DBRowSet rs,String prefix) {
		StringBuilder sb = new StringBuilder();
		
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
	 * Pivot Table<br>
	 * 
	 * @param rs			DBRowSet 		VO
	 * @return String 	IBSheet 			<DATA>
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