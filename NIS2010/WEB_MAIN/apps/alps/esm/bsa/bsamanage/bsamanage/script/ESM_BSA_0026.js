/**=========================================================
* Copyright(c) 2006 CyberLogitec
* @FileName : ESM_BSA_0036.js
* @FileTitle : Inquire/Edit Step-up/Down by Port
* Open Issues :
* Change history :
* @LastModifyDate : 2006-09-18
* @LastModifier : Kim Jong Beom
* @LastVersion : 1.0
*  2006-09-18 Kim Jong Beom
*  1.0 최초 생성
' =========================================================
 * History
 * 2012.05.24 이석준 [CHM-201218050] Port Step Up/Down 화면 Weight 입력 기능 변경 요청
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
     * @class ESM_BSA_0032 : ESM_BSA_0032 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var sheet_selno = ""; //현재선택된 SHEET

var JOINT_OPERATING  = "";
var SPACE_CHARTERING = "";

var selRow = 0;
var selValue = "";

var sheet_height = 20; // sheet의 height

var comboObjects = new Array();
var comboCnt = 0;
var loadingMode = false;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	var formObject = document.form;

	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	var sheetObject3 = sheetObjects[2];
	var sheetObject4 = sheetObjects[3];

	var m_SheetObj = sheetObjects[0]; // Master Sheet
	var d_SheetObj = sheetObjects[1]; // Detail Sheet
	var m_sheet_no   = 1;
	var d_sheet_no   = 2;
	if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
		m_SheetObj = sheetObjects[0];
		d_SheetObj = sheetObjects[1];
		m_sheet_no   = 1;
		d_sheet_no   = 2;
	} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
		m_SheetObj = sheetObjects[2];
		d_SheetObj = sheetObjects[3];
		m_sheet_no   = 3;
		d_sheet_no   = 4;
	}


	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {

			case "btn_retrieve":
				doActionIBSheet(m_SheetObj,formObject,IBSEARCH);
				d_SheetObj.RemoveAll();
				setHeaderTitle(); // Header Setting
				break;

			case "btn_downexcel":
				doActionIBSheet(m_SheetObj,formObject,IBDOWNEXCEL);
				break;

			case "btns_calendar1":
				var cal = new ComCalendar();
				cal.select(formObject.txtSDate, 'yyyy-MM-dd');
				break;

			case "btns_calendar2":
				var cal = new ComCalendar();
				cal.select(formObject.txtEDate, 'yyyy-MM-dd');
				break;

			case "rdoOp_cd":
				if (formObject.rdoOp_cd[0].checked) { //JO 선택시
					document.getElementById("tabLayer1").style.display = "inline";
					document.getElementById("tabLayer2").style.display = "none";
//					document.getElementById("div_carrier").style.display = "inline";
					sheet_selno = formObject.rdoOp_cd[0].value; //'J'
				} else if (formObject.rdoOp_cd[1].checked) { //SC 선택시
					document.getElementById("tabLayer1").style.display = "none";
					document.getElementById("tabLayer2").style.display = "inline";
//					document.getElementById("div_carrier").style.display = "none";
					sheet_selno = formObject.rdoOp_cd[1].value; //'S'
				}
				chgCarrier();
				setHeaderTitle(); // Header Setting
				break;

			case "rdoType":

				m_SheetObj.RemoveAll();
				d_SheetObj.RemoveAll();
				
				m_SheetObj.CountPosition  = 0 ;
				d_SheetObj.CountPosition  = 0 ;
				initSheet(m_SheetObj, m_sheet_no);
				initSheet(d_SheetObj, d_sheet_no);
				
				setHeaderTitle();
				break;

			case "btng_save1":
				doActionIBSheet(m_SheetObj,formObject,IBSAVE);
				d_SheetObj.RemoveAll();
				break;

			case "btng_save2":
   				doActionIBSheet2(d_SheetObj,formObject,IBSAVE);
				break;

			case "btng_reset":
				doActionIBSheet(m_SheetObj,formObject,IBRESET);
				d_SheetObj.RemoveAll();
				break;

			case "btng_portadd":
				doActionIBSheet2(d_SheetObj,formObject,IBINSERT);
				break;

			case "btng_creation":
				doActionIBSheet2(d_SheetObj,formObject,IBCREATE);
				d_SheetObj.RemoveAll();
				break;

			case "bu_zoom_in":
				sheet_height = 100;
				sheetObject1.style.height = sheetObject1.GetSheetHeight(sheet_height);
				sheetObject2.style.height = sheetObject2.GetSheetHeight(sheet_height);
				sheetObject3.style.height = sheetObject3.GetSheetHeight(sheet_height);
				sheetObject4.style.height = sheetObject4.GetSheetHeight(sheet_height);
				div_zoom_in.style.display = "none";
				div_zoom_out.style.display = "inline";
				parent.syncHeight();
				break;

			case "bu_zoom_out":
				sheet_height = 20;
				sheetObject1.style.height = sheetObject1.GetSheetHeight(sheet_height);
				sheetObject2.style.height = sheetObject2.GetSheetHeight(sheet_height);
				sheetObject3.style.height = sheetObject3.GetSheetHeight(sheet_height);
				sheetObject4.style.height = sheetObject4.GetSheetHeight(sheet_height);
				div_zoom_in.style.display = "inline";
				div_zoom_out.style.display = "none";
				parent.syncHeight();
				break;


		} // end switch
	} catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}

	JOINT_OPERATING  = document.form.rdoOp_cd[0].value;
	SPACE_CHARTERING = document.form.rdoOp_cd[1].value;
	document.getElementById("tabLayer2").style.display = "none";
	//tabLayer2.style.display = "none";
	document.getElementById("div_carrier").style.display = "inline";

	setHeaderTitle(); // Header Setting
	sheet_selno = JOINT_OPERATING; //현재선택된 SHEET (첫번째 쉬트)
	
	// 멀티콤보 처리
	loadingMode = true;
	loadCombo();
	
	for(k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],comboObjects[k].id);
	}
	loadingMode = false;
    
    // 초기 설정
    comboObjects[3].Code = "SML";
}

function loadCombo() {
	var formObj = document.form;
	var sXml = formObj.sXml.value;

	var arrXml = sXml.split("|$$|");
		
	if (arrXml.length > 0)
		ComXml2ComboItem(arrXml[0], formObj.cobTrade, "code", "code");
	if (arrXml.length > 1)
		ComXml2ComboItem(arrXml[1], formObj.cobLane, "code", "code");
	if (arrXml.length > 2)
		ComXml2ComboItem(arrXml[2], formObj.cobDir, "code", "code");
	if (arrXml.length > 3){
		ComXml2ComboItem(arrXml[3], formObj.cobCarrier, "code", "code");
	}
	document.form.sXml.value="";
 }
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
/**
* IBCombo Object를 배열로 등록
* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
* 배열은 소스 상단에 정의
*/
function setComboObject(combo_obj){
   comboObjects[comboCnt++] = combo_obj;
}


