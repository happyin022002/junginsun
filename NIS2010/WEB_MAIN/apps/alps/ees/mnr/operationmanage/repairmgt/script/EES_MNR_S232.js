/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_S232.js
*@FileTitle : Repair Creation File Import_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 손흥식
*@LastVersion : 1.0
* 2009.09.29 손흥식
* 2009.11.20 권영법   
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
     * @class EES_MNR_S232 : EES_MNR_S232 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_MNR_S232() {
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
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;       

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;    

var comboValue = "";  
//검증작업을 한데이타만 부모화면으로 이동가능
var verifyCheck = false;      
var retComboVal = "";   

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
		        case "btn_new":  
                    doActionIBSheet(sheetObject, formObject, IBCLEAR);
                    break;   

                 case "btn_loadExcel": 
				 	sheetObject.LoadExcel(0, 1, "", -1, -1, "", false,false,"1=>4|2=>5|3=>6");
					for(var i = 1; i <= sheetObject.RowCount; i++){        
						sheetObject.RowStatus(i) = "R";  
						sheetObject.CellEditable(i,"checkbox") = false;          
					}                  
                    break;          		     
 	 
		        case "btn_ok":
                    if(sheetObject.FindCheckedRow("checkbox") == ""){ 

						ComShowCodeMessage("MNR00038","SELECT ");             	   
					} else if(!verifyCheck){  

						ComShowCodeMessage("MNR00157");          		 	  
					} else {     

						comPopupOK_0122(sheetObject,formObject); 	
					}                                   
					break;         

		        case "btn_Save":    
                    doActionIBSheet(sheetObject, formObject, IBSAVE); 
                    break;        
					   
		        case "btn_RowAdd":                  
                    doActionIBSheet(sheetObject, formObject, IBINSERT);        
                    break; 
					      
		        case "btn_RowDel":                     
                    doActionIBSheet(sheetObject, formObject, IBDELETE);        
                    break;        

		        case "btn_close":    
                    self.close();  
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
		MnrWaitControl(true); 
        for(i=0;i<sheetObjects.length;i++){

        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i + 1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);

			doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
        }
		  
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k + 1);
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
            case 1:      //t1sheet1 init
                with (sheetObj) { 

                    // 높이 설정  
                    style.height = 242;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;  

                    //전체Edit 허용 여부 [선택, Default false] 
                    Editable = true;             
  
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100); 

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(54, 0, 0, true);        
						 
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)
					   
                    var HeadTitle = "|Sel.|Del.|Seq.|EQ No.|Yard|Repair Date|System Verify Result";
 									 	
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true); 
    											                
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	 	50,    	daCenter,  	false,   	"ibflag"); 
//                  InitDataProperty(0, cnt++ , dtStatus,	 	50,    	daCenter,  	false,   	"ibflag"); 
                    InitDataProperty(0, cnt++ , dtCheckBox,   40,    daCenter,  false,   "checkbox",     false,          "",      dfNone,		0,			true,		true);           
                    InitDataProperty(0, cnt++ , dtDummyCheck,   40,    daCenter,  false,   "del_check",     false,          "",      dfNone,		0,			true,		true);               
					InitDataProperty(0, cnt++ , dtDataSeq,    40,    daCenter,  true,    "Seq",     false,          "",      dfNone);
					InitDataProperty(0, cnt++ , dtData,      90,    daCenter,  false,     "inp_msg1",     true,          "",      dfNone,		0,			true,		true,	11,	false);      
                    InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  false,     "inp_msg2",     true,        "",      dfNone,		0,			true,		true,	7,	true); 
                    InitDataProperty(0, cnt++ , dtData,      170,    daCenter,  false,     "inp_msg3",     false,       "",      dfDateYmd,		0,			true,		true);    
					                     
                    InitDataProperty(0, cnt++ , dtData,      65,    daLeft,     false,     "inp_msg5",     false,        "",      dfNone,		0,			false,		false);               
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg4",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg6",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg7",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg8",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg9",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg10",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg11",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg12",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg13",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg14",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg15",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg16",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg17",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg18",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg19",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg20",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg21",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg22",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg23",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg24",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg25",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg26",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg27",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg28",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg29",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg30",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg31",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg32",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg33",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg34",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg35",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg36",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg37",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg38",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg39",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg40",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg41",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg42",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg43",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg44",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg45",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg46",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg47",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg48",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg49",	   false,		"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg50",	   false,		"",		 dfNone,		0,			false,		false);
                    
					                         
					InitDataValid(0,  "inp_msg1", vtEngUpOther,"0123456789"); 
					InitDataValid(0,  "inp_msg2", vtEngUpOther,"0123456789"); 
					         	     	   
					//SELECT 로우 배경색                  
					//SelectionMode MultiSelection=false이면 1개의 행만 선택 가능           
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
	 * Combo 기본 설정    
	 * @param	{IBMultiCombo}	combo_obj	콤보오브젝트. 
	 * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호 
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */     
	function initCombo (comboObj, comboNo) {   
	    //var cnt  = 0 ; 
	    var formObject = document.form
	     
	    switch(comboNo) {    
	          case 1: 
	           with (comboObj) { 
	      	   	 
		       SetColAlign("left");         
			   DropHeight = 160;  
		    }      
	           break;    
	     } 
	}   
	         
  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;   
        switch(sAction) {
			 case IBSAVE:        //저장
              		formObj.f_cmd.value = MULTI;   
					formObj.eq_type.value = comboValue;     
					       	   
					for(var i = 1; i <= sheetObj.RowCount; i++){
						sheetObj.RowStatus(i) = "I";      
					}   
		
					var sParam = sheetObj.GetSaveString(false, true); 
					if (sParam == "") return;
					
					sParam += "&vndr_seq=" + formObj.vndr_seq.value;  
				    sParam += "&" + FormQueryString(formObj);  
				    var sXml = sheetObj.GetSaveXml("EES_MNR_S232GS.do", sParam);
				    sheetObj.LoadSaveXml(sXml); 
								 
					//체크된 로우에 색상을 입힌다.     
					for(var i = 1; i <= sheetObj.RowCount; i++){  
						if(sheetObj.CellValue(i,"checkbox") == 1){    
							sheetObj.RowBackColor(i) = sheetObj.RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);	
							//success 된것은 수정하지 못하게 한다.
							sheetObj.CellEditable(i,"inp_msg1") = false;
							sheetObj.CellEditable(i,"inp_msg2") = false;
							sheetObj.CellEditable(i,"inp_msg3") = false; 
						} else {                 
							sheetObj.RowBackColor(i) = sheetObj.RgbColor(ErrorColBackColorR,ErrorColBackColorG,ErrorColBackColorB);         
							//실패한건은 선택할수 없다. 
							sheetObj.CellEditable(i,"checkbox") = false;  
						}                          
					}         
					verifyCheck = true;
					//verifyCheck에 사용된 eqtype을 저장한다. 
					retComboVal = comboValue;         
                break;      
					        
			case IBINSERT:  // ROWADD                   
					var Row = sheetObj.DataInsert(-1); 
					sheetObj.CellValue2(Row,"inp_msg3") = ComGetNowInfo("ymd"); 
					sheetObj.CellEditable(Row,"checkbox") = false; 
					verifyCheck = false;                       
	      		break; 
				
			case IBDELETE:  // ROWDELETE   
					for(var i = sheetObj.RowCount; i > 0; i--){  
						if(sheetObj.CellValue(i,"del_check") == 1){
							sheetObj.RowDelete(i, false);                     	
						}     	
					}           
				break;
			
			case IBCLEAR: //  콤보 데이터 조회 및 모든 쉬트를 초기화 
					MnrWaitControl(true);
					sheetObj.WaitImageVisible=false;
					//콤보데이타 초기화  
					for(var i = 0; i < comboObjects.length;i++){ 
						comboObjects[i].RemoveAll(); 	
					}     
					
					//combo1 세팅  EQ_TYPE     
					var sCondition = new Array (
							new Array("MnrGenCd","SELHO","CUSTOM9")		//Eq Kind
						); 
					var retArray = MnrComSearchCombo(sheetObj,sCondition); 
					for(var j = 0; j < retArray[0].length;j++){   
						var tempText = retArray[0][j].split("|");  
						                   
						comboObjects[0].InsertItem(j, tempText[1] ,tempText[0]);
						//넘어온 값을 세팅한다.      
						if(formObj.eq_type.value != "" && formObj.eq_type.value == tempText[0].trim()){ 
							comboObjects[0].Code = tempText[0];				 	 		    	
						}  		      
					} 
												 
					//쉬트 초기화
					sheetObj.RemoveAll();  
					verifyCheck = false;  
					sheetObj.WaitImageVisible=true;
                  	MnrWaitControl(false);  
    
	      	   	break; 	
        } 
    }  
     
	/**
     * 추가로 넘겨야 될값이 많아서 따로 구현한다.
     */
	function comPopupOK_0122(sheetObj,formObject) {
		var formObject = document.form; 
    
		var rArray = new Array(); //행데이터를 담고 있는 배열
		var ret_val = new Array(); 
      
		ret_val[0] = retComboVal;    
             
	    var sRow = sheetObj.FindCheckedRow("checkbox");
	    //가져온 행을 배열로 반든다.          
	    var arrRow = sRow.split("|");   
	    
	    for (idx=0; idx < arrRow.length - 1; idx++){     
			var cArray = new Array(); //열데이터를 담고 있는 배열

			cArray[0] = sheetObj.CellValue(arrRow[idx], "inp_msg44");
			cArray[1] = sheetObj.CellValue(arrRow[idx], "inp_msg1"); 
			cArray[2] = sheetObj.CellValue(arrRow[idx], "inp_msg18"); 
			cArray[3] = sheetObj.CellValue(arrRow[idx], "inp_msg7"); 
			cArray[4] = sheetObj.CellValue(arrRow[idx], "inp_msg2");
			cArray[5] = sheetObj.CellValue(arrRow[idx], "inp_msg45"); 
			cArray[6] = sheetObj.CellValue(arrRow[idx], "inp_msg40"); 
			cArray[7] = sheetObj.CellValue(arrRow[idx], "inp_msg46"); 
			cArray[8] = sheetObj.CellValue(arrRow[idx], "inp_msg42");
			cArray[9] = sheetObj.CellValue(arrRow[idx], "inp_msg3"); 
			cArray[10] = sheetObj.CellValue(arrRow[idx], "inp_msg47"); 
			cArray[11] = sheetObj.CellValue(arrRow[idx], "inp_msg34");
			cArray[12] = sheetObj.CellValue(arrRow[idx], "inp_msg8");
			cArray[13] = sheetObj.CellValue(arrRow[idx], "inp_msg47");
			cArray[14] = sheetObj.CellValue(arrRow[idx], "inp_msg9");
			
			rArray[idx] = cArray; 
		}   

		opener.getEES_MNR_S232(rArray);  //호출하는 부모js에 getMnr_Multi 붙여넣으면됩니다.

		window.close();                 
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
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {

                }
             break;

         }
    }

    /** 
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem)
    {  
        var objs = document.all.item("tabLayer"); 

    	objs[nItem].style.display = "Inline";
    	objs[beforetab].style.display = "none";
		  
    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab= nItem; 
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */ 
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){  
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }       
        return true; 
    }   
         
 	/**  
	 * combo1 체인지 이벤트      
	 * @param	{IBMultiCombo}		comboObj	콤보오브젝트  
	 * @param 	{Number} 			Index_Code 	선택된 row 
	 * @param 	{String} 			Text 		선택된 Text  
	 */  
	function combo1_OnChange(comboObj,Index_Code, Text){ 
		comboValue = comboObj.Code;                  
	}     
	
	function sheet1_OnLoadFinish(sheetObj) { 
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    }
	
	/**  
	 * combo1 체크박스 이벤트      
	 * @param	{IBSheet}		sheetObj	콤보오브젝트  
	 * @param 	{String} 			Row 		Row 
	 * @param 	{String} 			Col 		Col 
	 */  
	function sheet1_OnBeforeCheck(sheetObj,Row,Col){  
		if(sheetObj.ColSaveName(Col) == 'checkbox')    
		{
			if(sheetObj.CellValue(Row,Col) != 1){                   
				sheetObj.RowBackColor(Row) = sheetObj.RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);
				
			} else {                            
				sheetObj.RowBackColor(Row) = sheetObj.RgbColor(SheetEditBackColorR,SheetEditBackColorG,SheetEditBackColorB);  
				sheetObj.CellValue2(Row,"inp_msg5") = "";            
				sheetObj.CellEditable(Row,"checkbox") = false;                
				sheetObj.CellEditable(Row,"inp_msg1") = true; 
				sheetObj.CellEditable(Row,"inp_msg2") = true; 
				sheetObj.CellEditable(Row,"inp_msg3") = true;       
				verifyCheck = false;        
			} 
		}				
	} 
	
	//저장후 결과메세지 표시
	function sheet1_OnSaveEnd(sheetObj,ErrMsg){ 
		if (ErrMsg == "") {   
			ComShowCodeMessage("MNR00158");         
		} else { 
			ComShowCodeMessage("MNR00159",ErrMsg);   
		}       
	}
	/* 개발자 작업  끝 */