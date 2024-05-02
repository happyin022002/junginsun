<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0215.jsp
*@FileTitle  : Add Call Information (Pop-Up)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/16
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0215Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import = "com.clt.framework.component.util.StringUtil" %>  
<% 
	VopVsk0215Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.scheduleplanningoperation.vesselschedulemgt");

	String hiddenTurn = "";
	String hiddenEta = "";
	String showYard = "";
	String portCd = "";
	String srcYdCd = "";

	String posFlg = "";		//position(Before, After) Disabled Flag
	
	String	sVirtualAddCallPortViewFlg	= "";
	String	sVirtualAddCallPortTgtFlg	= "";
	
	String  sAddCallExternalViewFlg		= "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopVsk0215Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		hiddenTurn = request.getParameter("hiddenTurn");
		hiddenEta = request.getParameter("hiddenEta");
		showYard = request.getParameter("showYard");

		// in case Add Calling to Added port at Long Range SKD Creation, portCd and srcYdCd value exist
		portCd = request.getParameter("portCd");
		portCd = portCd==null?"":portCd.trim();
		srcYdCd = request.getParameter("ydCd");

		// if srcYdCd length is 7, using last 2 words, else using srcYdCd
		srcYdCd = srcYdCd==null?"":srcYdCd.trim().length()==7?srcYdCd.substring(5, 7):srcYdCd.length()==2?srcYdCd:"";

		posFlg 						= request.getParameter("pos_flg");
		sVirtualAddCallPortViewFlg	= request.getParameter("virtual_add_call_port_view_flg") 	== null?"":request.getParameter("virtual_add_call_port_view_flg");
		sVirtualAddCallPortTgtFlg	= request.getParameter("virtual_add_call_tgt_flg") 			== null?"":request.getParameter("virtual_add_call_tgt_flg");
		
		sAddCallExternalViewFlg		= request.getParameter("add_call_xter_flg") 				== null?"":request.getParameter("add_call_xter_flg");
		sAddCallExternalViewFlg		= "Y";
		
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
<input type="hidden" name="pos_flg" value="<%=posFlg %>" id="pos_flg" />
<input type="hidden" name="vt_add_call_tgt_flg" 	value="<%=sVirtualAddCallPortTgtFlg%>" 	id="pos_flg" />
<input type="hidden" name="add_call_xter_tgt_flg" 	value="<%=sAddCallExternalViewFlg%>" 	id="pos_flg" />

