/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0139.jsp
*@FileTitle  : Feeder Term
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/27
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
     * @class ESM_COA_0139 : ESM_COA_0139 Business script for the UI
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
                    //loadPage();			
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
    		} // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(getMsg(OBJECT_ERROR));
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
    	for(i=0;i<sheetObjects.length;i++){
    		//Sheet configuration setting function(start)
    		ComConfigSheet(sheetObjects[i]);
    		initSheet(sheetObjects[i],i+1);
    		//Sheet configuration setting function(end)
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	ComSetFocus(document.form.f_por);
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
    	      //  (7, 3, 0, true);//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    	      var HeadTitle="Sel.| |Org. Loc.|Dest. Loc.|F/M|Feeder Rcv. Term|Feeder DE. Term" ;
    	      var HeadTitle1="| |Org. Loc.|Dest. Loc.|F/M|Feeder Rcv. Term|Feeder DE. Term" ;
    	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
    	      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
    	      var headers = [ { Text:HeadTitle, Align:"Center"},{ Text:HeadTitle1, Align:"Center"} ];
    	      InitHeaders(headers, info);
    	      var cols = [ {Type:"DelCheck",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"dtDelCheck",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
    	             {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
    	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"org_loc_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
    	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dest_loc_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
    	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"full_mty_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
    	             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"fdr_rcv_term_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },		//20160114.MOD : EDITLEN
    	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"fdr_de_term_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 } ];	//20160114.MOD : EDITLEN
    	       
    	      InitColumns(cols);

    	      SetEditable(1);//Editkind[optional,Defaultfalse]
//    	      SetSheetHeight(430);
			  resizeSheet();
    	      SetRangeBackColor(0, 2, 0, 3,"#17B0B0");
//    	      SetRangeFontColor(0, 2, 0, 3,"#000000");
    	      SetColProperty(0 ,"org_loc_cd"  , {AcceptKeys:"N|E"   , InputCaseSensitive:1});	//20151209.MOD : AcceptKeys E->N,E
    	      SetColProperty(0 ,"dest_loc_cd"  , {AcceptKeys:"N|E"   , InputCaseSensitive:1});	//20151209.MOD : AcceptKeys E->N,E
    	      SetColProperty(0 ,"full_mty_cd"  , {AcceptKeys:"E"   , InputCaseSensitive:1});
    	      SetColProperty(0 ,"fdr_rcv_term_cd"  , {AcceptKeys:"E"   , InputCaseSensitive:1});
    	      SetColProperty(0 ,"fdr_de_term_cd"  , {AcceptKeys:"E"   , InputCaseSensitive:1});
    	      }


    	} 
    }
    /**
    * Open popup in case of double clicking sheet1
    * Inquiry RCV-CALC in case of double clicking ORG_LOC_CD 
    * Inquiry DEL-CALC in case of double clicking DEST_LOC_CD
    */
    function sheet1_OnDblClick(sheetObj , row, col){
        if(sheetObj.ColSaveName(col) == "org_loc_cd"){
    		var str="f_calc_term_cd=RCV" +
    		"&f_wtr_term_cd=" + sheetObj.GetCellValue(row, "fdr_rcv_term_cd") ;
        } else if(sheetObj.ColSaveName(col) == "dest_loc_cd"){
            var str="f_calc_term_cd=DEL" +
            "&f_wtr_term_cd=" + sheetObj.GetCellValue(row, "fdr_de_term_cd") ;
        } else {
            return;
        }
        str=str + "&sysCommUiTitle=Feeder Term Ratio";
        // popup window
    	Popup(str);
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
    		case IBDELETE:                  // Insert
    			sheetObj.RowDelete(sheetObj.GetSelectRow(), false);
    			break;	   								
    		case IBRESET:                  // RESET
    			sheetObj.RemoveAll();
    			break;		    
    		case IBSEARCH:		           //Inquiry
    			// Prohibit button click when a business transaction is processing 
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
    			formObj.f_cmd.value=SEARCHLIST;
     			sheetObj.DoSearch("ESM_COA_0139GS.do", coaFormQueryString(formObj) );
//    			ComOpenWait(false);
    			break;	
    		case IBSAVE:                  // save
    			// Prohibit button click when a business transaction is processing 
    			if(!validateForm(sheetObj,formObj,sAction)) return false;
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
    			formObj.f_cmd.value=MULTI;
    			sheetObj.DoSave("ESM_COA_0139GS.do", coaFormQueryString(formObj), -1, true);
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
    	}
    }
    
    function callBackExcelMethod(excelType){
    	switch (excelType) {
		case "AY":
			if(sheetObjects[0].RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
				}else{
					sheetObjects[0].Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
				}

			break;
		case "DY":
			if(sheetObjects[0].RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
				}else{
					sheetObjects[0].Down2Excel({HiddenColumn:1, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
				}

				
			break;
		case "AN":
			if(sheetObjects[0].RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
				}else{
					sheetObjects[0].Down2Excel({ HiddenColumn:0, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
				}

				
			break;
		case "DN":
			if(sheetObjects[0].RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
				}else{
					sheetObjects[0].Down2Excel({HiddenColumn:1, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
				}
				
			break;
    	}
    }

    function sheet1_OnSearchEnd(shtObj, ErrMsg) {
		ComOpenWait(false);
    }			
    /**
    * Open the common popup of the location code
    */
    function openLocationCode(funtionNm){
    	ComOpenPopup('/opuscntr/COM_ENS_051.do', 775, 490, funtionNm, '1,0,1,1,1,1,1,1,1,1,1,1');
    }	
    /**
     * Getting a por-location from the popup and input it por-column
     */
    function getFPor(rowArray) {
    	var colArray=rowArray[0];
    	document.form.f_por.value=colArray[3];
    	document.form.f_del.focus();		
    }
    /** 
		  * Getting a del-location from the popup and input it del-column
     */
    function getFDel(rowArray) {
    	var colArray=rowArray[0];
    	document.form.f_del.value=colArray[3];
    }	
    /**
     * Popup function
     */
    function Popup(str){    	 
    	ComOpenWindow2("ESM_COA_0140.do?" + str,'','width=900, height=500, menubar=no, scrollbars=no, resizable=yes');
    }
    function validateForm(sheetObj,formObj,sAction){
    	var sheetObject=sheetObjects[0];
    	switch(sAction) {
    		case IBSAVE:
    			var dr=sheetObj.ColValueDup("org_loc_cd|dest_loc_cd|full_mty_cd");
    			if(dr>0){	//If there is duplicate values			
    				ComShowCodeMessage('COM12115', 'Origin Location, Destnation Lacation, Full or Empty Code');
    				sheetObj.SelectCell(dr,"org_loc_cd");
    				return false;
    			}
    		break;
    	}
    	return true;
    }

    function resizeSheet(){
   	 ComResizeSheet(sheetObjects[0], 40);
    }
	/* Developer's task ends */
    
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
