<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0092.jsp 
*@FileTitle  : Route Detail
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg0092Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0092Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message

	String strUsr_id		= "";
	String strUsr_nm		= "";

	String bkgNo = "";
	String calllFunc = "";
	String caFlg = "";
	String callSheetIdx = "";
	String bkgTrunkVvd = "";
	String displayOnly = "";
	String podClptIndSeq = "";
	String polClptIndSeq = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0092Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// get data from server when load page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		bkgNo  = JSPUtil.getParameter(request, "bkg_no");
		caFlg  = JSPUtil.getParameter(request, "ca_flg");
		calllFunc  = JSPUtil.getParameter(request, "func");
		callSheetIdx  = JSPUtil.getParameter(request, "callSheetIdx");
		bkgTrunkVvd  = JSPUtil.getParameter(request, "bkgTrunkVvd");
		displayOnly  = JSPUtil.getParameter(request, "displayOnly");
		podClptIndSeq  = JSPUtil.getParameter(request, "pod_clpt_ind_seq");
		polClptIndSeq = JSPUtil.getParameter(request, "pol_clpt_ind_seq");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">

	var pod_clpt_ind_seq_temp = "<%=podClptIndSeq%>";
	var pol_clpt_ind_seq_temp = "<%=polClptIndSeq%>";
	
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
<input type="hidden" name="bkg_no" value="<%= bkgNo%>">
<input type="hidden" name="ca_flg" value="<%= caFlg%>">
<input type="hidden" name="calllFunc" value="<%=calllFunc%>">
<input type="hidden" name="callSheetIdx" value="<%=callSheetIdx%>">
<input type="hidden" name="bkgTrunkVvd" value="<%=bkgTrunkVvd%>">
<input type="hidden" name="trunkSeq" value="0">
<input type="hidden" name="displayOnly" value="<%=displayOnly%>">
<input type="hidden" name="st_pod_clpt_ind_seq" >
<input type="hidden" name="st_pol_clpt_ind_seq" >
<!-- OUTER - POPUP (S)tart -->

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Route Detail</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!--
			--><button type="button" class="btn_accent" name="btn_Save" id="btn_Save">OK</button><!--
			--><button type="button" class="btn_normal" name="btn_Clear" id="btn_Clear">Clear</button><!--
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry">
			<table> 
				<colgroup>
					<col width="100px" />
					<col width="80px"/>
					<col width="100px" />
					<col width=""/>
				</colgroup>
				<tbody>
					<tr>
						<td colspan="4">
							<h3 class="title_design">OCEAN ROUTE</h3>
						</td>
					</tr>
					<tr>
						<th>ETA of 1st VVD</th>
						<td><input type="text" name="n1st_eta_day" style="width:75px;" class="input2" readonly><!--
						--><input type="text" name="n1st_eta_time" style="width:45px;" class="input2" readonly></td>
						<th>ETA of DEL</th>
						<td><input type="text" name="del_eta_day" style="width:75px;" class="input2" readonly><!--
						--><input type="text" name="del_eta_time" style="width:45px;" class="input2" readonly></td>
					</tr>
				</tbody>
			</table>
		</div>	
	</div>
	
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" >
			<div class="opus_design_grid">
				<div class="opus_design_btn"><!--
				--><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--
				--><button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button><!--
				--><button type="button" class="btn_normal" name="btn_Delete" id="btn_Delete">Row Delete</button>
				</div>
			</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
			<h3> <input type="checkbox" name="mnl_tvvd_flg" value="N" class="trans" id="mnl_tvvd_flg"><label for="mnl_tvvd_flg"> T.VVD copy from BKG creation</label></h3>
			<table class="line_bluedot"><tr><td></td></tr></table>
		</div>
		<!-- opus_design_grid(E) -->
		<!-- layout_wrap(S) -->
		<div class="layout_wrap">
		    <div class="layout_vertical_2 pad_rgt_4">
		    	<h3 class="title_design">ORIGIN INLAND ROUTE</h3>
		        <div class="opus_design_grid">
					<table  class="grid2"> 
						<tbody>
							<tr>
								<th colspan="2">POR</th>
								<th colspan="2">POL</th>
								<th>Trans Mode</th>
							</tr>
			   				<tr>
								<td><input type="text" name="por_loc_cd" style="width:50px" readonly></td>
								<td><input type="text" name="por_nod_cd" style="width:30px;" readonly></td>
								<td><input type="text" name="pol_loc_cd" style="width:50px;" readonly></td>
								<td><input type="text" name="pol_nod_cd" style="width:30px;" readonly></td>
								<td><script type="text/javascript" >ComComboObject('combo1', 2, 110, 1, 0, 1)</script></td>
							</tr>
						</tbody>
					</table>
		        </div>
		    </div>
		    <div class="layout_vertical_2 pad_left_4">
		    	<h3 class="title_design">DESTINATION INLAND ROUTE</h3>
		        <div class="opus_design_grid">
					<table class="grid2"> 
						<tbody>
							<tr>
								<th colspan="2">POD</th>
								<th colspan="2">DEL</th>
								<th>Trans Mode</th>
							</tr>
							<tr>
								<td><input type="text" name="pod_loc_cd" style="width:50px;" readonly></td>
								<td><input type="text" name="pod_nod_cd" style="width:30px;" readonly></td>
								<td><input type="text" name="del_loc_cd" style="width:50px;" readonly></td>
								<td><input type="text" name="del_nod_cd" style="width:30px;" readonly></td>
								<td><script type="text/javascript" >ComComboObject('combo2', 2, 100, 1, 0, 1)</script></td>
							</tr>
						</tbody>
					</table>
		        </div>
		    </div>
		    
		</div>
		<!-- layout_wrap(E) -->
		
    	<input type="text" name="us_west_coast" class="mar_top_12" style="width:100%;" class="noinput2" readonly />
	</div>
</div>

<!-- : ( Button : pop ) (E) -->
</form>