/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : VOP_SCG_0060.js
 *@FileTitle: Packing Instructions/Provisions (Creation)
 *@author   : CLT
 *@version  : 1.0
 *@since    : 2014/06/23
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
     * @class vop_scg_0042 : business script for vop_scg_0042
     */
//    function vop_scg_0042() {
//    	this.processButtonClick		= tprocessButtonClick;
//    	this.setSheetObject 		= setSheetObject;
//    	this.loadPage 				= loadPage;
//    	this.initSheet 				= initSheet;
//    	this.initControl            = initControl;
//    	this.doActionIBSheet 		= doActionIBSheet;
//    	this.setTabObject 			= setTabObject;
//    	this.validateForm 			= validateForm;
//    	this.sheet1_OnDblClick 		= sheet1_OnDblClick;
//    }
    // common global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    var prefix="sheet1_";
//    var prefix="";
    var uploadObjects=new Array();
	var uploadCnt=0;
	/**
     * Dynamically load HTML Control event in page. <br>
     * Initialize IBSheet Object by calling this function from {@link #loadPage} function. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects list in turn
     **/
    function initControl() {     	
        //Axon event handling1. event catch
//        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
//        axon_event.addListenerFormat ('keypress', 'obj_keypress', form);
    }
 	// Handling business javascript OnKeyUp event
    function obj_keypress() {
    	switch(event.srcElement.dataformat){
    	    case "engup":
    	    	switch(ComGetEvent("name")){
	    	        case "imdg_pck_instr_cd":	
	    	        	//common standard:Only input English upper case, number
	        	    	ComKeyOnlyAlphabet('uppernum');
	    	        	break;
    	    	}
    	    	break; 
    	}
    }
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
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
				case "btn_down_excel":
    				var paramObj=new Object();
    				paramObj.title="Packing Instructions/Provisions";
                    paramObj.orientation="Portrait";
                    
					var sheetExcelObj = sheetObjects[0];
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
//    				paramObj.columnwidth="2:20|3:20|4:20|5:15";
//    				paramObj.datarowheight="0:25";
//    				var url=ComScgGetPgmTitle(sheetObjects[0], paramObj);  
//    				if(sheetObject.RowCount() < 1){//no data
//              		  	ComShowCodeMessage("COM132501");
//      	       		}else{
//      	       			//@@
//      	       			sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1 });
//      	       		}
//					sheetObject.SpeedDown2Excel(-1,false,false,"","",false,false,"Packing Instructions&Provisions",false);
					break;
 				case "btn_OK":
 					if (sheetObject.FindCheckedRow("checkbox") == "") {
 						ComShowCodeMessage("COM12189");
 						return 0;
 					}
					comPopupOKVOP();
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
    
	function getCheckedRowsSCG(colName) {
		var sheetObject=sheetObjects[0];
 		if(sheetObj == null) return null;
		var colsCnt=sheetObj.LastCol()+ 1;

  		var sCheckRows = sheetObj.FindCheckedRow("checkbox");
    	var arrRow = sCheckRows.split("|");
 		if(sCheckRows == "") return null;

		var rArray=new Array(arrRow.length);
    	var cArray=null; 
    	
    	for(idx=0; idx<arrRow.length; idx++){ 
  			cArray=null;
  			if(colName != null && colName != "") {
  				cArray=sheetObj.GetCellValue(arrRow[idx], colName);
  			} else {
  				cArray=new Array(colsCnt);
	  			for(var j=0; j<cArray.length; j++) {
	  				cArray[j]=sheetObj.GetCellValue(arrRow[idx], j);
                }
            }
            rArray[idx]=cArray;
    	}

	  	return rArray;
	}
    
	// 부모창의 Target Object에 값 세팅
	function comPopupOKVOP() {
		//alert(preConds.imdg_pck_instr_cd);
		// 모달창인 경우는 window 객체로부터 opener를 획득			        
		opener = window.dialogArguments;
		if (!opener) opener=parent; //이 코드 추가할것
			
		var rArray = null; 	// 행데이터를 담고 있는 배열
		var val	   = "";	// Target Object에 세팅할 값
		
		//var tagName = opener.document.all[preConds.imdg_pck_instr_cd].tagName;
		
		// 단일선택(Radio) 또는 다중선택(CheckBox) 일 때..
		if("radio" == "radio" || "radio" == "checkbox") {
			rArray = getCheckedRowsSCG(prefix+"imdg_pck_instr_cd");
        }
        // 선택박스가 없는경우.. 단일선택
        else {
        	rArray = getCheckedRowsSCG(prefix+"imdg_pck_instr_cd");
        }
		
		val = rArray;
		
		/*for(var i=1; i<=8; i++){
			var cval = eval("parent.document.form."+preConds.imdg_pck_instr_cd+".value");
			
			if(val == cval){
				//ComShowCodeMessage('SCG50005','Data');   //'{?msg1} is duplicated.'
				parent.document.all[preConds.imdg_pck_instr_cd].value = "";
				try {
					// Target Object에 OnChange 이벤트 발생시킨다.
					// => 이것은 Onchange 이벤트를 지정한 Object에만 영향을 끼친다.
					opener.document.all[preConds.imdg_pck_instr_cd].fireEvent("onchange");
				} catch(e) {}
				ComClosePopup();
			}
		}*/
		
		// Target Object에 값 세팅
		try {
			opener.document.all[preConds.imdg_pck_instr_cdObj].value = val;
			
			try {
				// Target Object에 OnChange 이벤트 발생시킨다.
				// => 이것은 Onchange 이벤트를 지정한 Object에만 영향을 끼친다.
				opener.document.all[preConds.imdg_pck_instr_cdObj].fireEvent("onchange");
			} catch(e) {}
			ComClosePopup();
			
		}
		catch(e) {
		 	ComShowCodeMessage("COM12111");
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
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        initControl();
        sheet1_OnLoadFinish(sheetObjects[0]);
    }
    function sheet1_OnLoadFinish(sheetObj) {
        if(preConds.pop_yn == 'Y') {
       	 if(sheetObj.GetColHidden("checkbox") == 1) {
       		 sheetObj.SetColHidden("checkbox", 0);
       	 }
         if(preConds.imdg_pck_instr_cd != '') {
         	if(preConds.imdg_pck_instr_cd != '') ComSetObjValue(document.form.imdg_pck_instr_cd, preConds.imdg_pck_instr_cd);
         }
        }
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj, sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {               
//                (8, 0, 0, true);
	                var HeadTitle="|No.|Seq|File Sav Id||Packing Instructions\nProvisions|FileNm|ID|Date";
	                SetConfig( { SearchMode:2, MergeSheet:8, Page:20, DataRowMerge:0 } );
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [  {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
	                              {Type:"Radio",    Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"checkbox" },
		                          {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"NONE" },
		                          {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"imdg_pck_instr_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                          {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"file_sav_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                          {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:prefix+"imdg_pck_instr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
		                          {Type:"Text",      Hidden:0,  Width:410,  Align:"Left",    ColMerge:0,   SaveName:prefix+"file_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:200 },
		                          {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cre_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                          {Type:"Date",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cre_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 }		                          
		                          ];
	                 
	                InitColumns(cols);
//	                SetEditable(0);
	                SetEditable(1);
	                //SetSheetHeight(420);
	                resizeSheet();
	                SetColHidden("checkbox",1);
               }
               break;
        }
    }
    function resizeSheet(){
   	 	ComResizeSheet(sheetObjects[0]);
    }
    // Sheet related process handling
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:      //retrieve
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=SEARCH;
					
					var imdg_pck_instr_cd  = preConds.imdg_pck_instr_cd;
					if(preConds.imdg_pck_instr_cd != ""){
						formObj.imdg_pck_instr_cd.value = imdg_pck_instr_cd;
					}
					
 					sheetObj.DoSearch("VOP_SCG_0042GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix) );
				}
				break;
        }
    }
    /**
     * after retrieving Sheet, event occurs
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		with(sheetObj) {
			SetColFontUnderline(prefix+"file_nm",1);
			SetDataLinkMouse(prefix+"file_nm",1);
		}
	}
	/**
     * downloading file <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj selected Row
     * @param {ibsheet} Col     	sheetObj selected Col
     * @param {String} 	Value     	file name
     **/
	function sheet1_OnDblClick(sheetObj, Row, Col, Value){		
		if (sheetObj.ColSaveName(Col) != prefix+"file_nm")
			return;
		if(sheetObj.GetCellText(Row, prefix+"file_nm") == "") {
			return;
		}
		location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefix+"file_sav_id");
		return;
	}
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj, formObj, sAction){
        with(formObj){
//                if (!isNumber(formObj.iPage)) {
//                    return false;
//                }
        }
        return true;
    }
