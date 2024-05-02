<%--=========================================================================
'ì£¼  ì ì¤ í : ê³µíµ
'ìë¸  ìì¤í : 
'íë¡ê·¸ë¨ ID  : IBS_common.jsp
'íë¡ê·¸ë¨ ëª  : 
'íë¡ê·¸ë¨ê°ì : 
'ì   ì±   ì : 
'ì   ì±   ì¼ : 2007.10.25
=============================================================================
'ìì ì/ìì ì¼ :
'ìì ì¬ì /ë´ì­ :
=========================================================================--%>
<%@ page import="com.hanjin.syscommon.common.ibsheet.IbSheetUtil"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil" %> 
<%
	IbSheetUtil util = IbSheetUtil.getInstance();
	String mode = request.getParameter("ibs_udataMode");
	String usr_id = request.getParameter("ibs_udataUsrId"); 
	String scrn_id = request.getParameter("ibs_udataScrnId"); 
	String sh_id = JSPUtil.getParameter(request, "ibs_udataShId"); 
	String hdr_desc = JSPUtil.getParameter(request, "ibs_udataHdrDesc");
	String hdr_len_ctnt = JSPUtil.getParameter(request, "ibs_udataHdrLenCtnt");

		String[] arrTmp = hdr_desc.split("[|][|]");
		out.println(arrTmp.length);
		if(arrTmp.length ==2){
			hdr_desc = arrTmp[0];
			hdr_len_ctnt = arrTmp[1];
			//out.println("hdr_len_ctnt");
		}

	try {
		out.clear();
		
		if("SAVE".equals(mode)) {
			util.saveIbSetting(usr_id, scrn_id, sh_id, hdr_desc, hdr_len_ctnt);
			out.print("SUCCESS");
		} else if("DEL".equals(mode)) {
			util.delIbSetting(usr_id, scrn_id, sh_id);
			out.print("SUCCESS");
		} else if("SEARCH".equals(mode)) {
			hdr_desc = util.searchIbSetting(usr_id, scrn_id, sh_id);
			String[] arrTmp2 = hdr_desc.split("[|][|]");
			if(arrTmp2.length ==2){
				hdr_desc = arrTmp2[0];
				hdr_len_ctnt = arrTmp2[1];
			}
			//out.print(sh_id + "::" + hdr_desc);


%>
			<script>
				
				var colSeq = "";
				var colSize = "";
				
				var sh_id = "<%=sh_id%>";
				var hdr_desc = "<%=hdr_desc%>";
				var hdr_len_ctnt = "<%=hdr_len_ctnt%>";
				
				if(hdr_desc != null && hdr_desc != "" && hdr_len_ctnt != null && hdr_len_ctnt != "") {
					var sheetObj = parent.document.all[sh_id];
					
					//var arrVal = hdr_desc.split("||");
					
					//if(arrVal.length == 2) {
						
						//colSeq = arrVal[0];
						colSeq = hdr_desc;
						
						//colSize = arrVal[1];
						colSize = hdr_len_ctnt;
						
						// 1. Column 배열 순서
						var arrValSeq = colSeq.split("|");
						if(sheetObj.LastCol + 1 == arrValSeq.length) {
							for(var i=0; i<arrValSeq.length; i++) {	
								sheetObj.MoveColumnPos(arrValSeq[i], i);
							}
											
							// 2. Column size
							arrValSize = colSize.split("|");
							if(sheetObj.LastCol + 1 == arrValSize.length) {
								for(var i=0; i<arrValSize.length; i++) {	
									sheetObj.ColWidth(i) = arrValSize[i];
								}
							}
						}
					//}
				}
			</script>		
<% 
		}
	} catch(Exception e) {
		out.println("ERROR");
	}
%>


