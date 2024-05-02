<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : cps_cni_0009.jsp
*@FileTitle  : Handling Costs
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/16
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@page import="com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.event.CpsCni0009Event"%>
<%@page import="com.clt.apps.opus.cps.cni.common.CniUtil"%>
<%@page import="com.clt.framework.component.util.io.HttpUtil"%>
<%
	CpsCni0009Event event = null;
    Exception serverException = null;
    String strErrMsg = "";
    int rowCount = 0;

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String userId = "";
    String userName = "";
    String userOffice = "";
    String userArea = "";
	String userCgoClmNo = "";//session claimNo 변수
	String reqCgoClmNo = "";

    Logger log = Logger.getLogger("com.clt.apps.opus.cps.cni.containercargoclaim.ContainerCargoClaimSC");
	String xml = HttpUtil.makeXML(request,response);
	SignOnUserAccount account = null;

    try
    {
    	reqCgoClmNo  = JSPUtil.getParameter(request, "cgo_clm_no","");

        account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();
        
      //session start
		if(!reqCgoClmNo.equals("")){//req 있으면 req claimNo 로 세팅.
			userCgoClmNo = reqCgoClmNo;
		}else{//req 없으면 session 에 있는지 체크.
			if(!CniUtil.getCargoClaimNo(account).equals("")){//session 에 있으면 session 값으로 세팅
				userCgoClmNo = CniUtil.getCargoClaimNo(account);
			}
		}

		userCgoClmNo = CniUtil.getCargoClaimNo(account);
		//session end

        event = (CpsCni0009Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }
    catch (Exception e)
    {
        out.println(e.toString());
    }

    // ----------------------------------------------------------------
    // 해당 초기 파라미터 설정
    // ----------------------------------------------------------------
    String popupYn = JSPUtil.getParameter(request , "popupYn" , "N");
    
    // 사용자 roles
    String roles = CniUtil.getRoles(account);
    String area =  CniUtil.getAreaInfo(account);
    String ofcCd = account.getOfc_cd(); 
    
    //roles = "CNI01,CNI03";
    //area =  "H";
    //ofcCd = "GOABB";
    //userId = "003997933";     
%>
<%@page import="com.clt.apps.opus.cps.gem.common.GemUtil"%>
<%@page import="com.clt.framework.component.util.StringUtil"%>

<script type="text/javascript">
function setupPage(){
	var errMessage = "<%=strErrMsg%>";
	if (errMessage.length >= 1) {
		showErrMessage(errMessage);
	} // end if
	loadPage();
}
</script>

        <% if ("Y".equals(popupYn)) {%><!-- pop up 과 main 의 디자인이 if else 로 처리되었으니 항목추가시 주의. -->

<form name="form2">
<input type="hidden" name="sXml" value="<%=xml%>" id="sXml" />
</form>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />

<input type="hidden" name="usr_id" value="<%=userId%>" id="usr_id" readonly="readonly"/>
<input type="hidden" name="usr_roles" value="<%=roles%>" id="usr_roles" readonly="readonly"/>
<input type="hidden" name="usr_area" value="<%=area%>" id="usr_area" readonly="readonly"/>
<input type="hidden" name="usr_office" value="<%=ofcCd%>" id="usr_office" readonly="readonly"/>

<!-- 개발자 작업 -->
<input type="hidden" name="cgo_clm_no_old" value="" id="cgo_clm_no_old" />
<input type="hidden" name="cgo_clm_sts_cd" value="" id="cgo_clm_sts_cd" />
<input type="hidden" name="clm_stl_auth_no" value="" id="clm_stl_auth_no" />

<!-- 권한체크위한 변수 -->
<input type="hidden" name="hdlr_usr_id" id="hdlr_usr_id" />
<input type="hidden" name="hdlr_ofc_cd" id="hdlr_ofc_cd" />

<!-- POPUP 용도로 사용시 -->
<input type="hidden" name="popupYn" value="<%=popupYn%>" id="popupYn" readonly="readonly"/>
       <% } else { %>
       
<form name="form2">
<input type="hidden" name="sXml" value="<%=xml%>" id="sXml" />
</form>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />

<input type="hidden" name="usr_id" value="<%=userId%>" id="usr_id" readonly="readonly"/>
<input type="hidden" name="usr_roles" value="<%=roles%>" id="usr_roles" readonly="readonly"/>
<input type="hidden" name="usr_area" value="<%=area%>" id="usr_area" readonly="readonly"/>
<input type="hidden" name="usr_office" value="<%=ofcCd%>" id="usr_office" readonly="readonly"/>

<!-- 개발자 작업 -->
<input type="hidden" name="cgo_clm_no_old" value="" id="cgo_clm_no_old" />
<input type="hidden" name="cgo_clm_sts_cd" value="" id="cgo_clm_sts_cd" />
<input type="hidden" name="clm_stl_auth_no" value="" id="clm_stl_auth_no" />

<!-- 권한체크위한 변수 -->
<input type="hidden" name="hdlr_usr_id" id="hdlr_usr_id" />
<input type="hidden" name="hdlr_ofc_cd" id="hdlr_ofc_cd" />
        <% } %>


<!-- page_title_area(S) -->
<div class="page_title_area clear ">

<% if ("Y".equals(popupYn)) {%>
	<!-- page_title(S) -->
	<h2 class="page_title">Handling Costs</h2>
	<!-- page_title(E) -->
<% }else{ %>	
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
<% } %>	
		<!-- opus_design_btn (S) -->
			<div class="opus_design_btn">
				<button class="btn_accent" name="btn1_Retrieve" id="btn1_Retrieve" type="button">Retrieve</button><!--
				--><button class="btn_normal" name="btn1_New" id="btn1_New" type="button">New</button><!--
				--><button class="btn_normal" name="btn1_Save" id="btn1_Save" type="button">Save</button><!--
				--><% if ("Y".equals(popupYn)) {%><button class="btn_normal" name="btn1_close" id="btn1_close" type="button">Close</button><!--
				--><% } %></div>
			<!-- opus_design_btn (E) -->
<% if (!"Y".equals(popupYn)) {%>	
	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
<% } %>		
	
	
</div>
<!-- page_title_area(E) -->


<!-- wrap_area(S) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="70px">
				<col width="50px">
				<col width="170px">
				<col width="50px">
				<col width="65px">
				<col width="135px">
				<col width="150px">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Claim No.</th>
					<td><input type="text" dataformat="engup" name="cgo_clm_no" caption="Claim No" required="" maxlength="10" style="width:100px;text-align:center" class="input1" value="<%=userCgoClmNo%>" id="cgo_clm_no" /><input type="text" name="clm_area_cd" style="width:35px;text-align:center" class="input2" value="" id="clm_area_cd" /></td>
					<th>Status</th>
					<td><input type="text" name="clm_misc_nm" style="width:80px;text-align:center" class="input2" value="" id="clm_misc_nm" /> </td>
					<th title="Date of Case Closed">DOC</th>
					<td><input type="text" name="cs_clz_dt" style="width:80px;text-align:center" class="input2" value="" id="cs_clz_dt" /> </td>
					<th title="Type Of Settlement">TOS</th>
					<td><input type="text" name="cgo_clm_stl_tp_cd" style="width:40px;text-align:center" class="input2" value="" id="cgo_clm_stl_tp_cd" /> </td>
				</tr> 
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="70px">
				<col width="50px">
				<col width="56px">
				<col width="50px">
				<col width="350px">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Claimant</th>
					<td><input type="text" name="pty_nm" style="width:253px;" class="input2" value="" id="pty_nm" /> </td>
					<th title="Date of Notice of Preliminary Claim">DON</th>
					<td><input type="text" name="prlm_clm_ntc_dt" dataformat="ymd" style="width:80px;text-align:center" class="input2" value="" id="prlm_clm_ntc_dt" /> </td>
					<th>Summons Served Date</th>
					<td><input type="text" name="smns_sve_dt" dataformat="ymd" style="width:80px;text-align:center" class="input2" value="" id="smns_sve_dt" /> </td>
				</tr> 
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="101px">
				<col width="50px">
				<col width="56px">
				<col width="50px">
				<col width="168px">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Claim Amount</th>
					<td><input type="text" name="clmt_locl_amt" dataformat="float" readonly style="width:180px;text-align:right" class="input2" value="" id="clmt_locl_amt" /><input type="text" name="clmt_locl_curr_cd" style="width:38px;text-align:center" class="input2" value="" id="clmt_locl_curr_cd" /> </td>
					<th title="Rate Of Exchange">R.O.E</th>
					<td><input type="text" name="clmt_locl_xch_rt" dataformat="float" readonly style="width:80px;text-align:right" class="input2" value="" id="clmt_locl_xch_rt" /><input type="text" name="clmt_usd_amt" dataformat="float" readonly style="width:146px;text-align:right" class="input2" value="" id="clmt_usd_amt" />  USD</td>
					<th title="Date Of Formal Claim">DOF</th>
					<td><input type="text" name="fmal_clm_rcv_dt" dataformat="ymd" style="width:80px;text-align:center" class="input2" value="" id="fmal_clm_rcv_dt" /> </td>
				</tr>
				<tr>
					<th>Settled Amount </th>
					<td><input type="text" name="cgo_clm_stl_locl_amt" dataformat="float" readonly style="width:180px;text-align:right" class="input2" value="" id="cgo_clm_stl_locl_amt" /><input type="text" name="cgo_clm_stl_locl_curr_cd" style="width:38px;text-align:center" class="input2" value="" id="cgo_clm_stl_locl_curr_cd" /> </td>
					<th title="Rate Of Exchange">R.O.E</th>
					<td><input type="text" name="cgo_clm_stl_xch_rt" dataformat="float" readonly style="width:80px;text-align:right" class="input2" value="" id="cgo_clm_stl_xch_rt" /><input type="text" name="cgo_clm_stl_usd_amt" dataformat="float" readonly style="width:146px;text-align:right" class="input2" value="" id="cgo_clm_stl_usd_amt" />  USD</td>
				    <th title="Date Of Settlement">DOS</th>
					<td><input type="text" name="cgo_clm_stl_dt" dataformat="ymd" style="width:80px;text-align:center" class="input2" value="" id="cgo_clm_stl_dt" /> </td>
				</tr>
			</tbody>
		</table>
	<!-- opus_design_inquiry(E) -->
	</div>
</div>
<!-- wrap_area(E) -->

<!-- result_area(S) -->
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<!-- opus_design_btn (S) -->
			<div class="opus_design_btn">
				<button class="btn_accent" name="btn2_Row_Add" id="btn2_Row_Add" type="button">Row&nbsp;Add</button><!--
				--><button class="btn_normal" name="btn2_Row_Copy" id="btn2_Row_Copy" type="button">Row Copy</button><!--
				--><button class="btn_normal" name="btn2_Row_Delete" id="btn2_Row_Delete" type="button">Row&nbsp;Delete</button><!--
				--><button class="btn_normal" name="btn2_Down_Excel" id="btn2_Down_Excel" type="button">Down Excel</button><!--
				--><button class="btn_normal" name="btn2_Load_Excel" id="btn2_Load_Excel" type="button">Load Excel</button><!--
				--></div>
				<!-- opus_design_btn (E) -->
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- result_area(E) -->
</form>
