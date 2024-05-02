/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0224.js
*@FileTitle : Hanger Bar Inventory History Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
						OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ees_mnr_0224 : business script for ees_mnr_0224.
     */
// common global variables
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;    
var initLoader=0;
var regionalHQ="";
var nowLoad=0;
// Office level of login user : HO level -> L1, RHQ level -> L2, Office level -> L3 (MnrOfficeLevel reference at CoMnr.js)
var strMnrOfficeLevel="";
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
				case "btn_calendar": 
					var cal=new ComCalendarFromTo();       
 					cal.select(form.from_dt,  form.to_dt,  'yyyy-MM-dd'); 
					break;    		
				case "btn_Close":
					ComClosePopup(); 
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
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
		initControl()
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
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);		
    }
    /**   
	 * setting combo basic info    
	 * @param	{IBMultiCombo}	combo_obj	ComboObject. 
	 * @param	{Number}	comboNo		ComboObject tag serial number 
	 * adding case as numbers of counting combos 
	 */     
	function initCombo (comboObj, comboNo) {        
	    var formObject=document.form
	    switch(comboNo) {    
	        case 1: 
	           	with (comboObj) { 
				//MultiSeparator = "|";
				SetTitle("Office Code|Office Name");
				SetColAlign(0, "left");
				SetColAlign(1, "left");
				//SetColWidth("100|150");        
			   	SetDropHeight(160);
				SetUseAutoComplete(1);
		    	}      
	        	break; 
	     } 
	} 	  
  /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      // sheet1 init
                with(sheetObj){
	              var HeadTitle1="|Seq|Regional\nH/Q|Office|Bar Type|Inventory|Purchase Qty|Supply Qty|Collection Qty|Collection Qty|Missing Qty|Missing Qty|G.TTL|Remark(s)|Update\nDate";
	              var HeadTitle2="|Seq|Regional\nH/Q|Office|Bar Type|Inventory|Purchase Qty|Supply Qty|Sound         |Damage        |Missing    |Disposal   |G.TTL|Remark(s)|Update\nDate";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"},
	                          { Text:HeadTitle2, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ar_hd_qtr_ofc_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"mnr_hngr_bar_tp_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Int",       Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"rcvr_qty",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	                     {Type:"Int",       Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"pur_qty",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
	                     {Type:"Int",       Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"csm_qty",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
	                     {Type:"Int",       Hidden:0,  Width:105,  Align:"Right",   ColMerge:1,   SaveName:"act_invt_qty",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
	                     {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"mnr_hngr_dmg_qty",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
	                     {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"mnr_lost_hngr_qty",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
	                     {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"mnr_disp_hngr_qty",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
	                     {Type:"Int",       Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"invt_qty",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:1,   SaveName:"invt_rmk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4000 },
	                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"upd_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	               
	              InitColumns(cols);
	
	              SetEditable(0);
                    SetSelectionMode(smSelectionRow);

                    SetSheetHeight(300);
              }


         break;
        }
    }
	function initControl() {  
	    //Axon handling event1. event catch  
	    axon_event.addListenerForm  ('blur', 'obj_deactivate',  form); 			  
	  //  axon_event.addListenerFormat('focus',   'obj_activate',    form);            
	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);            
	}           
    /**
     * registering IBSheet Object as list
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
	 * HTML Control deactivate event <br>
	 **/
	function obj_deactivate(){    
		obj=event.srcElement;       
	    ComChkObjValid(event.srcElement); 
	} 
	/**
	 * HTML Control activate event <br>
	 **/
	function obj_activate(){   
	    ComClearSeparator(event.srcElement);
	}        
	/**
	 * HTML Control keypress event <br>
	 **/     
	function obj_keypress(){     
	    obj=event.srcElement;    
	    if(obj.dataformat == null) return; 
	    window.defaultStatus=obj.dataformat;
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
	        	ComKeyOnlyAlphabet('uppernum','45');   
	        break;	  
	    }
	} 	
   /**
    * handling process after ending sheet1 retrieve.
    * @param sheetObj
    * @param errMsg
    * @return
    */
     function sheet1_OnSearchEnd(sheetObj, errMsg) {
		if(sheetObjects[0].RowCount()>0){
	    	 for(i=sheetObjects[0].LastRow(); i > 1 ; i--){
	    		 sheetObj.SetCellValue(i,  "pieces",sheetObj.GetCellValue(i, "act_invt_qty") - sheetObj.GetCellValue(i, "invt_qty"),0);
	    	 }
		}	 
     }
  	/**
     * handling process sheet
     * @param	{IBSheet}	sheetObj	handling sheetObject 
     * @param	{Form}		formObj		handling formObject
     * @param	{Number}	sAction		Action constants  
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
            case IBSEARCH:      //retrieving
                if(validateForm(sheetObj,formObj,sAction)){
					if(sheetObj.id =="sheet1"){       
						formObj.f_cmd.value=SEARCH; 
						sheetObj.DoSearch("EES_MNR_0224GS.do",FormQueryString(formObj) );
					}  
				}	
                break;
			case IBCLEAR:        //initializing
				MnrWaitControl(true);
			    sheetObj.SetWaitImageVisible(0);
				if(initLoader == 0){
					//initializing combo
					for(var i=0; i < comboObjects.length;i++){ 
						comboObjects[i].RemoveAll();
					}   
					//retrieving common combo.  
					var sCondition=new Array (
						new Array("MnrGenCd","CD00022", "COMMON")  //Hanger Bar Type 
					);			                                       
					var comboList=MnrComSearchCombo(sheetObj,sCondition);   
					//setting combo
					for(var i=0; i < comboList.length;i++){
						if(comboList[i] != null){
							//initializing sheetCombo
							sheetComboText="";
							sheetComboCode="";
							for(var j=0; j < comboList[i].length;j++){ 
								var tempText=comboList[i][j].split("|");
								sheetComboText +=  tempText[1] + "|";
								sheetComboCode +=  tempText[0] + "|";
							}
							//Hanger Bar Type 
							if(i==0) {
								sheetObjects[0].SetColProperty(0,"mnr_hngr_bar_tp_cd", {ComboText:sheetComboText, ComboCode:sheetComboCode} );
							}						
						}
					}
					initLoader=1;	
				}
				//initializing sheet   
				for(i=0;i<sheetObjects.length;i++){   
					sheetObjects[i].RemoveAll();
		        }  
				form.from_dt.value=ComGetDateAdd(ComGetNowInfo("ymd"), "m", -3);
				form.to_dt.value=ComGetNowInfo();
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
        }
		return true;
	}
	/* developer job */
