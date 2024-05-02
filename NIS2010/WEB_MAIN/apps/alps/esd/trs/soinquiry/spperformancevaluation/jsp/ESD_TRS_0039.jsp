<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0039.jsp
*@FileTitle : S/P Performance Evaluation Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-27
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-10-27 juhyun
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
<%@ page import="com.hanjin.apps.alps.esd.trs.soinquiry.spperformancevaluation.event.EsdTrs0039Event"%>
<%
	EsdTrs0039Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수
	//String successFlag = "";
	//String codeList  = "";
	//String pageRows  = "100";
	String today = DateTime.getFormatString("yyyyMMdd");
	String userId ="";
	String eq_ctrl ="";

	try {

	   SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   userId=account.getUsr_id();
	   eq_ctrl=account.getOfc_cd();

		event = (EsdTrs0039Event)request.getAttribute("Event");

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
<title>S/P Performance Evaluation Creation <%=userId%> <%=today%></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	<%= JSPUtil.getIBCodeCombo("wo_ev_grd_cd", "01", "CD00847", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("shpr_ev_grd_cd", "01", "CD00847", 0, "")%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		loadPage();
		getVendorComboList(); 
		initVendorCombo(document.combo_svc_provider);
	} 
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="hid_cre_dt" value="<%=today%>">
<input type="hidden" name="hid_cre_usr_id" value="<%=userId%>">
<input type="hidden" name="hid_cre_ofc_cd" value="<%=eq_ctrl%>">
<input type="hidden" name="hid_period" value="I">
<input type="hidden" name="hid_from_date">
<input type="hidden" name="hid_to_date">
<input type="hidden" name="hid_provider">
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
							<td width="120">Work Order Date</td>
							<td>
								<table border="0" style="height:15; width:480; ">
                                	<tr>
                                		<td class="sm" width="160" style="padding-left:15">
                                			<input name="radio_period" type="radio"  type="radio" class="trans"  checked  OnChange="fnchange_period();" >Issued&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<input name="radio_period" type="radio"  type="radio" class="trans" OnChange="fnchange_period();" >Evaluated</td>
										<td class="stm">
											<input  name="from_date"  type="text" maxlength="8" style="width:75" onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this);">&nbsp;~&nbsp;<input name="to_date" type="text" maxlength="8" style="width:75" onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this);" ><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" img src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"  name="btns_calendar"></td>
                                	</tr>
                                </table>
                             </td>
						</tr>
					</table>
					<table height="2"><tr><td></td></tr></table>
					<table class="search_in" border="0">
						<tr class="h23">
						    <td width="120">Service Provider</td>
							<td width="152"><script language="javascript">ComComboObject('combo_svc_provider', 2, 150, 0);</script></td>
							<td width="390"><input name='svc_provider' type="text" style="width:302;" value="" readonly  class="input2"  title="This inputbox cant't write"><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" img src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name='btng_provider'></td>
							<td width="100">Work Order No.</td>
							<td align="right"><input name="wonumber" type="text" style="width:188;" onFocus='fun_Focus(this)' onBlur="val_check(this,'WO NUMBER');"><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" img src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"  onClick="wo_OnPopupClick('W/O No.');"></td>

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

					<table class="height_10"><tr><td></td></tr></table>

					<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
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
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_save" name="btng_save">Save</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->


						</tr></table>
					</td></tr>
					</table>
					<!-- : ( Button_ Sub ) (E) -->


					<table width="100%" class="search">
						<tr>
							<td class="stm"><img src="/hanjin/img/ico_star.gif" width="13" height="9" border="0" vspace="2">&nbsp;Evaluation Item #1 : How do you satisfy the level of service provider's operation on the work order?</td>
						</tr>
						<tr>
							<td class="stm"><img src="/hanjin/img/ico_star.gif" width="13" height="9" border="0" vspace="2">&nbsp;Evaluation Item #2 : How does the customer(consignor) evaluate the level of service provider's operation on the work order?</td>
						</tr>
					</table>


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