/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : stm_sar_5003.js // 수정
*@FileTitle  : Agent Statement of Account Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class STM_SAR_5003 : business script for STM_SAR_5003
 */
// common global variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var combo1=null
var comboCnt=0;
var gCurRow=0;
var prefix="sheet1_";
// Event handler processing by button click event */
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
// Event handler processing by button name */
/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */   
function processButtonClick() {
	/***** setting sheet object *****/
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/    
	var sheetObject1=sheetObjects[0];
	/*******************************************************/
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		 /***********************************************************************************************************
	        이미지 클릭 이벤트 처리, popup도 역시 이곳에서 함
	        공통코드: CoFormControl.js 에 정의 되어있습니다. 이 변수를 통하여 ServiceCommand에서 분기 합니다.        
	     **********************************************************************************************************/
		/*
	        이곳에 document.form 혹은 document.form[0]식으로 코딩하시는 것을 삼가해 주십시오.
	        메뉴가 적용되면 left_menu.jsp에 form 이 존재할 것이기 때문에 더이상 form[0]이 아닙니다.
	        (순서상도 form[1]이 되겠죠?) 
	        그리고 위에서 with(document.form)라고 했기때문에 (브라우저의 DOM 객체중 특정부분만 잡는다는 의미니깐!)
	         document.form.f_cmd.value=INSERT;   이런식의 코딩은 지양해주십시오.
	     */
		switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject1, formObj, IBSEARCH);
				break;
			case "btn_OK":
				if(sheetObject1.RowCount()== 0){
					ComClosePopup(); 
				}else{
					comPopupOK();
				}
				break;
    	    case "btn_New":
    	    	sheetObject1.RemoveAll();
    	    	formObj.reset();
    	        break;
			case "btn_Close":
				ComClosePopup(); 
    	        break;				
			case "btn_print":
				var dupRow1=sheetObjects[0].ColValueDup(prefix + "chg_tp_cd");
	            alert("dupRow1  == " + dupRow1)
	            // Dup data pre-check before saving
	            if (dupRow1>0) {  
	            	sheetObject1.SetSelectRow(dupRow1);
	            	ComShowCodeMessage('SCO00004', 'Check', 'Duplicated Type');
	                ComSetFocus(sheetObject1.ColValueDupRows(prefix + "chg_tp_cd"));	
	                return false;
	            }
				break;
			case "btnCalduedtFm": 
				var cal=new ComCalendar();
				cal.setDisplayType('month');
				cal.select(form.bil_cre_prd_fm_dt, 'yyyy-MM');
				break;
			case "btnCalduedtTo": 
				var cal=new ComCalendar();
				cal.setDisplayType('month');
				cal.select(form.bil_cre_prd_to_dt, 'yyyy-MM');
				break;
			case "btn_pop_ofc_cd":
		        ComOpenPopupWithTarget("/opuscntr/STM_SAP_0001.do?ofc_cd="+document.form.ar_ofc_cd.value, 480, 550,"ap_ofc_cd:ar_ofc_cd", "0,0", true);
		        //ComOpenPopupWithTarget("/opuscntr/STM_SAR_0200.do?asa_no="+document.form.ofc_cd.value, 480, 550,"asa_no:ofc_cd", "0,0", true);
		        break;
			case "btn_new":
				formObj.reset();
				sheetObjects[0].RemoveAll();
				break;
			case "btn_downexcel":
				if(sheetObject1.RowCount() < 1){//no data	
					ComShowCodeMessage("COM132501");
				}else{	
					sheetObject1.Down2Excel();
				}	
    	    	break;
		} // end switch
	} catch (e) {
		/*
        자바 스크립트 에러가 발생할시 오동작이 납니다. 고객에게 이 경우 아래의 메세지가 뿌려지게 해야합니다.
        물론 화면에서 다음의 메세지를 보시면 무조건 '자바스크립트 에러구나'라고 확인하실수 가 있습니다.
        */
		if (e == "[object Error]") {
			ComShowCodeMessage('SAP00001');
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
/**
 * IBSheet Object를 배열로 등록
 * comSheetObject(id)에서 호출한다
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/** 
 * registering IBCombo Object as list
 * param : combo_obj
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */ 
function setComboObject(combo_obj) {  
    comboObjects[comboCnt++]=combo_obj;  
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
/**
 * Sheet 기본 설정 및 초기화 
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	// IBMultiCombo초기화
	agn_ofc_cd=comboObjects[0];
	comboCnt=comboObjects.length;
	for (var k=0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k]);
	}
    initControl();
    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
    //doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
/**
* 콤보 초기설정값
* @param {IBMultiCombo} comboObj  comboObj
*/
function initCombo(comboObj) {
	comboObj.SetMultiSelect(0);
//no support[check again]CLT 	comboObj.UseCode=true;
//no support[check again]CLT 	comboObj.LineColor="#7896B1";	
	comboObj.SetMultiSeparator(",");
	comboObj.SetDropHeight(240);
	comboObj.SetBackColor("#CCFFFD");
}
/**
 * loading HTML Control event <br>
 * {@link #loadPage} function call this. so IBSheet Object is initialized. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sequence number in sheetObjects array
 **/
function initControl() {
	//** Date Separator **/
	DATE_SEPARATOR="-";
	var formObj=document.form;
    //handling Axon event. event catch
//    axon_event.addListenerFormat('keypress',	'obj_keypress',		formObj); 	//- handling code when onkeypress event in case of existing dataformat property
//    axon_event.addListenerFormat('keyup',		'form_keyup'  , 	formObj);
    axon_event.addListenerForm  ('blur',		'obj_deactivate',  	formObj);            
//    axon_event.addListenerFormat('focus',		'obj_activate',    	formObj);
    axon_event.addListenerFormat('keydown',		'obj_keydown', 		formObj);
}
//handling Axon event 2
function obj_blur(){
    ComChkObjValid(event.srcElement);
	var src=ComGetEvent("name")
}

function obj_keypress(){
	var src=ComGetEvent("name")
}
function form_keyup(){
	ComKeyEnter('lengthnextfocus');
}
function obj_onclick(){
	var src=ComGetEvent("name")
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;	
	switch (sheetNo) {
	case 1: //t1sheet1 init
	    with(sheetObj){
	      var HeadTitle1="|ASA No|CUR|From Date|To Date|Balance Brought|Collect-Refund|Expense|Commission|Remittance|Balance Carried|Actual Balance|Unsettled Balance|Finish Date|Approved Date";
	      var headCount=ComCountHeadTitle(HeadTitle1);
	      (headCount, 0, 0, true);
	      var prefix="sheet1_";
	
	      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	      InitHeaders(headers, info); 
	
	      var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"asa_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"curr_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:12 },
	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bil_cre_prd_fm_dt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bil_cre_prd_to_dt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"prev_bal_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
	             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"rev_rfd_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
	             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"expense_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
	             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"comm_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
	             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"rmtc_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
	             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"last_bal_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
	             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"actual_bal_amt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
	             {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"unset_bal_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"agn_asa_cre_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"apro_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	       
	      InitColumns(cols);
	      SetEditable(1);
	      sheetObj.SetColProperty(prefix+"bil_cre_prd_fm_dt", {Format:"####-##-##"} );
		  sheetObj.SetColProperty(prefix+"bil_cre_prd_to_dt", {Format:"####-##-##"} );
		  sheetObj.SetColProperty(prefix+"agn_asa_cre_dt", {Format:"####-##-##"} );
		  sheetObj.SetColProperty(prefix+"apro_dt", {Format:"####-##-##"} );
//		  SetSheetHeight(360);
		  resizeSheet();
   }
   break;
	}
}

function resizeSheet(){
	ComResizeSheet(sheetObjects[0], 130);
}

// handling sheet process Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	var prefix="sheet1_";
	var form=document.form;
	var sheetObject1=sheetObjects[0];
	if (!validateForm(sheetObj, formObj, sAction))
		return;
	switch (sAction) {	
		case IBSEARCH_ASYNC01: 
			formObj.f_cmd.value=SEARCH03;	
			var param="f_cmd=" + SEARCH03 + "&ofc_lvl_tp=ENTRY&ofc_brnc_agn_tp_cd=AGT";
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			var sXml=sheetObj.GetSearchData("SARCommonGS.do", param);
			var strOtsOfcCd=ComGetEtcData(sXml,"ots_ofc_cd");	
			if (!ComIsNull(strOtsOfcCd)) {
				var ofcList=strOtsOfcCd.split("|");
				// -------------------------------------------------------------------------------------------------------------------
				//|OtsOfcCd^ArOfcCd^RhqCd^OtsSmryCd^OtsCd^RepOtsOfcCd^RctTpCd^RctUnapyFlg^OfcEntrLvlCd^ArCurrCd^DpPrcsKnt^BankCtrlCd^agnCurrCd^agnPfxCd^agnOtsLmtAmt
				//|0       ^1      ^2    ^3        ^4    ^5          ^6      ^7          ^8           ^9       ^10       ^11        ^12       ^13      ^14
				// -------------------------------------------------------------------------------------------------------------------
				for (var i=1; i < ofcList.length; i++ ) {
					var ofcInfo=ofcList[i].split("^");
					agn_ofc_cd.InsertItem(i-1, ofcInfo[0], ofcList[i]);	
				}			
				for (var i=1; i < ofcList.length; i++ ) {
					var ofcInfo=ofcList[i].split("^");
					if(ofcInfo[0] == ofcInfo[1]){
						agn_ofc_cd.SetSelectText(ofcInfo[1]);  
						formObj.ar_ofc_cd.value=ofcInfo[1];
					}
				}	
			}			
			ComOpenWait(false);
			break;
		case IBSEARCH: //retrieve
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);	
		    setTimeout( function () {
				formObj.f_cmd.value=SEARCH;
	 			sheetObj.DoSearch("STM_SAR_5003GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"),{Sync:2} );
				ComOpenWait(false);
		    } , 100);
			break;
	}
}
/**
 * handling process for input validation 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case IBSEARCH: //retrieve
			if(agn_ofc_cd.GetSelectText() == ""){
				ComShowCodeMessage("COM12113", "Office Code");
				ComSetFocus(document.all.item("agn_ofc_cd"));
				return false;
			}
			break;
	}
	return true;
}
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	//if combined data
	for (var i=sheetObj.HeaderRows(); i<= sheetObj.LastRow(); i++){
		}
}
function sheet1_OnChange(sheetObj, Row, Col, Value) {
}
/**
 * IBSeet내의 데이터 셀의 팝업 버튼이 눌러졌을 때 발생하는 Event<br>
 * @param {sheetObj} String : 해당 IBSheet셀 명
 * @param {Row} Long : 해당 셀의 Row Index
 * @param {Col} Long : 해당 셀의 Column Index
 */	
