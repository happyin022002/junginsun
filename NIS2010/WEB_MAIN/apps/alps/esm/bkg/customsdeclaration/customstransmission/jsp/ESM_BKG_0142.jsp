<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0142.jsp
*@FileTitle : ACI_Vessel Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.04.24 김민정
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.event.EsmBkg0142Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0142Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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

		event = (EsmBkg0142Event)request.getAttribute("Event");
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
<title>Canada ACI: CBSA Result Report</title>
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
<input type="hidden" name="pagerows" value="<%=pageRows %>">
<input type="hidden" name="subcmd">

<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr>
		<td valign="top">

<!--Page Title, Historical (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
	<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
	<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
</table>
<!--Page Title, Historical (E)-->

<!--biz page (S)-->

<table class="search">
	<tr>
		<td class="bg">
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td rowspan="3" width="130">
						<table class="search_sm" border="0" width="120">
							<tr><td class="sm" width="120"><input type="radio" class="trans" checked="true" name="rpt_flag" value="F">&nbsp;<strong>Full (A6A)</strong></td></tr>
							<tr><td class="sm"><input type="radio" class="trans" name="rpt_flag" value="M">&nbsp;<strong>Empty (E10)</strong></td></tr>
							<tr><td class="sm"><input type="radio" class="trans" name="rpt_flag" value="V">&nbsp;<strong>Vessel (A6)</strong></td></tr>
						</table>
					</td>
					<td width="48">VVD</td>
					<td width="100"><input type="text" style="width:80;ime-mode:disabled" class="input" 
						name="vvd_cd" dataformat="eng" maxlength="9" caption="VVD" fullfill></td> 
					<td width="25">POL</td>
					<td width="60"><input type="text" style="width:50;ime-mode:disabled" class="input" 
						name="pol_cd" dataformat="eng" maxlength="5" caption="POL" fullfill></td> 
					<td width="25">POD</td>
					<td width="60"><input type="text" style="width:50;ime-mode:disabled" class="input" 
						name="pod_cd" dataformat="eng" maxlength="5" caption="POD" fullfill></td>
					<td width="83" align="right">Send Date</td>
					<td width="240" class="stm">
						<input type="text" style="width:85;ime-mode:disabled" 
							name="s_snd_dt" class="input" dataformat="ymd" caption="Send Date" cofield="e_snd_dt" maxlength="10">
						&nbsp;~&nbsp;
						<input type="text" style="width:85;ime-mode:disabled" 
							name="e_snd_dt" class="input" dataformat="ymd" caption="Send Date" cofield="s_snd_dt" >
						<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_snd_calendar">
					</td>
					<td width="70">A6A(B/L)</td>
					<td>
						<select style="width:130;" name="cstms_trsm_sts_cd">
							<option value="">All</option>
							<option value="SentByA6A">Original</option>
							<option value="AddedByAi">Update</option>
							<option value="UnManifested">Un-Manifested</option>
							<option value="Manifested">Manifested</option>
						</select></td>
				</tr>
				<tr class="h23">
					<td>B/L No.</td>
					<td colspan="5"><input type="text" style="width:125;;ime-mode:disabled" class="input" 
						name="bl_no" dataformat="eng" maxlength="12" caption="B/L No" fullfill></td>
					<td width="" align="right">Receive Date</td>
					<td class="stm">
						<input type="text" style="width:85;ime-mode:disabled" 
							name="s_rcv_dt" class="input" dataformat="ymd" caption="Receive Date" cofield="e_rcv_dt" maxlength="10">
						&nbsp;~&nbsp;
						<input type="text" style="width:85;ime-mode:disabled" 
							name="e_rcv_dt" class="input" dataformat="ymd" caption="Receive Date" cofield="s_rcv_dt">
						<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_rcv_calendar">
					</td> 
					<td>Status</td>
					<td>
						<script language="javascript">ComComboObject('cstms_ack_proc_rslt_cd', 2, 112, 1, 0, 2);</script><img src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btn_M1">
					</td> 
					
				</tr>
			</table>
		</td>
	</tr>
</table>
<table class="height_8"><tr><td></td></tr></table>
<table class="search" id="mainTable">
	<tr>
		<td class="bg">
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
			
<!-- Manifest TTL (S) -->
<table class="height_8"><tr><td></td></tr></table>
<div id="readonly">
<table class="search"> 
     <tr>
     	<td class="bg">
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="85">Manifest TTL</td>
					<td width="60"><input type="text" style="width:50; text-align:center;" class="input" name="frm_manifest_ttl" readonly="ReadOnly"></td> 
					<td width="40" align="center">=</td>
					<td width="85">Original</td>
					<td width="60"><input type="text" style="width:50; text-align:center;" class="input" name="frm_sent_by_a6a" readonly="ReadOnly"></td> 
					<td width="40" align="center">+</td>
					<td width="90">Update</td>
					<td><input type="text" style="width:50; text-align:center;" class="input" name="frm_sent_by_al" readonly="ReadOnly"></td>
				</tr>
				<tr class="h23">
					<td>Target TTL</td>
					<td><input type="text" style="width:50; text-align:center;" class="input2" name="frm_target_ttl" readonly="ReadOnly"></td> 
					<td colspan="4"></td>
					<td>Unmanifested</td>
					<td><input type="text" style="width:50; text-align:center;" class="input" name="frm_unmanifest" readonly="ReadOnly"></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- Manifest TTL (E) -->				

<!-- Total (S) -->
<table class="height_8"><tr><td></td></tr></table>
<table class="search"> 
	<tr>
		<td class="bg">
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="85">Total</td>
					<td width="100"><input type="text" style="width:50; text-align:right;" class="input2" name="frm_total" readonly="ReadOnly"></td> 
					<td width="85">Processed</td>
					<td width="100"><input type="text" style="width:50; text-align:right;" class="input2" name="frm_processed" readonly="ReadOnly"></td> 
					<td width="90">Error</td>
					<td><input type="text" style="width:50; text-align:right;" class="input2" name="frm_error" readonly="ReadOnly"></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</div>
<!-- 본문끝 -->

<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	<tr>
		<td class="btn">
			<table>
				<tr>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_new">New</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td class="btn1_line"></td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_downexcel">Down Excel</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_print">Print</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_blInquiry">B/L Inquiry</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_history">Receive History</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_viewMsg">View MSG</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>					
				</tr>
			</table>
		</td>
		<td class="btn1_bg">
    		<table border="0" cellpadding="0" cellspacing="0">
    			<tr>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_37" id="btn_37">37/01</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_21" id="btn_21">21/01</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!--Button (E) -->

		</td>
	</tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>