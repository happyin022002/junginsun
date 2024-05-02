<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0029.jsp
*@FileTitle : Delay&Skip Status
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.11
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.08.10 서창열
* 1.0 Creation
*
* History
* 2011.03.14 진마리아 CHM-201109291-01 Location Code(숫자포함)의 Validation 체크로직 수정
* 2011.04.11 진마리아 CHM-201109577-01 Delete Vessel Code에 대한 조회 로직 보완
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.event.VopVsk0029Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0029Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String header = "";
	Logger log = Logger.getLogger("com.hanjin.apps.ActualScheduleManagement.OnTimeResultAnalysis");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopVsk0029Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
		strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		//HEADER 정보 
		header = eventResponse.getETCData("header");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>SKD Status (Delay Status)</title>
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
<input type="hidden" name="headerVal" value="<%=header%>">
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="grp_flg_cd">
<input type="hidden" name="inc_del_vsl" value="Y">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle">&nbsp;<span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;<span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="75">Period</td>
					<td width="230">
						<input type="text" name="act_inp_fm_dt" dataformat="ym" caption="시작년월" maxlength="6" size="10" cofield="act_inp_fm_dt" style="width:60;text-align:center;" class="input1" value="" readonly="readonly">&nbsp;<img src="img/btns_calendar.gif" name="btns_calendar_s" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">&nbsp;~&nbsp;
						<input type="text" name="act_inp_to_dt" dataformat="ym"  caption="종료년월" maxlength="6" size="10" cofield="act_inp_to_dt" style="width:60;text-align:center;" class="input1" value="" readonly="readonly">&nbsp;<img src="img/btns_calendar.gif" name="btns_calendar_e" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					</td>
					<td width="210">
						<table class="search_sm2" border="0" style="width:180;"> 
						<tr class="h23">
							<td><input type="radio" name="lane_grp" class="trans" value="I" checked="checked">Individual &nbsp;&nbsp;&nbsp;<input type="radio" name="lane_grp" class="trans" value="G">Group</td>
						</tr>	
						</table>
					</td>
					<td width="80">Lane Code</td>
					<td width=""><input type="text" style="width:50;ime-mode:disabled;text-align:center" name="vsl_slan_cd" class="input" maxlength="3" dataformat="uppernum" value="">&nbsp;<img src="img/btns_search.gif" name="btns_search" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">&nbsp;
						<script language="javascript">ComComboObject('lane_grp_nm',1,70,1,1);</script>
						</td>
				</tr>	
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="75">Vessel Code</td>
					<td width="230"><input type="text" style="width:60;ime-mode:disabled;text-align:center" name="vsl_cd" class="input" maxlength="4" dataformat="uppernum" value="">&nbsp;<img src="img/btns_search.gif" name="btns_search2" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="35">Port</td>
					<td width="175"><input type="text" style="width:50;ime-mode:disabled;text-align:center" name="vps_port_cd" class="input" maxlength="5" dataformat="uppernum" value="">&nbsp;<img src="img/btns_search.gif" name="btns_search3" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>		
				
					<td width="80">Carrier Code</td>
					<td width=""><input type="text" style="width:50;ime-mode:disabled;text-align:center" name="crr_cd" class="input" maxlength="4" dataformat="engup" value="">&nbsp;<img src="img/btns_search.gif" name="btns_search4" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				</tr>	
				</table>
				
				</td>
			</tr>	
		</table>
				<!--  biz_1   (E) -->
				<table class="height_8"><tr><td></td></tr></table>
		<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%"> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1');</script>
						<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
					</td></tr>
			</table>
		<!-- Tab ) (E) -->

		
<!--TAB Delay Status (S) -->
<div id="tabLayer" style="display:inline">
		
	<table class="search"> 
       	<tr><td class="bg">
     	
				<!--  biz_2  (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="260">
						<table class="search_sm2" border="0" style="width:220;"> 
							<tr class="h23">
								<td width=""><input type="radio" name="ie_flg" class="trans" value="I" checked="checked">Inclusive&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="ie_flg" value="" class="trans" value="E">Exclusive</td> 
							</tr>
						</table>
					</td>
					<td width="50">Group</td>
					<td width=""><select style="width:100;" class="input1" name="grp_flg" onChange="delayChange();">
						<option value="P" selected="selected">Port</option>
						<option value="V">VSL</option>
						<option value="L">Lane</option>
						</select></td>
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
			<!-- Grid (E) -->

				<!--biz page (E)-->
	</td>
			</tr>
			</table>

</div>
<!--TAB Delay Status (E) -->


<!--TAB Skip Status (S) -->
<div id="tabLayer" style="display:none">

	<table class="search"> 
       	<tr><td class="bg">
     	
				<!--  biz_2  (S) -->
				
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="340">
						<table class="search_sm2" border="0" style="width:300;"> 
							<tr class="h23">
								<td width="40">SKIP</td>
								<td width="" class="stm"><input type="radio" name="port_skp_tp_cd" value="A" class="trans" checked="checked">All&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="port_skp_tp_cd" value="I" class="trans">Intended&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="port_skp_tp_cd" value="F" class="trans">Force Majeure</td> 
							</tr>
						</table>
					</td>
					<td width="50">Group</td>
					<td width=""><select style="width:100;" class="input1" name="grp_flg" onChange="skipChange();">
						<option value="P" selected="selected">Port(Skip)</option>
						<option value="V">VSL</option>
						<option value="L">Lane</option>
						<option value="R">Port(Reason)</option>
						</select></td>
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
				<!-- Grid (E) -->

				<!--biz page (E)-->
	</td>
			</tr>
			</table>

</div>
<!--TAB Skip Status (E) -->


<!--TAB Skip Change Status (S) -->
<div id="tabLayer" style="display:none">

	<table class="search"> 
       	<tr><td class="bg">
     	
				<!--  biz_2  (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					
					<td width="50">Group</td>
					<td width=""><select style="width:100;" class="input1" name="grp_flg" onChange="skipChangeStatus();">
						<option value="P" selected="selected">Port</option>
						<option value="V">VSL</option>
						<option value="L">Lane</option>
						</select></td>
				</tr>	
				</table>
				<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t3sheet1');</script>
					</td>
				</tr>
			</table>
				<!-- Grid (E) -->
						
				<!--biz page (E)-->
	</td>
			</tr>
			</table>

</div>
<!--TAB Skip Change Status (E) -->



	
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_Retrieve" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_VVDRMKs">VVD & Remark(s)</td>
					<td class="btn1_right"></td>
					</tr>
				</table>
			</td>
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DelayRSN">Delay Reason</td>
					<td class="btn1_right"></td>
					</tr>
				</table>
			</td>
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_GroupRegister">Group Registration</td>
					<td class="btn1_right"></td>
					</tr>
				</table>
			</td>
			
			</tr>
</table>	
    <!--Button (E) -->
	</td></tr>
</table>
</td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>