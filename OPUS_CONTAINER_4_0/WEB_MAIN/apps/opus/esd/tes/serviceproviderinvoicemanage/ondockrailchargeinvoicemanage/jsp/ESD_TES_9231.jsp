<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_9231.jsp
*@FileTitle  : 3rd Party Interface
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/25
=========================================================*/
%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%
	String param_name = null;
	java.util.Enumeration enums = request.getParameterNames();
	while (enums.hasMoreElements()){
		param_name = (String)enums.nextElement();
	}

	String tml_inv_tp_cd	 = request.getParameter("tml_inv_tp_cd"			)!=null&&!request.getParameter("tml_inv_tp_cd"		).equals("")?request.getParameter("tml_inv_tp_cd" 		):"";
	String tml_so_ofc_cty_cd = request.getParameter("tml_so_ofc_cty_cd"		)!=null&&!request.getParameter("tml_so_ofc_cty_cd").equals("")?request.getParameter("tml_so_ofc_cty_cd" ):"";
	String tml_so_seq		 = request.getParameter("tml_so_seq"			)!=null&&!request.getParameter("tml_so_seq"				).equals("")?request.getParameter("tml_so_seq"				):"";
	String tml_so_dtl_seq 	 = request.getParameter("tml_so_dtl_seq"		)!=null&&!request.getParameter("tml_so_dtl_seq"		).equals("")?request.getParameter("tml_so_dtl_seq" 		):"";
	String inv_ofc_cd		 = request.getParameter("inv_ofc_cd"			)!=null&&!request.getParameter("inv_ofc_cd"				).equals("")?request.getParameter("inv_ofc_cd"				):"";
	String vndr_seq			 = request.getParameter("vndr_seq"				)!=null&&!request.getParameter("vndr_seq"					).equals("")?request.getParameter("vndr_seq"					):"";
	String yd_cd			 = request.getParameter("yd_cd"					)!=null&&!request.getParameter("yd_cd"						).equals("")?request.getParameter("yd_cd"						  ):"";
	String inv_no			 = request.getParameter("inv_no"				)!=null&&!request.getParameter("inv_no"						).equals("")?request.getParameter("inv_no"					  ):"";
	String curr_cd			 = request.getParameter("curr_cd"				)!=null&&!request.getParameter("curr_cd"					).equals("")?request.getParameter("curr_cd"					  ):"";
	String vvd_no			 = request.getParameter("vvd_no"				)!=null&&!request.getParameter("vvd_no"						).equals("")?request.getParameter("vvd_no"						):"";
	String calc_tp_cd	     = request.getParameter("calc_tp_cd"			)!=null&&!request.getParameter("calc_tp_cd"				).equals("")?request.getParameter("calc_tp_cd"				):"";
	String lgs_cost_cd	     = request.getParameter("lgs_cost_cd"			)!=null&&!request.getParameter("lgs_cost_cd"			).equals("")?request.getParameter("lgs_cost_cd"				):"";
	String cntr_tpsz_cd		 = request.getParameter("cntr_tpsz_cd"			)!=null&&!request.getParameter("cntr_tpsz_cd"			).equals("")?request.getParameter("cntr_tpsz_cd"			):"";
	String io_bnd_cd		 = request.getParameter("io_bnd_cd"				)!=null&&!request.getParameter("io_bnd_cd"				).equals("")?request.getParameter("io_bnd_cd"				  ):"";
	String ioc_cd			 = request.getParameter("ioc_cd"				)!=null&&!request.getParameter("ioc_cd"						).equals("")?request.getParameter("ioc_cd"						):"";
	String lane_cd			 = request.getParameter("lane_cd"				)!=null&&!request.getParameter("lane_cd"					).equals("")?request.getParameter("lane_cd"					  ):"";
	String cal_vol			 = request.getParameter("cal_vol"				)!=null&&!request.getParameter("cal_vol"					).equals("")?request.getParameter("cal_vol"					  ):"";
	String opener_row  		 = request.getParameter("opener_row"			)!=null&&!request.getParameter("opener_row" 			).equals("")?request.getParameter("opener_row"				):"";
	String rvis_vol_qty  	 = request.getParameter("rvis_vol_qty"			)!=null&&!request.getParameter("rvis_vol_qty"			).equals("")?request.getParameter("rvis_vol_qty"			):"";
	String inv_amt		  	 = request.getParameter("inv_amt"				)!=null&&!request.getParameter("inv_amt"					).equals("")?request.getParameter("inv_amt"						):"";
	String fm_tr_vol_val  	 = request.getParameter("fm_tr_vol_val"			)!=null&&!request.getParameter("fm_tr_vol_val"		).equals("")?request.getParameter("fm_tr_vol_val"			):"";
	String to_tr_vol_val  	 = request.getParameter("to_tr_vol_val"			)!=null&&!request.getParameter("to_tr_vol_val"		).equals("")?request.getParameter("to_tr_vol_val"			):"";
	String dcgo_clss_cd  	 = request.getParameter("dcgo_clss_cd"			)!=null&&!request.getParameter("dcgo_clss_cd"	  	).equals("")?request.getParameter("dcgo_clss_cd"			):"";
	String ctrt_rt  	 = request.getParameter("ctrt_rt"			)!=null&&!request.getParameter("ctrt_rt"	  	).equals("")?request.getParameter("ctrt_rt"			):"";
	String inv_xch_rt  	 = request.getParameter("inv_xch_rt"			)!=null&&!request.getParameter("inv_xch_rt"	  	).equals("")?request.getParameter("inv_xch_rt"			):"";
	String tml_wrk_dy_cd  	 			 = request.getParameter("tml_wrk_dy_cd"					)!=null&&!request.getParameter("tml_wrk_dy_cd"								).equals("")?request.getParameter("tml_wrk_dy_cd"								):"";
	String sheet_idx			= request.getParameter("sheet_idx")!=null&&!request.getParameter("sheet_idx").equals("")?request.getParameter("sheet_idx"):"";
