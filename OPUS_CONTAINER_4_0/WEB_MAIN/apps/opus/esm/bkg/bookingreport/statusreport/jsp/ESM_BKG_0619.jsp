<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName:  : ESM_BKG_0619.jsp
 *@FileTitle  : Outbound Container Movement Status 
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/02
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg0619Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0619Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String cookiesJSessionId="";
	Logger log = Logger.getLogger("com.clt.apps.BookingReport.StatusReport");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0619Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        Cookie[] cookies = request.getCookies();
          if (cookies != null) {
              for (int loop = 0; loop < cookies.length; loop++) {
                     if (cookies[loop].getName().equals("JSESSIONID")) {
                             cookiesJSessionId=cookies[loop].getValue();
                      }
              }
       }

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
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

	<form id="form" name="form">
		<input type="hidden" id="f_cmd" name="f_cmd"> <input type="hidden" name="pagerows">
		<input type="hidden" id="com_mrdPath" name="com_mrdPath">
		<input type="hidden" id="com_mrdArguments" name="com_mrdArguments"> 
		<input type="hidden" id="com_mrdTitle" name="com_mrdTitle" value="O/B Container Movement Status">
		<input type="hidden" id="com_mrdBodyTitle" name="com_mrdBodyTitle" value="O/B Container Movement Status">
		<input type="hidden" id="combo_flg" name="combo_flg" value="">
		<input type="hidden" name="jsession" id="jsession" value="<%=cookiesJSessionId %>"/>
		<!-- 개발자 작업	-->
		<!-- page_title_area(S) -->
		<div class="page_title_area clear">
		   <!-- page_title(S) -->
			<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
			<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
			<!-- page_title(E) -->
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_New"  	id="btn_New">New</button><!-- 
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
		
<!-- result_area(S) -->
<div class="wrap_search_tab">
<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
			<colgroup>
				<col width="80"></col>
				<col width="85"></col>
				<col width="25"></col>
				<col width="25"></col>
				<col width="40"></col>
				<col width="25"></col>
				<col width="55"></col>
				<col width="70"></col>
				<col width="30"></col>
				<col width="50"></col>
				<col width="90"></col>
				<col width="50"></col>
				<col width="60"></col>
				<col width="36"></col>
				<col width="55"></col>
				<col width="*"></col>
			</colgroup>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" name="vvd_cd" style="width: 80px;" class="input1" value="" style="ime-mode:disabled" dataformat="engup" caption="VVD" maxlength="9" fullfill required></td>
					<th class="sm">L/T</th>
					<td class="sm">
						<input type="checkbox" id="chk_lt_type_l" name="chk_lt_type" value="L"><label for="chk_lt_type_l">Local</label><!--
					 --><input type="checkbox" id="chk_lt_type_t" name="chk_lt_type" value="T"><label for="chk_lt_type_t">T/S</label></td>
					<th title="Port of Loading">POL</th>
					<td><input type="text" name="pol_cd" style="width: 65px;" class="input1" value="" style="ime-mode:disabled" dataformat="engup" caption="POL" maxlength="5"></td>
					<th title="Place of Receipt">POR</th>
					<td><input type="text" name="por_cd" style="width: 65px;" class="input" value="" style="ime-mode:disabled" dataformat="engup" caption="POR" maxlength="5"></td>
					<th>R/D Term</th>
					<td><script type="text/javascript">ComComboObject('rcv_term_cd', 1,65, 1)</script>
						<script type="text/javascript">ComComboObject('de_term_cd', 1, 65, 1)</script></td>
					<th>Pre VVD</th>
					<td ><input type="text" name="pre_1_vvd" style="width: 80px;" class="input" value="" style="ime-mode:disabled" dataformat="engup" caption="Pre VVD" maxlength="9" fullfill></td>
					<th>Pre POL</th>
					<td ><input type="text" name="pre_1_pol_cd" style="width: 50px;" class="input" value="" style="ime-mode:disabled" dataformat="engup" caption="Pre POL" maxlength="5" fullfill></td>
					<th>Yard</th>
					<td><input type="text" name="org_yd_cd" style="width: 65px;" class="input" value="" style="ime-mode:disabled" dataformat="engup"caption="Yard" maxlength="7"></td>
				</tr>
			</tbody>
		</table>
		<table>
			<tbody>
				<colgroup>
					<col width="80"></col>
					<col width="200"></col>
					<col width="73"></col>
					<col width="247"></col>
					<col width="70"></col>
					<col width="90"></col>
					<col width="70"></col>
					<col width="73"></col>
					<col width="77"></col>
					<col width="*"></col>
				</colgroup>
				<tr>
						<th>BKG OFC</th>
						<td ><input type="text" name="bkg_ofc_cd" style="width: 65;" class="input" value=""
													style="ime-mode:disabled" dataformat="enguponly"
													caption="BKG OFC" maxlength="5" fullfill>(<input
													type="checkbox" id="ofc_inc_sub" name="ofc_inc_sub" value="Y"><label for="ofc_inc_sub">Including Sub</label>)</td> 
						<th>BKG Date</th>
						<td><input type="text" name="bkg_dt_fr"
													style="width: 75px;" class="input" value="" dataformat="ymd"
													caption="BKG Start Date" maxlength="10">~&nbsp;<input type="text" name="bkg_dt_to" style="width: 75px;"
													class="input" value="" dataformat="ymd"
													caption="BKG End Date" maxlength="10"><!--
													--><button type="button" class="calendar ir" onClick="callDatePop('BKG_DATE')"></button>
													
						</td>
						<th>BKG Status</th>
						<td><script type="text/javascript">ComComboObject('bkg_sts_cd', 1, 65,0, 0, 0);</script></td>
						<th>BKG Kind</th>
						<td ><script type="text/javascript">ComComboObject('xter_bkg_rqst_cd',1, 65, 0, 0, 0);</script></td>
						<th>EQ Confirm</th>
						<td width=""><select name="cntr_cfm_flg" style="width: 65px;">
									 <option value="" selected>All</option>
									 <option value="Y">Y</option>
									 <option value="N">N</option>
								     </select>
						</td>
				</tr>				
			</tbody>
		</table>
		
	<table> 
		<tbody>
			<colgroup>
					<col width="80"></col>
					<col width="200"></col>
					<col width="120"></col>
					<col width="90"></col>
					<col width="326"></col>
					<col width="70"></col>
					<col width="*"></col>
			</colgroup>
			<tr>
				<th>Cargo Type</th>
				<td><script type="text/javascript">ComComboObject('bkg_cgo_tp_cd', 1, 180, 0,0,0);</script></td> 
				<th><input type="checkbox" id="chk_inc_clm" name="chk_inc_clm"  value="Y"  onClick="chkIncClm()"><label for="chk_inc_clm">Incl. CLM Info.</label></th> 
				<th>Customer</th>
				<td>
					<script type="text/javascript">ComComboObject('cust_tp_cd', 1, 80, 0,0,0);</script><!-- 
					 --><input type="text" name="cust_cnt_cd" id="cust_cnt_cd" style="width:30px;" class="input" value="" style="ime-mode:disabled" dataformat="enguponly"  caption="Country Code" maxlength="2" ><!--
					 --><input type="text" name="cust_seq" id="cust_seq" style="width:50px;" class="input" value="" style="ime-mode:disabled" dataformat="num"  caption="Cust Seq" maxlength="6"><!--
					 --><input type="text" name="cust_nm" id="cust_nm" style="width:70px;" class="input" value="" style="ime-mode:disabled"  dataformat='engup' maxlength="20">
				</td>
				<th>O/C Status</th>	 
				<td><select name="cnmv_sts_cd" style="width:65px;">
					<option value="" selected>All</option>
					<option value="Y">Y</option>
					<option value="N">N</option>
					</select>
				</td>
		</tr>
		</tbody>
	</table>
	
	<table> 
		<tbody>	
			<colgroup>
					<col width="80"></col>
					<col width="150"></col>
					<col width="75"></col>
					<col width="120"></col>
					<col width="53"></col>
					<col width="*"></col>
			</colgroup>		
			<tr>
				<th>Trade</th>
				<td><script type="text/javascript">ComComboObject("trd_cd", 2, 60, 0, 0, 0);</script></td>
				<th>Sub Trade</th>
				<td><script type="text/javascript">ComComboObject("sub_trd_cd", 3, 50, 0, 0, 1);</script></td>
				<th>Lane</th>
				<td><script type="text/javascript">ComComboObject("rlane_cd", 4, 80, 0, 0, 2, false);</script></td>
			</tr>
		</tbody>
	</table>
	</div>
