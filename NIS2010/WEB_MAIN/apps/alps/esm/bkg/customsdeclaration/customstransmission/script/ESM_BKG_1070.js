/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_1070.js
 *@FileTitle : China: Manifest Transmission(CNYIT)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.11.16
 *@LastModifier : 이수빈
 *@LastVersion : 1.0
 * 2009.11.16 이수빈
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
function esm_bkg_1070() {
    this.processButtonClick = processButtonClick;
    this.setSheetObject = setSheetObject;
    this.loadPage = loadPage;
    this.initSheet = initSheet;
    this.doActionIBSheet = doActionIBSheet;
    this.validateForm = validateForm;
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
			
			case "btn_excel":
				doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
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
	
	var formObj = document.form;
	//화면에서 필요한 이벤트
	axon_event.addListenerForm("Click","obj_Click", formObj);
	axon_event.addListenerForm("KeyUp","obj_KeyUp", formObj);
	axon_event.addListenerFormat("KeyPress","obj_KeyPress", formObj);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	
	ComBtnDisable("btn_Transmit");
	formObj.vvd.focus();
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
	            style.height = 360;
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
	
	            var HeadTitle1 = "|Sel.|Seq.|B/L No.|BKG No.|STS|POL|POD|DEL|Package|Package|Weight|Weight|Seal|Seal|SHPR|SHPR|CNEE|CNEE|NTFY|NTFY|TP|TR|DG|RF|CNTR|Transmit Status|Transmit Status";
	            var HeadTitle2 = "|Sel.|Seq.|B/L No.|BKG No.|STS|POL|POD|DEL|Package|Package|Weight|Weight|Seal|Seal|N|A|N|A|N|A|TP|TR|DG|RF|CNTR|User|Time";
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
	            InitDataProperty(0, cnt++ , dtData, 		90,		daCenter,	true,     "bkg_no",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		30,		daCenter,	true,     "bkg_sts_cd",		false,    "",  dfNone, 0,   true,	true);
	            
	            InitDataProperty(0, cnt++ , dtData, 		40,		daCenter,	true,     "pol_cd",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		40,		daCenter,	true,     "pod_cd",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		40,		daCenter,	true,     "del_cd",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		30,		daCenter,	true,     "pck_qty",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		30,		daCenter,	true,     "pck_tp_cd",  	false,    "",  dfNone, 0,   true,	true);
	            
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "act_wgt",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "wgt_ut_cd",  	false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		20,		daCenter,	true,     "seal_no_flg",  	false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		20,		daCenter,	true,     "sealer_cd_flg",	false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		20,		daCenter,	true,     "shpr_nm",  		false,    "",  dfNone, 0,   true,	true);
	            
	            InitDataProperty(0, cnt++ , dtData, 		20,		daCenter,	true,     "shpr_addr",  	false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		20,		daCenter,	true,     "cnee_nm",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		20,		daCenter,	true,     "cnee_addr",  	false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		20,		daCenter,	true,     "ntfy_nm",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		20,		daCenter,	true,     "ntfy_addr",  	false,    "",  dfNone, 0,   true,	true);
	            
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "bkg_cgo_tp_cd",  false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "tr",  			false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "dcgo_flg",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "rc_flg",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		40,		daCenter,	true,     "cntr_cnt",  		false,    "",  dfNone, 0,   true,	true);
	            
	            InitDataProperty(0, cnt++ , dtData, 		70,		daCenter,	true,     "trsm_msg_tp_id", false,    "",  dfNone, 0,   true,	true,	-1,	false,	false);
	            InitDataProperty(0, cnt++ , dtData, 		100,	daCenter,	true,     "mf_snd_dt",  	false,    "",  dfUserFormat2, 0,   true,	true,	-1,	false,	false);

				InitUserFormat2(0, "mf_snd_dt", "####-##-## ##:##:##", "-|:" );	
	        }
            sheetObj.SetMergeCell(0, 9, 2, 2); 
            sheetObj.SetMergeCell(0, 11, 2, 2); 
            sheetObj.SetMergeCell(0, 13, 2, 2); 
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
	
	            var HeadTitle = "flag||Seq|B/L No.|BKG No.";
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
	        }
	        break;
	}
}

/**
 * 조회 후 처리
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var tot_cntr = 0;
    var redColor = sheetObj.RgbColor(255, 0, 0);
	for (i=2; i<sheetObj.RowCount+2; i++){
	   	for(j=9; j<20; j++){
			if(sheetObj.CellValue(i, j) == 'N'){
				sheetObj.CellFont("FontColor", i, j) = redColor;
			}
	   	}
	   	tot_cntr = tot_cntr + parseInt(sheetObj.CellValue(i, "cntr_cnt"));
	}
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
 * Sheet관련 프로세스 처리
 */ 
function doActionIBSheet(sheetObj,formObj,sAction) {
	//sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	
	switch(sAction) {
		case IBSEARCH:      //Retrieve
			if(!validateForm(sheetObj,formObj,sAction)) return false;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			var sXml = sheetObj.GetSearchXml("ESM_BKG_1070GS.do", FormQueryString(formObj));
			var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
	        if(State == "S"){
	        	 var sheetObj2 = sheetObjects[1];
                 sheetObj.Redraw = false;           
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
                 document.form.vsl_eng_nm.value  = ComGetEtcData(sXml,"vsl_eng_nm")  == "null" ? "" : ComGetEtcData(sXml,"vsl_eng_nm");
                 document.form.snd_date.value    = ComGetEtcData(sXml,"snd_date")  == "null" ? "" : ComGetEtcData(sXml,"snd_date");
                 document.form.eta_flg.value = ComGetEtcData(sXml,"eta_flg") == "null" ? "" : ComGetEtcData(sXml,"eta_flg");
                 document.form.etd_flg.value = ComGetEtcData(sXml,"etd_flg") == "null" ? "" : ComGetEtcData(sXml,"etd_flg"); 

             	if( formObj.bl_type.value != 'A' ){
             		if(sheetObj.TotalRows > 0){
                 		ComBtnEnable("btn_Transmit");
             		}
             	}else{
             		ComBtnDisable("btn_Transmit");
             	}
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
		
		case IBSEARCH_ASYNC01:	//Transmit Manifest  
			ComOpenWait(true); 
			formObj.f_cmd.value = COMMAND01;
			var sParam = FormQueryString(formObj) + "&" + sheetObjects[0].GetSaveString(false);
			var sXml = sheetObj.GetSaveXml("ESM_BKG_1070GS.do", sParam);
			var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
	        ComOpenWait(false); 
			ComShowMessage(ComResultMessage(sXml));
	        if(State == "S"){
	        	//formObj.output.value = ComGetEtcData(sXml, "flatFile");
	        	
		        doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
	        }
		break;
			
	}
}

/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateForm(sheetObj,formObj,sAction){
    switch (sAction) {
	    case IBSEARCH: // 조회
			if(!ComChkRequired(formObj)) return false;
	        return true;
	        break;
    }
}
/* 개발자 작업  끝 */