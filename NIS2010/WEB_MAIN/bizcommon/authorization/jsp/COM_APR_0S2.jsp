<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : COM_APR_0S1.jsp
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.22
*@LastModifier : SSY
*@LastVersion : 1.0
* 1.0 최초 생성
*-------------------------------------------------------------------------------------------------------
* History
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.bizcommon.authorization.event.ComApr0S2Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	ComApr0S2Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String ofc_cd  			= ""; 
	String sub_sys_cd_auth = "";
	String sub_sys_cd = "";
	String auth_pgm_seq = "";
	String auth_pgm_btn_seq = "";
	String auth_pgm_fld_seq = "";
	String modify = "";

	auth_pgm_seq 			= JSPUtil.getParameter(request, "auth_pgm_seq".trim(), "");
	auth_pgm_btn_seq 		= JSPUtil.getParameter(request, "auth_pgm_btn_seq".trim(), "");
	auth_pgm_fld_seq 		= JSPUtil.getParameter(request, "auth_pgm_fld_seq".trim(), "");
	modify					= JSPUtil.getParameter(request, "modify".trim(), "");
	
	Logger log = Logger.getLogger("com.hanjin.apps.ConsultationSlipRequestMgt.ConsultationSlipRequestMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	    ofc_cd	  = account.getOfc_cd();
	    
		event = (ComApr0S2Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	
		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		if(eventResponse != null){
			sub_sys_cd_auth = JSPUtil.getNull(eventResponse.getETCData("SUB_SYS_CD_AUTH"));
			sub_sys_cd = JSPUtil.getNull(eventResponse.getETCData("SUB_SYS_CD"));
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Create/Modify Program Authorization List</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="/hanjin/css/OrganTree.css" type="text/css" rel="stylesheet" />
<script language="javascript" type="text/javascript" src="/hanjin/js/OrganTree.js"></script>
<script language="javascript" type="text/javascript" src="/hanjin/js/HashMap.js"></script>
<script language="javascript">
	function setupPage(){
		
		
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
	var sub_sys_cd_auth = "<%=sub_sys_cd_auth%>";
	var sub_sys_cd = "<%=sub_sys_cd%>";
</script>
</HEAD>
<body  onLoad="setupPage();"> 
<form name="form" method="post">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="ofc_cd"  value="<%=ofc_cd%>">
<input type="hidden" name="modify"  value="<%=modify%>">
<input type="hidden" name="auth_pgm_seq"  value="<%=auth_pgm_seq%>">
<input type="hidden" name="auth_pgm_btn_seq"  value="<%=auth_pgm_btn_seq%>">
<input type="hidden" name="auth_pgm_fld_seq"  value="<%=auth_pgm_fld_seq%>">
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Create/Modify Program Authorization List </td></tr>
        </table>
        <!-- : ( Title ) (E) -->
        
        <!--biz page (S)-->
        <table class="search"> 
       	<tr><td class="bg">
       			<!-- Grid  (S) -->
			<table width="100%" class="search"  id="mainTable"> 
				<tr>
					<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table> 			
			<!-- Grid (E) -->
				<table width="100%" class="button">
									<tr>
										<td class="btn2_bg">
											<table border="0" cellpadding="0" cellspacing="0">
												<tr>
													<td><table width="100%" border="0" cellpadding="0"	cellspacing="0" class="button">
															<tr>
																<td class="btn2_left"></td>
																<td class="btn2" name="btn_save">Save</td>
																<td class="btn2_right"></td>
															</tr>
														</table></td>
													<!-- <td><table width="100%" border="0" cellpadding="0"	cellspacing="0" class="button">
															<tr>
																<td class="btn2_left"></td>
																<td class="btn2" name="btn_t1rowAdd">Row Add</td>
																<td class="btn2_right"></td>
															</tr>
														</table></td>
													<td><table width="100%" border="0" cellpadding="0"cellspacing="0" class="button">
															<tr>
																<td class="btn2_left"></td>
																<td class="btn2" name="btn_t1rowDel">Row Delete&nbsp;</td>
																<td class="btn2_right"></td>
															</tr>
														</table></td> -->
												</tr>
											</table>
										</td>
									</tr>
								</table> 
			
			
			</td></tr>
		</table>
        <!--biz page (E)--> 

<table class="height_5"><tr><td></td></tr></table>

</td></tr></table>
<!-- OUTER - POPUP (E)nd -->

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

        <!--Button (S) -->  
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr>
        
        <td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>                    
            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Close">Close</td>
                    <td class="btn1_right"></td>
                </tr></table></td>                
            </tr>
        </table>
        <!--Button (E) -->
    
		</td>
		
		</tr>
		</table>
		
</td>
</tr>
</table>		
<!-- : ( Button : pop ) (E) -->

</form>
</BODY>

</HTML>

 <%@include file="../../include/common_alps.jsp"%>