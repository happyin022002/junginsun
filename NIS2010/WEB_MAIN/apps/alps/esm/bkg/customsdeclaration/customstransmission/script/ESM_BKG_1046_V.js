/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_1046_V.js
 *@FileTitle : China: Manifest Transmission
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.25
 *@LastModifier : 이수빈
 *@LastVersion : 1.0
 * 2009.08.25 이수빈
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
 * @class China: Manifest Transmission : China: Manifest Transmission 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function esm_bkg_1046_V() {
    this.processButtonClick = processButtonClick;
    this.setSheetObject = setSheetObject;
    this.setComboObject = setComboObject;
    this.loadPage = loadPage;
    this.initSheet = initSheet;
    this.doActionIBSheet = doActionIBSheet;
    this.validateForm = validateForm;
    this.sheet1_OnDblClick = sheet1_OnDblClick;
}

/* 개발자 작업    */

//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    var sheetObject1 = sheetObjects[0];
    var sheetObject2 = sheetObjects[1];
    /*******************************************************/
    var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
			break;
			
			case "btn_new":
				doActionIBSheet(sheetObject1,formObject,IBRESET);							
			break;
			
			case "btn_delete":
				doActionIBSheet(sheetObject1,formObject,IBDELETE);
			break;	
			
			case "btn_excel":
				doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
			break;	
			
			case "btn_save_csv":
       	 		doActionIBSheet(sheetObject1,formObject,IBSAVE);
			break;
			
			case "btn_go_bl":
				doActionIBSheet(sheetObject1,formObject,IBROWSEARCH);
			break;		
			
			case "btn_Transmit":
				doActionIBSheet(sheetObject2,formObject,IBSEARCH_ASYNC01);
			break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
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
*/
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * 콤보 Object를 comboObjects 배열에 등록
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj; 
}

/**
 * Combo Object 초기화
 * @param comboObj
 * @param comNo
 * @return
 */
function initCombo(comboObj, comboNo) {
    switch(comboObj.id) {
        case "msg_type":
            var i=0;
            with(comboObj) {
            	ColBackColor(0) = "#CCFFFD";
            	DropHeight = 200;
            	MultiSelect = false;
            	MaxSelect = 1;
            }
            break;
    }
}

/**
* Sheet 기본 설정 및 초기화
* body 태그의 onLoad 이벤트핸들러 구현
* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
*/
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
	    //khlee-시작 환경 설정 함수 이름 변경
	    ComConfigSheet (sheetObjects[i] );
	
	    initSheet(sheetObjects[i],i+1);
	    //khlee-마지막 환경 설정 함수 추가
	    ComEndConfigSheet(sheetObjects[i]);
    }
    
	for(i = 0; i < comboObjects.length; i++ ) {
		initCombo(comboObjects[i], i+1);
	}
	
	var formObj = document.form;
	//화면에서 필요한 이벤트
	axon_event.addListenerForm("KeyUp","obj_KeyUp", formObj);
	axon_event.addListenerForm("Click","obj_Click", document.form);
	axon_event.addListenerFormat("KeyPress","obj_KeyPress", formObj);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');

	// 콤보 데이터 생성
	ComXml2ComboItem(formObj.code_list.value, formObj.msg_type, "attr_ctnt1", "attr_ctnt2");
	if(formObj.trans_mode.value == "D"){
		formObj.msg_type.Code = '0';
	}else{
		formObj.msg_type.Code = '9';
	}
	
	// 중국내 ID 일 경우만 버튼 활성화
	if(!saveCsvFlg){
		ComBtnDisable("btn_save_csv");
	}
	document.form.vvd.focus();
}

/**
 * 조회조건 입력할 때 MaxLength까지 입력하면 다음탭으로 이동
 */
function obj_KeyUp() {
	var formObject = document.form;
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	var srcName = window.event.srcElement.getAttribute("name");
	
	if ( (  srcName == "vvd" || srcName == "pol_cd" ) && ComChkLen(srcValue, srcMaxLength) == "2" ) {
		ComSetNextFocus();
	}
}

 function obj_Click() {
	var formObject = document.form;
	var currType = formObject.curr_type.value;
	var srcValue = window.event.srcElement.getAttribute("value");
	var srcName = window.event.srcElement.getAttribute("name");
	var sheetObj = sheetObjects[0];
	
	if ( srcName == "trans_type" && currType != srcValue){
		sheetObj.RemoveAll();
		formObject.bl_cnt.value = 0;
		formObject.cntr_cnt.value = 0;
		formObject.curr_type.value = srcValue;
	}
}
 
