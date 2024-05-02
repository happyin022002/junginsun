<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0587.jsp
*@FileTitle : Booking Closing Bayplan
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.05.22 최영희
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event.EsmBkg0587Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.common.*" %>
<%@ page import="java.util.List"%>
<%
	EsmBkg0587Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	String strVslCd			= "";
	String strPolCd			= "";
	boolean bFlag=false;
	Logger log = Logger.getLogger("com.hanjin.apps.GeneralBookingConduct.GeneralBookingListSearch");
	
	List<BkgComboVO> bkg_clz_sts_list = null;

	try {

	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
        strOfc_cd = account.getOfc_cd();

		event = (EsmBkg0587Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		bkg_clz_sts_list = (List<BkgComboVO>) eventResponse.getCustomData("bkg_clz_sts_list");
		strVslCd = event.getVslCd();
		strPolCd = event.getPolCd();
		if (strVslCd.length()>1 && strPolCd.length()>1) bFlag=true;
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Booking Closing Bayplan</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(flag){
		if('<%=strVslCd.length()%>' > 1) {				
			//Show closing button
			document.all.popLayer.style.display = "";
			
			try {
				var appName = navigator.appName;
			 	if (appName.indexOf("Netscape") == -1) {
			  		document.all.pophistory.innerHTML = "";
			 	} else {
			  		document.getElementById("pophistory").innerHTML = "";
			 	}
			 	
			 	document.getElementById("mainTbl").className   = "popup";
			 	document.getElementById("mainTbl").cellPadding = "10";
			 	document.getElementById("topLine").className   = "top";
			}catch(err) {
			 	ComShowMessage(err);
			}
		}
		
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if	
		
		loadPage(flag);
	}
</script>
</head>

<body  onLoad="setupPage(<%=bFlag%>);">
<form name="form" onkeyup="ComKeyEnter('lengthnextfocus');">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="userOfc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="user_id" value="<%=strUsr_id%>">
<!-- 개발자 작업	-->
<table id="mainTbl" width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr><td id="topLine"></td></tr>  
	<tr><td valign="top">

		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history" id="pophistory"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><% if(bFlag){ %> Booking Close for Bay Plan<%}else{ %><span id="title"></span><%} %></td></tr>
			</table>
		<!--Page Title, Historical (E)-->
	<!--Page Title, Historical (S)-->
	<!--	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history" id="pophistory"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>-->
	<!--Page Title, Historical (E)-->
	
	<!--Button (S) -->
		
    <!--Button (E) -->
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="35">VVD</td>
					<td width="130"><input type="text" style="width:90;" class="input1" value="<%=strVslCd%>" name="vsl_cd" dataformat="engup" maxlength="9"></td>
					<td width="35">POL</td>
					<td width="130"><input type="text" style="width:60;" class="input1" value="<%=strPolCd%>" name="pol_cd" dataformat="engup" maxlength="5">&nbsp;<input type="text" style="width:30;" class="input" name="yd_cd" dataformat="engup"  maxlength="2"></td>
					<td width="100">Booking Office</td>
					<td width="120"><select style="width:80;" name="ofc_cd" id="ofc_cd">
					<option value="All" selected>All</option>
					</select></td>
					<td width="80">Sub&nbsp;<input type="checkbox" name="sub_chk" value="Y" class="trans"></td>
					<td width="50">Status</td>
					<td width="">
						<%=HTMLUtil.getComboString("bkg_clz_sts_cd", "width:100;", "", "","All","All", bkg_clz_sts_list)%>
					 </td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
				
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>	
				
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Booking_Close">Booking Close</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Re_Open"> Re-open</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_RowAdd">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
				
				
				</td></tr>
			</table>
				
		
			<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Excel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	
	</td></tr>
		</table>

<div id="popLayer" style="display:none">
<table class="height_5"><tr><td></td></tr></table>	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">	
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       			<tr>
       				<td class="btn3_bg">
		    			<table border="0" cellpadding="0" cellspacing="0">
		    				<tr>
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