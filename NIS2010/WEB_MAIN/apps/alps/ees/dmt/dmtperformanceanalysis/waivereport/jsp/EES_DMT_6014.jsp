<%/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ees_dmt_6014.jsp
*@FileTitle : Guarantee Letter Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : Kim YC
*@LastVersion : 1.0
* 
* 1.0 Creation
* 
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.waivereport.event.EesDmt6014Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
    EesDmt6014Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strUsr_ofc       = "";
    String strRhq_ofc_cd    = "";
    Logger log = Logger.getLogger("com.hanjin.apps.DMTPerformanceAnalysis.waivereport");

	String popupFlg = request.getParameter("popupFlg") 	!= null ? (String)request.getParameter("popupFlg") 	: "N" ;
	String darNo 	= request.getParameter("dar_no") 	!= null ? (String)request.getParameter("dar_no") 	: "" ;	
	String custCd 	= request.getParameter("cust_cd") 	!= null ? (String)request.getParameter("cust_cd") 	: "" ;
	String custNm 	= request.getParameter("cust_nm") 	!= null ? (String)request.getParameter("cust_nm") 	: "" ;

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strUsr_ofc  = account.getOfc_cd();
        strRhq_ofc_cd = account.getRhq_ofc_cd();


        event = (EesDmt6014Event)request.getAttribute("Event");
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
<title>Guarantee Letter Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			//showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows">
<input type="hidden" name="pageno" value="ees_dmt_6014">
<input type="hidden" name="dar_cust_cd"> 

<input type="hidden" name="s_cust_gubun">
<input type="hidden" name="s_cust_cd">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top">
		
		
	<% if (!"Y".equals(popupFlg)) { %>	 
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<% } else { %>		
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Guarantee Letter Inquiry</td></tr>
		</table>			
	<% } %>
		
		<!--Page Title, Historical (S)
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr>
					<td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
				</tr>
				<tr>
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
				</tr>
			</table>
		Page Title, Historical (E)--> 
    
	<table class="search"> 
       		<tr><td class="bg">
       		<div id="showMin" style="display: inline"><!--  biz_1  (S) -->
				<!--  biz_1  (S) -->
	    <!--biz page (S)-->
	    	<table class="search" id="mainTable">
	       		<tr class="h23">
                	<td width="70">Customer</td>
                    <td width="560">
                    <table border="0" cellpadding="0" cellspacing="0">
                    	<tr>
                    		<td>
								<input type="text" name="cust_cd" value="<%=custCd%>" style="width:80;" dataformat=engupnum class="input" caption="cust_cd" maxlength="8" minlength="8" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')" >&nbsp;
							</td>
							<td>
								<img src="img/btns_search.gif" name="btns_cust_cd" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="openPopup('cust_cd')">&nbsp;<input type="text" name="cust_nm" value="<%=custNm%>" style="width:433;" class="input2" readOnly>
							</td>
						</tr>
					</table>  
                    </td>
					<td width="70">DAR No.</td>
					<td width=""><input type="text" style="width:120" name="dar_no" dataformat="engupnum" class="input" value="<%=darNo%>" caption="cust_cd" onKeyPress="ComKeyOnlyAlphabet('uppernum')" >&nbsp;
					             <img src="img/btns_multisearch.gif" name="btns_multisearch1" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor: hand;" onClick="openPopup('dar_no')"></td>
				</tr>
			</table>
		<!--biz page (E)-->
			</div>
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		<!-- Grid  (S) -->
		<table class="search" id="mainTable"> 
       		<tr>
       			<td class="bg">
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<!-- Grid (E) -->

			</td></tr>
		</table>
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
											<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>								
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn1_left"></td>
										<td class="btn1" name="btn_New">New</td>
										<td class="btn1_right"></td>
									</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn1_left"></td>
										<td class="btn1" name="btn_DownExcel">Down Excel</td>
										<td class="btn1_right"></td>
									</tr>
									</table>
								</td>	
							</tr>
						</table>
					</td>
				</tr>
			</table>
			
	<!--Button (S) -->
			<% if ("Y".equals(popupFlg)) { %>	 
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
	       	<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>   
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Close">Close</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
				</tr>
				</table>
			</td></tr>
			</table>			
			<% } %>
    <!--Button (E) -->
			
		</td></tr>
		</table>
	    <!--Button (E) -->

    	</td>
	</tr>
	</div>
	
</table>

<!-- Copyright(E)--> <!-- 개발자 작업  끝 -->
</form>
<iframe name="hiddenFrame" style="visibility:hiddden" height="0" width="0"></iframe>
</body>
</html>