/**
 * 조회조건 클릭할 때 값에 따라 데이터 필터링
 */
//var orgBlCnt;
//var orgCntrCnt;
//var currType = 'all';
//function obj_Click() {
//	var formObject = document.form;
//	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
//	var srcValue = window.event.srcElement.getAttribute("value");
//	var srcName = window.event.srcElement.getAttribute("name");
//	
//	var sheetObj = sheetObjects[0];
//	var blCnt = orgBlCnt;
//	var cntrCnt = orgCntrCnt;
//	
//	if ( srcValue == currType ) return false;
//	if ( srcName == "trans_type" && sheetObj.TotalRows > 0) {
//		//sheetObj.Redraw = false;
//		for(var i=2; i<sheetObj.TotalRows+2; i++){
//			if( srcValue == "local" ){ 		// LOCAL
//				if(sheetObj.CellValue(i,"tr") == "E" || sheetObj.CellValue(i,"tr") == "I"){
//					sheetObj.RowHidden(i) = false;
//				}
//				else{
//					sheetObj.RowHidden(i) = true;
//					blCnt = blCnt - 1;
//					cntrCnt = cntrCnt - parseInt(sheetObj.CellValue(i,"cntr_cnt"));
//				}
//			}
//			else if( srcValue == "ts" ){ 	// T/S
//				if(sheetObj.CellValue(i,"tr") == "R" || sheetObj.CellValue(i,"tr") == "T"){
//					sheetObj.RowHidden(i) = false;
//				}
//				else{
//					sheetObj.RowHidden(i) = true;
//					blCnt = blCnt - 1;
//					cntrCnt = cntrCnt - parseInt(sheetObj.CellValue(i,"cntr_cnt"));
//				}
//			}
//			else{ 	// ALL
//				sheetObj.RowHidden(i) = false;
//				blCnt = orgBlCnt;
//				cntrCnt = orgCntrCnt;
//			}
//		}
//		//sheetObj.Redraw = true;
//		formObject.bl_cnt.value = ComAddComma(blCnt);
//		formObject.cntr_cnt.value = ComAddComma(cntrCnt);
//	}
//	currType = srcValue;
//}

