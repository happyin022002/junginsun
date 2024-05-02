/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : COM_CSR_0015.js
*@FileTitle : CSR ERP Transfer
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.17
*@LastModifier : kim young shin
*@LastVersion : 1.0
* 2014.12.17
* 1.0 Creation
* ----------------------------------------------------------
* History
* 2014.03.13 심성윤 Alps 데이터 결제처리 기능 추가
* 2014.03.16 심성윤 체크박스 기능 추가(정상 결재는 체크 되지 않음)
* 2014.03.18 심성윤 체크된 항목 + 결재 조건 체크 로직 추가
=========================================================*/
/**
 * @extends
 * @class COM_CSR_0015 : COM_CSR_0015 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function COM_CSR_0015() {
	this.processButtonClick		= processButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.validateForm 			= validateForm;
}

//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;



// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function processButtonClick(){

    var sheetObject = sheetObjects[0];
    
    /*******************************************************/
    var formObject = document.form;
    
    try {
		var srcName = window.event.srcElement.getAttribute("name");
		 

		switch (srcName) {

		case "btng_retrieve":
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			//처음에 막고 시작
			var rowno = sheetObjects[0].Rows - 1; // 데이터 행의 개수

			var flagSts = "";
			var errSts = "";
			for ( var i = 0; i < rowno; i++) {
				flagSts = sheetObjects[0].CellValue(i + 1, 'if_flg');
				errSts = sheetObjects[0].CellValue(i + 1, 'corr_his_rmk');
				
				if (flagSts == "Y") {
					// I/F Flag 값이 Y이면 각 행의 첫번째 칼럼(체크박스) 수정 불가
					sheetObjects[0].CellEditable(i + 1, 1) = false;
				}// if
				if (errSts == "IE"){
					sheetObjects[0].RowBackColor(i + 1) = sheetObjects[0].RgbColor(255,178,217);
				}
			}// for			
			break;

		case "btng_interface":
			if (sheetObjects[0].RowCount <= 0) {				
				showErrMessage(getMsg('CSR25006'));// showErrMessage('조회된 data가
													// 없습니다.');
				return false;
			}
			if (sheetObjects[0].SelectRow == undefined
					|| sheetObjects[0].SelectRow == null
					|| sheetObjects[0].SelectRow == 0) {				
				showErrMessage(getMsg('CSR21908'));// showErrMessage('선택된 row가
													// 없습니다.');
				return false;
			}
			if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow, 'csr_no') == undefined
					|| sheetObjects[0].CellValue(sheetObjects[0].SelectRow,
							'csr_no') == null
					|| sheetObjects[0].CellValue(sheetObjects[0].SelectRow,
							'csr_no').trim() == '') {				
				showErrMessage(getMsg('CSR40048')); // showErrMessage('선택된 row에
													// CSR No.가 없습니다.'); 
				return false;
			}
			
			var flag = false; 			
			var tpCd = "";
			var flagSts = "";
			//검색된 데이터들 중에서 1.Check된 ROW 확인, 2. I/F Flag가 Y가 아닌, 3. Apro Type이 GW 또는 AL일 때 IBSAVE 실행
			var apCheckRow = sheetObjects[0].FindCheckedRow("apro_chk");
			//arrRow : check된 row의 위치를 저장한 배열
			var arrRow = apCheckRow.split("|");			
			if (arrRow.length != 1) {
				for ( var i = 0; i < arrRow.length - 1; i++) {

					tpCd = sheetObjects[0].CellValue(arrRow[i],	'csr_apro_tp_cd');
					flagSts = sheetObjects[0].CellValue(arrRow[i], 'if_flg');

					if (flagSts != "Y") {
						if (tpCd == "GW" || tpCd == "AL") {

							flag = true;

						} else {
							flag = false;
							showErrMessage("Wrong Apro Type!!!");
							break;
						}
					} else {
						flag = false;
						showErrMessage("This CSR is approved successfully!! Check another CSR!!! ");
						break;
					}
				}
			}else{
				flag = false;
				showErrMessage("선택된 항목이 없습니다.");
				break;
			}			
		if(flag){
			showErrMessage((arrRow.length-1)+"건이 전송 됩니다.");
			if (confirm('쏠래?')){
				doActionIBSheet(sheetObject, formObject, IBSAVE);	
			}	
		} 
	}}catch(e) {
		if( e == "[object Error]") {
			showErrMessage(getMsg('CSR23028')); //ComShowMessage(OBJECT_ERROR);
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

function loadPage() {
	
	
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet(sheetObjects[i]);

        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    
}


function initSheet(sheetObj,sheetNo) {

    var cnt = 0;

    switch(sheetNo) {
         case 1:      //sheet1 init
            with (sheetObj) {
                // 높이 설정
                style.height = 370;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false] 
                Editable = true;
                
                MultiSelection = false;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 10, 100);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				 InitColumnInfo(14, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false,false);

				var HeadTitle1 = "||CSR No.|Payment S/P|Payment S/P|I/F Flag|I/F Status\nUpdated Time|Error Reason|Currency|Total Amount|USD Amount|Payment\nDue Date|Apro Type|Error Check" ;

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                sheetObj.FrozenCols = 2;
                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,       20,     daCenter , false,   "ibflag",     false,          "");				
				InitDataProperty(0, cnt++ , dtCheckBox,           30,     daCenter , true,   "apro_chk",     false,          "");
				InitDataProperty(0, cnt++ , dtData,	150, daCenter,			false,    "csr_no",				false,			"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	60, daCenter,			false,    "vndr_no",			false,			"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData, 150, daLeft,			false,    "inv_desc",			false,			"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData, 70, daCenter,			false,    "if_flg",				false,			"",			dfNone,			0,			false,			false	);  	
				InitDataProperty(0, cnt++ , dtData,	110,	daCenter,		    false,    "if_dt",				false,			"",			dfDateYmd,		0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	200, daLeft,			false,    "if_err_rsn",			false,			"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	80, daCenter,			false,    "csr_curr_cd",		false,			"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	100, daRight,			false,    "csr_amt",			false,			"",			dfFloat,		2,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	100, daRight,			false,    "csr_usd_amt",		false,			"",			dfFloat,		0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	80,	daCenter,		    false,    "due_dt",				false,			"",			dfDateYmd,		0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData, 100, daCenter,			false,    "csr_apro_tp_cd",		false,			"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,       20,     daCenter , false,   "corr_his_rmk",     false,          "",			dfNone,			0,			false,			false	);
				
				InitDataCombo(0, "csr_apro_tp_cd", "G/W|ALPS", "GW|AL");
         	}
            break;
    }
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;

    switch(sAction) {
       case IBSEARCH:      //조회
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("COM_CSR_0015GS.do", FormQueryString(formObj));
		    break;
		    
       case IBSAVE:        //전송
    	    
			formObj.f_cmd.value = MULTI;
			var param = sheetObj.GetSaveString(false,true,1);
			var sXml = sheetObj.GetSaveXml("COM_CSR_0015GS.do", "f_cmd="+ComGetObjValue(formObj.f_cmd)+"&"+ param);
			sheetObj.LoadSaveXml(sXml,true);
			retrieve();
            break;
      
    }
}

function retrieve() {	
	var formObject = document.form;
	doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
}
