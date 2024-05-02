<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MST_0025.jsp
*@FileTitle  : Container Status Creation-LST and FND
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/04
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0025Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%
	EesMst0025Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list
	String successFlag = "";
	String codeList = "";
	String pageRows = "100";
	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";	
	String strPgmNo = "";
	Logger log = Logger.getLogger("com.clt.apps.EquipmentManagement.ContainerOnOffhire");
	try {
			SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
			strUsr_id = account.getUsr_id();
			strUsr_nm = account.getUsr_nm();
			strOfc_cd = account.getOfc_cd();				
			event = (EesMst0025Event) request.getAttribute("Event");
			serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
			if (serverException != null) {
					strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
			}
			
			strPgmNo = StringUtil.xssFilter(request.getParameter("pgmNo"));
			if (strPgmNo == null)
				strPgmNo = "";
			// adding logic to get data from server when first loading ..
			GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch (Exception e) {
			out.println(e.toString());
	}
%>


<script type="text/javascript">
		function setupPage(){
				var errMessage = "<%=strErrMsg%>";
				if (errMessage.length >= 1) {
						ComShowMessage(errMessage);
				} // end if
				strOfcCd = "<%=strOfc_cd%>";		
				loadPage();
		}
</script>

<form name="form"><input type="hidden" name="f_cmd"> 
<input id="pagerows" name="pagerows" type="hidden" />
<input type="hidden" name="input_cntr_sts_evnt_dt" id="input_cntr_sts_evnt_dt">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<% if("EES_MST_0025".equals(strPgmNo)) { %>
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<% } else { %>
	<h2 class="page_title"><button type="button"><span id="">Container Force Transfer Creation (EES_MST_1025)</span></button></h2>
	<% } %>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>
	</div>
	<!-- opus_design_btn(E) -->
	<% if("EES_MST_0025".equals(strPgmNo)) { %>
	<div class="location"><span id="navigation"></span></div>
	<% }else{ %>
	<div class="location"><span id="">Equipment Management > CNTR Master > Status > Container Force Transfer Creation</span></div>
	<% } %>
</div>
<!-- page_title_area(E) -->

<div class= "wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="10" />
				<col width="70" />
				<col width="160" />
				<col width="50" />
				<col width="160" />
				<col width="50" />
				<col width="300" />
				<col width="*" />
			</colgroup>
			<tr>
				<td></td>
				<th>Status Code</th>
				<td>
					<select style="width: 120px; text-align:center;" class="input1" name="input_cntr_sts_cd" id="input_cntr_sts_cd">
						<% if(OfficeCodeMgr.checkContainOfficeCode("000001", "MST",strOfc_cd)  ){ %>
							<% if("EES_MST_0025".equals(strPgmNo)) { %>
								<option value="LST" selected>Lost</option>
								<option value="FND">Found</option>
							 <% } else { %>
								<option value="RPC" selected>Force Transfer</option>
							 <% } %>
						<% } else {%>
								<option value="LST" selected>Lost</option>
						<% }%>		
					</select>
				</td>
				<th>Date</th>
				<td><input style="width: 100px;text-align:center;" class="input1" dataformat="ymd" name="input_cntr_sts_evnt_dt2" id="input_cntr_sts_evnt_dt2" style="ime-mode:disabled" maxlength="10" style="text-align:center"><button type="button" class="calendar ir" name="btns_calendar1" id="btns_calendar1"></button></td>
				<th>Yard</th>
				<td><input type="text" id="input_onh_yd_cd" style="width: 105px;text-align:center;" class="input1" dataformat="engup" name="input_onh_yd_cd" maxlength="7"  /><!-- 
				--><button type="button" class="input_seach_btn" name="ComOpenPopupWithTarget1" id="ComOpenPopupWithTarget1" ></button><!-- 
				--><input type="text" id="yd_cd_nm" style="width: 225px;" class="input2" readonly value=""  name="yd_cd_nm" /></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->	
</div>
<div class="wrap_result">
 <!-- opus_design_grid(S) -->
<div class="opus_design_grid">
    <div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_master" id="btn_master">Master</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_add" id="btn_add">Row Add</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Delete</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_loadexcel" id="btn_loadexcel">Load Excel</button>
	</div>
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
</div>
<!-- opus_design_grid(E) -->
</form>