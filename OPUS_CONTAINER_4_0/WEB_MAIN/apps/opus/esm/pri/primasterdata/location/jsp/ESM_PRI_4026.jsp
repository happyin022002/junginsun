<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_4026.jsp
*@FileTitle  : Location Inquiry
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
<%@ page import="com.clt.apps.opus.esm.pri.primasterdata.location.event.EsmPri4026Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.primasterdata.location.vo.RsltGrpLocListVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmPri4026Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.PRIMasterData.Location");
    
    String groupCmd = "";
    String propNo = "";
    String svcScpCd = "";
    String amdtSeq = "";
    String grpLocSeq = "";
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
       
       
        event = (EsmPri4026Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        
        RsltGrpLocListVO rsltGrpLocListVO = event.getRsltGrpLocListVO();
        
        
        
        if(rsltGrpLocListVO != null) {
            groupCmd = rsltGrpLocListVO.getGroupCmd();
            propNo = rsltGrpLocListVO.getPropNo();
            svcScpCd = rsltGrpLocListVO.getSvcScpCd();
            amdtSeq = rsltGrpLocListVO.getAmdtSeq();
            grpLocSeq = rsltGrpLocListVO.getGrpLocSeq();
        }
        
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
            showErrMessage(errMessage);
        } // end if
        loadPage();
        
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="group_cmd" value="<%=JSPUtil.getNull(request.getParameter("group_cmd"))%>">
<input type="hidden" name="location_cmd" value="<%=JSPUtil.getNull(request.getParameter("location_cmd"))%>"> 
<input type="hidden" name="prop_no" value="<%=JSPUtil.getNull(request.getParameter("prop_no")) %>">
<input type="hidden" name="svc_scp_cd" value="<%=JSPUtil.getNull(request.getParameter("svc_scp_cd"))%>" >
<input type="hidden" name="amdt_seq" value="<%=JSPUtil.getNull(request.getParameter("amdt_seq")) %>">
<input type="hidden" name="cre_ofc_cd" value="<%=JSPUtil.getNull(request.getParameter("cre_ofc_cd"))%>" >
<input type="hidden" name="grp_loc_seq" >
<input type="hidden" name="gline_seq" value="<%=JSPUtil.getNull(request.getParameter("gline_seq"))%>">
<input type="hidden" name="loc_tp_cd" value="<%=JSPUtil.getNull(request.getParameter("loc_tp_cd"))%>">
<input type="hidden" name="org_dest_cd" value="<%=JSPUtil.getNull(request.getParameter("org_dest_cd"))%>">
<input type="hidden" name="qttn_no" value="<%=JSPUtil.getNull(request.getParameter("qttn_no"))%>">
<input type="hidden" name="qttn_ver_no" value="<%=JSPUtil.getNull(request.getParameter("qttn_ver_no"))%>">
<input type="hidden" name="chg_cd" value="<%=JSPUtil.getNull(request.getParameter("chg_cd"))%>">
<input type="hidden" name="multi_yn" value="<%=JSPUtil.getNull(request.getParameter("multi_yn"))%>">
<input type="hidden" name="loc_def_cd" value="<%=JSPUtil.getNull(request.getParameter("loc_def_cd"))%>">
<input type="hidden" name="loc_def_nm" value="<%=JSPUtil.getNull(request.getParameter("loc_def_nm"))%>">

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="layer_popup_title">
    <div class="page_title_area clear">
        <!-- page_title(S) -->
        <h2 class="page_title">
            <span>&nbsp; Location Inquiry</span>
        </h2>
        <!-- page_title(E) -->
        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn"><!--
        --><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
        --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--
        --><button type="button" class="btn_normal" name="btn_OK" id="btn_OK">OK</button><!--
        --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
        </div>
        <!-- opus_design_btn(E) -->
    </div>
