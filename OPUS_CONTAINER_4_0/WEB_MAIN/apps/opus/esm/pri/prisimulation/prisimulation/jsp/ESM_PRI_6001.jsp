<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_6001.jsp
*@FileTitle  : Verify Rate
*@author     : CLT
*@version    : 1.0
*@since      : 2014/11/26
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.prisimulation.prisimulation.event.EsmPri6001Event"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmPri6001Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";

    String[] cgoTpCdList = null;	//cargo type
    String[] eqtTpCdList = null;	//equipt type
    String[] gohCdList = null;	//equipt type
    String[] svcScpCd = null; 
    String[] trnsModCd = null; 
    String[] wgtUtCd = null; 
    String[] measUtCd = null; 
    String[] filerList = null; 
    String[] siCdList = null; 
    
    Logger log = Logger.getLogger("com.clt.apps.PRISimulation.PRISimulation");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EsmPri6001Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // adding logic to get data from server when first loading
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

        //COMMBO LIST       
        cgoTpCdList 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("cgoTpCdList"), true, "|", "\t", "getCode", "getName");
        eqtTpCdList 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("eqtTpCdList"));
        gohCdList		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("gohCdList"), true, "|", "\t", "getCode", "getName");
        svcScpCd        = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("svcScpCdList"));
        trnsModCd       = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("trnsModCdList"), true, "|", "\t", "getCode", "getName");
        wgtUtCd         = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("wgtUtCdList"), true, "|", "\t", "getCode", "getName");
        measUtCd        = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("measUtCdList"), true, "|", "\t", "getCode", "getName");
        filerList       = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("filerList"), true, "|", "\t", "getCode", "getName");
        siCdList        = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("siCdList"), true, "|", "\t", "getCode", "getName");
        
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
    
<script language="javascript">
    var cgoTpCdListComboValue = "<%=cgoTpCdList[0]%>";
    var cgoTpCdListComboText = "<%=cgoTpCdList[1]%>";
    var eqtTpCdListComboValue = "<%=eqtTpCdList[0]%>";
    var eqtTpCdListComboText = "<%=eqtTpCdList[1]%>";
    var gohCdListComboValue = "|<%=gohCdList[0]%>";
    var gohCdListComboText = "|<%=gohCdList[1]%>";
    var svcScpComboValue = "<%=svcScpCd[0]%>";  
    var svcScpComboText = "<%=svcScpCd[1]%>";
    var trnsModComboValue = "|<%=trnsModCd[0]%>";  
    var trnsModComboText = "|<%=trnsModCd[1]%>";
    var wgtUtCdComboValue = "|<%=wgtUtCd[0]%>";  
    var wgtUtCdComboText = "|<%=wgtUtCd[1]%>";
    var measUtCdComboValue = "|<%=measUtCd[0]%>";  
    var measUtCdComboText = "|<%=measUtCd[1]%>";
    var filerComboValue = "|<%=filerList[0]%>";  
    var filerComboText = "|<%=filerList[1]%>";
    var siCdComboValue = "|<%=siCdList[0]%>";  
    var siCdComboText = "|<%=siCdList[1]%>";


    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="ctrt_tp">
<div id="msg" style="position:absolute;left:0;top:0;width:0;height:0;"></div>
<!-- developer performance  -->

