/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : stm_sar_5001.js // 수정
*@FileTitle  : Agent Collection Entry
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
 * @class STM_SAR_5001 : business script for STM_SAR_5001
 */
// common global variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var combo1=null
var comboCnt=0;
var gCurRow=0;
var prefix="sheet1_";
var pre_data=[];
var pre_Org_usd_amt=[];
var pre_Org_locl_amt=[];
var pre_Org_n3rd_amt1=[];
var pre_Org_n3rd_amt2=[];
var pre_Org_n3rd_amt3=[];
var pre_Org_n3rd_amt4=[];
var pre_Org_eqv_locl_amt=[];
var pre_Org_chg_usd_amt=[];
var pre_Org_eqv_locl_amt2=[];
var pre_Org_ttl_amt=[];
var Org_usd_amt=[];
var Org_locl_amt=[];
var Org_n3rd_amt1=[];
var Org_n3rd_amt2=[];
var Org_n3rd_amt3=[];
var Org_n3rd_amt4=[];
var Org_eqv_locl_amt=[];
var Org_chg_usd_amt=[];
var Org_eqv_locl_amt2=[];
var Org_ttl_amt=[];

var  INPUT_RATE_AGENT = "";

var dpPrcsKnt = 2;
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
			case "btn_Close":
				ComClosePopup(); 
    	        break;				
			case "btn_print":
				var dupRow1=sheetObjects[0].ColValueDup(prefix + "chg_tp_cd");
	            // Dup data pre-check before saving
	            if (dupRow1>0) {  
	            	sheetObject1.SetSelectRow(dupRow1);
	            	ComShowCodeMessage('SCO00004', 'Check', 'Duplicated Type');
	                ComSetFocus(sheetObject1.ColValueDupRows(prefix + "chg_tp_cd"));	
	                return false;
	            }
				break;
			case "btnCalduedtFm": 
				if (formObj.option2[0].checked == true){
					var cal=new ComCalendar();
					cal.select(form.due_dt_fm, 'yyyy-MM-dd');
				}
				break;
			case "btnCalduedtTo": 
				if (formObj.option2[0].checked == true){
					var cal=new ComCalendar();
					cal.select(form.due_dt_to, 'yyyy-MM-dd');
				}
				break;	
			case "btn_pop_ofc_cd":
		        ComOpenPopupWithTarget("/opuscntr/STM_SAP_0001.do?ofc_cd="+document.form.ar_ofc_cd.value, 480, 550,"ap_ofc_cd:ar_ofc_cd", "0,0", true);
		        //ComOpenPopupWithTarget("/opuscntr/STM_SAR_0200.do?asa_no="+document.form.ofc_cd.value, 480, 550,"asa_no:ofc_cd", "0,0", true);
		        break;
			case "btn_pop_asa_cd":
				formObj.dp_prcs_knt.value = "";
				if(agn_ofc_cd.GetSelectText() == ""){
					ComShowCodeMessage("COM12113", "Office Code");
					ComSetFocus(document.all.item("agn_ofc_cd"));
					return false;
				}
			
		        ComOpenPopupWithTarget("/opuscntr/STM_SAR_0200.do?asa_no="+ document.form.asa_no1.value + "&ofc_cd="+document.form.ar_ofc_cd.value    , 480, 550,"asa_no1:asa_no1|asa_no2:asa_no2|asa_no3:asa_no3|bil_cre_prd_fm_dt:gl_yrmon_fm|bil_cre_prd_to_dt:gl_yrmon_to|curr_cd:asa_curr_cd|dp_prcs_knt:dp_prcs_knt", "0,0", true);
		        
		        /*
		        if (document.form.option2[0].checked == true){
		        	if(document.form.gl_yrmon_fm.value != ""){
		        		document.form.due_dt_fm.value=ComGetDateAdd(document.form.gl_yrmon_fm.value, "M", -6);
		        	}
			        if(document.form.gl_yrmon_to.value != ""){
			        	document.form.due_dt_to.value=document.form.gl_yrmon_to.value;
			        }
		        }
		        
		        //retrieve Currency Precision
				formObj.f_cmd.value = SEARCH08;
				formObj.curr_cd.value = formObj.asa_curr_cd.value;
				var sXml = sheetObject1.GetSearchData("SARCommonGS.do", FormQueryString(formObj));
				var sStr = ComGetEtcData(sXml,"dp_prcs_knt_list");
				var arrStr = sStr.split("|");
				
				if(ComIsEmpty(arrStr[1])) dpPrcsKnt = 2;
				else dpPrcsKnt = arrStr[1];
				
				//자리수 추가
				sheetObjects[0] = sheetObjects[0].Reset(); 
				sheetObject1=sheetObjects[0];  
				ComConfigSheet(sheetObject1);  
				initSheet(sheetObject1, 1, dpPrcsKnt); 
				ComEndConfigSheet(sheetObject1);  
		        */
		        
		        break;
			case "btn_save":
				var dupRow1=sheetObject1.ColValueDup("2|3|4|5");
				if (dupRow1>0) {  
	            	ComShowCodeMessage("SAR00002");
	            	sheetObject1.RowForeColor(dupRow1)="#FF0000";
	            	return false;
	            }
				doActionIBSheet(sheetObject1,formObj,IBSAVE);
				break;
			case "btn_add":
				doActionIBSheet(sheetObject1,formObj,IBINSERT);
				check_sum();
				break;
			case "btn_del":
				doActionIBSheet(sheetObject1,formObj,REMOVE);
				check_sum();
				break;
			case "btn_new":
				formObj.reset();
				formObj.bnd.disabled=true;
				formObj.bnd.readOnly=true;
				formObj.bnd.style.backgroundColor="#E8E7EC";
    	    	sheetObject1.RemoveAll();
    	    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
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
		initSheet(sheetObjects[i], i + 1, dpPrcsKnt);
		ComEndConfigSheet(sheetObjects[i]);
	}
	// IBMultiCombo초기화
	agn_ofc_cd=comboObjects[0];
	comboCnt=comboObjects.length;
	for (var k=0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k]);
	}
    initControl();
    document.form.bnd.disabled=true;
    document.form.bnd.readOnly=true;
    document.form.bnd.style.backgroundColor="#E8E7EC";
    document.form.svc_scp_cd.readOnly=true;
    document.form.svc_scp_cd.style.backgroundColor="#E8E7EC";
    document.form.port_cd.readOnly=true;
    document.form.port_cd.style.backgroundColor="#E8E7EC";
    document.form.vvd_cd.readOnly=true;
    document.form.vvd_cd.style.backgroundColor="#E8E7EC";
    
    document.form.gl_yrmon_fm.readOnly= true; 
    document.form.gl_yrmon_fm.style.backgroundColor="#E8E7EC";
    document.form.gl_yrmon_to.readOnly= true; 
    document.form.gl_yrmon_to.style.backgroundColor="#E8E7EC";
    document.form.asa_curr_cd.readOnly= true; 
    document.form.asa_curr_cd.style.backgroundColor="#E8E7EC";
    document.form.ttl_cnt.readOnly= true 
    document.form.ttl_cnt.style.backgroundColor="#E8E7EC";
    document.form.ttl_amt_sum.readOnly= true; 
    document.form.ttl_amt_sum.style.backgroundColor="#E8E7EC";
    document.form.usd_amt_sum.readOnly= true; 
    document.form.usd_amt_sum.style.backgroundColor="#E8E7EC"; 
    document.form.eqv_lcl_sum.readOnly= true; 
    document.form.eqv_lcl_sum.style.backgroundColor="#E8E7EC";
    document.form.source_amt_sum.readOnly= true; 
    document.form.source_amt_sum.style.backgroundColor="#E8E7EC";
    document.form.charge_amt_sum.readOnly= true; 
    document.form.charge_amt_sum.style.backgroundColor="#E8E7EC";
    document.form.n3rd_amt1_sum.readOnly= true; 
    document.form.n3rd_amt1_sum.style.backgroundColor="#E8E7EC";
    document.form.n3rd_amt2_sum.readOnly= true; 
    document.form.n3rd_amt2_sum.style.backgroundColor="#E8E7EC"; 
    document.form.n3rd_amt3_sum.readOnly= true; 
    document.form.n3rd_amt3_sum.style.backgroundColor="#E8E7EC";
    document.form.n3rd_amt4_sum.readOnly= true; 
    document.form.n3rd_amt4_sum.style.backgroundColor="#E8E7EC";
    document.form.eqv_lcl2_sum.readOnly= true;  
    document.form.eqv_lcl2_sum.style.backgroundColor="#E8E7EC";
    document.form.asa_no2.readOnly= true;  
    document.form.asa_no2.style.backgroundColor="#E8E7EC";
    document.form.asa_no3.readOnly= true;  
    document.form.asa_no3.style.backgroundColor="#E8E7EC";
    
