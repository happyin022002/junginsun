/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0926.js
 *@FileTitle : C/M Data Check Set-up
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.23
 *@LastModifier : 이수빈
 *@LastVersion : 1.0
 * 2009.04.23 이수빈
 * 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author 한진해운
 */

/**
 * @extends 
 * @class C/M Data Check Set-up : C/M Data Check Set-up 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0926() {
    this.processButtonClick		= tprocessButtonClick;
    this.setSheetObject 		= setSheetObject;
    this.loadPage 				= loadPage;
    this.initSheet 				= initSheet;
    this.doActionIBSheet 		= doActionIBSheet;
    this.setTabObject 			= setTabObject;
    this.validateForm 			= validateForm;
}

/* 개발자 작업    */


//공통전역변수
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1; 

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

//폼에 있는 input element 를 모두 가져온다
var j = k = 0;
var hideArr = new Array();
var chkArr = new Array();
var frmChild = document.getElementsByTagName("input");
for(var i=0; i<frmChild.length; i++){
	if(frmChild[i].type == "hidden"){
		hideArr[j++] = frmChild[i];
	}
	if(frmChild[i].type == "checkbox"){
		chkArr[k++] = frmChild[i];
	}
}

//체크된 체크박스 카운트
var checkCnt = 0;

// 본사 및 지역본부 소속 Office Code 정의
var availableOfc = new Array();
availableOfc[0] = "HAMU";
availableOfc[1] = "NYCN";
availableOfc[2] = "SHAA";
availableOfc[3] = "SINW";
availableOfc[4] = "SELH";

//삭제 가능 여부 구분값
var frobVal;
var retrieveFlag = false;
var deleteFlag = false;

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    var sheetObject = sheetObjects[0];
    /*******************************************************/
    var formObject = document.form;

    try {
        var srcName = window.event.srcElement.getAttribute("name");

        switch(srcName) {
        case "btn_Retrieve":
            doActionIBSheet(sheetObject, formObject, IBSEARCH);
            break;
            
        case "btn_New":
            doActionIBSheet(sheetObject, formObject, IBINSERT);
            
        	comboObjects[0].Index = "-1";
        	comboObjects[1].Index = "-1";

        	var frobs = formObject.elements("frob_flg");
        	for(i = 0; i < frobs.length; i++ ) {
        		if(frobs[i].value == "Y") {
        			frobs[i].checked = true;
        		}else{
        			frobs[i].checked = false;
        		}
        	}
            break; 
            
        case "btn_Save":
            doActionIBSheet(sheetObject, formObject, IBSAVE); 
            break; 
            
        case "btn_Delete":
            doActionIBSheet(sheetObject, formObject, IBDELETE); 
            break; 
                        
        } // end switch
    }catch(e) {
        if( e == "[object Error]") {
            ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e);
        }
    }
}


/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
    for(var k=0;k<tabObjects.length;k++){
        initTab(tabObjects[k],k+1);
    }
	for(i = 0; i < comboObjects.length; i++ ) {
		initCombo(comboObjects[i], i+1);
	}
    for (i = 0; i < sheetObjects.length; i++) {
        // khlee-시작 환경 설정 함수 이름 변경
        ComConfigSheet(sheetObjects[i]);

        initSheet(sheetObjects[i], i + 1);
        // khlee-마지막 환경 설정 함수 추가
        ComEndConfigSheet(sheetObjects[i]);
    }

	toggleButtons("INIT");
    if(document.form.menuCode.value == "R") {
		for(var i=0; i<frmChild.length; i++){
			if(frmChild[i].type == "checkbox"){
				frmChild[i].disabled = true;
			}
    	}
		ComBtnEnable("btn_Retrieve");
    }

	//화면에서 필요한 이벤트
	axon_event.addListenerForm("click","obj_click", document.form);
	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    
    doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
}

/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setTabObject(tab_obj){
    tabObjects[tabCnt++] = tab_obj;
}

