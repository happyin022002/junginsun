/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0153.js
*@FileTitle : Chinese Booking Agent
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.06.08 김기종
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
     * @class esm_bkg_0153 : esm_bkg_0153 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0153() {
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
    	var sheetObject1 = sheetObjects[0];
    	/*******************************************************/
    	var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

    		switch(srcName) {    					
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
				
				case "btn_downexcel":
					sheetObject1.SpeedDown2Excel(-1);
					break;			
				
				case "btn_save":
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
					break;
				
				case "btn_add":
					doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
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
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		initControl();
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
    	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
    	var formObj = document.form;
        var cnt = 0;
		var sheetID = sheetObj.id;
				
        switch(sheetID) {
            case "sheet1":      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 400;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;
                    if (ComGetObjValue(formObj.screenName).indexOf("Q") > -1) {
                    	Editable = false;
                    }

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 2, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(20, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

					var HeadTitle1 = "|Control\nOffice|Agent\nCode|Customer\nCode|Customer\nCode|Booking Agent Name|Financial\nOffice|BKG\nBlock|Vendor|Vendor|Dir.\nPay|Remark(s)|Email Address|Auto\nEmail|Creation|Creation|Creation|||";
					var HeadTitle2 = "|Control\nOffice|Agent\nCode| | |Booking Agent Name|Financial\nOffice|BKG\nBlock| | |Dir.\nPay|Remark(s)|Email Address|Auto\nEmail|Date|By|Office|||";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                                        
                    //데이터속성    [ROW, COL,  DATATYPE,   				WIDTH, 	DATAALIGN, 		COLMERGE, 		SAVENAME,  			KEYFIELD, 		CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,			30,		daCenter,		true,			"ibflag");
					
					InitDataProperty(0, cnt++ , dtData ,				65,		daCenter,		true,			"finc_ofc_cd",		true,			"",      dfEngUpKey,		0,		false,		false,		5,		5);
					InitDataProperty(0, cnt++ , dtData ,				53,		daCenter,		true,			"chn_agn_cd",		true,			"",      dfEngUpKey,		0,		false,		false,		2,		2);
					InitDataProperty(0, cnt++ , dtData ,				38,		daCenter,		true,			"cust_cnt_cd",		true,			"",      dfEngUpKey,		0,		true,		true,		2,		2);
                                                                                    		                                      
					InitDataProperty(0, cnt++ , dtData ,				50,		daCenter,		true,			"cust_seq",			true,			"",      dfNone ,			0,		true,		true,		6);
					InitDataProperty(0, cnt++ , dtData,					220,	daLeft,	  		true,			"agn_nm",			false,			"",      dfNone,			0,		false,		false		);
					InitDataProperty(0, cnt++ , dtData,					60,		daCenter,		true,			"ofc_cd",			false,			"",      dfNone,			0,		false,		false,		5,		5);
				    InitDataProperty(0, cnt++ , dtCheckBox,				60,		daCenter,		true,			"bkg_blck_flg",		false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData ,				35,		daCenter,		true,			"vndr_cnt_cd",		false,			"",      dfEngUpKey,		0,		false,		false,		2,		2);
					InitDataProperty(0, cnt++ , dtData ,				60,		daCenter,		true,			"vndr_seq",			false,			"",      dfNone   	,		0,		false,		false,		6,		6);

					InitDataProperty(0, cnt++ , dtData,					65,		daCenter,		true,			"dir_pay_ofc_cd",	false,			"",      dfEngUpKey,		0,		true,		true,		5,		5);
					InitDataProperty(0, cnt++ , dtData,					200,	daLeft,		    true,			"diff_rmk",			false,			"",      dfNone,			0,		true,		true,		30);
					InitDataProperty(0, cnt++ , dtData ,				200,	daLeft,		    true,			"agn_eml",			false,			"",      dfEngKey,			0,		true,		true,		100);
					InitDataProperty(0, cnt++ , dtHidden,				40,		daCenter,		true,			"auto_eml_flg",		false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					70,		daCenter,		true,			"upd_dt",			false,			"",      dfDateYmd,			0,		false,		false);
					                                                                                                                              
					InitDataProperty(0, cnt++ , dtData,					100,	daCenter,		true,			"upd_usr_id",		false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					40,		daCenter,		true,			"upd_ofc_cd",		false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,				40,		daCenter,		true,			"auto_dp_chk_flg",	false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,				40,		daCenter,		true,			"origin_vndr",		false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,				40,		daCenter,		true,			"origin_cust",		false,			"",      dfNone,			0,		false,		false);
					
					FocusEditMode = -1;					
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
		        	  sheetObj.DoSearch("ESM_BKG_0153GS.do", FormQueryString(formObj)
								+ "&" + ComGetPrefixParam(""));
				}	  
		        break;
		        
			case IBSAVE:        //저장
				if(validateForm(sheetObj,formObj,sAction)) {					
					formObj.f_cmd.value = MULTI;
					sheetObj.DoSave("ESM_BKG_0153GS.do", FormQueryString(formObj));
    			}
                break;
                
			case IBINSERT:      // 입력
				//신규행 추가
 				sheetObj.DataInsert(-1);
                break;
        }
    }
      
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {	
    	if (ErrMsg == "") {
    		ComBkgSaveCompleted();  //서버메세지 처리
		} 	 	
    }
      
    function sheet1_OnAfterEdit(sheetObj,Row,Col){
	    var formObj = document.form;
	    var param ;
	    var sheet2= sheetObjects[1];
	  	   
	    with (sheetObj) {
    	    var sName = ColSaveName(Col);
    	    if (CellValue(Row,Col) =="") return;
    	    var cust_cd = CellValue(Row,"cust_cnt_cd")+ CellValue(Row,"cust_seq");
    	   
    	    if (sName == 'ofc_cd'){
				formObj.f_cmd.value = COMMAND01;
				param = param+"&f_cmd="+COMMAND01;
				param = param+"&ofc_cd="+CellValue(Row,Col);
				
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0153GS.do", param);
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == 'F') {
					if (sXml != "") LoadSearchXml(sXml);
					//CellValue2(Row,Col) = "";
					SelectCell(Row,Col,false);
					return;
				}
				CellValue2(Row, "finc_ofc_cd")= ComGetEtcData(sXml,"ar_ofc_cd");
    	    } else if (sName == 'cust_cnt_cd'){
    		    if (CellValue(Row,'cust_seq') != ""){
    			   	formObj.f_cmd.value = COMMAND02;
    			   	param = param+"&f_cmd="+COMMAND02;
    			   	param = param+"&cust_cnt_cd="+CellValue(Row,"cust_cnt_cd");
 				    param = param+"&cust_seq="+CellValue(Row,"cust_seq");
 				    
 				    var cust_cd = CellValue(Row,"cust_cnt_cd")+ CellValue(Row,"cust_seq");
 				    if (cust_cd == CellValue(Row,"origin_cust")){
 				    	return;
 				    }
					var sXml = sheetObj.GetSearchXml("ESM_BKG_0153GS.do", param);
					if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == 'F') {
						if (sXml != "") LoadSearchXml(sXml);
						SelectCell(Row,Col,false);
						return;
					}
					
					//CellValue2(Row, "agn_nm")= ComGetEtcData(sXml,"name");
    		    }
    	    } else if (sName == 'cust_seq'){
    		    formObj.f_cmd.value = COMMAND02;
    		    param = param+"&f_cmd="+COMMAND02;
			    param = param+"&cust_cnt_cd="+CellValue(Row,"cust_cnt_cd");
			    param = param+"&cust_seq="+CellValue(Row,"cust_seq");
			   
			    if (cust_cd == CellValue(Row,"origin_cust")){
			    	return;
			    }
			    var sXml = sheetObj.GetSearchXml("ESM_BKG_0153GS.do", param);
			   
			    if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == 'F') {
				    LoadSearchXml(sXml);
					SelectCell(Row,Col,false);
					return;
			    }
			    //CellValue2(Row, "agn_nm")= ComGetEtcData(sXml,"name");
    	    }
	    }
    }
	    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        	switch(sAction) {
				case IBSAVE: 
	            	var rowM = sheetObj.ColValueDup("ofc_cd|chn_agn_cd|cust_cnt_cd|cust_seq|agn_nm");
					if (rowM >= 0) {
						 ComShowCodeMessage("BKG03833", "Sheet", rowM); //BKG00833
					     return false;
				    }	 
					break;
				
				case IBSEARCH: // 저장시 확인
	         		if (!ComChkValid(formObj)) return false;
	         		break;
        	}	
        }
        return true;
    }         

	/* 개발자 작업  끝 */