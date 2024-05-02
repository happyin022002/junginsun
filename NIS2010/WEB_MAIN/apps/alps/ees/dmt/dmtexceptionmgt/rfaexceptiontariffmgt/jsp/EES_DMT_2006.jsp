<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_2006.jsp
*@FileTitle : DEM/DET Adjustment Request & Approval Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.08.03 이성훈
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.event.EesDmt2006Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt2006Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	 = "";
	String strUsr_nm	 = "";
	String strOfc_cd	 = "";
	String strRhq_ofc_cd = "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id 	  = account.getUsr_id();
		strUsr_nm 	  = account.getUsr_nm();
		strOfc_cd 	  = account.getOfc_cd();
		strRhq_ofc_cd = account.getRhq_ofc_cd();
	   
		event = (EesDmt2006Event)request.getAttribute("Event");
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
<title>DEM/DET Adjustment Request & Approval Status</title>
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
<!-- S/C 및 DAR 의 Request & Approval 현황조회를 위해서 사용되는 매개변수 -->
<input type="hidden" name="group_by">
<input type="hidden" name="dmdt_trf_cd">
<input type="hidden" name="type">
<input type="hidden" name="cond_tp">
<input type="hidden" name="tab_tp">
<input type="hidden" name="fm_dt">
<input type="hidden" name="to_dt">
<input type="hidden" name="sc_no">
<input type="hidden" name="rfa_no">
<input type="hidden" name="prop_no">
<input type="hidden" name="dar_no">
<input type="hidden" name="apvl_no">
<input type="hidden" name="bkg_no">
<input type="hidden" name="bl_no">
<input type="hidden" name="to_cc">
<input type="hidden" name="usr_id">
<input type="hidden" name="usr_ofc_cd">
<input type="hidden" name="usr_ofc_only">
<input type="hidden" name="usr_role_cd" value="DMT03">
<!-- 조회에 사용되는 실제 Office Code 값을 임시적으로 저장하기 위한 매개변수 -->
<input type="hidden" name="ofc_cd">
<input type="hidden" name="cust_cd">
<!-- Type 설정을 위해서 사용되는 매개변수 -->
<input type="hidden" name="login_usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="login_usr_nm" value="<%=strUsr_nm%>">
<input type="hidden" name="login_ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="login_rhqofc_cd" value="<%=strRhq_ofc_cd%>">
<!-- Customer Name 를 조회하기 위해서 사용되는 매개변수 -->
<input type="hidden" name="cust_seq">
<input type="hidden" name="cust_cnt_cd">

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
							<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
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
					<td class="btn1_line"></td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_Minimize">Minimize</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_Detail">Detail</td>
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
    	
	<div id="conditionLayer" style="display:block">	
		<table class="search"> 
       	<tr>
       		<td class="bg">
				<!--  biz_1  (S) -->
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="240">
						
						<table class="search_sm" border="0" style="width:220;"> 
						<tr class="h23">
							<td width="35">Type</td>
							<td class="stm"><input type="checkbox" name="searchType" class="trans" onClick="displayGridByType()">S/C&nbsp;&nbsp;&nbsp;<input type="checkbox" name="searchType" class="trans" onClick="displayGridByType()">Before&nbsp;&nbsp;&nbsp;<input type="checkbox" name="searchType" class="trans" onClick="displayGridByType()">After</td>
						</tr>
						</table>
					</td>
					<td width="60">Group by</td>
					<td width="110"><select style="width:90;" name="groupBy" class="input">
						<option value="DAR" selected>S/C & DAR</option>
						<option value="CVRG">Coverage </option>
					</select></td>
					<td width="70">Tariff Type</td>
					<td width="">&nbsp;<script language="javascript">ComComboObject('combo1', 2, 250, 0, 1)</script>&nbsp;<img src="img/btns_multisearch.gif"width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
				</tr>
				</table>
				<table class="height_2"><tr><td></td></tr></table>
				<table class="search_sm" border="0" style="width:979;"> 
				<tr class="h23">
					<td>
						<table class="search" border="0"> 
						<tr class="h23">
							<td width="70"><input type="radio" name="cond_type" value="date" class="trans">Date</td>
							<td width="50" class="stm">Update</td>
							<td width="284">
								<input type="text" name="updDtFm" style="width:80;" class="input1" dataformat="ymd" maxlength="8" readonly>&nbsp;~&nbsp;
								<input type="text" name="updDtTo" style="width:80;" class="input1" dataformat="ymd" maxlength="8" readonly>&nbsp;<img src="img/btns_calendar.gif" name="btns_calendar" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor">
							</td>
							<td width="50" class="stm">Office</td>
							<td width="90"><input type="text" name="office" style="width:50;" class="input" dataformat="engup"></td>
							<td width="50" class="stm">To/Cc</td>
							<td width="100"><select name="toCc" style="width:70;" class="input">
								<option value="" selected>All</option>
								<option value="to">To</option>
								<option value="cc">Cc</option>
							</select></td>
							<td width="120" class="stm"><input type="checkbox" name="userOfficeOnly" class="trans">User Office Only</td>
							<td width="" class="stm"><input type="checkbox" name="userOnly" class="trans" onClick="modifyToCc()">User Only</td>
							</tr>
						</table>
				
						<table class="search" border="0"> 
						<tr class="h23">
							<td width="70" rowspan="2" valign="top"><input type="radio" name="cond_type" value="dar" class="trans">DAR</td>
							<td width="50" class="stm">S/C No.</td>
							<td width="150"><input type="text" name="sCNo" style="width:120;ime-mode:disabled" class="input" dataformat="engup" maxlength="9"></td>
							<td width="50" class="stm">RFA No.</td>
							<td width="150" class="stm"><input name="rFANo" type="text" style="width:120;ime-mode:disabled" class="input" dataformat="engup" maxlength="11"></td>
							<td width="75" class="stm">Proposal No.</td>
							<td width="150" class="stm"><input name="proposalNo" type="text" style="width:110;ime-mode:disabled" class="input" dataformat="engup" maxlength="11"></td>
							<td width="50" class="stm"></td>
							<td width="" class="stm"></td>
						</tr>
						<tr class="h23">
							<td width="50" class="stm">DAR No.</td>
							<td width="150"><input type="text" name="darNo" style="width:120;ime-mode:disabled" class="input" dataformat="engup" maxlength="15"></td>
							<td width="60" class="stm">APVL No.</td>
							<td width="150" class="stm"><input name="approvalNo" type="text" style="width:120;ime-mode:disabled" class="input" dataformat="engup" maxlength="15"></td>
							<td width="50" class="stm">BKG No.</td>
							<td width="150" class="stm"><input name="bkgNo" type="text" style="width:110;ime-mode:disabled" class="input" dataformat="engup" maxlength="13"></td>
							<td width="50" class="stm">B/L No.</td>
							<td width="" class="stm"><input name="blNo" type="text" style="width:110;ime-mode:disabled" class="input" dataformat="engup" maxlength="12"></td>
						</tr>
						</table>
					</td>
					</tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="70">&nbsp;&nbsp;Customer</td>
						<td><input type="text" name="custCd" style="width:70;" class="input" dataformat="engup">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" onClick="openWinSearchCustomer('cust_cd')">&nbsp;<input type="text" name="custNm" style="width:705;" class="input2"></td>	
					</tr>
				</table>
			</td></tr>
		</table>
	</div>
			
		<!-- earch Options_Speed (E) --> 	
		<table class="height_8"><tr><td></td></tr></table>
		
		<!-- Tab ) (S) -->
     	<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       	<tr>
       		<td width="100%">
				<script language="javascript">ComTabObject('tab1')</script>
			</td>
		</tr>
		</table>
		<!-- Tab ) (E) --> 
		
	<!--TAB Received (S) -->
	<div id="tabLayer" style="display:block">		
		
		<!-- Tab BG Box ) (S) -->
		<table class="search"> 
       	<tr>
       		<td class="bg">
       	
   			<div id="receivedTabSCTariffLayer" style="display:block">	
				<table class="search" border="0">
				<tr class="h23">
					<td class="title_h"></td>
					<td class="title_s">S/C Exception Tariff</td>
					<td align="right">
						<table width="250" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn2_left"></td>
							<td class="btn2" name="t1btn_SCdownexcel">S/C Exception Tariff Down Excel</td>
							<td class="btn2_right"></td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
				<!-- Grid  (S) -->
				
				<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t1sheet1');</script>
					</td>
				</tr>
				</table> 				

				<!-- Grid  (e) -->
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			</div>
			
			<div id="receivedTabBeforeBookingLayer" style="display:block">
				<table class="search" border="0">
				<tr class="h23">
					<td class="title_h"></td>
					<td class="title_s">Before Booking DAR</td>
					<td align="right">
						<table width="210" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn2_left"></td>
							<td class="btn2" name="t1btn_Beforedownexcel">Before BKG DAR Down Excel</td>
							<td class="btn2_right"></td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
				<!-- Grid  (S) -->
				
				<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t1sheet2');</script>
					</td>
				</tr>
				</table> 				

				<!-- Grid  (e) -->
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			</div>
							
   			<div id="receivedTabAfterBookingLayer" style="display:block">								
				<table class="search" border="0">
				<tr class="h23">
					<td class="title_h"></td>
					<td class="title_s">After Booking DAR</td>
					<td align="right">
						<table width="210" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn2_left"></td>
							<td class="btn2" name="t1btn_Afterdownexcel">After BKG DAR Down Excel</td>
							<td class="btn2_right"></td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
				<!-- Grid  (S) -->
				
				<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t1sheet3');</script>
					</td>
				</tr>
				</table> 
			</div>
			
				<!-- Grid  (e) -->
			</td>
		</tr>
				
		</table>
		
