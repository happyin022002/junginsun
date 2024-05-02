/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mnr_0014.js
*@FileTitle : MNR Standard Tariff Creation and Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.05
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.06.05 김완규
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
     * @class ees_mnr_0014 : ees_mnr_0014 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mnr_0014() {
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
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var comboObjects = new Array();
	var comboCnt = 0;
	var comboValue = "";
	var saveType = 0;  //0:save, 1:confirm, 2:Delete
	var searchType = 0; //0:search, 1:load excel
	var comboListGrid =new Array();
	var sSaveRtnXml = "";
	//탭메뉴를 가지고 있는 배열
	var tabList = new Array();
	var uTab = new Array();  
	var gTab = new Array(); 
	var zTab = new Array(); 
	var initflag = false;
	var dummyEvent = false;  

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/** 
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
	 */	
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject7 = sheetObjects[0];  //hidden sheet
        
        var sheetObject1 = sheetObjects[1];
        var sheetObject2 = sheetObjects[2];
        var sheetObject3 = sheetObjects[3];
        var sheetObject4 = sheetObjects[4];
        var sheetObject5 = sheetObjects[5];
        var sheetObject6 = sheetObjects[6];

        /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,document.form,IBSEARCH);
					break;

				case "btn_New":
					doActionIBSheet(sheetObject2,document.form,IBCLEAR,1);
					break;

				case "btn_Delete":
					doActionIBSheet(sheetObject3,document.form,IBSAVE);
					break;

				case "btn_Save":
					doActionIBSheet(sheetObject1,document.form,IBSAVE);
					break;

				case "btn_Confirm":
					doActionIBSheet(sheetObject2,document.form,IBSAVE);
					break;

				case "btn_Copy":
					doActionIBSheet(sheetObject1,document.form,"COPY");
					break;

                //Tafiff No. PopUp
				case "trf_no_popup":
				    ComOpenPopup('/hanjin/EES_MNR_0188.do?mnr_trf_knd_cd=STD', 1000, 540, 'setEES_MNR_0188', '0,1,1,1,1,1,1,1,1,1,1,1', true);
					break;

                //Eff.from Calendar
				case "eff_dt_cal":
					var status = document.combo1.Code;
					if(status!="HA") {
						var cal = new ComCalendar();
						cal.select(formObject.eff_dt, 'yyyy-MM-dd');
					}
					break;

				/** Dry All (S) **/
				case "btn_t1Delete":
					doActionIBSheet(sheetObject1,formObject,IBDELETE);
					break;

				case "btn_t1RowAdd":
					doActionIBSheet(sheetObject1,formObject,IBINSERT);
					break;

				case "btn_t1RowCopy":
					doActionIBSheet(sheetObject1,formObject,IBCOPYROW);
					break;

				case "btn_t1LoadExcel":
					doActionIBSheet(sheetObject1,formObject,IBLOADEXCEL);
					break;

				case "btn_t1DownExcel":
					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
					break;
				/** Dry All (E) **/

				/** Reefer Box (S) **/
				case "btn_t2Delete":
					doActionIBSheet(sheetObject2,formObject,IBDELETE);
					break;

				case "btn_t2RowAdd":
					doActionIBSheet(sheetObject2,formObject,IBINSERT);
					break;

				case "btn_t2RowCopy":
					doActionIBSheet(sheetObject2,formObject,IBCOPYROW);
					break;

				case "btn_t2LoadExcel":
					doActionIBSheet(sheetObject2,formObject,IBLOADEXCEL);
					break;

				case "btn_t2DownExcel":
					doActionIBSheet(sheetObject2,formObject,IBDOWNEXCEL);
					break;
				/** Reefer Box (E) **/

				/** Reefer Unit (S) **/
				case "btn_t3Delete":
					doActionIBSheet(sheetObject3,formObject,IBDELETE);
					break;

				case "btn_t3RowAdd":
					doActionIBSheet(sheetObject3,formObject,IBINSERT);
					break;

				case "btn_t3RowCopy":
					doActionIBSheet(sheetObject3,formObject,IBCOPYROW);
					break;

				case "btn_t3LoadExcel":
					doActionIBSheet(sheetObject3,formObject,IBLOADEXCEL);
					break;

				case "btn_t3DownExcel":
					doActionIBSheet(sheetObject3,formObject,IBDOWNEXCEL);
					break;
				/** Reefer Unit (E) **/

				/** Special Dry (S) **/
				case "btn_t4Delete":
					doActionIBSheet(sheetObject4,formObject,IBDELETE);
					break;

				case "btn_t4RowAdd":
					doActionIBSheet(sheetObject4,formObject,IBINSERT);
					break;

				case "btn_t4RowCopy":
					doActionIBSheet(sheetObject4,formObject,IBCOPYROW);
					break;

				case "btn_t4LoadExcel":
					doActionIBSheet(sheetObject4,formObject,IBLOADEXCEL);
					break;

				case "btn_t4DownExcel":
					doActionIBSheet(sheetObject4,formObject,IBDOWNEXCEL);
					break;
				/** Special Dry (E) **/

				/** Chassis (S) **/
				case "btn_t5Delete":
					doActionIBSheet(sheetObject5,formObject,IBDELETE);
					break;

				case "btn_t5RowAdd":
					doActionIBSheet(sheetObject5,formObject,IBINSERT);
					break;

				case "btn_t5RowCopy":
					doActionIBSheet(sheetObject5,formObject,IBCOPYROW);
					break;

				case "btn_t5LoadExcel":
					doActionIBSheet(sheetObject1,formObject,IBLOADEXCEL);
					break;

				case "btn_t5DownExcel":
					doActionIBSheet(sheetObject5,formObject,IBDOWNEXCEL);
					break;
				/** Chassis (E) **/

				/** MG Set (S) **/
				case "btn_t6Delete":
					doActionIBSheet(sheetObject6,formObject,IBDELETE);
					break;

				case "btn_t6RowAdd":
					doActionIBSheet(sheetObject6,formObject,IBINSERT);
					break;

				case "btn_t6RowCopy":
					doActionIBSheet(sheetObject6,formObject,IBCOPYROW);
					break;

				case "btn_t6LoadExcel":
					doActionIBSheet(sheetObject6,formObject,IBLOADEXCEL);
					break;

				case "btn_t6DownExcel":
					doActionIBSheet(sheetObject6,formObject,IBDOWNEXCEL);
					break;
				/** MG Set (E) **/

			}
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

		//hidden sheet 로 인해 i=1 시작함
        for(i=1;i<sheetObjects.length;i++){
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
			
            initSheet(sheetObjects[i]);
        	
			//khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

		//Axon이벤트 초기화
		initControl();
		
		initflag = true;
		
		//tab명 조회 설정
		setTabName();

		//화면 초기화 이벤트
		doActionIBSheet(sheetObjects[1],document.form,IBCLEAR,0);
		
		initflag = false;
		
		//set Focus
		document.form.search_trf_no.focus();
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
	    	case 3: 
	            with (comboObj) { 
			       SetColAlign("left");         
				   DropHeight = 160;  
		        }
	            break;
	    	case 2: 
	            with (comboObj) { 
			        SetColAlign("left|left");        
			        SetColWidth("25|75")   
		        }
	            break;
	     } 
	}

    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , disPlayArray) {
        with (tabObj) {
			RemoveAll();  
			var cnt  = 0 ;   
			for(var j = 0; j < disPlayArray.length;j++){
				InsertTab( cnt++ , disPlayArray[j] , -1 );           	
		   	}
		} 
    }
	
  	/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     * @param	{IBSheet}	sheetObj	초기설정될 시트오브젝트 
     * @param	{String}	sheetNo		시트오브젝트 태그의 아이디에 붙인 일련번호
     */
    function initSheet(sheetObj) {
        var cnt = 0;
		var sheetid = sheetObj.id;
		switch(sheetid) {
            case "t1sheet1":
			case "t2sheet1":
			case "t3sheet1":
			case "t4sheet1":
			case "t5sheet1":
			case "t6sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 362;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 6, 100);

					var HeadTitle1 = "|Sel|Seq.|Mandatory|Mandatory|Option|Description|Range Type|Volume|Volume|Volume|Limitation|Limitation|Man-Hour||Component Group|Remark(s)";
                	var HeadTitle2 = "|Sel|Seq.|Component|Repair|Division|Description|Range Type|Type|Q'ty|Size/Square|Min|Max|Man-Hour||Component Group|Remark(s)";
              
                    var headCount = ComCountHeadTitle(HeadTitle1);
					
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount+ 13, 6, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                   
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		        	InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,	45,		daCenter,	true,	"del_chk");
					InitDataProperty(0, cnt++ , dtDataSeq,	 	30,		daCenter,	true,	"Seq");
					InitDataProperty(0, cnt++ , dtComboEdit,	85,		daCenter,	true,	"eq_cmpo_cd",			true,	"",	dfNone,			0,	true,	true,	3,	true);	//Component
	                InitDataProperty(0, cnt++ , dtComboEdit,	70,		daCenter,	true,	"eq_rpr_cd",			true,	"",	dfNone,			0,	true,	true,	2,	true);	//Repair
	                InitDataProperty(0, cnt++ , dtCombo,  		50,		daCenter,	true,	"trf_div_cd",			false,	"",	dfNone,			0,	true,	true);				//Division
	                InitDataProperty(0, cnt++ , dtData,  		230,	daLeft,		true,	"dtl_desc",				true,	"",	dfNone,			0,	true,	true,	500);		//Description
	                InitDataProperty(0, cnt++ , dtCombo,  		90,		daLeft,		true,	"mnr_rng_tp_cd_view",	true,	"",	dfNone, 		0,	true,	true);				//Range Type View
	                InitDataProperty(0, cnt++ , dtCombo,  		60,		daLeft,		true,	"vol_tp_cd_view",		true,	"",	dfNone, 		0,	true,	true);				//Type View
	                InitDataProperty(0, cnt++ , dtData,  		40,		daRight,	true,	"rpr_qty",				false,	"",	dfNullInteger, 	0,	true,	true,	6,	false);	//Q'ty
	                InitDataProperty(0, cnt++ , dtData,  		85, 	daRight,	true,	"rpr_sz_no",			false,	"",	dfNullInteger, 	0,	true,	true,	10,	false);	//Size/Square
	                InitDataProperty(0, cnt++ , dtData,  		50,		daRight,	true,	"fm_rng_sz_no",			false,	"",	dfNullInteger,	0,	true,	true,	8,	false);	//Min
	                InitDataProperty(0, cnt++ , dtData,  		60,		daRight,	true,	"to_rng_sz_no",			false,	"",	dfNullInteger,	0,	true,	true,	8,	false);	//Max
	                InitDataProperty(0, cnt++ , dtData,  		80,		daRight,	true,	"rpr_lbr_hrs",			true,	"",	dfNullFloat, 	2,	true,	true,	6,	false);	//Man-Hour
	                InitDataProperty(0, cnt++ , dtHidden,  		103,	daRight,	true,	"mtrl_reco_amt",		false,	"",	dfFloat, 		2,	true,	true,	18,	false);	//recommend Material
	                InitDataProperty(0, cnt++ , dtData,  		110,	daLeft,		true,	"eq_cmpo_up_cd",		false,	"",	dfNone,			0,	false,	false);				//Component Group
	                InitDataProperty(0, cnt++ , dtData,  		83,		daLeft,		true,	"dtl_rmk",				false,	"",	dfNone,			0,	true,	true,	4000);		//Remark(s)
	                //Hidden데이터
	                InitDataProperty(0, cnt++ , dtHidden,  		50,		daLeft,		true,	"trf_no");
	                InitDataProperty(0, cnt++ , dtHidden,  		0,		daRight,	true,	"trf_dtl_seq");
	                InitDataProperty(0, cnt++ , dtHidden,  		50,		daRight,	true,	"cost_grp_cd");
	                InitDataProperty(0, cnt++ , dtHidden,  		30,		daRight,	true,	"inch_size");
	                InitDataProperty(0, cnt++ , dtHidden,  		30,		daRight,	true,	"cm_size");
	                InitDataProperty(0, cnt++ , dtHidden,  		30,		daRight,	true,	"inch_fm");
	                InitDataProperty(0, cnt++ , dtHidden,  		30,		daRight,	true,	"cm_fm");
	                InitDataProperty(0, cnt++ , dtHidden,  		30,		daRight,	true,	"inch_to");
	                InitDataProperty(0, cnt++ , dtHidden,  		30,		daRight,	true,	"cm_to");
	                InitDataProperty(0, cnt++ , dtHidden,  		90,		daLeft,		true,	"mnr_rng_tp_cd");	//Range Type
	                InitDataProperty(0, cnt++ , dtHidden,  		60,		daLeft,		true,	"vol_tp_cd");		//Type
	                InitDataProperty(0, cnt++ , dtHidden,  		0,		daRight,	true,	"div_flag");
	                InitDataProperty(0, cnt++ , dtHidden,  		0,		daRight,	true,	"rpr_flag");
					//데이터 Validation
					InitDataValid(0,  "eq_cmpo_cd", vtEngUpOther,"0123456789");  
					InitDataValid(0,  "eq_rpr_cd", vtEngUpOther,"0123456789");  

					//SELECT 로우 배경색       
					SelectionMode = smSelectionRow;    
					SelectHighLight = true;            
					SelectFontBold = false;          
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);   

					ShowButtonImage = 2;
					CountPosition = 0;

					//Grid Combo의 값에  맞지 않는 값이 들어올경우 Text로 보여줌.    
					InitComboNoMatchText(true);          
                }
                break;
			
			default:
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
    }

	/** 
	 * IBCombo Object를 배열로 등록
	 * @param    {IBCombo}	combo_obj	배열로 등록될 IBCombo Object
	 */	
    function setComboObject(combo_obj){
 		comboObjects[comboCnt++] = combo_obj; 
 	}

    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;
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
	          	ComKeyOnlyAlphabet('uppernum','45');//"-"          
	            break;
			
			case "ymd":
				ComKeyOnlyNumber(event.srcElement);
				break;
	    } 
	}

	/** 
	 * COMBO 변경 이벤트
	 * EQ Type 변경시 탭 재설정
	 * @param	{IBMultiCombo}	comboObj	변경한 콤보 오브젝트
	 * @param	{Number}		Index_Code	변경한 콤보의 코드
	 * @param	{String}		Text		변경한 콤보의 명
	 */
	function combo2_OnChange(comboObj,Index_Code, Text){
		//시트에 값이 존재하는지 여부
		var cnt = 0;
		for (var i=1; i<sheetObjects.length; i++){
			cnt += sheetObjects[i].RowCount;
		}
		if(cnt>0) {
			//변경의사 확인
			if(!ComShowCodeConfirm("MNR00192")) {
				comboObj.Code2 = comboValue;
				return;
			}
			//모든 쉬트를 초기화 	 
		    for(i=1;i<sheetObjects.length;i++){
		    	sheetObjects[i].RemoveAll();
            }
			//시트콤보 재조회 설정
			setSheetCombo(sheetObjects[1]);
		}
		
		//EQ Type
		comboValue = comboObj.Code;
		
		//Tab재설정,sheetCombo재조회
		if(comboValue=="U") {
			initTab(tabObjects[0],uTab);  
			setSheetCombo(sheetObjects[1]);
		} 
		else if(comboValue=="Z") {
			initTab(tabObjects[0],zTab);  
			setSheetCombo(sheetObjects[1]);
			
		} else if(comboValue=="G") {
			initTab(tabObjects[0],gTab);  
			setSheetCombo(sheetObjects[1]);
		}
		//EQ TYPE 별로 디폴트값을 조회해온후 세팅       
		var defUnitOfMeasure = MnrDefaultUnitOfMeasure(sheetObjects[0],comboObj.Code);
		document.form.combo4.Code	 = defUnitOfMeasure;	//UnitOfMass 
	}   

	/** 
	 * COMBO 변경 이벤트
	 *     Unit Of Measure 를 inch/cm 로 변경하면 Size/Square 값 재설정
	 *     
	 * @param	{IBMultiCombo}	comboObj	변경한 콤보 오브젝트
	 * @param	{Number}		Index_Code	변경한 콤보의 코드
	 * @param	{String}		Text		변경한 콤보의 명
	 */
	function combo4_OnChange(comboObj,Index_Code, Text){
		if(initflag == false){
			ComOpenWait(true,true);
			var mnrMeasUtCd = Index_Code;
			if(mnrMeasUtCd == "INC") {
				for (var i=1; i<sheetObjects.length; i++){
					for(var j=sheetObjects[i].HeaderRows; j<=sheetObjects[i].LastRow; j++) {
						var volTpCd	= sheetObjects[i].CellValue(j, "vol_tp_cd");
						if(volTpCd != "Q") {
							var inchSize	= sheetObjects[i].CellValue(j, "inch_size");
							var inchFm 		= sheetObjects[i].CellValue(j, "inch_fm");
							var inchTo 		= sheetObjects[i].CellValue(j, "inch_to");
							sheetObjects[i].CellValue(j, "rpr_sz_no") 		= inchSize;
							sheetObjects[i].CellValue(j, "fm_rng_sz_no")	= inchFm;
							sheetObjects[i].CellValue(j, "to_rng_sz_no")	= inchTo;
						}
					}
				}
			} else if(mnrMeasUtCd == "CMT"){
				for (var i=1; i<sheetObjects.length; i++){
					for(var j=sheetObjects[i].HeaderRows; j<=sheetObjects[i].LastRow; j++) {
						var volTpCd	= sheetObjects[i].CellValue(j, "vol_tp_cd");
						if(volTpCd != "Q") {
							var cmSize	= sheetObjects[i].CellValue(j, "cm_size");
							var cmFm 	= sheetObjects[i].CellValue(j, "cm_fm");
							var cmTo 	= sheetObjects[i].CellValue(j, "cm_to");
							sheetObjects[i].CellValue(j, "rpr_sz_no") 		= cmSize;
							sheetObjects[i].CellValue(j, "fm_rng_sz_no")	= cmFm;
							sheetObjects[i].CellValue(j, "to_rng_sz_no")	= cmTo;
						}
					}
				}
			} else {
				ComShowCodeMessage("MNR00010", "Unit Of Measure");
			}
			ComOpenWait(false,true);
		}
	}
	
    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem){
        var objs = document.all.item("tabLayer");

    	objs[nItem].style.display = "Inline";
    	objs[beforetab].style.display = "none";

    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1 ;
    	//------------------------------------------------------//
    	beforetab= nItem;
    }

	/** 
	 * 조회후 설정
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		if(!checkIsDetailRow()) {return;}
		
		doAfterSearch();
	}

	/** 
	 * 조회후 설정
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		if(!checkIsDetailRow()) {return;}

		doAfterSearch();
	}
	
	/** 
	 * 조회후 설정
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function t3sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		if(!checkIsDetailRow()) {return;}

		doAfterSearch();
	}
	
	/** 
	 * 조회후 설정
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function t4sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		if(!checkIsDetailRow()) {return;}

		doAfterSearch();
	}

	/** 
	 * 조회후 설정
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function t5sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		if(!checkIsDetailRow()) {return;}

		doAfterSearch();
	}

	/** 
	 * 조회후 설정
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function t6sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		if(!checkIsDetailRow()) {return;}

		doAfterSearch();
	}

	/** 
	 * 저장후 결과메세지 표시
	 * @param	{IBSheet}	sheetObj	저장이벤트의 시트 오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function t1sheet1_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") { 
			//0:save, 1:confirm, 2:Delete
			if(saveType==0) {
				ComShowCodeMessage("MNR00023");
			} else if (saveType==1) {
				ComShowCodeMessage("MNR00313");
			} else if (saveType==2) {
				ComShowCodeMessage("MNR00020");
			}
			doAfterSave();
		} 
		else { 
		    //Server Message와 중복으로 인한 주석처리
			//ComShowCodeMessage("MNR00008",ErrMsg);  
		} 
	}     

	/** 
	 * 셀의 값 변경시 발생하는 Event
	 * Volume Type 콤보값에 따라 Q'ty와 Size/Square의 값을 재설정한다.
	 * Volume Type:Q -> Size/Square=0, Volume Type:S -> Q'ty=0 
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function t1sheet1_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {		
			if(!dummyEvent){
				var colname = ColSaveName(Col);
				//Volume Type Code
				if(colname=='vol_tp_cd'){
					setEditableByVolumeType(sheetObj,Row);  		//Editalbe설정
				}
				//Component Code
				else if(colname=='eq_cmpo_cd'){
					checkIsComboValue(sheetObj,Row,Col,Value,0);		//존재유무 체크
					setRprCombo(sheetObj,Row);							//Repair GridCombo Set
					setDivCombo(sheetObj,Row);							//Div GridCombo Set	
					setDescripton(sheetObj,Row);						//Description명 부여								
				}
				//Repair Code
				else if(colname=='eq_rpr_cd'){
					checkIsComboValue(sheetObj,Row,Col,Value,1);  	//존재유무 체크
					setDivCombo(sheetObj,Row);						//Div GridCombo Set
					setDescripton(sheetObj,Row);					//Description명 부여
				}
				//Div Code
				else if(colname=='trf_div_cd'){
					setDescripton(sheetObj,Row);					//Description명 부여
				}
				//Range Type
				else if(colname=='mnr_rng_tp_cd_view'){
					checkRangeType(sheetObj,Row,Value);				//동일스팩에 First Volume 존재유무 체크
				}
				//Voulume Type
				else if(colname=='vol_tp_cd_view') {
					setVolumeTypeHidden(sheetObj,Row,Value);	//Hidden 컬럼에도  값을  입력한다.
				}
			}	
		}
	}
		
	/** 
	 * 셀의 값 변경시 발생하는 Event
	 * Volume Type 콤보값에 따라 Q'ty와 Size/Square의 값을 재설정한다.
	 * Volume Type:Q -> Size/Square=0, Volume Type:S -> Q'ty=0 
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function t2sheet1_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			if(!dummyEvent){
				var colname = ColSaveName(Col);
				//Volume Type Code
				if(colname=='vol_tp_cd'){
					setEditableByVolumeType(sheetObj,Row);  		//Editalbe설정
				}
				//Component Code
				else if(colname=='eq_cmpo_cd'){
					checkIsComboValue(sheetObj,Row,Col,Value,0);  		//존재유무 체크
					setRprCombo(sheetObj,Row);							//Repair GridCombo Set
					setDivCombo(sheetObj,Row);							//Div GridCombo Set
					setDescripton(sheetObj,Row);						//Description명 부여
				}
				//Repair Code
				else if(colname=='eq_rpr_cd'){
					checkIsComboValue(sheetObj,Row,Col,Value,1); 	//존재유무 체크
					setDivCombo(sheetObj,Row);						//Div GridCombo Set
					setDescripton(sheetObj,Row);					//Description명 부여
				}
				//Div Code
				else if(colname=='trf_div_cd'){
					setDescripton(sheetObj,Row);					//Description명 부여
				}
				//Range Type
				else if(colname=='mnr_rng_tp_cd_view'){
					checkRangeType(sheetObj,Row,Value);				//동일스팩에 First Volume 존재유무 체크
				}
				//Voulume Type
				else if(colname=='vol_tp_cd_view') {
					setVolumeTypeHidden(sheetObj,Row,Value);		//Hidden 컬럼에도  값을  입력한다.
				}
			}	
		}
	}
		
	/** 
	 * 셀의 값 변경시 발생하는 Event
	 * Volume Type 콤보값에 따라 Q'ty와 Size/Square의 값을 재설정한다.
	 * Volume Type:Q -> Size/Square=0, Volume Type:S -> Q'ty=0 
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function t3sheet1_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			if(!dummyEvent){
				var colname = ColSaveName(Col);
				//Volume Type Code
				if(colname=='vol_tp_cd'){
					setEditableByVolumeType(sheetObj,Row);  		//Editalbe설정
				}
				//Component Code
				else if(colname=='eq_cmpo_cd'){
					checkIsComboValue(sheetObj,Row,Col,Value,0);  		//존재유무 체크
					setRprCombo(sheetObj,Row);							//Repair GridCombo Set
					setDivCombo(sheetObj,Row);							//Div GridCombo Set
					setDescripton(sheetObj,Row);						//Description명 부여
				}
				//Repair Code
				else if(colname=='eq_rpr_cd'){			
					checkIsComboValue(sheetObj,Row,Col,Value,1);  	//존재유무 체크
					setDivCombo(sheetObj,Row);						//Div GridCombo Set
					setDescripton(sheetObj,Row);						//Description명 부여
				}
				//Div Code
				else if(colname=='trf_div_cd'){
					setDescripton(sheetObj,Row);					//Description명 부여
				}
				//Range Type
				else if(colname=='mnr_rng_tp_cd_view'){
					checkRangeType(sheetObj,Row,Value);				//동일스팩에 First Volume 존재유무 체크
				}
				//Voulume Type
				else if(colname=='vol_tp_cd_view') {
					setVolumeTypeHidden(sheetObj,Row,Value);		//Hidden 컬럼에도  값을  입력한다.
				}
			}	
		}
	}
		
	/** 
	 * 셀의 값 변경시 발생하는 Event
	 * Volume Type 콤보값에 따라 Q'ty와 Size/Square의 값을 재설정한다.
	 * Volume Type:Q -> Size/Square=0, Volume Type:S -> Q'ty=0 
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function t4sheet1_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			if(!dummyEvent){
				var colname = ColSaveName(Col);
				//Volume Type Code
				if(colname=='vol_tp_cd'){
					setEditableByVolumeType(sheetObj,Row);  		//Editalbe설정
				}
				//Component Code
				else if(colname=='eq_cmpo_cd'){
					checkIsComboValue(sheetObj,Row,Col,Value,0);  		//존재유무 체크
					setRprCombo(sheetObj,Row);							//Repair GridCombo Set
					setDivCombo(sheetObj,Row);							//Div GridCombo Set
					setDescripton(sheetObj,Row);						//Description명 부여
					//sheetObj.CellValue(Row, "eq_cmpo_up_cd") = Value;	//2nd Component Code Name set 
				}
				//Repair Code
				else if(colname=='eq_rpr_cd'){
					checkIsComboValue(sheetObj,Row,Col,Value,1);	//존재유무 체크
					setDivCombo(sheetObj,Row);						//Div GridCombo Set
					setDescripton(sheetObj,Row);					//Description명 부여
				}
				//Div Code
				else if(colname=='trf_div_cd'){
					setDescripton(sheetObj,Row);					//Description명 부여
				}
				//Range Type
				else if(colname=='mnr_rng_tp_cd_view'){
					checkRangeType(sheetObj,Row,Value);				//동일스팩에 First Volume 존재유무 체크
				}
				//Voulume Type
				else if(colname=='vol_tp_cd_view') {
					setVolumeTypeHidden(sheetObj,Row,Value);		//Hidden 컬럼에도  값을  입력한다.
				}
			}	
		}
	}
		
	/** 
	 * 셀의 값 변경시 발생하는 Event
	 * Volume Type 콤보값에 따라 Q'ty와 Size/Square의 값을 재설정한다.
	 * Volume Type:Q -> Size/Square=0, Volume Type:S -> Q'ty=0 
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function t5sheet1_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			if(!dummyEvent){
				var colname = ColSaveName(Col);
				//Volume Type Code
				if(colname=='vol_tp_cd'){
					setEditableByVolumeType(sheetObj,Row);  		//Editalbe설정
				}
				//Component Code
				else if(colname=='eq_cmpo_cd'){
					checkIsComboValue(sheetObj,Row,Col,Value,0);  		//존재유무 체크
					setRprCombo(sheetObj,Row);							//Repair GridCombo Set
					setDivCombo(sheetObj,Row);							//Div GridCombo Set
					setDescripton(sheetObj,Row);						//Description명 부여
					
				}
				//Repair Code
				else if(colname=='eq_rpr_cd'){
					checkIsComboValue(sheetObj,Row,Col,Value,1);  	//존재유무 체크
					setDivCombo(sheetObj,Row);						//Div GridCombo Set
					setDescripton(sheetObj,Row);						//Description명 부여
				}			
				//Div Code
				else if(colname=='trf_div_cd'){
					setDescripton(sheetObj,Row);					//Description명 부여
				}
				//Range Type
				else if(colname=='mnr_rng_tp_cd_view'){
					checkRangeType(sheetObj,Row,Value);				//동일스팩에 First Volume 존재유무 체크
				}
				//Voulume Type
				else if(colname=='vol_tp_cd_view') {
					setVolumeTypeHidden(sheetObj,Row,Value);		//Hidden 컬럼에도  값을  입력한다.
				}
			}	
		}
	}
		
	/** 
	 * 셀의 값 변경시 발생하는 Event
	 * Volume Type 콤보값에 따라 Q'ty와 Size/Square의 값을 재설정한다.
	 * Volume Type:Q -> Size/Square=0, Volume Type:S -> Q'ty=0 
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */	
	function t6sheet1_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			if(!dummyEvent){
				var colname = ColSaveName(Col);
				//Volume Type Code
				if(colname=='vol_tp_cd'){
					setEditableByVolumeType(sheetObj,Row);  		//Editalbe설정
				}
				//Component Code
				else if(colname=='eq_cmpo_cd'){
					checkIsComboValue(sheetObj,Row,Col,Value,0);  		//존재유무 체크
					setRprCombo(sheetObj,Row);							//Repair GridCombo Set
					setDivCombo(sheetObj,Row);							//Div GridCombo Set
					setDescripton(sheetObj,Row);						//Description명 부여
				}
				//Repair Code
				else if(colname=='eq_rpr_cd'){
					checkIsComboValue(sheetObj,Row,Col,Value,1);  	//존재유무 체크
					setDivCombo(sheetObj,Row);						//Div GridCombo Set
					setDescripton(sheetObj,Row);						//Description명 부여
				}		
				//Div Code
				else if(colname=='trf_div_cd'){
					setDescripton(sheetObj,Row);					//Description명 부여
				}
				//Range Type
				else if(colname=='mnr_rng_tp_cd_view'){
					checkRangeType(sheetObj,Row,Value);				//동일스팩에 First Volume 존재유무 체크
				}
				//Voulume Type
				else if(colname=='vol_tp_cd_view') {
					setVolumeTypeHidden(sheetObj,Row,Value);		//Hidden 컬럼에도  값을  입력한다.
				}		
			}				
		}
	}

	/** 
	 * 마우스 클릭시  발생하는 Event
	 *    Div콤보 클릭시 1회에 한하여 Div조회한다. 
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}		Button		Lett:1, Right:2
	 * @param	{Int}		Shift		Shift:1, Ctrl:2, Etc..:0
	 * @param	{Long}		X			Value
	 * @param	{Long}		Y			Value
	 */
    function t1sheet1_OnMouseDown(sheetObj,Button, Shift, X, Y){
		var Row = sheetObj.MouseRow;
		var Col = sheetObj.MouseCol;
		var ColSaveName = sheetObj.ColSaveName(Col);
		
		if(ColSaveName=="eq_rpr_cd") { //RPR Code
			var rprFlag = sheetObj.CellValue(Row, "rpr_flag");
			if(rprFlag=="1") {return} 
			setRprCombo(sheetObj,Row);	
														
			var divFlag = sheetObj.CellValue(Row, "div_flag");
			if(divFlag=="1") {return} 
			setDivCombo(sheetObj,Row); 
		} else if(ColSaveName=="trf_div_cd") { //Div Code
		    var divFlag = sheetObj.CellValue(Row, "div_flag");
			if(divFlag=="1") {return}	
			setDivCombo(sheetObj,Row); 
		}
	}
	
    /** 
     * 마우스 클릭시  발생하는 Event
     *    Div콤보 클릭시 1회에 한하여 Div조회한다. 
     * @param	{IBSheet}	sheetObj	시트오브젝트
     * @param	{Int}		Button		Lett:1, Right:2
     * @param	{Int}		Shift		Shift:1, Ctrl:2, Etc..:0
     * @param	{Long}		X			Value
     * @param	{Long}		Y			Value
     */
    function t2sheet1_OnMouseDown(sheetObj,Button, Shift, X, Y){
    	var Row = sheetObj.MouseRow;
    	var Col = sheetObj.MouseCol;
    	var ColSaveName = sheetObj.ColSaveName(Col);
    	if(ColSaveName=="eq_rpr_cd") { //RPR Code
			var rprFlag = sheetObj.CellValue(Row, "rpr_flag");
			if(rprFlag=="1") {return} 
			setRprCombo(sheetObj,Row);	
														
			var divFlag = sheetObj.CellValue(Row, "div_flag");
			if(divFlag=="1") {return} 
			setDivCombo(sheetObj,Row); 
		} else if(ColSaveName=="trf_div_cd") { //Div Code
		    var divFlag = sheetObj.CellValue(Row, "div_flag");
			if(divFlag=="1") {return}	
			setDivCombo(sheetObj,Row); 
		}
    }
    
    /** 
     * 마우스 클릭시  발생하는 Event
     *    Div콤보 클릭시 1회에 한하여 Div조회한다. 
     * @param	{IBSheet}	sheetObj	시트오브젝트
     * @param	{Int}		Button		Lett:1, Right:2
     * @param	{Int}		Shift		Shift:1, Ctrl:2, Etc..:0
     * @param	{Long}		X			Value
     * @param	{Long}		Y			Value
     */
    function t3sheet1_OnMouseDown(sheetObj,Button, Shift, X, Y){
    	var Row = sheetObj.MouseRow;
    	var Col = sheetObj.MouseCol;
    	var ColSaveName = sheetObj.ColSaveName(Col);
    	if(ColSaveName=="eq_rpr_cd") { //RPR Code
			var rprFlag = sheetObj.CellValue(Row, "rpr_flag");
			if(rprFlag=="1") {return} 
			setRprCombo(sheetObj,Row);	
														
			var divFlag = sheetObj.CellValue(Row, "div_flag");
			if(divFlag=="1") {return} 
			setDivCombo(sheetObj,Row); 
		} else if(ColSaveName=="trf_div_cd") { //Div Code
		    var divFlag = sheetObj.CellValue(Row, "div_flag");
			if(divFlag=="1") {return}	
			setDivCombo(sheetObj,Row); 
		}
    }
    
    /** 
     * 마우스 클릭시  발생하는 Event
     *    Div콤보 클릭시 1회에 한하여 Div조회한다. 
     * @param	{IBSheet}	sheetObj	시트오브젝트
     * @param	{Int}		Button		Lett:1, Right:2
     * @param	{Int}		Shift		Shift:1, Ctrl:2, Etc..:0
     * @param	{Long}		X			Value
     * @param	{Long}		Y			Value
     */
    function t4sheet1_OnMouseDown(sheetObj,Button, Shift, X, Y){
    	var Row = sheetObj.MouseRow;
    	var Col = sheetObj.MouseCol;
    	var ColSaveName = sheetObj.ColSaveName(Col);
    	if(ColSaveName=="eq_rpr_cd") { //RPR Code
			var rprFlag = sheetObj.CellValue(Row, "rpr_flag");
			if(rprFlag=="1") {return} 
			setRprCombo(sheetObj,Row);	
														
			var divFlag = sheetObj.CellValue(Row, "div_flag");
			if(divFlag=="1") {return} 
			setDivCombo(sheetObj,Row); 
		} else if(ColSaveName=="trf_div_cd") { //Div Code
		    var divFlag = sheetObj.CellValue(Row, "div_flag");
			if(divFlag=="1") {return}	
			setDivCombo(sheetObj,Row); 
		}
    }
    
    /** 
     * 마우스 클릭시  발생하는 Event
     *    Div콤보 클릭시 1회에 한하여 Div조회한다. 
     * @param	{IBSheet}	sheetObj	시트오브젝트
     * @param	{Int}		Button		Lett:1, Right:2
     * @param	{Int}		Shift		Shift:1, Ctrl:2, Etc..:0
     * @param	{Long}		X			Value
     * @param	{Long}		Y			Value
     */
    function t5sheet1_OnMouseDown(sheetObj,Button, Shift, X, Y){
    	var Row = sheetObj.MouseRow;
    	var Col = sheetObj.MouseCol;
    	var ColSaveName = sheetObj.ColSaveName(Col);
    	if(ColSaveName=="eq_rpr_cd") { //RPR Code
			var rprFlag = sheetObj.CellValue(Row, "rpr_flag");
			if(rprFlag=="1") {return} 
			setRprCombo(sheetObj,Row);	
														
			var divFlag = sheetObj.CellValue(Row, "div_flag");
			if(divFlag=="1") {return} 
			setDivCombo(sheetObj,Row); 
		} else if(ColSaveName=="trf_div_cd") { //Div Code
		    var divFlag = sheetObj.CellValue(Row, "div_flag");
			if(divFlag=="1") {return}	
			setDivCombo(sheetObj,Row); 
		}
    }
    
    /** 
     * 마우스 클릭시  발생하는 Event
     *    Div콤보 클릭시 1회에 한하여 Div조회한다. 
     * @param	{IBSheet}	sheetObj	시트오브젝트
     * @param	{Int}		Button		Lett:1, Right:2
     * @param	{Int}		Shift		Shift:1, Ctrl:2, Etc..:0
     * @param	{Long}		X			Value
     * @param	{Long}		Y			Value
     */
    function t6sheet1_OnMouseDown(sheetObj,Button, Shift, X, Y){
    	var Row = sheetObj.MouseRow;
    	var Col = sheetObj.MouseCol;
    	var ColSaveName = sheetObj.ColSaveName(Col);
    	if(ColSaveName=="eq_rpr_cd") { //RPR Code
			var rprFlag = sheetObj.CellValue(Row, "rpr_flag");
			if(rprFlag=="1") {return} 
			setRprCombo(sheetObj,Row);	
														
			var divFlag = sheetObj.CellValue(Row, "div_flag");
			if(divFlag=="1") {return} 
			setDivCombo(sheetObj,Row); 
		} else if(ColSaveName=="trf_div_cd") { //Div Code
		    var divFlag = sheetObj.CellValue(Row, "div_flag");
			if(divFlag=="1") {return}		
			setDivCombo(sheetObj,Row); 
		}			
    }
    
  	/**
     * Sheet1관련 프로세스 처리
     * @param	{IBSheet}	sheetObj	프로세스 처리될 시트오브젝트 
     * @param	{Form}		formObj		프로세스 처리될 폼오브젝트
     * @param	{Number}	sAction		분기처리될 액션의 상수값(CoObject.js에 정의) 
     */
    function doActionIBSheet(sheetObj,formObj,sAction,sActionIdx) {
	   	sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			//초기화
			case IBCLEAR:
				//버튼 ,프로그레스바 설정
				sheetObj.WaitImageVisible = false;
				MnrWaitControl(true);

	    		// 모든 쉬트를 초기화
	    		for (i = 0; i < sheetObjects.length; i++) {
	    			sheetObjects[i].RemoveAll();
	    		}
				
				//최초 로딩시에만 값조회
				if(sActionIdx==0) {	
		        	//조건부 콤보데이타 초기화
					for(var i = 0; i < comboObjects.length;i++){ 
						comboObjects[i].RemoveAll();	
					}
					//조건부 콤보데이타 조회(UnitOfMass, Currency)
					var sCondition = new Array (
						new Array("MnrGenCd","CD00007", "COMMON"), 	//Status	
						new Array("MnrGenCd","SELHO","CUSTOM9") ,  	//EQ Type
						new Array("MdmCurrency","", "COMMON"),		//Currency			
						new Array("MnrGenCd","CD00010", "COMMON"), 	//UnitOfMass
						new Array("MnrEqCmpoCd","3","COMMON"), 		//Component
						new Array("MnrCedexOthCd","RPR","COMMON"), 	//Repair
						new Array("MnrGenCd","CD00012", "COMMON"),	//RangeType
						new Array("MnrGenCd","CD00013", "COMMON")	//Type
					)             
					var comboList = MnrComSearchCombo(sheetObj,sCondition);
					var sheetComboText 		= "";  
					var sheetComboCode 		= "";
					var sheetComboDefault	= "";
					//쉬트 콤보 SAVE_NAME
					var comboSaveNames = new Array();
					comboSaveNames[0] = "eq_cmpo_cd";
					comboSaveNames[1] = "eq_rpr_cd";
					comboSaveNames[2] = "mnr_rng_tp_cd_view";  
					comboSaveNames[3] = "vol_tp_cd_view";  

					//조건부 콤보데이타에 값을 세팅함        
					for(var i = 0; i < comboList.length;i++){
						//comboObjects[i].RemoveAll();   
						if(comboList[i] != null){
							//쉬트콤보별 초기화
							sheetComboText 		= "";
							sheetComboCode 		= "";
							sheetComboCodeText	= "";
							sheetComboDefault 	= ""; 

							//Display[CODE_NAME]:Status,UnitOfMass 
							if(i==0||i==1||i==3) {
								for(var j = 0; j < comboList[i].length;j++){ 
									var tempText = comboList[i][j].split("|");    
									//Status 
									if(i==0) {
										formObj.combo1.InsertItem(j, tempText[1] ,tempText[0]);
									//EQ Type
									} else if(i==1) {
										formObj.combo2.InsertItem(j, tempText[1] ,tempText[0]);
									//UnitOfMass
									} else if(i==3) {
										formObj.combo4.InsertItem(j, tempText[1] ,tempText[0]);
									}
								}
							//Display[CODE]:Currency
							} else if(i==2){
								for(var j = 0; j < comboList[i].length;j++){ 
									formObj.combo3.InsertItem(j, comboList[i][j] ,j);
								}
							//쉬트 콤보
							} else if (i==4||i==5||i==6||i==7) {
								for(var j = 0; j < comboList[i].length;j++){
									var tempText = comboList[i][j].split("|");    
									sheetComboText +=  tempText[1] + "|";
									sheetComboCode +=  tempText[0] + "|";
									sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
									if(j ==0){
										sheetComboDefault = tempText[0];      	
									} 
								}
							}
							//탭별 쉬트 콤보 설정
							for(var k=1; k<sheetObjects.length; k++) {
								//[CODE][NAME]:Component,Repair	
								//i==4|| Component 막아놈 eq_type에 따라가도록 요청	
								if(i==5) {
									sheetObjects[k].InitDataCombo (0, comboSaveNames[i - 4], sheetComboCodeText, sheetComboCode ,sheetComboDefault); 
								}
								//[NAME]:RangeType,Type 
								else if(i==6||i==7) {  
									sheetObjects[k].InitDataCombo (0, comboSaveNames[i - 4], sheetComboText, sheetComboCode ,sheetComboDefault); 
								} 
							}							
						}
					}
				}
				//콤보초기값 설정
				formObj.combo1.Code = "";		//Status
				formObj.combo2.Code = "U";		//EQ Type           	
				formObj.combo3.Text = "USD";	//Currency
				formObj.combo4.Code = "INC";	//UnitOfMass   	
				
				//콤보이외의 조회조건값 초기화
				if(sheetObj.id == 't1sheet1') {	//Tariff No Road
					formObj.search_trf_no.value = ""; 
				} else {						//Tariff No New/Copy
					formObj.search_trf_no.value = "NEW"; 
				}
				formObj.trf_no.value 			= "NEW"; 				//Tariff No for Save
				formObj.search_trf_no.readOnly 	= false;				//Tariff No ReadOnly
				formObj.search_trf_no.className	= "input1";				//Tariff No Class
				formObj.rqst_ofc_cd.value		= currOfcCd;			//Tariff Office
				formObj.cre_usr_id.value		= usrId;				//Creation User
				formObj.cre_dt.value 			= ComGetNowInfo("ymd");	//Creation Date
				formObj.eff_dt.value 			= ComGetNowInfo("ymd"); //Eff.from
				formObj.eff_dt.readOnly 		= false; 				//Eff.from
				formObj.eff_dt.className 		= "input1"; 			//Eff.from
				formObj.mnr_trf_sts_cd.value 	= "";					//Tariff Status 
				formObj.mnr_trf_rmk.value       = "";					//Remark(s)
				
				//Currency,EQ Type 콤보 활성화 설정
				formObj.combo1.Enable = false;	//Status
				formObj.combo2.Enable = true;	//EQ Type
				formObj.combo3.Enable = false;	//Currency
				formObj.combo4.Enable = true;	//Unit Of Measure
				
				//Button 활성화 설정
				setButtonEnDisable();
                
				//버튼 ,프로그레스바 설정
				MnrWaitControl(false);
				sheetObj.WaitImageVisible = true;
				
				break;
				
			//조회
            case IBSEARCH:
				formObj.f_cmd.value = SEARCH;      
                if(validateForm(sheetObj,formObj,sAction)) {
					//다중조회
					var sXml = sheetObj.GetSearchXml("EES_MNR_0014GS.do", FormQueryString(formObj));
					var arrXml = sXml.split("|$$|");
					
					//Header
					var arrResult = MnrXmlToArray(arrXml[0]);
					if(arrResult != null){
						formObj.trf_no.value			= arrResult[0][19];	//triff No    
						formObj.eff_dt.value 			= arrResult[0][6];  //계약 시작일
						formObj.rqst_ofc_cd.value		= arrResult[0][4];	//Tariff Office
						formObj.cre_dt.value 			= arrResult[0][9];  //생성 일자
						formObj.cre_usr_id.value 		= arrResult[0][14]; //생성 User ID
						formObj.mnr_trf_sts_cd.value	= arrResult[0][23]; //Tariff Status Code(SS:Save[SPP],SR:Request[SPP],SD:Delete[SPP],HR:Request,HS:Save,HJ:Reject,HD:Delete,HE:Expired,HA:Approval)
						formObj.mnr_trf_rmk.value 		= arrResult[0][18]; //Remark(s)
						
						formObj.combo1.Code = arrResult[0][23];		//Tariff Status Code
						formObj.combo2.Code = arrResult[0][24];  	//EQ Type(U:CONTAINER,Z:CHASSIS,G:GENSET) 
						formObj.combo3.Text = arrResult[0][7];  	//Currency
						formObj.combo4.Code = arrResult[0][10];  	//Unit Of Mass (CMT:CM, INC:inch)
						
						setButtonEnDisable();  //Button Enable 설정
					} else {
						ComShowCodeMessage("MNR00204");
						formObj.search_trf_no.focus();
						return;
					}
					//0 vndr_seq|1 vndr_nm|2 agmt_no|3 rqst_ofc_cd|4 pagerows|5 eff_dt|6 curr_cd|7 ibflag|8 cre_dt|9 mnr_meas_ut_cd|10 upd_usr_id|11 apro_ofc_cd|12 cre_usr_id|13 mnr_trf_sts_dt|14 mnr_trf_knd_cd|15 sts_ref_no|16 mnr_trf_rmk|17 trf_no|18 cre_usr_nm|19 eq_knd_nm|20 mnr_inp_tp_cd|21 mnr_trf_sts_cd|22 eq_knd_cd|23 upd_dt|24 pre_trf_no|
					//vndr_seq|vndr_nm|agmt_no|rqst_ofc_cd|pagerows|eff_dt|curr_cd|ibflag|cre_dt|mnr_meas_ut_cd|upd_usr_id|apro_ofc_cd|cre_usr_id|mnr_trf_sts_dt|mnr_trf_knd_cd|sts_ref_no|mnr_trf_rmk|trf_no|cre_usr_nm|eq_knd_nm|mnr_inp_tp_cd|mnr_trf_sts_cd|eq_knd_cd|upd_dt|pre_trf_no
					//MnrXmlToArrayDebug('vndr_seq|vndr_nm|agmt_no|rqst_ofc_cd|pagerows|eff_dt|curr_cd|ibflag|cre_dt|mnr_meas_ut_cd|upd_usr_id|apro_ofc_cd|cre_usr_id|mnr_trf_sts_dt|mnr_trf_knd_cd|sts_ref_no|mnr_trf_rmk|trf_no|cre_usr_nm|eq_knd_nm|mnr_inp_tp_cd|mnr_trf_sts_cd|eq_knd_cd|upd_dt|pre_trf_no');

					//0 mnr_trf_sts_nm|1 vndr_seq|2 vndr_nm|3 agmt_no|4 rqst_ofc_cd|5 pagerows|6 eff_dt|7 curr_cd|8 ibflag|9 cre_dt|10 mnr_meas_ut_cd|11 mnr_trf_knd_nm|12 upd_usr_id|13 apro_ofc_cd|14 cre_usr_id|15 mnr_trf_sts_dt|16 mnr_trf_knd_cd|17 sts_ref_no|18 mnr_trf_rmk|19 trf_no|20 cre_usr_nm|21 eq_knd_nm|22 mnr_inp_tp_cd|23 mnr_trf_sts_cd|24 eq_knd_cd|25 mnr_meas_ut_nm|26 upd_dt|27 pre_trf_no					
					
					//Detail
					var eqTypeCd = arrResult[0][24];
					searchType = 0;
					
					if(eqTypeCd=="U") {
						ComOpenWait(true,true);
						for(var i = 1; i < arrXml.length; i++){
							sheetObjects[i].LoadSearchXml(arrXml[i]);
							//Editalbe설정
							for(var j=sheetObjects[i].HeaderRows; j<=sheetObjects[i].LastRow; j++) {
								setEditableByVolumeType(sheetObjects[i],j);	
							}
						}
						setTabSelect(); //탭선택
						ComOpenWait(false,true);
					} 
					else if (eqTypeCd=="Z") {
						for(var i = 1; i < arrXml.length; i++){
							sheetObjects[1].LoadSearchXml(arrXml[5]);
							//Editalbe설정
							for(var j=sheetObjects[1].HeaderRows; j<=sheetObjects[1].LastRow; j++) {
								setEditableByVolumeType(sheetObjects[1],j);	
							}
						}
					}
					else if (eqTypeCd=="G") {
						for(var i = 1; i < arrXml.length; i++){
							//Editalbe설정
							sheetObjects[1].LoadSearchXml(arrXml[6]);
							for(var j=sheetObjects[1].HeaderRows; j<=sheetObjects[1].LastRow; j++) {
								setEditableByVolumeType(sheetObjects[1],j);	
							}
						}
					}
					
                }
                break;

			//저장
            case IBSAVE:
                if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = MULTI;
					formObj.mnr_meas_ut_cd.value 	= formObj.combo4.Code;  	//Unit Of Mass
					formObj.curr_cd.value 			= formObj.combo3.Text;  	//Currency
					formObj.eq_knd_cd.value 		= formObj.combo2.Code;  	//EQ Type
					formObj.eq_knd_nm.value 		= formObj.combo2.Text;  	//EQ Type Name
					formObj.mnr_trf_knd_cd.value 	= "STD";  				 	//Tariff 종류 표시(STD:Standard Tariff, LCL:Local Tariff)
					formObj.pre_trf_no.value		= "SML("+comboValue+")-S-";	//Tariff_No의 prefix

					//Tariff Status Code  (SS:Save[SPP],SR:Request[SPP],SD:Delete[SPP],HR:Request,HS:Save,HJ:Reject,HD:Delete,HE:Expired,HA:Approval)
					//Save
					if(sheetObj.id == 't1sheet1') {  
						formObj.mnr_trf_sts_cd.value = "HS";
						saveType = 0;  
					} 
					//Confirm
					else if (sheetObj.id == 't2sheet1') {
						formObj.mnr_trf_sts_cd.value = "HA";
						setRowStausByConfirm();	//저장이벤트 발생을 위한 상태변경
						saveType = 1;
					}
					//Delete
					else {
						formObj.mnr_trf_sts_cd.value = "HD";
						setRowStausByConfirm();	//저장이벤트 발생을 위한 상태변경
						saveType = 2;
					}
					
					//2009-12-24:속도향상을 위해 형식변경
					//var sParam = ComGetSaveString(sheetObjects);
					var sParam = "";
					for(var i=1; i<=4; i++) {
						if(sheetObjects[i].RowCount > 0) {
							sParam = sParam + "&" +	MnrGetAllSaveText(sheetObjects[i], true, "ibflag");
						}
					}
					
					if (sParam == "") return;
				    sParam += "&" + FormQueryString(formObj);
					//Tariff No 를 return 받는다.
				    sSaveRtnXml = sheetObjects[1].GetSaveXml("EES_MNR_0014GS.do", sParam);
					
				    sheetObjects[1].LoadSaveXml(sSaveRtnXml);  //저장 성공확인 메세지를 위한 Load
				}
                break;

			//복사 
			case "COPY":
				if(validateForm(sheetObj,formObj,sAction)) {
					//조건부 값 초기화
					formObj.trf_no.value 			= "NEW"; 	  			//trf_no for save
					formObj.search_trf_no.value 	= "NEW";				//trf_no for search
					formObj.search_trf_no.className	= "input1";				//trf_no for search
					formObj.search_trf_no.readOnly 	= false;				//trf_no for search
					formObj.combo2.Enable 			= false;				//EQ Type
					formObj.rqst_ofc_cd.value		= currOfcCd;			//Tariff Office
					formObj.cre_usr_id.value		= usrId;				//Creation User
					formObj.cre_dt.value 			= ComGetNowInfo("ymd");	//Creation Date
					formObj.eff_dt.value 			= ComGetNowInfo("ymd"); //Eff.from
					formObj.eff_dt.readOnly 		= false; 				//Eff.from
					formObj.eff_dt.className 		= "input1"; 			//Eff.from
					formObj.mnr_trf_sts_cd.value 	= "";					//Status
					formObj.combo1.Code2 			= "";					//Status
					
					//조회부 시트상태값,trf_no 변경
					setRowStausByCopy(formObj);
					
					//Button Enable 설정  
					setButtonEnDisable();    
				}
				break;
				
            //Row 입력
			case IBINSERT:
			    if(validateForm(sheetObj,formObj,sAction)) {
				    var Row = sheetObj.DataInsert(-1);
					//Tariff No
					sheetObj.CellValue2(Row, "trf_no") = formObj.trf_no.value;
					//Volume Edit 설정
					setEditableByVolumeType(sheetObj,Row);  
					//cost_grp_cd 설정
					if(comboValue=="U") {
						if(sheetObj.id == 't1sheet1') {
							sheetObj.CellValue2(Row, "cost_grp_cd") = "MRDR";
						}
						else if (sheetObj.id == 't2sheet1') {   
							sheetObj.CellValue2(Row, "cost_grp_cd") = "MRRF";
				   	   	}
						else if (sheetObj.id == 't3sheet1') {   
							sheetObj.CellValue2(Row, "cost_grp_cd") = "MRRU";
				   	   	}
						else if (sheetObj.id == 't4sheet1') {   
							sheetObj.CellValue2(Row, "cost_grp_cd") = "MRDS";
				   	   	}
						
					} else if(comboValue=="Z"){
						sheetObj.CellValue2(Row, "cost_grp_cd") = "MRZS";
					} else if (comboValue=="G") {
						sheetObj.CellValue2(Row, "cost_grp_cd") = "MRGS";
					}
					//set Value Init
					sheetObj.CellValue2(Row, "eq_cmpo_cd")		= "";  	//Component
					sheetObj.CellValue2(Row, "eq_rpr_cd") 		= "";  	//Repair
					sheetObj.CellValue2(Row, "trf_div_cd") 		= "";  	//Div
					sheetObj.CellValue2(Row, "eq_cmpo_up_cd")	= "";  	//Component Group
					sheetObj.CellValue2(Row, "mnr_rng_tp_cd")	= "F";	//Hidden Range Type
					sheetObj.CellValue2(Row, "vol_tp_cd")		= "Q";  //Hidden Volume Type
					//set Focus
					sheetObj.SelectCell(Row, "eq_cmpo_cd");
				}
                break;
				
			//Row Copy
			case IBCOPYROW:
			    if(validateForm(sheetObj,formObj,sAction)) {
					var Row = sheetObj.DataCopy();
					setDivCombo(sheetObj,Row);	//Div GridCombo Set
				}    
				break;
				
			//Row 삭제
			case IBDELETE:
			    if(validateForm(sheetObj,formObj,sAction)) {
					ComRowHideDelete(sheetObj, "del_chk");
				}    
				break;
				
            //Load Excel
			case IBLOADEXCEL:
				if(validateForm(sheetObj,formObj,sAction)) {
					var eqTypeCd = formObj.combo2.Code; //EQ Type
				    ComOpenPopup('/hanjin/EES_MNR_0190.do?eqTypeCd='+eqTypeCd, 1020, 591, 'setEES_MNR_190', '1,0,1,1,1,1,1,1,1,1,1,1', false);
					searchType = 1;
				}   
				break;

            //Down Excel
			case IBDOWNEXCEL:
			    //sheetObj.Down2Excel(-1);
				sheetObj.SpeedDown2Excel(-1);
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
				//Dataformat
				if (!ComChkValid(formObj)) {return false;}
				//Tariff No 체크
				var trfNo = formObj.search_trf_no.value;
				if(trfNo=="NEW") {
					ComShowCodeMessage("MNR00003");
					formObj.search_trf_no.focus();
					return false;
				}
			}
			//저장(확정,삭제)시
			else if(sAction==IBSAVE) {
				//Tariff상태값 체크
				if(!checkTariffStatus()) {return false;}
				//필수
				if(!checkMandatory(formObj.eff_dt)) {return false;}
				//그리드 존재유무 
				if(!checkIsDetailRow()) {return false;}
				//각시트별 중복체크
				for (var i=1; i<sheetObjects.length; i++){
					var Row = sheetObjects[i].ColValueDup("eq_cmpo_cd|eq_rpr_cd|trf_div_cd|fm_rng_sz_no|to_rng_sz_no|mnr_rng_tp_cd|vol_tp_cd|rpr_qty|rpr_sz_no");
					if(sheetObjects[i].IsDataModified){
						if(Row>0){
							ComShowCodeMessage("MNR00006",i + "th sheet of " + (Row - 1) + " row ");	
							sheetObjects[i].SelectCell(Row, "eq_cmpo_cd", true);  
							return false;
						}
					}
				}
				//각 시트의 VolumnType별 Q'ty,Size/Square체크, Man-Hour 체크, FmTo 체크 
				for (var i=1; i<sheetObjects.length; i++){

					if(sheetObjects[i].RowCount > 0) {
						for(var j=sheetObjects[i].HeaderRows; j<=sheetObjects[i].LastRow; j++) {
						    var volTpCd		= sheetObjects[i].CellValue(j, "vol_tp_cd");	//Type
						    var rprQty 		= sheetObjects[i].CellValue(j, "rpr_qty");		//Q'ty
						    var rprSzNo 	= sheetObjects[i].CellValue(j, "rpr_sz_no");	//Size/Square
						    var rprLbrHrs	= sheetObjects[i].CellValue(j, "rpr_lbr_hrs");	//Man-Hour
						    var fmRngSzNo	= sheetObjects[i].CellValue(j, "fm_rng_sz_no");	//Fm
						    var toRngSzNo	= sheetObjects[i].CellValue(j, "to_rng_sz_no");	//To
						    
						    rprQty 		= ComParseInt(rprQty);		//Q'ty
						    rprSzNo 	= ComParseInt(rprSzNo);		//Size/Square
						    fmRngSzNo	= ComParseInt(fmRngSzNo);	//Fm
						    toRngSzNo	= ComParseInt(toRngSzNo);	//To
						    
						    if(isNaN(fmRngSzNo)) {fmRngSzNo=0};  //Fm
						    if(isNaN(toRngSzNo)) {toRngSzNo=0};  //To
						    
							//Q'ty
							if(volTpCd=='Q') {
								if(rprQty < 1){
									ComShowCodeMessage("MNR00175",(i) + "th sheet of " + (j - 1) + "row\'s Q'ty");
									sheetObjects[i].SelectCell(j, "rpr_qty", true); 
									return false;
								}
							} 
							//Size/Square
							else {
								if(rprSzNo < 1){
									ComShowCodeMessage("MNR00175",(i) + "th sheet of " + (j - 1) + "row\' Size/Square");
									sheetObjects[i].SelectCell(j, "rpr_sz_no", true); 
									return false;
								}
								if(fmRngSzNo > toRngSzNo){
									ComShowCodeMessage("MNR00166");
									sheetObjects[i].SelectCell(j, "to_rng_sz_no", true); 
									return false;
								}
								//Size 범위 체크
								var mnrRngTpCdView = sheetObjects[i].CellValue(j, "mnr_rng_tp_cd_view"); //Range Type
								if(mnrRngTpCdView=="F") {
									if(toRngSzNo < rprSzNo){
										ComShowCodeMessage("MNR00166");
										sheetObjects[i].SelectCell(j, "rpr_sz_no", true); 
										return false;
									}
									if(fmRngSzNo > rprSzNo){
										ComShowCodeMessage("MNR00166");
										sheetObjects[i].SelectCell(j, "rpr_sz_no", true); 
										return false;
									}
								}
							}
							//Man-Hour
							if(rprLbrHrs == "") {
								ComShowCodeMessage("MNR00175",(i) + "th sheet of " + (j - 1) + " row\'s  Man-Hour");
								sheetObjects[i].SelectCell(j, "rpr_lbr_hrs", true); 
								return false;
							}
						}
					}
				}
  				//Delete버튼 클릭시
				if(sheetObj.id == 't3sheet1'){
					if(!ComShowCodeConfirm("MNR00026")){return false}
				}
				//Confirm버튼 클릭시
				if(sheetObj.id == 't2sheet1'){
					if(!ComShowCodeConfirm("MNR00197")){return false}
				}
			}
			//복사시
			else if (sAction=="COPY") {
				//그리드 존재유무 
				if(!checkIsDetailRow()) {return false;}
			}
			//행 삭제시
			else if (sAction==IBDELETE) {
				if(sheetObj.FindCheckedRow("del_chk") == ""){ 
					ComShowCodeMessage("MNR00038","DELETE ");
					return false;             	   
				}
			}
			//행 복사시
			else if (sAction==IBCOPYROW) {
				//그리드 존재유무 
				if(!checkIsDetailRow()) {return false;}
			}
			//Load Excel
			else if (sAction==IBLOADEXCEL) {
				//Tariff상태값 체크
				if(!checkTariffStatus()) {return false;}
			}
        }
        return true;
    }

