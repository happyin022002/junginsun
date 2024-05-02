<%--/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : COM_ENS_COMMON.jsp
*@FileTitle : 업무공통 모듈에서 사용하는 공통 Iframe Function 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-29
*@LastModifier : HyungChoonRoh
*@LastVersion : 1.0
* 2006-11-29 HyungChoonRoh
* 1.0 최초 생성
=========================================================*/--%>
<%@ page import="java.util.*"%>
<script>
/**
 * @type   : function
 * @access : public
 * @desc   : 해당 Object의 상위 Object를 반환한다.
 * <pre>사용예 :
 *
 *     insertRow(oInput, "TABLE");
 *
 *     - oInput   : HTML Object
 *     - "TABLE"  : HTML Object의 상위 Object중 TABLE을 찾는다.
 * </pre>     
 * @sig    : 
 * @param  : TBL
 * @return : Object (Object를 찾지 못한 경우 null 리턴)
 * @author : raika
 */
function getParentNode(srcObj, parentTagName) {
	var targetObj = srcObj;
	while(targetObj.parentNode && targetObj.parentNode.tagName) {
		targetObj = targetObj.parentNode;
		if((targetObj.tagName).toUpperCase() == parentTagName.toUpperCase()) {
			break;
		}
	}
	
	if((targetObj.tagName).toUpperCase() != parentTagName.toUpperCase()) {
		targetObj = null;
	}
	
	return targetObj;
}
</script>
<script>
<%	
	String func = "SCONTI";//request.getParameter("func");
	if("STE_COMBO".equals(func)) {
		String cnt_cd = request.getParameter("cnt_cd");
		String targetCombo = request.getParameter("targetCombo");
		String where = " cnt_cd = '" + cnt_cd + "' ";
		
		String strCombo = com.hanjin.bizcommon.util.BizComUtil.getCodeCombo(targetCombo, "", "", "STE", 1, "0: :ALL", where);
%>	
		var targetObj = parent.document.all['<%=targetCombo%>'];
		var targetCell = getParentNode(targetObj, "TD");
		targetCell.innerHTML = '<%=strCombo%>';
<%		
	} else if("SCONTI".equals(func)) {
		String conti_cd = request.getParameter("conti_cd");
		String targetCombo = request.getParameter("targetCombo");
		String where = " conti_cd = '" + conti_cd + "' ";
		
		String strCombo = com.hanjin.bizcommon.util.BizComUtil.getCodeCombo(targetCombo, "", "", "SCONTI", 1, "0: :ALL", where);
%>
		var targetObj = parent.document.all['<%=targetCombo%>'];
		var targetCell = getParentNode(targetObj, "TD");
		targetCell.innerHTML = '<%=strCombo%>';
<%
	} else if("CNT_VALID".equals(func)) {
		String cnt_cd = request.getParameter("cnt_cd");
		String sheetIdx = request.getParameter("sheetIdx");
		String row = request.getParameter("row");
		String col = request.getParameter("col");
		
		String cnt_nm = com.hanjin.bizcommon.util.BizComUtil.getCodeVal("CNT", cnt_cd);
		
		if(cnt_nm == null || cnt_nm.equals("")) {
%>
			showErrMessage("Country Code is invalid.");
			var targetSheet = parent.docObjects[parseInt(<%=sheetIdx%>, 10)];
			targetSheet.SelectCell(parseInt(<%=row%>, 10), parseInt(<%=col%>, 10), true);
<%
		} else {
%>
			var targetSheet = parent.docObjects[parseInt(<%=sheetIdx%>)];
			targetSheet.CellValue2(parseInt(<%=row%>, 10),"cnt_nm") = "<%=cnt_nm%>";
			targetSheet.CellValue2(parseInt(<%=row%>, 10),"ste_cd") = "";
			targetSheet.CellValue2(parseInt(<%=row%>, 10),"ste_nm") = "";
<%
		}
	} else if("STE_VALID".equals(func)) {
		String ste_cd = request.getParameter("ste_cd");
		String sheetIdx = request.getParameter("sheetIdx");
		String row = request.getParameter("row");

		String ste_nm = com.hanjin.bizcommon.util.BizComUtil.getCodeVal("STE", ste_cd);
		
		if(ste_nm == null || ste_nm.equals("")) {
%>
			showErrMessage("State Code is invalid.");
			var targetSheet = parent.docObjects[parseInt(<%=sheetIdx%>, 10)];
			targetSheet.SelectCell(parseInt(<%=row%>, 10), "ste_cd", 10), true);
<%
		} else {
%>
			var targetSheet = parent.docObjects[parseInt(<%=sheetIdx%>)];
			targetSheet.CellValue2(parseInt(<%=row%>, 10),"ste_nm") = "<%=ste_nm%>";
<%
		}
	} else if("LOC_VALID".equals(func)) {
		String loc_cd = request.getParameter("loc_cd");
		String sheetIdx = request.getParameter("sheetIdx");
		String row = request.getParameter("row");

		String loc_nm = com.hanjin.bizcommon.util.BizComUtil.getCodeVal("LOC", loc_cd);
		String ste_cd = com.hanjin.bizcommon.util.BizComUtil.getCodeVal("STE_LOC", loc_cd);
		
		if(loc_nm == null || loc_nm.equals("")) {
%>
			showErrMessage("Location Code is invalid.");
			var targetSheet = parent.docObjects[parseInt(<%=sheetIdx%>, 10)];
			targetSheet.SelectCell(parseInt(<%=row%>, 10), "loc_cd", 10), true);
<%
		} else {
%>
			var targetSheet = parent.docObjects[parseInt(<%=sheetIdx%>)];
			targetSheet.CellValue2(parseInt(<%=row%>, 10),"loc_nm") = "<%=loc_nm%>";
			targetSheet.CellValue2(parseInt(<%=row%>, 10),"ste_cd") = "<%=ste_cd%>";
<%
		}
	} else if("STE_EXIST".equals(func)) {
		String cnt_cd = request.getParameter("cnt_cd");
		String sheetIdx = request.getParameter("sheetIdx");
		String row = request.getParameter("row");

		String existYn = com.hanjin.bizcommon.util.BizComUtil.getCodeVal("STE_EXIST", cnt_cd);
		
		if(existYn != null && existYn.equals("Y")) {
%>		
			var targetSheet = parent.docObjects[parseInt(<%=sheetIdx%>, 10)];
			targetSheet.CellEditable(parseInt(<%=row%>, 10), 'ste_cd') = true;
<%
		} else {
%>
			var targetSheet = parent.docObjects[parseInt(<%=sheetIdx%>)];
			targetSheet.CellEditable(parseInt(<%=row%>, 10), 'ste_cd') = false;
<%
		}
	} else if("LOC_EXIST".equals(func)) {
		String cnt_cd = request.getParameter("cnt_cd");
		String sheetIdx = request.getParameter("sheetIdx");
		String row = request.getParameter("row");

		String existYn = com.hanjin.bizcommon.util.BizComUtil.getCodeVal("LOC_EXIST", cnt_cd);
		
		if(existYn != null && existYn.equals("Y")) {
%>		
			var targetSheet = parent.docObjects[parseInt(<%=sheetIdx%>, 10)];
			targetSheet.CellEditable(parseInt(<%=row%>, 10), 'loc_cd') = true;
<%
		} else {
%>
			var targetSheet = parent.docObjects[parseInt(<%=sheetIdx%>)];
			targetSheet.CellEditable(parseInt(<%=row%>, 10), 'loc_cd') = false;
<%
		}
	} else if("CONTI_CNT".equals(func)) {
		String cnt_cd = request.getParameter("cnt_cd");
		String targetObj = request.getParameter("targetObj");

		String conti_cd = com.hanjin.bizcommon.util.BizComUtil.getCodeVal("CONTI_CNT", cnt_cd);
		
		if(conti_cd != null && !conti_cd.equals("")) {
%>		
			parent.document.all["<%=targetObj%>"].value = "<%=conti_cd%>";
<%
		}
	} else if("SVC_SCOPE".equals(func)) {
		String por = request.getParameter("por");
		String del = request.getParameter("del");
		String targetCombo = request.getParameter("targetCombo");
		String where = " T1.RGN_CD = '" + por + "' "
					 + " AND T2.RGN_CD = '" + del + "' ";
		
		String strCombo = com.hanjin.bizcommon.util.BizComUtil.getCodeCombo(targetCombo, "", "", "SVC_SCOPE", 1, "0: :ALL", where);
%>
		var targetObj = parent.document.all['<%=targetCombo%>'];
		var targetCell = getParentNode(targetObj, "TD");
		targetCell.innerHTML = '<%=strCombo%>';
<%
	}
%>
</script>
