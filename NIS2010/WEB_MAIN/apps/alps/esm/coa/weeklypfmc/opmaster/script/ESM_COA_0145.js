/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0145.js
*@FileTitle : Lane History
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 이연각
*@LastVersion : 1.0
=========================================================
* History
* 2007.07.25 Park Eun Ju
* 2009.10.23 김기대 New FrameWork 적용
* 2010.02.24 이연각 업무처리중 버튼사용 금지 처리
* 2010.04.14 이행지 FormQueryString =>coaFormQueryString 변경
* 2010.06.14 이행지 Ticket ID : CHM-200901717[Legacy전환] UI 표준안 적용 요청 관련 수정
* 2010.06.17 이행지 Lane History Seq 구하는 로직 수정
* 2010.09.01 이일민 Ticket ID:CHM-201004982-01 COA Architecture 위배사항 수정
=========================================================
*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends 
 * @class ESM_COA_0145 : ESM_COA_0145 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_COA_0145() {
    this.processButtonClick =  processButtonClick ;
    this.loadPage           =  loadPage           ;
    this.initSheet          =  initSheet          ;
    this.setSheetObject     =  setSheetObject     ;
    this.getEdtDate         =  getEdtDate         ;
    this.sheet1_OnSearchEnd =  sheet1_OnSearchEnd ;
    this.sheet1_OnChange    =  sheet1_OnChange    ;
    this.doActionIBSheet    =  doActionIBSheet    ;
    this.validateForm       =  validateForm       ; 
}


// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var selRow = 0;
var sheet_height = 14; // sheet의 height

