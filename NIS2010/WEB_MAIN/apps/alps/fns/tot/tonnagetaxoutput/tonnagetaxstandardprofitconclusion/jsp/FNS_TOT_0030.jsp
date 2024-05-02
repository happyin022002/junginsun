<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_TOT_0030.jsp
*@FileTitle : Inquiry VSL Owner/Charter
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.19
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.11.19 김영오
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
<%@ page import="com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.event.FnsTot0030Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsTot0030Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

    String bsaTrdList = "";
	String yyyyMM = JSPUtil.getKST("yyyy-MM"); 
	String stlClzFlg		= "";

	String pgStlYrmon		= "";
	String pgTrdCd		= "";
	String pgVslCd		= "";
	String fromPg		= "N";
	String jbEndDt   = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.TonnageTaxOutput.TonnageTaxStandardProfitConclusion");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		pgStlYrmon = JSPUtil.getNull((String) request.getParameter("stl_yrmon"));
		pgTrdCd = JSPUtil.getNull((String) request.getParameter("trd_cd"));
		pgVslCd = JSPUtil.getNull((String) request.getParameter("vsl_cd"));
		fromPg = JSPUtil.getNull((String) request.getParameter("from_pg"));

		event = (FnsTot0030Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
	         strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		bsaTrdList = eventResponse.getETCData("bsaTrdList");
		stlClzFlg = eventResponse.getETCData("stlClzFlg" );
		jbEndDt   = eventResponse.getETCData("jbEndDt"  );		
		//System.out.println("bsaTrdList :::::::::::::::::::::::::::::::::: "+bsaTrdList);
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
	
		loadPage("<%=bsaTrdList%>","<%=stlClzFlg%>","");
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="stl_yr">
<input type="hidden" name="nrt_yn">
<input type="hidden" name="use_yn">
<input type="hidden" name="day_yn">
<input type="hidden" name="pgStlYrmon" value="<%=pgStlYrmon %>">
<input type="hidden" name="pgTrdCd" value="<%=pgTrdCd %>">
<input type="hidden" name="pgVslCd" value="<%=pgVslCd %>">
<input type="hidden" name="fromPg" value="<%=fromPg %>">
<input type="hidden" name="trd_cd">
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
		
		<!--biz page (S)-->
			<table class="search"> 
		       	<tr>
			       	<td class="bg">
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="70">Vessel Type</td>
								<td width="100">
									<select name="tong_flet_tp_cd" style="width:80">
										<option value="A" selected>ALL</option>
										<option value="O">OWNER</option>
										<option value="C">CHARTER</option>
									</select>
								</td>								
								<td width="45"> Month</td>
								<td width="160"><input type="text" style="width:60;" class="input1" name="stl_yrmon" maxlength="6" size="7" value="<%=yyyyMM%>" dataformat="ym">&nbsp;<img class="cursor" src="img/btns_back.gif" name = "btns_back" width="19" height="20" border="0" align="absmiddle">&nbsp;<img class="cursor" src="img/btns_next.gif" name = "btns_next" width="19" height="20" border="0" align="absmiddle"></td>
								<td width="200"></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
				<table class="height_8"><tr><td colspan="8"></td></tr></table>				
				<table class="search"> 
		       		<tr>
			       		<td class="bg">	
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
							<table class="search" border="0" style="width:979;"> 
								<tr class="h23">
									<td width="100">Total Amount </td>
									<td width=""><input type="text" style="width:120;text-align:right" class="input" name= "total_txt_amt" dataformat="float" value="0" disabled></td>
								</tr>
							</table>
							<!--  Grid_button (S) -->
						</td>
					</tr>
				</table>
		<!-- Tab BG Box  (S) -->
		<!--biz page (E)-->	
		
		<!--Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
		       	<tr>
			       	<td class="btn1_bg">
					    <table border="0" cellpadding="0" cellspacing="0">
						    <tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn1_Retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn1_New">New</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn1_Detail">Detail</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn1_Down_Excel">Down Excel</td>
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
		</td>
	</tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>