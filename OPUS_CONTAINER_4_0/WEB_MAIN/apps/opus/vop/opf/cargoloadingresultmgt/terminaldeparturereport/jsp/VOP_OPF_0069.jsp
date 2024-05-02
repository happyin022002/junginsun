<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_0069
*@FileTitle  : Terminal Productivity Report
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
<%@ page import="com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf0069Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.Date"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>

<%
	VopOpf0069Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CargoLoadingResultMgt.TerminalDepartureReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopOpf0069Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<head>
<title>Terminal Productivity Report</title>


<script type="text/javascript">
<%=ConstantMgr.getCompanyCodeToJS()%>

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="tml_prod_rpt_flg" id="tml_prod_rpt_flg" />
<!-- Input Box for Report Designer -->
<input type="hidden" name="com_mrdPath" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" id="com_mrdArguments" />
<input type="hidden" name="com_mrdSaveDialogFileName" value="Terminal_ProductivityReportPrintPreview" id="com_mrdSaveDialogFileName" />
<input type="hidden" name="com_mrdSaveDialogFileExt" value="pdf" id="com_mrdSaveDialogFileExt" />
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif" id="com_mrdSaveDialogFileExtLimit" />
<input type="hidden" name="com_mrdDisableToolbar" id="com_mrdDisableToolbar" />
<input type="hidden" name="com_mrdTitle" value="Terminal Productivity Report Print Preview" id="com_mrdTitle" />
<input type="hidden" name="com_mrdBodyTitle" id="com_mrdBodyTitle" value="<span style=&quot;color:red&quot;>Terminal Productivity Report Print Preview</span>"/>
<!-- Developer Performance	-->
<input type="hidden" name="now_date" value="<%=DateTime.getFormatDate(new Date()," yyyy-MM-dd") %>" id="now_date" />
<input type="hidden" name="last_day" value="<%=DateTime.lastDayOfMonth(DateTime.getFormatDate(new Date(),"yyyyMMdd"))%>" id="last_day" />
<input type="hidden" name="carr_cd" id="carr_cd" />
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--  
	--><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
	--><button type="button" class="btn_normal" name="btn_New"  	id="btn_New">New</button><!--  
	--><button type="button" class="btn_normal" name="btn_Detail" 	id="btn_Detail">TDR Details</button><!--  
	--><button type="button" class="btn_normal" name="btn_Excel" 	id="btn_Excel">Down Excel</button><!--  
	--></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<div class="wrap_search ">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="147px">
				<col width="150px">
				<col width="130px">
				<col width="30px">
				<col width="130px">
				<col width="30px">
				<col width="*">
			</colgroup>
			<tr>
				<th>RHQ&nbsp;&nbsp;<script type="text/javascript">ComComboObject('rhq', 1, 70, 1);</script></th>
				<th>Port&nbsp;&nbsp;<input type="text" style="width:55px;ime-mode:disabled" class="" name="loc_cd" dataformat="engup" maxlength="5" caption="Port" >&nbsp;<!--  
				--><button type="button" name="btn_loc_cd" id="btn_loc_cd" class="input_seach_btn"></button><!--  
				--><script type="text/javascript">ComComboObject('yd_cd', 2, 46, 1);</script></th>
				<th>Lane&nbsp;&nbsp;<script type="text/javascript">ComComboObject('slan_cd', 1, 60, 1);</script></th>
				<th>Group</th>
				<td><script type="text/javascript">ComComboObject('group_by', 1, 100, 1);</script></td>					
				<th>Period</th>
				<td><input type="text" name="from_date" style="width:60px;" class="" dataformat="ym" maxlength="6" caption="Period" id="from_date" /><!--  
				--><button type="button" class="calendar ir" name="from_calendar" id="from_calendar"></button>&nbsp;~&nbsp;<!--  
				--><input type="text" name="to_date" id="to_date" style="width:60px;" class="" dataformat="ym" maxlength="6" caption="Period"/>&nbsp;<!--  
				--><button type="button" class="calendar ir" name="to_calendar" id="to_calendar"></button></td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="77px">
				<col width="70px">
				<col width="70px">
				<col width="130px">
				<col width="100px">
				<col width="42px">
				<col width="30px">
				<col width="30px">
				<col width="*">
			</colgroup>
			<tr>
				<th>Carrier Code</th>
				<td><input type="checkbox" name="carr_cd1" id="carr_cd1" class="trans" value=<%=ConstantMgr.getCompanyCode()%> checked>&nbsp;<%=ConstantMgr.getCompanyCode()%></td>
				<td><input type="checkbox" name="carr_cd2" class="trans" value="OTH" id="carr_cd2" />Other</td>
				<th>Excluded fm TPR</th>
				<td><input type="checkbox" name="tml_prod_rpt_rsn_cd" class="trans" value="Y" id="tml_prod_rpt_rsn_cd" /> </td>
				<th>Target</th>
				<td><script type="text/javascript">ComComboObject('target_lanes', 1, 160, 1);</script>&nbsp;<!--  
				--><button type="button" name="btn_target_lanes" id="btn_target_lanes" class="input_seach_btn"></button></td>
				<td><!--  
				--><script type="text/javascript">ComComboObject('target_ports', 1, 160, 1);</script>&nbsp;<!--  
				--><button type="button" name="btn_target_ports" id="btn_target_ports" class="input_seach_btn"></button></td>
				<td></td>
			</tr>
		</table>
	</div>
</div>
<div class="wrap_result ">
	<div class="opus_design_grid" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_grid" id="mainTable" style="display:none;">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>
</form>