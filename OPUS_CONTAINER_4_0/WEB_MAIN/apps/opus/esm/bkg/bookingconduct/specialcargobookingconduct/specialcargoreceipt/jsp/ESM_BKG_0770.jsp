<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0770.js
*@FileTitle  : VVD Selection Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/02
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event.EsmBkg0770Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0770Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SpecialCargoBookingConduct.SpecialCargoReceipt");
	
	String imdg_pck_tp_cd = "";
	String pck_tp_seq = "";
	String imdg_emer_no = "";
	String ctrl_temp_ctnt = "";
	String emer_rspn_gid_no = "";
	String emer_rspn_gid_chr_no = "";
	String emer_temp_ctnt = "";	
	String erap_no = "";
	String erap_cntc_no = "";
	String erap_apro_ref_no ="";
	String pop_type = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0770Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		imdg_pck_tp_cd =  JSPUtil.getParameter(request, "imdg_pck_tp_cd");
		pck_tp_seq =  JSPUtil.getParameter(request, "pck_tp_seq");
		imdg_emer_no =  JSPUtil.getParameter(request, "imdg_emer_no");
		ctrl_temp_ctnt =  JSPUtil.getParameter(request, "ctrl_temp_ctnt");
		emer_rspn_gid_no =  JSPUtil.getParameter(request, "emer_rspn_gid_no");
		emer_rspn_gid_chr_no =  JSPUtil.getParameter(request, "emer_rspn_gid_chr_no");
		emer_temp_ctnt =  JSPUtil.getParameter(request, "emer_temp_ctnt");
		erap_no = JSPUtil.getParameter(request, "erap_no");
		erap_cntc_no = JSPUtil.getParameter(request, "erap_cntc_no");
		erap_apro_ref_no = JSPUtil.getParameter(request, "erap_apro_ref_no");
		pop_type = JSPUtil.getParameter(request, "pop_type");
		

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
		
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="imdg_pck_tp_cd" id="imdg_pck_tp_cd" />
<input type="hidden" name="pck_tp_seq" id="pck_tp_seq" />
<input type="hidden" name="pop_type" id="pop_type" value="<%=pop_type%>"/>
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Other Emergency and Reefer Information</span></h2>
		
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_ok" id="btn_ok" type="button">OK</button><!--
			--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button><!--
			--></div>
	</div>
</div>
<!-- page_title_area(E) -->
<div class="layer_popup_contents">
	<!-- wrap_search(S) -->
	<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="10" />
				<col width="100" />
				<col width="100" />
				<col width="*" />
			</colgroup>
			
	<%if(pop_type.equals("PR") || pop_type.equals("PA")){ %>
			<tbody>
				<tr class="h23">
					<th>EMS No</th>
					<!-- 2010.07.12 수정 read only처리함 By KHH-->	
					<!--  <td width="170"><input name="imdg_emer_no" type="text" style="width:124;" class="input" value="<%=imdg_emer_no%>" maxlength="10"></td> -->
					<td><input name="imdg_emer_no" type="text" style="width:124px;" class="input2" value="<%=imdg_emer_no%>" maxlength="14" readonly id="imdg_emer_no" /></td>
					<th>Control Temp</th>
					<td><input name="ctrl_temp_ctnt" type="text" style="width:90px; text-align:right;" class="input" value="<%=ctrl_temp_ctnt%>" maxlength="5" id="ctrl_temp_ctnt" />  °C</td>
				</tr>
				<tr class="h23">
					<th>ERG</th>
					<td><input name="emer_rspn_gid_no" type="text" style="width:90px;" class="input" value="<%=emer_rspn_gid_no%>" maxlength="3" id="emer_rspn_gid_no" /><input name="emer_rspn_gid_chr_no" type="text" style="width:30px;" class="input" value="<%=emer_rspn_gid_chr_no%>" maxlength="2" id="emer_rspn_gid_chr_no" /></td>
					<th>Emergency Temp</th>
					<td><input name="emer_temp_ctnt" type="text" style="width:90px; text-align:right;" class="input" value="<%=emer_temp_ctnt%>" maxlength="4" id="emer_temp_ctnt" />  °C</td>
				</tr>
			</tbody>
		</table>
	<%}else{ %>
			<tbody>
				<tr class="h23">
					<th>EMS No</th>
					<!-- 2010.07.12 수정 read only처리함 By KHH-->	
					<!--  <td width="170"><input name="imdg_emer_no" type="text" style="width:124;" class="input" value="<%=imdg_emer_no%>" maxlength="10"></td> -->
					<td><input name="imdg_emer_no" type="text" style="width:124px;" class="input2" value="<%=imdg_emer_no%>" maxlength="14" readonly id="imdg_emer_no" /></td>
					<th>Control Temp</th>
					<td><input name="ctrl_temp_ctnt" type="text" style="width:90px; text-align:right;" class="input" value="<%=ctrl_temp_ctnt%>" maxlength="5" id="ctrl_temp_ctnt" />  °C</td>
				</tr>
				<tr class="h23">
					<th>ERG</th>
					<td><input name="emer_rspn_gid_no" type="text" style="width:90px;" class="input" value="<%=emer_rspn_gid_no%>" maxlength="3" id="emer_rspn_gid_no" /><input name="emer_rspn_gid_chr_no" type="text" style="width:30px;" class="input" value="<%=emer_rspn_gid_chr_no%>" maxlength="2" id="emer_rspn_gid_chr_no" /></td>
					<th>Emergency Temp</th>
					<td><input name="emer_temp_ctnt" type="text" style="width:90px; text-align:right;" class="input" value="<%=emer_temp_ctnt%>" maxlength="4" id="emer_temp_ctnt" />  °C</td>
				</tr>
				<tr class="h23">
					<th>ERAP</th>
					<td><input name="erap_no" type="text" style="width:120px;" class="input" value="<%=erap_no%>" id="erap_no" /></td>
					<th>ERAP CONTRACT NO.:</th>
					<td><input name="erap_cntc_no" type="text" style="width:120px;" class="input" value="<%=erap_cntc_no%>" id="erap_cntc_no" /></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="180" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr class="h23">
					<th>ERAP APPROVAL REFERENCE:</th>
					<td><input name="erap_apro_ref_no" type="text" style="width:260px;" class="input" value="<%=erap_apro_ref_no%>" id="erap_apro_ref_no" /></td>
				</tr>
			</tbody>
		</table>
	<%} %>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
