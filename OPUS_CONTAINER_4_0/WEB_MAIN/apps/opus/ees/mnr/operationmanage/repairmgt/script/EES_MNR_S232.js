/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EXP_SPP_S139.js
*@FileTitle  : SPP Damage Flagging/Unflagging Pop Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/12
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
    }
   	/* 개발자 작업	*/
// 공통전역변수
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;       
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;    
var comboValue="";  
//검증작업을 한데이타만 부모화면으로 이동가능
var verifyCheck=false;      
var retComboVal="";   
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick=processButtonClick;  
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) { 
		        case "btn_new":  
                    doActionIBSheet(sheetObject, formObject, IBCLEAR);
                    break;   
                 case "btn_loadExcel": 
 				 	sheetObject.LoadExcel({ Mode:"NoHeader",WorkSheetNo:"1",StartRow:"-1",EndRow:"-1",WorkSheetName:"",Append:false,ColumnMapping:"1=>4|2=>5|3=>6"});
					                 
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
		        	ComClosePopup(); 
					break;   
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
    		}						
    	}
    }
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    } 
  	/** 
	 * IBCombo Object를 배열로 등록
	 * @param	{IBMultiCombo}	combo_obj	화면에서 사용할 콤보들을 추가한다. 
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */ 
	function setComboObject(combo_obj){     
    	comboObjects[comboCnt++]=combo_obj;  
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
        var cnt=0;
        switch(sheetNo) {
            case 1:      //t1sheet1 init
                with(sheetObj){
                
            var HeadTitle="|Sel.|Del.|Seq.|EQ No.|Yard|Repair Date|System Verify Result";

            SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

            var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            var headers = [ { Text:HeadTitle, Align:"Center"} ];
            InitHeaders(headers, info);

            var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"checkbox",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_check",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq",        KeyField:0,   CalcLogic:"",   Format:"" },
             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"inp_msg1",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"inp_msg2",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
             {Type:"Date",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:0,   SaveName:"inp_msg3",   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:65,   Align:"Left",    ColMerge:0,   SaveName:"inp_msg5",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg4",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg6",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg7",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg8",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg9",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg10",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg11",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg12",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg13",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg14",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg15",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg16",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg17",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg18",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg19",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg20",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg21",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg22",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg23",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg24",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg25",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg26",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg27",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg28",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg29",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg30",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg31",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg32",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg33",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg34",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg35",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg36",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg37",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg38",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg39",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg40",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg41",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg42",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg43",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg44",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg45",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg46",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg47",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg48",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg49",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg50",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
             
            InitColumns(cols);

            SetEditable(1);
            SetEditableColorDiff(0);
            SetSelectionMode(smSelectionRow);
            SetSheetHeight(242);
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
	    var formObject=document.form
	    switch(comboNo) {    
	          case 1: 
	           with (comboObj) { 
	        	  SetColAlign(0, "left");
			   SetDropHeight(160);
		    }      
	           break;    
	     } 
	}   
  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			 case IBSAVE:        //저장
              		formObj.f_cmd.value=MULTI;   
					formObj.eq_type.value=comboValue;     
					for(var i=1; i <= sheetObj.RowCount(); i++){
						sheetObj.SetRowStatus(i,"I");
					}   
					var sParam=sheetObj.GetSaveString(false, true);
					if (sParam == "") return;
					sParam += "&vndr_seq=" + formObj.vndr_seq.value;  
				    sParam += "&" + FormQueryString(formObj);  
 				    var sXml=sheetObj.GetSaveData("EES_MNR_S232GS.do", sParam);
 				    sheetObj.LoadSaveData(sXml);
					//체크된 로우에 색상을 입힌다.     
					for(var i=1; i <= sheetObj.RowCount(); i++){
						if(sheetObj.GetCellValue(i,"checkbox") == 1){
							sheetObj.SetRowBackColor(i,"#NANNANNAN");
							//success 된것은 수정하지 못하게 한다.
							sheetObj.SetCellEditable(i,"inp_msg1",0);
							sheetObj.SetCellEditable(i,"inp_msg2",0);
							sheetObj.SetCellEditable(i,"inp_msg3",0);
						} else {                 
							sheetObj.SetRowBackColor(i,"#NANNANNAN");
							//실패한건은 선택할수 없다. 
							sheetObj.SetCellEditable(i,"checkbox",0);
						}                          
					}         
					verifyCheck=true;
					//verifyCheck에 사용된 eqtype을 저장한다. 
					retComboVal=comboValue;         
                break;      
			case IBINSERT:  // ROWADD                   
					var Row=sheetObj.DataInsert(-1);
					sheetObj.SetCellValue(Row,"inp_msg3",ComGetNowInfo("ymd"),0);
					sheetObj.SetCellEditable(Row,"checkbox",0);
					verifyCheck=false;                       
	      		break; 
			case IBDELETE:  // ROWDELETE   
					for(var i=sheetObj.RowCount(); i > 0; i--){
						if(sheetObj.GetCellValue(i,"del_check") == 1){
							sheetObj.RowDelete(i, false);
						}     	
					}           
				break;
			case IBCLEAR: //  콤보 데이터 조회 및 모든 쉬트를 초기화 
					MnrWaitControl(true);
					sheetObj.SetWaitImageVisible(0);
					//콤보데이타 초기화  
					for(var i=0; i < comboObjects.length;i++){ 
						comboObjects[i].RemoveAll();
					}     
					//combo1 세팅  EQ_TYPE     
					var sCondition=new Array (
							new Array("MnrGenCd","SELHO","CUSTOM9")		//Eq Kind
						); 
					var retArray=MnrComSearchCombo(sheetObj,sCondition); 
					for(var j=0; j < retArray[0].length;j++){   
						var tempText=retArray[0][j].split("|");  
						comboObjects[0].InsertItem(j, tempText[1] ,tempText[0]);
						//넘어온 값을 세팅한다.      
						if(formObj.eq_type.value != "" && formObj.eq_type.value == tempText[0].trim()){ 
							comboObjects[0].SetSelectCode(tempText[0]);
						}  		      
					} 
					//쉬트 초기화
					sheetObj.RemoveAll();
					verifyCheck=false;  
					sheetObj.SetWaitImageVisible(1);
                  	MnrWaitControl(false);  
	      	   	break; 	
        } 
    }  
	/**
     * 추가로 넘겨야 될값이 많아서 따로 구현한다.
     */
	function comPopupOK_0122(sheetObj,formObject) {
		var formObject=document.form; 
		var rArray=new Array(); //행데이터를 담고 있는 배열
		var ret_val=new Array(); 
		ret_val[0]=retComboVal;    
	    var sRow=sheetObj.FindCheckedRow("checkbox");
	    //가져온 행을 배열로 반든다.          
	    var arrRow=sRow.split("|");   
	    for (idx=0; idx < arrRow.length - 1; idx++){     
			var cArray=new Array(); //열데이터를 담고 있는 배열
			cArray[0]=sheetObj.GetCellValue(arrRow[idx], "inp_msg44");
			cArray[1]=sheetObj.GetCellValue(arrRow[idx], "inp_msg1");
			cArray[2]=sheetObj.GetCellValue(arrRow[idx], "inp_msg18");
			cArray[3]=sheetObj.GetCellValue(arrRow[idx], "inp_msg7");
			cArray[4]=sheetObj.GetCellValue(arrRow[idx], "inp_msg2");
			cArray[5]=sheetObj.GetCellValue(arrRow[idx], "inp_msg45");
			cArray[6]=sheetObj.GetCellValue(arrRow[idx], "inp_msg40");
			cArray[7]=sheetObj.GetCellValue(arrRow[idx], "inp_msg46");
			cArray[8]=sheetObj.GetCellValue(arrRow[idx], "inp_msg42");
			cArray[9]=sheetObj.GetCellValue(arrRow[idx], "inp_msg3");
			cArray[10]=sheetObj.GetCellValue(arrRow[idx], "inp_msg47");
			cArray[11]=sheetObj.GetCellValue(arrRow[idx], "inp_msg34");
			cArray[12]=sheetObj.GetCellValue(arrRow[idx], "inp_msg8");
			cArray[13]=sheetObj.GetCellValue(arrRow[idx], "inp_msg47");
			cArray[14]=sheetObj.GetCellValue(arrRow[idx], "inp_msg9");
			rArray[idx]=cArray; 
		}   
		opener.getEES_MNR_S232(rArray);  //호출하는 부모js에 getMnr_Multi 붙여넣으면됩니다.
		ComClosePopup(); 
	}   
    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
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
        var objs=document.all.item("tabLayer"); 
    	objs[nItem].style.display="Inline";
    	objs[beforetab].style.display="none";
    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab=nItem; 
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
	function combo1_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){ 
		comboValue=comboObj.GetSelectCode();
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
if(sheetObj.GetCellValue(Row,Col) != 1){
				sheetObj.SetRowBackColor(Row,"#NANNANNAN");
			} else {                            
				sheetObj.SetRowBackColor(Row,"#NANNANNAN");
				sheetObj.SetCellValue(Row,"inp_msg5","",0);
				sheetObj.SetCellEditable(Row,"checkbox",0);
				sheetObj.SetCellEditable(Row,"inp_msg1",1);
				sheetObj.SetCellEditable(Row,"inp_msg2",1);
				sheetObj.SetCellEditable(Row,"inp_msg3",1);
				verifyCheck=false;        
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
	
	function sheet1_OnLoadExcel(sheetObj, result, code, msg){
		if(isExceedMaxRow(msg))return;
		
		for(var i=1; i <= sheetObj.RowCount(); i++){
			sheetObj.SetRowStatus(i,"R");
			sheetObj.SetCellEditable(i,"checkbox",0);
		} 
	}
	/* 개발자 작업  끝 */
