<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0905.jsp
*@FileTitle  : TRO-Actual Customer
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
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event.EsmBkg0905Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0905Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message


	Logger log = Logger.getLogger("com.clt.apps.GeneralBookingConduct.TransferOrderIssue");
	
	try {

		event = (EsmBkg0905Event)request.getAttribute("Event");
		
		// If you imported data from the server initialization when loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="tro_act_cust_knd_cd" id="tro_act_cust_knd_cd" />
<input type="hidden" name="conti_cd" id="conti_cd" />
<input type="hidden" name="cnt_cd" id="cnt_cd" />
<input type="hidden" name="bkg_no" id="bkg_no" />
<input type="hidden" name="act_shpr_cnt_cd" id="act_shpr_cnt_cd" />
<input type="hidden" name="act_shpr_seq" id="act_shpr_seq" />
<input type="hidden" name="act_shpr_nm" id="act_shpr_nm" />
<input type="hidden" name="type" id="type" />
	<div class="page_title_area clear">
		<h2 class="page_title"><span>TRO Actual Customer</span></h2>
		<div class="opus_design_btn">
		 	<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		 	 --><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!-- 
		 	 --><button type="button" class="btn_normal" name="btn_Select" id="btn_Select">Select</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
	</div>

<div class="wrap_search_tab">
</div>
<div class="wrap_result">
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<div id="tabLayer" style="display:none">
		<div class="opus_design_inquiry" >
			<table>
			<colgroup>
                <col width="60" />
                <col width="150"  />
                <col width="150" />
                <col width="*"/>
            </colgroup>
				<tbody>
					<tr>
						<th>Customer</th>
						<td><input type="text" name="cust_cnt_cd" id="cust_cnt_cd" dataformat="enguponly" caption="Country Code"  class="input1" style="width:100%;" value="" fullfill style="ime-mode:disabled" maxlength="2"></td>
						<td><input type="text" name="cust_seq" id="cust_seq" caption="Customer Code" class="input"  style="width:100%;" value="" maxlength="6" dataformat="num"></td>
						<td><input type="text" name="cust_lgl_eng_nm" id="cust_lgl_eng_nm" dataformat="engup" caption="Customer Name" class="input"  style="width:300px;" value=""></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('t1sheet1');</script>
		</div>
		
		<div class="opus_design_grid">
			<div class="opus_design_btn">
			 	<button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_RowDelete" id="btn_RowDelete">Row Delete</button>
			</div>
			<script type="text/javascript">ComSheetObject('t1sheet2');</script>
		</div>
	</div>
	
	<!--TAB Customer Creation (S) -->
	<!-- 2015.01.19 By E/Q Office(U.S.A Region) 삭제
	<div id="tabLayer" style="display:none">
		<div class="opus_design_inquiry">
			<table>
			<colgroup>
                <col width="60">
                <col width="50">
                <col width="70">
                <col width="50">
                <col width="120">
                <col width="*">
            </colgroup>
				<tbody>
					<tr>
						<th>Door Location</th>
						<td><input type="text" name="dor_loc_cd" id="dor_loc_cd" maxlength="5" class="input2" style="width:60px"  readonly></td>
						<th>EQ Office</th>
						<td><input type="text" name="ofc_cd" id="ofc_cd" caption="EQ Office" dataformat="engup" maxlength="5" class="input1" style="width:60px"></td>
						<th>Customer Name</th>
						<td><input type="text" name="tro_act_rep_nm" id="tro_act_rep_nm"  dataformat="engup" caption="Customer Name" class="input1" style="width:240px;" otherchar=" &*-./" ></td>
					</tr>
				</tbody>
			</table>
		</div>
		
		<div class="opus_design_grid">
			<div class="opus_design_btn">
			 	<button type="button" class="btn_normal" name="btn_t2RowAdd1" id="btn_t2RowAdd1">Row Add</button> 
				<button type="button" class="btn_normal" name="btn_t2RowDelete1" id="btn_t2RowDelete1">Row Delete</button>
			</div>
			<script type="text/javascript">ComSheetObject('t2sheet1');</script>
		</div>
		
		<div class="opus_design_grid">
			<div class="opus_design_btn">
			 	<button type="button" class="btn_normal" name="btn_t2RowAdd2" id="btn_t2RowAdd2">Row Add</button> 
				 <button type="button" class="btn_normal" name="btn_t2RowDelete2" id="btn_t2RowDelete2">Row Delete</button>
			</div>
			<script type="text/javascript">ComSheetObject('t2sheet2');</script>
		</div>
	</div>
	 -->

		  <div class="opus_design_grid">
			<!-- 
			<script type="text/javascript">ComSheetObject('h1sheet1');</script>
			 -->
			<script type="text/javascript">ComSheetObject('h1sheet2');</script>
		</div>	
</div>
</form>


<SCRIPT type="text/javascript">
<!--
      /* 
        Form input values ​​except ibSheet (Information input by the user ->provide the screen to By event
      */
      with(document.form)
      {
        <%
        if(event != null){         	
        	String contiCd      = event.getContiCd();
            String cntCd        = event.getCntCd();
            String bkgNo        = event.getBkgNo();
            String actShprCntCd = event.getActShprCntCd();
            String actShprSeq   = event.getActShprSeq();
            String actShprNm    = event.getActShprNm();
            String type    = event.getType();
        %>    
	        eval("conti_cd").value        = "<%=contiCd%>";
	        eval("cnt_cd").value          = "<%=cntCd%>";
            eval("bkg_no").value          = "<%=bkgNo%>";
            eval("act_shpr_cnt_cd").value = "<%=actShprCntCd%>";
            eval("act_shpr_seq").value    = "<%=actShprSeq%>";
            eval("act_shpr_nm").value     = "<%=actShprNm%>";
            eval("type").value     = "<%=type%>";
        <% } %>
       }
-->
</SCRIPT>
