/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0330.JSP
*@FileTitle  : Payment Detail Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
var sheetObjects=new Array();
var sheetCnt=0;
document.onclick=processButtonClick;
function processButtonClick() {
    var shtObj=sheetObjects[0];
    var frmObj=document.form;
    try {
        var srcName=ComGetEvent("name");
        switch (srcName) {
			case "btns_calendar_fr":
				var cal=new ComCalendar();
				cal.select(frmObj.from_pay_dt, 'yyyy-MM-dd');
				break;					
			case "btns_calendar_to":
				var cal=new ComCalendar();
				cal.select(frmObj.to_pay_dt, 'yyyy-MM-dd');
				break;		        
            case "btn_retrieve":     // Retrieve
                doActionIBSheet(shtObj, frmObj, IBSEARCH);
                break;
    	    case "btn_new" :
    	    	frmObj.reset();
    	    	sheetObjects[0].RemoveAll();
    	    	sheetObjects[1].RemoveAll();
    	    	doActionIBSheet(shtObj, frmObj, COMMAND01);
    	    	break;  
    	    case "btn_downexcel":
    	    	if(sheetObjects[0].RowCount() < 1){//no data
    	    		ComShowCodeMessage("COM132501");
    	    	}
    	    	if(sheetObjects[1].RowCount() < 1){//no data
    	    		ComShowCodeMessage("COM132501");
    	    	}
    	    	
    	    	if (sheetObjects[0].RowCount() > 0 && sheetObjects[1].RowCount() > 0) {
    	    		sheetObjects[0].Down2ExcelBuffer(true);
    				if(sheetObjects[0].SearchRows()>0){
    					sheetObjects[0].Down2Excel({FileName:'Excel',SheetName:'Sheet1', HiddenColumn:1, SheetDesign:1});
    			   	}
    			   	if(sheetObjects[1].SearchRows()>0){
    					sheetObjects[1].Down2Excel({FileName:'Excel',SheetName:'Sheet2', HiddenColumn:1, SheetDesign:1});
    			   	}
    				sheetObjects[0].Down2ExcelBuffer(false);
    	    	} else {
    	    		// If any grid has no data, we could not download excel by using Buffer, we should download one by one.
    	    		if (sheetObjects[0].RowCount() > 0) {
    	    			sheetObjects[0].Down2Excel({FileName:'Excel',SheetName:'Sheet1', HiddenColumn:1, SheetDesign:1});
    	    		}
    	    	}
    	    	
    	    	break;	
            case "btn_payment_office" :            	
            	ComOpenPopupWithTarget('/opuscntr/STM_SAP_0001.do?ofc_cd='+frmObj.ofc_cd.value, 400, 430,"ap_ofc_cd:ofc_cd", "0,0", true);
            	break;
            case "btn_supplier" :
            	ComOpenPopupWithTarget('/opuscntr/STM_SAP_0002.do?vndr_seq='+frmObj.vndr_no.value, 900, 420,"vndr_seq:vndr_no|vndr_lgl_eng_nm:vndr_lgl_eng_nm", "0,0", true);
            	break;
            case "btn_payment_method" :
            	ComOpenPopupWithTarget('/opuscntr/STM_SAP_0007.do?lu_cd='+frmObj.pay_mzd_lu_cd.value, 500, 420,"lu_cd:pay_mzd_lu_cd", "0,0", true);
            	break;    
        } // end switch
    } catch(e) {
        if (e == "[object Error]") {
            ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e.message);
        }
    }
}

