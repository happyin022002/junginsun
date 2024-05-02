/* =========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName      : ESD_PRD_0036.js
 *@FileTitle     : CCT MANAGEMENT BY YD
 *Open Issues    :
 *Change history :
 *@LastModifyDate: 2009-02-18
 *@LastModifier  : SUNYONG JEONG
 *@LastVersion   : 1.0 
 * 2009-06-08 SUNYONG JEONG
 * 1.0 최초 생성
 * CSR: N200903040130 20090608 e-NIS CCT MGMT by Yard UI 수정 관련 PRD SKD Logic 보완
========================================================= */

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var validateData = "";
var retValidate = 0;
var locCd = "";
var mode = "";
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    var sheetObject = sheetObjects[0];
    var sheetObject1 = sheetObjects[1];
    var sheetObject2 = sheetObjects[2];
    var sheetObject3 = sheetObjects[3];
    /** **************************************************** */
    var formObject = document.form;

    var con_cd_val ;
    var dispaly ;
    var classId ;
    var param ;
    var chkStr ;    
    try {
        var srcName = window.event.srcElement.getAttribute("name");
      

        /***********************************************************************
         * enterKey 처리
         **********************************************************************/
        var srcObj = window.event.srcElement.nodeName;
        var keyObj = window.event.keyCode;
      
        /****************************/
        switch (srcName) {

        case "btn_retrieve":
            if (!checkInput())
                return;
            doActionIBSheet(sheetObject, formObject, IBSEARCH);

            break;

        case "btn_new":

            formObject.reset();
            sheetObject.removeall();
         
            break;

        case "btn_save":
            doActionIBSheet(sheetObject, formObject, IBSAVE);
            break;

        case "btng_rowadd":
            doActionIBSheet(sheetObject, formObject, IBINSERT);
            break;

        case "btng_rowcopy":
            doActionIBSheet(sheetObject, formObject, IBCOPYROW);
            break;

        case "btn_cnt":
            selectCountry('cnt');
            break;

        case "btn_downexcel":
            doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
            break;

        case "btn_loadexcel":
            doActionIBSheet(sheetObject, formObject, IBLOADEXCEL);
            break;

        case "btng_gotoyardinquiry":

            dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; // com_ens_051_dispaly.value;
            con_cd_val = sheetObject
                    .CellValue(sheetObject.SelectRow, "yd_cd");
            classId = "ESD_PRD_0002";
            // var cmd = SEARCH;
            param = '?classId=' + classId + '&yard_code=' + con_cd_val;
         
            winObject = window
                    .open("/hanjin/ESD_PRD_0002.do" + param, "한진해운PI", "height=770, width=800, top=0");

            break;

        case "btn_con":

            dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; // com_ens_051_dispaly.value;
            classId = "COM_ENS_0M1";
            con_cd_val = formObject.textc.value;
            param = '?classId=' + classId + '&cnt_cd=' + con_cd_val;
            chkStr = dispaly.substring(0, 3);

            if (chkStr == "1,0") {
                ComOpenPopup('/hanjin/COM_ENS_0M1.do' + param, 770, 470, 'getCon', dispaly, true);
            } else {
                ComShowMessage(ComGetMsg('PRD90063'));
                return;
            }
            break;

        case "loc_btn":

            dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; // com_ens_051_dispaly.value;
            classId = "COM_ENS_051";
            var loc_cd_val = formObject.location_code.value;
            param = '?classId=' + classId + '&loc_cd=' + loc_cd_val;

            chkStr = dispaly.substring(0, 3);

            // radio PopUp
            if (chkStr == "1,0") {
            	ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 770, 470, 'getLocation', dispaly, true);
            } else {
                ComShowMessage(ComGetMsg('PRD90063'));
                return;
            }
            break;

        case "node_btn":
            param = '?classId=' + "COM_ENS_061" + '&node_cd=' + formObject.yard_code.value;
            ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 770, 470, 'getNode', "1,0,1,1,1,1,1,1,1,1,1,1", true);
            break;

        case "btn_slan":

            var slan_cd_val = formObject.lane_code.value;

            dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; // Radio PopUp

            classId = "COM_ENS_081";
            param = '?&lane_cd=' + slan_cd_val + '&classId=' + classId;

            chkStr = dispaly.substring(0, 3);

            // Radio PopUp
            if (chkStr == "1,0") {
            	ComOpenPopup('/hanjin/COM_ENS_081.do' + param, 770, 470, 'getLane', dispaly, true);

            } else {
                ComShowMessage(ComGetMsg('PRD90063'));
                return;
            }

            break;

        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComShowMessage(ComGetMsg('COM12111'));
        } else {
            ComShowMessage(e);
        }
    }
}

