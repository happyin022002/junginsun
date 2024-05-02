/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_BSA_0123.js
*@FileTitle : BSA Creation VVD Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
*=========================================================
* History :
* 2015.03.20 김용습 [CHM-201534945] - BSA CREATION 화면 / "VVD INQUIRY" 기능 개선 요청
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
 * @class ESM_BSA_0023 : ESM_BSA_0023 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BSA_0123() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.validateForm 			= validateForm;
}
    
// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;


var comboObjects = new Array();
var comboCnt = 0;
var loadingMode = false;


/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

	    	case "btn_Retrieve":
	    		doActionIBSheet(sheetObject, formObject, IBSEARCH);
	    		break;

	    	case "btn_Close":
	    		self.close();
	        break;

	    	case "btn_OK":
				formObj = document.form;
				try {
					var chkRows = null;
					with(sheetObjects[0]){
					    chkRows = FindCheckedRow("radio");
					    if(chkRows == ""){
	        			    //하나도 선택을 안하면 에러 메시지만 보여준다.
	        			    ComShowCodeMessage('BSA10026','VVD');
	        			    return;
	        		    }
					    var arys = chkRows.split("|");
					    var vvd = CellValue(Number(arys[0]),"vvd_code")
					    opener.getESM_BSA_0123(CellValue(Number(arys[0]),"vvd_code"), formObject.popup_row.value, formObject.rdoOp_cd.value);

					    self.close(); 
					}
				} catch (e1) {
					if (e1 == "[object Error]") {
						alert("정보를 돌려 받을 수 없습니다.");
					} else {
						alert(e);
					}
				}
	    	break;
	    	
	    	case "btns_calendar1":
				var cal = new ComCalendar();
				cal.select(formObject.txtSDate, 'yyyy-MM-dd');
				break;
	
			case "btns_calendar2":
				var cal = new ComCalendar();
				cal.select(formObject.txtEDate, 'yyyy-MM-dd');
				break;
		}
	}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(ComGetMsg("COM12111","",""));
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
	 * IBCombo Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
//	function setComboObject(combo_obj){
//		comboObjects[comboCnt++] = combo_obj;
//	}
	
	/**
	* IBSheet의 콤보 컬럼에 데이터를 setting한다. <br>
	*/
//	function setIBMultiCombo(sheetObj, sXml ,objName){
//		if (sXml == undefined || sXml == ""){
//			return;
//		}
//		var arrData = ComCoaXml2SheetMultiComboString(sXml, "code", "code");
//		sheetObj.InitDataCombo(0,objName, arrData[1], arrData[0],"","");		
//	}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	
	if(document.form.txtEDate.value == 'undefined'){
		document.form.txtEDate.value = '';
	}
	
	for (i=0; i<sheetObjects.length; i++) {
		
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i+1, "");
		ComEndConfigSheet(sheetObjects[i]);
		
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}

	
	// 멀티콤보 처리
//	loadingMode = true;
//	loadCombo();
//	
//	for(k=0;k<comboObjects.length;k++){
//		initCombo(comboObjects[k],comboObjects[k].id);
//	}
//	loadingMode = false;

	//doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);  //Load시 조회
}

//function loadCombo() {
//	var formObj = document.form;
//		var sXml = formObj.sXml.value;
//
//		var arrXml = sXml.split("|$$|");
//		
//		if (arrXml.length > 0)
//		ComXml2ComboItem(arrXml[0], formObj.cobTrade, "code", "code");
//	if (arrXml.length > 1)
//		ComXml2ComboItem(arrXml[1], formObj.cobLane, "code", "code");
//	if (arrXml.length > 2)
//		ComXml2ComboItem(arrXml[2], formObj.cobDir, "code", "code");
//		document.form.sXml.value="";
// }

