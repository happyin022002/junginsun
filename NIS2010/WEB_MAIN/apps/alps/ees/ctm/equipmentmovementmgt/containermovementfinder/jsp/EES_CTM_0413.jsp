<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CTM_0413.jsp
*@FileTitle : BKG/MVMT VL/VD Unmatch
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.08.18 우경민
* 1.0 Creation
* --------------------------------------------------------
* History
* 2013.07.02 김상수 [CHM-201325058-01] BKG/MVMT VL/VD unmatch Inquiry 기준 값 변경(Yard ->Location)
                                        - UI-EES_CTM_0460에서 받는 parameter 방식변경
* 2014.03.10 박다은 [CHM-201428741]	CTM: Stowage Plan POD (BKG/MVMT VL/VD unmatch Inquiry)                                        
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0413Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCtm0413Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.EquipmentMovementMgt.ContainerMovementFinder");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCtm0413Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}

  String vvdCd = JSPUtil.getParameter(request, "vvdCd");
  String etdDt = JSPUtil.getParameter(request, "etdDt");
  String stsCd = JSPUtil.getParameter(request, "stsCd");
  String yard  = JSPUtil.getParameter(request, "yard");
  String yard1 = (yard.length() > 4 ? yard1 = yard.substring(0,5) : "");
  String yard2 = (yard.length() > 6 ? yard2 = yard.substring(5,7) : "");
  String restuff = JSPUtil.getParameter(request, "restuff");		//ESS_CTM_0460화면에서 넘어오는 restuff 체크여부
  String ttl = JSPUtil.getParameter(request, "ttl");				//ESS_CTM_0460화면에서 넘어오는 ttl 체크여부
  String flg = JSPUtil.getParameter(request, "flg");				//ESS_CTM_0460화면에서 넘어오는지 확인('Y'이면 ESS_CTM_0460화면에서 넘어오는 값)
  
  //restuff checkbox에 checked 표시여부 확인
  String restuffChk = "";
  if(flg.equals("Y")){		
  	if(restuff.equals("Y")){
  		restuffChk = "checked";
  	}
  }else{					//ESS_CTM_0460화면에서 넘어오지 않고 바로 페이지 불렀을때
  	restuffChk = "checked";
  }
  //ttl checkbox에 checked 표시여부 확인
  String ttlChk = "";
  if(flg.equals("Y")){
  	if(ttl.equals("Y")){
  		ttlChk = "checked";
  	}
  }else{					//ESS_CTM_0460화면에서 넘어오지 않고 바로 페이지 불렀을때
  	ttlChk = "checked";
  }

	
  // pop_mode
  String popMode = (request.getParameter("pop_mode") == null)? "N": "Y";
