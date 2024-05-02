<%/*=========================================================
*Copyright(c) 2017 SMLines
*@FileName : ESM_BKG_N006.jsp
*@FileTitle : Canada Export: Receiving History
*Open Issues :
*Change history :
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.event.EsmBkgN006Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkgN006Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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

		event = (EsmBkgN006Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String strBlNo = StringUtil.xssFilter(request.getParameter("bl_no"))==null?"":StringUtil.xssFilter(request.getParameter("bl_no"));
	String strVvdNo = StringUtil.xssFilter(request.getParameter("vvd_cd"))==null?"":StringUtil.xssFilter(request.getParameter("vvd_cd"));
	String strFCmd = StringUtil.xssFilter(request.getParameter("f_cmd"));
	
%>
<html>
<head>
<title>Receive History</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage('<%=strFCmd%>');
	}
</script>
</head>
<body  onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd" value="<%=strFCmd%>">
<input type="hidden" name="pagerows">

<%@include file="/apps/alps/esm/bkg/bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp" %> 

<table class="search">
	<tr>
		<td class="bg">
		<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="140" rowspan="2">
						<table class="search_sm2" border="0" width="110">
							<tr class="h23">
								<td width=""  align="center">MSG TYPE</td></tr>
								<tr class="h23">
								<td  align="center">
									<select style="width:110;" name="rcv_msg_tp_id">
									<option value="">All</option>
									<option value="997">997</option>
									<option value="824">824</option>
									<option value="BRC">Baplie Response</option>
									</select>
								</td>
							</tr>
						</table>
					</td>
					<td width="50">VVD</td>
					<td width="130"><input type="text" style="width:90;ime-mode:disabled" class="input" 
						name="vvd_cd" dataformat="eng" maxlength="9" caption="VVD" value="<%=strVvdNo%>"></td> 
					<td width="45">POL</td>
					<td width="120"><input type="text" style="width:90;ime-mode:disabled" class="input" 
						name="pol_cd" dataformat="engupnum" maxlength="5" caption="POL"></td>
					<td width="55">POD</td>
					<td width="120"><input type="text" style="width:90;ime-mode:disabled" class="input" 
						name="pod_cd" dataformat="engupnum" maxlength="5" caption="POD"></td> 
						
					<td rowspan="2" align="right">
						<table class="search_sm2" border="0" width="330">
							<tr class="h23">
								<td width="120"><input type="checkbox" class="trans" name="rcv_dt_flg" value="true">&nbsp;Receive Date</td></tr>
							<tr class="h23">
								<td class="stm">
									<input type="text" style="width:80;ime-mode:disabled"  maxlength="10"
										name="s_rcv_dt" class="input" dataformat="ymd" caption="Receive Date" cofield="e_rcv_dt">
									<input type="text" style="width:40;ime-mode:disabled"  maxlength="5" value="00:00"
										name="s_rcv_tm" class="input" dataformat="hm" caption="Receive Time">
									&nbsp;~&nbsp;
									<input type="text" style="width:80;ime-mode:disabled"  maxlength="10"
										name="e_rcv_dt" class="input" dataformat="ymd" caption="Receive Date" cofield="s_rcv_dt">
									<input type="text" style="width:40;ime-mode:disabled"  maxlength="5" value="23:59"
										name="e_rcv_tm" class="input" dataformat="hm" caption="Receive Time">
									<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_calendar">
								</td>
							</tr>
						</table>
					</td> 
				</tr>
				<tr class="h23">
					<td>B/L No.</td>
					<td><input type="text" style="width:120;ime-mode:disabled" class="input" 
						name="bl_no" dataformat="eng" maxlength="12" caption="B/L No" value="<%=strBlNo%>"></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td> 
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
						<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
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
				</tr>
			</table>
		</td>
		<td class="btn1_bg">
    		<table border="0" cellpadding="0" cellspacing="0">
    			<tr>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_viewReceiveFile">View Received File</td>
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
	</tr>
</table>
<!--Button (E) -->
		</td>
	</tr>
</table>

<%@include file="/apps/alps/esm/bkg/bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp" %>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>