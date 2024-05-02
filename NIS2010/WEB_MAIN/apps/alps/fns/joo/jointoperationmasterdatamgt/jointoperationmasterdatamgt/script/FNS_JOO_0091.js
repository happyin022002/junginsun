/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FNS_JOO_0091.jsp
*@FileTitle : BSA Information Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.30
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.12.30 김영오
* 1.0 Creation
* 2013.02.01 이수진 그리드 항목 위치 변경
* 2013.05.06 김현화[CHM-201324350]BSA Information Entry 로직 추가- Update 시 refNo Validation.
* 2013.06.14 이수진 [CHM-201325358]BSA Information Entry 기능 추가
*            - Vessel, Direction 데이타 입력시  Start/End Vessel과 Direction에 자동으로 반영될 수 있도록
*            - Vessel, Direction 코드와 Start/End Vessel과 Direction 코드가 상이할 경우 메세지 처리
*            - Row Copy, Row Add시 Pirce Finish 값을 Default로 "N"에서 "Y"로 변경
*            - Row copy하여  Add Carrier 값이 존재하면 Add BSA 정보
*            - Remark RDR, Remark J/O 항목 추가
* 2013.09.02 이수진 [CHM-201326325][BSA Information Entry] 시스템 UI 개선 요청 건
* 2013.10.22 이수진 [CHM-201327277] JO - BSA ENTRY INFO. 수정 요청
*            - 계약정보(주차, Port, Date 정보) 구해오는 기준 변경(Trade + VVD, Trade + RLane + VVD)
* 2015.09.18 손진환 [CHM-201537268] 2015년 공동운항 개발 건 - Target Retrieve / Target Excel기능 추가 / 검색조건 default = "ALL"
* =========================================================*/
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
 * @class FNS_JOO_0091 : FNS_JOO_0091 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function FNS_JOO_0091() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업	*/

//공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var prefix = "sheet1_";
var prefix3 = "sheet3_";
var prefix4 = "sheet4_";

var gRow = "";

var gTrdLaneCrrArr; //0 : Trade, 1 : Lane, 2 : Carrier

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	
//	if( document.form.add_carrier.checked == true){
//		var sheetObj = sheetObjects[2];
//		
//	}else{
		var sheetObj = sheetObjects[0];
//	}

	/*******************************************************/
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {

		case "btns_copy":
			UF_copyRow();	
			break;

		case "btns_add":
			UF_addRow(-1);
			break;

		case "btns_insert":
			UF_addRow();
			break;
			
		case "btns_del":
			// 2013.02.19 이수진 (오미랑 과장 요청사항 - RDR Finish 또는 Delete Mark가 "Y"인 경우에는 Row Delete되지 않도록 수정)
			var jo_fsh_flg = sheetObj.CellValue(sheetObj.SelectRow, prefix+"jo_fsh_flg");
			var delt_flg = sheetObj.CellValue(sheetObj.SelectRow, prefix+"delt_flg");
			
			if(jo_fsh_flg == "N" && delt_flg == "N"){			
				sheetObj.RowHidden(sheetObj.SelectRow)= true;		//2.행 숨기기
				sheetObj.RowStatus(sheetObj.SelectRow)= "D";		//3.트랜잭션 상태 "삭제"로 만들기
			}else{
				ComShowCodeMessage("JOO00209");
			}
			break;
			
		case "btn_retrieve":
			if( formObj.add_carrier.checked == true){
				sheetObj = sheetObjects[2];
            }else{
            	sheetObj = sheetObjects[0];
            }
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
			break;

		case "btn_new":
			ComResetAll();    //기본 object 초기화
			UF_reset();
			document.all.sheet_main.style.display = "";
			document.all.sheet_carrier.style.display = "none";
			ComBtnEnable("btns_copy");
			ComBtnEnable("btns_add");
			ComBtnEnable("btns_del");
			ComBtnEnable("btn_history");
			break;

		case "btn_downexcel":
			var paramObj = new Object();
			if( formObj.add_carrier.checked == true){
				sheetObj = sheetObjects[2];
				sheetObj.SpeedDown2Excel(-1, false, false, "");
            }else{
            	sheetObj = sheetObjects[0];
            	var url = ComJooGetPgmTitle(sheetObj, paramObj);
    			sheetObj.SpeedDown2Excel(-1, false, false, "", url);
            }
			
			break;
			
		case "btn_target_excel":
			var paramObj = new Object();
			sheetObj = sheetObjects[3];
			
			doActionIBSheet(sheetObj, formObj, "TARGETEXCEL");

			sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false);
			
			break;
			
		case "btn_target_retrieve":
			var paramObj = new Object();
			sheetObj = sheetObjects[0];
			
			doActionIBSheet(sheetObj, formObj, "TARGETRETRIEVE");

			
			
			break;
			
		case "btn_loadExcel":
			if( formObj.add_carrier.checked == true){
				sheetObj = sheetObjects[2];
				sheetObj.RemoveAll();
				sheetObj.LoadExcel();
            }else{
            	sheetObj = sheetObjects[0];
            	sheetObj.RemoveAll();
    			sheetObj.LoadExcel();
            }
			
			break;	
			
		case "btn_save":
			
			if( formObj.add_carrier.checked == true){				
				sheetObj = sheetObjects[2];
            }else{
            	sheetObj = sheetObjects[0];
            }		

			doActionIBSheet(sheetObj, formObj, IBSAVE);
			break;
			
		case "btn_pop_ofc_cd":
			ComOpenPopup("/hanjin/COM_ENS_071.do", 750, 470, "ofc_cd_pop_event", "1,0,1", true);
			break;

		//Creation Date 달력
		case "cre_dt_cal":
			var cal = new ComCalendarFromTo();
			cal.select(formObj.cre_dt_fr, formObj.cre_dt_to, 'yyyy-MM-dd');
			break;
					
		// Date 달력
		case "etd_dt_cal":
			var cal = new ComCalendarFromTo();
			cal.select(formObj.fm_etd_dt, formObj.to_etd_dt, 'yyyy-MM-dd');
			break;
			
		case "btns_calendar_from": //달력버튼
            var cal = new ComCalendar();
            cal.select(formObj.cre_dt_to, 'yyyy-MM-dd');
            break;

	    case "btns_calendar_to": //달력버튼
	        var cal = new ComCalendar();
	        cal.select(formObj.cre_dt_fr, 'yyyy-MM-dd');
	        break;
				
	    case "btn_history": //history
	    	if(sheetObj.RowCount > 0){
	    		var vvdPort = sheetObj.CellValue(sheetObj.SelectRow, prefix+"vvd_port");

					var paramUrl = "pgmNo=FNS_JOO_0092&vvdPort=" +vvdPort;

					ComOpenPopup("/hanjin/FNS_JOO_0092.do?"+paramUrl, 1435, 500,
						"popupFinish", "1,0,1,1,1,1,1,1", true, false, 0, 0, 0,
						"pop1");
				
			}			
	        break;	

		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage('JOO00001');
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
 * param : combo_obj ==> 콤보오브젝트
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
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

	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}

	var arr1d = gTrdLaneCrr.split("|");
	gTrdLaneCrrArr = arr1d;
	for (var i=0; i< arr1d.length; i++){
		var arr2d = arr1d[i];
		gTrdLaneCrrArr[i] = arr2d.split(",");
	}

    initControl();
}

 
 /**
  * 마이스 이동시 이벤트
  * @param Button
  * @param Shift
  * @param X
  * @param Y
  * @return
  */
 function sheet1_OnMouseMove(Button, Shift, X, Y) {
 	//window.status = "OnMouseMove Row=" + Row + ", Col=" + Col + ", Text=" + sText;

 	Row = sheetObjects[0].MouseRow;
 	Col = sheetObjects[0].MouseCol; 	
 	
 	var colSaveName = sheetObjects[0].ColSaveName(Col);
 	
 	if( (colSaveName == prefix+"jo_bsa_entr_rmk") || (colSaveName == prefix+"jo_bsa_entr_rdr_rmk") ){    
 		sText = sheetObjects[0].CellText(Row,Col); 	
 	}else{
 		sText = "";
 	}
    
    //풍선도움말 만들기
 	sheetObjects[0].MouseToolTipText = sText; 	
 	  
 }
 
/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 **/
function initControl() {
	//** Date 구분자 **/
	DATE_SEPARATOR = "-";
	var formObj = document.form;
	
    //Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerFormat('beforedeactivate', 'obj_deactivate'    ,  formObj); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
	axon_event.addListenerFormat('beforeactivate'  , 'obj_activate'      ,  formObj); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
    axon_event.addListenerFormat('keypress'        , 'obj_keypress'      , 	formObj); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    axon_event.addListenerFormat('keyup'           , 'obj_keyup'         ,  formObj);
    axon_event.addListenerFormat('click'           , 'obj_onclick'       , 	formObj);
    axon_event.addListenerForm("Click","obj_Click", document.form);

	axon_event.addListenerFormat('beforedeactivate', 'obj_blur'          , formObj); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
	axon_event.addListenerFormat('beforeactivate'  , 'obj_focus'         , formObj);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
    axon_event.addListenerFormat('keypress'        , 'obj_keypress'      , formObj);
				
    axon_event.addListener      ('beforedeactivate', 'ofc_cd_onblur'     , 'ofc_cd');
    axon_event.addListener      ('keypress'        , 'ofc_cd_keypress'   , 'ofc_cd');
    axon_event.addListener      ('keyup'           , 'ofc_cd_keyup'      , 'ofc_cd');
    axon_event.addListener      ('click'           , 'add_carrier_click' , 'add_carrier');
    
    axon_event.addListenerForm  ('keydown'         , 'ComKeyEnter'       , formObj);
    axon_event.addListenerForm  ('keyup'           , 'fnObjKeyUp'        , formObj );
    axon_event.addListenerForm  ('keypress'        , 'fnObjKeyPress'     , formObj );
	
}

function obj_keyup() {
	ComKeyEnter('lengthnextfocus');
}

//Axon 이벤트 처리2. 이벤트처리함수
function obj_deactivate() {
	ComChkObjValid(event.srcElement);
}

