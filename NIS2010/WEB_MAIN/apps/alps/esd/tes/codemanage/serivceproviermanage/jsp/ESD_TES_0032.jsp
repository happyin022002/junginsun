<!--%/*=========================================================
*Copyright(c) 2017 HiplusCard
*@FileName : ESD_TES_032.jsp
*@FileTitle : Service Provider Code Master(India)
*Open Issues :
*Change history :
*@LastModifyDate : 2017-06-29
*@LastModifier : 
*@LastVersion : 1.0
* 2017-06-29  
* 1.0 최초 생성
=========================================================*%-->
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tes.codemanage.serviceprovidermanage.event.EsdTes0032Event"%>
<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";								 //에러메세지
	
	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	} catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Service Provider Code(India)</title>
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
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name=ida_spcl_ecn_zn_doc_no>

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->



		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->




		<!-- TABLE '#D' : ( Search Options :  ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
				<!-- : ( Week ) (S) -->
				<table class="search_in" border="0">

				<tr class="h23">
					<td width="80"><img class="nostar">S/P Code</td>
					<td width="105" class="stm">
						<input class="input1" type="text" style="width:68" name="vndr_seq" value='' valid="1" desc= "VNDR Code" value='' maxlength=6 tabindex='1' onKeyUp='tes_isNum(this);' onKeyDown='tes_isNum(this);' onBlur='validateVndrSeq();'>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name="btn_vndr">
						<input type="hidden" name="vndr_seq_hidden" value=''>
						<input type="hidden" name="is_valid_vndr_seq" value=''>	
					</td>				  
					<td width="80"><img class="nostar">S/P Name</td>
					<td width="155"><input type="text" style="width:135" value=""  name ="vndr_seq_nm" valid="1" class="input2" readOnly ></td>
					<td width="80"><img class="nostar">State Code</td>
					<td width="95" class="stm"><input type="text" style="width:35" value=""  name ="ste_cd" valid="1" class="input1" ></td>
					<td width="100"><img class="nostar">Country Code</td>
					<td width="95" class="stm"><input type="text" style="width:35" value="IN"  name ="cnt_cd" valid="1" class="input2" readOnly ></td>
				</tr>
				</table>
				<!-- : ( Week ) (E) -->


			</td></tr>
		</table>
		
		<!-- TABLE '#D' : ( Search Options : ) (E) -->
		<table class="height_10"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Search Options : Detail Explanation ) (S) -->
     	<table class="search">
       		<tr><td class="bg">


				<!-- : ( From Location ) (S) -->
					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>
				<!-- : ( From Location ) (E) -->



			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Detail Explanation) (E) -->

		<table class="height_10"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Search Options : Detail Explanation ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Detail Explanation ) (S) -->
				<table class="search_in" border="0">

				<tr class="h23">
					<td width="80"><img class="nostar">S/P Code</td>
					<td width="105" class="stm"><input type="text" style="width:85" value=""  name ="ida_vndr_seq" valid="1" class="input2" readOnly ></td>				  
					<td width="100">S/P Name</td>
					<td width="245"><input type="text" style="width:225" value=""  name ="ida_vndr_nm" valid="1" class="input2" readOnly ></td>
					<td width="200"></td>
				</tr>
				<tr class="h23">
					<td width="80"><img class="nostar">State Code</td>
					<td width="105" class="stm"><input type="text" style="width:85" value=""  name ="ida_ste_cd" valid="1" class="input2" readOnly ></td>				  
					<td width="100">State Name</td>
					<td width="245"><input type="text" style="width:225" value=""  name ="ida_ste_nm" valid="1" class="input2" readOnly ></td>
					<td width="200"></td>
				</tr>
				<tr class="h23">
					<td width="150"><img class="nostar">Company Type</td>
					<td width="225" class="stm"><select style="width:155;"  value="0" name="ida_co_type_cd" desc= "Company Type" onChange="" class="input1">
						<option value=""></option>
						<option value="R">Private Limited Co.</option>
						<option value="U">Public Limited Co.</option>
						<option value="P">Partnership</option>
						<option value="I">Individual</option>
						</select>
					</td>	
					<td width="80">PAN No</td>
					<td width="245" class="stm"><input type="text" style="width:135" value=""  name ="ida_pan_no" valid="1" class="input1"></td>				  
					<td width="200"></td>
				</tr>
				<tr class="h23">
					<td width="200"><img class="nostar">GST Registration Status</td>
					<td width="135" class="stm"><select style="width:100;"  value="0" name="ida_gst_rgst_sts_cd" onChange="" class="input1">
						<option value="" selected></option>
						<option value="R">Registered</option>
						<option value="U">Unregistered</option>
						<option value="C">Composite</option>
						</select></td>				  
					<td width="200">No. of GST Registration</td>
					<td width="245"><select style="width:80;"  value="0" name="ida_gst_rgst_tp_cd" onChange="" class="input1">
						<option value="" selected></option>
						<option value="S">Single</option>
						<option value="M">Multiple</option>
						</select></td>
					<td width="200"></td>
				</tr>
				<tr class="h23">
					<td width="150"><img class="nostar">GSTIN/UIN</td>
					<td width="245"><input type="text" style="width:225" value=""  name ="ida_gst_rgst_no" valid="1" class="input1"></td>
					<td width="120">Alternative Payee</td>
					<td width="245" class="stm"><input type="text" style="width:135" value=""  name ="ida_altn_rcvr_nm" valid="1" class="input1"></td>		
					<td width="200"></td>
				</tr>
				<tr class="h23">
					<td width="80"><img class="nostar">SEZ Unit</td>
					<td width="105" class="stm"><select style="width:40;"  value="0" name="ida_spcl_ecn_zn_ut_flg" desc= "SEZ Unit" onChange="chkSezDoc();" class="input1">
					    <option value="" selected></option>
						<option value="Y">Y</option>
						<option value="N">N</option>
						</select></td>	
					<td width="200">SEZ Certificate</td>
					<td width="245"><input type="text" style="width:185" value=""  name ="ida_spcl_ecn_zn_doc_desc" valid="1" class="input1" readOnly>&nbsp;<img class="cursor" name="btn_upload" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>		
					<td width="200"></td>			  
					
				</tr>
				<tr class="h23">
					<td width="220"><img class="nostar">Contact Person (Additional)</td>
					<td width="225"><input type="text" style="width:225" value=""  name ="ida_cntc_pson_nm" valid="1" class="input1"></td>
					<td width="200">E-Mail (Additional)</td>
					<td width="245"><input type="text" style="width:225" value=""  name ="ida_vndr_eml" valid="1" class="input1"></td>
					<td width="200"></td>			  					
				</tr>			
				</table>
				<!-- : ( Detail Explanation ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Detail Explanation) (E) -->

</td></tr>
</table>
</form>
</body>
</html>		

<DIV style="display:none">
<table width="100%" id="mainTable">
    <tr><td>
         <script language="javascript">ComSheetObject('sheet2');</script>
    </td></tr>
</table>
</DIV>

