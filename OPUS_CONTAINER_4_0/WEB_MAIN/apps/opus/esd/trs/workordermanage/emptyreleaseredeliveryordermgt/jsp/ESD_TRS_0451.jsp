<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0451.jsp
*@FileTitle  : Release/Re-delivery Order
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/29
=========================================================*/ 
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.config.SiteConfigFactory"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>

<%
  Exception serverException = null;
  String strErrMsg = "";
  String successFlag = "";
  String strUsr_id = "";
  String strUsr_nm = "";
  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
  } catch(Exception e) {
    out.println(e.toString());
  }
%>

<script language="javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script language="javascript">
  function setupPage(){
    var errMessage = "<%=strErrMsg%>";
    if (errMessage.length >= 1) {
      ComShowMessage(errMessage);
    }
    loadPage();
  }
</script>

<form method="post" name="form" onSubmit="return false;">
	<input type="hidden" name="f_cmd"> 
	<input type="hidden" name="unload_flag" value="reset">
	<div class="layer_popup_title">
		<div class="page_title_area clear">
			<h2 class="page_title">
				<span>Release/Re-delivery Order</span>
			</h2>
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_confirm" id="btn_confirm">Confirm</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
			</div>
		</div>
	</div>
	<!-- popup_title_area(E) -->
	<!-- popup_contens_area(S) -->
	<div class="layer_popup_contents">
		<div class="wrap_search">
			<div class="opus_design_inquiry wFit">
				<table>
					<colgroup>
						<col width="100" />
						<col width="" />
					</colgroup>
					<tbody>
						<tr>
							<th>Status</th>
							<td>
								<select style="width: 80px;" class="input" name="issue_flag" id="issue_flag">
									<option value="R" selected>Resend</option>
								</select>
							</td>
						</tr>
						<tr>
							<th>Issue Type</th>
							<td>
								<input type="radio" class="trans" name="issue_type" id="issue_type2" value="E"><label for="issue_type2">E-mail</label>
								<input type="radio" class="trans" name="issue_type" id="issue_type1" value="F" checked><label for="issue_type1">Fax</label>
	                         	<input type="radio" class="trans" name="issue_type" id="issue_type3" value="D"><label for="issue_type3">EDI</label>
	                       </td>
						</tr>
						<tr>
							<th>E-Mail Address</th>
							<td><input type="text" name="eml" id="eml" maxlength="200" style="width: 300px;" /></td>
						</tr>
						<tr>
							<th>Fax Number</th>
							<td><input type="text" name="fax" id="fax" maxlength="200" style="width: 300px;" /></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="wrap_result">
			<div class="opus_design_RD">
				<script type="text/javascript">rdViewerObject();</script>
			</div>
		</div>
	</div>
</form>
