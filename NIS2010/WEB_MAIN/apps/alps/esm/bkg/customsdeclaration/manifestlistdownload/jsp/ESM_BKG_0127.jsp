<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0127.jsp
*@FileTitle : ESM_BKG_0127
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.05.18 경종윤
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.brazil.event.EsmBkg0127Event"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0127Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg0127Event)request.getAttribute("Event");
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
<title>ESM_BKG_0127</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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
<input type="hidden" name="brz_cmdt_cd">

<!-- 개발자 작업	-->


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif"
					align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>
		<!--Page Title, Historical (E)-->	
	
			<table class="height_8"><tr><td></td></tr></table>
		<!-- Tab ) (S) -->
     	
		<!-- Tab ) (E) -->
		
		<!-- Grid BG Box  (S) -->
		
     		<table class="search"> 
       		<tr><td class="bg">
			
			
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="25">VVD</td>
					<td width="85">
						<input type="text" style="width:80;ime-mode: disabled" class="input1" name="vvd_cd"
							dataformat="eng" maxlength="9" fullfill caption="VVD">
					</td>
					<td width="25">&nbsp;POL</td>
					<td width="55">
						<input type="text" style="width:50;ime-mode: disabled" class="input" name="pol_cd" value=""
							dataformat="engupnum" caption="POL" fullfill maxlength="5">
					</td>
					<td width="25">&nbsp;POD</td>
					<td width="55">
						<input type="text" style="width:50;ime-mode: disabled" class="input" name="pod_cd"
							dataformat="engupnum" caption="POD" fullfill maxlength="5">
					</td>
					
					<td width="25">&nbsp;DEL</td>
					<td width="55">
						<input type="text" style="width:50;ime-mode: disabled" class="input" name="del_cd"
							dataformat="engupnum" caption="DEL" fullfill maxlength="5">
					</td>
					
					<td width=100 align="left">
						<table class="search_sm2" border="0">
							<tr class="h23">
							<td>
								<input type="radio" name="io_type" value="O" checked class="trans">O/B&nbsp;<input type="radio" name="io_type" value="I" class="trans">I/B
								<input type="hidden" name="search_io_type" value="">
							</td>
							</tr>
						</table>
					</td>
					<td width=110 align="left">
						<table class="search_sm2" border="0">
							<tr class="h23">
							<td>
								<input type="radio" name="error_type" value="1" checked class="trans" >All&nbsp;<input type="radio" name="error_type" value="2" class="trans" ></td><td>Error B/L
							</td>
							</tr>
						</table>
					</td>
					
					<td width=120 align="right">
						<table class="search_sm2" border="0">
						<tr class="h23">
		                <td width="50">Cargo Type</td>
		                <td width="81"><select name="bkg_cgo_tp_cd" style="width:60">
			                <option>All</option>
			                <option value="F" selected>Full</option>
			                <option value="P">Empty</option>
			                </select>
			            </td>
						</tr>
						</table></td>
					<td width="25">DUV</td>
					<td width="100">
						<input type="text" style="width:100;ime-mode: disabled" class="input" name="br_duv"
							dataformat="engupnum" caption="DUV" fullfill maxlength="10">&nbsp;
					</td>
					<td width="55">Manifest ID</td>
					<td width="105">
						<input type="text" style="width:105;ime-mode: disabled" class="input" name="br_mid"
							dataformat="engupnum" caption="Manifest ID" fullfill maxlength="13">
					</td>	
					</tr>
				
					<tr class="h23">
					<td width="25"></td>
					<td width="85"></td>
					<td width="25"></td>
					<td width="55"></td>
					<td width="25"></td>
					<td width="55"></td>
					<td width="25"></td>
					<td width="55"></td>
					
					<td width=100 align="left">
					</td>
					<td width=110 align="left">
					</td>
					
					<td width=120 align="right">
					</td>
					<td width="25">B/L No.</td>
					<td width="100">
						<input type="text" style="width:100;ime-mode: disabled" class="input1" name="bl_no"
							dataformat="engupnum" caption="BL No." fullfill maxlength="13">&nbsp;
					</td>
					<td width="55">CNPJ No.</td>
					<td width="105">
						<input type="text" style="width:105;ime-mode: disabled" class="input" name="cnpj_no"
							dataformat="engupnum" caption="CNPJ No." fullfill maxlength="14">
					</td>	
					</tr>				
				</table>

				<table class="line_bluedot"><tr><td></td></tr></table>		
				<!--Grid (s)-->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
				<!--Grid (E)-->
						<!--  Button_Sub (S) -->
						
	    				<!-- Button_Sub (E) -->
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S)  -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
					<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_datadl">Data DownLoad</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_transmit">Transmit</td>
					<td class="btn1_right"></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
	
</table>	

	
	    <!-임시 (S)-->
	    <!-- 
	    <table style="width:979;height:100">
	    	<tr><td>result : </td></tr>
	        <tr>
	            <td><textarea name="output" cols="100" rows="20">Back End Job을 로 실행됩니다. 만들어진 FlatFile은 리턴받을 수 없습니다.</textarea></td>
	        </tr>
	    </table>
		 -->
	
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>