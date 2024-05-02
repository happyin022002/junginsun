<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_1023.jsp
*@FileTitle : Location M/B by Logistics-Wise
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.05.20 박광석
* 1.0 Creation
* ------------------------------------------------------------
* History
* 2012.03.26 신자영 [CHM-201216788-01] M/B 기능 보완 요청
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
<%@ page import="com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EesCim1023Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim1023Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strCnt_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CNTROperatioNPerformanceMgt.EQMatchBackNLoadFactorMgt");
	String xml = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strCnt_cd = account.getCnt_cd();


		event = (EesCim1023Event)request.getAttribute("Event");
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
<title>Location M/B by Logistics-Wise</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
		document.form.froms.focus();		
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="sXml" value="<%=xml%>">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="etcDataValue" value="">
<input type="hidden" name="etcChk" value="">
<input type="hidden" name="from">
<input type="hidden" name="to">
<input type="hidden" name="inquiryLevel2">

<!-- Report Start -->
<input type="hidden" name="rpt_period"    >
<input type="hidden" name="rpt_fromdate"  >
<input type="hidden" name="rpt_todate"    >
<input type="hidden" name="rpt_locationby">
<input type="hidden" name="rpt_location"  >
<input type="hidden" name="rpt_cargotype" >
<input type="hidden" name="rpt_tpsz"      >
<input type="hidden" name="rpt_rdtype"    >
<input type="hidden" name="rpt_enroute"   >
<input type="hidden" name="rpt_soc"       >
<input type="hidden" name="rpt_company"   >
<input type="hidden" name="rpt_cnt_cd"  value="<%=strCnt_cd%>" >
<!-- Report End -->

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
					<td class="btn1" name="btn_Retrieve" ID="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
                
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Print">Print</td>
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
					<td width="48">Period</td>
					<td width="90"><select style="width:125;" class="input1" name="period" >
						<option value="M" selected>Month(YYYY-MM)</option>
						<option value="W">Week(YYYY-WW)</option>
						</select></td>
					<td width="245">&nbsp;<input type="text" style="width:55;" class="input1" value="" name="froms" caption="FM" required dataformat="ym" maxlength="6">&nbsp;~&nbsp;
					<input type="text" style="width:55;" class="input1" value="" name="tos" required dataformat="ym" caption="TO" maxlength="6"></td>

					<td width="65">Location </td>
					<td width="203"><select style="width:70;" class="input1" name="inquiryLevel">
						<option value="A" selected></option>
						<option value="R" >RCC</option>
						<option value="L" >LCC</option>
						<option value="E" >ECC</option>
						<option value="P" >PORT</option>
						<option value="Y" >YARD</option>
						</select>&nbsp;<input type="text" style="width:72;" class="input" name="location" value=""  dataformat="engup" style="ime-mode:disabled"  maxlength="5"  disabled>&nbsp;<img class="cursor" src="img/btns_search.gif"  name="btn_loc_cd"  width="19" height="20" border="0" align="absmiddle"></td>
					<td width="70">Cargo Type</td>
					<td width=""><select style="width:55;" class="input" name="cargotype">
						<option value="A" selected></option>
						<option value="F">FULL</option>
						<option value="M" >MTY</option>
						</select></td>
					</tr> 
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="420">
					<table border="0" style="width:94%;border:5px;" class="search_sm2"> 
					<tr class="h23">
					<td width="45">TP/SZ</td>
					<td width="345" class="stm" style="font-size:12;">
						<input type="radio" class="trans" checked name="tpsz" value="A" onClick="rdTypeSel(this.value)">&nbsp;All&nbsp;&nbsp;
						<input type="radio" class="trans"  name="tpsz" value="D" onClick="rdTypeSel(this.value)">&nbsp;DRY&nbsp;&nbsp;
						<input type="radio" class="trans"  name="tpsz" value="S" onClick="rdTypeSel(this.value)">&nbsp;SPCL&nbsp;&nbsp;
						<input type="radio" class="trans"  name="tpsz" value="R" onClick="rdTypeSel(this.value)">&nbsp;Reefer&nbsp;
						<select style="width:100;" class="input" name="rdtype" disabled>
						<option value="I"selected>Include R/D</option>
						<option value="E">Exclude R/D</option>
						<option value="O">Only R/D</option>
						</select></td>
						</tr> 
						</table></td>
					<td width="65">T/S CNTR</td>
					<td width="203"><select style="width:78;" class="input" name="tscntr">
						<option value="E"selected>Exclude</option>
						<option value="I">Include</option>
						<option value="O">Only </option>
						</select></td>
					<td width="35">S.O.C </td>
					<td width="110"><select style="width:90;" class="input" name="soc">
						<option value="E"selected>Exclude</option>
						<option value="I">Include</option>
						<option value="O">Only </option>
						</select></td>
					<td width="65">Company</td>
					<td width=""><input type="text" style="width:30;" class="input" value="SML" readOnly></td>
				
				</tr> 
				</table>
				<!--  biz_1   (E) -->
				
				</td></tr>
			</table>
			
			<table class="height_10"><tr><td colspan="8"></td></tr></table>
		<!-- Tab (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       			<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
					</td></tr>
				</table>
		<!-- Tab (E) -->	

<!-- Tab [ M/Back (%) ]  (S) -->
<div id="tabLayer" style="display:inline">

		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
			 														
			<!-- Grid  (S) -->
				<table width="100%" class="search"  id="mainTable"> 
					<tr>
						<td width="100%">
						<script language="javascript">ComSheetObject('t1sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->

			<!--  Grid_button (S) -->
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->

</div>
<!-- Tab [ M/Back (%) ]  (E) -->


<!-- Tab [ M/B Detail ]  (S) -->
<div id="tabLayer" style="display:none">

		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
			 														
			<!-- Grid  (S) -->
				<table width="100%" class="search"  id="mainTable"> 
					<tr>
						<td width="100%">
						<script language="javascript">ComSheetObject('t2sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->

			<!--  Button_Sub (S) -->
	    	<!-- Button_Sub (E) -->
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->

</div>
<!-- Tab [ M/B Detail ]  (E) -->

<!--TAB M/B Trend (S) -->
<div id="tabLayer" style="display:none">

		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
			 														
			<!-- Grid  (S) -->
			
				<table width="100%"  class="search" id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject1('t3sheet1');</script>
						</td>
					</tr>
				</table>			

			<!-- Grid (E) -->

			<!--  Grid_button (S) -->
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->

</div>
<!--TAB M/B Trend (E) --> 




	
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