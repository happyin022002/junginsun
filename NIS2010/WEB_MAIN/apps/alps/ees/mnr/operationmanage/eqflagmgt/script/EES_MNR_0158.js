	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : EES_MNR_0158.js 
	 *@FileTitle : M&R Disposal Candidate Inquiry_Pop Up
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.09.21
	 *@LastModifier : 권영법
	 *@LastVersion : 1.0
	 *   2009.09.21 권영법
	 * 1.0 Creation
	=========================================================*/
	/****************************************************************************************
	  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
						[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
						기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
	 ***************************************************************************************/
	
	/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
	
	/**
	 * @extends 
	 * @class ees_mnr_0158 : ees_mnr_0158 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_MNR_0158() {
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
	
	//공통전역변수
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var nowLoad = 0;

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
				doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
				break;
				
			case "btn_ok":
				if(sheetObjects[0].FindCheckedRow("checkbox") == ""){ 
					ComShowCodeMessage("MNR00038","SELECT ");             	   
				} else {     
					if(window.dialogArguments != undefined)
					{	
						var checkValue=sheetObjects[0].GetRangeText(sheetObjects[0].SelectRow, 1, sheetObjects[0].SelectRow,  sheetObjects[0].LastCol , "|", "^");
						//window.dialogArguments.setPopUpParam_EES_MNR_0214(checkValue);
						self.close();   
					}else{
						comPopupOK();    	
					}
				}   
				break;
	
			case "btn_close":
				self.close();
				break;
				
			case "btn_location":
				ComOpenPopup("COM_ENS_051.do", 800, 460, 'setPopUpParam_COM_ENS_051', '1,0', true);
				break;	
				
			case "btn_downExcel":
				sheetObjects[0].SpeedDown2Excel(-1); 
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
    
    function setPopUpParam_COM_ENS_051(array) {
    	if(array == null)return;
    	var formObj = document.form;
    	var str = array + "";
    	var arr = str.split(",");
 
    	formObj.location_cd.value = arr[3];

    	if(arr[3] !="")
    	{
    		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	}
    }    

    
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
		MnrWaitControl(true);
		initControl();
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
	
			initSheet(sheetObjects[i],i + 1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		MnrWaitControl(false);	
    }

  	function initControl() {       
  		//Axon 이벤트 처리1. 이벤트catch  
  		var formObject = document.form;       
  		axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject);	//- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
  		axon_event.addListenerFormat('focus',    'obj_activate',    formObject);    //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
  		axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);    //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
  		axon_event.addListenerFormat('change',	 'obj_change',		formObject); 	//- 변경될때.
  	}             
  	
  	//Axon 이벤트 처리2. 이벤트처리함수   
  	function obj_deactivate(){      
  		ComChkObjValid(event.srcElement); 
  	} 
  	
  	function obj_activate(){   
  		ComClearSeparator(event.srcElement);
  	}        
  	
  	function obj_change(){	     
  		var obj      = event.srcElement; 
  		var formObj  = document.form; 
  		var sheetObj = sheetObjects[0]; 
  	
  		if ( ComTrim(obj.value) != "" ) {
  			switch(obj.name) {      
  			case "empty":    
  				break;   
  			}        
  		} 
  	}    
  	
  	function obj_keypress(){   
  		obj = event.srcElement;    
  		keys = event.keyCode;	
  		if(obj.dataformat == null) return; 
  		window.defaultStatus = obj.dataformat;
  		var formObj  = document.form; 
  		if ( ComTrim(obj.value) != "" ) {
  			switch(obj.name) { 	     
  			case "location_cd":   
  				var strMnrOrdSeqAll=formObj.location_cd.value;
  				var strMnrOrdSeqTail="";
	
  				if(strMnrOrdSeqAll.length >= 5)
  				{ 
  					if(keys==13)
  					{
  						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
  					}
  				}
  				break;   
  			}       
  		}				 			              
  		switch(obj.dataformat) {   
  		case "ymd":   
  		case "int":       
  			ComKeyOnlyNumber(obj); 
  			break;     
  		case "float":    
  			ComKeyOnlyNumber(obj, "-.");
  			break; 
  		case "eng":   
  			ComKeyOnlyAlphabet();
  			break;   
  		case "engup":  
  			ComKeyOnlyAlphabet('uppernum');           
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
                    style.height = 285;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);
					
					var HeadTitle1 = "|Sel|Seq|Sale Category|EQ No|TP/SZ|TERM|MVMT|YARD|EventDate|S/Days|Damaged Flag|BKG No|Material|Maker Name|Unit Model|M/Date|CRE DT|DV Value|";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(22, 0, 0, true);  
					 
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)
						
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
								
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
        			var prefix = "sheet1_";
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	50,		daCenter,	true,		prefix+	"ibflag");
        			InitDataProperty(0, cnt++ , dtCheckBox,    	40,     daCenter,   true,       "checkbox",              			false,	"", dfNone,	0, true,  true);
                    InitDataProperty(0, cnt++ , dtSeq,		   	40,		daCenter,	true,		"Seq");
					InitDataProperty(0, cnt++ , dtCombo,	  	100,	daLeft,		true,		prefix+	"disp_rsn_cd",				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,		  	100,	daCenter,	true,		prefix+	"eq_no",					false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		   	50,		daCenter,	true,		prefix+	"eq_tpsz_cd",				false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		   	80,		daCenter,	true,		prefix+	"lstm_cd",					false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		   	80,		daCenter,	true,		prefix+	"mvmt_cd",					false,	"",	dfNone, 0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		   	80, 	daCenter,	true,		prefix+	"mnr_dmg_flg_yd_cd",		false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		   	80, 	daCenter,	true,		prefix+	"mvmt_dt",					false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		   	80, 	daCenter,	true,		prefix+	"sdays_dt",					false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		   	100,	daCenter,	true,		prefix+	"mst_dmg_flag",				false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		   	150, 	daCenter,	true,		prefix+	"bkg_no",					false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		   	100,	daLeft,		true,		prefix+	"mtrl_nm",					false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		   	100,	daLeft,		true,		prefix+	"eq_mkr_nm",				false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		   	100,	daLeft,		true,		prefix+	"eq_mdl_nm",				false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		   	80,		daCenter,	true,		prefix+	"manu_dt",					false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		   	80,		daCenter,	true,		prefix+	"cre_dt",		    		false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	false,		prefix+	"dv_value",					false,	"",	dfFloat,2,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,	   	100,	daCenter,	true,		prefix+	"mtrl_cd",		  	  		false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,	   	100,	daCenter,	true,		prefix+	"ut_price",		  	  		false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,	   	100,	daCenter,	true,		prefix+	"rpr_cost_amt",		  	  	false,	"",	dfNone,	0,	false,	false);
													
					//SELECT 로우 배경색	 	      
					SelectionMode = smSelectionRow;    
					SelectHighLight = false;             
					SelectFontBold = false;          
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);   
					EditableColorDiff = true; 
				}	
		break;
	         		
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
    	switch(sAction) {
    	case IBCLEAR:
    		MnrWaitControl(true);
    		
			if(MnrNullToBlank(formObj.cost_ofc_cd.value) == ""){
				formObj.cost_ofc_cd.value = currOfcCd;
			}	
									
    		formObj.location_cd.value="";
							
    		sheetObjects[0].RemoveAll();
			sheet1_disp_rsn_cd_Initialize();
			
    		MnrWaitControl(false);
    		break;

    	case IBSEARCH:      //조회
    		MnrWaitControl(true);
    		if(!validateForm(sheetObj,formObj,sAction))
    		{
    			MnrWaitControl(false);
    			return;
    		}

    		nowLoad = 1;
    		sheetObjects[0].RemoveAll();

    		formObj.f_cmd.value = SEARCH; 
    		var sParam = "";
    		var aryPrefix = new Array("sheet1_");

    		sParam += ComGetPrefixParam(aryPrefix)+ "&" + FormQueryString(formObj);

    		//alert("IBSEARCH : " + "\n"+ sParam);
    		var sXml   = sheetObj.GetSearchXml("EES_MNR_0158GS.do", sParam);
    		arrDataSearchDbXml = sXml.split("|$$|");

    		for ( var i = 0; i < arrDataSearchDbXml.length; i++) {

    			sheetObjects[i].Redraw = false;
    			sheetObjects[i].WaitImageVisible = false;
    			sheetObjects[i].LoadSearchXml(arrDataSearchDbXml[i]);
    			sheetObjects[i].Redraw = true;
    		}   		 	   
    		break;
    	}
    }

	function sheet1_disp_rsn_cd_Initialize(){
		var sheetObj=sheetObjects[0];
		//콤보조회
		var sCondition = new Array (
			new Array("MnrGenCd","CD00038", "COMMON") //Sale Category		
		);
		var comboList = MnrComSearchCombo(sheetObj,sCondition);
		//쉬트 설정
		var sheetComboText = "";
		var sheetComboCode = "";
		var sheetComboCodeText = "";
		var sheetComboDefault = "";
		for(var i = 0; i < comboList.length;i++)
		{
			//쉬트콤보별 초기화
			sheetComboText = "";
			sheetComboCode = "";
			sheetComboCodeText = "";
			sheetComboDefault = ""; 
			if(comboList[i] != null)
			{	
				for(var j = 0; j < comboList[i].length;j++)
				{ 
					var tempText = comboList[i][j].split("|");   
					sheetComboText +=  tempText[1] + "|";
					sheetComboCode +=  tempText[0] + "|";
					sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
					if(j ==0)
					{	
						sheetComboDefault = tempText[0];      	
					}
				}
				//쉬트 콤보 설정
				if(i == 0)
				{
					sheetObjects[0].InitDataCombo(0, "sheet1_disp_rsn_cd", sheetComboText, sheetComboCode, sheetComboDefault);
				}
			}
		}		
	}    	
		
    function sheet1_OnSearchEnd(sheetObj,errMsg){
        if(errMsg!=""){
            showErrMessage(errMsg);
        }
        MnrWaitControl(false);
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
			switch(sAction) {  	
				case IBSEARCH:      
					if (!ComChkValid(formObj)) return false;
				break;
			}	
        }
        return true;
    }	
	
	function sheet1_OnChange(sheetObj,Row, Col, Value){ 
		if(sheetObj.ColSaveName(Col) == "checkbox"){
			MnrCheckRowColChange(sheetObj,sheetObj.CellValue(Row,"checkbox"),Row);  
		}	
	}
	
	function sheet1_OnClick(sheetObj,Row,Col){   
		if(sheetObj.ColSaveName(Col) != "checkbox"){
			if(sheetObj.CellValue(Row,"checkbox") == "1"){
				sheetObj.CellValue(Row,"checkbox") = "0";
			} else {
				sheetObj.CellValue(Row,"checkbox") = "1";  
			}   
		}
 	}