/**
 * 콤보 Object를 comboObjects 배열에 등록
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj; 
}


/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 */
function initTab(tabObj , tabNo) {
    with (tabObj) {
        var cnt  = 0 ;
        InsertTab( cnt++ , "Import to" , -1 );
        InsertTab( cnt++ , "Export from" , -1 );
    }
}

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj , tabIndex)
{
    if (beforetab != tabIndex) {
        var objs = document.all.item("tabLayer");
        
        objs[tabIndex].style.display = "inline";
        objs[beforetab].style.display = "none";
    }
        
    beforetab = tabIndex;
}


/**
 * Combo Object 초기화
 * @param comboObj
 * @param comNo
 * @return
 */
function initCombo(comboObj, comboNo) {
    switch(comboObj.id) {
        case "cnt_cd":
            var i=0;
            with(comboObj) {
            	//BackColor = "cyan";
            	DropHeight = 200;
            	MultiSelect = false;
            	MaxSelect = 1;
            }
            break;
        
        case "loc_cd":
            var i=0;
            with(comboObj) {
            	//UseEdit = true;
            	//BackColor = "cyan";
            	DropHeight = 200;
            	MultiSelect = false;
            	MaxSelect = 1;
            }
            break;
    }
}

/**
 * cnt_cd 콤보 Change 이벤트 처리
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cnt_cd_OnChange(comboObj, value, text) {
	var str;
	for(var i=0; i<frmChild.length; i++){
		if(frmChild[i].type == "hidden"){
			var prefix = frmChild[i].name.substring(0,3);
			if(prefix == "exp" || prefix == "imp"){
				str = frmChild[i].name.substring(7,frmChild[i].name.length);
	        	if(str == "cnt_cd"){
	        		frmChild[i].value = value;
	        	}
			}
		}
    }
	retrieveFlag = false;
	deleteFlag = false;

	initCheckbox();
	ComBtnEnable("btn_Retrieve");
	toggleButtons("READONLY");

	document.form.cntCd.value = value;
    doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
}

/**
 * loc_cd 콤보 Change 이벤트 처리
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function loc_cd_OnChange(comboObj, value, text) {
	var str;
	for(var i=0; i<frmChild.length; i++){
		if(frmChild[i].type == "hidden"){
			var prefix = frmChild[i].name.substring(0,3);
			if(prefix == "exp" || prefix == "imp"){
				str = frmChild[i].name.substring(7,frmChild[i].name.length);
	        	if(str == "loc_cd"){
	        		frmChild[i].value = value;
	        	}
			}
		}
    }
	initCheckbox();
	toggleButtons("READONLY");
}


/**
 * 조회 조건에 Including FROB 선택 시 처리
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function OnClickRadioButton(formObj){
	var frobs = formObj.elements("frob_flg");
	for(i = 0; i < frobs.length; i++ ) {
		if(frobs[i].checked) {
			if(frobVal != frobs[i].value){
				retrieveFlag = false;
				deleteFlag = false;
			}
			frobVal = frobs[i].value;
		}
	}
	initCheckbox();
	toggleButtons("READONLY");
}

/**
 * 체크 박스 모두 Unchecked 처리
 */
function initCheckbox() {
	for(var i=0; i<frmChild.length; i++){
		if(frmChild[i].type == "checkbox"){
			frmChild[i].checked = false;
		}
	}
}


/**
 * Location Code에서 엔터키 입력시 조회
 */
