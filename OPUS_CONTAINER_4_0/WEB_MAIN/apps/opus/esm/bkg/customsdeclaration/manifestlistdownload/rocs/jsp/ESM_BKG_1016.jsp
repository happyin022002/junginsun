<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ui_bkg_1016.jsp
*@FileTitle : Rocs Commodity Amend Pop-up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/13
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
 
Exception serverException   = null;			//서버에서 발생한 에러
String strErrMsg = "";						//에러메세지
int rowCount	 = 0;						//DB ResultSet 리스트의 건수

String successFlag = "";
String codeList  = "";
String pageRows  = "100";

String strUsr_id		= "";
String strUsr_nm		= "";
String ofc_cd           = "";

String pck_desc= "";
Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

try {
   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
   	
   	pck_desc = request.getParameter("pck_desc")==null?"":request.getParameter("pck_desc");   	
	 
   	pck_desc = pck_desc.replaceAll("<br>","\r\n");
   	 
     
	strUsr_id =	account.getUsr_id();
	ofc_cd    = account.getOfc_cd();  
	strUsr_nm = account.getUsr_nm();

	//event = (EsmBkg0440Event)request.getAttribute("Event");
	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

	if (serverException != null) {
		strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	}


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
		document.getElementById("title").innerHTML = " Rocs Commodity Amend";
	}
	 
</script>

<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="f_flag" value ="SEARCH">
<input type="hidden" name="pagerows">

<input type="hidden" name="user_id" value ="<%=strUsr_id%>">

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span> Rocs Commodity Amend</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">

	<div class="opus_design_inquiry">   <!-- no TAB  -->
		<table> 
			<colgroup>
				<col width="260px" />				
			</colgroup>
			<tbody>
				<tr>					
					<td>
						<textarea  name="frm_pck_desc" style="width:260px"  rows="10"><%=StringUtil.xssFilter(pck_desc)%></textarea>
					</td>								
				</tr>
			</tbody>
		</table>
	</div>

</div>
			
</form>			
