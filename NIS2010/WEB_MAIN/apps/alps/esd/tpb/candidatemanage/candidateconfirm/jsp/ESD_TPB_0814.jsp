<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0105.jsp
*@FileTitle : TPB Candidate Confirmation
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-31
*@LastModifier : Park Sung-Jin
*@LastVersion : 2.0
* 2008-09-01 O Wan-Ki 1.0 최초 생성
* 2009-08-11 O Wan-Ki 1.1 디자인변경
* 2009-08-31 Park Sung-Jin 2.0 NIS2010 시스템 적용
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.candidatemanage.candidateconfirm.event.EsdTpb0814Event"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.common.TPBUtils"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0814Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.StatusInquiry.PerformanceInquiry");
	
	String ofc_cd = "";
	String rhq_cd = "";
	String cnt_cd = "";
	String currentDay = DateTime.getFormatString("yyyy-MM-dd");
	

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		ofc_cd = account.getOfc_cd();
		cnt_cd = account.getCnt_cd();

		event = (EsdTpb0814Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String[] officeInfo = TPBUtils.getHandleOfficeLevel( ofc_cd, true ); // 0:Office Level / 1:Office Code / 2:RHQ Code / 3:HO Code
	String ofc_top_lvl = JSPUtil.getNull( TPBUtils.getOfficeTopLevel( ofc_cd ) );
	String ofc_lvl = JSPUtil.getNull( officeInfo[0] ); // Office Level
	rhq_cd  = JSPUtil.getNull( officeInfo[2] ); // RHQ Code
%>
<html>
<head>
<title>Note on Non-TPB</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
<script language="javascript">
<%= JSPUtil.getIBCodeCombo("combo01", "01", "CD00583", 0, "")%>
<%= JSPUtil.getIBCodeCombo("combo02", "02", "CD00902", 0, "")%>
    function setupPage()
    {  
     loadPage();
    }
    function enforcechar(what,limit){
    	if (what.value.length>=limit)
    	return false
    }
</script>
<script type="text/javascript">

    // are_name - textarea객체, ari_max - 제한길이 수

    function f_chk_byte(aro_name,ari_max) {   
    	if(form.n3pty_non_cfm_rsn.value.length < 1) {
    		form.n3pty_non_cfm_rsn.value = str_placeholder;
    		is_placeholder = true;
    		return;
    	}
    	
        var ls_str     = aro_name.value;

        var li_str_len = ls_str.length;

        var li_max      = ari_max;

        var i           = 0;

        var li_byte     = 0;

        var li_len      = 0;

        var ls_one_char = "";

        var ls_str2     = "";

    

        for(i=0; i< li_str_len; i++) {

            ls_one_char = ls_str.charAt(i);

            if (escape(ls_one_char).length > 4) 

                li_byte += 2;

            else 

                li_byte++;

            

            if (li_byte <= li_max) li_len = i + 1;

        }

    

        if(li_byte > li_max) {

//       alert("한글 " +  ari_max + "글자를 초과 입력할수 없습니다. 초과된 내용은 자동으로 삭제 됩니다.");

            ls_str2 = ls_str.substr(0, li_len);

            aro_name.value = ls_str2;

        }

        aro_name.focus();   

    }

</script>


</head>

<body  onLoad="setupPage();">
<form method="post" name="form">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<!-- ______________________________________________ Start Hidden Value -->
<!-- | -->
<input type="hidden" name="ots_dtl_seq" value= "<%=JSPUtil.getNull(request.getParameter("ots_dtl_seq"))%>">
<input type="hidden" name="pN3pty_non_cfm_rsn_cd" value= "<%=JSPUtil.getNull(request.getParameter("n3pty_non_cfm_rsn_cd"))%>">
<input type="hidden" name="f_cmd">
<!-- |______________________________________________ End Hidden Value -->

<table width="100%" class="popup" cellpadding="10" border="0"> 
   <tr><td class="top"></td></tr>
   <tr>
    <td valign="top">
     <table width="100%" border="0">
     <tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Non-TPB Request</td></tr>
     </table>
 
  
  <table>
   <tr height="5"><td>
   </td></tr>
  </table>
  
  <table class="search">
   <tr><td class="bg">
    <table border="0" style="width:100%; background-color:white;" class="grid2"> 
     <tr><td width="" class="tr2_head" style="text-align:left;">* Reason for Non-TPB</td></tr>
     <tr><td>
      <textarea style="width:100%;height:160; text-indent:0px"  onkeydown="f_set_placeholder(event)" onkeyup="f_chk_byte(this,1000)" maxLength="100" rows="10" cols= "100" name="n3pty_non_cfm_rsn" value = ""></textarea>
     </td></tr>
    </table>
   </td></tr>
  </table>
	
 
<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 
 
	<!-- | -->	<table class="search"><tr><td class="bg">
	<!-- | -->
	<!-- | -->		<table width="100%" id="mainTable">
	<!-- | -->			<tr>
	<!-- | -->				<td>
	<!-- | -->					<script language="javascript">ComSheetObject('sheet1');</script>
	<!-- | -->				</td>
	<!-- | -->			</tr>
	<!-- | -->		</table>
	<!-- | -->
	<!-- | -->	</td></tr></table>
 
 
 
 
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
 
  <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn3_bg">
      <table border="0" cellpadding="0" cellspacing="0">
      <tr>
       <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
     <tr><td class="btn1_left"></td>
     <td class="btn1" name="btn_Save">Save</td>
     <td class="btn1_right"></td>
    </tr></table></td>
    <td class="btn1_line"></td>
    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
     <tr><td class="btn1_left"></td>
     <td class="btn1" name="btn_Close">Close</td>
     <td class="btn1_right"></td>
    </tr></table></td>
   </tr>
  </table>
    <!--Button (E) -->
 
 </td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
</td>
</tr>
</table>
</form>
</body>
</html>
