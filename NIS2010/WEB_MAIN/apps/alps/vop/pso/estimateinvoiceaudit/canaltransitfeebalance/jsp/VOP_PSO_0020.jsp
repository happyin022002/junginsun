<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_pso_0020.jsp
*@FileTitle : Requested MSA
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.05.20 김진일
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
<%@ page import="com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.event.VopPso0020Event"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopPso0020Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strRevYrmon 		= "";//메인 페이지의 Work Month 
	String strVndrSeq		= "";//메인 페이지의 vender seq
	String strPortNm 		= "";//선택된 Port Name
	String strVndrNm			= "";//선택된 vendor Name
	String row = "";
	String col = "";
	String strSts		    = "";//StatusCD
	String strYdCd = "";
	Logger log = Logger.getLogger("com.hanjin.apps.EstimateInvoiceAudit.CanalTransitFeeBalance");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		strRevYrmon = StringUtil.xssFilter(request.getParameter("revYrmon"));
		strVndrSeq = StringUtil.xssFilter(request.getParameter("vndrSeq"));
		strPortNm = StringUtil.xssFilter(request.getParameter("portNm")); 
		strVndrNm = StringUtil.xssFilter(request.getParameter("vndrNm"));
		row = StringUtil.xssFilter((String) request.getParameter("row"));
		col = StringUtil.xssFilter((String) request.getParameter("col"));
		strSts = StringUtil.xssFilter(request.getParameter("sts"));
		strYdCd = StringUtil.xssFilter(request.getParameter("ydCd"));
		//if(strVndrSeq == null ) strVndrSeq = "181162"; //TEST CODE BY KJI 
		
		event = (VopPso0020Event)request.getAttribute("Event");
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
<title>Requested MSA</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		//Main에서 넘온 값 세팅..
		form.revYrmon.value = ComGetMaskedValue('<%=strRevYrmon%>',  'ym');
		form.portNm.value = "<%=strPortNm%>";
		form.vndrNm.value = "<%=strVndrNm%>";
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form" >
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="rev_yrmon"  value="<%=strRevYrmon%>" />
<input type="hidden" name="vndr_seq"  value="<%=strVndrSeq%>" />
<input type="hidden" name="opflag"  value="S" />
<input type="hidden" name="pso_bztp_cd"  value="" />
<input type="hidden" name="row" value="<%=row%>" />
<input type="hidden" name="col" value="<%=col%>" />
<input type="hidden" name="yd_cd" value="<%=strYdCd%>" />
<!-- 개발자 작업	-->
<table width="900" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Requested MSA</td></tr>
		</table>
		<!-- : ( Title ) (E) -->


	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="50">Month</td>
					<td width="160"><input name="revYrmon" readonly type="text" style="width:60;text-align:center;" class="input2" maxlength="6" size="8"   value="" >
					</td>
					<td width="30">Port</td>
						<td width=""><input type="text" readonly
							name="portNm" style="width: 50;text-align:center;" class="input2" value="" />
						&nbsp;<input type="text" readonly name="vndrNm"
							style="width: 300;text-align:left;" class="input2" value="" /></td>
					</tr>
				</table>
				<!--  biz_1   (E) -->
				</td>
				</tr>
				</table>
				<table class="height_8"><tr><td></td></tr></table>
				
				
		<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
						<!-- img src="/img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
					</td></tr>
				</table>
		<!-- Tab ) (E) --> 
		


<!--TAB (A) (S) -->
<div id="tabLayer" style="display:inline">
		
			<table class="search"> 
       	<tr><td class="bg">	
				
				<!--  biz_2  (S) -->
		
		
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t1sheet1');</script>
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
						<td class="btn2" name="btn_DownExcel">Down Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
				</td></tr>
				</table>
	    			<!-- Button_Sub (E) -->				
				<!--  biz_2   (E) -->
				
				
				</td></tr>
			</table>
	
	<!--biz page (E)-->
	
</div>
<!--TAB (A) (E) --> 




<!--TAB (B) (S) -->
<div id="tabLayer" style="display:none">

			<table class="search"> 
       	<tr><td class="bg">	
				
				<!--  biz_2  (S) -->
		
		
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t2sheet1');</script>
						</td>
					</tr>
				</table>				
				<!-- Grid (E) -->
						
				<!--  biz_2   (E) -->
				
				
				</td></tr>
			</table>
	
	<!--biz page (E)-->

</div>
<!--TAB (B) (E) -->  





<!--TAB (C) (S) -->
<div id="tabLayer" style="display:none">

			<table class="search"> 
       	<tr><td class="bg">	
				
				<!--  biz_2  (S) -->
		
		
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t3sheet1');</script>
						</td>
					</tr>
				</table>				
				<!-- Grid (E) -->
						
				<!--  biz_2   (E) -->
				
				
				</td></tr>
			</table>
	
	<!--biz page (E)-->

</div>
<!--TAB (C) (E) --> 





</td></tr></table>

<table class="height_5"><tr><td></td></tr></table>
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr>
			<td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    
		    	<!-- 
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				 -->
				<% if(!strSts.equals("10")){ %>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_confirm">Confirm</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
                <%} %>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_reject">Reject</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			<td class="btn1_line"></td>		
			<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right">
				</tr></table></td>	
				
			</tr>
		</table></td>	
			</tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
</td></tr>
</table>

	
	

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>