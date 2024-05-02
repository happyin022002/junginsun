<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_S011.jsp
*@FileTitle : SPP MNR Local Tariff Creation and Verify
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : WanGyu Kim
*@LastVersion : 1.0
* 2009.07.02 WanGyu Kim
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.event.EesMnrS011Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesMnrS011Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strVndr_seq		= "";
	String strVndr_nm		= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id 	= account.getUsr_id();
		strUsr_nm 	= account.getUsr_nm();
		strOfc_cd 	= account.getOfc_cd();
		strVndr_seq = account.getOfc_eng_nm();
		strVndr_nm 	= account.getOfc_krn_nm();
		
		
		event = (EesMnrS011Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title>Local Material Tariff Creation & Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">       
<script language="javascript">
    var strVndrSeq	= "<%=strVndr_seq%>";
    var strVndrNm	= "<%=strVndr_nm%>";
	var currOfcCd 	= "<%=strOfc_cd.trim() %>";
	var usrId     	= "<%=strUsr_id.trim()%>";
    
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<script language="javascript">ComSheetObject('sheet1');</script>
</head>

<body  onLoad="setupPage();"> 
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="mnr_meas_ut_cd">						<!-- Unit Of Mass -->
<input type="hidden" name="curr_cd">							<!-- Currency -->
<input type="hidden" name="eq_knd_cd">							<!-- EQUIPMENT 종류 구분 -->
<input type="hidden" name="eq_knd_nm">							<!-- EQUIPMENT 종류 구분명 -->
<input type="hidden" name="mnr_trf_knd_cd">						<!-- Tariff 종류 표시 -->
<input type="hidden" name="mnr_trf_sts_cd">						<!-- Tariff Status Code -->
<input type="hidden" name="pre_trf_no">							<!-- trf_no 생성용인자 -->
<input type="hidden" name="hdn_user_id" value="<%=strUsr_id%>">	<!-- Hidden UserId -->
<input type="hidden" name="std_trf_no">							<!-- Standard Tariff No -->
<input type="hidden" name="pagerows">      
<!-- 개발자 작업	-->
 
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
	</td></tr>
	<tr><td valign="top">
	
	
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Tariff Creation & Inquiry
</td></tr>
		</table>
		<!--Page Title, Historical (E)-->
	
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Delete">Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Request">Request</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Copy">Copy</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
	
	
		<!--biz page (S)-->
		<!-- 1 (S) -->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">


				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="60">Tariff No.</td>
					<td width=""><input type="text" name="search_trf_no" style="width:130;text-align:center" class="input1" required dataformat="engup" maxlength="20">&nbsp;<img name="trf_no_popup" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					<input type="hidden" name="trf_no" class="input2" readOnly="true">
					</td>
				</tr> 
				</table>			
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="60">Eff. from </td>
					<td width="130"><input type="text" name="eff_dt" style="width:80;text-align:center" class="input1" dataformat="ymd" maxlength="8" size="10">&nbsp;<img name="eff_dt_cal" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="110">S/Provider Code</td>
					<td width="252"><input type="text" name="vndr_seq" style="width:50;text-align:center" class="input2" readonly="readonly"">&nbsp;<input type="text" name="vndr_nm" style="width:178" class="input2" readonly="readonly"></td>
					<td width="60">Currency</td>
					<td width="100" style="padding-left:2"><script language="javascript">ComComboObject('combo4', 1, 80, 1, 0);</script></td>
					<td width="60">Status</td>
					<td width=""><script language="javascript">ComComboObject('combo1', 1, 140, 1, 0);</script></td>
				</tr> 
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="60">EQ Type </td>
					<td width="130" style="padding-left:2"><script language="javascript">ComComboObject('combo2', 1, 103, 1, 0);</script></td>
					<td width="110">Unit Of Measure</td>
					<td width="90" style="padding-left:0"><script language="javascript">ComComboObject('combo3', 1, 52, 1, 0);</script></td>
					<td width="80">Tariff Office</td>
					<td width="80"><input type="text" name="rqst_ofc_cd" style="width:60;text-align:center" class="input2" value="<%=strOfc_cd%>" readonly="readonly"></td>
					<td width="60">Cre. Date</td>
					<td width="100"><input type="text" name="cre_dt" style="width:80;text-align:center" class="input2" readonly="readonly"></td>
					<td width="60">Cre. User</td>
					<td width=""><input type="text" name="cre_usr_id" style="width:140;text-align:center" class="input2" value="<%=strUsr_id%>" readonly="readonly"></td>
				</tr> 
				</table>			
				<!--  biz_1   (E) -->

		</td></tr>
		</table>	
		<!-- 1 (E) -->
		
		<!-- 2 (S) -->		
		<table class="height_8"><tr><td></td></tr></table>
			<!-- Tab (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
				<tr>
					<td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
					</td>
				</tr>
			</table>
			<!-- Tab (E) -->	
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
			
				
		
		
<!--TAB Dry All (S) -->

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
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t1LoadExcel">Load&nbsp;Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t1DownExcel">Down&nbsp;Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
</div>

<!--TAB Dry All (E) -->


<!--TAB Reefer Box (S) -->

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
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t2LoadExcel">Load&nbsp;Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t2DownExcel">Down&nbsp;Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
</div>

<!--TAB Reefer Box (E) -->


<!--TAB Reefer Unit (S) -->

<div id="tabLayer" style="display:none">	
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t3sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->		
			
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t3LoadExcel">Load Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t3DownExcel">Down Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
</div>

<!--TAB Reefer Unit (E) -->

<!--TAB Special Dry (S) -->

<div id="tabLayer" style="display:none">	
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t4sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->		
			
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t4LoadExcel">Load Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t4DownExcel">Down Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
</div>

<!--TAB Special Dry (E) -->

<!--TAB Chassis (S) -->

<div id="tabLayer" style="display:none">	
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t5sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->		
			
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t1LoadExcel">Load Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t1DownExcel">Down Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
</div>

<!--TAB Chassis (E) -->

<!--TAB MG Set (S) -->

<div id="tabLayer" style="display:none">	
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t6sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->		
			
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t1LoadExcel">Load Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t1DownExcel">Down Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
</div>



			
			</td></tr>
		</table>
		<!-- 2 (E) -->
		
		
		<!--biz page (E)-->
	       <table class="search" border="0" style="width:100%;"> 
			<tr class="h23">
			<td width="" valign="top" style="padding: 20 0 0 0">
				<table border="0" style="width:100%; background-color:white;" class="grid2"> 
				<tr><td class="tr2_head" width="100">Remark(s)</td>  
					<td>     
					<textarea name="mnr_trf_rmk" wrap="off" style="width:100%;height:60;" maxLength="4000"></textarea>
					</td>  
				</tr> 
				</table>
			</td>
			</tr>
			</table>

	
	
	</td></tr>
		</table>
	

	
</form>
</body>
</html>
