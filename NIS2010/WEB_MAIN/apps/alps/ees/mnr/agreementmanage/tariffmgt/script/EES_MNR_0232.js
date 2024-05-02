/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0232.jsp
*@FileTitle : Disposal Tariff Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.27
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.09.27 장준우
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
     * @class EES_MNR_0232 : EES_MNR_0232 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_MNR_0232() {
    	this.processButtonClick	 = processButtonClick;
    	this.setSheetObject 	 = setSheetObject;
    	this.loadPage 			 = loadPage;
    	this.initSheet 			 = initSheet;

    	this.obj_blur 			 = obj_blur;
    	this.obj_focus 			 = obj_focus;
    	this.obj_change 		 = obj_change;
    	this.obj_keypress 		 = obj_keypress;
    	this.obj_keyup 			 = obj_keyup;
    	this.obj_keydown 		 = obj_keydown;

    	this.doActionIBSheet 	 = doActionIBSheet;

    	this.openPopup 		     = openPopup;
    	this.setPopData_Currency = setPopData_Currency;
    	this.validateForm 		 = validateForm;
    	this.clearForm 			 = clearForm;

    }

   	/* 개발자 작업	*/

   	/* Sheet Select Back Color */
	var MNR_SELECT_BACK_COLOR = 10092543;
	var MNR_TOTCOL_BACK_COLOR = 15723503;

	var cntrTpSz = new Array();
	var chssTpSz = new Array();
	var gsetTpSz = new Array();

	var vCntrTpszHdr = "| | | | | | | | | | | | | | | | | | | | | | | | | | | | | |";
	var vArrCntrTpsz = vCntrTpszHdr.split("|");
	var vCntrTpszCnt = vArrCntrTpsz.length;

	// 공통전역변수
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;

	var sheetObjects = new Array();
	var sheetCnt = 0;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        var sheetObject3 = sheetObjects[2];
        var sheetObject4 = sheetObjects[3];
        var sheetObject5 = sheetObjects[4];
        var tabObj = tabObjects[0];
        /*******************************************************/
        var formObj = document.form;

     	try {
 			var srcName = window.event.srcElement.getAttribute("name");

 			switch(srcName) {
 				case "btn_Retrieve":
 					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
 					break;

 				case "btn_New":
					ComResetAll();
					setDynamicEqTpszHeader(sheetObjects[0], "U");
					formObj.p_loc_cd.readOnly = true;
					formObj.p_loc_cd.className = "input2";
					ComEnableObject(formObj.btns_search, false);
					for(i = 0; i < sheetObjects.length; i++) {
						sheetObjects[i].CellText(0, "rcc_cd") = "RCC";
					}

					for(var i = 0; i < tabObj.GetCount(); i++) {
						tabObj.TabEnable(i) = true;
					}
					tabObj.SelectedIndex = 0;
					ComSetFocus(formObj.p_trf_eff_yr);
 					break;

 				case "btns_calendar1":
 					var cal = new ComCalendar();
					cal.setDisplayType('year');
					cal.select(formObj.p_trf_eff_yr, 'yyyy');
             	 	break;

             	case "btns_search":	//Form Location. 조회 팝업
 					openPopup("1");
 					break;

             	case "btn_DownExcel1":
             	case "btn_DownExcel2":
             	case "btn_DownExcel3":
             	case "btn_DownExcel4":
             		sheetObject5.SpeedDown2Excel(-1, false,false);
					break;

 			} // end switch
     	} catch(e) {
     		if(e == "[object Error]") {
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
    function setSheetObject(sheet_obj) {
       sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	var formObj = document.form;

		for(i = 0; i < sheetObjects.length; i++) {
	        //khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );

			initSheet(sheetObjects[i], i+1);
	        //khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}

		/* IBTab 초기화 */
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
		}
    }

    /**
	 * loadPage 메서드에서 초기 조회하는 메서드를 분리한다.
	 */
	function t1sheet1_OnLoadFinish(sheetObj) {
		var formObj = document.form;

     	/* IBMulti Combo Item Setting */
    	doActionIBSheet(sheetObjects[0], document.form, IBCREATE);

    	/* Axon Control Setting*/
    	initControl();

    	/* 초기 Focus Setting */
    	ComSetFocus(formObj.p_trf_eff_yr);
    	ComEnableObject(formObj.btns_search, false);
    	for(i = 0; i < sheetObjects.length; i++) {
    		sheetObjects[i].CellText(0, "rcc_cd") = "RCC";
    	}
    }

    // Axon 이벤트 처리
  	// 1. 이벤트catch
  	function initControl() {
  		var formObj = document.form;
  		axon_event.addListenerFormat('blur',		'obj_blur',		formObj); //- 포커스 나갈때
		axon_event.addListenerFormat('focus',		'obj_focus',	formObj); //- 포커스 들어갈때
  		axon_event.addListenerFormat('keypress',	'obj_keypress',	formObj); //- 키 눌렸을때
		axon_event.addListenerFormat('keyup',		'obj_keyup',	formObj); //- 키 올라올때
		axon_event.addListenerForm('keydown',		'obj_keydown',	formObj); //- 키 눌렸을때
		axon_event.addListenerForm('change',   		'obj_change',  	formObj); //- 변경될때.
  	}

	//이벤트 중복방지 변수
	var preEventType = null;

  	// 2. 이벤트처리함수 -- Start
  	/**
	 * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
	 **/
	function obj_blur() {
		var obj = event.srcElement;

		if(preEventType == event.type) {
			preEventType = null;
			return;
		}

	    switch(obj.name) {
	    	case "p_trf_eff_yr":
  				//Validation 전체 체크(길이,format,최대,최소 등등)
	            ComChkObjValid(obj, true, false, false);
	    		break;
	        default: //do nothing
	        	ComChkObjValid(obj);
	        	break;
	    }
	}

	/**
	 * HTML Control의 포커스 들어가는 이벤트에서 마스크 구분자를 제거한다.
	 */
	function obj_focus() {
		var obj = event.srcElement;

	    if(obj.readOnly) {
	    	ComSetNextFocus(obj);
	    } else {
	    	//마스크구분자 없애기
		    ComClearSeparator(obj);
	    }
	}

	/**
	 * Change Event 처리
	 */
	function obj_change() {
		var obj = event.srcElement;
		var formObj  = document.form;
		var sheetObj = sheetObjects[0];
		var tabObj = tabObjects[0];

		switch(obj.name) {
			case "p_trf_eff_qtr_no":	//Effective Quarter
				for(var i = 0; i < tabObj.GetCount(); i++) {
					if(obj.value == "") {
						tabObj.TabEnable(i) = true;
					} else {
						tabObj.TabEnable(i) = (obj.value == i +1);
					}
				}

				if(obj.value == "") {
					tabObj.SelectedIndex = 0;
				} else {
					tabObj.SelectedIndex = obj.value -1;
				}
				break;
			case "p_eq_knd_cd":			//Equipment Type
				for(i = 0; i < sheetObjects.length; i++) {
					sheetObjects[i].RemoveAll();
				}
				setDynamicEqTpszHeader(sheetObjects[0], obj.value);
				break;
			case "p_loc_tp":			//Location Type
				formObj.p_loc_cd.value = "";
				if(obj.value == "0") {
					formObj.p_loc_cd.readOnly = true;
					formObj.p_loc_cd.className = "input2";
					ComEnableObject(formObj.btns_search, false);
					for(i = 0; i < sheetObjects.length; i++) {
						sheetObjects[i].CellText(0, "rcc_cd") = "RCC";
					}
				} else {
					formObj.p_loc_cd.readOnly = false;
					formObj.p_loc_cd.className = "input";
					ComEnableObject(formObj.btns_search, true);
					ComSetNextFocus(obj);

					for(i = 0; i < sheetObjects.length; i++) {
						if(obj.value == "1") {
							sheetObjects[i].CellText(0, "rcc_cd") = "LCC";
						} else if(obj.value == "2") {
							sheetObjects[i].CellText(0, "rcc_cd") = "SCC";
						}
					}
				}
				break;
			case "p_loc_cd":		//Location Code
  				if ( ComTrim(obj.value) != "" ) {
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC01);
  				}
				break;
		}
	}

	/**
	 * Key-Press Event 처리
	 */
  	function obj_keypress() {
  		var obj = event.srcElement;

		switch(obj.dataformat) {
	        case "ymd":
	        case "ym":
	        case "hms":
	        case "hm":
	        case "jumin":
	        case "saupja":
	        case "int":
	            ComKeyOnlyNumber(obj);
	            break;
	        case "float":
	            ComKeyOnlyNumber(obj, "-.");
	            break;
	        case "eng":
	            ComKeyOnlyAlphabet();
	            break;
	        case "engup":
	            ComKeyOnlyAlphabet('upper');
	            break;
	        case "engdn":
	            ComKeyOnlyAlphabet('lower');
	            break;
	        default:
	            ComKeyOnlyNumber(obj);
	        	break;
	    }
  	}

  	/**
  	 * Key-Up Event 처리
  	 */
  	function obj_keyup() {
  		var obj     = event.srcElement;
  		var formObj = document.form;

  		switch(obj.name) {
  			case "p_trf_eff_yr":
  				ComKeyEnter('LengthNextFocus');
  				break;
  			case "p_loc_cd":
  				ComKeyEnter('LengthNextFocus');
  				break;
  			default :
			  	ComKeyEnter('LengthNextFocus');
  		}
  	}

   	/**
     * Key-Down Event 처리
     */
   	function obj_keydown() {
   		var obj      = event.srcElement;
   		var vKeyCode = event.keyCode;
   		var formObj  = document.form;

   		if(vKeyCode == 13) {
   			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
   		}
   	}
  	//2. 이벤트처리함수 -- End

	/**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;

    }

    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
	                var cnt  = 0 ;
	                InsertTab( cnt++ , "1/4 Quarter" , -1 );
	                InsertTab( cnt++ , "2/4 Quarter" , -1 );
	                InsertTab( cnt++ , "3/4 Quarter" , -1 );
	                InsertTab( cnt++ , "4/4 Quarter" , -1 );
                }
             break;

         }
    }

    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem) {

        var objs = document.all.item("tabLayer");

    	objs[nItem].style.display = "Inline";
    	objs[beforetab].style.display = "none";

    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1;
    	//------------------------------------------------------//
    	beforetab= nItem;
    }

  	/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo) {
    	var formObj = document.form;
		var sheetid = sheetObj.id;
		var cnt = 0;

		switch(sheetid) {
			case "t1sheet1":
			case "t2sheet1":
			case "t3sheet1":
			case "t4sheet1":
			case "t5sheet1":
				with(sheetObj) {
					// 높이 설정
					style.height = 410;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					//SheetWidth = 984;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msPrevColumnMerge;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);

					var HeadTitle = "||Quarter|||RCC|LOC|Currency"+ vCntrTpszHdr;
					var headCount = ComCountHeadTitle(HeadTitle);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 8, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, false, false, true, false,false)

					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					var vDataType = sheetid == "t5sheet1" ? dtData : dtHidden;
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,	"trf_eff_yr",		false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,	"trf_eff_qtr_no",	false,	"",	dfNone);
					InitDataProperty(0, cnt++ , vDataType,		50,		daCenter,	true,	"trf_eff_qtr_nm",	false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,	"eq_knd_cd",		false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,	"eq_knd_nm",		false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"rcc_cd",			false,	"",	dfEngUpKey);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"loc_cd",			false,	"",	dfEngUpKey);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"curr_cd",			false,	"",	dfEngUpKey);

					for(var i = 1; i < vCntrTpszCnt; i++) {
						var tpsz_dp_no = "tpsz_dp"+ ComLpad(i, 2, "0");
						InitDataProperty(0, cnt++ , dtData,		90,  	daRight,	false,	tpsz_dp_no,			false,	"",	dfFloat, 2);

                    	if(vArrCntrTpsz[i] != "") {
							eval('ColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '") = false;');
						} else {
							eval('ColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '") = true;');
						}
					}
					SelectBackColor = MNR_SELECT_BACK_COLOR;
 					CountFormat = "[SELECTDATAROW / TOTALROWS]";
 					CountPosition = 0;
				}
				break;
		}
	}

	/**
	 * Sheet관련 프로세스 처리
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @param CondParam
	 * @param PageNo
	 */
    function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
        sheetObj.ShowDebugMsg = false;

		switch(sAction) {
			case IBCREATE:
				//Equipment Type/Size Grid Header Item Setting
				initDynamicEqTpszCd(sheetObj);
				setDynamicEqTpszHeader(sheetObj, formObj.p_eq_knd_cd.value);
				break;
			case IBSEARCH:			//조회
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "t1sheet1") {
						formObj.f_cmd.value = SEARCH;
						sheetObj.WaitImageVisible = false;
						ComOpenWait(true);

						var sXml = sheetObj.GetSearchXml("EES_MNR_0232GS.do" , FormQueryString(formObj));
						var arrXml = sXml.split("|$$|");
				        for( var i = 0 ; i < arrXml.length ; i++ ){
				            sheetObjects[i].LoadSearchXml(arrXml[i]);
				            setDynamicTabSheetsHeader(sheetObjects[i]);
				        }

						ComOpenWait(false);
						sheetObj.WaitImageVisible = true;
					}
				}
				break;
			case IBSEARCH_ASYNC01:	// Location 조회
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "t1sheet1") {
						var vLocType = formObj.p_loc_tp.value;
						var vLocCode = formObj.p_loc_cd.value;
 						var param = "f_cmd="+SEARCH+"&loc_cd=&loc_nm=&un_loc_ind_cd=&cnt_cd=&loc_eq_ofc=&select=&loc_state=";

 						if(vLocType == "1") {//p_loc_tp is 'RCC'
							param += "&rcc_cd="+ vLocCode +"&lcc_cd=";
 						} else {//p_loc_tp is 'LCC'
							param += "&rcc_cd=&lcc_cd="+ vLocCode;
 						}

 						sheetObj.WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("COM_ENS_051GS.do", param);
						sheetObj.WaitImageVisible = true;

						if ( ComGetTotalRows(sXml) < 1 ) {
							ComShowCodeMessage("MNR00117");
 							formObj.p_loc_cd.value = "";
							ComSetFocus(formObj.p_loc_cd);
						}
					}
				}
 				break;
		}
    }

	/**
     * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 * @param sheetObj
	 * @param ErrMsg
     */
    function setDynamicTabSheetsHeader(sheetObj, ErrMsg) {
    	with(sheetObj) {
    		var formObj = document.form;
			var viewCnt = 0;

			if(LastRow > HeaderRows) {
				for ( var i = 1 ; i < vCntrTpszCnt ; i++ ) {
					var cellData = eval('CellValue(LastRow, "tpsz_dp'+ ComLpad(i, 2, "0") + '")');
					if(cellData <= 0) {
						eval('ColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '") = true;');
					}

					//var viewFlag = eval('ColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '")');
					//if(viewFlag == false) {
					//	viewCnt++;
					//}
				}

				for(var i = 0; i <= SearchRows; i++) {
					if(CellValue(i, "loc_cd") == "") {
						RowBackColor(i) = MNR_TOTCOL_BACK_COLOR;
					}

					if(sheetObj.id == "t5sheet1" && CellValue(i, "rcc_cd") == "") {
						RowHidden(i) = true;
					}
				}

				RowHidden(LastRow) = true;
			}
			/*
			if(SearchRows > 0) {
				if(230 + (viewCnt * 90) > 984) {
					SheetWidth = 984;
				} else {
					SheetWidth = 240 + (viewCnt * 90);
				}
			} else {
				SheetWidth = 984;
				for( var i = 1; i < vCntrTpszCnt; i++ ) {
					if(vArrCntrTpsz[i] != "") {
						eval('ColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '") = false;');
					} else {
						eval('ColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '") = true;');
					}
				}
			}
			*/
    	}
    }

	/**
     * Pop-up Open 부분<br>
     * @param type 1:Location Code, 2:Currency Code
     * @param Row 대상Object가 IBSheet일 경우 해당 Row index
     * @param Col 대상Object가 IBSheet일 경우 해당 Col index
     */
    function openPopup(type, Row, Col) {
    	var formObj = document.form;

    	if ( type == "1" ) {
    		switch(formObj.p_loc_tp.value) {
    			case "1" :	//RCC
    				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 755, 610,"rcc_cd:p_loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			case "2" :	//LCC
    				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 755, 610,"lcc_cd:p_loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			default : 	//do nothing
    		}
    	}

    	return;
    }

	/**
	 * EQ_TYPE별 타입사이즈를 조회해서 각 배열에 담는다.
	 */
	function initDynamicEqTpszCd(sheetObj) {
		var arrXml = MnrComSearchGrid(sheetObj,"type_size_search_ind","");

		if(arrXml != null) {
			for(var i = 0; i < arrXml.length; i++) {
				if(i == 0){//U
					cntrTpSz = MnrXmlToOneDimArray(arrXml[i], "cd_id");
				} else if(i == 1){//Z
					chssTpSz = MnrXmlToOneDimArray(arrXml[i], "cd_id");
				} else if(i == 2){//G
					gsetTpSz = MnrXmlToOneDimArray(arrXml[i], "cd_id");
				}
			}
		}
	}

	/**
	 * Equipment Type/Size Grid Header Setting
	 */
	function setDynamicEqTpszHeader(sheetObj, eqKndCd) {
		var eqTpSzAry = new Array();

		if(eqKndCd == "U") {
			eqTpSzAry = cntrTpSz;
		} else if(eqKndCd == "Z") {
			eqTpSzAry = chssTpSz;
		} else {//eqKndCd is 'G'
			eqTpSzAry = gsetTpSz;
		}

		if(eqTpSzAry.length > 0) {
			var eqTpSzStr = "|"+ eqTpSzAry.toString().replace(/,/g, "|");
			vCntrTpszHdr = eqTpSzStr;
			vArrCntrTpsz = eqTpSzStr.split("|");
			vCntrTpszCnt = vArrCntrTpsz.length;

			for(i = 0; i < sheetObjects.length; i++) {
				/* IBSheet 재설정 */
				//khlee-시작 환경 설정 함수 이름 변경
				ComConfigSheet (sheetObjects[i] );
				initSheet(sheetObjects[i], i+1);
				//khlee-마지막 환경 설정 함수 추가
				ComEndConfigSheet(sheetObjects[i]);
			}
		}
	}

    /**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 */
	function validateForm(sheetObj, formObj, sAction) {
    	with(formObj) {
    		switch(sAction) {
    			case IBSEARCH:      //조회
					if(formObj.p_trf_eff_yr.value == "") {
						ComShowCodeMessage("MNR00172", "Effective Year");
						ComSetFocus(formObj.p_trf_eff_yr);
						return false;
						break;
					}
    				return ComChkValid(formObj, false);
    				break;
				default :	//do nothing
    		}
    	}

        return true;
	}

  	/**
	 * Form Element Clear 처리부분.<br>
	 * @param fieldName
	 * @deprecated 2009.06.22 현재 사용되지 않는다.
	 */
	function clearForm(fieldName) {
		var formObj = document.form;
		switch(fieldName) {
			default :	//do nothing
		}
	}
	/* 개발자 작업  끝 */