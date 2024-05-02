/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0116ViewAdapter.java
 *@FileTitle : booking report
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.10
 *@LastModifier : 강동윤
 *@LastVersion : 1.0
 * 2009.08.10 강동윤
 * 1.0 Creation
 * 2011.03.03 정선용 [ESM_BKG_0116_01] IBSheet에 WGT,MEASURE 항목의 경우 소수점 셋째자리까지 변경 요청 .000 으로 표시
 * 2012.06.25 김기택 [CHM-201218292-01] C/M 화면 다운로드 데이터 양식 수정(B/L No, TP/SZ, Seal No 컬럼 분리) 
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
public class EsmBkg0116ViewAdapter extends ViewAdapter{

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

		String nowCntrNo 	= "";
		String befCntrNo 	= "";
		String nexCntrNo 	= "";

		String nowBlNo		= "";
		//String befBlNo		= "";
		String nexBlNo		= "";

		String nowCustNm	= "";
		//String befCustNm	= "";
		String nexCustNm	= "";

		String nowFaxNo		= "";
		//String befFaxNo		= "";
		String nexFaxNo		= "";

		float subTotPackage = 0;
		float subTotWeight  = 0;
		float subTotMeasure = 0;

		float totPackage 	= 0;
		float totWeight  	= 0;
		float totMeasure 	= 0;

		float grandPackage	= 0;
		float grandWeight	= 0;
		float grandMeasure	= 0;

		int seqIdx = 1;

		Map<String, String> tempColValues = vos.get(0).getColumnValues();			

