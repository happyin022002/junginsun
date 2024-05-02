<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_SCE_0012.jsp
*@FileTitle : Exception Detail
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion :
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.exceptionmanage.exceptionsearch.event.EsdSce0012Event"%>
<%@ page import="com.clt.apps.opus.esd.sce.exceptionmanage.exceptionsearch.vo.SearchExptDetail01VO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdSce0012Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error on Server Side
	String strErrMsg = "";						//Error Message
	int rowCount	 = 0;						//DB ResultSet List Count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String           copExptNo   = "" ;
	String           copExptTpCD = "" ;
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.ExceptionManage.ExceptionSearch");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdSce0012Event)request.getAttribute("Event");
		SearchExptDetail01VO searchExptDetail01VO = event.getSearchExptDetail01VO();
	 
		copExptNo = searchExptDetail01VO.getCopExptNo();
		log.debug(" =========================================== copExptNo "+copExptNo);
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// The data obtained from the server side on load
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Exception Detail</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
	
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body onLoad="setupPage();">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
<tr><td valign="top">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

		<form name="form" method="post">
		<!-- <input type="hidden" name="sheet_no"> -->
		<input type="hidden" name="s_htp_cd" value="<%=copExptTpCD%>">
		<input type="hidden" name="f_cmd">



				<!-- TABLE '#D' : ( Button : Main ) (S) -->
				<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
								<tr><td class="btn1_bg">

										<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<!-- Repeat Pattern -->
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
											<td class="btn1_line"></td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn1_left"></td><td class="btn1" name="btn_copdetail" id="btn_copdetail">COP Detail</td><td class="btn1_right"></td></tr></table></td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn1_left"></td><td class="btn1" name="btn_send" id="btn_send">Send</td><td class="btn1_right"></td></tr></table></td>
											<!-- Repeat Pattern -->

										</tr></table>

								</td></tr>
						</table>
				<!-- TABLE '#D' : ( Button : Main ) (E) -->


				<!-- TABLE '#D' : ( Search Options ) (S) -->
				<table class="search">
				<tr>
					<td class="bg">
						<table class="search_in" border="0">
						<tr class="h23">
							<td width="90">Exception No.</td>
							<td width=""><input name="cop_expt_no" type="text" style="width:115; text-transform:uppercase;" value="<%=copExptNo%>" maxlength=14 ></td>
						</tr>
						</table>
					</td>
				</tr>
				</table>

				<!-- TABLE '#D' : ( Search Options ) (E) -->

				<table class="height_10"><tr><td></td></tr></table>

				<table class="search">
		       	<tr>
		       		<td class="bg">
						<!-- : ( Speed ) (S) -->
						<table style="width:100%; class="search">
						 		<tr>
							      <td width="30%">
								  <table width="40%" class="search">
										<tr>
										<td class="title_h"></td>
										<td class="title_s"> &nbsp;BKG Information </td>
										</tr>
										<tr><td class="height_5"></td></tr>
								  </table>

							    </td></tr>
						</table>
						<table width="100%" id="mainTable">
						<tr><td>
						   <script language="javascript">ComSheetObject('sheet1');</script>
						</td></tr>
						</table>

						<!-- : ( Speed ) (E) -->
						<!-- : ( Button : Sub ) (S) -->
						<table width="100%" class="sbutton">
		      			<tr><td class="align">
								<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

								<table style="width:100%; class="search">
						 		<tr>
									<td width="30%">
										<table width="40%" class="search">
										<tr>
											<td class="title_h"></td>
											<td class="title_s"> &nbsp;Exception Summary </td>
										</tr>
										<tr><td class="height_5"></td></tr>
										</table>
									 </td>
							    </tr>
								</table>
								<table width="100%" id="mainTable">
								<tr><td>
								   <script language="javascript">ComSheetObject('sheet2');</script>
								</td></tr>
								</table>

				 				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
								<table style="width:100%; class="search">
								 		<tr>
									      <td width="30%">
										  <table width="40%" class="search">
												<tr>
												<td class="title_h"></td>
												<td class="title_s"> &nbsp;Exception Detail </td>
												</tr>
												<tr><td class="height_5"></td></tr>
										  </table>

									    </td></tr>
								</table>
								<table width="100%" id="mainTable">
								<tr width="30%"><td>
								   <script language="javascript">ComSheetObject('sheet3');</script>
								</td></tr>
								</table>
								<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
								<table style="width:100%; class="search" >
								 		<tr>
									      <td width="30%" >
										  <table width="40%" class="search">
												<tr>
												<td class="title_h"></td>
												<td class="title_s"> &nbsp;Exception Confirm </td>
												</tr>
												<tr><td class="height_5" ></td></tr>
										  </table>

									    </td></tr>
								</table>
								<table width="100%" id="mainTable" >
								<tr><td>
								   <script language="javascript">ComSheetObject('sheet4');</script>
								</td><td></td><td></td></tr>
								</table>
							<!-- </td>
						</tr> -->
						</table>
			    		<!-- : ( Button : Sub ) (E) -->
					</td>
				</tr>
				</table>

				<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (END) ####### -->


		</form>
<span id="new_form"></span>

    </td></tr>
</table>
<!-- Outer Table (E)-->
</body>
</html>