<%/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : ESM_BKG_0507.jsp
*@FileTitle : US AMS: Transmission History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.07.14 이수빈
* 1.0 Creation
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>

<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.event.EsmBkg0507Event"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Locale" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0507Event  event 		= null;	//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;	//서버에서 발생한 에러
	String strErrMsg 			= "";	//에러메세지
	int rowCount	 			= 0;	//DB ResultSet 리스트의 건수

	String successFlag 	= "";
	String codeList  	= "";
	String pageRows  	= "1000";
	String strUsr_id	= "";
	String strUsr_nm	= "";
    String today        = "";

	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.CustomsReport");
	
	String vvdCd = "";
	String polCd = "";
	String podCd = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0507Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		today = eventResponse.getETCData("date"); 
        codeList = HttpUtil.makeXML(request,response);
        
		vvdCd  = JSPUtil.getParameter(request, "vvd_cd");
		polCd  = JSPUtil.getParameter(request, "pol_cd");
		podCd  = JSPUtil.getParameter(request, "pod_cd");		
		
	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String strIoBndCd = "";
	String strPgmNo = request.getParameter("pgmNo");
	if ("ESM_BKG_0507".equals(strPgmNo)) {
		strIoBndCd = "I";
	} else {
		strIoBndCd = "O";
	}	
%>
<html>
<head>
<title>US AMS: Transmission History</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    var today = "<%=today%>";
    
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if

		loadPage();
	}
</script>
</head>

<body  onLoad="javascript:setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows" value=<%=pageRows%>>

<input type="hidden" name="msg_tp_id">
<input type="hidden" name="vvd2">
<input type="hidden" name="pol">
<input type="hidden" name="pod">
<input type="hidden" name="ofc">
<input type="hidden" name="usr">

<input type="hidden" name="cnt_cd">
<input type="hidden" name="io_bnd_cd" value="<%=strIoBndCd%>">
<input type="hidden" name="snd_date">
<input type="hidden" name="his_seq">
<input type="hidden" name="ofm_flg">

<input type="hidden" name="usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="code_list" value="<%=codeList%>">
<input type="hidden" name="auto_gubun">
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr><td valign="top">
        <!--Page Title, Historical (S)-->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title">US AMS: Transmission History</span></td></tr>
        </table>
        <!--Page Title, Historical (E)-->
	
	
		<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="120" rowspan="2">
					
						<table class="search_sm" border="0" width="100">
							<tr class="h23">
								<td align="center">MSG Type</td></tr>
							<tr class="h23">
								<td align="center">
									<script language="javascript">ComComboObject('trsm_msg_tp_id', 2, 70, 1, 1);</script>
								</td>
							</tr>
						</table>
					
					</td>
					<td width="60">VVD</td>
					<td width="110"><input type="text" name="vvd" style="width:90; ime-mode: disabled;" class="input" dataformat="eng" minlength="9" maxlength="9" fullfill caption="VVD" value="<%=vvdCd%>"></td> 
					<td width="50">POL</td>
					<td width="80"><input type="text" name="pol_cd" style="width:60; ime-mode: disabled;" class="input" dataformat="eng" maxlength="5" fullfill caption="POL"  value="<%=polCd%>"></td>
					<td width="65">POD</td>
					<td width="100"><input type="text" name="pod_cd" style="width:60; ime-mode: disabled;" class="input" dataformat="eng" maxlength="5" fullfill caption="POD"  value="<%=podCd%>"></td> 
<%					if ( "I".equals(strIoBndCd))  { %>
						<td width="90">Last F. POL</td>
						<td width="70"><input type="text" name="lst_for_pol" style="width:50; ime-mode: disabled;" class="input" dataformat="eng" maxlength="5" fullfill caption="Last F. POL"></td> 
<%					}  else { %>
						<td width="90"></td>
						<td><input type="hidden" name="lst_for_pol" value=""></td>
<%					}  %> 
					<td rowspan="2" align="right">
					
						<table class="search_sm" border="0" width="300">
							<tr class="h23">
								<td width="150"><input type="checkbox" name="gubun" class="trans">&nbsp;Send Date</td>
								<td width="150"><input type="checkbox" name="auto_notification" class="trans">&nbsp;Auto Notification</td>
							</tr>
							<tr class="h23">
								<td class="stm" colspan="2">
			                        <input type="text"
			                        style="width: 75; ime-mode: disabled" class="input1" value="<%=today%>" disabled required
			                        dataformat="ymd" name="snd_fromd" maxlength="10" caption="Send Date" cofield="snd_tod">
			                        <input type="text" name="snd_fromt" maxlength="5" style="width:40" dataformat="hm" value="00:00" class="input1" disabled>
			                        ~ <input type="text"
			                        style="width: 75; ime-mode: disabled" class="input1" value="<%=today%>" disabled required
			                        dataformat="ymd" name="snd_tod" maxlength="10" caption="Send Date" cofield="snd_fromd">
			                        <input type="text" name="snd_tot" maxlength="5" style="width:40" value="23:59" class="input1" disabled>
			                        <img src="img/btns_calendar.gif" width="19" height="20" border="0" dataformat="hm" align="absmiddle" class="cursor" name="btn_calendar">
								</td>
							</tr>
						</table>

					</td> 
				</tr>
				<tr class="h23">
					<td>B/L No.</td>
					<td><input type="text" name="bl_no" style="width:100; ime-mode: disabled;" class="input"
						dataformat="eng" maxlength="12" fullfill caption="B/L No."></td>
					<td>OFFICE</td>
					<td><input type="text" name="snd_ofc_cd" style="width:60; ime-mode: disabled;" class="input"
						dataformat="eng" minlength="5" maxlength="6" caption="OFFICE"></td>
					<td>USER ID</td>
					<td><input type="text" name="snd_usr_id" style="width:80; ime-mode: disabled;" classESM_BKG_0507.jsp="input"></td> 
					<td>RHQ</td>
					<td><script language="javascript">ComComboObject("rct_rhq_cd", 1, 65, 0,1,1);</script></td>
					<td colspan="2"></td> 
				</tr>
				</table>
				<!--  biz_1   (E) -->

				</td></tr>
			</table>
			<table class="height_8"><tr><td></td></tr></table>
			

		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable">
       	<tr><td class="bg">

				<!--Grid (S)-->
				<table width="100%"  id="mainTable"> 
                    <tr width = "100%">
                        <td width="100%" style="font size:11;">* EST (GMT -05:00)</td>
                    </tr> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>				
				<!--Grid (E)-->
				
				
			</td></tr>
		</table>
		<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table width="100%" border="0" cellpadding="0" cellspacing="0">
		    <tr>
<%			if ( "I".equals(strIoBndCd))  { %>		    
		    <td>		    
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_ofm_retrieve">OFM History Retrieve</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_ofm_file">View OFM File</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
				</tr></table>
			</td>
<%			} %>
				
			<td align="right">			
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
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
						<td class="btn1" name="btn_file">View Sent File</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_downexcel">Down Excel</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
				</tr></table>				
			</td>
			</tr>
			</table>
		</td></tr> 
		</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
	
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>