<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_vsk_0010.jsp
*@FileTitle : Lane Information Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.06.16 장석현
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.event.VopVsk0512Event"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VskComboVO"%>
<%@ page import="com.hanjin.syscommon.common.table.MdmVslSvcLaneVO"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0512Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.VesselOperationSupportMgt.LaneInformationMgt");
	StringBuffer bunkerPort = new StringBuffer("");
	StringBuffer laneCd = new StringBuffer("");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopVsk0512Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..\

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		List<VskComboVO> list = (List<VskComboVO>)eventResponse.getCustomData("BunkerPort");
		List<MdmVslSvcLaneVO> list2 = (List<MdmVslSvcLaneVO>)eventResponse.getCustomData("LaneCd");

		if(list != null){
			for(int cnt = 0; cnt < list.size(); cnt++){
				VskComboVO combo = list.get(cnt);
				
				bunkerPort.append("|" + combo.getVal());
			}
		}
		if(list2 != null){
			for(int cnt = 0; cnt < list2.size(); cnt++){
				MdmVslSvcLaneVO combo = list2.get(cnt);
				
				laneCd.append("|" + combo.getVslSlanCd());
			}
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Lane Information Creation</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="comboCd">
<input type="hidden" name="pagerows">
<input type="hidden" name="bunkerPort" value="<%=bunkerPort%>">
<input type="hidden" name="laneCd" value="<%=laneCd%>">
<input type="hidden" name="vskd_flet_grp_cd" value="%">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr><td valign="top">
	
	
	
		<!--Page Title, Historical (S)-->
		
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
		<!--biz page (S)-->
		<!-- 1 (S) -->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">


				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="70">Lane Code</td>
					<td width="245"><input type="text" style="width:40;text-align:center;" class="input" value="" name="slan_cd" maxlength="3" fullfill caption="Lane Code" style="ime-mode:disabled">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="ComOpenPopupWithTarget"></td>
					<td width="450">&nbsp;</td>					
					<td width="90">Updated Date</td>   
					<td width="116"><input type="text" name="upd_dt_view" style="width:115;text-align:center;" class="input2" readOnly></td>
					<td width="70" align="right"><input type="text" name="upd_id_view" style="width:70;" class="input2" readOnly></td>
				</tr> 
				</table>				
				<!--  biz_1   (E) -->
				

		</td></tr></table>	
		<table class="height_8"><tr><td></td></tr></table>	
		<!-- 1 (E) -->
		
		
		<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tabLane')</script>
						<!-- img src="/img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
					</td></tr>
				</table>
		<!-- Tab ) (E) --> 
				


<!--TAB  (S) -->
<div id="tabLayer" style="display:inline">
						
		<!-- 2 (S) -->
		<table class="search" id="mainTable"> 
       	<tr><td class="bg" style="height:438" valign="top">		
				
			<!-- grid box (S) -->
			<table class="search">
			<tr><td valign="top" width="50%">	
					

					<table class="search" border="0">
					<tr><td class="height_10"></td></tr>
					<tr><td class="title_h"></td>
						<td class="title_s">Main SVC Including SML Operation</td></tr>
					</table>
					

					<!-- Grid - 1 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t1sheet1');</script>
						</td>
					</tr>
				</table>					
				<!-- Grid - 1 (E) -->	

											
				</td>
				
				<td valign="top" width="50%" style="padding-left:10px;">	

					<table class="search" border="0">
					<tr><td class="height_10"></td></tr>
					<tr><td class="title_h"></td>
						<td class="title_s">CKY SVC Including Slot Charter Only</td></tr>
					</table>
					
					<!-- Grid - 2 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t1sheet2');</script>
						</td>
					</tr>
				</table>					
					<!-- Grid - 2 (E) -->		
								
				</td></tr>
				
				
			<tr><td valign="top" colspan="2" height="8"></td></tr>
			<tr><td valign="top">	
					
					<table class="search" border="0">
					<tr><td class="height_10"></td></tr>
					<tr><td class="title_h"></td>
						<td class="title_s">Other Alliance SVC</td></tr>
					</table>
					
					<!-- Grid - 3 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t1sheet3');</script>
						</td>
					</tr>
				</table>					
					<!-- Grid - 3 (E) -->	
								
				</td>
				
				
				<td valign="top" style="padding-left:10px;">	
					
					<table class="search" border="0">
					<tr><td class="height_10"></td></tr>
					<tr><td class="title_h"></td>
						<td class="title_s">Intra Asia SVC (Including Alliance)</td></tr>
					</table>
					
					<!-- Grid - 4 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t1sheet4');</script>
						</td>
					</tr>
				</table>					
					<!-- Grid - 4 (E) -->	
					
				</td></tr>
			</table>
			<!-- grid box (E) -->
			
			
		</td></tr>
		</table>			
		<!-- 2 (E) -->
		
		<!--biz page (E)-->

		
			
