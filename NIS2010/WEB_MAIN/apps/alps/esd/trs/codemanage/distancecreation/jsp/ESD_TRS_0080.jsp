<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0080.jsp
*@FileTitle : Distance Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-31
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-10-31 juhyun
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
<%@ page import="com.hanjin.apps.alps.esd.trs.codemanage.distancecreation.event.EsdTrs0080Event"%>
<%
	EsdTrs0080Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수
	String today = DateTime.getFormatString("yyyyMMdd");
	String userId="";
	String ofc_cd="";


	try {

	   SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   userId=account.getUsr_id();
	   ofc_cd=account.getOfc_cd();
	   //userAuth=account.getAuth();

		event = (EsdTrs0080Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		/*
		아래부분은 꼭 지켜주셔야 에러메세지가 정상적으로 전달이 됩니다.
		보시다시피 먼저 에러를 받고 에러가 아닐시에 EventResponse로 값을 전달하셔야 합니다.
		*/
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title>Distance Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

	<%= JSPUtil.getIBCodeCombo("dist_meas_ut_cd", "01", "CD00780", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("conv_meas_ut_cd", "01", "CD00780", 0, "")%>

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
<input type="hidden" name="verify_check_yn" value="N">
<input type="hidden" name="ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="hid_upd_date" value="<%=today%>">
<input type="hidden" name="hid_cre_date" value="<%=today%>">
<input type="hidden" name="hid_cre_usr_id" value="<%=userId%>">
<input type="hidden" name="hid_upd_usr_id" value="<%=userId%>">

<input type="hidden" name="hid_frm_node">
<input type="hidden" name="hid_to_node">

<input type="hidden" name="opner_from_node">
<input type="hidden" name="opner_from_zip_code">
<input type="hidden" name="opner_to_node">
<input type="hidden" name="opner_to_zip_code">

<input type="hidden" name="del_gubun">
<input type="hidden" name="page_no">
<input type="hidden" name="total_page_no">


<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
	       	<tr><td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>

					<td class="btn1_line"></td>

					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_reset" name="btn_reset">Reset</td><td class="btn1_right"></td></tr></table></td>
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
							<td width="70">From Node</td>
							<td width="54"><input name="frm_node" type="text" style="width:50;" maxlength="5" onFocus='fun_Focus(this)'  onChange="getComboList_val(this, document.frm_yard, 'F');" onBlur=""></td>
							<td width="130"><script language="javascript">ComComboObject('frm_yard', 1, 58, 0)</script><img src="/hanjin/img/blank.gif" width="4" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_frmnode"></td>
							<td width="60">To Node </td>
							<td width="54"><input name="to_node" type="text" style="width:50;" maxlength="5" onFocus='fun_Focus(this)'  onChange="getComboList_val(this, document.to_yard, 'T');"  onBlur=""></td>
							<td width="140"><script language="javascript">ComComboObject('to_yard', 1, 58, 0)</script><img src="/hanjin/img/blank.gif" width="4" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name="btns_tonode"></td>
							<td width="94">From Zip Code</td>
							<td width="170"><input name="frm_zip" type="text" style="width:width:104;"  onBlur="han_check(this, document.frm_zip, 'F');" onFocus='fun_Focus(this)'  maxlength="15"></td>
							<td width="77">To Zip Code</td>
						    <td align="right"><input name="to_zip" type="text" style="width:width:104;" onBlur="han_check(this, document.to_zip, 'T');" onFocus='fun_Focus(this)'   maxlength="15"></td>
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


	                <table width="100%" class="search">
			            <tr><td class="gray">Conversion Ratio : 1 Mile = 1.609344km</td></tr>
			           </table>
					 <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
                    </table>
					<!-- : ( Grid ) (E) -->


					<!-- : ( Button_ Sub ) (S) -->
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_fileselect" name="btng_fileselect">File Select</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_downexcel" name="btng_downexcel">Down Excel</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_delete" name="btng_delete">Delete</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_live" name="btng_live">Live</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_rowadd" name="btng_rowadd">Row Add</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_verify" name="btng_verify">Verify</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_save" name="btng_save">Save</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_history" name="btng_history">History</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->


						</tr></table>
					</td></tr>
					</table>
					<!-- : ( Button_ Sub ) (E) -->
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->




</td></tr>
</table>
<!-- Outer Table (E)-->


</form>
</body>
</html>