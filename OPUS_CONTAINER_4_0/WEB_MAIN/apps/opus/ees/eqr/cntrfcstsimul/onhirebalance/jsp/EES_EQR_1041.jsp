<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_1041.jsp
*@FileTitle  : On-Hire Request & Approval
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/09
=========================================================*/
%>     
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.cntrfcstsimul.onhirebalance.event.EesEqr1041Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%
    EesEqr1041Event  event = null;                    //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;            
    String strErrMsg = "";                     
    int rowCount     = 0;                        //DB ResultSet 

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    
    String levelCd = "";
    String ofcCd   = "";
    
    String popMode  = (request.getParameter("pop_mode") == null)? "N": "Y";  
    //String tempWeek = (request.getParameter("yrwk") == null)? DateTime.getFormatDate(new java.util.Date(), "yyyyww") : request.getParameter("yrwk");
    String tempWeek = "";
    String popRcc   = (request.getParameter("rcc_cd") == null)? "ALL" : StringUtil.xssFilter(request.getParameter("rcc_cd"));
    String popLcc   = (request.getParameter("lcc_cd") == null)? "ALL" : StringUtil.xssFilter(request.getParameter("lcc_cd"));
    String popTpsz  = (request.getParameter("tpsz_flag") == null)? "D2,D4,D5,D7" : StringUtil.xssFilter(request.getParameter("tpsz_flag"));
    String dp_seq   = StringUtil.xssFilter(request.getParameter("dp_seq")); 
    String row      = StringUtil.xssFilter(request.getParameter("row")); 
    String yrwk      = StringUtil.xssFilter(request.getParameter("yrwk")); 
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        ofcCd     = account.getOfc_cd();

        event = (EesEqr1041Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);       
        
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        if(popMode.equals("Y")) tempWeek = yrwk;  
        else                    tempWeek = eventResponse.getETCData("fcast_yrwk"); 

    }catch(Exception e) {
        out.println(e.toString());
    }
   
    String locSelectBox = JSPUtil.getCodeCombo("loc_tp_cd_second","L","","CD03052",0,"");        
    
    String optionStr2 = "000000: :ALL";
    String cntrTpsz  = JSPUtil.getCodeCombo("cntrTpsz","","style='width:70px;'","CD00263",0,optionStr2);
    String locSelectBox2 = JSPUtil.getCodeCombo("loc_tp_cd_second","L","","CD03052",0,"");   
    
    String currYear = DateTime.getFormatDate(new java.util.Date(), "yyyy");
    
%>
<script language="javascript">

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
<input type="hidden" name="level_cd" id="level_cd" value="<%= levelCd %>">
<input type="hidden" name="ofc_cd"   id="ofc_cd" value="<%= ofcCd %>">
<input type="hidden" name="pop_mode" id="pop_mode" value="<%= popMode %>">
<input type="hidden" name="pop_rcc"  id="pop_rcc" value="<%= popRcc %>">
<input type="hidden" name="pop_lcc"  id="pop_lcc" value="<%= popLcc %>">
<input type="hidden" name="pop_tpsz" id="pop_tpsz" value="<%= popTpsz %>">
<input type="hidden" name="dp_seq"   id="dp_seq" value="<%= dp_seq %>">
<input type="hidden" name="row"      id="row" value="<%= row %>">
<input type="hidden" name="tempWeek" id="tempWeek" value="<%= tempWeek %>">

<% if (popMode.equals("Y")) { %>
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>On-Hire Request & Approval</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
			--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
			--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
			--><button type="button" class="btn_normal" name="btn_request" id="btn_request">Request</button><!--
			--><button type="button" class="btn_normal" name="btn_cancel" id="btn_cancel">Request Cancel</button><!--
			--><button type="button" class="btn_normal" name="btn_downExcel" id="btn_downExcel">Down Excel</button><!--
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>   
<% } else { %>
<div class="page_title_area clear ">
			<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
			--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
			--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
			--><button type="button" class="btn_normal" name="btn_request" id="btn_request">Request</button><!--
			--><button type="button" class="btn_normal" name="btn_cancel" id="btn_cancel">Request Cancel</button><!--
			--><button type="button" class="btn_normal" name="btn_downExcel" id="btn_downExcel">Down Excel</button>
			</div>
	
			<div class="location">
				<span id="navigation"></span>
			</div>
	</div>
<% } %>    

