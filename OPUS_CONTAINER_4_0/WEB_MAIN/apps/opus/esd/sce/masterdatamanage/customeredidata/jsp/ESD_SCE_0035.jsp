<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0035.jsp
*@FileTitle  : Customer EDI Monitoring 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event.EsdSce0035Event"%>
<%@ page import="com.clt.framework.core.layer.event.EventResponse"%>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBCImpl" %>

<%
	CodeUtilBC codeUtil = new CodeUtilBCImpl() ;
    EsdSce0035Event  event = null;                			//PDTO(Data Transfer Object including Parameters)
    EventResponse eventResponse = null;
	Exception serverException   = null;            			//error from server

	String strErrMsg = "";                                  //error message
   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
   	String userId=account.getUsr_id();

	DBRowSet rowSet      = null;                            //DB ResultSet

	int rowCount     = 0;                                   //count of DB resultSET list

    try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
            event = (EsdSce0035Event)request.getAttribute("Event");
            eventResponse = (EventResponse)request.getAttribute("EventResponse");
            if (eventResponse != null) {
                rowSet = eventResponse.getRs();
                if(rowSet != null){
                     rowCount = rowSet.getRowCount();
                } // end if
            } // end if
        } // end else
    }catch(Exception e) {
        out.println(e.toString());
    }

%>
<script type="text/javascript">

    function setupPage(){
        loadPage();
    }

</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="dist1" value="" id="dist1" />
<input type="hidden" name="dist2" value="" id="dist2" />
<input type="hidden" name="tabno" value="" id="tabno" />

<input type="hidden" name="cop_no" value="" id="cop_no" />
<input type="hidden" name="bkg_no" value="" id="bkg_no" />
<input type="hidden" name="bkg_no_split" value="" id="bkg_no_split" />
<input type="hidden" name="cntr_no" value="" id="cntr_no" />
<input type="hidden" name="pgmNo" value="" id="pgmNo" />


<input type="hidden" name="podetadate1_hidden" id="podetadate1_hidden" />
<input type="hidden" name="podetadate2_hidden" id="podetadate2_hidden" />
<input type="hidden" name="poletddate1_hidden" id="poletddate1_hidden" />
<input type="hidden" name="poletddate2_hidden" id="poletddate2_hidden" />

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_cop" id="btn_cop">COP</button><!--
		--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_send" id="btn_send">Send</button><!--
		--><button type="button" class="btn_normal" name="btn_saveas" id="btn_saveas">Save As</button>
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

