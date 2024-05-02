/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1057ViewAdapter.java
*@FileTitle : Freight & Charge List by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.12
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2009.09.12 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import java.math.BigDecimal;
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
 * @author kim tae kyoung
 * @see ViewAdapter 참조
 * @since J2EE 1.6
 */
public class EsmBkg1057ViewAdapter extends ViewAdapter{

	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param colOrder String[] Column명 문자열 
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception 
	 */	
	
	protected  BigDecimal getRound(double dataDouble, int seat){ // 소수점 자리수 표현셋팅

        BigDecimal bd = new BigDecimal(dataDouble);
        bd = bd.setScale(seat, BigDecimal.ROUND_HALF_UP);

        return bd;

    }
	
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		StringBuilder sbufXML = new StringBuilder();
		int totCnt = vos.size();
		int realCnt = vos.size();
		
		AbstractValueObject vo = (AbstractValueObject)vos.get(0);
		//String[] realColNms = getColHeader(vo);
		//String[] changedColNms = getChangedColNms(realColNms, prefix);
		
		if(vo.getMaxRows()>0){
			totCnt = vo.getMaxRows();
		}
		String nowBKgNo ="";
		String befBkgNo ="";
		String nexBkgNo ="";
		//String lastBkgNo = null;
		
		float subTotRatedAs = 0;
		float subTotRate = 0;
		float subAmt = 0;
		
		float grandRatedAs = 0;
		float grandRate = 0;
		float grandAmt = 0;
		
		//int seqIdx = 1;
		//String xx = "0";
		//Map<String, String> tempColValues = vos.get(0).getColumnValues();

		sbufXML.append("\n<DATA TOTAL='"); sbufXML.append(totCnt); sbufXML.append("'>\n");
			
