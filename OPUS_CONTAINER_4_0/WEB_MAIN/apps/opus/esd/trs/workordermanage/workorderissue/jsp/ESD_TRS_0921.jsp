<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_921.jsp
*@FileTitle  : More Candidates
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/12
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
<%@ page import="com.clt.apps.opus.esd.trs.workordermanage.workorderissue.event.EsdTrs0921Event"%>
<%
	EsdTrs0921Event  			event 			= null;		//PDTO(Data Transfer Object including Parameters)
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
	String vndr_seq       	    = null;
	String vndr_nm              = null;
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

	String from_nod_cd    	    = null;
	String from_loc    	    	= null;
	String from_yard    	    = null;

	String via_nod_cd     	    = null;
	String via_loc     	    	= null;
	String via_yard     	    = null;

	String door_nod_cd    	    = null;
	String door_loc    	    	= null;
	String door_zone    	    = null;

	String to_nod_cd      	    = null;
	String to_loc      	    	= null;
	String to_yard      	    = null;

	String bundle_cnt 		    = null;
	String wgt_uom    		    = null;
	String wgt_qty        	    = null;
	String dist_km			    = null;
	String dist_mile			= null;
	String single_multi_sep		= null;
	String wo_issued            = null;
	String spcl_cgo_cntr_tp_cd  = null;
	String basic_rt             = null;
	String nego_amt             = null;
	String fuel_scg_rt          = null;
	String etc_add_amt          = null;
	String trsp_agmt_ofc_cty_cd = null;
	String trsp_agmt_seq        = null;
	String rvn_mpt_cntr         = null;
	String conti_cd             = null;
	String scg_ind_cd           = null;

	try {

	   SignOnUserAccount account	= (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   userId						= account.getUsr_id();
	   ofcId						= account.getOfc_cd();
	   //userAuth=account.getAuth();

       targetRow           = JSPUtil.getNull(request.getParameter("targetRow")         );

       trsp_so_ofc_cty_cd   = JSPUtil.getNull(request.getParameter("trsp_so_ofc_cty_cd"));
       trsp_so_seq          = JSPUtil.getNull(request.getParameter("trsp_so_seq")       );
       ctrl_ofc_cd          = JSPUtil.getNull(request.getParameter("ctrl_ofc_cd")       );
       vndr_seq             = JSPUtil.getNull(request.getParameter("vndr_seq")          );
       vndr_nm              = JSPUtil.getNull(request.getParameter("vndr_nm")          );
       basis_dt             = JSPUtil.getNull(request.getParameter("basis_dt")          );
       eq_knd_cd            = JSPUtil.getNull(request.getParameter("eq_knd_cd")         );
       eq_tp_sz_cd          = JSPUtil.getNull(request.getParameter("eq_tp_sz_cd")       );
       cmb_tp_cd            = JSPUtil.getNull(request.getParameter("cmb_tp_cd")         );
       cgo_tp_cd            = JSPUtil.getNull(request.getParameter("cgo_tp_cd")         );
       bound_cd             = JSPUtil.getNull(request.getParameter("bound_cd")          );
       crr_mod_cd           = JSPUtil.getNull(request.getParameter("crr_mod_cd")        );
       cost_mod_cd          = JSPUtil.getNull(request.getParameter("cost_mod_cd")       );
       cust_cnt_cd          = JSPUtil.getNull(request.getParameter("cust_cnt_cd")       );
       cust_seq             = JSPUtil.getNull(request.getParameter("cust_seq")          );
       cmdt_cd              = JSPUtil.getNull(request.getParameter("cmdt_cd")           );
       from_nod_cd          = JSPUtil.getNull(request.getParameter("from_nod_cd")       );
       via_nod_cd           = JSPUtil.getNull(request.getParameter("via_nod_cd")        );
       door_nod_cd          = JSPUtil.getNull(request.getParameter("door_nod_cd")       );
       to_nod_cd            = JSPUtil.getNull(request.getParameter("to_nod_cd")         );
       bundle_cnt           = JSPUtil.getNull(request.getParameter("bundle_cnt")        );
       wgt_uom              = JSPUtil.getNull(request.getParameter("wgt_uom")           );
       wgt_qty              = JSPUtil.getNull(request.getParameter("wgt_qty")           );
       dist_km              = JSPUtil.getNull(request.getParameter("dist_km")           );
       dist_mile            = JSPUtil.getNull(request.getParameter("dist_mile")         );
       single_multi_sep     = JSPUtil.getNull(request.getParameter("single_multi_sep"));
       wo_issued            = JSPUtil.getNull(request.getParameter("wo_issued"));
       spcl_cgo_cntr_tp_cd  = JSPUtil.getNull(request.getParameter("spcl_cgo_cntr_tp_cd"));
       basic_rt             = JSPUtil.getNull(request.getParameter("basic_rt"));
       nego_amt             = JSPUtil.getNull(request.getParameter("nego_amt"));
       fuel_scg_rt          = JSPUtil.getNull(request.getParameter("fuel_scg_rt"));
       etc_add_amt          = JSPUtil.getNull(request.getParameter("etc_add_amt"));
       trsp_agmt_ofc_cty_cd = JSPUtil.getNull(request.getParameter("trsp_agmt_ofc_cty_cd"));
       trsp_agmt_seq        = JSPUtil.getNull(request.getParameter("trsp_agmt_seq"));
       rvn_mpt_cntr         = JSPUtil.getNull(request.getParameter("rvn_mpt_cntr"));
       conti_cd             = JSPUtil.getNull(request.getParameter("conti_cd"));
       scg_ind_cd           = JSPUtil.getNull(request.getParameter("scg_ind_cd"));

	    if(!"".equals(from_nod_cd) && from_nod_cd.length() >= 5) {
	    	from_loc	= from_nod_cd.substring(0,5);
	    	if(from_nod_cd.length() == 7) {
	    		from_yard	= from_nod_cd.substring(5,7);
	    	} else {
	    		from_yard	= "";
	    	}
	    } else {
	    	from_loc	= "";
	    	from_yard	= "";
	    }

	    if(!"".equals(via_nod_cd) && via_nod_cd.length() >= 5) {
	    	via_loc		= via_nod_cd.substring(0,5);
	    	if(via_nod_cd.length() == 7) {
	    		via_yard	= via_nod_cd.substring(5,7);
	    	} else {
	    		via_yard	= "";
	    	}
	    } else {
	    	via_loc		= "";
	    	via_yard	= "";
	    }

	    if(!"".equals(door_nod_cd) && door_nod_cd.length() >= 5) {
	    	door_loc	= door_nod_cd.substring(0,5);
	    	if(door_nod_cd.length() == 7) {
	    		door_zone	= door_nod_cd.substring(5,7);
	    	} else {
	    		door_zone	= "";
	    	}
	    } else {
	    	door_loc	= "";
	    	door_zone	= "";
	    }

	    if(!"".equals(to_nod_cd) && to_nod_cd.length() >= 5) {
	    	to_loc		= to_nod_cd.substring(0,5);
	    	if(to_nod_cd.length() == 7) {
	    		to_yard	= to_nod_cd.substring(5,7);
	    	} else {
	    		to_yard	= "";
	    	}
	    } else {
	    	to_loc		= "";
	    	to_yard		= "";
	    }

	    if ("Y".equals(rvn_mpt_cntr)) {
	    	cgo_tp_cd		= "M";
	    }

		event 				= (EsdTrs0921Event)request.getAttribute("Event");
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
		document.form.fm_cgo_tp_cd.value="<%=cgo_tp_cd%>";
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
<input type="hidden" name="vndr_seq" value="<%=vndr_seq%>" id="vndr_seq" />
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
<input type="hidden" name="from_nod_cd" value="<%=from_nod_cd==null?"":from_nod_cd%>" id="from_nod_cd" />
<input type="hidden" name="via_nod_cd" value="<%=via_nod_cd==null?"":via_nod_cd%>" id="via_nod_cd" />
<input type="hidden" name="door_nod_cd" value="<%=door_nod_cd==null?"":door_nod_cd%>" id="door_nod_cd" />
<input type="hidden" name="to_nod_cd" value="<%=to_nod_cd==null?"":to_nod_cd%>" id="to_nod_cd" />
<input type="hidden" name="bundle_cnt" value="<%=bundle_cnt%>" id="bundle_cnt" />
<input type="hidden" name="wgt_uom" value="<%=wgt_uom%>" id="wgt_uom" />
<input type="hidden" name="wgt_qty" value="<%=wgt_qty%>" id="wgt_qty" />
<input type="hidden" name="dist_km" value="<%=dist_km%>" id="dist_km" />
<input type="hidden" name="dist_mile" value="<%=dist_mile%>" id="dist_mile" />
<input type="hidden" name="single_multi_sep" value="<%=single_multi_sep%>" id="single_multi_sep"  />
<input type="hidden" name="wo_issued" value="<%=wo_issued%>" id="wo_issued"  />
<input type="hidden" name="basic_rt" value="<%=basic_rt%>" id="basic_rt"  />
<input type="hidden" name="nego_amt" value="<%=nego_amt%>" id="nego_amt"  />
<input type="hidden" name="fuel_scg_rt" value="<%=fuel_scg_rt%>" id="fuel_scg_rt"  />
<input type="hidden" name="etc_add_amt" value="<%=etc_add_amt%>" id="etc_add_amt"  />
<input type="hidden" name="trsp_agmt_ofc_cty_cd" value="<%=trsp_agmt_ofc_cty_cd%>" id="trsp_agmt_ofc_cty_cd"  />
<input type="hidden" name="trsp_agmt_seq" value="<%=trsp_agmt_seq%>" id="trsp_agmt_seq"  />
<input type="hidden" name="conti_cd" value="<%=conti_cd%>" id="conti_cd"  />
<input type="hidden" name="scg_ind_cd" value="<%=scg_ind_cd%>" id="scg_ind_cd"  />
<div class="layer_popup_title">
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>More Candidate</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" type="button" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button class="btn_accent" type="button" name="btn_filter" id="btn_filter">Filter by S/P</button><!--
		--><button class="btn_accent" type="button" name="btn_apply" id="btn_apply">Apply</button><!--
		--><button class="btn_normal" type="button" name="btn_close" id="btn_close">Close</button><!--
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
				<col width="100" />				
				<col width="120" />				
				<col width="80" />				
				<col width="110" />				
				<col width="90" />	
				<col width="110" />	
				<col width="90" />	
				<col width="110" />	
				<col width="90" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Service Provider</th>
					<td>
					<%if(wo_issued.equals("Y")) { %>
						<input name="fm_vndr_prmry_seq" type="text"  style="width:50px;" value="<%=vndr_seq %>"  maxlength="6" readOnly><!--
					 --><input name="fm_vndr_prmry_nm" type="text" style="width:95px;" value="<%=vndr_nm %>" class="input2"  title="This inputbox cant't write" readOnly><!--
					 --><button type="button" class="input_seach_btn" id='btn_provider' name='btn_provider' disabled></button>
					<%} else { %>
						<input name="fm_vndr_prmry_seq" type="text"  style="width:50px;" value=""  maxlength="6" onBlur="vender_blur();"><!--
					 --><input name="fm_vndr_prmry_nm" type="text" style="width:95px;" value="" class="input2"  title="This inputbox cant't write" readOnly><!--
					 --><button type="button" class="input_seach_btn" id='btn_provider' name='btn_provider'></button>
					 <%} %>
					</td>
		   		</tr>
		   		<tr>
		   			<th>Container TP/SZ</th>
					<td><input type="text" style="width:30px;background-color: white;" name="eq_tpsz_cd" id="eq_tpsz_cd" value="<%=eq_tp_sz_cd%>" align="center" readonly></td>
					<th>Cost Mode</th>
					<td><input type="text" style="width:50px;background-color: white;" name="fm_cost_mod_cd" value="<%=cost_mod_cd%>" align="right" id="fm_cost_mod_cd" readonly/> </td>
					<th>Trans Mode</th>
					<td><input type="text" style="width:79px;background-color: white;" name="fm_crr_mod_cd" value="<%=crr_mod_cd%>" align="right" id="fm_crr_mod_cd" readonly/> </td>
		   			<th>Cargo Type</th>
					<td>
	                    <select name="fm_cgo_tp_cd" id="fm_cgo_tp_cd" style="width:98px;" disabled >
	                        <option value="F">FULL</option>
	                        <option value="M">EMPTY</option>
	                    </select> 
					</td>
		   		</tr>
		   		<tr>
					<th>From Node</th>
					<td><input type="text" style="width:50px;background-color: white;" name="fm_loce" id="fm_loce" value="<%=from_loc%>" align="center" readonly><!-- 
						 --><input type="text" style="width:25px;background-color: white;" name="fm_yard" id="fm_yard" value="<%=from_yard%>" align="center" readonly></td>
					<th>Via Node</th>
					<td><input type="text" style="width:50px;background-color: white;" name="via_loce" id="via_loce" value="<%=via_loc%>" align="center" readonly><!-- 
						 --><input type="text" style="width:25px;background-color: white;" name="via_yard" id="via_yard" value="<%=via_yard%>" align="center" readonly></td>
					<th>To Node</th>
					<td><input type="text" style="width:50px;background-color: white;" name="to_loce" id="to_loce" value="<%=to_loc%>" align="center" readonly><!-- 
						 --><input type="text" style="width:25px;background-color: white;" name="to_yard" id="to_yard" value="<%=to_yard%>" align="center" readonly></td>
					<th>Door Location</th>
					<td><input type="text" style="width:50px;background-color: white;" name="dor_loce" id="dor_loce" value="<%=door_loc%>" align="center" readonly><!-- 
						 --><input type="text" style="width:25px;background-color: white;" name="dor_yard" id="dor_yard" value="<%=door_zone%>" align="center" readonly></td>
		   		</tr>
		   		<tr>
		   			<th>Bound</th>
					<td><input type="text" style="width:50px;background-color: white;" name="fm_bound_cd" value="<%=bound_cd%>" align="center" id="fm_bound_cd" readonly/></td>
		   			<th>Cargo Nature</th>
					<td><input type="text" style="width:50px;background-color: white;" name="spcl_cgo_cntr_tp_cd" value="<%=spcl_cgo_cntr_tp_cd%>" align="center" id="spcl_cgo_cntr_tp_cd" readonly/></td>
		   			<th>Revenue Empty Container</th>
					<td><input type="text" style="width:50px;background-color: white;" name="rvn_mpt_cntr" value="<%=rvn_mpt_cntr%>" align="center" id="rvn_mpt_cntr" readonly /></td>
		   		</tr>
		   </tbody>
		</table>		
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

	<div class="wrap_result">
        <!-- opus_tab_btn(S) -->
        <div class="opus_design_tab">
            <script type="text/javascript">ComTabObject('tab1')</script>
        </div>
        <!-- opus_tab_btn(E) -->
        <div id="tabLayer" name="tabLayer" style="display:inline">
            <div class="opus_design_grid clear" id="mainTable" >
            	<script type="text/javascript">ComSheetObject('sheet0');</script>
            </div>
        </div>
        <div id="tabLayer" name="tabLayer" style="display:none">
            <div class="opus_design_grid clear" id="mainTable" >
                <script type="text/javascript">ComSheetObject('sheet1');</script>
             </div>
        </div>
	</div>
</div>

</form>
