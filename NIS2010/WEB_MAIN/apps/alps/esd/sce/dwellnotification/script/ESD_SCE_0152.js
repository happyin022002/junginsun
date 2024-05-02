/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : ESD_SCE_0152.js
 *@FileTitle : Dwell/Delay Notification Sending Status Detail
 *Open Issues :
 *@LastModifyDate : 2011.07.25
 *@LastModifier : 이수진
 *@LastVersion : 1.0
 * 2011.07.25 이수진
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 =========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author SM LINE
 */

/**
 * @extends
 * @class ESD_SCE_0152 : ESD_SCE_0152 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */


function ESD_SCE_0152() {
	this.processButtonClick = tprocessButtonClick;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}

/* 개발자 작업 */
//공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {		
		case "btn_close":
			window.close();
			
			break;
			
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

// 화면 오픈시 핸들
function initControl() {
}

/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
 
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

 
/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {

		for (i = 0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		
}
 

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
 
 function initSheet(sheetObj, sheetNo) {	 

		var cnt = 0;

		switch (sheetNo) {
		case 1: 
			
			with (sheetObj) {
				// 높이 설정
				style.height = 400;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msNone;

				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 4, 100);

				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(7, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false, false)

				var HeadTitle = "|Date|96hrs Terminal Dwell|48hrs Enroute Dwell|72hrs Destination Dwell|24hrs Vessel Delay|";

				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
				// SAVESTATUS, FORMATFIX]
				
				InitDataProperty(0, cnt++ , dtHiddenStatus,  0, 	daCenter,  	false,    "ibflag");     
	            InitDataProperty(0, cnt++ , dtData, 		170,	daCenter,	true,     "eml_snd_dt_desc", false,    "",  dfNone, 0,   false,	false);
	            InitDataProperty(0, cnt++ , dtData, 		170,    daCenter,	true,     "t96_cnt",  	false,    "",  dfNone, 0,   false,	false);            
	            InitDataProperty(0, cnt++ , dtData, 		170,	daCenter,	true,     "e48_cnt", 	false,    "",  dfNone, 0,   false,	false);
	            InitDataProperty(0, cnt++ , dtData, 		170,    daCenter,	true,     "d72_cnt", 	false,    "",  dfNone, 0,   false,	false);
	            InitDataProperty(0, cnt++ , dtData, 		170,	daCenter,	true,     "v24_cnt", 	false,    "",  dfNone, 0,   false,	false);
	            InitDataProperty(0, cnt++ , dtHidden, 		170,	daCenter,	true,     "eml_snd_dt", false,    "",  dfNone, 0,   false,	false);
	            
	            
	            DataLinkMouse('eml_snd_dt_desc') = true;
	            WaitImageVisible=false;
			}
			break;
		}
	}


//Sheet관련 프로세스 처리

function doActionIBSheet(sheetObj, formObj, sAction) {
//	sheetObj.ShowDebugMsg = 1;
	switch (sAction) {
	case IBSEARCH:		
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH ;
		sheetObj.DoSearch4Post("ESD_SCE_0152GS.do", SceFrmQryString(formObj));	
		break;

	
	
	case IBSEARCH_ASYNC01:      //조회
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH;
	  	sheetObj.DoSearch4Post("ESD_SCE_0152GS.do", SceFrmQryString(formObj));

	break;
	
	case COMMAND01:      //SC_No Retrieve
		formObj.f_cmd.value = COMMAND01;
		var sXml = sheetObj.GetSaveXml("ESD_SCE_0152GS.do", FormQueryString(formObj));
	  	document.form.sc_no.value = ComGetEtcData(sXml, "sc_no");

	break;
	
	}
		
}

