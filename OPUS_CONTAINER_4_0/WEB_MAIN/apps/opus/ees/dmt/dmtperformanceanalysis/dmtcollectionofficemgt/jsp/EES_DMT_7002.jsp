<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_7002.jsp
*@FileTitle  : DEM/DET Office Inquiry by Yard
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.event.EesDmt7002Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
    EesDmt7002Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strUsr_of        = "";
    String strUsr_lc        = "";
    Logger log = Logger.getLogger("com.clt.apps.DMTPerformanceAnalysis.DMTCollectionOfficeMgt");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strUsr_of = account.getOfc_cd();
        strUsr_lc = account.getCnt_cd();


        event = (EesDmt7002Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // Retrieving the parameter values ​​for calls to pop-up page ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script type="text/javascript">
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
<input type="hidden" name="conti_cd">
<input type="hidden" name="cnt_cd">
<input type="hidden" name="rgn_cd">
<input type="hidden" name="ste_cd">
<input type="hidden" name="loc_cd">
<input type="hidden" name="yd_cd">

<input type="hidden" name="dmdt_trf_cd">
<input type="hidden" name="cvrg_conti_cd">
<input type="hidden" name="cvrg_cnt_cd">
<input type="hidden" name="cvrg_rgn_cd">
<input type="hidden" name="cvrg_ste_cd">
<input type="hidden" name="cvrg_loc_cd">
<input type="hidden" name="cvrg_yd_cd">
<input type="hidden" name="org_dest_conti_cd">
<input type="hidden" name="org_dest_cnt_cd">
<input type="hidden" name="org_dest_rgn_cd">
<input type="hidden" name="org_dest_ste_cd">
<input type="hidden" name="org_dest_loc_cd">

<input type="hidden" name="svr_id">
<input type="hidden" name="trf_seq">
<input type="hidden" name="trf_grp_seq">

<input type="hidden" name="wknd1" value="SAT">
<input type="hidden" name="wknd2" value="SUN">

<input type="hidden" name="demdetoff">
<input type="hidden" name="countrycd">
<input type="hidden" name="yardlocat">
<input type="hidden" name="yardnodee">
<input type="hidden" name="h_user_office"  value="<%= strUsr_of %>"  >
<input type="hidden" name="usr_ofc_cd" value="<%= strUsr_of %>">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="tmp_ofc_cd">
<input type="hidden" name="usr_cnt_cd" value="<%= strUsr_lc %>">

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_downExcel" id="btn_downExcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->

   	<!-- page_location(S) -->
   	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
        <span id="navigation"></span>
   	</div>
   	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <table>
    	<colgroup>
            <col width="105" />
            <col width="255" />
            <col width="80" />
            <col width="90" />
            <col width="" />
        </colgroup>
        <tbody>
			<tr class="h23">
				<th>DEM/DET Office </th>
                <td>
                    <script type="text/javascript">ComComboObject('office',1,80,0,0,0,true);</script>&nbsp;
                    <button type="button"  class="multiple_inq ir"></button>
                    <input type="checkbox" name="chk_sub_ofc" value="Y" onClick="doInclSubOfc()"  class="trans">&nbsp;Incl. Sub Office                        
                </td>
                <th>Collection </th>
                <td style="padding-left:5px;">I/B
                    <select style="width:60px;" class="input" name="collectib" id="collectib">
                        <option value="A" selected>All</option>
                        <option value="Y"         >Yes</option>
                        <option value="N"         >No </option>
                    </select>
                </td>
                <td class="stm">O/B
                    <select style="width:60px;" class="input" name="collectob" id="collectob">
                        <option value="A" selected>All</option>
                        <option value="Y"         >Yes</option>
                        <option value="N"         >No </option>
                    </select>
                </td>
			</tr>
		</tbody>
	</tabble>
	<table>
    	<colgroup>
            <col width="105" />
            <col width="50" />
            <col width="50" />
            <col width="147" />
            <col width="80" />
            <col width="" />
        </colgroup>
        <tbody>
			<tr class="h23">
				<th>Country </th>
                <td>
                    <script type="text/javascript">ComComboObject('combo3', 2, 50 , 0, 0, 0, true)</script>
                </td>
                <th>Yard</th>
                <td>
                    <input type="text" id="yd_cd1" name="yd_cd1" style="width:60px;" class="input" value=""  maxlength="5" style="ime-mode:disabled" dataformat="engup" OnKeyUp="checkYard1(this)"><!-- 
                    --><script type="text/javascript">ComComboObject('combo5', 2, 50 , 0, 0, 0, true)</script>                        
                </td>
                <th style="padding-left:20px">Yard Status </th>
                <td class="stm" style="padding-left: 11px;"> 
                    <select style="width:60px;" class="input" name="yarddelyn" id="yarddelyn">
                        <option value="A"         >All   </option>
                        <option value="N" selected>Live  </option>
                        <option value="Y"         >Deleted</option>
                    </select>
                </td>
			</tr>
		</tbody>
	</table>
	<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result" style="padding-bottom:46px">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <script type="text/javascript">ComSheetObject('sheet1');</script>
    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
<!-- opus_design_grid(E) -->
</div>
<!-- page(E) -->

</form>