		if (tempColValues.get("tab_tp") != null){ 

			sbufXML.append("\n<DATA TOTAL='"); sbufXML.append(totCnt); sbufXML.append("'>\n");

			if (tempColValues.get("tab_tp").equals("CM")){ 

				for(int i = 0 ; i < realCnt ; i++){

					Map<String, String> nowColValues = vos.get(i).getColumnValues();

					nowCntrNo = JSPUtil.getNull(nowColValues.get("cntr_no"));

					if (i != 0){

						Map<String, String> befColValues = vos.get(i-1).getColumnValues(); 

						befCntrNo = JSPUtil.getNull(befColValues.get("cntr_no"));
					}

					if (i != realCnt-1){

						Map<String, String> nexColValues = vos.get(i+1).getColumnValues(); 

						nexCntrNo = JSPUtil.getNull(nexColValues.get("cntr_no"));
					}else{

						nexCntrNo = "";
					}

					if (!befCntrNo.equals(nowCntrNo)){		//그룹구분
						
						seqIdx = 1;
						if (tempColValues.get("spl_Flg").equals("S")){
							sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");
							sbufXML.append("  <TD DATA-ALIGN=\"daLeft\" BOLD=\"TRUE\"><![CDATA["); sbufXML.append(" Container No : "); sbufXML.append(nowColValues.get("cntr_no")); sbufXML.append(" / "); sbufXML.append(nowColValues.get("cntr_tpsz_cd")); sbufXML.append("       Seal No : "); sbufXML.append(nowColValues.get("cntr_seal_no")); sbufXML.append("]]></TD>\n");
							sbufXML.append("  <TD><![CDATA["); sbufXML.append(" Container No : "); sbufXML.append(nowColValues.get("cntr_no")); sbufXML.append(" / "); sbufXML.append(nowColValues.get("cntr_tpsz_cd")); sbufXML.append("       Seal No : "); sbufXML.append(nowColValues.get("cntr_seal_no")); sbufXML.append("]]></TD>\n");
							sbufXML.append("  <TD><![CDATA["); sbufXML.append(" Container No : "); sbufXML.append(nowColValues.get("cntr_no")); sbufXML.append(" / "); sbufXML.append(nowColValues.get("cntr_tpsz_cd")); sbufXML.append("       Seal No : "); sbufXML.append(nowColValues.get("cntr_seal_no")); sbufXML.append("]]></TD>\n");
							sbufXML.append("  <TD><![CDATA["); sbufXML.append(" Container No : "); sbufXML.append(nowColValues.get("cntr_no")); sbufXML.append(" / "); sbufXML.append(nowColValues.get("cntr_tpsz_cd")); sbufXML.append("       Seal No : "); sbufXML.append(nowColValues.get("cntr_seal_no")); sbufXML.append("]]></TD>\n");
							sbufXML.append("  <TD><![CDATA["); sbufXML.append(" Container No : "); sbufXML.append(nowColValues.get("cntr_no")); sbufXML.append(" / "); sbufXML.append(nowColValues.get("cntr_tpsz_cd")); sbufXML.append("       Seal No : "); sbufXML.append(nowColValues.get("cntr_seal_no")); sbufXML.append("]]></TD>\n");
							sbufXML.append("  <TD><![CDATA["); sbufXML.append(" Container No : "); sbufXML.append(nowColValues.get("cntr_no")); sbufXML.append(" / "); sbufXML.append(nowColValues.get("cntr_tpsz_cd")); sbufXML.append("       Seal No : "); sbufXML.append(nowColValues.get("cntr_seal_no")); sbufXML.append("]]></TD>\n");
							sbufXML.append("  <TD><![CDATA["); sbufXML.append(" Container No : "); sbufXML.append(nowColValues.get("cntr_no")); sbufXML.append(" / "); sbufXML.append(nowColValues.get("cntr_tpsz_cd")); sbufXML.append("       Seal No : "); sbufXML.append(nowColValues.get("cntr_seal_no")); sbufXML.append("]]></TD>\n");
							sbufXML.append("  <TD><![CDATA["); sbufXML.append(" Container No : "); sbufXML.append(nowColValues.get("cntr_no")); sbufXML.append(" / "); sbufXML.append(nowColValues.get("cntr_tpsz_cd")); sbufXML.append("       Seal No : "); sbufXML.append(nowColValues.get("cntr_seal_no")); sbufXML.append("]]></TD>\n");
							sbufXML.append("  <TD><![CDATA["); sbufXML.append(" Container No : "); sbufXML.append(nowColValues.get("cntr_no")); sbufXML.append(" / "); sbufXML.append(nowColValues.get("cntr_tpsz_cd")); sbufXML.append("       Seal No : "); sbufXML.append(nowColValues.get("cntr_seal_no")); sbufXML.append("]]></TD>\n");
							sbufXML.append("  <TD><![CDATA["); sbufXML.append(" Container No : "); sbufXML.append(nowColValues.get("cntr_no")); sbufXML.append(" / "); sbufXML.append(nowColValues.get("cntr_tpsz_cd")); sbufXML.append("       Seal No : "); sbufXML.append(nowColValues.get("cntr_seal_no")); sbufXML.append("]]></TD>\n");
							sbufXML.append("  <TD><![CDATA["); sbufXML.append(" Container No : "); sbufXML.append(nowColValues.get("cntr_no")); sbufXML.append(" / "); sbufXML.append(nowColValues.get("cntr_tpsz_cd")); sbufXML.append("       Seal No : "); sbufXML.append(nowColValues.get("cntr_seal_no")); sbufXML.append("]]></TD>\n");
							sbufXML.append("  <TD><![CDATA["); sbufXML.append(" Container No : "); sbufXML.append(nowColValues.get("cntr_no")); sbufXML.append(" / "); sbufXML.append(nowColValues.get("cntr_tpsz_cd")); sbufXML.append("       Seal No : "); sbufXML.append(nowColValues.get("cntr_seal_no")); sbufXML.append("]]></TD>\n");
							sbufXML.append("  <TD><![CDATA["); sbufXML.append(" Container No : "); sbufXML.append(nowColValues.get("cntr_no")); sbufXML.append(" / "); sbufXML.append(nowColValues.get("cntr_tpsz_cd")); sbufXML.append("       Seal No : "); sbufXML.append(nowColValues.get("cntr_seal_no")); sbufXML.append("]]></TD>\n");
							sbufXML.append("  <TD><![CDATA["); sbufXML.append(" Container No : "); sbufXML.append(nowColValues.get("cntr_no")); sbufXML.append(" / "); sbufXML.append(nowColValues.get("cntr_tpsz_cd")); sbufXML.append("       Seal No : "); sbufXML.append(nowColValues.get("cntr_seal_no")); sbufXML.append("]]></TD>\n");
							sbufXML.append("  <TD><![CDATA["); sbufXML.append(" Container No : "); sbufXML.append(nowColValues.get("cntr_no")); sbufXML.append(" / "); sbufXML.append(nowColValues.get("cntr_tpsz_cd")); sbufXML.append("       Seal No : "); sbufXML.append(nowColValues.get("cntr_seal_no")); sbufXML.append("]]></TD>\n");
							sbufXML.append("  <TD><![CDATA["); sbufXML.append(" Container No : "); sbufXML.append(nowColValues.get("cntr_no")); sbufXML.append(" / "); sbufXML.append(nowColValues.get("cntr_tpsz_cd")); sbufXML.append("       Seal No : "); sbufXML.append(nowColValues.get("cntr_seal_no")); sbufXML.append("]]></TD>\n");
							sbufXML.append("  <TD><![CDATA["); sbufXML.append(" Container No : "); sbufXML.append(nowColValues.get("cntr_no")); sbufXML.append(" / "); sbufXML.append(nowColValues.get("cntr_tpsz_cd")); sbufXML.append("       Seal No : "); sbufXML.append(nowColValues.get("cntr_seal_no")); sbufXML.append("]]></TD>\n");
							sbufXML.append("  <TD><![CDATA["); sbufXML.append(" Container No : "); sbufXML.append(nowColValues.get("cntr_no")); sbufXML.append(" / "); sbufXML.append(nowColValues.get("cntr_tpsz_cd")); sbufXML.append("       Seal No : "); sbufXML.append(nowColValues.get("cntr_seal_no")); sbufXML.append("]]></TD>\n");
							sbufXML.append("  <TD><![CDATA["); sbufXML.append(" Container No : "); sbufXML.append(nowColValues.get("cntr_no")); sbufXML.append(" / "); sbufXML.append(nowColValues.get("cntr_tpsz_cd")); sbufXML.append("       Seal No : "); sbufXML.append(nowColValues.get("cntr_seal_no")); sbufXML.append("]]></TD>\n");
							sbufXML.append("  <TD><![CDATA["); sbufXML.append(" Container No : "); sbufXML.append(nowColValues.get("cntr_no")); sbufXML.append(" / "); sbufXML.append(nowColValues.get("cntr_tpsz_cd")); sbufXML.append("       Seal No : "); sbufXML.append(nowColValues.get("cntr_seal_no")); sbufXML.append("]]></TD>\n");
							sbufXML.append("  <TD><![CDATA["); sbufXML.append(" Container No : "); sbufXML.append(nowColValues.get("cntr_no")); sbufXML.append(" / "); sbufXML.append(nowColValues.get("cntr_tpsz_cd")); sbufXML.append("       Seal No : "); sbufXML.append(nowColValues.get("cntr_seal_no")); sbufXML.append("]]></TD>\n");
							sbufXML.append("  <TD><![CDATA["); sbufXML.append(" Container No : "); sbufXML.append(nowColValues.get("cntr_no")); sbufXML.append(" / "); sbufXML.append(nowColValues.get("cntr_tpsz_cd")); sbufXML.append("       Seal No : "); sbufXML.append(nowColValues.get("cntr_seal_no")); sbufXML.append("]]></TD>\n");
							sbufXML.append("  <TD><![CDATA["); sbufXML.append(Integer.toString(i+1)); sbufXML.append("]]></TD>\n");

							sbufXML.append("</TR>\n"); 

						}else if(tempColValues.get("spl_Flg").equals("F")){
							sbufXML.append(" <TR>\n");

							sbufXML.append("  <TD DATA-ALIGN=\"daLeft\" BOLD=\"TRUE\"><![CDATA["); sbufXML.append(" Container No : "); sbufXML.append(nowColValues.get("cntr_no"));sbufXML.append("]]></TD>\n");
							sbufXML.append(" <TD><![CDATA[]]></TD>\n"); //2
							sbufXML.append(" <TD><![CDATA[]]></TD>\n"); //3
							sbufXML.append(" <TD><![CDATA[]]></TD>\n"); //4
							sbufXML.append(" <TD><![CDATA[]]></TD>\n"); //5
							sbufXML.append(" <TD><![CDATA[]]></TD>\n");  //6
							sbufXML.append(" <TD><![CDATA[]]></TD>\n");  //7
							sbufXML.append(" <TD ><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cntr_mf_wgt"))); sbufXML.append("]]></TD>\n");
							sbufXML.append("  <TD ><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("meas_qty"))); sbufXML.append("]]></TD>\n");
							sbufXML.append(" <TD><![CDATA[]]></TD>\n"); //10
							sbufXML.append(" <TD><![CDATA[]]></TD>\n"); //11
							sbufXML.append(" <TD><![CDATA[]]></TD>\n"); //12
							sbufXML.append(" <TD><![CDATA[]]></TD>\n"); //13
							sbufXML.append(" <TD><![CDATA[]]></TD>\n"); //14
							sbufXML.append(" <TD><![CDATA[]]></TD>\n"); //15
							sbufXML.append(" <TD><![CDATA[]]></TD>\n"); //16
							sbufXML.append(" <TD><![CDATA[]]></TD>\n"); //17
							sbufXML.append(" <TD><![CDATA[]]></TD>\n"); //18
							sbufXML.append(" <TD><![CDATA[]]></TD>\n"); //19
							sbufXML.append(" <TD><![CDATA[]]></TD>\n"); //20
							sbufXML.append(" <TD><![CDATA[]]></TD>\n"); //21
							sbufXML.append(" <TD><![CDATA[]]></TD>\n"); //22
							sbufXML.append(" <TD><![CDATA[]]></TD>\n"); //23
							sbufXML.append(" <TD><![CDATA[]]></TD>\n"); //24
							sbufXML.append(" <TD><![CDATA[]]></TD>\n"); //25

							sbufXML.append("</TR>\n"); 
						}
					}

