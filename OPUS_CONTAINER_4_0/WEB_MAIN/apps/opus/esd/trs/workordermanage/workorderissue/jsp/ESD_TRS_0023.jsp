﻿﻿<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0023.jsp
*@FileTitle  :  W/O Issue 
*@author     : CLT
*@version    : 1.0 
*@since      : 2014/06/05
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.workordermanage.workorderissue.event.EsdTrs0023Event"%>
<%@ page import="java.util.StringTokenizer"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>

<%!
    private ArrayList splitStr(String src, String delim)
    {
        if(src == null || src.equals("")) return null;
        ArrayList returnV = new ArrayList();
        StringTokenizer st = new StringTokenizer(src, delim);
        String tempNo = null;
        tempNo = st.nextToken();
        returnV.add(tempNo);
        while (st.hasMoreTokens()) {
            tempNo = st.nextToken();
            returnV.add(tempNo);
        }
        return returnV;
    }
%>
<%

	EsdTrs0023Event  event = null;            
    Exception serverException   = null;       
    DBRowSet rowSet   = null;                 
    String strErrMsg = "";                    
    int rowCount     = 0;                     
    SignOnUserAccount account = null;
    String eq_ctrl ="";
    try {
        account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        eq_ctrl=account.getOfc_cd();
        event = (EsdTrs0023Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
    }catch(Exception e) {
        out.println(e.toString());
    }

    String today = DateTime.getFormatString("yyyyMMdd");
    String beforeOneMonth = DateTime.addMonths(today, -1);

    String costModeCd   = JSPUtil.getCodeCombo("trs_cost_md_cd", "01", "style='width:160'", "CD00958", 0, "000020:ALL:ALL");
    String transModeCd  = JSPUtil.getCodeCombo("trs_md_cd", "01", "style='width:50'", "CD00283", 0, "000010:ALL:ALL");
    String boundCd = JSPUtil.getCodeCombo("trs_bnd_cd", "01", "style='width:57'", "CD00591", 0, "000030:ALL:ALL");
    String soTpCd   = JSPUtil.getCodeCombo("trs_so_tp_cd", "01", "style='width:130'", "CD00279", 0, "000040:ALL:ALL");
	String selMVMTSTS  = JSPUtil.getCodeCombo("cnmv_sts_cd", "01", "style='width:60'", "CD00252", 0, "000020::");

    ArrayList trsp_so_ofc_cty_cd = splitStr(request.getParameter("trsp_so_ofc_cty_cd"),",");
    ArrayList trsp_so_seq = splitStr(request.getParameter("trsp_so_seq"),",");
    String eq_mode = request.getParameter("eq_mode");
    boolean init_searchStr = false;
    if(trsp_so_ofc_cty_cd != null && trsp_so_ofc_cty_cd.size() > 0){
    	init_searchStr = true;
    }

%>
<script type="text/javascript">
    var beforeOneMonth = '<%=beforeOneMonth%>';
    var today = '<%=today%>';
    var init_searchStr = <%=init_searchStr%>;
    <%= BizComUtil.getIBCodeCombo("po_local_curr_cd", "01", "CURR", 1, " |")%>
    <%= JSPUtil.getIBCodeCombo("trsp_rjct_rsn_cd", "", "CD00957", 0, "")%>
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        }
        loadPage();
    }
</script>
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="FORM_CRE_USR_ID" value="<%=account.getUsr_id()%>" id="FORM_CRE_USR_ID" />
<input type="hidden" name="FORM_USR_OFC_CD" value="<%=account.getOfc_cd()%>" id="FORM_USR_OFC_CD" />
<input type="hidden" name="EQ_MODE" value="<%=StringUtil.xssFilter(eq_mode)%>" id="EQ_MODE" />
<input type="hidden" name="wo_prv_grp_seq" id="wo_prv_grp_seq" />
<input type="hidden" name="wo_iss_no" id="wo_iss_no" />
<input type="hidden" name="p_draft_flg" id="p_draft_flg" />
<input type="hidden" name="trs_sub_sts_cd_n" id="trs_sub_sts_cd_n" />
<input type="hidden" name="old_ofc_cd" value="<%=StringUtil.xssFilter(eq_ctrl)%>" id="old_ofc_cd" />
<input type="hidden" name="init_trsp_so_ofc_cty_cd" id="init_trsp_so_ofc_cty_cd"  value="<%=StringUtil.xssFilter(request.getParameter("trsp_so_ofc_cty_cd")) %>" />
<input type="hidden" name="init_trsp_so_seq" id="init_trsp_so_seq" value="<%=StringUtil.xssFilter(request.getParameter("trsp_so_seq")) %>" />

<!-- Retrieve Condition Template -->
<input type="hidden" name="pgm_no" id="pgm_no" value="ESD_TRS_0023"> <!-- UI -->
<input type="hidden" name="usr_id" id="usr_id" value="<%=account.getUsr_id()%>"><!-- User ID -->
<input type="hidden" name="ofc_cd" id="ofc_cd" value="<%=account.getOfc_cd()%>"><!-- Office CD -->
<input type="hidden" name="src_keep_flg" id="search_keep_flg" value="N">
<input type="hidden" name="keep_so_no" id="keep_so_no" value="">
<!-- Retrieve Condition Template -->

	
<!-- page_title_area(S) -->
<div class="page_title_area clear">
<!-- page_title(S) -->
<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
<!-- page_title(E) -->
<!-- opus_design_btn(S) -->
<div class="opus_design_btn">
<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
     --><button type="button" class="btn_normal" name="btn_reset" id="btn_reset">Reset</button><!--
     --><button type="button" class="btn_normal" name="btn_minimize" id="btn_minimize">Minimize</button>
