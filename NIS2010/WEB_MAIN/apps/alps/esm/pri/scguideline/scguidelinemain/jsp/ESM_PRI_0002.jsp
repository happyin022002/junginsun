<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0002.jsp
*@FileTitle : Guideline Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.09.30 박성수
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.event.EsmPri0002Event"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeUtil"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri0002Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SCGuideline.SCGuidelineMain");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmPri0002Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	log.debug(serverException);
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title>Guideline Inquiry</title>
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
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">

<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<!--td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td-->
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
                
				<table class="search" border="0" width="100%">
				<tr class="h23">
					<td width="90">Service Scope</td>
					<td width="360" style="padding-left:2px;"><script language="javascript">ComComboObject("svc_scp_cd", 2, 50, 0, 1, 0, false);</script>&nbsp;<input name="svc_scp_nm" type="text" style="width:270;"  value="" class="input2" readonly caption="Service Scope"></td>
					<td width="57">Duration</td>
					<td width="260" style="padding-left:2px;">
					<script language="javascript">ComComboObject("gline_seq", 3, 90, 1, 1, 2, true);</script>
					&nbsp;~&nbsp;<input name="eff_dt" type="hidden" value="" class="input1" caption="Effective Date" required>
					<input name="eff_dt_hidden" type="hidden" value="" class="input1"><input name="exp_dt" type="text" style="width:75;" readonly value="" class="input1" caption="Expire Date" maxlength="10" dataformat="ymd" required>
					<!--img src="img/btns_calendar.gif" class="cursor" name="btns_calendar" width="19" height="20" alt="" border="0" align="absmiddle" --></td>

					<td width="70">Confirmation</td>
					<td width=""><input name="cfm_flg" type="text" style="width:58;"  value="" class="input2" readonly caption="Confirmation"></td></tr>

				<tr class="h23">
					<td width="">Creation Date</td>
					<td width=""><input name="cre_dt" type="text" style="width:77;"  value="" class="input2" readonly caption="Creation Date"></td>
					<td width="">Staff</td>
					<td width=""><input name="cre_usr_nm" type="text" style="width:110;"  value="" class="input2" readonly caption="Staff"></td>
					<td width="">Team</td>
					<td width=""><input name="cre_ofc_cd" type="text" style="width:58;"  value="" class="input2" readonly caption="Team"></td></tr>

				</table>
				<!--  biz_1   (E) -->
				</td></tr>
			</table>
				
			<table class="height_8"><tr><td></td></tr></table>
			
			<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
						<!-- img src="/img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
					</td></tr>
				</table>
			<!-- Tab ) (E) -->
		
			<!-- iFrame (S) -->
            <div id="tabLayer" style="display:none">
            <iframe name="t1frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="425" src="about:blank"></iframe>
            </div>
            <div id="tabLayer" style="display:none">
            <iframe name="t2frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="425" src="about:blank"></iframe>
            </div>
            <div id="tabLayer" style="display:none">
            <iframe name="t3frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="425" src="about:blank"></iframe>
            </div>
            <div id="tabLayer" style="display:none">
            <iframe name="t4frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="425" src="about:blank"></iframe>
            </div>
            <div id="tabLayer" style="display:none">
            <iframe name="t5frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="650" src="about:blank"></iframe>
            </div>
            <div id="tabLayer" style="display:none">
            <iframe name="t6frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="425" src="about:blank"></iframe>
            </div>
            <div id="tabLayer" style="display:none">
            <iframe name="t7frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="425" src="about:blank"></iframe>
            </div>
            
			<!-- iFrame (E) -->
			
			<!-- Hidden sheet for Transaction (S) -->
			<script language="javascript">ComSheetObject('sheet1');</script>
			<!-- Hidden sheet for Transaction (E) -->
				
	
		<table class="height_10"><tr><td colspan="8"></td></tr></table>
			
	</td></tr>
</table>
 
<!-- Copyright (S) 
<table class="copy">
<tr><td class="familysite">&nbsp;
		<select name="sitelink" id="sitelink" class="select_family" onChange="javascript:go_sitelink(this);">
       	<option selected>&nbsp;&nbsp;  -- Family Site --  &nbsp;&nbsp;</option>
		<option value=""></option>
		<option value=""></option>
		<option value=""></option>
   		</select>
	</td>
	<td class="copy"><img src="img/img_bottom_logo.gif" width="460" height="16" alt="" border="0"></td></tr>
</table>
-->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>