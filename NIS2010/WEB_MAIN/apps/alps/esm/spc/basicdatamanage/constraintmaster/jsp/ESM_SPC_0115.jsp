<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESM_SPC_0115.jsp
*@FileTitle : Constraint Mastertable
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.23
*@LastModifier : Seung-Man KIM
*@LastVersion : 1.0
* 2015.01.23 Seung-Man KIM
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
<%@ page import="com.hanjin.framework.core.controller.util.WebKeys"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.event.EsmSpc0115Event"%>
<%@ page import="com.hanjin.framework.core.view.template.Screen"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.apps.alps.esm.coa.common.Utils"%>

<%
	EsmSpc0115Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String screenName		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BasicDataManage.ConstraintMaster");
	//test 삭제요망
	String col_desc = Utils.iif(request.getParameter("col_desc")==null, "", request.getParameter("col_desc"));
    String col_nm   = Utils.iif(request.getParameter("col_nm")==null, "", request.getParameter("col_nm"));
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmSpc0115Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		log.debug("====================================");
		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
		screenName = screen.getName();
		log.debug("====================================");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Booking Allocation Master Table</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript" >
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		
		//test 삭제요망
		var col_desc = document.form.f_header.value;
        var col_nm = document.form.f_headernm.value;
        
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
		ComSetObjValue(document.form.screenName,"<%=screenName%>");
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="screenName" id="screenName">
<!-- 개발자 작업	-->
<input type="hidden" name="dirty_flag" id="dirty_flag">
<input type="hidden" name="ofc_cd"  id="ofc_cd">
<input type="hidden" name="ofc_ty" id="ofc_ty">
<input type="hidden" name="vvd_sig" id="vvd_sig">
<input type="hidden" name="f_header" id="f_header"  value="<%=col_desc%>">
<input type="hidden" name="f_headernm" id="f_headernm" value="<%=col_nm%>">
<!-- 추가 
<input type="hidden" name="dcgo_flg" id="dcgo_flg" value="">
<input type="hidden" name="rd_cgo_flg" id="rd_cgo_flg" value="">-->
<input type="hidden" name="tab_rhq_cd" id="tab_rhq_cd" value="">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
		<!--Page Title, Historical (S)-->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
        </table>
		<!--Page Title, Historical (E)-->
<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>	
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_excel">Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
		<!--biz page (S)-->
		
<table class="search" id="mainTable"> 
    <tr><td class="bg">	
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="50">Type</td>
				<td width="160" ><script language="javascript" >ComComboObject('bkg_aloc_tp_cd', 1, 100, 1, 0)</script></td>
				<td width="80">Rep. Trade</td>
					<td width="150">&nbsp;
						<script language="JavaScript">ComComboObject("trade", 2, 60, 0, 0);</script>
					</td>
					<td width="70">Sub Trade</td>
					<td width="130">&nbsp;
						<script language="JavaScript">ComComboObject("subtrade", 3, 50, 0, 0);</script>
					</td>
					<td width="45">&nbsp;Lane</td>
					<td width="140">
						<script language="JavaScript">ComComboObject("lane", 4, 80, 0, 0);</script>
					</td>
					<td width="50">Bound</td>
					<td width="140">&nbsp;
						<select name="bound" style="width:50;"></select>
					</td>
				<!-- 
				<td width="50">T.Lane</td>
				<td width=""><input type="text" name="trnk_slan_cd"  style="ime-mode:disabled;width:120px;" dataformat="engupnum" class="input"></td>
				<td width="50">S/C No.</td>
				<td width=""><input type="text" name="sc_no"  style="ime-mode:disabled;width:120px;" dataformat="engupnum" class="input"></td>
				<td width=120>Commodity Name</td>
				<td width=""><input type="text" name="cmdt_nm"  style="ime-mode:disabled;width:120px;" dataformat="engupnum" class="input"></td>
				 -->
			</tr>
			</table>
			
			
		</td></tr>
		</table>
		<!--biz page (E)-->
	<table class="height_8"><tr><td></td></tr></table>
		
	<!--biz page (S)-->
	
	<table class="search" id="mainTable"> 
 		<tr>
				<!-- Grid  (S) -->
				<table class="tab">
					<tr>
						<td><script language="javascript">ComTabObject('tab1')</script></td>
					</tr>
				</table>

			<div id="tabLayer" style="display:inline"><!-- TABLE '#D' : ( Search Options ) (S) -->
				<table class="search">
					<tr>
						<td class="bg">
						<!-- : ( POR ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet1');</script></td>
							</tr>
						</table>
						<!-- : ( POR ) (E) -->
						</td>
					</tr>
				</table>
				<!-- TABLE '#D' : ( Search Options ) (E) -->
			</div>

			<div id="tabLayer" style="display:none"><!-- TABLE '#D' : ( Search Options ) (S) -->
				<table class="search">
					<tr><td class="bg">


						<!-- : ( POR ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet2');</script></td>
							</tr>
						</table>
						<!-- : ( POR ) (E) -->
					</td></tr>
				</table>
				<!-- TABLE '#D' : ( Search Options ) (E) -->
			</div>
			<div id="tabLayer" style="display:none"><!-- TABLE '#D' : ( Search Options ) (S) -->
				<table class="search">
					<tr><td class="bg">


						<!-- : ( POR ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet3');</script></td>
							</tr>
						</table>
						<!-- : ( POR ) (E) -->
					</td></tr>
				</table>
				<!-- TABLE '#D' : ( Search Options ) (E) -->
			</div>
			<div id="tabLayer" style="display:none"><!-- TABLE '#D' : ( Search Options ) (S) -->
				<table class="search">
					<tr><td class="bg">


						<!-- : ( POR ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet4');</script></td>
							</tr>
						</table>
						<!-- : ( POR ) (E) -->
					</td></tr>
				</table>
				<!-- TABLE '#D' : ( Search Options ) (E) -->
			</div>	
			<div id="tabLayer" style="display:none"><!-- TABLE '#D' : ( Search Options ) (S) -->
				<table class="search">
					<tr><td class="bg">


						<!-- : ( POR ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet5');</script></td>
							</tr>
						</table>
						<!-- : ( POR ) (E) -->
					</td></tr>
				</table>
				<!-- TABLE '#D' : ( Search Options ) (E) -->
			</div>	
			<!-- Grid (E) -->
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	      	 	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button_in">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_rowadd">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button_in">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_rowdel">Row&nbsp;Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
                        
				        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button_in">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_copy">Row&nbsp;Copy</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				        
				        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button_in">
						<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button_in"><tr>
                            <td class="btn2_left"></td><td class="btn2" name="btn_import">Import</td><td class="btn2_right"></td>
                            </tr></table>
                        </td> 
						</tr>
						</table></td>
						
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			
			</tr>
		</table>
		<!--biz page (E)-->	

<!--Button (S) -->
		
    <!--Button (E) -->
	
	
	</td></tr>
</table>
	
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>