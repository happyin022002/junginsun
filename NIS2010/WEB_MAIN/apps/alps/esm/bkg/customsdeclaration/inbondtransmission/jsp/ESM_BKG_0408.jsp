<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0408.jsp
*@FileTitle : In-Bond Arrival Manifest (Container Tab)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.06.19 김도완
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page
	import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page
	import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.event.EsmBkg0408Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0408Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지

	String strUsr_id = "";
	String strUsr_nm = "";

	String vvdCd = "";
	String podCd = "";
	
	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0408Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

        vvdCd  = JSPUtil.getParameter(request, "vvd_cd");
		podCd  = JSPUtil.getParameter(request, "pod_cd");
		
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Welcome to alps!</title>
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
<form name="form"><input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows">
<input type="hidden" name="page_no" value="ESM_BKG_0408">
<input type="hidden" name="h_vvd" value="">
<input type="hidden" name="h_pod" value="">
<input type="hidden" name="h_del" value="">
<input type="hidden" name="h_hub" value="">
<input type="hidden" name="h_cstms" value="">
<input type="hidden" name="hubModifyYn" value="">
<input type="hidden" name="cstmsModifyYn" value="">



<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	style="padding-top: 2; padding-left: 5;">

	<tr>
		<td valign="top"><!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" 
			class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif"
					align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>
		<!--Page Title, Historical (E)--> 

		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="30">VVD</td>
					<td width="120"><input type="text" style="width: 80; ime-mode:disabled;"
							class="input1" maxlength="9" value="<%=vvdCd%>" name="vvd" dataformat="uppernum" required></td>
					<td width="30">POD</td>
					<td width="120"><input type="text" name="pod" maxlength="5" style="width:50;ime-mode:disabled;" value="<%=podCd%>" class="input1" dataformat="uppernum" required ></td>
					<td width="90">In-bond Type</td>
					<td width="100"><select name="ibd_tp_cd" style="width:80;"class="input1">
						<option value="" selected>ALL</option>
						<option value="61">IT(61)</option>
						<option value="62">T&E(62)</option>
						<option value="63">IE(63)</option>
						</select></td>
					<td><table width="120" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_Mi_History">MI History</td>
					<td class="btn2_right"></td>
					</tr>
				</table></td>
					</tr> 
				</table>				
				
				
				
				
				<!--  biz_1   (E) -->
			
			<table class="line_bluedot"><tr><td></td></tr></table>
			
			
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->			
			
			</td></tr></table>
		<table class="height_5"><tr><td></td></tr></table>	
		
		
		
		<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
					</td></tr>
				</table>
		<!-- Tab ) (E) -->
<!--TAB 1 (S) -->

		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
<div id="tabLayer" style="display:inline">
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t1sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->
					
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Bl_Inquiry1">B/L Inquiry</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>						
						<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Cntr_Inquiry1">C/M Inquiry</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_DownExcel1">Down Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->		
		
</div>
<!--TAB 1 (E) -->

<!--TAB 2 (S) -->

<div id="tabLayer" style="display:none">
			
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t2sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->
					
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Bl_Inquiry2">B/L Inquiry</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>						
						<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Cntr_Inquiry2">C/M Inquiry</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_DownExcel2">Down Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->		
		
		
</div>
<!--TAB 2 (E) -->	
	</td></tr>
	</table>
	<!--biz page (E)-->


	
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_PMibAssign">P/MIB Assign</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Transmit">Transmit</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_EntryTypeSetUp">Entry Type Set-up</td>
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
	<!--
	    <table style="width:979;height:100">
	    	<tr><td>result : </td></tr>
	        <tr>
	            <td><textarea name="output" cols="100" rows="20"></textarea></td>
	        </tr>
	    </table>
	-->    
	    <!-임시 (E)-->
	    <table width="100%" id="mainTable" style="display:none">
	        <tr>
	            <td width="100%"><script language="javascript">ComSheetObject('sheet4');</script></td>
	        </tr>
	    </table>
<!-- Copyright(E)--> <!-- 개발자 작업  끝 -->
</form>
</body>
</html>