/**
* 시트 초기설정값, 헤더 정의
* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
*/
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;
			
	switch(sheetID) {
     	case "sheet1":      //sheet1 init
	        with (sheetObj) {
	            // 높이 설정
	            style.height = 342;
	            //전체 너비 설정
	            SheetWidth = mainTable.clientWidth;
	
	            //Host정보 설정[필수][HostIp, Port, PagePath]
	            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	            //전체Merge 종류 [선택, Default msNone]
	            MergeSheet = msHeaderOnly;
	
	            //전체Edit 허용 여부 [선택, Default false]
	            Editable = true;
	
	            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	            InitRowInfo( 2, 1, 3, 100);
	
	            // 해더에서 처리할 수 있는 각종 기능을 설정한다
	            InitHeadMode(true, true, true, true, false,false)
	
	            var HeadTitle1 = "|Sel.|Seq.|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|SHPR|SHPR|CNEE|CNEE|NTFY|NTFY|TP|TR|DG|RF|CNTR|||Transmission Status| ";
	            var HeadTitle2 = "|Sel.|Seq.|B/L No.|BKG No.|POL|POD|DEL|Package|Package|Weight|Weight|Seal|Seal|Seal|N|A|N|A|N|A|TP|TR|DG|RF|CNTR|||Transmission Status| ";
	            var headCount = ComCountHeadTitle(HeadTitle1);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            InitColumnInfo(headCount, 0, 0, true);
	             
	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	            InitHeadRow(0, HeadTitle1, true);
	            InitHeadRow(1, HeadTitle2, true);
	                                 
	            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	            InitDataProperty(0, cnt++ , dtHiddenStatus,	  0, 	daCenter,  	false,    "ibflag");
		        InitDataProperty(0, cnt++ , dtCheckBox,		40, 	daCenter,  	true,     "Chk");
	            InitDataProperty(0, cnt++ , dtSeq,	     	30, 	daCenter,  	true,     "Seq");     
	            InitDataProperty(0, cnt++ , dtData, 		90,		daCenter,	true,     "bl_no",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		100,	daCenter,	true,     "bkg_no",  		false,    "",  dfNone, 0,   true,	true);
	            
	            InitDataProperty(0, cnt++ , dtData, 		50,		daCenter,	true,     "pol_cd",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		50,		daCenter,	true,     "pod_cd",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		50,		daCenter,	true,     "del_cd",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		30,		daCenter,	true,     "pck_qty",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		30,		daCenter,	true,     "pck_tp_cd",  	false,    "",  dfNone, 0,   true,	true);
	            
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "act_wgt",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "wgt_ut_cd",  	false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "seal_no_flg",  	false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "seal_knd_flg",	false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "sealer_cd_flg",	false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "shpr_nm",  		false,    "",  dfNone, 0,   true,	true);
	            
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "shpr_addr",  	false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "cnee_nm",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "cnee_addr",  	false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "ntfy_nm",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "ntfy_addr",  	false,    "",  dfNone, 0,   true,	true);
	            
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "bkg_cgo_tp_cd",  false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "tr",  			false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "dcgo_flg",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "rc_flg",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		40,		daCenter,	true,     "cntr_cnt",  		false,    "",  dfNone, 0,   true,	true);

	            InitDataProperty(0, cnt++ , dtHidden, 		50,		daCenter,	true,     "bkg_pol_cd",  	false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtHidden, 		50,		daCenter,	true,     "bkg_pod_cd",  	false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		50,		daCenter,	true,     "trsm_msg_tp_id", false,    "",  dfNone, 0,   true,	true,	-1,	false,	false);
	            InitDataProperty(0, cnt++ , dtData, 		100,	daLeft,		true,     "mf_snd_dt",  	false,    "",  dfUserFormat2, 0,   true,	true,	-1,	false,	false);

				InitUserFormat2(0, "mf_snd_dt", "####-##-## ##:##:##", "-|:" );	
				
				CountPosition = 0;
	        }
            sheetObj.SetMergeCell(0, 28, 2, 2); 
	        break;

     	case "sheet2":      //sheet1 init
	        with (sheetObj) {
	            // 높이 설정
	            style.height = 0;
	            //전체 너비 설정
	            SheetWidth = mainTable.clientWidth;
	
	            //Host정보 설정[필수][HostIp, Port, PagePath]
	            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	            //전체Merge 종류 [선택, Default msNone]
	            MergeSheet = msHeaderOnly;
	
	            //전체Edit 허용 여부 [선택, Default false]
	            Editable = true;
	
	            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	            InitRowInfo( 1, 1, 3, 100);
	
	            // 해더에서 처리할 수 있는 각종 기능을 설정한다
	            InitHeadMode(true, true, true, true, false,false)
	
	            var HeadTitle = "flag||Seq.|B/L No.|BKG No.|bkg_pol_cd|bkg_pod_cd";
	            var headCount = ComCountHeadTitle(HeadTitle);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            InitColumnInfo(headCount, 0, 0, true);
	             
	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	            InitHeadRow(0, HeadTitle, true);
	                                 
	            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	            InitDataProperty(0, cnt++ , dtStatus,	    50, 	daCenter,  	false,    "ibflag"); 
		        InitDataProperty(0, cnt++ , dtCheckBox,		30, 	daCenter,  	true,     "Chk");
	            InitDataProperty(0, cnt++ , dtSeq,	     	30, 	daCenter,  	true,     "Seq");    
	            InitDataProperty(0, cnt++ , dtData, 		90,		daCenter,	true,     "bl_no",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		100,	daCenter,	true,     "bkg_no",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		100,	daCenter,	true,     "bkg_pol_cd",  	false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		100,	daCenter,	true,     "bkg_pod_cd",  	false,    "",  dfNone, 0,   true,	true);
	        }
	        break;

     	case 3: //sheet3 init
    		with (sheetObj) {// 높이 설정
    			style.height = 100;
    			// 전체 너비 설정
    			SheetWidth = mainTable.clientWidth;
    			// Host정보 설정[필수][HostIp, Port, PagePath]
    			if (location.hostname != "")
    				InitHostInfo(location.hostname, location.port, page_path);
    			// 전체Merge 종류 [선택, Default msNone]
    			MergeSheet = msHeaderOnly;
    			// 전체Edit 허용 여부 [선택, Default false]
    			Editable = true;
    			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    			InitRowInfo(1, 1, 2, 100);
    			var HeadTitle = "RESULT";
    			var headCount = ComCountHeadTitle(HeadTitle);

    			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    			InitColumnInfo(headCount, 0, 0, true);

    			// 해더에서 처리할 수 있는 각종 기능을 설정한다
    			InitHeadMode(true, true, false, true, false, false)

    			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    			InitHeadRow(0, HeadTitle, true);

    			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
    			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
    			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
    			// SAVESTATUS, FORMATFIX]
    			InitDataProperty(0, cnt++, dtData, 25, daCenter, false, "key", false, "", dfNone, 0, false, false);
    		}
	}
}

