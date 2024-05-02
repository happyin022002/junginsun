<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0079.jsp
*@FileTitle  : S_C Print View
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
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
<%@ page import="com.clt.apps.opus.esm.pri.screport.screport.event.EsmPri0079Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri0079Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_srep      = "";	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String sParam			= "";
	String parentId			= "";
	Logger log = Logger.getLogger("com.clt.apps.SCReport.SCReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_srep = account.getSrep_cd();		
		sParam = request.getParameter("sParam");	
		parentId	= request.getParameter("parentId");	

		event = (EsmPri0079Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");		
		

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
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
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="sParam" id="sParam" value="<%=StringUtil.xssFilter(sParam)%>">
<input type="hidden" name="parentId" id="parentId" value="<%=StringUtil.xssFilter(parentId)%>">

<div class="layer_popup_title">
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Print</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" id="btn_retrieve" name="btn_retrieve" class="btn_accent">Retrieve</button>
			<!-- <button type="button" id="btn_saveas" name="btn_saveas" class="btn_normal">Save As</button>-->
			<button type="button" id="btn_close" name="btn_close" class="btn_normal">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
</div>
<div class="layer_popup_contents">
	<div class="wrap_search" >
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="40"/>
					<col width="105"/>
					<col width="40"/>
					<col width="55"/>
					<col width="75" />				
					<col width="130"/>
					<col width="90" />				
					<col width="220"/>
					<col width="50"/>
					<col width="100" />
					<col width="50"/>
					<col width="*" />				
				</colgroup> 
				<tr>
					<th>S/C No.</th>
					<td><input id="sc_no" style="width:90px; text-align:center;" readonly name="sc_no" class="input2" type="text" /> </td>
					<th>AMD No.</th>
					<td><input id="amdt_seq" style="width:40px; text-align:center;" readonly name="amdt_seq" class="input2" type="text" /> </td>
					<th>Proposal No.</th>
					<td><input id="prop_no" style="width:80px; text-align:center;" readonly name="prop_no" class="input2" type="text" /> </td>
					<th>Duration</th>
					<td><input id="ctrt_eff_dt" style="width:80px; text-align:center;" readonly name="ctrt_eff_dt" class="input2" type="text" />  ~ <input id="ctrt_exp_dt" style="width:80px; text-align:center;" readonly name="ctrt_exp_dt" class="input2" type="text" /> </td>
					<th>Filed Date</th>
					<td><input id="prop_file_dt" style="width:75px; text-align:center;" readonly name="prop_file_dt" class="input2" type="text" /> </td>
					<th>Creation Date</th>
					<td><input id="prop_cre_dt" style="width:75px; text-align:center;" readonly name="prop_cre_dt" class="input2" type="text" /> </td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="90"/>
					<col width="100"/>
					<col width="50"/>
					<col width="290"/>
					<col width="90"/>
					<col width="100"/>
					<col width="50" />				
					<col width="*"/>				
				</colgroup> 
				<tr>
					<th>Request Office</th>
					<td><input id="prop_ofc_cd" style="width:70px; text-align:center;" readonly name="prop_ofc_cd" class="input2" type="text" /> </td>
					<th>Sales Rep.</th>
					<td><script type="text/javascript">ComComboObject('prop_srep_cd', 1, 63, 0, 1, 0, false);</script><input type="text" style="width:200px;" name="prop_srep_nm" readonly=true class="input2"></td>
					<th>Approval Office</th>
					<td><input id="apro_ofc_cd" style="width:70px; text-align:center;" readonly name="apro_ofc_cd" class="input2" type="text" /> </td>
					<th>Auth by</th>
					<td><input id="apro_usr_nm" style="width:240px;" readonly name="apro_usr_nm" class="input2" type="text" /> </td>
				</tr>
			</table>
			<table style="height:30px">
				<colgroup>
					<col width="90"/>
					<col width="200"/>
					<col width="*" />				
				</colgroup> 
				<tr>
					<th>Print Option&nbsp;&nbsp;&nbsp;</th>
					<%if ("ESM_PRI_0039".equals(parentId)) {%>
					<td><input type="checkbox" name="blpl_flg" id="blpl_flg" class="trans">&nbsp;Boiler Plate&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="sign_flg" id="sign_flg" class="trans" checked>&nbsp;Signature Page</td>
					<% } else { %>
					<td><input type="checkbox" name="blpl_flg" id="blpl_flg" class="trans" checked>&nbsp;Boiler Plate&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="sign_flg" id="sign_flg" class="trans" checked>&nbsp;Signature Page</td>
					<% } %>
					<td></td>
					<!-- <td><button type="button" id="btn_search" name="btn_search" class="btn_etc">Search</button></td> -->
				</tr>
			</table>
		</div>
	</div>
	<div class="wrap_result">
	    <div style="height=0px;"><script type="text/javascript">ComSheetObject('sheet1');</script></div>
		<div style="height=0px;display:none" >
	      	<table>
				<tr align="center">
					<td valign="top">
						<img src="img/btns_back_1.gif" width="0" height="19" alt="" border="0" name="btns_back1" class="cursor">&nbsp;
						<img src="img/btns_back.gif" width="0" height="19" alt="" border="0" name="btns_back2" class="cursor">&nbsp;
						<img src="img/btns_next.gif" width="0" height="19" alt="" border="0" name="btns_next1" class="cursor">&nbsp;
						<img src="img/btns_next_1.gif" width="0" height="19" alt="" border="0" name="btns_next2" class="cursor">&nbsp;
						<script type="text/javascript">ComComboObject('sc_no_list', 1, 120, 1, 1, 0, false);</script>
					</td>
				</tr>
			</table>
		</div>
		<div class="opus_design_RD">
	      	<script type="text/javascript">rdViewerObject();</script>
		</div>
		<div style="height=0px;"><script type="text/javascript" for=report1 event="ReportFinished();">ReportFinished();</script></div>
	</div>
</div>

</form>