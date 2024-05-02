<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_1034.jsp
*@FileTitle : Repo Result by Location
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.05.27 박광석
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.event.EesCim1034Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim1034Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CNTROperatioNPerformanceMgt.MTYRepositionPerformanceAnalysis");
	String xml = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCim1034Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		xml = HttpUtil.makeXML(request,response);

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Repo Result by Location</title>
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
<input type="hidden" name="sXml" value="<%=xml%>">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="from">
<input type="hidden" name="to">
<input type="hidden" name="inquiryLevel" value="O">
<input type="hidden" name="company" value="H">
<input type="hidden" name="location">

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
					<td class="btn1" name="btn_Retrieve" ID="btn_Retrieve">Retrieve</td>
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
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="480">
						<table border="0" style="width:450;" class="search"> 
						<tr class="h23">
							<td width="50">&nbsp;Period</td>
							<td width="" >
								<select style="width:125;" class="input1" name="period">
									<option value="M" selected>Month(YYYY-MM)</option>
									<option value="W" >Week(YYYY-WW)</option>
								</select>&nbsp;<input type="text" style="width:55;" class="input1" value="" name="froms" required dataformat="ym" maxlength="6">&nbsp;~&nbsp;
							<input type="text" style="width:55;" class="input1" value="" name="tos" required dataformat="ym" maxlength="6"></td>
						</tr>
						</table>
						
						<table class="height_2"><tr><td colspan="8"></td></tr></table>
						
						<table border="0" style="width:450;" class="search_sm2"> 
						<tr class="h23">
							<td width="100" rowspan="2">Direction Wise<br>
								<select style="width:90;" class="input"  name="directionwise">
									<option value="F">From</option>
									<option value="T" selected>To</option>
								</select>
							</td>
							<td width="80" class="stm"><input type="radio" value="R"  name="inquirywise" class="trans" checked>Within</td>
							<td width="30" class="stm"> RCC</td>
							<td width="" colspan="2" style="padding-left:1">
								<script language="javascript" >ComComboObject('rcc', 1, 70, 0,0,0,true);</script>
							</td>
							
						</tr> 
						<tr class="h23">
							<td width="" class="stm"><input type="radio" value="L"  name="inquirywise"  class="trans" >Location</td>
							<td width="" class="stm"><span id="tt" >To</span></td>
							<td width="" class="stm"><input type="text" style="width:67;" class="input1" value="" name="loccode1" dataformat="engup" style="ime-mode:disabled" maxLength ="5">
							<img class="cursor" src="img/btns_search.gif" name="btn_location1" width="19" height="20" border="0" align="absmiddle"></td>
							<td width="" class="stm"><span id="ff" >From</span>&nbsp;<input type="text" style="width:67;" class="input" value="" name="loccode2" dataformat="engup" style="ime-mode:disabled" maxLength ="5">
							<img class="cursor" src="img/btns_search.gif" name="btn_location2" width="19" height="20" border="0" align="absmiddle"></td>
						</tr> 
						</table>
						<table class="height_2"><tr><td colspan="8"></td></tr></table>
						<table border="0" style="width:450;" class="search_sm2"> 
						<tr class="h23">
							<td width="120">Inquiry Level</td>
								<td width="428" class="stm" style="font-size:12;">
						<input type="radio" class="trans" checked name="inquirylevel" value="L">&nbsp;By LCC&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" class="trans" name="inquirylevel" value="E">&nbsp;By ECC&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" class="trans" name="inquirylevel" value="S">&nbsp;By SCC&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
						</tr> 
						</table>
					</td>	
					
					<td width="" valign="top">
						<table border="0" style="width:96%;" class="search_sm2"> 
						<tr class="h23">
							<td width="80">TP/SZ </td>
								<td width="428" class="stm" style="font-size:12;">
								<input type="radio" class="trans"  name="tpsz" checked value="A">&nbsp;All&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" class="trans" name="tpsz"  value="D">&nbsp;DRY&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" class="trans" name="tpsz"  value="S">&nbsp;SPCL&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" class="trans" name="tpsz"  value="R">&nbsp;Reefer&nbsp;&nbsp;&nbsp;
								<select style="width:90;" class="input" name="rdtype" disabled>
									<option value="I" selected>Include R/D</option>
									<option value="E">Exclude R/D</option>
									<option value="O" >Only R/D</option>
								</select>
							</td>
						</tr> 
						</table>
						
						<table class="height_2"><tr><td colspan="8"></td></tr></table>
						
						<table border="0" style="width:96%;" class="search"> 
						<tr class="h23">
							<td width="80">&nbsp;Cargo Type</td>
							<td width="130">
								<select style="width:100;" class="input" name="cargotype" >
									<option value="A">ALL </option>
									<option value="F" >Full</option>
									<option value="E"  selected>Empty</option>
								</select>
							</td>
							<td width="50">S.O.C</td>
							<td width="140">
								<select style="width:100;" class="input" name="soc">
									<option value="E" selected>Exclude</option>
									<option value="I" >Include</option>
									<option value="O" >Only</option>
								</select>
							</td>
							<td width="65">Company</td>
							<td width=""><input type="text" style="width:30;" class="input" value="SML" readOnly></td>
						</tr> 
						</table>
						
						
						
					</td>	
				</tr> 
				</table>
				
				<!--  biz_1   (E) -->
				
				</td></tr>
			</table>
			
			<table class="height_8"><tr><td colspan="8"></td></tr></table>
		
		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
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

			<!--  Grid_button (S) -->
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		
    <!--Button (E) -->
	
<table class="height_10"><tr><td colspan="8"></td></tr></table>
	</td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>