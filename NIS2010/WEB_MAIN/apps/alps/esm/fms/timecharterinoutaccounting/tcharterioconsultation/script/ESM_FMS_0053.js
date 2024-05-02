/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0053.js
*@FileTitle : Invoice Interface Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.07.20 윤세영
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
     * @class ESM_FMS_0053 : ESM_FMS_0053 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_FMS_0053() {
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
	
	var rdObjects = new Array();
    var rdCnt = 0;

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
						
            	case "btn_retrieve":
	             	
	             	if (!duration_change()) return;
	             	
	             	doActionIBSheet(sheetObject,formObject,IBSEARCH);
                break;

				case "btn_new":
					
					ComResetAll();
					inputReadOnly("New");

                break;

				case "btn_save":
					if (ComIsBtnEnable("btn_save")) {
						doActionIBSheet(sheetObject1,formObject,IBSAVE);
					}	
                break;
	
                //2017.04.18 preview 기능 추가
				case "btn_preview":
					if (sheetObject.SelectRow > 0) {

						//CSR No.
						formObject.csr_no.value = sheetObject.CellValue(sheetObject.SelectRow, "csr_no");
	
						rdOpenPreview(rdObjects[0], formObject);

					} else {
			 			ComShowCodeMessage("FMS00015");
					}
                break;
                
				case "btn_print":
					if (sheetObject.SelectRow > 0) {

						//CSR No.
						formObject.csr_no.value = sheetObject.CellValue(sheetObject.SelectRow, "csr_no");
	
						rdOpen(rdObjects[0], formObject);

					} else {
			 			ComShowCodeMessage("FMS00015");
					}
                break;

     			case "btn_fr_duration":
     				var cal = new ComCalendar();

 					cal.setDisplayType('date');
					cal.select(form.fr_duration, 'yyyy-MM-dd');
     				
					break;					

     			case "btn_to_duration":
     				var cal = new ComCalendar();

 					cal.setDisplayType('date');
					cal.select(form.to_duration, 'yyyy-MM-dd');

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
     * Event에 따른 화면 처리 <br>
     * @param {String} flag     	Event 구분값
     **/
    function inputReadOnly(flag) {
    	var readOnly = true;
    	var cursor = "default";
    	var img = "no_";
    	
    	if(flag == "New") {
    		readOnly = false;
    		cursor = "hand";
    		img = "";
    	}

		form.fr_duration.readOnly = readOnly;
		form.to_duration.readOnly = readOnly;
    	form.condition[0].disabled = readOnly;
    	form.condition[1].disabled = readOnly;
    	form.search_csr_no.readOnly = readOnly;
    	
    	document.images["btn_fr_duration"].name = img+"btn_fr_duration";
    	document.images["btn_to_duration"].name = img+"btn_to_duration";
    	
    	form.btn_fr_duration.style.cursor = cursor;
    	form.btn_to_duration.style.cursor = cursor;

		ComBtnEnable("btn_save");

		ComBtnDisable("btn_preview");
		ComBtnDisable("btn_print");
    }

    /**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_blur(){
	    ComChkObjValid(event.srcElement);
    }
    
    /**
     * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
     **/
    function obj_keypress(){

	    obj = event.srcElement;

	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;

    	switch(event.srcElement.dataformat){
	        case "engup":
	            ComKeyOnlyAlphabet('uppernum', "0123456789");
	            break;
			case "int":
		        //숫자 만입력하기
		        ComKeyOnlyNumber(event.srcElement);

				break;
			case "float":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			default:
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
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

        //khlee-시작 환경 설정 함수 이름변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
				
        //Grid 마지막 컬럼의 크기가 그리드 사이즈에 맞게 늘어나지 않게 함.
        sheetObjects[0].ExtendLastCol = false;
        sheetObjects[1].ExtendLastCol = false;
        
        //html컨트롤 이벤트초기화
        initControl();

        //RD
		initRdConfig(rdObjects[0]);

    }

	/**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {
    	
        //Axon 이벤트 처리1. 이벤트catch
    	axon_event.addListenerForm  ('blur'				, 'obj_blur', 		document.form); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress'        	, 'obj_keypress'  , document.form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
        
        axon_event.addListener  ('change'  , 'duration_change', 'fr_duration');			//- Duration 입력 후 From~To 비교
        axon_event.addListener  ('change'  , 'duration_change', 'to_duration');			//- Duration 입력 후 From~To 비교

		//Print Button Disable 하기
        ComBtnDisable("btn_preview");
		ComBtnDisable("btn_print");

    }

	/**
     * Duration 입력 후 From~To 비교
     **/
    function duration_change() {

		var formObj = document.form;
		var fr_duration = ComReplaceStr(formObj.fr_duration.value,'-');
		var to_duration = ComReplaceStr(formObj.to_duration.value,'-');
		if (fr_duration != '' && to_duration != '') {
			if (parseFloat(fr_duration) > parseFloat(to_duration)) {
				ComAlertFocus(formObj.to_duration, ComGetMsg('FMS00018','Effective From Date','Effective To Date'));
				return false;
			}
			
		}

		return true;

	}	


  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
				var sheetID = sheetObj.id;
        switch(sheetID) {
        	
            case "sheet1":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 154;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);

					var HeadTitle1 = "|Seq|Apply|CSR No.|Vendor Code|Vendor Code|Effective Date|Currency|Balance Amount|CSR Description|Interface Error Message";
					var headCount = ComCountHeadTitle(HeadTitle1);
 
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	80,		daCenter,	true,		"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,			35,		daCenter,	true,		"Seq");
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		"apply_chk");
					InitDataProperty(0, cnt++ , dtData,  		150,	daCenter,	true,		"csr_no",		false,	"",	dfNone, 	0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,  		25,		daCenter,	true,		"vndr_cnt_cd",	false,	"",	dfNone, 	0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,  		60,		daCenter,	true,		"vndr_seq",		false,	"",	dfNone, 	0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,      	95,		daCenter,	false,		"eff_dt",		false,	"",	dfDateYmd, 	0,     	false,		false);
					
					InitDataProperty(0, cnt++ , dtData,      	60,		daCenter,	true,		"csr_curr_cd",	false,	"",	dfNone, 	0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	   	100,	daRight,	true,		"csr_amt",		false,	"",	dfNullFloat,2,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,      	220,	daLeft,		true,		"csr_desc",		false,	"",	dfNone, 	0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,      	220,	daLeft,		true,		"if_err_rsn",	false,	"",	dfNone, 	0,     	false,		false);
										
										
										
               }
                break;
        	
            case "sheet2":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 258;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
					MergeSheet = msAll;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 2, 3, 100);

					var HeadTitle1 = " |Seq|Acct Code|Vendor Code|Vendor Code|Center Code|City|Effective Date|Slip Amount";
					var HeadTitle2 = " |Seq|Description|Description|Description|Description|Description|VVD Code|Key Number";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount+9, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,	"org_slp_seq_no",	false,	"",	dfNone, 	0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,      	125,	daCenter,	true,	"acct_cd",			false,	"",	dfNone, 	0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,      	40,		daCenter,	false,	"vndr_cnt_cd",		false,	"",	dfNone, 	0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,      	90,		daCenter,	false,	"vndr_seq",			false,	"",	dfNone, 	0,     	false,		false);
					
					InitDataProperty(0, cnt++ , dtData,      	125,	daCenter,	false,	"ctr_cd",			false,	"",	dfNone, 	0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,      	125,	daCenter,	false,	"slp_loc_cd",		false,	"",	dfNone, 	0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,      	110,	daCenter,	false,	"eff_dt",			false,	"",	dfDateYmd, 	0,     	false,		false);
					InitDataProperty(0, cnt++ , dtAutoSum,   	140,	daRight,	false,	"csr_amt",			false,	"",	dfNullFloat,2,     	false,		false);

					InitDataProperty(0, cnt++ , dtHidden,		0,    	daLeft,  	false,  "org_slp_tp_cd");
					InitDataProperty(0, cnt++ , dtHidden,		0,    	daLeft,  	false,  "org_slp_func_cd");
					InitDataProperty(0, cnt++ , dtHidden,		0,    	daLeft,  	false,  "org_slp_ofc_cd");
					InitDataProperty(0, cnt++ , dtHidden,		0,    	daLeft,  	false,  "org_slp_iss_dt");
					InitDataProperty(0, cnt++ , dtHidden,		0,    	daLeft,  	false,  "org_slp_ser_no");
					InitDataProperty(0, cnt++ , dtHidden,		0,    	daLeft,  	false,  "cxl_desc");
					InitDataProperty(0, cnt++ , dtHidden,		0,    	daLeft,  	false,  "pre_slp_tp_cd");
					InitDataProperty(0, cnt++ , dtHidden,		0,    	daLeft,  	false,  "pre_slp_func_cd");
					InitDataProperty(0, cnt++ , dtHidden,		0,    	daLeft,  	false,  "pre_slp_ofc_cd");

					cnt = 0;
					InitDataProperty(1, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	"ibflag1");
					InitDataProperty(1, cnt++ , dtData,			85,		daCenter,	true,	"org_slp_seq_no1",	false,	"",	dfNone, 	0,     	false,		false);
					InitDataProperty(1, cnt++ , dtData,      	125,	daLeft,		true,	"csr_desc",			false,	"",	dfNone, 	0,     	false,		false);
					InitDataProperty(1, cnt++ , dtData,      	40,		daCenter,	false,	"csr_desc1",		false,	"",	dfNone, 	0,     	false,		false);
					InitDataProperty(1, cnt++ , dtData,      	90,		daCenter,	false,	"csr_desc2",		false,	"",	dfNone, 	0,     	false,		false);

					InitDataProperty(1, cnt++ , dtData,      	125,	daCenter,	false,	"csr_desc3",		false,	"",	dfNone, 	0,     	false,		false);
					InitDataProperty(1, cnt++ , dtData,      	125,	daCenter,	false,	"csr_desc4",		false,	"",	dfNone, 	0,     	false,		false);
					InitDataProperty(1, cnt++ , dtData,      	110,	daCenter,	false,	"vvd_cd",			false,	"",	dfNone, 	0,     	false,		false);
					InitDataProperty(1, cnt++ , dtData,   	   	140,	daRight,	false,	"key_number",		false,	"",	dfNone, 	0,     	false,		false);

					InitDataProperty(1, cnt++ , dtHidden,		0,    	daLeft,  	false,  "slp_tp_cd");
					InitDataProperty(1, cnt++ , dtHidden,		0,    	daLeft,  	false,  "slp_func_cd");
					InitDataProperty(1, cnt++ , dtHidden,		0,    	daLeft,  	false,  "slp_ofc_cd");
					InitDataProperty(1, cnt++ , dtHidden,		0,    	daLeft,  	false,  "slp_iss_dt");
					InitDataProperty(1, cnt++ , dtHidden,		0,    	daLeft,  	false,  "slp_ser_no");
					InitDataProperty(1, cnt++ , dtHidden,		0,    	daLeft,  	false,  "slp_seq_no");
					InitDataProperty(1, cnt++ , dtHidden,		0,    	daLeft,  	false,  "pre_slp_iss_dt");
					InitDataProperty(1, cnt++ , dtHidden,		0,    	daLeft,  	false,  "pre_slp_ser_no");
					InitDataProperty(1, cnt++ , dtHidden,		0,    	daLeft,  	false,  "pre_slp_seq_no");

    				DataRowMerge(1) = true;

               }
                break;



        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction, searchDetail) {

		sheetObj.ShowDebugMsg = false;
        switch(sAction) {

			case IBSEARCH:      //조회

     	   	  	if (searchDetail == 'Y') {

	        		formObj.f_cmd.value = SEARCH01;
	        		sheetObj.DoSearch("ESM_FMS_0053GS.do", FormQueryString(formObj));

       	   	  	} else {
	       	   	  	if(validateForm(sheetObj,formObj,sAction)){
		        		formObj.f_cmd.value = SEARCH;
		        		sheetObj.DoSearch("ESM_FMS_0053GS.do", FormQueryString(formObj)+"&" + ComGetPrefixParam(new Array("master")));
		        	   
		  	   	  		inputReadOnly("Search");
						
						//Print button enable
		  	   	  		ComBtnEnable("btn_preview");
						ComBtnEnable("btn_print");
		  	   	  	}	
       	   	  	}

                break;

           	case IBSAVE:        //저장
	 			if(!validateForm(sheetObj,formObj,sAction)) return;
	 			formObj.f_cmd.value = MULTI;
	 			
	 			if (sheetObj.RowCount > 1) {
	 				sheetObj.CellValue(2, "cxl_desc") = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "if_err_rsn");
	 				//Office Code
	 				sheetObj.CellValue(3, "org_slp_ofc_cd") = formObj.slp_ofc_cd.value;
	 			}
	 			
				var param = FormQueryString(formObj) + "&" + ComFmsSetPrifix(sheetObj.GetSaveString(),"sheet1_")+"&" + ComGetPrefixParam(new Array("master"));
				var sXml = sheetObj.GetSaveXml("ESM_FMS_0053GS.do", param);
		
		        var saveFlag = ComFmsGetXMLData(sXml, "TR-ALL");
				sheetObjects[0].LoadSaveXml(sXml);
				if (saveFlag == "OK") {
					sheet1_OnClick(sheetObjects[0],1, 1, "");	
				}	

			break;

        }
    }



    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){

	    	//필수 입력 등 Validation 체크
	        if (!ComChkValid(formObj)) return false;

            if (formObj.search_csr_no.value.trim() != '' && formObj.search_csr_no.value.trim().length < 3) {
			 	ComShowCodeMessage("FMS01437");
                return false;
            }
        }

        return true;
    }

    /**
     * Sheet의 조회 이벤트가 끝난 이후에 프로세스 처리
     */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{

		if (sheetObj.RowCount > 0) {
			sheet1_OnClick(sheetObj,1, 1, "");	
		} else {
			sheetObjects[1].RemoveAll();
		}
	}

    /**
     * Sheet의 조회 이벤트가 끝난 이후에 프로세스 처리
     */
	function sheet2_OnSearchEnd(sheetObj, ErrMsg)
	{

		setTotalRow(sheetObj)

 		ComColFontName(sheetObj, "slp_loc_cd", "Courier New"); 	
 		ComColFontName(sheetObj, "eff_dt", "Courier New"); 	
 		ComColFontName(sheetObj, "csr_amt", "Courier New"); 	

	}

    /**
     * Sheet의 클릭 이벤트시 프로세스 처리
     */
	function sheet1_OnClick(sheetObj,Row, Col, Value)
	{
		var formObject = document.form;

		if (Row > 0) {
			//CSR No.
			formObject.csr_no.value = sheetObj.CellValue(Row, "csr_no");
         	
         	doActionIBSheet(sheetObjects[1],formObject,IBSEARCH,'Y');
		} 		

	}

     /**
      * 합계 행에 대해 처리
      */
    function setTotalRow(sheetObj) {

		//<TR SUM='TRUE'> 합계 행을 자동으로 만들기 위해서는 왼쪽과 같이 설정해야 함.
		sheetObj.SumText(0,"slp_seq_no") = '';
		sheetObj.SumText(0,"slp_loc_cd") = 'Total Amount';
		sheetObj.SumText(0,"eff_dt") = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "csr_curr_cd");
		if (sheetObj.LastRow > 1) {
			sheetObj.CellAlign(sheetObj.LastRow-1,"slp_loc_cd") = daCenter;
			sheetObj.CellAlign(sheetObj.LastRow-1,"eff_dt") = daCenter;
		}
		
		sheetObj.RowHidden(sheetObj.LastRow) = true;
		
	}

    /**
   	 * 페이지에 있는 RD Object를 로드한다. <br>
   	 * {@link #loadPage}함수에서 이 함수를 호출하여 RD Object를 초기화 한다. <br>
   	 * @param {rdObject} rdObject    RD Object
   	 **/
   	function initRdConfig(rdObject){
   	    var Rdviewer = rdObject ;
   	    Rdviewer.style.height = 0;
   	    Rdviewer.style.width = 0;
   	    
   	    Rdviewer.AutoAdjust = true;
   	    Rdviewer.ViewShowMode(0);

   		Rdviewer.setbackgroundcolor(128,128,128);
   		Rdviewer.SetPageLineColor(128,128,128);
   	}

    /**
   	 * 인쇄를 실행한다. <br>
   	 * {btn_print}함수에서 이 함수를 호출하여 인쇄를 실행한다. <br>
   	 * @param {rdObject} rdObject    RD Object
   	 * @param {formObject} formObject    Form Object
   	 **/
 	function rdOpen(rdObject, formObject){
		var Rdviewer = rdObject ;

		queryStr = RD_FormQueryString(formObject,1);

		var rdParam = '/rv '+queryStr;

		var rdFile = 'ESM_FMS_031.mrd';

		// 열고자 하는 RD 파일을 지정한다.
	    Rdviewer.FileOpen(RD_path+'apps/alps/esm/fms/timecharterinoutaccounting/tcharterioconsultation/report/'+rdFile, RDServer + rdParam + " /rop /rprintnexit ");
 	}
 	
 	function rdOpenPreview(rdObject, formObject){

		queryStr = RD_FormQueryString(formObject,1);

		var rdParam = '/rv '+queryStr;

		var strPath = 'apps/alps/esm/fms/timecharterinoutaccounting/tcharterioconsultation/report/ESM_FMS_031.mrd';

		formObject.com_mrdPath.value = strPath;
		formObject.com_mrdArguments.value = rdParam;
        ComOpenRDPopupModal('resizable=yes;dialogWidth:750px;dialogHeight:690px');  
 	}
		
	/* 개발자 작업  끝 */ 
