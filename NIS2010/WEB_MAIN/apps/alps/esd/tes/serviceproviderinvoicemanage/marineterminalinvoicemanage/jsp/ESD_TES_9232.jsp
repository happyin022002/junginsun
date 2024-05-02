<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_9232.jsp
*@FileTitle : TES 3rd Party Billing Input Popup화면-Marine Terminal Invoice
*Open Issues :
*Change history :
*@LastModifyDate : 2007-03-01
*@LastModifier : kimjinjoo
*@LastVersion : 1.0
* 2007-03-01 kimjinjoo
* 1.0 최초 생성
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%
	String calc_cost_grp_cd	 = request.getParameter("calc_cost_grp_cd"	)!=null&&!request.getParameter("calc_cost_grp_cd"	).equals("")?request.getParameter("calc_cost_grp_cd" 	):"";
	String tml_inv_tp_cd	 = request.getParameter("tml_inv_tp_cd"		)!=null&&!request.getParameter("tml_inv_tp_cd"		).equals("")?request.getParameter("tml_inv_tp_cd" 		):"";
	String tml_so_ofc_cty_cd = request.getParameter("tml_so_ofc_cty_cd"	)!=null&&!request.getParameter("tml_so_ofc_cty_cd"	).equals("")?request.getParameter("tml_so_ofc_cty_cd" 	):"";
	String tml_so_seq		 = request.getParameter("tml_so_seq"		)!=null&&!request.getParameter("tml_so_seq"			).equals("")?request.getParameter("tml_so_seq"			):"";
	String tml_so_dtl_seq 	 = request.getParameter("tml_so_dtl_seq"	)!=null&&!request.getParameter("tml_so_dtl_seq"		).equals("")?request.getParameter("tml_so_dtl_seq" 		):"";
	String inv_ofc_cd		 = request.getParameter("inv_ofc_cd"		)!=null&&!request.getParameter("inv_ofc_cd"			).equals("")?request.getParameter("inv_ofc_cd"			):"";
	String vndr_seq			 = request.getParameter("vndr_seq"			)!=null&&!request.getParameter("vndr_seq"			).equals("")?request.getParameter("vndr_seq"			):"";
	String yd_cd			 = request.getParameter("yd_cd"				)!=null&&!request.getParameter("yd_cd"				).equals("")?request.getParameter("yd_cd"				):"";
	String inv_no			 = request.getParameter("inv_no"			)!=null&&!request.getParameter("inv_no"				).equals("")?request.getParameter("inv_no"				):"";
	String err_inv_no		 = request.getParameter("err_inv_no"		)!=null&&!request.getParameter("err_inv_no"			).equals("")?request.getParameter("err_inv_no"			):"";
	String curr_cd			 = request.getParameter("curr_cd"			)!=null&&!request.getParameter("curr_cd"			).equals("")?request.getParameter("curr_cd"				):"";
	String vvd			 	 = request.getParameter("vvd"				)!=null&&!request.getParameter("vvd"				).equals("")?request.getParameter("vvd"					):"";
	String calc_tp_cd	     = request.getParameter("calc_tp_cd"		)!=null&&!request.getParameter("calc_tp_cd"			).equals("")?request.getParameter("calc_tp_cd"			):"";
	String lgs_cost_cd	     = request.getParameter("lgs_cost_cd"		)!=null&&!request.getParameter("lgs_cost_cd"		).equals("")?request.getParameter("lgs_cost_cd"			):"";
	String cntr_tpsz_cd		 = request.getParameter("cntr_tpsz_cd"		)!=null&&!request.getParameter("cntr_tpsz_cd"		).equals("")?request.getParameter("cntr_tpsz_cd"		):"";
	String io_bnd_cd		 = request.getParameter("io_bnd_cd"			)!=null&&!request.getParameter("io_bnd_cd"			).equals("")?request.getParameter("io_bnd_cd"			):"";
	String ioc_cd			 = request.getParameter("ioc_cd"			)!=null&&!request.getParameter("ioc_cd"				).equals("")?request.getParameter("ioc_cd"				):"";
	String lane_cd			 = request.getParameter("lane_cd"			)!=null&&!request.getParameter("lane_cd"			).equals("")?request.getParameter("lane_cd"				):"";
	String cal_vol			 = request.getParameter("cal_vol"			)!=null&&!request.getParameter("cal_vol"			).equals("")?request.getParameter("cal_vol"				):"";
	String opener_row  		 = request.getParameter("opener_row"		)!=null&&!request.getParameter("opener_row" 		).equals("")?request.getParameter("opener_row"			):"";
	String rvis_vol_qty  	 = request.getParameter("rvis_vol_qty"		)!=null&&!request.getParameter("rvis_vol_qty"		).equals("")?request.getParameter("rvis_vol_qty"		):"";
	String inv_amt		  	 = request.getParameter("inv_amt"			)!=null&&!request.getParameter("inv_amt"			).equals("")?request.getParameter("inv_amt"				):"";
	String fm_tr_vol_val  	 = request.getParameter("fm_tr_vol_val"		)!=null&&!request.getParameter("fm_tr_vol_val"		).equals("")?request.getParameter("fm_tr_vol_val"		):"";
	String to_tr_vol_val  	 = request.getParameter("to_tr_vol_val"		)!=null&&!request.getParameter("to_tr_vol_val"		).equals("")?request.getParameter("to_tr_vol_val"		):"";
	String dcgo_ind_cd  	 = request.getParameter("dcgo_ind_cd"		)!=null&&!request.getParameter("dcgo_ind_cd"	  	).equals("")?request.getParameter("dcgo_ind_cd"			):"";
	String tml_wrk_dy_cd  	 = request.getParameter("tml_wrk_dy_cd"		)!=null&&!request.getParameter("tml_wrk_dy_cd"		).equals("")?request.getParameter("tml_wrk_dy_cd"		):"";
	String tml_trns_mod_cd 	 = request.getParameter("tml_trns_mod_cd"	)!=null&&!request.getParameter("tml_trns_mod_cd"	).equals("")?request.getParameter("tml_trns_mod_cd"		):"";
	String acct_cd			 = request.getParameter("acct_cd"			)!=null&&!request.getParameter("acct_cd"			).equals("")?request.getParameter("acct_cd"				):"";
	String ctrt_rt			 = request.getParameter("ctrt_rt"			)!=null&&!request.getParameter("ctrt_rt"			).equals("")?request.getParameter("ctrt_rt"				):"";
	String inv_xch_rt		 = request.getParameter("inv_xch_rt"		)!=null&&!request.getParameter("inv_xch_rt"			).equals("")?request.getParameter("inv_xch_rt"			):"";
	String tml_crr_cd		 = request.getParameter("tml_crr_cd"		)!=null&&!request.getParameter("tml_crr_cd"			).equals("")?request.getParameter("tml_crr_cd"			):"";
	String n3rd_page_rows  	 = request.getParameter("n3rd_page_rows"	)!=null&&!request.getParameter("n3rd_page_rows"	  	).equals("")?request.getParameter("n3rd_page_rows"		):"";
	%>
