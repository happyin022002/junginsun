<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0003.jsp
*@FileTitle : CY & Door S/O Creation Detail Input
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-04
*@LastModifier : z_kim_sang_geun
*@LastVersion : 1.0
* 2006-10-04 z_kim_sang_geun
* 1.0 최초 생성
*----------------------------------------------------------
* 2012.01.09 김보배 [CHM-201215479] [TRS] Dup. S/O 사전 보완기능 요청
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.event.EsdTrs0002Event"%>
<%
	EsdTrs0002Event  			event 				= null;		//PDTO(Data Transfer Object including Parameters)
	Exception 					serverException   	= null;		//서버에서 발생한 에러
	DBRowSet 					rowSet	  			= null;		//DB ResultSet
	String 						strErrMsg 			= "";		//에러메세지
	int 						rowCount	 		= 0;		//DB ResultSet 리스트의 건수

	String 						trsp_crr_mod_cd 	= ""; 		//Transportation Mode
	String 						dor_svc_tp_cd 		= ""; 		//Door Service Type

	String	sCostModeCd		= JSPUtil.getNull(request.getParameter("cost_mode_cd")		);	/* 2007-12-13 */
	String	sScrnId			= JSPUtil.getNull(request.getParameter("scrn_id"));	/* 2007-12-13 */

	try {

		trsp_crr_mod_cd  = JSPUtil.getCodeCombo("trsp_crr_mod_cd", "01", "style='width:150'", "CD00283", 0, "");

		if( !"CY".equals(sCostModeCd) )		dor_svc_tp_cd  = JSPUtil.getCodeCombo("dor_svc_tp_cd", "01", "style='width:150'", "CD00284", 0, "");

		event = (EsdTrs0002Event)request.getAttribute("Event");
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
<title>CY & Door S/O Creation Detail Input</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		loadPage();
		getParamInfo(); //body에서 값을 얻는다.
		
	}

</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();" onunload="javascript:doClosePopup();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd"	>
<input type="hidden" name="iPage"	>
<input type="hidden" name="CONTI_CD">

<input type="hidden" name="act_cust_cnt_cd"		>
<input type="hidden" name="act_cust_seq"		>
<input type="hidden" name="act_cust_addr_seq"	>
<input type="hidden" name="factory_zip_code"	>
<input type="hidden" name="factory_addr"		>
<input type="hidden" name="factory_tel_no"		>
<input type="hidden" name="factory_fax_no"		>
<input type="hidden" name="pic_nm"				>
<input type="hidden" name="bnd_cd">
<input type="hidden" name="unplan_shuttle">
<input type="hidden" name="scrn_id" value="<%=sScrnId%>">