<!-- : ( Search Options ) (E) -->
 
</div>
<!--TAB Received (E) --> 				
			
					

<!--TAB Sent (S) -->
<div id="tabLayer" style="display:none">
		<!-- Tab BG Box ) (S) -->
   		<table class="search"> 
      	<tr>
       		<td class="bg">
			<div id="sentTabSCTariffLayer" style="display:block">       		
				<table class="search" border="0">
				<tr class="h23">
					<td class="title_h"></td>
					<td class="title_s">S/C Exception Tariff</td>
					<td align="right">
						<table width="250" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn2_left"></td>
							<td class="btn2" name="t2btn_SCdownexcel">S/C Exception Tariff Down Excel</td>
							<td class="btn2_right"></td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
				<!-- Grid  (S) -->
				
				<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t2sheet1');</script>
					</td>
				</tr>
				</table> 				

				<!-- Grid  (e) -->
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			</div>
			
			<div id="sentTabBeforeBookingLayer" style="display:block">				
				<table class="search" border="0">
				<tr class="h23">
					<td class="title_h"></td>
					<td class="title_s">Before Booking DAR</td>
					<td align="right">
						<table width="210" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn2_left"></td>
							<td class="btn2" name="t2btn_Beforedownexcel">Before BKG DAR Down Excel</td>
							<td class="btn2_right"></td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
				<!-- Grid  (S) -->
				
				<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t2sheet2');</script>
					</td>
				</tr>
				</table> 				

				<!-- Grid  (e) -->
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			</div>
			
   			<div id="sentTabAfterBookingLayer" style="display:block">	
				<table class="search" border="0">
				<tr class="h23">
					<td class="title_h"></td>
					<td class="title_s">After Booking DAR</td>
					<td align="right">
						<table width="210" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn2_left"></td>
							<td class="btn2" name="t2btn_Afterdownexcel">After BKG DAR Down Excel</td>
							<td class="btn2_right"></td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
				<!-- Grid  (S) -->
				
				<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t2sheet3');</script>
					</td>
				</tr>
				</table> 
			</div>
				<!-- Grid  (e) -->
			</td>
		</tr>
		</table>
		
<!-- : ( Search Options ) (E) -->
</div>
<!--TAB Sent (E) --> 		

			
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->

	</td></tr>
</table>
	</td></tr>
</table>
</form>
</body>
</html>
