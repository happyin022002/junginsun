<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0533.jsp
*@FileTitle : In-Bond Arrival Manifest (Container Tab)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.06.19 김도완
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page
	import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page
	import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.event.EsmBkg0533Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0533Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	
	String strUsr_id = "";
	String strUsr_nm = "";
	
	String vvdCd  = "";
	String podCd  = "";
	
	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0533Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}
		
		vvdCd  = JSPUtil.getParameter(request, "vvd_cd");
		podCd  = JSPUtil.getParameter(request, "pod_cd");


	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			//showErrMessage(errMessage);
		} // end if
		loadPage();
		
		document.form.vvd.value = "<%=vvdCd%>";
		document.form.pod.value = "<%=podCd%>";
		
	}
</script>
</head>

<body onLoad="setupPage();">
<form name="form"><input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 
<input type="hidden" name="vsl_cd"> 
<input type="hidden" name="skd_voy_no"> 
<input type="hidden" name="skd_dir_cd"> 
<input type="hidden" name="bl_cntr_gubun" value="Cntr">
<input type="hidden" name="page_no" value="ESM_BKG_0533">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	style="padding-top: 2; padding-left: 5;">

	<tr>
		<td valign="top"><!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" 
			class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif"
					align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>
		<!--Page Title, Historical (E)--> <!--Button (S) --> <!--Button (E) -->

		<!--biz page (S)-->

		<table class="search" id="mainTable">
			<tr>
				<td class="bg">
				<table class="search" border="0" style="width: 979;">
				<tr class="h23">
				<td>
					<table class="search" border="0" style="width:580;"> 
					<tr class="h23">
						<td width="70">VVD</td>
						<td width="100"><input type="text" style="width: 80;ime-mode: disabled;"
							class="input1" name="vvd" dataformat="eng" maxlength="9" fullfill  caption="VVD" value="<%=vvdCd%>" ></td>
						<td width="30">POD</td>
						<td width="70"><input type="text" name="pod" maxlength="5" style="width:50;ime-mode: disabled;" class="input1" required dataformat="eng" caption="POD" fullfill maxlength="5" caption="POD" value="<%=podCd%>" ></td>
						<td width="40">Hub</td>
						<td width="" colspan="3"><input type="text" name="hub" style="width:50;ime-mode: disabled;" value="" class="input" dataformat="eng"></td>
					</tr>
					<tr class="h23">
						<td width="">MIB Type</td>
						<td><select name="ibd_tp_cd" style="width:70;" class="input1">
						<option value="All" selected>All</option>
						<option value="61">61</option>
						<option value="62">62</option>
						<option value="63">63</option>
						<option value="612">61&62</option>
						<option value="623">62&63</option>
						</select></td>
						<td>Arrival</td>
						<td><select name="arr_dt" style="width:50;" class="input1">
						<option value="" selected>All</option>
						<option value="Y">Yes</option>
						<option value="N">No</option>
						</select></td>
						<td>Export</td>
						<td><select name="xpt_dt" style="width:50;" class="input1">
						<option value="" selected>All</option>
						<option value="Y">Yes</option>
						<option value="N">No</option>
						</select></td>
						<td width="120">Customs Response</td>
						<td><select name="edi_error" style="width:60;" class="input1">
						<option value="" selected>All</option>
						<option value="NA">No Arrival</option>
						<option value="NE">No Export</option>
						</select></td>
						</tr>
				</table>
				</td>
				<td valign="top">	
					<table class="search" border="0" style="width:;"> 
					<tr class="h23">
						<td width="110"><input type="checkbox" name="arr_gubun" class="trans"> Arrival Date</td>
						<td>
							<input type="text" style="width: 75; ime-mode: disabled" class="input2"
							dataformat="ymd" name="fromd" required caption="Sent Date From" cofield="tod" maxlength="10" readOnly="true">
							<input type="text" name="fromt" style="width:40" value="00:00" class="input2" dataformat="hm" maxlength="5" readOnly="true">
							&nbsp;~&nbsp; <input type="text"
							style="width: 75; ime-mode: disabled" class="input2"
							dataformat="ymd" name="tod" required caption="Sent Date To" cofield="fromd" maxlength="10" readOnly="true">
							<input type="text" name="tot" style="width:40" value="23:59" class="input2" dataformat="hm" maxlength="5" readOnly="true">
							<img src="img/btns_calendar.gif" width="19" height="20" alt=""
							border="0" align="absmiddle" class="cursor" name="btn_calendar">
						</td>
					</tr>
					<tr class="h23">	
						<td width="" style="padding-left:28">EQ Office</td>
						<td><input type="text" name="eq_ofc" style="width:60; ime-mode: disabled" class="input2" value="" maxlength="5" dataformat="eng" readOnly="true"></td>
					</tr>
					</table>
				</td>
			</tr>
		</table>
		<!--biz page (E)-->
		
		</td>
			</tr>
		</table>
		<table class="height_8"><tr><td></td></tr></table>	

       	<!-- Tab ) (S) -->
       	
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
					</td></tr>
				</table>
		<!-- Tab ) (E) -->
		<table class="search" id="mainTable">
       	<tr><td class="bg">
       	