%>

<script type="text/javascript">
<%= JSPUtil.getIBCodeCombo("combo01", "01", "CD00583", 0, "")%>

var sheet_idx = <%=sheet_idx%>;
	
	function setupPage(){
		loadPage();
	}
	
</script>

<form method="post" name="form">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="tml_inv_tp_cd"	 		 value="<%=tml_inv_tp_cd%>">
<input type="hidden" name="tml_so_ofc_cty_cd"	 	 value="<%=tml_so_ofc_cty_cd%>">
<input type="hidden" name="tml_so_seq"				 value="<%=tml_so_seq%>">
<input type="hidden" name="tml_so_dtl_seq"		 	 value="<%=tml_so_dtl_seq%>">
<input type="hidden" name="inv_ofc_cd"				 value="<%=inv_ofc_cd%>">
<input type="hidden" name="inv_no"					 value="<%=inv_no%>">
<input type="hidden" name="vndr_seq"				 value="<%=vndr_seq%>">
<input type="hidden" name="yd_cd"					 value="<%=yd_cd%>">
<input type="hidden" name="curr_cd"					 value="<%=curr_cd%>">
<input type="hidden" name="vvd_no"					 value="<%=vvd_no%>">
<input type="hidden" name="calc_tp_cd"				 value="<%=calc_tp_cd%>">
<input type="hidden" name="lgs_cost_cd"				 value="<%=lgs_cost_cd%>">
<input type="hidden" name="cntr_tpsz_cd"			 value="<%=cntr_tpsz_cd%>">
<input type="hidden" name="io_bnd_cd"				 value="<%=io_bnd_cd%>">
<input type="hidden" name="ioc_cd"					 value="<%=ioc_cd%>">
<input type="hidden" name="lane_cd"					 value="<%=lane_cd%>">
<input type="hidden" name="cal_vol"					 value="<%=cal_vol%>">
<input type="hidden" name="rvis_vol_qty"			 value="<%=rvis_vol_qty%>">
<input type="hidden" name="inv_amt"					 value="<%=inv_amt%>">
<input type="hidden" name="fm_tr_vol_val"			 value="<%=fm_tr_vol_val%>">
<input type="hidden" name="to_tr_vol_val"			 value="<%=to_tr_vol_val%>">
<input type="hidden" name="dcgo_clss_cd"			 value="<%=dcgo_clss_cd%>">
<input type="hidden" name="tml_wrk_dy_cd"			 value="<%=tml_wrk_dy_cd%>">
<input type="hidden" name="opener_row"				 value="<%=opener_row%>">
<input type="hidden" name="n3pty_bil_cs_cd" 		 value="">
<input type="hidden" name="sheet_idx"                value='<%=sheet_idx%>'>
<input type="hidden" name="ctrt_rt"			         value="<%=ctrt_rt%>">
<input type="hidden" name="inv_xch_rt"			     value="<%=inv_xch_rt%>">
<input type="hidden" name="org_curr_cd"				value="<%=curr_cd%>">
<input type="hidden" name="del_if_seq"				value="">
<input type="hidden" name="flg_yn"			 		value="">

<!-- TPB I/F TPB Use BillingCase Code Get Temp ( 2009-09-18 ) -->
<input type="hidden" name="n3pty_bil_tp_cd_tmp" value="" id="n3pty_bil_tp_cd_tmp" />

<div class="layer_popup_title">
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>3rd Party Interface</span></h2>
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btng_interfaceto3rd" 	id="btng_interfaceto3rd">Ok</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_close" 	id="btn_close">Close</button>
		</div>
	
		<!-- <div class="location">
			<span id="navigation"></span>
		</div> -->
	</div>
</div>

<div class="layer_popup_contents">	
	<div class="wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="50" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Source No.</th>
						<td><input type="text" style="width:80px" value="<%=inv_no%>"></td>	
				</tbody>
			</table>
		</div>
	</div>
	<div class="wrap_result">
		<div class="opus_design_grid clear" id="mainTable">
			<script type="text/javascript">ComSheetObject('sheet');</script>
		</div>
	</div>	
</div>
	
</form>

