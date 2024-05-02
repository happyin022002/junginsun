/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0495ViewAdapter.java
*@FileTitle : T/S List by 1st VSL & 2nd VSL T/S Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.06.02 최영희
* 1.0 Creation
* -------------------------------------------------------
* History
* 2010.09.14 변종건 [CHM-201005873-01]	 T/S List by 1st VSL & 2nd VSL 엑셀 다운 폼 수정 요청 (Location Full Name 추가)
* 2011.04.28 이일민 [CHM-201110111] Transshipment 와 discharging list data match 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.event;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;

/**
 * ESM_BKG_0495 에 대한 <br>
 * -  EsmBkg0495ViewAdapter 작성<br>
 *
 * @author Choi Yeoung Hee
 * @see ESM_BKG_0495HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg0495ViewAdapter extends ViewAdapter {

	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param List<AbstractValueObject> vos
	 * @param String prefix
	 * @return String
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
		String sVvdTmp="";
		String sNextVvdTmp="";
		String sVvdCd="";
		float iCntr20SubSum=0.0F;
		float iCntr40SubSum=0.0F;
		float iCntr20SubVolSum =0.0F;
		float iCntr40SubVolSum =0.0F;
		float fWgtSum=0.0F;
		float iCntr20Sum =0.0F;
		float iCntr40Sum =0.0F;
		int colCnt=0;
		
		if (realColNms.length>10){
			sbufXML.append("\n<DATA TOTAL='"); sbufXML.append(totCnt); sbufXML.append("'>\n"); 
			for(int i=0;i<realCnt;i++){
				Map<String, String> colValues = vos.get(i).getColumnValues(); 
				
				if (i+1 == realCnt){
					sNextVvdTmp="";
				}else{
					Map<String, String> colNextValues = vos.get(i+1).getColumnValues();
					if(colNextValues.get("disc").equals("D")){
						sNextVvdTmp = colNextValues.get("nextvvd");
					}else{
						sNextVvdTmp = colNextValues.get("firstvvd");
					}
				}
				
				colCnt = realColNms.length;
				if (colValues.get("disc").equals("D")){
					sVvdCd =colValues.get("nextvvd");
				}else{
					sVvdCd =colValues.get("firstvvd");
				}
				if (!sVvdTmp.equals(sVvdCd)){		//그룹구분
					sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");
					sbufXML.append("  <TD>R</TD>\n");
					sbufXML.append("  <TD DATA-ALIGN=\"daLeft\"><![CDATA["); sbufXML.append(colValues.get("vsl_nm")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(colValues.get("vsl_nm")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(colValues.get("vsl_nm")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(colValues.get("vsl_nm")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(colValues.get("vsl_nm")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(colValues.get("vsl_nm")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(colValues.get("vsl_nm")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(colValues.get("vsl_nm")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(colValues.get("vsl_nm")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(colValues.get("vsl_nm")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(colValues.get("vsl_nm")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(colValues.get("vsl_nm")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(colValues.get("vsl_nm")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(colValues.get("vsl_nm")); sbufXML.append("]]></TD>\n");			
					sbufXML.append("  <TD><![CDATA["); sbufXML.append("ETB"); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD BGCOLOR=\"232, 231, 236\" ><![CDATA["); sbufXML.append(colValues.get("etb")); sbufXML.append("]]></TD>\n"); 
					sbufXML.append("  <TD BGCOLOR=\"232, 231, 236\" ><![CDATA["); sbufXML.append(colValues.get("etb")); sbufXML.append("]]></TD>\n"); 
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
 
					sbufXML.append("</TR>\n"); 
					sVvdTmp=sVvdCd;
				}
				
				sbufXML.append(" <TR>\n");
				sbufXML.append("  <TD>R</TD>\n");
				sbufXML.append("  <TD DATA-TYPE=\"dtCheckBox\"><![CDATA[0]]></TD>\n");
				sbufXML.append("  <TD DATA-TYPE=\"dtCheckBox\"><![CDATA[");sbufXML.append(colValues.get("rmk")); sbufXML.append("]]></TD>\n"); 
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(colValues.get("op_cd"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(colValues.get("firstlane"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(colValues.get("firstvvd"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(colValues.get("firstetb"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(colValues.get("nextlane"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(colValues.get("nextetd"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(colValues.get("terminal"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(colValues.get("nextvvd"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(colValues.get("bl_no"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(colValues.get("cntr_no"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(colValues.get("cntr_tpsz_cd"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(colValues.get("cntr_seal_no"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(colValues.get("org_yd_cd"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(colValues.get("pol_cd"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(colValues.get("pod_cd"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(colValues.get("pod_nod_cd"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(colValues.get("del_cd"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(colValues.get("wgt"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(colValues.get("bs_cd"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(colValues.get("special"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(colValues.get("auth"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(colValues.get("stwg_cd"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD DATA-ALIGN=\"daLeft\"><![CDATA["); sbufXML.append(JSPUtil.getNull(colValues.get("cmdt_nm"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(colValues.get("ts_rmk"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(colValues.get("bkg_no"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(colValues.get("vsl_nm"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
				sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
				sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(colValues.get("cntr_vol"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(colValues.get("teu"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(colValues.get("feu"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(colValues.get("pol_nm"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(colValues.get("pod_nm"))); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(colValues.get("del_nm"))); sbufXML.append("]]></TD>\n");
				sbufXML.append(" </TR>\n");
				if (JSPUtil.getNull(colValues.get("cntr_tpsz_cd")).length()>0 && 
						"2".equals(JSPUtil.getNull(colValues.get("cntr_tpsz_cd")).substring(JSPUtil.getNull(colValues.get("cntr_tpsz_cd")).length()-1,JSPUtil.getNull(colValues.get("cntr_tpsz_cd")).length()))){
						//iCntr20Sum++;
						//iCntr20SubSum++;
						/* 현재 로직이 CNTR 갯수를 그냥 Count 하고 있어 Partial 하는 Cntr 가 있어 Cntr Vol 을 사용 함 
						 * double 선언 하여 cntr 가 1 이아닌 0. 값을 받음
						 * 마지막에 int 로 캐스팅 하여 int 형으로 던짐 
						 * */
						iCntr20SubVolSum = Float.parseFloat(JSPUtil.getNullNoTrim(colValues.get("cntr_vol"), "0"));
						iCntr20Sum += iCntr20SubVolSum;
						iCntr20SubSum += iCntr20SubVolSum;
					}else { /* 20 이 아니면 나머지는 모두 40 으로 처리*/
						//iCntr40Sum++;
						//iCntr40SubSum++;
						/* 현재 로직이 CNTR 갯수를 그냥 Count 하고 있어 Partial 하는 Cntr 가 있어 Cntr Vol 을 사용 함 
						 * double 선언 하여 cntr 가 1 이아닌 0. 값을 받음
						 * 마지막에 int 로 캐스팅 하여 int 형으로 던짐 
						 * */
						iCntr40SubVolSum = Float.parseFloat(JSPUtil.getNullNoTrim(colValues.get("cntr_vol"), "0"));
						iCntr40Sum += iCntr40SubVolSum;
						iCntr40SubSum += iCntr40SubVolSum;
						
					}
				 
					fWgtSum+= Float.parseFloat(colValues.get("wgt"));
					if (!sVvdTmp.equals(sNextVvdTmp)) {		//소계처리
						sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");
						sbufXML.append(" <TD>R</TD>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append("SUB TOTAL"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append("SUB TOTAL"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append("SUB TOTAL"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD BGCOLOR=\"232, 231, 236\" DATA-ALIGN=\"daRight\"><![CDATA["); sbufXML.append("20'"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD BGCOLOR=\"232, 231, 236\" DATA-ALIGN=\"daRight\" DATA-FORMAT=\"dfInteger\" BOLD=\"TRUE\" COLOR=\"251, 25, 1\"><![CDATA["); sbufXML.append(iCntr20SubSum); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD BGCOLOR=\"232, 231, 236\" DATA-ALIGN=\"daRight\"><![CDATA["); sbufXML.append("40'"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD BGCOLOR=\"232, 231, 236\" DATA-ALIGN=\"daRight\" DATA-FORMAT=\"dfInteger\" BOLD=\"TRUE\" COLOR=\"251, 25, 1\"><![CDATA["); sbufXML.append(iCntr40SubSum); sbufXML.append("]]></TD>\n");
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
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(iCntr20Sum); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(iCntr40Sum); sbufXML.append("]]></TD>\n");			
						sbufXML.append("  <TD><![CDATA["); sbufXML.append(Math.round(fWgtSum/1000)); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
						sbufXML.append(" </TR>\n");
						iCntr20SubSum=0;
						iCntr40SubSum=0;
					}
			}//for
			
			
			//Total
			sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");
			sbufXML.append(" <TD>R</TD>\n");
			sbufXML.append("  <TD DATA-ALIGN=\"daLeft\"><![CDATA["); sbufXML.append("TOTAL"); sbufXML.append("]]></TD>\n");
			sbufXML.append("  <TD DATA-ALIGN=\"daLeft\"><![CDATA["); sbufXML.append("TOTAL"); sbufXML.append("]]></TD>\n");
			sbufXML.append("  <TD DATA-ALIGN=\"daLeft\"><![CDATA["); sbufXML.append("TOTAL"); sbufXML.append("]]></TD>\n");
			sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
			sbufXML.append("  <TD BGCOLOR=\"232, 231, 236\" DATA-ALIGN=\"daRight\"><![CDATA["); sbufXML.append("20'"); sbufXML.append("]]></TD>\n");
			sbufXML.append("  <TD BGCOLOR=\"232, 231, 236\" DATA-ALIGN=\"daRight\" BOLD=\"TRUE\" COLOR=\"251, 25, 1\"><![CDATA["); sbufXML.append((int)iCntr20Sum); sbufXML.append("]]></TD>\n");
			sbufXML.append("  <TD BGCOLOR=\"232, 231, 236\" DATA-ALIGN=\"daRight\"><![CDATA["); sbufXML.append("40'"); sbufXML.append("]]></TD>\n");
			sbufXML.append("  <TD BGCOLOR=\"232, 231, 236\" DATA-ALIGN=\"daRight\" BOLD=\"TRUE\" COLOR=\"251, 25, 1\"><![CDATA["); sbufXML.append((int)iCntr40Sum); sbufXML.append("]]></TD>\n");
			sbufXML.append("  <TD><![CDATA[ ]]></TD>\n"); 
			sbufXML.append("  <TD DATA-ALIGN=\"daLeft\"><![CDATA["); sbufXML.append("Grand Weight"); sbufXML.append("]]></TD>\n");
			sbufXML.append("  <TD BGCOLOR=\"232, 231, 236\"><![CDATA["); sbufXML.append("Grand Weight"); sbufXML.append("]]></TD>\n"); 
			sbufXML.append("  <TD BGCOLOR=\"232, 231, 236\" DATA-ALIGN=\"daRight\" DATA-FORMAT=\"dfNumber\"  BOLD=\"TRUE\" COLOR=\"251, 25, 1\"><![CDATA["); sbufXML.append(Math.round(fWgtSum/1000)); sbufXML.append("]]></TD>\n");
			sbufXML.append("  <TD BGCOLOR=\"232, 231, 236\" DATA-ALIGN=\"daRight\" DATA-FORMAT=\"dfNumber\"  BOLD=\"TRUE\" COLOR=\"251, 25, 1\"><![CDATA["); sbufXML.append(Math.round(fWgtSum/1000)); sbufXML.append("]]></TD>\n");
			sbufXML.append("  <TD><![CDATA[TON]]></TD>\n");
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
			sbufXML.append("  <TD><![CDATA["); sbufXML.append((int)iCntr20Sum); sbufXML.append("]]></TD>\n");
			sbufXML.append("  <TD><![CDATA["); sbufXML.append((int)iCntr40Sum); sbufXML.append("]]></TD>\n");			
			sbufXML.append("  <TD><![CDATA["); sbufXML.append(Math.round(fWgtSum/1000)); sbufXML.append("]]></TD>\n");			
			sbufXML.append("  <TD><![CDATA[ ]]></TD>\n");
			sbufXML.append(" </TR>\n");
			
			
		}else{
			sbufXML.append("<DATA COLORDER='" + JSPUtil.convertStringArrayToString(changedColNms, "|") + "' COLSEPARATOR='" + DELIMITER + "' TOTAL='" + totCnt +"'>\n");
			for(int i=0;i<realCnt;i++){
				Map<String, String> colValues = vos.get(i).getColumnValues();
				
				sbufXML.append("	<TR><![CDATA[");
			    colCnt = realColNms.length;
				
				for (int j = 0 ; j < colCnt-1 ; j++) {
					sbufXML.append(JSPUtil.getNull(colValues.get(realColNms[j])) + DELIMITER); 
		        }
				sbufXML.append(JSPUtil.getNull(colValues.get(realColNms[colCnt-1])) + "]]></TR>\n");
			}
		}
		
		sbufXML.append("</DATA>\n");
		
		return sbufXML.toString();
	}

	/**
	 * DBRowSet를 Parsing하여 <DATA>태그를 생성한다.<br>
	 * IBSheet의 prefix값이 있는 경우 COLORDER에 prefix를 붙인 column명으로 표시해 준다.<br>
	 * 
	 * @param DBRowSet rs
	 * @param String prefix
	 * @return String
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
			throw new RuntimeException(ex.getMessage());
		}
		return sb.toString();
	}
	/**
	 * Pivot Table용 Data tag를 생성한다.<br>
	 * 
	 * @param DBRowSet rs
	 * @return String
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
		}catch(SQLException ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}
		return sb.toString();
	}

}
