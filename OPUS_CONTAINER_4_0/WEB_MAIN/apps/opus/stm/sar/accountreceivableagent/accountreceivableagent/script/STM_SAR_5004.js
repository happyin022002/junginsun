/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAR_5004.js
*@FileTitle  : Unreported OTS Report
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
 * @class STM_SAR_5004 : business script for STM_SAR_5004
 */
// common global variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();        
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
					cal.select(form.due_dt_fm, 'yyyy-MM-dd');
				break;	
			case "btn_pop_ofc_cd":
		        ComOpenPopupWithTarget("/opuscntr/STM_SAP_0001.do?ofc_cd="+document.form.ar_ofc_cd.value, 480, 550,"ap_ofc_cd:ar_ofc_cd", "0,0", true);
		        //ComOpenPopupWithTarget("/opuscntr/STM_SAR_0200.do?asa_no="+document.form.ofc_cd.value, 480, 550,"asa_no:ofc_cd", "0,0", true);
		        break;
			case "btn_pop_asa_cd":
				if(agn_ofc_cd.GetSelectText() == ""){
					ComShowCodeMessage("COM12113", "Office Code");
					ComSetFocus(document.all.item("agn_ofc_cd"));
					return false;
				}
		        ComOpenPopupWithTarget("/opuscntr/STM_SAR_0200.do?asa_no="+ document.form.asa_no1.value + "&ofc_cd="+document.form.ar_ofc_cd.value    , 480, 550,"asa_no1:asa_no1|asa_no2:asa_no2|asa_no3:asa_no3|bil_cre_prd_fm_dt:gl_yrmon_fm|bil_cre_prd_to_dt:gl_yrmon_to|bil_cre_prd_to_dt:due_dt_fm", "0,0", true);
		        break;
			case "btn_save":
				var dupRow1=sheetObject1.ColValueDup("2|3|4");
				if (dupRow1>0) {  
	            	ComShowCodeMessage("SAR00002");
	            	sheetObject1.RowForeColor(dupRow1)="#FF0000";
	            	return false;
	            }
				doActionIBSheet(sheetObject1,formObj,IBSAVE);
				break;
			case "btn_add":
				doActionIBSheet(sheetObject1,formObj,IBINSERT);
				break;
			case "btn_del":
				doActionIBSheet(sheetObject1,formObj,REMOVE);
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
    //axon_event.addListenerFormat('keypress'        , 'obj_keypress', formObj); 	//- handling code when onkeypress event in case of existing dataformat property
    axon_event.addListenerFormat('keyup'           , 'form_keyup'  , formObj);
}
//handling Axon event 2
function form_keyup(){
	ComKeyEnter('lengthnextfocus');
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
		// setting height
		
		// setting width
		var HeadTitle1="|NO|VVD|B/L NO|S/A Date|Due Date |Actual Balance USD|ASA Collection USD|To Be Balance USD";
		var headCount=ComCountHeadTitle(HeadTitle1);
		(headCount, 0, 0, true);

		SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		InitHeaders(headers, info);
		var prefix="sheet1_";
		//data property    [	ROW, COL,  DATATYPE,   		WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  							KEYFIELD, 	CALCULOGIC, DATAFORMAT, 		POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, 	FULLINPUT, 	SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:12 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"sail_arr_dt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"due_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"AutoSum",   Hidden:0, Width:180,  Align:"Right",   ColMerge:1,   SaveName:prefix+"act_usd",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
		             {Type:"AutoSum",   Hidden:0, Width:180,  Align:"Right",   ColMerge:1,   SaveName:prefix+"asa_usd",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
		             {Type:"AutoSum",   Hidden:0, Width:180,  Align:"Right",   ColMerge:1,   SaveName:prefix+"tobe_usd",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 } ];
		InitColumns(cols);
		//SetSheetHeight(360);
		resizeSheet();
		
		}
		sheetObj.SetColProperty(prefix+"due_dt", {Format:"####-##-##"} );
		sheetObj.SetColProperty(prefix+"sail_arr_dt", {Format:"####-##-##"} );
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
						agn_ofc_cd.SetSelectText(ofcInfo[1],false);
						formObj.ar_ofc_cd.value=ofcInfo[1];
						formObj.asa_no1.value=ofcInfo[13];
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
	 			sheetObj.DoSearch("STM_SAR_5004GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"),{Sync:2} );
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
			if(formObj.asa_no1.value == ""||ComIsNull(formObj.asa_no1.value)){
				ComShowCodeMessage("COM12113", "ASA NO1");
				ComSetFocus(document.all.item("asa_no1"));
				return false;
			}
			if(formObj.asa_no2.value == ""||ComIsNull(formObj.asa_no2.value)){
				ComShowCodeMessage("COM12113", "ASA NO2");
				ComSetFocus(document.all.item("asa_no2"));
				return false;
			}
			if(formObj.asa_no3.value == ""||ComIsNull(formObj.asa_no3.value)){
				ComShowCodeMessage("COM12113", "ASA NO3");
				ComSetFocus(document.all.item("asa_no3"));
				return false;
			}
		case IBSAVE:	
			if(agn_ofc_cd.GetSelectText() == ""){
				ComShowCodeMessage("COM12113", "Office Code");
				ComSetFocus(document.all.item("agn_ofc_cd"));
				return false;
			}
			if(formObj.asa_no1.value == ""||ComIsNull(formObj.asa_no1.value)){
				ComShowCodeMessage("COM12113", "ASA NO1");
				ComSetFocus(document.all.item("asa_no1"));
				return false;
			}
			if(formObj.asa_no2.value == ""||ComIsNull(formObj.asa_no2.value)){
				ComShowCodeMessage("COM12113", "ASA NO2");
				ComSetFocus(document.all.item("asa_no2"));
				return false;
			}
			if(formObj.asa_no3.value == ""||ComIsNull(formObj.asa_no3.value)){
				ComShowCodeMessage("COM12113", "ASA NO3");
				ComSetFocus(document.all.item("asa_no3"));
				return false;
			}
		case IBINSERT: // inserting	
			if(agn_ofc_cd.GetSelectText() == ""){
				ComShowCodeMessage("COM12113", "Office Code");
				ComSetFocus(document.all.item("agn_ofc_cd"));
				return false;
			}
			if(formObj.asa_no1.value == ""||ComIsNull(formObj.asa_no1.value)){
				ComShowCodeMessage("COM12113", "ASA NO1");
				ComSetFocus(document.all.item("asa_no1"));
				return false;
			}
			if(formObj.asa_no2.value == ""||ComIsNull(formObj.asa_no2.value)){
				ComShowCodeMessage("COM12113", "ASA NO2");
				ComSetFocus(document.all.item("asa_no2"));
				return false;
			}
			if(formObj.asa_no3.value == ""||ComIsNull(formObj.asa_no3.value)){
				ComShowCodeMessage("COM12113", "ASA NO3");
				ComSetFocus(document.all.item("asa_no3"));
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
 * Duplicate Check
 * @param {ibsheet}	sheet	IBSheet Object
 * @return
 */        
function chkDupRow(sheet){
	var idx=0;
 	var Rows;
 	Rows=sheet.ColValueDup("2|3|4");
//no support[check again]CLT 	alert("chkDupRow Rows=" + Rows );
	var arr_rows=null;
 	if (Rows!=null && Rows.trim()!=''){
		arr_rows=Rows.split(',');
	}
	for (var i=0; arr_rows!=null && i<arr_rows.length; i++){
		sheet.SetRowFontColor(arr_rows[i],"#FF0000");
		sheet.SetCellValue(arr_rows[i],"dup_chk_conf",++idx,0);
	}
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
