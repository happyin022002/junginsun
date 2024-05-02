/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0962.js
*@FileTitle : W/O 발행화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009-2-3
*@LastModifier : Bong-jun
*@LastVersion : 1.72
* 2006-11-21 poong_yeon
* 1.0 최초 생성
* 1.8 2010.11.29 이재위 [CHM-201006281-01] [TRS] VLCBB EDI(IFTMIN) 개발
=========================================================*/ 

/**
 * @class ESD_TRS_0962 : EDI RESEND
 */
function ESD_TRS_0962() {
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

var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	 var sheetObject = sheetObjects[0];

	 /*******************************************************/
	 var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

			case "btn_close":
				  window.close();
			  break;

			case "btng_edisend":
					if(formObject.ets_sts_flg.value == 'Y'){
						return;
					}					
				  resendEDI(sheetObject, formObject);
			 break;

		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('COM12111');
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
function setSheetObject(sheet_obj){

   sheetObjects[sheetCnt++] = sheet_obj;


}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	for(i=0;i<sheetObjects.length;i++){

	//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i],i+1);
	//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
}

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
				// 높이 설정
				style.height = 180;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msNone;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(10, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)
	
				var HeadTitle = "|EQ No|S/O No|W/O Issue Time|Ack/Nck|Ack/Nck\nReceived Time|Error MSG" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, false);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtCheckBox, 30,    daCenter,  false,    "ibcheck",        false,    "",         dfNone,     0,     true,        true);
				InitDataProperty(0, cnt++ , dtData,     100,   daCenter,  false,    "eq_no",        false,    "",         dfNone,     0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,      80,   daCenter,  false,    "trsp_so_ofc_cty_cd_seq",        false,    "",         dfNone,     0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,     100,   daCenter,  false,    "edi_iss_dt",        false,    "",         dfNone,     0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,     100,   daCenter,  false,    "edi_rcv_rslt_cd",        false,    "",         dfNone,     0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,     100,   daCenter,  false,    "edi_rcv_rslt_dt",        false,    "",         dfNone,     0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,     200,   daCenter,  false,    "edi_rcv_rslt_msg",        false,    "",         dfNone,     0,     false,       false);
								
				InitDataProperty(0, cnt++ , dtHidden,    0,   daCenter,  false,    "trsp_so_ofc_cty_cd",        false,    "",         dfNone,     0,     false,       false);
				InitDataProperty(0, cnt++ , dtHidden,    0,   daCenter,  false,    "trsp_so_seq",        false,    "",         dfNone,     0,     false,       false);
				InitDataProperty(0, cnt++ , dtStatus,   30,    daCenter,  false,   "ibflag",        false,    "",         dfNone,     0,     false,       false);
				
				ColHidden('ibflag') = true;
				
		   }
			break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {

	   case IBSEARCH:      //조회
			
			formObj.f_cmd.value = SEARCH03;
			sheetObj.DoSearch4Post("ESD_TRS_0024GS.do", TrsFrmQryString(formObj));
			break;
	}
	setDisplayForm(sheetObj,formObj);
}

// preview에서 조회
function resendEDI(sheetObj,formObj){
	var vseq = formObj.edi_vndr_seq.value 
	
	if(vseq == '102297'||vseq == '105121'||vseq == '155153'||vseq == '105147'||vseq == '135366'||vseq == '175368'||
			/* 1.19 N200904300130 - [TRS-EDI] VLCBB Work order EDI 개발 요청 - S/P 추가 */
			vseq == '120759'||vseq == '120852'||vseq == '121403'||vseq == '125140'||vseq == '166660'||
			vseq == '168242'||vseq == '172121'||vseq == '143046'||vseq == '166697'||vseq == '120849'||vseq == '181404'){
		if(formObj.edi_vndr_seq.value == '102297' ){
			formObj.f_cmd.value = SEARCH04;
			formObj.edi_loc.value = 'ASIA';
		}else if(vseq == '105121'||vseq == '155153'||vseq == '105147'||vseq == '135366'||vseq == '175368'||
				/* 1.19 N200904300130 - [TRS-EDI] VLCBB Work order EDI 개발 요청 - S/P 추가 */
				vseq == '120759'||vseq == '120852'||vseq == '121403'||vseq == '125140'||vseq == '166660'||
				vseq == '168242'||vseq == '172121'||vseq == '143046'||vseq == '166697'||vseq == '120849'||vseq == '181404'
		){
			formObj.f_cmd.value = SEARCH05;
			formObj.edi_loc.value = 'EUR';
		}
		
		formObj.edi_trsp_wo_ofc_cty_cd.value = formObj.trsp_wo_ofc_cty_cd.value.substring(0,3);
		formObj.edi_trsp_wo_seq.value = formObj.trsp_wo_ofc_cty_cd.value.substring(3);
		var queryStr = sheetObj.GetSaveString(true, false);
		sheetObj.DoSearch4Post("ESD_TRS_0024GS.do", queryStr+"&"+TrsFrmQryString(formObj));
	}else{
		ComShowMessage("Function is underdeveloped.");
	}
}

function setDisplayForm(sheetObj,formObj){
	var vseq = formObj.edi_vndr_seq.value 

	if(vseq != '102297'&&vseq != '105121'&&vseq != '155153'&&vseq != '105147'&&vseq != '135366'&&vseq != '175368'&&
			/* 1.19 N200904300130 - [TRS-EDI] VLCBB Work order EDI 개발 요청 - S/P 추가 */
			vseq != '120759'&&vseq != '120852'&&vseq != '121403'&&vseq != '125140'&&vseq != '166660'&&
			vseq != '168242'&&vseq != '172121'&&vseq != '143046'&&vseq != '166697'&&vseq != '120849'&&vseq != '181404'
	){
		document.all.btng_edisend.style.display = "none";
		document.all.btn1_right_r.style.display = "none";
		document.all.btn1_left_r.style.display = "none";
	}
}


/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet1_OnSearchEnd(sheetObj, errMsg) {
	
	var formObj = document.form;

	if( errMsg != null && errMsg != '' ) {
		ComShowMessage(errMsg);
	} else {
		if(formObj.f_cmd.value == SEARCH02 || formObj.f_cmd.value == SEARCH04){
			ComShowCodeMessage('TRS90208');
		}
	}
}

/**
 * sheet의 OnChange 이벤트 정의
 */
function sheet1_OnChange(sheetObj, row, col, value)
{
	var colName = sheetObj.ColSaveName(col);
	var formObj = document.form;

	switch(colName)
	{
		case('ibcheck'):
			
			if( formObj.edi_vndr_seq.value == '102297' ){
				for(var i=1; i<sheetObj.RowCount+1; i++){
					sheetObj.CellValue2(i, 'ibcheck') = value;
				}
			}
			break;
	}
}