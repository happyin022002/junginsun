/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAR_4003.js
*@FileTitle  : Ledger Ots Creation & Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/08
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class STM_SAR_4003 : business script for STM_SAR_4003
 */
// common global variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();        
var comboCnt=0;
var gCurRow=0;
var prefix="sheet1_";
var func_curr="";
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
			case "btn_creation":
				doActionIBSheet(sheetObject1, formObj, MULTI);
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
					cal.select(form.gl_month, 'yyyy-MM');
				break;	
			case "btn_new":
				formObj.acctnm.value = "";
				sheetObjects[0].RemoveAll();
				comboObjects[0].SetSelectIndex(0);
				comboObjects[1].SetSelectIndex(0);
				//comboObjects[2].Index = 0;
				comboObjects[2].SetSelectIndex(-1);
				comboObjects[3].SetSelectIndex(-1);
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
	var prefix="sheet1_";
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC05);
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	// IBMultiCombo Initialize
	for ( var k=0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}
//	var sheetObj = sheetObjects[0];
//	var otsGroupComboItems = SarGetSelectComboItems(sheetObj, "OTS GROUP");
//	SarAddSelectComboItem(comboObjects[2], otsGroupComboItems, "2", "ALL", "ALL");
    initControl();
    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC03);
    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC04);
    //doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    sheetObjects[0].SetCellValue(0, prefix + "cop_krw","Corporate\n" + func_curr + " Amount");
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
	axon_event.addListenerForm('blur', 'obj_blur'    , formObj); 	//- handling code when OnBeforeDeactivate(blur) event
	axon_event.addListenerForm('focus'  , 'obj_focus'   , formObj);            //- handling code when OnBeforeActivate event in case of existing dataformat property
    axon_event.addListenerFormat('keypress'        , 'obj_keypress', formObj); 	//- handling code when onkeypress event in case of existing dataformat property
    axon_event.addListenerFormat('keyup'           , 'form_keyup'  , formObj);
}
//handling Axon event 2
function obj_blur(){
    ComChkObjValid(ComGetEvent());
	var src=ComGetEvent("name");
	switch (src){
	case "gl_month":
		ComAddSeparator(ComGetEvent(),"ym");
		break;
	}
}
function obj_focus(){
    var src=ComGetEvent("name");
	switch (src){
	case "gl_month":
		ComClearSeparator(ComGetEvent());
		break;
	}
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
		with (sheetObj) {
	        var HeadTitle1="|RHQ|Office|Account|Type|Currency|Prev Month\nBalance Amount|This Month\nAmount|This Month\nBalance Amount|Corporate\n Amount|Corporate\nUSD Amount";
	        var headCount=ComCountHeadTitle(HeadTitle1);
	        var prefix="sheet1_";
	
	        SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	
	        var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
	               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rhq_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ots_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"dmst_dr_acct_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ots_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",   Hidden:0, Width:150,  Align:"Right",   ColMerge:1,   SaveName:prefix+"prv_bal",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",   Hidden:0, Width:150,  Align:"Right",   ColMerge:1,   SaveName:prefix+"ths_amt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",   Hidden:0, Width:150,  Align:"Right",   ColMerge:1,   SaveName:prefix+"ths_bal",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",   Hidden:0, Width:150,  Align:"Right",   ColMerge:1,   SaveName:prefix+"cop_krw",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",   Hidden:0, Width:150,  Align:"Right",   ColMerge:1,   SaveName:prefix+"cop_usd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",   Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"",           KeyField:0,   CalcLogic:"",   Format:"",  PointCount:0 }];
	        
//	        ShowSubSum([{StdCol:"rhq_cd", SumCols:"6|7|8|9|10", Sort:false, ShowCumulate:false, CaptionCol:0, CaptionText:"Total"}]); 
//	        SetCellValue(sheetObj.LastRow(),"sts_evnt_ofc_cd",'TOTAL')
	        InitColumns(cols);
	
			SetEditable(1);
			//SetSheetHeight(360);
		    resizeSheet();
   }
   break;
	}
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
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
			//retrieve AR Office List 	
			formObj.f_cmd.value=SEARCH11;
			var sXml=sheetObj.GetSearchData("SARCommonGS.do", FormQueryString(formObj));
			var sStr=ComGetEtcData(sXml,"ots_ofc_cd");
			var arrStr=sStr.split("|");
			MakeRctOfcComboObject(ots_ofc_cd, arrStr);
			for (var i=1; i < arrStr.length; i++ ) {
				var arrStr2=arrStr[i].split("^");
				if(arrStr2[0] == arrStr2[1]){
					ots_ofc_cd.text=arrStr2[1];
					ar_ofc_cd.value=arrStr2[1];
				}
			}
			break;
		case IBSEARCH_ASYNC03: 
			//retrieve AR Office List ALL 	
			var f_query='';
			f_query += 'f_cmd' + '=' + SEARCH11 + '&';
			f_query += 'ar_rhq_cd=ALL';
			var sXml=sheetObj.GetSearchData("SARCommonGS.do", f_query);
			var sStr=ComGetEtcData(sXml,"ots_ofc_cd"); 
			var arrStr=sStr.split("|");
			MakeRctOfcComboObject(ots_ofc_cd, arrStr);
			for (var i=1; i < arrStr.length; i++ ) {
				var arrStr2=arrStr[i].split("^");
				if(arrStr2[0] == arrStr2[1]){
					ots_ofc_cd.text=arrStr2[1];
					ar_ofc_cd.value=arrStr2[1];
				}
			} 
			break;	
		case IBSEARCH_ASYNC02:
			//retrieve AR RHQ List 	
			formObj.f_cmd.value=SEARCH09;
			var sXmlRhq=sheetObj.GetSearchData("SARCommonGS.do", FormQueryString(formObj));
			var sStrRhq=ComGetEtcData(sXmlRhq,"rhq_cd");
			var arrStrRhq=sStrRhq.split("|");
			MakeRhqComboObject(rhq_cd, arrStrRhq);
			break;
		case IBSEARCH_ASYNC03: 
			formObj.f_cmd.value=SEARCH10;
			var sXml=sheetObj.GetSearchData("SARCommonGS.do", FormQueryString(formObj));
			var sStr=ComGetEtcData(sXml,"ar_acct_cd");
			if(!ComIsNull(sStr)) {
				var arrStr=sStr.split("|");
				MakeAcctComboObject(acct_cd, arrStr);
			}
			break;
		case IBSEARCH_ASYNC04: 
			formObj.f_cmd.value=SEARCH08;
			var sXml=sheetObj.GetSearchData("SARCommonGS.do", FormQueryString(formObj));
			var sStr=ComGetEtcData(sXml,"curr_cd_list");
			var arrStr=sStr.split("|");
			MakeCurrComboObject(curr_cd, arrStr);
			break;
		case IBSEARCH_ASYNC05: 
			formObj.f_cmd.value=SEARCH02;
			var sXml=sheetObj.GetSearchData("STM_SAR_4003GS.do", FormQueryString(formObj));
			func_curr=ComGetEtcData(sXml,"func_curr");
			break;
		case IBSEARCH: //retrieve
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);	
			setTimeout( function () {
				formObj.f_cmd.value=SEARCH;
				sheetObj.DoSearch("STM_SAR_4003GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
				ComOpenWait(false);
			} , 100);	
			break;
		case MULTI: //retrieve
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);	
			setTimeout( function () {
				formObj.f_cmd.value=MULTI;
				formObj.flgCd.value="Y" ;
				sheetObj.DoSearch("STM_SAR_4003GS.do",FormQueryString(formObj)  );
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
			if(formObj.gl_month.value == ""){
				ComShowCodeMessage("COM12113", "GL Month");
				ComSetFocus(document.all.item("gl_month"));
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
	check_sum();
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
 * init combo box<br>
 * <br><b>Example :</b>
 * <pre>
 * 
 * </pre>
 * @param {IBMultiCombo} comboObj  comboObj
 * @return none
 * @see #
 * @author 박정진
 * @version 2009.04.27
 */
function initCombo(comboObj, comboNo) {
	switch (comboObj.options.id) {
		case "acct_cd":
			with (comboObj) {
				//SetColAlign("left");
				SetColWidth(0, "60");
				SetColWidth(1, "200");
				SetMultiSelect(0);
				SetDropHeight(200);
				ValidChar(5); 
			}
			break;
			
	   case "curr_cd":
			with (comboObj) {
		   		SetDropHeight(200);
		   		SetMultiSelect(false)
		   		SetUseAutoComplete(true)
	 			SetMaxSelect(1)
	 			SetColAlign(0, "left");
			    SetColWidth(0, "80");
			    ValidChar(2); 
			   }
            break;
	   case "ots_ofc_cd":   
			with (comboObj) {  
		   		SetDropHeight(200);
		   		SetMultiSelect(false)
		   		SetUseAutoComplete(true)
	 			SetMaxSelect(1)
	 			SetColAlign(0, "left"); 
		   		SetColWidth(0, "80");
			    ValidChar(2); 
			   }
           break;		
	}
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
} 
/**
 * create combo box<br>
 * <br><b>Example : </b>
 * <pre>
 *    MakeRhqComboObject(cmbObj, arrStr);
 * </pre>
 * @param object cmbObj
 * @param String arrStr
 * @author Lee Yong Jun
 * @version 2014.03.24
 */
function MakeRhqComboObject(cmbObj, arrStr) {
	for (var i=1; i < arrStr.length; i++ ) {
		var arrStr2=arrStr[i].split("^");
		var rhq_cd=arrStr2[0];
		cmbObj.InsertItem(i-1, rhq_cd, arrStr[i]);			 
	}
}  
/**
 * create combo box<br>
 * <br><b>Example : </b>
 * <pre>
 *    MakeAcctComboObject(cmbObj, arrStr);
 * </pre>
 * @param object cmbObj
 * @param String arrStr
 * @author Lee Yong Jun
 * @version 2014.03.24
 */
function MakeAcctComboObject(cmbObj, arrStr) {
	for (var i=1; i < arrStr.length; i++ ) {
		var arrStr2=arrStr[i].split("^");
		var acct_cd=arrStr2[0];
		var acct_nm=arrStr2[1];
		cmbObj.InsertItem(i-1, acct_cd + "|" + acct_nm, arrStr[i]);			 
	}
}  
/**
 * create combo box<br>
 * <br><b>Example : </b>
 * <pre>
 *    MakeCurrComboObject(cmbObj, arrStr);
 * </pre>
 * @param object cmbObj
 * @param String arrStr
 * @author Lee Yong Jun
 * @version 2014.03.24
 */
function MakeCurrComboObject(cmbObj, arrStr) {
	for (var i=1; i < arrStr.length; i++ ) {
		var arrStr2=arrStr[i].split("^");
		var curr_cd=arrStr2[0];
		cmbObj.InsertItem(i-1, curr_cd, arrStr[i]);			 
	}
} 
/**
 * function called when combo box rct_ofc_cd change<br>
 * @param object comboObj
 * @param String value
 * @param String text
 * @author Park sung yong
 * @version 2014.03.26
 */	
function ots_ofc_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){ 
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var arrStr=newCode;
	//if(loadPageflg == "Y") return;
	sheetObjects[0].RemoveAll();
	formObj.ar_ofc_cd.value=newCode;
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
/**
 * function called when combo box rhq_cd change<br>
 * @param object comboObj
 * @param String value
 * @param String text
 * @author Lee Yong Jun
 * @version 2014.03.26
 */	
function rhq_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){ 
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var arrStr=newCode;
	//sheetObjects[0].RemoveAll();
	formObj.ar_rhq_cd.value="";
	if (newCode!= ""){
		comboObjects[1].RemoveAll();
		formObj.ar_ofc_cd.value="";
		formObj.ar_rhq_cd.value=newCode;
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
	} else {
		comboObjects[1].RemoveAll();
		formObj.ar_ofc_cd.value="";
		formObj.ar_rhq_cd.value="";  
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC03);
	}
}
/**
 * function called when combo box acct_cd change<br>
 * @param object comboObj
 * @param String value
 * @param String text
 * @author Lee Yong Jun
 * @version 2014.03.26
 */	
function acct_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){ 
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var arrStr=newCode;
	var temp=arrStr.split("^");
	if(newCode!=""&&newCode!=undefined){
		formObj.ar_acct_cd.value=newText;
		formObj.acctnm.value=temp[1];
		//form.acct_cd_text.value = comboObj.GetText(parseInt(newIndex), 0);
	} else {
		formObj.ar_acct_cd.value="";
		formObj.acctnm.value = "";
	}
}
/**
 * function called when combo box curr change<br>
 * @param object comboObj
 * @param String value
 * @param String text
 * @author Lee Yong Jun
 * @version 2014.03.26
 */	
