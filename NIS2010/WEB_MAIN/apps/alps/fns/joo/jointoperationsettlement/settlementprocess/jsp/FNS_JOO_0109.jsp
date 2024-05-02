<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_joo_0109.jsp
*@FileTitle : Movement Event Date Setting
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.10
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.08.10 민정호
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.event.FnsJoo0109Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
FnsJoo0109Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd = "";
	Logger log = Logger.getLogger("com.hanjin.apps.JointOperationMasterDataMgt.JointOperationMasterDataMgt");
	
	String trdCombo  = "";
	String laneCombo = "";
	String currCombo = "";
	String joStlOptCd = "";
	String joStlOptNm = "";
 	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
	   
		event = (FnsJoo0109Event)request.getAttribute("Event");
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
<title>Entry and Inquiry of Financial Affairs</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage("<%=trdCombo%>","<%=currCombo%>");
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="cntr_no">
<input type="hidden" name="cnmv_yr">
<input type="hidden" name="cnmv_id_no">
<input type="hidden" name="mvmt_sts_cd">
<input type="hidden" name="cnmv_evnt_dt">
<input type="hidden" name="vsl_cd">
<input type="hidden" name="skd_voy_no">
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="yd_cd">
<input type="hidden" name="in_pol_cd">
<input type="hidden" name="in_pol_yd_cd">
<input type="hidden" name="clpt_ind_seq">
<input type="hidden" name="pol_split_no">
<input type="hidden" name="vvd">
<input type="hidden" name="inp_yd_cd">
<input type="hidden" name="clpt_ind_seq2">
<input type="hidden" name="slane">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
<!--Page Title, Historical (S)-->   
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">   
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>   
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>   
    </table>   
<!--Page Title, Historical (E)-->  	
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
	              <tr class="h23">
						<td width="50">&nbsp;&nbsp;VVD</td>
						<td width="150"><input type="text" style="width:100;" name="in_vvd_cd" class="input1" value="" dataformat="uppernum" style="ime-mode:disabled" maxlength="9"></td>
						<td width="50">&nbsp;&nbsp;YARD</td>
						<td width="250"><script language="javascript">ComComboObject('rob_port_cd',6,100,0,0);</script>&nbsp;&nbsp;<input type="text" style="width:100;" name="in_pol_yd" class="input" value="" dataformat="engupspecial" style="ime-mode:disabled" readonly></td>
						<td width="50">&nbsp;&nbsp;Calling</td>
						<td width="*"><script language="javascript">ComComboObject('acct_cd2', 1, 70, 0, 0);</script></td>
						<td width="100">&nbsp;&nbsp;Lane Code</td>
						<td width="150"><input type="text" style="width:100;" name="in_slan_cd" class="input1" value="" dataformat="uppernum" style="ime-mode:disabled" maxlength="5"></td>																	
	              </tr>
				</table>								
				<!--  biz_1   (E) -->				
				</td></tr>
			</table>			
			<table class="height_10"><tr><td colspan="8"></td></tr></table>		
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
			<!--  Button_Sub (S) -->
	    	<!-- Button_Sub (E) -->						
			<table class="line_bluedot"><tr><td></td></tr></table>			
			<!-- Grid  (S) -->
							<table width="100%"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet2');</script>
									</td>
								</tr>
							</table>
			<!-- Grid (E) -->
			<!--  Grid_button (S) -->
			<!--  Button_Sub (S) -->
	    	<!-- Button_Sub (E) -->
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,"> 
		<tr>
			<td class="btn1_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    	<tr>
			    		<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_call_batch" id="btn_call_batch" auth="R">Call Batch</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<!-- 
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_call_batch_all" id="btn_call_batch_all" auth="R">Call Batch All</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						 -->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_retrieve" id="btn_retrieve" auth="R">Retrieve</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_set" id="btn_set" auth="C">Setting</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>				
						<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_new" id="btn_new" auth="R">New</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						    <td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_save" id="btn_save" auth="C">Save</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
					</tr>
				</table>
	<!--Button (E) -->
			</td>
		</tr>
	</table>
</td></tr>
</table>
<!-- Copyright (S) -->
<!-- Copyright(E)-->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>