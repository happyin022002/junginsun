<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1058.jsp
*@FileTitle : MT Return Yard for Pickup Notice
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.08.10 박미옥
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1058Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1058Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	String strOfc_cd    = "";
	String parPodCd     = JSPUtil.getParameter(request, "pod_cd");
	String parDelCd     = JSPUtil.getParameter(request, "del_cd");
	Logger log = Logger.getLogger("com.hanjin.apps.InboundBLMgt.PickUpNotice");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg1058Event)request.getAttribute("Event");
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
<title>MT Return Yard for Pickup Notice</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
		document.form.pod_cd.value      = "<%=parPodCd%>";
		document.form.fnl_dest_cd.value = "<%=parDelCd%>";
		
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<input type="hidden" name="usr_id"     value="<%=strUsr_id%>">
<input type="hidden" name="usr_nm"     value="<%=strUsr_nm%>">
<input type="hidden" name="usr_ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="delt_flg">
<input type="hidden" name="chk_tp">
<input type="hidden" name="loc_cd">

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
            
            <!--biz page (S)-->
            <table class="search"> 
                <tr>
                    <td class="bg">

                        <!--  biz_1  (S) -->
                        <table class="search" border="0" style="width:979;"> 
                            <tr class="h23">
                                <td width="120">
                                    Port&nbsp;<input type="text" style="width:50;ime-mode:disabled;" class="input" maxlength="5" dataformat="" fullfill="true" caption="Port" name="pod_cd" /></td>
                                <td width="">
                                    Saved Date
                                    <input type="text" style="width:75;" class="input" dataformat="ymd" maxlength="10" 
                                           caption="Saved Date Start Date" cofield="rtn_yd_sav_dt_e" name="rtn_yd_sav_dt_s" />
                                    <input type="text" style="width:75;" class="input" dataformat="ymd" maxlength="10" 
                                           caption="Saved Date End Date" cofield="rtn_yd_sav_dt_s" name="rtn_yd_sav_dt_e" />
                                    <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="img_dt" />
                                </td>
                                <td width="50">PICK YD</td>
                                <td width="110"><input type="text" style="width:70;ime-mode:disabled;" class="input" minlength="5" maxlength="8" dataformat="" caption="PICK YD" name="pkup_yd_id" /></td>
                                <td width="25">DEL</td>
                                <td width="70"><input type="text" style="width:50;ime-mode:disabled;" class="input" maxlength="5" dataformat="" fullfill="true" caption="DEL" name="fnl_dest_cd" /></td>
                                <td width="65">Return YD</td>
                                <td width="90"><input type="text" style="width:65;ime-mode:disabled;" class="input" minlength="5" maxlength="7" dataformat="" caption="Return YD" name="mcntr_rtn_yd_cd" /></td>
                                <td width="40">Office</td>
                                <td width=""><input type="text" style="width:50;ime-mode:disabled;" class="input" maxlength="5" dataformat="" fullfill="true" caption="Office" name="rtn_yd_sav_ofc_cd" /></td>
                            </tr>
                        </table>
                        <!--  biz_1   (E) -->                                
                                
                    </td>
                </tr>
            </table>
            <table class="height_8"><tr><td></td></tr></table>
                        
                        
                        
            <!-- Tab ) (S) -->
            <table class="tab" border="0" cellpadding="0" cellspacing="0"> 
                <tr><td><script language="javascript">ComTabObject('tab1')</script></td></tr>
            </table>
            <!-- Tab ) (E) -->
                
            <!--TAB Live (S) -->
            <div id="tabLayer" style="display:inline">
                <!-- Grid BG Box  (S) -->
                <table class="search" id="mainTable">
                    <tr>
                        <td class="bg">
                
                            
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
                                <tr>
                                    <td class="btn2_bg">
                                        <table border="0" cellpadding="0" cellspacing="0">
                                            <tr>
                                                <td>
                                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                        <tr>
                                                            <td class="btn2_left"></td>
                                                            <td class="btn2" name="btn_RowAdd" id="btn_RowAdd">Row&nbsp;Add</td>
                                                            <td class="btn2_right"></td>
                                                        </tr>
                                                    </table>
                                                </td>
                                                <td>
                                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                        <tr>
                                                            <td class="btn2_left"></td>
                                                            <td class="btn2" name="btn_Delete" id="btn_Delete">Row Delete</td>
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
                <!-- Grid BG Box  (S) -->
            </div>  
            <!--TAB Live (E) -->

            <!--TAB Delete (E) -->
            <div id="tabLayer" style="display:none">
                <!-- Grid BG Box  (S) -->
                <table class="search" id="mainTable">
                    <tr>
                        <td class="bg">                                                
                            <!-- Grid  (S) -->
                            <table width="100%"  id="mainTable">
                                <tr>
                                    <td width="100%">
                                        <script language="javascript">ComSheetObject('t2sheet1');</script>
                                    </td>
                                </tr>
                            </table>
                            <!-- Grid (E) -->                                                                
                                
                        </td>
                    </tr>
                </table>
                <!-- Grid BG Box  (S) -->       
            </div>  
            <!--TAB Delete (E) -->

            <!--biz page (E)-->
         

<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:2;"> 
    <tr>
        <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
                <tr> 
                    <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr><td class="btn1_left"></td>
                                <td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
                                <td class="btn1_right"></td>
                            </tr>
                        </table>
                    </td>
                     <td class="btn1_line"></td>
                    <td>
                        <table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
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
                                <td class="btn1" name="btn_DownExcel">Down&nbsp;Excel</td>
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
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp"%>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>