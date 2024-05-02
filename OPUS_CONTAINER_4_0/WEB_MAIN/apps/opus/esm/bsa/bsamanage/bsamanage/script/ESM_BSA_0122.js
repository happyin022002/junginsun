/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BSA_0122.js
*@FileTitle  : Other Carrier's Slot Swap Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/04
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------Following code is added code to make JSDoc ------------------*/
  

    /**
     * @extends 
     * @class ESM_BSA_0122 : business script for ESM_BSA_0122
     */
    function ESM_BSA_0122() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	
 

    var sheetObjects = new Array();
    var sheetCnt = 0;

	/* Event handler processing by button click event */
	document.onclick = processButtonClick;

	/* Event handler processing by button name */
	function processButtonClick(){
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			if(ComGetBtnDisable(srcName)) return false;
			
			switch(srcName) {
				case "btn_save":
				    doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;
					
    			case "btng_rowadd":
    				doActionIBSheet(sheetObject,formObject,IBINSERT);
    				break;
				
				case "btn_close":
//					self.close();
		    		ComClosePopup(); 
					break;
			
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(ComGetMsg("COM12111","",""));
			} else {
				ComShowMessage(e);
			}
		}
	}

   /**
	* registering IBSheet Object as list
	* adding process for list in case of needing batch processing with other items
	* defining list on the top of source
	*/
	function setSheetObject(sheet_obj){
	
		sheetObjects[sheetCnt++] = sheet_obj;
	
	}

   /**
	* initializing sheet
	* implementing onLoad event handler in body tag
	* adding first-served functions after loading screen.
	*/
	function loadPage(crrCombo) {
	
		for(i=0;i<sheetObjects.length;i++){
		
			
			ComConfigSheet(sheetObjects[i]);
			
			initSheet(sheetObjects[i],i+1, crrCombo);
			
			
			ComEndConfigSheet(sheetObjects[i]);
 
			
	    }
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
//		sheetObjects[1].LoadSearchXml(document.form.sXml.value);
//		sheetObjects[1].Visible = false;
	}

   /**
	* setting sheet initial values and header
	* param : sheetObj, sheetNo
	* adding case as numbers of counting sheets
	*/
	function initSheet(sheetObj,sheetNo, crrCombo) {
	
		var cnt = 0;
	
		switch(sheetNo) {
			case 1:      //sheet1 init
			    with(sheetObj){
				
				      var HeadTitle="STS|From|Sub BSA|To";

				      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:0 } );

				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);

				      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"Combo",     Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"bsa_fm_crr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Float",     Hidden:0,  Width:150,  Align:"Right",   ColMerge:1,   SaveName:"crr_swap_capa",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Combo",     Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"bsa_to_crr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				       
				      InitColumns(cols);
				      SetColProperty("bsa_fm_crr_cd", {ComboText:crrCombo, ComboCode:crrCombo} );
				      SetColProperty("bsa_to_crr_cd", {ComboText:crrCombo, ComboCode:crrCombo} );

				      SetEditable(1);//Editkind[option,Defaultfalse]
				      SetCountPosition(0);
				      SetSheetHeight(150);
				                        //no support[check again]CLT 					style.height=GetSheetHeight(11) ;
				      
				      SetEditArrowBehavior(3); 

				}
				break;
		
//			case 2:      //sheet1 init
//				with (sheetObj) {
//					SheetWidth = mainTable.clientWidth; 	 	 	 //setting width
//					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //setting Host information[mandatory][HostIp, Port, PagePath]
//					MergeSheet = msNone;									//Merge kind [option, Default msNone]
//					Editable = false;										//Edit kind [option, Default false]
//					InitRowInfo( 1, 1, 9, 100);								//setting Row information[HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
//					InitColumnInfo(9, 0 , 0, true);							//setting Column information[COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
//					InitHeadMode(true, true, false, true, false,false);		// setting various option using in header
//					var HeadTitle = "STS|bsa_seq|trd_cd|rlane_cd|dir_cd|vop_cd|vsl_capa|bsa_fm_dt|bsa_to_dt";
//					InitHeadRow(0, HeadTitle, false);						//setting Header row information[ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
//					
//					//Data properties[ROW,COL,DATATYPE,WIDTH,DATAALIGN,COLMERGE,SAVENAME,KEYFIELD,CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//					InitDataProperty(0,		cnt++,	dtStatus,	40,		daCenter,	true,	"ibflag");
//					InitDataProperty(0,		cnt++,	dtData,		80,	    daCenter,	true,	"bsa_seq",	false,	"",	dfNone,     0,	true,	true);
//					InitDataProperty(0,		cnt++,	dtData,		80,	    daCenter,	true,	"trd_cd",	false,	"",	dfNone,     0,	true,	true);
//					InitDataProperty(0,		cnt++,	dtData,		80,	    daCenter,	true,	"rlane_cd",	false,	"",	dfNone,  	0,	true,	true);
//					InitDataProperty(0,		cnt++,	dtData,		80,	    daCenter,	true,	"dir_cd",	false,	"",	dfNone,	    0,	true,	true);
//					InitDataProperty(0,		cnt++,	dtData,		80,	    daCenter,	true,	"vop_cd",	false,	"",	dfNone,	    0,	true,	true);
//					InitDataProperty(0,		cnt++,	dtData,		80,	    daCenter,	true,	"vsl_capa",	false,	"",	dfNone,	    0,	true,	true);
//					InitDataProperty(0,		cnt++,	dtData,		80,	    daCenter,	true,	"bsa_fm_dt",false,	"",	dfNone,	    0,	true,	true);
//					InitDataProperty(0,		cnt++,	dtData,		80,	    daCenter,	true,	"bsa_to_dt",false,	"",	dfNone,	    0,	true,	true);
//					
//					CountPosition  = 0 ;
//					style.height = GetSheetHeight(0) ;
//
//				}
//				break;
		
		}
	}

	// handling the process realated with sheet
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
//		var sheetObj2 = sheetObjects[1];
	
		switch(sAction) {
			case IBSEARCH:      //Retrieve
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				formObj.f_cmd.value = SEARCHLIST02;
				sheetObj.DoSearch("ESM_BSA_0122GS.do", bsaFormString(formObj,getParam('ESM_BSA_0122')));
				break;
 
			case IBSAVE:        //save
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				if(sheetObj.RowCount()>0){
    				formObj.f_cmd.value = MULTI02;
    				sheetObj.DoSave("ESM_BSA_0122GS.do", bsaFormString(formObj,getParam('ESM_BSA_0122','S')), -1, false);
    				break;
				}else{
				    ComShowMessage(sheetObj.MessageText("UserMsg13"));
				    return false;
				}
				
//				2015.06.06 김용습 - 저장 완료 메시지 추가
				ComShowCodeMessage("BSA10047");
				
				break;
				
			case IBINSERT:        //save
				sheetObj.DataInsert();
				break;
		     
		}
	}


   /**
	* handling process for input validation
	*/
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
		}
	
		return true;
	}

	