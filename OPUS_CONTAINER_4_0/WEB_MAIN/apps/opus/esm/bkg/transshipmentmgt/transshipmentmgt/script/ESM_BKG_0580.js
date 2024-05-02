/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0580.js
*@FileTitle  : VVD Discharging Yard
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class esm_bkg_0580 :  business script for esm_bkg_0580
     */
    
   	/* Developer Work	*/
 // global variable
 var tabObjects=new Array();
 var tabCnt=0 ;
 var beforetab=1; 
 var sheetObjects=new Array();
 var sheetCnt=0;
 var prefix1="sheet1_";
 var prefix2="sheet2_";
// Event handler processing by button click event  */
 document.onclick=processButtonClick;
 // Event handler processing by button name */
     function processButtonClick(){
          /***** using extra sheet valuable if there are more 2 sheets *****/
          var sheetObject=sheetObjects[0];
          var sheetObject1=sheetObjects[1];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name"); 
             switch(srcName) {
 					case "btn_retrieve":
						var iCheck=0;
						for(var i=0;i<sheetObject.RowCount();i++){
							if (sheetObject.GetRowStatus(i+1)=="I" || sheetObject.GetRowStatus(i+1)=="U"){
								iCheck++;
							}   
						}
						if(iCheck > 0){
		        			if(ComShowCodeConfirm("BKG00350")){
	 							doActionIBSheet(sheetObject,document.form,IBSAVE);
		        			}
						}
						doActionIBSheet(sheetObject,document.form,IBSEARCH);
                     break;
 					case "btn_new":
 						doActionIBSheet(sheetObject,document.form,IBCLEAR);
                     break;
 					case "btn_save": 
						var iCheck=0;
						for(var i=0;i<sheetObject.RowCount();i++){
							if (sheetObject.GetRowStatus(i+1)=="I" || sheetObject.GetRowStatus(i+1)=="U"){
								sheetObject.SetCellValue(i+1,prefix1+"yd_cd",formObject.vps_port_cd.value+sheetObject.GetCellValue(i+1,prefix1+"ydcd"));
								iCheck++;
							}   
						}
						if (iCheck==0){
							ComShowCodeMessage("BKG00233");
						}else{ 
 							doActionIBSheet(sheetObject,document.form,IBSAVE);
						}
                     break;
 					case "btn_saveAs":
 						doActionIBSheet(sheetObject,document.form,IBDOWNEXCEL);
                     break; 
 					case "btn_yardPaste":
						if(sheetObject.RowCount()>0){
						    for(var i=0;i<sheetObject.RowCount();i++){
						    	if(sheetObject.GetCellValue(i+1,prefix1+"del_chk")==1&&sheetObject1.CheckedRows(prefix2+"del_chk")==1){
						    		sheetObject.SetCellValue(i+1,prefix1+"yd_cd",sheetObject1.GetCellValue(sheetObject1.GetSelectRow(),prefix2+"yd_cd"));
						    		sheetObject.SetCellValue(i+1,prefix1+"ydcd",sheetObject1.GetCellValue(sheetObject1.GetSelectRow(),prefix2+"yd_cd").substring(5));
								}
							}
						}else{
							 ComShowCodeMessage("BKG00155");
						} 
                     break;  					     
 					case "btns_calendar":
						var cal=new ComCalendarFromTo();
						cal.select(formObject.vps_etb_dt, formObject.vps_etd_dt,'yyyy-MM-dd');
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
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
         initDate(document.form);
		 axon_event.addListenerForm  ('beforedeactivate', 'bkg0580_obj_deactivate',  document.form); //- focus in
	     axon_event.addListenerFormat('beforeactivate',   'bkg0580_obj_activate',    document.form); //- focus out
     }
   /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
 		switch(sheetNo) {
 			case 1:      //sheet1 init
 				with (sheetObj) {
 		       
		 		      var HeadTitle1="|Sel.|VVD|Lane|ETB|Yard|CRN (Ship Call No.)|UVI No.";
		
		 		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		 		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		 		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		 		      InitHeaders(headers, info);
		
		 		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"ibflag" },
		 		             {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"del_chk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		 		             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"vvd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		 		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"lane",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		 		             {Type:"Text",      Hidden:0, Width:85,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"etb",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		 		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"ydcd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		 		             {Type:"Text",      Hidden:0, Width:140,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"cvy_ref_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		 		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"uq_vsl_id_no", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		 		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"vsl_cd" },
		 		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"skd_voy_no" },
		 		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"skd_dir_cd" },
		 		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"skd_call_seq" },
		 		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"clpt_cd" },
		 		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"yd_cd" } ];
		 		       
		 		      InitColumns(cols);
		 		      SetSheetHeight(480);
		 		      SetEditable(1);
		 		      SetEnterBehavior("tab");
 				}
 				break;
 			case 2:      //sheet1 init
 				with (sheetObj) {
		 		       var HeadTitle1="|Sel.|Yard CD|Full Name";
		 		       SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		 		       var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		 		       InitHeaders(headers, info);
		
		 		       var cols = [ {Type:"Status",    Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"ibflag" },
		 		              {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"del_chk", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		 		              {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:0,   SaveName:prefix2+"yd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		 		              {Type:"Text",      Hidden:0, Width:110,  Align:"Left",    ColMerge:0,   SaveName:prefix2+"yd_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		 		        
		 		       InitColumns(cols);
		 		       SetSheetHeight(480);
		 		       SetEditable(1);
		 		       
	 			}
 			break;
         }
     }
   // handling sheet process
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         var arrPreFix=new Array("sheet1_","sheet2_");
         switch(sAction) {
 			case IBSEARCH:      //retrieve 
 				if(validateForm(sheetObj,formObj,sAction)){ 
 					formObj.f_cmd.value=SEARCH;
 			        if (!ComIsEmpty(formObj.vps_oher_port_cd.value)){
 			        	formObj.vps_port_cds.value=formObj.vps_port_cd.value+"|"+formObj.vps_oher_port_cd.value;
 			        }else{
					}   formObj.vps_port_cds.value=formObj.vps_port_cd.value;
					var sXml=sheetObj.GetSearchData("ESM_BKG_0580GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arrPreFix));
					var arrXml=sXml.split("|$$|");
					for(var i=0; i < arrXml.length; i++){ 
						sheetObjects[i].RenderSheet(0);
						if(i > 0) {
							sheetObjects[i].SetWaitImageVisible(0);
						}  
						sheetObjects[i].LoadSearchData(arrXml[i],{Sync:0} );
						sheetObjects[i].RenderSheet(1);
					} 
				}
				break;
	 		case IBSAVE:        //save 
		 		if(validateForm(sheetObj,formObj,sAction)) {
		 			formObj.f_cmd.value=MULTI; 
					var sParam=ComGetSaveString(sheetObjects);
				    if (sParam == "") return;  
				    sParam += "&" + FormQueryString(formObj);
				    var sXml=sheetObjects[0].GetSaveData("ESM_BKG_0580GS.do", sParam);
				    sheetObjects[0].LoadSaveData(sXml);
		 		}
	 			break;
			case IBCLEAR:      // initialization 
			    ComClearObject(formObj.vps_port_cd);
				ComClearObject(formObj.vps_oher_port_cd);
				ComClearObject(formObj.crr_cd);
				ComClearObject(formObj.vvd);
				ComClearObject(formObj.lane);
				formObj.vps_etb_dt.value=ComGetNowInfo();
				formObj.vps_etd_dt.value=ComGetNowInfo();
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
            	break;
			case IBDOWNEXCEL:      // excel down
				
				if(sheetObj.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
					 sheetObj.Down2Excel({ HiddenColumn:{HiddenColumn:-1}});
				}
	        	break; 
         }
     }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction) {
        with(formObj){
	       	if (ComChkLen(vps_port_cd,5)!=2){ 
	       		ComShowCodeMessage("BKG00655");
				return false;
	       	}
        	switch (sAction) {
        		case IBSEARCH: {
					if (ComGetDaysBetween(vps_etb_dt.value, vps_etd_dt.value) > 30) {
						ComShowCodeMessage("BKG00756", "Duration", "30Days");
						vps_etb_dt.focus();
						return false;
					}
        			break;
        		}
        	}
        }
        return true;
    }
     /**
      *  Date input form screen initialization process
      */
     function initDate(formObj){
    	 with(formObj){
    		 vps_etb_dt.value=ComGetNowInfo();
    		 vps_etd_dt.value=ComGetNowInfo();
    	 }
     }
     /**
	 * Sheet1 OnChange evenet handling
	 */ 
	 function sheet1_OnChange(sheetObject,Row,Col,Value){ 
		 if (Col ==6 || Col ==7){
			 if (ComChkLen(sheetObject.GetCellValue(Row,prefix1+"cvy_ref_no"),20) !=2){
				sheetObject.SelectCell(Row,prefix1+"cvy_ref_no");
			}
			 if (ComChkLen(sheetObject.GetCellValue(Row,prefix1+"uq_vsl_id_no"),20) !=2){
				sheetObject.SelectCell(Row,prefix1+"uq_vsl_id_no");
			}
		 } 
	 }  
	 
	/*
	 * Activate Event handling
	 */
	function bkg0580_obj_activate(){
    	//input Validation
    	switch(ComGetEvent("name")){
	    	case "vps_etb_dt":
	    		ComClearSeparator(ComGetEvent());
    			break;
	    	case "vps_etd_dt":
	    		ComClearSeparator(ComGetEvent());
    			break; 
    		default:
    			break;
    	}
    }
	/*
	 * Deactivate Event handling
	 */
    function bkg0580_obj_deactivate(){ 
    	switch(ComGetEvent("name")){ 
	    	case "vps_etb_dt":
	    		ComAddSeparator(ComGetEvent());
    			break;
	    	case "vps_etd_dt":
	    		ComAddSeparator(ComGetEvent());
    			break;  
    		default:
    			break; 
    	}
    }
	/* Developer Work End */
