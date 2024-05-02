/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_scg_2013_01
*@FileTitle  : Supporting Documents or Pictures
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/23
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
     * @class vop_scg_2013_01 : business script for vop_scg_2013_01
     */
    // common global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
         /***** In case of more than 2 sheets in a tab, additional sheet variables can be specified *****/
         var sheetObj=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
	            case "btn_FileAdd":  
					selectFile(sheetObj, true);
					break;
	            case "btn_Delete":
	            	setDelRow(sheetObj);
					break;					
				case "btn_OK":
					comPopupOK();
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
     * delete selected row
     */
    function setDelRow(sheetObj){
    	sheetObj.GetRowHidden(sheetObj.SetSelectRow)(1);//1.hide row
		sheetObj.SetRowStatus(sheetObj.GetSelectRow(),"D");//2.make transaction status "delete"
    }
    /**
     * select file <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} addRowFlag  sheetObj Row add
     **/
	function selectFile(sheetObj, addRowFlag){
		if(addRowFlag) sheetObj.DataInsert(-1,0);						//In case of File Add, create New Row
//no support[check again]CLT 		var fileName=sheetObj.OpenFileDialog('Please choose target file to upload.');
		if(fileName.indexOf("\\") !=-1) {
			with(sheetObj) {
				SetCellValue(GetSelectRow(), "file_sav_id",fileName,0);//set file path
				SetCellValue(GetSelectRow(), "file_set_yn","Y",0);//set whether to select local file
				fileName=fileName.substr(fileName.lastIndexOf("\\")+1);
				SetCellValue(GetSelectRow(), "file_nm",fileName,0);//set file name
 				GetCellFontUnderline(SetSelectRow, "file_nm")(0);//clear download link
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
    function loadPage(file_pop_kind) {
    	if(file_pop_kind != null && file_pop_kind == 'readOnly') 
        	document.getElementById("btnLayer").style.visibility="hidden";
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        var sheetObj=sheetObjects[0];
        var opener=window.dialogArguments;
        //If modifying file info exist in parent window, original info should be maintained.
        if(opener != undefined && opener != null) {
        	var oSheetObj=opener.getFileUpload();
        	if(oSheetObj != undefined && oSheetObj != null) {
        		if(oSheetObj.RowCount()> 0) {
        			var sXml=IBS_GetDataSearchXml(oSheetObj);
        			sheetObj.LoadSearchData(sXml,{Sync:1} );
	        		for(var rowIdx=sheetObj.HeaderRows(); rowIdx<=sheetObj.LastRow(); rowIdx++) {
	        			if(sheetObj.SetRowStatus(rowIdx) == 'D') sheetObj.GetRowHidden(rowIdx,1);
 	        			if(sheetObj.SetRowStatus(rowIdx) == 'I') sheetObj.GetCellFont("FontUnderline", rowIdx,3,0);
	        		}
        		} else {
        			//initial retrieve when loading page
        			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        		}
        	}
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
            case 1:      // sheet1 init
                with(sheetObj){
            		var HeadTitle="|Seq.||File Name||ID|Date|";
            		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

            		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            		var headers = [ { Text:HeadTitle, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
            		             {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"No" },
						         {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"file_set_yn",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						         {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:0,   SaveName:"file_nm",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						         {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"file_sav_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cre_usr_id",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						         {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cre_dt",                 KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						         {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_irr_file_seq" } ];
		           InitColumns(cols);
		           SetEditable(1);
		           SetSheetHeight(100);
              }
			break;
        }
    }
    // Sheet related process handling
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBSEARCH:      //retrieve
        		formObj.f_cmd.value=SEARCH;			
         		sheetObj.DoSearch("VOP_SCG_2013_01GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("") );
        		break;
        }
    }
    /**
     * after retrieving Sheet, event occurs
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		with(sheetObj) {
			SetColFontUnderline("file_nm",1);
			SetDataLinkMouse("file_nm",1);
		}
	}
    /**
     * Downloading file <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj selected Row
     * @param {ibsheet} Col     	sheetObj selected Col
     * @param {String} 	Value     	file name
     **/
	function sheet1_OnDblClick(sheetObj,Row,Col,Value){		
		if (sheetObj.ColSaveName(Col) != "file_nm")
			return;
		//Show file selecting window when there's no file name, newly created row, selecting new file.
		if(sheetObj.GetCellText(Row, "file_nm") == ""
|| sheetObj.GetRowStatus(Row) == "I"
|| sheetObj.GetCellValue(Row, "file_set_yn") == "Y") {
			selectFile(sheetObj, false);			
			return;
		}
		location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, "file_sav_id");
		return;
	}
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//                if (!isNumber(formObj.iPage)) {
//                    return false;
//                }
        }
        return true;
    }
