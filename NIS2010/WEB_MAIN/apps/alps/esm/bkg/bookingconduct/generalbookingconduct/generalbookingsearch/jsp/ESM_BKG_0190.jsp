<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : ESM_BOOK_0190.jsp
	 *@FileTitle : Actual Customer
	 *Open Issues :
	 * parameter: sc_no또는 rfa_no,svc_scp_cd는 필수 조건.app_dt는 YYYY-MM-DD 형태
	 * 예( sc_no=HAM090003&svc_scp_cd=ACE&app_dt=2009-06-10)
	* parameter: sc_no또는 rfa_no,svc_scp_cd는 필수 조건.app_dt는 YYYY-MM-DD 형태
	* 예( sc_no=HAM090003&svc_scp_cd=ACE&app_dt=2009-06-10)
	*  ComOpenPopupWithTarget('/hanjin/ESM_BKG_0190.do?sc_no=HAM090003&svc_scp_cd=ACE&app_dt=2009-06-10', 800, 310,'sheet1_cust_cnt_cd:cust_cnt_cd|sheet1_cust_seq:cust_seq', '0,1,1,1,1,1,1', true);">
	*  sc_no또는 rfa_no,svc_scp_cd는 필수.
	*  콜백 메소드를 사용하려면 ComOpenPopup 공통 팝업 메소드를 사용.
	 *Change history :
	 *@LastModifyDate : 2009.05.13
	 *@LastModifier : 김경섭
	 *@LastVersion : 1.0
	 * 2009.05.13 김경섭
	 * 1.0 Creation
	 ===========================================================
	 History
	 2014.12.09 최도순[CHM-201432911] E-bkg/Upload 스크린에 A/customer 저장 요청
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0190Event"%>	
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0190Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	boolean bBtn_Disabled = true;

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0190Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
  String svc_scp_cd = JSPUtil.getNull(request.getParameter("svc_scp_cd")); 
  String app_dt     = JSPUtil.getNull(request.getParameter("app_dt")); 
  String sc_no      = JSPUtil.getNull(request.getParameter("sc_no")); 
  String rfa_no      = JSPUtil.getNull(request.getParameter("rfa_no")); 
  String bkg_no      = JSPUtil.getNull(request.getParameter("bkg_no")); 
  
  
  String por_cd      = JSPUtil.getNull(request.getParameter("por_cd")); 
  String del_cd      = JSPUtil.getNull(request.getParameter("del_cd")); 
  String cmdt_cd      = JSPUtil.getNull(request.getParameter("cmdt_cd")); 
  String bkg_upld_flg = JSPUtil.getNull(request.getParameter("bkg_upld_flg")); 
%>
<html>
<head>
<title>Customer Information_Actual Customer</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        // InitTab();
        loadPage();
    }
</script>
</head>
<!-- 
showErrMessage를 써주지 않으면 에러 발생시 처리가 불가합니다.
그리고 지금은 showErrMessage()으로 되어있지만 추후에 고객님이 변덕을 일으켜서 웹페이지를 호출하라고 할경우를 
대비해서 직접 showErrMessage() 하지 마시고 꼭 showErrMessage를 써주십시오. 한방에 바꾸게요. 표준을 안따르면 나중에 후회합니다.  
-->

<body class="popup_bg" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="svc_scp_cd" value="<%=svc_scp_cd%>">
<input type="hidden" name="por_cd" value="<%=por_cd%>">
<input type="hidden" name="del_cd" value="<%=del_cd%>">
<input type="hidden" name="cmdt_cd" value="<%=cmdt_cd%>">
<input type="hidden" name="bkg_upld_flg" value="<%=bkg_upld_flg%>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="./img/icon_title_dot.gif" align="absmiddle">&nbsp;Actual Customer</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
			
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="50">RFA No.</td>
						<td width="110">
								<input type="input" name="rfa_no"  style="width:100;" value="<%=rfa_no%>" readonly class="input2"><!-- AAR09P0002 --><!-- 2009-01-01 -->
						</td>
						<td width="50">S/C No.</td>
						<td width="110">
								<input type="input" name="sc_no"  style="width:100;" value="<%=sc_no%>" readonly class="input2"><!-- HAM090003 --> 
						</td>
						<td width="50">BKG No.</td>
						<td width="110">
						    <input type="input" name="bkg_no" style="width:100;" value="<%=bkg_no%>" readonly class="input2">
						</td>
						<td width="50">Duration</td>
						<td width=""><input type="text" style="width:80;" class="input2" value="" disabled name="from_dt">&nbsp;~&nbsp;
						               <input type="text" style="width:80;" class="input2" value="" disabled name="to_dt">
	          </td>
					</tr>
					</table>
					
				<table class="search" border="0" style="width:100%;">
				<tr><td height='5'></td></tr>
				<tr class="h23">					
					<td width="100">Applicable Date</td>
					<td width="170">
					<input type="text" style="width:80;" class="input1" value="<%=app_dt%>" name="app_dt" maxlength='8' dataformat='ymd' style="ime-mode:disabled">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_app_dt"></td> 
					<td width="40">Name</td>
					<td width=""><input type="text" style="width:165;" class="input" value="" name="cust_lgl_eng_nm" maxlength='20' style="ime-mode:disabled" onKeyUp="javascript:upper(this);"></td> 
				</tr>
			</table>
				
				<!-- : ( Grid ) (S) -->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%" style='padding-top:10px'>
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
				<!-- : ( Grid ) (E) -->	
		    <!-- : ( Button : Grid ) (E) -->	
			
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
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve" >Retrieve</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Select">Select</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
			

</form>
</body>
</html>
 <%@include file="/bizcommon/include/common_alps.jsp"%>
