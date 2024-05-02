<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0668_07.jsp
*@FileTitle : In-bound C/S Screen US
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 안진응
*@LastVersion : 1.0
* 2009.12.16 안진응
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg066807Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg066807Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.CsScreenMgtSC.CsScreenBC");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd =	account.getOfc_cd();
	   
		event = (EsmBkg066807Event)request.getAttribute("Event");
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
<title>Inbound C/S Screen US</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var strUsr_id    = "<%=strUsr_id%>";
    var strOfc_cd    = "<%=strOfc_cd%>";
    
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
<div id="blLayer" style="position:absolute; background-color:#ffffff; width:130px; visibility: hidden; overflow-y:auto; overflow-x:hidden; z-index:1000; border-width:1; border-color:black; border-style:solid;"></div>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 개발자 작업	-->
<input type='hidden' name ='xmlData' value = "">
<input type='hidden' name ='bl_no' value = "<%=JSPUtil.getNull(request.getParameter("bl_no"))%>">
<input type='hidden' name ='bkg_no' value = "<%=JSPUtil.getNull(request.getParameter("bkg_no"))%>">
<input type='hidden' name ='h_mov_cntr_no' value = "">
<input type='hidden' name ='h_mrd_id' value = "">
<input type='hidden' name ='h_local_lang_flg' value = "">
<!-- Ivoce Bil_Amt Total-->
<input type='hidden' name ='invTotBilAmt'>
<input type='hidden' name ='h_old_bl_no' value = "">
<input type='hidden' name ='h_old_bkg_no' value = "">
<!-- RD 부분  -->
<input type="hidden" name="com_mrdPath" value="">
<input type="hidden" name="com_mrdArguments" value="">
<!-- 
<input type="hidden" size="200" name="com_mrdSaveDialogDir" value="">
<input type="hidden" size="200" name="com_mrdSaveDialogFileName" value="">
<input type="hidden" size="200" name="com_mrdSaveDialogFileExt" value="">
<input type="hidden" size="200" name="com_mrdSaveDialogFileExtLimit" value="">
-->
<input type="hidden" name="com_mrdTitle" value="">
<input type="hidden" name="com_mrdDisableToolbar" value=""> 
<input type="hidden" name="com_mrdBodyTitle" value="">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<!--TAB Pickup -->
<div id="tabLayer" style="display:none">

		<!-- Grid BG Box (S)-->
		<table class="search" id="mainTable"> 
   		<tr><td class="bg">	
			
			<!--  biz_2 (S) -->
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="110">
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Consignee Code</td></tr>
				</table>
				<td width="110"><input type="text" style="width:70;" class="input2" value="" name = "frm_t7sheet1_cust_cd_c" readonly="true"></td>
				<td width="40">Name</td>
				<td width="315"><input type="text" style="width:260;" class="input2" value="" name = "frm_t7sheet1_cust_nm_c" readonly="true"></td> 
				<td width="40">Address</td>
				<td width=""><input type="text" style="width:100%;" class="input2" value="" name = "frm_t7sheet1_cust_addr_c" readonly="true"></td>
				</table>			
				<!--  biz_2  (E) -->
				
	
				<!-- Tab (S) -->
	     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
	       		<tr><td width="100%">
					<script language="javascript">ComTabObject('t7tab1')</script>
					</td></tr>
				</table>								
				<!-- Tab (E) -->
				
				<!--TAB  (S) -->				
				<table class="search"> 
		       	<tr><td class="bg">
				
					<!-- Grid  (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('t7sheet1');</script>
									</td>
							</tr>
						</table>
						
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">			
									<script language="javascript">ComSheetObject('t7sheet2');</script>
									</td>
							</tr>
						</table>
							
					</td></tr>
				</table>
				<!--TAB  (E) -->
				
				<table class="height_8"><tr><td></td></tr></table>
				<!--  biz_2 (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
			
				<td width="110">
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Notify Code</td></tr>
				</table>
				</td>
				<td width="110"><input type="text" style="width:70;" class="input2" value="" name = "frm_t7sheet1_cust_cd_n" readonly="true"></td>
				<td width="40">Name</td>
				<td width="315"><input type="text" style="width:260;" class="input2" value="" name = "frm_t7sheet1_cust_nm_n" readonly="true"></td> 
				<td width="40">Address</td>
				<td width=""><input type="text" style="width:360;" class="input2" value="" name = "frm_t7sheet1_cust_addr_n" readonly="true"></td>
				</tr>
			</table>			
			<!--  biz_2  (E) -->	
				
				
			<!-- Tab (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       		<tr><td width="100%">
				<script language="javascript">ComTabObject('t7tab2')</script>
				</td></tr>
			</table>

			<!-- Tab (E) -->
			<table class="search"> 
	       	<tr><td class="bg">
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">									
							<script language="javascript">ComSheetObject('t7sheet3');</script>
						</td>
					</tr>
				</table>
			</td></tr>
			</table>

			<table class="height_8"><tr><td></td></tr></table>

			<!--  biz_2 (S) -->
			<table class="search" border="0" style="width:100%;"> 
			<tr class="h23">
			
				<td width="110">
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">A. Notify Code</td></tr>
				</table>
				</td>
				<td width="110"><input type="text" style="width:70;" class="input2" value="" name = "frm_t7sheet1_cust_cd_a" readonly="true"></td>
				<td width="110">Name & Address</td>
				<td width=""><input type="text" style="width:100%;" class="input2" value="" name = "frm_t7sheet1_cust_nm_a" readonly="true"></td> 
				
				</tr>
			</table>			
			<!--  biz_2  (E) -->
			
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t7TemplateAuto">Template (Auto)</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t7TemplateManual">Template (Manual)</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>

					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t7SendManual">Send (Manual)</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>

					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t7Preview">Preview</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>

					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			</td>
					</tr>
				</table>
			
		<!-- Grid BG B	ox (E)-->

	<table class="height_10"><tr><td colspan="8"></td></tr></table>
		

</div>
<!--TAB Customer Insert info (E) --> 	


<!-- ************************************************************************************************** -->


<!--TAB  (S) -->
<div id="tabLayer" style="display:none">


<!--TAB  (E) --> 	


<!-- ************************************************************************************************** -->
	
	<!--biz page (E)-->
			</div>

<!-- 개발자 작업  끝 -->
</table>
</form>
</body>
</html>