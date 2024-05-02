<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1066.jsp
*@FileTitle : Pick up No Notice Manual Send
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.27
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.11.27 박미옥
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1066Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg1066Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strOfc_cd        = "";
    
    String strPre_Bl_No     = "";
    
    Logger log = Logger.getLogger("com.hanjin.apps.InboundBLMgtSC.PickUpNoticeBC");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOfc_cd = account.getOfc_cd();

        strPre_Bl_No = JSPUtil.getParameter(request, "bl_no");

        event = (EsmBkg1066Event)request.getAttribute("Event");
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
<title>Pick up No Notice Manual Setup</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        
        document.form.bl_no.value = "<%=strPre_Bl_No%>";

        loadPage();
    }
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업 -->

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
                                <td width="808">
                                    <table class="search_sm2" border="0" style="width:805;"> 
                                        <tr class="h23">
                                            <td width="155">
                                                <input type="radio" class="trans" name="sch_tp_cd" value="DATE" />&nbsp;
                                                <select style="width:120;" name="dt_tp_cd" class="input1">
                                                    <option value="SENT">(Exp)Send Date</option>
                                                    <option value="UPLOAD">P/U Upload Date</option>
                                                    <option value="ATA">POD ATA</option>
                                                </select>
                                            </td>
                                            <td width="200">
                                                <input type="text" style="width:75;" class="input1" dataformat="ymd" maxlength="10" 
                                                       caption="ATA POD Start Date" cofield="dt_e" name="dt_s" />&nbsp;
                                                <input type="text" style="width:75;" class="input1" dataformat="ymd" maxlength="10" 
                                                       caption="ATA POD End Date" cofield="dt_s" name="dt_e" />&nbsp;
                                                <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="img_dt" />
                                            </td>

                                            <td width="">
                                                <input type="radio" class="trans" name="sch_tp_cd" value="MVMT" />&nbsp;MVMT                                
                                            </td>                                            
                                            <td width="60">
                                                <select style="width:55;" class="input1" name="mvmt_cd">
                                                    <option value="">All</option>
                                                    <option value="NT">NT</option>
                                                    <option value="NF">NF</option>
                                                    <option value="AR">AR</option>
                                                    <option value="RL">RL</option>
                                                </select>
                                            </td>                                            
                                                                                        
                                            <td width="330">
                                                <input type="text" style="width:75;" class="input1" dataformat="ymd" maxlength="10" 
                                                       caption="MVMT Start Date" cofield="dt_mvmt_e" name="dt_mvmt_s" />                                                
                                                <input type="text" style="width: 44" class="input1" dataformat="hm" maxlength="5" 
                                                        caption="MVMT Start Time" name="tm_mvmt_s" />&nbsp;&nbsp;~&nbsp;                                                    
                                                <input type="text" style="width:75;" class="input1" dataformat="ymd" maxlength="10" 
                                                       caption="MVMT End Date" cofield="dt_mvmt_s" name="dt_mvmt_e" />                                                       
                                                <input type="text" style="width: 44" class="input1" dataformat="hm" maxlength="5"  
                                                       caption="MVMT End Time" name="tm_mvmt_e" />&nbsp;                                           
                                                <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="img_mvmt_dt" />
                                            </td>                                            

                                        </tr> 
                                    </table>
                                </td>
                    
                    
                                <td width="48">&nbsp;EQ OFC</td>
                                <td width="65">
                                    <input type="text" style="width:50;ime-mode:disabled;" class="input" name="eq_ofc_cd" 
                                        caption="EQ Office" maxlength="5" minlength="5" dataformat="" fullfill="true" />
                                </td>
                                <td width="30">O.W.</td>
                                <td width=""><input type="checkbox" class="trans" name="ow_flag"></td>
                    
                            </tr> 
                        </table>                
                        <table class="height_2"><tr><td></td></tr></table>
                        <table class="search" border="0" style="width:979;"> 
                            <tr class="h23">
                                <td width="194">
                                    <table class="search_sm2" border="0" style="width:190;"> 
                                        <tr class="h23">
                                            <td width="70">
                                                <input type="radio" class="trans" name="sch_tp_cd" value="BL" />B/L No.
                                            </td>
                                            <td width="">
                                                <input type="text" style="width:110;ime-mode:disabled;" class="input1"   
                                                       dataformat="" maxlength="13" caption="B/L No." name="bl_no" />
                                            </td>
                                        </tr> 
                                    </table>
                                </td>
                                <td width="62">Rail Co.</td>
                                <td width="70">
                                    <select style="width:60;" class="input1" name="rail_co_cd">
                                        <option value="">ALL</option>
                                        <option value="B">CP,CN</option>
                                    </select>
                                </td>
                                <td width="32">Sent</td>
                                <td width="90">
                                    <select style="width:80;" class="input1" name="snd_sts_cd">
                                        <option value="">All</option>
                                        <option value="N">Un-Sent</option>
                                        <option value="F">Fail</option>
                                        <option value="S">Success</option>
                                        <option value="P">Processing</option>
                                        <option value="Y">Sent</option>
                                    </select>
                                </td>
                                <td width="75">Sent Type</td>
                                <td width="75">
                                    <select style="width:68;" class="input1" name="ntc_tp_cd">
                                        <option value="">All</option>
                                        <option value="PP">Time</option>
                                        <option value="FC">F/O/C</option>
                                        <option value="MA">Manual</option>
                                    </select>
                                </td>
                                <td width="25">FOC</td>
                                <td width="85">
                                    <select style="width:78;" class="input1" name="foc_tp_cd">
                                        <option value="">All</option>
                                        <option value="C">Clear</option>
                                        <option value="N">Not Clear</option>
                                    </select>
                                </td>

                                <td width="70">Update ID</td>
                                <td width="">
                                    <input type="text" style="width:80;ime-mode:disabled;" class="input" name="upd_usr_id" 
                                        caption="Update ID" maxlength="20" />
                                </td>
                                
                                <td width="57">&nbsp;Pending</td>
                                <td width=""><input type="checkbox" class="trans" name="contact_flag"></td>

                                <td width="35">&nbsp;Stop</td>
                                <td width=""><input type="checkbox" class="trans" name="stop_flag"></td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
                
                
            <!--  biz_1   (E) -->
            
            <table class="height_8"><tr><td></td></tr></table>
                
            <!-- Tab ) (S) -->
            <table class="tab" border="0" cellpadding="0" cellspacing="0" width="979"> 
                <tr>
                    <td width="979">
                        <script language="javascript">ComTabObject('tab1')</script>
                        <!-- img src="/img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
                    </td>
                </tr>
            </table>
            <!-- Tab ) (E) -->

