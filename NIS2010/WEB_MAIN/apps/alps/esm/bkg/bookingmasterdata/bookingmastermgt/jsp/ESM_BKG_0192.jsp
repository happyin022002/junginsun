<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : esm_bkg_0192.jsp
	 *@FileTitle :  B/L CUSTOMER
	 *Open Issues :
	 * parameter: sc_no또는 rfa_no,svc_scp_cd는 필수 조건.app_dt는 YYYY-MM-DD 형태
	 * 예( sc_no=HAM090003&svc_scp_cd=ACE&app_dt=2009-06-10)
	* parameter: sc_no또는 rfa_no,svc_scp_cd는 필수 조건.app_dt는 YYYY-MM-DD 형태
	* 예( sc_no=HAM090003&svc_scp_cd=ACE&app_dt=2009-06-10)
	*  ComOpenPopupWithTarget('/hanjin/ESM_BKG_0190.do?sc_no=HAM090003&svc_scp_cd=ACE&app_dt=2009-06-10', 800, 310,'sheet1_cust_cnt_cd:cust_cnt_cd|sheet1_cust_seq:cust_seq', '0,1,1,1,1,1,1', true);">
	*  sc_no또는 rfa_no,svc_scp_cd는 필수 입니다.
	*  콜백 메소드를 사용하려면 ComOpenPopup 공통 팝업 메소드를 사용하면 됩니다.
	 *Change history :
	 *@LastModifyDate : 2009.05.13
	 *@LastModifier : 김경섭
	 *@LastVersion : 1.0
	 * 2009.05.13 김경섭
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0192Event"%>	
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0192Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	boolean bBtn_Disabled = true;
	Logger log = Logger
			.getLogger("com.hanjin.apps.CustomsDeclaration.CndManifestListDownload");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0192Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

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
  String cust_cnt_cd = JSPUtil.getNull(request.getParameter("cust_cnt_cd")); 
  String cust_seq    = JSPUtil.getNull(request.getParameter("cust_seq")); 
  String cust_nm     = JSPUtil.getNull(request.getParameter("cust_nm")); 
  String cust_addr   = JSPUtil.getNull(request.getParameter("cust_addr")); 
  String cty_nm     = JSPUtil.getNull(request.getParameter("cty_nm")); 
  String ste_cd     = JSPUtil.getNull(request.getParameter("ste_cd")); 
  String zip_cd     = JSPUtil.getNull(request.getParameter("zip_cd")); 
  String bco_type   = JSPUtil.getNull(request.getParameter("bco_type")); 
  String custFunc       = JSPUtil.getNull(request.getParameter("func")); 
  String bkg_no       = JSPUtil.getNull(request.getParameter("bkg_no")); 
  String indiv_pson_flg = JSPUtil.getNull(request.getParameter("indiv_pson_flg"));
  String indiv_dp_flg = JSPUtil.getNull(request.getParameter("indiv_dp_flg"));
  
  if(!cust_cnt_cd.equals("") && !cust_seq.equals("")){
	  cust_nm ="";
  }  
