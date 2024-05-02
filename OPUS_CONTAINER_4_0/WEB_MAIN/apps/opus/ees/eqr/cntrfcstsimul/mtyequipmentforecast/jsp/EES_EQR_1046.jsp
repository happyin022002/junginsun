<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_1046.jsp
*@FileTitle  : MTY Balance Report
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
<%@ page import="com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.event.EesEqr1046Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%
	EesEqr1046Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String repoFlag 		= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesEqr1046Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		repoFlag = event.getMtyBalanceOptionVO().getRepoFlag();
		if ( repoFlag.equals("MINUS")) {
			repoFlag = "-";
		} else {
			repoFlag = "+";
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage('<%=repoFlag %>');
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" id="loc_grp_cd" name="loc_grp_cd"  value="<%=event.getAttribute("loc_grp_cd") %>">
<input type="hidden" id="loc_cd" name="loc_cd"  value="<%=event.getAttribute("loc_cd") %>">
<input type="hidden" id="fcast_yrwk" name="fcast_yrwk"  value="<%=event.getAttribute("fcast_yrwk") %>">
<input type="hidden" id="inp_yrwk" name="inp_yrwk"  value="<%=event.getMtyBalanceOptionVO().getInpYrwk() %>">
<input type="hidden" id="tp_cd" name="tp_cd"  value="<%=event.getMtyBalanceOptionVO().getTpCd() %>">
<input type="hidden" id="save_option" name="save_option"  value="<%=event.getAttribute("save_flag") %>">
<input type="hidden" id="search_flag" name="search_flag"  value="<%=StringUtil.xssFilter(request.getParameter("search_flag")) %>">

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span><%=repoFlag %> Others Creation</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!-- 
			--><button type="button" class="btn_normal" name="btn_downExcel" id="btn_downExcel">Down Excel</button><!-- 
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
						<td width="230"><div class="sm"><table><tr>
							<td>
								<input type="radio" id="viewFlag_dry" name="viewFlag" checked><label for="viewFlag_dry"><strong>DRY</strong></label><!--
							 --><input type="radio" id="viewFlag_spcl" name="viewFlag"><label for="viewFlag_spcl"><strong>SPCL(RF, OT, FR)</strong></label><!--
							 --><input type="radio" id="viewFlag_all" name="viewFlag"><label for="viewFlag_all"><strong>ALL</strong></label>
							</td>
						</tr></table></div></td>
						<td></td>
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