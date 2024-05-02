<%/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_cni_0009.jsp
 *@FileTitle : [cps_cni_0009] Handling Costs
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.07
 *@LastModifier : 양정란
 *@LastVersion : 1.0
 * 2009.04.17 양정란
 * 1.0 Creation
 *------------------------------------------------------------
 * History
 * 2011.06.29 Ticket ID : [선조치]
 * 제 목 : Claim Amount등 체크 로직 제거
 * 내 용 : Claim Amount, Settled Amount 소숫점 체크 로직 제거
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@page import="com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.event.CpsCni0009Event"%>
<%@page import="com.hanjin.apps.alps.cps.cni.common.CniUtil"%>
<%@page import="com.hanjin.framework.component.util.io.HttpUtil"%>
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

    Logger log = Logger.getLogger("com.hanjin.apps.alps.cps.cni.containercargoclaim.ContainerCargoClaimSC");
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


<%@page import="com.hanjin.apps.alps.cps.gem.common.GemUtil"%>
<%@page import="com.hanjin.framework.component.util.StringUtil"%>

<html>
<head>
<title>Handling Costs</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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

        <% if ("Y".equals(popupYn)) {%><!-- pop up 과 main 의 디자인이 if else 로 처리되었으니 항목추가시 주의. -->

<body class="popup_bg" onLoad="setupPage();">
<form name="form2">
<input type="hidden" name="sXml" value="<%=xml%>">
</form>
<form name="form">
<input type="hidden" name="f_cmd">

<input type="hidden" name="usr_id" value="<%=userId%>">
<input type="hidden" name="usr_roles" value="<%=roles%>">
<input type="hidden" name="usr_area" value="<%=area%>">
<input type="hidden" name="usr_office" value="<%=ofcCd%>">

<!-- 개발자 작업 -->
<input type="hidden" name="cgo_clm_no_old" value="">
<input type="hidden" name="cgo_clm_sts_cd" value="">
<input type="hidden" name="clm_stl_auth_no" value=""><!-- Settlement Type 선택시 INV_NO -->

<!-- 권한체크위한 변수 -->
<input type="hidden" name="hdlr_usr_id">
<input type="hidden" name="hdlr_ofc_cd">

<!-- POPUP 용도로 사용시 -->
<input type="hidden" name="popupYn" value="<%=popupYn%>">
        <table width="100%" class="popup" cellpadding="10" border="0">
        <tr><td class="top"></td></tr>
       <% } else { %>
       
<body  onLoad="setupPage();">
<form name="form2">
<input type="hidden" name="sXml" value="<%=xml%>">
</form>
<form name="form">
<input type="hidden" name="f_cmd">

<input type="hidden" name="usr_id" value="<%=userId%>">
<input type="hidden" name="usr_roles" value="<%=roles%>">
<input type="hidden" name="usr_area" value="<%=area%>">
<input type="hidden" name="usr_office" value="<%=ofcCd%>">

<!-- 개발자 작업 -->
<input type="hidden" name="cgo_clm_no_old" value="">
<input type="hidden" name="cgo_clm_sts_cd" value="">
<input type="hidden" name="clm_stl_auth_no" value=""><!-- Settlement Type 선택시 INV_NO -->

<!-- 권한체크위한 변수 -->
<input type="hidden" name="hdlr_usr_id">
<input type="hidden" name="hdlr_ofc_cd">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
        <% } %>
<tr>
<td valign="top">

    <!--Page Title, Historical (S)-->
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <% if ("Y".equals(popupYn)) { %>
        

<!-- POPUP 용도로 사용시 -->
<input type="hidden" name="popupYn" value="<%=popupYn%>">
        <tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">  Handling Costs</td></tr>
        <% } else { %>
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
        <% } %>

    </table>
    <!--Page Title, Historical (E)-->

		<!--biz page (S)-->

