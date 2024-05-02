/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0581.js
*@FileTitle  : OOP Code Match with Vessel 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/29
=========================================================
*/

/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @fileoverview business script for esm_bkg_0581
     * @author CLT
     */
    /**
	 * @extends
	 * @class esm_bkg_0581 : esm_bkg_0581
	 */
    
   	/* developer's work */
    // global variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1; 
	var sheetObjects=new Array();
	var sheetCnt=0;
	var prefix1="sheet1_";
	var prefix2="sheet2_";
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
         /** *** using extra sheet valuable if there are more 2 sheets **** */
         var sheetObject=sheetObjects[0];
         var sheetObject1=sheetObjects[1];
         /** **************************************************** */
         var formObject=document.form;
         try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
					case "btn_retrieve":
						 if (ComIsNull(formObject.crr_cd)&&ComIsNull(formObject.vsl_cd)&&ComIsNull(formObject.vsl_eng_nm)){ 
							 ComShowCodeMessage("BKG00701","the carrier or the vessel or the VSL name");
						 }else{
							var iCheck=0;
							for(var i=0;i<sheetObject.RowCount();i++){
								if (sheetObject.GetRowStatus(i+1)=="I" || sheetObject.GetRowStatus(i+1)=="U"){
									iCheck++;
								}   
							}
							if(iCheck > 0){
			        			if(ComShowCodeConfirm("BKG00350")){
									doActionIBSheet(sheetObject,document.form,MULTI01);
			        			}
							}
							doActionIBSheet(sheetObject,document.form,IBSEARCH);
						 }
                    break;
					case "btn_new":
						doActionIBSheet(sheetObject,document.form,COMMAND01);
                    break;
					case "btn_save":
						doActionIBSheet(sheetObject,document.form,MULTI01);
                    break;
					case "btn_rowAdd":
						doActionIBSheet(sheetObject1,document.form,COMMAND02);
                    break;
                    
					case "btn_delete":
						doActionIBSheet(sheetObject1,document.form,REMOVE);
                    break;
					case "btn_save2":
						for(i=0;i<sheetObject1.RowCount();i++){
							if (ComIsNull(sheetObject1.GetCellValue(i,prefix2+"op_cd"))){
								ComShowCodeMessage("BKG00155");
								return;
							}
					    }
						doActionIBSheet(sheetObject1,document.form,MULTI02);
                    break;
					case "btn_carrier_cd":		
						var param="?crr_cd="+formObject.crr_cd.value;   
					    param+="&pgmNo=COM_ENS_0N1";
						ComOpenPopup('/opuscntr/COM_ENS_0N1.do' + param, 700, 500, 'getCOM_ENS_0N1_1', '1,0,1,1,1', true);
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
	 * registering IBSheet Object as list adding process for list in case of
	 * needing batch processing with other items defining list on the top of
	 * source
	 */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
	 * initializing sheet implementing onLoad event handler in body tag adding
	 * first-served functions after loading screen.
	 */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
         // doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
        }
        // axon_event.addListenerFormat('keypress','bkg0581_keypress',document.form);
    }
  /**
	 * setting sheet initial values and header param : sheetObj, sheetNo adding
	 * case as numbers of counting sheets
	 */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		switch(sheetNo) {
			case 1:      // sheet1 init
			    with(sheetObj){
			        
			      	var HeadTitle1="|Vessel|Full Name|OOP1|OOP2|OOP3";
	
			      	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
			      	var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      	var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      	InitHeaders(headers, info);
	
			      	var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"ibflag" },
			             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"vsl_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
			             {Type:"Text",      Hidden:0, Width:220,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"vsl_eng_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:50 },
			             {Type:"Text",      Hidden:0, Width:85,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"oop1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
			             {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"oop2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
			             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"oop3",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 } ];
			       
			      	InitColumns(cols);
			      	SetEditable(1);
			      	SetEditEnterBehavior("tab");
			        SetSheetHeight(480);
			     }
				break;
			case 2:      // sheet1 init
			    with(sheetObj){
		        
				      (4, 0, 0, true);
				      var HeadTitle1="|Sel.|OOP|Name ";
		
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"ibflag" },
				             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"del_chk", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:0,   SaveName:prefix2+"op_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
				             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix2+"op_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 } ];
				      InitColumns(cols);
				      SetEditable(1);
				      SetSheetHeight(480);
		        }
				break;
        }
    }
  // handling of Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
		var arrPreFix=new Array("sheet1_","sheet2_");
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:      
				if(validateForm(sheetObj,formObj,sAction))
 					formObj.f_cmd.value=SEARCH; 
					formObj.vsl_eng_nm.value=formObj.vsl_eng_nm.value.toUpperCase();
					var sXml=sheetObj.GetSearchData("ESM_BKG_0581GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arrPreFix));
					var arrXml=sXml.split("|$$|");
					for(var i=0; i < arrXml.length; i++){ 
						sheetObjects[i].RenderSheet(0);
						if(i > 0) {
							sheetObjects[i].SetWaitImageVisible(0);
						}  
						sheetObjects[i].LoadSearchData(arrXml[i],{Sync:0} );
						sheetObjects[i].RenderSheet(1);
					}
                break;
                
			case MULTI01:        // saving sheet1
          	  // if(getGridDataExistCheck(sheetObjects[0],sheetObjects[1])){
                formObj.f_cmd.value=MULTI01; 
				var sParam=ComGetSaveString(sheetObj);
				if (sParam == ""){
					ComShowCodeMessage("BKG95053"); 
					return; 
				}
				sParam += "&" + FormQueryString(formObj);
				var sXml=sheetObjects[0].GetSaveData("ESM_BKG_0581GS.do", sParam);
				sheetObj.LoadSaveData(sXml);
			  // }
				State=ComGetEtcData(sXml,"TRANS_RESULT_KEY");
				if(State == "S"){
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				}else{
					ComShowCodeMessage("BKG00391");
				}
                break;
                
			case MULTI02:        // saving sheet2
          	  if(validateForm(sheetObj,formObj,sAction)){
                formObj.f_cmd.value=MULTI02; 
				var sParam=ComGetSaveString(sheetObjects);
				if (sParam == "") return; 
				sParam += "&" + FormQueryString(formObj);
				var sXml=sheetObjects[1].GetSaveData("ESM_BKG_0581GS.do", sParam);
				sheetObj.LoadSaveData(sXml);
				State=ComGetEtcData(sXml,"TRANS_RESULT_KEY");
				if(State == "S"){
					doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
				}else{
					ComShowCodeMessage("BKG00391");
				}
			  }
                break;
			case COMMAND01:      // initializing
			    ComClearObject(formObj.crr_cd);
				ComClearObject(formObj.vsl_cd);
				ComClearObject(formObj.vsl_eng_nm);
			    sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
                break;
			case COMMAND02:      // inserting sheet2
			     sheetObj.DataInsert();
                break;
			case REMOVE:      // deleting sheet1
			   ComRowHideDelete(sheetObj,prefix2+"del_chk");
                break;
        }
    }
    /**
	 * handling process for input validation
	 */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        	if(sAction == 182){
        		if(sheetObj.ColValueDup(prefix2+"op_cd")>0){
        			ComShowCodeMessage("BKG03056", "OOP");
        			return false;
        		}
        	}
	// if (!isNumber(formObj.iPage)) {
	// return false;
	// }
        }
        return true;
    }
	/*
	 * common pop-up (getting carrier code)
	 */
	 function getCOM_ENS_0N1_1(rowArray){
		var formObject=document.form;
		var colArray=rowArray[0]; 
 		formObject.crr_cd.value=colArray[3] 
    }
	/*
	 * checking sheet2 compared with sheet 1
	 */
	function getGridDataExistCheck(sheetObj,sheetObj1){
		for (var i=0;i<sheetObj1.RowCount() ; i++)
		{
			if(sheetObj.GetCellValue(sheetObj.GetSelectRow(),sheetObj.GetSelectCol()) == sheetObj1.GetCellValue(i+1,"op_cd"))
			{
				return true;
			} 
			return false;
		}
    } 
	/*
	 * handling KeyPress Event
	 */
	// function bkg0581_keypress(){
	// obj=event.srcElement;
	// if(obj.dataformat == null) return;
	// window.defaultStatus=obj.dataformat;
	// switch(obj.dataformat){
	// case "engup":
	// ComKeyOnlyAlphabet('uppernum');
	// break;
	// }
	// }
    /*
	 * handling OnAfterEdit Event
	 */
	function sheet1_OnAfterEdit(sheetObj,Row,Col){
		if (!ComIsNull(sheetObj.GetCellValue(Row,Col))){
			var bFlag=false;
			for(i=1;i<=sheetObjects[1].RowCount();i++){
				if (sheetObj.GetCellValue(Row,Col)==sheetObjects[1].GetCellValue(i,prefix2+"op_cd")){
					bFlag=true;
					break;
				}
			}
			if (!bFlag){
				ComShowCodeMessage("BKG00105"); 
				sheetObj.SetCellValue(Row,Col,"");
				return;
			}
			if(sheetObj.ColSaveName(Col)==prefix1+"oop1"){
				if (sheetObj.GetCellValue(Row,prefix1+"oop1")==sheetObj.GetCellValue(Row,prefix1+"oop2")
						|| sheetObj.GetCellValue(Row,prefix1+"oop1")==sheetObj.GetCellValue(Row,prefix1+"oop3")){
					ComShowCodeMessage("BKG00488");
					sheetObj.SetCellValue(Row,Col,"");
				}
			}else if(sheetObj.ColSaveName(Col)==prefix1+"oop2"){
				if (sheetObj.GetCellValue(Row,prefix1+"oop2")==sheetObj.GetCellValue(Row,prefix1+"oop1")
						|| sheetObj.GetCellValue(Row,prefix1+"oop2")==sheetObj.GetCellValue(Row,prefix1+"oop3")){
					ComShowCodeMessage("BKG00488");
					sheetObj.SetCellValue(Row,Col,"");
				}
			}else if(sheetObj.ColSaveName(Col)==prefix1+"oop3"){
				if (sheetObj.GetCellValue(Row,prefix1+"oop3")==sheetObj.GetCellValue(Row,prefix1+"oop1")
						|| sheetObj.GetCellValue(Row,prefix1+"oop3")==sheetObj.GetCellValue(Row,prefix1+"oop2")){
					ComShowCodeMessage("BKG00488");
					sheetObj.SetCellValue(Row,Col,"");
				}
			} 
		}
	}
	/* the end of developer's work */
