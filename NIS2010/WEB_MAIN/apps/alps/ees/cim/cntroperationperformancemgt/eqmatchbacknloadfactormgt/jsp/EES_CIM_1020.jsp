<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_cim_1020.jsp
*@FileTitle : Lane M/B by Logistics-Wise
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.05.21 박광석
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
<%@ page import="com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EesCim1020Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim1020Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CNTROperatioNPerformanceMgt.EQMatchBackNLoadFactorMgt");
	String xml = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCim1020Event)request.getAttribute("Event");
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
<title>Lane M/B by Logistics-Wise</title>
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
<SPAN id="cursors">
<form name="form"  >
<input type="hidden" name="sXml" value="<%=xml%>">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="etcDataValue" value="">
<input type="hidden" name="from">
<input type="hidden" name="to">
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
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve"  ID="btn_Retrieve">Retrieve</td>
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
					<td width="45">Period</td>
					<td width="127"><select style="width:125;" class="input1" name="period" >
						<option value="M" selected>Month(YYYY-MM)</option>
						<option value="W">Week(YYYY-WW)</option>
						</select></td>
					<td width="200"><input type="text" style="width:55;" class="input1" value="" name="froms" caption="FM" required dataformat="ym" maxlength="6">&nbsp;~
					<input type="text" style="width:55;" class="input1" value="" name="tos" required dataformat="ym" caption="TO" maxlength="6"></td>
					<td width="500">
						<table border="0" style="width:485;" class="search_sm2"> 
						<tr class="h23">
						<td width="88">Inquiry Level</td>
						<td width="28" class="stm" style="font-size:12;">Port&nbsp<input type="text" style="width:0" name="prepolnext"></td>
						<td width="90"><script language="javascript">ComComboObject('pol', 1, 70, 0,0,0,true);</script><input type="text" style="width:0" name="polnext"></td>
						
						<td width="30" class="stm" style="font-size:12;">Yard&nbsp</td>
						<td width="90"><script language="javascript">ComComboObject('yard', 1, 50, 0,0,0,true);</script><input type="text" style="width:0" name="yardnext"></td>
						
						<td width="28" class="stm" style="font-size:12;">Lane&nbsp</td>
						<td width="60"><script language="javascript">ComComboObject('lane', 2, 50, 0,0,0,true);</script><input type="text" style="width:0" name="lanenext"></td>
						<td width="28" class="stm" style="font-size:12;">VVD&nbsp</td>
						<td width=""><script language="javascript">ComComboObject('vvd', 1, 100, 0,0,0,true);</script></td>
						</tr> 
						</table>
					</td> 
					<td width="60">Company</td>
					<td width=""><input type="text" style="width:30;text-align:center;" class="input" value="SML" readOnly name="company"></td>
					</tr> 
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="375">
					<table border="0" style="width:360;" class="search_sm2"> 
					<tr class="h23">
					<td width="45">TP/SZ </td>
					<td width="" class="stm" style="font-size:12;">
						<input type="radio" class="trans" name="tpsz" checked value="A">All&nbsp;
						<input type="radio" class="trans" name="tpsz" value="D">DRY&nbsp;
						<input type="radio" class="trans" name="tpsz" value="S">SPCL&nbsp;
						<input type="radio" class="trans" name="tpsz" value="R">Reefer&nbsp;
						<select style="width:90;" class="input" name="rdtype" disabled>
						<option value="I" selected>Include R/D</option>
						<option value="E">Exclude R/D</option>
						<option value="O" >Only R/D</option>
						</select></td>
						</tr> 
						</table></td>
						
					<td width="72">Cargo Type</td>	
					<td width="73"><select style="width:60;" class="input" name="cargotype">
						<option value="A" selected></option>
						<option value="F">FULL</option>
						<option value="M">MTY</option>
						</select></td>
					<td width="63">T/S CNTR</td>
					<td width="90"><select style="width:74;" class="input" name="tscntr">
						<option value="E" selected>Exclude</option>
						<option value="I" >Include</option>
						<option value="O" >Only</option>
						</select></td>
					<td width="40">S.O.C</td>
					<td width=""><select style="width:82;" class="input" name="soc">
						<option value="E"selected>Exclude</option>
						<option value="I" >Include</option>
						<option value="O" >Only</option>
						</select></td>
				
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
</SPAN>
</body>
</html>