</div>
<!-- page_title_area(E) -->
<!-- popup_contens_area(S) -->
<div class="layer_popup_contents" style="overflow:auto; overflow:hidden;">
    <!-- inquiry_area(S) -->
    <div class="wrap_search">       
        <div class="opus_design_inquiry wFit">
            <!--  biz_1 (S) -->
            <table>
                <colgroup>
                    <col width="60" />
                    <col width="530" />
                    <col width="*" />
                </colgroup>
                <tbody>
                    <tr>
                        <th class="sm">Type</th>
                        <td class="sm">
                            <input type="radio" name="radio_type" id="radio_type1" value="1" class="trans" checked="true"><label for="radio_type1">Location</label><!--
                            --><input type="radio" name="radio_type" id="radio_type2" value="2" class="trans"><label for="radio_type2">Location Group</label><!--
                            --><input type="radio" name="radio_type" id="radio_type3" value="3" class="trans"><label for="radio_type3">State</label><!--
                            --><input type="radio" name="radio_type" id="radio_type4" value="4" class="trans"><label for="radio_type4">Region</label><!--
                            --><input type="radio" name="radio_type" id="radio_type5" value="5" class="trans"><label for="radio_type5">Country</label>
                        </td>
                        <td></td>
                    </tr>
                </tbody>
             </table>
            <table id="radioLayer1" style="display:inline">                             
                <colgroup>                          
                    <col width="60"  />
                    <col width="100" />
                    <col width="80" />
                    <col width="*" />
                </colgroup>
                <tbody>
                    <tr>
                        <th>Code</th>
                        <td><input name="loc_cd" type="text" style="width:65px;ime-mode:disabled" dataformat="engup" maxlength="5" minlength="2" class="input" value="" ></td>
                        <th>Description</th>
                        <td><input name="loc_nm" type="text" style="width:350px;" maxlength="30" class="input" value="<%=request.getParameter("loc_def_nm")==null?"":request.getParameter("loc_def_nm")%>" style="ime-mode:disabled" ></td>
                    </tr>
                </tbody>
            </table>
            <!-- Raido Tab [ Location ] (E) -->
            <table id="radioLayer2" style="display:none">                           
                <colgroup>                          
                    <col width="60"  />
                    <col width="100" />
                    <col width="80" />
                    <col width="" />
                </colgroup>
                        <tbody>
                    <tr>
                        <th>Code</th>
                        <td><script type="text/javascript">ComComboObject('combo_grp_loc_cd', 2, 70, 0, 1, 0, false);</script><!--
                        --><input type="text" name="combo_grp_loc_nm" style="width:150px;" class="input"  value="" style="ime-mode:disabled"></td>
                        <td></td>
                        <td></td>
                    </tr>
                </tbody>
            </table>
            <!-- Raido Tab [ Group Location ] (E) -->
            <table id="radioLayer3" style="display:none">                           
                <colgroup>                          
                    <col width="60"  />
                    <col width="100" />
                    <col width="80" />
                    <col width="" />
                </colgroup>
                        <tbody>
                    <tr>
                        <th>Country Code</th>
                        <td style="padding-left:2">
                            <script type="text/javascript">ComComboObject("combo_cnt_cd", 2, 70, 0, 1, 0, false);</script>
                            &nbsp;<input type="text" name="combo_cnt_nm" style="width:150px;" class="input" value="" disabled="true"></td>
                    </tr>
                    <tr>
                        <th>State</th>
                        <td width="">
                            <input type="text" name="ste_cd" style="width:70px;" maxlength="2" minlength="1" class="input" value="" dataformat="enguponly" style="ime-mode:disabled" >
                            <input type="text" name="ste_nm" maxlength="30" style="width:150px;" class="input" value="" style="ime-mode:disabled">
                        </td>
                        <td></td>
                        <td></td>
                    </tr>
                </tbody>
            </table>
            <!-- Raido Tab [ State ] (E) -->
            <!-- Raido Tab [ Region ] (S) -->
            <table id="radioLayer4" style="display:none">                           
                <colgroup>                          
                    <col width="60"  />
                    <col width="*" />
                </colgroup>
                <tbody>
                    <tr>
                        <th>Country Code</th>
                        <td><script type="text/javascript">ComComboObject("combo2_cnt_cd", 2, 70, 0, 1, 0, false);</script><!--
                        --><input type="text" name="combo2_cnt_nm" id="combo2_cnt_nm" style="width:150px;" class="input" value="" disabled="true"></td>
                    </tr>
                    <tr>
                        <th>Region</th>
                        <td><input type="text" name="rgn_cd" style="width:70px;ime-mode:disabled" maxlength="3" minlength="2" dataformat="enguponly" class="input" value="" ><!--
                        --><input type="text" name="rgn_nm" maxlength="30" style="width:150px;ime-mode:disabled" class="input" value="" ></td>
                    </tr>
                </tbody>
            </table>
            <!-- Raido Tab [ Region ] (E) -->
            <!-- Raido Tab [ Country ] (S) -->
            <table id="radioLayer5" style="display:none">                           
                <colgroup>                          
                    <col width="60"  />
                    <col width="100" />
                    <col width="80" />
                    <col width="" />
                </colgroup>
                 <tbody>
                    <tr>
                        <th>Code</th>
                        <td><input name="cnt_cd" dataformat="enguponly" type="text" style="width:65px;" maxlength="2" class="input" value="" style="ime-mode:disabled"></td>
                        <th>Description</th>
                        <td><input name="cnt_nm" type="text" style="width:200px;" maxlength="30" class="input" value="" style="ime-mode:disabled"></td>
                    </tr>
                </tbody>
            </table>
            <!--  biz_1   (E) -->   
        </div>
    </div>
        <!-- opus_design_inquiry(E) -->

    <!-- opus_design_grid(S) -->
    <div class="wrap_result" >    
        <div class="opus_design_grid">
            <script type="text/javascript">ComSheetObject('sheet1');</script>
        </div>
        <!-- opus_design_grid(E) -->
        
        <!-- opus_design_grid(S) -->
        <div class="opus_design_grid">
            <script type="text/javascript">ComSheetObject('sheet2');</script>
        </div>
        <!-- opus_design_grid(E) -->
        
        <!-- opus_design_grid(S) -->
        <div class="opus_design_grid">
            <script type="text/javascript">ComSheetObject('sheet3');</script>
        </div>
        <!-- opus_design_grid(E) -->
        
        <!-- opus_design_grid(S) -->
        <div class="opus_design_grid">
            <script type="text/javascript">ComSheetObject('sheet4');</script>
        </div>
        <!-- opus_design_grid(E) -->
        
        <!-- opus_design_grid(S) -->
        <div class="opus_design_grid">
            <script type="text/javascript">ComSheetObject('sheet5');</script>
        </div>
        <!-- opus_design_grid(E) -->
    </div>
</div>
<!-- popup_contens_area(E) -->
<!-- page(E) -->
</form>