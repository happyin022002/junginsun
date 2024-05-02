<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_6010.jsp
*@FileTitle  : Waive Report by Office - Detail(s)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/18
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.waivereport.event.EesDmt6010Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%
    EesDmt6010Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB ResultSet list
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";
    String strUsr_id = "";
    String strUsr_nm = "";
    String tFmDt      = "";
    String tToDt      = "";
    String tReqApp    = "";
    String tSlctOfcCd = "";
    String tSlctTrfCd = "";
    String tSlctScNo  = "";
    String tSlctRfaNo = "";
    String tOfc_flg2 = "";
    String dmdt_cntr_tp_cd = "";
    String curr_flg = "";
    String ofc_cd2 = "";
    String strRhq_of = "";

    Logger log = Logger.getLogger("com.clt.apps.DMTPerformanceAnalysis.waivereport");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strRhq_of = account.getRhq_ofc_cd();

        event      = (EesDmt6010Event)request.getAttribute("Event");
        tFmDt      = StringUtil.xssFilter((String)request.getParameter("fm_dt"    ));
        tToDt      = StringUtil.xssFilter((String)request.getParameter("to_dt"    ));
        tReqApp    = StringUtil.xssFilter((String)request.getParameter("reqapp"   ));
        tSlctOfcCd = StringUtil.xssFilter((String)request.getParameter("slctofccd"));
        tSlctTrfCd = StringUtil.xssFilter((String)request.getParameter("slctTrfCd"));
        tSlctScNo  = StringUtil.xssFilter((String)request.getParameter("slctScNo" ));
        tSlctRfaNo = StringUtil.xssFilter((String)request.getParameter("slctRfaNo"));
        tOfc_flg2  = StringUtil.xssFilter((String)request.getParameter("ofc_flg2" ));
        dmdt_cntr_tp_cd  = StringUtil.xssFilter((String)request.getParameter("dmdt_cntr_tp_cd"));
        curr_flg  = StringUtil.xssFilter((String)request.getParameter("curr_flg"));
        ofc_cd2  = StringUtil.xssFilter((String)request.getParameter("ofc_cd2"));

        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script type="text/javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>

<form name="form" id="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="fm_dt" name="fm_dt" value="<%= tFmDt      %>" type="hidden" />
<input id="to_dt" name="to_dt" value="<%= tToDt      %>" type="hidden" />
<input id="reqapp" name="reqapp" value="<%= tReqApp    %>" type="hidden" />
<input id="ofc_flg2" name="ofc_flg2" value="<%= tOfc_flg2  %>" type="hidden" />
<input id="slctofccd" name="slctofccd" value="<%= tSlctOfcCd %>" type="hidden" />
<input id="slcttrfcd" name="slcttrfcd" value="<%= tSlctTrfCd %>" type="hidden" />
<input id="slctscno" name="slctscno" value="<%= tSlctScNo  %>" type="hidden" />
<input id="slctrfano" name="slctrfano" value="<%= tSlctRfaNo %>" type="hidden" />
<input id="curr_flg" name="curr_flg" value="<%= curr_flg   %>" type="hidden" />
<input id="dmdt_cntr_tp_cd" name="dmdt_cntr_tp_cd" value="<%= dmdt_cntr_tp_cd %>" type="hidden" />
<input id="ofc_cd2" name="ofc_cd2" value="<%= ofc_cd2    %>" type="hidden" />
<input id="bkg_no" name="bkg_no" type="hidden" />
<input id="cntr_no" name="cntr_no" type="hidden" />
<input id="bl_no" name="bl_no" type="hidden" />
<input id="dmdt_trf_cd" name="dmdt_trf_cd" type="hidden" />
<input id="svr_id" name="svr_id" type="hidden" />
<input id="cntr_cyc_no" name="cntr_cyc_no" type="hidden" />
<input id="dmdt_chg_loc_div_cd" name="dmdt_chg_loc_div_cd" type="hidden" />
<input id="chg_seq" name="chg_seq" type="hidden" />
<input id="h_rhq_off" name="h_rhq_off" value="<%=strRhq_of%>" type="hidden" />
<!-- Parameters for checking authority  -->
<input id="role_permit" name="role_permit" type="hidden" />
<input id="role_auth" name="role_auth" type="hidden" />

<div class="layer_popup_title"> 
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Waive Report by Office - Detail</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button type="button" id="btn_bkg" name="btn_bkg" class="btn_accent">by BKG</button><!--
			--><button type="button" id="btn_cntr" name="btn_cntr" class="btn_normal">by CNTR</button><!--
			--><button type="button" id="btn_down" name="btn_down" class="btn_normal">Down Excel</button><!--
			--><button type="button" id="btn_close" name="btn_close" class="btn_normal">Close</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents" style="overflow:hidden!important">
	<div class="wrap_result">
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<table>
			<tbody>
				<colgroup>
					<col width="70"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>CNTR Q'ty</th>
					<td><input type="text" name="cntrqtybox" id="cntrqtybox" style="width:50;text-align:right;" readonly ></td>				
				</tr>
			</tbody>
		</table>
	</div>
</div>
	
</form>         