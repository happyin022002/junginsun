<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0510.jsp
*@FileTitle : Hold Notice Send
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.08.31 박미옥
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0510Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0510Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strPgmNo         = ""; 
    String strOfc_cd        = "";
	Logger log = Logger.getLogger("com.hanjin.apps.InboundBLMgt.HoldNotice");

	String vvdCd = "";
	String podCd = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
        strOfc_cd = account.getOfc_cd();

		strPgmNo = JSPUtil.getParameter(request, "pgmNo");
		event = (EsmBkg0510Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		vvdCd = JSPUtil.getNullNoTrim(request.getParameter("vvd_cd"));
		podCd = JSPUtil.getNullNoTrim(request.getParameter("pod_cd"));
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Hold Notice Send</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd" />
<input type="hidden" name="pagerows" />
<!-- 개발자 작업	-->

<input type="hidden" name="flag"             value="<%=strPgmNo%>" />
<input type="hidden" name="usr_id"           value="<%=strUsr_id%>" />
<input type="hidden" name="usr_ofc_cd"       value="<%=strOfc_cd%>" />
<input type="hidden" name="com_mrdPath"      value="" />
<input type="hidden" name="com_mrdArguments" value="" />
<input type="hidden" name="com_mrdTitle" value="">
<input type="hidden" name="com_mrdDisableToolbar" value=""> 
<input type="hidden" name="com_mrdBodyTitle" value="">

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
        
            <table class="search"> 
                <tr>
                    <td class="bg">
            
                        <!--  biz_1  (S) -->
                        
                        <table class="search" border="0" style="width:979;"> 
                            <tr class="h23">
                                <td width="650">
                                    <table class="search_sm" border="0" style="width:620;"> 
                                        <tr class="h23">
                                            <td width="25"><input type="radio" class="trans" name="sch_tp_cd" value="VVD" />VVD</td>
                                            <td width="85">
                                                <input type="text" style="width:77;ime-mode:disabled;" class="input1" dataformat="" minlength="9" maxlength="9" caption="VVD" fullfill="true" name="vvd" value="<%=vvdCd%>"/>
                                            </td>
                                            <td width="80"><input type="radio" class="trans" name="sch_tp_cd" value="ETA" />POD ETA</td>
                                            <td width="220">
                                                <input type="text" style="width:75;" class="input1" dataformat="ymd" maxlength="10"  caption="POD ETA Start Date" cofield="dt_e" name="dt_s" />
                                                <input type="text" style="width:75;" class="input1" dataformat="ymd" maxlength="10"  caption="POD ETA End Date" cofield="dt_s" name="dt_e" />
                                                <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="img_dt" />
                                            </td>
                                            <td width="70"><input type="radio" class="trans" name="sch_tp_cd" value="BL" />B/L No.</td>
                                            <td width="">
                                                <input type="text" style="width:110;ime-mode:disabled;" class="input1"   
                                                       dataformat="" maxlength="13" caption="B/L No." name="bl_no" />
                                            </td>
                                        </tr> 
                                    </table>
                                </td>
                                <td width="25">POD</td>
                                <td width="65">
                                    <input type="text" style="width:50;ime-mode:disabled;" class="input" name="pod_cd" value="<%=podCd%>" 
                                        caption="POD" maxlength="5" minlength="5" dataformat="eng" fullfill="true" />
                                </td>
                                <td width="25">DEL</td>
                                <td width="65">
                                    <input type="text" style="width:50;ime-mode:disabled;" class="input" name="del_cd" value="" 
                                        caption="DEL" maxlength="5" minlength="5" dataformat="eng" fullfill="true" />
                                </td>
                                <td width="80">Sent Result</td>
                                <td width="">
                                    <select style="width:70;" class="input1" name="snd_rslt_cd">
                                        <option value="ALL">All</option>
                                        <option value="">Not Send</option>
                                        <option value="S">Success</option>
                                        <option value="F">Fail</option>
                                    </select>
                                </td>
                            </tr> 
                        </table>    
            
                        <table class="search" border="0" style="width:979;"> 
                            <tr class="h23">
                                <td width="75">&nbsp;&nbsp;&nbsp;&nbsp;CNTR No.</td>
                                <td width="">
                                    <input type="text" style="width:100;ime-mode:disabled;" class="input"  
                                        dataformat="" maxlength="14" caption="Container No." name="cntr_no" />
                                </td>
                            </tr> 
                        </table>                
                
                    </td>
                </tr>
            </table>
            <!--  biz_1   (E) -->
            
            <table class="height_8"><tr><td></td></tr></table>
            
            <!-- Tab (S) -->
            <table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%"> 
                <tr>
                    <td width="100%">
                        <script language="javascript">ComTabObject('tab1')</script>
                    </td>
                </tr>
            </table>
            <!-- Tab (E) -->
                
<!--TAB Pre-Hold Notice (S) -->
<div id="tabLayer" style="display:inline">
                
            <table class="search"> 
                <tr>
                    <td class="bg">
            
            
                        <!--Grid (s)-->
                        <table width="100%"  id="mainTable">
                            <tr>
                                <td width="100%">
                                    <script language="javascript">ComSheetObject('t1sheet1');</script>
                                </td>
                            </tr>
                        </table>    
                        <!--Grid (E)-->
                        
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
                                                        <td class="btn2" name="btn_t1Preview">Preview</td>
                                                        <td class="btn2_right"></td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr>
                                                        <td class="btn2_left"></td>
                                                        <td class="btn2" name="btn_t1FormSetting">Form Setup</td>
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
<!--TAB Pre-Hold Notice (E) -->


<!--TAB Confirmation Notice (S) -->
<div id="tabLayer" style="display:inline">

            <table class="search"> 
                <tr>
                    <td class="bg">
            
                        <!--Grid (s)-->
                        <table width="100%"  id="mainTable">
                            <tr>
                                <td width="100%">
                                    <script language="javascript">ComSheetObject('t2sheet1');</script>
                                </td>
                            </tr>
                        </table>
                        <!--Grid (E)-->
                        
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
                                                        <td class="btn2" name="btn_t2GotoTPB">TPB Issue</td>
                                                        <td class="btn2_right"></td>
                                                    </tr>
                                                </table>
                                            </td>

                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr>
                                                        <td class="btn2_left"></td>
                                                        <td class="btn2" name="btn_t2Preview">Preview</td>
                                                        <td class="btn2_right"></td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr>
                                                        <td class="btn2_left"></td>
                                                        <td class="btn2" name="btn_t2FormSetting">Form Setup</td>
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
            <!-- Grid BG Box  (E) -->

</div>
<!--TAB Confirmation Notice (E) -->
    
            <!--biz page (E)-->
            
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
                                            <td class="btn1" name="btn_CustomsResult">Customs Result</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
                                
                                <td>
                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_Fax_Send">Fax</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
                                
                                <td>
                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_Email_Send">E-mail</td>
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
                                <td>
                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_ListPrint">List Print</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
                                <td>
                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_SentHistory">Sent History</td>
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
                        <script language="javascript">ComSheetObject('t1sheet2');</script>
                        <script language="javascript">ComSheetObject('t2sheet2');</script>
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