<!-- opus_design_inquiry(S) -->
<div class="wrap_search_tab">
<div class="opus_design_inquiry wFit">
	<!--  MiniLayer (S) -->
	<table>
		<colgroup>
            <col width="95" />
            <col width="323" />
            <col width="55" />
            <col width="279" />
            <col width="80" />
            <col width="" />
		</colgroup>
		<tbody>
			<tr>
				<th>Customer</th>
				<td colspan="10">
				<input class="input1" name="cs_grp_id" id="cs_grp_id" type="text"   style="width:80px; text-transform:uppercase;" value="" onfocusout="javascript:onObjectFocusout(this.form)"><!--
				--><input class="input1" name="tp_id" id="tp_id" type="text" style="width:80px; text-transform:uppercase;" value="" onfocusout="javascript:onObjectTpId(this.form)"><!--
				--><input class="input1" name="grp_nm" id="grp_nm" type="text" style="width:671px; text-transform:uppercase;" value=""><!--
				--><button type="button" class="input_seach_btn" onClick="openCustomer()"></button>
			</tr>
			<tr>
				<th>My Customer</th>
				<td>
					<%=codeUtil.searchCodeCombo("mycust"," ( select edi_grp_cd a, cust_trd_prnr_id b, edi_grp_desc c from edi_usr_cust where cre_usr_id = '"+userId+"' and edi_sts_seq = '1')   "
				        ," a||'%'||b||'%'||c  "
				        ," a ||' | '||b||' | '|| c temp ","a"," onChange=javascript:onValueChange('mycust',this.form) style=\"width:839;\"","1:: ")%>
				</td>
			</tr>
			<tr>
				<th>Booking NO.</th>
				<td><input name="bkg_no_" id="bkg_no_" Onkeydown="onEnterKey()" type="text" class="input" style="width:102px; text-transform:uppercase;"  value=""><!--
				--><button type="button" class="btn_plus" onClick="openAddPaste('bkg_no_')"></button></td>
				<th>B/L NO.</th>
				<td><input name="bl_no_" id="bl_no_" Onkeydown="onEnterKey()" type="text" class="input" style="width:102px; text-transform:uppercase;"  value=""><!-- 
				--><button type="button" class="btn_plus" onClick="openAddPaste('bl_no_')"></button></td>
				<th>CNTR NO.</th>
				<td><input name="cntr_no_" id="cntr_no_" Onkeydown="onEnterKey()" type="text" class="input" style="width:102px; text-transform:uppercase;"  value=""><!--
				--><button type="button" class="btn_plus" onClick="openAddPaste('cntr_no_')"></button></td>
			</tr>
			<tr>
				<th>TRANS Mode.</th>
				<td>
				<select name="trs_mode_" id="trs_mode_" class="input" style="width:102px;">
					<option value="A">ALL</option>
					<option value="Y">RAIL</option>
					<option value="N">NONRAIL</option>
				</select>
				</td>
				<th>EDI STS</th>
				<td><input name="edi_sts" id="edi_sts" Onkeydown="onEnterKey()" type="text" class="input" style="width:102px; text-transform:uppercase;"  value=""><!--
				--><button type="button" class="input_seach_btn" onClick="openEdiStsList()"></button></td>
				<th>COP Status.</th>
				<td><select name="cop_status" id="cop_status" class="input" style="width:102px;">
					<option value="A">ALL</option>
					<option value="C">Closed</option>
					<option value="I">In-Transit</option>
					</select></td>
			</tr>
			<tr>
				<th title="Vessel Voyage Direction">VVD</th>
				<td><input name="vvd" id="vvd" type="text" Onkeydown="onEnterKey()" class="input" style="width:72px; text-transform:uppercase;"  value=""><button type="button" class="input_seach_btn" onClick="openVVDList()"></button><button type="button" class="btn_plus" onClick="openAddPaste('vvd')"></button></td>
				<th title="Place of Receipt">POR</th>
				<td><input name="por" id="por" Onkeydown="onEnterKey()" type="text" class="input" style="width:73px; text-transform:uppercase;"  value=""><button type="button" class="input_seach_btn" onClick="openLocPop(false,'por')"></button></td>
				<th title="Port of Loading">POL</th>
				<td><input name="pol" id="pol" Onkeydown="onEnterKey()" type="text" class="input" style="width:73px; text-transform:uppercase;"  value=""><button type="button" class="input_seach_btn" onClick="openLocPop(false,'pol')"></button></td>
				<th title="Port of Discharging">POD</th>
				<td><input name="pod" id="pod" Onkeydown="onEnterKey()" type="text" class="input" style="width:70px; text-transform:uppercase;"  value=""><button type="button" class="input_seach_btn" onClick="openLocPop(false,'pod')"></button></td>
				<th title="Place of Delivery">DEL</th>
				<td><input name="del" id="del" Onkeydown="onEnterKey()" type="text" class="input" style="width:70px; text-transform:uppercase;"  value=""><button type="button" class="input_seach_btn" onClick="openLocPop(false,'del')"></button>
				</td>
			</tr>
			<tr>
				<th>T.VVD ETD</th>
				<td><input name="poletdDate1" id="poletdDate1" type="text" class="input" style="width:70px; text-transform:uppercase;" onKeyUp="chkField(this, 'date', false, null, null, '-')" onBlur="chkField(this, 'date', false, null, null, '-')"><!--
				-->~ <!--
				--><input name = "poletdDate2" id = "poletdDate2" type="text" class="input" style="width:70px; text-transform:uppercase;" onKeyUp="chkField(this, 'date', false, null, null, '-')" onBlur="chkField(this, 'date', false, null, null, '-')"><!--
				--><button type="button" class="calendar ir" onClick="openCalendar('1')"></button></td>
				<th>T.VVD ETA</th>
				<td><input name = "podetaDate1" id = "podetaDate1" type="text" class="input" style="width:70px; text-transform:uppercase;" onKeyUp="chkField(this, 'date', false, null, null, '-')" onBlur="chkField(this, 'date', false, null, null, '-')"><!--
				-->~ <!--
				--><input name = "podetaDate2" id = "podetaDate2" type="text" class="input" style="width:70px; text-transform:uppercase;" onKeyUp="chkField(this, 'date', false, null, null, '-')" onBlur="chkField(this, 'date', false, null, null, '-')"><!--
				--><button type="button" class="calendar ir" onClick="openCalendar('2')"></button></td>
			</tr>
		</tbody>
	</table>
	<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
</div>
<!-- opus_design_inquiry(E) -->

<div class="wrap_result">
<!-- opus_tab_btn(S) -->
<div class="opus_design_tab">
	<div style="display:none;"><input name="ckCount" id="ckCount" type="text" style="width:30px;" readonly> rows selected</div>
	<script type="text/javascript">ComTabObject('tab1')</script>
</div>
<!-- opus_tab_btn(E) -->

<!--TAB Summary Report (S) -->
<div class="opus_design_grid" name="tabLayer" id="tabLayer">
	<script type="text/javascript">ComSheetObject('t0sheet');</script>
</div>
<!--TAB Summary Report (E) -->

<!--TAB Detail Report-COP (S) -->
<div class="opus_design_grid" name="tabLayer" id="tabLayer">
	<script type="text/javascript">ComSheetObject('t1sheet');</script>
</div>
<!--TAB Detail Report-COP (E) -->

<!--TAB Detail Report-Others (S) -->
<div class="opus_design_grid" name="tabLayer" id="tabLayer" style="display:none">
	<script type="text/javascript">ComSheetObject('t2sheet');</script>
</div>
<!--TAB Detail Report-Others (E) -->
</div>
<!-- page(E) -->

</form>