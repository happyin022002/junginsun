<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ui_bkg_1017.jsp
*@FileTitle : Rocs BL ADD Pop-Up
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
 
Exception serverException   = null;			// error from server
String strErrMsg = "";						// error message
int rowCount	 = 0;						// count of DB resultSET list

String successFlag = "";
String codeList  = "";
String pageRows  = "100";

String strUsr_id		= "";
String strUsr_nm		= "";
String ofc_cd           = "";
String bkg_no= "";
String frm_crn_number= ""; 
Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

try {
   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
   	
   	bkg_no = request.getParameter("bkg_no")==null?"":request.getParameter("bkg_no");
   	frm_crn_number = request.getParameter("frm_crn_number")==null?"":request.getParameter("frm_crn_number");
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
		
	}
</script>

<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="f_flag" value ="SEARCH">
<input type="hidden" name="pagerows">
<input type="hidden" name="vsl_cd"> 
<input type="hidden" name="skd_voy_no"> 
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="mt_flag">
<input type="hidden" name="pol_cd">
<input type="hidden" name="cntr_no">  
<input type="hidden" name="pg_no" value="esm1017">
<input type="hidden" name="dif_chr">
<input type="hidden" name="bkg_no" value="<%=StringUtil.xssFilter(bkg_no)%>">
<input type="hidden" name="crn_number" value ="<%=StringUtil.xssFilter(frm_crn_number)%>">
<input type="hidden" name="etc_bkg_no">
<input type="hidden" name="user_id" value ="<%=strUsr_id%>">

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span> B/L Add</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_new" id="btn_new">Creation</button>
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
				<col width="50px" />				
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>B/L No.</th>
					<td>
						<input type="text" maxlength="12" class="input" dataformat="engup" style="ime-mode: disabled" name = "bl_no" value="">
					</td>									
				</tr>				
			</tbody>
		</table>
	</div>
	
	<!-- 시트영역 -->
	<div class="opus_design_grid" style="display:none">		
		<script language="javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- 시트영역 -->

</div>


</form>
