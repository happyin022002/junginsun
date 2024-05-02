/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESM_MAS_9000.js
*@FileTitle : Bkg 소급
*Open Issues :
*@LastModifyDate	: 2013.04.26
*@LastModifier 	: 박찬민
* 1.0 최초 생성
=========================================================
* History
* 2015.08.31 손진환 [CHM-201536958] Split15-[그룹사 표준 코드 시행] SML 프로그램 대응 및 데이타 마이그레이션 작업 요청
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
	 * @class ESM_MAS_9000 : ESM_MAS_9000 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESM_MAS_9000() {
		this.processButtonClick		= processButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.doActionIBSheet 		= doActionIBSheet;
		this.validateForm 		    = validateForm;
	}

// 공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;
var loadingMode = false;
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


         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
            
            	case "btn_calendar":
	                if (!window.event.srcElement.disabled) {
	                    var cal = new ComCalendarFromTo();
	                    cal.select(formObject.f_fm_date, formObject.f_to_date, "yyyy-MM-dd");
	                }
                break;

        	    case "btn_Retrieve":
        	    	if(formObject.f_fm_date.value == "" || formObject.f_to_date.value ==""){
        	    		ComShowMessage(ComGetMsg("COM130201","duration"));
        	    	}else{
        	    		doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	    	}
        	        break;

        	    case "btn_Apply":
	                	doActionIBSheet(sheetObject,formObject,IBSAVE);
	                	doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	        break;

        	    case "btng_DownExcel":
        	        doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
        	        break;

        	    case "btng_RowAdd":
    	            doActionIBSheet(sheetObject,formObject,IBINSERT);
        	        break;
        	        
        	    case "btng_RowDel":
    	            doActionIBSheet(sheetObject,formObject,IBDELETE);
        	        break;

                case "btng_LoadExcel":
                    doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
                    break;
                    
                case "btn_New":
                	sheetObject.RemoveAll();
                	var NowDate = ComGetNowInfo();
                	ComSetObjValue(formObject.f_fm_date, NowDate);
                	ComSetObjValue(formObject.f_to_date, NowDate);
                	ComSetObjValue(formObject.f_status,"All");
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
		
		if (document.form.f_ofc_cd.value == 'SELCSG' || document.form.f_ofc_cd.value == 'CLTCO'
			|| document.form.f_ofc_cd.value == 'SELAPM' ){
			ComBtnEnable("btn_Retrieve");
			ComBtnEnable("btn_New");
			ComBtnEnable("btn_Apply");
			ComBtnEnable("btng_RowAdd");
			ComBtnEnable("btng_RowDel");
			ComBtnEnable("btng_DownExcel");
			ComBtnEnable("btng_LoadExcel");
		} else {
			ComBtnDisable("btn_Retrieve");
			ComBtnDisable("btn_New");
			ComBtnDisable("btn_Apply");
			ComBtnDisable("btng_RowAdd");
			ComBtnDisable("btng_RowDel");
			ComBtnDisable("btng_DownExcel");
			ComBtnDisable("btng_LoadExcel");
		}
		document.form.f_fm_date.value = ComGetNowInfo();
		document.form.f_to_date.value = ComGetNowInfo();
    }

 	/**
     * 멀티콤보 항목을 설정한다.
     */
	function initCombo(comboObj, comboId) {
		with (comboObj) {
	    	if(comboId == "f_status"){
//	    		BackColor = "#CCFFFD";
	    		ValidChar(2,1); // 영어대문자 사용, 숫자포함 시
	    	} else {
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
				//sheet1 init
				with (sheetObj) {
					SheetWidth = mainTable.clientWidth;									//전체 너비 설정
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
					MergeSheet = msHeaderOnly;											//전체Merge 종류 [선택, Default msNone]
					Editable = true;													//전체Edit 허용 여부 [선택, Default false]
					InitRowInfo( 1, 1, 9, 100);											//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitColumnInfo(8, 0, 0, true);										//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitHeadMode(true, true, false, true, false,false);					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					var HeadTitle  = "Sel.|STS|Seq.|Booking No.|Remarks|Create User|Status|Finish Time" ;
					InitHeadRow(0, HeadTitle, true);									//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtCheckBox,   30,    daCenter,  true,    "sel_chk",       	false, 			"", 	  dfNone,    		0						);
					InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	  30,	 daCenter,	true,	 "ibflag"																			);
					InitDataProperty(0, cnt++ , dtSeq,        50,    daCenter,  true,    "seq",      		false,          "",       dfNone,   		0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      120,    daCenter,  true,    "bkg_no",			true,           "",       dfNone,    		0,     false,      true);
					InitDataProperty(0, cnt++ , dtData,      250,    daCenter,  true,    "mas_bat_rmk",    true,           "",       dfNone,       	0,     false,      true);
					InitDataProperty(0, cnt++ , dtData,       120,    daCenter,  true,    "cre_usr_id",     false,           "",       dfNone,       	0,     false,      false);
					InitDataProperty(0, cnt++ , dtCombo,       80,    daCenter,  true,    "status",     		false,          "",       dfNone,       	0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,    "finish_time",     		false,          "",       dfNone,       	0,     false,      false);

					CountPosition  = 2 ;
					style.height = GetSheetHeight(18) ;

				}
				break;
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
				var sXml = sheetObj.GetSearchXml("ESM_MAS_9000GS.do", masFormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0){
					ComXml2ComboItem(arrXml[0], formObj.f_status, "code", "name");
					ComMasSetIBCombo(sheetObj, arrXml[0], "status", true, 0);
					}
				ComOpenWait(false);
				break;
				
			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH01;
				sheetObj.DoSearch4Post("ESM_MAS_9000GS.do", masFormQueryString(formObj));
				ComOpenWait(false);
				break;

			case IBSAVE:        //저장
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				popup = window.showModalDialog("ESM_MAS_3001.do", window, "dialogWidth:300px;dialogHeight:140px;scroll:no");
    	    	if(popup == "6475"){
    	    		// 업무처리중 버튼사용 금지 처리
    				sheetObj.WaitImageVisible = false;
    				ComOpenWait(true);
    				formObj.f_cmd.value = MULTI01;
    				sheetObj.DoAllSave("ESM_MAS_9000GS.do", masFormQueryString(formObj));
    				ComOpenWait(false);	
    	    	}
				
				break;

			case IBINSERT:      // 입력
				if(formObj.f_rownum.value==""){
					var Row =sheetObj.DataInsert(-1);
				}else{
					if(formObj.f_rownum.value>1000){
						ComShowMessage(ComGetMsg("MAS10008","1000 rows"));
					}else{
						for(i=0;i<formObj.f_rownum.value;i++){
							sheetObj.DataInsert(-1)
						}
					}
				}
				
				break;
				
            case IBDELETE:
            	var arrRow = sheetObj.FindCheckedRow("sel_chk").split("|");
            	
            	for(idx=0; idx<arrRow.length-1; idx++){
            			sheetObj.RowDelete(arrRow[idx]-idx, false);
            	}
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
	        	sheetObj.LoadExcel(-1, 1, "", "-1", "-1", "", false);
        		ComOpenWait(false);
        		sheetObj.Redraw = true;
	        	
				break;					
				
		}
	}

	/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
	function validateForm(sheetObj,formObj,sAction){
		var rt = true;
		with(formObj){
			switch(sAction) {
				case IBSAVE:
					
					if(sheetObj.RowCount>1000){
						ComShowMessage(ComGetMsg("MAS10008","1000 rows"));
						return false;
					}
					if(!checkDup(sheetObj)){
						ComShowMessage(ComGetMsg("COM131301","Booking No."));
						return false;
					}
					var lastRow = sheetObj.LastRow;
					for (idx=1; idx<lastRow+1; idx++){
						if(sheetObj.CellValue(idx,"bkg_no")==""||sheetObj.CellValue(idx,"mas_bat_rmk")==""){
							ComShowMessage(ComGetMsg("COM130201","Booking No. or Remarks"));
							return false;
						}
					}
					break;
			}
		}
		return rt;
	}
	
	/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
	function checkDup(sheetObject){
		var duprow1 = sheetObject.ColValueDupRows("bkg_no",false,false,1,sheetObject.LastRow);
		var rt = true;
		if(duprow1!=""){
			var arrRow = duprow1.split(",");
			for (idx=0; idx<arrRow.length; idx++){ 
				sheetObject.CellBackColor(arrRow[idx],"bkg_no") = sheetObject.RgbColor(255, 0, 0)
    			}
			rt = false;
		}
		return rt;
	}
	
    /**
     * 날짜 형식으로 변형해준다.
     *
     * @param obj object
     */
    function addDateDash(obj){
        var value = obj.value.replace(/\/|\-|\./g,"");
        var rtnValue = "";
        if(value.length>0){
            rtnValue = value.substring(0, 4)+"-"+value.substring(4,6)+"-"+value.substring(6);
            obj.value = rtnValue;
        }
    }

