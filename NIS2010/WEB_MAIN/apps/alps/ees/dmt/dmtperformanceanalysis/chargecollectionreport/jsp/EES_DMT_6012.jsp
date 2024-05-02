<%/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ees_dmt_6012.jsp
*@FileTitle : Pre-Advice Report (Vessel Loading)
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : Cho won joo
*@LastVersion : 1.0
* 
* 1.0 Creation
* 
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.event.EesDmt6012Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EesDmt6012Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지

	String strUsr_id = "";
	String strUsr_nm = "";
	String search_flg1 = "";
	String search_flg3 = "";

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		String ofcCd = account.getOfc_cd();
			
		// Log-in ID 소속 Office 가 "MX" 인 경우 Default
		// 하동일 수석 가이드에 따라 조직코드의 앞 3자리가 MEX인 유저에 대해 로직을 적용함.
		if(ofcCd != null){
			if(ofcCd.substring(0, 3).equals("MEX")){
				search_flg1 = "checked";
			}
		}
		//Log-in ID 소속 Office 가 "MX" 가 아닌 경우 Default
		if( search_flg1.equals("")){
			search_flg3 = "checked";
		}
		
		event = (EesDmt6012Event) request.getAttribute("Event");
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
<title>Pre-Advice Report (Vessel Loading)</title>
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
<input type="hidden" name="pageno" value="ees_dmt_6012">
<input type="hidden" name="tml_yd_cd"> 
<input type="hidden" name="tml_clpt_ind_seq"> 
<input type="hidden" name="tml_vvd"> 

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top">
		
		<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr>
					<td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
				</tr>
				<tr>
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
				</tr>
			</table>
		<!--Page Title, Historical (E)--> 
    
	    <!--biz page (S)-->
	    	<table class="search" id="mainTable">
	       		<tr>
	       			<td class="bg">
						<table class="search"> 
	       					<tr class="h23">
								<td valign="top">
									<!--  biz_1  (S) -->

									<table class="search" border="0" style="width:800;"> 
										<tr class="h23">
											<td width="40">POD</td>
											<td width="100"><input type="text" name="s_tml_yd_cd" caption="POD" maxlength="7" style="width:80;ime-mode:disabled;" value="" class="input1" dataformat="uppernum"></td>
											<td width="100">VVD POD ETA</td>
											<td width="250">
											<input type="text" name="s_fm_dt" style="width:75;" class="input1" value=""  dataformat="ymd" caption="Start Date" maxlength="10" size="10" cofield="to_dt" onFocus="this.select();">
											&nbsp;~&nbsp;
											<input type="text" name="s_to_dt" style="width:75;" class="input1" value=""  dataformat="ymd" caption="End Date" maxlength="10" size="10" cofield="fm_dt" onFocus="this.select();">&nbsp;
											<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"  style="cursor:hand" onClick="callDatePop('ETA')">
											</td>
											<td width="30">VVD</td> 
											<td width="120"><input type="text" style="width: 80; ime-mode:disabled;" class="input" maxlength="9" value="" name="s_vvd" caption="VVD" dataformat="uppernum" required></td>
											
											<td width="">DMT tariff : DMIF, CTIC </td> 
										</tr>
									</table>
									<!--  biz_1   (E) -->
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		<!--biz page (E)-->

		<table class="height_8">
			<tr>
				<td></td>
			</tr>
		</table>
		
		<!-- Grid  (S) -->
			<table class="search" id="mainTable"> 
	       		<tr>
	       			<td class="bg">
						<table width="720"  id="mainTable">
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
		
		<table class="height_8">
			<tr>
				<td></td>
			</tr>
		</table>


		<!-- Tab ) (S) -->
	   		
			
			<div id="tabLayer" style="display:Inline;">
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
		<!-- Grid (E) -->
			</div>
			
						
			<div id="tabLayer" style="display:none;">
		<!-- Grid  (S) -->
			

		<!-- Grid (E) -->

			</div>
		<!--  Button_Sub (S) -->
		
    	<!-- Button_Sub (E) -->	
					
		<!--Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
		       	<tr>
		       		<td class="btn1_bg">
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
											<td class="btn1" name="btn_down_excel" id="btn_Retrieve">Data D/L</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
	    <!--Button (E) -->

    	</td>
	</tr>
</table>

<!-- Copyright(E)--> <!-- 개발자 작업  끝 -->
</form>
</body>
</html>