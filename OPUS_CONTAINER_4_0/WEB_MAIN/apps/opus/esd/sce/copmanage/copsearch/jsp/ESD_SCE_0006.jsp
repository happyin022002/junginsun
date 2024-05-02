﻿﻿<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved..
*@FileName   : ESD_SCE_0006.jsp
*@FileTitle  :  COP Detail Search
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/22
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.controller.html.FormCommand"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.copmanage.copsearch.event.EsdSce0006Event"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.COPDetailVO"%>
<%@ page import="com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.SearchSceCopHdrInfoVO"%>
       
<%
	EsdSce0006Event event				= null;
	GeneralEventResponse eventResponse  = null;
	Exception serverException 			= null;
	String strErrMsg       				= "";
	int rowCount         				= 0;

    //SEARCHLIST
	List<SearchSceCopHdrInfoVO> bookingList = null;	
	String cop_no       = "" ;
	String bkg_no       = "" ;
	String cntr_no      = "" ;
	String cop_sts      = "" ;
	String cntr_no_v    = "";
	String cop_mst_bkg	= "";
	String tpszCd		= "";
	Map map = null;
	COPDetailVO inqVO = null;

	int    command      = -1 ;

	try {
		event   = (EsdSce0006Event)request.getAttribute("Event");
		command      = event.getFormCommand().getCommand() ;
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        } else {
			eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
					
			bookingList  = (List<SearchSceCopHdrInfoVO>)eventResponse.getRsVoList();
			
			inqVO = event.getCOPDetailVO();
			if(inqVO != null){
				cop_no       = inqVO.getCopNo()==null?"":inqVO.getCopNo();
				bkg_no       = inqVO.getBkgNo();
				cntr_no      = inqVO.getCntrNo()==null?"":inqVO.getCntrNo();
				cop_sts      = inqVO.getCopSts();
				cop_mst_bkg	 = inqVO.getCopMstBkg();	
			}
		}
	} catch(Exception e) {
		out.println(e.toString());
    }
	
	cntr_no_v = cntr_no;
	if(!cntr_no.equals("") ) {
		if(cntr_no.substring(4).equals("0000000")){
			cntr_no_v = "";
		}
	}
%>
<script type="text/javascript">

    function setupPage(){
    	setCopValues(document.form.bkg_no_tmp);
	    loadPage();
<%		if(!cop_no.equals("")){ %>
			var formObject = document.form ;
			doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
	       	doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
	       	doActionIBSheet(sheetObjects[2],formObject,IBSEARCH);
			doActionIBSheet(sheetObjects[3],formObject,IBSEARCH_ASYNC03);
<%		} %>
    }

</script>

	<form name="form" id="form" method="post">
		<input type="hidden" name="f_cmd" id="f_cmd" />
		<input type="hidden" name="pgmNo" value="ESD_SCE_0006" id="pgmNo" />
		<input type="hidden" name="cop_grp_seq" id="cop_grp_seq" />
		<!-- <input type="hidden" name="cop_dtl_seq" id="cop_dtl_seq" /> -->
		<input type="hidden" name="bkg_no" id="bkg_no"  value="<%=bkg_no%>"/>
		<input type="hidden" name="cntr_no" value="<%=cntr_no_v%>" id="cntr_no" />
		<input type="hidden" name="estm_act_dt" id="estm_act_dt" />
		<input type="hidden" name="clickBtnNm" id="clickBtnNm" />
		<input type="hidden" name="cop_sts_cd" id="cop_sts_cd" />
		<input type="hidden" name="cop_sub_sts_cd" id="cop_sub_sts_cd" />
		<input type="hidden" name="act_cd" id="act_cd" />
		<%String mainPage = JSPUtil.getNull(request.getParameter("mainPage"));%>
		