//function sheet1_OnDownFinish(type, result){
//	if (sheetObjects[1].RowCount() > 0) {
//		sheetObjects[1].Down2Excel({FileName:'Excel',SheetName:'Sheet1', HiddenColumn:1, SheetDesign:1});
//	}
//	sheetObjects[0].Down2ExcelBuffer(false);
//}
/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(shtObj) {
   sheetObjects[sheetCnt++]=shtObj;
}
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
    for (var i=0; i<sheetObjects.length; i++){
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
    initControl();
    resizeSheet();
}
/**
 * 시트 초기설정값, 헤더 정의
 * param : shtObj ==> 시트오브젝트, shtNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(shtObj, shtNo) {
    var cnt=0;
    switch(shtNo) {
    	case 1:      // sheet1 init   
    	      with(shtObj){
		         document.form.pagerows.value=500;
		         var HeadTitle0="|SEQ|Payment Date|Supplier|Supplier Name|Currency|Payment Amount|Bank|Branch|Bank Account No|Payment Method|Payment Number";
		
		         SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		         var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
		         var headers = [ { Text:HeadTitle0, Align:"Center"} ];
		         InitHeaders(headers, info);
		
		         var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		             {Type:"Date",      Hidden:0,  Width:110,   Align:"Center",  ColMerge:1,   SaveName:"pay_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vndr_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"vndr_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"pay_amt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"bank_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"bank_brnc_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"bank_acct_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"pay_mzd_lu_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"pay_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		          
		         InitColumns(cols);
		         SetEditable(1);
		         SetSheetHeight(320);
              }
	    break;
    	case 2:      // sheet2 init   
            with(shtObj){
		        document.form.pagerows.value=500;
		        var HeadTitle0="Currency|Payment Amount";
		
		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		        var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
		        var headers = [ { Text:HeadTitle0, Align:"Center"} ];
		        InitHeaders(headers, info);
		
		        var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		         {Type:"Text",      Hidden:0,  Width:280,  Align:"Right",   ColMerge:1,   SaveName:"pay_amt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		         
		        InitColumns(cols);
		        SetEditable(1);
		        var height = ComGetSheetHeight(shtObj, 4) + 10;
		        SetSheetHeight(height);
		        SetCountPosition(0);
		        SetExtendLastCol(false);
            }
	    break;		    
    }
}
/**
 * Form의 Conrol 초기화 및 초기 이벤트 등록
 */
function initControl() {
	var formObj=document.form;
//	axon_event.addListenerFormat('beforedeactivate', 'obj_blur'    ,   form); //- handling code when OnBeforeDeactivate(blur) event
//	axon_event.addListenerFormat('beforeactivate'  , 'obj_focus'   ,   form); //- handling code when OnBeforeActivate event in case of existing dataformat property
//  axon_event.addListenerFormat('keypress'        , 'obj_keypress',   form); //- handling code when onkeypress event in case of existing dataformat property
//  axon_event.addListenerFormat('keyup'           , 'obj_keyup'   ,   form);
  axon_event.addListenerFormat('focus'           , 'obj_activate',   formObj);
  axon_event.addListenerFormat('blur'            , 'obj_deactivate', formObj);
  axon_event.addListenerForm ('change', 'obj_onchange', formObj);
    //axon_event.addListener('change', 'vndr_no_onchange', 'vndr_no', '');	
}
/**
 *  Supplier Number / Name - OnChange
 */
/*function vndr_no_onchange() {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var vndr_no=formObj.vndr_no.value;
	if(vndr_no == ""){
		document.form.vndr_lgl_eng_nm.value = "";
	}else
	document.form.vndr_lgl_eng_nm.value=SapGetSupplierName(sheetObj,vndr_no,"","" );
}*/
/**
 * initialize or check selected header information
 */ 
function obj_onchange(){
	var formObj=document.form;
	var sheetObject=sheetObjects[0];
	switch(ComGetEvent("name")){
		case "vndr_no":
			var vndr_no=formObj.vndr_no.value;
			formObj.vndr_lgl_eng_nm.value=SapGetSupplierName(sheetObject,vndr_no,"","" );
	    	break;
			
		case "ofc_cd":
			var office_code=formObj.ofc_cd.value;
			formObj.ofc_cd.value = SapGetDataSecurityOffice(sheetObject, office_code, "" );
			break;
	}
}
/**
 * Sheet관련 프로세스 처리
 */
function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
    switch (sAction) {
	    case COMMAND01: // when first form open,
	        //office 코드 설정
	    	frmObj.ofc_cd.value=SapGetLoginAPOfc(sheetObjects[0]);
	        //office local date 설정
	    	var localTime=SapGetLocDate(sheetObjects[0]);
	    	var localStartTime=localTime.substr(0,6) + "01";
	    	frmObj.from_pay_dt.value=ComGetMaskedValue(localStartTime, "ymd");				
	    	frmObj.to_pay_dt.value=ComGetMaskedValue(localTime, "ymd");
	    	break;
        case IBSEARCH:       // 조회
        	if (validateForm(shtObj, frmObj, sAction)) {
	            ComOpenWait(true);
	            frmObj.f_cmd.value=SEARCH;
 	            shtObj.DoSearch("STM_SAP_0330GS.do", FormQueryString(frmObj) );
	            frmObj.f_cmd.value=SEARCH01;
 	            sheetObjects[1].DoSearch("STM_SAP_0330GS.do", FormQueryString(frmObj) );
	            ComOpenWait(false);
        	}
            break;
    }
}
/**
 * 조회 form 필수조건 유효성 체크
 */