var cntGb = '';
function selectCountry(cnt) {
    cntGb = cnt;
    var frm = document.form;
    var param = '?classId=' + "COM_ENS_051"
    // var sheetObj = sheetObjects[0];
    if (cntGb == 'cnt') {
        param = param + '&cnt_cd=' + frm.country_code.value;
    }

    ComOpenPopup('/hanjin/COM_ENS_0M1.do' + param, 565, 480, 'getCountry', "1,0,1,1,1,1,1,1,1,1,1,1", true);

}

function getCountry(rowArray) {
    //alertComPopupData(rowArray);

    var colArray = rowArray[0];
    // var sheetObj = sheetObjects[0];
    var frm = document.form;
    if (cntGb == 'cnt') {
        frm.country_code.value = colArray[3];
    }
}

function getCon(rowArray) {
    var colArray = rowArray[0];
    document.all.textc.value = colArray[3];
}

function getLocation(rowArray) {

    var colArray = rowArray[0];
    document.all.location_code.value = colArray[3];
}

function getNode(rowArray) {

    var colArray = rowArray[0];
    document.all.yard_code.value = colArray[3];
}

function getLane(rowArray) {

    var colArray = rowArray[0];
    // sheetObj.CellValue(row, col) = colArray[3];
    document.all.lane_code.value = colArray[3];

}

/*
 * retrieve 를 위한 입력조건 체크 
 */
