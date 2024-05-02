<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0079_01.jsp
*@FileTitle  :  
*@author     : CUONG.LE
*@version    : 1.0  
*@since      : 2014/05/15
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.core.controller.util.WebKeys"%>
<%@ page import="com.clt.framework.core.view.template.Screen"%>
<%-- <%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg007901Event"%> --%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.core.controller.DefaultViewAdapter"%>



<%
//  EsmBkg007901Event  event = null;          //PDTO(Data Transfer Object including Parameters)
  Exception serverException   = null;     // error from server
  String strErrMsg = "";            // error message

  String strUsr_id  = "";
  String strUsr_nm  = "";
  String strUsr_ofc   = "";
  String strUsr_tel   = "";
  String strUsr_eml   = "";
  String strUsr_info  = "";
  String strUsr_cntCd = "";
  String showUsrInfo  = "";
  
  String bkgNo = "";
  String isInquiry = "N"; 
  String caNewCreationFlag = "";
  
  Logger log = Logger.getLogger("com.clt.apps.GeneralBookingConduct.GeneralBookingReceipt");
  
  String sXml = null;
  try {
      SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    strUsr_ofc = account.getOfc_cd();
    strUsr_tel = account.getMphn_no();
    strUsr_eml = account.getUsr_eml();
    strUsr_cntCd = account.getCnt_cd();
    //strUsr_info = strUsr_nm + "&#13" + strUsr_ofc + "&#13" + strUsr_tel + "&#13" + strUsr_eml;
    strUsr_info = "ID : " + strUsr_nm + "<br>BKG OFD : " + strUsr_ofc + "<br>TEL : " + strUsr_tel + "<br>E-mail : " + strUsr_eml;
    
//    event = (EsmBkg007901Event)request.getAttribute("Event");
    
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }
    
    bkgNo  = JSPUtil.getParameter(request, "bkg_no");
    
    Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
    //inquiry mode
    if (screen.getName().indexOf("Q") >= 0){
      isInquiry = "Y";
    } else {
      isInquiry = "N";      
    }
    
    //ca new creation
    if (screen.getName().indexOf("C") >= 0){
      caNewCreationFlag = "Y";
    } else {
      caNewCreationFlag = "N";
    }
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    DefaultViewAdapter adapter = new DefaultViewAdapter();
    sXml = adapter.makeXML(request, response);    
    
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

<form name="form" onKeyDown="ComKeyEnter('search')">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="isInquiry" id="isInquiry" value="<%=isInquiry%>">
<input type="hidden" name="sXml" id="sXml" value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>">
<input type="hidden" name="usr_ofc_cd" id="usr_ofc_cd" value="<%=strUsr_ofc%>">
<input type="hidden" name="gw_subject" id="gw_subject" />
<input type="hidden" name="gw_contents" id="gw_contents" />
<input type="hidden" name="gw_template" value="ESM_BKG_COMM_01T.html" id="gw_template" />
<input type="hidden" name="gw_args" value="reqcontents;" id="gw_args" />
<input type="hidden" name="com_subject" id="com_subject" />
<input type="hidden" name="com_content" id="com_content" />
<input type="hidden" name="usr_toyota_check" id="usr_toyota_check" value="N"/>
<input type="hidden" name="bl_no_ck" id="bl_no_ck" value=""/>
<input type="hidden" name="lst_sav_dt" id="lst_sav_dt" value=""/>
<% if("Y".equals(caNewCreationFlag)){ %>

	<!-- page_title_area(S) -->
	<!-- <div class="page_title_area clear "> -->
	<div class="page_title_area clear">
	
	    <!-- page_title(S) -->
	    <h2 class="page_title"><button type="button"><span id="title">Booking Creation after BDR</span></button></h2>
	    <!-- page_title(E) -->
	    
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_t1retrieve" id="btn_t1retrieve">Retrieve</button><!--  
		    --><button type="button" class="btn_normal" name="btn_t1New" id="btn_t1New">New</button><!--
		    --><button type="button" class="btn_normal" name="btn_t1RmkSave" id="btn_t1RmkSave" style="display:none">Remark Save</button><!--
		    --><button type="button" class="btn_normal" name="btn_t1Save" id="btn_t1Save">Save</button><!--
		    --><button type="button" class="btn_normal" name="btn_t1GoIBCS" id="btn_t1GoIBCS">Go to I/B CS</button><!--
		    --><button type="button" class="btn_normal" name="btn_t1BKGCancel" id="btn_t1BKGCancel">BKG Cancel</button><!--
		    --><button type="button" class="btn_normal" name="btn_t1Copy" id="btn_t1Copy">Copy</button><!--
		    --><button type="button" class="btn_normal" name="btn_t1FaxEDI" id="btn_t1FaxEDI">Fax/EDI</button><!--
		    --><button type="button" class="btn_normal" name="btn_t1Holding" id="btn_t1Holding" style="display:none">Waiting -> Firm</button><!--
		    --><button type="button" class="btn_normal" name="btn_t1Waiting" id="btn_t1Waiting" style="display:inline">Firm -> Waiting</button><!-- 
		    --><button class="btn_normal" name="btn_t1Split" id="btn_t1Split" type="button">Split</button>
		</div>
		<!-- opus_design_btn(E) --> 
	
		<!-- page_location(S) -->
		<div class="location">	
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	
	</div>
	<!-- page_title_area(E) -->

<% }else{ %>

	<!--TAB BKG Creation (S) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn opus_design_normal2">
		<button type="button" class="btn_normal2" name="btn_t1retrieve" id="btn_t1retrieve">Retrieve</button><!--  
	    --><button type="button" class="btn_normal2" name="btn_t1New" id="btn_t1New">New</button><!--
	    --><button type="button" class="btn_normal2" name="btn_t1RmkSave" id="btn_t1RmkSave" style="display:none">Remark Save</button><!--
	    --><button type="button" class="btn_normal2" name="btn_t1Save" id="btn_t1Save">Save</button><!--
	    --><button type="button" class="btn_normal2" name="btn_t1GoIBCS" id="btn_t1GoIBCS">Go to I/B CS</button><!--
	
	    --><button type="button" class="btn_normal2" name="btn_t1BKGCancel" id="btn_t1BKGCancel">BKG Cancel</button><!--
	    --><button type="button" class="btn_normal2" name="btn_t1Copy" id="btn_t1Copy">Copy</button><!--
	    --><button type="button" class="btn_normal2" name="btn_t1FaxEDI" id="btn_t1FaxEDI">Fax/EDI</button><!--
	    --><button type="button" class="btn_normal2" name="btn_t1Holding" id="btn_t1Holding" style="display:none">Waiting -> Firm</button><!--
	    --><button type="button" class="btn_normal2" name="btn_t1Waiting" id="btn_t1Waiting" style="display:inline">Firm -> Waiting</button><!-- 
	    --><button class="btn_normal2" name="btn_t1Split" id="btn_t1Split" type="button">Split</button>
	</div>
	<!-- opus_design_btn(E) --> 
<% } %>
 
