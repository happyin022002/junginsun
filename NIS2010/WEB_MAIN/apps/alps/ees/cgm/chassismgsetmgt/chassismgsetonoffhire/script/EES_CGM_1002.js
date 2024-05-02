/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_CGM_1002.js
 *@FileTitle : Chassis Specification Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.28
 *@LastModifier : 박의수
 *@LastVersion : 1.0
 * 2009.04.28 박의수
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
 * @class ees_cgm_1002 : ees_cgm_1002 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ees_cgm_1002() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject     = setSheetObject;
	this.loadPage           = loadPage;
	this.initSheet          = initSheet;
	this.initControl        = initControl;
	this.doActionIBSheet    = doActionIBSheet;
	this.setTabObject       = setTabObject;
	this.validateForm       = validateForm;
}

/* 개발자 작업 */

// 공통전역변수
var sheetObjs = new Array();
var sheetCnt     = 0;

var comboObjects = new Array();
var comboCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObj = sheetObjs[0];

	/** *****************************************************/
	var formObject = document.form;

	//try {
	var srcName = window.event.srcElement.getAttribute("name");
	var formObj = document.form;

	switch (srcName) {

		case "btn_retrieve":
			if(formObj.eq_spec_no.text == null || formObj.eq_spec_no.text == ""){
				ComShowCodeMessage("CGM10004", "Specification No");
				return;
			}
			
			doActionIBSheet(sheetObj, formObject, IBSEARCH);
			sheetObj.CellValue(1, "eq_knd_cd") = "Z";

  	        with(document.eq_spec_no) { // chungpa 20090728 IBCOMBO new클릭시 편집가능설정
  	        	Style = 1; //편집불가능설정
  	        	UseEdit = false;
 	  	    }			
  	        
  	        formObj.eq_spec_no_ins.disabled = true;
			break;

		case "btn_new":
			// 그리드 초기화(그리드 단건을 가지고 컨트롤해야 하므로 모두 삭제)하고 행을 한개만 생성
			// 플레그는 신규이므로 "I"로 강제 할당함.
			sheetObj.RemoveAll();
			var row = sheetObj.DataInsert(0);
			sheetObj.RowStatus(1)="I";
			sheetObj.CellValue(1, "eq_knd_cd") = "Z";
			objectClear();
			
			//chungpa 20100118 일반콤보=>멀티콤보 Upgrade start
			/* 
  	        with(document.eq_spec_no) { // chungpa 20090728 IBCOMBO new클릭시 편집가능설정
  	        	Index2 = -1; // chungpa 20090817 new click 시 콤보 데이터 재클릭이벤트 안먹는 문제점.
  	        	Style = 0; //편집가능설정
  	        	UseEdit = true;
 	  	    }
 	  	    */
			formObj.eq_spec_no_ins.disabled = false;
  	        //document.eq_spec_no.focus();
  	        formObj.eq_spec_no_ins.focus();
  	        ////chungpa 20100118 일반콤보=>멀티콤보 Upgrade end
			break;

		case "btn_save":

			//chungpa 20100118 일반콤보=>멀티콤보 Upgrade start
			// Specification No Null value check
			
			//if(formObj.eq_spec_no.text == null || formObj.eq_spec_no.text == ""){
			//	ComShowCodeMessage("CGM10004", "Specification No");
			//	return;
			//}
			//var tmp_eq_spec_no = formObj.eq_spec_no.text;
			if(formObj.eq_spec_no_ins.value == null || formObj.eq_spec_no_ins.value ==""){
				ComShowCodeMessage("CGM10004", "Specification No");
				if(formObj.eq_spec_no_ins.disabled == false)
				{
					formObj.eq_spec_no_ins.focus();
				}
				return;
			}
			var tmp_eq_spec_no = formObj.eq_spec_no_ins.value;
			
			//chungpa 20100118 일반콤보=>멀티콤보 Upgrade end
			
			// Chassis Type/Size Null value check
			if(formObj.eq_tpsz_cd.text == null || formObj.eq_tpsz_cd.text == ""){
				ComShowCodeMessage("CGM10004", "Chassis Type/Size");
				return;
			}
			// Manufacturer Null value check
			if(formObj.vndr_seq.text == null || formObj.vndr_seq.text == ""){
				ComShowCodeMessage("CGM10004", "Manufacturer");
				return;
			}
			if((sheetObj.CellValue(1, "ibflag")) == "R"){
				return;
			}

			doActionIBSheet(sheetObj,formObject,IBSAVE);
			
			// 그리드에 있는 값으로 콤보 셋팅
			//formObj.eq_spec_no.text = sheetObj.CellValue(1, "eq_spec_no");
			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);

			formObj.eq_spec_no.Text = tmp_eq_spec_no; // chungpa 20090804 combo data select 
			
  	        with(document.eq_spec_no) { // chungpa 20090728 IBCOMBO new클릭시 편집가능설정
  	        	Style = 1; //편집불가능설정
  	        	UseEdit = false;
 	  	    }		
  	        formObj.eq_spec_no_ins.disabled = true;
			break;

		case "btn_delete":
			if(formObj.eq_spec_no.text == null || formObj.eq_spec_no.text == ""){
				ComShowCodeMessage("CGM10004");
				return;
			}
			
			formObj.f_cmd.value = SEARCH01;
     		var sXml = sheetObj.GetSearchXml("EES_CGM_1002GS.do", FormQueryString(formObj));
     		// 데이터 건수
  	        var dataCount = ComGetTotalRows(sXml);
  	        if(dataCount > 0){
  	        	// a.You cannot delete specification number with chassis. Please contact system manager.
  	        	ComShowCodeMessage('CGM10052');
  	        	return;
  	        }

			// b.Are you sure that you want to delete this specification number? 
			if ( ComShowCodeConfirm("CGM10051" ,"delete specification number") ){  
				sheetObj.RowStatus(1) = "D";
				sheetObj.RowHidden(1) = true;				
				doActionIBSheet(sheetObj,formObject,IBDELETE);
			}else
			{
				return;
			}
			
			//오브젝트 초기화  호출
			objectClear();

			var row = sheetObj.DataInsert(0);
			sheetObj.RowStatus(1)="I";
			sheetObj.CellValue(1, "eq_knd_cd") = "Z";

  	        with(document.eq_spec_no) { // chungpa 20090728 IBCOMBO new클릭시 편집가능설정
  	        	Style = 1; //편집불가능설정
  	        	UseEdit = false;
 	  	    }				
  	        formObj.eq_spec_no_ins.disabled = true;
			break;
		}
	
		tRoleApply();
