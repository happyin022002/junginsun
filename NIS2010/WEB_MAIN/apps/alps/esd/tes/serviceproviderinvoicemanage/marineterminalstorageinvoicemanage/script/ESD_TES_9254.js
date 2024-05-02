/**
 * @fileoverview MR Storage Container List - 3rd Party Interface 에서 사용하는 업무 스크립트를 정의한다.
 * @author SM LINE
 */

/**
 * @extends Tes
 * @class ESD_TES_9254 : MR Storage Container List - 3rd Party Interface 에서 사용하는 업무 스크립트를 정의한다.
 */

	function ESD_TES_9254() {
		this.processButtonClick = processButtonClick;
		this.setSheetObject = setSheetObject;
		this.setComboObject = setComboObject;
		this.setTabObject = setTabObject;
		this.loadPage = loadPage;
		this.initSheet = initSheet;
		this.initControl = initControl;
		this.initTab = initTab;
		this.doActionIBSheet = doActionIBSheet;
		this.validateForm = validateForm;
	}

	//공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
	document.onclick = processButtonClick;

	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
	 * @return
	 */
    function processButtonClick(){
         var sheetObj = sheetObjects[0];

         var formObject = document.form;

    	 try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
        	    case "btng_rowadd":
    	            doActionIBSheet(sheetObj,formObject,IBINSERT);
        	        break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('TES23028')); //ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 * @return     
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
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
									
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(24, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false, false);

				//var HeadTitle = "Del.|STS|3rd Party|3rd Party|Container No.|Billing Case|Amount|Remark";
				//var HeadTitle = "|STS|Container No.|Billing Case|Amount|3rd Party|3rd Party|Remark";
				var HeadTitle = "|Container No.|Billing Case|Amount|3rd Party|3rd Party|Remark";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				//InitDataProperty(0, cnt++, dtCheckBox,   30,    daCenter,  true,    "chk");
				InitDataProperty(0, cnt++, dtHiddenStatus,     30,    daCenter,  true,    "ibflag");
				InitDataProperty(0, cnt++, dtData,      100,    daLeft,  false,    "cntr_no",       true,           "",       dfNone,    0,     false,       false);
				InitDataProperty(0, cnt++, dtData,     100,    daCenter,  false,    "n3pty_bil_tp_cd",       true,           "",       dfNone,    0,     true,       true);
				InitDataProperty(0, cnt++, dtData,       60,    daRight ,  false,    "if_amt",       false,          "",      dfFloat,    2,     true,       true);
				
				InitDataProperty(0, cnt++, dtCombo,     80,     daLeft,  true,    "vndr_cust_div_cd",        false,          "",       dfNone,    0,     true,       true); ///
				InitDataProperty(0, cnt++, dtPopup,     100,    daLeft,  true,    "trd_party_val",        false,          "",       dfNone,    0,     true,       true); ///
				InitDataProperty(0, cnt++, dtData,      100,    daLeft,  false,    "if_rmk",       false,          "",       dfNone,    0,     true,       true);
				InitDataProperty(0, cnt++, dtHidden,       65,  daRight,   true,    "vndr_cnt_cd",        false,          "",    dfNone);
				InitDataProperty(0, cnt++, dtHidden,       65,  daRight,   true,    "vndr_seq",        false,          "",    dfNone);

				InitDataProperty(0, cnt++, dtHidden,       65,  daRight,   true,    "n3pty_vndr_seq",        false,          "",    dfNone);
				InitDataProperty(0, cnt++, dtHidden,       65,  daRight,   true,    "cust_cnt_cd",        false,          "",    dfNone);
				InitDataProperty(0, cnt++, dtHidden,       65,  daRight,   true,    "cust_seq",        false,          "",    dfNone);
				InitDataProperty(0, cnt++, dtHidden,       65,  daRight,   true,    "n3pty_ofc_cd",        false,          "",    dfNone);
				InitDataProperty(0, cnt++, dtHidden,       65,  daRight,   true,    "tml_if_ofc_cd",        false,          "",    dfNone);
				
				InitDataProperty(0, cnt++, dtHidden,       65,  daRight,   true,    "tml_if_seq",        false,          "",    dfNone);
				InitDataProperty(0, cnt++, dtHidden,       65,  daRight,   true,    "tml_so_ofc_cty_cd",        false,          "",    dfNone);
				InitDataProperty(0, cnt++, dtHidden,       65,  daRight,   true,    "tml_so_seq",        false,          "",    dfNone);
				InitDataProperty(0, cnt++, dtHidden,       65,  daRight,   true,    "tml_so_cntr_list_seq",        false,          "",    dfNone);
				InitDataProperty(0, cnt++, dtHidden,       65,  daRight,   true,    "tml_so_dtl_seq",        false,          "",    dfNone);

				InitDataProperty(0, cnt++, dtHidden,       65,  daRight,   true,    "tml_so_dtl_seq3",        false,          "",    dfNone);
				InitDataProperty(0, cnt++, dtHidden,       65,  daRight,   true,    "lgs_cost_cd",        false,          "",    dfNone);
				InitDataProperty(0, cnt++, dtHidden,       65,  daRight,   true,    "cntr_tpsz_cd",        false,          "",    dfNone);
				InitDataProperty(0, cnt++, dtHidden,       65,  daRight,   true,    "io_bnd_cd",        false,          "",    dfNone);
				InitDataProperty(0, cnt++, dtHidden,       65,  daRight,   true,    "calc_cost_grp_cd",        false,          "",    dfNone);
				
				InitDataCombo (0, "vndr_cust_div_cd", combo01Text, combo01Code);

		    }
			break;
		}
	}

     /**
      * Sheet 관련 프로세스 처리
 	 * @param {ibsheet} sheetObj 	IBSheet Object
 	 * @param {form} 	formObj		Form Object
 	 * @param {int}	sAction		실행할 액션 구분 값
      * @return
      */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
		   case IBSEARCH:
                if (!validateForm(sheetObj,formObj,sAction)){
			        return false;
			    }
				formObj.f_cmd.value = SEARCHLIST;
				sheetObj.DoSearch4Post("ESD_TES_9254Popup.do", tesFrmQryStr(formObj));
			    break;
		}
    }

   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!ComIsNumber(iPage)) {
//
//                return false;
//            }
        }

        return true;
    }

