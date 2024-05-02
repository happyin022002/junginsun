/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0107ViewAdapter.java
*@FileTitle : EsdTpb0107ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 최 선
*@LastVersion : 1.1
* 2009.09.04 Sun, CHOI	1.0	최초 생성
* 2009.09.04 Sun, CHOI	1.1 ALPS Migration
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.outstandinggroupmanage.event;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.layer.integration.DAOException;

/**
 * ESD_TPB_0107 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0107HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Sun, Choi
 * @see ESD_TPB_0107HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdTpb0107ViewAdapter extends ViewAdapter {
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param List<AbstractValueObject> vos
	 * @param String prefix
	 * @return String
	 */
	public String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		StringBuilder sbufXML = new StringBuilder();
		
		int totCnt = vos.size();
		int realCnt = vos.size();

		AbstractValueObject vo = (AbstractValueObject)vos.get(0);

		if(vo.getMaxRows()>0){
			totCnt = vo.getMaxRows();
		} 
		
		Map<String, String> colValues = null;
		
		if(realCnt>0){
			colValues = vos.get(0).getColumnValues();
		}
				
		//TOTAL 개수 조정
		sbufXML.append("<DATA TOTAL='").append(totCnt).append("'>\n");

		int grp_srt_no = 0;
		String before_tpb_no = "";
		String now_tpb_no = "";
		
		for(int j = 0 ; j < realCnt ; j++){
			
			colValues = vos.get(j).getColumnValues();

			sbufXML.append("<TR>\n");
			sbufXML.append("	<TD></TD>\n");
			sbufXML.append("	<TD>R</TD>\n");

			now_tpb_no = JSPUtil.getNull(colValues.get("n3pty_no_org"));

			if ( now_tpb_no.length() > 0 && !before_tpb_no.equals(now_tpb_no)){
				grp_srt_no++ ; 
			} 
			before_tpb_no = now_tpb_no;
			
			if ( now_tpb_no.length() > 0 ) {
				sbufXML.append("<TD><![CDATA[").append(grp_srt_no).append("]]></TD>\n");
				sbufXML.append("<TD><![CDATA[").append(grp_srt_no).append("]]></TD>\n");
			} else {
				sbufXML.append("<TD EDIT='false'></TD>\n");
				sbufXML.append("<TD EDIT='false'></TD>\n");
			}
			
			sbufXML.append("	<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("ots_dtl_seq"))).append("]]></TD>\n");
			sbufXML.append("	<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("n3pty_no_org"))).append("]]></TD>\n");
			sbufXML.append("	<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("n3pty_no_dp_seq_org"))).append("]]></TD>\n");
			sbufXML.append("	<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("n3pty_no"))).append("]]></TD>\n");  
			sbufXML.append("	<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("n3pty_no_dp_seq"))).append("]]></TD>\n");   
			sbufXML.append("	<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("n3pty_expn_tp_cd"))).append("]]></TD>\n");  
			sbufXML.append("	<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("n3pty_bil_tp_cd"))).append("]]></TD>\n");    
			sbufXML.append("	<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("n3pty_bil_tp_nm"))).append("]]></TD>\n");     
			sbufXML.append("	<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("n3pty_src_no"))).append("]]></TD>\n");   
			sbufXML.append("	<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("bkg_no_all"))).append("]]></TD>\n");
			sbufXML.append("	<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("bl_no_all"))).append("]]></TD>\n"); 
			sbufXML.append("	<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("rev_vvd"))).append("]]></TD>\n");  
			sbufXML.append("	<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("act_vvd"))).append("]]></TD>\n");   
			sbufXML.append("	<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("csr_no"))).append("]]></TD>\n");   
			sbufXML.append("	<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("gl_month"))).append("]]></TD>\n");  
			sbufXML.append("	<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("eq_no"))).append("]]></TD>\n");  
			sbufXML.append("	<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("trd_party_code"))).append("]]></TD>\n");  
			sbufXML.append("	<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("trd_party_name"))).append("]]></TD>\n");  
			sbufXML.append("	<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("ots_sts_nm"))).append("]]></TD>\n");  
			sbufXML.append("	<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("candidate_yn"))).append("]]></TD>\n");  
			sbufXML.append("	<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("roc_candidate_yn"))).append("]]></TD>\n");  
			sbufXML.append("	<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("cfm_curr_cd"))).append("]]></TD>\n");
			sbufXML.append("	<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("cfm_amt"))).append("]]></TD>\n");

			sbufXML.append("</TR>\n");
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
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new RuntimeException(se.getMessage());
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
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new RuntimeException(se.getMessage());
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