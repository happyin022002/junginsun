/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mnr_0190.js
*@FileTitle : Local Tariff File Import_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.06.22 김완규
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
     * @class ees_mnr_0190 : ees_mnr_0190 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mnr_0190() {
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
	var sheetObjects = new Array();
	var sheetCnt = 0;
	//검증작업을 한 데이타만 부모화면으로 이동가능
	var verifyCheck = false;
	var comboListGrid =new Array();
	var programId     = "";    

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
		        case "btn_new":  
                    doActionIBSheet(sheetObject1, formObject, IBCLEAR);
                    break;   

                case "btn_downExcel":
					doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
				
                    break;          		     
 	 
                case "btn_loadExcel":
					doActionIBSheet(sheetObject1, formObject, IBLOADEXCEL);
				
                    break;          		     
 	 
		        case "btn_ok":
					doActionIBSheet(sheetObject1, formObject, "doOK");
					break;         
				
				case "btn_close":
					doActionIBSheet(sheetObject1, formObject, "doClose");
					break;
				
				//Verify
		        case "btn_Save":
                    doActionIBSheet(sheetObject1, formObject, IBSAVE); 
                    break;        
					
		        case "btn_RowAdd":
                    doActionIBSheet(sheetObject1, formObject, IBINSERT); 
                    break;        
					
		        case "btn_RowDel":
                    doActionIBSheet(sheetObject1, formObject, IBDELETE); 
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

		//set Opener Program Id
		programId = document.form.program_id.value;
		//set Title as Opener
		setTitle();
		
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+ 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		//set SheetCombo
		setSheetCombo(sheetObjects[0]);
		
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
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
		var sheetID = sheetObj.id;
        switch(sheetID) {
            case "sheet1":
            case "sheet2":
                with (sheetObj) {
                    if(sheetObj.id=="sheet1") {
	                    // 높이 설정
	                    style.height = 350;
					} else {
	                    // 높이 설정
	                    style.height = 0;
					}				
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
 
					var HeadTitle1 = "|Sel|Del|Seq|Cost Group|Mandatory|Mandatory|Option|Description|Range Type|Volume|Volume|Volume|Limitation|Limitation|Man-Hour||Material|Component Group|Remark|Verify Result|Verify Code|Error Warning|Tariff No|DetailSeq|inch_size|cm_size|inch_fm|cm_fm|inch_to|cm_to|div_flag";
					var HeadTitle2 = "|Sel|Del|Seq|Cost Group|Component|Repair|Div|Description|Range Type|Type|QTY|SIZE|Min|Max|Man-Hour||Material|Component Group|Remark|Verify Result|Verify Code|Error Warning|Tariff No|DetailSeq|inch_size|cm_size|inch_fm|cm_fm|inch_to|cm_to|div_flag";

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(32, 8, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
                    
					//Local Tariff(Opener : ees_mnr_0011)
					if(programId=="ees_mnr_0011") {
	                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE,		SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                    InitDataProperty(0, cnt++ , dtHiddenStatus,	50,		daCenter,	false,	"ibflag");
						InitDataProperty(0, cnt++ , dtDummyCheck,	40,		daCenter,  	true,  	"checkbox",     false,  "", dfNone,			0,	false,	false);				//sel
						InitDataProperty(0, cnt++ , dtDelCheck,		40,		daCenter,  	true,  	"del_check",	false,  "", dfNone,			0,	false,	false);  			//del					
	                    InitDataProperty(0, cnt++ , dtDataSeq,		30,		daCenter,	true,	"seq");
						InitDataProperty(0, cnt++ , dtCombo,		120,	daLeft,		true,	"inp_msg17",	false,	"",	dfNone,			0,	false,	false,	4,	true);  //Cost Group Code
						InitDataProperty(0, cnt++ , dtComboEdit,	70,		daCenter,	false,	"inp_msg1",		false,	"",	dfNone,			0,	false,	false,	3,	true);  //Component
						InitDataProperty(0, cnt++ , dtComboEdit,	45, 	daCenter,	false,	"inp_msg2",	    false,	"",	dfNone,			0,	false,	false,	2,	true);	//Repair
						InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	false,	"inp_msg6",		false,	"",	dfNone,			0,	false,	false,	2,	false);	//Div
						InitDataProperty(0, cnt++ , dtData,			150,	daLeft,		true,	"inp_msg7",		false,	"",	dfNone,			0,	false,	false,	500);		//Description
						InitDataProperty(0, cnt++ , dtCombo,		75,		daLeft,		true,	"inp_msg10",	false,	"",	dfNone,			0,	false,	false);				//Range Type
						InitDataProperty(0, cnt++ , dtCombo,		65,		daLeft,		false,	"inp_msg11",	false,	"",	dfNone,			0,	false,	false);				//Volume Type
						InitDataProperty(0, cnt++ , dtData,			28,		daRight,	false,	"inp_msg12",	false,	"",	dfNullInteger,	0,	false,	false,	6,	false);	//Qty
						InitDataProperty(0, cnt++ , dtData,			45,		daRight,	false,	"inp_msg13",	false,	"",	dfNullInteger,	0,	false,	false,	10,	false);	//Size
						InitDataProperty(0, cnt++ , dtData,			48,		daRight,	false,	"inp_msg8",		false,	"",	dfNullInteger,	0,	false,	false,	8,	false);	//Fm
						InitDataProperty(0, cnt++ , dtData,			48, 	daRight,	false,	"inp_msg9",	    false,	"",	dfNullInteger,	0,	false,	false,	8,	false);	//To
						InitDataProperty(0, cnt++ , dtData,			65, 	daRight,	true,	"inp_msg14",	false,	"",	dfNullFloat,	2,	false,	false,	6,	false);	//Man-Hour
						InitDataProperty(0, cnt++ , dtHidden,		100,	daRight,	true,	"inp_msg15",	false,	"",	dfFloat,		2,	false,	false,	18,	false);	//Reco Material
						InitDataProperty(0, cnt++ , dtData,     	55,    	daRight,    true,  	"inp_msg19",   	false,  "", dfNullFloat,	2,	true,	true,	18,	false);	//Material
						InitDataProperty(0, cnt++ , dtHidden,		100,	daLeft,		true,	"inp_msg23",	false,	"",	dfNone,			0,	false,	false);				//Component 2nd
						InitDataProperty(0, cnt++ , dtData,			60,		daLeft,		true,	"inp_msg16",	false,	"",	dfNone,			0,	true,	true,	4000);		//Remark
						InitDataProperty(0, cnt++ , dtData,     	100,    daLeft,     true,  	"inp_msg5",   	false,  "", dfNone,			0,	false,	false);				//Message Name
						
					} 
                    //Standard Tariff(Opener : ees_mnr_0014)
                    else {
	                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE,		SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                    InitDataProperty(0, cnt++ , dtHiddenStatus,	50,		daCenter,	false,	"ibflag");
						InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,  	true,  	"checkbox",     false,  "", dfNone,			0,	true,	true);				//sel
						InitDataProperty(0, cnt++ , dtDummyCheck,	40,		daCenter,  	true,  	"del_check",	false,  "", dfNone,			0,	true,	true);  			//del					
	                    InitDataProperty(0, cnt++ , dtDataSeq,		30,		daCenter,	true,	"seq");
						InitDataProperty(0, cnt++ , dtCombo,		120,	daLeft,		true,	"inp_msg17",	false,	"",	dfNone,			0,	true,	true,	4,	true);  //Cost Group Code
						InitDataProperty(0, cnt++ , dtComboEdit,	70,		daCenter,	false,	"inp_msg1",		false,	"",	dfNone,			0,	true,	true,	3,	true);  //Component
						InitDataProperty(0, cnt++ , dtComboEdit,	45, 	daCenter,	false,	"inp_msg2",	    false,	"",	dfNone,			0,	true,	true,	2,	true);	//Repair
						InitDataProperty(0, cnt++ , dtCombo,		50,		daCenter,	false,	"inp_msg6",		false,	"",	dfNone,			0,	true,	true,	2,	false);	//Div
						InitDataProperty(0, cnt++ , dtData,			150,	daLeft,		true,	"inp_msg7",		false,	"",	dfNone,			0,	true,	true,	500);		//Description
						InitDataProperty(0, cnt++ , dtCombo,		75,		daLeft,		true,	"inp_msg10",	false,	"",	dfNone,			0,	true,	true);				//Range Type
						InitDataProperty(0, cnt++ , dtCombo,		65,		daLeft,		false,	"inp_msg11",	false,	"",	dfNone,			0,	true,	true);				//Volume Type
						InitDataProperty(0, cnt++ , dtData,			28,		daRight,	false,	"inp_msg12",	false,	"",	dfNullInteger,	0,	true,	true,	6,	false);	//Qty
						InitDataProperty(0, cnt++ , dtData,			45,		daRight,	false,	"inp_msg13",	false,	"",	dfNullInteger,	0,	true,	true,	10,	false);	//Size
						InitDataProperty(0, cnt++ , dtData,			48,		daRight,	false,	"inp_msg8",		false,	"",	dfNullInteger,	0,	true,	true,	8,	false);	//Fm
						InitDataProperty(0, cnt++ , dtData,			48, 	daRight,	false,	"inp_msg9",	    false,	"",	dfNullInteger,	0,	true,	true,	8,	false);	//To
						InitDataProperty(0, cnt++ , dtData,			65, 	daRight,	true,	"inp_msg14",	false,	"",	dfNullFloat,	2,	true,	true,	6,	false);	//Man-Hour
						InitDataProperty(0, cnt++ , dtHidden,		100,	daRight,	true,	"inp_msg15",	false,	"",	dfFloat,		2,	true,	true,	18,	false);	//Reco Material
						InitDataProperty(0, cnt++ , dtData,     	55,    	daRight,    true,  	"inp_msg19",   	false,  "", dfNullFloat,	2,	true,	true,	18,	false);	//Material
						InitDataProperty(0, cnt++ , dtHidden,		100,	daLeft,		true,	"inp_msg23",	false,	"",	dfNone,			0,	false,	false);				//Component 2nd
						InitDataProperty(0, cnt++ , dtData,			60,		daLeft,		true,	"inp_msg16",	false,	"",	dfNone,			0,	true,	true,	4000);		//Remark
						InitDataProperty(0, cnt++ , dtData,     	100,    daLeft,     true,  	"inp_msg5",   	false,  "", dfNone,			0,	false,	false);				//Message Name
						
					}
					//Hidden Column
					InitDataProperty(0, cnt++ , dtHidden,     	30,    	daLeft,     true,  	"inp_msg4",   	false,  "", dfNone,			0,	false,	false);				//Message Code
					InitDataProperty(0, cnt++ , dtHidden,     	30,    	daLeft,     true,  	"inp_msg3",   	false,  "", dfNone,			0,	false,	false);				//Error/Warning
					InitDataProperty(0, cnt++ , dtHidden,     	30,    	daLeft,     true,  	"inp_msg18",   	false,  "", dfNone,			0,	false,	false);				//trf_no
					InitDataProperty(0, cnt++ , dtHidden,     	30,    	daCenter,   true,  	"inp_msg20",   	false,  "", dfNone,			0,	false,	false);				//detail_seq
					InitDataProperty(0, cnt++ , dtHidden,     	30,    	daLeft,     true,  	"inp_msg21",   	false,  "", dfNone,			0,	false,	false);				//inch_size
					InitDataProperty(0, cnt++ , dtHidden,     	30,    	daLeft,     true,  	"inp_msg22",   	false,  "", dfNone,			0,	false,	false);				//cm_size
					InitDataProperty(0, cnt++ , dtHidden,     	30,    	daLeft,     true,  	"inp_msg24",   	false,  "", dfNone,			0,	false,	false);				//inch_fm
					InitDataProperty(0, cnt++ , dtHidden,     	30,    	daLeft,     true,  	"inp_msg25",   	false,  "", dfNone,			0,	false,	false);				//cm_fm
					InitDataProperty(0, cnt++ , dtHidden,     	30,    	daLeft,     true,  	"inp_msg26",   	false,  "", dfNone,			0,	false,	false);				//inch_to
					InitDataProperty(0, cnt++ , dtHidden,     	30,    	daLeft,     true,  	"inp_msg27",   	false,  "", dfNone,			0,	false,	false);				//cm_to
					InitDataProperty(0, cnt++ , dtHidden,     	30,    	daCenter,   true,  	"div_flag",   	false,  "", dfNone,			0,	false,	false);				//blank column for excel 
					
					//데이터 Validation
					InitDataValid(0,  "inp_msg1", vtEngUpOther,"0123456789");  
					InitDataValid(0,  "inp_msg2", vtEngUpOther,"0123456789");  
					
					//SELECT 로우 배경색                  
					EditableColorDiff = false;     
					MultiSelection = true;                                    
					SelectionMode = smSelectionRow;  
					//선택시 하이라이트사용하지 않음            
					SelectHighLight = false;           
					//선택시 볼드 사용하지 않음             
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
	 * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
	 * @param    {IBSheet}	sheet_obj	배열로 등록될 IBSheet Object
	 */	
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

    /** 
     * 초기화 이벤트
     *     OnLoad 가 끝나면 초기화 이벤트 실행
     * @param	{Sheet}		sheetObj	프로세스 처리될 시트오브젝트
     */
    /*
    function sheet1_OnLoadFinish(sheetObj) {
		//화면 초기화
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    }
    */
    
	/** 
	 * 셀의 값 변경시 발생하는 Event
	 * Volume Type 콤보값에 따라 Q'ty와 Size/Square의 값을 재설정한다.
	 * Volume Type:Q -> Size/Square=0, Volume Type:S -> Q'ty=0 
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function sheet1_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			var colname = ColSaveName(Col);
			//Component Code
			if(colname=='inp_msg1'){
				checkIsComboValue(sheetObj,Row,Col,Value,0);	//존재유무 체크
				setDescripton(sheetObj,Row);					//Description명 부여
				setDivCombo(sheetObj,Row);						//Div GridCombo Set
				//sheetObj.CellValue(Row, "inp_msg23") = Value;	//2nd Component Code Name set
			}
			//Repair Code
			else if(colname=='inp_msg2'){
				checkIsComboValue(sheetObj,Row,Col,Value,1);  	//존재유무 체크
				setDescripton(sheetObj,Row);					//Description명 부여
				setDivCombo(sheetObj,Row);						//Div GridCombo Set
			}
			//Div Code
			else if(colname=='inp_msg6'){
				setDescripton(sheetObj,Row);					//Description명 부여
			}
			//Range Type
			else if(colname=='inp_msg10'){
				checkRangeType(sheetObj,Row,Value);				//동일스팩에 First Volume 존재유무 체크
			}
			//Volume Type Code
			else if(colname=='inp_msg11'){
				setEditableByVolumeType(sheetObj,Row);  		//Editalbe설정
			}
		}
	}

	/**  
	 * 체크박스 이벤트
	 * Sel 체크박스를 해제하면 Edit를 재설정 한다.
	 * Sel checkBox:Edit  -> false
	 * All Column  :Edit  -> true
	 * Volume Type :Edit  -> setEditableByVolumeType()
	 * Verfy Column:Value -> null
	 * BackColor          -> Edit
	 * @param	{IBSheet}		sheetObj	콤보오브젝트  
	 * @param 	{String} 			Row 		Row 
	 * @param 	{String} 			Col 		Col 
	 */  
	function sheet1_OnBeforeCheck(sheetObj,Row,Col){  
		if(sheetObj.ColSaveName(Col) == 'checkbox') {
			if(sheetObj.CellValue(Row,Col) == 1){
				//set Verify Columns Value null 
				sheetObj.CellValue(Row,"inp_msg4") = "";
				sheetObj.CellValue(Row,"inp_msg5") = "";
				
				//set All Columns Edit true without Sel-checkbox(false)	                              
				sheetObj.CellEditable(Row, "checkbox") = false; 
				sheetObj.CellEditable(Row, "inp_msg17") = true; 
				sheetObj.CellEditable(Row, "inp_msg1") = true; 
				sheetObj.CellEditable(Row, "inp_msg2") = true; 
				sheetObj.CellEditable(Row, "inp_msg6") = true; 
				sheetObj.CellEditable(Row, "inp_msg7") = true; 
				sheetObj.CellEditable(Row, "inp_msg8") = true; 
				sheetObj.CellEditable(Row, "inp_msg9") = true; 
				sheetObj.CellEditable(Row, "inp_msg10") = true; 
				sheetObj.CellEditable(Row, "inp_msg11") = true; 
				sheetObj.CellEditable(Row, "inp_msg12") = true; 
				sheetObj.CellEditable(Row, "inp_msg13") = true; 
				sheetObj.CellEditable(Row, "inp_msg14") = true; 
				sheetObj.CellEditable(Row, "inp_msg15") = true; 
				sheetObj.CellEditable(Row, "inp_msg16") = true; 
				
				//set Edit by VolumeType
				setEditableByVolumeType(sheetObj,Row);
                
				//set BackColor
				sheetObj.RowBackColor(Row) = sheetObj.RgbColor(SheetEditBackColorR,SheetEditBackColorG,SheetEditBackColorB);
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
    function sheet1_OnMouseDown(sheetObj,Button, Shift, X, Y){
		var Row = sheetObj.MouseRow;
		var Col = sheetObj.MouseCol;
		var ColSaveName = sheetObj.ColSaveName(Col);
		
		if(ColSaveName=="inp_msg6") { //Div Code
		    var divFlag = sheetObj.CellValue(Row, "div_flag");
		    var successFlag = sheetObj.CellValue(Row, "inp_msg4");
			if(divFlag=="1"||successFlag=="SS") {return}
			
			setDivCombo(sheetObj,Row); 
		}
	}
  	/**
     * Sheet1관련 프로세스 처리
     * @param	{IBSheet}	sheetObj	프로세스 처리될 시트오브젝트 
     * @param	{Form}		formObj		프로세스 처리될 폼오브젝트
     * @param	{Number}	sAction		분기처리될 액션의 상수값(CoObject.js에 정의) 
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			//초기화
			case IBCLEAR:
				//버튼 ,프로그레스바 설정
				//sheetObj.WaitImageVisible = false;
				MnrWaitControl(true);
				
		    	sheetObj.RemoveAll();
				
				//버튼 ,프로그레스바 설정
				MnrWaitControl(false);
				
				//호출하는 부모창에 따라 쉬트 format 재설정 
				setSheetFormatByOpener(); 
				
				//sheetObj.WaitImageVisible = true;
				break;

			//Load Excel
			case IBLOADEXCEL:
				
				//Local Tariff(Opener : ees_mnr_0011)
				if(programId=="ees_mnr_0011") {
					//2010-03-11 : 로직변경 주석처리 시작
					/* 
					// load Excel
					var rtnLoad = sheetObjects[1].LoadExcel(-1, 1, "", -1, -1, "", false,false,"");
					
					if(!rtnLoad) {return;}  //취소
					
					ComOpenWait(true,true); 
					// check Shown DetailSeq with Hidden DetailSeq
					for(var i=sheetObjects[1].HeaderRows; i<=sheetObjects[1].LastRow; i++){
						var hiddenDetailSeq	= sheetObjects[1].CellValue(i, "inp_msg20");  //DetailSeq(Hidden Sheet)
						var shownDetailSeq  = sheetObjects[0].CellValue(i, "inp_msg20");  //DetailSeq(Shown Sheet)
						if(hiddenDetailSeq != shownDetailSeq) {
							ComShowCodeMessage("MNR00327");
							doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
							return;
						}
					}
					
					// copy Data from Hidden Sheet to Shown Sheet
					sheetObjects[1].Copy2SheetCol(sheetObjects[0], "inp_msg19|inp_msg16", "inp_msg19|inp_msg16");//19:Material,16:Remark
					// set Sel-checkbox checked
					sheetObjects[0].CheckAll2("checkbox") = 1;
					ComOpenWait(false,true);
					*/ 
					//2010-03-11 : 로직변경 주석처리 끝

					var rtnLoad = sheetObjects[0].LoadExcel(-1, 1, "", -1, -1, "", false,false,"");
					if(!rtnLoad) {return;}  //취소
					
				//Standard Tariff(Opener : ees_mnr_0014)
				} else {
					//2009-11-05: Header Style 로 변경
				    //var columnMapping = "1=>4|2=>5|3=>6|4=>7|5=>8|6=>9|7=>10|8=>11|9=>12|10=>13|11=>14|12=>15|13=>19"; 
				 	//sheetObj.LoadExcel(0, 1, "", -1, -1, "", false,false,columnMapping);
					var rtnLoad = sheetObj.LoadExcel(-1, 1, "", -1, -1, "", false,false,"");
					
					if(!rtnLoad) {return;}  //취소
					
					ComOpenWait(true,true);
					for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++){        
						//Sel Column Edit 설정
						sheetObj.CellEditable(i,"checkbox") = false;
						
						//Volume Edit 설정  
						setEditableByVolumeType(sheetObj,i);	
					}
					//no match combo 설정 
					setNoMatchCombo(sheetObj);
					ComOpenWait(false,true);  
				}
				break;
            
			case IBDOWNEXCEL:
				//Local Tariff(Opener : ees_mnr_0011)
				if(programId=="ees_mnr_0011") {
					ComShowCodeMessage("MNR00288");
					//sheetObj.Down2Excel(false, false,false,true, "", "/apps/alps/ees/mnr/agreementmanage/tariffmgt/xml/EES_MNR_0190_FORMAT.xml"); 
					sheetObj.SpeedDown2Excel(false, false,false,"", "/apps/alps/ees/mnr/agreementmanage/tariffmgt/xml/EES_MNR_0190_FORMAT.xml"); 
				
				//Standard Tariff(Opener : ees_mnr_0014)
				} else {
					var Row = sheetObj.DataInsert(-1);
					sheetObj.Down2Excel(true, false,false,true, "", "/apps/alps/ees/mnr/agreementmanage/tariffmgt/xml/EES_MNR_0190_2_FORMAT.xml");
					sheetObj.CellValue(Row, "del_check")= "1";
					ComRowHideDelete(sheetObj, "del_check");
				}
			    break;			

			//OK
			case "doOK":
				if(validateForm(sheetObj,formObj,sAction)) {
					comPopupOK_190(sheetObj);	
				}
				break;
			
			//Close
			case "doClose":
				window.close();
				break;
			
			//Verify
			case IBSAVE:
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = MULTI;
					var sParam = sheetObj.GetSaveString(true, true); 
					if (sParam == "") return;
				    sParam += "&" + FormQueryString(formObj);
					var sXml = sheetObj.GetSaveXml("EES_MNR_0190GS.do", sParam);
				    sheetObj.LoadSaveXml(sXml);
					
					verifyCheck = true;
					ComOpenWait(true,true);
					setNoMatchCombo(sheetObj); //no match combo 설정
					ComOpenWait(false,true);
				}
				break;
			
			//행추가
			case IBINSERT:
				var Row = sheetObj.DataInsert(-1); 
				//set Value init
				sheetObj.CellValue2(Row, "inp_msg1")	= "";	//Component
				sheetObj.CellValue2(Row, "inp_msg2")	= "";  	//Repair
				sheetObj.CellValue2(Row, "inp_msg6") 	= "";  	//Div
				sheetObj.CellValue2(Row, "inp_msg23") 	= "";  	//Component 2nd
				//set Edit by Volume Type
				setEditableByVolumeType(sheetObj,Row);
				//set CheckBox(Sel) Edit(false) 	 
				sheetObj.CellEditable(Row,"checkbox") = false;
				//set Focus 
				sheetObj.SelectCell(Row, "inp_msg17");
				break;
			
			//행삭제
			case IBDELETE:
			    if(validateForm(sheetObj,formObj,sAction)) {
					//ComRowHideDelete(sheetObj, "del_check");
			    	MnrRowDelete(sheetObj, "del_check");
				}    
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
			//Verify버튼 클릭시
			if(sAction==IBSAVE) {
				//중복체크
				var Row = sheetObj.ColValueDup("inp_msg1|inp_msg2|inp_msg6|inp_msg8|inp_msg9|inp_msg10|inp_msg11|inp_msg12|inp_msg17", false);
				if(Row>0){
					ComShowCodeMessage("MNR00006",(Row - 1) + " row ");
					sheetObj.SelectCell(Row, "inp_msg1", true);  
					return false;
				}
			}
			//OK버튼 클릭시
			else if(sAction=="doOK"){
				//2010-03-23: Standard/Local 모두 Verify 함에 따라 로직 모두 적용
				//if(programId!="ees_mnr_0011") {
					//Verify을 하지 않은 경우
					if(!verifyCheck){  
						ComShowCodeMessage("MNR00157");
						return false;          		 	  
					} 
				//} 
				//SEL checkBox의 체크된 값이 하나도 없을때
			    if(sheetObj.FindCheckedRow("checkbox") == ""){ 
					ComShowCodeMessage("MNR00038","SELECT ");
					return false;             	   
				}
			    //Error Data 가 존재할때
			    //2010-03-23: Standard/Local 모두 Verify 함에 따라 로직 모두 적용
			    //if(programId!="ees_mnr_0011") {
			    	for (var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++) {
			    		var selCheck = sheetObj.CellValue(i, "checkbox");
			    		if(selCheck=="0") {
							//Verify 성공하지 못한 Data 가 존재합니다.
			    			ComShowCodeMessage("MNR00301");
			    			sheetObj.SelectCell(i, "checkbox"); 
			    			return false;
			    		}
			    	}
			    //}
			}
			//행삭제 버튼 클릭시
			else if(sAction==IBDELETE) {
				//DEL checkBox의 체크된 값이 하나도 없을때
				if(sheetObj.FindCheckedRow("del_check") == ""){ 
					ComShowCodeMessage("MNR00038","DELETE ");
					return false;             	   
				}
			}
		}
        return true;
    }

