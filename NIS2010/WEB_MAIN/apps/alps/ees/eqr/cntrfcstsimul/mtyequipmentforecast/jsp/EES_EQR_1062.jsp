<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1062.jsp
*@FileTitle :Forecast Accuracy Review (By Week)
*Open Issues :
*Change history : 1. 2012-12-24 CHM-201222064, 신용찬 수석, Location By 옵션 조정
                  2. 2013-01-21 CHM-201322369, Location 검색조건 추가, 신용찬 수석
*@LastModifyDate : 2009.12.17
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.12.17 김종준
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
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.event.EesEqr1062Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr1062Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesEqr1062Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String optionStr = "000000: :ALL";
	String cntrTpsz  = JSPUtil.getCodeCombo("cntrTpsz","","style='width:70;'","CD00263",0,optionStr);
	String locSelectBox = JSPUtil.getCodeCombo("loc_tp_cd_second","L","","CD03052",0,"");		
%>
<html>
<head>
<title>MTY Balance Report</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	// Type Size
    <%= JSPUtil.getIBCodeCombo("tpszall", "01", "CD00830", 0, "")%> // ALL TYPE SIZE CD00244
    <%= JSPUtil.getIBCodeCombo("tpszdry", "01", "CD00751", 0, "")%> // DRY TYPE SIZE
    <%= JSPUtil.getIBCodeCombo("tpszrfr", "01", "CD00752", 0, "")%> // RFR TYPE SIZE
    <%= JSPUtil.getIBCodeCombo("tpszot",  "01", "CD00828", 0, "")%> // OT  TYPE SIZE CD00753
    <%= JSPUtil.getIBCodeCombo("tpszfr",  "01", "CD00829", 0, "")%> // FR  TYPE SIZE CD00754
    
    // ------- type 변수선언 -------------- START
	var consTpsz      = replaceAll(tpszallText, "|", ",");
	var consTpszArr   = consTpsz.split(',');
	var consTpszDry   = replaceAll(tpszdryText, "|", ",");
	var consTpszRfr   = replaceAll(tpszrfrText, "|", ",");
	var consTpszOt    = replaceAll(tpszotText,  "|", ",");
	var consTpszFr    = replaceAll(tpszfrText,  "|", ",");
	// ------- type 변수선언 -------------- END

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
<input type="hidden" name="search_flag">
<input type="hidden" name="inquiryLevel" value=""> 
<input type="hidden" name="location" value=""> 
<input type="hidden" name="backendjob_key">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
		<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
	
		</td></tr>
		<tr><td valign="top">
		
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_Retrieve">Retrieve</td>
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
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
	
		<!--biz page (S)-->
		<!-- 1 (S) -->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
															
					<td width="">
						<input type="radio" name="div_flag" value="1" class="trans" OnClick="ChangeInputStatus(1);" checked>
					</td>
						
					<td width="80">Location By</td>
					<td width="72">
						<select style="width:100;" name="loc_tp_cd" class="input">
							<option value="E" selected>ECC(by SCC)</option>
							<option value="L">LCC(by ECC)</option>
							<option value="S">LCC(by SCC)</option>
							<option value="R">RCC(by LCC)</option>
						</select>
					</td>
					<td width="100">
						<input type="text" dataformat="engup" size="5" maxlength="5" caption="Location By CD"  style="width:50;" class="input1" name="loc_cd" value="">&nbsp;<img src="img/btns_search.gif" name="btn_loc_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					</td>

					<td width="">
						<input type="radio" name="div_flag" value="2" class="trans" OnClick="ChangeInputStatus(2);">
					</td>
					<td width="50">Location</td>
					<td width="50"><%= locSelectBox %></td> <!-- loc_tp_cd_second -->
					<td width="120">
						<input type="text" dataformat="engup" size="5" maxlength="5" caption="Location CD" style="width:50;" class="input1" name="loc_cd_second" value=""> <img src="img/btns_search.gif" name="btn_loc_cd_second" width="19" height="20" border="0" align="absmiddle" class="cursor">
					</td>
										
					<td width="35">Week</td>
					<td width="180"><input type="text" style="width:60"  required maxlength="7" caption="Week From" dataformat="yw" class="input1" name="fm_week" value="">&nbsp;~&nbsp;<input type="text" style="width:60" caption="Week To" required maxlength="7" dataformat="yw"  class="input1" name="to_week" value="">&nbsp;</td>
					<td width="60">Forecast</td> 
					<td width="100"><select style="width:80;" class="input" name="bound">
						<option value="O" selected>OP</option>
						<option value="I">MG</option>
						<option value="A">ALL</option>
						</select></td>
					<td align="right"><table width="120" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
					    <td class="btn2_left"></td>
					    <td class="btn2" name="btn_t1detail">Evaluation Rule</td>
					    <td class="btn2_right"></td>
					</tr>
					</table></td> 
				</tr>
				<tr class="h23">
				    <td></td>
					<td>TP/SZ</td>
					<td width="70"><%= cntrTpsz %></td>
					<td colspan=8>&nbsp;<script language="javascript">ComComboObject('tpsztype' , 1, 280, 1 )</script></td>
				</tr>
				</table>	
				<!--  biz_1   (E) -->
		</td></tr>
		</table>	
		<!-- 1 (E) -->
		<table class="height_8"><tr><td></td></tr></table>


		<!-- Tab ) (S) -->
   		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
     		<tr><td width="100%">
				<script language="javascript">ComTabObject('tab1')</script>
			</td></tr>
		</table>
		<!-- Tab ) (E) --> 
		
<!--TAB Inventory (S) -->
<div id="tabLayer" style="display:inline">
		
		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
			
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t1sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->
			<table class="height_5"><tr><td></td></tr></table>
			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Accuracy Ranking</td></tr>
			</table>
			<!-- Grid - 1 (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t2sheet1');</script>
					</td>
				</tr>
			</table>			
			<!-- Grid - 1 (E) -->			
					
			</td></tr>
		</table>

		
		
	<!--biz page (E)-->
</div>

<!--TAB  (S) -->
<div id="tabLayer" style="display:none">
		<!-- 2 (S) -->		
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			<table class="search_sm2">
				<tr class="h23">
					<td class="stm"><input type="radio" name="view_flag" checked value="" class="trans">All&nbsp;&nbsp;&nbsp;<input type="radio" name="view_flag" value="1" class="trans">FCST&nbsp;&nbsp;&nbsp;<input type="radio" name="view_flag" value="2" class="trans">PFMC&nbsp;&nbsp;&nbsp;<input type="radio" name="view_flag" value="3" class="trans">Diff.Vol&nbsp;&nbsp;&nbsp;<input type="radio" name="view_flag" value="4" class="trans">Diff.(%)&nbsp;&nbsp;&nbsp;<input type="radio" name="view_flag" value="5" class="trans">Evaluation<td>
				</tr>
			</table>
			<table class="height_5"><tr><td></td></tr></table>
			<!-- Grid - 1 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t1sheet2');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid - 1 (E) -->	
			</td></tr>
		</table>
		<!-- 2 (E) -->
</div>
<!--TAB  (E) --> 
	
<!--biz page (E)-->
	</td></tr>
	</table>
	<table class="height_10"><tr><td colspan="8"></td></tr></table>
</form>
</body>
</html>
