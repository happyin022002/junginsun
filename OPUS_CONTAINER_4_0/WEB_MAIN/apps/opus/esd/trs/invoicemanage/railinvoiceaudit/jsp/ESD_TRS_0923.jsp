<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESD_TRS_0923.jsp
*@FileTitle  : USA Rail Invoice File Import
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.event.EsdTrs0923Event"%>
<%
	EsdTrs0923Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Server Exception
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //Error Message
	int rowCount	 = 0;								  
	String userId = "";
	String ofcId = "";
	SignOnUserAccount account = null;

	try {

	   account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   userId=account.getUsr_id();
	   ofcId=account.getOfc_cd();

		event = (EsdTrs0923Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}

	String mode = JSPUtil.getNull(request.getParameter("mode"));

	String inv_no				= JSPUtil.getNull(request.getParameter("inv_no"));
	String rail_road_code		= JSPUtil.getNull(request.getParameter("rail_road_code"));
	String rail_road_name		= JSPUtil.getNull(request.getParameter("rail_road_name"));
	String payment_vndr_code	= JSPUtil.getNull(request.getParameter("payment_vndr_code"));
	String payment_vndr_name	= JSPUtil.getNull(request.getParameter("payment_vndr_name"));
	String receive_dt			= JSPUtil.getNull(request.getParameter("receive_dt"));
	String issue_dt				= JSPUtil.getNull(request.getParameter("issue_dt"));
	String invoice_amt			= JSPUtil.getNull(request.getParameter("invoice_amt"));
	String vat_amt				= JSPUtil.getNull(request.getParameter("vat_amt"));
	String currency				= JSPUtil.getNull(request.getParameter("currency"));
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
</head>


<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="receive_dt" value="<%=receive_dt%>" id="receive_dt" />
<input type="hidden" name="issue_dt" value="<%=issue_dt%>" id="issue_dt" />
<input type="hidden" name="invoice_amt" value="<%=invoice_amt%>" id="invoice_amt" />
<input type="hidden" name="vat_amt" value="<%=vat_amt%>" id="vat_amt" />
<input type="hidden" name="currency" value="<%=currency%>" id="currency" />
<input type="hidden" name="FORM_CRE_USR_ID" value="<%=account.getUsr_id()%>" id="FORM_CRE_USR_ID" />
<input type="hidden" name="FORM_USR_OFC_CD" value="<%=account.getOfc_cd()%>" id="FORM_USR_OFC_CD" />
<input type="hidden" name="mode" value="<%=mode%>" id="mode" />

<div class="layer_popup_title">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><span>USA Rail Invoice File Import</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent" name="btn_apply" id="btn_apply">Apply</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_close"  	id="btn_close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->
</div>
<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table>
				<tbody>
					<tr>
						<th>Invoice No. </th>
						<td><input name="inv_no" value="<%=inv_no%>" type="text" style="width:285px;" readonly class="input2" id="inv_no" /></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<th>Rail Road</th>
						<td><!-- 
							 --><input name="rail_road_code" type="text" style="width:100px;" value="<%=rail_road_code%>" readonly="" class="input2" id="rail_road_code" /><!-- 
							 --><input name="rail_road_name" type="text" style="width:180px;" value="<%=rail_road_name%>" readonly="" class="input2" id="rail_road_name" />
						<th>Payment Vendor</th>
						<td><!-- 
							 --><input name="payment_vndr_code" type="text" style="width:100px;" value="<%=payment_vndr_code%>" readonly="" class="input2" id="payment_vndr_code" /><!-- 
							 --><input name="payment_vndr_name" type="text" style="width:220px;" value="<%=payment_vndr_name%>" readonly="" class="input2" id="payment_vndr_name" />
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
		
	</div>
	
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">
			<div class="opus_design_btn"><!-- 
				 --><button type="button" class="btn_accent" name="btng_select" id="btng_select">Select</button><!-- 
				 --><button type="button" class="btn_normal" name="btng_verify"  	id="btng_verify">Verify</button>
			</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(S) -->
	</div>
</div>

</form>