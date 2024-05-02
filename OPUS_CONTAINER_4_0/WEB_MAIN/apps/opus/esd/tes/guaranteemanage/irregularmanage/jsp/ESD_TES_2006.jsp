<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESD_TES_2006.jsp
*@FileTitle : Irregular Creation & Adjustment
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/02
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tes.guaranteemanage.irregularmanage.event.EsdTes2006Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTes2006Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;				//Server Exception
	String strErrMsg = "";							//Error Message
	int rowCount	 = 0;							//DB ResultSet Count

	String		successFlag		= "";
	String		codeList		= "";
	String		pageRows		= "100";

	String		strUsr_id		= "";
	String		strUsr_nm		= "";
	String		strOfc_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.GuaranteeManage.IrregularManage");

	String		referer			= JSPUtil.getNull(request.getHeader("REFERER"));

	String		gnte_no			= JSPUtil.getParameter(request, "gnte_no		".trim(), "");
	String		irr_no			= JSPUtil.getParameter(request, "irr_no			".trim(), "");
	String		gnte_flg		= JSPUtil.getNull(JSPUtil.getParameter(request, "gnte_flg".trim(), ""), "N");
	String		inq_flg			= JSPUtil.getNull(JSPUtil.getParameter(request, "inq_flg".trim(), ""), "N");
	String		gnte_tp_cd		= JSPUtil.getParameter(request, "gnte_tp_cd		".trim(), "");
	String		curr_cd			= JSPUtil.getParameter(request, "curr_cd		".trim(), "");
	String		ttl_amt			= JSPUtil.getParameter(request, "ttl_amt		".trim(), "");
	String		bkg_sts_cd		= JSPUtil.getParameter(request, "bkg_sts_cd		".trim(), "");
	String		cntr_list		= JSPUtil.getParameter(request, "cntr_list		".trim(), "");
	String		cntr_seq		= JSPUtil.getParameter(request, "cntr_seq		".trim(), "");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();


		event = (EsdTes2006Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// To initialize the imported data extracted from the server loading 
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>


<script  type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="DB_DATE">
<input type="hidden" name="dmy_flg" id="dmy_flg">
<!-- Container No. Booking No. RowId for input-->
<input type="hidden" name="rowId" id="rowId">	
<input type="hidden" name="is_valid_TPB" id="is_valid_TPB">

<!-- DEPART Validation Check Use -->
<input type="hidden" name="is_valid_dept_no" id="is_valid_dept_no">
<input type="hidden" name="dept_no" id="dept_no">
<input type="hidden" name="yd_cd" id="yd_cd" value='___'>

<!-- Container Info Select Use	-->
<input type="hidden" name="bkg_no_tmp" id="bkg_no_tmp">
<input type="hidden" name="cntr_no_tmp" id="cntr_no_tmp">
<input type="hidden" name="is_valid_cntr_info" id="is_valid_cntr_info">

<!-- Retrieve Use	-->
<input type="hidden" name="retrieveFlg"	id="retrieveFlg"		value='N'>
										
<input type="hidden" name="regflag"	id="regflag"		value="Y">
<input type="hidden" name="referer"	id="referer"		value="<%=referer%>">
<input type="hidden" name="inq_flg"	id="inq_flg"		value="<%=inq_flg%>">
<input type="hidden" name="gnte_flg" id="gnte_flg"		value="<%=gnte_flg%>">
<input type="hidden" name="gnte_no"	id="gnte_no"		value="<%=gnte_no %>">
<input type="hidden" name="cre_ofc_cd"	id="cre_ofc_cd"	value="<%=strOfc_cd%>">

<!-- Guarantee Transfer Irregular Creation Use	-->
<input type="hidden" name="gnte_tp_cd_gnte"	id="gnte_tp_cd_gnte" value="<%=gnte_tp_cd%>">
<input type="hidden" name="curr_cd_gnte"	id="curr_cd_gnte" value="<%=curr_cd%>">
<input type="hidden" name="ttl_amt_gnte"	id="ttl_amt_gnte" value="<%=ttl_amt%>">
<input type="hidden" name="bkg_sts_cd_gnte"	id="bkg_sts_cd_gnte" value="<%=bkg_sts_cd%>">
<input type="hidden" name="cntr_list"	id="cntr_list"	value="<%=cntr_list%>">

<!-- Guarantee Transfer Irregular Creation Use	-->
<input type="hidden" name="cntr_seq"	id="cntr_seq"	value="<%=cntr_seq %>">

<!-- 2017.01.02 Add Guarantee dummy flag  -->
<input type="hidden" name="dmy_flg"	id="dmy_flg"	value="">

<div class="page_title_area clear">
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- btn_div -->
	<div class="opus_design_btn"><!-- 
	    --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
	    --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
	    --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
	    --><button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Delete</button><!-- 
	    --><button type="button" class="btn_normal" name="btn_guarantee" id="btn_guarantee">Guarantee</button><!-- 
	 --></div>

   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
</div>

<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="130">
				<col width="150">
				<col width="100">
				<col width="90">
				<col width="100">
				<col width="100">
				<col width="100">
				<col width="100">
				<col width="80">
				<col width="*">
			</colgroup>
			<tr >
				<th>Reference Number</th>
				<td><input type="text" style="width:100px" name="irr_no" id="irr_no" value="<%=irr_no %>" maxlength="12" OnKeyUp="isApNum2(this)"><button type="button" id="btn_refno" name="btn_refno" class="input_seach_btn"></button></td>
				<th>Office Code</th>
				<td><input type="text" style="width:70px" name="ofc_cd" id="ofc_cd" value="<%=strOfc_cd %>" class="input2" readonly></td>
				<th>USER ID</th>
				<td><input type="text" style="width:81px" name="cre_usr_id" id="cre_usr_id" value="<%=strUsr_id %>" class="input2" readonly></td>
				<th>Creation Date</th>
				<td><input type="text" style="width:115px" name="cre_dt" id="cre_dt" class="input2" readonly></td>
				<th>Delete</th>
				<td><input type="text" style="width:30px" name="delt_flg" id="delt_flg" class="input2" readonly></td>
			</tr>
		</table>

		<table>
			<colgroup>
				<col width="130">
				<col width="150">
				<col width="100">
				<col width="90">
				<col width="100">
				<col width="100">
				<col width="100">
				<col width="*">
			</colgroup>
			<tr >
				<th>Type</th>
				<td><select name="gnte_tp_cd" id="gnte_tp_cd" OnChange="JavaScript:setTypeCntrDt();" style="width:100px"><option value="ST">Storage</option><option value="FL">Flip</option><option value="CY">Other</option></select></td>
				<th>Currency Code</th>
				<td><select name="curr_cd" id="curr_cd" style="width:70px"><option value="USD">USD</option><option value="CAD">CAD</option></select></td>
				<th>Booking Status</th>
				<td><select name="bkg_sts_cd" id="bkg_sts_cd"><option value="F">Firm</option><option value="C">Canceled</option></select></td>
				<th>Irregular Type</th>
				<td><select name="irr_tp_cd" id="irr_tp_cd" OnChange="JavaScript:irrTpCdChange();"><option value="I">Irregularity</option><option value="O">Operation Cost</option></select></td>
			</tr>
		</table>
	</div>
	<table class="line_bluedot"><tr><td></td></tr></table>
	<div class="opus_design_inquiry wFit">	
		<!-- layout_wrap (S) -->
		 <div class="layout_wrap">
		     <div class="layout_vertical_2" style="width:520px;"> 
		     <table>
		     		<colgroup>
						<col width="80">
						<col width="190">
						<col width="60">
						<col width="*">
					</colgroup>
					<tr >
						<th>DEPART</th>
						<td><input type="text" name="cost_ofc_cd" id="cost_ofc_cd" style="width:50px;" maxlength="6" OnKeyUp='tes_isApNum(this);upper(this);' OnBlur='validateDeptNo();' value="<%=strOfc_cd%>"></td>
						<th>Amount</th>
						<td><input type="text" name="irr_ttl_amt" id="irr_ttl_amt" style="width:180px;" maxlength="13" class="input2" readonly></td>						
					</tr>		
					<tr >
						<th>RESP PART</th>
						<td colspan="3"><textarea name="respb_pty_nm" id="respb_pty_nm" style="width:430px; height:42px;resize:none"></textarea></td>
					</tr>
					<tr><td colspan="4"><h3 class="title_design" style="margin-bottom:0px;">Reason </h3></td></tr>
					<tr><td colspan="4"><textarea name="irr_rsn_rmk" id="irr_rsn_rmk" style="width:510px; height:77px;resize:none"></textarea></td>
					</tr>					 
				</table>	       
		     </div>     
		     <div class="layout_vertical_2 pad_left_8" style="width: 450px;">
		     	<div name="irLayer" id="irLayer" style="display:inline">
					<table class="grid_2">
	   					<tr>
							<th rowspan="4"><b>Irregularity</b></th>
							<td><input type="checkbox" name="irr_stf_err_flg" id="irr_stf_err_flg"		value="Y" ><b>Staff Error</b></td>
							<td><input type="checkbox" name="irr_late_dis_flg"	id="irr_late_dis_flg"	value="Y" ><b>Late Dispatch</b></td>
						</tr>
	  					<tr>
	  						<td><input type="checkbox" name="irr_sys_err_flg"	id="irr_sys_err_flg"	value="Y" ><b>System Error</b></td>
	  						<td><input type="checkbox" name="irr_lack_of_flw_flg" id="irr_lack_of_flw_flg"	value="Y" ><b>Lack of follow</b></td>
	  					</tr>
	  					<tr>
	  						<td><input type="checkbox" name="irr_chss_shtg_flg"	id="irr_chss_shtg_flg"	value="Y"><b>Chassis Shortage</b></td>
	  						<td><input type="checkbox" name="irr_cxl_wo_flg"	id="irr_cxl_wo_flg"		value="Y" ><b>Canceled Work order</b></td>
	  					</tr>
	  					<tr>
	  						<td><input type="checkbox" name="irr_otr_flg"	id="irr_otr_flg"		value="Y" ><b>Other</b></td>
	  						<td><input type="checkbox" name="irr_eq_shtg_flg"	id="irr_eq_shtg_flg"	value="Y"><b>EQ Shortage</b></td>
	  					</tr>
					</table>
				</div>
				<!-- Case of Operation Cost	-->					
				<div name="irLayer" id="irLayer" style="display:none">
					<table class="grid_2">
    					<tr >
							<th rowspan="4"><b>Operation Cost</b></th>
							<td><input type="checkbox" name="op_cost_ocp_flg"	id="op_cost_ocp_flg"	value="Y" class="trans"><b>OCP</b></td>
							<td><input type="checkbox" name="op_cost_sptg_icrz_flg" id="op_cost_sptg_icrz_flg" value="Y" class="trans"><b>Spot Increase</b></td>
						</tr>
   						<tr >
   							<td><input type="checkbox" name="op_cost_tnk_ord_flg"	id="op_cost_tnk_ord_flg"	value="Y" class="trans"><b>Tank Order</b></td>
   							<td><input type="checkbox" name="op_cost_otr_tml_chss_flg" id="op_cost_otr_tml_chss_flg"	value="Y" class="trans"><b>Other TML CHZ</b></td>
   						</tr>
   						<tr >
   							<td><input type="checkbox" name="op_cost_team_trkg_flg"	id="op_cost_team_trkg_flg" value="Y" class="trans"><b>Team Trucking</b></td>
   							<td><input type="checkbox" name="op_cost_mnr_flg"	id="op_cost_mnr_flg"	value="Y" class="trans"><b>M&R</b></td></tr>
   						<tr >
   							<td><input type="checkbox" name="op_cost_xtra_ft_flg" id="op_cost_xtra_ft_flg"	value="Y" class="trans"><b>EXT.Freetime</b></td>
   							<td><input type="checkbox" name="op_cost_tri_axl_flg" id="op_cost_tri_axl_flg"	value="Y" class="trans"><b>Triaxle(Covered by S/C or B/L)</b></td>
   						</tr>
					</table>	
				</div>	
				<table>
					 <tr><td><h3 class="title_design" style="margin:8px 0 0 0;">Preventive Measurement</h3></td></tr>
					 <tr><td><textarea name="irr_prvt_rmk" id="irr_prvt_rmk" style="width:450px; height:42px;resize:none" ></textarea></td></tr>
				</table>				
		     </div>
		 </div>
		<!-- layout_wrap (e) -->
	</div>
</div>

<div class="wrap_result">	
	<div class="opus_design_grid clear">
		<div class="opus_design_btn">
	   		<button type="button" class="btn_normal" name="btng_rowadd" id="btng_rowadd">Row Add</button><!-- 
	   		--><button type="button" class="btn_normal" name="btng_rowdelete" id="btng_rowdelete">Row Delete</button>
		</div>
		<script  type="text/javascript">ComSheetObject('sheet1');</script>
		
		<div style='display:none'>
			<script  type="text/javascript">ComSheetObject('sheet2');</script>	
		</div>		
	</div>	
</div>
<div class="header_fixed"></div>
</form>
