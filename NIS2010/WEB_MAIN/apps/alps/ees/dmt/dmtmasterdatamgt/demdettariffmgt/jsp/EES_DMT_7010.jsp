<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_7010.jsp
*@FileTitle : DEM/DET User Role Match
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.16
*@LastModifier : Lim Chang Bin
*@LastVersion : 1.0
* 2013.07.16 Lim Chang Bin
* 1.0 Creation
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event.EesDmt7010Event"%>

<%@ page import="org.apache.log4j.Logger" %>
<%
	EesDmt7010Event  	event = null;               //PDTO(Data Transfer Object including Parameters)
    Exception 			serverException   = null;   //서버에서 발생한 에러
    String 	strErrMsg = "";                      	//에러메세지
    int 	rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";
    
    String usr_role_cd = "";
    String usr_role_nm = "";
    
    Logger log = Logger.getLogger("com.hanjin.apps.dmtmasterdatamgt.demdettariffmgt");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

        event = (EesDmt7010Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

 		// User Role Code 멀티콤보 
	    String temp_usr_role_cd = JSPUtil.getIBCodeCombo("", "", "CD03239", 0, "");
 		
	    if(temp_usr_role_cd != null && temp_usr_role_cd.length() > 8) {
	    	usr_role_cd = temp_usr_role_cd.substring(temp_usr_role_cd.indexOf("Code = \"")+8, temp_usr_role_cd.lastIndexOf("\""));
	    	usr_role_nm = temp_usr_role_cd.substring(temp_usr_role_cd.indexOf("Text = \"")+8, temp_usr_role_cd.indexOf("\";")); 
	    }		
	    
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>DEM/DET Office Inquiry by Yard</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        
        
        loadPage("<%=usr_role_cd%>", "<%=usr_role_nm%>");
    }
</script>
</head>
<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="chk_usr_id" value=""> <!--User ID Check용-->

<!-- 개발자 작업 -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
    <tr><td valign="top">
    <!--Page Title, Historical (S)-->
    </td></tr>
    
    
    <tr><td valign="top">
    <!--Page Title, Historical (S)-->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
        </table>
    
    <table class="search"> 
            <tr><td class="bg">
                <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:660;"> 
                    <tr class="h23"> 
                    <td width="70">User ID</td>
					<td width="150"><input type="text" name="usr_id" style="width:150;text-align:Left;ime-mode:disabled" maxlength=20 class="input" tabindex='1' value="">&nbsp;&nbsp;

                    <td width="65">User Name</td>
					<td width="300"><input type="text" name="usr_locl_nm" style="width:300" maxlength=100 class="input" tabindex='1' value="">&nbsp;&nbsp;
					</td>
					
					<tr class="h23"> 
                    <td width="70">Office Code</td>
                    <td><input type="text" style="width:80;" dataformat="engup" class="input" name= "ofc_cd" value="" onKeyPress="javascript:ComKeyOnlyAlphabet('uppernum');">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_ofc_cd"></td>
					<!--td width="90"><input type="text" name="ofc_cd" style="width:80;text-align:Center;ime-mode:disabled" maxlength=6 class="input" tabindex='1' value="" onKeyPress="DmtComKeyOnlyAlphabet('upperall')"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_ofc_cd"></td-->
					
					
					<td width="65">Role Code</td>
					<td width="" colspan="3" style="padding-left:2">
					<script language="javascript">ComComboObject('usr_role_cd', 2, 160 , 1)</script>
					</td>
                </table>

                <!--  biz_1  (E) -->
             
                
                <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
                
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
														<td class="btn2" name="btn_RowAdd">Row Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_RowDelete">Row Delete</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_downExcel">Down Excel</td>
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
        
     <!--Button (S) -->
     <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
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
        	</tr>
        </table>
       </td></tr>
    </table>
    <!--Button (E) -->         
    </td>
    </tr>
</table>
<!-- Copyright (S) -->
<!-- Copyright(E)-->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>