<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Detail Input</td></tr>
		</table>
		<!-- : ( Title ) (E) -->


		<!-- : ( Search Options, Grid ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">

					<!-- TABLE '#D' : ( Search Options ) (S) -->
					<table class="search" border="0">
						<tr class="h23">
							<td width="10%">Cost Mode </td>
							<td width="40%">
								<input name="trsp_cost_dtl_mod_cd" type="text" style="width:260;" value="" disabled></td>
							<td width="10%">&nbsp;</td>
							<td width="40%">&nbsp;</td>
						</tr>
					</table>
					<!-- TABLE '#D' : ( Search Options ) (E) -->

					<table class="line_bluedot"><tr><td></td></tr></table>

					<!-- : ( Grid ) (S) -->
					<table width="100%" class="grid">
					<tr class="tr_head">
						<td width="157">&nbsp;</td>
						<td width="280" colspan="2">Preset (From COP) </td>
						<td width="280" colspan="2">Actual</td>
						</tr>
					<tr>
						<td width="157" valign="top" class="tr_head"><div align="left">From Node </div></td>
						<td width="180"><input name="old_fm_nod_cd" type="text" class="noinput" style="width:170;" disabled></td>
						<td width="100"><input name="old_fm_nod_yard" type="text" class="noinput" style="width:90;" disabled></td>
						<td width="157"><input name="fm_nod_cd" type="text" class="noinput" style="width:155;" value="" onChange="getComboList(this, document.fm_nod_yard, 'F');" maxlength="5" onBlur=""></td>
						<td width="103"><script language="javascript">ComComboObject('fm_nod_yard', 1, 78, 0)</script>
							<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_frmnode"></td>
						</tr>
					<tr>
						<td valign="top" class="tr_head"><div align="left">Via Node </div></td>
						<td><input name="old_via_nod_cd" type="text" class="noinput" style="width:170;" disabled></td>
						<td><input name="old_via_nod_yard" type="text" class="noinput" style="width:90;" disabled></td>
						<td><input name="via_nod_cd" type="text" class="noinput" style="width:155;" value="" onChange="getComboList(this, document.via_nod_yard, 'V');" maxlength="5" onBlur=""></td>
						<td><script language="javascript">ComComboObject('via_nod_yard', 1, 78, 0)</script>
							<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_vianode"></td>
						</tr>
					<tr>
						<td width="157" valign="top" class="tr_head"><div align="left">To Node </div></td>
						<td><input name="old_to_nod_cd" type="text" class="noinput" style="width:170;" disabled></td>
						<td><input name="old_to_nod_yard" type="text" class="noinput" style="width:90;" disabled></td>
						<td><input name="to_nod_cd" type="text" class="noinput" style="width:155;" value="" onChange="getComboList(this, document.to_nod_yard, 'T');" maxlength="5" onBlur=""></td>
						<td><script language="javascript">ComComboObject('to_nod_yard', 1, 78, 0)</script>
							<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_tonode"></td>
					</tr>
					<tr>
						<td valign="top" class="tr_head"><div align="left">Door Location </div></td>
						<td><input name="old_dor_nod_cd" type="text" class="noinput" style="width:170;" disabled></td>
						<td><input name="old_dor_nod_yard" type="text" class="noinput" style="width:90;" disabled></td>
						<td><input name="dor_nod_cd" type="text" class="noinput" style="width:155;" value="" onChange="getComboList(this, document.dor_nod_yard, 'D');" maxlength="5" onBlur=""></td>
						<td>
							<%
								if( !"CY".equals(sCostModeCd) )	{
							%>
							<script language="javascript">ComComboObject('dor_nod_yard', 1, 78, 0)</script>
							<%
								}
							%>
							<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_dorloc"></td>
					</tr>
					<tr>
						<td valign="top" class="tr_head"><div align="left">Actual Customer </div></td><!--old no-->
						<td colspan="2"><input name="factory_nm" type="text" class="noinput" style="width:250;" value=""></td>
						<td colspan="2"><input name="act_cust_cd" type="text" class="noinput" style="width:250;" value="">
							<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_actualcust"></td>
					</tr>
					<tr>
						<td valign="top" class="tr_head"><div align="left">Door Service Type</div></td><!--old no-->
						<td colspan="2"><input name="org_dor_svc_tp_cd" type="text" class="noinput" style="width:270;" disabled></td>
						<td colspan="2" style="padding-left:3;"><%=dor_svc_tp_cd%></td>
					</tr>

					<tr>
						<td valign="top" class="tr_head"><div align="left">Trans Mode </div></td>
						<td colspan="2"><input name="org_trsp_crr_mod_cd" type="text" class="noinput" style="width:270;" disabled></td>
						<td colspan="2" style="padding-left:3;"><%=trsp_crr_mod_cd%></td>
						</tr>
					<tr>
						<td valign="top" class="tr_head"><div align="left">Remarks</div></td>
						<td colspan="4"><input name="remark" type="text" class="noinput" style="width:99%;" value=""></td>
					</tr>
					<tr>
						<td valign="top" class="tr_head"><div align="left">Reason of Node Change</div></td>
						<td colspan="4"><input name="cng_rsn_desc" type="text" class="noinput" style="width:99%;" value=""></td>
					</tr>	
				</table>
				<!-- : ( Grid ) (E) -->


			</td></tr>
		</table>
		<!-- : ( Search Options, Grid ) (E) -->



</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->


<table class="height_5"><tr><td></td></tr></table>


<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>

				<!-- Repeat Pattern -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_apply" id="btn_apply">Apply</td><td class="btn1_right"></td></tr></table></td>

				<td class="btn1_line"></td>

				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
				<!-- Repeat Pattern -->

			</tr>
		</table>

	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->



<table width="100%" height="0" ID='mainTable'>
	<tr><td>
		 <script language="javascript">ComSheetObject('sheet');</script>
	</td></tr>
</table>
</form>
</body>
</html>
