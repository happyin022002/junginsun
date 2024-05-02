<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0207.jsp
*@FileTitle  : B/L Rider
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/24
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.event.EsmBkg0207Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0207Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SpecialCargoBookingConduct.specialcargorider");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg0207Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
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
	}
</script>

<form name="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="bkg_no" name="bkg_no" value="<%=JSPUtil.getParameter(request, "bkg_no")%>" type="hidden" />
<input id="ridr_tp_cd" name="ridr_tp_cd" value="<%=JSPUtil.getParameter(request, "ridr_tp_cd")%>" type="hidden" />
<input id="disableYn" name="disableYn" value="<%=JSPUtil.getParameter(request, "disableYn")%>" type="hidden" />
<input id="open_tp_cd" name="open_tp_cd" value="<%=JSPUtil.getParameter(request, "open_tp_cd")%>" type="hidden" />


	<div name="pop_title" id="pop_title" class="page_title_area clear">
		<h2 class="page_title"><span>Special Cargo Rider</span></h2>
		
		<div class="opus_design_btn">
		   <button type="button" id="btn_upload" name="btn_upload" class="btn_normal">File Add</button><!--
		--><button type="button" id="btn_delete" name="btn_delete" class="btn_normal">File Delete</button><!--
		--><button type="button" id="btn_save" name="btn_save" class="btn_normal">Save</button><!--
		--><button type="button" id="btn_close" name="btn_close" class="btn_normal">Close</button>
		</div>
	</div>



	<div class="wrap_search" name="pop_search" id="pop_search" >
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="60" />
				</colgroup>
				<tbody>
				<tr>
					<th>Booking No.</th>
					<td id="v_bkg_no" name="v_bkg_no"></td>
				</tr>
				</tbody>
			</table>
			<table>
				<colgroup>
					<col width="60" />
				</colgroup>
				<tbody>
				<tr>
					<td>
                        <input id="r_ridr_tp_cd_D" name="r_ridr_tp_cd" value="D" onclick="fn_ridr_Tp_Change(this)" disabled type="radio" /><label for="r_ridr_tp_cd_D"><strong>D/G Rider</strong></label><!--
					 --><input id="r_ridr_tp_cd_A" name="r_ridr_tp_cd" value="A" onclick="fn_ridr_Tp_Change(this)" disabled type="radio" /><label for="r_ridr_tp_cd_A"><strong>Awkward Rider</strong></label><!--
					 --><input id="r_ridr_tp_cd_B" name="r_ridr_tp_cd" value="B" onclick="fn_ridr_Tp_Change(this)" disabled type="radio" /><label for="r_ridr_tp_cd_B"><strong>Break Bulk Rider</strong></label>
					</td>
					<td></td> 
				</tr>
			</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	<div class="wrap_result">
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<div class="opus_design_grid" style="display:none">
			<script>ComUploadObject('upload1', '<=session.getId()%>');</script>
		</div>
		<iframe name="hiddenFrame" style="visibility:hidden" height="0" width="0" frameborder="0" marginHeight="0"	marginWidth="0"></iframe>
	</div>

</form>
