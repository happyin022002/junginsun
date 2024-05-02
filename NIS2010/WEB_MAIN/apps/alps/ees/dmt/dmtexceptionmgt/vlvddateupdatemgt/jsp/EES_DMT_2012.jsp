<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_dmt_2012.jsp
*@FileTitle : VL/VD Date Update by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 김재진
*@LastVersion : 1.0
* 2009.08.26 김재진
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.event.EesDmt2012Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt2012Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= ""; 
	String strUsr_nm		= "";
    String strRhq_of = "";
	Logger log = Logger.getLogger("com.hanjin.apps.DMTExceptionMgt.VLVDDateUpdateMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	    strRhq_of = account.getRhq_ofc_cd();
	   
		event = (EesDmt2012Event)request.getAttribute("Event");
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
<title>VL/VD Date Update by VVD CD</title>
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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="loc_cd">
<input type="hidden" name="pastDayR">
<input type="hidden" name="pastVvdR">
<input type="hidden" name="h_rhq_off" value="<%=strRhq_of%>">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
    </td></tr>
    <tr><td valign="top">
    <!--Page Title, Historical (S)-->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
        </table>
    <!--Page Title, Historical (E)-->
    <table class="search"> 
            <tr><td class="bg">
                <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:979;"> 
                    <tr class="h23">
                        <td width="115">Movement Status</td>
                        <td width=" 80">
                            <select style="width:40;" class="input1" name="mvmt" onKeyPress="form_keyup()">
                            <option value="VL" selected>VL</option>
                            <option value="VD"         >VD</option>
                            </select>
                        </td>
                        <td width="70">Tariff type</td>
                        <td width=" ">
                            <input type="text" style="width:82;" class="input2" value="DMOF, CTOC" name="type" readonly>
                        </td>
                    </tr>
                </table>
                <table class="search" border="0" style="width:979;"> 
                    <tr class="h23">
                        <td width="30">Port</td>
                        <td width="85">
                            <input type="text" style="width:50;" class="input1" value="" name="port" dataformat="engup" maxlength="5" OnKeyUp="obj_keyup()">
                        </td>
                        <td width="">
                            <table class="search_sm2" border="0" style="width:520;border:3px;"> 
                                <tr class="h23">
                                    <td width="70">
                                        <input type="radio" name="dayVvdR" value="" class="trans" checked> Period
                                    </td>
                                    <td width="250">
                        <input type="text" style="width:70;" class="input1" value="" name="frdt" required dataformat="ymd" maxlength="8">&nbsp;~&nbsp;
                        <input type="text" style="width:70;" class="input1" value="" name="todt" required dataformat="ymd" maxlength="8">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendarto"  id="btns_calendarfm" >
                                    </td>
                                    <td width="100">
                                        <input type="radio" name="dayVvdR" value="" class="trans"> VVD Code
                                    </td>
                                    <td width="">
                                        <input type="text" style="width:80;" class="input2" value="" name="vvdc" dataformat="engup" maxlength="9" readonly>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
                
                <table class="line_bluedot"><tr><td></td></tr></table>
                <!-- Grid  (S) -->
                    <table width="100%"  id="mainTable"> 
                        <tr>
                            <td width="100%">
                                <script language="javascript">ComSheetObject('sheet1');</script>
                            </td>
                        </tr>
                    </table>
                <!-- Grid  (e) -->
                        </td>
                    </tr>
                
                </table>
        
<!-- : ( Search Options ) (E) -->
 
            
            
                    
                    
            
            </td></tr>
        </table>
    <!-- Tab BG Box  (S) -->
    <!--biz page (E)-->
    <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
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
                    <td class="btn1" name="btn_save">Save</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
        </td></tr>
        </table>
    <!--Button (E) -->
    </td></tr>
</table>
    </td></tr>
</table>
<!-- Copyright (S) -->
<!-- Copyright(E)-->
<!-- 개발자 작업  끝-->
</form>
</body>
</html>