<!-- wrap_search (S)  -->
<div class="wrap_search coupled_btn_normal2">
	<div class="opus_design_inquiry wFit">
		  <table>
		    <tbody>
		      <tr>
		        <th width="54">BKG No.</th>
		        <td width="150"><input type="text" name="bkg_no" maxlength="13" minlength="10" dataformat="engup"  otherchar="" style="width:103px;ime-mode:disabled;text-transform:uppercase;" class="input" value="<%= bkgNo%>" tabindex=1><!-- 
		         --><button type="button" class="btn_down_list" name="btn_splitPop" id="btn_splitPop"></button>
		        </td>
		        <th width="60">B/L No.</th>
			    <td><input type="text" name="bl_no" maxlength=13 style="width:105px;ime-mode:disabled;text-transform:uppercase;" dataformat="engup" class="input"     tabindex=3 id="bl_no"><button type="button" style="display: none;" class="btn_down_list" name="btn_OrgBlPop" id="btn_OrgBlPop"></button></td>
			  </tr>
		    </tbody>
		  </table>
	</div>
</div>
<!-- wrap_search (E)  -->


<!-- wrap_result (S)  -->
<div class="wrap_result coupled_btn_normal2">
		
		<div class="opus_design_inquiry wFit mar_btm_4">
			  <table>
			    <tbody>
			      <tr>
			        <th width="69"><input type="checkbox" name="mnl_bkg_no_flg" value="" tabindex=2 id="mnl_bkg_no_flg"><label for="mnl_bkg_no_flg">Manual</label></th>
			        <td width="40"><div style="display:none" id="split_flg"><input type="text" style="width:35px;" name="split_info" class="transgray" readOnly></div></td>
			        <th width="110"><input type="checkbox" name="edi_hld_flg" id="edi_hld_flg" value="Y"  onclick="userCheck()" ><label for="edi_hld_flg">Auto EDI Hold</label></th>
			        <th width="60"><input type="checkbox" name="si_flg" id="si_flg" value="Y"   tabindex=4><label for="si_flg" >SI</label></th>
			        <th width="70"><input type="checkbox" name="bdr_flg" id="bdr_flg" value="Y" class="transgray" disabled><label for="bdr_flg">BDR</label></th>
			        <th width="60">Status</th>
			        <td>
			        	<input type="text" name="bkg_sts_cd" style="width:20px;" class="input2" value=""  readonly>
			        	&nbsp;&nbsp;<input type="checkbox" name="bkg_wt_chk_flg" id="bkg_wt_chk_flg" value="Y" class="trans" onclick="ediHldFlgChecked()" style="margin-left: 20px;"><label for="bkg_wt_chk_flg"><font style="font-weight: bold">Wait</font></label>
			        	&nbsp;&nbsp;<input type="checkbox" name="bkg_ty_flg" id="bkg_ty_flg" value="Y" class="trans" onclick="toyotaClick()" style="margin-left: 20px"><label for="bkg_ty_flg"><font style="font-weight: bold">For 10-digit BL No.</font></label>
			        </td>
			        <td style="color:#ff0000;" width="" align="right"><div id="wait_rsn"></div></td>
			      </tr>
			    </tbody>
			  </table>
		</div>
		
		<div class="opus_design_inquiry"> 
		
			<!-- Block 1ST :layout_wrap (S) -->
			<div class="layout_wrap">
				<div class="layout_flex_fixed" style="width:480px">
		      
					<div class="opus_design_inquiry sm" style="height:125px;">
			            <table> 
			              <colgroup>
			                <col width="47" />
			                <col width="123" />
			                <col width="38" />
			                <col width="118"/>
			                <col/>
			              </colgroup>
			              <tbody>
			              <tr>
			                <th>T/VVD</th>
			                <td><input type="text" id="bkg_trunk_vvd" name="bkg_trunk_vvd" style="width:85px;" readonly="readonly"><!-- 
			                   --><button type="button" class="input_seach_btn" name="btn_0019Pop" id="btn_0019Pop"></button></td>
			                <td colspan="3">
			                  <button type="button" class="btn_etc" style="width:90px;" name="btn_t1RouteDetail" id="btn_t1RouteDetail">Route Detail</button><!-- 
			                   --><button type="button" class="btn_etc" style="width:90px;" name="btn_allocation" id="btn_allocation">Allocation</button></td>
			              </tr>
			              <tr>
			                <th title="Place of Receipt">POR</th>
			                <td><input type="text" id="bkg_por_cd" name="bkg_por_cd" style="width:56px;ime-mode:disabled;text-transform:uppercase;" dataformat="engup" class="input1" value="" maxlength=5    tabindex=12><!-- 
			                   --><input type="text" id="bkg_por_yd_cd" name="bkg_por_yd_cd" style="width:25px;ime-mode:disabled;text-transform:uppercase;" dataformat="engup" class="input" value="" maxlength=2    tabindex=13><!-- 
			                   --><button type="button" class="input_seach_btn" name="btn_0083PorPop" id="btn_0083PorPop"></button></td>
			                <th title="Port of Loading">POL</th>
			                <td><input type="text" id="bkg_pol_cd" name="bkg_pol_cd" style="width:52px;ime-mode:disabled;text-transform:uppercase;" dataformat="engup" class="input" value="" maxlength=5   tabindex=14><!-- 
			                   --><input type="text" id="bkg_pol_yd_cd" name="bkg_pol_yd_cd" style="width:25px;ime-mode:disabled;text-transform:uppercase;" dataformat="engup" class="input" value="" maxlength=2   tabindex=15><!-- 
			                   --><button type="button" class="input_seach_btn" name="btn_0083PolPop" id="btn_0083PolPop"></button></td>
			                <td rowspan="2">
			                    <table class="grid_2 mar_none" style="width:138px;">
			                      <tr><th class="align_center" style="height:20px">R/D Term</th></tr>
			                      <tr><td class="align_center noinput">
			                        <script type="text/javascript" >ComComboObject('rcv_term_cd', 2, 60, 1, 0, 0)</script>
			                        <script type="text/javascript" >ComComboObject('de_term_cd', 2, 60, 1, 0, 0)</script></td></tr>
			                    </table>
			                </td>
			              </tr>
			              <tr>
			                <th title="Port of Discharging">POD</th>
			                <td><input type="text" id="bkg_pod_cd" name="bkg_pod_cd" style="width:56px;ime-mode:disabled;text-transform:uppercase;" dataformat="engup" class="input" value="" maxlength=5  tabindex=16><!-- 
			                   --><input type="text" id="bkg_pod_yd_cd" name="bkg_pod_yd_cd" style="width:25px;ime-mode:disabled;text-transform:uppercase;" dataformat="engup" class="input" value="" maxlength=2    tabindex=17><!--
			                  --><button type="button" class="input_seach_btn" name="btn_0083PodPop" id="btn_0083PodPop"></button></td>
			                <th title="Place of Delivery">DEL</th>
			                <td><input type="text" id="bkg_del_cd" name="bkg_del_cd" style="width:52px;ime-mode:disabled;text-transform:uppercase;" dataformat="engup" class="input1" value="" maxlength=5   tabindex=18><!-- 
			                   --><input type="text" id="bkg_del_yd_cd" name="bkg_del_yd_cd" style="width:25px;ime-mode:disabled;text-transform:uppercase;" dataformat="engup" class="input" value="" maxlength=2   tabindex=19><!--  
			                  --><button type="button" class="input_seach_btn" name="btn_0083DelPop" id="btn_0083DelPop"></button></td>
			              </tr>
			              </tbody>
			              </table>
			              
			            <table>
			              <colgroup>
			                <col width="47" />
			                <col width="203" />
			                <col width="30" />
			                <col/>
			              </colgroup>
			              <tbody>
				              <tr>
				                <th>Pre</th>
				                <td><input type="text" id="pre_rly_port_cd" name="pre_rly_port_cd" style="width:56px;" class="input2" value="" readonly tabindex=-1><!-- 
				                   --><input type="text" id="pre_rly_port_yd_cd" name="pre_rly_port_yd_cd" style="width:25px;" class="input2" value="" readonly tabindex=-1><!-- 
				                   --><input type="text" id="pre_vvd_cd" name="pre_vvd_cd" style="width:100px;" class="input2" value="" readonly tabindex=-1></td>
				                <th>Post</th>
				                <td>
				                  <input type="text" id="pst_rly_port_cd" name="pst_rly_port_cd"  style="width:56px;" class="input2" value="" readonly tabindex=-1><!-- 
				                   --><input type="text" id="pst_rly_port_yd_cd" name="pst_rly_port_yd_cd" style="width:25px;" class="input2" value="" readonly tabindex=-1><!-- 
				                   --><input type="text" id="pst_vvd_cd" name="pst_vvd_cd" style="width:94px;" class="input2 mar_rgt_none" value="" readonly tabindex=-1></th>
				              </tr>
			              </tbody>
			            </table>
					</div>
				</div>
				
				<div class="layout_flex_flex" style="padding-left:488px">
					<div class="opus_design_inquiry sm" style="height:125px;">
			            <table style="width:743px"> 
			              <colgroup>
			                <col width="50" />
			                <col width="320"/>
			                <col width="37" />
			                <col width="70" />
			                <col width="70" />
			                <col width="67" />
			                <col />
			              </colgroup>
			              <tr>
			                <th>SHPR</th>
			                <td><input type="text" name="s_cust_cnt_cd" style="width:25px;ime-mode:disabled;text-transform:uppercase;" data-eng="on;" class="input1" value="" maxlength=2  dataformat="enguponly" tabindex=31><!-- 
			                   --><input type="text" name="s_cust_seq" style="width:50px;ime-mode:disabled;text-transform:uppercase;" data-eng="on;" class="input1" value="" maxlength=6   dataformat="num" tabindex=32><!-- 
			                   --><input type="text" name="s_cust_nm" style="width:180px;" class="input2" value="" readonly tabindex=-1><!-- 
			                  --><button type="button" class="input_seach_btn" name="btn_0652ShprPop" id="btn_0652ShprPop"></button></td>
			                <th>Filer </th>
			                <td><input type="text" name="" style="width:25px;" class="input2" value="US" readonly  tabindex=-1><!-- 
			                  --><script type="text/javascript" >ComComboObject('usa_cstms_file_cd', 2, 35, 1, 0, 0)</script></td>                            
			                <td><input type="text" style="width:25px;" class="input2" value="CA" readonly  tabindex=-1><!-- 
			                  --><script type="text/javascript" >ComComboObject('cnd_cstms_file_cd', 2, 35, 1, 0, 0)</script></td>
			                <th>SCAC</th>
			                <td class="align_right"><input type="text" name="scac_cd" id="scac_cd" style="width:85px;ime-mode:disabled;text-transform:uppercase;text-align:left" data-eng="on;" class="input" value="" maxlength=4  tabindex=37><!-- 
			                  --><button type="button" class="input_seach_btn" name="btn_0744Pop" id="btn_0744Pop"></button></td>
			              </tr>
			              <tr>
			                <th>FWDR</th>
			                <td><input type="text"  name="f_cust_cnt_cd" style="width:25px;ime-mode:disabled;text-transform:uppercase;" data-eng="on;" class="input1" value="" maxlength=2  dataformat="enguponly" tabindex=33><!-- 
			                   --><input type="text"  name="f_cust_seq" style="width:50px;ime-mode:disabled;text-transform:uppercase;" data-eng="on;" class="input1" value="" maxlength=6  dataformat="num" tabindex=34><!-- 
			                   --><input type="text" name="f_cust_nm" style="width:180px;" class="input2" value="" readonly  tabindex=-1><!-- 
			                  --><button type="button" class="input_seach_btn" name="btn_0652FwdrPop" id="btn_0652FwdrPop"></button></td>
			                <th colspan="4"><a href="javascript:comBkgCallPopEsmPri0004();">S/C No.</a></th>
			                <td class="align_right">
			                  <input type="text" name="sc_no" id="sc_no" style="width:85px;ime-mode:disabled;text-align:left;" dataformat="engup" class="input" value="" maxlength=9 onBlur="if(this.value=='DUM'){this.value=ComRpad(this, 8, '0');this.value=ComRpad(this, 9, '1');}" tabindex=38><!--
			                  --><button type="button" class="input_seach_btn" name="btn_ScNo" id="btn_ScNo"></button></td>
			              </tr>
			              <tr>
			                <th>CNEE</th>
			                <td><input type="text" name="c_cust_cnt_cd" style="width:25px;ime-mode:disabled;text-transform:uppercase;" data-eng="on;" class="input" value="" maxlength=2   dataformat="enguponly" tabindex=35><!-- 
			                   --><input type="text" name="c_cust_seq" style="width:50px;" class="input" value="" maxlength=6 dataformat="num" tabindex=36><!-- 
			                   --><input type="text" name="c_cust_nm" style="width:180px;" class="input2" value=""  readonly  tabindex=-1><!-- 
			                  --><button type="button" class="input_seach_btn" name="btn_ComEns041Pop" id="btn_ComEns041Pop"></button></td>
			                <th colspan="4">
			                	<input type="radio" name="chkTaaRfaNo" value="T"  onClick="javascript:chkTaaRfa('T');">
								<a href="javascript:comBkgCallPopEsmPri3007();">TAA No.</a>&nbsp;
			                	<input type="radio" name="chkTaaRfaNo" value="R"  checked onClick="javascript:chkTaaRfa('R');">
			                	<a href="javascript:comBkgCallPopEsmPri2019();">RFA No.</a></th>
			                <td class="align_right">
			                  <div id="taaNoDiv"  style="display:none">
			                      <input type="text" name="taa_no" style="width:85px;ime-mode:disabled;text-align:left;" dataformat="engup" class="input" value=""  maxlength=10  onBlur="if(this.value=='DUM'){this.value=ComRpad(this, 8, '0');this.value=ComRpad(this, 9, '1');}" tabindex=40><!-- 
			                  --><button type="button" class="input_seach_btn" name="btn_TaaNo" id="btn_TaaNo"></button>
			                  </div>
			                  <div id="rfaNoDiv"  style="display:block">                            
			                    <input type="text" name="rfa_no" style="width:85px;ime-mode:disabled;text-align:left;" dataformat="engup" class="input" value=""  maxlength=11  onBlur="if(this.value=='DUM'){this.value=ComRpad(this, 8, '0');this.value=ComRpad(this, 9, '1');}" tabindex=40><!--
			                    --><button type="button" class="input_seach_btn" name="btn_RfaNo" id="btn_RfaNo"></button>
			                  </div>
			                </td>   
			              </tr>               
			              <tr>
			              <th>CNPT</th>
			                <td><input type="text" name="bkg_ctrl_pty_cust_cnt_cd" style="width:25px;ime-mode:disabled;text-transform:uppercase;" data-eng="on;" class="input" value="" maxlength=2   dataformat="enguponly" readonly tabindex=-1><!-- 
			                   --><input type="text" name="bkg_ctrl_pty_cust_seq" style="width:50px;" class="input" value="" maxlength=6 dataformat="num" readonly tabindex=-1><!-- 
			                   --><input type="text" name="bkg_ctrl_pty_cust_nm" style="width:180px;" class="input2" value=""  readonly  tabindex=-1></td>
			                <td colspan="5" class="align_right" style="font-weight:bold;">CMDT
			                  <input type="text" name="cmdt_cd" style="width:50px;font-weight:normal;" class="input1" value="" maxlength=6 dataformat="num" tabindex=42><!--
			                  --><input type="text" name="cmdt_desc" style="width:250px;text-align:left;font-weight:normal;" class="input2" value="" readonly  tabindex=-1><!--
			                  --><button type="button" class="input_seach_btn" name="btn_CmdtPop" id="btn_CmdtPop"></button></td>
			              </tr>
			            </table>
					</div>
		      
				</div>    
			</div>
			<!-- Block 1ST :layout_wrap (E) -->
		          
		          
		  
		  
		
			<!-- Block 2ND :layout_wrap (S) -->
			<div class="layout_wrap">
				<div class="layout_flex_fixed" style="width:480px">
				
					<div class="opus_design_inquiry sm" style="height:177px;">
			            <table width="100%"> 
			              <tr>
			                <th width="57px">Total Vol.</th>
			                <td class="pad_rgt_none"><input type="text" name="total_vol" style="width:100%;" class="input2 mar_rgt_none" value="" readonly></td>
			              </tr>
			            </table>
			              
			            <div class="opus_design_grid grid_height" style="margin:4px 0">
			            	<script type="text/javascript">ComSheetObject('t1sheet1');</script>
			            	<script type="text/javascript">ComSheetObject('t1sheet2');</script>
  							<script type="text/javascript">ComSheetObject('t1sheet3');</script>
  							<script type="text/javascript">ComSheetObject('t1sheet4');</script>
			            </div>
			              
			            <table> 
			              <tr>
			                <th width="70px"><input type="checkbox"  name="flex_hgt_flg" id="flex_hgt_flg" value="Y"><b><label id="flex_hgt_flg">F.H.</label></b>&nbsp;</th>
			                <td>
			                 	<button type="button" class="btn_etc" name="btn_EqDetail" id="btn_EqDetail">Vol Detail</button><!-- 
			                   --><button type="button" class="btn_etc" name="btn_t1TPSZ"   id="btn_t1TPSZ">TP/SZ</button><!-- 
			                   --><button type="button" class="btn_etc" name="btn_t1RowAdd" id="btn_t1RowAdd">Row Add</button><!-- 
			                   --><button type="button" class="btn_etc" name="btn_t1Delete" id="btn_t1Delete">Delete</button>
			                </td>
			              </tr>
			            </table>
					</div>
				</div>
	
				<div class="layout_flex_flex" style="padding-left:488px">
			      
					<div class="opus_design_inquiry sm" style="height:177px;">
			            <table> 
							<colgroup>
				                <col width="94" />
				                <col width="170" />
				                <col width="90" />
				                <col width="184" />
				                <col width="85" />
				                <col/>
							</colgroup>
							<tbody>
					              <tr>
					                <th>Weight</th>
					               	<td><input type="text" name="act_wgt" style="width:100px;text-align:right;" class="input1" value="" dataformat="float" maxlength=14 tabindex=51><!-- 
					                  --><script type="text/javascript" >ComComboObject('wgt_ut_cd', 1, 50, 1, 0, 0)</script></th>
					                <th>C.OFC/Rep.</th>
					                <td><input type="text" name="ctrt_ofc_cd" style="width:50px;" class="input2" value="" readonly><!-- 
					                  --><input type="text" name="ctrt_srep_cd" style="width:59px;" class="input2" value="" readonly></td>
					                <th>L.OFC/Rep.</th>
					                <td><input type="text" name="ob_sls_ofc_cd" style="width:50px;" class="input2" value=""  readonly><!-- 
					                  --><input type="text" name="ob_srep_cd" style="width:59px;" class="input1" value=""  maxlength=5 tabindex=52></td>
					              </tr>
							</tbody>
						</table>
			            <table> 
							<colgroup>
				                <col width="25" />
				                <col width="110" />
				                <col width="75" />
				                <col width="70" />
				                
				                <col width="135" />
				                <col width="55" />
				                <col width="80" />
				                <col width="70" />
				                <col/>
							</colgroup>
							<tbody>
					              <tr>
					                <td>&nbsp;<input type="checkbox" onclick="waitChecked()" name="dcgo_flg" value="Y"></td>
					                <td><button type="button" class="btn_etc mar_rgt_none" name="btn_t1Danger" id="btn_t1Danger" style="width:110px">Danger</button></td>
					                <td colspan="2"><button type="button" class="btn_etc mar_rgt_none" name="btn_t1Stowage" id="btn_t1Stowage"  style="width:110px">Stowage</button></td>
					                <th class="align_left"><input type="checkbox" name="prct_flg" id="prct_flg" value="Y" ><label for="prct_flg" >Precaution</label></th>
					                <th>S/O No.</th>
					                <td><input type="text" name="twn_so_no" style="width:60px;" class="input" value=""  maxlength=6 tabindex=81></td>
					                <th>Dest. OCP</th>
					                <td><input type="text" name="ocp_cd" style="width:50px;" class="input" value="" dataformat="enguponly" maxlength=5 tabindex=82></td>
					              </tr>
					              <tr>
					                <td>&nbsp;<input type="checkbox" onclick="waitChecked()" name="rc_flg" value="Y"  ></td>
					                <td><button type="button" class="btn_etc mar_rgt_none" name="btn_t1Reefer" id="btn_t1Reefer"  style="width:110px">Reefer</button></td>
					                <td colspan="2"><button type="button" class="btn_etc mar_rgt_none" name="btn_t1Hanger" id="btn_t1Hanger"  style="width:110px">Hanger</button></td>
					                <th class="align_left"><input type="checkbox" name="spcl_hide_flg" id="spcl_hide_flg" value="Y"><label for="spcl_hide_flg" >Hide</label></th>
					                <th>eSI/BKG PTY</th>
					                <td colspan="3">
					                	<input type="text" name="bkg_pty_cnt_cd" style="width:25px;ime-mode:disabled;text-transform:uppercase;" data-eng="on;" class="input" value="" maxlength="2" dataformat="enguponly">
										<input type="text" name="bkg_pty_cust_seq" style="width:50px;ime-mode:disabled;text-transform:uppercase;" data-eng="on;" class="input" value="" maxlength="6" dataformat="num">
										<input type="text" name="bkg_pty_cust_nm" style="width:180px;" class="input2" value="" readonly="" tabindex="-1">
										<button type="button" class="input_seach_btn" name=btn_0652PtyPop id="btn_0652PtyPop"></button>
					                </td>
					              </tr>
					              <tr>
					                <td>&nbsp;<input type="checkbox" onclick="waitChecked()" name="awk_cgo_flg" value="Y"  ></td>
					                <td><button type="button" class="btn_etc mar_rgt_none" name="btn_t1Awkward" id="btn_t1Awkward"  style="width:110px">Awkward</button></td>
					                <td colspan="2"><button type="button" class="btn_etc mar_rgt_none" name="btn_t1StopOffCargo" id="btn_t1StopOffCargo"  style="width:110px">Stop Off Cargo</button></td>
					                <th class="align_left"><input type="checkbox" name="hot_de_flg" id="hot_de_flg" value="Y" disabled><label for="hot_de_flg">Premium</label></th>
					                <td colspan="4"><button type="button" class="btn_etc" name="btn_t1Constraints" id="btn_t1Constraints"  style="width:95px">Constraints</button></td>
					              </tr>
					              <tr>
					                <td>&nbsp;<input type="checkbox" onclick="waitChecked()" name="bb_cgo_flg" value="Y" ></td>
					                <td><button type="button" class="btn_etc mar_rgt_none" name="btn_t1BreakBulk" id="btn_t1BreakBulk" style="width:110px">Break Bulk</button></td>
					                <th>Rail Bulk</th>
					                <td><script type="text/javascript" >ComComboObject('rail_blk_cd', 2, 35, 0, 0, 0)</script></td>
					                <th class="align_left"><input type="checkbox" name="fd_grd_flg" id="fd_grd_flg" value="Y"  ><label for="fd_grd_flg">Food Grade</label></th>
					                <th colspan="4" class="align_left"><input type="checkbox" name="bkg_cgo_tp_cd" id="bkg_cgo_tp_cd" value="R" ><label for="bkg_cgo_tp_cd">Revenue Empty Container</label></th>
					              </tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<!-- Block 2ND :layout_wrap (E) -->
			  
		  
		
	
			<!-- Block 3RD :layout_wrap (S) -->
			<div class="layout_wrap">
				<div class="layout_flex_fixed" style="width:480px">
			  
			  				<div class="layout_wrap">
								<div class="layout_vertical_2 pad_rgt_8" style="width:255px;">
							          <div class="opus_design_inquiry sm" style="height:127px;">
							            <h3>Planned Delivery Schedule</h3>
							            <table class="grid_2" style="width:227px;"> 
											<tr><th width="120">M’ty DR Arrival Date</th>
												<td class="noinput"><input type="text" name="mty_dor_arr_dt" style="width:74px;" class="noinput margin_none" value=""  maxlength=10 dataformat="ymd"  tabindex=61><!-- 
							                   --><button type="button" class="calendar ir margin_none" name="btns_MtDorArrCalendar" id="btns_MtDorArrCalendar"></button></td></tr>
							              	<tr><th>Sailing Due Date</th>
							               		<td class="noinput"><input type="text" name="lodg_due_dt" style="width:74px;" class="input1 margin_none" value="" maxlength=10 dataformat="ymd"  tabindex=62><!-- 
							                   --><button type="button" class="calendar ir margin_none" name="btns_LodgDueCalendar" id="btns_LodgDueCalendar"></button></td></tr>
							              	<tr><th>Delivery Date</th>
							                	<td class="noinput"><input type="text" name="de_due_dt" style="width:74px;" class="noinput margin_none" value="" maxlength=10 dataformat="ymd"  tabindex=63><!-- 
							                   --><button type="button" class="calendar ir margin_none" name="btns_DeDueCalendar" id="btns_DeDueCalendar"></button></td></tr>
							            </table>
							          </div>
								</div>
							
							
								<div class="layout_vertical_2" style="width:225px;">
							          <div class="opus_design_inquiry sm" style="height:127px;">
							            <h3>Empty CNTR P/Up & RTN CY</h3>
							            <table class="grid_2" style="width:208px;"> 
							              <tr><th width="110">M'ty Pick up CY</th>
							                <td><input type="text" name="mty_pkup_yd_cd" style="width:74px;ime-mode:disabled;text-transform:uppercase;" data-eng="on;" class="noinput margin_none" value=""  maxlength=7   tabindex=64><!-- 
							                   --><button type="button" class="input_seach_btn margin_none" name="btn_0082Pop" id="btn_0082Pop"></button></td></tr>
							              <tr><th>M'ty Pick up DT</th>
							                <td><input type="text" name="mty_pkup_dt" style="width:74px;" class="noinput margin_none" value="" maxlength=10 dataformat="ymd"  tabindex=65><!-- 
							                   --><button type="button" class="calendar ir margin_none" name="btns_MtPickUpCalendar" id="btns_MtPickUpCalendar"></button></td></tr>
							              <tr><th>Full Return CY</th>
							                <td><input type="text" name="full_rtn_yd_cd" style="width:74px;ime-mode:disabled;text-transform:uppercase;" data-eng="on;" class="noinput margin_none" value="" maxlength=7  tabindex=66><!-- 
							                   --><button type="button" class="input_seach_btn margin_none" name="btn_0088Pop" id="btn_0088Pop"></button></td></tr>
							            </table>
							          </div>
								</div>
							</div>
				</div>
			
	
				<div class="layout_flex_flex" style="padding-left:488px">
							<!-- layout_wrap(s) -->
			  				<div class="layout_wrap">
								<div class="layout_flex_fixed" style="width:290px">
							          <div class="opus_design_inquiry sm" style="height:127px;">
							              <table> 
							                  <tr>
							                    <td><script type="text/javascript">ComTabObject('t1tab1', 'white', "100%")</script></td>
							                  </tr>
							                  <tr>
							                    <td>
							                      <div style="overflow:auto; height:85px;">
							                    <table id="t1tabLayer"  style="display:inline;">
							                      <tr>
							                        <th>Contact</th>
							                        <td><input type="text" name="bkg_cntc_pson_nm" style="width:190px;" value="" maxlength=50 tabindex=71></td>
							                      </tr>       
							                      <tr>
							                        <th>Tel.</th>
							                        <td><input type="text" name="bkg_cntc_pson_phn_no" style="width:190px;" value="" maxlength=30 tabindex=72 ></td>
							                      </tr>   
							                      <tr>
							                        <th>Fax</th>
							                        <td><input type="text" name="bkg_cntc_pson_fax_no" style="width:190px;" value="" maxlength=30 tabindex=75 ></td>
							                      </tr>   
							                      <tr>
							                        <th>E-mail</th>
							                        <td><input type="text" name="bkg_cntc_pson_eml" style="width:190px;" value="" maxlength=200 tabindex=73></td>
							                      </tr>   
							                      <tr>
							                        <th>Mobile</th>
							                        <td><input type="text" name="bkg_cntc_pson_mphn_no" style="width:190px;" value="" maxlength=30 tabindex=74></td>
							                      </tr>   
							                    </table>
							                    <table id="t1tabLayer" style="display:inline">
							                      <tr>
							                        <th>Contact</th>
							                        <td><input type="text" name="si_cntc_pson_nm" style="width:190px;" value="" maxlength=50 tabindex=76></td>
							                      </tr>       
							                      <tr><th>Tel.</th>
							                        <td><input type="text" name="si_cntc_pson_phn_no" style="width:190px;" value="" maxlength=30 tabindex=77 dataformat="num" ></td>
							                      </tr>   
							                      <tr><th>Fax</th>
							                        <td><input type="text" name="si_cntc_pson_fax_no" style="width:190px;" value="" maxlength=30 tabindex=80 dataformat="num" ></td>
							                      </tr>   
							                      <tr><th>E-mail</th>
							                        <td><input type="text" name="si_cntc_pson_eml" style="width:190px;" value="" maxlength=200 tabindex=78></td>
							                      </tr>   
							                      <tr><th>Mobile</th>
							                        <td><input type="text" name="si_cntc_pson_mphn_no" style="width:190px;" value="" maxlength=30 tabindex=79></td>
							                      </tr>   
							                    </table>
							                  </div>
							                </td>
							              </tr>           
							            </table>
									</div>
								</div>
							
								<div class="pad_left_8 layout_flex_fixed" style="width:190px">
							          <div class="opus_design_inquiry sm align_center" style="height:127px;">
							            <table style="margin:0 auto;"> 
							              <tr><td class="align_center"><button type="button" class="btn_etc" name="btn_t1SVCModeRoute" id="btn_t1SVCModeRoute" style="width:100%;">SVC Mode & Route</button></td></tr>
							              <tr><td class="align_center"><button type="button" class="btn_etc" name="btn_t1ReferenceNo" id="btn_t1ReferenceNo"   style="width:100%;">Reference No.</button></td></tr>
							              <tr><td class="align_center"><button type="button" class="btn_etc" name="btn_t1CargoClosingTime" id="btn_t1CargoClosingTime" style="width:100%;">Cut Off Time</button></td></tr>
							              <tr><td class="align_center"><button type="button" class="btn_etc" name="btn_t1RollOverInformation" id="btn_t1RollOverInformation" style="width:100%;">Roll Over Information</button></td></tr>
							            </table>
							          </div>
							    </div>
							
								<div class="layout_flex_flex" style="padding-left:488px">
									<div class="opus_design_inquiry sm" style="height:127px;">
										<table>
											<tr><th width="85">B.OFC</th>
												<td colspan="2"><input type="text" name="bkg_ofc_cd" style="width:70px;" class="input2" value="<%=strUsr_ofc %>" readonly></td></tr>
											<tr><th>Booking Staff</th>
												<td colspan="2"><input id="usr_nm" type="text" name="usr_nm" value="<%= strUsr_nm%>" style="width:170px;" class="input2" readonly></td></tr>
											<tr><th>BKG</th>
												<td width="75px"><input type="text" style="width: 70px;" name="xter_bkg_rqst_cd" class="input2" value="" readonly></td>
												<th width="65px;">VGM</th>
												<td width="100%"><input type="text" name="xter_vgm_rqst_cd" style="width:70px;" class="input2" value="" readonly></td>
											</tr>
											<tr><th>S/I</th>
												<td colspan="2"><input type="text" name="xter_si_cd" style="width:70px;" class="input2" value=" " readonly></td></tr>
										</table>
									</div>
							    </div>
							</div>
							<!-- layout_wrap(e) -->
				</div>
			</div>
			<!-- Block 3RD :layout_wrap (E) -->
				
				
			
			<!-- Block 4TH :layout_wrap (S) -->
		    <div class="opus_design_inquiry sm">
		      <table>
		        <tr>
		          <th width="50" class="align_left">Cust&nbsp;<button type="button" class="input_seach_btn" name="btn_0976Pop" id="btn_0976Pop" style="vertical-align:middle;margin-bottom:5px;"></button><br>Remark</th>
		          <td width="340"><textarea  name="xter_rmk" onBlur="javascript:getMakeBrCust();" style="width:320;height:50px;resize:none" tabindex=91></textarea></td>
		          <th width="50" class="align_left">Vndr&nbsp;<button type="button" class="input_seach_btn" name="btn_0976Pop" id="btn_0976Pop" style="vertical-align:middle;margin-bottom:5px;"></button><br>Remark</th>
		          <td width="340"><textarea  name="vndr_rmk"  onBlur="javascript:getMakeBrVndr();" style="width:320;height:50px;resize:none" tabindex=92></textarea></td>
		          <th width="50" class="align_left">Int&nbsp;<button type="button" class="input_seach_btn" name="btn_0976Pop" id="btn_0976Pop" style="vertical-align:middle;margin-bottom:5px;"></button><br>Remark</th>
		          <td width="340"><textarea  name="inter_rmk" style="width:320;height:50px;resize:none" tabindex=93></textarea></td>
		          <th class="align_left">Sharing&nbsp;<button type="button" class="input_seach_btn" name="btn_Trs0982Pop" id="btn_Trs0982Pop" style="vertical-align:middle;margin-bottom:5px;"></button><br>Remarks & Memos</th>
		        </tr>
		      </table>
		    </div>
			<!-- Block 4TH :layout_wrap (E) -->	
		</div>
