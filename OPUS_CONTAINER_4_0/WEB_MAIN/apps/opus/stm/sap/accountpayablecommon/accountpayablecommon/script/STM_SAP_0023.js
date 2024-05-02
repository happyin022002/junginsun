/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0023.js
*@FileTitle  : Location Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
 /**
 * @extends 
 * @class Evidence Popup : business script for STM_SAP_0023
 */
/* 공통전역변수 */
var ipageNo=1 ;
var sheetObjects=new Array();
var sheetCnt=0;
document.onclick=processButtonClick;
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */    
	function processButtonClick(){
		 var sheetObject=sheetObjects[0];
	     var formObj=document.form;
	    try {
	        var srcName=ComGetEvent("name");
	        switch(srcName) {
	        	case "btn_retrieve":
	        		doActionIBSheet(sheetObject, formObj, IBSEARCH);
	    	        break;
	            case "btn_close":
	            	ComClosePopup(); 
	    	        break;
	    	    case "btn_ok":
					if(sheetObject.RowCount()== 0){
						ComClosePopup(); 
					}else{
						comPopupOK();
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
    /**
     * IBSheet Object를 배열로 등록
     * comSheetObject(id)에서 호출한다
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * Sheet 기본 설정 및 초기화 
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
     function loadPage() {
    	 var formObject=document.form;
    	 for(i=0;i<sheetObjects.length;i++){
 			ComConfigSheet (sheetObjects[i] );
 			initSheet(sheetObjects[i],i+1);
 			ComEndConfigSheet(sheetObjects[i]);
 		}
 		initControl();
 		if (formObject.loc_cd.value == "") { 
  			var sXml=sheetObjects[0].GetSearchData("SAPCommonGS.do", "f_cmd=" + SEARCH01);
 			var apLoginLoc=ComGetEtcData(sXml, "loc_cd");
 			formObject.loc_cd.value=apLoginLoc;	
 		}
 	}
 	/**
 	 * loading HTML Control event <br>
 	 * {@link #loadPage} function call this. so IBSheet Object is initialized. <br>
 	 * @param {ibsheet} sheetObj    IBSheet Object
 	 * @param {int}     sheetNo     sequence number in sheetObjects array
 	 **/
 	function initControl() {
 		// axon_event.addListenerForm('keypress', 'obj_keypress',  form);    	  
 		// axon_event.addListenerForm('keyup',    'obj_keyup',   	form);
 		//axon_event.addListenerForm  ('blur', 'obj_deactivate',  form);
 		//axon_event.addListenerFormat('focus', 'obj_activate', form);
 	}
	function obj_keypress() {
		switch(ComGetEvent("dataformat")){
			case "engup":
				ComKeyOnlyAlphabet('uppernum');				
				break;
			case "han":
				break;
			default:
				//common standard: recognization only number, english
				ComKeyOnlyAlphabet("num");
				break;     
		}
		if(event.KeyCode == 13){
			ComSetNextFocus(ComGetEvent());
		}
	}    
    /** 
     * handling Keypress event of Object  <br>
     * checking validation of input value by dataformat of object  <br>
     */ 
	function obj_keyup(){
	}  
    /** 
     * handling work javascript OnFocus event  <br>
     */    
	function obj_activate() {
       	//delete mask separator
        ComClearSeparator(ComGetEvent());
    }
    /**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 살려주며. Validate를 체크하여준다.
     **/
	function obj_deactivate(){
		ComChkObjValid(ComGetEvent());
		//ComAddSeparator(ComGetEvent(), "ymd");
	}
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        //sheetObj.UseUtf8 = true;
        switch(sheetNo) {
            case 1:      //IBSheet1 init
                with(sheetObj){
		              var HeadTitle="|Location|Location Name";
		              var headCount=ComCountHeadTitle(HeadTitle);
		              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );
		              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"loc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"loc_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		              InitColumns(cols);
		              SetEditable(1);
		              //SetSheetHeight(180);
		              resizeSheet();
                    }
                break;
        }
    }
    /* Sheet관련 프로세스 처리 */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBSEARCH: //retrieve
        		formObj.f_cmd.value=SEARCH;			
         		var sXml=sheetObj.GetSearchData("STM_SAP_0023GS.do", FormQueryString(formObj));
        		sheetObj.LoadSearchData(sXml,{Sync:1} );
        		break;
        }
    }
    function sheet_OnDblClick(sheetObj, Row, Col) {
    	comPopupOK();
    }    
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }
