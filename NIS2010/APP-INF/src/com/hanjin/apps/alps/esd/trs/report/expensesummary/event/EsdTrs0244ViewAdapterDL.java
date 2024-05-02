
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTrsTempViewAdapterDL.java
*@FileTitle : EsdTrsTempViewAdapterDL
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.16
*@LastModifier : 금병주
*@LastVersion : 1.0
* 2012.02.16 금병주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.expensesummary.event;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;

/**
 * ESD_TRS_0104 에 대한 ViewAdapter<br>
 * - ESD_TRS_0104HTMLAction에서 작성<br>
 *
 * @author 금병주
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdTrs0244ViewAdapterDL extends ViewAdapter {
	
    public EsdTrs0244ViewAdapterDL(){
    	super();
    }

	/**
	 * View Adapter 생성시 자동으로 호출된다.<br>
	 *  <br>
	 * 
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * @return String
	 * @exception EventException
	 */	
    
    public String makeXML(HttpServletRequest request, HttpServletResponse response) {
    	GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse"); 
 		
 		StringBuilder strBuilder = new StringBuilder();
    	DBRowSet rowSet = null;							   	//DB ResultSet
    	
    	String savedName = "ESD_TRS_0244DL.csv";  
 		
    	rowSet = (DBRowSet)eventResponse.getRs();
//    	String[] titleField = (String[])eventResponse.getCustomData("columns");
    	
		try{			
    		
 			response.setContentType("application/vnd.ms.excel");
 			String strClient = request.getHeader("user-agent");
 
 			if (strClient.indexOf("MSIE 5.5") != -1) {
 				response.setHeader("Content-Type",
 						"doesn/matter; charset=euc-kr");
 				response.setHeader("Content-Disposition", "filename="
 						+ savedName + "; charset=euc-kr");
 			} else {
 				response.setHeader("Content-Type",
 						"application/octet-stream; charset=euc-kr");
 				response.setHeader("Content-Disposition",
 						"attachment;filename=" + savedName + ";");
 			} 			     		
     		
    		PrintWriter pout = response.getWriter();
    		int seq=1;
    		
    		strBuilder.append("Seq,W/O Office,Invoice Office,Month,Cost Mode,Trans Mode,BND,S/O TP,Term,From,Via,To,Door,ETS,Distance,Distance,INV Curr,");
    		strBuilder.append("W/O Amount(Local),W/O Amount(Local),W/O Amount(Local),W/O Amount(Local),W/O Amount(Local),W/O Amount(Local),W/O Amount(Local),W/O Amount(Local),W/O Amount(Local),W/O Amount(Local),W/O Amount(Local),W/O Amount(Local),W/O Amount(Local),W/O Amount(Local),W/O Amount(Local),W/O Amount(Local),W/O Amount(Local),W/O Amount(Local),W/O Amount(Local),W/O Amount(Local),W/O Amount(Local),W/O Amount(Local),W/O Amount(Local),W/O Amount(Local),W/O Amount(Local),W/O Amount(Local),W/O Amount(Local),W/O Amount(Local),W/O Amount(Local),W/O Amount(Local),");
    		strBuilder.append("W/O Amount(USD),W/O Amount(USD),W/O Amount(USD),W/O Amount(USD),W/O Amount(USD),W/O Amount(USD),W/O Amount(USD),W/O Amount(USD),W/O Amount(USD),W/O Amount(USD),W/O Amount(USD),W/O Amount(USD),W/O Amount(USD),W/O Amount(USD),W/O Amount(USD),W/O Amount(USD),W/O Amount(USD),W/O Amount(USD),W/O Amount(USD),W/O Amount(USD),W/O Amount(USD),W/O Amount(USD),W/O Amount(USD),W/O Amount(USD),W/O Amount(USD),W/O Amount(USD),W/O Amount(USD),W/O Amount(USD),W/O Amount(USD),W/O Amount(USD),");
    		strBuilder.append("HJL Handling Fee,HJL Handling Fee,HJL Handling Fee,HJL Handling Fee,HJL Handling Fee,HJL Handling Fee,");
    		strBuilder.append("Invoice Amount(Local),Invoice Amount(Local),Invoice Amount(Local),Invoice Amount(Local),Invoice Amount(Local),Invoice Amount(Local),Invoice Amount(Local),");
    		strBuilder.append("Invoice Amount(USD),Invoice Amount(USD),Invoice Amount(USD),Invoice Amount(USD),Invoice Amount(USD),Invoice Amount(USD),Invoice Amount(USD),");
    		strBuilder.append("Volumn,Volumn,Volumn,Volumn,");
    		strBuilder.append("Volumn By Container Size/Type,Volumn By Container Size/Type,Volumn By Container Size/Type,Volumn By Container Size/Type,Volumn By Container Size/Type,Volumn By Container Size/Type,Volumn By Container Size/Type,Volumn By Container Size/Type,Volumn By Container Size/Type,Volumn By Container Size/Type,Volumn By Container Size/Type,Volumn By Container Size/Type,Volumn By Container Size/Type,Volumn By Container Size/Type,Volumn By Container Size/Type,Volumn By Container Size/Type,Volumn By Container Size/Type,Volumn By Container Size/Type,Volumn By Container Size/Type,Volumn By Container Size/Type,Volumn By Container Size/Type,Volumn By Container Size/Type,Volumn By Container Size/Type,Volumn By Container Size/Type,Volumn By Container Size/Type");
    		strBuilder.append("\n");
    		strBuilder.append("Seq,W/O Office,Invoice Office,Month,Cost Mode,Trans Mode,BND,S/O TP,Term,From,Via,To,Door,ETS,Km,R.Link,INV Curr,");
    		strBuilder.append("20' Basic,20' FSC,20' Nego,20' TollFee,20' Additional,20' VAT,20' HAZ(Us Rail),20' OVR(Us Rail),20' Rail Other Surcharge (Us Rail),20' Sum,40' Basic,40' FSC,40' Nego,40' TollFee,40' Additional,40' VAT,40' HAZ(Us Rail),40' OVR(Us Rail),40' Rail Other Surcharge (Us Rail),40' Sum,Total(Basic),Total(FSC),Total(Nego),Total(TollFee),Total(Additional),Total(VAT),Total(HAZ)(Us Rail),Total(OVR)(Us Rail),Total(Rail other Surcharge)(Us Rail),Total(Sum),");
    		strBuilder.append("20' Basic,20' FSC,20' Nego,20' TollFee,20' Additional,20' VAT,20' HAZ(Us Rail),20' OVR(Us Rail),20' Rail Other Surcharge (Us Rail),20' Sum,40' Basic,40' FSC,40' Nego,40' TollFee,40' Additional,40' VAT,40' HAZ(Us Rail),40' OVR(Us Rail),40' Rail Other Surcharge (Us Rail),40' Sum,Total(Basic),Total(FSC),Total(Nego),Total(TollFee),Total(Additional),Total(VAT),Total(HAZ)(Us Rail),Total(OVR)(Us Rail),Total(Rail other Surcharge)(Us Rail),Total(Sum),");
    		strBuilder.append("20' (Local),40' (Local),Total (Local),20' (USD),40' (USD),Total(USD),");
    		strBuilder.append("20' Basic,20' Surcharge,40' Basic,40' Surcharge,Total(Basic),Total(Surcharge),Total(Sum),");
    		strBuilder.append("20' Basic,20' Surcharge,40' Basic,40' Surcharge,Total(Basic),Total(Surcharge),Total(Sum),");
    		strBuilder.append("20',40',Teu,Box,D2,D4,D5,D7,R2,R4,R5,R7,R8,F2,F4,F5,A2,A4,A5,P2,P4,O2,O4,S2,S4,T2,T4,DX,DW");
    		strBuilder.append("\n");
    		
    		while(rowSet.next()){
    			
				strBuilder.append(seq);
				strBuilder.append(",");	
				seq++;
				strBuilder.append(JSPUtil.getNull(rowSet.getString("WO_OFC_CD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("INV_OFC_CD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("CRE_MONTH")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("TRSP_COST_DTL_MOD_CD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("TRSP_CRR_MOD_CD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("TRSP_BND_CD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("TRSP_SO_TP_NM")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("BKG_TERM_NM")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("FM_NOD_CD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("VIA_NOD_CD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("TO_NOD_CD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("DOR_NOD_CD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("ETS_YN")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("TTL_DIST")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("LNK_DIST_DIV_CD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("INV_CURR_CD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("BZC_D2_AMT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("FUEL_SCG_D2_AMT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("NEGO_D2_AMT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("TOLL_FEE_D2_AMT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("TRUK_ETC_ADD_D2_AMT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("SCG_VAT_D2_AMT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("HZD_MTRL_SCG_D2_AMT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("OVR_WGT_SCG_D2_AMT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("RAIL_ETC_ADD_D2_AMT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("D2_AMT_SUM")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("BZC_D4_AMT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("FUEL_SCG_D4_AMT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("NEGO_D4_AMT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("TOLL_FEE_D4_AMT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("TRUK_ETC_ADD_D4_AMT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("SCG_VAT_D4_AMT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("HZD_MTRL_SCG_D4_AMT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("OVR_WGT_SCG_D4_AMT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("RAIL_ETC_ADD_D4_AMT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("D4_AMT_SUM")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("BZC_AMT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("FUEL_SCG_AMT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("NEGO_AMT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("TOLL_FEE_AMT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("TRUK_ETC_ADD_AMT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("SCG_VAT_AMT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("HZD_MTRL_SCG_AMT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("OVR_WGT_SCG_AMT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("RAIL_ETC_ADD_AMT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("TOT_AMT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("BZC_D2_AMT_USD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("FUEL_SCG_D2_AMT_USD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("NEGO_D2_AMT_USD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("TOLL_FEE_D2_AMT_USD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("TRUK_ETC_ADD_D2_AMT_USD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("SCG_VAT_D2_AMT_USD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("HZD_MTRL_SCG_D2_AMT_USD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("OVR_WGT_SCG_D2_AMT_USD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("RAIL_ETC_ADD_D2_AMT_USD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("D2_AMT_SUM_USD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("BZC_D4_AMT_USD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("FUEL_SCG_D4_AMT_USD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("NEGO_D4_AMT_USD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("TOLL_FEE_D4_AMT_USD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("TRUK_ETC_ADD_D4_AMT_USD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("SCG_VAT_D4_AMT_USD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("HZD_MTRL_SCG_D4_AMT_USD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("OVR_WGT_SCG_D4_AMT_USD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("RAIL_ETC_ADD_D4_AMT_USD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("D4_AMT_SUM_USD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("BZC_AMT_USD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("FUEL_SCG_AMT_USD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("NEGO_AMT_USD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("TOLL_FEE_AMT_USD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("TRUK_ETC_ADD_AMT_USD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("SCG_VAT_AMT_USD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("HZD_MTRL_SCG_AMT_USD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("OVR_WGT_SCG_AMT_USD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("RAIL_ETC_ADD_AMT_USD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("TOT_AMT_USD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("HJL_HNDL_D2_AMT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("HJL_HNDL_D4_AMT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("HJL_HNDL_AMT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("HJL_HNDL_D2_AMT_USD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("HJL_HNDL_D4_AMT_USD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("HJL_HNDL_AMT_USD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("INV_BZC_D2_AMT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("INV_ETC_ADD_D2_AMT")).trim().replaceAll(",", ""));
				strBuilder.append(",");	
				strBuilder.append(JSPUtil.getNull(rowSet.getString("INV_BZC_D4_AMT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("INV_ETC_ADD_D4_AMT")).trim().replaceAll(",", ""));
				strBuilder.append(",");	
				strBuilder.append(JSPUtil.getNull(rowSet.getString("INV_BZC_AMT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("INV_ETC_ADD_AMT")).trim().replaceAll(",", ""));
				strBuilder.append(",");	
				strBuilder.append(JSPUtil.getNull(rowSet.getString("INV_TOT_AMT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("INV_BZC_D2_AMT_USD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("INV_ETC_ADD_D2_AMT_USD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("INV_BZC_D4_AMT_USD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("INV_ETC_ADD_D4_AMT_USD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("INV_BZC_AMT_USD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("INV_ETC_ADD_AMT_USD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("INV_TOT_AMT_USD")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("CNTN20")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("CNTN40")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("CNTN_TEU")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("CNTN_BOX")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("D2_CNT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("D4_CNT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("D5_CNT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("D7_CNT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("R2_CNT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("R4_CNT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("R5_CNT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("R7_CNT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("R8_CNT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("F2_CNT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("F4_CNT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("F5_CNT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("A2_CNT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("A4_CNT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("A5_CNT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("P2_CNT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("P4_CNT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("O2_CNT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("O4_CNT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("S2_CNT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("S4_CNT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("T2_CNT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("T4_CNT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("DX_CNT")).trim().replaceAll(",", ""));
				strBuilder.append(",");
				strBuilder.append(JSPUtil.getNull(rowSet.getString("DW_CNT")).trim().replaceAll(",", ""));
				strBuilder.append("\n");
			}
    		
			pout.print(strBuilder.toString());
			pout.flush();
			pout.close();
    				    
        }    	
    	catch(Exception ex){
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage());
        }    	
    	return "";
    }
    
    /*
 	 * (non-Javadoc)
 	 * 
 	 * @see
 	 * com.hanjin.framework.core.controller.ViewAdapter#makeDataTag(java.util
 	 * .List, java.lang.String)
 	 */
 	protected String makeDataTag(List<AbstractValueObject> arg0, String arg1) {
 		return null;
 	}
 
 	/*
 	 * (non-Javadoc)
 	 * 
 	 * @see
 	 * com.hanjin.framework.core.controller.ViewAdapter#makeDataTag(com.hanjin
 	 * .framework.component.rowset.DBRowSet, java.lang.String)
 	 */
 	protected String makeDataTag(DBRowSet arg0, String arg1) {
 		return null;
 	}
}
