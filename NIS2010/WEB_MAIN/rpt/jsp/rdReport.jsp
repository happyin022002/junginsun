<%--=========================================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : rdReport.jsp
*@FileTitle : Report Common
=========================================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title></title>
</head>

<link href="/hanjin/css/alps_contents.css" rel="stylesheet" type="text/css">

<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>

<script language="javascript">

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
		<td class="btn1" name="" OnClick="Save_OnClick()"><a href="#">Save</a></td>
		<td class="btn1" name="" OnClick="Print_OnClick()"><a href="#">Print</td>
		<td class="btn1" name="" OnClick="First_OnClick()"><a href="#">First</td>
		<td class="btn1" name="" OnClick="Prev_OnClick()"><a href="#">Back</td>
		<td class="btn1" name="" OnClick="Next_OnClick()"><a href="#">Next</td>
		<td class="btn1" name="" OnClick="Last_OnClick()"><a href="#">Last</td>
		<td class="btn1" name="" OnClick="ZoomIn_OnClick()"><a href="#">Zoom In(+)</td>
		<td class="btn1" name="" OnClick="ZoomOut_OnClick()"><a href="#">Zoom Out(-)</td>
		<td class="btn1" name="" OnClick="Close_OnClick()"><a href="#">Close</td>
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

	img_cnt = 9;
	first_img =new Array(img_cnt + 1);
	for (var i = 1; i<=img_cnt; i++) {first_img[i] = new Image() }
	first_img[1].src = "/hanjin/img/menu/save_1.gif"
	first_img[2].src = "/hanjin/img/menu/print_1.gif"
	first_img[3].src = "/hanjin/img/menu/first_1.gif"
	first_img[4].src = "/hanjin/img/menu/back_1.gif"
	first_img[5].src = "/hanjin/img/menu/next_1.gif"
	first_img[6].src = "/hanjin/img/menu/last_1.gif"
	first_img[7].src = "/hanjin/img/menu/zoomin_1.gif"
	first_img[8].src = "/hanjin/img/menu/zoomout_1.gif"
	first_img[9].src = "/hanjin/img/menu/close_1.gif"

	over_img =new Array(img_cnt + 1);
	for (var i = 1; i<=img_cnt; i++) { over_img[i] = new Image() }
	over_img[1].src = "/hanjin/img/menu/save_2.gif"
	over_img[2].src = "/hanjin/img/menu/print_2.gif"
	over_img[3].src = "/hanjin/img/menu/first_2.gif"
	over_img[4].src = "/hanjin/img/menu/back_2.gif"
	over_img[5].src = "/hanjin/img/menu/next_2.gif"
	over_img[6].src = "/hanjin/img/menu/last_2.gif"
	over_img[7].src = "/hanjin/img/menu/zoomin_2.gif"
	over_img[8].src = "/hanjin/img/menu/zoomout_2.gif"
	over_img[9].src = "/hanjin/img/menu/close_2.gif"

	function msover(num) {
		document.images[num].src = over_img[num].src
	}

	function msout(num) {
		document.images[num].src =first_img[num].src
	}

	function Save_OnClick() {
		Rdviewer.SaveAsDialog();
	}

	function Print_OnClick() {
		Rdviewer.PrintDialog();
	}

	function First_OnClick() {
		Rdviewer.FirstPage();
	}

	function Prev_OnClick() {
		Rdviewer.PrevPage();
	}

	function Next_OnClick() {
		Rdviewer.NextPage();
	}

	function Last_OnClick() {
		Rdviewer.LastPage();
	}

	function ZoomIn_OnClick() {
		Rdviewer.ZoomIn();
	}

	function ZoomOut_OnClick() {
		Rdviewer.ZoomOut();
	}

	function Close_OnClick() {
		window.close();
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