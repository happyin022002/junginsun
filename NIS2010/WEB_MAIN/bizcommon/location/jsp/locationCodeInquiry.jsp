<%--=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : locationCodeInquiry.jsp
*@FileTitle : Location Detail 정보
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-20
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2009-08-20 정인선
* 1.0 최초 생성
=========================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.bizcommon.location.event.ComEns051Event"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%
	ComEns051Event  event = null;                        //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;                    //서버에서 발생한 에러
	String strErrMsg = "";                                 //에러메세지
	String usr_ofc_cd = "";
	GeneralEventResponse eventresponse = new GeneralEventResponse();
	Map<String, String> etcData = new HashMap<String, String>();
	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
   		event = (ComEns051Event)request.getAttribute("Event");
   		eventresponse = (GeneralEventResponse)request.getAttribute("EventResponse");
   		etcData = eventresponse.getETCData();
  		if (serverException != null) {
      		strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	    }
	}catch(Exception e) {
		out.println(e.toString());
	} 
%>
<html>
<head>
<title>Location</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<link href="css/alps_contents.css" rel="stylesheet" type="text/css">
<body class="popup_bg"> 
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; Location Code Inquiry-Detail</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
				<!--  biz_1  (S) ||||hub_loc_cd|un_loc_ind_cd|un_loc_cd|loc_chr_cd|scc_cd|lcc_cd|sls_ofc_cd|eq_ctrl_ofc_cd| -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="150">Location Code</td>  
					<td width="160"><input type="text" style="width:150;" class="input" value="<%=etcData.get("loc_cd")%>"></td>  
					<td width="150">UN Code</td>  
					<td width="150"><input type="text" style="width:100%;" class="input" value="<%=etcData.get("un_loc_cd")%>"></td> 
				</tr>
				<tr class="h23">
					<td width="">Location Name</td>  
					<td width=""><input type="text" style="width:150;" class="input" value="<%=etcData.get("loc_nm")%>"></td>
					<td width="">Local Name</td>  
					<td width=""><input type="text" style="width:100%;" class="input" value="<%=etcData.get("loc_locl_lang_nm")%>"></td> 
				</tr>
				
				<tr class="h23"><td height="10" colspan="4"></td></tr>
				
				<tr class="h23">
					<td width="">Type</td>  
					<td width=""><input type="text" style="width:150;" class="input" value="<%=etcData.get("port_inlnd_cd")%>"></td>  
					<td width="">Calling Port</td>  
					<td width=""><input type="text" style="width:100%;" class="input" value="<%=etcData.get("call_port_flg")%>"></td> 
				</tr>
				<tr class="h23">
					<td width="">Continent</td>  
					<td width=""><input type="text" style="width:150;" class="input" value="<%=etcData.get("conti_nm")%>"></td>  
					<td width="">Sub-Continent</td>  
					<td width=""><input type="text" style="width:100%;" class="input" value="<%=etcData.get("sconti_cd")%>"></td> 
					</tr>
					<tr class="h23">
					<td width="">Country</td>  
					<td width=""><input type="text" style="width:150;" class="input" value="<%=etcData.get("country")%>"></td>  
					<td width="">Region</td>  
					<td width=""><input type="text" style="width:100%;" class="input" value="<%=etcData.get("rgn_cd")%>"></td> 
					</tr>
					<tr class="h23">
					<td width="">State</td>  
					<td width="" ><input type="text" style="width:150;" class="input" value="<%=etcData.get("loc_state")%>"></td>
					<td width="" colspan="2"><input type="text" style="width:100%;" class="input" value="<%=etcData.get("ste_nm")%>"></td>   
				</tr>
				
				<tr class="h23"><td height="10" colspan="4"></td></tr>
				
				<tr class="h23">
					<td width="">EQ SCC</td>  
					<td width=""><input type="text" style="width:150;" class="input" value="<%=etcData.get("scc_cd")%>"></td>
					<td width="">Office-Sales&nbsp;</td>  
					<td width=""><input type="text" style="width:100%;" class="input" value="<%=etcData.get("sls_ofc_cd")%>"></td> 
				</tr>
				<tr class="h23">
					<td width="">EQ ECC</td>  
					<td width=""><input type="text" style="width:150;" class="input" value="<%=etcData.get("ecc_cd")%>"></td>  
					<td width="">Office-Finance&nbsp;</td>  
					<td width=""><input type="text" style="width:100%;" class="input" value="<%=etcData.get("finc_ctrl_ofc_cd")%>"></td> 
					</tr>
					<tr class="h23">
					<td width="">EQ LCC</td>  
					<td width=""><input type="text" style="width:150;" class="input" value="<%=etcData.get("lcc_cd")%>"></td>  
					<td width="">Office-Logistics&nbsp;</td>  
					<td width=""><input type="text" style="width:100%;" class="input" value="<%=etcData.get("eq_ctrl_ofc_cd")%>"></td> 
				</tr>
				
				<tr class="h23"><td height="10" colspan="4"></td></tr>
				
				<tr class="h23">
					<td width="">Rep.Zone</td>  
					<td width=""><input type="text" style="width:150;" class="input" value="<%=etcData.get("rep_zn_cd")%>"></td>
					<td width="">Rep.Empty P/U Yard</td>  
					<td width=""><input type="text" style="width:100%;" class="input" value="<%=etcData.get("mty_pkup_yd_cd")%>"></td>   
					</tr>
				<tr class="h23">
					<td width="">Hub City(USA I.T) </td>  
					<td width="" colspan="3"><input type="text" style="width:150;" class="input" value="<%=etcData.get("hub_loc_cd")%>"></td>  
				</tr>
				<tr class="h23">
					<td width="">Grid</td>  
					<td width=""><input type="text" style="width:150;" class="input" value="<%=etcData.get("loc_grd_no")%>"></td>  
					<td width="">ZIP</td>  
					<td width=""><input type="text" style="width:100%;" class="input" value="<%=etcData.get("zip_cd")%>"></td> 
				</tr>
				<tr class="h23">
					<td width="">Commercial Zone</td>  
					<td width="" colspan="3"><input type="text" style="width:150;" class="input" value="<%=etcData.get("cml_zn_flg")%>"></td>  
					</tr>
				<tr class="h23">
					<td width="">US AMS</td>  
					<td width=""><input type="text" style="width:150;" class="input" value="<%=etcData.get("loc_ams_port_cd")%>"></td>  
					<td width="">Customs Code</td>  
					<td width=""><input type="text" style="width:100%;" class="input" value="<%=etcData.get("cstms_cd")%>"></td> 
				</tr>
				<tr class="h23">
					<td width="">U.T.C Gap (Min)</td>  
					<td width="" colspan="3"><input type="text" style="width:150;" class="input" value="<%=etcData.get("gmt_hrs")%>"></td>  
				</tr>
				<tr class="h23">
					<td width="">Latitude</td>  
					<td width=""><input type="text" style="width:150;" class="input" value="<%=etcData.get("port_lat")%>"></td>  
					<td width="">Longitude</td>  
					<td width=""><input type="text" style="width:100%;" class="input" value="<%=etcData.get("port_lon")%>"></td> 
				</tr>
				</table> 
				<!--  biz_1   (E) -->
				
				
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) --><table class="height_5"><tr><td></td></tr></table>

</td></tr>
</table> 


	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="Colse">Close</td>
					<td class="btn1_right">
				</tr></table></td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
			
			
</body>
</html>
