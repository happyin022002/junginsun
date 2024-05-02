/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0893.js
*@FileTitle : Wharfage 신고서
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.16
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.04.16 정재엽
* 1.0 Creation
=========================================================*/
// 공통전역변수
var docObjects = new Array();
var sheetCnt = 0;

var rdObjects = new Array();
var rdCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러  정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				case "btn_Close":
					window.close();
					break;
				case "btn_Print":					
					rdObjects[0].PrintDialog();
					break;
            } // end switch
    	}catch(e) {
    	}
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage(rdData) {
    	rdOpen(rdData);
    }
     
    /**
     * print화면 오픈
     * print화면 오픈
     * print할수 있는 화면 오픈
     */
	function rdOpen(rdData){
		var opener_obj = opener;
		var Rdviewer = rdObjects[0];
		var xmldata = "<?xml version=\"1.0\" encoding=\"euc-kr\"?><root><startdate>20080101</startdate><enddate>20081231</enddate><today>20090113</today><table1>	<a>		<a1>100 </a1>		<a2> 200</a2>		<a3>300 </a3>		<a4>400 </a4>		<a5>500 </a5>	</a></table1></root>";

		if (location.hostname == "localhost") {
			RD_path = "http://localhost:7001/hanjin/";
		}
	    var mrdpath = RD_path+"apps/alps/esm/bkg/wharfagemgt/wharfagedecmgt/report/ESM_BKG_0893.mrd" ;
	    
        Rdviewer.AutoAdjust = true;
	    Rdviewer.ViewShowMode(0); 
	    Rdviewer.setbackgroundcolor(128,128,128);
	    Rdviewer.SetPageLineColor(128,128,128);
	    Rdviewer.SetNoDataDialogInfo (0, "", ""); //데이터 없음 메시지 창 숨김
	    //Rdviewer.FileOpen(mrdpath,"/rdata [14.000^0.000^0.000^0.000^0.000^0.000^4.000^0.000^0.000^0.000^0.000^0.000^0.000^4.000^161,280^161,280^17.000^0.000^0.000^0.000^0.000^0.000^0.000^0.000^0.000^0.000^0.000^0.000^0.000^2.222^0.000^0.000^0.000^0.000^0.000^0.000^0.000^0.000^0.000^0.000^0.000^0.000^0.000^3.333^ANRBS^AENA0052W^TES_ANRBS^2008-07-20^] /rnl[~]");
	    Rdviewer.FileOpen(mrdpath,rdData);
		
	}