/**
* IBSheet의 콤보 컬럼에 데이터를 setting한다. <br>
*/
function setIBMultiCombo(sheetObj, sXml ,objName){
	if (sXml == undefined || sXml == ""){
		return;
	}
	var arrData = ComCoaXml2SheetMultiComboString(sXml, "code", "code");
	sheetObj.InitDataCombo(0,objName, arrData[1], arrData[0],"","");		

}
/**
* 콤보 항목을 설정한다. by.yjjeon
*/
function initCombo (comboObj, comboNo) {
	 with (comboObj) {
	  	 DropHeight = 300;
	  	 if( comboNo == "cobCarrier"){
	  		comboObj.BackColor = "#CCFFFD";
	  	 } else {
	  		 comboObj.InsertItem(0, 'All' ,''); 
	  	 }
	  	 Index = 0;  	 
	 }
}
/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var formObject = document.form;
	var cnt = 0;

	switch(sheetNo) {
		case 1:      //sheet1 init
			with (sheetObj) {
				style.height = GetSheetHeight(sheet_height) ;
				SheetWidth = mainTable1.clientWidth;
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				MergeSheet = msHeaderOnly;
				Editable = true;
				InitRowInfo(1, 1, 9, 100);
				InitColumnInfo(14, 1 , 0, true);
				InitHeadMode(true, true, false, true, false, false) ;


				var HeadTitle = "STS|SEQ|From|To|Trade|R.Lane|Dir.|OPR|BSA Capa.|Opr|Opr Job|Carrier|Flg|SML";
				InitHeadRow(0, HeadTitle, false);

				InitDataProperty(0, cnt++, dtStatus,   30, daCenter, false,"M_ibflag");

				InitDataProperty(0, cnt++, dtData,     30, daCenter, true, "M_bsa_seq",      false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtData,     70, daCenter, true, "M_bsa_fm_dt",    false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtData,     70, daCenter, true, "M_bsa_to_dt",    false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtData,     50, daCenter, true, "M_trd_cd",       false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtData,     55, daCenter, true, "M_rlane_cd",     false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtData,     30, daCenter, true, "M_dir_cd",       false, "", dfNone,    0, false, false);

				InitDataProperty(0, cnt++, dtData,     40, daCenter, true, "M_vop_cd",       false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtData,     65, daRight,  true, "M_vsl_capa",     false, "", dfInteger, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden,    0, daCenter, true, "M_bsa_op_cd",    false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtHidden,    0, daCenter, true, "M_bsa_op_jb_cd", false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtHidden,    0, daCenter, true, "M_crr_cd",       false, "", dfNone,    0, false, false);

				//InitDataProperty(0, cnt++, dtCheckBox, 30, daCenter, true, "M_stup_flg",     false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtHidden,   30, daCenter, true, "M_stup_flg",     false, "", dfNone,    0, false, false);
				
				if(formObject.rdoType[2].checked){
					InitDataProperty(0, cnt++, dtAutoSum,  80, daRight,  true, "M_crr_bsa_capa", false, "", dfFloat, 1, true,  false);
				}else{
					InitDataProperty(0, cnt++, dtAutoSum,  80, daRight,  true, "M_crr_bsa_capa", false, "", dfInteger, 0, true,  false);
				}

				CountPosition  = 0 ;
			}
			break;

		case 2:      //sheet2 init
			with (sheetObj) {
				style.height = GetSheetHeight(sheet_height) ;
				SheetWidth = mainTable2.clientWidth;
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				MergeSheet = msHeaderOnly;
				Editable = true;
				InitRowInfo(1, 1, 9, 100);
				InitColumnInfo(14, 0 , 0, true);
				InitHeadMode(true, true, false, true, false, false) ;

				var HeadTitle = "DEL|STS|BSA SEQ|Trade|R.Lane|Dir.|OPR|BSA capa.|Opr|Opr Job|Carrier|SEQ.|Port|BSA(TEU)";
				InitHeadRow(0, HeadTitle, false);

				InitDataProperty(0, cnt++, dtDelCheck, 30, daCenter, false, "");
				InitDataProperty(0, cnt++, dtStatus,   30, daCenter, false, "D_ibflag");

				InitDataProperty(0, cnt++, dtHidden,   50, daCenter, true,  "D_bsa_seq",       false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtHidden,   70, daCenter, true,  "D_trd_cd",        false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtHidden,   70, daCenter, true,  "D_rlane_cd",      false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtHidden,   70, daCenter, true,  "D_dir_cd",        false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtHidden,   70, daCenter, true,  "D_vop_cd",        false, "", dfNone,    0, false, false);

				InitDataProperty(0, cnt++, dtHidden,   80, daRight,  true,  "D_vsl_capa",      false, "", dfInteger, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden,    0, daCenter, true,  "D_bsa_op_cd",     false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtHidden,    0, daCenter, true,  "D_bsa_op_jb_cd",  false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtHidden,    0, daCenter, true,  "D_crr_cd",        false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtData,     30, daCenter, false, "D_port_seq",      false, "", dfNone,    0, false, false,  3);

				InitDataProperty(0, cnt++, dtData,     55, daCenter, false, "D_port_cd",       false, "", dfEngUpKey,    0, true,  true,  5);
				
				if(formObject.rdoType[2].checked){
					InitDataProperty(0, cnt++, dtAutoSum,  65, daRight,  false, "D_port_bsa_capa", false, "", dfFloat, 1, true,  true,  25);
				}else{
					InitDataProperty(0, cnt++, dtAutoSum,  65, daRight,  false, "D_port_bsa_capa", false, "", dfInteger, 0, true,  true,  25);
				}

				CountPosition  = 0 ;
			}
			break;

		case 3:      //sheet3 init
			with (sheetObj) {
				style.height = GetSheetHeight(sheet_height) ;
				SheetWidth = mainTable3.clientWidth;
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				MergeSheet = msHeaderOnly;
				Editable = true;
				InitRowInfo(1, 1, 9, 100);
				InitColumnInfo(14, 1 , 0, true);
				InitHeadMode(true, true, false, true, false, false) ;

				var HeadTitle = "STS|SEQ|From|To|Trade|R.Lane|Dir.|Seq|VSL Code|Opr|Opr Job|Carrier|Flg|Final SML BSA";
				InitHeadRow(0, HeadTitle, false);

				InitDataProperty(0, cnt++, dtStatus,   30, daCenter, false,"M_ibflag");

				InitDataProperty(0, cnt++, dtData,     30, daCenter, true, "M_bsa_seq",          false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtData,     70, daCenter, true, "M_bsa_fm_dt",        false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtData,     70, daCenter, true, "M_bsa_to_dt",        false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtData,     50, daCenter, true, "M_trd_cd",           false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtData,     55, daCenter, true, "M_rlane_cd",         false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtData,     30, daCenter, true, "M_dir_cd",           false, "", dfNone,    0, false, false);

				InitDataProperty(0, cnt++, dtData,     30, daCenter, true, "M_vsl_seq",          false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtData,     65, daCenter, true, "M_vsl_cd",           false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtHidden,    0, daCenter, true, "M_bsa_op_cd",        false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtHidden,    0, daCenter, true, "M_bsa_op_jb_cd",     false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtHidden,    0, daCenter, true, "M_crr_cd",           false, "", dfNone,    0, false, false);

				//InitDataProperty(0, cnt++, dtCheckBox, 30, daCenter, true, "M_stup_flg",         false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtHidden,   30, daCenter, true, "M_stup_flg",         false, "", dfNone,    0, false, false);
				
				if(formObject.rdoType[2].checked){
					InitDataProperty(0, cnt++, dtAutoSum,  80, daRight,  true, "M_crr_bsa_capa", false, "", dfFloat, 1, true,  false);
				}else{
					InitDataProperty(0, cnt++, dtAutoSum,  80, daRight,  true, "M_crr_bsa_capa", false, "", dfInteger, 0, true,  false);
				}
				
				

				CountPosition  = 0 ;
			}
			break;

		case 4:      //sheet4 init
			with (sheetObj) {
				style.height = GetSheetHeight(sheet_height) ;
				SheetWidth = mainTable4.clientWidth;
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				MergeSheet = msHeaderOnly;
				Editable = true;
				InitRowInfo(1, 1, 9, 100);
				InitColumnInfo(15, 0 , 0, true);
				InitHeadMode(true, true, false, true, false, false) ;

				var HeadTitle = "DEL|STS|BSA Seq|From|Trade|R.Lane|Dir.|VSL SEQ|VSL Code|Opr|Opr Job|Carrier|SEQ|Port|BSA(TEU)";
				InitHeadRow(0, HeadTitle, false);

				InitDataProperty(0, cnt++, dtDelCheck, 30, daCenter, false, "");
				InitDataProperty(0, cnt++, dtStatus,   30, daCenter, false, "D_ibflag");

				InitDataProperty(0, cnt++, dtHidden,   50, daCenter, true,  "D_bsa_seq",       false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtHidden,   70, daCenter, true,  "D_bsa_fm_dt",     false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden,   70, daCenter, true,  "D_trd_cd",        false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtHidden,   70, daCenter, true,  "D_rlane_cd",      false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtHidden,   70, daCenter, true,  "D_dir_cd",        false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtHidden,   30, daCenter, true,  "D_vsl_seq",       false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtHidden,   70, daCenter, true,  "D_vsl_cd",        false, "", dfNone,    0, false, false);

				InitDataProperty(0, cnt++, dtHidden,    0, daCenter, true,  "D_bsa_op_cd",     false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtHidden,    0, daCenter, true,  "D_bsa_op_jb_cd",  false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtHidden,    0, daCenter, true,  "D_crr_cd",        false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtData,     30, daCenter, false, "D_port_seq",      false, "", dfNone,    0, false, false,  3);
				InitDataProperty(0, cnt++, dtData,     55, daCenter, false, "D_port_cd",       false, "", dfNone,    0, true,  true,  5);

				if(formObject.rdoType[2].checked){
					InitDataProperty(0, cnt++, dtAutoSum,  65, daRight,  false, "D_port_bsa_capa", false, "", dfFloat, 1, true,  true,  25);
				}else{
					InitDataProperty(0, cnt++, dtAutoSum,  65, daRight,  false, "D_port_bsa_capa", false, "", dfInteger, 0, true,  true,  25);
				}
				CountPosition  = 0 ;
			}
			break;

	}
}


// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	var sheetObject3 = sheetObjects[2];
	var sheetObject4 = sheetObjects[3];
	sheetObj.ShowDebugMsg = false;
    formObj.target = "";

	switch(sAction) {
		case IBSEARCH:
			if (!validateCond(formObj,sAction)) {
				return false;
			}
			if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
    			formObj.f_cmd.value = SEARCHLIST01;
    			sheetObj.DoSearch4Post("ESM_BSA_0026GS.do", bsaFormString(formObj,getParam(curPgmNo)));
			} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
    			formObj.f_cmd.value = SEARCHLIST03;
    			sheetObj.DoSearch4Post("ESM_BSA_0026GS3.do", bsaFormString(formObj,getParam(curPgmNo)));
			}
			break;

		case IBDOWNEXCEL:   //엑셀 다운로드
			if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
    			//sheetObj.SpeedDown2Excel(-1);
    			//if (sheetObject2.RowCount > 0) {
        		//	sheetObject2.SpeedDown2Excel(-1);
    			//}
                var excelType = selectDownExcelMethod(sheetObj);
                switch (excelType) {
                    case "AY":
                        sheetObj.Down2Excel(0, false, false, true);
            			if (sheetObject2.RowCount > 0) {
                			sheetObject2.Down2Excel(0, false, false, true);
            			}
                        break;
                    case "DY":
                        sheetObj.Down2Excel(-1, false, false, true);
            			if (sheetObject2.RowCount > 0) {
                			sheetObject2.Down2Excel(-1, false, false, true);
            			}
                        break;
                    case "AN":
                        sheetObj.SpeedDown2Excel(0, false, false);
            			if (sheetObject2.RowCount > 0) {
                			sheetObject2.SpeedDown2Excel(0, false, false);
            			}
                        break;
                    case "DN":
                        sheetObj.SpeedDown2Excel(-1, false, false);
            			if (sheetObject2.RowCount > 0) {
                			sheetObject2.SpeedDown2Excel(-1, false, false);
            			}
                        break;
                }               
			} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
    			//sheetObj.SpeedDown2Excel(-1);
    			//if (sheetObject4.RowCount > 0) {
        		//	sheetObject4.SpeedDown2Excel(-1);
    			//}
                var excelType = selectDownExcelMethod(sheetObj);
                switch (excelType) {
                    case "AY":
                        sheetObj.Down2Excel(0, false, false, true);
            			if (sheetObject4.RowCount > 0) {
                			sheetObject4.Down2Excel(0, false, false, true);
            			}
                        break;
                    case "DY":
                        sheetObj.Down2Excel(-1, false, false, true);
            			if (sheetObject4.RowCount > 0) {
                			sheetObject4.Down2Excel(-1, false, false, true);
            			}
                        break;
                    case "AN":
                        sheetObj.SpeedDown2Excel(0, false, false);
            			if (sheetObject4.RowCount > 0) {
                			sheetObject4.SpeedDown2Excel(0, false, false);
            			}
                        break;
                    case "DN":
                        sheetObj.SpeedDown2Excel(-1, false, false);
            			if (sheetObject4.RowCount > 0) {
                			sheetObject4.SpeedDown2Excel(-1, false, false);
            			}
                        break;
                }               
			}
			break;

		case IBSAVE:        //Master 저장
			if (!validateForm(sheetObj)) {
				return false;
			}
			if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
    			if (sheetObj.RowCount > 0) {
    				formObj.f_cmd.value = MULTI01;
    				sheetObj.DoSave("ESM_BSA_0026GS.do", bsaFormString(formObj,getParam(curPgmNo,'S')), -1, false);
    			}
			} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
    			if (sheetObj.RowCount > 0) {
    				formObj.f_cmd.value = MULTI03;
    				sheetObj.DoSave("ESM_BSA_0026GS3.do", bsaFormString(formObj,getParam(curPgmNo,'S')), -1, false);
    			}
			}
			break;

		case IBRESET:      //RESET
			if (!validateCond(formObj,sAction)) {
				return false;
			}
			if (ComShowConfirm(ComGetMsg('BSA10021')) == true) { //정보를 RESET 하시겠습니까?

    			if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
    				formObj.f_cmd.value = MODIFY01;
    				sheetObj.DoSearch4Post("ESM_BSA_0026GS.do", bsaFormString(formObj,getParam(curPgmNo)));

    			    formObj.f_cmd.value = SEARCHLIST01;
    			    sheetObj.DoSearch4Post("ESM_BSA_0026GS.do", bsaFormString(formObj,getParam(curPgmNo)));
    			} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
    				formObj.f_cmd.value = MODIFY02;
    				sheetObj.DoSearch4Post("ESM_BSA_0026GS3.do", bsaFormString(formObj,getParam(curPgmNo)));

    			    formObj.f_cmd.value = SEARCHLIST03;
    			    sheetObj.DoSearch4Post("ESM_BSA_0026GS3.do", bsaFormString(formObj,getParam(curPgmNo)));
    			}
				var err_cd  = sheetObj.EtcData("err_cd");
				var err_msg = sheetObj.EtcData("err_msg");
				if (err_cd == "00000") {
					ComShowMessage(ComGetMsg('BSA10018','RESET')); //msg1 + ' 처리가 정상적으로 완료 되었습니다.'
				}
			}
			break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet2(sheetObj,formObj,sAction) {
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	var sheetObject3 = sheetObjects[2];
	var sheetObject4 = sheetObjects[3];
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {

		case IBSEARCH:      //조회
		    var param = "";
			//-----------------------------------------------------------------------------------------
			// RowSaveStr을 이용하여 마스터 그리드에서 선택된 정보를 Query String 형태로 변환하여 넘기도록 수정.
			//-----------------------------------------------------------------------------------------
			if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
    			formObj.f_cmd.value = SEARCHLIST02;
    			param = sheetObj.RowSaveStr(sheetObj.SelectRow);
    			sheetObject2.DoSearch4Post("ESM_BSA_0026GS2.do", bsaFormString(formObj,getParam(curPgmNo)) +'&'+ param);
			} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
    			formObj.f_cmd.value = SEARCHLIST04;
    			param = sheetObj.RowSaveStr(sheetObj.SelectRow);
    			sheetObject4.DoSearch4Post("ESM_BSA_0026GS4.do", bsaFormString(formObj,getParam(curPgmNo)) +'&'+ param);
			}
			break;

		case IBINSERT:      // 행추가
            
			if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
    			if (sheetObject1.RowCount > 0 && sheetObject1.SelectRow > 0) {
        			var Row = sheetObj.DataInsert(-1);

        			sheetObj.CellValue2(Row, "D_bsa_seq")      = ComTrimAll(sheetObject1.CellValue(sheetObject1.SelectRow, "M_bsa_seq"), "-");
        			//sheetObj.CellValue2(Row, "D_bsa_fm_dt")    = ComTrimAll(sheetObject1.CellValue(sheetObject1.SelectRow, "M_bsa_fm_dt"), "-");
        			//sheetObj.CellValue2(Row, "D_bsa_to_dt")    = ComTrimAll(sheetObject1.CellValue(sheetObject1.SelectRow, "M_bsa_to_dt"), "-");

        			sheetObj.CellValue2(Row, "D_trd_cd")       = sheetObject1.CellValue(sheetObject1.SelectRow, "M_trd_cd");
        			sheetObj.CellValue2(Row, "D_rlane_cd")     = sheetObject1.CellValue(sheetObject1.SelectRow, "M_rlane_cd");
        			sheetObj.CellValue2(Row, "D_dir_cd")       = sheetObject1.CellValue(sheetObject1.SelectRow, "M_dir_cd");
        			sheetObj.CellValue2(Row, "D_vop_cd")       = sheetObject1.CellValue(sheetObject1.SelectRow, "M_vop_cd");
        			sheetObj.CellValue2(Row, "D_vsl_capa")     = sheetObject1.CellValue(sheetObject1.SelectRow, "M_vsl_capa");
        			sheetObj.CellValue2(Row, "D_bsa_op_cd")    = sheetObject1.CellValue(sheetObject1.SelectRow, "M_bsa_op_cd");
        			sheetObj.CellValue2(Row, "D_bsa_op_jb_cd") = sheetObject1.CellValue(sheetObject1.SelectRow, "M_bsa_op_jb_cd");
        			sheetObj.CellValue2(Row, "D_crr_cd")       = sheetObject1.CellValue(sheetObject1.SelectRow, "M_crr_cd");
        			sheetObj.CellValue2(Row, "D_port_seq")     = Row;
        			
    			}
			} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
    			if (sheetObject3.RowCount > 0 && sheetObject3.SelectRow > 0) {
        			var Row = sheetObj.DataInsert(-1);

        			sheetObj.CellValue2(Row, "D_bsa_seq")      = ComTrimAll(sheetObject3.CellValue(sheetObject3.SelectRow, "M_bsa_seq"), "-");
        			//sheetObj.CellValue2(Row, "D_bsa_fm_dt")    = ComTrimAll(sheetObject3.CellValue(sheetObject3.SelectRow, "M_bsa_fm_dt"), "-");
        			//sheetObj.CellValue2(Row, "D_bsa_to_dt")    = ComTrimAll(sheetObject3.CellValue(sheetObject3.SelectRow, "M_bsa_to_dt"), "-");
        			sheetObj.CellValue2(Row, "D_trd_cd")       = sheetObject3.CellValue(sheetObject3.SelectRow, "M_trd_cd");
        			sheetObj.CellValue2(Row, "D_rlane_cd")     = sheetObject3.CellValue(sheetObject3.SelectRow, "M_rlane_cd");
        			sheetObj.CellValue2(Row, "D_dir_cd")       = sheetObject3.CellValue(sheetObject3.SelectRow, "M_dir_cd");
        			sheetObj.CellValue2(Row, "D_vsl_seq")      = sheetObject3.CellValue(sheetObject3.SelectRow, "M_vsl_seq");
        			sheetObj.CellValue2(Row, "D_bsa_op_cd")    = sheetObject3.CellValue(sheetObject3.SelectRow, "M_bsa_op_cd");
        			sheetObj.CellValue2(Row, "D_bsa_op_jb_cd") = sheetObject3.CellValue(sheetObject3.SelectRow, "M_bsa_op_jb_cd");
        			sheetObj.CellValue2(Row, "D_crr_cd")       = sheetObject3.CellValue(sheetObject3.SelectRow, "M_crr_cd");
        			sheetObj.CellValue2(Row, "D_port_seq")     = Row;
    			}
			}
			break;

		case IBSAVE:        //Detail 저장
			if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
    			if (sheetObj.RowCount > 0) {
    				formObj.f_cmd.value = MULTI02;
    				sheetObj.DoSave("ESM_BSA_0026GS2.do", bsaFormString(formObj,getParam(curPgmNo,'S')), -1, false);
    			}
			} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
    			if (sheetObj.RowCount > 0) {
    				formObj.f_cmd.value = MULTI04;
    				sheetObj.DoSave("ESM_BSA_0026GS4.do", bsaFormString(formObj,getParam(curPgmNo,'S')), -1, false);
    			}
			}
			break;

		case IBCREATE:      //생성
			if (!validateCond(formObj,sAction)) {
				return false;
			}

		    var param = "";
			//-----------------------------------------------------------------------------------------
			// RowSaveStr을 이용하여 마스터 그리드에서 선택된 정보를 Query String 형태로 변환하여 넘기도록 수정.
			//-----------------------------------------------------------------------------------------
			if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
    			if (sheetObject1.RowCount > 0 && sheetObject1.SelectRow > 0) {
        			formObj.f_cmd.value = MULTI05;
            		param = sheetObject1.RowSaveStr(sheetObject1.SelectRow);
        			sheetObj.DoSearch4Post("ESM_BSA_0026GS2.do", bsaFormString(formObj,getParam(curPgmNo))+'&' + param);
    			}
			} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
    			if (sheetObject3.RowCount > 0 && sheetObject3.SelectRow > 0) {
        			formObj.f_cmd.value = MULTI06;
            		param = sheetObject3.RowSaveStr(sheetObject3.SelectRow);
        			sheetObj.DoSearch4Post("ESM_BSA_0026GS4.do", bsaFormString(formObj,getParam(curPgmNo))+'&' + param);
    			}
			}
			var err_cd  = sheetObj.EtcData("err_cd");
			var err_msg = sheetObj.EtcData("err_msg");
			if(err_cd == "00000"){
				ComShowCodeMessage("BSA10018","Creation");
			}
			break;

	}
}

