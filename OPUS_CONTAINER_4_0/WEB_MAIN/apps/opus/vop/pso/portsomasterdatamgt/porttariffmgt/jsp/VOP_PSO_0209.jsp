<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_PSO_0209.jsp
*@FileTitle  : Search Formula & Condition ID
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/22
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0209Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopPso0209Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_Ofc_cd      = "";
	
	String strTerminalList = "";
	String strAccountList = "";
	String strObjList = "";
	String formcond = "";
	String caller = "";

	Logger log = Logger.getLogger("com.clt.apps.PortSOMasterDataMgt.PortTariffMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_Ofc_cd = account.getOfc_cd();
	   
		event = (VopPso0209Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		formcond 	= StringUtil.xssFilter(request.getParameter("formcond")) == null 	? "1" : StringUtil.xssFilter(request.getParameter("formcond"));
		caller 		= StringUtil.xssFilter(request.getParameter("caller")) == null 		? ""  : StringUtil.xssFilter(request.getParameter("caller"));

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
//		strTerminalList = eventResponse.getETCData("lane");
//		strAccountList  = eventResponse.getETCData("account");
		strObjList  	= eventResponse.getETCData("objlist");
		
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		TerminalList = "<%=strTerminalList%>";
		AccountList  = "<%=strAccountList%>";
		ObjList      = "<%=strObjList %>";
		
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="sXml" id="sXml" />
<input type="hidden" name="id_tp" id="id_tp" value="<%=formcond.equals("1") ? "F" : "C" %>">
<input type="hidden" name="caller" id="caller" value="<%=caller %>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><span>Search Formula & Condition ID</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		    <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_OK" id="btn_OK">Ok</button><!--
		 --><button type="button" class="btn_normal" name="btn_Excel" id="btn_Excel">Down Excel</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table> 
			<colgroup>
				<col width="80px">
				<col width="80px">
				<col width="90px">
				<col width="100px">
				<col width="90px">
				<col width="100px">
				<col width="90px">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th rowspan="2"><input name=formcond id=formcond type="radio" value="1" class="trans" <%=formcond.equals("1") ? "checked" : "disabled" %> >Formula</th>
					<th rowspan="2"><input name=formCond  id=formCond type="radio" value="2" class="trans"  <%=formcond.equals("2") ? "checked" : "disabled" %> >Condition</th>
					<th>ID No.</th>
					<td><script type="text/javascript">ComComboObject('combo1',1,90,0);</script></td>
					<th>Charge Type</th>
					<td><script type="text/javascript">ComComboObject('combo2',1,90,1);</script></td>
					<th>Object</th>
					<td><script type="text/javascript">ComComboObject('combo3',2,140,0);</script></td>
				</tr>
				<tr>
					<th>Updated by ID</th>
					<td><input name="cre_usr" id="cre_usr" type="text"  style="width:140px;ime-mode:disabled;text-align:left" class="input0" value=""></td>
					<th>Description</th>
					<td colspan="3"><input name="descript" id="descript" type="text"  style="width:330px;ime-mode:disabled;text-align:left" class="input0" value=""></td>
				</tr>
			</tbody>
		</table>
		<!-- 
		<table>
			<colgroup>
				<col width="260">
				<col width="80">
				<col width="100">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Charge Type</th>
					<td><script type="text/javascript">ComComboObject('combo2',1,90,1);</script></td>
					<th>Object</th>
					<td><script type="text/javascript">ComComboObject('combo3',2,140,0);</script></td>
				</tr>
			</tbody>
		</table>
		-->
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>
