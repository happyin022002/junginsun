<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_0036_7.jsp
*@FileTitle  : TDR Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/02
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf0036Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopOpf0036Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String btnDis			= "";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CargoLoadingResultMgt.TerminalDepartureReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		btnDis = request.getParameter("btnDis");

		event = (VopOpf0036Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		$(".util_bar").css("display","none");
		$(".btn_gnb_hide").css("display","none");
		$(".gnb").css("display","none");
		loadPage("<%=StringUtil.xssFilter(btnDis)%>");
	}
</script>
<form name="form">
	<div class="opus_design_inquiry" style="width: 979px;" id="mainTable">
		<table>
			<tr>
				<td>
					<div class="wrap_serach_btn" style="width:380px">
						<table>
							<tr>
								<td>
									<input type="radio" value="SD" name="misDischLoad" id="misDischLoad_SD" checked><label for="misDischLoad_SD">Short Disch.</label>
									<input type="radio" value="OD" name="misDischLoad" id="misDischLoad_OD"><label for="misDischLoad_OD">Over Disch.</label>
									<input type="radio" value="SL" name="misDischLoad" id="misDischLoad_SL"><label for="misDischLoad_SL">Short Load</label>
									<input type="radio" value="OL" name="misDischLoad" id="misDischLoad_OL"><label for="misDischLoad_OL">Over Load</label>
								</td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table> 
	</div>
	<div class="opus_design_grid" id="mainTable">
		<%if(btnDis != null && btnDis.equals("Y")){%>
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn"><!--  
			--><button type="button" class="btn_normal" name="btn_t7RowAdd"  	id="btn_t7RowAdd">Row Add</button><!-- 
			--><button type="button" class="btn_accent" name="btn_t7RowInsert" id=btn_t7RowInsert>Row Insert</button><!--  
			--><button type="button" class="btn_normal" name="btn_t7RowCopy"  	id="btn_t7RowCopy">Row Copy</button><!-- 
			--><button type="button" class="btn_normal" name="btn_t7Delete"  	id="btn_t7Delete">Row Delete</button><!-- 
			--></div>
			<!-- opus_design_btn(E) -->
		<%}%>
		<script language="javascript">ComSheetObject('t7sheet1');</script>
	</div>
</form>