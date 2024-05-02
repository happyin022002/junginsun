/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0955.jsp
*@FileTitle : Booking History (B/L Data)
*Open Issues : ESM_BKG_0955 화면
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.08.14 이남경
* 1.0 Creation 
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

    /**
     * @extends 
     * @class esm_bkg_0955 : esm_bkg_0955 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0955() {
    	this.processButtonClick = tprocessButtonClick;
    	this.loadPage 			= loadPage;
    	this.initRdConfig       = initRdConfig;
    	this.rdOpen             = rdOpen;
    }
    
   	/* 개발자 작업	*/
 
    // 공통전역변수    
//    var rdObjects = new Array();
    var rdCnt = 0;    
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){        
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				case "btn_print":					
					//rdObjects[0].PrintDialog();
					viewer.print({isServerSide:true});
					break;

				case "btn_close":
					ComClosePopup();
					break;
            }
    	}catch(e) {
    		ComShowMessage(e);
    	}
    }

    /**
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	var formObj = document.form;
    	var sheetIdx = ComGetObjValue(formObj.sheet_idx);
    	var sheetRow = ComGetObjValue(formObj.sheet_row);
    	
		var parentRefSheet;
		if (opener && opener.sheetObjects) parentRefSheet =opener.sheetObjects[sheetIdx]; 
		else if (parent && parent.sheetObjects) parentRefSheet =parent.sheetObjects[sheetIdx];
		
    	formObj.his_cate_nm.value=parentRefSheet.GetCellValue(sheetRow, "his_cate_nm");
    	formObj.crnt_ctnt.value=parentRefSheet.GetCellValue(sheetRow, "crnt_ctnt_org");
    	formObj.pre_ctnt.value=parentRefSheet.GetCellValue(sheetRow, "pre_ctnt_org");
    	formObj.cre_usr_id.value=parentRefSheet.GetCellValue(sheetRow, "cre_usr_id");
    	formObj.office.value=parentRefSheet.GetCellValue(sheetRow, "office");
    	formObj.cre_dt.value=parentRefSheet.GetCellValue(sheetRow, "cre_dt");
    	formObj.his_seq.value=parentRefSheet.GetCellValue(sheetRow, "his_seq");
    	formObj.his_dtl_seq.value=parentRefSheet.GetCellValue(sheetRow, "his_dtl_seq");
    	
//        initRdConfig(rdObjects[0]); 
        
        rdOpen      (viewer);
        
    }

    //######################[2. Etc]##############################################################
    /**
	 * Rd 설정
	 */
//	function initRdConfig(rdObject){
//		var RdViewer = rdObject;
//
//		RdViewer.AutoAdjust = true;
//		RdViewer.HideStatusBar();
//		RdViewer.ViewShowMode(0); 
//		RdViewer.SetBackgroundColor(128,128,128);
//		RdViewer.SetPageLineColor  (128,128,128);
//	}    
     
    /**
     * print할수 있는 화면 오픈
     */
 	function rdOpen(viewer) {
 		var formObj  = document.form;
 		var RdViewer = viewer;
 		
// 		var sXml = "";		
// 		sXml =  "<?xml version='1.0' ?>";
// 		sXml += "<SHEET>";
// 		sXml += "<ETC>" ;
// 		sXml += "<BKG_NO>"+formObj.bkg_no.value+"</BKG_NO>"
// 		sXml += "<BL_NO>"+formObj.bl_no.value+"</BL_NO>"
// 		sXml += "<ITEM>"+formObj.his_cate_nm.value+"</ITEM>"
// 		sXml += "<USRNM>"+formObj.cre_usr_id.value+"</USRNM>"
// 		sXml += "<OFFICE>"+formObj.office.value+"</OFFICE>"
// 		sXml += "<DT>"+formObj.cre_dt.value+"</DT>"
// 		/*sXml += "<CRNT_CTNT>"+formObj.crnt_ctnt.value+"</CRNT_CTNT>"
// 		sXml += "<PRE_CTNT>"+formObj.pre_ctnt.value+"</PRE_CTNT>"*/
// 		sXml += "</ETC>";
// 		sXml += "</SHEET>"; 	
 		
 		
 		//RdViewer.SetRData(sXml);
 		
 		var rdUrl      = "apps/opus/esm/bkg/bookingconduct/generalbookingconduct/generalbookingsearch/report/";
		var rdFileName = "ESM_BKG_5028.mrd";
		var rdParam    = "/rp ['"+formObj.bkg_no.value+"'] ['"+formObj.his_seq.value+"'] ['"+formObj.his_dtl_seq.value+"']";
		var rdOption   = " /riprnmargin";   //' /rwait'
//		RdViewer.SetAppendReport(0);
//		RdViewer.ApplyLicense("0.0.0.0");
		RdViewer.openFile(RD_path + rdUrl + rdFileName, RDServer + rdParam + rdOption,{timeout:3000}); 
 	}


	/* 개발자 작업  끝 */