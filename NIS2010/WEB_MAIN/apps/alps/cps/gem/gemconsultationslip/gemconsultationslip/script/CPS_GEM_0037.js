/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CPS_GEM_0037.js
*@FileTitle : Consultation Slip -Preview
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.10
*@LastModifier : HongSeongPil
*@LastVersion : 1.0
* 2016.06.10 HongSeongPil
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
 * @class CPS_GEM_0037 : CPS_GEM_0037 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function CPS_GEM_0037() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.setTabObject 			= setTabObject;
	this.validateForm 			= validateForm;
}
    
/* 개발자 작업	*/

//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0;

var comboObjects = new Array();
var comboCnt = 0 ; 

var rdObjects = new Array();
var rdCnt = 0;
var approvalFlg = "";

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject 	= sheetObjects[0];
	/*******************************************************/
	var formObject = document.form; 
	var rdObject = rdObjects[0];
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {
			case "btng_close":
				window.close();
				break;
			case "btng_print":					
				rdObject.CMPrint(); // 기본 프린터로 출력
				break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage("COM12111");
		} else {
			ComShowCodeMessage(e);
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
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	rdOpen();	
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
			style.height = GetSheetHeight(13);
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
			
			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 1, 1, 9, 100);
			
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(9, 1, 0, true);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false)
			
			var HeadTitle = "Seq.||Invoice No.|Net Amount|Tax Amount|Total Amount" ;
			
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  					KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			
			InitDataProperty(0, cnt++ , dtHiddenStatus,	 			1,		daRight,		false,    "ibflag",				false,			"",			dfNone,					0,			false,			false	);
		}
		break;    
	}
}

  // Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:      //조회
			formObj.f_cmd.value = SEARCHLIST;                  
			break; 
		case IBCOPYROW:        //행 복사
			sheetObj.DataCopy();
			break
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
    }
    return true;
}
    
function initRdConfig(rdObject){
	var Rdviewer = rdObject ;
	
	Rdviewer.AutoAdjust = true;
	Rdviewer.ViewShowMode(0);
	
	Rdviewer.setbackgroundcolor(128,128,128);
	Rdviewer.SetPageLineColor(128,128,128);
}

/**
 * MInimize 클릭시 이벤트 관련
 */
function Minimize(nItem){
	var objs = document.all.item("showMin");

	if ( nItem == "1" )
	{
		objs.style.display = "none";
		sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(20);
		sheetObjects[0].focus();
		sheetObjects[0].ViewRows  =20; 
	}
	else
	{
		objs.style.display = "inline";
		sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(10);
		sheetObjects[0].focus();
		sheetObjects[0].ViewRows  =10;
	}
}

function rdOpen(){
	var sXml = "";		
	var i=0;
	var j=0; 
	var opener_obj = window.dialogArguments;	
	var opener_sheet_obj =  opener_obj.document.sheet1;
	
	var fromObj = new Array();
	var rdObj = new Array();
				
	fromObj[0] = document.form;                            // RD 로 보내기 위해 배열로담는다
	rdObj[0] = opener_sheet_obj;     
	 
	sXml = "<?xml version='1.0' ?><SHEET>";
	sXml += "<ETC>";
	
	if(p_gen_expn_rqst_tp_cd == "I"){
		sXml += "    <GENEXPNRQSTTPCD>"  + "Input date" + "</GENEXPNRQSTTPCD>";
	}else if(p_gen_expn_rqst_tp_cd == "E"){
		sXml += "    <GENEXPNRQSTTPCD>"  + "Invoice Date" + "</GENEXPNRQSTTPCD>";
	}else if(p_gen_expn_rqst_tp_cd == "A"){
		sXml += "    <GENEXPNRQSTTPCD>"  + "Approval Date" + "</GENEXPNRQSTTPCD>";
	}
	           
	sXml += "    <PERIODSTDT>"       + p_period_stdt         + "</PERIODSTDT>";          
	sXml += "    <PERIODEDDT>"       + p_period_eddt         + "</PERIODEDDT>";              
	sXml += "    <CSRNO>"            + p_csr_no              + "</CSRNO>";              
	sXml += "    <OFCLVL1>"          + p_ofc_lvl1            + "</OFCLVL1>";              
	sXml += "    <OFCLVL2>"          + p_ofc_lvl2            + "</OFCLVL2>";              
	sXml += "    <OFCLVL3>"          + p_ofc_lvl3            + "</OFCLVL3>";              
	sXml += "    <SUBSEXPNNM>"       + p_subs_expn_nm        + "</SUBSEXPNNM>";
	sXml += "    <EXPNDIVCD>"        + p_expn_div_cd         + "</EXPNDIVCD>";      
	sXml += "    <STATUS>"           + p_status              + "</STATUS>";
	sXml += "</ETC>";
	
	sXml +=RD_GetDataSearchXml(rdObj[i],1); 					
	sXml +="</SHEET>"; 
	if ( rdObj[0].RowCount  == "0")                     // RD 로 보낼 sheet 에 데이타가 없으면 Error
	{
		ComShowCodeMessage("No Data Found");
		return;
	}
	
	fromObj[0].test.value = sXml;
	
	//RD_path = "http://siy:7001/hanjin/";
	rdObjects[0].AutoAdjust = true;
	rdObjects[0].HideToolbar();
	rdObjects[0].HideStatusbar();
	rdObjects[0].ViewShowMode(2);
			
	rdObjects[0].setbackgroundcolor(255,255,255);
	rdObjects[0].SetPageLineColor(255,255,255);								
	
	rdObjects[0].SetRData(sXml); 
	//Real 
	rdObjects[0].FileOpen(RD_path+'apps/alps/cps/gem/gemconsultationslip/gemconsultationslip/report/CPS_GEM_0037.mrd', ''); 
	//Local
	//rdObjects[0].FileOpen("http://localhost:7001/hanjin/apps/alps/cps/gem/gemconsultationslip/gemconsultationslip/report/CPS_GEM_0037.mrd", ''); 	
}

/* 개발자 작업  끝 */