<html>
<head>
<title>TES 3rd Party Billing Input Popup화면-Marine Terminal Invoice </title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
<%= JSPUtil.getIBCodeCombo("combo01", "01", "CD00583", 0, "")%>
	function setupPage(){
		loadPage();
	}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="calc_cost_grp_cd"	 	 value="<%=calc_cost_grp_cd	%>">
<input type="hidden" name="tml_inv_tp_cd"	 		 value="<%=tml_inv_tp_cd	%>">
<input type="hidden" name="tml_so_ofc_cty_cd"	 	 value="<%=tml_so_ofc_cty_cd%>">
<input type="hidden" name="tml_so_seq"				 value="<%=tml_so_seq		%>">
<input type="hidden" name="tml_so_dtl_seq"		 	 value="<%=tml_so_dtl_seq	%>">
<input type="hidden" name="inv_ofc_cd"				 value="<%=inv_ofc_cd		%>">
<input type="hidden" name="inv_no"					 value="<%=inv_no			%>">
<input type="hidden" name="err_inv_no"				 value="<%=err_inv_no		%>">
<input type="hidden" name="vndr_seq"				 value="<%=vndr_seq			%>">
<input type="hidden" name="yd_cd"					 value="<%=yd_cd			%>">
<input type="hidden" name="curr_cd"					 value="<%=curr_cd			%>">
<input type="hidden" name="vvd"					 	 value="<%=vvd				%>">
<input type="hidden" name="calc_tp_cd"				 value="<%=calc_tp_cd	    %>">
<input type="hidden" name="lgs_cost_cd"				 value="<%=lgs_cost_cd	    %>">
<input type="hidden" name="cntr_tpsz_cd"			 value="<%=cntr_tpsz_cd		%>">
<input type="hidden" name="io_bnd_cd"				 value="<%=io_bnd_cd		%>">
<input type="hidden" name="ioc_cd"					 value="<%=ioc_cd			%>">
<input type="hidden" name="lane_cd"					 value="<%=lane_cd			%>">
<input type="hidden" name="cal_vol"					 value="<%=cal_vol			%>">
<input type="hidden" name="rvis_vol_qty"			 value="<%=rvis_vol_qty		%>">
<input type="hidden" name="inv_amt"					 value="<%=inv_amt			%>">
<input type="hidden" name="fm_tr_vol_val"			 value="<%=fm_tr_vol_val  	%>">
<input type="hidden" name="to_tr_vol_val"			 value="<%=to_tr_vol_val  	%>">
<input type="hidden" name="dcgo_ind_cd"			 	 value="<%=dcgo_ind_cd  	%>">
<input type="hidden" name="tml_wrk_dy_cd"			 value="<%=tml_wrk_dy_cd  	%>">
<input type="hidden" name="tml_trns_mod_cd"			 value="<%=tml_trns_mod_cd 	%>">
<input type="hidden" name="opener_row"				 value="<%=opener_row  		%>">
<input type="hidden" name="acct_cd"			 		 value="<%=acct_cd			%>">
<input type="hidden" name="ctrt_rt"			 		 value="<%=ctrt_rt			%>">
<input type="hidden" name="inv_xch_rt"			 	 value="<%=inv_xch_rt		%>">
<input type="hidden" name="tml_crr_cd"				 value="<%=tml_crr_cd		%>">
<input type="hidden" name="n3rd_page_rows"			 value="<%=n3rd_page_rows  	%>">
<input type="hidden" name="n3pty_bil_cs_cd" 		 value="">