//	} catch (e) {
//			if (e == "[object Error]") {
//				ComShowMessage(OBJECT_ERROR);
//			} else {
//				ComShowMessage(e);
//			}
//	}
}


/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {

	sheetObjs[sheetCnt++] = sheet_obj;
}


/**
 * IBMultiCombo Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setComboObjects(combo_obj) {

	comboObjects[comboCnt++] = combo_obj;
}


/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	var sheetObj = sheetObjs[0];
	var formObj = document.form;
	var obj = event.srcElement;
	
    for(i=0; i<sheetObjs.length; i++){
        // 시작 환경 설정 함수 이름 변경
    	ComConfigSheet (sheetObjs[i] );
    	initSheet(sheetObjs[i],i+1);
        // 마지막 환경 설정 함수 추가
    	ComEndConfigSheet(sheetObjs[i]);
    }

    initControl(sheetObjs[0]);

    // 화면 로딩후 바로 입력시 그리드에 로우가 없어서 나는 에러 방지를 위해 첫행을 생성
	sheetObj.RemoveAll();
	var row = sheetObj.DataInsert(0);

	sheetObj.RowStatus(1)="I";
	sheetObj.CellValue(1, "eq_knd_cd") = "Z";

	axon_event.addListenerForm  ("beforedeactivate",	"obj_deactivate",	form,	"rdoCity");
	axon_event.addListenerFormat("beforeactivate",		"obj_activate",		form);
	axon_event.addListener      ("keypress",			"obj_onkeypress",	"chss_tare_wgt", "chss_tare_wgtlb", "chss_payld_wgt", "chss_payld_wgtlb", "chss_ttl_dim_len", "chss_ttl_dim_wdt", "chss_ttl_dim_hgt", "chss_ttl_dim_len_ft", "chss_ttl_dim_len_in", "chss_ttl_dim_wdt_ft", "chss_ttl_dim_wdt_in", "chss_ttl_dim_hgt_ft", "chss_ttl_dim_hgt_in");
	axon_event.addListener      ("focusout",			"obj_focusout",		"chss_tare_wgt", "chss_tare_wgtlb", "chss_payld_wgt", "chss_payld_wgtlb", "chss_ttl_dim_len", "chss_ttl_dim_wdt", "chss_ttl_dim_hgt", "chss_ttl_dim_len_ft", "chss_ttl_dim_len_in", "chss_ttl_dim_wdt_ft", "chss_ttl_dim_wdt_in", "chss_ttl_dim_hgt_ft", "chss_ttl_dim_hgt_in");
	axon_event.addListener      ("blur",				"obj_blur",			"chss_tare_wgt", "chss_tare_wgtlb", "chss_payld_wgt", "chss_payld_wgtlb", "chss_ttl_dim_len", "chss_ttl_dim_wdt", "chss_ttl_dim_hgt", "chss_ttl_dim_len_ft", "chss_ttl_dim_len_in", "chss_ttl_dim_wdt_ft", "chss_ttl_dim_wdt_in", "chss_ttl_dim_hgt_ft", "chss_ttl_dim_hgt_in");
	axon_event.addListener      ("blur",				"obj_blur",			"eq_spec_no");
	//axon_event.addListener      ("change",				"eq_spec_no_OnChange",	"eq_spec_no");
	
	if(formObj.param_eq_spec_no.value != "")
	{
		formObj.eq_spec_no.Text = formObj.param_eq_spec_no.value;
	}    
	
	tRoleApply();
}

/**
 * Sheet 로딩 후 기본 설정 및 초기화 <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.10.20
 */     
 function sheet1_OnLoadFinish(sheetObj) {
    sheetObj.WaitImageVisible = false;

    doActionIBSheet(sheetObj,document.form,IBCLEAR);
    sheetObj.WaitImageVisible = true; 
 }
 
/**
 * Axon 이벤트 처리2. 이벤트처리함수
 */
function obj_deactivate(){
    ComChkObjValid(event.srcElement);
}
/**
 * Axon 이벤트 처리2. 이벤트처리함수
 */
function obj_activate(){
    ComClearSeparator(event.srcElement);
    //ComIsNumber(event.srcElement, ",");
}

/**
 * HTML Object의 이벤트 처리
 * chungpa 20090729
 */
function eq_spec_no_OnKeyUp(){

}

/**
 * HTML Object의 이벤트 처리
 */
function obj_onkeypress(objs) {
	// 숫자만 입력
	ComKeyOnlyNumber(event.srcElement);
}


/**
 * Form의 Conrol 를 초기화 시킨다.
 */
