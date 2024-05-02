<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ui_bkg_0044.jsp
*@FileTitle  : ACI_Vessel Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/26
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.event.EsmBkg0044Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0044Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.opus.CustomsDeclarationAncs.AncsManifestListDownload");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0044Event)request.getAttribute("Event");
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
<input type="hidden" name="pagerows">
<input type="hidden" name="frm_attr_ctnt2">

<%
	String vvd   = (request.getParameter("vvd") == null)? "":request.getParameter("vvd");
	String ssrNo = (request.getParameter("ssr_no")== null)?"":request.getParameter("ssr_no");
	String podCd   = (request.getParameter("pod_cd")== null)?"":request.getParameter("pod_cd");
	String eta   = (request.getParameter("eta")== null)?"":request.getParameter("eta");
	String popup   = (request.getParameter("popup")== null)?"":request.getParameter("popup");
%>	

<div class="page_title_area clear ">
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>

	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button>
	</div>

	<div class="location">
		<span id="navigation"></span>
	</div>
</div>
<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table> 
		<tbody>
	         <colgroup>
	            <col width="100"/>
	            <col width="880"/>
	            <col width="*" />
	        </colgroup> 
			<tr>
				<th>VVD</th>
				<td><input type="text" style="width:200px;ime-mode:disabled" class="input1" name="vvd" align="middle" maxlength="9" dataformat="engup" value="<%=vvd %>"></td>
			</tr>
			<tr>
				<th>SSR No</th>
				<td><input type="text" style="width:200px;ime-mode:disabled" name="ssr_no" class="input" align="middle" maxlength="7" dataformat="num" value="<%=ssrNo %>"></td>
			</tr>
			<tr>
				<th>POD</th>
				<td><script language="JavaScript">ComComboObject("pod", 1, 200);</script>
				<input type="hidden" style="width:200px" name="in_pod"  class="input2" readonly="readonly" value="<%=podCd%>">
				</td>
			</tr>
			<tr>
				<th>Call Date (ETA)</th>
				<td><input type="text" style="width:200px" name="eta" class="input2" maxlength="10" dataformat="ymd" readonly="readonly" value="<%=eta %>"></td>
			</tr>
		</tbody>	
		</table>
		<table style="width:330px;"> 
			<tr>
				<td width="300px" border="0" cellpadding="0" cellspacing="0" class="button">
					<button type="button" style="width:100%" class="btn_etc align_left" name="btn_vvdListForSSRCreation" id="btn_vvdListForSSRCreation">
					1. VVD List for SSR Creation</button>
				</td>
			</tr>
			<tr>
				<td width="300px" border="0" cellpadding="0" cellspacing="0" class="button">
					<button type="button" style="width:100%" class="btn_etc align_left" name="btn_ssrViewForCusrep" id="btn_ssrViewForCusrep">
					2. SSR View for CUSREP</button>
				</td>
			</tr>
			<tr><td></td></tr>
			<tr>
				<td width="300px" border="0" cellpadding="0" cellspacing="0" class="button">
					<button type="button" style="width:100%" class="btn_etc align_left" name="btn_blListForCuscar" id="btn_blListForCuscar">
					3. B/L List for CUSCAR</button>
				</td>
			</tr>
			<tr>
				<td width="300px" border="0" cellpadding="0" cellspacing="0" class="button">
					<button type="button" style="width:100%" class="btn_etc align_left" name="btn_blView" id="btn_blView">
					4. Manifest Details by B/L</button>
				</td>
			</tr>
			<tr><td></td></tr>
			<tr>
				<td width="300px" border="0" cellpadding="0" cellspacing="0" class="button">
					<button type="button" style="width:100%" class="btn_etc align_left" name="btn_cusrepHistoryByVvd" id="btn_cusrepHistoryByVvd">
					5. CUSREP History By VVD</button>
				</td>
			</tr>
			<tr>
				<td width="300px" border="0" cellpadding="0" cellspacing="0" class="button">
					<button type="button" style="width:100%" class="btn_etc align_left" name="btn_cuscarHisByBl" id="btn_cuscarHisByBl">
					6. CUSCAR History By B/L</button>
				</td>
			</tr>
			<tr><td></td></tr>
			<tr>
				<td width="300px" border="0" cellpadding="0" cellspacing="0" class="button">
					<button type="button" style="width:100%" class="btn_etc align_left" name="btn_codeValidate" id="btn_codeValidate">
					7. Code Validate</button>
				</td>
			</tr>
			<tr>
				<td width="300px" border="0" cellpadding="0" cellspacing="0" class="button">
					<button type="button" style="width:100%" class="btn_etc align_left" name="btn_notyLetter" id="btn_notyLetter">
					8. Notify Letter</button>
				</td>
			</tr>
			<tr>
				<td width="300px" border="0" cellpadding="0" cellspacing="0" class="button">
					<button type="button" style="width:100%" class="btn_etc align_left" name="btn_interCustomDataMgnt" id="btn_interCustomDataMgnt">
					9. Integrated Customer Data Management</button>
				</td>
			</tr>
		</table>
	</div>
	
	<script type="text/javascript">ComSheetObject('sheet0');</script>
</div>
</form>
			
