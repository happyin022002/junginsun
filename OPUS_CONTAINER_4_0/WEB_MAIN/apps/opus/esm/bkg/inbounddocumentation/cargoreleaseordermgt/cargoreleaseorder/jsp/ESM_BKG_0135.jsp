<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : esm_bkg_0135.jsp
*@FileTitle  : Cargo Release Order_E-D/O inquiry _Main
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/01
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0135Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0135Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from the server
	String strErrMsg = "";						//error messege
	int rowCount	 = 0;						//the number of DB ResultSet List
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.InboundBLMgtSC.FullReleaseOrderBC");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg0135Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		//  extract additional data obtained from the server during Initial loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>In-bond Transportation Application Inquiry</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table class="search" border="0" style="width:100%"> 
				<tbody>
					<tr class="h23">
					<td width="60">MRN No.</td>
					<td width="200"><input type="text" style="width:100" class="input2" value="<%=JSPUtil.getNull(request.getParameter("edo_rqst_no").substring(0, 11))%>" readonly></td>
					<td width="30">MSN</td>
					<td width="200"><input type="text" style="width:100" class="input2" value="<%=JSPUtil.getNull(request.getParameter("edo_rqst_no").substring(11))%>" readonly></td> 
					<td width="60">Approval shipping corporation</td>
					<td width=""><input type="text" style="width:100;" class="input2" value="<%=ConstantMgr.getScacCode()%>" readonly></td>			
					</tr> 
				</tbody>
			</table>
		</div>
	</div>
	<div class="wrap_result">
		<div class="layout_wrap">
			<table class="search" border="0">
					<tr>
						<td class="title_h"></td>
						<td class="title_s"><b>Master B/L No.</b></td>
					</tr>
			</table>
			<table border="0" style="width:900; background-color:white;" class="grid2"> 
					<tr>
						<th class="tr2_head" width="150">B/L No</th> 
						<td width="300" class="input2" colspan="2"><input type="text" name = "bl_no" style="width:100%;" class="noinput2" value="" readonly></td> 
						<th class="tr2_head" width="150">Application Date</th> 
						<td class="input2" colspan="2" width="300"><input type="text" name = "edo_rct_dt" style="width:100%;" class="noinput2" value="" readonly></td> 
					</tr>
								
					<tr>
						<th class="tr2_head" width="">The applicant</th> 
						<td width="100" class="input2"><input type="text" name = "ms_pty_rgst_no" style="width:100%;" class="noinput2" value="" readonly></td> 
						<td width="200" class="input2"><input type="text" name = "ms_pty_nm" style="width:100%;" class="noinput2" value="" readonly></td> 
						<th class="tr2_head" width="">Check Date</th> 
						<td class="input2" colspan="2"><input type="text" style="width:100%;" class="noinput2" value=" " readonly></td> 
					</tr>
					<tr>
						<th class="tr2_head" width="">Approved carriers</th> 
						<td width="" class="input2"><input type="text" name = "ga_pty_rgst_no" style="width:100%;" class="noinput2" value="" readonly></td> 
						<td width="" class="input2"><input type="text" name = "ga_pty_nm" style="width:100%;" class="noinput2" value="" readonly></td> 
						<th class="tr2_head" width="">Approval Date</th> 
						<td class="input2" colspan="2"><input type="text" name = "edo_ack_dt_a" style="width:100%;" class="noinput2" value="" readonly></td> 
					</tr>
					<tr>
						<th class="tr2_head" width="">Receipt place</th> 
						<td width="" class="input2"><input type="text" name = "edo_rct_loc_cd" style="width:100%;" class="noinput2" value="" readonly></td> 
						<td width="" class="input2"><input type="text" name = "edo_rct_loc_nm" style="width:100%;" class="noinput2" value="" readonly></td> 
						<th class="tr2_head" width="">denial date</th> 
						<td class="input2"  colspan="2"><input type="text" name = "edo_ack_dt_r" style="width:100%;" class="noinput2" value="" readonly></td> 
					</tr>
					<tr>
						<th class="tr2_head" width="">Bonded area destinations</th> 
						<td width="" class="input2"><input type="text" name = "arr_area_no" style="width:100%;" class="noinput2" value="" readonly></td> 
						<td width="" class="input2"><input type="text" name = "arr_area_vndr_nm" style="width:100%;" class="noinput2" value="" readonly></td> 
						<th class="tr2_head" width="">USER ID</th> 
						<td class="input2"  colspan="2"><input type="text" name = "edo_ack_usr_id" style="width:100%;" class="noinput2" value="" readonly></td> 
					</tr>
					<tr>
					<th class="tr2_head" width="">Voyage</th> 
						<td width="" class="input2" colspan="2"><input type="text" name = "skd_nm" style="width:100%;" class="noinput2" value="" readonly></td> 
						<th class="tr2_head" width="">Destination Customs</th> 
						<td width="100" class="input2"><input type="text" name = "arr_cstms_no" style="width:100%;" class="noinput2" value="" readonly></td> 
						<td width="200" class="input2"><input type="text" name = "arr_cstms_vndr_nm" style="width:100%;" class="noinput2" value="" readonly></td> 
					</tr>
					<tr>
						<th class="tr2_head" width="">ship name</th> 
						<td width="" class="input2" colspan="2"><input type="text" name = "edo_vsl_nm" style="width:100%;" class="noinput2" value="" readonly></td> 
						<th class="tr2_head" width="">Arrival date</th> 
						<td width="" class="input2" colspan="2"><input type="text" name = "vsl_arr_dt" style="width:100%;" class="noinput2" value="" readonly></td> 
					</tr>
					<tr>
						<th class="tr2_head" width="">Total number of Packing</th> 
						<td width="" class="input2"><input type="text" name = "pck_qty" style="width:100%;text-align:right" class="noinput2" value="" readonly></td> 
						<td width="" class="input2"><input type="text" name = "pck_tp_cd" style="width:100%;" class="noinput2" value="" readonly></td> 
						<th class="tr2_head" width="">The number of containers</th> 
						<td width="" class="input2" colspan="2"><input type="text" name = "cntr_no" style="width:100%;"class="noinput2"value="" readonly></td> 
					</tr>
					<tr>
						<th class="tr2_head" width="">Item</th> 
						<td width="" class="input2" colspan="2"><input type="text" name = "gds_desc1"  style="width:100%;" class="noinput2" value="" readonly></td> 
						<th class="tr2_head" width="">Gross</th> 
						<td width="" class="input2" colspan="2"><input type="text" name = "ttl_wgt" style="width:100%;" class="noinput2" value="" readonly></td> 
					</tr>
					 <tr>
						<th class="tr2_head" width=""></th> 
						<td width="" class="input2" colspan="2"><input type="text" name = "gds_desc2" style="width:100%;" class="noinput2" value="" readonly></td> 
								
						<td width="" class="input2" colspan="3" rowspan="5"><input type="text" style="width:100%;" class="noinput2" value="" readonly></td> 
					</tr>
					<tr>
						<th class="tr2_head" width=""></th> 
						<td width="" class="input2" colspan="2"><input type="text" name = "gds_desc3" style="width:100%;" class="noinput2" value="" readonly></td> 
					</tr>
					<tr>
						<th class="tr2_head" width=""></th> 
						<td width="" class="input2" colspan="2"><input type="text" name = "gds_desc4" style="width:100%;" class="noinput2" value="" readonly></td> 
					</tr>
					<tr>
						<th class="tr2_head" width="">Requests</th> 
						<td width="" class="input2" colspan="2"><input type="text" name = "diff_rmk" style="width:100%;" class="noinput2" value="" readonly></td> 
					</tr>
					<tr>
						<th class="tr2_head" width=""></th> 
						<td width="" class="input2" colspan="2"><input type="text" style="width:100%;" class="noinput2" value="" readonly></td> 
								
					</tr>
					<tr>
						<th class="tr2_head" width="">Request date</th> 
						<td width="" class="input2" colspan="2"><input type="text" name = "rqst_trsp_dt" style="width:100%;" class="noinput2" value="" readonly></td> 
						<th class="tr2_head" width="">Import prices</th> 
						<td width="" class="input2" colspan="2"><input type="text" name = "inv_amt" style="width:100%;" class="noinput2" value="" readonly></td> 
					</tr>
			</table> 
		</div>
	</div>
	<div class="wrap_result">
		<div class="layout_wrap">
			<table class="search" border="0">
							<tr><td class="title_h"></td>
								<td class="title_s"><b>Application vendors</b></td></tr>
							</table>
						<table border="0" style="width:900; background-color:white;" class="grid2"> 
							<tr>
								<th class="tr2_head" width="150">Company name</th> 
								<td width="300" class="input2"><input type="text" name = "ms_pty_nm2" style="width:100%;" class="noinput2" value="" readonly></td> 
								<th class="tr2_head" width="150">Person in charge</th> 
								<td width="300" class="input2"><input type="text" name = "ms_pty_cntc_pson_nm" style="width:100%;" class="noinput2" value="" readonly></td> 
							</tr>
							<tr>
								<th class="tr2_head" width="150">Phone number</th> 
								<td width="300" class="input2"><input type="text" name = "ms_phn_no" style="width:100%;" class="noinput2" value="" readonly></td> 
								<td class="input2" colspan="2"></td> 
							</tr>
						</table>
		</div>
	</div>
	<div class="wrap_result">
		<div class="layout_wrap">
			<table class="search" border="0">
							<tr><td class="title_h"></td>
								<td class="title_s"><b>Ship owner</b></td></tr>
							</table>
						<table border="0" style="width:900; background-color:white;" class="grid2"> 
							<tr>
								<th class="tr2_head" width="150">Company name</th> 
								<td width="300" class="input2"><input type="text" name = "as_pty_nm" style="width:100%;" class="noinput2" value="" readonly></td> 
								<th class="tr2_head" width="150">Business Number</th> 
								<td width="300" class="input2"><input type="text" name = "as_pty_rgst_no" style="width:100%;" class="noinput2" value="" readonly></td> 
							</tr>
							<tr>
								<th class="tr2_head" width="150">Representatives</th> 
								<td width="300" class="input2"><input type="text" name = "as_pty_rep_nm" style="width:100%;" class="noinput2" value="" readonly></td> 
								<th class="tr2_head" width="150">Contact</th> 
								<td width="300" class="input2"><input type="text" name = "as_phn_no" style="width:100%;" class="noinput2" value="" readonly></td> 
							</tr>
							<tr>
								<th class="tr2_head" width="150" rowspan="3">Address</th> 
								<td width="300" class="input2"><input type="text" name = "as_pty_addr1" style="width:100%;" class="noinput2" value="" readonly></td> 
								<td class="input2" colspan="2" rowspan="3"></td> 
							</tr>
							<tr>
								<td width="300" class="input2"><input type="text" name = "as_pty_addr2" style="width:100%;" class="noinput2" value="" readonly></td> 
							</tr>
							<tr>
								<td width="300" class="input2"><input type="text" name = "as_pty_addr3" style="width:100%;" class="noinput2" value="" readonly></td> 
							</tr>
						</table> 
		</div>
	</div>
	
	<div class="wrap_result">
		<div class="layout_wrap">
				<table class="search" border="0">
							<tr><td class="title_h"></td>
								<td class="title_s"><b>Consignee </b></td></tr>
							</table>
						<table border="0" style="width:900; background-color:white;" class="grid2"> 
							<tr>
								<th class="tr2_head" width="150">Consignee company name </th> 
								<td width="300" class="input2"><input type="text" name = "cn_pty_nm" style="width:100%;" class="noinput2" value="" readonly></td> 
								<th class="tr2_head" width="150">Business Number</th> 
								<td width="300" class="input2"><input type="text" name = "cn_pty_rgst_no" style="width:100%;" class="noinput2" value="" readonly></td> 
							</tr>
							<tr>
								<th class="tr2_head" width="150">The place of notice name</th> 
								<td width="300" class="input2"><input type="text" name = "ni_pty_nm" style="width:100%;" class="noinput2" value="" readonly></td> 
								<th class="tr2_head" width="150">Business Numbe</th> 
								<td width="300" class="input2"><input type="text" name = "ni_pty_rgst_no" style="width:100%;" class="noinput2" value="" readonly></td> 
							</tr>
						</table> 
		</div>
	</div>
	
	<div class="wrap_result">
		<div class="opus_design_grid" >			
			<script language="javascript">ComSheetObject('sheet1');</script>
			<script language="javascript">ComSheetObject('sheet2');</script>
			<script language="javascript">ComSheetObject('sheet3');</script>
		</div>
	</div>
</div>

<input type='hidden' name ='frm_edo_rqst_no' value = "<%=JSPUtil.getNull(request.getParameter("edo_rqst_no"))%>">
<input type='hidden' name ='frm_edo_tp_cd' value = "<%=JSPUtil.getNull(request.getParameter("edo_tp_cd"))%>">
<input type='hidden' name ='frm_edo_rqst_seq_5jn' value = "<%=JSPUtil.getNull(request.getParameter("edo_rqst_seq_5jn"))%>">
<input type='hidden' name ='frm_edo_rqst_seq_5jm' value = "<%=JSPUtil.getNull(request.getParameter("edo_rqst_seq_5jm"))%>">
<input type='hidden' name ='frm_edo_rqst_seq_5jk' value = "<%=JSPUtil.getNull(request.getParameter("edo_rqst_seq_5jk"))%>">
</form>

<%@include file="/bizcommon/include/common_opus.jsp"%>