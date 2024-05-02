/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0004.jsp
*@FileTitle  : EQ Damage Type
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/13
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
						OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends Mnr
     * @class EES_MNR_0004 : business script for EES_MNR_0004.
     */
   	/* developer job	*/    
	// common global variables 
	var sheetObjects=new Array();
	var sheetCnt=0;  
	var comboObjects=new Array();
	var comboCnt=0;   
	//saving combo value.          
	var comboValue="";              
	// Office level of login user : HO level -> L1, RHQ level ->  L2, Office level -> L3 (CoMnr.js reference at MnrOfficeLevel)
	var strMnrOfficeLevel="";
	// Event handler processing by button click event */	
	document.onclick=processButtonClick;
	/** 
	 * Event handler processing by button name
	 */ 
    function processButtonClick(){ 
         var sheetObject=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form; 
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
				switch(srcName) {
						case "btn_Retrieve": 
								doActionIBSheet(sheetObject, formObject, IBSEARCH)
								break; 
						case "btn_New":    
								doActionIBSheet(sheetObject, formObject, IBCLEAR)
								setSaveBtnDisplay();
								break;
						case "btn_Save":  
								doActionIBSheet(sheetObject, formObject, IBSAVE)
								break; 
						case "btn_RowAdd":  
								doActionIBSheet(sheetObject, formObject, IBINSERT)
								break;    
						case "btn_RowDel":      
								doActionIBSheet(sheetObject, formObject, IBDELETE)
								break;      
						case "btn_Excel1":
							if(sheetObject.RowCount() < 1){//no data
								ComShowCodeMessage("COM132501");
							}else{
								sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(  sheetObject), SheetDesign:1,Merge:1 });
							}
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
     * registering IBSheet Object as list 
     * @param	{IBSheet}	sheet_obj	adding sheet.
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source 
     */ 
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
	/** 
	 * registering IBCombo Object as list
	 * @param	{IBMultiCombo}	combo_obj	adding ComboObject. 
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */ 
	function setComboObject(combo_obj){    
    	comboObjects[comboCnt++]=combo_obj;  
	}      
    /** 
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() { 
    	MnrOfficeLevel(currOfcCd, rhqOfcCd);
		MnrWaitControl(true);  
		initControl(); 	
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }  
		//initializing IBMultiCombo 
	    for(var k=0;k<comboObjects.length;k++){ 
	        initCombo(comboObjects[k],k + 1);  
	    }	 
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
        setSaveBtnDisplay();
    }
	/**   
	 * setting combo basic info    
	 * @param	{IBMultiCombo}	combo_obj	ComboObject. 
	 * @param	{Number}	comboNo		ComboObject tag serial number 
	 * adding case as numbers of counting combos 
	 */     
	function initCombo (comboObj, comboNo) {   
	    //var cnt  = 0 ; 
	    var formObject=document.form
	    switch(comboNo) {    
	          case 1: 
	           with (comboObj) { 	
		      	   SetTitle("Code|Desc");	 
					SetColAlign(0, "left");
					SetColAlign(1, "left");
				   SetDropHeight(160);
		    }      
	           break;    
	     } 
	} 
   /**   
     * setting sheet initial values and header 
     * @param	{IBSheet}	sheetObj	sheetObject. 
	 * @param	{Number}	sheetNo		sheetObject tag serial number 
     * adding case as numbers of counting sheets
     */  
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
				var sheetID=sheetObj.id;
        switch(sheetID) { 
            case "sheet1":
                with(sheetObj){
		             var HeadTitle1="|D|S|Code|Num Code|Name|Description";
		             var headCount=ComCountHeadTitle(HeadTitle1);
		
		             SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		             InitHeaders(headers, info);
		
		             var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"DummyCheck", Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
		                 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"S" },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_cedex_otr_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_cedex_otr_num_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
		                 {Type:"Text",      Hidden:0,  Width:230,  Align:"Left",    ColMerge:1,   SaveName:"eq_cedex_otr_cd_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"eq_cedex_otr_cd_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
		                 {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"eq_cedex_otr_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		              
		             InitColumns(cols);
		
		             SetEditable(1);
		             
		             SetColProperty(0 ,"eq_cedex_otr_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
		             SetColProperty(0 ,"eq_cedex_otr_num_cd" , {AcceptKeys:"[0123456789]", InputCaseSensitive:1});
		             SetColProperty(0 ,"eq_cedex_otr_cd_nm", {AcceptKeys:"E|N|[.-/,() &]"});
		             SetColProperty(0 ,"eq_cedex_otr_cd_desc", {AcceptKeys:"E|N|[.-/,() &]"});
		             //conversion of function[check again]CLT 					InitDataValid(0,  "eq_cedex_otr_cd", vtEngUpOther,"0123456789");
		             //conversion of function[check again]CLT 					InitDataValid(0,  "eq_cedex_otr_num_cd", vtNumericOnly);
		             SetSelectionMode(smSelectionRow);

//		             SetSheetHeight(530);
		              resizeSheet( sheetObj );
	             }

  
     			break;   
        }   
    }
	function resizeSheet( sheetObj ){
	    ComResizeSheet( sheetObj );
	}
	/**
	 * handling process sheet
	 * @param {IBSheet} sheetObj handling sheetObject 
	 * @param {Form}  formObj  handling formObject
	 * @param {Number} sAction  Action constants  
	 */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {           
		    case IBSEARCH:    //retrieving 
		    		//initializing sheet
	            	sheetObj.RemoveAll();
		    		if (validateForm(sheetObj,formObj,sAction)) {   
	          			formObj.f_cmd.value=SEARCH;             
	          			formObj.eq_cedex_otr_tp_cd.value=comboValue; 
	          			sheetObj.DoSearch("EES_MNR_0004GS.do", FormQueryString(formObj) );
					}    	    
	          	break;       
			case IBSAVE:  //saving          
					if (validateForm(sheetObj,formObj,sAction)) {  
						formObj.f_cmd.value=MULTI;                                                            
						sheetObj.DoSave("EES_MNR_0004GS.do", FormQueryString(formObj),-1,false);
					}        	       
	      		break;    	   
			case IBINSERT:  // ROWADD   
		   	   		var Row=sheetObj.DataInsert(-1);
					sheetObj.SetCellValue(Row, "eq_cedex_otr_tp_cd",comboValue,0);
	      		break;           
            case IBDELETE:  // deletion      
            		if(sheetObj.FindCheckedRow("del_chk") != ""){
						ComRowHideDelete(sheetObj,"del_chk"); 
					} else {                        
						ComShowCodeMessage("MNR00150");	     	   
					}        
	      		break;      
          	case IBCLEAR: //  retrieving Combo Data and initializing sheet 
          		   MnrWaitControl(true);
                   sheetObj.SetWaitImageVisible(0);
					//initializing Combo Data
					for(var i=0; i < comboObjects.length;i++){ 
						comboObjects[i].RemoveAll();
					}    
					// retrieving combo
					var sCondition=new Array ( 
					 	new Array("MnrGenCd","CD00001", "COMMON")    
					)         
					// setting values on combo data    
					var comboList=MnrComSearchCombo(sheetObj,sCondition); 
					for(var i=0; i < comboList.length;i++){ 
						comboObjects[i].RemoveAll();
					 	if(comboList[i] != null){  
					 		for(var j=0; j < comboList[i].length;j++){ 
								comboObjects[i].InsertItem(j, comboList[i][j] ,j + '');
							}      
						}                     
					 	comboObjects[i].SetSelectCode(0);
					 }  
					//initializing sheet
					sheetObj.RemoveAll();
					//initializing input text    
					formObj.eq_cedex_otr_cd_dummy.value='';  
					sheetObj.SetWaitImageVisible(1);
                    MnrWaitControl(false); 
	      	   	break;           
        }             
    }   
	/**  
     * handling process for input validation
     * @param	{IBSheet}	sheetObj	checking sheetObject 
     * @param	{Form}		formObj		checking comboObject
     * @param	{Number}	sAction		Action constants  
     */     
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){  
			if(sAction==IBSAVE) {    
				//duplicate checking When saving    
				if(sheetObj.IsDataModified()){
						var Row=sheetObj.ColValueDup("eq_cedex_otr_cd|eq_cedex_otr_tp_cd");
						if(Row > 0){               
							ComShowCodeMessage("MNR00006",i + 1 + "th sheet of " + Row + " row ");
							sheetObj.SetCellValue(Row, "eq_cedex_otr_cd","",0);
							sheetObj.SelectCell(Row, "eq_cedex_otr_cd", true);
							return false;              
						}    			
				}
			} else if(sAction==IBSEARCH) {  
				//retrieving in case of not existing retrieving code
				if(eq_cedex_otr_cd_dummy.value == '' || eq_cedex_otr_cd_dummy.value  == null){
					eq_cedex_otr_cd.value='All';    
				} else {
					eq_cedex_otr_cd.value=eq_cedex_otr_cd_dummy.value;	
				}      
			}
        }    
        return true; 
    } 
	/* ********* User Functions ************* */	
	//showing message after saving  
	function sheet1_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") {        
			ComShowCodeMessage("MNR00023",'');   
		} else {    
			ComShowCodeMessage("MNR00008",ErrMsg);  
		}         
	}    
	function initControl() {  
	    //Axon handling event1. event catch 
//	    axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); 			  
//	    axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form);            
	    axon_event.addListenerFormat('keypress',         'obj_keypress', 	form);            
	}           
	//Axon handling event2. handling event  
	function obj_deactivate(){     
	    ComChkObjValid(event.srcElement);
	}
	function obj_activate(){  
	    ComClearSeparator(event.srcElement);
	}  
	function obj_keypress(){ 
	    obj=event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus=obj.dataformat;
	    switch(obj.dataformat) {
	        case "engup":
	          	ComKeyOnlyAlphabet('uppernum');          
	            break;   
	    }   
	}      
	/**  
	 * combo1 Change event      
	 * @param	{IBMultiCombo}		comboObj	comboObject  
	 * @param 	{Number} 			Index_Code 	selected row 
	 * @param 	{String} 			Text 		selected Text  
	 */  
	//function combo1_OnChange(comboObj,Index_Code, Text){   
	function combo1_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){
		comboValue=NewText;//comboObj.GetText(Index_Code,0);          
	}        
	/**
	 * setting  save button
	 * display in case of users office level is equal to L1 
	 *  
	 * @return
	 */
	function setSaveBtnDisplay() {
		if(strMnrOfficeLevel=="L1") {
			ComBtnEnable("btn_Save");
		} else {
			ComBtnDisable("btn_Save");
		}
	}
	/* developer job */
