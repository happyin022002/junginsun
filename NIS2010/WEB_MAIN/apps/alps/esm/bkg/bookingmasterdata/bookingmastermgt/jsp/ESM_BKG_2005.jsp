<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_2005.jsp
*@FileTitle : Hard Coding Content
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.24
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2012.08.24 조정민
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg2005Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg2005Event event = null; //PDTO(Data Transfer Object including Parameters)
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

		event = (EsmBkg2005Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		request.setCharacterEncoding("euc-kr");
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		strhrd_cdg_id = JSPUtil.getNull(request.getParameter("hrd_cdg_id"));
		for(int i=0; i<10; i++){
			attr_nm[i] = JSPUtil.getNull(request.getParameter("attr_nm"+(i+1)));
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


		
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="attr_nm1"  value="<%=attr_nm[0]%>">
<input type="hidden" name="attr_nm2"  value="<%=attr_nm[1]%>">
<input type="hidden" name="attr_nm3"  value="<%=attr_nm[2]%>">
<input type="hidden" name="attr_nm4"  value="<%=attr_nm[3]%>">
<input type="hidden" name="attr_nm5"  value="<%=attr_nm[4]%>">
<input type="hidden" name="attr_nm6"  value="<%=attr_nm[5]%>">
<input type="hidden" name="attr_nm7"  value="<%=attr_nm[6]%>">
<input type="hidden" name="attr_nm8"  value="<%=attr_nm[7]%>">
<input type="hidden" name="attr_nm9"  value="<%=attr_nm[8]%>">
<input type="hidden" name="attr_nm10"  value="<%=attr_nm[9]%>">
<table width="835" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
       
             <!--Page Title, Historical (S)-->
             <table width="100%" border="0" cellpadding="0" cellspacing="0"
                    class="title">
                    <tr>
                    	<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; Hard Coding Contents </td>
                    </tr>
             </table>

<!--Page Title, Historical (E)-->

			<!--biz page (S)-->
			<table class="search">
				<tr>
					<td class="bg">
						<table class="search" border="0" style="width: 280;">
							<tr class="h23">
								<td width="20">ID</td>
								<td width="150">
									<input type="text" style="width:150; ime-mode:disabled" name="hrd_cdg_id" class="input" maxlength="20" readOnly value="<%=strhrd_cdg_id%>">	
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
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn2_left"></td>
											<td class="btn2" name="btn_Copy">Copy</td>
											<td class="btn2_right"></td>
										</tr>
									</table>
								</td>
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
       	<tr>
			<td class="">
				<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:0;,padding-left:5;"> 
       				<tr>
       					<td class="" align="middle">
		    				<table border="0" cellpadding="0" cellspacing="0">
		    					<tr>
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn1_left"></td>
												<td class="btn1" name="btn_Close" id="btn_Close">Close</td>
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
