<%
/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : fns_joo_0087.jsp
 *@FileTitle : Integrated Loading Summary Report 화면
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.01.19
 *@LastModifier : 김영오
 *@LastVersion : 1.0
 * 2012.01.19 김영오
 * 1.0 Creation
 
Date : 2012.07.19. 
Ticket ID : SRM-201227013
Title :[ALPS JOO] TDR Inquiry by VVD - Additional Slot 칼럼 및 Sub Alloc and Ratio 팝업 추가
개발자 : 전상화
Description : 
	1. Support & Administration > Joint Operation > TDR/RDR > Integrated Loading Summary Report 에
	   Lane 조회 조건 수정 (PopUp -> Select Box)
	
	
Date : 2012.07.24. 	
Ticket ID : SRM-201227013
Title :[ALPS JOO] TDR Inquiry by VVD - Additional Slot 칼럼 및 Sub Alloc and Ratio 팝업 추가
개발자 : 전상화
Description
  1. Lane 조회 조건 수정 (PopUp -> Select Box)로 수정하면서 추가 사항(select Key 추가)을 반영

 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>

<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0087Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	FnsJoo0087Event event = null; // PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; // 서버에서 발생한 에러
	String strErrMsg = ""; // 에러메세지
	int rowCount = 0; // DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String yyyyMMDD = JSPUtil.getKST("yyyy-MM-DD");
	Logger log = Logger
			.getLogger("com.hanjin.apps.JointOperationAgreementSettlement.CarrierSettlementProcess");
	String strFromyyyyMMdd = "";
	String strToyyyyMMdd = "";
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strFromyyyyMMdd = DateTime.getFormatDate(DateTime.addMonths( JSPUtil.getKST("yyyyMMdd"), -1), "yyyyMMdd", "yyyy-MM-dd");
		strToyyyyMMdd = DateTime.getFormatDate(JSPUtil.getKST("yyyyMMdd"), "yyyyMMdd", "yyyy-MM-dd");

		event = (FnsJoo0087Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		
		
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Integrated Loading Summary Report</title>
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

<body onLoad="setupPage();">
<form name="form">

<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> <!-- 개발자 작업    -->
<input type="hidden" name="dt" value="<%=yyyyMMDD%>">
<input type="hidden" name="dt2" value="<%=strToyyyyMMdd%>">
<input type="hidden" name="tab_gubun" value="">
<input type="hidden" name="code">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top"><!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>
		<!--Page Title, Historical (E)--> <!--biz page (S)-->
		<table class="search">
			<tr>
				<td class="bg">
				<!--  biz_1  (S) -->
					<table class="search" border="0" style="width:979;">
	                <tr class="h23">
	                    <td width="45">Period&nbsp;</td>
	                    <td width="210">
	                    	<input type="text" style="width:70" class="input1" required dataformat="ymd"  maxlength="8" caption="Period From" name="pre_fr" value="" cofield="pre_to">&nbsp;<img src="img/btns_calendar.gif" align="absmiddle" name="btns_calendar_from" style="cursor:hand">&nbsp;~
	                        <input type="text" style="width:70" class="input1" required dataformat="ymd"  maxlength="8"  caption="Period To" name="pre_to" value="<%=strToyyyyMMdd%>" cofield="pre_fr">&nbsp;<img src="img/btns_calendar.gif" align="absmiddle" name="btns_calendar_to" style="cursor:hand">
	                    </td>
	                    <td width="40" align="right" >Lane&nbsp;</td>
	                    <td>	                    
	                    <!-- 2012.07.19  Editor : Start -->	                     
	                    <script language="javascript">ComComboObject('rlane_cd', 2, 72, 0, 1);</script>	    	                   										 
	                     <!-- 2012.07.19  Editor : End	  -->	                     
	                    </td>	                    
	                    <td width="35" align="right" >Dir.&nbsp;</td>
	                	<td width="40"><script language="javascript">ComComboObject('skd_dir_cd', 1, 40, 1, 0,0 );</script></td>
	                	<td width="60" align="right">Region&nbsp;</td>
                    	<td><script language="javascript">ComComboObject("joRgnCdCombo", 1, 90, 1, 0, 0);</script><input type="hidden" name="region"></td>
                    	<td width="40" align="right">VVD&nbsp;</td>
	                    <td><input type="text" style="width:80" class="input" name="vvd" dataformat="uppernum" caption="VVD" maxlength="9" minlength="1" fullfill style="ime-mode:disabled"></td>
	                    <td width="50" align="right">Carrier&nbsp;</td>
	                    <td><script language="javascript">ComComboObject("oprCdCombo", 1, 70, 1, 1, 0);</script><input type="hidden" name="opr_cd"></td>
	                    <td width="65" align="right">Rev/Exp&nbsp;</td>
						<td width="80"><script language="javascript">ComComboObject('re_divr_cd', 1, 80, 1, 1,0 );</script></td>	                    	                    	                                        
	                </tr>
	                </table>
				<!--  biz_1   (E) -->
				</td>
			</tr>
		</table>
		<table class="height_10">
			<tr>
				<td colspan="8"></td>
			</tr>
		</table>
		
	<!-- Tab ) (S) -->
    		<table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%"> 
       		<tr>
	       		<td width="100%">
					<script language="javascript">ComTabObject('tab1')</script>
				</td>
			</tr>
		</table>
	<!-- Tab ) (E) -->
		
		<div id="additional_cd_line" style="display:Inline">
		<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="280" >
				 	<table border="0" style="width:350;" class="">
							 	<tr class="h23">
										<td width="" name="additional_cd" class="noinput1" style="font-size:12;">
											<input type="radio" name="additional_cd" value="S" class="trans" checked> Additional Slot 
											<input type="radio" name="additional_cd" value="L" class="trans"> Additional Slot & Loading Detail 
										</td>
								</tr>
					</table>
				</td>
			</tr>
		</table>
		</div>
					
	<!--TAB RDR (S) -->
	<div id="tabLayer" style="display:Inline">
			<!-- Tab BG Box  (S) -->
	     <table class="search"> 
       		<tr>
	       		<td class="bg" style="height:160" valign="top">
				<!--  biz_5 (E) -->
				<!-- Grid  (S) -->
					<div id="t3sheetLayer1" style="display:Inline">
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('t3sheet1');</script>
								</td>
							</tr>
						</table>  
					</div>
				<!-- Grid (E) -->
			<!-- Tab BG Box (S) -->
			</td>
		</tr>
	</table>
	</div>
	<!--TAB RDR (E) --> 	
		
		
		
		
		
	<!--TAB TDR (S) -->
	<div id="tabLayer" style="display:none">
			<!-- Tab BG Box  (S) -->
	     <table class="search"> 
       		<tr>
	       		<td class="bg" style="height:160" valign="top">
				<!--  biz_5 (E) -->
				<!-- Grid  (S) -->
					<div id="t3sheetLayer1" style="display:Inline">
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('t3sheet2');</script>
								</td>
							</tr>
						</table>  
					</div>
				<!-- Grid (E) -->
			<!-- Tab BG Box (S) -->
			</td>
		</tr>
	</table>
	</div>
	<!--TAB TDR (E) --> 	
		
		
	<!--TAB Booking Date (S) -->
	<div id="tabLayer" style="display:none">
			<!-- Tab BG Box  (S) -->
	     <table class="search"> 
       		<tr>
	       		<td class="bg" style="height:160" valign="top">
				<!--  biz_5 (E) -->
				<!-- Grid  (S) -->
					<div id="t3sheetLayer1" style="display:Inline">
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('t3sheet3');</script>
								</td>
							</tr>
						</table>  
					</div>
				<!-- Grid (E) -->
			<!-- Tab BG Box (S) -->
			</td>
		</tr>
	</table>
	</div>
	<!--TAB Booking Date (E) --> 

		<!-- Tab BG Box  (S) --> <!--biz page (E)--> <!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
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
						
						<td class="btn1_line"></td>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_new">New</td>
								<td class="btn1_right"></td>
								</tr>
							</table>
						</td>

						<td class="btn1_line"></td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_save">Save</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				<!--Button (E) --></td>
			</tr>
		</table>
		</td>
	</tr>
</table>
<!-- 개발자 작업  끝 --></form>
</body>
</html>