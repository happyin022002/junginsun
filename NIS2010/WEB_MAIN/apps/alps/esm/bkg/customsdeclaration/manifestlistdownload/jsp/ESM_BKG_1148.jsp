<%/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_1148.jsp
 *@FileTitle : Pakistan Customs Manifest
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.07.18
 *@LastModifier : 김보배
 *@LastVersion : 1.0
 * 2012.07.18 김보배
 * 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.event.EsmBkg1148Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg1148Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지

	String strUsr_id = "";
	String strUsr_nm = "";

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		String ofcCd = account.getOfc_cd();
		
		event = (EsmBkg1148Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	} catch (Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title>Pakistan: Manifest Data Download _ B/L List</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			//showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows">
<input type="hidden" name="pageno" value="ESM_BKG_1148">
<input type="hidden" name="pol_cd"> 
<input type="hidden" name="pod_cd"> 

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
	<table class="search"> 
      	<tr><td class="bg">

		<!--  biz_1  (S) -->
		<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
			<td width="40">&nbsp;&nbsp;VVD</td>
			<td width="150"><input name="vvd_cd" type="text" style="text-align:center"  style="width:80" value="" class="input1" dataformat="uppernum" style="ime-mode: disabled" maxlength="9"></td>
				
			<td width="300">
			<table class="search_sm2" border="0" style="width:200;"> 
			<tr class="h23">
				<td width="70"><input name="port_flg" type="radio"  class="trans" value="pol"   checked>POL</td>
				<td width="65"><input  name="port_flg"  type="radio"  class="trans" value="pod" >&nbsp;&nbsp;POD</td>
				<td width=""><input    name="pol_pod_cd" type="text" style="width:50" value="PKKHI" class="input1" style="text-align:center" style="ime-mode: disabled" dataformat="engupnum" maxlength="5"></td>
				</tr>
			</table>
			</td>
			<td width="60">Total B/L</td>
			<td width=""><input name="total_bl" type="text" style="width:35" value="" class="input2" style="text-align:right" readonly></td>
			</tr>
		</table>
		<!--  biz_1  (E) -->
		
		</td></tr>
	</table>	
	
	
	<table class="height_10"><tr><td colspan="8"></td></tr></table>	
	<table class="search"> 
      	<tr><td class="bg">
			
			<!--  biz_2  (S) -->
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="92">&nbsp;&nbsp;Vessel Name</td>
				<td width="230"><input name="vsl_eng_nm" type="text" style="width:170" value="" class="input2" readonly></td>
				<td width="60">Call Sign</td>
				<td width="180"><input name="call_sgn_no" type="text" style="width:70" value="" class="input2" readonly></td>
				<td width="30">ETD</td>
				<td width="152"><input name="etd_dt" type="text" style="width:90" value="" class="input2" readonly></td>
				<td width="30">ETA</td>
				<td width=""><input name="eta_dt" type="text" style="width:90" value="" class="input2" readonly></td>
			</tr>
			</table>
			<!--  biz_2  (E) -->
		
		</td></tr>
	</table>
	
	<table class="height_8">
		<tr>
			<td></td>
		</tr>
	</table>
	
	
	<!-- Tab (S) -->
  	<table class="tab" border="0" cellpadding="0" cellspacing="0" width="800"> 
   		<tr>
   			<td width="100%"><script language="javascript">ComTabObject('tab1')</script></td>
		</tr>
	</table>
		
	<div id="tabLayer" style="display:Inline;">
	<!-- Grid  (S) -->
		<table class="search" id="mainTable"> 
       		<tr>
       			<td class="bg">
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	<!-- Grid (E) -->
	</div>
		
					
	<div id="tabLayer" style="display:none;">
	<!-- Grid  (S) -->
		<table class="search" id="mainTable"> 
       		<tr>
       			<td class="bg">
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	<!-- Grid  (S) -->
	</div>
	
	
	<div id="tabLayer" style="display:none;">
	<!-- Grid  (S) -->
		<table class="search" id="mainTable"> 
       		<tr>
       			<td class="bg">
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet3');</script>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	<!-- Grid  (S) -->
	</div>
	<!-- Tab (E) -->
	
	
	<!--biz page (E)-->


	<!--Button (S) -->
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
							<td class="btn1_right"></td>
						</tr>
					</table>
				</td>
				<td class="btn1_line"></td>
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_down_excel" id="btn_Retrieve">Down Excel</td>
							<td class="btn1_right"></td>
						</tr>
					</table>
				</td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>
		
		


<!-- Copyright(E)--> <!-- 개발자 작업  끝 -->
</form>
</body>
</html>