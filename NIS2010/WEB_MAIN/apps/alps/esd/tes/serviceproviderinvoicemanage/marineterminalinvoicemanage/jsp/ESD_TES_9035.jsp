<%--
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESD_TES_9035.jsp
*@FileTitle : R/H Volume Adjustment PopUp 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2015-02-10
*@LastModifier : 9014987
*@LastVersion : 1.0
* 2015-02-10 9014987
* 1.0 최초 생성
* 2015-04-01 [CHM-201534782] R/H Volume Ahjustment pop-up에 TPSZ 별 검색조건 추가
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%
	String tml_inv_tp_cd	 = request.getParameter("tml_inv_tp_cd"		)!=null&&!request.getParameter("tml_inv_tp_cd"		).equals("")?request.getParameter("tml_inv_tp_cd" 		):"";
	String tml_so_ofc_cty_cd = request.getParameter("tml_so_ofc_cty_cd"	)!=null&&!request.getParameter("tml_so_ofc_cty_cd"	).equals("")?request.getParameter("tml_so_ofc_cty_cd" 	):"";
	String tml_so_seq		 = request.getParameter("tml_so_seq"		)!=null&&!request.getParameter("tml_so_seq"			).equals("")?request.getParameter("tml_so_seq"			):"";
	String vndr_seq			 = request.getParameter("vndr_seq"			)!=null&&!request.getParameter("vndr_seq"			).equals("")?request.getParameter("vndr_seq"			):"";
	String yd_cd			 = request.getParameter("yd_cd"				)!=null&&!request.getParameter("yd_cd"				).equals("")?request.getParameter("yd_cd"				):"";
	String yd_nm			 = request.getParameter("yd_nm"				)!=null&&!request.getParameter("yd_nm"				).equals("")?request.getParameter("yd_nm"				):"";
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
	String dcgo_ind_cd		 = request.getParameter("dcgo_ind_cd"		)!=null&&!request.getParameter("dcgo_ind_cd"		).equals("")?request.getParameter("dcgo_ind_cd"			):"";
	String tml_wrk_dy_cd 	 = request.getParameter("tml_wrk_dy_cd"		)!=null&&!request.getParameter("tml_wrk_dy_cd"		).equals("")?request.getParameter("tml_wrk_dy_cd"		):"";
	String tml_trns_mod_cd 	 = request.getParameter("tml_trns_mod_cd"	)!=null&&!request.getParameter("tml_trns_mod_cd"	).equals("")?request.getParameter("tml_trns_mod_cd"		):"";
	String rvis_div			 = request.getParameter("rvis_div"			)!=null&&!request.getParameter("rvis_div"			).equals("")?request.getParameter("rvis_div"			):"";
	String vol_tr_ut_cd		 = request.getParameter("vol_tr_ut_cd"		)!=null&&!request.getParameter("vol_tr_ut_cd"		).equals("")?request.getParameter("vol_tr_ut_cd"		):"";
	String calc_tp_cd		 = request.getParameter("calc_tp_cd"		)!=null&&!request.getParameter("calc_tp_cd"			).equals("")?request.getParameter("calc_tp_cd"			):"";
	String tml_so_dtl_seq 	 = request.getParameter("tml_so_dtl_seq"	)!=null&&!request.getParameter("tml_so_dtl_seq"		).equals("")?request.getParameter("tml_so_dtl_seq" 		):"";
	String ctrt_rt			 = request.getParameter("ctrt_rt"			)!=null&&!request.getParameter("ctrt_rt"			).equals("")?request.getParameter("ctrt_rt"				):"";
	String page_rows		 = request.getParameter("page_rows"			)!=null&&!request.getParameter("page_rows"			).equals("")?request.getParameter("page_rows"			):"";
	String tml_crr_cd		 = request.getParameter("tml_crr_cd"		)!=null&&!request.getParameter("tml_crr_cd"			).equals("")?request.getParameter("tml_crr_cd"			):"";
	String edi_so_dtl_id  	 = request.getParameter("edi_so_dtl_id"		)!=null&&!request.getParameter("edi_so_dtl_id"		).equals("")?request.getParameter("edi_so_dtl_id"		):"";
	String atb_dt		  	 = request.getParameter("atb_dt"			)!=null&&!request.getParameter("atb_dt"				).equals("")?request.getParameter("atb_dt"				):"";
	String cntr_no		  	 = request.getParameter("cntr_cd"			)!=null&&!request.getParameter("cntr_no"			).equals("")?request.getParameter("cntr_no"				):"";
	String edi_flg		  	 = request.getParameter("edi_flg"			)!=null&&!request.getParameter("edi_flg"			).equals("")?request.getParameter("edi_flg"				):"";
	String rf_mntr_dys  	 = request.getParameter("rf_mntr_dys"		)!=null&&!request.getParameter("rf_mntr_dys"		).equals("")?request.getParameter("rf_mntr_dys"		    ):"";
	String rc_flg			 = request.getParameter("rc_flg"			)!=null&&!request.getParameter("rc_flg"				).equals("")?request.getParameter("rc_flg"				):"";
