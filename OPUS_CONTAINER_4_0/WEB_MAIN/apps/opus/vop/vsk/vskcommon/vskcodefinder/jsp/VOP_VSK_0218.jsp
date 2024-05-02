<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_vsk_0218.jsp
*@FileTitle  : Remark(s) (Pop-Up)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/16
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.event.VskGloEvent"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import = "com.clt.framework.component.util.StringUtil" %> 
<% 
	VskGloEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.vskcommon.vskcodefinder");

	String remarks = "";
	String readOnly = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VskGloEvent)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		remarks = request.getParameter("remarks");
		remarks = (remarks=="-1")?"":remarks;
		remarks = remarks==null?"":remarks;

		readOnly = request.getParameter("readonly");
		readOnly = readOnly==null?"false":readOnly;

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
<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<div class="layer_popup_title">	
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Remark(s)</span></h2>
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_ok"	id="btn_ok">OK</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_close"	id="btn_close">Close</button>
			
	    </div>
	</div>
</div>

<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
<div class="layer_popup_contents" style="overflow:hidden;">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="300" />
		   </colgroup>  
		   <tbody>
		   		<tr>
					<td><textarea  style="width:295px;height:200px;ime-mode:disabled;" name="remarks" id="remarks" <%="true".equals(readOnly)?"readonly":"" %>><%=StringUtil.xssFilter(remarks)%></textarea></td>
		   		</tr>
		   </tbody>
		</table>
	</div>
</div>

<!-- wrap_search(E) -->
</form>
