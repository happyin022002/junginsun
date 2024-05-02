<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SPC_0102.jsp
*@FileTitle  : Some Title 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/18 
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.event.EsmSpc0102Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSpc0102Event event     = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.DailyForecast.DailyForecastManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSpc0102Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String ofc_cd = event.getSignOnUserAccount().getOfc_cd();
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">
	var ofc_cd = "<%=ofc_cd%>";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<!-- <form name="form" onsubmit="return false;" onKeyDown="spcKeyAction('ESM_SPC_0102' , event);"> -->
<form name="form" onsubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="vvdList" id="vvdList" value="DEFAULT">
<input type="hidden" name="salesRepCodeList" id="salesRepCodeList" value="DEFAULT">
<input type="hidden" name="uiname" id="uiname" value="ESM_SPC_0102">

<input type="hidden" name="ctrl_hc"  value="">
<input type="hidden" name="ctrl_45"  value="">
<input type="hidden" name="ctrl_53"  value="">
<input type="hidden" name="ctrl_rf"  value="">
<input type="hidden" name="ctrl_wt"  value="">
<input type="hidden" name="ctrl_lvl_all"  value="">
<input type="hidden" name="ctrl_tpsz_all"  value="">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
	 	--><button type="button" class="btn_normal" name="btn_fileimport" id="btn_fileimport">File Import</button><!-- 
	 	--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
		--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
		--><button type="button" class="btn_normal" name="btn_confirm" id="btn_confirm">Confirm</button><!-- 
		--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->
	
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<div class= "wrap_search">
<!-- opus_design_inquiry (S) -->
<div class= "opus_design_inquiry wFit">
	<table class="search_in" id="zoomarea">
		<tbody>
		<colgroup>
			<col width="80"/>
			<col width="75"/>
			<col width="70"/>
			<col width="41"/>
			<col width="10"/>
			<col width="120"/>
			<col width="10"/>
			<col width="*">
		</colgroup>
			<tr>
				<th>Start Week</th>
				<td>
					<select class="input1" name="year" id="year" style="width:65px;"></select><!-- 
					--><select class="input1" name="week" id="week" style="width:55px;"></select>
				</td>
				<th>Duration</th>
				<td><select class="input1" name="duration" id="duration" size="1"></select></td>
				<td></td>
			</tr>
			<tr>
				<th>Trade</th>
				<td><script type="text/javascript">ComComboObject("trade", 2, 104, 0, 1);</script></td>
				<th>Sub Trade</th>
				<td><script type="text/javascript">ComComboObject("subtrade", 3, 80, 0, 0, 1);</script></td>
				<th>Lane</th>
				<td><script type="text/javascript">ComComboObject("lane", 4, 70, 0, 1, 2);</script></td>
				<th>Bound</th>
				<td>
				<select name="bound" id="bound" style="width:95px;"></select><!-- 
				 --><input type="radio" class="trans" name="ioc" id="id_chk_ocn" value="O" checked><label for="id_chk_ocn">OCN</label>&nbsp;<!-- 
				 --><input type="radio" class="trans" name="ioc" id="id_chk_ipc" value="I"><label for="id_chk_ipc">IPC</label>&nbsp;<!-- 
				 --><input type="radio" class="trans" name="ioc" id="id_chk_ts"  value="T"><label for="id_chk_ts">TS</label>&nbsp;</td><!-- 
			 --></tr>
			<tr>
				<th>Sales Office</th>
				<td><script type="text/javascript">ComComboObject("salesOffice", 2, 104, 0, 1);</script></td>
				<th>Sub-Office</th>
				<td><script type="text/javascript">ComComboObject("subOffice", 2, 80, 0,0);</script></td>
				<th>Sales Rep</th>
				<td><script type="text/javascript">ComComboObject("salesRep", 4, 70, 0);</script></td>
				<th title="Vessel Voyage Direction">VVD</th>
				<td><input class="input1" type="text" name="vvd" size="12" maxlength="9" dataformat="engup" style="ime-mode:disabled;" onkeypress="eventKeyChangeChar(UPPER_CASE , this);" onchange="vvdChanged(this);"></td>
			</tr>
