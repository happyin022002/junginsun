<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0246.jsp
*@FileTitle : Detail(Bunker/Canal Fee)
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.09.09 유혁
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0246Event"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CanalBnkSavVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0246Event event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	Logger log = Logger.getLogger("com.hanjin.apps.scheduleplanningoperation.vesselschedulemgt");
	
	String vvd = request.getParameter("vvd");
	String vslCd = vvd.substring(0, 4);
	String skdVoyNo = vvd.substring(4, 8);
	String skdDirCd = vvd.substring(8, 9);
	String vslSlanCd = JSPUtil.replaceForHTML(request.getParameter("vsl_slan_cd"));
	String vpsPortCd = JSPUtil.replaceForHTML(request.getParameter("vps_port_cd"));
	String bound = JSPUtil.replaceForHTML(request.getParameter("bound"));

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		event = (VopVsk0246Event)request.getAttribute("Event");
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
<title>Detail(Bunker/Canal Fee)</title>
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

<body class="popup_bg" onLoad="setupPage();"> 

<form name="form"> 
<input type="hidden" name="f_cmd">
<input type="hidden" name="bound" value="<%=bound%>">

<input type="hidden" name="next_port">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Detail (Bunker/Canal Fee) </td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 			
			<table class="search"> 
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				
				<table class="search" border="0" style="width:780;"> 
				<tr class="h23">
					<td width="30">VVD</td>   
					<td width="230">
						<input type="text" style="width:55;text-align:center;" class="input1" name="vsl_cd" value="<%=vslCd%>" readonly>&nbsp;
						<input type="text" style="width:55;text-align:center;" class="input1" name="skd_voy_no" value="<%=skdVoyNo%>" readonly>&nbsp;
						<input type="text" style="width:25;text-align:center;" class="input1" name="skd_dir_cd" value="<%=skdDirCd%>" readonly></td>
					<td width="70">Lane Code</td>
					<td width=""><input type="text" style="width:55;text-align:center;" class="input2" name="vsl_slan_cd" value="<%=vslSlanCd%>" readonly></td>   
					</tr>
				</table>
				<!--  biz_1   (E) -->
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
				<!-- : ( BOx1 ) (S) -->
				<table width="100%" class="grid2"> 
				<tr class="tr2_head">
					<td width="" colspan="5">VSL Condition</td>
					<td width="" colspan="2"> Bunker Condition</td>
					<td width="" colspan="3">Canal transit Surcharge (USD)</td>
				</tr>
					
					
				<tr>
					<td align="center" width="" class="tr2_head2"> From -to		</td>
					<td align="center" colspan="2"><input type="text" name="vps_port_cd" style="width:100%;text-align:center" class="noinput" value="<%=vpsPortCd%> " readOnly></td>
					<td align="center" colspan="2"><input type="text" style="width:100%;text-align:center" class="noinput" value=" EGSUZ" readOnly>	</td>
					<td align="center" width="150" class="tr2_head2"> Supply Bunker Q'ty		</td>
					<td align="center" width="150"><input type="text" style="width:100%;text-align:center" class="noinput" name="supply_bunker_qty" value=" " readOnly></td>
					<td align="center" width="100" class="tr2_head2" rowspan="6"> Convoy or<br>Group</td>
					<td align="center" width="50" rowspan="2"><input type="text" style="width:100%;text-align:right" class="noinput" value=" 3.0%" readOnly></td>
					<td align="center" width="150" rowspan="2"><input type="text" style="width:100%;text-align:right" class="noinput" name="cts_1st" value=" " readOnly></td>
				</tr>
				<tr>
					<td align="center" width="" class="tr2_head2">  Reported Date (GMT)</td>
					<td align="center" colspan="4"><input type="text" style="width:100%;text-align:center" class="noinput" name="reported_date" value=" " readOnly></td>
					<td align="center" width="" class="tr2_head2"> Supply Bunker Port	</td>
					<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" name="supply_bunker_port" value=" " readOnly></td>
					
				</tr>
				<tr>
					<td align="center" width="" class="tr2_head2"> ETA </td>
					<td align="center" colspan="4"><input type="text" style="width:100%;text-align:center" class="noinput" name="nxt_port_eta" value=" " readOnly></td>
					<td align="center" width="" class="tr2_head2">  Bunker Price	 (USD)</td>
					<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" name="actual_bunker_price" value=" " readOnly></td>
					<td align="center" width="50" rowspan="2"><input type="text" style="width:100%;text-align:right" class="noinput" value=" 5.0%" readOnly></td>
					<td align="center" width="150" rowspan="2"><input type="text" style="width:100%;text-align:right" class="noinput" name="cts_2nd" value=" " readOnly></td>
				</tr>
				<tr>
					<td align="center" width="" class="tr2_head2">  Distance To Go</td>
					<td align="center" colspan="4"><input type="text" style="width:100%;text-align:center" class="noinput" name="remain_dist" value=" " readOnly></td>
					<td align="center" width="" class="tr2_head2"> ROB		</td>
					<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" name="remain_bunker" value=" " readOnly></td>
					
				</tr>
				<tr>
					<td align="center" width="" class="tr2_head2">   ETA SPEED	</td>
					<td align="center" colspan="4"><input type="text" style="width:100%;text-align:center" class="noinput" name="remain_spd" value=" " readOnly></td>
					<td align="center" width="" class="tr2_head2"> Bunker Consumption per HR<br> (ETA Speed)	</td>
					<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" name="bunker_consum_by_eta" value=" " readOnly></td>	
					<td align="center" width="50" rowspan="2"><input type="text" style="width:100%;text-align:right" class="noinput" value=" 10.0%" readOnly></td>
					<td align="center" width="150" rowspan="2"><input type="text" style="width:100%;text-align:right" class="noinput" name="cts_3rd" value=" " readOnly></td>
					
				</tr>
				<tr>
					<td align="left" width="130" class="tr2_head2"> Weather Condition	</td>
					<td align="left" width="50" class="tr2_head2">Wind	</td>
					<td align="center" width="50"><input type="text" style="width:100%;text-align:center" class="noinput" name="wind_dir_scale" value=" " readOnly></td>
					<td align="left" width="50" class="tr2_head2">Sea</td>
					<td align="center" width="50"><input type="text" style="width:100%;text-align:center" class="noinput" name="sea_dir_scale" value=" " readOnly></td>
					<td align="center" class="tr2_head2">Course</td>
					<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" name="course_org" value=" " readOnly></td>
					
				</tr>
				
				</table> 
				<!-- : ( BOx1 ) (E) -->
		 <table class="height_5"><tr><td></td></tr></table>
			<!-- : ( BOx2 ) (S) -->
				<table width="100%" class="grid2">
				<!--  
				<tr class="tr_head">
					<td width="5%">Case</td>
					<td width="14%">Transit Limit</td>
					<td width="9%">Surcharge</td>
					<td width="9%">ETA Speed</td>
					<td width="26%" colspan="2">Add Bunker Consumption Q’ty</td>
					<td width="10%">Next Port<br>ETA Speed</td>
					<td width="10%">Add Bunker<br>Consumption</td>
					<td width="10%">Bunker<br>Expense</td>
					<td width="%">Result</td>
				</tr>
				 -->
				 <tr class="tr2_head">
					<td width="5%" rowspan="2">Case</td>
					<td width="14%" rowspan="2">Transit Limit</td>
					<td width="9%" rowspan="2">Surcharge</td>
					<td width="9%" rowspan="2">ETA Speed</td>
					<td width="20%" colspan="2">Add Bunker Consumption</td>
					<td width="8%" rowspan="2">Next Port<br>ETA Speed</td>
					<td width="10%" rowspan="2">Add Bunker<br>Consumption</td>
					<td width="12%" rowspan="2">Bunker Expense<br>(USD)</td>
					<td width="%" rowspan="2">Result<br>(USD)</td>
				</tr>
				<tr class="tr2_head">
					<td width="7%">Q'ty</td>
					<td width="13%">Amount (USD)</td>
				</tr>
				<tr>
				<td align="left" width="%" class="tr2_head2">1</td>
				<td align="left" width="%" class="tr2_head2">Speed of Transit SUZ<br>without Surcharge</td>
				<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" value=" 0%" readOnly></td>			
				<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" name="eta_speed_1" value=" " readOnly></td>
				<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" name="add_bunker_consum_qty_1" value=" " readOnly></td>
				<td align="center"><input type="text" style="width:100%;text-align:right" class="noinput" name="add_bunker_consum_amount_1" value=" " readOnly></td>
				<td align="center" rowspan="4"><input type="text" style="width:100%;text-align:center" class="noinput" name="next_port_eta_speed_1" value=" " readOnly></td>
				<td align="center" rowspan="4"><input type="text" style="width:100%;text-align:center" class="noinput" name="add_bunker_consum_02_1" value=" " readOnly></td>
				<td align="center" rowspan="4"><input type="text" style="width:100%;text-align:right" class="noinput" name="add_bunker_amount_02_1" value=" " readOnly></td>
				<td align="center"><input type="text" style="width:100%;text-align:right" class="noinput" name="result_1" value=" " readOnly></td>
				</tr>
				<tr>
				<td align="left" width="%" class="tr2_head2" rowspan="3">2</td>
				<td align="left" width="%" class="tr2_head2" rowspan="3">Speed for transit 1st<br>convoy or Group</td>
				<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" value=" 3%" readOnly></td>			
				<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" name="eta_speed_2" value=" " readOnly></td>
				<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" name="add_bunker_consum_qty_2" value=" " readOnly></td>
				<td align="center"><input type="text" style="width:100%;text-align:right" class="noinput" name="add_bunker_consum_amount_2" value=" " readOnly></td>
				<td align="center"><input type="text" style="width:100%;text-align:right" class="noinput" name="result_2" value=" " readOnly></td>
				</tr>
				<tr>
				<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" value=" 5%" readOnly></td>			
				<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" name="eta_speed_3" value=" " readOnly></td>
				<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" name="add_bunker_consum_qty_3" value=" " readOnly></td>
				<td align="center"><input type="text" style="width:100%;text-align:right" class="noinput" name="add_bunker_consum_amount_3" value=" " readOnly></td>
				<td align="center"><input type="text" style="width:100%;text-align:right" class="noinput" name="result_3" value=" " readOnly></td>
				</tr>
				<tr>
				<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" value=" 10%" readOnly></td>			
				<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" name="eta_speed_4" value=" " readOnly></td>
				<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" name="add_bunker_consum_qty_4" value=" " readOnly></td>
				<td align="center"><input type="text" style="width:100%;text-align:right" class="noinput" name="add_bunker_consum_amount_4" value=" " readOnly></td>
				<td align="center"><input type="text" style="width:100%;text-align:right" class="noinput" name="result_4" value=" " readOnly></td>
				</tr>
				<tr>
				<td align="left" width="%" class="tr2_head2">3</td>
				<td align="left" width="%" class="tr2_head2">Speed of Transit SUZ<br>without Surcharge</td>
				<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" value=" 0%" readOnly></td>			
				<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" name="eta_speed_5" value=" " readOnly></td>
				<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" name="add_bunker_consum_qty_5" value=" " readOnly></td>
				<td align="center"><input type="text" style="width:100%;text-align:right" class="noinput" name="add_bunker_consum_amount_5" value=" " readOnly></td>
				<td align="center" rowspan="4"><input type="text" style="width:100%;text-align:center" class="noinput" name="next_port_eta_speed_2" value=" " readOnly></td>
				<td align="center" rowspan="4"><input type="text" style="width:100%;text-align:center" class="noinput" name="add_bunker_consum_02_2" value=" " readOnly></td>
				<td align="center" rowspan="4"><input type="text" style="width:100%;text-align:right" class="noinput" name="add_bunker_amount_02_2" value=" " readOnly></td>
				<td align="center"><input type="text" style="width:100%;text-align:right" class="noinput" name="result_5" value=" " readOnly></td>
				</tr>
				<tr>
				<td align="left" width="%" class="tr2_head2" rowspan="3">4</td>
				<td align="left" width="%" class="tr2_head2" rowspan="3">Speed for transit 2nd<br>convoy or Group</td>
				<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" value=" 3%" readOnly></td>			
				<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" name="eta_speed_6" value=" " readOnly></td>
				<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" name="add_bunker_consum_qty_6" value=" " readOnly></td>
				<td align="center"><input type="text" style="width:100%;text-align:right" class="noinput" name="add_bunker_consum_amount_6" value=" " readOnly></td>
				<td align="center"><input type="text" style="width:100%;text-align:right" class="noinput" name="result_6" value=" " readOnly></td>
				</tr>
				<tr>
				<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" value=" 5%" readOnly></td>			
				<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" name="eta_speed_7" value=" " readOnly></td>
				<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" name="add_bunker_consum_qty_7" value=" " readOnly></td>
				<td align="center"><input type="text" style="width:100%;text-align:right" class="noinput" name="add_bunker_consum_amount_7" value=" " readOnly></td>
				<td align="center"><input type="text" style="width:100%;text-align:right" class="noinput" name="result_7" value=" " readOnly></td>
				</tr>
				<tr>
				<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" value=" 10%" readOnly></td>			
				<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" name="eta_speed_8" value=" " readOnly></td>
				<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" name="add_bunker_consum_qty_8" value=" " readOnly></td>
				<td align="center"><input type="text" style="width:100%;text-align:right" class="noinput" name="add_bunker_consum_amount_8" value=" " readOnly></td>
				<td align="center"><input type="text" style="width:100%;text-align:right" class="noinput" name="result_8" value=" " readOnly></td>
				</tr>
				</table>
			<!-- : ( BOx2) (E) -->
			<table class="height_5"><tr><td></td></tr></table>
			<!-- : ( BOx3 ) (S) -->
			<!-- 
				<table width="100%" class="grid2"> 
				<tr class="tr_head">
					<td width="40%" colspan="5">Weather Condition (Mediterranean/Indian Ocean)</td>
					<td width="%"  colspan="5">Optimized Cancel Transit Time ( Only Reference) </td>
				</tr>
				<tr>
				<td align="left" width="%" class="tr2_head2">Wind</td>
				<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" value=" SSW7"></td>			
				<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" value=" SW5"></td>
				<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" value=" SW7"></td>
				<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" value=" W5"></td>
				<td align="left" width="%" class="tr2_head2">Case</td>
				<td align="left" width="%" class="tr2_head2">Add Canal Surcharge</td>
				<td align="left" width="%" class="tr2_head2">ADD Bunker Q’ty</td>
				<td align="left" width="%" class="tr2_head2">ADD Bunker Amount</td>
				<td align="left" width="%" class="tr2_head2">Total Expense</td>
				</tr>
				<tr>
				<td align="left" width="%" class="tr2_head2">Sea</td>
				<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" value=" SSW7"></td>			
				<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" value=" SW5"></td>
				<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" value=" SW7"></td>
				<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" value=" W4"></td>
				<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" value=" "></td>			
				<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" value=" "></td>
				<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" value=" "></td>
				<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" value=" "></td>
				<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput" value=" "></td>
				</tr>
				</table>
			 -->
			<!-- : ( BOx3) (E) -->
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->

<table class="height_5"><tr><td></td></tr></table>

</td></tr>
</table> 
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!--  조회 결과 매핑용 그리드. 화면에 표시되지 않음. -->
<table width="100%"  id="mainTable"> 
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('sheet1');</script>
		</td>
	</tr>
</table>
			
</form>			
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp" %>