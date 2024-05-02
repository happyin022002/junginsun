/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAR_1002.js
*@FileTitle  : Outstanding Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class STM_SAR_1002 : business script for STM_SAR_1002
 */
// common global variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();        
var combo1=null;
var comboCnt=0;
//combo1 office list
var ofcList=null;
var gCurRow=0;
var prefix="sheet1_";
var hiddenYn = "N";
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
			case "btnCalasofDt": 
				var cal=new ComCalendar();
				cal.select(form.sail_arr_dt, 'yyyy-MM-dd');
				break;
			case "btnCalasofDtfm":   
				var cal=new ComCalendar();
				cal.select(form.sail_arr_dt_fm, 'yyyy-MM-dd');
				break;	
			case "btnCalasofDtto":   
				var cal=new ComCalendar();
				cal.select(form.sail_arr_dt_to, 'yyyy-MM-dd');
				break;	
			case "btn_print":
				break;
			case "btn_pop_ofc_cd":
		        ComOpenPopupWithTarget("/opuscntr/STM_SAP_0001.do?ofc_cd="+document.form.ofc_cd.value, 480, 550,"ap_ofc_cd:ofc_cd", "0,0", true);
		        //ComOpenPopupWithTarget("/opuscntr/STM_SAR_0200.do?asa_no="+document.form.ofc_cd.value, 480, 550,"asa_no:ofc_cd", "0,0", true);
		        break;
			case "btn_pop_cust_cd":
				var cust_cnt_cd=formObj.rct_cust_cnt_cd.value;
				var cust_seq=formObj.rct_cust_seq.value;
				var classId="STM_SAR_9003"; 
				var param='?cust_cnt_cd='+cust_cnt_cd+'&cust_seq='+cust_seq+'&pop_yn=Y&classId='+classId;
				ComOpenPopup('/opuscntr/STM_SAR_9003.do' + param, 900, 450, 'getSTM_SAR_9003', '0,0', true, false);
				break;	
			case "btn_pop_credit_cust":
				var formObject=document.form; 
				if(formObject.rct_cust_cnt_cd.value != "" && formObject.rct_cust_seq.value != "") {
					var param='?cust_cnt_cd='+formObject.rct_cust_cnt_cd.value+'&cust_seq='+formObject.rct_cust_seq.value+'&pop_yn=Y&ret_yn=Y';
					ComOpenPopup('/opuscntr/STM_SAR_9002.do' + param, 1300, 650, 'getPopData', '0,0', true, false, "", "", 0);
				}
				break; 	
			case "btn_downexcel":
				if(sheetObject1.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
					
					if(sheetObject1.RowCount() >= sheetObject1.GetTotalRows() ) {
						sheetObject1.Down2Excel({ HiddenColumn:1,TreeLevel:false,SheetName:"Outstanding Inquery"}); 
					} else {
						ComShowCodeMessage("SAR00072");  //To retrieve all data, please scroll down to the bottom and click down excel.
					}				
					
				}
    	    	break;
			case "btn_multi_office_popup":
				 // 팝업Open시 선택되어야 하는 Office Code 를 다중으로  설정 
				 //  선택 불필요시 var param = "";  으로 설정
				 var ofcLvlTp="&ofc_lvl_tp=";
				  if (selOfcCds == "") {
					  ofcLvlTp="?ofc_lvl_tp=";
				  }
				  var param=selOfcCds + ofcLvlTp + "QUERY"; 
				  var popupMultiWin=ComOpenPopup('/opuscntr/STM_SAR_0003.do' + param, 200, 600, 'getSTM_SAR_0003', '0,1', false, false);
				  popupMultiWin.focus();
				  break;
			case "btn_new":
				formObj.reset();
				formObj.f_cust_cnt_cd.value = "";
				formObj.f_cust_seq.value = "";
				sheetObjects[0].RemoveAll();
				//comboObjects[1].SetSelectIndex(0);
				comboObjects[2].SetSelectIndex(0);
				comboObjects[2].RemoveAll();
				formObj.ots_grp_tp_desc.text ="";
				ots_tp_cd.SetEnable(0);
				//combo1.SetSelectText(combo1.GetSelectCode());
				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
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
var selOfcCds="";
/**
 * Muti office popup callback function
 */