// Search-End Setting
function setSearchEnd(sheetObj) {
	var formObject = document.form;
    var i = 1;

	if (formObject.rdoType[0].checked) {
		div_save.style.display = "none";
		sheetObj.ColHidden("M_ibflag") = true;
		for (i=1; i<sheetObj.LastRow+1; i++) {
			sheetObj.CellEditable(i,"M_crr_bsa_capa") = false;
		}
	} else if (formObject.rdoType[1].checked || formObject.rdoType[2].checked) {
		div_save.style.display= "inline";
		sheetObj.ColHidden("M_ibflag") = false;
		for (i=1; i<sheetObj.LastRow+1; i++) {
			sheetObj.CellEditable(i,"M_crr_bsa_capa") = true;
		}
	}

	sheetObj.SumText(0,0) = "" ;
	sheetObj.SumText(0,"M_bsa_seq") = "TOTAL" ;
}


function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
	var formObject = document.form;
    setSearchEnd(sheetObj);
}

function sheet3_OnSearchEnd(sheetObj,ErrMsg) {
	var formObject = document.form;
    setSearchEnd(sheetObj);
}

// sheet1을 더블클릭하여 sheet2를 상세조회한다.
function sheet1_OnDblClick(sheetObj, row, col) {
	var formObject = document.form;
	
	sheetObjects[1].RemoveAll();
	doActionIBSheet2(sheetObj,formObject,IBSEARCH);
}

