<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UI_TEST.jsp
*@FileTitle : TEST
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.07.23 김귀진
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
<%@ page import="com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.event.EsdPrd0003Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdPrd0003Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.RnllwsTest.Yardmanage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdPrd0003Event)request.getAttribute("Event");
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
<title>TEST</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
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
<input	type="hidden" name="f_cmd">

<!-- 개발자 작업	-->




<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
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
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>

						

						</tr></table>

				</td></tr>
		</table>

		<!-- TABLE '#D' : ( Button : Main ) (E) -->



		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<table class="search_in" border="0">
						<tr class="h23">

							<td width="60">Country</td>
							<td width="200">
								<input type="text" maxlength="2" name="country_code" required caption="Country" value="" style="width:37"  dataformat="engup"  >
								<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name="btn_cnt"></td>
							<td width="65">Location</td>
							<td width="220">
								<input type="text" maxlength=5; name="location_code" maxlength="5" value="" style="width:70"  dataformat="engup" >
								<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name="loc_btn"></td>
							<td width="35">Yard</td>
							<td>
								<input type="text" maxlength=7; name="node_code" maxlength="7" value="" style="width:70"  dataformat="engup" >
								</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Grid BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">
					<table class="height_10"><tr><td></td></tr></table>

					<!-- Grid : Week (S) -->
					<!-- 'HEAD1-BGCOLOR : 192 235 163' , 'HEAD2-BGCOLOR : 231 250 249' , 'BORDER : 90 138 158' , 'HEAD1-FONT : 0 83 116' , 'DATA GRID BG (2 colors) : 255 255 255, 249 249 249 ' -->
                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script type="text/javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
                    </table>
					<!-- Grid : Week (E) --></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->

		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">

					<table class="height_10"><tr><td></td></tr></table>
					<!-- TABLE '#D' : ( Table :Basic Information ) (S) -->
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="13%" rowspan="10">Basic Information</td>
							<td width="8%" class="stm">Yard Code</td>
							<td width="28%"><input name="yard_code" type="text" style="width:200" value=""  class="input2" readonly ></td>
							<td width="20%" rowspan="10">Lease Company Information</td>
							<td width="9%" class="stm">Lease Com1</td>
							<td><input name="com_code1" type="text" style="width:70" value=""  class="input2" readonly >&nbsp;<input name="com_name1" type="text" style="width:130" value=""  class="input2" readonly ></td>
						</tr>
						<tr class="h23">
							<td class="stm">Yard Name</td>
							<td><input name="yard_name" type="text" style="width:200" value=""  class="input2" readonly ></td>
							<td class="stm">Lease Com2</td>
							<td><input name="com_code2" type="text" style="width:70" value=""  class="input2" readonly >&nbsp;<input name="com_name2" type="text" style="width:130" value=""  class="input2" readonly ></td>
						</tr>
						<tr class="h23">
							<td class="stm">Address</td>
							<td><input name="address" type="text" style="width:200" value=""  class="input2" readonly ></td>
							<td class="stm">Lease Com3</td>
							<td><input name="com_code3" type="text" style="width:70" value=""  class="input2" readonly >&nbsp;<input name="com_name3" type="text" style="width:130" value=""  class="input2" readonly ></td>
						</tr>
						<tr class="h23">
							<td class="stm">PIC</td>
							<td><input name="pic" type="text" style="width:200" value=""  class="input2" readonly ></td>
							<td class="stm">Lease Com4</td>
							<td><input name="com_code4" type="text" style="width:70" value=""  class="input2" readonly >&nbsp;<input name="com_name4" type="text" style="width:130" value=""  class="input2" readonly ></td>
						</tr>
						<tr class="h23">
							<td class="stm">TEL</td>
							<td><input name="tel" type="text" style="width:200" value=""  class="input2" readonly ></td>
							<td class="stm">Lease Com5</td>
							<td><input name="com_code5" type="text" style="width:70" value="" class="input2" readonly >&nbsp;<input name="com_name5" type="text" style="width:130" value=""  class="input2" readonly ></td>
						</tr>
						<tr class="h23">
							<td class="stm">FAX</td>
							<td><input name="fax" type="text" style="width:200" value=""  class="input2" readonly ></td>
							<td class="stm">Lease Com6</td>
							<td><input name="com_code6" type="text" style="width:70" value="" class="input2" readonly >&nbsp;<input name="com_name6" type="text" style="width:130" value=""  class="input2" readonly ></td>
						</tr>
						<tr class="h23">
							<td class="stm">E-mail</td>
							<td><input name="e_mail" type="text" style="width:200" value=""  class="input2" readonly ></td>
							<td class="stm">Lease Com7</td>
							<td><input name="com_code7" type="text" style="width:70" value="" class="input2" readonly >&nbsp;<input name="com_name7" type="text" style="width:130" value=""  class="input2" readonly ></td>
						</tr>
						<tr class="h23">
							<td class="stm"></td>
							<td></td>
							<td class="stm">Lease Com8</td>
							<td><input name="com_code8" type="text" style="width:70" value="" class="input2" readonly >&nbsp;<input name="com_name8" type="text" style="width:130" value=""  class="input2" readonly ></td>
						</tr>
						<tr class="h23">
							<td class="stm"></td>
							<td></td>
							<td class="stm">Lease Com9</td>
							<td><input name="com_code9" type="text" style="width:70" value="" class="input2" readonly >&nbsp;<input name="com_name9" type="text" style="width:130" value=""  class="input2" readonly ></td>
						</tr>
						<tr class="h23">
							<td class="stm"></td>
							<td></td>
							<td class="stm">Lease Com10</td>
							<td><input name="com_code10" type="text" style="width:70" value="" class="input2" readonly >&nbsp;<input name="com_name10" type="text" style="width:130" value=""  class="input2" readonly ></td>
						</tr>
					</table>

			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->




	

    </td></tr>
</table>
<!-- Outer Table (E)-->
</form>











<!-- 개발자 작업  끝 -->
</body>
</html>