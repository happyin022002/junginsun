/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0310.js
 *@FileTitle : Indonesian Customs EDI
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.29
 *@LastModifier : 민동진
 *@LastVersion : 1.0
 * 2009.09.29 민동진
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
 * @class ESM_BKG_0310 : ESM_BKG_0310 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0310() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

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
			doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
			break; 
			 
		case "btn_downexcel": 			 								 
			sheetObject1.SpeedDown2Excel(-1);
			break;
			
		case "btn_edi":
			doActionIBSheet(sheetObjects[1], formObject, IBSAVE);
			break;

		} 
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	if (formObj.vvd.value.length != 9) {
		ComShowCodeMessage('BKG00007');
		formObj.vvd.focus();
		return false;
	}
	return true;
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
	axon_event.addListenerForm("focus", "obj_Focus", document.form);
	axon_event.addListenerForm("keyup", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("keypress", "obj_KeyPress", document.form);        	 
    axon_event.addListener('keydown', 'obj_ComKeyEnter', 'form');       
	axon_event.addListenerForm("click", "obj_Click", document.form);
	
	
	setFormatByMfTpCd("01I");
	ComSetFocus(document.form.vvd);
}


 /**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;

	switch (sheetID) {
    case "sheet1":      //sheet1 init
    with (sheetObj) {
        // 높이 설정
        style.height = 360;
                            
        //전체 너비 설정
        SheetWidth = mainTable.clientWidth;

        //Host정보 설정[필수][HostIp, Port, PagePath]
        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

        //전체Merge 종류 [선택, Default msNone]
        MergeSheet = msHeaderOnly;

       //전체Edit 허용 여부 [선택, Default false]
        Editable = true;

        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
        InitRowInfo( 1, 1, 3, 100);

        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
        InitColumnInfo(14, 0, 0, true); 
        
        // 해더에서 처리할 수 있는 각종 기능을 설정한다
        InitHeadMode(true, true, true, true, false,false)

        var HeadTitle = "|Seq.|BKG No.|B/L No.|C/T|T/S|T/VVD|POR|POL|POD|DEL";

        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
        InitHeadRow(0, HeadTitle, true);


        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
        InitDataProperty(0, cnt++ , dtHiddenStatus,	0,      daCenter,  	 false,  	"ibflag");               
    	InitDataProperty(0, cnt++ , dtDataSeq,	    35,     daCenter,    false,     "Seq",          false,    "",      dfNone, 			0,     false,		false,-1,false,false,"",true,"IUD",false);
		InitDataProperty(0, cnt++ , dtData,      	145,    daCenter,    false,     "bkg_no",      	false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      	145,    daCenter,    false,     "bl_no",       	false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      	60,     daCenter,    false,     "bkg_cgo_tp_cd",	      	false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      	60,     daCenter,    false,     "ts_flg",	      	false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      	125,     daCenter,    false,     "vvd",	      	false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      	95,     daCenter,    false,     "por_cd",       false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      	95,     daCenter,    false,     "pol_cd",       false,    "",      dfNone, 			0,     false,		false); 
		InitDataProperty(0, cnt++ , dtData,      	95,     daCenter,    false,     "pod_cd",   	false,    "",      dfNone, 			0,     false,		false);                                                                                                                                            	
		InitDataProperty(0, cnt++ , dtData,      	95,     daCenter,  	 false,     "del_cd",  		false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtHidden,      	60,     daCenter,  	 false,     "vsl_cd",  		false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtHidden,      	35,     daCenter,    false,     "skd_voy_no",   false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtHidden,      	80,     daCenter,  	 false,     "skd_dir_cd",  	false,    "",      dfNone, 			0,     false,		false);

   }
    break;
    
	case "sheet2": //sheet2 init
		with (sheetObj) {

			// 높이 설정
			style.height = 0;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(1, 1, 15, 100);

			var HeadTitle1 = "|Flat File";
            var headCount = ComCountHeadTitle(HeadTitle1);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);
            
            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false,false)

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true, true);
            
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtHiddenStatus,	0,      daCenter,  	 false,  	"ibflag");
            InitDataProperty(0, cnt++, dtData, 300, daLeft, false, "flat_file");
		}
		break;
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

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
	
	case IBSEARCH:	// 조회
	if(!validateForm(sheetObj,formObj,sAction)) {
		return false;
	}
	sheetObj.WaitImageVisible = false;
	ComOpenWait(true);	
	initSheet(sheetObjects[0],0);
	formObj.f_cmd.value = SEARCH;  
	formObj.vsl_cd.value     = formObj.vvd.value.substring(0,4);
	formObj.skd_voy_no.value = formObj.vvd.value.substring(4,8);
	formObj.skd_dir_cd.value = formObj.vvd.value.substring(8);
    formObj.pol_cd.value = formObj.pol_code.value; 
    formObj.pod_cd.value = formObj.pod_code.value;

	sheetObjects[0].RemoveAll();		     					
		sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0310GS.do", FormQueryString(formObj));

	var arrXml = sXml.split("|$$|");
		 
   	if (arrXml.length > 0) {  	  		 
   	  	sheetObjects[0].LoadSearchXml(arrXml[0]);
   	}    
   	ComEtcDataToForm(formObj, sheetObj);
   	ComOpenWait(false);   
   	break;
   	

	case IBSAVE: //저장
		if (validateForm(sheetObj, formObj, sAction)) {
			if (sheetObj.id == "sheet2") {
				sheetObj.WaitImageVisible = false;
				
				
				/*
				 * 2010.12.14
				 * BL_ISSUE DATA가 없는 BKG 리스트 조회함( CONFIRM MSG 파라메터로 사용하기 위해)
				 * pagerows 는 TRUE : BL_ISSUE DATE 가 없는 BKG 문자열, FALSE : 실제 EDI File Download
				 */
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI;
				formObj.pagerows.value = "TRUE";
				
				var xmlStr = sheetObj.GetSaveXml("ESM_BKG_0310GS.do", FormQueryString(formObj));
				sheetObj.LoadSaveXml(xmlStr);

				ComOpenWait(false);
				
				var msgParam = sheetObj.CellValue(1, "flat_file");
				
				var msgParamBkgNo = Array();
				
				if(msgParam != "") {
					msgParamBkgNo = msgParam.split(",");
				}
				
				if(msgParamBkgNo.length > 0 && sheetObjects[0].RowCount == msgParamBkgNo.length) {
					if(msgParam != "" ) {
						ComShowMessage(ComGetMsg("BKG06128", msgParam));
						return false;
		            }
					
				} else {
					if(msgParam != "" && !ComShowConfirm(ComGetMsg("BKG06127", msgParam))) {
						return false;
		            }
				}

				
				
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI;
				formObj.pagerows.value = "FALSE";
				var xmlStr = sheetObj.GetSaveXml("ESM_BKG_0310GS.do", FormQueryString(formObj));
				
				var sResult = ComGetEtcData(xmlStr, "TRANS_RESULT_KEY");
				if (sResult == "F") {
					sheetObj.LoadSaveXml(xmlStr);
				}			
				else {
					sheetObj.LoadSaveXml(xmlStr);
					///*var sValue = ComGetEtcData(xmlStr, "flatFile");
					//sheetObj.RemoveAll();
					//var row = sheetObj.DataInsert(-1);
					if (sheetObj.RowCount > 0) {
						//sheetObj.CellValue2(row, "flat_file") = sValue;
						var flatFileNm = formObj.vvd.value + "_"
								+ formObj.pol_cd.value + "_" + formObj.pod_cd.value
								+ "_" + ComGetObjValue(formObj.mf_tp_cd) + "_"
								+ ComReplaceStr(ComGetNowInfo("ymd"), "-", "")
								+ "_"
								+ ComReplaceStr(ComGetNowInfo("hms"), ":", "")
								+ "_IB";
						sheetObj.Down2Text("","","1", flatFileNm, "", "", false, false, true);
					}
				}
				ComOpenWait(false);

			}
		}
		break;
	}
}

