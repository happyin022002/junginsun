<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_066.jsp
*@FileTitle : EQ 회송기여도 RPT 조회1-2
*Open Issues :
*Change history : CSR No. R200804296329 내부 경로 변경
*@LastModifyDate : 2006-12-01
*                : 2008-05-06
*@LastModifier : Chilseo_Park
*              : 전윤주
*@LastVersion : 1.0
* 2006-12-01 Chilseo_Park
* 2008-05-06 전윤주
* 1.0 최초 생성
* =========================================================
* History
* 2009.09.16 김기식 Alps전환작업 
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.vo.MultiDimensionPfmcByOfficeListVO"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%
	GeneralEventResponse eventResponse = null;
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";								 //에러메세지
	String cntrString = "";
	String crdString = "";

	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
            if (eventResponse != null) {
            	MultiDimensionPfmcByOfficeListVO retVo = (MultiDimensionPfmcByOfficeListVO)eventResponse.getCustomData("retVo");
			
				String[] arr = retVo.getCArr();
				String[] arr2 = retVo.getRtoArr();
				for(int k=0; k<arr.length; k++) {
					cntrString = cntrString + arr[k];
					crdString = crdString + arr2[k];
					if(k!=arr.length-1) {
						cntrString = cntrString + "|";
						crdString = crdString + "|";
					}
				}
			}
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Inquire EQ Repo-contribution By Cost Detail</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var cntrs = '<%=cntrString%>';
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		loadPage(cntrs);
		setRetrieveAction();
	}
</script>
</head>

<body onLoad="javascript:setupPage();">
<form method="post" name="form" onKeyDown="ComKeyEnter();">
  <input type="hidden" name="f_cmd">
  <input type="hidden" name="iPage">
  <!--  부모창으로부터 전송된 폼값 -->
  <input type="hidden" name="f_bkg_no" value="<%=JSPUtil.getNull(request.getParameter("f_bkg_no"))%>">
  <input type="hidden" name="f_cntrNo" value="">
  <input type="hidden" name="f_crd_rto" value="<%=crdString%>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">


		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Inquire EQ Repo-contribution By Cost Detail</td></tr>
		</table>
		<!-- : ( Title ) (E) -->


        <!-- : ( Search Options ) (S) -->
        <table class="search">
          <tr>
            <td class="bg">
              <table class="search" border="0">
                <tr>
                  <td class="title_h"></td>
                  <td class="title_s">Cost Detail Inquiry</td>
                </tr>
                <tr>
                  <td class="height_5"></td>
                </tr>
              </table>
              <!-- : ( Grid ) (S) -->
              <table width="100%" id="mainTable">
                <tr>
                  <td>
                    <script language="javascript">ComSheetObject('sheet1');</script>
                  </td>
                </tr>
              </table>
              <!-- : ( Grid ) (E) -->
            </td>
          </tr>
        </table>
        <!-- : ( Search Options ) (E) -->

      </td>
    </tr>
  </table>
  <!-- OUTER - POPUP (E)nd -->


<table class="height_5"><tr><td></td></tr></table>


<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>

				<!-- Repeat Pattern -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>

				<td class="btn1_line"></td>

				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
				<!-- Repeat Pattern -->

			</tr>
		</table>

	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->



</form>
</body>
</html>