</div>
<!--TAB  (E) -->			

<!--TAB  (S) -->
<div id="tabLayer" style="display:inline">

		<!-- 2 (S) -->
		<table class="search" id="mainTable"> 
       	<tr><td class="bg" style="height:438" valign="top">	
				
			<!-- grid box (S) -->
			<table class="search">
			<tr><td valign="top" width="30%">	
					
					<!-- Table - 1 (S) -->
					<table width="100%" class="grid2"> 
					<tr><td align="center" width="15%">M :</td>
						<td>Main Service Including SML Operation</td></tr>
					<tr><td align="center">C :</td>
						<td>CKY Service Including Slot Charter Only</td></tr>
					<tr><td align="center">O :</td>
						<td>Other Alliance Service</td></tr>
					<tr><td align="center">I :</td>
						<td>Intra Asia Service Including Alliance</td></tr>
					</table> 
					<!-- Table - 1 (E) -->	

											
				</td>
				<td valign="top" width="35%" style="padding-left:10px;">	

					<!-- Grid - 1 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t2sheet1');</script>
						</td>
					</tr>
				</table>					
					<!-- Grid - 1 (E) -->		
								
				</td>
				
				<td valign="top" width="35%" style="padding-left:10px;">	

					<!-- Grid - 2 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t2sheet2');</script>
						</td>
					</tr>
				</table>					
					<!-- Grid - 2 (E) -->		
								
				</td></tr>
				
			<tr><td valign="top" colspan="3">	
					
					<table class="height_8"><tr><td></td></tr></table>
					<table class="search" border="0">
					<tr><td class="height_10"></td></tr>
					<tr><td class="title_h"></td>
						<td class="title_s">SML Vessel SVC - Service Including SML Vessel</td></tr>
					</table>
					
					<!-- Grid - 3 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t2sheet3');</script>
						</td>
					</tr>
				</table>					
					<!-- Grid - 3 (E) -->	
								
				</td></tr>
			</table>
			<!-- grid box (E) -->
			
			
		</td></tr>
		</table>			
		<!-- 2 (E) -->
		
		<!--biz page (E)-->
</div>
<!--TAB  (E) -->

<!--TAB  (S) -->
<div id="tabLayer" style="display:none">

		<table class="search" id="mainTable"> 
       		<tr><td class="bg" style="height:438" valign="top">		
			
			<!-- Title - 1 -->
			<table class="search" border="0">
			<tr><td class="height_10"></td></tr>
			<tr><td class="title_h"></td>
				<td class="title_s">SML Operator</td></tr>
			</table>
			<!-- Title - 1 -->
					
			<!-- Grid - 1 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t3sheet1');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid - 1 (E) -->			
			
			
			<!-- Title - 2 -->
			<table class="search" border="0">
			<tr><td class="height_10"></td></tr>
			<tr><td class="title_h"></td>
				<td class="title_s">Alliance Operator</td></tr>
			</table>
			<!-- Title - 2 -->
					
			<!-- Grid - 2 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t3sheet2');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid - 2 (E) -->			
			
			
			<!-- Title - 3 -->
			<table class="search" border="0">
			<tr><td class="height_10"></td></tr>
			<tr><td class="title_h"></td>
				<td class="title_s">Special Cargo Authorization Part or AUTO TLX</td></tr>
		
			</table>
			<!-- Title - 3 -->
					
			<!-- Grid - 3 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t3sheet3');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid - 3 (E) -->				
			
			<!-- Grid - 4 (S) -->
				<table width="100%"  id="mainTable" style="display:none;"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t3sheet4');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid - 4 (E) -->				
			
			</td></tr>
		</table>
		<!--biz page (E)-->

	
</div>
<!--TAB  (E) --> 



<!--TAB  (S) -->
<div id="tabLayer" style="display:none">

		<table class="search" id="mainTable"> 
       		<tr><td class="bg" style="height:438" valign="top">	
			
			
			<!-- Grid  (S) --> 
				<table width="100%"  id="mainTable" height="20">  
					<tr>
						<td width="100%" align="right" valign="bottom">Unit of Measure(%)</td>
					</tr>
				</table>			
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t4sheet1');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->			
			
			</td></tr>
		</table>
		<!--biz page (E)-->

			    	
			

</div>
<!--TAB  (E) -->
			
			
			
			
				
	</td></tr>
		</table>
	

	<!-- Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="divExcell">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table></td>
				
			</tr>
			</table>
			<!-- Button (E) -->
<div id="divSheet1" style="display:none;"><script language="javascript">ComSheetObject('sheet1');</script></div>
<div id="divSheet2" style="display:none;"><script language="javascript">ComSheetObject('sheet2');</script></div>
<!--  -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>