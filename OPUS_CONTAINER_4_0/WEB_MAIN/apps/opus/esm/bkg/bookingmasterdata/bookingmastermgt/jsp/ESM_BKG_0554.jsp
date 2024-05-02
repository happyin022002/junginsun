<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : esm_bkg_0554.jsp
*@FileTitle : Package Table
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/05
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0554Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0554Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			// error from server
	String strErrMsg = "";						// error message
	int rowCount	 = 0;						// count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strCntCd			= "";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.BookingMasterData.BookingMasterMgt");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strCntCd =	account.getCnt_cd();

		event = (EsmBkg0554Event)request.getAttribute("Event");
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
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="ibflag" value="I">

<!-- 제목 -->
<div class="page_title_area clear">
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- btn_div -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_del" id="btn_del">Delete</button><!--
		--><button type="button" class="btn_normal" name="btn_inquiry" id="btn_inquiry">Inquiry</button>
	</div>

	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
</div>
<!-- 제목 -->

<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<h3 class=“title_design”>Input Option</h3>
		<table border="0" style="width:979px;">
			<tr class="h23">
			<th width="90px" class="align_left">Country Code</th>
			<td width="80px"><input type="text" name="cnt_cd" style="width:30px;" class="input1" value="" style="ime-mode:disabled" dataformat="engup" caption="Country Code" maxlength="2" required fullfill ></td>
			<th width="150px" class="align_left">Bonded Abbr. Code</th>
			<td width="*"><input type="text" name="wh_cd" style="width:45px;" class="input1" value="" style="ime-mode:disabled" dataformat="engup" caption="Bonded Abbr. Code" maxlength="4" required fullfill ></td>
			</tr>
		</table>
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_grid" style="display:none">
		<script language="javascript">ComSheetObject('sheet1');</script>
	</div>
	<h3 class="title_design">Bonded Area Information</h3>
	<div class="opus_design_inquiry ">
		<table border="0" style="width:400px;">
			<tr class="h23">
				<th class="tr2_head align_center" width="100px">Bonded Area Code</th>
				<td width="*" class="input1" colspan="2"><input type="text" name="cstms_cd" style="width:100%;" class="input1" value="" style="ime-mode:disabled" dataformat="exceptengdn" caption="Customs Code" maxlength="10" required fullfill ></td>
			</tr>
			<tr class="h23">
				<th class="tr2_head align_center">Name</th>
				<td width="" class="input1" colspan="2"><input type="text" name="wh_nm" style="width:100%;" class="input1" value="" style="ime-mode:disabled" dataformat="exceptengdn" caption="Name" maxlength="500" required  ></td>
			</tr>
			<tr class="h23">
				<th class="tr2_head align_center" width="100px">Address</th>
				<td width="" class="input1" colspan="2"><input type="text" name="wh_addr" style="width:100%;" class="input1" value="" style="ime-mode:disabled" dataformat="exceptengdn"  caption="Address" maxlength="500" required></td>
			</tr>
			<tr class="h23">
				<th class="tr2_head align_center" width="100px">Location</th>
				<td width="100px" ><input type="text" name="loc_cd" style="width:100%;" class="input1" value="" style="ime-mode:disabled" dataformat="engup" caption="Location" maxlength="5" required fullfill onfocusout="obj_deactivate()"></td>
				<td width="200px"><input type="text" name="loc_nm" style="width:100%;" class="input2" value=""  readonly="readonly" style="ime-mode:disabled" caption="Location Name"   ></td>
			</tr>
			<tr class="h23">
				<th class="tr2_head align_center" width="100px">Contact Person</th>
				<td width="*" colspan="2"><input type="text" name="pson_nm" style="width:100%;"  value=""   caption="Contact Person" maxlength="50"></td>
			</tr>
			<tr class="h23">
				<th class="tr2_head align_center" width="100px">Tel</th>
				<td width="*" colspan="2"><input type="text" name="phn_no" style="width:100%;"  value="" style="ime-mode:disabled" caption="Tel" maxlength="20"></td>
			</tr>
			<tr class="h23">
				<th class="tr2_head align_center" width="100px">Fax</th>
				<td width="*" colspan="2"><input type="text" name="fax_no" style="width:100%;"  value="" style="ime-mode:disabled" caption="Fax" maxlength="20"></td>
			</tr>
			<tr class="h23">
				<th class="tr2_head align_center" width="100px">Remark(s)</th>
				<td width="*" colspan="2"><input type="text" name="diff_rmk" style="width:100%;"  value=""  caption="Remark" maxlength="4000"></td>
			</tr>
		</table>
	</div>
</div>

</form>
