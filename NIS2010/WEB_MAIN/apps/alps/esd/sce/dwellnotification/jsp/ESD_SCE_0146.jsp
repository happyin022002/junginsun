<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0146.jsp
*@FileTitle : Microsoft Exception Management
*Open Issues :
*@LastModifyDate : 2016-02-01
*@LastModifier : Poong Yeon CHO, Min Jung KIM
*@LastVersion : 1.0
* 2015-09-23 Poong Yeon CHO, Min Jung KIM
* 1.0 최초 생성
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0146Event" %>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBCImpl" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsdSce0146Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	String strUsr_id		= "";
	
	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		event = (EsdSce0146Event)request.getAttribute("Event");
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
<title>Microsoft Exception Management</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
	<%=JSPUtil.getIBCodeCombo("ms_dwll_rsn_cd", "01", "CD03456", 0, "")%> 
</script>
</head>

<body onLoad="setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="usr_id" value = "<%= strUsr_id %>">
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
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_loadexcel" id="btn_loadexcel">Upload Excel</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>	
							<!-- Repeat Pattern -->

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
							<td width="109">Customer</td>
							<td width="" colspan="10">
							<input class="input1" name="cs_grp_id" type="text"  class="input" style="width:80; text-transform:uppercase;" value="COM02879" onfocusin="javascrpt:onbuttondisable()"  onblur="javascript:onObjectFocusout1(this.form)" disabled="disabled">
							<input class="input1" name="tp_id" type="text"  class="input" style="width:120; text-transform:uppercase;" value="RBTW" disabled="disabled">
							<input class="input1" name="grp_nm" type="text"  class="input" style="width:560; text-transform:uppercase;" value="MICROSOFT (TMC)" disabled="disabled">
							<img onClick="openCustomer()" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" disabled="disabled">
							</td>
						</tr>
					</table>
					<table class="search_in" border="0">
					<tr class="h23">
							<td width="80">POD</td>
							<td width="160"><input name="pod_cd_" type="text" class="input" style="width:70; text-transform:uppercase;"  value=""> <img onClick="openLocPop(false,'pod_cd_')" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
							<td width="81">DEL</td>
							<td width="160"><input name="del_cd_" type="text" class="input" style="width:70; text-transform:uppercase;"  value=""> <img onClick="openLocPop(false,'del_cd_')" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
							<td width="80">VVD</td>
							<td width="160"><input name="vvd_" type="text" class="input" style="width:92; text-transform:uppercase;"  value="" > <img onClick="openVVDList()" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
							<img onClick="openAddPaste('vvd_')" class="cursor" src="/hanjin/img/button/btng_plus.gif" width="19" height="20" border="0" align="absmiddle"></td>
					</tr>
					</table>
	
					<table class="search_in" border="0">
					<tr class="h23">
							<td width="80">B/L NO.</td>
							<td width="160">
							<input name="bl_no_" type="text" class="input" style="width:100; text-transform:uppercase;"  value="">
							<img onClick="openAddPaste('bl_no_')" class="cursor" src="/hanjin/img/button/btng_plus.gif" width="19" height="20" border="0" align="absmiddle"></td>
							<td width="81">CNTR NO.</td>
						  	<td width="160">
							<input name="cntr_no_" type="text" style="width:100px ; text-transform:uppercase;" value="" >
							<img onClick="openAddPaste('cntr_no_')" class="cursor" src="/hanjin/img/button/btng_plus.gif" width="19" height="20" border="0" align="absmiddle"></td>
							<td width="80">Sent</td>
							<td width="160">
							<select name="snt_flg_" class="input" style="width:80;">
								<option value="A">ALL</option>
								<option value="Y">Yes</option>
								<option value="N">No</option>
							</select>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
		
		<table class="height_10"><tr><td></td></tr></table>
		
		
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">

				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<!-- Repeat Pattern -->

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save" alt="">Save</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_send" id="btn_send" alt="">Send</td><td class="btn1_right"></td></tr></table></td>	

							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>

		<!-- TABLE '#D' : ( Grid BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">
				
				<!-- Grid : Week (S) -->
					<!-- 'HEAD1-BGCOLOR : 192 235 163' , 'HEAD2-BGCOLOR : 231 250 249' , 'BORDER : 90 138 158' , 'HEAD1-FONT : 0 83 116' , 'DATA GRID BG (2 colors) : 255 255 255, 249 249 249 ' -->
					<table width="100%" id="mainTable">
				       <tr><td>
					   <script language="javascript">ComSheetObject('sheet1');</script>
					   </td></tr>
					   <tr>
                    		<td align="right">
                    			<input name="ckCount" type="text" class="noinput1" style="width:30;" readonly > rows selected
                    		</td>
                    	</tr>
					</table>
					<!-- Grid : Week (E) -->
			    </td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->

    </td></tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>