/**
 * 조회 후 처리
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    //document.form.trans_type[0].checked = true;
    
	var tot_cntr = 0;
    var redColor = sheetObj.RgbColor(255, 0, 0);
	for (i=2; i<sheetObj.RowCount+2; i++){
	   	for(j=8; j<20; j++){
			if(sheetObj.CellValue(i, j) == 'N'){
				sheetObj.CellFont("FontColor", i, j) = redColor;
			}
	   	}
	   	tot_cntr = tot_cntr + parseInt(sheetObj.CellValue(i, "cntr_cnt"));
	}
    orgBlCnt = sheetObj.TotalRows;
    orgCntrCnt = tot_cntr;
    document.form.bl_cnt.value = ComAddComma(sheetObj.TotalRows);
    document.form.cntr_cnt.value = ComAddComma(tot_cntr);
}

/**
 * 시트의 체크박스 클릭 시 hidden 시트의 같은 row 체크박스 클릭
 */
function sheet1_OnChange(sheetObj, row, col, val) {
	var sheetObj2 = sheetObjects[1];
	if(sheetObj.ColSaveName(col) == "Chk"){
		sheetObj2.CellValue2(row-1, "Chk") = sheetObj.CellValue(row, "Chk"); 
	}
}

/**
 * 헤더 클릭 시 Sorting
 */
//function sheet1_OnSort(sheetObj, Col, SortArrow) {
//	var sheet2 = sheetObjects[1];
//	sheet2.ColumnSort(Col, SortArrow);
//}

/**
 * B/L Inquiry 화면 이동
 */
function sheet1_OnDblClick(sheetObj, Row, Col){
	var sParam = "";
	var transMode = document.form.trans_mode.value;
	if( transMode == "P"){
		sParam += "pgmNo=ESM_BKG_0217-2&bl_no="+sheetObj.CellValue(Row,"bl_no")+"&trans_mode="+transMode;
	}else{
		sParam += "pgmNo=ESM_BKG_0217-1&bl_no="+sheetObj.CellValue(Row,"bl_no")+"&trans_mode="+transMode;
	}
	ComOpenWindowCenter("ESM_BKG_0217.do?"+sParam, "ESM_BKG_0217", 1024, 600);
}

/**
 * Sheet관련 프로세스 처리
 */ 
