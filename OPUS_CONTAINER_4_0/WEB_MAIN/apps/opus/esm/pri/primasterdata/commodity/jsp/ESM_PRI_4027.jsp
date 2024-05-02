<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_4027.jsp
*@FileTitle  : Commodity Inquiry
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
<%@ page import="com.clt.apps.opus.esm.pri.primasterdata.commodity.event.EsmPri4027Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmPri4027Event  event = null;      //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null; //Error happened at server side
    String strErrMsg = "";              //Error Message
    int rowCount     = 0;               //DB ResultSet List Count
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";


    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.PRIMasterData.Commodity");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
       
       
        event = (EsmPri4027Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        // Adding the code extract data from server when initialization loading..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
    }catch(Exception e) {
        out.println(e.toString());
    }
    
    String cmdtNm = JSPUtil.getNull(request.getParameter("prc_cmdt_def_nm"));
    String commodityCmd = JSPUtil.getNull(request.getParameter("commodity_cmd")); 
    String prcCmdtTpCd = JSPUtil.getNull(request.getParameter("prc_cmdt_tp_cd"));
    String grpCd = JSPUtil.getNull(request.getParameter("grp_cd"));
    String svcScpCd = JSPUtil.getNull(request.getParameter("svc_scp_cd"));
    String glineSeq = JSPUtil.getNull(request.getParameter("gline_seq"));
    String prcCustTpCd = JSPUtil.getNull(request.getParameter("prc_cust_tp_cd"));
    String propNo = JSPUtil.getNull(request.getParameter("prop_no"));
    String amdtSeq = JSPUtil.getNull(request.getParameter("amdt_seq"));
    String chgCd = JSPUtil.getNull(request.getParameter("chg_cd"));
    String creOfcCd = JSPUtil.getNull(request.getParameter("cre_ofc_cd"));
    String qttnNo = JSPUtil.getNull(request.getParameter("qttn_no"));
    String qttnVerNo = JSPUtil.getNull(request.getParameter("qttn_ver_no"));
    String multiYn = JSPUtil.getNull(request.getParameter("multi_yn"));
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

<input type="hidden" name="commodity_cmd" value="<%=commodityCmd%>">
<input type="hidden" name="prc_cmdt_tp_cd" value="<%=prcCmdtTpCd%>">
<input type="hidden" name="grp_cd" value="<%=grpCd%>">
<input type="hidden" name="svc_scp_cd" value="<%=svcScpCd%>">
<input type="hidden" name="gline_seq" value="<%=glineSeq%>">
<input type="hidden" name="prc_cust_tp_cd" value="<%=prcCustTpCd%>">
<input type="hidden" name="prop_no" value="<%=propNo%>">
<input type="hidden" name="amdt_seq" value="<%=amdtSeq%>">
<input type="hidden" name="chg_cd" value="<%=chgCd%>">
<input type="hidden" name="cre_ofc_cd" value="<%=creOfcCd%>">
<input type="hidden" name="qttn_no" value="<%=qttnNo%>">
<input type="hidden" name="qttn_ver_no" value="<%=qttnVerNo%>">
<input type="hidden" name="multi_yn" value="<%=multiYn%>"><!-- Only Use in TRI GRI -->

<!-- page(S) -->
<!-- OUTER - POPUP (S)tart -->
<%if(!commodityCmd.equals("")){ %>
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	    <!-- page_title(S) -->
	    <h2 class="page_title"><span>Commodity Inquiry</span></h2>
	    <!-- page_title(E) -->
	
	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
	        --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--
	        --><button type="button" class="btn_normal" name="btn_Ok" id="btn_Ok">OK</button><!--
	        --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
	    </div>
	    <!-- opus_design_btn(E) -->
	
	</div>
</div>
<!-- page_title_area(E) -->
<%} else { %>
<!-- page_title_area(S) -->
<div class="page_title_area clear">
    <!-- page_title(S) -->
    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
    <!-- page_title(E) -->

    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
        <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
        --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button>
    </div>
    <!-- opus_design_btn(E) -->

    <!-- page_location(S) -->
    <div class="location">
        <span id="navigation"></span>
    </div>
    <!-- page_location(E) -->
</div>
<%}%>

