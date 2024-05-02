<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_SCG_0021.jsp
*@FileTitle : Restrictions
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.07.17 김현욱
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg0021Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0021Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CargoLoadingApproval.OwnDangerousCargoApproval");
	
	String imdg_un_no     = "";
	String imdg_un_no_seq = "";
	String imdg_clss_cd   = "";
	String pol_port_cd    = "";
	String pod_port_cd    = "";
	String slan_cd        = "";
	
	String bkg_no        = "";
	String vsl_cd        = "";
	String skd_voy_no    = "";
	String skd_dir_cd    = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg0021Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		imdg_un_no     = StringUtil.xssFilter(request.getParameter("imdg_un_no"))==null?"":StringUtil.xssFilter(request.getParameter("imdg_un_no"));
		imdg_un_no_seq = StringUtil.xssFilter(request.getParameter("imdg_un_no_seq"))==null?"":StringUtil.xssFilter(request.getParameter("imdg_un_no_seq"));
		imdg_clss_cd   = StringUtil.xssFilter(request.getParameter("imdg_clss_cd"))==null?"":StringUtil.xssFilter(request.getParameter("imdg_clss_cd"));
		pol_port_cd    = StringUtil.xssFilter(request.getParameter("pol_cd"))==null?"":StringUtil.xssFilter(request.getParameter("pol_cd"));
		pod_port_cd    = StringUtil.xssFilter(request.getParameter("pod_cd"))==null?"":StringUtil.xssFilter(request.getParameter("pod_cd"));
		slan_cd        = StringUtil.xssFilter(request.getParameter("slan_cd"))==null?"":StringUtil.xssFilter(request.getParameter("slan_cd"));
		
		//bkg_no         = StringUtil.xssFilter(request.getParameter("bkg_ref_no"))==null?(StringUtil.xssFilter(request.getParameter("bkg_no"))==null?"":StringUtil.xssFilter(request.getParameter("bkg_no"))):StringUtil.xssFilter(request.getParameter("bkg_ref_no"));
		if(!"".equals(StringUtil.xssFilter(request.getParameter("bkg_ref_no"))) && StringUtil.xssFilter(request.getParameter("bkg_ref_no"))!=null){
			bkg_no = StringUtil.xssFilter(request.getParameter("bkg_ref_no"));
		}else{
			if(!"".equals(StringUtil.xssFilter(request.getParameter("bkg_no"))) && StringUtil.xssFilter(request.getParameter("bkg_no"))!=null){
				bkg_no = StringUtil.xssFilter(request.getParameter("bkg_no"));
			}else{
				bkg_no = "";
			}
		}
		
		vsl_cd         = StringUtil.xssFilter(request.getParameter("vsl_cd"))==null?"":StringUtil.xssFilter(request.getParameter("vsl_cd"));
		skd_voy_no     = StringUtil.xssFilter(request.getParameter("skd_voy_no"))==null?"":StringUtil.xssFilter(request.getParameter("skd_voy_no"));
		skd_dir_cd     = StringUtil.xssFilter(request.getParameter("skd_dir_cd"))==null?"":StringUtil.xssFilter(request.getParameter("skd_dir_cd"));

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Restrictions</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	//초기조회조건
	var preConds = {
		imdg_un_no         : "<%=imdg_un_no%>",
		imdg_un_no_seq     : "<%=imdg_un_no_seq%>",
		imdg_clss_cd       : "<%=imdg_clss_cd%>",
		pol_port_cd        : "<%=pol_port_cd%>",
		pod_port_cd        : "<%=pod_port_cd%>",
		slan_cd            : "<%=slan_cd%>",
		bkg_no             : "<%=bkg_no%>",
		vsl_cd             : "<%=vsl_cd%>",
		skd_voy_no         : "<%=skd_voy_no%>",
		skd_dir_cd         : "<%=skd_dir_cd%>"
	}

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
<input type="hidden" name="pagerows">

<input type="hidden" name="bkg_no">
<input type="hidden" name="vsl_cd">
<input type="hidden" name="skd_voy_no">
<input type="hidden" name="skd_dir_cd">