</div>
<!-- opus_design_btn(E) -->

<!-- page_location(S) -->
<div class="location">
<!-- location 내용 동적생성 (별도 코딩 불필요) -->
<span id="navigation"></span>
</div>
</div>

<!-- page_title_area(E) -->

<div id="MiniLayer" style="display:inline">
<!-- wrap_search(S) -->  
<div class="wrap_search">
    <!-- opus_design_inquiry (S) -->
    <div class="opus_design_inquiry wFit">
         <table>
             <colgroup>
                   <col width="110">
                   <col width="70">
                   <col width="50">
                   <col width="50">
                   <col width="483">
                   <col width="120">
                   <col width="*">
               </colgroup>
               <tbody>
                <!--
	          <tr>
	            <th>Template</th>
	            <td colspan="4"><script  type="text/javascript">ComComboObject('templateCombo', 1, 240, 0);</script>
	            <input type="hidden" name='temp_tmpl_desc' id='temp_tmpl_desc' readOnly value="">
	              <button type="button" class="btn_etc" name="btn_template_SaveAs" id="btn_template_SaveAs">Save as..</button>
	              <button type="button" class="btn_etc" name="btn_template_Save" id="btn_template_Save">Save</button>
	              <button type="button" class="btn_etc" name="btn_template_Delete" id="btn_template_Delete">Delete</button>
	            </td>
	          </tr>
	           -->
              <tr>
                  <th>Work Order Issued</th>
                  <td>
                      <input type="radio" style="margin-left: 10px;" name='wo_radio' id='wo_radio'  value=""  onClick='setWOIssue(this);' class="trans" checked><label for = "wo_radio">All</label>
                      <input type="radio" style=""                   name='wo_radio' id='wo_radio1' value="N" onClick='setWOIssue(this);' class="trans"><label for = "wo_radio1">No</label>
                      <input type="radio" style=""                   name='wo_radio' id='wo_radio2' value="Y" onClick='setWOIssue(this);' class="trans"><label for = "wo_radio2">Yes</label>
                      <input type="hidden"                           name="hid_wo_radio" id="hid_wo_radio" />
                  </td>
                  <td></td>
                  <th>Service Provider</th>
                  <td>
                      <input type="text" name='combo_svc_provider' id='combo_svc_provider'  style="width:100px;" onChange='getTextVendorSeq(sheetObjects[0], document.form, this.value)' onKeyup='enterCheck(this)' dataformat="engup"><!-- 
                      --><input type="text" name='svc_provider' id='svc_provider' readOnly style="width:300px;" class="input2"><!-- 
                      --><button type="button" name="btng_provider" id="btng_provider"  class="input_seach_btn"></button><!-- 
                  --></td>
                <th>Work Order Issue Status</th>
                <td>
                    <select name="wo_iss_sts_cd" id="wo_iss_sts_cd" style="width:98px;">
                        <option value=""  selected>ALL</option>
                        <option value="I">Issued</option>
                        <option value="R">Reissued</option>
                        <option value="C">Correction</option>
                        <option value="N">Cancellation</option>
                    </select>
                </td>
              </tr>
             </tbody>
          </table>

          <table>
                  <colgroup>
                      <col width="90">
                      <col width="50">
                      <col width="50">                          
                      <col width="*">                          
                  </colgroup>
                  <tbody>
               <tr>
                   <th>Date</th>
                   <td width="600" style="padding-left:10;">
                        <input type="radio" style="margin-left: 10px;" name='dt_radio' id='dt_radio1' value="plan_dpt"  onClick='setWOIssue(this);' class="trans"><label for ="dt_radio1">Planned Departure</label>
                        <input type="radio" style="margin-left: 10px;" name='dt_radio' id='dt_radio2' value="dor_arr"   onClick='setWOIssue(this);' class="trans"><label for ="dt_radio2">Door Arrival</label>
                        <input type="radio" style="margin-left: 10px;" name='dt_radio' id='dt_radio3' value="so_create" onClick='setWOIssue(this);' class="trans" checked><label for ="dt_radio3">Service Order Created</label>
                        <input type="radio" style="margin-left: 10px;" name='dt_radio' id='dt_radio4' value="wo_issue"  onClick='setWOIssue(this);' class="trans"><label for ="dt_radio4">Work Order Issue</label>
                        <input type="radio" style="margin-left: 10px;" name='dt_radio' id='dt_radio5' value="wo_reject" onClick='setWOIssue(this);' class="trans"><label for ="dt_radio5">Work Order Rejected</label>
                        <input type="radio" style="margin-left: 10px;" name='dt_radio' id='dt_radio6' value="plan_rtn"  onClick='setWOIssue(this);' class="trans"><label for ="dt_radio6">Planned Return</label>
                    </td>
                    <td><input id="fmdate" name="fmdate" type="text" class="input1" maxlength="8" style="width:75px;" value="" dataformat="ymd" onfocus="javascript:delHypen(this);" onblur="javascript:getHypen(this);getDateBetween(this)" /><!-- 
                     -->~ <!-- 
                      --><input id="todate" name="todate" type="text" class="input1" maxlength="8" style="width:75px;" value="" dataformat="ymd" onfocus="javascript:delHypen(this);" onblur="javascript:getHypen(this);" /><!-- 
                       --><button type="button" name="btns_calendar" id="btns_calendar"  class="calendar ir"></button></td>
                     <td></td>
                </tr>
                </tbody>        
             </table>

             <table>
                 <colgroup>
                       <col width="90">
                       <col width="80">
                       <col width="80">
                       <col width="117">
                       <col width="100">
                       <col width="90">
                       <col width="90">
                       <col width="120">
                       <col width="98">
                       <col width="*">
                   </colgroup>
                <tbody>
                 <tr>
                     <th>Bound</th>
                     <td><%=boundCd%></td>
                     <th>Cost Mode</th>
                     <td><%=costModeCd%></td>
                     <th>Trans Mode</th>
                     <td><%=transModeCd%></td>
                     <th>Service Order Type</th>
                     <td><%=soTpCd%></td>
                     <th>Door Time</th>
                     <td>
                         <input id="dor_arr_dt" name="dor_arr_dt" type="text" maxlength="8" style="width:75px;" value="" dataformat="ymd" onselect="javascript:delHypen(this);" onblur="javascript:getHypen(this);" /><!-- 
                         --><button type="button" name="btns_calendar_single" id="btns_calendar_single" class="calendar ir"></button><!-- 
                         --><input id="dor_arr_tm" name="dor_arr_tm" type="text" dataformat="hm" maxlength="5" style="width:60px;" value="" onselect="javascript:delColon(this);" onblur="javascript:delColon(this);" /><!-- 
                     --></td>
                 </tr>
                 </tbody>
               </table>

                <table>
                    <colgroup>
                           <col width="90">
                           <col width="117">
                           <col width="80">
                           <col width="117">
                           <col width="80">
                           <col width="117">
                           <col width="80">
                           <col width="117">
                           <col width="103">
                           <col width="*">
                       </colgroup>
                    <tbody>
                    <tr>
                        <th>From</th>
                        <td><input type="text" style="width:56px;" name="search_fm_loc" onchange="getComboList(this)" onkeyup="enterCheck(this)" maxlength="5" id="search_fm_loc" dataformat="engup" /><!-- 
                            --><script type="text/javascript">ComComboObject('search_fm_yard', 1, 50, 0);</script><input type="hidden" name="temp_search_fm_yard" id="temp_search_fm_yard"><!-- 
                         --><button type="button" name="btns_frmnode" id="btns_frmnode"  class="input_seach_btn"></button></td>
                       
                        <th>Via</th>
                        <td><input type="text" style="width:56px;" name="search_via_loc" onchange="getComboList(this)" onkeyup="enterCheck(this)" maxlength="5" id="search_via_loc" dataformat="engup" /><!-- 
                         --><script type="text/javascript">ComComboObject('search_via_yard', 1, 50, 0);</script><input type="hidden" name="temp_search_via_yard" id="temp_search_via_yard"><!-- 
                         --><button type="button" name="btns_vianode" id="btns_vianode"  class="input_seach_btn"></button></td>

                        <th>To</th>
                        <td><input type="text" style="width:56px;" name="search_to_loc" onchange="getComboList(this)" onkeyup="enterCheck(this)" maxlength="5" id="search_to_loc" dataformat="engup" /><!-- 
                         --><script type="text/javascript">ComComboObject('search_to_yard', 1, 50, 0);</script><input type="hidden" name="temp_search_to_yard" id="temp_search_to_yard"><!-- 
                         --><button type="button" name="btns_tonode" id="btns_tonode"  class="input_seach_btn"></button></td>                        

                        <th>Door</th>
                        <td><input type="text" style="width:56px;" name="search_door_loc" onchange="getComboList(this)" onkeyup="enterCheck(this)" maxlength="5" id="search_door_loc" dataformat="engup" /><!-- 
                         --><script type="text/javascript">ComComboObject('search_door_yard', 1, 50, 0);</script><input type="hidden" name="temp_search_door_yard" id="temp_search_door_yard"><!-- 
                         --><button type="button" name="btns_dorloc" id="btns_dorloc"  class="input_seach_btn"></button></td>                         

				        <th>Zip Code</th>
				        <td>
				            <input id="dor_pst_cd" name="dor_pst_cd" type="text" style="width:70px;" onBlur="val_check(this,'ZIPCD');" dataformat="engup" otherchar=", "><!-- 
				         --><button type="button" name="btns_dor_pst_cd" id="btns_dor_pst_cd" class="multiple_inq ir"></button><!-- 
				     --></td>
                    </tr>
                   </tbody>
                 </table>


             <table>
                 <colgroup>
                       <col width="90">
                       <col width="100">
                       <col width="54">
                       <col width="100">
                       <col width="54">
                       <col width="100">
                       <col width="54">
                       <col width="117">
                       <col width="93">
                       <col width="*">
                   </colgroup>
                <tbody>
                 <tr>
                     <th>From-LCC</th>
                     <td>
                         <input id = "fm_lcc_cd" name = "fm_lcc_cd" type = "text" class = "input" style="width:107px;" onchange="toUpperCase(this)" onfocus="fun_Focus(this)" onkeyup="enterCheck(this)" maxlength="5" dataformat="engup" otherchar=","><!-- 
                      --><button type="button" id="btns_fm_lcc_cd" name="btns_fm_lcc_cd" class="multiple_inq ir"></button><button type = "button" class = "input_seach_btn" onclick = "openFmLccPopUp('Y', 'N');"></button><!-- 
                  --></td>
                     <th>To-LCC</th>
                     <td>
                         <input id = "to_lcc_cd" name = "to_lcc_cd" type = "text" class = "input" style="width:107px;" onchange="toUpperCase(this)" onfocus="fun_Focus(this)" onkeyup="enterCheck(this)" maxlength="5" dataformat="engup" otherchar=","><!-- 
                      --><button type="button" id="btns_to_lcc_cd" name="btns_to_lcc_cd" class="multiple_inq ir"></button><button type = "button" class = "input_seach_btn" onclick = "openToLccPopUp('Y', 'N');"></button><!-- 
                  --></td>
                     <th>ECC</th>
                     <td>
                         <input id = "ecc_cd" name = "ecc_cd" type = "text" class = "input" style="width:107px;" onchange="toUpperCase(this)" onfocus="fun_Focus(this)" onkeyup="enterCheck(this)" maxlength="5" dataformat="engup" otherchar=","><!-- 
                      --><button type="button" id="btns_ecc_cd" name="btns_ecc_cd" class="multiple_inq ir"></button><button type = "button" class = "input_seach_btn" onclick = "openEccPopUp('Y', 'N');"></button><!-- 
                  --></td>
                     <th>Office</th>
                     <td>
                         <input id = "input_office" name = "input_office" type="text" onBlur = 'javascript:this.value=this.value.toUpperCase();' style="width:82px;" value='<%=account.getOfc_cd()%>' maxlength='5' onBlur='value_upper(this)' dataformat="engup" otherchar=","><!-- 
                      --><button type = "button" class = "input_seach_btn" id = "btns_office" name = "btns_office"></button>&nbsp;
                     </td>
                     <td>
                     	 <input type="checkbox" id="chk_office" name="chk_office" value="Y" class="trans" onClick="javascript:fun_chkOffice();" style="vertical-align:bottom;"> Incl. Sub OFC &nbsp;
                     	 <input type="checkbox" id="cop_flg" name="cop_flg" value="Y" class="trans" style="vertical-align:bottom;"> Attached Flag</td>
                     <td></td>
                 </tr>
                 </tbody>
               </table>


            </div>
                 <table class="line_bluedot"><tr><td></td></tr></table>
            <div class="opus_design_inquiry wFit">     
                 
                 <table>
                         <colgroup>
                            <col width="90">
                            <col width="100">
                            <col width="55">
                            <col width="150">
                            <col width="30">
                            <col width="60">
                            <col width="30">
                            <col width="80">
                            <col width="*">
                        </colgroup>
                        <tbody>
                        <tr>
                            <th>T.VVD</th>
                            <td>
                                <input name="tvvd_no" class="input" type="text" onblur="javascript:this.value=this.value.toUpperCase();" onkeyup="enterCheck(this)" style="width:107px;" id="tvvd_no" dataformat="engup" /><!-- 
                                --><button type="button" id="btns_tvvd_no" name="btns_tvvd_no" class="multiple_inq ir"></button><button type="button" id="btns_tvvd_s_no" name="btns_tvvd_s_no" class="input_seach_btn"></button><!-- 
                            --></td>
                            <th>F.VVD</th>
                            <td>
                                <input type="radio" style="margin-left: 2px" name="f_vvd_radio" value="A" onclick="" class="trans" checked id="f_vvd_radio1" /><label for ="f_vvd_radio1">All</label>
                                <input type="radio" name="f_vvd_radio" value="I" onclick="" class="trans" id="f_vvd_radio2" /><label for ="f_vvd_radio2">In VVD</label>
                                <input type="radio" name="f_vvd_radio" value="O" onclick="" class="trans" id="f_vvd_radio3" /><label for ="f_vvd_radio2">Out VVD</label>
                            </td>
                            <td>
                                <input name="fvvd_no" type="text" onblur="javascript:this.value=this.value.toUpperCase();" onkeyup="enterCheck(this)" style="width:132px;" id="fvvd_no" dataformat="engup" otherchar="," /><!-- 
                                 --><button type="button" name="btns_fvvd_no" id="btns_fvvd_no"  class="multiple_inq ir"></button><!-- 
                                 --><button type="button" name="btns_fvvd_s_no" id="btns_fvvd_s_no"  class="input_seach_btn"></button>                                                                                          
                             </td>
				             <th>COP No.</th>
				             <td>
				                 <input id="cop_no" name="cop_no" type="text" style="width:100px;" onBlur="setgetUpper(this);val_check(this,'COP NUMBER');" dataformat="engup" otherchar=","><!-- 
				                 --><button type="button" name="btns_cop_no" id="btns_cop_no" class="multiple_inq ir"></button>
				             </td>
				             <th>Slot Ref No.</th>
				             <td>
				                 <input id="cntr_slt_no" name="cntr_slt_no" type="text" style="width:100px;" dataformat="engup" otherchar=","><!-- 
				                 --><button type="button" name="btns_cntr_slt_no" id="btns_cntr_slt_no" class="multiple_inq ir"></button>
				             </td>
                          </tr>
                         </tbody>
                    </table>
                    
                    <table>
                        <colgroup>
                            <col width="90">
                            <col width="120">
                            <col width="60">
                            <col width="150">
                            <col width="90">
                            <col width="80">
                            <col width="100">
                            <col width="100">
                            <col width="100">
                            <col width="*">
                        </colgroup>
                        <tbody>
                        <tr>
                            <th>Booking No.</th>
                            <td><input name="bkg_no" type="text" onblur="javascript:this.value=this.value.toUpperCase();" onkeyup="enterCheck(this)" style="width:107px;" id="bkg_no" dataformat="engup" otherchar="," /><!-- 
                             --><button type="button" id="btns_bkg_no" name="btns_bkg_no" class="multiple_inq ir"></button></td>
                            <th>B/L No.</th>
                            <td><input name="bl_no" type="text" onblur="javascript:this.value=this.value.toUpperCase();" onkeyup="enterCheck(this)" style="width:120px;" id="bl_no" dataformat="engup" otherchar="," /><!-- 
                             --><button type="button" id="btns_bl_no" name="btns_bl_no" class="multiple_inq ir"></button></td>
                            <th>BKG CGO SPE</th>
						    <td>
						    	<script type="text/javascript">ComComboObject('spcl_cgo_cntr_tp_cd', 2, 70, 1, 0);</script>
						    	<input type="hidden" name="temp_spcl_cgo_cntr_tp_cd" id="temp_spcl_cgo_cntr_tp_cd">
						    </td>
                            <th>Equipment No.</th>
                            <td>
								<input type="radio" id="eq_radio1" name="eq_radio" value="U" onclick="change_eq_val();checkDigit()" class="trans" checked /><label for ="eq_radio1">Container</label><!-- 
                             --><input type="radio" id="eq_radio2" name="eq_radio" value="Z" onclick="change_eq_val();" class="trans" /><label for ="eq_radio2">Chassis</label><!-- 
                             --><input type="radio" id="eq_radio3" name="eq_radio" value="G" onclick="change_eq_val();" class="trans" /><label for ="eq_radio3">Genset</label></td>
                            <td><input name="eq_no" type="text" onblur="javascript:this.value=this.value.toUpperCase();" onchange="checkDigit(this)" onkeyup="enterCheck(this)" style="width:100px;" id="eq_no" dataformat="engup" otherchar="," /><!-- 
                             --><button type="button" name="btns_eq_no" id="btns_eq_no"  class="multiple_inq ir"></button></td>
                            <td>&nbsp;
                                <input type=checkbox id="ruoh" name="ruoh" value=""/>&nbsp;RUOH
                            </td>
                          </tr>
                         </tbody>
                    </table>

                    <table>
                        <colgroup>
                            <col width="90">
                            <col width="120">
                            <col width="60">
                            <col width="150">
                            <col width="130">
                            <col width="179">
                            <col width="95">
                            <col width="90">
                            <col width="85">
                            <col width="*">
                        </colgroup>
                             <tbody>
                        <tr>
                            <th>S/O No.</th>
                            <td><input name='so_no' type="text" onBlur='javascript:this.value=this.value.toUpperCase();' onKeyup='enterCheck(this)' style="width:107px;" dataformat="engup" otherchar=","><!-- 
                             --><button type="button" name="btns_so_no" id="btns_so_no"  class="multiple_inq ir"></button></td>                            
                            <th>W/O No.</th>
                            <td><input name='wo_no' type="text" onBlur='javascript:this.value=this.value.toUpperCase();' onKeyup='enterCheck(this)' style="width:120px;" dataformat="engup" otherchar=","><!-- 
                             --><button type="button" name="btns_wo_no" id="btns_wo_no"  class="multiple_inq ir"></button></td>                            
                            <th>MTY Reference No.</th>
                            <td><input name='mty_rfrn_no' type="text" onBlur='javascript:this.value=this.value.toUpperCase();' onKeyup='enterCheck(this)'  onBlur='javascript:this.value=this.value.toUpperCase();' style="width:120px;" dataformat="engup" otherchar="," ><!-- 
                             --><button type="button" name="btns_mty_rfrn_no" id="btns_mty_rfrn_no" class="multiple_inq ir"></button></td> 
							<th>Cargo Type</th>
							<td>
							    <script type="text/javascript">ComComboObject('cgo_tp_cd', 2, 70, 1, 0);</script>
							    <input type="hidden" name="temp_cgo_tp_cd" id="temp_cgo_tp_cd">
							</td>
							<th>EQ TP/SZ</th>
							<td>
							    <script type="text/javascript">ComComboObject('eq_tpsz_cd', 2, 60, 1, 0);</script>
							    <input type="hidden" name="temp_eq_tpsz_cd" id="temp_eq_tpsz_cd">
							</td>
                        </tr>
                        </tbody>
                    </table>
                    <table>
                        <colgroup>
                            <col width="90">
                            <col width="120">
                            <col width="70">
                            <col width="120">
                            <col width="90">
                            <col width="80">
                            <col width="130">
                            <col width="60">
                            <col width="130">
                            <col width="64">
                            <col width="64">
                            <col width="*">
                        </colgroup>
                        <tbody>
                            <tr>
                            	<th>Change Mgmt.</th>
                                <td>
							        <select name="trs_chg_tp_cd">
							        	<option value=""  selected></option>
				                        <option value="A">All Changes</option>
				                        <option value="S">Shipment Change</option>
				                        <option value="V">Vendor Change</option>
				                    </select>                                
                                </td>
                                <th>CM Item.</th>
                                <td><input type="text" onBlur='javascript:this.value=this.value.toUpperCase();' onKeyup='enterCheck(this)' style="width:107px;" dataformat="engup" ></td>
                                <th>Transp Status</th>
							    <td>
							       <!--  <select name="trs_sub_sts_cd" style="width:98px;">
				                        <option value=""  selected>ALL</option>
				                        <option value="DF">Draft</option>
				                        <option value="OR">Ordered</option>
				                        <option value="ST">Started</option>
				                        <option value="AC">Accepted</option>
				                        <option value="CM">Completed</option>
				                    </select> -->
				                    <script type="text/javascript">ComComboObject('trs_sub_sts_cd', 2, 70, 1, 0);</script>
							    </td>
								<th>Latest MVMT STS</th>
								<td>
									<%=selMVMTSTS %>
								</td>
								<th>Latest MVMT Yard</th>
							    <td>
							    	<input type="text" name="crnt_yd_cd" style="width:64px;" id="crnt_yd_cd" onchange="checkYardCode(this)" onfocus="fun_Focus(this)" maxlength="7" dataformat="engup">
							    </td>
							    
							    <th>User ID</th>
				                <td><input name="user_id" type="text" style="width:80px;" maxlength='20' dataformat="eng"></td>
                            </tr>
                        </tbody>
                    </table>                 

    </div>
    <!-- opus_design_inquiry (E) -->
