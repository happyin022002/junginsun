/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mnr_0221.js
*@FileTitle : Sold Creation File Import_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.10.06 김완규
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
     * @class ees_mnr_0221 : ees_mnr_0221 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mnr_0221() {
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

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject = sheetObjects[0];
        /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				//Verify
		        case "btn_Save":
	                doActionIBSheet(sheetObject, formObject, IBSAVE); 
	                break;        
					
		        case "btn_RowAdd":
	                doActionIBSheet(sheetObject, formObject, IBINSERT); 
	                break;        
					
		        case "btn_RowDel":
	                doActionIBSheet(sheetObject, formObject, IBDELETE); 
	                break;        

				case "btn_New":
					doActionIBSheet(sheetObject, formObject, IBCLEAR);
					break;

				case "btn_LoadExcel":
					doActionIBSheet(sheetObject, formObject, IBLOADEXCEL);
					break;

				case "btn_OK":
					doActionIBSheet(sheetObject, formObject, "doOK");
					break;

				case "btn_Close":
					window.close();
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

    	//IBSheet 초기화
    	for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
        }	
    	
    	//화면초기화
    	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
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
		var sheetId = sheetObj.id;

        switch(sheetId) {
            case "sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 202;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);

                    var HeadTitle1 = "|Sel|Del|Seq|EQ No.|P/Up Yard|Sold DT|Verify Result";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(9, 0, 0, true); 

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    		
                    //데이터속성    [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
                    InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	false,	"checkbox");
                    InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	false,	"del_check");
					InitDataProperty(0, cnt++ , dtSeq,			30,		daCenter,	false,	"seq");
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,	"inp_msg1",	false,	"",	dfNone,		0,	true,	true,	14);	//EQ No
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,	"inp_msg2",	false,	"",	dfNone,		0,	true,	true,	7);		//Yard
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,	"inp_msg3",	false,	"",	dfDateYmd,	0,	true,	true,	8);		//Sold DT
					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		false,	"inp_msg5",	false,	"",	dfNone,		0,	false,	false);			//Verify Result Name
					InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		false,	"inp_msg4");     												//Verify Result Code
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
                }
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
	 * 체크박스 이벤트
	 * Sel 체크박스를 해제하면 Edit를 재설정 한다.
	 * Sel checkBox:Edit  -> false
	 * All Column  :Edit  -> true
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
				sheetObj.CellEditable(Row, "inp_msg1") = true; 
				sheetObj.CellEditable(Row, "inp_msg2") = true; 
				
				//set BackColor
				sheetObj.RowBackColor(Row) = sheetObj.RgbColor(SheetEditBackColorR,SheetEditBackColorG,SheetEditBackColorB);
			} 
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
				sheetObj.WaitImageVisible = false;
				MnrWaitControl(true);
				
		    	sheetObj.RemoveAll();
		    	verifyCheck = false;
		    	
				//버튼 ,프로그레스바 설정
				MnrWaitControl(false);
				sheetObj.WaitImageVisible = true;

			//Verify
			case IBSAVE:        
				if(validateForm(sheetObj,formObj,sAction)) {
	          		formObj.f_cmd.value = MULTI;
					          
					var sParam = sheetObj.GetSaveString(true, true); 
					if (sParam == "") return;
				    sParam += "&" + FormQueryString(formObj); 
				    var sXml = sheetObj.GetSaveXml("EES_MNR_0221GS.do", sParam);
				    sheetObj.LoadSaveXml(sXml); 
				    
				    verifyCheck = true;
				    
				    doAfterSave();
				}
				break;

			//행추가
			case IBINSERT:
				var Row = sheetObj.DataInsert(-1); 
				//set CheckBox(Sel) Edit(false) 	 
				sheetObj.CellEditable(Row,"checkbox") = false;
				//set Focus 
				sheetObj.SelectCell(Row, "inp_msg1");
				break;
				
			//행삭제
			case IBDELETE:
				ComRowHideDelete(sheetObj, "del_check");
				break;
				
			//Load Excel
			case IBLOADEXCEL:
			    var columnMapping = "1=>4|2=>5|3=>6"; 
			 	sheetObj.LoadExcel(0, 1, "", -1, -1, "", false,false,columnMapping);
				
			 	//Sel Column Edit 설정
			 	for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++){        
					sheetObj.CellEditable(i,"checkbox") = false;
				}
				break;

			//OK
			case "doOK":
				if(validateForm(sheetObj,formObj,sAction)) {
					comPopupOK();	
				}
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
				var Row = sheetObj.ColValueDup("inp_msg1");
				if(Row>0){
					ComShowCodeMessage("MNR00006",(Row) + " row ");
					sheetObj.SelectCell(Row, "inp_msg1", true);  
					return false;
				}
			}
			//OK버튼 클릭시
			else if(sAction=="doOK") {
				//Verify 실행여부 체크
				if(!verifyCheck){  
					ComShowCodeMessage("MNR00157");
					return false;          		 	  
				}
				//부모창의 입력될 EQ No 와  선택한 EQ No 의 갯수를 비교 체크한다.  
				var selCnt = 0;
				for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++) {
					var selValue = sheetObj.CellValue(i, "checkbox");
					if(selValue == "1") {
						selCnt++;
					}
				}
				var insCnt = formObj.ins_cnt.value;
				if(insCnt < selCnt) {
					//입력될 EQ No 보다 선택된 EQ No 의 갯수가 많습니다.
					ComShowCodeMessage("MNR00266"); 
					return false;
				}
			}
        }
        return true;
    }

/* ********* User Functions ************* */
	/** 
	 * Verify 처리후 색상,수정여부 설정
	 */
	function doAfterSave() {
		for(var i=sheetObjects[0].HeaderRows; i<=sheetObjects[0].LastRow; i++ ) {
			var verifyResult = sheetObjects[0].CellValue(i, "inp_msg4");
			//성공
			if(verifyResult == "SS") {
				sheetObjects[0].RowBackColor(i) = sheetObjects[0].RgbColor(SelectBackColorR, SelectBackColorG, SelectBackColorB);
				sheetObjects[0].CellEditable(i, "inp_msg1") = false;
				sheetObjects[0].CellEditable(i, "inp_msg2") = false;
			//에러
			} else {
				sheetObjects[0].RowBackColor(i) = sheetObjects[0].RgbColor(ErrorColBackColorR, ErrorColBackColorG, ErrorColBackColorB); 
				sheetObjects[0].CellEditable(i, "checkbox") = false;
			}
		}
	}