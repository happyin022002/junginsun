/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : fns_joo_0090.js
*@FileTitle : Add Carriers POP UP화면
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.21
*@LastModifier : Kim, Sanggeun
*@LastVersion : 1.0
* 2012.06.21 Kim, Sanggeun
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
	/**
	 * @extends 
	 * @class fns_joo_0090 : fns_joo_0090 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function fns_joo_0090() {
		this.processButtonClick		= tprocessButtonClick;
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

	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	var sheetObjects = new Array();
	var sheetCnt = 0;
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
		/*******************************************************/
		var formObject = document.form;
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				case "btn_Close":
					self.close();
				break;		 
				case "btn_save": //저장
					doActionIBSheet(sheetObject, formObject, IBSAVE);
				break;
			}
		} catch(e) {
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
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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
					style.height = 240;
					//style.height = 180;

					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 3, 100);

					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);

					var HeadTitle1 = "Sel|Lane|Rep. Carrier|Carrier|20'HC|20'HC|40'HC|40'HC|45'|45'|45'|Round Type|";
					var HeadTitle2 = "Sel|Lane|Rep. Carrier|Carrier|Sub-Alloc|Over Ratio\n(TEU)|Sub-Alloc|Over Ratio\n(TEU)|Sub-Alloc|Under Ratio\n(TEU)|Over Ratio\n(TEU)|Round Type|";

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	true,  "ibflag");
					InitDataProperty(0, cnt++ , dtHidden,		70, daCenter,	true,  "rlane_cd", 			false, "", dfNone, 2,  false,  false);
                    InitDataProperty(0, cnt++,  dtCheckBox, 80, daCenter,   true,   "chk");
					InitDataProperty(0, cnt++ , dtData,		80, daCenter,	true,   "jo_crr_cd", 			false, "", dfNone, 2,  false,  false);
					InitDataProperty(0, cnt++ , dtData,		80,	daRight,	false,  "jo_20ft_sub_teu_qty",  false, "", dfInteger, 2,  true, true, 9);
					InitDataProperty(0, cnt++ , dtData,		80,	daRight,	false,  "jo_20ft_n1st_rto",  	false, "", dfFloat, 2,  true, true, 5);
					InitDataProperty(0, cnt++ , dtData,		80, daRight,	false,  "jo_40ft_sub_teu_qty",  false, "", dfInteger, 2,  true, true, 9);
					InitDataProperty(0, cnt++ , dtData,		80,	daRight,	false,  "jo_40ft_n1st_rto",     false, "", dfFloat, 2,  true, true, 5);
					InitDataProperty(0, cnt++ , dtData,		80, daRight,	false,  "jo_45ft_sub_teu_qty", 	false, "", dfInteger, 2,  true, true, 9);
					InitDataProperty(0, cnt++ , dtData,		80, daRight,	false,  "jo_45ft_n1st_rto", 	false, "", dfFloat, 2,  true, true, 5);
					InitDataProperty(0, cnt++ , dtData,		80, daRight,	false,  "jo_45ft_n2nd_rto", 	false, "", dfFloat, 2,  true, true, 5);
					InitDataProperty(0, cnt++ , dtCombo,	80, daCenter,	true,   "jo_rnd_rule_lvl", 		false, "", dfNone, 2,  true, true);
					InitDataProperty(0, cnt++,  dtHidden, 	80, daCenter,   true,   "jo_rep_crr_flg");
					
					InitDataCombo(0, "jo_rnd_rule_lvl", " |Round|Round Up|Round Down|No", " |1|2|3|4");
				}
			break;
		}
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction, Col, Row) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH:      //조회
				formObj.f_cmd.value = SEARCH01;
				sheetObj.DoSearch("FNS_JOO_0090GS.do", FormQueryString(formObj));
			break;

			case IBSAVE:       //저장
				formObj.f_cmd.value = MULTI;
				
				sheetObj.DoSave("FNS_JOO_0090GS.do", ComGetSaveString(sheetObj) + "&" + FormQueryString(formObj), "ibflag", false);
			break;
		}
	}

	function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		if (ErrMsg == "") {
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			//doActionIBSheet(sheetObj, document.form, IBSEARCH);
			//opener.getFNS_JOO_0090_1();
		}
	}
	
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		if (ErrMsg == "") {
			for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++) {
				if ((sheetObj.cellValue(i, "jo_rep_crr_flg") == "N") || (sheetObj.cellValue(i, "jo_rep_crr_flg") == "")) {
						//sheetObj.CellEditable(i, "chk") = false;
						sheetObj.CellEditable(i, "jo_20ft_sub_teu_qty") = false;
						sheetObj.CellEditable(i, "jo_20ft_n1st_rto") = false;
						sheetObj.CellEditable(i, "jo_40ft_sub_teu_qty") = false;
						sheetObj.CellEditable(i, "jo_40ft_n1st_rto") = false;
						sheetObj.CellEditable(i, "jo_45ft_sub_teu_qty") = false;
						sheetObj.CellEditable(i, "jo_45ft_n1st_rto") = false;
						sheetObj.CellEditable(i, "jo_45ft_n2nd_rto") = false;
						sheetObj.CellEditable(i, "jo_rnd_rule_lvl") = false;
						sheetObj.CellEditable(i, "jo_rnd_rule_lvl") = false;
				} else if (sheetObj.cellValue(i, "jo_rep_crr_flg") == "Y") {
					sheetObj.cellValue(i, "chk") = '1';
				}
			}
		}
     }
	
    /**
     * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function sheet1_OnClick(sheetObj, Row, Col, Value) {
        with (sheetObj) {
            switch (ColSaveName(Col)) {

                case "chk":
					if (Value == "0") {			//[Rep. Carrier]체크박스 체크 - 해당 Row활성화
						sheetObj.CellEditable(Row, "jo_20ft_sub_teu_qty") = true;
						sheetObj.CellEditable(Row, "jo_20ft_n1st_rto") = true;
						sheetObj.CellEditable(Row, "jo_40ft_sub_teu_qty") = true;
						sheetObj.CellEditable(Row, "jo_40ft_n1st_rto") = true;
						sheetObj.CellEditable(Row, "jo_45ft_sub_teu_qty") = true;
						sheetObj.CellEditable(Row, "jo_45ft_n1st_rto") = true;
						sheetObj.CellEditable(Row, "jo_45ft_n2nd_rto") = true;
						sheetObj.CellEditable(Row, "jo_rnd_rule_lvl") = true;
						sheetObj.CellEditable(Row, "jo_rnd_rule_lvl") = true;
						sheetObj.CellEditable(Row, "jo_rep_crr_flg") = true;
						CellValue(Row, "jo_rep_crr_flg") = "Y";
						
					} else if (Value == "1") {	//[Rep. Carrier]체크박스 체크 해제 - 해당 Row비활성화 및 모든 값 초기화 "0"으로 셋팅
						CellValue(Row, "jo_20ft_sub_teu_qty") = 0;
						CellValue(Row, "jo_20ft_n1st_rto") = 0;
						CellValue(Row, "jo_40ft_sub_teu_qty") = 0;
						CellValue(Row, "jo_40ft_n1st_rto") = 0;
						CellValue(Row, "jo_45ft_sub_teu_qty") = 0;
						CellValue(Row, "jo_45ft_n1st_rto") = 0;
						CellValue(Row, "jo_45ft_n2nd_rto") = 0;
						CellValue(Row, "jo_rnd_rule_lvl") = 0;
						CellValue(Row, "jo_rnd_rule_lvl") = " ";
						CellValue(Row, "jo_rep_crr_flg") = "N";
						
						sheetObj.CellEditable(Row, "jo_20ft_sub_teu_qty") = false;
						sheetObj.CellEditable(Row, "jo_20ft_n1st_rto") = false;
						sheetObj.CellEditable(Row, "jo_40ft_sub_teu_qty") = false;
						sheetObj.CellEditable(Row, "jo_40ft_n1st_rto") = false;
						sheetObj.CellEditable(Row, "jo_45ft_sub_teu_qty") = false;
						sheetObj.CellEditable(Row, "jo_45ft_n1st_rto") = false;
						sheetObj.CellEditable(Row, "jo_45ft_n2nd_rto") = false;
						sheetObj.CellEditable(Row, "jo_rnd_rule_lvl") = false;
						sheetObj.CellEditable(Row, "jo_rnd_rule_lvl") = false;
						sheetObj.CellEditable(Row, "jo_rep_crr_flg") = false;
					}
										
                    break;
            }
        }
    }

/* 개발자 작업  끝 */