function checkInput() {
    var formObject = document.form;


    return true;
}

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {

    sheetObjects[sheetCnt++] = sheet_obj;

}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

    for (i = 0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }

    if (locCd != "") {
        formObj = document.form;
        formObj.f_cmd.value = SEARCH;
        sheetObjects[0].DoSearch4Post("ESD_PRD_0036GS.do", PrdFQString(formObj));
    }
    
	if(CRUD == "R") {
    	ComBtnDisable("btn_save");
	}

	//Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	axon_event.addListenerFormat('keypress',         'obj_keypress', 	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
	axon_event.addListener('keypress', 'PrdComKeyEnter' , 'country_code', 'location_code', 'yard_code','lane_code');

}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
    var cnt = 0;

    switch (sheetNo) {
    case 1: //sheet1 init
        with (sheetObj) {
            // 높이 설정
            style.height = 240;

            // 전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            // Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "")
                InitHostInfo(location.hostname, location.port, page_path);

            // 전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

            // 전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(2, 1, 9, 100);

            // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(29, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false, false);
            var HeadTitle  = "SEQ|STS|Del|Act|LOC Code|Yard Code|Lane Code|VVD|Local/Rail|Bound|Cargo Type|Cargo Closing Time|Cargo Closing Time|Cargo Closing Time|Cargo Closing Time|Excl Day|Excl Day|Excl Day|ERD|ERD|ERD|ERD|ERD|C.Date|C.User|U.Date|U.User|cct_type";
            var HeadTitle1 = "SEQ|STS|Del|Act|LOC Code|Yard Code|Lane Code|VVD|Local/Rail|Bound|Cargo Type|CCT TYPE|CCT HOUR|CCT DAY|CCT TIME|Sat|Sun|Holi|Free Day|ETA|Sat|Sun|Holi|C.Date|C.User|U.Date|U.User|cct_type";
            // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);
            InitHeadRow(1, HeadTitle1, true);

            // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++, dtSeq,       30, daCenter, true, "",             false, "", dfNone,          0,  true,  true);
            InitDataProperty(0, cnt++, dtStatus,    30, daCenter, true, "ibflag",       false, "", dfNone,          0,  true,  true);
            //InitDataProperty(0, cnt++, dtData,      30, daCenter, true, "status",     false, "", dfNone,          0, false, false);
            //InitDataProperty(0, cnt++, dtDelCheck,  30, daCenter, true, "",             false, "", dfNone,          0,  true,  true);
            InitDataProperty(0, cnt++, dtDelCheck,  30, daCenter, true, "del_flag",             false, "", dfNone,          0,  true,  true);
            InitDataProperty(0, cnt++, dtCheckBox,  30, daCenter, true, "delete_flag",  false, "", dfNone,          0,  false,  true);
            InitDataProperty(0, cnt++, dtData,      80, daCenter, true, "location_code",false, "", dfNone,          0, false, false);
            InitDataProperty(0, cnt++, dtPopupEdit,100, daCenter, true, "yard_code",    true,  "", dfNone,          0, false,  true, 7);

            InitDataProperty(0, cnt++, dtPopupEdit, 80, daCenter, true, "lane_code",    true,  "", dfNone,          0, false,  true, 3);
            InitDataProperty(0, cnt++, dtData,      80, daCenter, true, "vvd_cd",false, "", dfNone,          0, false, true, 9);
            InitDataProperty(0, cnt++, dtCombo, 80, daCenter, true, "aply_rail_ctnt",    true,  "", dfNone,          0, false,  true);
            
           // InitDataProperty(0, cnt++, dtCombo,      80,   daLeft, true, "lane_dir_code",true,  "", dfNone,          0, false,  true);
            InitDataProperty(0, cnt++, dtHidden,      80,   daLeft, true, "lane_dir_code",false,  "", dfNone,          0, false,  true);
            InitDataProperty(0, cnt++, dtCombo,     80,   daLeft, true, "cargo_type",   false, "", dfNone,          0, false,  true);
            InitDataProperty(0, cnt++, dtCombo,     80,   daLeft, true, "cct_type",     false, "", dfNone,          0,  true,  true);
            InitDataProperty(0, cnt++, dtData,      80,   daLeft, true, "cct_hour",     false, "", dfUserFormat2,   0,  true,  true);

            InitDataProperty(0, cnt++, dtComboEdit, 80,   daLeft, true, "cct_day",      false, "", dfNone,          0,  true, false);
            InitDataProperty(0, cnt++, dtData,      80,   daLeft, true, "cct_time",     false, "", dfTimeHm,        0,  true, false);
            InitDataProperty(0, cnt++, dtCheckBox,  50,   daLeft, true, "sat_flag",     false, "", dfNone,          0,  true,  true);
            InitDataProperty(0, cnt++, dtCheckBox,  50,   daLeft, true, "sun_flag",     false, "", dfNone,          0,  true,  true);
            InitDataProperty(0, cnt++, dtCheckBox,  50,   daLeft, true, "holi_flag",    false, "", dfNone,          0,  true,  true);
            
            InitDataProperty(0, cnt++, dtData,      80,   daCenter, true, "ert_rcv_dt_free_dy",     false, "", dfNone,        0,  true, true);
            InitDataProperty(0, cnt++, dtCheckBox,  50,   daLeft, true, "ert_rcv_dt_eta_flg",     false, "", dfNone,          0,  false,  false);
            InitDataProperty(0, cnt++, dtCheckBox,  50,   daLeft, true, "ert_rcv_dt_sat_flg",     false, "", dfNone,          0,  true,  true);
            InitDataProperty(0, cnt++, dtCheckBox,  50,   daLeft, true, "ert_rcv_dt_sun_flg",     false, "", dfNone,          0,  true,  true);
            InitDataProperty(0, cnt++, dtCheckBox,  50,   daLeft, true, "ert_rcv_dt_hol_flg",    false, "", dfNone,          0,  true,  true);
            
            InitDataProperty(0, cnt++, dtData,      80,   daCenter, true, "cre_dt",     false, "", dfNone,        0,  false, true);
            InitDataProperty(0, cnt++, dtData,      80,   daCenter, true, "cre_usr_id",     false, "", dfNone,        0,  false, true);
            InitDataProperty(0, cnt++, dtData,      80,   daCenter, true, "upd_dt",     false, "", dfNone,        0,  false, true);
            InitDataProperty(0, cnt++, dtData,      80,   daCenter, true, "upd_usr_id",     false, "", dfNone,        0,  false, true);
            
            InitDataProperty(0, cnt++, dtHidden,  50,   daLeft, true, "cct_old_type",    false, "", dfNone,          0,  false,  false);
            InitDataProperty(0, cnt++, dtHidden,  50,   daLeft, true, "org_delete_flag",    false, "", dfNone,          0,  true,  true);

            // InitDataProperty(0, cnt++, dtData, 160, daLeft, false, "yd_nm", false, "", dfNone, 0, false, false);
            // InitDataProperty(0, cnt++, dtData, 160, daLeft, false, "ln_nm", false, "", dfNone, 0, false, false);
            // InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cct_hr2", true, "", dfUserFormat2, 0, true, true);
            InitComboNoMatchText(true);
            // InitDataProperty2(0, "cct_hr", dtData, "DataFormat=dfUserFormat");
            InitUserFormat2(0, "cct_hour", "- ## H", " |-|H");
            // InitUserFormat(0, "cct_hrmnt", "##.##", "." );
            InitViewFormat(0, "cct_time", "hh:mm");
            InitDataCombo(0, "cct_type", "ETB|ETD|Day|CMN", "ETB|ETD|Day|CMN");
            InitDataCombo(0, "lane_dir_code", "All|E|W", "A|E|W");
            InitDataCombo(0, "cargo_type", "All|Dry|Reefer|DG", "AL|DR|RF|DG");
            InitDataCombo(0, "cct_day", cct_dayText, cct_dayCode);
            InitDataCombo(0, "aply_rail_ctnt", "Local|Rail", "LOCAL|RAIL");

			InitDataValid(0, "yard_code", vtEngUpOther, "1234567890");
			InitDataValid(0, "lane_code", vtEngUpOther, "1234567890");
			InitDataValid(0, "vvd_cd", vtEngUpOther, "1234567890");
			
			WaitImageVisible=false;
        }
        break;
    }
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	var uid ;
	var sXml ;
	sheetObj.ShowDebugMsg = false;

    switch (sAction) {

    case IBSEARCH: //조회
        if (validateForm(sheetObj, formObj, sAction));
        	formObj.f_cmd.value = SEARCH;
            sheetObj.DoSearch4Post("ESD_PRD_0036GS.do", PrdFQString(formObj));
        break;

    case IBSAVE: //저장
		// cct_type에 따른 필수 입력 항목 체크.
		if(!keyFieldCheck(sheetObj)) break;

        if (validateForm(sheetObj, formObj, sAction));
            formObj.f_cmd.value = MULTI;
            if ( !sheetObj.DoSave("ESD_PRD_0036GS.do", PrdFQString(formObj)) ) {
            	// del_flag 체크
            	delCheck(sheetObj);
            }
        break;

    case IBDOWNEXCEL: //엑셀 다운로드

        sheetObj.Down2Excel(-1, false, false, true);
        break;

    case IBLOADEXCEL: //엑셀 업로드
        sheetObj.LoadExcel();

        break;

    case IBINSERT: // 입력

        if (validateForm(sheetObj, formObj, sAction))

            sheetObj.DataInsert();
            //CCT Management by Yard for Export Booking.메뉴관련 추가
            sheetObj.CellValue2(sheetObj.SelectRow, "lane_dir_code") ='A';
            sheetObj.CellValue2(sheetObj.SelectRow, "ert_rcv_dt_free_dy") ='0';
            sheetObj.CellValue2(sheetObj.SelectRow, "ert_rcv_dt_eta_flg") ='Y';
            if(sheetObj.CellValue(sheetObj.SelectRow,"cct_type") == "ETB" || sheetObj.CellValue(sheetObj.SelectRow,"cct_type")== "ETD"){
            	sheetObj.CellEditable(sheetObj.SelectRow, "cct_time") = true;
            }
        break;

    case IBCOPYROW: // 입력
        sheetObj.DataCopy();
        break;

    case SEARCH04:
    	formObj.f_cmd.value = SEARCH04;
        uid = "ESD_PRD_0036";
        sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do", "uid=" + uid + "&check_data=" + validateData + "&" + PrdFQString(formObj));
        
        sheetObj.LoadSearchXml(sXml, true, -1, true);
    	retValidate = sheetObjects[0].EtcData("rowCount");
  
    	if (retValidate != 0) {
            sheetObj.CellValue2(sheetObj.SelectRow, "location_code") = sheetObjects[0].EtcData("comData2");
        } else {
            sheetObj.CellValue2(sheetObj.SelectRow, "location_code") = "";
            sheetObj.CellValue2(sheetObj.SelectRow, "yard_code") = "";
            sheetObj.SelectCell(sheetObj.SelectRow, "yard_code");
        }
        break;
    // lane code check
    case SEARCH07:
    	formObj.f_cmd.value = SEARCH07;
        uid = "ESD_PRD_0036";
        sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do", "uid=" + uid + "&check_data=" + validateData + "&" + PrdFQString(formObj));

        sheetObj.LoadSearchXml(sXml, true, -1, true);
        
	    retValidate = sheetObjects[0].EtcData("rowCount");
	    if (retValidate == "0" || retValidate ==""){
	        sheetObj.CellValue2(sheetObj.SelectRow, "lane_code") = "";
	        sheetObj.SelectCell(sheetObj.SelectRow, "lane_code");
	    }
        
        break;

    case SEARCH02:
    	formObj.f_cmd.value = SEARCH02;

        uid = "ESD_PRD_0036";
        sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do", "uid=" + uid + "&check_data=" + validateData + "&" + PrdFQString(formObj));

        sheetObj.LoadSearchXml(sXml, true, -1, true);
        retValidate = sheetObjects[0].EtcData("rowCount");
        break;
    }
}

