	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : EES_MNR_0119.js
	 *@FileTitle : PFMC by CEDEX Code
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.10.05
	 *@LastModifier : 민정호
	 *@LastVersion : 1.0
	 * 2009.10.05 민정호
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
	 * @class EES_MNR_0119 : EES_MNR_0119 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_MNR_0119() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.setTabObject 			= setTabObject;
		this.validateForm 			= validateForm;
	}
	// 공통전역변수
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var comboObjects = new Array();
	var comboCnt = 0;
	var checkRows;
	var vFmt_dt="";
	var vTo_dt="11";
	//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch(srcName) {
	
			case "btn_Retrieve":
				vFmt_dt=formObject.fm_dt.value;
				vTo_dt =formObject.to_dt.value ;
				
				var dmgValue = formObject.damage.Code;
				if(dmgValue == 'FQ'){
					sheetObjects[0].ColHidden("chk")  = false;
				}else{
					sheetObjects[0].ColHidden("chk")  = true;
				}
				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				break;
			case "btn_New":
				doActionIBSheet(sheetObject1,formObject,IBCLEAR);
				break; 		            
			case "btn_DownExcel":
				doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
				break;
			case "btn_calendar": 
				var cal = new ComCalendarFromTo(); 
				cal.select(formObject.fm_dt, formObject.to_dt, 'yyyy-MM-dd');       						
				break; 	 				
			case "btn_provider_popup":
				ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 450, 'setPopData_Sp', '1,0,1,1,1,1,1,1', true);
				break;					
			case "btn_location":
				ComOpenPopup('EES_MNR_0193.do?rec_eq_knd_cd=' + formObject.eq_type.Code, 896, 498, 'setEES_MNR_0193', '1,0,1,1,1,1,1,1,1,1,1,1'); 
				break;	
			case "btn_DetailInformation":
				if(sheetObject1.RowCount == 0){ 
					ComShowCodeMessage("MNR00204");			
				} else { 
				    // W/O Type ALL 팝업 구분
					//견적서 팝업 호출 
					checkRows = sheetObject1.CheckedRows("chk");
					if(checkRows == 0 && sheetObject1.RowCount > 0 ){
						ComShowCodeMessage("MNR00309");
					}else{

						ComOpenPopup('/hanjin/EES_MNR_0119_01.do', 1024, 550, '', '1,0,1,1,1,1,1,1,1,1,1,1', true);
						//ComOpenPopup('/hanjin/EES_MNR_0119_01.do', 1024, 550, '', '1,0,1,1,1,1,1,1,1,1,1,1');
					}
				}	
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
	 * IBCombo Object를 배열로 등록
	 * @param	{IBMultiCombo}	combo_obj	화면에서 사용할 콤보들을 추가한다. 
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
		initControl();
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i + 1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		//IBMultiCombo초기화 
		for(var k=0;k<comboObjects.length;k++){ 
			initCombo(comboObjects[k],k + 1);    
		}
		sheetObjects[0].ColHidden("chk")  = true;
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		ComBtnDisable("btn_DetailInformation");
	}	
			
	function initControl() {       
		//Axon 이벤트 처리1. 이벤트catch 
		axon_event.addListenerForm  ('blur', 'obj_deactivate',  form); 			      //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
		axon_event.addListenerFormat('focus',   'obj_activate',    form);             //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListenerFormat('change',	 'obj_change',		form); 	  //- 변경될때.
	}           
	
	/**
	 * HTML Control의 deactivate 이벤트 <br>
	 **/
	function obj_deactivate(){    
		obj = event.srcElement;       
		ComChkObjValid(event.srcElement); 
	} 
	
	/**
	 * HTML Control의 activate 이벤트 <br>
	 **/
	function obj_activate(){   
		ComClearSeparator(event.srcElement);
	}  
	
	function obj_change(){	     
		var obj      = event.srcElement; 
		var formObj  = document.form; 
		var sheetObj = sheetObjects[0]; 
		if ( ComTrim(obj.value) != "" ) {
			switch(obj.name) {       
			case "vndr_seq":  
				formObj.vndr_seq.value = ComLpad(formObj.vndr_seq.value,6,"0");  
				doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01);
				break;	   
			}       
		} else {
			switch(obj.name) {      
			case "vndr_seq":    
				ComSetObjValue(formObj.vndr_lgl_eng_nm,"") 
				break;   	
			}  		
		}
	} 
	
	/**
	 * HTML Control의 keypress 이벤트 <br>
	 **/     
	function obj_keypress(){     
		obj = event.srcElement;    
		if(obj.dataformat == null) return; 
		window.defaultStatus = obj.dataformat;
	
		switch(obj.dataformat) {  
		case "ymd":   
		case "int":    
			ComKeyOnlyNumber(obj); 
			break;     
		case "float":   
			ComKeyOnlyNumber(obj, ".");
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
	 * Combo 기본 설정    
	 * @param	{IBMultiCombo}	combo_obj	콤보오브젝트. 
	 * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호 
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */     
	function initCombo (comboObj, comboNo) {        
		var formObject = document.form
		switch(comboNo) {          	    
		case 1: 
			with (comboObj) { 
				MultiSeparator = "|";
				SetTitle("Period|Amount");	
				SetColAlign("left|left");		        
				SetColWidth("100|100");			     
				DropHeight = 160;		         
				UseAutoComplete = true;
			}        
			break;  
		case 2: 
			with (comboObj) { 
				MultiSelect = true;
				SetColAlign("left");        
				SetColWidth("80");      
				DropHeight = 160;  
				UseAutoComplete = true;
			}   
			break;	        	        	
		case 3: 
		case 4: 
			with (comboObj) { 
				MultiSeparator = "|";
				SetTitle("Office Code|Office Name");
				SetColAlign("left|left");        
				//SetColWidth("100|150"); 
				DropHeight = 160;  
				UseAutoComplete = true;
			}      
			break;      
		case 5: 
			with (comboObj) { 
				SetTitle("Code|Code Desc");
				SetColAlign("left|left");        
				SetColWidth("50|150");      
				DropHeight = 160;  
				UseAutoComplete = true;
			}      
			break;
		case 6: 
			with (comboObj) { 
				SetTitle("Code|Code Desc");
				SetColAlign("left|left");        
				SetColWidth("50|150");      
				DropHeight = 160;  
				UseAutoComplete = true;
			}      
			break;        	
		case 7: 
			with (comboObj) { 
				SetTitle("Code|Code Desc");
				SetColAlign("left|left");        
				SetColWidth("50|150");      
				DropHeight = 160;  
				UseAutoComplete = true;
			}      
			break;   
		case 8:     
			with (comboObj) { 
				SetTitle("Code|Code Desc");
				SetColAlign("left|left");        
				SetColWidth("50|150");      
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
		var sheetID = sheetObj.id;
	
		switch(sheetID) {
	
		case "sheet1":
			with (sheetObj) {
	
				// 높이 설정
				style.height = 350;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msNone;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
	
				var HeadTitle = "|chk|Seq.|EQ Type|Location\nCode|Component|Component\nName|Repair|Repair\nName|Division|Division\nName|Damage|Damage\nName|RHQ.|Office|S/P Code|S/P Name|Curr|QTY|Labor\nCost|Material\nCost|Total\nAMT|Average\nAmt";
				
				var headCount = ComCountHeadTitle(HeadTitle);
					
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false);
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
								
				//데이터속성                [ROW, COL,  DATATYPE,                WIDTH, DATAALIGN, COLMERGE, SAVENAME,     KEYFIELD, CALCULOGIC, DATAFORMAT,      POINTCOUNT,   UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,			0,		daCenter,	false,	"hdnStatus");
				InitDataProperty(0, cnt++ , dtCheckBox, 			30,     daCenter,  false,   "chk",		    false,  "",            dfNone,                0,         true,       true);
				InitDataProperty(0, cnt++ , dtSeq,					30,		daCenter,	false,	"seq",		    false,	"",	           dfNone,	  	          0,	     true,       true);
				InitDataProperty(0, cnt++ , dtCombo,				70,		daCenter,	false,	"eq_knd_cd",	false,	"",            dfNone,                0,        false,      false);
				InitDataProperty(0, cnt++ , dtData,					60,		daCenter,	false,	"eq_loc_cd",	false,	"",            dfNone,                0,        false,      false);
                                                                                                                                                              
				InitDataProperty(0, cnt++ , dtData,					70,		daCenter,	false,	"eq_cmpo_cd",	false,	"",            dfNone,                0,        false,      false);
				InitDataProperty(0, cnt++ , dtData,					100,	daLeft,		false,	"eq_cmpo_nm",	false,	"",            dfNone,                0,        false,      false);
				InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	false,	"eq_rpr_cd",	false,	"",            dfNone,                0,        false,      false);
				InitDataProperty(0, cnt++ , dtData,					100,	daLeft,		false,	"eq_rpr_nm",	false,	"",            dfNone,                0,        false,      false);
				InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	false,	"trf_div_cd",	false,	"",            dfNone,                0,        false,      false);
				InitDataProperty(0, cnt++ , dtData,					100,	daLeft,		false,	"trf_div_nm",	false,	"",            dfNone,                0,        false,      false);
				                                                                                                                                              
				InitDataProperty(0, cnt++ , dtData,					60,		daCenter,	false,	"eq_dmg_cd",	false,	"",            dfNone,                0,        false,      false);
				InitDataProperty(0, cnt++ , dtData,					100,	daLeft,		false,	"eq_dmg_nm",	false,	"",            dfNone,                0,        false,      false);
				InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	false,	"rhq",			false,	"",            dfNone,                0,        false,      false);
				InitDataProperty(0, cnt++ , dtData,					60,		daCenter,	false,	"cost_ofc_cd",	false,	"",            dfNone,                0,        false,      false);
				InitDataProperty(0, cnt++ , dtData,					80,		daLeft,		false,	"vndr_seq",		false,	"",            dfNone,                0,        false,      false);
				InitDataProperty(0, cnt++ , dtData,					170,	daLeft,		false,	"vndr_seq_nm",	false,	"",            dfNone,                0,        false,      false);
				InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	false,	"curr_cd",		false,	"",            dfNone,                0,        false,      false);
				InitDataProperty(0, cnt++ , dtAutoSum,				50,		daRight,	false,	"qty",			false,	"",            dfNone,                0,        false,      false);
				InitDataProperty(0, cnt++ , dtData,					80,		daRight,	false,	"lbr_cost_amt",	false,	"",            dfNullFloat,		      2,        false,      false);
				InitDataProperty(0, cnt++ , dtData,					80,		daRight,	false,	"mtrl_cost_amt",false,	"",            dfNullFloat,		      2,        false,      false);
				InitDataProperty(0, cnt++ , dtAutoSum,				100,	daRight,	false,	"t_amt",	    false,	"",            dfNullFloat,		      2,        false,      false);
				InitDataProperty(0, cnt++ , dtAutoSum,				100,	daRight,	false,	"t_avg",	    false,	"",            dfNullFloat,		      2,        false,      false);
																	
				CountPosition = 0;
				
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
			if (sheetObj.id == "sheet1"){
				if(formObj.currency_ck.checked)
				{
					formObj.currency.value="Y";
				}else{
					formObj.currency.value="N";
				}
				if(formObj.qty_ck.checked)
				{
					formObj.qty.value="Y";
				}else{
					formObj.qty.value="N";
				}
					
				formObj.f_cmd.value = SEARCH;     
				sheetObj.DoSearch("EES_MNR_0119GS.do",FormQueryString(formObj));
			}
		}
		break;
	
		case IBCLEAR:      //초기화
		MnrWaitControl(true);
		sheetObj.WaitImageVisible = false;
	
		//쉬트 초기화   
		for(i=0;i<sheetObjects.length;i++){   
			sheetObjects[i].RemoveAll();    
		}  
	
		//콤보 초기화 
		for(var i = 0; i < comboObjects.length;i++){ 
			comboObjects[i].RemoveAll();       
		}	  				
	
		//공통콤보 정보를 가져온다.    
		var sCondition = new Array ( 
				new Array("MnrGenCd","CD00055", "COMMON"),   //Report Period Type
				new Array("MnrGenCd","","CUSTOM9"),          //EQ TYPE
				new Array("MdmOrganization","RHQ","FALSE"),  //Regional HQ
				new Array("MnrEqCmpoCd","3","COMMON"),       //Component
				new Array("MnrCedexOthCd","RPR","COMMON"),    //Repair
				new Array("MnrCedexOthCd","DMG","COMMON") 	  //Demage	
		);
		
		//EQ Type   
		formObj.eq_type.InsertItem(0,"ALL","A");
		//Regional HQ  
		formObj.rhq.InsertItem(0,"ALL","A");
		//Component
		formObj.component.InsertItem(0,"ALL","A");
		//Repair		
		formObj.repair.InsertItem(0,"ALL","A");	
		//Damage		
		formObj.damage.InsertItem(0,"ALL","A");	
	
	
		var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);
		var sheetComboText = "";
		var sheetComboCode = "";
		var sheetComboCodeText = "";
		var sheetComboDefault = "";
		for(var i=0;i<comboList.length;i++)
		{
			sheetComboText = "";
			sheetComboCode = "";
			sheetComboCodeText = "";
			sheetComboDefault = ""; 
			if(comboList[i] != null){        
				for(var j = 0; j < comboList[i].length;j++){  
					var tempText = comboList[i][j].split("|");  
					sheetComboText +=  tempText[1] + "|";
					sheetComboCode +=  tempText[0] + "|";
					sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
					if(i==0){
						tempText[1] = tempText[1] + '|' + 'Estimate Amt';
						formObj.report_period_type.InsertItem(j,tempText[1] ,tempText[0]);
					}else if(i==1){
						formObj.eq_type.InsertItem(j + 1,tempText[1] ,tempText[0]);
					}else if(i==2){
						formObj.rhq.InsertItem(j + 1,comboList[i][j] ,tempText[0]);
					}else if(i==3){
						formObj.component.InsertItem(j + 1,comboList[i][j] ,tempText[0]);
					}else if(i==4){
						formObj.repair.InsertItem(j + 1,comboList[i][j] ,tempText[0]);
					}else if(i==5){
						formObj.damage.InsertItem(j + 1,comboList[i][j] ,tempText[0]);						
					}
					if(i==1)sheetObjects[0].InitDataCombo (0, "eq_knd_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
				}  
			}  
		}
	
		//기본값 세팅 	
		formObj.report_period_type.Code = "WI";  
		formObj.currency_ck.checked=false;
		formObj.qty_ck.checked=false;
		formObj.qty.value="N";
		formObj.eq_type.Code = "A";
		formObj.rhq.Code = "A";	 
		formObj.ofc_cd.Code = "A";	 
		formObj.component.Code = "A";	
		formObj.repair.Code = "A";	
		formObj.division.Code = -1;    	
		formObj.damage.Code = "A";	

		formObj.fm_dt.value = ComGetDateAdd(ComGetNowInfo("ymd"), "M", -1);
		MnrSetFromDate(formObj.fm_dt);	
		formObj.to_dt.value = ComGetNowInfo();
				
		formObj.vndr_seq.value = ""; 
		formObj.vndr_lgl_eng_nm.value = ""; 
		
		sheetObj.ColHidden("eq_dmg_cd")			= false;
		sheetObj.ColHidden("eq_dmg_nm")			= false;
		sheetObj.ColHidden("rhq")				= false;
		sheetObj.ColHidden("cost_ofc_cd")		= false;
		sheetObj.ColHidden("vndr_seq")			= false;
		sheetObj.ColHidden("vndr_seq_nm")		= false;
		sheetObj.ColHidden("eq_loc_cd")			= false;
			
		sheetObj.WaitImageVisible = true;
		MnrWaitControl(false);  				
		break;
	
		case IBDOWNEXCEL:
			sheetObj.SpeedDown2Excel(-1);   
			break;	 
	
		case IBSEARCH_ASYNC01:	//조회(sevice provider No. 입력시)
		if ( validateForm(sheetObj, formObj, sAction) ) { 
			if(Number(formObj.vndr_seq.value)){
				//서비스 프로바이더 조회     	
				var sCondition = new Array ( 	 
						new Array("MdmVendor",formObj.vndr_seq.value,"COMMON")
				)                             
				//조회 값이 있다면 세팅
				var comboList = MnrComSearchCombo(sheetObjects[0],sCondition); 
				if(comboList[0] != null){  
					var tempText = comboList[0][0].split("|");  
					formObj.vndr_lgl_eng_nm.value  = tempText[1];   
				} else {        
					ComShowCodeMessage("MNR00005", "Service Provider");              
					ComSetObjValue(formObj.vndr_lgl_eng_nm, "");  
					ComSetObjValue(formObj.vndr_seq, "");   
					ComSetFocus(formObj.vndr_seq);  
				}  
			} else {        
				ComShowCodeMessage("MNR00005", "Service Provider");              
				ComSetObjValue(formObj.vndr_lgl_eng_nm, "");  
				ComSetObjValue(formObj.vndr_seq, "");   
				ComSetFocus(formObj.vndr_seq);  
			}  
		}	
		break;		
	
		}
	}
	
	
	/**
	 * Division 콤보 초기화
	 */      
	function set_Division_Combo(sheetObj,formObj,sAction){	  
		if(ComTrimAll(formObj.component.Code) != "A" && ComTrimAll(formObj.repair.Code) != "A"){
			formObj.division.RemoveAll();
			var compRprJoinStr = ComTrimAll(formObj.component.Code) + ComTrimAll(formObj.repair.Code);   
			var sCondition = new Array (      
					new Array("MnrDivCd",compRprJoinStr,"COMMON") 		//Division
			)              
	
			var comboList = MnrComSearchCombo(sheetObj,sCondition);
			if(comboList[0] != null){			
				for(var j = 0; j < comboList[0].length;j++){   
					var tempText = comboList[0][j].split("|");  
					formObj.division.InsertItem(j, comboList[0][j] ,tempText[0]);
				}    	 			
			}
		}	
	} 		   
	
	//멀티콤보 클릭 이벤트	
	function eq_type_OnCheckClick(comboObj, index, code) { 
		MnrAllChkMultiCombo(comboObj,index);    		  
	}
	 
	/**  
	 * component Change 이벤트      
	 * @param {IBMultiCombo}  comboObj 콤보오브젝트  
	 * @param  {String}    Index_Code   Index 나 코드
	 * @param  {String}    Text   텍스트
	 */  
	function component_OnChange(comboObj,Index_Code, Text){  
		set_Division_Combo(sheetObjects[0],document.form,'');	
	}		 
	
	/**  
	 * repair Change 이벤트      
	 * @param {IBMultiCombo}  comboObj 콤보오브젝트  
	 * @param  {String}    Index_Code   Index 나 코드
	 * @param  {String}    Text   텍스트
	 */  
	function repair_OnChange(comboObj,Index_Code, Text){
		set_Division_Combo(sheetObjects[0],document.form,'');	
	}
	
	/**  
	 * rhq Change 이벤트		      
	 * @param {IBMultiCombo}  comboObj 콤보오브젝트  
	 * @param  {String}    Index_Code   Index 나 코드
	 * @param  {String}    Text   텍스트
	 */  	
	function rhq_OnChange(comboObj,Index_Code, Text){
		var formObj  = document.form;       
		var sCondition = new Array (
				new Array("MdmOrganization","SEARCH",Index_Code)   //Office
			);   
		var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);
	
		if(comboList[0] != null){
			for(var i = 0; i < comboList[0].length;i++){ 
				var code = comboList[0][i].substring(0, comboList[0][i].indexOf('|') );
				formObj.ofc_cd.InsertItem(i, comboList[0][i] , code);			   
			}
			formObj.ofc_cd.InsertItem(0, "ALL" , "A"); 
			formObj.ofc_cd.Code = "A";  
		}		 
	}  	
	 
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			if(sAction==IBSEARCH) {	  	    
				if(!MnrChkFromDate(formObj.fm_dt)) return false;
			}  				
		}
		return true;
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
			formObj.vndr_lgl_eng_nm.value  = aryPopupData[0][4];
		}
	}	
	
	/**
	 * rep_Multiful_inquiry 사용시 받는부분  
	 * 소스에 붙여서 사용하세요          
	 * Location : 팝업에서 단일 선택을 한경우..     
	 */      
	function getMnr_Multi(rowArray,return_val) {
		var formObj = document.form;  
		var tempText = ""; 	
		//초기화	   
		for(var i=0; i<rowArray.length; i++) {   
			var colArray = rowArray[i];     
			tempText +=  rowArray[i] + ','; 	  
		}      
		//마지막에 ,를 없애기 위함     
		tempText = MnrDelLastDelim(tempText);	 
	
		tempText = tempText.toUpperCase(); 	            
		eval("document.form." + return_val + ".value = '" + tempText + "';"); 
	}
	
	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{	
		with(sheetObj)	
		{
			SumText(0, "RegionalHQ") = "Grand Total";
		}		
		if(document.form.qty.value=="Y"){
			sheetObj.ColHidden("eq_dmg_cd")			= true;
			sheetObj.ColHidden("eq_dmg_nm")			= true;
			sheetObj.ColHidden("rhq")				= true;
			sheetObj.ColHidden("cost_ofc_cd")		= true;
			sheetObj.ColHidden("vndr_seq")			= true;
			sheetObj.ColHidden("vndr_seq_nm")		= true; 
			sheetObj.ColHidden("eq_loc_cd")			= true; 
		} else {									
			sheetObj.ColHidden("eq_dmg_cd")			= false;
			sheetObj.ColHidden("eq_dmg_nm")			= false;
			sheetObj.ColHidden("rhq")				= false;
			sheetObj.ColHidden("cost_ofc_cd")		= false;
			sheetObj.ColHidden("vndr_seq")			= false;
			sheetObj.ColHidden("vndr_seq_nm")		= false;
			sheetObj.ColHidden("eq_loc_cd")		= false;
		}				
					
		var aFloat = parseFloat(sheetObj.SumValue(0,"t_amt") + "");										
		var bFloat = parseFloat(sheetObj.SumValue(0,"qty") + ""); 
		var avgFloat = 0;	
		if(bFloat != 0){			
			avgFloat = parseFloat(aFloat / bFloat).toFixed(2);
		} 						  	
		sheetObj.SumValue(0,"t_avg") = avgFloat; 
	}
	
	/**
	 * EES_MNR_0193 Popup의 값을 받은 함수        
	 */	
	function setEES_MNR_0193(aryPopupData){
		var tagetSheet = sheetObjects[2]; 
		var formObj = document.form;			   			
		for(var i = 0; i < aryPopupData.length;i++){
			formObj.location_cd.value = aryPopupData[i];  
		}	
	} 	
	
//	var pCheckedRow='';
	function sheet1_OnChange(sheet , row, col, value) {	
		var dmgValue = sheet.CellValue(row , "eq_dmg_cd");
		if(dmgValue == 'FQ'){
			ComBtnEnable("btn_DetailInformation");
		}else{
			ComShowMessage("it isn't FQ Damage in selected Row");
			sheet.CellValue2(row , "chk")=0;
			ComBtnDisable("btn_DetailInformation");
		}		
	}

	function damage_OnChange(comboObj, code, text) {
		if(code=='FQ'){
			ComBtnEnable("btn_DetailInformation");
		}else{
			ComBtnDisable("btn_DetailInformation");
		}
	}	 