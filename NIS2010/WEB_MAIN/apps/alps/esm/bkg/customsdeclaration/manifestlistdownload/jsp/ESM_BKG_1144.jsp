<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_BKG_1144.jsp
*@FileTitle : Secondary notification & Customs broker nomination
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.26
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2012.03.26 KIM HYUN HWA
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg1144Event"%>
<%@ page import="com.hanjin.syscommon.common.table.MdmCountryVO" %>
<%@ page import="com.hanjin.syscommon.common.table.MdmPortVO" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>

<%
    EsmBkg1144Event  event = null;                    //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;            //서버에서 발생한 에러
    String strErrMsg = "";                        //에러메세지
    int rowCount     = 0;                        //DB ResultSet 리스트의 건수
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id    = "";
    String strUsr_nm    = "";
    String strOfc_cd    = "";

    String strCustCode  = "";
    String strCreOfcCd  = "";
    Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOfc_cd = account.getOfc_cd();
       
        event = (EsmBkg1144Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        strCustCode = JSPUtil.getNullNoTrim(request.getParameter("cust_cnt_cd"));
        strCustCode = strCustCode + JSPUtil.getNullNoTrim(request.getParameter("cust_seq"));
        strCreOfcCd = JSPUtil.getNullNoTrim(request.getParameter("ofc_cd"));
 
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Secondary notification & Customs broker nomination</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    var userOfficeCode = "<%=strOfc_cd%>";    
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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="strCustCntCd">
<input type="hidden" name="strCustSeq">
<input type="hidden" name="strPod">
<input type="hidden" name="strDel">
<input type="hidden" name="strLocCd">
<!-- 개발자 작업    -->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
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
				<table class="search" border="0"> 
				<tr class="h23">
					<td width="100">Customer Code</td>
					<td width="100"><input type="text" name="cust_cd" style="width:70; ime-mode: disabled;" class="input" value="<%=strCustCode%>"
                        				dataformat="eng" maxlength="8" caption="Customer Code"></td>
					<td width="48">S/C No.</td>
					<td width="110"><input type="text" name="sc_no" style="width:73; ime-mode: disabled;" class="input"
                        				dataformat="eng" maxlength="9" caption="S/C No."></td>
					<td width="25">POD</td>
					<td width="80"><input type="text" name="pod_cd" style="width:50; ime-mode: disabled;" class="input"
                        				dataformat="engupnum" maxlength="5" fullfill caption="POD"></td>
					<td width="25">DEL</td>
					<td width="80"><input type="text" name="del_cd" style="width:50; ime-mode: disabled;" class="input"
                        				dataformat="engupnum" maxlength="5" fullfill caption="DEL"></td>

					<td width="90">Create Office</td>
					<td width=""><input type="text" name="cre_ofc_cd" style="width:50; ime-mode: disabled;" class="input" 
					                    value="<%="".equals(strCreOfcCd) ? strOfc_cd : strCreOfcCd%>"
                        				dataformat="engup" minlength="5" maxlength="6" caption="Create Office"></td>
				</tr></table>
								
				<!--  biz_1   (E) -->
				
				<table class="line_bluedot"><tr><td></td></tr></table>
				
				
			
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
						<td class="btn2" name="btn_RowAdd">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Copy">Row Copy</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td> 
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_Delete">Row Delete</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
				
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down&nbsp;Excel</td>
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