<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec. All Rights Reserved.
*@FileName   Esm_bkg_0723.js
*@FileTitle  : CLL/CDL EDI Option
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
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
<%@ page import="com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0723Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0723Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//serverException
	String strErrMsg = "";						//error massage
	int rowCount	 = 0;						//DB ResultSet list count
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String inListType		= "";
	String inVvdCd			= "";
	String inPolCd			= "";
	String inPodCd			= "";
	String allPol			= "";
	String bkgCgoTpCd			= "";
	Logger log = Logger.getLogger("com.clt.apps.TerminalDocumentation.CLLCDLManifest");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		inListType = StringUtil.xssFilter(request.getParameter("inListType"))==null?"":StringUtil.xssFilter(request.getParameter("inListType"));
		allPol = StringUtil.xssFilter(request.getParameter("allPol"))==null?"":StringUtil.xssFilter(request.getParameter("allPol"));
		inVvdCd = StringUtil.xssFilter(request.getParameter("inVvdCd"))==null?"":StringUtil.xssFilter(request.getParameter("inVvdCd"));
		inPolCd = StringUtil.xssFilter(request.getParameter("inPolCd"))==null?"":StringUtil.xssFilter(request.getParameter("inPolCd"));
		inPodCd = StringUtil.xssFilter(request.getParameter("inPodCd"))==null?"":StringUtil.xssFilter(request.getParameter("inPodCd"));
		bkgCgoTpCd = StringUtil.xssFilter(request.getParameter("inBkgCgoTpCd"))==null?"":StringUtil.xssFilter(request.getParameter("inBkgCgoTpCd"));
		event = (EsmBkg0723Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
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
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="in_vvd_cd" name="in_vvd_cd" value="<%=inVvdCd %>" type="hidden" />
<input id="in_pol_cd" name="in_pol_cd" value="<%=inPolCd %>" type="hidden" />
<input id="in_pod_cd" name="in_pod_cd" value="<%=inPodCd %>" type="hidden" />
<input id="allPol" name="allPol" value="<%=allPol %>" type="hidden" />
<input id="bkg_cgo_tp_cd" name="bkg_cgo_tp_cd" value="<%=bkgCgoTpCd %>" type="hidden" />
<input id="port_cd" name="port_cd" value="" type="hidden" />
<input id="in_list_type" name="in_list_type" value="<%=inListType %>" type="hidden" />
<input id="in_rcv_id" name="in_rcv_id" type="hidden" />
<input id="in_snd_id" name="in_snd_id" type="hidden" />
<input id="in_yd_cd" name="in_yd_cd" type="hidden" />
<input id="in_dest_svr_cd" name="in_dest_svr_cd" type="hidden" />
<input id="in_area_id" name="in_area_id" type="hidden" />
<input id="in_vvd_flg" name="in_vvd_flg" type="hidden">
<input id="in_bl_flg" name="in_bl_flg" type="hidden">

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>CLL/CDL EDI Option</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_OK" id="btn_OK">OK</button><!--  
			--><button type="button" class="btn_normal" name="btn_Close" 	id="btn_Close">Close</button>		
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
			<table> 
				<tbody>
				<colgroup>
					<col width="10%" />
					<col width="*" />
				</colgroup>
				<tr class="h23">
					<th style="text-align:left">List Type</th>
					<td><input type="text" class="input2" name="in_list_type_view" style="width:184px;" value="<%if(inListType.equals("L")){%>Loading List<%}else{%>Discharging List<%}%>" readonly></td></tr>
				<tr class="h23">						
					<th style="text-align:left">VVD</th>
					<td><input type="text" class="input2" name="in_vvd_cd_view" style="width:184px;" value="<%=inVvdCd %>" readonly></td></tr>
				<tr class="h23">
					<th style="text-align:left"><%if(inListType.equals("L")){%>POL<%}else{%>POD<%}%></td>
					<td><input type="text" class="input2" name="in_port_cd" style="width:184px;" value="<%if(inListType.equals("L")){%><%=inPolCd%><%}else{%><%=inPodCd%><%}%>" readonly></td></tr>
				<tr class="h23">
					<th style="text-align:left">Terminal VVD</th>
					<td><input type="text" class="input" name="in_terminal_vvd_cd" style="width:184px;" maxlength="7" value="" dataformat="engup" style="ime-mode:disabled"></td></tr>
				<tr class="h23">
					<th style="text-align:left">EDI Message Type</th>
					<td>
					<%=new com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil().getCstmsCodeCombo("in_edi_msg_func", "00", "CLL_EDI_MSG_TP_CD","", "style='width:100;'")%>
					</td>
				</tr>
				</tbody>
			</table>		
	</div>
	<!-- opus_design_inquiry(E) -->
	</div>
	
	<div class="wrap_result">
	<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	<!-- opus_design_grid(E) -->
	<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" style="display:none">
				<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
	<!-- opus_design_grid(E) -->
	</div>
</div>
</form>