<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_1074.jsp
*@FileTitle  : Internet O.B/L Print Authorize 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/10/13
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg1074Event"%>

<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg1074Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = "";				//error message
	int rowCount	 = 0;				//count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";
	Logger log = Logger.getLogger("com.clt.apps.OutboundBLMgt.BLIssuance");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		event = (EsmBkg1074Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<script language="javascript" type="text/javascript" src="/opuscntr/syscommon/common/fckeditor/ckeditor.js"></script>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd"								id="f_cmd" /> 
<input type="hidden" name="pagerows"							id="pagerows" /> 
<input type="hidden" name="strUsr_id" value="<%=strUsr_id%>"	id="strUsr_id" /> 
<input type="hidden" name="strOfc_cd" value="<%=strOfc_cd%>"	id="strOfc_cd" /> 

<!-- OUTER - POPUP (S)tart -->
<input type="hidden" name="bkg_no" value='<%=JSPUtil.getParameter(request, "bkg_no")%>'	id="bkg_no" /> 
<input type="hidden" name="bl_no" value='<%=JSPUtil.getParameter(request, "bl_no")%>'	id="bl_no" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->

	<h2 class="page_title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Internet O.B/L Print Authorize</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Authorize" id="btn_Authorize">Authorize</button><!--
		--><button type="button" class="btn_accent" name="btn_Email" id="btn_Email">E-mail</button><!--
		--><button type="button" class="btn_accent" name="btn_close" id="btn_close">Close</button><!--
	 --></div>
	<!-- opus_design_btn(E) -->
</div>
<!-- page_title_area(E) -->

<!-- wrap_search(S) -->
<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
	
		<table class="sm" border=1>
			<tbody>
				<colgroup>
					<col width="60"></col>
					<col width="90"></col>
					<col width="250"></col>
					<col ></col>
				</colgroup>
				<tbody>
					<tr>
						<th class="tr2_head">SHPR</th>
						<td><input type="text" style="width: 80px;" class="input2"  name="shpr_cd" id="shpr_cd" value="" readonly></td>
						<td><input type="text" style="width: 250px;" class="input2"  name="shpr_nm" id="shpr_nm" value="" readonly></td>
						<td><img name="pop_shpr" id="pop_shpr" src="img/btns_search.gif" width="19px" height="20px" alt="" border="0" class="cursor"></td>
					</tr> 
					<tr>
						<th class="tr2_head">FWDR</th>
						<td><input type="text" style="width: 80px;" class="input2"  name="fwdr_cd" id="fwdr_cd" value="" readonly></td>
						<td><input type="text" style="width: 250px;" class="input2"  name="fwdr_nm" id="fwdr_nm" value="" readonly></td>
						<td><img name="pop_fwdr" id="pop_fwdr" src="img/btns_search.gif" width="19px" height="20px" alt="" border="0" class="cursor"></td>
					</tr> 
				</tbody>
		</table>
	</div>
</div>
<table class="line_bluedot"><tr><td></td></tr></table>
<!-- wrap_search(E) -->
<!-- wrap_result(S) -->
<div class="wrap_result">
		
		<!-- 1ST TO (S) -->
		<div class="opus_design_inquiry">
			<table class="sm"  border=1>
				<tbody>
					<colgroup>
						<col width="60"></col>
						<col ></col>
					</colgroup>
					<tr>
						<th class="tr2_head">To</th>
						<td><input type="text" style="width: 100%;" class="noinput" name="email_to" id="email_to" value=""></td>
					</tr> 
				</tbody>
			</table>
		</div>
		<!-- 1ST TO (E) -->
	
	
		<!-- 2ND (S) -->
		<div class="opus_design_inquiry">
			<table class="sm"  border=1>
				<tbody>
					<colgroup>
						<col width="60"></col>
						<col ></col>
					</colgroup>
					<tr>
						<th class="tr2_head" >Subject</th>
						<!-- 
						<td><input type="text" style="width: 100%;" class="noinput" name="email_subject" id="email_subject" value=" OPUS Shipping B/L Print Ready Notice (B/L No. : <%=JSPUtil.getParameter(request, "bl_no")%> )"></td>
						 -->
						<td><input type="text" style="width: 100%;" class="noinput" name="email_subject" id="email_subject" value=""></td>
					</tr> 
				</tbody>
				<tbody>
					<colgroup>
						<col width="60"></col>
						<col ></col>
					</colgroup>
					<tr>
						<th class="tr2_head" >Contents</th>
						<td>
<!-- 
<textarea class="ckeditor" name="email_contents">
Dear Customer
<br>
Your Bill(s) of Lading below is (are) ready to be printed on the OPUS Shipping Website.
<br>
B/L No
<br>
-----------------------
<br>
<%=JSPUtil.getParameter(request, "bl_no")%>
<br>
<br>
Please go to http://www.opus.com/eservice/opus/en/bl/oblMainNew.do?certi=Y and login with your digital certificate.
<br>

If you are user of non-certificate service,please go to
<br>
http://www.opus.com/eservice/en/bl/oblMain.do?certi=N and login with your ID, password
<br>
and customer code
<br>
<br>

Thank you
 -->
							<textarea class="ckeditor" name="email_contents">

							</textarea>						
						</td>
					</tr> 
				</tbody>
			</table>
		</div>
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="leftTable" style="display:none"><script type="text/javascript">ComSheetObject('sheet1');</script></div>
	<!-- opus_design_grid(E) -->

		<!-- 2ND (E) -->
</div>
<!-- wrap_result(E) -->

</form>
