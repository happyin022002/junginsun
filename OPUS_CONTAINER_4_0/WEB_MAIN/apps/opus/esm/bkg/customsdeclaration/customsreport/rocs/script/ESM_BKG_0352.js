﻿/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : esm_bkg_0352.js
*@FileTitle : esm_bkg_0352
*Open Issues :
*Change history :
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author
     */


   	/* 개발자 작업	*/

//	var rdObjects = new Array();
//	var rdCnt = 0;


	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
//	    var rdObject = rdObjects[0];
	    var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

    		switch(srcName) {
				case "btn_print":
					viewer.print({isServerSide:true});
					break;
				case "btn_close":
					window.close();
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


    function loadPage() {
    	var formObject = document.form;
		//var bl_no = formObject.bl_no.value;	 HTML5 인하여 주석처리
		var bl_no = loadBlNo(formObject.bl_no.value);
		var param = "/rp [" + bl_no + "]";
//		var param = bl_no;
//    	initRdConfig(rdObjects[0]);    	HTML5 인하여 주석처리
//    	rdOpen(rdObjects[0], document.form, param); HTML5 인하여 주석처리
		rdOpen(document.form, param);
	}

    function loadBlNo(bl_no)
    {
    	var strResult = "";

		var arrRow = bl_no.split("|");

		for (idx=0; idx<arrRow.length-1; idx++) {
			strResult += "'" + arrRow[idx] + "',";
		}
		var ii = strResult.lastIndexOf(",");
		strResult = strResult.substring(0,ii);
		return strResult;
    }


//	function initRdConfig(rdObject){			HTML5 인하여 주석처리
//		var Rdviewer = rdObject;
//		Rdviewer.AutoAdjust = true;
//		Rdviewer.ViewShowMode(0);
//		Rdviewer.SetBackgroundColor(128,128,128);
//		Rdviewer.SetPageLineColor(128,128,128);
//		Rdviewer.ApplyLicense("0.0.0.0");
//}

	function rdOpen(formObject, param){
//		var Rdviewer = rdObject; HTML5 인하여 주석처리
		var rdParam = param +  " /riprnmargin /rwait";
		var strPath = RD_path+"apps/opus/esm/bkg/customsdeclaration/customsreport/rocs/report/ESM_BKG_0352.mrd";
		ComOpenWait(true);
		viewer.openFile(strPath, RDServer + rdParam,{timeout:1800});
		ComOpenWait(false);
	}