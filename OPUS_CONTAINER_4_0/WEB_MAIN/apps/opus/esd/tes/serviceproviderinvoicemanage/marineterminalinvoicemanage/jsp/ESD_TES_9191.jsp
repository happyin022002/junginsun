<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_TES_9191.jsp
*@FileTitle  : R/H Volume Adjustment PopUp 
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

	String tml_so_ofc_cty_cd = request.getParameter("tml_so_ofc_cty_cd"	)!=null&&!request.getParameter("tml_so_ofc_cty_cd"	).equals("")?request.getParameter("tml_so_ofc_cty_cd" 	):"";
	String tml_so_seq		 = request.getParameter("tml_so_seq"		)!=null&&!request.getParameter("tml_so_seq"			).equals("")?request.getParameter("tml_so_seq"			):"";
	String tml_so_dtl_seq	 = request.getParameter("tml_so_dtl_seq"	)!=null&&!request.getParameter("tml_so_dtl_seq"		).equals("")?request.getParameter("tml_so_dtl_seq"		):"";
	String vvd 		 		 = request.getParameter("vvd"				)!=null&&!request.getParameter("vvd"				).equals("")?request.getParameter("vvd"					):"";
	String yd_cd			 = request.getParameter("yd_cd"				)!=null&&!request.getParameter("yd_cd"				).equals("")?request.getParameter("yd_cd"				):"";
	String lgs_cost_cd 		 = request.getParameter("lgs_cost_cd"		)!=null&&!request.getParameter("lgs_cost_cd"		).equals("")?request.getParameter("lgs_cost_cd"			):"";
	String cntr_tpsz_cd		 = request.getParameter("cntr_tpsz_cd"		)!=null&&!request.getParameter("cntr_tpsz_cd"		).equals("")?request.getParameter("cntr_tpsz_cd"		):"";
	String io_bnd_cd		 = request.getParameter("io_bnd_cd"			)!=null&&!request.getParameter("io_bnd_cd"			).equals("")?request.getParameter("io_bnd_cd"			):"";
	String ioc_cd			 = request.getParameter("ioc_cd"			)!=null&&!request.getParameter("ioc_cd"				).equals("")?request.getParameter("ioc_cd"				):"";
	String lane_cd			 = request.getParameter("lane_cd"			)!=null&&!request.getParameter("lane_cd"			).equals("")?request.getParameter("lane_cd"				):"";
	String opener_row  		 = request.getParameter("opener_row"		)!=null&&!request.getParameter("opener_row" 		).equals("")?request.getParameter("opener_row"			):"";
	String rh_vol_qty  		 = request.getParameter("rh_vol_qty"		)!=null&&!request.getParameter("rh_vol_qty"			).equals("")?request.getParameter("rh_vol_qty"			):"";
	String dcgo_clss_cd		 = request.getParameter("dcgo_clss_cd"		)!=null&&!request.getParameter("dcgo_clss_cd"		).equals("")?request.getParameter("dcgo_clss_cd"		):"";
	String vol_tr_ut_cd		 = request.getParameter("vol_tr_ut_cd"		)!=null&&!request.getParameter("vol_tr_ut_cd"		).equals("")?request.getParameter("vol_tr_ut_cd"		):"";
	String tml_wrk_dy_cd	 = request.getParameter("tml_wrk_dy_cd"		)!=null&&!request.getParameter("tml_wrk_dy_cd"		).equals("")?request.getParameter("tml_wrk_dy_cd"		):"";
	String sub_trd_cd	 = request.getParameter("sub_trd_cd"		)!=null&&!request.getParameter("sub_trd_cd"		).equals("")?request.getParameter("sub_trd_cd"		):"";
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
<input type="hidden" name="yd_cd" 				value="<%=yd_cd				%>">
<input type="hidden" name="opener_row" 			value="<%=opener_row		%>">
<input type="hidden" name="rh_vol_qty" 			value="<%=rh_vol_qty		%>">
<input type="hidden" name="tml_so_ofc_cty_cd"	value="<%=tml_so_ofc_cty_cd	%>">
<input type="hidden" name="tml_so_seq"			value="<%=tml_so_seq		%>">
<input type="hidden" name="tml_so_dtl_seq"		value="<%=tml_so_dtl_seq	%>">
<input type="hidden" name="cntr_tpsz_cd"		value="<%=cntr_tpsz_cd		%>">
<input type="hidden" name="io_bnd_cd"			value="<%=io_bnd_cd			%>">
<input type="hidden" name="dcgo_clss_cd"		value="<%=dcgo_clss_cd  	%>">
<input type="hidden" name="tml_wrk_dy_cd"		value="<%=tml_wrk_dy_cd  	%>">
<input type="hidden" name="ioc_cd"				value="<%=ioc_cd			%>">
<input type="hidden" name="lane_cd"				value="<%=lane_cd			%>">
<input type="hidden" name="vol_tr_ut_cd"		value="<%=vol_tr_ut_cd		%>">
<input type="hidden" name="sub_trd_cd"		value="<%=sub_trd_cd		%>">
<input type="hidden" name="rc_flg"		value="<%=rc_flg		%>">

<!--<input type="hidden" name="rvis_flag"					 value="MENUAL">

--><!-- OUTER - POPUP (S)tart -->

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>R/H Volume Adjustment</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table class="search" border="0" style="width:362;">
					<tr class="h23">
						<th width="65">Cost Code</th>
						<td width="147"><input type="text" style="width:90" name="lgs_cost_cd" value="<%=lgs_cost_cd%>"></td>
						<th width="30">VVD</th>
						<td width="120"><input type="text" style="width:90" name="vvd" value="<%=vvd%>"></td>
					</tr>
				</table>
			</div>
		</div>
	<div class="wrap_result">
		<div class="opus_design_grid clear">
			<script type="text/javascript">ComSheetObject('sheet');</script>
		</div>
	</div>
</div>

</form>