/**
 * 화면 폼 입력 필드에 MaxLength 만큼 값이 들어오면,
 * 자동으로 다음 필드로 Focus 이동
 * TAB 이나 BACK TAB은 막음
 */
function obj_Click() {
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcValue = window.event.srcElement.getAttribute("value");
	if (srcName == "mf_tp_cd") {
		setFormatByMfTpCd(srcValue);
	}
}


/**
 * 화면 폼 입력 필드에 MaxLength 만큼 값이 들어오면,
 * 자동으로 다음 필드로 Focus 이동
 */
function obj_KeyUp() {
	     
	    var formObject = document.form;        
	    var srcName = window.event.srcElement.getAttribute("name");
	    var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	    var srcValue = window.event.srcElement.getAttribute("value");
	    if (ComChkLen(srcValue, srcMaxLength) == "2") {
	    	ComSetNextFocus();        	    		
	    }
}

/**
 * 엔터 입력시 조회 
 * @return
 */  
  function obj_ComKeyEnter() {
  	
      var formObject = document.form;
      var srcName = window.event.srcElement.getAttribute("name");
           
      if(srcName != "") {         		 
        	ComKeyEnter();
       }         	         
}
  
function setFormatByMfTpCd(mfTpCd) {
	ComEnableObject(document.form.pol_code, true);
	ComEnableObject(document.form.pod_code, true);
	switch (mfTpCd) {
	case "01I":
		if (document.form.usr_ofc_cd.value == "SRGBA") {
			document.form.pod_code.value = "IDSRG";
		}
		else if (document.form.usr_ofc_cd.value == "SUBBA") {
			document.form.pod_code.value = "IDSUB";
		}
		else if (document.form.usr_ofc_cd.value == "JKTBA") {
			document.form.pod_code.value = "IDJKT";
		}
		else if (document.form.usr_ofc_cd.value == "BLWBA") {
			document.form.pod_code.value = "IDBLW";
		}
		ComSetFocus(document.form.pol_code);
		break;
	case "02I":
		ComSetFocus(document.form.pod_code);
		break;
	case "03I":
		ComSetFocus(document.form.pod_code);
		break;
	case "08X":
		if (document.form.usr_ofc_cd.value == "SRGBA") {
			document.form.pod_code.value = "IDSRG";
		}
		else if (document.form.usr_ofc_cd.value == "SUBBA") {
			document.form.pod_code.value = "IDSUB";
		}
		else if (document.form.usr_ofc_cd.value == "JKTBA") {
			document.form.pod_code.value = "IDJKT";
		}
		else if (document.form.usr_ofc_cd.value == "BLWBA") {
			document.form.pod_code.value = "IDBLW";
		}
		break;
	}
}
