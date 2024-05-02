/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0861.js
*@FileTitle :  Empty Container Release Order(RD)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.07.16 최도순
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
     * @author 한진해운
     */

    /**
     * @extends 
     * @class ESM_BKG_0861 : ESM_BKG_0861 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0861() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

    var rdObjects = new Array();
    var rdCnt = 0;
    
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	
    	 var sheetObject = opener.sheetObjects[0];
         var formObject = opener.document.form;
         var rdObject	=	rdObjects[0];
         var param="";
         
		initRdConfig(rdObject);
		rdOpen(rdObject,formObject,sheetObject);
	}
    
    function rdOpen(rdObject, formObject, sheetObject){
		
		var Rdviewer = rdObject;
		// /rp [" + param + "] /riprnmargin /rprncenteropt [1] /rwait -- 파라메터 순서
		//var rdParam = "/rp [" + param + "] /riprnmargin /rwait";
		
		var iCheckRow = sheetObject.FindCheckedRow("Check");
		
		var strBkgNo = "";
		var strRemark = "";
		var strType = "";
		var strUsrId = "";
		var arrRow = iCheckRow.split("|");

		for (var idx=0; idx<arrRow.length-1; idx++) {
			if (""!=sheetObject.CellValue(arrRow[idx], "bkg_no")) {
				if (0 > strBkgNo.indexOf(sheetObject.CellValue(arrRow[idx], "bkg_no"))) {
					strBkgNo += "'" + sheetObject.CellValue(arrRow[idx], "bkg_no") + "',";
					strRemark += sheetObject.CellValue(arrRow[idx], "diff_rmk") + "@@";
				}
			} else {
				for (var ii=arrRow[idx]-1; ii>0; ii--) {
					if (""!=sheetObject.CellValue(ii, "bkg_no") &&
						0 > strBkgNo.indexOf(sheetObject.CellValue(ii, "bkg_no"))) {
							strBkgNo += "'" + sheetObject.CellValue(ii, "bkg_no") + "',";
							strRemark += sheetObject.CellValue(ii, "diff_rmk") + "@@";
							break;
					}
				}
			}
		}
		strBkgNo = " bkg_no[( " + strBkgNo.substring(0, eval(strBkgNo.lengthByte()) - 1) + " )] ";
		strRemark = " remark[" + strRemark + " ] ";
		strUsrId = " usr_id[" + formObject.usr_id.value + "] ";
		
		for(i=0;i< formObject.ser_type.length;i++){ 
    		if (formObject.ser_type[i].checked){ 
    			v_ser_type = formObject.ser_type[i].value; 
    		} 
    	}
		
		if(v_ser_type=='simple'){
			strType ="type[simple]";
		}else{
			strType ="type[detail]";
		}    		
		
		var rdParam = "/rv "+ strBkgNo + strRemark + strUsrId + strType;
		// 열고자 하는 RD 파일을 지정한다.
		var strPath = RD_path+"apps/alps/esm/bkg/outbounddocumentation/outboundblmgt/emptyreleaseorder/report/ESM_BKG_0861.mrd";
		
		//Rdviewer.AutoAdjust = false;
		//Rdviewer.ZoomRatio = 90;
		//Rdviewer.HideToolbar();
		//Rdviewer.setbackgroundcolor(255,255,255);
		//Rdviewer.setPageScroll(0);

		Rdviewer.FileOpen(strPath, RDServer + rdParam);
	}
    
	
	
    /*
	*Rd 설정
	*/
	function initRdConfig(rdObject){
		var Rdviewer = rdObject;

		Rdviewer.AutoAdjust = true;
		Rdviewer.HideToolbar();
		Rdviewer.HideStatusbar();
		Rdviewer.ViewShowMode(0); 
		Rdviewer.setbackgroundcolor(128,128,128);
		Rdviewer.SetPageLineColor(128,128,128);
	}
	
	
	/* 개발자 작업  끝 */