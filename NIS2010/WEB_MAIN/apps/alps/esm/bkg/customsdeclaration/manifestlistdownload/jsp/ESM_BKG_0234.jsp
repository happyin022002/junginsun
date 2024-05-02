<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0234.jsp
*@FileTitle : ESM_BKG-0234
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.05.19 임재택
* 1.0 Creation
*
* 2011.08.05 민정호 [CHM-201111822] Split 05-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.event.EsmBkg0234Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%
	EsmBkg0234Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	//int rowCount = 0; DB ResultSet 리스트의 건수

	//String successFlag = "";
	//String codeList = "";
	//String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	//Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0234Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>ESM_BKG-0234</title>
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
<form name="form" method="post">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 
<input type="hidden" name="vsl_cd"> 
<input type="hidden" name="skd_voy_no"> 
<input type="hidden" name="skd_dir_cd"> 
<input type="hidden" name="sheetdata">
<input type="hidden" name="sheetgubun"> 
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr>
	<td valign="top">
	 <!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="40">VVD</td>
					<td width="110"><input maxlength="9" type="text" style="width:80;" class="input1" value="" name="vvd_cd" style="ime-mode: disabled"  dataformat="uppernum"></td>
					<td width="30">POL</td>
					<td width="70"><input maxlength="5" type="text" style="width:50;" class="input" value="" name="pol_cd" style="ime-mode: disabled"  dataformat="uppernum"></td>
					<td width="30">POD</td>
					<td width="70"><input maxlength="5" type="text" style="width:50;" class="input1" value="PHMNL" name="pod_cd"  style="ime-mode: disabled" dataformat="uppernum"></td>
					<td width="80">Registry No.</td>
					<td width=""><input maxlength="7" type="text" style="width:80;" class="input1" value="" name="reg_no" style="ime-mode: disabled"  dataformat="uppernum"></td>
					</tr> 
				</table>	
					
				<!--  biz_1   (E) -->
			
		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>	
		
		
		<!-- Tab ) (S) -->
     	<table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%"> 
       		<tr><td width="100%">
				<script language="javascript">ComTabObject('tab1')</script>
			</td></tr>
		</table>
		<!-- Tab ) (E) --> 
		
		

<!--TAB File1 (S) -->
<div id="tabLayer" style="display:inline">
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t1sheet1');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->	
			</td></tr>
		</table>
		<!--biz page (E)-->
</div>
<!--TAB File1 (E) -->

<!--TAB File2 (S) -->
<div id="tabLayer" style="display:none">
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t2sheet1');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->	
			</td></tr>
		</table>
		<!--biz page (E)-->
</div>
<!--TAB File2 (E) -->

<!--TAB File3 (S) -->
<div id="tabLayer" style="display:none">
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t3sheet1');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->	
			</td></tr>
		</table>
		<!--biz page (E)-->
</div>
<!--TAB File3 (E) -->		
		
<!--TAB File4 (S) -->
<div id="tabLayer" style="display:none">		
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t4sheet1');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->	
			</td></tr>
		</table>
		<!--biz page (E)-->
</div>
<!--TAB File4 (E) --> 



<!--TAB File5 (S) -->
<div id="tabLayer" style="display:none">
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t5sheet1');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->	
			
			
			</td></tr>
		</table>
		<!--biz page (E)-->
</div>
<!--TAB File5 (E) -->



<!--TAB File6 (S) -->
<div id="tabLayer" style="display:none">
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t6sheet1');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->	
			</td></tr>
		</table>
		<!--biz page (E)-->
</div>
<!--TAB File6 (E) -->



<!--TAB File7 (S) -->
<div id="tabLayer" style="display:none">
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t7sheet1');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->	
			</td></tr>
		</table>
		<!--biz page (E)-->
</div>
<!--TAB File7 (E) -->



<!--TAB File8 (S) -->
<div id="tabLayer" style="display:none">
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t8sheet1');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->	
			</td></tr>
		</table>
		<!--biz page (E)-->
</div>
<!--TAB File8 (E) -->

<!--TAB Package Code (E) -->		

<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new" id="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Download To PC</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td id="btn_transmit"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_transmit">Transmit</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
	</td></tr>
</table>
</form>

<!--EDI File Download용 hidden Sheet(S) -->
<table width="100%" id="mainTable" style="display:none">
    <tr>
        <td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
    </tr> 
</table>
<!--EDI File Download용 hidden Sheet (E) -->

<form name="formFile" action="/hanjin/FileDownload" method="post">
<input type="hidden" name="downloadLocation" size="55"><br>
<input type="hidden" name="downloadFileName" size="55" >
</form>
<iframe name="download" id="download" style="display:none;width:1px;height:1px;" onreadystatechange="ComOpenWait(false);">
</iframe>
</body>
</html>