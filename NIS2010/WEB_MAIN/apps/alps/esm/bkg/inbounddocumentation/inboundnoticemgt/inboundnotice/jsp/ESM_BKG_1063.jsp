<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1063.jsp
*@FileTitle : Pick up down-load
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.10.21 박미옥
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1063Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1063Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "500";

	String strUsr_id		= "";
	String strUsr_nm		= "";
    String strPgmNo         = ""; 
    
    String strPre_popUp     = "";
    String strSch_tp_cd     = "";
    String strPre_bl_no     = "";
    
	Logger log = Logger.getLogger("com.hanjin.apps.InboundBLMgt.PickUpNotice");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		strPre_popUp = JSPUtil.getParameter(request, "popUp");
		strSch_tp_cd = JSPUtil.getParameter(request, "sch_tp_cd");
		strPre_bl_no = JSPUtil.getParameter(request, "bl_no");

        strPgmNo = JSPUtil.getParameter(request, "pgmNo");
		event = (EsmBkg1063Event)request.getAttribute("Event");
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
<title>Pick up down-load</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
		<%if ("Y".equals(strPre_popUp)) {%>
		document.form.flag.value   = "ESM_BKG_1063-01";
		document.form.popUp.value  = "Y";
		document.form.p_sch_tp_cd.value = "<%=strSch_tp_cd%>";
		document.form.p_bl_no.value  = "<%=strPre_bl_no%>";
		<%}%>
		
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd" />
<input type="hidden" name="popUp" />
<input type="hidden" name="p_sch_tp_cd" />
<input type="hidden" name="p_bl_no" />

<input type="hidden" name="pagerows" value="<%=pageRows %>" />
<!-- 개발자 작업	-->

<input type="hidden" name="flag"             value="<%=strPgmNo%>" />

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
            <table class="height_2"><tr><td></td></tr></table>
            <!-- Tab (S) -->
            <table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%"> 
                <tr><td width="100%">
                        <script language="javascript">ComTabObject('tab1')</script>
                </td></tr>
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
                
                        <!--  biz_1  (S) -->                    
                        <table class="search" border="0" style="width:979;"> 
                            <tr class="h23">
                                <td width="860">
                                    <table class="search_sm2" border="0" style="width:840;"> 
                                        <tr class="h23">
                                            <td width="25"><input type="radio" class="trans" name="sch_tp_cd" value="VVD" />VVD</td>
                                            <td width="85">
                                                <input type="text" style="width:77;ime-mode:disabled;" class="input1" 
                                                       dataformat="" minlength="9" maxlength="9" caption="VVD" fullfill="true" name="vvd" />
                                            </td>
                                            <td width="80"><input type="radio" class="trans" name="sch_tp_cd" value="ATA" />POD ATA</td>
                                            <td width="220">
                                                <input type="text" style="width:75;" class="input1" dataformat="ymd" maxlength="10" 
                                                       caption="ATA POD Start Date" cofield="dt_e" name="dt_s" />&nbsp;
                                                <input type="text" style="width:75;" class="input1" dataformat="ymd" maxlength="10" 
                                                       caption="ATA POD End Date" cofield="dt_s" name="dt_e" />&nbsp;
                                                <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="img_dt" />
                                            </td>
                                            <td width="70"><input type="radio" class="trans" name="sch_tp_cd" value="BL" />B/L No.</td>
                                            <td width="110">
                                                <input type="text" style="width:110;ime-mode:disabled;" class="input1"   
                                                       dataformat="" maxlength="13" caption="B/L No." name="bl_no" />
                                            </td>
                                            <td width="80"><input type="radio" class="trans" name="sch_tp_cd" value="CN" />CNTR No.</td>
                                            <td width="">
                                                <input name="cntr_no" id ="cntr_no" type="hidden">
                                                <input type="text" style="width:100;ime-mode:disabled;" class="input1"  
                                                       dataformat="" minlength="10" maxlength="10" caption="Container No." fullfill="true" name="cntr_no_nonbit" />
                                               <input type="text" style="width:22" class="input2" maxlength="1" readonly="" name ="cntr_no_split">
                                            </td>                                        
                                        </tr> 
                                    </table>
                                </td>
                                <td width="50">EQ OFC</td>
                                <td width="">
                                    <input type="text" style="width:53;ime-mode:disabled;" class="input" name="ofc_cd" value="" 
                                        caption="Office" maxlength="5" minlength="5" dataformat="" fullfill="true" />
                                </td>
                            </tr> 
                        </table>                                                                            
                        <!--  biz_1   (E) -->
                        
                        <!--Grid (s)-->
                        <table width="100%"  id="mainTable">
                            <tr>
                                <td width="100%">
                                <script language="javascript">ComSheetObject('t2sheet1');</script>
                                <script language="javascript">ComSheetObject('t2sheet2');</script>
                                </td>
                            </tr>
                        </table>
                        <!--Grid (E)-->
                                
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
                        <table border="0" cellpadding="0" cellspacing="0" align="left">
                            <tr>
                                <td>
                                    <div id="div_cre_tp1">
                                        <table class="search" border="0" width="" align="right">
                                            <tr class="h23">
                                                <td width="125">Filter 
                                                    <select style="width:85;" class="input1" name="cre_tp_cd1">
                                                        <option value="">All</option>
                                                        <option value="N">Not Created</option>
                                                        <option value="C">Created</option>
                                                    </select>
                                                </td>
                                            </tr>
                                        </table>
                                    </div>

                                    <div id="div_cre_tp2">
                                        <table class="search" border="0" width="" align="right">
                                            <tr class="h23">
                                                <td width="125">Filter 
                                                    <select style="width:85;" class="input1" name="cre_tp_cd2">
                                                        <option value="">All</option>
                                                        <option value="N">Not Created</option>
                                                        <option value="C">Created</option>
                                                    </select>
                                                </td>
                                            </tr>
                                        </table>
                                    </div>
                                </td>
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
                                            <td class="btn1" name="btn_New" id="btn_New">New</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
                                <td class="btn1_line"></td>
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
                                        <tr><td class="btn1_left"></td>
                                        <td class="btn1" name="btn_Upload" id="btn_Upload">Upload</td>
                                        <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
                                <td>
                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_DataSetup" id="btn_DataSetup">Data Setup</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
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
                                            <td class="btn1" name="btn_PickupSend" id="btn_PickupSend">Pickup Send</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
            
                                <td>
                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_DownExcel" id="btn_DownExcel">Down Excel</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
                                <td>
                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_History" id="btn_History">History</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
                                <td>
                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_RtnYD" id="btn_RtnYD">RTN YD</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
                                <td>
                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_Batch">Batch</td>
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