/*=========================================================
*copyright(c) 2006 cyberlogitec
*@filename : ESD_PRD_0002.jsp
*@filetitle : yardmanage
*open issues :
*change history :
*@lastmodifydate : 2006-10-24
*@lastmodifier : kimyoungchul
*@lastversion : 1.0 
* 2006-10-24 kimyoungchul
* 1.0 최초 생성
* 2009-07-13 alps framework 구조 변경 noh seung bae
=========================================================*/

var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var nodeCd = "";
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    var sheetObject = sheetObjects[0];
    var sheetObject1 = sheetObjects[1];
    /** **************************************************** */
    var formObject = document.form;
    var param ;
    try {
        var srcName = window.event.srcElement.getAttribute("name");
        switch (srcName) {

        case "btn_retrieve":
            doActionIBSheet(sheetObject, formObject, IBSEARCH);
            break;

        case "btn_new":
            sheetObject.RemoveAll();
            var opts = document.form.select2;
            for(var i=opts.length-1; i>0 ; i--) {
            	opts[i].parentNode.removeChild(opts[i]);
            }
            
            formObject.reset();
            break;
        case "loc_btn":
            param = '?classId=' + "COM_ENS_051" + '&loc_cd=' + formObject.location_code_top.value;
            ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 770, 470, 'getLoc', "1,0,1,1,1,1,1,1,1,1,1,1", true);
            break;
        case "node_btn":
            param = '?classId=' + "COM_ENS_061" + '&node_cd=' + formObject.node_code_top.value + "&pop_mode=1";
            ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 770, 470, 'getNode', "1,0,1,1,1,1,1,1,1,1,1,1", true);
            break;

        case "btn_cnt":
            selectCountry('cnt');
            break;

        case "btng_constraint":
            doConstraint(sheetObject);
            break;
        case "btng_yardcct":
            doYardCct(sheetObject);
            break;
        case "btng_dwell":
            var formObj = document.form;
            var param = '?search_nod_cd=' + formObj.yard_code.value + "&mode=pop&pgmNo=ESD_PRD_0008";
          
            var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1";
            ComOpenPopup("/hanjin/ESD_PRD_0008.do" + param, 700, 400, '', dispaly, true);
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

function getLoc(rowArray) {
    //alertComPopupData('3:'+rowArray);

    var colArray = rowArray[0];

    document.all.location_code_top.value = colArray[3];

}

