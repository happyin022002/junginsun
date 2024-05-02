<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESD_SPE_1008.jsp
*@FileTitle : Evaluation Group Mapping & Basic Evaluation
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.22
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.01.22 백형인
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
<%@ page import="com.hanjin.apps.alps.esd.spe.egmapping.evaluationgroupmapping.event.EsdSpe1008Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdSpe1008Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String usr_id 					= "";
	String strUsr_nm				= "";
	String ofc_cd					= "";
	String rhq_ofc_cd				= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SpeMst.SPServiceCategoryConfirm");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_nm 			= account.getUsr_nm();
		usr_id       		= account.getUsr_id();      
		ofc_cd      		= account.getOfc_cd();    
		rhq_ofc_cd      	= account.getRhq_ofc_cd(); 


		event = (EsdSpe1008Event)request.getAttribute("Event");
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
<title>Evaluation Group Mapping & Basic Evaluation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(year){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage(year);
	}
</script>
</head>

<body onLoad="setupPage('<%=DateTime.getYear()%>');">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="code_key">
<input type="hidden" name="pagerows">
<input type="hidden" name="sp_seq">
<input type="hidden" name="chk_type">
<input type="hidden" name="vndr_cd">
<input type="hidden" name="ev_svc_cate_cd">
<input type="hidden" name="g_eg_id">
<input type="hidden" name="g_sp_seq">
<input type="hidden" name="g_ev_yr">
<input type="hidden" name="log_usr_id" value="<%=usr_id%>">
<input type="hidden" name="eg_rhq_cd" value="<%=rhq_ofc_cd%>">
<input type="hidden" name="eg_ofc_cd" value="<%=ofc_cd%>">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr>
	<td valign="top">	
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->

			
		<!--Button (S) -->
	    <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 0; padding-bottom: 2;">
		<tr>
			<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_save">Save</td>
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
		 
		<!--biz page (S)-->
		<table class="search" > 
       	<tr><td class="bg">		
			<!-- biz_1  (S) -->
			<table class="search" border="0"  style="width: 979;" >
			<tr class="h23">
				<td width="48">Year</td>
				<td width="110" style="padding-left:1;">
					<input type="text" style="width:50; text-align: center" class="input" name="s_ev_yr" maxlength="4" required fullfill minnum="1900" maxnum="2050" caption="Year">
					<img class="cursor" src="img/btns_calendar.gif" width="20" height="20" border="0" align="absmiddle" name="btn_audit_month">
				</td>
				<td width="27"></td>
				
				<td width="70">Evaluation</td>
				<td width="209" class="stm" style="font-size:12;">
					<input type="checkbox" class="trans" name="s_chk_all" onClick="chkClickEvn('s_chk_all')" checked="checked">All&nbsp;&nbsp;
					<input type="checkbox" class="trans" name="s_chk_map" onClick="chkClickEvn('s_chk_map')">Yes&nbsp;&nbsp;
					<input type="checkbox" class="trans" name="s_chk_unmap" onClick="chkClickEvn('s_chk_unmap')">No&nbsp;&nbsp;					
				</td>				
					
				<td width="515"></td>
				
			</tr>
			</table>

			
			<table class="search" border="0"  style="width: 979;" >
				<tr class="h23">
					<td width="50">Level 1</td>
					<td width="100" style="padding-left:1;">
						<script language="javascript">ComComboObject('s_eg_rhq_cd',1,100,0,1,0);</script>
					</td>
						
					
					<td width="35"></td>
					
					<td width="50">Level 2</td>
					<td width="100" style="padding-left:1;">
						<script language="javascript">ComComboObject('s_eg_ofc_cd',1,100,0,1,0);</script>
					</td>
					<td width="35"></td>
					
					<td width="50">Level 3</td>
					<td width="160" style="padding-left:1;">
						<script language="javascript">ComComboObject('s_ev_svc_cate_cd',2,160,0,1,1);</script>
					</td>
						
					<td width="399"></td>
					
				</tr>
			</table>			
										
			</td>
		</tr>
	</table>


	<table class="height_5"><tr><td></td></tr></table>
	<!-- Grid BG Box  (S) -->
	<table class="search" id="mainTable">
	 	<tr><td class="bg" valign="top">
		<!-- Grid  (S) -->
		<table width="100%"  id="mainTable"> 
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
				</td>
			</tr>
		</table> 
		<table width="100%"  id="mainTable"> 
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet2');</script>
				</td>
			</tr>
		</table> 
		
		<!-- Grid (E) -->
		<!--  Button_Sub (S) -->
		<table width="100%" class="button">
			<tr>
				<td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn2_left"></td>
									<td class="btn2" name="btn_RowAdd">Row&nbsp;Add</td>
									<td class="btn2_right"></td>
								</tr>
							</table>
						</td>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn2_left"></td>
									<td class="btn2" name="btn_RowDel">Row&nbsp;Delete</td>
									<td class="btn2_right"></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!-- Button_Sub (E) -->		
		</td></tr>
	</table>
<!-- Grid BG Box  (E) -->

		
<!-- 개발자 작업  끝 -->
			</td>
		</tr>
	</table>
</form>

</body>
</html>