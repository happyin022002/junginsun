<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0072.jsp
*@FileTitle  : Damage Flagging/Unflagging 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event.EsdSce0072Event"%>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBCImpl" %>
<%@ page import="com.clt.framework.core.layer.event.EventResponse"%>

<%
	CodeUtilBC codeUtil = new CodeUtilBCImpl() ;
    EsdSce0072Event  event = null;                		//PDTO(Data Transfer Object including Parameters)
    //EsdSce0072EventResponse eventResponse = null;    	//RDTO(Data Transfer Object including DB ResultSet)
    EventResponse eventResponse = null;    	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException   = null;            			//error from server

	String strErrMsg = "";                                  //error message

	DBRowSet rowSet      = null;                            //DB ResultSet
	int rowCount     = 0;                                   //count of DB resultSET list
	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	String userId=account.getUsr_id();

	String sqlQuery = " select edi_grp_cd a, cust_trd_prnr_id b,edi_grp_desc c,edi_cgo_rmk d ";
	sqlQuery = sqlQuery + " from( select cust.edi_grp_cd , cust.cust_trd_prnr_id , cust.edi_grp_desc , cust.edi_cgo_rmk  ,sts.EDI_STND_STS_CD, sts.CUST_EDI_STS_CD ,ROWNUM RNUM from edi_usr_cust cust, edi_usr_sts sts ";
	sqlQuery = sqlQuery + " where cust.cre_usr_id = sts.cre_usr_id and cust.edi_grp_cd = sts.edi_grp_cd and cust.edi_sts_seq = sts.edi_sts_seq and cust.cre_usr_id = '"+userId+"' and cust.edi_sts_seq = 2 ";
	sqlQuery = sqlQuery + " ) group by edi_grp_cd, cust_trd_prnr_id,edi_grp_desc,edi_cgo_rmk	";

	try{
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if(serverException != null){
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} else {
			event = (EsdSce0072Event)request.getAttribute("Event");
            eventResponse = (EventResponse)request.getAttribute("EventResponse");
            if (eventResponse != null) {
                //rowSet = eventResponse.getRowSet();
                rowSet = eventResponse.getRs();
                if(rowSet != null){
                     rowCount = rowSet.getRowCount();
                } // end if
            } // end if
		}
	} catch(Exception e) {
        out.println(e.toString());
    }
%>

<script type="text/javascript">

	function setupPage(){
		loadPage();
		var formObject = document.form ;
	}

