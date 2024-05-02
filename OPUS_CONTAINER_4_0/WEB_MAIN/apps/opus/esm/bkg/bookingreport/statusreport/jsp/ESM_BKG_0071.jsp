<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0071.jsp
*@FileTitle  : BDR Status Inquiry 
*@author     : CLT
*@version    : 
*@since      : 2014/05/05
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg0071Event"%>	
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0071Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//serverException
	String strErrMsg = "";						//error massage
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	boolean bBtn_Disabled = true;
	Logger log = Logger
			.getLogger("com.clt.apps.CustomsDeclaration.CndManifestListDownload");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0071Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		//when open screen, get data in server..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
	<input type="hidden" name="f_cmd" id="f_cmd"> 
	<input type="hidden" name="pagerows" id="pagerows"> 
	<input type="hidden" name="ch_usr_id" id="ch_usr_id">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_BKGList"  	id="btn_BKGList">BKG List</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_DownExcel" 	id="btn_DownExcel">Down Excel</button>	
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
	<!-- page_title_area(E) -->
	
	<!-- opus_design_inquiry(S) -->
	<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="50"/>
				<col width="150"/>
				<col width="43"/>
				<col width="150"/>
				<col width="57"/>
				<col width="150"/>
				<col width="40"/>
				<col width="100"/>
				<col width="40"/>
				<col width="100"/>
				<col width="70"/>
				<col width="*" />				
			</colgroup> 
			<tbody>
				<tr>
						<th title="Vessel Voyage Direction">VVD</th>
						<td><input type="text" style="width:96px" value="" class="input1" name="vvd_cd" id="vvd_cd" maxlength='9' required fullfill  dataformat='engup' style="ime-mode:disabled"></td>
						<th title="Port of Loading">POL</th>
						<td><input type="text" style="width:110px" value="" class="input" name="pol_cd" id="pol_cd" maxlength='5' dataformat='engup' style="ime-mode:disabled"></td>
						<th title="Port of Discharging">POD</th>
						<td><input type="text" style="width:96px" value="" class="input" name="pod_cd" id="pod_cd" maxlength='5' dataformat='engup' style="ime-mode:disabled"></td>
						<th>Lane</th>
						<td>
					   <!-- comboid, iColCnt, iWidth , iStyle, iCss, iShowCol, iEdit, iTab --> 
							<script type="text/javascript">ComComboObject('slan_cd', 1, 67, 0);</script>
						<!--<select style="width:67;" name="slan_cd">
							<option value="" ></option>
							</select>&nbsp;
							-->
						</td>
						<th>Dir</th>
						<td><script type="text/javascript">ComComboObject('skd_dir_cd', 1, 57, 1 );</script></td>
						<th>BDR Date</th>
						<td><input type="text" style="width:96px" value="" class="input" name="bdr_dt"  maxlength='10' dataformat="ymd" ><!-- 
						     --><button type="button" class="calendar ir"  name="btn_bdrdate" id="btn_bdrdate"></button>
						</td>
						
					</tr>
			</table>
			<table>
			<colgroup>
				<col width="50"/>
				<col width="100"/>
				<col width="200"/>
				<col width="90"/>
				<col width="*"/>
			</colgroup> 
			<tbody>
						<tr>
						<th>Period</th>
						<td>
						<select  style="width: 100%;" name="period_type">
							<option value=""></option>
							<option value="POL/ETD" >POL/ETD</option>
							<option value="POD/ETA">POD/ETA</option>
							</select>
						</td>
						<td>
							<input type="text" style="width:80px" value="" class="input"  name="from_dt" id="from_dt"  maxlength='10' dataformat="ymd" ><span class="dash">~</span><!-- 
							--><input type="text" style="width:80px" value="" class="input"  name="to_dt"  id="to_dt"  maxlength='10' dataformat="ymd" ><!-- 
							--><button type="button" class="calendar ir"  name="btn_period" id="btn_period"></button>
						</td>
						<th>Runtime</th>
						<td><input type="text" style="width:116px" value="" class="input2" name="runtime" id="runtime" readonly></td>					
					</tr>
			</tbody>
		</table>
	</div>
	</div>
<!-- opus_design_inquiry(E) -->
	<!-- opus_design_grid(S) -->
	<div class="wrap_result" >
	<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	</div>
<!-- opus_design_grid(E) -->
</form>
 