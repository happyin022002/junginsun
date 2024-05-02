<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_7008.jsp
*@FileTitle : Approval Authority Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 최성환 
*@LastVersion : 1.0
* 2009.10.09 최성환
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.event.EesDmt7008Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt7008Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();

		event = (EesDmt7008Event)request.getAttribute("Event");
		
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
<title>Approval Authority Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}

</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="usr_ofc_cd" value="<%=strUsr_ofc%>">
<input type="hidden" name="usr_id">
<input type="hidden" name="ar_hd_qtr_ofc_cd" value="" />
<input type="hidden" name="rhq_ofc_cd" value="" />
<input type="hidden" name="sub_ofc_cd" value="" />

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr><td valign="top">
	
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->
	
    
    <!--Button (S) -->
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
	<tr><td class="btn1_bg">
    	<table border="0" cellpadding="0" cellspacing="0">
		<tr>
           <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
               <tr><td class="btn1_left"></td>
               <td class="btn1" name="btn_retrieve" id="btn_Retrieve">Retrieve</td>
               <td class="btn1_right"></td>
               </tr>
           </table></td>
           <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
               <tr><td class="btn1_left"></td>
               <td class="btn1" name="btn_new">New</td>
               <td class="btn1_right"></td>
               </tr>
           </table></td>
           <td class="btn1_line"></td>
           <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
               <tr><td class="btn1_left"></td>
               <td class="btn1" name="btn_downexcel">Down Excel</td>
               <td class="btn1_right"></td>
               </tr>
           </table></td>
    	</tr>
    	</table>
	</td></tr>
	</table>
    <!--Button (E) -->
	
	<table class="search"> 
    <tr><td class="bg">
			<!--  biz_1  (S) -->
		<table class="search" border="0" style="width:979;"> 
		<tr class="h23"> 
				
			<td width="100" align="left">Approval Office</td>
			<td width="120" class="stm"><script language="javascript">ComComboObject('comboRHQ', 2, 90 , 0, 1, 0, true)</script></td>
			<td width="70">User Office </td>
			<td width="115"><input type="text" name="ofc_cd" dataformat="engup2" maxlength="6"  style="width:55;ime-mode:disabled;" class="input" value="" >&nbsp;<img src="img/btns_search.gif"width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="openPopup('ofc_cd')"></td>
			<td width="70">User Name </td>
			<td><input type="text" name="usr_nm" maxlength="30" style="width:200;" class="input" value="" >&nbsp;<img src="img/btns_search.gif"width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"  onClick="openPopup('usr_nm')"></td>
		</tr>
		</table>
			
	</td></tr>
	</table>
	
	<!-- earch Options_Speed (E) --> 	
	<table class="height_8"><tr><td></td></tr></table>
	
	<!-- Tab ) (S) -->
   	<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
   	<tr><td width="100%">
		<script language="javascript">ComTabObject('tab1')</script>
		<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
	</td></tr>
	</table>
	<!-- Tab ) (E) --> 
		
		
	<!--TAB - Before Booking (S) -->
	<div id="tabLayer" style="display:inline">		
		
		<!-- Tab BG Box ) (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
				
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t1sheet1');</script>
					</td>
				</tr>
			</table>				
			<!-- Grid  (e) -->
					
		</td></tr>
		</table>
		
	</div>
	<!--TAB - Before Booking (E) --> 

	<!--TAB - After Booking (S) -->
	<div id="tabLayer" style="display:none">

		<!-- Tab BG Box ) (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
				
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t2sheet1');</script>
					</td>
				</tr>
			</table>				
			<!-- Grid  (e) -->
					
		</td></tr>
		</table>

	</div>
	<!--TAB - After Booking (E) --> 		

	
	<!--TAB - Inactive (S) -->
	<div id="tabLayer" style="display:none">

		<!-- Tab BG Box ) (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
				
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t3sheet1');</script>
					</td>
				</tr>
			</table>				
			<!-- Grid  (e) -->
				
		</td></tr>
		</table>
		
	</div>
	<!--TAB - Inactive (E) --> 						
					
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	
	</td></tr>
	</table>
</td></tr>
</table>
<!-- Copyright (S) -->

<!-- Copyright(E)-->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>