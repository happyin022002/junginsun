<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0010.jsp
*@FileTitle : Standard Note Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.10.16 최성민
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.scguideline.scbasicstandardnoteguideline.event.EsmPri0010Event"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri0010Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String[] prcCustTpCd = null;	//CUSTOMER TYPE
	String[] svcScpCd = null;		//SERVICE SCOPE
	
	Logger log = Logger.getLogger("com.hanjin.apps.SCGuideline.SCBasicStandardNoteGuideline");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmPri0010Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		//COMMBO LIST
		prcCustTpCd		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PRC_CUST_TP_CD"));
		svcScpCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("SVC_SCP_CD"));
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Standard Note Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	var prcCustTpCdComboValue = "<%=prcCustTpCd[0]%>";
    var prcCustTpCdComboText = "<%=prcCustTpCd[1]%>";
    
	var svcScpCdComboValue = "<%=svcScpCd[0]%>";
    var svcScpCdComboText = "<%=svcScpCd[1]%>";
    
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
				
				<table class="search" style="width:979;"> 
				<tr class="h23">
					
					<td width="30">Year</td>
					<td width="75"><input name="note_ref_yr" type="text" maxlength="4" style="width:35;"  value="" class="input1" onkeyup="javascript:searchDuration();"></td>
					<td width="90">Service Scope</td>			 	
					<td width="330"><script language="javascript"> ComComboObject('svc_scp_cd', 2, 50, 0, 1, 0, false);</script>
					&nbsp;<input name="svc_scp_nm" type="text" style="width:240;"  value="" class="input2" readonly="true"></td>
					<td width="75">Duration</td>
					<td width="240">
					<table class="search" width="100%"> 
					<tr><td width="185">
					<script language="javascript">ComComboObject('gline_seq', 2, 90, 0, 1, 0, true);</script>&nbsp;~<input name="eff_dt" type="hidden" value="" class="input1">
					<input name="exp_dt" type="text" style="width:75;"  value="" class="input1" 
					caption="Expire Date" maxlength="10" dataformat="ymd" required="true" OnFocus="setExpDtBefore();" OnBlur="setNoteNmCd();"></td>
					<td align="left">
					<img src="img/btns_calendar.gif" class="cursor" name="btns_calendar">
					</td>
					</tr>
					</table>
					</td>
					<td width="">&nbsp;</td>
				</tr>
				<tr class="h23">
					<td width=""  colspan="2">Standard Note</td>
					<td width="" colspan="2"><script language="javascript">ComComboObject('note_nm_cd', 1, 384, 0, 1, 0, true);</script></td>
					<td width="">Cust. Type</td>
					<td colspan="2"><script language="javascript">ComComboObject('prc_cust_tp_cd', 2, 90, 0, 0, 0, false);</script>
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
			
				<!--  biz_2   (E) -->
				<table class="line_bluedot"><tr><td></td></tr></table>
			
					<!-- Grid  (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table>
					
				<!-- Grid (E) -->
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
					<td class="btn1" name="btn_retrieve">Retrieve</td>
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
</form>
</body>
</html>

<!-- 개발자 작업  끝 -->
