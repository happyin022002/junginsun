<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0672.jsp
*@FileTitle  : Arrival Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/20
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0672Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0672Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_email	    = "";
	String strOfc_cd    = "";
    String code = "";
    String value = "";
    String mainPage = JSPUtil.getNull(request.getParameter("mainPage"));
	Logger log = Logger.getLogger("com.clt.apps.InboundBLMgt.ArrivalNotice");
	String parAutoSearchFlg = JSPUtil.getParameter(request, "autoSearchFlg");
	String parVvd = JSPUtil.getParameter(request, "vvd");
	String parVpsEtaDtStart = JSPUtil.getParameter(request, "vps_eta_dt_start");
	String parVpsEtaDtEnd = JSPUtil.getParameter(request, "vps_eta_dt_end");
	String parPodCd = JSPUtil.getParameter(request, "pod_cd");
	String parDelCd = JSPUtil.getParameter(request, "del_cd");
	String parPolCd = JSPUtil.getParameter(request, "pol_cd");
	String parBlNo = JSPUtil.getParameter(request, "bl_no");
	String parOfcCd = JSPUtil.getParameter(request, "ofc_cd");
	String parSchTp = JSPUtil.getParameter(request, "sch_tp");
	String parTsFlg = JSPUtil.getParameter(request, "ts_flg");
	String parCustCntCd = JSPUtil.getParameter(request, "cust_cnt_cd");
	String parCustSeq = JSPUtil.getParameter(request, "cust_seq");
	String parCustNm = JSPUtil.getParameter(request, "cust_nm");
	String parCustRefNo = JSPUtil.getParameter(request, "cust_ref_no");
	String parSNo = JSPUtil.getParameter(request, "sc_no");
	String parEvalFlg = JSPUtil.getParameter(request, "is_validated");
	String parPgmNo = JSPUtil.getParameter(request, "pgmNo");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	    strUsr_email = account.getUsr_eml();
	    strOfc_cd = account.getOfc_cd();
		event = (EsmBkg0672Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	    code = eventResponse.getETCData("code");
	    value = eventResponse.getETCData("value");
	    
	}catch(Exception e) {
		out.println(e.toString());
	} 
%>
<script type="text/javascript">
    var strUsr_nm    = "<%=strUsr_nm %>";
    var strUsr_email = "<%=strUsr_email %>";
    var strOfc_cd    = "<%=strOfc_cd %>";
    var evtCode = "|<%=code %>";
    var evtValue = " |<%=value %>";
    var parAutoSearchFlg = "<%=parAutoSearchFlg%>";
    var parVvd   = "<%=parVvd%>";
    var parVpsEtaDtStart = "<%=parVpsEtaDtStart %>";
    var parVpsEtaDtEnd = "<%=parVpsEtaDtEnd %>";
    var parPodCd = "<%=parPodCd%>";
    var parDelCd = "<%=parDelCd%>";
    var parPolCd = "<%=parPolCd%>";
    var parBlNo  = "<%=parBlNo%>";
    var parOfcCd = "<%=parOfcCd%>";
    var parSchTp = "<%=parSchTp %>";
    var parTsFlg = "<%=parTsFlg %>";
	var parCustCntCd = "<%=parCustCntCd %>";
	var parCustSeq = "<%=parCustSeq %>";
	var parCustNm = "<%=parCustNm %>";
	var parCustRefNo = "<%=parCustRefNo%>";
	var parSNo = "<%=parSNo%>";
    var parEvalFlg = "<%=parEvalFlg %>";
    var parPgmNo = "<%=parPgmNo%>";
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        loadPage();
    }
    function rdchk(a){
    	if(a=='V'){
    		$("input:radio[name='sch_tp']:radio[value='V']").prop("checked",true);
    		return true;
    	}else if(a=='D'){
    		$("input:radio[name='sch_tp']").removeAttr("checked");
    		$("input:radio[name='sch_tp']:radio[value='D']").prop("checked",true);
    		return true;
    	}else if(a=='B'){
    		$("input:radio[name='sch_tp']").removeAttr("checked");
    		$("input:radio[name='sch_tp']:radio[value='B']").prop("checked",true);
    		return true;
    	}
    	
    }
</script>
        