function sheet1_OnDblClick(sheetObj ,Row, Col){
	
     var formObj = document.form;
     
    var colName = sheetObj.ColSaveName(Col);
    var dtValue = sheetObj.CellValue(Row,Col);
    switch(colName) {
    case "eml_snd_dt_desc":
     
		var queryStr= 'eml_snd_dt='+sheetObj.CellValue(Row,'eml_snd_dt').replace(".","").replace(".","")+"&cust_cd="+formObj.cust_cd.value +"&dwll_tp=";
		//var strPath   =  "apps/alps/esd/sce/dwellnotification/report/ESD_SCE_0152.mrd";
		
		window.showModalDialog("ESD_SCE_0156.do?"+queryStr,self, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:1000px;dialogHeight:800px");
		break;
    case "t96_cnt":
    	if (parseInt(dtValue) > 0) {
    		var queryStr= 'eml_snd_dt='+sheetObj.CellValue(Row,'eml_snd_dt').replace(".","").replace(".","")+"&cust_cd="+formObj.cust_cd.value +"&dwll_tp=" + "T96";
    		window.showModalDialog("ESD_SCE_0156.do?"+queryStr,self, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:1000px;dialogHeight:800px");
    	}
    	break;
    case "e48_cnt":
    	if (parseInt(dtValue) > 0) {
    		var queryStr= 'eml_snd_dt='+sheetObj.CellValue(Row,'eml_snd_dt').replace(".","").replace(".","")+"&cust_cd="+formObj.cust_cd.value +"&dwll_tp=" + "E48";
    		window.showModalDialog("ESD_SCE_0156.do?"+queryStr,self, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:1000px;dialogHeight:800px");
    	}
    	break;
    case "d72_cnt":
    	if (parseInt(dtValue) > 0) {
    		var queryStr= 'eml_snd_dt='+sheetObj.CellValue(Row,'eml_snd_dt').replace(".","").replace(".","")+"&cust_cd="+formObj.cust_cd.value +"&dwll_tp=" + "D72";
    		window.showModalDialog("ESD_SCE_0156.do?"+queryStr,self, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:1000px;dialogHeight:800px");
    	}
    	break;
    case "v24_cnt":
    	if (parseInt(dtValue) > 0) {
    		var queryStr= 'eml_snd_dt='+sheetObj.CellValue(Row,'eml_snd_dt').replace(".","").replace(".","")+"&cust_cd="+formObj.cust_cd.value +"&dwll_tp=" + "V24";
    		window.showModalDialog("ESD_SCE_0156.do?"+queryStr,self, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:1000px;dialogHeight:800px");
    	}
    	break;
    	
    }
}

/**
 * Search후 이벤트처리
 * @param sheetObj
 * @return
 */
function sheet1_OnSearchEnd(sheetObj)
{    
	var idx = coSceSaveNameCol(sheetObj, 'eml_snd_dt_desc');
	var rowcount = sheetObj.RowCount;	
	sheetObj.ColFontUnderline('eml_snd_dt_desc') = true;
	sheetObj.ColFontColor('eml_snd_dt_desc')= sheetObj.RgbColor(0, 0, 255);
	sheetObj.RangeFontBold(1,idx,rowcount,idx)=true;

	var sIdx = coSceSaveNameCol(sheetObj, 't96_cnt');
	var eIdx = coSceSaveNameCol(sheetObj, 'v24_cnt');
	for (var i = 1; i < rowcount ; i ++ ) {
		for (var j = sIdx; j <= eIdx; j++) {
			if (parseInt(sheetObj.CellValue(i,j)) > 0 ) {
				sheetObj.CellFont("FontUnderLine", i,j) = true;
				sheetObj.CellFont("FontColor", i,j)= sheetObj.RgbColor(0, 0, 255);
				sheetObj.CellFont("FontBold", i,j) =true;
			}
		}
	}

	ComOpenWait(false);
}

/**
 * Sheet Load후 이벤트 처리
 * @param sheetObj
 * @return
 */
function sheet1_OnLoadFinish(sheetObj)
{
    var formObj = document.form;
    doActionIBSheet(sheetObj,formObj,COMMAND01);
	doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC01);

}
