<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_EAS_0202.jsp
*@FileTitle : Contact point
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.29
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.10.29 백형인
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
<%@ page import="com.hanjin.apps.alps.esd.eas.eac.eacmgt.event.EsdEas0202Event"%>

<%
	EsdEas0202Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String pageRows  = "100";

	// SignOnUserAccount Info
	String usr_id 					= "";
	String strUsr_nm				= "";
	String ofc_cd					= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_nm 			= account.getUsr_nm();
		usr_id       		= account.getUsr_id();      
		ofc_cd      		= account.getOfc_cd();     

		event = (EsdEas0202Event)request.getAttribute("Event");
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
<title>Contact point</title>
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
<input type="hidden" name="session_usr_nm" value="<%=strUsr_nm%>">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="code_key">
<input type="hidden" name="g_vndr_seq">
<input type="hidden" name="usr_id" 		value="<%=usr_id%>" >
<input type="hidden" name="ofc_cd" 		value="<%=ofc_cd%>" >
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr>
	<td valign="top">	
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->

			
		<!--Button (S) -->
	    <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 0; padding-bottom: 2;">
		<tr>
			<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_retrieve" >Retrieve</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_save">Save</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td>
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

		<!--biz page (S)-->
		<table class="search"> 
	       	<tr><td class="bg">
				<!-- biz_1  (S) -->
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
					
<!-- 						<td width="40">RHQ</td> -->
<!-- 						<td width="100"> -->
<!-- 							<script language="javascript">ComComboObject('s_rhq_ofc_cd',1,100,0,0,0);</script> -->
<!-- 						</td> -->
<!-- 		                <td width="25"></td> -->
<!-- 						<td width="45">Office</td> -->
<!-- 						<td width="100" style="padding-left:0;"> -->
<!-- 							<script language="javascript">ComComboObject('s_ofc_cd',1,100,0,0,0);</script> -->
<!-- 						</td> -->
						<td width="70">Country</td>
						<td width="50">
							<input type="text" name="s_cnt_cd" maxlength=2 style="width:50;ime-mode:disabled" dataformat="engup">
						</td>
						<td width="25"></td>
						<td width="100">Control Office</td>
						<td width="50">
						<input type="text" name="s_ofc_cd" style="width:50;ime-mode:disabled" maxlength=6 dataformat="engup">
						</td>
						<td width="25"></td>
						<td width="70">S/P Code</td>
						<td width="220">
							<input type="text" dataformat="ymd" style="width: 70; text-align:center;" class="input" name="s_vndr_seq">
							<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_vndr_seq">
							<input type="text" dataformat="ymd" style="width: 100; text-align:left;" class="input2" name="s_vndr_nm" readonly="readonly">  
						</td>
		                <td width="25"></td>
						<td width="150">Contact Point Register</td>
						<td width="45" style="padding-left:0;">
							<script language="javascript">ComComboObject('contact_point_exists',1,45,1,0,0);</script>
						</td>						
						<td width="149"></td>
	                </tr>					
				</table>		
	          </td>
			</tr>
		</table>
        <!--biz page (E)-->		 
        
        <table class="height_5"><tr><td></td></tr></table>
		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable">
      	<tr><td class="bg" valign="top">
                <table class="search" border="0">
                   <tr><td class="title_h"></td>
                   <td class="title_s">MDM S/P Information</td></tr>
                </table>       	
			<!-- Grid  (S) -->
			
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 
			<!-- Grid (E) -->
			

			</td></tr>
		</table>
        <table class="height_5"><tr><td></td></tr></table>
		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable">
       	<tr><td class="bg" valign="top">
               <table class="search" border="0">
                   <tr><td class="title_h"></td>
                   <td class="title_s">Contact point</td></tr>
               </table>       	
			<!-- Grid  (S) -->
			
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table> 
			<!-- Grid (E) -->
			

			</td></tr>
		</table>
	<!-- Grid BG Box  (E) -->

		<!--  Button_Sub (S) -->
		<table width="100%" class="button">
			<tr>
				<td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn2_left"></td>
									<td class="btn2" name="btn_RowAdd">Row&nbsp;Add</td>
									<td class="btn2_right"></td>
								</tr>
							</table>
						</td>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn2_left"></td>
									<td class="btn2" name="btn_RowDel">Row Delete</td>
									<td class="btn2_right"></td>
								</tr>
							</table>
						</td>
<!-- 						<td> -->
<!--                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button"> -->
<!--                                    <tr> -->
<!--                                        <td class="btn2_left"></td> -->
<!--                                        <td class="btn2" name="btn_downexcel">Down Excel</td> -->
<!--                                        <td class="btn2_right"></td> -->
<!--                                    </tr> -->
<!--                                </table> -->
<!--                            </td>								 -->
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!-- Button_Sub (E) -->

<!-- Grid  (S) -->														
<table width="100%" id="mainTable"> 
<tr>
	<td width="100%">
		<script language="javascript">ComSheetObject('sheet3');</script>
	</td>
</tr>
</table> 
<!-- Grid (E) -->
<!-- 개발자 작업  끝 -->
		</td>
	</tr>
</table>
</form>
</body>
</html>