<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_4018.jsp
*@FileTitle : Surcharge Location Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.05.06 이승준
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
<%@ page import="com.hanjin.apps.alps.esm.pri.surcharge.surchargegrouplocation.event.EsmPri4018Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri4018Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.Surcharge.SurchargeGroupLocation");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmPri4018Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String preSvcScpCd = null;
    String preChgCd = null;
	String isPopup = null;
	
	preSvcScpCd = JSPUtil.getNull(request.getParameter("pre_svc_scp_cd"));
	preChgCd = JSPUtil.getNull(request.getParameter("pre_chg_cd"));
	isPopup = JSPUtil.getNull(request.getParameter("is_popup"));
%>
<html>
<head>
<title>Surcharge Location Group Creation</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="grp_loc_seq" value="">
<input type="hidden" name="max_seq" value="0">
<input type="hidden" name="pre_svc_scp_cd" value="<%=preSvcScpCd%>">
<input type="hidden" name="pre_chg_cd" value="<%=preChgCd%>">
<input name="cd" type="hidden" value="">
<input name="etc1" type="hidden" value="">
<!-- 개발자 작업	-->
<%
    if (isPopup.equals("Y")) {
%>
<!-- OUTER - POPUP (S)tart -->
<table width="700" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Surcharge Location Group Inquiry</td></tr>
        </table>
        <!-- : ( Title ) (E) -->
<%
    } else {
%>
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->
<%
    }
%>
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="90">Service Scope</td>
					<td width="300"><script language="javascript">ComComboObject('svc_scp_cd', 2, 50, 0, 1, 0, false);</script>
					&nbsp;<input name="svc_scp_nm" type="text" style="width:200;"  value="" class="input2" readonly></td>
					<td width="55">Charge </td>
					<td width=""><script language="javascript">ComComboObject('chg_cd', 2, 50, 0, 1, 0, true);</script>
					&nbsp;<input name="chg_nm" type="text" style="width:200;"  value="" class="input2" readonly></td> 
 				</tr>
				</table>
				<!--  biz_1   (E) -->
				
				<!-- Hidden sheet for Transaction (S) -->
				<script language="javascript">ComSheetObject('sheet0');</script>
				<!-- Hidden sheet for Transaction (E) -->
				
				<!--  biz_2  (S) -->
		<table class="search"> 
       	<tr><td class="" width="40%">		
			<!-- Grid 1 (S) -->
			<table width="100%" id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid 1 (E) -->		
				
			<!--Button (S) -->				
	
			<!--Button (S) -->	
			
			</td>
			<td class="" width="2%"></td>
			<td class="" width="58%">
			<!-- Grid 2 (S) -->	
				<table width="100%" id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				<!-- Grid 2 (E) -->		
				<!--Button (S) -->				
				
				<!--Button (S) -->	
				<!-- Grid (E) -->
			</td>
		</tr>
		</table>	
	<!--  biz_2   (E) -->
	</td></tr>
	</table>
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right">
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right">
				</table></td>
				<%
        if (isPopup.equals("Y")) {
%>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left">
                    <td class="btn1" name="btn_Close">Close</td>
                    <td class="btn1_right">
                </table></td>
<%
        }
%>
			</tr>
			</table>
        </td></tr>
                </table>		
    <!--Button (E) -->

    </td></tr>
            </table>
</td></tr>
        </table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>