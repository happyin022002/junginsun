/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   EES_MNR_0022.js
*@FileTitle  : Estimate Group Auditing
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
						OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/* developer job	*/ 	
// common global variables   
var tabObjects=new Array(); 
var tabCnt=0 ;  
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0; 
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
         var sheetObject=sheetObjects[1];
         /*******************************************************/
         var formObject=document.form;
    	 try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {	
                case "btn_retrive":  
                    doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
                    break; 
		        case "btn_New":
		        	sheetObjects[0].RemoveAll();
					sheetObjects[1].RemoveAll();
					formObject.reset();
					doActionIBSheet(sheetObjects[0],document.form,IBCLEAR); 
                    break; 
		        case "btn_Reject": 	
                    doActionIBSheet(sheetObjects[1],formObject,IBCREATE);
                    break;
		        case "btn_Approval": 
                    doActionIBSheet(sheetObjects[1],formObject,IBSAVE);
                    break;
		        case "btn_Detail":	
					if(sheetObjects[1].RowCount()== 0){
						ComShowCodeMessage("MNR00309");			
					} else { 
						if(MnrNullToBlank(sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"rqst_eq_no")) != ''){
							// calling popup 
							var rqstEqNo=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"rqst_eq_no");
							var rprRqstSeq=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"rpr_rqst_seq");
							var rprRqstVerNo=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"rpr_rqst_ver_no");
							var eqKndCd=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"eq_knd_cd");
							ComOpenPopup('/opuscntr/EES_MNR_0192.do?rqst_eq_no='+rqstEqNo+"&rpr_rqst_seq="+rprRqstSeq+"&rpr_rqst_ver_no="+rprRqstVerNo+"&eq_knd_cd="+eqKndCd, 1024, 768, '', '0,0', false);   		
						}	 
					}
                    break;	
		        case "btn_downExcel":	
		        	if(sheetObject.RowCount() < 1){//no data
		        		ComShowCodeMessage("COM132501");
		        	}else{
		        		 sheetObject.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObject), Merge:1});
		        	}
		        	//sheetObjects[1].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[1]), SheetDesign:1,Merge:1 });
                    break;	
				case "btns_calendar":	 
					var cal=new ComCalendarFromTo();	       
						cal.select(form.fm_rqst_dt,  form.to_rqst_dt,  'yyyy-MM-dd'); 
					break; 	
				// inputting multi
				case "eq_no_multi":  
				    rep_Multiful_inquiry("rqst_eq_no");
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
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
		MnrWaitControl(true);
		initControl();   
        for(i=0;i<sheetObjects.length;i++){
        	//
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
        	//
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k + 1);
        }   
        
        for(var k=0;k<comboObjects.length;k++){ 
            initCombo(comboObjects[k],k + 1);  
        }
        
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR); 
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
        switch(sheetObj.id) {
			case "sheet1":  
                with (sheetObj) {
					sheet1.SetVisible(false);
				}	
                break;
            case "sheet2":      // sheet2 init
                with(sheetObj){
		              var HeadTitle="|Seq|Sel.|Estimate No|EQ No.|EQ Type|Service Provider|T/S|Cost Code|Cost Code Name|Request Date|Total\nAmout|System Verify\nResult|AGMT No.|Ref.No|Tariff No.";
		              HeadTitle      += "|AGMT Office|Damage\nFlagging|Imm\nExit|Off-\nhire|Gate In\nDate|Estimate\nStatus|RU Label Type|RU Label Value|Remark(s)";
		
		              SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					             {Type:"Text",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"tmp_seq",              KeyField:0,   CalcLogic:"",   Format:"" , PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                         {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
		                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rqst_ref_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rqst_eq_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"eq_knd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:1,   SaveName:"vndr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",   ColMerge:0,   SaveName:"cost_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",   ColMerge:0,   SaveName:"cost_cd_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             
					             {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"rqst_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"total_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Combo",     Hidden:0, Width:140,  Align:"Left",    ColMerge:1,   SaveName:"mnr_vrfy_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"agmt_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"agmt_ref_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"trf_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"agmt_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dmg_flag",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"imm_ext",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"rpr_offh_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"mvmt_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Combo",     Hidden:0, Width:113,  Align:"Left",    ColMerge:1,   SaveName:"rpr_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",  ColMerge:1,   SaveName:"rstr_usg_lbl_tp",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",  ColMerge:1,   SaveName:"rstr_usg_lbl_val",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"mnr_rpr_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"agmt_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"agmt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"agmt_ver_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"rpr_rqst_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"rpr_rqst_ver_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		               
		              InitColumns(cols);
//		              SetSheetHeight(410);
		              SetEditable(1);
		              resizeSheet( sheetObj );
		              SetFocusAfterProcess(0);
                }
                break;
        }		
    }
  // handling process for sheet 
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
          case IBSEARCH:      //retrieving list   rqst_type  
                 if(validateForm(sheetObj,formObj,sAction)){    
						formObj.f_cmd.value=SEARCH;  
						var sParam=FormQueryString(formObj);
						sheetObj.DoSearch("EES_MNR_0022GS.do",sParam );
				  } 	        
                break; 	
			 case IBCREATE:        //Reject
	              if(validateForm(sheetObj,formObj,sAction)){
						formObj.f_cmd.value=COMMAND03; 	   
						var sParam=sheetObjects[1].GetSaveString(false, true,"del_chk");
						sParam=ComSetPrifix(sParam,"sheet2"); 
					    sParam += "&" + FormQueryString(formObj);	 	  
					    var sXml=sheetObj.GetSaveData("EES_MNR_0022GS.do", sParam);
					    sheetObjects[1].LoadSaveData(sXml);
				  }			
				 break;	  
			case IBSAVE:        //Approval	    
	             if(validateForm(sheetObj,formObj,sAction)){ 
						formObj.f_cmd.value=COMMAND04;   	   
						var sParam=sheetObjects[1].GetSaveString(false, true,"del_chk");
						sParam=ComSetPrifix(sParam,"sheet2"); 
					    sParam += "&" + FormQueryString(formObj);	 	  
					    var sXml=sheetObj.GetSaveData("EES_MNR_0022GS.do", sParam);
					    sheetObjects[1].LoadSaveData(sXml);
				  }		
				 break;	
			case IBCLEAR:      // initializing 
				MnrWaitControl(true);
				//START
				sheetObj.SetWaitImageVisible(0);
				formObj.reset();
				//initializing combo	  
				for(var i=0; i < comboObjects.length;i++){ 
					comboObjects[i].SetSelectCode("-1");
					comboObjects[i].RemoveAll();
				}	 
				//initializing sheet 	
				sheetObjects[1].RemoveAll();
				formObj.fm_rqst_dt.value=ComGetDateAdd(ComGetNowInfo("ymd"), "M", -3); 	         
				formObj.to_rqst_dt.value=ComGetNowInfo("ymd"); 	
				//setting sheet combo 
				var sCondition=new Array (	 
					new Array("MnrGenCd",selfOfcCd,"CUSTOM9"), 
					new Array("MnrGenCd","CD00008", "COMMON"),	
					new Array("MnrGenCd","CD00002", "COMMON"),
					new Array("MnrGenCd","CD00004", "COMMON")	    
				)			 	
				var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
				//form combo EQ_TYPE	
				comboObjects[0].InsertItem(0, 'ALL' ,'A'); 
				if(comboList[0] != null){	    
					for(var j=1; j < comboList[0].length + 1;j++){ 
						var tempText=comboList[0][j - 1].split("|");  
						comboObjects[0].InsertItem(j, tempText[1] ,tempText[0]);
					} 				    
				}		 		  	 
				comboObjects[0].SetSelectCode('A');
				//setting sheetObjects[1] sheetCombo    			
				var sheetComboText="";  
				var sheetComboCode="";
				var sheetComboDefault="";
				var comboSaveNames=new Array();
				comboSaveNames[0]="rpr_sts_cd";
				comboSaveNames[1]="eq_knd_cd";
				comboSaveNames[2]="mnr_vrfy_tp_cd";          
				for(var i=1; i < comboList.length;i++){
				 	if(comboList[i] != null){
						sheetComboText=""; 
						sheetComboCode="";
						sheetComboDefault=""; 
				 		for(var j=0; j < comboList[i].length;j++){ 
							var tempText=comboList[i][j].split("|");    
							sheetComboText +=  tempText[1] + "|";  
							sheetComboCode +=  tempText[0] + "|";  
							if(j == 0){
								sheetComboDefault=tempText[0]; 	       	
							}  	   
						}			
						sheetObjects[1].InitDataCombo (0, comboSaveNames[i - 1], sheetComboText, sheetComboCode ,sheetComboDefault); 
					}   		      
				}    
				//END 
				sheetObj.SetWaitImageVisible(1);
				MnrWaitControl(false);  
                break;
                
			case IBSEARCH_ASYNC02:	//retrieving(in case of changing EQ Type)
				sheetObj.SetWaitImageVisible(0);
				if ( validateForm(sheetObj, formObj, sAction) ) { 
					//Cost Code						
					cost_cd.RemoveAll();
					var sCondition=new Array ( 		 
						new Array("MnrGenCd",combo1.GetSelectCode()+ "G", "COMMON")
					)  	                           
					var comboList=MnrComSearchCombo(sheetObjects[0],sCondition); 
					cost_cd.InsertItem(0,"ALL| |ALL","A");		  
					if(comboList[0] != null){
						for(var j=0; j < comboList[0].length;j++){  
							var tempText=comboList[0][j].split("|");  
							var tempTxt = tempText[0]+"-"+tempText[1];
							cost_cd.InsertItem(j + 1,tempText[0]+"|"+tempText[1]+"|"+tempTxt,tempText[0]);
						} 			      
					}		
				    cost_cd.SetSelectCode("A");
				}		
				sheetObj.SetWaitImageVisible(1);
				break;
        }
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
	 * setting combo basic info    
	 * @param	{IBMultiCombo}	combo_obj	ComboObject. 
	 * @param	{Number}	comboNo		ComboObject tag serial number 
	 * adding case as numbers of counting combos 
	 */     
	function initCombo (comboObj, comboNo) {   
	    var formObject=document.form
	    switch(comboNo) {     
	    	case 2:
	    		with (comboObj) { 
		    		SetMultiSeparator("|");
					SetTitle("Code|Name");	
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "65");
					SetColWidth(1, "135");
					SetDropHeight(160);
					SetUseAutoComplete(1);
					SetTitleVisible(true);
	    		}
			   default :   
		           with (comboObj) { 
				       //SetColAlign("left");	         
					   //DropHeight = 160;		     
			       }   	   
	           break;	 	
	     } 		
	} 
    /**
     * registering IBTab Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
    /**
     * initializing Tab
     * setting Tab items.
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
                }
             break;
         }	
    }
	function sheet2_OnSaveEnd(sheetObj,ErrMsg){  
		if (ErrMsg == "" || ErrMsg == undefined) {  
			ComShowCodeMessage("MNR00023"); 		   
		} else {		 	
			//ComShowCodeMessage("MNR00008",ErrMsg);  		
		}  	 		      
	}
    /**
     * Event when clicking Tab
     * activating selected tab items.
     */
    function tab1_OnChange(tabObj , nItem)
    {
        var objs=document.all.item("tabLayer");
    	objs[nItem].style.display="Inline";
    	objs[beforetab].style.display="none";
    	//--------------- important --------------------------//
    	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab=nItem;
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){ 	       
        	switch(sAction) { 	 
				case IBROWSEARCH:
					if (!ComChkValid(formObj)) return false;
				 	break;	
				case IBCREATE: 	  //Reject
					var sRow=sheetObj.FindCheckedRow("del_chk");
					if (sRow == ""){
						ComShowCodeMessage("MNR00038","Reject ");	
						return false;
					} 
					//checking REJECT   	
					if (!ComShowCodeConfirm("MNR00275","Estimate","Reject")){return false;}     
					break;	
				case IBSAVE:     		//Approval 
					var sRow=sheetObj.FindCheckedRow("del_chk");
					if (sRow == ""){
						ComShowCodeMessage("MNR00038","Approval ");	
						return false;
					} 
					if (!ComShowCodeConfirm("MNR00275","Estimate","Approval")){return false;}	
					break; 	 	
			}   
		}
        return true;
    }
	/** 
	 * handling method returned by rep_Multiful_inquiry
	 * @param	{Array}		rowArray	return Array
	 * @param	{String}	return_val	return form element name
	 */
	function getMnr_Multi(rowArray,return_val) {
 		var formObj=document.form;	 
 		var tempText="";      
 		//initializing     
		eval("document.form." + return_val + ".value='';"); 
 		for(var i=0; i < rowArray.length; i++) {     
 			tempText +=  rowArray[i] + ',';      
 		}     
 		//clearing comma(,)      
		tempText=MnrDelLastDelim(tempText);		
 		eval("document.form." + return_val + ".value='" + tempText + "';"); 
 	} 
	function sheet2_OnDblClick(sheetObj,Row,Col){
		var formObj=document.form;       
		if(MnrNullToBlank(sheetObjects[1].GetCellValue(Row,"rqst_eq_no")) != ''){
			// calling popup
			var rqstEqNo=sheetObjects[1].GetCellValue(Row,"rqst_eq_no");
			var rprRqstSeq=sheetObjects[1].GetCellValue(Row,"rpr_rqst_seq");
			var rprRqstVerNo=sheetObjects[1].GetCellValue(Row,"rpr_rqst_ver_no");
			var eqKndCd=sheetObjects[1].GetCellValue(Row,"eq_knd_cd");
			ComOpenPopup('/opuscntr/EES_MNR_0192.do?rqst_eq_no='+rqstEqNo+"&rpr_rqst_seq="+rprRqstSeq+"&rpr_rqst_ver_no="+rprRqstVerNo+"&eq_knd_cd="+eqKndCd, 1024, 768, '', '0,0', false);   		
		} 	      	
	} 	
	//combo event 					
	function combo1_OnChange(oldIndex, oldText, oldCode, newIndex, newText, newCode){ 
//		var comboObj = combo1;
		var formObj=document.form;        
		formObj.eq_knd_cd.value=combo1.GetSelectCode();
		
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC02);
	}   
	function initControl() {        
	    //Axon handling event1. event catch  
		var formObject=document.form;       
	   // axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 			  
	   // axon_event.addListenerFormat('focus',    'obj_activate',    formObject);             
	    //axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);            
		//axon_event.addListenerFormat('change',	 'obj_change',		formObject); 			
	}             
	//Axon handling event2. handling event   
	function obj_deactivate(){      
	    ComChkObjValid(ComGetEvent()); 
	} 
	function obj_activate(){   
	    ComClearSeparator(ComGetEvent());
	}        
	function obj_change(){	     
		var obj=ComGetEvent(); 
		var formObj=document.form; 
		var sheetObj=sheetObjects[0]; 
		if ( ComTrim(obj.value) != "" ) {
			switch(ComGetEvent("name")) {      
	    		case "rqst_eq_no":   
	        		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01);
				   	break;   
			}       
	    } else {
			switch(ComGetEvent("name")) {     
	    		case "rqst_eq_no":    
					setEqInfoClear(); 
				   	break;   	
			}  		
		}
	}    
//	function obj_keypress(){   
//	    obj=event.srcElement;    
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
//				if(obj.name == "rqst_eq_no"){
//					ComKeyOnlyAlphabet('uppernum','44');
//				} else { 
//					ComKeyOnlyAlphabet('uppernum');	
//				}      
//	            break; 
//	    }         
//	}
	/* developer job */
