<%/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EES_EQR_1052.jsp
*@FileTitle : BKG Split
*Open Issues :
*Change history : 1. 2014-03-07, CHM-201429123, ROB booking 기능 추가, YongChan Shin
*@LastModifyDate : 2013.08.22
*@LastModifier : 신용찬
*@LastVersion : 1.0
* 2013.08.22 신용찬
* 1.0 Creation 
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.event.EesEqr1052Event"%>
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1052ConditionVO" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr1052Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CntrMtyBkgManage.CntrMtyBkgCreate");
	
	String flag         = "";
	String open_flag_rob= "";  // rob 체크 여부
	String bkg_no		= "";
	String bkg_vvd		= "";
	String bkg_pol		= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesEqr1052Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 1018에서 대상row 를 선택하지 않으면 데이터 없을수 있음.
		flag    	 = JSPUtil.getParameter(request, "flag");	// S : Single BKG SPLIT, M : Multi BKG Split	
		
		open_flag_rob= JSPUtil.getParameter(request, "flag_rob");// 1 : ROB, 0 : NON ROB
		if(open_flag_rob.equals("1")) open_flag_rob = "Y"; 
		else						  open_flag_rob = "N";	
		
		bkg_vvd 	 = JSPUtil.getParameter(request, "vvd");
		bkg_no  	 = JSPUtil.getParameter(request, "bkg_no");
		bkg_pol 	 = JSPUtil.getParameter(request, "pol_cd");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Booking Split for Repositioning Empty Container</title>
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
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="flag" value="<%= flag %>" >  					<!-- multi split, single split 구분 -->
<input type="hidden" name="open_flag_rob" value="<%= open_flag_rob %>" >    <!-- rob 여부를 구분(중요) -->
<input type="hidden" name="splitresult" >
<input type="hidden" name="pod_clpt_ind_seq" >
<input type="hidden" name="iPage">

	<!-- OUTER - POPUP (S)tart -->
	<table width="1060" class="popup" cellpadding="10">
		<tr><td class="top"></td></tr>
		<tr><td valign="top">
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Booking Split for Repositioning Empty Containers</td></tr>
			</table>
			<!-- : ( Title ) (E) -->			

			<!-- TABLE '#D' : ( Button : Main ) (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
									<td class="btn1_right"></td>
								</tr></table></td>				
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_new" id="btn_new">New</td>
									<td class="btn1_right"></td>
								</tr></table></td>
							<td class="btn1_line"></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_downexcel" id="btn_downexcel">Down&nbsp;Excel</td>
									<td class="btn1_right"></td>
								</tr></table></td>
							<td class="btn1_line"></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_print" id="btn_print">Print</td>
									<td class="btn1_right"></td></tr></table></td>
						</tr></table>
					</td></tr>
			</table>
			<!-- TABLE '#D' : ( Button : Main ) (E) -->
			
			<!-- TABLE '#D' : ( Search Options ) (S) -->
			<table class="search">
				<tr>
					<td class="bg">
	
					<!-- : ( Scenario ID ) (S) -->
					<table class="search" border="0" style="width:737;">
					<tr class="h23">
					<% if(flag.equals("S")) { %>
						<td width="4%">VVD</td>
						<td width="14%"><input type="text" style="width:80" name="vvd" value="<%= bkg_vvd %>" class="input2" readOnly></td>
						<td width="7%">BKG No.</td>
						<td width="14%"><input type="text" style="width:90" name="bkg_no" value="<%= bkg_no %>" class="input2" readOnly></td>
                        <td width="8%">&nbsp;</td>
                        <td width="4%">ROB</td>
                        <td width="4%"><input type="checkbox" name="flag_rob" value="" class="trans" onClick="javascript:changeROB();" ></td>
                        <td width="18%"><script language="javascript">ComComboObject('vvd_rob', 1, 100, 1, 0)</script></td>
                        
						<td >&nbsp;</td>
					<% } else { %>							
						<td width="4%">VVD</td>
						<td width="14%"><input type="text" style="width:75" name="vvd" class="input1"  maxlength="9"  onChange="javascript:changeVVD();" ></td>
						<td width="7%">BKG No.</td>
						<td width="18%"><script language="javascript">ComComboObject('bkg_no', 1, 120, 1, 0)</script></td>
						<td >&nbsp;</td>
		
					<% }        %>	
					</tr>
					</table>
					<!-- : ( Scenario ID ) (E) -->
	
				</td></tr>
			</table>
			<!-- TABLE '#D' : ( Search Options ) (E) -->

			<table class="height_10"><tr><td></td></tr></table>

			<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
			<table class="search" border="0">
				<tr><td class="bg">	
						<table width="100%" class="search">
							<tr>
								<td class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">Master Data</td>
								<td class="gray_tit" width=285>&nbsp;</td>
								<td class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">Split BKG Creation</td>
							</tr>
						</table>
	
						<table class="search" border="0" width="100%">
							<tr>
							<td width="350" valign="top">
									<!--grid (S)-->
								<table width="560" id="mainTable">
	                        		<tr><td>
	                             		<script language="javascript">ComSheetObject('sheet1');</script>
	                        		</td></tr>
			            		</table>
									<!--grid (E)-->
								</td>
								<td width="37">
									<table class="search">
										<tr><td align="center"><img src="/hanjin/img/button/btns_add.gif" width="26" height="26" alt="" border="0" name="btns_add"><br><br><img src="/hanjin/img/button/btns_del.gif" width="26" height="26" alt="" border="0" name="btns_del"></td></tr>
									</table>
	
								</td>
								<td width="*" valign="top">
									<!--grid (S)-->
								<table width="430" id="mainTable">
	                        		<tr><td>
	                             		<script language="javascript">ComSheetObject('sheet2');</script>
	                        		</td></tr>
			            		</table>
									<!--grid (E)-->
							</td>
							</tr>
						</table>
						
						<!-- : ( Button : Sub ) (S) -->
						<table width="100%" class="button">
					       	<tr><td class="btn_bg">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr>
	
								<!-- Repeat Pattern -->
								<td width=158>&nbsp;</td>	
								
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn2_left" ></td>
									<td class="btn2" name="btng_formatexceldown" id="btng_formatexceldown">Format&nbsp;Excel&nbsp;Down</td>
									<td class="btn2_right"></td>
								</tr>
								</table>
								</td>	
								
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn2_left" ></td>
									<td class="btn2" name="btng_loadexcel" id="btng_loadexcel">Load&nbsp;Excel</td>
									<td class="btn2_right"></td>
								</tr>
								</table>
								</td>	
								
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn2_left" ></td>
									<td class="btn2" name="btng_rowadd" id="btng_rowadd">Row&nbsp;Add</td>
									<td class="btn2_right"></td>
								</tr>
								</table>
								</td>
								
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn2_left" ></td>
									<td class="btn2" name="btng_rowdel" id="btng_rowdel">Row&nbsp;Delete</td>
									<td class="btn2_right"></td>
								</tr>
								</table>
								</td>								
										
								<td width=30>&nbsp;</td>
										
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr class="h23">
									<td>POD</td>
									<td width=5>&nbsp;</td>
									<td width="90">
                        				<script language="javascript">ComComboObject('pod_yd_cd', 2, 90, 1, 1 )</script>
                    				</td> 
									<td width="130"><input type="text" style="width:130" name="to_etb_dt" class="input2" readOnly></td>                     				
									<td></td>
								</tr>
								</table>
								</td>

								<td width=30>&nbsp;</td>
																															
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn2_left" ></td>
									<td class="btn2" name="btng_splitbkgcre" id="btng_splitbkgcre">Split&nbsp;BKG&nbsp;Cre.</td>
									<td class="btn2_right"></td>
								</tr>
								</table>
								</td>
								<!-- Repeat Pattern -->
	
							</tr></table>
						</td></tr>
						</table>
						
		    			<!-- : ( Button : Sub ) (E) -->
				</td></tr>
			</table>
			<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		</td></tr>
	</table>
	<!-- OUTER - POPUP (E)nd -->
	<table class="height_10"><tr><td></td></tr></table>

	<!-- : ( Button : Sub ) (S) -->
	<table width="100%" class="sbutton">
		<tr><td height="71" class="popup">
				<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	       			<tr><td class="btn3_bg">
			    		<table border="0" cellpadding="0" cellspacing="0">
			    			<tr>		
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn1_left"></td>
										<td class="btn1" name="btn_close" id="btn_close" onClick="javascript:closeWindow();">Close</td>
										<td class="btn1_right"></td>
									</tr>
									</table>
								</td>
							</tr>
						</table>
						</td></tr>
				</table>
			</td></tr>
	</table>
<!-- : ( Button : Sub ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>