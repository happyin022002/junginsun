<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : VOP_AOM_0108.jsp
*@FileTitle : Image File Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.27
*@LastModifier : 신자영
*@LastVersion : 1.0
* 2013.02.27 신자영
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
<%@ page import="com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0108Event"%>
 <%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>

<%
	VopScg0108Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String pckCd 			= "";
	String pckCdSeq  		= "";
	String dispNo  		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.vskcommon.vskcodefinder");

	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (VopScg0108Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		pckCd = StringUtil.xssFilter(request.getParameter("imdg_pck_instr_cd"));
		pckCd = pckCd==null?"":pckCd;
		
		pckCdSeq = StringUtil.xssFilter(request.getParameter("imdg_pck_instr_seq"));
		pckCdSeq = pckCdSeq==null?"":pckCdSeq;
		
		
		dispNo = StringUtil.xssFilter(request.getParameter("regu_dp_no"));
		dispNo = dispNo==null?"":dispNo;
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Image File Registration</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<SCRIPT LANGUAGE="javascript" SRC="apps/alps/vop/aom/CoScg.js" TYPE="text/javascript"></SCRIPT>
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 개발자 작업	-->
<table width="600" class="popup" cellpadding="10" border="0"> 
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top">
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr>
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Image File Registration</td>
				</tr>
			</table>
			<!-- : ( Title ) (E) -->
			<!-- : ( Search Options ) (S) -->
			<table class="search"> 
       			<tr>
       				<td class="bg">
						<!--  biz_1  (S) -->
						<table class="search" border="0" style="width:420;">
							<tr class="h23">
								<td width="120">Packing Inst. Code</td>
								<td width="">
									<input type="text" style="width:50;text-align:center;ime-mode:disabled;" class="input" maxlength="7" name="imdg_pck_instr_cd" value="<%=pckCd %>" tabindex="1">
								</td>
								<td width="30">Seq.</td>
								<td width="">
									<input type="text" style="width:40;text-align:center;ime-mode:disabled;" class="input" maxlength="2" name="imdg_pck_instr_seq" value="<%=pckCdSeq %>" tabindex="1">
								</td>
								<td width="50">DISP</td>
								<td width="">
									<input type="text" style="width:40;text-align:center;ime-mode:disabled;" class="input" maxlength="2" name="regu_dp_no" value="<%=dispNo %>" tabindex="1">
								</td>
							</tr>
						</table>
						<!--  biz_1   (E) -->
					</td>
				</tr>
			</table>
			<!-- : ( Search Options ) (E) -->
			<table class="height_8"><tr><td></td></tr></table>
			
			<!-- : ( Data ) (S) -->
			<table class="search"> 
       			<tr>
       				<td class="bg">
						<!-- : ( Grid ) (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- : ( Grid ) (E) -->		
						<!--  Button_Sub (S) -->
						<table width="100%" class="button"> 
					     	<tr>
					     		<td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											
											
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_RowAdd">Row Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<input type="button" style="border-width:0px;background:spacer.gif" name="downbtn" onclick="doAction('down')">
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_FileAdd">File Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_RowDelete">Row Delete</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
  						<!-- Button_Sub (E) -->				
					</td>
				</tr>
			</table>
			<!-- : ( Data ) (E) -->
		</td>
	</tr>
</table> 

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
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Save">Save</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_close">Close</td>
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
<!-- : ( Button : pop ) (E) -->
<script language="javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>	
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>