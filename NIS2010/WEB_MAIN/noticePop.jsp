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
	function setCookie( name, value, expiredays ) 
	{ 
			var todayDate = new Date(); 
			todayDate.setDate( todayDate.getDate() + expiredays ); 
			document.cookie = name + "=" + escape( value ) + "; path=/; expires=" + todayDate.toGMTString() + ";" 
			} 

	function closeWin() 
	{ 
			if ( document.pop.Notice.checked ) 
			setCookie( "Notice", "done" , 1);  // 오른쪽 숫자는 쿠키를 유지할 기간을 설정합니다
			self.close(); 
	}
	
	function noticeDetail() {
		window.open("noticeDetailPop.jsp","_blank","toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=yes, resizable=no, copyhistory=no, width=905, height=690");
		//ComOpenWindowCenter('noticeDetailPop.jsp', 'noticeDetail', 860, 500, false, 1);
	}
	
	
	
</script>
<script type="text/javascript">
    self.window.focus();
</script>
</head>
<body> 
<table class="search" id="mainTable">
	<tr>
		<td class="bg">	
			<table class="search" border="0" style="width:430;">
				<tr class="h23">
					<td>
						<img src="img/notice.jpg" />
					</td>	
				</tr>
			</table>
		</td>
	</tr>
</table>

<table width="100%" class="sbutton">
<tr>
	<td height="71" class="popup">
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	   		<tr>
	   			<td class="btn3_bg">
			    	<table width="100%" class="search" border="0" cellpadding="0" cellspacing="0" style="padding-top: 0; , padding-bottom: 0;">
					<tr>
						<td class="btn3_bg">
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td width="150">
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td><a href="javascript:noticeDetail();"><font size="4">Click for Details</font></a></td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
						<td class="btn3_bg" width="250">
							<table border="0" cellpadding="0" cellspacing="0" class="button">
							<form name="pop"> 
								<input type="checkbox" name="Notice" value="">Do not open the pop-up window today.   
							</form>
							</table>
						</td>
						<td class="btn3_bg"  width="100">
							<table border="0" cellpadding="0" cellspacing="0" class="button">
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


</body>
</html>