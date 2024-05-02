<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0490.jsp
*@FileTitle : Sri Lanka Customs Manifest B/L Info
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.05.27 임재택
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.event.EsmBkg0490Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0490Event event=null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException=null;			//서버에서 발생한 에러
	String strErrMsg="";						//에러메세지
	int rowCount	=0;						//DB ResultSet 리스트의 건수

	String successFlag="";
	String codeList="";
	String pageRows="100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	Logger log=Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm=account.getUsr_nm();

		serverException=(Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg=new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		//GeneralEventResponse eventResponse=(GeneralEventResponse) request.getAttribute("EventResponse");
		 //http//127.0.0.1:7001/hanjin/nis2010Main.screen?pgmNo=ESM_BKG_M001&url=^hanjin^ESM_BKG_0013.do&id=ESM_BKG_0013

	}catch(Exception e) {
		out.println(e.toString());
	}

%>
<html>
<head>
<title>Sri Lanka Customs Manifest B/L Info</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage="<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pgNo">
<input type="hidden" name="pagerows">
<input type="hidden" name="frm_attr_ctnt2">
<input type="hidden" name="vsl_cd">
<input type="hidden" name="skd_voy_no">
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="vvd_nm">
<input type="hidden" name="sr_sts_cd">
<input type="hidden" name="rgst_dt">
<input type="hidden" name="rjct_dt">
<input type="hidden" name="vsl_auth_no">
<input type="hidden" name="sr_sts_desc">
<input type="hidden" name="sr_cmt_desc">
<input type="hidden" name="decl_bl_qty">
<input type="hidden" name="edi_mt_removal">
<input type="hidden" name="beforetab">
<input type="hidden" name="crr_nm">
<input type="hidden" name="lloyd_cd">

<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">

	<tr><td valign="top">

		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->

		<!--Button (E) -->

		<!--biz page (S)-->
		<table class="search" id="mainTable">
			<tr><td class="bg">


				<!-- biz_1 (S) -->
				<table class="search" border="0" style="width:979;">
					<tr class="h23">
						<td width="130">VVD</td>
						<td width="117"><input name="vvd_number" dataformat="uppernum" style="ime-mode: disabled" type="text" style="width:90;" class="input1" maxlength="9" ></td>
						<td><table class="search_sm" border="0" style="width:180;">
						<tr class="h23">
						<td width="300">
				<table class="search_sm2" border="0" style="width:150;"> 
				<tr class="h23">
					<td width="70"><input name="port_flg" type="radio"  class="trans" value="pol"   checked>POL</td>
					<td width=""><input name="pol_cd" type="text" style="width:50" value="" class="input1" 
										style="text-align:center" style="ime-mode: disabled" dataformat="engupnum" maxlength="5"></td>
					<td width="65"><input name="port_flg"  type="radio"  class="trans" value="pod" >&nbsp;&nbsp;POD</td>
					<td width=""><input name="pod_cd" type="text" style="width:50" value="" class="input1" 
										style="text-align:center" style="ime-mode: disabled" dataformat="engupnum" maxlength="5"></td>
					</tr>
				</table>
				</td>
						</tr>
						</table>
						</td>
