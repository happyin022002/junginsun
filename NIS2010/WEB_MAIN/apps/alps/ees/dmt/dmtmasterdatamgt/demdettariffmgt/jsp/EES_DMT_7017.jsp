<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EES_DMT_7017.jsp
*@FileTitle : Inactive Authority Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.27
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2015.01.27 이성훈
* 1.0 Creation 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.util.log4j.StringUtils"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event.EesDmt7017Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt7017Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	 = "";
	String strUsr_nm	 = "";
	String strOfc_cd	 = "";
	String strRhq_ofc_cd = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.DMTMasterDataMgt.DemDetTariffMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id 	  = account.getUsr_id();
		strUsr_nm 	  = account.getUsr_nm();
		strOfc_cd 	  = account.getOfc_cd();
		strRhq_ofc_cd = account.getRhq_ofc_cd();


		event = (EesDmt7017Event)request.getAttribute("Event");
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
<title>Inactive Authority Setup</title>
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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="usr_id" value="<%=strUsr_id%>" />
<input type="hidden" name="usr_ofc_cd" value="<%=strOfc_cd%>" />
<input type="hidden" name="usr_rhq_ofc_cd" value="<%=strRhq_ofc_cd%>" />
<input type="hidden" name="rhq_ofc_cd" value="" />
<input type="hidden" name="chg_delt_ofc_cd" value="" />
<input type="hidden" name="aft_bkg_ofc_cd" value="" />
<input type="hidden" name="tab_order">

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
	
		<table class="search" style="margin-bottom: 10px;"> 
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="50" align="left">RHQ</td>
					<td width="100" class="stm"><script language="javascript">ComComboObject('comboRHQ', 2, 90 , 0, 1, 0, true)</script></td>
					<td width="20"> </td>
					<td width="50" align="left">Office</td>
					<td width="280" class="stm"><script language="javascript">ComComboObject('comboOffice', 2, 250 , 0, 1, 0, true)</script>&nbsp;<img src="img/btns_multisearch.gif"width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
					<td width="">&nbsp; </td>
				</tr> 
				</table>
				<table class="search_sm2" border="0" style="width:520;">
				<tr class="h23">
					<td width="70">&nbsp;Validity</td>
					<td width="100" class="stm"><input type="checkbox" name="crnt_flg" value="Y" class="trans" checked>&nbsp;Current</td>
					<td width="100" class="stm"><input type="checkbox" name="tobe_flg" value="Y" class="trans" checked>&nbsp;To-be</td>
					<td width="800" class="stm" colspan="2"><input type="checkbox" name="exp_flg" value="Y" class="trans">&nbsp;Expired</td>
				</tr>				
				</table>
				</td>
			</tr>
		</table>
		<!--  biz_1  (E) -->
								
<!-- 				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table> -->
				
		<!-- Tab (S) -->
   		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
			<tr>
				<td width="100%">
					<script language="javascript">ComTabObject('tab1')</script>
				</td>
			</tr>
		</table>
		<!-- Tab (E) -->
		
		<!-- Tab1 (S) -->
		<div id="tabLayer" style="display:inline">
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
				<!-- Grid  (E) -->
				
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
					<td width="">
				<!--  Button_Sub (S) -->
				<table width="100%" class="button"> 
	       			<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_RowAdd">Row Add</td>
							<td class="btn2_right"></td></tr>
							</table></td>
							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_Delete">Row Delete</td>
							<td class="btn2_right"></td></tr>
							</table></td>
							</tr>
						</table>
					</td></tr>
				</table>
					<!-- Button_Sub (E) -->
				</td>
			</tr>
			</table> 
		
			<!-- : ( Search Options ) (E) -->
			<!-- biz_4 (E) -->
					
			</td></tr>
			</table>
		</div>
		<!-- Tab1 (E) -->
		
		<!-- Tab2 (S) -->
		<div id="tabLayer" style="display:none;">
			<table class="search"> 
       		<tr><td class="bg">
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>	
				<!-- Grid  (E) -->
				
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
					<td width="">
				<!--  Button_Sub (S) -->
				<table width="100%" class="button"> 
	       			<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_RowAdd">Row Add</td>
							<td class="btn2_right"></td></tr>
							</table></td>
							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_Delete">Row Delete</td>
							<td class="btn2_right"></td></tr>
							</table></td>
							</tr>
						</table>
					</td></tr>
				</table>
					<!-- Button_Sub (E) -->
				</td>
			</tr>
			</table> 
		
			<!-- : ( Search Options ) (E) -->
			<!-- biz_4 (E) -->
					
			</td></tr>
			</table>
		</div>
		<!-- Tab2 (E) -->
		
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr>
       		<td class="btn1_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    	<tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" id="btn_Retrieve" name="btn_Retrieve">Retrieve</td>
							<td class="btn1_right"></td>
							</tr>
							</table>
						</td>	
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" id="btn_New" name="btn_New">New</td>
							<td class="btn1_right"></td>
							</tr>
							</table>
						</td>	
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_Save">Save</td>
							<td class="btn1_right"></td>
							</tr>
							</table>
						</td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_DownExcel">Down Excel</td>
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
	</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>

</body>
</html>