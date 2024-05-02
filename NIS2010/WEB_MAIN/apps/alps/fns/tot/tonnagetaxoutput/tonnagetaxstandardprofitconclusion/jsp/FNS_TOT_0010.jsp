<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_TOT_0010.jsp
*@FileTitle : TOT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.06.08 장창수
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="java.util.Collection" %>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo" %>
<%@ page import="com.hanjin.bizcommon.util.BizComUtil" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.event.FnsTot0010Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsTot0010Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	String laneCmb		= "";
	String trdBylaneCmb		= "";
	String trdCmb		= "";
	

	Logger log = Logger.getLogger("com.hanjin.apps.TonnageTaxOutput.TonnageTaxStandardProfitConclusion");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (FnsTot0010Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
	         strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		//laneCmb = eventResponse.getETCData("laneCmb" );
		//trdBylaneCmb = eventResponse.getETCData("trdBylaneCmb" );
		trdCmb = eventResponse.getETCData("trdCmb" );

	}catch(Exception e) {
		out.println(e.toString());
	}


%>
<html>
<head>
<title>TOT</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
	
		loadPage("<%=trdCmb%>");
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

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
		<table class="search" id="mainTable" border="0"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="40">Vessel</td>
					<td width="140"><input type="text" class="input" name="vsl_cd" style="width:60;" dataformat="engup" maxlength="4" >&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btn1_pop_vsl" ></td>
					<td width="48">Period</td>
					<td width="340"><input type="text" style="width:60" class="input1" name= "stl_yrmon" dataformat="ym" maxlength="6" size="7" cofield="e_stl_yrmon" caption="the start date" value="">&nbsp;<img class="cursor" src="img/btns_back.gif" name = "btns_back" width="19" height="20" border="0" align="absmiddle">&nbsp;<img class="cursor" src="img/btns_next.gif" name = "btns_next" width="19" height="20" border="0" align="absmiddle">&nbsp;&nbsp;~&nbsp;&nbsp;<input type="text" style="width:60" class="input1" name="e_stl_yrmon" maxlength="6" size="7" dataformat="ym"  cofield="stl_yrmon"  caption="the end date" value="">&nbsp;<img class="cursor" src="img/btns_back.gif" name = "btns_back2" width="19" height="20" border="0" align="absmiddle">&nbsp;<img class="cursor" src="img/btns_next.gif" name = "btns_next2" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="38">Trade</td>
					<td width="120">
					<script language="javascript">ComComboObject('trd_cd',2,55,1,0);</script>
					</td>
					<td width="46">Lane</td>
					<td >
					<script language="javascript">ComComboObject('slan_cd',2,55,1,0);</script>
					</td>
					</tr> 
				</table>				
				<!--  biz_1   (E) -->
			
		</td></tr></table>
		
		<table class="height_8"><tr><td></td></tr></table>	
		
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
			
			<!-- Grid  (S) -->

			<div id="tabLayer" style="display:inline">	
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
			</div>		

			<!-- Grid (E) -->			
			
			
			</td></tr>
		</table>
		<!--biz page (E)-->

	
	
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Down_Excel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			
		</td></tr>
		</table>
    <!--Button (E) -->
	
	
	
	</td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>