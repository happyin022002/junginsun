<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_1044.jsp
*@FileTitle  : MTY Repo In/ Out Plan
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/15
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.event.EesEqr1044Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr1044Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String locGrpCd = "";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String week = "";
	String title = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EesEqr1044Event)request.getAttribute("Event");
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		title = "Discharging List";
		week  = (String)event.getAttribute("fcast_yrwk");
		
		if("E".equals(event.getAttribute("loc_grp_cd"))){
			locGrpCd = "ECC";
		}else if("L".equals(event.getAttribute("loc_grp_cd"))){
			locGrpCd = "LCC";
		}else if("S".equals(event.getAttribute("loc_grp_cd"))){
			locGrpCd = "SCC";
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<script type="text/javascript">
    function setupPage(){  
	    loadPage();
    }
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="loc_grp_cd" id="loc_grp_cd"  value="<%=event.getAttribute("loc_grp_cd") %>">
<input type="hidden" name="loc_cd" id="loc_cd"  value="<%=event.getAttribute("loc_cd") %>">
<input type="hidden" name="fcast_yrwk" id="fcast_yrwk"  value="<%=event.getAttribute("fcast_yrwk") %>">
<input type="hidden" name="repo_pln_yrwk" id="repo_pln_yrwk"  value="<%=event.getAttribute("repo_pln_yrwk") %>">
<input type="hidden" name="curr_flag" id="curr_flag"  value="<%=event.getMtyBalanceRepoListVO().getCurrFlag() %>">

<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
		<!-- btn_div -->
		<div class="opus_design_btn"><!--
		    --><button type="button" class="btn_accent" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
	   <!-- page_location(S) -->
	   <div class="location">
			<span id="navigation"></span>
	   </div>
	</div>
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table>
				<tr>
                 	<th>Wk<%= week.substring(4) %> disc vol. (<%=event.getMtyBalanceRepoListVO().getWkStDt() %>~<%=event.getMtyBalanceRepoListVO().getWkEndDt() %>)</th>
               	</tr>
                <tr>
                    <td><%= locGrpCd %></td>
                    <td>:</td>
                    <td><%=event.getAttribute("loc_cd") %></td>
                </tr>
			</table>
		</div>
	</div>
	<div class="wrap_result">
		<div class="opus_design_grid" id="dis_vol"  style="display:none">
			<div>Discharged Vol.</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<div class="opus_design_grid" id="mainTable">
			<div>To Be discharging Vol.</div>
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
	</div>	
</form>