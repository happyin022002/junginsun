<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_1051.jsp
*@FileTitle : MTY CNTR PFMC by Movement
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.06.02 박광석
* 1.0 Creation
* ======================================================
* History
* 2012.02.22 신자영 [CHM-201216310-01] mvmt pfmc by cy 기능 보완
* 2012.05.23 신자영 [CHM-201217983-01] MVMT PFMC BY CY 기능에 검색 가능 MVMT 추가 - ID-MT 옵션 추가
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
<%@ page import="com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.event.EesCim1051Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim1051Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (EesCim1051Event)request.getAttribute("Event");
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
<title>MTY CNTR PFMC by Movement</title>
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
<input type="hidden" name="backendjob_key">
<input type="hidden" name="gubun" value="S">
<input type="hidden" name="sXml" value="<%=xml%>">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="dtlTpsz">
<!-- 개발자 작업	-->
<input type="hidden" name="from">
<input type="hidden" name="to">
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
					<td width="142"><select style="width:140;" class="input1" name="period">
						<option value="D" selected>Date(YYYY-MM-DD)</option>
						<option value="M" >Month(YYYY-MM)</option>
						<option value="W">Week(YYYY-WW) </option>
						</select></td>
					<td width="285">&nbsp;<input type="text" style="width:80;" class="input1" value="" name="froms" caption="FM" required dataformat="ymd" maxlength="8">&nbsp;~&nbsp;
					<input type="text" style="width:80;" class="input1" value="" name="tos" required dataformat="ymd" caption="TO" maxlength="8">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendarto"  id="btns_calendarfm" ></td>
					<td width="60">Location </td>
					<td width=""><select style="width:60;" class="input1" name="inquiryLevel">
						<option value="L" >LCC</option>
						<option value="E" >ECC</option>
						<option value="S"  selected>SCC</option>
						<option value="Y" >Yard</option>
						</select>&nbsp;<input type="text"  style="width:70;" class="input1"  name="location" value="" dataformat="engup" style="ime-mode:disabled" maxLength ="5">&nbsp;<img class="cursor" name="btn_loc_cd"  src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					
					<td width="39">S.O.C</td>
					<td width="90"><select style="width:70;" class="input" name="soc">
						<option value="E"selected>Exclude</option>
						<option value="I" >Include</option>
						<option value="O" >Only </option>
						</select></td>
					<td width="70">Company</td>
					<td width=""><input type="text" style="width:40;text-align:center;" class="input2" value="SML" readOnly></td>
						
					</tr> 
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="47"><div id="comboName1" style="display:none">TP/SZ</div><div id="comboName2" style="display:none">Day</div></td>
					<td width="425" style="font-size:12;">
					<div id="comboLayer1" style="display:none">
						<script language="javascript" >ComComboObject('tpsz', 1, 140,1);</script>
					</div>
					<div id="comboLayer2" style="display:none">
						<script language="javascript" >ComComboObject('day', 1, 140,1);</script>
					</div>					
					<!--  &nbsp;<input type="checkbox" class="trans" name="chk_cntr_tpsz_cd"  border="0">-->
					<!-- 2014.04.25 by Chang Young Kim ( AA Young Du Lee ) 조회 조건 추가 (S) -->
					<div id="comboLayer1_1" style="display:none">
						&nbsp;<script language="javascript" >ComComboObject('vvd_tp', 1, 80,1);</script>
						&nbsp;<input type="text" style="width:80;" class="input" name="vvd_nm" value="" dataformat="engup" style="ime-mode:disabled" maxLength ="9">
					</div>
					<!-- 2014.04.25 by Chang Young Kim ( AA Young Du Lee ) 조회 조건 추가 (E) -->
					<!-- ComboBox or Radio [ Detail Trend ]  (S) -->
					<div id="comboName3" style="display:none">&nbsp;TP/SZ&nbsp;</div>
					<div id="radioLayer" style="display:none">
						<input type="radio" class="trans"  checked name="radioTpsz" value="D">&nbsp;DRY&nbsp;&nbsp;
						<input type="radio" class="trans"  name="radioTpsz" value="O">&nbsp;OT&nbsp;&nbsp;
						<input type="radio" class="trans"  name="radioTpsz" value="F">&nbsp;FR&nbsp;&nbsp;
						<input type="radio" class="trans"  name="radioTpsz" value="R">&nbsp;Reefer&nbsp;
					</div>
					<!-- ComboBox or Radio [ Detail Trend ]  (E) -->
					</td>
					<td width="76">MVMT PFMC</td>
					<td width="180"><select style="width:170;" class="input" name="mtymvmt">
						<option value="MT" selected>MT</option>
						<option value="MTIDMG">MG</option>
						<option value="MP">MP</option>
						<option value="MR">MR</option>
						<option value="MO">MO</option>
						<option value="MTVDVD-MT">VD(MTY)</option>
						<option value="VD">VD(Full)</option>
						<option value="VLMTMT-VL">VL(MTY)</option>
						<option value="VL">VL(Full)</option>
						<option value="OP">OP</option>
						<option value="OC">OC</option>
						<option value="IC">IC</option>
						<option value="ID">ID</option>
						<option value="ENF">EN(Full)</option>
						<option value="ENM">EN(MTY)</option>
						<option value="TNF">TN(Full)</option>
						<option value="TNM">TN(MTY)</option>
						<option value="TS">TS</option>
						<option value="CM">CM</option>
						<option value="CP">CP</option>
						<option value="CI">CI</option>
						<option value="CO">CO</option>
						<option value="CD">CD</option>
						<option value="CT">CT</option>
						<option value="CE">CE</option>
						<option value="XX">XX</option>
						<option value="MTOPOP-MT"">OP-MT</option>
						<option value="MTOCOC-MT">OC-MT</option>
						<option value="OCIDID-OC">ID-OC</option>
						<!-- 추가 항목  -->
						<option value="MTIDID-MT">ID-MT</option>
						<option value="OPMTMT-OP">MT-OP</option>
						<option value="TNMTMT-TN">MT-TN</option>
						<option value="ENMTMT-EN">MT-EN</option>
						<option value="IDICIC-ID">IC-ID</option>
						<option value="ENICIC-EN">IC-EN</option>
						<option value="TNICIC-TN">IC-TN</option>
						<option value="VDMTVL">VD-MT-VL</option>
						<option value="VDMTTNENMTVL">VD-MT-(TN or EN)-MT-VL</option>
						</select></td>
					<td width="45">Bound</td>
					<td width=""><select style="width:60;" class="input" name="bound">
						<option value="" selected>ALL</option>
						<option value="N" >IN</option>
						<option value="Y" >OUT </option>
						</select></td>
					<td width="50">Lease Term</td>
					<td width="40" style="font-size:12;"><script language="javascript">ComComboObject('lstmcd', 1, 70, 1);</script>
						<!-- <input type="checkbox" class="input2" name="chk_lstmcd" readOnly=true  class="input" value=""> -->
					</td>	
				
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
		