function doActionIBSheet(sheetObj,formObj,sAction) {
	//sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	
	switch(sAction) {
		case IBSEARCH:      //Retrieve
			if(!validateForm(sheetObj,formObj,sAction)) return false;
    		ComOpenWait(true, true);
			formObj.f_cmd.value = SEARCH;
			formObj.gubun.value = "";
			if(formObj.loc_nm.value == "POL"){
				formObj.loc_cd.value = formObj.pol_cd.value;
			}
			else if(formObj.loc_nm.value == "POD"){
				formObj.loc_cd.value = formObj.pod_cd.value;
			}

            sheetObj.Redraw = false;  
            
			var sXml = sheetObj.GetSearchXml("ESM_BKG_1046GS.do", FormQueryString(formObj));
			var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
	        if(State == "S"){
	        	 var sheetObj2 = sheetObjects[1];
                 sheetObj.LoadSearchXml(sXml);       
                 sheetObj2.LoadSearchXml(sXml);   
     			 if(sheetObj.TotalRows > 0){ 
	                 sheetObj.CheckAll2("Chk") = 1;   
	                 sheetObj2.CheckAll2("Chk") = 1;
     			 } 
                 sheetObj.Redraw = true;
                 
                 document.form.call_sgn_no.value = ComGetEtcData(sXml,"call_sgn_no") == "null" ? "" : ComGetEtcData(sXml,"call_sgn_no"); 
                 document.form.pre_port.value 	 = ComGetEtcData(sXml,"pre_port") 	 == "null" ? "" : ComGetEtcData(sXml,"pre_port"); 
                 document.form.nxt_port.value 	 = ComGetEtcData(sXml,"nxt_port") 	 == "null" ? "" : ComGetEtcData(sXml,"nxt_port"); 
                 document.form.vps_eta_dt.value  = ComGetEtcData(sXml,"vps_eta_dt")  == "null" ? "" : ComGetEtcData(sXml,"vps_eta_dt"); 
                 document.form.vps_etd_dt.value  = ComGetEtcData(sXml,"vps_etd_dt")  == "null" ? "" : ComGetEtcData(sXml,"vps_etd_dt");
                 document.form.vps_etb_dt.value  = ComGetEtcData(sXml,"vps_etb_dt")  == "null" ? "" : ComGetEtcData(sXml,"vps_etb_dt"); 
                 document.form.vsl_eng_nm.value  = ComGetEtcData(sXml,"vsl_eng_nm")  == "null" ? "" : ComGetEtcData(sXml,"vsl_eng_nm");
                 document.form.snd_date.value    = ComGetEtcData(sXml,"snd_date")  == "null" ? "" : ComGetEtcData(sXml,"snd_date");
                 document.form.eta_flg.value = ComGetEtcData(sXml,"eta_flg") == "null" ? "" : ComGetEtcData(sXml,"eta_flg");
                 document.form.etd_flg.value = ComGetEtcData(sXml,"etd_flg") == "null" ? "" : ComGetEtcData(sXml,"etd_flg"); 
	        }else{
	        	// 에러메세지 출력
	    		ComShowMessage(ComResultMessage(sXml));
	        }
			 ComOpenWait(false);
		break;

        case IBRESET:        //New
    	    formObj.reset();
    	    sheetObjects[0].RemoveAll();
    	    sheetObjects[1].RemoveAll();
    	    sheetObjects[0].CheckAll2("Chk") = 0;
    	    sheetObjects[1].CheckAll2("Chk") = 0;
    	    formObj.vvd.focus();
    	break;
		
		case IBDOWNEXCEL: 	//Down Excel
		   	if (sheetObj.RowCount == 0 ) {
		   		ComShowCodeMessage("BKG00389"); // No data to dowload as Excel
		   	    return;
		   	} else {
				ComOpenWait(true);
		   	    sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", true);
				ComOpenWait(false);
		   	}
		break;

		case IBSAVE:      //Save CSV
			if(!validateForm(sheetObj,formObj,IBSEARCH)) return false; 
			formObj.f_cmd.value = SEARCH01;
			formObj.gubun.value = "csv";

			ComOpenWait(true,true); 
			var sXml = sheetObj.GetSearchXml("ESM_BKG_1046GS.do", FormQueryString(formObj));
			var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
	        if(State == "S"){
			   	if ( ComGetEtcData(sXml,"total") == "0" ) {
			   		ComShowCodeMessage("BKG00389"); // No data to dowload as Excel
			   		ComOpenWait(false);
			   	    return;
			   	} else {
					formObj.f_cmd.value = MULTI01;
					formObj.target = "download";
					formObj.action = "ESM_BKG_1046_1GS.do?bkg_cgo_tp_cd="+formObj.bkg_cgo_tp_cd.value;		
					formObj.submit();
			   	}
	        }
	        else{
                sheetObj.Redraw = false;           
                sheetObj.LoadSearchXml(sXml);   
                sheetObj.Redraw = true;
	        } 
	        //ComOpenWait(false); 
		break;
		
		case IBDELETE:      //Delete
			//if(!validateForm(sheetObj,formObj,sAction)) return false;
			if (sheetObj.CheckedRows(1) == 0) {
				//선택된 내역이 없을경우
				ComShowCodeMessage('BKG00249'); // No Selected Row
	         	return;
			}
			
			if(sheetObj.CheckedRows(1) > 0){
				if(ComShowCodeConfirm('BKG00535')){
					ComOpenWait(true,true);
					formObj.f_cmd.value = MULTI;
					var sParam = FormQueryString(formObj) + "&" + sheetObjects[1].GetSaveString(false);
					var sXml = sheetObj.GetSaveXml("ESM_BKG_1046GS.do", sParam);
			        ComOpenWait(false); 
					ComShowMessage(ComResultMessage(sXml));
			        doActionIBSheet(sheetObj,formObj,IBSEARCH);
				}
			}
		break;
		
		case IBROWSEARCH:	//  B/L Inquiry
			if(sheetObj.TotalRows == 0){
				//선택된 내역이 없을경우
				ComShowCodeMessage('BKG00249'); // No Selected Row
			}else{
				var sParam = "";
				var transMode = document.form.trans_mode.value;
				if( transMode == "P"){
					sParam += "pgmNo=ESM_BKG_0217-2&bl_no="+sheetObj.CellValue(sheetObj.SelectRow,"bl_no")+"&trans_mode="+transMode;
				}else{
					sParam += "pgmNo=ESM_BKG_0217-1&bl_no="+sheetObj.CellValue(sheetObj.SelectRow,"bl_no")+"&trans_mode="+transMode;
				}
				ComOpenWindowCenter("ESM_BKG_0217.do?"+sParam, "ESM_BKG_0217", 1020, 670);
			}
		break;
		
		case IBSEARCH_ASYNC01:	//Transmit Manifest
			formObj.f_cmd.value = MULTI04;
			if(formObj.trans_mode.value == 'O' && formObj.eta_flg.value == '-1'){
				ComShowCodeMessage('BKG06006');
			}
			if(formObj.trans_mode.value == 'O' && formObj.etd_flg.value == '-1'){
				ComShowCodeMessage('BKG06007');
			}
			if(formObj.trans_mode.value == 'D' && formObj.eta_flg.value == '-1'){
				ComShowCodeMessage('BKG06008');
			}
			ComOpenWait(true,true); 
			var sParam = FormQueryString(formObj) + "&" + sheetObjects[0].GetSaveString(false);
			var sXml = sheetObj.GetSaveXml("ESM_BKG_1046GS.do", sParam);
			
			// 30초 이상 걸리는 경우가 발생해서 BackEndJob으로 돌림 3초마다
			var key = ComGetEtcData(sXml, "KEY");
			intervalId = setInterval("doActionValidationResult(sheetObjects[2], '" + key + "');", 3000);
		break;
			
	}
}


