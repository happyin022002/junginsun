/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EesEqr1013ViewAdapter.java
*@FileTitle : Container Guideline Manage
*Open Issues :
*Change history :
* No.	Ver.		Modifier           					modifier date    explanation
* 1     1.0      	SHIN DONG IL						2013.05.27		 Creation
* 2                 SHIN YONGCHAN                       2015.08.10       CHM-201537079, 2015-08-10, 신용찬, 표준코드 변환          
*@LastModifyDate : 2013.05.27
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2013.05.27 SHIN DONG IL
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanmtrepoplan.event;

import java.sql.SQLException;
import java.util.List;

import com.hanjin.apps.alps.ees.eqr.cntrcommon.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanmtrepoplan.vo.EesEqr1013ConditionVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;
 
/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author SHIN DONG IL
 * @see ViewAdapter 참조
 * @since 2013.06.10
 */
public class EesEqr1013ViewAdapter extends ViewAdapter {
	
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
		EesEqr1013ConditionVO conditionVO = (EesEqr1013ConditionVO) commonRsVO.getConditionVO();
		DBRowSet rs = commonRsVO.getDbRowset();
		
		int totCnt  = vos.size();
		
		String ofc_cd = conditionVO.getOfcCd();
		
		// 2015.02.25 CHM-201534210 EQR 소스 보안 윗라인에서 conditionVO를 사용했으므로 굳이 null체크 할필요가 없음
//		String[] cntr_tp_sz = conditionVO!=null?conditionVO.getCntrTpszCd().split(","):null;
		String[] cntr_tp_sz = conditionVO.getCntrTpszCd().split(",");
		
		// EES_EQR_1014 에서 호출할때는 MAIN_PAGE = FALSE 로 호출됨. (수정불가)
		String main_page =	JSPUtil.getNull(conditionVO.getMainPage());		
		String colEdit = main_page.trim().equals("true")?"\"TRUE\"":"\"FALSE\"";  // EES_EQR_1014 호출 : FALSE, TRUE : 1013 호출
		
		log.debug("\n EesEqr1013ViewAdapter - main_page : "+main_page+ " <<<<< \n");		
		
		String disableColor = "";//"BGCOLOR=\"230,255,255\" "; //grey
		
		sbufXML.append("<DATA TOTAL='" + totCnt + "'>\n");
		
