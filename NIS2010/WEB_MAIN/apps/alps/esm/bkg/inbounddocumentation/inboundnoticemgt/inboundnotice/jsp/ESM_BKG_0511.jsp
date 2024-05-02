<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0511.jsp
*@FileTitle : Hold Notice: Pre-Hold Notice Set-up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.08.17 박미옥
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0511Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0511Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	String strPopUp         = "";
    String strPreOfc_cd     = "";
	String strPrePod_cd     = "";
	Logger log = Logger.getLogger("com.hanjin.apps.InboundBLMgt.HoldNotice");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();


		strPopUp     = JSPUtil.getParameter(request, "popUp");
        strPreOfc_cd = JSPUtil.getParameter(request, "ofc_cd");
		strPrePod_cd = JSPUtil.getParameter(request, "pod_cd");
		
		event = (EsmBkg0511Event)request.getAttribute("Event");
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
<title>Hold Notice: Hold Notice Set-up</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
        document.form.ofc_cd.value = "<%="Y".equals(strPopUp)?strPreOfc_cd:strOfc_cd%>";
        document.form.pod_cd.value = "<%="Y".equals(strPopUp)?strPrePod_cd:""%>";
		
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<input type="hidden" name="usr_ofc_cd"     value="<%=strOfc_cd%>">
<input type="hidden" name="hld_ntc_tp_cd"  value="PH">
<input type="hidden" name="hld_ntc_fom_cd" value="**">

<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>
<%-- Main & Popup 공통 삭제 처리 
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
    <tr>
        <td valign="top">
            <!--Page Title, Historical (S)-->
            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
                <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle" /><span id="navigation"></span></td></tr>
                <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle" /><span id="title"></span></td></tr>
            </table>
            <!--Page Title, Historical (E)-->
--%>        
            <!-- Grid BG Box  (S) -->
        
        
            <!-- Grid BG Box  (S) -->        
            <table class="search"> 
                <tr>
                    <td class="bg">
                        <!--  biz_1 (S) -->
                        <table class="search" border="0" style="width:979;"> 
                            <tr class="h23">
                                <td width="100">Handling Office</td>
                                <td width="110">
                                    <input type="text" style="width:80;ime-mode:disabled;" class="input1" name="ofc_cd"
                                        caption="Handling Office" maxlength="6" minlength="5" dataformat="engup" required="" />
                                </td>
                                <td width="30">POD</td>
                                <td width="">
                                    <input type="text" style="width:80;ime-mode:disabled;" class="input1" name="pod_cd"
                                        caption="POD Code" maxlength="5" minlength="5" dataformat="" required="" fullfill="fullfill" />&nbsp;
                                    <script language="javascript">ComComboObject("pod_cd_list", 1, 100, 0, 0);</script>
                                </td>                        
                            </tr>                            
                        </table>
                        <!--  biz_1   (E) -->       
                    
                        <table class="line_bluedot"><tr><td></td></tr></table>
                            
                        <!--  biz_2 (S) -->
                        <input type="hidden" name="frm_ofc_cd" />
                        <input type="hidden" name="frm_pod_cd" />
                        <table class="search_sm2" border="0" style="width:509;"> 
                            <tr class="h23">
                                <td width="70">Auto Send</td>
                                <td width="136" class="stm">
                                    <input type="radio" class="trans" name="frm_auto_ntc_flg" value="Y" />&nbsp;Yes&nbsp;
                                    <input type="radio" class="trans" name="frm_auto_ntc_flg" value="N" />&nbsp;No
                                </td>
                                <td width="160">Enclose B/L Copy</td>
                                <td width="" class="stm">
                                    <input type="radio" class="trans" name="frm_eclz_obl_flg" value="Y" />&nbsp;Yes&nbsp;
                                    <input type="radio" class="trans" name="frm_eclz_obl_flg" value="N" />&nbsp;No
                                </td>
                        
                            </tr>
                        </table>
                        <!--  biz_2  (E) -->    
                        
                        <table class="height_8"><tr><td></td></tr></table>  
                        
                        <table class="grid2" border="0" style="width:979;"> 
                            <tr class="tr2_head">
                                <td width="100%" align="left"> &nbsp;Address</td>
                            </tr>
                            <tr>
                                <td><input type="text" style="width:100%;" class="noinput" name="frm_addr_ctnt" format="" maxlength="4000" /></td>
                            </tr>
                        </table>

                        <table class="height_8"><tr><td></td></tr></table>  

                        <table class="grid2" border="0" style="width:979;"> 
                            <tr class="tr2_head"><td width="100%" align="left"> &nbsp;From</td></tr>
                            <tr>
                                <td><input type="text" style="width:100%;" class="noinput" name="frm_snd_ofc_cntc_ctnt" format="" maxlength="500" /></td>
                            </tr>
                        </table>

                        <table class="height_8"><tr><td></td></tr></table>

                        <table border="0" style="width:100%; background-color:white;" class="grid2"> 
                            <tr class="tr2_head">
                                <td width="100%" align="left"> &nbsp;Important Notice</td>
                            </tr>
                            <tr>
                                <td style="color:#3333cc;">
                                    <textarea cols="7" rows="13"style="width:100%" caption="Important Notice" name="frm_hld_rmk"></textarea>
                                </td> 
                            </tr>
                        </table>
                        <!--  biz_2  (E) -->    
                    </td>
                </tr>
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
                                <td class="btn1_line"></td>
                                <td>
                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_Save" id="btn_Save">Save</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
                                <td>
                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_HoldNotice" id="btn_HoldNotice">Hold Notice</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
                                <td>
                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_Delete" id="btn_Delete">Delete</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
                                <td>
                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_Copy" id="btn_Copy">Copy</td>
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
                
            <!--Grid (s)-->
            <table width="100%"  id="mainTable">
                <tr>
                    <td width="100%">
                        <script language="javascript">ComSheetObject('sheet1');</script>
                        <script language="javascript">ComSheetObject('sheet2');</script>
                    </td>
                </tr>
            </table>
            <!--Grid (E)-->
                
        </td>
    </tr>
</table>

<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp"%>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>