<%  
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_3015.jsp
 *@FileTitle : Publication Date Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.11.30
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.11.30 박성수
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
<%@ page import="com.hanjin.apps.alps.esm.pri.triproposal.triproposal.event.EsmPri3015Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
    EsmPri3015Event event = null; //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null; //서버에서 발생한 에러
    String strErrMsg = ""; //에러메세지
    int rowCount = 0; //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    Logger log = Logger.getLogger("com.hanjin.apps.TRIProposal.TRIRateProposal");

    try {
        SignOnUserAccount account = (SignOnUserAccount) session
                .getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmPri3015Event) request.getAttribute("Event");
        serverException = (Exception) request
                .getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        

    } catch (Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Publication Date Creation</title>
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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업 -->
<input type="hidden" name="amdt_seq" value="<%=request.getParameter("amdt_seq")%>">
<input type="hidden" name="prop_sts_cd" value="<%=request.getParameter("prop_sts_cd")%>">
<input type="hidden" name="is_req_usr" value="<%=request.getParameter("is_req_usr")%>">
<input type="hidden" name="is_apro_usr" value="<%=request.getParameter("is_apro_usr")%>">

<!-- OUTER - POPUP (S)tart -->
<table width="500" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Publication Date Creation</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="55">TRI No.</td>
					<td width="200"><input type="text" name="tri_no" style="width:120;text-align:center;" class="input2" value="<%=request.getParameter("tri_no")%>" caption="TRI No." required readonly></td>
					<td width="80">Proposal No.</td>
					<td width=""><input type="text" name="tri_prop_no" style="width:80;text-align:center;" class="input2" value="<%=request.getParameter("tri_prop_no")%>" caption="Proposal No." required readonly></td>
					
					
				</tr>
				
				<tr class="h23">
					<td width="">Duration</td>
					<td colspan="3"><input type="text" name="disp_eff_dt" style="width:75;text-align:center;" class="input2" value="<%=request.getParameter("eff_dt")%>" caption="Effective date" cofield="disp_exp_dt" maxlength="10" dataformat="ymd" required readonly>
					 ~ <input type="text" name="disp_exp_dt" style="width:75;text-align:center;" class="input2" value="<%=request.getParameter("exp_dt")%>" caption="Expiration date" cofield="disp_eff_dt" maxlength="10" dataformat="ymd" required readonly></td>
					
				</tr>
				</table>
				<table class="line_bluedot"><tr><td></td></tr></table>
				<!-- : ( Grid ) (S) -->
				<table class="grid2" border="0" style="width:100%;"> 
				<tr class="tr2_head">
					<td width="50%">Last Publication Date</td>
					<td width="">New Publication Date</td>	
				</tr>
				<tr class="h23">
					<td align="center" class="input2"><input type="text" name="last_pub_dt" style="width:75;text-align:center;" class="noinput2" value="<%=request.getParameter("last_pub_dt")%>" caption="Last Publication date" maxlength="10" dataformat="ymd" readonly></td>
					<td align="center" class="input1"><input type="text" name="pub_dt" style="width:75;text-align:center;" class="noinput1" value="" caption="Publication date" maxlength="10" dataformat="ymd" required>
					<!-- img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td -->
				</tr>
				</table>
				
				<table class="height_5"><tr><td></td></tr></table>
				
				<table class="grid2" border="0" style="width:100%;"> 
				<tr class="tr2_head">
					<td width="50%">Current Expiration Date</td>
					<td width="">New Expiration Date</td>	
				</tr>
				<tr class="h23">
					<td align="center" class="input2"><input type="text" name="cur_exp_dt" style="width:75;text-align:center;" class="noinput2" value="<%=request.getParameter("exp_dt")%>" caption="Current Expiration date" maxlength="10" dataformat="ymd" readonly></td>
					<td align="center" class="input1"><input type="text" name="exp_dt" style="width:75;text-align:center;" class="noinput1" value="<%=request.getParameter("exp_dt")%>" caption="New Expiration date" maxlength="10" dataformat="ymd" required>
					<!-- img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td -->
				</tr>
				</table>
			
		</td></tr></table>
		
		<!--biz page (E)--> 

</td></tr></table>

<table class="height_5"><tr><td></td></tr></table>
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr> 		
		    		  <td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ok">Save</td>
					<td class="btn1_right"></td></tr></table></td>
				<td class="btn1_line">
				   <td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td></tr></table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
			<!-- Hidden sheet for Transaction (S) -->
			<div id="hiddenSheetLayer" style="display: none">
			<script language="javascript">ComSheetObject('sheet1');</script>
			</div>
			<!-- Hidden sheet for Transaction (E) -->
</form>
</body>
</html>

