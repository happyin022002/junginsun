<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0240.jsp
*@FileTitle  : Integrated Customer Data Management 
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
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0240Event"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
	EsmBkg0240Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from the server
	String strErrMsg = "";						//error messege
	int rowCount	 = 0;						//the number of DB ResultSet List
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd    = "";
	String req_cust_cnt_cd = "";
	String req_cust_seq = "";
	String autoSearchFlg = "";
    String code = "";
    String value = "";
    String statusCode = "";
    String statusValue = "";
    String mainPage 		= "";
    String menuflag 		= "";
    Logger log = Logger.getLogger("com.clt.apps.InboundBLMgt.ArrivalNotice");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	mainPage = request.getParameter("mainPage");
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		req_cust_cnt_cd = JSPUtil.getNull(request.getParameter("cust_cnt_cd"));
		req_cust_seq = JSPUtil.getNull(request.getParameter("cust_seq"));
		autoSearchFlg = JSPUtil.getNull(request.getParameter("autoSearchFlg"));
		event = (EsmBkg0240Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		//  extract additional data obtained from the server during Initial loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        code = eventResponse.getETCData("code");
        value = eventResponse.getETCData("value");
        statusCode = eventResponse.getETCData("status_code");
        statusValue = eventResponse.getETCData("status_value");
	} catch(Exception e) {
		out.println(e.toString());
	}
%>
  <style type="text/css">

