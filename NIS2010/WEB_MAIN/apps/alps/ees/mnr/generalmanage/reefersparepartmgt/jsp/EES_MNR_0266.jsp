<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0266.jsp
*@FileTitle : Spare Part VSL Inventory Code
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.02
*@LastModifier : 차상영
*@LastVersion : 1.0
* 2014.12.02 차상영
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.event.EesMnr0266Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0266Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id       =	account.getUsr_id();
		strUsr_nm       = account.getUsr_nm(); 
		
		event = (EesMnr0266Event)request.getAttribute("Event");
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
<title>Spare Part VSL Inventory Code</title>
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

<body  onLoad="setupPage();">

<form name="form"> 
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="new_yn">
 
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
					<td class="btn1" name="btn_retrieve">Retrieve</td>
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
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_del">Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>		
    	<!--Button (E) -->
	
		<!--biz page (S)-->
		<!-- 2014.12.03 조회 콤보 숨김
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">

				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="70">Maker</td>
					<td width="380"><script language="javascript">ComComboObject('spr_prt_vndr_seq',2,370,0,1,1);</script></td>
					<td width="70">Model No.</td>
					<td width="180"><script language="javascript">ComComboObject('spr_ut_mdl_nm',2,133,0,1,1);</script></td>					
				</tr>
				</table>				
			
		</td></tr></table>
		-->
		<table class="height_8"><tr><td></td></tr></table>	
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
			<table class="search" border="0">
			<tr>
			    <td align="right">
				   <table>
				   	<tr> 
				   	<td>Ver. : <input type="text" name="txt_ver" size="1" class="input2" readonly>&nbsp;&nbsp;</td>
			     <td>Create date : <input type="text" name="txt_cre_dt" size="10" class="input2" readonly>&nbsp;</td>
				   	</tr>
				   </table>
			    </td>	   
			</tr>
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
			
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_add">Row Add</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>	
				
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_row_del">Row Del</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>	
				
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_downexcel">Down Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>	
				
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_upload">Upload</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>	
					
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_format_down">Format Down</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>							
									
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			
			
			</td></tr>
		</table>
		<!--biz page (E)-->	
	</td></tr>
</table>

<!--  엑셀 업로드용 숨김 그리드 -->
<div style="display:none;">
	<table width="100%"> 
		<tr>
			<td width="100%">
				<script language="javascript">ComSheetObject('sheet2');</script>
			</td>
		</tr>
	</table>			
</div>
<!--  엑셀 업로드용 숨김 그리드 -->


</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp" %>
