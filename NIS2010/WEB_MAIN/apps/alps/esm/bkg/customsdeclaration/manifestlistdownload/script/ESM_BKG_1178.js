/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0013.js
 *@FileTitle : Customer Code Entry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.16
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.04.16 김민정
 * 1.0 Creation
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/**
 * 화면에서 사용하는 업무 스크립트를 정의한다.
 */
    function esm_bkg_1178() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
	this.sheet1_OnClick = sheet1_OnClick;
	this.sheet1_OnKeyUp = sheet1_OnKeyUp;


}


   	/* developer's work*/
     /**
      * registering IBSheet Object as list 
      * adding process for list in case of needing batch processing with other items
      * defining list on the top of source
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
     }
     
     
 // global variable
 var sheetObjects = new Array();
 var sheetCnt = 0;
 
 var prefix = "";//IBSheet divider
 

 /*********************** EDTITABLE MULIT COMBO START ********************/
	var comboCnt = 0;
 	var comboObjects = new Array();
 /*********************** EDTITABLE MULIT COMBO END ********************/
 	
     /**
      * initializing sheet
      * implementing onLoad event handler in body tag
      * adding first-served functions after loading screen.
      */
//     function loadPage() {
//         for(i=0;i<sheetObjects.length;i++){
//		 			ComConfigSheet (sheetObjects[i] );
//		 			initSheet(sheetObjects[i],i+1);
//		 			ComEndConfigSheet(sheetObjects[i]);
//		    }	
//		    initControl();
//		 	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
//
//		 		
//     }
//     
     function loadPage() {
    	 var formObject = document.form;
    	 
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );

             initSheet(sheetObjects[i],i+1);      
             ComEndConfigSheet(sheetObjects[i]);
          
         }
         initControl();
//         doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
     }
	
    
    function initControl() {
    	var formObject = document.form;

        axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- keyboard
       // axon_event.addListenerForm  ('blur', 'bkg_blur',  formObject); //- out of focus     
      //  axon_event.addListenerFormat('focus', 'bkg_focus',    formObject); //- focus in
     	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
        axon_event.addListenerForm ('change', 'bkg_change', formObject);
    }        

    

/*********************** KEY EVENT END ********************/

// Event handler processing by button click event */
 		document.onclick = processButtonClick;

 // Event handler processing by button name */
     function processButtonClick(){
          /***** using extra sheet valuable if there are more 2 sheets *****/
          var sheetObject1 = sheetObjects[0];
					
					var comboObject1 = comboObjects[0]; 
          /*******************************************************/
          var formObject = document.form;

	     	//try {
	     		
	     		var srcName = window.event.srcElement.getAttribute("name");
	     		
		 			switch(srcName) {
		 				case "btn_Retrieve":
		 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
		 					break;	
		 					
		 				case "btn_Delete":
		 					
		 					doActionIBSheet(sheetObject1,formObject,IBDELETE);
		 					break;	
		 						
		 				case "btn_Close":
							if(opener != undefined ){
							}		 				
		 					self.close();
		 					break;
		 							 		
	     	
    }
     }
 
   // handling of Sheet 
     function doActionIBSheet(sheetObj,formObj,sAction,row) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

 			case IBSEARCH:      
 				
	 				if(!validateForm(sheetObj,formObj,sAction)) return;
	 				formObj.f_cmd.value = SEARCH;
					var sXml = sheetObj.DoSearch("ESM_BKG_1178GS.do", FormQueryString(formObj));
					
	

					
				
					if(sheetObj.RowCount>0){		
						ComBtnEnable("btn_Delete");
					}else{
						ComBtnDisable("btn_Delete");
					}					
				for(var i=0; i<sheetObj.RowCount; i++){
						if(sheetObj.CellValue(i, "download_flag") == "Y"){ // 조회조건 BDR = "NO"							
								ComBtnDisable("btn_Delete");
							break;
						}	
					}
				
					break;
					
 			case IBDELETE:        

 				if(!validateForm(sheetObj,formObj,sAction))	return;		
 				 if(!ComShowConfirm(ComGetMsg("COM12194"))) return false;
 				formObj.f_cmd.value = MULTI;

 				var sParam = sheetObj.GetSaveString();
			//	if (!sheetObj.IsDataModified && sParam == "")	return;
				sParam += "&" + FormQueryString(formObj);
				var sXml = sheetObj.GetSaveXml("ESM_BKG_1178GS.do" , sParam);
				sheetObj.LoadSaveXml(sXml);
				//window.returnValue = true;
				
				
				//doActionIBSheet(sheetObj,formObj,IBSEARCH);
				
         }
         
      }
     
     
     /**
      * 저장 후 재 조회
      */
     function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
     	if(ErrMsg.indexOf("<||>") < 0) {
     		sheetObj.RemoveAll();
     		ComBtnDisable("btn_Delete");
     	}
     }
     

   
 /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt = 0;
         switch(sheetObj.id) {

            case "sheet1":
              with (sheetObj) {
                 //setting height
                 style.height = 320;
                 
                 //setting width
                 SheetWidth = mainTable.clientWidth;

                 //setting Host information[mandatory][HostIp, Port, PagePath]
                 if (location.hostname != "")
                	 InitHostInfo(location.hostname, location.port, page_path);
                 //Merge kind  [Option, Default msNone]
                 MergeSheet = msHeaderOnly;

                //Edit kind [Option, Default false]
                 Editable = true;

				//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 15, 100);

		        var HeadTitle1 = "|Seq|VVD|CRN|Download Flag";
			
                var headCount = ComCountHeadTitle(HeadTitle1);

                //setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // Setting each function which can be handled in header
                //([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
                InitHeadMode(true, true, true, true, false,false)

                //Header information [mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
              //  InitHeadRow(1, HeadTitle2, true);
                
                
                //Data  attribute    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
               // InitDataProperty(0, cnt++, 		dtDummyCheck, 		20, 		daCenter, 		true, 		"DelChk");
                InitDataProperty(0, cnt++ , 	dtHiddenStatus,		30,		  	daCenter,		true,		"ibflag");               
				InitDataProperty(0, cnt++, 		dtSeq, 				30,			daCenter, 		false, 		"seq"); 
				InitDataProperty(0, cnt++ , 	dtData,				150,			daCenter,		true,	 	"vvd",		false,			"",      dfNone,			0,		false,	false);
				InitDataProperty(0, cnt++ , 	dtData,				150,			daCenter,		true,   	"cvy_ref_no",		false,			"",      dfEngUpKey,			0,		false,	false);
				InitDataProperty(0, cnt++ , 	dtData,			30,			daCenter,		true,	 	"download_flag",	false,			"",      dfNone,			0,		false,	false);

				
//				InitDataCombo(0, 5, "중국|일본|동남아", "C|J|D"); 
//				InitDataValid(0, "slan_cd", vtEngUpOther, "1234567890");

 				CountPosition = 0;//[1/3] 
			}
	
		break;
         }
     }
    
 	 
 	 /**
      * handling process for input validation
      */
      function validateForm(sheetObj,formObj,sAction){
    	  switch(sAction) {
       	
    	  
    	  
       		case IBSEARCH: // 화면 로우 추가시
       			
				//기본포멧체크
				if (!ComChkValid(formObj)) return false;
	
    	  break;	
    	  	}
    	  		return true;
      
          
      }
 	 
      