</table>
</div>
</div>
<!-- wrap_result(S) -->
<div class="wrap_result">
<div class="layout_wrap">
    <div class="layout_flex_fixed" style="width:710px"> 
	<table>
	 	<tr>
			<td rowspan="2">Data Selection :</td>
			<td ><input type="checkbox" class="trans" name="chkDs2LaneInfo" id="ds2LaneInfo" checked disabled></td><!-- onclick="return changeCheckSelection(this);"  -->
			<td><label for="ds2LaneInfo">Lane Info</label></td>

			<td ><input type="checkbox" class="trans" name="chkDs2Office" id="ds2Office" checked disabled></td>
			<td><label for="ds2Office">Office</label></td>

			<td ><input type="checkbox" class="trans" name="chkDs2Account" id="ds2Account" checked disabled></td>
			<td><label for="ds2Account">Account</label></td>

			<td  id="divDs2POD"><input type="checkbox" class="trans" name="chkDs2POD" id="ds2POD" disabled></td>
			<td  id="divDs2POD"><label for="ds2POD">POD</label></td>

			<td ><input type="checkbox" class="trans" name="chkDs2OTH" id="ds2OTH" onclick="return changeCheckSelection(this);"></td>
			<td><label for="ds2OTH">20/40</label></td>

			<td ><input type="checkbox" class="trans" name="chkDs2HC" id="ds2HC" onclick="return changeCheckSelection(this);"></td>
			<td><label for="ds2HC">HC</label></td>
		</tr>
		<tr>
			<td ><input type="checkbox" class="trans" name="chkDs245" id="ds245" onclick="return changeCheckSelection(this);"></td>
			<td><label for="ds245">45</label></td>
			
			<td ><input type="checkbox" class="trans" name="chkDs253" id="ds253" onclick="return changeCheckSelection(this);"></td>
			<td><label for="ds253">53'</label></td>

			<td ><input type="checkbox" class="trans" name="chkDs2RF" id="ds2RF" onclick="return changeCheckSelection(this);"></td>
			<td><label for="ds2RF">RF</label></td>

			<td ><input type="checkbox" class="trans" name="chkDs2WT" id="ds2WT" onclick="return changeCheckSelection(this);"></td>
			<td><label for="ds2WT">WT</label></td>

			<td ><input type="checkbox" class="trans" name="chkDs2BKG" id="ds2BKG" checked onclick="return changeCheckSelection(this);"></td>
			<td><label for="ds2BKG">BKG</label></td>

			<td  style="display:none;" id="divDs2CFM"><input type="checkbox" class="trans" name="chkDs2CFM" id="ds2CFM" onclick="return changeCheckSelection(this);"></td>
			<td style="display:none;" id="divDs2CFM"><label for="ds2CFM">Confirmed</label></td>

			<td ><input type="checkbox" class="trans" name="chkDs2CfrmAll" id="ds2CfrmAll" checked></td>
			<td><label for="ds2CfrmAll">Confirm all data on the screen</label></td>
		</tr> 
	</table>
	</div>
	<div class="layout_flex_flex" style="padding-left:718px"> 
	<table>
		<tr>
			<td  style="display:none;" id="divDs2INF"><input type="checkbox" class="trans" name="chkDs2INF" id="ds2INF" onclick="return changeCheckSelection();"></td>
			<td style="display:none;" id="divDs2INF"><label for="ds2INF">Information</label></td>
			<td rowspan="2"><button type="button" class="btn_etc" name="btng_addAccount2" id="btng_addAccount2" >Acct. Add/Del</button></td>
			<td align="right" id="sheetControlDiv">
				<button type="button" class="btn_down" id="maxi" name="maxi" sheetId="t1sheet1" type="N" onclick="toggleSheetSize('zoomarea');" alt='Alt+↑'></button>
			</td>
		</tr>
	</table>
	</div>
	<table><tr><td height="7"></td></tr></table>
	</div>
	<div id="mainTable">
	<script type="text/javascript">ComSheetObject('t1sheet1');</script>
	</div>
</div>
</form>

