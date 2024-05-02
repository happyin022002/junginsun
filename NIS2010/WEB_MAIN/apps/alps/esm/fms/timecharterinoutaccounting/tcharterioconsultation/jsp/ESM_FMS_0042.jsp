<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0042.jsp
*@FileTitle : Slip Inquiry Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.08.06 정윤태
* 1.0 Creation 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0042Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0042Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmFms0042Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		log.error(e.getMessage(),e);
	}
	
	String vsl_cd = JSPUtil.replaceForHTML(request.getParameter("vsl_cd"));
	String vsl_eng_nm = JSPUtil.replaceForHTML(request.getParameter("vsl_eng_nm"));
	String csr_no = JSPUtil.replaceForHTML(request.getParameter("csr_no"));
%>

<html>
<head>
<title>Slip Inquiry Detail</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<body class="popup_bg" onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="csr_type">
<table width="800" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
 <!-- : ( Title ) (S) -->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Slip Inquiry Detail</td></tr>
        </table>

        <!-- : ( Title ) (E) -->
	
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Slip Inquiry Head</td></tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="85">Vessel Code</td>
					<td width="280"><input type="text" style="width:56;text-align:center;" class="input2" value="<%=vsl_cd%>" readonly>&nbsp;<input type="text" style="width:200;" class="input2" name="vsl_eng_name" value="&nbsp;<%=vsl_eng_nm%>" readonly></td>
					<td width="55">CSR No.</td>
					<td width=""><input type="text" style="width:183;text-align:center;" class="input2" name="csr_no" value="<%=csr_no%>" readonly></td>
				</tr>
				</table>
				
				<!--  biz_1   (E) -->
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				<!--  biz_2  (S) -->
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s"> Slip Inquory - Detail</td></tr>
				</table>
				<!-- Grid  (S) -->
					<table width="100%" id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
				<!-- Grid (E) -->
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<table class="search" border="0" style="width:983;"> 
				<tr class="h23">
					<td width="590"></td>
					<td width="90">Total Amount</td>
					<td width="160"><input type="text" style="width:50;text-align:center;" class="tr_head3" value="DR" readonly>&nbsp;<input type="text" style="width:100;text-align:right;" class="tr_head3" name="dr_amt" readonly></td>
					<td ><input type="text" style="width:50;text-align:center;" class="tr_head3" name="diff" readonly>&nbsp;<input type="text" style="width:100;text-align:right;" class="tr_head3" name="cr_amt" readonly></td>
				</tr>
				<tr class="h23">
					<td width="590"></td>
					<td width="90"> </td>
					<td width="160"></td>
					<td id="balanceAmt" style="display:none;"><input type="text" style="width:50;text-align:center;" class="tr_head3" value="Balance" readonly>&nbsp;<input type="text" style="width:100;text-align:right;" class="tr_head3" name="balance_amt" readonly></td>
				</tr>
				</table>	
			</td></tr>
			</table>
				<table class="height_5"><tr><td></td></tr></table>
	</td></tr>
			</table>
	<!--biz page (E)-->
	
	<!--Button (S) -->
    
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
    
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
				
				<!-- td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_hire">Hire Statement</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td-->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_tax">Tax </td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
                  <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_close">Close</td>
                    <td class="btn1_right"></td>
                </tr></table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
</td></tr>
</table>

<!------- Print용 Hidden RD Object Start -------->
<table width="100%" id="rdTable"> 
	<tr>
		<td width="100%">
			<script language="javascript">comRdObject('Rd');</script>
		</td>
	</tr>
</table>
<!------- Print용 Hidden RD Object End -------->

</form>
</body>
</html>