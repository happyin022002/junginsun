<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0179.jsp
*@FileTitle  : BL Clause Remark Pop-up
*@author     : CLT
*@version    : 1.0
*@since      : 2015/03/19
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg0179Event"%>	
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0179Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; 	//error from server
	String strErrMsg = ""; 				//error message
	int rowCount = 0; 					//DB ResultSet List count

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	
	String bkgNo  = ""; 
	String porCd  = ""; 
	String polCd  = ""; 
	String podCd  = ""; 
	String delCd  = ""; 
	String custFunc = ""; 
			
	boolean bBtn_Disabled = true;
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0179Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}
		bkgNo  = JSPUtil.getNull(request.getParameter("bkg_no"));
		porCd  = JSPUtil.getNull(request.getParameter("por_cd"));
		polCd  = JSPUtil.getNull(request.getParameter("pol_cd"));
		podCd  = JSPUtil.getNull(request.getParameter("pod_cd"));
		delCd  = JSPUtil.getNull(request.getParameter("del_cd"));
		custFunc = JSPUtil.getNull(request.getParameter("func"));	  

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	if(!opener) opener = window.dialogArguments;
	if(!opener) opener=parent;
	<%		
		if(!custFunc.equals("")) {%>
			var callbackMethod = opener.<%= custFunc%>;
	<%	} else{	%>
			var callbackMethod = null; 
	<%	}%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="bkg_no" id="bkg_no" value="<%=bkgNo%>"/>
<input type="hidden" name="por_cd" id="por_cd" value="<%=porCd%>"/>
<input type="hidden" name="pol_cd" id="pol_cd" value="<%=polCd%>"/>
<input type="hidden" name="pod_cd" id="pod_cd" value="<%=podCd%>"/>
<input type="hidden" name="del_cd" id="del_cd" value="<%=delCd%>"/>
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>BL Clause Remark Pop-up</span></h2>
		<div class="opus_design_btn"><!--
		--><button type="button" class="btn_accent" name="btn_Apply" id="btn_Apply">Apply</button><!--
		--><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_result">
		<div class="opus_design_inquiry">
			<table class="grid_2">
				<colgroup>
					<col width="80" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th style="text-align:center;">Standard Clause</th> 
						<td><textarea  style="width:90%;height:80px;resize:none;" name="std" id="std" dataformat="engup" otherchar="<%=getSpecialChars()%>" onpaste="javascript:mousePaste(this)"  ></textarea></td>
					</tr>
					<tr>
						<th style="text-align:center;">Country Clause</th> 
						<td><textarea  style="width:90%;height:80px;resize:none;" name="cnt" id="cnt" dataformat="engup" otherchar="<%=getSpecialChars()%>" onpaste="javascript:mousePaste(this)"  ></textarea></td>
					</tr>
					<tr>
						<th style="text-align:center;">Customer Clause</th> 
						<td><textarea  style="width:90%;height:80px;resize:none;" name="cus" id="cus" dataformat="engup" otherchar="<%=getSpecialChars()%>" onpaste="javascript:mousePaste(this)" ></textarea></td>
					</tr>
				</tbody>
			</table>
			<table class="grid">
				<colgroup>
					<col width="80" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th style="text-align:center;">Remark</th> 
						<td><textarea  style="width:90%;height:80px;resize:none;" name="rmk" id="rmk" onkeyup="javascript:checkUpdate(this)" onpaste="javascript:mousePaste(this)" ></textarea></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="opus_design_grid"  style="display:none">
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
 	 </div>
</div>

</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>

<%!

	public String getSpecialChars() {
		return " ~!@#$%^&*()`_+-={}|[]\\\"\\':;,./?"; 
	}
		
%>