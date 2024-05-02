<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_TES_9072.jsp
*@FileTitle  : Volume Adjustment PopUp
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/02
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
//	out.println("yd_cd==>"+request.getParameter("yd_cd"		));
	
	String tml_inv_tp_cd	 = request.getParameter("tml_inv_tp_cd"		)!=null&&!request.getParameter("tml_inv_tp_cd"		).equals("")?request.getParameter("tml_inv_tp_cd" 		):"";
	String tml_so_ofc_cty_cd = request.getParameter("tml_so_ofc_cty_cd"	)!=null&&!request.getParameter("tml_so_ofc_cty_cd"	).equals("")?request.getParameter("tml_so_ofc_cty_cd" 	):"";
	String tml_so_seq		 = request.getParameter("tml_so_seq"		)!=null&&!request.getParameter("tml_so_seq"			).equals("")?request.getParameter("tml_so_seq"			):"";
	String vndr_seq			 = request.getParameter("vndr_seq"			)!=null&&!request.getParameter("vndr_seq"			).equals("")?request.getParameter("vndr_seq"			):"";
	String yd_cd			 = request.getParameter("yd_cd"				)!=null&&!request.getParameter("yd_cd"				).equals("")?request.getParameter("yd_cd"				):"";
	String vvd				 = request.getParameter("vvd"				)!=null&&!request.getParameter("vvd"				).equals("")?request.getParameter("vvd"					):"";
	String lgs_cost_cd	     = request.getParameter("lgs_cost_cd"		)!=null&&!request.getParameter("lgs_cost_cd"		).equals("")?request.getParameter("lgs_cost_cd"			):"";
	String cntr_tpsz_cd		 = request.getParameter("cntr_tpsz_cd"		)!=null&&!request.getParameter("cntr_tpsz_cd"		).equals("")?request.getParameter("cntr_tpsz_cd"		):"";
	String cntr_sty_cd  	 = request.getParameter("cntr_sty_cd"		)!=null&&!request.getParameter("cntr_sty_cd"	  	).equals("")?request.getParameter("cntr_sty_cd"			):"";
	String io_bnd_cd		 = request.getParameter("io_bnd_cd"			)!=null&&!request.getParameter("io_bnd_cd"			).equals("")?request.getParameter("io_bnd_cd"			):"";
	String ioc_cd			 = request.getParameter("ioc_cd"			)!=null&&!request.getParameter("ioc_cd"				).equals("")?request.getParameter("ioc_cd"				):"";
	String lane_cd			 = request.getParameter("lane_cd"			)!=null&&!request.getParameter("lane_cd"			).equals("")?request.getParameter("lane_cd"				):"";
	String cal_vol			 = request.getParameter("cal_vol"			)!=null&&!request.getParameter("cal_vol"			).equals("")?request.getParameter("cal_vol"				):"";
	String opener_row  		 = request.getParameter("opener_row"		)!=null&&!request.getParameter("opener_row" 		).equals("")?request.getParameter("opener_row"			):"";
	String rvis_vol_qty  	 = request.getParameter("rvis_vol_qty"		)!=null&&!request.getParameter("rvis_vol_qty"		).equals("")?request.getParameter("rvis_vol_qty"		):"";
	String fm_tr_vol_val  	 = request.getParameter("fm_tr_vol_val"		)!=null&&!request.getParameter("fm_tr_vol_val"		).equals("")?request.getParameter("fm_tr_vol_val"		):"";
	String to_tr_vol_val  	 = request.getParameter("to_tr_vol_val"		)!=null&&!request.getParameter("to_tr_vol_val"		).equals("")?request.getParameter("to_tr_vol_val"		):"";
	String dcgo_ind_cd		 = request.getParameter("dcgo_ind_cd"		)!=null&&!request.getParameter("dcgo_ind_cd"		).equals("")?request.getParameter("dcgo_ind_cd"		):"";
	String tml_wrk_dy_cd 	 = request.getParameter("tml_wrk_dy_cd"		)!=null&&!request.getParameter("tml_wrk_dy_cd"		).equals("")?request.getParameter("tml_wrk_dy_cd"		):"";
	String tml_trns_mod_cd 	 = request.getParameter("tml_trns_mod_cd"	)!=null&&!request.getParameter("tml_trns_mod_cd"	).equals("")?request.getParameter("tml_trns_mod_cd"		):"";
	String rvis_div			 = request.getParameter("rvis_div"			)!=null&&!request.getParameter("rvis_div"			).equals("")?request.getParameter("rvis_div"			):"";
	String vol_tr_ut_cd		 = request.getParameter("vol_tr_ut_cd"		)!=null&&!request.getParameter("vol_tr_ut_cd"		).equals("")?request.getParameter("vol_tr_ut_cd"		):"";
	String calc_tp_cd		 = request.getParameter("calc_tp_cd"		)!=null&&!request.getParameter("calc_tp_cd"			).equals("")?request.getParameter("calc_tp_cd"			):"";
	String tml_so_dtl_seq 	 = request.getParameter("tml_so_dtl_seq"	)!=null&&!request.getParameter("tml_so_dtl_seq"		).equals("")?request.getParameter("tml_so_dtl_seq" 		):"";
	String ctrt_rt			 = request.getParameter("ctrt_rt"			)!=null&&!request.getParameter("ctrt_rt"			).equals("")?request.getParameter("ctrt_rt"				):"";
	String sub_trd_cd			 = request.getParameter("sub_trd_cd"			)!=null&&!request.getParameter("sub_trd_cd"			).equals("")?request.getParameter("sub_trd_cd"				):"";
	String rc_flg			 = request.getParameter("rc_flg"			)!=null&&!request.getParameter("rc_flg"			).equals("")?request.getParameter("rc_flg"				):"";
