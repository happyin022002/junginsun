/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0108.js
*@FileTitle : INVOICE Printer Set up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.24
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.10.24 최우석
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
     * @class fns_inv_0108 : fns_inv_0108 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_inv_0108() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

    // 공통전역변수

    var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var rdObjects = new Array();
	var rdCnt = 0;
	
	var timer1 = null;
	var timer2 = null;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
                case "btn_new":
                	formObject.inv_prn_dvc_nm.value = "";
                    break;

                case "btn_save":
                	doActionIBSheet(sheetObject,formObject,IBSAVE);
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
     * IBSheet Object를 배열로 등록<br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
     * 배열은 소스 상단에 정의<br>
     *
     * @param {object} sheet_obj
     * @return 없음
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * Sheet 기본 설정 및 초기화<br>
     * body 태그의 onLoad 이벤트핸들러 구현<br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다<br>
     * 
     * @return 없음
     */
    function loadPage() {
    	for(i=0;i<sheetObjects.length;i++){
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

    	initRdConfig(rdObjects[0]);
    	timer1 = setInterval(initPrintList, 500);
    	timer2 = setInterval(getDataInfo, 1000);
    }
    
    /**
     * 시트 초기설정값, 헤더 정의<br>
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호<br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다<br>
     * 
     * @param {object} sheetObj
     * @param {int} sheetNo
     * @return 없음
     * @see #loadPage
     */
    function initSheet(sheetObj,sheetNo) {
    	switch(sheetObj.id) {
    		case "sheet1":
    			with(sheetObj) {
                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                }
                break;
        }
    }

    /** Sheet관련 프로세스 처리<br>
     * 
     * @param {object} sheetObj
     * @param {object} formObj
     * @param {int} sAction
     * @return 없음
     * @see #processButtonClick
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {
        	case IBSEARCH:
        		formObj.f_cmd.value = SEARCH;
    			var sXml = sheetObj.GetSearchXml("FNS_INV_0108GS.do", FormQueryString(formObj));
	   			var arOfcCd = ComGetEtcData(sXml, "ArOfcCd");
	   			var invPrnDvcNm = ComGetEtcData(sXml, "InvPrnDvcNm");
	   			if(typeof arOfcCd != "undefined" && arOfcCd != "" ) {
	   				formObj.ar_ofc_cd.value = arOfcCd;
	   				formObj.prn_dvc_nm.Code = invPrnDvcNm;
//	   				if(invPrnDvcNm == "") {
//	   					var defaultPrint = rdObjects[0].GetLocalInfo("DefaultPrnName", "");
//	   					formObj.prn_dvc_nm.Code = defaultPrint;
//	   				}
	   			}
    			break;
			case IBSAVE:
				if(validateForm(sheetObj,formObj,sAction)) {
        			formObj.f_cmd.value = MULTI;
        			form.inv_prn_dvc_nm.value = formObj.prn_dvc_nm.text;
        			var sXml = sheetObj.GetSaveXml("FNS_INV_0108GS.do", FormQueryString(formObj));
        			var state = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
        			if(state == "S") {
        				ComShowCodeMessage("INV00051");
        			} else{
        				ComShowCodeMessage("INV00053");
        			}
        		}
				break;
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리<br>
     *
     * @param {object} sheetObj
     * @param {object} formObj
     * @param {int} sAction
     * @return bool;
     */
    function validateForm(sheetObj,formObj,sAction){
    	if (!ComChkValid(formObj)) return false;
        return true;
    }

    /**
  	 * RD Object 초기화<br>
  	 * 
  	 * @return 없음
     * @see #loadPage
     */
    function initRdConfig(rdObject){
  		var Rdviewer = rdObject ;

		Rdviewer.AutoAdjust = true;
		Rdviewer.ViewShowMode(0);

		Rdviewer.setbackgroundcolor(128,128,128);
		Rdviewer.SetPageLineColor(128,128,128);

		Rdviewer.style.height = 0;
 	}
     
    /**
     * Print정보를 가져한다.<br>
     * 
     * @return 없음
     * @see #loadPage
     */
    function initPrintList(){
    	var Rdviewer = rdObjects[0];
	  	var strPrintList = Rdviewer.GetLocalInfo("PrnNames", "");

	  	if(strPrintList == undefined || strPrintList == null || strPrintList == "") return;

	  	var arrPrintList = strPrintList.split("|");
	
	  	printListXml  = " <SHEET> \n";
	  	printListXml += " <DATA COLORDER='val' COLSEPARATOR='☜☞' TOTAL='"+(arrPrintList.length-1)+"'> \n";
	
	  	for(var i = 0; i < arrPrintList.length-1; i++) {
	  		printListXml += " 	<TR><![CDATA["+arrPrintList[i]+"]]></TR> \n";
	  	}		
	  	printListXml += " </DATA> \n";
	  	printListXml += " </SHEET> ";
	  	ComXml2ComboItem(printListXml, form.prn_dvc_nm, "val", "val");
	  	
	  	clearInterval(timer1);
 	}

    /**
     * 설정된 Print정보를 가져온다.<br>
     * 
     * @return 없음
     */
    function getDataInfo() {
    	doActionIBSheet(sheetObjects[0],form,IBSEARCH);
    	clearInterval(timer2);
    }
	/* 개발자 작업  끝 */