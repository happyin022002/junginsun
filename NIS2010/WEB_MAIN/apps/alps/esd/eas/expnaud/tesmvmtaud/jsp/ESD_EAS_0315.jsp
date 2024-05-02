<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_EAS_0315.jsp
*@FileTitle : Contianer Movement - Reefer
*Open Issues :
*Change history :
*@LastModifyDate : 2015-02-02
*@LastModifier : 9014613
*@LastVersion : 1.0
* 2015-02-02 9014613 			1.0	최초 생성
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.eas.expnaud.tesmvmtaud.event.EsdEas0315Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdEas0315Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.esd.eas.expnaud.tesmvmtaud.TesMvmtAudBC");
	
	String ofc_cd = "";
	String currentDay = DateTime.getFormatString("yyyy-MM-dd");
	String selBOUND = "";
	String optionStr = "000020::";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		ofc_cd = account.getOfc_cd();
		
		event = (EsdEas0315Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		selBOUND  = JSPUtil.getCodeCombo("bnd_cd", "01", "style='width:60'", "CD00591", 0, optionStr);
	}catch(Exception e) {
		out.println(e.toString());
	}
	
%>
<html>
<head>
<title>JO TPB Process Inquiry</title>
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
<!-- 개발자 작업	-->
<!-- ______________________________________________ Start Hidden Value -->
<!-- | -->
<!-- | --><input type="hidden" name="iPage">
		<input type="hidden" name="s_ofc_cd_for_rhq" value="<%=ofc_cd%>">
<!-- |______________________________________________ End Hidden Value -->


