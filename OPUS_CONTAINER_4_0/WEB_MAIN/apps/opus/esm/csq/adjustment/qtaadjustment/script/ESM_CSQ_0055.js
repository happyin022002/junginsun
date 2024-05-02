/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0055.jsp
*@FileTitle  : QTA Edit
*@author     : CLT
*@version    : 1.0 
*@since      : 2015/01/20
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends
 * @class ESM_CSQ_0055 : ESM_CSQ_0055 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */

/* 개발자 작업  */

//공통전역변수
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
loadExcelVal="N";
//CalcuLogic
var gRev; 
var paCm;
var raCm ;
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
function processButtonClick(){
    var sheetObject=sheetObjects[0];
    var formObj=document.form;
    try {
        var srcName=ComGetEvent("name");
        switch(srcName) {
            case "btn_Retrieve":
                doActionIBSheet(sheetObject, formObj, IBSEARCH);
                break;
            case "btn_Save":
                doActionIBSheet(sheetObject, formObj, IBSAVE);
                break;
            case "btn_Creation":
                doActionIBSheet(sheetObject, formObj, MULTI01);
                break;
            case "btn_Downexcel":
                doActionIBSheet(sheetObject,formObj,IBDOWNEXCEL);
                break;
            case "btn_Loadexcel":
                doActionIBSheet(sheetObject,formObj,IBLOADEXCEL);
                break;
            case "btn_ofcAdd":
                doActionIBSheet(sheetObject,formObj,"OfficeAdd");
                break;
        }
    } catch(e) {
        if( e == "[object Error]") {
            ComShowMessage(ComGetMsg("COM12111", "", ""));
        } else {
            ComShowMessage(e.message);
        }
    }
}
/**
 * IBSheet Object 를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * IBSheet Object 를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setComboObject(combo_obj){
    comboObjects[comboCnt++]=combo_obj;
}
function loadPage(){
    var formObj=document.form;
    loadingMode=true;
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);
    for(k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],comboObjects[k].id);
    }
    initControl();
    toggleButtons("INIT");
    loadingMode=false;
    resizeSheet();
    //이전에는 ias office add 기능을 사용했으나 sector가 만들어지면서 사용하지않음->추후 사용할수있어 숨김
    var ias_office_add=document.getElementById("ias_office_add");
    ias_office_add.style.display="none";
}
 /**
 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
 **/
 function obj_keypress(){
    switch(ComGetEvent("dataformat")){
        case "engup":
            //영문대+숫자
            ComKeyOnlyAlphabet('upper');
            break;
        default:
            //숫자만입력하기(정수,날짜,시간)
            ComKeyOnlyNumber(ComGetEvent());
    }
}
 /**
  * 조회조건 입력할 때 처리
  */
 function obj_KeyUp() {
      var formObject=document.form;
      var srcName=ComGetEvent("name");
      var srcMaxLength=ComGetEvent("maxlength");
      var srcValue=ComGetEvent("value");
      if (ComChkLen(srcValue, srcMaxLength) == "2") {
          ComSetNextFocus();
      }
 }
 function initControl(){
        axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
        axon_event.addListenerFormat('keypress', 'obj_keypress', document.form);
        axon_event.addListenerForm('click', 'f_decimal_flg_click', document.form); 
 }
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
        case 1:     //sheet1 init
            with(sheetObj){
                var HeadTitle1="STS|SEQ|Year|Quarter|Office View|Portion Linked|Trade||Lane Bound|Sub Trade|R.Lane|VVD||||Month|Week|Supply|RHQ|Office|Load|G.RPB|G.REV|CM(PA)|CMCB(PA)|CM(RA)|CMCB(RA)";
                gRev="|grs_rpb_rev|*|lod_qty|";
                paCm="(|grs_rpb_rev|*|lod_qty|)-(|pa_cm_uc_amt|*|lod_qty|)";
                raCm="(|grs_rpb_rev|*|lod_qty|)-(|ra_cm_uc_amt|*|lod_qty|)";
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bse_yr",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bse_qtr_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ofc_vw_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"csq_cng_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"conv_dir_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bse_mon",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bse_wk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Int",       Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"fnl_bsa_capa",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rgn_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"lod_qty",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
                if(loadExcelVal == "Y"){ // Decimal
                    cols.push({Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"grs_rpb_rev",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:13,  UpdateEdit:1,   InsertEdit:1 });
                }else{
                    cols.push({Type:"Int",       Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"grs_rpb_rev",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:13,  UpdateEdit:1,   InsertEdit:1 });
                }
                cols.push({Type:"Int",       Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"g_rev",          KeyField:0,   CalcLogic:gRev, Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                cols.push({Type:"Int",       Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"pa_cm",          KeyField:0,   CalcLogic:paCm, Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                cols.push({Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"pa_cm_uc_amt",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                cols.push({Type:"Int",       Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"ra_cm",          KeyField:0,   CalcLogic:raCm, Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                cols.push({Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"ra_cm_uc_amt",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
 
                InitColumns(cols);
                SetSheetHeight(400);
                SetEditable(1);
            }
            break;
    }
}
/**
* 멀티콤보 항목을 설정한다.
*/
function initCombo(comboObj, comboId) {
    switch(comboObj.options.id) {
        case "f_bse_yr":
        case "f_bse_qtr_cd":
            with (comboObj) {
                SetDropHeight(300);
                SetSelectIndex(1);
            }
            break;
        case "f_ofc_vw_cd":
            with (comboObj) {
                SetDropHeight(300);
                SetSelectIndex(1);
            }
            break;
        default:
            with (comboObj) {
                SetDropHeight(300);
                SetSelectIndex(0);
            }
            break;
    }
}
/**
 * f_bse_yr가 바뀌었을때 period 의 year 변경
 */
function f_bse_yr_OnChange(obj, value, text) {
    period_change();
    setTradeCombo();
}
/**
 * f_bse_qtr_cd 바뀌었을때 period 의 week 기간변경
 */
function f_bse_qtr_cd_OnChange(obj, value, text) {
    var formObj=document.form;
    period_change();
    setTradeCombo();
    doActionIBSheet(sheetObjects[0], formObj, SEARCH01);
}
/**
* onChange event
* f_trd_cd 바뀌었을때  f_lane_cd 콤보조회
*/
function f_trd_cd_OnChange(obj, value, text) {
    setLaneCombo();
}
/**
 * onChange event
 * f_rhq_cd 바뀌었을때  f_rgn_ofc_cd 콤보조회
 */
function f_rhq_cd_OnChange(obj, value, text) {
    var formObj=document.form;
    var rhqCd=ComGetObjValue(f_rhq_cd);
    if(rhqCd!="All"){
        var param="f_cmd=" + SEARCH01
        + "&code_name=officeForPlan"
        + "&code_param=" + rhqCd
        + "&all_flag=All";  // Trade
        var xmlStr=sheetObjects[0].GetSearchData("CommonGS.do", param);
        ComXml2ComboItem(xmlStr, f_rgn_ofc_cd, "code", "name");
    }else{
        f_rgn_ofc_cd.RemoveAll();
        f_rgn_ofc_cd.InsertItem(0, "All", "All");
    }
    f_rgn_ofc_cd.SetSelectIndex(0);
}
/**
 * f_bse_yr, f_bse_qtr_cd, f_trd_cd 바뀌었을때  f_lane_cd 콤보조회
 */
function setLaneCombo() {
    var formObj=document.form;
    var sheetObj=sheetObjects[0];
    var param="";
    var bse_qtr_cd	 = ComGetObjValue(f_bse_qtr_cd);
    var bse_yr		 = ComGetObjValue(f_bse_yr);
    var trd_cd		 = ComGetObjValue(f_trd_cd);
    var rlane_cd	 = ComGetObjValue(f_rlane_cd);
    if ( trd_cd != "All" && trd_cd != "" ) {
	 	param="f_cmd=" + SEARCH01
	     + "&code_name=rLane"
	     + "&code_param="+trd_cd+"|"
	     				+"Q|"
	     				+bse_yr+"|"
	     				+bse_qtr_cd
	     + "&all_flag=All";
        var sXml=sheetObj.GetSearchData("CommonGS.do",param);
        ComXml2ComboItem(sXml, f_rlane_cd, "code", "name");
		// 변경된 Combo box에서 이전선택된 코드의 Index를 구해서 세팅한다.
        var rlane_index=SearchIndex(f_rlane_cd, rlane_cd);
        f_rlane_cd.SetSelectIndex(rlane_index);
    } else {
        f_rlane_cd.RemoveAll();
        f_rlane_cd.InsertItem(0, "All", "All");
        f_rlane_cd.SetSelectIndex(0);
    }
}
/**
 * f_bse_yr, f_bse_qtr_cd  바뀌었을때 f_trd_cd 콤보조회
 */
function setTradeCombo() {
    var formObj=document.form;
    var sheetObj=sheetObjects[0];
    var param="";
	var f_bse_tp_cd  = "Q";
	var f_bse_yr 	 = ComGetObjValue(formObj.f_bse_yr);
	var f_bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
    var trd_cd		 = ComGetObjValue(f_trd_cd);

    param="f_cmd=" + SEARCH01
     + "&code_name=trade"
     + "&code_param="  + f_bse_tp_cd + "|" + f_bse_yr + "|" + f_bse_qtr_cd
     + "&all_flag=";    // Trade
    var sXml=sheetObj.GetSearchData("CommonGS.do",param);
    if (sXml != "") {
        ComXml2ComboItem(sXml, f_trd_cd, "code", "name");
		// 변경된 Combo box에서 이전선택된 코드의 Index를 구해서 세팅한다.
        var trd_index=SearchIndex(f_trd_cd, trd_cd);
        f_trd_cd.SetSelectIndex(trd_index);
    } else {
        f_trd_cd.RemoveAll();
    }
}
/**
 * Sheet 관련 프로세스 처리
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBCLEAR:          // 화면 접속 시
            sheetObj.SetWaitImageVisible(0);
            ComOpenWait(true);
            formObj.f_cmd.value=INIT;
            var sXml=sheetObj.GetSearchData("ESM_CSQ_0055GS.do", FormQueryString(formObj));
            var arrXml=sXml.split("|$$|");
            if (arrXml.length > 0)
                ComXml2ComboItem(arrXml[0], f_bse_yr, "code", "name");
            if (arrXml.length > 1)
                ComXml2ComboItem(arrXml[1], f_bse_qtr_cd, "code", "name");
            if (arrXml.length > 2)
                ComSetYearQta(arrXml[2]);
            if (arrXml.length > 3)
                ComXml2ComboItem(arrXml[3], f_ofc_vw_cd, "code", "name");
            if (arrXml.length > 4)
                ComXml2ComboItem(arrXml[4], f_rhq_cd, "code", "name");
            if (arrXml.length > 5)
                ComXml2ComboItem(arrXml[5], f_dir_cd, "code", "name");
            if (arrXml.length > 6){
                ComXml2ComboItem(arrXml[6], f_csq_cng_tp_cd, "code", "name");
            }
            ComOpenWait(false);
            break;
        case SEARCH01:          // Month,Week
            formObj.f_cmd.value=SEARCH01;
            var sXml=sheetObj.GetSearchData("ESM_CSQ_0055GS.do", FormQueryString(formObj));
            var arrXml=sXml.split("|$$|");
            if (arrXml.length > 0)
                ComXml2ComboItem(arrXml[0], f_to_mon, "code", "name");
            if (arrXml.length > 1)
                ComXml2ComboItem(arrXml[1], f_to_wk, "code", "name");
            f_to_mon.SetSelectIndex(0);
            f_to_wk.SetSelectIndex(0);
            break;
        case MULTI01:          //CMCB Adjust Creation시에
            if (ComShowConfirm (ComGetMsg("CSQ00009")) != 1) {
                return false;
            }
            ComOpenWait(true);
            ComSetSearchParams("f_cmd", MULTI01);
            var sXml=sheet1.GetSaveData("ESM_CSQ_0055GS.do", searchParams);
            var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
            ComOpenWait(false);
            if(State != "S"){
                ComShowMessage(ComResultMessage(sXml));
                return false;
            }else {
                ComShowCodeMessage('CSQ00010','Data');
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
            }
            break;
        case IBSEARCH:          //화면 조회시
            ComOpenWait(true);
            formObj.f_cmd.value=SEARCH;
            loadExcelVal=(formObj.f_decimal_flg.checked == 1)?"Y":"N"; //자식창 inisheet시에 decimal히든 여부 설정
            searchParams=FormQueryString(formObj);
            searchParams=searchParams+ "&f_decimal_flg=" +loadExcelVal;
            sheetObj = sheetObj.Reset();
            initSheet(sheetObj, 1);
            resizeSheet();
    		var rtnXml=sheetObj.GetSearchData("ESM_CSQ_0055GS.do",searchParams);
    		sheetObj.LoadSearchData(rtnXml,{Sync:1} );
            if (sheetObj.SearchRows()== 0) {
                toggleButtons("INIT");
            }else{
                toggleButtons("SEARCH");
            }
            ComOpenWait(false);
            break;
        case IBSAVE:          // 화면 저장시
            if (!validateForm(sheetObjects[0], formObj, sAction)) return false;
            if (sheet1.IsDataModified()== false) {
                ComShowCodeMessage("CSQ00006");
                return false;
            } else if (ComShowConfirm (ComGetMsg("CSQ00004")) != 1) {
                return false;
            }
            ComSetSearchParams("f_cmd", MULTI);
            var sParam=sheet1.GetSaveString(false, true, "ibflag");
            var sXml=sheet1.GetSaveData("ESM_CSQ_0055GS.do", searchParams + "&" +sParam);
            var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
            if(State != "S"){
                ComShowMessage(ComResultMessage(sXml));
                return false;
            }else if(State == "S"){
                ComShowCodeMessage('CSQ00001','Data');
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
            }
            break;
        case IBDOWNEXCEL:        // 엑셀 다운로드
            ComOpenWait(true);
			sheet1.Down2Excel({DownCols: makeHiddenSkipCol(sheet1), SheetDesign:1,Merge:1 });
            ComOpenWait(false);
            break;
        case IBLOADEXCEL:       // 엑셀 업로드
            loadExcelRowCnt=sheet1.HeaderRows()+ sheet1.GetTotalRows();
//			loadExcelRowCnt=sheetObj.HeaderRows()+ sheetObj.GetTotalRows();
            loadExcelTotFlg=false;     // 화면에 Total Row 존재 여부
            loadExcelExField="|conv_dir_cd|vsl_cd|skd_voy_no|skd_dir_cd|bse_mon|bse_wk|lod_qty|grs_rpb_rev|g_rev|pa_cm|ra_cm|";     // 비교 제외 필드
            loadExcelAplyField="|lod_qty|grs_rpb_rev|";               // 반영 필드
        	ComOpenPopup("ESM_CSQ_1001.do?", 1050, 620, "", "0,0", true);
            break;
        case "OfficeAdd":
        	// sheet에 변경사항이 있는지 확인
            if (sheet1.IsDataModified()== true) {
                ComShowCodeMessage("CSQ00017");
                return false;
            }
            ComSetSearchParams("f_cmd", "");
        	ComOpenPopup("ESM_CSQ_0056.do?"+searchParams+ "&div_period=" + document.getElementById("div_period").innerHTML, 800, 550, "callbackPopup", "0,0", true);
            break;
    }
}

function callbackPopup(value){
	// ESM_CSQ_0056에서 받은 리턴값이 S일때 IAS Office Add 후 그리드를 다시 조회한다.
    if(value == "S"){
    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }
}

 /**
  *조회 함수를 이용하여 조회가 완료되고 발생하는 Event
  * @param sheetObj
  */
  function sheet1_OnSearchEnd(sheetObj){
    var row=0;
 // Allocation = QTA Setting 된 경우 해당 Row를 Disable 시킨다.
    while((row=sheet1.FindText("csq_cng_tp_cd", "A", row + 1)) > 0){
    	sheet1.SetRowEditable(row,0);
    }
 }
  /**
  * 화면의 모든 버튼들의 Enable/Disable 을 처리
  */
 function toggleButtons(step) {
    switch (step) {
        case "INIT":
            ComBtnDisable("btn_Save");
            ComBtnDisable("btn_Creation");
            ComBtnDisable("btn_Downexcel");
            ComBtnDisable("btn_Loadexcel");
//ias office add 기능은 있으나 숨겨놓음
//            ComBtnDisable("btn_ofcAdd");
            break;
        case "SEARCH":
            ComBtnEnable("btn_Save");
            ComBtnEnable("btn_Downexcel");
            ComBtnEnable("btn_Loadexcel");
            ComBtnEnable("btn_Creation");
//ias office add 기능은 있으나 숨겨놓음
//            if (ComGetSearchParams("f_trd_cd") == "IAS") {
//                ComBtnEnable("btn_ofcAdd");
//            } else {
//                ComBtnDisable("btn_ofcAdd");
//            }
            break;
    }
 }
  /**
  * ESM_SQM_1001에서 호출 : row의 sqm_cng_tp_cd가 'A'일때 load,G.RPB 반영제외
  */
  function rowExceptionFn(sheetObj,row) {
      if(sheet1.GetCellValue(row,"csq_cng_tp_cd") == "A"){
          return false;
      }else{
          return true;
      }
  }
 /**
  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  */
 function validateForm(sheetObj, formObj, sAction){
    switch(sAction) {
        case IBSAVE:  // save시
            var upRow=sheet1.FindStatusRow("U");
            var uRow=upRow.split(";");
            var sMsg="";
            for(var i=0;i<uRow.length;i++){
                // RPB 값을 제대로 인식하지 못하는 경우가 존재 eval로 실수로 변환하고 이것을 parseInt로 정수로 변환하여 비교하도록 변경
                if(sheet1.GetCellValue(uRow[i],"lod_qty")!=0 && sheet1.GetCellValue(uRow[i],"grs_rpb_rev")==0){
                    sMsg=sMsg + "\n" + sheet1.GetCellValue(uRow[i],"trd_cd")
                    + "-" + sheet1.GetCellValue(uRow[i],"rlane_cd")
                    +"-" + sheet1.GetCellValue(uRow[i],"dir_cd")
                    +"-" + sheet1.GetCellValue(uRow[i],"bse_wk")
                    +"-" + sheet1.GetCellValue(uRow[i],"rhq_cd")
                    +"-" + sheet1.GetCellValue(uRow[i],"rgn_ofc_cd");
                }
            }
            if(sMsg!=""){
                ComShowCodeMessage("CSQ00037","Trade-Rlane-Bound-Week-RHQ-Office",sMsg);
                return false;
            }
            break;
    }
    return true;
 }
 
 function resizeSheet(){
	    for (i=0; i<sheetObjects.length; i++){
	        ComResizeSheet(sheetObjects[i]);
	    }
	}
 /* 개발자 작업  끝 */
