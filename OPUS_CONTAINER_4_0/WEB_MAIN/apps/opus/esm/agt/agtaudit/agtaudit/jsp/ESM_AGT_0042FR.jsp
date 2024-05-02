<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_042FR.jsp
*@FileTitle : Other Commission Request
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-18
*@LastModifier : JungHyung, Kim
*@LastVersion : 1.0
* 2007-01-18 JungHyung, Kim
* 1.0 최초 Insert
=========================================================*/
--%>

<%--
=========================================================================
Form Control중 A/R Office ComboBox가 변경시 Subject Office ComboBox를 재세팅한다.
=========================================================================
'[Table]
'	MDM_DTL_REV_LANE
'[JSP Code]
'	<iframe height="0" width="0" name="frmHidden"></iframe>
'	<input type="hidden" name="param1"><!-- ComboUtil에서 사용하는 codeItem -->
'	<input type="hidden" name="param2"><!-- All Display 유무(Y, N, [All])   -->
'	<input type="hidden" name="param3"><!-- Object Name  -->
'	<input type="hidden" name="param4"><!-- Trade Code   -->
'	...
'	
'	<td><%//<img class="nostar">%>Subject Office</td>
'	<td><div id="div_sbOfcCd"><%= sbOfcCd %></div></td>
'
'[JavaScript Code]
'	formObj.param1.value = <<codeItem>>;
'	formObj.param2.value = <<All 유무>>;
'	formObj.param3.value = <<Object Name>>;
'	formObj.param4.value = <<A/R Office Code>>;
'	formObj.target = "frmHidden";
'	formObj.action = "ESM_AGT_010FR.do";
'	formObj.submit();
=========================================================================
--%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.apps.opus.esm.agt.common.CodeUtil"%>
<%@ page import="com.clt.apps.opus.esm.agt.common.event.CommonEvent"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.agt.agtaudit.agtaudit.event.EsmAgt0042Event"%>
<%@ page import="org.apache.log4j.Logger"%>


<%
	String arOfcCd = "";
	String vendor = "";
	String vndrSeq = "";
	String vndrCnt = "";
	String name = "";
	String office = "";
	String city = "";
	String center = "";
	String curr = "";
	HashMap<String, String> rtnHash = new HashMap<String, String>();
	String gubun = "";

	String ofcCd = "";
	String aplyDt = "";
	String xchRt = "";

	String strErrMsg = "";
	CommonEvent event = null;
	Exception serverException = null;

	try {
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		} else {
			event = (CommonEvent) request.getAttribute("Event");

			if (event != null) {
				arOfcCd = event.getString("param1");
				gubun = event.getString("gubun");

				//Optional한 AR_Office의 Vendor,Name,Office,City,Center,Currency 정보를 구한다.
				rtnHash = CodeUtil.getInstance().getOfficeInfo(arOfcCd);

				vendor = (String)rtnHash.get("vendor");
				vndrCnt = vendor.substring(0, 2);
				vndrSeq = vendor.substring(2);
				name = (String)rtnHash.get("name");
				office = (String)rtnHash.get("office");
				city = (String)rtnHash.get("city");
				center = (String)rtnHash.get("center");
				curr = (String)rtnHash.get("curr");

				if (!vendor.equals("")) {
					if (gubun.equals("RE")) {
						ofcCd = office;
						aplyDt = event.getString("param2");

						// Insert Office, Apply Date의 xchRt를 구한다.
						xchRt = CodeUtil.getInstance().getXchRt(
								ofcCd, aplyDt);
						
					}
				}
			}
		}
	} catch (Exception e) {
		out.println(e.toString());
	}
%>


<script language="javascript">
	<%if (!vendor.equals("")) {%>
		parent.document.getElementById("param3").value = "<%=vndrCnt%>";
		parent.document.getElementById("param4").value = "<%=vndrSeq%>";
		parent.document.getElementById("param5").value = "<%=name%>";
		parent.document.getElementById("param6").value = "<%=office%>";
		parent.document.getElementById("param7").value = "<%=city%>";
		parent.document.getElementById("param8").value = "<%=center%>";
		parent.document.getElementById("param9").value = "<%=curr%>";
	<%}%>
	<%if (gubun.equals("RE")) {%>		
			parent.setValue();
			parent.document.getElementById("param10").value = "<%=xchRt%>";
			parent.setXchRt();
			parent.checkOfficeInfo();
	<%} else {%>
			parent.checkOfficeInfo();
	<%}%>

</script>