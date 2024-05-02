<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_PSO_0036.jsp
*@FileTitle : Port Tariff Condition
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.14
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.07.28 김진일
* 1.0 Creation
*  
* History
* 2011.03.14 진마리아 CHM-201109292-01 Location 조회불가건 수정 보완 요청
* 2011.07.28 김기종 CHM-201112475-01 [VOP_PSO] Port Tariff Inquiry 메뉴 수정 요청건
* 2013.11.18 S.K.Y CHM-201327648 Surcharge, dicount  포함 account code 붉은색으로 표시
* 2014.07.16 이성훈   CHM-201430928    Port Tariff Contract 및 URL 저장
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0036Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
	VopPso0036Event  event = null;					
	Exception serverException   = null;			
	String strErrMsg = "";						
	int rowCount	 = 0;						
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String param_yard		= "";
	String param_acct_cd	= "";
	String param_port_cd	= "";
	String param_terminal_cd= "";
	
	String pop_port_cd = JSPUtil.getParameter(request, "port_cd"   , "");
	String pop_btn_port_cd = JSPUtil.getParameter(request, "btn_port_cd", "");
	String popup_flg        = (request.getParameter("port_cd") == null)? "N" : "Y";
	
	//Logger log = Logger.getLogger("com.hanjin.apps.PortSOMasterDataMgt.PortTariffMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		param_yard      	= StringUtil.xssFilter(request.getParameter("yard"))== null?"":StringUtil.xssFilter(request.getParameter("yard"));
		param_acct_cd      	= StringUtil.xssFilter(request.getParameter("acct_cd"))== null?"":StringUtil.xssFilter(request.getParameter("acct_cd"));
		if(!"".equals(param_yard) && param_yard != null){
			param_port_cd = param_yard.substring(0,5);
			param_terminal_cd = param_yard.substring(5,param_yard.length());
		}

		event = (VopPso0036Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Port Tariff</title>
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
<input type="hidden" name="yd_cd" value="" />
<input type="hidden" name="vndr_seq" value="" />
<input type="hidden" name="lgs_cost_cd" value="" />
<input type="hidden" name="eff_dt" value="" />
<input type="hidden" name="combo1" value="" /><!-- terminal code  -->
<input type="hidden" name="combo3" value="" /><!-- lgs_cost_cd -->
<input type="hidden" name="combo5" value="" /><!-- yd_ver_seq -->
<input type="hidden" name="from_date" value="" />
<input type="hidden" name="to_date" value="" />
<input type="hidden" name="yd_chg_no" value="" />
<input type="hidden" name="popup_flg"   value="<%=popup_flg%>">
<input type="hidden" name="pop_port_cd"   value="<%=pop_port_cd%>">
<input type="hidden" name="pop_btn_port_cd" value="<%=pop_btn_port_cd%>">
<input type="hidden" name="param_acct_cd" value="<%=param_acct_cd%>">
<input type="hidden" name="param_terminal_cd" value="<%=param_terminal_cd%>">
<!-- input type="hidden" name="sXml" value="" /-->
<input type="hidden" name="desc" value="" />


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
	    <% if(popup_flg.equals("Y")){ %>	
	    <% }else{ %>
	    		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	    <% } %>		
	</table>
	<!--Page Title, Historical (E)-->
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
	       	<tr>
	       		<td class="btn1_bg">
				    <table border="0" cellpadding="0" cellspacing="0">
					    <tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" id="btn_Retrieve" name="btn_Retrieve">Retrieve</td>
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
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn1_Tariff_Update">Tariff Update</td>
								<td class="btn1_right"></td>
								</tr>
							</table></td>
						</tr>
					</table>
				</td>			
			</tr>
		</table>

		
		<table class="search"> 
       		<tr>
       			<td class="bg">
				
					<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="30">Port</td>
						<td width="195" id="xxx"><input name="port_cd" type="text" dataformat="uppernum" style="width:50;text-align:left;" class="input" value="<%=param_port_cd%>" size="5" maxlength="5"/>&nbsp;<img class="cursor" name="btn_port_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;<script language="javascript">ComComboObject('comboTerminalCd',2,60,0);</script></td>
						<td>Year&nbsp;<input name="year" dataformat="y" maxlength="4" type="text" style="width:45;text-align:center;" class="input1" value=""></td>
						
						<td width="80">Account CD</td>
						<td width="" style="padding-left: 2"><script language="javascript">ComComboObject('acct_cd',3, 96, 0, 0);</script>&nbsp;<input type="text" name="acct_nm" style="width: 300; text-align: left" class="input2" value="" readonly></td>
					</tr>
					</table>
					<!--  biz_1   (E) -->
					<table class="line_bluedot"><tr><td></td></tr></table>
	
					<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="300" valign="top">
						<!-- Grid  (S) -->
						<table width="100%" id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- Grid  (E) -->	
						
						</td>
						<td width="19">&nbsp;</td>
						<td width="" valign="top" height="740">
							<table class="search" border="0">
								<tr class="h23">
									<td width="263" align="left">Contract/Regulation&nbsp;<input name="contract" value="" type="text" style="width:127" class="input2" readonly>&nbsp;</td>
									<td width="19" align="left"><img class="cursor" name="btn_cntr_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
									<td width="15">&nbsp;</td>
								  	<td width="" align="left">URL&nbsp;<input name="port_trf_url" value="" type="text" style="width:105" class="input2" readonly>&nbsp;<img class="cursor" name="btn_url" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
									<td width="" align="left">Remark&nbsp;<input name="port_trf_rmk" value="" type="text" style="width:130" class="input2" readonly>&nbsp;<img class="cursor" name="btn_port_trf_rmk" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
								</tr> 
							</table>						
							<table class="search" border="0">
								<tr class="h23">
									<td width="265" align="left" id="yyy">Effective Date&nbsp;&nbsp;<script language="javascript">ComComboObject('comboLgsCostCd',1,170,1,3);</script></td>
									<td width="22">&nbsp;</td>
								  	<td width="" align="left" id="zzz">Ver.&nbsp;<script language="javascript">ComComboObject('comboVer',1,60,1,3);</script></td>
									<td width="" align="left">Updated By&nbsp;<input type="text" name="updated_by" style="width:70;text-align:center;" value="" class="input2" readonly>&nbsp;<input type="text" name="updated_date" style="width:134;text-align:center;" value="" class="input2" readonly></td>
								</tr> 
							</table>
							<table style="height:12"><tr><td></td></tr></table>
						
							<table class="search" border="0">
								<tr>
									<td class="title_h"></td>
									<td class="title_s">Base</td>
									<td align="right"><strong>Compulsory</strong>&nbsp;&nbsp;<input type="checkbox" name="cpls_flg" value="" class="trans" disabled></td>
								</tr>
							</table>
					
							<!-- DIV : VOP_PSO_0211.do -->
							<div id="myDiv0211" style="display:inline;" width="100%" height="700">
								<table width="100%" id="mainTable">
									<tr>
										<td width="100%"><script language="javascript">ComSheetObject('sheet2');</script></td>
									</tr>
								</table>
				
								<table class="line_bluedot">
									<tr>
										<td></td>
									</tr>
								</table>
					
								<table class="search" border="0">
									<tr>
										<td class="title_h"></td>
										<td class="title_s">Surcharge</td>
									</tr>
								</table>
								
								<table width="100%" id="mainTable">
									<tr>
										<td width="100%"><script language="javascript">ComSheetObject('sheet3');</script></td>
									</tr>
								</table>
				
								<table class="line_bluedot">
									<tr>
										<td></td>
									</tr>
								</table>
					
								<table class="search" border="0">
									<tr>
										<td class="title_h"></td>
										<td class="title_s">Discount</td>
									</tr>
								</table>
								
								<table width="100%" id="mainTable">
									<tr>
										<td width="100%"><script language="javascript">ComSheetObject('sheet4');</script></td>
									</tr>
								</table>
							</div>
							
							<!-- DIV : VOP_PSO_0212.do -->
							<div id="myDiv0212" style="display:none;" width="100%" height="700">
							
								<table class="search" border="0" width="100%">
									<tr class="h23">
										<td width="350" valign="top">
											<table class="search_sm" border="0" width="100%" height="91%">
												<tr class="h23">
													<td valign="top">
														<table width="100%" id="mainTable">
															<tr>
																<td width="100%"><script language="javascript">ComSheetObject('sheet5');</script>
																</td>
															</tr>
														</table>
														
														<table class="height_10">
															<tr>
																<td></td>
															</tr>
														</table>
														<table width="100%" class="" border="0" cellpadding="2" cellspacing="1">
															<tr class="history">
																<td>&nbsp;&nbsp;*Formula</td>
															</tr>
															<tr height="110">
																<td>
																	<div id="foml_desc" style="width:100%;height:100%;border:solid 1;overflow-y:auto;overflow-x:hidden;padding:2px;border-color:#5B8A9E;background-color:#FFFFFF"></div>
																</td>
															</tr>
															<tr class="history">
																<td>&nbsp;&nbsp;*Condition</td>
															</tr>
															<tr height="70">
																<td>
																	<div id="cond_desc" style="width:100%;height:100%;border:solid 1;overflow-y:auto;overflow-x:hidden;padding:2px;border-color:#5B8A9E;background-color:#FFFFFF"></div>
																</td>
															</tr>
														</table>
					
													</td>
												</tr>
											</table>
										</td>
										<td width="19">&nbsp;</td>
										<td width="" valign="top">
											<table width="100%" id="mainTable">
												<tr>
													<td width="100%"><script language="javascript">ComSheetObject('sheet6');</script></td>
												</tr>
											</table>
					
											<table class="height_10">
												<tr>
													<td></td>
												</tr>
											</table>
					
											<table width="100%" id="mainTable">
												<tr>
													<td width="100%"><script language="javascript">ComSheetObject('sheet7');</script></td>
												</tr>
											</table>
											
											<table width="380" class="button">
												<tr>
													<td class="btn2_bg"></td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
				
								<table class="line_bluedot">
									<tr>
										<td></td>
									</tr>
								</table>
				
								<!-- Surcharge -->
								<table class="search" border="0">
									<tr>
										<td class="title_h"></td>
										<td width="" class="title_s">Surcharge</td>
									</tr>
								</table>
								<table width="100%" id="mainTable">
									<tr>
										<td width="100%"><script language="javascript">ComSheetObject('sheet8');</script></td>
									</tr>
								</table>
				
								<table class="line_bluedot">
									<tr>
										<td></td>
									</tr>
								</table>
				
								<!-- Discount -->
								<table class="search" border="0">
									<tr>
										<td class="title_h"></td>
										<td width="" class="title_s">Discount</td>
									</tr>
								</table>
								<table width="100%" id="mainTable">
									<tr>
										<td width="100%"><script language="javascript">ComSheetObject('sheet9');</script></td>
									</tr>
								</table>
				
								<div id="div_base_dummy" style="display:none">
									<table class="line_bluedot">
										<tr>
											<td></td>
										</tr>
									</table>
									<table class="search" border="0">
										<tr>
											<td class="title_h"></td>
											<td width="" class="title_s">Base Dummy</td>
					
										</tr>
									</table>
									<table width="100%" id="mainTable">
										<tr>
											<td width="100%"><script language="javascript">ComSheetObject('sheet10');</script></td>
										</tr>
									</table>
								</div>
							
							</div>
						</td>
					</tr>
					</table>
	
					
				</td>
			</tr>
		</table>
	
	
	<!--biz page (E)-->
	
<table class="height_8"><tr><td></td></tr></table>


	</td></tr>
</table>
</form>
</body>
</html>