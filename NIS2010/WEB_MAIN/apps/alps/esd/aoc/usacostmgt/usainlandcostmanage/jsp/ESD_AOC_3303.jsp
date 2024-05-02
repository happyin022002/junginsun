<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_AOC_3303.jsp
*@FileTitle : Inland Cost Management Route Detail(SHA)
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.event.EsdAoc3303Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdAoc3303Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String strCntCd 		= JSPUtil.getNull(request.getParameter("cnt_cd"));
	String strCostTrfNo 	= JSPUtil.getNull(request.getParameter("cost_trf_no"));
	String svcModCd 		= JSPUtil.getNull(request.getParameter("svc_mod_cd"));
	String costRoutGrpNo 	= JSPUtil.getNull(request.getParameter("cost_rout_grp_no"));
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdAoc3303Event)request.getAttribute("Event");
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
<title>Inland Cost Management – Route Detail</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
	
	function doClosePopup(){
		//window.dialogArguments.call_esd_aoc_3302();
		opener.call_esd_aoc_3302();
	}
	
</script>
</head>

<body class="popup_bg" onLoad="setupPage();" onunLoad="javascript:doClosePopup();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 개발자 작업	-->
<input type="hidden" name="in_asc_desc" value="asc">
<input type="hidden" name="s_cost_rout_grp_no" value="<%=costRoutGrpNo%>">
<input type="hidden" name="svc_mod_cd" value="<%=svcModCd%>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	<!-- : ( Title ) (S) -->
	<table width="100%" border="0">
	<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Inland Cost Management – Route Detail
	</td></tr>
	</table>
	<!-- : ( Title ) (E) -->

	<!--biz page (S)-->
	<table class="search"> 
      		<tr><td class="bg">
			<!-- biz_1  (S) -->
			<table class="search" border="0" style="width:878;;"> 
			<tr class="h23">
				<td width="110">Country</td>
				<td width="120"><input type="text" name="in_cnt_cd" style="width:100;text-align:left;" class="input2" value="<%=strCntCd%>" readonly></td>
				<td width="100">Cost Tariff No</td>
				<td width="170"><input type="text" name="in_cost_trf_no" style="width:120;text-align:left;" class="input2" value="<%=strCostTrfNo%>" readonly></td>
				<td width="50">Bound</td>
				<td width="180"><input type="text" name="io_bnd_nm" style="width:150;text-align:left;" class="input2" readonly></td>
				<td width="55">Status</td>
				<td width=""><input type="text" name="cost_trf_sts_nm" style="width:120;text-align:left;" class="input2" readonly></td>
			</tr>
			<tr class="h23">
				<td>Effective From</td>
				<td><input type="text" name="eff_fm_dt" style="width:100;text-align:left;" class="input2" readonly></td>
				<td>Update Date</td>
				<td><input type="text" name="upd_dt" style="width:120;text-align:left;" class="input2" readonly></td>
				<td>User</td>
				<td><input type="text" name="upd_usr_id" style="width:150;text-align:left;" class="input2" readonly></td>
			</tr>
			</table>
			<!-- biz_1  (E) -->		
		</td></tr>
	</table>
	<table class="height_8"><tr><td></td></tr></table>
	<table class="search"> 
      	<tr>
      		<td class="bg">
				<!-- biz_1  (S) -->
				<table class="search" border="0" style="width:878;;"> 
					<tr class="h23">
						<td width="65">Sort by</td>
						<td width="150"><script language="javascript">ComComboObject('in_sort_by', 1, 104, 1, 0);</script></td>
						<td width="250">
							<input type="radio" name="radio_cd" class="trans" checked>Ascending&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="radio_cd" class="trans">Descending
						</td>
						<td width="">
							<table width="80" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_retrieve">Sort</td>
									<td class="btn1_right"></td>
								</tr>
							</table>				
						</td>
						
						<td width="">
							<table width="150" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_1strow">1st Row Select</td>
									<td class="btn1_right"></td>
								</tr>
							</table>				
						</td>
					</tr>
					<tr>
						<td colspan="5" class="stm">When Trans or TML sector is selected, the data based on AGMT has higher priority regardless of the rate.</td>
					</tr>
				</table>
				<!-- biz_1  (E) -->		
			</td>
		</tr>
	</table>
				
	<table class="height_8"><tr><td></td></tr></table>

	<div id="tabLayer" style="display:inline">
		<table class="search"> 
		<tr><td class="bg" style="height:380" valign="top">
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->
		</td></tr>
		</table>
	</div>

	</td></tr>
</table> 

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
      	<tr><td class="btn3_bg">
	    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td width="">
					<table width="110" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_cost_detail">Cost Detail</td>
							<td class="btn1_right"></td>
						</tr>
					</table>
				</td>
				<td width="">
					<table width="110" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_down_excel">Down Excel</td>
							<td class="btn1_right"></td>
						</tr>
					</table>
				</td>
				<td width="">
					<table width="80" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_delete">Delete</td>
							<td class="btn1_right"></td>
						</tr>
					</table>
				</td>
				<td width="">
					<table width="80" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_apply">Apply</td>
							<td class="btn1_right"></td>
						</tr>
					</table>
				</td>
				<td width="">
					<table width="80" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_close">Close</td>
							<td class="btn1_right"></td>
						</tr>	
					</table>
				</td>
			</tr>
		</table>
		</td></tr>
	</table>
</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<div id="tabLayer" style="display:none">
	<table class="search" id="mainTable"> 
      	<tr><td class="bg">	
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet3');</script>
					</td>
				</tr>
			</table>
		</td></tr>
	</table>
</div>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>