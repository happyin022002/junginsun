<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ui_bkg_0557.jsp
*@FileTitle : Wharfage Declare
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0557Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0557Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String sBound = "";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.wharfagemgt.wharfagedecmgt");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0557Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		sBound = JSPUtil.getParameter(request, "bound");
		// Inbound / Outbound
			String sPgmNo = JSPUtil.getParameter(request, "pgmNo");
		if ("".equals(sBound)) {
			if (sPgmNo.length() == 12) {
				sBound = "I";
			} else {
				sBound = "O";
			}
		}

		//Add logic information data from the server when loading the initial screen
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
</head>

<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="edi_msg_snd_id">
<input type="hidden" name="cntr_20_ut_rt">
<input type="hidden" name="cntr_40_ut_rt">
<input type="hidden" name="cntr_45_ut_rt">
<input type="hidden" name="blk_ut_rt">
<input type="hidden" name="blk_rt_rto">
<input type="hidden" name="cancel_flag" value = "N">  <!-- Dec I/F ?  /  Dec Cancel I/F ? -->
<input type="hidden" name="csr_no" value = "">
<input type="hidden" name="bound" value = "<%=sBound%>">

<%
	//String keyAddr     =JSPUtil.getParameter(request, "keyAddr");
%>

<!-- 제목 -->
<div class="page_title_area clear">
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- btn_div -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_send" id="btn_send">Send</button><!--
		--><button type="button" class="btn_normal" name="btn_decIF" id="btn_decIF">Dec I/F</button><!--
		--><button type="button" class="btn_normal" name="btn_changeNoIF" id="btn_changeNoIF">Change No. I/F</button><!--
		--><button type="button" class="btn_normal" name="btn_decCancelIF" id="btn_decCancelIF">Dec Cancel I/F</button>
	</div>

   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
</div>
<!-- 제목 -->