</div>
<!-- wrap_search(E) -->  
</div>


<!-- wrap_result(S) -->  
<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid" id="mainTable">

    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn opus_design_normal">
    <!-- Content -->
		<button type="button" class="btn_normal" name="btng_draft" id="btng_draft">Draft</button><!-- 
		 --><button type="button" class="btn_normal" name="btng_cmdtl" id="btng_cmdtl">SHPMT CM</button><!-- 
		 --><button type="button" class="btn_normal" name="btng_vndrcm" id="btng_vndrcm">VNDR CM</button><!-- 
		 --><button type="button" class="btn_normal" name="btng_joedihis" id="btng_joedihis">WO EDI HISTORY</button><!--
		 --><button type="button" class="btn_normal" name="btng_cycntrupd" id="btng_cycntrupd">CY CNTR Update</button><!-- 
		 --><button type="button" class="btn_normal" name="btng_trnasp_status_update" id="btng_trnasp_status_update">Transp. Status Update</button><!-- 
		 --><!-- <button type="button" class="btn_normal" name="btng_surchargeapply" id="btng_surchargeapply">Surcharge Apply</button> --><!-- 
         --><button type="button" class="btn_normal" name="btng_downexcel" id="btng_downexcel"> Down Excel </button><!-- 
         --><button type="button" class="btn_normal" name="btng_frustrate" id="btng_frustrate">Frustrate</button><!-- 
         --><button type="button" class="btn_normal" name="btng_spselect" id="btng_spselect">S/P Select</button><!-- 
         --><button type="button" class="btn_normal" name="btng_morecandidate" id="btng_morecandidate">More Candidate</button><!-- 
         --><button type="button" class="btn_normal" name="btng_wopreview" id="btng_wopreview">W/O Preview</button>
         
    </div>
    
    <script type="text/javascript">ComSheetObject('sheet');</script>
