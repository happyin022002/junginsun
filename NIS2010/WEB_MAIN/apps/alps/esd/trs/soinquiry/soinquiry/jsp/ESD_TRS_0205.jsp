<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0019GS.jsp
*@FileTitle : SO Inquiry
*Open Issues : 
*Change history :
*@LastModifyDate : 2006-11-10
*@LastModifier : juhyun 
*@LastVersion : 1.0
* 2006-11-10 juhyun 
* 1.0 최초 생성
* 2011.05.06  손은주            [CHM-201109770-01][TRS] MEXBB 에서 처리되는 Rail S/O 에 대한 exception logic 적용가능성 검토요청 (US Rail surcharge 기능 연계)
* 2011.11.30  유선오    1.3 [CHM-201114748] [TRS] S/O inquiry 상에 보이는 VVD lane 정보 칼럼 변경/추가 요청
=========================================================*/
--%>
<%@ page contentType="text/xml; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.soinquiry.soinquiry.event.EsdTrs0019Event"%>
<%@ page import="com.hanjin.framework.core.layer.event.EventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.FormCommand"%>


	


<% 
response.setContentType("application/x-msdownload");
response.setHeader("Content-Disposition", "attachment;filename=aaa.xls;");
%>


<style>
<!--table
	{mso-displayed-decimal-separator:"\.";
	mso-displayed-thousand-separator:"\,";}
@page
	{margin:1.0in .75in 1.0in .75in;
	mso-header-margin:.5in;
	mso-footer-margin:.5in;}
tr
	{mso-height-source:auto;
	mso-ruby-visibility:none;}
col
	{mso-width-source:auto;
	mso-ruby-visibility:none;}
br
	{mso-data-placement:same-cell;}
.style0
	{mso-number-format:General;
	text-align:general;
	vertical-align:middle;
	white-space:nowrap;
	mso-rotate:0;
	mso-background-source:auto;
	mso-pattern:auto;
	color:windowtext;
	font-size:11.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:돋움, monospace;
	mso-font-charset:129;
	border:none;
	mso-protection:locked visible;
	mso-style-name:표준;
	mso-style-id:0;}
td
	{mso-style-parent:style0;
	padding-top:1px;
	padding-right:1px;
	padding-left:1px;
	mso-ignore:padding;
	color:windowtext;
	font-size:11.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:돋움, monospace;
	mso-font-charset:129;
	mso-number-format:General;
	text-align:general;
	vertical-align:middle;
	border:none;
	mso-background-source:auto;
	mso-pattern:auto;
	mso-protection:locked visible;
	white-space:nowrap;
	mso-rotate:0;}
.xl24
	{mso-style-parent:style0;
	mso-number-format:"\@";
	text-align:center;
	border:.0pt solid windowtext;
	background:white;
	mso-pattern:auto none;}
.xl25
	{mso-style-parent:style0;
	mso-number-format:"\@";
	text-align:center;
	border:.5pt solid windowtext;
	background:silver;
	mso-pattern:auto none;
	white-space:normal;}
.xl26
	{mso-style-parent:style0;
	mso-number-format:"\@";
}
.xl27
	{mso-style-parent:style0;
	mso-number-format:"\#\,\#\#0\.00_ ";
	border:.5pt solid windowtext;}
.xl28
	{mso-style-parent:style0;
	mso-number-format:General;
}
ruby
	{ruby-align:left;}
rt
	{color:windowtext;
	font-size:8.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:돋움, monospace;
	mso-font-charset:129;
	mso-char-type:none;
	display:none;}
-->
</style>