function sheet1_OnPopupClick(sheetObj, row, col) {
	var param ;
	
    if (sheetObj.ColSaveName(col) == "yard_code") {
        param = '?yd_cd=' + sheetObj.CellValue(row, col);

        ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 770, 470, 'getYardGrid', '1,0,1,1,1,1,1,1,1,1,1,1',true,false, row, col);
    }
    if (sheetObj.ColSaveName(col) == "lane_code") {
        param = '?vsl_slan_cd=' + sheetObj.CellValue(row, col);

        ComOpenPopup('/hanjin/COM_ENS_081.do' + param, 770, 470, 'getLaneGrid', '1,0,1,1,1,1,1,1,1,1,1,1',true,false, row, col);

    }
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {

    if (sheetObj.RowCount > 0) {
    	ComBtnEnable("btn_save");
//    	ComEnableObject(document.getElementById("btn_save"), true);
        // bntImgEnable(document.form.btn_new, true);
        // bntImgEnable(document.form.btng_rowcopy, true);
        // bntImgEnable(document.form.btng_rowadd, true);
        // bntImgEnable(document.form.btng_gotoyardinquiry, true);
    } else {
        //            bntImgEnable(document.form.btn_save, false);
        // bntImgEnable(document.form.btn_new, false);
        // bntImgEnable(document.form.btng_rowcopy, false);
        // bntImgEnable(document.form.btng_rowadd, false);
        // bntImgEnable(document.form.btng_gotoyardinquiry, false);
    }
   
}

