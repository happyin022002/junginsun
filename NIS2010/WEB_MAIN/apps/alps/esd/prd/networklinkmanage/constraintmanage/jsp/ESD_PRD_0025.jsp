<%
/*=========================================================
*SM Lines(c) 2018 SM Lines
*@FileName : ESD_PRD_0025.jsp
*@FileTitle : Multi Exception Customer
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2018.01.08
===============================================================================
 ========================================================*/
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
	Exception serverException   = null;				//서버에서 발생한 에러
	String strErrMsg 			= "";				//에러메세지
	int rowCount	 			= 0;				//DB ResultSet 리스트의 건수

	String successFlag 			= "";
	String codeList  			= "";
	String pageRows  			= "100";

	String strUsr_id			= "";
	String strUsr_nm			= "";
	String v_nod_cd			    = "";
	String v_nod_cnst_itm_cd	= "";
	String v_nod_cnst_seq		= "";
	String v_cnst_cst_expt		= "";
	Logger log = Logger.getLogger("com.hanjin.alps.esm.spc.ESD_PRD_0025");

	try {		
		v_nod_cd						= JSPUtil.getNull(request.getParameter("p_nod_cd"));
		v_nod_cnst_itm_cd				= JSPUtil.getNull(request.getParameter("p_nod_cnst_itm_cd"));
		v_nod_cnst_seq					= JSPUtil.getNull(request.getParameter("p_nod_cnst_seq"));
		v_cnst_cst_expt					= JSPUtil.getNull(request.getParameter("p_cnst_cst_expt"));
		
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


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
<title>Exception Customer</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

	<%= JSPUtil.getIBCodeCombo("cnst_expt_tp_cd", "01", "CD03564", 0, "")%>

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();" onunload="fn_unload()">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="nod_cd" value="<%=v_nod_cd%>">
<input type="hidden" name="nod_cnst_itm_cd" value="<%=v_nod_cnst_itm_cd%>">
<input type="hidden" name="nod_cnst_seq" value="<%=v_nod_cnst_seq%>">
<input type="hidden" name="cnst_cst_expt" value="<%=v_cnst_cst_expt%>">

<!-- 개발자 작업	-->
<!-- <!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top">
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr>
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;<span id='title_m'>Exception Customer</span></td>
				</tr>
			</table>


			<table class="height_10"><tr><td></td></tr></table>

			<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
			<table width="100%" class="search" border="0">
				<tr>
					<td class="bg">
						<!-- : ( Grid ) (S) -->
						<table width="100%" id="mainTable">
	                        <tr>
	                        	<td>
	                            	<script language="javascript">ComSheetObject('sheet1');</script>
	                        	</td>
	                        </tr>
	                    </table>
						<!-- : ( Grid ) (E) -->
	
					</td>
				</tr>
				
			<table width="100%" class="sbutton">
		       	<tr>
		       		<td height="71" class="popup">				
						<table width="100%" class="button">
						 <tr>
						 	<td class="btn2_bg">
						 		<table border="0" cellpadding="0" cellspacing="0">
						 			<td width="100">
						 				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						 					<tr><td class="btn2_left"></td>
						 						<td class="btn2" name="btn_add">Row Add</td>
						 						<td class="btn2_right"></td>
						 					</tr>
						 				</table>
						 			</td>						 			
						 		</table>
						 	</td>
						 </tr>
						</table>
						</td>
					</tr>
				</table>
			</table>

			<table width="100%" class="sbutton">
		       	<tr>
		       		<td height="71" class="popup">
		       		<!-- <td height="71"> -->
		       			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
		       				<tr>
		       					<td class="btn3_bg"> 
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>											
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn1_left"></td>
														<td class="btn1" id="btn_save" name="btn_save">Save</td>
														<td class="btn1_right"></td>
													</tr>
												</table>
											</td>
											
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn1_left"></td>
														<td class="btn1" id="btn_close" name="btn_close">Close</td>
														<td class="btn1_right"></td>
													</tr>
												</table>
											</td>											
																						
											<!-- Repeat Pattern -->
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Button : pop ) (E) -->
		</td>
	</tr>
</table>
<!-- <!-- OUTER - POPUP (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>