function obj_KeyPress() {
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");

	if (srcName == "loc_cd" && KeyCode == 13) {
	    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
}

/**
 * Click 이벤트 처리
 */
function obj_click(){
	var formObject = document.form;
    if(!validateForm(sheetObjects[0],formObject,COMMAND01)) return;
    
	if(!ComIsBtnEnable("btn_Retrieve")) {
		ComShowCodeMessage('BKG06035'); // 먼저 데이터를 조회해 주세요.
		return;
	}
	
	var srcObj = window.event.srcElement;
	var srcName = srcObj.getAttribute("name");
	var srcVal =  srcObj.value;
	if(formObject.menuCode.value == "C" && srcObj.type == "checkbox"){
		if(!retrieveFlag) {
			//조회한 후 선택 가능
			return false;
		}
		
        if(srcObj.checked)
        	checkCnt++;
        else
        	checkCnt--;

    	if(checkCnt >= 0) {
            ComBtnEnable("btn_Save");
    	}
    }
}
/**
 * 조회조건 입력할 때 처리
 */
function obj_KeyUp() {
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	
	if (srcName == "loc_cd" && ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

    var cnt = 0;
    var sheetID = sheetObj.id;

    switch (sheetID) {
    case "sheet1": // sheet1 init
        with (sheetObj) {

            // 높이 설정
            style.height = 180;
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
            InitRowInfo(2, 1, 4, 100);

            // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(66, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(false, false, false, false, false, false);

            var HeadTitle1 = "|Information|Information|Information|Information|Information|Information|Shipper|Shipper|Shipper|Shipper|Shipper|Shipper|Shipper|Shipper|Shipper|Shipper|Shipper|Consignee|Consignee|Consignee|Consignee|Consignee|Consignee|Consignee|Consignee|Consignee|Consignee|Consignee|Notify|Notify|Notify|Notify|Notify|Notify|Notify|Notify|Notify|Notify|Notify|B/L Main|B/L Main|B/L Main|B/L Main|B/L Main|Container|Container|Container|Container|Container|C/M|C/M|C/M|C/M|C/M|C/M|C/M|C/M|Export/Import Ref #|Export/Import Ref #|Export/Import Ref #|Export/Import Ref #|Export/Import Ref #|Export/Import Ref #|Export/Import Ref #|Del St.";
            var HeadTitle2 = "|Exp/Imp Code|B/L Type|Country|Location|Frob|Cstms Div Id|Name|Address|City|State|Country|ZIP|Street|EORI|Tel|Fax|Company Registration No.|Name|Address|City|State|Country|ZIP|Street|EORI|Tel|Fax|Company Registration No.|Name|Address|City|State|Country|ZIP|Street|EORI|Tel|Fax|Company Registration No.|Package|Weight|Measure|Description|Mark|Container No|Seal No|Package|Weight|Measure|Package|Weight|Measure|Description|Mark|HTS|HS|NCM|Ref #1|Ref #2|Ref #3|Ref #4|Ref #5|Ref #6|Ref #7|Del St.";
            
            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);
            InitHeadRow(1, HeadTitle2, true);

            // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
            // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
            // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
            // SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++, dtHiddenStatus, 50, daCenter, false,    "ibflag");
            InitDataProperty(0, cnt++, dtData, 80, daCenter, false,    "xpt_imp_cd", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtData, 60, daCenter, false,    "bl_tp_cd", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtData, 60, daCenter, false,    "cnt_cd", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtData, 60, daCenter, false,    "loc_cd", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtData, 60, daCenter, false,    "frob_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtData, 80, daCenter, false,    "cstms_div_id", false, "", dfNone, 0, false, false);
            
            InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, "shpr_nm_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 60, daCenter, true, "shpr_addr_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, "shpr_cty_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, "shpr_ste_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, "shpr_cnt_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 30, daCenter, true, "shpr_zip_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 30, daCenter, true, "shpr_st_nm_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 30, daCenter, true, "shpr_eori_no_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 30, daCenter, true, "shpr_phn_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 30, daCenter, true, "shpr_fax_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 150, daCenter, true, "shpr_co_rgst_flg", false, "", dfNone, 0, false, false);
            
            InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, "cnee_nm_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 60, daCenter, true, "cnee_addr_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, "cnee_cty_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, "cnee_ste_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, "cnee_cnt_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 30, daCenter, true, "cnee_zip_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 30, daCenter, true, "cnee_st_nm_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 30, daCenter, true, "cnee_eori_no_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 30, daCenter, true, "cnee_phn_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 30, daCenter, true, "cnee_fax_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 150, daCenter, true, "cnee_co_rgst_flg", false, "", dfNone, 0, false, false);
            
            InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, "ntfy_nm_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 60, daCenter, true, "ntfy_addr_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, "ntfy_cty_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, "ntfy_ste_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, "ntfy_cnt_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 30, daCenter, true, "ntfy_zip_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 30, daCenter, true, "ntfy_phn_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 30, daCenter, true, "ntfy_st_nm_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 30, daCenter, true, "ntfy_eori_no_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 30, daCenter, true, "ntfy_fax_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 150, daCenter, true, "ntfy_co_rgst_flg", false, "", dfNone, 0, false, false);
            
            InitDataProperty(0, cnt++, dtCheckBox, 55, daCenter, true, "pck_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 55, daCenter, true, "wgt_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 55, daCenter, true, "meas_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 70, daCenter, true, "bl_desc_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, "bl_mk_flg", false, "", dfNone, 0, false, false);
            
            InitDataProperty(0, cnt++, dtCheckBox, 90, daCenter, true, "cntr_no_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, "seal_no_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, "cntr_pck_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, "cntr_wgt_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 60, daCenter, true, "cntr_meas_flg", false, "", dfNone, 0, false, false);

            InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, "cntr_mf_pck_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, "cntr_mf_wgt_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 60, daCenter, true, "cntr_mf_meas_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 70, daCenter, true, "cntr_mf_desc_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, "cntr_mf_mk_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 40, daCenter, true, "cntr_mf_cmdt_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 40, daCenter, true, "cmdt_hs_cd_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 40, daCenter, true, "cntr_mf_ncm_flg", false, "", dfNone, 0, false, false);

            InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, "xpt_imp_ref_flg1", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, "xpt_imp_ref_flg2", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, "xpt_imp_ref_flg3", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, "xpt_imp_ref_flg4", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, "xpt_imp_ref_flg5", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, "xpt_imp_ref_flg6", false, "", dfNone, 0, false, false); //Tax ID
            InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, "xpt_imp_ref_flg7", false, "", dfNone, 0, false, false); //IEC  
            
            InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "delt_flg", false, "", dfNone, 0, false, false);
        }

    	sheetObj.DataInsert(-1);
    	sheetObj.DataInsert(-1);
    	sheetObj.DataInsert(-1);
    	sheetObj.DataInsert(-1);
        break;

    }
}