%>


<script language="javascript">
    function setupPage(){
        loadPage();
    }
</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="tml_inv_tp_cd"	 		 value="<%=tml_inv_tp_cd	  %>">
<input type="hidden" name="tml_so_ofc_cty_cd"	 	 value="<%=tml_so_ofc_cty_cd  %>">
<input type="hidden" name="tml_so_seq"				 value="<%=tml_so_seq		  %>">
<input type="hidden" name="vndr_seq"				 value="<%=vndr_seq			  %>">
<input type="hidden" name="yd_cd"					 value="<%=yd_cd			  %>">
<input type="hidden" name="vvd"						 value="<%=vvd				  %>">
<input type="hidden" name="lgs_cost_cd"				 value="<%=lgs_cost_cd	      %>">
<input type="hidden" name="cntr_tpsz_cd"			 value="<%=cntr_tpsz_cd		  %>">
<input type="hidden" name="io_bnd_cd"				 value="<%=io_bnd_cd		  %>">
<input type="hidden" name="ioc_cd"					 value="<%=ioc_cd			  %>">
<input type="hidden" name="lane_cd"					 value="<%=lane_cd			  %>">
<input type="hidden" name="cal_vol"					 value="<%=cal_vol			  %>">
<input type="hidden" name="fm_tr_vol_val"			 value="<%=fm_tr_vol_val  	  %>">
<input type="hidden" name="to_tr_vol_val"			 value="<%=to_tr_vol_val  	  %>">
<input type="hidden" name="opener_row"				 value="<%=opener_row  		  %>">
<input type="hidden" name="rvis_vol_qty"			 value="<%=rvis_vol_qty  	  %>">
<input type="hidden" name="dcgo_ind_cd"			 	 value="<%=dcgo_ind_cd  	  %>">
<input type="hidden" name="tml_wrk_dy_cd"			 value="<%=tml_wrk_dy_cd	  %>">
<input type="hidden" name="tml_trns_mod_cd"			 value="<%=tml_trns_mod_cd	  %>">
<input type="hidden" name="rvis_div"				 value="<%=rvis_div  		  %>">
<input type="hidden" name="vol_tr_ut_cd"			 value="<%=vol_tr_ut_cd		  %>">
<input type="hidden" name="calc_tp_cd"				 value="<%=calc_tp_cd		  %>">
<input type="hidden" name="cntr_sty_cd"				 value="<%=cntr_sty_cd		  %>">
<input type="hidden" name="tml_so_dtl_seq"		 	 value="<%=tml_so_dtl_seq	  %>">
<input type="hidden" name="ctrt_rt"			 		 value="<%=ctrt_rt			  %>">
<input type="hidden" name="sub_trd_cd"			 		 value="<%=sub_trd_cd			  %>">
<input type="hidden" name="rc_flg"			 		 value="<%=rc_flg			  %>">


<!-- OUTER - POPUP (S)tart -->

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Revised Vol.(Volume Adjustment)</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_result">
		<div class="opus_design_inquiry">
			<script language="javascript">ComSheetObject('sheet');</script>
		</div>
	</div>
</div>

</form>