function initControl(sheetObj){
	// Form 객체 선언
	var formObj = document.form;
	var sheetObj = sheetObjs[0];
	
	formObj.eq_spec_no_ins.disabled = true;
	
	setComboObjects(document.eq_spec_no);
	setComboObjects(document.eq_tpsz_cd);
	setComboObjects(document.vndr_seq);
	
	for(var i=0; i< comboCnt; i++)
	{
		initCombo(comboObjects[i]);
	}
	
	/*
	// 콤보 초기화
	doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
	doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC04);
	doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC05);
	*/
   	doActionIBSheet(sheetObj, document.form, IBRESET);
}


/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
    var cnt = 0;

    switch(sheetNo) {
        case 1:      //t1sheet1 init
            with (sheetObj) {

                // 높이 설정
                style.height = 160;
                
                //전체 너비 설정
                SheetWidth = 200;

                //Host정보 설정[필수][HostIp, Port, PagePath]
  				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 3, 100);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(10, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false,false)

                var HeadTitle = "|eq_spec_no|eq_tpsz_cd|vndr_seq|chss_tare_wgt|chss_payld_wgt|chss_ttl_dim_len|chss_ttl_dim_wdt|chss_ddl_dim_hgt|eq_knd_cd";
            
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

                InitDataProperty(0,	cnt++,	dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
                InitDataProperty(0,	cnt++,	dtData,			120,	daCenter,	true,	"eq_spec_no",		false,	"",	dfNone,	0,	false,	false);
                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"eq_tpsz_cd",		false,	"",	dfNone,	0,	false,	false);
                InitDataProperty(0,	cnt++,	dtData,			150,	daCenter,	true,	"vndr_seq",			false,	"",	dfNone,	0,	false,	false,	30);
                InitDataProperty(0,	cnt++,	dtData,			120,	daCenter,	true,	"chss_tare_wgt",	false,	"",	dfNone,	0,	false,	false);

                InitDataProperty(0,	cnt++,	dtData,			120,	daCenter,	true,	"chss_payld_wgt",	false,	"",	dfNone,	0,	false,	false);
                InitDataProperty(0,	cnt++,	dtData,			120,	daCenter,	true,	"chss_ttl_dim_len",	false,	"",	dfNone,	0,	false,	false);
                InitDataProperty(0,	cnt++,	dtData,			120,	daCenter,	true,	"chss_ttl_dim_wdt",	false,	"",	dfNone,	0,	false,	false,	20);                   
                InitDataProperty(0,	cnt++,	dtData,			120,	daCenter,	true,	"chss_ttl_dim_hgt",	false,	"",	dfNone,	0,	false,	false,	20);                    
                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"eq_knd_cd",		false,	"",	dfNone,	0,	false,	false,	20);                    
           }
            break;
    }
}


