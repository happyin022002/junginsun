/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ees_mnr_0093.js
 *@FileTitle : Scrapping/Donation Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.07
 *@LastModifier : WanGyu Kim
 *@LastVersion : 1.0
 * 2009.09.07 WanGyu Kim
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
 * @class ees_mnr_0093 : ees_mnr_0093 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ees_mnr_0093() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* ********* General Functions ************* */
	// 공통전역변수
	var comboObjects = new Array();
	var comboCnt = 0;
	var sheetObjects = new Array();
	var sheetCnt = 0;
	//파일업로드를 사용하기 위한 
	var uploadObjects = new Array();
	var uploadCnt = 0;
	//파일Seq저장변수 (추가될때 )
	var uploadFileSeq = "";   
    //저장버튼 타입 저장변수	
	var saveType = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         
        var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        var sheetObject3 = sheetObjects[2];
         
        /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {

					case "btn_Retrieve":
						doActionIBSheet(sheetObject1, document.form, IBSEARCH);
						break;
	
					case "btn_New":
						doActionIBSheet(sheetObjects[0], document.form, IBCLEAR, 1);
						break;
	
					case "btn_Save":
						//MEXBA-MEXSC 변경에 따른 신규 데이타 생성 막음
						if(currOfcCd == "MEXBA"){
							ComShowCodeMessage("MNR00357");		
							break; 
						}
						saveType = 1;
						doActionIBSheet(sheetObjects[0], document.form, IBSAVE, 1);
						break;
						
					case "btn_Confirm":
						saveType = 2;
						doActionIBSheet(sheetObjects[0], document.form, IBSAVE, 2);
						break;
						
					case "btn_Cancel":
						saveType = 3;
						doActionIBSheet(sheetObjects[0], document.form, IBSAVE, 3);
						break;
					
					case "iss_dt_cal":
						var cal = new ComCalendar();
						cal.select(formObject.iss_dt, 'yyyy-MM-dd');
						break;
						
					case "btn_yard_popup":
						ComOpenPopup('/hanjin/COM_ENS_061.do', 766, 485, 'getCOM_ENS_061', '1,0,1,1,1,1,1,1,1,1,1,1', true);       
						break; 

					case "btn_FileAdd":
						file_Insert(sheetObjects[1]);
						break;
	
					case "btn_FileDel":
						file_Remove(sheetObjects[1]);       
						break; 

            } // end switch
    	}catch(e) {
    		if (e == "[object Error]") {
    			ComFuncErrMsg(e);
    		} else {
    			ComFuncErrMsg(e);
    		}
    	}
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	// 버튼 설정
    	MnrWaitControl(true);
    	// IBMultiCombo초기화
    	for ( var k = 0; k < comboObjects.length; k++) {
    		initCombo(comboObjects[k], k + 1);
    	}
    	// IBSheet초기화
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		//Axon이벤트 초기화
		initControl();
		//파일업로드 초기화
		ComConfigUpload(uploadObjects[0], "/hanjin/MNR_INTGS.do"); 
		//화면초기화
		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR, 0);
    }

  	/**
     * IBCombo 기본 설정
     * @param	{IBCombo}	comboObj	초기설정될 콤보오브젝트 
     * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호
     */
    function initCombo(comboObj, comboNo) {
	    var cnt  = 0 ;
	    var formObject = document.form
	   
	    switch(comboNo) {
	    	case 1: 
	    	case 2: 
	    	case 3: 
	            with (comboObj) { 
				       SetColAlign("left");         
					   DropHeight = 160;  
			        }
	    	case 4: 
	    	case 5: 
	            with (comboObj) { 
			        SetColAlign("left");         
				    DropHeight = 160; 
				    SetColWidth("75");
					UseAutoComplete = true;
					UseEdit = true;
		        }
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
		var sheetID = sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 10, 100);

					var HeadTitle1 = "|||||||||||||||||";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	false,	"xtra_disp_seq",		false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	false,	"eq_knd_cd",			false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	false,	"eq_no",				false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	false,	"xtra_disp_sts_cd",		false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	false,	"iss_ofc_cd",			false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	false,	"cre_usr_id",			false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	false,	"mnr_xtra_disp_tp_cd",	false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	false,	"curr_cd",				false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	false,	"iss_dt",				false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	false,	"iss_yd_cd",			false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	false,	"xtra_disp_incm_amt",	false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	false,	"xtra_disp_expn_amt",	false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	false,	"xtra_disp_desc",		false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	false,	"xtra_disp_rmk",		false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	false,	"file_seq",				false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	false,	"eq_tpsz_cd",			false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	false,	"ofc_cd",				false,	"",	dfNone,		0,	true,	true);

					CountPosition = 0;
				}
			    break;

            case "sheet2":
                with (sheetObj) {
					var prefix = "";   
					
					// 높이 설정
					style.height = 82; 
					// 전체 너비 설정
					//SheetWidth = mainTable.clientWidth;
					SheetWidth = 280;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
							
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;	
						
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 13, 100);
						
					var HeadTitle1 = "|Evidence Attached|Evidence Attached|Evidence Attached";
					var HeadTitle2 = "|Sel|File|Download";
								
					var headCount = ComCountHeadTitle(HeadTitle1);									
						
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(8, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true); 
					InitHeadRow(1, HeadTitle2, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	50,		daCenter,	true,	prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,	30,		daCenter,	false,	prefix + "del_chk")
					InitDataProperty(0, cnt++ , dtPopup,      	120,	daCenter,  	false,  prefix + "org_file_nm",     true,   "",	dfNone,	0,	false,	true,	50);
					InitDataProperty(0, cnt++ , dtImage,      	40,   	daCenter,  	false,  prefix + "file_dw",   		false,  "", dfNone, 0,  false,	true);
					InitDataProperty(0, cnt++ , dtHidden,     	80,     daCenter,  	false,  prefix + "file_path_nm",	false,  "", dfNone, 0,  true,   true);
					InitDataProperty(0, cnt++ , dtHidden,     	80,    	daCenter,  	false,  prefix + "file_path",   	false,  "", dfNone, 0,  true,   true);
					InitDataProperty(0, cnt++ , dtHidden,     	80,    	daCenter,  	false,	prefix + "file_seq",   		false,  "", dfNone, 0,  true,   true);										
					InitDataProperty(0, cnt++ , dtHidden,	 	80,		daLeft,		true,  	prefix + "file_dtl_seq",	false,	"",	dfNone,	0,	false,	false);
	 						
					CountPosition = 0;
					
                    ImageList(0)= "/hanjin/img/ico_attach.gif";
                    
					ShowButtonImage = 1;    
	            }
			    break;
        }
    }

    /**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 **/
	function initControl() {
	    axon_event.addListenerForm  ('blur', 		'obj_blur',		document.form); 	//- 포커스 나갈때
	    axon_event.addListenerFormat('focus',  		'obj_focus',    document.form); 	//- 포커스 들어갈때
	    axon_event.addListenerForm	('keypress',	'obj_keypress', document.form);		//- 키입력 할때
	    axon_event.addListenerFormat('change',	 	'obj_change',	document.form);		//- 변경될때
    }

	/**
	 * IBUpload Object 기본설정
	*/
	function initUpload(uploadObj, uploadNo) {
	   uploadObj.Files = "";
	}
    /**
     * IBCombo Object를 배열로 등록
     * 
     * @param {IBCombo}
     *            combo_obj 배열로 등록될 IBCombo Object
     */
    function setComboObject(combo_obj) {
    	comboObjects[comboCnt++] = combo_obj;
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
	 * IBUpload Object를 uploadObjects 배열에 등록
	 * 배열은 소스 상단에 정의
	*/
	function setUploadObject(uploadObj){
	   uploadObjects[uploadCnt++] = uploadObj;
	}
	
	/**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_blur(){
		ComChkObjValid(event.srcElement);
	}	
	
	/**
     * HTML Control의 focus이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_focus(){
    	ComClearSeparator(event.srcElement);
    }
	
	/**
	 * HTML Control의 onkeypress 이벤트에서 Validation을 체크한다. <br>
	 **/
	function obj_keypress(){
		obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
		switch(obj.dataformat) {
			case "ymd":
				ComKeyOnlyNumber(event.srcElement);
				break;
	        
			case "engup":
	          	ComKeyOnlyAlphabet("uppernum");          
	            break;
	        
			case "float":
				ComKeyOnlyNumber(event.srcElement, ".");          
	        	break;
	    } 
	}

	/**
	 * HTML Control의 onchange 이벤트에서 Validation을 체크한다. <br>
	 **/
	function obj_change(){ 
		var obj      = event.srcElement; 
		var formObj  = document.form; 
		var sheetObj = sheetObjects[0]; 
		if ( ComTrim(obj.value) != "" ) {
			switch(obj.name) {      
	    		case "eq_no":   
	        		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01);
				   	break;
				case "iss_yd_cd":  
					doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC02); 
				   	break;
			}       
	    } else {
			switch(obj.name) {     
	    		case "eq_no":    
					setEqInfoClear(); 
				   	break;   	
			} 
		}	
	} 
    
	/**
	 * 조회후 결과설정
	 * 
	 * @param {IBSheet}sheetObj 조회이벤트의 시트 오브젝트
	 * @param {String}ErrMsg 에러메세지
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		if(sheetObj.RowCount < 1) {return;}
		
		var formObj = document.form;
		var xtraDispStsCd	= sheetObj.CellValue(sheetObj.HeaderRows, "xtra_disp_sts_cd");		//EQ Status
		var issOfcCd		= sheetObj.CellValue(sheetObj.HeaderRows, "iss_ofc_cd");			//Request Office
		var creUsrId		= sheetObj.CellValue(sheetObj.HeaderRows, "cre_usr_id");			//Creation User
		var mnrXtraDispTpCd = sheetObj.CellValue(sheetObj.HeaderRows, "mnr_xtra_disp_tp_cd");	//Type
		var issDt			= sheetObj.CellValue(sheetObj.HeaderRows, "iss_dt");				//Issue Date
		var issYdCd			= sheetObj.CellValue(sheetObj.HeaderRows, "iss_yd_cd");				//Issue Yard
		var currCd			= sheetObj.CellValue(sheetObj.HeaderRows, "curr_cd");				//Currency
		var xtraDispIncmAmt	= sheetObj.CellValue(sheetObj.HeaderRows, "xtra_disp_incm_amt");	//Income Total
		var xtraDispExpnAmt	= sheetObj.CellValue(sheetObj.HeaderRows, "xtra_disp_expn_amt");	//Expense Total
		var xtraDispDesc	= sheetObj.CellValue(sheetObj.HeaderRows, "xtra_disp_desc");		//Information
		var xtraDispRmk		= sheetObj.CellValue(sheetObj.HeaderRows, "xtra_disp_rmk");			//Remark
		var fileSeq 		= sheetObj.CellValue(sheetObj.HeaderRows, "file_seq");				//File Seq
		var ofcCd 			= sheetObj.CellValue(sheetObj.HeaderRows, "ofc_cd");				//Creation Office

		formObj.xtra_disp_sts_cd.Code		= xtraDispStsCd;	//EQ Status
		formObj.iss_ofc_cd.Text 			= issOfcCd;			//Request Office
		formObj.cre_usr_id.value 			= creUsrId;			//Creation User
		formObj.mnr_xtra_disp_tp_cd.Code	= mnrXtraDispTpCd;	//Type
		formObj.iss_dt.value				= issDt;			//Issue Date
		formObj.iss_yd_cd.value				= issYdCd;			//Issue Yard
		formObj.curr_cd.Text				= currCd;			//Currency
		formObj.xtra_disp_incm_amt.value	= xtraDispIncmAmt;	//Income Total
		formObj.xtra_disp_expn_amt.value	= xtraDispExpnAmt;	//Expense Total
		formObj.xtra_disp_desc.value		= xtraDispDesc;		//Information
		formObj.xtra_disp_rmk.value			= xtraDispRmk;		//Remark
		formObj.ofc_cd.value				= ofcCd;			//Creation Office
		
		//파일 리스트 조회 
		if(fileSeq != "" && fileSeq != null){ 
			var fileXml = SearchFileUpload(sheetObjects[1],fileSeq);
			if(!MnrIsEmptyXml(fileXml)){
				sheetObjects[1].LoadSearchXml(fileXml);	
			}
		}	      

		formObj.xtra_disp_incm_amt.focus();
		formObj.xtra_disp_expn_amt.focus();
		formObj.mnr_xtra_disp_tp_cd.focus();
		
		formObj.eq_knd_cd.Enable = false;
		formObj.eq_no.readOnly = true;
		formObj.eq_no.className = "input2";
		
		setButtonEnDisable();
	}
	
	/**
	 * 저장후 결과메세지 표시
	 * 
	 * @param {IBSheet}sheetObj 저장이벤트의 시트 오브젝트
	 * @param {String}ErrMsg 에러메세지
	 */
	function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		if (ErrMsg == "") {
			//save
			if(saveType == 1) {
				ComShowCodeMessage("MNR00023");
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			//confirm
			} else if (saveType == 2) {
				ComShowCodeMessage("MNR00313");
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			//Cancel
			} else if(saveType == 3) {
				ComShowCodeMessage("MNR00104", "Data");
				doActionIBSheet(sheetObjects[0], document.form, IBCLEAR, 1);
			} else {
				ComShowCodeMessage("MNR00023");
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			}
		} else {
			//서버에러 메세지로 대체함.
			//ComShowCodeMessage("MNR00008", ErrMsg);
		}
		saveType = 0;
	}
	
    /**
     * Sheet1관련 프로세스 처리
     * 
     * @param {IBSheet}sheetObj 프로세스 처리될 시트오브젝트
     * @param {Form}formObj 프로세스 처리될 폼오브젝트
     * @param {Number}sAction 분기처리될 액션의 상수값(CoObject.js에 정의)
     */
    function doActionIBSheet(sheetObj,formObj,sAction, sActionIdx) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
	    	// 초기화
	    	case IBCLEAR:
	    		// 버튼 , 프로그레스바 설정 시작
	    		sheetObj.WaitImageVisible = false;
	    		MnrWaitControl(true);
	
	    		// 모든 쉬트를 초기화
	    		for (i = 0; i < sheetObjects.length; i++) {
	    			sheetObjects[i].RemoveAll();
	    		}
	    		// Only Loading
	    		if (sActionIdx == 0) {
	    			// 조건부 콤보데이타 초기화
	    			for ( var i = 0; i < comboObjects.length; i++) {
	    				comboObjects[i].RemoveAll();
	    			}
					//조건부 콤보데이타 조회(Type)
					var sCondition = new Array (
						new Array("MnrGenCd","SELHO","CUSTOM9"),		//EQ Type  
						new Array("MnrGenCd","CD00033", "COMMON"), 		//EQ Status
						new Array("MnrGenCd","CD00032", "COMMON"), 		//Type
						new Array("MdmCurrency","", "COMMON"),			//Currency
						new Array("MdmOrganization","SEARCH","NOTHQ")	//Request Office
					)             
					var comboList = MnrComSearchCombo(sheetObj,sCondition);
					//조건부 콤보데이타에 값을 세팅함        
					for(var i=0; i<comboList.length ; i++){
						//comboObjects[i].RemoveAll();
						if(comboList[i] != null){
							comboOfficeList = comboList[4]; //Validation check 용
							//[CODE_NAME]:EQ Type,EQ Status,Type
							if(i == 0 || i == 1 || i == 2) {
								for(var j = 0; j < comboList[i].length;j++){ 
									var tempText = comboList[i][j].split("|");
									if(i==0) {//EQ Type
										formObj.eq_knd_cd.InsertItem(j, tempText[1] ,tempText[0]);
									} else if(i==1) {//EQ Status
										formObj.xtra_disp_sts_cd.InsertItem(j, tempText[1] ,tempText[0]);
									} else if(i==2) {//Type
										formObj.mnr_xtra_disp_tp_cd.InsertItem(j, tempText[1] ,tempText[0]);
									}
								}
							//[CODE]:Currency, Request Office
							} else if(i == 3 || i == 4){
								for(var j = 0; j < comboList[i].length;j++){ 
									if(i == 3) {
										formObj.curr_cd.InsertItem(j, comboList[i][j] ,j);
									} else if (i == 4) {
										formObj.iss_ofc_cd.InsertItem(j, comboList[i][j] ,j);
									}
								}
							}
						}
					}
					formObj.xtra_disp_sts_cd.InsertItem(0, "New" ,"N" );
	    		}
	    		// 초기값 설정
	    		formObj.eq_knd_cd.Code 				= "U"; 	  				//EQ Type
	    		formObj.eq_knd_cd.Enable 			= true;					//EQ Type
	    		formObj.eq_no.value 				= ""; 	  				//EQ No
	    		formObj.eq_no.readOnly 				= false;				//EQ No
	    		formObj.eq_no.className 			= "input1";				//EQ No
	    		formObj.xtra_disp_sts_cd.Code 		= "N";					//EQ Status
	    		formObj.xtra_disp_sts_cd.Enable		= false;				//EQ Status
	    		formObj.iss_ofc_cd.Text				= currOfcCd;			//Creation Office
	    		formObj.cre_usr_id.value 			= usrId;				//Creation User
	    		formObj.mnr_xtra_disp_tp_cd.Code	= "SCR";				//Type
	    		formObj.iss_dt.value				= ComGetNowInfo("ymd");	//Issue Date
	    		formObj.iss_yd_cd.value				= "";					//Issue Yard
	    		formObj.curr_cd.Text				= "USD";				//Currency
	    		formObj.xtra_disp_incm_amt.value	= "0.00";				//Income Total
	    		formObj.xtra_disp_expn_amt.value	= "0.00";				//Expense Total
	    		formObj.xtra_disp_desc.value		= "";					//Information
	    		formObj.xtra_disp_rmk.value			= "";					//Remark
	    		formObj.eq_tpsz_cd.value			= "";					//TP/SZ	
	    		formObj.eq_knd_cd.focus();
	    		uploadFileSeq = "";
	    		
	    		// 버튼 , 프로그레스바 설정 끝
	    		MnrWaitControl(false);
	    		sheetObj.WaitImageVisible = true;
	
	    		break;

          	//조회
          	case IBSEARCH:      
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH;
					var sXml = sheetObj.GetSearchXml("EES_MNR_0093GS.do",FormQueryString(formObj));
					sheetObj.LoadSearchXml(sXml);
				}
                break;

            //저장
			case IBSAVE:        
				if(validateForm(sheetObj,formObj,sAction,sActionIdx)) {
					
					var xtraDispStsCd 	= formObj.xtra_disp_sts_cd.Code; 							//Status
					var eqKndCd			= formObj.eq_knd_cd.Code;									//EQ Type
					var eqNo			= formObj.eq_no.value;										//EQ No
					var issOfcCd 		= formObj.iss_ofc_cd.Text;									//Request Office
					var creUsrId 		= formObj.cre_usr_id.value;									//Creation User
					var mnrXtraDispTpCd = formObj.mnr_xtra_disp_tp_cd.Code;							//Type
					var issDt			= formObj.iss_dt.value;										//Issue Date
					var issYdCd			= formObj.iss_yd_cd.value;									//Issue Yard
					var currCd			= formObj.curr_cd.Text;										//Currency
					var xtraDispIncmAmt	= ComGetUnMaskedValue(formObj.xtra_disp_incm_amt, "float");	//Income Total
					var xtraDispExpnAmt	= ComGetUnMaskedValue(formObj.xtra_disp_expn_amt, "float");	//Expense Total
					var xtraDispDesc	= formObj.xtra_disp_desc.value;								//Information
					var xtraDispRmk		= formObj.xtra_disp_rmk.value;								//Remark
					var fileSeq			= uploadFileSeq;											//File Seq
					var eqTpszCd		= formObj.eq_tpsz_cd.value;									//TP/SZ 
						
					//EQ Status : New
					if(xtraDispStsCd == "N") {
						sheetObjects[0].DataInsert(-1);
						
						//Button:Save 
						if(sActionIdx == 1) {
							sheetObjects[0].CellValue(sheetObjects[0].HeaderRows,"xtra_disp_sts_cd") = "HS";				
						
						//Button:Confirm
						} else if(sActionIdx == 2) { 
							sheetObjects[0].CellValue(sheetObjects[0].HeaderRows,"xtra_disp_sts_cd") = "HA";
						}
						sheetObjects[0].CellValue(sheetObjects[0].HeaderRows,"eq_knd_cd")	= eqKndCd;	//EQ Type
						sheetObjects[0].CellValue(sheetObjects[0].HeaderRows,"eq_no") 		= eqNo; 	//EQ No
						sheetObjects[0].CellValue(sheetObjects[0].HeaderRows,"iss_ofc_cd") 	= issOfcCd; //Creation Office
						sheetObjects[0].CellValue(sheetObjects[0].HeaderRows,"cre_usr_id") 	= creUsrId; //Creation User

					//EQ Status : Save
					} else if(xtraDispStsCd == "HS"){
						//Button:Confirm
						if(sActionIdx == 2) {
							sheetObjects[0].RowStatus(sheetObjects[0].HeaderRows) = "U";
							sheetObjects[0].CellValue(sheetObjects[0].HeaderRows,"xtra_disp_sts_cd") = "HA";

						//Button:Cancel
						} else if (sActionIdx == 3) {
							sheetObjects[0].RowStatus(sheetObjects[0].HeaderRows) = "D";							
							sheetObjects[0].CellValue(sheetObjects[0].HeaderRows,"xtra_disp_sts_cd") = "HD";
						}
					
					//EQ Status : Confirm
					} else if (xtraDispStsCd == "HA") {
						//Button:Cancel
						if(sActionIdx == 3) {
							sheetObjects[0].RowStatus(sheetObjects[0].HeaderRows) = "D";
							sheetObjects[0].CellValue(sheetObjects[0].HeaderRows,"xtra_disp_sts_cd") = "HC";
						}
					}
						
					sheetObjects[0].CellValue(sheetObjects[0].HeaderRows,"mnr_xtra_disp_tp_cd") = mnrXtraDispTpCd;	//Type
					sheetObjects[0].CellValue(sheetObjects[0].HeaderRows,"iss_dt") 				= issDt;			//Issue Date
					sheetObjects[0].CellValue(sheetObjects[0].HeaderRows,"iss_yd_cd") 			= issYdCd; 			//Issue Yard
					sheetObjects[0].CellValue(sheetObjects[0].HeaderRows,"curr_cd") 			= currCd; 			//Currency
					sheetObjects[0].CellValue(sheetObjects[0].HeaderRows,"xtra_disp_incm_amt") 	= xtraDispIncmAmt; 	//Income Total
					sheetObjects[0].CellValue(sheetObjects[0].HeaderRows,"xtra_disp_expn_amt") 	= xtraDispExpnAmt; 	//Expense Total
					sheetObjects[0].CellValue(sheetObjects[0].HeaderRows,"xtra_disp_desc") 		= xtraDispDesc; 	//Information
					sheetObjects[0].CellValue(sheetObjects[0].HeaderRows,"xtra_disp_rmk") 		= xtraDispRmk; 		//Information
					sheetObjects[0].CellValue(sheetObjects[0].HeaderRows,"file_seq") 			= fileSeq; 			//File Seq
					sheetObjects[0].CellValue(sheetObjects[0].HeaderRows,"eq_tpsz_cd") 			= eqTpszCd; 		//TP/SZ 
					
					formObj.f_cmd.value = MULTI;
					var sParam = ComGetSaveString(sheetObjects);
					if (sParam == "") {return;}
					sParam += "&" + FormQueryString(formObj);
					var sXml = sheetObjects[0].GetSaveXml("EES_MNR_0093GS.do", sParam);
					sheetObjects[0].LoadSaveXml(sXml);
				 }
                 break;
            
            //체크조회(EQ No)
			case IBSEARCH_ASYNC01:	
				if ( validateForm(sheetObj, formObj, sAction) ) { 
					var eqNo 			= formObj.eq_no.value; 
					var eqKndCd 		= formObj.eq_knd_cd.Code;
					var totalLossDate	= ComGetNowInfo("ymd");
					
					var retArray = MnrGeneralCodeCheck(sheetObj,"ESTEQN",eqNo + "," + eqKndCd);      
					if(retArray == null){ 	          
						ComShowCodeMessage("MNR00165",eqNo,"EQ No.");          				
						ComSetObjValue(formObj.eq_no, "");  	    
						ComSetFocus(formObj.eq_no); 
						setEqInfoClear();
						return; 	     	          
					} 
					//EQ No 관련 항목 조회,설정
					setEqInfo(sheetObj,eqKndCd,eqNo,totalLossDate);
					//조회
					doActionIBSheet(sheetObj, document.form, IBSEARCH)
				}		
				break;
			
			//체크조회(Issue Yard)
			case IBSEARCH_ASYNC02:
				if ( validateForm(sheetObj, formObj, sAction) ) {  
					var issYdCdObj	= formObj.iss_yd_cd;
					var issYdCd 	= issYdCdObj.value;
							
					var retArray = MnrGeneralCodeCheck(sheetObj,"YARD",issYdCd);      
					
					if(retArray == null){        
						ComShowCodeMessage("MNR00165",issYdCd,"YARD");       				
						ComSetObjValue(issYdCdObj, "");  	    
						ComSetFocus(issYdCdObj);                   
					}   	 
				}		
				break;  
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction, sActionIdx){
        with(formObj){
    		// 조회시 체크
    		if (sAction == IBSEARCH) {
    			// Dataformat
    			if (!ComChkValid(formObj)) {
    				return false;
    			}
    		}
    		// 저장시 체크
    		else if (sAction == IBSAVE) {
    			// Dataformat
    			if (!ComChkValid(formObj)) {return false;}
    			var xtraDispStsCd = formObj.xtra_disp_sts_cd.Code;
    			// Button : Save
    			if(sActionIdx == 1) {
    				//저장필수체크
    				if(!checkMandatory(formObj.mnr_xtra_disp_tp_cd)) {return false};
    				if(!checkMandatory(formObj.iss_dt))  {return false};
    				if(!checkMandatory(formObj.iss_ofc_cd))  {return false};
    				if(!checkMandatory(formObj.iss_yd_cd))  {return false};
    				if(!checkMandatory(formObj.curr_cd))  {return false};
    				
        			// Status : New
    				if(xtraDispStsCd == "N") {
    					// DB중복 조회 체크
    					if(!checkDuplication(sheetObj, formObj)) {return false;}
    				// Status : Confirm
    				} else if(xtraDispStsCd == "HA") {
						//이미 ExtraDisposal 정보가 Confirm 되었습니다라는 메시지 표시
        				ComShowCodeMessage("MNR00107");
        				return false;
    				}
    				
				// Button : Confirm
    			} else if(sActionIdx == 2) {
    				//저장필수체크
    				if(!checkMandatory(formObj.mnr_xtra_disp_tp_cd)) {return false};
    				if(!checkMandatory(formObj.iss_dt))  {return false};
    				if(!checkMandatory(formObj.iss_ofc_cd))  {return false};
    				if(!checkMandatory(formObj.iss_yd_cd))  {return false};
    				if(!checkMandatory(formObj.iss_dt))  {return false};
    				// Status : New
    				if(xtraDispStsCd == "N") {
    					// DB중복 조회 체크
    					if(!checkDuplication(sheetObj, formObj)) {return false;}
    				// Status : Confirm
    				} else if(xtraDispStsCd == "HA"){
						//이미 ExtraDisposal 정보가 Confirm 되었습니다라는 메시지 표시
        				ComShowCodeMessage("MNR00107");
        				return false;
        			} 
    				// Confirm 의사확인
    				if(!ComShowCodeConfirm("MNR00197")) {return false;}
    			
    			// Button : Cancel
    			} else if (sActionIdx == 3) {
    				// Status : New
    				if(xtraDispStsCd == "N"){
						//Cancel할 Extra Disposal 정보를 먼저 조회 
    					ComShowCodeMessage("MNR00199");
        				return false;
        			} 
    				// Cancel 의사확인
    				if(!ComShowCodeConfirm("MNR00244")) {return false;}
    			}
    		}
    		//EQ No Validation 체크
    		else if (sAction == IBSEARCH_ASYNC01) {
				//EQ_TYPE 선택유무 체크 
    			var eqKndCd = formObj.eq_knd_cd.Code;
				if(eqKndCd == ""){	
					ComShowCodeMessage("MNR00119"); 
					ComSetObjValue(formObj.eq_no, "");     
					formObj.eq_knd_cd.focus();
					return;	   	 
				} 
    		}
        }
        return true;
    }


    /* ********* User Functions ************* */
    /**
     * 저장시 필수 체크
     * @param	{Element}	obj	체크할 Form Element
     */
	function checkMandatory(obj) {
		var objValue = ComGetObjValue(obj);
		if(ComIsEmpty(objValue)) {  
		    ComShowCodeMessage("MNR00003");
		    obj.focus();
		    return false;
		}
		return true;
	}
	
    /**
     * 신규 저장시 중복 체크 조회
     * @param  {IBSheet} sheetObj 처리될 시트오브젝트  
     * @param  {Form} formObj 처리될 폼오브젝트  
     * @return {Boolean} true/false
     */
	function checkDuplication(sheetObj, formObj) {
		formObj.f_cmd.value = SEARCH01;
		var sXml = sheetObj.GetSearchXml("EES_MNR_0093GS.do",FormQueryString(formObj));
		var strCnt = ComGetEtcData(sXml, "cnt");
		var intCnt = ComParseInt(strCnt); 
		if(intCnt > 0) {
			ComShowCodeMessage("MNR00236");
			return false;
		}
		return true;
	}
	
	 /**
     * IBSheet의 file upload 할 Row를 추가한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @return {없음}
     **/
	function file_Insert(sheetObj){ 
		uploadFileSeq = sheetObj.CellValue(2,"file_seq");
		
		if(uploadFileSeq == undefined){ 	 
			uploadFileSeq = "";	
		}
					
		for(var j = 2; j <= sheetObj.LastRow;j++){ 
			if (sheetObj.CellValue(j,"org_file_nm") == ""){
				ComShowMessage(ComGetMsg('MNR00024'));
				sheetObj.SelectCell(j,"org_file_nm");  
				return;      
			} 	
		} 
		var row = sheetObj.DataInsert(-1); 
	}
	
	 /**
     * IBSheet의 file upload 할 Row를 삭제한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @return {없음}
     **/
	function file_Remove(sheetObj) { 		  
		if(sheetObj.FindCheckedRow("del_chk") != ""){
			RemoveFileUpload(sheetObj);	         	 		
		} else {			      
			ComShowCodeMessage("MNR00150");   	   
		}	 
	}	
	
	/**
     * 파일 선택하기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function sheet2_OnPopupClick(sheetObj,Row,Col){
	    var upObj = uploadObjects[0];         
		var prefix = "";			
	 	var fileName = sheetObj.OpenFileDialog("파일선택");
		
		var badFile = false;
		if(fileName.indexOf("\\") == -1) {  
			badFile = true;		
		} else {
			var relativePath = fileName.substr(fileName.lastIndexOf("\\") + 1); 
			var fileType = 	relativePath.substr(relativePath.lastIndexOf(".") + 1);
			fileType = fileType.toUpperCase();
			//GIF, BMP, TIFF, JPG 
			//if(fileType != "GIF" && fileType != "BMP" && fileType != "TIFF" && fileType != "TIF" && fileType != "JPG"){
				badFile = false; 	
			//} 
		}
			  
	 	if(!badFile) {  
	 		sheetObj.CellValue2(Row, prefix+ "org_file_nm")= fileName;     			
	 		upObj.Files=""; //-먼저기존파일을 모두 지운후 추가함
	    	var ret = upObj.AddFile(fileName);     			     			
	    	fileName = fileName.substr(fileName.lastIndexOf("\\") + 1);
	 		sheetObj.CellValue2(Row, Col)= fileName;		 		
			sheetObj.CellValue2(Row, prefix+ "file_dw")= '1';
	 		var file_seq = sheetObj.CellValue(Row, prefix+ "file_seq"); 
			var file_dtl_seq = sheetObj.CellValue(Row, prefix+ "file_dtl_seq");
			if(file_dtl_seq=="") file_dtl_seq=Row;
			var ibflag='U';
			if(file_seq == "" || uploadFileSeq != "") ibflag='I'; // 최초 저장시 및 저장된 파일 없을때 ibflag을 I로 Setting			
			if(file_seq != "" && uploadFileSeq != "") ibflag='U'; 
				
			if(uploadFileSeq != "") {	
				file_seq = uploadFileSeq; 
			}	     		
							
	 		var sParam = "f_cmd="+COMMAND01;
	 		sParam+= "&mnr_grp_tp_cd=SCR";       // MNR Work Group Type Code				
	 		sParam+= "&file_seq=" + file_seq;    // 기존에 존재 File Sequence
	 		sParam+= "&file_dtl_seq=" + file_dtl_seq;    // 기존에 존재 File Sequence
	 		sParam+= "&org_file_nm=" + fileName; // Fileupload 파일명
	 		sParam+= "&ibflag=" + ibflag;        // I : 최초 File Upload U : File 변경   		
						
			upObj.ExtendParam = sParam;
			 
			var sXml = upObj.DoUpload(true);
				     		
			uploadFileSeq = ComGetEtcData(sXml,"seqValue");
						
			if(uploadFileSeq != "" && uploadFileSeq != undefined){ 
				var fileXml = SearchFileUpload(sheetObjects[1],uploadFileSeq);
				sheetObjects[1].LoadSearchXml(fileXml);   				
			}	  
	 	} else {
			ComShowCodeMessage("MNR00217");     	 
		}
	}
	
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     **/  
	function sheet2_OnClick(sheetObj,Row,Col,Value){
		var prefix = "";  
   		   
        if (sheetObj.ColSaveName(Col)!=prefix+"file_dw" || sheetObj.RowStatus(Row)=="I")return;
			
		if(sheetObj.CellText(Row, prefix+"file_path_nm") == "") return;
		
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_path_nm");
		return;
	}  
	
	/**
     * 상태에 따른 버튼의 활성/비활성화 설정 <br>
     **/  
	function setButtonEnDisable() {
		var xtraDispStsCd = document.form.xtra_disp_sts_cd.Code; //EQ Status
		//EQ Status : Confirm
		if(xtraDispStsCd == "HA") {
			ComBtnDisable("btn_Retrieve");
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_Confirm");
			ComBtnDisable("btn_FileAdd");
			ComBtnDisable("btn_FileDel");
		} else {
			ComBtnEnable("btn_Retrieve");
			ComBtnEnable("btn_Save");
			ComBtnEnable("btn_Confirm");
			ComBtnEnable("btn_FileAdd");
			ComBtnEnable("btn_FileDel");
		}
	}
	
	/**
     * EQ No에 따른 관련 항목(Issue Yard) 설정 <br>
     **/  
	function setEqInfo(sheetObj,sEqType,sEqNo,sTotalLossDate){
		var formObj = document.form;
		var sCostType = "";
		if(sEqType == "U"){
			sCostType = "MRDRRC";	
		} else if(sEqType == "G"){
			sCostType = "MRGSRC";		
		} else {
			sCostType = "MRZSRC";   
		}	    	 	
		var sXml = MnrComEqGenInfoSearch(sheetObj,sEqType,sEqNo,sTotalLossDate,sCostType);
		var retArr =  MnrXmlToArray(sXml); 
		//0 imm_ext|1 mdl_nm|2 mvmt_dt|3 dv_cur|4 rpr_yd|5 sp_name|6 flg_rmk|7 manu_dt|8 mkr_nm|9 pagerows|10 dv_value|11 ibflag|12 off_hire|13 mvmt_cd|14 dsp_flag|15 hngr_flg_yd|16 lessor_nm|17 hngr_rck_cd|18 crnt_yd_cd|19 lstm_cd|20 eq_no|21 hngr_flg_dt|22 bar_atch_knt|23 status|24 bar_tp_cd|25 dmg_flag|26 cost|27 mtrl_cd|28 eq_type|29 mtrl_nm|30 rpr_type|31 eq_tpsz_cd|32 rpr_dt						
		if(retArr == null){  
			ComShowCodeMessage("MNR00165",sEqNo,"EQ No."); 
			ComSetObjValue(formObj.eq_no,"");
			ComSetObjValue(formObj.iss_yd_cd,"");   
			ComSetObjValue(formObj.eq_tpsz_cd,"");
			return;
		} 
		if(sEqType == "U") {
			var lstmCd = retArr[0][19]; 
			if(lstmCd != "OW") {
				//Own 장비만 Scrap/Donation이 가능합니다.
				ComShowCodeMessage("MNR00285");  
				ComSetObjValue(formObj.eq_no,"");   
				ComSetObjValue(formObj.iss_yd_cd,"");   
				ComSetObjValue(formObj.eq_tpsz_cd,"");
				ComSetFocus(formObj.eq_no);
				return;
			}
		}   
		ComSetObjValue(formObj.iss_yd_cd,retArr[0][18]);   //current Yard 
		ComSetObjValue(formObj.eq_tpsz_cd,retArr[0][31]);  //TpSz 
	}	

	/**
     * EQ No에 따른 관련 항목(Issue Yard) 초기화 <br>
     **/  
	function setEqInfoClear(){
		var formObj = document.form;
		ComSetObjValue(formObj.iss_yd_cd,""); 
		ComSetObjValue(formObj.eq_tpsz_cd,""); 
	}
	
	/**
	 * COM_ENS_061 의 값을 받은 함수      
	 */
	function getCOM_ENS_061(aryPopupData, row, col, shhetIdx){
    	 var formObj = document.form;	 	
		 if(aryPopupData[0][3] != null && aryPopupData[0][3] != "")       
    	 	formObj.iss_yd_cd.value = aryPopupData[0][3];                                  
    }
	
