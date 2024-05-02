/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESD_TRS_0270.js
 *@FileTitle : Delivery Monitor Detail
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
===============================================================================
 History

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
 * @extends 
 * @class ESD_TRS_0270 : ESD_TRS_0270 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_TRS_0270() {
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

/* 공통전역변수 */
//var calPop = new ComCalendarGrid();
var curTab = 1;
var beforetab = 0;
var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0;
var comboObjects = new Array();
var comboCnt = 0 ;
var rdObjects = new Array();

var allClickFlg = false;
var request = null;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의  */
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

			case "btng_socreation":
			    doActionIBSheet(sheetObject,formObject,SEARCH10);
				break;

			case "btng_soinquiry":
			    doActionIBSheet(sheetObject,formObject,SEARCH11);
				break;

			case "btng_woissue":
			    doActionIBSheet(sheetObject,formObject,SEARCH12);
				break;

			case "btng_wopreview":
			    doActionIBSheet(sheetObject,formObject,SEARCH13);
				break;

			case "btng_downxcel":
			    doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL, "");
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
 * comSheetObject(id)에서 호출한다
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
function loadPage(){
	for(i=0;i<sheetObjects.length;i++){
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	//Initializing
	initControl();
}


/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 */
function initControl() {
//    axon_event.addListener('click', 'obj_click', 'manual');    		//Click
//    axon_event.addListener('keyup', 'obj_keyup', 'boo_bkg_no'); 		//Key Up
    axon_event.addListenerFormat('blur',    'obj_blur',     form);	//Blur
//    axon_event.addListenerFormat('focus',   'obj_focus',    form);	//Focus
    axon_event.addListenerFormat('keypress','obj_keypress', form);	//Key Press 
}


/**
 * HTML Control의 objClick이벤트에서 영문숫자만 입력 처리한다. <br>
 */
function obj_click() {
}


/**
 * HTML Control의 objKeyup이벤트에서 영문숫자만 입력 처리한다. <br>
 */
function obj_keyup() {
}


/**
 * HTML Control의 onBlur이벤트에서 Validation을 체크한다. <br>
 */
function obj_blur(){
	var elementObj = event.srcElement;
	var formObj = document.form;
}

/**
 * HTML Control의 onFocus이벤트에서 마스크 구분자를 제거한다. <br>
 */
function obj_focus(){
//            ComClearSeparator(event.srcElement);
}

/**
 * HTML Control의 onKeypress이벤트에서 숫자만 입력되게 한다. <br>
 */
function obj_keypress(){
	switch(event.srcElement.dataformat){
		case "engup":		//영문대문자
	 		ComKeyOnlyAlphabet('upper');
	 		break;
	 		
		case "engupnum":	//숫자+"영문대분자"입력하기
			ComKeyOnlyAlphabet('uppernum');
			break;

		case "num":			//숫자 입력하기
			ComKeyOnlyNumber(event.srcElement);
			break;
		
		case "engnum":		//숫자+"영문대소"입력하기
			ComKeyOnlyAlphabet('num'); 
			break;
			
		case "engupcomma":	//영문대문자+Comma
			ComKeyOnlyAlphabet('upper', '44');
	        break;
		
		default:
	}
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
				//높이 설정
				style.height = GetSheetHeight(28);
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;   //msAll / msPrevColumnMerge / msHeaderOnly

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 23);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false);

				var HeadTitle1 = 				"Sts||SEQ|S/O Office\n(SCEM)|S/O Office\n(TRS)|Week|Date|CY/Door|Bound|BKG No.|CNTR No.|CNTR\nTP/SZ|CNTR MVMT|CNTR MVMT|CNTR MVMT|CNTR MVMT|CNTR MVMT|BKG Route|BKG Route|BKG Route|BKG Route|S/O Route|S/O Route|S/O Route|S/O Route|S/O Route|S/O No.|S/O Creation\nDate|S/O Creation\nUser Name|W/O No.|W/O Issue\nDate|W/O Issue\nUser Name|S/P Code|S/P Name|Appt Time|Delivery Time|Match|LFD|Frustrate|Cop No|AG Seq|Conti Cd|Rail Cd|HJL YN|SO STS";
				var HeadTitle2 = 				"Sts||SEQ|S/O Office\n(SCEM)|S/O Office\n(TRS)|Week|Date|CY/Door|Bound|BKG No.|CNTR No.|CNTR\nTP/SZ|Current\nStatus|Current\nYard|Event Date|S/P Code|S/P Name|POR|POL|POD|DEL|From|Via|To|Door|Door Location\nName|S/O No.|S/O Creation\nDate|S/O Creation\nUser Name|W/O No.|W/O Issue\nDate|W/O Issue\nUser Name|S/P Code|S/P Name|Appt Time|Delivery Time|Match|LFD|Frustrate|Cop No|AG Seq|Conti Cd|Rail Cd|HJL YN|SO STS";

				var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 11, 0, true);
                
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);

				//데이터속성[		ROW,COL,	DATATYPE,    	 WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,						KEYFIELD, 	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT,	EDITLEN,	FULLINPUT,	SORTENABLE,	TOOLTIP,	ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, 	dtHiddenStatus,	20,	daCenter,	true,		"ibflag",   	false, 		"", 		dfNone, 	0, 			false, 		false,  		 0, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++ , dtCheckBox,		30, daCenter,   true,       "chk",			false);
				InitDataProperty(0, cnt++, 	dtSeq,   		40,	daCenter, 	true,    	"seq", 			false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		65,	daCenter, 	true,    	"sce_so_ofc_cd", 		false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		65,	daCenter, 	true,    	"trs_so_ofc_cd", 		false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		50,	daCenter, 	true,    	"yr_week", 		false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		110,daCenter, 	true,    	"pln_date", 	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtCombo,   		60,daCenter, 	true,    	"so_tp_cd",  	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		40,	daCenter, 	true,    	"bnd_cd",   	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		90,	daCenter, 	true,    	"bkg_no",   	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		90,	daCenter, 	true,    	"cntr_no",   	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		50,	daCenter, 	true,    	"cntr_tpsz_cd",   false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		50,	daCenter, 	true,    	"crnt_mvmt_sts_cd",   false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);				
				InitDataProperty(0, cnt++, 	dtData,   		60,	daCenter, 	true,    	"crnt_yd_cd",   false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   	   110,	daCenter, 	true,    	"evnt_dt",   	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		60,daCenter, 	true,    	"sp_cd",   		false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		100,daLeft, 	true,    	"sp_nm",      	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		45,daCenter, 	true,    	"por_cd",      	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		45,daCenter, 	true,    	"pol_cd",      	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		45,daCenter, 	true,    	"pod_cd",      	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		45,daCenter, 	true,    	"del_cd",      	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		60,daCenter, 	true,    	"fm_nod_cd",      	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		60,daCenter, 	true,    	"via_nod_cd",      	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		60,daCenter, 	true,    	"to_nod_cd",      	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		60,daCenter, 	true,    	"dor_nod_cd",      	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		100,daLeft, 	true,    	"dor_nm",      		false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		100,daCenter, 	true,    	"so_no",      		false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  	   110,daCenter, 	true,    	"so_cre_dt",      	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		100,daLeft, 	true,    	"so_cre_usr_nm",    false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		100,daCenter, 	true,    	"wo_no",      		false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  	   110,daCenter, 	true,    	"wo_cre_dt",      	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		100,daLeft, 	true,    	"wo_cre_usr_nm",    false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		60,daCenter, 	true,    	"vndr_seq",      	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		100,daLeft, 	true,    	"vndr_nm",      	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  	   110,daCenter, 	true,    	"apnt_dt",      	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  	   110,daCenter, 	true,    	"de_dt",      		false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,  		70,daCenter, 	true,    	"umch_flg",      	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  	   110,daCenter, 	true,    	"pkup_aval_dt",     false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		70,daCenter, 	true,    	"frst_flg",      	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,  		100,daCenter, 	true,    	"cop_no",      		false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,  		100,daCenter, 	true,    	"cost_act_grp_seq", false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,  		100,daCenter, 	true,    	"conti_cd",      	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,  		100,daCenter, 	true,    	"rail_cd",      	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,  		100,daCenter, 	true,    	"hjl_yn",      		false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,  		100,daCenter, 	true,    	"trsp_so_sts_cd",   false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataCombo(0, 'so_tp_cd', "CY|DR", "C|Z");
			}
			break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction, chkflg) {
	//sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:		//Retrieve
		    formObj.f_cmd.value = SEARCH02;
			formObj2 = opener.form2;
            sheetObj.DoSearch4Post("ESD_TRS_0270GS.do", TrsFrmQryString(formObj)+"&"+TrsFrmQryString(formObj2));
	   		break;
		case SEARCH10: //S/O Creation
			var cop_no = "";
			var ag_seq = "";
			var conti_cd = "";
			var ofc_cd = "";
			var so_tp_cd = "";
			var rail_cd = "";
			var bnd_cd = "";
			var bkg_no = "";
			var cntr_no = "";
			var so_sts_cd = "";
			var sUrl = "";

			var checkList = sheetObj.FindCheckedRow('chk');
        	var arrRow = checkList.split("|");
			if(checkList == ''){
				ComShowCodeMessage('COM12176');
				return false;
			}
			
			if(arrRow.length > 91){
				ComShowMessage("You can select up to 90.");
				return false;
			}
			
            for (i=0; i<arrRow.length-1; i++){ 
            	conti_cd = sheetObj.CellValue( arrRow[i] , "conti_cd" );
				ofc_cd = sheetObj.CellValue(arrRow[i], 'sce_so_ofc_cd');
				so_tp_cd = sheetObj.CellValue(arrRow[i], 'so_tp_cd');
				rail_cd = sheetObj.CellValue(arrRow[i], 'rail_cd');
				bnd_cd = sheetObj.CellValue(arrRow[i], 'bnd_cd');
				so_sts_cd = sheetObj.CellValue(arrRow[i], 'trsp_so_sts_cd');
				if( i == arrRow.length-2 ) {
					cop_no += sheetObj.CellValue(arrRow[i], 'cop_no');
					ag_seq += sheetObj.CellValue(arrRow[i], 'cost_act_grp_seq');
					bkg_no += sheetObj.CellValue(arrRow[i], 'bkg_no');
					cntr_no += sheetObj.CellValue(arrRow[i], 'cntr_no');
				} else {
					cop_no += sheetObj.CellValue(arrRow[i], 'cop_no') + ",";
					ag_seq += sheetObj.CellValue(arrRow[i], 'cost_act_grp_seq') + ",";
					bkg_no += sheetObj.CellValue(arrRow[i], 'bkg_no') + ",";
					cntr_no += sheetObj.CellValue(arrRow[i], 'cntr_no') + ",";
				}

   		        if (so_sts_cd != 'P') {
   		        	ComShowMessage("The selected data is not S/O Candidate.");
   		         	return false ;	
   		        }
            }

			if (conti_cd == 'E') {
				sUrl = "/hanjin/ESD_TRS_0002.do";
			}else if (conti_cd == 'A') {
				sUrl = "/hanjin/ESD_TRS_0005.do";
			}else if (conti_cd == 'M') {
				if (rail_cd == 'R' && bnd_cd == 'I'){
					sUrl = "/hanjin/ESD_TRS_0201.do";
				}else if (rail_cd == 'R' && bnd_cd == 'O') {
					sUrl = "/hanjin/ESD_TRS_0202.do";
				}else{
					sUrl = "/hanjin/ESD_TRS_0004.do";
				}	
			}

        	var param = ""; // "?s_view=" + view_div;
        	var vCond = "";
        	var p_url = "soCreation";
        	var soForm = document.soForm;
        	soForm.s_cop_no.value = cop_no;
        	soForm.s_cost_act_grp_seq.value = ag_seq;
        	soForm.s_so_ofc_cd.value = ofc_cd;
        	soForm.s_so_tp_cd.value = so_tp_cd;
        	soForm.s_bkg_no.value = bkg_no;
        	soForm.s_cntr_no.value = cntr_no;

        	param = TrsFrmQryString(soForm);
        	var myOption = "width=1024,height=700,menubar=0,status=0,scrollbars=0,resizable=1";
        	window.open(sUrl + "?" + param, p_url, myOption);

			break;
		case SEARCH11: //S/O Inquiry
			var ofc_cd = "";
			var so_no = "";
			var so_sts_cd = "";
			var sUrl = "";

			var checkList = sheetObj.FindCheckedRow('chk');
        	var arrRow = checkList.split("|");
			if(checkList == ''){
				ComShowCodeMessage('COM12176');
				return false;
			}
            for (i=0; i<arrRow.length-1; i++){ 
				ofc_cd = sheetObj.CellValue(arrRow[i], 'sce_so_ofc_cd');
				rail_cd = sheetObj.CellValue(arrRow[i], 'rail_cd');
				so_sts_cd = sheetObj.CellValue(arrRow[i], 'trsp_so_sts_cd');
				if( i == arrRow.length-2 ) {
					so_no += sheetObj.CellValue(arrRow[i], 'so_no');
				} else {
					so_no += sheetObj.CellValue(arrRow[i], 'so_no') + ",";
				}

   		        if (so_sts_cd == 'P') {
   		        	ComShowMessage("S/O is not created yet.");
   		         	return false ;	
   		        }
            }

			sUrl = "/hanjin/ESD_TRS_0019.do";

        	var param = ""; // "?s_view=" + view_div;
        	var vCond = "";
        	var p_url = "soInquiry";
        	var soForm = document.soForm;
        	soForm.s_so_ofc_cd.value = ofc_cd;
        	soForm.sowonumber.value = so_no;
        	soForm.s_rail_cd.value = rail_cd;

        	param = TrsFrmQryString(soForm);
        	var myOption = "width=1024,height=700,menubar=0,status=0,scrollbars=0,resizable=1";
        	window.open(sUrl + "?" + param, p_url, myOption);

			break;
		case SEARCH12: //W/O Issue
			var ofc_cd = "";
			var trsp_so_ofc_cty_cd = "";
			var trsp_so_seq = "";
			var hjl_yn = "";
			var so_sts_cd = "";
			var bkg_no = "";
			var cntr_no = "";
			var sUrl = "";

			var checkList = sheetObj.FindCheckedRow('chk');
        	var arrRow = checkList.split("|");
			if(checkList == ''){
				ComShowCodeMessage('COM12176');
				return false;
			}
            for (i=0; i<arrRow.length-1; i++){ 
				ofc_cd = sheetObj.CellValue(arrRow[i], 'sce_so_ofc_cd');
				rail_cd = sheetObj.CellValue(arrRow[i], 'rail_cd');
				hjl_yn = sheetObj.CellValue(arrRow[i], 'hjl_yn');
				so_sts_cd = sheetObj.CellValue(arrRow[i], 'trsp_so_sts_cd');
				if( i == arrRow.length-2 ) {
					trsp_so_ofc_cty_cd += sheetObj.CellValue(arrRow[i], 'so_no').substring(0, 3);
					trsp_so_seq += sheetObj.CellValue(arrRow[i], 'so_no').substring(3);
					bkg_no += sheetObj.CellValue(arrRow[i], 'bkg_no');
					cntr_no += sheetObj.CellValue(arrRow[i], 'cntr_no');
				} else {
					trsp_so_ofc_cty_cd += sheetObj.CellValue(arrRow[i], 'so_no').substring(0, 3) + ",";
					trsp_so_seq += sheetObj.CellValue(arrRow[i], 'so_no').substring(3) + ",";
					bkg_no += sheetObj.CellValue(arrRow[i], 'bkg_no') + ",";
					cntr_no += sheetObj.CellValue(arrRow[i], 'cntr_no') + ",";
				}
   		        if (so_sts_cd != 'C') {
   		        	ComShowMessage("The selected data is not S/O Created or already W/O Issued.");
   		         	return false ;	
   		        }

   		        if (hjl_yn == 'Y') {
   		        	ComShowMessage("S/O was created through ETS.");
   		         	return false ;	
   		        }
            }

			if (rail_cd == 'R' ){
				sUrl = "/hanjin/ESD_TRS_0028.do";
			}else{
				sUrl = "/hanjin/ESD_TRS_0023.do";
			}

        	var param = ""; // "?s_view=" + view_div;
        	var vCond = "";
        	var p_url = "woIssue";
        	var soForm = document.soForm;
        	soForm.s_so_ofc_cd.value = ofc_cd;
        	soForm.s_rail_cd.value = rail_cd;
        	if (rail_cd == 'R' ){
	        	soForm.s_bkg_no.value = bkg_no;
	        	soForm.s_cntr_no.value = cntr_no;
        	}else{
            	soForm.trsp_so_ofc_cty_cd.value = trsp_so_ofc_cty_cd;
            	soForm.trsp_so_seq.value = trsp_so_seq;
        	}

        	param = TrsFrmQryString(soForm);
        	var myOption = "width=1024,height=700,menubar=0,status=0,scrollbars=0,resizable=1";
        	window.open(sUrl + "?" + param, p_url, myOption);
			break;
		case SEARCH13: //W/O Preview
			var ofc_cd = "";
			var trsp_wo_ofc_cty_cd = "";
			var trsp_wo_seq = "";
			var hjl_yn = "";
			var sUrl = "";

			var checkList = sheetObj.FindCheckedRow('chk');
        	var arrRow = checkList.split("|");
			if(checkList == ''){
				ComShowCodeMessage('COM12176');
				return false;
			}
            for (i=0; i<arrRow.length-1; i++){ 
				ofc_cd = sheetObj.CellValue(arrRow[i], 'sce_so_ofc_cd');
				rail_cd = sheetObj.CellValue(arrRow[i], 'rail_cd');
				hjl_yn = sheetObj.CellValue(arrRow[i], 'hjl_yn');
				so_sts_cd = sheetObj.CellValue(arrRow[i], 'trsp_so_sts_cd');
				if( i == arrRow.length-2 ) {
					trsp_wo_ofc_cty_cd += sheetObj.CellValue(arrRow[i], 'wo_no').substring(0, 3);
					trsp_wo_seq += sheetObj.CellValue(arrRow[i], 'wo_no').substring(3);
				} else {
					trsp_wo_ofc_cty_cd += sheetObj.CellValue(arrRow[i], 'wo_no').substring(0, 3) + ",";
					trsp_wo_seq += sheetObj.CellValue(arrRow[i], 'wo_no').substring(3) + ",";
				}

   		        if (so_sts_cd != 'I') {
   		        	ComShowMessage("The selected data is not W/O Issued.");
   		         	return false ;	
   		        }

   		        if (hjl_yn == 'Y') {
   		        	ComShowMessage("S/O was created through ETS.");
   		         	return false ;	
   		        }
            }

			if (rail_cd == 'R' ){
				ComShowMessage("US Rail S/O are included");
				return false;
			}else{
				sUrl = "/hanjin/ESD_TRS_0024.do";
			}

        	var param = "";
        	var vCond = "";
        	var p_url = "woIssue";
			var wo_cancel_flag = '';
			var detain = '';
			var bno_issue = '';
			var eq_mode = 'IS';
			var issued = 'Y';

        	//param = TrsFrmQryString(soForm);
			param = "?trsp_wo_ofc_cty_cd="+trsp_wo_ofc_cty_cd+"&trsp_wo_seq="+trsp_wo_seq+"&wo_cancel_flag="+wo_cancel_flag+"&detain="+detain+"&eq_mode="+eq_mode+"&bno_issue="+bno_issue+"&isInquiry=Y"+"&pgmNo=ESD_TRS_0024";
        	var myOption = "scroll:no,status:no,help:no,width=1000,Height=800";
        	window.open(sUrl + param, p_url, myOption);

			break;
		case IBDOWNEXCEL:	//Down Excel
			sheetObj.SpeedDown2Excel(-1, false, false);
			break;
	}
}

/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateForm(sheetObj,formObj,sAction){
	switch(sAction){
		case IBDOWNEXCEL:
			//그리드 데이터 없을 경우
			if( sheetObj.RowCount <= 0 ){
				return false;
			}
			break;
	}
	
	return true;
}

function createHttpRequest() {
	try{
		request = new XMLHttpRequest();
	} catch(trymicrosoft) {
		try{
			request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch(othermicosoft) {
			try{
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch(failed) {
				request = null;
			}
		}
	}
	if( request == null ) {
		ComShowMessage("Error Request XMLHttp");
	}
}