// sheet3을 더블클릭하여 sheet4를 상세조회한다.
function sheet3_OnDblClick(sheetObj, row, col) {
	var formObject = document.form;
	doActionIBSheet2(sheetObj,formObject,IBSEARCH);
}


var selRow = 0;
var selValue = "";

function isValidLocation(result) {
	var sheetObject2 = sheetObjects[1];
	var sheetObject4 = sheetObjects[3];

	if(result != "Y"){
		ComShowMessage(ComGetMsg('BSA10004',selValue));  //msg1 + ' 는(은) 유효한 PORT가 아닙니다.'
    	if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
    		sheetObject2.SelectCell(selRow,"D_port_cd",true);
    	} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
    		sheetObject4.SelectCell(selRow,"D_port_cd",true);
    	}
	}
}

function sheet2_OnChange(sheetObj,Row,Col,Value) {
	var formObj = document.form;
	var param;

	if (sheetObj.ColSaveName(Col) == "D_port_cd") {
		selRow = Row;
		selValue = Value;
		
		param = "f_cmd="+SEARCHLIST02;
		param = param+"&port_cd="+sheetObj.CellValue(Row,Col);
		param = param+"&code=locCd";
		var sXml = sheetObj.GetSearchXml("ESM_BSA_CODE.do", param);
		var locCd = GetEtcDataForExceptional(sXml, "locCd", "0");
		
		isValidLocation(locCd);
	}
}

