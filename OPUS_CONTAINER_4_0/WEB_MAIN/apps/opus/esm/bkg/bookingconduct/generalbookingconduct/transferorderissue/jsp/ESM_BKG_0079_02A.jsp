<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0079_02A.jsp
*@FileTitle  : TRO(Transportation Request Order) for Inland Haulage
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
<%@ page import="com.clt.framework.core.view.template.Screen"%>
<%@ page import="com.clt.framework.core.controller.util.WebKeys"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event.EsmBkg007902aEvent"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg007902aEvent  event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	
    String bkgNo = "";	
	Logger log = Logger.getLogger("com.clt.apps.GeneralBookingConduct.TransferOrderIssue");
	String isInquiry = "N";	
	Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
	//inquiry mode
	if (screen.getName().indexOf("Q") >= 0){
		isInquiry = "Y";
	} else {
		isInquiry = "N";			
	}
	try {

		event = (EsmBkg007902aEvent)request.getAttribute("Event");	
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		if (event != null) {
		    bkgNo = event.getBkgNo();
		}
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<style type="text/css">
	.mar_top_6 {margin-top:6px!important} 
</style>

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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="io_bnd_cd"         value="O">
<input type="hidden" name="rtn_tro_flg"       value="N">
<input type="hidden" name="conti_cd"          value="">
<input type="hidden" name="oldBkgNo"          value="">
<input type="hidden" name="oldBlNo"           value="">
<input type="hidden" name="pcInqFlag"         value="N">
<input type="hidden" name="routeModifyFlag"   value="N">
<input type="hidden" name="curr_tro_seq"      value="">
<input type="hidden" name="ca_flg"            value="">
<input type="hidden" name="f_del_flg"          value="">
<input type="hidden" name="cfm_flg_old"        value="N">
<input type="hidden" name="cxl_flg_old"        value="N">
<input type="hidden" name="max_tro_seq_old"    value="0">
<input type="hidden" name="so_no_flg"          value="N">
<input type="hidden" name="cfm_sys_date"       value="">


<input type="hidden" name="por_nod_cd"         value="">
<input type="hidden" name="pickup_cy1"         value="">
<input type="hidden" name="pickup_cy2"         value="">
<input type="hidden" name="pkup_dt"            value="">
<input type="hidden" name="pkup_dt_hhmi"       value="">
<input type="hidden" name="dor_arr_dt"         value="">
<input type="hidden" name="dor_arr_dt_hhmi"    value="">
<input type="hidden" name="cmdt_nm"            value="">
<input type="hidden" name="etb_dt"             value="">
<input type="hidden" name="fd_grd_flg"         value="">
<input type="hidden" name="spcl_hide_flg"      value="">
<input type="hidden" name="so_flg"         value="">
<input type="hidden" name="ownr_trk_flg"   value="">
<input type="hidden" name="biz_rgst_no"    value="">
<input type="hidden" name="cntc_mphn_no"   value="">
<input type="hidden" name="ack_sts_cd"     value="">
<input type="hidden" class="noinput" name="modify_flag" value="N">
<input type="hidden" name="isInquiry" value="<%=isInquiry%>">


<!-- opus_design_btn(S) -->
<div class="opus_design_btn opus_design_normal2">
	<button type="button" class="btn_normal2" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
--><button type="button" class="btn_normal2" name="btn_t2aSave" id="btn_t2aSave">Save All</button><!--
--><button type="button" class="btn_normal2" name="btn_t2aSaveSeq" id="btn_t2aSaveSeq">Save</button><!--
--><button type="button" class="btn_normal2" name="btn_t2aCancelAll" id="btn_t2aCancelAll">Cancel All</button><!--
--><button type="button" class="btn_normal2" name="btn_t2aTROCopy" id="btn_t2aTROCopy">TRO Copy</button><!--
--><button type="button" class="btn_normal2" name="btn_t2aAddSeq" id="btn_t2aAddSeq">Add Seq.</button><!--
--><button type="button" class="btn_normal2" name="btn_t2aCopySeq" id="btn_t2aCopySeq">Copy Seq.</button><!--
--><button type="button" class="btn_normal2" name="btn_t2aCancelSeq" id="btn_t2aCancelSeq">Cancel Seq.</button>
</div>
<!-- opus_design_btn(E) -->


<!-- wrap_search (S) -->
<div class="wrap_search coupled_btn_normal2">
	<div class="opus_design_inquiry wFit"> 
		<table> 
			<colgroup>			
				<col width="55" />			
				<col />				
		   </colgroup> 
			<tbody>
				<tr>
					<th>BKG No.</th>
					<td>
						<input type="text" name="bkg_no" style="width:104px;" value="<%=bkgNo%>" class="input" maxlength="13" dataformat="engup" tabindex="1" id="bkg_no" /><!--
						--><button type="button" class="btn_down_list" id="btn_splitPop" name="btn_splitPop"></button>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- wrap_search (E) -->
		
		
		
<!-- wrap_result (S) -->
<div class="wrap_result coupled_btn_normal2">

	<!-- opus_design_inquiry(S) - (1st) -->
	<div class="opus_design_inquiry">
		<div class="layout_wrap" style="height:125px">
			<div class="layout_flex_fixed floatL" style="width:655px;margin-top:18px;">
				<table>
					<colgroup>			
						<col width="55" />
						<col width="155" />
						<col width="45" />
						<col width="220" />	
						<col width="79" />				
						<col />				
				   </colgroup> 
				   <tbody>
				   		<tr>
							<th>B/L No.</th>
							<td><input type="text" name="bl_no" style="width:104px;" value="" class="input" maxlength="13" dataformat="engup" tabindex="2" id="bl_no" /></td>
							<th>Status</th>
							<td><input type="text" name="bkg_sts_cd" style="width:32px;" value="" class="input2" readonly tabindex="-1" id="bkg_sts_cd" /></td>
							<th>Commodity</th>
							<td><input type="text" name="cmdt_cd" id="cmdt_cd" style="width:94px;" value="" class="input2" readonly onMouseOver="drs(document.form.cmdt_nm.value); return true;" onMouseOut="nd(); return true;" tabindex=-1></td>
				   		</tr>
						<tr>
							<th>T/VVD</th>
							<td><input type="text" name="vsl_cd" style="width:50px;" value="" class="input2" readonly tabindex="-1" id="vsl_cd" /><!--
							--><input type="text" name="skd_voy_no" style="width:50px;" value="" class="input2" readonly tabindex="-1" id="skd_voy_no" /><!--
							--><input type="text" name="skd_dir_cd" style="width:36px;" value="" class="input2" readonly tabindex="-1" id="skd_dir_cd" />
							</td>
							<th>Route</th>
							<td><input type="text" name="por_cd" style="width:50px;" value="" class="input2" readonly tabindex="-1" id="por_cd" /><!--
							--><input type="text" name="pol_code" style="width:50px;" value="" class="input2" readonly tabindex="-1" id="pol_code" /><!--
							--><input type="text" name="pod_cd" style="width:50px;" value="" class="input2" readonly tabindex="-1" id="pod_cd" /><!--
							--><input type="text" name="del_cd" style="width:50px;" value="" class="input2" readonly tabindex="-1" id="del_cd" /></td>
							<th>Return CY</th>
							<td><input type="text" name="return_cy1" style="width:60px;" value="" class="input2" readonly tabindex=-1><!--
							--><input type="text" name="return_cy2" style="width:30px;" value="" class="input2" readonly tabindex=-1>
							 </td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="90" />
						<col width="90" />
						<col width="100" />
						<col width="110" />
						<col width="110" />
						<col width="120" />
						<col />
					</colgroup>
					<tbody>
						<tr>
							<td><input type="checkbox" name="dcgo_flg" class="trans mar_top_6" disabled tabindex="-1" id="dcgo_flg" /><!--
							--><button class="btn_etc mar_left_4" name="btn_Danger" id="btn_Danger" type="button">Danger</button></td>
							<td><input type="checkbox" name="rc_flag" class="trans mar_top_6" disabled id="rc_flag" /><!--
							--><button class="btn_etc mar_left_4" name="btn_Reefer" id="btn_Reefer" type="button">Reefer</button></td>
							<td><input type="checkbox" name="awk_cgo_flg" class="trans mar_top_6" disabled tabindex="-1" id="awk_cgo_flg" /><!--
							--><button class="btn_etc mar_left_4" name="btn_Awkward" id="btn_Awkward" type="button">Awkward</button></td>
							<td><input type="checkbox" name="bb_cgo_flg" class="trans mar_top_6" disabled tabindex="-1" id="bb_cgo_flg" /><!--
							--><button class="btn_etc mar_left_4" name="btn_Bulk" id="btn_Bulk" type="button">Break Bulk</button></td>
							<td><input type="checkbox" name="rd_cgo_flg" class="trans mar_top_6" disabled tabindex="-1" id="rd_cgo_flg" /><!--
							--><button class="btn_etc mar_left_4" name="btn_RDry" id="btn_RDry" type="button">Reefer/Dry</button></td>
							<th>Receiving Term</th>
							<td><input type="text" name="term" style="width:30px;" class="input2" readonly tabindex="-1" id="term" /></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="55" />
						<col />
					</colgroup>
					<tbody>
						<tr>
							<th>Shipper</th>
							<td><input type="text" name="cust_cnt_cd" style="width:30px;" value="" class="input2" readonly tabindex="-1" id="cust_cnt_cd" /><!--
							--><input type="text" name="cust_seq" style="width:70px;" value="" class="input2" readonly tabindex="-1" id="cust_seq" /><!--
							--><input type="text" name="cust_nm" style="width:486px;" value="" class="input2" readonly tabindex="-1" id="cust_nm" /></td>
						</tr>
					</tbody>
				</table>	
			</div>			
			<div class="layout_flex_flex" style="padding-left:663px">
				<h3 class="title_design mar_btm_4">Total Volume</h3>
				<div class="opus_design_grid">
					<script type="text/javascript">ComSheetObject('t2asheet5');</script>
				</div>
			</div>			
		</div>
	</div>
	<!-- opus_design_inquiry(E) - (1st) -->
	
	<table class="line_bluedot"><tr><td></td></tr></table>

	<!-- opus_design_inquiry(S) - (2nd) -->
	<div class="opus_design_inquiry mar_btm_none wFit">
		<table>
			<colgroup>
				<col width="100">				
				<col width="110">				
				<col width="80">				
				<col width="50">				
				<col width="90">				
				<col width="150">				
				<col width="90">				
				<col width="130">				
				<col width="60">				
				<col width="80">				
				<col width="65">				
				<col >				
		   </colgroup>
		   <tbody>
		   		<tr>
		   			<th>Seq.</th>
					<td><script type="text/javascript">ComComboObject('tro_seq', 1, 46, 1);</script><!--
					--><input type="text" name="tro_seq_maxcnt" id="tro_seq_maxcnt" style="width:30px;" class="input2" readonly tabindex=-1>
					</td>
					<th>RCV Term</th>
					<td><input type="text" name="rcv_term_cd" id="rcv_term_cd" style="width:30px;" class="input2" readonly tabindex=-1></td>
					<th>Request Date</th>
					<td><input type="text" name="rqst_dt" id="rqst_dt" style="width:130px;" class="input2" readonly tabindex=-1></td>
					<th>D/G Seq.</th>
					<td><script type="text/javascript">ComComboObject('dcgo_seq', 2, 70, 1);</script></td>
					<th>R/F Seq.</th>
					<td><script type="text/javascript">ComComboObject('rc_seq', 2, 70, 1);</script></td>
					<th>A/K Seq.</th>
					<td><script type="text/javascript">ComComboObject('awk_cgo_seq', 1, 70, 1);</script></td>
		   		</tr>
		   		<tr>
		   			<th>Actual Customer</th>
					<td colspan="6"><!--
					--><input type="text" name="act_shpr_cnt_cd" id="act_shpr_cnt_cd" style="width:46px;"  class="input" maxlength="2"   dataformat="enguponly" tabindex=10><!--
					--><input type="text" name="act_shpr_seq"   id="act_shpr_seq"   style="width:60px;"  class="input" maxlength="6"   dataformat="num" tabindex=12><!--
					--><input type="text" name="act_shpr_nm"  id="act_shpr_nm"     style="width:433px;" class="input1 input_search" maxlength="500" data-eng="on"  tabindex=14><!--
					--><button type="button" class="input_seach_btn" name="btns_popActCust" id="btns_popActCust"></button><!--
					--></td>
					<td></td>
					<th><label for="drp_and_pk_flg">Drop and Pick</label></th>
					<td><input type="checkbox" name="drp_and_pk_flg" class="trans" id="drp_and_pk_flg" tabindex=16></td>
					<th><label for="tri_axl_req_flg">Tri-axle required</label></th>
					<td><input type="checkbox" name="tri_axl_req_flg" class="trans" id="tri_axl_req_flg" tabindex=18></td>
		   		</tr>
		   		<tr>
		   			<th>Location</th>
					<td><input type="text" name="dor_loc_cd"  id="dor_loc_cd" caption="Locaction Code" style="width:110px;" class="input1" maxlength="5" dataformat="enguponly" fullfill tabindex=20><!--
					--><input type="text" name="zn_cd"  id="zn_cd"  style="width:30px;" class="input1 input_search" maxlength="2" tabindex=22><!--
					--><button type="button" class="input_seach_btn" name="btns_popLocation" id="btns_popLocation"></button>
					</td>
					<th>Zip</th>
					<td><input type="text" name="dor_pst_no" id="dor_pst_no" style="width:60px;ime-mode:disabled;text-transform:uppercase;" class="input" caption="Zip" maxlength="12" data-eng="on"  otherchar=" &*-,./" tabindex=24></td>
					<th><label for="exID01">Confirm</label></th>
					<td><input type="checkbox" name="cfm_flg" class="trans" id="exID01" tabindex=26></td>
					<th>Confirm Date</th>
					<td><input type="text" name="cfm_dt"  id="cfm_dt" style="width:120px;" class="input2" readonly tabindex=-1></td>
					<th><label for="exID02">Cancel</label></th>
					<td><input type="checkbox" name="cxl_flg"  id="cxl_flg" class="trans" id="exID02" disabled=true tabindex=-1></td>
					<td></td>
					<td></td>
		   		</tr>
		   		<tr>
		   			<th>Address</th>
					<td colspan="9"><input type="text" name="act_shpr_addr"  id="act_shpr_addr" style="width:99.2%;" class="input" maxlength="500" tabindex=28></td>
					<th>Contact</th>
					<td><input type="text" name="cntc_pson_nm" id="cntc_pson_nm" style="width:100%;" class="input" maxlength="50" dataformat="eng"  otherchar="<%=getSpecialChars() %>" tabindex=30></td>
		   		</tr>
		   		<tr>
		   			<th rowspan="2">Remark(s)</th>
					<td colspan="9" rowspan="2" class="pad_btm_none"><textarea name="diff_rmk" id="diff_rmk" style="width:99.2%; height:54px; resize:none" maxlength="1000" tabindex=32></textarea>
					</td>
					<th>Tel.</th>
					<td><input type="text" name="cntc_phn_no" id="cntc_phn_no"  style="width:100%;" class="input" maxlength="20" dataformat="num" otherchar=" -" tabindex=34></td>
		   		</tr>
		   		<tr>
		   			<th>Fax</th>
					<td><input type="text" name="cntc_fax_no" id="cntc_fax_no"  style="width:100%;" class="input" maxlength="20" dataformat="num" otherchar=" -" tabindex=36></td>
		   		</tr>
		   </tbody>
		</table>
		<div class="layout_flex_fixed floatR" style="width:500px">
			
		</div>
		<div class="layout_flex_flex" style="padding-right:508px">
			
		</div>
	</div>
	<!-- opus_design_inquiry(E) - (2nd) -->

	<table class="line_bluedot"><tr><td></td></tr></table>


	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_button(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_t2aAdd" id="btn_t2aAdd">Row Add</button><!--
		--><button type="button" class="btn_normal" name="btn_t2aDelete" id="btn_t2aDelete">Row Delete</button><!--
		--><button type="button" class="btn_normal" name="btn_t2aCopy" id="btn_t2aCopy">Row Copy</button><!--
		--><input type="text" name="tro_copy_cnt" style="width:30px;" class="mar_left_8 mar_rgt_none" maxlength="2" dataformat="num">
		</div>
		<!-- opus_design_button(E) -->
		<script type="text/javascript">ComSheetObject('t2asheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->	
	
	
</div>
<!-- wrap_result (S) -->





<!-- hidden grid : Start ---------------------->
<div class="opus_design_grid" style="display:none">
	<!-- booking header / master all : hidden -->
	<script type="text/javascript">ComSheetObject('t2asheet2');</script>
	<!-- detail all : hidden -->	
	<script type="text/javascript">ComSheetObject('t2asheet3');</script>
	<!-- tro_dg_seq all : hidden -->
	<script type="text/javascript">ComSheetObject('t2asheet4');</script>
	
	<script type="text/javascript">ComSheetObject('t2amsgsheet1');</script>
</div>
<!-- hidden grid : End ------------------------>	




<div id="layList" name="layList" style="position:absolute;z-index:999;display:none" CELLPADDING=5 CELLSPACING=0 BORDER=0/></div>
<IFRAME id="ifrm" name="ifrm" src="apps/opus/esm/bkg/bookingcommon/bookingutil/jsp/esm_booking_split_no.html"  frameborder=0 marginHeight=0 marginWidth=0 width=115 height=82  style="position:absolute;border:1 #e9e9e9 solid" CELLSPACING=0 scrolling="no"></IFRAME>
<!--20090526 도움말용------------->
<DIV ID='overDiv' STYLE='position:absolute; z-index:90; width:350; visibility:hidden' tabindex=-1>
</DIV>
<!------------------------------->

<script type="text/javascript">
	//---------------------------->
	  var x = 0;
	  var y = 0;
	  var snow = 0;
	  var sw = 0;
	  var cnt = 0;
	  var dir = 1;
	  var offsetx = -150; //3;
	  var offsety = 10; //-20;
	  var width  = 50;
	  var height = 70;
	
	  over = overDiv.style;
	  document.onmousemove = mouseMove;
	
	  function drs(text, title) { dts(1,text); }
	
	  function nd() {
	    if ( cnt >= 1 ) { sw = 0 };
	    if ( sw == 0 ) { snow = 0; hideObject(over); }
	    else { cnt++; }
	  }
	
	  function dts(d,text) {
		if (text=="")
		{
	        return false;
		}
	    txt = "<TABLE WIDTH=200 STYLE=\"border:1 #e9e9e9 solid\" CELLPADDING=5 CELLSPACING=0 BORDER=0><TR><TD BGCOLOR=#ffffff><font STYLE=\"font-size:11px;color:#333399\">"+text+"</font></TD></TR></TABLE>"; 
	    layerWrite(txt);
	    dir = d;
	    disp();
	  }
	
	  function disp() {
	    if (snow == 0) {
	      if (dir == 2) { moveTo(over,x+offsetx-(width/2),y+offsety); } // Center
	      if (dir == 1) { moveTo(over,x+offsetx,y+offsety); }           // Right
	      if (dir == 0) { moveTo(over,x-offsetx-width,y+offsety); }     // Left
	      showObject(over);
	      snow = 1;
	    }
	  }
	
	  function mouseMove(e) {
	    x=event.x + document.body.scrollLeft+10
	    y=event.y + document.body.scrollTop
	    if (x+width-document.body.scrollLeft > document.body.clientWidth)  x=x-width-25;
	    if (y+height-document.body.scrollTop > document.body.clientHeight) y=y-height;
	
	    if (snow) {
	      if (dir == 2) { moveTo(over,x+offsetx-(width/2),y+offsety); } // Center
	      if (dir == 1) { moveTo(over,x+offsetx,y+offsety); }           // Right
	      if (dir == 0) { moveTo(over,x-offsetx-width,y+offsety); }     // Left
	    }
	  }
	
	  function cClick() { hideObject(over); sw=0; }
	  function layerWrite(txt) { document.all["overDiv"].innerHTML = txt }
	  function showObject(obj) { obj.visibility = "visible" }
	  function hideObject(obj) { obj.visibility = "hidden" }
	  function moveTo(obj,xL,yL) { obj.left = xL; obj.top = yL; }
	//<-------------------------------
</script>		
	


</form>

<SCRIPT type="text/javascript">
<!--
      with(document.form)
      {
        <%
          if(event != null) 
          {
              String currTroSeq = event.getCurrTroSeq();
              if (bkgNo.length() > 0) {
        %>
                  eval("curr_tro_seq").value = nullToBlank("<%=currTroSeq%>");
        <% 
              } 
          } 
        %>
      }
-->
</SCRIPT>

<%!

	public String getSpecialChars() {
		return " ~!@#$%^&*()`_+-={}|[]\\\"\\':;,./?"; 
	}
		
%>