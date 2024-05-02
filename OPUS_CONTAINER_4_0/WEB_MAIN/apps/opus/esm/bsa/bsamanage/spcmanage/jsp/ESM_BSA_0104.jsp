<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BSA_0104.js
*@FileTitle  : Inquire/Edit Daily-consumption & FO/DO By Lane
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/18
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.event.EsmBsa0104Event"%>
<%@ page import="com.clt.apps.opus.esm.bsa.common.vo.CommonBsaRsVO"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>

<%
	EsmBsa0104Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	
	String header   = "";
	String prevWeek = "";
	String year     = "";
	String hSearchYN = "";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.BSAManage.SPCManage");
	String xml = "";
    String opJob		= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBsa0104Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Extracting the data gotten from serve while initial loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		CommonBsaRsVO retVo = (CommonBsaRsVO)eventResponse.getCustomData("retVo");
    	prevWeek =eventResponse.getETCData("prevWk");
        opJob = retVo.getStrTemp3();
		
		header = retVo.getStrTemp();
		year = JSPUtil.getNull(request.getParameter("txtYear"))==""?"0":JSPUtil.getNull(request.getParameter("txtYear"));
		
        xml = HttpUtil.makeXML(request,response); 
        xml = xml.replaceAll("\"", "'");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script  type="text/javascript">
<%=ConstantMgr.getCompanyCodeToJS()%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		var formObj = document.form;
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage("<%=header%>");
		
		if (ComParseInt("<%=year%>") <= 0){	       
	        formObj.txtFmMonth.value = ComGetNowInfo("mm"); 
	        formObj.txtToMonth.value = ComGetNowInfo("mm"); 
	        formObj.txtFmMonth.value = ComLpad(formObj.txtFmMonth, 2, '0');
	        formObj.txtToMonth.value = ComLpad(formObj.txtToMonth, 2, '0');
	        
	        formObj.txtFmWeek.value = "<%=prevWeek%>";
	        formObj.txtToWeek.value = "<%=prevWeek%>";
	        
	        /* 2015.01.06 김용습  */ 
	        var today = new Date(); /* 오늘 날짜 */
	        
	        var int_of_a_week_before_today = today.setDate(today.getDate()-7); /* 오늘 날짜에서 7일(한주)를 뺌 -> 날짜가 숫자 값으로 나옴*/
	        
	        var date_of_a_week_before_today = new Date(int_of_a_week_before_today); /* 오늘 날짜에서 7일(한주)를 뺀 숫자값을 날짜로 변환 */
	        
	        var today2 = new Date(); /* 오늘 날짜 다시 생성*/
	        
	        var yyyy1 = today2.getFullYear(); /* 현재 년도 */
	        var yyyy2 = date_of_a_week_before_today.getFullYear(); /* 7일 전의 연도 */
	        
	        if(yyyy1 != yyyy2){ /* 현재 년도와 7일전의 연도가 다르면 현재 년도에서 1년을 뺀 연도가 찍히게 함 */
	        	formObj.txtYear.value = ComGetNowInfo("yy") - 1;  
	        }else{
	        	formObj.txtYear.value = ComGetNowInfo("yy");  
	        }   

	        setPeriod(formObj.txtToWeek);
       }
	}
</script>
</head>
<% if("Y".equals(JSPUtil.getNull(request.getParameter("hSearchYN")))){ %>
<% } else { %>
<div class="page_title_area clear">
<iframe height="0" width="0" name="frmHidden"></iframe>
</div>
<% } %>
<!-- <form method="post" name="form" onSubmit="return false;" onKeyDown="ComKeyEnter();"> -->
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="flag" id="flag" />
<input type="hidden" name="header" value="<%= header %>" id="header" />
<input type="hidden" name="param1" id="param1" />
<input type="hidden" name="param2" id="param2" />
<input type="hidden" name="param3" id="param3" />
<input type="hidden" name="param4" id="param4" />
<input type="hidden" name="param5" id="param5" />
<input type="hidden" name="param6" id="param6" />
<input type="hidden" name="param7" id="param7" />
<input type="hidden" name="param8" id="param8" />
<input type="hidden" name="hSearchYN" id="hSearchYN" />
<input type="hidden" name="sXml" value="<%= xml %>" id="sXml" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<% if("Y".equals(JSPUtil.getNull(request.getParameter("hSearchYN")))){ %>
	<h2 class="page_title">
		<span>Slot-info by VVD</span>
	</h2>
	<% } else { %>
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<% } %>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
		  --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->	
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="610"/>
					<col width="20"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<td><script  type="text/javascript">initPeriod();</script></td>
					<td></td>
					<td><label for="isExcludZero"><strong>Carriers with BSA only</strong></label>&nbsp;&nbsp;<input type="checkbox" name="isExcludZero" id="isExcludZero" value="1" class="trans"></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class= "opus_design_inquiry">
		<table>
			<tr class="line_bluedot"><td colspan="10"></td></tr>
		</table>
	</div>
	<div class= "opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="50"/>
					<col width="80"/>
					<col width="80"/>
					<col width="80"/>
					<col width="80"/>
					<col width="80"/>
					<col width="80"/>
					<col width="80"/>
					<col width="80"/>
					<col width="*"/>
			    </colgroup>	
				<tr>
					<th>Trade</th>
					<td><script  type="text/javascript">ComComboObject('cobTrade', 1, 70 , 0 )</script></td>
					<th>Lane</th>
					<td><div id="div_rLane"><script  type="text/javascript">ComComboObject('cobLane', 1, 80 , 0 )</script></div></td>
					<th>Dir.</th>
					<td><script  type="text/javascript">ComComboObject('cobDir', 1, 70 , 0 )</script></td>
					<th>IOC</th>
					<td><script  type="text/javascript">ComComboObject('cobIOC', 1, 80 , 0 )</script></td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td ><input type="text" size="4" name="txtVsl_cd" maxlength="4" onkeypress="ComKeyOnlyAlphabet('uppernum');" onkeyup="moveTab(this, txtSkd_voy_no);" style="ime-mode:disabled" id="txtVsl_cd" dataformat="engup"/><!-- 
					 --><input type="text" size="4" name="txtSkd_voy_no" maxlength="4" onkeypress="ComKeyOnlyNumber(window);" onkeyup="moveTab(this, txtDir_cd);" style="ime-mode:disabled" id="txtSkd_voy_no" /><!-- 
					 --><input type="text" size="1" name="txtDir_cd" maxlength="1" onkeypress="ComKeyOnlyAlphabet('upper');" style="ime-mode:disabled" id="txtDir_cd" dataformat="engup"/>
					</td>
				</tr>	
				
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" >
		<div class= "opus_design_inquiry">
		<div id="div_opjob"  style="float:left; font-weight: bold" name="div_opjob"></div>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_skdinquiry" id="btn_skdinquiry">SKD Inquiry</button>
			<div class="grid_option_right">
			<div id="div_zoom_in" style="display:none"><button name="bu_zoom_in" id="bu_zoom_in" alt="Zoom in(+)" type="button" class="btn_up mar_left_4"></button></div><!-- 
			--><div id="div_zoom_out" style="display:inline"><button type="button" name="bu_zoom_out" id="bu_zoom_out" alt="Zoom out(-)" class="btn_down mar_left_4"></button></div>
			</div>	
		</div>	
			<script type="text/javascript">ComSheetObject('sheet1');</script>
			<table>
				<tr>
					<th style="text-align:left">Vessel/Voy./BD Double Click : All detailed info. by VVD<br>Swap Notice Double Click : Swap info. by VVD</th>
				</tr>
			</table>
		</div>
	</div>