</div>
<!-- opus_design_grid(E) -->

<!-- opus_design_grid(S) -->
<div class="opus_design_grid" id="hidden table2">
    <script type="text/javascript">ComSheetObject('sheet2');</script>
</div>
<!-- opus_design_grid(E) -->

<!-- opus_design_grid(S) -->
<div class="opus_design_grid" id="hidden Table3">
    <script type="text/javascript">ComSheetObject('sheet3');</script>
</div>

<div class="opus_design_grid" id="hidden Table4">
    <script type="text/javascript">ComSheetObject('sheet4');</script>
</div>

<div class="opus_design_grid" id="hidden Table5">
    <script type="text/javascript">ComSheetObject('sheet5');</script>
</div>
<!-- opus_design_grid(E) -->
	<div class="opus_design_grid" id="ttl_layer">
		<div class="layout_wrap">
			<div class="layout_vertical_2" style="width:20%;">
				<div class="opus_design_inquiry">
					<table class="grid_2">
						<tr>
							<th>Total</th>
							<th>TEU</th>
							<td><input type="text" style="width:55px;text-align:right" class="noinput" value="" readonly id="sum_ttlteu" /> </td>
							<th>FEU</th>
							<td><input type="text" style="width:55px;text-align:right" class="noinput" value="" readonly id="sum_ttlfeu" /> </td>
							<th>BOX</th>
							<td><input type="text" style="width:55px;text-align:right" class="noinput" value="" readonly id="sum_ttlbox" /> </td>
						</tr>
					</table>
				</div>
			</div>
			<div class="layout_vertical_2" style="width:10%;">
				<div class="opus_design_inquiry">
				</div>
			</div>			
			<div class="layout_vertical_2" style="width:40%">
				<div class="opus_design_inquiry">
					<table class="grid_2">
						<tr>
							<th>D2</th>
							<td><input type="text" style="width:40px;text-align:right" class="noinput" value="" readonly id="sum_d2" /> </td>
							<th>D4</th>
							<td><input type="text" style="width:40px;text-align:right" class="noinput" value="" readonly id="sum_d4" /> </td>
							<th>D5</th>
							<td><input type="text" style="width:40px;text-align:right" class="noinput" value="" readonly id="sum_d5" /> </td>
							<th>D7</th>
							<td><input type="text" style="width:40px;text-align:right" class="noinput" value="" readonly id="sum_d7" /> </td>
							<th>R2</th>
							<td><input type="text" style="width:40px;text-align:right" class="noinput" value="" readonly id="sum_r2" /> </td>
							<th>R4</th>
							<td><input type="text" style="width:40px;text-align:right" class="noinput" value="" readonly id="sum_r4" /> </td>
							<th>R5</th>
							<td><input type="text" style="width:40px;text-align:right" class="noinput" value="" readonly id="sum_r5" /> </td>
							<th>F2</th>
							<td><input type="text" style="width:40px;text-align:right" class="noinput" value="" readonly id="sum_f2" /> </td>
							<th>Gross Weight</th>
							<th><input type="text" style="width:100px;text-align:right" class="noinput" value="" readonly id="sum_ttlwgtkgs" dataformat="float" pointcount="3"/>KGS</th>
						</tr>
						<tr>
							<th>F4</th>
							<td><input type="text" style="width:40px;text-align:right" class="noinput" value="" readonly id="sum_f4" /> </td>
							<th>F5</th>
							<td><input type="text" style="width:40px;text-align:right" class="noinput" value="" readonly id="sum_f5" /> </td>
							<th>O2</th>
							<td><input type="text" style="width:40px;text-align:right" class="noinput" value="" readonly id="sum_o2" /> </td>
							<th>O4</th>
							<td><input type="text" style="width:40px;text-align:right" class="noinput" value="" readonly id="sum_o4" /> </td>
							<th>A2</th>
							<td><input type="text" style="width:40px;text-align:right" class="noinput" value="" readonly id="sum_a2" /> </td>
							<th>A4</th>
							<td><input type="text" style="width:40px;text-align:right" class="noinput" value="" readonly id="sum_a4" /> </td>
							<th>S2</th>
							<td><input type="text" style="width:40px;text-align:right" class="noinput" value="" readonly id="sum_s2" /> </td>
							<th>S4</th>
							<td><input type="text" style="width:40px;text-align:right" class="noinput" value="" readonly id="sum_s4" /> </td>
							<th>Gross Weight</th>
							<th><input type="text" style="width:100px;text-align:right" class="noinput" value="" readonly id="sum_ttlwgtlbs"  dataformat="float" pointcount="3" />LBS</th>							
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- wrap_result(E) -->  
<div class="header_fixed"></div>
</form>
<form name='woForm' method='POST' action='ESD_TRS_0024.screen'>
<input type="hidden" name="pgmNo" id="pgmNo" />
<input type="hidden" name="draft_flg" id="draft_flg" />
<input type="hidden" name="rd_cgo" id="rd_cgo" />
<input type="hidden" name="trsp_so_ofc_cty_cd" id="trsp_so_ofc_cty_cd" />
<input type="hidden" name="trsp_so_seq" id="trsp_so_seq" />
<input type="hidden" name="wo_cancel_flag" id="wo_cancel_flag" />
<input type="hidden" name="dtn_use_flg" id="dtn_use_flg" />
<input type="hidden" name="wo_bl_no_iss_flg" id="wo_bl_no_iss_flg" />
<input type="hidden" name="vndr_seq" id="vndr_seq" />
<input type="hidden" name="po_local_curr_cd" id="po_local_curr_cd" />
<input type="hidden" name="po_basic_rt" id="po_basic_rt" />
<input type="hidden" name="nego_amt" id="nego_amt" />
<input type="hidden" name="etc_add_amt" id="etc_add_amt" />
<input type="hidden" name="po_fuel_scg_rt" id="po_fuel_scg_rt" />
<input type="hidden" name="po_usd_curr_tot_amt" id="po_usd_curr_tot_amt" />
<input type="hidden" name="n3pty_bil_flg" id="n3pty_bil_flg" />
<input type="hidden" name="eq_mode" value="IS" id="eq_mode" />
<input type="hidden" name="issued" id="issued" />
<input type="hidden" name="scg_grp_seq" id="scg_grp_seq" />
<input type="hidden" name="cust_cnt_cd" id="cust_cnt_cd" />
<input type="hidden" name="cust_seq" id="cust_seq" />
<input type="hidden" name="cust_nomi_trkr_flg" id="cust_nomi_trkr_flg" />
<input type="hidden" name="trsp_agmt_rt_tp_cd" id="trsp_agmt_rt_tp_cd" />
<input type="hidden" name="trsp_agmt_wy_tp_cd" id="trsp_agmt_wy_tp_cd" />
<input type="hidden" name="trsp_frst_flg" id="trsp_frst_flg" />
<input type="hidden" name="trsp_rjct_rsn_cd" id="trsp_rjct_rsn_cd" />
<input type="hidden" name="trsp_dflt_vndr_flg" id="trsp_dflt_vndr_flg" />

