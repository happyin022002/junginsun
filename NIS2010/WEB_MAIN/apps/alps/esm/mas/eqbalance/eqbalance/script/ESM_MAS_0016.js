/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_MAS_0016.js
*@FileTitle : ECC별 기여도 적용 위한 표준 단가 생성_MT 회송비 조회
*Open Issues :
*@LastModifyDate	: 2010.02.22
*@LastModifier 	: 이연각
* 2006-11-16 Sangwook_Nam
* 1.0 최초 생성
=========================================================
* History
* 2008.01.11 전윤주 CSR No.N200712280004   EQ repo rule-set X level 수정하고 저장할 수 있도록 변경
* 2008.02.13 전윤주 CSR No.N200802010006   X level Credit 수정 후 저장 가능
* 2008.09.01 전윤주 CSR No.N200808260006 EQ repo rule-set(Rlane setting을 From-To ECC setting으로)
* 2009.09.10 장영석 New framework 적용
* 2010.02.22 이연각 업무처리중 버튼사용 금지 처리
* 2010.09.01 이일민 [CHM-201004982-01] MAS Architecture 위배사항 수정
* 2011.01.11 이행지 [CHM-201108260-01]  [MAS]Rule-Set 화면 보완사항 처리
* 2011.03.18 김상수 [CHM-201109282-01] Split 04-ALPS의 Location 조회불가건 수정 보완 요청
*                                      - Location에 해당하는 input이나 sheet에 영문대문자와 숫자까지 입력되게 수정
* 2012.03.22 김종준 [CHM-201217091-01] EMU 관련 로직 보완/변경 검토 요청의 건 -POR 별 Credit Ratio를 setup 할수 있는 화면추가 (Rule-set)
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
	 * @class ESM_MAS_0016 : ESM_MAS_0016 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESM_MAS_0016() {
		this.processButtonClick		= processButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.sheet1_OnClick         = sheet1_OnClick;
		this.sheet1_OnChange        = sheet1_OnChange;
		this.sheet2_OnDblClick      = sheet2_OnDblClick;
		this.sheet2_OnSearchEnd     = sheet2_OnSearchEnd();
		this.doActionIBSheet 		= doActionIBSheet;
		this.doActionIBSheet2 		= doActionIBSheet2;
		this.doActionIBSheet3 		= doActionIBSheet3;
		this.openWindowCredit   	= openWindowCredit;
		this.openWindowFromECC   	= openWindowFromECC;
		this.setCheckBoxRow     	= setCheckBoxRow;
		this.searchLocation     	= searchLocation;
	   	this.searchEcc      	    = searchEcc;
	  	this.changeRcc      	    = changeRcc;
	  	this.changeLcc      	    = changeLcc;
		this.validateForm 		    = validateForm;
	}

// 공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;
var loadingMode = false;
var excel_load_yn ="N";
/*
 *버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
 */
document.onclick = processButtonClick;

	/*
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
	 */
  function processButtonClick(){
         /*
         	**** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 ****
         	*/
         var sheetObject = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];
