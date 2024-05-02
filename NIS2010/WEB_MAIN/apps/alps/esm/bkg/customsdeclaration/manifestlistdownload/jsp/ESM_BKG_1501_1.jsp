<%
	/*=========================================================
	 *Copyright(c) 2017 Hi-Plus Card
	 *@FileName : esm_bkg_1501_1.jsp
	 *@FileTitle : ESM_BKG-1501_1
	 *Open Issues :
	 *Change history :
		 2017.08.03 하대성 2017 Renewal Version Transmit 반영
	 *@LastModifyDate : 2017.08.03
	 *@LastModifier : 하대성
	 *@LastVersion : 1.0
	 * 2017.08.03 하대성
	 * 1.0 Creation
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.event.EsmBkg1501Event"%>

<%
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	String strUsr_id = "";
	String strUsr_nm = "";
	String bl_no = request.getParameter("bl_no");
	//Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Select Deletion Code</title>
<meta http-eqEsmv="Content-Type" content="text/html; charset=UTF-8">
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top">
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr>
<%if(bl_no.equals("") || (bl_no == null)) {%>
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> 
 						Advance Cargo Information Download & Transmit
 					</span>
					</td>
<% } else { %>				
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> 
 						BL/No. <%=bl_no %>
 					</span>
					</td>
<% } %>
				</tr>
			</table>	
			<!-- : ( Title ) (E) -->
			
			<!-- : ( Search Options ) (S) -->
	 
			<table class="search"> 
	       		<tr>
	       			<td class="bg">
						<table class="search" border="0" style="width:100%;"> 
							<tr>
								<td>
									<table class="search" border="0" style="width:100%;"> 
										<tr class="h23">
											<td>
												Deletion Code&nbsp;
												<select name="del_cd" caption="Deletion Code">
													<option value="" selected></option>
													<option value="1">1.Cancellation of loading</option>
													<option value="3">3.Change of B/L number</option>
													<option value="4">4.Misregistration</option>	
													<option value="5">5.Other reason</option>
												</select> 
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr id="row1">
								<td>
									<table height="23" class="search" border="0" style="width:100%;"> 
										<tr>
											<td>
						
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr id="row2" style="display:none;">	
								<td>
									<table class="search" border="0" style="width:100%;"> 
										<tr class="h23">
											<td>
												 Deletion Reason&nbsp;
												<textarea name="del_reason" style="ime-mode:disabled" caption="Deletion Reason" rows="1" cols="38" dataformat="etc" maxlength="200"></textarea>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!-- : ( Search Options ) (E) -->
	
			<table class="height_5"><tr><td></td></tr></table>
		
		</td>
	</tr>
</table> 
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
	
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
		       	<tr>
		       		<td class="btn3_bg">
					    <table border="0" cellpadding="0" cellspacing="0">
						    <tr>
								<td>
									<table border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_del_new_trans">OK</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								
						        <td>
			                        <table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
			                        	<tr>
			                        		<td class="btn1_left"></td>
			                            	<td class="btn1" name="btn1_Close">Close</td>
			                            	<td class="btn1_right">
			                        	</tr>
			                        </table>
			                    </td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
<!--Button (E) -->
		</td>
	</tr>
</table>
</form>
</body>
</html>