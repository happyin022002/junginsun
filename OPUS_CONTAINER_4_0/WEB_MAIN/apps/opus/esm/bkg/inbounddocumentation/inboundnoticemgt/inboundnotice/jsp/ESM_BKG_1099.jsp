<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1099.jsp
*@FileTitle  : Integrated Customer Data Update Setup Pop-up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<%

	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";
	Logger log = Logger.getLogger("com.clt.apps.InboundBlMgt.PickUpNotice");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = JSPUtil.getNull(request.getParameter("ofc_cd"));

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>Integrated Customer Data Update Setup</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Ok" 					id="btn_Ok">Ok</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Close" 			id="btn_Close">Close</button>		
	</div>
	<!-- opus_design_btn(E) -->
	
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>				
				<col width="100"/>
				<col width="*" />				
			</colgroup> 
			<tbody>
				<tr>
                    <th>Office</th>
                    <td>
                        <input type="text" style="width:65px;text-align:left;ime-mode:disabled;" class="input1" name="ofc_cd" 
                               caption="Office" value="<%=strOfc_cd%>" readonly/>
                    </td>
                </tr>
                <tr>
                    <th>Auto Update</th>
                    <td>
                         <select style="width:65px;" name="auto_upd_flg" onKeyDown="ComKeyEnter(this)">
                                        <option value="Y" selected>Yes</option>
                                        <option value="N" >No</option>
                         </select>
                    </td>
                </tr>
                <tr>
                  <th style="height:25px;">Last updated by</th>
                  <td><a><font color="blue"><span id="upd_usr_id"></span></font></a></td>
                </tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">	
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer" style="display:none">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	
</div>

</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>