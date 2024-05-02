/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0029.js
*@FileTitle  : Line Overseas DFF Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/02
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
 /**
 * @extends 
 * @class Line Overseas DFF Popup  : business script for STM_SAP_0029
 */
/* 공통전역변수 */
var ipageNo=1 ;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
document.onclick=processButtonClick;
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */    
	function processButtonClick(){
		 var sheetObject=sheetObjects[0];
	     var form=document.form;
	    try {
	        var srcName=ComGetEvent("name");
	        if(ComGetBtnDisable(srcName)) return false;
	        switch(srcName) {
	        	case "btn_new":
		            funcNew("FULL");
	    	        break;
	            case "btn_close":
	            	ComClosePopup(); 
	    	        break;
	    	    case "btn_ok":
	        		funcOK();
            		break;
	    	    case "btns_loc_srh":
	        		//Location
            		var param="?loc_cd=" + form.attr_ctnt3.value;
            		ComOpenPopup("STM_SAP_0023.do" + param, 400, 390, "setLocation", "0,0", true, false);
            		break;	
	    	    case "btns_cal1":  
            		//Vendor Invoice Date
            		var cal=new ComCalendar();
					cal.select(form.attr_ctnt2, 'yyyy-MM-dd');
					break;
	    	    case "btns_cal2":  
            		//Activity Date
            		var cal=new ComCalendar();
					cal.select(form.attr_ctnt11, 'yyyy-MM-dd');
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
 		formObject.attr_ctnt3_nm.value=SAPGetLocNm(sheetObjects[0],formObject.attr_ctnt3.value );
 		formObject.attr_ctnt2.value=ComGetMaskedValue(formObject.attr_ctnt2.value, "ymd");
 		formObject.attr_ctnt11.value=ComGetMaskedValue(formObject.attr_ctnt11.value, "ymd");
 	}
 	/**
 	 * loading HTML Control event <br>
 	 * {@link #loadPage} function call this. so IBSheet Object is initialized. <br>
 	 * @param {ibsheet} sheetObj    IBSheet Object
 	 * @param {int}     sheetNo     sequence number in sheetObjects array  beforedeactivate
 	 **/
 	function initControl() {
 		var form=document.form;
// 		axon_event.addListenerForm('keypress', 'obj_keypress',  form);    	  
// 		axon_event.addListenerForm('keyup',    'obj_keyup',   	form);
 		axon_event.addListenerForm  ('blur', 'obj_deactivate',  form);   //blur  beforedeactivate  
 		axon_event.addListenerFormat('focus', 'obj_activate', form);
 		axon_event.addListenerForm ('change', 'obj_onchange', form);
 	}
	function obj_keypress() {
		switch(event.srcElement.dataformat){
			case "engup":
				ComKeyOnlyAlphabet('uppernum');
				break;			
			case "engnum":
				ComKeyOnlyAlphabet('uppernum');
				break;	
			case "int":
				//숫자 만입력하기
				ComKeyOnlyNumber(event.srcElement);
				break;
			case "ymd":
				ComKeyOnlyNumber(event.srcElement);
				break;
			case "float":
				ComKeyOnlyNumber(event.srcElement, "-.");
				break;
			case "han":
				break;
			case "saupja":
				ComKeyOnlyNumber(event.srcElement, "-");
				break;
			default:
				//common standard: recognization only number, english
				ComKeyOnlyAlphabet("num");
				break;     
		}
		if(event.KeyCode == 13){
			ComSetNextFocus(event.srcElement);
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
        ComClearSeparator(event.srcElement);
    }
    /**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 살려주며. Validate를 체크하여준다.
     **/
	function obj_deactivate(){
		ComAddSeparator(form.attr_ctnt2, "ymd");
		ComAddSeparator(form.attr_ctnt11, "ymd");
		ComChkObjValid(event.srcElement)
	}
    /**
     * handling work javascript onchange event
     **/	     
	function obj_onchange(){
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		switch(event.srcElement.name){
			case "attr_ctnt3":
				if (formObj.attr_ctnt3.value != '' ) {
					formObj.attr_ctnt3_nm.value=SAPGetLocNm(sheetObj,event.srcElement.value );
				} else {
					formObj.attr_ctnt3_nm.value="";
				}
				break;
			case "attr_ctnt12":
				if (formObj.attr_ctnt12.value != '' ) {
					formObj.attr_ctnt12.value=SapGetActivityPlaceCheck(sheetObj,event.srcElement.value );
				} else {
					formObj.attr_ctnt12.value="";
				}
				break;
			case "attr_ctnt14":
				if (formObj.attr_ctnt14.value != '' ) {
					formObj.attr_ctnt14.value=SapGetInvoiceServiceLaneCheck(sheetObj,event.srcElement.value );
				} else {
					formObj.attr_ctnt14.value="";
				}
				break;
		}
	}	
 	/**
 	 * registering IBCombo Object as list
 	 * @param combo_obj
 	 * @return
 	 */
 	function setComboObject(combo_obj){
 		comboObjects[comboCnt++]=combo_obj;
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
                with (sheetObj) {
                    // 높이 설정
            	
            	var HeadTitle="|attr_ctnt1|attr_ctnt2|attr_ctnt3|attr_ctnt4|attr_ctnt5|attr_ctnt6|attr_ctnt7|attr_ctnt8|attr_ctnt9|attr_ctnt10|attr_ctnt11|attr_ctnt12|attr_ctnt14";
            	var headCount=ComCountHeadTitle(HeadTitle);
            	(headCount, 0, 0, true);

            	SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );

            	var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            	var headers = [ { Text:HeadTitle, Align:"Center"} ];
            	InitHeaders(headers, info);

            	var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
            	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt1",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt2",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt3",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt4",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt5",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt6",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt7",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt8",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt9",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt10",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt11",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt12",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt14",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
            	 
            	InitColumns(cols);
            	//SetSheetHeight(220);
            	SetEditable(1);
            	resizeSheet();
                }
                break;
        }
    }
    /* Sheet관련 프로세스 처리 */
    function doActionIBSheet(sheetObj,formObj,sAction, a, PageNo) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case COMMAND01:
           break;
        }
    }
   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(){
    	var formObj=document.form;
    	var sheetObj=sheetObjects[0];
    	if (!ComChkValid(formObj, true, false, false)) return false;
    	
    	if ("NO_DATA" == formObj.attr_ctnt3_nm.value ) {
			ComShowCodeMessage("COM132201", "Location" );  
			formObj.attr_ctnt3.value="";
//			formObj.attr_ctnt3.focus();
			return false;
		}
		
		if (formObj.attr_ctnt12.value != '' ) {
			formObj.attr_ctnt12.value = SapGetActivityPlaceCheck(sheetObj, formObj.attr_ctnt12.value );
		} else {
			formObj.attr_ctnt12.value="";
			return false;
		}
		
		if (formObj.attr_ctnt14.value != '' ) {
			formObj.attr_ctnt14.value = SapGetInvoiceServiceLaneCheck(sheetObj, formObj.attr_ctnt14.value );
		} else {
			formObj.attr_ctnt14.value="";
			return false;
		}
    	
    	return true;
    }	
    function funcNew(flag) {
    	var sheetObject=sheetObjects[0];
	    var formObj=document.form;
    	if (flag == "FULL") {
    		sheetObject.RemoveAll();
    		formObj.reset();
            formObj.attr_ctnt1.value="";
            formObj.attr_ctnt2.value="";
            formObj.attr_ctnt3.value="";
            formObj.attr_ctnt4.value="";
            formObj.attr_ctnt11.value = ""; 
            formObj.attr_ctnt12.value = ""; 
            formObj.attr_ctnt14.value = ""; 
    	} else if (flag == "OK") {
    		sheetObject.RemoveAll();
    		sheetObject.DataInsert(-1);
    	}
    }
    function funcOK() {
    	var sheetObj=sheetObjects[0];
	    var formObj=document.form;
    	funcNew("OK");
    	if ( !validateForm() ) {
    		return false;
    	}
    	sheetObj.SetCellValue(1, "attr_ctnt1",ComTrim(formObj.attr_ctnt1.value),0);
    	sheetObj.SetCellValue(1, "attr_ctnt2",ComTrim(formObj.attr_ctnt2.value),0);
    	sheetObj.SetCellValue(1, "attr_ctnt3",ComTrim(formObj.attr_ctnt3.value),0);
    	sheetObj.SetCellValue(1, "attr_ctnt4",ComTrim(formObj.attr_ctnt4.value),0);
    	sheetObj.SetCellValue(1, "attr_ctnt11",ComTrim(formObj.attr_ctnt11.value),0);
    	sheetObj.SetCellValue(1, "attr_ctnt12",ComTrim(formObj.attr_ctnt12.value),0);
    	sheetObj.SetCellValue(1, "attr_ctnt14",ComTrim(formObj.attr_ctnt14.value),0);
    	comPopupOK();
    }
    //Location Popup setting
    function setLocation(aryData) {
    	var formObj=document.form;
    	formObj.attr_ctnt3.value=aryData[0][1];
    	formObj.attr_ctnt3_nm.value=aryData[0][2];    	
    }
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }
