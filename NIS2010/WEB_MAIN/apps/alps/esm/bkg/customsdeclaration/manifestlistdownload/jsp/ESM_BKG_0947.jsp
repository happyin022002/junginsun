<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0947.jsp
*@FileTitle : Customs Result Code
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.07.20 이수빈
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg0947Event"%>
<%@ page import="com.hanjin.syscommon.common.table.MdmCountryVO" %>
<%@ page import="com.hanjin.syscommon.common.table.MdmPortVO" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>

<%
    EsmBkg0947Event  event = null;                    //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;            //서버에서 발생한 에러
    String strErrMsg = "";                        //에러메세지
    int rowCount     = 0;                        //DB ResultSet 리스트의 건수
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strOfc_cd        = "";
    String strCnt_cd		= "";
    String strPgmNo         = "";
    Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOfc_cd = account.getOfc_cd().substring(0,4);
        strCnt_cd = account.getCnt_cd();
       
       
        event = (EsmBkg0947Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        strPgmNo = request.getParameter("pgmNo");
 
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Customs Result Code</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업    -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr>
		<td valign="top">

<!--Page Title, Historical (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
	<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
	<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
</table> 
<!--Page Title, Historical (E)-->
<table class="search">
	<tr>
		<td class="bg">
			<table class="search" border="0" style="width:;"> 
				<tr class="h23">
					<td width="60">Country</td> 
					<td width="60"><input type="text" name="cnt_cd" style="width:33; ime-mode: disabled; text-align:center;" class="input" value="<%=strCnt_cd%>"
                        dataformat="engup" maxlength="2" fullfill caption="Country"></td>
					<td width="40">Code</td> 
					<td width="120"><input type="text" name="cstms_dspo_cd" style="width:100; ime-mode: disabled;" class="input"
                        dataformat="eng" minlength="2" maxlength="13" fullfill caption="Code"></td>
					<td width="40">Type</td> 
					<td width="160"><script language="javascript">ComComboObject('dspo_tp_cd', 1, 120, 0, 0, 1);</script></td>
					<td width="40">Total</td> 
					<td width=""><input type="text" name="total" style="width:40; text-align:center;" class="input2" readonly></td>
				</tr>
			</table>
			<!-- : ( Grid ) (S) -->
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

<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
	<tr>
		<td class="btn1_bg">
			<table border="0" cellpadding="0" cellspacing="0">
				<tr> 
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Excel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!--Button (E) -->
		</td>
	</tr>
</table>	
</form>
</body>
</html>