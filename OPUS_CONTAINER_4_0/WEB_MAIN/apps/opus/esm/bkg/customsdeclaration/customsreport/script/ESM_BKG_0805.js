/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0805.jsp
*@FileTitle  : Container Loading/Discharging Cross-Check (EDI) Print
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/18
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var rdObjects = new Array();
	var rdCnt = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         var sheetObject1 = sheetObjects[0];
         var formObject = document.form;

    	try {
    		var srcName = ComGetEvent("name");
                                          
    		switch(srcName) {
				case "btn_print":
					rdPrint();
					break; 
				case "btn_close":
					ComClosePopup();
					break;
            } // end switch
    		
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
     function loadPage(vvd, pol, etd) {
    	rdOpen();
     }

	/*
	* RD 오픈  및 미리보기
	*/
	function rdOpen(){
		var sXml = "";		
		//var opener_obj = opener;
		//var form1 = opener_obj.document.form;
		//var opener_sheet_obj1 =  opener_obj.document.sheet2;
		
		var opener_obj = opener;
		if (!opener_obj) opener_obj=parent;
		var opener_sheet_obj1 = opener_obj.sheet2;
		sXml = "<?xml version='1.0' ?><SHEET>";
		sXml +=RD_GetDataSearchXml(opener_sheet_obj1, 1);
		sXml +="\n<ETC>" ;
		sXml +="<TEMP>TEMP</TEMP>";
		sXml +="</ETC>";
		sXml +="</SHEET>";
		
		//alert(sXml);
		
		

		//rdObjects[0].AutoAdjust = true;
		//rdObjects[0].HideToolBar();
		//rdObjects[0].HideStatusBar();
		//rdObjects[0].ViewShowMode(0); 

		//rdObjects[0].SetBackgroundColor(128,128,128);
		//rdObjects[0].SetPageLineColor(128,128,128);
		
		viewer.setRData(sXml);
		var urlPath = RD_path+'apps/opus/esm/bkg/customsdeclaration/customsreport/report/ESM_BKG_0805.mrd';
		
		//urlPath = "http://localhost:9001/opuscntr/apps/opus/esm/bkg/customsdeclaration/customsreport/report/ESM_BKG_0805.mrd";
		
		viewer.openFile(urlPath ,RDServer, {timeout:1800});
		
	}
	
	/**
	 * RD 출력
	 * @param rdObject
	 * @return
	 */
	function rdPrint() {
		viewer.print({isServerSide:true});
	}
	
    
