<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MST_0022.jsp
*@FileTitle  : Container Specification Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/04 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.event.EesMst0022Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%
    EesMst0022Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";
    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.EquipmentManagement.ContainerSpecMgt");
    // getting own_cntr_flg 
    String own_cntr_flg = StringUtil.xssFilter(request.getParameter("own_cntr_flg"));
    if(own_cntr_flg == null){
            own_cntr_flg = "";
    }
    // getting cntr_tpsz_cd 
    String cntr_tpsz_cd = StringUtil.xssFilter(request.getParameter("cntr_tpsz_cd"));
    if(cntr_tpsz_cd == null){
            cntr_tpsz_cd = "";
    }
    // getting from_spec_yr 
    String from_spec_yr = StringUtil.xssFilter(request.getParameter("from_spec_yr"));
    if(from_spec_yr == null){
            from_spec_yr = "";
    }
    // getting to_spec_yr
    String to_spec_yr = StringUtil.xssFilter(request.getParameter("to_spec_yr"));
    if(to_spec_yr == null){
            to_spec_yr = "";
    }
    // getting agmt_no 
    String agmt_no = StringUtil.xssFilter(request.getParameter("agmt_no"));
    if(agmt_no == null){
            agmt_no = "";
    }
    // getting lot_no 
    String lot_no = StringUtil.xssFilter(request.getParameter("lot_no"));
    if(lot_no == null){
            lot_no = "";
    }
    // getting active_flag  
    String active_flag = StringUtil.xssFilter(request.getParameter("active_flag"));
    if (active_flag == null){
            active_flag = "";
    }
    
    String strVndrSeq = StringUtil.xssFilter(request.getParameter("strVndrSeq"));
    if(strVndrSeq == null){
        strVndrSeq = "";
    }
    
    String strVndrNm = StringUtil.xssFilter(request.getParameter("strVndrNm"));
    if(strVndrNm == null){
        strVndrNm = "";
    }
    
    String strLstmCd = StringUtil.xssFilter(request.getParameter("lstm_cd"));
    if(strLstmCd == null){
        strLstmCd = "";
    }   
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
            strUsr_id = account.getUsr_id();
            strUsr_nm = account.getUsr_nm();
            event = (EesMst0022Event)request.getAttribute("Event");
            serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
            if (serverException != null) {
                    strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
            }
            GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
    } catch(Exception e) {
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

<form name="form" id="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="rcv_own_cntr_flg" name="rcv_own_cntr_flg" value="<%=own_cntr_flg%>" type="hidden" />
<input id="cntr_tpsz_cd" name="cntr_tpsz_cd" value="<%=cntr_tpsz_cd%>" type="hidden" />
<input id="active_flag" name="active_flag" value="<%=active_flag%>" type="hidden" />
<input id="cntr_spec_no" name="cntr_spec_no" value="" type="hidden" />
<input id="lot_no" name="lot_no" value="<%=lot_no %>" type="hidden" />
<input id="lstm_cd" name="lstm_cd" value="<%=strLstmCd %>" type="hidden" />
<input id="h_lessor" name="h_lessor" value="<%=strVndrSeq %>" type="hidden" />
<input id="h_lessor_nm" name="h_lessor_nm" value="<%=strVndrNm %>" type="hidden" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
    <!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
    <% if( active_flag == "") {%>
        <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
    <%} else { %>
        <h2 class="page_title"><button type="button"><span>Container Specification Inquiry(EES_MST_0022)</span></button></h2>
    <%} %>
    
    
    <!-- page_title(E) -->
    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn"><!-- 
         --><% if (active_flag != "")
            {
        %><!-- 
            --><button type="button" class="btn_accent" name="btn_Retrieve" id="">Retrieve</button><!-- 
            --><button type="button" class="btn_normal" name="btn_ok" id="btn_ok">Ok</button><!-- 
            --><button type="button" class="btn_normal" name="btn_new" id="btn_new" style="display:none">New</button><!-- 
             --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!-- 
             --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button><!-- 
         --><%} else { %><!-- 
             --><button type="button" class="btn_accent" name="btn_Retrieve" id="">Retrieve</button><!-- 
             --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--        
             --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
             --><button type="button" class="btn_normal" name="btn_spec" id="btn_spec">SPEC</button><!-- 
         --><%} %><!-- 
     --></div>
    <!-- opus_design_btn(E) -->
    <% if( active_flag == "") {%>
        <div class="location"><span id="navigation"></span></div>
    <%} else { %>
        <div class="location"><span>Container Specification</span></div>
    <%} %>
</div>
<!-- page_title_area(E) -->


<div class="wrap_search">
    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry wFit">
        <table>
            <tbody>
                <colgroup>
                    <col width="10px" />
                    <col width="30px" />
                    <col width="25px" />
                    <col width="130px" />
                    <col width="35px" />
                    <col width="30px" />
                    <col width="80px" />
                    <col width="70px" />
                    <col width="100px" />
                    <col width="70px" />
                    <col width="150px" />
                    <col width="50px" />
                    <col width="150px" />
                    <col width="80px"/>
                    <col width="100px"/>
                    <col width="80px"/>
                    <col width="100px"/>
                    <col width="*" />
                </colgroup>
                <tr>
                    <td></td>
                    <th>Spec Classification</th>
                    <td></td>
                    <td><select class="input1" style="width: 80px;"  name="own_cntr_flg" id="own_cntr_flg" style="text-align:center">
                                      --><option value="O" selected>Own</option><!--                                              
                                      --><option value="L">Lease</option><!--  
                                      --><option value="S">Standard</option><!--  
                                      --></select></td>
                    <td></td>
                    <th>TP/SZ</th> 
                    <td><script type="text/javascript">ComComboObject('combo1', 1, 45, 1);</script></td>
                    <th width="90">Lease Term</th>
                    <td><script type="text/javascript">ComComboObject('combo2', 1, 50, 1);</script></td>
                    <th>Spec Year</th>
                    <td><input id="from_spec_yr" name="from_spec_yr" style="width: 50px; ime-mode:disabled; text-align:center;" dataformat="yyyy" maxlength="4" value="<%=from_spec_yr%>" type="text" />~ <input id="to_spec_yr" name="to_spec_yr" style="width: 50px; text-align:center" dataformat="yyyy" maxlength="4" value="<%=to_spec_yr%>" type="text" /></td>
                    <th>AGMT No.</th>
                    <td><input id="agmt_no" name="agmt_no" style="width: 80px;" class="input" dataformat="engup" value="<%=agmt_no%>" maxlength="9" readonly type="text"/><button class="input_seach_btn" name="btn_Popup" id="btn_Popup" type="button"></button></td>
                    <th id="th_lessor">Lessor</th>
                    <td id="td_lessor"><input type="text" name="vndr_seq" caption="Lessor" style="width:55px;text-align:center;" class="input2"  readonly="" dataformat="num" maxlength="6" id="vndr_seq" value="<%=strVndrSeq%>" /><!--
                                    --><button type="button" id="btns_search2" name="btns_search2" class="input_seach_btn"></button><!--
                                    --><input type="text" name="vndr_nm" caption="Lessor" style="width:100px;" class="input2" readonly="" id="vndr_nm" value="<%=strVndrNm%>" /></td>
                    <th>Zero Active Qty</th>
                    <td><select class="input" style="width: 70px;"  name="zero_active_qty" id="zero_active_qty" style="text-align:center">
                                      --><option value="E" selected>Exclude</option><!--                                              
                                      --><option value="I">Include</option><!--  
                                      --><option value="O">Only</option><!--  
                                      --></select></td>
                    <td></td>
                </tr>
            </tbody>
        </table>
    </div>
    <!-- opus_design_inquiry(E) --> 
</div>

<div class="wrap_result">
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid">
        <%-- <div class="opus_design_btn"><% if( active_flag!="" ){%><button type="button" class="btn_normal" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><%}%></div> --%>
    <div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
    <div class="opus_design_btn">
        <button type="button" class="btn_accent" name="btn_cntrlist" id="btn_cntrlist">CNTR List</button>
    </div>
    </div>
        <script type="text/javascript">ComSheetObject('sheet1');</script>
    </div>
    <!-- opus_design_grid(E) -->    
</div>
</form>
<%-- <%@ include file="/bizcommon/include/common_opus.jsp"%> --%>