<input type="hidden" name="pol_port_cd">
<input type="hidden" name="pod_port_cd">
<input type="hidden" name="slan_cd">
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">
	
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Restrictions </td></tr>
			</table>
			<!-- : ( Title ) (E) -->		
		
			<!--biz page (S)-->
			<!-- 1 (S) -->
			<table class="search"> 
        		<tr>
        			<td class="bg">
		                <!--  biz_1  (S) -->
		                <table class="search" border="0" style="width:979;"> 
			                <tr class="h23">
			                    <td width="80">UN No./Seq.</td>
			                    <td width="">&nbsp;<input type="text" style="width:60;" name='imdg_un_no' fullfill required class="input1" maxlength='4' style="ime-mode:disabled"   caption='UN No.'  value="" >&nbsp;<input type="text" style="width:19;"  name='imdg_un_no_seq' class="input1" caption='UN No./Seq.' maxlength='2' minlength='1' required value="">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" name='srch_imdg_un_no' align="absmiddle">&nbsp;<input type="text" style="width:780;" readonly class="input2" name='prp_shp_nm' value=""></td>
			                </tr>
			                <tr class="h23">
			                    <td>Class</td>
			                    <td width="">&nbsp;<input type="text" style="width:60;" class="input2"  readonly name='imdg_clss_cd' value="">&nbsp;<input type="text" style="width:826;" class="input2"  name='imdg_clss_cd_desc'  readonly value=""></td>
			                </tr>
		                </table>
		                <!--  biz_1   (E) -->
		        	</td>
		    	</tr>
            </table>	
			<!-- 1 (E) -->
		
			<!-- 2 (S) -->		
			<table class="height_8"><tr><td></td></tr></table>	
			<table class="search" id="mainTable"> 
       			<tr>
       				<td class="bg">		
			
						<!--  biz_2  (S) -->
				
						<table class="search" border="0">
							<tr>
								<td class="title_h"></td>
								<td class="title_s">Vessel Operator’s Restrictions on UN No.</td>
							</tr>
							<tr><td class="height_5"></td></tr>
						</table>
						
						<!-- Grid  (S) -->
		                <table width="100%"  id="mainTable">
		                    <tr>
		                        <td width="100%">
		                            <script language="javascript">ComSheetObject('sheet1');</script>
		                        </td>
		                    </tr>
		                </table>
		            	<!-- Grid (E) -->

						<!--  biz_4  (S) -->				
						<table height="15"><tr><td></td></tr></table>
						<table class="search" border="0">
							<tr>
								<td class="title_h" valign="middle"></td>
								<td style="padding-left:4;">
									<!--  Button_Sub (S) -->
									<table width="150" class="middle"> 
								       	<tr>
								       		<td class="btn2_bg">
												<table border="0" cellpadding="0" cellspacing="0">
													<tr>
														<td>
															<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr>
																	<td class="btn2_left"></td>
																	<td class="btn2" name="srch_irregulars_list" id="srch_irregulars_list">Irregulars List</td>
																	<td class="btn2_right"></td>
																</tr>
															</table>
														</td>																		
													</tr>
												</table>
											</td>
										</tr>
									</table>
							    	<!-- Button_Sub (E) -->
							    </td>
							</tr>
							<tr><td class="height_5"></td></tr>
						</table>
						<!--  biz_4  (E) -->	
	
						<!--  biz_5  (S) -->				
						<table height="10"><tr><td></td></tr></table>
						<table class="search" border="0">
							<tr><td class="title_h"></td>
								<td class="title_s">Port Restrictions En-route</td></tr>
							<tr><td class="height_5"></td></tr>
						</table>
				
						<!-- Grid - 1 (S) -->
						<table width="100%" class="search"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table> 
						<!-- Grid - 1 (E) -->					
						<!--  biz_5  (E) -->	
					
					</td>
				</tr>
			</table>
			<!-- 2 (E) -->
		
			<!--biz page (E)-->
			
<table class="height_8"><tr><td></td></tr></table>	
		</td>
	</tr>
</table>
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
	
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
	       		<tr>
	       			<td class="btn3_bg">
					    <table border="0" cellpadding="0" cellspacing="0">
						    <tr>
						    <td>
	                			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                    				<tr>
	                    					<td class="btn1_left"></td>
	                    					<td class="btn1" name="btn_Retrieve"  id="btn_Retrieve">Retrieve</td>
	                    					<td class="btn1_right"></td>
	                    				</tr>
	                				</table>
	                			</td>
	                			<td>
	                				<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
	                    				<tr>
	                    					<td class="btn1_left"></td>
	                    					<td class="btn1" name="btn_New"  id="btn_New">New</td>
	                    					<td class="btn1_right"></td>
	                    				</tr>
	                				</table>
	                			</td>
	                			<td class="btn1_line"></td>
								<td width="72">
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Close">Close</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
	    				<!--Button (E) -->
		
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>