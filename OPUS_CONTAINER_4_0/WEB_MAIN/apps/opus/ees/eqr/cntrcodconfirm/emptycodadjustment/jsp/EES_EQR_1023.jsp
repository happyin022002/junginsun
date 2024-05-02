<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_EQR_1023.jsp
*@FileTitle : MTY Repo Inquiry by Period
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/20
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.event.EesEqr1023Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr1023Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         
    String strErrMsg = "";                      
    int rowCount     = 0;                       //DB ResultSet 

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
	String strCnt_cd		= "";

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
		strCnt_cd = account.getCnt_cd();


        event = (EesEqr1023Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        loadPage();
 
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="period" value="M">
<input type="hidden" name="inquiryLevel">
<input type="hidden" name="rpt_fromdate">
<input type="hidden" name="rpt_enddate">
<input type="hidden" name="rpt_location">
<input type="hidden" name="rpt_inpuirylevel">
<input type="hidden" name="rpt_div">
<input type="hidden" name="rpt_tpsz">
<input type="hidden" name="rpt_tpszlist">
<input type="hidden" name="prelocation">
<input type="hidden" name="rpt_cnt_cd"  value="<%=strCnt_cd%>" >

<!-- 제목 -->
<div class="page_title_area clear">
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- btn_div -->
	<div class="opus_design_btn">
	    <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
	    --><button type="button" class="btn_normal" name="btn_new" name="btn_new">New</button><!--
	    --><button type="button" class="btn_normal" name="btn_downExcel" name="btn_downExcel">Down Excel</button><!--
	    --><button type="button" class="btn_normal" name="btn_print" name="btn_print">Print</button>
	</div>

   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
</div>
<!-- 제목 -->

<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
			<!--  biz_1  (S) -->
            <table border="0" style="width:979px;"> 
            <tr>
                <th width="55px" class="align_left">&nbsp;&nbsp;Period</th>
                <td width="235px" class="stm">
                    <input type="text" style="width:75px;" class="input1" value="" name="fromdate" id="fromdate" required dataformat="ymd" maxlength="8">
                    &nbsp;~&nbsp;
                    <input type="text" style="width:75px;" class="input1" value="" name="enddate" id="enddate"  required dataformat="ymd" maxlength="8">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19px" height="20px" border="0" align="absmiddle" name="btns_calendarto"  id="btns_calendarfm" >
                </td>
                 <td width="250px">
                    <table border="0" style="width:230px;"> 
                        <tr>
                            <td width="">
                                <input type="radio" value="R" name="inquirylevel" class="trans" checked>&nbsp;RCC&nbsp;
                                <input type="radio" value="L" name="inquirylevel" class="trans"        >&nbsp;LCC&nbsp;
                                <input type="radio" value="E" name="inquirylevel" class="trans"        >&nbsp;ECC&nbsp;
                                <input type="radio" value="S" name="inquirylevel" class="trans"        >&nbsp;SCC
                            </td>
                        </tr>
                    </table>
                </td>
                <th width="54px" class="align_left">Location</th>
                <td width="80px">
                    <input type="text" style="width:50px;" class="input1" value="" dataformat="engup" style="ime-mode:disabled" name="location" maxlength="5" onBlur="obj_blur();">
                </td>
               
                <td width="60px">&nbsp;</td>
                <td>&nbsp;</td>
             </tr> 
             </table>
             <table border="0" style="width:979px;"> 
             <tr class="h23">
                <td width="290px" >
                    <table border="0" style="width:260px;"> 
                        <tr>
                            <th width="45px" class="align_left">&nbsp;Option</th>
                            <td width="*" class="stm">
                                <input type="radio" value="A" name="div" class="trans"        >&nbsp;ALL&nbsp;
                                <input type="radio" value="L" name="div" class="trans"        >&nbsp;Loading&nbsp;
                                <input type="radio" value="D" name="div" class="trans" checked>&nbsp;Discharging
                            </td>
                        </tr>
                    </table>
                </td>
                <th width="50px" class="align_left">TP/SZ</th>
                <td width="" style="padding-left:2">
                    <select style="width:65px;" class="input" name="tpsz" id="tpsz">
                        <option value="A" selected>ALL   </option>
                        <option value="D"         >DRY   </option>
                        <option value="S"         >SPCL  </option>
                        <option value="R"         >Reefer</option>
                    </select>&nbsp;<input type="text" style="width:233px;" class="input" value="" name="tpszlist" readonly>
                </td>
            </tr> 
            </table>
            <!--  biz_1   (E) -->
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_grid">
		<script language="javascript">ComSheetObject('sheet1');</script>
	</div>
</div>

</form>
