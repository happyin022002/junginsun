<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_9500.jsp
*@FileTitle  PopUp 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2014-06-10
*@LastModifier : PCH
*@LastVersion : 1.0
* 2014-06-10 PCH
* 1.0 최초 생성
* 2014-06-19 : 박재흥 [CHM-201429999] TES: Cost Code SVXXHC Vol 계산시 TOR data참조 logic
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%
	String param_name = null;
	java.util.Enumeration enums = request.getParameterNames();
	while (enums.hasMoreElements()){
		param_name = (String)enums.nextElement();
	}

	String vvd 		 		= request.getParameter("vvd"				)!=null&&!request.getParameter("vvd"				).equals("")?request.getParameter("vvd"					):"";
	String yd_cd			 	= request.getParameter("yd_cd"				)!=null&&!request.getParameter("yd_cd"				).equals("")?request.getParameter("yd_cd"				):"";
	String yd_nm			 	= request.getParameter("yd_nm"			)!=null&&!request.getParameter("yd_nm"			).equals("")?request.getParameter("yd_nm"				):"";
	String atb_dt			 	= request.getParameter("atb_dt"			)!=null&&!request.getParameter("atb_dt"			).equals("")?request.getParameter("atb_dt"				):"";
%><html>
<head>
<title>Welcome to ALPS!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage(){
        loadPage();
    }

</script>

</head>


<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="atb_dt" value="<%=atb_dt%>">

<!-- OUTER - POPUP (S)tart -->
<table width="770" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;TOR Inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->


		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<table class="search_in" border="0" style="width:100%;">
					<tr class="h23">
						<td width="30">VVD</td>
						<td width="100"><input type="text"  class="input1"  style="width:90; text-align:center;" name="vvd"  readonly value="<%=vvd%>"></td>
						<td width="35">Port</td>
						<td width="390"><input type="text"  class="input1"  style="width:80;  text-align:center;" name="no_yd_cd"  readonly value="<%=yd_cd%>">&nbsp;&nbsp;<input type="text" style="width:300" name="yd_nm" value="<%=yd_nm%>"></td>
						<td width="30">UOM</td>
						<!-- // CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11) -->
						<td width="110">&nbsp;&nbsp;<input type="radio"  class="input" name="uom"   style="valign:absmiddle;"  value="B">Box&nbsp;<input type="radio"  class="input" name="uom" checked style="valign:absmiddle;" value="M">Move</td>
					</tr>
				</table>
			
				

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->
		
		
			<table class="height_10"><tr><td></td></tr></table>
				
				<table class="search" border="0" style="width:100%;">
					<tr class="h23" >
						<td class="title_s"  width="250" colspan=2  >Handling Moves</td>
						<td class="title_s"  width="404" colspan=1>Teminal Working Time</td>
					</tr>		
							
					<tr class="h23">
						<td class="bg"   width="150">Hatch Cover Handling </td>
						<td class="bg"   width="100"><input type="text" style="width:90;" name="hatch_handl"  readonly value=""></td>
						
						<td class=""   width="">
						<table class="search" border="0" cellpadding=0 cellspacing=0 style="width:100%;">
							<tr class="h23">
								<td class="bg"  width="202"  style="text-align:center;">Work Commenced</td>
								<td class="bg"  width="202"  style="text-align:center;">Work Completed</td>
							</tr>
							
							<tr class="" >
								<td class="bg"  style="text-align:center;"  width="202" ><input type="text" style="width:120;" name="work_comm"  readonly value=""></td>
								<td class="bg"  style="text-align:center;"  width="202" ><input type="text" style="width:120;" name="work_comp" readonly  value=""></td>
							</tr>
							
						</table>						
						</td>
						
					</tr>
				</table>

				<table class="height_5"><tr><td></td></tr></table>
				<!-- : ( Speed ) (S) -->
                    <table width="100%" id="mainTable" style="display:none;">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet');</script>
                        </td></tr>
                    </table>
				<!-- : ( Speed ) (E) -->
					<!-- : ( Button : Sub ) (S) -->
				<table class="button" border="0" width="100%">
					<tr><td class="btn2_bg" class="align">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn2_left"></td>
									<td class="btn2" name="btn_apply" id="btn_apply">Apply</td>
									<td class="btn2_right"></td>
									<td class="btn2_left"></td>
									<td class="btn2" name="btn_close" id="btn_close">Close</td>
									<td class="btn2_right"></td>
								</tr>
								</table>
								</td>
								<!-- Repeat Pattern -->
							</tr>
						</table>
					</td></tr>
				</table>
	    	<!-- : ( Button : Sub ) (E) -->		

</td>
</tr>
</table>
<!-- OUTER - POPUP (E)nd -->

<table class="height_10"><tr><td></td></tr></table>

<!-- : ( Button : Sub ) (S) -->
<!--table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table class="sbutton">
		<tr><td class="p_bt"><img class="cursor" src="/hanjin/img/button/btn_ok.gif" width="66" height="20" border="0" name="btn_ok"></td>
		<td class="p_bt"><img class="cursor" src="/hanjin/img/button/btn_close.gif" width="66" height="20" border="0" name="btn_close"></td></tr>
		</table>

	</td></tr>
</table-->
<!-- : ( Button : Sub ) (E) -->

	</form>

</body>
</html>
