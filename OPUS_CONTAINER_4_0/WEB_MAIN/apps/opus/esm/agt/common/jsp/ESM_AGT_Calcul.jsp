<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_Calcul.jsp
*@FileTitle : AGT Calculation
*Open Issues :
*Change history :
*@LastModifyDate : 2007-06-113
*@LastModifier : Sangjun Kwon
*@LastVersion : 1.0
* 2006-12-11 Sangjun Kwon
* 1.0 최초 Insert
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.agt.common.event.ESM_AGT_CalculEvent"%>
<%
	//PDTO(Data Transfer Object including Parameters)
	ESM_AGT_CalculEvent  event = null;
	try {
	   //SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   //userId=account.getUsr_id();
	   //userAuth=account.getAuth();
		event = (ESM_AGT_CalculEvent)request.getAttribute("Event");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Batch Test Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>
	function doProcess(pageNo){
		try {
			//var srcName = window.event.srcElement.getAttribute("name");
			// form 이름에 주의하시기 바랍니다.
			with(document.form) {
				switch (pageNo) {
					// BT_SCM_COA_021
					case 01:
						f_cmd.value = MULTI01;
						action = "ESM_AGT_Calcul.do";
						target = "frmHidden";
						submit();
						break;

					// BT_SCM_COA_022
					case 02:
						f_cmd.value = MULTI02;
						action = "ESM_AGT_Calcul.do";
						target = "frmHidden";
						submit();
						break;
						
					case 03:
						f_cmd.value = MULTI03;
						action = "ESM_AGT_Calcul.do";
						target = "frmHidden";
						submit();
						break;

				} // end switch
			}// end with
		} catch(e) {
			if( e == "[object Error]") {
				showErrMessage(getMsg(OBJECT_ERROR));
			} else {
				showErrMessage(e);
			}
		}
	}
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<form method="post" name="form" onSubmit="return false;">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td class="bodyright">
		<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (START) ####### -->

		 
		  
		
		  <div align="center">
		    <input type="hidden" name="f_cmd">
		    <input type="hidden" name="iPage">
		    <br>
		    <br>
		    <table width="900" border="0" cellspacing="0" cellpadding="0">
		      <tr>
		        <td width="70%" bgcolor="999999">
		          <table width="100%" border="0" cellpadding="1" cellspacing="1" style="left_margine:100">
		            <tr>
		              <td class="title" bgcolor="#DADADA" align="center">JOB </td>
		              <td class="title" bgcolor="#DADADA" align="center">연동포함(Charge)</td>
		              <td class="title" bgcolor="#DADADA" align="center">Do Process</td>
		            </tr>
		            <tr>
		              <td width="80%" class="con" bgcolor="#FFFFFF" align="center">
		                <br>
		                <div align="left">&nbsp;BKG_NO : <input name="bkg_no" type="" id="bkg_no" value="">
		                  &nbsp;BKG_NO_SPLIT : <input name="bkg_no_split" type="" id="bkg_no_split" value="  " size="2" maxlength="2">
		                </div>
		                <br>
		              </td>
		              <td width="10%" class="con" bgcolor="#FFFFFF" align="center">
		                <div align="center">
		                  &nbsp;<input type="checkbox" name="charge_1" id="charge_1">
		                </div>
		              </td>
		              <td width="10%" class="con" bgcolor="#FFFFFF" align="center"><a href="javascript:doProcess(01)">[Execute]</a></td>
		            </tr>
		            <tr>
		              <td width="80%" class="con" bgcolor="#FFFFFF" align="center">
		                <br>
		                <div align="left">
		                  &nbsp;BL_NO : <input name="bl_no" type="" id="bl_no" >
		                </div>
		                <br>
		              </td>
		              <td width="10%" class="con" bgcolor="#FFFFFF" align="center">
		                <div align="center">
		                  &nbsp;<input type="checkbox" name="charge_2" id="charge_2">
		                </div>
		              </td>
		              <td width="10%" class="con" bgcolor="#FFFFFF" align="center"><a href="javascript:doProcess(02)">[Execute]</a></td>
		            </tr>
		            <tr>
		              <td width="80%" height="230" class="con" bgcolor="#FFFFFF" align="center">
		                <br>
		                <div align="center">
		                  &nbsp;SQL <br> <textarea  name="sql" id="sql" cols="130" rows="12"></textarea>
		                </div>
		                <br>
		              </td>
		              <td width="10%" class="con" bgcolor="#FFFFFF" align="center">
		                <div align="center">
		                  &nbsp;<input type="checkbox" name="charge_3" id="charge_3">
		                </div>
		              </td>
		              <td width="10%" class="con" bgcolor="#FFFFFF" align="center"><a href="javascript:doProcess(03)">[Execute]</a></td>
		            </tr>
	          	</table>
	        	</td>
	      	</tr>
	    </table>
	  </div>
	</form>
	<iframe heigth="0" width="0" name="frmHidden"></iframe>

</td></tr>
	<tr><td class="bgdybottom_copy">

	<!-- ####### TABLE '#E' ::: 'BOTTOM' FRAME (START) ####### -->
	<!-- TABLE '#E' : 'Family Site + Copyright' Table (S)tart -->
	<table class="copy">
	<tr><td class="copy"><img src="/opuscntr/img/copy2.gif" width="460" height="16"></td></tr>
	</table>
	<!-- TABLE '#E' : 'Family Site + Copyright' Table (E)nd -->
	<!-- ####### TABLE '#E' ::: 'BOTTOM' FRAME (END) ####### -->

	</td></tr>
</table>
</body>
</html>