<% if("false".equals(mainPage)){  %>
<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>COP Detail</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!--
				--><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
				--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
				--><button type="button" class="btn_normal" name="btn_bkginfo" id="btn_bkginfo">BKG Info</button><!--
				--><button type="button" class="btn_normal" name="btn_history" id="btn_history">COP History</button><!--
				--><button type="button" class="btn_normal" name="t1btng_save" id="t1btng_save">Save</button><!--
				--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
				--></div>
		<!-- opus_design_btn(E) -->
	</div>
</div>

<div class="layer_popup_contents">
<%}else{ %>
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
			<div class="opus_design_btn"><!--
			--><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
			--><button type="button" class="btn_normal" name="btn_copchange" id="btn_copchange">COP Change</button><!--
			--><button type="button" class="btn_normal" name="btn_manualReplan" id="btn_manualReplan">Manual Replan by BKG</button><!--
			--><button type="button" class="btn_normal" name="btn_bkginfo" id="btn_bkginfo">BKG Info</button><!--
			--><button type="button" class="btn_normal" name="btn_history" id="btn_history">COP History</button><!--
			--><button type="button" class="btn_normal" name="t1btng_save" id="t1btng_save">Save</button><!--
			--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
			--></div>
		<!-- opus_design_btn(E) -->
	
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
<%} %>
<!-- page_title_area(E) -->

<!-- wrap_search(S) -->
<div class="wrap_search_tab">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">

	<table>
		<colgroup>
				<col width="90">				
				<col width="110">				
				<col width="90">				
				<col width="135">				
				<col width="80">				
				<col width="120">				
				<col width="90">				
				<col width="90">				
				<col width="40">				
				<col width="*">				
		   </colgroup>
		<tr>
			<th>Container No. </th>
			<!-- <td width=""><input class="input1" name="cntr_no_v" type="text" style="width:100; text-transform:uppercase;" value="<%=JSPUtil.getNull(cntr_no_v)%>" maxlength="11" onKeyUp="this.value=this.value.toUpperCase();" onBlur='javascript:this.value=this.value.toUpperCase();'   ></td> -->
			<td><input class="input1" name="cntr_no_v" type="text" style="width:100px; text-transform:uppercase;" value="<%=JSPUtil.getNull(cntr_no_v)%>" onBlur="keyAction();this.value=ComGetMaskedValue(this, 'engup', '');" onChange="CheckDigit(this)"  Onkeydown="onEnterKey(this)" onKeyUp="CheckDigit(this)" ></td>							
			<th>Booking No. </th>
			<td>
			<select name="bkg_no_tmp" style="width:128px;" onChange="setCopValues(this)"  onClick='javascript:contents_cp();'>

<%		// booking 검색시
		if(command==FormCommand.SEARCHLIST){
			if(bookingList != null){
				for(int i=0; i<bookingList.size(); i++){
					SearchSceCopHdrInfoVO infoVO = (SearchSceCopHdrInfoVO)bookingList.get(i);
					if(infoVO == null){
						infoVO = new SearchSceCopHdrInfoVO();
						infoVO.setCopNo(cop_no);
						infoVO.setBkgNo(bkg_no);
						infoVO.setCntrNo(cntr_no);
						infoVO.setCopStsCd(cop_sts);
						//infoVO.setC.setCopMstBkg(inqVO.getCopMstBkg());
					}else{
						tpszCd = infoVO.getCntrTpszCd();
					}
%>
					<option value="<%=infoVO.getBkgNo()%>|<%=infoVO.getCopNo()%>|<%=infoVO.getCopStsCd()%>|<%=infoVO.getMstLclCd()%>" <%=i==0?" selected":""%>>
						<%=infoVO.getBkgNo()%></option>
<%					
				}
			}
		}
		// Setting onload.
		else{
			// Setting in case of COP Main Search
			if(!cntr_no.equals("")){
%>				<option value="<%=bkg_no%>|<%=cop_no%>|<%=cop_sts%>"><%=bkg_no%></option>
<%			}
			// Setting in case of left menu
			else{
%>				<option value=""></option>
<%			}
		}
%>
		</select> </td>
				<th>COP No.</th>
				<td>
					<input name="cop_no" type="text" value="" style="width:110px" readOnly>
					<input type="hidden" name="rpln_cop_no" id="rpln_cop_no">
				</td>
				<th>COP Status</th>
				<td><input name="cop_sts" type="text" value="" style="width:60px" readOnly></td>
				<th>Master </th>
				<td><input name="cop_mst_bkg" type="text" value="<%=cop_mst_bkg %>" style="width:15px" readOnly><input type="hidden" name="cntr_tpsz_cd" value="<%=tpszCd%>"></td>
				<!-- <td width="13%"><input name="cop_sts" type="text" value="" style="width:80" readOnly></td>-->
			</tr>
		</table>