/* btn_etc_red */
.btn_etc_red{
    position:relative;
    padding:5px 10px 5px;
    border-width:1px;
    border-style:solid;
    text-align:center;line-height:14px
}
.btn_etc_red:after{
    display:block;content:" ";
    position:absolute;top:0;left:0;right:0;bottom:0;
    box-sizing:border-box;-moz-box-sizing:border-box;-webkit-box-sizing:border-box;
    border-width:1px;
    border-style:solid;
}
.btn_etc_red {height:25px;box-sizing:border-box;-moz-box-sizing:border-box;-webkit-box-sizing:border-box}
.btn_etc_red {border-color:#b7d6f8;background-color:#dceeff;color:red!important;border-radius:3px; }
.btn_etc_red:after {border-color:#eff8fd!important;}

/* btn_etc_blue */
.btn_etc_blue{
    position:relative;
    padding:5px 10px 5px;
    border-width:1px;
    border-style:solid;
    text-align:center;line-height:14px
}
.btn_etc_blue:after{
    display:block;content:" ";
    position:absolute;top:0;left:0;right:0;bottom:0;
    box-sizing:border-box;-moz-box-sizing:border-box;-webkit-box-sizing:border-box;
    border-width:1px;
    border-style:solid;
}
.btn_etc_blue {height:25px;box-sizing:border-box;-moz-box-sizing:border-box;-webkit-box-sizing:border-box}
.btn_etc_blue {border-color:#b7d6f8;background-color:#dceeff;color:#2c6ed1!important;border-radius:3px; }
.btn_etc_blue:after {border-color:#eff8fd!important;}
    
  </style>

<script type="text/javascript">
    var autoSearchFlg = "<%=autoSearchFlg%>";
    var sessOfcCd = "<%=strOfc_cd%>";
	var evtCode = "<%=code %>|";
	var evtValue = "<%=value %>|";
	var evtStatusCode = "<%=statusCode %>|";
	var evtStatusValue = "<%=statusValue %>|";
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        loadPage();
    }
</script>

<form name="form" id="form">
<input name="f_cmd" id="f_cmd" type="hidden" />
<input name="pagerows" id="pagerows" type="hidden" />
<input name="login_ofc_cd" id="login_ofc_cd" type="hidden" value="<%=strOfc_cd%>"/>

<%
	if (!"true".equals(mainPage))
	{
%>
	<div class="layer_popup_title">
		<div class="page_title_area clear">
			<h2 class="page_title"><span>Customer Master Data</span></h2>
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
				--><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!--  
				--><span name="inq"><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button></span><!--  
				--><button type="button" class="btn_normal" name="t1btn_SettingAN" id="t1btn_SettingAN">Setup A/N</button><!--
				--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close" onClick="self.close()" >Close</button>
			</div>
			<!-- opus_design_btn(E) -->
		</div>
	</div>
<%
	}else{
%>
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
		
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!--  
		--><span name="inq"><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button></span><!--  
		--><button type="button" class="btn_normal" name="t1btn_SettingAN" id="t1btn_SettingAN">Setup A/N</button>
	</div>
	<!-- opus_design_btn(E) -->
<%}%>

	<%
		if ("true".equals(mainPage))
		{
	%>
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>	
	<%}%>

<!-- page_title_area(E) -->

<%
	if (!"true".equals(mainPage))
	{
%>
<div class="layer_popup_contents">
<%} %>
<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
<div class="opus_design_inquiry">
	<table>
		<tbody>
			<colgroup>
				<col width="120"/>
				<col width="90"/>
				<col width="20"/>
				<col width="135"/>
				<col width="130"/>
				<col width="100"/>
				<col width="40"/>
				<col width="10"/>
				<col width="60"/>
				<col width="80"/>
				<col width="40"/>
				<col width="60"/>
				<col width="40"/>
				<col width="*" />
			</colgroup>
			<tr>
				<th class="sm pad_left_4"><input type="radio" value="" class="trans" name="sel_radio" id="sel_radio1" onClick="fncSelRadioChange()" checked><label for="sel_radio1">Customer Code</label></th>
				<td class="sm"><!--
				--><input type="text" style="width: 30px; ime-mode:disabled;" dataformat="enguponly" value="<%=req_cust_cnt_cd %>" name="cust_cnt_cd" id="cust_cnt_cd" maxlength="2" onKeyPress="ComKeyOnlyAlphabet('upper');" onKeyDown="ComKeyEnter(this)" fullfill required="true" onClick="form.sel_radio[0].checked=true;fncSelRadioChange()"><!--
				--><input type="text" style="width: 50px;" value="<%=req_cust_seq %>" name="cust_seq" id="cust_seq" dataformat="num" maxlength="6" onBlur="fncCustSeqBlur(this)" onKeyDown="ComKeyEnter(this)" style="ime-mode:disabled" required="true" onKeyPress="ComKeyOnlyNumber(this)" onClick="form.sel_radio[0].checked=true;fncSelRadioChange()">
				</td>
				<td></td>
				<th class="sm pad_left_8"><input type="radio" value="" class="trans"  name="sel_radio" id="sel_radio2" onClick="fncSelRadioChange()"><!--
				--><label for="sel_radio2">Customer Name</label></th>
				<td class="sm"><!--
				--><input type="text" style="width: 120px; ime-mode:disabled" dataformat="engup" name="cust_lgl_eng_nm" id="cust_lgl_eng_nm" dataformat="engup" otherchar="()_\-,. ^&()'" value="" onClick="form.sel_radio[1].checked=true;fncSelRadioChange()" onKeyDown="ComKeyEnter(this)" minlength="2"></td>
				<th class="sm">Country Code</th>
				<td class="sm"><input type="text" style="width: 30px; ime-mode:disabled;"  value="" name="cust_cnt_cd_ext" id="cust_cnt_cd_ext" maxlength="2" dataformat="enguponly" onClick="form.sel_radio[1].checked=true;fncSelRadioChange()" onKeyPress="ComKeyOnlyAlphabet('upper','32')" onKeyDown="ComKeyEnter(this)"></input></td>
				<td></td>
				<th>S/Office</th>
				<td><input type="text" style="width: 70px;"  value="" name="ofc_cd" id="ofc_cd" dataformat="engup" onKeyDown="ComKeyEnter(this)"></td>
				<th>State</th>
				<td><input type="text" style="width: 40px;"  value="" name="ste_cd" id="ste_cd" dataformat="engup" onKeyDown="ComKeyEnter(this)"></td>
				<th style="visibility: hidden;">Status</th>
				<td><select style="width: 100px;visibility: hidden;" name="cust_sts_cd" id="cust_sts_cd" onKeyDown="ComKeyEnter(this)"></select></td>
			</tr>
			<tr></tr>
		</tbody>
	</table>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid">
		<h3 class="title_design">Customer Main (MDA)</h3>
	</div>                                
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>   
  
<!-- opus_design_inquiry(E) -->

<!-- <table class="line_bluedot"><tr><td colspan="8"></td></tr></table> -->

<!-- <div class= "wrap_result">
	<div class="opus_design_inquiry">
		<h3 class="title_design">Customer Main (MDA)</h3>
	</div>                                
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>                           
</div>
 -->
<!-- opus_tab_btn(S) -->

<div class="opus_design_tab">
	<script type="text/javascript">ComTabObject('tab1')</script>
</div>
<!-- opus_tab_btn(E) -->

			
<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="10px"/>
					<col width="40px"/>
					<col width="250px"/>
					<col width="10px"/>
					<col width="30px"/>
					<col width="100px"/>
					<col width="20px"/>
					<col width="300px"/>
					<col width="*" />
				</colgroup>
				<tr class="h23" align="left">
					<td></td>
					<td style="font-weight: bold;" class="sm">Customer</td>
					<td class="sm"><!--
					--><input type="text" style="width: 30px;" class="input2" value="" name="cust_cnt_cd_ib" id="cust_cnt_cd_ib" disabled="disabled"><!--
					--><input type="text" style="width: 60px;" class="input2" value="" name="cust_seq_ib" id="cust_seq_ib" disabled="disabled"><!--
					--><input type="text" style="width: 150px;" class="input2" value="" name="cust_lgl_eng_nm_ib" id="cust_lgl_eng_nm_ib" disabled="disabled">
					</td>
					<td class="sm"></td>
					<td style="font-weight: bold;" class="sm">Office</td>
					<td class="sm"><!--
					--><input type="text" style="width: 70px;" dataformat="enguponly" value="" name="ofc_cd_ib" id="ofc_cd_ib" onKeyPress="ComKeyOnlyAlphabet('upper');" onKeyDown="ComKeyEnter('fncSearchIb')" maxlength="5"><!--
					--><button type="button" class="btn_etc" name="btn_Retrieve_Ib" id="btn_Retrieve_Ib">Retrieve</button>
					</td>
					<td></td>
					<td><!--
					--><button type="button" class="btn_etc" name="btn_FullUpdatedHistory" id="btn_FullUpdatedHistory">Full Updated History</button><!--
					--><button type="button" class="btn_etc" name="btn_CustomersClearanceType" id="btn_CustomersClearanceType">Customer's Clearance Type</button><!--
					--><button type="button" class="btn_etc" name="btn_ConcernedParty" id="btn_ConcernedParty">Multi-Contact</button><!--
					--><button type="button" class="btn_etc" name="btn_UpdateSetup" id="btn_UpdateSetup">Setup</button>
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
	<script type="text/javascript">ComSheetObject('t1sheet');</script>
</div>

<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="10px"/>
					<col width="40px"/>
					<col width="250px"/>
					<col width="*" />
				</colgroup>
				<tr class="h23" align="left">
					<td></td>
					<td style="font-weight: bold;" class="sm">Customer</td>
					<td class="sm"><!--
					--><input type="text" style="width: 30px;" class="input2" value="" name="cust_cnt_cd_ob" id="cust_cnt_cd_ob" disabled="disabled"><!--
					--><input type="text" style="width: 60px;" class="input2" value="" name="cust_seq_ob" id="cust_seq_ob" disabled="disabled"><!--
					--><input type="text" style="width: 150px;" class="input2" value="" name="cust_lgl_eng_nm_ob" id="cust_lgl_eng_nm_ob" disabled="disabled">
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
	<script type="text/javascript">ComSheetObject('t2sheet');</script>
</div>

<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="10px"/>
					<col width="40px"/>
					<col width="250px"/>
					<col width="*" />
				</colgroup>
				<tr class="h23" align="left">
					<td></td>
					<td style="font-weight: bold;" class="sm">Customer</td>
					<td class="sm"><!--
					--><input type="text" style="width: 30px;" class="input2" value="" name="cust_cnt_cd_invoice" id="cust_cnt_cd_invoice" disabled="disabled"><!--
					--><input type="text" style="width: 60px;" class="input2" value="" name="cust_seq_invoice" id="cust_seq_invoice" disabled="disabled"><!--
					--><input type="text" style="width: 150px;" class="input2" value="" name="cust_lgl_eng_nm_invoice" id="cust_lgl_eng_nm_invoice" disabled="disabled">
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
	<script type="text/javascript">ComSheetObject('t3sheet');</script>
</div>


<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="10px"/>
					<col width="40px"/>
					<col width="250px"/>
					<col width="*" />
				</colgroup>
				<tr class="h23" align="left">
					<td></td>
					<td style="font-weight: bold;" class="sm">Customer</td>
					<td class="sm"><!--
					--><input type="text" style="width: 30px;" class="input2" value="" name="cust_cnt_cd_tro" id=cust_cnt_cd_tro disabled="disabled"><!--
					--><input type="text" style="width: 60px;" class="input2" value="" name="cust_seq_tro" id="cust_seq_tro" disabled="disabled"><!--
					--><input type="text" style="width: 150px;" class="input2" value="" name="cust_lgl_eng_nm_tro" id="cust_lgl_eng_nm_tro" disabled="disabled">
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
	<script type="text/javascript">ComSheetObject('t4sheet');</script>
</div>
</div>
<%
	if (!"true".equals(mainPage))
	{
%>
</div>
<%} %>
</form> 