/* ********* User Functions ************* */	
  	/**
     * 넘겨야 될값이 많아서 따로 구현한다.
     * @param	{IBSheet}	sheetObj	시트오브젝트 
     */
	function comPopupOK_190(sheetObj) {
		ComOpenWait(true,true);
		
		var frm = opener.document.form;
		
		var sPopUpColNm		= "ibflag|inp_msg1|inp_msg2|inp_msg6|inp_msg7|inp_msg8|inp_msg9|inp_msg10|inp_msg10|inp_msg11|inp_msg11|inp_msg12|inp_msg13|inp_msg14|inp_msg15|inp_msg16|inp_msg17|inp_msg18|inp_msg19|inp_msg20|inp_msg21|inp_msg22|inp_msg23|inp_msg24|inp_msg25|inp_msg26|inp_msg27";
		var sOpenerColNm	= "ibflag|eq_cmpo_cd|eq_rpr_cd|trf_div_cd|dtl_desc|fm_rng_sz_no|to_rng_sz_no|mnr_rng_tp_cd_view|mnr_rng_tp_cd|vol_tp_cd_view|vol_tp_cd|rpr_qty|rpr_sz_no|rpr_lbr_hrs|mtrl_reco_amt|dtl_rmk|cost_grp_cd|trf_no|mtrl_cost_amt|trf_dtl_seq|inch_size|cm_size|eq_cmpo_up_cd|inch_fm|cm_fm|inch_to|cm_to";

		var eqTypeCd = document.form.eq_knd_cd.value;
		var sDivider = "";
		if(eqTypeCd=="U") {
			sDivider = "MRDR|MRRF|MRRU|MRDS";
		} else if (eqTypeCd=="Z"){
			sDivider = "MRZS";
		} else if (eqTypeCd=="G"){
			sDivider = "MRGS";
		}
		sheetObj.Redraw = false;
		for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++){
			sheetObj.CellValue2(i,"inp_msg18") = frm.trf_no.value;
			
			if(programId=="ees_mnr_0011") {
				sheetObj.CellValue2(i,"inp_msg20") = i - 1;
			}else{
				sheetObj.CellValue2(i,"ibflag") = "I";
			}	
		}
		sheetObj.Redraw = true;
 		var sXml = MnrMakeSearchXmls(sheetObj, "checkbox", sPopUpColNm, sOpenerColNm, "inp_msg17", sDivider);
		if(programId=="ees_mnr_0011") {
			frm.t1sheet1.RemoveAll();
			frm.t2sheet1.RemoveAll();
			frm.t3sheet1.RemoveAll();
			frm.t4sheet1.RemoveAll();
		}
		frm.t1sheet1.LoadSearchXml(sXml[0], true);
		frm.t2sheet1.LoadSearchXml(sXml[1], true);
		frm.t3sheet1.LoadSearchXml(sXml[2], true);
		frm.t4sheet1.LoadSearchXml(sXml[3], true);
		
		ComOpenWait(false,true);
			
		window.close();
	}
	
	/** 
	 * 시트 콤보박스에 입력한 코드가 존재하는지 확인
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
		var componentCode 	= sheetObj.CellValue(Row,"inp_msg1");
		var componentDesc	= getDescription(componentCode,0);
		var repairCode 		= sheetObj.CellValue(Row,"inp_msg2");
		var repairDesc 		= getDescription(repairCode,1);
		var divCode 		= sheetObj.CellValue(Row,"inp_msg6");
		var divDesc 		= "";
		sheetObj.CellValue2(Row, "inp_msg7") = "["+componentCode+"]"+componentDesc +" - ["+repairCode+"]"+ repairDesc+" - ["+divCode+"]";
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
	 * Range Type의 First Volume이외 선택시 동일한 스택에 First Volume 선택 Row가 존재하는지 체크
	 * 동일한 스팩에 선택된 First Voume이 없다면 에러 메세지 발생  
	 * 동일 스팩 기준(Component, Repair, Loc, Div, Fm, To)
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 * @param	{Int}		comboSeq	콤보서열
	 */
	function checkRangeType(sheetObj,Row,Value) {
		if(Value!='F') {
			var rowEqCmpoCd 	= sheetObj.CellValue(Row,"inp_msg1");	//Component
			var rowEqRprCd 		= sheetObj.CellValue(Row,"inp_msg2");	//Repair
			var rowTrfDivCd 	= sheetObj.CellValue(Row,"inp_msg6");	//Option Div
			var rowFmRngSzNo	= sheetObj.CellValue(Row,"inp_msg8");	//Size Section Fm
			var rowToRngSzNo 	= sheetObj.CellValue(Row,"inp_msg9");	//Size Section To
			var rowCostGrpCd 	= sheetObj.CellValue(Row,"inp_msg17");	//Cost Group Code
			var rowSpec = rowEqCmpoCd + rowEqRprCd + rowTrfDivCd + rowFmRngSzNo + rowToRngSzNo + rowCostGrpCd;
			
			for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++) {
				if(Row!=i){
					var iEqCmpoCd 	= sheetObj.CellValue(i,"inp_msg1");		//Component
					var iEqRprCd 	= sheetObj.CellValue(i,"inp_msg2");		//Repair
					var iTrfDivCd 	= sheetObj.CellValue(i,"inp_msg6");		//Option Div
					var iFmRngSzNo	= sheetObj.CellValue(i,"inp_msg8");		//Size Section Fm
					var iToRngSzNo 	= sheetObj.CellValue(i,"inp_msg9");		//Size Section To
					var iCostGrpCd 	= sheetObj.CellValue(i,"inp_msg17");	//Cost Group Code
					var iSpec = iEqCmpoCd + iEqRprCd + iTrfDivCd + iFmRngSzNo + iToRngSzNo +iCostGrpCd;
					
					if(rowSpec==iSpec) {
						var iMnrRngTpCd = sheetObj.CellValue(i,"inp_msg10");
						if(iMnrRngTpCd=='F') {
							return;
						}	
					}
				}
			}
			ComShowCodeMessage("MNR00176");
			sheetObj.CellValue2(Row,"inp_msg10") = "F";
			sheetObj.SelectCell(Row, "inp_msg10");  
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
		var volTpCd = sheetObj.CellValue(Row, "inp_msg11");	//Volume Type
		//Q'ty
		if(volTpCd=='Q'){
			///////////////////////////////////////////////////////////////////////////
	    	//(2009-09-03): QTY / Size의 에 대하여 Size/Square Section을 입력 할수 있도록 처리
			///////////////////////////////////////////////////////////////////////////
			
			//sheetObj.CellValue2(Row, "inp_msg8")	= "";		//Fm
			//sheetObj.CellValue2(Row, "inp_msg9")	= "";		//To
			sheetObj.CellValue2(Row, "inp_msg13")	= "";		//Size
			//sheetObj.CellEditable(Row, "inp_msg8") 	= false;	//Fm
			//sheetObj.CellEditable(Row, "inp_msg9") 	= false;	//To
			sheetObj.CellEditable(Row, "inp_msg13") = false;	//Size
			
			sheetObj.CellEditable(Row, "inp_msg12") = true;		//Qty
			sheetObj.ReturnCellData(Row, "inp_msg12");			//Qty
			
		//Size/Square
		} else {
			sheetObj.CellValue2(Row, "inp_msg12")	= "";		//Qty
			sheetObj.CellEditable(Row, "inp_msg12") = false;	//Qty
			
			//sheetObj.CellEditable(Row, "inp_msg8")	= true;		//Fm
			//sheetObj.CellEditable(Row, "inp_msg9") 	= true;		//To
			sheetObj.CellEditable(Row, "inp_msg13")	= true;		//Size
			//sheetObj.ReturnCellData(Row, "inp_msg8");			//Fm
			//sheetObj.ReturnCellData(Row, "inp_msg9");			//To
			sheetObj.ReturnCellData(Row, "inp_msg13");			//Size
		}
	}	

    /**
     * 호출하는 Opener에 따라 sheet의 format 재설정
     *   
     *   ees_mnr_0011(Local Tariff) 일 경우
     *   : 버튼 Disable    	- verify, RowAdd, RowDel
     *     컬럼 감추기     	- VerifyResult 컬럼
     *     데이터 가져오기	- 부모창인 ees_mnr_0011의 데이터를 공통함수를 이용하여 가져온다.
     *     수정여부 재설정   - Remark,Material컬럼 이외에는 모든 컬럼 수정 못하도록 함.
     *   
     *   ees_mnr_0014(Standard Tariff) 일 경우
     *   : 버튼 Disalbe     - Templete Down Excel  
     *   : 컬럼 감추기    	- ees_mnr_0011 에서 사용하는 Material,Tariff No,DetailSeq컬럼을 감춘다. 
     */
	function setSheetFormatByOpener() {
		//Opener programdId : ees_mnr_0011
		if(programId=="ees_mnr_0011") {
			//Button Disable
			//2010-03-24 : Local 에도 Verify 로직 추가함에 따라 버튼 Display
			//ComBtnDisable("btn_Save");  //Verify
			ComBtnDisable("btn_RowAdd");
			ComBtnDisable("btn_RowDel");
			
			//hidden Column
			//2010-03-24 : Local 에도 Verify 로직 추가함에 따라 Verify Result 컬럼 Display
			//sheetObjects[0].ColHidden("inp_msg5")  = true;  //Verify Result
			sheetObjects[0].ColHidden("inp_msg18") = true;  //Tariff No
			sheetObjects[0].ColHidden("inp_msg19") = false;	//Material
			
			//get Opener(ees_mnr_0011) Data
			//-----------------------------
			getOpenerData();
			//-----------------------------

		//Opener programdId : ees_mnr_0014
		} else {
			//hidden Column
			sheetObjects[0].ColHidden("inp_msg19") = true;	//Material
			sheetObjects[0].ColHidden("inp_msg20") = true;	//detail_seq
		}
	}
	
	/** 
	 * 호출하는 부모창에서 Data 가져오기
	 * 
	 * 	ees_mnr_0011에서 호출됐을때 공통함수(MnrMakeSearchXml())를 사용하여
	 *  부모창의 쉬트 데이타를 그대로 가져온다.
	 */
	function getOpenerData() {
		//get Opener Sheets
		var frm = opener.document.form;
		var thisObjects = new Array();
		thisObjects[0] = frm.t1sheet1;
		thisObjects[1] = frm.t2sheet1;
		thisObjects[2] = frm.t3sheet1;
		thisObjects[3] = frm.t4sheet1;
		
		var eqTypeCd = document.form.eq_knd_cd.value; //EQ Type
		//Container
		if(eqTypeCd=="U") {
			var cnt = 0;
			var openerSheetObjects = new Array();
			for (var i=0; i<thisObjects.length; i++) {
				//Only get Sheets with RowCount>0
				if(thisObjects[i].RowCount>0) {
					openerSheetObjects[cnt++] = thisObjects[i]
				}
			}
		//Chassis,MGSet
		} else {
			var openerSheetObjects = new Array(frm.t1sheet1);
		}
		var sTime1 = new Date();
		//get Opener Data by MnrMakeSearchXml()
		var saveName = "ibflag|seq|inp_msg17|inp_msg1|inp_msg2|inp_msg6|inp_msg7|inp_msg10|inp_msg11|inp_msg12|inp_msg13|inp_msg8|inp_msg9|inp_msg14|inp_msg15|inp_msg19|inp_msg23|inp_msg16|inp_msg18|inp_msg20|inp_msg21|inp_msg22|inp_msg24|inp_msg25|inp_msg26|inp_msg27";
		//---------------------------------------------------------------
 		var sXml = MnrMakeSearchXml(openerSheetObjects, saveName, false);
		//---------------------------------------------------------------
		sheetObjects[0].LoadSearchXml(sXml);
	}

	/** 
	 * 호출하는 부모창에 따른 Title변경
	 * 
	 * 	ees_mnr_0011에서 호출됐을때 - Local Tariff
	 *  ees_mnr_0014에서 호출됐을때 - Standard Tariff
	 */
	function setTitle() {
	    if(programId=="ees_mnr_0011") {
			document.title = "Local Tariff File Import_Pop Up";
			document.getElementById("title1").innerHTML = "Local Tariff File Import";
			document.getElementById("title2").innerHTML = "Local Tariff File Format";
			document.getElementById("materialName").style.display = "block";
			document.getElementById("materialValue").style.display = "block";
		} else {
			document.title = "Standard Tariff File Import_Pop Up";
			document.getElementById("title1").innerHTML = "Standard Tariff File Import";
			document.getElementById("title2").innerHTML = "Standard Tariff File Format";
			document.getElementById("materialName").style.display = "none";
			document.getElementById("materialValue").style.display = "none";
		}
	}

	/**
	 * 쉬트의 콤보데이터들을 조회하고 세팅한다.
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 */
	function setSheetCombo(sheetObj){
		//쉬트 콤보데이타 조회
		var eqTypeCd = document.form.eq_knd_cd.value;
		var sCondition = new Array (      
			new Array("MnrEqCmpoCd","3","COMMON"), 			//Component
			new Array("MnrCedexOthCd","RPR","COMMON"), 		//Repair
			new Array("MnrGenCd","CD00012", "COMMON"),		//RangeType
			new Array("MnrGenCd","CD00013", "COMMON"),		//Type 
			new Array("MnrGenCd","CC"+eqTypeCd, "CUSTOM2")//,	//CostGroup
		)             
		comboListGrid = MnrComSearchCombo(sheetObj,sCondition);
		//쉬트 콤보데이타에 값을 세팅함 
		var sheetComboText 		= "";  
		var sheetComboCode 		= "";
		var sheetComboCodeText	= "";
		var sheetComboTextCode	= "";
		var sheetComboDefault 	= "";
		//쉬트 콤보 SAVE_NAME
		var comboSaveNames = new Array();
		comboSaveNames[0] = "inp_msg1";		//Component
		comboSaveNames[1] = "inp_msg2";		//Repair 
		comboSaveNames[2] = "inp_msg10";	//RangeType  
		comboSaveNames[3] = "inp_msg11";	//Type  
		comboSaveNames[4] = "inp_msg17";	//CostGroup
		
		for(var i = 0; i < comboListGrid.length;i++){
		 	if(comboListGrid[i] != null){
				//쉬트콤보별 초기화
				sheetComboText = "";
				sheetComboCode = "";
				sheetComboCodeText = "";
				sheetComboTextCode = "";
				sheetComboDefault  = ""; 
				   
		 		for(var j = 0; j < comboListGrid[i].length;j++){ 
					var tempText = comboListGrid[i][j].split("|");    
					 
					sheetComboText +=  tempText[1] + "|";
					sheetComboCode +=  tempText[0] + "|";
					sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
					
					sheetComboTextCode +=  tempText[1] + "\t" + tempText[0] + "|";
					if(j ==0){
						sheetComboDefault = tempText[0];      	
					}  
				}
				//쉬트 콤보 설정
				//[NAME][CODE]:CostGroup,RangeType,Type
				if(i==4 || i==2 ||i==3 ) {
					sheetObj.InitDataCombo (0, comboSaveNames[i], sheetComboTextCode, sheetComboCode, "", sheetComboDefault); 
				}
				//[CODE][NAME]:,Component,Repair
				else if(i==0 || i==1) {  
					sheetObj.InitDataCombo (0, comboSaveNames[i], sheetComboCodeText, sheetComboCode, sheetComboDefault); 
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
	}
	
	/** 
	 * Div 시트콤보 설정
	 *     Component,Repair 시트콤보 변경시 Div 조회
	 *     Div 시트콤보 클릭시 1회에 한하여 Div조회
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}		Row			Row
	 */
	function setDivCombo(sheetObj,Row) {
		var eqCmpoCd		= sheetObj.CellValue(Row, "inp_msg1");
		var eqRprCd 		= sheetObj.CellValue(Row, "inp_msg2");
		var divCd 			= sheetObj.CellValue(Row, "inp_msg6");
		var costGrpCd 		= sheetObj.CellValue(Row, "inp_msg17");
		var prefixCostGrpCd	= costGrpCd.substring(0,3);
		
		if(eqCmpoCd != "" && eqRprCd != "") {
			var compRprJoinStr = ComTrimAll(eqCmpoCd) + ComTrimAll(eqRprCd);	
			var sCondition = new Array (         
			 	new Array("MnrDivCd",compRprJoinStr +','+ prefixCostGrpCd, "COMMON1")
			) 	 	       
			var comboList = MnrComSearchCombo(sheetObj,sCondition);      
				         
			var lbComboText = "";   
			var lbComboCode = ""; 
			
			//TS형 콤보타입 
			if(comboList[0] != null){     
				for(var j = 0; j < comboList[0].length;j++){ 
					var tempText = comboList[0][j].split("|");  
					 
					lbComboText +=  tempText[1] + "|";
					lbComboCode +=  tempText[0] + "|";
				}      
			}   		       
			sheetObj.CellComboItem (Row, "inp_msg6", lbComboCode, lbComboCode); 
			
			sheetObj.CellValue(Row, "inp_msg6") = divCd; //no match combo value 유지
			sheetObj.CellValue(Row, "div_flag") = "1";	 //search flag 설정
		}
	}

	/** 
	 * no match combo 설정
	 *      엑셀로드시 쉬트 콤보에 일치하지 않는 값이 들어올때 설정
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 */
	function setNoMatchCombo(sheetObj) {
		sheetObj.Redraw = false;
		for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++){        
			//no match combo 설정 
			var eqCmpoCd	= sheetObj.CellValue(i, "inp_msg1");
			var eqRprCd 	= sheetObj.CellValue(i, "inp_msg2");
			var divCd 		= sheetObj.CellValue(i, "inp_msg6");
			
			if(eqCmpoCd=="") {
				eqCmpoCd = sheetObj.CellText(i,"inp_msg1");  
				sheetObj.CellValue2(i,"inp_msg1") = eqCmpoCd; 
			}
			if(eqRprCd=="") {
				eqRprCd = sheetObj.CellText(i,"inp_msg2");  
				sheetObj.CellValue2(i,"inp_msg2") = eqRprCd; 
			}
			if(divCd=="") {
				divCd = sheetObj.CellText(i,"inp_msg6");  
				sheetObj.CellValue2(i,"inp_msg6") = divCd; 
			}
		}
		sheetObj.Redraw = true;
	}