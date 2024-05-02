<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1075.jsp
*@FileTitle : Booking Receipt Notice And Draft B/L Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.24
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.12.24 김영출
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg1075Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.common.*" %>

<%
	EsmBkg1075Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BookingMasterData.UserSetupMgt");

	//String org_cnt_cd = null;
	//String org_cnt_nm = null;
	//List<BkgComboVO> bkg_ofc_cds = null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg1075Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		/*
		bkg_ofc_cds = (List<BkgComboVO>) eventResponse.getCustomData("bkg_ofc_cds");
		if(bkg_ofc_cds == null || bkg_ofc_cds.size() == 0){
			org_cnt_cd = "  ";
			org_cnt_nm = "ALL";
		}else{
			for(int i=1;i<bkg_ofc_cds.size();i++){
				if(i==1){
					org_cnt_cd = bkg_ofc_cds.get(i).getVal();
	                org_cnt_nm = bkg_ofc_cds.get(i).getVal() + "\t" + bkg_ofc_cds.get(i).getName();
				}else{
					org_cnt_cd = org_cnt_cd + "|" + bkg_ofc_cds.get(i).getVal();
	                org_cnt_nm = org_cnt_nm + "|" + bkg_ofc_cds.get(i).getVal() + "\t" + bkg_ofc_cds.get(i).getName();
				}
			}
		}
		*/
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Booking Receipt Notice And Draft B/L Setup</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		//org_cnt_cd_str = "<%//=org_cnt_cd%>";
		//org_cnt_nm_str = "<%//=org_cnt_nm%>";
		//alert("\n=>" + org_cnt_cd_str + "\n=>" + org_cnt_nm_str);	
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
<!-- 개발자 작업	-->
<input type="hidden" name="dirty_flag">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
		<!--Page Title, Historical (S)-->
		<!--
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="/img/icon_history_dot.gif" align="absmiddle">&nbsp;M&amp;R >> Equipment Repair Approval Authority Creation</td></tr>
			<tr><td class="title"><img src="/img/icon_title_dot.gif" align="absmiddle">&nbsp;Booking Receipt Notice & Draft B/L Setup</td></tr>
		</table>
		-->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
        </table>
		<!--Page Title, Historical (E)-->

		<!--biz page (S)-->
		
<table class="search" id="mainTable"> 
    <tr><td class="bg">	
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="60">BKG OFC</td>
				<td width="130"><input type="text" name="bkg_ofc_cd"  style="ime-mode:disabled;width:120px;" dataformat="engupnum" class="input">
				    <!--script language="javascript">ComComboObject("comObj1", 2, 130, 0, 0, 0, true, 0, true);</script-->
					<%//=HTMLUtil.getComboString("bkg_ofc_cd", "width:120px;", "input", "", bkg_ofc_cds)%>
				     <!--select name="org_cnt_cd" style="width:70;" class="input">
						<option value="0" selected>All</option>
						<option value="1">1</option>
						<option value="2">2</option>
					</select--></td>
				<td width="100">Customer Code</td>
				<td width="641"><input type="text" name="cust_cd"  style="ime-mode:disabled;width:90px;" dataformat="engupnum" class="input">
				<!--
				<input type="hidden" name="cust_cnt_cd">
				<input type="hidden" name="cust_seq">
				-->
				</td>
			</tr>
			</table>
			
			
		</td></tr>
		</table>
		<!--biz page (E)-->
	<table class="height_8"><tr><td></td></tr></table>
		
	<!--biz page (S)-->
	
	<table class="search" id="mainTable"> 
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
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	      	 	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_rowadd">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_rowdel">Row&nbsp;Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			
			</td></tr>
		</table>
		<!--biz page (E)-->	

<!--Button (S) -->
		
    <!--Button (E) -->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
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
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
	
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>