/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0164.js
*@FileTitle  :  Disposal Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08 			
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
						OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /** 
     * @extends   
     * @class EES_MNR_0164 : business script for EES_MNR_0164.
     */
    function EES_MNR_0164() {
    	this.processButtonClick=processButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
/* developer job	*/ 	
// common global variables
//sheet  
var sheetObjects=new Array();
var sheetCnt=0;
//combo Object   
var comboObjects=new Array();
var comboCnt=0; 
//retrieve whether or not
var selCheck=false;
//combo default value 
var eqKnddefCode="";
//for message 
var actionType="";
//IBCLEAR
var isNowInit=false;  
var initLoader=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];		
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
				switch(srcName) {
					case "btn_Retrieve":   
						doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);  
					break;
					case "btn_New":     
						doActionIBSheet(sheetObjects[0],formObject,IBCLEAR);
					break;	 	
					case "btn_Detail":
						sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(),"ibflag","I",0);
						sParam=ComGetSaveString(sheetObjects[1])+"&chg_cd="+formObject.chg_cd.value;
						ComOpenPopup('/opuscntr/EES_MNR_0200.do?' + sParam, 1050, 550, 'getInvoiceDetail', "0,1,1,1,1,1", true);
						sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(),"ibflag","R",0);
					break;
					case "btn_DownExcel":
						if(sheetObjects[1].RowCount() < 1){//no data
							ComShowCodeMessage("COM132501");
							}else{
								sheetObjects[1].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[1]), SheetDesign:1,Merge:1 });
							}
					break;
					case "btn_period":
						var cal=new ComCalendarFromTo();  	       
						cal.select(formObject.in_apro_st_dt,  formObject.in_apro_end_dt,  'yyyy-MM-dd'); 
					break;  
			        case "btn_t1_req_multy":           
	                    rep_Multiful_inquiry("disp_no_list");   
						break;
			        case "btn_t2_req_multy":           
	                    rep_Multiful_inquiry("eq_no_list");   
						break;
			        case "btn_t3_req_multy":           
	                    rep_Multiful_inquiry("inv_no_list");   
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
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
		initControl();   
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		for(k=0;k < comboObjects.length;k++){ 
            initCombo(comboObjects[k],k + 1);   
        } 
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR); 		
    }
	/**   
	 * setting combo basic info    
	 * @param	{IBMultiCombo}	combo_obj	ComboObject. 
	 * @param	{Number}	comboNo		ComboObject tag serial number 
	 * adding case as numbers of counting combos 
	 */     
	function initCombo (comboObj, comboNo) {   
		switch(comboObj.options.id) {
        case "input_date_type_code":
            with(comboObj) {
                SetDropHeight(44);
            }
            break;
		}
	} 
	function resizeSheet( sheetObj ){
	    ComResizeSheet( sheetObj );
	}
  /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
        switch(sheetID) {
			case "sheet1": 
                with (sheetObj) {
                    //setting Host information[HostIp, Port, PagePath]
                    //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					SetVisible(false);
				}
            case "sheet2":
                with (sheetObj) {
	                var HeadTitle1="|Seq.|Disposal No.|Invoice No.|Request Office|Approval Office|EQ Type|Q'ty|Currency|T/AMT|Buyer Sel|Posting DT|Cre DT|Status"
	                var headCount=ComCountHeadTitle(HeadTitle1);
	                (headCount + 6, 5, 0, true);
	
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                       {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
	                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"disp_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"inv_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rqst_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"apro_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Combo",     Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"eq_knd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"disp_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"disp_st_prc",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"buyer_cnt",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"disp_bultn_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rqst_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Combo",     Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"disp_sts_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"disp_eml_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"apro_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"file_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"rqst_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"rqst_usr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"mnr_disp_rmk",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                 
	                InitColumns(cols);
	
	                SetEditable(1);
//	                SetSheetHeight(422);
	                resizeSheet( sheetObj );
			}				
			break;  	
        }
    }
	function initControl() {       
	    //Axon handling event1. event catch  
		var formObject=document.form;       
	    axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 			  
	  //  axon_event.addListenerFormat('focus',    'obj_activate',    formObject);                      
		axon_event.addListenerFormat('change',	 'obj_change',	formObject); 
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
	//Axon handling event2. handling event   
	function obj_deactivate(){      
	    ComChkObjValid(event.srcElement); 
	} 
	function obj_activate(){   
	    ComClearSeparator(event.srcElement);
	}        
	function obj_change(){ 	     
		var obj=event.srcElement; 
		var formObj=document.form; 
		var sheetObj=sheetObjects[0]; 
		if ( ComTrim(obj.value) != "" ) {
			switch(ComGetEvent("name")) {      
	    		case "disp_eml_flg_temp":     
				   	break;     
			}       
	    } 
	}    
	/********************************SHEET EVENT *******************************/
	function sheet2_OnDblClick(sheetObj,Row,Col) 
    {				
		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(),"ibflag","I",0);
		sParam=ComGetSaveString(sheetObjects[1])
		ComOpenPopup('/opuscntr/EES_MNR_0200.do?' + sParam, 1024, 510, 'getInvoiceDetail', "0,1,1,1,1,1", true);
    }  
 // handling process for sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
			case IBSEARCH:      //retrieving
				if(validateForm(sheetObj,formObj,sAction)){ 
					//retrieving header list 
					formObj.f_cmd.value=SEARCH;    
				    sParam=FormQueryString(formObj);  
				    var sXml=sheetObj.GetSaveData("EES_MNR_0164GS.do", sParam);
				    sheetObjects[1].LoadSearchData(sXml,{Sync:0} );
				}	 	 	
				break;	
			case IBCLEAR:      // initializing 
				MnrWaitControl(true);
				isNowInit=true;  
				sheetObj.WaitImageVisible = false;
				selCheck=false;   
				actionType="";
				// Each  
				formObj.reset();   
				if(initLoader == 0){
					//initializing combo 
					for(var i=0; i < comboObjects.length;i++){ 
						comboObjects[i].RemoveAll();
					} 
					//retrieving common combo.  
					var sCondition=new Array (
						new Array("MnrGenCd","CD00052", "COMMON"),	//date  
						new Array("MnrGenCd","CD00002", "COMMON"),	//eq_knd_cd
						new Array("MdmCurrency","","COMMON"),       //curr_cd
						new Array("MnrGenCd","CD00029", "COMMON") //disp_sts_cd
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
								//Date
								if(i==0) {
									input_date_type_code.InsertItem(j, tempText[1] ,tempText[0]);
									if(j == 0){	  	    
										input_date_type_code.SetSelectCode(tempText[0]);
									}  								
								}	
							}
							if(i==1) {		
								sheetObjects[1].SetColProperty(0,"eq_knd_cd", {ComboText:sheetComboText, ComboCode:sheetComboCode} );
							}else if(i==2) {		
								sheetObjects[1].SetColProperty(0,"curr_cd", {ComboText:sheetComboCode, ComboCode:sheetComboCode} );
							}else if(i==3) {		
								sheetObjects[1].SetColProperty(0,"disp_sts_cd", {ComboText:sheetComboText, ComboCode:sheetComboCode} );
							}	
						}
					}
				}
				initLoader=1;	
				//initializing sheet   
				for(i=0;i<sheetObjects.length;i++){   
					sheetObjects[i].RemoveAll();
		        }  
				//setting initial value 
				formObj.in_apro_st_dt.value=ComGetDateAdd(ComGetNowInfo("ymd"), "d", -7);;
				formObj.in_apro_end_dt.value=ComGetNowInfo("ymd");
				formObj.disp_no_list.value="";
				formObj.eq_no_list.value="";
				formObj.inv_no_list.value="";
				input_date_type_code.SetSelectIndex(0);
				sheetObj.SetWaitImageVisible(1);
				isNowInit=false;   
				MnrWaitControl(false);
				break;			
        }				
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
		with(formObj){            	        
	    	switch(sAction) {  	
			}		 
		}	
        return true; 
    }	
	/**
	 * getting rep_Multiful_inquiry  
	 *           
	 * Location : in case of Single choice     
	 */      
	function getMnr_Multi(rowArray,ret_val) {
		var formObj=document.form;  
		var tempText=""; 
		//initializing   
		eval("document.form." + ret_val + ".value='';"); 
		for(var i=0; i<rowArray.length; i++) {   
			var colArray=rowArray[i];     
			tempText +=  rowArray[i] + ',';    
		}      
		//clearing comma(,)      
		if (tempText != "")       
	        tempText=tempText.substr(0, tempText.length - 1);   	
		tempText=tempText.toUpperCase(); 	            
		eval("document.form." + ret_val + ".value='" + tempText + "';"); 
	}      
/* developer job */
