<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FNS_JOO_0081.jsp
*@FileTitle : Booking Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.25
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.01.25 장강철
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.03.21 신자영 [CHM-201109531-01] JOO/Booking Data Inquiry 기능 보완 - Double Calling Port 정보 표기 방법
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0081Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsJoo0081Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.JointOperationAgreementSettlement.CarrierSettlementProcess");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (FnsJoo0081Event)request.getAttribute("Event");
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
<title>Loading Port Inquiry</title>
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
 
<body  onLoad="setupPage();" >
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
 
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
    <tr><td valign="top">
<iframe name='ifExcelDown'  style='display:none'></iframe>
        <!--Page Title, Historical (S)-->
            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
                <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
                <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
            </table>
        <!--Page Title, Historical (E)-->   
    
    
    <!--biz page (S)-->
        <table class="search"> 
        <tr><td class="bg">
                <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                <td width="50">VSL/VO</td>
                    <td width="120"><input type="text" style="width:80" class="input1"  required maxlength='8'  caption='VVD' style="ime-mode:disabled"  fullfill name='vvd' >
                </td>
                <td width="50">HC Rate</td>
                    <td width="80"><input type="text" style="width:40" class="nummask_input1"  required  caption='HC Rate' style="ime-mode:disabled"   name='ratehc' value="2">
                </td>
                <td width="50">45 Rate</td>
                    <td width=""><input type="text" style="width:40" class="nummask_input1"  required     caption='45 Rate' style="ime-mode:disabled"   name='rate45'  value="2" >
                </td> 
				<td width="200" >
					 <table border="0" style="width:180;" class="search_sm">
					 <tr  class="h23"><td width=""></td>
					<td width="" class="noinput1" style="font-size:12;"><input type="radio" name="option" value="A" class="trans" checked> Type A <input type="radio" name="option" value="B" class="trans"> Type B </td></tr></table>
				</td>  					      
                </tr>
                </table>                
                <!--  biz_1   (E) -->
            </td>
        </tr>
        </table>
        <table class="height_10"><tr><td colspan="8"></td></tr></table>
        
        <!-- Tab BG Box  (S) -->
        <table class="search"> 
        <tr><td class="bg">                        
            <!-- Grid  (S) -->
                    <table width="100%"  id="mainTable">
                        <tr>
                            <td width="100%">
                                <script language="javascript">ComSheetObject('sheet1');</script>
                            </td>
                        </tr>
                    </table>
            <!-- Grid (E) -->

            </td>
        </tr>
        </table>
    <!-- Tab BG Box  (S) -->
    <!--biz page (E)-->
    
    
    <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Retrieve"  id="btn_Retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_DownExcel" id="btn_DownExcel">Down Excel</td>
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
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>