<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0493.jsp
*@FileTitle : Sri Lanka Customs Manifest_Vessel Registration Message
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.event.EsmBkg0493Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0493Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	 
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		 
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		 //http//127.0.0.1:7001/hanjin/nis2010Main.screen?pgmNo=ESM_BKG_M001&url=^hanjin^ESM_BKG_0013.do&id=ESM_BKG_0013 						 

	}catch(Exception e) {
		out.println(e.toString());
	}
	
%>
<html>
<head>
<title>Sri Lanka Customs Manifest_Vessel Registration Message</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pgNo">
<input type="hidden" name="pagerows">
<input type="hidden" name="frm_attr_ctnt2">
<input type="hidden" name="vsl_cd"> 
<input type="hidden" name="skd_voy_no"> 
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="port_cd">
<input type="hidden" name="io_bnd_cd">
<input type="hidden" name="call_port">
<input type="hidden" name="vvd_nm">
<input type="hidden" name="sr_sts_cd">
<input type="hidden" name="rgst_dt">
<input type="hidden" name="rjct_dt">
<input type="hidden" name="vsl_auth_no">
<input type="hidden" name="sr_sts_desc">
<input type="hidden" name="sr_cmt_desc">
<input type="hidden" name="decl_bl_qty">
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!--biz page (S)-->
		<table class="search" id="mainTable">
       		<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td width="30">VVD</td>
					<td width="130"><input name = "frm_vvd_number" dataformat="uppernum" style="ime-mode: disabled" type="text" style="width:80;" class="input1" value="" maxlength="9" style="text-align:center" ></td>
					
					<td width="30"><input name="port_flg" type="radio"  class="trans" value="pol" >POL</td>
					<td width="80"><input name="pol_cd" type="text" style="width:50" value="" class="input1" 
										style="text-align:center" style="ime-mode: disabled" dataformat="engupnum" maxlength="5"></td>
					<td width="30"><input name="port_flg"  type="radio"  class="trans" value="pod" checked >&nbsp;&nbsp;POD</td>
					<td width="80"><input name="pod_cd" type="text" style="width:50" value="" class="input1" 
										style="text-align:center" style="ime-mode: disabled" dataformat="engupnum" maxlength="5"></td>
<!-- 					<td width="30">POD</td> -->
<!-- 					<td width="135"><input  name = "pod_cd" dataformat="engupnum" style="ime-mode: disabled" type="text" style="width:50;" class="input1" value="LKCMB" maxlength="5" style="text-align:center"></td> -->
					
					<td width="110">Last Call Port CD</td>
					<td width=""><input  name = "frm_call_port_cd" dataformat="engupnum" style="ime-mode: disabled" type="text" style="width:50;" class="input1" value="" maxlength="5" style="text-align:center"></td>
				</tr>
				</table>
				<!--  biz_1   (E) -->

				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td>Vessel Registration No.</td>
					<td><input name= "frm_vsl_rgst_no" type="text"  dataformat="uppernum"  style="ime-mode: disabled"style="ime-mode: disabled" style="width:120;" class="input" value=""></td></tr>
				<tr class="h23">
					<td width="180">Arrival  Date</td>
					<td width="190"><input name = "frm_vps_eta_dt"  dataformat="ymd" type="text" style="width:120;" class="input" maxlength="10"></td>
					<td width="110">Arrival  Time</td>
					<td><input type="text" name = "frm_vps_eta_dt_time" dataformat="hms" style="width:100;" class="input" maxlength="8"></td>
					</tr>
				<tr class="h23">
					<td>Departure  Date</td>
					<td><input type="text" name = "frm_vps_etd_dt" dataformat="ymd" style="width:120;" class="input" maxlength="10"></td>
					<td>Departure Time</td>
					<td><input type="text"  name = "frm_vps_etd_dt_time" dataformat="hms" style="width:100;" class="input" maxlength="8"></td>
					</tr>
				<tr class="h23">
					<td>Vessel  Name</td>
					<td><input type="text" name = "frm_vsl_eng_nm"  dataformat="engup"  style="ime-mode: disabled" style="width:120;" class="input" value="" maxlength="50"></td>
					<td>Vessel Flag</td>
					<td><input name = "frm_vsl_rgst_cnt_cd"  dataformat="engup"  style="ime-mode: disabled" type="text" style="width:40;" class="input" value="" maxlength="2"></td>
					</tr>
				<tr class="h23">
					<td>Captain  Name</td>
					<td colspan="3"><input name = "frm_cap_nm" dataformat="engupspace2" style="ime-mode: disabled" type="text" style="width:400;" class="input" ></td></tr>
				<tr class="h23">
					<td>Departure  Port CD</td>
					<td><input name = "frm_depature_port" type="text"   dataformat="engupnum" style="ime-mode: disabled" style="width:120;" class="input"  maxlength="5"></td>
					<td>Arrival  Port CD</td> 
					<td><input name = "frm_arrival_port" type="text"   dataformat="engupnum" style="ime-mode: disabled" style="width:100;" class="input"  maxlength="5"></td>
					</tr>
				<tr class="h23">
					<td>Shipping  Agent</td>
					<td colspan="3"><input name = "frm_vsl_nm"   dataformat="engup" style="ime-mode: disabled" type="text" style="width:400;" class="input" value=""></td></tr>
				<tr class="h23">
					<td>Local  Agent</td>
					<td colspan="3"><input name = "frm_vsl_nm2"  dataformat="engup" style="ime-mode: disabled" type="text" style="width:400;" class="input" value=""></td></tr>
				<tr class="h23">
					<td>Vessel  Auth  No.</td>
					<td colspan="3"><input name = "frm_vsl_auth_no"  dataformat="uppernum" type="text" style="width:120;" class="input" value=""></td></tr>
				<tr class="h23">
					<td>Ship Stay Ref Code</td>
					<td><input name = "frm_cstms_vvd_cd"  dataformat="uppernum" type="text" style="width:120;" class="input" value="" maxlength="9"></td>
					<td>MRN</td> 
					<td><input name = "frm_msg_ref_no" type="text"   dataformat="engupnum" style="ime-mode: disabled" style="width:100;" class="input" ></td></tr>
				</table>
				<!--  biz_1   (E) -->


		</td></tr></table>
		<!--biz page (E)-->

</td></tr></table>
<div style="display:none">
<script language="javascript">ComSheetObject('sheet1');</script>
</div>

<!-- : ( Button : pop ) (S) -->

	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
			<table border="0" cellpadding="0" cellspacing="0">
				<tr><td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
							<td class="btn1_right"></td>
						</tr>
					</table>
					</td>
					<td class="btn1_line"></td>

					<td>
					<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Save">Save</td>
								<td class="btn1_right"></td>
							</tr>
					</table>
					</td>
					
					<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_ViewResponse">View Response</td>
							<td class="btn1_right"></td>
						</tr>
					</table>
					</td>
	
					<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Transmit">Transmit</td>
								<td class="btn1_right"></td>
							</tr>
				     </table>
				     </td>
			</tr>
		</table>
    	<!--Button (E) -->

	</td></tr>
</table>

<!-- : ( Button : pop ) (E) -->

</form>
</body>
</html>