/* ********* User Functions ************* */
	/**
	 * EES_MNR_0188 Popup의 값을 받은 함수      
	 */
	function setEES_MNR_0188(aryPopupData, row, col, shhetIdx){
    	 var formObj = document.form; 
		        
		 if(aryPopupData[0][3] != null && aryPopupData[0][3] != "") {
    	 	formObj.search_trf_no.value = aryPopupData[0][3];
		 }
		 doActionIBSheet(sheetObjects[1],formObj,IBSEARCH); 
	}      

    /**
     * 저장시 필수 체크
     * @param	{Element}	obj	체크할 Form Element
     */
	function checkMandatory(obj) {
		if(ComIsEmpty(obj)) {  
		    ComShowCodeMessage("MNR00003");
		    obj.focus();
		    return false;
		}
		return true;
	}
	
	/**
	 * 저장시 그리드 존재유무
	 */
	function checkIsDetailRow(){
		var cnt = 0;
		for (var i=1; i<sheetObjects.length; i++) {
			if(sheetObjects[i].RowCount > 0) {
				cnt++;
			}
		}
		if(cnt<1) { return false}

		return true;
	}
	
	/**
	 * Confirm/Delete버튼 클릭시 저장이벤트를 강제 발생시키기 위해 
	 * 존재하는 최초의 1개의 Row상태값만을 'U'로 변경시킴
	 */
	function setRowStausByConfirm(){
		for (var i=1; i<sheetObjects.length; i++) {
			//데이터가 존재하는 시트인 경우만  
			if(sheetObjects[i].RowCount > 0) {
				for(var j=sheetObjects[i].HeaderRows; j<=sheetObjects[i].LastRow; j++) {
					if(sheetObjects[i].RowStatus(j)== "R") {
					    sheetObjects[i].RowStatus(j) = "U";
						return;
					}
				}
			}
		}
	}
	
	/**
	 * Copy버튼 클릭시 그리드의 모든 Row의 상태값을 'I'로 변경시키고 trf_no값 초기화시킴
	 * @param	{Form}		formObj		폼오브젝트
	 */
	function setRowStausByCopy(formObj){
		for (var i=1; i<sheetObjects.length; i++) {
			//데이터가 존재하는 시트인 경우만  
			if(sheetObjects[i].RowCount > 0) {
				for(var j=sheetObjects[i].HeaderRows; j<=sheetObjects[i].LastRow; j++) {
					if(sheetObjects[i].RowStatus(j)!= "D") {
					    sheetObjects[i].RowStatus(j) = "I";
						sheetObjects[i].CellValue2(j, "trf_no") = formObj.trf_no.value;
					}
				}
			}
		}
	}

	/**
	 * Volume Type 콤보값에 따라 Q'ty와 Size/Square의 값을 재설정한다.
	 * Volume Type:Q -> Size/Square=0, 		Volume Type:S -> Q'ty=0 
	 * Volume Type:Q -> Q'ty=Edit,			Volume Type:S -> Size/Square=Edit 
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}		Row			Row
	 * @param	{String}	Val			Value
	 */
    function setEditableByVolumeType(sheetObj,Row){
		var volTpCd = sheetObj.CellValue(Row, "vol_tp_cd_view");
		//Q'ty
		if(volTpCd=='Q'){
			///////////////////////////////////////////////////////////////////////////
	    	//(2009-09-03): QTY / Size의 에 대하여 Size/Square Section을 입력 할수 있도록 처리
			///////////////////////////////////////////////////////////////////////////
			sheetObj.CellValue2(Row, "rpr_sz_no")		= "";
			sheetObj.CellEditable(Row, "rpr_sz_no") 	= false;
			
			sheetObj.CellEditable(Row, "rpr_qty") 		= true;
			sheetObj.ReturnCellData(Row, "rpr_qty");
			
		//Size/Square
		} else {
			sheetObj.CellValue2(Row, "rpr_qty")			= "";
			sheetObj.CellEditable(Row, "rpr_qty") 		= false;
			
			sheetObj.CellEditable(Row, "rpr_sz_no") 	= true;
			sheetObj.ReturnCellData(Row, "rpr_sz_no");
		}
	}	

	/** 
	 * 시트 콤보박스에 입력한 코드가 존재하는지 확인
	 * 시트 콤보박스 입력 변경시 코드값이 존재하는지 확인하고
	 * 존재하는 경우 Description 값도 자동설정한다.
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 * @param	{Int}		comboSeq	콤보서열
	 */
	function checkIsComboValue(sheetObj,Row,Col,Value,comboSeq){
 		for(var j = 0; j < comboListGrid[comboSeq].length;j++){ 
			var tempText = comboListGrid[comboSeq][j].split("|");
			//존재하는 코드
			if(tempText[0]==Value) {return ;}   
		}
		//존재하지 않는 코드
		ComShowCodeMessage("MNR00165",Value);
		sheetObj.CellValue2(Row,Col) ="";
		sheetObj.SelectCell(Row,Col, true);
	}
	
	/** 
	 * Description 설정
	 * Component,Repair,Div 시트콤보 변경시 Description을 조합하여 자동부여
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}		Row			Row
	 */
	function setDescripton(sheetObj,Row) {
		var componentCode 	= sheetObj.CellValue(Row,"eq_cmpo_cd");
		var componentDesc	= getDescription(componentCode,0);
		var divCode 		= sheetObj.CellValue(Row,"trf_div_cd");
		var divDesc 		= "";
		var repairCode 		= sheetObj.CellValue(Row,"eq_rpr_cd");
		var repairDesc 		= getDescription(repairCode,1);
		sheetObj.CellValue2(Row, "dtl_desc") = "["+componentCode+"]"+componentDesc +" - ["+repairCode+"]"+ repairDesc+" - ["+divCode+"]";
	} 
	
	/** 
	 * 시트 콤보박스의 코드에 해당하는 값을 반환
	 * Component,Repair의 코드명을 구한다.
	 * @param	{String}	Val			Value
	 * @param	{Int}		comboSeq	콤보서열
	 * @return  {String}    tempDesc    CodeName
	 */
	function getDescription(Value,comboSeq){
		var tempDesc = "";
 		for(var j = 0; j < comboListGrid[comboSeq].length;j++){ 
			var tempText = comboListGrid[comboSeq][j].split("|");
			if(tempText[0]==Value) {
				tempDesc = tempText[1];
				return tempDesc; 
			}   
		}
		return tempDesc; 
	}

	/** 
	 * Range Type에 Additional Volume 선택시 동일한 스택에 First Volume 선택 Row가 존재하는지 체크
	 *     동일한 스팩에 선택된 First Voume이 없다면 에러 메세지 발생  
	 * Range Type에 Limit Volume 선택시 동일한 스택에 Additional Volume 선택 Row가 존재하는지 체크
	 *     동일한 스팩에 선택된 Addtional Voume이 없다면 에러 메세지 발생 
	 *     
	 *     체크통과한다면 Hidden 컬럼에 값 설정  
	 *     
	 *     동일 스팩 기준(Component, Repair, Loc, Div, Fm, To)
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 * @param	{Int}		comboSeq	콤보서열
	 */
	function checkRangeType(sheetObj,Row,Value) {
		var rowEqCmpoCd 	= sheetObj.CellValue(Row,"eq_cmpo_cd");		//Component
		var rowEqRprCd 		= sheetObj.CellValue(Row,"eq_rpr_cd");		//Repair
		var rowTrfDivCd 	= sheetObj.CellValue(Row,"trf_div_cd");		//Option Div
		var rowFmRngSzNo	= sheetObj.CellValue(Row,"fm_rng_sz_no");	//Size Section Fm
		var rowToRngSzNo 	= sheetObj.CellValue(Row,"to_rng_sz_no");	//Size Section To
		var rowSpec = rowEqCmpoCd + rowEqRprCd + rowTrfDivCd + rowFmRngSzNo + rowToRngSzNo;
			
		for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++) {
			if(Row!=i){
				var iEqCmpoCd 	= sheetObj.CellValue(i,"eq_cmpo_cd");	//Component
				var iEqRprCd 	= sheetObj.CellValue(i,"eq_rpr_cd");	//Repair
				var iTrfDivCd 	= sheetObj.CellValue(i,"trf_div_cd");	//Option Div
				var iFmRngSzNo	= sheetObj.CellValue(i,"fm_rng_sz_no");	//Size Section Fm
				var iToRngSzNo 	= sheetObj.CellValue(i,"to_rng_sz_no");	//Size Section To
				var iSpec = iEqCmpoCd + iEqRprCd + iTrfDivCd + iFmRngSzNo + iToRngSzNo;
				
				if(rowSpec==iSpec) {
					var iMnrRngTpCd = sheetObj.CellValue(i,"mnr_rng_tp_cd_view");
					if(Value=='A') {
						if(iMnrRngTpCd=='F') {
							sheetObj.CellValue2(Row,"mnr_rng_tp_cd") =  Value;
							return;
						}	
					} else if(Value=='L') {
						if(iMnrRngTpCd=='A') {
							sheetObj.CellValue2(Row,"mnr_rng_tp_cd") =  Value;
							return;
						}
					} else {
						sheetObj.CellValue2(Row,"mnr_rng_tp_cd") =  Value;
						return;
					}
				}
			}
		}
		
		if(Value=='A') {
			ComShowCodeMessage("MNR00176");
		} else if(Value=='L') {
			ComShowCodeMessage("MNR00214");
		}
		sheetObj.CellValue2(Row,"mnr_rng_tp_cd_view")	= "F";
		sheetObj.CellValue2(Row,"mnr_rng_tp_cd") 		= "F";
		sheetObj.SelectCell(Row, "mnr_rng_tp_cd_view");  
	}

	/** 
	 * 조회 성공시 처리함.
	 */
	function doAfterSearch() {
		//search
		if(searchType==0) {
			var formObject = document.form;
			formObject.search_trf_no.readOnly = "true";		//Tariff No ReadOnly
			formObject.search_trf_no.className = "input2";	//Tariff No Class
			formObject.combo2.Enable = false;  				//EQ_Type Edit설정
			//Status(Tariff Approval)
			var status = formObject.combo1.Code;
			if(status=="HA") {
				formObject.eff_dt.readOnly = "true";	//Eff.from
				formObject.eff_dt.className = "input2";	//Eff.from
				formObject.combo4.Enable = false;		//Unit Of Measure
			} else {
				formObject.eff_dt.readOnly = "false";	//Eff.from
				formObject.eff_dt.className = "input1";	//Eff.from
				formObject.combo4.Enable = true;		//Unit Of Measure
			}
		}
		//load excel
		else if(searchType==1) {
			ComOpenWait(true,true);
			for(var i=1; i<sheetObjects.length; i++) {
				for(var j=sheetObjects[i].HeaderRows; j<= sheetObjects[i].LastRow; j++){
					setEditableByVolumeType(sheetObjects[i],j);	//set Edit Qty/Size by VolumeType
					var trfNo = sheetObjects[i].CellValue(j, "trf_no");
					if(trfNo=="NEW") {
						sheetObjects[i].RowStatus(j) = "I";      
					}
				}
			}
			ComOpenWait(false,true);
		}
		
		//no match combo 설정 
		for(var i=1; i<sheetObjects.length; i++) {
			setNoMatchCombo(sheetObjects[i]);
		}
	}
	/** 
	 * 저장 성공시 처리함.
	 * 삭제저장:초기화, 저장/확정저장:재조회
	 */
	function doAfterSave() {
		//삭제후 초기화
		if(saveType==2) {
			doActionIBSheet(sheetObjects[1],document.form,IBCLEAR,1);
		}  
		//저장,확정후 재조회 
        else {
			var arrResult = MnrXmlToArray(sSaveRtnXml);
			document.form.search_trf_no.value = arrResult[0][19];
			doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
		}
	}

	/**
	 * setEES_MNR_190 의 값을 받은 함수  
	 * @param Array[]	rArray				리턴받은 데이터
	 */
	function setEES_MNR_190(rArray){
		//팝업에서 직접처리함.
    }    

	/** 
	 * 상태에 따라 버튼을 활성/비활성화 시킴
	 * 상태값이 확정인 경우 비활성화 시키는 버튼
	 * (Delete, Save, Confirm, LoadExcel) 
	 */
    function setButtonEnDisable() {
		var mnrTrfStsCd = document.form.mnr_trf_sts_cd.value;
		if(mnrTrfStsCd=="HA"){
			ComBtnDisable("btn_Delete");
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_Confirm");
			ComBtnDisable("btn_t1LoadExcel");
			ComBtnDisable("btn_t1RowAdd");
			ComBtnDisable("btn_t1Delete");
			ComBtnDisable("btn_t1RowCopy");
			ComBtnDisable("btn_t2LoadExcel");
			ComBtnDisable("btn_t2RowAdd");
			ComBtnDisable("btn_t2Delete");
			ComBtnDisable("btn_t2RowCopy");
			ComBtnDisable("btn_t3LoadExcel");
			ComBtnDisable("btn_t3RowAdd");
			ComBtnDisable("btn_t3Delete");
			ComBtnDisable("btn_t3RowCopy");
			ComBtnDisable("btn_t4LoadExcel");
			ComBtnDisable("btn_t4RowAdd");
			ComBtnDisable("btn_t4Delete");
			ComBtnDisable("btn_t4RowCopy");

		} else {
			ComBtnEnable("btn_Delete");
			ComBtnEnable("btn_Save");
			ComBtnEnable("btn_Confirm");
			ComBtnEnable("btn_t1LoadExcel");
			ComBtnEnable("btn_t1RowAdd");
			ComBtnEnable("btn_t1Delete");
			ComBtnEnable("btn_t1RowCopy");
			ComBtnEnable("btn_t2LoadExcel");
			ComBtnEnable("btn_t2RowAdd");
			ComBtnEnable("btn_t2Delete");
			ComBtnEnable("btn_t2RowCopy");
			ComBtnEnable("btn_t3LoadExcel");
			ComBtnEnable("btn_t3RowAdd");
			ComBtnEnable("btn_t3Delete");
			ComBtnEnable("btn_t3RowCopy");
			ComBtnEnable("btn_t4LoadExcel");
			ComBtnEnable("btn_t4RowAdd");
			ComBtnEnable("btn_t4Delete");
			ComBtnEnable("btn_t4RowCopy");
		}
	}
	
	/**
	 * Tariff 상태값을 체크하여 확정인 경우 false를 
	 * 그외의 경우는 true를 리턴한다.
	 * @return  {Boolean}    true/false
	 */
	function checkTariffStatus() {
		var mnrTrfStsCd = document.form.mnr_trf_sts_cd.value; //mnr_trf_sts_cd
		if(mnrTrfStsCd=="HA"){
			ComShowCodeMessage("MNR00190","Tariff");
			return false;
		}
		return true;
	}
	
	/**
	 * 탭명 조회 설정
	 */
	function setTabName() {
		var sCondition = new Array (
			new Array("MnrGenCd","CC", "CUSTOM3") //탭명조회
		)
		tabList = MnrComSearchCombo(sheetObjects[1],sCondition);
		
		var uCnt = 0;
		var gCnt = 0;
		var zCnt = 0;

		for(var i = 0; i < tabList[0].length;i++){
			var tempText = tabList[0][i].split("|");
			if(tempText[0] == "U"){    
				uTab[uCnt++] = tempText[1]; 					
			} 	
			if(tempText[0] == "Z"){  
				zTab[zCnt++] = tempText[1];      		
			}  
			if(tempText[0] == "G"){   
				gTab[gCnt++] = tempText[1];		
			} 	
		}
	}

	/**
	 * 쉬트 콤보 데이티 조회
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 */
	function setSheetCombo(sheetObj) {
		//쉬트 콤보데이타 조회	
		var sCondition = new Array (					      
			new Array("MnrEqCmpoCdByEqType","3",document.form.combo2.Code), //Component
			new Array("MnrCedexOthCd","RPR","COMMON"), 	//Repair
			new Array("MnrGenCd","CD00012", "COMMON"),	//RangeType
			new Array("MnrGenCd","CD00013", "COMMON")	//Type
		)		             
		comboListGrid = MnrComSearchCombo(sheetObj,sCondition);
		//쉬트 콤보데이타에 값을 세팅함 	
		var sheetComboText = "";	  
		var sheetComboCode = "";	
		var sheetComboDefault = "";	
		//쉬트 콤보 SAVE_NAME
		var comboSaveNames = new Array();
		comboSaveNames[0] = "eq_cmpo_cd";
		comboSaveNames[1] = "eq_rpr_cd";
		comboSaveNames[2] = "mnr_rng_tp_cd_view";  
		comboSaveNames[3] = "vol_tp_cd_view";  
		
		for(var i = 0; i < comboListGrid.length;i++){
		 	if(comboListGrid[i] != null){
				//쉬트콤보별 초기화
				sheetComboText = "";
				sheetComboCode = "";
				sheetComboCodeText = "";
				sheetComboDefault = ""; 
				   
		 		for(var j = 0; j < comboListGrid[i].length;j++){ 
					var tempText = comboListGrid[i][j].split("|");    
					 
					sheetComboText +=  tempText[1] + "|";
					sheetComboCode +=  tempText[0] + "|";
					sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
					if(j ==0){
						sheetComboDefault = tempText[0];      	
					}  
				}
				
				//탭별 쉬트 콤보 설정
				for(var k=1; k<sheetObjects.length; k++) {
					//[CODE][NAME]:Component,Repair
					//||i==1 RPR Componet가 바뀌면 바뀌어야 한다. 
					if(i==0) {
						sheetObjects[k].InitDataCombo (0, comboSaveNames[i], sheetComboCodeText, sheetComboCode ,sheetComboDefault); 
					}
					//[NAME]:RangeType,Type 
					else if(i==2||i==3) {  
						sheetObjects[k].InitDataCombo (0, comboSaveNames[i], sheetComboText, sheetComboCode ,sheetComboDefault); 
					} 
				}
			}    
		}       
		//쉬트 콤보를 설정   폼 콤보와 동일하여 여기서 설정한다.
		if (sheetComboText != "") {
	        sheetComboText = sheetComboText.substr(0, sheetComboText.length - 1);	
		}
		if (sheetComboCode != "") {
	        sheetComboCode = sheetComboCode.substr(0, sheetComboCode.length - 1);
		}
		//모든 쉬트를 초기화 	 
	    for(i=0;i<sheetObjects.length;i++){
	    	sheetObjects[i].RemoveAll(); 
        }
	}
	
	/** 
	 * Div 시트콤보 설정
	 * Component,Repair 시트콤보 변경시 Div 조회
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}		Row			Row
	 */
	function setDivCombo(sheetObj,Row) {
		var eqCmpoCd		= sheetObj.CellValue(Row, "eq_cmpo_cd");
		var eqRprCd 		= sheetObj.CellValue(Row, "eq_rpr_cd");
		var costGrpCd		= sheetObj.CellValue(Row, "cost_grp_cd");
		var prefixCostGrpCd	= costGrpCd.substring(0,3);
					
		if(eqCmpoCd != "") {	
			var compRprJoinStr = ComTrimAll(eqCmpoCd) + ComTrimAll(eqRprCd);	
			var sCondition = new Array (         
			 	new Array("MnrDivCd",compRprJoinStr +','+ prefixCostGrpCd, "COMMON1")
			) 	 	       
			var comboList = MnrComSearchCombo(sheetObj,sCondition);      
				         
			var lbComboText = "";   
			var lbComboCode = ""; 
			var lbComboCodeText = ""; 
			//TS형 콤보타입 
			if(comboList[0] != null){     
				for(var j = 0; j < comboList[0].length;j++){ 
					var tempText = comboList[0][j].split("|");  
					lbComboCode +=  tempText[0] + "|";       
					lbComboText +=  tempText[1] + "|";
					lbComboCodeText += tempText[0] + "\t" + tempText[1] + "|";
				}      
			}	 	  	
			lbComboCode = MnrDelLastDelim(lbComboCode);  
					
			dummyEvent = true;
			sheetObj.CellComboItem (Row, "trf_div_cd", lbComboCodeText, lbComboCode);  
			dummyEvent = false;
			sheetObj.CellValue(Row, "div_flag") = "1";	 //search flag 설정
		}
	}

	/** 
	 * Repair 시트콤보 설정
	 * Component,Repair 시트콤보 변경시 Div 조회
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}		Row			Row
	 */
	function setRprCombo(sheetObj,Row) {	
		var eqCmpoCd		= sheetObj.CellValue(Row, "eq_cmpo_cd");
				
		if(eqCmpoCd != "") {
			var sCondition = new Array (	  		    
	 			new Array("MnrRprCd",eqCmpoCd,"COMMON")		
	 		)							
																												
			var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);
			var sheetComboCode = "";
			var sheetComboText = ""; 
			var sheetComboCodeText = ""; 
										
	 		var comboSaveNames = new Array();	
								
			for(var i = 0; i < comboList.length;i++){
			 	if(comboList[i] != null){
					sheetComboText = ""; 
					sheetComboCode = "";
					sheetComboCodeText = "";
											   	
			 		for(var j = 0; j < comboList[i].length;j++){ 
						var tempText = comboList[i][j].split("|");    
						sheetComboCode +=  tempText[0] + "|";    
						sheetComboText +=  tempText[1] + "|";
						sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
					}	
																						
					sheetComboCode = 	MnrDelLastDelim(sheetComboCode); 																				
			     	sheetComboText = 	MnrDelLastDelim(sheetComboText);  
			        sheetComboCodeText = MnrDelLastDelim(sheetComboCodeText);
					
					dummyEvent = true;											
					sheetObj.CellComboItem (Row, "eq_rpr_cd", sheetComboCodeText, sheetComboCode);
					dummyEvent = false;
				}   	 
		 	}			
			//******************** Component 바뀌면 RPR 코드 다시 조회해 온다. END *************
			sheetObj.CellValue(Row, "rpr_flag") = "1";	 //search flag 설정
			//sheetObj.CellValue2(Row ,"eq_rpr_cd") = "";		
		}	
	}
	
	/** 
	 * no match combo 설정
	 *      엑셀로드시 쉬트 콤보에 일치하지 않는 값이 들어올때 설정
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 */
	function setNoMatchCombo(sheetObj) {
		for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++){        
			//no match combo 설정 
			var divCd 		= sheetObj.CellValue(i, "trf_div_cd");
			
			if(divCd=="") {
				divCd = sheetObj.CellText(i,"trf_div_cd");  
				sheetObj.CellValue2(i,"trf_div_cd") = divCd; 
			}
		}
	}
	
	/**
	 * 조회후 4개의 탭중 값이 존재하는 탭을 선택하여 보여줌
	 * @return
	 */
	function setTabSelect(){
		for (var i=1; i<=4; i++) {
			var rowCnt = sheetObjects[i].RowCount;
			if(rowCnt>0) {
				tabObjects[0].SelectedIndex = (i-1);
				return;
			}
		}
	}
	
	/**
	 * Display 된 RangeType 변경시 Hidden 된 RangeType 에도 값을 입력한다.
	 * @param sheetObj
	 * @param Row
	 * @param Value
	 * @return
	 */
	function setRangeTypeHidden(sheetObj,Row,Value) {
		sheetObj.CellValue2(Row, "mnr_rng_tp_cd") = Value;
	}
	
	/**
	 * Display 된 Volume Type 변경시 Hidden 된 Volume Type 에도 값을 입력한다.
	 * @param sheetObj
	 * @param Row
	 * @param Value
	 * @return
	 */
	function setVolumeTypeHidden(sheetObj,Row,Value) {
		sheetObj.CellValue2(Row, "vol_tp_cd") = Value;
	}
/* 개발자 작업	*/		