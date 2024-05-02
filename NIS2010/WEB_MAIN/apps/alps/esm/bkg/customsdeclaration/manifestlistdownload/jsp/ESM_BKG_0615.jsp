<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0615.jsp
*@FileTitle : US Manifest EXPORT Transmit(XI)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.06.11 김도완 
* 1.0 Creation
*--------------------------------------------------------
* History
* 2013.04.02 김보배 [CHM-201323809] [BKG] [US AMS] XI 전송 화면 & Transmission & receiving history 화면 보완
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg0615Event"%><%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0615Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String pgmNo = StringUtil.xssFilter(request.getParameter("pgmNo"));
	//out.println(pgmNo);
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");
	
	String vvdCd = "";
	String polCd = "";
	String podCd = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0615Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		vvdCd  = StringUtil.xssFilter(request.getParameter("vvd_cd"));
		polCd  = StringUtil.xssFilter(request.getParameter("pol_cd"));
		podCd  = StringUtil.xssFilter(request.getParameter("pod_cd"));		
		
	}catch(Exception e) {
		out.println(e.toString());
	}
	
%>
<html>
<head>
<title>US AMS: Manifest Transmit (XI)</title>
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
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="search_mtd">
<input type="hidden" name="pageNo" value="<%=pgmNo%>">
<!-- 개발자 작업	-->
 
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			

				<!--  biz_1 (S) -->
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="30">VVD</td>
						<td width="150"><input type="text" name="vvd" style="width:80;ime-mode:disabled" maxlength="9" class="input1" dataformat="eng" required fullfill caption="VVD" value="<%=vvdCd%>"></td>
						<td width="30">POL</td>
						<td width="110">
							<input type="text" name="pol" style="width:50;ime-mode:disabled" maxlength="5" class="input1" dataformat="engupnum" required fullfill caption="POL"  value="<%=polCd%>">
						</td>
						<td width="30">POD</td>
						<td width="80">
							<input type="text" name="pod" style="width:50;ime-mode:disabled" maxlength="5" class="input" dataformat="engupnum" fullfill caption="POD"  value="<%=podCd%>">
						</td>
						<td width="70">Customs</td>
						<td width="100">
							<input type="text" name="customs" style="width:50;ime-mode:disabled" maxlength="5" class="input" dataformat="engupnum" fullfill caption="Customs">
						</td>
						<td width="160"><table class="search_sm2" border="0"  style="width:95%;">
							<tr class="h23">
								<td><input type="radio" name="all_err" value="All" class="trans" checked>All&nbsp;&nbsp;&nbsp;<input type="radio" name="all_err" value="err" class="trans">Error B/L</td>
							</tr>
						</table></td>
						<td width=""><select name="full_empty" style="width:67;">
						<option value="F" selected>Full</option>
						<option value="M">Empty</option>
						<!-- 2013.04.09 Empty 의 value 를 E 에서 M 으로 변경 -->
						</select></td> 
					</tr>
				</table>
				<!--  biz_1   (E) -->		
					
		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>	
		
		<table class="search" id="mainTable"> 
   		<tr><td class="bg">	
			<!-- Grid_2 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid_2 (E) -->		
			<table class="height_8"><tr><td></td></tr></table>	
			<!-- Grid_2 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
			<!-- Grid_2 (E) -->		
			
			<!--  Total  (S) -->
			<table class="total" border="0" width="100%"> 
			<tr><td width="18%" align="center">Total</td>
				<td class="sm">&nbsp;&nbsp;&nbsp;01 M/BL&nbsp;&nbsp;<input type="text" name="mbl01" style="width:40;text-align:center;" class="input" value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				02 M/BL&nbsp;&nbsp;<input type="text" name="mbl02" style="width:40;text-align:center;" class="input" value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				03 M/BL&nbsp;&nbsp;<input type="text" name="mbl03" style="width:40;text-align:center;" class="input" value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<b>B/L Total Count</b>&nbsp;&nbsp;<input type="text" name="totbl" style="width:50;text-align:center;" class="input" value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			</tr> 
			</table>				
			<!--  Total  (E) -->	
			
			</td></tr>
		</table>
		<!--biz page (E)-->
</td></tr>
		</table>
	
		
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
		<tr class="h23">
		<td>
		<!--Button (S) -->
		<table class="search" border="0" style="width:135;"> 
       	<tr><td class="btn1_bg">
		</td></tr>
		</table>
    	<!--Button (E) -->
	 </td>
	 <td>
		<!--Button (S) -->
		<table class="search" border="0" style="width:100%;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td id="btn_Transmit"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Transmit">Transmit (Full)</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td id="btn_Transmit_e"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Transmit_e">Transmit (Empty)</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				
				
				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
	 </td>
	</tr>
	</table>

		<br>
	    <!-임시 (S)-->
	    <!-- OFM Generation 수행시 생성된 flatfile을 보기 위해사용 
	    <table style="width:979;height:100">
	    	<tr><td>result : </td></tr>
	        <tr>
	            <td><textarea name="output" cols="100" rows="20"></textarea></td>
	        </tr>
	    </table>
	     -->
	    <table width="100%" id="imsiTable" style="display:none">
	        <tr>
	            <td width="100%"><script language="javascript">ComSheetObject('sheet3');</script></td>
	        </tr>
	    </table>
	    
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>