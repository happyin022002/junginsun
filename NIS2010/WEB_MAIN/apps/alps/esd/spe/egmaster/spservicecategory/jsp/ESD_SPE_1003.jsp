<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESD_SPE_1003.jsp
*@FileTitle : S/P Service Category Confirm
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.21
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.01.21 백형인
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
<%@ page import="com.hanjin.apps.alps.esd.spe.egmaster.spservicecategory.event.EsdSpe1003Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdSpe1003Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (EsdSpe1003Event)request.getAttribute("Event");
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
<title>S/P Service Category Confirm</title>
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
<input type="hidden" name="code_key">
<input type="hidden" name="pagerows">
<input type="hidden" name="chk_type">
<input type="hidden" name="s_sp_grp_ofc_cd">
<input type="hidden" name="f_ctrt_ofc_cd">
<input type="hidden" name="sp_seq">
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
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_new" >New</td>
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
				<td width="110">Regional Group</td>
				<td width="100" style="padding-left:1;">
					<script language="javascript">ComComboObject('s_eg_rhq_cd',1,100,0,1,0);</script>
				</td>
				
				<td width="20"></td>
				
				<td width="100">Control Office</td>
				<td width="100" style="padding-left:1;" >
					<script language="javascript">ComComboObject('s_eg_ofc_cd',1,100,0,0,0);</script>
				</td>
				
				<td width="20"></td>
				
				<td width="100">Contract Office</td>
				<td width="100" style="padding-left:1;">
					<input name="s_ctrt_ofc_cd" dataformat ="engup" type="text" style="width:50; text-align:left;" class="input">
					<img class="cursor" src="img/btns_search.gif" width="20" height="20" border="0" align="absmiddle" name="btn_ctrt_ofc_cd">
									
				</td>

									
				<td width="319"></td>
				
			</tr>
			</table>
			<table class="search" border="0"  style="width: 979;" >
			<tr class="h23">
			
				<td width="110">S/P Code</td>
				<td width="80" align="left">
					<input name="s_sp_seq" type="text" style="width:50; text-align:right;" class="input">
					<img class="cursor" src="img/btns_search.gif" width="20" height="20" border="0" align="absmiddle" name="btn_vndr_seq">
				</td>
				<td width="200">
					<input name="s_sp_nm" type="text" style="width:200; text-align:left;" class="input2" readonly="readonly">
				</td>
							
				<td width="20"></td>
				
				<td width="209" class="stm" style="font-size:12;">
					<input type="checkbox" class="trans" name="s_chk_all" onClick="chkClickEvn('s_chk_all')">All&nbsp;&nbsp;
					<input type="checkbox" class="trans" name="s_chk_map" onClick="chkClickEvn('s_chk_map')" checked>Mapped&nbsp;&nbsp;
					<input type="checkbox" class="trans" name="s_chk_unmap" onClick="chkClickEvn('s_chk_unmap')">UnMapped&nbsp;&nbsp;
				</td>				
					
				<td width="369"></td>
				
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