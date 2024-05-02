<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0554.jsp
*@FileTitle : Package Table
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.05.20 김기종
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0554Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0554Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strCntCd			= "";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BookingMasterData.BookingMasterMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strCntCd =	account.getCnt_cd();
	   
		event = (EsmBkg0554Event)request.getAttribute("Event");
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
<title>Package Table</title>
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
<input type="hidden" name="pagerows">
<input type="hidden" name="ibflag" value="I">
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->

	<!-- : ( Grid ) (S) -->
	<table width="100%" class="search"  id="leftTable"> 
        <tr>
            <td width="120">
            <script language="javascript">ComSheetObject('sheet1');</script>
            </td>
        </tr>
    </table>
    <!-- : ( Grid ) (E) -->
          
	<!--biz page (S)-->
		
		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable">
       	<tr><td class="bg">
			<!--  biz_2  (S) -->
			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Input Option</td></tr>
				</table>
			<table border="0" style="width:979;" class="search"> 
				<tr class="h23">
				<td width="90">Country Code</td>
				<td width="80"><input type="text" name="cnt_cd" style="width:30;" class="input1" value="" style="ime-mode:disabled" dataformat="engup" caption="Country Code" maxlength="2" required fullfill ></td>
				<td width="150">Warehouse Abbr. Code</td>
				<td width=""><input type="text" name="wh_cd" style="width:45;" class="input1" value="" style="ime-mode:disabled" dataformat="engup" caption="Warehouse Abbr. Code" maxlength="4" required fullfill ></td>
				</tr>
				</table>
				<!--  biz_2  (E) -->
<!--  Button_Sub (S) -->
			
	    	<!-- Button_Sub (E) -->
	
	<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
			
			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Warehouse Information</td></tr>
				</table>
			<table border="0" style="width:400;" class="grid2"> 
				<tr class="h23">
					<td class="tr2_head" width="100">Customs Code</td>
					<td width="" class="input1" colspan="2"><input type="text" name="cstms_cd" style="width:100%;" class="noinput1" value="" style="ime-mode:disabled" dataformat="uppernum" caption="Customs Code" maxlength="10" required fullfill ></td>
				</tr>
				<tr class="h23">
					<td class="tr2_head">Name</td>
					<td width="" class="input1" colspan="2"><input type="text" name="wh_nm" style="width:100%;" class="noinput1" value="" style="ime-mode:disabled" dataformat="etc" caption="Name" maxlength="500" required  ></td>
				</tr>
				<tr class="h23">
					<td class="tr2_head" width="100">Address</td>
					<td width="" class="input1" colspan="2"><input type="text" name="wh_addr" style="width:100%;" class="noinput1" value="" style="ime-mode:disabled" dataformat="etc"  caption="Address" maxlength="500" required></td>
				</tr>
				<tr class="h23">
					<td class="tr2_head" width="100">Location</td>
					<td width="100" class="noinput1"><input type="text" name="loc_cd" style="width:100%;" class="noinput1" value="" style="ime-mode:disabled" dataformat="engup" caption="Location" maxlength="5" required fullfill ></td>
					<td width="200" class="noinput2"><input type="text" name="loc_nm" style="width:100%;" class="noinput2" value="" readonly style="ime-mode:disabled" caption="Location Name" required  ></td>
				</tr>
				<tr class="h23">
					<td class="tr2_head" width="100">Contact Person</td>
					<td width="" colspan="2"><input type="text" name="pson_nm" style="width:100%;" class="noinput" value=""   caption="Contact Person" maxlength="50"></td>
				</tr>
				<tr class="h23">
					<td class="tr2_head" width="100">Tel</td>
					<td width="" colspan="2"><input type="text" name="phn_no" style="width:100%;" class="noinput" value="" style="ime-mode:disabled" caption="Tel" maxlength="20"></td>
				</tr>
				<tr class="h23">
					<td class="tr2_head" width="100">Fax</td>
					<td width="" colspan="2"><input type="text" name="fax_no" style="width:100%;" class="noinput" value="" style="ime-mode:disabled" caption="Fax" maxlength="20"></td>
				</tr>
				<tr class="h23">
					<td class="tr2_head" width="100">Remark(s)</td>
					<td width="" colspan="2"><input type="text" name="diff_rmk" style="width:100%;" class="noinput" value=""  caption="Remark" maxlength="4000"></td>
				</tr>
				</table>
				
			</td></tr>
		</table>
		
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
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
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_del">Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_inquiry">Inquiry</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
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