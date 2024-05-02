/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0186ViewAdapter.java
 *@FileTitle : AncsManifestListDownload
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.20
 *@LastModifier : 정재엽
 *@LastVersion : 1.0
 * 2009.05.20 정재엽
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.event;

import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;

/**
 * 다중라인을 보여주기 위한 ViewAdapter.
 * 
 * @author jae yoeb jeong
 * @see ESM_BKG_0045HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0186ViewAdapter extends ViewAdapter {

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
		
		//int totCnt = vos.size();
		int realCnt = vos.size();

		//AbstractValueObject vo = (AbstractValueObject)vos.get(0);
		//String[] realColNms=getColHeader(vo);
		//String[] changedColNms = getChangedColNms(realColNms, prefix);
		
		//if(vo.getMaxRows()>0){
		//	totCnt = vo.getMaxRows();
		//}
		/**
		 * <DATA COLORDER='ref_seq|anr_decl_no|edi_snd_usr_id|rcv_dt|snd_ofc_cd|vvd_nm|edi_snd_sts_cd|snd_dt|pagerows|vvd|ibflag|svc_rqst_no|err|edi_rcv_sts_cd|' COLSEPARATOR='~~' TOTAL='7'>
	<TR><![CDATA[1~~302543L9149744~~03206019~~2008-08-22 18:20:00.0~~ANRBS~~NAJRAN~~O~~2008-08-22 18:13:29.0~~~~AENA0052W~~~~302543~~/~~]]></TR>
	<TR><![CDATA[2~~302543L9149744~~03206019~~2008-08-22 18:20:00.0~~ANRBS~~NAJRAN~~O~~2008-08-22 18:13:30.0~~~~AENA0052W~~~~302543~~/~~]]></TR>
	<TR><![CDATA[3~~302543L9149744~~03206019~~2008-08-22 18:20:00.0~~ANRBS~~NAJRAN~~O~~2008-08-22 18:13:31.0~~~~AENA0052W~~~~302543~~/~~]]></TR>
	<TR><![CDATA[4~~302543L9149744~~03206019~~2008-08-22 18:20:02.0~~ANRBS~~NAJRAN~~O~~2008-08-22 18:13:31.0~~~~AENA0052W~~~~302543~~/~~]]></TR>
	<TR><![CDATA[5~~302543L9149744~~03206019~~2008-08-22 18:20:08.0~~ANRBS~~NAJRAN~~O~~2008-08-22 18:13:32.0~~~~AENA0052W~~~~302543~~/~~]]></TR>
	<TR><![CDATA[6~~302543L9149744~~03206019~~2008-08-22 18:20:02.0~~ANRBS~~NAJRAN~~O~~2008-08-22 18:13:33.0~~~~AENA0052W~~~~302543~~/~~]]></TR>
	<TR><![CDATA[7~~302543L9149744~~03206019~~2008-08-22 18:20:07.0~~ANRBS~~NAJRAN~~O~~2008-08-22 18:13:33.0~~~~AENA0052W~~~~302543~~/~~]]></TR>
</DATA>
		 */
		
		sbufXML.append("<DATA>\n");
		/*
		for(int i=0;i<realCnt;i++){
			Map<String, String> colValues = vos.get(i).getColumnValues();
			
			sbufXML.append("	<TR><![CDATA[");
			int colCnt = realColNms.length;
			
			for (int j = 0 ; j < colCnt-1 ; j++) {
				sbufXML.append(JSPUtil.getNull(colValues.get(realColNms[j])) + DELIMITER);
	        }
			sbufXML.append(JSPUtil.getNull(colValues.get(realColNms[colCnt-1])) + "]]></TR>\n");
		}
		*/
		for(int i=0;i<realCnt;i++){
			Map<String, String> colValues = vos.get(i).getColumnValues();
			
			//int colCnt = realColNms.length;
			
			//for (int j = 0 ; j < colCnt-1 ; j++) {
				sbufXML.append(" <TR>\n");
				sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
				sbufXML.append("  <TD><![CDATA[ "+ i +" ]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull( colValues.get("edi_snd_sts_cd") ) ); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull( colValues.get("snd_dt") ) ); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull( colValues.get("edi_snd_usr_id") ) ); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull( colValues.get("snd_ofc_cd") ) ); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull( colValues.get("vvd") ) ); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull( colValues.get("anr_decl_no") ) ); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull( colValues.get("ref_seq") ) ); sbufXML.append("]]></TD>\n");
				sbufXML.append(" </TR>\n");
				sbufXML.append(" <TR>\n");
				sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
				sbufXML.append("  <TD><![CDATA[ "+ i +" ]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull( colValues.get("edi_rcv_sts_cd") ) ); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull( colValues.get("rcv_dt") ) ); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull( colValues.get("edi_msg_err_id") ) ); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull( colValues.get("err") ) ); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull( colValues.get("err") ) ); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull( colValues.get("err") ) ); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull( colValues.get("err") ) ); sbufXML.append("]]></TD>\n");
				sbufXML.append(" </TR>\n");
			//}
			//sbufXML.append(JSPUtil.getNull(colValues.get(realColNms[colCnt-1])) + "]]></TR>\n");
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
					sb.append(JSPUtil.getNull(rs.getObject(j)) + DELIMITER);
				}	
				sb.append(JSPUtil.getNull(rs.getObject(colCount))  + "]]></TR>\n");
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
					arrRowSet[rowIdx][j-1] = JSPUtil.getNull(rs.getObject(j)).toString();
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