function obj_activate() {
	ComClearSeparator(event.srcElement);
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;

	switch (sheetNo) {
	case 1: // sheet1 init Main 화면 조회용
		with (sheetObj) {
			// 높이 설정
			style.height = 360;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);

			var HeadTitle  = "||YYYY-WW|Office|Rev/Exp|Trade|Lane|Vessel|Voyage|Direction|Port|Port Seq.|Carrier|BSA|Add BSA|Add\nBSA Carrier|OUS\nBSA|Ton/TEU|OUS\nWeight"
				+"|20' HC|20' HC|40' HC|40' HC|45'|45'|45'|Round\nKind|Round\nType|RF Alloc|RF Alloc|IPC\nOUS|RDR Port|Revenue Port ETD|RDR Finish|BSA\nPrice|OUS Price|OUS Price|OUS Price|OUS Price|OUS Price"
				+"|R/F Price|R/F Price|Price\nFinish|VVD+Port+Seq+Crr|Remark RDR|Remark FAR J/O|Update\nDate|Update ID|Update Name|Delete\nMark";
			var HeadTitle2 = "||YYYY-WW|Office|Rev/Exp|Trade|Lane|Vessel|Voyage|Direction|Port|Port Seq.|Carrier|BSA|Add BSA|Add\nBSA Carrier|OUS\nBSA|Ton/TEU|OUS\nWeight"
				+"|Sub Alloc|Over Ratio (F)|Sub Alloc|Over Ratio (F)|Sub Alloc|Under Ratio (F)|Over Ratio (F)|Round\nKind|Round\nType|Ocean|Inter|IPC\nOUS|RDR Port|Revenue Port ETD|RDR Finish|BSA\nPrice"
				+"|Ocean|Inter|MT(Ocean)|MT(Inter)|Sector Price|Ocean|Inter|Price\nFinish|VVD+Port+Seq+Crr|Remark RDR|Remark FAR J/O|Update\nDate|Update ID|Update Name|Delete\nMark";
			var headCount = ComCountHeadTitle(HeadTitle);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 13, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다.
			InitHeadMode(true, true, true, false, true, false)
			
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			InitHeadRow(1, HeadTitle2, true);

			//데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,		COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT,	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtStatus      , 30, daCenter, true, prefix + "ibflag" );
			InitDataProperty(0, cnt++, dtCheckBox    , 30, daCenter, true,  prefix + "del_chk"); //dtCheckBox
			
			InitDataProperty(0, cnt++, dtData   	 , 70, daCenter, true,  prefix + "yrwk"              		, false, "", dfDateYm      	, 0, false, false);      // YYYY-MM
			InitDataProperty(0, cnt++, dtCombo   	 , 70, daCenter, true,  prefix + "ofc_cd"              		, false, "", dfNone        	, 0, false, true ,6);      // Office
			InitDataProperty(0, cnt++, dtCombo       , 60, daCenter, true,  prefix + "re_divr_cd"          		, false, "", dfNone        	, 0, false, true );        // Rev/Exp
			InitDataProperty(0, cnt++, dtCombo       , 50, daCenter, true,  prefix + "trd_cd"              		, false, "", dfNone        	, 0, false, true );        // Trade
			InitDataProperty(0, cnt++, dtData        , 60, daCenter, true,  prefix + "rlane_cd"            		, false, "", dfNone        	, 0, false, true );        // Lane
			InitDataProperty(0, cnt++, dtData        , 60, daCenter, true,  prefix + "vsl_cd"            		, false, "", dfNone        	, 0, false, true ,4 );     // Vessel
			InitDataProperty(0, cnt++, dtData        , 60, daCenter, true,  prefix + "skd_voy_no"          		, false, "", dfNone        	, 0, false, true ,4 );     // Vessel
			InitDataProperty(0, cnt++, dtCombo       , 60, daCenter, true,  prefix + "skd_dir_cd"               , false, "", dfNone        	, 0, false, true );        // Direction
			InitDataProperty(0, cnt++, dtData   	 , 60, daCenter, true,  prefix + "port_cd"            		, false, "", dfNone        	, 0, false, true ,5 );     // Port
			InitDataProperty(0, cnt++, dtData        , 70, daCenter, true,  prefix + "port_seq"           		, false, "", dfNone        	, 0, false, true, 3 );     // Port Seq.
			
			InitDataProperty(0, cnt++, dtData        , 80, daCenter, true,  prefix + "jo_crr_cd"           		, false, "", dfNone        	, 0, false, true ,3);      // Carrier
			InitDataProperty(0, cnt++, dtData        , 80, daRight , true,  prefix + "jo_bsa_teu_qty"      		, false, "", dfInteger     	, 2, true , true );        // BSA			
			InitDataProperty(0, cnt++, dtData        , 80, daRight,  true,  prefix + "jo_bsa_add_teu_qty"      	, false, "", dfInteger   	, 0, false, true );        // Add BSA 
			InitDataProperty(0, cnt++, dtCombo       , 80, daCenter, true,  prefix + "jo_add_bsa_crr_flg"      	, false, "", dfNone   	   	, 0, true , true );        // Add BSA Carrier 
			InitDataProperty(0, cnt++, dtData        , 80, daRight,  true,  prefix + "jo_ovr_bsa_teu_qty"       , false, "", dfInteger   	, 2, false, true );        // OUS BSA
			InitDataProperty(0, cnt++, dtData        ,100, daRight,  true,  prefix + "jo_ton_teu_qty"     		, false, "", dfFloat   		, 2, true , true );        // Ton/TEU
			InitDataProperty(0, cnt++, dtData        , 90, daRight , true,  prefix + "jo_ovr_ton_wgt"    		, false, "", dfFloat 		, 2, true , true );        // OUS Weight 
			InitDataProperty(0, cnt++, dtData        , 90, daRight , false, prefix + "jo_20ft_sub_teu_qty"    	, false, "", dfInteger 		, 0, true , true );        // 20'HC Sub Alloc 
			InitDataProperty(0, cnt++, dtData        ,100, daRight,  false, prefix + "jo_20ft_ovr_rto"     		, false, "", dfFloat 		, 3, true , true );        // 20' Over Ratio
			InitDataProperty(0, cnt++, dtData        ,100, daRight,  false, prefix + "jo_40ft_sub_teu_qty"    	, false, "", dfInteger 		, 0, true , true );        // 40'HC Sub Alloc
			
			InitDataProperty(0, cnt++, dtData        ,110, daRight,  false, prefix + "jo_40ft_ovr_rto"      	, false, "", dfFloat 		, 3, true , true );        // 40' Over Ratio
			InitDataProperty(0, cnt++, dtData        ,100, daRight,  false, prefix + "jo_45ft_sub_teu_qty"      , false, "", dfInteger   	, 0, true , true );        // 45' Sub Alloc
			InitDataProperty(0, cnt++, dtData        ,100, daRight,  false, prefix + "jo_45ft_und_rto"  		, false, "", dfFloat 		, 3, true , true );        // 45' Under Ratio
			InitDataProperty(0, cnt++, dtData        ,100, daRight,  false, prefix + "jo_45ft_ovr_rto"			, false, "", dfFloat 		, 3, true , true );        // 45' Over Ratio			
			InitDataProperty(0, cnt++, dtCombo       , 90, daCenter, true,  prefix + "jo_rnd_knd_flg"          	, false, "", dfNone        	, 0, true , true);         // Round Kind
			InitDataProperty(0, cnt++, dtCombo       , 90, daCenter, true,  prefix + "jo_rnd_rule_lvl"          , false, "", dfNone        	, 0, true , true);         // Round Type			
			InitDataProperty(0, cnt++, dtData        ,110, daRight,  true,  prefix + "jo_rf_ocn_teu_qty"       	, false, "", dfInteger      , 0, true , true);         // RF Alloc Ocean
			InitDataProperty(0, cnt++, dtData   	 , 80, daRight,  true,  prefix + "jo_rf_inter_teu_qty"      , false, "", dfInteger     	, 0, true , true );        // RF Alloc Inter			
			InitDataProperty(0, cnt++, dtCombo       , 90, daCenter, true,  prefix + "jo_inter_ovr_flg"         , false, "", dfNone        	, 0, true , true);         // IPC OUS			
			InitDataProperty(0, cnt++, dtData        , 90, daCenter, true,  prefix + "jo_rdr_port_cd"          	, false, "", dfNone        	, 0, true , true,5);       // RDR Port
			InitDataProperty(0, cnt++, dtData        ,120, daCenter, true,  prefix + "rev_port_etd_dt"        	, false, "", dfDateYmd    	, 0, false, false);			// Revenue Port ETD
			
			InitDataProperty(0, cnt++, dtCombo       , 90, daCenter, true,  prefix + "jo_fsh_flg"          		, false, "", dfNone        	, 0, true , true);         // RDR Finish			
			InitDataProperty(0, cnt++, dtData  		 , 80, daRight,  true,  prefix + "jo_bsa_prc"         		, false, "", dfFloat     	, 2, true , true );        // BSA Price
			InitDataProperty(0, cnt++, dtData        ,120, daRight,  true,  prefix + "jo_ovr_ocn_prc"           , false, "", dfFloat 		, 2, true , true);         // OUS Price Ocean			
			InitDataProperty(0, cnt++, dtData        ,120, daRight,  true,  prefix + "jo_ovr_inter_prc"         , false, "", dfFloat 		, 2, true , true);         // OUS Price Inter
			InitDataProperty(0, cnt++, dtData        , 80, daRight,  true,  prefix + "jo_ovr_mt_ocn_prc"        , false, "", dfFloat        , 2, true , true);         // OUS Price MT(Ocean)
			InitDataProperty(0, cnt++, dtData        , 90, daRight,  true,  prefix + "jo_ovr_mt_inter_prc"      , false, "", dfFloat        , 2, true , true);         // OUS Price MT(Inter)
			InitDataProperty(0, cnt++, dtCombo       , 90, daCenter, true,  prefix + "jo_sctr_prc_flg"          , false, "", dfNone        	, 0, true , true);         // OUS Price Sector Price
			InitDataProperty(0, cnt++, dtData        , 90, daRight,  true,  prefix + "jo_rf_ocn_prc"          	, false, "", dfFloat        , 2, true , true);         // R/F Price Ocean			
			InitDataProperty(0, cnt++, dtData        , 90, daRight,  true,  prefix + "jo_rf_inter_prc"          , false, "", dfFloat        , 2, true , true);         // R/F Price Inter						
			InitDataProperty(0, cnt++, dtCombo       , 90, daCenter, true,  prefix + "jo_prc_fsh_flg"      		, false, "", dfNone        	, 0, true , true);         // Price Finish
			
			InitDataProperty(0, cnt++, dtData        ,140, daCenter, true,  prefix + "vvd_port"            		, false, "", dfNone        	, 0, false, true ,17 );    // Vessel			
			InitDataProperty(0, cnt++, dtData        ,300, daCenter, true,  prefix + "jo_bsa_entr_rdr_rmk"      , false, "", dfNone        	, 0, true , true,500);     // Remark RDR
			InitDataProperty(0, cnt++, dtData        ,300, daCenter, true,  prefix + "jo_bsa_entr_rmk"        	, false, "", dfNone        	, 0, true , true,500);     // Remark FAR J/O
			InitDataProperty(0, cnt++, dtData        , 90, daCenter, true,  prefix + "upd_dt"          			, false, "", dfDateYmd      , 0, false, true);
			InitDataProperty(0, cnt++, dtData        , 90, daCenter, true,  prefix + "upd_usr_id"          		, false, "", dfNone        	, 0, false, true);
			InitDataProperty(0, cnt++, dtData        ,120, daCenter, true,  prefix + "usr_nm"          			, false, "", dfNone        	, 0, false, true);
			InitDataProperty(0, cnt++, dtCombo       , 80, daCenter, true,  prefix + "delt_flg"            		, false, "", dfNone        	, 0, true, true);
			
			
			ImageList(0) = "/hanjin/img/button/btns_calendar.gif";	
			
            InitDataValid(0, prefix+"vsl_cd", vtEngUpOther, "0123456789");  //영문대문자+숫자   
            InitDataValid(0, prefix+"skd_voy_no", vtNumericOnly);    	   	// 숫자만
            InitDataValid(0, prefix+"port_cd", vtEngUpOnly);    			// 영대문자만
            InitDataValid(0, prefix+"port_seq", vtNumericOnly);    			// 숫자만            
            InitDataValid(0, prefix+"jo_crr_cd", vtEngUpOnly);    			// 영대문자만
            
            InitDataValid(0, prefix+"jo_rdr_port_cd", vtEngUpOnly);    			// 영대문자만
			InitDataCombo(0, prefix+"re_divr_cd" , "Rev|Exp", "R|E");
			InitDataCombo(0, prefix+"delt_flg"   , "Y|N", "Y|N");
			InitDataCombo(0, prefix+"skd_dir_cd"   , " |E|W|S|N", " |E|W|S|N");
			InitDataCombo(0, prefix+"jo_add_bsa_crr_flg"   , "Y|N", "Y|N");
			InitDataCombo(0, prefix+"jo_sctr_prc_flg"   , "Y|N", "Y|N");
			InitDataCombo(0, prefix+"jo_inter_ovr_flg"  , "Y|N", "Y|N");
			InitDataCombo(0, prefix+"jo_rnd_knd_flg"   , "S|G", "S|G");
			InitDataCombo(0, prefix+"jo_rnd_rule_lvl"   , "No|Round|Up|Down", "4|1|2|3");			
			InitDataCombo(0, prefix+"jo_fsh_flg"  , "Y|N", "Y|N");
			InitDataCombo(0, prefix+"jo_prc_fsh_flg"  , "Y|N", "Y|N");
			
			
			var trdList = gTrdCd.split("|");
			var trdSheet = "";
			var trdCodeName = "";
			for (var i=0; i<trdList.length; i++){
				trdCodeName = trdList[i].split(",");
				if (i == 0){
					trdSheet = trdCodeName[0];
				}else{
					trdSheet = trdSheet + "|" + trdCodeName[0];
				}
			}

			//OFC_CD
			var ofcCdList = gOfcCd.split("|");
			var ofcSheet = "";
			var ofcCodeName = "";
			for (var i=0; i<ofcCdList.length; i++){
				ofcCodeName = ofcCdList[i].split(",");
				if (i == 0){
					ofcSheet = ofcCodeName[0];
				}else{
					ofcSheet = ofcSheet + "|" + ofcCodeName[0];
				}
			}
			InitDataCombo(0, prefix+"ofc_cd"      , ofcSheet  , ofcSheet);
			InitDataCombo(0, prefix+"trd_cd"      , trdSheet  , trdSheet);

			InitComboNoMatchText(true);
			//ComboOpenMode = true; //한번 클릭으로 펼쳐짐
		}
		break;
	
	case 2: // sheet1 init  Main 화면 Excel Down 용
		with (sheetObj) {
			// 높이 설정
			style.height = 360;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);

			var HeadTitle  = "||YYYY-MM|Office|Rev/Exp|Trade|Lane|Vessel|Voyage|Direction|Port|Port Seq.|Carrier|BSA|Add BSA|Add\nBSA Carrier|OUS\nBSA|Ton/TEU|OUS\nWeight"
				+"|20' HC|20' HC|40' HC|40' HC|45'|45'|45'|Round\nKind|Round\nType|RF Alloc|RF Alloc|IPC\nOUS|RDR Port|Revenue Port ETD|RDR Finish|BSA\nPrice|OUS Price|OUS Price|OUS Price|OUS Price|OUS Price"
				+"|R/F Price|R/F Price|Price\nFinish|VVD+Port+Seq+Crr|Remark RDR|Remark FAR J/O|Update\nDate|Update ID|Update Name|Delete\nMark";
			var HeadTitle2 = "||YYYY-MM|Office|Rev/Exp|Trade|Lane|Vessel|Voyage|Direction|Port|Port Seq.|Carrier|BSA|Add BSA|Add\nBSA Carrier|OUS\nBSA|Ton/TEU|OUS\nWeight"
				+"|Sub Alloc|Over Ratio (F)|Sub Alloc|Over Ratio (F)|Sub Alloc|Under Ratio (F)|Over Ratio (F)|Round\nKind|Round\nType|Ocean|Inter|IPC\nOUS|RDR Port|Revenue Port ETD|RDR Finish|BSA\nPrice"
				+"|Ocean|Inter|MT(Ocean)|MT(Inter)|Sector Price|Ocean|Inter|Price\nFinish|VVD+Port+Seq+Crr|Remark RDR|Remark FAR J/O|Update\nDate|Update ID|Update Name|Delete\nMark";
			var headCount = ComCountHeadTitle(HeadTitle);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 12, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다.
			InitHeadMode(true, true, true, false, true, false)
			
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			InitHeadRow(1, HeadTitle2, true);

			//데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,		COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT,	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtStatus      , 30, daCenter, true, prefix + "ibflag" );
			InitDataProperty(0, cnt++, dtCheckBox    , 30, daCenter, true,  prefix + "del_chk"); //dtCheckBox
			
			InitDataProperty(0, cnt++, dtData   	 , 70, daCenter, true,  prefix + "yrwk"              		, false, "", dfNone        	, 0, false, true ,6);      // YYYY-MM
			InitDataProperty(0, cnt++, dtCombo   	 , 70, daCenter, true,  prefix + "ofc_cd"              		, false, "", dfNone        	, 0, false, true ,6);      // Office
			InitDataProperty(0, cnt++, dtCombo       , 60, daCenter, true,  prefix + "re_divr_cd"          		, false, "", dfNone        	, 0, false, true );        // Rev/Exp
			InitDataProperty(0, cnt++, dtCombo       , 50, daCenter, true,  prefix + "trd_cd"              		, false, "", dfNone        	, 0, false, true );        // Trade
			InitDataProperty(0, cnt++, dtData        , 60, daCenter, true,  prefix + "rlane_cd"            		, false, "", dfNone        	, 0, false, true );        // Lane
			InitDataProperty(0, cnt++, dtData        , 60, daCenter, true,  prefix + "vsl_cd"            		, false, "", dfNone        	, 0, false, true ,4 );     // Vessel
			InitDataProperty(0, cnt++, dtData        , 60, daCenter, true,  prefix + "skd_voy_no"          		, false, "", dfNone        	, 0, false, true ,4 );     // Vessel
			InitDataProperty(0, cnt++, dtCombo       , 60, daCenter, true,  prefix + "skd_dir_cd"               , false, "", dfNone        	, 0, false, true );        // Direction
			InitDataProperty(0, cnt++, dtData   	 , 60, daCenter, true,  prefix + "port_cd"            		, false, "", dfNone        	, 0, false, true ,5 );     // Port
			InitDataProperty(0, cnt++, dtData        , 70, daCenter, true,  prefix + "port_seq"           		, false, "", dfNone        	, 0, false, true, 3 );     // Port Seq.
			
			InitDataProperty(0, cnt++, dtData        , 80, daCenter, true,  prefix + "jo_crr_cd"           		, false, "", dfNone        	, 0, false, true ,3);      // Carrier
			InitDataProperty(0, cnt++, dtData        , 80, daRight , true,  prefix + "jo_bsa_teu_qty"      		, false, "", dfInteger     	, 2, true , true );        // BSA			
			InitDataProperty(0, cnt++, dtData        , 80, daRight,  true,  prefix + "jo_bsa_add_teu_qty"      	, false, "", dfInteger   	, 0, false, true );        // Add BSA 
			InitDataProperty(0, cnt++, dtCombo       , 80, daCenter, true,  prefix + "jo_add_bsa_crr_flg"      	, false, "", dfNone   	   	, 0, true , true );        // Add BSA Carrier 
			InitDataProperty(0, cnt++, dtData        , 80, daRight,  true,  prefix + "jo_ovr_bsa_teu_qty"       , false, "", dfInteger   	, 2, false, true );        // OUS BSA
			InitDataProperty(0, cnt++, dtData        ,100, daRight,  true,  prefix + "jo_ton_teu_qty"     		, false, "", dfFloat   		, 2, true , true );        // Ton/TEU
			InitDataProperty(0, cnt++, dtData        , 90, daRight , true,  prefix + "jo_ovr_ton_wgt"    		, false, "", dfFloat 		, 2, true , true );        // OUS Weight 
			InitDataProperty(0, cnt++, dtData        , 90, daRight , false, prefix + "jo_20ft_sub_teu_qty"    	, false, "", dfInteger 		, 0, true , true );        // 20'HC Sub Alloc 
			InitDataProperty(0, cnt++, dtData        ,100, daRight,  false, prefix + "jo_20ft_ovr_rto"     		, false, "", dfFloat 		, 3, true , true );        // 20' Over Ratio
			InitDataProperty(0, cnt++, dtData        ,100, daRight,  false, prefix + "jo_40ft_sub_teu_qty"    	, false, "", dfInteger 		, 0, true , true );        // 40'HC Sub Alloc
			
			InitDataProperty(0, cnt++, dtData        ,110, daRight,  false, prefix + "jo_40ft_ovr_rto"      	, false, "", dfFloat 		, 3, true , true );        // 40' Over Ratio
			InitDataProperty(0, cnt++, dtData        ,100, daRight,  false, prefix + "jo_45ft_sub_teu_qty"      , false, "", dfInteger   	, 0, true , true );        // 45' Sub Alloc
			InitDataProperty(0, cnt++, dtData        ,100, daRight,  false, prefix + "jo_45ft_und_rto"  		, false, "", dfFloat 		, 3, true , true );        // 45' Under Ratio
			InitDataProperty(0, cnt++, dtData        ,100, daRight,  false, prefix + "jo_45ft_ovr_rto"			, false, "", dfFloat 		, 3, true , true );        // 45' Over Ratio			
			InitDataProperty(0, cnt++, dtCombo       , 90, daCenter, true,  prefix + "jo_rnd_knd_flg"          	, false, "", dfNone        	, 0, true , true);         // Round Kind
			InitDataProperty(0, cnt++, dtCombo       , 90, daCenter, true,  prefix + "jo_rnd_rule_lvl"          , false, "", dfNone        	, 0, true , true);         // Round Type			
			InitDataProperty(0, cnt++, dtData        ,110, daRight,  true,  prefix + "jo_rf_ocn_teu_qty"       	, false, "", dfInteger      , 0, true , true);         // RF Alloc Ocean
			InitDataProperty(0, cnt++, dtData   	 , 80, daRight,  true,  prefix + "jo_rf_inter_teu_qty"      , false, "", dfInteger     	, 0, true , true );        // RF Alloc Inter			
			InitDataProperty(0, cnt++, dtCombo       , 90, daCenter, true,  prefix + "jo_inter_ovr_flg"         , false, "", dfNone        	, 0, true , true);         // IPC OUS			
			InitDataProperty(0, cnt++, dtData        , 90, daCenter, true,  prefix + "jo_rdr_port_cd"          	, false, "", dfNone        	, 0, true , true,5);       // RDR Port
			InitDataProperty(0, cnt++, dtData        ,120, daCenter, true,  prefix + "rev_port_etd_dt"        	, false, "", dfNone        	, 0, false, false);			// Revenue Port ETD
			
			InitDataProperty(0, cnt++, dtCombo       , 90, daCenter, true,  prefix + "jo_fsh_flg"          		, false, "", dfNone        	, 0, true , true);         // RDR Finish			
			InitDataProperty(0, cnt++, dtData  		 , 80, daRight,  true,  prefix + "jo_bsa_prc"         		, false, "", dfFloat     	, 2, true , true );        // BSA Price
			InitDataProperty(0, cnt++, dtData        ,120, daRight,  true,  prefix + "jo_ovr_ocn_prc"           , false, "", dfFloat 		, 2, true , true);         // OUS Price Ocean			
			InitDataProperty(0, cnt++, dtData        ,120, daRight,  true,  prefix + "jo_ovr_inter_prc"         , false, "", dfFloat 		, 2, true , true);         // OUS Price Inter
			InitDataProperty(0, cnt++, dtData        , 80, daRight,  true,  prefix + "jo_ovr_mt_ocn_prc"        , false, "", dfFloat        , 2, true , true);         // OUS Price MT(Ocean)
			InitDataProperty(0, cnt++, dtData        , 90, daRight,  true,  prefix + "jo_ovr_mt_inter_prc"      , false, "", dfFloat        , 2, true , true);         // OUS Price MT(Inter)
			InitDataProperty(0, cnt++, dtCombo       , 90, daCenter, true,  prefix + "jo_sctr_prc_flg"          , false, "", dfNone        	, 0, true , true);         // OUS Price Sector Price
			InitDataProperty(0, cnt++, dtData        , 90, daRight,  true,  prefix + "jo_rf_ocn_prc"          	, false, "", dfFloat        , 2, true , true);         // R/F Price Ocean			
			InitDataProperty(0, cnt++, dtData        , 90, daRight,  true,  prefix + "jo_rf_inter_prc"          , false, "", dfFloat        , 2, true , true);         // R/F Price Inter						
			InitDataProperty(0, cnt++, dtCombo       , 90, daCenter, true,  prefix + "jo_prc_fsh_flg"      		, false, "", dfNone        	, 0, true , true);         // Price Finish
			
			InitDataProperty(0, cnt++, dtData        ,120, daCenter, true,  prefix + "vvd_port"            		, false, "", dfNone        	, 0, false, true ,15 );    // Vessel			
			InitDataProperty(0, cnt++, dtData        ,300, daCenter, true,  prefix + "jo_bsa_entr_rdr_rmk"      , false, "", dfNone        	, 0, true , true,500);     // Remark RDR
			InitDataProperty(0, cnt++, dtData        ,300, daCenter, true,  prefix + "jo_bsa_entr_rmk"        	, false, "", dfNone        	, 0, true , true,500);     // Remark FAR J/O
			InitDataProperty(0, cnt++, dtData        , 90, daCenter, true,  prefix + "upd_dt"          			, false, "", dfDateYmd      , 0, false, true);
			InitDataProperty(0, cnt++, dtData        , 90, daCenter, true,  prefix + "upd_usr_id"          		, false, "", dfNone        	, 0, false, true);
			InitDataProperty(0, cnt++, dtData        ,120, daCenter, true,  prefix + "usr_nm"          			, false, "", dfNone        	, 0, false, true);
			InitDataProperty(0, cnt++, dtCombo       , 80, daCenter, true,  prefix + "delt_flg"            		, false, "", dfNone        	, 0, true , true);
			
			
			ImageList(0) = "/hanjin/img/button/btns_calendar.gif";	
			
            InitDataValid(0, prefix+"vsl_cd", vtEngUpOther, "0123456789");  //영문대문자+숫자   
            InitDataValid(0, prefix+"skd_voy_no", vtNumericOnly);    	   	// 숫자만
            InitDataValid(0, prefix+"port_cd", vtEngUpOnly);    			// 영대문자만
            InitDataValid(0, prefix+"port_seq", vtNumericOnly);    			// 숫자만            
            InitDataValid(0, prefix+"jo_crr_cd", vtEngUpOnly);    			// 영대문자만
            
            InitDataValid(0, prefix+"jo_rdr_port_cd", vtEngUpOnly);    			// 영대문자만
			InitDataCombo(0, prefix+"re_divr_cd" , "Rev|Exp", "R|E");
			InitDataCombo(0, prefix+"delt_flg"   , "Y|N", "Y|N");
			InitDataCombo(0, prefix+"skd_dir_cd"   , " |E|W|S|N", " |E|W|S|N");
			InitDataCombo(0, prefix+"jo_add_bsa_crr_flg"   , "Y|N", "Y|N");
			InitDataCombo(0, prefix+"jo_sctr_prc_flg"   , "Y|N", "Y|N");
			InitDataCombo(0, prefix+"jo_inter_ovr_flg"  , "Y|N", "Y|N");
			InitDataCombo(0, prefix+"jo_rnd_knd_flg"   , "S|G", "S|G");
			InitDataCombo(0, prefix+"jo_rnd_rule_lvl"   , "No|Round|Up|Down", "4|1|2|3");			
			InitDataCombo(0, prefix+"jo_fsh_flg"  , "Y|N", "Y|N");
			InitDataCombo(0, prefix+"jo_prc_fsh_flg"  , "Y|N", "Y|N");
			
			var trdList = gTrdCd.split("|");
			var trdSheet = "";
			var trdCodeName = "";
			for (var i=0; i<trdList.length; i++){
				trdCodeName = trdList[i].split(",");
				if (i == 0){
					trdSheet = trdCodeName[0];
				}else{
					trdSheet = trdSheet + "|" + trdCodeName[0];
				}
			}

			//OFC_CD
			var ofcCdList = gOfcCd.split("|");
			var ofcSheet = "";
			var ofcCodeName = "";
			for (var i=0; i<ofcCdList.length; i++){
				ofcCodeName = ofcCdList[i].split(",");
				if (i == 0){
					ofcSheet = ofcCodeName[0];
				}else{
					ofcSheet = ofcSheet + "|" + ofcCodeName[0];
				}
			}
			InitDataCombo(0, prefix+"ofc_cd"      , ofcSheet  , ofcSheet);
			InitDataCombo(0, prefix+"trd_cd"      , trdSheet  , trdSheet);

			InitComboNoMatchText(true);
			//ComboOpenMode = true; //한번 클릭으로 펼쳐짐
		}
		break;
		
	case 3: // sheet3 init  Add Carrier 조회 용
	with (sheetObj) {
		// 높이 설정
		style.height = 360;
		// 전체 너비 설정
		SheetWidth = mainTable.clientWidth;

		//Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "")
			InitHostInfo(location.hostname, location.port, page_path);

		//전체Merge 종류 [선택, Default msNone]
		MergeSheet = msHeaderOnly;

		//전체Edit 허용 여부 [선택, Default false]
		Editable = true;

		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo(1, 1, 3, 100);

		var HeadTitle  = "|VVD+Port+Seq+Crr|Carrier|Add BSA|Creation Date|Update ID|Update Name";
		var headCount = ComCountHeadTitle(HeadTitle);

		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(headCount, 0, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다.
		InitHeadMode(true, true, true, false, true, false)
		
		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle, true);

		//데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,		COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT,	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		InitDataProperty(0, cnt++, dtStatus, 30, daCenter, true, prefix3 + "ibflag" );
//		InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true,  prefix3 + "ibflag" );
//		InitDataProperty(0, cnt++, dtRadioCheck  , 30, daCenter, true,  prefix3 + "del_chk");
		InitDataProperty(0, cnt++, dtData        ,200, daCenter, true,  prefix3 + "vvd_port"       , true, "", dfNone        	, 0, false, false);
		InitDataProperty(0, cnt++, dtData        ,100, daCenter, true,  prefix3 + "jo_add_crr_cd"           , false, "", dfNone        	, 0, false, true ,3);     // Carrier
		InitDataProperty(0, cnt++, dtData        ,100, daRight,  true,  prefix3 + "jo_bsa_teu_qty"      , false, "", dfInteger   	, 0, false, true );       // Add BSA
		InitDataProperty(0, cnt++, dtData        ,150, daCenter, true,  prefix3 + "cre_dt"          	, false, "", dfDateYmd      , 0, false, true);
		InitDataProperty(0, cnt++, dtData        ,150, daCenter, true,  prefix3 + "upd_usr_id"          , false, "", dfNone        	, 0, false, true);
		InitDataProperty(0, cnt++, dtData        ,150, daCenter, true,  prefix3 + "usr_nm"          	, false, "", dfNone        	, 0, false, true);
		
	}
	break;
	
	case 4:
		with (sheetObj) {
		// 높이 설정
		style.height = 360;
		// 전체 너비 설정
		SheetWidth = mainTable.clientWidth;

		//Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "")
			InitHostInfo(location.hostname, location.port, page_path);

		//전체Merge 종류 [선택, Default msNone]
		MergeSheet = msHeaderOnly;

		//전체Edit 허용 여부 [선택, Default false]
		Editable = true;

		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo(2, 1, 3, 100);

		var HeadTitle  = "||YYYY-WW|Office|Rev/Exp|Trade|Lane|Vessel|Voyage|Direction|Port|Port Seq.|Carrier|BSA|Add BSA|Add\nBSA Carrier|OUS\nBSA|Ton/TEU|OUS\nWeight"
			+"|20' HC|20' HC|40' HC|40' HC|45'|45'|45'|Round\nKind|Round\nType|RF Alloc|RF Alloc|IPC\nOUS|RDR Port|Revenue Port ETD|RDR Finish|BSA\nPrice|OUS Price|OUS Price|OUS Price|OUS Price|OUS Price"
			+"|R/F Price|R/F Price|Price\nFinish|VVD+Port+Seq+Crr|Remark RDR|Remark FAR J/O|Update\nDate|Update ID|Update Name|Delete\nMark";
		var HeadTitle2 = "||YYYY-WW|Office|Rev/Exp|Trade|Lane|Vessel|Voyage|Direction|Port|Port Seq.|Carrier|BSA|Add BSA|Add\nBSA Carrier|OUS\nBSA|Ton/TEU|OUS\nWeight"
			+"|Sub Alloc|Over Ratio (F)|Sub Alloc|Over Ratio (F)|Sub Alloc|Under Ratio (F)|Over Ratio (F)|Round\nKind|Round\nType|Ocean|Inter|IPC\nOUS|RDR Port|Revenue Port ETD|RDR Finish|BSA\nPrice"
			+"|Ocean|Inter|MT(Ocean)|MT(Inter)|Sector Price|Ocean|Inter|Price\nFinish|VVD+Port+Seq+Crr|Remark RDR|Remark FAR J/O|Update\nDate|Update ID|Update Name|Delete\nMark";
		var headCount = ComCountHeadTitle(HeadTitle);

		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(headCount, 13, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다.
		InitHeadMode(true, true, true, false, true, false)
		
		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle, true);
		InitHeadRow(1, HeadTitle2, true);

		//데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,		COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT,	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		InitDataProperty(0, cnt++, dtStatus      , 30, daCenter, true, prefix4 + "ibflag" );
		InitDataProperty(0, cnt++, dtCheckBox    , 30, daCenter, true,  prefix4 + "del_chk"); //dtCheckBox
		
		InitDataProperty(0, cnt++, dtData   	 , 70, daCenter, true,  prefix4 + "yrwk"              		, false, "", dfDateYm      	, 0, false, false);      // YYYY-MM
		InitDataProperty(0, cnt++, dtCombo   	 , 70, daCenter, true,  prefix4 + "ofc_cd"              		, false, "", dfNone        	, 0, false, true ,6);      // Office
		InitDataProperty(0, cnt++, dtCombo       , 60, daCenter, true,  prefix4 + "re_divr_cd"          		, false, "", dfNone        	, 0, false, true );        // Rev/Exp
		InitDataProperty(0, cnt++, dtCombo       , 50, daCenter, true,  prefix4 + "trd_cd"              		, false, "", dfNone        	, 0, false, true );        // Trade
		InitDataProperty(0, cnt++, dtData        , 60, daCenter, true,  prefix4 + "rlane_cd"            		, false, "", dfNone        	, 0, false, true );        // Lane
		InitDataProperty(0, cnt++, dtData        , 60, daCenter, true,  prefix4 + "vsl_cd"            		, false, "", dfNone        	, 0, false, true ,4 );     // Vessel
		InitDataProperty(0, cnt++, dtData        , 60, daCenter, true,  prefix4 + "skd_voy_no"          		, false, "", dfNone        	, 0, false, true ,4 );     // Vessel
		InitDataProperty(0, cnt++, dtCombo       , 60, daCenter, true,  prefix4 + "skd_dir_cd"               , false, "", dfNone        	, 0, false, true );        // Direction
		InitDataProperty(0, cnt++, dtData   	 , 60, daCenter, true,  prefix4 + "port_cd"            		, false, "", dfNone        	, 0, false, true ,5 );     // Port
		InitDataProperty(0, cnt++, dtData        , 70, daCenter, true,  prefix4 + "port_seq"           		, false, "", dfNone        	, 0, false, true, 3 );     // Port Seq.
		
		InitDataProperty(0, cnt++, dtData        , 80, daCenter, true,  prefix4 + "jo_crr_cd"           		, false, "", dfNone        	, 0, false, true ,3);      // Carrier
		InitDataProperty(0, cnt++, dtData        , 80, daRight , true,  prefix4 + "jo_bsa_teu_qty"      		, false, "", dfInteger     	, 2, true , true );        // BSA			
		InitDataProperty(0, cnt++, dtData        , 80, daRight,  true,  prefix4 + "jo_bsa_add_teu_qty"      	, false, "", dfInteger   	, 0, false, true );        // Add BSA 
		InitDataProperty(0, cnt++, dtCombo       , 80, daCenter, true,  prefix4 + "jo_add_bsa_crr_flg"      	, false, "", dfNone   	   	, 0, true , true );        // Add BSA Carrier 
		InitDataProperty(0, cnt++, dtData        , 80, daRight,  true,  prefix4 + "jo_ovr_bsa_teu_qty"       , false, "", dfInteger   	, 2, false, true );        // OUS BSA
		InitDataProperty(0, cnt++, dtData        ,100, daRight,  true,  prefix4 + "jo_ton_teu_qty"     		, false, "", dfFloat   		, 2, true , true );        // Ton/TEU
		InitDataProperty(0, cnt++, dtData        , 90, daRight , true,  prefix4 + "jo_ovr_ton_wgt"    		, false, "", dfFloat 		, 2, true , true );        // OUS Weight 
		InitDataProperty(0, cnt++, dtData        , 90, daRight , false, prefix4 + "jo_20ft_sub_teu_qty"    	, false, "", dfInteger 		, 0, true , true );        // 20'HC Sub Alloc 
		InitDataProperty(0, cnt++, dtData        ,100, daRight,  false, prefix4 + "jo_20ft_ovr_rto"     		, false, "", dfFloat 		, 3, true , true );        // 20' Over Ratio
		InitDataProperty(0, cnt++, dtData        ,100, daRight,  false, prefix4 + "jo_40ft_sub_teu_qty"    	, false, "", dfInteger 		, 0, true , true );        // 40'HC Sub Alloc
		
		InitDataProperty(0, cnt++, dtData        ,110, daRight,  false, prefix4 + "jo_40ft_ovr_rto"      	, false, "", dfFloat 		, 3, true , true );        // 40' Over Ratio
		InitDataProperty(0, cnt++, dtData        ,100, daRight,  false, prefix4 + "jo_45ft_sub_teu_qty"      , false, "", dfInteger   	, 0, true , true );        // 45' Sub Alloc
		InitDataProperty(0, cnt++, dtData        ,100, daRight,  false, prefix4 + "jo_45ft_und_rto"  		, false, "", dfFloat 		, 3, true , true );        // 45' Under Ratio
		InitDataProperty(0, cnt++, dtData        ,100, daRight,  false, prefix4 + "jo_45ft_ovr_rto"			, false, "", dfFloat 		, 3, true , true );        // 45' Over Ratio			
		InitDataProperty(0, cnt++, dtCombo       , 90, daCenter, true,  prefix4 + "jo_rnd_knd_flg"          	, false, "", dfNone        	, 0, true , true);         // Round Kind
		InitDataProperty(0, cnt++, dtCombo       , 90, daCenter, true,  prefix4 + "jo_rnd_rule_lvl"          , false, "", dfNone        	, 0, true , true);         // Round Type			
		InitDataProperty(0, cnt++, dtData        ,110, daRight,  true,  prefix4 + "jo_rf_ocn_teu_qty"       	, false, "", dfInteger      , 0, true , true);         // RF Alloc Ocean
		InitDataProperty(0, cnt++, dtData   	 , 80, daRight,  true,  prefix4 + "jo_rf_inter_teu_qty"      , false, "", dfInteger     	, 0, true , true );        // RF Alloc Inter			
		InitDataProperty(0, cnt++, dtCombo       , 90, daCenter, true,  prefix4 + "jo_inter_ovr_flg"         , false, "", dfNone        	, 0, true , true);         // IPC OUS			
		InitDataProperty(0, cnt++, dtData        , 90, daCenter, true,  prefix4 + "jo_rdr_port_cd"          	, false, "", dfNone        	, 0, true , true,5);       // RDR Port
		InitDataProperty(0, cnt++, dtData        ,120, daCenter, true,  prefix4 + "rev_port_etd_dt"        	, false, "", dfDateYmd    	, 0, false, false);			// Revenue Port ETD
		
		InitDataProperty(0, cnt++, dtCombo       , 90, daCenter, true,  prefix4 + "jo_fsh_flg"          		, false, "", dfNone        	, 0, true , true);         // RDR Finish			
		InitDataProperty(0, cnt++, dtData  		 , 80, daRight,  true,  prefix4 + "jo_bsa_prc"         		, false, "", dfFloat     	, 2, true , true );        // BSA Price
		InitDataProperty(0, cnt++, dtData        ,120, daRight,  true,  prefix4 + "jo_ovr_ocn_prc"           , false, "", dfFloat 		, 2, true , true);         // OUS Price Ocean			
		InitDataProperty(0, cnt++, dtData        ,120, daRight,  true,  prefix4 + "jo_ovr_inter_prc"         , false, "", dfFloat 		, 2, true , true);         // OUS Price Inter
		InitDataProperty(0, cnt++, dtData        , 80, daRight,  true,  prefix4 + "jo_ovr_mt_ocn_prc"        , false, "", dfFloat        , 2, true , true);         // OUS Price MT(Ocean)
		InitDataProperty(0, cnt++, dtData        , 90, daRight,  true,  prefix4 + "jo_ovr_mt_inter_prc"      , false, "", dfFloat        , 2, true , true);         // OUS Price MT(Inter)
		InitDataProperty(0, cnt++, dtCombo       , 90, daCenter, true,  prefix4 + "jo_sctr_prc_flg"          , false, "", dfNone        	, 0, true , true);         // OUS Price Sector Price
		InitDataProperty(0, cnt++, dtData        , 90, daRight,  true,  prefix4 + "jo_rf_ocn_prc"          	, false, "", dfFloat        , 2, true , true);         // R/F Price Ocean			
		InitDataProperty(0, cnt++, dtData        , 90, daRight,  true,  prefix4 + "jo_rf_inter_prc"          , false, "", dfFloat        , 2, true , true);         // R/F Price Inter						
		InitDataProperty(0, cnt++, dtCombo       , 90, daCenter, true,  prefix4 + "jo_prc_fsh_flg"      		, false, "", dfNone        	, 0, true , true);         // Price Finish
		
		InitDataProperty(0, cnt++, dtData        ,140, daCenter, true,  prefix4 + "vvd_port"            		, false, "", dfNone        	, 0, false, true ,17 );    // Vessel			
		InitDataProperty(0, cnt++, dtData        ,300, daCenter, true,  prefix4 + "jo_bsa_entr_rdr_rmk"      , false, "", dfNone        	, 0, true , true,500);     // Remark RDR
		InitDataProperty(0, cnt++, dtData        ,300, daCenter, true,  prefix4 + "jo_bsa_entr_rmk"        	, false, "", dfNone        	, 0, true , true,500);     // Remark FAR J/O
		InitDataProperty(0, cnt++, dtData        , 90, daCenter, true,  prefix4 + "upd_dt"          			, false, "", dfDateYmd      , 0, false, true);
		InitDataProperty(0, cnt++, dtData        , 90, daCenter, true,  prefix4 + "upd_usr_id"          		, false, "", dfNone        	, 0, false, true);
		InitDataProperty(0, cnt++, dtData        ,120, daCenter, true,  prefix4 + "usr_nm"          			, false, "", dfNone        	, 0, false, true);
		InitDataProperty(0, cnt++, dtCombo       , 80, daCenter, true,  prefix4 + "delt_flg"            		, false, "", dfNone        	, 0, true, true);
		
		
		ImageList(0) = "/hanjin/img/button/btns_calendar.gif";	
		
        InitDataValid(0, prefix4 + "vsl_cd", vtEngUpOther, "0123456789");  //영문대문자+숫자   
        InitDataValid(0, prefix4 + "skd_voy_no", vtNumericOnly);    	   	// 숫자만
        InitDataValid(0, prefix4 + "port_cd", vtEngUpOnly);    			// 영대문자만
        InitDataValid(0, prefix4 + "port_seq", vtNumericOnly);    			// 숫자만            
        InitDataValid(0, prefix4 + "jo_crr_cd", vtEngUpOnly);    			// 영대문자만
        
        InitDataValid(0, prefix4 + "jo_rdr_port_cd", vtEngUpOnly);    			// 영대문자만
		InitDataCombo(0, prefix4 + "re_divr_cd" , "Rev|Exp", "R|E");
		InitDataCombo(0, prefix4 + "delt_flg"   , "Y|N", "Y|N");
		InitDataCombo(0, prefix4 + "skd_dir_cd"   , " |E|W|S|N", " |E|W|S|N");
		InitDataCombo(0, prefix4 + "jo_add_bsa_crr_flg"   , "Y|N", "Y|N");
		InitDataCombo(0, prefix4 + "jo_sctr_prc_flg"   , "Y|N", "Y|N");
		InitDataCombo(0, prefix4 + "jo_inter_ovr_flg"  , "Y|N", "Y|N");
		InitDataCombo(0, prefix4 + "jo_rnd_knd_flg"   , "S|G", "S|G");
		InitDataCombo(0, prefix4 + "jo_rnd_rule_lvl"   , "No|Round|Up|Down", "4|1|2|3");			
		InitDataCombo(0, prefix4 + "jo_fsh_flg"  , "Y|N", "Y|N");
		InitDataCombo(0, prefix4 + "jo_prc_fsh_flg"  , "Y|N", "Y|N");
		
		
		var trdList = gTrdCd.split("|");
		var trdSheet = "";
		var trdCodeName = "";
		for (var i=0; i<trdList.length; i++){
			trdCodeName = trdList[i].split(",");
			if (i == 0){
				trdSheet = trdCodeName[0];
			}else{
				trdSheet = trdSheet + "|" + trdCodeName[0];
			}
		}

		//OFC_CD
		var ofcCdList = gOfcCd.split("|");
		var ofcSheet = "";
		var ofcCodeName = "";
		for (var i=0; i<ofcCdList.length; i++){
			ofcCodeName = ofcCdList[i].split(",");
			if (i == 0){
				ofcSheet = ofcCodeName[0];
			}else{
				ofcSheet = ofcSheet + "|" + ofcCodeName[0];
			}
		}
		InitDataCombo(0, prefix4 +"ofc_cd"      , ofcSheet  , ofcSheet);
		InitDataCombo(0, prefix4 +"trd_cd"      , trdSheet  , trdSheet);

		InitComboNoMatchText(true);
		//ComboOpenMode = true; //한번 클릭으로 펼쳐짐
	}
		break;
	}
}
	
	//Pop-up창에서 Close시 호출한다.
	function parentSearch() {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
	
	//Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;


		
		switch (sAction) {
	
		case IBSEARCH: //조회
			formObj.f_cmd.value = SEARCH01;
			sheetObj.WaitImageVisible = true;
			if(document.form.add_carrier.checked){
				sheetObjects[2].DoSearch("FNS_JOO_0091GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix3));
			}else{
				sheetObjects[0].DoSearch("FNS_JOO_0091GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			}
			sheetObj.WaitImageVisible = false;
			break;
	
		case IBSAVE:
		
			if(document.form.add_carrier.checked){
				if(ComGetSaveString(sheetObjects[2]) == "") return;
				
				formObj.f_cmd.value = MULTI02;
				
				var SaveStr = ComGetSaveString(sheetObj); // 배열입니다.
				if (SaveStr == ""){
					ComShowCodeMessage("JOO00036");
					return false;			
				}
				
				if (!ComShowCodeConfirm("JOO00046")){
					return false;
				}
				
				var sParam = FormQueryString(formObj) + "&" + ComGetSaveString(sheetObjects[2]);
//				var sXml = sheetObj.GetSaveXml("FNS_JOO_0093GS.do", sParam +  "&src_id=FNS_JOO_0091");
				var sXml = sheetObjects[2].GetSaveXml("FNS_JOO_0091GS.do", sParam);
				
				sheetObjects[2].LoadSaveXml(sXml);		
//				doActionIBSheet(sheetObjects[2], formObj, IBSEARCH);
				
			}else{
				
				if (!validateForm(sheetObj, formObj, sAction))
				return;	
				formObj.f_cmd.value = MULTI;
			
				var SaveStr = ComGetSaveString(sheetObj); // 배열입니다.
				if (SaveStr == ""){
					ComShowCodeMessage("JOO00036");
					return false;			
				}
				
				if (!ComShowCodeConfirm("JOO00046")){
					return false;
				}
					sheetObj.WaitImageVisible = true;
				var sXml = sheetObj.GetSaveXml("FNS_JOO_0091GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
		
					sheetObj.LoadSaveXml(sXml);		
//					doActionIBSheet(sheetObj, formObj, IBSEARCH);
					sheetObj.WaitImageVisible = false;				
			}
			
			
			
			
			break;
		
		case IBSEARCH_ASYNC01: //OFFICE CODE Validation Check(For IBSheet Cell)
			formObj.f_cmd.value = SEARCH11;
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj)+"&code="+sheetObj.CellValue(gRow, prefix+"ofc_cd"));
			if (ComGetEtcData(sXml,"RESULT") == "E"){
				ComShowCodeMessage("JOO00136", "Office");
				sheetObj.CellValue2(gRow, prefix+"ofc_cd") = "";
				sheetObj.SelectCell(gRow, prefix+"ofc_cd");
			}
			break;
	
		case IBSEARCH_ASYNC02: //OFFICE CODE Validation Check(For Input Box)
			formObj.f_cmd.value = SEARCH11;
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj)+"&code="+formObj.ofc_cd.value);
			if (ComGetEtcData(sXml,"RESULT") == "E"){
				ComShowCodeMessage("JOO00136", "Office");
				formObj.ofc_cd.value = "";
				formObj.ofc_cd.focus();
			}
			break;
	
		case IBSEARCH_ASYNC03: //IBSheet상의 Trade Code변경시 Revenue Lane Setting
			formObj.f_cmd.value = SEARCH16;
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj)+"&code=&super_cd1=&super_cd2="+sheetObj.CellValue(gRow, prefix+"trd_cd"));
			var rlaneCdList = ComGetEtcData(sXml,"rlane_combo_sheet");
			sheetObj.InitCellProperty(gRow, prefix+"rlane_cd", dtCombo);
	        sheetObj.CellComboItem(gRow, prefix+"rlane_cd" , rlaneCdList, rlaneCdList);
			sheetObj.CellValue2(gRow, prefix+"rlane_cd") = "";
			sheetObj.CellValue2(gRow, prefix+"jo_crr_cd") = "";
			break;
	
		case IBSEARCH_ASYNC04: 
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("FNS_JOO_0085GS.do", "f_cmd=102"
					+"&ofc_cd="+sheetObj.CellValue(gRow, prefix+"ofc_cd")
					+"&re_divr_cd="+sheetObj.CellValue(gRow, prefix+"re_divr_cd")
					+"&trd_cd="+sheetObj.CellValue(gRow, prefix+"trd_cd")
					+"&rlane_cd="+sheetObj.CellValue(gRow, prefix+"rlane_cd"));
	
			var code = ComGetEtcData(sXml,"CODE");
			var text = ComGetEtcData(sXml,"TEXT");
			var comboList = text.split("|");
	
			if (sheetObj.RowStatus(gRow) == "I"){
				sheetObj.CellValue2(gRow, prefix+"agmt_eff_dt") = "";
				sheetObj.CellValue2(gRow, prefix+"agmt_exp_dt") = "";
			}
	
			//기존 같은 Data가 없으면 수기 입력 가능
			if (code == "" || comboList.length == 0){
				sheetObj.InitCellProperty(gRow, prefix+"jo_ver_no", dtData);
				sheetObj.CellEditable(gRow, prefix+"jo_ver_no") = false;
			}else if (comboList.length >= 1){
				if (ComShowCodeConfirm("JOO00188",comboList.length)){
					sheetObj.InitCellProperty(gRow, prefix+"jo_ver_no", dtData);
					sheetObj.CellEditable (gRow, prefix+"agmt_eff_dt") = true;
					sheetObj.CellEditable (gRow, prefix+"agmt_exp_dt") = true;
			        sheetObj.SelectCell(gRow, prefix+"rlane_cd");
				}else{
					sheetObj.InitCellProperty(gRow, prefix+"jo_ver_no", dtCombo);
					sheetObj.CellEditable (gRow, prefix+"agmt_eff_dt") = false;
					sheetObj.CellEditable (gRow, prefix+"agmt_exp_dt") = false;
			        sheetObj.CellComboItem(gRow, prefix+"jo_ver_no" , text, code);
					sheetObj.CellValue2(gRow, prefix+"jo_ver_no"  ) = "";
					sheetObj.CellValue2(gRow, prefix+"agmt_eff_dt") = "";
					sheetObj.CellValue2(gRow, prefix+"agmt_exp_dt") = "";
			        sheetObj.SelectCell(gRow, prefix+"del_chk");
				}
			}
	
			break;
				
		case IBSEARCH_ASYNC05: //IBSheet상의 Lane Code변경시 Vessel Setting
			formObj.f_cmd.value = SEARCH21;
			sheetObj.WaitImageVisible = false;
			//var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj)+"&code=&super_cd1=&super_cd2="+sheetObj.CellValue(gRow, prefix+"trd_cd"));
			var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj)+"&code=&super_cd1="+sheetObj.CellValue(gRow, prefix+"trd_cd")+"&super_cd2="+sheetObj.CellValue(gRow, prefix+"rlane_cd"));
			var vslCdList = ComGetEtcData(sXml,"vsl_combo_sheet");
					
			if (vslCdList.length == 0) {
				sheetObj.InitCellProperty(gRow, prefix+"vsl_cd", dtData);
			} else {
				sheetObj.InitCellProperty(gRow, prefix+"vsl_cd", dtCombo);
	        	sheetObj.CellComboItem(gRow, prefix+"vsl_cd" , vslCdList, vslCdList);
			}
			
			sheetObj.CellValue2(gRow, prefix+"vsl_cd") = "";
			break;
			
		case IBSEARCH_ASYNC06: //IBSheet상의 Vessel Code변경시 Port Setting
			formObj.f_cmd.value = SEARCH22;
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj)+"&code=&super_cd1="+sheetObj.CellValue(gRow, prefix+"trd_cd")+"&super_cd2="+sheetObj.CellValue(gRow, prefix+"rlane_cd")+"&super_cd3="+sheetObj.CellValue(gRow, prefix+"vsl_cd"));
			var vpsPortCdList = ComGetEtcData(sXml,"vpsport_combo_sheet");
			
			if (vpsPortCdList.length == 0) {
				sheetObj.InitCellProperty(gRow, prefix+"port_cd", dtData);
			} else {
				sheetObj.InitCellProperty(gRow, prefix+"port_cd", dtCombo);
	        	sheetObj.CellComboItem(gRow, prefix+"port_cd" , 'ALL|'+vpsPortCdList, 'ALL|'+vpsPortCdList);
			}
			
			sheetObj.CellValue2(gRow, prefix+"port_cd") = "";
			break;
			
		
		case IBSEARCH_ASYNC07: //VSL Code 변경시 공통 MDM_VSL_CNTR 테이블에서 VSL_CD 조회
			formObj.f_cmd.value = SEARCH23;
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj)+"&code=&super_cd1="+formObj.vsl_cd.value);
			if (ComGetEtcData(sXml,"RESULT") == "E"){
				ComShowCodeMessage("JOO00199");
				formObj.vsl_cd.value = "";
				formObj.vsl_cd.focus();
			}
			break;
		
		case IBSEARCH_ASYNC08: //Port Code 변경시 BSA Information Entry 공통 MDM_LOCATION 테이블에서 LOC_CD 조회
			formObj.f_cmd.value = SEARCH24;
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj)+"&code=&super_cd1="+formObj.port_cd.value);
			if (ComGetEtcData(sXml,"RESULT") == "E"){
				ComShowCodeMessage("JOO00200");
				formObj.port_cd.value = "";
				formObj.port_cd.focus();
			}
			break;
			
		case IBSEARCH_ASYNC09: //Port Code 변경시 BSA Information Entry 공통 MDM_LOCATION 테이블에서 LOC_CD 조회
			formObj.f_cmd.value = SEARCH24;
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj)+"&code=&super_cd1="+sheetObj.CellValue(gRow, prefix+"port_cd"));
			if (ComGetEtcData(sXml,"RESULT") == "E"){
				ComShowCodeMessage("JOO00200");
				formObj.port_cd.value = "";
				formObj.port_cd.focus();
			}
			break;
			
		case IBSEARCH_ASYNC10: //BSA Information Entry 공통 VSK_VSL_PORT_SKD 테이블에서 VSL_CD 조회
			formObj.f_cmd.value = SEARCH25;
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj)+"&code=&super_cd1="+sheetObj.CellValue(gRow, prefix+"jo_end_vsl_cd")+"&super_cd2="+sheetObj.CellValue(gRow, prefix+"jo_end_skd_voy_no")+"&super_cd3="+sheetObj.CellValue(gRow, prefix+"jo_end_skd_dir_cd"));
			if (ComGetEtcData(sXml,"RESULT") == "E"){
				ComShowCodeMessage("JOO00031");
				sheetObj.CellValue2(gRow, prefix+"jo_end_vsl_cd") = "";
				sheetObj.CellValue2(gRow, prefix+"jo_end_skd_voy_no") = "";
				sheetObj.CellValue2(gRow, prefix+"jo_end_skd_dir_cd") = "";
			    sheetObj.SelectCell(gRow, prefix+"jo_end_vsl_cd");
			}
			break;
        
		case "TARGETEXCEL":
			if(validateForm(sheetObj, formObj, sAction)) {
				formObj.f_cmd.value = SEARCH04;
				sheetObj.WaitImageVisible = true;
				sheetObj.DoSearch("FNS_JOO_0091GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix4));
				sheetObj.WaitImageVisible = false;
				
			}
			
			break;
			
		case "TARGETRETRIEVE":
			if(validateForm(sheetObj, formObj, sAction)) {
				formObj.f_cmd.value = SEARCH04;
				sheetObj.WaitImageVisible = true;
				sheetObj.DoSearch("FNS_JOO_0091GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				sheetObj.WaitImageVisible = false;				
				
			}
			
			break;
		}
		
	}
	
	/**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */
	function initCombo(comboObj, comboNo) {
		var formObj = document.form;
	
		switch (comboObj.id) {
		case "re_divr_cd":
			with (comboObj) {
				MultiSelect = false;
				UseAutoComplete = true;
				SetColAlign("left");
				SetColWidth("60");
				DropHeight = 160;
				ValidChar(2, 0);//영문대문자만 입력가능
				MaxLength = 7;
			}
			var comboItems = "ALL, |Rev,R|Exp,E";
			UF_addComboItem(comboObj, comboItems.split("|"));
			comboObj.Text2 = "ALL";
			break;
			
		case "jo_crr_cd":
			with (comboObj) {
				MultiSelect = false;
				UseAutoComplete = true;
				SetColAlign("left");
				SetColWidth("30");
				DropHeight = 160;
				ValidChar(2, 0);//영문대문자만 입력가능
				MaxLength = 3;
			}
			var comboItems = ("ALL, |"+gCrrCd+"|SML,SML").split("|");
			UF_addComboItem(comboObj, comboItems);
			
			comboObj.Text2 = "ALL";
			break;
	
		case "trd_cd":
			with (comboObj) {
				MultiSelect = false;
				UseAutoComplete = true;
				SetColAlign("left");
				SetColWidth("30");
				DropHeight = 160;
				ValidChar(2, 0);//영문대문자만 입력가능
				MaxLength = 3;
			}
			var comboItems = ("ALL, |"+gTrdCd).split("|");
			UF_addComboItem(comboObj, comboItems);
			comboObj.Text2 = "ALL";
			break;
	
		case "rlane_cd":
			with (comboObj) {
				MultiSelect = false;
				UseAutoComplete = true;
				SetColAlign("left");
				SetColWidth("50");
				DropHeight = 160;
				ValidChar(2, 1);//영문대문자+숫자만 입력가능
				MaxLength = 5;
			}
				
			var sheetObj = sheetObjects[0];
			formObj.f_cmd.value = SEARCH16;
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj)+"&code=&super_cd2="+formObj.trd_cd.Code+"&super_cd1="+formObj.jo_crr_cd.Code);
	        ComXml2ComboItem(sXml, formObj.rlane_cd,"code","code");
	        comboObj.InsertItem(0, "ALL", " ");
	        comboObj.Index2 = 0;
			
			break;
			
		case "delt_flg":
			with (comboObj) {
				MultiSelect = false;
				UseAutoComplete = true;
				SetColAlign("left");
				SetColWidth("60");
				DropHeight = 200;
				ValidChar(2, 0);//영문대문자만 입력가능
				MaxLength = 3;
			}
			var comboItems = "ALL, |Y,Y|N,N";
			UF_addComboItem(comboObj, comboItems.split("|"));
