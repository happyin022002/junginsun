/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0930.js
*@FileTitle : Office Transfer Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-16
*@LastModifier : z_kim_sang_geun
*@LastVersion : 1.0
* 2006-10-16 z_kim_sang_geun
* 1.0 최초 생성
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0930 : Booking .
 */
function ESD_TRS_0930() {
    this.processButtonClick     = processButtonClick;
    this.setSheetObject         = setSheetObject;
    this.setComboObject         = setComboObject;
    this.setTabObject           = setTabObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;        
    this.initControl            = initControl;
    this.initTab                = initTab;
    this.doActionIBSheet        = doActionIBSheet;
    this.validateForm           = validateForm;
}
/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/
 
// 공통전역변수

//var opensheetObject = opener.sheetObjects[0];
var opensheetObject = opener.openObjSheet(); //PARENT GRID
var openWindownm = opener.openWindownm;

var sheetObjects = new Array();
var sheetCnt = 0;


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
	for(i=0;i<sheetObjects.length;i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	//html컨트롤 이벤트초기화
	initControl();

}

    /**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {
        axon_event.addListener  ('keypress', 'engnum_keypress', 'boo_bkg_no', 'vvd_vvd');
        axon_event.addListener  ('click', 'manual_click', 'manual');    //BKG Creation탭의 manual이 바뀐경우
        axon_event.addListener  ('keyup', 'bkgno_keyup', 'boo_bkg_no'); //BKG Creation탭의 Booking No가 바뀐경우
        axon_event.addListenerFormat('blur',    'obj_blur',     form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onblur이벤트에 코드 처리
        axon_event.addListenerFormat('focus',   'obj_focus',    form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onfocus이벤트에 코드 처리
        axon_event.addListenerFormat('keypress','obj_keypress', form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리

        axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');     //Cust탭의 Cusromer_nm이 바뀐경우
    }

    /**
* HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
     **/
    function engnum_keypress() {
        ComKeyOnlyAlphabet('uppernum');
    }

    /**
     * BKG Creation manual <br>
     **/
    function manual_click() {
        //manual이 체크된 경우만 Bkg_no를 편집 가능으로 한다.
        form.boo_bkg_no.readOnly =!form.manual.checked;
    }

    /**
     * BKG Creation탭의 Booking No가 바뀐경우 기능을 처리한다. <br>
     **/
    function bkgno_keyup() {
        //bkg_no를 수정해서 저장된값과 다른경우 bl_no를 지우고, 같은경우 bl_no를 살린다.
        if (form.boo_bkg_no.value != form.hdn_boo_bkg_no.value) 
            form.boo_bl_no.value = "";
        else
            form.boo_bl_no.value = form.hdn_boo_bl_no.value;
    }

    /**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_blur(){
        //입력Validation 확인하기
        return ComChkObjValid(event.srcElement);
    }

    /**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
     **/
    function obj_focus(){
        //입력 Focus
        ComClearSeparator(event.srcElement);
    }

    /**
     * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
     **/
    function obj_keypress(){
        //입력 Key 
        ComKeyOnlyNumber(event.srcElement);
    }
    
    //Axon 이벤트 처리2. 이벤트처리함수 --- end


/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
	switch(sheetNo) {
		case 1:      //sheet1 init
			with (sheetObj) {
				style.height = 0; // 높이 설정
				SheetWidth = 0; //전체 너비 설정
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				MergeSheet = msAll; //전체Merge 종류 [선택, Default msNone]
				Editable = false; //전체Edit 허용 여부 [선택, Default false]

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 1, 1);
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(1, 0, 0, true);
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)
				var HeadTitle = "STS";
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtStatus,     0,   daCenter,	false,   "ibflag");
			}
		break;
	}
}

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		// form 이름에 주의하시기 바랍니다. 
		with(formObject) {
			switch (srcName) {
				// 버튼 이름으로 case를 넣어 주셔야 합니다. 
				case "btn_transfer":
					doActionIBSheet(sheetObject, formObject, IBSAVE);
				break;
				case "btn_close":
					window.close();
				break;
				case "btns_search":
					openTransOffice();
				break;
				
			} // end switch
		}// end with
	} catch(e) {
		if( e = "[object Error]") {
			errMsg = ComGetMsg("TRS90106");
			ComShowMessage(errMsg);
		} else {
			ComShowMessage(e);
		}
	}
}

