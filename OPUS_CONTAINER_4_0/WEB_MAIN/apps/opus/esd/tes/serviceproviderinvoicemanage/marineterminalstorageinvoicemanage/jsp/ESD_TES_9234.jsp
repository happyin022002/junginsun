<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_TES_9234.jsp
*@FileTitle  : 3rd Party Interface
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/28
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%
   	String tml_inv_tp_cd		= request.getParameter("tml_inv_tp_cd")!=null&&!request.getParameter("tml_inv_tp_cd").equals("")?request.getParameter("tml_inv_tp_cd"):"";
   	String tml_so_ofc_cty_cd	= request.getParameter("tml_so_ofc_cty_cd")!=null&&!request.getParameter("tml_so_ofc_cty_cd").equals("")?request.getParameter("tml_so_ofc_cty_cd"):"";
	String tml_so_seq			= request.getParameter("tml_so_seq")!=null&&!request.getParameter("tml_so_seq").equals("")?request.getParameter("tml_so_seq"):"";
	String tml_so_dtl_seq		= request.getParameter("tml_so_dtl_seq")!=null&&!request.getParameter("tml_so_dtl_seq").equals("")?request.getParameter("tml_so_dtl_seq"):"";
	String calc_cost_grp_cd		= request.getParameter("calc_cost_grp_cd")!=null&&!request.getParameter("calc_cost_grp_cd").equals("")?request.getParameter("calc_cost_grp_cd"):"";
	String calc_tp_cd			= request.getParameter("calc_tp_cd")!=null&&!request.getParameter("calc_tp_cd").equals("")?request.getParameter("calc_tp_cd"):"";
	String vndr_seq				= request.getParameter("vndr_seq")!=null&&!request.getParameter("vndr_seq").equals("")?request.getParameter("vndr_seq"):"";
	String inv_no				= request.getParameter("inv_no")!=null&&!request.getParameter("inv_no").equals("")?request.getParameter("inv_no"):"";
	String param_lgs_cost_cd	= request.getParameter("param_lgs_cost_cd")!=null&&!request.getParameter("param_lgs_cost_cd").equals("")?request.getParameter("param_lgs_cost_cd"):"";
	String param_cntr_tpsz_cd	= request.getParameter("param_cntr_tpsz_cd")!=null&&!request.getParameter("param_cntr_tpsz_cd").equals("")?request.getParameter("param_cntr_tpsz_cd"):"";
	String sheet_curr_row		= request.getParameter("sheet_curr_row")!=null&&!request.getParameter("sheet_curr_row").equals("")?request.getParameter("sheet_curr_row"):"";
	String sheet_idx			= request.getParameter("sheet_idx")!=null&&!request.getParameter("sheet_idx").equals("")?request.getParameter("sheet_idx"):"";
	String param_cntr_no		= request.getParameter("param_cntr_no")!=null&&!request.getParameter("param_cntr_no").equals("")?request.getParameter("param_cntr_no"):"";
	String curr_cd				= request.getParameter("curr_cd")!=null&&!request.getParameter("curr_cd").equals("")?request.getParameter("curr_cd"):"";
	String inv_amt				= request.getParameter("inv_amt")!=null&&!request.getParameter("inv_amt").equals("")?request.getParameter("inv_amt"):"";
	String calc_amt				= request.getParameter("calc_amt")!=null&&!request.getParameter("calc_amt").equals("")?request.getParameter("calc_amt"):"";
    String yd_cd  				= request.getParameter("yd_cd")!=null&&!request.getParameter("yd_cd").equals("")?request.getParameter("yd_cd"):"";
	String ctrt_rt  			= request.getParameter("ctrt_rt")!=null&&!request.getParameter("ctrt_rt").equals("")?request.getParameter("ctrt_rt"):"";
	String inv_xch_rt			= request.getParameter("inv_xch_rt")!=null&&!request.getParameter("inv_xch_rt").equals("")?request.getParameter("inv_xch_rt"):"1";
	String ovr_dys				= request.getParameter("ovr_dys")!=null&&!request.getParameter("ovr_dys").equals("")?request.getParameter("ovr_dys"):"1";
