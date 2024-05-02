<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@page import="com.hanjin.framework.core.config.SiteConfigFactory"%>
<html>
<head>
<link href="/hanjin/css/alps_contents.css" rel="stylesheet" type="text/css"/>
<link href="/hanjin/css/alps_menu.css" rel="stylesheet" type="text/css"/>
<link href="/hanjin/css/alps_contents.css" rel="stylesheet" type="text/css"/>
<title>Notice for Group Standard Code Enforcement</title>
<script>
	function closeWin() 
	{ 
			self.close(); 
	} 
</script>
</head>
<body> 
<table class="search" id="mainTable">
	<tr>
		<td class="bg">	
			<table class="search" border="0" style="width:430;">
				<tr class="h23">
					<td>
						<img src="img/noticeDetail.jpg" />
					</td>	
				</tr>
			</table>
		</td>
	</tr>
</table>

<!-- : ( Button : pop ) (S) -->
		<table width="100%" class="sbutton">
			<tr>
				<td height="71" class="popup">
				<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 0; , padding-bottom: 0;">
					<tr>
						<td class="btn3_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td width="200">
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<form name="form" action="/hanjin/FileDownload" method="post">
									<tr>
										<td class="btn1_left"></td>
										<td class="btn1" onclick="form.submit()">
											<input type="hidden" name="<%=SiteConfigFactory.get("COM.FILE.DOWNLOAD.KEY") %>"  value ="pkpcfp_20150818101050141.xlsx" size="55" >
											DownLoad Attachment
										</td>
										<td class="btn1_right"></td>
									</tr>
									</form>
								</table>
								</td>
								<td width="72">
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn1_left"></td>
										<td class="btn1" onClick="closeWin()">CLOSE</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
								</td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>



</body>
</html>