function getSTM_SAR_0003(data) { 
    // 반환 index 
 //      data[0 ] =  ibflag
 //  data[1 ] =  checkbox
 //  data[2 ] =  OTS_OFC_CD   
 //  data[3 ] =  ofc_brnc_agn_tp_cd
 //  data[4 ] =  rhq_cd           
 //  data[5 ] =  ar_curr_cd
 //  data[6 ] =  ots_smry_cd
 //  data[7 ] =  dp_prcs_knt
 //  data[8 ] =  bank_ctrl_cd
 //  data[9 ] =  ofc_entr_lvl_cd
 //  data[10] =  ar_ofc_cd
 //  data[11] =  ots_cd
 //  data[12] =  rct_tp_cd
 //  data[13] =  rep_ots_ofc_cd
 //  data[14] =  rct_unapy_flg
    var multiOfcCd="";
    var multiRhqCd="";
    for(var i=0; i < data.length; i++) {
        var row=data[i];
        if (i > 0 ) {        	
        	multiOfcCd +=  " , '" + row[2] +"'";
        	multiRhqCd +=  " , '" + row[4] +"'";
        	selOfcCds +=  "&selOfcCds=" + row[2];
        } else {
        	multiOfcCd +=  "'" + row[2] +"'";
        	multiRhqCd +=  "'" + row[4] +"'";
        	selOfcCds +=  "?selOfcCds=" + row[2];
        }    
    }
    var frm=document.form;
    frm.ofc_cd.value=multiOfcCd;
    frm.rhq.value=multiRhqCd;
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
    initControl();
    
    // IBMultiCombo Initialize
    combo1=comboObjects[0];
	for ( var k=0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}
	var sheetObj=sheetObjects[0];
	var otsGroupComboItems=SarGetSelectComboItems(sheetObj, "OTS GROUP");
	SarAddSelectComboItem(comboObjects[1], otsGroupComboItems, "3", "ALL", "ALL");
	doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC01);
}

function resizeSheet(){
	ComResizeSheet(sheetObjects[0],60);
}


function comboloadOtsType() {
   var sheetObj=sheetObjects[0];
   comboObjects[2].RemoveAll();  //.DeleteItem(0);
   document.form.ots_tp_cd_nm.value="";
   var otsTypeComboItems=SarGetSelectComboItems(sheetObj, "OTS TYPE",  "&attr_ctnt2=" + document.form.ots_grp_tp_cd.value );
   SarAddSelectComboItem(comboObjects[2], otsTypeComboItems, "2", "ALL", "ALL");
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
//	axon_event.addListenerFormat('beforedeactivate', 'obj_blur'    , formObj); 	//- handling code when OnBeforeDeactivate(blur) event
//	axon_event.addListenerFormat('beforeactivate'  , 'obj_focus'   , formObj);            //- handling code when OnBeforeActivate event in case of existing dataformat property
//    axon_event.addListenerFormat('keypress'        , 'obj_keypress', formObj); 	//- handling code when onkeypress event in case of existing dataformat property
//    axon_event.addListenerFormat('keyup'           , 'form_keyup'  , formObj);
//    axon_event.addListenerFormat('keypress'        , 'obj_keypress', formObj); 	//- handling code when onkeypress event in case of existing dataformat property
    axon_event.addListenerFormat('keyup'           , 'obj_keyup'   , formObj);
    axon_event.addListenerFormat('change'          , 'obj_onchange', formObj);
    axon_event.addListener('click', 'change_event_radio2', 'kind2_radio');
    axon_event.addListener('click', 'change_event_radio3', 'kind_3');
//    axon_event.addListener('click', 'change_event_radio_display', 'kind_3');
    axon_event.addListener('blur' , 'sail_arr_dt_onblur', 'sail_arr_dt');//- getting name after inputting customer code
    axon_event.addListener('click', 'change_event_combo', 'rate_yn');
    ots_tp_cd.SetEnable(0);
}
function obj_onchange(){
		var formObj=document.form;
		var sheetObject=sheetObjects[0];
		switch(event.srcElement.name){
			case "rct_cust_cnt_cd":
			case "rct_cust_seq":
				
				formObj.f_cust_cnt_cd.value = formObj.rct_cust_cnt_cd.value;
				formObj.f_cust_seq.value = formObj.rct_cust_seq.value;
				
				if(formObj.rct_cust_cnt_cd.value != '' && formObj.rct_cust_seq.value != '') {
					var valueCustSeq=formObj.rct_cust_seq.value;
					formObj.rct_cust_seq.value=ComLpad(valueCustSeq,6,"0");
					doActionIBSheet(sheetObject,formObj,IBSEARCH_ASYNC02);
				} else if(formObj.rct_cust_cnt_cd.value != '' || formObj.rct_cust_seq.value != '') {
					formObj.cust_nm.value = "";
				}
				
				break;
		}
}

/** 
 * handling Keypress event of Object  <br>
 * checking validation of input value by dataformat of object  <br>
 */ 
function obj_keyup(){
	var formObj=document.form;
	switch (ComGetEvent("name")) {
		case "rct_cust_cnt_cd":
			var rctCustCntCd=event.srcElement.value;
			if (rctCustCntCd.length == 2) {
				formObj.rct_cust_seq.focus();
			}
 		break;
	}
} 

