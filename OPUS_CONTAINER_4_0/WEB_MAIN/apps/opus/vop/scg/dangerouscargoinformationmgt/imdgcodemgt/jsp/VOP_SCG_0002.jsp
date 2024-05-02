<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_scg_0002.jsp
*@FileTitle  : UN Number (Inquiry)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.event.VopScg0002Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0002Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						////count of DB resultSET list
	
	String successFlag 	= "";
	String codeList  	= "";
	String pageRows  	= "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	Logger log = Logger.getLogger("com.clt.apps.DangerousCargoInformationMgt.IMDGCodeMgt");
	
	String pop_yn      = "";
	String imdg_un_no  = "";
	String imdg_tec_nm = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (VopScg0002Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// add logic data extracting from server when loading initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		pop_yn      = request.getParameter("pop_mode")==null?"N":"Y";
		imdg_un_no  = request.getParameter("imdg_un_no")==null?"":request.getParameter("imdg_un_no");		
		imdg_tec_nm = request.getParameter("imdg_tec_nm")==null?"":request.getParameter("imdg_tec_nm");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script  type="text/javascript">
	
	//call popup and initial retrieve condition
	var preConds = {
		pop_yn       : "<%=StringUtil.xssFilter(pop_yn)%>",
		imdg_un_no   : "<%=StringUtil.xssFilter(imdg_un_no)%>",
		imdg_tec_nm  : "<%=StringUtil.xssFilter(imdg_tec_nm)%>"
	}
	
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
		if('Y' == preConds.pop_yn) {		
			//show close button
			//@@주석 document.all.popLayer.style.display = ""; 

			try {
				var appName = navigator.appName;
			 	if (appName.indexOf("Netscape") == -1) {
			  		//@@주석 document.all.pophistory.innerHTML = "";
			 	} else {
			  		//@@주석 document.getElementById("pophistory").innerHTML = "";
			 	}
			}catch(err) {
			 	ComShowMessage(err);
			}
		}
		
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<% if (pop_yn=="Y") { %>
<div class="layer_popup_title">

<% } %>

<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	    
	    <!-- page_title(S) -->
	    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	    <!-- page_title(E) -->
	         
	   
	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_New"  	id="btn_New">New</button><!--
			 --><button type="button" class="btn_normal" name="btn_DownExcel" 	id="btn_DownExcel">Down Excel</button>
<% if (pop_yn=="Y") { %>
			 <button type="button" class="btn_normal" name="btn_OK" 	id="btn_OK">OK</button><!--
			 --><button type="button" class="btn_normal" name="btn_Close" 	id="btn_Close">Close</button>

<% } %>
	    </div>
	    <!-- opus_design_btn(E) -->

<% if (pop_yn=="Y") { %>


<% }else{ %>
	    <!-- page_location(S) -->
	    <div class="location">
	        <!-- location 내용 동적생성 (별도 코딩 불필요) -->
	        <span id="navigation"></span>
	    </div>
	    <!-- page_location(E) -->
<% } %>
	</div>

<% if (pop_yn=="Y") { %>
</div>

<div class="layer_popup_contents">
<% } %>
	<!-- page_title_area(E) -->
<div class= "wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="150" />
				<col width="70" />
				<col width="70" />
				<col width="80" />
				<col width="100" />
				<col width="100" />
				<col width="80" />
				<col width="*" />
			</colgroup>

			<tbody>
				<tr>
				    <th>Amdt No.</th>
				    <td><script>ComComboObject('imdg_amdt_no', 1, 60, 1);</script><input type="hidden" name="crte_imdg_un_no" id="crte_imdg_un_no" /></td>				
					<th>UN No.</th>
					<td><input type="text" name="imdg_un_no" id="imdg_un_no" caption="UN No." maxlength="4" style="width:50px;ime-mode:disabled;" class="input" value=""></td>
					<th>Class or division</th>
					<td>
						<script  type="text/javascript">ComComboObject('imdg_clss_cd', 1, 60, 0);</script><script  type="text/javascript">ComComboObject('imdg_comp_grp_cd', 1, 40, 0);</script>
					</td>
					<th>Restrictions</th> 
					<td>
						<select name="imdg_crr_rstr_expt_cd" id="imdg_crr_rstr_expt_cd" style="width:216px;" class="input">
							<option value="">All</option>
							<option value="N">None</option>
							<option value="P">Prohibited</option>
							<option value="R">Restricted</option>
							<option value="C">Excepted fm Class Prohibition</option>
							<option value="T">T/S Prohibited</option>
							<option value="L">Prohibited on Lane</option>
						</select>
					</td>
				</tr> 
				<tr>
					<th>Proper Shipping Name</th>
					<td colspan="7"><input type="text" name="imdg_tec_nm" id="imdg_tec_nm" caption="UN No." style="width:728px;ime-mode:disabled;" class="input" value=" "></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
	<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid">
		
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			<script  type="text/javascript">ComSheetObject('sheet1');</script>
		<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
</div>
<!-- opus_design_grid(E) -->

<% if (pop_yn=="Y") { %>
</div>
<% } %>



</form>

<%@include file="/bizcommon/include/common_opus.jsp"%>