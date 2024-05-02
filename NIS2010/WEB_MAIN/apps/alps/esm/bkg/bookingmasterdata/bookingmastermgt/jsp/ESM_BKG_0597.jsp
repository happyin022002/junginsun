<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0597.jsp
*@FileTitle : BDR Access Setting
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.01
*@LastModifier : Shin Kyu Jeong
*@LastVersion : 1.0
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
<%@ page import="com.hanjin.framework.core.view.template.Screen"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0597Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0597Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";
	String strhrd_cdg_id = "";
	String[] attr_nm = {"","","","","","","","","",""};


	Logger log = Logger.getLogger("com.hanjin.apps.BookingMasterData");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg0597Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		request.setCharacterEncoding("euc-kr");
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");



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


		
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="sheet_usr_id">

<!-- <table width="835" class="popup" cellpadding="10" border="0">  -->
<tr><td class="top"></td></tr>
<tr><td valign="top">
       
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->

			<!--biz page (S)-->
			<table class="search">
				<tr>
					<td class="bg">
						<table class="search" border="0" style="width: 280;">
							<tr class="h23">
							
					<td width=""><select name="search_option" style="width:90;">
						<option value="N" >User Name</option>
						<option value="I"  selected>User ID</option>
					
						</select></td>
<!-- 								<td width="20">ID</td> -->
								<td width="150">
									<input type="text" style="width:150; ime-mode:disabled" name="search_box" class="input" maxlength="20"  >	
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>

			<table class="height_8"><tr><td></td></tr></table>
		
			<!-- Grid BG Box  (S) -->
	     	<table width="100%" class="search" id="mainTable">
	       	<tr><td class="bg">
				
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
	       		<tr>
					<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
<!-- 								<td> -->
<!-- 									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button"> -->
<!-- 										<tr> -->
<!-- 											<td class="btn2_left"></td> -->
<!-- 											<td class="btn2" name="btn_Copy">Copy</td> -->
<!-- 											<td class="btn2_right"></td> -->
<!-- 										</tr> -->
<!-- 									</table> -->
<!-- 								</td> -->
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
											<td class="btn2" name="btn_RowDel">Row&nbsp;Delete</td>
											<td class="btn2_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
	    	<!-- Button_Sub (E) -->	
					
				</td></tr>
			</table>
			<!-- Grid BG Box  (S) -->
	
	<!--biz page (E)-->
	
	
	
	<!--Button (S) -->
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
				<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:0;,padding-left:5;"> 
       				<tr>
       					<td class="btn1_bg"><table border="0" cellpadding="0" cellspacing="0">
		    					<tr>
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn1_left"></td>
												<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
												<td class="btn1_right"></td>
																					
												<td class="btn1_left"></td>
												<td class="btn1" name="btn_Save" id="btn_Save">Save</td>
												<td class="btn1_right"></td>
												
								
											</tr>
										</table>
				
									</td>
								
								</tr>
							</table>
							</td>
						</tr>
					</table>
		
				</td>
			</tr>
		</table>
    <!--Button (E) -->
	</td></tr>
		</table>
	

</form>
</body>
</html>