//    document.form.asa_no1.value ="SHA";
//    document.form.asa_no2.value ="401";
//    document.form.asa_no3.value ="0160";
//    
//    document.form.gl_yrmon_fm.value ="20140109";
//    document.form.gl_yrmon_to.value ="20140115";
//    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
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
	//comboObj.SetDropHeight(240);
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
	axon_event.addListenerFormat('blur', 'obj_blur'    , formObj); 	//- handling code when OnBeforeDeactivate(blur) event
}

function change_event_radio1(){
	sheetObjects[0].RemoveAll();
}

//radio button click
function change_event_radio2(){
	sheetObjects[0].RemoveAll();
	var formObject=document.form;
//	formObject.vvd_cd.value ="";
//	formObject.due_dt_fm.value ="";
//	formObject.due_dt_to.value = "";
	if (formObject.option2[0].checked == true){
		formObject.vvd_cd.readOnly=true;
		formObject.vvd_cd.style.backgroundColor="#E8E7EC";
		formObject.due_dt_fm.readOnly=false;
		formObject.due_dt_to.readOnly=false;
		formObject.due_dt_fm.style.backgroundColor="#FFFFFF";
		formObject.due_dt_to.style.backgroundColor="#FFFFFF";
		formObject.bnd.disabled=true;
		formObject.bnd.readOnly=true;
		formObject.bnd.style.backgroundColor="#E8E7EC";
		formObject.svc_scp_cd.readOnly=true;
		formObject.svc_scp_cd.style.backgroundColor="#E8E7EC";
		formObject.port_cd.readOnly=true;
		formObject.port_cd.style.backgroundColor="#E8E7EC";
		if(formObject.gl_yrmon_fm.value != ""){
    		formObject.due_dt_fm.value=ComGetDateAdd(formObject.gl_yrmon_fm.value, "M", -6);
    	}
        if(formObject.gl_yrmon_to.value != ""){
        	formObject.due_dt_to.value=formObject.gl_yrmon_to.value;
        }
	} else if (formObject.option2[1].checked == true) {
		formObject.vvd_cd.readOnly=false;
        formObject.vvd_cd.style.backgroundColor="#FFFFFF";  //"#cdffff"; "#bebebe"; #E8E7EC  CCFFFD 7896B1 7F9DB9 E8E7EC
        formObject.due_dt_fm.readOnly=true;
		formObject.due_dt_to.readOnly=true;
		formObject.due_dt_fm.style.backgroundColor="#E8E7EC";
		formObject.due_dt_to.style.backgroundColor="#E8E7EC";
		formObject.bnd.disabled=false;
		formObject.bnd.readOnly=false;
		formObject.bnd.style.backgroundColor="#CCFFFD";
		formObject.svc_scp_cd.readOnly=false;
		formObject.svc_scp_cd.style.backgroundColor="#FFFFFF";
		formObject.port_cd.readOnly=false;
		formObject.port_cd.style.backgroundColor="#FFFFFF";
	}
}
//handling Axon event 2
function obj_blur(){
    var src=ComGetEvent("name")
	if (src != "vvd_cd"){
		ComChkObjValid(ComGetEvent());
	}
}
function obj_focus(){
    ComClearSeparator(ComGetEvent());
}
//function obj_keypress(){
//	var src = window.event.srcElement.getAttribute("name")
//}
function form_keyup(){
	ComKeyEnter('lengthnextfocus');
}
function obj_onclick(){
	var src=ComGetEvent("name")
}
function gl_yrmon_to_OnChange(){
	if(document.form.asa_no1.value == ""){
		return false;
	}
	if (document.form.option2[0].checked == true){
    	if(document.form.gl_yrmon_fm.value != ""){
    		document.form.due_dt_fm.value=ComGetDateAdd(document.form.gl_yrmon_fm.value, "M", -6);
    	}
        if(document.form.gl_yrmon_to.value != ""){
        	document.form.due_dt_to.value=document.form.gl_yrmon_to.value;
        }
    }
}