		String level 		= null;
		String fnl_cbf_flg 	= null;
		String pod_yd_cd 	= null;
		String pol_rcc_cd   = null;
		String pol_lcc_cd   = null;
		String ofc_rcc_cd   = null;
		String ofc_lcc_cd   = null;
		
		
		try {
			while (rs.next()){
//				log.debug("\n ---->>  mty_pln_shw_flg: "+getNull(rs.getString("mty_pln_shw_flg"))+"\n");
//				log.debug("\n ---->>  pod_yd_cd: "+getNull(rs.getString("pod_yd_cd"))+"\n");
//				log.debug("\n ---->>  level: "+getNull(rs.getString("lvl"))+"\n");
				
				level = getNull(rs.getString("lvl"));
				pod_yd_cd = getNull(rs.getString("pod_yd_cd"));
				
				// 1. CTY-EQ 는 모든 PORT 수정 가능
				// 2. SHAAS, SHAAOG 는 RCC / CNSHA, CNHKG, TWTPE, KRSEL, JPTYO 산하의 모든 PORT 수정 가능
				// 3. RCC : CNHKG 는 LCC 단위로 구분
			    //   --> CNSZP : CNSZP LCC 하단의 LOCATION 포함되는 OFFICE 만 수정 가능
			    //   --> CNXMN : CNXMN LCC 하단의 LOCATION 포함되는 OFFICE 만 수정 가능
			    //   --> CNHKG : CNHKG LCC 하단의 LOCATION 포함되는 OFFICE 만 수정 가능
				
				// POL_RCC_CD = OFC_RCC_CD  수정 가능
				// POL_RCC_CD <> OFC_RCC_CD 모든항목 수정 불가
				
				log.debug(  "\n ---->>  "
				           +"  POL_RCC_CD : "+getNull(rs.getString("pol_rcc_cd"))
						   +", POL_LCC_CD : "+getNull(rs.getString("pol_lcc_cd")) 
						   +", OFC_RCC_CD : "+getNull(rs.getString("ofc_rcc_cd")) 
						   +", OFC_LCC_CD : "+getNull(rs.getString("ofc_lcc_cd")) 						   
						   +", ofc_cd : " + ofc_cd
						                            
						                           
						);
				pol_rcc_cd = getNull(rs.getString("pol_rcc_cd"));
				pol_lcc_cd = getNull(rs.getString("pol_lcc_cd"));
				ofc_rcc_cd = getNull(rs.getString("ofc_rcc_cd"));
				ofc_lcc_cd = getNull(rs.getString("ofc_lcc_cd"));
				
				if(main_page.equals("true")) { // 1013 오픈을 의미 (Inquiry 아님)
					
					// CHM-201537079, 2015-08-10, 신용찬, 표준코드 변환
					//if(ofc_cd.equals("SELOPE")) { // SELCOE --> SELOPE
					if(ofc_cd.equals("SELCTY")) { // SELCOE --> SELOPE
						colEdit = "\"TRUE\""; // 1. SELOPE 는 모든 PORT 수정 가능 
					}else if( (ofc_cd.equals("SHARC") || ofc_cd.equals("SHARCO")) // SHAAS -->SHARC , SHAAOG --> SHARCO 
							 &&
							 (pol_rcc_cd.equals("CNSHA") || 
							  pol_rcc_cd.equals("CNHKG") || 
							  pol_rcc_cd.equals("TWTPE") || 
							  pol_rcc_cd.equals("KRSEL") || 
							  pol_rcc_cd.equals("JPTYO")
							 )		 
						   )  {
						colEdit = "\"TRUE\""; // 2. SHARC 혹은 SHARCO 는 RCC / CNSHA, CNHKG, TWTPE, KRSEL, JPTYO 산하의 모든 PORT 수정 가능
					}else if(
							 (ofc_lcc_cd.equals("CNSZP") && pol_lcc_cd.equals("CNSZP")) ||
							 (ofc_lcc_cd.equals("CNXMN") && pol_lcc_cd.equals("CNXMN")) ||
							 (ofc_lcc_cd.equals("CNHKG") && pol_lcc_cd.equals("CNHKG")) 
						   ) {
						colEdit = "\"TRUE\"";   // 위의 3번 설명 참조
					} else if(pol_rcc_cd.equals(ofc_rcc_cd) && !pol_rcc_cd.equals("CNHKG")) {
						colEdit = "\"TRUE\"";  // 위의 모든 경우를 제외한 모든 office user 포함(RCC/CNHKG 는 3번 로직 보완)
					} else   {
						colEdit = "\"FALSE\""; // 지역 불일치 row
					}
				}
				
				sbufXML.append("<TR LEVEL=\"" + level + "\" EXPAND=\"FALSE\">");
				sbufXML.append("<TD "+disableColor+"><![CDATA[" + getNull(rs.getString("trd_cd")) + "]]></TD>");
				sbufXML.append("<TD "+disableColor+"><![CDATA[" + getNull(rs.getString("sub_trd_cd")) + "]]></TD>");
				sbufXML.append("<TD "+disableColor+"><![CDATA[" + getNull(rs.getString("slan_cd")) + "]]></TD>");
				sbufXML.append("<TD "+disableColor+"><![CDATA[" + getNull(rs.getString("vvd_cd")) + "]]></TD>");
				sbufXML.append("<TD "+disableColor+"><![CDATA[" + getNull(rs.getString("pol_yd_cd")) + "]]></TD>");
				sbufXML.append("<TD "+disableColor+"><![CDATA[" + getNull(rs.getString("eta_dt")) + "]]></TD>");
				sbufXML.append("<TD "+disableColor+"><![CDATA[" + getNull(rs.getString("etd_dt")) + "]]></TD>");
				if (level!=null && level.trim().equals("0")){ // LEVEL = 0 은 POL ROW만 TEU, CBF FLAG 수정이 가능(조건에 따라 다름)
					sbufXML.append("<TD EDIT="+colEdit+" "+disableColor+"><![CDATA[" + getNull(rs.getString("fnl_cbf_dt")) + "]]></TD>");
					sbufXML.append("<TD EDIT=\"FALSE\" "+disableColor+"><![CDATA[" + getNull(rs.getString("avl_teu")) + "]]></TD>");
					sbufXML.append("<TD EDIT=\"FALSE\" "+disableColor+"><![CDATA[" + getNull(rs.getString("avl_ton")) + "]]></TD>");
					sbufXML.append("<TD EDIT=\"FALSE\" "+disableColor+" DATA-FORMAT=\"dfNone\"></TD>");
					sbufXML.append("<TD EDIT=\"FALSE\" "+disableColor+" DATA-FORMAT=\"dfNone\"></TD>");
//					sbufXML.append("<TD EDIT=\"TRUE\" "+disableColor+" DATA-FORMAT=\"dfInteger\" EDIT-LEN=\"\6\"><![CDATA[" + getNull(rs.getString("mty_pln_teu")) + "]]></TD>");
					sbufXML.append("<TD EDIT="+colEdit+" "+disableColor+"><![CDATA[" + getNull(rs.getString("mty_pln_teu")) + "]]></TD>");
					sbufXML.append("<TD EDIT=\"FALSE\" "+disableColor+"><![CDATA[" + getNull(rs.getString("mty_pln_ton")) + "]]></TD>");
					sbufXML.append("<TD EDIT=\"FALSE\" "+disableColor+"><![CDATA[" + getNull(rs.getString("mty_lodg_pln_teu")) + "]]></TD>");
					sbufXML.append("<TD EDIT=\"FALSE\" "+disableColor+"><![CDATA[" + getNull(rs.getString("mty_lodg_pln_ton")) + "]]></TD>");
					if( (rs.getString("eta_past_flg")).equals("Y")){ // ETA가 DB의 SYSDATE 이전이면 수정 불가
						sbufXML.append("<TD EDIT=\"FALSE\" "+" DATA-TYPE=\"dtCheckBox\"><![CDATA[" + getNull(rs.getString("fnl_cbf_flg")) + "]]></TD>");
					}else{
						sbufXML.append("<TD EDIT="+colEdit+" DATA-TYPE=\"dtCheckBox\"><![CDATA[" + getNull(rs.getString("fnl_cbf_flg")) + "]]></TD>");
					}
				} else { // POD ROW 는 TEU, CBF FLAG 수정불가
					sbufXML.append("<TD EDIT=\"FALSE\" "+disableColor+" DATA-FORMAT=\"dfNone\"></TD>");
					sbufXML.append("<TD EDIT=\"FALSE\" "+disableColor+" DATA-FORMAT=\"dfNone\"></TD>");
					sbufXML.append("<TD EDIT=\"FALSE\" "+disableColor+" DATA-FORMAT=\"dfNone\"></TD>");
					sbufXML.append("<TD EDIT=\"FALSE\" "+disableColor+" DATA-FORMAT=\"dfNone\"></TD>");
					sbufXML.append("<TD EDIT=\"FALSE\" "+disableColor+" DATA-FORMAT=\"dfNone\"></TD>");
					sbufXML.append("<TD EDIT=\"FALSE\" "+disableColor+" DATA-FORMAT=\"dfNone\"></TD>");
					sbufXML.append("<TD EDIT=\"FALSE\" "+disableColor+" DATA-FORMAT=\"dfNone\"></TD>");
					sbufXML.append("<TD EDIT=\"FALSE\" "+disableColor+" DATA-FORMAT=\"dfNone\"></TD>");
					sbufXML.append("<TD EDIT=\"FALSE\" "+disableColor+" DATA-FORMAT=\"dfNone\"></TD>");
					sbufXML.append("<TD EDIT=\"FALSE\" "+disableColor+" DATA-FORMAT=\"dfNone\"></TD>");
//					sbufXML.append("<TD EDIT=\"FALSE\" "+disableColor+" DATA-FORMAT=\"dfNone\"><![CDATA[" + getNull(rs.getString("fnl_cbf_dt")) + "]]></TD>");
//					sbufXML.append("<TD EDIT=\"FALSE\" "+disableColor+" DATA-FORMAT=\"dfNone\"><![CDATA[" + getNull(rs.getString("avl_ton")) + "]]></TD>");
//					sbufXML.append("<TD EDIT=\"FALSE\" "+disableColor+" DATA-FORMAT=\"dfNone\"><![CDATA[" + getNull(rs.getString("avl_ton")) + "]]></TD>");
//					sbufXML.append("<TD EDIT=\"FALSE\" "+disableColor+" DATA-FORMAT=\"dfNone\"><![CDATA[" + getNull(rs.getString("mty_pln_teu")) + "]]></TD>");
//					sbufXML.append("<TD EDIT=\"FALSE\" "+disableColor+" DATA-FORMAT=\"dfNone\"><![CDATA[" + getNull(rs.getString("mty_pln_ton")) + "]]></TD>");
//					sbufXML.append("<TD EDIT=\"FALSE\" "+disableColor+" DATA-FORMAT=\"dfNone\"><![CDATA[" + getNull(rs.getString("mty_lodg_pln_teu")) + "]]></TD>");
//					sbufXML.append("<TD EDIT=\"FALSE\" "+disableColor+" DATA-FORMAT=\"dfNone\"><![CDATA[" + getNull(rs.getString("mty_lodg_pln_ton")) + "]]></TD>");
//					sbufXML.append("<TD EDIT=\"FALSE\" "+disableColor+" DATA-FORMAT=\"dfNone\"><![CDATA[" + getNull(rs.getString("fnl_cbf_flg"))+"]]></TD>");
				}
				sbufXML.append("<TD "+disableColor+"><![CDATA[" + getNull(rs.getString("fnl_cbf_flg2")) + "]]></TD>");
				fnl_cbf_flg = !getNull(rs.getString("fnl_cbf_flg")).trim().equals("")?getNull(rs.getString("fnl_cbf_flg")):fnl_cbf_flg;
				
				if( (rs.getString("etd_past_flg")).equals("Y")){ // ETD가 DB의 SYSDATE 이전이면 수정 불가
					for(int i=0; cntr_tp_sz!=null && i<cntr_tp_sz.length; i++){
						if (cntr_tp_sz[i]!=null && !cntr_tp_sz[i].trim().equals("")){
							sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[" + getNull(rs.getString("mty_lodg_"+cntr_tp_sz[i]))+ "]]></TD>");
						}
					}
				}else{
					for(int i=0; cntr_tp_sz!=null && i<cntr_tp_sz.length; i++){
						if (cntr_tp_sz[i]!=null && !cntr_tp_sz[i].trim().equals("")){
							if (fnl_cbf_flg!=null && fnl_cbf_flg.trim().equals("0")){  // FINAL CONFIRM 되지 않은 경우
								if (pod_yd_cd!=null && (pod_yd_cd.trim().equals("+") || pod_yd_cd.trim().equals("-"))){  // POD_YD_CD = +- 는 POL ROW 를 의미함(수정불가)
									sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[" + getNull(rs.getString("mty_lodg_"+cntr_tp_sz[i]))+ "]]></TD>");
								} else {
									sbufXML.append("<TD EDIT="+colEdit+"><![CDATA[" + getNull(rs.getString("mty_lodg_"+cntr_tp_sz[i]))+ "]]></TD>");
								}
							} else {
								sbufXML.append("<TD EDIT=\"FALSE\"><![CDATA[" + getNull(rs.getString("mty_lodg_"+cntr_tp_sz[i]))+ "]]></TD>");
							}
						}
					}
				}
				
				
				if (level!=null && level.trim().equals("1")){
					sbufXML.append("<TD EDIT="+colEdit+" DATA-TYPE=\"dtCheckBox\"><![CDATA[" + getNull(rs.getString("mty_pln_shw_flg")) + "]]></TD>");
				} else {
					sbufXML.append("<TD "+disableColor+" EDIT=\"FALSE\"><![CDATA["+getNull(rs.getString("mty_pln_shw_flg"))+"]]></TD>");
				}
				sbufXML.append("<TD "+disableColor+"><![CDATA[" + getNull(rs.getString("pod_yd_cd")) + "]]></TD>");
				sbufXML.append("<TD "+disableColor+"><![CDATA[" + getNull(rs.getString("pod_yd_cd2")) + "]]></TD>");
				for(int i=0; cntr_tp_sz!=null && i<cntr_tp_sz.length; i++){
					if (cntr_tp_sz[i]!=null && !cntr_tp_sz[i].trim().equals("")){
						sbufXML.append("<TD><![CDATA[" + getNull(rs.getString("gl_qty_"+cntr_tp_sz[i])) + "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + getNull(rs.getString("gl_ut_"+cntr_tp_sz[i])) + "]]></TD>");
					}
				}
				sbufXML.append("<TD "+disableColor+"><![CDATA[" + getNull(rs.getString("repo_gline_rmk")) + "]]></TD>");
				sbufXML.append("<TD "+disableColor+"><![CDATA[" + getNull(rs.getString("mty_bkg_teu")) + "]]></TD>");
				sbufXML.append("<TD "+disableColor+"><![CDATA[" + getNull(rs.getString("mty_bkg_qty")) + "]]></TD>");
				for(int i=0; cntr_tp_sz!=null && i<cntr_tp_sz.length; i++){
					if (cntr_tp_sz[i]!=null && !cntr_tp_sz[i].trim().equals("")){
						sbufXML.append("<TD><![CDATA[" + getNull(rs.getString("mty_bkg_"+cntr_tp_sz[i])) + "]]></TD>");
					}
				}
				if (level!=null && level.trim().equals("0")){
					sbufXML.append("<TD EDIT="+colEdit+"><![CDATA[" + getNull(rs.getString("pln_rsn_hdr_cd")) + "]]></TD>");
					sbufXML.append("<TD EDIT="+colEdit+"><![CDATA[" + getNull(rs.getString("pln_rsn_sub_cd")) + "]]></TD>");
					sbufXML.append("<TD EDIT="+colEdit+"><![CDATA[" + getNull(rs.getString("pln_rsn_rmk")) + "]]></TD>");
				} else {
					sbufXML.append("<TD EDIT=\"FALSE\" "+disableColor+" DATA-FORMAT=\"dfNone\"></TD>");
					sbufXML.append("<TD EDIT=\"FALSE\" "+disableColor+" DATA-FORMAT=\"dfNone\"></TD>");
					sbufXML.append("<TD EDIT=\"FALSE\" "+disableColor+" DATA-FORMAT=\"dfNone\"></TD>");
				}
				sbufXML.append("<TD "+disableColor+"><![CDATA[" + getNull(rs.getString("etd_past_flg")) + "]]></TD>");
				sbufXML.append("<TD "+disableColor+"><![CDATA[" + getNull(rs.getString("eff_eta_dt")) + "]]></TD>");
				sbufXML.append("<TD "+disableColor+"><![CDATA[" + getNull(rs.getString("cre_ofc_cd")) + "]]></TD>");
				sbufXML.append("<TD "+disableColor+"><![CDATA[" + getNull(rs.getString("cre_conti_cd")) + "]]></TD>");
				sbufXML.append("<TD "+disableColor+"><![CDATA[" + getNull(rs.getString("aloc_hc_calc_qty")) + "]]></TD>");
				sbufXML.append("<TD "+disableColor+"><![CDATA[" + getNull(rs.getString("aloc_45ft_calc_qty")) + "]]></TD>");
				sbufXML.append("<TD "+disableColor+"><![CDATA[" + getNull(rs.getString("pol_rcc_cd")) + "]]></TD>");
				sbufXML.append("<TD "+disableColor+"><![CDATA[" + getNull(rs.getString("ofc_rcc_cd")) + "]]></TD>");
				sbufXML.append("<TD "+disableColor+"><![CDATA[" + getNull(rs.getString("pol_conti_cd")) + "]]></TD>");
				sbufXML.append("<TD "+disableColor+"><![CDATA[" + getNull(rs.getString("mty_vvd_cd")) + "]]></TD>");
				sbufXML.append("<TD></TD>");
				if (level!=null && level.trim().equals("0")){
					sbufXML.append("<TD><![CDATA[" + getNull(rs.getString("ibflag")) + "]]></TD>");
				} else {
					sbufXML.append("<TD></TD>");	
				}
				sbufXML.append("<TD></TD>");
				sbufXML.append("<TD></TD>");
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
	 * @param rs DBRowSet 		VO객체
	 * @param prefix String 		IBSheet savename's prefix string
	 * @return String IBSheet 		<DATA>태그
	 * @exception 
	 */
	protected String makeDataTag(DBRowSet rs,String prefix) {
		log.error("\n makeDataTag(DBRowSet rs,String prefix) ------- \n");
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