function getLocGrid(rowArray, row, col) {
    var sheetObj = sheetObjects[0];

    var colArray = rowArray[0];

    if (sheetObj.ColSaveName(col) == "port_cd") {
        sheetObj.CellValue2(row, "port_cd") = colArray[3];

    } else if (sheetObj.ColSaveName(col) == "hub_loc_cd") {
        sheetObj.CellValue2(row, "hub_loc_cd") = colArray[3];

    } else if (sheetObj.ColSaveName(col) == "loc_cd") {
        sheetObj.CellValue2(row, "loc_cd") = colArray[3];
    }
}

function getYardGrid(rowArray, row, col) {
    var sheetObj = sheetObjects[0];
    
    var colArray = rowArray[0];

    if (sheetObj.ColSaveName(col) == "yard_code") {
        sheetObj.CellValue2(row, "location_code") = colArray[3].substring(0, colArray[3].length - 2);
        sheetObj.CellValue2(row, "yard_code") = colArray[3];

    }

}

function getLaneGrid(rowArray, row, col) {
    var sheetObj = sheetObjects[0];

    var colArray = rowArray[0];

    if (sheetObj.ColSaveName(col) == "lane_code") {
        sheetObj.CellValue2(row, "lane_code") = colArray[3];
    }
}

function getCOM_ENS_051_1(rowArray) {
    //alertComPopupData(rowArray);

    var colArray = rowArray[0];
  
    document.all.in_port_cd.value = colArray[3];
 
}

function getPort(rowArray) {

    var colArray = rowArray[0];
   
    document.all.in_port_cd.value = colArray[3];

}

function getHub(rowArray) {


    var colArray = rowArray[0];
 
    document.all.in_hub_loc_cd.value = colArray[3];
 
}

function getLoc(rowArray) {
    var colArray = rowArray[0];
    document.all.in_loc_cd.value = colArray[3];
}