function asa_curr_cd_OnChange(){	
	if(document.form.asa_no1.value == ""){
		return false;
	}
	
	//retrieve Currency Precision
	document.form.f_cmd.value = SEARCH08;
	document.form.curr_cd.value = document.form.asa_curr_cd.value;
	var sXml = sheetObjects[0].GetSearchData("SARCommonGS.do", FormQueryString(document.form));
	var sStr = ComGetEtcData(sXml,"dp_prcs_knt_list");
	var arrStr = sStr.split("|");
	
	if(ComIsEmpty(arrStr[1])) dpPrcsKnt = 2;
	else dpPrcsKnt = arrStr[1];
	
	//자리수 추가
	sheetObjects[0] = sheetObjects[0].Reset(); 
	ComConfigSheet(sheetObjects[0]);  
	initSheet(sheetObjects[0], 1, dpPrcsKnt); 
	ComEndConfigSheet(sheetObjects[0]); 
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
function initSheet(sheetObj, sheetNo, dpPrcsKnt) {
	var cnt=0;	
	switch (sheetNo) {
	case 1: //t1sheet1 init
		with (sheetObj) {
	        var HeadTitle1="|Del|ASA No|B/L No|Invoice No|Charge Code|VVD|Port|Due Date|Type|TTL AMT|USD AMT";
	        HeadTitle1=HeadTitle1 + "|EX. Rate1|Equivalence\nLCL|Local CUR|Source AMT|EX. Rate1|Charge AMT|3rd CUR1|3rd AMT1|3rd Rate1|3rd CUR2";
	        HeadTitle1=HeadTitle1 + "|3rd AMT2|3rd Rate2|3rd CUR3|3rd AMT3|3rd Rate3|3rd CUR4|3rd AMT4|3rd Rate4|Equivalence\nLCL2|Remark";
	        HeadTitle1=HeadTitle1 + "|asa_clt_seq|ar_ofc_cd|eff_dt|agn_cd|svc_scp_cd|ib_ob_cd|asa_curr_cd|sail_arr_dt|gl_yrmon|n3rd_locl_amt1";
	        HeadTitle1=HeadTitle1 + "|n3rd_locl_amt2|n3rd_locl_amt3|n3rd_locl_amt4|cre_usr_id|cre_dt|upd_usr_id|upd_dt";
	        var headCount=ComCountHeadTitle(HeadTitle1);
	        var prefix="sheet1_";
	
	        SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	        
	        if(dpPrcsKnt == 0){ 
	        	 var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		   		               {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_chk" },
		   		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"asa_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:12 },
		   		               {Type:"PopupEdit", Hidden:0, Width:110,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:12 },
		   		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		   		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"chg_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		   		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
		   		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"port_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
		   		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"due_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		   		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"asa_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		   		               {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ttl_amt",        KeyField:0,   CalcLogic:"",   Format:"",       	  PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
		   		               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"usd_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
		   		               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"asa_xch_rt1",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:6,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
		   		               {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"eqv_locl_amt",   KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
		   		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"locl_curr_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		   		               {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"locl_amt",       KeyField:0,   CalcLogic:"",   Format:"",       	  PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
		   		               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"asa_xch_rt2",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:6,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
		   		               {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"chg_usd_amt",    KeyField:0,   CalcLogic:"",   Format:"",       	PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
		   		               {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",   ColMerge:1,   SaveName:prefix+"n3rd_curr_cd1",   KeyField:0,   CalcLogic:"",   Format:"",       	  Edit:false}, 
		   		               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"n3rd_amt1",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
		   		               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"n3rd_xch_rt1",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:6,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
		   		               {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",   ColMerge:1,   SaveName:prefix+"n3rd_curr_cd2",   KeyField:0,   CalcLogic:"",   Format:"",       	  Edit:false}, 
		   		               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"n3rd_amt2",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
		   		               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"n3rd_xch_rt2",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:6,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
		   		               {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",   ColMerge:1,   SaveName:prefix+"n3rd_curr_cd3",   KeyField:0,   CalcLogic:"",   Format:"",       	  Edit:false}, 
		   		               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"n3rd_amt3",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
		   		               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"n3rd_xch_rt3",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:6,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
		   		               {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",   ColMerge:1,   SaveName:prefix+"n3rd_curr_cd4",   KeyField:0,   CalcLogic:"",   Format:"",       	  Edit:false}, 
		   		               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"n3rd_amt4",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
		   		               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"n3rd_xch_rt4",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:6,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
		   		               {Type:"Int",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"eqv_locl_amt2",  KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:18 },
		   		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"asa_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 },
		   		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"asa_clt_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		   		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ar_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		   		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eff_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		   		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"agn_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		   		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"svc_scp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		   		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ib_ob_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		   		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"asa_curr_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		   		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sail_arr_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		   		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"gl_yrmon",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		   		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"n3rd_locl_amt1", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		   		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"n3rd_locl_amt2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		   		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"n3rd_locl_amt3", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		   		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"n3rd_locl_amt4", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		   		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		   		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		   		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		   		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	        } else {
	        	var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
	  		               {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_chk" },
	  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"asa_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:12 },
	  		               {Type:"PopupEdit", Hidden:0, Width:110,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:12 },
	  		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	  		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"chg_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
	  		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
	  		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"port_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
	  		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"due_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	  		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"asa_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
	  		               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ttl_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:dpPrcsKnt,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
	  		               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"usd_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
	  		               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"asa_xch_rt1",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:6,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
	  		               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"eqv_locl_amt",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:dpPrcsKnt,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
	  		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"locl_curr_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
	  		               {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"locl_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:dpPrcsKnt,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
	  		               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"asa_xch_rt2",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:6,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
	  		               {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"chg_usd_amt",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:dpPrcsKnt,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
	  		               {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",   ColMerge:1,   SaveName:prefix+"n3rd_curr_cd1",   KeyField:0,   CalcLogic:"",   Format:"",       	 Edit:false}, 
	  		               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"n3rd_amt1",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
	  		               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"n3rd_xch_rt1",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:6,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
	  		               {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",   ColMerge:1,   SaveName:prefix+"n3rd_curr_cd2",   KeyField:0,   CalcLogic:"",   Format:"",       	 Edit:false}, 
	  		               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"n3rd_amt2",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
	  		               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"n3rd_xch_rt2",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:6,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
	  		               {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",   ColMerge:1,   SaveName:prefix+"n3rd_curr_cd3",   KeyField:0,   CalcLogic:"",   Format:"",       	 Edit:false}, 
	  		               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"n3rd_amt3",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
	  		               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"n3rd_xch_rt3",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:6,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
	  		               {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",   ColMerge:1,   SaveName:prefix+"n3rd_curr_cd4",   KeyField:0,   CalcLogic:"",   Format:"",       	  Edit:false}, 
	  		               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"n3rd_amt4",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
	  		               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"n3rd_xch_rt4",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:6,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
	  		               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"eqv_locl_amt2",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:dpPrcsKnt,   UpdateEdit:0,   InsertEdit:1,   EditLen:18 },
	  		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"asa_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 },
	  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"asa_clt_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ar_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eff_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"agn_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"svc_scp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ib_ob_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"asa_curr_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sail_arr_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"gl_yrmon",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"n3rd_locl_amt1", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
	  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"n3rd_locl_amt2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
	  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"n3rd_locl_amt3", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
	  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"n3rd_locl_amt4", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
	  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	        } 
			        InitColumns(cols);
			
			        SetEditable(1);
			        //SetSheetHeight(360);
			        resizeSheet();
			        
	   		}
	        sheetObj.SetColProperty(prefix+"due_dt", {Format:"####-##-##"} );
	        sheetObj.SetColProperty(prefix+"eff_dt", {Format:"####-##-##"} );
	        sheetObj.SetColProperty(prefix+"sail_arr_dt", {Format:"####-##-##"} );
	   break;
	}
}

function resizeSheet(){
	ComResizeSheet(sheetObjects[0], 90);
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
			//loadPageflg = "Y";
			formObj.f_cmd.value=SEARCH03;	
			agn_ofc_cd.RemoveAll();
			var param="f_cmd=" + SEARCH03 + "&ofc_lvl_tp=ENTRY&ofc_brnc_agn_tp_cd=AGT";
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
//						agn_ofc_cd.text=ofcInfo[1];
						agn_ofc_cd.SetSelectText(ofcInfo[1], ofcInfo[1]);
						formObj.ar_ofc_cd.value=ofcInfo[1];
						formObj.asa_no1.value=ofcInfo[13];
					}
				}	
			}
			ar_office = formObj.ar_ofc_cd.value;
		    this.INPUT_RATE_AGENT = chkLookupOneData(sheetObjects[0], "&lu_tp_cd=ABLE TO INPUT AGENT&lu_cd=" + ar_office);
			break;
		case IBSEARCH: //retrieve
			var prefix="sheet1_"; 
			formObj.f_cmd.value=SEARCH; 
			sheetObj.SetWaitImageVisible(0); 
			ComOpenWait(true);	
			
			setTimeout( function () {
				formObj.f_cmd.value=SEARCH;
				var sXml=sheetObj.GetSearchData("STM_SAR_5001GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
				sheetObj.LoadSearchData(sXml,{Sync:1} ); 
				var otsCnt =ComGetEtcData(sXml,"OTSCNT");	
				searchEnd(sheetObj,otsCnt);  
				ComOpenWait(false);
		    } , 100); 
			break;
		case IBSAVE: // saving
			for(i=1; i < sheetObj.RowCount()+1; i++){
				if(sheetObj.GetCellValue(i, prefix + "bl_no") == "" || sheetObj.GetCellValue(i, prefix + "bl_no") == null){
    				ComShowCodeMessage("CGM10004", "bl no");
    				sheetObj.SelectCell(i, prefix + "bl_no", true);
    				return
    			}
    		}
			for(i=1; i < sheetObj.RowCount()+1; i++){
				if(sheetObj.GetCellValue(i, prefix + "inv_no") == "" || sheetObj.GetCellValue(i, prefix + "inv_no") == null){
    				ComShowCodeMessage("CGM10004", "invoice no");
    				sheetObj.SelectCell(i, prefix + "inv_no", true);
    				return
    			}
    		}
			for(i=1; i < sheetObj.RowCount()+1; i++){
				if(sheetObj.GetCellValue(i, prefix + "chg_tp_cd") == "" || sheetObj.GetCellValue(i, prefix + "chg_tp_cd") == null){
    				ComShowCodeMessage("CGM10004", "charge code");
    				sheetObj.SelectCell(i, prefix + "chg_tp_cd", true);
    				return
    			}
    		}

     		for(i=1; i<sheetObj.RowCount()+1; i++){
     			if(sheetObj.GetCellValue(i, prefix + "del_chk") == "1") {
     				sheetObj.SetCellValue(i, prefix + "ibflag","D",0);
     			}else{
     				sheetObj.SetCellValue(i, prefix + "ibflag","I",0);
     			}
    		}
     		
    		formObj.f_cmd.value=MULTI;
    		var sParam=ComGetSaveString(sheetObj);
    		if (sParam == "") return;
    		sParam +=  "&" + FormQueryString(formObj)+"&" + ComGetPrefixParam("sheet1_"); 
    		
    		sheetObj.WaitImageVisible=false;
    		ComOpenWait(true); 
    		var sXml; 
    		setTimeout( function () {
	    		sXml=sheetObj.GetSaveData("STM_SAR_5001GS.do", sParam);
	    		SarOpenWait(false,true);  	
    		} , 100);
    		setTimeout( function () {
    			if(SarShowXmlMessage(sXml) != "") {
    				ComShowMessage(SarShowXmlMessage(sXml));
    			}else{
    			    ComShowCodeMessage("COM130102", "Data");
    			}
    		} , 150);
    		break;
    	case IBINSERT: // inserting
    		var row=sheetObj.DataInsert();
    		if(INPUT_RATE_AGENT == "") {
		    	sheetObjects[0].SetColEditable("sheet1_asa_xch_rt1", 0);
		    } else {
		    	sheetObjects[0].SetColEditable("sheet1_asa_xch_rt1", 1);
		    }
    		sheetObj.SetCellValue(row,prefix + "asa_no",form.asa_no1.value + form.asa_no2.value + form.asa_no3.value ,0);//ComGetObjValue(form.asa_no1);
            break;
    	case REMOVE: // deleting
    		SarCheckedRowDelete1(sheetObject1, prefix + "del_chk");
    		break;
	}
}
function check_sum() {
	var cnt=0;
	var formObject=document.form;
	var prefix="sheet1_";
	var t_ttl_amt_sum = 0;
	var t_usd_amt_sum = 0;
	var t_eqv_lcl_sum = 0;
	var t_source_amt_sum = 0;
	var t_charge_amt_sum = 0;
	var t_n3rd_amt1_sum = 0;
	var t_n3rd_amt2_sum = 0;
	var t_n3rd_amt3_sum = 0;
	var t_n3rd_amt4_sum = 0;
	var t_eqv_lcl2_sum = 0;
	var sheetObj = sheetObjects[0];
	if (sheetObj.RowCount() > 0) {
		//formObject.ttl_cnt.value		 = sheetObjects[0].RowCount; 
			for(i=1; i<sheetObj.RowCount()+1; i++){
	//			if(sheetObj.CellValue(i, prefix + "ibflag") != "D") {
				if(sheetObj.GetCellValue(i, prefix + "del_chk") == "0") {
					cnt += 1;
					t_ttl_amt_sum = t_ttl_amt_sum + parseFloat(ComIsNull(sheetObj.GetCellValue(i, prefix + "ttl_amt"))?0:sheetObj.GetCellValue(i, prefix + "ttl_amt"));
					t_usd_amt_sum = t_usd_amt_sum + parseFloat(ComIsNull(sheetObj.GetCellValue(i, prefix + "usd_amt"))?0:sheetObj.GetCellValue(i, prefix + "usd_amt"));
					t_eqv_lcl_sum = t_eqv_lcl_sum + parseFloat(ComIsNull(sheetObj.GetCellValue(i, prefix + "eqv_locl_amt"))?0:sheetObj.GetCellValue(i, prefix + "eqv_locl_amt"));
					t_source_amt_sum = t_source_amt_sum + parseFloat(ComIsNull(sheetObj.GetCellValue(i, prefix + "locl_amt"))?0:sheetObj.GetCellValue(i, prefix + "locl_amt"));
					t_charge_amt_sum = t_charge_amt_sum + parseFloat(ComIsNull(sheetObj.GetCellValue(i, prefix + "chg_usd_amt"))?0:sheetObj.GetCellValue(i, prefix + "chg_usd_amt"));
					t_n3rd_amt1_sum = t_n3rd_amt1_sum + parseFloat(ComIsNull(sheetObj.GetCellValue(i, prefix + "n3rd_amt1"))?0:sheetObj.GetCellValue(i, prefix + "n3rd_amt1"));
					t_n3rd_amt2_sum = t_n3rd_amt2_sum + parseFloat(ComIsNull(sheetObj.GetCellValue(i, prefix + "n3rd_amt2"))?0:sheetObj.GetCellValue(i, prefix + "n3rd_amt2"));
					t_n3rd_amt3_sum = t_n3rd_amt3_sum + parseFloat(ComIsNull(sheetObj.GetCellValue(i, prefix + "n3rd_amt3"))?0:sheetObj.GetCellValue(i, prefix + "n3rd_amt3"));
					t_n3rd_amt4_sum = t_n3rd_amt4_sum + parseFloat(ComIsNull(sheetObj.GetCellValue(i, prefix + "n3rd_amt4"))?0:sheetObj.GetCellValue(i, prefix + "n3rd_amt4"));
					t_eqv_lcl2_sum = t_eqv_lcl2_sum + parseFloat(ComIsNull(sheetObj.GetCellValue(i, prefix + "eqv_locl_amt2"))?0:sheetObj.GetCellValue(i, prefix + "eqv_locl_amt2"));
				}  
			}	 
			formObject.ttl_cnt.value=String(cnt);  
			
			// To-Be
			formObject.ttl_amt_sum.value = SarMakeNumberFormat(t_ttl_amt_sum,dpPrcsKnt);
			formObject.usd_amt_sum.value =  SarMakeNumberFormat(t_usd_amt_sum,2);
			formObject.eqv_lcl_sum.value =  SarMakeNumberFormat(t_eqv_lcl_sum,dpPrcsKnt);
			formObject.source_amt_sum.value =  SarMakeNumberFormat(t_source_amt_sum,dpPrcsKnt);
			formObject.charge_amt_sum.value = SarMakeNumberFormat(t_charge_amt_sum,dpPrcsKnt);
			formObject.eqv_lcl2_sum.value =  SarMakeNumberFormat(t_eqv_lcl2_sum,dpPrcsKnt); 
			
			/*formObject.n3rd_amt1_sum.value=ComAddComma2(t_n3rd_amt1_sum, "#,###");
			formObject.n3rd_amt2_sum.value=ComAddComma2(t_n3rd_amt2_sum, "#,###");
			formObject.n3rd_amt3_sum.value=ComAddComma2(t_n3rd_amt3_sum, "#,###");
			formObject.n3rd_amt4_sum.value=ComAddComma2(t_n3rd_amt4_sum, "#,###"); */
		} else if (sheetObjects[0].RowCount()== 0){
			formObject.ttl_cnt.value="";
			formObject.ttl_amt_sum.value="";
			formObject.usd_amt_sum.value="";
			formObject.eqv_lcl_sum.value="";
			formObject.source_amt_sum.value="";
			formObject.charge_amt_sum.value="";
			formObject.n3rd_amt1_sum.value="";
			formObject.n3rd_amt2_sum.value="";
			formObject.n3rd_amt3_sum.value="";
			formObject.n3rd_amt4_sum.value="";
			formObject.eqv_lcl2_sum.value="";
		}
	return;
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
			if(formObj.gl_yrmon_to.value == ""||ComIsNull(formObj.gl_yrmon_to.value)){
				ComShowCodeMessage("COM12113", "GL Month");
				ComSetFocus(document.all.item("gl_yrmon_to"));
				return false;
			}
			/*
			if(formObj.due_dt_fm.value == ""||ComIsNull(formObj.due_dt_fm.value)){
				ComShowCodeMessage("COM12113", "From Due Date");
				ComSetFocus(document.all.item("due_dt_fm"));
				return false;
			}
			if(formObj.due_dt_to.value == ""||ComIsNull(formObj.due_dt_to.value)){
				ComShowCodeMessage("COM12113", "To Due Date");
				ComSetFocus(document.all.item("due_dt_to"));
				return false;
			}
			var frDt1=ComReplaceStr(formObj.due_dt_fm,"-","");
			var toDt1=ComReplaceStr(formObj.due_dt_to,"-","");
			if (ComGetDaysBetween(frDt1, toDt1) < 0){
				ComShowCodeMessage("COM132002");
//				formObj.due_dt_to.focus();
				return false;
			}
			*/
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


function searchEnd(sheetObj,otsCnt) { 
	//if combined data
	var prefix="sheet1_";  
	for (var Row=sheetObj.HeaderRows(); Row<= sheetObj.LastRow(); Row++){
		if(Row > otsCnt){
			sheetObj.SetRowBackColor(Row,"#FFFF3C");   
		}
		Org_usd_amt[Row]=sheetObj.CellSearchValue(Row,prefix+"usd_amt");
		Org_locl_amt[Row]=sheetObj.CellSearchValue(Row,prefix+"locl_amt");
		Org_n3rd_amt1[Row]=sheetObj.CellSearchValue(Row,prefix+"n3rd_amt1");
		Org_n3rd_amt2[Row]=sheetObj.CellSearchValue(Row,prefix+"n3rd_amt2");
		Org_n3rd_amt3[Row]=sheetObj.CellSearchValue(Row,prefix+"n3rd_amt3");
		Org_n3rd_amt4[Row]=sheetObj.CellSearchValue(Row,prefix+"n3rd_amt4");
		Org_eqv_locl_amt[Row]=sheetObj.CellSearchValue(Row,prefix+"eqv_locl_amt");
		Org_chg_usd_amt[Row]=sheetObj.CellSearchValue(Row,prefix+"chg_usd_amt");
		Org_eqv_locl_amt2[Row]=sheetObj.CellSearchValue(Row,prefix+"eqv_locl_amt2");
		Org_ttl_amt[Row]=sheetObj.CellSearchValue(Row,prefix+"ttl_amt");
	}
	if(INPUT_RATE_AGENT == "") {
    	sheetObjects[0].SetColEditable("sheet1_asa_xch_rt1", 0);
    } else {
    	sheetObjects[0].SetColEditable("sheet1_asa_xch_rt1", 1);
    }
	check_sum();
}

/*function sheet1_OnClick(sheetObj, Row, Col){
	console.debug("sheet1_OnClick");
	console.debug("sheet1_OnClick :" + sheetObj.GetCellValue(Row,"sheet1_del_chk"));
	var sName=sheetObj.ColSaveName(Col);
	var formObj=document.form;
	var prefix="sheet1_";
	if (Col ==  1){
		if(sheetObj.GetCellValue(Row, prefix + "del_chk") == "1") {
			Org_usd_amt[Row]=sheetObj.CellSearchValue(Row,prefix+"usd_amt");
			Org_locl_amt[Row]=sheetObj.CellSearchValue(Row,prefix+"locl_amt");
			Org_n3rd_amt1[Row]=sheetObj.CellSearchValue(Row,prefix+"n3rd_amt1");
			Org_n3rd_amt2[Row]=sheetObj.CellSearchValue(Row,prefix+"n3rd_amt2");
			Org_n3rd_amt3[Row]=sheetObj.CellSearchValue(Row,prefix+"n3rd_amt3");
			Org_n3rd_amt4[Row]=sheetObj.CellSearchValue(Row,prefix+"n3rd_amt4");
			Org_eqv_locl_amt[Row]=sheetObj.CellSearchValue(Row,prefix+"eqv_locl_amt");
			Org_chg_usd_amt[Row]=sheetObj.CellSearchValue(Row,prefix+"chg_usd_amt");
			Org_eqv_locl_amt2[Row]=sheetObj.CellSearchValue(Row,prefix+"eqv_locl_amt2");
			Org_ttl_amt[Row]=sheetObj.CellSearchValue(Row,prefix+"ttl_amt");
			sheetObj.SetCellValue(Row, prefix+"usd_amt",0,0);
			sheetObj.SetCellValue(Row, prefix+"locl_amt",0,0);
			sheetObj.SetCellValue(Row, prefix+"n3rd_amt1",0,0);
			sheetObj.SetCellValue(Row, prefix+"n3rd_amt2",0,0);
			sheetObj.SetCellValue(Row, prefix+"n3rd_amt3",0,0);
			sheetObj.SetCellValue(Row, prefix+"n3rd_amt4",0,0);
			sheetObj.SetCellValue(Row, prefix+"eqv_locl_amt",0,0);
			sheetObj.SetCellValue(Row, prefix+"chg_usd_amt",0,0);
			sheetObj.SetCellValue(Row, prefix+"eqv_locl_amt2",0,0);
			sheetObj.SetCellValue(Row, prefix+"ttl_amt",0,0);
			pre_Org_usd_amt[Row]=0;
			pre_Org_locl_amt[Row]=0;
			pre_Org_n3rd_amt1[Row]=0;
			pre_Org_n3rd_amt2[Row]=0;
			pre_Org_n3rd_amt3[Row]=0;
			pre_Org_n3rd_amt4[Row]=0;
			pre_Org_eqv_locl_amt[Row]=0;
			pre_Org_chg_usd_amt[Row]=0;
			pre_Org_eqv_locl_amt2[Row]=0;
			pre_Org_ttl_amt[Row]=0;
		} else if(sheetObj.GetCellValue(Row, prefix + "del_chk") == "0") {
			//alert("pre_Org_usd_amt = "+ pre_Org_usd_amt + "   sheetObj.CellValue(Row,prefix+usd_amt)  =  " + sheetObj.CellValue(Row,prefix+"usd_amt") );  
//			if (pre_Org_usd_amt[Row] == sheetObj.CellValue(Row,prefix+"usd_amt")){
			if (Org_usd_amt[Row] != sheetObj.GetCellValue(Row,prefix+"usd_amt")){
					sheetObj.SetCellValue(Row,prefix+"usd_amt",Org_usd_amt[Row]);
				}
//			}
//			if (pre_Org_locl_amt[Row] == sheetObj.CellValue(Row,prefix+"locl_amt")){
			if (Org_locl_amt[Row] != sheetObj.GetCellValue(Row,prefix+"locl_amt")){
					sheetObj.SetCellValue(Row,prefix+"locl_amt",Org_locl_amt[Row]);
				}
//			}
//			if (pre_Org_n3rd_amt1 == sheetObj.CellValue(Row,prefix+"n3rd_amt1")){
			if (Org_n3rd_amt1 != sheetObj.GetCellValue(Row,prefix+"n3rd_amt1")){
					sheetObj.SetCellValue(Row,prefix+"n3rd_amt1",Org_n3rd_amt1[Row]);
				}
//			}
//			if (pre_Org_n3rd_amt2 == sheetObj.CellValue(Row,prefix+"n3rd_amt2")){
			if (Org_n3rd_amt2 != sheetObj.GetCellValue(Row,prefix+"n3rd_amt2")){
					sheetObj.SetCellValue(Row,prefix+"n3rd_amt2",Org_n3rd_amt2[Row]);
				}
//			}
//			if (pre_Org_n3rd_amt3 == sheetObj.CellValue(Row,prefix+"n3rd_amt3")){
			if (Org_n3rd_amt3 != sheetObj.GetCellValue(Row,prefix+"n3rd_amt3")){
					sheetObj.SetCellValue(Row,prefix+"n3rd_amt3",Org_n3rd_amt3[Row]);
				}
//			}
//			if (pre_Org_n3rd_amt4 == sheetObj.CellValue(Row,prefix+"n3rd_amt4")){
			if (Org_n3rd_amt4 != sheetObj.GetCellValue(Row,prefix+"n3rd_amt4")){
					sheetObj.SetCellValue(Row,prefix+"n3rd_amt4",Org_n3rd_amt4[Row]);
				}
//			}
//			if (pre_Org_eqv_locl_amt == sheetObj.CellValue(Row,prefix+"eqv_locl_amt")){
			if (Org_eqv_locl_amt != sheetObj.GetCellValue(Row,prefix+"eqv_locl_amt")){
					sheetObj.SetCellValue(Row,prefix+"eqv_locl_amt",Org_eqv_locl_amt[Row]);
				}
//			}
//			if (pre_Org_chg_usd_amt == sheetObj.CellValue(Row,prefix+"chg_usd_amt")){
			if (Org_chg_usd_amt != sheetObj.GetCellValue(Row,prefix+"chg_usd_amt")){
					sheetObj.SetCellValue(Row,prefix+"chg_usd_amt",Org_chg_usd_amt[Row]);
				}
//			}
//			if (pre_Org_eqv_locl_amt2 == sheetObj.CellValue(Row,prefix+"eqv_locl_amt2")){
			if (Org_eqv_locl_amt2 != sheetObj.GetCellValue(Row,prefix+"eqv_locl_amt2")){
					sheetObj.SetCellValue(Row,prefix+"eqv_locl_amt2",Org_eqv_locl_amt2[Row]);
				}
//			}
			//if (pre_Org_ttl_amt == sheetObj.CellValue(Row,prefix+"ttl_amt")){
			if (Org_ttl_amt != sheetObj.GetCellValue(Row,prefix+"ttl_amt")){
					sheetObj.SetCellValue(Row,prefix+"ttl_amt",Org_ttl_amt[Row]);
				}
			//}
		}
	}
}*/

function sheet1_OnChange(sheetObj, Row, Col, Value ,OldValue) {
	var sName=sheetObj.ColSaveName(Col);
	var formObj=document.form;
	var prefix="sheet1_";
	
	if (Col ==  1){
			if(sheetObj.GetCellValue(Row, prefix + "del_chk") == "1") {
				sheetObj.SetCellValue(Row, prefix+"usd_amt",0,0);
				sheetObj.SetCellValue(Row, prefix+"locl_amt",0,0);
				sheetObj.SetCellValue(Row, prefix+"n3rd_amt1",0,0);
				sheetObj.SetCellValue(Row, prefix+"n3rd_amt2",0,0);
				sheetObj.SetCellValue(Row, prefix+"n3rd_amt3",0,0);
				sheetObj.SetCellValue(Row, prefix+"n3rd_amt4",0,0);
				sheetObj.SetCellValue(Row, prefix+"eqv_locl_amt",0,0);
				sheetObj.SetCellValue(Row, prefix+"chg_usd_amt",0,0);
				sheetObj.SetCellValue(Row, prefix+"eqv_locl_amt2",0,0);
				sheetObj.SetCellValue(Row, prefix+"ttl_amt",0,0);
			} else if(sheetObj.GetCellValue(Row, prefix + "del_chk") == "0") {
				if (Org_usd_amt[Row] != sheetObj.GetCellValue(Row,prefix+"usd_amt")){
						sheetObj.SetCellValue(Row,prefix+"usd_amt",Org_usd_amt[Row],0);
					}
				if (Org_locl_amt[Row] != sheetObj.GetCellValue(Row,prefix+"locl_amt")){
						sheetObj.SetCellValue(Row,prefix+"locl_amt",Org_locl_amt[Row],0);
					}
				if (Org_n3rd_amt1 != sheetObj.GetCellValue(Row,prefix+"n3rd_amt1")){
						sheetObj.SetCellValue(Row,prefix+"n3rd_amt1",Org_n3rd_amt1[Row],0);
					}
				if (Org_n3rd_amt2 != sheetObj.GetCellValue(Row,prefix+"n3rd_amt2")){
						sheetObj.SetCellValue(Row,prefix+"n3rd_amt2",Org_n3rd_amt2[Row],0);
					}
				if (Org_n3rd_amt3 != sheetObj.GetCellValue(Row,prefix+"n3rd_amt3")){
						sheetObj.SetCellValue(Row,prefix+"n3rd_amt3",Org_n3rd_amt3[Row],0);
					}
				if (Org_n3rd_amt4 != sheetObj.GetCellValue(Row,prefix+"n3rd_amt4")){
						sheetObj.SetCellValue(Row,prefix+"n3rd_amt4",Org_n3rd_amt4[Row],0);
					}
				if (Org_eqv_locl_amt != sheetObj.GetCellValue(Row,prefix+"eqv_locl_amt")){
						sheetObj.SetCellValue(Row,prefix+"eqv_locl_amt",Org_eqv_locl_amt[Row],0);
					}
				if (Org_chg_usd_amt != sheetObj.GetCellValue(Row,prefix+"chg_usd_amt")){
						sheetObj.SetCellValue(Row,prefix+"chg_usd_amt",Org_chg_usd_amt[Row],0);
					}
				if (Org_eqv_locl_amt2 != sheetObj.GetCellValue(Row,prefix+"eqv_locl_amt2")){
						sheetObj.SetCellValue(Row,prefix+"eqv_locl_amt2",Org_eqv_locl_amt2[Row],0);
					}
				if (Org_ttl_amt != sheetObj.GetCellValue(Row,prefix+"ttl_amt")){
						sheetObj.SetCellValue(Row,prefix+"ttl_amt",Org_ttl_amt[Row],0);
					}
			}
		} else { 
			if (sheetObj.ColSaveName(Col) == prefix+"usd_amt"
				|| 	sheetObj.ColSaveName(Col) == prefix+"locl_amt"
				|| 	sheetObj.ColSaveName(Col) == prefix+"n3rd_amt1"
				|| 	sheetObj.ColSaveName(Col) == prefix+"n3rd_amt2"
				|| 	sheetObj.ColSaveName(Col) == prefix+"n3rd_amt3"
				|| 	sheetObj.ColSaveName(Col) == prefix+"n3rd_amt4"
			){
				if(OldValue == 0 || OldValue == "" || OldValue == null){
					sheetObj.SetCellValue(Row,Col,OldValue,0); 
					ComShowCodeMessage("SAR00066"); 
					return;
				}   
			}
			
			
			Org_ttl_amt[Row]=sheetObj.CellSearchValue(Row,prefix+"ttl_amt");
			sheetObj.SetCellValue(Row, prefix+"eqv_locl_amt",SarRound(sheetObj.GetCellValue(Row, prefix+"usd_amt") * sheetObj.GetCellValue(Row, prefix+"asa_xch_rt1"),dpPrcsKnt),0);
			sheetObj.SetCellValue(Row, prefix+"chg_usd_amt",SarRound(sheetObj.GetCellValue(Row, prefix+"locl_amt") * sheetObj.GetCellValue(Row, prefix+"asa_xch_rt2"),dpPrcsKnt),0);
			var n3rd_amt1=SarRound(sheetObj.GetCellValue(Row, prefix+"n3rd_amt1") * sheetObj.GetCellValue(Row, prefix+"n3rd_xch_rt1"),dpPrcsKnt);
			var n3rd_amt2=SarRound(sheetObj.GetCellValue(Row, prefix+"n3rd_amt2") * sheetObj.GetCellValue(Row, prefix+"n3rd_xch_rt2"),dpPrcsKnt);
			var n3rd_amt3=SarRound(sheetObj.GetCellValue(Row, prefix+"n3rd_amt3") * sheetObj.GetCellValue(Row, prefix+"n3rd_xch_rt3"),dpPrcsKnt);
			var n3rd_amt4=SarRound(sheetObj.GetCellValue(Row, prefix+"n3rd_amt4") * sheetObj.GetCellValue(Row, prefix+"n3rd_xch_rt4"),dpPrcsKnt);
			
			sheetObj.SetCellValue(Row, prefix+"n3rd_locl_amt1", n3rd_amt1, 0);
			sheetObj.SetCellValue(Row, prefix+"n3rd_locl_amt2", n3rd_amt2, 0);
			sheetObj.SetCellValue(Row, prefix+"n3rd_locl_amt3", n3rd_amt3, 0);
			sheetObj.SetCellValue(Row, prefix+"n3rd_locl_amt4", n3rd_amt4, 0);
	
			sheetObj.SetCellValue(Row, prefix+"eqv_locl_amt2",n3rd_amt1 + n3rd_amt2 + n3rd_amt3 + n3rd_amt4,0);
			var eqv_locl_amt=Number(sheetObj.GetCellValue(Row, prefix+"eqv_locl_amt"));
			var chg_usd_amt=Number(sheetObj.GetCellValue(Row, prefix+"chg_usd_amt"));
			var eqv_locl_amt2=Number(sheetObj.GetCellValue(Row, prefix+"eqv_locl_amt2"));
			sheetObj.SetCellValue(Row, prefix+"ttl_amt",eqv_locl_amt + chg_usd_amt + eqv_locl_amt2,0);
		}
		check_sum();
}
/**
 * Duplicate Check
 * @param {ibsheet}	sheet	IBSheet Object
 * @return
 */        
function chkDupRow(sheet){
	var idx=0;
//no support[check again]CLT 	var Rows;
//no support[check again]CLT 	Rows=sheet.ColValueDup("2|3|4|5");
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
	var sheetID=sheetObj.id;
	var prefix="sheet1_";
	var param="";
	with (sheetObj) {
        switch (ColSaveName(Col)) {
            case  prefix + "bl_no":    //Supplier code
            	var param="?bl_no=" 		+ sheetObj.GetCellValue(Row, prefix+"bl_no")
            	          + "&ar_ofc_cd=" 	+ document.form.ar_ofc_cd.value 
            	          + "&gl_yrmon_to=" + document.form.gl_yrmon_to.value 
            	          + "&option1=" 	//+ document.form.option1.checked 
            	          + "&due_dt_fm=" 	+ document.form.due_dt_fm.value  
            	          + "&due_dt_to=" 	+ document.form.due_dt_to.value  
            	          + "&asa_curr_cd=" 	+ document.form.asa_curr_cd.value  
            	          + "&delt_fla=N";
				ComOpenPopup("STM_SAR_5901.do" + param, 900, 550, "setPopupData", "0,0", true, false, Row, Col, 0);
            	break;
        }
    }
}
/**
 * Pop-Up Return Value 처리 부분<br>
 * @param aryPopupData : {arry} returnedValues Pop-up 화면의 Return value array
 * @param Row : 대상Object가 IBSheet일 경우 해당 Row index
 * @param Col : 대상Object가 IBSheet일 경우 해당 Col index
 * @param ShtIdx : 대상IBSheet의 Sheet Array index
 */
function setPopupData(aryPopupData, Row, Col, ShtIdx) {
    if (aryPopupData.length > 0 ) {
        with (sheetObjects[ShtIdx]) {
        	var sheetObj=sheetObjects[ShtIdx];
        	var prefix=sheetObjects[ShtIdx].id + "_";
        	 
       		//check validation 
       		for (var i=sheetObj.HeaderRows(); i<= sheetObj.LastRow(); i++){
       			var blNo = aryPopupData[0][2];
       			var invNo = aryPopupData[0][3];
       			var chgTpCd = aryPopupData[0][4];
       			var arOfcCd = aryPopupData[0][32];
       			
       			if(blNo == sheetObj.GetCellValue(i,prefix + "bl_no") &&
       					invNo == sheetObj.GetCellValue(i,prefix + "inv_no") &&		
       					chgTpCd == sheetObj.GetCellValue(i,prefix + "chg_tp_cd") &&
       					arOfcCd == sheetObj.GetCellValue(i,prefix + "ar_ofc_cd")){
       				ComShowCodeMessage("SAR00067",blNo);   
       				sheetObj.SetSelectRow(i); 
       				return;     
       			}
    		}
        	
            switch (ColSaveName(Col)) {
               	case prefix + "bl_no":	
                	//clear
               		sheetObj.SetCellValue(Row, prefix + "bl_no","",0);
               		sheetObj.SetCellValue(Row, prefix + "inv_no","",0);
               		sheetObj.SetCellValue(Row, prefix + "chg_tp_cd","",0);
                	sheetObj.SetCellValue(Row, prefix + "vvd_cd","",0);
                	sheetObj.SetCellValue(Row, prefix + "port_cd","",0);
                	sheetObj.SetCellValue(Row, prefix + "due_dt","",0);
                	sheetObj.SetCellValue(Row, prefix + "asa_tp_cd","",0);
                	sheetObj.SetCellValue(Row, prefix + "ttl_amt","",0);
                	sheetObj.SetCellValue(Row, prefix + "usd_amt","",0);
                	sheetObj.SetCellValue(Row, prefix + "asa_xch_rt1","",0);
                	sheetObj.SetCellValue(Row, prefix + "eqv_locl_amt","",0);
                	sheetObj.SetCellValue(Row, prefix + "locl_curr_cd","",0);
                	sheetObj.SetCellValue(Row, prefix + "locl_amt","",0);
                	sheetObj.SetCellValue(Row, prefix + "asa_xch_rt2","",0);
                	sheetObj.SetCellValue(Row, prefix + "chg_usd_amt","",0);
                	sheetObj.SetCellValue(Row, prefix + "n3rd_curr_cd1","",0);
                	sheetObj.SetCellValue(Row, prefix + "n3rd_amt1","",0);
                	sheetObj.SetCellValue(Row, prefix + "n3rd_xch_rt1","",0);
                	sheetObj.SetCellValue(Row, prefix + "n3rd_curr_cd2","",0);
                	sheetObj.SetCellValue(Row, prefix + "n3rd_amt2","",0);
                	sheetObj.SetCellValue(Row, prefix + "n3rd_xch_rt2","",0);
                	sheetObj.SetCellValue(Row, prefix + "n3rd_curr_cd3","",0);
                	sheetObj.SetCellValue(Row, prefix + "n3rd_amt3","",0);
                	sheetObj.SetCellValue(Row, prefix + "n3rd_xch_rt3","",0);
                	sheetObj.SetCellValue(Row, prefix + "n3rd_curr_cd4","",0);
                	sheetObj.SetCellValue(Row, prefix + "n3rd_amt4","",0);
                	sheetObj.SetCellValue(Row, prefix + "n3rd_xch_rt4","",0);
                	sheetObj.SetCellValue(Row, prefix + "eqv_locl_amt2","",0);
                	sheetObj.SetCellValue(Row, prefix + "asa_rmk","",0);
                	sheetObj.SetCellValue(Row, prefix + "asa_clt_seq","",0);
                	sheetObj.SetCellValue(Row, prefix + "ar_ofc_cd","",0);
                	sheetObj.SetCellValue(Row, prefix + "eff_dt","",0);
                	sheetObj.SetCellValue(Row, prefix + "agn_cd","",0);
                	sheetObj.SetCellValue(Row, prefix + "svc_scp_cd","",0);
                	sheetObj.SetCellValue(Row, prefix + "ib_ob_cd","",0);
                	sheetObj.SetCellValue(Row, prefix + "asa_curr_cd","",0);
                	sheetObj.SetCellValue(Row, prefix + "sail_arr_dt","",0);
                	sheetObj.SetCellValue(Row, prefix + "gl_yrmon","",0);
                	sheetObj.SetCellValue(Row, prefix + "n3rd_locl_amt1","",0);
                	sheetObj.SetCellValue(Row, prefix + "n3rd_locl_amt2","",0);
                	sheetObj.SetCellValue(Row, prefix + "n3rd_locl_amt3","",0);
                	sheetObj.SetCellValue(Row, prefix + "n3rd_locl_amt4","",0);
                	//setting
                	sheetObj.SetCellValue(Row, prefix + "bl_no",aryPopupData[0][2],0);
                	sheetObj.SetCellValue(Row, prefix + "inv_no",aryPopupData[0][3],0);
               		sheetObj.SetCellValue(Row, prefix + "chg_tp_cd",aryPopupData[0][4],0);
                	sheetObj.SetCellValue(Row, prefix + "vvd_cd",aryPopupData[0][5],0);
                	sheetObj.SetCellValue(Row, prefix + "port_cd",aryPopupData[0][6],0);
                	sheetObj.SetCellValue(Row, prefix + "due_dt",aryPopupData[0][7],0);
                	sheetObj.SetCellValue(Row, prefix + "asa_tp_cd",aryPopupData[0][8],0);
                	sheetObj.SetCellValue(Row, prefix + "ttl_amt",aryPopupData[0][9],0);
                	sheetObj.SetCellValue(Row, prefix + "usd_amt",aryPopupData[0][10],0);
                	sheetObj.SetCellValue(Row, prefix + "asa_xch_rt1",aryPopupData[0][11],0);
                	sheetObj.SetCellValue(Row, prefix + "eqv_locl_amt",aryPopupData[0][12],0);
                	sheetObj.SetCellValue(Row, prefix + "locl_curr_cd",aryPopupData[0][13],0);
                	sheetObj.SetCellValue(Row, prefix + "locl_amt",aryPopupData[0][14],0);
                	sheetObj.SetCellValue(Row, prefix + "asa_xch_rt2",aryPopupData[0][15],0);
                	sheetObj.SetCellValue(Row, prefix + "chg_usd_amt",aryPopupData[0][16],0);
                	sheetObj.SetCellValue(Row, prefix + "n3rd_curr_cd1",aryPopupData[0][17],0);
                	sheetObj.SetCellValue(Row, prefix + "n3rd_amt1",aryPopupData[0][18],0);
                	sheetObj.SetCellValue(Row, prefix + "n3rd_xch_rt1",aryPopupData[0][19],0);
                	sheetObj.SetCellValue(Row, prefix + "n3rd_curr_cd2",aryPopupData[0][20],0);
                	sheetObj.SetCellValue(Row, prefix + "n3rd_amt2",aryPopupData[0][21],0);
                	sheetObj.SetCellValue(Row, prefix + "n3rd_xch_rt2",aryPopupData[0][22],0);
                	sheetObj.SetCellValue(Row, prefix + "n3rd_curr_cd3",aryPopupData[0][23],0);
                	sheetObj.SetCellValue(Row, prefix + "n3rd_amt3",aryPopupData[0][24],0);
                	sheetObj.SetCellValue(Row, prefix + "n3rd_xch_rt3",aryPopupData[0][25],0);
                	sheetObj.SetCellValue(Row, prefix + "n3rd_curr_cd4",aryPopupData[0][26],0);
                	sheetObj.SetCellValue(Row, prefix + "n3rd_amt4",aryPopupData[0][27],0);
                	sheetObj.SetCellValue(Row, prefix + "n3rd_xch_rt4",aryPopupData[0][28],0);
                	sheetObj.SetCellValue(Row, prefix + "eqv_locl_amt2",aryPopupData[0][29],0);
                	sheetObj.SetCellValue(Row, prefix + "asa_rmk",aryPopupData[0][30],0);
                	sheetObj.SetCellValue(Row, prefix + "asa_clt_seq",aryPopupData[0][31],0);
                	sheetObj.SetCellValue(Row, prefix + "ar_ofc_cd",aryPopupData[0][32],0);
                	sheetObj.SetCellValue(Row, prefix + "eff_dt",aryPopupData[0][33],0);
                	sheetObj.SetCellValue(Row, prefix + "agn_cd",aryPopupData[0][34],0);
                	sheetObj.SetCellValue(Row, prefix + "svc_scp_cd",aryPopupData[0][35],0);
                	sheetObj.SetCellValue(Row, prefix + "ib_ob_cd",aryPopupData[0][36],0);
                	sheetObj.SetCellValue(Row, prefix + "asa_curr_cd",aryPopupData[0][37],0);
                	sheetObj.SetCellValue(Row, prefix + "sail_arr_dt",aryPopupData[0][38],0);
                	sheetObj.SetCellValue(Row, prefix + "gl_yrmon",aryPopupData[0][39],0);
                	sheetObj.SetCellValue(Row, prefix + "n3rd_locl_amt1",aryPopupData[0][40],0);
                	sheetObj.SetCellValue(Row, prefix + "n3rd_locl_amt2",aryPopupData[0][41],0);
                	sheetObj.SetCellValue(Row, prefix + "n3rd_locl_amt3",aryPopupData[0][42],0);
                	sheetObj.SetCellValue(Row, prefix + "n3rd_locl_amt4",aryPopupData[0][43],0);
                	break;
                default:
                    SetCellValue(Row, Col,aryPopupData[0][1]);
                    break;
            }
        }
        check_sum();
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
	//cmbObj.SetDropHeight(190);
}  
/**
 * function called when combo box rct_ofc_cd change<br>
 * @param object comboObj
 * @param String value
 * @param String text
 * @author Park sung yong
 * @version 2014.03.26
 */	
function agn_ofc_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj,value,text){ 
	var formObj=document.form;
	
	if (formObj.agn_ofc_cd.value != '' && formObj.agn_ofc_cd.value != '') {
		var arrStr=newCode.split("^");
		formObj.ar_ofc_cd.value=arrStr[0];
		
		//formObj.reset();
		formObj.asa_no1.value = "";
		formObj.asa_no2.value = "";
		formObj.asa_no3.value = "";
		
		formObj.gl_yrmon_fm.value ="";
		formObj.gl_yrmon_to.value ="";
		formObj.due_dt_fm.value ="";
		formObj.due_dt_to.value ="";
		
		formObj.asa_curr_cd.value = "";
		
		sheetObjects[0].RemoveAll();
	}
}
/**
 * Delete  checked row <br>
 * @param {ibsheet} sheet 
 * @param {int} row
 * @author jinyoonoh
 * @version 2009.05.13
 */
 function SarCheckedRowDelete1(sheet, colName) {
	var sRow=sheet.FindCheckedRow(colName);
		if (sRow == "") {
			ComShowCodeMessage("COM12189");
			return ;
		}
	var hRow=sheet.HeaderRows();
	//sheet.SetRenderSheetSum(0);
	for (var row=hRow; row <= sheet.RowCount(); row++) {
		var status=sheet.GetRowStatus(row);
		if (sheet.GetCellValue(row, colName) == 1) {
			SarRowDelete(sheet,  row);
			if (status == "I") {
    			row--;
        	} 
		}
	}    
	//sheet.SetRenderSheetSum(1);
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
/* EES_CGM_3001.js
	var sheetObj=sheetObjects[0];
	var prefix="sheet1_";
	var invRefNoCol=sheetObj.SaveNameCol(prefix + "bl_no");
 	if ((Col == invRefNoCol || Col == invRefNoCol +1)  && Row !=0) { 
var getValue1=sheetObj.GetCellValue(Row, Col);
var getValue2=sheetObj.GetCellValue(Row, Col+1);
 		alert ("getValue1=" + getValue1 + "  getValue2=" + getValue2);
var Row2=sheetObj.FindText(Col, GetCellValue, -1);
alert("Row2=" + sheetObj.FindText(Col, GetCellValue, -1));
 		if(Row2 > 0){
Row3=sheetObj.FindText(Col, GetCellValue, Row2+1);
alert("Row3=" +sheetObj.FindText(Col, GetCellValue, Row2+1));
 			if (Row3 > 0) {
	        	ComShowCodeMessage('COM12115', 'B/L no');
				sheetObj.SetCellValue(Row, Col,'',0);
				sheetObj.SelectCell(Row, Col, true);
 			}
		}
	}
*/

