<%--=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_PRD_0070.jsp
*@FileTitle : Pick Up & Return CY for Booking화면
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2006-09-04 jungsunyong
*
* 2012.05.29 정선용 CHM-201217913-01	Pick Up CY for Export Booking 상, Cargo Type 추가에 따른 Logic 변경요청
=========================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.prd.networknodemanage.pickupreturncy.event.EsdPrd0070Event"%>

<%
    EsdPrd0070Event  event = null;                //PDTO(Data Transfer Object including Parameters)
  
    Exception serverException   = null;            //서버에서 발생한 에러
    DBRowSet rowSet      = null;                               //DB ResultSet
    String strErrMsg = "";                                 //에러메세지
    int rowCount     = 0;                                  //DB ResultSet 리스트의 건수
    

    try {

        event = (EsdPrd0070Event)request.getAttribute("Event");

 		
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<%@include file="/apps/alps/esd/prd/common/prdcommon/jsp/ESD_PRD_AUTH.jsp"%>
<html>
<head>
<title>Pickup Return CY </title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
    function setupPage(){
	    loadPage();
    }
</script>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
	<tr>
		<td><!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr>
				<td class="history"><img src="/hanjin/img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) --> <!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom: 5;">
			<tr>
				<td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<!-- Repeat Pattern -->
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_new" id="btn_new">New</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_save" id="btn_save">Save</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<!-- td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_loadexcel" id="btn_loadexcel">Load Excel</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td -->
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<!-- Repeat Pattern -->

					</tr>
				</table>

				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) --> <!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
				<table class="search_in" border="0">
					<tr class="h23">
                        <td width="50">Status</td>
                        <td width="130"><select name="del_flag" style="width: 60">
                            <option value="A" selected>All</option>
                            <option value="N">Live</option>
                            <option value="Y">Deleted</option>
                        </select></td>
						<td width="60">POR/DEL</td>
						<td width="130">
							<input type="" name="por_del" value="" style="width: 60" maxlength="5" dataformat="engup">
							<img class="cursor" src="/hanjin/img/alps/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_PorDel" >
						</td>
						<td width="110">POL/POD(Port)</td>
						<td width="130">
							<input type="" name="pol_pod" value="" style="width: 60" maxlength="5"  dataformat="engup">
							<img class="cursor" src="/hanjin/img/alps/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_PolPod" >
						</td>
						<td width="35">Lane</td>
						<td width="130">
							<input type="" name="lane_code" value="" style="width: 60" maxlength="3"  dataformat="engup">
							<img class="cursor" src="/hanjin/img/alps/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_Lane" >
						</td>
						<td width="45">Bound</td>
						<td width="130"><select name="bound_code">
							<option value="B">All</option>
							<option value="O">Out</option>
							<option value="I">In</option>
						</select></td>
						<td width="80">Cargo Type</td>
						<td width=""><select name="cargo_type">
							<option value="AL">All</option>
							<option value="DR">Dry</option>
							<option value="RF">Reefer</option>
							<option value="DG">DG</option>
							<option value="FO">F/R,O/T</option>
						</select></td>

					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10">
			<tr>
				<td></td>
			</tr>
		</table>


		<table class="search">
			<tr>
				<td class="bg"><!-- Grid  (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script type="text/javascript">ComSheetObject('sheet1');</script></td>
					</tr>
				</table>
				<!-- Grid (E) --> <!-- Button : Sub (S) -->
				<table width="100%" class="button">
					<tr>
						<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>

								<!-- Repeat Pattern -->
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btng_rowadd" id="btng_rowadd">Row Add</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>

								<!-- Repeat Pattern -->


							</tr>
						</table>
						</td>
					</tr>
				</table>
				<!-- Button : Sub (E) --></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) --></td>
	</tr>
</table>
<!-- Outer Table (E)--></form>
</body>
</html>
