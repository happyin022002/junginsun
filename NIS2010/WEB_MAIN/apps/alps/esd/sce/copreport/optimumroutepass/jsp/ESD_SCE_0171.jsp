<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_SCE_0171.jsp
*@FileTitle : Optimum Route Pass-Detail
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------------------------------------------------------
* History
* 2013.04.29 조인영 [CHM-201323843] [SCE] Optimum Route Pass의 조회 조건 및 칼럼 추가
* 2013.07.16 조인영 [CHM-201324797] [TRS] Optimum Route Pass의 칼럼 로직 정정 및 Compact 양식 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.copreport.optimumroutepass.event.EsdSce0171Event"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.Date"%>
<%
	EsdSce0171Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";

	String strWo_cre_ofc_cd = StringUtil.xssFilter(request.getParameter("sel_wo_cre_ofc_cd"));
	String strFrom_date = StringUtil.xssFilter(request.getParameter("sel_from_date"));
	String strTo_date = StringUtil.xssFilter(request.getParameter("sel_to_date"));
	
	String strBnd_cd = StringUtil.xssFilter(request.getParameter("sel_bnd_cd"));
	String strTrsp_mod_cd = StringUtil.xssFilter(request.getParameter("sel_trsp_mod_cd"));
	String strInput_office = StringUtil.xssFilter(request.getParameter("sel_ofc_cd"));
	String strSelOpTp = StringUtil.xssFilter(request.getParameter("sel_op_tp"));
	String strDscrRsnMap = StringUtil.xssFilter(request.getParameter("sel_dscr_rsn_map"));
	String strFrom_node = StringUtil.xssFilter(request.getParameter("from_node"));
	String strDoor_node = StringUtil.xssFilter(request.getParameter("door_node"));
	String strSel_date = StringUtil.xssFilter(request.getParameter("sel_date"));
	String strSo_no = StringUtil.xssFilter(request.getParameter("sel_so_no"));

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		event = (EsdSce0171Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
    // change to table name
	String transModeCd  = JSPUtil.getCodeCombo("dscr_rsn_cd" , "01", "style='width:120'", "CD03059", 0, "000010:ALL:ALL");
%>
<html>
<head>
<title>Optimum Route Pass Detail</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

	<%= JSPUtil.getIBCodeCombo("dscr_rsn_cd" , "", "CD03059", 0, "")%>

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
<input type="hidden" name="load_flg" value="N">
<input type="hidden" name="exl_flg" value="N">

<input type="hidden" name="wo_cre_ofc_cd" value="<%=strWo_cre_ofc_cd%>">
<input type="hidden" name="from_date" value="<%=strFrom_date%>">
<input type="hidden" name="to_date" value="<%=strTo_date%>">

<input type="hidden" name="bnd_cd" value="<%=strBnd_cd%>">
<input type="hidden" name="trsp_mod_cd" value="<%=strTrsp_mod_cd%>">
<input type="hidden" name="input_office" value="<%=strInput_office%>">
<input type="hidden" name="sel_op_tp" value="<%=strSelOpTp %>">
<input type="hidden" name="dscr_rsn_map" value="<%=strDscrRsnMap %>">
<input type="hidden" name="from_node" value="<%=strFrom_node %>">
<input type="hidden" name="door_node" value="<%=strDoor_node %>">
<input type="hidden" name="sel_date" value="<%=strSel_date %>">
<input type="hidden" name="sel_so_no" value="<%=strSo_no %>">

<!-- 개발자 작업	-->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	<!-- : ( Title ) (S) -->
	<table width="100%" border="0">
	<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Optimum Route Pass Detail
	</td></tr>
	</table>
	<!-- : ( Title ) (E) -->

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
                <td class="btn1" name="btn_down_excel">Down Excel</td>
                <td class="btn1_right"></td>
                </tr>
            </table></td>
        </tr>
        </table>
    </td></tr>
    </table>
    <!--Button (E) -->

	<!-- : ( Search Options ) (S) -->
	<table class="search"> 
      		<tr><td class="bg">
			<!-- biz_1  (S) -->
			<table class="search" border="0" style="width:900;"> 
			<tr class="h23">
				<td width="140">Optimum Route Pass</td>
				<td width="170">
					<script language="javascript">ComComboObject('optm_rout_pass_flg', 1, 100, 1);</script>
				</td>	
				<td width="140">Discrepancy Reason</td>
				<td width="">
					<script language="javascript">ComComboObject('dscr_rsn_cd', 1, 180, 1);</script>
				</td>	
				<td width="50">Format</td>
				<td width="150">
					<table border="0" style="height:25; background-color: #E9E9E9;">
						<tr><td>
							<input type="checkbox" name="chk_compact" value="" class="trans" onclick="chkCompactOption();">Compact
						</td></tr>
					</table>
				</td>
			</tr>
			</table>
			<!-- biz_1  (E) -->
		</td></tr>
	</table>
	<table class="height_8"><tr><td></td></tr></table>
	
		
	<table class="search"> 
      <tr><td class="bg">
		<!-- : ( Grid ) (S) -->
		<table width="100%" id="mainTable"> 
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
				</td>
			</tr>
		</table> 				
		<!-- : ( Grid ) (E) -->	
		</td>
		</tr>
	</table> 
	<table class="height_10"><tr><td></td></tr></table>

	</td></tr>
</table> 

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="74" class="popup">
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
      	<tr><td class="btn3_bg">
	    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
			<td width="">
			<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_close">Close</td>
				<td class="btn1_right"></td></tr>
			</table>
			</td>	
			</tr>
		</table>
		</td></tr>
	</table>
</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<div id="tabLayer" style="display:none">
	<table class="search" id="mainTable"> 
      	<tr><td class="bg">	
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet2');</script>
					</td>
				</tr>
			</table>
		</td></tr>
	</table>
</div>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>