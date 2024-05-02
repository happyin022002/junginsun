<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_joo_0060.jsp
*@FileTitle : Invoice Letter Information Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.07.07 장강철
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.event.FnsJoo0062Event"%>
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.LetterVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsJoo0062Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	String strOfc_eng_nm    = "";
	String strUsr_Eml       = "";
	String strFax_no        = "";
	
	
	Logger log = Logger.getLogger("com.hanjin.apps.JointOperationAgreementSettlement.JointOperationLetter");
	String yyyyMM = JSPUtil.getKST("yyyy-MM");
	String curYYYYMM = JSPUtil.getKST("yyyy-MM-dd");	
	String jo_ltr_seq       = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strOfc_eng_nm =   account.getOfc_eng_nm();
		strUsr_Eml    =   account.getUsr_eml();
		strFax_no     =   account.getFax_no();
		
		event = (FnsJoo0062Event)request.getAttribute("Event");
		LetterVO letterVO =  event.getLetterVO();
		if( letterVO == null ){
		    letterVO = new LetterVO();
		}
		jo_ltr_seq =  letterVO.getJoLtrSeq()==null?"":letterVO.getJoLtrSeq();
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
<title>MCS Letter Information Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 

<script language="javascript">
    var yyyyMM         =  "<%=yyyyMM%>";
    var curYYYYMM      =  "<%=curYYYYMM%>";
    var strOfc_eng_nm  =  "<%=strOfc_eng_nm%>";
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
<input type="hidden" name="ofc_cd"        value="<%=strOfc_cd %>">
<input type="hidden" name="flag"         value="I">
<input type="hidden" name="jo_ltr_tp_cd" value="I">
<input type="hidden" name="usr_nm" value="<%=strUsr_nm %>">
<input type="hidden" name="send_fax_no" value="<%=strFax_no %>"> <!-- 전송자 FaxNO -->


<input type="hidden"   name="jo_ltr_seq" value="<%=jo_ltr_seq %>"> 
<input type="hidden"   name="cre_usr_id" value="<%=strUsr_id %>"> 

<input type="hidden"   value="JOO" name="sub_sys_cd">

<input type="hidden"   value="FNS_JOO_0064.mrd" name="tmplmrd">                
<input type="hidden"   value="" name="tmplparam">              

<input type="hidden"   value="<%=strUsr_Eml %>" name="sndr_eml">
 
<input type="hidden"   value="" name="ltr_tit_ctnt">

<input type="hidden"   value="" name="changeyn" >
<input type="hidden"   value="" name="jo_ltr_tmplt_seq" >
<input type="hidden"   value="" name="content" >
<input type="hidden"   value="" name="attach_yn" >
<textarea name="keys" style="width:100%; height:10px;display:none"></textarea>

<input type="hidden"   value="" name="eml_snd_no" ><!--   -->
<input type="hidden"   value="" name="fax_snd_no" ><!--  -->

 
<!-- RD -->
<input type="hidden"   name="com_mrdPath" value="">
<input type="hidden"   name="com_mrdArguments" value="">
<input type="hidden"   name="com_mrdBodyTitle"     value="">   

<input type="hidden"   name="com_mrdSaveDialogFileExt" value="ppt">
<input type="hidden"   name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@doc@ppt">
<input type="hidden"   name="com_mrdSaveDialogFileName" value="InvoiceInform">
<input type="hidden"   name="com_mrdSaveDialogDir" value="c:\users\">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
		<!--Page Title, Historical (E)-->	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
				<td width="91">&nbsp;Year/Month</td>
					<td width="136"><input type="text" style="width:60" class="input1"  dataformat='ym'  maxlength='6' value="<%=yyyyMM %>" caption='Period' required  fullfill name='acct_yrmon' >&nbsp;<img class="cursor" src="img/btns_back.gif" name='btn_acct_yrmon_back' width="19" height="20" border="0" align="absmiddle">&nbsp;<img class="cursor" src="img/btns_next.gif"  name='btn_acct_yrmon_next' width="19" height="20" border="0" align="absmiddle"></td>
					<td width="40">Carrier </td>
					<td width="80">&nbsp;<script language="javascript">ComComboObject('jo_crr_cd', 1, 60, 0, 1, 0 );</script>&nbsp;</td>
					<td width="105">Combined No.</td>
					<td width=""><script language="javascript">ComComboObject('stl_cmb_seq', 1, 120, 0, 1, 0 );</script></td>
					</tr> 
				</table>			
