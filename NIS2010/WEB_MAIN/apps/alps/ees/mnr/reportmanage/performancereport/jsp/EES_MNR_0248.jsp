<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EES_MNR_0248.jsp
*@FileTitle : M&R PFMC by EqNo
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.10
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2011.02.10 김영오
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
<%@ page import="com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event.EesMnr0248Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0248Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.ReportManage.PerformanceReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EesMnr0248Event)request.getAttribute("Event");
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
	<input type="hidden" name="user_ofc_cd" value="<%=strOfc_cd%>"> 
	<input type="hidden" name="curr_cd">
<input type="hidden" name="backendjob_key">
	<!-- 개발자 작업	-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
		<tr>
			<td valign="top">
				<!--Page Title, Historical (S)-->
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
					<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
					<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
				</table>
				<!--Page Title, Historical (E)-->
			
				<!--Button (S) -->
				<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
		       	<tr>
			       	<td class="btn1_bg">
					    <table border="0" cellpadding="0" cellspacing="0">
					    	<tr>
						    	<td>
							    	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_New">New</td>
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
				
				<!--biz page (S)-->
				<table class="search" id="mainTable"> 
		       		<tr>
			       		<td class="bg">	
							<!--  biz_1  (S) -->		
							<table class="search" border="0" style="width:979;"> 
								<tr class="h23">
									<td width="90">Period</td>
									<td width="360">&nbsp;<script language="javascript">ComComboObject('report_period_type',2, 100 , 1,1)</script>						
										&nbsp;<input required type="text" name="fm_dt" dataformat="ymd"    caption="from date"        maxlength="8"  size="10"  cofield="to_dt" value="">   
				                              	~ <input required type="text" name="to_dt" dataformat="ymd"    caption="to date"        maxlength="8"  size="10"  cofield="fm_dt">&nbsp;<img name="btn_calendar" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
									</td>		
									<td width="60">EQ Type</td>
									<td width="140">&nbsp;<script language="javascript">ComComboObject('eq_type',2, 110, 1, 0, 2,false,1);</script></td>
									<td width="50">TP/SZ</td>
									<td width="130">&nbsp;<script language="javascript">ComComboObject('tp_sz_cd', 2, 100 ,0);</script></td>
									<td>USD Only&nbsp;<input name="check_usd_only" type="checkbox" class="trans"></td>				
								</tr>							 	
							</table>	 	
							<table class="search" border="0" style="width:979;"> 
								<tr class="h23"> 
									<td width="90">Regional HQ</td>
									<td width="110">&nbsp;<script language="javascript">ComComboObject('rhq',2, 100, 0, 0);</script></td>
									<td width="100">EQ Term</td>
									<td width="150">&nbsp;<script language="javascript">ComComboObject('lstm_cd',1, 140,0);</script></td>
									<td width="160">Service Provider</td>	
									<td width="369"><input type="text" name="vndr_seq" caption="Service Provider" style="width:57;text-align:left;" class="input" value="" dataformat="engup" maxlength="6">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_provider_popup" width="19" height="20" border="0" align="absmiddle">&nbsp;<input type="text" name="vndr_lgl_eng_nm" caption="Service Provider" style="width:276;" class="input2" value="" readonly></td>
								</tr> 
								<tr class="h23">	 
									<td>Account Code</td>			 	
									<td>&nbsp;<script language="javascript">ComComboObject('acct_cd', 2, 100, 1, 0,0,false,4);</script></td>		
									<td>Manufacturer</td>
									<td>&nbsp;<script language="javascript">ComComboObject('manu_vndr_seq', 1, 140 ,0, 0,'',0,'');</script></td>
									<td>EQ Manufacturing Period</td>
									<td>					
										<input type="text" style="width:70;" class="input" name="from_date" dataformat="ymd" maxlength="8">&nbsp;~
										<input type="text" style="width:70;" class="input" name="to_date" dataformat="ymd" maxlength="8">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="cre_dt_cal">
									</td>
								</tr>
								<tr class="h23">	
									<td>Office</td>
									<td>&nbsp<script language="javascript">ComComboObject('ofc_cd',2, 100 ,0, 0,'',0,'');</script></td>
									<td>RF Unit Maker</td>
									<td>&nbsp;<script language="javascript">ComComboObject('unit_vndr_seq', 1, 140 ,0, 0,'',0,'');</script></td>
									<td colspan="2">
										<table class="search" border="0" style="width:100%;"> 
										<tr  class="h23">
											<td width="50">EQ No.</td>		 		 		
											<td width="170"><input type="text" name="eq_list" style="width:140;" class="input" dataformat="engup">&nbsp;<img src="img/btns_multisearch.gif" name="eq_no_multi" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
											<td width="20">&nbsp;</td>
											<td width="80">Verify Result</td>
									        <td width="">&nbsp;<script language="javascript">ComComboObject('verify_result', 2, 200 ,0);</script></td>
										</tr>
										</table>
									</td>
								</tr>
							</table>
							<!--  biz_1   (E) -->
						</td>
					</tr>
				</table>
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
			       		<tr>
				       		<td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn2_left"></td>
												<td class="btn2" name="btn_DownExcel">Down Excel</td>
												<td class="btn2_right"></td>
											</tr>
										</table>
									</td>						
								</tr>
							</table>
							</td>
						</tr>
					</table>
			    	<!-- Button_Sub (E) -->
								
					</td></tr>
				</table>
			</td>
		</tr>
	</table>
	<!--biz page (E)-->
	<!-- 개발자 작업  끝 -->
	</form>
</body>
</html>