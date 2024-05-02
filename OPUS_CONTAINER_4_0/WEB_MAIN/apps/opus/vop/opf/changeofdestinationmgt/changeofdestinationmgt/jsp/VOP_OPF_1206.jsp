<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_1206.jsp
*@FileTitle  : Reject Reason Remarks
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.event.VopOpf1206Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopOpf1206Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strIsPop			= "";
	Logger log = Logger.getLogger("com.clt.apps.ChangeOfDestinationMgt.ChangeOfDestinationMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (VopOpf1206Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		strIsPop = event.getIsPop();

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="isPop" value="<%=strIsPop%>">
<input type="hidden" name="codRemark">
<!-- Developer Performance	-->
<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span><%if (strIsPop.equals("C")){%>COD Remark<%}else if(strIsPop.equals("R")){%>Reject Reason Remark(s)<%}else if(strIsPop.equals("Q")){%>Quantity List <font color='blue'>(* means original POD)</font><%}%></span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
		<%if (strIsPop.equals("R") || strIsPop.equals("C")){%>
			<button type="button" class="btn_accent" name="btn_save" id="btn_save">Save</button>
		<%}%>	
			<button type="button" class="btn_accent" name="btn_close" id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
<div class="wrap_result">
		<div class="opus_design_inquiry">		
			<table class="search" border="0" style="width:100%;"> 
				<tr>
					<td width="100%" align="center"><textarea style="width:98%" rows="7" class="textarea2" name="rejectRmk" <%if (!strIsPop.equals("R") && !strIsPop.equals("C")){%>readonly<%}%>><%=StringUtil.xssFilter(request.getParameter("rejectRmk"))%></textarea></td>
				</tr>
			</table>
		</div>
</div>
</div>
<div style="height:0;width:0"><script type="text/javascript">ComSheetObject('sheet1');</script></div>
<!-- Developer Performance  end -->
</form>
