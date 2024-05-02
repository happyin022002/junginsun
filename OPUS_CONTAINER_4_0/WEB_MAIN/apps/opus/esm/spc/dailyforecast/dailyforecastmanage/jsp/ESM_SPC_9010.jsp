<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_SPC_9010.jsP
*@FileTitle  : File Import 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>

<%
	Exception serverException   = null;			//Server Exception
	String strErrMsg = "";						//Error Message
	String strOfc_cd = "";
	
	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strOfc_cd = account.getOfc_cd();
	
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
	 
	String tml_so_ofc_cty_cd = request.getParameter("tml_so_ofc_cty_cd")!=null&&!request.getParameter("tml_so_ofc_cty_cd").equals("")?request.getParameter("tml_so_ofc_cty_cd"):"";
	String tml_so_seq	= request.getParameter("tml_so_seq")!=null&&!request.getParameter("tml_so_seq").equals("")?request.getParameter("tml_so_seq"):"";
	String vndr_seq		= request.getParameter("vndr_seq")!=null&&!request.getParameter("vndr_seq").equals("")?request.getParameter("vndr_seq"):"";
	String inv_no		= request.getParameter("inv_no")!=null&&!request.getParameter("inv_no").equals("")?request.getParameter("inv_no"):"";
	String yd_cd		= request.getParameter("yd_cd")!=null&&!request.getParameter("yd_cd").equals("")?request.getParameter("yd_cd"):"";
	String fm_prd_dt	= request.getParameter("fm_prd_dt")!=null&&!request.getParameter("fm_prd_dt").equals("")?request.getParameter("fm_prd_dt"):"";
	String to_prd_dt	= request.getParameter("to_prd_dt")!=null&&!request.getParameter("to_prd_dt").equals("")?request.getParameter("to_prd_dt"):"";
	String rcv_dt		= request.getParameter("rcv_dt")!=null&&!request.getParameter("rcv_dt").equals("")?request.getParameter("rcv_dt"):"";
	String tml_cost_grp_cd		= request.getParameter("tml_cost_grp_cd")!=null&&!request.getParameter("tml_cost_grp_cd").equals("")?request.getParameter("tml_cost_grp_cd"):"";
	String tml_calc_ind_cd		= request.getParameter("tml_calc_ind_cd")!=null&&!request.getParameter("tml_calc_ind_cd").equals("")?request.getParameter("tml_calc_ind_cd"):"";
	String sto_dys_ind_cd		= request.getParameter("sto_dys_ind_cd")!=null&&!request.getParameter("sto_dys_ind_cd").equals("")?request.getParameter("sto_dys_ind_cd"):"";
	String cntr_tpsz_cd		= request.getParameter("cntr_tpsz_cd")!=null&&!request.getParameter("cntr_tpsz_cd").equals("")?request.getParameter("cntr_tpsz_cd"):"";
  %>

<script language="javascript">
	<%= JSPUtil.getIBCodeCombo("cntr_sty_cd"	, "01", "CD00136", 0, "")%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
		loadPage();
	}
</script>

<form name="form">
<input name='f_cmd' type='hidden'>
<input type="hidden" name="tml_so_ofc_cty_cd" value="<%=tml_so_ofc_cty_cd%>">
<input type="hidden" name="tml_so_seq" value="<%=tml_so_seq%>">
<input type="hidden" name="vndr_seq" value="<%=vndr_seq%>">
<input type="hidden" name="inv_no" value="<%=inv_no%>">
<input type="hidden" name="yd_cd" value="<%=yd_cd%>">
<input type="hidden" name="fm_prd_dt" value="<%=fm_prd_dt%>">
<input type="hidden" name="to_prd_dt" value="<%=to_prd_dt%>">
<input type="hidden" name="rcv_dt" value="<%=rcv_dt%>">
<input type="hidden" name="fileup_min_gt_in_dt" value="">
<input type="hidden" name="fileup_max_gt_out_dt" value="">
<input type="hidden" name="tml_cost_grp_cd" value="<%=tml_cost_grp_cd%>">
<input type="hidden" name="tml_calc_ind_cd" value="<%=tml_calc_ind_cd%>">
<input type="hidden" name="sto_dys_ind_cd" value="<%=sto_dys_ind_cd%>">
<input type="hidden" name="cntr_tpsz_cd" value="<%=cntr_tpsz_cd%>">
<input type="hidden" name="usr_ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="uiname" value="ESM_SPC_9010">
<input type="hidden" name="excel_chk" value="">


