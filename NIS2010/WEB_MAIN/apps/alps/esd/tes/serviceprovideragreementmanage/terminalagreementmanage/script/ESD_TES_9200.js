/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TES_9200.js
*@FileTitle : Vol. Accumulate Method
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.09.23 yOng hO lEE
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

// 공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;

/** 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/** 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		/*******************************************************/
		var sheetObject = sheetObjects[2];

		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;

				case "btn_new":
					formObject.reset();
					sheetObjects[0].removeAll();
					sheetObjects[1].removeAll();
					sheetObjects[2].removeAll();
					var opener_obj = window.dialogArguments;
					document.form.vndr_seq.value		= opener_obj.document.form.vndr_seq.value;
					document.form.ctrt_ofc_cd.value		= opener_obj.document.form.ctrt_ofc_cd.value;
					document.form.vndr_lgl_eng_nm.value	= opener_obj.document.form.vndr_seq_name.value;
					break;

				case "btns_calendar1":
					var cal = new ComCalendar();	//calendarPopup();
					cal.select(formObject.accm_fm_dt, 'yyyy-MM-dd');
					break;
				case "btns_calendar2":
					var cal = new ComCalendar();	//calendarPopup();
					cal.select(formObject.accm_to_dt, 'yyyy-MM-dd');
					break;
				case "btng_rowadd":
					doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;
				case "btn_delete":
					doActionIBSheet(sheetObject,formObject,IBDELETE);
					break;

				case "btng_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;

				case "btn_ok":
					//ComShowMessage("btn_ok button click");
					window.close();
					break;

				case "btn_close":
					window.close();
					break;
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('TES21025');
			} else {
				ComShowMessage(e);
			}
		}
	}

    /**
     * IBSheet Object를 배열로 등록.<br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다.<br>
     * 배열은 소스 상단에 정의.<br>
     * @param{ibsheet}	sheet_obj	Sheet Object
     */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}

	/**
	 * Sheet 기본 설정 및 초기화.<br>
	 * body 태그의 onLoad 이벤트핸들러 구현.<br>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다.<br>
	 */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet(sheetObjects[i]);	// 시작 환경 설정 함수 이름 변경
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);	// 마지막 환경 설정 함수 추가
		}

		sheetObjects[0].Visible = true;
		sheetObjects[1].Visible = true;

		/// form value initiate
		with ( document.form ){
			/**
            vndr_seq.value 				= "103787"; /// from Opener
            ctrt_ofc_cd.value 		= "TPEBB"; /// Contract Office /// from Opener
            vndr_lgl_eng_nm.value = "Asia Pacific Container Terminal"; /// Contract Office Name  /// from Opener
            accm_fm_dt.value 			= "2006-09-14"; ///  /// from Opener
            accm_to_dt.value 			= "2006-09-15"; /// /// from Opener
			 **/
			var opener_obj = window.dialogArguments;
			vndr_seq.value		= opener_obj.document.form.vndr_seq.value;
			ctrt_ofc_cd.value	= opener_obj.document.form.ctrt_ofc_cd.value;
			vndr_lgl_eng_nm.value	= opener_obj.document.form.vndr_seq_name.value;
		}

		doActionIBSheet(sheetObjects[2], document.form, IBSEARCH);
		var yd_cd = window.dialogArguments.document.form.yd_cd.value;
		var yd_cd_name = window.dialogArguments.document.form.yd_cd_name.value;
		var exist_gb = "";

		for(i=0;i<sheetObjects[2].RowCount;i++){
			if(sheetObjects[2].CellValue(i+1,"3yd_cd") == yd_cd){
				exist_gb  = "Y";
			}
		}

		if(exist_gb!="Y"){
			var Row = sheetObjects[2].DataInsert(-1);
			sheetObjects[2].CellValue(Row, "3yd_cd") = yd_cd;
			sheetObjects[2].CellValue(Row, "3yd_nm") = yd_cd_name;
		}
	}

    /**
     * 시트 초기설정값, 헤더 정의.<br>
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호.<br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다.<br>
     * @param{ibsheet}		sheetObj	Sheet Object
     * @param{int,String}	sheetNo		Sheet No
     */
    function initSheet(sheetObj,sheetNo) {
        var isSheetNoPrefix = true; /// prefix 여부
        var prefix = ""; /// prefix 문자
        var cnt = 0;

        switch(sheetNo) {

             case 1:      //sheet1 init
                with (sheetObj) {

                    /// prefix 설정
                    if ( isSheetNoPrefix ) { prefix = sheetNo.toString(); }

                    // 높이 설정
                    style.height = getSheetHeight(8);

                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(7, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);

                    var HeadTitle = "Del.|STS|Seq.|Yard|Yard Name";
                    //vndr_seq|accm_seq|accm_dtl_seq|yd_cd|cre_usr_id|cre_dt|upd_usr_id|upd_dt

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					//InitDataProperty(0, cnt++ , dtDelCheck,		 30,		daCenter,			false,	"",				false,			""	);
					InitDataProperty(0, cnt++ , dtStatus,100,		daCenter,			false,	prefix+"ibflag",				false,			""	);
					InitDataProperty(0, cnt++ , dtData,	 100,		daCenter,			false,	prefix+"vndr_seq",				false,			"",			dfNone,			0,			false,			true,   3);
					InitDataProperty(0, cnt++ , dtData,	 100,		daCenter,			false,	prefix+"accm_seq",				false,			"",			dfNone,			0,			false,			true	);
					InitDataProperty(0, cnt++ , dtData,	 100,		daCenter,			false,	prefix+"ctrt_ofc_cd",				false,			"",			dfNone,			0,			false,			true	);
					InitDataProperty(0, cnt++ , dtData,	 100,		daCenter,			false,	prefix+"accm_fm_dt",				false,			"",			dfNone,			0,			false,			true	);
					InitDataProperty(0, cnt++ , dtData,	 100,		daCenter,			false,	prefix+"accm_to_dt",				false,			"",			dfNone,			0,			false,			true	);
					InitDataProperty(0, cnt++ , dtData,	 100,		daCenter,			false,	prefix+"tml_accm_ut_cd",				false,			"",			dfNone,			0,			false,			true	);

               }
                break;


             case 2:      //sheet2 init
                with (sheetObj) {
                    /// prefix 설정
                    /// prefix 설정
                    if ( isSheetNoPrefix ) { prefix = sheetNo.toString(); }

                    // 높이 설정
                    style.height = getSheetHeight(8);

                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(5, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);

                    var HeadTitle = "ibflag.|STS|vndr_seq|accm_cost_seq|lgs_cost_cd";
                    //vndr_seq|accm_seq|accm_dtl_seq|yd_cd|cre_usr_id|cre_dt|upd_usr_id|upd_dt

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    //InitDataProperty(0, cnt++, dtDelCheck,   30,    daCenter,  true,    "");
					InitDataProperty(0, cnt++ , dtStatus,100,		daCenter,			false,	prefix+"ibflag",				false,			""	);
					InitDataProperty(0, cnt++ , dtData,	 100,		daCenter,			false,	prefix+"vndr_seq",				false,			"",			dfNone,			0,			false,			true,   3);
					InitDataProperty(0, cnt++ , dtData,	 100,		daCenter,			false,	prefix+"accm_seq",				false,			"",			dfNone,			0,			false,			true	);
					InitDataProperty(0, cnt++ , dtData,	 100,		daCenter,			false,	prefix+"accm_cost_seq",			false,			"",			dfNone,			0,			false,			true	);
					InitDataProperty(0, cnt++ , dtData,	 100,		daCenter,			false,	prefix+"lgs_cost_cd",			false,			"",			dfNone,			0,			false,			true	);
               }
                break;

             case 3:      //sheet3 init
            	 with (sheetObj) {
            		 /// prefix 설정
            		 if ( isSheetNoPrefix ) { prefix = sheetNo.toString(); }

                    // 높이 설정
                    style.height = getSheetHeight(8);

                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(5, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);

                    var HeadTitle = "Del.|STS|Seq.|Yard|Yard Name";
                    //vndr_seq|accm_seq|accm_dtl_seq|yd_cd|cre_usr_id|cre_dt|upd_usr_id|upd_dt

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtDelCheck,		 30,		daCenter,			false,	prefix+"delflag",				false,			""	);
					InitDataProperty(0, cnt++ , dtStatus,	 30,		daCenter,			false,	prefix+"ibflag",				false,			""	);
					InitDataProperty(0, cnt++ , dtData,	 30,		daCenter,			false,	prefix+"accm_dtl_seq",				false,			""    ,			dfNone,			0,			false,			false,   3);
					InitDataProperty(0, cnt++ , dtData,	 100,		daCenter,			false,	prefix+"yd_cd",				false,			"",			dfNone,			0,			false,			true,	7);
					InitDataProperty(0, cnt++ , dtData,	 150,		daCenter,			false,	prefix+"yd_nm",				false,			"",			dfNone,			0,			false,			false,	25);

					InitDataValid(0, 3, vtEngUpOther,'0123456789');
					CountFormat = "[SELECTDATAROW / ROWCOUNT]";
               }
                break;
        }
    }



	/**
	 * Sheet관련 프로세스 처리. <br>
	 * @param {ibsheet}  	sheetObj	Sheet Object
	 * @param {String}  	formObj		Form Object
	 * @param {String}  	sAction		Action Command
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false; /// 작업 후 false로 변경

		switch(sAction) {

			case IBSEARCH:      //조회

				formObj.f_cmd.value = SEARCH;
				var sXml = sheetObj.GetSearchXml("ESD_TES_9200GS.do", tesFrmQryStr(formObj)); //ComShowMessage(sXml);
				sheetObj.LoadSearchXml(sXml);
				var sxml0 = sheetObj.EtcData("sxml0"); // ComShowMessage(sxml0);
				var sxml1 = sheetObj.EtcData("sxml1"); // ComShowMessage(sxml1);
				var sxml2 = sheetObj.EtcData("sxml2"); // ComShowMessage(sxml2);
				sheetObj.RemoveEtcData();

				sheetObjects[0].LoadSearchXml(sxml0);
				sheetObjects[1].LoadSearchXml(sxml1);
				sheetObjects[2].LoadSearchXml(sxml2);

				sXml=null; sxml0=null; sxml1=null; sxml2=null;
				break;

			case IBSAVE:      //저장
				if (ComIsNull(formObj.ctrt_ofc_cd.value)){
					ComShowCodeMessage('TES10023');
					formObj.ctrt_ofc_cd.focus();
					return false;
				}

				if (ComIsNull(formObj.vndr_lgl_eng_nm.value)){
					ComShowCodeMessage('TES10022');
					formObj.vndr_lgl_eng_nm.focus();
					return false;
				}

				if (ComIsNull(formObj.accm_fm_dt.value)){
					ComShowCodeMessage('TES10122');
					formObj.accm_fm_dt.focus();
					return false;
				}

				if (ComIsNull(formObj.accm_to_dt.value)){
					ComShowCodeMessage('TES10122');
					formObj.accm_to_dt.focus();
					return false;
				}
				var element;
				var checkCount =0;
				var numOfEle = formObj.elements.length;
				var eleTp  = "checkbox";

				for (var i = 0; i < numOfEle; i++){
					if (formObj.elements[i].type == eleTp){
						if (formObj.elements[i].checked == true){
							checkCount++;
						}
					}
				}
				
				if(checkCount==0){
					ComShowCodeMessage('TES10123'); //Cost Code For Volume Accumulate를 체크하세요.
					return false;
				}

				formObj.f_cmd.value = MULTI;
				doActionSaveAll(sheetObj, formObj, sAction);
				break;

			case IBINSERT:      // 입력
				var sRow = sheetObj.DataInsert(-1);
				break;

			case IBDELETE:      // 삭제
				formObj.f_cmd.value = REMOVE;
				var sXml = sheetObjects[0].GetSaveXml("ESD_TES_9200GS.do", tesFrmQryStr(formObj));
				sheetObj.LoadSaveXml(sXml,true);
				var sxml0 = sheetObj.EtcData("sxml0"); // ComShowMessage(sxml0);
				var sxml1 = sheetObj.EtcData("sxml1"); // ComShowMessage(sxml1);
				var sxml2 = sheetObj.EtcData("sxml2"); // ComShowMessage(sxml2);
				sheetObj.RemoveEtcData();
				sheetObjects[0].LoadSearchXml(sxml0);
				sheetObjects[1].LoadSearchXml(sxml1);
				sheetObjects[2].LoadSearchXml(sxml2);

				sXml=null; sxml0=null; sxml1=null; sxml2=null;
				break;
		}
	}


	/**
	 * Sheet 관련 프로세스 처리. <br>
	 * @param {ibsheet}  	sheetObj	Sheet Object
	 * @param {String}  	formObj		Form Object
	 * @param {String}  	sAction		Action Command
	 */
	function doActionSaveAll(sheetObj, formObj, sAction) {
		var temp;
		var headerInfoArr;
		var dataArr;
		var prefix = "";

		/// sheetObjects[0] --------------
		headerInfoArr = "STS|vndr_seq|accm_seq|ctrt_ofc_cd|accm_fm_dt|accm_to_dt|tml_accm_ut_cd".split("|");
		dataArr = new Array(headerInfoArr.length);
		prefix = "1";

		dataArr[1] = formObj.vndr_seq.value.trim();
		dataArr[2] = "1";
		dataArr[3] = formObj.ctrt_ofc_cd.value;
		dataArr[4] = ComReplaceStr(formObj.accm_fm_dt.value,'-','');
		dataArr[5] = ComReplaceStr(formObj.accm_to_dt.value,'-','');
		dataArr[6] = ComGetObjValue(formObj.tml_accm_ut_cd);

		if ( dataArr[1].length <= 0 ) { ComShowCodeMessage('COM12114','Vendor Information'); return; } // 를(을) 확인하세요.
		if ( dataArr[3].length <= 4 ) { ComShowCodeMessage('COM12114','Contract Office'); return; }
//        if ( !isDate(dataArr[4]) ) { ComShowCodeMessage('COM12114','Period Start'); return; }
//        if ( !isDate(dataArr[5]) ) { ComShowCodeMessage('COM12114','Period End'); return; }
		if ( dataArr[6].length != 1 ) { ComShowCodeMessage('COM12114','UOM'); return; }

		if ( sheetObjects[0].TotalRows <= 0 ){
			sheetObjects[0].DataInsert(-1);
			sheetObjects[0].CellValue(1, prefix+"vndr_seq") = dataArr[1];
			sheetObjects[0].CellValue(1, prefix+"accm_seq") = dataArr[2];
		}

		sheetObjects[0].CellValue(1, prefix+"ctrt_ofc_cd")	= dataArr[3];
		sheetObjects[0].CellValue(1, prefix+"accm_fm_dt")	= dataArr[4];
		sheetObjects[0].CellValue(1, prefix+"accm_to_dt")	= dataArr[5];
		sheetObjects[0].CellValue(1, prefix+"tml_accm_ut_cd") = dataArr[6];

		/// sheetObjects[1] --------------
		prefix = "2";
		var baseInfoArr = "SVLDFL|SVLDMT|SVLDTS|TPNDFL|TPNDMT|TPNDTS|SVRHCC|SVRHCD|SVLDBB|TMNDFL|TMNDMT|TMNDTS|SVLDTM|TPNDTM".split("|");
		dataArr = new Array(baseInfoArr.length); /// checkbox => sheet grid

		for (var i=0; i<dataArr.length; i++ ){
			eval( "dataArr[i] = formObj."+baseInfoArr[i]+".checked;" );
		}

		var nowRowNum=0;
		sheetObjects[1].RemoveAll();
		for (var i=0; i<dataArr.length; i++ ){
			if ( !dataArr[i] ) { continue; }
			sheetObjects[1].DataInsert(-1);
			nowRowNum++;
			sheetObjects[1].CellValue(nowRowNum, prefix+"vndr_seq") = formObj.vndr_seq.value.trim();
			sheetObjects[1].CellValue(nowRowNum, prefix+"accm_seq") = "1";
			//sheetObjects[1].CellValue(nowRowNum, prefix+"accm_cost_seq") = i+1;
			sheetObjects[1].CellValue(nowRowNum, prefix+"lgs_cost_cd") = baseInfoArr[i];
		}

		/// sheetObjects[2] --------------
		prefix = "3";
		for (var i=1; i<=sheetObjects[2].RowCount; i++ ){
			if ( sheetObjects[2].CellValue(i, prefix+"ibflag") != "I"
				&& sheetObjects[2].CellValue(i, prefix+"ibflag") != "U" ) {
				continue;
			}
			temp = sheetObjects[2].CellValue(i, prefix+"yd_cd") ;
			temp = temp.trim();
			if ( temp==null || temp.length==0 ) {
				ComShowCodeMessage('COM12114','Yard Code');
				//mySheet.SelectCell(Row, Col, [EditMode], [EditModeText])
				sheetObjects[2].SelectCell(i, prefix+"yd_cd", true, "");
				return;
			}
		}

		//======================
		//  다중 그리드에 저장할 내용을 String Array 로 받습니다
		var params = new Array();
		params[0] = sheetObjects[0].GetSaveString(false ,false);
		params[1] = sheetObjects[1].GetSaveString(false ,false);
		params[2] = sheetObjects[2].GetSaveString(false ,false);
		params[3] = tesFrmQryStr(formObj);

        // 트랜잭션이 일어나는 여부를 체크합니다 ( 필요시 체크 안해도 됩니다)
		//  저장합니다
		var savexml = sheetObjects[0].GetSaveXml("ESD_TES_9200GS.do", ComGetAryJoin(params, "&"));
		// 저장 후 에러여부의 값을 받아 옵니다.  LoadSaveXml 을 하셔야지 OnSaveEnd 이벤트가 발생합니다
		sheetObj.LoadSaveXml(savexml,true);
		var sxml0 = sheetObj.EtcData("sxml0"); // ComShowMessage(sxml0);
		var sxml1 = sheetObj.EtcData("sxml1"); // ComShowMessage(sxml1);
		var sxml2 = sheetObj.EtcData("sxml2"); // ComShowMessage(sxml2);
		sheetObj.RemoveEtcData();
		sheetObjects[0].LoadSearchXml(sxml0);
		sheetObjects[1].LoadSearchXml(sxml1);
		sheetObjects[2].LoadSearchXml(sxml2);
	}

    ///===== event function ====================================
	/**
	 * sheet1 Sheet 조회후 관련 프로세스 처리. <br>
	 * @param {ibsheet}  	sheetObj	IBSheet Object
	 * @param {String}  	ErrMsg		Error Message
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){ /// sheet --> form
		if ( ErrMsg.length <= 0 ){
			var formObj = document.form;
			if ( sheetObjects[0].TotalRows == 1 ) {
				var headerInfoArr;
				var prefix = "1";

				/// sheetObjects[0] --------------
				headerInfoArr = "STS|vndr_seq|accm_seq|ctrt_ofc_cd|accm_fm_dt|accm_to_dt|tml_accm_ut_cd".split("|");
				prefix = "1";
				formObj.ctrt_ofc_cd.value	= sheetObjects[0].CellValue(1, prefix + "ctrt_ofc_cd");
				formObj.accm_fm_dt.value	= sheetObjects[0].CellValue(1, prefix + "accm_fm_dt");
				ComAddSeparator(formObj.accm_fm_dt, "ymd");
				formObj.accm_to_dt.value	= sheetObjects[0].CellValue(1, prefix + "accm_to_dt");
				ComAddSeparator(formObj.accm_to_dt, "ymd");
				if ( sheetObjects[0].CellValue(1, prefix + "tml_accm_ut_cd") == "T" ){
					formObj.tml_accm_ut_cd[0].checked = true;
				} else {
					formObj.tml_accm_ut_cd[1].checked = true;
				}
			} else {
				formObj.accm_fm_dt.value = '';
				formObj.accm_to_dt.value = '';
				formObj.tml_accm_ut_cd[0].checked = true;
			}
		}
	}

	/**
	 * sheet2 Sheet 조회후 관련 프로세스 처리. <br>
	 * @param {ibsheet}  	sheetObj	IBSheet Object
	 * @param {String}  	ErrMsg		Error Object
	 */
	function sheet2_OnSearchEnd(sheetObj, ErrMsg){ /// sheet --> form
		if ( ErrMsg.length <= 0 ){
			var formObj = document.form;
			var headerInfoArr;
			var dataArr;
			var prefix = "2";
			var temp ;

			/// sheetObjects[1] --------------
			//headerInfoArr = "STS|vndr_seq|accm_seq|accm_cost_seq|lgs_cost_cd".split("|");
			var baseInfoArr = "SVLDFL|SVLDMT|SVLDTS|TPNDFL|TPNDMT|TPNDTS|SVRHCC|SVRHCD|SVLDBB|TMNDFL|TMNDMT|TMNDTS|SVLDTM|TPNDTM".split("|");
			dataArr = new Array(baseInfoArr.length); /// checkbox => sheet grid

			//Delete Buttons 추가로 수정 2007.5.28
			for(var i=0; i<baseInfoArr.length; i++){
				if(sheetObj.FindText(prefix+'lgs_cost_cd', baseInfoArr[i]) ==  -1){
					eval( "formObj."+baseInfoArr[i]+".checked = false;" );
				}else{
					eval( "formObj."+baseInfoArr[i]+".checked = true;" );
				}
			}
            //수정 전 원본.. 문제 생기면 원복할것..
            //vvd_hidden.FindText('vvd', vvd)
            //            for ( var i=1; i<=sheetObjects[1].TotalRows; i++ ) {
            //                temp = sheetObjects[1].CellValue(i, prefix+"lgs_cost_cd");
            //                eval( "formObj."+temp+".checked = true;" );
            //            }
		}
	}

	/**
	 * sheet1 Sheet 저장후 관련 프로세스 처리. <br>
	 * @param {ibsheet}  	sheetObj	IBSheet Object
	 * @param {String}  	ErrMsg		Error Object
	 */
	function sheet1_OnSaveEnd(sheetObj, ErrMsg){
		if ( ErrMsg!=null || ErrMsg.length == 0 ){
			//loadPage();
		} else {
			ComShowMessage(ErrMsg);
		}
	}

	/**
     * Yard Code 유효성 검증. <br>
     **/
	function validateYardCode() {
		var formObj = document.form;
		if (formObj.yd_cd.value==null || formObj.yd_cd.value.trim() == '')
		{
			formObj.yd_cd_hidden.value = '';
			formObj.is_valid_yd_cd.value = '';
			return false;
		}

		if ((formObj.yd_cd_hidden.value==null || formObj.yd_cd_hidden.value.trim()=='') || formObj.yd_cd.value.trim()!=formObj.yd_cd_hidden.value.trim())
		{
			formObj.yd_cd_hidden.value = '';
			formObj.is_valid_yd_cd.value = '';
			tes_getInputValue('is_valid_yd_cd', SEARCH05, 'yd_cd', 'checkValidYardCode');
		}
	}

	/**
     * Yard Code  Validate Check. <br>
     **/
	function checkValidYardCode(){
		var formObj = document.form;
		var tmp = '';
		if (formObj.is_valid_yd_cd.value!=undefined && formObj.is_valid_yd_cd.value!=null && formObj.is_valid_yd_cd.value.trim()!=''){
			tmp = formObj.is_valid_yd_cd.value.split('|');
			if (tmp.length > 0){
				formObj.is_valid_yd_cd.value = (tmp[0]!=undefined&&tmp[0]!=null?tmp[0]:'');
				if (formObj.is_valid_yd_cd.value!=null && formObj.is_valid_yd_cd.value == 'Y'){
					//formObj.yd_cd_name.value = (tmp[2]!=undefined&&tmp[2]!=null?tmp[2]:'');
					formObj.yd_cd_hidden.value = formObj.yd_cd.value;
					sheetObjects[2].CellValue(document.form.row_num.value,4)=(tmp[2]!=undefined&&tmp[2]!=null?tmp[2]:'');
				} else {
					formObj.is_valid_yd_cd.value = '';
					formObj.yd_cd_hidden.value = '';
					formObj.yd_cd_name.value = '';
					sheetObjects[2].CellValue(document.form.row_num.value,3)="";
					ComShowCodeMessage('TES10066');
				}
			} else {
				formObj.is_valid_yd_cd.value = '';
				formObj.yd_cd_hidden.value = '';
				formObj.yd_cd_name.value = '';
				sheetObjects[2].CellValue(document.form.row_num.value,3)="";
				ComShowCodeMessage('TES10066');
			}
		} else {
			formObj.is_valid_yd_cd.value = '';
			formObj.yd_cd_hidden.value = '';
			formObj.yd_cd_name.value = '';
			sheetObjects[2].CellValue(document.form.row_num.value,3)="";
			ComShowCodeMessage('TES10066');
		}
	}

	/**
	 * sheet3 Sheet 변경후 관련 프로세스 처리. <br>
	 * @param {ibsheet}  	Sheet	IBSheet Object
	 * @param {int,String}	Row		Sheet Row Index/Save Name
	 * @param {int,String}	Col		Sheet Column Index/Save Name
	 * @param {String}  	Value	Value
	 */
	function sheet3_OnChange(Sheet, Row, Col, Value ){
		if(Col == 3 && Value != "" ){
			document.form.yd_cd.value	= Value;
			document.form.row_num.value	= Row;
			validateYardCode();
		}
	}

	/**
	 * Input Check. <br>
	 * @param {Object}  	obj		Check Object
	 */
	function chkInput(obj) {
		if (obj.maxLength < getStrLen(obj.value))
		{
			obj.value = '';//substring(obj.value,0,obj.maxLength);
			obj.focus();
			return false;
		}
	}

	/**
     * 숫자만.. <br>
     * @param {Object}	obj    Text Object
     **/
	function isNum1(obj){
		//숫자만..
		if (!ComIsNumber(obj,'-')){
			obj.value = '';
		}
	}