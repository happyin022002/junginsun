<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESM_BKG_1021.jsp
*@FileTitle : Bank In Account No Setup for A/N
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/14
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1021Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmBkg1021Event event = null;
	Exception serverException   = null;
	String ofc_cd = "";
	String strErrMsg = "";
	try
	{
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		ofc_cd =	account.getOfc_cd();
		event = (EsmBkg1021Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	}
	catch(Exception e)
	{
		out.println(e.toString());
	}
%>
	<script type="text/javascript">
		function setupPage()
		{
			$('<button type="button" class="btn_accent" name="btn_Retrieve"	id="btn_Retrieve">Retrieve</button>').appendTo(".opus_design_btn");
			if(curPgmNo.indexOf("1021_Q") == -1){
				$('<button type="button" class="btn_normal" name="btn_Save"  	id="btn_Save">Save</button>').appendTo(".opus_design_btn");
				$('<button type="button" class="btn_normal" name="btn_Delete" 	id="btn_Delete">Delete</button>').appendTo(".opus_design_btn");
			}

			loadPage();
		}

	</script>
	<form name="form"><!-- OUTER - POPUP (S)tart -->
	<input type="hidden" name="f_cmd">
	<input type="hidden" name="pagerows">
	<input type="hidden" name="old_ofc_cd">
	<input type="hidden" name="drft_bl_bank_acct_dp_flg" />

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn"></div>
		<!-- opus_design_btn (E) -->
		<!-- page_location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
	</div>
	<!-- page_title_area(E) -->

	<div class="layer_popup_contents">
		<div class="wrap_search">
			<div class="opus_design_inquiry">
				<!--biz page (S)-->
				<table class="search">
					<tr>
						<td>
							<table class="search" border="0" style="width: 479px;">
								<tr class="h23">
									<th width="60px">Office</th>
									<td width="*"><input type="text" style="width:50px;ime-mode:disabled;" class="input1"  name="ofc_cd" id="ofc_cd"  dataformat="enguponly" caption="Office" minlength="5" maxlength="6" value="<%=ofc_cd %>" required="" />
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
					<table class="search">
					<tr>
						<td>
							<table class="grid2">
								<tr>
									<th width="*" style="text-align:center;" class="tr2_head">Bank In Account No.</th>
								</tr>
								<tr>
									<td>
										<textarea style="width:100%;text-indent:0px" rows="5" name="bank_in_acct_ctnt" ></textarea>
									</td>
								</tr>
<!-- 20150317 안진응 주석처리 (조원주 수석 요청)
								<tr>
									<td>
									Display Option : <input type="checkbox" class="trans" name="dp_flg" /> Draft B/L
									<input type="hidden" name="drft_bl_bank_acct_dp_flg" />
									</td>
								</tr>
-->								
								<tr>
									<td>Last updated by <span id="upd_usr_id"></span></td>
								</tr>

							</table>

					</td></tr>
				</table>
				</div>
			</div>
	<!-- 검색영역 -->
	</div>
	<!-- 검색영역 -->

	<div class="wrap_result" style="display: none;">
		<table>
			<tr><td width="100%">
				<script type="text/javascript">ComSheetObject('sheet1');</script>
			</td></tr>
		</table>
	</div>
	</form>