</div>
</form>
<SCRIPT type="text/javascript">


<%
	// Popup 모드 (1: function 호출형, 2: target 세팅형)
	String pop_mode = request.getParameter("pop_mode");	
	if(pop_mode == null || pop_mode.equals(""))
		pop_mode = "1";

	// 호출할 부모창의 스크립트 메소드 (pop_mode가 1(function 호출형) 인 경우)
	String func  = request.getParameter("func");

	// 값을 세팅할 부모창의 Object목록 (pop_mode가 2(target 세팅형) 인 경우)
	String targetObjList = request.getParameter("targetObjList");
	
	// Multi Sheet인 경우, 데이터를 가져올 Sheet 정보
	String sheet = request.getParameter("sheet");	
	
	// Multi Sheet인 경우, Sheet의 Index 정보
	String sheetIdx = request.getParameter("sheetIdx");
	
	// Sheet에서 팝업 호출시, Target이 되는 Cell의 row/col 정보
	String row = request.getParameter("row");
	String col = request.getParameter("col");	
	
	String strDisplay = request.getParameter("display");
	String strPopOpt  = null;
	String popKind	  = null;
%>

	// 부모창의 function을 호출
	function comPopupOK() {
		<%
			if(func == null || func.equals("")) {
		%>
				window.close();
				return;
		<%
			}
		%>

		var item = document.getElementsByTagName("input");

		//alert("item.length : [" + item.length + "]");

		var rArray =  new Array(1); //데이터를 담고 있는 배열
		rArray[0] = new Array(item.length);

		for (var i=0; i < item.length; i++) {
			//
			if ( item[i].type == "text" || item[i].type == "hidden" ) {
				//
				rArray[0][i] = item[i].value;
			}
		}

		//alert("rArray[0] : [" + rArray[0] + "]");

		// 모달창인 경우는 window 객체로부터 opener를 획득
		if(!opener)
			opener = window.dialogArguments;
		
		try {
			<%
				if(func != null && !func.equals("")) {					
					if(row != null && col != null) {
						if(sheetIdx != null && sheetIdx != "") {
			%>
							opener.<%= func %>(rArray, <%=row%>, "<%=col%>", <%=sheetIdx%>);
							window.close();
			<%
						} else {
			%>
							opener.<%= func %>(rArray, <%=row%>, "<%=col%>");
							window.close();
			<%
						}
					} else {
			%>
						opener.<%= func %>(rArray);
						window.close();
			<%
					}
				}
			%>
		}
		catch(e) {
		 	//ComShowCodeMessage("COM12111");
			
		}
	}


</SCRIPT>