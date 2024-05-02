<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_0075.jsp
*@FileTitle : Commodity Group Code Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-01
*@LastModifier : kimjin
*@LastVersion : 1.0
* 1.0 최초 생성
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.codemanage.commoditygroupcodemanage.event.EsdTrs0075Event"%>
<%
	EsdTrs0075Event event 		= null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg 			= "";			//에러메세지
	int rowCount	 			= 0;			//DB ResultSet 리스트의 건수
	String userId  				= "";
	String today 				= DateTime.getFormatString("yyyyMMdd");

	try {

		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		userId=account.getUsr_id();
		event = (EsdTrs0075Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null)
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Commodity Group Code Management</title>
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

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="cre_usr_id" value="<%=userId%>">
<input type="hidden" name="cre_dt" value="<%=today%>">
<input type="hidden" name="upd_usr_id" value="<%=userId%>">
<input type="hidden" name="upd_dt" value="<%=today%>">
<input type="hidden" name="insert_val" value="N">
<input type="hidden" name="delete_val" value="Y">
<input type="hidden" name="hid_row">
<input type="hidden" name="hid_col">
<input type="hidden" name="hid_vndr_seq" value="">


<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search_in" border="0"><tr><td></td></tr></table>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="48%" valign="top">


						<!-- TABLE '#D' : ( Button : Main ) (S) -->
						<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
					       	<tr><td class="btn1_bg" style="padding-right:5;">

								<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<!-- Repeat Pattern -->
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td><td class="btn1"  id="btn_retrieve1" name="btn_retrieve1">Retrieve</td><td class="btn1_right"></td></tr></table></td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td><td class="btn1"  id="btn_reset" name="btn_reset">Reset</td><td class="btn1_right"></td></tr></table></td>
									<!-- Repeat Pattern -->

								</tr></table>

							</td></tr>
						</table>
			    		<!-- TABLE '#D' : ( Button : Main ) (E) -->


						<table class="search" style="width:99%">
						<tr>
							<td class="bg">

								<table class="search" border="0" style="width:100%">
									<tr class="h23">
										<td width="140">Service Provider</td>
										<td><input name="vndr_cd" type="text" style="width:25%;" class="input1"  onBlur="vndr_check(this);"  onFocus='fun_Focus(this)' maxlength="9"><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><input name="vndr_nm" type="text" style="width:67%;" class="input1" onBlur="vndr_nm_check(this);"  onFocus='fun_Focus(this)' maxlength="100"><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" img src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" onClick="vndr_OnPopupClick();"></td>
									</tr>
									<tr class="h23">
										<td>S/P Commodity Group</td>
										<td><input name="vndr_commoodity_cd" type="text" style="width:25%;"  onFocus='fun_Focus(this)' onBlur="han_check(this,'A');"><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><input name="vndr_commoodity_nm" type="text" style="width:67%;"  onFocus='fun_Focus(this)'  maxlength="100"  onBlur="han_check(this,'B');"></td>
									</tr>
								</table>

								<table class="height_10"><tr><td></td></tr></table>

								<!-- TABLE '#D' : ( Grid ) (S) -->
								<!-- 'HEAD1-BGCOLOR : 192 235 163' , 'HEAD2-BGCOLOR : 231 250 249' , 'BORDER : 90 138 158' , 'HEAD1-FONT : 0 83 116' , 'DATA GRID BG (2 colors) : 255 255 255, 249 249 249 ' -->
            					<table width="100%" id="mainTable">
                                    <tr><td>
                                         <script language="javascript">ComSheetObject('sheet1');</script>
                                    </td></tr>
            		            </table>
								<!-- TABLE '#D' : ( Grid ) (E) -->

								<!-- : ( Button_ Sub ) (S) -->
								<table width="100%" class="button">
							       	<tr><td class="btn2_bg" style="padding-top:0;">
									<table border="0" cellpadding="0" cellspacing="0">
									<tr>

										<!-- Repeat Pattern -->
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2"  id="btng_rowadd" name="btng_rowadd">Row&nbsp;Add</td><td class="btn2_right"></td></tr></table></td>

										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2"  id="btn_delete1" name="btn_delete1">Delete</td><td class="btn2_right"></td></tr></table></td>
										<!-- Repeat Pattern -->


									</tr></table>
								</td></tr>
								</table>
								<!-- : ( Button_ Sub ) (E) -->

								<table class="height_10"><tr><td></td></tr></table>

								<!-- TABLE '#D' : ( Grid ) (S) -->
								<!-- 'HEAD1-BGCOLOR : 192 235 163' , 'HEAD2-BGCOLOR : 231 250 249' , 'BORDER : 90 138 158' , 'HEAD1-FONT : 0 83 116' , 'DATA GRID BG (2 colors) : 255 255 255, 249 249 249 ' -->
           				    	<table width="100%" id="mainTable">
                                    <tr><td>
                                         <script language="javascript">ComSheetObject('sheet2');</script>
                                    </td></tr>
            		            </table>
								<!-- TABLE '#D' : ( Grid ) (E) -->
								<!-- : ( Button_ Sub ) (S) -->
								<table width="100%" class="button">
							       	<tr><td class="btn2_bg" style="padding-top:0;">
									<table border="0" cellpadding="0" cellspacing="0">
									<tr>

										<!-- Repeat Pattern -->
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2"  id="btng_update2" name="btng_update2">Delete</td><td class="btn2_right"></td></tr></table></td>

										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2"  id="btng_save2" name="btng_save2">Save</td><td class="btn2_right"></td></tr></table></td>
										<!-- Repeat Pattern -->


									</tr></table>
								</td></tr>
								</table>
								<!-- : ( Button_ Sub ) (E) --></td>
							</tr>
						</table>
					</td>


					<td width="5%" valign="middle"><img src="/hanjin/img/img_arrow.gif" width="36" height="72" align="absmiddle"></td>


					<td width="47%" valign="top">

						<!-- TABLE '#D' : ( Button : Main ) (S) -->
						<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
					       	<tr><td class="btn1_bg" style="padding-right:5;">

								<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<!-- Repeat Pattern -->
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td><td class="btn1"  id="btn_retrieve2" name="btn_retrieve2">Retrieve</td><td class="btn1_right"></td></tr></table></td>
									<!-- Repeat Pattern -->

								</tr></table>

							</td></tr>
						</table>
			    		<!-- TABLE '#D' : ( Button : Main ) (E) -->


						<table class="search" style="width:99%">
						<tr>
							<td class="bg">

								<table class="search" border="0" style="width:100%">
									<tr class="h23">
										<td width="110">Rep. Commodity</td>
										<td><input name="rep_cmdt_cd" type="text" value="" style="width:25%;" maxlength="4" onBlur="rep_commodity_check(this);"  onFocus='fun_Focus(this)'><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" onClick="rep_OnPopupClick();"><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><input name="rep_cmdt_nm" class="input2" type="text" style="width:67%;" readonly  title="This inputbox cant't write"></td>
										</tr>
										<tr class="h23">
											<td>Commodity</td>
											<td><input name="cmdt_cd" type="text" style="width:25%;" maxlength="6"  onBlur="commodity_check(this);"  onFocus='fun_Focus(this)'><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" onClick="commodity_OnPopupClick()"><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><input name="cmdt_nm"  class="input2" type="text" style="width:67%;" readonly  title="This inputbox cant't write"></td>
									</tr>
								</table>

								<table class="height_10"><tr><td></td></tr></table>
								<!-- TABLE '#D' : ( Grid ) (E) -->
								<!-- 'HEAD1-BGCOLOR : 192 235 163' , 'HEAD2-BGCOLOR : 231 250 249' , 'BORDER : 90 138 158' , 'HEAD1-FONT : 0 83 116' , 'DATA GRID BG (2 colors) : 255 255 255, 249 249 249 ' -->
           				    	<table width="100%" id="mainTable">
                                    <tr><td>
                                         <script language="javascript">ComSheetObject('sheet3');</script>
                                    </td></tr>
            		            </table>

								<!-- TABLE '#D' : ( Grid ) (E) -->

								<!-- : ( Button_ Sub ) (S) -->
								<table width="100%" class="button">
							       	<tr><td class="btn2_bg" style="padding-top:6;">
									<table border="0" cellpadding="0" cellspacing="0">
									<tr>

										<!-- Repeat Pattern -->
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2"  id="btng_apply" name="btng_apply">Apply</td><td class="btn2_right"></td></tr></table></td>
										<!-- Repeat Pattern -->


									</tr></table>
								</td></tr>
								</table>
								<!-- : ( Button_ Sub ) (E) -->
							</td>
						</tr>


						<tr>
							<td>
								<table width="100%" id="mainTable">
									<tr height="0"><td width="100%">
										 <script language="javascript">ComSheetObject('sheet4');</script>
                                    </td></tr>
           		            </table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>


</td></tr>
</table>
<!-- Outer Table (E)-->


</form>

</body>
</html>