/**
* 콤보 항목을 설정한다. by.yjjeon
*/
//function initCombo (comboObj, comboNo) {
//	with (comboObj) {
//		DropHeight = 300;
//		comboObj.InsertItem(0, 'All' ,''); 
//		Index = 0;
//	}
//}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo,header) {
	var arrHeader = "";
	var cnt = 0;
	switch(sheetNo) {
		case 1:      //sheet1 init
			with (sheetObj) {
            // 높이 설정
            style.height = GetSheetHeight(7) ;
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

            //전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo( 1, 1, 9, 5000);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(11, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, true, true, false,false)

            var HeadTitle = "|SEQ|Trade|R.Lane|Vessel Name|VVD|S.Lane|1st Loading ETD|VSL Capa|OPR|CRR" ;            

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);

            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtRadioCheck,  	20,		daCenter,  false,  	"radio",		false,          "",       dfNone,   	0,     true,       true);
            InitDataProperty(0, cnt++ , dtSeq,      	27,		daCenter,  true,    "seq",			false,          "",       dfNone,   	0,     false,       true);

            InitDataProperty(0, cnt++ , dtData,      	50,		daCenter,  false,	"trade_cd",		false,          "",       dfNone,       0,     false,       true);
            InitDataProperty(0, cnt++ , dtData,      	50,		daCenter,  false,	"rlan_cd",		false,          "",       dfNone,       0,     false,       true);
            InitDataProperty(0, cnt++ , dtData,      	150,   	daCenter,  false,	"vsl_eng_nm",	false,          "",       dfNone,       0,     false,       true);
            InitDataProperty(0, cnt++ , dtData,      	100,   	daCenter,  false,	"vvd_code",		false,          "",       dfNone,       0,     false,       true);
            InitDataProperty(0, cnt++ , dtData,      	50,    	daCenter,  false,	"slan_cd",		false,          "",       dfNone,       0,     false,       true);
            InitDataProperty(0, cnt++ , dtData,      	130,   	daCenter,  false,	"n1st_lodg_etd",false,          "",       dfNone,       0,     false,       true);
            InitDataProperty(0, cnt++ , dtData,      	70,   	daCenter,  false,	"vsl_capa",		false,          "",    	  dfNone,       0,     false,       true);
            InitDataProperty(0, cnt++ , dtData,      	50,		daCenter,  false,	"opr_cd",		false,          "",       dfNone,       0,     false,       true);
            InitDataProperty(0, cnt++ , dtData,      	50,		daCenter,  false,	"crr_cd",		false,          "",       dfNone,       0,     false,       true);
            
            // Space charter인 경우 VSL Capa 숨김
            if(document.form.rdoOp_cd.value=="S"){
					ColHidden(8)=true;
			}
		}
        break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {

    	case IBSEARCH:      //조회
    		
    		if(formObj.txtSDate.value == "" &&
    			formObj.cobTrade.value == "" && 
    			formObj.cobLane.value == "" &&
    			formObj.cobDir.value == "" &&
    			formObj.cobCapa.value == "" ) // 검색 조건 없이는 조회 안되게 함
    			{
    				return false;
    			}
    		
    		formObj.f_cmd.value = SEARCHLIST;
    		var sXml = sheetObjects[0].GetSearchXml("ESM_BSA_0123GS.do", bsaFormString(formObj,getParam('ESM_BSA_0123')));
    		sheetObjects[0].LoadSearchXml(sXml);
    		break;
		}
}


//function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
//	
//		for (var k=0; k<12; k++) {
//			sheetObj.CellBackColor(1,k) = sheetObj.RgbColor(189,189,189);
//		}		
//		
////	with (sheetObj) {
////		if (LastRow > 0) {
////			for (var k=0; k<LastCol; k++) {
////				if (CellValue(0,k) == "SML") {
////					CellBackColor(0,k) = RgbColor(222,251,248);
////				}
////			}
////		}
////
////		for (var i=1; i<LastRow+1; i++) {
////			for (var j=1; j<LastCol+1; j++) {
////				if (ColSaveName(j).substring(0,10)  == "D_aply_flg") {
////					if (CellValue(i,j) == "1") {
////						CellEditable(i,j) = false;
////					} else if (CellValue(i,j) == "0") {
////						CellEditable(i,j) = true;
////					}
////				}
////				if (CellValue(0,j) == "SML") {
////						CellEditable(i,j) = false;
////				}
////			}
////		}
////	}
////	
////	ComOpenWait(false);
//}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction) {
	switch (sAction) {
		case IBSAVE:		

			if (!sheetObj.IsDataModified) {
				ComShowCodeMessage("BSA00004");
				return false;
			}
				
			if (sheetObj.IsDataModified && sheetObj.GetSaveString() == "") {
				return false;
			}
		
			break;
	}
	return true;
}

/**
* trade코드 변경시 rLane 리스트를 리플래쉬 한다.
*/
//function cobTrade_OnChange(obj) {
//	if (loadingMode == true) return; 
//	var formObj = document.form;
//	var sheetObj = sheetObjects[0];
//	var param = "";
//	var trd_cd = "";
//	sheetObj.WaitImageVisible = false;
//	
//	if(obj.Text != ""){
//		trd_cd = obj.Code;
//		param = "f_cmd="+SEARCHLIST01;
//		param = param+"&trd_cd="+trd_cd;
//		param = param+"&code=rLane";
//		var sXml = sheetObj.GetSearchXml("ESM_BSA_CODE.do", param);
//		
//		var arrXml = sXml.split("|$$|");
//		if (arrXml.length > 0)
//			ComXml2ComboItem(arrXml[0], formObj.cobLane, "code", "code");
//		formObj.cobLane.Index = 0;
//	}
//	sheetObj.WaitImageVisible = true;
//}


