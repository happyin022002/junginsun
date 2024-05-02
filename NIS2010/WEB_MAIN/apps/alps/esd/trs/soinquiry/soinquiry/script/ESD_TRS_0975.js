/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0975.js
*@FileTitle : S/O History Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2011-06-28
*@LastModifier : eunju Son
*@LastVersion : 1.0 
* 2011-06-28 eunju Son
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2011.06.28 손은주 [CHM-201111573-01]	[TRS] S/O history function 추가 요청
* 2012.03.13 최종혁 []	 s/o history 화면의 철자 교정 
=========================================================*/



function ESD_TRS_0975() {
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

			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
    				
    	    case "btn_close":
    	        window.close();
    	        break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage("TRS90392");
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
				style.height = GetSheetHeight(16) ;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 2, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(24, 4 , 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)

				var HeadTitle = "Seq.|S/O No.|Event|Event Date\n(Local)|TRS|TRS|TRS|SCE|SCE|SCE|CNTR No.|CNTR\nTP/SZ|BKG No.|W/O No.|Invoice No|Invoice\nVendor Seq|COP NO|A/G SEQ|A/G CODE|Unplanned|DESC|Event User ID|Office|Recording\nSystem";
				var HeadTitle1 = "Seq.|S/O No.|Event|Event Date\n(Local)|S/O Status|S/O Route|Route Replan|S/O Status|S/O Route|Unmatched|CNTR No.|CNTR\nTP/SZ|BKG No.|W/O No.|Invoice No|Invoice\nVendor Seq|COP NO|A/G SEQ|A/G CODE|Unplanned|DESC|Event User ID|Office|Recording\nSystem";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				InitHeadRow(1, HeadTitle1, false);
				
				HeadRowHeight = 20 ;


				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,       37,    daCenter,   true,    "seq",     			false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       78,    daCenter,   true,    "so_no",     			false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       80,    daCenter,   true,    "event",     			false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       110,   daCenter,   true,    "locl_cre_dt",     	false,          "",       dfNone,          0,     false,       false);
				
				InitDataProperty(0, cnt++ , dtData,       67,    daCenter,   true,    "trsp_so_sts_cd", 	false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       150,   daLeft,   	 true,    "so_rout_desc",   	false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,        80,   daCenter,   true,    "rout_rpln_flg",   	false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       67,    daCenter,   true,    "cop_so_sts_cd",  	false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       150,   daLeft,     true,    "cop_so_rout_desc",	false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       74,    daCenter,   true,    "rpln_umch_flg",     	false,          "",       dfNone,          0,     false,       false);
				
				InitDataProperty(0, cnt++ , dtData,       80,    daCenter,   true,    "eq_no",     			false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       40,    daCenter,   true,    "eq_tpsz_cd",     	false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       90,    daCenter,   true,    "bkg_no",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       90,    daCenter,   true,    "wo_no",     			false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       100,   daCenter,   true,    "inv_no",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   true,    "inv_vndr_seq",   	false,          "",       dfNone,          0,     false,       false);

				InitDataProperty(0, cnt++ , dtData,       110,   daCenter,   true,    "cop_no",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   true,    "cost_act_grp_seq",   false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   true,    "cost_act_grp_cd",    false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   true,    "upln_so_flg",     	false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       250,   daLeft,   true,      "trsp_so_his_desc",   false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       81,    daCenter,   true,    "cre_usr_id",     	false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       81,    daCenter,   true,    "cre_ofc_cd",     	false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       60,    daCenter,   true,    "rqst_src_sys_cd",   	false,          "",       dfNone,          0,     false,       false);	
		   }
			break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {

	   case IBSEARCH:      //조회
			formObj.f_cmd.value = SEARCH04;
			sheetObj.DoSearch4Post("ESD_TRS_0019GS.do", TrsFrmQryString(formObj));
			break;
	}
}