					if (tempColValues.get("spl_Flg").equals("S")){
						sbufXML.append(" <TR>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("bl_no"))); sbufXML.append(JSPUtil.getNull(nowColValues.get("bl_tp_cd"))); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(Integer.toString(seqIdx++)); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cntr_mf_gds_desc"))); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD DATA-FORMAT=\"dfInteger\"><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("pck_qty"))); sbufXML.append("]]></TD>\n");
						//5
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("pck_tp_cd"))); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD ><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cntr_mf_wgt"))); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD ><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("meas_qty"))); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("rcv_term_cd"))); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("de_term_cd"))); sbufXML.append("]]></TD>\n");
						//10
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("dcgo_flg"))); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("awk_cgo_flg"))); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("hngr_flg"))); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("adv_shtg_cd"))); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cntr_mf_mk_desc"))); sbufXML.append("]]></TD>\n");
						//15
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("ob_srep_cd"))); sbufXML.append("]]></TD>\n");				
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cust_nm"))); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("doc_usr_id"))); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("hamo_trf_cd"))); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("po_no"))); sbufXML.append("]]></TD>\n");
						//20
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cmdt_hs_cd"))); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("pol_cd"))); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("bkg_no"))); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append("OK"); sbufXML.append("]]></TD>\n");

						sbufXML.append(" </TR>\n");

						subTotPackage += Float.parseFloat(nowColValues.get("pck_qty"));
						subTotWeight  += Float.parseFloat(nowColValues.get("cntr_mf_wgt"));
						subTotMeasure += Float.parseFloat(nowColValues.get("meas_qty")); 
					} else if(tempColValues.get("spl_Flg").equals("F")){
						sbufXML.append(" <TR>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("bl_no"))); sbufXML.append(JSPUtil.getNull(nowColValues.get("bl_tp_cd"))); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(nowColValues.get("cntr_tpsz_cd")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(nowColValues.get("cntr_seal_no")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(Integer.toString(seqIdx++)); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cntr_mf_gds_desc"))); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD DATA-FORMAT=\"dfInteger\"><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("pck_qty"))); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("pck_tp_cd"))); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD ><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cntr_mf_wgt"))); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD ><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("meas_qty"))); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("rcv_term_cd"))); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("de_term_cd"))); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("dcgo_flg"))); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("awk_cgo_flg"))); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("hngr_flg"))); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("adv_shtg_cd"))); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cntr_mf_mk_desc"))); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("ob_srep_cd"))); sbufXML.append("]]></TD>\n");				
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cust_nm"))); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("doc_usr_id"))); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("hamo_trf_cd"))); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("po_no"))); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cmdt_hs_cd"))); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("pol_cd"))); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("bkg_no"))); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append("OK"); sbufXML.append("]]></TD>\n");

						sbufXML.append(" </TR>\n");

						subTotPackage += Float.parseFloat(nowColValues.get("pck_qty"));
						subTotWeight  += Float.parseFloat(nowColValues.get("cntr_mf_wgt"));
						subTotMeasure += Float.parseFloat(nowColValues.get("meas_qty")); 
					}


					if (!nowCntrNo.equals(nexCntrNo)){		//소계처리									

						sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");

						sbufXML.append("  <TD DATA-ALIGN=\"daRight\" BOLD=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD DATA-ALIGN=\"daRight\" BOLD=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD DATA-ALIGN=\"daRight\" BOLD=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD DATA-ALIGN=\"daRight\" DATA-FORMAT=\"dfInteger\"><![CDATA["); sbufXML.append(Float.toString(subTotPackage)); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD DATA-ALIGN=\"daRight\" ><![CDATA["); sbufXML.append(Float.toString(subTotWeight));  sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD DATA-ALIGN=\"daRight\" ><![CDATA["); sbufXML.append(Float.toString(subTotMeasure)); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");

						sbufXML.append(" </TR>\n");

						subTotPackage = 0;
						subTotWeight  = 0;
						subTotMeasure = 0;

					}

					totPackage += Float.parseFloat(nowColValues.get("pck_qty"));
					totWeight  += Float.parseFloat(nowColValues.get("cntr_mf_wgt"));
					totMeasure += Float.parseFloat(nowColValues.get("meas_qty"));

				}//for

				//Total
				sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");

				sbufXML.append("  <TD DATA-ALIGN=\"daCenter\" BOLD=\"TRUE\"><![CDATA["); sbufXML.append("Total"); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD DATA-ALIGN=\"daCenter\" BOLD=\"TRUE\"><![CDATA["); sbufXML.append("Total"); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD DATA-ALIGN=\"daCenter\" BOLD=\"TRUE\"><![CDATA["); sbufXML.append("Total"); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD DATA-ALIGN=\"daRight\"  BOLD=\"TRUE\" DATA-FORMAT=\"dfInteger\"><![CDATA["); sbufXML.append(Float.toString(totPackage)); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
				sbufXML.append("  <TD DATA-ALIGN=\"daRight\"  BOLD=\"TRUE\" ><![CDATA["); sbufXML.append(Float.toString(totWeight));  sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD DATA-ALIGN=\"daRight\"  BOLD=\"TRUE\" ><![CDATA["); sbufXML.append(Float.toString(totMeasure)); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
				sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
				sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
				sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
				sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
				sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
				sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
				sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
				sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
				sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
				sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
				sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
				sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
				sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
				sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
				sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
