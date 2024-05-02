<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0014.jsp
*@FileTitle : Service Order 생성화면 - Chassis or Genset
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-04
*@LastModifier : poong
*@LastVersion : 1.0
* 2006-10-04 poong 
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
<%@ page import="com.hanjin.apps.alps.esd.trs.chassisgensetsomanage.chassisgensetsomanage.event.EsdTrs0014Event"%>
<%
	EsdTrs0014Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수
	SignOnUserAccount account = null;

	try {

		account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		event = (EsdTrs0014Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}


	String today = DateTime.getFormatString("yyyyMMdd");
	String beforeOneMonth = DateTime.addMonths(today, -1);
%>
<html>
<head> 
<title>Service Order Creation - Chassis or Genset</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript"> 
var today = '<%=today%>';
var beforeOneMonth = '<%=beforeOneMonth%>';

	<%= JSPUtil.getIBCodeCombo("trsp_crr_mod_cd", "", "CD00283", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("trsp_so_cmb_tp_cd", "", "CD00762", 0, "")%>

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		setKindEnabled();
	}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="TRSP_SO_TP_CD">
<input type="hidden" name="TRSP_SO_STS_CD">
<input type='hidden' name='TRSP_SO_EQ_KIND'>
<input type='hidden' name='EQ_TPSZ_CD'>
<input type="hidden" name="form_cre_usr_id" value="<%=account.getUsr_id()%>">
<input type="hidden" name="form_usr_ofc_cd" value="<%=account.getOfc_cd()%>">
<input type="hidden" name="dist_div_cd" value="G"> <!-- Grid OnChange Event : G, Multi Apply팝업화면에서 Apply일때는 "F"  )-->

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
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
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_rowadd" name="btn_rowadd">Row Add</td><td class="btn1_right"></td></tr></table></td>
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
							<td width="8%" rowspan="2">Kind</td>
							<td width="25%">
								<table class="search_sm" style="width:98%;">
									<tr>
										<td class="stm" align="center"><input type="radio" name='kind_chassis' class="trans" value="Z" onClick='setKindEnabled()'  checked>
										Chassis&nbsp;&nbsp;&nbsp;
										<input type="radio" name='kind_chassis' value="G" onClick='setKindEnabled()' class="trans">Genset</td>
									</tr>
								</table>

							</td>

							<td width="32%">
								<table height="17" class="search_sm" style="width:98%">
									<tr>
										<td class="stm" align="center"><input type="radio" name='kind_hire' class="trans" value="D" onClick='setKindEnabled()' checked>
											Drayage&nbsp;&nbsp;
											<input type="radio" value="N" name='kind_hire' class="trans" onClick='setKindEnabled()'>
											On Hire &nbsp;&nbsp;
											<input type="radio" value="F" name='kind_hire' class="trans" onClick='setKindEnabled()'>
											Off Hire</td>
									</tr>
								</table>
							</td>
							<td>
								<table class="search_sm" style="width:100%">
									<tr>
										<td class="stm" align="center"><input type="radio" class="trans" name='kind_manual' value="manual" onClick='setKindEnabled();' checked>
										Manual&nbsp;&nbsp;
										<input type="radio" value="from_eq_master" name='kind_manual' onClick='setKindEnabled();' class="trans">
										From EQ Master</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
					<table style="height:2;"><tr><td></td></tr></table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="8%"></td>
							<td width="58%" style="padding-right:6;">
								<table height="20" class="search_sm" style="width:98%">
									<tr>
										<td class="stm" align="center"><input type="radio" class="trans" name='kind_bundle' value="single_unit" onClick='setKindEnabled();' checked>
										Single Unit &nbsp;&nbsp;&nbsp;&nbsp;
										<input type="radio" name='kind_bundle' value="bundle_stack" class="trans"onClick='setKindEnabled();'>
										Bundle-Stack &nbsp;&nbsp;&nbsp;
										<input type="radio" name='kind_bundle' value="bundle_flatbed" class="trans"onClick='setKindEnabled();'>
										Bundle-Flatbed</td>
									</tr>
								</table>

								<table class="height_1"><tr><td></td></tr></table>
							</td>
							<td width="8%" style="padding-left:2;">Unit</td>
							<td width="12%" style="padding-left:3;">
							<select name="bundle_unit" style="width:60;" onChange="">
								<option value='2'>2</option>
								<option value='3'>3</option>
								<option value='4'>4</option>
								<option value='5'>5</option>
								<option value='6'>6</option>
								<option value='7'>7</option>
								<option value='8'>8</option>
								<option value='9'>9</option>
							</select>
							</td>
							<td width="3%">SET</td>
							<td align="right"><input name="bundle_set" type="text" style="width:100;" onChange='checkNumber(this, true);'maxlength=6></td>
						</tr>
					</table>

					<table class="height_1"><tr><td></td></tr></table>

						<table class="search_in" border="0">
							<tr class="h23">
								<td width="77">Quantity</td>
								<td width="180"><input name="unit_qty" type="text" style="width:100" onBlur='checkNumber(this, true);'></td>
								<td width="140">On Hire Creation Date </td>
								<td width="251" class="sm"><input name="fmdate" type="text" style="width:75;" value="<%=beforeOneMonth%>" onChange='checkNumber(this, false);' maxlength=8>&nbsp;~&nbsp;<input name="todate" type="text" style="width:75;" value="<%=today%>" onChange='checkNumber(this, false);' maxlength=8>
									<img name='search_hiredate' class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
								<td width="81">On Hire Yard</td>
								<td width="66"><input name="hire_loc" type="text" style="width:61" onChange='getComboList(this);' onKeyup='enterCheck(this)' maxlength=5></td>
								<td width="63"><script language="javascript">ComComboObject('hire_yd', 1, 60, 0);</script></td>
								<td><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_search"></td>
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
                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet');</script>
                        </td></tr>
                    </table>
					<table width="100%" id="hiddenTable1">
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
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_rowadd" name="btng_rowadd">Row Add</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_delete" name="btng_delete">Delete</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_fillineq" name="btng_fillineq">File in EQ No.</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_multipleapply" name="btng_multipleapply">Multiple Apply</td><td class="btn2_right"></td></tr></table></td>

							<td class="sm" style="padding:0,5,0,13;">Unit
								<select name="bundle2_unit" style="width:40;">
									<option value='2'>2</option>
									<option value='3'>3</option>
									<option value='4'>4</option>
									<option value='5'>5</option>
									<option value='6'>6</option>
									<option value='7'>7</option>
									<option value='8'>8</option>
									<option value='9'>9</option>
								</select>
							</td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_bundling" name="btng_bundling">Bundling</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_unbundling" name="btng_unbundling">Unbundling</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->


						</tr></table>
					</td></tr>
					</table>
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_downexcel" name="btng_downexcel">Down Excel</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_socreation" name="btng_socreation">S/O Creation</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_woissue" name="btng_woissue">W/O Issue</td><td class="btn2_right"></td></tr></table></td>
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

<form name='woForm' method='POST' action='ESD_TRS_0023.screen'>
<input type='hidden' name='trsp_so_ofc_cty_cd'>
<input type='hidden' name='trsp_so_seq'>
<input type='hidden' name='eq_mode' value='CG'>
<input	type="hidden" name="sysCommUiTitle" value="Issue">
<input	type="hidden" name="pgmNo" value="ESD_TRS_0023">
<input	type="hidden" name="sysCommUiNavigation" value="Trans S/O > Work Order">
</form>

</body>
</html>
