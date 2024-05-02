<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_SCG_5922.jsp
*@FileTitle  : Application Request & Approval Status - SS
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/14
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
<%@ page import="com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.event.VopScg5922Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.StringTokenizer,java.util.Vector" %>
<%
	VopScg5922Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String vslCd     = "";
	String skdVoyNo  = "";
	String skdDirCd  = "";
	String fromEtaDt  = "";
	String toEtaDt  = "";
	
	String rdoImg    = ""; //image radio button
	
	String plmtPortCd	= "";
	String portLmtSeq 	= "";
	String authFlg 		= "";
	String plmtClptIndSeq = "";
	String plmtVvd  = "";
	Vector<String> vec = new Vector<String>();
	
	try {
		
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	
		vslCd     	= request.getParameter("vslCd");
		skdVoyNo  	= request.getParameter("skdVoyNo");
		skdDirCd  	= request.getParameter("skdDirCd");
		fromEtaDt  	= request.getParameter("from_eta_dt");
		toEtaDt  	= request.getParameter("to_eta_dt");
		plmtClptIndSeq = request.getParameter("plmt_clpt_ind_seq");
		rdoImg    	= request.getParameter("rdo_img");
		
		plmtPortCd	= request.getParameter("plmt_port_cd");
		portLmtSeq	= request.getParameter("port_lmt_seq");
		authFlg		= request.getParameter("auth_flg");
		plmtVvd		= request.getParameter("plmtVvd");
		
		event = (VopScg5922Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// add logic data extracting from server when loading initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
 	    StringTokenizer token = new StringTokenizer (rdoImg, ",");
 	   
	    int i = 0;
	    while ( token.hasMoreTokens()){
	    	vec.add(token.nextToken());
			i++;
	    }
	    
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<title>Port Limit Booking Details</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="vsl_cd" 			value="<%=StringUtil.xssFilter(vslCd) %>"><%//전체조회 %>
<input type="hidden" name="skd_voy_no" 		value="<%=StringUtil.xssFilter(skdVoyNo) %>"><%//전체조회 %>
<input type="hidden" name="skd_dir_cd" 		value="<%=StringUtil.xssFilter(skdDirCd) %>"><%//전체조회 %>

<input type="hidden" name="bkg_nos" 		value="">
<input type="hidden" name="from_eta_dt" 	value="<%=StringUtil.xssFilter(fromEtaDt) %>">
<input type="hidden" name="to_eta_dt" 		value="<%=StringUtil.xssFilter(toEtaDt) %>">
<input type="hidden" name="plmt_clpt_ind_seq" 		value="<%=StringUtil.xssFilter(plmtClptIndSeq) %>">

<input type="hidden" name="plmt_port_cd" 	value="<%=StringUtil.xssFilter(plmtPortCd) %>">
<input type="hidden" name="port_lmt_seq" 	value="<%=StringUtil.xssFilter(portLmtSeq) %>">
<input type="hidden" name="auth_flg" 		value="<%=StringUtil.xssFilter(authFlg) %>">
<input type="hidden" name="plmt_vvd" 		value="<%=StringUtil.xssFilter(plmtVvd) %>">

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Port Limit Booking Details</span></h2>
		
		<div id="btnView1" class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>	
	</div>
</div>
<div class="layer_popup_contents"  style="overflow:hidden;">
	<div class="wrap_search">
		<div class="opus_design_inquiry">
			<table>
				<tbody>
				<colgroup>
					<col width="90" />
					<col width="100" />
					<col width="90" />
					<col width="*" />					
				</colgroup>
					<tr>
						<td>
						<%
							int j = 0;
							for(int i=0; i < vec.size(); i++){
								String vecStr = (String)vec.get(i);
								String img = "";
								if("G".equals(vecStr)){
									img = "img/btng_icon_green.gif";
								}else if("Y".equals(vecStr)){
									img = "img/btng_icon_y.gif";
								}else if("R".equals(vecStr)){
									img = "img/btng_icon_r.gif";
								}
								
								if(!"B".equals(vecStr)){
									if(i==0){			j++;
						%>
							<input type="radio" name="bkg_srch" id="bkg_srch" value="1<%=vecStr%>" class="trans" <%if(j==1){%>checked<%}%>/>&nbsp;<image src="<%=img%>"/>&nbsp;<b>Arrival</b>&nbsp;&nbsp;&nbsp;
						<%	
									}else if(i == 1){	j++;
						%>
							<input type="radio" name="bkg_srch" id="bkg_srch" value="2<%=vecStr%>" class="trans" <%if(j==1){%>checked<%}%>/>&nbsp;<image src="<%=img%>"/>&nbsp;<b>Discharge</b>&nbsp;&nbsp;&nbsp;
						<%	
									}else if(i == 2){	j++;
						%>
							<input type="radio" name="bkg_srch" id="bkg_srch" value="3<%=vecStr%>"class="trans" <%if(j==1){%>checked<%}%>/>&nbsp;<image src="<%=img%>"/>&nbsp;<b>Load</b>&nbsp;&nbsp;&nbsp;
						<%
									}else if(i == 3){	j++;
						%>
							<input type="radio" name="bkg_srch" id="bkg_srch" value="4<%=vecStr%>" class="trans" <%if(j==1){%>checked<%}%>/>&nbsp;<image src="<%=img%>"/>&nbsp;<b>Departure </b>&nbsp;&nbsp;&nbsp;
						<%
									}
								}
							}
						%>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="wrap_result">
		<div class="opus_design_grid" >
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
			</div>
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>
</form>