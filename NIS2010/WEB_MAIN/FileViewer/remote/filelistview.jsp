<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<%
try{
	String dir = request.getParameter("filepath");
	String regexStr = request.getParameter("reg_name");
	String server = request.getParameter("server");
	String port = request.getParameter("port");
	
	System.out.println("filelistview.server ->" + server);
	System.out.println("filelistview.port ->" + port);
    System.out.println("filelistview.filepath ->" + dir);
    System.out.println("filelistview.reg_name ->" + regexStr);
%>
<html>
<head>
<title>File List</title>
</head>

<script language="javascript">
	var filePathSort = true;
	var fileDateSort = true;
	
	function getFileList(filepath){
		var frm = parent.document.forms[0];
        frm.filepath.value=filepath;
        parent.doAction();
	}

    function getFileContents(filepath){
        var frm = document.forms[0];
        frm.filepath.value=filepath;
        frm.action = "fileview.jsp";
        frm.submit();
    }

	function tdcSort(sortKey){
		var hdrTitle = "";
		switch(sortKey){
			case 'filePath': {
				if ( !filePathSort ) {
					tdcElements.Sort = "+"+sortKey;
				} else {
					tdcElements.Sort = "-"+sortKey;
				}
				if ( filePathSort ) {
					hdrTitle = "File Path ▼"
				} else {
					hdrTitle = "File Path ▲"
				}
				
				filePathSort = !filePathSort;	
				document.getElementById("hdrFilePath").innerText = hdrTitle;		
			}
			break;
			
			case 'fileDate': {
				if ( !fileDateSort ) {
					tdcElements.Sort = "+"+sortKey;
				} else {
					tdcElements.Sort = "-"+sortKey;
				}
				if ( fileDateSort ) {
					hdrTitle = "Last Modified ▼"
				} else {
					hdrTitle = "Last Modified ▲"
				}
				fileDateSort = !fileDateSort;
				document.getElementById("hdrFileDate").innerText = hdrTitle;		
			}
			break;
		}
		tdcElements.Reset();
	}
	
</script>

<SCRIPT FOR=tdcElements EVENT=ondatasetcomplete >
	document.getElementById('spanElemCount').innerText = tdcElements.recordset.recordCount;
</SCRIPT>

<!-- Tabuler Data Control -->

    <OBJECT id=tdcElements CLASSID="clsid:333C7BC4-460F-11D0-BC04-0080C7055A83">
		<PARAM NAME="UseHeader" VALUE="True">
		<PARAM NAME="FieldDelim" VALUE="^">
		<PARAM NAME="CharSet" VALUE="utf-8">
		<PARAM NAME="UseHeader" VALUE="True">
    </OBJECT>
    
    <script>
	     document.tdcElements.DataURL = "filelist.jsp?server=<%=server%>&port=<%=port%>&filepath=<%=dir%>&reg_name=<%=regexStr%>";
	     document.tdcElements.Reset();
    </script>
<body>    
   <table width="100%" border="0" cellspacing="0" cellpadding="0" class="simple2" Height="22">
     <tr>
         <td align="right">
             <input type="button" ID=cmdfirstPage onclick="tblElements.firstPage()"
                 VALUE=" << " class="btn_top03" id="Button4"/>
             <input type="button" ID=cmdpreviousPage onclick="tblElements.previousPage()"
                 VALUE=" < "class="btn_top03" id="Button4"/>
             <input type="button" ID=cmdnextPage onclick="tblElements.nextPage()"
                 VALUE=" > "class="btn_top03" id="Button4"/>
             <input type="button" ID=cmdlastPage onclick="tblElements.lastPage()"
                 VALUE=" >> "class="btn_top03" id="Button4"/> &nbsp;Total : <SPAN ID=spanElemCount></SPAN> &nbsp;&nbsp;  
         </td>
     </tr>
   </table>
            
   <TABLE width="100%" ID=tblElements DATASRC=#tdcElements DATAPAGESIZE=20 >
	   <THEAD>
	   <TR STYLE="font-weight:bold">
	   	<td id="hdrFilePath" colspan="2" align="center" style="width:50%;" onmouseover="this.style.cursor='hand'" onmouseout="this.style.cursor='default'" onclick="javascript:tdcSort('filePath');">File Path</td>
		<td align="right" style="width:5%;" >Permission</td>
		<td align="right" style="width:15%;" >Size</td>
		<td id="hdrFileDate" align="right" style="width:20%;" onmouseover="this.style.cursor='hand'" onmouseout="this.style.cursor='default'" onclick="javascript:tdcSort('fileDate');">Last Modified</td>
	   </TR>
	   </THEAD>
	   <TBODY>
	   <TR>
	      <TD align="left" style="width:2%;"><IMG width='15' height='15' align='absmiddle' DATAFLD="image"></TD>
	      <TD align="left" style="width:48%;"><A DATAFLD="linkFilePath"><DIV DATAFLD="filePath"></DIV></A></TD>
	      <TD align="right" style="width:5%;"><DIV datafld="fileRole" dataformatas="text"></DIV></TD>
	      <TD align="right" style="width:15%;"><DIV datafld="fileSize" dataformatas="text"></DIV></TD>
	      <TD align="right" style="width:20%;"><DIV datafld="fileDate" dataformatas="text"></DIV></TD>
	   </TR>
	   </TBODY>
   </TABLE>
<form name="form" method="post">
	<input type="hidden" name="filepath"/>
	<input type="hidden" name="server" value="<%=server%>"/>
	<input type="hidden" name="port" value="<%=port%>"/>
	<input type="hidden" name="readpos" value="0" /> 
	<input type="hidden" name="command" value="last" /> 
	<input type="hidden" name="readbyte" value="20000" />	
</form>
</body>
</html>
<%
}catch(Exception e){
	e.printStackTrace();
}
%>