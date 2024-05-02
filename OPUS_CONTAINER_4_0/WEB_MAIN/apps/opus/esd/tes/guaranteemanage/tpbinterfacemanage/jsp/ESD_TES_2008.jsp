<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_TES_2008.jsp
*@FileTitle  : Guarantee TPB I/F
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/03
=========================================================*/
%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tes.guaranteemanage.tpbinterfacemanage.event.EsdTes2008Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTes2008Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;				//Server Exception
	String strErrMsg = "";							//Error Message
	int rowCount	 = 0;							//DB ResultSet Count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	Logger log = Logger.getLogger("com.clt.apps.GuaranteeManage.TPBInterfaceManage");
	
	String gnte_no	= JSPUtil.getParameter(request, "gnte_no		".trim(), "");
	String curr_cd = JSPUtil.getParameter(request, "curr_cd		".trim(), "");
	String yd_cd = JSPUtil.getParameter(request, "yd_cd		".trim(), "");
	String cntr_seq = JSPUtil.getParameter(request, "cntr_seq		".trim(), "");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		event = (EsdTes2008Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// To initialize the imported data extracted from the server loading 
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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
<input type="hidden" id="gnte_no"	name="gnte_no"			value="<%=gnte_no %>">
<input type="hidden" id="gnte_curr_cd" name="gnte_curr_cd"	value="<%=curr_cd %>">
<input type="hidden" id="yd_cd" name="yd_cd"	value="<%=yd_cd %>">
<input type="hidden" id="cntr_seq" name="cntr_seq"		value="<%=cntr_seq %>">

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>3rd Party Interface</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_ok" id="btn_ok">OK</button><!-- -->
			<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table class="search" border="0" style="width:464;">
				<tr class="h23" align="right">
					<td>Currency</td>
					<td width="65">
						<select id="curr_cd" name="curr_cd">
							<option value="USD">USD</option>
							<option value="CAD">CAD</option>
						</select>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<div class="wrap_result">
		<div class="opus_design_grid" >
			<div class="opus_design_grid">
				<div class="opus_design_btn">
					<button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>
				</div>
			</div>
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>

</form>