/* Sheet관련 프로세스 처리 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSAVE:
			if( doSepRemove(formObj.new_trns_rqst_ofc_cd.value, " ") == "" ) {
				errMsg = ComGetMsg("TRS90091");
				ComShowMessage(errMsg);
				formObj.new_trns_rqst_ofc_cd.focus();
			} else if( doSepRemove(formObj.new_trns_rqst_rsn.value, " ") == "" ) {
				errMsg = ComGetMsg("TRS90093");
				ComShowMessage(errMsg);
				formObj.new_trns_rqst_rsn.focus();
			} else {
			    if( openWindownm == "MT") formObj.f_cmd.value = MODIFY01;
			    else formObj.f_cmd.value = MODIFY;
				var queryStr = opensheetObject.GetSaveString(false, true, "chk1");
				sheetObj.DoSearch4Post("ESD_TRS_0930GS.do", TrsFrmQryString(formObj)+"&"+queryStr, "chk1", false, true);	
			}
		break;

		case IBSEARCH: //조회
			formObj.f_cmd.value = SEARCH10;
			sheetObj.DoSearch4Post("ESD_TRS_0930GS.do", TrsFrmQryString(formObj), "chk1", false, true);	
		break;
	}
}

/*
 * Office 유무체크
 */
function officeCheck(obj) {
	var lvobj = obj.value.toUpperCase();
	obj.value = lvobj;

	if( doSepRemove(obj.value, " ") != "" ) {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
}

/*
 * 화면의 데이터를 삭제한다.
 */
function doTransOffice(sheetObj) {
	var sRow = sheetObj.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");

	for (ir = arrRow.length-2; ir >=0 ; ir--) {
		//원본에서 지움
		sheetObj.RowDelete(arrRow[ir], false);
	}

    if( openWindownm=='MT') opener.doOfficeTrans_end(this.window);
    else 
     window.close();

}

/**
 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSaveEnd에서 정의
 */
function sheet_OnSearchEnd(sheetObj,errMsg) {
	if( document.form.f_cmd.value == MODIFY || document.form.f_cmd.value == MODIFY01 ) {
		if( errMsg.length > 0 ) {
			ComShowMessage(errMsg);
		} else {
			doTransOffice(opensheetObject);
		}
	} else {
		if( errMsg.length > 0 ) {
			document.form.new_trns_rqst_ofc_cd.value = "";
		}
	}
}

/**
 * 공통 Transfer Office
 */
function openTransOffice() {
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var xx1 = ""; //CONTI
	var xx2 = ""; //SUB CONTI
	var xx3 = ""; //COUNTRY
	var xx4 = ""; //STATE
	var xx5 = ""; //CONTROL OFFIC
	var xx6 = ""; //LOC CODE
	var xx7 = ""; //LOC NAME
	var xx8 = "";
	var xx9 = "";
	var classId = "getCOM_ENS_071_1";

	var param = "?ofc_pts_cd="+xx1+"&ofc_cd="+xx2+"&ofc_nm="+xx3+"&ofc_dispaly="+xx4+"&classId="+classId;
	ComOpenPopup('/hanjin/COM_ENS_071.do' + param, 800, 550, 'getCOM_ENS_071_1', '1,0,1,1,1,1,1,1', true);
}

/**
 * Commodity : 팝업에서 Radio로 단일 선택을 한경우..
 */
function getCOM_ENS_071_1(rowArray) {
	var colArray = rowArray[0];
	document.form.new_trns_rqst_ofc_cd.value = colArray[3];
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
