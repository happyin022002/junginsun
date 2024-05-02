<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0006.jsp
*@FileTitle : DG Restriction by Port (Inquiry)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.05.26 장강철 jkc
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
<%@ page import="com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.event.VopScg0006Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0006Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DangerousCargoRestriction.PortRestriction");
    String pPort_cd = "";
 
    String pImdg_clss_cd  = "";
    String pImdg_clss_cd_desc  = "";
    String pImdg_un_no  = "";
    String pImdg_un_no_seq  = "";    
    String pPrp_shp_nm = "";    
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (VopScg0006Event)request.getAttribute("Event");
		
		pPort_cd           = event.getPPortCd(); 
		pImdg_clss_cd      = event.getPImdgClssCd(); 
		pImdg_clss_cd_desc = event.getPImdgClssCdDesc(); 
		pImdg_un_no        = event.getPImdgUnNo(); 
		pImdg_un_no_seq    = event.getPImdgUnNoSeq(); 		
		pPrp_shp_nm        = event.getPPrpShpNm();				
		
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
<title>DG Restriction by Port (Inquiry)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
 
		if(document.form.pPort_cd.value != ""){
		     ComScgMainToMakePopup();
		     document.all.closeBtnLayer.style.display = "";
		}
				
		loadPage();
	}
</script>
</head>

<!-- 개발자 작업	-->
<% if("".equals(pPort_cd)) { %>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="pPort_cd" value="<%=pPort_cd %>">

<input type="hidden" name="imdg_port_rstr_seq">
<input type="hidden" name="load_imdg_cmptn_auth_cd">
<input type="hidden" name="dis_imdg_cmptn_auth_cd">
<input type="hidden" name="ts_imdg_cmptn_auth_cd">
<input type="hidden" name="pass_imdg_cmptn_auth_cd">

<input type="hidden" name="pImdg_clss_cd"      value="<%=pImdg_clss_cd %>">
<input type="hidden" name="pImdg_clss_cd_desc" value="<%=pImdg_clss_cd_desc %>">
<input type="hidden" name="pImdg_un_no"        value="<%=pImdg_un_no %>">
<input type="hidden" name="pImdg_un_no_seq"    value="<%=pImdg_un_no_seq %>">
<input type="hidden" name="pPrp_shp_nm"        value="<%=pPrp_shp_nm %>">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<% } else { %>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="pPort_cd" value="<%=pPort_cd %>">

<input type="hidden" name="imdg_port_rstr_seq">
<input type="hidden" name="load_imdg_cmptn_auth_cd">
<input type="hidden" name="dis_imdg_cmptn_auth_cd">
<input type="hidden" name="ts_imdg_cmptn_auth_cd">
<input type="hidden" name="pass_imdg_cmptn_auth_cd">

<input type="hidden" name="pImdg_clss_cd"      value="<%=pImdg_clss_cd %>">
<input type="hidden" name="pImdg_clss_cd_desc" value="<%=pImdg_clss_cd_desc %>">
<input type="hidden" name="pImdg_un_no"        value="<%=pImdg_un_no %>">
<input type="hidden" name="pImdg_un_no_seq"    value="<%=pImdg_un_no_seq %>">
<input type="hidden" name="pPrp_shp_nm"        value="<%=pPrp_shp_nm %>">

<table width="100%" class="popup" border="0" cellpadding="10">
<tr><td class="top"></td></tr>
<% } %>
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
											<td class="btn1" name="btn_retrieve" id="btn_Retrieve" >Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_new">New</td>
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
						<!--  biz_1  (S) -->
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="80">Port Code</td>
								<td width="320">
									<input type="text" style="width:60;ime-mode:disabled" class="input1" name='port_cd' required dataformat='uppernum' maxLength=5   fullfill   caption='Port Code'   value="">
									<img class="Cursor" src="img/btns_search.gif" width="19" height="20" name='srch_port_cd' border="0" align="absmiddle">&nbsp;<input type="text" style="width:200;"  readonly class="input2" name='port_cd_nm' value="">
								</td>
								<td width="200">
									<table  class="search_sm2" border="0" style="width:230;" >
										<tr class="h23">
											<td width="60">&nbsp;Option</td>
											<td class="stm">
												<input type="radio" value='class' name='optClass' class="trans" checked   >Class&nbsp;&nbsp;
												<input type="radio"  name='optClass'  value='unno' class="trans">UN No.
											</td>
										</tr>
									</table>
								</td>
								<td width="100" align="center">Update By</td>
								<td width="">
									<input type="text" style="width:100;" class="input2" name='upd_usr_id' value="">
									<input type="text" style="width:110;" class="input2" name='upd_dt' value="">
								</td>
							</tr>
						</table>
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="80">Class</td>
								<td style="padding-left:2;"><script language="javascript">ComComboObject('imdg_clss_cd', 2, 60, 1, 1);</script>&nbsp;<input type="text" style="width:830;" class="input2" readonly  name='imdg_clss_cd_desc' value="">
							    </td>
							</tr>
						</table>
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="80">UN No./Seq.</td>
								<td colspan="4">
									<input type="text" style="width:60;" name='imdg_un_no'  class="input1" maxlength=4 dataformat='engup' caption='UN No.' fullfill style="ime-mode:disabled" onKeyPress="ComKeyOnlyNumber(this)"  value="">
									<input type="text" style="width:30;" class="input1" name='imdg_un_no_seq' value=""   onKeyPress="ComKeyOnlyNumber(this)" maxlength="2">
									<img class="cursor" src="img/btns_search.gif" name='srch_imdg_un_no' width="19" height="20" border="0" align="absmiddle">
									<input type="text" style="width:773;" class="input2" name='prp_shp_nm' value="" readonly>
								</td>
							</tr>
						</table>
						<!--  biz_1   (E) -->
					</td>
				</tr>
			</table>
			<table class="height_8"><tr><td></td></tr></table>
     	<table class="search">
       	<tr><td class="bg">
			<!--  biz_2  (S) -->
			   <table class="search" border="0" style="width:979;" id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!--  biz_2  (E) -->
				<table class="search" border="0" style="width:979;" id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet3');</script>
						</td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet4');</script>
						</td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet5');</script>
						</td>
					</tr>
				</table>
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet6');</script>
						</td>
					</tr>
				</table> 	
				<table class="grid2" border="0" style="width:979;"> 
				<tr class="tr2_head">
					<td>Remark(s)</td>
		        </tr>
				<tr class="h23">
					<td><textarea cols="190" rows="6" name='rstr_rmk' maxlength='4000'></textarea></td>
				</tr>
				</table>
				<!--  biz_2  (E) -->
		
	
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	<table class="height_5"><tr><td></td></tr></table>
	
	</td></tr>
		</table>
		
<div id="closeBtnLayer" style="display:none">
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
											<td class="btn1" name="btn_Close" id="btn_Close">Close</td>
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