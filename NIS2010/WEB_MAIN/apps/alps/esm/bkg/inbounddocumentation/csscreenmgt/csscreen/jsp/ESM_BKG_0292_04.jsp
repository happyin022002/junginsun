<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0292_04.jsp
*@FileTitle : C/S Screen(Notice & B/L Copy)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.23
*@LastModifier : 안진응
*@LastVersion : 1.0
* 2009.05.19 안진응
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg029204Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg029204Event  event = null;            //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strOfcCd         = "";
    Logger log = Logger.getLogger("com.hanjin.apps.CsScreenMgtSC.CsScreenBC");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOfcCd  = account.getOfc_cd();


        event = (EsmBkg029204Event)request.getAttribute("Event");
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
<title>Inbound C/S Screen(Notice & B/L Copy)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    var strUsr_id    = "<%=strUsr_id%>";
    var lginOfcCd    = "<%=strOfcCd %>"; //로그인 사용자 오피스 코드
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
<input type='hidden' name ='bl_no' value = "<%=JSPUtil.getNull(request.getParameter("bl_no"))%>">
<input type='hidden' name ='bkg_no' value = "<%=JSPUtil.getNull(request.getParameter("bkg_no"))%>">
<input type='hidden' name ='h_mrd_id' value = "">
<input type='hidden' name ='h_local_lang_flg' value = "">
<!-- RD 부분  -->
<input type="hidden" name="com_mrdPath" value="">
<input type="hidden" name="com_mrdArguments" value="">
<!--
<input type="hidden" size="200" name="com_mrdSaveDialogDir" value="">
<input type="hidden" size="200" name="com_mrdSaveDialogFileName" value="">
<input type="hidden" size="200" name="com_mrdSaveDialogFileExt" value="">
<input type="hidden" size="200" name="com_mrdSaveDialogFileExtLimit" value="">
-->
<input type="hidden" name="com_mrdTitle" value="">
<input type="hidden" name="com_mrdDisableToolbar" value="">
<input type="hidden" name="com_mrdBodyTitle" value="">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;padding-left:0;">
<!--TAB A/N & Invoice (S) -->
<div id="tabLayer" style="display:none">  
	<table class="search" border="0"> 
       	<tr><td class="bg">
			<!--  biz_2 (S) -->
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="110">
					<table class="search" border="0">
							<tr><td class="title_h"></td>
								<td class="title_s">Consignee Code</td></tr>
						</table>
					</td>
                    <td width="130"><input type="text" style="width:90;" class="input2" value="" name = "frm_t5sheet1_cust_cd_c" readonly="true"></td>
                    <td width="45">Name</td>
                    <td width="225"><input type="text" style="width:180;" class="input2" value="" name = "frm_t5sheet1_cust_nm_c" readonly="true"></td>
                    <td width="60">Address</td>
                    <td><input type="text" style="width:350;" class="input2" value="" name = "frm_t5sheet1_cust_addr_c" readonly="true"></td>
                </tr>
                </table>
                
                <table class="height_8"><tr><td></td></tr></table>

               <table width="100%" id="mainTable"> 
				<tr>
				<td width="100%">
                        <script language="javascript">ComSheetObject('t5sheet1');</script>
                        <script language="javascript">ComSheetObject('t5sheet2');</script>
                    </td>
                </tr>
                </table>

                <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
                <table class="height_5"><tr><td></td></tr></table>

                <table class="search" border="0" style="width:979;">
                <tr class="h23">
                    <td width="110">
					<table class="search" border="0">
							<tr><td class="title_h"></td>
								<td class="title_s">Notify Code</td></tr>
						</table>
					</td>
                    <td width="130"><input type="text" style="width:90;" class="input2" value="" name = "frm_t5sheet1_cust_cd_n" readonly="true"></td>
                    <td width="45">Name</td>
                    <td width="225"><input type="text" style="width:180;" class="input2" value="" name = "frm_t5sheet1_cust_nm_n" readonly="true"></td>
                    <td width="60">Address</td>
                    <td><input type="text" style="width:350;" class="input2" value="" name = "frm_t5sheet1_cust_addr_n" readonly="true"></td>
                 </tr>
                </table>

                <table class="height_8"><tr><td></td></tr></table>
                
               <table width="100%" id="mainTable"> 
				<tr>
				<td width="100%">
                        <script language="javascript">ComSheetObject('t5sheet3');</script>
                    </td>
                </tr>
                </table>
			  <table class="height_8"><tr><td></td></tr></table>
					<!--  biz_2 (S) -->
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
               	
			<table class="search" border="0" style="width:100%;"> 
			<tr class="h23">
			
				<td width="110">
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">A. Notify Code</td></tr>
				</table>
				</td>
				<td width="130"><input type="text" style="width:90;" class="input2" value="" name = "frm_t5sheet1_cust_cd_a" readonly="true"></td>
				<td width="110">Name & Address</td>
				<td width=""><input type="text" style="width:576;" class="input2" value="" name = "frm_t5sheet1_cust_nm_a" readonly="true"></td> 
				
				</tr>
			</table>			
			<!--  biz_2  (E) -->
                <!--  Button_Sub (S) -->
                <table width="100%" class="button">
                <tr>
                    <td class="btn2_bg">
                        <table border="0" cellpadding="0" cellspacing="0">
                        <tr>
                            <td>
                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                <tr><td class="btn2_left"></td>
                                    <td class="btn2" name="btn_t5Preview">Preview</td>
                                    <td class="btn2_right"></td>
                            </tr>
                            </table>
                        </td>

                        <td>
                            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr><td class="btn2_left"></td>
                                <td class="btn2" name="btn_t5Master">Master Data</td>
                                <td class="btn2_right"></td>
                            </tr>
                            </table>
                        </td>

                        <td>
                            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr><td class="btn2_left"></td>
                                <td class="btn2" name="btn_t5SendAn">Send A/N</td>
                                <td class="btn2_right"></td>
                            </tr>
                            </table>
                        </td>

                        <td>
                            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr><td class="btn2_left"></td>
                                <td class="btn2" name="btn_t5AnTemplate">A/N Template</td>
                                <td class="btn2_right"></td>
                            </tr>
                            </table>
                        </td>

                        <td>
                            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr><td class="btn2_left"></td>
                                <td class="btn2" name="btn_t5SendOBl">Send O.B/L</td>
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
<!--TAB A/N & Invoice (E) -->
</div>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>