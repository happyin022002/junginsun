<%/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_cni_0008.jsp
 *@FileTitle : [CPS_CNI_0008] Payment
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.07
 *@LastModifier : 양정란
 *@LastVersion : 1.0
 * 2009.04.17 양정란
 * 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@page import="com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.event.CpsCni0008Event"%>
<%@page import="com.hanjin.apps.alps.cps.cni.common.CniUtil"%>

<%
	CpsCni0008Event event = null;
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

	String cgoClmNo = "";

    Logger log = Logger.getLogger("com.hanjin.apps.alps.cps.cni.codemgt.CodeMgtSC");
    SignOnUserAccount account = null;

    try
    {

		cgoClmNo  = JSPUtil.getParameter(request, "cgo_clm_no","");

        account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();

        event = (CpsCni0008Event) request.getAttribute("Event");
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
    
    // 사용자 roles
    String roles = CniUtil.getRoles(account);
    String area =  CniUtil.getAreaInfo(account);
    String ofcCd = account.getOfc_cd(); 
    
    //roles = "CNI03";
    //area =  "E";
    //ofcCd = "GOABB";
    //userId = "003997933";    
%>


<%@page import="com.hanjin.apps.alps.cps.gem.common.GemUtil"%>
<%@page import="com.hanjin.framework.component.util.StringUtil"%>

<html>
<head>
<title>Payment</title>
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



<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="usr_id" value="<%=userId%>">
<input type="hidden" name="usr_roles" value="<%=roles%>">
<input type="hidden" name="usr_area" value="<%=area%>">
<input type="hidden" name="usr_office" value="<%=ofcCd%>">

<!-- Status 변경을 위한 변수 -->
<input type="hidden" name="cgo_clm_sts_cd">
<input type="hidden" name="cgo_clm_clz_cd">
<input type="hidden" name="upd_usr_id">

<!-- 권한체크위한 변수 -->
<input type="hidden" name="hdlr_usr_id">
<input type="hidden" name="hdlr_ofc_cd">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Payment</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- : ( Search Options ) (S) -->

			<table class="search">
       		<tr><td class="bg">
				<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td width="70">Claim No.</td>
					<td width="210"><input type="text" style="width:120;text-align:center" class="input1" name="cgo_clm_no" value="<%=cgoClmNo%>" required caption="Claim No" maxlength="10" >&nbsp;<input type="text" name="clm_area_cd" style="width:35;text-align:center" value="" class="input2" readonly></td>
					<td width="40">Status</td>
					<td width="266"><input type="text" name="clm_misc_nm"  style="width:112;text-align:center" class="input2" value="" readonly></td>
					<td width="60" title="Date Of Close">DOC</td>
					<td width=""><input type="text" name="cs_clz_dt" style="width:100%;text-align:center" dataformat="ymd" class="input2" value="" readonly></td>
				</tr>
				<tr class="h23">
					<td width="">Claimant</td>
					<td width="" colspan="5"><input type="text" name="pty_nm" style="width:363;" class="input2" value="" readonly>
					</tr>
				</table>

				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
		<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td width="130">Claim Amount</td>
					<td width="180" class="stm"><input type="text" name="clmt_locl_amt" style="width:110;text-align:right;ime-mode:disabled" dataformat="float" pointcount="2" class="input2" value="" readonly>&nbsp;<input type="text" name="clmt_locl_curr_cd" style="width:35;text-align:center" class="input2" value=""></td>
					<td width="30" title="Rate Of Exchange">R.O.E<td>
					<td width="240" class="stm"><input type="text" name="clmt_locl_xch_rt" style="width:70;text-align:right;ime-mode:disabled" dataformat="float" pointcount="5" class="input2" value="" readonly>&nbsp;<input type="text" name="clmt_usd_amt" style="width:110;text-align:right;ime-mode:disabled" dataformat="float" pointcount="2" class="input2" value="" readonly>&nbsp;&nbsp;USD
					<td width="60" title="Date Of Formal Claim">DOF</td>
					<td width=""><input type="text" name="fmal_clm_rcv_dt" dataformat="ymd" style="width:100%;text-align:center;ime-mode:disabled" class="input2" value="" readonly></td>
				</tr>
				<tr class="h23">
					<td width="">Settled Amount </td>
					<td width="" class="stm"><input type="text" name="cgo_clm_stl_locl_amt" style="width:110;text-align:right;ime-mode:disabled" dataformat="float" pointcount="2" class="input2" value="" readonly>&nbsp;<input type="text" name="cgo_clm_stl_locl_curr_cd" style="width:35;text-align:center" class="input2" value="" readonly></td>
					<td width="" title="Rate Of Exchange">R.O.E<td>
					<td width="" class="stm"><input type="text" name="cgo_clm_stl_xch_rt" style="width:70;text-align:right;ime-mode:disabled" dataformat="float" pointcount="5" class="input2" value="" readonly>&nbsp;<input type="text" name="cgo_clm_stl_usd_amt" style="width:110;text-align:right;ime-mode:disabled" dataformat="float" pointcount="2" class="input2" value="" readonly>&nbsp;&nbsp;USD
					<td width="" title="Date Of Settlement">DOS</td>
					<td width=""><input type="text" name="cgo_clm_stl_dt" dataformat="ymd" style="width:100%;text-align:center;ime-mode:disabled" class="input2" value="" readonly></td>
				</tr>
				<tr class="h23">
					<td width="" colspan="4">Recovered Amount</td>
					<td width="" class="stm"  style="padding-left:74"><input type="text" name="recovered_amount" style="width:110;text-align:right;ime-mode:disabled" dataformat="float" pointcount="2" class="input2" value="" readonly>&nbsp;&nbsp;USD</td>

				</tr>
				<tr class="h23">
					<td width="">From Liable Party</td>
					<td width="" class="stm"><input type="text" name="labl_pty_rcvr_locl_amt" style="width:110;text-align:right;ime-mode:disabled" dataformat="float" pointcount="2" class="input2" value="" readonly>&nbsp;<input type="text" name="labl_pty_rcvr_locl_curr_cd" style="width:35;text-align:center" class="input2" value="" readonly></td>
					<td width="" title="Rate Of Exchange">R.O.E<td>
					<td width="" class="stm"><input type="text" name="labl_pty_rcvr_locl_xch_rt" style="width:70;text-align:right;ime-mode:disabled" dataformat="float" pointcount="5" class="input2" value="" readonly>&nbsp;<input type="text" name="labl_pty_rcvr_usd_amt" style="width:110;text-align:right;ime-mode:disabled" dataformat="float" pointcount="2" class="input2" value="" readonly>&nbsp;&nbsp;USD
					<td width="">LP DOR</td>
					<td width=""><input type="text" name="labl_pty_rcvr_dt" dataformat="ymd" style="width:100%;text-align:center;ime-mode:disabled" class="input2" value="" readonly></td>
				</tr>
				<tr class="h23">
					<td width="">From Insurer</td>
					<td width="" class="stm"><input type="text" name="insur_rcvr_amt" style="width:110;text-align:right;ime-mode:disabled" dataformat="float" pointcount="2" class="input2" value="" readonly>&nbsp;<input type="text" name="insur_rcvr_locl_curr_cd" style="width:35;text-align:center" class="input2" value="" readonly></td>
					<td width="" title="Rate Of Exchange">R.O.E<td>
					<td width="" class="stm"><input type="text" name="insur_rcvr_xch_rt" style="width:70;text-align:right;ime-mode:disabled" dataformat="float" pointcount="5" class="input2" value="" readonly>&nbsp;<input type="text" name="insur_rcvr_usd_amt" style="width:110;text-align:right;ime-mode:disabled" dataformat="float" pointcount="2" class="input2" value="" readonly>&nbsp;&nbsp;USD
					<td width="">INS DOR</td>
					<td width=""><input type="text" name="insur_rcvr_dt" dataformat="ymd" style="width:100%;text-align:center;ime-mode:disabled" class="input2" value="" readonly></td>
				</tr>
				<tr class="h23">
					<td width=""  colspan="4">Net Paid Amount</td>
					<td width="" class="stm" style="padding-left:74"><input type="text" name="net_paid_amount" style="width:110;text-align:right;ime-mode:disabled" dataformat="float" pointcount="2" class="input2" value="" readonly>&nbsp;&nbsp;USD</td>
				</tr></table>
				<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td width="479">Defense Ratio on Settlement</td>
					<td width="" class="stm"  colspan="2"><input type="text" name="defense_ratio_on_settlement" style="width:50;text-align:right;ime-mode:disabled" dataformat="float" pointcount="2" class="input2" value="" readonly>&nbsp;&nbsp;%</td>
				</tr>
				<tr class="h23">
					<td width="" style="padding-left:80">on Net Payment</td>
					<td width="" class="stm" colspan="2"><input type="text" name="on_net_payment" style="width:50;text-align:right;ime-mode:disabled" dataformat="float" pointcount="2" class="input2" value="" readonly>&nbsp;&nbsp;%</td>
				</tr></table>
				<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td width="322">Handling Cost in Total</td>
					<td width="97" class="stm"><!-- input type="text" name="cost_seq" style="width:50;text-align:right;ime-mode:disabled" class="input2" value="" readonly--></td>
					<td width="" class="stm"><input type="text" name="inv_usd_amt" style="width:110;text-align:right;ime-mode:disabled" dataformat="float" pointcount="2" class="input2" value="" readonly>&nbsp;&nbsp;USD</td>
				</tr>
				</table>
			<table class="grid2" border="0" style="width:100%;">
				<tr class="tr2_head">
					<td width="130" rowspan="3">Remarks</td>
					<td width=""><textarea style="width:100%" name="pay_rmk" caption="Remarks" rows="3"></textarea></td>
				</tr>
				</table>
			<!--  Button_Sub (S) -->
			<table width="100%" class="button">
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2_3" name="btn1_Handling_Costs">Handling Costs</td>
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


<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table>


<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
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

				<td class="btn1_line">
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    <!--Button (E) -->

	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

</form>
<div style="display: none;"><script language="javascript">ComSheetObject('sheet1');</script></div>

</body>
</html>