/**
 * 시트 데이터 초기화
 * @param sheetObj
 * @return
 */
function initSheetData(sheetObj) {
	sheetObj.RemoveAll();
	sheetObj.DataInsert(-1);
	sheetObj.DataInsert(-1);
	sheetObj.DataInsert(-1);
	sheetObj.DataInsert(-1);
	
	sheetObj.CellValue2(2,"xpt_imp_cd") = 'E';
	sheetObj.CellValue2(3,"xpt_imp_cd") = 'E';
	sheetObj.CellValue2(4,"xpt_imp_cd") = 'I';
	sheetObj.CellValue2(5,"xpt_imp_cd") = 'I';

	sheetObj.CellValue2(2,"bl_tp_cd") = 'M';
	sheetObj.CellValue2(3,"bl_tp_cd") = 'H';
	sheetObj.CellValue2(4,"bl_tp_cd") = 'M';
	sheetObj.CellValue2(5,"bl_tp_cd") = 'H';
}

/**
 * 저장 후 처리
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSaveEnd(sheetObj,ErrMsg) {
	ComOpenWait(false); 
	if(sheetObj.EtcData("mode") == "D"){
		formObj = document.form;

    	comboObjects[0].Index = "-1";
    	comboObjects[1].Index = "-1";
    	
    	initSheetData(sheetObj);
        IBS_CopyRowToForm(sheetObj, formObj, 2, "expMst_");
        IBS_CopyRowToForm(sheetObj, formObj, 3, "expHus_");
        IBS_CopyRowToForm(sheetObj, formObj, 4, "impMst_");
        IBS_CopyRowToForm(sheetObj, formObj, 5, "impHus_");

        deleteFlag = false;
	}else{
		if(document.form.menuCode.value == "C") {
            ComBtnEnable("btn_Delete");
            deleteFlag = true;
		}
	    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
}

/**
 * Sheet관련 프로세스 처리
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
    //sheetObj.ShowDebugMsg = false;
    switch (sAction) {

    case SEARCH01: // country 코드 데이터 조회
        formObj.f_cmd.value = SEARCH01;
        
        formObj.comboName.value = "country"; 
        var sXml = sheetObj.GetSearchXml("ESM_BKG_0926GS.do", FormQueryString(formObj));
		ComBkgXml2ComboItem(sXml, formObj.cnt_cd, "cnt_cd", "cnt_nm");
		break;

    case SEARCH02: // port 코드 데이터 조회
        formObj.f_cmd.value = SEARCH01;
		
        formObj.comboName.value = "port"; 
        var sXml = sheetObj.GetSearchXml("ESM_BKG_0926GS.do", FormQueryString(formObj));
		ComBkgXml2ComboItem(sXml, formObj.loc_cd, "port_cd", "port_nm");

    	comboObjects[1].Code = 'ALL';
    	comboObjects[1].focus();
		break;

    case IBSEARCH: // 조회
        if (!validateForm(sheetObj,formObj,sAction)) return;
		ComOpenWait(true,true); 
        if (sheetObj.id == "sheet1")
        {   
        	checkCnt = 0;
            formObj.f_cmd.value = SEARCH;
            sheetObj.DoSearch("ESM_BKG_0926GS.do", FormQueryString(formObj));
            
            if(sheetObj.RowCount > 0){
	            IBS_CopyRowToForm(sheetObj, formObj, 2, "expMst_");
	            IBS_CopyRowToForm(sheetObj, formObj, 3, "expHus_");
	            IBS_CopyRowToForm(sheetObj, formObj, 4, "impMst_");
	            IBS_CopyRowToForm(sheetObj, formObj, 5, "impHus_");
	            	            
	            for(i=2; i<sheetObj.RowCount+2; i++){
	            	
	            	if(i == 3){
	            		if(checkCnt > 0) {
	            			// Export 에 체크 된 데이터 있을 경우 Export 탭 활성화 
	            			tabObjects[0].SelectedIndex = 0;
	            		}
	            		else {
	            			// Export 에 체크 된 데이터 없을 경우 Import 탭 활성화 
	            			tabObjects[0].SelectedIndex = 1;
	            		}
	            	}
		            for(j=0; j<58; j++){
		            	if(sheetObj.CellValue(i,j) == 1){
		            		checkCnt++;
		            	}
		            }
	            }
            	if(checkCnt == 0){
        			// Import 에 체크 된 데이터 없을 경우 Export 탭 활성화 
            		tabObjects[0].SelectedIndex = 0;
            	}
	            if(formObj.menuCode.value == "C") {
		            if(validateForm(sheetObj,formObj,COMMAND01)) {
			            deleteFlag = true;
		            	ComBtnEnable("btn_Delete");
		            }
	            }
            }
            else{
        		for(var i=0; i<frmChild.length; i++){
        			if(frmChild[i].type == "checkbox"){
        				frmChild[i].checked = false;
        			}
            	}
            	initSheetData(sheetObj);
            	ComShowCodeMessage('BKG00889'); // No data found.
            }
            retrieveFlag = true;
			ComOpenWait(false); 
        }
        break;

    case IBSAVE: // 저장
        if(!validateForm(sheetObj,formObj,COMMAND01))return;
        if(!validateForm(sheetObj,formObj,IBSEARCH))return;
        if(!validateForm(sheetObj,formObj,sAction))return;

		ComOpenWait(true,true); 
    	for(var i=0; i<frmChild.length; i++){
    		if(frmChild[i].type == "hidden"){
    			var prefix = frmChild[i].name.substring(0,3);
    			if(prefix == "exp" || prefix == "imp"){
    				str = frmChild[i].name.substring(7,frmChild[i].name.length);
    	        	if(str == "frob_flg"){
    	                var frobs = formObj.elements("frob_flg");
    	                for (j=0; j<frobs.length; j++) {
    	                	if(frobs[j].checked) {
    	                		frmChild[i].value = frobs[j].value;
    	                		break;
    	                	}
    	                }
    	        	}
    			}
    		}
        }

        IBS_CopyFormToRow(formObj, sheetObj, 2, "expMst_");
        IBS_CopyFormToRow(formObj, sheetObj, 3, "expHus_");
        IBS_CopyFormToRow(formObj, sheetObj, 4, "impMst_");
        IBS_CopyFormToRow(formObj, sheetObj, 5, "impHus_");
        sheetObj.RowStatus(2) = "U";
        formObj.f_cmd.value = MULTI;
        sheetObj.DoSave("ESM_BKG_0926GS.do", FormQueryString(formObj), -1, false);
        break;

    case IBINSERT: // 초기화
    	initSheetData(sheetObj);
        IBS_CopyRowToForm(sheetObj, formObj, 2, "expMst_");
        IBS_CopyRowToForm(sheetObj, formObj, 3, "expHus_");
        IBS_CopyRowToForm(sheetObj, formObj, 4, "impMst_");
        IBS_CopyRowToForm(sheetObj, formObj, 5, "impHus_");

    	toggleButtons("INIT");
        break;

    case IBDELETE: // 삭제여부 저장
        if(!validateForm(sheetObj,formObj,COMMAND01))return;
        if(!validateForm(sheetObj,formObj,IBSEARCH))return;
        if(!validateForm(sheetObj,formObj,sAction))return;

		ComOpenWait(true); 
    	sheetObj.RowStatus(2) = "D";
    	sheetObj.RowStatus(3) = "D";
    	sheetObj.RowStatus(4) = "D";
    	sheetObj.RowStatus(5) = "D";
    	
        if (sheetObj.id == "sheet1") {
        	//alert(sheetObj.id);
        	formObj.f_cmd.value = MODIFY;
        	sheetObj.DoSave("ESM_BKG_0926GS.do", FormQueryString(formObj), -1, false);
        	break;
        }
    }
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
    switch (sAction) {
    case IBSEARCH: // 조회
        if (comboObjects[0].Code == "") {
        	ComShowCodeMessage('BKG00104', "Country"); // Mandatory item is missing. Please enter ({?msg1})
        	comboObjects[0].focus();
        	return false;
        }
        return true;
        break;
        
    case IBSAVE: // 저장
    	if(!retrieveFlag){	// 먼저 조회 후 저장 가능
        	return false;
			break;
    	}
    	if(checkCnt < 0) {
    		ComShowCodeMessage('BKG00743'); // There is no updated data to save.
    		return false;
    	}
        return true;
        break;
    
    case IBDELETE: // 삭제여부 저장
    	if(!retrieveFlag){	// 먼저 조회한 후 삭제 가능
        	ComBtnDisable("btn_Delete");
        	return false;
			break;
    	}
    	if(!deleteFlag){
            return false;
            break;
    	}
        return true;
        break;
        
//    case COMMAND01: // 본사 및 지역본부 소속 유저만 저장,삭제 가능
//    	for(var i=0; i<availableOfc.length; i++){
//    		if(userOfficeCode == availableOfc[i]){
//                return true;
//    			break;
//    		}
//    	}
//    	toggleButtons("READONLY");
//    	return false;
//    	break;
    }
    return true;
}

/**
 * 버튼 활성화 처리
 * @param mode
 * @return
 */
function toggleButtons(mode) {
//	switch (mode) {
//	case "INIT":
//    	ComBtnDisable("btn_Retrieve");
//    	ComBtnDisable("btn_Save");
//    	ComBtnDisable("btn_Delete");
//		break;
//	case "READONLY":
//    	ComBtnDisable("btn_Save");
//    	ComBtnDisable("btn_Delete");
//		break;
//	}
}

/* 개발자 작업  끝 */