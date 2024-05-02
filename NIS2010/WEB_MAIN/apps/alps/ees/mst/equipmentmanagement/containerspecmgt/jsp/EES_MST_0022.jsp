<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MST_0022.jsp
*@FileTitle : Container Specification Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 김석준
*@LastVersion : 1.0
* 2009.05.11 김석준
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
<%@ page import="com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.event.EesMst0022Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMst0022Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.EquipmentManagement.ContainerSpecMgt");
	
	// own_cntr_flg 값 가져오기.
	String own_cntr_flg = JSPUtil.getParameter(request ,"own_cntr_flg".trim(),"");
	if(own_cntr_flg == null){
		own_cntr_flg = "";
	}
	
	// cntr_tpsz_cd 값 가져오기.
	String cntr_tpsz_cd = JSPUtil.getParameter(request ,"cntr_tpsz_cd".trim(),"");
	if(cntr_tpsz_cd == null){
		cntr_tpsz_cd = "";
	}
	
	// from_spec_yr 값 가져오기.
	String from_spec_yr = JSPUtil.getParameter(request ,"from_spec_yr".trim(),"");
	if(from_spec_yr == null){
		from_spec_yr = "";
	}
	
	// to_spec_yr 값 가져오기.
	String to_spec_yr = JSPUtil.getParameter(request ,"to_spec_yr".trim(),"");
	if(to_spec_yr == null){
		to_spec_yr = "";
	}
	
	// agmt_no 값 가져오기.
	String agmt_no = JSPUtil.getParameter(request ,"agmt_no".trim(),"");
	if(agmt_no == null){
		agmt_no = "";
	}
	
	// lot_no 값 가져오기.
	String lot_no = JSPUtil.getParameter(request ,"lot_no".trim(),"");
	if(lot_no == null){
		lot_no = "";
	}
	
	// active_flag 값 가져오기.  -- 조회조건의 활성화여부 체크.
	String active_flag = JSPUtil.getParameter(request ,"active_flag".trim(),"");
	if(active_flag == null){
		active_flag = "";
	}
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EesMst0022Event)request.getAttribute("Event");
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
<title>Container Specification Inquiry</title>
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

<body onLoad="setupPage();">
<form name="form" onkeyup="ComKeyEnter('lengthnextfocus');">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="cntr_tpsz_cd" value="<%=cntr_tpsz_cd%>">
<input type="hidden" name="active_flag" value="<%=active_flag%>">
<input type="hidden" name="cntr_spec_no" value="">
<input type="hidden" name="lot_no" value="<%=lot_no %>">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
	<!--Page Title, Historical (S)-->
 		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<%if(active_flag == "") {%>
						<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle">&nbsp;Equipment Management > CNTR Master > Specification > Container Specification Inquiry</td></tr>
						<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			<%}else{ %>
						<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"></td></tr>
						<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Container Specification</td></tr>
			<%} %>  			
 		</table>
 	<!--Page Title, Historical (E)-->
	
	<!--biz page (S)-->
		<!-- : ( Search Options ) (S) -->
			<table class="search"> 
       		<tr><td class="bg">
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="310">
							<table width="250" class="search_sm2"> 
							<tr class="h23">
								<td width="70" align="center">Term</td>
								<td class="stm">
								<input type="radio" name="own_cntr_flg" value="Y" class="trans" <%if(own_cntr_flg.equals("Y")) out.print("checked"); %> >&nbsp;OWN&nbsp;&nbsp;<input type="radio" name="own_cntr_flg" value="N" class="trans" <%if(own_cntr_flg.equals("N")) out.print("checked"); %> >&nbsp;Lease</td>
							</tr> 
							</table>
						</td>
						<td width="45">TP/SZ</td>
						<td width="150" style="padding-left:2;"><script language="javascript">ComComboObject('combo1', 1, 45, 1);</script></td>
						<td width="65">Spec Year</td>
						<td><input type="text" name="from_spec_yr" style="width:50" dataformat="engup" maxlength=4 value = "<%=from_spec_yr%>" style="text-align:center">&nbsp;~&nbsp;<input type="text" name="to_spec_yr" style="width:50" dataformat="engup" maxlength=4 value = "<%=to_spec_yr%>" style="text-align:center"></td>
						<td width="60">AGMT No.</td>
						<td><input type="text" name="agmt_no" style="width:100" class="input" dataformat="engup" value = "<%=agmt_no%>" maxlength=9  style="text-align:center">&nbsp;<img src="img/btns_search.gif" name="btn_Popup" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"> </td>
					</tr> 
				</table>	
				
				</td> 
			</tr></table>
			<table class="height_8"><tr><td></td></tr></table>
			
			<table class="search"> 
       		<tr><td class="bg" style="height:456;" valign="top">
				
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- : ( Grid ) (E) -->	
<% if(active_flag!="")		// 팝업일경우 출력되는 버튼.
{
%>

			<!--  Button_Sub (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							
							
			</tr>
			</table>
		</td></tr>
		</table>
<%
}
%>
		    <!-- Button_Sub (E) -->
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->

</td></tr>
</table> 

<% if(active_flag!="")		// 팝업일경우 출력되는 버튼.
{
%>
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td width="">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_downexcel">Down Excel</td>
						<td class="btn1_right"></td>
					</tr>
					</table>
				</td>
		    	<td class="btn1_line"></td>
				<td width="">
					<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_ok">OK</td>
						<td class="btn1_right"></td>
					</tr>
					</table>
				</td>
				<td class="btn1_line"></td>
				<td width="">
					<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_close">Close</td>
						<td class="btn1_right"></td>
					</tr>
					</table>
				</td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
<%
}
else	// 팝업이 아닐경우 출력되는 버튼
{
%>
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
		
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    	<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_downexcel">Down Excel</td>
						<td class="btn1_right"></td>
					</tr>
					</table>
				</td>
		    	<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
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
					<td class="btn1" name="btn_spec">SPEC</td>
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
	
<%
}
%>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>

<%@ include file="/bizcommon/include/common_nis2010.jsp"%>