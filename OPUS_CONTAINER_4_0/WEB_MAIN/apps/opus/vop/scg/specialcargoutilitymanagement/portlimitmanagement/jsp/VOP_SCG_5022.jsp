<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_SCG_5022
*@FileTitle  : Port Limits DG Total Weight Check
*@author     : CLT
*@version    : 1.0
*@since      : 2014/11/18
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.event.VopScg5022Event"%>
<%
	VopScg5022Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error occurred on the server
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //Error message
	int rowCount	 = 0;								  //DB ResultSet List the number of

	SignOnUserAccount account = null;

	try {

		account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		event = (VopScg5022Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} // end if


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


<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="plmt_clpt_ind_seq">
<input type="hidden" name="f_cre_usr_id" value="<%=account.getUsr_id()%>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" type="button" id="btn_retrieve" name="btn_retrieve">Retrieve</button><!--
			 --><button class="btn_normal" type="button" id="btn_new" name="btn_new">New</button>
	    </div>
   	<!-- page_location(S) -->
   	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
        <span id="navigation"></span>
   	</div>
   	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class= "wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class= "opus_design_inquiry wFit" style="height:30px">
		<table>
			<colgroup>
				<col width="280px"/>
				<col width="80px"/>
				<col width="90px"/>
				<col width="50px"/>
				<col width="100px"/>
				<col width="20px"/>	
				<col width="200px"/>	
				<col width="80px"/>
				<col width="280px"/>
				<col width="*"/>
				<%-- <col width="*"/> --%>
			</colgroup>
			<tbody>
				<tr>
					<td class="pad_left_12">
						<input type="radio" name="plmt_port_cd" value="SGSIN" class="trans" id="plmt_port_cd" checked/>&nbsp;<b>Singapore</b>&nbsp;&nbsp;
						<input type="radio" name="plmt_port_cd" value="SAJED" class="trans" id="plmt_port_cd" />&nbsp;<b>Jeddah</b>&nbsp;&nbsp;
						<input type="radio" name="plmt_port_cd" value="FRLEH" class="trans" id="plmt_port_cd" />&nbsp;<b>Le Havre</b>&nbsp;&nbsp;
						<!-- input type="radio" name="plmt_port_cd" value="CNSHA" class="trans" id="plmt_port_cd" />&nbsp;<b>Shanghai</b-->
					</td>
					<th>Lane</th>
					<td><input type="text" name="slan_cd1" style="width:53px;text-align:center;" class="input" value="" fullfill="" caption="Lane" maxlength="3" dataformat="engup" id="slan_cd1" /><button type="button" id="btn_SlanCd" name="btn_SlanCd" class="input_seach_btn"></button>
			    	</td>
					<th>VVD</th>
					<td><input type="text" name="vsl_cd"     id="vsl_cd" style="width:55px;text-align:center;" class="input" value="" fullfill="" caption="VVD CD" maxlength="4" dataformat="engup" id="vsl_cd"/><input type="text" name="skd_voy_no" id="skd_voy_no" style="width:40px;text-align:center;" class="input"  value="" fullfill="" caption="VVD CD" maxlength="4" dataformat="engup" id="skd_voy_no" /><input type="text" name="skd_dir_cd" id="skd_dir_cd" style="width:20px;text-align:center;" class="input"  value="" fullfill="" caption="VVD CD" maxlength="1" dataformat="engup" id="skd_dir_cd" /><button type="button" id="btn_VVDpop" name="btn_VVDpop" class="input_seach_btn"></button>&nbsp;&nbsp;&nbsp;
					</td>
					<th>ETA</th>
					<td><input type="text" name="from_eta_dt" id="from_eta_dt" style="width:81px;text-align:center;" class="input2" value="" dataformat="ymd" maxlength="8" caption="POL ETA" id="from_eta_dt" required="true" />~&nbsp;
						<input type="text" name="to_eta_dt"   id="to_eta_dt" style="width:85px;text-align:center;" class="input2" value="" dataformat="ymd" maxlength="8" caption="POL ETA" id="to_eta_dt"   required="true" /> 
						<button type="button" id="btn_Calendar" name="btn_Calendar" class="calendar ir"></button>
					</td>
					<th class="wrap_search_tab">APVL Type</th>
					<td class="wrap_search_tab" ><!--
						 --><input type="radio" name="auth_flg" value="Y" class="trans" checked="" id="auth_flg" />&nbsp;&nbsp;Approved&nbsp;&nbsp;<!--
						 --><input type="radio" name="auth_flg" value="R" class="trans" id="auth_flg" />&nbsp;Request&nbsp;&nbsp;<!--
					     --><input type="radio" name="auth_flg" value="P" class="trans" id="auth_flg" />&nbsp;Pending&nbsp;&nbsp;<!--
					     --><input type="radio" name="auth_flg" value="A" class="trans" id="auth_flg" />&nbsp;All&nbsp;&nbsp;&nbsp;
					</td>
					<td><input type="checkbox" name="load_discharge" id="load_discharge" value="Y" class="trans" onClick="loadDischarge()" checked/>&nbsp;&nbsp;<b>Incl. D/L</b></td>
					<%--<th>Class</th>
					<td><script type="text/javascript">ComComboObject('imdg_clss_cd', 2, 56, 0, 0);</script>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</td> --%>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<div class= "wrap_result">
	<div class= "opus_design_grid">
		<div class="clear">
			<!-- opus_design_btn (S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_DownExcel" 	id="btn_DownExcel">Down Excel</button><!--
			 --><button class="btn_normal" name="btn_bkgDetails" id="btn_bkgDetails" type="button" onClick="bkgDetPop()">BKG Details</button>
			<!-- opus_design_btn (E) -->
			</div>
			<!-- opus_design_inquiry(S) -->
		</div>
		<div id="SHEET1" style="display:inline">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<div id="SHEET2" style="display:none">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
	</div>
</div>
</form>