<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0916.jsp
*@FileTitle : ESM_BKG_0916
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.07.10 김승민
* 1.0 Creation
* History
* 2015.04.20 신영재 소스보안 결함 수정
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0916Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
	EsmBkg0916Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String vvdCd		= "";
	String portCd			= "";
	String bkgNo			= "";
	String cntrNo			= "";
	String cntrLodgNo			= "";
	String rowNum ="";
	String gubun = "";
	String gubunValue = "";
	Logger log = Logger.getLogger("com.hanjin.apps.TerminalDocumentation.CLLCDLManifest");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		vvdCd = StringUtil.xssFilter(request.getParameter("vvdCd"))==null?"":StringUtil.xssFilter(request.getParameter("vvdCd"));
		portCd = StringUtil.xssFilter(request.getParameter("portCd"))==null?"":StringUtil.xssFilter(request.getParameter("portCd"));
		bkgNo = StringUtil.xssFilter(request.getParameter("bkgNo"))==null?"":StringUtil.xssFilter(request.getParameter("bkgNo"));
		cntrNo = StringUtil.xssFilter(request.getParameter("cntrNo"))==null?"":StringUtil.xssFilter(request.getParameter("cntrNo"));
		cntrLodgNo = StringUtil.xssFilter(request.getParameter("cntrLodgNo"))==null?"":StringUtil.xssFilter(request.getParameter("cntrLodgNo"));
		rowNum = StringUtil.xssFilter(request.getParameter("rowNum"))==null?"":StringUtil.xssFilter(request.getParameter("rowNum"));
		gubun = StringUtil.xssFilter(request.getParameter("gubun"))==null?"":StringUtil.xssFilter(request.getParameter("gubun"));
		gubunValue = StringUtil.xssFilter(request.getParameter("gubunValue"))==null?"":StringUtil.xssFilter(request.getParameter("gubunValue"));

		event = (EsmBkg0916Event)request.getAttribute("Event");
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
<title>ESM_BKG_0916</title>
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

<body class="popup_bg"  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="in_vsl_cd" value="<%= vvdCd.substring(0,4)%>">
<input type="hidden" name="in_skd_voy_no" value="<%= vvdCd.substring(4,8)%>">
<input type="hidden" name="in_skd_dir_cd" value="<%= vvdCd.substring(8)%>">
<input type="hidden" name="in_port_cd" value="<%= portCd%>">
<input type="hidden" name="in_bkg_no" value="<%= bkgNo%>">
<input type="hidden" name="in_cntr_no" value="<%= cntrNo%>">
<input type="hidden" name="in_cntr_lodg_no" value="<%= cntrLodgNo%>">
<input type="hidden" name="rowNum" value="<%= rowNum%>">
<input type="hidden" name="gubun" value="<%= gubun%>">
<input type="hidden" name="gubunValue" value="<%= gubunValue%>">
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> CLL for EDI - RF Info</span></td></tr>
		</table>	
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
			
			
				<table class="search" border="0"> 
				<tr class="h23">
					<td width="80">Booking No.</td> 
					<td width="120"><input type="text" style="width:100;text-align:center;" class="input2" name="form1_bkg_no" value="<%=bkgNo %>" readonly></td>
					<td width="90">Container No.</td>
					<td width=""><input type="text" style="width:100;text-align:center;" class="input2" name="form1_cntr_no" value="<%=cntrNo %>" readonly></td>
				</tr>
				</table>
			
				<table class="height_5"><tr><td></td></tr></table>
				
				<table class="search" border="0"> 
				<tr class="h23">
					<td width="350" valign="top">
					
					<table class="grid2" border="0" style="width:100%;"> 
						<tr class="h23">
							<td width="110" class="tr2_head">Over Front</td> 
							<td colspan="2"><input type="text" style="width:100%" class="noinput" name="form1_ovr_fwrd_len" value="" dataformat="num3" style="ime-mode:disabled"></td>
						</tr>
						<tr class="h23">
							<td width="" class="tr2_head">Over Rear</td> 
							<td colspan="2"><input type="text" style="width:100%" class="noinput" name="form1_ovr_bkwd_len" value="" dataformat="num3" style="ime-mode:disabled"></td>
						</tr>
						<tr class="h23">
							<td width="" class="tr2_head">Over Height</td> 
							<td colspan="2"><input type="text" style="width:100%" class="noinput" name="form1_ovr_hgt" value="" dataformat="num3" style="ime-mode:disabled"></td>
						</tr>
						<tr class="h23">
							<td width="" class="tr2_head">Over Left Width</td> 
							<td colspan="2"><input type="text" style="width:100%" class="noinput" name="form1_ovr_port_len" value="" dataformat="num3" style="ime-mode:disabled"></td>
						</tr>
						<tr class="h23">
							<td width="" class="tr2_head">Over Right Width</td> 
							<td colspan="2"><input type="text" style="width:100%" class="noinput" name="form1_ovr_sd_len" value="" dataformat="num3" style="ime-mode:disabled"></td>
						</tr>
						<tr class="h23">
							<td width="" class="tr2_head">Over Weight</td> 
							<td width="120"><input type="text" style="width:100%" class="noinput" name="form1_ovr_cntr_wgt" value="" dataformat="num2" style="ime-mode:disabled"></td>
							<td width="">
						<select name="form1_ovr_wgt_ut_cd" style="width:120">
						<!-- option value=""></option-->
						<option value="KGS">KGS</option>
						<option value="LBS">LBS</option>
						</select>							
							<!-- input type="text" style="width:100%" class="noinput" name="form1_ovr_wgt_ut_cd" value="" maxlength="" dataformat="num3" style="ime-mode:disabled"--></td>
						</tr>
					</table>
					
					
					</td> 
					<td width="15" valign="top"></td> 
					<td width="" valign="top">
					
					<table class="grid2" border="0" style="width:100%;"> 
						<tr class="h23">
							<td width="100" class="tr2_head" rowspan="2">Temperature</td> 
							<td width="60"><input type="text" style="width:100%;text-align:right" class="noinput" name="form1_cdo_temp" maxlength="9" onBlur="cToF();" dataformat="num" style="ime-mode:disabled"></td>
							<td width=""><input type="text" style="width:100%" class="noinput" value="C" readonly></td>
						</tr>
						<tr class="h23">
							<td width="70" class="noinput2"><input type="text" style="width:100%;text-align:right" class="noinput2" name="form1_fdo_temp" value="" readonly></td>
							<td class="noinput2"><input type="text" style="width:100%" class="noinput2" value="F" readonly></td>
						</tr>
						<tr class="h23">
							<td width="" class="tr2_head">Ventilation</td> 
							<td><input type="text" style="width:100%;text-align:right" class="noinput" name="form1_cntr_vent_rto" value="" dataformat="num2" style="ime-mode:disabled"></td>
							<td><input type="text" style="width:100%" class="noinput" value="%" readonly></td>
						</tr>
					</table>
					
					</td> 
				</tr>
				</table>
				
				
			
				
			
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 


<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right">
				</tr></table></td>
				<td class="btn1_line">
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right">
				</tr></table></td>
			</tr>
		</table>
		</td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
<!-- : ( Button : pop ) (E) -->
<table width="100%"  id="mainTable" style="display:none"> 
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('sheet1');</script>
		</td>
	</tr>
</table>  			
</form>			
</body>
</html>