<!-- (TAB) Container (S) -->
<div id="tabLayer" style="display:inline">

		<!-- Grid BG Box  (S) -->
     	
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t1sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->


			<!--  Button_Sub (S) -->
			<table width="100%" class="button">
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><input type="text" style="width:80; ime-mode: disabled" name="set_arr_d" class="input1" value="" dataformat="ymd" maxlength="10">&nbsp; <input type="text" style="width:40;" name="set_arr_t" class="input1" value="" maxlength="5" dataformat="hm">&nbsp;&nbsp;</td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t1SetArrivalDate">Set Arrival Date</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t1SetExportDate">Set Export Date</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
</div>
			
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	

<!-- (TAB) Container (E) -->

<!-- (TAB) B/L (S) -->
<div id="tabLayer" style="display:none">

		<!-- Grid BG Box  (S) -->
     	
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t2sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->
			

			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><input type="text" style="width:80;ime-mode: disabled" name="set_arr_d" class="input1" value="" dataformat="ymd" maxlength="10">&nbsp; <input type="text" style="width:40;" name="set_arr_t" class="input1" value="" maxlength="5" dataformat="hm">&nbsp;&nbsp;</td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t2SetArrivalDate">Set Arrival Date</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t2SetExportDate">Set Export Date</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->

</div>
<!-- (TAB) B/L (E) -->

	<!--Button (S) -->
		<table width="100%" class="button" border="0" height=40 cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve"  id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right">
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_TransAN">Transmit Arrival</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_TransExp">Transmit Export</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<!-- 
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_SelectAll">Select All</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DeselectAll">Deselect All</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				-->
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
    	</td>
	</tr>
</table>
<!--textarea name="flatFile" cols="100" rows="20"></textarea-->




<!-- Copyright (S) >
<table class="copy">
	<tr>
		<td class="familysite">&nbsp; <select name="sitelink"
			id="sitelink" class="select_family"
			onChange="javascript:go_sitelink(this);">
			<option selected>&nbsp;&nbsp; -- Family Site -- &nbsp;&nbsp;</option>
			<option value=""></option>
			<option value=""></option>
			<option value=""></option>
		</select></td>
		<td class="copy"><img src="img/img_bottom_logo.gif" width="460"
			height="16" alt="" border="0"></td>
	</tr>
</table>

<br>
	    <!-임시 (S)-->
	    <!-- 
	    <table style="width:979;height:100">
	    	<tr><td>result : </td></tr>
	        <tr>
	            <td><textarea name="output" cols="100" rows="20"></textarea></td>
	        </tr>
	    </table>
	     -->
<!-- Copyright(E)--> <!-- 개발자 작업  끝 -->
</form>
</body>
</html>