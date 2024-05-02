<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0059.jsp
*@FileTitle : Special Provisions (Inquiry)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.18 장강철 jkc
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0059Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0059Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;				//서버에서 발생한 에러
	String strErrMsg 	= "";						//에러메세지
	int rowCount	 	= 0;						//DB ResultSet 리스트의 건수

	String successFlag 	= "";
	String codeList  	= "";
	String pageRows  	= "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	String pop_yn      	= "";
	String imdg_spcl_provi_no  	= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.SpecialCargoMasterDataMgt.SpecialCargoMasterDataMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg0059Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		pop_yn      		= StringUtil.xssFilter(request.getParameter("pop_mode"))==null?"N":"Y";
		imdg_spcl_provi_no  = StringUtil.xssFilter(request.getParameter("imdg_spcl_provi_no"))==null?"":StringUtil.xssFilter(request.getParameter("imdg_spcl_provi_no"));

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Special Provisions (Inquiry)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	//팝업호출 및 초기조회조건
	var preConds = {
		pop_yn       : "<%=pop_yn%>",
		imdg_spcl_provi_no   : "<%=imdg_spcl_provi_no%>"
	}

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
		if('Y' == preConds.pop_yn) {					
			//닫기버튼 보이기
			document.all.popLayer.style.display = "";
			
			//Set title of page
			var titleStr = "Special Provisions - Inquiry";
			try {
				var appName = navigator.appName;
			 	if (appName.indexOf("Netscape") == -1) {
			  		document.all.pophistory.innerHTML = "";
			  		document.all.title.innerHTML = '&nbsp; '+titleStr;
			  		document.title = titleStr;
			 	} else {
			  		document.getElementById("pophistory").innerHTML = "";
			  		document.getElementById("title").innerHTML = '&nbsp; '+titleStr;
			  		document.title = titleStr;
			 	}
			}catch(err) {
			 	ComShowMessage(err);
			}
		}

		loadPage();
	}
</script>
</head>

<!-- 개발자 작업	-->
<% if (pop_yn=="Y") { %>
<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="rowNo">
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr>
		<td class="top"></td>
	</tr>
<% }else{ %>
<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="rowNo">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
<% } %>
	<tr>
		<td valign="top">
			<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history" id="pophistory"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!--Page Title, Historical (E)-->
	
			<!--biz page-1 (S)-->
			<table class="search"> 
		       	<tr>
		       		<td class="bg">
						<!--  biz_1  (S) -->
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="120">Special Provisions</td>
								<td width=""><input type="text" name="imdg_spcl_provi_no" maxlength=3  style="width:40;text-align:center;ime-mode:disabled" caption='Special Provisions' class="input" value="">
							</td>
						</table>
						<!--  biz_1   (E) -->
					</td>
				</tr>
			</table>
			<!--biz page-1 (E)-->
			<!-- 2 (S) -->		
			<table class="height_8"><tr><td></td></tr></table>	
			<table class="search" id="mainTable"> 
	       		<tr>
	       			<td class="bg" style="height:465;" valign="top">			
						<table width="979"> 
							<tr>
								<td width="190">
									<!-- Grid - 1 (S) -->
									<table width="100%"  id="mainTable"> 
										<tr>
											<td width="100%">
												<script language="javascript">ComSheetObject('sheet1');</script>
											</td>
										</tr>
									</table>
									<!-- Grid - 1 (E) -->		
								</td>
								<td width="20"></td>
								<td width="">
									<!--  biz_1  (S) -->
									<table class="search" border="0" style="width:100%;"> 
										<tr class="h23">
											<td width="230">&nbsp;&nbsp;Description of Special Provision</td>
											<td width="630"><input type="text" name="imdg_spcl_provi_no2" style="width:70;" readonly class="input2" value=""></td>
										</tr>
										<tr class="h23">
											<td width="" colspan="2">
												<textarea name="imdg_spcl_provi_desc1" style="width:760" rows="28"></textarea>
											</td>
										</tr>
									</table>
									<!--  biz_1   (E) -->
								</td>
							</tr>
						</table>		
						<!--  Button_Sub (S) -->
 
				    	<!-- Button_Sub (E) -->
					</td>
				</tr>
			</table>
			<!--Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;padding-bottom:0;"> 
	     		<tr>
	     			<td class="btn1_bg">
					   	<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn1_Excel">Down Excel</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!--Button (E) -->
			<!--biz page (E)-->
		</td>
	</tr>
</table>

<div id="popLayer" style="display:none">
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
	
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;"> 
       			<tr>
       				<td class="btn3_bg">
		    			<table border="0" cellpadding="0" cellspacing="0">
		    				<tr>
		    					<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_OK">OK</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>				
								<td class="btn1_line"></td>
								<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Close">Close</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>
							</tr>
						</table>
    					<!--Button (E) -->
	
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- : ( Button : pop ) (E) -->
</div>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_nis2010.jsp"%>