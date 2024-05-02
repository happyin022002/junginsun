<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_SCE_0120.jsp
*@FileTitle : Actual Mapping History
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.copreport.actmappinghis.event.EsdSce0120Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdSce0120Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error On Server Side
	String strErrMsg = "";						//Error Message
	int rowCount	 = 0;						//DB ResultSet List Count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.opus.esd.sce.copreport");
	int rowSize = 3000 ;

	//selected value in exception combo box
	String expt_tp_idx = JSPUtil.getNull(request.getParameter("expt_tp_selected_idx"));

	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdSce0120Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//The data obtained from the server side on load.
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Exception Inquiry II</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}

</script>

</head>
<!--  Setting multi selected at check box&&& -->

<body onLoad="setupPage();">
<form name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="row_size" value="<%=rowSize%>">
<input type="hidden" name="coldesc0" value="Actual Type,Mappimg,Actual Date,Event Code,VVD,BKG No.,CNTR No.,COP,Actaul Code,Location,Planned,Estimated,Gap Time,Master COP,Actual Received Date,Mapping Date,Retry Mapping,Update Date,Update ID">
<input type="hidden" name="iCheckRow" value="1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38">
<input type="hidden" name="row_size" value="<%=rowSize%>">
<input type="hidden" name="totcnt" value="1" >
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

<script language="javascript">

function screenReload(){

form.action = 'ESD_SCE_0120.do';
form.submit();

}
</script>
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
							<td class="btn1_line"></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr> 
		</table>
		<table class="search">
			<tr>
				<td class="bg">
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="107">Actual Type </td>
							<td width="">
							    <DIV id="ExptDTLTPDiv" >
							      <select style="width:140;" name='act_rcv_tp_cd' >&nbsp;
							      <option value="" >ALL</option>
							        <option value="1" >MVMT</option>
							        <option value="2" >VSL</option>
							        <option value="3" >322</option>
							        <option value="4" >214</option>
							        <option value="5" >SPP</option>
							        <option value="6" >Manual</option>
							      </select>
							    </DIV>
							</td>
							<td width="160">Actual Event Code</td>
							<td width=""><input name="act_sts_mapg_cd" type="text" style="width:100; text-transform:uppercase;" value="">
							</td>
							<td width="330"></td>
						</tr>
					</table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="107">Mapping</td>
							<td width="">
							    <DIV id="ExptDTLTPDiv" >
							      <select style="width:140;" name='act_umch_tp_cd' >&nbsp;
							      <option value="" >ALL</option>
							        <option value="99" >Y</option>
							        <option value="N" >N</option>
							        <option value="70" >Copy</option>
							      </select>
							    </DIV>
							</td>
							<td width="300"></td>
						</tr>
					</table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="107">Actual Date</td>
							<td width="89" ><input name="act_fm_dt" type="text" class="input" style="width:70; text-transform:uppercase;" onKeyUp="ComChkObjValid(this, 'date', false, null, null, '-')" onBlur="ComChkObjValid(this, 'date', false, null, null, '-')">&nbsp;~&nbsp;</td>
							<td width="75" ><input name="act_to_dt" type="text" class="input" style="width:70; text-transform:uppercase;" onKeyUp="ComChkObjValid(this, 'date', false, null, null, '-')" onBlur="ComChkObjValid(this, 'date', false, null, null, '-')"></td>
							<td width="135" ><img name="btn_act_calendar" class="cursor" src="/opuscntr/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>

							<td width="80"></td>
							<td width="230" >
							</td>

							<td width="110"  ></td>
							<td width="" >&nbsp; </td>

						</tr>
					</table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="107">Booking No.</td>
							<td width="89" ><input name="bkg_no" type="text" style="width:110 ; text-transform:uppercase;" value="" Onkeydown="onEnterKey(this)" ></td>
							<td width="75" ></td>
							<td width="135" ></td>

							<td width="70">CNTR No.</td>
							<td width="230" ><input name="cntr_no" type="text" style="width:100 ; text-transform:uppercase;" value="" Onkeydown="onEnterKey(this)" >
							</td>

							<td width="60"  >COP No.</td>
							<td width="" ><input name="cop_no" type="text" style="width:100; text-transform:uppercase;" value="" Onkeydown="onEnterKey(this)" >
							</td>

						</tr>
					</table>
					<table class="search_in" border="0">
					<tr class="h23">
						<td width="107">VVD</td>
						<td width="160"><input name="vvd" type="text" style="width:70; text-transform:uppercase;" onBlur="ComChkObjValid(this)">&nbsp;<img onClick="openVVDPopUp(true)" class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
						<td width="30">POR</td>
						<!--  Setting POR check box &&&-->
						<td width="160"><input name="por_cd" type="text" class="input" style="width:60; text-transform:uppercase;" onKeyUp="ComChkObjValid(this, 'eng_num', true, 1000)">&nbsp;<img onClick="openLocPopUp(true,'por_cd')" class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
						<td width="30">POL</td>
						<!--  Setting POL check box&&& -->
						<td width="160"><input name="pol_cd" type="text" class="input" style="width:60; text-transform:uppercase;" onKeyUp="ComChkObjValid(this, 'eng_num', true, 1000)">&nbsp;<img onClick="openLocPopUp(true,'pol_cd')" class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
						<td width="30">POD</td>
						<!--  Setting POD check box&&& -->
						<td width="160"><input name="pod_cd" type="text" class="input" style="width:60; text-transform:uppercase;" onKeyUp="ComChkObjValid(this, 'eng_num', true, 1000)">&nbsp;<img onClick="openLocPopUp(true,'pod_cd')" class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
						<td width="30">DEL</td>
						<!--  Setting DEL check box&&& -->
						<td width=""><input name="del_cd" type="text" class="input" style="width:60; text-transform:uppercase;" onKeyUp="ComChkObjValid(this, 'eng_num', true, 1000)">&nbsp;<img onClick="openLocPopUp(true,'del_cd')" class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>

					</tr>
					</table>



					
				</td></tr>
		</table>

		<table class="height_10"><tr><td></td></tr></table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

		<table style="width:100%; class="search">
		 		<tr>
			      <td width="30%">
				  <table width="40%" class="search">
						<tr>
							<td width="150"></td>
						</tr>
						<tr><td class="height_"></td></tr>
				  </table>
				  <td width="70%" align="left">

			    </td></tr>
		</table>

				<!-- : ( Speed ) (S) -->
				<table width="100%" id="mainTable">
					<tr><td>
					   <script language="javascript">ComSheetObject('sheet1');</script>
					</td></tr>
				</table>
				<!-- : ( Speed ) (E) -->

				<!-- : ( Button : Sub ) (S) -->
					<table width="100%" class="sbutton">
	       				<tr><td class="align">

			    		<table class="sbutton">
			    			<!-- btn_confirm.gif를  btn_ExceptionConfirm.gif로 &&&-->
			    			<tr><!-- <td class="bt"><img class="cursor" src="/opuscntr/img/button/btn_ExceptionConfirm.gif" width="125" height="20" border="0" name="btn_confirm"></td> -->
								</tr>
						</table>

						</td></tr>
					</table>
	    		<!-- : ( Button : Sub ) (E) -->

			</td></tr>

		</table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->

		<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (END) ####### -->


    </td></tr>
</table>
<!-- Outer Table (E)-->
</form>
<span id="new_form"></span>
</body>
</html>
<%@include file="/bizcommon/include/common_opus.jsp"%>