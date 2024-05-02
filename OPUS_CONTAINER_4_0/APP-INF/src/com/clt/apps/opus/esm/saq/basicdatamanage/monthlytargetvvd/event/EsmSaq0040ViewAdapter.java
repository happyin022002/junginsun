/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmSaq0040ViewAdapter.java
*@FileTitle      : Target VVD/Supply Management
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.saq.basicdatamanage.monthlytargetvvd.event;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.clt.apps.opus.esm.saq.basicdatamanage.monthlytargetvvd.vo.MonthlyTargetVVDManagementVO;
import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author 김태호
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EsmSaq0040ViewAdapter extends ViewAdapter{
	
	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param colOrder String[] Column명 문자열 
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception 
	 */	
	@SuppressWarnings("unchecked")
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {

		ReturnVO listVO = (ReturnVO)vos.get(0);
		QuotaConditionVO conditionVO = (QuotaConditionVO) listVO.getList(0);
		List<MonthlyTargetVVDManagementVO> list01=  (List<MonthlyTargetVVDManagementVO>) listVO.getList(1);
		List<MonthlyTargetVVDManagementVO> list02=  (List<MonthlyTargetVVDManagementVO>) listVO.getList(2);
		String resultYN = listVO.getResultYN();

		String tgt_vvd_sts_cd = "";
		StringBuffer rlaneCds = new StringBuffer();
		StringBuffer bsaCds = new StringBuffer();
		String sub_trd_cd = null;
		String pre_sub_trd_cd = "";
		String rlane_cd = null;		
		String fnl_bsa_capa = null;
		String str_fnl_bsa_capa = null;
		TreeMap tmap = new TreeMap();
		Set set = null;
		Iterator iter = null;
		int totCnt = list01.size();

		StringBuilder sbufXML = new StringBuilder();
		sbufXML.append("<DATA TOTAL='" + totCnt +"'>\n");

		for(int i=0; i<totCnt; i++){
			Map<String, String> colValues = list01.get(i).getColumnValues();
	
//			if( tgt_vvd_sts_cd.length() == 0){
				tgt_vvd_sts_cd = colValues.get("tgt_vvd_sts_cd");
//			}
			sub_trd_cd = colValues.get("sub_trd_cd");
			rlane_cd = colValues.get("rlane_cd");
			// filter 에 필요한 항목 리스트 작성
			if(rlaneCds.indexOf(rlane_cd) < 0){
				if( !pre_sub_trd_cd.equals(sub_trd_cd) ){
					if( pre_sub_trd_cd.length() != 0 ){
						rlaneCds.append("&");
					}
					rlaneCds.append(sub_trd_cd).append(";");
				}
				pre_sub_trd_cd = sub_trd_cd;						
				rlaneCds.append(rlane_cd).append("|");
			}
			fnl_bsa_capa = colValues.get("fnl_bsa_capa");
			str_fnl_bsa_capa = colValues.get("str_fnl_bsa_capa");
			if(tmap.get(str_fnl_bsa_capa) == null ){
				tmap.put(str_fnl_bsa_capa,"1");//JSPUtil.formatCurrency(fnl_bsa_capa));
			}

			
			
			sbufXML.append("<TR>");			
			sbufXML.append("<TD>"+colValues.get("trd_cd")+"</TD>");
			sbufXML.append("<TD>"+colValues.get("dir_cd")+"</TD>");
			sbufXML.append("<TD>"+colValues.get("sub_trd_cd")+"</TD>");
			sbufXML.append("<TD>"+colValues.get("rlane_cd")+"</TD>");
			sbufXML.append("<TD>"+colValues.get("sprt_grp_cd")+colValues.get("bsa_grp_cd")+"</TD>");
			sbufXML.append("<TD>"+conditionVO.getYear()+"</TD>");
			sbufXML.append("<TD>"+colValues.get("bse_mon")+"</TD>");
			sbufXML.append("<TD>"+colValues.get("bse_wk")+"</TD>");
			sbufXML.append("<TD>"+colValues.get("vsl_cd")+colValues.get("skd_voy_no")+colValues.get("skd_dir_cd")+"</TD>");
			int unit = 1;	//태그라이브러리 삭제 영향
			if ( conditionVO.getUnit().equals("T")) {
				unit = 1;
			}else{
				unit = 2;
			}
			sbufXML.append("<TD>"+Integer.parseInt(colValues.get("fnl_bsa_capa"))/unit+"</TD>");
			sbufXML.append("<TD>"+colValues.get("fnl_bsa_capa")+"</TD>");
			sbufXML.append("<TD>N</TD>");
			sbufXML.append("<TD>"+colValues.get("sprt_grp_cd")+"</TD>");
			sbufXML.append("<TD>"+colValues.get("bsa_grp_cd")+"</TD>");
			sbufXML.append("<TD>"+colValues.get("sprt_grp_cd")+"</TD>");
			sbufXML.append("<TD>"+colValues.get("bsa_grp_cd")+"</TD>");
			sbufXML.append("<TD>"+colValues.get("sprt_grp_cd")+"</TD>");
			sbufXML.append("<TD>"+colValues.get("bsa_grp_cd")+"</TD>");
			sbufXML.append("<TD>"+colValues.get("upd_rmk")+"</TD>");
			sbufXML.append("<TD>"+colValues.get("delt_flg")+"</TD>");
			sbufXML.append("<TD>"+conditionVO.getYear()+"</TD>");
			sbufXML.append("<TD>"+conditionVO.getQuarter()+"</TD>");
			sbufXML.append("<TD>"+colValues.get("vsl_cd")+"</TD>");
			sbufXML.append("<TD>"+colValues.get("skd_voy_no")+"</TD>");
			sbufXML.append("<TD>"+colValues.get("skd_dir_cd")+"</TD>");
			sbufXML.append("<TD>"+colValues.get("lst_lodg_port_etd_dt")+"</TD>");
			sbufXML.append("<TD>"+colValues.get("ioc_cd")+"</TD>");
			sbufXML.append("<TD>"+colValues.get("vvd_seq")+"</TD>");
			sbufXML.append("<TD>"+colValues.get("ibflag")+"</TD>");
			sbufXML.append("<TD>"+colValues.get("sub_trd_cd")+colValues.get("rlane_cd")+conditionVO.getYear()+colValues.get("bse_mon")+colValues.get("bse_wk")+colValues.get("vsl_cd")+colValues.get("skd_voy_no")+colValues.get("skd_dir_cd")+"</TD>");
			sbufXML.append("<TD></TD>");
			sbufXML.append("<TD>"+colValues.get("lst_lodg_port_cd")+"</TD>");
			sbufXML.append("<TD>"+colValues.get("sub_trd_cd")+colValues.get("rlane_cd")+conditionVO.getYear()+colValues.get("bse_mon")+colValues.get("bse_wk")+"</TD>");
			sbufXML.append("</TR>\n");
		}
		set = tmap.keySet();
		iter = set.iterator();
		bsaCds.setLength(0);
		
		while(iter.hasNext()){
			//bsaCds.append(JSPUtil.formatCurrency((String)i.next())).append("|");
			String key = (String)iter.next();
			String value = (String)tmap.get(key);
			bsaCds.append(value).append("|");
		}		
		
		sbufXML.append("</DATA>\n");
		sbufXML.append("<ETC-DATA>\n");
		sbufXML.append("<ETC KEY=\"status\">OK</ETC>\n"); 
		sbufXML.append("<ETC KEY=\"tgt_vvd_sts_cd\">"+tgt_vvd_sts_cd+"</ETC>\n"); 
		sbufXML.append("<ETC KEY=\"LANE\"><![CDATA["+rlaneCds.toString()+"]]></ETC>\n");
		sbufXML.append("<ETC KEY=\"BSA\"><![CDATA["+bsaCds.toString()+"]]></ETC>\n");
		sbufXML.append("<ETC KEY=\"SAVEYN\"><![CDATA["+resultYN+"]]></ETC>\n");			
		sbufXML.append("</ETC-DATA>\n");   		
		sbufXML.append("</SHEET>\n");
		sbufXML.append("+\n");
		
		sbufXML.append("<SHEET>\n");
		sbufXML.append(" <DATA>\n");
		pre_sub_trd_cd = "";
		rlaneCds.setLength(0);
		tmap.clear();		

		totCnt = list02.size();
		for(int i=0; i<totCnt; i++){
			Map<String, String> colValues = list02.get(i).getColumnValues();
			sub_trd_cd = colValues.get("sub_trd_cd");
			rlane_cd = colValues.get("rlane_cd");
			// filter 에 필요한 항목 리스트 작성
			if(rlaneCds.indexOf(rlane_cd) < 0){
				if( !pre_sub_trd_cd.equals(sub_trd_cd) ){
					if( pre_sub_trd_cd.length() != 0 ){
						rlaneCds.append("&");
					}
					rlaneCds.append(sub_trd_cd).append(";");
				}
				pre_sub_trd_cd = sub_trd_cd;						
				rlaneCds.append(rlane_cd).append("|");
			}
			fnl_bsa_capa = colValues.get("fnl_bsa_capa");
			str_fnl_bsa_capa = colValues.get("str_fnl_bsa_capa");
			if(tmap.get(str_fnl_bsa_capa) == null ){
				tmap.put(str_fnl_bsa_capa,JSPUtil.formatCurrency(fnl_bsa_capa));
			}

			sbufXML.append("<TR>");			
			sbufXML.append("<TD>"+colValues.get("trd_cd")+"</TD>");
			sbufXML.append("<TD>"+colValues.get("dir_cd")+"</TD>");
			sbufXML.append("<TD>"+colValues.get("sub_trd_cd")+"</TD>");
			sbufXML.append("<TD>"+colValues.get("rlane_cd")+"</TD>");
			sbufXML.append("<TD></TD>");
			sbufXML.append("<TD></TD>");
			sbufXML.append("<TD></TD>");
			sbufXML.append("<TD></TD>");
			sbufXML.append("<TD></TD>");
			sbufXML.append("<TD></TD>");
			sbufXML.append("<TD></TD>");
			sbufXML.append("<TD></TD>");
			sbufXML.append("<TD></TD>");
			sbufXML.append("<TD>"+colValues.get("bse_mon")+"</TD>");
			sbufXML.append("<TD>"+colValues.get("bse_wk")+"</TD>");
			sbufXML.append("<TD>"+colValues.get("vsl_cd")+colValues.get("skd_voy_no")+colValues.get("skd_dir_cd")+"</TD>");
			int unit = 1;	//태그라이브러리 삭제 영향 (소스 품질 수정 요청건 0 --> 1)
			if ( conditionVO.getUnit().equals("T")) {
				unit = 1;
			}else{
				unit = 2;
			}
			sbufXML.append("<TD>"+Integer.parseInt(colValues.get("fnl_bsa_capa"))/unit+"</TD>");
			sbufXML.append("<TD>"+colValues.get("fnl_bsa_capa")+"</TD>");
			sbufXML.append("<TD>"+colValues.get("sprt_grp_cd")+"</TD>");
			sbufXML.append("<TD>"+colValues.get("bsa_grp_cd")+"</TD>");
			sbufXML.append("<TD>"+colValues.get("grp_max")+"</TD>");
			sbufXML.append("<TD>"+conditionVO.getYear()+"</TD>");
			sbufXML.append("<TD>"+conditionVO.getQuarter()+"</TD>");
			sbufXML.append("<TD>"+colValues.get("vsl_cd")+"</TD>");
			sbufXML.append("<TD>"+colValues.get("skd_voy_no")+"</TD>");
			sbufXML.append("<TD>"+colValues.get("skd_dir_cd")+"</TD>");
			sbufXML.append("<TD>"+conditionVO.getYear()+"</TD>");
			sbufXML.append("<TD>"+colValues.get("etd_dt")+"</TD>");
			sbufXML.append("<TD>"+colValues.get("ioc_cd")+"</TD>");
			sbufXML.append("<TD>"+colValues.get("vvd_seq")+"</TD>");
			sbufXML.append("<TD>I</TD>");
			sbufXML.append("<TD></TD>");
			sbufXML.append("<TD>"+colValues.get("sub_trd_cd")+colValues.get("rlane_cd")+conditionVO.getYear()+colValues.get("bse_mon")+colValues.get("bse_wk")+colValues.get("vsl_cd")+colValues.get("skd_voy_no")+colValues.get("skd_dir_cd")+"</TD>");
			sbufXML.append("<TD>"+colValues.get("lst_lodg_port_cd")+"</TD>");
			sbufXML.append("<TD>"+colValues.get("sub_trd_cd")+colValues.get("rlane_cd")+conditionVO.getYear()+colValues.get("bse_mon")+colValues.get("bse_wk")+"</TD>");
			sbufXML.append("</TR>\n");
		}		
		sbufXML.append("</DATA>\n");
		sbufXML.append("<ETC-DATA>\n");
		sbufXML.append("<ETC KEY=\"status\">OK</ETC>\n"); 
		sbufXML.append("<ETC KEY=\"LANE\"><![CDATA["+rlaneCds.toString()+"]]></ETC>\n");
		sbufXML.append("<ETC KEY=\"BSA\"><![CDATA["+bsaCds.toString()+"]]></ETC>\n");		
		sbufXML.append("</ETC-DATA>\n");   		
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