<%

	EsdTrs0019Event event = null;
	EventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException = null;					 //서버에서 발생한 에러
	DBRowSet rowSet = null;							   //DB ResultSet
	String strErrMsg = "";								//에러메세지
	int rowCount	 = 0;								 //DB ResultSet 리스트의 건수




	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	

		}else{
			event = (EsdTrs0019Event)request.getAttribute("Event");
			eventResponse = (EventResponse)request.getAttribute("EventResponse");

			if (eventResponse != null) {
				rowSet = eventResponse.getRs();
				
				if(rowSet != null){
					 rowCount = rowSet.getRowCount();
				} // end if
			} // end if
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}

	StringBuffer aa = new StringBuffer();
	int i=0; 




	


   aa.append("<TABLE>");

 aa.append("<tr>");
 aa.append("<td rowspan=2 >Seq.</td><td rowspan=2>EQ No.</td><td rowspan=2>TP/SZ</td><td rowspan=2>Org TP/SZ</td><td rowspan=2>Cost Mode</td> <td rowspan=2>Trans Mode</td><td rowspan=2>S/O TP</td><td rowspan=2>Unplanned</td><td rowspan=2>CB</td><td rowspan=2>Frustrated</td> <td rowspan=2>S/O No.</td><td rowspan=2>S/O CRE DT</td><td rowspan=2>S/O DEL</td><td rowspan=2>S/O DEL DT</td><td rowspan=2>S/O UPD ID</td> <td rowspan=2>W/O No.</td><td rowspan=2>W/O Iss STS</td><td rowspan=2>W/O Iss DT</td><td rowspan=2>W/O ISS TP</td><td rowspan=2>W/O ISS OFC</td> <td rowspan=2>W/O ISS ID</td><td rowspan=2>From</td><td rowspan=2>Via</td><td rowspan=2>To</td><td rowspan=2>Door</td> <td colspan=7>Door Information</td><td  colspan=3>W/O S/P</td> <td colspan=2>Parent S/P</td>  <td rowspan=2>W/O RCV DT</td><td rowspan=2>Appt. Time</td><td rowspan=2>Deliv. Time</td><td colspan=2>Feeder Term</td> <td rowspan=2>3rd Party</td><td rowspan=2>Cost OFC</td> <td colspan=8>Work Order Amount</td> <td rowspan=2>Exchange Rate</td><td rowspan=2>Calculation Logic</td> <td colspan=5>Invoice Amount</td> <td colspan=2>Invoice S/P</td><td rowspan=2>Invoice No.</td><td rowspan=2>INV STS</td><td rowspan=2>INV CNFM DT</td><td rowspan=2>CSR No.</td><td rowspan=2>INV I/F DT</td> <td rowspan=2>INV OFC</td><td rowspan=2>INV User</td>  <td colspan=4>Estimated Time</td>  <td rowspan=2>COP No.</td><td rowspan=2>A/G SEQ</td><td rowspan=2>A/G Code</td><td rowspan=2>BKG No.</td><td rowspan=2>BL No.</td><td rowspan=2>BND</td> <td rowspan=2>Term</td>  <td colspan=9>TRO Information</td>  <td rowspan=2>BKG QTY</td><td rowspan=2>POR</td><td rowspan=2>POL</td><td rowspan=2>POD</td><td rowspan=2>DEL</td><td rowspan=2>T.VVD</td> <td rowspan=2>Lane</td><td rowspan=2>In VVD</td><td rowspan=2>Out VVD</td><td rowspan=2>CGO TP</td><td rowspan=2>BKG SPE</td><td rowspan=2>Used</td> <td rowspan=2>L/T</td><td rowspan=2>I.Exit</td><td rowspan=2>L/T EXP</td><td rowspan=2>Seal No</td><td rowspan=2>Weight(KGS)</td> <td rowspan=2>Weight(LBS)</td><td rowspan=2>No of PKG</td><td rowspan=2>PKG CD</td><td rowspan=2>Commodity DESC</td><td rowspan=2>C.LOC</td> <td rowspan=2>USA Last City</td><td rowspan=2>F</td><td rowspan=2>O</td><td rowspan=2>C</td><td rowspan=2>Pickup No.</td><td rowspan=2>PU Yard</td> <td rowspan=2>Avaliable DT</td><td rowspan=2>Last Free DT</td rowspan=2><td rowspan=2>S/C No.</td><td rowspan=2>RFA No.</td><td rowspan=2>Door SVC TP</td> <td rowspan=2>Pickup CNTR</td><td rowspan=2>Shipper</td><td rowspan=2>Consignee</td><td rowspan=2>Notify</td><td rowspan=2>Ref.BKG No</td> <td rowspan=2>Ref.BL No</td><td rowspan=2>Outgate Date</td><td rowspan=2>Ingate Date</td><td rowspan=2>MTY Reference No</td><td rowspan=2>SEN W/O No</td><td rowspan=2>Reason</td><td rowspan=2>Internal Remark</td><td rowspan=2>Nego. Remark</td> <td rowspan=2>Special Instruction</td><td rowspan=2>W/O Instruction</td><td rowspan=2>CHZ Bundle</td><td rowspan=2>Supplement Kind</td><td rowspan=2>ETS</td>");
 
 aa.append("</tr>");
 aa.append("<tr >");
 aa.append("<td>Actual Customer</td>	<td>Factory Name</td>	<td>Zip Code</td>	  <td>Address</td>				<td>TEL</td>				<td>FAX</td>		 <td>PIC</td>			 <td>Type</td>   <td>Code</td>   <td>Name</td>   <td>Code</td>      <td>Name</td>	<td>Receiving</td> <td>Delivery</td>	<td>Currency</td>	 <td>Basic</td>		   <td>Negotiated</td>	     <td>Fuel</td>	<td>Vat</td>	 <td>Additional</td>	 <td>Total</td>		   <td>W/O Amount Total(USD)</td>						<td>Currency</td>	<td>Basic</td>	       <td>Surcharge</td>     <td>Total</td>	  <td>Invoice total Amount(USD)</td><td>Code</td>       <td>Name</td>      <td>From Departure</td><td>To Arrival</td><td>Door Arrival</td><td>TRO Door Date</td> <td>SEQ</td>	    <td>CNFM</td>	    <td>OFFICE	</td>	    <td>USER ID</td>	    <td>TIME </td>	    <td>REV CURRENCY</td>   <td>REV AMOUNT</td>  <td>Manifested</td>   <td>LOAD REF NO</td>");
 aa.append("</tr>");

 