//radio button click
function change_event_radio2(){
	var formObject=document.form;
	formObject.bl_inv_count.value=""; 
	formObject.usd_sum.value="";
    formObject.lcl_sum.value="";
	sheetObjects[0].RemoveAll();
}
function change_event_combo(){
	var formObject=document.form;
	if (formObject.rate_yn[1].selected == true){
		formObject.ots_opy.disabled=false;
	} else {
		formObject.ots_opy[0].selected=true; 
		formObject.ots_opy.disabled=true;
	}
}
function change_event_radio3(){
	sheetObjects[0].RemoveAll();
	var formObject=document.form;
	//alert(formObject.kind_3[3].checked);
//	formObject.rct_cust_cnt_cd.value="";
//	formObject.rct_cust_seq.value="";
//	formObject.cust_nm.value="";
	formObject.kind3_code.value="";
	formObject.kind3_code2.value="";
	formObject.bl_inv_count.value=""; 
	formObject.usd_sum.value="";
    formObject.lcl_sum.value="";
	//formObject.sail_arr_dt_fm.value ="";
	//formObject.sail_arr_dt_to.value ="";
	if (formObject.kind_3[3].checked == true){
		ComSetDisplay("kind3_code", false);
		ComSetDisplay("kind3_code2", false);
		ComSetDisplay("sail_arr_dt_fm", true); 
		ComSetDisplay("sail_arr_dt_to", true);
		ComSetDisplay("btnCalasofDtfm", true);
		ComSetDisplay("btnCalasofDtto", true);
		ComSetDisplay("sa_date_fm", true);
		ComSetDisplay("sa_date_to", true);
	} else if (formObject.kind_3[0].checked == true) {
		ComSetDisplay("kind3_code", false);
		ComSetDisplay("kind3_code2", false);
		ComSetDisplay("sail_arr_dt_fm", false); 
		ComSetDisplay("sail_arr_dt_to", false);
		ComSetDisplay("btnCalasofDtfm", false);
		ComSetDisplay("btnCalasofDtto", false);
		ComSetDisplay("sa_date_fm", false);
		ComSetDisplay("sa_date_to", false);
	} else if (formObject.kind_3[1].checked == true || formObject.kind_3[7].checked == true || formObject.kind_3[8].checked == true) {
		ComSetDisplay("kind3_code", false);
		ComSetDisplay("kind3_code2", true);
		ComSetDisplay("sail_arr_dt_fm", false); 
		ComSetDisplay("sail_arr_dt_to", false);
		ComSetDisplay("btnCalasofDtfm", false);
		ComSetDisplay("btnCalasofDtto", false);
		ComSetDisplay("sa_date_fm", false);
		ComSetDisplay("sa_date_to", false);
	} else {
		setComSetDisplay();
	}
}
function setComSetDisplay(){
	ComSetDisplay("kind3_code", true);
	ComSetDisplay("kind3_code2", false);
	ComSetDisplay("sail_arr_dt_fm", false); 
	ComSetDisplay("sail_arr_dt_to", false);
	ComSetDisplay("btnCalasofDtfm", false);
	ComSetDisplay("btnCalasofDtto", false);
	ComSetDisplay("sa_date_fm", false);
	ComSetDisplay("sa_date_to", false);
}
//retrieving in case of changing stl_yr 
function sail_arr_dt_onblur(){
	var formObject=document.form;
	if (formObject.sail_arr_dt.value ==null || formObject.sail_arr_dt.value ==""){
		ComShowCodeMessage('JOO00116','as of date');
		ComSetFocus(formObject.sail_arr_dt);
		return false;
	}
}   
function sail_arr_dt_onblur_fm(){
	var formObject=document.form;
	if (formObject.sail_arr_dt_fm.value ==null || formObject.sail_arr_dt_fm.value ==""){
			ComShowCodeMessage('JOO00116','as of date from');
			ComSetFocus(formObject.sail_arr_dt_fm);
			return false;
	}
}   
function sail_arr_dt_onblur_to(){
	var formObject=document.form;
	if (formObject.sail_arr_dt_to.value ==null || formObject.sail_arr_dt_to.value ==""){
		ComShowCodeMessage('JOO00116','as of date to');
		ComSetFocus(formObject.sail_arr_dt_to);
		return false;
	}
}   
//handling Axon event 2
function obj_blur(){
    ComChkObjValid(event.srcElement);
	var src=ComGetEvent("name")
}
function obj_focus(){
    ComClearSeparator(event.srcElement);
}
function form_keyup(){
	ComKeyEnter('lengthnextfocus');
}
function obj_onclick(){
	var src=ComGetEvent("name")
}
function ots_grp_tp_desc_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	var formObj=document.form;
	var code=comboObj.FindItem(comboObj.GetSelectCode(), 0);
	if (code != null && code != undefined) {
		formObj.ots_grp_tp_cd_nm.value=comboObj.GetText(code, 1);
		formObj.ots_grp_tp_cd.value=comboObj.GetText(code, 2);
		comboloadOtsType();
		ots_tp_cd.SetEnable(1);
		ots_tp_cd.SetSelectText("",false);
	}else{
		ots_tp_cd.SetEnable(0);
	}
}
function ots_tp_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	var formObj=document.form;
	var code=comboObj.FindItem(comboObj.GetSelectCode(), 0);
	if (code != null && code != "") {
		formObj.ots_tp_cd_nm.value=comboObj.GetText(code, 1);
		/*
		var text=comboObj.GetText(code, 1);
		if (text != null && text != "" && text != formObj.ots_tp_cd_nm.value) {
			formObj.ots_tp_cd_nm.value=comboObj.GetText(code, 1);
		}  */
	}
	if(ots_tp_cd.GetSelectCode()=="ALL"){
		formObj.ots_tp_cd_nm.value="";
	}
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
	        var HeadTitle1="|Office|Customer Code|Customer Name|B/L No|Invoice No|Invoice Date|Invoice Currency|INV ROE LCL|INV ROE USD|INV TTL LCL|RCT TTL LCL|ADJ TTL LCL|TTL LCL|INV TTL USD|RCT TTL USD|ADJ TTL USD|TTL USD|BKG No|Charge Code|RHQ|Credit Currency|Credit Limit|O/B Term|I/B Term|Credit Flag|VVD|Lane|Bound|S/A Date|POR|POL|POD|DEL|SCP|Sales Rep|Reference|Due Date|Overdue|OTS Group|OTS Type|S/C No|Remark|Kind2|AR/AP Offset No|Currency|Invoice|Receipt|Adjust|Balances|Local Ex. Rate|USD Ex. Rate|OSCAR OTS Status|OSCAR Inv No|";
	        var headCount=ComCountHeadTitle(HeadTitle1); 
	
	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, FrozenCol:6 } );
	
	        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	
	        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ots_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"cust_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"cust_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Popup",     Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"inv_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"inv_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"inv_curr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"inv_locl_xch_rt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"inv_usd_xch_rt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },	               
	               {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"inv_tot_lcl",       KeyField:0,   CalcLogic:"",   Format:"",    		  PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"rct_tot_lcl",       KeyField:0,   CalcLogic:"",   Format:"",    		  PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"adj_tot_lcl",       KeyField:0,   CalcLogic:"",   Format:"",    		  PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"tot_lcl",           KeyField:0,   CalcLogic:"",   Format:"",    		  PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"inv_tot_usd",       KeyField:0,   CalcLogic:"",   Format:"",    		  PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"rct_tot_usd",       KeyField:0,   CalcLogic:"",   Format:"",    		  PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"adj_tot_usd",       KeyField:0,   CalcLogic:"",   Format:"",    		  PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"tot_usd",           KeyField:0,   CalcLogic:"",   Format:"",    		  PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"chg_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"credit_curr_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"credit_limit",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"ob_term",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"ib_term",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"credit_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"lane_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bnd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sail_arr_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"por_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"svc_scp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sale_rep_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ref_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"due_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Int",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"over_due",          KeyField:0,   CalcLogic:"",   Format:"NullInteger",  PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ots_grp_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ots_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sc_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"rmk",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"kind2",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ap_ar_offst_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"usd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"inv_amt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"rct_amt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"adj_amt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"bal_amt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"ex_rate",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:6,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"usd_eqv_lcl",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:6,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",     Hidden:0,  Width:120,   Align:"Center",   ColMerge:1,   SaveName:"ots_pay_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",     Hidden:0,  Width:140,   Align:"Center",   ColMerge:1,   SaveName:"org_inv_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:"sort_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
	               ];
	         	
	        InitColumns(cols);
	        SetDataRowHeight(26);
	        SetEditable(1);
	        
	        SetCountFormat("[SELECTDATAROW / TOTALROWS]");
	        
	        resizeSheet();
	        
	        
	        //SetSheetHeight(360);
		}
		break;
	}
}
// handling sheet process Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
	if (!validateForm(sheetObj, formObj, sAction))
		return;
	switch (sAction) {
		case IBSEARCH_ASYNC01:	//Search Customer Info
			combo1.RemoveAll();
			//change_event_combo();
			formObj.f_cmd.value=SEARCH03;		
			var param="f_cmd=" + SEARCH03 + "&ofc_lvl_tp=QUERY";
			var sXml=sheetObj.GetSearchData("SARCommonGS.do", param);
			var strOtsOfcCd=ComGetEtcData(sXml,"ots_ofc_cd");
			if (!ComIsNull(strOtsOfcCd)) {
				ofcList=strOtsOfcCd.split("|");				
				// -------------------------------------------------------------------------------------------------------------------
				//|OtsOfcCd^ArOfcCd^RhqCd^OtsSmryCd^OtsCd^RepOtsOfcCd^RctTpCd^RctUnapyFlg^OfcEntrLvlCd^ArCurrCd^DpPrcsKnt^BankCtrlCd
				//|0       ^1      ^2    ^3        ^4    ^5          ^6      ^7          ^8           ^9       ^10       ^11     
				// -------------------------------------------------------------------------------------------------------------------
				combo1.InsertItem(0, "ALL", "ALL");				
				combo1.InsertItem(1, "Agent", "AGT");
				combo1.InsertItem(2, "Branch", "BRH");
				for (var i=1; i < ofcList.length; i++ ) {
					var ofcInfo=ofcList[i].split("^");				
					//combo1.InsertItem(i+2, ofcInfo[0], ofcList[i]);	
					combo1.InsertItem(i+2, ofcInfo[0], ofcInfo[0]);	
				}				
				combo1.SetSelectText(strUsr_ofc);
				formObj.ofc_cd.value=strUsr_ofc;
				for (var i=1; i < ofcList.length; i++ ) {
					if (combo1.GetItemCheck(i+2) == true){
						var ofcInfo=ofcList[i].split("^");	
						formObj.rhq.value=ofcInfo[2];
					}
				}
			}
			formObj.ots_opy.disabled=false; 
			
			param="f_cmd=" + SEARCH17 + "&ofc_cd=" + strUsr_ofc;   
			sXml=sheet1.GetSearchData("SARCommonGS.do", param); 
			hiddenYn = ComGetEtcData(sXml,"hidden_yn");
			if(hiddenYn == 'Y'){
				$("select#date_tp_cd.input1").html("<option  value='A'>S/A Date</option>");  
				$("input#kind_3_8.trans").hide();
				$("label#l_kind_3_8").html(""); 
				sheet1.SetColHidden("inv_no",1);
				sheet1.SetColHidden("inv_dt",1);
				sheet1.SetColHidden("inv_curr_cd",1);
				sheet1.SetColHidden("inv_locl_xch_rt",1);
				sheet1.SetColHidden("inv_usd_xch_rt",1);  
			} else {
				$("select#date_tp_cd.input1").html("<option  value='A'>S/A Date</option><option  value='I'>Invoice Date</option>"); 
			}
			
		
			
			break;
		case IBSEARCH_ASYNC02:	//Search Customer Info
			formObj.f_cmd.value=SEARCH06;
			formObj.cust_cnt_cd.value=formObj.rct_cust_cnt_cd.value;
			formObj.cust_seq.value=formObj.rct_cust_seq.value;
			var sXml=sheetObj.GetSearchData("SARCommonGS.do", FormQueryString(formObj));
			if(SarShowXmlMessage(sXml) != "") {
					ComShowMessage(SarShowXmlMessage(sXml));
					ComClearObject(formObj.rct_cust_cnt_cd);
					ComClearObject(formObj.rct_cust_seq);
					ComClearObject(formObj.cust_nm);
					formObj.rct_cust_cnt_cd.focus();
				}else{
				formObj.cust_nm.value=ComGetEtcData(sXml,"cust_nm");
				}
			break;
		case IBSEARCH: //retrieve
			sheetObj.WaitImageVisible=false;
			var sXml;
			iPageNo = 1;
			ComOpenWait(true); 
			setTimeout( function () {
			    var multiRhqCd="";
			    for(var i=3; i < combo1.GetItemCount(); i++) {
			    	if (combo1.GetItemCheck(i) == true){
			    		var j=0;
			    		j=j+1
				        var row=ofcList[i-2].split("^");
				        if (j > 0 ) {        	
				        	multiRhqCd +=  " , " + row[2] ;
				        } else {
				        	multiRhqCd +=  row[2] +"'";
				        }
			    	}
			    }
			    formObj.rhq.value=multiRhqCd;
				formObj.f_cmd.value=SEARCH;	
				formObj.ofc_cd.value=combo1.GetSelectText();			
				sXml=sheetObj.GetSearchData("STM_SAR_1002GS.do", FormQueryString(formObj)+"&i_page="+iPageNo);
				var summary_yn = formObj.summary_yn.value;
			    if (summary_yn == "D") {
			    	colHidden(false);
			    } else {
			    	colHidden(true);
			    }
		  
				if(SarShowXmlMessage(sXml) != "") {
					ComShowMessage(SarShowXmlMessage(sXml));
					formObj.bl_inv_count.value=""; 
					formObj.usd_sum.value="";
					formObj.lcl_sum.value=""; 
				}else{
					sheetObj.LoadSearchData(sXml,{Sync:1} );
					formObj.bl_inv_count.value = SarMakeNumberFormat(ComGetEtcData(sXml,"total_cnt"));
					formObj.usd_sum.value = SarMakeNumberFormat(ComGetEtcData(sXml,"total_usd_amt"));
					formObj.lcl_sum.value = SarMakeNumberFormat(ComGetEtcData(sXml,"total_lcl_amt"));
				} 
				ComOpenWait(false); 
		    } , 100);
			
//			setTimeout( function () {
//				if (sheetObj.RowCount()> 0) { 
//					formObj.bl_inv_count.value=sheetObj.RowCount();
//					formObj.usd_sum.value=SarMakeNumberFormat(sheetObj.ComputeSum("|tot_usd|"),2);
//					formObj.lcl_sum.value=SarMakeNumberFormat(sheetObj.ComputeSum("|tot_lcl|"),2);
//				} else if (sheetObj.RowCount()== 0){
//					formObj.bl_inv_count.value=""; 
//					formObj.usd_sum.value="";
//					formObj.lcl_sum.value=""; 
//				}	
//			} , 103); 
			break;
			
		case IBSEARCHAPPEND: // 
			
			sheetObj.WaitImageVisible=false;
			var sXml;
			ComOpenWait(true); 
			setTimeout( function () {
			    var multiRhqCd="";
			    for(var i=3; i < combo1.GetItemCount(); i++) {
			    	if (combo1.GetItemCheck(i) == true){
			    		var j=0;
			    		j=j+1
				        var row=ofcList[i-2].split("^");
				        if (j > 0 ) {        	
				        	multiRhqCd +=  " , " + row[2] ;
				        } else {
				        	multiRhqCd +=  row[2] +"'";
				        }
			    	}
			    }
			    formObj.rhq.value=multiRhqCd;
				formObj.f_cmd.value=SEARCH;	
				formObj.ofc_cd.value=combo1.GetSelectText();			
				sXml=sheetObj.GetSearchData("STM_SAR_1002GS.do", FormQueryString(formObj)+"&i_page="+PageNo, {Append:true});
				
				
				var summary_yn = formObj.summary_yn.value;
			    if (summary_yn == "D") {
			    	colHidden(false);
			    } else {
			    	colHidden(true);
			    }
		  
				if(SarShowXmlMessage(sXml) != "") {
					ComShowMessage(SarShowXmlMessage(sXml));
				}else{
					sheetObj.LoadSearchData(sXml,{Sync:0,Append:1} );
				} 
				ComOpenWait(false); 
		    } , 100);
			
//			setTimeout( function () {
//				if (sheetObj.RowCount()> 0) { 
//					formObj.bl_inv_count.value=sheetObj.RowCount();
//					formObj.usd_sum.value=SarMakeNumberFormat(sheetObj.ComputeSum("|tot_usd|"),2);
//					formObj.lcl_sum.value=SarMakeNumberFormat(sheetObj.ComputeSum("|tot_lcl|"),2);
//				} else if (sheetObj.RowCount()== 0){
//					formObj.bl_inv_count.value=""; 
//					formObj.usd_sum.value="";
//					formObj.lcl_sum.value=""; 
//				}	
//			} , 103); 
			break;
		
	}
}