function sheet4_OnChange(sheetObj,Row,Col,Value) {
	var formObj = document.form;
	var param;
	
	if (sheetObj.ColSaveName(Col) == "D_port_cd") {
		selRow = Row;
		selValue = Value;

		
		param = "f_cmd="+SEARCHLIST02;
		param = param+"&port_cd="+sheetObj.CellValue(Row,Col);
		param = param+"&code=locCd";
		var sXml = sheetObj.GetSearchXml("ESM_BSA_CODE.do", param);
		var locCd = GetEtcDataForExceptional(sXml, "locCd", "0");
		isValidLocation(locCd);
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj) {
	with(sheetObj){
	}

	return true;
}

/**
 * 화면 조회값에 대한 유효성검증 프로세스 처리
 */
function validateCond(formObj,sAction) {
	with(formObj){
		if (ComTrim(txtSDate.value) == "") {
			//ComShowMessage(ComGetMsg('COM12130','Period','First Element'));
			//formObj.txtSDate.focus();
			ComAlertFocus(txtSDate, ComGetMsg('COM12130','Period','First Element'));
			return false;
		}

		// msg1 + '의 ' + msg2 + '는(은) ' + msg3 + ' 보다 적거나 같아야 합니다.';
		if (ComTrim(txtSDate.value) != "" && ComTrim(txtEDate.value) != "") {
			if(parseInt(txtSDate.value) > parseInt(txtEDate.value)){
				//ComShowMessage(ComGetMsg('BSA10011','Period','First Element','Second Element'));
				//txtEDate.focus();
				ComAlertFocus(txtEDate, ComGetMsg('BSA10011','Period','First Element','Second Element'));
				return false;
			}
		}
//		if(formObj.cobTrade.value == ""){ 
//	            ComAlertFocus(cobTrade, ComGetMsg('COM12113','Trade'));
//	            return false;
//	    }
//	        
//		if(formObj.cobLane.value == ""){
//         ComAlertFocus(cobLane, ComGetMsg('COM12113','Lane'));
//         return false;
//		}
	}

	return true;
}


 /**
  * trade코드 변경시 rLane 리스트를 리플래쉬 한다.
  */
 function cobTrade_OnChange(obj) {
 	if (loadingMode == true) return; 
 	var formObj = document.form;
    var sheetObj = sheetObjects[0];
    var param = "";
    var trd_cd = "";
	sheetObj.WaitImageVisible = false;
    
    if(obj.Text != ""){
     	formObj.f_cmd.value = SEARCHLIST01;
		trd_cd = obj.Code;
        param = "f_cmd="+SEARCHLIST01;
		param = param+"&trd_cd="+trd_cd;
		param = param+"&code=rLane";
		var sXml = sheetObj.GetSearchXml("ESM_BSA_CODE.do", param);
			
		var arrXml = sXml.split("|$$|");
		if (arrXml.length > 0)
			ComXml2ComboItem(arrXml[0], formObj.cobLane, "code", "code");
		formObj.cobLane.Index = 0;
     }
	sheetObj.WaitImageVisible = true;
 }
/**
 *  JO/SC 가 변경되면 Carrier combo를 변경한다.
 */
function chgCarrier(){
    var sheetObj = sheetObjects[0];
    var formObj = document.form;
    var param="";    
    var bsa_op_cd = "";
    sheetObj.RemoveAll();
	sheetObj.WaitImageVisible = false;
    
    if (formObj.rdoOp_cd[0].checked) { //JO 선택시
    	bsa_op_cd = formObj.rdoOp_cd[0].value;
    } else if (formObj.rdoOp_cd[1].checked) { //SC 선택시
    	bsa_op_cd = formObj.rdoOp_cd[1].value;
    }
    
	param = "f_cmd="+SEARCHLIST01;
	param = param+"&bsa_op_cd="+bsa_op_cd;
	param = param+"&code=carrier";
	var sXml = sheetObj.GetSearchXml("ESM_BSA_CODE.do", param);
	
	var arrXml = sXml.split("|$$|");
	if (arrXml.length > 0)
		ComXml2ComboItem(arrXml[0], formObj.cobCarrier, "code", "code");
	formObj.cobCarrier.Index = 0;
	
	// 초기 설정
    comboObjects[3].Code = "SML";
	sheetObj.WaitImageVisible = true;
  
}

//Carrier Combo Change
function cobCarrier_OnChange(obj) {
    var sheetObject1 = sheetObjects[0];
    var sheetObject2 = sheetObjects[2];
    var formObj = document.form;
    
    
    if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
    	sheetObject1.CellValue2(0,"M_crr_bsa_capa") = obj.Code;
    } else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
    	sheetObject2.CellValue2(0,"M_crr_bsa_capa") = obj.Code;
    }

}

// Header Setting
function setHeaderTitle() {
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	var sheetObject3 = sheetObjects[2];
	var sheetObject4 = sheetObjects[3];
	var formObject = document.form;

	var strTypeText  = "";

	var obj = formObject.rdoType;
	for(var i=0; i<obj.length; i++) {
		if (obj[i].checked) {
    		strTypeText  = obj[i].text;
			break;
		}
	}
	var carrierObj = comboObjects[3];

	if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
		sheetObject1.CellValue2(0,"M_crr_bsa_capa")  = carrierObj.Code;
		sheetObject2.CellValue2(0,"D_port_bsa_capa") = strTypeText;
	} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
		sheetObject3.CellValue2(0,"M_crr_bsa_capa")  = carrierObj.Code;
		sheetObject4.CellValue2(0,"D_port_bsa_capa") = strTypeText;
	}
}

//화면의 Enter-Key 처리
function keyEnter_loc(){
	var sheetObject1 = sheetObjects[0];
	var sheetObject3 = sheetObjects[2];
	var formObject = document.form;
	if (event.keyCode == 13) {
		if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
			doActionIBSheet(sheetObject1,formObject,IBSEARCH);
		} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
			doActionIBSheet(sheetObject3,formObject,IBSEARCH);
		}
	}
}