//			comboObj.Code2 = "N";
			comboObj.Text2 = "ALL";
			
			break;
			
		case "jo_fsh_flg":
			with (comboObj) {
				MultiSelect = false;
				UseAutoComplete = true;
				SetColAlign("left");
				SetColWidth("60");
				DropHeight = 200;
				ValidChar(2, 0);//영문대문자만 입력가능
				MaxLength = 3;
			}
			var comboItems = "ALL, |Y,Y|N,N";
			UF_addComboItem(comboObj, comboItems.split("|"));
//			comboObj.Code2 = "Y";
			comboObj.Text2 = "ALL";
			
			break;
			
		case "jo_prc_flg":
			with (comboObj) {
				MultiSelect = false;
				UseAutoComplete = true;
				SetColAlign("left");
				SetColWidth("60");
				DropHeight = 200;
				ValidChar(2, 0);//영문대문자만 입력가능
				MaxLength = 3;
			}
			var comboItems = "ALL, |Y,Y|N,N";
			UF_addComboItem(comboObj, comboItems.split("|"));
			comboObj.Text2 = "ALL";
			
			break;			
			
		case "ofc_cd":
			with (comboObj) {
				MultiSelect = false;
				UseAutoComplete = true;
				SetColAlign("left");
				SetColWidth("60");
				DropHeight = 200;
				ValidChar(2,2);//영문대문자만 입력가능
				MaxLength=3;
			}
			var comboItems = gOfcCd.split("|");
			addComboItem(comboObj, comboItems);
			comboObj.Index2 = 0;
	        if (comboItems.length == 1){
	        	comboObj.Enable = false;
	        }else{
	        	comboObj.Enable = true;
	        }
			break;
	
		case "skd_dir_cd":
			with (comboObj) {
				MultiSelect = false;
				UseAutoComplete = true;
				SetColAlign("left");
				SetColWidth("60");
				DropHeight = 160;
				ValidChar(2, 0);//영문대문자만 입력가능
				MaxLength = 1;
			}
			var comboItems = "ALL, |E,E|W,W|S,S|N,N";
			UF_addComboItem(comboObj, comboItems.split("|"));
			comboObj.Text2 = "ALL";
			break;
			
		}
	}
	
	//조회조건필드인 Lane SVC Type 데이터 조회
	function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboKey) {
	    sheetObj.ShowDebugMsg = false;	
	    switch(sAction) {	
	       case IBSEARCH: //TRADE
				if (sComboObj.id == "trd_cd"){
					//콤보필드를 초기화시킨다.
					sComboObj.RemoveAll();
					formObj.f_cmd.value = SEARCH15;
					sheetObj.WaitImageVisible = false;
					var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj)+"&code=&super_cd1="+formObj.jo_crr_cd.Code+"&super_cd2=");
	                ComXml2ComboItem(sXml, formObj.trd_cd,"code","code");
					sComboObj.InsertItem(0, "ALL", " ");
					sComboObj.Index2 = 0;
	    	   }else if (sComboObj.id == "rlane_cd") {
					//콤보필드를 초기화시킨다.
					sComboObj.RemoveAll();
								
					formObj.f_cmd.value = SEARCH16;
					sheetObj.WaitImageVisible = false;
					var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj)+"&code=&super_cd2="+formObj.trd_cd.Code+"&super_cd1=");
					var comboItems = ("ALL, |"+ComGetEtcData(sXml, "rlane_cd")).split("|");
					addComboItem(comboObjects[1],comboItems);
					sComboObj.Index2 = 0;
				}
				break;
	    }
	}
	
	
	/**
	 * Popup Data Validation Check. <br>
	 **/
	function ofc_cd_pop_event(aryPopupData) {
		document.form.ofc_cd.value = aryPopupData[0][3];
//		sheetObjects[0].RemoveAll();
	}
	
	function re_divr_cd_OnChange(comboObj, Code, Text) {
//		sheetObjects[0].RemoveAll(); 2013.04.18 LSJ 
	}
	
	function jo_crr_cd_OnChange(comboObj, code, text){
//		sheetObjects[0].RemoveAll();  2013.04.18 LSJ 
	
	}
	
	//TRADE 변경시 LANE 변경
	function trd_cd_OnChange(comboObj, Code, Text){
		var formObj = document.form;
		formObj.rlane_cd.Index2 = -1;
		formObj.rlane_cd.RemoveAll();
		doActionIBCombo(sheetObjects[0], formObj, IBSEARCH, comboObjects[1] ,"rlane_cd");
		formObj.trd_cd.focus();
	
	}
	
	function rlane_cd_OnChange(comboObj, code, text){
		//sheetObjects[0].RemoveAll(); 
	}
	
	function upload_flg_OnChange(){
		sheetObjects[0].RemoveAll(); 
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
		with (formObj) {
			switch (sAction) {

			case  IBSAVE: 
					if(formObj.add_carrier.checked == false){
					for(var i = 2; i <= sheetObj.LastRow;i++){
						var rowStatus = sheetObj.RowStatus(i);					
					
					    if (rowStatus == "I") {	
							if (sheetObj.CellValue(i, prefix+"ofc_cd").length < 5){
								ComShowCodeMessage("JOO00112");
								sheetObj.SelectCell(i, prefix+"ofc_cd");
								return false;
							}
			
							if (sheetObj.CellValue(i, prefix+"re_divr_cd").length < 1){
								ComShowCodeMessage("JOO00184");
								sheetObj.SelectCell(i, prefix+"re_divr_cd");
								return false;
							}
			
							if (sheetObj.CellValue(i, prefix+"trd_cd").length < 3){
								ComShowCodeMessage("JOO00009");
								sheetObj.SelectCell(i, prefix+"trd_cd");
								return false;
							}
			
							if (sheetObj.CellValue(i, prefix+"rlane_cd").length < 5){
								ComShowCodeMessage("JOO00010");
								sheetObj.SelectCell(i, prefix+"rlane_cd");
								return false;
							}
							
							if (sheetObj.CellValue(i, prefix+"vsl_cd").length < 1){
								ComShowCodeMessage("JOO00196");
								sheetObj.SelectCell(i, prefix+"vsl_cd");
								return false;
							}
							
							if (sheetObj.CellValue(i, prefix+"skd_dir_cd").length < 1) {
								ComShowCodeMessage("JOO00190");
								sheetObj.SelectCell(i, prefix+"skd_dir_cd");
								return false;					
							}
							
							if (sheetObj.CellValue(i, prefix+"port_cd").length < 1){
								ComShowCodeMessage("JOO00197");
								sheetObj.SelectCell(i, prefix+"port_cd");
								return false;
							}
							if (sheetObj.CellValue(i, prefix+"port_seq").length < 1 || sheetObj.CellValue(i, prefix+"port_seq").length >= 4){
								ComShowCodeMessage("JOO00198");
								sheetObj.SelectCell(i, prefix+"port_seq");
								return false;
							}
			
							if (sheetObj.CellValue(i, prefix+"jo_crr_cd").length == 0 || sheetObj.CellValue(i, prefix+"jo_crr_cd").length > 3){
								ComShowCodeMessage("JOO00008");
								sheetObj.SelectCell(i, prefix+"jo_crr_cd");
								return false;
							}
					    }
					}
				}
 			break;
 			
			case "TARGETRETRIEVE":
				if(formObj.trd_cd.Code == "ALL" || formObj.trd_cd.Code == " "){
					ComShowCodeMessage("JOO00009");
					return false;
				}
				if(formObj.rlane_cd.Code == "ALL" || formObj.rlane_cd.Code == " "){
					ComShowCodeMessage("JOO00010");
					return false;
				}
				break;
				
			case "TARGETEXCEL":
				if(formObj.trd_cd.Code == "ALL" || formObj.trd_cd.Code == " "){
					ComShowCodeMessage("JOO00009");
					return false;
				}
				if(formObj.rlane_cd.Code == "ALL" || formObj.rlane_cd.Code == " "){
					ComShowCodeMessage("JOO00010");
					return false;
				}
				break;
			}
		}
	
		return true;
	}
	
	
	
	function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
		var sName = sheetObj.ColSaveName(Col);
	
		var Value = sheetObj.EditValue;
	}
	
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		gRow = Row;
		var formObj = document.form;
	    switch (sheetObj.ColSaveName(Col)) {
			case prefix+"ofc_cd":
				doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC01);
				break;
		
			case prefix+"trd_cd":
				if (sheetObj.RowStatus(Row) == "I" || sheetObj.RowStatus(Row) == "U"){
					if (Value == ""){
						ComShowCodeMessage("JOO00009");
						sheetObj.SelectCell(Row, Col);
						return;
					}
					var reDivrCd = sheetObj.CellValue(Row, prefix+"re_divr_cd");
					if (reDivrCd == "E") {				
						doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03)
						sheetObj.CellValue2(Row, prefix+"jo_crr_cd") = "SML";
						sheetObj.CellEditable(Row, prefix+"jo_crr_cd") = true;
					} else {
						sheetObj.CellValue2(Row, prefix+"jo_crr_cd") = "";
						sheetObj.CellEditable(Row, prefix+"jo_crr_cd") = true;
						doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03)
					}
				}
				if (sheetObj.RowStatus(Row) == "I"){
					setYyyyWwDt(sheetObj, Row);
				}
				break;
			case prefix+"re_divr_cd":
				var reDivrCd = sheetObj.CellValue(Row, prefix+"re_divr_cd");
				if (reDivrCd == "E") {
					sheetObj.CellValue2(Row, prefix+"jo_crr_cd") = "SML";
					sheetObj.CellEditable(Row, prefix+"jo_crr_cd") = false;
				} else {
					sheetObj.CellValue2(Row, prefix+"jo_crr_cd") = "";
					sheetObj.CellEditable(Row, prefix+"jo_crr_cd") = true;
				}
				
				break;
			case prefix+"rlane_cd":
				if (sheetObj.RowStatus(Row) == "I" || sheetObj.RowStatus(Row) == "U"){
					if (sheetObj.CellValue(Row, prefix+"trd_cd") == ""){
						ComShowCodeMessage("JOO00009");
						sheetObj.SelectCell(Row, prefix+"trd_cd");
						return;
					}
					if (Value == ""){
						ComShowCodeMessage("JOO00010");
						sheetObj.SelectCell(Row, Col);
						return;
					}
					
					var trd   = sheetObj.CellValue(Row, prefix+"trd_cd");
					var rlane = sheetObj.CellValue(Row, prefix+"rlane_cd");
					var reDivrCd = sheetObj.CellValue(Row, prefix+"re_divr_cd");
					
					var crrList = "";
					
					if (reDivrCd == "R") {
						
						for(var k=0; k<gTrdLaneCrrArr.length; k++){
							if (trd == gTrdLaneCrrArr[k][0] && rlane == gTrdLaneCrrArr[k][1]){
								if (k==0){
									crrList = gTrdLaneCrrArr[k][2];
								}else{
									crrList = crrList+"|"+gTrdLaneCrrArr[k][2];
								}
							}
						}
						crrList = crrList+"|SML";
						
						sheetObj.InitCellProperty(Row, prefix+"jo_crr_cd", dtCombo);
				        sheetObj.CellComboItem(Row, prefix+"jo_crr_cd" , crrList, crrList);
				        sheetObj.CellValue2(Row, prefix+"jo_crr_cd") = "";
						sheetObj.CellEditable(Row, prefix+"jo_crr_cd") = true;
					} else {
						sheetObj.CellValue2(Row, prefix+"jo_crr_cd") = "SML";
						sheetObj.CellEditable(Row, prefix+"jo_crr_cd") = false;
					}
						//2013.09.10 김종옥 주석처리
			        	//doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC04);
	
						sheetObj.CellValue2(Row, prefix+"vsl_cd") = "";
						sheetObj.CellEditable(Row, prefix+"vsl_cd") = true;
						doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC05);
				}
				if (sheetObj.RowStatus(Row) == "I"){
					setYyyyWwDt(sheetObj, Row);
				}
				break;
			
			case prefix+"vsl_cd":
				sheetObj.CellValue2(Row, prefix+"port_cd") = "";
				sheetObj.CellEditable(Row, prefix+"port_cd") = true;
				doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC06);
				
				sheetObj.CellValue2(Row, prefix+"jo_st_vsl_cd") = sheetObj.CellValue(Row, prefix+"vsl_cd");
				sheetObj.CellValue2(Row, prefix+"jo_end_vsl_cd") = sheetObj.CellValue(Row, prefix+"vsl_cd");
				
				if (sheetObj.RowStatus(Row) == "I"){
					setYyyyWwDt(sheetObj, Row);
				}
				break;
			case prefix+"skd_voy_no":
				if (sheetObj.RowStatus(Row) == "I"){
					setYyyyWwDt(sheetObj, Row);
				}
				break;
			case prefix+"skd_dir_cd":
				sheetObj.CellValue2(Row, prefix+"jo_st_skd_dir_cd") = sheetObj.CellValue(Row, prefix+"skd_dir_cd");
				sheetObj.CellValue2(Row, prefix+"jo_end_skd_dir_cd") = sheetObj.CellValue(Row, prefix+"skd_dir_cd");
				if (sheetObj.RowStatus(Row) == "I"){
					setYyyyWwDt(sheetObj, Row);
				}
				break;
			case prefix+"jo_st_vsl_cd":
				var vsl_cd = sheetObj.CellValue(Row, prefix+"vsl_cd");				
				
					if ( vsl_cd != sheetObj.CellValue(Row, prefix+"jo_st_vsl_cd") ){
						alert("Wrong Start Vessel Code")
						sheetObj.CellValue2(Row, prefix+"jo_st_vsl_cd")= "";	
						sheetObj.SelectCell(Row, prefix+"jo_st_vsl_cd", true);
					}
				
				break;		
				
			case prefix+"re_divr_cd":
		        var reDivrCd = sheetObj.CellValue(Row, prefix+"re_divr_cd");
		        
		        var cdList = "";
		        var nmList = "";
		        
		        for (var j=0; j<gJoSrcCd.length; j++){
		        	if (reDivrCd == "E"){
		        		if (gJoSrcCd[j] == "B"){
			        		if (j==0){
			        			cdList = gJoSrcCd[j];
			        			nmList = gJoSrcNm[j];
			        		}else{
			        			cdList = cdList+"|"+gJoSrcCd[j];
			        			nmList = nmList+"|"+gJoSrcNm[j];
			        		}
		        		}
		        	}else if (reDivrCd == "R"){
		        		if (gJoSrcCd[j] != "B"){
			        		if (j==0){
			        			cdList = gJoSrcCd[j];
			        			nmList = gJoSrcNm[j];
			        		}else{
			        			cdList = cdList+"|"+gJoSrcCd[j];
			        			nmList = nmList+"|"+gJoSrcNm[j];
			        		}
		        		}
		        	}
		        }
				break;
			//2013.09.06 lsj수정 (jo_bsa_ref_no 삭제하고 vvd_port 추가)	
			case prefix+"jo_add_bsa_crr_flg":
				
				var joAddBsaCrrFlg = sheetObj.CellValue(Row, prefix+"jo_add_bsa_crr_flg");
				if (joAddBsaCrrFlg == 'Y') {
					var vvdPort = sheetObj.CellValue(Row, prefix+"vvd_port");
					if( vvdPort == '' ) {
						if (sheetObj.CellValue(Row, prefix+"ibflag") == "I"){
							ComShowCodeMessage("JOO00192");
						} else {
							alert("vvd port가 없습니다");
						}
						sheetObj.CellValue2(Row, prefix+"jo_add_bsa_crr_flg") = "N";
						return;
					} else {
						//var paramUrl = "pgmNo=FNS_JOO_0093&vvd_port="+vvdPort;
						var paramUrl = "pgmNo=FNS_JOO_0093&vvd_port="+vvdPort+"&vsl_cd="+sheetObj.CellValue(Row, prefix + "vsl_cd")+"&skd_voy_no="+sheetObj.CellValue(Row, prefix + "skd_voy_no")+"&skd_dir_cd="+sheetObj.CellValue(Row, prefix + "skd_dir_cd")+"&port_cd="+sheetObj.CellValue(Row, prefix + "port_cd")+"&port_seq="+sheetObj.CellValue(Row, prefix + "port_seq")+"&jo_crr_cd="+sheetObj.CellValue(Row, prefix + "jo_crr_cd");		
		
						ComOpenPopup("/hanjin/FNS_JOO_0093.do?"+paramUrl, 1055, 177,
							"setPopupData", "1,0,1,1,1,1,1,1", true, false, 0, 0, 0,
							"pop1");
						
					}
				} else if (joAddBsaCrrFlg == 'N') {
					sheetObj.CellValue2(Row, prefix+"jo_bsa_add_teu_qty") = "";
					var joBsaTeuQty = parseInt(ComNullToZero(sheetObj.CellValue(Row, prefix+"jo_bsa_teu_qty")));
					sheetObj.CellValue2(Row, prefix+"jo_ovr_bsa_teu_qty")    = joBsaTeuQty ;
				}
				break;
				
			case prefix+"port_cd":
				if (sheetObj.CellValue(Row, prefix+"port_cd") != "ALL") {
					doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC09);
				}
				break;
			
				
			//2013.06.17 이수진 추가(신철원씨 요청사항 - OUS Weight는 OUS BSA * Ton/Tue로 자동 계산되도록)	
			case prefix+"jo_bsa_teu_qty":
			case prefix+"jo_bsa_add_teu_qty":				
				var joBsaTeuQty = parseInt(ComNullToZero(sheetObj.CellValue(Row, prefix+"jo_bsa_teu_qty")));
				var joBsaAddTeuQty = parseInt(ComNullToZero(sheetObj.CellValue(Row, prefix+"jo_bsa_add_teu_qty")));
				sheetObj.CellValue2(Row, prefix+"jo_ovr_bsa_teu_qty")    = joBsaTeuQty + joBsaAddTeuQty;
				var joOverTeuQty = sheetObj.CellValue(Row, prefix+"jo_ovr_bsa_teu_qty")
				var joTonTueQty = parseFloat(ComNullToZero(sheetObj.CellValue(Row, prefix+"jo_ton_teu_qty")));