function sheet1_OnPopupClick(sheetObj, Row, Col){
}
/**
 * create combo box<br>
 * <br><b>Example : </b>
 * <pre>
 *    MakeRctOfcComboObject(cmbObj, arrStr);
 * </pre>
 * @param object cmbObj
 * @param String arrStr
 * @author Park sung yong
 * @version 2014.03.24
 */
function MakeRctOfcComboObject(cmbObj, arrStr) {
	for (var i=1; i < arrStr.length; i++ ) {
		var arrStr2=arrStr[i].split("^");
		var ots_ofc_cd=arrStr2[0];
		cmbObj.InsertItem(i-1, ots_ofc_cd, arrStr[i]);			 
	}
	cmbObj.SetDropHeight(190);
}  

function obj_deactivate(){    
    // 2013-08-27 Recovery PQC test defects by J.H Han
    var obj=ComGetEvent();
    var formObj=document.form;
    if ( ComTrim(obj.value) != "" ) {
        switch(ComGetEvent("name")) {
            case "bil_cre_prd_fm_dt":
                ComAddSeparator(obj, "ym");
                break;
            case "bil_cre_prd_to_dt":
                ComAddSeparator(obj, "ym");
                break;
        }
    }
} 
/**
 * HTML Control activate event <br>
 **/
