<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_1011.jsp
*@FileTitle : Turn Time by Movement
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.08.31 박광석
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
<%@ page import="com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.event.EesCim1011Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim1011Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CNTROperatioNPerformanceMgt.TurnTimePerformanceMgt");
	String xml = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCim1011Event)request.getAttribute("Event");
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
<title>Turn Time by Movement</title>
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
					<td style="width:330;">
					<table border="0" style="width:100%;" class="search_"> 
						<tr class="h23">
							<td width="55">&nbsp;Period</td>
							<td width="127"><select style="width:125;" class="input1" name="period">
							<option value="M" selected>Month(YYYY-MM)</option>
							<option value="W" >Week(YYYY-WW)</option>
							</select></td>
							<td width="170"><input type="text" style="width:55;" class="input1" value="" name="froms" dataformat="ym" maxlength="6">&nbsp;~
							<input type="text" style="width:55;" class="input1" value="" name="tos" dataformat="ym" maxlength="6"></td>
						</tr> 
					</table></td>
					
					<td width="280">
					<table border="0" style="width:100%;" class="search"> 
						<tr class="h23">
							<td width="78">Location by</td>
							<td width="190"><select style="width:100;" class="input1" name="inquiryLevel">
							<option value="AR" selected>All(by RCC)</option>
							<option value="AC" >All(Country)</option>
							<option value="RL" >RCC(by LCC)</option>
							<option value="RE" >RCC(by ECC)</option>
							<option value="LE" >LCC(by ECC)</option>
							<option value="LS" >LCC(by SCC)</option>
							<option value="ES" >ECC(by SCC)</option>
							<option value="SS" >SCC</option>
							</select>&nbsp;<input type="text" style="width:45;" class="input" value="" name="location" dataformat="engup" style="ime-mode:disabled" maxLength ="5">&nbsp;<img class="cursor" name="btn_loc_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
						</tr> 
					</table>
					</td>
					<td rowspan="2">
					<table border="0" style="width:98%;" class="search_sm2" > 
						<tr class="h23">
							<td width="220"><input type="radio" class="trans" checked name="mvmtPairDivision" value="1"> MVMT Pair of Same Loc. Level</td>
							<td width=""><select style="width:140;" class="input" name="mvmtPair1">
						<option value="AL" selected></option>
						<option value="MG" >ID-MT (MTY Generation)</option>
						<option value="MP" >MT-OP (MTY Pick-up)</option>
						<option value="MR" >MT-VL (MTY Repo-out)</option>
						<option value="FH" >MT-XX (Off-hire)</option>
						<option value="FD" >IC-ID (Full Delivery)</option>
						<option value="OF" >OP-VL (Full Outbound)</option>
						<option value="IF" >VD-MT (Full Inbound)</option>
						<option value="TL" >VD-TS-VL (Full T/S)</option>
						</select></td>
						</tr> 
						<tr class="h23">
							<td width=""><input type="radio" class="trans" name="mvmtPairDivision" value="2"> MVMT Pair of Sequence</td>
							<td width=""><select style="width:140;" class="input" name="mvmtPair2">
						<option value="Z" selected></option>
						<option value="A">IC-EN</option>
						<option value="B">EN-IC</option>
						<option value="C">IC-ID</option>
						<option value="D">ID-MT</option>
						<option value="E">MT-EN</option>
						<option value="O">MT-TN</option>
						<option value="F">MT-XX</option>
						<option value="G">XX-MT</option>
						<option value="H">MT-OP</option>
						<option value="I">OP-OC</option>
						<option value="J">OC-EN</option>
						<option value="K">EN-OC</option>
						<option value="L">OC-VL</option>
						<option value="M">EN-MT</option>
						<option value="N">MT-VL</option>
						</select></td>
						</tr> 
					</table></td>
					
				</tr> 
				<tr class="h23">
					<td>
					<table border="0" style="width:310;" class="search_sm2"> 
						<tr class="h23">
							<td width="45">&nbsp;TP/SZ</td>
							<td width="" class="stm" style="font-size:12;">
							<input type="radio" class="trans" checked name="tpsz" value="A">&nbsp;All&nbsp;&nbsp;
							<input type="radio" class="trans" name="tpsz" value="D">&nbsp;DRY&nbsp;&nbsp;
							<input type="radio" class="trans" name="tpsz" value="S">&nbsp;SPCL&nbsp;&nbsp;
							<input type="radio" class="trans" name="tpsz" value="R">&nbsp;Reefer</td>
						</tr> 
					</table></td>
					<td width="270">
					<table border="0" style="width:100%;" class="search"> 
						<tr class="h23">
							<td width="35">S.O.C </td>
							<td width="100"><select style="width:80;" class="input" name="soc">
							<option value="E" selected>Exclude</option>
							<option value="I" >Include</option>
							<option value="O" >Only</option>
								</select></td>
							<td width="60">Company</td>
							<td><input type="text" style="width:35" class="input" value=" SML" ReadOnly align="center"></td>
						</tr> 
					</table>
					</td>
					
				
				</tr> 
				</table>
				<!--  biz_1   (E) -->
				
				</td></tr>
			</table>
			
			<table class="height_8"><tr><td colspan="8"></td></tr></table>
		<!-- Tab (S) -->
     	<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
		<tr><td width="100%">
				<script language="javascript">ComTabObject('tab1')</script>
			</td></tr>
		</table>
		<!-- Tab (E) -->

		<!-- Tab Summary  (S) -->

		<div id="tabLayer" style="display:inline">
				
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

		</div>

		<!-- Tab Summary  (S) -->

		<!-- Tab Detail  (S) -->

		<div id="tabLayer" style="display:none">

		<!-- Tab BG Box  (S) -->
				<table class="search"> 
				<tr><td class="bg">
																			
					<!-- Grid  (S) -->
					<table width="100%" class="search"  id="mainTable"> 
						<tr>
							<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
					</table> 					
					<!-- Grid (E) -->

					<!--  Grid_button (S) -->
					</td></tr>
				</table>
			<!-- Tab BG Box  (S) -->


		</div>

		<!-- Tab Detail  (E) -->
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		
    <!--Button (E) -->

	</td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>