<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2075.jsp
*@FileTitle : RFA Proposal Inquiry – Rate – Specification
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.10.20 김재연
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
<%@ page import="com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2075Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri2075Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.RFAProposal.RFARateProposal");
	
	String propNo = JSPUtil.getNull(request.getParameter("prop_no"));
	String amdtSeq = JSPUtil.getNull(request.getParameter("amdt_seq"));
	String svcScpCd = JSPUtil.getNull(request.getParameter("svc_scp_cd"));
	String cmdtHdrSeq = JSPUtil.getNull(request.getParameter("cmdt_hdr_seq"));
	String routSeq = JSPUtil.getNull(request.getParameter("rout_seq"));
	String rtSeq = JSPUtil.getNull(request.getParameter("rt_seq"));
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri2075Event)request.getAttribute("Event");
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
<title>RFA Proposal Creation – Rate – Specification</title>
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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="cd">
<input type="hidden" name="prop_no" value="<%=propNo%>">
<input type="hidden" name="amdt_seq" value="<%=amdtSeq%>">
<input type="hidden" name="svc_scp_cd" value="<%=svcScpCd%>">
<input type="hidden" name="cmdt_hdr_seq" value="<%=cmdtHdrSeq%>">
<input type="hidden" name="rout_seq" value="<%=routSeq%>">
<input type="hidden" name="rt_seq" value="<%=rtSeq%>">
<input type="hidden" name="rat_ut_cd">
<input type="hidden" name="cntr_len">
<input type="hidden" name="cntr_wdt">
<input type="hidden" name="cntr_hgt">
<input type="hidden" name="cntr_wgt">
<table width="700" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;RFA Proposal Creation - Rate [Specification]</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
			<table class="search"> 
       		<tr><td class="bg">
				<table border="0" style="width:100%;" class="search_sm"> 
					<tr class="h23">
						<td width="130">Measuring Unit</td>
						<td width="" class="stm"><input type="radio" name="measuring_unit" value="M" class="trans" checked>Metric (mm / Kg)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="measuring_unit" value="I" class="trans">Imperial (foot / lbs)</td>
					</tr>
				</table>
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Actual Dimension</td></tr>
				</table>
				<table border="0" style="width:100%;" class="grid2"> 
					<tr class="tr2_head">
						<td width="14%">Type (Unit)	</td>
						<td width="22%" id="len_title">Length (mm)	</td>
						<td width="22%" id="wdt_title">Width (mm)	</td>
						<td width="22%" id="hgt_title">Height (mm)	</td>
						<td width="" id="wgt_title">Weight (Kg)</td>
					</tr>
					<tr class="">
						<td width="14%" align="center"><input type="text" name="type_unit" style="width:100%;text-align:center" class="noinput" readonly>	</td>
						<td width="22%" align="center"><input type="text" name="act_cgo_len" dataformat="float" maxLength="10" pointcount="2" value=".00" style="width:100%;text-align:right;ime-mode:disabled" class="noinput" readonly></td>
						<td width="22%" align="center"><input type="text" name="act_cgo_wdt" dataformat="float" maxLength="10" pointcount="2" value=".00" style="width:100%;text-align:right;ime-mode:disabled" class="noinput" readonly></td>
						<td width="22%" align="center"><input type="text" name="act_cgo_hgt" dataformat="float" maxLength="10" pointcount="2" value=".00" style="width:100%;text-align:right;ime-mode:disabled" class="noinput" readonly></td>
						<td width="%" align="center"><input type="text" name="act_cgo_wgt" dataformat="float" maxLength="19" pointcount="2" value=".00" style="width:100%;text-align:right;ime-mode:disabled" class="noinput" readonly></td>
					</tr>
				</table>
				<table class="search" border="0">
				<tr><td class="height_5"></td></tr>
				<tr><td class="title_h"></td>
					<td class="title_s">Over Dimension</td></tr>
				</table>
				<table border="0" style="width:100%;" class="grid2"> 
					<tr class="tr2_head">
						<td width="14%">Type (Void)</td>
						<td width="14%" id="front_title">Front</td>
						<td width="14%" id="rear_title">Rear</td>
						<td width="14%" id="left_title">Left</td>
						<td width="14%" id="right_title">Right</td>
						<td width="14%" id="height_title">Height</td>
						<td id="weight_title">Weight</td>
					</tr>
					<tr class="">
						<td width="" align="center"><input type="text" name="type_void" style="width:80;text-align:center" class="noinput" readonly></td>
						<td width="" align="center"><input type="text" name="front_len" value=".00" style="width:80;text-align:right" class="noinput" readonly></td>
						<td width="" align="center"><input type="text" name="rear_len" value=".00" style="width:80;text-align:right" class="noinput" readonly></td>
						<td width="" align="center"><input type="text" name="left_wdt" value=".00" style="width:80;text-align:right" class="noinput" readonly></td>
						<td width="" align="center"><input type="text" name="right_wdt" value=".00" style="width:80;text-align:right" class="noinput" readonly></td>
						<td width="" align="center"><input type="text" name="hgt" value=".00" style="width:80;text-align:right" class="noinput" readonly></td>
						<td width="" align="center"><input type="text" name="wgt" value=".00" style="width:80;text-align:right" class="noinput" readonly></td>			
					</tr>
				</table>
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<table border="0" style="width:100%;" class="search"> 
						
						<tr class="h23">
						<td width="130">Additional Dead Slot</td>
						<td width="100"><input type="text" name="add_dead_slot" style="width:40;text-align:center" value="0" class="noinput2"></td>
						<td width="170">Total Estimated Dead Slot</td>
						<td width="">
							<input type="text" style="width:40;text-align:center;background-color:E8EFF9;" value="Q2" class="noinput2" readonly>&nbsp;<input type="text" name="total_dead_slot1" value="0" style="width:40;text-align:center" class="noinput2" readonly>&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="text" style="width:40;text-align:center;background-color:E8EFF9;" value="Q4" class="noinput2" readonly>&nbsp;<input type="text" name="total_dead_slot2" value="0" style="width:40;text-align:center" class="noinput2" readonly></td>
						</tr>
				</table>
				<table border="0" style="width:100%;" class="search"> 
						<tr class="h23">
						<td width="40" valign="top">Note </td>
						<td width=""><textarea name="cgo_spec_rmk" cols="120" rows="4" style="ime-mode:disabled" readonly></textarea></td>
						</tr>
				</table>
				<table width="100%" id="mainTable" style="display:none">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>		
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 

<table class="height_5"><tr><td></td></tr></table>
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>