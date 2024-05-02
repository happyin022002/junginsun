// 공통전역변수 

var tabObjects = new Array();
var tabCnt = 0;
var beforetab1 = 1;
var beforetab2 = 1

var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    var sheetObject1 = sheetObjects[0];

    /** **************************************************** */
    var formObject = document.form;
    try {
        var srcName = window.event.srcElement.getAttribute("name");
        switch (srcName) {

        case "btn_Retrieve":
            doActionIBSheet(sheetObject1, formObject, IBSEARCH);
            break;

        case "btn_New":
            formObject.reset();
            sheetObject1.removeall();
            break;

        case "btn_Save":
            doActionIBSheet(sheetObject1, formObject, IBSAVE);
            break;
            
        case "btn_DownExcel":
            doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
            break;

        case "btn_RowAdd":
            doActionIBSheet(sheetObject1, formObject, IBINSERT);
            break;
            
        case "btn_RowCopy":
            doActionIBSheet(sheetObject1, formObject, IBCOPYROW);
            break;

        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            alert(ComGetMsg('COM12111'));
        } else {
            ComShowMessage(e);
        }
    }
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
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setTabObject(tab_obj) {
    tabObjects[tabCnt++] = tab_obj;
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

        //doActionIBSheet(sheetObjects[i], document.form, IBSEARCH);
    }

    for (k = 0; k < tabObjects.length; k++) {
        initTab(tabObjects[k], k + 1);
    }
    
    //권한부여
	if(CRUD == "R") {
		ComBtnDisable("btn_save");
//		ComEnableObject(document.getElementById("btn_save"), false);

	}    
    
	//Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	axon_event.addListenerFormat('keypress',         'obj_keypress', 	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
	axon_event.addListener('keypress', 'PrdComKeyEnter' , 'pod_code', 'hub_code', 'lane_code', 'group_code');
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
    var cnt = 0;
    switch (sheetObj.id) {
    case "sheet1": //sheet1 init
        with (sheetObj) {

            // 높이 설정
            style.height = 405;

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
            InitRowInfo(1, 1, 15, 100);

            var HeadTitle1 = "NO.|Status|Del|POD|HUB|LANE|Stowage|GROUP|C. User|C. Date|U. User|U. Date";
            var headCount = ComCountHeadTitle(HeadTitle1);

            // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false, false);

            // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);

            // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++, dtSeq,       50,     daCenter, true, "seq",          false, "", dfNone,        0, true,  true);
            InitDataProperty(0, cnt++, dtStatus,    50,     daCenter, true, "ibflag",       false, "", dfNone,        0, true,  true);
            InitDataProperty(0, cnt++, dtCheckBox,  50,     daCenter, true, "del_flag",     false, "", dfNone,        0, true,  true);
            InitDataProperty(0, cnt++, dtData,      80,     daCenter, true, "pod_code",     false, "", dfNone,        0, false, true, 5, false);
            InitDataProperty(0, cnt++, dtData,      80,     daCenter, true, "hub_code",     false, "", dfNone,        0, false, true, 5, false);
            InitDataProperty(0, cnt++, dtComboEdit, 80,     daCenter, true, "lane_code",    false, "", dfNone,        0, false, true, 3);
            InitDataProperty(0, cnt++, dtData,      80,     daCenter, true, "stwg_cd",   false, "", dfNone,        0, false, true, 4, false);            
            InitDataProperty(0, cnt++, dtData,      80,     daCenter, true, "group_code",   false, "", dfNone,        0, false, true, 3, true);
            InitDataProperty(0, cnt++, dtData,      120,    daCenter, true, "c_user_id",    false, "", dfNone,        0, false, false);
            InitDataProperty(0, cnt++, dtData,      120,    daCenter, true, "c_date",       false, "", dfDateYmd,     0, false, false);
            InitDataProperty(0, cnt++, dtData,      120,    daCenter, true, "u_user_id",    false, "", dfNone,        0, false, false);
            InitDataProperty(0, cnt++, dtData,      120,    daCenter, true, "u_date",       false, "", dfDateYmd,     0, false, false);

            //CountPosition = 0;
			InitComboNoMatchText(true);

			InitDataValid(0, "pod_code", vtEngUpOther, "1234567890");
			InitDataValid(0, "hub_code", vtEngUpOther, "1234567890");
			InitDataValid(0, "group_code", vtEngUpOther, "1234567890");

        }
        break;

    }
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg = false;
    switch (sAction) {
    case IBSEARCH: //조회
        if (validateForm(sheetObj, formObj, sAction)) {
            if (sheetObj.id == "sheet1") {
                formObj.f_cmd.value = SEARCH;
                sheetObj.DoSearch4Post("ESD_PRD_0071GS.do", PrdFQString(formObj));
            }
        }
        break;

    case IBSAVE: //저장
        if (validateForm(sheetObj, formObj, sAction)) {
            formObj.f_cmd.value = MULTI;
            sheetObj.DoSave("ESD_PRD_0071GS.do", PrdFQString(formObj));
        }
        break;
        
    case IBDOWNEXCEL: //엑셀 다운로드
        sheetObj.SpeedDown2Excel(-1, false, false);
        break;
        
    case IBINSERT: // 입력
        sheetObj.DataInsert();
        break;
        
    case IBCOPYROW: // 입력
        sheetObj.DataCopy();
        sheetObj.CellValue2(sheetObj.SelectRow, 3) = "";
        sheetObj.SelectCell(sheetObj.SelectRow, 3);
        //sheet1_OnChange(sheetObj, sheetObj.SelectRow, 3, sheetObj.CellValue(sheetObj.SelectRow, 3) );
        break;
    }
}