function obj_activate(){   
    ComClearSeparator(ComGetEvent());
}

/**
 * function called when combo box rct_ofc_cd change<br>
 * @param object comboObj
 * @param String value
 * @param String text
 * @author Park sung yong
 * @version 2014.03.26
 */	

function agn_ofc_cd_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, newtext, newcode){ 
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var arrStr=newtext.split("^");
	//if(loadPageflg == "Y") return;
	sheetObjects[0].RemoveAll();
	formObj.ar_ofc_cd.value=arrStr[0];
	/*
	formObj.rhq_cd.value=arrStr[2];
	formObj.ots_smry_cd.value=arrStr[3]; 
	formObj.ots_cd.value=arrStr[4]; 
	formObj.rep_ots_ofc_cd.value=arrStr[5]; 
	formObj.rct_tp_cd.SetSelectCode(arrStr[6]);
	formObj.rct_unapy_flg.value=arrStr[7]; 
	formObj.ofc_entr_lvl_cd.value=arrStr[8]; 
	formObj.bank_ctrl_cd.value=arrStr[11];
	*/
}
/*
function sheet1_OnDblClick(sheetObj, Row, Col) {
	 comPopupOK();
}
function sheet1_OnClick(sheetObj, Row, Col){
	alert("aaaaa");
window.returnValue=sheetObj.GetCellValue(sheetObj.GetSelectRow(), 'asa_no');
}
//no support[check again]CLT function sheet1_OnLoadFinish(sheetObj) {
    sheetObj.SetWaitImageVisible(0);
	 for (i=0; i < sheetObjects.length; i++) {
	     doActionIBSheet(sheetObjects[i], document.form, IBSEARCH);
	 }
    doActionIBSheet(sheetObj,document.form,IBCLEAR);
    sheetObj.SetWaitImageVisible(1);
}
*/

