<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0023.jsp
*@FileTitle :More Candidates
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-21
*@LastModifier : poong_yeon
*@LastVersion : 1.0
* 2006-11-21 poong_yeon
* 1.0 최초 생성
=========================================================*/
--%>



<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Vector"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.event.EsdTrs0921Event"%>
<%@ page import = "com.hanjin.framework.component.util.StringUtil"%>
<%



	EsdTrs0921Event  			event 			= null;		//PDTO(Data Transfer Object including Parameters)
	Exception 					serverException	= null;		//서버에서 발생한 에러
	DBRowSet 					rowSet	 		= null;		//DB ResultSet
	String 						strErrMsg 		= "";		//에러메세지
	int 						rowCount	 	= 0;		//DB ResultSet 리스트의 건수

	String 						userId			= "";
	String 						ofcId 			= "";

	String targetRow 			= null;
	String trsp_so_ofc_cty_cd  	= null;
	String trsp_so_seq         	= null;
	String ctrl_ofc_cd    	    = null;
	String vndr_seq       	    = null;
	String basis_dt       	    = null;
	String eq_knd_cd		    = null;
	String eq_tp_sz_cd    	    = null;
	String cmb_tp_cd      	    = null;
	String cgo_tp_cd    	    = null;
	String bound_cd       	    = null;
	String crr_mod_cd     	    = null;
	String cost_mod_cd    	    = null;
	String cust_cnt_cd		    = null;
	String cust_seq       	    = null;
	String cmdt_cd        	    = null;

	String from_nod_cd    	    = null;
	String from_loc    	    	= null;
	String from_yard    	    = null;

	String via_nod_cd     	    = null;
	String via_loc     	    	= null;
	String via_yard     	    = null;

	String door_nod_cd    	    = null;
	String door_loc    	    	= null;
	String door_zone    	    = null;

	String to_nod_cd      	    = null;
	String to_loc      	    	= null;
	String to_yard      	    = null;

	String bundle_cnt 		    = null;
	String wgt_uom    		    = null;
	String wgt_qty        	    = null;
	String dist_km			    = null;
	String dist_mile			= null;

	String single_multi_sep     = null;
	
	
	String spot_bid_no			= null;
	String spot_bid_win_vndr_seq= null;
	String spot_bid_sel_row		= null;
	String more_bid_read_only	= null;
	

	try {

	   SignOnUserAccount account	= (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   userId						= account.getUsr_id();
	   ofcId						= account.getOfc_cd();
	   //userAuth=account.getAuth();

       targetRow           = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("targetRow")         ));
       trsp_so_ofc_cty_cd  = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("trsp_so_ofc_cty_cd")));
       trsp_so_seq         = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("trsp_so_seq")       ));
       ctrl_ofc_cd         = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("ctrl_ofc_cd")       ));
       vndr_seq            = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("vndr_seq")          ));
       basis_dt            = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("basis_dt")          ));
       eq_knd_cd           = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("eq_knd_cd")         ));
       eq_tp_sz_cd         = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("eq_tp_sz_cd")       ));
       cmb_tp_cd           = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("cmb_tp_cd")         ));
       cgo_tp_cd           = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("cgo_tp_cd")         ));
       bound_cd            = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("bound_cd")          ));
       crr_mod_cd          = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("crr_mod_cd")        ));
       cost_mod_cd         = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("cost_mod_cd")       ));
       cust_cnt_cd         = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("cust_cnt_cd")       ));
       cust_seq            = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("cust_seq")          ));
       cmdt_cd             = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("cmdt_cd")           ));
       from_nod_cd         = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("from_nod_cd")       ));
       via_nod_cd          = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("via_nod_cd")        ));
       door_nod_cd         = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("door_nod_cd")       ));
       to_nod_cd           = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("to_nod_cd")         ));
       bundle_cnt          = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("bundle_cnt")        ));
       wgt_uom             = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("wgt_uom")           ));
       wgt_qty             = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("wgt_qty")           ));
       dist_km             = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("dist_km")           ));
       dist_mile           = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("dist_mile")         ));
	   single_multi_sep    = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("single_multi_sep")  ));
	   
	   
	   spot_bid_no			= JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("spot_bid_no")  ));
	   spot_bid_win_vndr_seq= JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("spot_bid_win_vndr_seq")  ));
	   spot_bid_sel_row		= JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("spot_bid_sel_row")  ));
	   more_bid_read_only	= JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("more_bid_read_only")  ));

	    if ( !"".equals(from_nod_cd) && from_nod_cd.length() == 7){
	    	from_loc	= from_nod_cd.substring(0,5);
	    	from_yard	= from_nod_cd.substring(5,7);
	    }else{
	    	from_loc	= "";
	    	from_yard	= "";
	    }

	    if (!"".equals(via_nod_cd) && via_nod_cd.length() == 7){
	    	via_loc		= via_nod_cd.substring(0,5);
	    	via_yard	= via_nod_cd.substring(5,7);
	    }else{
	    	via_loc		= "";
	    	via_yard	= "";
	    }

	    if ( !"".equals(door_nod_cd) && door_nod_cd.length() == 7){
	    	door_loc	= door_nod_cd.substring(0,5);
	    	door_zone	= door_nod_cd.substring(5,7);
	    }else{
	    	door_loc	= "";
	    	door_zone	= "";
	    }

	    if ( !"".equals(to_nod_cd) && to_nod_cd.length() == 7){
	    	to_loc		= to_nod_cd.substring(0,5);
	    	to_yard		= to_nod_cd.substring(5,7);
	    }else{
	    	to_loc		= "";
	    	to_yard		= "";
	    }

		event 				= (EsdTrs0921Event)request.getAttribute("Event");
		serverException 	= (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>More Bidder</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

	<%//= JSPUtil.getIBCodeCombo("wy_type", "", "CD00929", 0, "")%>

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="usr_id" 				value="<%=userId%>"				>
<input type="hidden" name="ofc_cd" 				value="<%=ofcId%>"				>
<input type="hidden" name="targetRow" 			value="<%=targetRow%>"			>

<input type="hidden" name="trsp_so_ofc_cty_cd" 	value="<%=trsp_so_ofc_cty_cd%>"	>
<input type="hidden" name="trsp_so_seq" 		value="<%=trsp_so_seq%>"		>
<input type="hidden" name="ctrl_ofc_cd" 		value="<%=ctrl_ofc_cd%>"		>
<input type="hidden" name="vndr_seq" 			value="<%=vndr_seq%>"			>
<input type="hidden" name="basis_dt" 			value="<%=basis_dt%>"			>
<input type="hidden" name="eq_knd_cd" 			value="<%=eq_knd_cd%>"			>
<input type="hidden" name="eq_tp_sz_cd" 		value="<%=eq_tp_sz_cd%>"		>
<input type="hidden" name="cmb_tp_cd" 			value="<%=cmb_tp_cd%>"			>
<input type="hidden" name="cgo_tp_cd" 			value="<%=cgo_tp_cd%>"			>
<input type="hidden" name="bound_cd" 			value="<%=bound_cd%>"			>
<input type="hidden" name="crr_mod_cd" 			value="<%=crr_mod_cd %>"		>
<input type="hidden" name="cost_mod_cd" 		value="<%=cost_mod_cd%>"		>
<input type="hidden" name="cust_cnt_cd" 		value="<%=cust_cnt_cd%>"		>
<input type="hidden" name="cust_seq" 			value="<%=cust_seq%>"			>
<input type="hidden" name="cmdt_cd" 			value="<%=cmdt_cd%>"			>
<input type="hidden" name="from_nod_cd" 		value="<%=from_nod_cd%>"		>
<input type="hidden" name="via_nod_cd" 			value="<%=via_nod_cd%>"			>
<input type="hidden" name="door_nod_cd" 		value="<%=door_nod_cd%>"		>
<input type="hidden" name="to_nod_cd" 			value="<%=to_nod_cd%>"			>
<input type="hidden" name="bundle_cnt" 			value="<%=bundle_cnt%>"			>
<input type="hidden" name="wgt_uom" 			value="<%=wgt_uom%>"			>
<input type="hidden" name="wgt_qty" 			value="<%=wgt_qty%>"			>
<input type="hidden" name="dist_km" 			value="<%=dist_km%>"			>
<input type="hidden" name="dist_mile" 			value="<%=dist_mile%>"			>
<input type="hidden" name="single_multi_sep"    value="<%=single_multi_sep%>"   >

<input type="hidden" name="spot_bid_no"				value="<%=spot_bid_no%>"			>
<input type="hidden" name="spot_bid_win_vndr_seq"	value="<%=spot_bid_win_vndr_seq%>"	>
<input type="hidden" name="spot_bid_sel_row"		value="<%=spot_bid_sel_row%>"		>
<input type="hidden" name="more_bid_read_only"		value="<%=more_bid_read_only%>"		>

<!-- OUTER - POPUP (S)tart -->
<table width="600" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; More Bidder</td></tr>
		</table>
		<!-- : ( Title ) (E) -->


		<!-- : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Node / Link ) (S) -->
                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet');</script>
                        </td></tr>
                    </table>
				<!-- : ( Node / Link ) (E) -->


			</td></tr>
		</table>
		<!-- : ( Search Options ) (E) -->



</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->






<table class="height_5"><tr><td></td></tr></table>

<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>

				<!-- Repeat Pattern -->
<% if (!more_bid_read_only.trim().equals("Y") ) { %>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_apply" id="btn_apply">Apply</td><td class="btn1_right"></td></tr></table></td>

				<td class="btn1_line"></td>
<% } %>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
				<!-- Repeat Pattern -->

			</tr>
			</table>

	</td></tr>
	</table>
</table>
<!-- : ( Button : Sub ) (E) -->



</form>

</body>
</html>