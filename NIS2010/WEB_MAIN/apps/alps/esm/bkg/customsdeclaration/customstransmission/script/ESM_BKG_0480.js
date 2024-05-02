/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : Esm_bkg_0480.js
 *@FileTitle : ESM_BKG-0480
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.03.05
 *@LastModifier : 김종옥
 *@LastVersion : 1.0
 * 2012.03.05 김종옥
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
 * @class ESM_BKG-0480 : ESM_BKG-0480 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0480() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업 */
// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var state = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject1 = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
			case "radio_cd":
				if(formObject.radio_cd[0].checked){
					ComEnableObject(formObject.in_bkg_no, true);
					ComEnableObject(formObject.in_vvd_cd, false);
					ComEnableObject(formObject.in_pol_cd, false);
					ComEnableObject(formObject.in_por_cd, false);
					ComEnableObject(formObject.in_bat_skd_prd_fm_dt, false);
					ComEnableObject(formObject.in_bat_skd_prd_to_dt, false);
					ComEnableObject(formObject.in_edi_snd_usr_id, false);
					ComEnableObject(document.all.from_to_calendar, false);
					formObject.in_vvd_cd.value = "";
					formObject.in_pol_cd.value = "";
					formObject.in_por_cd.value = "";
					formObject.in_bat_skd_prd_fm_dt.value = "";
					formObject.in_bat_skd_prd_to_dt.value = "";
					formObject.in_edi_snd_usr_id.value = "";
					document.all.from_to_calendar.value = "";
					sheetObject1.RemoveAll();
					document.all.item("bkrbkc_save").style.display = "inline";
    				document.all.item("qty_save").style.display = "none";
				}else if(formObject.radio_cd[1].checked){
					ComEnableObject(formObject.in_bkg_no, false);
					ComEnableObject(formObject.in_vvd_cd, true);
					ComEnableObject(formObject.in_pol_cd, true);
					ComEnableObject(formObject.in_por_cd, true);
					ComEnableObject(formObject.in_bat_skd_prd_fm_dt, true);
					ComEnableObject(formObject.in_bat_skd_prd_to_dt, true);
					ComEnableObject(formObject.in_edi_snd_usr_id, true);
					ComEnableObject(document.all.from_to_calendar, true);
					formObject.in_bkg_no.value = "";
					sheetObject1.RemoveAll();
					document.all.item("bkrbkc_save").style.display = "none";
    				document.all.item("qty_save").style.display = "inline";
				}
				break;

			case "btn_Retrieve":
				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
				break;

			case "btn_New":
				doActionIBSheet(sheetObject1, formObject, IBCLEAR);
				break;

			case "btn_Download":
				sheetObject1.SpeedDown2Excel(-1);
				break

			case "btn_Save":
				doActionIBSheet(sheetObject1, formObject, MULTI01);
				break
				
			case "btn_Trans":
				doActionIBSheet(sheetObject1, formObject, IBSAVE);
				break

   	        case "from_to_calendar": // From 달력버튼
   	        	if(formObject.radio_cd[1].checked){
            		var cal = new ComCalendarFromTo();
            		cal.select(formObject.in_bat_skd_prd_fm_dt, formObject.in_bat_skd_prd_to_dt, 'yyyy-MM-dd');
				}
   	            break
				
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

/**
* IBSheet Object를 배열로 등록
* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
* 배열은 소스 상단에 정의
* @param sheet_obj IBSheet Object
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
		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
	doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
	ComEnableObject(document.all.from_to_calendar, false);
	document.form.in_bkg_no.focus();
}

/** 
 * initControl()
 */ 
function initControl() {
	 DATE_SEPARATOR = "-";
	axon_event.addListenerForm('keypress', 'obj_keypress',  form);    	  
	axon_event.addListenerForm('keyup',    'obj_keyup',   	form);
	axon_event.addListenerForm('deactivate', 'obj_deactivate', form);
	axon_event.addListenerFormat('focus', 'obj_activate', form);
	axon_event.addListenerForm('blur', 'obj_blur', form);		
}