<!-- 					<td>POD&nbsp;&nbsp;<input name="pod_cd" dataformat="engupnum" style="ime-mode: disabled" type="text" style="width:60;" class="input1" value="LKCMB" maxlength="5"></td> -->
						<td align="center">DEL&nbsp;&nbsp;<input name="del_cd" dataformat="engupnum" style="ime-mode: disabled" type="text" style="width:50;" value="LKCMB" maxlength="5"></td>
						<td align="center">CGO Type&nbsp;
							<select style="width:60;" class="input" name="cgo_tp_cd" >
								<option value="F" selected>Full</option>
								<option value="M">MT</option>
							</select></td>
						<td align="center">Type&nbsp;
							<select style="width:60;" class="input" name="ts_tp_cd" >
								<option value="A" selected>All</option>
								<option value="L" >Local</option>
								<option value="T">T/S</option>
							</select></td>
						<td align="right">Last Call Port CD&nbsp;<input name="call_port" dataformat="engupnum" style="ime-mode: disabled" type="text" style="width:60;" class="input1" maxlength="5">&nbsp;&nbsp;</td>

					<td align="right"><input name="ver_flg" dataformat="engup" style="ime-mode: disabled" type="hidden" style="width:60;" class="input" ></td>
					</tr>
				</table>

				<table class="search" border="0" style="width:979;">
					<tr class="h23">
						<td width="130">Vessel Approval No.</td>
						<td width="120"><input name="auth_no" dataformat="uppernum" style="ime-mode: disabled" type="text" style="width:90;" maxlength="10"></td>
						<td width="120">Carrier TIN No.</td>
						<td width="170"><input name="carrier_no" type="text" style="width:130;" value=" 114333611-7000" class="input2" readonly></td>
						<td width="80">Vessel Name</td>
						<td><input name="vsl_nm" type="text" style="width:350;" class="input2" readonly></td>
					</tr>
				</table>

				<table class="search" border="0" style="width:979;">
					<tr class="h23">
						<td width="130">Customs Office Code</td>
						<td width="120"><input name="customs_office_code" type="text" dataformat="uppernum" style="ime-mode: disabled" style="width:90;" value="CBLR1" maxlength="5"></td>
						<td width="120">Vessel Arrival Date</td>
						<td width="110"><input name="eta_dt" type="text" style="width:80;" class="input2" readonly></td>
						<td width="140">Vessel Departure Date</td>
						<td width="110"><input name="etd_dt" type="text" style="width:80;" class="input2" readonly></td>
						<td width="140">Port Registration No.</td>
						<td><input type="text" name="reg_no" class="input" style="ime-mode:disabled" maxlength="7" style="width:100;" onKeyPress="ComKeyAlphabetNChar('uppernum2')" ></td>
					</tr>
				</table>
				<!-- biz_1 (E) -->

		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>

		<!-- Tab (S) -->
		<table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr><td width="100%">
					<script language="javascript">ComTabObject("tab1")</script>
					<!-- img src="/img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
				</td></tr>
		</table>
		<!-- Tab (E) -->

<!--TAB B/L Info (S) -->
<div id="tabLayer" style="display:inline">

		<table class="search" id="mainTable">
			<tr><td class="bg">

			<!-- Grid (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject("t1sheet1");</script>
						</td>
					</tr>
					<tr>
						<td width="100%">B/L Total:
						 <input name="total_bl" type="text" style="width:35" class="input2" style="text-align:right" readonly></td>
					</tr>
				</table>
			<!-- Grid (E) -->

			</td></tr>
		</table>
		<!--biz page (E)-->

</div>
<!--TAB B/L Info (E) -->


<!--TAB Arrival Date (S) -->
<div id="tabLayer" style="display:inline">

		<table class="search" id="mainTable">
			<tr><td class="bg">

			<!-- Grid (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject("t2sheet1");</script>
						</td>
					</tr>
					<tr>
						<td width="100%">CNTR Total:
						 <input name="total_cntr" type="text" style="width:35" class="input2" style="text-align:right" readonly></td>
					</tr>
				</table>
			<!-- Grid (E) -->

			</td></tr>
		</table>
		<!--biz page (E)-->

</div>
<!--TAB Arrival Date (E) -->

	</td></tr>
		</table>

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
		<tr><td class="btn1_bg">
			<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ViewResponse">View Response</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Transmit_ASYCUDA">EDI Transmit(ASYCUDA)</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Transmit_CTS">EDI Transmit(CTS)</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_MtRemoval">EDI (MT Removal)</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>


	<table class="height_10"><tr><td colspan="8"></td></tr></table>
	 <!-- <table style="width:979;height:100">
			<tr><td>result : </td></tr>
			<tr>
				<td><textarea name="output" cols="100" rows="20"></textarea></td>
			</tr>
		</table>-->

</form>
</body>
</html>