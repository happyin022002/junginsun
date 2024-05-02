<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_017FR.jsp
*@FileTitle : Agent Commission AP Interface iFrame
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-30
*@LastModifier : Junghyung_kim
*@LastVersion : 1.0
* 2006-11-30 Junghyung_kim
* 1.0 최초 생성
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
'	<td><img class="nostar">Subject Office</td>
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
<%@ page import="com.hanjin.framework.component.util.JSPUtil" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.Utils" %>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.ComboUtil"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.CodeUtil"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.event.CommonEvent" %>

<%
	String codeItem   = "";
	String objectNm   = "";
	String searchCd	  = "";
	String isAll	  = ""; 
	String strErrMsg  = "";
	String flag       = "";
	String offsetFlag = "";
	String sbOfcCd 	  = "";
	String asaNo      = "";
	String vendor     = "";
	CommonEvent event = null;
	Exception serverException = null;
	
	try{
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if(serverException != null){
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} else {
			event = (CommonEvent)request.getAttribute("Event");
			
			if(event != null){
				codeItem = event.getString("param1");
				isAll    = Utils.iif(event.getString("param2") == null, "", event.getString("param2"));
				objectNm = event.getString("param3");
				searchCd = event.getString("param4");
				flag     = event.getString("param5");
				
				if(flag.equals("SUBOFC")){
					//Combo Data : getCodeCombo('태그명','초기값', '추가요소', '업무명', '조건코드', '전체유무', '추가옵션')
					//A/R Offce의 상계/분리대리점 구분 조회
					offsetFlag = CodeUtil.getInstance().getOffsetFlag(searchCd);
					//Subject Office 리스트 조회
					sbOfcCd = ComboUtil.getCodeCombo(objectNm, searchCd, "onChange='agn_cd_OnChange(this);' style='width:85;', class='input1'", codeItem, searchCd, isAll, "");
					//ASA No 리스트 조회
					asaNo   = ComboUtil.getCodeCombo("asa_no", "", " onChange='asa_no_OnChange();' style='width:400'", "asaNo", searchCd, "", "");
					//Vendor 정보 조회
					vendor  = CodeUtil.getInstance().getCodeInfo("vendor", searchCd);
				}else{
					//Combo Data : getCodeCombo('태그명','초기값', '추가요소', '업무명', '조건코드', '전체유무', '추가옵션') 
					// 2007.07.03 추가
					offsetFlag = CodeUtil.getInstance().getOffsetFlag(searchCd);
					//ASA No 리스트 조회
					if(offsetFlag.equals("Y")){
						asaNo   = ComboUtil.getCodeCombo(objectNm, "", " onChange='asa_no_OnChange();' style='width:400'", codeItem, searchCd, "", "");
					}else{
						asaNo   = "<SELECT name='asa_no'  onChange='asa_no_OnChange();' style='width:400'></SELECT>";
					}
					//Vendor 정보 조회
					vendor  = CodeUtil.getInstance().getCodeInfo("vendor", searchCd);
				}
			}
		}
		
	}catch(Exception e){
		out.println(e.toString());
	}

	
	if(flag.equals("SUBOFC")){
%>
<div id="div_sbOfcCd"><%= sbOfcCd %></div>
<div id="div_asaNo"><%= asaNo %></div>
<script language="javascript">
	parent.document.getElementById("offsetFlag").value = "<%= offsetFlag %>";
	parent.document.getElementById("div_sbOfcCd").innerHTML = div_sbOfcCd.innerHTML;
	parent.document.getElementById("div_asaNo").innerHTML = div_asaNo.innerHTML;
	parent.document.getElementById("txVendor").value = "<%= vendor %>";
	parent.asa_no_OnChange();
</script>
<%
	}else{
%>
<div id="div_asaNo"><%= asaNo %></div>
<script language="javascript">
	parent.document.getElementById("offsetFlag").value = "<%= offsetFlag %>";
	parent.document.getElementById("div_asaNo").innerHTML = div_asaNo.innerHTML;
	parent.document.getElementById("txVendor").value = "<%= vendor %>";
</script>
<%
	}
%>