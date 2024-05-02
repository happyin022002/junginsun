<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_opf_0036_3.jsp
*@FileTitle  : TDR Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/1
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
	String btnDis			= "";
	Logger log = Logger.getLogger("com.clt.apps.CargoLoadingResultMgt.TerminalDepartureReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopOpf0036Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		btnDis = request.getParameter("btnDis");
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
<form name="form">
	<div class="opus_design_inquiry" style="width: 979px;" id="mainTable">
		<table>
			<tr>
				<td>
					<div class="wrap_serach_btn" style="width:350px">
						<table>
							<tr>
								<td>
									<input type="radio" value="" name="chk_DischVol" id="totalvol" checked><label for="totalvol">Total Volume</label>
									<input type="radio" value="" name="chk_DischVol" id="specialcargo"><label for="specialcargo">Special Cargo</label>
									<input type="radio" value="" name="chk_DischVol" id="breakbulk"><label for="breakbulk">Break-Bulk</label>
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
				--><button type="button" class="btn_accent" name="btn_t3ImportPart" id="btn_t3ImportPart">Import BKG data for ref.</button><!--  
				--><button type="button" class="btn_normal" name="btn_t3RowAdd"  	id="btn_t3RowAdd">Row Add</button><!-- 
				--><button type="button" class="btn_accent" name="btn_t3RowInsert" id="btn_t3RowInsert">Row Insert</button><!--  
				--><button type="button" class="btn_normal" name="btn_t3RowCopy"  	id="btn_t3RowCopy">Row Copy</button><!-- 
				--><button type="button" class="btn_normal" name="btn_t3Delete"  	id="btn_t3Delete">Row Delete</button><!-- 
				--></div>
				<!-- opus_design_btn(E) -->
			<%}%>
	
		<%for( int cnt = 1; cnt < 4; cnt++){%>
			<div id="t3sheetDiv" style="display:<%=(cnt == 1 ? "inline" : "none")%>">
				<script type="text/javascript">ComSheetObject('t3sheet<%=cnt%>');</script>
			</div>
		<%}%>
	</div>
</form>