out.print(aa.toString());

if(rowSet != null){
   while(rowSet.next()){
   i++;

	aa = new StringBuffer();

    aa.append("<tr>");


     aa.append("<td>"+i+"</td>");
     aa.append("<td>"+rowSet.getString("eq_no")+"</td>");
     aa.append("<td>"+rowSet.getString("eq_tpsz")+"</td>");
     aa.append("<td>"+rowSet.getString("org_eq_tpsz")+"</td>");
     aa.append("<td>"+rowSet.getString("trsp_cost_dtl_mod_cd")+"</td>");
     aa.append("<td>"+rowSet.getString("trsp_crr_mod_cd")+"</td>");
     aa.append("<td>"+rowSet.getString("trsp_so_tp_cd")+"</td>");
     aa.append("<td>"+rowSet.getString("upln_so_flg")+"</td>");
     aa.append("<td>"+rowSet.getString("bkg_cntr_cmb_seq")+"</td>");
     aa.append("<td>"+rowSet.getString("trsp_frst_flg")+"</td>");
     aa.append("<td>"+rowSet.getString("so_no")+"</td>");
     aa.append("<td class=xl26 style='border-top:none;border-left:none' >"+rowSet.getString("so_cre_dt1")+"</td>");
     aa.append("<td>"+rowSet.getString("so_del_flg")+"</td>");
     aa.append("<td class=xl26 style='border-top:none;border-left:none' >"+rowSet.getString("so_del_dt")+"</td>");
     aa.append("<td class=xl24>"+rowSet.getString("upd_usr_id")+"</td>");
     aa.append("<td>"+rowSet.getString("wo_no")+"</td>");
     aa.append("<td>"+rowSet.getString("wo_iss_sts_cd")+"</td>");
     aa.append("<td class=xl26 style='border-top:none;border-left:none'>"+rowSet.getString("wo_iss_dt")+"</td>");
     aa.append("<td>"+rowSet.getString("wo_iss_tp")+"</td>");
     aa.append("<td>"+rowSet.getString("wo_iss_ofc_cd")+"</td>");
     aa.append("<td class=xl24>"+rowSet.getString("wo_iss_id")+"</td>");
     aa.append("<td>"+rowSet.getString("fm_nod_cd")+"</td>");
     aa.append("<td>"+rowSet.getString("via_nod_cd")+"</td>");
     aa.append("<td>"+rowSet.getString("to_nod_cd")+"</td>");
     aa.append("<td>"+rowSet.getString("door")+"</td>");
     aa.append("<td class=xl24>"+rowSet.getString("door_act_cust")+"</td>");
     aa.append("<td class=xl24>"+rowSet.getString("door_fctry_nm")+"</td>");
     aa.append("<td class=xl24>"+rowSet.getString("door_zip")+"</td>");
     aa.append("<td class=xl24>"+rowSet.getString("dor_de_addr")+"</td>");
     aa.append("<td class=xl24>"+rowSet.getString("door_tel")+"</td>");
     aa.append("<td class=xl24>"+rowSet.getString("door_fax")+"</td>");
     aa.append("<td class=xl24>"+rowSet.getString("door_pic")+"</td>");
     aa.append("<td>"+rowSet.getString("vndr_tp_cd")+"</td>");
     aa.append("<td>"+rowSet.getString("vndr_cd")+"</td>");
     aa.append("<td class=xl24>"+rowSet.getString("vndr_abbr_nm")+"</td>");
     aa.append("<td>"+rowSet.getString("pvndr_cd")+"</td>");
     aa.append("<td class=xl24>"+rowSet.getString("pvndr_nm").replaceFirst("-"," ")+"</td>");
     aa.append("<td class=xl26 style='border-top:none;border-left:none' >"+rowSet.getString("wo_rcv_dt")+"</td>");
     aa.append("<td class=xl26 style='border-top:none;border-left:none' >"+rowSet.getString("appt_time")+"</td>");
     aa.append("<td class=xl26 style='border-top:none;border-left:none' >"+rowSet.getString("deliv_time")+"</td>");
     aa.append("<td>"+rowSet.getString("wtr_rcv_term_cd")+"</td>");
     aa.append("<td>"+rowSet.getString("wtr_de_term_cd")+"</td>");
     
     aa.append("<td>"+rowSet.getString("n3pty_bil_flg")+"</td>");
     aa.append("<td>"+rowSet.getString("cost_ofc_cd")+"</td>");
     aa.append("<td>"+rowSet.getString("wo_curr_cd")+"</td>");
     aa.append("<td>"+rowSet.getString("wo_bzc_amt")+"</td>");
     aa.append("<td>"+rowSet.getString("wo_nego_amt")+"</td>");
     aa.append("<td>"+rowSet.getString("wo_fuel_scg_amt")+"</td>");
     aa.append("<td>"+rowSet.getString("wo_vat_scg_amt")+"</td>");
     aa.append("<td>"+rowSet.getString("wo_etc_add_amt")+"</td>");
     aa.append("<td>"+rowSet.getString("wo_tot_amt")+"</td>");
     aa.append("<td>"+rowSet.getString("wo_tot_amt_usd")+"</td>");
     aa.append("<td>"+rowSet.getString("inv_xch_rt")+"</td>");
     aa.append("<td>"+rowSet.getString("inv_calc_lgc_tp_cd")+"</td>");
     aa.append("<td>"+rowSet.getString("inv_curr_cd")+"</td>");
     aa.append("<td>"+rowSet.getString("inv_bzc_amt")+"</td>");
     aa.append("<td>"+rowSet.getString("inv_etc_add_amt")+"</td>");
     aa.append("<td>"+rowSet.getString("inv_tot_amt")+"</td>");
     aa.append("<td>"+rowSet.getString("inv_tot_amt_usd")+"</td>");
     aa.append("<td>"+rowSet.getString("inv_vndr_cd")+"</td>");
     aa.append("<td class=xl24>"+rowSet.getString("inv_vndr_nm")+"</td>");
     aa.append("<td>"+rowSet.getString("inv_no")+"</td>");
     aa.append("<td>"+rowSet.getString("inv_sts_cd")+"</td>");
     aa.append("<td class=xl26 style='border-top:none;border-left:none' >"+rowSet.getString("inv_cfm_dt")+"</td>");
     aa.append("<td class=xl24>"+rowSet.getString("car_no")+"</td>");
     aa.append("<td class=xl26 style='border-top:none;border-left:none' >"+rowSet.getString("inv_if_dt")+"</td>");
     aa.append("<td>"+rowSet.getString("inv_cfm_ofc_cd")+"</td>");
     aa.append("<td>"+rowSet.getString("inv_cre_usr_id")+"</td>");
     aa.append("<td class=xl26 style='border-top:none;border-left:none' >"+rowSet.getString("n1st_nod_pln_dt")+"</td>");
     aa.append("<td class=xl26 style='border-top:none;border-left:none' >"+rowSet.getString("lst_nod_pln_dt")+"</td>");
     aa.append("<td class=xl26 style='border-top:none;border-left:none' >"+rowSet.getString("dor_nod_pln_dt")+"</td>");
     aa.append("<td class=xl26 style='border-top:none;border-left:none' >"+rowSet.getString("dor_arr_dt")+"</td>");
     aa.append("<td>"+rowSet.getString("cop_no")+"</td>");
     aa.append("<td>"+rowSet.getString("ag_seq")+"</td>");
     aa.append("<td>"+rowSet.getString("ag_code")+"</td>");
     aa.append("<td>"+rowSet.getString("bkg_no")+"</td>");
     aa.append("<td>"+rowSet.getString("bl_no")+"</td>");
     aa.append("<td>"+rowSet.getString("trsp_bnd_cd")+"</td>");
     aa.append("<td>"+rowSet.getString("term")+"</td>");
     aa.append("<td>"+rowSet.getString("tro_seq")+"</td>");
     aa.append("<td>"+rowSet.getString("tro_cnfm")+"</td>");
     aa.append("<td class=xl24>"+rowSet.getString("tro_cfm_ofc")+"</td>");
     aa.append("<td class=xl24>"+rowSet.getString("tro_cfm_usr")+"</td>");
     aa.append("<td class=xl26 style='border-top:none;border-left:none' >"+rowSet.getString("tro_cfm_upd")+"</td>");
     aa.append("<td>"+rowSet.getString("tro_rev_cur")+"</td>");
     aa.append("<td class=xl28 >"+rowSet.getString("eur_tro_rev")+"</td>");
     aa.append("<td class=xl24>"+rowSet.getString("manifested")+"</td>");
     aa.append("<td class=xl24>"+rowSet.getString("tro_lod_ref")+"</td>");
     aa.append("<td>"+rowSet.getString("bkg_qty")+"</td>");
     aa.append("<td>"+rowSet.getString("por_cd")+"</td>");
     aa.append("<td>"+rowSet.getString("pol_cd")+"</td>");
     aa.append("<td>"+rowSet.getString("pod_cd")+"</td>");
     aa.append("<td>"+rowSet.getString("del_cd")+"</td>");
     aa.append("<td>"+rowSet.getString("t_vvd")+"</td>");
     aa.append("<td>"+rowSet.getString("slan_cd")+"</td>");
     aa.append("<td>"+rowSet.getString("ib_vvd_cd")+"</td>");
     aa.append("<td>"+rowSet.getString("ib_slan_cd")+"</td>");
     aa.append("<td>"+rowSet.getString("ob_vvd_cd")+"</td>");
     aa.append("<td>"+rowSet.getString("ob_slan_cd")+"</td>");
     aa.append("<td>"+rowSet.getString("cgo_tp_cd")+"</td>");
     aa.append("<td class=xl24>"+rowSet.getString("bkg_spe")+"</td>");
     aa.append("<td class=xl24>"+rowSet.getString("used")+"</td>");
     aa.append("<td>"+rowSet.getString("lt")+"</td>");
     aa.append("<td>"+rowSet.getString("i_exit")+"</td>"); 
     aa.append("<td>"+rowSet.getString("lt_exp")+"</td>");
     aa.append("<td class=xl26 style='border-top:none;border-left:none'>"+rowSet.getString("seal_no")+"</td>");
     aa.append("<td>"+rowSet.getString("weight_kgs")+"</td>");
     aa.append("<td>"+rowSet.getString("weight_lbs")+"</td>");
     aa.append("<td>"+rowSet.getString("no_pkg")+"</td>");
     aa.append("<td>"+rowSet.getString("pkg_cd")+"</td>");
     aa.append("<td class=xl24>"+rowSet.getString("cmdt_nm")+"</td>");
     aa.append("<td class=xl24>"+rowSet.getString("c_loc")+"</td>");
     aa.append("<td class=xl24>"+rowSet.getString("usa_last_city")+"</td>");
     aa.append("<td>"+rowSet.getString("f")+"</td>");
     aa.append("<td>"+rowSet.getString("o")+"</td>");
     aa.append("<td>"+rowSet.getString("c")+"</td>");
     aa.append("<td>"+rowSet.getString("pickup_no")+"</td>");
     aa.append("<td>"+rowSet.getString("pu_yard_cd")+"</td>");
     aa.append("<td>"+rowSet.getString("available_dt")+"</td>");
     aa.append("<td>"+rowSet.getString("last_free_dt")+"</td>");
     aa.append("<td>"+rowSet.getString("sc_no")+"</td>");
     aa.append("<td>"+rowSet.getString("rfa_no")+"</td>");
     aa.append("<td>"+rowSet.getString("door_svc_tp")+"</td>");
     aa.append("<td></td>");   // PICK UP CNTR
     aa.append("<td class=xl24>"+rowSet.getString("shipper")+"</td>");
     aa.append("<td class=xl24>"+rowSet.getString("consignee")+"</td>");
     aa.append("<td class=xl24>"+rowSet.getString("notify")+"</td>");
     aa.append("<td>"+rowSet.getString("ref_bkg_no")+"</td>");
     aa.append("<td>"+rowSet.getString("ref_bl_no")+"</td>");
     aa.append("<td class=xl26 style='border-top:none;border-left:none' >"+rowSet.getString("org_gate_out_dt")+"</td>");
     aa.append("<td class=xl26 style='border-top:none;border-left:none' >"+rowSet.getString("dest_gate_in_dt")+"</td>");
     aa.append("<td class=xl24>"+rowSet.getString("mty_ref_id")+"</td>");
     aa.append("<td>"+rowSet.getString("sen_wo_no")+"</td>");
     aa.append("<td class=xl24>"+rowSet.getString("trsp_purp_rsn")+"</td>");
     aa.append("<td class=xl24>"+rowSet.getString("inter_rmk")+"</td>");
     aa.append("<td class=xl24>"+rowSet.getString("nego_rmk")+"</td>");
     aa.append("<td class=xl24>"+rowSet.getString("spcl_instr_rmk")+"</td>");
     aa.append("<td class=xl24>"+rowSet.getString("wo_instr_rmk")+"</td>");
     aa.append("<td>"+rowSet.getString("chz_bundle_seq")+"</td>");
     aa.append("<td>"+rowSet.getString("trsp_spl_so_tp_cd")+"</td>");
     aa.append("<td>"+rowSet.getString("hjl_no")+"</td>");

    aa.append("</tr>");

out.print(aa.toString());


   }
}
   
   out.print("</TABLE>");



%> 

