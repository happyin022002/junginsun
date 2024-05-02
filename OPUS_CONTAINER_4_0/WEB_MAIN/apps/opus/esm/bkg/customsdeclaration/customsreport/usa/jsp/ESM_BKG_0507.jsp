<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0507.jsp
*@FileTitle  : US AMS: Transmission History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%> 
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>

<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.event.EsmBkg0507Event"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Locale" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0507Event  event 		= null;	//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;	// error from server
	String strErrMsg 			= "";	// error message
	int rowCount	 			= 0;	// count of DB resultSET list

	String successFlag 	= "";
	String codeList  	= "";
	String pageRows  	= "1000";
	String strUsr_id	= "";
	String strUsr_nm	= "";
    String today        = "";

	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.CustomsReport");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0507Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		today = eventResponse.getETCData("date"); 
        codeList = HttpUtil.makeXML(request,response);
        
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
    var today = "<%=today%>";
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
<input type="hidden" name="pagerows" value=<%=pageRows%>>

<input type="hidden" name="msg_tp_id">
<input type="hidden" name="vvd2">
<input type="hidden" name="pol">
<input type="hidden" name="pod">
<input type="hidden" name="ofc">
<input type="hidden" name="usr">

<input type="hidden" name="cnt_cd">
<input type="hidden" name="io_bnd_cd">
<input type="hidden" name="snd_date">
<input type="hidden" name="his_seq">
<input type="hidden" name="ofm_flg">

<input type="hidden" name="usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="code_list" value="<%=codeList%>">

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
	<!-- 
		<button type="button" class="btn_normal" name="btn_ofm_retrieve" id="btn_ofm_retrieve">OFM History Search</button>
		<button type="button" class="btn_normal" name="btn_ofm_file" id="btn_ofm_file">View OFM File</button>
    -->
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button>
		<button type="button" class="btn_normal" name="btn_file" id="btn_file">View Sent File</button>
		<button type="button" class="btn_normal" name="btn_Downexcel" id="btn_Downexcel">Down Excel</button>
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
<!--Page Title, Historical (E)-->

<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
<div class="opus_design_inquiry wFit">
	<!--  MiniLayer (S) -->
	<table>
		<colgroup>
            <col width="95px" />
            <col width="70px" />
            <col width="140px" />
            <col width="50px" />
            <col width="110px" />
            <col width="60px" />
            <col width="110px" />
            <col width="90px" />
            <col width="110px" />
            <col width="200px" />
            <col width="" />
		</colgroup>
		<tbody>
			<tr>
				<td rowspan="2" class="bg">
					<table>
						<tr>
							<td align="center">MSG Type</td></tr>
						<tr>
							<td align="center">
								<script language="javascript">ComComboObject('trsm_msg_tp_id', 2, 70, 1, 1);</script>
							</td>
						</tr>
					</table>
				</td>
				<th title="Vessel Voyage Direction">VVD</th>
				<td><input type="text" name="vvd" style="width:90px; ime-mode: disabled;" class="input" value=""
					dataformat="engup" minlength="9" maxlength="9" fullfill caption="VVD"></td> 
				<th title="Port of Loading">POL</th>
				<td><input type="text" name="pol_cd" style="width:60px; ime-mode: disabled;" class="input"
                       dataformat="engup" maxlength="5" fullfill caption="POL"></td>
				<th title="Port of Discharging">POD</th>
				<td><input type="text" name="pod_cd" style="width:60px; ime-mode: disabled;" class="input"
                       dataformat="engup" maxlength="5" fullfill caption="POD"></td> 
				<th>Last F. POL</th>
				<td><input type="text" name="lst_for_pol" style="width:50px; ime-mode: disabled;" class="input"
                       dataformat="engup" maxlength="5" fullfill caption="Last F. POL"></td> 
				<td rowspan="2">
					<div class="sm">
						<table>
							<tr>
								<td width="120px"><input type="checkbox" name="gubun" id="gubun" class="trans"><label for="gubun">Send Date</label></td></tr>
							<tr>
								<td class="stm">
			                        <input type="text" style="width:75px; ime-mode: disabled" class="input1" value="<%=today%>" disabled required dataformat="ymd" name="snd_fromd" maxlength="10" caption="Send Date" cofield="snd_tod"><!--
			                        --><input type="text" name="snd_fromt" maxlength="5" style="width:40px" dataformat="hm" value="00:00" class="input1" disabled>~&nbsp;<!--
			                        --><input type="text" style="width: 75px; ime-mode: disabled" class="input1" value="<%=today%>" disabled required dataformat="ymd" name="snd_tod" maxlength="10" caption="Send Date" cofield="snd_fromd"><!--
			                        --><input type="text" name="snd_tot" maxlength="5" style="width:40px" value="23:59" class="input1" disabled><!--
			                        --><button type="button" class="calendar ir" name="btn_calendar" id="btn_calendar"></button>         
								</td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
			<tr>
				<th>B/L No.</th>
				<td><input type="text" name="bl_no" style="width:100px; ime-mode: disabled;" class="input"
					dataformat="engup" maxlength="12" ></td>
				<th>OFFICE</th>
				<td><input type="text" name="snd_ofc_cd" style="width:60px; ime-mode: disabled;" class="input"
					dataformat="enguponly" minlength="5" maxlength="6" caption="OFFICE"></td>
				<th>USER ID</th>
				<td><input type="text" name="snd_usr_id" style="width:80px; ime-mode: disabled;" class="input"></td> 
				<td></td>
				<td></td> 
				<td colspan="2"></td>
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
	<!-- opus_grid_left(S)-->
	<div class="grid_option_left pad_btm_4">* EST (GMT -05:00)</div>
	<!-- opus_grid_left(E)-->

	<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <script language="javascript">ComSheetObject('sheet1');</script>
    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
</div>
<!-- opus_design_grid(E) -->
	
</form>