<!-- 2009 10 7 추가 -->
<input type="hidden" name="del_if_seq"			value="">
<input type="hidden" name="flg_yn"			 	value="">
<!-- <input type="hidden" name="del_cntr_seq" 	value=""> -->

<!-- TPB I/F TPB Use BillingCase Code Get Temp ( 2009-09-18 ) -->
<input type="hidden" name="n3pty_bil_tp_cd_tmp"  value="">

<table width="800" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;3rd Party Interface</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Year ) (S) -->
				<table class="search" border="0">
				<tr class="h23">
					<td width="10%">Source No.</td>
					<td><input type="text" readOnly style="width:80" value="<%=inv_no%>"></td></tr>
				</table>
				<!-- : ( Year ) (E) -->

			</td></tr>
		</table>
		<!-- : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Grid ) (S) -->
                <table width="100%" id="mainTable">
                    <tr><td>
                         <script language="javascript">ComSheetObject('sheet');</script>
                    </td></tr>
                </table>
				<!-- : ( Grid ) (E) -->

			</td></tr>
		</table>
		<!-- : ( Search Options ) (E) -->

</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->



<table class="height_10"><tr><td></td></tr></table>


<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
		<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	       		<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>

					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_ok" id="btn_ok">Ok</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr>
			</table>

		</td></tr>
</table>

<!-- : ( Button : Sub ) (E) -->

</form>
</body>
</html>

