<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0223.jsp
*@FileTitle : FQA Result Detail Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.10.09 함형석
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
<%@ page import="com.hanjin.apps.alps.ees.mnr.generalmanage.fqaresultmgt.event.EesMnr0223Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesMnr0223Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String vndrSeq = ((request.getParameter("vndr_seq")==null )?"":request.getParameter("vndr_seq"));
	String ydCd = ((request.getParameter("yd_cd")==null )?"":request.getParameter("yd_cd"));
	String fldAudDt = ((request.getParameter("fld_aud_dt")==null )?"":request.getParameter("fld_aud_dt"));
	String ofcCd = ((request.getParameter("ofc_cd")==null )?"":request.getParameter("ofc_cd"));
	
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	Logger log = Logger.getLogger("com.hanjin.apps.test.test");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EesMnr0223Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>FQA Result Detail Info</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!--MNR 공용 사용  -->       
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
<input type="hidden" name="key_value">  
<input type="hidden" name="ofc_cd" value="<%=ofcCd %>">
<input type="hidden" name="usr" value="<%=strUsr_id %>">
<!-- 개발자 작업	-->
<table width="100%" class="popup" cellpadding="10" border="0"> 

	<tr><td valign="top">
        <!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		    <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> FQA Result Detail Info</span></td></tr>
		</table> 
		<!--Page Title, Historical (E)-->        

		<!--biz page (S)-->
		<!-- 1 (S) -->
		<table class="search" id="mainTable">
       		<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					
					<td width="70">S/Provider</td>
					<td width="300"><input type="text" style="width:60;" class="input2" readOnly name="vndr_seq" value="<%=vndrSeq%>" required maxlength="6" dataformat="engup">&nbsp;<input type="text" style="width:200;" class="input2" readOnly name="vndr_lgl_eng_nm" ></td>
					<td width="28">Yard</td>
				    <td colspan="110"><input type="text" style="width:60;" class="input2" readOnly name="yd_cd" value="<%=ydCd%>" required fullfill type="text"  dataformat="engup" maxlength="7" >&nbsp;</td>
					<td width="70">Audit Date</td>
					<td width="120"><input type="text" style="width:80;" class="input2" readOnly name="fld_aud_dt" value="<%=fldAudDt%>" required dataformat="ymd" maxlength="8" >&nbsp;</td>
					<td width="130">Audit  Result History</td>
					<td width=""><script language="javascript">ComComboObject('combo1',2, 80 ,1,1,1)</script></td></tr>
				<tr class="h23"></tr>
				</table>
				<!--  biz_1   (E) -->
   
		</td></tr></table>
		<!-- 1 (E) -->


		<!-- 2 (S) -->
		<table class="height_8"><tr><td></td></tr></table>
		<table class="search" id="mainTable">
       		<tr><td class="bg">

			<table class="search" border="0">
			<tr><td class="title_h"></td>
				<td class="title_s">  Field Quality Audit Result</td></tr>
			</table>

			<!-- Grid - 2 (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid - 2 (E) -->
		<table class="height_8"><tr><td></td></tr></table>
		
		<table class="search" border="0">
			<tr class="h23">
				<td width="400">
					<!-- Grid - 2 (S) -->
					<table width="350"  id="mainTable">
						<tr>
							<td width="350">
							<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
					</table>
					<!-- Grid - 2 (E) -->
				</td>
				<td align="right" valign="top">Total Performance Score by 100% Point <input type="text" style="width:40; text-align:right;" class="input2" readOnly name="total" value=""></td>
			
			</tr>
		</table>
	    	

			</td></tr>
		</table>
		<!-- 2 (E) -->
		<!--biz page (E)-->
		<table class="height_5"><tr><td></td></tr></table>


	</td></tr>
</table>  

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>	
			<td class="btn3_bg">
		    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				
			</tr>
		</table></td></tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<script language="javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp" %>