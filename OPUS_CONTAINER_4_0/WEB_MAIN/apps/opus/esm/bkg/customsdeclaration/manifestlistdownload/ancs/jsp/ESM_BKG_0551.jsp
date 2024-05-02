<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0551.jsp
*@FileTitle  : SSR Create
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/13
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.event.EsmBkg0551Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0551Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmBkg0551Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // If you imported data from the server initialization when loading
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

<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="frm_attr_ctnt2">
<input type="hidden" name="chk_down">


<%
    String vvd   = (request.getParameter("vvd") == null)? "":request.getParameter("vvd");
    String ssrNo = (request.getParameter("ssr_no")== null)?"":request.getParameter("ssr_no");
    String pod   = (request.getParameter("pod")== null)?"":request.getParameter("pod");
%>

<!-- page_title_area(S) -->
<div class="page_title_area clear">
    <!-- page_title(S) -->
    <h2 class="page_title">
        <button type="button">
            <span id="title"></span>
        </button>
    </h2>
    <!-- page_title(E) -->

    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
    	<button class="btn_normal" name="btn_Delete" id="btn_Delete" type="button" style="display:none">Data Delete</button><!--
       	 --><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
        --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!-- 
        --><button type="button" class="btn_normal" name="btn_BLList" id="btn_BLList">B/L List</button><!-- 
        --><button type="button" class="btn_normal" name="btn_SSRView" id="btn_SSRView">SSR View</button><!-- 
        --><button type="button" class="btn_normal" name="btn_Download" id="btn_Download">Download</button><!-- 
        --><button type="button" class="btn_normal" name="btn_addLane" id="btn_addLane">Add Lane</button>
    </div>
    <!-- opus_design_btn(E) -->

    <!-- page_location(S) -->
    <div class="location">
        <span id="navigation"></span>
    </div>
    <!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
<!-- inquiry_area(S) -->
<div class="opus_design_inquiry wFit">
    <!--  biz_1 (S) -->
    <table>
        <colgroup>
            <col width="100px" />
            <col width="245px" />
            <col width="30px"  />
            <col width="135px" />
            <col width="30px"  />
            <col width="115px" />
            <col width="48px"  />
            <col width="135px" />
            <col width="35px"  />
            <col width=""      />
        </colgroup>
        <tbody>
            <tr>
                <th>Call Date (ETA)</th>
                <td><input type="text" style="width: 80px; ime-mode: disabled" class="input1" value="" dataformat="ymd" maxlength="10" name="s_vps_eta_dt" dataformat="eng" caption="ETA" cofield="e_vps_eta_dt"><!--  
                       	--><span class="dash">~</span><input type="text" style="width: 80px; ime-mode: disabled" class="input1" value="" dataformat="ymd" maxlength="10" name="e_vps_eta_dt" dataformat="eng" caption="ETA" cofield="s_vps_eta_dt"><!--  
                        --><button type="button" class="calendar ir" name="btn_calendar" id="btn_calendar"></button>
                </td>
                <th title="Vessel Voyage Direction">VVD</th>
                <td><input type="text" style="width:100px;ime-mode:disabled" name="vvd" maxlength="9" dataformat="engup" class="input" value="<%=vvd %>"></td>
                <th>SSR</th>
                <td><input type="text" style="width:80px;ime-mode:disabled"  name="svc_rqst_no" maxlength="6" dataformat="engup" class="input" value="<%=ssrNo %>"></td>
                <th>Status</th>
                <td><%=JSPUtil.getCodeCombo("msg_sts_cd", "", "style='width:100'", "CD02226", 0, "")%></td>
                <th>DNLD</thd>
                <td><%=JSPUtil.getCodeCombo("bkg_count", "", "style='width:100'", "CD20059", 0, "")%></td>
            </tr>
        </tbody>
    </table>
    <!--  biz_1   (E) -->   
</div>
<!-- inquiry_area(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- layout_wrap(S) -->
	<div class="layout_wrap">
	    <div class="layout_flex_flex" style="padding-right:285px;">
	        <!-- opus_design_grid(S) -->
	        <div class="opus_design_grid mar_top_4">
	            <script type="text/javascript">ComSheetObject('sheet2');</script>
	        </div>
	        <!-- opus_design_grid(E) -->
	    </div>

	    <div class="layout_flex_fixed" style="width:250px; float:right">
	        <table class="grid_2 wAuto">
	            <colgroup>
	                <col width="100" />
	                <col width="*" />
	            </colgroup>
	            <tbody>
	                <tr>
	                    <th><strong>VVD</strong></th>
	                    <td><input type="text" class="noinput2 wAuto" readOnly="readonly" name="vvd1"></td>
	                </tr>
	                <tr>
	                    <th><strong>POL</strong></th>
	                    <td><input type="text" class="noinput2 wAuto" readOnly="readonly" name="pol1"></td>
	                </tr>
	            </tbody>
	        </table>
	    </div>
	</div>
	<!-- layout_wrap(E) -->
</div>
</form>