<!--TAB 1 (S) -->
<div id="tabLayer" style="display:inline">


            <table class="search"> 
                <tr>
                    <td class="bg">
            
            
                        <!--Grid (s)-->
                        <table width="100%"  id="mainTable">
                            <tr>
                                <td width="100%">
                                    <script language="javascript">ComSheetObject('sheet1');</script>
                                </td>
                            </tr>
                        </table>
                        <!--Grid (E)-->
                        
                        <!--  Button_Sub (S) -->
                        <table width="100%" class="button" border="0"> 
                            <tr>
                                <td class="btn2_bg">
                                    <table border="0" cellpadding="0" cellspacing="0">
                                        <tr>                    

                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr>
                                                        <td class="btn2_left"></td>
                                                        <td class="btn2" name="btn_CustomerInfo">Customer Info</td>
                                                        <td class="btn2_right"></td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr>
                                                        <td class="btn2_left"></td>
                                                        <td class="btn2" name="btn_MasterData">Master Data</td>
                                                        <td class="btn2_right"></td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr>
                                                        <td class="btn2_left"></td>
                                                        <td class="btn2" name="btn_MultiContact">Multi-Contact</td>
                                                        <td class="btn2_right"></td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr>
                                                        <td class="btn2_left"></td>
                                                        <td class="btn2" name="btn_RailAMSHistory">Rail AMS History</td>
                                                        <td class="btn2_right"></td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr>
                                                        <td class="btn2_left"></td>
                                                        <td class="btn2" name="btn_UsIor">US IOR</td>
                                                        <td class="btn2_right"></td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr>
                                                        <td class="btn2_left"></td>
                                                        <td class="btn2" id="btn_ReceiverSetup" name="btn_ReceiverSetup">Receiver Setup</td>
                                                        <td class="btn2_right"></td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr>
                                                        <td class="btn2_left"></td>
                                                        <td class="btn2" name="btn_FormSetup">Form Setup</td>
                                                        <td class="btn2_right"></td>
                                                    </tr>
                                                </table>
                                            </td>
                                            
                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr>
                                                        <td class="btn2_left"></td>
                                                        <td class="btn2" name="btn_DownExcel">Down Excel</td>
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
                                <td>
                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_New">New</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
                                <td class="btn1_line"></td>
                                <td>
                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_PickUpNoUpload">Pick-Up No Upload</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
                                <td>
                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_StopSend">Stop Send</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
                                <td>
                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_ResumeSend">Resume Send</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
                                <td>
                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_Save">Save</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
                                <td>
                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_Fax">Fax</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
                                <td>
                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_Email">E-Mail</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
                                <td>
                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_Preview">Preview</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
                                <td>
                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_ManualSetup">Manual Setup</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
                                <td>
                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_SendHistory">Send History</td>
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