///**
// * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
// */
//function obj_keypress() {
//	switch (event.srcElement.dataformat) {
//        case "engupnum":
//            //숫자+"영문대분자"입력하기
//        	ComKeyOnlyAlphabet('uppernum');
//            break;
//        case "ymd":
//        	ComKeyOnlyNumber(event.srcElement);
//            break;			
//        case "engnum"://숫자+"영문대소"입력하기
//  	  	ComKeyOnlyAlphabet('num'); 
//    	break;
//		default:
//			// 숫자만입력하기(정수,날짜,시간)
//			ComKeyOnlyNumber(event.srcElement);
//	}
//}

/** 
 * Object 의 Keypress 이벤트에 대한 처리  <br>
 * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
 */ 
function obj_keypress(){
    obj = event.srcElement;
    if(obj.dataformat == null) return;
    	 	
    window.defaultStatus = obj.dataformat;
    	 
    switch(obj.dataformat) {
		case "uppernum":
			// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
			ComKeyOnlyAlphabet('uppernum');
			break;
		case "upper":
			// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
			ComKeyOnlyAlphabet('upper');
			break;
        case "ymd":
        	ComKeyOnlyNumber(event.srcElement);
            break;
        case "float":
        	ComKeyOnlyNumber(event.srcElement, ".");
            break;
        default:
            //숫자만입력하기(정수,날짜,시간)
            ComKeyOnlyNumber(event.srcElement, ".");
    }
}

/** 
 * Object 의 Keypress 이벤트에 대한 처리  <br>
 * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
 */ 
function obj_keyup(){
	obj = event.srcElement;
	var formObj = document.form;
	//VOP_OPF_0063 참조
}

	/**
 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
 **/
function obj_deactivate(){
	
    //입력Validation 확인하기
	switch(event.srcElement.name){
	
    	case "in_bat_skd_prd_fm_dt":
    		ComAddSeparator(event.srcElement);
			break;
    	case "in_bat_skd_prd_to_dt":
    		ComAddSeparator(event.srcElement);
			break;
    		
		default:
			break;
	}
}

//업무 자바스크립트 OnFocus 이벤트 처리
function obj_activate() {
   	//마스크 구분자 없애기
   	switch(event.srcElement.name){ 	    	
   		case "in_bat_skd_prd_fm_dt":
   			ComClearSeparator(event.srcElement);
   			break;
   		case "in_bat_skd_prd_to_dt":
   			ComClearSeparator(event.srcElement);
   		default:
   			break;
   	}
}

/** 	
 * 업무 자바스크립트 Onblur 이벤트 처리  <br>
 */    