<!-- Tab [ Summary ]  (S) -->
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
<!-- Tab [ Summary ]  (E) -->


<!-- Tab [ Detail ]  (S) -->
<div id="tabLayer" style="display:none">

		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
			 														
			<!-- Grid  (S) -->
				<table width="100%"   class="search"  id="mainTable"> 
					<tr>
						<td width="100%">
						<script language="javascript">ComSheetObject('t2sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->

			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%"  class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t2EachCNTR">Each&nbsp;CNTR</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t2EachBKG">Each&nbsp;BKG</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->

</div>
<!-- Tab [ Trend ]  (E) -->
	<!-- Tab [ Detail ]  (S) -->
<div id="tabLayer" style="display:none">

		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
			 														
			<!-- Grid  (S) -->
				<table width="100%" class="search"  id="mainTable"> 
					<tr>
						<td width="100%">
						<script language="javascript">ComSheetObject1('t3sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->

			
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->

</div>
<!-- Tab [ Detail ]  (E) -->
<!-- Tab [ Detail Trend]  (S) -->
<div id="tabLayer" style="display:none">

		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
			 														
			<!-- Grid  (S) -->
				<table width="100%" class="search"  id="mainTable"> 
					<tr>
						<td width="100%">
						<script language="javascript">ComSheetObject('t4sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->

			
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->

</div>
<!-- Tab [ Detail Trend]  (E) -->
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