<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<!--  biz_1  (S) -->
		<table class="search" border="0" style="width:979px;">
			<tr class="h23">
				<th width="30px" class="align_left">VVD</th>
				<td width="110px"><input type="text" style="width:77px;ime-mode:disabled" class="input1" name="vvd" dataformat="engup" maxlength="9" onkeyup="condition_KeyUp()" ></td>
				<th width="35px" class="align_left">Port</th>
				<td width="90px">
					<input type="text" style="width:49px;ime-mode:disabled" class="input1" name="port_cd"  dataformat="engup" maxlength="5" onkeyup="condition_KeyUp()">
				</td>
				<th width="35px" class="align_left">Bound</th>
				<td width="160px">
				<%=JSPUtil.getCodeCombo("whf_bnd_cd", "",  "style='width:140px;' onchange='searcgBySelect()'", "CD01546", 0,"")%>
				</td>
				<th width="35px" class="align_left">Send</th>
				<td width="80px">
					 <%=JSPUtil.getCodeCombo("send", "style='width:60px;'", "", "CD20022", 0, "")%></td>
				<th width="54px" class="align_left">MRN No.</th>
				<td width="160px"><input type="text" style="width:110px;" class="input2" name="mf_ref_no" maxlength="22" readonly="readonly" ></td>
				<th width="74px" class="align_left">Sailing Date</th>
				<td width="*"><input type="text" style="width:80px;" class="input2" name="sail_dt" maxlength="10" dataformat="ymd" readonly="readonly" ></td>
			</tr>
		</table>
		<!--  biz_1   (E) -->
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_grid">
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_add" id="btn_add">Row Add</button><!--
			--><button type="button" class="btn_normal" name="btn_del" id="btn_del">Row Delete</button>
		</div>
		<script language="javascript">ComSheetObject('sheet1');</script>
	</div>

	<table class="line_bluedot mar_btm_12"><tr><td></td></tr></table>
	<div class="opus_design_grid">
		<script language="javascript">ComSheetObject('sheet2');</script>
	</div>
	<div class="opus_design_inquiry">
		<table class="search" border="0" style="width:979px;">
			<tr class="h23">
				<td width="250px" valign="top">

				<table width="230px" class="grid2">
					<tr>
						<th width="35%" class="tr2_head align_center">허가일자	</th>
						<td width="%">
							<input type="text" style="ime-mode:disabled" name="whf_ntc_dt" dataformat="ymd" class="input1" caption="년월일"  maxlength="10" size="10"  ><!--
							--><button type="button" name="btn_calendar1" class="calendar"></button>
						</td>
					</tr>
					<tr>
						<th class="tr2_head align_center">납기일자 	</th>
						<td><input type="text" style="width:80px;" dataformat="ymd" class="noinput2" name="whf_pay_dt" readonly="readonly"></td>
					</tr>
					<tr>
						<th class="tr2_head align_center">담당자 	</th>
						<td><input type="text" style="width:80px;" class="input1" name="whf_usr_nm"></td>
					</tr>
					<tr>
						<th class="tr2_head align_center">화주 	</th>
						<td  class="input"><input type="radio" value="C" class="trans" name="whf_cust_knd_cd"  onclick="changeCommition(this.value)" checked="checked">복수 &nbsp;&nbsp;&nbsp;
										   <input type="radio" value="U" class="trans" name="whf_cust_knd_cd" onclick="changeCommition(this.value)">단수</td>
					</tr>
				</table>

				</td>
				<td width="350px" valign="top">


				<table width="330px" class="grid2">
					<tr>
						<th width="35%" class="tr2_head align_center">Total Amount	</th>
						<td width="%"  class="input2">
						<input type="text" style="width:100%;text-align:right;" class="noinput2"  maxlength="22" dataformat="float" name="whf_rt_amt" onkeyup="changeTotalAmtAndNtcAmt()" value="0"></td>
					</tr>
					<tr>
						<th class="tr2_head align_center">신고 금액  	</th>
						<td width="%"  class="input"><input type="text" style="width:100%;text-align:right;ime-mode:disabled" dataformat="float" maxlength="22" class="noinput" name="ntc_amt" onkeyup="changeTotalAmtAndNtcAmt()" value="0"></td>
					</tr>
					<tr>
						<th class="tr2_head align_center">WHF DEC No. 	</th>
						<td  class="input2" ><input type="text" style="width:100%;" class="noinput2" name="whf_decl_no" readonly="readonly"></td>
					</tr>
					<tr>
						<th class="tr2_head align_center">I/B T/S Amount</th>
						<td  class="input2" ><input type="text" style="width:100%;text-align:right;" class="noinput2" name="ibts_amt" readonly="readonly"></td>
					</tr>
				</table>

				</td>
				<td width="" valign="top">
				<table width="240px" class="grid2">
					<tr>
						<th width="38%" class="tr2_head align_center">절사</th>
						<td width="%"  class="input" colspan="3"><input type="text" style="width:100%;text-align:right;ime-mode:disabled" class="noinput" dataformat="float" maxlength="22" name="rduc_amt" onkeyup="PointNumberFixed(this.name, this.value)"; value="0"></td>
					</tr>
					<tr>
						<th class="tr2_head align_center">Commission 	</th>
						<td width="%"  class="input" colspan="3"><input type="text" style="width:100%;text-align:right;ime-mode:disabled" class="noinput" dataformat="float" maxlength="22" name="comm_amt" onkeyup="PointNumberFixed(this.name, this.value)"; value="0"></td>
					</tr>
					<tr>
						<th class="tr2_head align_center">항만 	</th>
						<td  class="input2" colspan="3"><input type="text" style="width:100%;" class="noinput2" name="port_nm"></td>
					</tr>
					<tr>
						<th class="tr2_head align_center">허가번호 </th>
						<td  class="input" width="20%"><input type="text" style="width:100%;ime-mode:disabled" class="noinput" dataformat="yy" name="whf_ntc_no_yr" maxlength="4" onchange="changePermitNum()"></td>
						<td  class="input" width="15%"><input type="text" style="width:100%;ime-mode:disabled" class="noinput" dataformat="yy" name="whf_ntc_no_mon" maxlength="2" onchange="changePermitNum()"></td>
						<td  class="input" width="%"><input type="text" style="width:100%;ime-mode:disabled" class="noinput" dataformat="yy" name="whf_ntc_no_seq" maxlength="6" onchange="changePermitNum()"></td>
					</tr>
				</table>


				</td>

			</tr>
		</table>

		<table border="0" style="width: 300px" class="search" >
			<tr class="h23">
				<th>LAST UPDATE:</th>
				<td><input type="text" style="width: 80px;"
				class="input2" name="upd_usr_id" readonly="readonly"></td>
				<td><input type="text" style="width: 110px;"
				class="input2" name="upd_dt" readonly="readonly"></td>
			</tr>
		</table>
	</div>
</div>

</form>