var comboObjects = new Array();
var comboCnt = 0;
var loadingMode = false;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         var sheetObject = sheetObjects[0];
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
        	    case "btn_Save":
    	            doActionIBSheet(sheetObject,formObject,IBSAVE);
        	        break;

        	    case "btn_Rowadd":
    	            doActionIBSheet(sheetObject,formObject,IBINSERT);
        	        break;
        	        
        	    case "btn_Close":
    	            self.close();
        	        break;

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg("COM12111", "", ""));
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }


    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
		loadingMode = true;
	    for(i=0;i<sheetObjects.length;i++){
	        ComConfigSheet(sheetObjects[i]);
	        initSheet(sheetObjects[i],i+1);
	        ComEndConfigSheet(sheetObjects[i]);
	    }
	    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
	    for(k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],comboObjects[k].id);
	    }
		loadingMode = false;
	}

	/**
	 * 멀티콤보 항목을 설정한다.
	 */
	function initCombo(comboObj, comboId) {
		with (comboObj) {
			DropHeight = 300;
			Index = 0;
		}
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
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
					
					SheetWidth = mainTable.clientWidth;														//전체 너비 설정
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);	//Host정보 설정[필수][HostIp, Port, PagePath]
					MergeSheet = msNone;																	//전체Merge 종류 [선택, Default msNone]
					Editable = true;																		//전체Edit 허용 여부 [선택, Default false]
					InitRowInfo(1 , 1, 9, 100);																//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitColumnInfo(14, 2, 0, true);															//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitHeadMode(true, true, false, true, false,false);										// 해더에서 처리할 수 있는 각종 기능을 설정한다
					var HeadTitle  = "Del.|STS|SEQ|Trade|Sub Trade|S.Lane|R.Lane|Bound|IOC|Lane T/P|Step Up/Down|VVD|From|To.";
					InitHeadRow(0, HeadTitle, false);														//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtDelCheck,	30,		daCenter,	false,		"");
					InitDataProperty(0, cnt++ , dtStatus,	30,		daCenter,	false,		"ibflag");
					InitDataProperty(0, cnt++ , dtData,	    50,		daCenter,	true,		"lane_seq",			true,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,	    50,		daCenter,	true,		"trd_cd",			true,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,	    70,		daCenter,	true,		"sub_trd_cd",		false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,		"slan_cd",			false,		"",		dfEngUpKey,	0,		false,		false);
					                                           		         	     		   		      		   		       		  		     		
					InitDataProperty(0, cnt++ , dtData,		55,		daCenter,	true,		"rlane_cd",			true,		"",		dfEngUpKey,	0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,	    55,		daCenter,	true,		"dir_cd",	        true,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,	    60,		daCenter,	true,		"ioc_cd",			true,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtCombo,	60,		daCenter,	true,		"vsl_lane_tp_cd",	false,		"",		dfNone,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtCheckBox,	90,		daCenter,	true,		"stup_flg",			false,		"",		dfNone,		0,		true,		true);
					                                           		         	     		   		      		   		       		  		     		
					InitDataProperty(0, cnt++ , dtData,	    80,		daCenter,	true,		"vvd_cd",	        false,		"",		dfNone,	    0,		true,		true, 9);
					InitDataProperty(0, cnt++ , dtData,	    80,		daCenter,	true,		"lane_aply_fm_dt",	false,		"",		dfDateYmd,	0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,	    80,		daCenter,	true,		"lane_aply_to_dt",	false,		"",		dfDateYmd,	0,		true,		true);

					CountPosition  = 0 ;
					style.height = GetSheetHeight(sheet_height) ;
					
                    InitDataValid(0, "vvd_cd",  6, "1234567890"); //vtEngOther=6
  				
               }
                break;

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

    //VVD --> edt-date
    function getEdtDate(result) {
    	var sheetObject1 = sheetObjects[0];
    	var sheetObject2 = sheetObjects[1];
    	var tmpRow = 0;
    
    	if(result == null || result == "" || result == "null"){
    		ComShowMessage(ComGetMsg('COA10027',selValue));
    		sheetObject1.SelectCell(selRow, "vvd_cd",true);
    	} else {
    		sheetObject1.CellValue(selRow,"lane_aply_fm_dt") = result;
    	}
    }   
    
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
        var formObj = document.form;
        sheetObj.RowEditable(1) = false;
    }

    function sheet1_OnChange(sheetObj,Row,Col,Value) {
    	var formObj = document.form;
    	with(sheetObj) {
    	    // FROM DATE를 변경하면 이전 데이터의 TO DATE를 변경시켜준다.
    		if (ColSaveName(Col) == "lane_aply_fm_dt") {
    			if (Row > 1) {
    				//Day-1 추출 로직 적용
    				//CellValue2(Row-1,"lane_aply_to_dt") = getOffsetDate(Value,-1);
                    CellValue2(Row-1,"lane_aply_to_dt") = ComGetDateAdd(Value, "D", -1, "-");
    			}
    		}
    		// VVD 가 변경되면 해당 FIRST LOADING PORT ETD DT를 가지고 온다.
    		if (ColSaveName(Col) == "vvd_cd") {
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
    			selRow = Row;
    			selValue = Value;
				formObj.f_cmd.value = SEARCHLIST02;
	        	formObj.f_vsl_cd.value = Value.substring(0,4);
	        	formObj.f_skd_voy_no.value = Value.substring(4,8);
	        	formObj.f_skd_dir_cd.value = Value.substring(8,9);
				var sXml = sheetObj.GetSearchXml("ESM_COA_0145GS2.do", coaFormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				if (0 < arrXml.length) {
					parent.getEdtDate(ComGetEtcData(arrXml[0],"edtDate"));
				}
				ComOpenWait(false);
    		}
    		// SC 일경우엔 STEP UP/DOWN을 안한다.
    		if(ColSaveName(Col) == "vsl_lane_tp_cd"){
    		    if(CellValue(Row, "vsl_lane_tp_cd") == "SC") {
        		    CellValue(Row, "stup_flg") = "0";
        		    CellEditable(Row, "stup_flg") =  false;
    		    } else {
        		    CellEditable(Row, "stup_flg") =  true;
    		    }
    		}
    	}
    }

	/**
	 * Sheet관련 프로세스 처리
	 */ 
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
	
		switch(sAction) {
		
	    	case IBCLEAR:          //조회
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = INIT;
		
				var sXml = sheetObj.GetSearchXml("ESM_COA_0145GS2.do", coaFormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				if (0 < arrXml.length) {
					ComCoaSetIBCombo(sheetObj, arrXml[0], "vsl_lane_tp_cd", true, 0);
				}

				ComOpenWait(false);

				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;

			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCHLIST01;
				sheetObj.DoSearch4Post("ESM_COA_0145GS.do", coaFormQueryString(formObj));
				ComOpenWait(false);
				break;
				
			case IBSAVE:        //저장
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI01;
				sheetObj.DoSave("ESM_COA_0145GS.do", coaFormQueryString(formObj,'f_cmd',true), -1, false);
				ComOpenWait(false);
				break;
			
			case IBINSERT:      // 입력
			    sheetObj.DataCopy(); //행복사
//				sheetObj.DataCopy(-1); // 마지막행에 행삽입
                var num = 0;
                for(i=1; i<sheetObj.LastRow+1; i++){
                    if(parseInt(num)<parseInt(sheetObj.CellValue(i, "lane_seq"))) {
                    	num = sheetObj.CellValue(i, "lane_seq");
                    }
                }
                num = parseInt(num) + 1;
				sheetObj.CellValue2(sheetObj.SelectRow, "lane_seq") = num;
				sheetObj.CellValue2(sheetObj.SelectRow, "stup_flg") = "0";
				break;
		}
	}

   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            for(var i=1; i<=sheetObj.LastRow; i++){       
                var lane_aply_fm_dt = sheetObj.CellValue(i,"lane_aply_fm_dt");
                var lane_aply_to_dt = sheetObj.CellValue(i,"lane_aply_to_dt");

                if(sheetObj.CellValue(i,"ibflag") != "R"){
                    if(lane_aply_fm_dt == "") {
                        ComShowMessage(ComGetMsg("COM12114","From Date"));
                        sheetObj.SelectCell(i, "lane_aply_fm_dt");
                        return false;
                    }
                    
                    if(lane_aply_to_dt == "") {
                        ComShowMessage(ComGetMsg("COM12114","To Date"));
                        sheetObj.SelectCell(i, "lane_aply_to_dt");
                        return false;
                    }
                }
            } 
        }
        return true;
    }