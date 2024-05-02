/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0702.js
*@FileTitle : Booking Receipt Draft BL EDI
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.09.17 전용진
* 1.0 Creation
* -------------------------------------------------------
* History
* 2011.05.27 이일민 [CHM-201110854-01] [ALPS] Drfat B/L (EDI) 전송 Time Out 수정
* 2011.05.31 이일민 [CHM-201110854-01] [ALPS] Drfat B/L (EDI) 전송 Time Out 수정
* 2011.10.24 정선용 [CHM-201113772-01] [삼성SDS] 신규 TP ID 셋업 요청
* 2013.04.09 김태경 [CHM-201323872] ALPS > Draft B/L &Freight Invoice EDI 화면 Multi Booking No 팝업 추가 
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
     * @class ESM_BKG_0702 : ESM_BKG_0702 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0702() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }

	// 공통전역변수
	
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1; 
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;
	
	var intervalId;
	var intervalTime = 3000;
	var processCnt = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject = sheetObjects[0];
        var sheetObject1 = sheetObjects[1];
        /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
				case "btn_SendtoCustomer":
					if(!validateForm(sheetObjects[0],formObject,"btn_SendtoCustomer")) {
						return false;
					}
					doActionIBSheet(sheetObjects[0],document.form,"btn_SendtoCustomer");
					break;
	
				case "btn_SendtoTerminal":
					if(!validateForm(sheetObjects[0],formObject,"btn_SendtoTerminal")) {
						return false;
					}
					doActionIBSheet(sheetObjects[0],document.form,"btn_SendtoTerminal");
					break;
	
				case "btn_Retrieve":
					ComAddSeparator(formObject.bkg_from_dt);
					ComAddSeparator(formObject.bkg_to_dt);
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
	
				case "btn_New":
					doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
	
					ComClearObject(formObject.bkg_from_dt);
					ComClearObject(formObject.bkg_to_dt);
					formObject.xter_rqst_via_cd.Code = "";
					break;
	
				case "btn_DownExcel":
					doActionIBSheet(sheetObjects[0],document.form,IBDOWNEXCEL);
					break;
	
				case "btns_calendar":
					var cal = new ComCalendarFromTo();
					cal.select(formObject.bkg_from_dt, formObject.bkg_to_dt,'yyyy-MM-dd');
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
     * 콤보 Object를 배열로 등록
     * @param combo_obj 콤보오브젝트
     */
    function setComboObject(combo_obj) {
    	comboObjects[comboCnt++] = combo_obj;
    }
    function initCombo(comboObj) {
    	comboObj.MultiSelect = true;
    	// comboObj.UseCode = true;
    	comboObj.LineColor = "#ffffff";
    	comboObj.SetColAlign("left|left");
    	comboObj.MultiSeparator = ",";
    }
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		for ( var k = 0; k < comboObjects.length; k++) {
			initCombo(comboObjects[k]);
		}
    	var objCbo = comboObjects[0];
    	objCbo.InsertItem(0, "EDI","EDI");
    	objCbo.InsertItem(1, "GTNEXUS","GTNEXUS");
    	objCbo.InsertItem(2, "INTTRA","INTTRA");
    	objCbo.InsertItem(3, "DAKOSY","DAKOSY");
    	objCbo.InsertItem(4, "CARGO SMART","CARGO SMART");
    	objCbo.InsertItem(5, "Simple EDI","Simple EDI");
    	objCbo.InsertItem(6, "WEB Upload","WEB Upload");
	    processCnt = 0;
	
		initControl();
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
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
                    style.height = 330;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(26, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

                    var HeadTitle1 = "|Sel.|Seq.|Doc Type|BL Type|Booking No.|B/L No.|Customer Code|Name|Group EDI ID|EDI Ref|EDI Receive|Receiver Name|VVD|POR|POL|POD|DEL|Sent Time|Sent ID|Sent Status|Sent Nm|||ISA#|tp_301";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,		"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,		"slct_flg",			false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtSeq,			40,		daCenter,	true,		"seq");
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"doc_type",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"bl_tp_cd",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"bkg_no",			false,			"",      dfNone,			0,		false,		true);
		
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		"bl_no",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"cust_cd",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			170,	daLeft,		false,		"cust_nm",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,		"group_edi_id",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,		"edi_ref",			false,			"",      dfNone,			0,		false,		true);
		
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,		"rcv_id",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			200,	daLeft,		false,		"receiver_name",	false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	false,		"vvd",				false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,		"por_cd",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,		"pol_cd",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"pod_cd",			false,			"",      dfNone,			0,		false,		true);
		
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"del_cd",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"sent_dt",			false,			"",      dfDateYmd,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"snd_usr_id",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,		"sent_status",		false,			"",      dfNone,			0,		false,		true);
//					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"ack",				false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		false,		"snd_usr_nm");
					InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		false,		"group_id");
					InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		false,		"ref_code");
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"isa_no",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		false,		"tp_301");
					
					ShowButtonImage = 2;
					sheetObj.FrozenCols = 7;
               }
               break;
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBCLEAR:      //초기화
				ComClearObject(formObj.bkg_from_dt);
				ComClearObject(formObj.bkg_to_dt);
				ComClearObject(formObj.vvd);
				ComClearObject(formObj.pol_cd);
				ComClearObject(formObj.pod_cd);
				ComClearObject(formObj.del_cd);
				ComClearObject(formObj.bkg_ofc_cd);
				ComClearObject(formObj.bkg_stf_cd);
				ComClearObject(formObj.sls_ofc_cd);
				ComClearObject(formObj.sales_rep);
				ComClearObject(formObj.bl_ofc_cd);
				ComClearObject(formObj.bkg_no);
				ComClearObject(formObj.bl_no);
				ComClearObject(formObj.sc_no);
				ComClearObject(formObj.cust_seq);
				ComClearObject(formObj.cust_nm);
				ComClearObject(formObj.edi_receive_nm);
				ComClearObject(formObj.xter_rqst_via_cd);
				
				if(ComGetObjValue(formObj.pgm_no)=="ESM_BKG_0702-1"){
					formObj.type_gbn[0].checked = true;
				} else {
					formObj.type_gbn[1].checked = true;
				}
				/*formObj.bkg_from_dt.value = ComGetNowInfo();
				formObj.bkg_to_dt.value = ComGetNowInfo();*/
				formObj.cust_tp_cd.selectedIndex = 0;
				sheetObj.RemoveAll();
				checkType();
				break;
	
	        case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
		  		sheetObj.WaitImageVisible=false;
				ComOpenWait(true);       			
	        	formObj.f_cmd.value = SEARCH;
	        	var sXml = sheetObj.GetSearchXml("ESM_BKG_0702GS.do", FormQueryString(formObj));
				ComOpenWait(false);       			
		       	var arrXml = sXml.split("|$$|");
		       	for(var i = 0; i < arrXml.length; i++){ 
		       		sheetObjects[i].Redraw = false;    
		       		if(i > 0) {
	     				sheetObjects[i].WaitImageVisible = false;	
		       		}  
		       		sheetObjects[i].LoadSearchXml(arrXml[i]); 
		       		sheetObjects[i].Redraw = true; 
		       	}
	
				formObj.total.value = ComAddComma(ComGetEtcData(sXml, "total"));
				formObj.success.value = ComAddComma(ComGetEtcData(sXml, "success"));
				formObj.send.value = ComAddComma(ComGetEtcData(sXml, "sending"));
				formObj.unsent.value = ComGetEtcData(sXml, "unSent") + " (No Send : " + ComGetEtcData(sXml, "noSend") + " / Failed : " + ComGetEtcData(sXml, "fail") + ")";
				
				for (var i=sheetObj.HeaderRows;i<sheetObj.Rows;i++) {
					sheetObjects[0].CellFontColor(i, 5) = sheetObjects[0].RgbColor(0, 0, 255);
					sheetObjects[0].CellFontColor(i, 6) = sheetObjects[0].RgbColor(0, 0, 255);
				}
	            break;
	
			case IBDOWNEXCEL:
				if (sheetObj.RowCount > 0) {
					sheetObj.SpeedDown2Excel(1);
				} else {
					ComShowMessage(msgs['BKG00155']);
				}
				break;
	
			case "btn_SendtoCustomer":
				ComOpenWait(true);
		    	ComSetObjValue(formObj.f_cmd,MULTI);
				var params = FormQueryString(formObj);
				params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(false, true, 1), "sheet1_");
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0702GS.do", params);
		    	var arrXml = sXml.split("|$$|");
				if (ComGetEtcData(arrXml[0], "jobID")) {
					ComSetObjValue(formObj.key, ComGetEtcData(arrXml[0], "jobID"));
		            intervalId = setInterval(callIntervalBackEndJob, intervalTime);
				} else {  //backendJob 호출 실패
					ComOpenWait(false);
				}
				break;
	
	    	case SEARCH01: // BackEndJob 상태 조회(루프)
		    	ComSetObjValue(formObj.f_cmd,SEARCH01);
		    	params = FormQueryString(formObj);
		    	var sXml = sheetObj.GetSearchXml("ESM_BKG_0702GS.do", params);
		    	var arrXml = sXml.split("|$$|");
				var jobState = ComGetEtcData(arrXml[0], "jb_sts_flg");
				if ("3"==jobState) {  // BackEndJob 성공
					clearInterval(intervalId);
		            doActionIBSheet(sheetObj, document.form, SEARCH02);  // BackEndJob 결과 조회
				} else if ("4"==jobState) {  // BackEndJob 실패
					clearInterval(intervalId);
					ComOpenWait(false);
					ComShowCodeMessage("BKG01163");  //Unprocessed data remained, please click \"Send to Customer\" again to complete transmission
//					doActionIBSheet(sheetObj, formObj, IBSEARCH);
				} else if ("5"==jobState) {  // 이미 BackEndJob 결과 파일을 읽었습니다.
					clearInterval(intervalId);
					ComOpenWait(false);
//					doActionIBSheet(sheetObj, formObj, IBSEARCH);
				}
				break;
	
	    	case SEARCH02: // BackEndJob 결과 조회
		    	ComSetObjValue(formObj.f_cmd,SEARCH02);
		    	params = FormQueryString(formObj);
		    	var sXml = sheetObj.GetSearchXml("ESM_BKG_0702GS.do", params);
		    	var arrXml = sXml.split("|$$|");
		    	if ("Y"==ComGetEtcData(arrXml[0], "result")) {
		    		clearInterval(intervalId);
					ComOpenWait(false);
					ComShowCodeMessage("BKG00204");
//					doActionIBSheet(sheetObj, formObj, IBSEARCH);
				} else if ("N"!=ComGetEtcData(arrXml[0], "result")) {  // BackEndJob 9분30초 경과
					ComShowMessage(ComGetEtcData(arrXml[0], "result"));
					ComOpenWait(false);
//					doActionIBSheet(sheetObj, formObj, IBSEARCH);
				} else { // EDI 전송 중 Exception 발생
					clearInterval(intervalId);
					ComOpenWait(false);
					ComShowCodeMessage("BKG01163");  //Unprocessed data remained, please click \"Send to Customer\" again to complete transmission
//					doActionIBSheet(sheetObj, formObj, IBSEARCH);
				}
		    	break;
	
	    	case "btn_SendtoTerminal":
				formObj.f_cmd.value = MULTI01;
				var params = FormQueryString(formObj);
				params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(false, true, 1), "sheet1_");
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0702GS.do", params);
				if(ComGetEtcData(sXml, "SuccessYn") == "Y"){
					ComShowCodeMessage("BKG00204");
//					doActionIBSheet(sheetObj, formObj, IBSEARCH);
				}else{
					sheetObj.LoadSaveXml(sXml);
				}
				break;
        }
    }

    //BackEndJob 상태 조회용 루프 함수
    function callIntervalBackEndJob() {
    	if (600==processCnt++) {  //intervalTime(3초) * 600 = 30분
    		clearInterval(intervalId);
    		ComOpenWait(false);
    		return;
    	}
        doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
    }

	function initControl() {
		var formObject = document.form;
		// Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat('keydown',	'obj_keydown', formObject); //- 키 눌렸을때
		axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); //- 키보드 입력할때
		axon_event.addListenerForm('beforedeactivate', 'bkg0702_obj_deactivate', formObject); //- 포커스 나갈때
		axon_event.addListenerFormat('beforeactivate',   'bkg0702_activate', formObject); //- 포커스 들어갈때
		axon_event.addListenerForm('blur', 'form1_blur', formObject);
	}

	/**
	 * 마우스 IN일때 
	 */
	function bkg0702_activate(){
		//입력Validation 확인하기
		switch(event.srcElement.name){	
	    	case "bkg_from_dt":
	    		ComClearSeparator(event.srcElement);
				break;
	    	case "bkg_to_dt":
	    		ComClearSeparator(event.srcElement);
				break;
			default:
				break;
		}
	}

	function form1_blur(){
		/*if (event.srcElement.name = "bkg_stf_cd"){
			return true;
		}
		ComChkObjValid(event.srcElement);*/
	}

   	function obj_keydown() {
   		var obj      = event.srcElement;
   		var vKeyCode = event.keyCode;
   		var formObj  = document.form;

   		if ( vKeyCode == 13 ) {
   			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
   		}
   	}

	function obj_keypress(){
		var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	    switch(event.srcElement.dataformat){
	    	case "int":
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
		        break;
	        case "float":
	            //숫자+"."입력하기
	            ComKeyOnlyNumber(event.srcElement, ".");
	            break;
	        case "eng":
	            //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
		        if(keyValue >= 97 && keyValue <= 122) {//소문자
	                event.keyCode = keyValue + 65 - 97;
	            }
	            break;
	        case "engnum"://숫자+"영문대소"입력하기
    	  	  	ComKeyOnlyAlphabet('num'); 
	        	break;	      
	        case "engdn":
	            //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
	            ComKeyOnlyAlphabet('lower');
	            break;
	        case "engup":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('uppernum');
	            break;
	        case "uppernum":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	        	ComKeyOnlyAlphabet('uppernum');
	            break;
	        case "etc": //모든 문자 가능하지만 영문은 대문자로
		        if(keyValue >= 97 && keyValue <= 122) {//소문자
	                event.keyCode = keyValue + 65 - 97;
	            }
	        	break;
	        default:
	            //숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber(event.srcElement);
	    }
	}

	function checkType(){
		var formObj = document.form;
		if(formObj.type_gbn[1].checked) {
			ComBtnDisable("btn_SendtoTerminal");
		} else {
			ComBtnEnable("btn_SendtoTerminal");
		}
	}

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	var result = false;
        with(formObj){
			switch(sAction) {
				case IBSEARCH:
					if(!ComIsNull(formObj.cust_seq)){
						if(!ComIsNumber(formObj.cust_seq)){
				 			ComShowCodeMessage("BKG00340");
							formObj.cust_seq.focus();
							return false;
						}
					}
					if ( ComIsNull(ComTrimAll(formObj.bkg_no))) {
						if ( !ComIsNull(formObj.vvd) ) {
							if ( checkMendatoryPOL(formObj) || checkMendatoryBkgOfcCd(formObj) || checkMendatoryBkgStfCd(formObj)
								|| checkMendatorySlsOfcCd(formObj) || checkMendatorySalesRep(formObj) || checkMendatoryBlOfcCd(formObj)
								|| checkMendatoryScNo(formObj) || checkMendatoryCust(formObj) || checkMendatoryEdiRcv(formObj)
								|| checkMendatoryPOD(formObj) || checkMendatoryDEL(formObj)) {
								result = true;
							} else {
								ComShowCodeMessage('BKG00626', 'Other Value');
								formObj.bkg_ofc_cd.focus();
							}
							return result;
						} else if ( !ComIsNull(formObj.bkg_from_dt) && !ComIsNull(formObj.bkg_to_dt) ) {
							if( checkMendatoryDt(formObj)){
								if ( checkMendatoryPOL(formObj) || checkMendatoryBkgOfcCd(formObj) || checkMendatoryBkgStfCd(formObj)
									|| checkMendatorySlsOfcCd(formObj) || checkMendatorySalesRep(formObj) || checkMendatoryBlOfcCd(formObj)
									|| checkMendatoryScNo(formObj) || checkMendatoryCust(formObj) || checkMendatoryEdiRcv(formObj)
									|| checkMendatoryPOD(formObj) || checkMendatoryDEL(formObj)) {
									result = true;
								} else {
									ComShowCodeMessage('BKG00626', 'Other Value');
									formObj.bkg_ofc_cd.focus();
								}
							}
						} else if ( ComIsNull(formObj.vvd) || ComIsNull(formObj.bkg_from_dt) || ComIsNull(formObj.bkg_to_dt) ) {
							ComShowCodeMessage('BKG00626', '\n\n[BKG Date&Other, VVD&Other, BKG NO] , One must have value');
							formObj.bkg_from_dt.focus();
						} else return result;
					} else return true;
					break;
		
				case "btn_SendtoCustomer":
					if (sheetObj.RowCount == 0) {
						ComShowMessage(msgs['BKG00155']);
						return false;
					}
					if (sheetObj.CheckedRows("slct_flg") == 0) {
						ComShowMessage(msgs['BKG00155']);
						return false;
					}
					var iRow = sheetObj.FindCheckedRow(1);
					var arrRow = iRow.split("|");
					for (var idx=0; idx<arrRow.length-1; idx++){
						if(sheetObj.CellValue(arrRow[idx], "tp_301") == 'T') {
							ComShowMessage(msgs['BKG08290']);
							return false;
						}
					}
					result = true;
					break;
		
				case "btn_SendtoTerminal":
					if (sheetObj.RowCount == 0) {
						ComShowMessage(msgs['BKG00155']);
						return false;
					}
					if (sheetObj.CheckedRows("slct_flg") == 0) {
						ComShowMessage(msgs['BKG00155']);
						return false;
					}
					var iRow = sheetObj.FindCheckedRow(1);
					var arrRow = iRow.split("|");
					for (var idx=0; idx<arrRow.length-1; idx++){
						if(sheetObj.CellValue(arrRow[idx], "tp_301") != 'T') {
							ComShowMessage(msgs['BKG08286']);
							return false;
						}
					}

					result = true;
					break;
			}
        }
        return result;
    }

	function checkMendatoryDt(formObj) {
		if( ComIsNull(formObj.bkg_from_dt) ) {
			return false;
		}
		if( ComIsNull(formObj.bkg_to_dt) ) {
			return false;
		}
		if (formObj.bkg_from_dt.value != "" && formObj.bkg_to_dt.value != "") {
			if (ComGetDaysBetween(formObj.bkg_from_dt,formObj.bkg_to_dt) < 0) {
				ComShowMessage(msgs['BKG00112']);
				return false;
			}			
			if (ComGetDaysBetween(formObj.bkg_from_dt,formObj.bkg_to_dt) >= 7){
				ComShowCodeMessage("BKG00756", "Duration", "7 Days");
				return false;
			}
		}
		return true;
	}

	function checkMendatoryVVD(formObj) {
		if( ComIsNull(formObj.vvd) ) {
			return false;
		}
		return true;
	}

	function checkMendatoryPOL(formObj) {
		if( ComIsNull(formObj.pol_cd) ) {
			return false;
		}
		return true;
	}

	function checkMendatoryPOD(formObj) {
		if( ComIsNull(formObj.pod_cd) ) {
			return false;
		}
		return true;
	}

	function checkMendatoryDEL(formObj) {
		if( ComIsNull(formObj.del_cd) ) {
			return false;
		}
		return true;
	}

	function checkMendatoryBkgOfcCd(formObj) {
		if( ComIsNull(formObj.bkg_ofc_cd) ) {
			return false;
		}
		return true;
	}

	function checkMendatoryBkgStfCd(formObj) {
		if( ComIsNull(formObj.bkg_stf_cd) ) {
			return false;
		}
		return true;
	}

	function checkMendatorySlsOfcCd(formObj) {
		if( ComIsNull(formObj.sls_ofc_cd) ) {
			return false;
		}
		return true;
	}

	function checkMendatorySalesRep(formObj) {
		if( ComIsNull(formObj.sales_rep) ) {
			return false;
		}
		return true;
	}

	function checkMendatoryBlOfcCd(formObj) {
		if( ComIsNull(formObj.bl_ofc_cd) ) {
			return false;
		}
		return true;
	}

	function checkMendatoryScNo(formObj) {
		if( ComIsNull(formObj.sc_no) ) {
			return false;
		}
		return true;
	}

	function checkMendatoryCust(formObj) {
		if( ComIsNull(formObj.cust_seq) && ComIsNull(formObj.cust_nm) ) {
			return false;
		}
		return true;
	}

	function checkMendatoryEdiRcv(formObj) {
		if( ComIsNull(formObj.edi_receive_nm) ) {
			return false;
		}
		return true;
	}

	
	function sheet1_OnDblClick(sheetObj, Row, Col){
		if(Col == 5){
			//freezing 관련 수정
//			ComBkgCall0079(sheetObj.CellValue(Row,Col)); 
			comBkgCallPopBkgDetail(sheetObj.CellValue(Row,Col));   
		}
		if(Col == 6){
			ComOpenWindow("/hanjin/ESM_BKG_0927.do?bkg_no=" + sheetObj.CellValue(Row,5)+"&bl_no=" + sheetObj.CellValue(Row,Col), "PopupEsmBkg0927", "width=916, height=768, scrollbars=no", false);
		}
	} 


	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		with(sheetObj){
			ColFontUnderline("bkg_no") = true;
			ColFontUnderline("bl_no") = true;
		}			
	}
	
    // BKG_NO 입력 받는 메소드(POP UP 에서 호출한다.)
    function openAddPaste(bkgNo){
    	var formObj = document.form;
    	var bkg_no = formObj.bkg_no.value;
    	var _Width = '400';
		var _Height = '420';
//    	var newWin = window.showModalDialog("ESM_BKG_9457.do?bkg_no="+bkgNo, window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:400px;dialogHeight:400px");
    	var newWin = ComOpenWindow("ESM_BKG_9457.do?bkg_no="+formObj.bkg_no.value, "BKG_Win", "scroll:;dialogWidth:" + _Width + "px; dialogHeight:" + _Height + "px", true);
    }
	
    // Pop UP 에서 입력된 No 를 전달 받는다.
    function addValueNo(multi_value){
    	var multis = multi_value.split('\n');
     	multi_value = '';
    	for(var i = 0 ; i < multis.length ; i++){
			if(i == 0){
				multi_value = multis[i];
			}else{
				multi_value = multi_value + ',' + multis[i];
			}
   		}
    	if(multi_value != ''){
    		document.getElementById('bkg_no').value = multi_value;	
    	}
	}	
