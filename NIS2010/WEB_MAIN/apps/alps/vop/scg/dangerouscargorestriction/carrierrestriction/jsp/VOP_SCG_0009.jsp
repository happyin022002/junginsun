<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0009.jsp
*@FileTitle : VSL OPR's Restriction on DG (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.09 장강철 jkc
* 1.0 Creation
* History
* 2012.04.20 서석진 [CHM-201216960-01] Vessl Operator내 파일첨부 기능 추가
* 처리내역 :첨부파일추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.event.VopScg0009Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0009Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DangerousCargoRestriction.CarrierRestriction");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg0009Event)request.getAttribute("Event");
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
<title>VSL OPR's Restriction on DG (Creation)</title>
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
<form name="form"  >
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
 

<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr>
		<td valign="top">
			<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!--Page Title, Historical (E)-->

			<!--biz page (S)-->
			<table class="search"> 
    		   	<tr>
    		   		<td class="bg">
						<!--  biz_1  (S) -->
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="100">Vessel Operator</td>
								<td width="400">&nbsp;<input type="text" style="width:60;" name='crr_cd'  dataformat='engup' style="ime-mode:disabled" caption='Vessel Operator' required  maxlength=4 minlength=3  class="input1" value="">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" name='srch_crr_cd' id='srch_crr_cd' align="absmiddle">&nbsp;<input type="text" style="width:250;" name='crr_nm' readonly class="input2" value=""></td>
								<td width="250">
									<table style="background-color: #E9E9E9;" border="0" style="width:220;" >
										<tr class="h23">
											<td width="70">&nbsp;&nbsp;Option</td>
											<td class="stm"><input type="radio" value='class' name='optclass' class="trans" checked>Class&nbsp;&nbsp;<input type="radio"  name='optclass'  value='unno' class="trans">UN No.</td>
										</tr>
									</table>
								</td>
								<td width="100">Attach File</td>
								<td width="279">
								   <input name="file_name"  type="text" style="width:150;" class="input2" value="" readonly >
								   <img name="btn_filePop" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  >
								</td>
							</tr>
							<tr><td style="height:1"></td></tr>
							<tr class="h23">
								<td width="">Class</td>
								<td width="" colspan="4" >&nbsp;
									<script language="javascript">ComComboObject('imdg_clss_cd', 2, 60, 0);</script>&nbsp;<input type="text" style="width:800;" class="input2" readonly  name='imdg_clss_cd_desc' >
								</td>
							</tr>
							<tr class="h23">
								<td>UN No./Seq.</td>
								<td colspan="4" style="padding-left:2"><input type="text" style="width:60;" name='imdg_un_no'  class="input" dataformat='eng' style="ime-mode:disabled" caption='UN No.'    fullfill   maxlength=4  value="">&nbsp;<input type="text" style="width:30;" class="input" name='imdg_un_no_seq' value="" style="ime-mode:disabled"  maxlength="2">&nbsp;<img class="cursor" src="img/btns_search.gif" name='srch_imdg_un_no' width="19" height="20" border="0" align="absmiddle">&nbsp;<input type="text" style="width:743;" class="input2" name='prp_shp_nm' value="" readonly></td>					
							</tr>
						</table>
						<!--  biz_1   (E) -->
					</td>
				</tr>
			</table>
			<table class="height_8"><tr><td></td></tr></table>
		
			<!-- Grid BG Box  (S) -->
			<table class="search" id="mainTable">
	       		<tr>
	       			<td class="bg" style="height:415;" valign="top">	
	   				<!--  biz_2  (S) -->
		       		<div id='div_s1' >
						<table class="search" border="0">
							<tr>
								<td class="title_h"></td>
								<td class="title_s">Restrictions on Class</td>
							</tr>
						</table>
						<!-- Grid  (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->
						<!--Button (S) -->
						<table width="100%" class="button" border="0"> 
			       			<tr>
			       				<td class="btn2_bg">
								    <table border="0" cellpadding="0" cellspacing="0">
									    <tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2_1"  name="btn_add" id="btn_add" optclass='class'>Row Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2_1"  name="btn_insert" id="btn_insert" optclass='class'>Row Insert</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2_1" name="btn_copy" id="btn_copy"  optclass='class'>Row Copy</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2_1" name="btn_row_delete" id="btn_row_delete" optclass='class'>Row Delete</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						<!--Button (E) -->
						<table class="height_8"><tr><td></td></tr></table>
						<table class="search" border="0">
							<tr>
								<td><textarea style="height:70;width:980"  name='crr_regu_desc_class'></textarea></td>
							</tr>
						</table>
       			    </div>
				    <div id='div_s2' style='display:none'>
						<table class="search" border="0">
							<tr>
								<td class="title_h"></td>
								<td class="title_s">Restrictions on UN No.</td>
							</tr>
						</table>
						<!-- Grid  (S) -->
						<table width="100%" class="search" id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table>
						<table width="100%" class="button" border="0"> 
			       			<tr>
			       				<td class="btn2_bg">
								    <table border="0" cellpadding="0" cellspacing="0">
									    <tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2_1" name="btn_add2" id="btn_add2" optclass='unno'>Row Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2_1"  name="btn_insert2" id="btn_insert2"  optclass='unno' >Row Insert</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2_1"  name="btn_copy2" id="btn_copy2"  optclass='unno' >Row Copy</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2_1"   name="btn_row_delete2" id="btn_row_delete2"   optclass='unno' >Row Delete</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
			    		<!--Button (E) -->
				    	<table class="height_8"><tr><td></td></tr></table>
				    	<table class="search" border="0">
							<tr>
								<td><textarea  style="height:70;width:980"  name='crr_regu_desc_unno'></textarea></td>
							</tr>
						</table>
					</div>					
					<!--  biz_2  (E) -->
					</td>
				</tr>
			</table>
			<!-- Grid BG Box  (E) -->
			<!--Button (S) --> 
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;"> 
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
			                		<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
			                    		<tr>
			                    			<td class="btn1_left"></td>
						                    <td class="btn1" name="btn_New">New</td>
						                    <td class="btn1_right"></td>
					                    </tr>
					                </table>
								</td>
			                	<td class="btn1_line"></td>
			                	<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_DownExcel">Down&nbsp;Excel</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
			                	<td>
			                		<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
			                    		<tr>
			                    			<td class="btn1_left"></td>
			                    			<td class="btn1" name="btn_Save">Save</td>
			                    			<td class="btn1_right"></td>
			                    		</tr>
			                		</table>
			                	</td>
				            </tr>
			            </table>
			        </td>
				</tr>
			</table>
		</td>
	</tr>
</table>
			
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>