</div>
<!-- wrap_result (E)  -->



<!-- <div id="msg" style="position:absolute; left:0; top:0; width:0; height:0;">1111111111111111</div> -->
<div id="orgBlNo" style="position:absolute;left:0;top:0;width:0;height:0;"></div>       
  <!-- Grid BG Box  (E) --> 
<!--TAB BKG Creation (E) -->
<input type="hidden" name="old_bkg_no" value="<%= bkgNo%>">
<input type="hidden" name="old_bl_no">
<input type="hidden" name="data_yn" value="N">
<input type="hidden" name="orgBlNo">
<input type="hidden" name="userInfo"  value="<%= strUsr_info%>">
<input type="hidden" name="save_mode_cd">
<!-- route -->
<input type="hidden" name="pctl_no" >
<input type="hidden" name="xter_bkg_rqst_ref_no" >
<input type="hidden" name="por_conti_cd">
<input type="hidden" name="del_conti_cd">
<input type="hidden" name="bkg_trunk_vvd_old">
<input type="hidden" name="por_cd_old">
<input type="hidden" name="por_yd_cd_old">
<input type="hidden" name="pol_cd_old">
<input type="hidden" name="pol_yd_cd_old">
<input type="hidden" name="pod_cd_old">
<input type="hidden" name="pod_yd_cd_old">
<input type="hidden" name="del_cd_old">
<input type="hidden" name="del_yd_cd_old">
<input type="hidden" name="rcv_term_cd_old">
<input type="hidden" name="de_term_cd_old">
<input type="hidden" name="mty_dor_arr_dt_old"> 
<input type="hidden" name="lodg_due_dt_old">
<input type="hidden" name="de_due_dt_old">
<input type="hidden" name="mty_pkup_yd_cd_old">
<input type="hidden" name="mty_pkup_dt_old">
<input type="hidden" name="full_rtn_yd_cd_old">
<input type="hidden" name="full_pkup_yd_cd">
<input type="hidden" name="mty_rtn_yd_cd">
<input type="hidden" name="org_sconti_cd">
<input type="hidden" name="dest_sconti_cd">
<input type="hidden" name="org_trns_svc_mod_cd">
<input type="hidden" name="dest_trns_svc_mod_cd">
<!-- customer -->
<input type="hidden" name="s_cust_cnt_cd_old"> 
<input type="hidden" name="s_cust_seq_old">
<input type="hidden" name="s_cust_subst_flg">
<input type="hidden" name="s_cust_exist_flg">
<input type="hidden" name="f_cust_cnt_cd_old">
<input type="hidden" name="f_cust_seq_old">
<input type="hidden" name="f_cust_subst_flg">
<input type="hidden" name="f_cust_exist_flg">
<input type="hidden" name="c_cust_cnt_cd_old">
<input type="hidden" name="c_cust_seq_old">
<input type="hidden" name="c_cust_subst_flg">
<input type="hidden" name="c_cust_exist_flg">
<input type="hidden" name="fmc_no">
<!-- CTRT -->
<input type="hidden" name="rfa_no_old">
<input type="hidden" name="rfaNoValid"> <!-- for CMDT PopUp -->
<input type="hidden" name="sc_no_old">
<input type="hidden" name="taa_no_old">
<input type="hidden" name="cmdt_cd_old">
<input type="hidden" name="rep_cmdt_cd">
<input type="hidden" name="premium_available_flg">
<input type="hidden" name="validPrecaution">
<input type="hidden" name="befUsaCstmsFileCd">
<!-- cargo -->
<input type="hidden" name="modify_cargo_flg">
<input type="hidden" name="dcgo_flg_old">
<input type="hidden" name="rc_flg_old">
<input type="hidden" name="awk_cgo_flg_old">
<input type="hidden" name="bb_cgo_flg_old">
<input type="hidden" name="allMotorLoc">
<input type="hidden" name="flexHeightLoc">
<input type="hidden" name="rd_cgo_flg"> <!-- changed if Saved -->
<input type="hidden" name="soc_flg"> <!-- changed if Saved -->
<input type="hidden" name="eq_subst_flg"> <!-- changed if Saved -->
<input type="hidden" name="dg_flg">
<input type="hidden" name="hcdg_flag">
<input type="hidden" name="rf_flg">
<input type="hidden" name="awk_flg">
<input type="hidden" name="bb_flg">
<input type="hidden" name="stwg_flg">
<input type="hidden" name="hngr_flg">
<input type="hidden" name="stop_off_flg">
<input type="hidden" name="blck_stwg_cd">