function sheet1_OnSearchEnd(sheetObj){
	
		for(var i=sheetObj.HeaderRows; i<(sheetObj.HeaderRows + sheetObj.RowCount); i++){
			if(sheetObj.CellValue(i,"cct_type") == "ETB" || sheetObj.CellValue(i,"cct_type")== "ETD"){
				sheetObj.CellEditable(i, "cct_hour") = true;
				sheetObj.CellEditable(i, "cct_day") = false; 
				//CCT Management by Yard for Export Booking.메뉴관련 변경
				//sheetObj.CellEditable(i, "cct_time") = false; 
				sheetObj.CellEditable(i, "cct_time") = true;
			} else if(sheetObj.CellValue(i,"cct_type") == "CMN" ){
	            sheetObj.CellComboItem(i, "cct_day", "OneDayBeforeETB", "")
//	            sheetObj.CellValue2(i, "cct_day") = 'OneDayBeforeETB';
				sheetObj.CellEditable(i, "cct_hour") = false; 
				sheetObj.CellEditable(i, "cct_day") = false; 
				sheetObj.CellEditable(i, "cct_time") = true; 
			} else {
				sheetObj.CellEditable(i, "cct_hour") = false; 
				sheetObj.CellEditable(i, "cct_day") = true; 
				sheetObj.CellEditable(i, "cct_time") = true;
			}
			//CCT Management by Yard for Export Booking.메뉴관련 추가
			if(sheetObj.CellValue(i,"cct_type") == "Day" ){
				sheetObj.CellEditable(i, "sat_flag") = false;
				sheetObj.CellEditable(i, "sun_flag") = false;
				sheetObj.CellEditable(i, "holi_flag") = false;
			}
			
			if(sheetObj.CellValue(i,"org_delete_flag") == 1 ){
				sheetObj.CellEditable(i, "delete_flag") = true;
				// 2010.04.06 delt_flg 유무에 맞추어서 체크박스 체크 표시
				sheetObj.CellValue2(i, "del_flag") = 1;
			}
			
			if(sheetObj.CellValue(i,"aply_rail_ctnt") == "RAIL" ){
	    		sheetObj.CellEditable(i, "ert_rcv_dt_free_dy") = false;
	    		sheetObj.CellEditable(i, "ert_rcv_dt_sat_flg") = false;
	    		sheetObj.CellEditable(i, "ert_rcv_dt_sun_flg") = false;
	    		sheetObj.CellEditable(i, "ert_rcv_dt_hol_flg") = false;
			}
			
		}
	
	
}

