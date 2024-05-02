/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAR_1005.js
*@FileTitle  : Payment Request Letter
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
 * @class STM_SAR_1005 : business script for STM_SAR_1005
 */
// common global variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();        
var comboCnt=0;
var gCurRow=0;
var otsTpXcld="";

//add@
var firstCurrCd = "";  
var first_within_amt = 0.00;
var first_over_amt = 0.00;   
var first_ttl_amt = 0.00;   
var first_count = 0;
var secondCurrCd = "";  
var second_within_amt = 0.00;
var second_over_amt = 0.00;     
var second_ttl_amt = 0.00;     
var second_count = 0;
var formObj=document.form; 

// Event handler processing by button click event */
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
// Event handler processing by button name */
/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */   
function processButtonClick() {
	var formObj=document.form; 
	/***** setting sheet object *****/
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/    
	var sheetObject1=sheetObjects[0];
	/*******************************************************/
	try {
		var srcName=ComGetEvent("name");
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
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
			case "btn_pop_credit_cust":
			var formObject=document.form; 
			if(formObject.rct_cust_cnt_cd.value != "" && formObject.rct_cust_seq.value != "") {
				var param='?cust_cnt_cd='+formObject.rct_cust_cnt_cd.value+'&cust_seq='+formObject.rct_cust_seq.value+'&pop_yn=Y&ret_yn=Y';
				ComOpenPopup('/opuscntr/STM_SAR_9002.do' + param, 1300, 650, 'getPopData', '0,0', true, false, "", "", 0);
			}
			break;
			case "btn_retrieve":
				doActionIBSheet(sheetObject1, formObj, IBSEARCH); 
				break;
			case "btnCalasofDtto":   
				var cal=new ComCalendar();
				cal.select(form.sail_arr_dt, 'yyyy-MM-dd');
				break;	
			case "btns_xcld_ots_tp":
				var param=otsTpXcld;
				var popupMultiWin=ComOpenPopup('/opuscntr/STM_SAR_0161.do' + param, 600, 500,"getSTM_SAR_0161", "0,1", true, false);
				//popupMultiWin.focus();
				break;	
			case "btn_pop_cust_cd":
				var cust_cnt_cd=formObj.rct_cust_cnt_cd.value;
				var cust_seq=formObj.rct_cust_seq.value;
				var classId="STM_SAR_9003"; 
				var param='?cust_cnt_cd='+cust_cnt_cd+'&cust_seq='+cust_seq+'&pop_yn=Y&classId='+classId +'&office='+ctrl_ofc_cd.GetSelectText();
				ComOpenPopup('/opuscntr/STM_SAR_9003.do' + param, 900, 450, 'getSTM_SAR_9003', '0,0', true, false);
				break;		
			case "btn_send":
				if($('#r_type:checked').val() == "O"){
					doActionIBSheet(sheetObject1,formObj,COMMAND01);
				} else {
					var check_count = 0;
					for (var i=sheetObjects[0].HeaderRows(); i<= sheetObjects[0].LastRow(); i++){
						if(sheetObjects[0].GetCellValue(i, "del_chk") == "0") {
							check_count += 1; 
						}
					}
					if(!(check_count > 0)){ 
						ComShowCodeMessage('COM130402','data');  
						break; 
					} 
					
					doActionIBSheet(sheetObject1,formObj,IBSAVE);
					 
					if(sheetObjects[1].RowCount() == 1){
						firstCurrCd = sheetObjects[1].GetCellValue(2, "sum_curr_cd");
						first_ttl_amt = sheetObjects[1].GetCellValue(2, "sum_tot_lcl");
						first_count = sheetObjects[1].GetCellValue(2, "sum_count"); 
					}
					if(sheetObjects[1].RowCount() > 1){ 
						firstCurrCd = sheetObjects[1].GetCellValue(2, "sum_curr_cd");
						first_ttl_amt = sheetObjects[1].GetCellValue(2, "sum_tot_lcl");
						first_count = sheetObjects[1].GetCellValue(2, "sum_count"); 
						secondCurrCd = sheetObjects[1].GetCellValue(3, "sum_curr_cd");
						second_ttl_amt = sheetObjects[1].GetCellValue(3, "sum_tot_lcl");  
						second_count = sheetObjects[1].GetCellValue(3, "sum_count");
					}
					
					var param='';
					ComOpenPopupWithTarget("/opuscntr/STM_SAR_1006.do?cust_code="+document.form.cust_cd.value + 
							                                        "&cust_name="+document.form.cust_nm.value +  
							                                        "&firstCurrCd="   +firstCurrCd +  
							                                        "&first_ttl_amt="  +first_ttl_amt +  
							                                        "&first_count="  +first_count +  
							                                        "&secondCurrCd="   +secondCurrCd +  
							                                        "&second_ttl_amt="  +second_ttl_amt +   
							                                        "&second_count="  +second_count +   
							                                        "&eml_seq="  +document.form.ar_eml_seq.value +  
							                                        "&email="    +document.form.email.value +  
							                                        "&fax="      +document.form.fax.value +  
							                                        "&cnsd_cust_flg="    +document.form.cnsd_cust_flg.value +  
							                                        "&ots_smry_cd="      +document.form.ots_smry_cd.value +
							                                        "&ar_ofc_cd=" + ctrl_ofc_cd.GetSelectText() +  
							                                        "&rhq_cd=" + document.form.rhq_cd.value
							                                        , 750, 300, "cust_cd:cust_cd", '0,0', true);
				}
				break;
			case "btn_downexcel":
				if (sheetObjects[0].RowCount() > 0) { 
					sheetObjects[0].Down2Excel({ HiddenColumn:1,DownCols:"2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18"});  
				} else {
					ComShowCodeMessage("COM132501");
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
				clearCustomer();
				var checkNum = ctrl_ofc_cd.GetSelectIndex();
				ctrl_ofc_cd.SetSelectIndex(checkNum,0);  
				doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03); 
				break;
			case "btn_his":	
				var cust_cnt_cd=formObj.rct_cust_cnt_cd.value;
				var cust_seq=formObj.rct_cust_seq.value;
				var cust_nm=formObj.cust_nm.value; 
				var param='?cust_nm='+cust_nm+'&ar_ofc_cd='+ctrl_ofc_cd.GetSelectText()+'&r_type='+$('#r_type:checked').val()+'&cust_cnt_cd='+cust_cnt_cd+'&cust_seq='+cust_seq+'&pop_yn=Y';
				ComOpenPopup('/opuscntr/STM_SAR_1009.do' + param, 1000, 600, '', '0,0', false, false);
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
	for ( var k=0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}
    initControl(); 
    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
  //  agn_ofc_cd.SetSelectIndex(0);
    clearCustomer();
}
function comboloadOtsType() { 
   var sheetObj=sheetObjects[0];
    comboObjects[1].RemoveAll();  //.DeleteItem(0);
   document.form.ots_tp_cd_nm.value="";
   var otsTypeComboItems=SarGetSelectComboItems(sheetObj, "OTS TYPE",  "&attr_ctnt2=" + document.form.ots_grp_tp_cd.value );
   SarAddSelectComboItem(comboObjects[1], otsTypeComboItems, "2", "ALL", "ALL");
}

function initCombo(comboObj, comboNo) {
	switch (comboObj.options.id) {
 		case "agn_ofc_cd":  
 			with (comboObj) {
 				SetMultiSelect(1);
 				SetMultiSeparator(",");
 				SetDropHeight(240);
 				SetBackColor("#CCFFFD");
 			}
 			break;
	}
}
/**
 * loading HTML Control event <br>
 * {@link #loadPage} function call this. so IBSheet Object is initialized. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sequence number in sheetObjects array
 **/
function initControl() {
	var formObj=document.form;
    //handling Axon event. event catch
	//axon_event.addListenerFormat ('keypress', 'obj_keypress', formObj);
	//axon_event.addListenerFormat('beforedeactivate', 'obj_blur'    , formObj); 	//- handling code when OnBeforeDeactivate(blur) event
	//axon_event.addListenerFormat('beforeactivate'  , 'obj_focus'   , formObj);  //- handling code when OnBeforeActivate event in case of existing dataformat property
	axon_event.addListenerFormat('change'          , 'obj_onchange', formObj);
//	axon_event.addListenerFormat('keypress'        , 'obj_keypress', formObj); 	//- handling code when onkeypress event in case of existing dataformat property
//	axon_event.addListenerFormat('keyup'           , 'obj_keyup'   , formObj);
}
function obj_onchange(){
		var formObj=document.form;
		var sheetObject=sheetObjects[0];
		switch(ComGetEvent("name")){
			case "rct_cust_seq":
				if (formObj.rct_cust_cnt_cd.value != '' && formObj.rct_cust_seq.value != '') {
					var valueCustSeq=formObj.rct_cust_seq.value;
					formObj.rct_cust_seq.value=ComLpad(valueCustSeq,6,"0");
					var cust_cd=formObj.rct_cust_cnt_cd.value + formObj.rct_cust_seq.value;
					formObj.cust_cd.value=cust_cd;
					doActionIBSheet(sheetObject,formObj,IBSEARCH_ASYNC02);
				}
				break;
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
	var sheetID=sheetObj.id; 
	switch(sheetID) {
	case "sheet1": //t1sheet1 init
		with (sheetObj) {  
			var HeadTitle1="|Del|VVD|B/L No|Invoice No|Office|Customer|Customer\nName|Invoice\nCurrency|S/A Date|Cust Ref No|Invoice\nDate|Due Date|Overdue|Invoice Amt|Receipt Amt|Adjust Amt|Balance Amt|Invoice\nStatus||||";
			var headCount=ComCountHeadTitle(HeadTitle1);
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);
			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
			             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"inv_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"office",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cust_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:200,   Align:"Left",  	ColMerge:1,   SaveName:"cust_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"inv_curr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sail_arr_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ref_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"inv_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"due_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"over_due",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"inv_amt",      KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
			             {Type:"Text",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"rct_amt",      KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
			             {Type:"Text",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"adj_amt",      KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
			             {Type:"Text",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"bal_amt",      KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ots_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, 
			             {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"type",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ctrl_ofc_cd_text",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			InitColumns(cols); 
			SetSheetHeight(350);
			SetEditable(1);
			}
		break;
	case "sheet2":
	    with(sheetObj){
		      var HeadTitle1="|Total Outstanding Balance Amount|Total Outstanding Balance Amount|Total Outstanding Balance Amount|Total Outstanding Balance Amount||"; 
		      var HeadTitle2="|Within Terms|Within Terms|OverDue|Total||";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:0, DataRowMerge:1 } );
		      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"}, 
		      				  { Text:HeadTitle2, Align:"Center"}];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sum_curr_cd",     KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				           {Type:"Text",     Hidden:0,  Width:120,   Align:"Right",   ColMerge:1,   SaveName:"sum_in_bal",      KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
				           {Type:"Text",     Hidden:0,  Width:120,   Align:"Right",   ColMerge:1,   SaveName:"sum_over_bal",      KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
				           {Type:"Text",     Hidden:0,  Width:120,   Align:"Right",   ColMerge:1,   SaveName:"sum_tot_lcl",      KeyField:0,   CalcLogic:"",   Format:"",      PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
				           {Type:"Int",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:"sum_count",       KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      			   {Type:"Int",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:"dp_prcs_knt",       KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		      InitColumns(cols);   
			  SetSheetHeight(120); 
		      SetEditable(1);
		      SetCountPosition(0);
		      SetPagingPosition(0);
		      
            }
		break;	
	}
}
// handling sheet process Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBSEARCH_ASYNC01: 
			formObj.f_cmd.value=SEARCH14;
 			var sXml=sheetObj.GetSearchData("SARCommonGS.do", FormQueryString(formObj));
			var ctrlOfcStr=ComGetEtcData(sXml,"ctrl_ofc_cd");
			var arrCtrlStr=ctrlOfcStr.split("|"); 
			// ----------------------------------------
			//|CtrlOfcCd^OtsCd^ChkOfcYn^RhqCd^OtsSmryCd
			//|0        ^1    ^2       ^3    ^4 
			// -----------------------------------------
			var checkNum = 0;
			for (var i=1; i < arrCtrlStr.length; i++ ) {
				var arrStr=arrCtrlStr[i].split("^");
				var ctrlOfcCd=arrStr[0];
				ctrl_ofc_cd.InsertItem(i-1, ctrlOfcCd, arrCtrlStr[i]);	
				if(arrStr[2] == 'Y'){
					checkNum = i-1;
				}
			}
			ctrl_ofc_cd.SetSelectIndex(checkNum,0);   
			var arrStr = ctrl_ofc_cd.GetSelectCode().split("^")
			formObj.rhq_cd.value= arrStr[3];
			formObj.ots_smry_cd.value= arrStr[4]; 
			formObj.ar_ofc_cd.value = ctrl_ofc_cd.GetSelectText();
			
			var sStr=ComGetEtcData(sXml,"ots_ofc_cd");
			var arrStr=sStr.split("|");
			MakeRctOfcComboObject(agn_ofc_cd, arrStr);
			
			for (var i=1; i < arrStr.length; i++ ) {
				var ofcInfo=arrStr[i].split("^");
				// -------------------------------------------------------------------------------------------------------------------
				//|OtsOfcCd^ArOfcCd^RhqCd^OtsSmryCd^OtsCd^RepOtsOfcCd^RctTpCd^RctUnapyFlg^OfcEntrLvlCd^ArCurrCd^DpPrcsKnt^BankCtrlCd^agnCurrCd^agnPfxCd^agnOtsLmtAmt
				//|0       ^1      ^2    ^3        ^4    ^5          ^6      ^7          ^8           ^9       ^10       ^11        ^12       ^13      ^14
				// -------------------------------------------------------------------------------------------------------------------
				if(ofcInfo[0] == formObj.usr_ofc_cd.value){
					agn_ofc_cd.SetItemCheck(i,true); 
				}  	
			}   
			
			var param="f_cmd=" + SEARCH17 + "&ofc_cd=" + strUsr_ofc;   
			sXml=sheetObj.GetSearchData("SARCommonGS.do", param); 
			var hiddenYn = ComGetEtcData(sXml,"hidden_yn");
			
			if(hiddenYn == 'Y'){
				sheet1.SetColHidden("inv_no",1);
				sheet1.SetColHidden("inv_curr_cd",1);
				sheet1.SetColHidden("inv_dt",1);
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
				formObj.cnsd_cust_flg.value=ComGetEtcData(sXml,"cnsd_cust_flg");
 			}
			break;
		case IBSEARCH_ASYNC03:
			// ----------------------------------------
			//|CtrlOfcCd^OtsCd^ChkOfcYn^RhqCd^OtsSmryCd
			//|0        ^1    ^2       ^3    ^4 
			// -----------------------------------------
			var arrStr = ctrl_ofc_cd.GetSelectCode().split("^")
			var f_query='';
			// 쿼리 스트링 조합시작
			f_query += 'f_cmd' + '=' + SEARCH15 + '&';
			f_query += 'ofc_cd=' + arrStr[0] + '&';
			f_query += 'acct_ctnt=' + arrStr[1];
				 
 			var sXml=sheetObj.GetSearchData("SARCommonGS.do", f_query);
 			var sStr=ComGetEtcData(sXml,"ots_ofc_cd");
			var arrStr=sStr.split("|");
			MakeRctOfcComboObject(agn_ofc_cd, arrStr);
			for (var i=1; i < arrStr.length; i++ ) {
				var ofcInfo=arrStr[i].split("^");  
				// -------------------------------------------------------------------------------------------------------------------
				//|OtsOfcCd^ArOfcCd^RhqCd^OtsSmryCd^OtsCd^RepOtsOfcCd^RctTpCd^RctUnapyFlg^OfcEntrLvlCd^ArCurrCd^DpPrcsKnt^BankCtrlCd^agnCurrCd^agnPfxCd^agnOtsLmtAmt
				//|0       ^1      ^2    ^3        ^4    ^5          ^6      ^7          ^8           ^9       ^10       ^11        ^12       ^13      ^14
				// -------------------------------------------------------------------------------------------------------------------
				if(ofcInfo[0] == formObj.usr_ofc_cd.value){
					agn_ofc_cd.SetItemCheck(i,true); 
				}  	
			}   
			break;	
		case IBSEARCH: //retrieve
			if (!validateForm(sheetObj, formObj, sAction)){return;}
			sheetObj.WaitImageVisible=false;
			ComOpenWait(true); 
			setTimeout( function () {
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
					//formObj.cust_nm.value=ComGetEtcData(sXml,"cust_nm");
					formObj.cnsd_cust_flg.value=ComGetEtcData(sXml,"cnsd_cust_flg");
	 			}
				
				formObj.f_cmd.value=SEARCH;			
	 			var sXml=sheetObj.GetSearchData("STM_SAR_1005GS.do", FormQueryString(formObj));
	 			var arrXml=sXml.split("|$$|");
				if (arrXml.length > 0) {
					sheetObj.LoadSearchData(arrXml[0],{Sync:1} );	
				}	
				if (arrXml.length > 1) {
					sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
				}
				
				for(i=1; i<sheetObj.RowCount()+1; i++){
					sheetObj.SetRowStatus(i,"U");
	    		}
				ComOpenWait(false);
		    } , 100);
			break;
		case IBSAVE: // saving
			//if (!validateForm(sheetObj, formObj, sAction)){return;}
			formObj.f_cmd.value=SEARCH02;			
 			var sXml=sheetObj.GetSearchData("STM_SAR_1005GS.do", FormQueryString(formObj));
			var sSeq=ComGetEtcData(sXml,"ar_eml_seq");
			formObj.ar_eml_seq.value=sSeq;
			formObj.f_cmd.value=SEARCH03;			
 			var sXml=sheetObj.GetSearchData("STM_SAR_1005GS.do", FormQueryString(formObj));
			var sFax=ComGetEtcData(sXml,"fax");
			var sEmail=ComGetEtcData(sXml,"email");
			if (typeof sFax == "undefined" || sFax == "") {
				formObj.fax.value="";
			} else {
				formObj.fax.value=sFax;
			}
			if (typeof sEmail == "undefined" || sEmail == "") {
				formObj.email.value="";
			} else{
				formObj.email.value=sEmail;
			}	
			
			sheetObj.WaitImageVisible=false;
			ComOpenWait(true); 
			setTimeout( function () {
	    		formObj.f_cmd.value=MULTI;
	    		sheetObj.DoSave("STM_SAR_1005GS.do", FormQueryString(formObj),-1,false );
	    		for(i=1; i<sheetObj.RowCount()+1; i++){
					sheetObj.SetRowStatus(i,"U");
					sheetObjects[0].SetCellValue(i, "del_chk","0",0);
	    		}
	     		ComOpenWait(false);	 	 
			} , 100);	
    		break;
		case COMMAND01: // by office sendmail
			if (!validateForm(sheetObj, formObj, sAction)){return;}
			formObj.f_cmd.value=COMMAND01;			
 			var sXml=sheetObj.GetSearchData("STM_SAR_1005GS.do", FormQueryString(formObj)); 
 			
 			if(SarShowXmlMessage(sXml) != "") {
 				ComShowMessage(SarShowXmlMessage(sXml));
 				return; 
 			}else{
 				// batch 가 running 상태일 경우, message 호출
 				var batStsCd = ComGetEtcData(sXml, "batStsCd");
 				if (!ComIsNull(batStsCd)) {
 					if(batStsCd == "R"){
 						//There is other {?msg1} execution in progress. Please try again after a few minutes.
 						ComShowCodeMessage("SAR00079", "mail");		
 						return;					
 					}
 				}
 				
 				var result = ComGetEtcData(sXml, "result");
 				if (result.length > 0) {  
 	 				ComShowCodeMessage("SAR00053");
 	 				return;  
 	 			} else {
 	 				ComShowCodeMessage('SAR00057');
 	 				return; 
 	 			}
 			}
			break;
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
	var formObj=document.form;
    //var sail_arr_dt = formObject.sail_arr_dt.value;
	switch (sAction) {
		case IBSEARCH: //retrieve
			if($('#r_type:checked').val() != "C"){
				ComShowCodeMessage('SAR00056');
				return false;
			}	
			
			if (ComIsEmpty(agn_ofc_cd.GetSelectText())){
			    ComShowCodeMessage('COM130403','Collction Office');
			    agn_ofc_cd.Focus(); 
				return false;
			}
			 
			var cust_cd=formObj.rct_cust_cnt_cd.value + formObj.rct_cust_seq.value;
			formObj.cust_cd.value=cust_cd;
			if (formObj.rct_cust_seq.value ==null || formObj.rct_cust_seq.value ==""||formObj.rct_cust_cnt_cd.value ==null || formObj.rct_cust_cnt_cd.value ==""){
				ComShowCodeMessage('COM130403','Customer');
				ComSetFocus(formObj.cust_cd);
				return false;
			}	
		break;
	default:
		break;
	}
	return true;
}
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	//if combined data
	/*for (var i=sheetObj.HeaderRows(); i<= sheetObj.LastRow(); i++){
		}*/
}
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var sName=sheetObj.ColSaveName(Col);
	var formObj=document.form;
	sheetObj.SetRowStatus(Row,"");
	check_sum();
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
	cmbObj.RemoveAll();
	cmbObj.InsertItem(0, "ALL", "ALL"); 
	for (var i=1; i < arrStr.length; i++ ) {
		var arrStr2=arrStr[i].split("^");
		var ots_ofc_cd=arrStr2[0];
		cmbObj.InsertItem(i, ots_ofc_cd, arrStr[i]);			 
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
function ctrl_ofc_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){ 
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var arrStr=newCode.split("^");
	sheetObjects[0].RemoveAll();
	// ----------------------------------------
	//|CtrlOfcCd^OtsCd^ChkOfcYn^RhqCd^OtsSmryCd
	//|0        ^1    ^2       ^3    ^4 
	// -----------------------------------------
	formObj.rhq_cd.value= arrStr[3];
	formObj.ots_smry_cd.value= arrStr[4]; 
	if(formObj.ots_smry_cd.value == "BL"){
		formObj.inv_no.value="";
		ComEnableObject(formObj.inv_no,false);
	}else if(formObj.ots_smry_cd.value == "INV"){
		formObj.inv_no.value="";
		ComEnableObject(formObj.inv_no,true);
	}
	//Search Collection Office
	doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03); 
	formObj.ar_ofc_cd.value =  newText;
}

function agn_ofc_cd_OnCheckClick(s_code, s_index ) {
	// checked all
	if (s_index == 0) {		
		var checked=false;
		if (agn_ofc_cd.GetItemCheck(s_index)) { 
			checked=true;
		}
		for(var i=1; i < agn_ofc_cd.GetItemCount(); i++) {
			agn_ofc_cd.SetItemCheck(i,checked); 
		}
	}  
} 

function getSTM_SAR_0161(data) {
    var multiOtsTpXcld="";
    otsTpXcld = "";
    
    if(data.length > 0){
    	 for(var i=0; i < data.length; i++) {
	        var row=data[i];
	        if (i > 0 ) {        	
	        	multiOtsTpXcld +=  " , '" + row[2] +"'";
	        	otsTpXcld +=  "&otsTpXcld=" + row[2];
	        } else {
	        	multiOtsTpXcld +=  "'" + row[2] +"'";
	        	otsTpXcld +=  "?otsTpXcld=" + row[2];
	        }    
	    }
    } else {
    	otsTpXcld = "";
    	multiOtsTpXcld = "";
    } 
    
    var frm=document.form;
    frm.xcld_ots_tp_cd.value=multiOtsTpXcld;
}	
function check_sum(){
	firstCurrCd = "";  
	first_within_amt = 0.00;
	first_over_amt = 0.00;   
	first_count = 0;
	secondCurrCd = "";  
	second_within_amt = 0.00;
	second_over_amt = 0.00;      
	second_count = 0;
	first_ttl_amt = 0.00;
	second_ttl_amt = 0.00;
	firstPrcsKnt = 0;
	secondPrcsKnt = 0;
	
	if(sheetObjects[1].RowCount() == 0){
		return;
	}
	if(sheetObjects[1].RowCount() == 1){
		firstCurrCd = sheetObjects[1].GetCellValue(2, "sum_curr_cd"); 
		firstPrcsKnt = sheetObjects[1].GetCellValue(2, "dp_prcs_knt"); 
	}
	if(sheetObjects[1].RowCount() == 2){ 
		SeCondCurrCd = sheetObjects[1].GetCellValue(3, "sum_curr_cd"); 
		secondPrcsKnt = sheetObjects[1].GetCellValue(3, "dp_prcs_knt");
	}
	 
	//if (sheetObjects[0].GetSelectCol()==  1){
		for (var i=sheetObjects[0].HeaderRows(); i<= sheetObjects[0].LastRow(); i++){
			if(sheetObjects[0].GetCellValue(i, "del_chk") == "0") {
				//first
				if(sheetObjects[0].GetCellValue(i, "inv_curr_cd") == firstCurrCd){
					first_count += 1; 
					//overdue
					if(parseInt(sheetObjects[0].GetCellValue(i, "over_due")) > 0){
						first_over_amt += parseFloat(ComRound(ComReplaceStr(sheetObjects[0].GetCellValue(i, "bal_amt"),",",""), 2));
					} else {
						first_within_amt += parseFloat(ComRound(ComReplaceStr(sheetObjects[0].GetCellValue(i, "bal_amt"),",",""), 2));
					}
				} else {
					second_count += 1; 
					if(parseInt(sheetObjects[0].GetCellValue(i, "over_due")) > 0){
						second_over_amt += parseFloat(ComRound(ComReplaceStr(sheetObjects[0].GetCellValue(i, "bal_amt"),",",""), 2));
					} else {
						second_within_amt += parseFloat(ComRound(ComReplaceStr(sheetObjects[0].GetCellValue(i, "bal_amt"),",",""), 2));
					}
				}
			}
		}
	//} 
	   
	first_ttl_amt = parseFloat(ComRound(first_within_amt + first_over_amt),2); 
	second_ttl_amt = parseFloat(ComRound(second_within_amt + second_over_amt),2);
		 
	//적용
	if(sheetObjects[1].RowCount() == 1){
		sheetObjects[1].SetCellValue(2, "sum_in_bal", SarMakeNumberFormat(first_within_amt,firstPrcsKnt));
		sheetObjects[1].SetCellValue(2, "sum_over_bal", SarMakeNumberFormat(first_over_amt,firstPrcsKnt));
		sheetObjects[1].SetCellValue(2, "sum_tot_lcl", SarMakeNumberFormat(first_ttl_amt,firstPrcsKnt));
		sheetObjects[1].SetCellValue(2, "sum_count", SarMakeNumberFormat(first_count,firstPrcsKnt));
	}
	if(sheetObjects[1].RowCount() == 2){ 
		sheetObjects[1].SetCellValue(3, "sum_in_bal", SarMakeNumberFormat(second_within_amt,secondPrcsKnt));
		sheetObjects[1].SetCellValue(3, "sum_over_bal", SarMakeNumberFormat(second_over_amt,secondPrcsKnt));
		sheetObjects[1].SetCellValue(3, "sum_tot_lcl", SarMakeNumberFormat(second_ttl_amt,secondPrcsKnt)); 
		sheetObjects[1].SetCellValue(3, "sum_count", SarMakeNumberFormat(second_count,secondPrcsKnt)); 
	}
	return;
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
}

function clearCustomer(){ 
	var formObj=document.form;
	formObj.rct_cust_cnt_cd.value = "";
	formObj.rct_cust_seq.value = "";
	formObj.cust_nm.value = "";
	$("th#search1").hide();
	/*ComSetDisplay("rct_cust_cnt_cd",false);
	ComSetDisplay("rct_cust_seq",false);
	ComSetDisplay("btn_pop_cust_cd",false);
	ComSetDisplay("cust_nm",false);*/
	$("#searchcust").hide();
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	ComBtnDisable("btn_retrieve"); 
}

function change_event_radio1(){ 
	clearCustomer();
}

function change_event_radio2(){
	$("th#search1").show(); 
	$("#searchcust").show();
	/*ComSetDisplay("rct_cust_cnt_cd",true);
	ComSetDisplay("rct_cust_seq",true);
	ComSetDisplay("btn_pop_cust_cd",true);
	ComSetDisplay("cust_nm",true);
	sheetObjects[0].RemoveAll();*/
	ComBtnEnable("btn_retrieve");	
}