//				sheetObj.CellValue2(Row, prefix+"jo_ovr_ton_wgt")    = joOverTeuQty * joTonTueQty;
				break;
			
			
			//2013.06.17 이수진 추가(신철원씨 요청사항 - OUS Weight는 OUS BSA * Ton/Tue로 자동 계산되도록)		
			case prefix+"jo_ton_teu_qty":
				var joOverTeuQty = sheetObj.CellValue(Row, prefix+"jo_ovr_bsa_teu_qty")
				var joTonTueQty = parseFloat(ComNullToZero(sheetObj.CellValue(Row, prefix+"jo_ton_teu_qty")));
//				sheetObj.CellValue2(Row, prefix+"jo_ovr_ton_wgt")    = joOverTeuQty * joTonTueQty;
				
				break;
				
			case prefix+"jo_fsh_flg":
				//2013.02.18 이수진 (오미랑과장 요청사항-RDR Finish 가 Y 인건은 ROW DELETE 안되도록 보완 )
				if (sheetObj.CellValue(Row, prefix+"jo_fsh_flg") == "Y") {
					sheetObj.CellEditable(Row,prefix+"del_chk") = false;
					sheetObj.CellValue2(Row, prefix+"del_chk"  ) = "N";
					sheetObj.CellEditable(Row,prefix+"jo_bsa_teu_qty") = false;
//					sheetObj.CellEditable(Row,prefix+"jo_bsa_add_teu_qty") = false;
					sheetObj.CellEditable(Row,prefix+"jo_add_bsa_crr_flg") = false;
//					sheetObj.CellEditable(Row,prefix+"jo_ovr_bsa_teu_qty") = false;
					sheetObj.CellEditable(Row,prefix+"jo_ovr_ton_wgt") = false;
					sheetObj.CellEditable(Row,prefix+"jo_ton_teu_qty") = false;
					sheetObj.CellEditable(Row,prefix+"jo_20ft_sub_teu_qty") = false;
					sheetObj.CellEditable(Row,prefix+"jo_20ft_ovr_rto") = false;
					sheetObj.CellEditable(Row,prefix+"jo_40ft_sub_teu_qty") = false;
					sheetObj.CellEditable(Row,prefix+"jo_40ft_ovr_rto") = false;
					sheetObj.CellEditable(Row,prefix+"jo_45ft_sub_teu_qty") = false;
					sheetObj.CellEditable(Row,prefix+"jo_45ft_und_rto") = false;
					sheetObj.CellEditable(Row,prefix+"jo_45ft_ovr_rto") = false;
					sheetObj.CellEditable(Row,prefix+"jo_rnd_knd_flg") = false;
					sheetObj.CellEditable(Row,prefix+"jo_rnd_rule_lvl") = false;
					sheetObj.CellEditable(Row,prefix+"jo_rf_ocn_teu_qty") = false;
					sheetObj.CellEditable(Row,prefix+"jo_rf_inter_teu_qty") = false;			
					sheetObj.CellEditable(Row,prefix+"jo_inter_ovr_flg") = false;
					
				} else {
					sheetObj.CellEditable(Row,prefix+"del_chk") = true;
					sheetObj.CellEditable(Row,prefix+"jo_bsa_teu_qty") = true;
					sheetObj.CellEditable(Row,prefix+"jo_add_bsa_crr_flg") = true;
					sheetObj.CellEditable(Row,prefix+"jo_ovr_ton_wgt") = true;
					sheetObj.CellEditable(Row,prefix+"jo_ton_teu_qty") = true;
					sheetObj.CellEditable(Row,prefix+"jo_20ft_sub_teu_qty") = true;
					sheetObj.CellEditable(Row,prefix+"jo_20ft_ovr_rto") = true;
					sheetObj.CellEditable(Row,prefix+"jo_40ft_sub_teu_qty") = true;
					sheetObj.CellEditable(Row,prefix+"jo_40ft_ovr_rto") = true;
					sheetObj.CellEditable(Row,prefix+"jo_45ft_sub_teu_qty") = true;
					sheetObj.CellEditable(Row,prefix+"jo_45ft_und_rto") = true;
					sheetObj.CellEditable(Row,prefix+"jo_45ft_ovr_rto") = true;
					sheetObj.CellEditable(Row,prefix+"jo_rf_ocn_teu_qty") = true;
					sheetObj.CellEditable(Row,prefix+"jo_rf_inter_teu_qty") = true;
					sheetObj.CellEditable(Row,prefix+"jo_rnd_knd_flg") = true;
					sheetObj.CellEditable(Row,prefix+"jo_rnd_rule_lvl") = true;
					sheetObj.CellEditable(Row,prefix+"jo_inter_ovr_flg") = true;
				}
				break;
			case prefix+"jo_prc_fsh_flg":
				if (sheetObj.CellValue(Row, prefix+"jo_prc_fsh_flg") == "Y") {
					sheetObj.CellEditable(Row,prefix+"jo_bsa_prc") = false;
					sheetObj.CellEditable(Row,prefix+"jo_ovr_ocn_prc") = false;
					sheetObj.CellEditable(Row,prefix+"jo_ovr_inter_prc") = false;
					sheetObj.CellEditable(Row,prefix+"jo_ovr_mt_ocn_prc") = false;
					sheetObj.CellEditable(Row,prefix+"jo_ovr_mt_inter_prc") = false;
					sheetObj.CellEditable(Row,prefix+"jo_sctr_prc_flg") = false;
					sheetObj.CellEditable(Row,prefix+"jo_rf_ocn_prc") = false;
					sheetObj.CellEditable(Row,prefix+"jo_rf_inter_prc") = false;
				} else {
					sheetObj.CellEditable(Row,prefix+"jo_bsa_prc") = true;
					sheetObj.CellEditable(Row,prefix+"jo_ovr_ocn_prc") = true;
					sheetObj.CellEditable(Row,prefix+"jo_ovr_inter_prc") = true;
					sheetObj.CellEditable(Row,prefix+"jo_ovr_mt_ocn_prc") = true;
					sheetObj.CellEditable(Row,prefix+"jo_ovr_mt_inter_prc") = true;
					sheetObj.CellEditable(Row,prefix+"jo_sctr_prc_flg") = true;
					sheetObj.CellEditable(Row,prefix+"jo_rf_ocn_prc") = true;
					sheetObj.CellEditable(Row,prefix+"jo_rf_inter_prc") = true;
				}
				break;
				
			case prefix+"delt_flg":     //2013.02.18 이수진 추가(오미랑 과장 요청사항 - Y로되면, BSA ~ End port 까지 비활성화되도록 보완)
			
				if (sheetObj.CellValue(Row, prefix+"delt_flg") == "Y") {
					sheetObj.CellEditable(Row,prefix+"jo_bsa_teu_qty") = false;
//					sheetObj.CellEditable(Row,prefix+"jo_bsa_add_teu_qty") = false;
					sheetObj.CellEditable(Row,prefix+"jo_add_bsa_crr_flg") = false;
//					sheetObj.CellEditable(Row,prefix+"jo_ovr_bsa_teu_qty") = false;
					sheetObj.CellEditable(Row,prefix+"jo_ovr_ton_wgt") = false;
					sheetObj.CellEditable(Row,prefix+"jo_ton_teu_qty") = false;
					sheetObj.CellEditable(Row,prefix+"jo_20ft_sub_teu_qty") = false;
					sheetObj.CellEditable(Row,prefix+"jo_20ft_ovr_rto") = false;
					sheetObj.CellEditable(Row,prefix+"jo_40ft_sub_teu_qty") = false;
					sheetObj.CellEditable(Row,prefix+"jo_40ft_ovr_rto") = false;
					sheetObj.CellEditable(Row,prefix+"jo_45ft_sub_teu_qty") = false;
					sheetObj.CellEditable(Row,prefix+"jo_45ft_und_rto") = false;
					sheetObj.CellEditable(Row,prefix+"jo_45ft_ovr_rto") = false;
					sheetObj.CellEditable(Row,prefix+"jo_rnd_knd_flg") = false;
					sheetObj.CellEditable(Row,prefix+"jo_rnd_rule_lvl") = false;
					sheetObj.CellEditable(Row,prefix+"jo_rf_ocn_teu_qty") = false;					
					sheetObj.CellEditable(Row,prefix+"jo_rf_inter_teu_qty") = false;
					sheetObj.CellEditable(Row,prefix+"jo_inter_ovr_flg") = false;
					sheetObj.CellEditable(Row,prefix+"jo_fsh_flg") = false;
					sheetObj.CellEditable(Row,prefix+"jo_bsa_prc") = false;
					sheetObj.CellEditable(Row,prefix+"jo_ovr_ocn_prc") = false;
					sheetObj.CellEditable(Row,prefix+"jo_ovr_inter_prc") = false;
					sheetObj.CellEditable(Row,prefix+"jo_ovr_mt_ocn_prc") = false;
					sheetObj.CellEditable(Row,prefix+"jo_ovr_mt_inter_prc") = false;					
					sheetObj.CellEditable(Row,prefix+"jo_sctr_prc_flg") = false;
					sheetObj.CellEditable(Row,prefix+"jo_rf_ocn_prc") = false;					
					sheetObj.CellEditable(Row,prefix+"jo_rf_inter_prc") = false;
					sheetObj.CellEditable(Row,prefix+"jo_prc_fsh_flg") = false;
								
				} else {					
					if (sheetObj.CellValue(Row, prefix+"jo_fsh_flg") == "Y") {
						sheetObj.CellEditable(Row,prefix+"del_chk") = false;
						sheetObj.CellValue2(Row, prefix+"del_chk"  ) = "N";
						sheetObj.CellEditable(Row,prefix+"jo_bsa_teu_qty") = false;
//						sheetObj.CellEditable(Row,prefix+"jo_bsa_add_teu_qty") = false;
						sheetObj.CellEditable(Row,prefix+"jo_add_bsa_crr_flg") = false;
//						sheetObj.CellEditable(Row,prefix+"jo_ovr_bsa_teu_qty") = false;
						sheetObj.CellEditable(Row,prefix+"jo_ovr_ton_wgt") = false;
						sheetObj.CellEditable(Row,prefix+"jo_ton_teu_qty") = false;
						sheetObj.CellEditable(Row,prefix+"jo_20ft_sub_teu_qty") = false;
						sheetObj.CellEditable(Row,prefix+"jo_20ft_ovr_rto") = false;
						sheetObj.CellEditable(Row,prefix+"jo_40ft_sub_teu_qty") = false;
						sheetObj.CellEditable(Row,prefix+"jo_40ft_ovr_rto") = false;
						sheetObj.CellEditable(Row,prefix+"jo_45ft_sub_teu_qty") = false;
						sheetObj.CellEditable(Row,prefix+"jo_45ft_und_rto") = false;
						sheetObj.CellEditable(Row,prefix+"jo_45ft_ovr_rto") = false;
						sheetObj.CellEditable(Row,prefix+"jo_rnd_knd_flg") = false;
						sheetObj.CellEditable(Row,prefix+"jo_rnd_rule_lvl") = false;
						sheetObj.CellEditable(Row,prefix+"jo_rf_ocn_teu_qty") = false;
						sheetObj.CellEditable(Row,prefix+"jo_rf_inter_teu_qty") = false;			
						sheetObj.CellEditable(Row,prefix+"jo_inter_ovr_flg") = false;	
						
						sheetObj.CellEditable(Row,prefix+"jo_fsh_flg") = true;
						sheetObj.CellEditable(Row,prefix+"jo_bsa_prc") = true;
						sheetObj.CellEditable(Row,prefix+"jo_ovr_ocn_prc") = true;
						sheetObj.CellEditable(Row,prefix+"jo_ovr_inter_prc") = true;
						sheetObj.CellEditable(Row,prefix+"jo_ovr_mt_ocn_prc") = true;
						sheetObj.CellEditable(Row,prefix+"jo_ovr_mt_inter_prc") = true;					
						sheetObj.CellEditable(Row,prefix+"jo_sctr_prc_flg") = true;
						sheetObj.CellEditable(Row,prefix+"jo_rf_ocn_prc") = true;					
						sheetObj.CellEditable(Row,prefix+"jo_rf_inter_prc") = true;
						sheetObj.CellEditable(Row,prefix+"jo_prc_fsh_flg") = true;
			
					}
					if (sheetObj.CellValue(Row, prefix+"jo_prc_fsh_flg") == "Y") {
						sheetObj.CellEditable(Row,prefix+"jo_bsa_teu_qty") = true;
						sheetObj.CellEditable(Row,prefix+"jo_add_bsa_crr_flg") = true;
						sheetObj.CellEditable(Row,prefix+"jo_ovr_ton_wgt") = true;
						sheetObj.CellEditable(Row,prefix+"jo_ton_teu_qty") = true;
						sheetObj.CellEditable(Row,prefix+"jo_20ft_sub_teu_qty") = true;
						sheetObj.CellEditable(Row,prefix+"jo_20ft_ovr_rto") = true;
						sheetObj.CellEditable(Row,prefix+"jo_40ft_sub_teu_qty") = true;
						sheetObj.CellEditable(Row,prefix+"jo_40ft_ovr_rto") = true;
						sheetObj.CellEditable(Row,prefix+"jo_45ft_sub_teu_qty") = true;
						sheetObj.CellEditable(Row,prefix+"jo_45ft_und_rto") = true;
						sheetObj.CellEditable(Row,prefix+"jo_45ft_ovr_rto") = true;
						sheetObj.CellEditable(Row,prefix+"jo_rnd_knd_flg") = true;
						sheetObj.CellEditable(Row,prefix+"jo_rnd_rule_lvl") = true;
						sheetObj.CellEditable(Row,prefix+"jo_rf_ocn_teu_qty") = true;					
						sheetObj.CellEditable(Row,prefix+"jo_rf_inter_teu_qty") = true;
						sheetObj.CellEditable(Row,prefix+"jo_inter_ovr_flg") = true;		
						sheetObj.CellEditable(Row,prefix+"jo_fsh_flg") = true;
						
						sheetObj.CellEditable(i,prefix+"jo_bsa_prc") = false;
						sheetObj.CellEditable(i,prefix+"jo_ovr_ocn_prc") = false;
						sheetObj.CellEditable(i,prefix+"jo_ovr_inter_prc") = false;
						sheetObj.CellEditable(i,prefix+"jo_ovr_mt_ocn_prc") = false;
						sheetObj.CellEditable(i,prefix+"jo_ovr_mt_inter_prc") = false;
						sheetObj.CellEditable(i,prefix+"jo_sctr_prc_flg") = false;
						sheetObj.CellEditable(i,prefix+"jo_rf_ocn_prc") = false;
						sheetObj.CellEditable(i,prefix+"jo_rf_inter_prc") = false;
					}
				}
				break;				
	    }
	}
	
	function setYyyyWwDt(sheetObj, Row){
		var vTrd_cd = sheetObj.CellValue(Row, prefix+"trd_cd");
		var vRlane_cd = sheetObj.CellValue(Row, prefix+"rlane_cd");
		var vVsl_cd = sheetObj.CellValue(Row, prefix+"vsl_cd");
		var vSkd_voy_no = sheetObj.CellValue(Row, prefix+"skd_voy_no");
		var vSkd_dir_cd = sheetObj.CellValue(Row, prefix+"skd_dir_cd");
		var sParams = "";
		if( vTrd_cd != "" && vRlane_cd != "" && vVsl_cd != "" && vSkd_voy_no != "" && vSkd_dir_cd != "" ){
			//파라미터 명시적인 생성
			sParams += "trd_cd="        +vTrd_cd;
			sParams += "&rlane_cd="     +vRlane_cd;
			sParams += "&vsl_cd="       +vVsl_cd;
			sParams += "&skd_voy_no="   +vSkd_voy_no;
			sParams += "&skd_dir_cd="   +vSkd_dir_cd;
			sParams += "&f_cmd=103";
			var sXml = sheetObjects[2].GetSearchXml("FNS_JOO_0091GS.do", sParams);
			if(ComJooGetMessageFromXml(sXml) != ""){
				ComShowMessage(ComJooGetMessageFromXml(sXml));
			}else{
				sheetObj.CellValue(Row, prefix+"yrwk") = ComGetEtcData(sXml,"etcYrwk");
				sheetObj.CellValue(Row, prefix+"rev_port_etd_dt") = ComGetEtcData(sXml,"etcRevPortEtdDt");
				sheetObj.CellValue(Row, prefix+"jo_rdr_port_cd") = ComGetEtcData(sXml,"etcJoRdrPortCd");
			}
		}
	}
	
	function sheet1_OnClick(sheetObj, Row, Col, Value) {
		gRow = Row;
		var formObj = document.form;
		
		if (sheetObj.CellValue(Row, prefix+"ibflag") == "R") {
			formObj.del_chk.value = "R";
		}		
//		sheetObj.CellValue(Row, prefix+"del_chk") = "1";	 	
		if (formObj.del_chk.value == "R") {
			sheetObj.CellValue2(Row, prefix+"ibflag") = "R"
			formObj.del_chk.value = ""
		}
	    switch (sheetObj.ColSaveName(Col)) {
			case prefix+"jo_add_bsa_crr_flg":
				
				var joAddBsaCrrFlg = sheetObj.CellValue(Row, prefix+"jo_add_bsa_crr_flg");
				if (joAddBsaCrrFlg == 'Y') {
					var vvdPort = sheetObj.CellValue(Row, prefix+"vvd_port");
					if( vvdPort == '' ) {
//						ComShowCodeMessage("JOO00192");
						alert("VVD+PORT 정보가 존재하지 않습니다.");
					} else {
						var paramUrl = "pgmNo=FNS_JOO_0093&vvd_port="+vvdPort+"&vsl_cd="+sheetObj.CellValue(Row, prefix + "vsl_cd")+"&skd_voy_no="+sheetObj.CellValue(Row, prefix + "skd_voy_no")+"&skd_dir_cd="+sheetObj.CellValue(Row, prefix + "skd_dir_cd")+"&port_cd="+sheetObj.CellValue(Row, prefix + "port_cd")+"&port_seq="+sheetObj.CellValue(Row, prefix + "port_seq")+"&jo_crr_cd="+sheetObj.CellValue(Row, prefix + "jo_crr_cd");		
						ComOpenPopup("/hanjin/FNS_JOO_0093.do?"+paramUrl, 1055, 177,
							"popupFinish", "1,0,1,1,1,1,1,1", true, false, 0, 0, 0,
							"pop1");
					}
				}
				break;
	
		}
	}
	
	function sheet1_OnPopupClick(sheetObj, Row, Col) {
	    switch (sheetObj.ColSaveName(Col)) {
			case prefix+"agmt_eff_dt":
				var cal = new ComCalendarGrid();
				cal.select(sheetObj, Row, Col, "yyyy-MM-dd");
				break;
			case prefix+"agmt_exp_dt":
				var cal = new ComCalendarGrid();
				cal.select(sheetObj, Row, Col, "yyyy-MM-dd");
				break;
			case prefix+"ofc_cd":
				ComOpenPopup("/hanjin/COM_ENS_071.do", 750, 470, "ofc_cd_sheet_pop_event", "1,0,1", true, false, Row, Col, 0);
				break;
	
		}
	}
	
	
	function ofc_cd_sheet_pop_event(aryPopupData, row, col, sheetIdx){
		sheetObjects[sheetIdx].CellValue(row, col) = aryPopupData[0][3];
	}
	
	
	function ofc_cd_OnChange(comObj, Value, Text) {
		//sheetObjects[0].RemoveAll(); 
	}
	
	function UF_copyRow(){
		var formObj  = document.form;
		var sheetObj = sheetObjects[0];
		
		var arrs = sheetObj.GetSelectionRows(",");
		var rows = arrs.split(",");
		for (var i = rows.length-1; i >= 0; i--){
			sheetObj.SelectCell(rows[i], 7);	   	
			var row = sheetObj.DataCopy();
			sheetObj.CellValue2(row, prefix+"ibflag"    ) = "I";
//			sheetObj.CellValue2(row, prefix+"jo_bsa_add_teu_qty") = "";
			sheetObj.CellValue2(row, prefix+"jo_fsh_flg"  ) = "N";
			sheetObj.CellValue2(row, prefix+"jo_prc_fsh_flg"  ) = "Y";
			sheetObj.CellValue2(row, prefix+"delt_flg"  ) = "N";
//			sheetObj.CellValue2(row, prefix+"jo_add_bsa_crr_flg")  = "N";
			sheetObj.CellValue2(row, prefix+"jo_sctr_prc_flg")     = "N";
//			sheetObj.CellValue2(row, prefix+"jo_rnd_rule_lvl")     = "1";  // 2013.01.24 이수진 (오미랑 과장님 요청사항) : Round Type은 RowCopy시 자동 Copy 되도록
			sheetObj.CellValue2(row, prefix+"cre_dt"    ) = ComGetNowInfo("ymd");
			sheetObj.CellValue2(row, prefix+"upd_dt"    ) = ComGetNowInfo("ymd");
			sheetObj.CellValue2(row, prefix+"upd_usr_id") = gUsrId;
			sheetObj.CellValue2(row, prefix+"usr_nm") = gUsrNm;
//			sheetObj.CellValue2(row, prefix+"jo_ovr_bsa_teu_qty") = "";       // 2013.01.24 이수진 (오미랑 과장님 요청사항) : OUS BSA는 자동 Copy 되지 않도록
//			sheetObj.CellValue2(row, prefix+"jo_ovr_bsa_teu_qty") = sheetObj.CellValue(row, prefix+"jo_bsa_teu_qty");
							
			sheetObj.CellValue2(row, prefix+"del_chk") = "";                  // 2013.01.24 이수진 (오미랑 과장님 요청사항)			
			
			sheetObj.CellEditable(row,prefix+"jo_bsa_add_teu_qty") = false;
			sheetObj.CellEditable(row,prefix+"jo_ovr_bsa_teu_qty") = false;
			sheetObj.CellEditable(row,prefix+"cre_dt") = false;
			sheetObj.CellEditable(row,prefix+"upd_usr_id") = false;
			sheetObj.CellEditable(row,prefix+"usr_nm") = false;
					
			var sCode = sheetObj.GetComboInfo(row, prefix+"rlane_cd", "Code");
			var arrCode = sCode.split("|");
			
			//Copy한 Lane이 Combo가 아니라면 Combo로 만들어 준다.
			if (arrCode.length <= 1){
				var trd = sheetObj.CellValue(row, prefix+"trd_cd");
				
				var laneList = "";
				var lane = "";
				var cnt = 0;
				for(var k=0; k<gTrdLaneCrrArr.length; k++){
					if (trd == gTrdLaneCrrArr[k][0]){
						//TRADE_-LANE-CARRIER를 열거한 거라 lane이 같은게 있을 수 있으므로 중복을 제거한다.
						if (lane != gTrdLaneCrrArr[k][1]){
							lane = gTrdLaneCrrArr[k][1];
							
							if (cnt==0){
								laneList = gTrdLaneCrrArr[k][1];
							}else{
								laneList = laneList+"|"+gTrdLaneCrrArr[k][1];
							}
							cnt++;
						}
					}
				}
				sheetObj.InitCellProperty(row, prefix+"rlane_cd", dtCombo);
		        sheetObj.CellComboItem(row, prefix+"rlane_cd" , laneList, laneList);
			}
			
			if (i==0){
				sheetObj.SelectCell(row, prefix+"ofc_cd");
			}			
		}
	}
	
	function UF_addRow(i){
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		
		var row;
		if (i == undefined || i == null || i == ""){
			row = sheetObj.DataInsert();
		}else{
			row = sheetObj.DataInsert(-1);		
		}
		//sheetObj.CellValue2(row, prefix+"del_chk")   = "1"; 
		sheetObj.CellValue2(row, prefix+"jo_bsa_add_teu_qty")   = "";
		sheetObj.CellValue2(row, prefix+"re_divr_cd")   = "";
		sheetObj.CellValue2(row, prefix+"trd_cd")    = "";
		sheetObj.CellValue2(row, prefix+"jo_crr_flag")  = "N";
		sheetObj.CellValue2(row, prefix+"jo_fsh_flg")   = "N";
		sheetObj.CellValue2(row, prefix+"jo_prc_fsh_flg")   = "";
		sheetObj.CellValue2(row, prefix+"delt_flg")     = "N";
		sheetObj.CellValue2(row, prefix+"jo_add_bsa_crr_flg")     = "N";
		sheetObj.CellValue2(row, prefix+"jo_sctr_prc_flg")     = "";
		sheetObj.CellValue2(row, prefix+"jo_rnd_knd_flg")     = "";
		sheetObj.CellValue2(row, prefix+"jo_rnd_rule_lvl")     = "";
		sheetObj.CellValue2(row, prefix+"jo_inter_ovr_flg")     = "";
		sheetObj.SelectCell(row, prefix+"ofc_cd");
		sheetObj.CellValue2(row, prefix+"jo_ton_wgt_rnd_rt")   = "1";
		sheetObj.CellValue2(row, prefix+"jo_20ft_rnd_rt")   = "1";
		sheetObj.CellValue2(row, prefix+"jo_40ft_rnd_rt")   = "1";
		sheetObj.CellValue2(row, prefix+"jo_45ft_rnd_rt")   = "1";
		sheetObj.CellValue2(row, prefix+"upd_usr_id")   = gUsrId;
		sheetObj.CellValue2(row, prefix+"usr_nm")   = gUsrNm;
		sheetObj.CellValue2(row, prefix+"cre_dt") = ComGetNowInfo("ymd");
		sheetObj.CellValue2(row, prefix+"upd_dt") = ComGetNowInfo("ymd");
		
		sheetObj.CellEditable(row,prefix+"jo_bsa_add_teu_qty") = false;
		sheetObj.CellEditable(row,prefix+"jo_ovr_bsa_teu_qty") = false;
		sheetObj.CellEditable(row,prefix+"cre_dt") = false;
		sheetObj.CellEditable(row,prefix+"upd_usr_id") = false;
		sheetObj.CellEditable(row,prefix+"usr_nm") = false;
		return row;
	}
	

		
		
