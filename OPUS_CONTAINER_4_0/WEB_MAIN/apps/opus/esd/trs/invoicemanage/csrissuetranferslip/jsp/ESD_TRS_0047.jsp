<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_TRS_0047.jsp
*@FileTitle  : CSR I/F Status Inquiry  
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/04
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0047Event"%>
<%
	EsdTrs0047Event  event 		= null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Server Exception
	String strErrMsg 			= "";		 	//Error Message
	String ofc_cd = "";
	String userId = "";

	String sToDay 			= DateTime.getFormatString	("yyyyMMdd")	;
	String sFromDay			= DateTime.addDays			(sToDay, -30)	;

	String sFormatToDay		= "";
	String sFormatFromDay	= "";

	if(sToDay.length()   == 8)	sFormatToDay 	= sToDay.substring	(0,4) + "-" + sToDay.substring	(4,6) + "-" + sToDay.substring	(6,8);
	if(sFromDay.length() == 8)	sFormatFromDay	= sFromDay.substring(0,4) + "-" + sFromDay.substring(4,6) + "-" + sFromDay.substring(6,8);

	try {

	   SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   ofc_cd = account.getOfc_cd();
	   userId=account.getUsr_id();

		event = (EsdTrs0047Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

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
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="csr_no" id="csr_no" />
<input type="hidden" name="usr_id" value="<%=userId%>" id="usr_id" />
<input type="hidden" name="aproSeqKey" id="aproSeqKey" />
<input type="hidden" name="apro_step" id="apro_step" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new"  		id="btn_new">New</button>	
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="86px"/>
					<col width="82px"/>
					<col width="32px"/>
					<col width="339px"/>
					<col width="65px"/>
					<col width="157px"/>
					<col width="49px"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>Invoice Office</th>
					<td><input name="cost_ofc_cd" type="text" maxlength=6 style="width:60px" class="input2" value="<%=ofc_cd%>" readonly></td>
					<th>Date</th>
					<td class="sm"><select style="width:165px;" name='dt_status' id='dt_status'><option value="AR">Approval Requested</option><option value="AV">Approved</option><option value="IU">I/F Status Updated</option></select><input name="fm_eff_dt" type="text" style="width:71px" maxlength=10 value="<%=sFormatFromDay%>"  onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this);" onKeyUp="javascript:isNum(this);">&nbsp;~&nbsp;<input name="to_eff_dt" type="text" style="width:71px" maxlength=10 value="<%=sFormatToDay%>"  onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this);" onKeyUp="javascript:isNum(this);"><button type="button" class="calendar ir" id="btns_calendar" name="btns_calendar"></button></td>
					<th>I/F Status</th>
					<td><select style="width:165px;" name='if_status' id='if_status'><!-- 
						 --><option value="AL" selected>All</option><!-- 
						--><option value="DA">Disapproved</option><!-- 
						--><option value="AR">Approval Requested</option><!-- 
						--><option value="IE">I/F Error</option><!-- 
						--><option value="RJ">A/P Rejected</option><!-- 
						--><option value="SC">I/F Success</option><!-- 
						--><option value="PD">Paid</option></select></td>
					<th>CSR No.</th>
					<td><input name="mult_csr_no" type="text" style="width:143px" value="" dataformat="engup" otherchar=","><button type="button" class="multiple_inq ir" name="btns_multisearch" id="btns_multisearch"></button></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" >
		<div class="opus_design_btn"><!--  
		--><!-- <button type="button" class="btn_normal" name="btng_editapprovalstep" 	id="btng_editapprovalstep">Edit Approval Step</button> --><!--
		--><button type="button" class="btn_normal" name="btng_viewapprovalstep" 	id=btng_viewapprovalstep>View Approval Step</button><!--
		--><button type="button" class="btn_normal" name="btng_csrformat" 	id="btng_csrformat">CSR Format</button><!--
		--><button type="button" class="btn_normal" name="btng_invoicelistinquiry" 	id=btng_invoicelistinquiry>Invoice List Inquiry</button><!--
		--><button type="button" class="btn_normal" name="btng_csrcancel" 	id="btng_csrcancel">CSR Cancel</button><!--
		--><button type="button" class="btn_normal" name="btng_downexcel1" 	id="btng_downexcel1">Down Excel</button><!--
		--></div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->
</form>

<DIV style="display:none">
<div class="wrap_result">
	<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
</div>
</DIV>