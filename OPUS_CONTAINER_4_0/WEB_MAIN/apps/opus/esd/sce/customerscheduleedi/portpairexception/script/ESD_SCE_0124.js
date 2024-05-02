/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0124.js
*@FileTitle  : Bottleneck Input
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/15
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @author 
     */
    /**
     * @extends 
     * @class ESM_SAQ_0034 :  business script for ESM_SAQ_0034
     */
    var sheetObjects=new Array();
    var comObjects=new Array();
    var sheetCnt=0;
    var comboCnt=0;
    var set_lane="";
    /* Event handler processing by button click event */
    document.onclick=processButtonClick;
    /* Event handler processing by button name */
    function processButtonClick(){
    	var sheetObject=sheetObjects [0];
    	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
    			case "btn_retrieve":
					doActionIBSheet(sheetObject , formObject, IBSEARCH);
    				break;
    			case "btn_save":
    				doActionIBSheet(sheetObject , formObject, IBSAVE);
    				break;
    			case "btng_rowadd1":
    				doActionIBSheet(sheetObject, formObject, IBINSERT);
    				break;
				case "btng_ok":  
					ComClosePopup(); 
					break;
    		} // end switch
    	} catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(getMsg("COM12111"));
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
    function setSheetObject(sheet_obj) {
    	sheetObjects [sheetCnt++]=sheet_obj;
    }
     /** 
      * registering IBCombo Object as list
      * param : combo_obj 
      * adding process for list in case of needing batch processing with other items
      * defining list on the top of source
      */ 
     function setComboObject(combo_obj) {  
         comboObjects[comboCnt++]=combo_obj;  
     }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage(rlaneSheetList, rlaneNmSheetList) {
    	for(i=0; i < sheetObjects .length; i++) {
    		ComConfigSheet(sheetObjects [i]);
    		initSheet(sheetObjects [i], i+1);
    		ComEndConfigSheet(sheetObjects [i]);
    	}
    	var sheetResizeFull=true;
 		var comboList=new Array();
 		comboList1=rlaneSheetList.split("|");
 	 	comboList2=rlaneNmSheetList.split("|");
 	 	currencyKindCode="";
 	 	currencyKindDesc="";
 	 	for(var i=0; i < comboList1.length;i++){
	 	 	currencyKindCode=currencyKindCode + comboList1[i].split("|") + "|";
	 	 	currencyKindDesc=currencyKindDesc + comboList1[i].split("|")+"\t"+comboList2[i].split("|") + "|";
 	 	}
 	 	sheetObjects[0].SetColProperty(sheetObjects[0].SaveNameCol("slan_cd"), {ComboText:currencyKindDesc, ComboCode:currencyKindCode} );
 	 	sheet1_OnLoadFinish(sheet1);
    }
      function sheet1_OnLoadFinish(sheetObj) {
 		   var formObject=document.form;
		   doActionIBSheet(sheetObjects[0] , formObject, IBSEARCH);
     }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
     function initSheet(sheetObj, sheetNo) {
     	var cnt=0;
     	switch (sheetNo) {
     	case 1: 
     	    with(sheetObj){
		          var HeadTitle="STS|Del.|Lane|Name";
		          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		          var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		          var cols = [ 
		                     {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			                 {Type:"DelCheck",  Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"dtDelCheck",   KeyField:0,   CalcLogic:"",   Format:"" },
			                 {Type:"Combo", 	Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"slan_cd",      KeyField:0,   CalcLogic:"",   Format:"",        PointCount:0,   UpdateEdit:0,   InsertEdit:1},
			                 {Type:"Text",      Hidden:0, Width:160,  Align:"Left",    ColMerge:1,   SaveName:"vsl_slan_nm",  KeyField:0,   CalcLogic:"",   Format:"",        PointCount:0,   UpdateEdit:0,   InsertEdit:1},
			                 {Type:"Text",      Hidden:1, Width:160,  Align:"Left",    ColMerge:1,   SaveName:"rout_rcv_dt",  KeyField:0,   CalcLogic:"",   Format:"",        PointCount:0,   UpdateEdit:0,   InsertEdit:1},
			                 {Type:"Text",      Hidden:1, Width:160,  Align:"Left",    ColMerge:1,   SaveName:"rout_seq",     KeyField:0,   CalcLogic:"",   Format:"",        PointCount:0,   UpdateEdit:0,   InsertEdit:1},
			                 {Type:"Text",      Hidden:1, Width:160,  Align:"Left",    ColMerge:1,   SaveName:"blck_seq",     KeyField:0,   CalcLogic:"",   Format:"",        PointCount:0,   UpdateEdit:0,   InsertEdit:1} ];
		          InitColumns(cols);
		          SetEditable(1);
		          SetSheetHeight(260);
                }
     		break;
     	}
     }
    /*
     * handling sheet process
     */
    function doActionIBSheet(sheetObj, formObj, sAction) {
    	sheetObj.ShowDebugMsg(false);
    	switch(sAction) {
    		case IBSEARCH:      //Query
    			if(validateForm(sheetObj, formObj, sAction)) {
    				formObj.f_cmd.value=SEARCHLIST01;
     				sheetObj.DoSearch("ESD_SCE_0124GS.do", SceFrmQryString(formObj) );
    			}
    			break;
    		case IBSAVE:        //save
    			var SaveStr=ComGetSaveString(sheetObj);
    			formObj.f_cmd.value=MULTI;
     			var sXml=sheetObj.GetSaveData("ESD_SCE_0124GS.do", SaveStr + "&" + SceFrmQryString(formObj));
     			sheetObj.LoadSaveData(sXml);
    			//for parent window 
    			var blockSel="";
    	        for(var i=0; i<sheetObj.RowCount(); i++) {
    	        	if(i<0) break;
    	        	blockSel += sheetObj.GetCellValue(i + 1, "slan_cd");
    	            if(i != sheetObj.RowCount()-1) {
    	            	blockSel += ",";
    	            }
    	        }
//    	        opener=window.dialogArguments;
//    			if(!opener)
//    				opener=parent;
    			var gubun=formObj.gubun.value;
    			opener.popOk(gubun, blockSel);
    			ComClosePopup(); 
	    		break;
    		case IBINSERT:      // row insert
    			var Row=sheetObj.DataInsert();
				sheetObj.SetCellValue(Row, 2," ",0);
    			sheetObj.SetCellValue(Row,  sheetObj.SaveNameCol("rout_seq"),formObj.rout_seq.value);
    			sheetObj.SetCellValue(Row,  sheetObj.SaveNameCol("rout_rcv_dt"),formObj.rout_rcv_dt.value);
    			break;
    	}
    }
    /*
     * lane chage 
     */ 
    function sheet1_OnChange(sheetObj, row, col, value) {
    	with(sheetObj){
    		switch(ColSaveName(col)) {
    			case "slan_cd":
    				var dup=0;
    	            for(var i=0; i<sheetObj.RowCount(); i++) {
    	            	if(sheetObj.GetCellValue(i + 1, "slan_cd") == value) {
    	                	dup++;
    	                }
    	                if(dup > 1){
    	                    ComShowMessage(value + " is already added");
    	                    sheetObj.SetCellValue(i + 1, "slan_cd","");
    	                    return;
    	                }
    	            }
    				var sText=sheetObj.GetComboInfo(row, col, "Text");
    				var arrText=sText.split("|");
    				var idx=sheetObj.GetComboInfo(row, col, "SelectedIndex");
    				if(idx >= 0){
	    				var vText=arrText[idx].split("\t");
	    				sheetObj.SetCellValue(row, "vsl_slan_nm",vText);
    				}
    			break;
    		}
    	}
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction) {
    	with(formObj){
//    		if (!isNumber(iPage)) {
//    			return false;
//    		}
    	}
    	return true;
    }
   function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	   //
   }
    function sheet1_OnSaveEnd(sheetObj, errMsg) {
    	
    	if(errMsg==0){
    		ComShowMessage("saved successfully.");  
    	}else{
    		ComShowMessage(errMsg);
    	}
    }
