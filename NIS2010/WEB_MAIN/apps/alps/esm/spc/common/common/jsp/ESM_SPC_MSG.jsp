<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_SPC_MSG.jsp
*@FileTitle : 메시지 내용이 길어서 스크롤 하거나 clipboard에 copy해서 봐야 할경우 쓰이는 메시지 창
*Open Issues :
*Change history :
*@LastModifyDate : 2007-05-28
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2007-05-28 송민석
* 1.0 최초 생성
=========================================================*/
%>
<%
	String windowType = request.getParameter("windowType");
%>
<%@ page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>Message Window</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function initPage(){
		loadPage();
	}
</script>

</head>

<body onLoad="initPage()">
<form name=form>
<!-- OUTER FRAME : "to make sum of components' HEIGHTS 100%" (S)tart -->
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
<tr><td valign="top">


	<table style='border-collapse: collapse; width:100%; height:100%;padding:6px; background-color:#FFFFFF; border:2px solid #A3A4C7;'> 
       	<tr><td style='WIDTH: 100%' > 
    
                
			<table style='border-collapse: collapse;width:100%;HEIGHT:100%; border:1px solid #A3A4C7;background-color:#C0EBA3;' border='1'  ><tr><td> 
				<table style='border-collapse: collapse;width:100%;HEIGHT: 100%;border:1px solid #A3A4C7;' border='1'  >    
        		<tr style='height:23;font-family: Arial;  font-size: 10px;text-align:center; color: #636363;background-color:#FFFFFF;border:1px solid #A3A4C7; '> 
    					<td width='30%' style='border:1px solid #A3A4C7;HEIGHT: 100%'> <textarea name=msg style="WIDTH:100% ;HEIGHT: 100%;border:2px" readonly onChange="document.form.msg.scrollTop=0;"></textarea> </td> 
    			</tr>         
				</table> 
				</td> 
				</tr>	 			
			</table> 
       	</td>                
		</tr  > 
       	<tr><td  style='WIDTH: 100%; HEIGHT: 26'>        
 
			<table style='width:100% ;height:1px'>
				<tr>
					<td style='height:1px'></td>
				</tr>
			</table>
        
			<table style='width:100% ;height:25'>
				<tr>
					<td style='padding:6px; background-color:#FFFFFF; border:1px solid #A3A4C7;'> 
						<table   style='width:100%; height:25'>
							<tr>
<% if( "1".equals(windowType) ){ %>							
								<td align=center><img class='cursor' src='/hanjin/img/button/btn_ok.gif' width='66' height='20' border='0' name='btn_ok' ></td>
								<td align=center><img class='cursor' src='/hanjin/img/button/btn_cancel.gif' width='66' height='20' border='0' name='btn_cancel'></td>
<%}else{ %>								
								<td align=center><img class='cursor' src='/hanjin/img/button/btn_close.gif' width='66' height='20' border='0' name='btn_close' ></td>
<%} %>								
								<td align=center><img class='cursor' src='/hanjin/img/button/btn_copytoclipboard.gif' width='130' height='20' border='0' name='btn_copy' ></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
    

        
		</td> 
		</tr>	 		 
 	</table>                

 
</td></tr>
</table>
</form>	

</body>
</html>
