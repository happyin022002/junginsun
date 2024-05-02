<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0107.jsp
*@FileTitle : Budget VSL SKD Inquiry by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.11
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.02.10 진마리아
* 1.0 Creation
*
* History
* 2011.02.22 진마리아 CHM-201108456-01 사업계획용 스케줄 정보 노출 대응을 위한 시스템 업데이트건
* 2011.04.11 진마리아 CHM-201109577-01 Delete Vessel Code에 대한 조회 로직 보완
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.budget.vesselschedulemgt.event.VopVsk0107Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0107Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.Budget.VesselScheduleMgt");
	
	//Pop-up 으로 넘어 왔을때 필요한 parameter
	String popMode 		= "";
	String sVslCd 		= "";
	String sSkdVoyNo 	= "";
	String sSkdDirCd 	= "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (VopVsk0107Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		//Pop-up 으로 넘어 왔을때 필요한 parameter setting
		popMode		= JSPUtil.replaceForHTML(request.getParameter("pop_mode")) == null ? "N" : "Y";
		sVslCd		= JSPUtil.replaceForHTML(request.getParameter("vsl_cd")) == null ? "" : JSPUtil.replaceForHTML(request.getParameter("vsl_cd"));
		sSkdVoyNo	= JSPUtil.replaceForHTML(request.getParameter("skd_voy_no")) == null ? "" : JSPUtil.replaceForHTML(request.getParameter("skd_voy_no"));
		sSkdDirCd	= JSPUtil.replaceForHTML(request.getParameter("skd_dir_cd")) == null ? "" : JSPUtil.replaceForHTML(request.getParameter("skd_dir_cd"));
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Budget VSL SKD Inquiry by VVD</title>
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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="pop_mode" value="<%=popMode %>">
<!-- RD -->
<input type="hidden" name="com_mrdPath" value="">
<input type="hidden" name="com_mrdArguments" value="">
<input type="hidden" name="com_mrdBodyTitle" value="">   
<input type="hidden" name="com_mrdSaveDialogFileExt" value="ppt">
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@doc@ppt">
<input type="hidden" name="com_mrdSaveDialogFileName" value="">
<input type="hidden" name="com_mrdSaveDialogDir" value="c:\users\">
<input type="hidden" name="com_mrdTitle" value="">
<input type="hidden" name="inc_del_vsl" value="Y">
<!-- 개발자 작업	-->

<table id="top_table" width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;" class="">
	<tr id="top_tr"><td id="top_td"></td></tr>
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<div id="main_title">
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	</div>
	<!--Page Title, Historical (E)-->
	
	
	<!--biz page (S)-->
	<table class="search"> 
      	<tr><td class="bg">
			<!--  biz_1  (S) -->
			
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="70" rowspan="">VVD</td>   
				<td width="220"><input type="text" name="vsl_cd" style="width:40;text-align:center;ime-mode:disabled;" class="input1" value="<%=sVslCd %>" maxlength="4" onfocus="this.select();">&nbsp;<input type="text" name="skd_voy_no" style="width:40;text-align:center;ime-mode:disabled;" class="input1" value="<%=sSkdVoyNo %>" maxlength="4" onfocus="this.select();">&nbsp;<input type="text" name="skd_dir_cd" style="width:25;text-align:center;ime-mode:disabled;" class="input1" value="<%=sSkdDirCd %>" maxlength="1" onfocus="this.select();">&nbsp;<%if("N".equals(popMode)){ %><img class="cursor" name="btn_vvd_search" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"><%} %></td>
				<td width="80">Lane Code</td>
				<td width="280"><input type="text" name="vsl_slan_cd" style="width:40;text-align:center;" class="input2" value="" readonly="readonly"></td>
				<td width="90">Created Date</td>
				<td align="right"><input type="text" name="cre_dt" style="width:110;text-align:center;" class="input2" value="" readonly="readonly">
								  <input type="text" name="cre_usr_id" style="width:110;" class="input2" value="" readonly="readonly"></td>
			</tr>
			<tr class="h23">
				<td></td>   
				<td></td>
				<td></td>
				<td></td>
				<td>Updated Date</td>
				<td align="right"><input type="text" name="upd_dt" style="width:110;text-align:center;" class="input2" value="" readonly="readonly">
								  <input type="text" name="upd_usr_id" style="width:110;" class="input2" value="" readonly="readonly"></td>
			</tr>
			<tr class="h23">
				<td width="70" valign="top">Remark(s)</td>   
				<td width="" colspan="5" align="center"><textarea name="skd_rmk" id="skd_rmk" style="width:99%;height:50;" class="textarea2" readonly="readonly"></textarea></td>
			</tr>
			</table>
		</td></tr>	
	</table>
			<!--  biz_1   (E) -->
	<table class="height_8"><tr><td></td></tr></table>
	<!-- Tab ) (S) -->
	
	<table class="search"> 
      	<tr><td class="bg">
    	
	<!--  biz_2  (S) -->
			
			<!-- Grid  (S) -->
			<table width="100%" id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->
					
	<!--  biz_2   (E) -->
			
			
	</td></tr>
	</table>
	
	<!--biz page (E)-->
	
	
	<!--Button (S) -->
	<div id="main_layer" style="display:none">
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
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<!-- <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_test">Test</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td> -->
			</tr>
			</table>
		</td></tr>
	</table>
	</div>
    <!--Button (E) -->
</td></tr>
</table>


<!-- : ( Button : pop ) (S) -->
<div id="pop_layer" style="display:none">
<table width="100%" class="sbutton">
	<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
   		    	<%if("N".equals(popMode)){ %>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve_pop" id="btn_retrieve_pop">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<%} %>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
					<td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<!-- <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_test_pop">Test</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td> -->
			</tr>
			</table></td>
		</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
</div>
<!-- : ( Button : pop ) (E) -->


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