/**
 * 저장을 BackEndJob으로 하기 때문에 저장버튼 클릭 후 완료되었는지 확인하는 로직
 * @param sheetObj 시트오브젝트
 * @param sKey BackEndJob Key
 */
function doActionValidationResult(sheetObj, sKey) {
	var sXml = sheetObj.GetSearchXml("ESM_BKG_1046GS.do?f_cmd=" + MULTI03 + "&key=" + sKey);
	var sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");
	// 에러가 발생했을 경우 대기사항을 종료한다.
	if (!ComBkgErrMessage(sheetObj, sXml)) {
		clearInterval(intervalId);
		ComOpenWait(false);
		return;
	}
	if (sJbStsFlg == "SUCCESS") {
		clearInterval(intervalId);
		ComOpenWait(false);
		// 성공메시지 보여주고
		ComShowMessage(ComResultMessage(sXml));
		// sheet1 다시 조회
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		return;
	} else if (sJbStsFlg == "FAIL") {
		//에러
		clearInterval(intervalId);
		ComOpenWait(false);
		// 에러메시지 보여주고
		ComShowMessage(ComResultMessage(sXml));
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
    switch (sAction) {
	    case IBSEARCH: // 조회
			if(!ComChkRequired(formObj)) return false;
			if(formObj.trans_mode.value != "D") return true;
			if(formObj.pod_cd.value.substring(0,2) == "CN"){
				if(formObj.pod_cd.value == "CNHKG"){
					ComShowCodeMessage('BKG06036');   // Invalid POD. China port only.
					return false;
				}
			}else{
				ComShowCodeMessage('BKG06036');   // Invalid POD. China port only.
				return false;
			}
	        return true;
	        break;
    }
}
/* 개발자 작업  끝 */