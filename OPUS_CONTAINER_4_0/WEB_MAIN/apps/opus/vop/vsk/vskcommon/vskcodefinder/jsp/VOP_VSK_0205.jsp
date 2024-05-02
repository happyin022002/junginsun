<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_vsk_0205.jsp
*@FileTitle  : Phase In/Out Information (pop-up)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/16
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.event.VskGloEvent"%>
<%@ page import="com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.PhaseInOutReasonVO"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import = "com.clt.framework.component.util.StringUtil" %> 
<% 
	VskGloEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.vskcommon.vskcodefinder");

	String phaseType = null;
	String clptIndSeq = null;
	//String[] portList = null;
	List<PhaseInOutReasonVO> list = null;
	String dirCd = null;
	String[] dirCds = null;

	String vpsPortCd = null;
	String[] vpsPortCds = null;
	String firstPortCds = null;
	String secondPortCds = null;


	String parentUI = null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (VskGloEvent)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		list = eventResponse.getRsVoList();

		//////////////////////////

		phaseType = (String)event.getAttribute("sPhaseType");
		
		clptIndSeq = (String)event.getAttribute("sClptIndSeq");
		//portList = ((String)event.getAttribute("sPortList")).split("\\|");

		dirCd = request.getParameter("dir_cd");
		dirCd = dirCd==null?"":dirCd;

		if(dirCd.indexOf("|")>0){
			dirCds = dirCd.split("\\|");
		}

		vpsPortCd = request.getParameter("port_cd");
		vpsPortCd = vpsPortCd==null?"":vpsPortCd;

		firstPortCds = request.getParameter("first_port_cd");
		firstPortCds = firstPortCds==null?"":firstPortCds;

		secondPortCds = request.getParameter("second_port_cd");
		secondPortCds = secondPortCds==null?"":secondPortCds;

		if(firstPortCds.indexOf("|")>0){
			vpsPortCds = firstPortCds.split("\\|");
		}

		parentUI = request.getParameter("parentUI");

		//////////////////////////

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<%
	if("I".equals(phaseType)){
		out.print("<title>Phase In Information</title>");
	}else if("O".equals(phaseType)){
		out.print("<title>Phase Out Information</title>");
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

<input type="hidden" name="phaseType" value="<%=phaseType %>" id="phaseType" />
<input type="hidden" name="src_clpt_ind_seq" value="<%=clptIndSeq %>" id="src_clpt_ind_seq" />
<input type="hidden" name="dst_clpt_ind_seq" value="<%=clptIndSeq %>" id="dst_clpt_ind_seq" />
<input type="hidden" name="parentUI" value="<%=StringUtil.xssFilter(parentUI)%>" id="parentUI" />

<input type="hidden" name="firstPortCds" value="<%=StringUtil.xssFilter(firstPortCds)%>" id="firstPortCds" />
<input type="hidden" name="secondPortCds" value="<%=StringUtil.xssFilter(secondPortCds)%>" id="secondPortCds" />

<div class="layer_popup_title">

	<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span><%= "I".equals(phaseType)?"Phase In":"O".equals(phaseType)?"Phase Out":"" %></span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_OK" 		id="btn_OK">Ok</button>
		<button type="button" class="btn_normal" name="btn_Close" 	id="btn_Close">Close</button>		
	</div>
	<!-- opus_design_btn(E) -->
	
</div>
<!-- page_title_area(E) -->
	
</div>

<div class="layer_popup_contents">
	
	<!-- wrap_search(S) -->
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="150" />	
					<col width="200" />
					<col width="120" />
					<col width="*"   />
			   </colgroup> 
		   		<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" name="src_vsl_cd"     id="src_vsl_cd"     style="width:45px;ime-mode:disabled;text-align:center" class="input1" maxlength="4" value="<%=event.getAttribute("sVslCd")%>" readOnly>
						<input type="text" name="src_skd_voy_no" id="src_skd_voy_no" style="width:45px;ime-mode:disabled;text-align:center" class="input1" maxlength="4" value="<%=event.getAttribute("sVoyNo")%>" readOnly>
						<%if(dirCds==null){%>
						<input type="text" name="src_skd_dir_cd" id="src_skd_dir_cd" style="width:20px;ime-mode:disabled;text-align:center" class="input1" maxlength="1" value="<%=StringUtil.xssFilter(dirCd)%>" readOnly>
						<%}else{ // CHM-201005617-01 %>
						<select name="src_skd_dir_cd" id="src_skd_dir_cd" onchange="changePortList()">
							<%for(int i=0; i<dirCds.length; i++){ %>
								<option value="<%=dirCds[i]%>"><%=dirCds[i]%></option>
							<%} %>
						</select>
						<%} %>
						<%if("I".equals(phaseType)){%>
							<button type="button" id="btns_search1" name="btns_search1" class="input_seach_btn"></button>
						<%} %>
					</td>
					<th>Call Indicator</th>
					<td><select style="width:121px;" class="input1" name="clpt_ind_seq_1" id="clpt_ind_seq_1"><option value="1">First</option><option value="2">Second</option><option value="3">Third</option><option value="4">4th</option><option value="5">5th</option><option value="6">6th</option><option value="7">7th</option><option value="8">8th</option><option value="9">9th</option><option value="10">10th</option></select></td>
		   		</tr>
		   	</table>
	   		<table>
			   	<% if("I".equals(phaseType) || "O".equals(phaseType)){ %>
				<colgroup>
					<col width="150" />				
					<col width="200" />				
					<col width="120" />				
					<col width="*" />				
			   </colgroup>
			   <tr>
			   <%}else{%>
			   <colgroup>
			   		<col width="150" />
					<col width="*" />				
			   </colgroup>
			   <tr>	
			   <td></td>
				</tr>
			   <%}%>
			</table>
	   		<table>
				<colgroup>
					<col width="150" />				
					<col width="200" />				
					<col width="120" />				
					<col width="*" />				
			   </colgroup>
			   <!-- 2014.12.29 dongsoo 
			        P/F SKD Date 화면에서 삭제 요청 
				<tr>
					<td></td>
					<td></td>
					<th>P/F SKD Date</th>
					<td>
					<%if("I".equals(phaseType)){%>
						<input type="text" style="width:87px;text-align:center" class="input1" dataformat="ymd" maxlength="8" name="src_pf_date" id="src_pf_date" value="<%=StringUtil.xssFilter(request.getParameter("src_pf_date"))%>"><button type="button" id="btns_cal11" name="btns_cal11" class="calendar ir"></button>
					<%} %>
					</td>
				</tr>
				 -->
			</table>
		   	<table>
				<colgroup>
					<col width="150" />				
					<col width="200" />				
					<col width="120" />				
					<col width="*" />				
			   </colgroup>
				<tr>
					<th>Lane</th>
					<td><input type="text" name="src_vsl_slan_cd" id="src_vsl_slan_cd" style="width:126px;text-align:center" class="input2" value="<%=event.getAttribute("sVslSlanCd")%>" readonly></td>
					<th>Port Code</th>
					<td>
						<%if(!"".equals(vpsPortCd)){ %>
						<input type="text" name="src_port_cd" id="src_port_cd" style="width:121px;text-align:center" class="input1" value="<%=StringUtil.xssFilter(vpsPortCd)%>" readonly>
						<%}else{ // CHM-201005617-01%>
						<select name="src_port_cd" id="src_port_cd">
							<%if(vpsPortCds!=null)for(int i=0; i<vpsPortCds.length; i++){ %>
							<option value="<%=vpsPortCds[i]%>"><%=vpsPortCds[i]%></option>
							<%} %>
						</select>
						<%} %>
					</td>
				</tr>
			</table>
		   	<table>
				<colgroup>
					<col width="150" />
					<col width="*" />
			   </colgroup>
				<tr class="h23">
					<th>Reason</th>
					<td>
						 <select style="width:126px;" class="input" name="phase_rsn_code" id="phase_rsn_code">
						 <% if(list != null){
							    for(int i=0; i<list.size(); i++){ 
							        PhaseInOutReasonVO vo = list.get(i);
							        if("O".equals(phaseType) && ("DO".equals(vo.getRsnCode()) || "LC".equals(vo.getRsnCode()) || "O".equals(vo.getRsnCode()) || "SO".equals(vo.getRsnCode()) || "OD".equals(vo.getRsnCode()) || "OL".equals(vo.getRsnCode()) || "TO".equals(vo.getRsnCode())) ){
					     %>
						 		    	<option value="<%=vo.getRsnName()%>"><%=vo.getRsnCode()%></option>
						 		    	
 						 <%         }else if("I".equals(phaseType) && ("DC".equals(vo.getRsnCode()) || "DS".equals(vo.getRsnCode()) || "DV".equals(vo.getRsnCode()) || "I".equals(vo.getRsnCode()) || "LC".equals(vo.getRsnCode()) || "SI".equals(vo.getRsnCode())) ){
 						 %>	 
 			 		    				<option value="<%=vo.getRsnName()%>"><%=vo.getRsnCode()%></option>
 						 <%
 						 			}
 						        }
							} 
 						 %>
						 </select><input type="text" style="width:311px;" class="input2" value="" name="phase_rsn_name" id="phase_rsn_name">
					</td>
				</tr>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	<!-- wrap_search(E) -->
	
	<!-- wrap_result(S) -->
	<div class="wrap_result" style="display: none;">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable"  style="display: none;">
			<script type="text/javascript">ComSheetObject('sheet1');</script>		
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	<!-- wrap_result(E) -->
</div>
</form>