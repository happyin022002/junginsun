<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESD_TRS_0240.jsp
*@FileTitle : HJL HANDLING  FEE
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.bizcommon.util.BizComUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0240Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTrs0240Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();


		event = (EsdTrs0240Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>HJS-HJL Handling Fee Management</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
<%=BizComUtil.getIBCodeCombo("default_curr", "01", "CURR", 1, "")%>

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="usr_id" value="<%=strUsr_id%>" >
<input type="hidden" name="usr_ofc_cd" value="<%=strOfc_cd%>" >
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr>
		<td valign="top">
			<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!--Page Title, Historical (E)-->
			
		    <!--Button (S) -->
		     <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
		        <tr>
		        	<td class="btn1_bg">
		            <table border="0" cellpadding="0" cellspacing="0">
			            <tr>
			                <td>
			                	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				                    <tr>
				                    	<td class="btn1_left"></td>
					                    <td class="btn1" name="btn_retrieve">Retrieve</td>
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
	    	
			<!--biz page (S)-->
			<table class="search"> 
		    	<tr>
		    		<td class="bg">
						<!-- biz_1  (S) -->
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="60">Office</td>
								<td width="180">
									<input name="ofc_cd" type="text" style="width:100;" onChange="javascript:fun_officeText();">
								</td>
								<td width="100">Effective as of</td>
								<td width="">
									<input  name="fm_dt"  type="text" style="width:80;" onFocus="javascript:delHypen(this);" onBlur="javascript:isValidDateForm(this);getHypen(this); setgetUpper(this);" maxlength="10">
								</td>
								<td width="">
									<input  name="flg_his"  type="checkbox">Incl. Historical Data
								</td>
							</tr>
						</table>	
						<!-- biz_1  (E) -->		
					</td>
				</tr>
			</table>
						
			<table class="height_8"><tr><td></td></tr></table>
	
			<!-- TAB [ Dry ] (S) -->
			<div id="tabLayer" style="display:inline">
				<table class="search"> 
					<tr>
						<td class="bg" style="height:416" valign="top">
							<!-- Grid  (S) -->
							<table width="100%"  id="mainTable">
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet1');</script>
									</td>
								</tr>
							</table>
							<!-- Grid (E) -->
						</td>
					</tr>
				</table>
			</div>
			<!-- TAB [ Dry ] (E) -->
	
		
			<!--biz page (E)-->
			<!--Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
		       	<tr>
		       		<td class="btn1_bg">
					    <table border="0" cellpadding="0" cellspacing="0">
						    <tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_excel">Down Excel</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
				                <td>
				                	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				                    	<tr>
				                    		<td class="btn1_left"></td>
						                    <td class="btn1" name="btn_save">Save</td>
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
		</td>
	</tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>