%><html>
<head>
<title>Welcome to ALPS!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage(){
        loadPage();
    }
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="tml_inv_tp_cd"	 		 value="<%=tml_inv_tp_cd	  %>">
<input type="hidden" name="tml_so_ofc_cty_cd"	 	 value="<%=tml_so_ofc_cty_cd  %>">
<input type="hidden" name="tml_so_seq"				 value="<%=tml_so_seq		  %>">
<input type="hidden" name="vndr_seq"				 value="<%=vndr_seq			  %>">
<%-- <input type="hidden" name="yd_cd"					 value="<%=yd_cd			  %>"> --%>
<input type="hidden" name="vvd"						 value="<%=vvd				  %>">
<%-- <input type="hidden" name="lgs_cost_cd"				 value="<%=lgs_cost_cd	      %>"> --%>
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
<input type="hidden" name="page_rows"				 value="<%=page_rows		  %>">
<input type="hidden" name="tml_crr_cd"				 value="<%=tml_crr_cd		  %>">
<input type="hidden" name="edi_so_dtl_id"		     value="<%=edi_so_dtl_id      %>">
<input type="hidden" name="atb_dt"			 		 value="<%=atb_dt    		  %>">
<input type="hidden" name="cntr_no"			 		 value="<%=cntr_no    		  %>">
<input type="hidden" name="rf_mntr_dys"			     value="<%=rf_mntr_dys  	  %>">
<input type="hidden" name="rc_flg"			    	 value="<%=rc_flg  	  %>">
<input type="hidden" name="search_bkg_no">
<input type="hidden" name="rowId">

<!-- ADD -->
<input type="hidden" name="yn">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;R/H Volume Adjustment</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<table class="search">
	       		<tr><td class="bg">
					<!-- biz_1  (S) -->
					<table border="0">
					<tr class="h23">
						<td width="50">VVD CD</td>
						<td width="160">
							<input type="text" style="width:40;" class="input1" name="vsl_cd" required fullfill caption="Vessel Code" maxlength="4" dataformat="engup"  style="ime-mode:disabled" value="<%=vvd.substring(0, 4)%>" readonly>
							<input type="text" style="width:38;" class="input1" name="skd_voy_no" required fullfill caption="Schedule Voyage Number" maxlength="4" dataformat="engup" style="ime-mode:disabled" value="<%=vvd.substring(4, 8)%>" readonly>
							<input type="text" style="width:22;" class="input1" name="skd_dir_cd" caption="Schedule Direction Code" maxlength="1" dataformat="engup" style="ime-mode:disabled" value="<%=vvd.substring(8, 9)%>" readonly>
						</td>
						<td width="30">Port<!-- Port --></td>
						<td width="100">
							<input type="text" style="width:80;" class="input1" name="yd_cd" required fullfill caption="yard Code" dataformat="engup"  style="ime-mode:disabled" value="<%=yd_cd%>" title="<%=yd_nm%>" readonly>
						</td>
						<td width="70">Cost Code<!-- Port --></td>
						<td width="100">
							<input type="text" style="width:80;" class="input1" name="lgs_cost_cd" required fullfill caption="lag_cost_cd" dataformat="engup"  style="ime-mode:disabled" value="<%=lgs_cost_cd%>" readonly>
						</td>
						<td width="50">TP/SZ</td>
						<td width="100">
							<script language="javascript">ComComboObject('tpsz_cd', 1, 71, 1, 1)</script>
						</td>	
						<td width="80">Full/Empty</td>
						<td>
							FL<input type="checkbox" name="fm_full" class="trans" checked="checked">
							MT<input type="checkbox" name="fm_empty" class="trans" checked="checked">
						</td>
					</tr>
					</table>
					<!-- biz_1  (E) -->	
				</td></tr>
			</table>
			
			<table class="height_8"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
				<!-- : ( Speed ) (S) -->
                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet');</script>
                        </td></tr>
                    </table>
				<!-- : ( Speed ) (E) -->
					<!-- : ( Button : Sub ) (S) -->
				<table width="100%" class="sbutton">
	       				<tr><td class="align">
						<table class="sbutton">
			    			<tr>
			    				<td class="bt">
			    				<%if(rvis_div!=null && !rvis_div.trim().equals("")){ %>
			    					<%if(edi_flg.equalsIgnoreCase("Y")){ %>
				    					<img src="/hanjin/img/button/btng_rowdel.gif" width="65" height="19" border="0">
				    					<img src="/hanjin/img/button/btng_rowadd.gif" width="65" height="19" border="0">
			    					<%} else {%>
				    					<img class="cursor" src="/hanjin/img/button/btng_rowdel.gif" width="65" height="19" border="0" name="btn_rowdel">
				    					<img class="cursor" src="/hanjin/img/button/btng_rowadd.gif" width="65" height="19" border="0" name="btng_rowadd">
				    				<%} %>
			    				<%} %>
			    				</td>
							</tr>
						</table>
					</td></tr>
				</table>
	    	<!-- : ( Button : Sub ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->

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
						<tr><td class="btn1_left"></td>
						<%if(edi_flg.equalsIgnoreCase("Y")){ %>
	    					<td class="btn1">Retrieve</td>
    					<%} else {%>
	    					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
	    				<%} %>
						<td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<%if(edi_flg.equalsIgnoreCase("Y")){ %>
								<!-- <td class="btn1">Ok</td> -->
								<td class="btn1" name="btn_ok" id="btn_ok">Ok</td>
							<%} else {%>
								<td class="btn1" name="btn_ok" id="btn_ok">Ok</td>
							<%} %>
							<td class="btn1_right"></td></tr></table></td>
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