<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

	<!-- ______________________________________________ Start Page Navigation & Title -->
	<!-- | -->
	<!-- | -->	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
	<!-- |______________________________________________ End Page Navigation & Title -->


	<!-- ______________________________________________ Start Main Button -->
	<!-- | -->
	<!-- | -->	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>

							<td class="btn1_line"></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>

							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
	<!-- |______________________________________________ End Main Button -->


	<!-- ______________________________________________ Start Search Option -->
	<!-- | -->
	<!-- | -->	<table class="search"><tr><td class="bg" style="width: 979;">
	<!-- | -->
	<!-- | -->		<table class="search_in" border="0">
	<!-- | -->			<tr class="h23">
	<!-- | -->				<td width="78">Period</td>
	<!-- | -->				<td width="223"><input type="text" name="fm_dt" style="width:70" caption="Date" dataformat="ymd" maxlength="10" size="10" >&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">&nbsp;~&nbsp;<input type="text" name="to_dt" style="width:70" caption="Date" dataformat="ymd" maxlength="10" size="10" >&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"></td>
							
							</td><td width="10"></td>
	<!-- | -->				<td width="80">Origin Yard</td>
	<!-- | -->				<td width="200">
								<input type="hidden" name="org_yd_cd"/>
	<!-- | -->					<input caption="Origin Yard" class="input1" required name="search_fm_loc" type="text" style="width:56;" maxlength="5" onChange="getComboList(this, document.form.search_fm_yard, 'F');" onBlur=""  >
	<!-- | -->					<script language="javascript">ComComboObject('search_fm_yard', 1, 48, 0, 1)</script><img src="" width="2" hight="1"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_frmnode">
	<!-- | -->				</td>
	<!-- | -->				</td><td width="10"></td>
	<!-- | -->				<td width="73" title="VVD Code">VVD Code</td>
	<!-- | -->				<td width="116">
	<!-- | -->					<input type="text" size="13" name="vvd_cd" style="width:75;" dataformat="uppernum">
								<img src="img/btns_search.gif" name='btn_vvd' width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
	<!-- | -->				</td>
	
							</td><td width="10"></td>
	<!-- | -->				<td width="77" title="Bound">Bound</td>
	<!-- | -->				<td width="104" title="Bound">
	<!-- | -->					<%=selBOUND%>
	<!-- | -->				</td>
	<!-- | -->			</tr>
	<!-- | -->		</table>
	
	<!-- | -->		<table class="search_in" border="0" style="width: 979;">
						<tr class="h23">
	<!-- | -->				<td width="76">Booking No.</td>
	
	<!--						<td width="240"><input type="text" size="20" name="bkg_no"></td> -->
	
	<!-- | -->				<td class="stm" style="padding-left:2" width="225">
	<!-- | -->					<input type="text" name="bkg_no" maxlength="" size="10"  style="width:135;" class="input" dataformat="uppernum">&nbsp;
	<!-- | -->					<img src="img/btns_multisearch.gif"	name="btn_bkg_no" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" >
	<!-- | -->				</td>
	
							</td><td width="10"></td>
	<!-- | -->				<td width="75">CNTR No.</td>
	<!-- 	 				<td width="158"><input type="text" size="24" name="cntr_no">	-->
	<!-- | -->				<td class="stm" style="padding-left:2" width="205">
	<!-- | -->					<input type="text" name="cntr_no" maxlength="" size="10"  style="width:135;" class="input" dataformat="uppernum">&nbsp;
	<!-- | -->					<img src="img/btns_multisearch.gif"	name="btn_cntr_no" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" >
	<!-- | -->				</td>
					
	<!-- | -->				</td><td width="5"></td>
	<!-- | -->				<td width="75" title="CNTR Type">CNTR Type</td>
	<!-- | -->				<td width="117" title="CNTR Type">
	<!-- | -->					<select class="input" style="width:100;" name="eq_tp_sz_cd" caption="CNTR Type">
	<!-- | -->						<option value="" selected></option>
	<!-- | -->						<option value="R2" >R2</option>
	<!-- | -->						<option value="R4" >R4</option>
	<!-- | -->						<option value="R5" >R5</option>
	<!-- | -->						<option value="R7" >R7</option>
	<!-- | -->						<option value="R8" >R8</option>
	<!-- | -->						<option value="R9" >R9</option>
	<!-- | -->					</select>
	<!-- | -->				</td>
							</td><td width="10"></td>
	<!-- | -->				<td width="77" title="MVMT Leg" >MVMT Leg</td>
	<!-- | -->				<td width="104" title="MVMT Leg" >
	<!-- | -->					<select class="input1" style="width:92;" name="mvmt_leg" required caption="MVMT Leg">
	<!-- | -->						<option value="" selected>&lt;Select&gt;</option>
	<!-- | -->						<option value="MTOP" >MT-OP</option>
	<!-- | -->						<option value="ICID" >IC-ID</option>
	<!-- | -->						<option value="ICTN" >IC-TN</option>
	<!-- | -->						<option value="ICEN" >IC-EN</option>
	<!-- | -->						<option value="OCVL" >OC-VL</option>
	<!-- | -->						<option value="OCTN" >OC-TN</option>
	<!-- | -->						<option value="OCEN" >OC-EN</option>
	<!-- | -->						<option value="TSVL" >TS-VL</option>
	<!-- | -->						<option value="TSTN" >TS-TN</option>
	<!-- | -->						<option value="TSEN" >TS-EN</option>
	<!-- | -->					</select>
	<!-- | -->				</td>
	<!-- | -->			</tr>
	<!-- | -->		</table>
	<!-- | -->
	<!-- | -->		<table class="search_in" border="0" style="width: 979;">
	<!-- | -->			<tr class="h23">

						<td>
						<table class="sm" border="0" style="height:20;">
	<!-- | -->					<td width="793"></td>
		<!-- | -->				<td width="95"><input type="radio" name="days" value="D" style="border:0;" checked>Calendar Day</td>
		<!-- | -->				<td width="91"><input type="radio" name="days" value="H" style="border:0;">24 Hour</td>
						</table>
						</td>
	<!-- | -->			</tr>
	<!-- | -->		</table>
	<!-- | -->
	<!-- | -->
	<!-- | -->
	<!-- | -->	</td></tr></table>
	<!-- |______________________________________________ End Search Option -->


	<table class="height_10"><tr><td></td></tr></table>

	<!-- ______________________________________________ Start Result Grid -->
	<!-- | -->
	<!-- | -->	<table class="search"><tr><td class="bg">
	<!-- | -->
	<!-- | -->		<table width="100%" id="mainTable">
	<!-- | -->			<tr>
	<!-- | -->				<td>
	<!-- | -->					<script language="javascript">ComSheetObject('sheet1');</script>
	<!-- | -->				</td>
	<!-- | -->			</tr>
	<!-- | -->		</table>
	<!-- | -->
	<!-- | -->	</td></tr></table>
	<!-- |______________________________________________ End Result Grid -->



    </td></tr>
</table>
<!-- Outer Table (E)-->


</form>
</body>
</html>