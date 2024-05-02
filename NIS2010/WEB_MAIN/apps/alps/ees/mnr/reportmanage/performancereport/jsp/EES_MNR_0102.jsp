<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0102.jsp
*@FileTitle : Total Loss Performance
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.10.06 민정호
* 1.0 Creation
* --------------------------------------------------------
* 2012.02.27 신혜정 [CHM-201216419] 검색 조건 Payer Type, Payer Code 추가, 그리드 Payer Type 항목 추가
* 2012.04.23 신혜정 [CHM-201217368] 검색 조건 SCAC Code 추가, Payer Type 조건 삭제
* 2012.05.02 신혜정 [CHM-201217379] 검색 조건 buyer Code 추가 , 그리드 buyer name 항목 추가  
* 2013.02.13 조경완 [CHM-201322896-01] ALPS MNR-Total Loss Logic 검토 및 수정 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event.EesMnr0102Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0102Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ReportManage.PerformanceReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesMnr0102Event)request.getAttribute("Event");
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
<title><span id="title"></span></title>
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
<!-- 개발자 작업	-->
<input type="hidden" name="eq_kind">   
<input type="hidden" name="rhq">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="rsn_cd_all_flg">
<input type="hidden" name="close_tp_all_flg">   

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
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
	
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="50">EQ Kind</td>
					<td width="130">&nbsp;<script language="javascript">ComComboObject('combo_eq_kind',1, 102 , 1,1)</script></td>
					<td width="78">Regional HQ</td>
					<td width="215" colspan="2">&nbsp;<script language="javascript">ComComboObject('in_office_tp',1, 100 , 1,1)</script>&nbsp<script language="javascript">ComComboObject('combo_rhq',2, 102 , 0,1);</script></td>
					<td width="85">&nbsp;<script language="javascript">ComComboObject('combo_office',2, 80 , 0,1,'',0,'');</script></td>
					<td width="90"><script language="javascript">ComComboObject('in_search_dt_tp',1, 120 , 1,1)</script></td>
					<td width="">&nbsp;<input type="text" style="width:75;" class="input1" name="fm_dt" dataformat="ymd" maxlength="8" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">&nbsp;~
						<input type="text" style="width:75;" class="input1" name="to_dt" dataformat="ymd" maxlength="8" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="cre_dt_cal">
						&nbsp;										
						<input type="text" style="width:30;" class="input" name="in_days" dataformat="int" maxlength="3"> Days
					</td>					
				</tr> 				
				<tr class="h23"> 
					<td width="50">EQ No.</td>
					<td width="130">&nbsp;<input type="text" name="eq_no" style="width:100;" class="input" dataformat="engup">&nbsp;<img src="img/btns_multisearch.gif" name="eq_no_multi"width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					</td>
					<td width="78">Total&nbsp;Loss&nbsp;No.</td>
					<td width="135">&nbsp;<input type="text" name="total_loss_no" style="width:100;" class="input" dataformat="engup">&nbsp;<img src="img/btns_multisearch.gif" name="tln_multi"width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					</td>
					<td width="80">Main Reason</td>
					<td width="90">&nbsp;<script language="javascript">ComComboObject('rsn_cd', 1, 100, 1, 0);</script>
					</td>		
					<td width="80">Sub Reason</td>	 
					<td>&nbsp;<script language="javascript">ComComboObject('ttl_lss_dtl_rsn_cd', 1, 100, 1, 0);</script></td>	
				</tr> 
				<tr class="h23">
					<td>Status</td>   	
					<td>&nbsp;<script language="javascript">ComComboObject('in_status_tp',1, 100 , 1,0)</script></td>
					<td>Close Type</td>	
					<td style="padding-left:4px;" align=left><script language="javascript">ComComboObject('ttl_lss_cmpl_cd',1, 80 , 1,0)</script></td>
					<td >Lessor</td>		 	
					<td colspan=3  width="346"><input type="text" name="vndr_seq" caption="Service Provider" style="width:55;text-align:left;" class="input" value="" dataformat="engup" maxlength="6">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_vndr" width="19" height="20" border="0" align="absmiddle">&nbsp;<input type="text" name="vndr_nm" caption="Lessor" style="width:241;" class="input2" value="" readonly></td>		
				</tr>
				<tr class="h23">
					<td>SCAC Code</td>
					<td>&nbsp;<input type="text" name="usa_edi_cd" style="width:100;" class="input" dataformat="engup">&nbsp;<img src="img/btns_multisearch.gif" name="usa_edi_cd_multi"width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					</td>					
					<td >Payer Code</td>		 	
					<td colspan=3><input type="text" name="payer_code" caption="Service Provider" style="width:55;text-align:left;" class="input" value="" dataformat="engup" maxlength="6">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_payer" width="19" height="20" border="0" align="absmiddle">&nbsp;<input type="text" name="payer_nm" caption="Lessor" style="width:210;" class="input2" value="" readonly></td>						
					<td >Buyer Code</td>		 	
					<td ><input type="text" name="buyer_code" caption="Service Provider" style="width:55;text-align:left;" class="input" value="" dataformat="engup" maxlength="6">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_buyer" width="19" height="20" border="0" align="absmiddle">&nbsp;<input type="text" name="buyer_nm" caption="Lessor" style="width:190;" class="input2" value="" readonly></td>					
				</tr>					 	
				</table>				
				
				<!--  biz_1   (E) -->
			
		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>	
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	

			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->	
			
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_Excel">Down Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_Detail">Detail</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>					
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->	
			
			</td></tr>
		</table>
		<!--biz page (E)-->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>