<input type="hidden" name="n1st_nod_pln_dt" id="n1st_nod_pln_dt" />
<input type="hidden" name="lst_nod_pln_dt" id="lst_nod_pln_dt" />
<input type="hidden" name="dor_nod_pln_dt" id="dor_nod_pln_dt" />
<input type="hidden" name="inter_rmk" id="inter_rmk" />
<input type="hidden" name="spcl_instr_rmk" id="spcl_instr_rmk" />

<input type="hidden" name="form_fctry_nm" id="form_fctry_nm" />
<input type="hidden" name="form_dor_pst_cd" id="form_dor_pst_cd" />
<input type="hidden" name="form_cntc_pson_phn_no" id="form_cntc_pson_phn_no" />
<input type="hidden" name="form_cntc_pson_fax_no" id="form_cntc_pson_fax_no" />
<input type="hidden" name="form_cntc_pson_nm" id="form_cntc_pson_nm" />

<input type="hidden" name="n3pty_cust_cnt_cd" id="n3pty_cust_cnt_cd" />
<input type="hidden" name="n3pty_cust_seq" id="n3pty_cust_seq" />
<input type="hidden" name="n3pty_desc" id="n3pty_desc" />
<input type="hidden" name="n3pty_vndr_seq" id="n3pty_vndr_seq" />
<input type="hidden" name="n3pty_ofc_cd" id="n3pty_ofc_cd" />
<input type="hidden" name="n3pty_bil_bzc_amt" id="n3pty_bil_bzc_amt" />
<input type="hidden" name="n3pty_bil_tp_cd" id="n3pty_bil_tp_cd" />
<input type="hidden" name="n3pty_curr_cd" id="n3pty_curr_cd" />

