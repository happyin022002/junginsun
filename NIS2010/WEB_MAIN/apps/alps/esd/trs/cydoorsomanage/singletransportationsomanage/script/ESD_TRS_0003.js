/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0003.js
*@FileTitle : CY & Door S/O Creation Detail Input
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.15
*@LastModifier : 최 선
*@LastVersion : 1.1
* 2006.10.04 z_kim_sang_geun
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2011.03.15 최 선     1.1 [CHM-201109283] [TRS] ALPS의 Location 조회불가건 수정 보완 요청
* 2012.01.09 김보배 [CHM-201215479] [TRS] Dup. S/O 사전 보완기능 요청
* 
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
 * @class ESD_TRS_0003 : Booking ??? ?? ???? ???? ?? ????? ????.
 */
function ESD_TRS_0003() {
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

// body에서 가지고 온 정보를 비교한다.
var sheetObjectP = opener.sheetObjects[0];

var sheetObjects = new Array();
var sheetCnt = 0;

var lvFromNode = "";
var lvViaNode = "";
var lvToNode = "";
var lvDoorLoc = "";

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
	var formObj = document.form;
	for(i=0;i<sheetObjects.length;i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	//html컨트롤 이벤트초기화
	initControl();
	
	//CHM-201431662 Multiple Apply 개선 2014.08.27
	//Door일 경우 Door Node비활성화(아주지역제외)
	if(formObj.CONTI_CD.value !="A" && formObj.trsp_cost_dtl_mod_cd.value == "DOOR"){
		formObj.dor_nod_cd.disabled = true;	
	}
	
}

    /**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {
        //Axon ??? ??1. ???catch
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
        //영문 대문자 입력
        ComKeyOnlyAlphabet('uppernum');
    }

    /**
     * BKG Creation?? manual? ???? ??? ????. <br>
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
        //?????? ???
        ComClearSeparator(event.srcElement);
    }

    /**
     * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
     **/
    function obj_keypress(){
        //???????
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
function processButtonClick(){
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		// form 이름에 주의하시기 바랍니다. 
		switch (srcName) {
			case "btn_apply":
				if( fnChkForm(formObject) ) {
					doApplyAction(sheetObjectP, formObject);
				}
			break;
			
			case "btns_frmnode": //FromNode Popup창
				openHireYardPopup('getFromNode');
			break;
			
			case "btns_vianode": //ViaNode Popup창
				openHireYardPopup('getViaNode');
			break;

			case "btns_tonode": //ToNode Popup창
				openHireYardPopup('getToNode');
			break;

			case "btns_actualcust": //Actual Customer창
				popActualCustomer(sheetObject, formObject);
			break;

			case "btns_dorloc": //DoorLocation Popup창
				openHireYardPopup('getDorLoc');
			break;
			
			case "btn_close":
				window.close();
			break;
		} // end switch
	} catch(e) {
		if( e = "[object Error]") {
			errMsg = ComGetMsg("TRS90108");
			ComShowMessage(errMsg);
		} else {
			ComShowMessage(e);
		}
	}
}
	
function fnChkForm(theForm) { // btn_apply 유효성 체크
	if( !doengnumcheck(theForm.act_cust_cd.value) ) {
		theForm.act_cust_cd.focus();
		return false;
	}
	if( !doengnumcheck(theForm.remark.value) ) {
		return false;
	}
	
	var fmNod = doSepRemove(theForm.fm_nod_cd.value, " ");
	var toNod = doSepRemove(theForm.to_nod_cd.value, " ");
	var dorNod = doSepRemove(theForm.dor_nod_cd.value, " ");
	var viaNod = doSepRemove(theForm.via_nod_cd.value, " ");
	
	if ( fmNod != "" ||toNod != ""  ||dorNod != ""  ||viaNod != ""  ){
		if (doSepRemove(theForm.cng_rsn_desc.value, " ") == ""){
		    errMsg = ComGetMsg("TRS90530");
		    ComShowMessage(errMsg);
	        theForm.cng_rsn_desc.focus();
		    return false;
	   }
	}
	
	return true;
}

function doApplyAction(sheetObj, formObj) {
	var lvDocValue = "";
	var lvDocText = "";
	var lvDocChoi = "";
	var lvCrrValue = "";
	var lvCrrText = "";
	var lvCrrChoi = "";
	//데이터 행의 개수 확인
	var fromRow = 0;
	var sRow = sheetObj.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");

    var lv_cost_mode_cd    = formObj.trsp_cost_dtl_mod_cd.value;
    
    if( lv_cost_mode_cd == "DOOR"){   /* DOOR + DOR SERVICE TYPE CODE APPLY */
    	for( var i=0; i<formObj.dor_svc_tp_cd.length; i++ ) {
    		lvDocValue = formObj.dor_svc_tp_cd.options[i].value + "|"+ lvDocValue;
    		lvDocText = formObj.dor_svc_tp_cd.options[i].text + "|"+ lvDocText;
    		lvDocChoi = formObj.dor_svc_tp_cd.value;
    	}    
    }

	for( var i=0; i<formObj.trsp_crr_mod_cd.length; i++ ) {
		lvCrrValue = formObj.trsp_crr_mod_cd.options[i].value + "|"+ lvCrrValue;
		lvCrrText = formObj.trsp_crr_mod_cd.options[i].text + "|"+ lvCrrText;
		lvCrrChoi = formObj.trsp_crr_mod_cd.value;
	}
	
	for( var i = 0; i < arrRow.length-1; i++ ) {
		fromRow = arrRow[i];
		if( sheetObj.CellValue(fromRow, "chk1") == "1" ) {
		    
			if(formObj.act_cust_cd.value != ''){
				sheetObj.CellValue2(fromRow, "act_cust_cd") = formObj.act_cust_cd.value;
			}
			if(formObj.act_cust_cnt_cd.value != ''){
				sheetObj.CellValue2(fromRow, "act_cust_cnt_cd") = formObj.act_cust_cnt_cd.value;
			}
			if(formObj.act_cust_seq.value != ''){
				sheetObj.CellValue2(fromRow, "act_cust_seq") = formObj.act_cust_seq.value;
			}
			if(formObj.act_cust_addr_seq.value != ''){
				sheetObj.CellValue2(fromRow, "act_cust_addr_seq") = formObj.act_cust_addr_seq.value;
			}
			if(formObj.factory_nm.value != ''){
				sheetObj.CellValue2(fromRow, "fctry_nm") = formObj.factory_nm.value;
			}
			if(formObj.factory_zip_code.value != ''){
				sheetObj.CellValue2(fromRow, "dor_pst_cd") = formObj.factory_zip_code.value;
			}
			if(formObj.factory_addr.value != ''){
				sheetObj.CellValue2(fromRow, "dor_de_addr") = formObj.factory_addr.value;
			}
			if(formObj.factory_tel_no.value != ''){
				sheetObj.CellValue2(fromRow, "cntc_pson_phn_no") = formObj.factory_tel_no.value;
			}
			if(formObj.factory_fax_no.value != ''){
				sheetObj.CellValue2(fromRow, "cntc_pson_fax_no") = formObj.factory_fax_no.value;
			}
			if(formObj.pic_nm.value != ''){
				sheetObj.CellValue2(fromRow, "cntc_pson_nm") = formObj.pic_nm.value;
			}
			
			if( doSepRemove(formObj.fm_nod_cd.value, " ") != "" ) {
				sheetObj.CellValue2(fromRow, "fm_nod_yard") = document.fm_nod_yard.Code;
				sheetObj.CellValue(fromRow, "fm_nod_cd") = formObj.fm_nod_cd.value;
//				sheetObj.CellComboItem(fromRow, "fm_nod_yard", lvFromNode, lvFromNode);
			}
			if( lvCrrChoi.indexOf("D") < 0 ) {
				if( doSepRemove(formObj.via_nod_cd.value, " ") != "" ) {
					sheetObj.CellValue2(fromRow, "via_nod_cd") = formObj.via_nod_cd.value;
					sheetObj.CellComboItem(fromRow, "via_nod_yard", lvViaNode, lvViaNode);
					sheetObj.CellValue2(fromRow, "via_nod_yard") = document.via_nod_yard.Code;
				}
				sheetObj.CellEditable(fromRow, "via_nod_cd") = true;
				sheetObj.CellEditable(fromRow, "via_nod_yard") = true;
			} else {
				sheetObj.CellValue2(fromRow, "via_nod_cd") = formObj.via_nod_cd.value;
				sheetObj.CellComboItem(fromRow, "via_nod_yard", "", "");
				sheetObj.CellValue2(fromRow, "via_nod_yard") = "";
				sheetObj.CellEditable(fromRow, "via_nod_cd") = false;
				sheetObj.CellEditable(fromRow, "via_nod_yard") = false;
			}
			
			if( doSepRemove(formObj.to_nod_cd.value, " ") != "" ) {

				sheetObj.CellValue2(fromRow, "to_nod_yard") = document.to_nod_yard.Code;
				sheetObj.CellValue(fromRow, "to_nod_cd") = formObj.to_nod_cd.value;
//				sheetObj.CellComboItem(fromRow, "to_nod_yard", lvToNode, lvToNode);
			}
			if( doSepRemove(formObj.dor_nod_cd.value, " ") != "" ) {
				sheetObj.CellValue2(fromRow, "dor_nod_cd") = formObj.dor_nod_cd.value;
				sheetObj.CellComboItem(fromRow, "dor_nod_yard", lvDoorLoc, lvDoorLoc);
				sheetObj.CellValue2(fromRow, "dor_nod_yard") = document.dor_nod_yard.Code;
			}
			if( doSepRemove(lvCrrChoi, " ") != "" ) {
				sheetObj.CellComboItem(fromRow, "trsp_crr_mod_cd", lvCrrText, lvCrrValue);
				sheetObj.CellValue2(fromRow, "trsp_crr_mod_cd") = lvCrrChoi;
			}
			if( formObj.trsp_cost_dtl_mod_cd.value == "DOOR" ) {
				//Asis S/O Creation화면의 dor_svc_tp_cd항목은 Combo가 아님.
				if(formObj.scrn_id.value != "0005"){
					sheetObj.CellComboItem(fromRow, "dor_svc_tp_cd", lvDocText, lvDocValue);
				}
				sheetObj.CellValue2(fromRow, "dor_svc_tp_cd") = lvDocChoi;
			}
			if( doSepRemove(formObj.remark.value, " ") != "" ) {
				sheetObj.CellValue2(fromRow, "spcl_instr_rmk") = formObj.remark.value;
			}
			
			if( doSepRemove(formObj.cng_rsn_desc.value, " ") != "" ) {
				sheetObj.CellValue2(fromRow, "cng_rsn_desc") = formObj.cng_rsn_desc.value;
			}
			
			opener.document.form.dist_div_cd.value = "F";
			opener.distance_cal(sheetObj, fromRow);
			opener.document.form.dist_div_cd.value = "G";
		}
	}
	
	// 값이 변경된 row 들의 중복 체크
	for( var i = 0; i < arrRow.length-1; i++ ) {
		fromRow = arrRow[i];
		if( sheetObj.CellValue(fromRow, "chk1") == "1" ) {
			opener.searchSODupCheck(sheetObj, formObj, fromRow);
		}
	}
	opener.document.form.msg_flag.value = "N";
	window.close();
}

/**
 * ACTUAL CUSTOMER POPUP
 */
function popActualCustomer(sheetObject, formObject) {
	var myOption = "dialogWidth:800px; dialogHeight:506px; help:no; status:no; resizable:no; scroll=no; ";
	var url = 'ESD_TRS_0914.screen';
	var lv_conti_cd   = document.form.CONTI_CD.value;
	url    += '?conti_cd='+lv_conti_cd;	
	window.showModalDialog(url, window, myOption);
}
// Pop-Up의 Return 값 Actual Customer
function applyAtualCustomer(winObj, row, act_cust_cd, act_cust_cnt_cd, act_cust_seq, act_cust_addr_seq, act_cust_nm, factory_nm, factory_zip_code, factory_addr, factory_tel_no, factory_fax_no, pic_nm) {    
	var formObj = document.form;
	formObj.act_cust_cd.value         = act_cust_cd;
	formObj.factory_nm.value          = factory_nm;	
	
    formObj.act_cust_cnt_cd.value     = act_cust_cnt_cd   ;     
    formObj.act_cust_seq.value        = act_cust_seq      ;     
    formObj.act_cust_addr_seq.value   = act_cust_addr_seq ;     
    formObj.factory_nm.value          = factory_nm        ;     
    formObj.factory_zip_code.value    = factory_zip_code  ;     
    formObj.factory_addr.value        = factory_addr      ;     
    formObj.factory_tel_no.value      = factory_tel_no    ;     
    formObj.factory_fax_no.value      = factory_fax_no    ;     
    formObj.pic_nm.value              = pic_nm            ;     
    
	winObj.close();
}

function getParamInfo() { // body에서 가지고 온 정보를 얻는다.
    var formObj    = document.form;
    
	var lvFromNode = opener.HGet("FN");
	var lvViaNode = opener.HGet("VN");
	var lvToNode = opener.HGet("TN");
	var lvDoorLoc = opener.HGet("DR");
	var lvTransMode = opener.HGet("TM");
	
	var lv_conti_cd  = opener.HGet("CONTI_CD");
	
	formObj.CONTI_CD.value   = lv_conti_cd;

	formObj.trsp_cost_dtl_mod_cd.value = opener.HGet("CM");
	
	//jsk:20071212
	var lv_cost_mode_cd    = formObj.trsp_cost_dtl_mod_cd.value;
	//var objs               = document.all.item("PrivateDoorCostMode");
	
	if(lv_cost_mode_cd == 'CY')
	{
        //objs.style.display     = "none";
        formObj.btns_dorloc.style.visibility       = "hidden";
        formObj.btns_actualcust.style.visibility   = "hidden";
        formObj.dor_nod_cd.style.visibility        = "hidden";        
        formObj.factory_nm.style.visibility        = "hidden";    
        formObj.act_cust_cd.style.visibility       = "hidden";     
        formObj.org_dor_svc_tp_cd.style.visibility = "hidden";   
                  
	}else{
	    //objs.style.display     = "inline";
	}
	
	if( lvFromNode.length > 5 ) {
		var doc = opener.HGet("FN").split("|");
		document.form.old_fm_nod_cd.value = doc[0];
		document.form.old_fm_nod_yard.value = doc[1];
	}
	if( lvViaNode.length > 5 ) {
		var doc = opener.HGet("VN").split("|");
		document.form.old_via_nod_cd.value = doc[0];
		document.form.old_via_nod_yard.value = doc[1];
	}
	if( lvToNode.length > 5 ) {
		var doc = opener.HGet("TN").split("|");
		document.form.old_to_nod_cd.value = doc[0];
		document.form.old_to_nod_yard.value = doc[1];
	}
	if( lvDoorLoc.length > 5 ) {
		var doc = opener.HGet("DR").split("|");
		document.form.old_dor_nod_cd.value = doc[0];
		document.form.old_dor_nod_yard.value = doc[1];
	 	
		if(formObj.scrn_id.value != "0005" && lv_conti_cd != "A"){
			document.form.dor_nod_cd.value = doc[0];
			document.form.dor_nod_cd.disabled  = true;
			getZoneCombo(formObj.dor_nod_yard, sheetObjects[0], formObj, doc[0]);
			formObj.dor_nod_yard.CODE = doc[1];
			formObj.dor_nod_yard.enable  = false;
			formObj.btns_dorloc.style.display = "none";
		}
	}
	document.form.trsp_crr_mod_cd.value = lvTransMode;
}

/*
 * 외부 콤보박스의 리스트 가져오기 (ESD_TRS_0002.js에도 존재).
 */
function getComboList(obj, comObj, sep) { //object, 값을 받는부분, 'Node종류
	var formObj = document.form;
	var lvobj = doSepRemove(obj.value.toUpperCase(), " ");
	obj.value = lvobj;
	if( lvobj == "" ) {
		obj.value = "";
		comObj.RemoveAll();
		return false;
	} else if( lvobj.length != 5 ) {
		errMsg = ComGetMsg("TRS90074");
		ComShowMessage(errMsg);
		obj.value = "";
		comObj.RemoveAll();
		return false;
	}
	if( !doengnumcheck(lvobj) ) {
		obj.value = "";
		obj.focus();
		comObj.RemoveAll();
		return false;
	}
	if( sep == 'F' ) {
		lvFromNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
		if( lvFromNode == "" ) {
			ComShowCodeMessage('COM12161', lvobj);
			obj.value = "";
			comObj.RemoveAll();
		}
	} else if( sep == 'V' ) {
		lvViaNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
		if( lvViaNode == "" ) {
			ComShowCodeMessage('COM12161', lvobj);
			obj.value = "";
			comObj.RemoveAll();
		}
	} else if( sep == 'T' ) {
		lvToNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
		if( lvToNode == "" ) {
			ComShowCodeMessage('COM12161', lvobj);
			obj.value = "";
			comObj.RemoveAll();
		}
	} else if( sep == 'D' ) {
		lvDoorLoc = getZoneCombo(comObj, sheetObjects[0], formObj, lvobj);
		if( lvDoorLoc == "" ) {
			ComShowCodeMessage('COM12161', lvobj);
			obj.value = "";
			comObj.RemoveAll();
		}
	}
}

/**
 * 공통 Node popup
 */
 function openHireYardPopup(objName) {
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var classId = objName;
	var xx1 = ""; //CONTI
	var xx2 = ""; //SUB CONTI
	var xx3 = ""; //COUNTRY
	var xx4 = ""; //STATE
	var xx5 = ""; //CONTROL OFFIC
	var xx6 = ""; //LOC CODE
	var xx7 = ""; //LOC NAME
	var xx8 = "";
	var xx9 = "";
	var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 772, 450, objName, '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * popSearchPiCommCodeGrid 프로세스 처리
 */
function popSearchPiCommCodeGrid(classID,midCD,cdName,sheetName,sRow,colCode,colName){
	var myUrl = getPopupURL(POPUP_PI_COMM);
	var myOption = getPopupOption(POPUP_PI_COMM);
	var url;
	
	if(myWin != null) myWin.close();
	url = myUrl+"?class_id="+classID + "&mid_cd="+midCD + "&cdName="+cdName+ "&sheetName="+sheetName+ "&sRow="+sRow+ "&colCode="+colCode+ "&colName="+colName;
	myWin = window.open(url, "piCommCodePop", myOption);
	myWin.focus();
}

/**
 * From Node 팝업에 대한 리턴값
 */
function getFromNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.fm_nod_cd.value = lvLoc;
	getYardCombo(document.fm_nod_yard, sheetObjects[0], formObject, lvLoc);
	document.fm_nod_yard.CODE = lvYard;
}

/**
 * Via Node 팝업에 대한 리턴값
 */
function getViaNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.via_nod_cd.value = lvLoc;
	getYardCombo(document.via_nod_yard, sheetObjects[0], formObject, lvLoc);
	document.via_nod_yard.CODE = lvYard;
}


/**
 * To Node 팝업에 대한 리턴값
 */
function getToNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.to_nod_cd.value = lvLoc;
	getYardCombo(document.to_nod_yard, sheetObjects[0], formObject, lvLoc);
	document.to_nod_yard.CODE = lvYard;
}

/**
 * Door Location 팝업에 대한 리턴값
 */
function getDorLoc(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];

	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.dor_nod_cd.value = lvLoc;
	getZoneCombo(document.dor_nod_yard, sheetObjects[0], formObject, lvLoc);
	document.dor_nod_yard.CODE = lvYard;
}

 function doClosePopup() { //Window창의 X를 클릭했을 때 호출됨.
	 opener.document.form.pop_flag.value = "N";
}