/**
 * Handling OnKeyDown even <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param N/A
 * @return N/A
 * @author 
 * @version 2009.04.17
 */       
function obj_keydown(){
	var formObj = document.form;	
	//Proposal No,S/C No.,Retrieving by enter key
	var eleName=ComGetEvent("name");
	var keyValue=null;
	if(event == undefined || event == null) {
		keyValue=13;
	} else {
		keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	}
	
	if ((keyValue == 9 || keyValue == 13)  && eleName == "asa_no3_fm") {
		if(formObj.asa_no3_fm.value.length == "1"){
			formObj.asa_no3_fm.value = "000" + formObj.asa_no3_fm.value;		   
		}else if(formObj.asa_no3_fm.value.length == "2"){
			formObj.asa_no3_fm.value = "00" + formObj.asa_no3_fm.value;
		}else if(formObj.asa_no3_fm.value.length == "3"){
			formObj.asa_no3_fm.value = "0" + formObj.asa_no3_fm.value;
		}
	}
	
	if ((keyValue == 9 || keyValue == 13)  && eleName == "asa_no3_to") {
		if(formObj.asa_no3_to.value.length == "1"){
			formObj.asa_no3_to.value = "000" + formObj.asa_no3_to.value;		   
		}else if(formObj.asa_no3_to.value.length == "2"){
			formObj.asa_no3_to.value = "00" + formObj.asa_no3_to.value;
		}else if(formObj.asa_no3_to.value.length == "3"){
			formObj.asa_no3_to.value = "0" + formObj.asa_no3_to.value;
		}
	}
}
