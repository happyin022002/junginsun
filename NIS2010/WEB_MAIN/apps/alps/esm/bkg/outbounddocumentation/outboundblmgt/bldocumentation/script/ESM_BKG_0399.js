/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_399.js
*@FileTitle : NVOCC House B/L Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.07.22 김영출
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
     * @class ESM_BKG_399 : ESM_BKG_399 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0399() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }

   	/* 개발자 작업	*/

	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var callback_func = '';

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

				case "btn_RowAdd":
					var nRow = sheetObject1.DataInsert(-1);
					//alert(nRow);
					sheetObject1.CellValue2(nRow, "ofc_cd") = formObject.ofc_cd.value;
					//sheetObject1.CellValue2(nRow+1, "ofc_cd") = formObject.ofc_cd.value;
					//sheetObject1.CellValue2(nRow, "prof_seq") = ' ';
					//sheetObject1.CellValue2(nRow+1, "prof_seq") = ' ';
					//sheetObject1.CellValue2(nRow, "ref_no") = ' ';
					//sheetObject1.CellValue2(nRow+1, "ref_no") = ' ';
					//
					setCMInfo(sheetObject1.SelectRow );
				break;

				case "btn_Delete":
					//
					ComRowHideDelete(sheetObject1, "sel", true);
					//
					var sRow = sheetObject1.FindStatusRow("U|I|R");
					if(sRow == ''){
						sheetObject2.removeAll();
					}else{
						var arRow = sRow.split(";");
						var curIdx = arRow[arRow.length-2];
						sheetObject1.SelectCell(curIdx, 2, false);
						setCMInfo(curIdx);
					}					
				break;


				case "btn_RowAdd2":
					var pSeq = sheetObject1.CellValue(sheetObject1.SelectRow, "prof_seq");
					if(pSeq == '' || pSeq == ' '){
						if(confirm(ComGetMsg("BKG08010"))){
							doActionIBSheet(sheetObject1,formObject,IBSAVE) ;
							doActionIBSheet(sheetObject1,formObject,IBSEARCH);
						}else{
							return;
						}
					}else{
						var nRow = sheetObject2.DataInsert(-1);
						sheetObject2.CellValue2(nRow, "ofc_cd") = formObject.ofc_cd.value;
						sheetObject2.CellValue2(nRow, "prof_seq") = pSeq;
					}
					ComRenumberSeq(sheetObject2, "seq");
				break;

				case "btn_Delete2":
					ComRowHideDelete(sheetObject2, "sel");
					ComRenumberSeq(sheetObject2, "seq");
				break;


				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				break;

				case "btn_New":
					formObject.reset();
					sheetObject1.removeAll();
					sheetObject2.removeAll();
				break;

				case "btn_Save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE) ;
				break;

			    case "btn_CheckSelect":
					// target
					var rd_target = '';
					var rdObj = formObject.rd_target;
					for(rn=0;rn<rdObj.length;rn++){
						if(rdObj[rn].checked) rd_target = rdObj[rn].value;
					}
					// Customer Grid
					var rnarr = ComFindText(sheetObject1, "sel", 1);
					var cstm_arr = new Array(0);
					if(rnarr.length == 0){
						//ComShowMessage(ComGetMsg("BKG00733"));
						//return;
					}else if(rnarr.length == 1){
						cstm_arr.push(sheetObject1.CellValue(rnarr[0], "act_shpr_nm"));
						cstm_arr.push(sheetObject1.CellValue(rnarr[0], "act_shpr_addr"));
						cstm_arr.push(sheetObject1.CellValue(rnarr[0], "ulti_cnee_nm"));
						cstm_arr.push(sheetObject1.CellValue(rnarr[0], "ulti_cnee_addr"));
					}else{
						ComShowMessage(ComGetMsg("BKG00733"));
						return;
					}
					
					// Description for Customs
					var rxarr = ComFindText(sheetObject2, "sel", 1);
					var desc_cstm_arr = new Array(rxarr.length);
					for(rx=0;rx<rxarr.length;rx++){
						var arr = ComGetRowData(sheetObject2, rxarr[rx], "cstms_desc,hamo_trf_cd");
						desc_cstm_arr[rx] = arr;
					}
					
					if(!opener) opener = window.dialogArguments;
					if(callback_func != ''){
						eval('opener.'+callback_func)(rd_target, cstm_arr, desc_cstm_arr);
					}
				//break;

				case "btn_Close":
					window.close();
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
			//initSheet
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		// search init-data
        //doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
        //add listener
		axon_event.addListenerForm('focus', 'form1_focus', document.form);
        axon_event.addListenerForm('blur', 'form1_blur', document.form);
		axon_event.addListenerForm('keypress', 'form1_keypress', document.form);
        axon_event.addListenerForm('change', 'form1_change', document.form);

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
/*

                    // 높이 설정
                    style.height = 200;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge;//msAll;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 2, 20, 100);		// 단위 데이터 행의 맨 아래 Row를 RowHidden 속성으로 구분한다.

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(8, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, false, false, true, false, false)

                    var HeadTitle1 = "ST|Sel.|Seq.|Office|ProfSeq.|Shipper Name|Consignee Name|Reference";
                    var HeadTitle2 = "ST|Sel.|Seq.|Office|ProfSeq.|Address |Address|Reference";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,         WIDTH, DATAALIGN, COLMERGE, SAVENAME,          KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,  cnt++,  dtStatus,  20,    daCenter,  true,     "ibflag");
                    InitDataProperty(0,  cnt++,  dtRadioCheck,    30,    daCenter,  true,     "sel");
                    InitDataProperty(0,  cnt++,  dtSeq,           35,    daCenter,  true,     "seq");
                    InitDataProperty(0,  cnt++,  dtData,        20,    daCenter,  true,    "ofc_cd");
                    InitDataProperty(0,  cnt++,  dtData,        20,    daCenter,  true,    "prof_seq");
                    InitDataProperty(0,  cnt++,  dtData,          250,   daLeft,    false,     "act_shpr_nm",     false,      "",      dfNone,     0,        true,        true,        35);
                    InitDataProperty(0,  cnt++,  dtData,          250,   daLeft,    false,     "ulti_cnee_nm",    false,      "",      dfNone,     0,        true,        true,        35);
                    InitDataProperty(0,  cnt++,  dtData,          80,    daCenter,  true,     "ref_no",          false,      "",      dfNone,     0,        true,        true,        8);

                    cnt = 0;
                    InitDataProperty(1,  cnt++,  dtStatus,  20,    daCenter,  true);
                    InitDataProperty(1,  cnt++,  dtRadioCheck,    30,    daCenter,  true);
                    InitDataProperty(1,  cnt++,  dtSeq,           35,    daCenter,  true);
                    InitDataProperty(1,  cnt++,  dtData,        20,    daCenter,  true);
                    InitDataProperty(1,  cnt++,  dtData,        20,    daCenter,  true);
                    InitDataProperty(1,  cnt++,  dtData,          250,   daLeft,    false,     "act_shpr_addr",    false,      "",      dfNone,    0,        true,        true,        35);
                    InitDataProperty(1,  cnt++,  dtData,          250,   daLeft,    false,     "ulti_cnee_addr",   false,      "",      dfNone,    0,        true,        true,        35);
                    InitDataProperty(1,  cnt++,  dtData,          80,    daCenter,  true);

                    //WordWrap = true;
*/

                    // 높이 설정
                    style.height = 200;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 1, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(10, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle1 = "|Sel.|Seq.|Office|ProfSeq.|Shipper Name|Shipper Address|Consignee Name|Consignee Address|Reference";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,         WIDTH, DATAALIGN, COLMERGE, SAVENAME,          KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,  cnt++,  dtHiddenStatus,  20,    daCenter,  false,    "ibflag");
                    InitDataProperty(0,  cnt++,  dtDummyCheck,    30,    daCenter,  false,     "sel");
                    InitDataProperty(0,  cnt++,  dtSeq,           35,    daCenter,  false,     "seq");
                    InitDataProperty(0,  cnt++,  dtHidden,        20,    daCenter,  false,     "ofc_cd");
                    InitDataProperty(0,  cnt++,  dtHidden,        20,    daCenter,  false,     "prof_seq");
                    InitDataProperty(0,  cnt++,  dtData,          100,   daLeft,    false,     "act_shpr_nm",     false,      "",      dfEngUpKey,     0,        false,        false,  70);
                    InitDataProperty(0,  cnt++,  dtData,          150,   daLeft,    false,     "act_shpr_addr",    false,      "",      dfEngUpKey,    0,        false,        false,  105);
                    InitDataProperty(0,  cnt++,  dtData,          100,   daLeft,    false,     "ulti_cnee_nm",    false,      "",      dfEngUpKey,     0,        false,        false);
                    InitDataProperty(0,  cnt++,  dtData,          150,   daLeft,    false,     "ulti_cnee_addr",   false,      "",      dfEngUpKey,    0,        false,        false);
                    InitDataProperty(0,  cnt++,  dtData,          80,    daCenter,  false,     "ref_no",          false,      "",      dfEngUpKey,     0,        true,        true,  8);

					AutoRowHeight = false;

               }
            break;

            case 2:      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 100;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 1, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(9, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, false, true, false, false);

                    var HeadTitle1 = "|Sel.|Seq.|Office|ProfSeq.|SubSeq.|Description for Customs|HTS Code|HTS Code";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,   DATATYPE,        WIDTH, DATAALIGN, COLMERGE, SAVENAME,      KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,  cnt++,  dtHiddenStatus,  20,    daCenter,  false,    "ibflag");
                    InitDataProperty(0,  cnt++,  dtDummyCheck,    35,    daCenter,  false,    "sel");
                    InitDataProperty(0,  cnt++,  dtData,          35,    daCenter,  false,    "seq",         false,    "",      dfNone,            0,        false,       false);
                    InitDataProperty(0,  cnt++,  dtHidden,        20,    daCenter,  false,    "ofc_cd");
                    InitDataProperty(0,  cnt++,  dtHidden,        40,    daCenter,  false,    "prof_seq");
                    InitDataProperty(0,  cnt++,  dtHidden,        40,    daCenter,  false,    "prof_sub_seq");
                    InitDataProperty(0,  cnt++,  dtData,          490,   daLeft,    false,    "cstms_desc",  false,    "",      dfEngUpKey,            0,        true,        true);
                    InitDataProperty(0,  cnt++,  dtData,          100,   daCenter,  false,    "hamo_trf_cd", false,    "",      dfEngUpKey,            0,        true,        true);
					InitDataProperty(0,  cnt++,  dtPopup,         20,    daCenter,  false,    "HTCPop");

					ShowButtonImage = 2;
					AutoRowHeight = false;
					//
					//InitDataValid(0, "cstms_desc", vtEngUpOnly, "1234567890");
					//InitDataValid(0, "hamo_trf_cd", vtEngUpOnly, "1234567890");

               }
            break;

        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = SEARCH;
					var rXml = sheetObj.GetSearchXml("ESM_BKG_0399GS.do", FormQueryString(formObj));
					if(rXml == '' || rXml.length < 7) return;
					if(rXml.substring(1, 6) == "ERROR"){
						//alert(ComResultMessage(rXml).split('<||>').join('\n'));
						ComShowMessage(ComResultMessage(rXml));
						return;
					}
										
                    var arrXml = rXml.split("|$$|");
                    //alert("xml count : " + arrXml.length);
					if(arrXml.length==2){
						var custTmpltXml  = arrXml[0];
						var cmTmpltXml  = arrXml[1];
						// CM Container Info
						sheetObjects[0].LoadSearchXml(custTmpltXml, false);
						// CM Cntr MF Info
						sheetObjects[1].LoadSearchXml(cmTmpltXml, false);
						// filtering
						if(sheetObjects[0].TotalRows  > 0){
							setCMInfo(1);
						}
					}else{
						//alert("SEARCH xml : " + arrXml.length);
						return;
					}
				}
			break;

			case IBSAVE:        //저장
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = MULTI;
					// form param
					var sParam = FormQueryString(formObj);
					// Sheet1 param
					var sParamSheet1 = sheetObjects[0].GetSaveString();
					if (sParamSheet1 != "") {
						sParam = sParam + "&sheet1_" + sParamSheet1.replace(/&/g, '&sheet1_');
					}
					// Sheet2 param
					var sParamSheet2 = sheetObjects[1].GetSaveString();
					if (sParamSheet2 != "") {
						sParam = sParam + "&sheet2_" + sParamSheet2.replace(/&/g, '&sheet2_');
					}
					// return xML
					var rXml = sheetObj.GetSaveXml("ESM_BKG_0399GS.do", sParam);
					var rMsg = ComResultMessage(rXml);
					if(rMsg == ''){
						/* Transaction 상태 복원 */
						sheetObjects[0].LoadSaveXml("<RESULT><TR-ALL>OK</TR-ALL><MESSAGE/></RESULT>");
						sheetObjects[1].LoadSaveXml("<RESULT><TR-ALL>OK</TR-ALL><MESSAGE/></RESULT>");
						/* 성공메세지 */
						//ComShowMessage(ComGetMsg("BKG00166"));
					} else {
						//alert(rMsg.split('<||>').join('\n'));
						ComShowMessage(rMsg);
					}
				}
			break;

        }
    }



    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        switch(sAction) {
			case IBSEARCH:      //조회
				if(formObj.shpr_nm.value == '' && formObj.cnee_nm.value == ''){
					ComShowMessage(ComGetMsg("BKG00804"));
					return false;
				}
			break;

			case IBSAVE:      //조회
				if(formObj.ofc_cd.value == ''){
					ComShowMessage(ComGetMsg("BKG00806"));
					return false;
				}
				//
				var rcnt = sheetObjects[0].RowCount;
				for (rn = 1; rn <= rcnt; rn++) {
					if(sheetObjects[0].CellValue(rn, "act_shpr_nm") == '' || sheetObjects[0].CellValue(rn, "ulti_cnee_nm") == ''){
						 ComShowMessage(ComGetMsg("BKG00888", "[SHPR_NM or CNEE_NM]"));
						 return false;
					}
				}
				var xcnt = sheetObjects[1].RowCount;
				for (xn = 1; xn <= xcnt; xn++) {
					if(sheetObjects[1].CellValue(xn, "cstms_desc") == ''){
						 ComShowMessage(ComGetMsg("BKG00888", "[CSTMS_DESC]"));
						 return false;
					}
				}
			break;
		}
        return true;
    }

	/* --------------------------------------------------------------------
	 * Event 처리
	 ---------------------------------------------------------------------- */
	function form1_focus(){
		//ComClearSeparator(event.srcElement);
	}

    function form1_blur(){
		//ComChkObjValid(event.srcElement);
    }

	function form1_keypress(){
		if (event.srcElement.type == "text" && event.keyCode == 13 ) {
   			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			//ComKeyEnter("search");
		}
		switch(event.srcElement.dataformat){
			case "ymd":
				ComKeyOnlyNumber(event.srcElement);
				break;
			case "ym":
			case "yw":
			case "jumin":
			case "saupja":	//숫자 + "-"
				ComKeyOnlyNumber(event.srcElement, "-"); 
			break;
			case "hms":
			case "hm":		//숫자 + ":"
				ComKeyOnlyNumber(event.srcElement, ":"); 
			break;
			case "int":		//숫자
				ComKeyOnlyNumber(event.srcElement); 
			break;
			case "float":	//숫자+"."	            
				ComKeyOnlyNumber(event.srcElement, "."); 
			break;	    
			case "engup":
				//영문대문자
				ComKeyOnlyAlphabet("upper");
			break;
			case "engupnum":
				//숫자+"영문대분자"입력하기
				ComKeyOnlyAlphabet("uppernum");
			break;
			case "engupnumspc":
				//영문대문자 + 숫자 + 스페이스
				//ComKeyOnlyAlphabet("uppernum", "32|45|95");
				var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
				if(keyValue >= 97 && keyValue <= 122){                  //소문자
                	event.keyCode = keyValue + 65 - 97;
				}
				//event.returnValue = true;
			break;
		}			
	}
	
    function form1_change(){
		/* 대문자 */
		//if(event.srcElement.type =="text") {
		//	event.srcElement.value = event.srcElement.value.toUpperCase();
		//}
    }

	function sheet1_OnClick(sheetObj, row, col, val) {
		setCMInfo(row);
		
        var col_name = sheetObj.ColSaveName(col);
		if(col_name == "act_shpr_nm") {
			ComShowMemoPad(sheetObj, row, col, false, 200, 100, 70);
		}else 
		if(col_name == "act_shpr_addr") {
			ComShowMemoPad(sheetObj, row, col, false, 200, 100, 105);
		}else 
		if(col_name == "ulti_cnee_nm") {
			ComShowMemoPad(sheetObj, row, col, false, 200, 100, 70);
		}else 
		if(col_name == "ulti_cnee_addr") {
			ComShowMemoPad(sheetObj, row, col, false, 200, 100, 105);
		}
	}
	
	function sheet1_OnChange(sheetObj, row, col, val){

		/* 대문자 */
		var data_type = sheetObj.ReadDataProperty(row, col, 0);
		if(data_type == dtData) {
			sheetObj.CellValue2(row, col) = sheetObj.CellValue(row, col).toUpperCase();
		}

	}
	
	function sheet2_OnPopupClick(sheetObj, row, col){
		var col_name = sheetObj.ColSaveName(col);
		switch(col_name) {

			case "HTCPop":
				//var hts_cd = sheetObj.CellValue(row, "hamo_trf_cd");
				//var url = "ESM_BKG_0607.do?hamo_trf_cd="+hts_cd;
				//ComOpenWindowCenter(url, "ESM_BKG_0607" , 1024, 530, false);
				comBkgCallPop0607("callBackHTSCode", 'T', sheetObj.CellValue(row, "hamo_trf_cd"));
			break;

		} // end switch
	}
	
	function sheet2_OnChange(sheetObj, row, col, val){

		/* 대문자 */
		var data_type = sheetObj.ReadDataProperty(row, col, 0);
		if(data_type == dtData) {
			sheetObj.CellValue2(row, col) = sheetObj.CellValue(row, col).toUpperCase();
		}
		
	}
	
	
	/* --------------------------------------------------------------------
	 * User Defained Functions
	 ---------------------------------------------------------------------- */
	function setCMInfo(row){
		//alert(row + ". BkgNo : " + sheetObjects[0].CellValue(row, "bkg_no"));
		if(row > 0) {
			// retrieve CM
			ComShowAndHideSheet(sheetObjects[1], "prof_seq", sheetObjects[0].CellValue(row, "prof_seq"));
			ComRenumberSeq(sheetObjects[1], "seq");
		}
	}

	function callBackHTSCode(aryPopupData) {
		//alert(aryPopupData);
		sheetObjects[1].CellValue2(sheetObjects[1].SelectRow, "hamo_trf_cd") = aryPopupData[0][3];
	}

	/* 개발자 작업  끝 */
