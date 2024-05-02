/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0130.js
*@FileTitle  : ReportViewManagement
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/04
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    /**
     * @extends 
     * @class ESM_COA_0130 : ESM_COA_0130 Business script for the UI
     */
    function ESM_COA_0130() {
    	this.processButtonClick=tprocessButtonClick;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.setSheetObject=setSheetObject;
    	this.sheet1_OnSearchEnd=sheet1_OnSearchEnd;
    	this.sheet1_OnChange=sheet1_OnChange;
    	this.doActionIBSheet=doActionIBSheet;
    	this.validateForm=validateForm;
    }
 // Grobla Variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    /* Event handler processing by button click event */
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
                    case "btn_Retrieve":
                        doActionIBSheet(sheetObject,formObject,IBSEARCH);
                        break;
                    case "btn_Save":
                        doActionIBSheet(sheetObject,formObject,IBSAVE);
                        break;
                    case "btn_Close":
                    	ComClosePopup(); 
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
            for(i=0;i<sheetObjects.length;i++){
                //Sheet configuration setting function(start)
                ComConfigSheet(sheetObjects[i]);
                initSheet(sheetObjects[i],i+1);
                //Sheet configuration setting function(end)
                ComEndConfigSheet(sheetObjects[i]);
            }
            doActionIBSheet(sheetObjects[0],document.form,IBCLEAR); 
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
                    with(sheetObj){
                    	//(13, 0, 0, true);                      //setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                		var HeadTitle0="status|rpt_seq|Office\nLevel|Office Desc|Profit View|Profit View|Profit View|Office View|Office View|Office View|Profit Level|Profit Level|Profit Level";
                		var HeadTitle1="status|rpt_seq|Office\nLevel|Office Desc|PA|RA|default|Contract|Loading|default|CM|OP|default";

                		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                		var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
                		var headers = [ { Text:HeadTitle0, Align:"Center"}, { Text:HeadTitle1, Align:"Center"} ];
                		InitHeaders(headers, info);

                		var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rpt_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ofc_lvl",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"ofc_lvl_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                		             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pfit_cd1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
                		             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pfit_cd2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
                		             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pfit_dflt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
                		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
                		             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ofc_dflt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lvl_cd1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
                		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lvl_cd2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
                		             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"lvl_dflt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
                		
                		InitColumns(cols);

                		SetEditable(1);//Editkind[optional,Defaultfalse]
                		//	SetCountPosition(0);
                        SetColProperty(0 ,"ofc_cd1" , {AcceptKeys:"[Y,N]" , InputCaseSensitive:1});
                        SetColProperty(0 ,"ofc_cd2" , {AcceptKeys:"[Y,N]" , InputCaseSensitive:1});
                        SetColProperty(0 ,"lvl_cd1" , {AcceptKeys:"[Y,N]" , InputCaseSensitive:1});
                        SetColProperty(0 ,"lvl_cd2" , {AcceptKeys:"[Y,N]" , InputCaseSensitive:1});
//                		SetSheetHeight(300);
      				  	resizeSheet();
                	}
                    break;
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
         * Display color under the terms after sheet1 inquiry
         */
        function sheet1_OnSearchEnd(sheetObj, errMsg){        	
        	for(i=2; i<=sheetObj.LastRow(); i++){
        		if(sheetObj.GetCellValue(i, "pfit_dflt") == "P"){
                     sheetObj.SetCellBackColor(i, "pfit_cd1","#F7E7EC");
                     sheetObj.SetCellBackColor(i, "pfit_cd2","#FFFFFF");
                 }else{
                     sheetObj.SetCellBackColor(i, "pfit_cd1","#FFFFFF");
                     sheetObj.SetCellBackColor(i, "pfit_cd2","#F7E7EC");
                 }
        		if(sheetObj.GetCellValue(i, "ofc_dflt") == "C"){
                     sheetObj.SetCellBackColor(i, "ofc_cd1","#F7E7EC");
                     sheetObj.SetCellBackColor(i, "ofc_cd2","#FFFFFF");
                 }else{
                     sheetObj.SetCellBackColor(i, "ofc_cd1","#FFFFFF");
                     sheetObj.SetCellBackColor(i, "ofc_cd2","#F7E7EC");
                 }
        		if(sheetObj.GetCellValue(i, "lvl_dflt") == "C"){
                     sheetObj.SetCellBackColor(i, "lvl_cd1","#F7E7EC");
                     sheetObj.SetCellBackColor(i, "lvl_cd2","#FFFFFF");
                 }else{
                     sheetObj.SetCellBackColor(i, "lvl_cd1","#FFFFFF");
                     sheetObj.SetCellBackColor(i, "lvl_cd2","#F7E7EC");
                 }        		
        	}            
        }
        /**
         * Change the color after the sheet1 is saved
         */
        function sheet1_OnChange(sheetObj, row, col, value){            
        	if(sheetObj.GetCellValue(row, "pfit_dflt") == "P"){
                sheetObj.SetCellBackColor(row, "pfit_cd1","#F7E7EC");
                sheetObj.SetCellBackColor(row, "pfit_cd2","#FFFFFF");
            }else{
                sheetObj.SetCellBackColor(row, "pfit_cd1","#FFFFFF");
                sheetObj.SetCellBackColor(row, "pfit_cd2","#F7E7EC");
            }
        	if(sheetObj.GetCellValue(row, "ofc_dflt") == "C"){
                sheetObj.SetCellBackColor(row, "ofc_cd1","#F7E7EC");
                sheetObj.SetCellBackColor(row, "ofc_cd2","#FFFFFF");
            }else{
                sheetObj.SetCellBackColor(row, "ofc_cd1","#FFFFFF");
                sheetObj.SetCellBackColor(row, "ofc_cd2","#F7E7EC");
            }
        	if(sheetObj.GetCellValue(row, "lvl_dflt") == "C"){
                sheetObj.SetCellBackColor(row, "lvl_cd1","#F7E7EC");
                sheetObj.SetCellBackColor(row, "lvl_cd2","#FFFFFF");
            }else{
                sheetObj.SetCellBackColor(row, "lvl_cd1","#FFFFFF");
                sheetObj.SetCellBackColor(row, "lvl_cd2","#F7E7EC");
            }
        } 
        /**
         * Handling process about the sheet object
         */
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg(false);
            switch(sAction) {
            	case IBCLEAR:          //Inquiry
			        sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
					formObj.f_cmd.value=INIT;
//parameter changed[check again]CLT 					
					var sXml=sheetObj.GetSearchData("ESM_COA_0130GS.do", coaFormQueryString(formObj));
					var arrXml=sXml.split("|$$|");
					if (arrXml.length > 0)
						ComCoaSetIBCombo(sheetObj, arrXml[0], "pfit_dflt", false, 0);
					if (arrXml.length > 1)
						ComCoaSetIBCombo(sheetObj, arrXml[1], "ofc_dflt", false, 0);
					if (arrXml.length > 2)
						ComCoaSetIBCombo(sheetObj, arrXml[2], "lvl_dflt", false, 0);
					ComOpenWait(false);
					break	
                case IBSEARCH:      //Inquiry
                    if(validateForm(sheetObj,formObj,sAction))
                	// Prohibit button click when a business transaction is processing 
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
                    formObj.f_cmd.value=SEARCH;
//method change[check again]CLT                     
                    sheetObj.DoSearch("ESM_COA_0130GS.do", coaFormQueryString(formObj) );
                    ComOpenWait(false);
                    break;
                case IBSAVE:       //Save
                    if(validateForm(sheetObj,formObj,sAction))
                	// Prohibit button click when a business transaction is processing 
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
                    formObj.f_cmd.value=MULTI;
                    sheetObj.DoSave("ESM_COA_0130GS.do", coaFormQueryString(formObj));
                    ComOpenWait(false);
                    break;
            }
        }
        /**
         * Handling process for form object input validation
         */
        function validateForm(sheetObj,formObj,sAction){
            with(formObj){      
            }   
            return true;
        }

        function resizeSheet(){
       	 ComResizeSheet(sheetObjects[0]);
        }
