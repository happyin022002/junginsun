<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_3502.jsp
*@FileTitle : Tariff Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.12
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2010.10.12 서미진
* 1.0 Creation

=========================================================
* History
* 2014.06.05 최성환 [CHM-201430518] Tariff E-Service Display 기능 추가     
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.tariff.tariffcode.event.EsmPri3502Event"%>
<%@ page import="com.hanjin.syscommon.common.table.PriTariffVO"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri3502Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String inlandFlag = "";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String trfInlndFlg     = null;				//combo에 셋팅해줄 값
	
	String[] scopeCd = null;

	Logger log = Logger.getLogger("com.hanjin.apps.Tariff.TariffCode");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		
		event = (EsmPri3502Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		scopeCd = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("scopeList"), true);
	
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Tariff Code Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    var scopeCdValue = " |<%=scopeCd[0]%>";
    var scopeCdText = " |<%=scopeCd[1]%>";
    
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
<input type="hidden" name="strusr_id" value="<%=strUsr_id %>">
<input type="hidden" name="strofc_cd" value="<%=strOfc_cd %>">
<input type="hidden" name="successFlag" value ="Y">
<input type="hidden" name="trf_inlnd_flg" value="">
<input type="hidden" name="web_dp_flg" value="">

<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_delete">Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>		
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

			<!--  biz_1  (S)    -->
		
			<table class="search" border="0" width="100%"  > 
			<tr class="h23">
			<td width="100%"><table border="0" cellpadding="0" cellspacing="0"><tr class="h23">
					<td width="90">Tariff Code</td>
					<td width="350"><input type="text" name="trf_pfx_cd" style="width:50;" class="input1" value="SMLM -" >
					<input type="text" name="trf_no" maxlength="3" style="width:50;text-align:center;" class="input1" value=""  dataformat="engup" 
					onkeyup="upper(this); javascript:searchTariffCodeName(this);" /></td>
					<td width="90">Inland Rates</td>
					<td width="160"><script language="javascript">ComComboObject("inland_rates", 0, 60, 0, 1, 0, false); </script></td>
					<!-- ADD CHM-201430518 -->
					<td width="120">E-service Display</td>
					<td width="160"><script language="javascript">ComComboObject("web_dp", 0, 60, 0, 1, 0, false); </script></td>
					
				</table></td>
				</tr>
			<tr class="h23">
			<td width="100%"><table border="0" cellpadding="0" cellspacing="0"><tr class="h23">
					<td width="90">Tariff Name</td>
					<td width="500"><input type="text" name="trf_nm" style="width:100%" class="input2"  value=""  maxlength="100"  dataformat="engup" readOnly></td>
				</table></td>
				</tr>	
			<tr class="h23">
			<td width="100%"><table border="0" cellpadding="0" cellspacing="0"><tr class="h23">	
					<td width="90">Organization</td>
					<td width="350"><input type="text" name="trf_orz_nm" style="width:260;" class="input2" value="SM Line Corporation (026475)" readonly></td>
					<td width="90">Type</td>
					<td width="180"><input type="text" name="trf_orz_tp_nm" style="width:57;" class="input2" value="VOCC" readonly></td>				
			</table></td>
			<td width="100%">
			<div id="flagLayer1" style="display:none">
			<table border="0" cellpadding="0" cellspacing="0"  >
					<td width="90"  >Create Flag</td>
					<td width="220"><input type="text" name="cre_flg" style="width:500;" class="input1"  value="  " ></td>
			</table>
			</div>
			</td>		
			</tr>
			</table>
			
				
			<!--  biz_1   (E) -->
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	
			<!-- Grid  (S) -->
			<table class="search" border="0">
	       		<tr><td class="title_h"></td>
		   		<td class="title_s">Tariff Scope</td></tr>
	      	</table>
			<table width="100%"  cellpadding="5"  id="mainTable"> 
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
						<td class="btn2" name="btn_rowadd">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_rowdelete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>				
				</table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
	    	
			</td></tr>
		</table>
	
	<!--  biz_1   (E) -->
	
	</td></tr>
</table>

	<table class="height_10"><tr><td colspan="8"></td></tr></table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>