function sheet1_OnChange(sheetObj, Row, Col, Value) {
    validateData = Value;
    if (sheetObj.ColSaveName(Col) == "cct_type") {
        if (sheetObj.CellValue(Row, "cct_type") == "Day") {
            sheetObj.CellComboItem(Row, "cct_day", "", "")
            sheetObj.CellValue2(Row, "cct_hour") = '';
            sheetObj.CellEditable(Row, "cct_hour") = false;
            sheetObj.CellEditable(Row, "cct_day") = true;
            sheetObj.CellEditable(Row, "cct_time") = true;
          //CCT Management by Yard for Export Booking.메뉴관련 추가
            sheetObj.CellEditable(Row, "sat_flag") = false;
            sheetObj.CellEditable(Row, "sun_flag") = false;
            sheetObj.CellEditable(Row, "holi_flag") = false;
        }
        if (sheetObj.CellValue(Row, "cct_type") == "CMN") {
            sheetObj.CellComboItem(Row, "cct_day", "OneDayBeforeETB", "")
            sheetObj.CellValue2(Row, "cct_day") = 'OneDayBeforeETB';
            sheetObj.CellValue2(Row, "cct_hour") = '';
            sheetObj.CellEditable(Row, "cct_hour") = false;
            sheetObj.CellEditable(Row, "cct_day") = false;
            sheetObj.CellEditable(Row, "cct_time") = true;
          //CCT Management by Yard for Export Booking.메뉴관련 변경 추가
            sheetObj.CellEditable(Row, "sat_flag") = true;
            sheetObj.CellEditable(Row, "sun_flag") = true;
            sheetObj.CellEditable(Row, "holi_flag") = true;
        }
        if (sheetObj.CellValue(Row, "cct_type") == "ETB" || sheetObj.CellValue(Row, "cct_type") == "ETD") {
            sheetObj.CellComboItem(Row, "cct_day", "", "")
            sheetObj.CellValue2(Row, "cct_day") = '';
            sheetObj.CellValue2(Row, "cct_time") = '';
            sheetObj.CellEditable(Row, "cct_hour") = true;
            sheetObj.CellEditable(Row, "cct_day") = false;
            //CCT Management by Yard for Export Booking.메뉴관련 추가 및 변경
            //sheetObj.CellEditable(Row, "cct_time") = false;
            sheetObj.CellEditable(Row, "cct_time") = true;
            sheetObj.CellEditable(Row, "sat_flag") = true;
            sheetObj.CellEditable(Row, "sun_flag") = true;
            sheetObj.CellEditable(Row, "holi_flag") = true;
        }

    }

    if ((sheetObj.ColSaveName(Col) == "yard_code") && (sheetObj.ReadDataProperty(Row, Col, dpEditLen) == 7)) {
        doActionIBSheet(sheetObj, document.form, SEARCH04);
    } else if ((sheetObj.ColSaveName(Col) == "lane_code") && (sheetObj.ReadDataProperty(Row, Col, dpEditLen) == 3)) {
        doActionIBSheet(sheetObj, document.form, SEARCH07);
    }
    
    if((sheetObj.ColSaveName(Col) == "vvd_cd" && sheetObj.CellValue(Row, "lane_code")!= "" ) || 
    		(sheetObj.ColSaveName(Col) == "lane_code" && sheetObj.CellValue(Row, "vvd_cd")!= "" ) ){
    		var vslSlanCd = sheetObj.CellValue(Row,"lane_code");
    		var vvd = sheetObj.CellValue(Row, "vvd_cd");
    		if (vslSlanCd.length > 0 && vvd.length > 0 && vvd != 'ALL') {
    			var formObj = document.form;
    			formObj.f_cmd.value = SEARCH12;
    			var sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do", "uid=ESD_PRD_0024&lane_code=" + vslSlanCd + "&vvd=" + vvd+ "&" +PrdFQString(formObj));
    			sheetObj.LoadSearchXml(sXml,true, -1, true); 
    		    if( sheetObj.EtcData("comData1") == "N") {
    		    	ComShowCodeMessage('PRD90133');
    		    	if(sheetObj.ColSaveName(Col) == "vvd_cd"){
    		    		sheetObj.CellValue2(Row, "vvd_cd") = "";
    		    		sheetObj.SelectCell(Row, "vvd_cd");
    		    	} else {
    		    		sheetObj.CellValue2(Row, "lane_code") = "";
    		    		sheetObj.SelectCell(Row, "lane_code");
    		    	} 
    		    		
    		    	return;
    		    } 
    		}
    }
    
    if(sheetObj.ColSaveName(Col) == "aply_rail_ctnt"){
    	var aplyRailCtnt = sheetObj.CellValue(Row,"aply_rail_ctnt");
    	if(aplyRailCtnt  == "RAIL") {
    		sheetObj.CellValue2(Row, "ert_rcv_dt_free_dy") = "0";
    		sheetObj.CellValue2(Row, "ert_rcv_dt_sat_flg") = "N";
    		sheetObj.CellValue2(Row, "ert_rcv_dt_sun_flg") = "N";
    		sheetObj.CellValue2(Row, "ert_rcv_dt_hol_flg") = "N";
    		sheetObj.CellEditable(Row, "ert_rcv_dt_free_dy") = false;
    		sheetObj.CellEditable(Row, "ert_rcv_dt_sat_flg") = false;
    		sheetObj.CellEditable(Row, "ert_rcv_dt_sun_flg") = false;
    		sheetObj.CellEditable(Row, "ert_rcv_dt_hol_flg") = false;
    	}
    	if(aplyRailCtnt  == "LOCAL") {
    		sheetObj.CellValue2(Row, "ert_rcv_dt_free_dy") = "0";
    		sheetObj.CellValue2(Row, "ert_rcv_dt_sat_flg") = "N";
    		sheetObj.CellValue2(Row, "ert_rcv_dt_sun_flg") = "N";
    		sheetObj.CellValue2(Row, "ert_rcv_dt_hol_flg") = "N";
    		sheetObj.CellEditable(Row, "ert_rcv_dt_free_dy") = true;
    		sheetObj.CellEditable(Row, "ert_rcv_dt_sat_flg") = true;
    		sheetObj.CellEditable(Row, "ert_rcv_dt_sun_flg") = true;
    		sheetObj.CellEditable(Row, "ert_rcv_dt_hol_flg") = true;
    		
    	}
    }

}

