/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0213.js
*@FileTitle  : QTA Set up for IAS Sector by Head Office
*@author     : CLT
*@version    : 1.0
*@since      : 2015/02/06
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends
 * @class ESM_CSQ_0213 : ESM_CSQ_0213 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
/* 개발자 작업  */
//공통전역변수
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var rowCnt=0;
var max=0;
var params="";
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
function processButtonClick(){
    var sheetObject=sheetObjects[0];
    var formObj=document.form;
    try {
        var srcName=ComGetEvent("name");
        switch(srcName) {
            case "f_bse_tp_cd":
                f_bse_tp_cd_OnChange();
                break;
            case "btn_Retrieve":
                doActionIBSheet(sheetObject, formObj, IBSEARCH);
                break;
            case "btn_Save":
                doActionIBSheet(sheetObject, formObj, IBSAVE);
                break;
            case "btn_Creation":
                doActionIBSheet(sheetObject, formObj, IBCREATE);
                break;
            case "btn_AddCreation":
                doActionIBSheet(sheetObject, formObj, "AddCreation");
                break;
            case "btn_Freezing":
                doActionIBSheet(sheetObject, formObj, "Freezing");
                break;
            case "btn_AddFreezing":
                doActionIBSheet(sheetObject, formObj, "AddFreezing");
                break;
            case "btn_Transfer":
                doActionIBSheet(sheetObject,formObj, "Transfer");
                break;
            case "btn_Downexcel":
            	if(sheetObject.RowCount() < 1){//no data
            		ComShowCodeMessage("COM132501");
            	}else{
            		doActionIBSheet(sheetObject,formObj,IBDOWNEXCEL);
            	}
                break;
            case "btn_Loadexcel":
                doActionIBSheet(sheetObject,formObj, "LoadExcel");
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
        //khlee-시작 환경 설정 함수 이름 변경
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
        ComEndConfigSheet(sheetObjects[i]);
    }
    doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);
    initControl();
    for(k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],comboObjects[k].id);
    }
    toggleButtons("INIT");
    loadingMode=false;
    resizeSheet();
}
function initControl() {
    var formObj=document.form;
}
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
        case 1:     //sheet1 init
            with(sheetObj){
            	var HeadTitle1="STS|SEQ|Year|Quarter|Office View|ofc_vw_cd|Trade|Sub Trade|R.Lane|Lane Bound|P/F SKD Group|Supply|RHQ|Office|POL|POD|Main/Sector|Past COA PFMC|Past COA PFMC|Past COA PFMC|Input Item|Input Item|Input Item";
            	var HeadTitle2="STS|SEQ|Year|Quarter|Office View|ofc_vw_cd|Trade|Sub Trade|R.Lane|Lane Bound|P/F SKD Group|Supply|RHQ|Office|POL|POD|Main/Sector|Load|G.RPB|G.REV|Load|G.RPB|G.REV";
            	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

            	var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
            	var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
            	InitHeaders(headers, info);

            	var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bse_yr",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                if(loadExcelVal=="Y"){
                	cols.push({Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bse_qtr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                }else{
                	cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bse_qtr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                }
                cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ofc_vw_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                cols.push({Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ofc_vw_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                cols.push({Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                cols.push({Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                cols.push({Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pf_grp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                cols.push({Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"fnl_bsa_capa",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rgn_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                cols.push({Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"csq_mn_sctr_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"gid_lod_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"gid_grs_rpb_rev",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"gid_grs_ttl_rev",  KeyField:0,   CalcLogic:"|gid_lod_qty|*|gid_grs_rpb_rev|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"lod_qty",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:0 });
                cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"grs_rpb_rev",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:0 });
                cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"grs_ttl_rev",      KeyField:0,   CalcLogic:"|lod_qty|*|grs_rpb_rev|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
     
                InitColumns(cols);
                SetSheetHeight(400);
                SetEditable(1);
                SetRangeBackColor(1,17,1,22,"#555555");
            }
            break;
    }
}
/**
*조회 함수를 이용하여 조회가 완료되고 발생하는 Event
* @param sheetObj
* @param ErrMsg
*/
function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	setSumText(sheetObj);
}

function setSumText(sheetObj){
    sheetObj.SetSumText(0,"ibflag","");
    sheetObj.SetSumText(0,"bse_yr","TOTAL");
	 //RPB SUM 계산 (sum(REV) / sum(load))]
	if(sheetObj.RowCount() > 0){
		sheetObj.SetSumText(0, "grs_rpb_rev",ComAddComma((sheetObj.GetSumValue(0, "grs_ttl_rev")/sheetObj.GetSumValue(0, "lod_qty")).toFixed(0)));
		sheetObj.SetSumText(0, "gid_grs_rpb_rev",ComAddComma((sheetObj.GetSumValue(0, "gid_grs_ttl_rev")/sheetObj.GetSumValue(0, "gid_lod_qty")).toFixed(0)));
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
            }
            break;
        case "f_ofc_vw_cd":
            with (comboObj) {
                SetDropHeight(300);
                SetSelectIndex(1);
            }
            break;
        case "f_pf_grp_cd":
            with (comboObj) {
        		SetTitleVisible(1);
                SetTitle("R/Lane|Group");
                SetColAlign(0, "center");
                SetColAlign(1, "center");
                SetColWidth(0, "80");
                SetColWidth(1, "80");
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
    setSubTradeCombo();
}
/**
* f_bse_qtr_cd 바뀌었을때 period 의 week 기간변경
*/
function f_bse_qtr_cd_OnChange(obj, value, text) {
    period_change();
    setSubTradeCombo();
}
/**
* Sheet 관련 프로세스 처리
*/
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    var sXml;
    switch(sAction) {
        case IBCLEAR:          // 화면 접속 시
            ComOpenWait(true);
            formObj.f_cmd.value=INIT;
        	sXml=sheetObj.GetSearchData("ESM_CSQ_0213GS.do", FormQueryString(formObj));
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
                ComXml2ComboItem(arrXml[4], f_dir_cd, "code", "name");
            if (arrXml.length > 5)
                ComXml2ComboItem(arrXml[5], f_rhq_cd, "code", "name");
            ComOpenWait(false);
            break;
        case IBSEARCH:          // Retrieve
            ComOpenWait(true);
            setWeek();
            formObj.f_cmd.value=SEARCH01;
            searchParams=FormQueryString(formObj);
        	var rtnXml=sheetObj.GetSearchData("ESM_CSQ_0213GS2.do", searchParams);
            sheetObj.LoadSearchData(rtnXml,{Sync:1} );
            //연간/분기에 따라서 그리드 항목을 보여줬다 감췄다 함
            if (ComGetObjValue(document.form.f_bse_tp_cd) == "Y") {
                sheetObj.SetColHidden("bse_qtr_cd",1);
            } else {
                sheetObj.SetColHidden("bse_qtr_cd",0);
            }
            // ETC의 값을 폼변수에 넣어준다.(f_p_cnt, f_c_cnt, f_t_cnt)
            formObj.f_p_cnt.value=sheetObj.GetEtcData("p_cnt");
            formObj.f_c_cnt.value=sheetObj.GetEtcData("c_cnt");
            formObj.f_t_cnt.value=sheetObj.GetEtcData("t_cnt");
            sheetObj.RemoveEtcData();
            ComOpenWait(false);
            toggleButtons("SEARCH");
            break;
        case IBSAVE:          // Save
            if (sheetObj.IsDataModified()== false) {
                ComShowCodeMessage("CSQ00006");  //There is no data to save
                return false;
            } else if (ComShowConfirm (ComGetMsg("CSQ00004")) != 1) { //Do you want to save?
                return false;
            }
            ComOpenWait(true);
        	ComSetSearchParams("f_cmd", MULTI01);
            var sParam=sheetObj.GetSaveString(false, true, "ibflag");
            var sXml=sheetObj.GetSaveData("ESM_CSQ_0213GS.do", searchParams + "&" +sParam);
            var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
            if(State != "S"){
                ComShowMessage(ComResultMessage(sXml));
                return false;
            }else if(State == "S"){
                ComShowCodeMessage('CSQ00001','Data');
                doActionIBSheet(sheetObj, formObj, IBSEARCH);
            }
            ComOpenWait(false);
            break;
        case IBCREATE:          // Creation
            if (sheetObj.IsDataModified()== true) {
                ComShowCodeMessage("CSQ00030",'Creation'); //There are modified data.\nPlease save before you click {?msg1}.
                return false;
            }
            if (ComShowConfirm (ComGetMsg('CSQ00012','Creation')) != 1) { //Do you want to {?msg1}?
                return false;
            }
            ComOpenWait(true);
            ComSetSearchParams("f_cmd", MULTI02);
            var sXml=sheetObj.GetSearchData("ESM_CSQ_0213GS.do", searchParams);
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
        case "AddCreation":          // AddCreation Popup
//        	ComOpenWindow("ESM_CSQ_0214.do?" + searchParams,  null,  "dialogHeight:550px;dialogWidth:885px;center:yes;resizable:no;scroll:no;status:no;unadorned:yes;" , true);
        	ComOpenPopup("ESM_CSQ_0214.do?"+searchParams, 885, 550, "callbackPopup", "0,0", true);
        	break;
        case "Freezing":          // Freezing
            if (sheetObj.IsDataModified()== true) {
                ComShowCodeMessage("CSQ00030",'Freezing'); //There are modified data.\nPlease save before you click {?msg1}.
                return false;
            }
            if (ComShowConfirm (ComGetMsg('CSQ00012','Freezing')) != 1) { //Do you want to {?msg1}?
                return false;
            }
            ComOpenWait(true);
        	ComSetSearchParams("f_cmd", MULTI03);
            var sXml=sheetObj.GetSearchData("ESM_CSQ_0213GS.do", searchParams);
            var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
            ComOpenWait(false);
            if(State != "S"){
                ComShowMessage(ComResultMessage(sXml));
                return false;
            }else {
                ComShowCodeMessage('CSQ00010','Data');
            }
            // 데이터 생성 후 버튼 컨트롤
            formObj.f_p_cnt.value=sheetObj.GetEtcData("p_cnt");
            formObj.f_c_cnt.value=sheetObj.GetEtcData("c_cnt");
            formObj.f_t_cnt.value=sheetObj.GetEtcData("t_cnt");
            sheetObj.RemoveEtcData();
            toggleButtons("SEARCH");
            break;
        case "AddFreezing":          // AddFreezing Popup
//        	ComOpenWindow("ESM_CSQ_0215.do?" + searchParams,  null,  "dialogHeight:550px;dialogWidth:885px;center:yes;resizable:no;scroll:no;status:no;unadorned:yes;" , true);
        	ComOpenPopup("ESM_CSQ_0215.do?"+searchParams, 885, 550, "", "0,0", true);
        	break;
        case "Transfer":          // 1Q Transfer
            if (ComShowConfirm (ComGetMsg('CSQ00012','1Q Transfer')) != 1) { //Do you want to {?msg1}?
                return false;
            }
            ComOpenWait(true);
            ComSetSearchParams("f_cmd", MULTI04);
            var sXml=sheetObj.GetSearchData("ESM_CSQ_0213GS.do", searchParams);
            var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
            ComOpenWait(false);
            if(State != "S"){
                ComShowMessage(ComResultMessage(sXml));
                return false;
            }else {
                ComShowCodeMessage('CSQ00010','Data');
            }
            // 데이터 생성 후 버튼 컨트롤
            formObj.f_p_cnt.value=sheetObj.GetEtcData("p_cnt");
            formObj.f_c_cnt.value=sheetObj.GetEtcData("c_cnt");
            formObj.f_t_cnt.value=sheetObj.GetEtcData("t_cnt");
            sheetObj.RemoveEtcData();
            toggleButtons("SEARCH");
            break;
        case "LoadExcel":          // LoadExcel
            loadExcelRowCnt=sheetObj.HeaderRows()+ sheetObj.GetTotalRows();
            loadExcelTotFlg=true;      // 화면에 Total Row 존재 여부
            if(ComGetObjValue(formObj.f_bse_tp_cd) == "Y")
                loadExcelExField="|bse_qtr_cd|ofc_vw_cd|trd_cd|sub_trd_cd|gid_lod_qty|gid_grs_rpb_rev|gid_grs_ttl_rev|lod_qty|grs_rpb_rev|grs_ttl_rev|";      // 비교 제외 필드
            else
                loadExcelExField="|ofc_vw_cd|trd_cd|sub_trd_cd|gid_lod_qty|gid_grs_rpb_rev|gid_grs_ttl_rev|lod_qty|grs_rpb_rev|grs_ttl_rev|";     // 비교 제외 필드
            loadExcelAplyField="|lod_qty|grs_rpb_rev|";       // 반영 필드
        	ComOpenPopup("ESM_CSQ_1001.do?", 1050, 620, "", "0,0", true);
            break;
        case IBDOWNEXCEL:       // 엑셀 다운로드
            ComOpenWait(true);
        	sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol( sheetObj), SheetDesign:1,Merge:1 });
            ComOpenWait(false);
            break;
  }
}

function callbackPopup(value){
	// ESM_CSQ_0214에서 받은 리턴값이 S일때 그리드를 다시 조회한다.
    if(value == "S"){
    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }
}
/**
 *  f_bse_yr, f_bse_qtr_cd, f_trd_cd  변경시 f_sub_trd_cd를 변경한다.
 */
function setSubTradeCombo(){
 	var formObj=document.form;
	var f_bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd[0]);
	var f_bse_yr 	 = ComGetObjValue(formObj.f_bse_yr);
	var f_bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
	var trd_cd 		 = ComGetObjValue(formObj.f_trd_cd);
	
 	if ( trd_cd != ""  && trd_cd != "All" ) {
	 	var param="f_cmd=" + SEARCH01
	     + "&code_name=subTradeSector"
	     + "&code_param="+trd_cd+"|"
	     				+f_bse_tp_cd+"|"
	     				+f_bse_yr+"|"
	     				+f_bse_qtr_cd
	     + "&all_flag=All";
        var xmlStr=sheetObjects[0].GetSearchData("CommonGS.do", param);
	 	ComXml2ComboItem(xmlStr, f_sub_trd_cd, "code", "name");
	 	f_sub_trd_cd.SetSelectIndex(0);
 	} else {
 		f_sub_trd_cd.RemoveAll();
 		f_sub_trd_cd.InsertItem(0, "All", "All");
 		f_sub_trd_cd.SetSelectIndex(0);
 	}
}
/**
* onChange event
* f_sub_trd_cd 바뀌었을때  f_lane_cd 콤보조회
*/
function f_sub_trd_cd_OnChange(obj, value, text) {
    setLaneCombo();
 }
/**
 *  f_sub_trd_cd 변경시 f_rlane_cd를 변경한다.
 */
function setLaneCombo(){
    var formObj=document.form;
    var sub_trd_cd	 = ComGetObjValue(f_sub_trd_cd);
	var f_bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd[0]);
	var f_bse_yr 	 = ComGetObjValue(formObj.f_bse_yr);
	var f_bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
	var trd_cd 		 = ComGetObjValue(formObj.f_trd_cd);
	
    if (sub_trd_cd != ""  && sub_trd_cd != "All") {
	 	var param="f_cmd=" + SEARCH01
	     + "&code_name=rLaneSector"
	     + "&code_param="+trd_cd+"|"
	     				+f_bse_tp_cd+"|"
	     				+f_bse_yr+"|"
	     				+f_bse_qtr_cd+"|"
	     			    +sub_trd_cd
	     + "&all_flag=All";
        
        var xmlStr=sheetObjects[0].GetSearchData("CommonGS.do", param);
        ComXml2ComboItem(xmlStr, f_rlane_cd, "code", "name");
        f_rlane_cd.SetSelectIndex(0);
    } else {
        f_rlane_cd.RemoveAll();
        f_rlane_cd.InsertItem(0, "All", "All");
        f_rlane_cd.SetSelectIndex(0);
    }
}
/**
 * f_rlane_cd 바뀌었을때 POL, POD 변경
 */
function f_rlane_cd_OnChange(obj, OldIdx, OldTxt, OldCd, NewIdx, NewTxt, NewCd) {
    var formObj=document.form;
    var sheetObj=sheetObjects[0];
    if(NewCd != "" && NewCd != "All") {
        var code_name=new Array("polCdSector", "podCdSector", "bsaSector");
        var code_param=new Array(NewCd, NewCd, NewCd);
        var all_flag=new Array("All", "All", "All");
        var param="f_cmd="        + SEARCH02
                  + "&code_name="   + code_name
                  + "&code_param="  + code_param
                  + "&all_flag="    + all_flag
                  + "&" + FormQueryString(formObj);
        var sXml=sheetObj.GetSearchData("CommonGS.do", param);
        var arrXml=sXml.split("|$$|");
        if (arrXml.length > 0) {
            ComXml2ComboItem(arrXml[0], f_pol_cd, "code", "name");
            f_pol_cd.SetSelectIndex(0);
        }
        if (arrXml.length > 1) {
            ComXml2ComboItem(arrXml[1], f_pod_cd, "code", "name");
            f_pod_cd.SetSelectIndex(0);
        }
        if (arrXml.length > 2) {
        	ComXml2ComboItem(arrXml[2], f_fnl_bsa_capa, "code", "name");
        	f_fnl_bsa_capa.SetSelectIndex(0);
        }
        //PF GROUP
    	var param2="f_cmd="   + SEARCH02
        + "&code_name=pfGroupPlan"
        + "&code_param="    + NewCd
        + "&all_flag="
        + "&" + FormQueryString(formObj);
        var sXml2=sheetObj.GetSearchData("CommonGS.do", param2);
        var arrXml2=sXml2.split("|$$|");
        if (sXml2.length > 0) {
            ComXml2ComboItem(arrXml2[0], f_pf_grp_cd, "code", "name");
            f_pf_grp_cd.InsertItem(0, "All|All", "All");
            f_pf_grp_cd.SetSelectIndex(0);
        }
    }
}
/**
 * f_bse_tp_cd 바뀌었을때 qtr_cd, week 변경
 */
function f_bse_tp_cd_OnChange() {
    var formObj=document.form;
    var bse_tp_cd=ComGetObjValue(formObj.f_bse_tp_cd);
    var div_qtr=document.getElementById("div_qtr");
    var div_period=document.getElementById("div_period");
    if (bse_tp_cd == "Y") {
        div_qtr.style.display="none";
        div_period.style.display="none";
        f_bse_qtr_cd.SetVisible(0);
    } else {
        div_qtr.style.display="inline";
        div_period.style.display="inline";
        f_bse_qtr_cd.SetVisible(1);
    }
    period_change();
    setSubTradeCombo();
    toggleButtons("SEARCH");
}
/**
 *  선택된 RHQ 에 해당하는 Office 정보 가져와서 ComboBox 셋팅
 */
function f_rhq_cd_OnChange(obj, value, text) {
    var formObj=document.form;
    var sheetObj=sheetObjects[0];
	var rhqCd=ComGetObjValue(formObj.f_rhq_cd);

    if (rhqCd != "All") {
		var sXml=sheetObj.GetSearchData("CommonGS.do", "f_cmd="+ SEARCH01 + "&code_name=officeForPlan&code_param=" + rhqCd + "&all_flag=All");
        var arrXml=sXml.split("|$$|");
        if (arrXml.length > 0) {
            ComXml2ComboItem(arrXml[0], f_rgn_ofc_cd, "code", "name");
            f_rgn_ofc_cd.SetSelectIndex(0);
        }
    } else {
        f_rgn_ofc_cd.RemoveAll();
        f_rgn_ofc_cd.SetSelectIndex(0);
    }
}
/**
 *  주차정보를 세팅한다.
 */
function setWeek(){
	var formObj=document.form;
	var qta=ComGetObjValue(f_bse_qtr_cd);
	var bse_tp_cd=ComGetObjValue(formObj.f_bse_tp_cd);
	if (bse_tp_cd == "Q" ) {
		formObj.f_fm_wk.value=qtaWeekArr[qta][0].substring(3);
		formObj.f_to_wk.value=qtaWeekArr[qta][1].substring(3);
	} else {
		formObj.f_fm_wk.value="00";
		formObj.f_to_wk.value="53";
	}
}
/**
 * 화면의 모든 버튼들의 Enable/Disable 을 처리
 */
function toggleButtons(step) {
    var formObj=document.form;
    switch (step) {
        case "INIT":
            ComBtnDisable("btn_Save");
            ComBtnDisable("btn_Creation");
            ComBtnDisable("btn_AddCreation");
            ComBtnDisable("btn_Freezing");
            ComBtnDisable("btn_AddFreezing");
            ComBtnDisable("btn_Transfer");
            ComBtnDisable("btn_Downexcel");
            ComBtnDisable("btn_Loadexcel");
            ComSetDisplay("btn_AddCreation", false)
            ComSetDisplay("btn_AddFreezing", false)
            break;
        case "SEARCH":
            if (formObj.f_p_cnt.value == "0" )    { // Planning Data가 없을 때
                ComBtnDisable("btn_Save");
                ComBtnEnable("btn_Creation");
                ComBtnDisable("btn_AddCreation");
                ComBtnDisable("btn_Freezing");
                ComBtnDisable("btn_AddFreezing");
                ComBtnDisable("btn_Transfer");
                ComBtnDisable("btn_Downexcel");
                ComBtnDisable("btn_Loadexcel");
                if (ComGetObjValue(formObj.f_bse_tp_cd) == "Y" ) { // 연간이고
                    ComSetDisplay("btn_Transfer", true);
                    ComBtnDisable("btn_Transfer");
                } else {
                    ComBtnDisable("btn_Transfer");
                    ComSetDisplay("btn_Transfer", false);
                }
                ComSetDisplay("btn_Creation", true);
                ComSetDisplay("btn_AddCreation", false);
                ComSetDisplay("btn_Freezing", true);
                ComSetDisplay("btn_AddFreezing", false);
            } else { // Planning Data 가 있을 때
                ComBtnEnable("btn_Save");
                ComBtnDisable("btn_Creation");
                ComBtnEnable("btn_AddCreation");
                ComSetDisplay("btn_Creation", false);
                ComSetDisplay("btn_AddCreation", true);
                if( formObj.f_c_cnt.value == "0" ) { // confirm Data 가 없을 경우
                    ComBtnEnable("btn_Freezing");
                    ComBtnDisable("btn_AddFreezing");
                    ComSetDisplay("btn_Freezing", true);
                    ComSetDisplay("btn_AddFreezing", false);
                    if (ComGetObjValue(formObj.f_bse_tp_cd) == "Y" ) {
                        ComBtnDisable("btn_Transfer");
                        ComSetDisplay("btn_Transfer", true);
                    } else {
                        ComBtnDisable("btn_Transfer");
                        ComSetDisplay("btn_Transfer", false);
                    }
                } else { // confirm Data 가 있을 경우
                    ComBtnDisable("btn_Freezing");
                    ComBtnEnable("btn_AddFreezing");
                    ComSetDisplay("btn_Freezing", false);
                    ComSetDisplay("btn_AddFreezing", true);
                    if (ComGetObjValue(formObj.f_bse_tp_cd[0]) == "Y" ) {
                        if (formObj.f_t_cnt.value == "0") {
                            ComBtnEnable("btn_Transfer");
                            ComSetDisplay("btn_Transfer", true);
                        } else {
                            ComBtnDisable("btn_Transfer");
                            ComSetDisplay("btn_Transfer", true);
                        }
                    } else {
                        ComBtnDisable("btn_Transfer");
                        ComSetDisplay("btn_Transfer", false);
                    }
                }
                ComBtnEnable("btn_Downexcel");
                ComBtnEnable("btn_Loadexcel");
            }
            break;
    }
}

function resizeSheet(){
    for (i=0; i<sheetObjects.length; i++){
        ComResizeSheet(sheetObjects[i]);
    }
}
/* 개발자 작업  끝 */