<input type="hidden" name="trsp_agmt_ofc_cty_cd" id="trsp_agmt_ofc_cty_cd" />
<input type="hidden" name="trsp_agmt_seq" id="trsp_agmt_seq" />

<input type="hidden" name="wgt_meas_ut_cd" id="wgt_meas_ut_cd" />
<input type="hidden" name="cntr_lbs_wgt" id="cntr_lbs_wgt" />
<input type="hidden" name="cntr_kgs_wgt" id="cntr_kgs_wgt" />
<input type="hidden" name="cntr_pkup_no" id="cntr_pkup_no" />
<input type="hidden" name="scg_ind_cd" id="scg_ind_cd" />

<input type="hidden" name="sysCommUiTitle" value="Preview" id="sysCommUiTitle" />
<input type="hidden" name="sysCommUiNavigation" value="Trans S/O > Work Order" id="sysCommUiNavigation" />
</form>

<form name='soForm' method='POST' action='ESD_TRS_019.screen'>
<input type="hidden" name="trsp_so_ofc_cty_cd" id="trsp_so_ofc_cty_cd" />
<input type="hidden" name="trsp_so_seq" id="trsp_so_seq" />
</form>

<FORM NAME='scgForm' id="scgForm" method='POST'>
<input type="hidden" name="unique_cd" id="unique_cd" />
<input type="hidden" name="open_mode" id="open_mode" />
<input type="hidden" name="step_cd" id="step_cd" />
<input type="hidden" name="main_row" id="main_row" />
<input type="hidden" name="sheet_arr_no" id="sheet_arr_no" />
<input type="hidden" name="ofc_cty_cd" id="ofc_cty_cd" />
<input type="hidden" name="so_seq" id="so_seq" />
<input type="hidden" name="curr_cd" id="curr_cd" />
<input type="hidden" name="multi_ofc_cty_cd" id="multi_ofc_cty_cd" />
<input type="hidden" name="multi_so_seq" id="multi_so_seq" />
<input type="hidden" name="multi_cgo_tp_cd" id="multi_cgo_tp_cd" />
<input type="hidden" name="check_row" id="check_row" />


