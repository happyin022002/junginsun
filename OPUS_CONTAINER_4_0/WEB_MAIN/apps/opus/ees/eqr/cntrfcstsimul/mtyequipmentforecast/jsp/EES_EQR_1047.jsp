<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_1047.jsp
*@FileTitle  : MTY Balance Repo Out
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/02
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.event.EesEqr1047Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%
	EesEqr1047Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String title = "";
	String locGrpCd = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EesEqr1047Event)request.getAttribute("Event");
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		title = "MTY Balance Repo Out";
		
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
<script language="javascript">
<%= JSPUtil.getIBCodeCombo("trspModCd", "01", "CD03235", 0, "")%> // trsp_mod_cd

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<script language="javascript">

    function setupPage(){  

	    loadPage();
    }

</script>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" id="loc_grp_cd" name="loc_grp_cd"  value="<%=event.getAttribute("loc_grp_cd") %>">
<input type="hidden" id="loc_cd" name="loc_cd"  value="<%=event.getAttribute("loc_cd") %>">
<input type="hidden" id="fcast_yrwk" name="fcast_yrwk"  value="<%=event.getAttribute("fcast_yrwk") %>">
<input type="hidden" id="inp_yrwk" name="inp_yrwk"  value="<%=event.getAttribute("inp_yrwk") %>">
<input type="hidden" id="cre_seq" name="cre_seq" >
<input type="hidden" id="save_option" name="save_option"  value="<%=event.getAttribute("save_flag") %>">
<input type="hidden" id="tpsz_flag" name="tpsz_flag"  value="<%=StringUtil.xssFilter(request.getParameter("tpsz_flag")) %>">

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span><%=title%></span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
			--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!-- 
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table> 
				<tbody>
					<tr>
						<td width="35"><%= locGrpCd %></td>
						<th width="10">:</th>
						<td><%=event.getAttribute("loc_cd") %></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	
	<div class="wrap_result">
		<div class="opus_design_grid" >
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button>
				<button type="button" class="btn_normal" name="btn_Delete" id="btn_Delete">Row Delete</button>
			</div>
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>
</form>