/**
 * Sheet관련 프로세스 처리
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	var formObj  = document.form;
	var sheetObj = sheetObjs[0];

	switch (sAction) {

		// Search
		case IBSEARCH:
			formObj.f_cmd.value = SEARCH;

			sheetObj.DoSearch("EES_CGM_1002GS.do",FormQueryString(formObj));

			// 조회된 데이타가 없을때  그리드에 신규행을 생성하고 초기화.
			if(sheetObj.rowCount == 0){

				sheetObj.RemoveAll();
				var row = sheetObj.DataInsert(0);
				sheetObj.RowStatus(1)="I";

				sheetObj.CellValue(1, "eq_spec_no") = formObj.eq_spec_no.text;

				//Weight 초기화
				formObj.reset();
			}else
			{
			    with(document.eq_spec_no) { // chungpa 20090914 Enter눌렀을때 초기화 방지
				  	Style = 1; //편집불가능설정
				  	UseEdit = false;
			    }
			}
			formObj.eq_spec_no_ins.disabled = true; // chungpa 20100118
			
			//Chassis Type/Size 콤보 값 변경 
			formObj.eq_spec_no_ins.value = sheetObj.CellValue(1,"eq_spec_no");
			formObj.eq_tpsz_cd.Code = sheetObj.CellValue(1, "eq_tpsz_cd");
			
			formObj.vndr_seq.Text2    = ''; //chungpa 20100222 lessor display null bug
			formObj.vndr_seq.Code   = sheetObj.CellValue(1, "vndr_seq");

			// 수치 값 셋팅
			form.chss_tare_wgt.value    = ComAddComma(sheetObj.CellValue(1, "chss_tare_wgt"));
			form.chss_payld_wgt.value   = ComAddComma(sheetObj.CellValue(1, "chss_payld_wgt"));
			form.chss_ttl_dim_len.value = ComAddComma(sheetObj.CellValue(1, "chss_ttl_dim_len"));
			form.chss_ttl_dim_wdt.value = ComAddComma(sheetObj.CellValue(1, "chss_ttl_dim_wdt"));
			form.chss_ttl_dim_hgt.value = ComAddComma(sheetObj.CellValue(1, "chss_ttl_dim_hgt"));
			
			// 조회시 해당값 단위환산(Weight).replaceStr(",");
			document.forms[0].chss_tare_wgtlb.value  =  ComAddComma((document.forms[0].chss_tare_wgt.value.replaceStr(",")*2.2046).toFixed(0));
			document.forms[0].chss_payld_wgtlb.value =  ComAddComma((document.forms[0].chss_payld_wgt.value.replaceStr(",")*2.2046).toFixed(0));
			document.forms[0].gross_wgt.value        =  ComAddComma(ComRound(Number(document.forms[0].chss_tare_wgt.value.replaceStr(",")) + Number(document.forms[0].chss_payld_wgt.value.replaceStr(","))), 0);
			document.forms[0].gross_wgtlb.value      =  ComAddComma((ComRound(document.forms[0].chss_tare_wgt.value.replaceStr(",")*2.2046, 0)) + (ComRound(document.forms[0].chss_payld_wgt.value.replaceStr(",")*2.2046, 0)));

			// 조회시 해당값 단위환산(Dimension Lengt)
			setLenmm = ((document.forms[0].chss_ttl_dim_len.value.replaceStr(",")) * 0.03937) / 12 + "";
			strIndex = setLenmm.indexOf(".");
			setLenft = setLenmm.substring(0, strIndex);
			setLenin = ComRound((setLenmm.substring(strIndex) * 10), 0);

			document.forms[0].chss_ttl_dim_len_ft.value = ComAddComma(setLenft);
			document.forms[0].chss_ttl_dim_len_in.value = ComAddComma(setLenin);

			// 조회시 해당값 단위환산(Dimension Width)
			setWdtmm = ((document.forms[0].chss_ttl_dim_wdt.value.replaceStr(",")) * 0.03937) / 12 + "";
			strIndex = setWdtmm.indexOf(".");
			setWdtft = setWdtmm.substring(0, strIndex);
			setWdtin = ComRound((setWdtmm.substring(strIndex) * 10), 0);

			document.forms[0].chss_ttl_dim_wdt_ft.value = ComAddComma(setWdtft);
			document.forms[0].chss_ttl_dim_wdt_in.value = ComAddComma(setWdtin);

			// 조회시 해당값 단위환산(Dimension Height)
			setHgtmm = ((document.forms[0].chss_ttl_dim_hgt.value.replaceStr(",")) * 0.03937) / 12 + "";
			strIndex = setHgtmm.indexOf(".");
			setHgtft = setHgtmm.substring(0, strIndex);
			setHgtin = ComRound((setHgtmm.substring(strIndex) * 10), 0);

			document.forms[0].chss_ttl_dim_hgt_ft.value = ComAddComma(setHgtft);
			document.forms[0].chss_ttl_dim_hgt_in.value = ComAddComma(setHgtin);
			break;

			// Save
       	case IBSAVE:
 			formObj.f_cmd.value = MULTI;
	 		sheetObj.WaitImageVisible=false;
	 		ComOpenWait(true);		  			
 			if(sheetObj.DoSave("EES_CGM_1002GS.do", FormQueryString(formObj)))
 			{
 				ComShowCodeMessage("CGM00003");
 			}else
 			{
 				
 			}
	 		ComOpenWait(false);		 
            break;

    		// Delete
       	case IBDELETE:
 			formObj.f_cmd.value = REMOVE;
	 		sheetObj.WaitImageVisible=false;
	 		ComOpenWait(true);		 
	 		
 			sheetObj.DoSave("EES_CGM_1002GS.do", FormQueryString(formObj)); 
 			
 			// 데이타 삭제후 콤보 내용을 새로고치기 위해  SPECIFICATION COMBO REFLASH
 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
	 		
	 		ComOpenWait(false);		 
            break;

        // Combo - Spec No
    	case IBSEARCH_ASYNC03:
    		formObj.f_cmd.value = SEARCH03;
			var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));

			// chungpa 20100119 save후 tp/sz사라지는 문제점 start
			//기존
			//var sStr = ComGetEtcData(sXml,"comboList");
			//var arrStr = sStr.split("@");
			//MakeComboObject1(formObj.eq_spec_no, arrStr, 0, 0);
			//신규
			var sStr = ComGetEtcData(sXml,"comboList1002");
			var arrStr = sStr.split("@");
			MakeComboObject2_2(formObj.eq_spec_no, arrStr, 0);
			// chungpa 20100119 save후 tp/sz사라지는 문제점 end
    		break;

    	// Combo - Chassis Type/Size
    	case IBSEARCH_ASYNC04:
    		formObj.f_cmd.value = SEARCH04;
    		
			var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
			var sStr = ComGetEtcData(sXml,"comboList");
			var arrStr = sStr.split("@");

			MakeComboObject1(formObj.eq_tpsz_cd, arrStr, 0, 0);
    		break;
    		
    	// Combo - Manufacturer
    	case IBSEARCH_ASYNC05:
    		formObj.f_cmd.value = SEARCH05;
    		
			var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
			var sStr = ComGetEtcData(sXml, "comboList");
			var arrStr = sStr.split("@");
			
			MakeComboObjectManufacture(formObj.vndr_seq, arrStr, 0, 0);
			break;

    	case IBRESET:
    		var idx = 0
    		var sXml2 = document.form2.sXml.value;
    		var arrXml = sXml2.split("|$$|");
    		
    		// CGM_EQ_SPEC 테이블에서 Spec No 리스트
    		if ( arrXml[idx] == null ) {return;}
    		var vArrayListData = ComCgmXml2ListMap(arrXml[idx]);
    	    var arrStr1 = new Array();
    		for ( var i = 0; i < vArrayListData.length; i++) {
    		    vListData = vArrayListData[i];
    		    //chungpa 20100118 일반콤보=>멀티콤보 Upgrade start
    		    //arrStr1[i] = vListData["code1"] + "|" + vListData["desc1"];
    		    arrStr1[i] = vListData["code1"] + "|" + vListData["desc2"];
    		    //chungpa 20100118 일반콤보=>멀티콤보 Upgrade end
    		}

    		//chungpa 20100118 일반콤보=>멀티콤보 Upgrade start
    		//기존단일컬럼 MakeComboObject1(formObj.eq_spec_no, arrStr1, 0, 0);
			//신규멀티컬럼
    		MakeComboObject2_2(formObj.eq_spec_no, arrStr1, 0);
    		//chungpa 20100118 일반콤보=>멀티콤보 Upgrade end
    		
    		idx++;        		
    		
    		//Type/Size
    		if ( arrXml[idx] == null ) {return;}
    		var vArrayListData2 = ComCgmXml2ListMap(arrXml[idx]);
    	    var arrStr2 = new Array();
    		for ( var i = 0; i < vArrayListData2.length; i++) {
    		    vListData = vArrayListData2[i];
    		    arrStr2[i] = vListData["code1"] + "|" + vListData["desc1"];
    		}
    		MakeComboObject1(formObj.eq_tpsz_cd, arrStr2, 0, 0);
	  		idx++;
	  		
    		// Manufacturer
    		if ( arrXml[idx] == null ) {return;}
    		var vArrayListData3 = ComCgmXml2ListMap(arrXml[idx]);
    	    var arrStr3 = new Array();
    		for ( var i = 0; i < vArrayListData3.length; i++) {
    		    vListData = vArrayListData3[i];
    		    arrStr3[i] = vListData["code1"] + "|" + vListData["desc1"];
    		}
    		MakeComboObjectManufacture(formObj.vndr_seq, arrStr3, 0, 0);
	  		idx++;

    		break;			
	}
}


/**
 * 멀티콤보 생성
 */
