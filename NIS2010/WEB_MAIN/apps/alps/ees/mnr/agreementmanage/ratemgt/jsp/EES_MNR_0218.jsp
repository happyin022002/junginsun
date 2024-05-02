<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0218.jsp
*@FileTitle : M&R AGREEMENT DETAIL Pop_Up
*Open Issues :
*Change history :
*@LastModifyDate : 20104.11.06
*@LastModifier : 함형석 
*@LastVersion : 1.0
* 2009.07.03 함형석
* 1.0 Creation
* 2014-11-06 CSR ID : CHM-201432660 : ALPS MNR-AGMTTARIFF 화면에서 GW-Contract Document와 ALPS MNR-AGMT와 Interface된 결과 값을 보여줄수 있도록 구현 : AA Chang Young Kim, DEV 이상근
=========================================================*/   
%>		
		
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.event.EesMnr0218Event"%>
<%@ page import="org.apache.log4j.Logger" %>
  
<%
	EesMnr0218Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	 
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100"; 
 	
	String strUsr_id		= ""; 
	String strUsr_nm		= "";  
	String strOfc_cd		= "";  
	String strAgmt_no		= "";  
	String strAgmt_ofc_cd		= "";  
	
	Logger log = Logger.getLogger("com.hanjin.apps.OperationManage.EQFlagMgt");
		  
	try {	
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();	   
		strUsr_nm = account.getUsr_nm();	
		strOfc_cd = account.getOfc_cd();	  

		strAgmt_no = JSPUtil.getParameter(request, "agmt_no");
		strAgmt_ofc_cd = JSPUtil.getParameter(request, "agmt_ofc_cd");
		
		event = (EesMnr0218Event)request.getAttribute("Event"); 
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
<title>M&R Agreement Detail</title>	  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 

<!--MNR 공용 사용  -->				
<script language="javascript">   
	function setupPage(){ 
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if  
		loadPage();
	}
</script>
<script language="javascript">ComSheetObject('sheet1');</script>	
</head> 
	   
<body  class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="local_ofc_cd" value="<%=strOfc_cd%>">	  
<input type="hidden" name="f_cmd">  
<input type="hidden" name="pagerows">	
<!-- 조회시 인덱스를 테우기 위한 히든값	-->				   
<input type="hidden" name="agmt_ofc_cty_cd">			 
<input type="hidden" name="agmt_seq"> 
<!-- 가변적 TPSZ를 처리하기 위한 히든값 -->
<input type="hidden" name="agmt_type_tpsz">  
<!-- 저장시 가변적 VO 타입을 처리하기 위한 히든값 --> 
<input type="hidden" name="agmt_display_type">   
<input type="hidden" name="agmt_prifix">   
<!-- 버젼업상태표시  -->	
<input type="hidden" name="isversionup" value="N">	 
   
<!-- PARTER 용 히든   -->		
<input type="hidden" name="ctrl_ofc_cd" value="<%=strOfc_cd%>">	 
<input type="hidden" name="strAgmt_no" value="<%=strAgmt_no%>">   
<!-- 개발자 작업	-->   
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>

	<tr><td valign="top"> 
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> M&R Agreement Detail</td></tr>
		</table>
		<!--Page Title, Historical (E)-->	
			
		<!--biz page (S)-->
		<table class="search" id="mainTable" border="0" > 
			<tr><td class="bg">
			
			
			<table class="search" border="0" style="width:100%;"> 
			<tr class="h23">
				<td width="100%">
				
				<!--  biz_1  (S) -->  
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23"> 
					<td width="105">Agreement No.</td>	 
					<td width="130"><input required tabindex="1" type="text" name="agmt_no"  style="width:100;" class = "input1" value = "" dataformat="engup">&nbsp;</td>
					<td width="75">Version No.</td> 		 
					<td width="235"><input required name="agmt_ver_no2" readonly type="text" style="width:43;text-align:right;" class="input2" value="">
						<input required name="agmt_ver_dt" readonly type="text" style="width:150;" class="input2" value=""></td>
					<td width="120">G/W Contract</td>
					<td width=""><input required name="gw_contract" readonly type="text" style="width:79;"";text-align:right;" class="input2" value=""></td>
				</tr>		
				</table> 				 
				<!--  biz_1   (E) --> 
					
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
							
				<!--  biz_2  (S) --> 
				<table class="search" border="0" style="width:100%;">  
				<tr class="h23">
					<td width="105">Service Provider</td>			 
					<td width="290"><input required tabindex="3" type="text" name="vndr_seq" caption="Service Provider" style="width:55;text-align:left;" class="input1" value="" dataformat="engup" maxlength="6">&nbsp;<input type="text" name="vndr_nm" caption="Service Provider" style="width:190;" class="input2" value="" readonly></td>
					<td width="70">Currency</td>   
					<td width="80"><input required name="curr_cd2" readonly type="text" style="width:42;" class="input2" value=""></td>
					<td width="120">Agreement Office</td>   
					<td width=""><input required name="agmt_ofc_cd2" readonly type="text" style="width:79;" class="input2" value="<%=strAgmt_ofc_cd %>"></td>	
				</tr>  
				<tr class="h23"> 
					<td>Effect Period</td>  
					<td class="sm"> 
					<input required fullfill type="text" name="eff_dt" dataformat="ymd" class="input1"  caption="from date"  maxlength="8" style="width:78"  cofield="exp_dt" value="">   
									~ <input required fullfill type="text" name="exp_dt" dataformat="ymd"   class="input1"  caption="to date" maxlength="8"  size="10"  cofield="eff_dt">&nbsp; 
					</td>
					<td>Pay Terms</td>	 			 
					<td class="sm"><input required name="pay_term_dys" type="text" style="width:42;text-align:right;" class="input1" value="" maxlength="3" dataformat="int" >&nbsp;days</td> 
					<td>AGMT Sign Date</td>		
					<td><input required  name="agmt_dt" type="text" style="width:79" class="input1" value="" dataformat="ymd" maxlength="8">&nbsp;</td></tr> 
				</table>					
				<!--  biz_2  (E) --> 
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
				<!--  biz_3  (S) --> 
				<table class="search" border="0" style="width:100%;">  
				<tr class="h23">  
					<td width="105">Tariff No.</td>	   
					<td width="290"><input required name="trf_no2" readonly type="text" style="width:182;" class="input2" value="">  
					</td> 
					<td width="70">Ref. No.</td> 
					<td width=""><input required type="text"  maxlength="20" name="agmt_ref_no" style="width:280;" class="input1" value="" dataformat="engup"></td> 
				</tr>	 	  
				<tr class="h23">		
				<td colspan="5">
					<table class="search" border="0" style="width:279;">	 
					<tr class="h23">			
						<td width="105">EQ Type</td>	   
						<td width=""><input required name="eq_knd_cd2" readonly type="text" style="width:82;" class="input2" value="">	 

						</td> 
					</tr>   
					</table>
				</td>   
				</tr>  
				</table> 				
				<!--  biz_3   (E) -->
				</td>
				</tr></table>
		<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
		 
		<!-- grid box (S) -->	
		
		<table class="search" border="0">
		<tr><td valign="top" width="50%"> 	
				<!-- Tab (S) -->
		 	<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
				<tr>
					<td width="100%">	
						<script language="javascript">ComTabObject('tab1')</script>
					</td>	
				</tr>
			</table>			
			<!-- Tab (E) -->						
				<!--TAB Repair (S) -->	 
				<div id="tabLayer" style="display:none">
					<!-- Grid  (S) -->  
						<table width="100%"  id="mainTable">  
							<tr>  
								<td width="100%">  
									<script language="javascript">ComSheetObject('t1sheet1');</script>
								</td>
							</tr>
						</table>
					<!-- Grid (E) -->	
					<!--  (Repair)RC형 추가요청 삭제  -->		
				</div>
				
			<!--TAB Repair (E) -->	

<!--TAB Cleaning (S) -->

<div id="comboLayer" style="display:none">
	<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComComboObject('agmt_ver_no', 2, 0, 1, 1,0,false,2);</script>
							<script language="javascript">ComComboObject('curr_cd', 2, 0, 1, 1,0,false,4);</script>
							<script language="javascript">ComComboObject('agmt_ofc_cd', 1, 0, 1, 1);</script>
							<script language="javascript">ComComboObject('trf_no', 8, 270, 1, 0,0,false,1);</script>
							<script language="javascript">ComComboObject('eq_knd_cd',1, 78 , 1,1)</script> 	
						</td>
					</tr>
				</table>
</div>
				
<div id="tabLayer" style="display:none">
	<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t2sheet1');</script>
						</td>
					</tr>
				</table>

	<!-- Grid (E) -->	
	<!--  Button_Sub (S) -->
	<table width="100%" class="button"> 
	 	<tr><td class="btn2_bg">
		<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="">	 
			&nbsp; 
			</td>	
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn2_left"></td>
			<td class="btn2" name="btn_t2add">Row&nbsp;Add</td>
			<td class="btn2_right"></td>
			</tr>
			</table></td>   
			
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn2_left"></td>
			<td class="btn2" name="btn_t2del">Row&nbsp;Delete</td>
			<td class="btn2_right"></td>
			</tr>
			</table></td>
					
			</tr></table>
	</td></tr>
	</table>
	<!-- Button_Sub (E) -->		
</div>

<!--TAB Cleaning (E) --> 



<!--TAB Survery (S) -->

<div id="tabLayer" style="display:none">

	<!-- Grid  (S) -->

				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t3sheet1');</script>
						</td>
					</tr>
				</table>
	
	<!-- Grid (E) -->		
	
	<!--  Button_Sub (S) -->
	<table width="100%" class="button"> 
	 	<tr><td class="btn2_bg">
		<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="">   
			&nbsp; 
			</td> 
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn2_left"></td>
			<td class="btn2" name="btn_t3add">Row&nbsp;Add</td>
			<td class="btn2_right"></td>
			</tr>
			</table></td>

			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn2_left"></td>
			<td class="btn2" name="btn_t3del">Row&nbsp;Delete</td>
			<td class="btn2_right"></td>
			</tr>
			</table></td>
					
			</tr></table>
	</td></tr>
	</table>
	<!-- Button_Sub (E) -->

</div>

<!--TAB Survery (E) -->

<!--TAB Other (S) -->

<div id="tabLayer" style="display:none">

	<!-- Grid  (S) -->

				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t4sheet1');</script>
						</td>
					</tr>
				</table>

	<!-- Grid (E) -->		

	<!--  Button_Sub (S) -->
	<table width="100%" class="button"> 
	 	<tr><td class="btn2_bg">
		<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="">   
			&nbsp; 
			</td> 
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn2_left"></td>
			<td class="btn2" name="btn_t4add">Row&nbsp;Add</td>
			<td class="btn2_right"></td>
			</tr>
			</table></td>

			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn2_left"></td>
			<td class="btn2" name="btn_t4del">Row&nbsp;Delete</td>
			<td class="btn2_right"></td>
			</tr>
			</table></td>
					
			</tr></table>
	</td></tr>
	</table>
	<!-- Button_Sub (E) -->
  
</div>

<!--TAB Other (E) -->


<!--TAB Pre-Pre-Maintenance (S) -->
<div id="tabLayer" style="display:none">
<!-- Grid  (S) -->

				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t5sheet1');</script>
						</td>
					</tr>
				</table>
				
				<!--  Button_Sub (S) -->
				<table width="100%" class="button"> 
				 	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr> 
						<td width="">   
						&nbsp; 
						</td> 
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t5add">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
			
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t5del">Row&nbsp;Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
								
						</tr></table>
				</td></tr>
				</table>
				<!-- Button_Sub (E) -->
	<!-- Grid (E) -->		
</div>
<!--TAB Pre-Maintenance (E) -->


<!--TAB Trie Purchase (S) -->
<div id="tabLayer" style="display:none">
<!-- Grid  (S) -->

				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t6sheet1');</script>
						</td> 
					</tr>
				</table>
				
	<!-- Grid (E) -->		

	<!--  Button_Sub (S) -->
	<table width="100%" class="button"> 
	 	<tr><td class="btn2_bg">
		<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="">   
			&nbsp; 
			</td> 
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn2_left"></td>
			<td class="btn2" name="btn_t6add">Row&nbsp;Add</td>
			<td class="btn2_right"></td>
			</tr>
			</table></td>

			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn2_left"></td>
			<td class="btn2" name="btn_t6del">Row&nbsp;Delete</td>
			<td class="btn2_right"></td>  
			</tr> 
			</table></td> 
					
			</tr></table> 
	</td></tr> 
	</table>
	<!-- Button_Sub (E) -->
</div> 
<!--TAB Trie Purchase (E) -->
	 
<!--TAB PTI (S) -->
<div id="tabLayer" style="display:none">
<!-- Grid  (S) -->

				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t7sheet1');</script>
						</td>
					</tr>
				</table>
	<!-- Grid (E) -->		
</div>
<!--TAB PTI (E) -->


<!--TAB Arrach/Detach (S) -->
<div id="tabLayer" style="display:none">
<!-- Grid  (S) -->

				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t8sheet1');</script>
						</td>
					</tr>
				</table>

	<!-- Grid (E) -->	
</div>	
<!--TAB Arrach/Detach (E) -->   
		</td> 
		<td valign="top" width="50%" style="padding-top:0px; padding-left:10px;">	
		<!-- grid box (S) -->		 
			<table width="100%" class="search" border="0" style="padding-bottom:4px">
						<tr><td class="title_h"></td>
							<td class="title_s">Cost CTRL Office & Partner Infomation</td>
						</tr>	
			</table> 		
			<table width="100%"  id="mainTable"> 
			<tr>
			<td width="100%">
				<script language="javascript">ComSheetObject('sheet2');</script>
			</td>
			</tr>
			</table>
			<!-- Grid (E) -->	

		<!-- grid box (S) -->	
		</td></tr> 
	</table>	
	<table class="height_8"><tr><td colspan="8"></td></tr></table> 
	<table class="search" border="0"> 
		<tr class="h23"><td width="75">Remark(s)</td> 
			<td width=""><textarea name="agmt_rmk" wrap="off" style="width:100%;" rows="4"></textarea></td></tr>
	</table>
		<!--biz page (E)--> 
	</td></tr> 
	</table>

<table class="height_8"><tr><td colspan="8"></td></tr></table> 
	
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
		</table></td>
			</tr>
		</table>
<!-- : ( Button : pop ) (E) -->		
</form>   
</body>   
</html> 
