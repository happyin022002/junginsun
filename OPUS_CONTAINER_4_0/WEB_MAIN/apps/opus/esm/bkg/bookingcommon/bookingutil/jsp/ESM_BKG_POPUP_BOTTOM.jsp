<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_POPUP_TITLE.jsp
*@FileTitle : ESM_BKG_POPUP_TITLE
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.19
*@LastModifier : KIM TAE KYOUNG
*@LastVersion : 1.0
* 2010.02.19 KIM TAE KYOUNG
* 1.0 Creation	
=========================================================*/
%>
<%
	if(!mainPage.equals("true")){
%>
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
				<tr>
					<td class="btn3_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
										<td class="btn1" name="btn_Close" onClick="self.close()">Close</td>
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
<script>
	if(typeof(document.getElementById("title")) != "undefined"){
		document.getElementById("title").innerHTML = curTitle;
		document.body.className ="popup_bg";
	}
</script>
<%
}
%>					