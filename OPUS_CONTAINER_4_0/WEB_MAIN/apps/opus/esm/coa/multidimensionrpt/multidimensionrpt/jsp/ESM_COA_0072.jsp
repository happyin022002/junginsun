<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0072.jsp
*@FileTitle  : Inquire Weekly Sales Report By Office 3
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%> 
<%
    GeneralEventResponse eventResponse = null;
    Exception serverException = null;
    String strErrMsg = "";
    Logger log = Logger.getLogger("com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.ESM_COA_0072");
    String userId = "";
    String ofc_cd = "";
    String ofc_lvl = "";
    String headCode1 = ""; //sheet1
    String headName1 = "";
    String headCode2 = ""; //sheet2 
    String headName2 = "";
    String headCode3 = ""; //sheet3 
    String headName3 = "";
    String xml = "";
    try {
    	eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");								//소스품질.20150507
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        } else {
            SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
            userId = account.getUsr_id();
            ofc_cd = account.getOfc_cd(); //getUserOffice2();
            ofc_lvl = account.getUsr_auth_tp_cd(); //getUserLevel();
            xml = HttpUtil.makeXML(request,response); 
            xml = xml.replaceAll("\"", "'");            
            
            headCode1 = eventResponse.getETCData("headCode1");
            headName1 = eventResponse.getETCData("headName1");
            headCode2 = eventResponse.getETCData("headCode2");
            headName2 = eventResponse.getETCData("headName2");
            headCode3 = eventResponse.getETCData("headCode3");
            headName3 = eventResponse.getETCData("headName3");
            
        } //end of if
    } catch(Exception e) {
        log.error("JSP Exception : " + e.toString());
    }

%>

<script type="text/javascript">
    function setupPage() {
        var formObj = document.form;
        var errMessage = '<%=strErrMsg%>';
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if

        loadPage("<%=headCode1%>","<%=headName1%>","<%=headCode2%>","<%=headName2%>","<%=headCode3%>","<%=headName3%>");
    }
</script>

<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="headCode1" value="<%=headCode1.toString()%>" id="headCode1" />
<input type="hidden" name="headCode1" value="<%=headName1.toString()%>" id="headCode1" />
<input type="hidden" name="headCode2" value="<%=headCode2.toString()%>" id="headCode2" />
<input type="hidden" name="headName2" value="<%=headName2.toString()%>" id="headName2" />
<input type="hidden" name="headCode3" value="<%=headCode3.toString()%>" id="headCode3" />
<input type="hidden" name="headName3" value="<%=headName3.toString()%>" id="headName3" />

<input type="hidden" name="v_ofc_cd" value="<%=ofc_cd%>" id="v_ofc_cd" />
<input type="hidden" name="v_ofc_lvl" value="<%=ofc_lvl%>" id="v_ofc_lvl" />
<input type="hidden" name="sXml" value="<%=xml%>" id="sXml" /> 

<!-- page_title_area(S) -->
<div class="page_title_area clear">

    <!-- page_title(S) -->
    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
    <!-- page_title(E) -->

    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
        <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
        --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
    </div>
    <!-- opus_design_btn(E) -->
    
    <!-- page_location(S) -->
    <div class="location">
        <span id="navigation"></span>
    </div>
</div>
<!-- page_title_area(E) -->