function colHidden(flag) {
	var sheet1 = sheetObjects[0];
	
	if (flag) { 		
		sheet1.SetColHidden("inv_amt",1);
		sheet1.SetColHidden("rct_amt",1);
		sheet1.SetColHidden("adj_amt",1);
		sheet1.SetColHidden("bal_amt",1);
		sheet1.SetColHidden("ex_rate",1);
		sheet1.SetColHidden("usd_eqv_lcl",1);		
	} else {
		sheet1.SetColHidden("inv_amt",0);
		sheet1.SetColHidden("rct_amt",0);
		sheet1.SetColHidden("adj_amt",0);
		sheet1.SetColHidden("bal_amt",0);
		sheet1.SetColHidden("ex_rate",0);
		sheet1.SetColHidden("usd_eqv_lcl",0);
	}
	
}

/**
 * Popup Data Validation Check. <br>
 **/
function ofc_cd_pop_event(aryPopupData) {
	document.form.ofc_cd.value=aryPopupData[0][3];
	sheetObjects[0].RemoveAll();
}
function ofc_cd_sheet_pop_event(aryPopupData, row, col, sheetIdx){
	sheetObjects[sheetIdx].SetCellValue(row, col,aryPopupData[0][3]);
}
/**
 * handling process for input validation 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	var formObject=document.form;
	var prefix="sheet1_";
    var sail_arr_dt=formObject.sail_arr_dt.value;
    var sail_arr_dt_fm=formObject.sail_arr_dt_fm.value;
    var sail_arr_dt_to=formObject.sail_arr_dt_to.value;
	switch (sAction) {
		case IBSEARCH: //retrieve
			if (formObj.sail_arr_dt.value ==null || formObj.sail_arr_dt.value ==""){
			    ComShowCodeMessage('COM130403','as of date');
				ComSetFocus(formObj.sail_arr_dt);
				var asofDt=ComReplaceStr(formObj.sail_arr_dt,"-","");
				return false;
			}			
			if (combo1.GetSelectCode()==""){
			    ComShowCodeMessage('COM130403','Office');
				ComSetFocus(formObj.ofc_cd);
				return false;
			}	
//			if (formObj.rhq.value ==null || formObj.rhq.value ==""){
////				alert("validateForm");
//			    ComShowCodeMessage('COM130403','RHQ');
//				ComSetFocus(formObj.rhq);
//				return false;
//			}				
		break;
	default:
		break;
	}
	return true;
}
function initCombo(comboObj, comboNo) {
	switch (comboObj.options.id) {
 		case "ots_grp_tp_desc":
 			var i=0;
 			with (comboObj) {
 				//BackColor = "cyan";
 				SetDropHeight(200);
 				SetMultiSelect(0);
 				SetMaxSelect(1);
 				SetUseAutoComplete(1);
 				//MaxLength = 50;
 				SetColWidth(0, "100");
 				SetColWidth(1, "180");
 				SetColWidth(2, "0");
 			}
 			break;
 		case "ots_tp_cd":
 			var i=0;
 			with (comboObj) {
 				//BackColor = "cyan";
 				SetDropHeight(200);
 				SetMultiSelect(0);
 				SetMaxSelect(1);
 				SetUseAutoComplete(1);
 				//Disabled = false;
 				//SetColWidth("100|180|100|100");
 			}
 			break;
 		case "combo1":
 			var i=0;
 			with (comboObj) {
 				SetMultiSelect(1);
 //no support[check again]CLT 				UseCode=true;
 //no support[check again]CLT 				LineColor="#7896B1";	
 				SetMultiSeparator(",");
 				SetDropHeight(240);
 				SetBackColor("#CCFFFD");
 			}
 			break;
	}
}


function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var sName=sheetObj.ColSaveName(Col);
	var formObj=document.form;
}
/**
 * IBSeet내의 데이터 셀의 팝업 버튼이 눌러졌을 때 발생하는 Event<br>
 * @param {sheetObj} String : 해당 IBSheet셀 명
 * @param {Row} Long : 해당 셀의 Row Index
 * @param {Col} Long : 해당 셀의 Column Index
 */	
