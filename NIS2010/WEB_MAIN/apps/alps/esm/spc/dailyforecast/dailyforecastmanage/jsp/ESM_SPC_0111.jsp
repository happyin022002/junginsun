<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0111.jsp
*@FileTitle : Load Office Mapping
*Open Issues :
*Change history :
* 2013-02-14
* 1.0 최초 생성
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2013.02.14 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2014.02.04 [CHM-201428383-01] RFA 로직 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.event.EsmSpc0111Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	String trd_cd      = JSPUtil.getParameter(request, "trade", "");
	String sub_trd_cd  = JSPUtil.getParameter(request, "subtrade", "");
	String lane        = JSPUtil.getParameter(request, "lane", "");
	String ofc_cd      = JSPUtil.getParameter(request, "ofc_cd", "");
	String ioc         = JSPUtil.getParameter(request, "ioc", "");
	String cust_cnt_cd = JSPUtil.getParameter(request, "cust_cnt_cd", "").substring(0,2);
	String cust_seq    = JSPUtil.getParameter(request, "cust_cnt_cd", "").substring(2);
	String cust_nm     = JSPUtil.getParameter(request, "cust_nm", "");
	String fcast_seq   = JSPUtil.getParameter(request, "fcast_seq", "");
	String sc_no       = JSPUtil.getParameter(request, "sc_no", "");
	String rfa_no      = JSPUtil.getParameter(request, "rfa_no", "");
	String sc_flg      = JSPUtil.getParameter(request, "sc_flg", "");
	
	EsmSpc0111Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.Spacecontrolinquiry.Spacecontrolinquiry");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmSpc0111Event)request.getAttribute("Event");
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
<title>Load Office Mapping</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

	var curPgmNo = "ESM_SPC_0111";
	var curTitle = "Load Office Mapping";
	var curDescription = "Load Office Mapping";
	
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
<input type="hidden" name="lane" value="<%=lane%>">
<input type="hidden" name="custcntcd" value="<%=cust_cnt_cd%>">
<input type="hidden" name="custseq"   value="<%=cust_seq%>">
<input type="hidden" name="cust_nm"   value="<%=cust_nm%>">
<input type="hidden" name="fcast_seq" value="<%=fcast_seq%>">
<input type="hidden" name="ioc"       value="<%=ioc%>">
<input type="hidden" name="sc_no"     value="<%=sc_no%>">
<input type="hidden" name="rfa_no"    value="<%=rfa_no%>">
<input type="hidden" name="sc_flg"    value="<%=sc_flg%>">

<!-- 개발자 작업	-->
<!-- Outer Table (S)-->
<table width="550" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
     	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
			<tr><td class="btn1_bg">

					<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
						
						<td class="btn1_line"></td>

						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
						<!-- Repeat Pattern -->

					</tr></table>

			</td></tr>
		</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->
	 	<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search" id="searchCondition">
       	<tr><td class="bg">

				<!-- : ( Year ) (S) -->
				<table class="search" border="0">
				<tr>
					<td>
					<table class="search" border="0">
					<tr class="h23">
						<td width="60"><img class="nostar">Trade</td>
						<td width="80"><input type="text" name="trade" size="7" readonly style="ime-mode:disabled; text-align:center;" value ="<%=trd_cd%>"></td>
						<td width="80"><img class="nostar">Sub Trade</td>
						<td width="50"><input type="text" name="subTrade" size="2" readonly style="ime-mode:disabled; text-align:center;" value ="<%=sub_trd_cd%>"></td>
						
						<td width="115"><img class="nostar">Contract Office</td>
						<td><input type="text"" name="ofc_cd" size="7" readonly style="ime-mode:disabled; text-align:center;" value ="<%=ofc_cd%>"></td>
					</tr>
					</table>
					</td>

				</tr>
				</table>
				<!-- : ( Year ) (E) -->
			</td></tr>
		</table>
		<table class="height_10"><tr><td></td></tr></table>

		<!-- UI_ESM_SPC_112 : THIS IS 1st TAB -->
		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
       	<tr><td class="bg">
				<table width="100%" class="button">
					<tr>
						<td>
							<table border="0" width="100%" class="button">
								<tr><td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<!-- Repeat Pattern -->
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" name="btn_rowadd" id="btn_rowadd">Row Add</td>
											<td class="btn2_right"></td></tr></table></td>
											<!-- Repeat Pattern -->
										</tr>
									</table>
								</td></tr>
							</table>
						</td>
					</tr>
				</table>

				<!-- : ( POR ) (S) -->

				<table width="100%" id="mainTable">
                       <tr><td>
                            <script language="javascript">ComSheetObject('sheet1');</script>
                       </td></tr>
	            </table>


				<!-- : ( POR ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
</td></tr>

</table>
<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>