<%if (popMode.equals("Y")) {%><div class="layer_popup_contents"><%}%>
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
		<table>
			<tbody> 
                <tr>
                    <td width="480">
                    	<div class="sm" style="width:480px">
                        <table> 
                            <tr>
                              <td width="5"></td>
                              <td width="100">
                                  <input type="radio" name="div_flag" id="div_flag_1" value="1" OnClick="radioToggle();" checked><label for="div_flag_1"><strong>Approval WK</strong></label>
                              </td>  
                              <td width="70"><input type="text" name="yrwk" id="yrwk" dataformat="num" value="<%=tempWeek%>" class="input1" style="width:55px;ime-mode:disabled;" maxlength="6" dataformat='num'></td>
                              <td width="70">
                                  <input type="radio" name="div_flag" id="div_flag_2" value="2" OnClick="radioToggle();"><label for="div_flag_2"><strong>Period</strong></label>
                              </td>  
                              
                              <td width="90"> 
                                  <select name="periodtp" id="periodtp" style="width:82px;" class="input">
                                  <option value="W" >yyyyww</option>
                                  <option value="M" >yyyymm</option>
                                  </select>
                              </td>
                              <td>
                                 <input name="fmperiod" id="fmperiod" value="" type="text" class="input" style="width:55px;ime-mode:disabled;" dataformat="num" maxlength="6" onkeyup="moveTabNormal(this,toperiod);">&nbsp;~
                                 <input name="toperiod" id="toperiod" value="" type="text" class="input" style="width:55px;ime-mode:disabled;" dataformat="num" maxlength="6"> 
                              </td>
                            </tr>
                      		<tr>
                      		  <td></td>
                              <td width="15">
                                  <input type="radio" name="div_flag" id="div_flag_3" value="3" OnClick="radioToggle();" ><label for="div_flag_3"><strong>Pick-up WK</strong></label>
                              </td>  
                              <td width="65"><input type="text" name="yrwk_pkup" id="yrwk_pkup" dataformat="num" value="<%=tempWeek%>" class="input" style="width:55px;ime-mode:disabled;" maxlength="6" dataformat='num'></td>
                              <td width="15">
                                  <input type="radio" name="div_flag" id="div_flag_4" value="4" OnClick="radioToggle();"><label for="div_flag_4"><strong>Period</strong></label>
                              </td>  
                              <td width="75"> 
                                  <select name="periodtp_pkup" id=""periodtp_pkup"" style="width:82px;" class="input">
                                  <option value="W" >yyyyww</option>
                                  <option value="M" >yyyymm</option>
                                  </select>
                              </td>
                              <td width="140">
                                 <input name="fmperiod_pkup" id="fmperiod_pkup" value="" type="text" class="input" style="width:55px;ime-mode:disabled;" dataformat="num" maxlength="6" onkeyup="moveTabNormal(this,toperiod_pkup);">&nbsp;~
                                 <input name="toperiod_pkup" id="toperiod_pkup" value="" type="text" class="input" style="width:55px;ime-mode:disabled;" dataformat="num" maxlength="6"> 
                              </td>
                           </tr>                            
                        </table>
                        </div>
                    </td>  
                    <td>
					    <table>
					        <tr>
                              <th width="50">RCC</th>
                              <td width="90">
                                  <script language="javascript">ComComboObject('rcc_cd' , 1, 80, 1 )</script>
                              </td>    
                              <th width="30">LCC</th>
                              <td width="90">
                                  <script language="javascript">ComComboObject('lcc_cd' , 1, 105, 1 )</script>
                              </td>             
                              <th width="40">TP/SZ</th>
                              <td width="55"><%= cntrTpsz %></td>
                              <td><script language="javascript">ComComboObject('tpsztype' , 1, 130, 1 )</script></td>
                           </tr>
					       <tr>
                             <th width="50">Status</th>
                             <td width="90">
                                 <select style="width:105px;" name="sts_cd" class="input" ><!-- LOC_TYPE_CODE -->
                                     <option value="" selected>ALL</option>
                                     <option value="S">Saved</option>
                                     <option value="R">Requested</option>
                                     <option value="A">Approved</option>
                                     <!-- loc_cd -->
                                 </select>                         
                             </td>    
                           </tr>
                        </table>
                    </td>                    
                </tr>
			</tbody>
		</table>			
	</div>
	<!-- opus_design_inquiry(E) -->
	</div>
	
	<div class="wrap_result">	
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid"> 
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_rowadd" id="btn_rowadd">Row Add</button>
				<button type="button" class="btn_normal" name="btn_rowdel" id="btn_rowdel">Row Delete</button>
			</div>
		    <script language="javascript">ComSheetObject('sheet1');</script>
	    </div>
	    <div style="display:none">
	    	<script language="javascript">ComSheetObject('sheet2');</script>
	    </div>
		<!-- opus_design_grid(E) -->
	</div>
<%if (popMode.equals("Y")) {%></div><%}%>
</form>