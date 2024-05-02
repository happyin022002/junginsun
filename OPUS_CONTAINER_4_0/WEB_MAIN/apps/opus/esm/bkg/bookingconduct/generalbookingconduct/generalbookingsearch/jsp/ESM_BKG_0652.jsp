<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0652.jsp
*@FileTitle  : Customer Inquiry
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
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0652Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0652Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from the server	
	String strErrMsg = "";						//error messege

	String strUsr_id		= "";
	String strUsr_nm		= "";
	//get Parameter from main
	String calllFunc = "";
	String bkgCustTpCd = "";
	String custCntCd = "";
	String custSeq = "";
	String custNm = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg0652Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		calllFunc  = JSPUtil.getParameter(request, "func");
		bkgCustTpCd  = JSPUtil.getParameter(request, "bkg_cust_tp_cd");		
		custCntCd  = JSPUtil.getParameter(request, "cust_cnt_cd");
		custSeq  = JSPUtil.getParameter(request, "cust_seq");
		custNm = JSPUtil.getParameter(request, "cust_nm");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script  type="text/javascript">
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
<input type="hidden" name="calllFunc" value="<%=calllFunc%>">
<input type="hidden" name="bkgCustTpCd" value="<%=bkgCustTpCd%>">

<!-- popup_title_area(S) -->
	<!-- page_title_area(S) -->
	<div class="layer_popup_title">
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Customer Inquiry</span></h2>
		<!-- page_title(E) -->			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
			--><button type="button" class="btn_normal" name="btn_Select" id="btn_Select">Select</button><!-- 
			--><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!-- 
			--><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!-- 
		   --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	</div>
	<!-- page_title_area(E) -->
<!-- popup_title_area(E) -->
<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
	<div class= "wrap_search">
		<!-- inquiry_area(S) -->
		<div class="opus_design_inquiry wFit">
			<table> 
				<colgroup>
					<col width="50" />
					<col width="100" />
					<col width="55" />
					<col width="350" />
					<col width="80" />
					<col width="80" />
				</colgroup>
				<tbody>
					<tr>
						<th>Code</th>
						<td><input type="text" name="cust_cnt_cd" id="cust_cnt_cd" size="2" style="text-align:center;" class="input1" value="<%=custCntCd %>" style="ime-mode:disabled"  maxlength=2 dataformat="enguponly"><!-- 
						 --><input type="text" name="cust_seq" id="cust_seq" size="6" style="text-align:center;" class="input" value="<%=custSeq %>" style="ime-mode:disabled"  maxlength=6 dataformat="num"></td>			
						<th>Name</th>
						<td><input type="text" name="cust_nm" id="cust_nm" style="width:340px;" class="input" style="ime-mode:disabled" value="<%=custNm %>" dataformat="engup" otherchar="!@#$%^&*()? ][{}=+-"></td>
						<th>Location</th>
						<td><input type="text" name="loc_cd" id="loc_cd" style="width:80px;" class="input" style="ime-mode:disabled"" maxlength=5 dataformat="enguponly"></td>				
						<th>S. OFC</th>
						<td><input type="text" name="ofc_cd" id="ofc_cd" style="width:80px;" class="input" style="ime-mode:disabled" dataformat="enguponly"></td>				
					</tr> 
				</tbody>
			</table>
		</div>
	</div>
	<div class="wrap_result">
		<div class="layout_wrap">
		    <div class="layout_vertical_2"  style="width:70%">
		        <!-- opus_design_grid(S) -->
		        <div class="opus_design_grid">
		            <script  type="text/javascript">ComSheetObject('sheet1');</script>
		        </div>
		        <!-- opus_design_grid(E) -->
		    </div>
		    <div class="layout_vertical_2 pad_left_12" style="width:30%">
		        <!-- opus_design_grid(S) -->
		        <div class="opus_design_grid">
		            <script  type="text/javascript">ComSheetObject('sheet2');</script>
		        </div>
		        <!-- opus_design_grid(E) -->
		    </div>
		</div>
		<!-- opus_design_grid(S) -->
		<div class="layout_wrap">
		<div class="opus_design_grid" >
			<br>
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_Add" id="btn_Add">Row Add</button>
				<button type="button" class="btn_accent" name="btn_Delete" id="btn_Delete">Row Delete</button>
			</div>
			<script  type="text/javascript">ComSheetObject('sheet3');</script>
		</div>
		</div>
	</div>
	</div>
</form>