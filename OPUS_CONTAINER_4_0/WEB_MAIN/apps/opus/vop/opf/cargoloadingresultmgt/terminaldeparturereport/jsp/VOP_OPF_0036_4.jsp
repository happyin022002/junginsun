<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_opf_0036_4.jsp
*@FileTitle  : TDR Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/01
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

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CargoLoadingResultMgt.TerminalDepartureReport");
	String btnDis			= "";

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
		loadPage("<%=StringUtil.xssFilter(btnDis)%>");
	}
</script>
<form name="form" id="form">
	<div class="opus_design_inquiry" style="width: 979px;" id="mainTable">
		<table>
			<tr>
				<td>
					<div class="wrap_serach_btn" style="width:350px">
						<table>
							<tr>
								<td>
									<input type="radio" value="" name="chk_LoadVol" id="ocean" checked><label for="ocean">Ocean</label>
									<input type="radio" value="" name="chk_LoadVol" id="interport"><label for="interport">Inter Port</label>
									<input type="radio" value="" name="chk_LoadVol" id="specialcargo"><label for="specialcargo">Special Cargo</label>
									<input type="radio" value="" name="chk_LoadVol" id="breakbulk"><label for="breakbulk">Break-Bulk</label>
								</td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table> 
	</div>
	<div class="opus_design_grid">
		<%if(btnDis != null && btnDis.equals("Y")){%>
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn"><!--  
			--><button type="button" class="btn_accent" name="btn_t4ImportPart" id="btn_t4ImportPart">Import BKG data for ref.</button><!--  
			--><button type="button" class="btn_normal" name="btn_t4RowAdd"  	id="btn_t4RowAdd">Row Add</button><!-- 
			--><button type="button" class="btn_accent" name="btn_t4RowInsert" id="btn_t4RowInsert">Row Insert</button><!--  
			--><button type="button" class="btn_normal" name="btn_t4RowCopy"  	id="btn_t4RowCopy">Row Copy</button><!-- 
			--><button type="button" class="btn_normal" name="btn_t4Delete"  	id="btn_t4Delete">Row Delete</button><!-- 
			--></div>
			<!-- opus_design_btn(E) -->
		<%}%>
		<%for( int cnt = 1; cnt < 5; cnt++){%>
			<div  id="t4sheetDiv" style="display:<%=(cnt == 1 ? "inline" : "none")%>">
				<script type="text/javascript">ComSheetObject('t4sheet<%=cnt%>');</script>
			</div>
		<%}%>
	</div>
</form>