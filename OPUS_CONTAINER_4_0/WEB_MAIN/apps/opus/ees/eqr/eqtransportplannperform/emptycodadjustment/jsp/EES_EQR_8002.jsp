<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ees_eqr_1050.jsp
*@FileTitle  : Match-back by Vessel
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/14
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>
<%@ page import="com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.event.EesEqr8002Event"%>
<%@ page import="com.clt.apps.opus.ees.eqr.common.eqrcommon.basic.CommonBC"%>
<%@ page import="com.clt.apps.opus.ees.eqr.common.eqrcommon.basic.CommonBCImpl"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesEqr8002Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
	String strCnt_cd		= "";
    Logger log = Logger.getLogger("com.clt.apps.eqtransportplannperform.emptycodadjustment");
    CommonBC tpszUtil = new CommonBCImpl(); 	//Combo BOX
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
		strCnt_cd = account.getCnt_cd();


        event = (EesEqr8002Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // adding logic to get data from server when first loading ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script type="text/javascript">
	<%= tpszUtil.getTpSzCodeCombo("eqr", "hidtpszall", "", "", "", "Y", "")%>
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        loadPage();
        //document.form.froms.focus();      
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="period" value="M" id="period" />
<input type="hidden" name="inquiryLevel" id="inquiryLevel" />
<input type="hidden" name="rpt_fromdate" id="rpt_fromdate" />
<input type="hidden" name="rpt_enddate" id="rpt_enddate" />
<input type="hidden" name="rpt_location" id="rpt_location" />
<input type="hidden" name="rpt_inpuirylevel" id="rpt_inpuirylevel" />
<input type="hidden" name="rpt_div" id="rpt_div" />
<input type="hidden" name="rpt_tpsz" id="rpt_tpsz" />
<input type="hidden" name="rpt_tpszlist" id="rpt_tpszlist" />
<input type="hidden" name="prelocation" id="prelocation" />
<input type="hidden" name="rpt_cnt_cd" value="<%=strCnt_cd%>" id="rpt_cnt_cd" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new"  	id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_downExcel" 	id="btn_downExcel">Down Excel</button><!--
		 --><button type="button" class="btn_normal" name="btn_print"  	id="btn_print">Print</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>

	<!-- page_title_area(E) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="50">
				<col width="220">
				<col width="20">
				<col width="240">
				<col width="80">
				<col width="60">
				<col width="80">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Period</th>
                    <td><input type="text" style="width:75px;text-align:center;" class="input1" value="" name="fromdate" required dataformat="ymd" maxlength="10" id="fromdate" /><!--
                    --><span class="dash">~</span><input type="text" style="width:75px;text-align:center;" class="input1" value="" name="enddate" required dataformat="ymd" maxlength="10" id="enddate" /><!--
                    --><button type="button" class="calendar ir" name="btns_calendarfm" id="btns_calendarfm"></button></td>
                    <td></td>
        			<td class="sm pad_left_8 pad_rgt_8"><!--
        			--><input type="radio" value="R" name="inquirylevel" class="trans" id="inquirylevel1" checked /><label for="inquirylevel1">RCC</label><!--
        			--><input type="radio" value="L" name="inquirylevel" class="trans" id="inquirylevel2" /><label for="inquirylevel2">LCC</label><!--
        			--><input type="radio" value="E" name="inquirylevel" class="trans" id="inquirylevel3" /><label for="inquirylevel3">ECC</label><!--
        			--><input type="radio" value="S" name="inquirylevel" class="trans" id="inquiryleve4" /><label for="inquiryleve4">SCC</label></td>
                    <th>Location</th>
                    <td><input type="text" style="width:50px;text-align:center;" class="input1" value="" dataformat="engup" name="location" maxlength="5" id="location" /></td>
                    <th>Company</th>
                    <td><input type="text" style="width:35px" class="input" value="<%=ConstantMgr.getCompanyCode ()%>" readonly></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="50">
				<col width="220">
				<col width="20">
				<col width="40">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
                    <th class="sm">Option</th>
                    <td class="sm"><!--
                    --><input type="radio" value="A" name="div" class="trans" id="div1" /><label for="div1">ALL</label><!--
                    --><input type="radio" value="L" name="div" class="trans" id="div2" /><label for="div2">Loading</label><!--
                    --><input type="radio" value="D" name="div" class="trans" checked id="div3" /><label for="div3">Discharging</label></td>
                    <td></td>
                    <th>TP/SZ</th>
                    <td><select style="width:65px;" class="input" name="tpsz" id="tpsz">
                    	<option value="A" selected>ALL</option>
                    	<option value="D">DRY</option>
                    	<option value="S">SPCL</option>
                    	<option value="R">Reefer</option>
                        </select><!--
                        --><input type="text" style="width:261px;" class="input" value="" name="tpszlist" id="tpszlist" readonly>
                    </td>
                </tr> 
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->	
</div>

<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
</div>
</form>