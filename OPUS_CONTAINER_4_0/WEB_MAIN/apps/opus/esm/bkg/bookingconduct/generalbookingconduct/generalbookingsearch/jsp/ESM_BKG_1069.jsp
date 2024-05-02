<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1069.jsp
*@FileTitle  : Route Detail inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/14
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg1069Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1069Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";				//error message
	int rowCount	 = 0;				//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.generalbookingconduct.generalbookingsearch");

	String bkgNo = "";
	
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg1069Event)request.getAttribute("Event");
		bkgNo = JSPUtil.getParameter(request, "bkg_no");
						
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" id="bkg_no" name="bkg_no" value="<%=bkgNo%>">

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Route Detail</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_result">
		
		<div class="opus_design_grid" >
			<h3 class="title_design grid_heading_clear">OCEAN ROUTE</h3>
			<div class="grid2 noinput2">
				<table style="width:491px"> 
					<tr>
						<th width="100">ETA of 1st VVD</th>
						<td width="130">
							<input type="text" id="vps_eta_dt_date" name="vps_eta_dt_date" style="width:75px;" class="input2" value="" readOnly><!-- 
						 --><input type="text" id="vps_eta_dt_time" name="vps_eta_dt_time" style="width:45px;" class="input2" value="" readOnly>
						</td>
						<th width="100">ETA of DEL</th>
						<td><input type="text" id="del_eta_day" name="del_eta_day" style="width:75px;" class="input2" readonly><!-- 
						 --><input type="text" id="del_eta_time" name="del_eta_time" style="width:45px;" class="input2" readonly>
						</td>						
					</tr>
				</table> 
			</div>
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
		
		<div class="layout_wrap">
		
			<div class="layout_vertical_2  pad_rgt_4">
				<div class="grid2">
					<h3 class="title_design">ORIGIN INLAND ROUTE</h3>
					<table>
						<tbody>
							<tr>
								<th width="30%" colspan="2">POR</th>
								<th width="30%" colspan="2">POL</th>
								<th>Trans Mode</th>
				   			</tr>
					   		<tr>
								<td width="20%" class="input2"><input type="text" id="por_cd" name="por_cd" style="width:100%;" class="noinput2" value="" readonly></td>
								<td width="10%" class="input2"><input type="text" id="por_nod_cd" name="por_nod_cd" style="width:100%;" class="noinput2" value="" readonly></td>
								<td width="20%" class="input2"><input type="text" id="pol_cd" name="pol_cd" style="width:100%;" class="noinput2" value="" readonly></td>
								<td width="10%" class="input2"><input type="text" id="pol_nod_cd" name="pol_nod_cd" style="width:100%;" class="noinput2" value="" readonly></td>
								<td><script language="javascript">ComComboObject('org_trns_mod_cd', 2, 145, 1, 0, 0)</script></td>
					   		</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="layout_vertical_2 pad_left_4">
				<div class="grid2">
					<h3 class="title_design">ORIGIN INLAND ROUTE</h3>
					<table>
						<tbody>
							<tr  class="tr2_head">
								<th width="30%" colspan="2">POD</th>
								<th width="30%" colspan="2">DEL</th>
								<th>Trans Mode</th>
					   		</tr>
					   		<tr>
								<td width="20%" class="input2"><input type="text" id="pod_cd" name="pod_cd" style="width:100%;" class="noinput2" value="" readonly></td>
								<td width="10%" class="input2"><input type="text" id="pod_nod_cd" name="pod_nod_cd" style="width:100%;" class="noinput2" value="" readonly></td>
								<td width="20%" class="input2"><input type="text" id="del_cd" name="del_cd" style="width:100%;" class="noinput2" value="" readonly></td>
								<td width="10%" class="input2"><input type="text" id="del_nod_cd" name="del_nod_cd" style="width:100%;" class="noinput2" value="" readonly></td>
								<td><script language="javascript">ComComboObject('dest_trns_mod_cd', 2, 145, 1, 0, 0)</script></td>
					   		</tr>
						</tbody>
					</table>
				</div>
			</div>
				
		</div>
		
		<div class="opus_design_grid" style="display:none">
			<script language="javascript">ComSheetObject('sheet2');</script>
		</div>
	</div>
	
</div>

</form>			