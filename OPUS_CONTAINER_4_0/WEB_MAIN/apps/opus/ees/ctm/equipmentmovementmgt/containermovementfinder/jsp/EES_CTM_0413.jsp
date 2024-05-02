<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CTM_0413.jsp
*@FileTitle  :  BKG/MVMT VL/VD Unmatch
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/15
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0413Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCtm0413Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String mainpage = "";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.EquipmentMovementMgt.ContainerMovementFinder");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		mainpage = request.getParameter("main_page");
		event = (EesCtm0413Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}

  String vvdCd = (request.getParameter("vvdCd") == null)? "": request.getParameter("vvdCd");
  String etdDt = (request.getParameter("etdDt") == null)? "": request.getParameter("etdDt");
  String stsCd = (request.getParameter("stsCd") == null)? "VL": request.getParameter("stsCd");
  if (stsCd.equals("")) stsCd = "VL";
  String yard  = (request.getParameter("yard") == null)? "": request.getParameter("yard");
  String yard1 = (yard.length() == 7)? yard1 = yard.substring(0,5) : "";
  String yard2 = (yard.length() == 7)? yard2 = yard.substring(5,7) : "";

  // pop_mode
  String popMode = (request.getParameter("pop_mode") == null)? "N": "Y";
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
<!-- developer job	-->
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="p_yard" id="p_yard" value="<%=yard%>">

