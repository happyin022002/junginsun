<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1109.jsp
*@FileTitle : Europe Advanced Manifest: Customs Setup 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.03
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2010.09.03 김경섭
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

<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
	   
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
<title></title>
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
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
		

<!-- OUTER - POPUP (S)tart -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
		
		<!-- : ( Search Options ) (S) -->
 			<!--biz page-1 (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0"> 
				<tr class="h23">
					<td width="65"> &nbsp;&nbsp;Country</td>
					<td width="200"><input type="text" style="width:32;" class="input" name="p_cnt_cd" value=""  maxlength='2'  dataformat='engup' style="ime-mode:disabled">
					</td>
					<td width="30">Port</td>
					<td width="146"><script language="javascript">ComComboObject('p_port', 1, 100, '');</script>
					<!--<input type="text" style="width:70;" class="input1" name="p_port" value="CNNBO" maxlength='5' dataformat='engup' style="ime-mode:disabled" >
					--></td>
					<td width="60">Terminal</td>
					<td width=""><script language="javascript">ComComboObject('p_tml', 1, 100, '');</script>
<!--					<input type="text" style="width:70;" class="input" name="p_tml" value="CNNBO" maxlength='7' dataformat='engup' style="ime-mode:disabled" >-->
					</td>
					<td></td>
				</tr>	
				</table> 
				<table class="" border="0"> 
				<tr class="h23">
					<td width="100">&nbsp;&nbsp;Customs Code</td>
					<td width="120"><input type="text" style="width:100;" class="input" name="p_cstms_cd" value=""  maxlength='5' dataformat='engupnum' style="ime-mode:disabled">
					</td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
				<table class="height_2"><tr><td></td></tr></table>
				<!-- : ( Grid ) (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table> 
				<!-- : ( Grid ) (E) -->	
				<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_RowAdd">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_RowDelete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	<tr>
		<td>	
			<table width="100%" align='left' class='search'>
				<tr>
					<td width="100%"> * Customs code for EXS of MTMAR =MT000113 (Hardcoding)</td>
				</tr>
			</table>						
		</td>
		<td>
    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	    <tr><td class="btn2_bg">
		            <table border="0" cellpadding="0" cellspacing="0">
		              <tr>
		              <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>	
			            <td class="btn1_line"></td>		
			              <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_Save">Save</td>
								<td class="btn1_right"></td>
								</tr>
							</table>
						  </td>	
						 <td width='10'></td>
		              </tr>
		            </table>
		    </td></tr>
		</table>
    	<!--Button (E) -->
		</td>
	</tr>
	</table>    	
</td></tr>
</table> 			
</form>
</body>
</html>