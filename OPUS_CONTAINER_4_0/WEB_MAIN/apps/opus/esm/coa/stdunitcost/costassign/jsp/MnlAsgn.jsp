<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_9999.jsp
*@FileTitle : Batch Test Page
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.coa.stdunitcost.costassign.event.EsmCoaAssignEvent"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmCoaAssignEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	Logger log = Logger.getLogger("com.clt.apps.STDUnitCost.CostAssign");

	try {
		event = (EsmCoaAssignEvent)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script>
	function doProcess(pageNo){
		try {
			//var srcName = window.event.srcElement.getAttribute("name");

			with(document.form) {
				switch (pageNo) {
					// BT_SCM_COA_021
					case 21:
						f_cmd.value = COMMAND21;
						action = "MnlAsgn.do";
						target = "frmHidden";
						submit();
						break;

					// BT_SCM_COA_022
					case 22:
						f_cmd.value = COMMAND22;
						action = "MnlAsgn.do";
						target = "frmHidden";
						submit();
						break;

					// 
					case 23:
						f_cmd.value = COMMAND23;
						action = "MnlAsgn.do";
						target = "frmHidden";
						submit();
						break;
						
					case 24:
						f_cmd.value = COMMAND24;
						antion = "MnlAsgn.do";
						target = "frmHidden";
						submit();
						break;
					
				} // end switch
			}// end with
		} catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}
</script>
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>



<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- Developer DIV	-->

<div class="page_title_area clear ">
	<h2 class="page_title"><button type="button"><span>Batch Test Page</span></button></h2>

	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
	</div>

	<div class="location">
		<span id="navigation"></span>
	</div>
</div>

<div class="wrap_search">
	<div class="layout_wrap">
		<table class="grid2">
			<tr>
				<th width="85%">Pane Name</th>
				<th width="15%">Do Process</th>
			</tr>
			<tr>
			<td class="con" bgcolor="#FFFFFF" style="height:70; padding-left:30; ">
					<b>PRD (createCostAssignPrd)</b>&nbsp;&nbsp;&nbsp;&nbsp;
					start_pctl_no&nbsp;&nbsp;<input name="f_start_pctl_no" id="start_pctl_no" value="B0702160000000690002">&nbsp;&nbsp;
					end_pctl_no&nbsp;&nbsp;<input name="f_end_pctl_no" id="end_pctl_no" value="B0702160000000690002">
				</td>
				<td class="con" bgcolor="#FFFFFF" align="center"><a href="javascript:doProcess(21)" class="purple">Execute</a></td>
			</tr>
			<tr>
				<td class="con" bgcolor="#FFFFFF" style="height:70; padding-left:30;">
					<b>COP (createCostAssignCop)</b>&nbsp;&nbsp;&nbsp;&nbsp;
					 bkg_no&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					 <input name="f_bkg_no" " id="f_bkg_no" value="HKGY6050197"  maxlength="13" ><!-- SGN73060004 -->
					 <input type="checkbox" name="f_del_para" value="T"  class="trans"  checked>&nbsp;PARA 삭제
					 <input name="f_level" " id="f_level" value="6"  maxlength="1" ><!-- SGN73060004 -->
				</td>
				<td class="con" bgcolor="#FFFFFF" align="center" ><a href="javascript:doProcess(22)" class="purple">Execute</a></td>
			</tr>
		</table>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid"  id="mainTable">
		<table>
			<tbody>
            <tr>
				<td class="con"  width="100">COA_BAT_CD</td>
				<td><input type="text" class="input1" name="f_coa_bat_cd"style="width:150;text-align:center;" maxlength="15"></td>
			</tr>
			 <tr height="5px">
				<td></td>
				<td></td>
			</tr>
			</tbody>
		</table>
	
		<script language="javascript">ComSheetObject('sheet1');</script>
	</div>
</div>




<!-- Developer DIV	END -->
</form>
<iframe heigth="0" width="0" name="frmHidden" ></iframe>
