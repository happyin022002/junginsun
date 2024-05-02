/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_scg_0051.js
*@FileTitle  : Loading Port for RSO (Inquiry)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23

=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @fileoverview commonly used javascript file, calendar related functions are defined.
     */
    /**
     * @extends 
     * @class vop_scg_0051 : business javascript for vop_scg_0051 
     */
  
    // common global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0; 
    var gRow=0; 
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
    	/***** In case of more than 2 sheets in a tab, additional sheet variables can be specified *****/
    	var sheetObject=sheetObjects[0];
    	/*******************************************************/
    	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
    			case "btn_retrieve":
    				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    				break;
    			case "btn1_Excel":
    				if(sheetObjects[0].RowCount() < 1){//no data
                		ComShowCodeMessage("COM132501");
                		}else{
                			doActionIBSheet(sheetObjects[0],document.form,IBDOWNEXCEL);
                		}
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
    	for(i=0;i<sheetObjects.length;i++){
    		ComConfigSheet (sheetObjects[i] );
    		initSheet(sheetObjects[i],i+1);
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	//Initializing IBMultiCombo
    	for(var k=0; k < comboObjects.length; k++){
    		initCombo(comboObjects[k], k + 1);
    	}
    	sheet1_OnLoadFinish(sheet1);
    }
    function sheet1_OnLoadFinish(sheetObj) {
    	doActionIBSheet( sheetObj,document.form,IBCLEAR);
    } 
    /**
     * Initializing Form의 Control. <br>
     * @param  {object} sheetObj	compulsory
     * @return none
     * @author 
     * @version 
     */
    function initControl(sheetObj){
    	// Form object
    	formObj=document.form;
    	// register axon event 
//    	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
    }
   	/** 
   	 * register IBCombo Object as list
   	 * @param    {IBCombo}	combo_obj	IBCombo Object
   	 */	
    function setComboObject(combo_obj){
    	comboObjects[comboCnt++]=combo_obj;
   	}
    /**
     * Initializing Combo 
     * param : comboObj, comboNo
     * adding case as numbers of counting combo
     */ 
    function initCombo(comboObj, comboNo) {
    	switch(comboObj.options.id) {
    		case "rso":    
    			var i=0;
    			with(comboObj) {
    				SetTitle("Code|Description");
					SetColAlign(0, "center");
					SetColAlign(1, "left");
					SetColWidth(0, "50");
					SetColWidth(1, "150");
    				SetDropHeight(200);
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
    		case 1:      //t1sheet1 init
    			with (sheetObj) {
		    	        var HeadTitle="|No.|Loading Port Code|Port Name|RSO Code|Country";
		    	        var prefix="sheet1_";
		
		    	        SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		    	        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		    	        var headers = [ { Text:HeadTitle, Align:"Center"} ];
		    	        InitHeaders(headers, info);
		
		    	        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		    	               {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"NONE" },
		    	               {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"loc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		    	               {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:prefix+"loc_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"rgn_shp_opr_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	               {Type:"Text",      Hidden:0,  Width:520,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cnt_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	               {Type:"Text",      Hidden:1, Width:540,  Align:"Left",    ColMerge:1,   SaveName:prefix+"key_loc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	               {Type:"Text",      Hidden:1, Width:540,  Align:"Left",    ColMerge:1,   SaveName:prefix+"key_rgn_shp_opr_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		    	         
		    	        InitColumns(cols);
		    	        SetEditable(0);
		    	        //SetSheetHeight(420);
		    	        resizeSheet();
                   }
                    break;
            }
    }
    function resizeSheet(){
   	 	ComResizeSheet(sheetObjects[0]);
    }
    // Sheet related process handling
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
    	switch(sAction) {
    		case IBCLEAR:      //retrieve combo
    			formObj.f_cmd.value=SEARCH01;
    			var aryPrefix=new Array("sheet1_");
    			var sXml=sheetObj.GetSearchData("VOP_SCG_0051GS.do", FormQueryString(formObj) );
    			sheetObj.ShowDebugMsg(false);
    			var sRso=ComGetEtcData(sXml, "cmbRso");
    			if(sRso != undefined){
    				var arrRso=sRso.split("%");
    				MakeComboObject(rso, arrRso);
    			}
    			break;   
    		case IBSEARCH:      //retrieve
    			if(!validateForm(sheetObj,formObj,sAction)){
    				return;
    			}
    			formObj.f_cmd.value=SEARCH;
    			var aryPrefix=new Array("sheet1_");
    			var sXml=sheetObj.GetSearchData("VOP_SCG_0051GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam( aryPrefix ));
    			sheetObj.ShowDebugMsg(false);
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
    		case IBDOWNEXCEL:      // Excel
                var paramObj=new Object();
                paramObj.title="Loading Port for RSO";
                paramObj.orientation="Portrait";
//                paramObj.columnwidth="2:15|3:30|4:35";
//                var url=ComScgGetPgmTitle(sheetObj, paramObj); 
//                sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
				var sheetExcelObj = sheetObj;
	            paramObj.columnwidth=ComScgGetExcelDown(sheetExcelObj);
	            paramObj.cols=ComScgGetExcelDownCols(sheetExcelObj);	
	            paramObj.datarowheight="0:25";
	            var url=ComScgGetPgmTitle(sheetExcelObj, paramObj); 
	            
	            if(sheetExcelObj.RowCount() < 1){//no data
	        		  ComShowCodeMessage("COM132501");
		       	}else{
	   	       		var str = sheetExcelObj.GetSearchData(url);
	   	       		str = str.replace(/(^\s*)|(\s*$)/gi, "");
	   	       		sheetExcelObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetExcelObj), SheetDesign:1,Merge:1,ReportXML:str});
		       	}
    			break;
    	}
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
              if(sAction == IBSEARCH){
      		      if (comboObjects[0].GetSelectCode()== "" ){
 		    	     ComShowCodeMessage('COM12113', 'RSO Code!');   
 		    	     //comboObjects[0].focus();
		    	     return false;
   		          }
           	 }
              if(sAction == IBSAVE){
           	     if( !ComShowCodeConfirm('COM12147' , 'data' ) ){
           	    	 return false;	 
           	     }
           	 }
        }
        return true;
    }
    function MakeComboObject(cmbObj, arrStr) {
    	for (var i=0; i < arrStr.length-1;i++ ) {
    		var text=arrStr[i].split("|");
    		cmbObj.InsertItem(i,   arrStr[i],text[0]);
    	}
    }
    //Find or create function combo_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)
    function rso_OnChange (comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
//    	var aText=newText.split("|");
    	document.form.rgn_shp_opr_desc.value=comboObj.GetText(newCode,1);
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);    	 
    }	 
