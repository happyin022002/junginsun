<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TES_9200.jsp
*@FileTitle : Vol. Accumulate Method
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-23
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.09.23 yOng hO lEE
* 1.0 Creation
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes9200Event"%>
<%
	EsdTes9200Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수

	try {


		event = (EsdTes9200Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Vol. Accumulate Method</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}  // end if
		// InitTab();
		loadPage();
	}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">

<!-- <input type="button" value="script reload" onClick="uiScriptReload()"> -->

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="is_valid_yd_cd">
<input type="hidden" name="yd_cd_hidden">
<input type="hidden" name="yd_cd">
<input type="hidden" name="yd_cd_name">
<input type="hidden" name="row_num">

<div id="hidden_sheets1" style="display:none">
<-- hidden Method info -->
<script language="javascript">ComSheetObject('sheet1');</script>
</div>
<div id="hidden_sheets1" style="display:none">
<-- hidden Costcode info -->
<script language="javascript">ComSheetObject('sheet2');</script>
</div>

<input type="hidden" name="vndr_seq">


<!-- OUTER - POPUP (S)tart -->
<table width="400" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Volume Accumulate Method</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_delete" id="btn_delete">Delete</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
				</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->


		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<table class="search" border="0">
					<tr class="h23">
						<td width="100">Contract Office</td>
						<td width=""><input type="text" name="ctrt_ofc_cd" style="width:90" value=""></td></tr>
					<tr class="h23">
						<td>S/P</td>
						<td><input type="text" name="vndr_lgl_eng_nm" style="width:255" value=""></td></tr>

					<tr class="h23">
						<td>Period</td>
						<td><input type="text" name="accm_fm_dt" style="width:75" value="" maxlength="10" onKeyUp='tes_isNumD(this,"Y");tes_moveFocus(this, this.form.accm_to_dt, 10);' onKeyDown='tes_chkInput(this);'>&nbsp;<!--
							 --><img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1"><!--
							 -->&nbsp;&nbsp;~&nbsp;&nbsp;<input type="text" name="accm_to_dt" maxlength="10" style="width:75" value="" onKeyUp='tes_isNumD(this,"Y");' onKeyDown='tes_chkInput(this);'>&nbsp;<!--
							 --><img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"></td></tr>

					<tr class="h23">
						<td>UOM</td>
						<td class="sm"><input type="radio" name="tml_accm_ut_cd" value="T" class="trans" checked>&nbsp;TEU&nbsp;&nbsp;&nbsp;<!--
							 --><input type="radio" name="tml_accm_ut_cd" value="B" class="trans">&nbsp;BOX&nbsp;&nbsp;&nbsp;</td></tr>
				</table>


				<table class="height_5"><tr><td></td></tr></table>
				<!-- : ( Speed ) (S) -->
				<table border="0" style="width:362;" class="grid2">
				<tr class="tr2_head">
					<td colspan="8">Cost Code For Volume Accumulate</td>
				</tr>

				<tr align="center">
					<td width="30" style="border-right:1pt solid white" align="right"><input type="checkbox" name="SVLDFL" value="SVLDFL" class="trans"></td>
					<td width="60" align="left">SVLDFL</td>
					<td width="30" style="border-right:1pt solid white" align="right"><input type="checkbox" name="SVLDMT" value="SVLDMT" class="trans"></td>
					<td width="60" align="left">SVLDMT</td>
					<td width="30" style="border-right:1pt solid white" align="right"><input type="checkbox" name="SVLDTS" value="SVLDTS" class="trans"></td>
					<td width="60" align="left">SVLDTS</td>
					<td width="30" style="border-right:1pt solid white" align="right"><input type="checkbox" name="TPNDFL" value="TPNDFL" class="trans"></td>
					<td width="62" align="left">TPNDFL</td></tr>

				<tr align="center">
					<td style="border-right:1pt solid white" align="right"><input type="checkbox" name="TPNDMT" value="TPNDMT" class="trans"></td>
					<td align="left">TPNDMT</td>
					<td style="border-right:1pt solid white" align="right"><input type="checkbox" name="TPNDTS" value="TPNDTS" class="trans"></td>
					<td align="left">TPNDTS</td>
					<td style="border-right:1pt solid white" align="right"><input type="checkbox" name="SVRHCC" value="SVRHCC" class="trans"></td>
					<td align="left">SVRHCC</td>
					<td style="border-right:1pt solid white" align="right"><input type="checkbox" name="SVRHCD" value="SVRHCD" class="trans"></td>
					<td align="left">SVRHCD</td></tr>

				<tr align="center">
					<td style="border-right:1pt solid white" align="right"><input type="checkbox" name="SVLDBB" value="SVLDBB" class="trans"></td>
					<td align="left">SVLDBB</td>
					<td style="border-right:1pt solid white" align="right"><input type="checkbox" name="TMNDFL" value="TMNDFL" class="trans"></td>
					<td align="left">TMNDFL</td>
					<td style="border-right:1pt solid white" align="right"><input type="checkbox" name="TMNDMT" value="TMNDMT" class="trans"></td>
					<td align="left">TMNDMT</td>
					<td style="border-right:1pt solid white" align="right"><input type="checkbox" name="TMNDTS" value="TMNDTS" class="trans"></td>
					<td align="left">TMNDTS</td></tr>

				<tr align="center">
					<td style="border-right:1pt solid white" align="right"><input type="checkbox" name="SVLDTM" value="SVLDTM" class="trans"></td>
					<td align="left">SVLDTM</td>
					<td style="border-right:1pt solid white" align="right"><input type="checkbox" name="TPNDTM" value="TPNDTM" class="trans"></td>
					<td align="left">TPNDTM</td></tr>

				</table>
				<!-- : ( Speed ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
     	<table class="search">
       	<tr><td class="bg">


				<!-- : ( Seq. ) (S) -->
					<table style="width:362;" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet3');</script><!-- shown Yard info -->
                        </td></tr>
		            </table>
				<!-- : ( Seq. ) (E) -->


				<!-- : ( Button : Sub ) (S) -->
				<table class="button" border="0" width="100%">
					<tr><td class="btn2_bg" class="align">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btng_rowadd" id="btng_rowadd">Row Add</td>
								<td class="btn2_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btng_save" id="btng_save">Save</td>
								<td class="btn2_right"></td></tr></table></td>
								<!-- Repeat Pattern -->
							</tr>
						</table>
					</td></tr>
				</table>
		    	<!-- : ( Button : Sub ) (E) -->





			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->




</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->



<table class="height_10"><tr><td></td></tr></table>


<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
		<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	       		<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>

					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_ok" id="btn_ok">Ok</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr>
			</table>

		</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->
</form>
</body>
</html>