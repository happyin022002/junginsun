// 공통전역변수 
/*
 * history
 * 2010.10.1 채창호 CHM-201006135-01 Pick Up & Return CY Export 화면 수정 요청
 * 2012.05.29 정선용 CHM-201217913-01	Pick Up CY for Export Booking 상, Cargo Type 추가에 따른 Logic 변경요청

*/

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
        case "btn_retrieve":
            doActionIBSheet(sheetObject1, formObject, IBSEARCH);
            break;

        case "btn_new":
            formObject.reset();
            sheetObject1.removeall();
            break;

        case "btn_save":
            doActionIBSheet(sheetObject1, formObject, IBSAVE);
            break;

        case "btn_downexcel":
            doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
            break;

//        case "btn_loadexcel":
//            doActionIBSheet(sheetObject1, formObject, IBLOADEXCEL);
//            break;

        case "btng_rowadd":
            doActionIBSheet(sheetObject1, formObject, IBINSERT);
            break;
		case "btn_PorDel":
			//PrdComPopup("location", document.form.por_del);
			selectPort(formObject, 'POL');
			break;
		case "btn_PolPod":
			//PrdComPopup("location", document.form.pol_pod);
			selectPort(formObject, 'POD');
			break;
		case "btn_Lane":
			//PrdComPopup("lane", document.form.lane_code);
			selectPort(formObject, 'LANE');
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

var portInd = '';
function selectPort(frm, pt){
	portInd = pt;
	var param = '';

	if(pt == 'POL') param = '?loc_cd='+frm.por_del.value;
	if(pt == 'POD') param = '?loc_cd='+frm.pol_pod.value;
	if(pt == 'LANE')param = '?lane_cd=' + frm.lane_code.value;
	if(pt == 'POL' || pt =='POD'){
		ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 770, 470, 'getCOM_ENS_051', '1,0,1,1,1,1,1,1,1,1,1,1', true);
	}else if(pt == 'LANE'){
		ComOpenPopup('/hanjin/COM_ENS_081.do' + param, 770, 470, 'getLane', '1,0,1,1,1,1,1,1,1,1,1,1', true);
	}
}
function getCOM_ENS_051(rArray) {
	
	var cArray  =  rArray [0];


	var frm = document.form;
	
	if(portInd == 'POL'){

		 frm.por_del.value = cArray[3];
	}
	if(portInd == 'POD'){
		 frm.pol_pod.value = cArray[3];
	}
}