function initCombo(comboObj) {
	switch(comboObj.id) {
        // Spec No
	    case "eq_spec_no":
	    	with(comboObj){
	        	DropHeight = 220;
	        	MultiSelect = false;
	        	MaxSelect = 1;
	        	
	        	ValidChar(1,3);         // 영어 사용, 숫자포함, 특수문자 포함.
	            IMEMode = 0;            // 영문
	            MaxLength = 20;         // 20자까지 입력
	    	}
	    	break;
	    	
	    // Chassis Type/Size/eq_tpsz_cd
	    case "eq_tpsz_cd":
	    	with(comboObj){
	        	DropHeight = 220;
	        	MultiSelect = false;
	        	MaxSelect = 1;
	    	}
	    	break;
	    	
	    // Manufacturer
	    case "vndr_seq":
	        with(comboObj) {
	        	DropHeight = 220;
	        	MultiSelect = false;
	        	MaxSelect = 1;
	        }
	        break;
    }
}



/** 
 * IBSheet Grid 밖에 콤보 추가(Spec No * Type/Size)
 * @author 박의수
 * @version 2009.06.05
 */ 
function ComCgmMakeMultiCombo1(cmbObj, arrStr, txtCol, codeCol) {
	cmbObj.RemoveAll();
	cmbObj.InsertItem(0, "", "");

	// Loop를 돌리기 위해 데이타 갯수를 구함 
	var arrCode = arrStr[0].split("|");
	
	for (var i = 0; i < arrCode.length;i++ ) {
		var arrCode2 = arrCode[i].split("|");
		cmbObj.InsertItem(i+1, arrCode2[txtCol], arrCode2[codeCol]);
	}
	cmbObj.Index2 = "" ;
}


/**
 * 콤보 오브젝트 생성(Spec No * Type/Size)
 */
function MakeComboObject1(cmbObj, arrStr, txtCol, codeCol) {
	cmbObj.RemoveAll();
	cmbObj.InsertItem(0, "", "");
	
	for (var i=0; i<arrStr.length; i++) {
		var arrCode = arrStr[i].split("|");
		cmbObj.InsertItem(i+1, arrCode[codeCol], arrCode[txtCol]);
	}
	cmbObj.Index2 = "" ;
}
/**
 * 콤보 오브젝트 생성(Manufacturer)
 * (Description이 보여지고 Code가 저장되어야 하므로 콤보 생서 오브젝트를 별도로 사용)
 */
function MakeComboObjectManufacture(cmbObj, arrStr, txtCol, codeCol) {
	cmbObj.RemoveAll();
	cmbObj.InsertItem(0, "", "");
	cmbObj.InsertItem(1, "Thermo King Corporation","113272"); // chungpa 20100226 초주의! 하드코딩 DATA 113272
	for (var i=0; i<arrStr.length; i++) {
		var arrCode = arrStr[i].split("|");
		cmbObj.InsertItem(i+2, arrCode[1], arrCode[codeCol]);
	}
	cmbObj.Index2 = "" ;
}

 /**
  * 콤보 오브젝트 생성
  * @author 조재성
  * @version 20091113
  */
 function MakeComboObject2_2(cmbObj, arrStr, col) {
 	cmbObj.RemoveAll();
 	cmbObj.InsertItem(0, "", "");
 	
 	for (var i = 0; i < arrStr.length;i++ ) {
 		var arrCode = arrStr[i].split("|");
 		cmbObj.InsertItem(i+1, arrStr[i], arrCode[col]);
 	}
 	cmbObj.Index2 = "" ;
 }
 
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
//	    if (!isNumber(formObj.iPage)) {
//	        return false;
//	    }
    }
    return true;
}


/** 
 * Combo Spec No 변경시 그리드로 값 셋팅
 */
