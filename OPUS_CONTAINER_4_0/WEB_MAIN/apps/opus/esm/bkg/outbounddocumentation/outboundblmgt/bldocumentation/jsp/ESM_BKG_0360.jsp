<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0360.jsp
*@FileTitle  : Marks And Description by NVO H/BL
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg0360Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0360Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.OutboundBLMgt.BLDocumentation");

	String bkgNo = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0360Event)request.getAttribute("Event");
		bkgNo = event.getBkgNo();
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
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
		loadPage();
		//
		callback_func = '<%=JSPUtil.getParameter(request, "func", "")%>';
	}
</script>
</head>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

			
<div class="page_title_area clear">
	<h2 class="page_title"><span>Marks & Description of NVOCC House B/L</span></h2>
	
	<div class="opus_design_btn"><!-- 
	 	 --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
	 	 --><button type="button" class="btn_normal" name="btn_copy" id="btn_copy">Copy to M.B/L</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button><!-- 
	 --></div>
</div>

<div class="wrap_search">
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="60" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Booking No.</th>
					<td><input type="text" name="bkg_no" value="<%=bkgNo%>" class="input input_search" style="ime-mode:disabled; width:120px;" dataformat="engup"><button type="button" class="btn_down" name="btn_splitPop" id="btn_splitPop"></button></td>
				</tr>
				<tr><td colspan="6"></td></tr>
				<tr class="line_bluedot"><td colspan="6"></td></tr>
				<tr><td colspan="6"></td></tr>
				<tr class="h23">
					<th>Customs Description</th>
					<td><input type="text" name="cntr_mf_gds_desc" class="input" style="ime-mode:disabled; width: 600px;" dataformat="engup" otherchar=" /\n"></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<div class="wrap_result">	
	<div class="layout_wrap">
	    <div class="layout_vertical_3" style="width:10% ">
	        <div class="opus_design_grid">
	           <script type="text/javascript">ComSheetObject('sheet1');</script>
	        </div>
	    </div>
	    <div class="layout_vertical_3" style="width:5% ">
	        <div class="opus_design_inquiry">
				<table>
					<tr>
						<td></td>
					</tr>
				</table>
	        </div>
	    </div>
	    <div class="layout_vertical_3" style="width:40% ">
	        <div class="opus_design_inquiry">
				<table class="grid_2">
					<tbody>
						<tr>
							<th class="align_center">Marks & Numbers</th>
						</tr>
						<tr>
							<td class="align_center" valign="top">
								<textarea name="bl_mk_desc"  style="width:100%; ime-mode:disabled;height:182px; font-family:Courier New;font-size:14px;text-indent:0px;overflow X:hidden;" dataformat="engup" otherchar=" /\n"></textarea>
							</td>
						</tr>
					</tbody>
				</table>
	        </div>
	    </div>
	      <div class="layout_vertical_3" style="width:5% ">
	        <div class="opus_design_inquiry">
				<table>
					<tr>
						<td></td>
					</tr>
				</table>
	        </div>
	    </div>
	    <div class="layout_vertical_3" style="width:40% ">
	        <div class="opus_design_inquiry">
				<table class="grid_2">
					<tbody>
						<tr>
							<th class="align_center">Description of Goods</th>
						</tr>
						<tr>
							<td class="align_center" valign="top">
								<textarea name="bl_gds_desc"  style="width:100%; ime-mode:disabled;height:182px; ime-mode:disabled;font-family:Courier New;font-size:14px;text-indent:0px;overflow X:hidden;" dataformat="engup"></textarea>
							</td>
						</tr>
					</tbody>
				</table>

	        </div>
	    </div>
	</div>
</div>
</form>
