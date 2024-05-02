<%
/*========================================================= 
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0024.jsp
*@FileTitle : Vessel Charter / Lay up Expense
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :  
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.event.EsmCoa0024Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmCoa0024Event event = null;
	Exception serverException = null;    // 서버에서 발생한 에러
	String strErrMsg = "";               // 에러메세지
	int rowCount = 0;                    // DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.depositinvoice.depositinvoice");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmCoa0024Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Container Deposit Invoice</title>
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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업 -->
<input type="hidden" name="f_yrtype" value="yrwk">
<input type="hidden" name="rlane_cd" value="<%=JSPUtil.getParameter(request,"rlane_cd")%>">
<input type="hidden" name="cost_yrmon" value="<%=JSPUtil.getParameter(request,"cost_yrmon")%>">

<table width="100%" class="popup" cellpadding="10" border="0">
  	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">
			<!-- : ( Title ) (S) -->
		      <table width="100%" border="0">
		        <tr><td class="title"><div id="div_title"></div></td></tr>
		      </table>
		      <!-- : ( Title ) (E) -->

			
			<!-- Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding:5px 0px 10px 0px;">
				<tr>
					<td class="btn1_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left">
											<td class="btn1" name="btn_retrieve">Retrieve</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>
								<!-- 
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left">
											<td class="btn1" name="btn_weekcopy">Week Copy</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>
								 -->
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left">
											<td class="btn1" name="btn_downexcel">Down Excel</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>					
				</tr>
			</table>
			<!-- Button (E) -->
			
			<!-- biz page (S) -->
			<table class="search" border="0" height="40" style="width:100%;">
				<tr class="h23">
					<td class="bg" width="100%" valign="top">		              
						<table class="height_5"><tr><td></td></tr></table>
						<table border="0" width="100%">
							<tr class="h23" align="center">
								<td>
									<table class="search" border="0" style="width:100%;">
										<tr class="h23">
											<td width="8%">YYYY-WW</td>
											<td width="8%" align="left"><input type="text" class="input1" style="width:60" name="f_yearweek" maxlength="6" onkeyPress="ComKeyOnlyNumber(window);" onfocus="ComClearSeparator(this,'', '-');this.select();" onblur="javascript:fnYearWeekSet(this);"></td>
											<td width="84%" class="sm"><div id="div_period"></div></td>
										</tr>
									</table>
								</td>
							</tr>						
						</table>
					</td>
				</tr>
			</table>


			<table class="height_8"><tr><td></td></tr></table>


			<table class="search">
				<tr>
					<td class="bg" valign="top">
						<!-- biz_2 (S) -->
						<!-- Grid (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td width="100%"><script language="javascript">ComSheetObject("sheet1");</script></td>
							</tr>
						</table>
						
						<!-- Grid (E) -->
						<!-- biz_2 (E) -->						
						
						<table width="100%" class="button">
							<tr>
								<td class="btn2_bg">
									<table  border="0" cellpadding="0" cellspacing="0">
									<tr>
										<!-- 
										<td><table border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn2_left"></td>
												<td class="btn2" name="btn_rowadd">Row Add</td>
												<td class="btn2_right"></td>
											</tr>
										</table></td>
										<td><table border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn2_left"></td>
												<td class="btn2" name="btn_save">Save</td>
												<td class="btn2_right"></td>
											</tr>
										</table></td>
										 -->
									</tr></table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!-- biz page (E) -->




		</td>
	</tr>
</table>

<table class="height_5"><tr><td></td></tr></table>
 <!-- : ( Button : pop ) (S) -->
 <table width="100%" class="sbutton">
   <tr>
     <td height="71" class="popup"><table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
         <tr>
           <td class="btn3_bg"><table border="0" cellpadding="0" cellspacing="0">
               <tr>
                 <td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                     <tr>
                       <td class="btn1_left"></td>
                       <td class="btn1" name="btn_close">Close</td>
                       <td class="btn1_right"></td>
                     </tr>
                   </table></td>
               </tr>
             </table></td>
         </tr>
       </table></td>
   </tr>
 </table>

<!-- 개발자 작업 끝 -->
</form>
</body>
</html>