<!-- popup_contens_area(S) -->
<%if(!commodityCmd.equals("")){ %>
<div class="layer_popup_contents" style="overflow:auto; overflow:hidden;">
<%}%>
<!-- inquiry_area(S) -->
<div class="wrap_search">
    <div class="opus_design_inquiry wFit">
        <!--  biz_1 (S) -->
        <table>
            <colgroup>
                <col width="40"  />
                <col width="350" />
                <col width="*" />
            </colgroup>
            <tbody>
                <tr>
                    <th class="sm">Type</th>
                    <td class="sm">
                        <input type="radio" name="radio_type" id="radio_type1" value="C" class="trans" checked><label for="radio_type1">Commodity</label><!--
                        --><input type="radio" name="radio_type" id="radio_type2" value="R" class="trans"><label for="radio_type2">Rep. Commodity</label><!--
                        --><input type="radio" name="radio_type" id="radio_type3" value="G" class="trans"><label for="radio_type3">Commodity Group</label>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <!-- Raido Tab [ Commodity ] (S) -->
                        <div id="radioLayer1" style="display:none">
                            <table>
                                <colgroup>                          
                                    <col width="60"  />
                                    <col width="100" />
                                    <col width="80" />
                                    <col width="*" />
                                </colgroup>
                                <tbody>
                                    <tr>
                                        <th>Code</th>
                                        <td><input type="text" name="cmdt_cd" id="cmdt_cd" dataformat="num" maxlength="6" style="width:60px;" class="input"></td>
                                        <th>Description</th>
                                        <td><input type="text" name="cmdt_nm" id="cmdt_nm" value="<%=cmdtNm%>" maxlength="40" style="width:200px;ime-mode:disabled" class="input"></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>                      
                        <!-- Raido Tab [ Commodity ] (E) -->
                        
                        <!-- Raido Tab [ Rep Commodity ] (S) -->
                        <div id="radioLayer2" style="display:none">
                            <table>
                                <colgroup>                          
                                    <col width="60"  />
                                    <col width="100" />
                                    <col width="80" />
                                    <col width="*" />
                                </colgroup>
                                    <tbody>
                                    <tr>
                                        <th>Code</th>
                                        <td><input type="text" name="rep_cmdt_cd" id="rep_cmdt_cd" dataformat="num" minlength="2" maxlength="4" style="width:60px;" class="input"></td>
                                        <th>Description</th>
                                        <td><input type="text" name="rep_cmdt_nm" id="rep_cmdt_nm" dataformat="engup" otherchar=" " maxlength="40" style="width:200px;" class="input"></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>                      
                        <!-- Raido Tab [ Rep Commodity ] (E) -->
                        
                        <!-- Raido Tab [ Group.Commodity ] (S) -->
                        <div id="radioLayer3" style="display:none">
                            <table>
                                <colgroup>                          
                                    <col width="60"  />
                                    <col width="100" />
                                    <col width="80" />
                                    <col width="*" />
                                </colgroup>
                                    <tbody>
                                    <tr>
                                        <th>Code</th>
                                        <td>
                                            <script type="text/javascript">ComComboObject('grp_cmdt_seq', 2, 70, 0, 1, 0, false);</script> <input type="text" name="prc_grp_cmdt_desc" style="width:150;" class="input2" readOnly>
                                        </td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>                      
                        <!-- Raido Tab [ Group.Commodity ] (E) -->
                    </td>
                    <td></td>
                </tr>
            </tbody>
        </table>
        <!--  biz_1   (E) -->   
    </div>
</div>
<!-- inquiry_area(E) -->

<div class="wrap_result">
    <!-- opus_design_grid(S) -->
    <div id="sheet1Layer" class="opus_design_grid" style="display:none">
        <script type="text/javascript">ComSheetObject('sheet1');</script>
    </div>
    <!-- opus_design_grid(E) -->
    
    <!-- opus_design_grid(S) -->
    <div id="sheet2Layer" class="opus_design_grid" style="display:none">
        <script type="text/javascript">ComSheetObject('sheet2');</script>
    </div>
    <!-- opus_design_grid(E) -->
    
    <!-- opus_design_grid(S) -->
    <div id="sheet3Layer" class="opus_design_grid" style="display:none">
        <script type="text/javascript">ComSheetObject('sheet3');</script>
    </div>
    <!-- opus_design_grid(E) -->
</div>
<%if(!commodityCmd.equals("")){ %>
</div>
<%}%>
<!-- popup_contens_area(E) -->
<!-- page(E) -->

</form>