function obj_blur(){
	obj = event.srcElement;
	var formObj = document.form;

	switch(obj.name) {

		case "in_bat_skd_prd_fm_dt":
			if( formObj.in_bat_skd_prd_fm_dt.value != ""){
                if(!ComChkObjValid(obj)){
                	setObjValue("in_bat_skd_prd_fm_dt", "");
                	setFocus("in_bat_skd_prd_fm_dt");
                    return false;
                }
            }
			break;
			
		case "in_bat_skd_prd_to_dt":
			if( formObj.in_bat_skd_prd_to_dt.value != ""){
                if(!ComChkObjValid(obj)){
                	setObjValue("in_bat_skd_prd_to_dt", "");
                	setFocus("in_bat_skd_prd_to_dt");
                    return false;
                }
            }
			break;

	}
}

 /**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 * @param sheetObj 시트오브젝트
 * @param sheetNo 시트오브젝트 태그의 아이디에 붙인 일련번호
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;

	switch (sheetID) {
	case "sheet1": // sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 400;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle1 = "Flag|Seq.|Chk|BKR/BKC\n(R/Rv/D)|Send Date|Send Time|Office|User ID|VVD|Voyage No|POL|POL\nCY cd|POR|POR\nCY cd|Othr Ntfy|BKG No|CNTR 1|CNTR 1|CNTR2|CNTR2|CNTR3|CNTR3|CNTR4|CNTR4|CNTR5|CNTR5||||be_bkrbkc|cng_flg|bkg_skd_delt_flg";
			var HeadTitle2 = "Flag|Seq.|Chk|BKR/BKC\n(R/Rv/D)|Send Date|Send Time|Office|User ID|VVD|Voyage No|POL|POL\nCY cd|POR|POR\nCY cd|Othr Ntfy|BKG No|TP|Qty|TP|Qty|TP|Qty|TP|Qty|TP|Qty||||be_bkrbkc|cng_flg|bkg_skd_delt_flg";
			var headCount = ComCountHeadTitle(HeadTitle2);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, "ibflag");
			InitDataProperty(0, cnt++, dtDataSeq, 	40, daCenterTop, true,	"seq");
			InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true,	"del_chk",				false, "", dfNone, 0, true,	true);			
			InitDataProperty(0, cnt++, dtCombo, 70, daCenterTop, true,	"bkrbkc", 				false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 	75, daCenterTop, true,	"edi_snd_dt", 			false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 	75, daCenterTop, true,	"edi_snd_tm", 			false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 	75, daCenterTop, true,	"edi_snd_ofc_cd", 		false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 	75, daCenterTop, true,	"edi_snd_usr_id",		false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 	75, daCenterTop, true,	"vvd_cd", 				false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenterTop, true, "jp_tml_vsl_no", 	false, "", dfNone, 0, true, true, 10);
			InitDataProperty(0, cnt++, dtData, 	75, daCenterTop, true,	"pol_cd", 				false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtCombo, 75, daCenterTop, true,	"pol_yd_cd", 			false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 	75, daCenterTop, true,	"por_cd", 				false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtCombo, 75, daCenterTop, true,	"por_yd_cd", 			false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtCombo, 70, daCenterTop, true,	"otr_ntfy_yd_cd", 		false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 	100, daCenterTop, true,	"bkg_no", 				false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 	70, daCenterTop, true,	"cntr_tpsz_cd1", 		false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 	50, daCenterTop, true,	"cntr_vol_qty1",		false, "", dfNone, 2, false, true);
			InitDataProperty(0, cnt++, dtData, 	70, daCenterTop, true,	"cntr_tpsz_cd2", 		false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 	50, daCenterTop, true,	"cntr_vol_qty2", 		false, "", dfNone, 2, false, true);
			InitDataProperty(0, cnt++, dtData, 	70, daCenterTop, true,	"cntr_tpsz_cd3", 		false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 	50, daCenterTop, true,	"cntr_vol_qty3", 		false, "", dfNone, 2, false, true);
			InitDataProperty(0, cnt++, dtData, 	70, daCenterTop, true,	"cntr_tpsz_cd4", 		false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 	50, daCenterTop, true,	"cntr_vol_qty4", 		false, "", dfNone, 2, false, true);
			InitDataProperty(0, cnt++, dtData, 	70, daCenterTop, true,	"cntr_tpsz_cd5", 		false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 	50, daCenterTop, true,	"cntr_vol_qty5", 		false, "", dfNone, 2, false, true);
			InitDataProperty(0, cnt++, dtHidden,50, daCenterTop, true,	"vsl_cd", 			false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden,50, daCenterTop, true,	"skd_voy_no", 		false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden,50, daCenterTop, true,	"skd_dir_cd", 		false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden,50, daCenterTop, true,	"be_bkrbkc", 		false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden,50, daCenterTop, true,	"snaccs_tml_edi_sts_cng_flg", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden,50, daCenterTop, true,	"bkg_skd_delt_flg", false, "", dfNone, 0, false, true);
			//CountPosition = 0;
			InitDataCombo(0, "bkrbkc",  "R|Rv|D",  "R|V|D");
						
			SelectHighLight = false;
			SelectionMode = smSelectionCol;
		}
		break;

	}
}

/**
* Sheet관련 프로세스 처리
* @param sheetObj Sheet
* @param formObj form객체
* @param sAction 작업처리코드
*/
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
		
		case IBCREATE:      //콤보 데이터 조회
				formObj.f_cmd.value = INIT;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0479GS.do", FormQueryString(formObj));
				var arrCombo;
				arrCombo = ComXml2ComboString(sXml, "val", "name");
				sheetObj.InitDataCombo(0, "pol_yd_cd", " |"+arrCombo[0], " |"+arrCombo[0]	,"", "", 0);
				sheetObj.InitDataCombo(0, "por_yd_cd", " |"+arrCombo[0], " |"+arrCombo[0],"", "", 0);
				sheetObj.InitDataCombo(0, "otr_ntfy_yd_cd", " |"+arrCombo[0], " |"+arrCombo[0],"", "", 0);
				break;

		case IBSEARCH:      //조회
			if(validateForm(sheetObj,formObj,sAction)){
				
				if(formObj.radio_cd[0].checked){
					formObj.f_cmd.value = SEARCH;
				}else{
					formObj.f_cmd.value = SEARCH01;
				}	
				
				var sParam = FormQueryString(formObj);
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0480GS.do", sParam);
				if(sXml.length>0){ 
					sheetObj.LoadSearchXml(sXml);
				}
				ComOpenWait(false);
			}	
			break;

		case MULTI01:
			if(validateForm(sheetObj,formObj,sAction)){
				formObj.f_cmd.value = MULTI01;

				var sParamSheet = sheetObj.GetSaveString(false, true, "del_chk");
	        	var sParam =  FormQueryString(formObj)+ "&" + ComSetPrifix(sParamSheet, "");
	        	var sXml = sheetObj.GetSaveXml("ESM_BKG_0480GS.do", sParam);
				
				sheetObj.LoadSaveXml(sXml);
			}	
			break;
			
		case IBSAVE: //transmit
			if(validateForm(sheetObj,formObj,sAction)){
				
				if(formObj.radio_cd[0].checked){
					formObj.f_cmd.value = MULTI;
				}else{
					formObj.f_cmd.value = MULTI02;
				}
				var sParamSheet = sheetObj.GetSaveString(false, true, "del_chk");
	        	var sParam =  FormQueryString(formObj)+ "&" + ComSetPrifix(sParamSheet, "");
	        	var sXml = sheetObj.GetSaveXml("ESM_BKG_0480GS.do", sParam);

				var vChkFlg = ComGetEtcData(sXml, "chk_flg");
				if(vChkFlg == "ROUTE"){
					ComShowCodeMessage('BKG00651',"BKG ROUTE");
				}else{
					sheetObj.LoadSaveXml(sXml);
				}
				
//				for(i=1; i<= sheetObjects[0].Rows ; i++) {
//					if(sheetObjects[0].CellValue(i,"bkg_skd_delt_flg")=="Y"){
//						ComShowCodeMessage("BKG02120"); 
//						return;
//					}
//					}
			}	
			break;

		case IBCLEAR:
			formObj.reset();
			sheetObj.RemoveAll();
			ComEnableObject(formObj.in_bkg_no, true);
			ComEnableObject(formObj.in_vvd_cd, false);
			ComEnableObject(formObj.in_pol_cd, false);
			ComEnableObject(formObj.in_por_cd, false);
			ComEnableObject(formObj.in_bat_skd_prd_fm_dt, false);
			ComEnableObject(formObj.in_bat_skd_prd_to_dt, false);
			ComEnableObject(formObj.in_edi_snd_usr_id, false);
			ComEnableObject(document.all.from_to_calendar, false);
			document.all.item("bkrbkc_save").style.display = "inline";
			document.all.item("qty_save").style.display = "none";
			formObj.in_bkg_no.focus();
			break;
	}
}