<form name="form" id="form">
<input name="f_cmd" type="hidden" id="f_cmd" />
<input type="hidden" name="pagerows" value="<%=pageRows%>" id="pagerows" />
<input type="hidden" name="vvd0243list" value="" id="vvd0243list" />
<input type="hidden" name="an_seq" value="" />
<input type="hidden" name="strUsr_nm" value="" />
<input type="hidden" name="strUsr_email" value="" />
<input type="hidden" name="strOfc_cd" value="" />
<input type="hidden" name="gw_subject" value="Customer Code Request">
<input type="hidden" name="gw_contents" valule="" >
<!-- <input type="hidden" name="gw_template" value="template.htmlmail"> -->
<input type="hidden" name="gw_args" value="name;" />
<input type="hidden" name="gw_args" value="" />

<!-- page_title_area(S) -->
<% if (!mainPage.equals("true")) { %>
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Arrival Information ( ESM_BKG_0672-01 )</span></h2>
<%}else{%>
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
<% } %>
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--
	--><button type="button" class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve">Retrieve</button><!--  
	--><button type="button" class="btn_normal" name="btn_DownExcel" 		id="btn_DownExcel">Down Excel</button><!--  
	--><button type="button" class="btn_normal" name="btn_Save" 			id="btn_Save">Save</button><!--  		
	--><button type="button" class="btn_normal" name="btn_code_validate" 	id="btn_code_validate">Code Validate</button><!--  		
	--><button type="button" class="btn_normal" name="btn_template" 		id="btn_template">Template</button><!--  		
	--><button type="button" class="btn_normal" name="btn_ANSend" 			id="btn_ANSend">A/N Send</button><!--
	--><% if (!mainPage.equals("true")) { %><!-- 
		--><button type="button" class="btn_normal" name="btn_Close" 	id="btn_Close">Close</button>
		<% } %>
		</div>
	<!-- opus_design_btn(E) -->

<% if (!mainPage.equals("true")) { %>	
	</div>
</div>
<%}else{%>
	<!-- opus_design_btn(E) -->	
	<div class="location">
        <!-- location 내용 동적생성 (별도 코딩 불필요) -->
        <span id="navigation"></span>
    </div>
</div>
<% } %>
<!-- page_title_area(E) -->