%>


<script language="javascript">
<%= JSPUtil.getIBCodeCombo("combo01", "01", "CD00583", 0, "")%>
    function setupPage(){
        loadPage();
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="sheet_idx" value='<%=sheet_idx%>'>
<input type="hidden" name="sheet_curr_row" value='<%=sheet_curr_row%>'>
<input type="hidden" name="tml_inv_tp_cd" value="<%=tml_inv_tp_cd%>"> <!--// TM, OF, ON, ST //-->
<input type="hidden" name="tml_so_ofc_cty_cd" value="<%=tml_so_ofc_cty_cd%>">
<input type="hidden" name="tml_so_seq" value="<%=tml_so_seq%>">
<input type="hidden" name="tml_so_dtl_seq" value='<%=tml_so_dtl_seq%>'>
<input type="hidden" name="calc_cost_grp_cd" value="<%=calc_cost_grp_cd%>"> <!--// TM, SD, SP //-->
<input type="hidden" name="calc_tp_cd" value="<%=calc_tp_cd%>"> <!--// A, M //-->
<input type="hidden" name="vndr_seq" value="<%=vndr_seq%>">
<input type="hidden" name="inv_no" value="<%=inv_no%>">
<input type="hidden" name="param_lgs_cost_cd" value="<%=param_lgs_cost_cd%>">
<input type="hidden" name="param_cntr_tpsz_cd" value="<%=param_cntr_tpsz_cd%>">
<input type="hidden" name="param_cntr_no" value="<%=param_cntr_no%>">
<input type="hidden" name="n3pty_bil_cs_cd" value="">
<input type="hidden" name="curr_cd" value="<%=curr_cd%>">
<input type="hidden" name="inv_amt" value="<%=inv_amt%>">
<input type="hidden" name="calc_amt" value="<%=calc_amt%>">
<input type="hidden" name="yd_cd" value="<%=yd_cd%>">
<input type="hidden" name="ctrt_rt" value="<%=ctrt_rt%>">
<input type="hidden" name="inv_xch_rt" value="<%=inv_xch_rt%>">
<input type="hidden" name="ovr_dys" value="<%=ovr_dys%>">

<input type="hidden" name="del_if_seq" id="del_if_seq">
<input type="hidden" name="del_cntr_seq" id="del_cntr_seq">

<!-- TPB I/F TPB Use BillingCase Code Get Temp ( 2009-09-18 )	-->
<input type="hidden" name="n3pty_bil_tp_cd_tmp"	 id="n3pty_bil_tp_cd_tmp"	value="">

<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>3rd Party Interface</span></h2>
		
		<div class="opus_design_btn"> 
			 <button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table> 
				<tbody>
					<tr class="h23">
						<td width="11%">Source No.</td>
						<td><input type="text" name='inv_no' style="width:150" value="<%=inv_no%>" class="input2" readonly></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="wrap_result">
		<div class="opus_design_grid" >
			<div class="opus_design_grid">
				
				<!-- opus_grid_btn(S) -->
				<div class="opus_design_btn" id='enableRowButton' style="display:inline">
					<button type="button" class="btn_normal" name="btng_rowadd" id="btng_rowadd">Row Add</button><!-- 
					 --><button type="button" class="btn_normal" name="btng_rowdel" id="btng_rowdel">Row Delete</button><!-- 
					  --><button type="button" class="btn_normal" name="btng_interfaceto3rd" id="btng_interfaceto3rd">OK</button><!-- 
					   --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
				</div>
				<div class="opus_design_btn" id='disableRowButton' style="display:none">
					<button type="button" class="btn_normal" name="btng_interfaceto3rd" id="btng_interfaceto3rd">OK</button><!-- 
					 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
				</div>
				<!-- opus_grid_btn(E) -->
			</div>
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>

</form>