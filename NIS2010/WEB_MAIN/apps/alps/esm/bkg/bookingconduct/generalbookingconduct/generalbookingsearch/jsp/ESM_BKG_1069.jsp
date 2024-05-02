<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1069.jsp
*@FileTitle : Route Detail inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2009.06.10 이병규
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg1069Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1069Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.generalbookingconduct.generalbookingsearch");

	String bkgNo = "";
	
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg1069Event)request.getAttribute("Event");
		bkgNo = JSPUtil.getParameter(request, "bkg_no");
						
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
<title>Welcome to nis2010!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<script language="javascript">

    function setupPage(){  

	    loadPage();
    }

</script>


<body class="popup_bg" onLoad="setupPage();"> 

<form name="form"> 
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="bkg_no" value="<%=bkgNo%>">


<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; Route Detail</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 		<!-- 1 (S) -->
		<table class="search"> 
       	<tr><td class="bg">
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">OCEAN ROUTE</td></tr>
				</table>
				<!--  biz_1  (S) -->
				<table width="684" class="search"> 
					<tr class="h23">
						<td width="100">&nbsp;ETA of 1st VVD</td>
						<td width=""><input type="text" name="vps_eta_dt_date" style="width:75;" class="input2" value="" readOnly>&nbsp;<input type="text" name="vps_eta_dt_time" style="width:45;" class="input2" value="" readOnly></td>
						<td width="100">&nbsp;ETA of DEL</td>
						<td width="" ><input type="text" name="del_eta_day" style="width:75;" class="input2" readonly>&nbsp;<input type="text" name="del_eta_time" style="width:45;" class="input2" readonly></td>						
					</tr>
				</table> 
						
				<!-- : ( Grid ) (S) -->
			
					<table width="684" class="search"  id="mainTable"> 
						<tr>
							<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table> 
					
			        <!-- : ( Grid ) (E) -->
			        <!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
				
						
				</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
		<table class="line_bluedot"><tr><td></td></tr></table>
				<table width="684" class="search"> 
				<tr class="h23">	
				<td><table width="684" class="search"> 
					    <tr class="h23">
					    <td>
					   <table class="search" border="0">
				           <tr><td class="title_h"></td>
					   <td class="title_s">ORIGIN INLAND ROUTE</td></tr>
				           </table>
				           <table border="0" style="width:310; background-color:white;" class="grid2"> 
						<tr  class="tr2_head">
						<td width="30%" colspan="2">POR</td>
						<td width="30%" colspan="2">POL</td>
						<td width="">Trans Mode</td>
					   </tr>
					   <tr>
						<td width="20%" class="input2"><input type="text" name="por_cd" style="width:100%;" class="noinput2" value="" readonly></td>
						<td width="10%" class="input2"><input type="text" name="por_nod_cd" style="width:100%;" class="noinput2" value="" readonly></td>
						<td width="20%" class="input2"><input type="text" name="pol_cd" style="width:100%;" class="noinput2" value="" readonly></td>
						<td width="10%" class="input2"><input type="text" name="pol_nod_cd" style="width:100%;" class="noinput2" value="" readonly></td>
						<td width=""><select name="org_trns_mod_cd" style="width:100%;" disabled>
						
						<option value="N"></option>
						<option value="A">Rail/Truck</option>
						<option value="B">Barge</option>
						<option value="E">Feeder/Truck</option>
						<option value="F">Feeder</option>
						<option value="R">Rail</option>
						<option value="T">Truck</option>
						<option value="U">Barge/Truck</option>
						</select></td>
					   </tr></table>
				 </td></tr></table>	
				</td>
			        <td>
					   <table class="search" border="0">
				           <tr><td class="title_h"></td>
					   <td class="title_s">DESTINATION INLAND ROUTE</td></tr>
				           </table>
				           <table border="0" style="width:320; background-color:white;" class="grid2"> 
						<tr  class="tr2_head">
						<td width="30%" colspan="2">POD</td>
						<td width="30%" colspan="2">DEL</td>
						<td width="">Trans Mode</td>
					   </tr>
					   <tr>
						<td width="20%" class="input2"><input type="text" name="pod_cd" style="width:100%;" class="noinput2" value="" readonly></td>
						<td width="10%" class="input2"><input type="text" name="pod_nod_cd" style="width:100%;" class="noinput2" value="" readonly></td>
						<td width="20%" class="input2"><input type="text" name="del_cd" style="width:100%;" class="noinput2" value="" readonly></td>
						<td width="10%" class="input2"><input type="text" name="del_nod_cd" style="width:100%;" class="noinput2" value="" readonly></td>
						<td width=""><select name="dest_trns_mod_cd" style="width:100%;" disabled>
						<option value="N"></option>
						<option value="A">Rail/Truck</option>
						<option value="B">Barge</option>
						<option value="E">Feeder/Truck</option>
						<option value="F">Feeder</option>
						<option value="R">Rail</option>
						<option value="T">Truck</option>
						<option value="U">Barge/Truck</option>
						</select></td>
					   </tr></table>
				 </td></tr></table>	
				</td>
				</tr>
				</table>
					
					
	
<table class="height_5"><tr><td></td></tr></table>				
					
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 

	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right">
				</tr></table></td>
			</tr>
		</table>
    <!--Button (E) -->
		</td></tr>
</table>
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
	
</form>			
</body>
</html>