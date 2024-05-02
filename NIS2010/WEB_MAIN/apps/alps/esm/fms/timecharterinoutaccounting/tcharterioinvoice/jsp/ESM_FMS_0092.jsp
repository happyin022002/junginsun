<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0092.jsp
*@FileTitle : [ESM_FMS_0092] File Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.27
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2014.10.27 민정호
* 1.0 Creation 
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@page import="com.hanjin.apps.alps.esm.fms.fmscommon.fmsfileupload.event.EsmFms0092Event"%>
<%@page import="com.hanjin.framework.component.util.StringUtil"%>
<%
	EsmFms0092Event event = null;
    Exception serverException = null;
    String strErrMsg = "";
    int rowCount = 0; 

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String userId = "";
    String userName = "";
    String userOffice = "";
    String atchFileFletLnkId = "";
    String vslCd = "";
    String vnorSeq = "";
    String vnorItmSeq = "";
    
    String csrNo = "";
    
    String editAble = "";
    String row = "";
    String tabGubun = "";
    String chkFlg = "";
    
    Logger log = Logger.getLogger("com.hanjin.apps.alps.fns.joo.joocommon.JOOCommonSC");
    
    try
    {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();
        
        event = (EsmFms0092Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        atchFileFletLnkId     = JSPUtil.getParameter(request , "atch_file_flet_lnk_id" , "");
        vslCd     				 = JSPUtil.getParameter(request , "vsl_cd" , "");
        vnorSeq     			 = JSPUtil.getParameter(request , "vnor_seq" , "");
        vnorItmSeq     		 = JSPUtil.getParameter(request , "vnor_itm_seq" , "");
        editAble    			 = JSPUtil.getParameter(request , "edit_able" , "");
        row	    			 = JSPUtil.getParameter(request , "row" , "");
        tabGubun  			 = JSPUtil.getParameter(request , "tab_gubun" , "");   
        chkFlg  			 = JSPUtil.getParameter(request , "chk_flg" , "");   
        
        csrNo				= JSPUtil.getParameter(request , "csr_no" , "");
        
        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }
    catch (Exception e)
    {
        out.println(e.toString());
    }
    
    
    // ----------------------------------------------------------------
    // 해당 초기 파라미터 설정
    // ----------------------------------------------------------------    
    // clm_file_tp_cd  (UI번호(4) + fileupload 일련번호  000501 , 000502)   
%>


<html>
<head>
<title>File Upload</title>
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

<body  class="popup_bg" onLoad="javascript:setupPage();" >
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows">

<!-- 개발자 작업 -->
<input type="hidden" name="atch_file_flet_lnk_id" value="<%=atchFileFletLnkId%>">
<input type="hidden" name="vsl_cd" value="<%=vslCd%>">
<input type="hidden" name="vnor_seq" value="<%=vnorSeq%>">
<input type="hidden" name="vnor_itm_seq" value="<%=vnorItmSeq%>">

<input type="hidden" name="csr_no" value="<%=csrNo%>">

<input type="hidden" name="row" value="<%=row%>">
<input type="hidden" name="tab_gubun" value="<%=tabGubun%>">
<input type="hidden" name="chk_flg" value="<%=chkFlg%>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; FMS File Upload</td></tr>
        </table>
        <!-- : ( Title ) (E) -->
        
        <!-- : ( Search Options ) (S) -->
        <table class="search"> 
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
<%if ("Y".equals(editAble)) {%>  
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn2_Row_Add">Row Add</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn2_Row_Delete">Row Delete</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn2_Save">Save</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td> 
<%} %>	                                                                       
                    </tr></table>
            </td></tr>
            </table>
            <!-- Button_Sub (E) -->
            </td></tr>
        </table>
<!-- : ( Search Options ) (E) -->

<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 
    
    
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
    
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_Close">Close</td>
                    <td class="btn1_right"></td>
                </tr></table></td>
            </tr>
        </table>
    <!--Button (E) -->
    
    </td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
<script language="javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>
<form name="form1" method="post">
</form>
</body>
</html>