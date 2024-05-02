<%  
/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : ESM_PRI_2055.jsp
 *@FileTitle : RFA Proposal Creation - Rate [M/B]
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.04.20
 *@LastModifier : 전지예
 *@LastVersion : 1.0
 * 2015.04.20 전지예
 * 1.0 Creation
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2055Event"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="org.apache.log4j.Logger"%>

<%
    EsmPri2055Event event = null;						//PDTO(Data Transfer Object including Parameters)
    
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    Logger log = Logger.getLogger("com.hanjin.apps.RFAProposal.RFARateProposal");

    try {
    	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmPri2055Event) request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

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
<title>RFA Proposal Creation - Rate [M/B]</title>
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

<!-- OUTER - POPUP (S)tart -->
<input type="hidden" name="prop_no" value="<%=StringUtil.xssFilter(request.getParameter("prop_no"))%>" />
<input type="hidden" name="amdt_seq" value="<%=StringUtil.xssFilter(request.getParameter("amdt_seq"))%>" />
<input type="hidden" name="svc_scp_cd" value="<%=StringUtil.xssFilter(request.getParameter("svc_scp_cd"))%>" />
<input type="hidden" name="cmdt_hdr_seq" value="<%=StringUtil.xssFilter(request.getParameter("cmdt_hdr_seq"))%>" />

<table width="580" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr><td valign="top">
    
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;RFA Proposal Creation - Rate [M/B]</td></tr>
        </table>
        <!-- : ( Title ) (E) -->
        
        <!-- 1 (S) -->
        <table class="search">
        <tr><td class="bg" width="33%" valign="top">
        	<!--grid (s)-->
       		<table class="search" border="0">
				<tr>
					<td class="title_h"></td>
					<td class="title_s">Origin</td>
				</tr>
			</table>
            <table width="100%"  id="mainTable">
                <tr>
                    <td width="100%">
                        <script type="text/javascript">ComSheetObject('sheet1');</script>
                    </td>
                </tr>
            </table>
        	<!--grid (e)-->
        </td>
        <td class="bg" width="33%">
			<!--grid 2 (s)-->
			<table class="search" border="0">
				<tr>
					<td class="title_h"></td>
					<td class="title_s">Dest</td>
				</tr>
			</table>
			<table width="100%" id="mainTable">
				<tr>
					<td width="100%"><script type="text/javascript">ComSheetObject('sheet2');</script>
					</td>
				</tr>
			</table>
			<!--grid 2 (E)--> 
        </td>
        <td class="bg" width="33%">
			<!--grid 3 (s)-->
			<table class="search" border="0">
				<tr>
					<td class="title_h"></td>
					<td class="title_s" id="mb_port"></td>
				</tr>
			</table>
			<table width="100%" id="mainTable">
				<tr>
					<td width="100%"><script type="text/javascript">ComSheetObject('sheet3');</script>
					</td>
				</tr>
			</table>
			<!--grid 3 (E)--> 
        </td>
        </tr>
        </table>
        <!-- 1 (E) -->
</td></tr></table>

<table class="height_5"><tr><td></td></tr></table>
    
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup"><!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0"
			cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn3_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td class="btn3_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
								<table width="72 border=" 0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn1_left"></td>
										<td class="btn1" name="btn_close">Close</td>
										<td class="btn1_right">
									</tr>
								</table>
								</td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!--Button (E) --></td>
	</tr>
</table>
<!-- : ( Button : pop ) (E) -->
	<table class="height_10"><tr><td colspan="8"></td></tr></table>
</form>
</body>
</html>