</div>
<!-- opus_design_grid(E) -->
</form>
<SCRIPT  type="text/javascript">
<!--

	/**
	 * getting the Infomation, which the user input, from event except ibsheet and showing it on the screen
	 */
	with(document.form){		
		var opJob = "<%=opJob%>";
		var arrOpJob = opJob.split("|$$|");
		
		var rdoStr = "";
        var rdoCode = arrOpJob[0].split("|");
        var rdoName = arrOpJob[1].split("|");

		if(rdoName != ""){
			for(i=0; i<rdoName.length-1; i++){
				rdoStr += "<input type='radio' value='"+rdoCode[i]+"' class='trans' name='rdoOpJob' id='rdio"+i+"' onClick=\"chgOptionJob('"+rdoName[i]+"');\"><label for='rdio"+i+"'>"+rdoName[i]+"</label>&nbsp;&nbsp;&nbsp;";
			}
		}else{
			rdoStr += "<input type='radio' value='007' class='trans' name='rdoOpJob' name='rdoOpJob1' onClick=\"chgOptionJob('BSA');\"><label for='rdoOpJob1'>BSA</label>&nbsp;&nbsp;&nbsp;&nbsp;";
			rdoStr += "<input type='radio' value='008' class='trans' name='rdoOpJob' name='rdoOpJob2' onClick=\"chgOptionJob('Weight Per TEU');\"><label for='rdoOpJob2'>Weight Per TEU</label>&nbsp;&nbsp;&nbsp;&nbsp;";
		}
		div_opjob.innerHTML = rdoStr;
		rdoOpJob[0].checked=true;
		//div_perf.style.display = "none";
		<% if(event != null) {%>
	    txtYear.value       = "<%= JSPUtil.getNull(request.getParameter("txtYear")) == null ? "" : JSPUtil.getNull(request.getParameter("txtYear")) %>";
	    txtFmWeek.value     = "<%= JSPUtil.getNull(request.getParameter("txtFmWeek"))==null?"":JSPUtil.getNull(request.getParameter("txtFmWeek")) %>";
	    txtToWeek.value     = "<%= JSPUtil.getNull(request.getParameter("txtToWeek"))==null?"":JSPUtil.getNull(request.getParameter("txtToWeek")) %>";
	    cobTrade.value      = "<%= JSPUtil.getNull(request.getParameter("selTrade"))==null?"":JSPUtil.getNull(request.getParameter("selTrade")) %>";
	    cobLane.value      = "<%= JSPUtil.getNull(request.getParameter("selRlane"))==null?"":JSPUtil.getNull(request.getParameter("selRlane")) %>";
	    cobDir.value        = "<%= JSPUtil.getNull(request.getParameter("selDir"))==null?"":JSPUtil.getNull(request.getParameter("selDir")) %>";
	    cobIOC.value        = "<%= JSPUtil.getNull(request.getParameter("selIOC"))==null?"":JSPUtil.getNull(request.getParameter("selIOC")) %>";
	    txtVsl_cd.value     = "<%= JSPUtil.getNull(request.getParameter("txtVsl_cd"))==null?"":JSPUtil.getNull(request.getParameter("txtVsl_cd")) %>";
	    txtSkd_voy_no.value = "<%= JSPUtil.getNull(request.getParameter("txtSkd_voy_no"))==null?"":JSPUtil.getNull(request.getParameter("txtSkd_voy_no")) %>";
	    txtDir_cd.value     = "<%= JSPUtil.getNull(request.getParameter("txtDir_cd"))==null?"":JSPUtil.getNull(request.getParameter("txtDir_cd")) %>";
	    hSearchYN.value     = "<%= JSPUtil.getNull(request.getParameter("hSearchYN")) == null ? "" : JSPUtil.getNull(request.getParameter("hSearchYN")) %>";
	    <%}%>
	}
-->
</SCRIPT>