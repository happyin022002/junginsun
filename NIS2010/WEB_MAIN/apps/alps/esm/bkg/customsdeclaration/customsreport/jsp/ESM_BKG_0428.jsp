<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0428.jsp
*@FileTitle : US AMS: Receive History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01 
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.06.01 이수빈
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

<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.event.EsmBkg0428Event"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Locale" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0428Event  event 		= null;	//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;	//서버에서 발생한 에러
	String strErrMsg 			= "";	//에러메세지
	int rowCount	 			= 0;	//DB ResultSet 리스트의 건수

	String successFlag 	= "";
	String codeList  	= "";
	String pageRows  	= "1000";
	String strUsr_id	= "";
	String strUsr_nm	= "";

	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.CustomsReport");
	
	String vvdCd = "";
	String polCd = "";
	String podCd = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0428Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		vvdCd  = JSPUtil.getParameter(request, "vvd_cd");
		polCd  = JSPUtil.getParameter(request, "pol_cd");
		podCd  = JSPUtil.getParameter(request, "pod_cd");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>US AMS: Receive History</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	var today = "<%=JSPUtil.replace(DateTime.getDateString(),".","-")%>";

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
<input type="hidden" name="vsl_cd">
<input type="hidden" name="skd_voy_no">
<input type="hidden" name="skd_dir_cd">

<input type="hidden" name="msg_tp_id">
<input type="hidden" name="vvd2">
<input type="hidden" name="pol">
<input type="hidden" name="pod">
<input type="hidden" name="bl_no">
<input type="hidden" name="batch_no">
<input type="hidden" name="cnt_cd">
<input type="hidden" name="io_bnd_cd">
<input type="hidden" name="rcv_date">
<input type="hidden" name="rcv_seq">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
    <tr><td valign="top">
        <!--Page Title, Historical (S)-->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title">US AMS: Receive History</span></td></tr>
        </table>
        <!--Page Title, Historical (E)-->
    
        <!--biz page (S)-->
        <table class="search" id="mainTable"> 
            <tr><td class="bg">

                <!--  biz_1 (S) -->
                <table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="100" rowspan="2">					
						<table class="search_sm" border="0" width="100">
							<tr class="h23">
								<td align="center">MSG Type</td></tr>
							<tr class="h23">
								<td align="center">
									<script language="javascript">ComComboObject('rcv_msg_tp_id', 2, 50, 1, 1);</script>
								</td>
							</tr>
						</table>
					</td>
					<td width="50">VVD</td>
					<td width="120"><input type="text" style="width:80; ime-mode: disabled" class="input"
                        dataformat="eng" name="vvd" maxlength="9" fullfill caption="VVD"  value="<%=vvdCd%>"></td> 
					<td width="50">POL</td>
					<td width="80"><input type="text" style="width:60; ime-mode: disabled" class="input"
                        dataformat="eng" name="pol_cd" maxlength="5" fullfill caption="POL"  value="<%=polCd%>" ></td>
					<td width="60">Customs</td>
					<td width=""><input type="text" style="width:60; ime-mode: disabled" class="input"
                        dataformat="eng" name="pod_cd" maxlength="5" fullfill caption="POD" value="<%=podCd%>"></td> 
					<td width="40"></td>
					<td width="40"></td>					
					<td rowspan="2" align="right">
                		<table class="search_sm" border="0" width="330">
							<tr class="h23">
								<td width="110"><input type="checkbox" name="gubun" class="trans"> Receive Date</td></tr>
							<tr class="h23">
								<td class="stm">
			                         <input type="text"
	                        style="width: 75; ime-mode: disabled" class="input1" value="<%//=JSPUtil.replace(DateTime.getDateString(),".","-")%>" disabled required
	                        dataformat="ymd" name="fromd" maxlength="10" caption="Receive Date" cofield="tod">
	                        &nbsp;<input type="text" name="fromt" maxlength="5" style="width:40" dataformat="hm" value="00:00" class="input1" disabled>
	                        &nbsp;~&nbsp; <input type="text"
	                        style="width: 75; ime-mode: disabled" class="input1" value="<%//=JSPUtil.replace(DateTime.getDateString(),".","-") %>" disabled required
	                        dataformat="ymd" name="tod" maxlength="10" caption="Receive Date" cofield="fromd">
	                        &nbsp;<input type="text" name="tot" maxlength="5" style="width:40" dataformat="hm" value="23:59" class="input1" disabled>
	                        <img src="img/btns_calendar.gif" width="19" height="20" alt=""
	                        border="0" align="absmiddle" class="cursor" name="btn_calendar"></td>
							</tr>
						</table>
                </td> 
				</tr>
				<tr class="h23">
					<td width="">B/L No.</td>
					<td width=""><input type="text" style="width:112; ime-mode: disabled" class="input"
                        dataformat="eng" name="bl_nos"  caption="B/L No."></td> 
					<td>Batch No.</td>
					<td><input type="text" style="width:60; ime-mode: disabled" class="input"
                        dataformat="int" name="cstms_bat_no" maxlength="5" fullfill caption="Batch No."></td>
                        <td>SCAC</td>
					<td><input type="text" style="width:60; ime-mode: disabled" class="input"
                        dataformat="eng" name="scac_cd" maxlength="4" fullfill caption="SCAC"></td>
					<td>RHQ</td>
					<td><script language="javascript">ComComboObject("rct_rhq_cd", 1, 65, 0,1,1);</script></td>
					<td></td>
					<td></td> 
					<td colspan="2"></td> 
				</tr>
				</table>
               
                <!--  biz_1   (E) -->       
                    
        </td></tr></table>
        <table class="height_8"><tr><td></td></tr></table>  
        
        <table class="search" id="mainTable"> 
        <tr><td class="bg">
            <!-- Grid_2 (S) -->
                <table width="100%"  id="mainTable"> 
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                    </tr>
                </table> 
            <!-- Grid_2 (E) --> 
            </td></tr>
        </table>
        <!--biz page (E)-->
    
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
		    <tr><td class="btn1_bg">
		    
		        <table border="0" cellpadding="0" cellspacing="0">
		        <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
		                <tr><td class="btn1_left"></td>
		                <td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
		                <td class="btn1_right"></td>
		                </tr>
		            </table></td>
		            <td class="btn1_line"></td>
		            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
		                <tr><td class="btn1_left"></td>
		                <td class="btn1" name="btn_view">View Receive File</td>
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