function sheet1_OnPopupClick(sheetObj, Row, Col){
	var sheetID=sheetObj.id;
	var prefix="sheet1_";
	var param="";
	with (sheetObj) {
        switch (ColSaveName(Col)) {
            case  "bl_no":    
            	var param="?bl_no=" 		+ sheetObj.GetCellValue(Row, "bl_no") ;
            	SarOpenWindowCenter("STM_SAR_1001.do" + param,"STM_SAR_1001",1250,700,0,1,0,1);  
				break; 
        }
    }
}

function sheet1_OnDblClick(sheet, row, col) {
	if (row < 1) {
		return;
	}
	
	if(sheet.GetCellValue(row, "sort_seq") != ""){
		if(sheet.GetCellValue(row, "sort_seq") == "1"){
			var parentPgmNo="STM_SAR_1001";
				var param="?bl_no=" + sheet.GetCellValue(row, "bl_no") + 
				  "&inv_no=" + sheet.GetCellValue(row, "inv_no") + 
				  "&bkg_no=" + sheet.GetCellValue(row, "bkg_no") +
				  "&sel_ofc_cd=" + sheet.GetCellValue(row, "ots_ofc_cd") + 
				  '&pop_yn=Y&parentPgmNo='+parentPgmNo;  
				SarOpenWindowCenter("STM_SAR_1001.do" + param,"STM_SAR_1001",1250,700,0,1,0,1); 
		} else {
			var parentPgmNo="STM_SAR_2002"; 
				var param="?rct_no=" + sheet.GetCellValue(row, "bl_no") + 
				  "&rct_ofc_cd=" + sheet.GetCellValue(row, "ots_ofc_cd") + 
				  "&req_rct_dt=" + sheet.GetCellValue(row, "due_dt") +
				  "&call_yn=Y" + 
				  '&pop_yn=Y&parentPgmNo='+parentPgmNo;      
			SarOpenWindowCenter("STM_SAR_2002.do" + param,"STM_SAR_2002",1250,700,0,1,0,1);
		}
	} 
}

