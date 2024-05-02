<%
/*=========================================================
 *Copyright(c) 2015 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_TRS_0982.jsp
 *@FileTitle  : Internal Remark Popup
 *@author     : CHAN WOO PARK
 *@version    : 1.0
 *@since      : 2015/08/05
 =========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>

<%
	SignOnUserAccount account = null; 
	Exception serverException = null;
	DBRowSet rowSet = null;
	String strErrMsg = ""; 
	
	String bkg_no = "";				
	String eq_no = "";				
	String so_no = "";				
	String wo_no = "";				
	String inter_rmk_cd = "";		
	String rail_chk = "";			

	bkg_no = ((request.getParameter("bkg_no") == null) ? "" : request.getParameter("bkg_no")).trim();
	eq_no = ((request.getParameter("eq_no") == null) ? "" : request.getParameter("eq_no")).trim();
	so_no = ((request.getParameter("so_no") == null) ? "" : request.getParameter("so_no")).trim();
	wo_no = ((request.getParameter("wo_no") == null) ? "" : request.getParameter("wo_no")).trim();
	inter_rmk_cd = ((request.getParameter("inter_rmk_cd") == null) ? "" : request.getParameter("inter_rmk_cd")).trim();
	rail_chk = ((request.getParameter("rail_chk") == null) ? "" : request.getParameter("rail_chk")).trim();
	
	try {
		account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		serverException = (Exception) request .getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	} catch (Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} 
		loadPage();
	}
</script>
<form method="post" name="form" onSubmit="return false;">
	<input type="hidden" name="f_cmd" id="f_cmd" />
	<input type="hidden" name="iPage" id="iPage" /> 
	<input type="hidden" name="bkg_no" value="<%=StringUtil.xssFilter(bkg_no)%>" id="bkg_no" /> 
	<input type="hidden" name="eq_no" value="<%=StringUtil.xssFilter(eq_no)%>" id="eq_no" />
	<input type="hidden" name="so_no" value="<%=StringUtil.xssFilter(so_no)%>" id="so_no" />
	<input type="hidden" name="wo_no" value="<%=StringUtil.xssFilter(wo_no)%>" id="wo_no" />
	<input type="hidden" name="usr_id"	value="<%=account.getUsr_id()%>" id="usr_id" />
	<input type="hidden" name="inter_rmk_cd"	value="<%=StringUtil.xssFilter(inter_rmk_cd)%>" id="inter_rmk_cd" />
	<input type="hidden" name="rail_chk"	value="<%=StringUtil.xssFilter(rail_chk)%>" id="rail_chk" />
	
	<!-- 선택된 row 위치를 저장하기 위한 hidden 변수 -->
	<input type="hidden" name="focus_row" id="focus_row" />
	<div class="layer_popup_contents" style="overflow: hidden">
		<div class="layer_popup_title">
			<!-- page_title_area(S) -->
			<div class="page_title_area clear">
				<!-- page_title(S) -->
				<h2 class="page_title">
					<span>Internal Remark</span>
				</h2>
				<!-- page_title(E) -->

				<!-- opus_design_btn(S) -->
				<div class="opus_design_btn">
					<button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button><!-- 
					 --><button type="button" class="btn_normal" name="btn_RowDelete" id="btn_RowDelete">Row Delete</button><!-- 
					 --><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!-- 
					 --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
				</div>
				<!-- opus_design_btn(E) -->

				<!-- page_location(S) -->
				<div class="location">
					<span id="navigation"></span>
				</div>
				<!-- page_location(E) -->
			</div>
			<!-- page_title_area(E) -->
		</div>
		
		<!-- opus_design_grid(S) -->
		<div class="wrap_result">
			<div class="opus_design_grid">
				<script type="text/javascript">
					ComSheetObject('sheet1');
				</script>
			</div>
			<div class="opus_design_grid">
				<table class="grid2 sm">
					<colgroup>
						<col width="160"/>
						<col width="*"/>
					</colgroup>
					<tbody>
						<tr align="center">
							<th><b>Remarks</b></th>
							<td><textarea disabled="true" name="inter_rmk" style="width:100%;height:200px;resize:none;" maxlength=4000 onblur="javascript: inter_rmk_onBlur()"></textarea>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</form>