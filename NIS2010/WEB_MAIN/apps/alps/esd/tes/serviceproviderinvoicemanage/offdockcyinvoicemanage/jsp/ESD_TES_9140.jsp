<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";								 //에러메세지
	
	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	
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
<html>
<head>
<title>Get CNTR List Pop Up</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

</head>

<body onLoad="setupPage();">
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
<input type="hidden" name="resultStr" value="">        
<input type="hidden" value="BackEndJobResultJSP">
 

<!-- OUTER - POPUP (S)tart -->
<table width="600" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S)
		<table width="100%" border="0" class="search">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;File Import</td></tr>
		<tr>
			<td class="title" width="25%">&nbsp;&nbsp;&nbsp;<span title='It is possible to input the CNTR No. manually by selecting YES'>Manual Input</span></td>
			<td class="stm">
				<input type="radio" name="manual_input_yn" value="Y"  class="trans">Yes&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="manual_input_yn" value="N"  class="trans">No
			</td>
		</tr>
		</table> -->
		
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Get CNTR List</td></tr>
		</table>
		
		
		<!-- table width="580" border="0">
		<tr>
			<td class="title" width="25%">&nbsp;&nbsp;&nbsp;<span title='It is possible to input the CNTR No. manually by selecting YES'>Manual Input</span></td>
			<td class="h23">
				<input type="radio" name="manual_input_yn" value="Y"  class="trans">Yes&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="manual_input_yn" value="N"  class="trans">No
			</td>
		</tr>
		</table-->
		

		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_loadexcel" id="btn_loadexcel">Load Excel</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->
		
     	<table width="580" border="0" class="search">
       	<tr><td class="bg">
				<table class="search" border="0">
					<tr class="h23">
						<td width="30%">Manual Input</td>
						<td class="stm">
							<input type="radio" name="manual_input_yn" value="Y"  class="trans" >Yes&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="manual_input_yn" value="N"  class="trans">No
						</td>
					</tr>
				</table>
			</td></tr>
		</table>

		<table class="height_10"><tr><td></td></tr></table>
						
		<!-- : ( Title ) (E) -->


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



				<div id="main_hidden_sheets" style="display:none;">
				<!--// HIDDEN SHEET : header 정보 임시 보관용 //-->
				<script language="javascript">ComSheetObject('main_hidden');</script>
				</div>

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->




</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->



<table class="height_10"><tr><td></td></tr></table>


<!-- : ( Button : Sub ) (S) -->
<table width="600" class="sbutton">
		<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	       		<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>
					<!-- Repeat Pattern -->
					<!-- CHM-201641075 Get CNTR List화면에서 Multi-Row Add기능 추가 -->
					<td><table border="0" cellpadding="0" cellspacing="0">
						<tr><td><input type="text" name="rowsadd" size="2" value="1" maxlength="4"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_rowadd" id="btn_rowadd">Row Add</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_chkdigit" id="btn_chkdigit">CHK Digit</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_verify" id="btn_verify">Verify</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->
				</tr>
			</table>

		</td></tr>
	</table>
<!-- : ( Button : Sub ) (E) -->

	</form>



</body>

</html>
