<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_BKG_1177.jsp
*@FileTitle : DO Validity Upto History
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.23
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2010.07.28 조원주
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
<%@ page import="org.apache.log4j.Logger" %>

<%

	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
 
	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";
	String bkg_no ="";
	Logger log = Logger.getLogger("com.hanjin.apps.InboundBlMgt.PickUpNotice");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		//strOfc_cd = account.getOfc_cd();
		//strOfc_cd = "ddd";
		strOfc_cd = JSPUtil.getNull(request.getParameter("ofc_cd"));
		bkg_no = JSPUtil.getNull(request.getParameter("bkg_no"));
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>DO Validity Upto History</title>
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

<body class="popup_bg"  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="bkg_no" value="<%=bkg_no%>">



<!-- 개발자 작업	-->


<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
    <tr><td class="top"></td></tr>
    <tr>
        <td valign="top">
    
            <!-- : ( Title ) (S) -->
            <table width="100%" border="0">
                <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle" />&nbsp;DO Validity Upto History</td></tr>
            </table>
            <!-- : ( Title ) (E) -->
        
            <!--biz page (S)-->
            <table class="search" id="mainTable"> 
                <tr>
                    <td class="bg">
                
                    
                        <table class="search" width="100%" > 
                            <!--<tr class="h23">
                                <td width="350">DO Validity Upto Date/ Updated Date / Updated Staff </td>
                                
                            </tr>-->
                            
                            
                            
                            <!--<tr class="h23">
                              
                            
                                <td width="350">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<u><font color="blue"><span id="upd_usr_id" style="center"></span></font></u></td>

                            </tr>-->
                            
                            <table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
                        </table>        
                        
                
                    </td>
                </tr>
            </table>
            <!--biz page (E)--> 

        </td>
    </tr>
</table>
    
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
    <tr>
        <td height="71" class="popup">

            <!--Button (S) -->  
            <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
                <tr>
                    <td class="btn3_bg">
                        <table border="0" cellpadding="0" cellspacing="0">
                            <tr>
                                
                                <td> 
                                    <table border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_Close">Close</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </table>                        
                    </td>
                </tr>
            </table>
    
        </td>
    </tr>
</table>
<!-- : ( Button : pop ) (E)style="display:none" -->




<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_nis2010.jsp"%>