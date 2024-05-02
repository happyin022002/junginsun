<%--
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_AGT_050.jsp
*@FileTitle : Container type 조회 및 다중 선택(Pop-up)
*Open Issues :
*Change history :
*@LastModifyDate : 2010-06-04
*@LastModifier : Sung-Jin Park
*@LastVersion : 1.0
* 2010-06-04 Sung-Jin Park
* 1.0 최초 생성
=========================================================*/ 
--%>
<%@ page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title></title>
</head>

<link href="/hanjin/css/alps_contents.css" rel="stylesheet" type="text/css">

<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>

<script language="javascript">

RdReport = "/hanjin/apps/alps/esm/agt/common/jsp/ESM_AGT_RDReport.jsp" ; 

function setupPage(){
var ClientWidth = document.body.clientWidth ;
var ClientHeight = document.body.clientHeight - 100 ;
document.all.rdTable.width = ClientWidth ;
document.all.rdTable.height = ClientHeight ;
rdOpen();
}
</script>
<body leftmargin="0px" rightMargin="0" topmargin="0" marginwidth="0" marginheight="0" scroll="yes" onload="setupPage()">

<br>
<table border=0>
	<tr>
		<td width=25></td>
		<td colspan="10"><img src="/hanjin/img/report_hanjin_logo.jpg"></td>
	</tr>
	<tr>
		<td width=25></td>
		<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
            <tr><td class="btn2_left"></td><td class="btn2" name="btn_save">Save</td><td class="btn2_right"></td></tr></table></td>
            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
            <tr><td class="btn2_left"></td><td class="btn2" name="btn_print">Print</td><td class="btn2_right"></td></tr></table></td>
		<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
            <tr><td class="btn2_left"></td><td class="btn2" name="btn_first">First</td><td class="btn2_right"></td></tr></table></td>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
            <tr><td class="btn2_left"></td><td class="btn2" name="btn_back">Back</td><td class="btn2_right"></td></tr></table></td>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
            <tr><td class="btn2_left"></td><td class="btn2" name="btn_next">Next</td><td class="btn2_right"></td></tr></table></td>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
            <tr><td class="btn2_left"></td><td class="btn2" name="btn_last">Last</td><td class="btn2_right"></td></tr></table></td>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
            <tr><td class="btn2_left"></td><td class="btn2" name="btn_zoomin">Zoom In(+)</td><td class="btn2_right"></td></tr></table></td>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
            <tr><td class="btn2_left"></td><td class="btn2" name="btn_zoomout">Zoom Out(-)</td><td class="btn2_right"></td></tr></table></td>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
            <tr><td class="btn2_left"></td><td class="btn2" name="btn_close">Close</td><td class="btn2_right"></td></tr></table></td>
	</tr>
</table>
<table id="rdTable" width="100%" height="100%">
	<tr>
		<td><script language="javascript">
comRdObjectPopup("Rdviewer");
</script></td>
	</tr>
</table>
<br>
<br>
<SCRIPT ID=clientEventHandlersJS LANGUAGE="JavaScript">

		/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	function processButtonClick(){

       // var rdObject = rdObjects[0] ;
		//var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			// form 이름에 주의하시기 바랍니다. 

				switch (srcName) {
					// 버튼 이름으로 case를 넣어 주셔야 합니다. 
					case "btn_save" :
						Rdviewer.SaveAsDialog();
						break;
					case "btn_print" :
						Rdviewer.PrintDialog();
						break;
					case "btn_first" :
						Rdviewer.FirstPage();
						break;
					case "btn_back" :
						Rdviewer.PrevPage();
						break;
					case "btn_next" :
						Rdviewer.NextPage();
						break;
					case "btn_last" :
						Rdviewer.LastPage();
						break;
					case "btn_zoomin" :
						Rdviewer.ZoomIn();
						break;
					case "btn_zoomout" :
						Rdviewer.ZoomOut();
						break;
					case "btn_close" :
						window.close();
						break;
	    
				} // end switch

		} catch(e) {
			if( e = "[object Error]") {
				ComShowCodeMessage('COM12111');
			} else {
				ComShowMessage(e);
			}
		}
	}

	function rdOpen() {

		var sXml = "";
		var sheetObj = new Array();
		var frmObj = new Array();
        var etcObj = "";
		sheetObj = parmModalObj[4] ;
		frmObj = parmModalObj[5] ;
		//Youn byong Suk 추가
		etcObj = parmModalObj[6] ;

	   // 복수개의 sheet, form object 를 배열로 받아서 처리
		sXml = "<?xml version='1.0' ?><SHEET>" ;

		sheetCnt = 1 ;
		for ( i= 0 ; i < sheetObj.length ; i++)
		{
		sheetCnt = i + 1 ;
		if( sheetObj[i].RowCount == 0){
			sXml += "<SHEET" + sheetCnt + "><DATA TOTAL='0'><TR>";
			for(j=0; j<= sheetObj[i].LastCol ; j++){
				sXml += "<TD></TD>";
			}
			sXml += "</TR></DATA></SHEET"+ sheetCnt +">";
		}else{
			sXml += RD_GetDataSearchXml(sheetObj[i], sheetCnt);
		}
		}
		sXml += "</SHEET>" ;

		var	mrdPath = parmModalObj[3];

		var formParam = "/rv "  ;
		for ( k = 0 ; k < frmObj.length ; k++)
		{
		formParam += RD_FormQueryString(frmObj[k], k+1);
		}

        //Youn byong Suk 추가
        if( etcObj != undefined ) {
             if( etcObj.length > 0 ) {
                formParam = formParam + etcObj;
            }
        }

		Rdviewer.AutoAdjust = false;
		Rdviewer.ZoomRatio = 90;
		Rdviewer.HideToolbar();
		Rdviewer.setbackgroundcolor(255,255,255);
		Rdviewer.setPageScroll(0);

		Rdviewer.SetRData(sXml);
		Rdviewer.FileOpen(mrdPath, RDServer + formParam);

	}
</SCRIPT>



</body>
</html>