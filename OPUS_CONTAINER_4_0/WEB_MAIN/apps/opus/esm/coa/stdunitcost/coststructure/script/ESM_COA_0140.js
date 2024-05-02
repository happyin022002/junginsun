/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0140.js
*@FileTitle  : Feeder Term Ratio
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Code for JSDoc creation below ------------------*/
   /**
     * @fileoverview 
     */
    /**
     * @extends 
     * @class ESM_COA_0140 : ESM_COA_0140 Business script for the UI
     */
 /* Developer's task	*/
 // Grobla Variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    /**
     * Event handler processing by button click event 
     */
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name
     */
    function processButtonClick(){
    	var sheetObject=sheetObjects[0];
    	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
    			case "btng_RowAdd":
    				doActionIBSheet(sheetObject,formObject,IBINSERT);
    				break;	
    			case "btng_RowDel":
    				doActionIBSheet(sheetObject,formObject,IBDELETE);
    				break;							
    			case "btn_Reset":
    				doActionIBSheet(sheetObject,formObject,IBRESET);
    				break;						    
    			case "btn_Retrieve":
    				doActionIBSheet(sheetObject,formObject,IBSEARCH);
    				break;
    			case "btn_Save":
    				doActionIBSheet(sheetObject,formObject,IBSAVE);
    				break;					
    			case "btn_DownExcel":
    				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    				break;		
    			case "btn_LoadExcel":
    				doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
    				break;	    		
    			case "btn_Close":			
    				doActionIBSheet(sheetObject,formObject,-1);
    				break;	 									
    		} // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage(OBJECT_ERROR);
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
    	var formObj = document.form;
    	
     	for(i=0;i<sheetObjects.length;i++){
     		//Sheet configuration setting function(start)
     		ComConfigSheet (sheetObjects[i]);
     		initSheet(sheetObjects[i],i+1);
     		//Sheet configuration setting function(end)
     		ComEndConfigSheet(sheetObjects[i]);
     	}
     	//SJH.20150105.ADD
     	if(formObj.f_calc_term_cd.value != "") {
     		btn_LoadExcel.style.display="none";
     		btng_RowAdd.style.display="none";
     		btng_RowDel.style.display="none";
     	}else{
     		btn_LoadExcel.style.display="inline";
     		btng_RowAdd.style.display="inline";
     		btng_RowDel.style.display="inline";     		
     	}
     }
     /**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
      */
      function initSheet(sheetObj,sheetNo) {
      	var cnt=0;
      	if(sheetNo==1) {
      	    with(sheetObj){
      	      //  (12, 3, 0, true);//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
      	      var HeadTitle="Sel.| |ACTIVITY\nGROUP CD|CALCULATION\nTERM CD|WATER\nTERM CD|WATER\nMODE FLAG|NODE\nSTEVEDORAGE RATIO|NODE\nTHROUGHPUT RATIO|NODE\nTERMINAL RATIO|NEXT NODE\nSTEVEDORAGE RATIO|NEXT NODE\nTHROUGHPUT RATIO|NEXT NODE\nTERMINAL RATIO" ;
      	      var HeadTitle1="| |ACTIVITY\nGROUP CD|CALCULATION\nTERM CD|WATER\nTERM CD|WATER\nMODE FLAG|NODE\nSTEVEDORAGE RATIO|NODE\nTHROUGHPUT RATIO|NODE\nTERMINAL RATIO|NEXT NODE\nSTEVEDORAGE RATIO|NEXT NODE\nTHROUGHPUT RATIO|NEXT NODE\nTERMINAL RATIO" ;

      	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

      	      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
      	      var headers = [ { Text:HeadTitle, Align:"Center"},
      	                  { Text:HeadTitle1, Align:"Center"} ];
      	      InitHeaders(headers, info);

      	      var cols = [ {Type:"DelCheck",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"dtDelCheck",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
      	             {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
      	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cost_act_grp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
      	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"calc_term_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
      	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"wtr_term_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
      	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"wtr_mod_flg",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
      	             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"nod_stvg_rto",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
      	             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"nod_thrp_rto",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
      	             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"nod_tml_rto",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
      	             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"nxt_nod_stvg_rto",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
      	             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"nxt_nod_thrp_rto",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
      	             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"nxt_nod_tml_rto",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
      	       
      	      InitColumns(cols);
 
      	      SetEditable(1);//Editkind[optional,Defaultfalse]
      	      SetHeaderRowHeight(GetDataRowHeight());
      	      SetSheetHeight(ComGetSheetHeight(sheetObj, 14));
      	      SetColProperty(0 ,"cost_act_grp_cd"  , {AcceptKeys:"E|N"   , InputCaseSensitive:1});
      	      SetColProperty(0 ,"calc_term_cd"  , {AcceptKeys:"E"   , InputCaseSensitive:1});
      	      SetColProperty(0 ,"wtr_term_cd"  , {AcceptKeys:"E"   , InputCaseSensitive:1});
      	      SetColProperty(0 ,"wtr_mod_flg"  , {AcceptKeys:"E"   , InputCaseSensitive:1});
      	      //SJH.20150105.ADD
      	      SetColProperty(0 ,"nod_stvg_rto" , {AcceptKeys:"N"   , InputCaseSensitive:1});
      	      SetColProperty(0 ,"nod_thrp_rto" , {AcceptKeys:"N"   , InputCaseSensitive:1});
      	      SetColProperty(0 ,"nod_tml_rto"  , {AcceptKeys:"N"   , InputCaseSensitive:1});      	
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
     * Handling process about the sheet object
     */ 
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
    	switch(sAction) {
    		case IBINSERT:                  // Insert
    			sheetObj.DataInsert(-1);
    			break;	
    		case IBDELETE:                  // Delete
    			formObj.f_cmd.value=MULTI;
    			sheetObj.RowDelete(sheetObj.GetSelectRow(), false);
    			break;	   								
    		case IBRESET:                  // RESET
//                sheetObj.Reset();
    			sheetObj.RemoveAll();
//    			sheetObj.RenderSheet(0);
//    			initSheet(sheetObj, 1);
//    			sheetObj.RenderSheet(1);
    			break;		    
    		case IBSEARCH:		           //Inquiry
    			// Prohibit button click when a business transaction is processing 
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
    			formObj.f_cmd.value=SEARCHLIST;
     			sheetObj.DoSearch("ESM_COA_0140GS.do", coaFormQueryString(formObj) );
//    			ComOpenWait(false);
    			break;	
    		case IBSAVE:                  // save
    			// Prohibit button click when a business transaction is processing 
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
    			formObj.f_cmd.value=MULTI;
    			sheetObj.DoSave("ESM_COA_0140GS.do", coaFormQueryString(formObj), -1, true);
    			ComOpenWait(false);
    			break;					
           case IBDOWNEXCEL:            // Excell download
    			//sheetObj.SpeedDown2Excel(-1, true, true);
    			var excelType=selectDownExcelMethod(sheetObj);
    			break;	
    		case IBLOADEXCEL:                  // excell loading
        		//20150716.MOD/ADD/DEL
        		sheetObj.SetWaitImageVisible(0);
	        	sheetObj.RemoveAll();
	        	sheetObj.LoadExcel({ Mode:"HeaderMatch", StartRow: "1"});
    			break;	
    		case -1:                     // close window 
    			ComClosePopup(); 
    			break;												
    	}	
    }
    
    //SJH.20150105.MOD
    function callBackExcelMethod(excelType) {	
    	var sheetObj = sheetObjects[0];
        switch (excelType) {
    	    case "AY":
    	        sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
    	        break;
    	    case "AN":
    	    	sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
    	    	break;
    	    case "DY":
    	    	sheetObj.Down2Excel({ HiddenColumn:1, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
    	    	break;
    	    case "DN":
    	    	sheetObj.Down2Excel({ HiddenColumn:1, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
    	    	break;
    	}            
    }

    function sheet1_OnSearchEnd(shtObj, ErrMsg) {
		ComOpenWait(false);
    }			
    /*To retrieve when the screen is loaded */
    function setRetrieveAction(){    	
    	sheetObject=sheetObjects[0];
    	formObject=document.form;
    	doActionIBSheet(sheetObject,formObject,IBSEARCH);
    }
    
    //SJH.20150105.ADD : 저장후 메시지 추가 나중 SC로 교체!!!
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
        if(ErrMsg == ""){
            // [COM130102] : Success
        	ComShowMessage(ComGetMsg("COM130102","Data"));
        }else{
            ComShowMessage(ComGetMsg("COM132101"));
        }	
        doActionIBSheet(sheetObj,document.form,IBSEARCH);
    } 
    
    //SJH.20150507.ADD : LOADEXCEL OPTION
    function sheet1_OnLoadExcel(sheetObj, result, code, msg) {	
    	ComOpenWait(false);									//20150716.MOD
    	if(isExceedMaxRow(msg)) return;
    }    
    
    //20150716.ADD
    function sheet1_OnLoadFileSelect(sheetObj){
        ComOpenWait(true);
    }  
    
	/* Developer's task ends */
    
    