function getLane(rowArray){
	var colArray = rowArray[0];
	document.all.lane_code.value = colArray[3];
	document.all.lane_code.focus();
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

	if(CRUD == "R") {
//		ComBtnDisable("btn_save");
//		ComEnableObject(document.getElementById("btn_save"), false);

	}
	
	//Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	axon_event.addListenerFormat('keypress',         'obj_keypress', 	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
	axon_event.addListener('keypress', 'PrdComKeyEnter' , 'por_del', 'pol_pod', 'lane_code');
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

            var HeadTitle1 = "NO.|STS|Del|POR/DEL|POL/POD|Lane|Bound|Cargo Type|Pick Up/Rtn CY|C.User|U.User|U.Date";
            var headCount = ComCountHeadTitle(HeadTitle1);

            // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false, false);

            // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);

            // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++, dtSeq,       40,     daCenter, true, "",            false,   "", dfNone,	    0,  true,   true);
            InitDataProperty(0, cnt++, dtStatus,    40,     daCenter, true, "ibflag",      false,   "", dfNone,     0,  true,   true);
            InitDataProperty(0, cnt++, dtCheckBox,  40,     daCenter, true, "del_flag",    false,   "", dfNone,     0,  true,   true);
            InitDataProperty(0, cnt++, dtPopupEdit, 110,    daCenter, true, "por_del",     true,    "", dfNone,     0,  false,  true, 5);
            InitDataProperty(0, cnt++, dtPopupEdit, 110,    daCenter, true, "pol_pod",     true,    "", dfNone,     0,  false,  true, 5);
            InitDataProperty(0, cnt++, dtPopupEdit, 110,    daCenter, true, "lane_code",   true,    "", dfNone,     0,  false,  true, 3);
            InitDataProperty(0, cnt++, dtCombo,     120,    daCenter, true, "bound_code",  true,    "", dfNone,	    0,  false,  true);
            InitDataProperty(0, cnt++, dtCombo,     110,    daCenter, true, "cargo_type",  true,    "", dfNone,     0,  false,  true);
            InitDataProperty(0, cnt++, dtPopupEdit, 110,    daCenter, true, "pickup_cy",   true,    "", dfNone,     0,  true,   true, 7, true);
            
            InitDataProperty(0, cnt++, dtPopupEdit, 100,    daCenter, true, "cre_usr_id",   false,    "", dfNone,     0,  false,   false);
            InitDataProperty(0, cnt++, dtPopupEdit, 100,    daCenter, true, "upd_usr_id",   false,    "", dfNone,     0,  false,   false);
            InitDataProperty(0, cnt++, dtPopupEdit, 100,    daCenter, true, "upd_dt",       false,    "", dfDateYmd,     0,  false,   false);
            
            InitDataCombo(0, "bound_code",  "ALL|Out|In",       "B|O|I",    "Out");
            InitDataCombo(0, "cargo_type",  "ALL|Dry|Reefer|D/G|F/R,O/T",   "AL|DR|RF|DG|FO", "Dry");
            //CountPosition = 0;
			InitDataValid(0, "por_del",   vtEngUpOther, "1234567890");
			InitDataValid(0, "pol_pod",   vtEngUpOther, "1234567890");
			InitDataValid(0, "lane_code", vtEngUpOther, "1234567890");
			InitDataValid(0, "pickup_cy", vtEngUpOther, "1234567890");
        }
        break;

    }
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	 sheetObj.ShowDebugMsg = false;
     switch (sAction) {
     case IBSEARCH: //조회
         if (validateForm(sheetObj, formObj, sAction)) {
             if (sheetObj.id == "sheet1") {
                 formObj.f_cmd.value = SEARCH;
                 sheetObj.DoSearch4Post("ESD_PRD_0070GS.do", PrdFQString(formObj));
             }
         }
         break;

     case IBSAVE: //저장
         if (validateForm(sheetObj, formObj, sAction)) {
             formObj.f_cmd.value = MULTI;
             sheetObj.DoSave("ESD_PRD_0070GS.do", PrdFQString(formObj));
         }
         break;

     case IBINSERT: // 입력
    	 var Row = sheetObj.DataInsert();
    	 sheetObj.CellValue2(Row, "lane_code") = "ALL";
//         sheetObj.CellValue2(Row, "bound_code") = "B";
         sheetObj.CellValue2(Row, "cargo_type") = "AL";

         break;

	 //Load Excel
//	 case IBLOADEXCEL:
//
//		 sheetObj.RemoveAll();
//		 sheetObj.LoadExcel();
		 
//		 var rtnLoad = sheetObj.LoadExcel(-1, 1, "", -1, -1, "", false,false,"");
//		
//		 if(!rtnLoad) {return;}  //취소
//		
//		 ComOpenWait(true,true);
//		 for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++){        
//			 //Sel Column Edit 설정
//			 sheetObj.CellEditable(i,"checkbox") = false;
//			
//			 //Volume Edit 설정  
//			 setEditableByVolumeType(sheetObj,i);	
//		 }
//		 //no match combo 설정 
//		 setNoMatchCombo(sheetObj);
//		 ComOpenWait(false,true);  
//		 break;         
         
     case IBDOWNEXCEL: //엑셀 다운로드
         sheetObj.Down2Excel(-1, false, false, true);
         break;

     } // end switch
}