//	/**
//	 * Add Carrir Checkbox를 Click했을 경우
//	 * @return
//	 */
//	function add_carrier_click(){
//		formObj = document.form;
//		formObj.add_carrier.value = formObj.add_carrier.checked?"Y":"N";		
//	}
		

	
	 
	function sheet1_OnLoadExcel(sheetObj) {
		formObj = document.form;
		if (formObj.add_carrier.value == "Y"){  // Main 화면
//			var btnFlag = "N";
			if (formObj.upload_flg.value == "I"){  // New Upload
				for(var i=sheetObj.HeaderRows ;i<=sheetObj.LastRow;i++) {	
			        sheetObj.CellValue(i, prefix+"jo_add_bsa_crr_flg") = "N";
		            sheetObj.CellValue(i, prefix+"jo_fsh_flg") = "N";
		            sheetObj.CellValue(i, prefix+"delt_flg") = "N";
		            sheetObj.CellValue(i, prefix+"cre_dt") = ComGetNowInfo("ymd");
		            sheetObj.CellValue(i, prefix+"upd_usr_id") = gUsrId;
		            sheetObj.CellValue(i, prefix+"usr_nm") = gUsrNm;

		            sheetObj.CellValue(i, prefix+"yrwk") = "";
//		            sheetObj.CellValue(i, prefix+"jo_rdr_port_cd") = "";
//		            sheetObj.CellValue(i, prefix+"rev_port_etd_dt") = "";
		            
//		            if(btnFlag == "N"){
//			            if(sheetObj.CellValue(i, prefix+"yrwk").trim() != ""){		//new 데이터에 YYYY-WW값이 있을 시 Save금지
//			            	btnFlag = "Y";
//			            } 
//		            }
		            //오류 Row에 색 넣기
//		            if(sheetObj.CellValue(i, prefix+"yrwk").trim() != ""){
//		            	sheetObj.RowBackColor(i) = sheetObj.RgbColor(255,200,230);
//		            }
				}  // End for
			}else{ // Update Upload
				for(var i=sheetObj.HeaderRows ;i<=sheetObj.LastRow;i++) {	
					sheetObj.CellEditable(i, prefix+"ofc_cd") = true;
					sheetObj.CellEditable(i, prefix+"re_divr_cd") = true;
					sheetObj.CellEditable(i, prefix+"trd_cd") = true;
					sheetObj.CellEditable(i, prefix+"rlane_cd") = true;
					sheetObj.CellEditable(i, prefix+"vsl_cd") = true;
					sheetObj.CellEditable(i, prefix+"skd_dir_cd") = true;
					sheetObj.CellEditable(i, prefix+"port_cd") = true;
					sheetObj.CellEditable(i, prefix+"port_seq") = true;
					sheetObj.CellEditable(i, prefix+"jo_crr_cd") = true;
					
					sheetObj.CellValue(i, prefix+"ibflag") = "U";
		            sheetObj.CellValue(i, prefix+"delt_flg") = "N";
		            sheetObj.CellValue(i, prefix+"upd_usr_id") = gUsrId;
		            sheetObj.CellValue(i, prefix+"usr_nm") = gUsrNm;
		           
//		            if(btnFlag == "N"){
//						if(sheetObj.CellValue(i, prefix+"yrwk").trim() == ""){	//update 데이터에 YYYY-WW값이 없을 시 Save금지
//			            	btnFlag = "Y";
//			            } 
//					}
		          //오류 Row에 색 넣기
//		            if(sheetObj.CellValue(i, prefix+"yrwk").trim() == ""){
//		            	sheetObj.RowBackColor(i) = sheetObj.RgbColor(255,200,230);
//		            }
				} // End For
				
				
			}
//			if(btnFlag == "Y") ComBtnDisable("btn_save");
//			else if(btnFlag == "N") ComBtnEnable("btn_save");
		} // End if
		
//		if(sheetObj.LastRow == 0) return;
		
		
	}
			
	function sheet3_OnLoadExcel(sheetObj) {
		if (document.form.upload_flg.value == "I"){  // New Upload
			for(var i=sheetObj.HeaderRows ;i<=sheetObj.LastRow;i++) {
				sheetObj.CellEditable(i, prefix3+"vvd_port") = false;		
				sheetObj.CellEditable(i, prefix3+"jo_crr_cd") = true;	
				sheetObj.CellEditable(i, prefix3+"jo_bsa_teu_qty") = true;	
				sheetObj.CellEditable(i, prefix3+"cre_dt") = false;
				sheetObj.CellEditable(i, prefix3+"upd_usr_id") = false;
				sheetObj.CellEditable(i, prefix3+"usr_nm") = false;	
				
				sheetObj.CellValue(i, prefix3+"cre_dt") = ComGetNowInfo("ymd");
	            sheetObj.CellValue(i, prefix3+"upd_usr_id") = gUsrId;
	            sheetObj.CellValue(i, prefix3+"usr_nm") = gUsrNm;

			} // End For			
			
		}else{ // Update Upload
			for(var i=sheetObj.HeaderRows ;i<=sheetObj.LastRow;i++) {				
				sheetObj.CellEditable(i, prefix3+"vvd_port") = false;		
				sheetObj.CellEditable(i, prefix3+"jo_crr_cd") = true;	
				sheetObj.CellEditable(i, prefix3+"jo_bsa_teu_qty") = true;	
				sheetObj.CellEditable(i, prefix3+"cre_dt") = false;
				sheetObj.CellEditable(i, prefix3+"upd_usr_id") = false;
				sheetObj.CellEditable(i, prefix3+"usr_nm") = false;				
				
				sheetObj.CellValue(i, prefix3+"ibflag") = "U";
	            sheetObj.CellValue(i, prefix3+"upd_usr_id") = gUsrId;
	            sheetObj.CellValue(i, prefix3+"usr_nm") = gUsrNm;	
			} // End For
		}  // End if     
	}


	
	
	
	
	/**
	 * Load Excel Data 의 정합성을 체크한다. 
	 * @param sheetObj
	 */
	function checkLoadDate(sheetObj) {
		
			if (document.form.upload_flg.value == "U"){ 
				var cnt = 0;
				with(sheetObj) {
					for(var i =HeaderRows ; i<=LastRow ; i++){
						
					}  //end for
		
				}  //end with
			} // end if
		
		return cnt>0?false:true;
	}	
	
	 /**
	 * Add Carrier Checkbox Click 여부
	 * @return
	 */
	 
	function obj_Click() {
        var obj = event.srcElement;
		var formObj = document.form;
		var doc = document.all;
		if (obj.name == "add_carrier"){
			if(formObj.add_carrier.checked)  {
			    doc.sheet_main.style.display = "none";
	            doc.sheet_carrier.style.display  = "";           
	            sheetObjects[2].RemoveAll();
	            ComBtnDisable("btns_copy");
	    		ComBtnDisable("btns_add");
	    		ComBtnDisable("btns_del");
	    		ComBtnDisable("btn_history");
	    		ComBtnEnable("btn_save");
	           
			}else{
				doc.sheet_main.style.display = "";
	            doc.sheet_carrier.style.display = "none";            
	            sheetObjects[0].RemoveAll();
	            ComBtnEnable("btns_copy");
	    		ComBtnEnable("btns_add");
	    		ComBtnEnable("btns_del");
	    		ComBtnEnable("btn_history");	             
			}	
		}
	}	
	
	
	
	function obj_keypress(){
    	switch(event.srcElement.dataformat){
    		case "engup":
    			switch(event.srcElement.name){
    				case "vsl_cd":	     
    					ComKeyOnlyAlphabet('uppernum');		//영문대문자 입력하기 . 숫자도 포함
    					break;
    				case "port_cd":	     
    					ComKeyOnlyAlphabet('upper');		//영문대문자 입력하기
    					break;
    				case "vvd_port":	     
    					ComKeyOnlyAlphabet('uppernum');		//영문대문자 입력하기 . 숫자도 포함
    					break;	
    			}
    			break;
    	}
    }

     function fnObjKeyUp(){
         var obj = event.srcElement;
         var formObj = document.form;
         switch (obj.name){
            case 'vsl_cd':
                  var maxlength = obj.getAttribute("maxlength");
                  if( obj.value.length == eval(maxlength) ){
                      doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC07);
                  }
                  break;
            case 'port_cd':
                  var maxlength = obj.getAttribute("maxlength");
                  if( obj.value.length == eval(maxlength) ){
                      doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC08);
                  }
                  break;
         }
     }
	 
	 
         /**
          * <pre>
          *    form Element의 KeyPress Event 발생시 처리.
          *
          * </pre>
          * @return
          */
         function fnObjKeyPress(){
             var obj = event.srcElement;
             var formObj = document.form;
             switch (obj.name){
                case 'vsl_cd':
                      ComKeyOnlyAlphabet( "uppernum" );
//                      if( sheetObjects[0].RowCount > 0 ){
//                         sheetObjects[0].RemoveAll();  2013.04.18 
//                      }
                      break;
                case 'port_cd':
                      ComKeyOnlyAlphabet( "uppernum" );
 //                     if( sheetObjects[0].RowCount > 0 ){
//                         sheetObjects[0].RemoveAll(); 2013.04.18 
 //                     }
                      break;
             }
         }