<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title" id="popup_title" name="popup_title"><span>Forecast File Import</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">							
			<button type="button" class="btn_accent" 	name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_template" 	id="btn_template">Template Down</button><!--
			--><button type="button" class="btn_normal" name="btn_downexcel" 	id="btn_downexcel">Down Excel</button><!--
			--><button type="button" class="btn_normal" name="btn_loadexcel" 	id="btn_loadexcel">Load Excel</button><!--
			--><button type="button" class="btn_normal" name="btn_save" 			id="btn_save">Save</button><!--
			--><button type="button" class="btn_normal" name="btn_close" 			id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
		<!-- <div class="location">
			<span id="navigation"></span>
		</div> -->
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents">	
	<div class= "wrap_search">
		<div class= "opus_design_inquiry">
			<table>
				<colgroup>
					<col width="80px" />					
					<col width="35px" />
					<col width="110px" />
					<col width="55px" />
					<col width="110px" />
					<col width="110px" />
					<col width="110px" />
					<col width="110px" />
					<col width="110px" />
					<col width="" />
				</colgroup>
				<tbody>
					<tr>
						<th>Start Week</th>
						<td>
							<select class="input1" id="year" name="year" style="width:60px;"></select>
						</td>
						<td>
							<select class="input1" id="week" name="week" style="width:45px;"></select>
						</td>
						<th>Duration</th>
						<td>
							<select class="input1" id="duration" name="duration" size="1"></select>
						</td>
						<th>VVD</th>
						<td>
							<input class="input1" type="text" name="vvd" size="12" maxlength="9" style="ime-mode:disabled;" dataformat="engup" onkeypress="eventKeyChangeChar(UPPER_CASE , this);" onchange="vvdChanged();">
						</td>
						<th></th>
						<td><input type="checkbox" class="trans" name="salesrep" id="salesrep"> SalesRep							
						      <input type="checkbox" class="trans" name="fcast" id="fcast"> Customer							
						</td>
					</tr>
					<tr>			
						<th>Trade</th>
						<td colspan="2"><script language="JavaScript">ComComboObject("trade", 2, 104, 0, 1);</script></td>
						<th>Sub Trade</th>
						<td><script type="text/javascript">ComComboObject("subtrade", 3, 80, 0, 0, 1);</script></td>
						<th>Lane</th>
						<td><script language="JavaScript">ComComboObject("lane", 4, 70, 0, 0, 2);</script></td>
						<th>Bound</th>
						<td><select name="bound" id="bound" class="input1" style="width:95px;"></select></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="id="mainTable"">
		    <!-- opus_design_btn(S) -->
		    <div class="opus_design_btn">
			    <button type="button" class="btn_normal" name="btn_rowadd" id="btn_rowadd">Add</button>
			    <button type="button" class="btn_normal" name="btn_rowdel" id="btn_rowdel">Delete</button>
		    </div>
		    <!-- opus_design_btn(E) -->
		    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		    <script type="text/javascript">ComSheetObject('sheet');</script>
		    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
		</div>
		
		<div class="opus_design_grid"  id="mainTable" style="display:none;">
	    	<script type="text/javascript">ComSheetObject('sheet2');</script>
	    </div>
	    
	    <div class="opus_design_grid"  id="mainTable" style="display:none;">
	    	<script type="text/javascript">ComSheetObject('sheet3');</script>
	    </div>
		<!--biz page (E)-->
	</div>
</div>
</form>