function curr_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){ 
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
//	var arrStr=value.split("^");
	//sheetObjects[0].RemoveAll();
	formObj.curr.value=newCode;
}
function check_sum() {
	var formObject=document.form;
	var prefix="sheet1_";
	if (sheetObjects[0].RowCount()> 0) {
		var jpySum = 0
		var UsdSum = 0
		
		for(var j = sheetObjects[0].HeaderRows(); j <= sheetObjects[0].LastRow(); j++) {
			//console.log(parseFloat(ComReplaceStr(sheetObjects[0].GetCellValue(j, prefix+"cop_krw"),",","")));
			jpySum +=  parseFloat(ComReplaceStr(sheetObjects[0].GetCellValue(j, prefix+"cop_krw"),",",""));   
			UsdSum +=  parseFloat(ComReplaceStr(sheetObjects[0].GetCellValue(j, prefix+"cop_usd"),",",""));     
		}
		var Row=sheetObjects[0].DataInsert(-1);
		var prefix="sheet1_";
		sheetObjects[0].SetCellValue(Row,prefix+"rhq_cd",'TOTAL',0);
		sheetObjects[0].SetCellValue(Row,prefix+"ots_ofc_cd",'',0);
		sheetObjects[0].SetCellValue(Row,prefix+"dmst_dr_acct_cd",'',0);
		sheetObjects[0].SetCellValue(Row,prefix+"ots_tp_cd",'',0);
		sheetObjects[0].SetCellValue(Row,prefix+"bl_curr_cd",'',0);
		sheetObjects[0].SetCellValue(Row,prefix+"prv_bal",'',0);
		sheetObjects[0].SetCellValue(Row,prefix+"ths_amt",'',0); 
		sheetObjects[0].SetCellValue(Row,prefix+"ths_bal",'',0);
		sheetObjects[0].SetCellValue(Row,prefix+"cop_krw",ComAddComma2(String(ComRound(jpySum,0)), "#,###"),0);
		sheetObjects[0].SetCellValue(Row,prefix+"cop_usd",ComAddComma2(String(ComRound(UsdSum,2)), "#,###.00"),0);   
	}
	return;
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