/**
* del_flag 가 1인 행의 Act항목 클릭시 Del 체크해제, Act 체크
* @param sheetObj
* @param Row
* @param Col
* @return
*/
function sheet1_OnClick(sheetObj, Row, Col) {
	// 항목 Act 의 Col 값은 3
	if (Col == 3) {
		// DB에서 가져온 delete_flag가 Y 의 경우만  Act 항목 클릭시 이벤트 발생
		if(sheetObj.CellValue(Row, "org_delete_flag") == 1 ) {
			if ((sheetObj.CellValue(Row, "del_flag") == 1) && (sheetObj.CellValue(Row, "delete_flag") == 0)) {
				sheetObj.CellValue2(Row, "delete_flag") = 1;
				sheetObj.CellValue2(Row, "del_flag") = 0;
			} else if ((sheetObj.CellValue(Row, "del_flag") == 1) && (sheetObj.CellValue(Row, "delete_flag") == 1)){
				sheetObj.CellValue2(Row, "delete_flag") = 0;
			}
		}
	} else if (Col == 2) {    // 항목 Del 의 Col 값은 2
		
		if(sheetObj.CellValue(Row, "org_delete_flag") == 1 ) {
			if (sheetObj.CellValue(Row, "del_flag") == 0 && sheetObj.Cellvalue(Row, "delete_flag") == 1) {
				sheetObj.CellValue2(Row, "delete_flag") = 0;
			}
		}
	}
}

function validateLocation(loc, num) {
    if (loc.length < 1 && num == 1) {
        document.form.text.focus();
        return;
    }
    validateData = loc.toUpperCase();
    if (num == 1) {
        document.form.text.value = loc.toUpperCase();
    }
    doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
    if (retValidate < 1) {
        document.form.text.focus();

    } else {
        document.form.text2.focus();
    }

}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
    with (formObj) {
        //            if (!isNumber(iPage)) {
        //
        // return false;
        // }
    }
    return true;
}

    /**
     * Cargo Closing Time 의 CCT TYPE 에 따른 필수값 체크
     * CCT TYPE 가 ETB, EDT 의 경우 CCT HOUR 필수 입력
     * CCT TYPE 가 Day, CMN 의 경우 CCT DAY, CCT TIME 필수 입력
     * @param sheetObj
     * @return
     */
	function keyFieldCheck(sheetObj) {
		// cct_type, cct_hour, cct_day, cct_time
	    for(var i=sheetObj.HeaderRows; i<(sheetObj.HeaderRows + sheetObj.RowCount); i++){
	    	if ((sheetObj.CellValue(i,"cct_type") == "ETB" || sheetObj.CellValue(i,"cct_type")== "ETD") && sheetObj.CellValue(i, "cct_hour") == "") {
	    		ComShowMessage(ComGetMsg("PRD90112",(i-1),'CCT HOUR'));
		    	sheetObj.SelectCell(i, "cct_hour");
		        return false; 
	    	} else if ((sheetObj.CellValue(i,"cct_type") == "Day" || sheetObj.CellValue(i,"cct_type") == "CMN") && (sheetObj.CellValue(i, "cct_day") == "" || sheetObj.CellValue(i, "cct_time") == "")) {
	    		if (sheetObj.CellValue(i, "cct_day") == "") {
	    			ComShowMessage(ComGetMsg("PRD90112",(i-1),'CCT DAY'));
		            sheetObj.SelectCell(i, "cct_day");
	    		} else {
	    			ComShowMessage(ComGetMsg("PRD90112",(i-1),'CCT TIME'));
		            sheetObj.SelectCell(i, "cct_time");
	    		}
	    		return false;
	    	}
	    	// Save 버튼 클릭시 기존에 del_flag값이 1의 경우 ibflag 값에 'D'가 세팅 되어 있어서 초기화 시켜줌
	    	if(sheetObj.CellValue(i, "org_delete_flag") == 1 && sheetObj.CellValue(i, "del_flag") == 1) {
	    		sheetObj.RowStatus(i) = 'R';
	    	}
		}
		return true;
	}
	
    /**
     * Save 버튼 클릭후 저장유무 확인 팝업 창에서 취소를 클릭할 경우 기존 del_flag 값이 1인 항목에 체크표시
     * @param sheetObj
     * @return
     */
    function delCheck(sheetObj) {
    	for(var i=sheetObj.HeaderRows; i<(sheetObj.HeaderRows + sheetObj.RowCount); i++){
    		if((sheetObj.CellValue(i, "org_delete_flag") == 1) && sheetObj.CellValue(i, "delete_flag") == 0) {
    			sheetObj.RowStatus(i) = 'R';
        		sheetObj.CellValue2(i, "del_flag") = 1;
        		sheetObj.CellValue2(i, "delete_flag") = 0;
    		}
    	}
    }
    
    
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
        	ComShowMessage("Saved data successfully.");
        }  
    	
    }