</div>
<!-- opus_design_inquiry (E) -->
</div>
<!-- wrap_search(S) -->
<div class="wrap_search_tab">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
	<!-- layout_wrap(S) -->
	<div class="layout_wrap" style="width: 100%">
		<!-- layout_vertical_2(S) -->
		<div class="layout_vertical_2" >
			<h3 class="title_design">Delivery Time Info.</h3>
			<table class="grid_2">
				<tr>
					<th style="text-align:center;">Delivery Due Date </th>
					<th style="text-align:center;">O/B Door Arrival </th>
					<th style="text-align:center;">I/B Door Arrival </th>
					<th style="text-align:center;">Planned</th>
					<th style="text-align:center;">Estimated</th>
				</tr>
				<tr>
					<td><input name="de_due_dt" type="text" class="noinput" style="width:100%;text-align:center;" readonly id="de_due_dt" /> </td>
					<td><input name="ob_dor_arr_dt" type="text" class="noinput" style="width:100%;text-align:center;" readonly id="ob_dor_arr_dt" /> </td>
					<td><input name="apnt_dt" type="text" class="noinput" style="width:100%;text-align:center;" readonly id="apnt_dt" /> </td>
					<td><input name="dlv_pln_date" type="text" class="noinput" style="width:100%;text-align:center;" readonly id="dlv_pln_date" /> </td>
					<td><input name="dlv_estm_date" type="text" class="noinput" style="width:100%;text-align:center;" readonly id="dlv_estm_date" /> </td>
				</tr>
			</table>
		</div>
	     <!-- layout_vertical_2(E) -->
		<!-- layout_vertical_2(S) -->
		<div class="layout_vertical_2" style="width: 227px">
			<h3 class="title_design">Total Transit Time Info.</h3>
			<table class="grid_2">
				<tr>
					<th style="text-align:center;">Planned</th>
					<th style="text-align:center;">Estimated/Actual</th>
				</tr>
				<tr>
					<td><input name="tot_trans_pln_date" type="text" class="noinput" style="width:100%;text-align:center;" readonly id="tot_trans_pln_date" /> </td>
					<td><input name="tot_trans_act_date" type="text" class="noinput" style="width:100%;text-align:center;" readonly id="tot_trans_act_date" /> </td>
<!-- 					<td><input name="tot_trans_estm_date" type="text" class="noinput" style="width:100%;text-align:center;" readonly id="tot_trans_estm_date" /> </td> -->
				</tr>
			</table>
		</div>
	     <!-- layout_vertical_2(E) -->
		<!-- layout_vertical_2(S) -->
		<div class="layout_vertical_2" style="width: 190px">
			<h3 class="title_design">Rail Available Return Info.</h3>
			<table class="grid_2">
				<tr>
					<th style="text-align:center;">Rail Receiving date </th>
				</tr>
				<tr>
					<td><input name="rail_rcv_coff_fm_dt" type="text" class="noinput" style="width:100%;text-align:center;" readonly id="rail_rcv_coff_fm_dt" /> </td>
				</tr>
			</table>
		</div>
	     <!-- layout_vertical_2(E) -->
	</div>
	<!-- layout_wrap(E) -->		
	
</div>
<!-- opus_design_inquiry (E) -->
</div>

<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->
	<!-- wrap_result(S) -->
	<div class="wrap_result">
	<!-- TabLayer (S-1)  -->
	<div id="tabLayer" style="display:inline">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">
			<script type="text/javascript">ComSheetObject('t1sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	<!-- TabLayer (E-1)  -->
	
	<!-- TabLayer (S-2)  -->
	<div id="tabLayer" style="display:none" id="mainTable">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('t3sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	<!-- TabLayer (E-2)  -->
	
	<!-- TabLayer (S-2)  -->
	<div id="tabLayer" style="display:none" id="mainTable">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('t4sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	<!-- TabLayer (E-2)  -->
	</div>
</div>
<!-- cop replan(S) -->
<div class="wrap_result" style="display:none">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- cop replan(E) -->

<% if("false".equals(mainPage)){  %>
</div>
<% } %>
</form>	
