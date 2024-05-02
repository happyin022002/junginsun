<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_1033.jsp
*@FileTitle : Repo Result by Port
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.05.26 박광석
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
<%@ page import="com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.event.EesCim1033Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim1033Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (EesCim1033Event)request.getAttribute("Event");
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
<title>Repo Result by Port</title>
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
<input type="hidden" name="vvd">

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
					<td style="width:550;" >
						<table border="0" style="width:530;" class="search_sm2">  
						<tr class="h23">
							<td width="50" rowspan="2">Option</td>
							<td width="65" class="stm"><input type="radio" value="P" class="trans" checked name="option">Period</td>
							<td width=""><select style="width:125;" class="input1" name="period"><option value="M" selected>Month(YYYY-MM)</option><option value="W" >Week(YYYY-WW)</option>
							</select> <input type="text" style="width:51;" class="input1" value="" name="froms" required dataformat="ym" maxlength="6">&nbsp;~&nbsp;<input type="text" style="width:51;" class="input1" value="" name="tos" required dataformat="ym" maxlength="6"></td>
							<td>Lane&nbsp;<script language="javascript" >ComComboObject('lane', 2, 55, 0,0,0,true);</script></td>
						</tr>
						<tr class="h23">
							<td width="" class="stm"><input type="radio" value="V" class="trans"  name="option">VVD</td>
							<td colspan="3" class="stm">
							<input type="text" style="width:88;" class="input1" value=""  name="vvd01" disabled dataformat="engup" style="ime-mode:disabled" maxLength ="9">
							<input type="text" style="width:88;" class="input" value=""  name="vvd02" disabled dataformat="engup" style="ime-mode:disabled" maxLength ="9">
							<input type="text" style="width:88;" class="input" value=""  name="vvd03" disabled dataformat="engup" style="ime-mode:disabled" maxLength ="9">
							<input type="text" style="width:88;" class="input" value=""  name="vvd04" disabled dataformat="engup" style="ime-mode:disabled" maxLength ="9">
							<img class="cursor" src="img/btns_search.gif" name="btn_vvd" width="19" height="20" border="0" align="absmiddle">
							</td>
						</tr>  
						</table>
						
						<table class="height_2"><tr><td colspan="8"></td></tr></table>
						
						<table border="0" style="width:96%;" class="search_sm"> 
						<tr class="h23">
							<td width="70" align="center" rowspan="2">Direction<br>Wise<br>
								<select style="width:70;" class="input"  name="directionwise">
									<option value="F">From</option>
									<option value="T" selected>To</option>
								</select>
							</td>
							<td width="100" class="stm"><input type="radio" value="R"  name="inquirywise" class="trans" checked><span id="ft" >To/From</span></td>
							<td width="50" class="stm"><span id="torcc">TO RCC</span></td>
							<td width="90"><script language="javascript" >ComComboObject('rcc01', 1, 70, 0,1,0,true);</script><input type="text" style="width:0" name="rccnext"></td>
							<td width="50" class="stm"><span id="fmrcc">FM RCC</span></td>
							<td width="90"><script language="javascript" >ComComboObject('rcc02', 1, 70, 0,0,0,true);</script></td>
						</tr> 
						<tr class="h23">
							<td width="100" class="stm"><input type="radio" value="P"  name="inquirywise" class="trans"><span id="ld">POD/POL</span></td>
							<td width="50" class="stm"><span id="pod">POD</span></td>
							<td width="90"><script language="javascript" >ComComboObject('port01', 1, 70, 0, 1,0,true);</script><input type="text" style="width:0" name="portnext"></td>
							<td width="50" class="stm"><span id="pol">POL</span></td>
							<td width="90"><script language="javascript" >ComComboObject('port02', 1, 70, 0, 0,0,true);</script></td>
						</tr> 
						</table>
		
					</td>	
					
					<td width="" valign="top">
						<table border="0" style="width:96%;" class="search_sm2"> 
						<tr class="h23">
							<td width="80">TP/SZ</td>
							<td width="100%" class="stm" style="font-size:12;">
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
						
						<table border="0" style="width:96%;" class="search_sm2"> 
						<tr class="h23">
							<td width="100">T/S CNTR</td>
							<td width="80%" class="stm" style="font-size:12;">
								<input type="radio" class="trans" checked name="tscntr" value="O">&nbsp;By ORGN / DSTN&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" class="trans" name="tscntr" value="T">&nbsp;Through&nbsp;&nbsp;&nbsp;
								<select style="width:90;" class="input" name="through" disabled>
									<option value="I" >Include T/S</option>
									<option value="E" > Exclude T/S</option>
									<option value="O" >Only T/S</option>
								</select>
							</td>
						</tr> 
						</table>
						
						<table class="height_2"><tr><td colspan="8"></td></tr></table>
						
						<table border="0" style="width:96%;" class="search"> 
						<tr class="h23">
							<td width="80">&nbsp;Cargo Type</td>
							<td width="85">
								<select style="width:65;" class="input" name="cargotype" >
									<option value="A">ALL </option>
									<option value="F" >Full</option>
									<option value="M"  selected>MTY</option>
								</select>
							</td>
							<td width="35">S.O.C</td>
							<td width="110">
								<select style="width:77;" class="input" name="soc">
									<option value="E" selected>Exclude</option>
									<option value="I" >Include</option>
									<option value="O" >Only</option>
								</select>
							</td>
							<td width="30">Company</td>
							<td width=""><input type="text" style="width:30;" class="input" value="SML" readOnly></td>
						</tr> 
						</table>
						
					    <table class="height_2"><tr><td colspan="8"></td></tr></table>
						
						<table border="0" style="width:96%;" class="search_desc"> 
						<tr class="h23">
							<td width="400">&nbsp; * Direction wise "From" logic revised since 201307 </td>
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

					<table width="100%" class="search"  id="mainTable"> 
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