<%--
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESD_TRS_0290.jsp
*@FileTitle : D/O notification Setting
*Open Issues :
*Change history :
*@LastModifyDate : 2016-05-30
*@LastModifier : geun hwan park
*@LastVersion : 1.0
* 2016-05-30 geun hwan park
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
<%@ page import="com.hanjin.apps.alps.esd.trs.codemanage.donotificationsetting.event.EsdTrs0290Event"%>
<%
	EsdTrs0290Event  event = null;				    //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			    //서버에서 발생한 에러
	DBRowSet rowSet	  = null;						//DB ResultSet
	String strErrMsg = "";							//에러메세지
	String usrOfcCd="";
	String usrId="";
	String usrNm="";

	SignOnUserAccount account= null;

	try {

	    account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	    usrId = account.getUsr_id();
	    usrOfcCd = account.getOfc_cd();
        usrNm = account.getUsr_nm();
	    event = (EsdTrs0290Event)request.getAttribute("Event");

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
<title>D/O Notification Setting</title>
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
	<input type="hidden" name="usr_ofc_cd" value="<%=usrOfcCd%>">
	<input type="hidden" name="usr_id" value="<%=usrId%>">
	<input type="hidden" name="usr_nm" value="<%=usrNm%>">

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
									<td width = "80px">Contract No.</td>
									<td width = "220px">
										<!-- <input type="text" style="width:120" name='f_sc_no' maxlength=20 dataformat="engup" > -->
										<table>
											<tr>												
												<td><img src="/hanjin/img/blank.gif" width="2" height="1" border="0">
												<select name=f_ctrt_tp_cd style="width:60;">
													<option value=""></Option>
													<option value="S">S/C</Option>
													<option value="R">RFA</Option>
												</select><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img src="/hanjin/img/blank.gif" width="2" hight="1"><input type="text" style="width:120" name='f_sc_no' maxlength=20 dataformat="engup" ><img src="/hanjin/img/blank.gif" width="4" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_contract"></td>
												<!-- <td class="sm">&nbsp;&nbsp;<input type="radio" name="f_ctrt_tp_cd" class="trans" value="S" checked>&nbsp;S/C&nbsp;<input type="radio" name="f_ctrt_tp_cd" class="trans" value="R">&nbsp;RFA&nbsp;</td>
												<td align="right"><input type="text" style="width:120" name='f_sc_no' maxlength=20 dataformat="engup" ><img src="/hanjin/img/blank.gif" width="4" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_contract"></td> -->
											</tr>
										</table>
									</td>
									<td width = "90px">Effective Date</td>
									<td width = "120px">
										<input type="text" style="width:80" name='f_eff_dt' maxlength=8 dataformat="engup" >
										<img src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_onecalendar">
									</td>
									<td width="40px">Door</td>
									<td width="150px">
										<table>
											<tr>
												<td><input name="f_dor_nod_cd" type="text" style="width:56;" onChange='getComboList(this)'  maxlength=5 dataformat="engup"></td>
												<td><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><script language="javascript">ComComboObject('f_dor_nod_yd', 1, 55, 0);</script><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img src="/hanjin/img/blank.gif" width="2" hight="1"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name="btns_dorloc"></td>
											</tr>
										</table>
									</td>	
									<td width="40px">Active</td>
									<td>
										<select name="f_act_flg" style="width:50;">
											<option value=""></Option>
											<option value="Y">Y</Option>
											<option value="N">N</Option>
										</select>
									</td>
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
															<td class="btn2"  id="btng_rowdel" name="btng_rowdel">Row Delete</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" id="btn_save" name="btn_save">Save</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>												
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" id="btng_downexcel" name="btng_downexcel">Down Excel</td>
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