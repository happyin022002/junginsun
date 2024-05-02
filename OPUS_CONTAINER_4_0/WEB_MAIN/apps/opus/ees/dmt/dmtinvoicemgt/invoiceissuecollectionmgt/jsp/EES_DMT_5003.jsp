<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_5003.jsp
*@FileTitle  : Invoice Interface to A/R - Detail
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt5003Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt5003Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	String strCnt_cd 		= "";

	//Parameter
	String ofc_cd		= "";
	String dmdt_trf_cd	= "";
	String chk_hold		= "";
	String cond_type	= "";
	String fm_dt		= "";
	String to_dt		= "";
	String inv_no		= "";
	String bkg_no		= "";
	String bl_no		= "";
	String sh_cust_cd	= "";
	String sh_cust_nm	= "";
	String sh_inv_curr_cd = "";
	String hold_auth	= "";
	Logger log = Logger.getLogger("com.clt.apps.DMTInvoiceMgt.invoiceissuecollectionmgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		strCnt_cd = account.getCnt_cd();


		event = (EesDmt5003Event)request.getAttribute("Event");		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// in loading page, Get data from server.
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		ofc_cd		= JSPUtil.getParameter(request,"ofc_cd");
		dmdt_trf_cd	= JSPUtil.getParameter(request,"dmdt_trf_cd");
		chk_hold	= JSPUtil.getParameter(request,"chk_hold");
		cond_type	= JSPUtil.getParameter(request,"cond_type");
		fm_dt		= JSPUtil.getParameter(request,"fm_dt").replaceAll("-","");
		to_dt		= JSPUtil.getParameter(request,"to_dt").replaceAll("-","");
		inv_no		= JSPUtil.getParameter(request,"inv_no");
		bkg_no		= JSPUtil.getParameter(request,"bkg_no");
		bl_no		= JSPUtil.getParameter(request,"bl_no");
		sh_cust_cd	= JSPUtil.getParameter(request,"sh_cust_cd");
		sh_cust_nm	= JSPUtil.getParameter(request,"sh_cust_nm");
		sh_inv_curr_cd	= JSPUtil.getParameter(request,"sh_inv_curr_cd");
		hold_auth	= JSPUtil.getParameter(request,"hold_auth");



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
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="usr_ofc_cd" value="<%=strUsr_ofc%>" id="usr_ofc_cd" />

<input type="hidden" name="ofc_cd" value="<%=ofc_cd%>" id="ofc_cd" />
<input type="hidden" name="dmdt_trf_cd" value="<%=dmdt_trf_cd%>" id="dmdt_trf_cd" />
<input type="hidden" name="chk_hold" value="<%=chk_hold%>" id="chk_hold" />
<input type="hidden" name="cond_type" value="<%=cond_type%>" id="cond_type" />
<input type="hidden" name="fm_dt" value="<%=fm_dt%>" id="fm_dt" />
<input type="hidden" name="to_dt" value="<%=to_dt%>" id="to_dt" />
<input type="hidden" name="inv_no" value="<%=inv_no%>" id="inv_no" />
<input type="hidden" name="bkg_no" value="<%=bkg_no%>" id="bkg_no" />
<input type="hidden" name="bl_no" value="<%=bl_no%>" id="bl_no" />
<input type="hidden" name="sh_cust_cd" value="<%=sh_cust_cd%>" id="sh_cust_cd" />
<input type="hidden" name="sh_cust_nm" value="<%=sh_cust_nm%>" id="sh_cust_nm" />
<input type="hidden" name="sh_inv_curr_cd" value="<%=sh_inv_curr_cd%>" id="sh_inv_curr_cd" />

<input type="hidden" name="hold_auth" value="" id="hold_auth" />

<input type="hidden" name="success_yn" value="" id="success_yn" />

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Invoice Interface to A/R - Detail</span></h2>
		<!-- page_title(E) -->

		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn"><!-- 
			--><button type="button" class="btn_accent" name="btn_arif" id="btn_arif">A/R I/F</button><!-- 
			<%if(hold_auth.equals("Y")){%>--><button type="button" class="btn_normal" name="btn_hold" id="btn_hold">A/R I/F</button><!--<% } %>
			--><button type="button" class="btn_normal" name="btn_detail" id="btn_detail">Detail</button><!-- 
			--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!-- 
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button><!-- 
		 --></div>
		<!-- opus_design_btn(E) -->		
	</div>
	<!-- page_title_area(E) -->


	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">  <!-- no TAB  -->
			<table> 
				<colgroup>
					<col width="42" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Payer</th>
						<td><input type="text" style="width:70px;" class="input2" value="<%=sh_cust_cd %>" readonly /><!--  
						 --><input type="text" style="width:500px;;" class="input2" value="<%=sh_cust_nm %>" readonly="" /></td>
					</tr>
				</tbody>
			</table>			
		</div>
	</div>			
	<div class="wrap_result">	
		<div class="opus_design_grid" id="mainTable2"  >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
			<br/><h3 class="title_design">Selected Total</h3><br/>
			<table> 
				<colgroup>
					<col width="60" />
					<col width="90" />
					<col width="70" />
					<col width="200" />
					<col width="60" />
					<col width="200" />
					<col width="80" />
					<col width="*" />
				</colgroup>
				<tbody>
				<tr>
						<th>INV Q’ty</th>
						<td><input type="text" name="inv_qty" style="width:60px;;" class="input2" value="" readonly id="inv_qty" /> </td>
						<th>Billing AMT</th>
						<td><input type="text" name="inv_chg_amt" style="width:150px;text-align:right" class="input2" value="" readonly id="inv_chg_amt" /> </td>
						<th>Tax AMT</th>
						<td><input type="text" name="tax_amt" style="width:150px;text-align:right" class="input2" value="" readonly id="tax_amt" /> </td>
						<th>Payable AMT</th>
						<td><input type="text" name="inv_amt" style="width:100px;%;text-align:right" class="input2" value="" readonly id="inv_amt" /> </td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>	


</form>