/**
* Sheet에서 클랙했을시 체크박스 처리
* @param sheetObj Sheet
* @param row row
* @param col col
*/
function sheet1_OnClick(sheetObj, row, col) {
	var formObj = document.form;
	if(formObj.radio_cd[1].checked){
		if(col == 2){
			if(sheetObj.CellValue(row, col) == "0"){
				for(i=0 ; i<5 ; i++){
					if ( sheetObj.CellValue(row, 16+(i*2)) != "" ){
						sheetObj.CellEditable(row, 16+(i*2)) = true;
					}
				}
			}
			else{
				for(i=0 ; i<5 ; i++){
					if ( sheetObj.CellValue(row, 16+(i*2)) != "" ){
						sheetObj.CellEditable(row, 16+(i*2)) = false;
					}
				}
			}
		}
	}
}

/**
* Sheet에서 데이타 변경시 처리
* @param sheetObj Sheet
* @param Row
* @param Col
* @param Value
*/
function sheet1_OnChange(sheetObj, Row, Col, Value){
	if(Col == 3){
		if(Value == sheetObj.CellValue(Row, "be_bkrbkc")){
			sheetObj.CellValue(Row, "snaccs_tml_edi_sts_cng_flg") = "N";
		}else{
			sheetObj.CellValue(Row, "snaccs_tml_edi_sts_cng_flg") = "Y";
		}
	}
}

