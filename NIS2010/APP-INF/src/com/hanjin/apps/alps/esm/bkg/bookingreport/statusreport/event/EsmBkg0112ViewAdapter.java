/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0112ViewAdapter.java
*@FileTitle : booking report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.08.05 강동윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event;

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
 * @author kang dong yun
 * @see ViewAdapter 참조
 * @since J2EE 1.6 
 */
public class EsmBkg0112ViewAdapter extends ViewAdapter{

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
		String[] realColNms=getColHeader(vo);
		String[] changedColNms = getChangedColNms(realColNms, prefix);
		
		if(vo.getMaxRows()>0){
			totCnt = vo.getMaxRows();
		}
		
		String nowBkgNo 	= "";
		String befBkgNo 	= "";
		String nexBkgNo 	= "";
		
		int seqIdx = 0;
		int gooIdx = 0;
		int errIdx = 0;
		
		float subConrPkg	= 0;
		
		Map<String, String> tempColValues = vos.get(0).getColumnValues();
		
		if(tempColValues.get("bl_no") != null || tempColValues.get("b_bl_no") != null){
		
			sbufXML.append("\n<DATA TOTAL='"); sbufXML.append(totCnt); sbufXML.append("'>\n");
			
			for(int i = 0 ; i < realCnt ; i++){
				
				Map<String, String> nowColValues = vos.get(i).getColumnValues();
				
				nowBkgNo = JSPUtil.getNull(nowColValues.get("bkg_no"));					
				
				if (i != 0){
					
					Map<String, String> befColValues = vos.get(i-1).getColumnValues(); 
					
					befBkgNo = JSPUtil.getNull(befColValues.get("bkg_no"));						
				}
				
				if (i != realCnt-1){
					
					Map<String, String> nexColValues = vos.get(i+1).getColumnValues(); 
					
					nexBkgNo = JSPUtil.getNull(nexColValues.get("bkg_no"));						
				}else{
					
					nexBkgNo = "";						
				}
				
				if (!befBkgNo.equals(nowBkgNo)){		//그룹구분
					
					seqIdx++;												

				}									
				
				subConrPkg += 0;
				
				if (!nowBkgNo.equals(nexBkgNo)){

					if (nowColValues.get("cust_nm_s").equals("E") 		||	nowColValues.get("cust_addr_s").equals("E")			||
						nowColValues.get("cust_cty_nm_s").equals("E")	|| 	nowColValues.get("cstms_decl_cnt_cd_s").equals("E")	||
						nowColValues.get("cust_zip_id_s").equals("E")	|| 	nowColValues.get("cust_nm_c").equals("E")			||
						nowColValues.get("cust_addr_c").equals("E")		|| 	nowColValues.get("cust_cty_nm_c").equals("E")		||
						nowColValues.get("cust_ste_cd_c").equals("E")	|| 	nowColValues.get("cstms_decl_cnt_cd_c").equals("E")	||
						nowColValues.get("cust_zip_id_c").equals("E")	|| 	nowColValues.get("cust_nm_n").equals("E")			||
						nowColValues.get("cust_addr_n").equals("E")		|| 	nowColValues.get("cust_cty_nm_n").equals("E")		||
						nowColValues.get("cust_ste_cd_n").equals("E")	|| 	nowColValues.get("cstms_decl_cnt_cd_n").equals("E")	||
						nowColValues.get("cust_zip_id_n").equals("E")	|| 	nowColValues.get("pck_qty_chk").equals("E")			||
						nowColValues.get("act_wet_chk").equals("E")		|| 	nowColValues.get("meas_qty_chk").equals("E")		||  
						nowColValues.get("cntr_mf_mk_desc").equals("E")	||	nowColValues.get("cntr_mf_gds_desc").equals("E")	||  
						nowColValues.get("cntr_seal_seq").equals("E")	||	nowColValues.get("cntr_mf_hts").equals("E")			||  
						nowColValues.get("cntr_mf_hs").equals("E")		||	nowColValues.get("cntr_mf_ncm").equals("E")){
						
						errIdx++;
					}else{
						
						gooIdx++;
					}
					
					subConrPkg = 0;
				}
				
				
				sbufXML.append(" <TR>\n");
				
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(Integer.toString(seqIdx)); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("bl_no"))); sbufXML.append(JSPUtil.getNull(nowColValues.get("bl_tp_cd"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("bkg_no"))); sbufXML.append("]]></TD>\n");					
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(nowColValues.get("entr_clss_tp_cd")); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(nowColValues.get("aes_inlnd_trns_no")); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(nowColValues.get("entr_clss_rmk")); sbufXML.append("]]></TD>\n");
				
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("s_cust_nm"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("s_cust_addr_nm"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cust_cty_nm_s"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cstms_decl_cnt_cd_s"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cust_zip_id_s"))); sbufXML.append("]]></TD>\n");
				
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(nowColValues.get("cust_nm")); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cust_addr_c"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cust_cty_nm_c"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cust_ste_cd_c"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cstms_decl_cnt_cd_c"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cust_zip_id_c"))); sbufXML.append("]]></TD>\n");
				
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(nowColValues.get("n_cust_nm")); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cust_addr_n"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cust_cty_nm_n"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cust_ste_cd_n"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cstms_decl_cnt_cd_n"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cust_zip_id_n"))); sbufXML.append("]]></TD>\n");
				
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("pck_cmdt_desc"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("md"))); sbufXML.append("]]></TD>\n");

				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("pck_qty_da"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("pck_tp_cd"))); sbufXML.append("]]></TD>\n");					
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("pck_qty_chk"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD DATA-FORMAT=\"dfFloat\" POINT-COUNT=\"2\"><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("act_wgt"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("act_wet_chk"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD DATA-FORMAT=\"dfFloat\" POINT-COUNT=\"2\"><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("meas_qty_da"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("meas_qty_chk"))); sbufXML.append("]]></TD>\n");
				
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("dcgo_flg"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(nowColValues.get("veh_cmdt_flg")); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("si_flg"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("xter_si_cd"))); sbufXML.append("]]></TD>\n");					

				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("bkg_qty"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cntr_qty"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cntr_no"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cntr_seal_seq"))); sbufXML.append("]]></TD>\n");					
				
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cust_nm"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("check"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(Integer.toString(gooIdx)); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(Integer.toString(errIdx)); sbufXML.append("]]></TD>\n");
				
				sbufXML.append(" </TR>\n");																																				
				
			}//for
			
			sbufXML.append("</DATA>\n");
		}else{

			sbufXML.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' COLSEPARATOR='").append("\u261C\u261E").append("' TOTAL='").append(totCnt).append("'>\n").toString());
	        for(int i = 0; i < realCnt; i++)
	        {
	            Map<String,String> colValues = ((AbstractValueObject)vos.get(i)).getColumnValues();
	            sbufXML.append("\t<TR><![CDATA[");
	            int colCnt = realColNms.length;
	            for(int j = 0; j < colCnt - 1; j++)
	                sbufXML.append((new StringBuilder(String.valueOf(getNull((String)colValues.get(realColNms[j]))))).append("\u261C\u261E").toString());

	            sbufXML.append((new StringBuilder(String.valueOf(getNull((String)colValues.get(realColNms[colCnt - 1]))))).append("]]></TR>\n").toString());
	        }
	        
	        sbufXML.append("</DATA>\n");
		}
		
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
