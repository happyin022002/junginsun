<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0014.jsp
*@FileTitle : Coastal SKD Creation by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.15
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.01 Jung Jinwoo
* 1.0 Creation
*
* History
* 2011.04.15 진마리아 padding-right 설정
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0014Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0014Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.VSKCommon.VSKCodeFinder");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (VopVsk0014Event)request.getAttribute("Event");
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
<title>Port Code Inquiry</title>
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
<input type="hidden" name="loc_cd">
<input type="hidden" name="vps_port_cd">
<input type="hidden" name="clpt_seq">
<input type="hidden" name="vps_etb_dt">
<input type="hidden" name="vsl_svc_tp_cd">
<input type="hidden" name="vsl_slan_dir_cd">
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img name="btn_main_history" src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img name="btn_main_title" src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->
	
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="30">VVD</td>   
					<td width="180"><input type="text" name="vsl_cd" style="width:45;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="4" onfocus="this.select();">&nbsp;<input type="text" name="skd_voy_no" style="width:45;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="4" onfocus="this.select();">&nbsp;<input type="text" name="skd_dir_cd" style="width:20;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="1" onfocus="this.select();">&nbsp;<img class="cursor" name="btn_vvd_search" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="70">Lane Code</td>   
					<td width="110"><input type="text" name="vsl_slan_cd" style="width:45;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="3" onfocus="this.select();">&nbsp;<img class="cursor" name="btn_vsl_slan_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="90">P/F SKD Type</td>   
					<td width="220"><script language="javascript">ComComboObject('pf_svc_tp_cd',2,70,1,0);</script></td>
					<td width="90">Created Date</td>
					<td width=""><input type="text" name="cre_dt" style="width:110;"  class="input2" value="" readonly="readonly">&nbsp;<input type="text" name="cre_usr_id" style="width:70;" class="input2" value="" readonly="readonly"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
					<td width="700"> </td> 
					<td width="90">Updated Date</td>
					<td width=""><input type="text" name="upd_dt" style="width:110;" class="input2"  value="" readonly="readonly">&nbsp;<input type="text" name="upd_usr_id" style="width:70;" class="input2" value="" readonly="readonly"></td>	
					</tr>	
				</table>
				
				<table class="height_5"><tr><td></td></tr></table>
				
				<table class="grid2" border="0" style="width:979;"> 
						<tr class="h23">
							<td class="tr2_head" width="100">Remark(s)</td>
							<td width=""><textarea style="ime-mode:disabled;" name="skd_rmk" id="skd_rmk" style="width:100%;height:50;"></textarea></td></tr>	
				</table>
			</td>
		</tr>	
	</table>
	<!--  biz_1   (E) -->
					
	<table class="height_8"><tr><td></td></tr></table>
		
		
	<table class="search"> 
    <tr>
    	<td class="bg">
			<!--  grid  (S) -->
			<table width="100%" id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>				
			<!--  grid   (E) -->
			
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_add">Row&nbsp;Add</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_insert">Row Insert</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_del">Row Delete</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
				</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			<!--biz page (E)-->
		</td>
	</tr>
	</table>
	
	
	<!--Button (S) -->
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
      	<tr><td class="btn1_bg">
	    <table border="0" cellpadding="0" cellspacing="0">
	    <tr><td>
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
				<td class="btn1_right"></td>
				</tr>
			</table>
			</td>
			<td>
				<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_new">New</td>
				<td class="btn1_right"></td>
				</tr>
			</table></td>
			<td class="btn1_line"></td>
			<td>
				<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_save">Save</td>
				<td class="btn1_right"></td>
				</tr>
			</table></td>
			<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_pfsked">P/F SKD Use</td>
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