<table class="search" id="mainTable">
    <tr><td class="bg">
			<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="70">Claim No.</td>
					<td width="280"><input type="text" name="cgo_clm_no" caption="Claim No" required maxlength="10" style="width:100;text-align:center" class="input1" value="<%=userCgoClmNo%>">&nbsp;<input type="text" name="clm_area_cd" style="width:35;text-align:center" class="input2" value=""></td>
					<td width="45">Status</td>
					<td width="120"><input type="text" name="clm_misc_nm" style="width:80;text-align:center" class="input2" value=""></td>
					<td width="30" title="Date of Case Closed">DOC</td>
					<td width="150"><input type="text" name="cs_clz_dt" style="width:80;text-align:center" class="input2" value=""></td>
					<td width="30" title="Type Of Settlement">TOS</td>
					<td width=""><input type="text" name="cgo_clm_stl_tp_cd" style="width:40;text-align:center" class="input2" value=""></td>
				</tr></table>
				<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td width="70">Claimant</td>
					<td width="280"><input type="text" name="pty_nm" style="width:253;" class="input2" value="">
					<td width="45" title="Date of Notice of Preliminary Claim">DON</td>
					<td width="300"><input type="text" name="prlm_clm_ntc_dt" dataformat="ymd" style="width:80;text-align:center" class="input2" value=""></td>
					<td width="140">Summons Served Date</td>
					<td width=""><input type="text" name="smns_sve_dt" dataformat="ymd" style="width:80;text-align:center" class="input2" value=""></td>
				</tr>
				</table>


		<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td width="100">Claim Amount</td>
					<td width="250" class="stm"><input type="text" name="clmt_locl_amt" dataformat="float" readonly style="width:180;text-align:right" class="input2" value="">&nbsp;<input type="text" name="clmt_locl_curr_cd" style="width:38;text-align:center" class="input2" value=""></td>
					<td width="45" title="Rate Of Exchange">R.O.E</td>
					<td width="300" class="stm"><input type="text" name="clmt_locl_xch_rt" dataformat="float" readonly style="width:80;text-align:right" class="input2" value="">&nbsp;<input type="text" name="clmt_usd_amt" dataformat="float" readonly style="width:146;text-align:right" class="input2" value="">&nbsp;USD</td>
					<td width="30" title="Date Of Formal Claim">DOF</td>
					<td width=""><input type="text" name="fmal_clm_rcv_dt" dataformat="ymd" style="width:80;text-align:center" class="input2" value=""></td>
				</tr>
				<tr class="h23">
					<td width="100">Settled Amount </td>
					<td width="250" class="stm"><input type="text" name="cgo_clm_stl_locl_amt" dataformat="float"  readonly style="width:180;text-align:right" class="input2" value="">&nbsp;<input type="text" name="cgo_clm_stl_locl_curr_cd" style="width:38;text-align:center" class="input2" value=""></td>
					<td width="45" title="Rate Of Exchange">R.O.E</td>
					<td width="300" class="stm"><input type="text" name="cgo_clm_stl_xch_rt" dataformat="float" readonly style="width:80;text-align:right" class="input2" value="">&nbsp;<input type="text" name="cgo_clm_stl_usd_amt" dataformat="float" readonly style="width:146;text-align:right" class="input2" value="">&nbsp;USD</td>
				    <td width="30" title="Date Of Settlement">DOS</td>
					<td width=""><input type="text" name="cgo_clm_stl_dt" dataformat="ymd" style="width:80;text-align:center" class="input2" value=""></td>
				</tr>
				</table>

			  <table class="line_bluedot"><tr><td colspan="8"></td></tr></table>

			  <!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->
			<!--  Button_Sub (S) -->
			<table width="100%" class="button">
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Add">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Copy">Row Copy</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Delete">Row&nbsp;Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Down_Excel">Down Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Load_Excel">Load Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table>

<% if ("Y".equals(popupYn)) {%>
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
<% } %>

		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><% if ("Y".equals(popupYn)) {%><td class="btn3_bg"><% }else{ %><td class="btn1_bg"><%}%>
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_New">New</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Save">Save</td>
					<td class="btn1_right"></td>
				</tr></table></td>

                 <% if ("Y".equals(popupYn)) {%>
                 
                 <td class="btn1_lline"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_close">Close</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <% } %>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->

<% if ("Y".equals(popupYn)) {%>
</tr>
</table>
<% } %>

    <!--biz page (E)-->

</td>
</tr>
</table>
</form>
</body>
</html>
