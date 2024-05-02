<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VOP_VSK_0210.jsp
*@FileTitle : Country Code Help
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/12
=========================================================*/
%>
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
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script language="javascript">
function setupPage(){  
	loadPage();
}
</script>

<form name="form">
<input type="hidden" name="f_cmd">

<input type="hidden" name="srcdate" value='<%=StringUtil.xssFilter(request.getParameter("srcdate")) %>'>
<input type="hidden" name="port" value='<%=StringUtil.xssFilter(request.getParameter("port")) %>'>
<input type="hidden" name="est" value='<%=StringUtil.xssFilter(request.getParameter("est")) %>'>
<input type='hidden' name='oldday' dataformat='ymd'>
<input type='hidden' name='oldtime' dataformat='hm'>

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Schedule Modify Help</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_ok" id="btn_ok">OK</button><!--
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table> 
				<tbody>
					<tr>
						<th width="40">PORT</th>
						<td><input type="text" class="input2" style="width:50px;text-align:center"  tabindex="-1" value="<%=StringUtil.xssFilter(request.getParameter("port")) %>" readonly></td>
					</tr>
					<tr>
						<th><%=StringUtil.xssFilter(request.getParameter("est"))%></th>
						<td>
							<input type='text' name='src_day' caption='날짜' dataformat='ymd'  style='width:80px;text-align:center' class='input'  maxlength="8" size="10" tabindex="1"><!--
							--><button type="button" class="calendar" name="btn_cal" id="btn_cal"></button><!--
							--><input type='text' name='src_time' caption='시간' dataformat='hm' style='width:40px;' class='input' maxlength="4" size="5" tabindex="2">
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

</form>			