function eq_spec_no_OnChange(comboObj, Index_Code, Text){
	 
	var formObj = document.form;
	var sheetObj = sheetObjs[0];
	var comboValuea = comboObj.GetText(Index_Code,0);

	// orginal sheetObj.CellValue(1, "eq_spec_no") = comboValuea;
	sheetObj.CellValue2(1, "eq_spec_no") = comboValuea;
	
	if(Text.length > 20) // chungpa 20090729 MAXLEN cannot be over more than 20 
	{
		ComShowCodeMessage('CGM10019','eq_spec_no(20)');
		//document.eq_spec_no.Text2 = Text.substring(0,19); // chungpa text로 초기화가 안됨
		document.eq_spec_no.Text2 = '';	// 명백한 오류상황이므로 20자가 넘을 경우 빈칸으로 초기화함. 
		
	}	

	//start chungpa 20090817 EES_CGM_1002 Retrieve 버튼을 삭제처리하고 Model No 콤보의 값을 선택할때 마다 자동으로 Retrieve를 실행하도록 해주세요
	if(formObj.eq_spec_no.text == null || formObj.eq_spec_no.text == ""){
		//document.eq_spec_no.Index2 = -1; // chungpa 20090804 new click 시 콤보 데이터 재클릭이벤트 안먹는 문제점.
		objectClear(); // 2차 이벤트발생함
		return;
	}
	
	doActionIBSheet(sheetObj, formObj, IBSEARCH);
	sheetObj.CellValue(1, "eq_knd_cd") = "Z";

	/*// chungpa 20090914 Enter눌렀을때 초기화 방지
    with(document.eq_spec_no) { // chungpa 20090728 IBCOMBO new클릭시 편집가능설정
	  	Style = 1; //편집불가능설정
	  	UseEdit = false;
    }*/
	
	//end chungpa 20090817 EES_CGM_1002 Retrieve 버튼을 삭제처리하고 Model No 콤보의 값을 선택할때 마다 자동으로 Retrieve를 실행하도록 해주세요

}
/** 
 * Combo Chassis Type/Size 변경시 그리드로 값 셋팅
 */
function eq_tpsz_cd_OnChange(comboObj, Index_Code, Text){
	var sheetObj = sheetObjs[0];
	var comboValueb = comboObj.GetText(Index_Code,0);

	sheetObj.CellValue(1, "eq_tpsz_cd") = comboValueb;
}
/** 
 * Combo Manufacturer 변경시 그리드로 값 셋팅
 */
function vndr_seq_OnChange(comboObj, Index_Code, Text){
	var sheetObj = sheetObjs[0];
	var comboValuec = comboObj.GetText(Index_Code, 1);

	sheetObj.CellValue(1, "vndr_seq") = Index_Code;
}


/**
 * Specification 값 변경시 그리드로 값 셋팅 
 * (그리드 바깥에 있는 콤보 접근)
 */
function obj_blur(comboObj, Index_Code, Text){
	var sheetObj = sheetObjs[0];
	var formObj  = document.form;
	
	sheetObj.CellValue(1, "eq_spec_no") = formObj.eq_spec_no.text;
}


/**
 * 오브젝트 초기화 
 */
function objectClear(){
	var formObj = document.form;
	
	//IBMultiCombo 초기화
	formObj.reset();
	formObj.eq_spec_no_ins.value = "";
	formObj.eq_spec_no.Code = "";
	formObj.eq_tpsz_cd.Code = "";
	formObj.vndr_seq.Code = "";
}

/**
* Specification No 대문자만 입력
*/
//function eq_spec_no_OnKeyDown(comboObj, KeyCode, Shift) {
//
//	// 공통에 요구할 사항(멀티콤보에 ComKeyOnlyAlphabet류의 공통함수 필요
//	// 영어대문자, 숫자, 지정문자
//	//KeyCode = KeyCode + 65 - 97;
//	//comboObj.Text = comboObj.Text.toUpperCase();
//
//return KeyCode;	
//}

///////////////////////////////////////////////////////////////////////////////////////////////////
// 아래 부분은 단위환산관련 스크립트만 존재함


/**
 * HTML Object의 이벤트 처리
 */