function getNode(rowArray) {

    var colArray = rowArray[0];
    document.all.node_code_top.value = colArray[3];
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
    //ComShowMessage(nodeCd );
    for (i = 0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    for (k = 0; k < tabObjects.length; k++) {
        initTab(tabObjects[k], k + 1);
    }
    if (nodeCd != "") {
        formObj = document.form;
        formObj.f_cmd.value = SEARCH;
        sheetObjects[0].DoSearch4Post("ESD_PRD_0002GS.do", PrdFQString(formObj));
    }

	//Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	axon_event.addListenerFormat('keypress',         'obj_keypress', 	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
	axon_event.addListener('keypress', 'PrdComKeyEnter' , 'country_code', 'region_code', 'location_code_top', 'node_code_top');
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

    var cnt = 0;
    switch (sheetNo) {
    case 1: //IBSheet1 init
        with (sheetObj) {
            //전체 너비 설정
            style.height = 140;
            SheetWidth = mainTable.clientWidth;

            // Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "")
                InitHostInfo(location.hostname, location.port, page_path);

            // 전체Merge 종류 [선택, Default msNone]
            MergeSheet = msNone;

            // 전체Edit 허용 여부 [선택, Default false]
            Editable = false;

            // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(1, 1, 9, 100);

            // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(6, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false, false)

            var HeadTitle = "No.|Type|Node Code|Node Name|Node Type|Remarks";

            // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, false);

            // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++, dtSeq,  30,  daCenter, false, "seq",         false, "", dfNone,     0, true, true);
            InitDataProperty(0, cnt++, dtData, 80,  daCenter, false, "node_div",    false, "", dfNone,     0, true, true);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "node_code",   false, "", dfNone,     0, true, true);
            InitDataProperty(0, cnt++, dtData, 270, daLeft,   false, "node_name",   false, "", dfNone,     0, true, true);
            InitDataProperty(0, cnt++, dtData, 150, daCenter, false, "node_type",   false, "", dfNone,     0, true, true);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "node_remark", false, "", dfNone,     0, true, true);

			InitDataValid(0, "node_code", vtEngUpOther, "1234567890");

        }
        break;

    case 2: //IBSheet2 init
        with (sheetObj) {
            //전체 너비 설정
            style.height = 80;
            SheetWidth = mainTable.clientWidth;

            // Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "")
                InitHostInfo(location.hostname, location.port, page_path);

            // 전체Merge 종류 [선택, Default msNone]
            MergeSheet = msNone;

            // 전체Edit 허용 여부 [선택, Default false]
            Editable = false;

            // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(1, 1, 9, 100);

            // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(3, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false, false)

            var HeadTitle = "seq|Postal Code|District";

            // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, false);

            // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++, dtHidden, 30,  daCenter, false, "seq", false, "", dfNone, 0, true, true);
            InitDataProperty(0, cnt++, dtData,   100, daCenter, false, "",    false, "", dfNone, 0, true, true);
            InitDataProperty(0, cnt++, dtData,   100, daCenter, false, "",    false, "", dfNone, 0, true, true);

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
        clear_form();
        if (formObj.country_code.value == '') {
            ComShowMessage(ComGetMsg('PRD90007'));
            return;
        }
        if (formObj.radio1[0].checked)
            formObj.node_type_div.value = '';
        if (formObj.radio1[1].checked)
            formObj.node_type_div.value = 'Y';
        if (formObj.radio1[2].checked)
            formObj.node_type_div.value = 'Z';

        if (validateForm(sheetObj, formObj, sAction))
            formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch4Post("ESD_PRD_0002GS.do", PrdFQString(formObj));
        break;

    case IBSAVE: //저장
        if (validateForm(sheetObj, formObj, sAction))
            // formObj.f_cmd.value = MULTI;
            // sheetObj.DoAllSave("ESD_PRD_0001GS.do", PrdFQString(formObj));
            break;

    case IBINSERT: // 입력
        if (validateForm(sheetObj, formObj, sAction))
            sheetObj.DataInsert();
        break;

    case IBCOPYROW: //행 복사
        sheetObj.DataCopy();
        break;

    case IBDOWNEXCEL: //엑셀 다운로드
        sheetObj.Down2Excel(-1, false, false, true);
        break;

    case IBLOADEXCEL: //엑셀 업로드
        sheetObj.LoadExcel();
        break;

    case SEARCH02:
        formObj.f_cmd.value = SEARCH02;
   
        uid = "ESD_PRD_0002";
        sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do", "uid=" + uid + "&chkData=" + validateData + "&" + PrdFQString(formObj));

        sheetObj.LoadSearchXml(sXml, true, -1, true);
        retValidate = sheetObjects[0].EtcData("rowCount");
        break;

    case SEARCH05:
//        alert("command5");
        formObj.f_cmd.value = SEARCH05;
        uid = "ESD_PRD_0002";
        sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do", "uid=" + uid + "&chkData=" + validateData + "&" + PrdFQString(formObj));

        sheetObj.LoadSearchXml(sXml, true, -1, true);
        retValidate = sheetObjects[0].EtcData("rowCount");

        break;
    }
}
/**
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setTabObject(tab_obj) {

    tabObjects[tabCnt++] = tab_obj;

}

/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 */
function initTab(tabObj, tabNo) {
    switch (tabNo) {
    case 1:
        with (tabObj) {
            var cnt = 0;
            InsertTab(cnt++, "Yard", -1);
            // InsertTab( cnt++, "Lease Yars" , -1 );
            InsertTab(cnt++, "Zone", -1);

        }
        break;

    }
}

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj, nItem) {
    var objs = document.all.item("tabLayer");

    objs[nItem].style.display = "Inline";
    objs[beforetab].style.display = "none";
    objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;

    beforetab = nItem;

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

function sheet1_OnDblClick(sheetObj, row, col, value) {
    clear_form();
    var node_div = (sheetObj.cellValue(row, "node_div") == 'Zone') ? 'Z' : 'Y';
    var node_cd = sheetObj.cellValue(row, "node_code");
    if (node_div == 'Z') {
        //tab1_OnChange(tabObjects[0] , 1);
        tabObjects[0].SelectedIndex = 1;
    } else if (node_div == 'Y') {
        //tab1_OnChange(tabObjects[0] , 0);
        tabObjects[0].SelectedIndex = 0;
    }

 
    if (node_div == 'Y') { //Yard
        document.form.f_cmd.value = SEARCH01;
        sheetObjects[1].ShowDebugMsg = false;
       
        sheetObjects[1].DoSearch4Post("ESD_PRD_0002GS.do?node_type_div=" + node_div + "&node_code=" + node_cd, PrdFQString(document.form));
        ComEtcDataToForm(document.form, sheetObjects[1]);
        var f = document.form;
        sheetObjects[1].EtcData("service_type_marinet") == "Y" ? f.service_type_marinet.checked = true : f.service_type_marinet.checked = false;
        sheetObjects[1].EtcData("service_type_barget") == "Y" ? f.service_type_barget.checked = true : f.service_type_barget.checked = false;
        sheetObjects[1].EtcData("service_type_cy") == "Y" ? f.service_type_cy.checked = true : f.service_type_cy.checked = false;
        sheetObjects[1].EtcData("service_type_cfs") == "Y" ? f.service_type_cfs.checked = true : f.service_type_cfs.checked = false;
        sheetObjects[1].EtcData("service_type_railramp") == "Y" ? f.service_type_railramp.checked = true : f.service_type_railramp.checked = false;
        sheetObjects[1].EtcData("service_type_pseudoy") == "Y" ? f.service_type_pseudoy.checked = true : f.service_type_pseudoy.checked = false;

    } else if (node_div == 'Z') { // Zone
        document.form.f_cmd.value = SEARCH02;
        sheetObjects[1].ShowDebugMsg = false;
       
        sheetObjects[1].DoSearch4Post("ESD_PRD_0002GS.do?node_type_div=" + node_div + "&node_code=" + node_cd, PrdFQString(document.form));
        ComEtcDataToForm(document.form, sheetObjects[1]);
    } else {
        ComShowMessage(ComGetMsg('PRD90110',node_div));
    }

}

//////////////////////////////////////////////////////////////

function changeContinent() {
    var list = document.form.select1;
    var c_code = list.options[list.selectedIndex].value;
    if (c_code != '0') {
        document.form.f_cmd.value = SEARCH19;
        document.form.conti_code.value = c_code;
        document.form.subconti_code.value = '';
        document.form.action = "ESD_PRD_COM_0002.do";
        document.form.target = "HiddenFrame";
        document.form.submit();
    } else {
        document.form.conti_code.value = "";
        document.form.subconti_code.value = "";
        var opts = document.form.select2;
        for(var i=opts.length-1; i>0 ; i--) {
        	opts[i].parentNode.removeChild(opts[i]);
        }
        
    }
}

function changeSubContinent() {
    var list = document.form.select2;
    var c_code = list.options[list.selectedIndex].value;
    if (c_code != '0') {
        document.form.f_cmd.value = '101';
        document.form.subconti_code.value = c_code;
    } else {
        document.form.subconti_code.value = "";
        
    }
}

function clear_form() {

    nodeForm = document.form;

    // yard
    nodeForm.yard_code.value = '';
    nodeForm.location_code.value = '';
    nodeForm.yard_name.value = '';
    // nodeForm.yd_rep_hub_loc_cd.value = '';
    nodeForm.node_type.value = '';
    nodeForm.hub_node.value = '';
    nodeForm.service_type_marinet.checked = '';
    nodeForm.service_type_barget.checked = '';
    nodeForm.service_type_cy.checked = '';
    nodeForm.service_type_cfs.checked = '';
    nodeForm.service_type_railramp.checked = '';
    nodeForm.service_type_pseudoy.checked = '';

    // yard contact point
    nodeForm.person.value = '';
    nodeForm.email.value = '';
    nodeForm.tel.value = '';
    // nodeForm.yd_web_site.value = '';
    nodeForm.fax.value = '';
    nodeForm.postal_code.value = '';
    nodeForm.yard_address.value = '';

    // yard service info
    nodeForm.gate_week_open.value = '';
    nodeForm.gate_week_close.value = '';
    nodeForm.gate_sat_open.value = '';
    nodeForm.gate_sat_close.value = '';
    nodeForm.gate_sun_open.value = '';
    nodeForm.gate_sun_close.value = '';
    nodeForm.gate_holiday_open.value = '';
    nodeForm.gate_holiday_close.value = '';
    nodeForm.ob_average_dwell_r.value = '';
    nodeForm.ob_average_dwell_d.value = '';
    nodeForm.ib_average_dwell_r.value = '';
    nodeForm.ib_average_dwell_d.value = '';
//    nodeForm.ob_minimum_dwell_r.value = '';
//    nodeForm.ob_minimum_dwell_d.value = '';    
//    nodeForm.ib_minimum_dwell_r.value = '';
//    nodeForm.ib_minimum_dwell_d.value = '';
    nodeForm.cop_ob_dry_avg_dwll_hrs.value = '';
    nodeForm.cop_ib_dry_avg_dwll_hrs.value = '';    
    nodeForm.cop_ob_rf_avg_dwll_hrs.value = '';
    nodeForm.cop_ib_rf_avg_dwll_hrs.value = '';
    nodeForm.ob_average_dwell_d.value = '';
    nodeForm.free_time.value = '';

    // yard yard operator
    nodeForm.yard_operator1.value = '';
    nodeForm.operator1_name.value = '';
    nodeForm.yard_operator2.value = '';
    nodeForm.operator2_name.value = '';
    nodeForm.yard_operator3.value = '';
    nodeForm.operator3_name.value = '';

    // yard additional info
    nodeForm.office_code.value = '';
    nodeForm.dem_ib_collection.value = '';
    nodeForm.dem_ob_collection.value = '';
    nodeForm.yard_ownership.value = '';
    nodeForm.bonded_yard.value = '';
    nodeForm.c_tpat.value = '';
    nodeForm.yard_on_off.value = '';

    // zone location
    nodeForm.location_code.value = '';
    nodeForm.location_name.value = '';

    // zone zone
    nodeForm.zone_code.value = '';
    nodeForm.zone_name.value = '';
    nodeForm.control_office.value = '';
    nodeForm.cargo_handling_time.value = '';

    // zone representative
    nodeForm.representative_code.value = '';
    nodeForm.representative_name.value = '';
    nodeForm.distance.value = '';
}

function chkCountry(obj) {

    var formObj = document.form;
    var inVal = event.srcElement.value;
    if (inVal.length > 2) {
        formObj.country_code.value = inVal.substring(0, 2);
    }
}

function doConstraint(sheetObj) {

    var formObj = document.form;
    var param = '?node_cd=' + formObj.yard_code.value + "&mode=pop&pgmNo=ESD_PRD_0024";
  
    var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1";
    ComOpenPopup("/hanjin/ESD_PRD_0024.do" + param, 1020, 600, '', dispaly, true);
    
}

function doYardCct(sheetObject) {
    var formObj = document.form;
    
    var param = '?loc_cd=' + document.getElementsByName("location_code")[0].value + "&mode=pop&pgmNo=ESD_PRD_0036";
    winObject = window.open("/hanjin/ESD_PRD_0036.do" + param, "한진해운PI", "height=450, width=1020, top=0");
}
