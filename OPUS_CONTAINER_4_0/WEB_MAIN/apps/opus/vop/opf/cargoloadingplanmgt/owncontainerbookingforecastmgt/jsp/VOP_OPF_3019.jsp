<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_opf_3019.jsp
*@FileTitle  : Weight Group (Creation) 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/19
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
<%@ page import="com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event.VopOpf3019Event"%>
<%@ page import="org.apache.log4j.Logger" %>
 
<%
	VopOpf3019Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	String slan_cd = "";
	String slan_cd_desc = "";
	String skd_dir_cd = "";
	String pol_cd = "";

	if(request.getParameter("slan_cd")!=null) {
		slan_cd	= request.getParameter("slan_cd");
	}
	if(request.getParameter("slan_cd_desc")!=null) {
		slan_cd_desc	= request.getParameter("slan_cd_desc");
	}
	if(request.getParameter("skd_dir_cd")!=null) {
		skd_dir_cd	= request.getParameter("skd_dir_cd");
	}
	if(request.getParameter("pol_cd")!=null) {
		pol_cd	= request.getParameter("pol_cd");
	}

	Logger log = Logger.getLogger("com.clt.apps.CargoLoadingPlanMgt.OwnContainerBookingForecastMgt");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopOpf3019Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="sel_skd_dir_cd" value="<%=StringUtil.xssFilter(skd_dir_cd)%>" id="sel_skd_dir_cd" />

 
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Weight Group (Creation)</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" 			id="btn_Retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_New" 			id="btn_New">New</button><!-- 		
			 --><button type="button" class="btn_normal" name="btn_Save" 			id="btn_Save">Save</button><!-- 		
			 --><button type="button" class="btn_normal" name="btn_Close" 			id="btn_Close">Close</button>		
		</div>
		<!-- opus_design_btn(E) -->
		
	</div>
	<!-- page_title_area(E) --> 
</div>

 
<div class="layer_popup_contents" style="overflow:hidden">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="30">
					<col width="330">
					<col width="50">
					<col width="50">
					<col width="30">
					<col width="*">				
				</colgroup> 
				<tbody>
					<tr class="h23">
						<th>Lane</th>
						<td><input type="text" tabindex="1" style="width:50px;" maxlength="3" fullfill="" caption="Lane" class="input1" name="slan_cd" dataformat="engup" value="<%=StringUtil.xssFilter(slan_cd)%>" required="" id="slan_cd" /><button type="button" id="slan_cd_pop" name="slan_cd_pop" class="input_seach_btn"></button><input type="text" style="width:230px;" class="input2" name="slan_cd_desc" value="<%=StringUtil.xssFilter(slan_cd_desc)%>" readonly id="slan_cd_desc" /></td>
						<th>Direction</th>
						<td width="90">
							<select tabIndex="2" style="width:50px;" class="input1" name="skd_dir_cd" onchange="skd_dir_cd_change(this.form)">
								<option value="E">E</option>
								<option value="W">W</option>
								<option value="S">S</option>
								<option value="N">N</option>
							</select>
						</td>
						<th title="Port of Loading">POL</th>
						<td><input type="text" tabindex="3" style="width:50px;" maxlength="5" fullfill="" caption="POL" class="input1" name="pol_cd" id="pol_cd" value="<%=StringUtil.xssFilter(pol_cd)%>" dataformat="engup" required="" /><button type="button" id="pol_cd_pop" name="pol_cd_pop" class="input_seach_btn"></button></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	
	<div class="wrap_result">
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">	
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_RowAdd" 			id="btn_RowAdd">Row Add</button>
				<button type="button" class="btn_normal" name="btn_RowDelete" 		id="btn_RowDelete">Row Delete</button>		
			</div>
			<!-- opus_design_btn(E) -->		
			<script type="text/javascript">ComSheetObject('sheet1');</script>		
		</div>
		<!-- opus_design_grid(E) -->
			
	</div>
	
	<div class = "opus_design_grid" id="tabLayer" style="display:none">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div> 	
</div>
</form>