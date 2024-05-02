<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0370.jsp
*@FileTitle : Mexico Customs Transmit
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.09.16 김도완
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.event.EsmBkg0370Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0370Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지

	String strUsr_id = "";
	String strUsr_nm = "";
	String search_flg1 = "";
	String search_flg3 = "";


	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
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
		
		event = (EsmBkg0370Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

	} catch (Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title></title>
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
<input type="hidden" name="pageno" value="ESM_BKG_0370">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	style="padding-top: 2; padding-left: 5;">

	<tr>
		<td valign="top">
		
		<!--Page Title, Historical (S)-->
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
    
		<table class="search"> 
       <tr class="h23">
       <td width=110>
				<table class="search_sm" border="0" style="width:110;height:84" >
				<tr class="h23">
					<td><input type="radio" name="search_flg" value="O" class="trans" <%=search_flg1%>>O/B(Trunk)</td>
				</tr>
				<tr	class="h23">
					<td><input type="radio" name="search_flg" value="T" class="trans">T/S(Feeder)</td>
				</tr>
				<tr	class="h23">	
					<td><input type="radio" name="search_flg" value="I" class="trans" <%=search_flg3%>>I/B(Trunk)</td>
				</tr>
				</table>
			</td>
			<td width="5" >&nbsp;</td>
       		<td width="80" > 
				<table class="search_sm" style="width:70;height:84" >
				<tr class="h23">
					<td>
					  <div> 
					 	 <input type="radio" name="search_cargo" value="F" class="trans" checked >Full
					  </div>
					  <div>					  
						<input type="radio" name="search_cargo" value="P" class="trans">Empty
					  </div>					  
					</td>
				</tr>				
				</table>
			</td>
			<td valign="top">
				<!--  biz_1  (S) -->
				<table class="height_8"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:780;"> 
				<tr class="h23">
					<td rowspan=2 width="20">&nbsp;</td>
					<td width="80">VVD</td> 
					<td width="164"><input type="text" style="width: 80; ime-mode:disabled;"
							class="input1" maxlength="9" value="" name="vvd" dataformat="uppernum" required></td>
					<td width="56">POL</td>
					<td width="108"><input type="text" name="pol_cd" maxlength="5" style="width:50;ime-mode:disabled;" value="" class="input" dataformat="uppernum" ></td>
					<td width="36">POD</td>
					<td width="118"> 
						<script language="javascript">ComComboObject('pod_cd', 1, 70, 0, 1,0,true);</script>
					</td>
					<td width="70">Total B/L</td>
					<td width=""><input type="text" name="total_bl" class="input2" style="width:50;ime-mode:disabled;text-align:right" class="input2" value="" readonly ></td>
				</tr>
				<tr class="h23">
					<td width="">Vessel Name</td>
					<td width=""><input type="text" name="vsl_eng_nm" style="width:110;" class="input2" value="" readonly></td>
					<td width="">Call Sign</td>
					<td width=""><input type="text" name="call_sgn_no" style="width:60;" class="input2" value="" readonly></td>
					<td width="">ETD</td>
					<td width=""><input type="text" name="etd" style="width:80;" class="input2" value="" readonly></td>
					<td width="26">ETA</td>
					<td width=""><input type="text" name="eta" style="width:80;" class="input2" value="" readonly></td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
				</td></tr>
			</table>
			<table class="line_bluedot"><tr><td></td></tr></table>
		
		<!-- Grid BG Box  (S) -->
     	
			
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->
			
			<!--  Button_Sub (S) -->
			
	    	<!-- Button_Sub (E) -->	
				
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
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
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Transmit">Transmit</td>
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
<!-- Copyright(E)--> <!-- 개발자 작업  끝 -->
</form>
</body>
</html>