function obj_focusout() {
	var sheetObj = sheetObjs[0];
	var formObj = document.form;
	var obj = event.srcElement;

    ComChkObjValid(event.srcElement);

	switch(obj.name){
        case "chss_tare_wgt":
    		var chss_tare_wgt  = formObj.chss_tare_wgt.value.replaceStr(",");
    		if(formObj.chss_payld_wgt.value == ""){
    			var chss_payld_wgt = 0;
    		} else {
    			var chss_payld_wgt = formObj.chss_payld_wgt.value.replaceStr(",");
    		}
    		
    		if(ComTrim(obj.value) != "" ){
        		formObj.chss_tare_wgtlb.value  = ComAddComma(chgKgLbs(obj.value.replaceStr(",")));

        		var chss_tare_wgtlb  = chgKgLbs(obj.value.replaceStr(","));
        		var chss_payld_wgtlb = formObj.chss_payld_wgtlb.value.replaceStr(",");

        		formObj.gross_wgt.value   = ComAddComma(Number(chss_tare_wgt)   + Number(chss_payld_wgt));
        		formObj.gross_wgtlb.value = ComAddComma(Number(chss_tare_wgtlb) + Number(chss_payld_wgtlb));
        	}
    		sheetObj.CellValue(1, "chss_tare_wgt") = document.forms[0].chss_tare_wgt.value.replaceStr(",");
        	break;

        case "chss_payld_wgt":
        	if(formObj.chss_tare_wgt.value == ""){
        		var chss_tare_wgt = 0;
        	} else {
        		var chss_tare_wgt = formObj.chss_tare_wgt.value.replaceStr(",");
        	}
        	var chss_payld_wgt = formObj.chss_payld_wgt.value.replaceStr(",");

        	if(ComTrim(obj.value) != "" ){
        		formObj.chss_payld_wgtlb.value = ComAddComma(chgKgLbs(obj.value.replaceStr(",")));
        		var chss_tare_wgtlb  = formObj.chss_tare_wgtlb.value.replaceStr(",");
        		var chss_payld_wgtlb = chgKgLbs(obj.value.replaceStr(","));

        		formObj.gross_wgt.value   = ComAddComma(Number(chss_tare_wgt)   + Number(chss_payld_wgt));
        		formObj.gross_wgtlb.value = ComAddComma(Number(chss_tare_wgtlb) + Number(chss_payld_wgtlb));
        	}
        	sheetObj.CellValue(1, "chss_payld_wgt") = document.forms[0].chss_payld_wgt.value.replaceStr(",");
        	break;

        case "chss_tare_wgtlb":
    		var chss_tare_wgtlb = formObj.chss_tare_wgtlb.value.replaceStr(",");
        	if(formObj.chss_payld_wgtlb.value == ""){
        		var chss_payld_wgtlb = 0;
        	} else {
        		var chss_payld_wgtlb = formObj.chss_payld_wgtlb.value.replaceStr(",");        		
        	}
        	
        	if(ComTrim(obj.value) != ""){
        		formObj.chss_tare_wgt.value  = ComAddComma(chgLbKgs(obj.value.replaceStr(",")));

        		var chss_tare_wgt  = chgLbKgs(obj.value.replaceStr(","));
        		var chss_payld_wgt = formObj.chss_payld_wgt.value.replaceStr(",");

        		formObj.gross_wgt.value   = ComAddComma(Number(chss_tare_wgt)   + Number(chss_payld_wgt));
        		formObj.gross_wgtlb.value = ComAddComma(Number(chss_tare_wgtlb) + Number(chss_payld_wgtlb));
        	}
        	sheetObj.CellValue(1, "chss_tare_wgt") = document.forms[0].chss_tare_wgt.value.replaceStr(",");
        	break;

        case "chss_payld_wgtlb":
        	if(formObj.chss_tare_wgtlb.value == ""){
        		var chss_tare_wgtlb = 0;
        	} else {
        		var chss_tare_wgtlb = formObj.chss_tare_wgtlb.value.replaceStr(",");
        	}
        	
        	var chss_payld_wgtlb = formObj.chss_payld_wgtlb.value.replaceStr(",");
        	
        	if(ComTrim(obj.value) != "" ){
        		formObj.chss_payld_wgt.value = ComAddComma(chgLbKgs(obj.value.replaceStr(",")));

        		var chss_tare_wgt  = formObj.chss_tare_wgt.value.replaceStr(",");
        		var chss_payld_wgt = chgLbKgs(obj.value.replaceStr(","));
        		
        		formObj.gross_wgt.value   = ComAddComma(Number(chss_tare_wgt)   + Number(chss_payld_wgt));
        		formObj.gross_wgtlb.value = ComAddComma(Number(chss_tare_wgtlb) + Number(chss_payld_wgtlb));
        	}
        	sheetObj.CellValue(1, "chss_payld_wgt") = document.forms[0].chss_payld_wgt.value.replaceStr(",");
        	break;
        	
        case "chss_ttl_dim_len":
        	var sheetObj = sheetObjs[0];
        	var setLenmm    = document.forms[0].chss_ttl_dim_len.value.replaceStr(",");
        	var setLenft    = document.forms[0].chss_ttl_dim_len_ft.value.replaceStr(",");
        	var setLenin    = document.forms[0].chss_ttl_dim_len_in.value.replaceStr(",");
        	setLenmm = ((setLenmm)*0.03937)/12 + "";
        	strIndex = setLenmm.indexOf(".");
        	setLenft = setLenmm.substring(0, strIndex);
        	setLenin = (setLenmm.substring(strIndex)*10).toFixed(0);
        	document.forms[0].chss_ttl_dim_len_ft.value = setLenft;
        	document.forms[0].chss_ttl_dim_len_in.value = setLenin;
        	
        	sheetObj.CellValue(1, "chss_ttl_dim_len") = document.forms[0].chss_ttl_dim_len.value.replaceStr(",");
        	break;
        	
        case "chss_ttl_dim_wdt":
        	var sheetObj = sheetObjs[0];
        	var setWdtmm    = document.forms[0].chss_ttl_dim_wdt.value.replaceStr(",");
        	var setWdtft    = document.forms[0].chss_ttl_dim_wdt_ft.value.replaceStr(",");
        	var setWdtin    = document.forms[0].chss_ttl_dim_wdt_in.value.replaceStr(",");
        	
        	setWdtmm = ((setWdtmm) * 0.03937)/12 + "";
        	strIndex = setWdtmm.indexOf(".");
        	setWdtft = setWdtmm.substring(0, strIndex);
        	setWdtin = (setWdtmm.substring(strIndex)*10).toFixed(0);
        	document.forms[0].chss_ttl_dim_wdt_ft.value = setWdtft;
        	document.forms[0].chss_ttl_dim_wdt_in.value = setWdtin;
        	
        	sheetObj.CellValue(1, "chss_ttl_dim_wdt") = document.forms[0].chss_ttl_dim_wdt.value.replaceStr(",");
        	break;
        	
        case "chss_ttl_dim_hgt":
        	var sheetObj = sheetObjs[0];
        	var setHgtmm    = document.forms[0].chss_ttl_dim_hgt.value.replaceStr(",");
        	var setHgtft    = document.forms[0].chss_ttl_dim_hgt_ft.value.replaceStr(",");
        	var setHgtin    = document.forms[0].chss_ttl_dim_hgt_in.value.replaceStr(",");
        	
        	setHgtmm = ((setHgtmm) * 0.03937) / 12 + "";
        	strIndex = setHgtmm.indexOf(".");
        	setHgtft = setHgtmm.substring(0, strIndex);
        	setHgtin = (setHgtmm.substring(strIndex) * 10).toFixed(0);
        	document.forms[0].chss_ttl_dim_hgt_ft.value = setHgtft;
        	document.forms[0].chss_ttl_dim_hgt_in.value = setHgtin;
        	
        	sheetObj.CellValue(1, "chss_ttl_dim_hgt") = document.forms[0].chss_ttl_dim_hgt.value.replaceStr(",");
        	break;
        	
        case "chss_ttl_dim_len_ft":
        	var sheetObj = sheetObjs[0];
        	var setLenmm    = document.forms[0].chss_ttl_dim_len.value.replaceStr(",");
        	var setLenft    = document.forms[0].chss_ttl_dim_len_ft.value.replaceStr(",");
        	var setLenin    = document.forms[0].chss_ttl_dim_len_in.value.replaceStr(",");

        	setLenmm = (Number(setLenft * 304.79999) + (Number(setLenin) * 25.4)).toFixed(0);
        	document.forms[0].chss_ttl_dim_len.value = ComAddComma(setLenmm);
        	
        	sheetObj.CellValue(1, "chss_ttl_dim_len") = document.forms[0].chss_ttl_dim_len.value.replaceStr(",");
	        break;

        case "chss_ttl_dim_len_in":
        	var sheetObj = sheetObjs[0];
        	var setLenmm    = document.forms[0].chss_ttl_dim_len.value.replaceStr(",");
        	var setLenft    = document.forms[0].chss_ttl_dim_len_ft.value.replaceStr(",");
        	var setLenin    = document.forms[0].chss_ttl_dim_len_in.value.replaceStr(",");

        	setLenmm = (Number(setLenft * 304.79999) + (Number(setLenin) * 25.4)).toFixed(0);
        	document.forms[0].chss_ttl_dim_len.value = ComAddComma(setLenmm);
        	
        	sheetObj.CellValue(1, "chss_ttl_dim_len") = document.forms[0].chss_ttl_dim_len.value.replaceStr(",");
	        break;

        case "chss_ttl_dim_wdt_ft":
        	var sheetObj = sheetObjs[0];
        	var setWdtmm    = document.forms[0].chss_ttl_dim_wdt.value.replaceStr(",");
        	var setWdtft    = document.forms[0].chss_ttl_dim_wdt_ft.value.replaceStr(",");
        	var setWdtin    = document.forms[0].chss_ttl_dim_wdt_in.value.replaceStr(",");

        	setWdtmm = (Number(setWdtft * 304.79999) + (Number(setWdtin) * 25.4)).toFixed(0);
        	document.forms[0].chss_ttl_dim_wdt.value = ComAddComma(setWdtmm);
        	
        	sheetObj.CellValue(1, "chss_ttl_dim_wdt") = document.forms[0].chss_ttl_dim_wdt.value.replaceStr(",");
	        break;

        case "chss_ttl_dim_wdt_in":
        	var sheetObj = sheetObjs[0];
        	var setWdtmm    = document.forms[0].chss_ttl_dim_wdt.value.replaceStr(",");
        	var setWdtft    = document.forms[0].chss_ttl_dim_wdt_ft.value.replaceStr(",");
        	var setWdtin    = document.forms[0].chss_ttl_dim_wdt_in.value.replaceStr(",");

        	setWdtmm = (Number(setWdtft * 304.79999) + (Number(setWdtin) * 25.4)).toFixed(0);
        	document.forms[0].chss_ttl_dim_wdt.value = ComAddComma(setWdtmm);
        	
        	sheetObj.CellValue(1, "chss_ttl_dim_wdt") = document.forms[0].chss_ttl_dim_wdt.value.replaceStr(",");
	        break;

        case "chss_ttl_dim_hgt_ft":
        	var sheetObj = sheetObjs[0];
        	var setHgtmm    = document.forms[0].chss_ttl_dim_hgt.value.replaceStr(",");
        	var setHgtft    = document.forms[0].chss_ttl_dim_hgt_ft.value.replaceStr(",");
        	var setHgtin    = document.forms[0].chss_ttl_dim_hgt_in.value.replaceStr(",");

        	setHgtmm = (Number(setHgtft * 304.79999) + (Number(setHgtin) * 25.4)).toFixed(0);
        	document.forms[0].chss_ttl_dim_hgt.value = ComAddComma(setHgtmm);
        	
        	sheetObj.CellValue(1, "chss_ttl_dim_hgt") = document.forms[0].chss_ttl_dim_hgt.value.replaceStr(",");
	        break;

        case "chss_ttl_dim_hgt_in":
        	var sheetObj = sheetObjs[0];
        	var setHgtmm    = document.forms[0].chss_ttl_dim_hgt.value.replaceStr(",");
        	var setHgtft    = document.forms[0].chss_ttl_dim_hgt_ft.value.replaceStr(",");
        	var setHgtin    = document.forms[0].chss_ttl_dim_hgt_in.value.replaceStr(",");

        	setHgtmm = (Number(setHgtft * 304.79999) + (Number(setHgtin) * 25.4)).toFixed(0);
        	document.forms[0].chss_ttl_dim_hgt.value = ComAddComma(setHgtmm);
        	
        	sheetObj.CellValue(1, "chss_ttl_dim_hgt") = document.forms[0].chss_ttl_dim_hgt.value.replaceStr(",");
	        break;
    }
}


/**
 * 단위환산 : Kg >> Lbs
 * 공식 : Kg = Lbs * 0.45359
 */
function chgKgLbs(kgs){
	return ComRound(kgs * 2.2046, 0);
}
/**
 * 단위환산 : Lbs >> Kg
 * 공식 : Lbs = Kg * 2.2046
 */
function chgLbKgs(lbs){
	return ComRound(lbs * 0.45359, 0);
}

 /**
 * 기능(ex:btn_save)에 권한(trole) 적용  <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2010.03.05
 */     
 function tRoleApply() {
	  var formObj = document.form;
	  if(formObj.trole.value == "Authenticated")
	  {

	  }else
	  {
		  ComBtnDisable("btn_save");
		  ComBtnDisable("btn_delete");
	  }
 } 
/* 개발자 작업 끝 */
