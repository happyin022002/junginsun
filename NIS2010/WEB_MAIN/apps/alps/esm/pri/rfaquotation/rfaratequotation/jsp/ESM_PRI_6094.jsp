<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : ESM_PRI_6094.jsp
	 *@FileTitle :  RFA Quotation Rate - Origin & Destination
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2012.07.24
	 *@LastModifier : 이은섭
	 *@LastVersion : 1.0
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event.EsmPri6094Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmPri6094Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.hanjin.apps.RFAProposal.RFARateProposal");

	String svcScpCd = request.getParameter("svc_scp_cd");
	svcScpCd = svcScpCd == null || svcScpCd.trim().length() == 0 ? "" : svcScpCd.trim();

	String ficRtTpCd = request.getParameter("fic_rt_tp_cd");
	ficRtTpCd = ficRtTpCd == null || ficRtTpCd.trim().length() == 0 ? "" : ficRtTpCd.trim();

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri6094Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

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
<title>RFA Quotation Rate - Route Point</title>
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
<input type="hidden" name="qttn_no" value="<%=request.getParameter("qttn_no")%>" >
<input type="hidden" name="qttn_ver_no" value="<%=request.getParameter("qttn_ver_no")%>">
<input type="hidden" name="gen_spcl_rt_tp_cd" value="<%=request.getParameter("gen_spcl_rt_tp_cd")%>">
<input type="hidden" name="cmdt_hdr_seq" value="<%=request.getParameter("cmdt_hdr_seq")%>">
<input type="hidden" name="rout_seq" value="<%=request.getParameter("rout_seq")%>">
<input type="hidden" name="org_dest_tp_cd" value="<%=request.getParameter("org_dest_tp_cd")%>">
<input type="hidden" name="pnt_via_tp_cd" value="<%=request.getParameter("pnt_via_tp_cd")%>">
<input type="hidden" name="svc_scp_cd" value="<%=request.getParameter("svc_scp_cd")%>" >
<input type="hidden" name="fic_rt_tp_cd" value="<%=request.getParameter("fic_rt_tp_cd")%>">
<input type="hidden" name="eff_dt" value="<%=request.getParameter("eff_dt")%>">
<input type="hidden" name="exp_dt" value="<%=request.getParameter("exp_dt")%>">

<input type="hidden" name="rout_tgt_row">

<!-- OUTER - POPUP (S)tart -->
<table width="980" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;RFA Quotation Creation -Rate(Route Point)</td></tr>
        </table>
        <!-- : ( Title ) (E) -->
        
        <!--biz page (S)-->
        <table class="search"> 
       <tr><td class="bg">
                <!--  biz_1   (E) -->
    
                <table border="0" style="width:700;" class="search_sm"> 
                <tr class="h23">
                    <td width="90">Route Point</td>
                    <td width="600" class="stm" style="font-size:12;">
                        <input type="radio" id="pointType" name="rt_pnt" value="0" class="trans">&nbsp;Origin&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="radio" id="pointType" name="rt_pnt" value="1" class="trans" <%= (ficRtTpCd.equals("A") && svcScpCd.equals("AEE"))?"disabled":"" %>>&nbsp;Origin Via&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="radio" id="pointType" name="rt_pnt" value="2" class="trans" <%= (ficRtTpCd.equals("A") && svcScpCd.equals("AEW"))?"disabled":"" %>>&nbsp;Destination Via&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="radio" id="pointType" name="rt_pnt" value="3" class="trans">&nbsp;Destination</td>
                        </tr>
                </table>
                <!-- : ( Grid ) (S) -->
                <table width="100%" id="mainTable"> 
                    <tr>
                        <td width="100%">
                            <div id="sheetLayer" style="display:none">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                            </div>
                            <div id="sheetLayer" style="display:none">
                            <script language="javascript">ComSheetObject('sheet2');</script>
                            </div>
                            <div id="sheetLayer" style="display:none">
                            <script language="javascript">ComSheetObject('sheet3');</script>
                            </div>
                            <div id="sheetLayer" style="display:none">
                            <script language="javascript">ComSheetObject('sheet4');</script>
                            </div>
                            <div id="sheetLayer" style="display:none">
                            <script language="javascript">ComSheetObject('sheet5');</script>
                            </div>
                            <div id="sheetLayer" style="display:none">
                            <script language="javascript">ComSheetObject('sheet6');</script>
                            </div>
                            <div style="display:none">
                            <script language="javascript">ComSheetObject('sheet7');</script>
                            </div>
                        </td>
                    </tr>
                </table>
                <!-- : ( Grid ) (E) --> 
                
                <!--  Button_Sub (S) -->
                <table width="100%" class="button"> 
                <tr><td class="btn2_bg">
                    <table border="0" cellpadding="0" cellspacing="0">
                    <tr>
                    
                    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn2_left"></td>
                    <td class="btn2" name="btn_add" suppressWait="Y">Row Add</td>
                    <td class="btn2_right"></td>
                    </tr>
                    </table></td>
                    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn2_left"></td>
                    <td class="btn2" name="btn_delete" suppressWait="Y">Delete</td>
                    <td class="btn2_right"></td>
                    </tr>
                    </table></td>
                    </tr></table>
            </td></tr>
            </table>
            <!-- Button_Sub (E) -->


        
        </td></tr></table>
        
        <!--biz page (E)--> 

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
						<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_ok">OK</td>
								<td class="btn1_right">
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
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
		<!--Button (E) --></td>
	</tr>
</table>
<!-- : ( Button : pop ) (E) -->
		</form></body>
</html>