function validateForm(sheetObj, formObj, sAction) {
    if (!ComChkValid(formObj)){
        return false;        
    }
    return true;
}
/** 
 * handling work javascript OnFocus event  <br>
 */    
function obj_activate() {
   	//delete mask separator
    ComClearSeparator(ComGetEvent());        
} 
/**
 * HTML Control onfocus validate event <br>
 **/
function obj_deactivate(){
	var formObj = document.form;
	switch(ComGetEvent("name")){
		case "from_pay_dt":
			ComChkObjValid(ComGetEvent());
			ComAddSeparator(formObj.from_pay_dt, "ymd");
			break;
		case "to_pay_dt":
			ComChkObjValid(ComGetEvent());
			ComAddSeparator(formObj.to_pay_dt, "ymd");
			break;
	}
}
function obj_keypress(){
	switch(event.srcElement.dataformat){
	case "engup":
		ComKeyOnlyAlphabet('uppernum');
		break;
	case "engnum":
		ComKeyOnlyAlphabet('uppernum');
		break;	
	case "int":
		//숫자 만입력하기
		ComKeyOnlyNumber(ComGetEvent());
		break;
	case "ymd":
		ComKeyOnlyNumber(ComGetEvent());
		break;
	case "float":
		ComKeyOnlyNumber(ComGetEvent(), "-.");
		break;
	default:
		//common standard: recognization only number, english
		ComKeyOnlyAlphabet("num");
		break;     
	}	
}

function resizeSheet(){
    for (i=1; i<sheetObjects.length; i++){
        ComResizeSheet(sheetObjects[i]);
    }
}


/** 
 * handling work javascript OnFocus event 
 */    
//function obj_activate() {
//   	//delete mask separator
//    ComClearSeparator(ComGetEvent());        
//} 
///**
// * HTML Control onfocus validate event <br>
// **/
//function obj_deactivate(){
//	ComChkObjValid(ComGetEvent());	
//}
function obj_blur(){
//	var formObj = document.form;
//	var obj = ComGetEvent();
//    if (event.srcElement.name == "from_pay_dt"){
//    	ComAddSeparator(formObj.from_pay_dt);
//    	if (ComGetNowInfo("ymd") < formObj.from_pay_dt.value){
//    		formObj.from_pay_dt.value = ComGetNowInfo("ymd");
//    		ComAlertFocus(formObj.from_pay_dt,ComGetMsg("MST01006", "", "", ""));
//    	} else {
//    		if (formObj.from_pay_dt.value.length >= 8 ) {//&&
//    			//replaceAll(formObj.from_pay_dt.value,"-","") < getRelativeTime(0,0,-90,0).substring(0,8)){
//    			ComShowCodeMessage("MST01030");
//    		}
//    		ComAddSeparator(formObj.from_pay_dt, "ymd");
//    	}
//    }
//    else if(event.srcElement.name == "to_pay_dt"){
//    	ComAddSeparator(formObj.to_pay_dt);
//    	if (ComGetNowInfo("ymd") < formObj.to_pay_dt.value){
//    		formObj.to_pay_dt.value = ComGetNowInfo("ymd");
//    		ComAlertFocus(formObj.to_pay_dt,ComGetMsg("MST01006", "", "", ""));
//    	} else {
//    		if (formObj.to_pay_dt.value.length >= 8 &&
//    			replaceAll(formObj.to_pay_dt.value,"-","") < getRelativeTime(0,0,-90,0).substring(0,8)){
//    			ComShowCodeMessage("MST01030");
//    		}
//    		ComAddSeparator(formObj.to_pay_dt, "ymd");
//    	}
//    }   
//    else if(event.srcElement.name == "vndr_no"){
//    	if(formObj.vndr_no.value.length < 1) formObj.vndr_lgl_eng_nm.value = "";
//    }      
}
/* 개발자 작업 끝 */