%>
<html>
<head>
<title>BKG/MVMT VL/VD Unmatch</title>
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
<style>
 .Obj1 {background:#C9FD86}
 .Obj2 {background:#FFFFFF}
</style>
</head>
<!-- 개발자 작업	-->


<% if (popMode.equals("Y")) { %>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<table width="100%" class="popup" cellpadding="10" border="0">
  <tr><td class="top"></td></tr>
  <tr>
    <td valign="top">
      <!-- : ( Title ) (S) -->
      <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;BKG/MVMT VL/VD unmatch Inquiry</td></tr>
      </table>
      <!-- : ( Title ) (E) -->

<% } else { %>

<body onLoad="setupPage();">
<form name="form">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
  <tr>
    <td valign="top">
      <!-- Page Title, Historical (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
      <!-- Page Title, Historical (E) -->

<% } %>

<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="p_yard">

	<!--biz page (S)-->
		<table class="search">
       	<tr><td class="bg" style="height:516" valign="top">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="50">T/VVD</td>
					<td width="95"><input type="text" style="width:80;" class="input1" value="<%=vvdCd%>" name="vls_cd" maxlength="9" tabindex="1"></td>
					<td width="30">Port</td>
					<td width="70"><input type="text" style="width:40;" class="input1" value="<%=yard1%>" name="pol_cd" maxlength="5" tabindex="2"> <input type="text" style="width:20;" class="input" value="<%=yard2%>" name="yard2" maxlength="5" tabindex="3"></td>
					<td width="265">
						<table class="search_sm2" border="0" style="width:265;">
							<tr class="h23">
								<td width="40">MVMT</td>
								<td class="stm"><input type="radio" value="RL" name="flgrslt" class="trans" <%if ("VL".equals(stsCd) || "".equals(stsCd)) {%> checked <%}%>>Result VL&nbsp;<input type="radio" class="trans" value="PD" name="flgrslt">Plan VD&nbsp;<input type="radio" value="RD" name="flgrslt" class="trans"<%if ("VD".equals(stsCd)){%> checked <%}%>>Result VD</td>
							</tr>
						</table>
					</td>
					<td width="220">
						<table class="search_sm2" border="0" style="width:220;">
							<tr class="h23">
								<td width="70">Cargo Type</td>
								<td class="stm"><input type="radio" value="" name="cgo_type" class="trans" checked>All&nbsp;<input type="radio" value="F" name="cgo_type" class="trans">Full&nbsp;&nbsp;<input type="radio" value="P" name="cgo_type" class="trans">Empty</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr><td colspan="8" style="height:2;"></td></tr>
				<tr class="h23">
					<td width="50">ETA/ETD</td>
					<td width="95"><input type="text" style="width:120;" class="input2" value="<%=etdDt%>" name="eta_etd" readonly></td>
					<td width="30">&nbsp;</td>
					<td width="70">&nbsp;</td>
					<td>
						<table class="search_sm2" border="0" style="width:205;">
							<tr class="h23">
								<td width="65">Local T/S</td>
								<td class="stm"><input type="radio" value="" name="locl_type" class="trans" checked>All&nbsp;<input type="radio" value="N" name="locl_type" class="trans">Local&nbsp;&nbsp;<input type="radio" value="Y" name="locl_type" class="trans">T/S</td>
							</tr>
						</table>
					</td>
					<td width="220">
						<table class="search_sm2" border="0" style="width:220;">
							<tr class="h23">
								<td><input type="checkbox" name="restuff" value="Y" class="trans" <%=restuffChk%>>Restuffing&nbsp;&nbsp;&nbsp;<input type="checkbox" name="ttl" value="Y" class="trans"  <%=ttlChk%>>TTL</td>
							</tr>
						</table>
					</td>
					<td width="180">
						<table class="search" border="0" style="width:180;display :none" >
							<tr class="h23">
							<td>S/Plan POD&nbsp;</td><td><script language="javascript">ComComboObject("spln_pod", 2, 70, 1, 0, 2)</script></td>
							</tr>
						</table>
					</td>
				</tr>

				</table>


				<table class="line_bluedot"><tr><td></td></tr></table>


				<!--  biz_2  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="400" valign="top">


					<table class="search" border="0">
						<tr><td colspan="8" style="height:8;"></td></tr>
						<tr><td class="title_h"></td>
						<td class="title_s">Booking container List</td></tr>
					</table>
				<!-- Grid  (S) -->
				<table width="390"  id="mainTable">
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
						<td class="btn2" name="btn_downexcel">Down Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_detail">MVMT Inquiry</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->


					</td>
					<td width="215" valign="top">

					<br><br>
					<table class="search" border="0" style="width:215;">
					<tr class="h23">
						<td width="11"></td>
						<td width="60"><input type="text" style="width:50;text-align:right" class="input" name="u1"></td>
						<td width="80"><table width="75" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_unmatch">Unmatch</td>
							<td class="btn2_right"></td>
							</tr></table>
						</td>
						<td><input type="text" style="width:50;text-align:right" class="input" name="u2"></td>
					</tr>
					<tr class="h23">
						<td width="11"></td>
						<td width="60"><input type="text" style="width:50;text-align:right;" class="input" name="m1"></td>
						<td width="80"><table width="75" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_match">Match</td>
							<td class="btn2_right"></td>
							</tr></table>
						</td>
						<td><input type="text" style="width:50;text-align:right;" class="input" name="m2"></td>
					</tr>
					<tr class="h23">
						<td width="11"></td>
						<td width="60"><input type="text" style="width:50;text-align:right;" class="Obj1" name="l1"></td>
						<td width="80"><table width="75" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_total">Total</td>
							<td class="btn2_right"></td>
							</tr></table>
						</td>
						<td><input type="text" style="width:50;text-align:right;" class="Obj1" name="l2"></td>
					</tr>

					</table>


					</td>
					<td width="380" valign="top">



					<table class="search" border="0">
						<tr><td colspan="8" style="height:2;"></td></tr>
						<tr>
						<td class="title_s"><input type="radio" value="" class="trans" checked name="mv_type">Movement&nbsp;&nbsp;&nbsp;<input type="radio" value="B" class="trans" name="mv_type">Stowage Plan</td></tr>
					</table>
				<!-- Grid  (S) -->
				<table width="378"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
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
						<td class="btn2" name="btn_downexcel2">Down Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_detail2">MVMT Inquiry</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->


					</td>
				</tr>
				</table>
				<!--  biz_2   (E) -->


				<!--  biz_3  (E) -->
				</td></tr>
			</table>
	<!--biz page (E)-->
	</td></tr>
		</table>

	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;">
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right">
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right">
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->

    </td>
  </tr>
</table>

<% if (popMode.equals("Y")) { %>

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
      <!-- : ( Button : pop ) (E) -->

<% } %>


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>