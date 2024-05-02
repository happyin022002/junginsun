<%--
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_AGT_0058.jsp
*@FileTitle : Customer Vs Vendor for S. America
*Open Issues :
*Change history :
*@LastModifyDate : 2011-04-22
*@LastModifier : SungJin Park
*@LastVersion : 1.0
* 2011-04-22 SungJin Park
* 1.0 최초 생성
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.agtmaster.agtcustomerinfo.event.EsmAgt0058Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
EsmAgt0058Event  event = null;                                 //PDTO(Data Transfer Object including Parameters)
Exception serverException = null;                               //서버에서 발생한 에러
String strErrMsg = "";                                                  //에러메세지
int rowCount     = 0;                                                   //DB ResultSet 리스트의 건수
//String successFlag = "";
//String codeList  = "";
//String pageRows  = "100";
String userId 		= "";
String strUsr_nm	= "";
try {
	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    userId=account.getUsr_id();
    strUsr_nm = account.getUsr_nm();

	event = (EsmAgt0058Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

	if (serverException != null) {
    	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	} else {
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} // end else

}catch(Exception e) {
	out.println(e.toString());
}
%>

<html>
<head>
<title>Freight Forwarder VS Vendor matching Info for Brokerage</title>
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

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
	<tr>
		<td>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr>
					<td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
				</tr>
				<tr>
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
			<!-- TABLE '#D' : ( Button : Main ) (S) -->
            <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
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
                                <td class="btn1_line"></td>
                                <td>
                                	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                    	<tr>
                                    		<td class="btn1_left"></td>
                                            <td class="btn1" name="btn_save">Save</td>
                                            <td class="btn1_right"></td>
										</tr>
									</table>
								</td>
                                <td>
                                	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                    	<tr>
                                    		<td class="btn1_left"></td>
                                            <td class="btn1" name="btn_downexcel">Down Excel</td>
                                            <td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
            <!-- TABLE '#D' : ( Button : Main ) (E) -->
			<!-- TABLE '#D' : ( Search Options ) (S) -->
            <table class="search">
            	<tr>
                	<td class="bg">
						<table class="search_in" border="0">
                        	<tr class="h23">
                              <td width="10%">AGMT Customer</td>
                              <td>&nbsp;<input type="text" name="cust_cnt_seq" style="width:100;ime-mode:disabled;" onKeyPress="ComKeyOnlyAlphabet('uppernum')" maxlength="8"><input type="hidden" name="search_brog_cnt_cust_seqName">
                                    <a href="javascript:openWindowCustomer(document.form);" class="purple"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></a></td>

							</tr>
						</table>
					</td>
				</tr>
			</table>
            <table class="height_10"><tr><td></td></tr></table>
            <!-- TABLE '#D' : ( Search Options ) (E) -->
			<!-- TABLE '#D' : ( Search Options ) (S) -->
            <table class="search">
            	<tr>
                	<td class="bg">
						<!-- : ( grid ) (S) -->
                        <table width="100%" id="mainTable">
                        	<tr>
                            	<td><script language="javascript">ComSheetObject('sheet1');</script></td>
							</tr>
						</table>
                        <!-- : ( grid ) (E) -->
						<!-- : ( Button : Sub ) (S) -->
						<table width="100%" class="button">
                        	<tr>
                        		<td class="btn2_bg">
                                	<table border="0" cellpadding="0" cellspacing="0">
                                		<tr>
	                                    	<td>
	                                    		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                                            	<tr>
	                                            		<td class="btn2_left"></td>
	                                                    <td class="btn2" name="btng_rowadd">Row Add</td>
	                                                    <td class="btn2_right"></td>
	                                              	</tr>
	                                        	</table>
	                                        </td>
                                    	</tr>
                                    </table>
                             	</td>
                             </tr>
                     	</table>
                        <!-- Button_Sub (E) -->
					</td>
				</tr>
        	</table>
            <!-- TABLE '#D' : ( Search Options ) (E) -->
		</td>
	</tr>
</table>
<!-- Outer Table (E)-->
</form>
</body>
</html>