</div>		
<!-- opus_design_inquiry(E) -->

<!-- result_area(S) -->
<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" name="mainTable" id="mainTable">
		<div class="opus_design_btn" id="sButtonTable" name="sButtonTable">
			<button type="button" class="btn_accent" name="btn_EQHistory" id="btn_EQHistory">EQ History</button>
			<button type="button" class="btn_normal" name="btn_COP" 	id="btn_COP">COP</button>
			<button type="button" class="btn_normal" name="btn_CLM"  id="btn_CLM">CLM</button>
		</div>
		<script type="text/javascript">ComSheetObject('t1sheet1');</script>
	</div>
	<div class="opus_design_grid clear" name="mainTable" id="mainTable">
		<div class="opus_design_btn" id="sButtonTable" name="sButtonTable">
			<button type="button" class="btn_normal" name="btn_Preview"  id="btn_Preview">Preview & Print</button>
		</div>
		<script type="text/javascript">ComSheetObject('t1sheet2');</script>
	</div>
	<div class="opus_design_grid clear" name="mainTable" id="mainTable">
		<div class="opus_design_btn" id="sButtonTable" name="sButtonTable">
			<button type="button" class="btn_normal" name="btn_Preview"  id="btn_Preview">Preview & Print</button>
		</div>
		<script type="text/javascript">ComSheetObject('t1sheet3');</script>
	</div>
	<!-- opus_design_grid(E) -->	
			<!-- 개발자 작업  끝 -->
</div>
</form>

<!-- 레포트  팝업  -->
<form name="form2" method="post">
	<input type="hidden" id="rfn" name="rfn"> 
	<input type="hidden" id="mrd" name="mrd"> 
	<input type="hidden" id="title" name="title"> 
	<input type="hidden" id="rp" name="rp">
	<input type="hidden" id="rv" name="rv">
</form>	