<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1044.jsp
*@FileTitle : Add Concerned Party
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.21
*@LastModifier : Son Yun Seuk
*@LastVersion : 1.0
* 2009.07.21 Son Yun Seuk
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1044Event"%>

<%@ page import="org.apache.log4j.Logger" %>
<%
	
	String cust_cnt_cd = JSPUtil.getNull(request.getParameter("cust_cnt_cd"));
	String cust_seq = JSPUtil.getNull(request.getParameter("cust_seq"));
	String cust_nm = JSPUtil.getNull(request.getParameter("cust_nm"));
	String ofc_cd  = JSPUtil.getNull(request.getParameter("ofc_cd"));
	/*
	String[] select = new String[6];
	
	for(int i=0;i<6;i++)
	{
		select[i] = "";
	}
	if("C1".equals(cust_cntc_tp_cd))      select[1] = "selected";
	else if("C2".equals(cust_cntc_tp_cd)) select[2] = "selected";
	else if("B1".equals(cust_cntc_tp_cd)) select[3] = "selected";
	else if("B2".equals(cust_cntc_tp_cd)) select[4] = "selected";
	else if("AN".equals(cust_cntc_tp_cd)) select[5] = "selected";
	else select[0] = "selected";
	*/
	
	/*
	'LGBBB' '5782' CA C1 CHARVES_TEST
	*/
	
	EsmBkg1044Event event = null;
	Exception serverException   = null;	
	
	String strErrMsg = "";
	try 
	{
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	//ofc_cd = account.getOfc_cd();
	   
	   	event = (EsmBkg1044Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) 
		{
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	}
	catch(Exception e) 
	{
		out.println(e.toString());
	}
	
%>
<html>
<head>
<title>Add Concerned Party</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<script language="javascript">
    function setupPage()
    {  
	    loadPage();
    }
</script>


<body class="popup_bg" onLoad="setupPage();"> 

<form name="form"> 
<input type="hidden" name="f_cmd" value="">
<input type="hidden" name="office" value="<%=ofc_cd%>">
<input type="hidden" name="origin_cust_seq" value="<%=cust_seq%>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Add Concerned Party</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		<!--biz page (S)-->
		<table class="search" width="100%"> 
       		<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="60">Customer</td>
					<td width=""><input type="text" style="width:25;" class="input2" value="<%=cust_cnt_cd%>" name="cust_cnt_cd" readOnly>&nbsp;<input type="text" style="width:60;" class="input2" value="" name="cust_seq"  readOnly>&nbsp;<input type="text" style="width:300;" class="input2" value="<%=cust_nm%>" name="cust_lgl_eng_nm"   readOnly></td>
				</tr>
				
				</table>
				<!--  biz_1   (E) -->
			
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>	
			<!-- Grid  (S) -->
			<table width="100%" id="mainTable"> 
			<tr>
				<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
			</tr>
			</table> 
			<!-- Grid  (E) -->
			<!--  Button_Sub (S) -->
			 <table width="100%" class="button"> 
                  <tr><td class="btn2_bg">
                    <table border="0" cellpadding="0" cellspacing="0"><tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_Retrieve">Retrieve</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
				
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_Add">Row&nbsp;Add</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					
					
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_Delete">Row&nbsp;Delete</td>
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
	</td></tr></table>
		
			
			
			    <!-- : ( Button : pop ) (S) -->
            <table width="100%" class="sbutton">
                <tr><td height="71" class="popup">

                        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;padding-bottom:10;">
                            <tr><td class="btn3_bg">
                                    <table border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                            	<td width='70'><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_Save">Save</td>
				<td class="btn1_right"></td>
				</tr>
				</table></td>
				
				<td class="btn1_line"></td>
				
				<td width='70'><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_Close">Close</td>
				<td class="btn1_right"></td>
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

		