<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : vop_opf_2024.jsp
 *@FileTitle : CBF Partner EDI
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
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
<%@ page import="com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event.VopOpf2024Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%
	//부모창에서 파라메터 받아오기;
	String vvd 		= "";
	String pol_clpt_ind_seq 	= "";
	String yd_cd 		= "";
		
	Logger log = Logger.getLogger("com.hanjin.apps.CargoLoadingPlanMgt.OwnContainerBookingForecastMgt");
	
	VopOpf2024Event event = null; 		//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; 	//서버에서 발생한 에러
	String strErrMsg = ""; 				//에러메세지
	int rowCount = 0; 					//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";

	try {
		SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (VopOpf2024Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		vvd         = StringUtil.xssFilter(request.getParameter("vvd"))== null?"":StringUtil.xssFilter(request.getParameter("vvd"));
		yd_cd       = StringUtil.xssFilter(request.getParameter("pol_cd"))== null?"":StringUtil.xssFilter(request.getParameter("pol_cd"));
		pol_clpt_ind_seq = StringUtil.xssFilter(request.getParameter("pol_clpt_ind_seq"))== null?"":StringUtil.xssFilter(request.getParameter("pol_clpt_ind_seq"));

		
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Partner CBF EDI</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
 var frDt = ComGetDateAdd('<%=JSPUtil.getKST("yyyy-MM-dd")%>', "D", -10);
 var toDt = "<%=JSPUtil.getKST("yyyy-MM-dd")%>";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} 
		loadPage();	
	}
</script>
</head>
<body class="popup_bg" onLoad="setupPage();">
<form name="form">

<input type="hidden" name="f_cmd">
<input type="hidden" name="uid">
<input type="hidden" name="pagerows">
<input type="hidden" name="cntr_tpsz_cd" value=" "/>
<input type="hidden"   name="vsl_cd" value=" "/>
<input type="hidden"   name="skd_voy_no" value=" "/>
<input type="hidden"   name="skd_dir_cd" value=" "/>
<!-- 개발자 작업	--> <!-- OUTER - POPUP (S)tart -->

<table width="100%" class="popup" cellpadding="10" border="0">
	<tr><td valign="top">
			<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; Partner CBF EDI</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		<!--biz page (S)   -->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg" style="height:450;" valign="top">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:860;"> 
				<tr class="h23"> 
					          <!--   <td width="30">VVD&nbsp;</td>
								<td width="100"><input type="text" style="width: 80;text-align:center;" class="input2" value="HSBD0010E" name="vvd" readOnly></td> -->
								<td width="30">POL&nbsp;</td>
								<td width="80"><input type="text" style="width: 70;text-align:center;" class="input2" value="<%=yd_cd %>"  name="yd_cd" readOnly></td>
								<td width="30">OPR&nbsp;</td>
								<td width="90"><input name="crr_cd" type="text" style="width:60;" class="input" value=""  required fullfill maxlength="3"  style="ime-mode:disabled;text-align:center;" onkeypress="eventKeyChangeChar(UPPER_CASE);" >
						                        <img class="cursor" name="btn_crr_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
								</td>
								<td width="90">RECEIVE DATE</td>
				    			<td width="210"><input type="text" name="fr_dt" style="width:80; text-align:center;" class="input" dataformat="ymd" maxlength="8" caption="From Date">&nbsp;~&nbsp;<input type="text" name="to_dt" style="width:80; text-align:center;" class="input" dataformat="ymd" maxlength="8" caption="To Date">&nbsp;<img src="img/btns_calendar.gif" id="btns_period" name="btns_period" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				
								<td  width="200" class="stm"><input type="radio" value="Y" name="apply_yn" class="trans"  OnClick="apply_flg();">Apply&nbsp;&nbsp;<input type="radio"  name="apply_yn" value="N" class="trans" OnClick="apply_flg();" checked >Not Apply</td>
								
								<input type="hidden" style="width:10;text-align:center;" class="input2" value="1" name="pol_clpt_ind_seq" readOnly>
								<input type="hidden" style="width: 70;text-align:center;" class="input2" value="<%=vvd %>"  name="vvd" readOnly>
				</tr>
				</table>
				<!--  biz_1   (E) -->
		     
		<table class="line_bluedot"><tr><td></td></tr></table>	
		
		
			<!-- Grid  (S) -->
			
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						
						</td>
					</tr>
				</table>

			<!-- Grid (E) -->			

	    	<!-- Button_Sub (E) -->
			
			
			</td></tr>
		</table>
		<!--biz page (E)-->
	
	</td></tr>
		</table>
	
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
											<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Save">Save</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Close">Close</td>
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
		
	</td></tr>
</table>  

<!-- : ( Button : pop ) (E) --> <!-- 개발자 작업  끝 -->

</form>
</body>
</html>
<%@include file="/bizcommon/include/common_nis2010.jsp"%>