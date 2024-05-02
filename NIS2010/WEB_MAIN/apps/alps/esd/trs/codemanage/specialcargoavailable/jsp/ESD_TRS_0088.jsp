<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0088.jsp
*@FileTitle : Special Cargo Available S/P
*Open Issues :
*Change history :
*@LastModifyDate : 2014-12-30
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2014-12-30 SHIN DONG IL
* History
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.codemanage.specialcargoavailable.event.EsdTrs0088Event"%>
<%
	EsdTrs0088Event  event = null;				    //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			    //서버에서 발생한 에러
	DBRowSet rowSet	  = null;						//DB ResultSet
	String strErrMsg = "";							//에러메세지
	int rowCount	 = 0;							//DB ResultSet 리스트의 건수
	String today = DateTime.getFormatString("yyyyMMdd");
	String userId="";
	String userNm="";
	String ofc_cd="";

	SignOnUserAccount account= null;

	try {

	    account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	    userId = account.getUsr_id();
	    ofc_cd = account.getOfc_cd();
        userNm = account.getUsr_nm();
	    event = (EsdTrs0088Event)request.getAttribute("Event");

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
<title>Special Cargo Available S/P</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

	function setupPage(){

		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}  // end if
		loadPage();
	}

</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
	<input type="hidden" name="f_cmd">
	<input type="hidden" name="iPage">
	<input type="hidden" name="login_ofc_cd" value="<%=ofc_cd%>">
	<input type="hidden" name="login_usr_id" value="<%=userId%>">
	<input type="hidden" name="login_usr_nm" value="<%=userNm%>">
	<input type="hidden" name="login_date" value="<%=today%>">
	<input type="hidden" name="ofc_cd" value="">
	

	<!-- Outer Table (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
		<tr>
			<td>
				<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
					<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
					<tr><td class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
				</table>
				<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
	
	
				<!-- TABLE '#D' : ( Button : Main ) (S) -->
				<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
					<tr>
						<td class="btn1_bg">
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<!-- Repeat Pattern -->
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn1_left"></td>
												<td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td>
												<td class="btn1_right"></td>
											</tr>
										</table>
									</td>
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
												<td class="btn1" id="btn_new" name="btn_new">New</td>
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
				<!-- TABLE '#D' : ( Button : Main ) (E) -->
		
				<!-- TABLE '#D' : ( Search Options ) (S) -->
				<table class="search">
					<tr>
						<td class="bg">
							<table class="search_in" border="0">
								<tr class="h23">
									<td width="10%">Service Provider</td>
									<td width="45%">
										<input type="text" style="width:80" name='combo_svc_provider' maxlength=6 dataformat="engup" onChange='getTextVendorSeq(sheetObjects[0], document.form, this.value)' onKeyup='enterCheck(this)'>
										<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name='btn_provider'>
										<input name="svc_provider"  type="text" style="width:300;" value="" readonly  class="input2">
									</td>
									<td width="31%"></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<!-- TABLE '#D' : ( Search Options ) (E) -->
		
				<table class="height_10"><tr><td></td></tr></table>
		
				<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
				<table class="search" border="0">
					<tr>
						<td class="bg">
							<table width="100%" id="mainTable1">
		                        <tr>
		                        	<td>
		                             	<script language="javascript">ComSheetObject('sheet1');</script>
			                        </td>
			                   </tr>
		                    </table>
		
							<!-- : ( Grid ) (E) -->
							<!-- : ( Button_ Sub ) (S) -->
							<table width="100%" class="button">
						       	<tr>
						       		<td class="btn2_bg">
										<table border="0" cellpadding="0" cellspacing="0">
											<tr>
												<!-- Repeat Pattern -->
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2"  id="btng_rowadd" name="btng_rowadd">Row Add</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2"  id="btng_delete" name="btng_row_del">Row Delete</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<!-- Repeat Pattern -->
											</tr>
										</table>
									</td>
								</tr>
							</table>
							<!-- : ( Button_ Sub ) (E) -->
						</td>
					</tr>
				</table>
				<!-- TABLE '#D' : ( Grid BG Box ) (E) -->
			</td>
		</tr>
	</table>
	<!-- Outer Table (E)-->
</form>
</body>
</html>