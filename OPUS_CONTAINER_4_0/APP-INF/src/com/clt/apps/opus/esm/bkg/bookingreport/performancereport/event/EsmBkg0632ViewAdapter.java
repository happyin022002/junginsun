/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0632ViewAdapter.java
*@FileTitle : Sales Performance Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.09.01 강동윤
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event;

import java.util.List;
import java.util.Map;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Kang Dong Yun
 * @see ViewAdapter 참조
 * @since J2EE 1.6
 */
public class EsmBkg0632ViewAdapter extends ViewAdapter{

	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체 
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
		
		String nowVVD 	= "";
		String befVVD 	= "";
		String nexVVD 	= "";
		
		float subTotTeu = 0;
		float subTotFeu = 0;
		float subTotTtl = 0;
		float subTotGro = 0;
		float subTotOth = 0;
		float subTot20  = 0;
		float subTot40  = 0;
		float subTotSlo = 0;
		float subTotOft = 0;
		float subTotBaf = 0;
		float subTotCaf = 0;
		float subTotDth = 0;
		float subTotDoc = 0;
		float subTotTac = 0;
		float subTotRth = 0;
		float subTotD2  = 0;
		float subTotD4  = 0;
		float subTotD5  = 0;
		float subTotR2  = 0;
		float subTotR4  = 0;
		float subTotS2  = 0;
		float subTotS4  = 0;
		float subTotRD2 = 0;
		float subTotRD4 = 0;
		
		float totTeu 	= 0;
		float totFeu  	= 0;
		float totTtl 	= 0;
		float totGro	= 0;
		float totOth	= 0;
		float tot20		= 0;
		float tot40		= 0;
		float totSlo	= 0;
		float totOft	= 0;
		float totBaf	= 0;
		float totCaf	= 0;
		float totDth	= 0;
		float totDoc	= 0;
		float totTac	= 0;
		float totRth	= 0;
		float totD2		= 0;
		float totD4		= 0;
		float totD5		= 0;
		float totR2		= 0;
		float totR4		= 0;
		float totS2		= 0;
		float totS4		= 0;
		float totRD2	= 0;
		float totRD4	= 0;
		
		java.text.DecimalFormat fm =new java.text.DecimalFormat(",##0");
		java.text.DecimalFormat fm2 =new java.text.DecimalFormat(",##0.00");
		
		Map<String, String> tempColValues = vos.get(0).getColumnValues();			
		
