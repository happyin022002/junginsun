<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_0095.jsp
*@FileTitle  : Missing TDR Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================*/
%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf0095Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>
<%
	VopOpf0095Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message

	Logger log = Logger.getLogger("com.clt.apps.CargoLoadingResultMgt.TerminalDepartureReport");

	String rhqOfcCd = "";
	String tdrList = "";
	String svcList = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		//rhqOfcCd = account.getRhq_ofc_cd();

		event = (VopOpf0095Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		////rhqOfcCd = eventResponse.getETCData("RHQ_OFC_CD");
		tdrList  = eventResponse.getETCData("tdrList");
		svcList  = eventResponse.getETCData("svcList");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>


<script type="text/javascript">
<%=ConstantMgr.getCompanyCodeToJS()%>
	var frDt = ComGetDateAdd('<%=JSPUtil.getKST("yyyy-MM-dd")%>', "M", -1);
	var toDt = "<%=JSPUtil.getKST("yyyy-MM-dd")%>";
	////var rhqOfcCd = "<%=rhqOfcCd%>";
	var tdrList  = "<%=tdrList%>";
	var svcList  = "<%=svcList%>";
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
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--  
	--><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
	--><button type="button" class="btn_normal" name="btn_new"  	id="btn_new">New</button><!--  
	--><button type="button" class="btn_normal" name="btn_downexcel" 	id="btn_DownExcel">Down Excel</button><!--  
	--></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table> 
			<colgroup>
				<col width="30px">
				<col width="30px">
				<col width="112px">
				<col width="70px">
				<col width="112px">
				<col width="80px">
				<col width="110px">
				<col width="80px">
				<col width="110px">				
				<col width="*">
			</colgroup>
			<tr>
				<th>Period</th>
				<td><input type="text" name="fr_dt" style="width:80px;" class="input1" dataformat="ymd" maxlength="8" caption="From to Date" id="fr_dt" />~&nbsp;<!--  
				--><input type="text" name="to_dt" style="width:80px;" class="input1" dataformat="ymd" maxlength="8" caption="To Date" id="to_dt" /><!--  
				--><button type="button" id="btns_period" name="btns_period" class="calendar ir"></button></td>
				<th>RHQ</th>
				<td><script type="text/javascript">ComComboObject('rhq_ofc_cd', 1, 75, 1);</script></td>
				<th>Port</th>
				<td><input type="text" name="loc_cd" style="width:60px; ime-mode:disabled" class="input" dataformat="engup" maxlength="5" caption="Port" fullfill="" id="loc_cd" /><!--  
				--><button type="button" id="btns_port" name="btns_port" class="input_seach_btn"></button></td>
				<th>Lane</th>
				<td><input type="text" name="slan_cd" style="width:47px; ime-mode:disabled;" class="input" dataformat="engup" maxlength="3" caption="Lane" fullfill="" id="slan_cd" /><!--  
				--><button type="button" id="btns_slan" name="btns_slan" class="input_seach_btn"></button></td>
				<th>VVD CD</th>
				<td><input id="vsl_cd" name="vsl_cd" required="" fullfill="" style="width:55px;" class="input1" value="" caption="VVD CD" maxlength="4" dataformat="engup" type="text" /><input id="skd_voy_no" name="skd_voy_no" required="" fullfill="" style="width: 40px;" class="input1" value="" caption="VVD CD" maxlength="4" dataformat="num" type="text" /><input id="skd_dir_cd" name="skd_dir_cd" required="" fullfill="" style="width: 20px;" class="input1" value="" caption="VVD CD" maxlength="1" dataformat="enguponly" type="text" /><button class="input_seach_btn" name="btn_vvd" id="btn_vvd" type="button"></button></td>
									
			</tr>	
		</table>
		<table>
			<colgroup>
				<col width="30px">
				<col width="68px">
				<col width="68px">
				<col width="68px">
				<col width="119px">
				<col width="70px">
				<col width="112px">
				<col width="70px">
				<col width="117px">
				<col width="*">
			</colgroup>
			<tr>
				<th>Carrier&nbsp;</th>
				<td><input type="radio" class="trans"  name="crr_cd" id="crr_cd" value=<%=ConstantMgr.getCompanyCode()%> checked>&nbsp;<%=ConstantMgr.getCompanyCode()%></td>
				<td><input type="radio" class="trans" name="crr_cd" value="OTH" id="crr_cd" />&nbsp;Other</td>
				<td><input type="radio" class="trans" name="crr_cd" value="" id="crr_cd" />&nbsp;All</td>
				<th>TDR</th>
				<td><script type="text/javascript">ComComboObject('tdr_flg', 1, 75, 1, 1 );</script></td>
				<th>Service</th>
				<td><script type="text/javascript">ComComboObject('svc_tp_cd', 1, 82, 1);</script></td>
				<th>Exclude from TPR</th>
				<td><script type="text/javascript">ComComboObject('ex_tpr_flg', 1, 47, 1);</script></td>
			</tr>	
		</table>
	</div>
</div>
<div class="wrap_result ">
	<div class="opus_design_grid" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>