function sheet1_OnChange(sheetObj, Row, Col, Value) {
    //check_data 파라미터값을 받아 디비에 있는 결과를  검사해서 값이  있으면 정상, 없으면 예외
    //TODO 로직 정리 noh
    var validation_flag = false;
    if ((sheetObj.ColSaveName(Col) == "por_del") && Value.length >= 5  ) {
         document.form.f_cmd.value = SEARCH02;
         validation_flag = true;
    }else if((sheetObj.ColSaveName(Col) == "pol_pod") && Value.length >= 5) {
        document.form.f_cmd.value = SEARCH02;
        validation_flag = true;
    }else if((sheetObj.ColSaveName(Col) == "lane_code") && Value.length >= 3) {
		if(sheetObj.CellValue(Row, Col)!="ALL"){
			document.form.f_cmd.value = SEARCH07;
			validation_flag = true;
		} 
        //return false;
    }else if((sheetObj.ColSaveName(Col) == "pickup_cy") && Value.length >= 7 ) {
        document.form.f_cmd.value = SEARCH05;
        validation_flag = true;
    }
    if(validation_flag){
		sheetObj.EtcData("rowCount") = "";
        var sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do", "uid=ESD_PRD_0070&check_data=" + Value + "&" + PrdFQString(document.form));
        sheetObj.LoadSearchXml(sXml, true, -1, true);
		var retCount = sheetObj.EtcData("rowCount");

        if (retCount == "") {
            sheetObj.CellValue2(sheetObj.SelectRow, sheetObj.ColSaveName(Col)) = "";
            sheetObj.SelectCell(Row, Col);
        }
    }
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
    if (!ComChkValid(formObj)){
        return false;        
    }

    with (formObj) {
        //if (!isNumber(formObj.iPage)) {
        //return false;
        // }
    }

    return true;
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

function sheet1_OnPopupClick(sheetObj, row, col) {
	var param ;
	var tml_cd ;

    if (sheetObj.ColSaveName(col) == "por_del") {
		//PrdComPopup("location",null , sheetObj, row, "por_del");
		param = '?loc_cd='+sheetObj.CellValue(row, col);
		ComOpenPopup('/hanjin/COM_ENS_051.do'+param,  770, 470, 'getLocGrid', '1,0,1,1,1,1,1,1,1,1,1,1',true,false,row,col);
    }else if (sheetObj.ColSaveName(col) == "pol_pod") {
		//PrdComPopup("location",null , sheetObj, row, "pol_pod");
		param = '?loc_cd='+sheetObj.CellValue(row, col);
		ComOpenPopup('/hanjin/COM_ENS_051.do'+param,  770, 470, 'getLocGrid', '1,0,1,1,1,1,1,1,1,1,1,1',true,false,row,col);
    }else if (sheetObj.ColSaveName(col) == "lane_code") {
		//PrdComPopup("lane",null , sheetObj, row, "lane_code");
		var lane_cd = ""
		if(sheetObj.CellValue(row, col)!="ALL"){
			lane_cd = sheetObj.CellValue(row, col);
		} 
			
        param = '?&lane_cd='+lane_cd;
        ComOpenPopup('/hanjin/COM_ENS_081.do' + param, 770, 470, 'getPop2Grid', "1,0,1,1,1,1,1,1,1,1,1,1", true,true, row, col);
    }else if (sheetObj.ColSaveName(col) == "pickup_cy") {
		//PrdComPopup("yard",null , sheetObj, row, "pickup_cy");
		tml_cd = sheetObj.CellValue(row, col);
        param = '?&node_cd='+tml_cd;
		  
        ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 770, 470, 'getPop2Grid', "1,0,1,1,1,1,1,1,1,1,1,1", true,true,row, col);
    
    }

}

function getLocGrid(rowArray, row, col) {

    var sheetObj = sheetObjects[0];
    
	var colArray = rowArray[0];
	//sheetObj.CellValue2(row, col) = colArray[3];
	if (sheetObj.ColSaveName(col) == "por_del")
	{
    	sheetObj.CellValue2(row, "por_del") = colArray[3];
    	
	} else if  (sheetObj.ColSaveName(col) == "pol_pod")
	{
    	sheetObj.CellValue2(row, "pol_pod") = colArray[3];
    	
	} else if(sheetObj.ColSaveName(col) == "pickup_cy" )
	{
		sheetObj.CellValue2(row, "pickup_cy") = colArray[3];
	}
}

function getPop2Grid(rowArray, row, col) {
    var sheetObj = sheetObjects[0];
	var colArray = rowArray[0];
//	alertComPopupData(rowArray);
	
	//sheetObj.CellValue2(row, col) = colArray[3];
    if (sheetObj.ColSaveName(col) == "lane_code")
	{
    	sheetObj.CellValue2(row, "lane_code") = colArray[3];
	} else if (sheetObj.ColSaveName(col) == "pickup_cy")
	{
    	sheetObj.CellValue2(row, "pickup_cy") = colArray[3];
	}
	// POP UP에서 가져왔을때도  port code 에 대한 validation
	sheet1_OnChange(sheetObj,row,col,colArray[3])
}
