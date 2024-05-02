<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : 
*@FileTitle  : 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23
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
<%@ page import="com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0059Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0059Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;				//error from server
	String strErrMsg 	= "";						//error message
	int rowCount	 	= 0;						//count of DB resultSET list

	String successFlag 	= "";
	String codeList  	= "";
	String pageRows  	= "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	String pop_yn      	= "";
	String imdg_spcl_provi_no  	= "";
	String objName 		= ""; //팝업 객체명
	String pop_type = "";

	Logger log = Logger.getLogger("com.clt.apps.SpecialCargoMasterDataMgt.SpecialCargoMasterDataMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg0059Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// add logic data extracting from server when loading initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		pop_yn      		= request.getParameter("pop_mode")==null?"N":"Y";
		imdg_spcl_provi_no  = request.getParameter("imdg_spcl_provi_no")==null?"":request.getParameter("imdg_spcl_provi_no");
		objName  = request.getParameter("objName")==null?"":request.getParameter("objName");
		pop_type      		= request.getParameter("pop_type")==null?"W":"R";
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<head>
<title>Special Provisions (Inquiry)</title>


<script type="text/javascript">
	//call popup and initial retrieve condition
	var preConds = {
		pop_yn       : "<%=StringUtil.xssFilter(pop_yn)%>",
		imdg_spcl_provi_no   : "<%=StringUtil.xssFilter(imdg_spcl_provi_no)%>",
		objName      : "<%=StringUtil.xssFilter(objName)%>",
		pop_type   : "<%=StringUtil.xssFilter(pop_type)%>"
	}

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		if('Y' == preConds.pop_yn) {					
			//show close button
			document.all.popLayer.style.display = "";
			/* 
			//Set title of page
			var titleStr = "Special Provisions - Inquiry";
			try {
				var appName = navigator.appName;
			 	if (appName.indexOf("Netscape") == -1) {
			  		//document.all.pophistory.innerHTML = "";
			  		document.all.title.innerHTML = '&nbsp; '+titleStr;
			  		document.title = titleStr;
			 	} else {
			  		//document.getElementById("pophistory").innerHTML = "";
			  		document.getElementById("title").innerHTML = '&nbsp; '+titleStr;
			  		document.title = titleStr;
			 	}
			}catch(err) {
			 	ComShowMessage(err);
			} */
		} 

		loadPage();
	}
</script>



<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="rowNo" id="rowNo" />

<% if (pop_yn=="Y") { %>
<!-- body class="popup_bg" onLoad="setupPage();"-->

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Special Provisions - Inquiry</span></h2>		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
			--><button class="btn_normal" name="btn1_Excel" id="btn1_Excel" type="button">Down Excel</button>
		</div>
	</div>
</div>
	
<% }else{ %>

<!-- body  onLoad="setupPage();"-->

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn1_Excel" id="btn1_Excel" type="button">Down Excel</button>
	</div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<% }%>	


<% if (pop_yn=="Y") { %><div class="layer_popup_contents"><%}%>
<!-- page_title_area(E) -->
	<div class="wrap_search">		
		<!-- opus_design_inquiry(S) -->
		<div class= "opus_design_inquiry">
			<table>
				<tbody>
					<colgroup>
						<col width="80"/>
						<col width="*"/>
				    </colgroup>
					<tr>
						<th>Special Provisions</th>
						<td><input type="text" name="imdg_spcl_provi_no" maxlength="3" style="width:40px;text-align:center;ime-mode:disabled" dataformat="int" caption="Special Provisions" class="input" value="" id="imdg_spcl_provi_no" /></td>
					</tr>
	
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>				
		
		<!-- layout_wrap(S) -->
	      <div class="wrap_result">
		    <div class="layout_vertical_2"  style="width:20%" >
				<div class="opus_design_grid" style="padding-right:10px;" >			
					<script type="text/javascript">ComSheetObject('sheet1');</script>
				</div>
		    </div>
		    <div class="layout_vertical_2" style="width:80%">
		    <table ><tr><td><h3 class="title_design">Description of Special Provision</h3></td>
		    	<td style="text-align:right"><input type="text" name="imdg_spcl_provi_no2" id="imdg_spcl_provi_no2" style="width:70px;margin-right:0px" class="input2 mar_left_8" value="" readonly/></td>
		    </tr>
		    <tr><td colspan="2">	
				<textarea name="imdg_spcl_provi_desc1" id="imdg_spcl_provi_desc1" rows="25" style="width:100%; margin-top:2px"></textarea>
			</td></tr></table>
		    </div>
		    <!-- opus_design_btn (S) -->
			<%-- <div class="opus_design_btn">
				<button class="btn_normal" name="btn_OK" id="btn_OK" type="button">OK</button><!--
				--><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button>
			</div>--%>
			
			<div id="popLayer" style="display:none">
				<!-- opus_design_btn (S) -->
				<div class="opus_design_btn">
					<button class="btn_normal" name="btn_OK" id="btn_OK" type="button">OK</button><!--
					--><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button>
				</div>
				<!-- opus_design_btn (E) -->
			</div>				
		</div>
	<!-- opus_design_btn (E) -->
	
<% if (pop_yn=="Y") { %></div><%}%>

</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>