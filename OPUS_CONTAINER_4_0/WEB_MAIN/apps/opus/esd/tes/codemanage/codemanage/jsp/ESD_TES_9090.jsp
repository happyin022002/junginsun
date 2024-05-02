<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TES_9090.js
*@FileTitle : User Password
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-04
*@LastModifier : jongbaemoon
*@LastVersion : 1.0
* 2006-09-04 jongbaemoon

*@LastModifyDate : 2009.10.06
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.10.06 yOng hO lEE
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%
	GeneralEventResponse eventResponse	= null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception		serverException		= null;			//서버에서 발생한 에러
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;									//DB ResultSet 리스트의 건수
	int costcdCount	= 0;					  		//DB ResultSet 리스트의 건수
	
	String userId  = "";
	
	SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	userId = account.getUsr_id()!=null&&!account.getUsr_id().equals("")?account.getUsr_id():"";
	   
	String authUser = "";
	String insertFlag = "N";
	String processGubun = JSPUtil.getParameter(request, "gb    			".trim(), "");
	String lgs_cost_cd 	= JSPUtil.getParameter(request, "lgs_cost_cd    ".trim(), "");
	// 설계상 OPT NO 중복 체크하도록 되어있는거 같은데 로직 구현되어 있지 않아서 추가함.(2010-03-24)
	String lgs_cost_opt_no 	= JSPUtil.getParameter(request, "lgs_cost_opt_no    ".trim(), "");
	String openerUIName = JSPUtil.getParameter(request, "openerUIName   ".trim(), "");

	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
			
			if (eventResponse != null) {
				int existUser	= Integer.parseInt( eventResponse.getETCData("existUser") );
				int existCostCd = Integer.parseInt( eventResponse.getETCData("existCostCd") );
				
				if(existUser>0) {
					authUser = "Y";
				}else{
					authUser = "N";
				}	
				
				if(existCostCd>0) {
					insertFlag = "N";
				}else{
					insertFlag = "Y";
				}	
				
			} // end if
		} // end else
			
	}catch(Exception e) {
		out.println(e.toString());
	}	
%>
<html>
<head>
<title>User Password</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
<!--
	
	function setupPage(){
		ComShowMessage('<%=strErrMsg%>');
<% 
		if(!strErrMsg.equals("")){
%> 
		window.close();
<% 
		}
%>		
	} 

//-->
</script>
<base target="_self" />
</head>
<%
if(authUser.equals("Y")){
		
	if(processGubun.equals("REMOVE")){ 
%> 
<script language="javascript">
	window.dialogArguments.deleteOk();
	window.close();
</script>	
<%
		}  	
		if(processGubun.equals("ADD")){
			if(insertFlag.equals("Y")){			
%>
<script language="javascript">	
	window.dialogArguments.addOk();
	window.close();
</script>
<%	
			}else if(insertFlag.equals("N")){			
%>
<script language="javascript">	
	window.dialogArguments.addNo();
	window.close();
</script>
<%	
			}
		}
		if(processGubun.equals("MODIFY")){
%>
<script language="javascript">
	window.dialogArguments.modifyOk();
	window.close();
</script>
<%
		}							
 }else if(authUser.equals("N")){
%>
<script language="javascript">
	ComShowCodeMessage('TES10094');
</script>
<%
}
%>
<%if(authUser.equals("Y")&& openerUIName.equals("034")){%>
<script language="javascript">	
	var opener_obj = window.dialogArguments;
	opener_obj.removeAgreementHDR(); 
	window.close();
</script>
<%}%>
<%if(authUser.equals("Y")&& openerUIName.equals("035")){%>
<script language="javascript">	
	var opener_obj = window.dialogArguments;
	opener_obj.terminalAgreementConfirm(); 
	window.close();
</script>
<%}%> 
<%if(authUser.equals("Y")&& openerUIName.equals("036")){%>
<script language="javascript">	
	var opener_obj = window.dialogArguments;
	opener_obj.storageAgreementConfirm(); 
	window.close();
</script>
<%}%>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<!--<form method="post" name="form" onSubmit="return false;">-->
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="usr_id" value="<%=userId%>">
<input type="hidden" name="lgs_cost_opt_no">
<input type="hidden" name="gb" value="<%=processGubun%>">
<input type="hidden" name="lgs_cost_cd" value="<%=lgs_cost_cd%>">
<%--// 설계상 OPT NO 중복 체크하도록 되어있는거 같은데 로직 구현되어 있지 않아서 추가함.(2010-03-24) --%>
<input type="hidden" name="lgs_cost_opt_no" value="<%=lgs_cost_opt_no%>">
<input type="hidden" name="openerUIName" value="<%=openerUIName%>">


<!-- OUTER - POPUP (S)tart -->
<table width="300" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) --><!--
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/opuscntr/img/icon_title_dot.gif" align="absmiddle">&nbsp;User Password</td></tr>
		</table>
		--><!-- : ( Title ) (E) -->
		
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;User Password<!--span id="title"></span--></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->



		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
     	<table class="search">
       	<tr><td class="bg">



				<table class="search" border="0" style="width:262;">
					<tr class="h23">
						<td width="65">Password</td>
						<td width="123"><input type="password" name="usr_pwd" style="width:115" onkeypress="enter();"></td>
						<td>
							<!-- TABLE '#D' : ( Button : Main ) (S) -->
							<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
									<tr><td class="btn1_bg">
					
											<table border="0" cellpadding="0" cellspacing="0">
											<tr>
												<!-- Repeat Pattern -->
												<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr><td class="btn1_left"></td><td class="btn1" name="btng_confirm" id="btng_confirm">Confirm</td><td class="btn1_right"></td></tr></table></td>
												<!-- Repeat Pattern -->
					
											</tr></table>
					
									</td></tr>
							</table>
					    	<!-- TABLE '#D' : ( Button : Main ) (E) -->
						
						</td></tr>
				</table>




			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->




</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->

<table class="height_10"><tr><td></td></tr></table>

</form>
</body>
</html>
<%if(openerUIName.equals("")){%>
<script>
	document.form.lgs_cost_opt_no.value = window.dialogArguments.document.form.lgs_cost_opt_no.value;
</script>
<%}%>

<div style='display:none'>
	<script language="javascript">ComSheetObject('sheet');</script>
</div>		