		if(tempColValues.get("rep_knd") != null){
			
			sbufXML.append("\n<DATA TOTAL='"); sbufXML.append(totCnt); sbufXML.append("'>\n");
			
			if (tempColValues.get("rep_knd").equals("G")){//REPORT KIND >>> General 
				
				for(int i = 0 ; i < realCnt ; i++){
					
					Map<String, String> nowColValues = vos.get(i).getColumnValues();
					
					nowVVD = JSPUtil.getNull(nowColValues.get("vvd"));
					
					if (i != 0){
						
						Map<String, String> befColValues = vos.get(i-1).getColumnValues(); 
						
						befVVD = JSPUtil.getNull(befColValues.get("vvd"));
					}
					
					if (i != realCnt-1){
						
						Map<String, String> nexColValues = vos.get(i+1).getColumnValues(); 
						
						nexVVD = JSPUtil.getNull(nexColValues.get("vvd"));
					}else{
						
						nexVVD = "";
					}
					
					if (!befVVD.equals(nowVVD)){		//그룹구분
						
						sbufXML.append(" <TR Merge=\"TRUE\" BackColor=\"246, 225, 236\">\n");
						for(int row=0; row<14; row++){ 
							sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						}
						sbufXML.append("</TR>\n"); 
	
					}
					
					sbufXML.append(" <TR>\n");
					
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("vvd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("bkg_pod"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNull(nowColValues.get("teu"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("feu"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNull(nowColValues.get("ttl"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("void_teu"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNull(nowColValues.get("void_feu"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("gross"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("net"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("non_net"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("misc"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("non_rev"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("teu_gross"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("feu_gross"),"0.00")); sbufXML.append("]]></TD>\n");
					
					sbufXML.append(" </TR>\n");
				
					
					if (!nowVVD.equals(nexVVD)){		//소계처리									
						
						sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");
						
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[Sub Total]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[Sub Total]]></TD>\n");
						
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(nowColValues.get("sub_tot_teu")).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(nowColValues.get("sub_tot_feu")).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(nowColValues.get("sub_tot_ttl")).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(nowColValues.get("sub_tot_void_teu")).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(nowColValues.get("sub_tot_void_feu")).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(nowColValues.get("sub_tot_gross")).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(nowColValues.get("sub_tot_net")).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(nowColValues.get("sub_tot_non_net")).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(nowColValues.get("sub_tot_misc")).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(nowColValues.get("sub_tot_non_rev")).append("]]></TD>\n");
						
						sbufXML.append("  <TD Align=\"Right\" ><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" ><![CDATA[ ]]></TD>\n");
						
						
						
						sbufXML.append(" </TR>\n");
						
					}
					

					if (i == realCnt-1){
						
						//Total
						sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");
						
						sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
						
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(nowColValues.get("tot_teu")).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(nowColValues.get("tot_feu")).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(nowColValues.get("tot_ttl")).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(nowColValues.get("tot_void_teu")).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(nowColValues.get("tot_void_feu")).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(nowColValues.get("tot_gross")).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(nowColValues.get("tot_net")).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(nowColValues.get("tot_non_net")).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(nowColValues.get("tot_misc")).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(nowColValues.get("tot_non_rev")).append("]]></TD>\n");
						
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\" ><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\" ><![CDATA[ ]]></TD>\n");
						
						sbufXML.append(" </TR>\n");
					}					
					
				}//for
				
			}else if (tempColValues.get("rep_knd").equals("R")){//REPORT KIND >>> By Route
				
				for(int i = 0 ; i < realCnt ; i++){
					
					Map<String, String> nowColValues = vos.get(i).getColumnValues();
					
					nowVVD = JSPUtil.getNull(nowColValues.get("vvd"));
					
					if (i != 0){
						
						Map<String, String> befColValues = vos.get(i-1).getColumnValues(); 
						
						befVVD = JSPUtil.getNull(befColValues.get("vvd"));
					}
					
					if (i != realCnt-1){
						
						Map<String, String> nexColValues = vos.get(i+1).getColumnValues(); 
						
						nexVVD = JSPUtil.getNull(nexColValues.get("vvd"));
					}else{
						
						nexVVD = "";
					}
					
					if (!befVVD.equals(nowVVD)){		//그룹구분
						
						sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");
						
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						
						sbufXML.append("</TR>\n"); 
					}
					
					sbufXML.append(" <TR>\n");
					
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("vvd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("slan_cd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("por_cd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("pod_cd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNull(nowColValues.get("teu"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("feu"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNull(nowColValues.get("void_slot"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("ttl"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("gross"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("void_rpb"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("eq_rpb"),"0.00")); sbufXML.append("]]></TD>\n");										
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("oft"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("baf"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("caf"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("oth"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("dth"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("doc"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("tac"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("r_other"),"0.00")); sbufXML.append("]]></TD>\n");
					
					sbufXML.append(" </TR>\n");
					
					subTotTeu += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("teu"),"0"));
					subTotFeu += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("feu"),"0"));
					subTotSlo += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_slot"),"0")); 
					subTotTtl += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("ttl"),"0")); 
					subTot20  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_rpb"),"0")); 
					subTot40  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("eq_rpb"),"0")); 
					subTotGro += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("gross"),"0")); 
					subTotOft += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("oft"),"0")); 
					subTotBaf += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("baf"),"0")); 
					subTotCaf += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("caf"),"0")); 
					subTotOth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("oth"),"0")); 
					subTotDth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("dth"),"0")); 
					subTotDoc += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("doc"),"0")); 
					subTotTac += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("tac"),"0")); 
					subTotRth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("r_other"),"0")); 					
					
					if (!nowVVD.equals(nexVVD)){		//소계처리									
						
						sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");
						
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");						
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm.format(subTotTeu)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm.format(subTotFeu)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm.format(subTotSlo)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm.format(subTotTtl)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTotGro)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTot20)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTot40)).append("]]></TD>\n");						
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTotOft)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTotBaf)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTotCaf)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTotOth)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTotDth)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTotDoc)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTotTac)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTotRth)).append("]]></TD>\n");
						
						sbufXML.append(" </TR>\n");
						
						subTotTeu = 0;
						subTotFeu = 0;
						subTotSlo = 0;
						subTotTtl = 0;
						subTot20  = 0;
						subTot40  = 0;
						subTotGro = 0;
						subTotOft = 0;
						subTotBaf = 0;
						subTotCaf = 0; 
						subTotOth = 0; 
						subTotDth = 0;
						subTotDoc = 0; 
						subTotTac = 0;
						subTotRth = 0;
					}
					
					totTeu += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("teu"),"0"));
					totFeu += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("feu"),"0"));
					totSlo += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_slot"),"0")); 
					totTtl += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("ttl"),"0")); 
					tot20  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_rpb"),"0"));
					tot40  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("eq_rpb"),"0"));
					totGro += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("gross"),"0")); 
					totOft += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("oft"),"0")); 
					totBaf += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("baf"),"0")); 
					totCaf += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("caf"),"0")); 
					totOth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("oth"),"0")); 
					totDth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("dth"),"0")); 
					totDoc += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("doc"),"0")); 
					totTac += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("tac"),"0")); 
					totRth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("r_other"),"0")); 
	
				}//for
				
				//Total
				sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");

				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");				
				sbufXML.append("  <TD Align=\"Right\"  FontBold=\"TRUE\"><![CDATA[ ").append(fm.format(totTeu)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\"  FontBold=\"TRUE\"><![CDATA[").append(fm.format(totFeu)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\"  FontBold=\"TRUE\"><![CDATA[ ").append(fm.format(totSlo)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\"  FontBold=\"TRUE\"><![CDATA[").append(fm.format(totTtl)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\"  FontBold=\"TRUE\" ><![CDATA[ ").append(fm2.format(totGro)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\"  FontBold=\"TRUE\" ><![CDATA[").append(fm2.format(tot20)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\"  FontBold=\"TRUE\" ><![CDATA[ ").append(fm2.format(tot40)).append("]]></TD>\n");				
				sbufXML.append("  <TD Align=\"Right\"  FontBold=\"TRUE\" ><![CDATA[").append(fm2.format(totOft)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\"  FontBold=\"TRUE\" ><![CDATA[ ").append(fm2.format(totBaf)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\"  FontBold=\"TRUE\" ><![CDATA[").append(fm2.format(totCaf)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\"  FontBold=\"TRUE\" ><![CDATA[ ").append(fm2.format(totOth)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\"  FontBold=\"TRUE\" ><![CDATA[").append(fm2.format(totDth)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\"  FontBold=\"TRUE\" ><![CDATA[ ").append(fm2.format(totDoc)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\"  FontBold=\"TRUE\" ><![CDATA[").append(fm2.format(totTac)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\"  FontBold=\"TRUE\" ><![CDATA[ ").append(fm2.format(totRth)).append("]]></TD>\n");
				
				sbufXML.append(" </TR>\n");
			}else if (tempColValues.get("rep_knd").equals("E")){//REPORT KIND >>> By E/Q Type
				
				for(int i = 0 ; i < realCnt ; i++){
					
					Map<String, String> nowColValues = vos.get(i).getColumnValues();
					
					nowVVD = JSPUtil.getNull(nowColValues.get("vvd"));
					
					if (i != 0){
						
						Map<String, String> befColValues = vos.get(i-1).getColumnValues(); 
						
						befVVD = JSPUtil.getNull(befColValues.get("vvd"));
					}
					
					if (i != realCnt-1){
						
						Map<String, String> nexColValues = vos.get(i+1).getColumnValues(); 
						
						nexVVD = JSPUtil.getNull(nexColValues.get("vvd"));
					}else{
						
						nexVVD = "";
					}
					
					if (!befVVD.equals(nowVVD)){		//그룹구분
						
						sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");
						
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						
						sbufXML.append("</TR>\n"); 
	
					}
					
					sbufXML.append(" <TR>\n");
					
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("vvd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("slan_cd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("por_cd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("pod_cd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNull(nowColValues.get("teu"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("feu"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNull(nowColValues.get("void_teu"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("void_feu"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNull(nowColValues.get("ttl"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("gross"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("void_rpb"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("eq_rpb"),"0.00")); sbufXML.append("]]></TD>\n");										
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("d2"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("d4"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("d5"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("r2"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("r4"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("rd2"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("rd4"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("s2"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("s4"),"0.00")); sbufXML.append("]]></TD>\n");
					
					sbufXML.append(" </TR>\n");
					
					subTotTeu += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("teu"),"0"));
					subTotFeu += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("feu"),"0"));
					subTotOth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_teu"),"0")); 
					subTotDth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_feu"),"0"));
					subTotTtl += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("ttl"),"0")); 
					subTot20  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_rpb"),"0")); 
					subTot40  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("eq_rpb"),"0")); 
					subTotGro += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("gross"),"0")); 
					subTotD2  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("d2"),"0")); 
					subTotD4  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("d4"),"0")); 
					subTotD5  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("d5"),"0")); 
					subTotR2  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("r2"),"0")); 
					subTotR4  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("r4"),"0")); 
					subTotRD2 += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("rd2"),"0")); 
					subTotRD4 += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("rd4"),"0")); 
					subTotS2  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("s2"),"0")); 
					subTotS4  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("s4"),"0")); 
					
					if (!nowVVD.equals(nexVVD)){		//소계처리									
						
						sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");
						
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");						
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm.format(subTotTeu)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm.format(subTotFeu)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTotOth)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm.format(subTotDth)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm.format(subTotTtl)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTotGro)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTot20)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTot40)).append("]]></TD>\n");						
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTotD2)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTotD4)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTotD5)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTotR2)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTotR4)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTotRD2)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTotRD4)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTotS2)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTotS4)).append("]]></TD>\n");						
						
						sbufXML.append(" </TR>\n");
						
						subTotTeu = 0;
						subTotFeu = 0;
						subTotOth = 0;
						subTotDth = 0;
						subTotTtl = 0;
						subTot20  = 0;
						subTot40  = 0;
						subTotGro = 0;
						subTotD2  = 0;
						subTotD4  = 0;
						subTotD5  = 0;
						subTotR2  = 0;
						subTotR4  = 0;
						subTotRD2 = 0;
						subTotRD4 = 0;
						subTotS2  = 0;
						subTotS4  = 0;
					}
					
					totTeu += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("teu"),"0"));
					totFeu += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("feu"),"0"));
					totOth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_teu"),"0")); 
					totDth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_feu"),"0"));
					totTtl += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("ttl"),"0")); 
					tot20  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_rpb"),"0")); 
					tot40  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("eq_rpb"),"0")); 
					totGro += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("gross"),"0")); 
					totD2  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("d2"),"0")); 
					totD4  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("d4"),"0")); 
					totD5  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("d5"),"0")); 
					totR2  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("r2"),"0")); 
					totR4  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("r4"),"0")); 
					totRD2 += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("rd2"),"0")); 
					totRD4 += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("rd4"),"0")); 
					totS2  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("s2"),"0")); 
					totS4  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("s4"),"0")); 
	
				}//for
				
				//Total
				sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");
				
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");				
				sbufXML.append("  <TD Align=\"Right\"  FontBold=\"TRUE\"><![CDATA[ ").append(fm.format(totTeu)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\"  FontBold=\"TRUE\"><![CDATA[").append(fm.format(totFeu)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\"  FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(totOth)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\"  FontBold=\"TRUE\"><![CDATA[").append(fm.format(totDth)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\"  FontBold=\"TRUE\"><![CDATA[ ").append(fm.format(totTtl)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\"  FontBold=\"TRUE\"><![CDATA[").append(fm2.format(totGro)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\"  FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(tot20)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\"  FontBold=\"TRUE\"><![CDATA[").append(fm2.format(tot40)).append("]]></TD>\n");						
				sbufXML.append("  <TD Align=\"Right\"  FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(totD2)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\"  FontBold=\"TRUE\"><![CDATA[").append(fm2.format(totD4)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\"  FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(totD5)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\"  FontBold=\"TRUE\"><![CDATA[").append(fm2.format(totR2)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\"  FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(totR4)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\"  FontBold=\"TRUE\"><![CDATA[").append(fm2.format(totRD2)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\"  FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(totRD4)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\"  FontBold=\"TRUE\"><![CDATA[").append(fm2.format(totS2)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\"  FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(totS4)).append("]]></TD>\n");
				
				sbufXML.append(" </TR>\n");
			}else if (tempColValues.get("rep_knd").equals("O")){//REPORT KIND >>> By Sales Office
				
				for(int i = 0 ; i < realCnt ; i++){
					
					Map<String, String> nowColValues = vos.get(i).getColumnValues();
					
					nowVVD = JSPUtil.getNull(nowColValues.get("vvd"));
					
					if (i != 0){
						
						Map<String, String> befColValues = vos.get(i-1).getColumnValues(); 
						
						befVVD = JSPUtil.getNull(befColValues.get("vvd"));
					}
					
					if (i != realCnt-1){
						
						Map<String, String> nexColValues = vos.get(i+1).getColumnValues(); 
						
						nexVVD = JSPUtil.getNull(nexColValues.get("vvd"));
					}else{
						
						nexVVD = "";
					}
					
					if (!befVVD.equals(nowVVD)){		//그룹구분
						
						sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");
						
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						
						sbufXML.append("</TR>\n"); 
	
					}
					
					sbufXML.append(" <TR>\n");
					
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("vvd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("slan_cd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("por_cd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("pod_cd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("sls_rhq_cd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("rgn_cnt"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("sls_rgn_ofc_cd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("ofc_cnt"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("ob_sls_ofc_cd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNull(nowColValues.get("teu"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("feu"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNull(nowColValues.get("void_teu"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("void_feu"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNull(nowColValues.get("ttl"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("gross"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("void_rpb"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("eq_rpb"),"0.00")); sbufXML.append("]]></TD>\n");										
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("oft"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("baf"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("caf"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("oth"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("dth"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("doc"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("tac"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("r_other"),"0.00")); sbufXML.append("]]></TD>\n");
					
					sbufXML.append(" </TR>\n");
					
					subTotTeu += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("teu"),"0"));
					subTotFeu += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("feu"),"0"));
					subTotD2  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_teu"),"0")); 
					subTotD4  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_feu"),"0"));
					subTotTtl += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("ttl"),"0")); 
					subTot20  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_rpb"),"0")); 
					subTot40  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("eq_rpb"),"0")); 
					subTotGro += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("gross"),"0")); 
					subTotOft += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("oft"),"0")); 
					subTotBaf += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("baf"),"0")); 
					subTotCaf += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("caf"),"0")); 
					subTotOth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("oth"),"0")); 
					subTotDth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("dth"),"0")); 
					subTotDoc += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("doc"),"0")); 
					subTotTac += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("tac"),"0")); 
					subTotRth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("r_other"),"0")); 
					
					if (!nowVVD.equals(nexVVD)){		//소계처리									
						
						sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");
						
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");		
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm.format(subTotTeu)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm.format(subTotFeu)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm.format(subTotD2)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm.format(subTotD4)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm.format(subTotTtl)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTotGro)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTot20)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTot40)).append("]]></TD>\n");						
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTotOft)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTotBaf)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTotCaf)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTotOth)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTotDth)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTotDoc)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTotTac)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTotRth)).append("]]></TD>\n");
						
						sbufXML.append(" </TR>\n");
						
						subTotTeu = 0;
						subTotFeu = 0;
						subTotD2  = 0;
						subTotD4  = 0;
						subTotTtl = 0;
						subTot20  = 0;
						subTot40  = 0;
						subTotGro = 0;
						subTotOft = 0;
						subTotBaf = 0;
						subTotCaf = 0;
						subTotOth = 0;
						subTotDth = 0;
						subTotDoc = 0;
						subTotTac = 0;
						subTotRth = 0;
					}
					
					totTeu += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("teu"),"0"));
					totFeu += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("feu"),"0"));
					totD2  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_teu"),"0")); 
					totD4  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_feu"),"0"));
					totTtl += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("ttl"),"0")); 
					tot20  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_rpb"),"0")); 
					tot40  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("eq_rpb"),"0")); 
					totGro += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("gross"),"0")); 
					totOft += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("oft"),"0")); 
					totBaf += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("baf"),"0")); 
					totCaf += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("caf"),"0")); 
					totOth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("oth"),"0")); 
					totDth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("dth"),"0")); 
					totDoc += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("doc"),"0")); 
					totTac += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("tac"),"0")); 
					totRth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("r_other"),"0")); 
	
				}//for
				
				//Total
				sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");
				
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");								
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");												
				
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm.format(totTeu)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm.format(totFeu)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm.format(totD2)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm.format(totD4)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm.format(totTtl)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(totGro)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm2.format(tot20)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(tot40)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm2.format(totOft)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(totBaf)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm2.format(totCaf)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(totOth)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm2.format(totDth)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(totDoc)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm2.format(totTac)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(totRth)).append("]]></TD>\n");
				
				sbufXML.append(" </TR>\n");
			}else if (tempColValues.get("rep_knd").equals("C")){//REPORT KIND >>> By Rep Commodity
				
				for(int i = 0 ; i < realCnt ; i++){
					
					Map<String, String> nowColValues = vos.get(i).getColumnValues();
					
					nowVVD = JSPUtil.getNull(nowColValues.get("vvd"));
					
					if (i != 0){
						
						Map<String, String> befColValues = vos.get(i-1).getColumnValues(); 
						
						befVVD = JSPUtil.getNull(befColValues.get("vvd"));
					}
					
					if (i != realCnt-1){
						
						Map<String, String> nexColValues = vos.get(i+1).getColumnValues(); 
						
						nexVVD = JSPUtil.getNull(nexColValues.get("vvd"));
					}else{
						
						nexVVD = "";
					}
					
					if (!befVVD.equals(nowVVD)){		//그룹구분
						
						sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");
						
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						
						sbufXML.append("</TR>\n"); 
	
					}
					
					sbufXML.append(" <TR>\n");
					
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("vvd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("slan_cd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("por_cd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("pod_cd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("rep_cmdt_cd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("rep_cmdt_nm"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNull(nowColValues.get("teu"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("feu"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNull(nowColValues.get("void_teu"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("void_feu"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNull(nowColValues.get("ttl"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("gross"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("void_rpb"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("eq_rpb"),"0.00")); sbufXML.append("]]></TD>\n");										
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("oft"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("baf"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("caf"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("oth"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("dth"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("doc"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("tac"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("r_other"),"0.00")); sbufXML.append("]]></TD>\n");
					
					sbufXML.append(" </TR>\n");
					
					subTotTeu += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("teu"),"0"));
					subTotFeu += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("feu"),"0"));
					subTotD2  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_teu"),"0")); 
					subTotD4  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_feu"),"0"));
					subTotTtl += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("ttl"),"0")); 
					subTot20  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_rpb"),"0")); 
					subTot40  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("eq_rpb"),"0")); 
					subTotGro += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("gross"),"0")); 
					subTotOft += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("oft"),"0")); 
					subTotBaf += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("baf"),"0")); 
					subTotCaf += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("caf"),"0")); 
					subTotOth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("oth"),"0")); 
					subTotDth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("dth"),"0")); 
					subTotDoc += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("doc"),"0")); 
					subTotTac += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("tac"),"0")); 
					subTotRth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("r_other"),"0")); 
					
					if (!nowVVD.equals(nexVVD)){		//소계처리									
						
						sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");
						
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");		
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm.format(subTotTeu)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm.format(subTotFeu)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm.format(subTotD2)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm.format(subTotD4)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm.format(subTotTtl)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTotGro)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTot20)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTot40)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTotOft)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTotBaf)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTotCaf)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTotOth)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTotDth)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTotDoc)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTotTac)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTotRth)).append("]]></TD>\n");
						
						sbufXML.append(" </TR>\n");
						
						subTotTeu = 0;
						subTotFeu = 0;
						subTotD2  = 0;
						subTotD4  = 0;
						subTotTtl = 0;
						subTot20  = 0;
						subTot40  = 0;
						subTotGro = 0;
						subTotOft = 0;
						subTotBaf = 0;
						subTotCaf = 0;
						subTotOth = 0;
						subTotDth = 0;
						subTotDoc = 0;
						subTotTac = 0;
						subTotRth = 0;
					}
					
					totTeu += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("teu"),"0"));
					totFeu += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("feu"),"0"));
					totD2  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_teu"),"0")); 
					totD4  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_feu"),"0"));
					totTtl += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("ttl"),"0")); 
					tot20  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_rpb"),"0")); 
					tot40  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("eq_rpb"),"0")); 
					totGro += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("gross"),"0")); 
					totOft += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("oft"),"0")); 
					totBaf += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("baf"),"0")); 
					totCaf += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("caf"),"0")); 
					totOth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("oth"),"0")); 
					totDth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("dth"),"0")); 
					totDoc += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("doc"),"0")); 
					totTac += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("tac"),"0")); 
					totRth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("r_other"),"0")); 
	
				}//for
				
				//Total
				sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");
				
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");								
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
				
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm.format(totTeu)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm.format(totFeu)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm.format(totD2)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm.format(totD4)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm.format(totTtl)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(totGro)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm2.format(tot20)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(tot40)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm2.format(totOft)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(totBaf)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm2.format(totCaf)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(totOth)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm2.format(totDth)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(totDoc)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm2.format(totTac)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(totRth)).append("]]></TD>\n");
				
				sbufXML.append(" </TR>\n");
			}else if (tempColValues.get("rep_knd").equals("M")){//REPORT KIND >>> By Shipper Code
				
				for(int i = 0 ; i < realCnt ; i++){
					
					Map<String, String> nowColValues = vos.get(i).getColumnValues();
					
					nowVVD = JSPUtil.getNull(nowColValues.get("vvd"));
					
					if (i != 0){
						
						Map<String, String> befColValues = vos.get(i-1).getColumnValues(); 
						
						befVVD = JSPUtil.getNull(befColValues.get("vvd"));
					}
					
					if (i != realCnt-1){
						
						Map<String, String> nexColValues = vos.get(i+1).getColumnValues(); 
						
						nexVVD = JSPUtil.getNull(nexColValues.get("vvd"));
					}else{
						
						nexVVD = "";
					}
					
					if (!befVVD.equals(nowVVD)){		//그룹구분
						
						sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");
						
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						
						sbufXML.append("</TR>\n"); 
	
					}
					
					sbufXML.append(" <TR>\n");
					
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("vvd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("slan_cd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("por_cd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("pod_cd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cust_cnt_cd"))); sbufXML.append(JSPUtil.getNull(nowColValues.get("cust_seq"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cust_nm"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNull(nowColValues.get("teu"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("feu"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNull(nowColValues.get("void_teu"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("void_feu"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNull(nowColValues.get("ttl"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("gross"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("void_rpb"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("eq_rpb"),"0.00")); sbufXML.append("]]></TD>\n");										
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("oft"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("baf"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("caf"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("oth"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("dth"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("doc"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("tac"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("r_other"),"0.00")); sbufXML.append("]]></TD>\n");
					
					sbufXML.append(" </TR>\n");
					
					subTotTeu += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("teu"),"0"));
					subTotFeu += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("feu"),"0"));
					subTotD2  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_teu"),"0")); 
					subTotD4  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_feu"),"0"));
					subTotTtl += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("ttl"),"0")); 
					subTot20  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_rpb"),"0")); 
					subTot40  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("eq_rpb"),"0")); 
					subTotGro += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("gross"),"0")); 
					subTotOft += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("oft"),"0")); 
					subTotBaf += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("baf"),"0")); 
					subTotCaf += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("caf"),"0")); 
					subTotOth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("oth"),"0")); 
					subTotDth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("dth"),"0")); 
					subTotDoc += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("doc"),"0")); 
					subTotTac += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("tac"),"0")); 
					subTotRth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("r_other"),"0")); 
					
					if (!nowVVD.equals(nexVVD)){		//소계처리									
						
						sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");
						
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");		
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm.format(subTotTeu)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm.format(subTotFeu)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm.format(subTotD2)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm.format(subTotD4)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm.format(subTotTtl)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTotGro)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTot20)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTot40)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTotOft)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTotBaf)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTotCaf)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTotOth)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTotDth)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTotDoc)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTotTac)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTotRth)).append("]]></TD>\n");
						
						sbufXML.append(" </TR>\n");
						
						subTotTeu = 0;
						subTotFeu = 0;
						subTotD2  = 0;
						subTotD4  = 0;
						subTotTtl = 0;
						subTot20  = 0;
						subTot40  = 0;
						subTotGro = 0;
						subTotOft = 0;
						subTotBaf = 0;
						subTotCaf = 0;
						subTotOth = 0;
						subTotDth = 0;
						subTotDoc = 0;
						subTotTac = 0;
						subTotRth = 0;
					}
					
					totTeu += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("teu"),"0"));
					totFeu += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("feu"),"0"));
					totD2  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_teu"),"0")); 
					totD4  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_feu"),"0"));
					totTtl += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("ttl"),"0")); 
					tot20  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_rpb"),"0")); 
					tot40  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("eq_rpb"),"0")); 
					totGro += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("gross"),"0")); 
					totOft += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("oft"),"0")); 
					totBaf += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("baf"),"0")); 
					totCaf += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("caf"),"0")); 
					totOth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("oth"),"0")); 
					totDth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("dth"),"0")); 
					totDoc += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("doc"),"0")); 
					totTac += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("tac"),"0")); 
					totRth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("r_other"),"0")); 
	
				}//for
				
				//Total
				sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");
				
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");								
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");	
				
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm.format(totTeu)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm.format(totFeu)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm.format(totD2)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm.format(totD4)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm.format(totTtl)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(totGro)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm2.format(tot20)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(tot40)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm2.format(totOft)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(totBaf)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm2.format(totCaf)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(totOth)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm2.format(totDth)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(totDoc)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm2.format(totTac)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(totRth)).append("]]></TD>\n");
				
				sbufXML.append(" </TR>\n");
			}else if (tempColValues.get("rep_knd").equals("P")){//REPORT KIND >>> By Group Code
				
				for(int i = 0 ; i < realCnt ; i++){
					
					Map<String, String> nowColValues = vos.get(i).getColumnValues();
					
					nowVVD = JSPUtil.getNull(nowColValues.get("vvd"));
					
					if (i != 0){
						
						Map<String, String> befColValues = vos.get(i-1).getColumnValues(); 
						
						befVVD = JSPUtil.getNull(befColValues.get("vvd"));
					}
					
					if (i != realCnt-1){
						
						Map<String, String> nexColValues = vos.get(i+1).getColumnValues(); 
						
						nexVVD = JSPUtil.getNull(nexColValues.get("vvd"));
					}else{
						
						nexVVD = "";
					}
					
					if (!befVVD.equals(nowVVD)){		//그룹구분
						
						sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");
						
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						
						sbufXML.append("</TR>\n"); 
	
					}
					
					sbufXML.append(" <TR>\n");
					
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("vvd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("slan_cd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("por_cd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("pod_cd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cust_grp_id"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cust_nm"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNull(nowColValues.get("teu"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("feu"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNull(nowColValues.get("void_teu"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("void_feu"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNull(nowColValues.get("ttl"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("gross"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("void_rpb"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("eq_rpb"),"0.00")); sbufXML.append("]]></TD>\n");										
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("oft"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("baf"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("caf"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("oth"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("dth"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("doc"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("tac"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("r_other"),"0.00")); sbufXML.append("]]></TD>\n");
					
					sbufXML.append(" </TR>\n");
					
					subTotTeu += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("teu"),"0"));
					subTotFeu += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("feu"),"0"));
					subTotD2  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_teu"),"0")); 
					subTotD4  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_feu"),"0"));
					subTotTtl += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("ttl"),"0")); 
					subTot20  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_rpb"),"0")); 
					subTot40  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("eq_rpb"),"0")); 
					subTotGro += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("gross"),"0")); 
					subTotOft += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("oft"),"0")); 
					subTotBaf += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("baf"),"0")); 
					subTotCaf += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("caf"),"0")); 
					subTotOth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("oth"),"0")); 
					subTotDth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("dth"),"0")); 
					subTotDoc += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("doc"),"0")); 
					subTotTac += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("tac"),"0")); 
					subTotRth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("r_other"),"0")); 
					
					if (!nowVVD.equals(nexVVD)){		//소계처리									
						
						sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");
						
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");		
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm.format(subTotTeu)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm.format(subTotFeu)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm.format(subTotD2)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm.format(subTotD4)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm.format(subTotTtl)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTotGro)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTot20)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTot40)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTotOft)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTotBaf)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTotCaf)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTotOth)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTotDth)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTotDoc)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTotTac)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTotRth)).append("]]></TD>\n");
						
						sbufXML.append(" </TR>\n");
						
						subTotTeu = 0;
						subTotFeu = 0;
						subTotD2  = 0;
						subTotD4  = 0;
						subTotTtl = 0;
						subTot20  = 0;
						subTot40  = 0;
						subTotGro = 0;
						subTotOft = 0;
						subTotBaf = 0;
						subTotCaf = 0;
						subTotOth = 0;
						subTotDth = 0;
						subTotDoc = 0;
						subTotTac = 0;
						subTotRth = 0;
					}
					
					totTeu += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("teu"),"0"));
					totFeu += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("feu"),"0"));
					totD2  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_teu"),"0")); 
					totD4  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_feu"),"0"));
					totTtl += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("ttl"),"0")); 
					tot20  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_rpb"),"0")); 
					tot40  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("eq_rpb"),"0")); 
					totGro += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("gross"),"0")); 
					totOft += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("oft"),"0")); 
					totBaf += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("baf"),"0")); 
					totCaf += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("caf"),"0")); 
					totOth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("oth"),"0")); 
					totDth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("dth"),"0")); 
					totDoc += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("doc"),"0")); 
					totTac += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("tac"),"0")); 
					totRth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("r_other"),"0")); 
	
				}//for
				
				//Total
				sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");
				
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");								
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
				
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm.format(totTeu)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm.format(totFeu)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm.format(totD2)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm.format(totD4)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm.format(totTtl)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(totGro)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm2.format(tot20)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(tot40)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm2.format(totOft)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(totBaf)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm2.format(totCaf)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(totOth)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm2.format(totDth)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(totDoc)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm2.format(totTac)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(totRth)).append("]]></TD>\n");
				
				sbufXML.append(" </TR>\n");
			}else if (tempColValues.get("rep_knd").equals("S")){//REPORT KIND >>> By Sales Rep
				
				for(int i = 0 ; i < realCnt ; i++){
					
					Map<String, String> nowColValues = vos.get(i).getColumnValues();
					
					nowVVD = JSPUtil.getNull(nowColValues.get("vvd"));
					
					if (i != 0){
						
						Map<String, String> befColValues = vos.get(i-1).getColumnValues(); 
						
						befVVD = JSPUtil.getNull(befColValues.get("vvd"));
					}
					
					if (i != realCnt-1){
						
						Map<String, String> nexColValues = vos.get(i+1).getColumnValues(); 
						
						nexVVD = JSPUtil.getNull(nexColValues.get("vvd"));
					}else{
						
						nexVVD = "";
					}
					
					if (!befVVD.equals(nowVVD)){		//그룹구분
						
						sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");
						
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						
						sbufXML.append("</TR>\n"); 
	
					}
					
					sbufXML.append(" <TR>\n");
					
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("vvd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("slan_cd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("por_cd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("pod_cd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("ob_srep_cd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("ob_srep_nm"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNull(nowColValues.get("teu"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("feu"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNull(nowColValues.get("void_teu"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("void_feu"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNull(nowColValues.get("ttl"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("gross"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("void_rpb"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("eq_rpb"),"0.00")); sbufXML.append("]]></TD>\n");										
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("oft"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("baf"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("caf"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("oth"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("dth"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("doc"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("tac"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("r_other"),"0.00")); sbufXML.append("]]></TD>\n");
					
					sbufXML.append(" </TR>\n");
					
					subTotTeu += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("teu"),"0"));
					subTotFeu += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("feu"),"0"));
					subTotD2  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_teu"),"0")); 
					subTotD4  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_feu"),"0"));
					subTotTtl += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("ttl"),"0")); 
					subTot20  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_rpb"),"0")); 
					subTot40  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("eq_rpb"),"0")); 
					subTotGro += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("gross"),"0")); 
					subTotOft += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("oft"),"0")); 
					subTotBaf += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("baf"),"0")); 
					subTotCaf += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("caf"),"0")); 
					subTotOth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("oth"),"0")); 
					subTotDth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("dth"),"0")); 
					subTotDoc += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("doc"),"0")); 
					subTotTac += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("tac"),"0")); 
					subTotRth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("r_other"),"0")); 
					
					if (!nowVVD.equals(nexVVD)){		//소계처리									
						
						sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");
						
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");		
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm.format(subTotTeu)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm.format(subTotFeu)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm.format(subTotD2)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm.format(subTotD4)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm.format(subTotTtl)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTotGro)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTot20)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTot40)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTotOft)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTotBaf)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTotCaf)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTotOth)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTotDth)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTotDoc)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTotTac)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTotRth)).append("]]></TD>\n");
						sbufXML.append(" </TR>\n");
						
						subTotTeu = 0;
						subTotFeu = 0;
						subTotD2  = 0;
						subTotD4  = 0;
						subTotTtl = 0;
						subTot20  = 0;
						subTot40  = 0;
						subTotGro = 0;
						subTotOft = 0;
						subTotBaf = 0;
						subTotCaf = 0;
						subTotOth = 0;
						subTotDth = 0;
						subTotDoc = 0;
						subTotTac = 0;
						subTotRth = 0;
					}
					
					totTeu += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("teu"),"0"));
					totFeu += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("feu"),"0"));
					totD2  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_teu"),"0")); 
					totD4  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_feu"),"0"));
					totTtl += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("ttl"),"0")); 
					tot20  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_rpb"),"0")); 
					tot40  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("eq_rpb"),"0")); 
					totGro += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("gross"),"0")); 
					totOft += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("oft"),"0")); 
					totBaf += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("baf"),"0")); 
					totCaf += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("caf"),"0")); 
					totOth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("oth"),"0")); 
					totDth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("dth"),"0")); 
					totDoc += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("doc"),"0")); 
					totTac += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("tac"),"0")); 
					totRth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("r_other"),"0")); 
	
				}//for
				
				//Total
				sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");
				
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");								
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
				
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm.format(totTeu)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm.format(totFeu)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm.format(totD2)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm.format(totD4)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm.format(totTtl)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(totGro)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm2.format(tot20)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(tot40)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm2.format(totOft)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(totBaf)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm2.format(totCaf)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(totOth)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm2.format(totDth)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(totDoc)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm2.format(totTac)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(totRth)).append("]]></TD>\n");
				
				sbufXML.append(" </TR>\n");
			}else if (tempColValues.get("rep_knd").equals("I")){//REPORT KIND >>> By I/B Control Office
				
				for(int i = 0 ; i < realCnt ; i++){
					
					Map<String, String> nowColValues = vos.get(i).getColumnValues();
					
					nowVVD = JSPUtil.getNull(nowColValues.get("vvd"));
					
					if (i != 0){
						
						Map<String, String> befColValues = vos.get(i-1).getColumnValues(); 
						
						befVVD = JSPUtil.getNull(befColValues.get("vvd"));
					}
					
					if (i != realCnt-1){
						
						Map<String, String> nexColValues = vos.get(i+1).getColumnValues(); 
						
						nexVVD = JSPUtil.getNull(nexColValues.get("vvd"));
					}else{
						
						nexVVD = "";
					}
					
					if (!befVVD.equals(nowVVD)){		//그룹구분
						
						sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");
						
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");						
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Left\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append(" VVD : "); sbufXML.append(nowColValues.get("vvd")); sbufXML.append("  	Grpup By : "); sbufXML.append(nowColValues.get("grp_by")); sbufXML.append("]]></TD>\n");
						
						sbufXML.append("</TR>\n"); 
	
					}
					
					sbufXML.append(" <TR>\n");
					
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("vvd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("slan_cd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("por_cd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("pod_cd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("sls_rhq_cd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("rgn_cnt"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("sls_rgn_ofc_cd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("ofc_cnt"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("eq_ctrl_ofc_cd"))); sbufXML.append("]]></TD>\n");
					
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNull(nowColValues.get("teu"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("feu"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNull(nowColValues.get("void_teu"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("void_feu"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNull(nowColValues.get("ttl"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("gross"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("void_rpb"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("eq_rpb"),"0.00")); sbufXML.append("]]></TD>\n");										
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("oft"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("baf"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("caf"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("oth"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("dth"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("doc"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA[ "); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("tac"),"0.00")); sbufXML.append("]]></TD>\n");
					sbufXML.append("  <TD><![CDATA["); sbufXML.append(JSPUtil.getNullNoTrim(nowColValues.get("r_other"),"0.00")); sbufXML.append("]]></TD>\n");
					
					sbufXML.append(" </TR>\n");
					
					subTotTeu += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("teu"),"0"));
					subTotFeu += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("feu"),"0"));
					subTotD2  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_teu"),"0")); 
					subTotD4  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_feu"),"0"));
					subTotTtl += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("ttl"),"0")); 
					subTot20  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_rpb"),"0")); 
					subTot40  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("eq_rpb"),"0")); 
					subTotGro += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("gross"),"0")); 
					subTotOft += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("oft"),"0")); 
					subTotBaf += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("baf"),"0")); 
					subTotCaf += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("caf"),"0")); 
					subTotOth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("oth"),"0")); 
					subTotDth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("dth"),"0")); 
					subTotDoc += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("doc"),"0")); 
					subTotTac += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("tac"),"0")); 
					subTotRth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("r_other"),"0")); 
					
					if (!nowVVD.equals(nexVVD)){		//소계처리									
						
						sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");
						
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");						
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");		
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Sub Total"); sbufXML.append("]]></TD>\n");
						
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm.format(subTotTeu)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm.format(subTotFeu)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm.format(subTotD2)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm.format(subTotD4)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm.format(subTotTtl)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTotGro)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTot20)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTot40)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTotOft)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTotBaf)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTotCaf)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTotOth)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTotDth)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTotDoc)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(fm2.format(subTotTac)).append("]]></TD>\n");
						sbufXML.append("  <TD Align=\"Right\"><![CDATA[ ").append(fm2.format(subTotRth)).append("]]></TD>\n");
						
						sbufXML.append(" </TR>\n");
						
						subTotTeu = 0;
						subTotFeu = 0;
						subTotD2  = 0;
						subTotD4  = 0;
						subTotTtl = 0;
						subTot20  = 0;
						subTot40  = 0;
						subTotGro = 0;
						subTotOft = 0;
						subTotBaf = 0;
						subTotCaf = 0;
						subTotOth = 0;
						subTotDth = 0;
						subTotDoc = 0;
						subTotTac = 0;
						subTotRth = 0;
					}
					
					totTeu += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("teu"),"0"));
					totFeu += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("feu"),"0"));
					totD2  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_teu"),"0")); 
					totD4  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_feu"),"0"));
					totTtl += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("ttl"),"0")); 
					tot20  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("void_rpb"),"0")); 
					tot40  += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("eq_rpb"),"0")); 
					totGro += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("gross"),"0")); 
					totOft += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("oft"),"0")); 
					totBaf += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("baf"),"0")); 
					totCaf += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("caf"),"0")); 
					totOth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("oth"),"0")); 
					totDth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("dth"),"0")); 
					totDoc += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("doc"),"0")); 
					totTac += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("tac"),"0")); 
					totRth += Float.parseFloat(JSPUtil.getNullNoTrim(nowColValues.get("r_other"),"0")); 
	
				}//for
				
				//Total
				sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");
				
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");				
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");								
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Center\" FontBold=\"TRUE\"><![CDATA["); sbufXML.append("Grand Total"); sbufXML.append("]]></TD>\n");
				
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm.format(totTeu)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm.format(totFeu)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm.format(totD2)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm.format(totD4)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm.format(totTtl)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(totGro)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm2.format(tot20)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(tot40)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm2.format(totOft)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(totBaf)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm2.format(totCaf)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(totOth)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm2.format(totDth)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(totDoc)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[").append(fm2.format(totTac)).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" FontBold=\"TRUE\"><![CDATA[ ").append(fm2.format(totRth)).append("]]></TD>\n");
				
				sbufXML.append(" </TR>\n");
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