function sheet1_OnSaveEnd(sheetObj, ErrMsg){
	var formObject = document.form;
	doActionIBSheet(sheetObj, formObject, IBSEARCH, true);
}

 /**
  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  * @param sheetObj Sheet
  * @param formObj form객체
  * @param sAction 작업처리코드
  */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBSEARCH:
			var fmDtObj = form.in_bat_skd_prd_fm_dt;
	 		var toDtObj = form.in_bat_skd_prd_to_dt;
	 		var fmDtValue = fmDtObj.value.replace(/-/g, "");
	 		var toDtValue = toDtObj.value.replace(/-/g, "");
			/*		
			if(!isNull(formObj.in_bkg_no.value)){
				if( formObj.in_bkg_no.value.length != 13 ){
					ComAlertFocus(formObj.in_bkg_no, "");
					return false;
				}
			}
			*/
			if(formObj.radio_cd[0].checked){
				if(ComIsEmpty(formObj.in_bkg_no.value)){
					ComShowCodeMessage("COM130201", "BKG No");
					ComAlertFocus(formObj.in_bkg_no, "");
					return false;
				}				
				
			}else if(formObj.radio_cd[1].checked){
//				vvd와 period 둘 중에 하나로 검색하기 위한 validation
//				if (formObj.in_bat_skd_prd_fm_dt.value==""&&formObj.in_bat_skd_prd_to_dt.value=="") {
//					if( formObj.in_vvd_cd.value == "" ){
//						ComShowCodeMessage('BKG02111');
//						formObj.in_vvd_cd.focus();
//						return false;
//					}
//				}else {
//					if (formObj.in_bat_skd_prd_fm_dt.value!="" && formObj.in_bat_skd_prd_to_dt.value=="") {
//						ComShowCodeMessage('BKG02111');
//						formObj.in_vvd_cd.focus();
//						return false;
//					}else if (formObj.in_bat_skd_prd_fm_dt.value=="" && formObj.in_bat_skd_prd_to_dt.value!="") {
//						ComShowCodeMessage('BKG02111');
//						formObj.in_vvd_cd.focus();
//						return false;
//					}
//				}
        if( formObj.in_bat_skd_prd_fm_dt.value==""&&formObj.in_bat_skd_prd_to_dt.value==""&&formObj.in_vvd_cd.value == ""&&formObj.in_pol_cd.value == ""&&formObj.in_edi_snd_usr_id.value == "") {
		ComShowCodeMessage("BKG02113"); // "Please input VVD or POL or Period or User ID."
		
		return false;
	     }
			}
			if( parseInt(fmDtValue,10) > parseInt(toDtValue, 10) ) {
				 ComShowCodeMessage("BKG95026", "From Date", "To Date");
				 ComSetFocus(fmDtObj);
				 return false;
	 		}
	 		
			var fromAddDays = ComGetDateAdd(fmDtValue, "D", 364, "", true);
			if( parseInt(toDtValue,10) > parseInt(fromAddDays, 10) ) {
				ComShowCodeMessage("BKG95027", "365 days"); // "The period of Date can't be over {?msg1}."
				ComSetFocus(fmDtObj);
				return false;
			}
			
			return true;
			break;
		
		case MULTI01:
			//모두 체크가 안되었으면 (0 이면)
			var iCheckRow = sheetObj.CheckedRows("del_chk");
			if(iCheckRow <= 0){
				ComShowCodeMessage('BKG02108');
			   return false;
			}
			return true;
			break;
			
		case IBSAVE:  
			 //전송
			//모두 체크가 안되었으면 (0 이면)
			var iCheckRow = sheetObj.CheckedRows("del_chk");
			if(iCheckRow <= 0){
				ComShowCodeMessage('BKG02109');
			   return false;
			}
			
			if(sheetObjects[0].CellValue(i,"del_chk") == 1 &&sheetObjects[0].CellValue(i,"jp_tml_vsl_no") == ""){
            	ComShowCodeMessage('BKG02115');// "Please input Voyage number."
        		sheetObjects[0].SelectCell(i,"jp_tml_vsl_no");

        	return;
        	}

			return true;
			break;

	}
	return true;
}

/**
 * 화면 폼입력값에 Null Check
 */
function isNull(itemValue){
    if(itemValue==null || itemValue=="" || itemValue=="undefined"){
    	return true;
    }
    else{
    	return false;
    }
}
/* 개발자 작업 끝 */