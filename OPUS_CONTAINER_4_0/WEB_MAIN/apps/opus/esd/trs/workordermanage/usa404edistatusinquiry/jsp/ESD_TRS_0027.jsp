<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0027.jsp
*@FileTitle  : Basic for USA/CA Rail
*@author     : CLT
*@version    : 1.0
*@since      : 2015/08/21
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Vector"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.event.EsdTrs0027Event"%>
<%
	EsdTrs0027Event  			event 			= null;		//PDTO(Data Transfer Object including Parameters)
	Exception 					serverException	= null;		//Error occurred on the server
	DBRowSet 					rowSet	 		= null;		//DB ResultSet
	String 						strErrMsg 		= "";		//Error message
	int 						rowCount	 	= 0;		//List the number of DB ResultSet

	String 						userId			= "";
	String 						ofcId 			= "";

	String targetRow 			= null;
	String trsp_so_ofc_cty_cd  	= null;
	String trsp_so_seq         	= null;
	String ctrl_ofc_cd    	    = null;
	String basis_dt       	    = null;
	String eq_knd_cd		    = null;
	String eq_tp_sz_cd    	    = null;
	String cmb_tp_cd      	    = null;
	String cgo_tp_cd    	    = null;
	String bound_cd       	    = null;
	String crr_mod_cd     	    = null;
	String cost_mod_cd    	    = null;
	String cust_cnt_cd		    = null;
	String cust_seq       	    = null;
	String cmdt_cd        	    = null;

	String rail_cmb_thru_tp_cd  = null;
	String rail_cmb_thru_tp_nm  = null;
	String fm_nod_cd    	    = null;
	String fm_nod_yard    	    = null;
	String to_nod_cd      	    = null;
	String to_nod_yard    	    = null;

	String bundle_cnt 		    = null;
	String wgt_uom    		    = null;
	String wgt_qty        	    = null;
	String dist_km			    = null;
	String dist_mile			= null;
	String single_multi_sep		= null;
	String wo_issued            = null;
	String spcl_cgo_cntr_tp_cd  = null;
	
	String agmt_ofc_cty_cd      = null;
	String agmt_seq             = null;
	String vndr_seq             = null;
	String curr_cd              = null;
	String bzc_amt              = null;

	try {

	   SignOnUserAccount account	= (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   userId						= account.getUsr_id();
	   ofcId						= account.getOfc_cd();
	   //userAuth=account.getAuth();

       targetRow           = JSPUtil.getNull(request.getParameter("targetRow")         );

       trsp_so_ofc_cty_cd  = JSPUtil.getNull(request.getParameter("trsp_so_ofc_cty_cd")); //OK
       trsp_so_seq         = JSPUtil.getNull(request.getParameter("trsp_so_seq")       ); //OK
       ctrl_ofc_cd         = JSPUtil.getNull(request.getParameter("ctrl_ofc_cd")       );
       
       basis_dt            = JSPUtil.getNull(request.getParameter("basis_dt")          ); //OK so_cre_dt
       eq_knd_cd           = JSPUtil.getNull(request.getParameter("eq_knd_cd")         );
       eq_tp_sz_cd         = JSPUtil.getNull(request.getParameter("eq_tp_sz_cd")       ); //OK
       cmb_tp_cd           = JSPUtil.getNull(request.getParameter("cmb_tp_cd")         );
       cgo_tp_cd           = JSPUtil.getNull(request.getParameter("cgo_tp_cd")         ); //OK
       bound_cd            = JSPUtil.getNull(request.getParameter("bound_cd")          ); //OK
       crr_mod_cd          = JSPUtil.getNull(request.getParameter("crr_mod_cd")        );
       cost_mod_cd         = JSPUtil.getNull(request.getParameter("cost_mod_cd")       );
       cust_cnt_cd         = JSPUtil.getNull(request.getParameter("cust_cnt_cd")       );
       cust_seq            = JSPUtil.getNull(request.getParameter("cust_seq")          );
       cmdt_cd             = JSPUtil.getNull(request.getParameter("cmdt_cd")           );
       
       rail_cmb_thru_tp_cd = JSPUtil.getNull(request.getParameter("rail_cmb_thru_tp_cd"));
       rail_cmb_thru_tp_nm = JSPUtil.getNull(request.getParameter("rail_cmb_thru_tp_nm"));
       
       fm_nod_cd           = JSPUtil.getNull(request.getParameter("fm_nod_cd")         ); //OK
       fm_nod_yard         = JSPUtil.getNull(request.getParameter("fm_nod_yard")       ); //OK
       to_nod_cd           = JSPUtil.getNull(request.getParameter("to_nod_cd")         ); //OK
       to_nod_yard         = JSPUtil.getNull(request.getParameter("to_nod_yard")       ); //OK
       
       bundle_cnt          = JSPUtil.getNull(request.getParameter("bundle_cnt")        );
       wgt_uom             = JSPUtil.getNull(request.getParameter("wgt_uom")           );
       wgt_qty             = JSPUtil.getNull(request.getParameter("wgt_qty")           ); //OK
       dist_km             = JSPUtil.getNull(request.getParameter("dist_km")           );
       dist_mile           = JSPUtil.getNull(request.getParameter("dist_mile")         );
       single_multi_sep    = JSPUtil.getNull(request.getParameter("single_multi_sep"));
       wo_issued           = JSPUtil.getNull(request.getParameter("wo_issued"));
       spcl_cgo_cntr_tp_cd = JSPUtil.getNull(request.getParameter("spcl_cgo_cntr_tp_cd"));

       agmt_ofc_cty_cd     = JSPUtil.getNull(request.getParameter("agmt_ofc_cty_cd")); //OK
       agmt_seq            = JSPUtil.getNull(request.getParameter("agmt_seq")); //OK
       vndr_seq            = JSPUtil.getNull(request.getParameter("vndr_seq")); //OK
       curr_cd             = JSPUtil.getNull(request.getParameter("curr_cd")); //OK
       bzc_amt             = JSPUtil.getNull(request.getParameter("bzc_amt")); //OK
       

		event 				= (EsdTrs0027Event)request.getAttribute("Event");
		serverException 	= (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="usr_id" value="<%=userId%>" id="usr_id" />
<input type="hidden" name="ofc_cd" value="<%=ofcId%>" id="ofc_cd" />
<input type="hidden" name="targetRow" value="<%=targetRow%>" id="targetRow" />

<input type="hidden" name="trsp_so_ofc_cty_cd" value="<%=trsp_so_ofc_cty_cd%>" id="trsp_so_ofc_cty_cd" />
<input type="hidden" name="trsp_so_seq" value="<%=trsp_so_seq%>" id="trsp_so_seq" />
<input type="hidden" name="ctrl_ofc_cd" value="<%=ctrl_ofc_cd%>" id="ctrl_ofc_cd" />
<input type="hidden" name="basis_dt" value="<%=basis_dt%>" id="basis_dt" />
<input type="hidden" name="eq_knd_cd" value="<%=eq_knd_cd%>" id="eq_knd_cd" />
<input type="hidden" name="eq_tp_sz_cd" value="<%=eq_tp_sz_cd%>" id="eq_tp_sz_cd" />
<input type="hidden" name="cmb_tp_cd" value="<%=cmb_tp_cd%>" id="cmb_tp_cd" />
<input type="hidden" name="cgo_tp_cd" value="<%=cgo_tp_cd%>" id="cgo_tp_cd" />
<input type="hidden" name="bound_cd" value="<%=bound_cd%>" id="bound_cd" />
<input type="hidden" name="crr_mod_cd" value="<%=crr_mod_cd %>" id="crr_mod_cd" />
<input type="hidden" name="cost_mod_cd" value="<%=cost_mod_cd%>" id="cost_mod_cd" />
<input type="hidden" name="cust_cnt_cd" value="<%=cust_cnt_cd%>" id="cust_cnt_cd" />
<input type="hidden" name="cust_seq" value="<%=cust_seq%>" id="cust_seq" />
<input type="hidden" name="cmdt_cd" value="<%=cmdt_cd%>" id="cmdt_cd" />
<input type="hidden" name="bundle_cnt" value="<%=bundle_cnt%>" id="bundle_cnt" />
<input type="hidden" name="wgt_uom" value="<%=wgt_uom%>" id="wgt_uom" />
<input type="hidden" name="wgt_qty" value="<%=wgt_qty%>" id="wgt_qty" />
<input type="hidden" name="dist_km" value="<%=dist_km%>" id="dist_km" />
<input type="hidden" name="dist_mile" value="<%=dist_mile%>" id="dist_mile" />
<input type="hidden" name="single_multi_sep" value="<%=single_multi_sep%>" id="single_multi_sep"  />
<input type="hidden" name="wo_issued" value="<%=wo_issued%>" id="wo_issued"  />

<input type="hidden" name="agmt_ofc_cty_cd" value="<%=agmt_ofc_cty_cd%>" id="agmt_ofc_cty_cd"  />
<input type="hidden" name="agmt_seq" value="<%=agmt_seq%>" id="agmt_seq"  />
<input type="hidden" name="vndr_seq" value="<%=vndr_seq%>" id="vndr_seq"  />
<input type="hidden" name="curr_cd" value="<%=curr_cd%>" id="curr_cd"  />
<input type="hidden" name="bzc_amt" value="<%=bzc_amt%>" id="bzc_amt"  />

<div class="layer_popup_title">
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>Basic for USA/CA Rail</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_normal" type="button" name="btn_close" id="btn_close">Close</button><!--
 --></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
</div>
 <div class="layer_popup_contents">
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="150" />
				<col width="180" />
				<col width="150" />
				<col width="180" />
				<col width="150" />
				<col width="*" />
		   </colgroup> 
		   <tbody>
		   		<tr>
					<th>Rail Billing Pattern</th>
					<td><input type="text" style="width:50px;background-color: white;" name="rail_cmb_thru_tp_cd" id="rail_cmb_thru_tp_cd" value="<%=rail_cmb_thru_tp_cd%>" align="center" readonly><!-- 
					 --><input type="text" style="width:200px;background-color: white;" name="rail_cmb_thru_tp_nm" id="rail_cmb_thru_tp_nm" value="<%=rail_cmb_thru_tp_nm%>" align="center" readonly></td>
		   			<th>Type/Size</th>
					<td><input type="text" style="width:60px;background-color: white;" name="eq_tpsz_cd" id="eq_tpsz_cd" value="<%=eq_tp_sz_cd%>" align="center" readonly></td>
					<th>Cargo Type</th>
					<td><input type="text" style="width:50px;background-color: white;" name="fm_cgo_tp_cd" value="<%=cgo_tp_cd%>" align="right" id="fm_cgo_tp_cd" readonly/> </td>
		   		</tr>
		   		<tr>
					<th>Rail ORG.</th>
					<td><input type="text" style="width:50px;background-color: white;" name="fm_nod_cd" id="fm_nod_cd" value="<%=fm_nod_cd%>" align="center" readonly><!-- 
					 --><input type="text" style="width:25px;background-color: white;" name="fm_nod_yard" id="fm_nod_yard" value="<%=fm_nod_yard%>" align="center" readonly></td>
		   			<th>Rail DEST.</th>
					<td><input type="text" style="width:50px;background-color: white;" name="to_nod_cd" id="to_nod_cd" value="<%=to_nod_cd%>" align="center" readonly><!-- 
					 --><input type="text" style="width:25px;background-color: white;" name="to_nod_yard" id="to_nod_yard" value="<%=to_nod_yard%>" align="center" readonly></td>
		   		</tr>
		   </tbody>
		</table>		
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

	<div class="wrap_result">
	    <div class="opus_design_grid clear" id="mainTable" >
	    	<script type="text/javascript">ComSheetObject('sheet0');</script>
	    </div>
	</div>
</div>

</form>