<!-- page_title_area(S) -->
<div class="page_title_area clear ">
    <!-- page_title(S) -->
    <h2 class="page_title"><button type="button"><span id="title"></span></button>
    </h2>
    <!-- page_title(E) -->

        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn">
            <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
            <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
            --><button type="button" class="btn_normal" name="btn_new"   id="btn_new">New</button>
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
        <!--biz page (S)-->
        <table>
            <colgroup>
                <col width="80"  />
                <col width="120" />
                <col width="60"  />
                <col width="60" />
                <col width="60"  />
                <col width="60" />
                <col width="110"  />
                <col width="100" />
                <col width="110"  />     
                <col width="" />
            </colgroup>
            <tbody>
                <tr>
                    <th>POR</th>
                    <td><input type="text" name="por" style="width:80px;ime-mode:disabled;text-align:center" class="input1" dataformat="engup" maxlength="5" minlength="5" required caption="POR"><!-- 
                	 --><button type="button" class="input_seach_btn" name="btn_por" id="btn_por"></button></td>
                    <th>R term</th>
					<td><select name="rcv_t" id="rcv_t" class="input1" required style="width:50px" >
								<option value="D">D</option>
								<option value="Y" selected>Y</option>
					</select></td>
					<th>D term</th>
					<td><select name="del_t" id="del_t" class="input1" required style="width:50px" >
							<option value="D">D</option>
							<option value="Y" selected>Y</option>
					</select></td>
                    <th>Dep. Svc</th>
                    <td><input type="text" name="dep_lane" style="width:80px;text-align: center;ime-mode:disabled;" class="input" dataformat="engup" maxlength="3"><!-- 
                	 --><button type="button" class="input_seach_btn" name="btn_dep_lane" id="btn_dep_lane"></button></td>
                    <th>Arv. Svc</td>
                    <td><input type="text" name="arv_lane" style="width:80px;text-align: center;ime-mode:disabled;" class="input" dataformat="engup" maxlength="3"><!-- 
                	 --><button type="button" class="input_seach_btn" name="btn_arv_lane" id="btn_arv_lane"></button></td>
                    <td></td>
                </tr>
                <tr>
                	<th>DEL</th>
                	<td><input type="text" name="del" style="width:80px;ime-mode:disabled;text-align:center" class="input1" dataformat="engup" maxlength="5" minlength="5" required caption="DEL"><!-- 
                	 --><button type="button" class="input_seach_btn" name="btn_del" id="btn_del"></button></td>
                    <th>Effective Date</th>
                    <td colspan="3"><input type="text" style="width:80px;text-align:center;" class="input1" name="ld_dt" id="ld_dt" dataformat="ymd" maxLength="10" minlength="8" required caption="Effective Date"><!-- 
                    --><button type="button" class="calendar ir" name="btn_calendar" id="btn_calendar"></button></td>
                    <th>POL</th>
                    <td><input type="text" name="pol" style="width:80px;text-align: center;ime-mode:disabled;" class="input" dataformat="engup" maxlength="5"><!-- 
                	 --><button type="button" class="input_seach_btn" name="btn_pol" id="btn_pol"></button></td>
                    <th>POD</td>
                    <td><input type="text" name="pod" style="width:80px;text-align: center;ime-mode:disabled;" class="input" dataformat="engup" maxlength="5"><!-- 
                	 --><button type="button" class="input_seach_btn" name="btn_pod" id="btn_pod"></button></td>
                    <td></td>
            <tbody>
        </table>
    </div>
</div>

