<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0500.jsp
*@FileTitle  : Canada ACI: Transmission History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.event.EsmBkg0500Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0500Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//DB ResultSet List count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0500Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
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

<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
		--><button type="button" class="btn_normal" name="btn_viewSendFile" id="btn_viewSendFile">View Sent File</button>
	</div>
	<!-- opus_design_btn(E) -->

   	<!-- page_location(S) -->
   	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
        <span id="navigation"></span>
   	</div>
   	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
<div class="opus_design_inquiry wFit">
	<!--  MiniLayer (S) -->
	<table>
		<colgroup>
            <col width="90px" />
            <col width="70px" />
            <col width="140px" />
            <col width="50px" />
            <col width="110px" />
            <col width="60px" />
            <col width="120px" />
            <col width="180px" />
            <col width="" />
		</colgroup>
		<tbody>
			<tr>
				<td rowspan="2" class="sm">
					<table>
						<tr class="h23">
							<td align="center">MSG Type</td></tr>
						<tr class="h23">
							<td align="center">
								<%--=JSPUtil.getCodeCombo("trsm_msg_tp_id", "", "", "CD20017", 0, "")--%>
								<select style="width:50;" name="trsm_msg_tp_id">
									<option value="">All</option>
									<option value="A6A">A6A</option>
									<option value="A6">A6</option>
									<option value="ATA">ATA</option>
									<option value="S10">S10</option>
									<option value="E10">E10</option>
									<option value="PA">PA</option>
									<option value="BACA">BAPLIE</option>
								</select>
							</td>
						</tr>
					</table>
				</td>
				<th title="Vessel Voyage Direction">VVD</th>
				<td><input type="text" style="width:90px;ime-mode:disabled" class="input" name="vvd_cd" dataformat="engup" maxlength="9" caption="VVD"></td> 
				<th title="Port of Loading">POL</th>
				<td><input type="text" style="width:90px;ime-mode:disabled" class="input" name="pol_cd" dataformat="engup" maxlength="5" caption="POL"></td>
				<th title="Port of Discharging">POD</th>
				<td><input type="text" style="width:90px;ime-mode:disabled" class="input" name="pod_cd" dataformat="engup" maxlength="5" caption="POD"></td>
				<td rowspan="2" align="right"  class="sm">
					<table class="search_sm2">
						<tr class="h23">
							<td class="pad_left_8"><input type="checkbox" class="trans" name="snd_dt_flg" value="true">&nbsp;&nbsp;Send Date</td></tr>
						<tr class="h23">
							<td class="stm pad_left_8">
								<input type="text" style="width:80px;ime-mode:disabled"  maxlength="10"
									name="s_snd_dt" class="input" dataformat="ymd" caption="Send Date" cofield="e_snd_dt"><!--
							--><input type="text" style="width:40px;ime-mode:disabled"  maxlength="5" value="00:00"
									name="s_snd_tm" class="input" dataformat="hm" caption="Send Time"><!--
				    		-->&nbsp;~&nbsp;<input type="text" style="width:80px;ime-mode:disabled"  maxlength="10"
									name="e_snd_dt" class="input" dataformat="ymd" caption="Send Date" cofield="s_snd_dt"><!--
							--><input type="text" style="width:40px;ime-mode:disabled"  maxlength="5" value="23:59"
									name="e_snd_tm" class="input" dataformat="hm" caption="Send Time"><!--
							--><button type="button" class="calendar ir" name="btn_calendar" id="btn_calendar"></button>
							</td>
						</tr>
					</table>
				</td>
				<td></td>
			</tr>
			<tr class="h23">
				<th>B/L No.</th>
				<td><input type="text" style="width:120px;ime-mode:disabled" class="input" 
					name="bl_no" dataformat="eng" maxlength="12" caption="B/L No"></td>
				<th>OFFICE</th>
				<td><input type="text" style="width:90px;" class="input" 
					name="office" dataformat="engup" maxlength="6" caption="OFFICE"></td>
				<th>USER ID</th>
				<td><input type="text" style="width:90px;" class="input" 
					name="usr_id" dataformat="eng" maxlength="20" caption="USER ID"></td>
			</tr>
		</tbody>
	</table>
	<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
<div class="opus_design_grid">
	<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <script language="javascript">ComSheetObject('sheet1');</script>
    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
</div>
<!-- opus_design_grid(E) -->
<!-- page(E) -->

</form>