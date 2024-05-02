<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1019.jsp
*@FileTitle : MTY BKG Route Setting 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 두기민
*@LastVersion : 1.0
* 2009.05.06 두기민
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
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtyroutesetting.event.EesEqr1019Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesEqr1019Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.EquipmentManagement.ContainerSpecMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		// save 버튼은 strOfc_cd 값이 SELOPE 이어야 한다. 2009.05.06. 김석준
		strOfc_cd = account.getOfc_cd();
	   
		event = (EesEqr1019Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		
	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String locSelectBox = JSPUtil.getCodeCombo("s_loc_grp_cd","","style='width:60;'","CD03052",0,"000001: :ALL");
%>
<html>
<head>
<title>Equipment Status Code Creation, Update & Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
		// Ofc_cd 지정.
		strOfcCd = "<%=strOfc_cd%>";

		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="p_rcc_cd">
<input type="hidden" name="plodg_dchg_div_cd">
<input type="hidden" name="p_loc_cd">
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
 	<!--Page Title, Historical (S)-->
 		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
 			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
 			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
 		</table>
 	<!--Page Title, Historical (E)-->
 	
 	<!-- TABLE '#D' : ( Button : Main ) (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
			<tr>
				<td class="btn1_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
									<td class="btn1_right"></td></tr>
							</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_new" id="btn_new">New</td>
									<td class="btn1_right"></td></tr>
							</table></td>
						<td class="btn1_line"></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_save" id="btn_save">Save</td>
									<td class="btn1_right"></td></tr>
							</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td>
									<td class="btn1_right"></td></tr>
							</table></td>
					</tr>
					</table>				
				</td>
			</tr>
			</table>
			<!-- TABLE '#D' : ( Button : Main ) (E) -->
	
	<!--biz page (S)-->
	<table class="search" border=0>
	<tr><td class="bg" style="height:516;" valign="top">	
		<table class="search" border="0" style="width:979;">
                        <tr>


					    <td>
						<table class="search_in" border="0" cellpadding="0" cellspacing="0" style="width:610;">
							<tr class="h23">		
								<td width="30">RCC</td>
								<td width="100"><script language="javascript">ComComboObject('s_rcc_cd' , 1, 80, 1 )</script></td>
								
								<td width="20">&nbsp;</td>					
					<td width="60" >Location</td>
					<td width="*">
					   <input type="text" class="input" name="s_loc_cd" dataformat="engup" size="5" maxlength="5" fulfill size="5" style="width: 53;" value="">
					</td>    											

							</tr>						
						</table>
					</td>
          </tr></table>
          
          <table class="line_bluedot"><tr><td></td></tr></table>
					
		<table class="search" border=0 style="width:979">
			<tr><td width="75%" style="padding-right:15; padding-top:0;" valign="top">		
		
		<!-- Grid BG Box  (S) -->

				<!-- Grid 1 (S) -->
				<table style="height:9;"><tr><td></td></tr></table>
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid 1(E) -->
				
				<!--  Button_Sub (S) -->
				<table width="100%" class="button"table border="0"> 
		       	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_add">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr>
					</table>
					
				</td></tr>
				</table>
		    	<!-- Button_Sub (E) -->			
			</td>	

			<td  valign="top">			
						
				<!--  biz_ (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td align="right"></td>
					</tr>
				<tr><td height="2"></td></tr>
				</table>
				<!--  biz_ (E) -->

				<!-- Grid 2 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				<!-- Grid 2(E) -->

				<!--  Button_Sub (S) -->
				<table width="100%" class="button"table border="0"> 
		       	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_tp_save">Save</td>
						<td class="btn2_right"></td>
						</tr>
					</tr>
					</table>
					
				</td></tr>
				</table>
		    	<!-- Button_Sub (E) -->			
			
				</td></tr>
		</table>	
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->

	
	</td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>