<%if("Y".equals(hiddenEta)){%>
<!-- 
<input type="hidden" name="eta_day" id="eta_day" />
<input type="hidden" name="eta_time" id="eta_time" />
 -->
<%} %>
<input type="hidden" name="showYard" value="<%=StringUtil.xssFilter(showYard)%>" id="showYard" />
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Add Call Information</span></h2>
		<div class="opus_design_btn"><!-- 
			 --><button type="button" class="btn_accent" name="btn_ok" id="btn_ok">OK</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_close"  	id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">	
		<div class="opus_design_inquiry">
		
			<br>
			<table>
				<colgroup>
					<col width="120">
					<col width="60">
					<col width="60">
					<col width="*">
				</colgroup>
				<% if("Y".equals(sVirtualAddCallPortViewFlg)){ %>
				<tr>
					<th>Special Indicator</th>
					<th><input type="checkbox" name="vt_add_call_flg" value="" class="trans" id="vt_add_call_flg" /><label style="color:blue;">Virtual Add Calling Port</label></th>
					<th></th>
					<td></td>
				</tr>

				<tr>
					<th>e-Comm Indicator</th>
					<th align="left"><input type="checkbox" name="add_call_xter_flg" value="" class="trans" id="add_call_xter_flg"/><label style="color:blue;">Add Calling Remarks &nbsp;&nbsp;&nbsp;</label></th>
					<th></th>
					<td></td>
				</tr>
				<%}%>
								
				<tr>
					<td></td>
					<th>&nbsp;</th>
				</tr>
				
			</table>		
		
			<table> 
				<colgroup>
					<col width="120">
					<col width="*">
				</colgroup>
				
				<tr>
					<th>Port</th>
					<td>
					<%if("".equals(portCd)){%>
						<input type='text' name="port_cd" id="port_cd" dataformat="engup" maxlength="5" style="width:50px;ime-mode:disabled;text-align:center" class="input1" value="" tabindex="1"><!--  
						--><button type="button" name="btn_search1" id="btn_search1" class="input_seach_btn"></button>
						<%if("Y".equals(showYard)){ %>
							<script type="text/javascript">ComComboObject('yd_cd',2,45,1,0);</script><input type="hidden" name="yard_cd" id="yard_cd" value="<%=srcYdCd%>">
						<%}else{%>
							<input type="hidden" name="yard_cd" value="" id="yard_cd" />
						<%} %>
					<%}else{ %>
						<input type='text' name="port_cd" id="port_cd" value="<%=StringUtil.xssFilter(portCd)%>" style="width:50px;ime-mode:disabled;text-align:center" class="noinput" tabindex="1" readonly>
						<%if("Y".equals(showYard)){ %>
							<%if("".equals(srcYdCd)){%>
								<script type="text/javascript">ComComboObject('yd_cd',2,45,1,0);</script><input type="hidden" name="yard_cd" id="yard_cd" value="<%=srcYdCd%>">
							<%}else{ %>
								<input type="text" value="<%=srcYdCd%>" style="width:30;ime-mode:disabled;text-align:center" class="noinput" tabindex="2" readonly><input type="hidden" name="yard_cd" id="yard_cd" value="<%=portCd + srcYdCd%>">
							<%} %>
						<%}else{ %>
							<input type="hidden" name="yard_cd" value="" id="yard_cd" />
						<%} %>
					<%}%>
					</td>
				</tr>
				<% if(!"Y".equals(hiddenEta)){ %>
				<tr>
					<th>ETA</th>
					<td><input type="text" name="eta_day" style="width:80px;text-align:center;" dataformat="ymd" class="input" tabindex="3" id="eta_day" /><!-- 
					 --><button type="button" id="eta_btn_cal" name="eta_btn_cal" class="calendar ir"></button><!-- 
					 --><input type="text" name="eta_time" maxlength="4" dataformat="hm" style="width:40px;text-align:center;" class="input1" dataformat="hm" value="00:00" tabindex="4" id="eta_time" nextstop/><!-- 
					 --><input type="text" style="width:84px" class="noinput2" value="(YYYYMMDD)"  tabindex="-1" readonly>
					</td>
				</tr>
				<%} %>
				<tr>
					<th>ETB</th>
					<td><input type="text" name="etb_day" style="width:80px;text-align:center;" dataformat="ymd" class="input" tabindex="5" id="etb_day" /><!-- 
					 --><button type="button" id="etb_btn_cal" name="etb_btn_cal" class="calendar ir"></button><!-- 
					 --><input type="text" name="etb_time" maxlength="4" dataformat="hm" style="width:40px;text-align:center;" class="input1" dataformat="hm" value="00:00" tabindex="6" id="etb_time" nextstop/><!-- 
					 --><input type="text" style="width:84px" class="noinput2" value="(YYYYMMDD)"  tabindex="-1" readonly>
					</td>
				</tr>
				<tr>
					<th>ETD</th>
					<td><input type="text" name="etd_day" style="width:80px;text-align:center;" dataformat="ymd" class="input" tabindex="7" id="etd_day" /><!-- 
					 --><button type="button" id="etd_btn_cal" name="etd_btn_cal" class="calendar ir"></button><!-- 
					 --><input type="text" name="etd_time" maxlength="4" dataformat="hm" style="width:40px;text-align:center;" class="input1" dataformat="hm" value="00:00" tabindex="8" id="etd_time" nextstop/><!-- 
					 --><input type="text" style="width:84px" class="noinput2" value="(YYYYMMDD)"  tabindex="-1" readonly>
					</td>
				</tr>
				<% if("Y".equals(hiddenTurn)){ %>
				<tr>
					<td colspan="2"></td>
				</tr>
				<%}else{ %>
				<tr>
					<th>Turn</th>
					<td><select name="turn_ind" id="turn_ind" style="width:80px;" class="input" tabindex="9"><!-- 
						 --><option value="0" >Y</option><!-- 
						 --><option value="1" selected>N</option></select>
					</td>
				</tr>
				<%}%>
			</table>
			
			<br>
			<table>
				<colgroup>
					<col width="120">
					<col width="60">
					<col width="60">
					<col width="*">
				</colgroup>
				<% if("".equals(portCd)){ %>
				<tr>
					<th>Position</th>
					<th><input type="radio" name="position" value="before" class="trans" id="position1" /><label for="position1"> Before</label></th>
					<th><input type="radio" name="position" class="trans" value="after" checked id="position2" /><label for="position2">After</label></th>
					<td></td>
				</tr>
				<%}else{ %>
				<tr>
					<td></td>
					<th>&nbsp;</th>
				</tr>
				<%} %>
			</table> 
		</div>
		<!-- opus_design_inquiry(E) -->
		
		<div class="wrap_result" style="display: none;">
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid" id="mainTable">
				<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>
			<!-- opus_design_grid(E) -->
			</div>
		</div>
</form>
