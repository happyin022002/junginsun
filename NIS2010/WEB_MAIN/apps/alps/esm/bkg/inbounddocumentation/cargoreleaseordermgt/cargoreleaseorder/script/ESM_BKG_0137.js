/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0137.js
*@FileTitle : Cargo Release Order의 Office Default From Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 안진응
*@LastVersion : 1.0
* 2009.07.02 안진응
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
     * @class esm_bkg_0137 : esm_bkg_0964 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0137() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm           = validateForm;
    }

    /* 개발자 작업  */

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

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,document.form,IBSEARCH);
				break;
				
				case "btn_Delete":
					doActionIBSheet(sheetObject1,document.form,IBDELETE);
				break;
				
				case "btn_Save":
					doActionIBSheet(sheetObject1,document.form,IBINSERT);
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
 		
        initControl();

        ComSetFocus(document.form.office);

        if(document.getElementById("office").value !='' ){
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        }
    }

	/**
	 * 화면의 Control의 초기값과 이벤트를 설정한다.
	 */
    function initControl() {
    	var formObject = document.form;
    	  
    	formObject.office.value = formObject.office_cd.value;	//세션에서 읽은 OFFICE 코드를 화면에 표시한다.
    	formObject.do_fom_prv_cd[0].checked = true;			//D/O 값을 디폴트 설정
    	formObject.locl_lang_flg.disabled = false;
    	formObject.locl_lang_flg.value = 'Y';					//English 값을 디폴트 설정
    	  
    	axon_event.addListenerForm  ('blur',     'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
    	axon_event.addListenerFormat('keypress', 'obj_keypress',    form); //- 키보드 입력할때
        axon_event.addListener  ('change'  , 'office_change', 'office');			//- Office 입력 후 From~To 비교
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
            case "sheet1":      //sheet1 init
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
                    InitRowInfo( 1, 1, 3, 100);

 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(8, 4, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, false, false, true, false,false)

                    var HeadTitle1 = "ibflag|ofc_cd|do_fom_prv_cd|locl_lang_flg|addr_ctnt|do_prn_rmk|auth_ctnt|del_chk";
                                         
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    var prefix="sheet1_";

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 	                InitDataProperty(0, cnt++ , dtHiddenStatus,	     0,    daCenter,    true,  	  prefix + "ibflag"); 					  
 				    InitDataProperty(0, cnt++ , dtData,      	   125,    daCenter,    true,     prefix + "ofc_cd",      	  false,    "",      dfNone, 			0,     false,		false);
 					InitDataProperty(0, cnt++ , dtData,      	   100,    daCenter,    true,     prefix + "do_fom_prv_cd",   false,    "",      dfNone, 			0,     false,		false);
  					InitDataProperty(0, cnt++ , dtData,      	    60,    daCenter,    true,     prefix + "locl_lang_flg",   false,    "",      dfNone, 			0,     false,		false);                                                                                                                                            	
 					InitDataProperty(0, cnt++ , dtData,      	    50,    daCenter,    true,     prefix + "addr_ctnt",       false,    "",      dfNone, 			0,     false,		false);
					InitDataProperty(0, cnt++ , dtData,      	   120,    daCenter,    true,     prefix + "do_prn_rmk",      false,    "",      dfNone, 	        0,     false,		false);
					InitDataProperty(0, cnt++ , dtData,      	    50,    daCenter,    true,     prefix + "auth_ctnt",       false,    "",      dfNone,			0,     false,		false);
					InitDataProperty(0, cnt++ , dtDelCheck,         50,    daCenter,    true,     prefix + "del_chk",         false,    "",      dfNone,			0,     false,		false);
                }
                break;
        }
    }      

    /**
     * Sheet관련 프로세스 처리
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	//sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				formObj.f_cmd.value = SEARCH;
                if(sheetObj.id == "sheet1"){
                	sheetObj.DoSearch("ESM_BKG_0137GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
                }
			break;
			
			case IBDELETE:        //삭제
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				formObj.f_cmd.value = REMOVE;
				
                var curRow = 1;
                var prefix="sheet1_";
            	 
            	sheetObj.CellValue2(curRow,prefix + "del_chk") = 1; 	
            	
                var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
                
                sheetObj.DoSave("ESM_BKG_0137GS.do", sParam, "", false);
			
			break;    					

			case IBINSERT:      // 입력
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				formObj.f_cmd.value = MULTI;
				
				copyFormToRow();
            	
                var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
                sheetObj.DoSave("ESM_BKG_0137GS.do", sParam, "", false);
			
			break;
        }
    }     
     
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
   		switch(sAction) {       	 
		case IBSEARCH:
            if(ComIsEmpty(formObj.office.value)){
                //ComShowCodeMessage('BKG00545');
                
                ComShowCodeMessage('BKG00887', 'Office');
                formObj.office.focus();
                return false;
            }

    		break;
    	
    	case IBDELETE:
    		
    		if (document.form.qryFlag.value != "Y") {
				ComShowCodeMessage('BKG00448');
    			return false;
    		}

    		if(sheetObj.RowCount == 0){
    	    	ComShowCodeMessage("BKG00155");
    	        return false;
    	    }
    		
	        break; 
    	case IBINSERT:
    		if (document.form.qryFlag.value != "Y") {
				ComShowCodeMessage('BKG00448');
    			return false;
    		}
    		
            if(ComIsEmpty(formObj.office.value)){
                ComShowCodeMessage('BKG00715', 'Office');
                formObj.office.focus();
                return false;
            }
            
            if(ComIsEmpty(formObj.addr_ctnt.value)){
            	formObj.addr_ctnt.value = " ";
            }

            if(ComIsEmpty(formObj.do_prn_rmk.value)){
            	formObj.do_prn_rmk.value = " ";
            }
            
            if(ComIsEmpty(formObj.auth_ctnt.value)){
            	formObj.auth_ctnt.value = " ";
            }
            
	        break; 
		}
		
    	return true;
   	}

         
    /**
     * 업무 자바스크립트 Blur 이벤트 처리
     */
    function obj_deactivate(){
    	//입력Validation 확인 및 마스킹 처리
        ComChkObjValid(event.srcElement);
    }

    /**
     * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
     **/
    function obj_keypress(){
    	switch(event.srcElement.dataformat){
            case "float":
            	//숫자+"."입력하기
                ComKeyOnlyNumber(event.srcElement, ".");
                break;
            case "eng":
                //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
                //ComKeyOnlyAlphabet();
                ComKeyOnlyAlphabet('uppernum');
                break;
            case "engdn":
                //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
                ComKeyOnlyAlphabet('lower');
                break;
            case "engup":
                //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
                ComKeyOnlyAlphabet('upper');
                break;
            default:	
                //숫자만입력하기(정수,날짜,시간)
                ComKeyOnlyNumber(event.srcElement);
            }
    }
         
    /**
     * Hidden IBSheet를 조회하고 나서 처리할 사항
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	var formObj = document.form;
     	
        if (ErrMsg == "") {
            if(sheetObj.RowCount > 0){
                //Grid의 Data를 Html의 인자값으로 Copy한다.
                var curRow = 1;
                var prefix="sheet1_";

                if (sheetObj.CellValue(curRow,prefix + "do_fom_prv_cd") == "DO") {
                	formObj.do_fom_prv_cd[0].checked = true;
                	formObj.locl_lang_flg.disabled = false;

                } else if (sheetObj.CellValue(curRow,prefix + "do_fom_prv_cd") == "BL") {
                	formObj.do_fom_prv_cd[1].checked = true;
                	formObj.locl_lang_flg.disabled = true;
                } else {
                	formObj.do_fom_prv_cd[2].checked = true;
                	formObj.locl_lang_flg.disabled = true;
                }
                formObj.locl_lang_flg.value = sheetObj.CellValue(curRow,prefix + "locl_lang_flg");
                formObj.addr_ctnt.value = sheetObj.CellValue(curRow,prefix + "addr_ctnt");
                formObj.do_prn_rmk.value = sheetObj.CellValue(curRow,prefix + "do_prn_rmk");
                formObj.auth_ctnt.value = sheetObj.CellValue(curRow,prefix + "auth_ctnt");
            } else {
            	initForm();
            }
        } else {
            ComShowMessage(ErrMsg);
        }
         
        formObj.qryFlag.value = "Y";
    }
         
    /**
    * 화면의 값을 초기화한다.
    */
    function initForm() {
		var formObject = document.form;
		  
		formObject.do_fom_prv_cd[0].checked = true;			//D/O 값을 디폴트 설정
		formObject.locl_lang_flg.value = 'Y';					//English 값을 디폴트 설정        	  
		formObject.locl_lang_flg.disabled = false;
		  
		formObject.addr_ctnt.value  = '';
		formObject.do_prn_rmk.value = '';
		formObject.auth_ctnt.value  = '';
    }
          
    /**
     * sheet1를 저장하고 나서 처리할 사항
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg){

        if (ErrMsg == "") {
	    	if (document.form.f_cmd.value == REMOVE) {
	            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	            ComBkgSaveCompleted();  //서버메세지 처리
	              
	            initForm();            		  
	    	} else {
	    	    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	    		ComBkgSaveCompleted();  //서버메세지 처리
	    		document.form.qryFlag.value = "Y";
	    	}
	    	
        }

        if (typeof(opener) == "object") {
        	self.close();
        }
        
    }         
          
    /**
     * 화면에 입력한 값을 sheet1에 Copy한다.
     */
    function copyFormToRow() {
	    var rowCnt = sheetObjects[0].RowCount;
	    var prefix="sheet1_";
	  
	    if (rowCnt > 0) {		//기존 자료가 존재하는 경우
//          2010.04.09 수정 지침에 따라서 수정(안진응)
//		    sheetObjects[0].CellValue2(rowCnt,prefix + "ibflag") = "U";
	    	sheetObjects[0].RowStatus(rowCnt) = "U";
	    } else {				//신규 입력인 경우
		    rowCnt = sheetObjects[0].DataInsert(-1);
//      2010.04.09 수정 지침에 따라서 수정(안진응)
//	  	    sheetObjects[0].CellValue2(rowCnt,prefix + "ibflag") = "I"; 	
	  	    sheetObjects[0].RowStatus(rowCnt) = "I";
	    }
    	  
	    sheetObjects[0].CellValue2(rowCnt,prefix + "ofc_cd") = document.form.office.value;
	  
        if (document.form.do_fom_prv_cd[0].checked == true) {
    	    sheetObjects[0].CellValue2(rowCnt,prefix + "do_fom_prv_cd") = document.form.do_fom_prv_cd[0].value;
        } else if (document.form.do_fom_prv_cd[1].checked == true) {
    	    sheetObjects[0].CellValue2(rowCnt,prefix + "do_fom_prv_cd") = document.form.do_fom_prv_cd[1].value;
        } else {
    	    sheetObjects[0].CellValue2(rowCnt,prefix + "do_fom_prv_cd") = document.form.do_fom_prv_cd[2].value;
        }
	  
	    sheetObjects[0].CellValue2(rowCnt,prefix + "locl_lang_flg") = document.form.locl_lang_flg.value;
	    sheetObjects[0].CellValue2(rowCnt,prefix + "addr_ctnt") = document.form.addr_ctnt.value;
	    sheetObjects[0].CellValue2(rowCnt,prefix + "do_prn_rmk") = document.form.do_prn_rmk.value;
	    sheetObjects[0].CellValue2(rowCnt,prefix + "auth_ctnt") = document.form.auth_ctnt.value;
    }
          
    /**
     * 화면의 값을 Clear한다.
     **/
    function office_change() {
    	document.form.qryFlag.value = "";
      	return true;
    }
           
    /**
    * Radio 버튼 클릭 시 값을 체크한다.
    **/
    function fnRadioCheck() {
        if (document.form.do_fom_prv_cd[0].checked == true) {
    	    document.form.locl_lang_flg.disabled = false;
        } else {
    	    document.form.locl_lang_flg.disabled = true;
        }
    }
    /* 개발자 작업  끝 */