<!-- 2014.12.11    Hyungwook Choi -->
<input type="hidden" name="vndr_seq"             id="vndr_seq" />
<input type="hidden" name="trsp_crr_mod_cd"      id="trsp_crr_mod_cd" />
<input type="hidden" name="trsp_cost_dtl_mod_cd" id="trsp_cost_dtl_mod_cd" />
<input type="hidden" name="cgo_tp_cd"            id="cgo_tp_cd" />
<input type="hidden" name="trsp_bnd_cd"          id="trsp_bnd_cd" />
<input type="hidden" name="fm_nod_cd"            id="fm_nod_cd" />
<input type="hidden" name="via_nod_cd"           id="via_nod_cd" />
<input type="hidden" name="dor_nod_cd"           id="dor_nod_cd" />
<input type="hidden" name="to_nod_cd"            id="to_nod_cd" />
<input type="hidden" name="cre_dt"               id="cre_dt" />
<input type="hidden" name="eq_knd_cd"            id="eq_knd_cd" />
<input type="hidden" name="eq_tpsz_cd"           id="eq_tpsz_cd" />
<input type="hidden" name="po_fuel_scg_rt"       id="po_fuel_scg_rt" />
<input type="hidden" name="scg_ind_cd"           id="scg_ind_cd" />


</FORM>

<form name='negoForm' method='POST'>
<input type="hidden" name="nego_amt" id="nego_amt" />
<input type="hidden" name="nego_row" id="nego_row" />
<input type="hidden" name="nego_col" id="nego_col" />
</form>