<!-- wrap_search(S) -->
<div class="wrap_search">
    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry">
        <table>
            <tr>
                <td colspan="10"><script type="text/javascript">coaPeriod1("1","O");</script></td>
            </tr>
            <tr><td colspan="10" class="line_bluedot" style="height:15px;"></td></tr>
        </table>

        <table>
            <colgroup>
                <col width="70"  />
                <col width="90" />
                <col width="160"  />
                <col width="90"  />
                <col width="100" />
                <col width="90"  />
                <col width="100" />
                <col width="90" />
                <col width="" />
            </colgroup>
            <tbody>
                <tr>
                    <td><img src="/opuscntr/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By View</td>
                    <th>Profit View</th>
                    <td><script type="text/javascript">ComComboObject('f_pro_vw',1, 140 , 0 )</script></td>
                    <th>Office View</th>
                    <td><script type="text/javascript">ComComboObject('f_ofc_vw',1, 80 , 0 )</script></td>
                    <th>Profit Level</th>
                    <td><script type="text/javascript">ComComboObject('f_pro_lvl',1, 80 , 0 )</script></td>
                </tr>
                <tr><td colspan="9" class="line_bluedot" style="height:15px;"></td></tr>
                <tr>
                    <td><img src="/opuscntr/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Office</td>
                    <th>Office Level</th>
                    <td><script type="text/javascript">ComComboObject('f_ofc_lvl',1, 140 , 0 )</script></td>
                    <th>Office</th>
                    <td><script type="text/javascript">ComComboObject('f_ofc_cd',1, 80 , 0 )</script></td>
                    <td colspan="2">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" class="trans" name="f_excl_sts" id="f_excl_sts" value="Y"><!--
                        --><label for="f_excl_sts">Exclude Sub</label>
                    </td>
                    <td style="color:#7F9DB9;">
                        <div id="div_text" style="display:none">TS Commitment based</div>
                    </td>
                    <td align="right">&nbsp;</td>
                </tr>
                <tr><td colspan="9" class="line_bluedot" style="height:15px;"></td></tr>
                <tr>
                    <td><img src="/opuscntr/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Lane</td>
                    <th>Trade</th>
                    <td><script type="text/javascript">ComComboObject('f_trd_cd',1, 80 , 0 )</script></td>
                    <th>Lane</th>
                    <td><script type="text/javascript">ComComboObject('f_rlane_cd',1, 80 , 0 )</script></td>
                    <th>Direction</th>
                    <td><script type="text/javascript">ComComboObject('f_dir_cd',1, 80 , 0 )</script></td>
                    <th title="Vessel Voyage Direction">VVD</th>
                    <td align="left">
                        <input type="text" size="4" name="f_vsl_cd" maxlength="4" onKeyPress="ComKeyOnlyAlphabet('uppernum')" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled; width:55px;" dataformat="engup"><!--
                        --><input type="text" size="4" name="f_skd_voy_no" maxlength="4" onKeyPress="ComKeyOnlyNumber(this);" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled; width:55px;" dataformat="num"><!--
                        --><input type="text" size="1" name="f_skd_dir_cd" maxlength="1" onKeyPress="ComKeyOnlyAlphabet('upper')" style="ime-mode:disabled; width:37px;" dataformat="engup">
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
    <!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
    <!-- opus_design_grid(S) -->

        <h3 class="title_design">Report Form</h3>
    	<div class="opus_design_grid">
	        <table>
	             <colgroup>
	                <col width="80"  />
	                <col width="350" />
	                <col width="193" />
	                <col width="200" />
	                <col width=""    />
	            </colgroup> 
	            <tbody>
	                <tr>
	                    <td><b>TEU Based</b></td>
	                    <td>
	                        <input type="radio" name="f_rdotype" id="f_rdotype1" class="trans" value="1" checked><label for="f_rdotype1">By Account</label><!--
	                        --><input type="radio" name="f_rdotype" id="f_rdotype2" class="trans" value="2" ><label for="f_rdotype2">By Lane / BND</label><!--
	                        --><input type="radio" name="f_rdotype" id="f_rdotype3" class="trans" value="3" ><label for="f_rdotype3">By VVD</label>
	                    <td>
	                        <div id = "div_locl" style="display:inline">
	                            <input type="radio" name= "f_locl_lang" id= "f_locl_lang1" class="trans" value="1"><label for="f_locl_lang1">LOCAL</label><!--
	                            --><input type="radio" name= "f_locl_lang" id= "f_locl_lang2" class="trans" value="2" checked><label for="f_locl_lang2">ENG</label>
	                        </div>
	                    </td>
	                    <td>
	                        <div id = "div_chtBiz" style="display:none">
	                            <b>By Division</b>&nbsp;&nbsp;&nbsp;<!--
	                            --><script type="text/javascript">ComComboObject('f_chtbiz',1, 90 , 0 )</script>
	                        </div>
	                    </td>
	                    <td align="right" valign="bottom" style="padding-right:4;">
        				<div class="opus_design_btn">
	                        <div id="div_zoom_in"  style="position:relative; right:0px; top:0px; display:inline"> <!-- absolute / relative -->
	                            <!-- <img class="cursor" src="/opuscntr/img/bu_prev01.gif" width="20" height="11" border="0" name="bu_zoom_in" title ="Zoom in(+)"> -->
	                            <button type="button" class="btn_up" name="bu_zoom_in" id="bu_zoom_in" title ="Zoom in(+)"></button>
	                        </div>
	                        <div id="div_zoom_out" style="position:relative; right:0px; top:0px; display:none">
	                            <!-- <img class="cursor" src="/opuscntr/img/bu_next01.gif" width="20" height="11" border="0" name="bu_zoom_out"  title ="Zoom out(-)"> -->
	                            <button type="button" class="btn_down" name="bu_zoom_out" id="bu_zoom_out" title ="Zoom out(-)"></button>
	                        </div>
	                     </div>
	                    </td>
	                </tr>
	            <tbody>
	        </table>
		</div>
		<div class="opus_design_grid" id="tabLayer1" style="display:inline">
            <script type="text/javascript">ComSheetObject('sheet1');</script>
        </div>
        <div class="opus_design_grid"  id="tabLayer2" style="display:none">
            <script type="text/javascript">ComSheetObject('sheet2');</script>
        </div>
        <div class="opus_design_grid"  id="tabLayer3" style="display:none">
            <script type="text/javascript">ComSheetObject('sheet3');</script>
        </div>
    <!-- opus_design_grid(E) -->

    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry wFit">
    <table>			    
			     <tr><td height="20"><img src="/opuscntr/img/ico_star.gif" border="0" hspace="3" align="absmiddle"><strong>Remark</strong></td></tr>
			    <tr><td style="padding-left:11;" class="sm">
			<!-- SJH.20141226.MOD -->
						 <img src="/opuscntr/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0" vspace="3">
            CM = Freight Rev + Misc OP Rev - Full Cost - MT Cost - Agt Comm - Internal Slottage Cost - Reefer Cost - CNTR M&R Charge - CHSS Fixed Cost<br>
            <img src="/opuscntr/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0" vspace="3">
            OP = CM + DEM/DET +S.Cht Revenue - Operation Cost( EQ Fixed Cost + General Expense +Vessel Operational Cost) + Slot Internal Revenue (OP)
					</td>
				</tr>				    
			</table>
    
    </div>
    
    
  <!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_result(E) -->

</form>