//         var sheetObject3 = sheetObjects[2];


         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

        	    case "btn_Retrieve":
    	            doActionIBSheet3(sheetObject2,formObject,IBSEARCH);
        	        break;

        	    case "btn_Save":
    	            doActionIBSheet3(sheetObject2,formObject,IBSAVE);
        	        break;

        	    case "btn_DownExcel":
        	        doActionIBSheet(sheetObject2,formObject,IBDOWNEXCEL);
        	        break;

        	    case "btng_RowAdd":
    	            doActionIBSheet(sheetObject2,formObject,IBINSERT);
        	        break;

                case "btn_LoadExcel":
                    doActionIBSheet(sheetObject2,formObject,IBLOADEXCEL);
                    break;
        	        

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage(OBJECT_ERROR);
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
	 * IBCombo Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
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
		loadingMode = true;
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
        for(k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],comboObjects[k].id);
        }
        loadingMode = false;
		ComSetFocus(document.form.f_cost_yrmon);
    }

 	/**
     * 멀티콤보 항목을 설정한다.
     */
	function initCombo(comboObj, comboId) {
		with (comboObj) {
	    	if(comboId == "f_cntr_tpsz_cd"){
	    		BackColor = "#CCFFFD";
	    		MaxLength = 3;  // TP/SZ 일 경우자릿수  3자리 제한
	    		ValidChar(2,1); // 영어대문자 사용, 숫자포함 시
	    	} else {
	    		MaxLength = 5;  // RCC,LCC,ECC는 5자리로 제한
	    		ValidChar(2,0); // 영어대문자 사용
	    	}
			DropHeight = 300;
			Index = 0;
		}
	}

   /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
			case 1:
				//sheet2 init
				with (sheetObj) {
					SheetWidth = mainTable.clientWidth;								//전체 너비 설정
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
					MergeSheet = msHeaderOnly;										//전체Merge 종류 [선택, Default msNone]
					Editable = false;												//전체Edit 허용 여부 [선택, Default false]
					InitRowInfo( 1, 1, 9, 100);										//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitColumnInfo(1, 0, 0, true);									//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitHeadMode(true, true, false, true, false,false);				// 해더에서 처리할 수 있는 각종 기능을 설정한다
					var HeadTitle  = "Location" ;
					InitHeadRow(0, HeadTitle, true, false);							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  	true,    "code",   false,          "",       dfNone,       0,     true,       true);
					CountPosition  = 0 ;
					style.height = GetSheetHeight(17) ;

				}
				break;
			case 2:
				//sheet2 init
				with (sheetObj) {
					SheetWidth = mainTable.clientWidth;									//전체 너비 설정
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
					MergeSheet = msHeaderOnly;											//전체Merge 종류 [선택, Default msNone]
					Editable = true;													//전체Edit 허용 여부 [선택, Default false]
					InitRowInfo( 2, 1, 9, 100);											//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitColumnInfo(11, 0, 0, true);										//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitHeadMode(true, true, false, true, false,false);					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					var HeadTitle  = "Del.|STS|No.|DIV|TP/SZ|ECC|LCC|RCC|PFMC Index of Items(%)|PFMC Index of Items(%)|PFMC Index of Items(%)" ;
					var HeadTitle1 = "Del.|STS|No.|DIV|TP/SZ|ECC|LCC|RCC|Imbal. Volume|M/B|Credit Ratio" ;
					InitHeadRow(0, HeadTitle, true);									//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(1, HeadTitle1, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtDelCheck,   30,    daCenter,  true,    "del_chk",       	false, 			"", 	  dfNone,    		0						);
					InitDataProperty(0,	cnt++ ,	dtStatus,	  30,	 daCenter,	true,	 "ibflag"																			);
					InitDataProperty(0, cnt++ , dtSeq,        50,    daCenter,  true,    "no",      		false,          "",       dfNone,   		0,     false,      false);
					InitDataProperty(0, cnt++ , dtCombo,      60,    daCenter,  true,    "cntr_org_dest_cd",true,           "",       dfNone,    		0,     false,      true);
					InitDataProperty(0, cnt++ , dtCombo,      80,    daCenter,  true,    "cntr_tpsz_cd",    true,           "",       dfNone,       	0,     false,      true);
					InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,    "ecc_cd",     		true,           "",       dfNone,       	0,     false,      true);
					InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,    "lcc_cd",     		false,          "",       dfNone,       	0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,    "rcc_cd",     		false,          "",       dfNone,       	0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       100,   daRight, 	true,    "imbal_amt",   	false,          "",       dfInteger,    	0,     true,       true,10);
					InitDataProperty(0, cnt++ , dtData,       100,   daRight, 	true,    "mb_amt",      	false,          "",       dfNullFloatOrg, 	2,     true,       true,5);
					InitDataProperty(0, cnt++ , dtData,       100,   daCenter,  true,    "eq_repo_cr_rto",  false,          "",       dfInteger,    	0,     true,       true,3);

					InitDataCombo(0, "cntr_org_dest_cd", "OP|DEL", "O|D");
					
					CellBackColor(1,"imbal_amt") = RgbColor(222, 251, 248);   // ENIS
					CellBackColor(1,"mb_amt") = CellBackColor(1,"imbal_amt") ;
					CellBackColor(1,"eq_repo_cr_rto") = CellBackColor(1,"imbal_amt") ;
					InitDataValid(0, "ecc_cd", vtEngUpOnly);	//대문자만
					CountPosition  = 0 ;
					style.height = GetSheetHeight(18) ;

				}
				break;
        }
    }

	/**
	 * sheet2 더블클릭시 ecc code에 해당하는 location list를 조회한다.
	 */
	function sheet2_OnDblClick(sheetObj , Row, Col, Val) {
		if ( sheetObj.CellValue(Row, "ibflag") == "R" ) {
			document.form.f_ecc_cd2.value = sheetObj.CellValue(Row, "ecc_cd");
			doActionIBSheet2(sheetObjects[0],document.form,IBSEARCH);
		}
	}

	// 2011.01.11 이행지 [CHM-201108260-01]  [MAS]Rule-Set 화면 보완사항 처리
	// Credit Ratio 클릭시는 조회되지 않고 수정만 가능하도록 활성화 시키기.
	function sheet2_OnClick(sheetObj , Row, Col, Val) {
		if(sheetObj.ColSaveName(Col) == "eq_repo_cr_rto" ){
			sheetObj.SelectCell(Row, Col, true);
			sheetObj.CellValue(Row, Col) = Val;
		}
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {
			case IBCLEAR:          //조회
		        sheetObj.WaitImageVisible = false;
				ComOpenWait(false);
				formObj.f_cmd.value = INIT;
				var sXml = sheetObj.GetSearchXml("ESM_MAS_0016GS2.do", masFormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], formObj.f_cntr_tpsz_cd, "code", "name");
				if (arrXml.length > 1)
					ComXml2ComboItem(arrXml[1], formObj.f_rcc_cd, "code", "name");
				if (arrXml.length > 2)
					ComXml2ComboItem(arrXml[2], formObj.f_lcc_cd, "code", "name");
				if (arrXml.length > 3)
					ComXml2ComboItem(arrXml[3], formObj.f_ecc_cd, "code", "name");

				ComMasSetIBCombo(sheetObjects[1], arrXml[0], "cntr_tpsz_cd", false, 0);
				//ComMasSetIBCombo(sheetObjects[1], arrXml[3], "cntr_org_dest_cd", false, 0); -- OP|DEL 로 세팅
				ComOpenWait(false);
				break;

			case IBSAVE:        //저장
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI01;
				sheetObj.DoAllSave("ESM_MAS_0016GS.do", masFormQueryString(formObj));
				ComOpenWait(false);
				break;

			case IBINSERT:      // 입력
				//sheetObj.DataCopy();        //행 복사

				// 레벨증가 후 행 추가
				//-------------------------------------------------------
				var Row =sheetObj.DataInsert(-1);
				
				sheetObj.CellValue2(Row, "cntr_tpsz_cd") = formObj.f_cntr_tpsz_cd.Code
				sheetObj.CellValue2(Row, "cntr_org_dest_cd") = formObj.cntr_org_dest_cd.value;
				break;

			case IBDOWNEXCEL:        //엑셀 다운로드
				var excelType = selectDownExcelMethod(sheetObj);
				switch (excelType) {
					case "AY":
						sheetObj.Down2Excel(0, false, false, true);
						break;
					case "DY":
						sheetObj.Down2Excel(-1, false, false, true);
						break;
					case "AN":
						sheetObj.SpeedDown2Excel(0, false, false);
						break;
					case "DN":
						sheetObj.SpeedDown2Excel(-1, false, false);
						break;
				}

				break;
        	case IBLOADEXCEL:
        		sheetObj.Redraw = false;
    			ComOpenWait(true);
        		sheetObj.WaitImageVisible = false;
	        	sheetObj.RemoveAll();	        	
	        	sheetObj.RowEditable(3) = true;
	        	EXCEL_LOAD_FLG = sheetObj.LoadExcel(-1, 1, "", "-1", "-1", "", false);
	        	if ( EXCEL_LOAD_FLG ) {
	        		excel_load_yn = "Y";
	        		for(i=0;i<sheetObj.Rows;i++){
        				if ( i>1) {	  //화면상에서 23.XXX보이게 처리
	        				sheetObj.CellValue2(i,"mb_amt") = sheetObj.CellValue(i,"mb_amt")*100;
	        				sheetObj.CellValue(i,"eq_repo_cr_rto") = sheetObj.CellValue(i,"eq_repo_cr_rto")*100;
        				}
	        		}	

	        	}
        		ComOpenWait(false);
        		sheetObj.Redraw = true;
	        	
				break;					
				
		}
	}

	// Sheet관련 프로세스 처리 ECC/Loc
	function doActionIBSheet2(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {
			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH02;
				sheetObj.DoSearch4Post("ESM_MAS_0016GS2.do", masFormQueryString(formObj));
				excel_load_yn = "N";
				ComOpenWait(false);
				break;
		}
	}

	// Sheet관련 프로세스 처리 PFMC
	function doActionIBSheet3(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {
			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				var cntr_org_dest_cd = formObj.cntr_org_dest_cd.value;
				formObj.f_cmd.value = SEARCH03;
				sheetObj.DoSearch4Post("ESM_MAS_0016GS3.do", masFormQueryString(formObj)+"&f_ori_dest="+cntr_org_dest_cd);
				excel_load_yn = "N";
				ComOpenWait(false);
				break;

			case IBSAVE:        //저장
				// 업무처리중 버튼사용 금지 처리
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				doSave();
					
				break;

		}
	}
	function doSave(){
		ComOpenWait(true);
    	var formObj = document.form;
    	var sheetObj = sheetObjects[1];

		var DupRow = sheetObj.ColValueDup("cntr_org_dest_cd|cntr_tpsz_cd|ecc_cd");
		if ( DupRow != -1) {
			ComShowMessage(ComGetMsg("COM131302","["+(eval(DupRow)-1)+"] Row O/D,TP/SZ,ECC Code"));
			sheetObj.CellValue2(DupRow, "ecc_cd") = '';
			sheetObj.SelectCell(DupRow, "ecc_cd", true);
			ComOpenWait(false);
			return;
		}
		
		//일반 저장일때만 체크
		for ( var row=1; row<=sheetObj.rowCount; row++ ) {
			if ( sheetObj.CellValue(row, "ibflag") == "I" ||  sheetObj.CellValue(row, "ibflag") == "U") {
				if ( eval(sheetObj.CellValue(row, "mb_amt")) <-100 || eval(sheetObj.CellValue(row, "mb_amt")) >100 ) {
					ComShowMessage(ComGetMsg("COM12175",sheetObj.CellValue(row, "mb_amt"),"-100", "100"));
					sheetObj.SelectCell(row, "mb_amt", true);
					ComOpenWait(false);
					return;
				}
				if ( eval(sheetObj.CellValue(row, "eq_repo_cr_rto")) <0 || eval(sheetObj.CellValue(row, "eq_repo_cr_rto")) >100 ) {
					ComShowMessage(ComGetMsg("COM12175",sheetObj.CellValue(row, "eq_repo_cr_rto"),"0", "100"));
					sheetObj.SelectCell(row, "eq_repo_cr_rto", true);
					ComOpenWait(false);
					return;
				}
			}
		}
		//저장하시겠습니까 Y이면 메세지 로딩이미지
		if(ComShowConfirm(ComGetMsg('COM130101'))){
		
			formObj.f_cmd.value = MULTI03; 
			sheetObj.DoSave("ESM_MAS_0016GS3.do", masFormQueryString(formObj)+"&excel_load_yn="+excel_load_yn,-1,false);
			excel_load_yn = "N";
			
		}
		ComOpenWait(false);
	}
	
	/**
	 * ecc code를 input box에 입력시 length가 5가 되면 자동조회된다.
	 */
	function searchLocation(obj) {
		// 2011.01.11 이행지 [CHM-201108260-01]  [MAS]Rule-Set 화면 보완사항 처리
		// ComIsAlphabet만 입력이 가능하도록 수정
		var val = obj.value;
		var len = val.length;
		if (obj.value.length == 5) {
			doActionIBSheet2(sheetObjects[1],document.form,IBSEARCH);
		}
	}

	/**
	 * location code를 input box에 입력시 length가 5가 되면 ecc code를 자동조회된다.
	 */
	function searchEcc(obj){
		// 2011.01.11 이행지 [CHM-201108260-01]  [MAS]Rule-Set 화면 보완사항 처리
		// ComIsAlphabet만 입력이 가능하도록 수정
		var val = obj.value;
		var len = val.length;
		if(obj.value.length == 5){
			var formObj = document.form;
			var sheetObj = sheetObjects[0];
			formObj.f_cmd.value = SEARCHLIST03;
			var sXml = sheetObj.GetSearchXml("ESM_MAS_0016GS2.do", masFormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
			if (0 < arrXml.length) {
				ComSetObjValue(formObj.f_ecc, ComGetEtcData(arrXml[0],"eccString"));
			}
		}
	}

	/**
	 * RCC Combo 변경시 LCC Combo를 다시 세팅
	 */
	function f_rcc_cd_OnChange(obj,value,text) {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		formObj.f_cmd.value = SEARCHLIST01;
		var sXml = sheetObj.GetSearchXml("ESM_MAS_0016GS2.do", masFormQueryString(formObj));
		var arrXml = sXml.split("|$$|");
		if (arrXml.length > 0)
			ComXml2ComboItem(arrXml[0], formObj.f_lcc_cd, "code", "name");
		formObj.f_lcc_cd.Index = 0;
		formObj.f_ecc_cd.Index = 0;
	}

	/**
	 * LCC Combo 변경시 ECC Combo를 다시 세팅
	 */
	function f_lcc_cd_OnChange(obj,value,text) {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		formObj.f_cmd.value = SEARCHLIST02;
		var sXml = sheetObj.GetSearchXml("ESM_MAS_0016GS2.do", masFormQueryString(formObj));
		var arrXml = sXml.split("|$$|");
		if (arrXml.length > 0)
			ComXml2ComboItem(arrXml[0], formObj.f_ecc_cd, "code", "name");
		formObj.f_ecc_cd.Index = 0;
	}

	/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
	function validateForm(sheetObj,formObj,sAction){
		// 2011.01.11 이행지 [CHM-201108260-01]  [MAS]Rule-Set 화면 보완사항 처리
		// LOC/ECC Information 조회시는 검색조건의 YYYY-MM 체크하지 않도록 수정
//    	if(sheetObj.id == "sheet2") return true;
		var rt = true;
		with(formObj){
			if(!ComIsDate(formObj.f_cost_yrmon , "ym")){
				ComShowCodeMessage('COM12180');
				ComSetFocus(formObj.f_cost_yrmon);
				return false;
			}
			if(formObj.f_cntr_tpsz_cd.Code == "" || formObj.f_cntr_tpsz_cd.Code == null ){
				if(!ComIsDate(formObj.f_cost_yrmon , "ym")){
					ComSetFocus(formObj.f_cost_yrmon);
					return false;
				}
				ComShowCodeMessage('MAS10002','Type/Size');
				formObj.f_cntr_tpsz_cd.focus();
				return false;
			}
		}
		return rt;
	}
	
    /**
     *sheet2 값 변경시 ecc_cd 존재여부 체크
     */
    function sheet2_OnChange (sheetObj, row , col, value ){
		var formObj = document.form;
		var sheetObj = sheetObjects[1];
    	if (sheetObj.ColSaveName(col) == "ecc_cd" && sheetObj.CellValue(row, "ecc_cd") !='' ) {
    		formObj.f_cmd.value = SEARCH04;
    		var ecc_cd = sheetObj.CellValue(row, col);
    		var sXml = sheetObj.GetSearchXml("ESM_MAS_0016GS2.do", masFormQueryString(formObj)+"&eccCd="+ecc_cd);
    		var checkEccYn = ComGetEtcData(sXml,"checkEccYn");
			if ( checkEccYn !='Y' ) {
				ComShowMessage(ComGetMsg("COM130402","ECC Code"));
				sheetObj.CellValue2(row, "ecc_cd") = '';
				sheetObj.SelectCell(row, "ecc_cd"); //ecc Focus
				return;
			} 
    	} 
    }	

	/**
	* 저장메세지 지정
	*/
	function sheet2_OnSaveEnd(sheetObj,errMsg){
		if(errMsg == ""){
			ComShowMessage(ComGetMsg("MAS00004","Data"));
		}
	}
	

	// POR ECC Setting 팝업열기
	function openWindowFromECC(sheetObj,formObj,sAction) {
		if(!validateForm(sheetObj,formObj,sAction)) return false;
		strUrl = "ESM_MAS_0136.do";
		strUrl += "?f_cost_yrmon="+formObj.f_cost_yrmon.value +
		          "&f_cntr_tpsz_cd="+formObj.f_cntr_tpsz_cd.Code;
		ComOpenWindow(strUrl,'temp','width=400,height=370,menubar=0,status=0,scrollbars=0,resizable=0,top=200,left=400');
		// CSR NO. N200802010006 tree 구조로 변경시 UI 크기 수정
	}

	// DEL ECC Setting 팝업열기
	function openWindowToECC(sheetObj,formObj,sAction) {
		if(!validateForm(sheetObj,formObj,sAction)) return false;
		strUrl = "ESM_MAS_0161.do";
		strUrl += "?f_cost_yrmon="+formObj.f_cost_yrmon.value +
		          "&f_cntr_tpsz_cd="+formObj.f_cntr_tpsz_cd.Code;
		ComOpenWindow(strUrl,'temp','width=400,height=370,menubar=0,status=0,scrollbars=0,resizable=0,top=200,left=400');
		// CSR NO. N200802010006 tree 구조로 변경시 UI 크기 수정
	}

