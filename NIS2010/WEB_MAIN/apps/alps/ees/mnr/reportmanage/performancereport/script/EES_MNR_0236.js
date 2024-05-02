/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_MNR_0236.jsp
 *@FileTitle : ACEP Candidate Cntr List 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.01.28
 *@LastModifier : 김완규 	
 *@LastVersion : 1.0     
 * 2010.01.28 김완규   
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
 * @class EES_MNR_0236 : EES_MNR_0236 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function EES_MNR_0236() {
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
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var comboObjects = new Array();
	var comboCnt = 0;

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
            	//New
				case "btn_New":
	                doActionIBSheet(sheetObject1,document.form,IBCLEAR,1);
	                break;
            
				//조회
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,document.form,IBSEARCH);
					break; 
				
				//S/Provider Code PopUp
				case "provider_popup":
					ComOpenPopup('/hanjin/COM_ENS_0C1.do', 705, 475, 'setPopData_Sp', '1,0,1,1,1,1,1,1', true);
					break;
					
				//엑셀
				case "btn_Down_Excel":
					sheetObject1.SpeedDown2Excel(-1);
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
    	
    	//IBMultiCombo초기화
    	for ( var k = 0; k < comboObjects.length; k++) {
    		initCombo(comboObjects[k], k + 1);
    	}
    	
    	//IBSheet 초기화
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }

        //Axon이벤트 초기화
		initControl();
		
		//화면초기화
		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR, 0);
		
		//focus
		document.form.cost_grp_cd.focus();
    }

    /**
     * IBCombo 기본 설정
     * @param {IBCombo} comboObj 초기설정될 콤보오브젝트
     * @param {Number} comboNo 콤보오브젝트 태그의 아이디에 붙인 일련번호
     */
    function initCombo(comboObj, comboNo) {
    	var cnt = 0;
    	var formObject = document.form

    	switch (comboNo) {
    	case 1:
    		with (comboObj) {
    			SetColAlign("left");
    			SetColWidth("25");
				UseAutoComplete = true;
    		}
    		break;
    	
    	case 2:
           	with (comboObj) { 
				SetTitle("Office Code|Office Name");
        	   	SetColAlign("center|left");        
				SetColWidth("55|225"); 
			   	DropHeight = 160;  
				UseAutoComplete = true;
	    	}      
    		break;
    		
    	case 3:
    		with (comboObj) { 
    			SetTitle("Office Code|Office Name");
    			SetColAlign("left|left");        
    			SetColWidth("60|305"); 
    			DropHeight = 160;  
				UseAutoComplete = true;
    		}      
    		break;
    		
    	case 4:
    	case 5:
    	case 6:
    		with (comboObj) {
				SetTitle("Code|Desc");
    			SetColAlign("center|left");        
    			SetColWidth("45|260"); 
    			DropHeight = 160;  
				UseAutoComplete = true;
    		}
    		break;
		case 7:	
    		with (comboObj) {
    			SetColAlign("left");
    			SetColWidth("25");
				UseAutoComplete = true;
    		}
    		break;
		case 8:
    		with (comboObj) {
    			SetColAlign("center|left");        
    			SetColWidth("35|265"); 
    			DropHeight = 160;  
				UseAutoComplete = true;
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
        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
                    // 높이 설정 
                    style.height = 410;    
					    
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 6, 100);
                    
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false) 
                     
                    var HeadTitle = "|Seq.|Tariff Type|Component\nCode|Repair\nCode|Division\nCode|RHQ|Office|S/P Code|S/P Name|Man-hour|Tariff\nCurr|Material|AGMT\nCurr|Labor\nRate|Tariff No|Tariff\nStatus|Agreement No";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
						
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                   	InitDataProperty(0, cnt++ , dtHiddenStatus, 40, 	daCenter,  	false,	"ibflag",			false,	"", dfNone,     0,	false,  false);
                   	InitDataProperty(0, cnt++ , dtDataSeq,  	40, 	daCenter,  	false,	"seq", 				false,	"", dfNone,     0,	false,  false);
                   	InitDataProperty(0, cnt++ , dtData,  		120,	daLeft,  	false,  "cost_grp_nm",		false,  "",	dfNone,     0,  false,	false);
                  	InitDataProperty(0, cnt++ , dtData,     	70,		daCenter,  	false,  "eq_cmpo_cd",		false,  "", dfNone,     0,  false,  false);
                  	InitDataProperty(0, cnt++ , dtData, 		50,		daCenter,  	false,  "eq_rpr_cd", 		false,  "", dfNone,     0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,   		50, 	daCenter,  	false,  "trf_div_cd", 		false,  "", dfNone,		0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData, 		55, 	daCenter,   false,  "ar_hd_qtr_ofc_cd",	false,  "", dfNone,   	0,  false,  false);
                	InitDataProperty(0, cnt++ , dtData,   		55, 	daCenter,  	false,  "rqst_ofc_cd",		false,  "", dfNone,  	0,  false,  false);
                	InitDataProperty(0, cnt++ , dtData,    		80, 	daCenter,  	false,  "vndr_seq",			false,  "", dfNone,     0,  false,  false);
                	InitDataProperty(0, cnt++ , dtData,    		150, 	daLeft,  	false,  "vndr_nm",			false,  "", dfNone,     0,  false,  false);
                	InitDataProperty(0, cnt++ , dtData,    		65, 	daRight,  	false,  "rpr_lbr_hrs",		false,  "", dfFloat,    2,  false,  false);
                	InitDataProperty(0, cnt++ , dtData,    		60, 	daCenter,  	false,  "curr_cd",			false,  "", dfNone,     0,  false,  false);
                	InitDataProperty(0, cnt++ , dtData,    		70, 	daRight,  	false,  "mtrl_cost_amt",	false,  "", dfFloat,    2,  false,  false);
                	InitDataProperty(0, cnt++ , dtData,    		60, 	daCenter,  	false,  "agmt_curr_cd",		false,  "", dfNone,     0,  false,  false);
					InitDataProperty(0, cnt++ , dtData,    		50, 	daRight,  	false,  "agmt_rt_amt",		false,  "", dfFloat,    2,  false,  false);
                	InitDataProperty(0, cnt++ , dtData,    		125, 	daCenter,  	false,  "trf_no",			false,  "", dfNone,     0,  false,  false);
                	InitDataProperty(0, cnt++ , dtData,    		85, 	daLeft,  	false,  "mnr_trf_sts_nm",	false,  "", dfNone,     0,  false,  false);
                	InitDataProperty(0, cnt++ , dtData,    		80,		daCenter,  	false,  "agmt_no",			false,  "", dfNone,     0,  false,  false);
					
					//SELECT 로우 배경색       
					SelectionMode = smSelectionRow;    
					SelectHighLight = true;            
					SelectFontBold = false;          
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);   
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
     * IBCombo Object를 배열로 등록
     * @param {IBCombo} combo_obj 배열로 등록될 IBCombo Object
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
	        case "engup":
	          	ComKeyOnlyAlphabet('uppernum');          
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
	    		case "vndr_seq":  
	        		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01);
				   	break;  
			}       
	    } else {
			switch(obj.name) {     
	    		case "vndr_seq":  
	        		formObj.vndr_nm.value = "";
				   	break;  	
			}  		
		}
	}      

	/** 
	 * COMBO 변경 이벤트
	 * ACEP Type 변경시 loc_cd 의 format 설정
	 * @param	{IBMultiCombo}	comboObj	변경한 콤보 오브젝트
	 * @param	{Number}		Index_Code	변경한 콤보의 코드
	 * @param	{String}		Text		변경한 콤보의 명
	 */
	function ar_hd_qtr_ofc_cd_OnChange(comboObj, Index_Code, Text){
		getAgmtOffice(Index_Code);
	}
	
	/** 
	 * COMBO 변경 이벤트
	 * ACEP Type 변경시 loc_cd 의 format 설정
	 * @param	{IBMultiCombo}	comboObj	변경한 콤보 오브젝트
	 * @param	{Number}		Index_Code	변경한 콤보의 코드
	 * @param	{String}		Text		변경한 콤보의 명
	 */
	function eq_cmpo_cd_OnChange(comboObj, Index_Code, Text){
		setDivCombo();
	}
	
	/** 
	 * COMBO 변경 이벤트
	 * ACEP Type 변경시 loc_cd 의 format 설정
	 * @param	{IBMultiCombo}	comboObj	변경한 콤보 오브젝트
	 * @param	{Number}		Index_Code	변경한 콤보의 코드
	 * @param	{String}		Text		변경한 콤보의 명
	 */
	function eq_rpr_cd_OnChange(comboObj, Index_Code, Text){
		setDivCombo();
	}
	
    /**
     * Sheet1관련 프로세스 처리
     * 
     * @param {IBSheet}sheetObj 프로세스 처리될 시트오브젝트
     * @param {Form}formObj 프로세스 처리될 폼오브젝트
     * @param {Number}sAction 분기처리될 액션의 상수값(CoObject.js에 정의)
     */
    function doActionIBSheet(sheetObj,formObj,sAction,sActionIdx) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
	    	// 초기화
	    	case IBCLEAR:
	    		// 버튼 , 프로그레스바 설정 시작
	    		sheetObj.WaitImageVisible = false;
	    		MnrWaitControl(true);

	    		//쉬트 초기화
	    		sheetObjects[0].RemoveAll(); 

				//Loading
				if(sActionIdx==0) {
					//조건부 콤보데이타 초기화
					for(var i = 0; i < comboObjects.length;i++){ 
						comboObjects[i].RemoveAll();	
					}
					//조건부 콤보데이타 조회
					var sCondition = new Array (
						new Array("MnrGenCd","CC", "COMMON") 		//Tariff Type
					  , new Array("MdmOrganization","RHQ","FALSE") 	//RegionalHQ
					  , new Array("MnrEqCmpoCd","3","COMMON")		//Component
					  , new Array("MnrCedexOthCd","RPR","COMMON")	//Repair
					  , new Array("MnrGenCd","CD00007", "COMMON")	//Status
					)             
					var comboList = MnrComSearchCombo(sheetObj,sCondition);
					
					//조건부 콤보데이타에 값을 세팅함        
					for(var i = 0; i < comboList.length;i++){
						if(comboList[i] != null){
							var cnt = 0;
							for(var j = 0; j < comboList[i].length;j++){ 
								var tempText = comboList[i][j].split("|");    
								if(i==0) {//Tariff Type
									formObj.cost_grp_cd.InsertItem(j, tempText[1] ,tempText[0]);
								} else if(i==1) {//RegionalHQ
									formObj.ar_hd_qtr_ofc_cd.InsertItem(j, comboList[i][j] ,tempText[0]);
								} else if(i==2) {//Component
									formObj.eq_cmpo_cd.InsertItem(j, comboList[i][j] ,tempText[0]);
								} else if(i==3) {//Repair
									formObj.eq_rpr_cd.InsertItem(j, comboList[i][j] ,tempText[0]);
								} else if(i==4) {//Status
									if(tempText[0]=="HE"||tempText[0]=="HA") {
										formObj.mnr_trf_sts_cd.InsertItem(cnt++, tempText[1] ,tempText[0]);
									}
								}
							}
						}
					}
					formObj.eq_cmpo_cd.InsertItem(0, "ALL" ,"A" ); 		//Component
					formObj.eq_rpr_cd.InsertItem(0, "ALL" ,"A" ); 		//Repair
					formObj.trf_div_cd.InsertItem(0, "ALL" ,"A" ); 		//Division
					formObj.mnr_trf_sts_cd.InsertItem(0, "ALL" ,"A" );	//Status
				}
								
				//초기값 설정
				formObj.cost_grp_cd.Code 		= "MRDR";	//Tariff Type
				formObj.rqst_ofc_cd.Code		= "";		//Office
				formObj.ar_hd_qtr_ofc_cd.Code	= defRhqOfc;		//Regional HQ
				formObj.vndr_seq.value			= "";		//S/P Code 
				formObj.vndr_nm.value			= "";		//S/P Name
				formObj.eq_cmpo_cd.Code2 		= "A";		//Component
				formObj.eq_rpr_cd.Code2 		= "A";		//Repair
				formObj.trf_div_cd.Code 		= "A";		//Division
				formObj.mnr_trf_sts_cd.Code 	= "A";		//Status

				// 버튼 , 프로그레스바 설정 끝
	    		MnrWaitControl(false);
	    		sheetObj.WaitImageVisible = true;
	    		break;
				
	    	//조회(sevice provider No. 입력시)
			case IBSEARCH_ASYNC01:	
				if ( validateForm(sheetObj, formObj, sAction) ) { 
					formObj.vndr_seq.value = ComLpad(formObj.vndr_seq.value, 6, "0");
					//Service Provider Detail Information  
					var sXml = MnrGetPartner(sheetObj,formObj.vndr_seq.value,"RPR");
					var vndrSeq = ComGetEtcData(sXml, "vndr_seq");
					if(vndrSeq != "" && vndrSeq != undefined){ 
						//Vender nm 세팅		
						ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));  
						
					} else {       
						ComShowCodeMessage("MNR00005", "Service Provider");              
						ComSetObjValue(formObj.vndr_nm, ""); 
						ComSetObjValue(formObj.vndr_seq, "");
						ComSetFocus(formObj.vndr_seq);
					}   
				}	
				break; 		

	    	//조회
			case IBSEARCH:      
				if(validateForm(sheetObj,formObj,sAction)) {
					sheetObj.WaitImageVisible = true;
					formObj.f_cmd.value = SEARCH;
					if(formObj.check_usd_only.checked){
						formObj.curr_cd.value = "Y";
					} else {
						formObj.curr_cd.value = "N";
					}
					var sXml = sheetObj.GetSearchXml("EES_MNR_0236GS.do", FormQueryString(formObj));
					sheetObj.LoadSearchXml(sXml);
				}
				break;
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
		//조회시
		if(sAction==IBSEARCH){
			//IBMultiCombo 필수값 체크
			var costGrpCd		= ComGetObjValue(formObj.cost_grp_cd);		//Tariff Type
			var arHdQtrOfcCd	= ComGetObjValue(formObj.ar_hd_qtr_ofc_cd);	//Regional HQ
			var rqstOfcCd 		= ComGetObjValue(formObj.rqst_ofc_cd);		//Office
			if(costGrpCd=='') {
				ComShowCodeMessage("MNR00036","Tariff Type");
				formObj.cost_grp_cd.focus();
			    return false;
			}
			if(arHdQtrOfcCd=='') {
				ComShowCodeMessage("MNR00036","Regional HQ");
				formObj.ar_hd_qtr_ofc_cd.focus();
				return false;
			}
			if(rqstOfcCd=='') {
				ComShowCodeMessage("MNR00036","AGMT Office");
				formObj.rqst_ofc_cd.focus();
			    return false;
			}
		}
    	return true;
    }
    
    
