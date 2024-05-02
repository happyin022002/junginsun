<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_SCE_0123.jsp
*@FileTitle : 화주전송 Schedule 관리화면
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.08
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2010.01.08 함대성
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
<%@ page import="com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.event.EsdSce0123Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdSce0123Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdSce0123Event)request.getAttribute("Event");
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
<title>화주전송 Schedule 관리화면</title>
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
<input type="hidden" name="tmp_vsl_slan_cd">
<input type="hidden" name="tmp_vsl_slan_nm">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<table width="100%" border="0" height="100%" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
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
						<td width="110">TP ID</td>
						<td colspan="5"><!-- 테스트(삼성) : C1T0W -->
							<script language="javascript">ComComboObject('cust_trd_prnr_id',2, 110, 1, 1, 2);</script>
							<input type="hidden" name="cust_trd_prnr_id">
							<!-- <input name="cust_trd_prnr_id" type="text"   maxlength="20" value=""  tabIndex="1"  caption="TP ID" style="width:100;ime-mode:disabled"   dataformat="" > -->
							<input name="partnerName" type="text" maxlength="50" style="width:300" value="" readonly>
						</td>
					</tr>
					<tr class="h23">
						<td width="110">Location(POL)</td>
						<td width="144">
							<input type="text" style="width:100" class="input" name='pol_cd' caption='pol_cd' value="" maxlength=5 minlength=5 fullfill style="ime-mode:disabled; text-align:center"  dataformat="engup" >
						</td>
						<td width="60">Country</td>
						<td width="130">
							<input name="pol_cnt" type="text"   style="width:100;"  value="" maxlength=2 minlength=2 fullfill style="ime-mode:disabled; text-align:center" dataformat="engup" >&nbsp;<img class="cursor" src="img/btns_search.gif" name="btns_country1" width="19" height="20" border="0" align="absmiddle">
						</td>
						<td width="500"></td>
						<td>
							
						</td>
					</tr>
					<tr class="h23">
						<td width="110">Location(POD)</td>
						<td>
							<input name="pod_cd" type="text" style="width:100;"   value="" maxlength=5 minlength=5 fullfill style="ime-mode:disabled; text-align:center" dataformat="engup" >
						</td>
						<td width="60">Country</td>
						<td>
							<input name="pod_cnt" type="text" style="width:100;"  value="" maxlength=5 minlength=5 fullfill style="ime-mode:disabled; text-align:center" dataformat="engup" >&nbsp;<img class="cursor" src="img/btns_search.gif" name="btns_country2" width="19" height="20" border="0" align="absmiddle">
						</td>
						<td width="500"></td>
						<td>
							
						</td>
					</tr>
					<!-- tr id="lineLayer" style="display:none"><td class="line_bluedot" colspan="6" ></td></tr -->
					<tr class="h23" id="samLayer" >
						<td width="110">Adj Lane</td>
						<td colspan="5"><!-- 테스트(삼성) : PNN -->
							<input name="slan_cds" type="text" maxlength="3" style="width:100" value="" maxlength=5 minlength=5 fullfill style="ime-mode:disabled; text-align:center" dataformat="engup" >
						</td>
					</tr>
				</table>
			</td></tr>
		</table>
			<!--  biz_1  (S) -->

		<table class="height_10"><tr><td colspan="8"></td></tr></table>
		<!-- Tab BG Box  (S) -->
     	<table class="search">
       	<tr><td class="bg">
			
			<!-- Grid  (S) -->
			
			<!-- <table width="100%" class="search"  id="mainTable1" style="display:none">
				<tr>
					<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script> 
					</td>
				</tr>
			</table> -->
			<table width="100%" class="search"  id="mainTable2" style="display:none">
				<tr>
					<td width="100%">
					<script language="javascript">ComSheetObject('sheet2');</script> 
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->

			<!--  Grid_button (S) -->
			<!--  Button_Sub (S) -->
			<table width="100%" class="button" id="btnLayer" >
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_RowAdd">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_RowDelete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			</td></tr>
		</table> 
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	
	
	<!--Button (S) -->
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;" id="btnSave" >
      	<tr><td class="btn1_bg">
	    <table border="0" cellpadding="0" cellspacing="0">
	    <tr>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_retrieve">Retrieve</td>
				<td class="btn1_right"></td>
				</tr>
			</table></td>
			<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_new">New</td>
				<td class="btn1_right"></td>
				</tr>
			</table></td>
			<td class="btn1_line"></td>
			<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_save">Save</td>
				<td class="btn1_right"></td>
				</tr>
			</table></td>
		</tr>
		</table>
		</td></tr>
	</table> 
    <!--Button (E) -->
    
	<!--Button (S) -->
	<!-- <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;" id="btnRet">
      	<tr>
      		<td class="btn1_bg">
	    		<table border="0" cellpadding="0" cellspacing="0">
	    			<tr>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_retrieve">Retrieve</td>
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
		</tr>
	</table> -->
</td>
</tr>
	</table> 
    <!--Button (E) -->    

</td>
</tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>