//				sbufXML.append("  <TD><![CDATA["); sbufXML.append(Integer.toString(realCnt)); sbufXML.append("]]></TD>\n");

				sbufXML.append(" </TR>\n");

			}else if (tempColValues.get("tab_tp").equals("FAX")){

				for(int i = 0 ; i < realCnt ; i++){

					Map<String, String> nowColValues = vos.get(i).getColumnValues();

					nowBlNo 	= JSPUtil.getNull(nowColValues.get("bl_no"));
					nowCustNm	= JSPUtil.getNull(nowColValues.get("cust_nm"));
					nowFaxNo	= JSPUtil.getNull(nowColValues.get("cntc_pson_fax_no"));

					/*
					if (i != 0){

						Map<String, String> befColValues = vos.get(i-1).getColumnValues(); 

						befBlNo 	= JSPUtil.getNull(befColValues.get("bl_no"));
						befCustNm 	= JSPUtil.getNull(befColValues.get("cust_nm"));
						befFaxNo 	= JSPUtil.getNull(befColValues.get("cntc_pson_fax_no"));
					}
					 */

					if (i != realCnt-1){

						Map<String, String> nexColValues = vos.get(i+1).getColumnValues(); 

						nexBlNo 	= JSPUtil.getNull(nexColValues.get("bl_no"));
						nexCustNm 	= JSPUtil.getNull(nexColValues.get("cust_nm"));
						nexFaxNo 	= JSPUtil.getNull(nexColValues.get("cntc_pson_fax_no"));
					}else{

						nexBlNo 	= "";
						nexCustNm 	= "";
						nexFaxNo 	= "";
					}

					sbufXML.append(" <TR>\n");

					//sbufXML.append("  <TD>R</TD>\n");
					sbufXML.append("  <TD DATA-TYPE=\"dtCheckBox \"><![CDATA[1]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("bl_no"))); sbufXML.append(JSPUtil.getNull(nowColValues.get("bl_tp_cd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cust_nm"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cntc_pson_nm"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cntc_pson_fax_no"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cntr_no"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cntr_tpsz_cd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cntr_seal_no"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("pod_cd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cntr_mf_gds_desc"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD DATA-FORMAT=\"dfInteger\"><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("pck_qty"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("act_wgt"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("meas_qty"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("xpt_lic_no"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("bkg_no"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[C]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(Integer.toString(i+1)); sbufXML.append("]]></TD>\n");

					sbufXML.append(" </TR>\n");

					subTotPackage += Float.parseFloat(nowColValues.get("pck_qty"));
					subTotWeight  += Float.parseFloat(nowColValues.get("act_wgt"));
					subTotMeasure += Float.parseFloat(nowColValues.get("meas_qty")); 

					grandPackage  += Float.parseFloat(nowColValues.get("pck_qty"));
					grandWeight	  += Float.parseFloat(nowColValues.get("act_wgt"));
					grandMeasure  += Float.parseFloat(nowColValues.get("meas_qty")); 

					if (!nowBlNo.equals(nexBlNo)){		//소계처리									

						sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");

						//sbufXML.append("  <TD>R</TD>\n");					
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD DATA-ALIGN=\"daRight\" BOLD=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD DATA-ALIGN=\"daRight\" DATA-FORMAT=\"dfInteger\"><![CDATA["); sbufXML.append(Float.toString(subTotPackage)); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD DATA-ALIGN=\"daRight\" ><![CDATA["); sbufXML.append(Float.toString(subTotWeight));  sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD DATA-ALIGN=\"daRight\" ><![CDATA["); sbufXML.append(Float.toString(subTotMeasure)); sbufXML.append("]]></TD>\n");					
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[S]]></TD>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(Integer.toString(i+1)); sbufXML.append("]]></TD>\n");

						sbufXML.append(" </TR>\n");															

						subTotPackage = 0;
						subTotWeight  = 0;
						subTotMeasure = 0;

					}

					if (!nowCustNm.equals(nexCustNm) && !nowFaxNo.equals(nexFaxNo)){		//Grand Total 	

						sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");

						//sbufXML.append("  <TD>R</TD>\n");					
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD DATA-ALIGN=\"daRight\" BOLD=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD DATA-ALIGN=\"daRight\" DATA-FORMAT=\"dfInteger\"><![CDATA["); sbufXML.append(Float.toString(grandPackage)); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD DATA-ALIGN=\"daRight\" ><![CDATA["); sbufXML.append(Float.toString(grandWeight));  sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD DATA-ALIGN=\"daRight\" ><![CDATA["); sbufXML.append(Float.toString(grandMeasure)); sbufXML.append("]]></TD>\n");					
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[G]]></TD>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(Integer.toString(i+1)); sbufXML.append("]]></TD>\n");

						sbufXML.append(" </TR>\n");

						grandPackage = 0;
						grandWeight  = 0;
						grandMeasure = 0;
					}
				}
			}

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
