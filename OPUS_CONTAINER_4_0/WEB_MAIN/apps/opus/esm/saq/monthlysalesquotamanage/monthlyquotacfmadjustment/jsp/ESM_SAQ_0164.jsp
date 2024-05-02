<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName 	 : ESM_SAQ_0164.jsp
*@FileTitle  : VVD Mapping
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.event.EsmSaq0164Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSaq0164Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String loginOfcCd       = "";
	
	Logger log = Logger.getLogger("com.clt.apps.MonthlySalesQuotaManage.monthlyquotacfmadjustment");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id  = account.getUsr_id();
		strUsr_nm  = account.getUsr_nm();
		loginOfcCd = account.getOfc_cd();


		event = (EsmSaq0164Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="unit" value="1" id="unit" />
<input type="hidden" name="change_type" value="M" id="change_type" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_save" 		id="btn_save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_downexcel"  		id="btn_downexcel">Down Excel</button>	
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
<div class= "wrap_search">
<!-- opus_design_inquiry(S) -->
	<div class= "opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="100px"/>
					<col width="80px"/>
					<col width="38px"/>
					<col width="80px"/>
					<col width="50px"/>
					<col width="70px"/>
					<col width="72px"/>
					<col width="60px"/>
					<col width="57px"/>
					<col width="66px"/>
					<col width="85px"/>
					
					
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>Origin</th>
					<td><input style="width:80px;" class="input1" name="ofcCd" value="<%=loginOfcCd%>" readonly id="ofcCd" /> </td>
					<th>Year</th>
					<td><select class="input1" name="year" id="year" style="width:80px;" onchange="year_OnChange(this);"></select></td>
					<th>Quarter</th>
					<td><select class="input1" name="quarter" id="quarter" style="width:80px;" onchange="quarter_OnChange(this);"></select></td>
					<th>From Week</th>
					<td><select name="fmBseWk" id="fmBseWk" style="width:45px;"></select></td>
					<th>To Week</th>
					<td><select name="toBseWk" id="toBseWk" style="width:45px;"></select></td>
					<th>Applied Mode</th>
					<td>
						<input type="radio" name="change_mode" id="change_mode" value="B" class="trans" checked="checked"/> Simple Change
						<input type="radio" name="change_mode" id="change_mode" value="S" class="trans" disabled="disabled"/> Optional Change
					</td>
				</tr>
				<tr>
					<th>Release Version</th>
					<td><input name="mqtaRlseVerNo" type="text" class="input1" style="width:80px;" readonly id="mqtaRlseVerNo" /> </td>
					<th>Trade</th>
					<td><select name="trade" id="trade" class="input1" style="width:80px;" onchange="changeModeStatus();"></select></td>
					<th>Bound</th>
					<td><select class="input1" name="bound" id="bound" style="width:80px;" onchange="changeModeStatus();"></select></td>
					<th>Change Status </th>
					<td colspan="3"><input type="text" style="width:137px;" name="change_status" readonly="readonly" id="change_status" /> </td>
                    <th>Lane</th>
                    <td><select name="lane" id="lane" style="width:68px;"></select></td>

				</tr>
			</tbody>
		</table>
	</div>
</div>

<!-- opus_design_inquiry(E) -->
<!-- opus_design_grid(S) -->
<div id="tabLayer" style="display:inline">
	<div class="wrap_result">
		<div class="opus_design_grid clear" >
				<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
	
	<div class="opus_design_data" >
		<h3>* Click "<img src="/opuscntr/img/opus/ico_filter.gif" border="0" align="absmiddle" >"  to filter items.	</h3>
	</div>
	</div>
</div>
<!-- opus_design_grid(E) -->

<!-- opus_design_grid(S) -->
<div id="tabLayer" style="display:none">
	<div class="wrap_result">
		<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>
<!-- opus_design_grid(E) -->
</html>