var iPageNo = 1;
function sheet1_OnVScroll(sheetObj, vpos, oldvpos, isTop, isBottom) {
    if (!isBottom || sheetObj.RowCount() >= sheetObj.GetTotalRows()) { 
    	return;
    } else {
    	doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, true, ++iPageNo);
    }
}

/**
 *  <br>
 * ComComboObject에 item 추가  <br>
 * jsp에서 ComComboObject() 함수 사용시 <br>
 * <br><b>Example : </b>
 * <pre>
 *     var currComboItems = SarGetComboItems(sheetObj, "SAR_TAX_CHARGE");
			SarAddComboItem(comboObjects[0], currComboItems, "1", "ALL", "ALL") 				
 * </pre>
 * @param comboObj
 * @param comboItems (SarGetComboItems 에서 얻은 리턴값)
 * @param type ( 1: code, 2 : code, name )
 * @param appendStr (ALL, SELECT 등 문자열 추가시 codedesc)
 * @param appendCode (ALL, SELECT 등 문자열 추가시 추가된 code)
 * @see SarGetComboItems
 */ 	
function SarAddSelectComboItem(comboObj, comboItems, type, appendStr, appendCode) {
	if (appendStr != "" ) { 
		comboObj.InsertItem(0, appendStr, appendCode);
	}
    for (var i=0 ; i < comboItems.length ; i++) {
        var comboItem=comboItems[i].split(FIELDMARK);
        if ( type == "1" ) {
        	comboObj.InsertItem(i+1, comboItem[0] , comboItem[0]);    
        } else  if ( type == "2" ) {            	
        	comboObj.InsertItem(i+1, comboItem[0] + "|" + comboItem[1] , comboItem[0]);    
        } else  if ( type == "3" ) {            	
        	comboObj.InsertItem(i+1, comboItem[2] + "|" + comboItem[1] + "|" + comboItem[0] , comboItem[2]);    
        } else  if ( type == "4" ) {            	
        	comboObj.InsertItem(i+1, comboItem[0] + "|" + comboItem[1] + "|" + comboItem[2] + "|" + comboItem[3] , comboItem[3]);    
        }
    }     
}
function SarGetSelectComboItems(sheetObj, sCondition, param) {
	if (param == undefined ) param="";
	var sXml=sheetObj.GetSearchData("STMCommonGS.do", "f_cmd=" + COMMAND01 + "&lu_tp_cd=" + sCondition + param);
	//alert("sXml"+sXml);
	var comboItems=ComGetEtcData(sXml, "lu_cd_list").split(ROWMARK);	
	//alert("comboItems"+comboItems);
	return comboItems;
}
function combo1_OnCheckClick(s_code, s_index ) {
	// checked all
	if (s_index == 0) {		
		var checked=false;
		if (combo1.GetItemCheck(s_index)) {
			checked=true;
		}
		for(var i=1; i < combo1.GetItemCount(); i++) {
			combo1.SetItemCheck(i,checked);
		}
		// agent all
	} else if (s_index == 1) {		
		var checked=false;
		if (combo1.GetItemCheck(s_index)) {
			checked=true;
		}
		if (ofcList != null && ofcList.length > 0) {
			for(var i=3; i < combo1.GetItemCount(); i++) {
				var ofcInfo=ofcList[i - 2].split("^");
				for(var j=0 ; j < 18 ; j++) {
					debugConsole(j + ":" +ofcInfo[j]);
				}
				if (ofcInfo[15] == "AGT") {					
					combo1.SetItemCheck(i,checked);
				}		
			}	
		}
	} else if (s_index == 2) {		
		var checked=false;
		if (combo1.GetItemCheck(s_index)) {
			checked=true;
		}
		if (ofcList != null && ofcList.length > 0) {
			for(var i=3; i < combo1.GetItemCount(); i++) {
				var ofcInfo=ofcList[i - 2].split("^");
				for(var j=0 ; j < 18 ; j++) {
					debugConsole(j + ":" +ofcInfo[j]);
				}
				if (ofcInfo[15] == "BRH" || ofcInfo[15] == "ALL") {			
					combo1.SetItemCheck(i,checked);
				}		
			}	
		}
	}
} 
/** 
 * call method when select event on popup(FNS_INV_0086)<br>
 * <br><b>Example :</b>
 * <pre>
 * </pre>
 * @param  {array} rowArray   
 * @return none
 * @see #
 * @author Park sung yong
 * @version 2014.03.24
 */
function getSTM_SAR_9003(rowArray) {
	var colArray=rowArray[0];
	var formObj=document.form;
	formObj.rct_cust_cnt_cd.value=colArray[8];
	formObj.rct_cust_seq.value=ComLpad(colArray[9], 6, '0');
	formObj.cust_nm.value=colArray[4];
	formObj.f_cust_cnt_cd.value = colArray[8];
	formObj.f_cust_seq.value = colArray[9];
}
