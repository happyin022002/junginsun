<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0078.jsp
*@FileTitle : Time of SPCL CGO Request APVL
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.14
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.12.14 김현욱
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
<%@ page import="com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg0078Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0078Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList    = "";
	String pageRows    = "100";

	String strUsr_id   = "";
	String strUsr_nm   = "";
	Logger log = Logger.getLogger("com.hanjin.apps.CargoLoadingApproval.OwnDangerousCargoApproval");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg0078Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Time of SPCL CGO Request APVL</title>
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
<input type="hidden" name="params">

<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr>
		<td valign="top">
			<!--top menu (S)-->
			<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!--Page Title, Historical (E)-->	
			<!--biz page (S)-->
			<!-- 1 (S) -->
			<table class="search">
		       	<tr>
		       		<td class="bg">
						<!--  biz_1  (S) -->
						<table class="search" border="0" style="width:979;">
							<tr class="h23">
								<td width="60">&nbsp;RSO</td>
								<td width="265" style="padding-left:4">
							   		<script language="javascript">ComComboObject('rgn_shp_opr_cd', 2, 81, 1, 1);</script>
								</td>
								<td width="272" colspan="4">
									<table class="search_sm2" border="0" style="width:320;" >
										<tr class="h23">
											<td width="57">Option 1</td>
											<td class="stm">&nbsp;
												<input type="radio" name="option_pending" value="Y" class="trans" checked>&nbsp;Incl. Pending&nbsp;&nbsp;
												<input type="radio" name="option_pending" value="N" class="trans">&nbsp;Excl. Pending
											</td>
										</tr>
									</table>								
								</td>
								<td width="" colspan="4">
									<table class="search_sm2" border="0" style="width:300;" >
										<tr class="h23">
											<td width="57">Option 2</td>
											<td class="stm">&nbsp;&nbsp;
												<input type="radio" name="option_post_vvd" value="I" class="trans">&nbsp;Incl. Post VVD&nbsp;&nbsp;
												<input type="radio" name="option_post_vvd" value="E" class="trans" checked>&nbsp;Excl. Post VVD
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr class="h23">
								<td width="60">&nbsp;Period</td>
								<td width="265" style="padding-left:3"><input type="text" name="from_rqst_dt" style="width:80" class="input1" value="<%=DateTime.addMonths(DateTime.getYear()+"0101",(((int)Math.ceil((float)DateTime.getMonth()/3)-1)*2+((int)Math.ceil((float)DateTime.getMonth()/3)-1)))%>" dataformat="ymd" maxlength="8">&nbsp;~&nbsp;<input type="text" name="to_rqst_dt" style="width:80" class="input1" value="<%=DateTime.getFormatDate(new java.util.Date(),"yyyyMMdd")%>" dataformat="ymd" maxlength="8">&nbsp;<img src="img/btns_calendar.gif" name="btn_Calendar" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
								<td width="272" colspan="4">&nbsp;Processing Time Setting (hours)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="proc_hour" style="width:40;text-align:right;" class="input1" value="24" caption="Processing Time Setting (hours)" required dataformat="engup" style="ime-mode:disabled"></td>
								<td width="30">&nbsp;Term</td>
								<td width="60"><script language="javascript">ComComboObject('term', 1, 85, 0, 0, 0, false);</script></td>
								<td width="60">&nbsp;USR ID</td>
								<td width=""><input type="text" name="auth_usr_id" style="width:110" class="input" value="" caption="" maxlength="" dataformat="" style=""></td>
								<!-- <td width=""><input type="text" name="slan_cd" style="width:45" class="input" value="" fullfill caption="Lane" maxlength="3" dataformat="engup" style="ime-mode:disabled"></td> -->
							</tr>
							<tr class="h23">
								<td width="320" colspan="2">
									<table  class="search_sm2" border="0" style="width:302;" >
										<tr class="h23">
											<td width="60">VSL OPR</td>
											<td class="stm">
												<input type="radio" name="crr_cd" value="" class="trans" checked>&nbsp;All&nbsp;&nbsp;
												<input type="radio" name="crr_cd" value="SML" class="trans">&nbsp;SML&nbsp;&nbsp;
												<input type="radio" name="crr_cd" value="NOTSML" class="trans">&nbsp;Others
												<!-- <input type="text" name="cgo_opr_cd" id="cgo_opr_cd" style="width:40" class="input" value="" caption="VSL OPR" maxlength="4" dataformat="engup" style="ime-mode:disabled">&nbsp;<img src="img/btns_search.gif" name="btn_Carrier" id="btn_Carrier" width="19" height="20" alt="" border="0" align="absmiddle" class="">  -->											
											</td>
										</tr>
									</table>
								</td>
								<td width="40">&nbsp;Lane</td>
								<td width="90"><input type="text" name="slan_cd" style="width:45" class="input" value="" fullfill caption="Lane" maxlength="3" dataformat="engup" style="ime-mode:disabled">&nbsp;<img src="img/btns_search.gif" name="btn_SlanCd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
								<td width="52">VVD CD</td>
								<td width="167"><input type="text" name="vsl_cd" style="width:40" class="input" value="" fullfill caption="VVD CD" maxlength="4" dataformat="engup" style="ime-mode:disabled">&nbsp;<input type="text" name="skd_voy_no" style="width:40" class="input" value="" fullfill caption="VVD CD" maxlength="4" dataformat="engup" style="ime-mode:disabled">&nbsp;<input type="text" name="skd_dir_cd" style="width:25" class="input" value="" fullfill caption="VVD CD" maxlength="1" dataformat="engup" style="ime-mode:disabled">&nbsp;<img src="img/btns_search.gif" name="btn_VVDpop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
								<td width="" colspan="4">&nbsp;SPCL CGO Type&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<script language="javascript">ComComboObject('scg_flg', 1, 85, 1, 0, 0, true);</script></td>
								<!-- <td width=""><script language="javascript">ComComboObject('scg_flg', 1, 85, 1, 0, 0, true);</script></td> -->
							</tr>
						</table>
						<!--  biz_1   (E) -->
					</td>
				</tr>
			</table>

			<table class="height_8"><tr><td></td></tr></table>	

			<table class="search" id="mainTable"> 
      			<tr>
      				<td class="bg" valign="top">
						<!-- Grid - 1 (S) -->
						<table width="100%" class="search"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table> 			
						<!-- Grid - 1 (E) -->	
	
						<!--  Button_Sub (S) -->
						<table class="search" border="0" style="width:100%;">
							<tr class="h23">
								<td width="100%" align="right">
									<table width="100%" class="button">
						       			<tr>
						       				<td class="btn2_bg">
												<table border="0" cellpadding="0" cellspacing="0">
													<tr>
														<td width="">
															<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr>
																	<td class="btn2_left"></td>
																	<td class="btn2" name="btn_downExcel">Down Excel</td>
																	<td class="btn2_right"></td>
																</tr>
															</table>
														</td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!-- 2 (E) -->		
			
			<!--Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;"> 
       			<tr>
       				<td class="btn1_bg">		
					    <table border="0" cellpadding="0" cellspacing="0">
					    	<tr>
					    		<td>
					    			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_retrive" id="btn_Retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_new">New</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Detail">Detail</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
    		<!--Button (E) -->	
		
			<!--biz page (E)-->

		</td>
	</tr>
</table>	
<!--Detail Information Component (S) -->
<script language="javascript">ComSheetObject('sheet2');</script>
<!--Detail Information Component (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>