			for(int i = 0 ; i < realCnt; i++){
				Map<String, String> nowColValues = vos.get(i).getColumnValues();
				
				nowBKgNo = JSPUtil.getNull(nowColValues.get("bkg_no"));
				
				if (i !=0 ){
					Map<String, String> befColValues = vos.get(i-1).getColumnValues();
					
					befBkgNo = JSPUtil.getNull(befColValues.get("bkg_no"));
				}
				if (i != realCnt-1){
					
					Map<String, String> nexColValues = vos.get(i+1).getColumnValues(); 
					
					nexBkgNo = JSPUtil.getNull(nexColValues.get("bkg_no"));
				}else{
					
					nexBkgNo = "";
				}
				if(!befBkgNo.equals(nowBKgNo)){ // 그룹구분 
					//seqIdx = 1;
					
					if(nowColValues.get("spl_flg").equals("S")){
						
						sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");
						
						sbufXML.append("  <TD DATA-ALIGN=\"daLeft\" BOLD=\"TRUE\"><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD DATA-ALIGN=\"daLeft\" BOLD=\"TRUE\"><![CDATA["); sbufXML.append(" Booking Number : "); sbufXML.append(nowColValues.get("bkg_no")); sbufXML.append("  TRADE : "); sbufXML.append(nowColValues.get("rev_dir_cd")); sbufXML.append("  POR : "); sbufXML.append(nowColValues.get("pol_cd")); sbufXML.append("  POL : "); sbufXML.append(nowColValues.get("pol_cd"));  sbufXML.append("  POD : "); sbufXML.append(nowColValues.get("pod_cd")); sbufXML.append("  DEL : ");sbufXML.append(nowColValues.get("del_cd")); sbufXML.append("  RD : "); sbufXML.append(nowColValues.get("rcv_term_cd")); sbufXML.append("  DT : "); sbufXML.append(nowColValues.get("de_term_cd")); sbufXML.append("  APLT DT : "); sbufXML.append(nowColValues.get("rt_aply_dt")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD DATA-ALIGN=\"daLeft\" BOLD=\"TRUE\"><![CDATA["); sbufXML.append(" Booking Number : "); sbufXML.append(nowColValues.get("bkg_no")); sbufXML.append("  TRADE : "); sbufXML.append(nowColValues.get("rev_dir_cd")); sbufXML.append("  POR : "); sbufXML.append(nowColValues.get("pol_cd")); sbufXML.append("  POL : "); sbufXML.append(nowColValues.get("pol_cd"));  sbufXML.append("  POD : "); sbufXML.append(nowColValues.get("pod_cd")); sbufXML.append("  DEL : ");sbufXML.append(nowColValues.get("del_cd")); sbufXML.append("  RD : "); sbufXML.append(nowColValues.get("rcv_term_cd")); sbufXML.append("  DT : "); sbufXML.append(nowColValues.get("de_term_cd")); sbufXML.append("  APLT DT : "); sbufXML.append(nowColValues.get("rt_aply_dt")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD DATA-ALIGN=\"daLeft\" BOLD=\"TRUE\"><![CDATA["); sbufXML.append(" Booking Number : "); sbufXML.append(nowColValues.get("bkg_no")); sbufXML.append("  TRADE : "); sbufXML.append(nowColValues.get("rev_dir_cd")); sbufXML.append("  POR : "); sbufXML.append(nowColValues.get("pol_cd")); sbufXML.append("  POL : "); sbufXML.append(nowColValues.get("pol_cd"));  sbufXML.append("  POD : "); sbufXML.append(nowColValues.get("pod_cd")); sbufXML.append("  DEL : ");sbufXML.append(nowColValues.get("del_cd")); sbufXML.append("  RD : "); sbufXML.append(nowColValues.get("rcv_term_cd")); sbufXML.append("  DT : "); sbufXML.append(nowColValues.get("de_term_cd")); sbufXML.append("  APLT DT : "); sbufXML.append(nowColValues.get("rt_aply_dt")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD DATA-ALIGN=\"daLeft\" BOLD=\"TRUE\"><![CDATA["); sbufXML.append(" Booking Number : "); sbufXML.append(nowColValues.get("bkg_no")); sbufXML.append("  TRADE : "); sbufXML.append(nowColValues.get("rev_dir_cd")); sbufXML.append("  POR : "); sbufXML.append(nowColValues.get("pol_cd")); sbufXML.append("  POL : "); sbufXML.append(nowColValues.get("pol_cd"));  sbufXML.append("  POD : "); sbufXML.append(nowColValues.get("pod_cd")); sbufXML.append("  DEL : ");sbufXML.append(nowColValues.get("del_cd")); sbufXML.append("  RD : "); sbufXML.append(nowColValues.get("rcv_term_cd")); sbufXML.append("  DT : "); sbufXML.append(nowColValues.get("de_term_cd")); sbufXML.append("  APLT DT : "); sbufXML.append(nowColValues.get("rt_aply_dt")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD DATA-ALIGN=\"daLeft\" BOLD=\"TRUE\"><![CDATA["); sbufXML.append(" Booking Number : "); sbufXML.append(nowColValues.get("bkg_no")); sbufXML.append("  TRADE : "); sbufXML.append(nowColValues.get("rev_dir_cd")); sbufXML.append("  POR : "); sbufXML.append(nowColValues.get("pol_cd")); sbufXML.append("  POL : "); sbufXML.append(nowColValues.get("pol_cd"));  sbufXML.append("  POD : "); sbufXML.append(nowColValues.get("pod_cd")); sbufXML.append("  DEL : ");sbufXML.append(nowColValues.get("del_cd")); sbufXML.append("  RD : "); sbufXML.append(nowColValues.get("rcv_term_cd")); sbufXML.append("  DT : "); sbufXML.append(nowColValues.get("de_term_cd")); sbufXML.append("  APLT DT : "); sbufXML.append(nowColValues.get("rt_aply_dt")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD DATA-ALIGN=\"daLeft\" BOLD=\"TRUE\"><![CDATA["); sbufXML.append(" Booking Number : "); sbufXML.append(nowColValues.get("bkg_no")); sbufXML.append("  TRADE : "); sbufXML.append(nowColValues.get("rev_dir_cd")); sbufXML.append("  POR : "); sbufXML.append(nowColValues.get("pol_cd")); sbufXML.append("  POL : "); sbufXML.append(nowColValues.get("pol_cd"));  sbufXML.append("  POD : "); sbufXML.append(nowColValues.get("pod_cd")); sbufXML.append("  DEL : ");sbufXML.append(nowColValues.get("del_cd")); sbufXML.append("  RD : "); sbufXML.append(nowColValues.get("rcv_term_cd")); sbufXML.append("  DT : "); sbufXML.append(nowColValues.get("de_term_cd")); sbufXML.append("  APLT DT : "); sbufXML.append(nowColValues.get("rt_aply_dt")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD DATA-ALIGN=\"daLeft\" BOLD=\"TRUE\"><![CDATA["); sbufXML.append(" Booking Number : "); sbufXML.append(nowColValues.get("bkg_no")); sbufXML.append("  TRADE : "); sbufXML.append(nowColValues.get("rev_dir_cd")); sbufXML.append("  POR : "); sbufXML.append(nowColValues.get("pol_cd")); sbufXML.append("  POL : "); sbufXML.append(nowColValues.get("pol_cd"));  sbufXML.append("  POD : "); sbufXML.append(nowColValues.get("pod_cd")); sbufXML.append("  DEL : ");sbufXML.append(nowColValues.get("del_cd")); sbufXML.append("  RD : "); sbufXML.append(nowColValues.get("rcv_term_cd")); sbufXML.append("  DT : "); sbufXML.append(nowColValues.get("de_term_cd")); sbufXML.append("  APLT DT : "); sbufXML.append(nowColValues.get("rt_aply_dt")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD DATA-ALIGN=\"daLeft\" BOLD=\"TRUE\"><![CDATA["); sbufXML.append(" Booking Number : "); sbufXML.append(nowColValues.get("bkg_no")); sbufXML.append("  TRADE : "); sbufXML.append(nowColValues.get("rev_dir_cd")); sbufXML.append("  POR : "); sbufXML.append(nowColValues.get("pol_cd")); sbufXML.append("  POL : "); sbufXML.append(nowColValues.get("pol_cd"));  sbufXML.append("  POD : "); sbufXML.append(nowColValues.get("pod_cd")); sbufXML.append("  DEL : ");sbufXML.append(nowColValues.get("del_cd")); sbufXML.append("  RD : "); sbufXML.append(nowColValues.get("rcv_term_cd")); sbufXML.append("  DT : "); sbufXML.append(nowColValues.get("de_term_cd")); sbufXML.append("  APLT DT : "); sbufXML.append(nowColValues.get("rt_aply_dt")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD DATA-ALIGN=\"daLeft\" BOLD=\"TRUE\"><![CDATA["); sbufXML.append(" Booking Number : "); sbufXML.append(nowColValues.get("bkg_no")); sbufXML.append("  TRADE : "); sbufXML.append(nowColValues.get("rev_dir_cd")); sbufXML.append("  POR : "); sbufXML.append(nowColValues.get("pol_cd")); sbufXML.append("  POL : "); sbufXML.append(nowColValues.get("pol_cd"));  sbufXML.append("  POD : "); sbufXML.append(nowColValues.get("pod_cd")); sbufXML.append("  DEL : ");sbufXML.append(nowColValues.get("del_cd")); sbufXML.append("  RD : "); sbufXML.append(nowColValues.get("rcv_term_cd")); sbufXML.append("  DT : "); sbufXML.append(nowColValues.get("de_term_cd")); sbufXML.append("  APLT DT : "); sbufXML.append(nowColValues.get("rt_aply_dt")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD DATA-ALIGN=\"daLeft\" BOLD=\"TRUE\"><![CDATA["); sbufXML.append(" Booking Number : "); sbufXML.append(nowColValues.get("bkg_no")); sbufXML.append("  TRADE : "); sbufXML.append(nowColValues.get("rev_dir_cd")); sbufXML.append("  POR : "); sbufXML.append(nowColValues.get("pol_cd")); sbufXML.append("  POL : "); sbufXML.append(nowColValues.get("pol_cd"));  sbufXML.append("  POD : "); sbufXML.append(nowColValues.get("pod_cd")); sbufXML.append("  DEL : ");sbufXML.append(nowColValues.get("del_cd")); sbufXML.append("  RD : "); sbufXML.append(nowColValues.get("rcv_term_cd")); sbufXML.append("  DT : "); sbufXML.append(nowColValues.get("de_term_cd")); sbufXML.append("  APLT DT : "); sbufXML.append(nowColValues.get("rt_aply_dt")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD DATA-ALIGN=\"daLeft\" BOLD=\"TRUE\"><![CDATA["); sbufXML.append(" Booking Number : "); sbufXML.append(nowColValues.get("bkg_no")); sbufXML.append("  TRADE : "); sbufXML.append(nowColValues.get("rev_dir_cd")); sbufXML.append("  POR : "); sbufXML.append(nowColValues.get("pol_cd")); sbufXML.append("  POL : "); sbufXML.append(nowColValues.get("pol_cd"));  sbufXML.append("  POD : "); sbufXML.append(nowColValues.get("pod_cd")); sbufXML.append("  DEL : ");sbufXML.append(nowColValues.get("del_cd")); sbufXML.append("  RD : "); sbufXML.append(nowColValues.get("rcv_term_cd")); sbufXML.append("  DT : "); sbufXML.append(nowColValues.get("de_term_cd")); sbufXML.append("  APLT DT : "); sbufXML.append(nowColValues.get("rt_aply_dt")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD DATA-ALIGN=\"daLeft\" BOLD=\"TRUE\"><![CDATA["); sbufXML.append(" Booking Number : "); sbufXML.append(nowColValues.get("bkg_no")); sbufXML.append("  TRADE : "); sbufXML.append(nowColValues.get("rev_dir_cd")); sbufXML.append("  POR : "); sbufXML.append(nowColValues.get("pol_cd")); sbufXML.append("  POL : "); sbufXML.append(nowColValues.get("pol_cd"));  sbufXML.append("  POD : "); sbufXML.append(nowColValues.get("pod_cd")); sbufXML.append("  DEL : ");sbufXML.append(nowColValues.get("del_cd")); sbufXML.append("  RD : "); sbufXML.append(nowColValues.get("rcv_term_cd")); sbufXML.append("  DT : "); sbufXML.append(nowColValues.get("de_term_cd")); sbufXML.append("  APLT DT : "); sbufXML.append(nowColValues.get("rt_aply_dt")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD DATA-ALIGN=\"daLeft\" BOLD=\"TRUE\"><![CDATA["); sbufXML.append(" Booking Number : "); sbufXML.append(nowColValues.get("bkg_no")); sbufXML.append("  TRADE : "); sbufXML.append(nowColValues.get("rev_dir_cd")); sbufXML.append("  POR : "); sbufXML.append(nowColValues.get("pol_cd")); sbufXML.append("  POL : "); sbufXML.append(nowColValues.get("pol_cd"));  sbufXML.append("  POD : "); sbufXML.append(nowColValues.get("pod_cd")); sbufXML.append("  DEL : ");sbufXML.append(nowColValues.get("del_cd")); sbufXML.append("  RD : "); sbufXML.append(nowColValues.get("rcv_term_cd")); sbufXML.append("  DT : "); sbufXML.append(nowColValues.get("de_term_cd")); sbufXML.append("  APLT DT : "); sbufXML.append(nowColValues.get("rt_aply_dt")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD DATA-ALIGN=\"daLeft\" BOLD=\"TRUE\"><![CDATA["); sbufXML.append(" Booking Number : "); sbufXML.append(nowColValues.get("bkg_no")); sbufXML.append("  TRADE : "); sbufXML.append(nowColValues.get("rev_dir_cd")); sbufXML.append("  POR : "); sbufXML.append(nowColValues.get("pol_cd")); sbufXML.append("  POL : "); sbufXML.append(nowColValues.get("pol_cd"));  sbufXML.append("  POD : "); sbufXML.append(nowColValues.get("pod_cd")); sbufXML.append("  DEL : ");sbufXML.append(nowColValues.get("del_cd")); sbufXML.append("  RD : "); sbufXML.append(nowColValues.get("rcv_term_cd")); sbufXML.append("  DT : "); sbufXML.append(nowColValues.get("de_term_cd")); sbufXML.append("  APLT DT : "); sbufXML.append(nowColValues.get("rt_aply_dt")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD DATA-ALIGN=\"daLeft\" BOLD=\"TRUE\"><![CDATA["); sbufXML.append(" Booking Number : "); sbufXML.append(nowColValues.get("bkg_no")); sbufXML.append("  TRADE : "); sbufXML.append(nowColValues.get("rev_dir_cd")); sbufXML.append("  POR : "); sbufXML.append(nowColValues.get("pol_cd")); sbufXML.append("  POL : "); sbufXML.append(nowColValues.get("pol_cd"));  sbufXML.append("  POD : "); sbufXML.append(nowColValues.get("pod_cd")); sbufXML.append("  DEL : ");sbufXML.append(nowColValues.get("del_cd")); sbufXML.append("  RD : "); sbufXML.append(nowColValues.get("rcv_term_cd")); sbufXML.append("  DT : "); sbufXML.append(nowColValues.get("de_term_cd")); sbufXML.append("  APLT DT : "); sbufXML.append(nowColValues.get("rt_aply_dt")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD DATA-ALIGN=\"daLeft\" BOLD=\"TRUE\"><![CDATA["); sbufXML.append(" Booking Number : "); sbufXML.append(nowColValues.get("bkg_no")); sbufXML.append("  TRADE : "); sbufXML.append(nowColValues.get("rev_dir_cd")); sbufXML.append("  POR : "); sbufXML.append(nowColValues.get("pol_cd")); sbufXML.append("  POL : "); sbufXML.append(nowColValues.get("pol_cd"));  sbufXML.append("  POD : "); sbufXML.append(nowColValues.get("pod_cd")); sbufXML.append("  DEL : ");sbufXML.append(nowColValues.get("del_cd")); sbufXML.append("  RD : "); sbufXML.append(nowColValues.get("rcv_term_cd")); sbufXML.append("  DT : "); sbufXML.append(nowColValues.get("de_term_cd")); sbufXML.append("  APLT DT : "); sbufXML.append(nowColValues.get("rt_aply_dt")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD DATA-ALIGN=\"daLeft\" BOLD=\"TRUE\"><![CDATA["); sbufXML.append(" Booking Number : "); sbufXML.append(nowColValues.get("bkg_no")); sbufXML.append("  TRADE : "); sbufXML.append(nowColValues.get("rev_dir_cd")); sbufXML.append("  POR : "); sbufXML.append(nowColValues.get("pol_cd")); sbufXML.append("  POL : "); sbufXML.append(nowColValues.get("pol_cd"));  sbufXML.append("  POD : "); sbufXML.append(nowColValues.get("pod_cd")); sbufXML.append("  DEL : ");sbufXML.append(nowColValues.get("del_cd")); sbufXML.append("  RD : "); sbufXML.append(nowColValues.get("rcv_term_cd")); sbufXML.append("  DT : "); sbufXML.append(nowColValues.get("de_term_cd")); sbufXML.append("  APLT DT : "); sbufXML.append(nowColValues.get("rt_aply_dt")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD DATA-ALIGN=\"daLeft\" BOLD=\"TRUE\"><![CDATA["); sbufXML.append(" Booking Number : "); sbufXML.append(nowColValues.get("bkg_no")); sbufXML.append("  TRADE : "); sbufXML.append(nowColValues.get("rev_dir_cd")); sbufXML.append("  POR : "); sbufXML.append(nowColValues.get("pol_cd")); sbufXML.append("  POL : "); sbufXML.append(nowColValues.get("pol_cd"));  sbufXML.append("  POD : "); sbufXML.append(nowColValues.get("pod_cd")); sbufXML.append("  DEL : ");sbufXML.append(nowColValues.get("del_cd")); sbufXML.append("  RD : "); sbufXML.append(nowColValues.get("rcv_term_cd")); sbufXML.append("  DT : "); sbufXML.append(nowColValues.get("de_term_cd")); sbufXML.append("  APLT DT : "); sbufXML.append(nowColValues.get("rt_aply_dt")); sbufXML.append("]]></TD>\n");
						sbufXML.append("  <TD DATA-ALIGN=\"daLeft\" BOLD=\"TRUE\"><![CDATA["); sbufXML.append(" Booking Number : "); sbufXML.append(nowColValues.get("bkg_no")); sbufXML.append("  TRADE : "); sbufXML.append(nowColValues.get("rev_dir_cd")); sbufXML.append("  POR : "); sbufXML.append(nowColValues.get("pol_cd")); sbufXML.append("  POL : "); sbufXML.append(nowColValues.get("pol_cd"));  sbufXML.append("  POD : "); sbufXML.append(nowColValues.get("pod_cd")); sbufXML.append("  DEL : ");sbufXML.append(nowColValues.get("del_cd")); sbufXML.append("  RD : "); sbufXML.append(nowColValues.get("rcv_term_cd")); sbufXML.append("  DT : "); sbufXML.append(nowColValues.get("de_term_cd")); sbufXML.append("  APLT DT : "); sbufXML.append(nowColValues.get("rt_aply_dt")); sbufXML.append("]]></TD>\n");
						
	 
						sbufXML.append("</TR>\n"); 
					}else if(nowColValues.get("spl_flg").equals("F")){
						sbufXML.append(" <TR>\n");
						
						sbufXML.append("  <TD DATA-ALIGN=\"daLeft\" BOLD=\"TRUE\"><![CDATA[ ]]></TD>\n");
						sbufXML.append("  <TD DATA-ALIGN=\"daLeft\" BOLD=\"TRUE\"><![CDATA["); sbufXML.append(" Booking Number : "); sbufXML.append(nowColValues.get("bkg_no")); sbufXML.append("  TRADE : "); sbufXML.append(nowColValues.get("rev_dir_cd")); sbufXML.append("  POR : "); sbufXML.append(nowColValues.get("pol_cd")); sbufXML.append("  POL : "); sbufXML.append(nowColValues.get("pol_cd"));  sbufXML.append("  POD : "); sbufXML.append(nowColValues.get("pod_cd")); sbufXML.append("  DEL : ");sbufXML.append(nowColValues.get("del_cd")); sbufXML.append("  RD : "); sbufXML.append(nowColValues.get("rcv_term_cd")); sbufXML.append("  DT : "); sbufXML.append(nowColValues.get("de_term_cd")); sbufXML.append("  APLT DT : "); sbufXML.append(nowColValues.get("rt_aply_dt")); sbufXML.append("]]></TD>\n");
						sbufXML.append(" <TD><![CDATA[]]></TD>\n");
						sbufXML.append(" <TD><![CDATA[]]></TD>\n");
						sbufXML.append(" <TD><![CDATA[]]></TD>\n");
						sbufXML.append(" <TD><![CDATA[]]></TD>\n");
						sbufXML.append(" <TD><![CDATA[]]></TD>\n");
						sbufXML.append(" <TD><![CDATA[]]></TD>\n");
						sbufXML.append(" <TD><![CDATA[]]></TD>\n");
						sbufXML.append(" <TD><![CDATA[]]></TD>\n");
						sbufXML.append(" <TD><![CDATA[]]></TD>\n");
						sbufXML.append(" <TD><![CDATA[]]></TD>\n");
						sbufXML.append(" <TD><![CDATA[]]></TD>\n");
						sbufXML.append(" <TD><![CDATA[]]></TD>\n");
						sbufXML.append(" <TD><![CDATA[]]></TD>\n");
						sbufXML.append(" <TD><![CDATA[]]></TD>\n");
						sbufXML.append(" <TD><![CDATA[]]></TD>\n");
						sbufXML.append(" <TD><![CDATA[]]></TD>\n");
						sbufXML.append(" <TD><![CDATA[]]></TD>\n");
						
	 
						sbufXML.append("</TR>\n"); 
	
					} 				
				}
				if(nowColValues.get("spl_flg").equals("S")){
					sbufXML.append("<TR>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("seq")));  sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("chg_tp")));  sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("rated_as"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("rate"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("per"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cur"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("amount"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("pc"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("pay_ofc"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("sc_no"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("rfa_no"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("tariff_no")));sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("shpr_nm"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cnee_nm"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cust_desc"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cmdt"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cmdt_desc"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("rep_cmdt_cd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("rep_cmdt"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("rt_aply_dt")));sbufXML.append("]]></TD>\n");
					
					sbufXML.append(" </TR>\n");
				
					
					subTotRatedAs += Float.parseFloat(nowColValues.get("rated_as"));
					subTotRate 	  += Float.parseFloat(nowColValues.get("rate"));
					subAmt 		  += Float.parseFloat(nowColValues.get("amount"));
				}else{
					sbufXML.append("<TR>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("seq")));  sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("bkg_no")));  sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("rev_dir_cd")));  sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("por_cd")));  sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("pol_cd")));  sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("pod_cd")));  sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("del_cd")));  sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("rcv_term_cd")));  sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("de_term_cd")));  sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("rt_aply_dt")));  sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("chg_tp")));  sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("rated_as"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("rate"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("per"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cur"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("amount"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("pc"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("pay_ofc"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("sc_no"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("rfa_no"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("tariff_no")));sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("shpr_nm"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cnee_nm"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cust_desc"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cmdt"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("cmdt_desc"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("rep_cmdt_cd"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("rep_cmdt"))); sbufXML.append("]]></TD>\n");
					sbufXML.append("<TD><![CDATA["); sbufXML.append(JSPUtil.getNull(nowColValues.get("rt_aply_dt")));sbufXML.append("]]></TD>\n");
					
					sbufXML.append(" </TR>\n");
				
					
					subTotRatedAs += Float.parseFloat(nowColValues.get("rated_as"));
					subTotRate 	  += Float.parseFloat(nowColValues.get("rate"));
					subAmt 		  += Float.parseFloat(nowColValues.get("amount"));
				}
					
				    
				if(!nowBKgNo.equals(nexBkgNo)){ // SubTotal
					 
					sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");
					sbufXML.append(" <TD><![CDATA[ ]]></TD>\n");
					sbufXML.append(" <TD><![CDATA[ ]]></TD>\n");
					sbufXML.append(" <TD DATA-FORMAT=\"dtdata\"  BOLD=\"TRUE\"><![CDATA["); sbufXML.append(String.valueOf(getRound(subTotRatedAs,2))); sbufXML.append("]]></TD>\n");
					sbufXML.append(" <TD DATA-FORMAT=\"dtdata\"  BOLD=\"TRUE\"><![CDATA["); sbufXML.append(String.valueOf(getRound(subTotRate,2))); sbufXML.append("]]></TD>\n");
					sbufXML.append(" <TD><![CDATA[ ]]></TD>\n");
					sbufXML.append(" <TD><![CDATA[ ]]></TD>\n");
					sbufXML.append(" <TD DATA-FORMAT=\"dtdata\"  BOLD=\"TRUE\"><![CDATA["); sbufXML.append(String.valueOf(getRound(subAmt,2))); sbufXML.append("]]></TD>\n");
					
					sbufXML.append(" </TR>\n");

					grandRatedAs += (subTotRatedAs);
					grandRate += (subTotRate);
					grandAmt += (subAmt);
					
					subTotRatedAs = 0;
					subTotRate = 0 ;
					subAmt = 0 ;

				}
				
//					grandRatedAs += (subTotRatedAs);
//					grandRate += (subTotRate);
//					grandAmt += (subAmt);
					
	
				if(i+ 1== realCnt){ // GrandTotal
					sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");
					sbufXML.append(" <TD><![CDATA[ ]]></TD>\n");
					sbufXML.append(" <TD DATA-ALIGN=\"daCenter\" BOLD=\"TRUE\"><![CDATA["); sbufXML.append(" TOTAL : "); sbufXML.append("]]></TD>\n");
					sbufXML.append(" <TD DATA-FORMAT=\"dtdata\"  BOLD=\"TRUE\"><![CDATA["); sbufXML.append(String.valueOf(getRound(grandRatedAs,2)));sbufXML.append("]]></TD>\n");
					sbufXML.append(" <TD  DATA-FORMAT=\"dtdata\" BOLD=\"TRUE\"><![CDATA["); sbufXML.append(String.valueOf(getRound(grandRate,2)));sbufXML.append("]]></TD>\n");
					sbufXML.append(" <TD><![CDATA[ ]]></TD>\n");
					sbufXML.append(" <TD><![CDATA[ ]]></TD>\n");
					sbufXML.append(" <TD DATA-FORMAT=\"dtdata\" POINT-COUNT=\"2\" BOLD=\"TRUE\"><![CDATA["); sbufXML.append(String.valueOf(getRound(grandAmt,2)));sbufXML.append("]]></TD>\n");
					sbufXML.append(" <TD DATA-ALIGN=\"daRight\" BOLD=\"TRUE\"><![CDATA[");sbufXML.append(realCnt);  sbufXML.append( "  Rows ");sbufXML.append("]]></TD>\n");
					
					sbufXML.append(" </TR>\n");
					
					subTotRatedAs = 0;
					subTotRate = 0 ;
					subAmt = 0 ;
					grandRatedAs = 0;
					grandRate = 0;
					subAmt = 0;
				}
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
	protected String makeDataTag(DBRowSet rs, String prefix) {
		
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
	
	protected String makePivotDataTag(DBRowSet rs){
		StringBuilder sb = new StringBuilder();
		
		int colCnt = 0;
		int rowCnt = rs.getRowCount();
		
		String[][] arrRowSet = null;
		
		try{
			colCnt = rs.getMetaData().getColumnCount();
			arrRowSet = new String[rowCnt][colCnt];
			
			int rowIdx = 0;
			while (rs.next()){
				for (int j = 1; j <= colCnt; j++){
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
