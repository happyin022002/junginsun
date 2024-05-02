<%@page import="com.nhncorp.lucy.security.xss.XssFilter"%>
<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName :  VOP_VSK_0025.jsp
*@FileTitle : Actual SKD Report Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/15
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.event.VopVsk0025Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import = "com.clt.framework.component.util.StringUtil" %> 

<%
	VopVsk0025Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error Message
	int rowCount	 = 0;						//count of DB ResultSet list
 
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";	// Office Code 삭제시 Delete 버튼 활성화 여부 확인.
	String strUsrAuth		= "";
	
	String cstVslCd = "";
	String cstSkdVoyNo = "";
	String cstSkdDirCd = "";
	String cstYdCd = "";
	String cstClptIndSeq = "";
	String popYn = "";
	
	Logger log = Logger.getLogger("com.clt.apps.ActualScheduleManagement.ActualScheduleMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		String[] aryUsrAuth = account.getUserAuth();
		
		StringBuffer sbUsrAuth	= new StringBuffer();
		
		for(int i=0; i<aryUsrAuth.length; i++){
			if(i==0){
				//::2014-04-18:://
				//strUsrAuth = aryUsrAuth[i];
				
				sbUsrAuth.append(aryUsrAuth[i]);
				
			}else{
				//::2014-04-18:://
				//strUsrAuth = strUsrAuth + "|" + aryUsrAuth[i];
				
				sbUsrAuth.append(strUsrAuth);
				sbUsrAuth.append("|");
				sbUsrAuth.append(aryUsrAuth[i]);
				
			}
		}
		
		strUsrAuth		= sbUsrAuth.toString();
		
		cstVslCd 		= request.getParameter("vslCd");
		cstVslCd 		= cstVslCd==null?"":cstVslCd;
		cstSkdVoyNo 	= request.getParameter("skdVoyNo");
		cstSkdVoyNo 	= cstSkdVoyNo==null?"":cstSkdVoyNo;
		cstSkdDirCd 	= request.getParameter("skdDirCd");
		cstSkdDirCd 	= cstSkdDirCd==null?"":cstSkdDirCd;
		cstYdCd 		= request.getParameter("ydCd");
		cstYdCd 		= cstYdCd==null?"":cstYdCd;
		cstClptIndSeq 	= request.getParameter("clptIndSeq");
		cstClptIndSeq 	= cstClptIndSeq==null?"":cstClptIndSeq;
		popYn 			= request.getParameter("popYn");
		popYn 			= popYn==null?"":popYn;

		event 			= (VopVsk0025Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg 	= new ErrorHandler(serverException).loadPopupMessage();
		}
		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script  type="text/javascript">
	var gOfcCd = "<%=strOfc_cd%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="port_skd_sts_cd" id="port_skd_sts_cd">
<input type="hidden" name="org_port_skd_sts_cd" id="org_port_skd_sts_cd">
<input type="hidden" name="clpt_seq" id="clpt_seq">
<input type="hidden" name="turn_port_flg" id="turn_port_flg">
<input type="hidden" name="turn_port_ind_cd" id="turn_port_ind_cd">
<input type="hidden" name="turn_skd_voy_no" id="turn_skd_voy_no">
<input type="hidden" name="turn_skd_dir_cd" id="turn_skd_dir_cd">
<input type="hidden" name="turn_clpt_ind_seq" id="turn_clpt_ind_seq">
<input type="hidden" name="pre_port_cd" id="pre_port_cd">
<input type="hidden" name="pre_etd_dt" id="pre_etd_dt">
<!--  <input type="hidden" name="lst_eta_dt" id="lst_eta_dt">
<input type="hidden" name="lst_etb_dt" id="lst_etb_dt">
<input type="hidden" name="lst_etd_dt" id="lst_etd_dt">
-->
<input type="hidden" name="vps_eta_dt" id="vps_eta_dt">
<input type="hidden" name="vps_etb_dt" id="vps_etb_dt">
<input type="hidden" name="vps_etd_dt" id="vps_etd_dt">
<input type="hidden" name="loc_cd" id="loc_cd">
<input type="hidden" name="slan_cd" id="slan_cd">
<input type="hidden" name="nxt_act_inp_flg" id="nxt_act_inp_flg">
<input type="hidden" name="act_ata_inp_dt" id="act_ata_inp_dt">
<input type="hidden" name="act_atb_inp_dt" id="act_atb_inp_dt">
<input type="hidden" name="act_atd_inp_dt" id="act_atd_inp_dt">
<input type="hidden" name="act_ata_inp_usr_id" id="act_ata_inp_usr_id">
<input type="hidden" name="act_atb_inp_usr_id" id="act_atb_inp_usr_id">
<input type="hidden" name="act_atd_inp_usr_id" id="act_atd_inp_usr_id">

<input type="hidden" name="org_act_arr_dt" id="org_act_arr_dt">
<input type="hidden" name="org_act_brth_dt" id="org_act_brth_dt">
<input type="hidden" name="org_act_dep_dt" id="org_act_dep_dt">

<input type="hidden" name="clpt_ind_seq" id="clpt_ind_seq">
<input type="hidden" name="yd_cd" id= "yd_cd">

<input type="hidden" name="usr_auth" id= "usr_auth" value="<%=strUsrAuth%>">
<input type="hidden" name="usr_id" id="usr_id" value="<%=strUsr_id%>">
   
<!-- for popup of Cst SKD Update -->
<input type="hidden" name="cst_vsl_cd" id="cst_vsl_cd" value="<%= StringUtil.xssFilter(cstVslCd)%>">
<input type="hidden" name="cst_skd_voy_no" id="cst_skd_voy_no" value="<%=StringUtil.xssFilter(cstSkdVoyNo)%>">
<input type="hidden" name="cst_skd_dir_cd" id="cst_skd_dir_cd" value="<%=StringUtil.xssFilter(cstSkdDirCd)%>">
<input type="hidden" name="cst_yd_cd" id="cst_yd_cd" value="<%=StringUtil.xssFilter(cstYdCd)%>">
<input type="hidden" name="cst_clpt_ind_seq" id="cst_clpt_ind_seq" value="<%=StringUtil.xssFilter(cstClptIndSeq)%>">
<input type="hidden" name="pop_yn" id="pop_yn" value="<%=StringUtil.xssFilter(popYn) %>">

<input type="hidden" name="act_skd_src_sys_cd" id="act_skd_src_sys_cd"><!-- distinguish with Actual SKD and VMS  -->

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">	
		<div>
			<button type="button" class="btn_accent" name="btn_retrieve" 		id="btn_retrieve">Retrieve</button>
			<button type="button" class="btn_normal" name="btn_new" 			id="btn_new">New</button>		
			<button type="button" class="btn_normal" name="btn_save" 	id="btn_save">Save</button>	
			<button  style ="display: none;"type="button" class="btn_normal" name="btn_delete" 		id="btn_delete">Delete</button>		
		</div>									
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->
<div class="wrap_search_tab">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="1px"/>
					<col width="1px"/>
					<col width="1px"/>																
					<col width="1px"/>																
					<col width="1px"/>																
					<col width="1px"/>																
					<col width="1px"/>	
					<col width="*" />
				</colgroup>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td> <input type="text" name="vsl_cd"     id="vsl_cd"     dataformat="engup"     style="width:48px;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="4" onfocus="this.select();"><!-- 
					  --><input type="text" name="skd_voy_no" id="skd_voy_no" dataformat="num"       style="width:48px;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="4" onfocus="this.select();"><!-- 
					  --><input type="text" name="skd_dir_cd" id="skd_dir_cd" dataformat="enguponly" style="width:25px;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="1" onfocus="this.select();" ><!--  
					  --><!-- <input type="hidden" name="hidden1" id="hidden1" style="width:0px;"  value="" > -->
					  	<button type="button" id="btn_vvd" name="btn_vvd" class="input_seach_btn"></button></td>
					<th>Port</th>
					<td width="390"><script language="javascript">ComComboObject('vps_port_cd', 4, 100, 1, 1, 1);</script></td>
					<!-- 
					<th>Call Ind.</th>
					<td><select name="clpt_ind_seq" id="clpt_ind_seq" style="width:80px;" class="input1"></select></td>
					 -->
					<th>Created Date</th>
					<td><input type="text" name="cre_dt" id="cre_dt" style="width:110px;text-align:center;" class="input2" value="" readonly="readonly"><input type="text" name="cre_usr_id" id="cre_usr_id" style="width:70px;" class="input2" value="" readonly="readonly"></td>
				</tr>
				<tr>
					<!-- 
					<th>Calling Terminal</th>
					<td><script  type="text/javascript">ComComboObject('yd_cd',2,85,1,0);</script></td>
					 -->
					<th>Vessel Condition</th>
					<td colspan="3" ><input type="text" name="port_skd_sts_nm" id="port_skd_sts_nm" style="width:80px;text-align:center;" class="input2" value="" readonly="readonly"></td>
					<th>Updated Date</th>
					<td><input type="text" name="upd_dt" id="upd_dt" style="width:110px;text-align:center;" class="input2" value="" readonly="readonly"><input type="text" name="upd_usr_id" id="upd_usr_id" style="width:70px;" class="input2"  value="" readonly="readonly"></td>				
				</tr>					
				<tr>
					<th>Remark(s)</th>
					<td colspan="7"><textarea name="diff_rmk" id="diff_rmk" style="width:775px;height:40px;ime-mode:disabled;resize: none;"></textarea></td>
				</tr>					
			</tbody>
		</table>	
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab sm">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" style="width:98%" name="tabLayer" id="tabLayer">
		
		<!-- opus_design_data(S) -->
		<div class="opus_design_inquiry">
			<table class="grid_2">
				<tbody>
					<tr>
						<th></th>
						<th style="text-align:center">P/F SKD</th>
						<th style="text-align:center">Initial Estimate SKD</th>
						<th style="text-align:center">Actual SKD</th>
						<th style="text-align:center">Delay(Time)</th>
						<th style="text-align:center">Delay Reason</th>
					</tr> 
					
					<tr>
						<th style="text-align:center">Arrival</th>
						<td><input type="text" id="pf_eta_dt"   name="pf_eta_dt"    style="width:100%;height:100%;ime-mode:disabled;text-align:center;" class="noinput2" value="" readonly="readonly"></td>
						<td><input type="text" id="lst_eta_dt"  name="lst_eta_dt"   style="width:100%;height:100%;ime-mode:disabled;text-align:center;" class="noinput2" value="" readonly="readonly"></td>
						<td><input type="text" id="act_arr_dt"  name="act_arr_dt"   style="width:100%;height:100%;ime-mode:disabled;border-color:#ffffff;text-align:center;" class="noinput1" dataformat="ymdhm"  value="" maxlength="16"></td>
						<td><input type="text" id="dlay_arr_tm" name="dlay_arr_tm"  style="width:100%;height:100%;text-align:Right;" class="noinput2" value="" readonly="readonly"></td>
						<td><script  type="text/javascript">ComComboObject('vsl_arr_dlay_rsn_cd',2,60,1,0);</script><input type="text" name="vsl_arr_dlay_rsn_nm" id="vsl_arr_dlay_rsn_nm" style="width:80%;height:100%;" class="noinput2" value="" readonly="readonly"></td>
					</tr>
					<tr>
						<th style="text-align:center">Berthing</th>
						<td><input type="text" id="pf_etb_dt"    name="pf_etb_dt"    style="width:100%;height:100%;ime-mode:disabled;text-align:center;" class="noinput2" value="" readonly="readonly"></td>
						<td><input type="text" id="lst_etb_dt"   name="lst_etb_dt"   style="width:100%;height:100%;ime-mode:disabled;text-align:center;" class="noinput2" value="" readonly="readonly"></td>
						<td><input type="text" id="act_brth_dt"  name="act_brth_dt"  style="width:100%;height:100%;ime-mode:disabled;border-color:#ffffff;text-align:center;" class="noinput1" dataformat="ymdhm" value="" maxlength="16"></td>
						<td><input type="text" id="dlay_brth_tm" name="dlay_brth_tm" style="width:100%;height:100%;text-align:Right;" class="noinput2" value="" readonly="readonly"></td>
						<td><script  type="text/javascript">ComComboObject('vsl_brth_dlay_rsn_cd',2,60,1,0);</script><input type="text" name="vsl_brth_dlay_rsn_nm" id="vsl_brth_dlay_rsn_nm" style="width:80%;height:100%;" class="noinput2" value="" readonly="readonly"></td>
					</tr>
					<tr>
						<th style="text-align:center">Departure</th>
						<td><input type="text" id="pf_etd_dt"   name="pf_etd_dt"     style="width:100%;height:100%;ime-mode:disabled;text-align:center;" class="noinput2" value="" readonly="readonly"></td>
						<td><input type="text" id="lst_etd_dt"  name="lst_etd_dt"    style="width:100%;height:100%;ime-mode:disabled;text-align:center;" class="noinput2" value="" readonly="readonly"></td>
						<td><input type="text" id="act_dep_dt"  name="act_dep_dt"    style="width:100%;height:100%;ime-mode:disabled;border-color:#ffffff;text-align:center;" class="noinput1" dataformat="ymdhm"  value="" maxlength="16"></td>
						<td><input type="text" id="dlay_dep_tm" name="dlay_dep_tm"   style="width:100%;height:100%;text-align:Right;" class="noinput2" value="" readonly="readonly"></td>
						<td><script  type="text/javascript">ComComboObject('vsl_dep_dlay_rsn_cd',2,60,1,0);</script><input type="text" name="vsl_dep_dlay_rsn_nm" id="vsl_dep_dlay_rsn_nm" style="width:80%;height:100%;" class="noinput2" value="" readonly="readonly"></td>
					</tr>
					<tr>
						<th colspan="3" style="text-align:center">Last Pilot Off</th>
						<td><input type="text" name="plt_lst_unld_dt" id="plt_lst_unld_dt" dataformat="ymdhm" style="width:100%;height:100%;ime-mode:disabled;border-color:#ffffff;text-align:center;" class="noinput" value="" maxlength="16"></td>
						<td colspan="3" style="background-color:#f3f5f5">&nbsp;</td>
					</tr>				
					<tr>
						<th colspan="3" style="text-align:center">Anchor Drop/Away Before Berthing</th>
						<td><input type="text" name="bfr_brth_ank_drp_dt" id="bfr_brth_ank_drp_dt" dataformat="ymdhm" style="width:100%;height:100%;ime-mode:disabled;border-color:#ffffff;text-align:center;" class="noinput" value="" maxlength="16"></td>
						<td><input type="text" name="bfr_brth_ank_off_dt" id="bfr_brth_ank_off_dt" dataformat="ymdhm" style="width:100%;height:100%;ime-mode:disabled;border-color:#ffffff;text-align:center;" class="noinput" value="" maxlength="16"></td>
						<td colspan="2" style="background-color:#f3f5f5"></td>
					</tr>
					
					<tr>
						<th colspan="3" style="text-align:center">Anchor Drop/Away After Departure</th>
						<td><input type="text" name="aft_unbrth_ank_drp_dt" id="aft_unbrth_ank_drp_dt" dataformat="ymdhm" style="width:100%;height:100%;ime-mode:disabled;border-color:#ffffff;text-align:center;" class="noinput" value="" maxlength="16"></td>
						<td><input type="text" name="aft_unbrth_ank_off_dt" id="aft_unbrth_ank_off_dt" dataformat="ymdhm" style="width:100%;height:100%;ime-mode:disabled;border-color:#ffffff;text-align:center;" class="noinput" value="" maxlength="16"></td>
						<td colspan="2" style="background-color:#f3f5f5"></td>
					</tr>
					
					<tr>
						<th colspan="2" style="text-align:center">Next Port ETA</th>
						<td><input type="text" name="nxt_port_cd" id="nxt_port_cd" style="width:100%;height:100%;border-color:#ffffff;text-align:center;" class="noinput2" value="" readonly="readonly"></td>
						<td><input type="text" name="nxt_eta_dt" id="nxt_eta_dt" style="width:100%;height:100%;border-color:#ffffff;text-align:center;" class="noinput2" value="" readonly="readonly"></td>
						<td colspan="3" style="background-color:#f3f5f5"></td>
					</tr>
				</tbody>			
			</table>
		</div>
		<!-- opus_design_data(E) -->
		
		<script type="text/javascript">ComSheetObject('sheet1');</script>	
	</div>
	<!-- opus_design_grid(S) -->

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" style="width:98%" name="tabLayer" id="tabLayer">		
		<!-- opus_design_data(S) -->
		<div class="opus_design_inquiry">
			<table class="grid_2" id="tbl_vsl_cond">
				<tbody>				
					<tr>
						<th></th>
						<th colspan="2" style="text-align:center">Arrival</th>
						<th></th>
						<th colspan="2" style="text-align:center">Departure</th>
						<th></th>
						<th colspan="2" style="text-align:center">Supply</th>
						<th></th>
					</tr> 				
					<tr>
						<th style="text-align:center">Fuel Oil</th>
						<td colspan="2" style="text-align:right"><input type="text" name="arr_foil_wgt" id="arr_foil_wgt" dataformat="float" caption="99,999.99" style="width:220px;text-align:right;border-color:#ffffff;" class="noinput" value="" maxlength="9"></td>
						<td style="text-align:center">M/T</td>
						<td colspan="2" style="text-align:right"><input type="text" name="dep_foil_wgt" id="dep_foil_wgt" dataformat="float" caption="99,999.99" style="width:220px;text-align:right;border-color:#ffffff;" class="noinput" value="" maxlength="9"></td>
						<td style="text-align:center">M/T</td>
						<td colspan="2" style="text-align:right"><input type="text" name="spl_foil_wgt" id="spl_foil_wgt" dataformat="float" caption="99,999.99" style="width:210px;text-align:right;border-color:#ffffff;" class="noinput" value="" maxlength="9"></td>
						<td style="text-align:center">M/T</td>
					</tr>
					
					<tr>
						<th style="text-align:center">Low Sulphur Fuel Oil</th>
						<td colspan="2" style="text-align:right"><input type="text" name="arr_low_sulp_foil_wgt" id="arr_low_sulp_foil_wgt" dataformat="float" caption="99,999.99" style="width:220px;text-align:right;border-color:#ffffff;" class="noinput" value="" maxlength="9"></td>
						<td style="text-align:center">M/T</td>
						<td colspan="2" style="text-align:right"><input type="text" name="dep_low_sulp_foil_wgt" id="dep_low_sulp_foil_wgt" dataformat="float" caption="99,999.99" style="width:220px;text-align:right;border-color:#ffffff;" class="noinput" value="" maxlength="9"></td>
						<td style="text-align:center">M/T</td>
						<td colspan="2" style="text-align:right"><input type="text" name="spl_low_sulp_foil_wgt" id="spl_low_sulp_foil_wgt" dataformat="float" caption="99,999.99" style="width:210px;text-align:right;border-color:#ffffff;" class="noinput" value="" maxlength="9"></td>
						<td style="text-align:center">M/T</td>
					</tr>
					
					<tr>
						<th style="text-align:center">Diesel Oil</th>
						<td colspan="2" style="text-align:right"><input type="text" name="arr_doil_wgt" id="arr_doil_wgt" dataformat="float" caption="99,999.99" style="width:220px;text-align:right;border-color:#ffffff;" class="noinput" value="" maxlength="9"></td>
						<td style="text-align:center">M/T</td>
						<td colspan="2" style="text-align:right"><input type="text" name="dep_doil_wgt" id="dep_doil_wgt" dataformat="float" caption="99,999.99" style="width:220px;text-align:right;border-color:#ffffff;" class="noinput" value="" maxlength="9"></td>
						<td style="text-align:center">M/T</td>
						<td colspan="2" style="text-align:right"><input type="text" name="spl_doil_wgt" id="spl_doil_wgt" dataformat="float" caption="99,999.99" style="width:210px;text-align:right;border-color:#ffffff;" class="noinput" value="" maxlength="9"></td>
						<td style="text-align:center">M/T</td>
					</tr>
					
					<tr>
						<th style="text-align:center">Low Sulphur Diesel Oil</th>
						<td colspan="2" style="text-align:right"><input type="text" name="arr_low_sulp_doil_wgt" id="arr_low_sulp_doil_wgt" dataformat="float" caption="99,999.99" style="width:220px;text-align:right;border-color:#ffffff;" class="noinput" value="" maxlength="9"></td>
						<td style="text-align:center">M/T</td>
						<td colspan="2" style="text-align:right"><input type="text" name="dep_low_sulp_doil_wgt" id="dep_low_sulp_doil_wgt" dataformat="float" caption="99,999.99" style="width:220px;text-align:right;border-color:#ffffff;" class="noinput" value="" maxlength="9"></td>
						<td style="text-align:center">M/T</td>
						<td colspan="2" style="text-align:right"><input type="text" name="spl_low_sulp_doil_wgt" id="spl_low_sulp_doil_wgt" dataformat="float" caption="99,999.99" style="width:210px;text-align:right;border-color:#ffffff;" class="noinput" value="" maxlength="9"></td>
						<td style="text-align:center">M/T</td>
					</tr>
					
					<tr>
						<th style="text-align:center">Fresh Water</th>
						<td colspan="2" style="text-align:right"><input type="text" name="arr_frsh_wtr_wgt"  id="arr_frsh_wtr_wgt" dataformat="float" caption="99,999.99" style="width:220px;text-align:right;border-color:#ffffff;" class="noinput" value="" maxlength="9"></td>
						<td style="text-align:center">M/T</td>
						<td colspan="2" style="text-align:right"><input type="text" name="dep_frsh_wtr_wgt"  id="dep_frsh_wtr_wgt"dataformat="float" caption="99,999.99" style="width:220px;text-align:right;border-color:#ffffff;" class="noinput" value="" maxlength="9"></td>
						<td style="text-align:center">M/T</td>
						<td colspan="2" style="text-align:right"><input type="text" name="spl_frsh_wtr_wgt"  id="spl_frsh_wtr_wgt" dataformat="float" caption="99,999.99" style="width:210px;text-align:right;border-color:#ffffff;" class="noinput" value="" maxlength="9"></td>
						<td style="text-align:center">M/T</td>
					</tr>
					
					<tr>
						<th style="text-align:center">Ballast</th>
						<td colspan="2" style="text-align:right"><input type="text" name="arr_blst_wgt" id="arr_blst_wgt" dataformat="float" caption="99,999.99" style="width:220px;text-align:right;border-color:#ffffff;" class="noinput" value="" maxlength="9"></td>
						<td style="text-align:center">M/T</td>
						<td colspan="2" style="text-align:right"><input type="text" name="dep_blst_wgt" id="dep_blst_wgt" dataformat="float" caption="99,999.99" style="width:220px;text-align:right;border-color:#ffffff;" class="noinput" value="" maxlength="9"></td>
						<td style="text-align:center">M/T</td>
						<th colspan="2" style="text-align:center">Discharging</th>
						<th></th>
					</tr>
					
					<tr>
						<th style="text-align:center">Draft Forward</th>
						<td colspan="2" style="text-align:right"><input type="text" name="arr_fwddr_hgt" id="arr_fwddr_hgt" dataformat="float" caption="99.99" style="width:220px;text-align:right;border-color:#ffffff;" class="noinput" value="" maxlength="5"></td>
						<td style="text-align:center">M</td>
						<td colspan="2" style="text-align:right"><input type="text" name="dep_fwddr_hgt" id="dep_fwddr_hgt" dataformat="float" caption="99.99" style="width:220px;text-align:right;border-color:#ffffff;" class="noinput" value="" maxlength="5"></td>
						<td style="text-align:center">M</td>
						<th style="text-align:center">Sludge</th>
						<td style="text-align:right"><input type="text" name="ttl_slg_wgt" id="ttl_slg_wgt" dataformat="float" caption="99,999.99" style="width:150px;text-align:right;border-color:#ffffff;" class="noinput" value="" maxlength="9"></td>
						<td style="text-align:center">M/T</td>
					</tr>
					
					<tr>
						<th style="text-align:center">Draft After</th>
						<td colspan="2" style="text-align:right"><input type="text" name="arr_aftdr_hgt" id="arr_aftdr_hgt" dataformat="float" caption="99.99" style="width:220px;text-align:right;border-color:#ffffff;" class="noinput" value="" maxlength="5"></td>
						<td style="text-align:center">M</td>
						<td colspan="2" style="text-align:right"><input type="text" name="dep_aftdr_hgt" id="dep_aftdr_hgt" dataformat="float" caption="99.99" style="width:220px;text-align:right;border-color:#ffffff;" class="noinput" value="" maxlength="5"></td>
						<td style="text-align:center">M</td>
						<th style="text-align:center">Garbage</th>
						<td style="text-align:right"><input type="text" name="ttl_gbg_qty" id="ttl_gbg_qty" dataformat="float" caption="99,999.99" style="width:150px;text-align:right;border-color:#ffffff;" class="noinput" value="" maxlength="9"></td>
						<td style="text-align:center">CBM</td>
					</tr>
					
					<tr>
						<th style="text-align:center">GM</th>
						<td colspan="2" style="text-align:right"><input type="text" name="arr_gm_hgt" id="arr_gm_hgt" dataformat="float" caption="99.99" style="width:220px;text-align:right;border-color:#ffffff;" class="noinput" value="" maxlength="5"></td>
						<td style="text-align:center">M</td>
						<td colspan="2" style="text-align:right"><input type="text" name="dep_gm_hgt" id="dep_gm_hgt" dataformat="float" caption="99.99" style="width:220px;text-align:right;border-color:#ffffff;" class="noinput" value="" maxlength="5"></td>
						<td style="text-align:center">M</td>
						<td colspan="3"></td>
					</tr>
					
					<tr>
						<th style="text-align:center">No.of TUG</th>
						<td colspan="2" style="text-align:right"><input type="text" name="arr_tug_bot_knt" id="arr_tug_bot_knt" dataformat="float" caption="99" style="width:220px;text-align:right;border-color:#ffffff;" class="noinput" value="" maxlength="2"></td>
						<td style="text-align:center">EA</td>
						<td colspan="2" style="text-align:right"><input type="text" name="dep_tug_bot_knt" id="dep_tug_bot_knt" dataformat="float" caption="99" style="width:220px;text-align:right;border-color:#ffffff;" class="noinput" value="" maxlength="2"></td>
						<td style="text-align:center">EA</td>
						<td colspan="3"></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_data(E) -->	
	</div>
	<!-- opus_design_grid(S) -->
</div>
</form>