<!-- page_title_area(S) -->
<% if(popMode.equals("Y")){ %>
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><!--button type="button"><span id="title"-->BKG/MVMT VL/VD unmatch Inquiry<!--/span></button--></h2>
	<!-- page_title(E) -->
<%}else{ %>
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
<%} %>
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_new"  	id="btn_new">New</button>
		<%if(popMode.equals("Y")){ %>
			<button type="button" class="btn_normal" name="btn_close"  	id="btn_close">Close</button>
		<%} %>			
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry">
	<style>
		.Obj1 {background:#C9FD86 !important;} 
 		.Obj2 {background:#FFFFFF !important;}
	</style>
	<table>
		<tbody>
			<colgroup>
				<col width="80" />
				<col width="150" />
				<col width="60" />
				<col width="60" />
				<col width="70" />
				<col width="230" />
				<col width="50"/>
				<col width="100" />
				<col width="*"/>
			</colgroup>
			<tr>
				<th>T/VVD</th>
				<td><input type="text" style="width:80px;" class="input1" value="<%=vvdCd%>" name="vls_cd" id="vls_cd" maxlength="9" tabindex="1" dataformat ="engup"></td>
				<th>Port</th>
				<td><input type="text" style="width:50px;" class="input1" value="<%=yard1%>" name="pol_cd" id="pol_cd" maxlength="5" tabindex="2" dataformat ="engup"><!-- 
					--><input type="text" style="width:40px;" class="input" value="<%=yard2%>" name="yard2" id="yard2" maxlength="5" tabindex="3">
				</td>
				<th class="sm">MVMT</th>
				<td class="sm"><input type="radio" value="RL" name="flgrslt" id="flgrslt" class="trans"  <%if (stsCd.equals("VL")) {%> checked <%}%>>Result VL&nbsp;&nbsp;<!-- 
				 --><input type="radio" class="trans" value="PD" name="flgrslt" id="flgrslt">Plan VD&nbsp;&nbsp;<!-- 
				 --><input type="radio" value="RD" name="flgrslt" id="flgrslt" class="trans" <%if (stsCd.equals("VD")){%> checked <%}%>>Result VD&nbsp;&nbsp;
				</td>
				<td></td>
				<th class="sm">Cargo Type</th>
				<td class="sm"><input type="radio" value="" name="cgo_type" id="cgo_type" class="trans" checked>All&nbsp;&nbsp;<!-- 
				 --><input type="radio" value="F" name="cgo_type" id="cgo_type" class="trans">Full&nbsp;&nbsp;<!-- 
				 --><input type="radio" value="P" name="cgo_type" id="cgo_type" class="trans">Empty
				</td>
			</tr>
		</tbody>
	</table>
	<table>
		<colgroup>
				<col width="80" />
				<col width="310" />
				<col width="70" />
				<col width="150" />
				<col width="*"/>
			</colgroup>
		<tr><td colspan="5"></td></tr>
		<tr>
			<th>ETA/ETD</th>
			<td><input type="text" style="width:130px;" class="input2" value="<%=etdDt%>" name="eta_etd" id="eta_etd" readonly></td>			
			<th class="sm">Local T/S</th>
			<td class="sm">
				<input type="radio" value="" name="locl_type" id="locl_type" class="trans" checked>All&nbsp;&nbsp;<!-- 
				 --><input type="radio" value="N" name="locl_type" id="locl_type" class="trans">Local&nbsp;&nbsp;<!-- 
				 --><input type="radio" value="Y" name="locl_type" id="locl_type" class="trans">T/S
			</td>
			<td ></td>
		</tr>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
<!-- layout_wrap(S) -->
<div class="layout_wrap" style="width:1258px;" >
	<!-- layout_vertical_2(S) -->
	<div class="layout_vertical_2" style="width:40%;">
		<table>
			<tr>
				<td><h3 class="title_design">Booking container List</h3></td>
			</tr>
		</table>
		<div class="opus_design_grid" id="mainTable">
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
				<button type="button" class="btn_normal" name="btn_detail" id="btn_detail">MVMT Inquiry</button>		
			</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- layout_vertical_2(E) -->
	
	<!-- layout_vertical_2(S) -->
	<div class="layout_vertical_2" style="width:20%; padding-left:10px;">
		<table style="margin: 50px 0px;">
			<tr>
				<td style="padding-right: 10px; padding-top:3px; padding-bottom:3px;"><input type="text" style="width:70px;text-align:right" class="input" name="u1" id="u1"></td>
				<td style="padding-right: 10px;"><button style="width: 70px;" type="button" class="btn_etc" name="btn_unmatch" id="btn_unmatch">Unmatch</button></td>
				<td><input type="text" style="width:70px;text-align:right" class="input" name="u2" id="u2"></td>
			</tr>
			<tr>
				<td style="padding-right: 10px; padding-top:3px; padding-bottom:3px;"><input type="text" style="width:70px; text-align:right;" class="input" name="m1" id="m1"></td>
				<td style="padding-right: 10px;"><button style="width: 70px;" type="button" class="btn_etc" name="btn_match" id="btn_match">Match</button></td>
				<td><input type="text" style="width:70px;text-align:right;" class="input" name="m2" id="m2"></td>
			</tr>
			<tr>
				<td style="padding-right: 10px; padding-top:3px; padding-bottom:3px;"><input type="text" style="width:70px;text-align:right;" class="Obj1" name="l1" id="l1"></td>
				<td style="padding-right: 10px;"><button style="width: 70px;" type="button" class="btn_etc" name="btn_total" id="btn_total">Total</button></td>
				<td><input type="text" style="width:70px;text-align:right;" class="Obj1" name="l2" id="l2"></td>
			</tr>
		</table>
	</div>
	<!-- layout_vertical_2(E) -->
	
	<!-- layout_vertical_2(S) -->
	<div class="layout_vertical_2 pad_left_8" style="width:40%; padding-top: 7px; padding-right:10px; float:right;">
		<table>
			<tr>	
				<td>
					<input type="radio" value="" class="trans" checked name="mv_type" id="mv_type" ><b>Movement</b>&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio"  value="B" class="trans" name="mv_type" id="mv_type"><b>Stowage Plan</b>
				</td>
			</tr>
		</table>
		
		<div class="opus_design_grid" id="mainTable" style="padding-right: 0px;">
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_downexcel2" id="btn_downexcel2">Down Excel</button>
				<button type="button" class="btn_normal" name="btn_detail2" id="btn_detail2">MVMT Inquiry</button>		
			</div>
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
	</div>
	<!-- layout_vertical_2(S) -->
</div>
<!-- layout_wrap(E) -->
</div>
</form>