<%if (!mainPage.equals("true")) { %><div class="layer_popup_contents"><%}%>
<!-- wrap_area(S) -->
<div class="wrap_search_tab">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="130"/>
				<col width="50"/>
				<col width="80"/>
				<col width="30"/>
				<col width="50"/>
				<col width="80"/>
				<col width="30"/>
				<col width="50"/>
				<col width="10"/>
				<col width="30"/>
				<col width="80"/>
				<col width="80"/>
				<col width="100"/>
				<col width="*" />
			</colgroup>
			<tr>
				<td class="sm pad_left_4"><input type="radio" value="V" class="trans" name="sch_tp" id="sch_tp"  checked><strong>VVD</strong>  <input type="text" style="width:80px;" class="input1" name="vvd" id="vvd" caption="vvd" value="" maxlength="9" size="9" style="ime-mode:disabled" dataformat="engup" onFocus="javascript:rdchk('V');"></td>
				<td class="sm"><input type="radio" value="D" name="sch_tp" id="sch_tp" class="trans"><strong>POD ETA</strong></td>
				<td class="sm"><input type="text" style="width:75px" dataformat="ymd" minlength="8" maxlength="8" value="" class="input1" caption="Duration Start Date" name="vps_eta_dt_start" id="vps_eta_dt_start" style="width:100;ime-mode:disabled" onFocus="javascript:rdchk('D');">~ <input type="text" style="width:75px" dataformat="ymd" minlength="8" maxlength="8" value="" class="input1" name="vps_eta_dt_end" id="vps_eta_dt_end" caption="Duration End Date" style="ime-mode:disabled" onFocus="javascript:rdchk('D');"><button type="button" class="calendar ir" name="eta_dt_end" id="eta_dt_end" ></button></td>
				<th class="sm">POD</th>
				<td class="sm"><input type="text" style="width:50px;" class="input1" value="" name="pod_cd" id="pod_cd" caption="POD" maxlength="5" style="ime-mode:disabled" dataformat="engup" fullfill /></td>
				<td class="sm"><strong>T/S</strong>  <input type="checkbox" value="Y" name="ts_flg" id="ts_flg" caption="T/S" class="trans"></td>
				<th class="sm">DEL</th>
				<td class="sm"><input type="text" style="width:50px;" class="input" value="" name="del_cd" id="del_cd" caption="DEL" minlength="2" maxlength="5" style="ime-mode:disabled" dataformat="engup"  ></td>
				<td></td>
				<th title="Port of Loading">POL</th>
				<td><input type="text" style="width:50px;" class="input" value="" name="pol_cd" id="pol_cd" caption="POL" minlength="5" maxlength="5" style="ime-mode:disabled" dataformat="engup" /></td>
				<td class="sm pad_left_4"><input type="radio" value="B" class="trans" name="sch_tp" id="sch_tp" >  <strong>B/L No.</strong></td>
				<td class="sm"><input type="text" style="width:100px;" class="input1" value="" name="bl_no"  id="bl_no" caption="B/L No." maxlength="12" style="ime-mode:disabled" dataformat="engup" onFocus="javascript:rdchk('B');"></td>						
				<td></td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="50"/>
				<col width="80"/>
				<col width="50"/>
				<col width="30"/>
				<col width="50"/>
				<col width="220"/>
				<col width="50"/>
				<col width="100"/>
				<col width="50"/>
				<col width="40"/>
				<col width="*" />				
			</colgroup>
		<tr>
			<th>Evaluated</th>
			<td><select name="is_validated" id="is_validated" class="input1"><option value="">All</option><option value="Y">Yes</option><option value="N">No</option></select></td>
			<th>Customer Code</th>
			<td><input type="text" style="width:30px;" class="input" value="" name="cust_cnt_cd" id="cust_cnt_cd" caption="Customer Code" style="ime-mode:disabled" dataformat="engup" size="2" maxlength="2" /><input type="text" style="width:50px;" class="input" value="" name="cust_seq" id="cust_seq" caption="Customer Code" dataformat="num"  maxlength="6" style="ime-mode:disabled"/></td>
			<th>Customer Name</th>
			<td><input type="text" style="width:190px;" class="input" name="cust_nm" id="cust_nm" value="" caption="Customer Name" maxlength="500"  dataformat="engup" otherchar=" "/></td>
			<th>P/O No.</th>
			<td><input type="text" style="width:80px;" class="input" value="" name="cust_ref_no" id="cust_ref_no" caption="P/O No." maxlength="500" style="ime-mode:disabled" /></td>
			<th>S/C No.</th>
			<td><input type="text" style="width:110px;" class="input" value="" name="sc_no" id="sc_no" caption="S/C No." maxlength="11" style="ime-mode:disabled" dataformat="engup" ></td>
			<td></td>
		</tr>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_area(E) -->

<!-- result_area(S) -->
<div class="wrap_result">
	
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" style="display:inline;" name="tabLayer" id="tabLayer">
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_t2set" 		id="btn_t2set">Set Data</button>
			<button type="button" class="btn_normal" name="btn_t2cus" 		id="btn_t2cus">Customer& Info.</button>		
		</div>
		<script type="text/javascript">ComSheetObject('t2sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" style="display:none;" name="tabLayer" id="tabLayer">
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_t3cust" 		id="btn_t3cust">Customer& Info.</button>		
			<button type="button" class="btn_normal" name="btn_t3multi_contact" 		id="btn_t3multi_contact">Multi-Contact</button>
			<button type="button" class="btn_normal" name="btn_t3master" 		id="btn_t3master">Master Data</button>	
		</div>
		<script type="text/javascript">ComSheetObject('t3sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" style="width:98%; display:none;" name="tabLayer" id="tabLayer">
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_t4downExcel" 		id="btn_t4downExcel">Down Excel</button>		
			<button type="button" class="btn_normal" name="btn_t4uploadExcel" 		id="btn_t4uploadExcel">Upload Excel</button>
		</div>
		<script type="text/javascript">ComSheetObject('t4sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" style="display:none;" name="tabLayer" id="tabLayer">
		<script type="text/javascript">ComSheetObject('t4sheet2');</script>
		<script type="text/javascript">ComSheetObject('t1sheet3');</script>
		<script type="text/javascript">ComSheetObject('t1sheet4');</script>
	</div>
	<!-- opus_design_grid(E) -->
	
</div>
<%if (!mainPage.equals("true")) { %></div><%}%>
<!-- result_area(E) -->
</form> 