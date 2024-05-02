<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0898.jsp
*@FileTitle : Vessel/Port Group Assign by VVD, Port
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.09.22 최영희
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg0898Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0898Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.TransshipmentMgt.TransshipmentMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0898Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Vessel/Port Group Assign by VVD, Port</title>
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

<body  onLoad="setupPage();">
<form name="form" onkeyup="ComKeyEnter('lengthnextfocus');">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- RouteDetail시 반영될 Hidden Sheet -->
<input type="hidden" name="org_trns_mod_cd"  value="">
<input type="hidden" name="dest_trns_mod_cd" value="">
<input type="hidden" name="bkg_por_cd"> 
<input type="hidden" name="bkg_por_yd_cd">
<input type="hidden" name="bkg_pol_cd">
<input type="hidden" name="bkg_pol_yd_cd">
<input type="hidden" name="bkg_pod_cd">
<input type="hidden" name="bkg_pod_yd_cd">
<input type="hidden" name="bkg_del_cd">
<input type="hidden" name="bkg_del_yd_cd">
<input type="hidden" name="port_skp_flg">
<input type="hidden" name="check_ts_close_flag">
<input type="hidden" name="cust_ntc_flg">
<input type="hidden" name="vsl_cng_rsn">
<input type="hidden" name="pgm_no" value="ESM_BKG_0898">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
		<!--Page Title, Historical (S)--> 
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
		<!--Page Title, Historical (E)--> 
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			

				<!--  biz_1 (S) -->
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="30">VVD</td>
						<td width="130"><input type="text" style="width:90;" class="input1"  maxlength="9" dataformat="engup" name="vvd" ></td>
						<td width="35">Port</td>
						<td width="130"><input type="text" style="width:60;" class="input1"  maxlength="5" dataformat="engup" name="port" >
										<input type="text" style="width:30;" class="input"  maxlength="2" dataformat="engup" name="yard" ></td>
						<td width="70">BKG Office</td>
						<td width=""><input type="text" style="width:90;" class="input" value="" maxlength="6" dataformat="engup" name="bkgOfcCd"></td>
						<td width="30">POL</td>
						<td width="130"><input type="text" style="width:60;" class="input"  maxlength="5" dataformat="engup" name="pol" ></td>
						<td width="30">POD</td>
						<td width="130"><input type="text" style="width:60;" class="input"  maxlength="5" dataformat="engup" name="pod" ></td>
						<td width="100"></td>
					</tr>
				</table>
				<!--  biz_1   (E) -->	
		
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			
			
			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Route Details</td></tr>
				</table>
			<!-- Grid_2 (S) -->
			<table width="100%" id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table> 
			<!-- Grid_2 (E) -->		
			
		<table class="height_8"><tr><td></td></tr></table>
			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">BKG Details</td></tr>
				</table>
			<!-- Grid_2 (S) -->
			<table width="100%" id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet2');</script>
					</td>
				</tr>
			</table> 
			<!-- Grid_2 (E) -->		
			
			
		<table class="height_8"><tr><td></td></tr></table>
			
			
			<!--  biz_2 (S) -->
				<table class="search" border="0" width="100%"> 
					<tr class="h23">
						<td width="60">Total B/L</td>
						<td width="80"><input type="text" style="width:40;text-align:center" class="input2" readOnly name="totalBl"></td>
						<td width="40">Success</td>
						<td width="80"><input type="text" style="width:40;text-align:center" class="input2" readOnly name="success"></td>
						<td width="30">Fail</td>
						<td width="80"><input type="text" style="width:40;text-align:center" class="input2" readOnly name="fail"></td>
						<td><!--Button (S) -->
							<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0"> 
							<tr><td class="btn2_bg"> 
								<table border="0" cellpadding="0" cellspacing="0">
								<tr>	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
										<td class="btn2" name="btn_selectall" id="btn_CheckAll">Select All</td>
										<td class="btn2" name="btn_deselectall" id="btn_UnCheckAll">DeSelect All</td>
										<td class="btn2_right"></td>
										</tr>
									</table></td>
										
									</tr>
								</table>
							</td></tr>
							</table>
					<!--Button (E) -->	</td>
					</tr>
				</table>
				<!--  biz_2   (E) -->	 
			
			</td></tr>
		</table>
		<!--biz page (E)--> 
	</td></tr>
		</table> 
<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_vvdportchange">VVD/Port Change</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->	 
		 <table width="0"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet3');</script>
					</td>
				</tr>
			</table> 

		 <table width="0"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet4');</script>
					</td>
				</tr>
			</table> 

        <table width="0"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet5');</script>
					</td>
				</tr>
			</table> 
		

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>