<%/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_BKG_1147.jsp
*@FileTitle : Thailand Manifest
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.22
*@LastModifier : Kim Jin-Seung
*@LastVersion : 1.0
* 2012.06.22 Kim Jin-Seung
* 1.0 Creation
* 2012.06.22 김진승 [?] Thailand Manifest
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.thailand.event.EsmBkg1147Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg1147Event event = null; //PDTO(Data Transfer Object including Parameters)
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
		
		event = (EsmBkg1147Event) request.getAttribute("Event");
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
<title>Thailand: Manifest Data Download _ B/L List</title>
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
<input type="hidden" name="pageno" value="ESM_BKG_1147">
<input type="hidden" name="pol_cd"> 
<input type="hidden" name="pod_cd"> 
<input type="hidden" name="trnk_vvd"> 

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
											<td width="30">VVD</td> 
											<td width="100"><input type="text" style="width: 80; ime-mode:disabled;" class="input1" maxlength="9" value="" name="s_vvd" caption="VVD" dataformat="uppernum" required></td>
											<td width="30">DEL</td>
											<td width="100"><input type="text" name="s_del_cd" caption="DEL" maxlength="5" style="width:50;ime-mode:disabled;" value="" class="input1" dataformat="uppernum" required> <input type="text" name="s_del_nod_cd" caption="DEL" maxlength="2" style="width:30;ime-mode:disabled;" value="" class="input1" dataformat="uppernum" ></td>
											<td width="30">POL</td>
											<td width=""><input type="text" name="s_pol_cd" caption="POL" maxlength="5" style="width:50;ime-mode:disabled;" value="" class="input" dataformat="uppernum"></td>
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
						<table width="60%"  id="mainTable">
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
							<tr align="right">
								<td>Total B/L Count&nbsp;&nbsp;<input type="text" name="tot_bl_cnt" maxlength="5" style="width:50;text-align:right" class="input2" dataformat="uppernum" value="" readonly></td>
							</tr>
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
			<table class="search" id="mainTable"> 
	       		<tr>
	       			<td class="bg">
						<table width="100%"  id="mainTable">
							<tr align="right">
								<td>Total Container Count&nbsp;&nbsp;<input type="text" name="tot_cntr_cnt" maxlength="5" style="width:50;text-align:right" class="input2" dataformat="uppernum" value="" readonly></td>
							</tr>
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet3');</script>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>

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
											<td class="btn1" name="btn_down_excel" id="btn_Retrieve">Down Excel</td>
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