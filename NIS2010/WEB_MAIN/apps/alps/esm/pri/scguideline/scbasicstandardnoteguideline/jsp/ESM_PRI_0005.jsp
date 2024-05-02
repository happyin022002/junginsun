<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_pri_0005.jsp
*@FileTitle : Standard Note Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.16
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.04.16 이승준
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.scguideline.scbasicstandardnoteguideline.event.EsmPri0005Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri0005Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SCGuideline.SCBasicStandardNoteGuideline");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmPri0005Event)request.getAttribute("Event");
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
<title>Standard Note Creation</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input name="note_hdr_seq" type="hidden" value="">
<input name="note_seq" type="hidden" value="">
<input name="cd" type="hidden" value="">

<!-- seleted year -->
<input type="hidden" name="note_ref_yr_hidden" value="">
<!-- svc_scp_cd -->
<input type="hidden" name="svc_scp_cd_hidden" value="">
<!-- seleted Duration -->
<input type="hidden" name="eff_dt_hidden" value="">
<input type="hidden" name="exp_dt_hidden" value="">
<!-- seleted note nm -->
<input type="hidden" name="note_nm_hidden" value="">
<!-- cust type nm -->
<input type="hidden" name="prc_cust_tp_cd_hidden" value="">
<!-- note_nm -->
<input type="hidden" name="note_nm" value="">


<!-- copy 시 기존 조회 조건 키값 저장용 -->
<input type="hidden" name="svc_scp_cd_copy" value="">
<input type="hidden" name="prc_cust_tp_cd_copy" value="">
<input type="hidden" name="note_hdr_seq_copy" value="">

<!-- ett_dt_before -->
<input type="hidden" name="exp_dt_before" value="">
<!-- dt combo select 여부 -->
<input type="hidden" name="exp_dt_hidden_select" value="">

<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	
	<tr><td valign="top">
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
					
					<td width="30">Year</td>
					<td width="75"><input name="note_ref_yr" type="text" maxlength="4" style="width:35;text-align:center;"  value="" class="input1" onkeyup="javascript:searchDuration();"></td>
					<td width="90">Service Scope</td>			 	
					<td width="300"><script language="javascript"> ComComboObject('svc_scp_cd', 2, 50, 0, 1, 0, false);</script>
					&nbsp;<input name="svc_scp_nm" type="text" style="width:220;"  value="" class="input2" readonly></td>
					<td width="70">Duration</td>
					<td width="104"><script language="javascript">ComComboObject('gline_seq', 2, 90, 0, 1, 0, true);</script>&nbsp;~<input name="eff_dt" type="hidden" value="" class="input1"></td>
					<td width="79"><input name="exp_dt" type="text" style="width:75;text-align:center;"  value="" class="input1" caption="Expire Date" maxlength="10" dataformat="ymd" required></td>
					<td width="60" align="left"><img src="img/btns_calendar.gif" class="cursor" name="btns_calendar" valign="bottom"></td>
					<td width="">Confirmation&nbsp;&nbsp;<input name="cfm_flg" type="text" style="width:50;text-align:center;"  value="" class="input2" readOnly></td>
				</tr>
				<tr class="h23">
					<td width=""  colspan="2">Standard Note</td>
					<td width="" colspan="2"><script language="javascript">ComComboObject('note_nm_cd', 1, 364, 0, 1, 0, true);</script></td>
					<td width="">Cust. Type</td>
					<td colspan="6"><script language="javascript">ComComboObject('prc_cust_tp_cd', 2, 90, 0, 0, 0, false);</script>
					</td>																	
				</tr>	
				</table>
				<!--  biz_1   (E) -->
				
				<!-- Hidden sheet for Transaction (S) -->
				<script language="javascript">ComSheetObject('sheet0');</script>
				<!-- Hidden sheet for Transaction (E) -->
				
				
				<!--  biz_2  (S) -->
				
				<!-- Grid  (S) -->
							<table width="100%"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet1');</script>
									</td>
								</tr>
							</table> 
				<!-- Grid (E) -->
				
						<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_add">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_delete">Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr></table></td>
				</tr></table>
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
					<!-- Grid  (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table>
					
				<!-- Grid (E) -->

	<table width="100%" class="button"> 
	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_add2">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_delete2">Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
			</table>
			</td></tr>
			
	
	<!--biz page (E)-->
		</td></tr>
			</table>
	
	<!--Button (S) -->
		
			
		</td></tr>
</table>		
	
    <!--Button (E) -->
	</td></tr>
</table>
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
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_confirm">Confirm</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_cancel">Confirm&nbsp;Cancel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_delete3">Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_copy">Copy</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
				
		</td>				
			</tr>
			</table>
<!-- Copyright (S) -->
<!--<table class="copy">
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
--><!-- Copyright(E)-->

<div id="hiddenSheetLayer" style="display:none">
<script language="javascript">ComSheetObject('sheet3');</script>
</div>
</form>
</body>
</html>

<!-- 개발자 작업  끝 -->
