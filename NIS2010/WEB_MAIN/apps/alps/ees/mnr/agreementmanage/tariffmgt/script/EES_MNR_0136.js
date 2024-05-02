/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mnr_0136.js
*@FileTitle : MNR Regional Tariff Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.07.20 김완규
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
     * @class ees_mnr_0136 : ees_mnr_0136 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mnr_0136() {
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
/* ********* General Functions ************* */

	// 공통전역변수
	var comboObjects = new Array();
	var comboCnt = 0;
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var saveType = 0; //(0:Approval, 1:Reject, 2:Delete)
	var saveMsg  = ""; 
	
	var strMnrOfficeLevel = "";	// 로그인 유저의 Office 레벨 :  HO레벨일때 L1, RHQ레벨일때 L2, Office레벨일때 L3리턴   (CoMnr.js에서 MnrOfficeLevel 함수에 의해 셋팅)

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/** 
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
	 */	
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject = sheetObjects[0];

        /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_Retrieve":
                    doActionIBSheet(sheetObject,document.form,IBSEARCH);
                    break;
				
				case "btn_New":
                    doActionIBSheet(sheetObject,document.form,IBCLEAR);
                    break;

				case "btn_Delete":
				    saveType = 2;
					saveMsg	 = "Delete";	
                    doActionIBSheet(sheetObject,document.form,IBSAVE);
                    break;

				case "btn_Approval":
					saveType = 0;
					saveMsg	 = "Approval";
                    doActionIBSheet(sheetObject,document.form,IBSAVE);
                    break;
                    
				case "btn_Reject":
				    saveType = 1;
					saveMsg	 = "Reject";
                    doActionIBSheet(sheetObject,document.form,IBSAVE);
                    break;
                    
				//S/Provider Code PopUp
				case "provider_popup":
				    ComOpenPopup('/hanjin/COM_ENS_0C1.do', 705, 475, 'setPopData_Sp', '1,0,1,1,1,1,1,1', true);
					break;
				
				//Calendar From PopUP
				case "eff_dt_fr_cal":
					var cal = new ComCalendar();
					cal.setDisplayType('year');
					cal.select(formObject.eff_dt_fr, 'yyyy');
	                break;

				//Calendar To PopUP
				case "eff_dt_to_cal":
					var cal = new ComCalendar();
					cal.setDisplayType('year');
					cal.select(formObject.eff_dt_to, 'yyyy');
	                break;

            	case "btn_DownExcel":
                    doActionIBSheet(sheetObject,document.form,IBDOWNEXCEL);
                    break;
                    
            	case "btn_TariffDetailInfo":
				    var selectedRow = sheetObject.SelectRow;
					if(selectedRow < 0) {return;}
					var trfNo = sheetObject.CellValue(selectedRow, "trf_no");
                    ComOpenPopup('/hanjin/EES_MNR_0215.do?trf_no='+trfNo, 1015, 670, '', '1,0,1,1,1,1,1,1,1,1,1,1', false);
                    break;
					
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
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
    	//버튼 설정
    	MnrWaitControl(true);

        //IBMultiCombo초기화
 	    for(var k = 0; k < comboObjects.length; k++){
 	        initCombo(comboObjects[k], k + 1);
 	    }
		//IBSheet초기화
        for(i=0;i<sheetObjects.length;i++){
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+ 1);
        	
			//khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
		//Axon이벤트 초기화
		initControl();
		
		//Office Level 조회  및 전역변수(strMnrOfficeLevel)에 세팅
		MnrOfficeLevel(currOfcCd,rhqOfcCd);

		//화면 초기화 이벤트
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		
		//초기 포커스
		document.form.cbRegionalHq.focus();
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
	           	with (comboObj) { 
					SetTitle("Office Code|Office Name");
	        	   	SetColAlign("left|left");        
					SetColWidth("60|230"); 
				   	DropHeight = 160;  
					UseAutoComplete = true;
					UseEdit = true;
		    	}      
	        	break;    
	    	case 2: 
	           	with (comboObj) { 
					SetTitle("Office Code|Office Name");
	        	   	SetColAlign("left|left");        
					SetColWidth("60|270"); 
				   	DropHeight = 160;  
					UseAutoComplete = true;
		    	}      
	        	break;    
			
			case 3:
	    	case 4: 
	            with (comboObj) { 
			       SetColAlign("left");         
				   DropHeight = 160;  
		        }
	            break;
	     } 
	}

  	/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     * @param	{IBSheet}	sheetObj	초기설정될 시트오브젝트 
     * @param	{String}	sheetNo		시트오브젝트 태그의 아이디에 붙인 일련번호
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        switch(sheetNo) {
            case 1:      //t1sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 400;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 10, 100);

					var HeadTitle1 = "|Sel|Seq.|Regional HQ|Tariff Office|Tariff No.|EQ Type|Service Provider|Applied Material Cost Total to Tariff|Applied Material Cost Total to Tariff|Applied Material Cost Total to Tariff|Applied Material Cost Total to Tariff|Applied Material Cost Total to Tariff|Applied Material Cost Total to Tariff|Applied Material Cost Total to Tariff|Request Date|Status|Status Date|Remark(s)";
					var HeadTitle2 = "|Sel|Seq.|Regional HQ|Tariff Office|Tariff No.|EQ Type|Service Provider|Dry|Reefer Box|Reefer Unit|S/Dry|Chassis|MG Set|Total Ratio|Request Date|Status|Status Date|Remark(s)";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount+ 2, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		        	InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
                    InitDataProperty(0, cnt++ , dtCheckBox,		45,		daCenter,	true,	"sel_chk");      
                    InitDataProperty(0, cnt++ , dtDataSeq,		30,		daCenter,	true,	"seq");
					InitDataProperty(0, cnt++ , dtData,			75,		daCenter,	true,	"ar_hd_qtr_ofc_cd",	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			75, 	daCenter,	true,	"rqst_ofc_cd",    	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	true,	"trf_no",   		false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			55,		daLeft,		true,	"eq_knd_nm",    	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			130,	daLeft,		true,	"vndr_nm",    		false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	"dry",      		false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	"reefer_box",      	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	"reefer_unit",     	false,	"",	dfNone,		0,	false,	false);
	                InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	"special_dry",     	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	"chassis",     		false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	"genset", 			false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	"total_ratio",   	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,	"cre_dt",   		false,	"",	dfDateYmd,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			120,	daLeft,		true,	"mnr_trf_sts_nm",	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"mnr_trf_sts_dt",	false,	"",	dfDateYmd,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,	"mnr_trf_rmk",		false,	"",	dfNone,		0,	true,	true,	4000);
					//Hidden Column
					InitDataProperty(0, cnt++ , dtHidden,		50,		daLeft,		true,	"mnr_trf_sts_cd",	false,	"",	dfDateYmd,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daLeft,		true,	"agmt_no",			false,	"",	dfNone,		0,	false,	false);
					
					//SELECT 로우 배경색       
					SelectionMode = smSelectionRow;    
					SelectHighLight = true;            
					SelectFontBold = false;          
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);   
			
					MultiSelection = false;
					ShowButtonImage = 2;
				}
		        break;
        }
    }

	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 **/
	function initControl() {
	    axon_event.addListenerForm  ('blur', 		'obj_blur',		document.form); //- 포커스 나갈때
	    axon_event.addListenerFormat('focus',  		'obj_focus',    document.form); //- 포커스 들어갈때
	    axon_event.addListenerForm	('keypress',	'obj_keypress', document.form);	//- 키입력 할때
	    axon_event.addListenerFormat('change',	 	'obj_change',	document.form);	//- 변경될때
    }

	/** 
	 * IBCombo Object를 배열로 등록
	 * @param    {IBCombo}	combo_obj	배열로 등록될 IBCombo Object
	 */	
    function setComboObject(combo_obj){
 		comboObjects[comboCnt++] = combo_obj; 
 	}

	/** 
	 * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
	 * @param    {IBSheet}	sheet_obj	배열로 등록될 IBSheet Object
	 */	
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

	/**  
	 * cbRegionalHq Change 이벤트      
	 * @param {IBMultiCombo}  comboObj 콤보오브젝트  
	 * @param  {String}    Index_Code   Index 나 코드
	 * @param  {String}    Text   텍스트
	 */  
	function cbRegionalHq_OnChange(comboObj,Index_Code, Text){
		getAgmtOffice(Index_Code);
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
	          	if(obj.name=="vndr_seq"){
					ComKeyOnlyNumber(obj);
				} else {
					ComKeyOnlyAlphabet('uppernum');	
				}          
	            break;
			
			case "yyyy":
				ComKeyOnlyNumber(event.srcElement);
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
	 * 저장후 결과메세지 표시
	 * @param	{IBSheet}	sheetObj	저장이벤트의 시트 오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function sheet1_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") { 
			//(0:Approval, 1:Reject, 2:Delete)
			if(saveType==0) {
				ComShowCodeMessage("MNR00315");
			} else if (saveType==1) {
				ComShowCodeMessage("MNR00314");
			} else if (saveType==2) {
				ComShowCodeMessage("MNR00020");
			} else {
				ComShowCodeMessage("MNR00023");
			}
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		} 
		else { 
			ComShowCodeMessage("MNR00008",ErrMsg);  
		} 
	}     

  	/**
     * Sheet1관련 프로세스 처리
     * @param	{IBSheet}	sheetObj	프로세스 처리될 시트오브젝트 
     * @param	{Form}		formObj		프로세스 처리될 폼오브젝트
     * @param	{Number}	sAction		분기처리될 액션의 상수값(CoObject.js에 정의) 
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			//초기화
			case IBCLEAR:
				sheetObj.WaitImageVisible = false;
				MnrWaitControl(true);
				
				//쉬트 초기화
	    		sheetObjects[0].RemoveAll(); 
	        	//조건부 콤보데이타 초기화
				for(var i = 0; i < comboObjects.length;i++){
					if(i!=1) {
						comboObjects[i].RemoveAll(); //AGMT Combo 제외 
					}
				}
				//콤보조회
				var sCondition = new Array (
					new Array("MdmOrganization","RHQ","FALSE"),	//Regional HQ
					new Array("MnrGenCd","CD00007", "COMMON"), 	//Status
					new Array("MnrGenCd","SELHO","CUSTOM9")  	//EQ Type
				)
				var comboList = MnrComSearchCombo(sheetObj,sCondition); 
				for(var i = 0; i < comboList.length;i++){
					if(comboList[i] != null){
						var cnt = 0;
						for(var j = 0; j < comboList[i].length;j++){ 
							var tempText = comboList[i][j].split("|");
							//Regional HQ
							if(i==0) {
								formObj.cbRegionalHq.InsertItem(j, comboList[i][j], tempText[0]);
							//Status
							} else if(i==1) {
								//HA:Apporval, HJ:Reject, HR:Request
								if(tempText[0]=="HA"||tempText[0]=="HJ"||tempText[0]=="HR") {
									formObj.cbTariffStatus.InsertItem(cnt++, tempText[1] ,tempText[0]);
								}
							//EQ Type
							} else if(i==2) {
								formObj.cbEqType.InsertItem(j, tempText[1] ,tempText[0]);
							}
						}
					}
				}
				formObj.cbRegionalHq.InsertItem(0, "ALL" ,"A" );
				formObj.cbTariffStatus.InsertItem(0, "ALL" ,"A" );
				formObj.cbEqType.InsertItem(0, "ALL" ,"A" );
				//콤보초기값 설정
				//Regional HQ
				if(strMnrOfficeLevel=="L1"){
					formObj.cbRegionalHq.Code = "A";
				} else {
					formObj.cbRegionalHq.Enable = false;
					var rhqCd = MnrHqOfcByOfc(sheetObjects[0],currOfcCd);
					formObj.cbRegionalHq.Code = rhqCd;
				}
				formObj.cbEqType.Code 		= "A";   //EQ Type 
				formObj.cbTariffStatus.Code	= "A";   //Tariff Status
				//콤보이외의 값 설정
				formObj.vndr_seq.value	= "";
				formObj.vndr_nm.value	= "";
				formObj.eff_dt_to.value = ComGetNowInfo("yy");
				formObj.eff_dt_fr.value = ComGetNowInfo("yy") - 1;
				
				MnrWaitControl(false);
				sheetObj.WaitImageVisible = true;
				
				break;
			
			//조회
            case IBSEARCH:      
				if(validateForm(sheetObj,formObj,sAction)) {
					sheetObj.WaitImageVisible = true;
					formObj.f_cmd.value = SEARCH;
					//조회조건 설정
					formObj.ar_hd_qtr_ofc_cd.value	= ComGetObjValue(formObj.cbRegionalHq);		//Regional HQ
					formObj.rqst_ofc_cd.value 		= ComGetObjValue(formObj.cbAgmtOffice);		//AGMT Office
					formObj.eq_knd_cd.value 		= ComGetObjValue(formObj.cbEqType);			//EQ Type
					formObj.mnr_trf_sts_cd.value 	= ComGetObjValue(formObj.cbTariffStatus);	//Tariff Status
					//조회
					var sXml = sheetObj.GetSearchXml("EES_MNR_0136GS.do", FormQueryString(formObj));
					sheetObj.LoadSearchXml(sXml);
				}
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
			
			//저장
			case IBSAVE:
				if(validateForm(sheetObj,formObj,sAction)) {
					var mnrTrfStsCd = "";   //status
				    if(saveType==0) {
						mnrTrfStsCd = "HA"; //Apporval
					} else if(saveType==1) {
						mnrTrfStsCd = "HJ"; //Reject
					} else if(saveType==2){
						mnrTrfStsCd = "HD"; //Delete
					} else {
						ComShowCodeMessage("MNR00010","Status"); 
						return;
					}
					//set Status to Sheet 
					for(var i=sheetObjects[0].HeaderRows; i<=sheetObjects[0].LastRow; i++) {
						var selChk = sheetObjects[0].CellValue(i,"sel_chk");
						if(selChk=='1') {
							sheetObjects[0].CellValue2(i,"mnr_trf_sts_cd") = mnrTrfStsCd;
						}
					}
					formObj.f_cmd.value = MULTI;
					var sParam = ComGetSaveString(sheetObjects);
				    if (sParam == "") return;
				    sParam += "&" + FormQueryString(formObj);
				    var sXml = sheetObj.GetSaveXml("EES_MNR_0136GS.do", sParam);
				    sheetObj.LoadSaveXml(sXml);
				}
				saveType = 0;
				saveMsg  = "";
                break;

            //Down Excel
			case IBDOWNEXCEL:
			    //sheetObj.Down2Excel(-1);   
			    sheetObj.SpeedDown2Excel(-1);   
				break;
				
			default:
				break;
        }
    }

  	/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     * @param	{IBSheet}	sheetObj	유효성을 검증할 시트오브젝트 
     * @param	{Form}		formObj		유효성을 검증할 폼오브젝트
     * @param	{Number}	sAction		분기처리될 액션의 상수값(CoObject.js에 정의) 
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
			//조회시
			if(sAction==IBSEARCH){
				//IBMultiCombo 필수값 체크
				var arHdQtrOfcCd	= ComGetObjValue(formObj.cbRegionalHq);		//Regional HQ
				var rqstOfcCd 		= ComGetObjValue(formObj.cbAgmtOffice);		//AGMT Office
				if(arHdQtrOfcCd=='') {
					ComShowCodeMessage("MNR00036","Regional HQ");
					formObj.cbRegionalHq.focus();
				    return false;
				}
				if(rqstOfcCd=='') {
					ComShowCodeMessage("MNR00036","AGMT Office");
					formObj.cbAgmtOffice.focus();
				    return false;
				}
				//Dataformat
				if (!ComChkValid(formObj)) {return false;}
				//Effective Period
				var effDtFr = formObj.eff_dt_fr.value;
				var effDtTo = formObj.eff_dt_to.value;
				var effDtFrLen = effDtFr.length;
				var effDtToLen = effDtTo.length;
				if((effDtFrLen==0 && effDtToLen!=0) || (effDtFrLen!=0 && effDtToLen==0)) {
					ComShowCodeMessage("MNR00162");
					formObj.eff_dt_fr.focus();
					return false;
				}
				if(effDtTo - effDtFr < 0){
					ComShowCodeMessage("MNR00162");
					formObj.eff_dt_fr.focus();
					return false;
				}
				//조회 의사확인
				if(sheetObjects[0].IsDataModified) {
					if(!ComShowCodeConfirm("MNR00007")) {return false;}
				}
			
			//저장시
			} else if (sAction==IBSAVE) {
				//그리드가 존재하는지 체크
				if(sheetObjects[0].RowCount < 1) {return false;}
				//체크된 값이 있는지 체크
				var checkRow = sheetObj.FindCheckedRow("sel_chk");
				if(checkRow=='') {
					ComShowCodeMessage("MNR00038", saveMsg);
					return false;
				}
				//저장상태 중복 확인
				if(!checkStatus()) {return false;}
				//삭제시 agreement_no 존재유무 체크
				if(saveType==2) {
					for(var i=sheetObjects[0].HeaderRows; i<=sheetObjects[0].LastRow; i++) {
						var checkValue = sheetObjects[0].CellValue(i, "sel_chk");
						if(checkValue == '1') {
							var agmtNo = sheetObjects[0].CellValue(i, "agmt_no");
							if(agmtNo!="") {
								//Agreement에서 확인/제거를 먼저 처리하여 주시기 바랍니다.
								ComShowCodeMessage("MNR00289");
								sheetObjects[0].SelectCell(i, "trf_no", true);
								return false;
							}
						}
					}
				}
				//저장 의사확인
				if(!ComShowCodeConfirm("MNR00039", saveMsg)) {return false;}
			}
        }
        return true;
    }

/* ********* User Functions ************* */
   /**
	 * cbRegionalHq OnChange가 발생하는 경우 cbAgmtOffice 조회
	 * @param comboObj
	 * @param Index_Code
	 * @param Text
	 * @return
	 */   
	function getAgmtOffice(Index_Code){ 
		sheetObjects[0].WaitImageVisible = false;
		
		var formObj = document.form;
		formObj.cbAgmtOffice.removeAll();
		var sCondition = new Array ( 
			new Array("MdmOrganization","SEARCH",Index_Code) 
		)
		var comboList = MnrComSearchCombo(sheetObjects[0],sCondition); 
		if(comboList[0] != null){      
			for(var j = 0; j < comboList[0].length;j++){  
				var tempText = comboList[0][j].split("|");  
				formObj.cbAgmtOffice.InsertItem(j,comboList[0][j] ,tempText[0]);
			}             
		}    
		formObj.cbAgmtOffice.InsertItem(0,"ALL","A");     
		//초기값 설정
		if(strMnrOfficeLevel=="L3"){
			formObj.cbAgmtOffice.Enable = false;
			formObj.cbAgmtOffice.Code = currOfcCd;
		}else {
			formObj.cbAgmtOffice.Code = "A";
		}	

		sheetObjects[0].WaitImageVisible = true;
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
	
  	/**
     * 저장시 같은 상태의 정보가 있는지 체크한다.
     *    Approval 저장시 체크된 정보상태가 Apporval 이면   false 리턴  
     *    Reject   저장시 체크된 정보상태가 Request  아니면 false 리턴
	 * @return	{Boolean}	true/false     
     */
	function checkStatus() {
		//Approval
		if(saveType==0) {
			for(var i=sheetObjects[0].HeaderRows; i<=sheetObjects[0].LastRow; i++) {
				var selChk = sheetObjects[0].CellValue(i,"sel_chk");
				if(selChk=='1') {
					var mnrTrfStsCd = sheetObjects[0].CellValue(i,"mnr_trf_sts_cd");
					if(mnrTrfStsCd == "HA"){
						ComShowCodeMessage("MNR00208",(i- 1)+" row\'s Tariff",saveMsg);  //already Approval 
						sheetObjects[0].SelectCell(i, "sel_chk"); 
						return false;
					}
				}
			}
		//Reject
		} else if(saveType==1) {
			for(var i=sheetObjects[0].HeaderRows; i<=sheetObjects[0].LastRow; i++) {
				var selChk = sheetObjects[0].CellValue(i,"sel_chk");
				if(selChk=='1') {
					var mnrTrfStsCd = sheetObjects[0].CellValue(i,"mnr_trf_sts_cd");
					if(mnrTrfStsCd == "HJ"){
						ComShowCodeMessage("MNR00208",(i- 1)+" row\'s Tariff",saveMsg);  //already Reject 
						sheetObjects[0].SelectCell(i, "sel_chk");	 
						return false;
					}
				}
			}
		//Etc..
		} else {
		   return true;	
		}
		return true;
	}
/* 개발자 작업	*/