%>
<html>
<head>
<title>B/L Customer</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
		<%
				if(!custFunc.equals("")) {					
		%>
		    if(!opener)
		      opener = window.dialogArguments;

			var callbackMethod = opener.<%= custFunc%>;
		//var callbackMethod = <%= custFunc%>;
		<%
				} else{
		%>
			var callbackMethod = null; 
		<%
				}
		%>
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
<input type="hidden" name="bco_type"    value="<%=bco_type%>">
<input type="hidden" name="curr_page"      value="1">
<input type="hidden" name="bkg_no"      value="<%=bkg_no%>">
<input type="hidden" name="indiv_pson_flg_origin" value="<%=indiv_pson_flg %>">
<input type="hidden" name="indiv_dp_flg" value="<%= indiv_dp_flg %>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="./img/icon_title_dot.gif" align="absmiddle">&nbsp;B/L Customer</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
		<table class="search"> 
    	<tr><td class="bg">
			
					<table class="search" border="0" style="width:100%;"> 
						<tr class="h23">
							<td width="33">Code</td>
							<td width="95"><input type="text" style="width:25;" class="input1" name="cust_cnt_cd" dataformat='engup' maxlength='2' style="ime-mode:disabled" value="<%=cust_cnt_cd%>">&nbsp;
							              <input type="text" style="width:50;" class="input"   name="cust_seq"    dataformat='num'   maxlength='6' style="ime-mode:disabled" value="<%=cust_seq %>"></td>
							<td width="37">Name</td>
							<td width="10"><input type="text" style="width:150;" class="input"  name="cust_nm"     maxlength='20' style="ime-mode:disabled" value="<%=cust_nm%>"></td>
							<td width="20"><input type="checkbox" name="include" Style="border-style:none"> 
							<td width="80">Inclusive </td>
					 		
							<td width="32">Address</td>
							<td width="170"><input type="text" style="width:100;" class="input"  name="cust_addr"   maxlength='10' style="ime-mode:disabled" value="<%=cust_addr%>"></td>
							
							<td width="50">No Use </td>
					 		<td width="20"><input type="checkbox" name="no_use"  Style="border-style:none">
							<td width="80">Financial Risk </td>
					        <td width="10"><input type="checkbox" name="bklst"  Style="border-style:none" checked>
							
							</tr>
					</table>
							<table class="search" border="0" style="width:100%;"> 
						<tr class="h23">
						    <td width="53">S. OFC</td>
							<td width="100"><input type="text" name="ofc_cd" style="width:80;" class="input" style="ime-mode:disabled" dataformat="engup"></td> 
							<td width="40">City</td>
							<td width="100"><input type="text" style="width:80;" class="input" name="cty_nm"       dataformat='address' maxlength='10' style="ime-mode:disabled" value="<%=cty_nm%>"></td> 
							<td width="40" >State</td>
							<td width="100"><input type="text" style="width:70;" class="input" name="ste_cd"       dataformat='engup' maxlength='3'  style="ime-mode:disabled" value="<%=ste_cd%>"></td> 
							<td width="80">Zip Code</td>
							<td width="81"><input type="text" style="width:60;" class="input"  name="zip_cd"        dataformat='zipcode' maxlength='10' style="ime-mode:disabled" value="<%=zip_cd%>"></td>
							<td width="80">Area Code</td>
					        <td width="81"><input type="text" style="width:60;" class="input"  name="area_cd" dataformat='zipcode' maxlength='3' style="ime-mode:disabled" ></td>
							
							
							<td width="210">
								<div id="indiv_display" style="display:none"> Individual Person <input type="checkbox" name="indiv_pson_flg" class="trans" value="<%=indiv_pson_flg%>" onclick="delCneeCd();"></div>
							</td>
								
						</tr>
					</table>
					
				<table class="height_8"><tr><td></td></tr></table>	
				
				<!-- : ( Grid 1) (S) -->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
				<!-- : ( Grid 1) (E) -->	
				
				<table class="height_8"><tr><td></td></tr></table>	
			
				<!-- : ( Grid 2 ) (S) -->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
					</table>
				<!-- : ( Grid2 ) (E) -->	
		    <!-- : ( Button : Grid ) (E) -->	
	<table width="100%" class="button">
					<tr>
						<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_RowAdd">Row&nbsp;Add</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_RowDelete">Row Delete</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_Copy">Copy from MDM</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>

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

		<table width="100%" class="button" border="0" cellpadding="0"	cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn3_bg">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"	class="button">
									<tr>
										<td class="btn1_left"></td>
										<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
							</td>
							<td class="btn1_line"></td>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn1_left"></td>
										<td class="btn1" name="btn_Save">Save</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
							</td>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn1_left"></td>
										<td class="btn1" name="btn_Select">Select</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
							</td>
							<td class="btn1_line"></td>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn1_left"></td>
										<td class="btn1" name="btn_Close">Close</td>
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
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
			

</form>
</body>
</html>
 <%@include file="/bizcommon/include/common_alps.jsp"%>
 <SCRIPT LANGUAGE="javascript">
 //부모창에 내려줄 sheet Object세팅 
	sheetObj = sheetObjects[1];
 </script>
 