/* ********* User Functions ************* */
    /**
 	 * Regional HQ OnChange가 발생하는 경우 Office 조회
 	 * @param comboObj
 	 * @param Index_Code
 	 * @param Text
 	 * @return
 	 */   
 	function getAgmtOffice(Index_Code){ 
 		var formObj = document.form;
 		formObj.rqst_ofc_cd.removeAll();

 		var arHdQtrOfcCd = ComGetObjValue(formObj.ar_hd_qtr_ofc_cd);
		var sCondition = new Array (         
			new Array("MdmOrganization","SEARCH",arHdQtrOfcCd)
		) 	 	       
		var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);      
		
		formObj.rqst_ofc_cd.InsertItem(0,"ALL","A");	
		if(comboList[0] != null){		
			for(var j = 0; j < comboList[0].length;j++){ 
				var tempText = comboList[0][j].split("|");
				formObj.rqst_ofc_cd.InsertItem(j + 1, comboList[0][j] ,tempText[0]);
			}
		}
		formObj.rqst_ofc_cd.Code = "A"; 	 
 	} 
 	
 	/**
 	 * Component,Repair 콤보 변경시 발생하는 이벤트
 	 *    Component,Repair 에 모두 값이 존재할 때만 Division 콤보조회/설정
 	 * @return
 	 */
	function setDivCombo() {
		var formObj = document.form;
		var eqCmpoCd		= ComGetObjValue(formObj.eq_cmpo_cd);	//Component
		var eqRprCd 		= ComGetObjValue(formObj.eq_rpr_cd);	//Repair
		var costGrpCd		= ComGetObjValue(formObj.cost_grp_cd);	//Tariff Type
		var prefixCostGrpCd	= costGrpCd.substring(0,3);
		
		if((eqCmpoCd==""||eqCmpoCd==null||eqCmpoCd=="A") || (eqRprCd==""||eqRprCd==null||eqRprCd=="A")) {
			return;
		}
		
		formObj.trf_div_cd.RemoveAll();
		var compRprJoinStr = ComTrimAll(eqCmpoCd) + ComTrimAll(eqRprCd);	
		var sCondition = new Array (         
		 	new Array("MnrDivCd",compRprJoinStr +','+ prefixCostGrpCd, "COMMON1")
		) 	 	       
		var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);      
        var cnt = 0;
		if(comboList[0] != null){
			for(var j = 0; j < comboList[0].length;j++){ 
				var tempText = comboList[0][j].split("|");
				if(ComTrimAll(tempText[0])!="" && ComTrimAll(tempText[0])!=null && ComTrimAll(tempText[0])!=undefined) {
					formObj.trf_div_cd.InsertItem(cnt++, comboList[0][j] ,tempText[0]);
				}
			}
			formObj.trf_div_cd.InsertItem(0, "ALL" ,"A" );
		}
		formObj.trf_div_cd.Code = "A";
	}
	
	/**
	 * (Service Provider) Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index 
	 */
	function setPopData_Sp(aryPopupData, Row, Col, SheetIdx) {
		var formObj  = document.form;   
   			
		if ( aryPopupData.length > 0 ) {
			formObj.vndr_seq.value = aryPopupData[0][2];
			formObj.vndr_nm.value  = aryPopupData[0][4];
			var sXml = MnrGetPartner(sheetObjects[0],formObj.vndr_seq.value,"RPR");
			if(ComGetEtcData(sXml, "vndr_seq") != null){ 
				//Vender nm 세팅		
				ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));  
			} else {	       
				ComShowCodeMessage("MNR00005", "Service Provider");              
				ComSetObjValue(formObj.vndr_nm, "");  
				ComSetObjValue(formObj.vndr_seq, ""); 
				ComSetFocus(formObj.vndr_seq); 	
			}   	
		}
	}
	