function sheet1_OnChange(sheetObj, row, col, value) {
	var sXml ;
    // row add, copy 된것 삭제 처리
    if(col == 2 ){
        if(sheetObj.RowStatus(row) == "I"){
            sheetObj.RowStatus(row) = "D";
        }
        return;
    }

	// add-row 후 pod_code 컬럼에 5자 모두 입력하면 디비에서 lane 코드 목록 가져와 콤보 박스에 입력한다.
	// 5자가 아니면 ALL 만 선택할 수 있다.
	var f = document.form;
    if (sheetObj.ColSaveName(col) == "pod_code") {
		if(value.length < 5){
			sheetObj.CellComboItem(row, "lane_code", "ALL", "ALL");
            sheetObj.SelectCell(row, col);
			return;
		}

//		if("US,CA,MX".indexOf(value.substring(0, 2),0) == -1){  // 201509 [CHM-201538143] 미주 외 국가에도 Block Stowage Code 등록 가능하도록 로직 변경 
//			ComShowMessage(ComGetMsg('PRD90109'));
//            sheetObj.CellValue2(row, col) = "";
//            sheetObj.SelectCell(row, col);
//			return;
//		}

		// POD validation
		f.f_cmd.value = SEARCH02;
		sheetObj.EtcData("rowCount") = "";
        sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do", "uid=ESD_PRD_0070&check_data=" + value + "&" + PrdFQString(f));
        sheetObj.LoadSearchXml(sXml, true, -1, true);
		var retCount = sheetObj.EtcData("rowCount");

        if (retCount == "") {
            sheetObj.CellValue2(row, col) = "";
            sheetObj.SelectCell(row, col);
			sheetObj.CellComboItem(row, "lane_code", "ALL", "ALL");
			return;
        }


		// lane code 가져오기
		f.f_cmd.value = SEARCH01;
        sXml = sheetObj.GetSaveXml("ESD_PRD_0071GS.do", "uid=ESD_PRD_0071&pod_code=" + value + "&" + PrdFQString(f));
		var str = PrdComEtcDataToComboString(sXml);
		str = "ALL|"+str;
		sheetObj.CellComboItem(row, "lane_code", str, str);

	}else if (sheetObj.ColSaveName(col) == "hub_code") {
		f.f_cmd.value = SEARCH02;
		sheetObj.EtcData("rowCount") = "";
        sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do", "uid=ESD_PRD_0070&check_data=" + value + "&" + PrdFQString(f));
        sheetObj.LoadSearchXml(sXml, true, -1, true);
		var retCount = sheetObj.EtcData("rowCount");

        if (retCount == "") {
            sheetObj.CellValue2(row, col) = "";
            sheetObj.SelectCell(row, col);
        }
	}

	// pod, hub, group 값으로 데이터베이스에 값이 있는지 삭제 안되어 있는 검사
	if(sheetObj.CellValue(row,"pod_code").length == 5 &&
		sheetObj.CellValue(row,"hub_code").length == 5 &&
		sheetObj.CellValue(row,"group_code").length == 3 &&
		sheetObj.CellValue(row,"stwg_cd").length == 4   ){

		sheetObj.EtcData("rowCount") = "";
		// del_flg, group_code를 공백으로 보내야 검색할 때 del_flg, group_code 는 빼고 검색한다.
		sXml = sheetObj.GetSaveXml("ESD_PRD_0071GS.do", "f_cmd="+SEARCH+"&del_flag=N&group_code=&"+sheetObj.RowSaveStr(row));
		sheetObj.LoadSearchXml(sXml, true, -1, true);

		if(sheetObj.EtcData("rowCount") > 0 ){
			ComShowMessage(ComGetMsg('COM131302','Data'));
			sheetObj.CellValue2(row, col) = "";
			sheetObj.SelectCell(row, col);
		}
	}

}

function sheet1_OnPopupClick(sheetObj, row, col) {
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
    with (formObj) {
        //if (!isNumber(formObj.iPage)) {
        //    return false;
        //}
    }
    return true;
}

 function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
     // delete 채크 박스 가 채크(삭제)되어 있으면 변경 불가능하게 속성 설정
     var rowCount = sheetObj.RowCount + 1;
     for(i=1; i<rowCount; i++){
         if(sheetObj.CellSearchValue(i, "del_flag") == 1){
             sheetObj.CellEditable(i, "del_flag") = false;         
         }
     }
}

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function tab2_OnChange(tabObj, nItem) {
    var objs = document.all.item("tabLayer2");

    objs[nItem].style.display = "Inline";
    objs[beforetab2].style.display = "none";

    // --------------- 요기가 중요 --------------------------//
    objs[beforetab2].style.zIndex = objs[nItem].style.zIndex - 1;
    // ------------------------------------------------------//
    beforetab2 = nItem;
}