<!-- ESM-BKG_0090 Special Stowage Request -->
<input type="hidden" name="stwg_cd">
<input type="hidden" name="stwg_rmk">
<!-- ESM-BKG_0658 Stop Off Cargo Order-->
<input type="hidden" name="stop_off_loc_cd">
<input type="hidden" name="stop_off_cntc_phn_no">
<input type="hidden" name="stop_off_cntc_pson_nm">
<input type="hidden" name="stop_off_diff_rmk">
<!-- C/A Flag -->
<input type="hidden" name="ca_flg">
<input type="hidden" name="ca_user" >
<input type="hidden" name="ca_remark" >
<input type="hidden" name="ca_rsn_cd" >
<input type="hidden" name="ca_new_creation_flag" value="<%=caNewCreationFlag %>">

<input type="hidden" name="org_trns_mod_cd">
<input type="hidden" name="dest_trns_mod_cd">
<!-- Etc flag -->
<input type="hidden" name="cgo_dtl_auto_flg">
<input type="hidden" name="carge_detail_pop">
<input type="hidden" name="partial_vvd_assign_flg">
<input type="hidden" name="partial_vvd_opened_flg">
<input type="hidden" name="ctrt_modify_flag">
<input type="hidden" name="route_modify_flag">
<input type="hidden" name="qty_modify_flag">
<input type="hidden" name="customer_modify_flag">
<input type="hidden" name="contact_modify_flag">
<input type="hidden" name="close_bkg_flag">
<input type="hidden" name="mail_open_flag">
<input type="hidden" name="cbf_bkg_flag">
<input type="hidden" name="ib_modify_flag">
<input type="hidden" class="noinput" name="modify_flag">
<input type="hidden" name="have_route_flag">
<input type="hidden" name="psdo_bkg_flg">
<input type="hidden" name="pc_inq_flag">
<input type="hidden" name="tro_un_cfm_flag">
<input type="hidden" name="is_vl_flg">
<input type="hidden" name="cntr_flg">
<input type="hidden" name="usr_cnt_cd" value="<%=strUsr_cntCd %>">

<input type="hidden" name="split_rsn_cd">
<input type="hidden" name="adv_shtg_cd">

</form>
