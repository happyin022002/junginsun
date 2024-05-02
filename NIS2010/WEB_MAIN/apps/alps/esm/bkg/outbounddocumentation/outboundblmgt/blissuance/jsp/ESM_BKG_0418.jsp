<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0418.jsp
*@FileTitle : Cargo Manifest print by B/L No
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.10.08 박준용
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg0418Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%@ page import="java.util.StringTokenizer" %>

<%
	EsmBkg0418Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.OutboundBLMgt.BLIssuance");

	String strMode = "";
	String strVvd = "";
	String strPort = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0418Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		strMode = JSPUtil.getParameter(request, "mode");
		strVvd = JSPUtil.getParameter(request, "vvd_cd");
		strPort = JSPUtil.getParameter(request, "port_cd");

	}catch(Exception e) {	
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Cargo Manifest print by B/L No</title>
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
<!-- 개발자 작업	-->
<input type="hidden" name="form_vslCd">
<input type="hidden" name="form_voyNo">
<input type="hidden" name="form_dirCd">
<input type="hidden" name="form_clptIndSeq" value="">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">

		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span><!-- &nbsp;Cargo Manifest print by B/L No. --></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
	
	
		<!--Button (S) -->
		
    	<!--Button (E) -->
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="160" valign="top">
						<table class="search" border="0" style="width:160;"> 
							<tr class="h23">
								<td width="40">Mode</td>
								<td width="">
									<select name="mode" style="width:200">
										<option value="I" <% if (strMode.equals("I") || strMode.equals("")) {%>selected<%}%>>Inbound</option>
										<option value="O" <% if (strMode.equals("O")) {%>selected<%}%>>Outbound</option>
									</select>
								</td>
							</tr> 
							<tr class="h23">
								<td>VVD</td>
								<td width=""><input type="text" name="vvd_cd" style="width:80;" class="input1" required value="<%=strVvd%>" maxlength="9" dataformat="engup"></td>
							</tr> 
							<tr class="h23">
								<td>Port</td>
								<td width=""><input type="text" name="port_cd" style="width:80;" class="input1" required value="<%=strPort%>" maxlength="5" dataformat="engup"></td>
							</tr> 
						</table>
					</td>
                    <td width="10"></td>
					<td valign="top">
							<!-- : ( Grid ) (S) -->
							<table width="200" id="sheetMainTable">
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet1');</script>
									</td>
								</tr>
							</table>
							<!-- : ( Grid ) (E) -->	
					</td>
					</tr> 
				</table>				
				<!--  biz_1   (E) -->
			
			
			</td></tr>
		</table>
        <div style="display:none">
            <script language="javascript">ComSheetObject('sheet_search');</script>
        </div>
		<!--biz page (E)-->

<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr> <td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
					<td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td></tr>
					</table>
					</td>
					<td class="btn1_line"></td>
					<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
					<td class="btn1_left"></td>
                    <td class="btn1" name="btn_Print">Print</td>
                    <td class="btn1_right"></td></tr>
					</table>
					</td>
			
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	
	</td></tr>
		</table>
	

	
	
	
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>