<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_9190.jsp
*@FileTitle : R/H Volume Adjustment PopUp screen
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
--%>

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
	String page_rows	 	 = request.getParameter("page_rows"			)!=null&&!request.getParameter("page_rows"			).equals("")?request.getParameter("page_rows"			):"";
	String rvis_vol_qty  	 = request.getParameter("rvis_vol_qty"		)!=null&&!request.getParameter("rvis_vol_qty"		).equals("")?request.getParameter("rvis_vol_qty"		):"";
	String ctrt_rt			 = request.getParameter("ctrt_rt"			)!=null&&!request.getParameter("ctrt_rt"			).equals("")?request.getParameter("ctrt_rt"				):"";
	String sub_trd_cd			 = request.getParameter("sub_trd_cd"			)!=null&&!request.getParameter("sub_trd_cd"			).equals("")?request.getParameter("sub_trd_cd"				):"";
	String rc_flg			 = request.getParameter("rc_flg"			)!=null&&!request.getParameter("rc_flg"			).equals("")?request.getParameter("rc_flg"				):"";

%><html>
<!-- <head>
<title>Welcome to OPUS!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<script language="javascript">
    function setupPage(){
        loadPage();
    }
</script>
<!-- </head> -->

<!-- <body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();"> -->
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
<input type="hidden" name="page_rows"			value="<%=page_rows			%>">
<input type="hidden" name="rvis_vol_qty"		value="<%=rvis_vol_qty      %>">
<input type="hidden" name="ctrt_rt" value="<%=ctrt_rt			  %>" id="ctrt_rt" />
<input type="hidden" name="sub_trd_cd" value="<%=sub_trd_cd			  %>" id="sub_trd_cd" />
<input type="hidden" name="rc_flg" value="<%=rc_flg			  %>" id="rc_flg" />

<!-- OUTER - POPUP (S)tart -->
<%-- <table width="400" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/opuscntr/img/icon_title_dot.gif" align="absmiddle">&nbsp;R/H Volume Adjustment</td></tr>
		</table>
		<!-- : ( Title ) (E) -->


		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<table class="search" border="0" style="width:362;">
					<tr class="h23">
						<td width="65">Cost Code</td>
						<td width="147"><input type="text" style="width:90" name="lgs_cost_cd" value="<%=lgs_cost_cd%>"></td>
						<td width="30">VVD</td>
						<td width="120"><input type="text" style="width:90" name="vvd" value="<%=vvd%>"></td>
					</tr>
				</table>


				<table class="height_5"><tr><td></td></tr></table>
				<!-- : ( Speed ) (S) -->
                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet');</script>
                        </td></tr>
                    </table>
				<!-- : ( Speed ) (E) -->
					<!-- : ( Button : Sub ) (S) -->
					<table width="100%" class="button">
							       	<tr><td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
									<tr>

										<!-- Repeat Pattern -->
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2" name="btng_rowadd" id="btng_rowadd">Row Add</td>
										<td class="btn2_right"></td></tr></table></td>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2" name="btn_ok" id="btn_ok">Ok</td>
										<td class="btn2_right"></td></tr></table></td>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2" name="btn_close" id="btn_close">Close</td>
										<td class="btn2_right"></td></tr></table></td>
										<!-- Repeat Pattern -->


									</tr></table>
								</td></tr>
							</table>
	    	<!-- : ( Button : Sub ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->

</td></tr>
</table> --%>
<!-- OUTER - POPUP (E)nd -->

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>R/H Volume Adjustment</span></h2>
		
		<div class="opus_design_btn">
			<!-- <button type="button" class="btn_normal" name="btng_rowadd" id="btng_rowadd">Row Add</button> -->
			<button type="button" class="btn_normal" name="btn_ok" id="btn_ok">Ok</button>
			<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table class="search" border="0" style="width:362;">
					<tr class="h23">
						<td width="65">Cost Code</td>
						<td width="147"><input type="text" style="width:90" name="lgs_cost_cd" value="<%=lgs_cost_cd%>"></td>
						<td width="30">VVD</td>
						<td width="120"><input type="text" style="width:90" name="vvd" value="<%=vvd%>"></td>
					</tr>
				</table>
			</div>
		</div>
	<div class="wrap_result">
		<div class="opus_design_grid clear">
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btng_rowadd" 		id="btng_rowadd">Row Add</button>
			</div>
			<script type="text/javascript">ComSheetObject('sheet');</script>
		</div>
	</div>
</div>

</form>
<!-- </body>
</html> -->