function UF_reset(){
	for(var i=0; i<comboObjects.length; i++){
		if (i == 5){
			comboObjects[i].Index2 = 2;
		}else{
			comboObjects[i].Index2 = (comboObjects[i].GetCount() == 0? -1 : 0);
		}
	}
	
	document.form.fm_yr_wk.value = "";
	document.form.to_yr_wk.value = "";
	
	document.form.fm_etd_dt.value = "";
	document.form.to_etd_dt.value = "";
	
	document.form.cre_dt_fr.value = "";
	document.form.cre_dt_to.value = "";
	
	sheetObjects[0].RemoveAll();
	
	document.form.jo_fsh_flg.Index2 = 0;
	
	document.form.jo_prc_flg.Index2 = 0;
	
	document.form.delt_flg.Index2 = 0;

	doActionIBCombo(sheetObjects[0], document.form, IBSEARCH, comboObjects[1] ,"rlane_cd");

}

    /**
     * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 조회 후 메시지
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg != "") return;
        with (sheetObj) {
            if (RowCount > 0) {
                //sheetObj.CellValue2(sheetObj.HeaderRows, prefix+"del_chk") = "1";
            }			
			for (var i=sheetObj.HeaderRows; i <= sheetObj.LastRow; i++){
	  		    //2013.02.18 이수진 추가(오미랑 과장 요청사항 - Y로되면, BSA ~ End port 까지 비활성화되도록 보완)
				if (sheetObj.CellValue(i, prefix+"delt_flg") == "Y") {
					sheetObj.CellEditable(i,prefix+"del_chk") = false;
					sheetObj.CellEditable(i,prefix+"jo_bsa_teu_qty") = false;
					sheetObj.CellEditable(i,prefix+"jo_bsa_add_teu_qty") = false;
					sheetObj.CellEditable(i,prefix+"jo_add_bsa_crr_flg") = false;
					sheetObj.CellEditable(i,prefix+"jo_ovr_bsa_teu_qty") = false;
					sheetObj.CellEditable(i,prefix+"jo_ovr_ton_wgt") = false;
					sheetObj.CellEditable(i,prefix+"jo_ton_teu_qty") = false;
					sheetObj.CellEditable(i,prefix+"jo_20ft_sub_teu_qty") = false;
					sheetObj.CellEditable(i,prefix+"jo_20ft_ovr_rto") = false;
					sheetObj.CellEditable(i,prefix+"jo_40ft_sub_teu_qty") = false;
					sheetObj.CellEditable(i,prefix+"jo_40ft_ovr_rto") = false;
					sheetObj.CellEditable(i,prefix+"jo_45ft_sub_teu_qty") = false;
					sheetObj.CellEditable(i,prefix+"jo_45ft_und_rto") = false;
					sheetObj.CellEditable(i,prefix+"jo_45ft_ovr_rto") = false;
					sheetObj.CellEditable(i,prefix+"jo_rnd_knd_flg") = false;
					sheetObj.CellEditable(i,prefix+"jo_rnd_rule_lvl") = false;
					sheetObj.CellEditable(i,prefix+"jo_rf_ocn_teu_qty") = false;					
					sheetObj.CellEditable(i,prefix+"jo_rf_inter_teu_qty") = false;
					sheetObj.CellEditable(i,prefix+"jo_inter_ovr_flg") = false;
					sheetObj.CellEditable(i,prefix+"jo_fsh_flg") = false;
					sheetObj.CellEditable(i,prefix+"jo_bsa_prc") = false;
					sheetObj.CellEditable(i,prefix+"jo_ovr_ocn_prc") = false;
					sheetObj.CellEditable(i,prefix+"jo_ovr_inter_prc") = false;
					sheetObj.CellEditable(i,prefix+"jo_ovr_mt_ocn_prc") = false;
					sheetObj.CellEditable(i,prefix+"jo_ovr_mt_inter_prc") = false;					
					sheetObj.CellEditable(i,prefix+"jo_sctr_prc_flg") = false;
					sheetObj.CellEditable(i,prefix+"jo_rf_ocn_prc") = false;					
					sheetObj.CellEditable(i,prefix+"jo_rf_inter_prc") = false;
					sheetObj.CellEditable(i,prefix+"jo_prc_fsh_flg") = false;
					
				}else {  // Delete Flag가 "N"이면
					if (sheetObj.CellValue(i, prefix+"jo_fsh_flg") == "Y") {
						sheetObj.CellEditable(i,prefix+"del_chk") = false;
						sheetObj.CellEditable(i,prefix+"jo_bsa_teu_qty") = false;
						sheetObj.CellEditable(i,prefix+"jo_add_bsa_crr_flg") = false;
						sheetObj.CellEditable(i,prefix+"jo_ovr_ton_wgt") = false;
						sheetObj.CellEditable(i,prefix+"jo_ton_teu_qty") = false;
						sheetObj.CellEditable(i,prefix+"jo_20ft_sub_teu_qty") = false;
						sheetObj.CellEditable(i,prefix+"jo_20ft_ovr_rto") = false;
						sheetObj.CellEditable(i,prefix+"jo_40ft_sub_teu_qty") = false;
						sheetObj.CellEditable(i,prefix+"jo_40ft_ovr_rto") = false;
						sheetObj.CellEditable(i,prefix+"jo_45ft_sub_teu_qty") = false;
						sheetObj.CellEditable(i,prefix+"jo_45ft_und_rto") = false;
						sheetObj.CellEditable(i,prefix+"jo_45ft_ovr_rto") = false;
						sheetObj.CellEditable(i,prefix+"jo_rnd_knd_flg") = false;
						sheetObj.CellEditable(i,prefix+"jo_rnd_rule_lvl") = false;
						sheetObj.CellEditable(i,prefix+"jo_rf_ocn_teu_qty") = false;					
						sheetObj.CellEditable(i,prefix+"jo_rf_inter_teu_qty") = false;
						sheetObj.CellEditable(i,prefix+"jo_inter_ovr_flg") = false;
					}
					if (sheetObj.CellValue(i, prefix+"jo_prc_fsh_flg") == "Y"){
						sheetObj.CellEditable(i,prefix+"jo_bsa_prc") = false;
						sheetObj.CellEditable(i,prefix+"jo_ovr_ocn_prc") = false;
						sheetObj.CellEditable(i,prefix+"jo_ovr_inter_prc") = false;
						sheetObj.CellEditable(i,prefix+"jo_ovr_mt_ocn_prc") = false;
						sheetObj.CellEditable(i,prefix+"jo_ovr_mt_inter_prc") = false;
						sheetObj.CellEditable(i,prefix+"jo_sctr_prc_flg") = false;
						sheetObj.CellEditable(i,prefix+"jo_rf_ocn_prc") = false;
						sheetObj.CellEditable(i,prefix+"jo_rf_inter_prc") = false;
					}
				}  // end else
				
			} // end for
        } // with
    } // end sheet1_OnSearchEnd

     /**
      * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
      * @param {shtObj} String : 해당 IBSheet Object
      * @param {ErrMsg} String : 조회 후 메시지
      */
     function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
         if (ErrMsg != "") return;
         with (sheetObj) {
 			for (var i=sheetObj.HeaderRows; i <= sheetObj.LastRow; i++){
 				sheetObj.CellEditable(i, prefix3+"jo_crr_cd") = true;	
				sheetObj.CellEditable(i, prefix3+"jo_bsa_teu_qty") = true;	
 				}
 			}
     }
/* 개발자 작업  끝 */