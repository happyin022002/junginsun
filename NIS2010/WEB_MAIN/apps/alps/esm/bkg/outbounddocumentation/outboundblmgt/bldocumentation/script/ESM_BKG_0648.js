/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0648.js
*@FileTitle : BL Copy
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 이일민
*@LastVersion : 1.0
* 2009.08.20 이일민
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
     * @class ESM_BKG_0648 : ESM_BKG_0648 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0648() {
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
    var sheetObjects = new Array();
    var sheetCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];
        /*******************************************************/
        var formObject = document.form;
        try {
            var srcName = window.event.srcElement.getAttribute("name");
            var btnFlag = ComIsBtnEnable(srcName);
            ComBtnDisable(srcName);
        	switch(srcName) {
	            case "btn_add":  //Row Add
	        		sheetObject1.DataInsert(-1);
	            	break;
	            case "btn_delete":  //Row Delete
	            	ComRowDeleteComplete(sheetObject1, "chk", 1);
	                break;
                case "btn_retrieve":  //Retrieve
	            	formObject.elements["bkg_no"].value = ComTrim(formObject.elements["bkg_no"].value);
	            	formObject.elements["s_bkg_no"].value = ComTrim(formObject.elements["s_bkg_no"].value);
                	doActionIBSheet(sheetObject1,document.form,IBSEARCH);
                    break;
                case "btn_new":  //New
                	sheetObject1.RemoveAll();
                	formObject.reset();
                    break;
                case "btn_copy":  //Copy
                	formObject.elements["bkg_no"].value = ComTrim(formObject.elements["bkg_no"].value);
	            	formObject.elements["s_bkg_no"].value = ComTrim(formObject.elements["s_bkg_no"].value);
                	//원본 조회 확인
                	if (""==formObject.elements["bkg_no"].value ||
                		formObject.elements["bkg_no"].value != formObject.elements["s_bkg_no"].value) {
	            		ComShowCodeMessage("BKG00255");  //"Booking Number is not available."
	            		ComSetFocus(formObject.s_bkg_no);
	                	ComBtnEnable(srcName);
	                	return;
                	}
                	//Copy 대상 Item 확인
            		if (!formObject.elements["cust_flg"].checked &&
            			!formObject.elements["mark_flg"].checked &&
            			!formObject.elements["desc_flg"].checked) {
            			ComShowCodeMessage("BKG00412");  //"Click item that you want to copy first"
            			formObject.elements["cust_flg"].focus();
                    	ComBtnEnable(srcName);
            			return;
            		}
           		    //Copy 대상 존재 확인
           			if (0==sheetObject1.RowCount) {
        				ComShowCodeMessage("BKG00411");  //"Input 'Copy To' booking number"
                    	ComBtnEnable(srcName);
            			return;
            		}
            		//check grid validation
            		if (!checkValidation(formObject,sheetObject1)) {
            			ComBtnEnable(srcName);
            			return;
            		}
                	//CONFIRM
                	if (!ComShowCodeConfirm("BKG00410")) {  //"Do you want to copy the B/L data ?"
                    	ComBtnEnable(srcName);
                		return;
                	}
           		    //복사 진행
                	doActionIBSheet(sheetObject1,document.form,IBSAVE);
                    break;
                case "btn_close":  //Close
	            	window.close();
	                break;
            }  //end switch
            if (btnFlag) {
            	ComBtnEnable(srcName);
            } else {
            	ComBtnDisable(srcName);
            }
        } catch(e) {
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
        for (i=0;i<sheetObjects.length;i++) {
        	ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
    	initControl();
    	ufGetBkgNo(sheetObjects[0]);
    }

    /**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * 
     * @param {ibsheet}
     *            sheetObj IBSheet Object
     * @param {int}
     *            sheetNo sheetObjects 배열에서 순번
     */
    function initControl() {
    	var formObject = document.form;
    	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
    	ComBtnDisable("btn_copy");

    	axon_event.addListenerFormat("keypress", "obj_KeyPress", formObject); //- 키보드 입력할때
    	axon_event.addListener("keydown", "ComKeyEnter", "form");
    	//axon_event.addListenerForm("beforedeactivate", "obj_deactivate",  formObject); //- 포커스 나갈때
    }

    function obj_deactivate() {
    	if ("s_bkg_no"==event.srcElement.name) {
        	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	}
    }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObject ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObject,sheetNo) {
        var cnt = 0;
        var sheetID = sheetObject.id;
        switch(sheetID) {
            case "sheet1":
                with (sheetObject) {
                // 높이 설정
                style.height = 145;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;
                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;//msNone;
                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;
                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);
                var HeadTitle = "|Sel.|Booking No.|Booking No.|Result";
                var headCount = ComCountHeadTitle(HeadTitle);
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false,false);
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 0,   daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtCheckBox,     40,  daCenter, false, "chk");
                InitDataProperty(0, cnt++, dtData,         120, daLeft,   false, "copy_bkg_no", true,  "", dfNone, 0, true,  true , 13);
                InitDataProperty(0, cnt++, dtPopup,        20,  daCenter, false, "bkgPop",      false, "", dfNone, 0, true,  true);
                InitDataProperty(0, cnt++, dtData,         50,  daLeft,   false, "resultMsg",   false, "", dfNone, 0, false, false);
                InitDataValid(0, "copy_bkg_no", vtEngUpOther, "0123456789");
                ShowButtonImage = 2;
                sheetObject.FocusEditMode = -1;
                CountPosition = 0;
            }
            break;
        }
    }

    //Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObject,formObject,sAction) {
    	sheetObject.ShowDebugMsg = false;
    	var sXml;
        switch(sAction) {
            case IBSEARCH:  //조회
                if (!validateForm(sheetObject,formObject,sAction)) return;
	            ComSetObjValue(formObject.elements["f_cmd"], SEARCH);
            	sXml = sheetObject.GetSearchXml("ESM_BKG_0648GS.do", FormQueryString(formObject), "", true);
				var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
				xmlDoc.async="false";
				xmlDoc.loadXML(sXml);
				if (xmlDoc.documentElement && 1 < xmlDoc.documentElement.getElementsByTagName("ETC-DATA").item(0).childNodes.length) {
					ComEtcDataXmlToForm(sXml, formObject);
	            	ComBtnEnable("btn_copy");
				} else {  //결과값이 없는 경우
					ComShowCodeMessage("BKG08017");  //BKG No. not exists
		            if (!ComIsEmpty(formObject.elements["bkg_no"].value)) {
			            ComSetObjValue(formObject.elements["s_bkg_no"], formObject.elements["bkg_no"].value);
		            	ComBtnEnable("btn_copy");
		            } else {
		            	ComBtnDisable("btn_copy");
		            }
		            formObject.elements["s_bkg_no"].focus();
				}
                break;
            case IBSAVE:  //복사
                if (!validateForm(sheetObject,formObject,sAction)) return;
	            ComSetObjValue(formObject.elements["f_cmd"], MULTI01);
	            ComSetObjValue(formObject.elements["bkg_no"], formObject.elements["s_bkg_no"].value);
	            sXml = sheetObject.GetSaveXml("ESM_BKG_0648GS.do", ComGetSaveString(sheetObject,true,true) + "&" + FormQueryString(formObject));
  				sheetObject.LoadSearchXml(sXml);
  				break;
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObject,formObject,sAction) {
        with(formObject){
			if (!ComChkValid(formObject)) return false;
        }
        return true;
    }

    /*
    function sheet1_OnSearchEnd(sheetObject, ErrMsg) {
        with(sheetObject) {
            ColFontUnderline("copy_bkg_no") = true;
        }
    }
    */

    //check grid validation
    function checkValidation(formObject,sheetObject) {
		for (var i=1; i<=sheetObject.RowCount; i++) {
			//비어있음
			if (ComIsEmpty(sheetObject.CellValue(i,2))) {
				ComShowCodeMessage("BKG00411");  //"Input 'Copy To' booking number"
				sheetObject.SelectCell(i,2);
				return false;
			//길이가 잘못됨
			} else if (11>ComGetLenByByte(sheetObject.CellValue(i,2)) || 13<ComGetLenByByte(sheetObject.CellValue(i,2))) {
				ComShowCodeMessage("BKG00381");  //"Incorrect Data Length"
				sheetObject.SelectCell(i,2);
				return false;
			//원본과같음
			} else if (formObject.elements["bkg_no"].value==sheetObject.CellValue(i,2)) {
				ComShowCodeMessage("BKG08019");  //"Please Check BKG No."
				sheetObject.SelectCell(i,2);
				return false;
			}
			//중복확인
    		for (var j=sheetObject.RowCount; 0<j; j--) {
    			if (i!=j && sheetObject.CellValue(i,2)==sheetObject.CellValue(j,2)) {
   					ComShowCodeMessage("BKG04008");  //"The Data you input were already exsited. Please check it again";
   					sheetObject.SelectCell(j,2);
   					return false;
    			}
    		}
		}
		return true;
    }

    //opener 에서 선택된 bkg_no를 받아온다.
    function ufGetBkgNo(sheetObj) {
    	if (opener && opener.sheetObjects[0] && "Y"==document.form.isPop.value) {
	    	var sRow = opener.sheetObjects[0].FindCheckedRow("slct_flg");
	    	var arrRow = sRow.split("|");
			for(var i=0; i < arrRow.length-1; i++) {
        		var row = sheetObj.DataInsert(-1);
        		sheetObj.CellValue2(row,"copy_bkg_no") = opener.sheetObjects[0].CellValue(arrRow[i],"bkg_no");
			}
    	}
    }

    //BKG 메인팝업을 호출한다.
	function sheet1_OnPopupClick(sheetObject, row, col) {
		if ("bkgPop"==sheetObject.ColSaveName(col)) {
			var bkg_no = sheetObject.CellValue(row, "copy_bkg_no");
			if (""==bkg_no) {
				ComShowCodeMessage("BKG08017");  //BKG No. not exists
				return;
			}
			ComOpenWindowCenter("ESM_BKG_0079.do?pgmNo=ESM_BKG_0079&bkg_no="+bkg_no+"&mainPage=false", "ESM_BKG_0079", 1024, 730, true);
		}
	}
    /* 개발자 작업  끝 */