</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="cust_cd">
<input type="hidden" name="user_id" value=<%=userId%>>
<input type='hidden' name="podetadate1_hidden">
<input type='hidden' name="podetadate2_hidden">
<input type='hidden' name="poletddate1_hidden">
<input type='hidden' name="poletddate2_hidden">

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
<div class="wrap_search">
<div class="opus_design_inquiry">
	<div id="sch_cond_div" style=display:block;>
	<!--  MiniLayer (S) -->
	<table>
		<colgroup>
            <col width="110" />
            <col width="120" />
            <col width="30" />
            <col width="150" />
            <col width="30" />
            <col width="150" />
            <col width="30" />            
            <col width="150" />
            <col width="30" />
            <col width="" />
		</colgroup>
		<tbody>
			<tr>
				<th>Customer</th>
				<td colspan="8">
				<input type ='hidden' name=cs value="test"><!-- 
				 --><input class="input1" name="cs_grp_id" type="text"  class="input" style="width:80px; text-transform:uppercase;" value="" onfocusout="javascript:onObjectFocusout(this.form)"><!-- 
				 --><input class="input1" name="tp_id" type="text"  class="input" style="width:80px; text-transform:uppercase;" value="" onfocusout="javascript:onObjectTpId(this.form)"><!-- 
				 --><input class="input1" name="grp_nm" type="text"  class="input" style="width:650px; text-transform:uppercase;" value=""><!-- 
				 --><button type="button" class="input_seach_btn" onClick="openCustomer()"></button>
				</td>
				<td> </td>
			</tr>
			<tr>
				<th>EDI Status</th>
				<td colspan="9"><input name="edi_sts" type="text"  class="input" style="width:164px; text-transform:uppercase;" value="" ><!-- 
				 --><button type="button" class="input_seach_btn" onClick="openEDIsts()"></button>
				</td>
				<td > </td>
			</tr>
		</tbody>
	</table>
	<table>
		<colgroup>
            <col width="110" />
            <col width="170" />
            <col width="*" />
		</colgroup>
		<tbody>
			<tr>
				<th>My Performance</th>
				<td>							
					<div id="cSelection" >
						<select name='mycust' id='mycust' onChange=javascript:onValueChange('mycust',this.form) style='width:164px;'></select>
					</div>
				</td>
				<td>					
					<button type="button" class="btn_etc" name="btn_addedit" id="btn_addedit" onClick="openMyReport()">Add / Edit</button>
				</td>
			</tr>
			<tr>
				<td colspan="3"><table class="line_bluedot"><tr><td></td></tr></table></td>
			</tr>
			<tr>
				<td colspan="3">
					<input type = "radio" id="missOntime1" name = "missOntime" value = "M" class="trans" Checked><label for="missOntime1">Missing Performance</label><!-- 
					 --><input type = "radio" id="missOntime2" name = "missOntime" value = "O" class="trans"><label for="missOntime2">On-Time Performance</label>
				</td>
			</tr>			
			<tr>
				<td colspan="10"><table class="line_bluedot"><tr><td></td></tr></table></td>
			</tr>
		</tbody>
	</table>
	<table>
		<colgroup>
            <col width="110" />
            <col width="120" />
            <col width="180" />
            <col width="*" />
		</colgroup>
		<tbody>
			<tr>
				<th>Trans Mode</th>
				<td>
				<select name="trs_mode_" id="trs_mode_" class="input" style="width:113px;">
					<option value="A">ALL</option>
					<option value="Y">RAIL</option>
					<option value="N">NONRAIL</option>
				</select>
				</td>
				<th>COP Status.</th>
				<td>
				<select name="cop_status" id="cop_status" class="input" style="width:100px;">
					<option value="A">ALL</option>
					<option value="C">Closed</option>
					<option value="I">In-Transit</option>
				</select>
				</td>
			</tr>
		</tbody>
	</table>
	<table>
		<colgroup>
            <col width="110" />
            <col width="130" />
            <col width="30" />
            <col width="100" />
            <col width="30" />
            <col width="110" />
            <col width="30" />            
            <col width="110" />
            <col width="30" />
            <col width="*" />
		</colgroup>
		<tbody>
			<tr>
				<th title="Vessel Voyage Direction">VVD</th>
				<td><input name="vvd" id="vvd" type="text" Onkeydown="onEnterKey()" class="input" style="width:70px; text-transform:uppercase;"  value="" ><button type="button" class="input_seach_btn" onClick="openVVDList()"></button><!-- 
				 --><button type="button" class="btn_plus" onClick="openAddPaste('vvd')"></button></td>
				<th title="Place of Receipt">POR</th>
				<td><input name="por" id="por"  Onkeydown="onEnterKey()" type="text" class="input" style="width:70px; text-transform:uppercase;"  value=""><button type="button" class="input_seach_btn" onClick="openLocPop(false,'por')"></button></td>
				<th title="Port of Loading">POL</th>
				<td><input name="pol" id="pol" Onkeydown="onEnterKey()" type="text" class="input" style="width:70px; text-transform:uppercase;"  value=""><button type="button" class="input_seach_btn" onClick="openLocPop(false,'pol')"></button></td>
				<th title="Port of Discharging">POD</th>
				<td><input name="pod" id="pod"  Onkeydown="onEnterKey()" type="text" class="input" style="width:70px; text-transform:uppercase;"  value=""><button type="button" class="input_seach_btn" onClick="openLocPop(false,'pod')"></button></td>
				<th title="Place of Delivery">DEL</th>
				<td><input name="del" id="del" Onkeydown="onEnterKey()" type="text" class="input" style="width:70px; text-transform:uppercase;"  value=""><button type="button" class="input_seach_btn" onClick="openLocPop(false,'del')"></button></td>
			</tr>
			<tr>
				<td colspan="10"><table class="line_bluedot"><tr><td></td></tr></table></td>
			</tr>
			</tbody>
	</table>
	<table>
		<colgroup>
            <col width="110" />
            <col width="170" />
            <col width="110" />
            <col width="120" />
            <col width="90" />
            <col width="*" />
		</colgroup>
		<tbody>
			<tr>
				<th>T.VVD ETD</th>
				<td><input name = "poletddate1" id = "poletddate1" type="text" class="input" style="width:70px; text-transform:uppercase;" maxlength="10"  dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)"  >~&nbsp;<!-- 
					 --><input name = "poletddate2" id = "poletddate2" type="text" class="input" style="width:70px; text-transform:uppercase;" maxlength="10"  dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)"  ><!-- 
					 --><button type="button" class="calendar ir" onClick="openCalendar('1')"></button>
				</td>
				<th>T.VVD ETA</th>
				<td><input name ="podetadate1" id ="podetadate1" type"text" class="input" style="width:70px; text-transform:uppercase;" maxlength="10"  dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" ><!-- 
					 -->~&nbsp;<input name = "podetadate2" id = "podetadate2" type="text" class="input" style="width:70px; text-transform:uppercase;" maxlength="10"  dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" ><!-- 
					 --><button type="button" class="calendar ir" onClick="openCalendar('2')"></button>
				</td>
			</tr>
			<tr>
				<th>Booking NO.</th>
				<td ><input name="bkg_no" id="bkg_no" Onkeydown="onEnterKey()" type="text" class="input" style="width:120px; text-transform:uppercase;"  value=""><!-- 
				 --><button type="button" class="btn_plus" onClick="openAddPaste('bkg_no')"></button></td>
				<th>B/L NO.</th>
				<td>
				<input name="bl_no"  id="bl_no" Onkeydown="onEnterKey()" type="text" class="input" style="width:120px; text-transform:uppercase;"  value=""><!-- 
				 --><button type="button" class="btn_plus" onClick="openAddPaste('bl_no')"></button></td>					
				<th>CNTR NO.</th>
				<td><input name="cntr_no" id="cntr_no" Onkeydown="onEnterKey()" type="text" class="input" style="width:92px; text-transform:uppercase;"  value=""><!-- 
				 --><button type="button" class="btn_plus" onClick="openAddPaste('cntr_no')"></button></td>
			</tr>
		</tbody>
	</table>
	</div>
</div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
<div class="opus_design_grid">
    <script type="text/javascript">ComSheetObject('sheet');</script>
</div>
</div>
<!-- opus_design_grid(E) -->
<!-- page(E) -->

</form>