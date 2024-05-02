/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_MNR_S122.js
*@FileTitle  : SPP Damage Flagging/Unflagging
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
// 공통전역변수
var tabObjects=new Array();
var tabCnt=0 ; 
var beforetab=1; 
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array(); 
var comboCnt=0;   
//TS타입일 경우 타입사이즈 배열  eq_type 별 3가지 모두 틀림 
var uTpSz=new Array();    
var gTpSz=new Array();  
var zTpSz=new Array();    
var err1 = "";
var err2 = "";
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
                case "btn_retrive":     
                    doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    break; 
		        case "btn_new": 
                    doActionIBSheet(sheetObject,formObject,IBCLEAR); 
                    break;
		        case "btn_save":      
                    doActionIBSheet(sheetObject,formObject,IBSAVE); 
                    break;    
		        case "btn_downExcel":
					if(sheetObject.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
					}
 					
                    break; 
		        case "btn_loadExcel":  
					  allSheetClr();  
					  ComOpenPopup('/opuscntr/EES_MNR_0139.do?eq_type=' + eq_knd_cd.GetSelectCode(), 798, 511, 'getEES_MNR_0139', '1,0,1,1,1,1,1,1,1,1,1,1', true);
                    break;                  
		        case "btns_calendar":        
                    var cal=new ComCalendar();     
                    cal.setDiffDomain(true);
	                cal.select(formObject.mnr_dmg_flg_dt, 'yyyy-MM-dd');
	                break;  
				//멀티입력
				case "eq_no_multi": 
				    rep_Multiful_inquiry("eq_list"); 
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
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
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
		// IBMultiCombo초기화 
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k + 1); 
	    }
		for(var k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k + 1);
        }    
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
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
	 * Combo 기본 설정    
	 * @param	{IBMultiCombo}	combo_obj	콤보오브젝트. 
	 * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호 
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */     
	function initCombo (comboObj, comboNo) {   
	    //var cnt  = 0 ; 
	    var formObject=document.form;        
	    switch(comboNo) {    
	          case 1: 		
			  case 2:	 	
	           with (comboObj) { 
				SetColAlign(0, "left");
				   SetDropHeight(160);
		       }      	
	           break; 
			   case 3:	 
			   with (comboObj) {
					SetMultiSelect(1);
					SetUseAutoComplete(1);
					SetColAlign(0, "left");
					SetColWidth(0, "230");
					SetDropHeight(200);
			   }    
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
					  var HeadTitle="|Seq.|FLAG|EQ TYPE|EQ No.|TP/SZ|Yard|Flag Date|Over Days|Remark(s)";
					  SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
					  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					  var headers = [ { Text:HeadTitle, Align:"Center"} ];
					  InitHeaders(headers, info);
					  var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
							 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq",                      KeyField:0,   CalcLogic:"",   Format:"" },
							 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"mnr_dmg_flg",              KeyField:0,   CalcLogic:"",   Format:"" },
							 {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"eq_knd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eq_no",                    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"mnr_dmg_flg_yd_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
							 {Type:"PopupEdit", Hidden:0, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"mnr_dmg_flg_dt",           KeyField:1,   CalcLogic:"",   Format:"YmdHm",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							 {Type:"Int",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"mnr_dmg_flg_dt_over_day",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"mnr_sts_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 } ];
					   
					  
					  InitColumns(cols);
					  SetColProperty(0 ,"mnr_dmg_flg_yd_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
					  SetEditable(1);
					  SetSheetHeight(420);
					  SetShowButtonImage(2);
					  SetSelectionMode(smSelectionRow);
					}
					 break;  
				}
    }
  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
           case IBSEARCH:      //조회   
                 if(validateForm(sheetObj,formObj,sAction)){  
				 	if(sheetObj.id =="sheet1"){       
						formObj.f_cmd.value=SEARCH;        
         				//2012.11.14 조경완 [CHM-201221414-01] server단 validation logic 추가
          				var sXml=sheetObj.GetSearchData("EES_MNR_S122GS.do", FormQueryString(formObj));
         				var validFlg=ComGetEtcData(sXml, "validFlg");
         				if(validFlg == "N"){
         					ComShowCodeMessage("MNR00223");
         				}else{
         					sheetObj.LoadSearchData(sXml,{Sync:1} );
         				}
					}         
				  }        
                break; 	
			 case IBSAVE:        //저장   
	              if(validateForm(sheetObj,formObj,sAction)){ 
				  	formObj.f_cmd.value=MULTI;                                                                   
//					sheetObj.DoSave("EES_MNR_S122GS.do", FormQueryString(formObj),-1,false);
				  	var sParam = sheetObj.GetSaveString(false);
					sParam=ComSetPrifix(sParam,"sheet1_");
					var sXml = sheetObj.GetSaveData("EES_MNR_S122GS.do", FormQueryString(formObj)+"&"+sParam);
					err1 =  ComGetEtcData(sXml,"error1");
					err2 =  ComGetEtcData(sXml,"error2");
//					sheetObj.LoadSaveData(sXml);
					if (ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S") {
						if(err1 == "" && err2 == ""){
							ComShowCodeMessage("MNR00023",'');
						}else{
							if(err1 != ""){
								ComShowMessage(err1);
							}
							if(err2 != ""){
								ComShowMessage(err2);
							}
						}
					}else {    
						showErrorMsg(sXml);  
					}   
				  	
				  }    
                break;
			case IBCLEAR: //  콤보 데이터 조회 및 모든 쉬트를 초기화
                    MnrWaitControl(true);
                    sheetObj.SetWaitImageVisible(0);
					formObj.reset(); 
					//초기값 세팅   
					formObj.mnr_flg_tp_cd.value=coMnrFlgDamageTypeCd;   
					//IBMultiCombo 콤보 초기화   
					for(var i=0; i < comboObjects.length;i++){ 
						comboObjects[i].SetSelectCode("-1");
						comboObjects[i].RemoveAll();
					}   	
					//쉬트 콤보를 설정하기 위한 변수 
					var sheetComboText="";  
					var sheetComboCode="";
					var sheetComboDefault="";  
					var sCondition=new Array ( 
					    new Array("MnrGenCd","","CUSTOM9"),
						new Array("MnrGenCd","CD00005", "COMMON") 
					)	         
					var comboList=MnrComSearchCombo(sheetObj,sCondition); 
					//IBMultiCombo-EQ_TYPE 세팅
					if(comboList[0] != null){
						for(var j=0; j < comboList[0].length;j++){ 
							var tempText=comboList[0][j].split("|");  
							sheetComboText +=  tempText[1] + "|";
							sheetComboCode +=  tempText[0] + "|";
							eq_knd_cd.InsertItem(j, tempText[1] ,tempText[0]);
							if(j == 0){      
								eq_knd_cd.SetSelectCode(tempText[0]);
								sheetComboDefault=tempText[0];       
							}   
						}  	
					}	
					//sheetObjects[0] eq_knd_cd 세팅
					sheetComboText=MnrDelLastDelim(sheetComboText);		
					sheetComboCode=MnrDelLastDelim(sheetComboCode);  			  
					sheetObj.InitDataCombo (0, "eq_knd_cd", sheetComboText, sheetComboCode,sheetComboDefault);     
	      	   		allSheetClr();  
					sheetObj.SetWaitImageVisible(1);
                    MnrWaitControl(false);       
				break; 	  
        }      
    }
	function allSheetClr(){   
		//쉬트 초기화        
		for(i=0; i < sheetObjects.length;i++){ 
			shtClear(sheetObjects[i]);      			
		}  
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
	function initControl() {  
	    //Axon 이벤트 처리1. 이벤트catch  
	    axon_event.addListenerForm  ('blur', 'obj_deactivate',  form); 			  //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	//    axon_event.addListenerFormat('focus',   'obj_activate',    form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	    //axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
	}              
	//Axon 이벤트 처리2. 이벤트처리함수   
	function obj_deactivate(){      
	    ComChkObjValid(ComGetEvent()); 
	} 
	function obj_activate(){   
	    ComClearSeparator(ComGetEvent());
	}       
//	function obj_keypress(){   
//	    obj=ComGetEvent();   
//	    if(obj.dataformat == null) return; 
//	    window.defaultStatus=obj.dataformat;
//	    switch(obj.dataformat) { 
//	        case "ymd":   
//	        case "int":    
//				ComKeyOnlyNumber(obj);
//	            break; 
//	        case "float":  
//	            ComKeyOnlyNumber(obj, "-.");
//	            break;
//	        case "eng":  
//	            ComKeyOnlyAlphabet();
//				break; 
//	        case "engup":  
//				if(obj.name == "mnr_dmg_flg_yd_cd")    
//					ComKeyOnlyAlphabet('uppernum');    
//				else 
//					ComKeyOnlyAlphabet('uppernum','44');
//	            break; 
//	    }         
//	}
	/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){   
			if(sAction==IBSEARCH) {      
				if (!ComChkValid(formObj)) return false;      
				if(ComIsEmpty(formObj.eq_list.value)){
		  	 		ComCodeMsgByEmptyData("eq_list");
		  	 		return false;
		  	 	}
			}else if(sAction==IBSAVE){ 
				//저장의사 확인
				if(!ComShowCodeConfirm("MNR00160","")){return false;} 
			}          	           
		}      
        return true; 
    }
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
//    function validateForm(sheetObj,formObj,sAction){
//        with(formObj){   
//			if(sAction==IBSEARCH) {	      
//				if (!ComChkValid(formObj)) return false;       
//			}else if(sAction==IBSAVE){ 
//				//저장의사 확인
//				if(!ComShowCodeConfirm("MNR00160","")){return false;} 
//			}      	           
//        }      
//        return true; 
//    }
    /**
	 * rep_Multiful_inquiry 사용시 받는부분  
	 * 소스에 붙여서 사용하세요          
	 * Location : 팝업에서 단일 선택을 한경우..     
	 */      
	function getMnr_Multi(rowArray,return_val) {
		var formObj=document.form;  
		var tempText=""; 	
		//초기화	   
		formObj.eq_list.value=''; 	
		for(var i=0; i<rowArray.length; i++) {   
			var colArray=rowArray[i];     
			tempText +=  rowArray[i] + ','; 	  
		}      
		//마지막에 ,를 없애기 위함     
		tempText=MnrDelLastDelim(tempText);	 
		tempText=tempText.toUpperCase(); 	            
		eval("document.form." + return_val + ".value='" + tempText + "';"); 
	}     
	/**
	 * COM_ENS_061 의 값을 받은 함수      
	 */
	function getCOM_ENS_061(aryPopupData, row, col, shhetIdx){
    	 var formObj=document.form; 
		 if(aryPopupData[0][3] != null && aryPopupData[0][3] != "")       
    	 	formObj.mnr_dmg_flg_yd_cd.value=aryPopupData[0][3];                                  
    }
	/**
	 * getEES_MNR_139 의 값을 받은 함수  
	 * @param Array[][]     aryPopupData		[0]EQNO   [1]YARD  [2]FLAGDATE 	  	
	 * @param Array[]       arrRetVal 	        [0]EQ_TYPE    [1]FLAG or UNFLAG
	 */
	function getEES_MNR_139(rArray,ret_val){ 
    	 var formObj=document.form;      
		 var firstSelect=0;    
		 eq_knd_cd.SetSelectCode(ret_val[0]);
    	 var mnr_dmg_flg="0";       
		 if(ret_val[1] == "Y"){
		 	mnr_dmg_flg="1";   	
		 } else {   
		 	mnr_dmg_flg="0";                   
		 }  
		 for(var i=0;i <  rArray.length;i++){    
		 	 var Row=sheetObjects[0].DataInsert(-1);
			 if(i == 0)  
			 	 firstSelect=Row;    
			 sheetObjects[0].SetCellValue(Row,"eq_knd_cd",eq_knd_cd.GetSelectCode(),0);
			 sheetObjects[0].SetCellValue(Row,"mnr_dmg_flg",mnr_dmg_flg,0);
			 sheetObjects[0].SetCellValue(Row,"eq_no",rArray[i][0],0);
			 sheetObjects[0].SetCellValue(Row,"mnr_dmg_flg_yd_cd",rArray[i][1],0);
			 sheetObjects[0].SetCellValue(Row,"mnr_dmg_flg_dt",rArray[i][2],0);
			 sheetObjects[0].SetCellValue(Row,"eq_tpsz_cd",rArray[i][3],0);
		 }           
    }    
	function sheet1_OnPopupClick(sheetObj, row,col){
        if (sheetObj.ColSaveName(col) != "mnr_dmg_flg_dt") return;
        var cal=new ComCalendarGrid();    
        cal.setDiffDomain(true);
        cal.select(sheetObj, row, col, 'yyyy-MM-dd HH:mm');  
    }   
	//저장후 결과메세지 표시  
	function sheet1_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") {
			if(err1 == "" && err2 == ""){
				ComShowCodeMessage("MNR00023",'');
			}else{
				if(err1 != ""){
					ComShowMessage(err1);
				}
				if(err2 != ""){
					ComShowMessage(err2);
				}
			}
			
		} else {
			ComShowCodeMessage("MNR00008",ErrMsg);
		}        
	}      
	//야드 벨리데이션 체크 
	function sheet1_OnChange(sheetObj,Row, Col, Value)	{
		var retArray=null;       
		if(sheetObj.ColSaveName(Col) == "mnr_dmg_flg_yd_cd"){
		var checkYard=sheetObj.GetCellValue(Row ,Col);
		    retArray=MnrGeneralCodeCheck(sheetObj,"YARD",checkYard);      
			if(retArray == null){         
				ComShowCodeMessage("MNR00165",checkYard,"YARD");       				
				sheetObj.SetCellValue(Row ,Col,"",0);
				sheetObj.SelectCell(Row ,Col);
			} else {  	  
				return;    
			}  	 
		} else if(sheetObj.ColSaveName(Col) == "mnr_dmg_flg"){
			sheetObj.SetCellValue(Row ,"mnr_dmg_flg_dt",ComGetNowInfo("ymd")+" "+ComGetNowInfo("hm"),0);
			var flgDt = sheetObj.GetCellValue(Row, "mnr_dmg_flg_dt").substring(0,4) + "-" + sheetObj.GetCellValue(Row, "mnr_dmg_flg_dt").substring(4,6) + "-" + sheetObj.GetCellValue(Row, "mnr_dmg_flg_dt").substring(6,8);
			var diff = sheet_dateDiff(flgDt, ComGetNowInfo("ymd")) + 1;
			sheetObj.SetCellValue(Row, "mnr_dmg_flg_dt_over_day", diff);
		}    	
	} 
	// 프리폼스타일의 타이틀및 디자인 설정
    function shtClear(sheetObj)
    {
           var shtID=sheetObj.id;
           switch(shtID) 
           {
		   			case "sheet1":
						with(sheetObj)
                        {
						 	RemoveAll();
						}	 
					break;
           }
			sheetObj.RenderSheet;
    }
    
    function sheet1_OnSearchEnd(sheetObj,ErrMsg){
    	for(var i = sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++){
			if(sheetObj.GetCellValue(i, "mnr_dmg_flg_dt") != ""){
				var flgDt = sheetObj.GetCellValue(i, "mnr_dmg_flg_dt").substring(0,4) + "-" + sheetObj.GetCellValue(i, "mnr_dmg_flg_dt").substring(4,6) + "-" + sheetObj.GetCellValue(i, "mnr_dmg_flg_dt").substring(6,8);
				var diff = sheet_dateDiff(flgDt, ComGetNowInfo("ymd")) + 1;
				sheetObj.SetCellValue(i, "mnr_dmg_flg_dt_over_day", diff);
				sheetObj.SetRowStatus(i, "R");
			}else{
				sheetObj.SetCellValue(i, "mnr_dmg_flg_dt_over_day", "");
				sheetObj.SetRowStatus(i, "R");
			}
		}
    }
	/* 개발자 작업  끝 */