<div class="wrap_result">
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid">                                  
        <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
        <script language="javascript">ComSheetObject('sheet1');</script>
        <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
        
     <div class="opus_design_inquiry pad_top_12 pad_left_8">
    <!-- opus_design_inquiry(S) -->
	    <div class="grid_option_left">
	    	<table>
	            <tbody>
					<tr>
						<th colspan="2">Rate Agreement/Service Contract # </th>
		                <td colspan="11"><input type="text" name="ctrt_no" style="width:96px;text-align: center;ime-mode:disabled;" class="input1" dataformat="engup" maxLength="11"><!-- 
		            	 --><button type="button" class="input_seach_btn" name="btn_ctrt" id="btn_ctrt"></button></td>
		                
		                <th colspan="2"><!-- <input type="checkbox" name="unmatch_chk" value="Y">&nbsp; Show Unmatched Rates -->
		                </th>
					</tr>
	                <tr>
	                    <th>Cargo Type</th>
	                    <td><script type="text/javascript" >ComComboObject('cgo_tp_cd', 2, 93, 0, 1, 0)</script></td>
	                    <th>Eqt Type</th>
	                    <td width="65"><script type="text/javascript" >ComComboObject('eq_tp_cd', 1, 40, 0, 1, 0)</script></td>
	                    <th>Sub Trade</th>
	                    <td><input type="text" name="sub_trd_cd" style="width:30px;text-align: center;ime-mode:disabled;" class="input" dataformat="engup" maxlength="2"><!-- 
	                	 --><button type="button" class="input_seach_btn" name="btn_sub_trd" id="btn_sub_trd"></button></td>
	                	<th>Service Scope</th>
	                    <td colspan="2">
	                    <select style="width: 152px;" name ="svc_scp_cd" class="input1" readonly></select>
						</td>
	                    <th>Org Trans Mode</th>
	                    <td><script type="text/javascript" >ComComboObject('org_trns_mod_cd', 2, 80, 0, 0, 0)</script></td>
	                    <th colspan="2" width="120">Dest Trans Mode</th>
	                    <td><script type="text/javascript" >ComComboObject('dest_trns_mod_cd', 2, 80, 0, 0, 0)</script></td>
	                </tr>
	                <tr>
	                	<th>Commodity</th>
		                <td><input type="text" style="width:93px;text-align:center;ime-mode:disabled" class="input" name="cmdt_cd" dataformat="num" maxLength="6"><!-- 
		                	 --><button type="button" class="input_seach_btn" name="btn_commodity" id="btn_commodity"></button>
		                </td>
		                <th colspan="2">Actual Customer</th>
		                <td colspan="2"><input type="text" name="cust_cnt_cd" style="width:32px;ime-mode:disabled;text-align:center" class="input" dataformat="enguponly" maxlength="2" minlength="2"><!-- 
		                	 --><input type="text" name="cust_seq" style="width:50px;ime-mode:disabled;text-align:center" class="input" dataformat="num" maxlength="6"><!-- 
		                	 --><button type="button" class="input_seach_btn" name="btn_cust" id="btn_cust"></button>
		                </td>
		                <th>Weight</th>
						<td colspan="2"><input type="text" name="act_wgt" style="width:100px;text-align:right;" class="input" value="" dataformat="float" maxlength=14 tabindex=51><!-- 
						--><script type="text/javascript" >ComComboObject('wgt_ut_cd', 1, 50, 0, 0, 0)</script></td>
		                <th>Measure</th>
						<td colspan="3"><input type="text" name="meas_qty" style="width:100px;text-align:right;" class="input" value="" dataformat="float" maxlength=14 tabindex=51><!-- 
						--><script type="text/javascript" >ComComboObject('meas_ut_cd', 1, 50, 0, 0, 0)</script></td>
					</tr>
					<tr>
						<th>Filer</th>
			            <td><input type="text" name="" style="width:25px;" class="input" value="US" readonly  tabindex=-1 onmousemove="msgmove('cstms_file')" onmouseover="msgset('cstms_file');return true;" onmouseout="msghide();return true;" ><!-- 
			             --><script type="text/javascript" >ComComboObject('usa_cstms_file_cd', 2, 35, 1, 0, 0)</script><!--                             
			             --><input type="text" style="width:25px;" class="input" value="CA" readonly  tabindex=-1 onmousemove="msgmove('cstms_file')" onmouseover="msgset('cstms_file');return true;" onmouseout="msghide();return true;" ><!--
			             --><script type="text/javascript" >ComComboObject('cnd_cstms_file_cd', 2, 35, 1, 0, 0)</script></td>
			            <th>S/I</th>    
						<td><script type="text/javascript" >ComComboObject('si_cd', 1, 55, 1, 0, 0)</script></td>
						<th>SOC &nbsp;<input type="checkbox" name="soc_flg" value="Y"> &nbsp; </th>
	                    <th> GOH &nbsp;<script type="text/javascript" >ComComboObject('goh_cd', 2, 50, 0, 0, 0)</script></th>
						<th>IMDG Class</th>
						<td><input type="text" name="imdg_clss_cd" style="width:60px;ime-mode:disabled;text-align:center" class="input" maxlength="3"></td><!--숫자+.-->
						<th>In-Gauge&nbsp; <input type="checkbox" name="in_ga_flg" value="Y"></th>
						<th width="80">HBL Count</th>
						<td><input type="text" name="hbl_knt" style="width:40px;ime-mode:disabled;text-align:center" class="input" dataformat="num" onmousemove="msgmove('hbl_knt')" onmouseover="msgset('hbl_knt');return true;" onmouseout="msghide();return true;" ></td>
						<th>Self Count</th>
						<td><input type="text" name="mf_self_knt" style="width:40px;ime-mode:disabled;text-align:center" class="input" dataformat="num" onmousemove="msgmove('self_knt')" onmouseover="msgset('self_knt');return true;" onmouseout="msghide();return true;" ></td>
						<th width="90">DOC Location</th>
						<td><input type="text" name="doc_loc_cd" style="width:80px;ime-mode:disabled;text-align:center" class="input" dataformat="engup" maxlength="5" minlength="5" onmousemove="msgmove('doc_loc')" onmouseover="msgset('doc_loc');return true;" onmouseout="msghide();return true;" ><!--
                	 --><button type="button" class="input_seach_btn" name="btn_doc" id="btn_doc"></button></td>
						
	                </tr>
	            <tbody>
	        </table>
	    </div>
	</div>
    </div>

	<div class="opus_design_grid">   
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_apply" id="btn_apply">Apply Rate</button>
			<button type="button" class="btn_normal" name="btn_rv" id="btn_rv">RV Detail</button>
			<button type="button" class="btn_normal" name="btn_cm" id="btn_cm">CM Detail</button>
	        <button type="button" class="btn_normal" name="btn_excel" id="btn_excel">Down Excel</button>
			<button type="button" class="btn_normal btn_up" name="btn_up" id="btn_up"></button>
		    <button type="button" class="btn_normal btn_down" name="btn_down" id="btn_down"></button>
		</div>
       	<script language="javascript">ComSheetObject('sheet2');</script>
	</div>
</div>
    <!-- opus_design_inquiry(E) --> 
<!-- developer performance  end -->
</form>
