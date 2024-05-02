/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_FMS_0100.js
*@FileTitle  : Other Code List 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/16
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   	/* 개발자 작업	*/
	// 공통전역변수
	var comboObjects=new Array(); 
	var comboCnt=0;
	var sheetObjects=new Array();
	var sheetCnt=0;
	//var PPT_NM="ppt_nm";
	var beforetab=1; 
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
       /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject=sheetObjects[0];
       /*******************************************************/
       var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
          	switch(srcName) {
            	case "btn_retrieve":
	             	if(!CoFmsInitConfirm(sheetObject)) return;
	             	doActionIBSheet(sheetObject,formObject,IBSEARCH);
                break;
				case "btn_new":
	             	if(!CoFmsInitConfirm(sheetObject)) return;
					ComResetAll();
					//ppt_nm.SetSelectText("ALL");
					sheetObject.RemoveAll();
                break;
				case "btn_save":
//					if (!checkDupAcctItem(sheetObject)) {
						doActionIBSheet(sheetObject,formObject,IBSAVE);
//                	}
                break;
				case "btn_add":
					if(!validateForm(sheetObject,formObject)) return;
					var row=sheetObject.DataInsert(-1);
					sheetObject.SelectCell(row, "sheet1_ppt_nm");
                break;
				case "btn_ins":
					if(!validateForm(sheetObject,formObject)) return;
					var row=sheetObject.DataInsert();
					sheetObject.SelectCell(row, "sheet1_ppt_nm");
					break;
				case "btn_del":
					if(checkBoxCheckYn(sheetObject, "sheet1_DelChk")) { 
						ComRowHideDelete(sheetObject, "sheet1_DelChk"); 
					}
                break;
          } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
//    /**
//    * Save 버튼 클릭시 중복 체크
//    */
//	function checkDupAcctItem(sheetObject) {
//		
//		var sRow = sheetObject.FindStatusRow("I|U");
//		var arrow = sRow.split(";");
//		
//		var len = arrow.length - 1;
//		
//		for (i=0; i<len; i++) {
//
//			var findrow = sheetObject.FindText("acct_itm_nm", sheetObject.CellValue(arrow[i], "acct_itm_nm"), 0, -1, false);
//
//			if (findrow > 0) {
//
//				if (findrow == arrow[i]) {
//					findrow = sheetObject.FindText("acct_itm_nm", sheetObject.CellValue(arrow[i], "acct_itm_nm"), findrow+1, -1, false);
//				}	
//			
//				if (findrow > 0) {
//					ComShowCodeMessage('FMS01340', arrow[i], findrow);
//					sheetObject.SelectCell(arrow[i], "acct_itm_nm");
//					return true;
//				}
//			}		
//		}	
//
//		return false;
//
//	}	
    /**
    * IBSheet Object를 배열로 등록
    * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
    * 배열은 소스 상단에 정의
    */
    function setSheetObject(sheet_obj){
      sheetObjects[sheetCnt++]=sheet_obj;
    }
    /** 
	 * IBCombo Object를 배열로 등록
	 * param : combo_obj ==> 콤보오브젝트
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */ 
	function setComboObject(combo_obj) {  
		comboObjects[comboCnt++]=combo_obj;  
	}
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
        //khlee-시작 환경 설정 함수 이름 변경
           ComConfigSheet (sheetObjects[i] );
           initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
           ComEndConfigSheet(sheetObjects[i]);
        }
        //html컨트롤 이벤트초기화
        initControl();
        /*for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
		ppt_nm.SetSelectText("ALL");*/
    }
	/**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {
    	//** Date 구분자 **/
    	DATE_SEPARATOR="/";
        //Axon 이벤트 처리1. 이벤트catch
    	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        //axon_event.addListenerFormat('keypress'        , 'obj_keypress'  , 	form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
        //axon_event.addListener  ('keypress', 'obj_keypress' , 'acct_cd');			//- Vendor Code 입력 시 숫자만 입력하기
    }
     /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with(sheetObj){
		              var HeadTitle="|Sel|Code Type|Code Seq|Code Description|CodeTypeSeq|CodeSeqSeq";
		              var prefix="sheet1_";
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		                     {Type:"DummyCheck", Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"DelChk" },
		                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ppt_nm",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ppt_seq",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:550,  Align:"Left",    ColMerge:0,   SaveName:prefix+"ppt_ctnt",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, MultiLineText:1 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"org_ppt_nm" },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"org_ppt_seq" } ];               
		              InitColumns(cols);
		              SetEditable(1);
//		              SetSheetHeight(470);
		              resizeSheet();
              }
                break;
         }
     }
 /**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */ 
	function initCombo(comboObj, comboNo) {
	 	var formObj=document.form;
	 	switch(comboObj.options.id) {  
	 		case "ppt_nm":
	 			with (comboObj) {
	 				SetMultiSelect(0);
	 				SetUseAutoComplete(1);
	 				SetMaxSelect(1);
	 				SetDropHeight(100);
	 				InsertItem(0, "ALL", "ALL");
//			 		InsertItem(1, 'ACCT_OF',	'ACCT_OF' );
//			 		InsertItem(2, 'ACCT_OT',	'ACCT_OT');
			 		InsertItem(3, 'ADDRESS', 	'ADDRESS');
			 		InsertItem(4, 'BANK_NO', 	'BANK_NO');
//			 		InsertItem(5, 'CENTER_CODE', 	'CENTER_CODE');
			 		
//	 				InsertItem(1, 'ACCT_DELETE',	'ACCT_DELETE');
//			 		InsertItem(2, 'ACCT_OF',	'ACCT_OF' );
//			 		InsertItem(3, 'ACCT_OT',	'ACCT_OT');
//			 		InsertItem(4, 'ADDRESS', 	'ADDRESS');
//			 		InsertItem(5, 'BANK_NO', 	'BANK_NO');
//			 		InsertItem(6, 'CENTER_CODE', 	'CENTER_CODE');
//			 		InsertItem(7, 'REV_ACCT_CD_10', 	'REV_ACCT_CD_10');
//			 		InsertItem(8, 'REV_ACCT_CD_60', 	'REV_ACCT_CD_60');
//			 		InsertItem(9, 'TEAM_CODE', 	'TEAM_CODE');
	 			}
	 		break;
    	}
	}
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj, sAction, Col, Row) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
         	case IBSEARCH:      //조회
        		ComOpenWait(true);
	            formObj.f_cmd.value=SEARCH;
	            var rXml=sheetObj.GetSearchData("ESM_FMS_0100GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
				sheetObj.LoadSearchData(rXml,{Sync:1} );
				ComOpenWait(false);
        	    break;
           	case IBSAVE:        //저장
	 			var sParam=ComGetSaveString(sheetObjects);
				if (sParam == "") return;
						//변경된 데이타가 없으면 저장하러 서버를 가지않음
				if (validateForm(sheetObj, formObj, IBSAVE)){ //유효성검증
					formObj.f_cmd.value=MULTI;
					ComOpenWait(true);
					var sXml=sheetObjects[0].GetSaveData("ESM_FMS_0100GS.do", "f_cmd=" + MULTI + "&" + sParam);
					if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "F"){
						ComOpenWait(false);
					}else{
						ComOpenWait(false);
						doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
					}
					sheetObj.LoadSaveData(sXml);
				}
				break;
        }
    }
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
         }
         return true;
     }
     
     function resizeSheet(){
    	    ComResizeSheet(sheetObjects[0], 80);
     }
	/* 개발자 작업  끝 */
