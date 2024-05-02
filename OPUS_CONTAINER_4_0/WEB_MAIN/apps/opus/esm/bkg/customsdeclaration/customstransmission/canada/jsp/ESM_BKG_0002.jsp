<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0002.jsp
*@FileTitle  : ACI_Vessel Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/29
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.event.EsmBkg0002Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0002Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //serverException
    String strErrMsg = "";                      //error massage
    int rowCount     = 0;                       //DB ResultSet list count

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    boolean isCA_Usr        = false;
    String strCnt_cd        = "";
    Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.customstransmission");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        if ("ESM_BKG_0002_2".equals(request.getParameter("pgmNo")))
        {
            isCA_Usr = true;
            strCnt_cd = "CA";
        }
        event = (EsmBkg0002Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        //when open screen, get data in server..
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
        loadPage(<%=isCA_Usr%>);
    }
</script>

<form name="form" method="post">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="cnt_cd" value="<%=strCnt_cd%>" id="cnt_cd" />
<input type="hidden" name="error_data" id="error_data" />
<input type="hidden" name="terminal_auto_snd" id="terminal_auto_snd" />

<!-- 제목(S) -->
<div class="page_title_area clear">
    <!-- page_title(S) -->
    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
    <!-- page_title(E) -->

    <!-- btn_div(S) -->
    <div class="opus_design_btn">
        <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
        --><button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Delete</button><!-- 
        --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!-- 
        --><button type="button" class="btn_normal" name="btn_addbl" id="btn_addbl">B/L Add</button><!-- 
        --><button type="button" class="btn_normal" name="btn_editbl" id="btn_editbl">Manifest(B/L)</button><!-- 
        --><button type="button" class="btn_normal" name="btn_transmit" id="btn_transmit">Transmit</button><!-- 
        --><button type="button" class="btn_normal" name="btn_terminal" id="btn_terminal">Terminal EDI</button>
    </div>
    <!-- btn_div(E) -->

    <!-- page_location(S) -->
    <div class="location">
        <span id="navigation"></span>
    </div>
    <!-- page_location(E) -->
</div>
<!-- 제목(E) -->



<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
	<!-- 검색영역(S)-->
	<div class="opus_design_inquiry">
	    <!--  biz_1 (S) -->
	    <table>
	        <colgroup>
	            <col width="30px"  />
	            <col width="120px" />
	            <col width="30px"  />
	            <col width="90px"  />
	            <col width="30px"  />
	            <col width="160px" />
	            <col width="30px"  />
	            <col width="90px"  />
	            <col width="60px"  />
	            <col width="80px"  />
	            <col width="150px" />
	            <col width=""      />
	        </colgroup>
	        <tbody>
	            <tr>
	                <th title="Vessel Voyage Direction">VVD</th>
	                <td><input type="text" style="width:90px;ime-mode:disabled" class="input1" name="vvd_cd" maxlength="9" dataformat="engup" minlength="9" caption="VVD" required></td> 
	                <th title="Port of Loading">POL</th>
	                <td><input type="text" style="width:50px;ime-mode:disabled" <%if(isCA_Usr){%>class="input"<%}else{%>class="input1" <%}%>name="pol_cd" maxlength="5" dataformat="engup" minlength="5" caption="POL" required></td> 
	                <th>ETL</th>
	                <td><input type="text" style="width:130px;" class="input" name="etl_dt" readonly="readonly"></td>
	                <th title="Port of Discharging">POD</th>
	                <td><input type="text" style="width:50px;ime-mode:disabled" <%if(isCA_Usr){%>class="input1"<%}else{%>class="input"<%}%>name="pod_cd" maxlength="5" dataformat="engup" minlength="5" caption="POD"></td>
	                <th>Customs</th>
	                <td><input type="text" style="width:50px;ime-mode:disabled" <%if(isCA_Usr){%>class="input1"<%}else{%>class="input"<%}%>name="cstms_port_cd" maxlength="5" dataformat="engup" minlength="5" caption="Customs"></td>
	                <td class = "sm"><input type="radio" name="bl_type" value="A" class="trans" checked="true">All&nbsp;&nbsp;<input type="radio" name="bl_type" value="E" class="trans">Error B/L</td>
	                <td width=""><%=JSPUtil.getCodeCombo("cntr_type", "", "style='width:67px;'", "CD00748", 0, "")%>
	                  <script>ComAddBeginComboItem(form.cntr_type,"All","A")</script>
	                </td> 
	            </tr>
	        </tbody>
	    </table> 
	    <!--  biz_1   (E) -->   
	</div>
	<!-- 검색영역(E)-->
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
<!-- 시트영역(S) -->
<div class="opus_design_grid">
    <script type="text/javascript">ComSheetObject('sheet1');</script>
    <!-- grid_option_leftBreakLine(S) -->
    <div class="line_bluedot"></div>
    <!-- grid_option_leftBreakLine(E)-->
    <script type="text/javascript">ComSheetObject('sheet2');</script>

<!--  Total  (S) -->
	<br>
	<div class="opus_design_inquiry">
		<table> 
			<tr>
				<th width="40">Total</th>
				<th width="70">01 H/BL</th>								
				<td width="50"><input type="text" name="frm_hbl_count" tabindex="20" style="width:40px;text-align:right;" class="input" value=""></td>
				<th width="50">01 M/BL</th>
				<td width="50"><input type="text" name="frm_mbl1_count" tabindex="21" style="width:40px;text-align:right;" class="input" value=""></td>
				<th width="50">02 M/BL</th>
				<td width="50"><input type="text" name="frm_mbl2_count" tabindex="22" style="width:40px;text-align:right;" class="input" value=""></td>
				<th width="50">03 M/BL</th>
				<td width="50"><input type="text" name="frm_mbl3_count" tabindex="23" style="width:40px;text-align:right;" class="input" value=""></td>
				<th width="100">B/L Total Count</th>
				<td width="*"><input type="text" name="frm_bl_tot_count" tabindex="24" style="width:50px;text-align:right;" class="input" value=""></td>				
			</tr> 
		</table>
	</div>				
<!--  Total  (E) -->

	</div>
</div>

<div style="display:none">
	<script language="javascript">ComSheetObject('sheet3');</script>
</div>
<!-- opus_design_grid(E) -->
<!-- 시트영역(E) -->
</form>