<!--   1 Search E-->				
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
				<td width="93">&nbsp;Text No.</td>
					<td width="130"><script language="javascript">ComComboObject('jo_tmplt_no',2, 106,0, 1);</script></td>
<!--    			<td width="105">Creation User ID</td>
					<td width="210"><input type="text" style="width:160;"   class="input2"  readonly  name='usr_id' value=""></td>-->
					<td width="">
						<table class="search_sm2" border="0" style="width:200;"> 
						<tr class="h23"><td width="70">Send Type </td>
								<td class="stm"><input type="radio" class="trans" name='send_type' checked  value='MAIL'>&nbsp;E-mail&nbsp;&nbsp;&nbsp;<input type="radio"  class="trans"  name='send_type' value='FAX'>&nbsp;Fax</td>
						</tr> 
						</table>
					</td>
					</tr> 
				</table>
<!--   2 Search E-->						
				<!--  biz_1   (E) -->
				<table class="line_bluedot"><tr><td></td></tr></table>
				<!--  biz_2   (S) -->
				<table class="grid2" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="10%" class="tr2_head">Address </td>
					<td width="" colspan="3"><textarea style="width:100%; height:40;"   class="input2" name="ofc_addr" readonly ></textarea></td>
				</tr>  
				<tr class="h23">
					<td width="10%" class="tr2_head">Date</td>
					<td width="50%"><input type="text" style="width:100;"   class="input" name="ltr_iss_dt"  caption='Date' required  size='10' style="ime-mode:disabled" dataformat="ymd" maxlength="8" required fullfill value='<%=curYYYYMM %>'>&nbsp;<img class="cursor" src="/hanjin/img/btns_calendar.gif" width="19" height="20"  name="btns_calendar"  border="0" align="absmiddle"></td>
					<td colspan="2" class="input2"></td>
				</tr> 
				<tr class="h23">
					<td width="10%" class="tr2_head">To </td>
					<td width="50%"><script language="javascript">ComComboObject('ltr_rcvr_co_nm', 1, 500, 0, 1);</script></td>
					<td width="10%" class="tr2_head">Letter No.</td>
					<td width=""><input type='text'  style="width:100%;text-align:center;" class="input2" readonly name='letter_no' /></td>
				</tr> 
				<tr class="h23">
					<td width="10%" class="tr2_head">Attn</td>
					<td width="50%"><input type="text" style="width:477;"  readonly  class="input2"  caption='Attn' required name='ltr_rcvr_cntc_pson_nm'  class="input" value="">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19"  id='btns_search01'  name='btns_search01' height="20" border="0" align="absmiddle"></td>
					<td colspan="2" rowspan="8" class="input2"></td>
				</tr> 
				<tr class="h23">
					<td width="10%" class="tr2_head">CC </td>
					<td width="50%"><input type="text" style="width:100%;"   class="input2"  readonly name='ltr_cc_rcvr_cntc_pson_nm_ctnt'></td>
				</tr> 
				<tr class="h23">
					<td width="10%" class="tr2_head">FM </td>
					<td width="50%"><input type="text" style="width:100%;"  class="input2"  caption='FM' required   readonly  name='ltr_sndr_co_nm'></td>
				</tr> 
				<tr class="h23">
					<td width="10%" class="tr2_head">RE </td>
					<td width="50%"><input type="text" style="width:200;"   class="input2"   caption='RE' required    readonly name='head_ltr_tit_ctnt'>
                               <select name='ltr_tit_ctnt_mnth' >
				                    <option value='Jan'>Jan</option>
				                    <option value='Feb'>Feb</option>
                                    <option value='Jan'>Mar</option>
				                    <option value='Apr'>Apr</option>
                                    <option value='May'>May</option>
                                    <option value='Jun'>Jun</option>
				                    <option value='Jul'>Jul</option>
				                    <option value='Aug'>Aug</option>
                                    <option value='Sep'>Sep</option>
                                    <option value='Oct'>Oct</option>
				                    <option value='Nov'>Nov</option>
                                    <option value='Dec'>Dec</option>                                   
				         </select>&nbsp;<select name='ltr_tit_ctnt_year' >
                                    <option value='<%=yyyyMM.substring(0,4)  %>'><%=yyyyMM.substring(0,4) %></option>
                                    <option value='<%=Integer.parseInt(yyyyMM.substring(0,4))-1  %>'><%=Integer.parseInt(yyyyMM.substring(0,4))-1 %></option>                                                                     
				               </select>&nbsp;<input type="text" style="width:188;"    class="input2"   caption='RE' required    readonly name='tail_ltr_tit_ctnt' ></td>
				</tr> 
				<tr class="h23">
					<td width="10%" class="tr2_head">Total Amount </td>
					<td width="50%"><input type="text" style="width:100%;"  style='width:150;text-align:right'   caption='Total Amount'      class="input2" readonly name='ttl_stl_amt'></td>
				</tr> 
				<tr class="h23">
					<td width="" class="tr2_head">Fax No.</td>
					<td width=""><input type="text" style="width:100%;"   class="input2"   name='jo_cntc_fax_no_ctnt'></td>
				</tr> 
				<tr class="h23">
					<td width="" class="tr2_head">Attn E-mail</td>
					<td width=""><input type="text" style="width:100%;"  class="input2"   name='rcvr_eml'></td>
				</tr> 
				<tr class="h23">
					<td width="" class="tr2_head">CC E-mail</td>
					<td width=""><input type="text" style="width:100%;"   class="input2"    name='cc_rcvr_eml_ctnt' ></td>
				</tr> 
				</table>
			<!--  biz_2   (E) -->
				<table class="line_bluedot"><tr><td></td></tr></table>
				
				
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Text  Detail</td></tr>
				</table>
				
			
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width=""><textarea style="width:979; height:50;"  rows=3 wrap=off name='n1st_stmt_ctnt'></textarea></td>
				</tr> 
			</table>
			<table class="height_8"><tr><td></td></tr></table>
 
			
			<!-- Grid  (S) -->
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23"><td style="padding-left:2">
					<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
			    	</table>
				<table width="100%"  id="mainTable" style='display:none'> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>

						</td>
					</tr>
				</table> 	
				</td></tr> 
			</table>
			<!-- Grid (E) -->
			<table class="height_8"><tr><td></td></tr></table>
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width=""><textarea style="width:979; height:40;"   name='n2nd_stmt_ctnt'></textarea></td>
				</tr> 
			</table>
			<table class="height_8"><tr><td></td></tr></table>
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width=""><textarea style="width:979; height:40;" class="input2" readonly  name='bank_stmt_ctnt'></textarea></td>
				</tr> 
			</table>
			<table class="height_8"><tr><td></td></tr></table>
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="400"><textarea style="width:400; height:90;"  wrap=off rows=6    name='n3rd_stmt_ctnt'></textarea></td>
					<td width="175"></td>
					<td width=""><textarea style="width:400; height:90;" rows=6 class="input2" readonly name='sig_stmt_ctnt'></textarea></td>
				</tr> 
			</table>
	
	</td>
	</tr> 
	</table>
	
	<!--biz page (E)-->				
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td style='display:none'><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve2" id="btn_Retrieve2">Retrieve2</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td> 
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Attach">Attach</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td id='td_btn_File_View'  style='display:none'  ><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_File_View" id="btn_File_View">FileView</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Send">Send</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Print">Print</td>
					<td class="btn1_right"></td>
 
					</tr>
				</table></td>
			
			
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>
</td></tr>
</table>
 

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>