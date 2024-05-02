/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1600.js
*@FileTitle : C/A Issue Reason Selection
*Open Issues : ESM_BKG_1600 화면
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.13 
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
     * @class esm_bkg_1600 : esm_bkg_1600 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_1600() {
    	this.processButtonClick		 = tprocessButtonClick;
    	this.setSheetObject 		 = setSheetObject;
    	this.loadPage 				 = loadPage;
    	this.initSheet 				 = initSheet;
    	this.setComboObject          = setComboObject;
    	this.doActionIBSheet 		 = doActionIBSheet;
    }
    
   	/* 개발자 작업	*/

    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;    

    var prefix1 = "sheet1_";
    var prefix2 = "sheet2_";
    var prefix3 = "sheet3_";
    var prefix4 = "sheet4_";
    
    var comboObjects = new Array();
    var comboCnt = 0;
       
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        sheetObject1 = sheetObjects[0];
        sheetObject2 = sheetObjects[1];
        /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_request":				
					// validation
					if (!validateForm(sheetObjects[0], document.form, IBSAVE)) return;
					
					// 승인자 지정
					var rValue = ComOpenPopup("/hanjin/ESM_BKG_1604.do?", 820, 405, 'getApprovalUser','0,0', true, true);
	    	        if(rValue == null){
	    	            return false;
	    	        }
					getApprovalUser(rValue);
					
					// Request 내역 저장 및 메일전송
					doActionIBSheet(sheetObjects[0], document.form, IBSAVE); 
			    	break;
			    	
				case "btn_cancel":
					self.close();
					break;
            } // end switch
    	}catch(e) {
    		ComShowMessage(e);
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
     * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
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
        for(var i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);         	
            ComEndConfigSheet(sheetObjects[i]);            
        }
        

        initControl(); 
        
        //initParam();  //form 객체에 한번만
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH); 
    }
     
    function initControl() {
  	    var formObj = document.form;
  	    axon_event.addListenerFormat('keypress', 'bkg1600_keypress', formObj);  //- 키보드 입력할때
  	}
    
    function bkg1600_keypress() {
    	var srcName = window.event.srcElement.getAttribute("name");
    	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	    switch(event.srcElement.dataformat){           
	        case "etc": //모든 문자 가능하지만 영문은 대문자로
		        if(keyValue >= 97 && keyValue <= 122) {//소문자
	                event.keyCode = keyValue + 65 - 97;
	            }
	        	break;	
        	
		    default:
		    	break;
	    }
    }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
		switch(sheetObj.id) {
			case "sheet1":      //t4sheet1 init
		        with (sheetObj) {
		            // 높이 설정
		            style.height = 85;
		            //전체 너비 설정
		            SheetWidth = mainTable.clientWidth;
		
		            //Host정보 설정[필수][HostIp, Port, PagePath]
		            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		            //전체Merge 종류 [선택, Default msNone]
		            MergeSheet = msNone;
		
		           //전체Edit 허용 여부 [선택, Default false]
		            Editable = true;
		
		            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		            InitRowInfo(1, 1, 10, 100);
		
		            var HeadTitle = " Chk||Type|Amend Reason";
		            var headCount = ComCountHeadTitle(HeadTitle);
		            		            
		            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(headCount, 0, 0, true);
		
		            // 해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(true, true, false, true, false,false);
		
		            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle, true);
		
		            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		            //dtRadioCheck
		            InitDataProperty(0,	cnt++,	dtRadioCheck,	30 ,  daCenter,	     false,	  prefix1 + "radio",     false,    "",      dfNone,	      0,     true,       true);
		            InitDataProperty(0, cnt++ , dtHiddenStatus,	50,   daCenter,  	 false,   prefix1 + "ibflag",    false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtHidden,  	    60,   daCenter,  	 false,   prefix1 + "val",       false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,     	120,  daLeft,  	     false,   prefix1 + "name",      false,    "",      dfNone,         0,     false,      false);
		        }
		        break;
			case "sheet2":      //t4sheet1 init
		        with (sheetObj) {
		            // 높이 설정
		            style.height = 80;
		            //전체 너비 설정
		            SheetWidth = mainTable.clientWidth;
		
		            //Host정보 설정[필수][HostIp, Port, PagePath]
		            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		            //전체Merge 종류 [선택, Default msNone]
		            MergeSheet = msNone;
		
		           //전체Edit 허용 여부 [선택, Default false]
		            Editable = true;
		
		            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		            InitRowInfo(1, 1, 10, 100);
		
		            var HeadTitle = " |Charge|Cur|Per|As-Is\nAmount|To-Be\nAmount|Diff|bkg_no";
		            var headCount = ComCountHeadTitle(HeadTitle);
		            		            
		            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(headCount, 0, 0, true);
		
		            // 해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(true, true, false, true, false,false);
		
		            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle, true);
		
		            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		            //dtRadioCheck
		            InitDataProperty(0, cnt++ , dtHiddenStatus,	50,   daCenter,  	 false,   prefix2 + "ibflag",       false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,  	    50,   daCenter,  	 false,   prefix2 + "chg_cd",       false,    "",      dfEngUpKey,         0,     false,      false, 3);
		            InitDataProperty(0, cnt++ , dtData,  	    50,   daCenter,  	 false,   prefix2 + "curr_cd",      true,     "",      dfEngUpKey,         0,     false,        false, 3);
		            InitDataProperty(0, cnt++ , dtData,  	    50,   daCenter,  	 false,   prefix2 + "rat_ut_cd",    true,     "",      dfEngUpKey,         0,     true,        false, 2);
		            InitDataProperty(0, cnt++ , dtData,  	    85,   daRight,  	 false,   prefix2 + "crnt_chg_amt", true,     "",      dfFloat,    2,     false,        false);
		            InitDataProperty(0, cnt++ , dtData,  	    85,   daRight,  	 false,   prefix2 + "amd_chg_amt",  true,     "",      dfFloat,    2,     false,        false);
		            InitDataProperty(0, cnt++ , dtData,  	    85,   daRight,  	 false,   prefix2 + "diff_chg_amt", false,    "|sheet2_amd_chg_amt|-|sheet2_crnt_chg_amt|",      dfNullFloat,         2,     false,      false);
		            InitDataProperty(0, cnt++ , dtHidden,  	    85,   daRight,  	 false,   prefix2 + "bkg_no",       true,     "",      dfNone,         0,     false,      false);
		            
		        }
		        break;
		        
			case "h1sheet1":      //hidden h1sheet1
				with (sheetObj) {
					// 높이 설정
					style.height = 0;
					
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 20, 100);
					
					var HeadTitle = "|bkg_no|chg_amd_rsn_cd|chg_amd_rmk|apro_usr_id|apro_ofc_cd";
					var headCount = ComCountHeadTitle(HeadTitle);
			
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
										
					//데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,	cnt++,	dtRadioCheck,	30 , 	daCenter,	false,	prefix3 + "radio",          false,  "", dfNone,	    0,      true, true);
					InitDataProperty(0,	cnt++,	dtData,			70 , 	daCenter,	false,	prefix3 + "bkg_no",         false,	"",	dfNone,		0,		true, true);
					InitDataProperty(0,	cnt++,	dtData,			70 , 	daCenter,	false,	prefix3 + "chg_amd_rsn_cd", false,	"",	dfNone,		0,		true, true);
					InitDataProperty(0,	cnt++,	dtData,			300, 	daCenter,	false,	prefix3 + "chg_amd_rmk",    false,	"",	dfNone,		0,		true, true);
					InitDataProperty(0,	cnt++,	dtData,			70 , 	daCenter,	false,	prefix3 + "apro_usr_id",    false,	"",	dfNone,		0,		true, true);
					InitDataProperty(0,	cnt++,	dtData,			70 , 	daCenter,	false,	prefix3 + "apro_ofc_cd",    false,	"",	dfNone,		0,		true, true);
					
					DataInsert(-1);
				}
		        break; 
		        
			case "h1sheet2":      //hidden h1sheet2
				with (sheetObj) {
					// 높이 설정
					style.height = 0;
					
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 20, 100);
					
					var HeadTitle = "|bkg_no|apro_rqst_ref_tp_cd|apro_rqst_ref_usr_seq|apro_rqst_ref_usr_ofc_cd|apro_rqst_ref_usr_id|apro_rqst_ref_usr_eml";
					var headCount = ComCountHeadTitle(HeadTitle);
			
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
										
					//데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, prefix4 + "ibflag");
					InitDataProperty(0,	cnt++,	dtData,			70 , 	daCenter,	false,	prefix4 + "bkg_no",         false,	"",	dfNone,		0,		true, true);
					InitDataProperty(0,	cnt++,	dtData,			70 , 	daCenter,	false,	prefix4 + "apro_rqst_ref_tp_cd", false,	"",	dfNone,		0,		true, true);
					InitDataProperty(0,	cnt++,	dtData,			300, 	daCenter,	false,	prefix4 + "apro_rqst_ref_usr_seq",    false,	"",	dfNone,		0,		true, true);
					InitDataProperty(0,	cnt++,	dtData,			70 , 	daCenter,	false,	prefix4 + "apro_rqst_ref_usr_ofc_cd",    false,	"",	dfNone,		0,		true, true);
					InitDataProperty(0,	cnt++,	dtData,			70 , 	daCenter,	false,	prefix4 + "apro_rqst_ref_usr_id",    false,	"",	dfNone,		0,		true, true);
					InitDataProperty(0,	cnt++,	dtData,			70 , 	daCenter,	false,	prefix4 + "apro_rqst_ref_usr_eml",    false,	"",	dfNone,		0,		true, true);
					
				}
		        break; 
		}
	}

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;
        var aryPrefix = new Array(prefix1, prefix2, prefix3, prefix4);
        
        switch(sAction) {
      	    case IBSEARCH: 
      	    	formObj.f_cmd.value = SEARCH;      	    	
      			var sXml = sheetObj.GetSearchXml("ESM_BKG_1600GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
      			var arrXml = sXml.split("|$$|");      			
      			var State = ComGetEtcData(arrXml[0],"TRANS_RESULT_KEY");      			
      			if ( State == "S" ) {
      				for ( var inx = 0; inx < arrXml.length; inx++) {
      					sheetObjects[inx].LoadSearchXml(arrXml[inx]);
      				}
      			}
      				
                break;
                
     		case IBSAVE:
                formObj.f_cmd.value = MULTI;
                var nChkRow = sheetObj.FindCheckedRow(prefix1 + "radio");
                var arrRow = nChkRow.split("|");
                if (arrRow.length > 0) {
                	sheetObjects[2].CellValue(1, prefix3 + "chg_amd_rsn_cd") = sheetObj.CellValue(arrRow[0], prefix1 + "val");
                }
                
                sheetObjects[2].CellValue(1, prefix3 + "bkg_no") = formObj.bkg_no.value;
                sheetObjects[2].CellValue(1, prefix3 + "chg_amd_rmk") = formObj.chg_amd_rmk.value;                
                
                var sParam = ComGetSaveString(sheetObjects, true, true); // 전체 sheet문자열
        		if (sParam == "")
        			return false;
        		sParam += "&" + FormQueryString(formObj); // hidden param value 문자열
        		sParam += "&" + ComGetPrefixParam(aryPrefix);// prefix 문자열 배열
        		ComOpenWait(true); // 대기창 보임
        		
        		// 2.저장처리
        		var sXml = sheetObj.GetSaveXml("ESM_BKG_1600GS.do", sParam);
        		// 3.저장후 결과처리
        		var State = ComGetEtcData(sXml,"TRANS_RESULT_KEY");
        		if(State != null){
        			if ( State == "S" ) {
        				sheetObj.LoadSaveXml(sXml);
        				ComShowMessage(ComGetMsg("BKG06173", formObj.chg_cd.value));
        				this.close();
        			} else {
        				fnExceptionMessage(sXml);
        			}
        		}
	            break;
        }
        ComOpenWait(false); // 대기창 사라짐
    }
    
    function getApprovalUser(rValue){
    	if (rValue == null || rValue == undefined ) return;

    	var formObj = document.form;
    	var sheetObj = sheetObjects[3];
    	var obj = rValue;
    	var cnt = obj.length;
		for ( var z = 0; z < cnt; z++) {
			if(undefined == obj[z]) break;
			if( '' == obj[z].apro_rqst_ref_tp_cd || undefined == obj[z].apro_rqst_ref_tp_cd) continue;
			nRow = sheetObj.DataInsert(-1);
			sheetObj.CellValue(nRow, prefix4 + "bkg_no") = formObj.bkg_no.value;
			sheetObj.CellValue(nRow, prefix4 + "apro_rqst_ref_tp_cd")		= obj[z].apro_rqst_ref_tp_cd;
			sheetObj.CellValue(nRow, prefix4 + "apro_rqst_ref_usr_seq")		= obj[z].apro_rqst_ref_usr_seq;
			sheetObj.CellValue(nRow, prefix4 + "apro_rqst_ref_usr_ofc_cd")	= obj[z].apro_rqst_ref_usr_ofc_cd;
			sheetObj.CellValue(nRow, prefix4 + "apro_rqst_ref_usr_id")		= obj[z].apro_rqst_ref_usr_id;
			sheetObj.CellValue(nRow, prefix4 + "apro_rqst_ref_usr_eml")		= obj[z].apro_rqst_ref_usr_eml;
		}
		return;
    }

    
    //######################[1. Event]############################################################
    /**
    * 저장완료시, 
    */  
    
    /**
    * 조회완료시, 
    */ 
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) { 
	   	var formObj = document.form;
	   	if (ErrMsg.trim().length > 0) {
	   		self.close();
	   		return;
	   	}
	   	
	   	var nSRow = sheetObj.FindText(prefix1 + "val", sheetObj.EtcData(prefix1 + "chg_amd_rsn_cd"));	   	
	   	if (nSRow > -1) {
	   		sheetObj.CellValue2(nSRow, prefix1 + "radio") = 1;
	   	}
	   	
	   	//02. Booking 상태별 : CA 관련 버튼 초기화 
	   	initControl(); 
    }
    
    function sheet2_OnAfterEdit(sheetObj, Row, Col, Value) {
    	var formObj 		= document.form;
    	if (sheetObj.ColSaveName(Col) == prefix2 + "curr_cd") {
			//------------------------------------------------>
			/*
			 * 등록되어 있지 않은 currency code 입력 했을 경우에 다음 error message 표시해 주고
			 * blank 처리“XXX is not registered code. Please check the charge
			 * code again.” cmd = SEARCHLIST18
			 */
			var curr_cd = sheetObj.CellValue(Row, prefix2 + "curr_cd");
			if(curr_cd == '' || undefined == curr_cd) return;
			var param = param + "&f_cmd=" + SEARCHLIST18 + "&input_text=" + curr_cd;
			var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
			var output_text = ComGetEtcData(sXml, "output_text");
			if ('Y' != output_text) {
				ComShowCodeMessage("BKG00898");
				return ;
			}
		} else if (sheetObj.ColSaveName(Col) == prefix2 + "rat_ut_cd") {
			//------------------------------------------------>
			/*
			 * 등록되어 있지 않은 currency code 입력 했을 경우에 다음 error message 표시해 주고
			 * blank 처리“XXX is not registered code. Please check the charge
			 * code again.” cmd = SEARCHLIST18
			 */
			var rat_ut_cd = sheetObj.CellValue(Row, prefix2 + "rat_ut_cd");
			if(rat_ut_cd == '' || undefined == rat_ut_cd) return;
			var param = param + "&f_cmd=" + COMMAND01 + "&input_text=" + rat_ut_cd;
			var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
			var output_text = ComGetEtcData(sXml, "output_text");
			if ('Y' != output_text) {
				ComShowCodeMessage("BKG00901");
				return ;
			}		

		}
    }
	
	//######################[2. Etc]##############################################################	    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, formObj, sAction){
	   	//1.기본체크-maxlength,필수입력 등 폼 전체 필드의 Validation 체크 
	   	if (!ComChkValid(formObj)) return false;
	   	 
	   	//2.업무체크-업무에서 필요한 Validation 체크 
	   	with(formObj) {
	         switch (sAction) {	                 
	             case IBSAVE: // 저장
	                 //01. Sheet 선택
	                 if (sheetObj.CheckedRows(prefix1 + "radio") <= 0) {
	                	 ComShowCodeMessage("BKG00249");
	                	 return false;
	                 } 
	                 //02. Remark 입력
	                 if (formObj.chg_amd_rmk.value == "") {
	                	 ComShowCodeMessage("BKG00888", "[Remark]");
	                	 formObj.chg_amd_rmk.focus();
	                	 return false;
	                 }
	                 //03. Amount 입력
	                 var cnt = sheetObjects[1].RowCount;
	                 if(cnt == 0){
	                	 ComShowCodeMessage("BKG95034", "[Amount]");
	                	 return false;
	                 }
	                 for(var i=1; i <= cnt; i++){
	                	 if(sheetObjects[1].CellValue(i, prefix2 + "curr_cd") == ""){
	                		 ComShowCodeMessage("BKG00887", "[Currency]");
	                		 return false;
	                	 } else {
	                		 var curr_cd = sheetObjects[1].CellValue(i, prefix2 + "curr_cd");
	                		 var param = "f_cmd=" + SEARCHLIST18 + "&input_text=" + curr_cd;
	                		 var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
	                		 var output_text = ComGetEtcData(sXml, "output_text");
	                		 if ('Y' != output_text) {
	                			 ComShowCodeMessage("BKG00898");
	                			 return ;
	                		 }	                		 
	                	 }
	                	 
	                	 if(sheetObjects[1].CellValue(i, prefix2 + "rat_ut_cd") == ""){
	                		 ComShowCodeMessage("BKG00887", "[Per]");
	                		 return false;
	                	 } else {
	                		 var rat_ut_cd = sheetObjects[1].CellValue(i, prefix2 + "rat_ut_cd");
	                		 var param = "f_cmd=" + COMMAND01 + "&input_text=" + rat_ut_cd;
	                		 var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
	                		 var output_text = ComGetEtcData(sXml, "output_text");
	                		 if ('Y' != output_text) {
	                			 ComShowCodeMessage("BKG00901");
	                			 return ;
	                		 }
	                	 }
	                	 
	                	 if(sheetObjects[1].CellValue(i, prefix2 + "crnt_chg_amt") == ""){
	                		 ComShowCodeMessage("BKG00887", "[As-Is Amount]");
	                		 return false;
	                	 }

	                	 if(sheetObjects[1].CellValue(i, prefix2 + "amd_chg_amt") == ""){
	                		 ComShowCodeMessage("BKG00887", "[To-Be Amount]");
	                		 return false;
	                	 }
	                 }
	                	 
	            	 break;
	         }
        }

        return true;
    }
    
    
    /**
    * fnExceptionMessage  
    * 에러처리 메세지 
    * @param 
    * @return 
    */
    function fnExceptionMessage(rXml){
    	var rMsg = ComGetEtcData(rXml,"Exception")
    	var rmsg = rMsg.split("<||>");
    	if(rmsg[3] != undefined && rmsg[3].length > 0) {
    		ComShowMessage(rmsg[3]);
    	}else{
    		sheetObjects[0].LoadSaveXml(rXml);
    	}
    }
    //#############################(3. Util/Etc)##################################################

    
	/* 개발자 작업  끝 */