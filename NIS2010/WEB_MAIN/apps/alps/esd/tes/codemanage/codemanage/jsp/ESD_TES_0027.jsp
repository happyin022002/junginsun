<!--%/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_027.jsp
*@FileTitle : Cost Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-01
*@LastModifier : jongbaemoon
*@LastVersion : 1.0
* 2006-09-01 jongbaemoon
* 1.0 최초 생성
=========================================================*/%-->
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tes.codemanage.codemanage.event.EsdTes0027Event"%>
<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";								 //에러메세지
	
	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	} catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Cost Code Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
<!--		
	function setupPage(){		
	    var errMessage = "<%=strErrMsg%>";
	    if (errMessage.length >= 1) {
	    	ComShowMessage(errMessage);
	    }

		loadPage();	
	}
	
//-->
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="gb" value="ADD">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->




		<!-- TABLE '#D' : ( Search Options :  ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
				<!-- : ( Week ) (S) -->
				<table class="search_in" border="0">

				<tr class="h23">
					<td width="10%"><img class="nostar">Cost Code</td>
					<td width="18%"><input type="text" name="lgs_cost_cd" maxlength="6" style="width:100" class="input1" value="" onKeyUp="autowrite();"></td>
					<td width="13%"><img class="nostar">Full Name</td>
					<td width="69%" colspan="3"><input class="input1" name="lgs_cost_full_nm" maxlength="50" type="text" style="width:526" value="" onKeyUp="syncData(this);"></td>
				</tr>
				<tr class="h23">
					<td width="10%"><img class="nostar">Abbr. Name</td>
					<td width="18%"><input class="input1" name="lgs_cost_abbr_nm" maxlength="20" type="text" style="width:100" value="" onKeyUp="syncData(this);"></td>
					<td width="13%"><img class="nostar">Output Sequence</td>
					<td width="15%"><input class="input1" name="lgs_cost_opt_no" maxlength="4" type="text" style="width:60" value="" onKeyUp="syncData(this);"></td>
					<td width="11%"><img class="nostar">SML Acct. CD</td>
					<td class="stm">SML <script language="javascript">ComComboObject('acct_cd', 1, 90, 1, 1)</script>
						&nbsp;&nbsp;
						Other Carriers <select name="crr_acct_cd" style="width:60;" onChange="syncData(this);">&nbsp;
						<option value="110911">110911</option>
						<option value="512019">512019</option>
						<option value="512029">512029</option>
						<option value="512039">512039</option>
						<option value="512069">512069</option>
						<option value="512071">512071</option>
						<option value="512119">512119</option>
						<option value="512229">512229</option>
						<option value="512429">512429</option>
						</select></td>
				</tr>
				</table>
				<!-- : ( Week ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Search Options : Detail Explanation ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( BKG Information ) (S) -->
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Detail Explanation</td></tr>
				<tr><td class="height_5"></td></tr>
				</table>

				<table border="0" class="search">
				<tr>
					<td><textarea name="lgs_cost_rmk" style="width:975; height:200;" onKeyUp="syncDataRmk(this);"></textarea></td></tr>
				</table>
				<!-- : ( BKG Information ) (E) -->

				<table class="height_5"><tr><td></td></tr></table>

				<!-- : ( Week ) (S) -->
				<table class="search_in" border="0">

				<tr class="h23">
					<td width="9%"><img class="nostar">Cost Class</td>
					<td width="28%"><input type="text" name="lgs_cost_cd_clss_lvl" style="width:130" value="" readonly></td>
					<td width="12%">Subject Code</td>
					<td width="27%"><input type="text" name="lgs_cost_subj_cd" maxlength="2" style="width:130" value="" readonly></td>
					<td width="10%">Detail Code</td>
					<td width="">
						<input type="text" name="lgs_cost_dtl_cd" maxlength="4" style="width:130" value="" readonly>
					</td>
				</tr>
				<tr class="h23">
					<td width="9%"><img class="nostar">User ID</td>
					<td width="28%"><input type="text" name="cre_usr_id" style="width:130" value="" readonly></td>
					<td width="12%">Registered Date</td>
					<td width="27%"><input type="text" name="cre_dt" style="width:130" value="" readonly></td>
					<td width="10%">Update Date</td>
					<td width="">
					<input type="text" name="upd_dt" style="width:130" value="" readonly>
					</td></tr>
				</table>
				<!-- : ( Week ) (E) -->
				<!-- : ( Button : Sub ) (S) -->
				<table class="button" border="0" width="100%">
						<tr><td class="btn2_bg" class="align">
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<!-- Repeat Pattern -->
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" name="btng_delete" id="btng_delete">Delete</td>
									<td class="btn2_right"></td></tr></table></td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" name="btng_save" id="btng_save">Save</td>
									<td class="btn2_right"></td></tr></table></td>
									<!-- Repeat Pattern -->
								</tr>
							</table>
						</td></tr>
					</table>
				<!-- : ( Button : Sub ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Detail Explanation) (E) -->

</td></tr>
</table>
<!-- Outer Table (E)-->


</form>
</body>
</html>

<div id="div_sheet" style="display:none;">
<script language="javascript">ComSheetObject('sheet');</script>
</div>

